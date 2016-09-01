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
import com.bydan.erp.cartera.util.FirmaClienteConstantesFunciones;
import com.bydan.erp.cartera.util.FirmaClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.FirmaClienteParameterGeneral;
import com.bydan.erp.cartera.business.entity.FirmaCliente;
import com.bydan.erp.cartera.business.logic.FirmaClienteLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class FirmaClienteLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(FirmaClienteLogic.class);
	
	protected FirmaClienteDataAccess firmaclienteDataAccess; 	
	protected FirmaCliente firmacliente;
	protected List<FirmaCliente> firmaclientes;
	protected Object firmaclienteObject;	
	protected List<Object> firmaclientesObject;
	
	public static ClassValidator<FirmaCliente> firmaclienteValidator = new ClassValidator<FirmaCliente>(FirmaCliente.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected FirmaClienteLogicAdditional firmaclienteLogicAdditional=null;
	
	public FirmaClienteLogicAdditional getFirmaClienteLogicAdditional() {
		return this.firmaclienteLogicAdditional;
	}
	
	public void setFirmaClienteLogicAdditional(FirmaClienteLogicAdditional firmaclienteLogicAdditional) {
		try {
			this.firmaclienteLogicAdditional=firmaclienteLogicAdditional;
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
	
	
	
	
	public  FirmaClienteLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.firmaclienteDataAccess = new FirmaClienteDataAccess();
			
			this.firmaclientes= new ArrayList<FirmaCliente>();
			this.firmacliente= new FirmaCliente();
			
			this.firmaclienteObject=new Object();
			this.firmaclientesObject=new ArrayList<Object>();
				
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
			
			this.firmaclienteDataAccess.setConnexionType(this.connexionType);
			this.firmaclienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  FirmaClienteLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.firmaclienteDataAccess = new FirmaClienteDataAccess();
			this.firmaclientes= new ArrayList<FirmaCliente>();
			this.firmacliente= new FirmaCliente();
			this.firmaclienteObject=new Object();
			this.firmaclientesObject=new ArrayList<Object>();
			
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
			
			this.firmaclienteDataAccess.setConnexionType(this.connexionType);
			this.firmaclienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public FirmaCliente getFirmaCliente() throws Exception {	
		FirmaClienteLogicAdditional.checkFirmaClienteToGet(firmacliente,this.datosCliente,this.arrDatoGeneral);
		FirmaClienteLogicAdditional.updateFirmaClienteToGet(firmacliente,this.arrDatoGeneral);
		
		return firmacliente;
	}
		
	public void setFirmaCliente(FirmaCliente newFirmaCliente) {
		this.firmacliente = newFirmaCliente;
	}
	
	public FirmaClienteDataAccess getFirmaClienteDataAccess() {
		return firmaclienteDataAccess;
	}
	
	public void setFirmaClienteDataAccess(FirmaClienteDataAccess newfirmaclienteDataAccess) {
		this.firmaclienteDataAccess = newfirmaclienteDataAccess;
	}
	
	public List<FirmaCliente> getFirmaClientes() throws Exception {		
		this.quitarFirmaClientesNulos();
		
		FirmaClienteLogicAdditional.checkFirmaClienteToGets(firmaclientes,this.datosCliente,this.arrDatoGeneral);
		
		for (FirmaCliente firmaclienteLocal: firmaclientes ) {
			FirmaClienteLogicAdditional.updateFirmaClienteToGet(firmaclienteLocal,this.arrDatoGeneral);
		}
		
		return firmaclientes;
	}
	
	public void setFirmaClientes(List<FirmaCliente> newFirmaClientes) {
		this.firmaclientes = newFirmaClientes;
	}
	
	public Object getFirmaClienteObject() {	
		this.firmaclienteObject=this.firmaclienteDataAccess.getEntityObject();
		return this.firmaclienteObject;
	}
		
	public void setFirmaClienteObject(Object newFirmaClienteObject) {
		this.firmaclienteObject = newFirmaClienteObject;
	}
	
	public List<Object> getFirmaClientesObject() {		
		this.firmaclientesObject=this.firmaclienteDataAccess.getEntitiesObject();
		return this.firmaclientesObject;
	}
		
	public void setFirmaClientesObject(List<Object> newFirmaClientesObject) {
		this.firmaclientesObject = newFirmaClientesObject;
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
		
		if(this.firmaclienteDataAccess!=null) {
			this.firmaclienteDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FirmaCliente.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			firmaclienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			firmaclienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		firmacliente = new  FirmaCliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FirmaCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			firmacliente=firmaclienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.firmacliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FirmaClienteConstantesFunciones.refrescarForeignKeysDescripcionesFirmaCliente(this.firmacliente);
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
		firmacliente = new  FirmaCliente();
		  		  
        try {
			
			firmacliente=firmaclienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.firmacliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FirmaClienteConstantesFunciones.refrescarForeignKeysDescripcionesFirmaCliente(this.firmacliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		firmacliente = new  FirmaCliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FirmaCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			firmacliente=firmaclienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.firmacliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FirmaClienteConstantesFunciones.refrescarForeignKeysDescripcionesFirmaCliente(this.firmacliente);
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
		firmacliente = new  FirmaCliente();
		  		  
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
		firmacliente = new  FirmaCliente();
		  		  
        try {
			
			firmacliente=firmaclienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.firmacliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FirmaClienteConstantesFunciones.refrescarForeignKeysDescripcionesFirmaCliente(this.firmacliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		firmacliente = new  FirmaCliente();
		  		  
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
		firmacliente = new  FirmaCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FirmaCliente.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =firmaclienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		firmacliente = new  FirmaCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=firmaclienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		firmacliente = new  FirmaCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FirmaCliente.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =firmaclienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		firmacliente = new  FirmaCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=firmaclienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		firmacliente = new  FirmaCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FirmaCliente.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =firmaclienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		firmacliente = new  FirmaCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=firmaclienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		firmaclientes = new  ArrayList<FirmaCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FirmaCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			FirmaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			firmaclientes=firmaclienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFirmaCliente(firmaclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FirmaClienteConstantesFunciones.refrescarForeignKeysDescripcionesFirmaCliente(this.firmaclientes);
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
		firmaclientes = new  ArrayList<FirmaCliente>();
		  		  
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
		firmaclientes = new  ArrayList<FirmaCliente>();
		  		  
        try {			
			FirmaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			firmaclientes=firmaclienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarFirmaCliente(firmaclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FirmaClienteConstantesFunciones.refrescarForeignKeysDescripcionesFirmaCliente(this.firmaclientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		firmaclientes = new  ArrayList<FirmaCliente>();
		  		  
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
		firmaclientes = new  ArrayList<FirmaCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FirmaCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			FirmaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			firmaclientes=firmaclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFirmaCliente(firmaclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FirmaClienteConstantesFunciones.refrescarForeignKeysDescripcionesFirmaCliente(this.firmaclientes);
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
		firmaclientes = new  ArrayList<FirmaCliente>();
		  		  
        try {
			FirmaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			firmaclientes=firmaclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFirmaCliente(firmaclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FirmaClienteConstantesFunciones.refrescarForeignKeysDescripcionesFirmaCliente(this.firmaclientes);
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
		firmaclientes = new  ArrayList<FirmaCliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FirmaCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FirmaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			firmaclientes=firmaclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFirmaCliente(firmaclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FirmaClienteConstantesFunciones.refrescarForeignKeysDescripcionesFirmaCliente(this.firmaclientes);
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
		firmaclientes = new  ArrayList<FirmaCliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FirmaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			firmaclientes=firmaclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFirmaCliente(firmaclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FirmaClienteConstantesFunciones.refrescarForeignKeysDescripcionesFirmaCliente(this.firmaclientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		firmacliente = new  FirmaCliente();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FirmaCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FirmaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			firmacliente=firmaclienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFirmaCliente(firmacliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FirmaClienteConstantesFunciones.refrescarForeignKeysDescripcionesFirmaCliente(this.firmacliente);
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
		firmacliente = new  FirmaCliente();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FirmaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			firmacliente=firmaclienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFirmaCliente(firmacliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FirmaClienteConstantesFunciones.refrescarForeignKeysDescripcionesFirmaCliente(this.firmacliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		firmaclientes = new  ArrayList<FirmaCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FirmaCliente.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			FirmaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			firmaclientes=firmaclienteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFirmaCliente(firmaclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FirmaClienteConstantesFunciones.refrescarForeignKeysDescripcionesFirmaCliente(this.firmaclientes);
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
		firmaclientes = new  ArrayList<FirmaCliente>();
		  		  
        try {
			FirmaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			firmaclientes=firmaclienteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFirmaCliente(firmaclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FirmaClienteConstantesFunciones.refrescarForeignKeysDescripcionesFirmaCliente(this.firmaclientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosFirmaClientesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		firmaclientes = new  ArrayList<FirmaCliente>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FirmaCliente.class.getSimpleName()+"-getTodosFirmaClientesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FirmaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			firmaclientes=firmaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFirmaCliente(firmaclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FirmaClienteConstantesFunciones.refrescarForeignKeysDescripcionesFirmaCliente(this.firmaclientes);
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
	
	public  void  getTodosFirmaClientes(String sFinalQuery,Pagination pagination)throws Exception {
		firmaclientes = new  ArrayList<FirmaCliente>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FirmaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			firmaclientes=firmaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFirmaCliente(firmaclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FirmaClienteConstantesFunciones.refrescarForeignKeysDescripcionesFirmaCliente(this.firmaclientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarFirmaCliente(FirmaCliente firmacliente) throws Exception {
		Boolean estaValidado=false;
		
		if(firmacliente.getIsNew() || firmacliente.getIsChanged()) { 
			this.invalidValues = firmaclienteValidator.getInvalidValues(firmacliente);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(firmacliente);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarFirmaCliente(List<FirmaCliente> FirmaClientes) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(FirmaCliente firmaclienteLocal:firmaclientes) {				
			estaValidadoObjeto=this.validarGuardarFirmaCliente(firmaclienteLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarFirmaCliente(List<FirmaCliente> FirmaClientes) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFirmaCliente(firmaclientes)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarFirmaCliente(FirmaCliente FirmaCliente) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFirmaCliente(firmacliente)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(FirmaCliente firmacliente) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+firmacliente.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=FirmaClienteConstantesFunciones.getFirmaClienteLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"firmacliente","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(FirmaClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(FirmaClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveFirmaClienteWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FirmaCliente.class.getSimpleName()+"-saveFirmaClienteWithConnection");connexion.begin();			
			
			FirmaClienteLogicAdditional.checkFirmaClienteToSave(this.firmacliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FirmaClienteLogicAdditional.updateFirmaClienteToSave(this.firmacliente,this.arrDatoGeneral);
			
			FirmaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.firmacliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowFirmaCliente();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFirmaCliente(this.firmacliente)) {
				FirmaClienteDataAccess.save(this.firmacliente, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.firmacliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FirmaClienteLogicAdditional.checkFirmaClienteToSaveAfter(this.firmacliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFirmaCliente();
			
			connexion.commit();			
			
			if(this.firmacliente.getIsDeleted()) {
				this.firmacliente=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveFirmaCliente()throws Exception {	
		try {	
			
			FirmaClienteLogicAdditional.checkFirmaClienteToSave(this.firmacliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FirmaClienteLogicAdditional.updateFirmaClienteToSave(this.firmacliente,this.arrDatoGeneral);
			
			FirmaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.firmacliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFirmaCliente(this.firmacliente)) {			
				FirmaClienteDataAccess.save(this.firmacliente, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.firmacliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FirmaClienteLogicAdditional.checkFirmaClienteToSaveAfter(this.firmacliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.firmacliente.getIsDeleted()) {
				this.firmacliente=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveFirmaClientesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FirmaCliente.class.getSimpleName()+"-saveFirmaClientesWithConnection");connexion.begin();			
			
			FirmaClienteLogicAdditional.checkFirmaClienteToSaves(firmaclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowFirmaClientes();
			
			Boolean validadoTodosFirmaCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(FirmaCliente firmaclienteLocal:firmaclientes) {		
				if(firmaclienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FirmaClienteLogicAdditional.updateFirmaClienteToSave(firmaclienteLocal,this.arrDatoGeneral);
	        	
				FirmaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),firmaclienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFirmaCliente(firmaclienteLocal)) {
					FirmaClienteDataAccess.save(firmaclienteLocal, connexion);				
				} else {
					validadoTodosFirmaCliente=false;
				}
			}
			
			if(!validadoTodosFirmaCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FirmaClienteLogicAdditional.checkFirmaClienteToSavesAfter(firmaclientes,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFirmaClientes();
			
			connexion.commit();		
			
			this.quitarFirmaClientesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveFirmaClientes()throws Exception {				
		 try {	
			FirmaClienteLogicAdditional.checkFirmaClienteToSaves(firmaclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosFirmaCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(FirmaCliente firmaclienteLocal:firmaclientes) {				
				if(firmaclienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FirmaClienteLogicAdditional.updateFirmaClienteToSave(firmaclienteLocal,this.arrDatoGeneral);
	        	
				FirmaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),firmaclienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFirmaCliente(firmaclienteLocal)) {				
					FirmaClienteDataAccess.save(firmaclienteLocal, connexion);				
				} else {
					validadoTodosFirmaCliente=false;
				}
			}
			
			if(!validadoTodosFirmaCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FirmaClienteLogicAdditional.checkFirmaClienteToSavesAfter(firmaclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarFirmaClientesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FirmaClienteParameterReturnGeneral procesarAccionFirmaClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FirmaCliente> firmaclientes,FirmaClienteParameterReturnGeneral firmaclienteParameterGeneral)throws Exception {
		 try {	
			FirmaClienteParameterReturnGeneral firmaclienteReturnGeneral=new FirmaClienteParameterReturnGeneral();
	
			FirmaClienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,firmaclientes,firmaclienteParameterGeneral,firmaclienteReturnGeneral);
			
			return firmaclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FirmaClienteParameterReturnGeneral procesarAccionFirmaClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FirmaCliente> firmaclientes,FirmaClienteParameterReturnGeneral firmaclienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FirmaCliente.class.getSimpleName()+"-procesarAccionFirmaClientesWithConnection");connexion.begin();			
			
			FirmaClienteParameterReturnGeneral firmaclienteReturnGeneral=new FirmaClienteParameterReturnGeneral();
	
			FirmaClienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,firmaclientes,firmaclienteParameterGeneral,firmaclienteReturnGeneral);
			
			this.connexion.commit();
			
			return firmaclienteReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FirmaClienteParameterReturnGeneral procesarEventosFirmaClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<FirmaCliente> firmaclientes,FirmaCliente firmacliente,FirmaClienteParameterReturnGeneral firmaclienteParameterGeneral,Boolean isEsNuevoFirmaCliente,ArrayList<Classe> clases)throws Exception {
		 try {	
			FirmaClienteParameterReturnGeneral firmaclienteReturnGeneral=new FirmaClienteParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				firmaclienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FirmaClienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,firmaclientes,firmacliente,firmaclienteParameterGeneral,firmaclienteReturnGeneral,isEsNuevoFirmaCliente,clases);
			
			return firmaclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public FirmaClienteParameterReturnGeneral procesarEventosFirmaClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<FirmaCliente> firmaclientes,FirmaCliente firmacliente,FirmaClienteParameterReturnGeneral firmaclienteParameterGeneral,Boolean isEsNuevoFirmaCliente,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FirmaCliente.class.getSimpleName()+"-procesarEventosFirmaClientesWithConnection");connexion.begin();			
			
			FirmaClienteParameterReturnGeneral firmaclienteReturnGeneral=new FirmaClienteParameterReturnGeneral();
	
			firmaclienteReturnGeneral.setFirmaCliente(firmacliente);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				firmaclienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FirmaClienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,firmaclientes,firmacliente,firmaclienteParameterGeneral,firmaclienteReturnGeneral,isEsNuevoFirmaCliente,clases);
			
			this.connexion.commit();
			
			return firmaclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FirmaClienteParameterReturnGeneral procesarImportacionFirmaClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,FirmaClienteParameterReturnGeneral firmaclienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FirmaCliente.class.getSimpleName()+"-procesarImportacionFirmaClientesWithConnection");connexion.begin();			
			
			FirmaClienteParameterReturnGeneral firmaclienteReturnGeneral=new FirmaClienteParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.firmaclientes=new ArrayList<FirmaCliente>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.firmacliente=new FirmaCliente();
				
				
				if(conColumnasBase) {this.firmacliente.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.firmacliente.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.firmacliente.setpath_firma(arrColumnas[iColumn++]);
				
				this.firmaclientes.add(this.firmacliente);
			}
			
			this.saveFirmaClientes();
			
			this.connexion.commit();
			
			firmaclienteReturnGeneral.setConRetornoEstaProcesado(true);
			firmaclienteReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return firmaclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarFirmaClientesEliminados() throws Exception {				
		
		List<FirmaCliente> firmaclientesAux= new ArrayList<FirmaCliente>();
		
		for(FirmaCliente firmacliente:firmaclientes) {
			if(!firmacliente.getIsDeleted()) {
				firmaclientesAux.add(firmacliente);
			}
		}
		
		firmaclientes=firmaclientesAux;
	}
	
	public void quitarFirmaClientesNulos() throws Exception {				
		
		List<FirmaCliente> firmaclientesAux= new ArrayList<FirmaCliente>();
		
		for(FirmaCliente firmacliente : this.firmaclientes) {
			if(firmacliente==null) {
				firmaclientesAux.add(firmacliente);
			}
		}
		
		//this.firmaclientes=firmaclientesAux;
		
		this.firmaclientes.removeAll(firmaclientesAux);
	}
	
	public void getSetVersionRowFirmaClienteWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(firmacliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((firmacliente.getIsDeleted() || (firmacliente.getIsChanged()&&!firmacliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=firmaclienteDataAccess.getSetVersionRowFirmaCliente(connexion,firmacliente.getId());
				
				if(!firmacliente.getVersionRow().equals(timestamp)) {	
					firmacliente.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				firmacliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowFirmaCliente()throws Exception {	
		
		if(firmacliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((firmacliente.getIsDeleted() || (firmacliente.getIsChanged()&&!firmacliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=firmaclienteDataAccess.getSetVersionRowFirmaCliente(connexion,firmacliente.getId());
			
			try {							
				if(!firmacliente.getVersionRow().equals(timestamp)) {	
					firmacliente.setVersionRow(timestamp);
				}
				
				firmacliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowFirmaClientesWithConnection()throws Exception {	
		if(firmaclientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(FirmaCliente firmaclienteAux:firmaclientes) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(firmaclienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(firmaclienteAux.getIsDeleted() || (firmaclienteAux.getIsChanged()&&!firmaclienteAux.getIsNew())) {
						
						timestamp=firmaclienteDataAccess.getSetVersionRowFirmaCliente(connexion,firmaclienteAux.getId());
						
						if(!firmacliente.getVersionRow().equals(timestamp)) {	
							firmaclienteAux.setVersionRow(timestamp);
						}
								
						firmaclienteAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowFirmaClientes()throws Exception {	
		if(firmaclientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(FirmaCliente firmaclienteAux:firmaclientes) {
					if(firmaclienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(firmaclienteAux.getIsDeleted() || (firmaclienteAux.getIsChanged()&&!firmaclienteAux.getIsNew())) {
						
						timestamp=firmaclienteDataAccess.getSetVersionRowFirmaCliente(connexion,firmaclienteAux.getId());
						
						if(!firmaclienteAux.getVersionRow().equals(timestamp)) {	
							firmaclienteAux.setVersionRow(timestamp);
						}
						
													
						firmaclienteAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public FirmaClienteParameterReturnGeneral cargarCombosLoteForeignKeyFirmaClienteWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalCliente,String finalQueryGlobalTipoImagen) throws Exception {
		FirmaClienteParameterReturnGeneral  firmaclienteReturnGeneral =new FirmaClienteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FirmaCliente.class.getSimpleName()+"-cargarCombosLoteForeignKeyFirmaClienteWithConnection");connexion.begin();
			
			firmaclienteReturnGeneral =new FirmaClienteParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			firmaclienteReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			firmaclienteReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoImagen> tipoimagensForeignKey=new ArrayList<TipoImagen>();
			TipoImagenLogic tipoimagenLogic=new TipoImagenLogic();
			tipoimagenLogic.setConnexion(this.connexion);
			tipoimagenLogic.getTipoImagenDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoImagen.equals("NONE")) {
				tipoimagenLogic.getTodosTipoImagens(finalQueryGlobalTipoImagen,new Pagination());
				tipoimagensForeignKey=tipoimagenLogic.getTipoImagens();
			}

			firmaclienteReturnGeneral.settipoimagensForeignKey(tipoimagensForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return firmaclienteReturnGeneral;
	}
	
	public FirmaClienteParameterReturnGeneral cargarCombosLoteForeignKeyFirmaCliente(String finalQueryGlobalEmpresa,String finalQueryGlobalCliente,String finalQueryGlobalTipoImagen) throws Exception {
		FirmaClienteParameterReturnGeneral  firmaclienteReturnGeneral =new FirmaClienteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			firmaclienteReturnGeneral =new FirmaClienteParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			firmaclienteReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			firmaclienteReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoImagen> tipoimagensForeignKey=new ArrayList<TipoImagen>();
			TipoImagenLogic tipoimagenLogic=new TipoImagenLogic();
			tipoimagenLogic.setConnexion(this.connexion);
			tipoimagenLogic.getTipoImagenDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoImagen.equals("NONE")) {
				tipoimagenLogic.getTodosTipoImagens(finalQueryGlobalTipoImagen,new Pagination());
				tipoimagensForeignKey=tipoimagenLogic.getTipoImagens();
			}

			firmaclienteReturnGeneral.settipoimagensForeignKey(tipoimagensForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return firmaclienteReturnGeneral;
	}
	
	
	public void deepLoad(FirmaCliente firmacliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			FirmaClienteLogicAdditional.updateFirmaClienteToGet(firmacliente,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		firmacliente.setEmpresa(firmaclienteDataAccess.getEmpresa(connexion,firmacliente));
		firmacliente.setCliente(firmaclienteDataAccess.getCliente(connexion,firmacliente));
		firmacliente.setTipoImagen(firmaclienteDataAccess.getTipoImagen(connexion,firmacliente));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				firmacliente.setEmpresa(firmaclienteDataAccess.getEmpresa(connexion,firmacliente));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				firmacliente.setCliente(firmaclienteDataAccess.getCliente(connexion,firmacliente));
				continue;
			}

			if(clas.clas.equals(TipoImagen.class)) {
				firmacliente.setTipoImagen(firmaclienteDataAccess.getTipoImagen(connexion,firmacliente));
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
			firmacliente.setEmpresa(firmaclienteDataAccess.getEmpresa(connexion,firmacliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			firmacliente.setCliente(firmaclienteDataAccess.getCliente(connexion,firmacliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoImagen.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			firmacliente.setTipoImagen(firmaclienteDataAccess.getTipoImagen(connexion,firmacliente));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		firmacliente.setEmpresa(firmaclienteDataAccess.getEmpresa(connexion,firmacliente));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(firmacliente.getEmpresa(),isDeep,deepLoadType,clases);
				
		firmacliente.setCliente(firmaclienteDataAccess.getCliente(connexion,firmacliente));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(firmacliente.getCliente(),isDeep,deepLoadType,clases);
				
		firmacliente.setTipoImagen(firmaclienteDataAccess.getTipoImagen(connexion,firmacliente));
		TipoImagenLogic tipoimagenLogic= new TipoImagenLogic(connexion);
		tipoimagenLogic.deepLoad(firmacliente.getTipoImagen(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				firmacliente.setEmpresa(firmaclienteDataAccess.getEmpresa(connexion,firmacliente));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(firmacliente.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				firmacliente.setCliente(firmaclienteDataAccess.getCliente(connexion,firmacliente));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(firmacliente.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoImagen.class)) {
				firmacliente.setTipoImagen(firmaclienteDataAccess.getTipoImagen(connexion,firmacliente));
				TipoImagenLogic tipoimagenLogic= new TipoImagenLogic(connexion);
				tipoimagenLogic.deepLoad(firmacliente.getTipoImagen(),isDeep,deepLoadType,clases);				
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
			firmacliente.setEmpresa(firmaclienteDataAccess.getEmpresa(connexion,firmacliente));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(firmacliente.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			firmacliente.setCliente(firmaclienteDataAccess.getCliente(connexion,firmacliente));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(firmacliente.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoImagen.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			firmacliente.setTipoImagen(firmaclienteDataAccess.getTipoImagen(connexion,firmacliente));
			TipoImagenLogic tipoimagenLogic= new TipoImagenLogic(connexion);
			tipoimagenLogic.deepLoad(firmacliente.getTipoImagen(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(FirmaCliente firmacliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			FirmaClienteLogicAdditional.updateFirmaClienteToSave(firmacliente,this.arrDatoGeneral);
			
FirmaClienteDataAccess.save(firmacliente, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(firmacliente.getEmpresa(),connexion);

		ClienteDataAccess.save(firmacliente.getCliente(),connexion);

		TipoImagenDataAccess.save(firmacliente.getTipoImagen(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(firmacliente.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(firmacliente.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoImagen.class)) {
				TipoImagenDataAccess.save(firmacliente.getTipoImagen(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(firmacliente.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(firmacliente.getEmpresa(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(firmacliente.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(firmacliente.getCliente(),isDeep,deepLoadType,clases);
				

		TipoImagenDataAccess.save(firmacliente.getTipoImagen(),connexion);
		TipoImagenLogic tipoimagenLogic= new TipoImagenLogic(connexion);
		tipoimagenLogic.deepLoad(firmacliente.getTipoImagen(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(firmacliente.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(firmacliente.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(firmacliente.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(firmacliente.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoImagen.class)) {
				TipoImagenDataAccess.save(firmacliente.getTipoImagen(),connexion);
				TipoImagenLogic tipoimagenLogic= new TipoImagenLogic(connexion);
				tipoimagenLogic.deepSave(firmacliente.getTipoImagen(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(FirmaCliente.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(firmacliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FirmaClienteConstantesFunciones.refrescarForeignKeysDescripcionesFirmaCliente(firmacliente);
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
			this.deepLoad(this.firmacliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FirmaClienteConstantesFunciones.refrescarForeignKeysDescripcionesFirmaCliente(this.firmacliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(FirmaCliente.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(firmaclientes!=null) {
				for(FirmaCliente firmacliente:firmaclientes) {
					this.deepLoad(firmacliente,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					FirmaClienteConstantesFunciones.refrescarForeignKeysDescripcionesFirmaCliente(firmaclientes);
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
			if(firmaclientes!=null) {
				for(FirmaCliente firmacliente:firmaclientes) {
					this.deepLoad(firmacliente,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					FirmaClienteConstantesFunciones.refrescarForeignKeysDescripcionesFirmaCliente(firmaclientes);
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
			this.getNewConnexionToDeep(FirmaCliente.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(firmacliente,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(FirmaCliente.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(firmaclientes!=null) {
				for(FirmaCliente firmacliente:firmaclientes) {
					this.deepSave(firmacliente,isDeep,deepLoadType,clases);
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
			if(firmaclientes!=null) {
				for(FirmaCliente firmacliente:firmaclientes) {
					this.deepSave(firmacliente,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getFirmaClientesFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FirmaCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,FirmaClienteConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			FirmaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			firmaclientes=firmaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FirmaClienteConstantesFunciones.refrescarForeignKeysDescripcionesFirmaCliente(this.firmaclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFirmaClientesFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,FirmaClienteConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			FirmaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			firmaclientes=firmaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FirmaClienteConstantesFunciones.refrescarForeignKeysDescripcionesFirmaCliente(this.firmaclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFirmaClientesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FirmaCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FirmaClienteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FirmaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			firmaclientes=firmaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FirmaClienteConstantesFunciones.refrescarForeignKeysDescripcionesFirmaCliente(this.firmaclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFirmaClientesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FirmaClienteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FirmaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			firmaclientes=firmaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FirmaClienteConstantesFunciones.refrescarForeignKeysDescripcionesFirmaCliente(this.firmaclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFirmaClientesFK_IdTipoImagenWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_imagen)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FirmaCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoImagen= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoImagen.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_imagen,FirmaClienteConstantesFunciones.IDTIPOIMAGEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoImagen);

			FirmaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoImagen","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			firmaclientes=firmaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FirmaClienteConstantesFunciones.refrescarForeignKeysDescripcionesFirmaCliente(this.firmaclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFirmaClientesFK_IdTipoImagen(String sFinalQuery,Pagination pagination,Long id_tipo_imagen)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoImagen= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoImagen.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_imagen,FirmaClienteConstantesFunciones.IDTIPOIMAGEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoImagen);

			FirmaClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoImagen","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			firmaclientes=firmaclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FirmaClienteConstantesFunciones.refrescarForeignKeysDescripcionesFirmaCliente(this.firmaclientes);
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
			if(FirmaClienteConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,FirmaClienteDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,FirmaCliente firmacliente,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(FirmaClienteConstantesFunciones.ISCONAUDITORIA) {
				if(firmacliente.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FirmaClienteDataAccess.TABLENAME, firmacliente.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FirmaClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FirmaClienteLogic.registrarAuditoriaDetallesFirmaCliente(connexion,firmacliente,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(firmacliente.getIsDeleted()) {
					/*if(!firmacliente.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,FirmaClienteDataAccess.TABLENAME, firmacliente.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////FirmaClienteLogic.registrarAuditoriaDetallesFirmaCliente(connexion,firmacliente,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FirmaClienteDataAccess.TABLENAME, firmacliente.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(firmacliente.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FirmaClienteDataAccess.TABLENAME, firmacliente.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FirmaClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FirmaClienteLogic.registrarAuditoriaDetallesFirmaCliente(connexion,firmacliente,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesFirmaCliente(Connexion connexion,FirmaCliente firmacliente)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(firmacliente.getIsNew()||!firmacliente.getid_empresa().equals(firmacliente.getFirmaClienteOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(firmacliente.getFirmaClienteOriginal().getid_empresa()!=null)
				{
					strValorActual=firmacliente.getFirmaClienteOriginal().getid_empresa().toString();
				}
				if(firmacliente.getid_empresa()!=null)
				{
					strValorNuevo=firmacliente.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FirmaClienteConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(firmacliente.getIsNew()||!firmacliente.getid_cliente().equals(firmacliente.getFirmaClienteOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(firmacliente.getFirmaClienteOriginal().getid_cliente()!=null)
				{
					strValorActual=firmacliente.getFirmaClienteOriginal().getid_cliente().toString();
				}
				if(firmacliente.getid_cliente()!=null)
				{
					strValorNuevo=firmacliente.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FirmaClienteConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(firmacliente.getIsNew()||!firmacliente.getid_tipo_imagen().equals(firmacliente.getFirmaClienteOriginal().getid_tipo_imagen()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(firmacliente.getFirmaClienteOriginal().getid_tipo_imagen()!=null)
				{
					strValorActual=firmacliente.getFirmaClienteOriginal().getid_tipo_imagen().toString();
				}
				if(firmacliente.getid_tipo_imagen()!=null)
				{
					strValorNuevo=firmacliente.getid_tipo_imagen().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FirmaClienteConstantesFunciones.IDTIPOIMAGEN,strValorActual,strValorNuevo);
			}	
			
			if(firmacliente.getIsNew()||!firmacliente.getfirma().equals(firmacliente.getFirmaClienteOriginal().getfirma()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(firmacliente.getFirmaClienteOriginal().getfirma()!=null)
				{
					strValorActual=firmacliente.getFirmaClienteOriginal().getfirma().toString();
				}
				if(firmacliente.getfirma()!=null)
				{
					strValorNuevo=firmacliente.getfirma().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FirmaClienteConstantesFunciones.FIRMA,strValorActual,strValorNuevo);
			}	
			
			if(firmacliente.getIsNew()||!firmacliente.getpath_firma().equals(firmacliente.getFirmaClienteOriginal().getpath_firma()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(firmacliente.getFirmaClienteOriginal().getpath_firma()!=null)
				{
					strValorActual=firmacliente.getFirmaClienteOriginal().getpath_firma();
				}
				if(firmacliente.getpath_firma()!=null)
				{
					strValorNuevo=firmacliente.getpath_firma() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FirmaClienteConstantesFunciones.PATHFIRMA,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveFirmaClienteRelacionesWithConnection(FirmaCliente firmacliente) throws Exception {

		if(!firmacliente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFirmaClienteRelacionesBase(firmacliente,true);
		}
	}

	public void saveFirmaClienteRelaciones(FirmaCliente firmacliente)throws Exception {

		if(!firmacliente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFirmaClienteRelacionesBase(firmacliente,false);
		}
	}

	public void saveFirmaClienteRelacionesBase(FirmaCliente firmacliente,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("FirmaCliente-saveRelacionesWithConnection");}
	

			this.setFirmaCliente(firmacliente);

			if(FirmaClienteLogicAdditional.validarSaveRelaciones(firmacliente,this)) {

				FirmaClienteLogicAdditional.updateRelacionesToSave(firmacliente,this);

				if((firmacliente.getIsNew()||firmacliente.getIsChanged())&&!firmacliente.getIsDeleted()) {
					this.saveFirmaCliente();
					this.saveFirmaClienteRelacionesDetalles();

				} else if(firmacliente.getIsDeleted()) {
					this.saveFirmaClienteRelacionesDetalles();
					this.saveFirmaCliente();
				}

				FirmaClienteLogicAdditional.updateRelacionesToSaveAfter(firmacliente,this);

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
	
	
	private void saveFirmaClienteRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfFirmaCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FirmaClienteConstantesFunciones.getClassesForeignKeysOfFirmaCliente(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFirmaCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FirmaClienteConstantesFunciones.getClassesRelationshipsOfFirmaCliente(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

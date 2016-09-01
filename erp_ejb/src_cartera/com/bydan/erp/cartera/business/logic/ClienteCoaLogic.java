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
import com.bydan.erp.cartera.util.ClienteCoaConstantesFunciones;
import com.bydan.erp.cartera.util.ClienteCoaParameterReturnGeneral;
//import com.bydan.erp.cartera.util.ClienteCoaParameterGeneral;
import com.bydan.erp.cartera.business.entity.ClienteCoa;
import com.bydan.erp.cartera.business.logic.ClienteCoaLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class ClienteCoaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ClienteCoaLogic.class);
	
	protected ClienteCoaDataAccess clientecoaDataAccess; 	
	protected ClienteCoa clientecoa;
	protected List<ClienteCoa> clientecoas;
	protected Object clientecoaObject;	
	protected List<Object> clientecoasObject;
	
	public static ClassValidator<ClienteCoa> clientecoaValidator = new ClassValidator<ClienteCoa>(ClienteCoa.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ClienteCoaLogicAdditional clientecoaLogicAdditional=null;
	
	public ClienteCoaLogicAdditional getClienteCoaLogicAdditional() {
		return this.clientecoaLogicAdditional;
	}
	
	public void setClienteCoaLogicAdditional(ClienteCoaLogicAdditional clientecoaLogicAdditional) {
		try {
			this.clientecoaLogicAdditional=clientecoaLogicAdditional;
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
	
	
	
	
	public  ClienteCoaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.clientecoaDataAccess = new ClienteCoaDataAccess();
			
			this.clientecoas= new ArrayList<ClienteCoa>();
			this.clientecoa= new ClienteCoa();
			
			this.clientecoaObject=new Object();
			this.clientecoasObject=new ArrayList<Object>();
				
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
			
			this.clientecoaDataAccess.setConnexionType(this.connexionType);
			this.clientecoaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ClienteCoaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.clientecoaDataAccess = new ClienteCoaDataAccess();
			this.clientecoas= new ArrayList<ClienteCoa>();
			this.clientecoa= new ClienteCoa();
			this.clientecoaObject=new Object();
			this.clientecoasObject=new ArrayList<Object>();
			
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
			
			this.clientecoaDataAccess.setConnexionType(this.connexionType);
			this.clientecoaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ClienteCoa getClienteCoa() throws Exception {	
		ClienteCoaLogicAdditional.checkClienteCoaToGet(clientecoa,this.datosCliente,this.arrDatoGeneral);
		ClienteCoaLogicAdditional.updateClienteCoaToGet(clientecoa,this.arrDatoGeneral);
		
		return clientecoa;
	}
		
	public void setClienteCoa(ClienteCoa newClienteCoa) {
		this.clientecoa = newClienteCoa;
	}
	
	public ClienteCoaDataAccess getClienteCoaDataAccess() {
		return clientecoaDataAccess;
	}
	
	public void setClienteCoaDataAccess(ClienteCoaDataAccess newclientecoaDataAccess) {
		this.clientecoaDataAccess = newclientecoaDataAccess;
	}
	
	public List<ClienteCoa> getClienteCoas() throws Exception {		
		this.quitarClienteCoasNulos();
		
		ClienteCoaLogicAdditional.checkClienteCoaToGets(clientecoas,this.datosCliente,this.arrDatoGeneral);
		
		for (ClienteCoa clientecoaLocal: clientecoas ) {
			ClienteCoaLogicAdditional.updateClienteCoaToGet(clientecoaLocal,this.arrDatoGeneral);
		}
		
		return clientecoas;
	}
	
	public void setClienteCoas(List<ClienteCoa> newClienteCoas) {
		this.clientecoas = newClienteCoas;
	}
	
	public Object getClienteCoaObject() {	
		this.clientecoaObject=this.clientecoaDataAccess.getEntityObject();
		return this.clientecoaObject;
	}
		
	public void setClienteCoaObject(Object newClienteCoaObject) {
		this.clientecoaObject = newClienteCoaObject;
	}
	
	public List<Object> getClienteCoasObject() {		
		this.clientecoasObject=this.clientecoaDataAccess.getEntitiesObject();
		return this.clientecoasObject;
	}
		
	public void setClienteCoasObject(List<Object> newClienteCoasObject) {
		this.clientecoasObject = newClienteCoasObject;
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
		
		if(this.clientecoaDataAccess!=null) {
			this.clientecoaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteCoa.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			clientecoaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			clientecoaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		clientecoa = new  ClienteCoa();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteCoa.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			clientecoa=clientecoaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.clientecoa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ClienteCoaConstantesFunciones.refrescarForeignKeysDescripcionesClienteCoa(this.clientecoa);
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
		clientecoa = new  ClienteCoa();
		  		  
        try {
			
			clientecoa=clientecoaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.clientecoa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ClienteCoaConstantesFunciones.refrescarForeignKeysDescripcionesClienteCoa(this.clientecoa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		clientecoa = new  ClienteCoa();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteCoa.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			clientecoa=clientecoaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.clientecoa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ClienteCoaConstantesFunciones.refrescarForeignKeysDescripcionesClienteCoa(this.clientecoa);
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
		clientecoa = new  ClienteCoa();
		  		  
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
		clientecoa = new  ClienteCoa();
		  		  
        try {
			
			clientecoa=clientecoaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.clientecoa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ClienteCoaConstantesFunciones.refrescarForeignKeysDescripcionesClienteCoa(this.clientecoa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		clientecoa = new  ClienteCoa();
		  		  
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
		clientecoa = new  ClienteCoa();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteCoa.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =clientecoaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		clientecoa = new  ClienteCoa();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=clientecoaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		clientecoa = new  ClienteCoa();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteCoa.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =clientecoaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		clientecoa = new  ClienteCoa();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=clientecoaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		clientecoa = new  ClienteCoa();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteCoa.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =clientecoaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		clientecoa = new  ClienteCoa();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=clientecoaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		clientecoas = new  ArrayList<ClienteCoa>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteCoa.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ClienteCoaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clientecoas=clientecoaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarClienteCoa(clientecoas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteCoaConstantesFunciones.refrescarForeignKeysDescripcionesClienteCoa(this.clientecoas);
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
		clientecoas = new  ArrayList<ClienteCoa>();
		  		  
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
		clientecoas = new  ArrayList<ClienteCoa>();
		  		  
        try {			
			ClienteCoaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clientecoas=clientecoaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarClienteCoa(clientecoas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteCoaConstantesFunciones.refrescarForeignKeysDescripcionesClienteCoa(this.clientecoas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		clientecoas = new  ArrayList<ClienteCoa>();
		  		  
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
		clientecoas = new  ArrayList<ClienteCoa>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteCoa.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ClienteCoaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clientecoas=clientecoaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarClienteCoa(clientecoas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteCoaConstantesFunciones.refrescarForeignKeysDescripcionesClienteCoa(this.clientecoas);
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
		clientecoas = new  ArrayList<ClienteCoa>();
		  		  
        try {
			ClienteCoaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clientecoas=clientecoaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarClienteCoa(clientecoas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteCoaConstantesFunciones.refrescarForeignKeysDescripcionesClienteCoa(this.clientecoas);
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
		clientecoas = new  ArrayList<ClienteCoa>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteCoa.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ClienteCoaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clientecoas=clientecoaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarClienteCoa(clientecoas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteCoaConstantesFunciones.refrescarForeignKeysDescripcionesClienteCoa(this.clientecoas);
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
		clientecoas = new  ArrayList<ClienteCoa>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ClienteCoaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clientecoas=clientecoaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarClienteCoa(clientecoas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteCoaConstantesFunciones.refrescarForeignKeysDescripcionesClienteCoa(this.clientecoas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		clientecoa = new  ClienteCoa();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteCoa.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ClienteCoaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clientecoa=clientecoaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarClienteCoa(clientecoa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteCoaConstantesFunciones.refrescarForeignKeysDescripcionesClienteCoa(this.clientecoa);
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
		clientecoa = new  ClienteCoa();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ClienteCoaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clientecoa=clientecoaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarClienteCoa(clientecoa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteCoaConstantesFunciones.refrescarForeignKeysDescripcionesClienteCoa(this.clientecoa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		clientecoas = new  ArrayList<ClienteCoa>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteCoa.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ClienteCoaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clientecoas=clientecoaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarClienteCoa(clientecoas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteCoaConstantesFunciones.refrescarForeignKeysDescripcionesClienteCoa(this.clientecoas);
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
		clientecoas = new  ArrayList<ClienteCoa>();
		  		  
        try {
			ClienteCoaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clientecoas=clientecoaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarClienteCoa(clientecoas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteCoaConstantesFunciones.refrescarForeignKeysDescripcionesClienteCoa(this.clientecoas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosClienteCoasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		clientecoas = new  ArrayList<ClienteCoa>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteCoa.class.getSimpleName()+"-getTodosClienteCoasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ClienteCoaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clientecoas=clientecoaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarClienteCoa(clientecoas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteCoaConstantesFunciones.refrescarForeignKeysDescripcionesClienteCoa(this.clientecoas);
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
	
	public  void  getTodosClienteCoas(String sFinalQuery,Pagination pagination)throws Exception {
		clientecoas = new  ArrayList<ClienteCoa>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ClienteCoaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clientecoas=clientecoaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarClienteCoa(clientecoas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteCoaConstantesFunciones.refrescarForeignKeysDescripcionesClienteCoa(this.clientecoas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarClienteCoa(ClienteCoa clientecoa) throws Exception {
		Boolean estaValidado=false;
		
		if(clientecoa.getIsNew() || clientecoa.getIsChanged()) { 
			this.invalidValues = clientecoaValidator.getInvalidValues(clientecoa);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(clientecoa);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarClienteCoa(List<ClienteCoa> ClienteCoas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ClienteCoa clientecoaLocal:clientecoas) {				
			estaValidadoObjeto=this.validarGuardarClienteCoa(clientecoaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarClienteCoa(List<ClienteCoa> ClienteCoas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarClienteCoa(clientecoas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarClienteCoa(ClienteCoa ClienteCoa) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarClienteCoa(clientecoa)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ClienteCoa clientecoa) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+clientecoa.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ClienteCoaConstantesFunciones.getClienteCoaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"clientecoa","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ClienteCoaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ClienteCoaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveClienteCoaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteCoa.class.getSimpleName()+"-saveClienteCoaWithConnection");connexion.begin();			
			
			ClienteCoaLogicAdditional.checkClienteCoaToSave(this.clientecoa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ClienteCoaLogicAdditional.updateClienteCoaToSave(this.clientecoa,this.arrDatoGeneral);
			
			ClienteCoaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.clientecoa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowClienteCoa();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarClienteCoa(this.clientecoa)) {
				ClienteCoaDataAccess.save(this.clientecoa, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.clientecoa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ClienteCoaLogicAdditional.checkClienteCoaToSaveAfter(this.clientecoa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowClienteCoa();
			
			connexion.commit();			
			
			if(this.clientecoa.getIsDeleted()) {
				this.clientecoa=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveClienteCoa()throws Exception {	
		try {	
			
			ClienteCoaLogicAdditional.checkClienteCoaToSave(this.clientecoa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ClienteCoaLogicAdditional.updateClienteCoaToSave(this.clientecoa,this.arrDatoGeneral);
			
			ClienteCoaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.clientecoa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarClienteCoa(this.clientecoa)) {			
				ClienteCoaDataAccess.save(this.clientecoa, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.clientecoa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ClienteCoaLogicAdditional.checkClienteCoaToSaveAfter(this.clientecoa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.clientecoa.getIsDeleted()) {
				this.clientecoa=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveClienteCoasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteCoa.class.getSimpleName()+"-saveClienteCoasWithConnection");connexion.begin();			
			
			ClienteCoaLogicAdditional.checkClienteCoaToSaves(clientecoas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowClienteCoas();
			
			Boolean validadoTodosClienteCoa=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ClienteCoa clientecoaLocal:clientecoas) {		
				if(clientecoaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ClienteCoaLogicAdditional.updateClienteCoaToSave(clientecoaLocal,this.arrDatoGeneral);
	        	
				ClienteCoaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),clientecoaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarClienteCoa(clientecoaLocal)) {
					ClienteCoaDataAccess.save(clientecoaLocal, connexion);				
				} else {
					validadoTodosClienteCoa=false;
				}
			}
			
			if(!validadoTodosClienteCoa) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ClienteCoaLogicAdditional.checkClienteCoaToSavesAfter(clientecoas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowClienteCoas();
			
			connexion.commit();		
			
			this.quitarClienteCoasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveClienteCoas()throws Exception {				
		 try {	
			ClienteCoaLogicAdditional.checkClienteCoaToSaves(clientecoas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosClienteCoa=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ClienteCoa clientecoaLocal:clientecoas) {				
				if(clientecoaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ClienteCoaLogicAdditional.updateClienteCoaToSave(clientecoaLocal,this.arrDatoGeneral);
	        	
				ClienteCoaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),clientecoaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarClienteCoa(clientecoaLocal)) {				
					ClienteCoaDataAccess.save(clientecoaLocal, connexion);				
				} else {
					validadoTodosClienteCoa=false;
				}
			}
			
			if(!validadoTodosClienteCoa) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ClienteCoaLogicAdditional.checkClienteCoaToSavesAfter(clientecoas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarClienteCoasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ClienteCoaParameterReturnGeneral procesarAccionClienteCoas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ClienteCoa> clientecoas,ClienteCoaParameterReturnGeneral clientecoaParameterGeneral)throws Exception {
		 try {	
			ClienteCoaParameterReturnGeneral clientecoaReturnGeneral=new ClienteCoaParameterReturnGeneral();
	
			ClienteCoaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,clientecoas,clientecoaParameterGeneral,clientecoaReturnGeneral);
			
			return clientecoaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ClienteCoaParameterReturnGeneral procesarAccionClienteCoasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ClienteCoa> clientecoas,ClienteCoaParameterReturnGeneral clientecoaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteCoa.class.getSimpleName()+"-procesarAccionClienteCoasWithConnection");connexion.begin();			
			
			ClienteCoaParameterReturnGeneral clientecoaReturnGeneral=new ClienteCoaParameterReturnGeneral();
	
			ClienteCoaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,clientecoas,clientecoaParameterGeneral,clientecoaReturnGeneral);
			
			this.connexion.commit();
			
			return clientecoaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ClienteCoaParameterReturnGeneral procesarEventosClienteCoas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ClienteCoa> clientecoas,ClienteCoa clientecoa,ClienteCoaParameterReturnGeneral clientecoaParameterGeneral,Boolean isEsNuevoClienteCoa,ArrayList<Classe> clases)throws Exception {
		 try {	
			ClienteCoaParameterReturnGeneral clientecoaReturnGeneral=new ClienteCoaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				clientecoaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ClienteCoaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,clientecoas,clientecoa,clientecoaParameterGeneral,clientecoaReturnGeneral,isEsNuevoClienteCoa,clases);
			
			return clientecoaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ClienteCoaParameterReturnGeneral procesarEventosClienteCoasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ClienteCoa> clientecoas,ClienteCoa clientecoa,ClienteCoaParameterReturnGeneral clientecoaParameterGeneral,Boolean isEsNuevoClienteCoa,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteCoa.class.getSimpleName()+"-procesarEventosClienteCoasWithConnection");connexion.begin();			
			
			ClienteCoaParameterReturnGeneral clientecoaReturnGeneral=new ClienteCoaParameterReturnGeneral();
	
			clientecoaReturnGeneral.setClienteCoa(clientecoa);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				clientecoaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ClienteCoaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,clientecoas,clientecoa,clientecoaParameterGeneral,clientecoaReturnGeneral,isEsNuevoClienteCoa,clases);
			
			this.connexion.commit();
			
			return clientecoaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ClienteCoaParameterReturnGeneral procesarImportacionClienteCoasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ClienteCoaParameterReturnGeneral clientecoaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteCoa.class.getSimpleName()+"-procesarImportacionClienteCoasWithConnection");connexion.begin();			
			
			ClienteCoaParameterReturnGeneral clientecoaReturnGeneral=new ClienteCoaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.clientecoas=new ArrayList<ClienteCoa>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.clientecoa=new ClienteCoa();
				
				
				if(conColumnasBase) {this.clientecoa.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.clientecoa.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.clientecoa.setautori_imprenta(arrColumnas[iColumn++]);
				this.clientecoa.setautori_usuario(arrColumnas[iColumn++]);
				this.clientecoa.setnum_factura_ini(arrColumnas[iColumn++]);
				this.clientecoa.setnum_factura_fin(arrColumnas[iColumn++]);
				this.clientecoa.setserie_docu(arrColumnas[iColumn++]);
				this.clientecoa.setfecha_vali(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				
				this.clientecoas.add(this.clientecoa);
			}
			
			this.saveClienteCoas();
			
			this.connexion.commit();
			
			clientecoaReturnGeneral.setConRetornoEstaProcesado(true);
			clientecoaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return clientecoaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarClienteCoasEliminados() throws Exception {				
		
		List<ClienteCoa> clientecoasAux= new ArrayList<ClienteCoa>();
		
		for(ClienteCoa clientecoa:clientecoas) {
			if(!clientecoa.getIsDeleted()) {
				clientecoasAux.add(clientecoa);
			}
		}
		
		clientecoas=clientecoasAux;
	}
	
	public void quitarClienteCoasNulos() throws Exception {				
		
		List<ClienteCoa> clientecoasAux= new ArrayList<ClienteCoa>();
		
		for(ClienteCoa clientecoa : this.clientecoas) {
			if(clientecoa==null) {
				clientecoasAux.add(clientecoa);
			}
		}
		
		//this.clientecoas=clientecoasAux;
		
		this.clientecoas.removeAll(clientecoasAux);
	}
	
	public void getSetVersionRowClienteCoaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(clientecoa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((clientecoa.getIsDeleted() || (clientecoa.getIsChanged()&&!clientecoa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=clientecoaDataAccess.getSetVersionRowClienteCoa(connexion,clientecoa.getId());
				
				if(!clientecoa.getVersionRow().equals(timestamp)) {	
					clientecoa.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				clientecoa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowClienteCoa()throws Exception {	
		
		if(clientecoa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((clientecoa.getIsDeleted() || (clientecoa.getIsChanged()&&!clientecoa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=clientecoaDataAccess.getSetVersionRowClienteCoa(connexion,clientecoa.getId());
			
			try {							
				if(!clientecoa.getVersionRow().equals(timestamp)) {	
					clientecoa.setVersionRow(timestamp);
				}
				
				clientecoa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowClienteCoasWithConnection()throws Exception {	
		if(clientecoas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ClienteCoa clientecoaAux:clientecoas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(clientecoaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(clientecoaAux.getIsDeleted() || (clientecoaAux.getIsChanged()&&!clientecoaAux.getIsNew())) {
						
						timestamp=clientecoaDataAccess.getSetVersionRowClienteCoa(connexion,clientecoaAux.getId());
						
						if(!clientecoa.getVersionRow().equals(timestamp)) {	
							clientecoaAux.setVersionRow(timestamp);
						}
								
						clientecoaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowClienteCoas()throws Exception {	
		if(clientecoas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ClienteCoa clientecoaAux:clientecoas) {
					if(clientecoaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(clientecoaAux.getIsDeleted() || (clientecoaAux.getIsChanged()&&!clientecoaAux.getIsNew())) {
						
						timestamp=clientecoaDataAccess.getSetVersionRowClienteCoa(connexion,clientecoaAux.getId());
						
						if(!clientecoaAux.getVersionRow().equals(timestamp)) {	
							clientecoaAux.setVersionRow(timestamp);
						}
						
													
						clientecoaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ClienteCoaParameterReturnGeneral cargarCombosLoteForeignKeyClienteCoaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalCliente,String finalQueryGlobalUsuario) throws Exception {
		ClienteCoaParameterReturnGeneral  clientecoaReturnGeneral =new ClienteCoaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteCoa.class.getSimpleName()+"-cargarCombosLoteForeignKeyClienteCoaWithConnection");connexion.begin();
			
			clientecoaReturnGeneral =new ClienteCoaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			clientecoaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			clientecoaReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			clientecoaReturnGeneral.setusuariosForeignKey(usuariosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return clientecoaReturnGeneral;
	}
	
	public ClienteCoaParameterReturnGeneral cargarCombosLoteForeignKeyClienteCoa(String finalQueryGlobalEmpresa,String finalQueryGlobalCliente,String finalQueryGlobalUsuario) throws Exception {
		ClienteCoaParameterReturnGeneral  clientecoaReturnGeneral =new ClienteCoaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			clientecoaReturnGeneral =new ClienteCoaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			clientecoaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			clientecoaReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			clientecoaReturnGeneral.setusuariosForeignKey(usuariosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return clientecoaReturnGeneral;
	}
	
	
	public void deepLoad(ClienteCoa clientecoa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ClienteCoaLogicAdditional.updateClienteCoaToGet(clientecoa,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		clientecoa.setEmpresa(clientecoaDataAccess.getEmpresa(connexion,clientecoa));
		clientecoa.setCliente(clientecoaDataAccess.getCliente(connexion,clientecoa));
		clientecoa.setUsuario(clientecoaDataAccess.getUsuario(connexion,clientecoa));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				clientecoa.setEmpresa(clientecoaDataAccess.getEmpresa(connexion,clientecoa));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				clientecoa.setCliente(clientecoaDataAccess.getCliente(connexion,clientecoa));
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				clientecoa.setUsuario(clientecoaDataAccess.getUsuario(connexion,clientecoa));
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
			clientecoa.setEmpresa(clientecoaDataAccess.getEmpresa(connexion,clientecoa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			clientecoa.setCliente(clientecoaDataAccess.getCliente(connexion,clientecoa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			clientecoa.setUsuario(clientecoaDataAccess.getUsuario(connexion,clientecoa));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		clientecoa.setEmpresa(clientecoaDataAccess.getEmpresa(connexion,clientecoa));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(clientecoa.getEmpresa(),isDeep,deepLoadType,clases);
				
		clientecoa.setCliente(clientecoaDataAccess.getCliente(connexion,clientecoa));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(clientecoa.getCliente(),isDeep,deepLoadType,clases);
				
		clientecoa.setUsuario(clientecoaDataAccess.getUsuario(connexion,clientecoa));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(clientecoa.getUsuario(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				clientecoa.setEmpresa(clientecoaDataAccess.getEmpresa(connexion,clientecoa));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(clientecoa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				clientecoa.setCliente(clientecoaDataAccess.getCliente(connexion,clientecoa));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(clientecoa.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				clientecoa.setUsuario(clientecoaDataAccess.getUsuario(connexion,clientecoa));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(clientecoa.getUsuario(),isDeep,deepLoadType,clases);				
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
			clientecoa.setEmpresa(clientecoaDataAccess.getEmpresa(connexion,clientecoa));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(clientecoa.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			clientecoa.setCliente(clientecoaDataAccess.getCliente(connexion,clientecoa));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(clientecoa.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			clientecoa.setUsuario(clientecoaDataAccess.getUsuario(connexion,clientecoa));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(clientecoa.getUsuario(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ClienteCoa clientecoa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ClienteCoaLogicAdditional.updateClienteCoaToSave(clientecoa,this.arrDatoGeneral);
			
ClienteCoaDataAccess.save(clientecoa, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(clientecoa.getEmpresa(),connexion);

		ClienteDataAccess.save(clientecoa.getCliente(),connexion);

		UsuarioDataAccess.save(clientecoa.getUsuario(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(clientecoa.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(clientecoa.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(clientecoa.getUsuario(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(clientecoa.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(clientecoa.getEmpresa(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(clientecoa.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(clientecoa.getCliente(),isDeep,deepLoadType,clases);
				

		UsuarioDataAccess.save(clientecoa.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(clientecoa.getUsuario(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(clientecoa.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(clientecoa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(clientecoa.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(clientecoa.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(clientecoa.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(clientecoa.getUsuario(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ClienteCoa.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(clientecoa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ClienteCoaConstantesFunciones.refrescarForeignKeysDescripcionesClienteCoa(clientecoa);
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
			this.deepLoad(this.clientecoa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ClienteCoaConstantesFunciones.refrescarForeignKeysDescripcionesClienteCoa(this.clientecoa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ClienteCoa.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(clientecoas!=null) {
				for(ClienteCoa clientecoa:clientecoas) {
					this.deepLoad(clientecoa,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ClienteCoaConstantesFunciones.refrescarForeignKeysDescripcionesClienteCoa(clientecoas);
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
			if(clientecoas!=null) {
				for(ClienteCoa clientecoa:clientecoas) {
					this.deepLoad(clientecoa,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ClienteCoaConstantesFunciones.refrescarForeignKeysDescripcionesClienteCoa(clientecoas);
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
			this.getNewConnexionToDeep(ClienteCoa.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(clientecoa,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ClienteCoa.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(clientecoas!=null) {
				for(ClienteCoa clientecoa:clientecoas) {
					this.deepSave(clientecoa,isDeep,deepLoadType,clases);
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
			if(clientecoas!=null) {
				for(ClienteCoa clientecoa:clientecoas) {
					this.deepSave(clientecoa,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getClienteCoasFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteCoa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,ClienteCoaConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			ClienteCoaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientecoas=clientecoaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteCoaConstantesFunciones.refrescarForeignKeysDescripcionesClienteCoa(this.clientecoas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClienteCoasFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,ClienteCoaConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			ClienteCoaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientecoas=clientecoaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteCoaConstantesFunciones.refrescarForeignKeysDescripcionesClienteCoa(this.clientecoas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClienteCoasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteCoa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ClienteCoaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ClienteCoaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientecoas=clientecoaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteCoaConstantesFunciones.refrescarForeignKeysDescripcionesClienteCoa(this.clientecoas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClienteCoasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ClienteCoaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ClienteCoaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientecoas=clientecoaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteCoaConstantesFunciones.refrescarForeignKeysDescripcionesClienteCoa(this.clientecoas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClienteCoasFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteCoa.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,ClienteCoaConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			ClienteCoaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientecoas=clientecoaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteCoaConstantesFunciones.refrescarForeignKeysDescripcionesClienteCoa(this.clientecoas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClienteCoasFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,ClienteCoaConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			ClienteCoaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientecoas=clientecoaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteCoaConstantesFunciones.refrescarForeignKeysDescripcionesClienteCoa(this.clientecoas);
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
			if(ClienteCoaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ClienteCoaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ClienteCoa clientecoa,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ClienteCoaConstantesFunciones.ISCONAUDITORIA) {
				if(clientecoa.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ClienteCoaDataAccess.TABLENAME, clientecoa.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ClienteCoaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ClienteCoaLogic.registrarAuditoriaDetallesClienteCoa(connexion,clientecoa,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(clientecoa.getIsDeleted()) {
					/*if(!clientecoa.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ClienteCoaDataAccess.TABLENAME, clientecoa.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ClienteCoaLogic.registrarAuditoriaDetallesClienteCoa(connexion,clientecoa,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ClienteCoaDataAccess.TABLENAME, clientecoa.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(clientecoa.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ClienteCoaDataAccess.TABLENAME, clientecoa.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ClienteCoaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ClienteCoaLogic.registrarAuditoriaDetallesClienteCoa(connexion,clientecoa,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesClienteCoa(Connexion connexion,ClienteCoa clientecoa)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(clientecoa.getIsNew()||!clientecoa.getid_empresa().equals(clientecoa.getClienteCoaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clientecoa.getClienteCoaOriginal().getid_empresa()!=null)
				{
					strValorActual=clientecoa.getClienteCoaOriginal().getid_empresa().toString();
				}
				if(clientecoa.getid_empresa()!=null)
				{
					strValorNuevo=clientecoa.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteCoaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(clientecoa.getIsNew()||!clientecoa.getid_cliente().equals(clientecoa.getClienteCoaOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clientecoa.getClienteCoaOriginal().getid_cliente()!=null)
				{
					strValorActual=clientecoa.getClienteCoaOriginal().getid_cliente().toString();
				}
				if(clientecoa.getid_cliente()!=null)
				{
					strValorNuevo=clientecoa.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteCoaConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(clientecoa.getIsNew()||!clientecoa.getid_usuario().equals(clientecoa.getClienteCoaOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clientecoa.getClienteCoaOriginal().getid_usuario()!=null)
				{
					strValorActual=clientecoa.getClienteCoaOriginal().getid_usuario().toString();
				}
				if(clientecoa.getid_usuario()!=null)
				{
					strValorNuevo=clientecoa.getid_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteCoaConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(clientecoa.getIsNew()||!clientecoa.getautori_imprenta().equals(clientecoa.getClienteCoaOriginal().getautori_imprenta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clientecoa.getClienteCoaOriginal().getautori_imprenta()!=null)
				{
					strValorActual=clientecoa.getClienteCoaOriginal().getautori_imprenta();
				}
				if(clientecoa.getautori_imprenta()!=null)
				{
					strValorNuevo=clientecoa.getautori_imprenta() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteCoaConstantesFunciones.AUTORIIMPRENTA,strValorActual,strValorNuevo);
			}	
			
			if(clientecoa.getIsNew()||!clientecoa.getautori_usuario().equals(clientecoa.getClienteCoaOriginal().getautori_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clientecoa.getClienteCoaOriginal().getautori_usuario()!=null)
				{
					strValorActual=clientecoa.getClienteCoaOriginal().getautori_usuario();
				}
				if(clientecoa.getautori_usuario()!=null)
				{
					strValorNuevo=clientecoa.getautori_usuario() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteCoaConstantesFunciones.AUTORIUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(clientecoa.getIsNew()||!clientecoa.getnum_factura_ini().equals(clientecoa.getClienteCoaOriginal().getnum_factura_ini()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clientecoa.getClienteCoaOriginal().getnum_factura_ini()!=null)
				{
					strValorActual=clientecoa.getClienteCoaOriginal().getnum_factura_ini();
				}
				if(clientecoa.getnum_factura_ini()!=null)
				{
					strValorNuevo=clientecoa.getnum_factura_ini() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteCoaConstantesFunciones.NUMFACTURAINI,strValorActual,strValorNuevo);
			}	
			
			if(clientecoa.getIsNew()||!clientecoa.getnum_factura_fin().equals(clientecoa.getClienteCoaOriginal().getnum_factura_fin()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clientecoa.getClienteCoaOriginal().getnum_factura_fin()!=null)
				{
					strValorActual=clientecoa.getClienteCoaOriginal().getnum_factura_fin();
				}
				if(clientecoa.getnum_factura_fin()!=null)
				{
					strValorNuevo=clientecoa.getnum_factura_fin() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteCoaConstantesFunciones.NUMFACTURAFIN,strValorActual,strValorNuevo);
			}	
			
			if(clientecoa.getIsNew()||!clientecoa.getserie_docu().equals(clientecoa.getClienteCoaOriginal().getserie_docu()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clientecoa.getClienteCoaOriginal().getserie_docu()!=null)
				{
					strValorActual=clientecoa.getClienteCoaOriginal().getserie_docu();
				}
				if(clientecoa.getserie_docu()!=null)
				{
					strValorNuevo=clientecoa.getserie_docu() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteCoaConstantesFunciones.SERIEDOCU,strValorActual,strValorNuevo);
			}	
			
			if(clientecoa.getIsNew()||!clientecoa.getfecha_vali().equals(clientecoa.getClienteCoaOriginal().getfecha_vali()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clientecoa.getClienteCoaOriginal().getfecha_vali()!=null)
				{
					strValorActual=clientecoa.getClienteCoaOriginal().getfecha_vali().toString();
				}
				if(clientecoa.getfecha_vali()!=null)
				{
					strValorNuevo=clientecoa.getfecha_vali().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteCoaConstantesFunciones.FECHAVALI,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveClienteCoaRelacionesWithConnection(ClienteCoa clientecoa) throws Exception {

		if(!clientecoa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveClienteCoaRelacionesBase(clientecoa,true);
		}
	}

	public void saveClienteCoaRelaciones(ClienteCoa clientecoa)throws Exception {

		if(!clientecoa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveClienteCoaRelacionesBase(clientecoa,false);
		}
	}

	public void saveClienteCoaRelacionesBase(ClienteCoa clientecoa,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ClienteCoa-saveRelacionesWithConnection");}
	

			this.setClienteCoa(clientecoa);

			if(ClienteCoaLogicAdditional.validarSaveRelaciones(clientecoa,this)) {

				ClienteCoaLogicAdditional.updateRelacionesToSave(clientecoa,this);

				if((clientecoa.getIsNew()||clientecoa.getIsChanged())&&!clientecoa.getIsDeleted()) {
					this.saveClienteCoa();
					this.saveClienteCoaRelacionesDetalles();

				} else if(clientecoa.getIsDeleted()) {
					this.saveClienteCoaRelacionesDetalles();
					this.saveClienteCoa();
				}

				ClienteCoaLogicAdditional.updateRelacionesToSaveAfter(clientecoa,this);

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
	
	
	private void saveClienteCoaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfClienteCoa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ClienteCoaConstantesFunciones.getClassesForeignKeysOfClienteCoa(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfClienteCoa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ClienteCoaConstantesFunciones.getClassesRelationshipsOfClienteCoa(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

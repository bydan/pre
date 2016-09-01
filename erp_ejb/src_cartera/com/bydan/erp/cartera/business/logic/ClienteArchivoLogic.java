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
import com.bydan.erp.cartera.util.ClienteArchivoConstantesFunciones;
import com.bydan.erp.cartera.util.ClienteArchivoParameterReturnGeneral;
//import com.bydan.erp.cartera.util.ClienteArchivoParameterGeneral;
import com.bydan.erp.cartera.business.entity.ClienteArchivo;
import com.bydan.erp.cartera.business.logic.ClienteArchivoLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class ClienteArchivoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ClienteArchivoLogic.class);
	
	protected ClienteArchivoDataAccess clientearchivoDataAccess; 	
	protected ClienteArchivo clientearchivo;
	protected List<ClienteArchivo> clientearchivos;
	protected Object clientearchivoObject;	
	protected List<Object> clientearchivosObject;
	
	public static ClassValidator<ClienteArchivo> clientearchivoValidator = new ClassValidator<ClienteArchivo>(ClienteArchivo.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ClienteArchivoLogicAdditional clientearchivoLogicAdditional=null;
	
	public ClienteArchivoLogicAdditional getClienteArchivoLogicAdditional() {
		return this.clientearchivoLogicAdditional;
	}
	
	public void setClienteArchivoLogicAdditional(ClienteArchivoLogicAdditional clientearchivoLogicAdditional) {
		try {
			this.clientearchivoLogicAdditional=clientearchivoLogicAdditional;
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
	
	
	
	
	public  ClienteArchivoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.clientearchivoDataAccess = new ClienteArchivoDataAccess();
			
			this.clientearchivos= new ArrayList<ClienteArchivo>();
			this.clientearchivo= new ClienteArchivo();
			
			this.clientearchivoObject=new Object();
			this.clientearchivosObject=new ArrayList<Object>();
				
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
			
			this.clientearchivoDataAccess.setConnexionType(this.connexionType);
			this.clientearchivoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ClienteArchivoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.clientearchivoDataAccess = new ClienteArchivoDataAccess();
			this.clientearchivos= new ArrayList<ClienteArchivo>();
			this.clientearchivo= new ClienteArchivo();
			this.clientearchivoObject=new Object();
			this.clientearchivosObject=new ArrayList<Object>();
			
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
			
			this.clientearchivoDataAccess.setConnexionType(this.connexionType);
			this.clientearchivoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ClienteArchivo getClienteArchivo() throws Exception {	
		ClienteArchivoLogicAdditional.checkClienteArchivoToGet(clientearchivo,this.datosCliente,this.arrDatoGeneral);
		ClienteArchivoLogicAdditional.updateClienteArchivoToGet(clientearchivo,this.arrDatoGeneral);
		
		return clientearchivo;
	}
		
	public void setClienteArchivo(ClienteArchivo newClienteArchivo) {
		this.clientearchivo = newClienteArchivo;
	}
	
	public ClienteArchivoDataAccess getClienteArchivoDataAccess() {
		return clientearchivoDataAccess;
	}
	
	public void setClienteArchivoDataAccess(ClienteArchivoDataAccess newclientearchivoDataAccess) {
		this.clientearchivoDataAccess = newclientearchivoDataAccess;
	}
	
	public List<ClienteArchivo> getClienteArchivos() throws Exception {		
		this.quitarClienteArchivosNulos();
		
		ClienteArchivoLogicAdditional.checkClienteArchivoToGets(clientearchivos,this.datosCliente,this.arrDatoGeneral);
		
		for (ClienteArchivo clientearchivoLocal: clientearchivos ) {
			ClienteArchivoLogicAdditional.updateClienteArchivoToGet(clientearchivoLocal,this.arrDatoGeneral);
		}
		
		return clientearchivos;
	}
	
	public void setClienteArchivos(List<ClienteArchivo> newClienteArchivos) {
		this.clientearchivos = newClienteArchivos;
	}
	
	public Object getClienteArchivoObject() {	
		this.clientearchivoObject=this.clientearchivoDataAccess.getEntityObject();
		return this.clientearchivoObject;
	}
		
	public void setClienteArchivoObject(Object newClienteArchivoObject) {
		this.clientearchivoObject = newClienteArchivoObject;
	}
	
	public List<Object> getClienteArchivosObject() {		
		this.clientearchivosObject=this.clientearchivoDataAccess.getEntitiesObject();
		return this.clientearchivosObject;
	}
		
	public void setClienteArchivosObject(List<Object> newClienteArchivosObject) {
		this.clientearchivosObject = newClienteArchivosObject;
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
		
		if(this.clientearchivoDataAccess!=null) {
			this.clientearchivoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteArchivo.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			clientearchivoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			clientearchivoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		clientearchivo = new  ClienteArchivo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteArchivo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			clientearchivo=clientearchivoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.clientearchivo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ClienteArchivoConstantesFunciones.refrescarForeignKeysDescripcionesClienteArchivo(this.clientearchivo);
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
		clientearchivo = new  ClienteArchivo();
		  		  
        try {
			
			clientearchivo=clientearchivoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.clientearchivo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ClienteArchivoConstantesFunciones.refrescarForeignKeysDescripcionesClienteArchivo(this.clientearchivo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		clientearchivo = new  ClienteArchivo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteArchivo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			clientearchivo=clientearchivoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.clientearchivo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ClienteArchivoConstantesFunciones.refrescarForeignKeysDescripcionesClienteArchivo(this.clientearchivo);
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
		clientearchivo = new  ClienteArchivo();
		  		  
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
		clientearchivo = new  ClienteArchivo();
		  		  
        try {
			
			clientearchivo=clientearchivoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.clientearchivo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ClienteArchivoConstantesFunciones.refrescarForeignKeysDescripcionesClienteArchivo(this.clientearchivo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		clientearchivo = new  ClienteArchivo();
		  		  
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
		clientearchivo = new  ClienteArchivo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteArchivo.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =clientearchivoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		clientearchivo = new  ClienteArchivo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=clientearchivoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		clientearchivo = new  ClienteArchivo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteArchivo.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =clientearchivoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		clientearchivo = new  ClienteArchivo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=clientearchivoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		clientearchivo = new  ClienteArchivo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteArchivo.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =clientearchivoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		clientearchivo = new  ClienteArchivo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=clientearchivoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		clientearchivos = new  ArrayList<ClienteArchivo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteArchivo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ClienteArchivoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clientearchivos=clientearchivoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarClienteArchivo(clientearchivos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteArchivoConstantesFunciones.refrescarForeignKeysDescripcionesClienteArchivo(this.clientearchivos);
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
		clientearchivos = new  ArrayList<ClienteArchivo>();
		  		  
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
		clientearchivos = new  ArrayList<ClienteArchivo>();
		  		  
        try {			
			ClienteArchivoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clientearchivos=clientearchivoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarClienteArchivo(clientearchivos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteArchivoConstantesFunciones.refrescarForeignKeysDescripcionesClienteArchivo(this.clientearchivos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		clientearchivos = new  ArrayList<ClienteArchivo>();
		  		  
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
		clientearchivos = new  ArrayList<ClienteArchivo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteArchivo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ClienteArchivoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clientearchivos=clientearchivoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarClienteArchivo(clientearchivos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteArchivoConstantesFunciones.refrescarForeignKeysDescripcionesClienteArchivo(this.clientearchivos);
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
		clientearchivos = new  ArrayList<ClienteArchivo>();
		  		  
        try {
			ClienteArchivoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clientearchivos=clientearchivoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarClienteArchivo(clientearchivos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteArchivoConstantesFunciones.refrescarForeignKeysDescripcionesClienteArchivo(this.clientearchivos);
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
		clientearchivos = new  ArrayList<ClienteArchivo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteArchivo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ClienteArchivoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clientearchivos=clientearchivoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarClienteArchivo(clientearchivos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteArchivoConstantesFunciones.refrescarForeignKeysDescripcionesClienteArchivo(this.clientearchivos);
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
		clientearchivos = new  ArrayList<ClienteArchivo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ClienteArchivoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clientearchivos=clientearchivoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarClienteArchivo(clientearchivos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteArchivoConstantesFunciones.refrescarForeignKeysDescripcionesClienteArchivo(this.clientearchivos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		clientearchivo = new  ClienteArchivo();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteArchivo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ClienteArchivoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clientearchivo=clientearchivoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarClienteArchivo(clientearchivo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteArchivoConstantesFunciones.refrescarForeignKeysDescripcionesClienteArchivo(this.clientearchivo);
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
		clientearchivo = new  ClienteArchivo();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ClienteArchivoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clientearchivo=clientearchivoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarClienteArchivo(clientearchivo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteArchivoConstantesFunciones.refrescarForeignKeysDescripcionesClienteArchivo(this.clientearchivo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		clientearchivos = new  ArrayList<ClienteArchivo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteArchivo.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ClienteArchivoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clientearchivos=clientearchivoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarClienteArchivo(clientearchivos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteArchivoConstantesFunciones.refrescarForeignKeysDescripcionesClienteArchivo(this.clientearchivos);
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
		clientearchivos = new  ArrayList<ClienteArchivo>();
		  		  
        try {
			ClienteArchivoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clientearchivos=clientearchivoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarClienteArchivo(clientearchivos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteArchivoConstantesFunciones.refrescarForeignKeysDescripcionesClienteArchivo(this.clientearchivos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosClienteArchivosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		clientearchivos = new  ArrayList<ClienteArchivo>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteArchivo.class.getSimpleName()+"-getTodosClienteArchivosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ClienteArchivoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clientearchivos=clientearchivoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarClienteArchivo(clientearchivos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteArchivoConstantesFunciones.refrescarForeignKeysDescripcionesClienteArchivo(this.clientearchivos);
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
	
	public  void  getTodosClienteArchivos(String sFinalQuery,Pagination pagination)throws Exception {
		clientearchivos = new  ArrayList<ClienteArchivo>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ClienteArchivoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clientearchivos=clientearchivoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarClienteArchivo(clientearchivos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteArchivoConstantesFunciones.refrescarForeignKeysDescripcionesClienteArchivo(this.clientearchivos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarClienteArchivo(ClienteArchivo clientearchivo) throws Exception {
		Boolean estaValidado=false;
		
		if(clientearchivo.getIsNew() || clientearchivo.getIsChanged()) { 
			this.invalidValues = clientearchivoValidator.getInvalidValues(clientearchivo);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(clientearchivo);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarClienteArchivo(List<ClienteArchivo> ClienteArchivos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ClienteArchivo clientearchivoLocal:clientearchivos) {				
			estaValidadoObjeto=this.validarGuardarClienteArchivo(clientearchivoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarClienteArchivo(List<ClienteArchivo> ClienteArchivos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarClienteArchivo(clientearchivos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarClienteArchivo(ClienteArchivo ClienteArchivo) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarClienteArchivo(clientearchivo)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ClienteArchivo clientearchivo) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+clientearchivo.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ClienteArchivoConstantesFunciones.getClienteArchivoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"clientearchivo","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ClienteArchivoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ClienteArchivoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveClienteArchivoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteArchivo.class.getSimpleName()+"-saveClienteArchivoWithConnection");connexion.begin();			
			
			ClienteArchivoLogicAdditional.checkClienteArchivoToSave(this.clientearchivo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ClienteArchivoLogicAdditional.updateClienteArchivoToSave(this.clientearchivo,this.arrDatoGeneral);
			
			ClienteArchivoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.clientearchivo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowClienteArchivo();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarClienteArchivo(this.clientearchivo)) {
				ClienteArchivoDataAccess.save(this.clientearchivo, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.clientearchivo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ClienteArchivoLogicAdditional.checkClienteArchivoToSaveAfter(this.clientearchivo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowClienteArchivo();
			
			connexion.commit();			
			
			if(this.clientearchivo.getIsDeleted()) {
				this.clientearchivo=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveClienteArchivo()throws Exception {	
		try {	
			
			ClienteArchivoLogicAdditional.checkClienteArchivoToSave(this.clientearchivo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ClienteArchivoLogicAdditional.updateClienteArchivoToSave(this.clientearchivo,this.arrDatoGeneral);
			
			ClienteArchivoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.clientearchivo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarClienteArchivo(this.clientearchivo)) {			
				ClienteArchivoDataAccess.save(this.clientearchivo, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.clientearchivo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ClienteArchivoLogicAdditional.checkClienteArchivoToSaveAfter(this.clientearchivo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.clientearchivo.getIsDeleted()) {
				this.clientearchivo=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveClienteArchivosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteArchivo.class.getSimpleName()+"-saveClienteArchivosWithConnection");connexion.begin();			
			
			ClienteArchivoLogicAdditional.checkClienteArchivoToSaves(clientearchivos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowClienteArchivos();
			
			Boolean validadoTodosClienteArchivo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ClienteArchivo clientearchivoLocal:clientearchivos) {		
				if(clientearchivoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ClienteArchivoLogicAdditional.updateClienteArchivoToSave(clientearchivoLocal,this.arrDatoGeneral);
	        	
				ClienteArchivoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),clientearchivoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarClienteArchivo(clientearchivoLocal)) {
					ClienteArchivoDataAccess.save(clientearchivoLocal, connexion);				
				} else {
					validadoTodosClienteArchivo=false;
				}
			}
			
			if(!validadoTodosClienteArchivo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ClienteArchivoLogicAdditional.checkClienteArchivoToSavesAfter(clientearchivos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowClienteArchivos();
			
			connexion.commit();		
			
			this.quitarClienteArchivosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveClienteArchivos()throws Exception {				
		 try {	
			ClienteArchivoLogicAdditional.checkClienteArchivoToSaves(clientearchivos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosClienteArchivo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ClienteArchivo clientearchivoLocal:clientearchivos) {				
				if(clientearchivoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ClienteArchivoLogicAdditional.updateClienteArchivoToSave(clientearchivoLocal,this.arrDatoGeneral);
	        	
				ClienteArchivoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),clientearchivoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarClienteArchivo(clientearchivoLocal)) {				
					ClienteArchivoDataAccess.save(clientearchivoLocal, connexion);				
				} else {
					validadoTodosClienteArchivo=false;
				}
			}
			
			if(!validadoTodosClienteArchivo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ClienteArchivoLogicAdditional.checkClienteArchivoToSavesAfter(clientearchivos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarClienteArchivosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ClienteArchivoParameterReturnGeneral procesarAccionClienteArchivos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ClienteArchivo> clientearchivos,ClienteArchivoParameterReturnGeneral clientearchivoParameterGeneral)throws Exception {
		 try {	
			ClienteArchivoParameterReturnGeneral clientearchivoReturnGeneral=new ClienteArchivoParameterReturnGeneral();
	
			ClienteArchivoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,clientearchivos,clientearchivoParameterGeneral,clientearchivoReturnGeneral);
			
			return clientearchivoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ClienteArchivoParameterReturnGeneral procesarAccionClienteArchivosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ClienteArchivo> clientearchivos,ClienteArchivoParameterReturnGeneral clientearchivoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteArchivo.class.getSimpleName()+"-procesarAccionClienteArchivosWithConnection");connexion.begin();			
			
			ClienteArchivoParameterReturnGeneral clientearchivoReturnGeneral=new ClienteArchivoParameterReturnGeneral();
	
			ClienteArchivoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,clientearchivos,clientearchivoParameterGeneral,clientearchivoReturnGeneral);
			
			this.connexion.commit();
			
			return clientearchivoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ClienteArchivoParameterReturnGeneral procesarEventosClienteArchivos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ClienteArchivo> clientearchivos,ClienteArchivo clientearchivo,ClienteArchivoParameterReturnGeneral clientearchivoParameterGeneral,Boolean isEsNuevoClienteArchivo,ArrayList<Classe> clases)throws Exception {
		 try {	
			ClienteArchivoParameterReturnGeneral clientearchivoReturnGeneral=new ClienteArchivoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				clientearchivoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ClienteArchivoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,clientearchivos,clientearchivo,clientearchivoParameterGeneral,clientearchivoReturnGeneral,isEsNuevoClienteArchivo,clases);
			
			return clientearchivoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ClienteArchivoParameterReturnGeneral procesarEventosClienteArchivosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ClienteArchivo> clientearchivos,ClienteArchivo clientearchivo,ClienteArchivoParameterReturnGeneral clientearchivoParameterGeneral,Boolean isEsNuevoClienteArchivo,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteArchivo.class.getSimpleName()+"-procesarEventosClienteArchivosWithConnection");connexion.begin();			
			
			ClienteArchivoParameterReturnGeneral clientearchivoReturnGeneral=new ClienteArchivoParameterReturnGeneral();
	
			clientearchivoReturnGeneral.setClienteArchivo(clientearchivo);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				clientearchivoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ClienteArchivoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,clientearchivos,clientearchivo,clientearchivoParameterGeneral,clientearchivoReturnGeneral,isEsNuevoClienteArchivo,clases);
			
			this.connexion.commit();
			
			return clientearchivoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ClienteArchivoParameterReturnGeneral procesarImportacionClienteArchivosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ClienteArchivoParameterReturnGeneral clientearchivoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteArchivo.class.getSimpleName()+"-procesarImportacionClienteArchivosWithConnection");connexion.begin();			
			
			ClienteArchivoParameterReturnGeneral clientearchivoReturnGeneral=new ClienteArchivoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.clientearchivos=new ArrayList<ClienteArchivo>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.clientearchivo=new ClienteArchivo();
				
				
				if(conColumnasBase) {this.clientearchivo.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.clientearchivo.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.clientearchivo.setnombre(arrColumnas[iColumn++]);
				this.clientearchivo.setdescripcion(arrColumnas[iColumn++]);
				
				this.clientearchivos.add(this.clientearchivo);
			}
			
			this.saveClienteArchivos();
			
			this.connexion.commit();
			
			clientearchivoReturnGeneral.setConRetornoEstaProcesado(true);
			clientearchivoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return clientearchivoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarClienteArchivosEliminados() throws Exception {				
		
		List<ClienteArchivo> clientearchivosAux= new ArrayList<ClienteArchivo>();
		
		for(ClienteArchivo clientearchivo:clientearchivos) {
			if(!clientearchivo.getIsDeleted()) {
				clientearchivosAux.add(clientearchivo);
			}
		}
		
		clientearchivos=clientearchivosAux;
	}
	
	public void quitarClienteArchivosNulos() throws Exception {				
		
		List<ClienteArchivo> clientearchivosAux= new ArrayList<ClienteArchivo>();
		
		for(ClienteArchivo clientearchivo : this.clientearchivos) {
			if(clientearchivo==null) {
				clientearchivosAux.add(clientearchivo);
			}
		}
		
		//this.clientearchivos=clientearchivosAux;
		
		this.clientearchivos.removeAll(clientearchivosAux);
	}
	
	public void getSetVersionRowClienteArchivoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(clientearchivo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((clientearchivo.getIsDeleted() || (clientearchivo.getIsChanged()&&!clientearchivo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=clientearchivoDataAccess.getSetVersionRowClienteArchivo(connexion,clientearchivo.getId());
				
				if(!clientearchivo.getVersionRow().equals(timestamp)) {	
					clientearchivo.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				clientearchivo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowClienteArchivo()throws Exception {	
		
		if(clientearchivo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((clientearchivo.getIsDeleted() || (clientearchivo.getIsChanged()&&!clientearchivo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=clientearchivoDataAccess.getSetVersionRowClienteArchivo(connexion,clientearchivo.getId());
			
			try {							
				if(!clientearchivo.getVersionRow().equals(timestamp)) {	
					clientearchivo.setVersionRow(timestamp);
				}
				
				clientearchivo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowClienteArchivosWithConnection()throws Exception {	
		if(clientearchivos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ClienteArchivo clientearchivoAux:clientearchivos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(clientearchivoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(clientearchivoAux.getIsDeleted() || (clientearchivoAux.getIsChanged()&&!clientearchivoAux.getIsNew())) {
						
						timestamp=clientearchivoDataAccess.getSetVersionRowClienteArchivo(connexion,clientearchivoAux.getId());
						
						if(!clientearchivo.getVersionRow().equals(timestamp)) {	
							clientearchivoAux.setVersionRow(timestamp);
						}
								
						clientearchivoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowClienteArchivos()throws Exception {	
		if(clientearchivos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ClienteArchivo clientearchivoAux:clientearchivos) {
					if(clientearchivoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(clientearchivoAux.getIsDeleted() || (clientearchivoAux.getIsChanged()&&!clientearchivoAux.getIsNew())) {
						
						timestamp=clientearchivoDataAccess.getSetVersionRowClienteArchivo(connexion,clientearchivoAux.getId());
						
						if(!clientearchivoAux.getVersionRow().equals(timestamp)) {	
							clientearchivoAux.setVersionRow(timestamp);
						}
						
													
						clientearchivoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ClienteArchivoParameterReturnGeneral cargarCombosLoteForeignKeyClienteArchivoWithConnection(String finalQueryGlobalCliente,String finalQueryGlobalTipoArchivo) throws Exception {
		ClienteArchivoParameterReturnGeneral  clientearchivoReturnGeneral =new ClienteArchivoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteArchivo.class.getSimpleName()+"-cargarCombosLoteForeignKeyClienteArchivoWithConnection");connexion.begin();
			
			clientearchivoReturnGeneral =new ClienteArchivoParameterReturnGeneral();
			
			

			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			clientearchivoReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoArchivo> tipoarchivosForeignKey=new ArrayList<TipoArchivo>();
			TipoArchivoLogic tipoarchivoLogic=new TipoArchivoLogic();
			tipoarchivoLogic.setConnexion(this.connexion);
			tipoarchivoLogic.getTipoArchivoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoArchivo.equals("NONE")) {
				tipoarchivoLogic.getTodosTipoArchivos(finalQueryGlobalTipoArchivo,new Pagination());
				tipoarchivosForeignKey=tipoarchivoLogic.getTipoArchivos();
			}

			clientearchivoReturnGeneral.settipoarchivosForeignKey(tipoarchivosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return clientearchivoReturnGeneral;
	}
	
	public ClienteArchivoParameterReturnGeneral cargarCombosLoteForeignKeyClienteArchivo(String finalQueryGlobalCliente,String finalQueryGlobalTipoArchivo) throws Exception {
		ClienteArchivoParameterReturnGeneral  clientearchivoReturnGeneral =new ClienteArchivoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			clientearchivoReturnGeneral =new ClienteArchivoParameterReturnGeneral();
			
			

			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			clientearchivoReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoArchivo> tipoarchivosForeignKey=new ArrayList<TipoArchivo>();
			TipoArchivoLogic tipoarchivoLogic=new TipoArchivoLogic();
			tipoarchivoLogic.setConnexion(this.connexion);
			tipoarchivoLogic.getTipoArchivoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoArchivo.equals("NONE")) {
				tipoarchivoLogic.getTodosTipoArchivos(finalQueryGlobalTipoArchivo,new Pagination());
				tipoarchivosForeignKey=tipoarchivoLogic.getTipoArchivos();
			}

			clientearchivoReturnGeneral.settipoarchivosForeignKey(tipoarchivosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return clientearchivoReturnGeneral;
	}
	
	
	public void deepLoad(ClienteArchivo clientearchivo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ClienteArchivoLogicAdditional.updateClienteArchivoToGet(clientearchivo,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		clientearchivo.setCliente(clientearchivoDataAccess.getCliente(connexion,clientearchivo));
		clientearchivo.setTipoArchivo(clientearchivoDataAccess.getTipoArchivo(connexion,clientearchivo));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				clientearchivo.setCliente(clientearchivoDataAccess.getCliente(connexion,clientearchivo));
				continue;
			}

			if(clas.clas.equals(TipoArchivo.class)) {
				clientearchivo.setTipoArchivo(clientearchivoDataAccess.getTipoArchivo(connexion,clientearchivo));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			clientearchivo.setCliente(clientearchivoDataAccess.getCliente(connexion,clientearchivo));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoArchivo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			clientearchivo.setTipoArchivo(clientearchivoDataAccess.getTipoArchivo(connexion,clientearchivo));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		clientearchivo.setCliente(clientearchivoDataAccess.getCliente(connexion,clientearchivo));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(clientearchivo.getCliente(),isDeep,deepLoadType,clases);
				
		clientearchivo.setTipoArchivo(clientearchivoDataAccess.getTipoArchivo(connexion,clientearchivo));
		TipoArchivoLogic tipoarchivoLogic= new TipoArchivoLogic(connexion);
		tipoarchivoLogic.deepLoad(clientearchivo.getTipoArchivo(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				clientearchivo.setCliente(clientearchivoDataAccess.getCliente(connexion,clientearchivo));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(clientearchivo.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoArchivo.class)) {
				clientearchivo.setTipoArchivo(clientearchivoDataAccess.getTipoArchivo(connexion,clientearchivo));
				TipoArchivoLogic tipoarchivoLogic= new TipoArchivoLogic(connexion);
				tipoarchivoLogic.deepLoad(clientearchivo.getTipoArchivo(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			clientearchivo.setCliente(clientearchivoDataAccess.getCliente(connexion,clientearchivo));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(clientearchivo.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoArchivo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			clientearchivo.setTipoArchivo(clientearchivoDataAccess.getTipoArchivo(connexion,clientearchivo));
			TipoArchivoLogic tipoarchivoLogic= new TipoArchivoLogic(connexion);
			tipoarchivoLogic.deepLoad(clientearchivo.getTipoArchivo(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ClienteArchivo clientearchivo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ClienteArchivoLogicAdditional.updateClienteArchivoToSave(clientearchivo,this.arrDatoGeneral);
			
ClienteArchivoDataAccess.save(clientearchivo, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ClienteDataAccess.save(clientearchivo.getCliente(),connexion);

		TipoArchivoDataAccess.save(clientearchivo.getTipoArchivo(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(clientearchivo.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoArchivo.class)) {
				TipoArchivoDataAccess.save(clientearchivo.getTipoArchivo(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ClienteDataAccess.save(clientearchivo.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(clientearchivo.getCliente(),isDeep,deepLoadType,clases);
				

		TipoArchivoDataAccess.save(clientearchivo.getTipoArchivo(),connexion);
		TipoArchivoLogic tipoarchivoLogic= new TipoArchivoLogic(connexion);
		tipoarchivoLogic.deepLoad(clientearchivo.getTipoArchivo(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(clientearchivo.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(clientearchivo.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoArchivo.class)) {
				TipoArchivoDataAccess.save(clientearchivo.getTipoArchivo(),connexion);
				TipoArchivoLogic tipoarchivoLogic= new TipoArchivoLogic(connexion);
				tipoarchivoLogic.deepSave(clientearchivo.getTipoArchivo(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ClienteArchivo.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(clientearchivo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ClienteArchivoConstantesFunciones.refrescarForeignKeysDescripcionesClienteArchivo(clientearchivo);
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
			this.deepLoad(this.clientearchivo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ClienteArchivoConstantesFunciones.refrescarForeignKeysDescripcionesClienteArchivo(this.clientearchivo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ClienteArchivo.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(clientearchivos!=null) {
				for(ClienteArchivo clientearchivo:clientearchivos) {
					this.deepLoad(clientearchivo,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ClienteArchivoConstantesFunciones.refrescarForeignKeysDescripcionesClienteArchivo(clientearchivos);
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
			if(clientearchivos!=null) {
				for(ClienteArchivo clientearchivo:clientearchivos) {
					this.deepLoad(clientearchivo,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ClienteArchivoConstantesFunciones.refrescarForeignKeysDescripcionesClienteArchivo(clientearchivos);
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
			this.getNewConnexionToDeep(ClienteArchivo.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(clientearchivo,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ClienteArchivo.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(clientearchivos!=null) {
				for(ClienteArchivo clientearchivo:clientearchivos) {
					this.deepSave(clientearchivo,isDeep,deepLoadType,clases);
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
			if(clientearchivos!=null) {
				for(ClienteArchivo clientearchivo:clientearchivos) {
					this.deepSave(clientearchivo,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getClienteArchivosFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteArchivo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,ClienteArchivoConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			ClienteArchivoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientearchivos=clientearchivoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteArchivoConstantesFunciones.refrescarForeignKeysDescripcionesClienteArchivo(this.clientearchivos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClienteArchivosFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,ClienteArchivoConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			ClienteArchivoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientearchivos=clientearchivoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteArchivoConstantesFunciones.refrescarForeignKeysDescripcionesClienteArchivo(this.clientearchivos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClienteArchivosFK_IdTipoArchivoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_archivo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteArchivo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoArchivo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoArchivo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_archivo,ClienteArchivoConstantesFunciones.IDTIPOARCHIVO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoArchivo);

			ClienteArchivoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoArchivo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientearchivos=clientearchivoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteArchivoConstantesFunciones.refrescarForeignKeysDescripcionesClienteArchivo(this.clientearchivos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClienteArchivosFK_IdTipoArchivo(String sFinalQuery,Pagination pagination,Long id_tipo_archivo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoArchivo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoArchivo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_archivo,ClienteArchivoConstantesFunciones.IDTIPOARCHIVO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoArchivo);

			ClienteArchivoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoArchivo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientearchivos=clientearchivoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteArchivoConstantesFunciones.refrescarForeignKeysDescripcionesClienteArchivo(this.clientearchivos);
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
			if(ClienteArchivoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ClienteArchivoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ClienteArchivo clientearchivo,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ClienteArchivoConstantesFunciones.ISCONAUDITORIA) {
				if(clientearchivo.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ClienteArchivoDataAccess.TABLENAME, clientearchivo.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ClienteArchivoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ClienteArchivoLogic.registrarAuditoriaDetallesClienteArchivo(connexion,clientearchivo,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(clientearchivo.getIsDeleted()) {
					/*if(!clientearchivo.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ClienteArchivoDataAccess.TABLENAME, clientearchivo.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ClienteArchivoLogic.registrarAuditoriaDetallesClienteArchivo(connexion,clientearchivo,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ClienteArchivoDataAccess.TABLENAME, clientearchivo.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(clientearchivo.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ClienteArchivoDataAccess.TABLENAME, clientearchivo.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ClienteArchivoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ClienteArchivoLogic.registrarAuditoriaDetallesClienteArchivo(connexion,clientearchivo,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesClienteArchivo(Connexion connexion,ClienteArchivo clientearchivo)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(clientearchivo.getIsNew()||!clientearchivo.getid_cliente().equals(clientearchivo.getClienteArchivoOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clientearchivo.getClienteArchivoOriginal().getid_cliente()!=null)
				{
					strValorActual=clientearchivo.getClienteArchivoOriginal().getid_cliente().toString();
				}
				if(clientearchivo.getid_cliente()!=null)
				{
					strValorNuevo=clientearchivo.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteArchivoConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(clientearchivo.getIsNew()||!clientearchivo.getid_tipo_archivo().equals(clientearchivo.getClienteArchivoOriginal().getid_tipo_archivo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clientearchivo.getClienteArchivoOriginal().getid_tipo_archivo()!=null)
				{
					strValorActual=clientearchivo.getClienteArchivoOriginal().getid_tipo_archivo().toString();
				}
				if(clientearchivo.getid_tipo_archivo()!=null)
				{
					strValorNuevo=clientearchivo.getid_tipo_archivo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteArchivoConstantesFunciones.IDTIPOARCHIVO,strValorActual,strValorNuevo);
			}	
			
			if(clientearchivo.getIsNew()||!clientearchivo.getnombre().equals(clientearchivo.getClienteArchivoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clientearchivo.getClienteArchivoOriginal().getnombre()!=null)
				{
					strValorActual=clientearchivo.getClienteArchivoOriginal().getnombre();
				}
				if(clientearchivo.getnombre()!=null)
				{
					strValorNuevo=clientearchivo.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteArchivoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(clientearchivo.getIsNew()||!clientearchivo.getarchivo().equals(clientearchivo.getClienteArchivoOriginal().getarchivo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clientearchivo.getClienteArchivoOriginal().getarchivo()!=null)
				{
					strValorActual=clientearchivo.getClienteArchivoOriginal().getarchivo().toString();
				}
				if(clientearchivo.getarchivo()!=null)
				{
					strValorNuevo=clientearchivo.getarchivo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteArchivoConstantesFunciones.ARCHIVO,strValorActual,strValorNuevo);
			}	
			
			if(clientearchivo.getIsNew()||!clientearchivo.getdescripcion().equals(clientearchivo.getClienteArchivoOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clientearchivo.getClienteArchivoOriginal().getdescripcion()!=null)
				{
					strValorActual=clientearchivo.getClienteArchivoOriginal().getdescripcion();
				}
				if(clientearchivo.getdescripcion()!=null)
				{
					strValorNuevo=clientearchivo.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteArchivoConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveClienteArchivoRelacionesWithConnection(ClienteArchivo clientearchivo) throws Exception {

		if(!clientearchivo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveClienteArchivoRelacionesBase(clientearchivo,true);
		}
	}

	public void saveClienteArchivoRelaciones(ClienteArchivo clientearchivo)throws Exception {

		if(!clientearchivo.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveClienteArchivoRelacionesBase(clientearchivo,false);
		}
	}

	public void saveClienteArchivoRelacionesBase(ClienteArchivo clientearchivo,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ClienteArchivo-saveRelacionesWithConnection");}
	

			this.setClienteArchivo(clientearchivo);

			if(ClienteArchivoLogicAdditional.validarSaveRelaciones(clientearchivo,this)) {

				ClienteArchivoLogicAdditional.updateRelacionesToSave(clientearchivo,this);

				if((clientearchivo.getIsNew()||clientearchivo.getIsChanged())&&!clientearchivo.getIsDeleted()) {
					this.saveClienteArchivo();
					this.saveClienteArchivoRelacionesDetalles();

				} else if(clientearchivo.getIsDeleted()) {
					this.saveClienteArchivoRelacionesDetalles();
					this.saveClienteArchivo();
				}

				ClienteArchivoLogicAdditional.updateRelacionesToSaveAfter(clientearchivo,this);

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
	
	
	private void saveClienteArchivoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfClienteArchivo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ClienteArchivoConstantesFunciones.getClassesForeignKeysOfClienteArchivo(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfClienteArchivo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ClienteArchivoConstantesFunciones.getClassesRelationshipsOfClienteArchivo(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

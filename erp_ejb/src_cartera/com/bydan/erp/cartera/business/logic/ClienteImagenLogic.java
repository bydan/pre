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
import com.bydan.erp.cartera.util.ClienteImagenConstantesFunciones;
import com.bydan.erp.cartera.util.ClienteImagenParameterReturnGeneral;
//import com.bydan.erp.cartera.util.ClienteImagenParameterGeneral;
import com.bydan.erp.cartera.business.entity.ClienteImagen;
import com.bydan.erp.cartera.business.logic.ClienteImagenLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class ClienteImagenLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ClienteImagenLogic.class);
	
	protected ClienteImagenDataAccess clienteimagenDataAccess; 	
	protected ClienteImagen clienteimagen;
	protected List<ClienteImagen> clienteimagens;
	protected Object clienteimagenObject;	
	protected List<Object> clienteimagensObject;
	
	public static ClassValidator<ClienteImagen> clienteimagenValidator = new ClassValidator<ClienteImagen>(ClienteImagen.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ClienteImagenLogicAdditional clienteimagenLogicAdditional=null;
	
	public ClienteImagenLogicAdditional getClienteImagenLogicAdditional() {
		return this.clienteimagenLogicAdditional;
	}
	
	public void setClienteImagenLogicAdditional(ClienteImagenLogicAdditional clienteimagenLogicAdditional) {
		try {
			this.clienteimagenLogicAdditional=clienteimagenLogicAdditional;
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
	
	
	
	
	public  ClienteImagenLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.clienteimagenDataAccess = new ClienteImagenDataAccess();
			
			this.clienteimagens= new ArrayList<ClienteImagen>();
			this.clienteimagen= new ClienteImagen();
			
			this.clienteimagenObject=new Object();
			this.clienteimagensObject=new ArrayList<Object>();
				
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
			
			this.clienteimagenDataAccess.setConnexionType(this.connexionType);
			this.clienteimagenDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ClienteImagenLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.clienteimagenDataAccess = new ClienteImagenDataAccess();
			this.clienteimagens= new ArrayList<ClienteImagen>();
			this.clienteimagen= new ClienteImagen();
			this.clienteimagenObject=new Object();
			this.clienteimagensObject=new ArrayList<Object>();
			
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
			
			this.clienteimagenDataAccess.setConnexionType(this.connexionType);
			this.clienteimagenDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ClienteImagen getClienteImagen() throws Exception {	
		ClienteImagenLogicAdditional.checkClienteImagenToGet(clienteimagen,this.datosCliente,this.arrDatoGeneral);
		ClienteImagenLogicAdditional.updateClienteImagenToGet(clienteimagen,this.arrDatoGeneral);
		
		return clienteimagen;
	}
		
	public void setClienteImagen(ClienteImagen newClienteImagen) {
		this.clienteimagen = newClienteImagen;
	}
	
	public ClienteImagenDataAccess getClienteImagenDataAccess() {
		return clienteimagenDataAccess;
	}
	
	public void setClienteImagenDataAccess(ClienteImagenDataAccess newclienteimagenDataAccess) {
		this.clienteimagenDataAccess = newclienteimagenDataAccess;
	}
	
	public List<ClienteImagen> getClienteImagens() throws Exception {		
		this.quitarClienteImagensNulos();
		
		ClienteImagenLogicAdditional.checkClienteImagenToGets(clienteimagens,this.datosCliente,this.arrDatoGeneral);
		
		for (ClienteImagen clienteimagenLocal: clienteimagens ) {
			ClienteImagenLogicAdditional.updateClienteImagenToGet(clienteimagenLocal,this.arrDatoGeneral);
		}
		
		return clienteimagens;
	}
	
	public void setClienteImagens(List<ClienteImagen> newClienteImagens) {
		this.clienteimagens = newClienteImagens;
	}
	
	public Object getClienteImagenObject() {	
		this.clienteimagenObject=this.clienteimagenDataAccess.getEntityObject();
		return this.clienteimagenObject;
	}
		
	public void setClienteImagenObject(Object newClienteImagenObject) {
		this.clienteimagenObject = newClienteImagenObject;
	}
	
	public List<Object> getClienteImagensObject() {		
		this.clienteimagensObject=this.clienteimagenDataAccess.getEntitiesObject();
		return this.clienteimagensObject;
	}
		
	public void setClienteImagensObject(List<Object> newClienteImagensObject) {
		this.clienteimagensObject = newClienteImagensObject;
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
		
		if(this.clienteimagenDataAccess!=null) {
			this.clienteimagenDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteImagen.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			clienteimagenDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			clienteimagenDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		clienteimagen = new  ClienteImagen();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteImagen.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			clienteimagen=clienteimagenDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.clienteimagen,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ClienteImagenConstantesFunciones.refrescarForeignKeysDescripcionesClienteImagen(this.clienteimagen);
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
		clienteimagen = new  ClienteImagen();
		  		  
        try {
			
			clienteimagen=clienteimagenDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.clienteimagen,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ClienteImagenConstantesFunciones.refrescarForeignKeysDescripcionesClienteImagen(this.clienteimagen);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		clienteimagen = new  ClienteImagen();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteImagen.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			clienteimagen=clienteimagenDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.clienteimagen,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ClienteImagenConstantesFunciones.refrescarForeignKeysDescripcionesClienteImagen(this.clienteimagen);
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
		clienteimagen = new  ClienteImagen();
		  		  
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
		clienteimagen = new  ClienteImagen();
		  		  
        try {
			
			clienteimagen=clienteimagenDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.clienteimagen,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ClienteImagenConstantesFunciones.refrescarForeignKeysDescripcionesClienteImagen(this.clienteimagen);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		clienteimagen = new  ClienteImagen();
		  		  
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
		clienteimagen = new  ClienteImagen();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteImagen.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =clienteimagenDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		clienteimagen = new  ClienteImagen();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=clienteimagenDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		clienteimagen = new  ClienteImagen();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteImagen.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =clienteimagenDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		clienteimagen = new  ClienteImagen();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=clienteimagenDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		clienteimagen = new  ClienteImagen();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteImagen.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =clienteimagenDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		clienteimagen = new  ClienteImagen();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=clienteimagenDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		clienteimagens = new  ArrayList<ClienteImagen>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteImagen.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ClienteImagenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clienteimagens=clienteimagenDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarClienteImagen(clienteimagens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteImagenConstantesFunciones.refrescarForeignKeysDescripcionesClienteImagen(this.clienteimagens);
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
		clienteimagens = new  ArrayList<ClienteImagen>();
		  		  
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
		clienteimagens = new  ArrayList<ClienteImagen>();
		  		  
        try {			
			ClienteImagenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clienteimagens=clienteimagenDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarClienteImagen(clienteimagens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteImagenConstantesFunciones.refrescarForeignKeysDescripcionesClienteImagen(this.clienteimagens);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		clienteimagens = new  ArrayList<ClienteImagen>();
		  		  
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
		clienteimagens = new  ArrayList<ClienteImagen>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteImagen.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ClienteImagenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clienteimagens=clienteimagenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarClienteImagen(clienteimagens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteImagenConstantesFunciones.refrescarForeignKeysDescripcionesClienteImagen(this.clienteimagens);
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
		clienteimagens = new  ArrayList<ClienteImagen>();
		  		  
        try {
			ClienteImagenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clienteimagens=clienteimagenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarClienteImagen(clienteimagens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteImagenConstantesFunciones.refrescarForeignKeysDescripcionesClienteImagen(this.clienteimagens);
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
		clienteimagens = new  ArrayList<ClienteImagen>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteImagen.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ClienteImagenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clienteimagens=clienteimagenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarClienteImagen(clienteimagens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteImagenConstantesFunciones.refrescarForeignKeysDescripcionesClienteImagen(this.clienteimagens);
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
		clienteimagens = new  ArrayList<ClienteImagen>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ClienteImagenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clienteimagens=clienteimagenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarClienteImagen(clienteimagens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteImagenConstantesFunciones.refrescarForeignKeysDescripcionesClienteImagen(this.clienteimagens);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		clienteimagen = new  ClienteImagen();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteImagen.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ClienteImagenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clienteimagen=clienteimagenDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarClienteImagen(clienteimagen);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteImagenConstantesFunciones.refrescarForeignKeysDescripcionesClienteImagen(this.clienteimagen);
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
		clienteimagen = new  ClienteImagen();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ClienteImagenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clienteimagen=clienteimagenDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarClienteImagen(clienteimagen);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteImagenConstantesFunciones.refrescarForeignKeysDescripcionesClienteImagen(this.clienteimagen);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosClienteImagensWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		clienteimagens = new  ArrayList<ClienteImagen>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteImagen.class.getSimpleName()+"-getTodosClienteImagensWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ClienteImagenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clienteimagens=clienteimagenDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarClienteImagen(clienteimagens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteImagenConstantesFunciones.refrescarForeignKeysDescripcionesClienteImagen(this.clienteimagens);
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
	
	public  void  getTodosClienteImagens(String sFinalQuery,Pagination pagination)throws Exception {
		clienteimagens = new  ArrayList<ClienteImagen>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ClienteImagenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clienteimagens=clienteimagenDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarClienteImagen(clienteimagens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteImagenConstantesFunciones.refrescarForeignKeysDescripcionesClienteImagen(this.clienteimagens);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarClienteImagen(ClienteImagen clienteimagen) throws Exception {
		Boolean estaValidado=false;
		
		if(clienteimagen.getIsNew() || clienteimagen.getIsChanged()) { 
			this.invalidValues = clienteimagenValidator.getInvalidValues(clienteimagen);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(clienteimagen);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarClienteImagen(List<ClienteImagen> ClienteImagens) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ClienteImagen clienteimagenLocal:clienteimagens) {				
			estaValidadoObjeto=this.validarGuardarClienteImagen(clienteimagenLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarClienteImagen(List<ClienteImagen> ClienteImagens) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarClienteImagen(clienteimagens)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarClienteImagen(ClienteImagen ClienteImagen) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarClienteImagen(clienteimagen)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ClienteImagen clienteimagen) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+clienteimagen.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ClienteImagenConstantesFunciones.getClienteImagenLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"clienteimagen","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ClienteImagenConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ClienteImagenConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveClienteImagenWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteImagen.class.getSimpleName()+"-saveClienteImagenWithConnection");connexion.begin();			
			
			ClienteImagenLogicAdditional.checkClienteImagenToSave(this.clienteimagen,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ClienteImagenLogicAdditional.updateClienteImagenToSave(this.clienteimagen,this.arrDatoGeneral);
			
			ClienteImagenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.clienteimagen,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowClienteImagen();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarClienteImagen(this.clienteimagen)) {
				ClienteImagenDataAccess.save(this.clienteimagen, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.clienteimagen,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ClienteImagenLogicAdditional.checkClienteImagenToSaveAfter(this.clienteimagen,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowClienteImagen();
			
			connexion.commit();			
			
			if(this.clienteimagen.getIsDeleted()) {
				this.clienteimagen=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveClienteImagen()throws Exception {	
		try {	
			
			ClienteImagenLogicAdditional.checkClienteImagenToSave(this.clienteimagen,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ClienteImagenLogicAdditional.updateClienteImagenToSave(this.clienteimagen,this.arrDatoGeneral);
			
			ClienteImagenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.clienteimagen,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarClienteImagen(this.clienteimagen)) {			
				ClienteImagenDataAccess.save(this.clienteimagen, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.clienteimagen,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ClienteImagenLogicAdditional.checkClienteImagenToSaveAfter(this.clienteimagen,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.clienteimagen.getIsDeleted()) {
				this.clienteimagen=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveClienteImagensWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteImagen.class.getSimpleName()+"-saveClienteImagensWithConnection");connexion.begin();			
			
			ClienteImagenLogicAdditional.checkClienteImagenToSaves(clienteimagens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowClienteImagens();
			
			Boolean validadoTodosClienteImagen=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ClienteImagen clienteimagenLocal:clienteimagens) {		
				if(clienteimagenLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ClienteImagenLogicAdditional.updateClienteImagenToSave(clienteimagenLocal,this.arrDatoGeneral);
	        	
				ClienteImagenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),clienteimagenLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarClienteImagen(clienteimagenLocal)) {
					ClienteImagenDataAccess.save(clienteimagenLocal, connexion);				
				} else {
					validadoTodosClienteImagen=false;
				}
			}
			
			if(!validadoTodosClienteImagen) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ClienteImagenLogicAdditional.checkClienteImagenToSavesAfter(clienteimagens,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowClienteImagens();
			
			connexion.commit();		
			
			this.quitarClienteImagensEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveClienteImagens()throws Exception {				
		 try {	
			ClienteImagenLogicAdditional.checkClienteImagenToSaves(clienteimagens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosClienteImagen=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ClienteImagen clienteimagenLocal:clienteimagens) {				
				if(clienteimagenLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ClienteImagenLogicAdditional.updateClienteImagenToSave(clienteimagenLocal,this.arrDatoGeneral);
	        	
				ClienteImagenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),clienteimagenLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarClienteImagen(clienteimagenLocal)) {				
					ClienteImagenDataAccess.save(clienteimagenLocal, connexion);				
				} else {
					validadoTodosClienteImagen=false;
				}
			}
			
			if(!validadoTodosClienteImagen) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ClienteImagenLogicAdditional.checkClienteImagenToSavesAfter(clienteimagens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarClienteImagensEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ClienteImagenParameterReturnGeneral procesarAccionClienteImagens(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ClienteImagen> clienteimagens,ClienteImagenParameterReturnGeneral clienteimagenParameterGeneral)throws Exception {
		 try {	
			ClienteImagenParameterReturnGeneral clienteimagenReturnGeneral=new ClienteImagenParameterReturnGeneral();
	
			ClienteImagenLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,clienteimagens,clienteimagenParameterGeneral,clienteimagenReturnGeneral);
			
			return clienteimagenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ClienteImagenParameterReturnGeneral procesarAccionClienteImagensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ClienteImagen> clienteimagens,ClienteImagenParameterReturnGeneral clienteimagenParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteImagen.class.getSimpleName()+"-procesarAccionClienteImagensWithConnection");connexion.begin();			
			
			ClienteImagenParameterReturnGeneral clienteimagenReturnGeneral=new ClienteImagenParameterReturnGeneral();
	
			ClienteImagenLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,clienteimagens,clienteimagenParameterGeneral,clienteimagenReturnGeneral);
			
			this.connexion.commit();
			
			return clienteimagenReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ClienteImagenParameterReturnGeneral procesarEventosClienteImagens(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ClienteImagen> clienteimagens,ClienteImagen clienteimagen,ClienteImagenParameterReturnGeneral clienteimagenParameterGeneral,Boolean isEsNuevoClienteImagen,ArrayList<Classe> clases)throws Exception {
		 try {	
			ClienteImagenParameterReturnGeneral clienteimagenReturnGeneral=new ClienteImagenParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				clienteimagenReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ClienteImagenLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,clienteimagens,clienteimagen,clienteimagenParameterGeneral,clienteimagenReturnGeneral,isEsNuevoClienteImagen,clases);
			
			return clienteimagenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ClienteImagenParameterReturnGeneral procesarEventosClienteImagensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ClienteImagen> clienteimagens,ClienteImagen clienteimagen,ClienteImagenParameterReturnGeneral clienteimagenParameterGeneral,Boolean isEsNuevoClienteImagen,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteImagen.class.getSimpleName()+"-procesarEventosClienteImagensWithConnection");connexion.begin();			
			
			ClienteImagenParameterReturnGeneral clienteimagenReturnGeneral=new ClienteImagenParameterReturnGeneral();
	
			clienteimagenReturnGeneral.setClienteImagen(clienteimagen);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				clienteimagenReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ClienteImagenLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,clienteimagens,clienteimagen,clienteimagenParameterGeneral,clienteimagenReturnGeneral,isEsNuevoClienteImagen,clases);
			
			this.connexion.commit();
			
			return clienteimagenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ClienteImagenParameterReturnGeneral procesarImportacionClienteImagensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ClienteImagenParameterReturnGeneral clienteimagenParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteImagen.class.getSimpleName()+"-procesarImportacionClienteImagensWithConnection");connexion.begin();			
			
			ClienteImagenParameterReturnGeneral clienteimagenReturnGeneral=new ClienteImagenParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.clienteimagens=new ArrayList<ClienteImagen>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.clienteimagen=new ClienteImagen();
				
				
				if(conColumnasBase) {this.clienteimagen.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.clienteimagen.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.clienteimagen.setnombre(arrColumnas[iColumn++]);
				this.clienteimagen.setdescripcion(arrColumnas[iColumn++]);
				
				this.clienteimagens.add(this.clienteimagen);
			}
			
			this.saveClienteImagens();
			
			this.connexion.commit();
			
			clienteimagenReturnGeneral.setConRetornoEstaProcesado(true);
			clienteimagenReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return clienteimagenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarClienteImagensEliminados() throws Exception {				
		
		List<ClienteImagen> clienteimagensAux= new ArrayList<ClienteImagen>();
		
		for(ClienteImagen clienteimagen:clienteimagens) {
			if(!clienteimagen.getIsDeleted()) {
				clienteimagensAux.add(clienteimagen);
			}
		}
		
		clienteimagens=clienteimagensAux;
	}
	
	public void quitarClienteImagensNulos() throws Exception {				
		
		List<ClienteImagen> clienteimagensAux= new ArrayList<ClienteImagen>();
		
		for(ClienteImagen clienteimagen : this.clienteimagens) {
			if(clienteimagen==null) {
				clienteimagensAux.add(clienteimagen);
			}
		}
		
		//this.clienteimagens=clienteimagensAux;
		
		this.clienteimagens.removeAll(clienteimagensAux);
	}
	
	public void getSetVersionRowClienteImagenWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(clienteimagen.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((clienteimagen.getIsDeleted() || (clienteimagen.getIsChanged()&&!clienteimagen.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=clienteimagenDataAccess.getSetVersionRowClienteImagen(connexion,clienteimagen.getId());
				
				if(!clienteimagen.getVersionRow().equals(timestamp)) {	
					clienteimagen.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				clienteimagen.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowClienteImagen()throws Exception {	
		
		if(clienteimagen.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((clienteimagen.getIsDeleted() || (clienteimagen.getIsChanged()&&!clienteimagen.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=clienteimagenDataAccess.getSetVersionRowClienteImagen(connexion,clienteimagen.getId());
			
			try {							
				if(!clienteimagen.getVersionRow().equals(timestamp)) {	
					clienteimagen.setVersionRow(timestamp);
				}
				
				clienteimagen.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowClienteImagensWithConnection()throws Exception {	
		if(clienteimagens!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ClienteImagen clienteimagenAux:clienteimagens) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(clienteimagenAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(clienteimagenAux.getIsDeleted() || (clienteimagenAux.getIsChanged()&&!clienteimagenAux.getIsNew())) {
						
						timestamp=clienteimagenDataAccess.getSetVersionRowClienteImagen(connexion,clienteimagenAux.getId());
						
						if(!clienteimagen.getVersionRow().equals(timestamp)) {	
							clienteimagenAux.setVersionRow(timestamp);
						}
								
						clienteimagenAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowClienteImagens()throws Exception {	
		if(clienteimagens!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ClienteImagen clienteimagenAux:clienteimagens) {
					if(clienteimagenAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(clienteimagenAux.getIsDeleted() || (clienteimagenAux.getIsChanged()&&!clienteimagenAux.getIsNew())) {
						
						timestamp=clienteimagenDataAccess.getSetVersionRowClienteImagen(connexion,clienteimagenAux.getId());
						
						if(!clienteimagenAux.getVersionRow().equals(timestamp)) {	
							clienteimagenAux.setVersionRow(timestamp);
						}
						
													
						clienteimagenAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ClienteImagenParameterReturnGeneral cargarCombosLoteForeignKeyClienteImagenWithConnection(String finalQueryGlobalCliente,String finalQueryGlobalTipoImagenPersona,String finalQueryGlobalTipoImagen) throws Exception {
		ClienteImagenParameterReturnGeneral  clienteimagenReturnGeneral =new ClienteImagenParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteImagen.class.getSimpleName()+"-cargarCombosLoteForeignKeyClienteImagenWithConnection");connexion.begin();
			
			clienteimagenReturnGeneral =new ClienteImagenParameterReturnGeneral();
			
			

			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			clienteimagenReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoImagenPersona> tipoimagenpersonasForeignKey=new ArrayList<TipoImagenPersona>();
			TipoImagenPersonaLogic tipoimagenpersonaLogic=new TipoImagenPersonaLogic();
			tipoimagenpersonaLogic.setConnexion(this.connexion);
			tipoimagenpersonaLogic.getTipoImagenPersonaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoImagenPersona.equals("NONE")) {
				tipoimagenpersonaLogic.getTodosTipoImagenPersonas(finalQueryGlobalTipoImagenPersona,new Pagination());
				tipoimagenpersonasForeignKey=tipoimagenpersonaLogic.getTipoImagenPersonas();
			}

			clienteimagenReturnGeneral.settipoimagenpersonasForeignKey(tipoimagenpersonasForeignKey);


			List<TipoImagen> tipoimagensForeignKey=new ArrayList<TipoImagen>();
			TipoImagenLogic tipoimagenLogic=new TipoImagenLogic();
			tipoimagenLogic.setConnexion(this.connexion);
			tipoimagenLogic.getTipoImagenDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoImagen.equals("NONE")) {
				tipoimagenLogic.getTodosTipoImagens(finalQueryGlobalTipoImagen,new Pagination());
				tipoimagensForeignKey=tipoimagenLogic.getTipoImagens();
			}

			clienteimagenReturnGeneral.settipoimagensForeignKey(tipoimagensForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return clienteimagenReturnGeneral;
	}
	
	public ClienteImagenParameterReturnGeneral cargarCombosLoteForeignKeyClienteImagen(String finalQueryGlobalCliente,String finalQueryGlobalTipoImagenPersona,String finalQueryGlobalTipoImagen) throws Exception {
		ClienteImagenParameterReturnGeneral  clienteimagenReturnGeneral =new ClienteImagenParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			clienteimagenReturnGeneral =new ClienteImagenParameterReturnGeneral();
			
			

			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			clienteimagenReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoImagenPersona> tipoimagenpersonasForeignKey=new ArrayList<TipoImagenPersona>();
			TipoImagenPersonaLogic tipoimagenpersonaLogic=new TipoImagenPersonaLogic();
			tipoimagenpersonaLogic.setConnexion(this.connexion);
			tipoimagenpersonaLogic.getTipoImagenPersonaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoImagenPersona.equals("NONE")) {
				tipoimagenpersonaLogic.getTodosTipoImagenPersonas(finalQueryGlobalTipoImagenPersona,new Pagination());
				tipoimagenpersonasForeignKey=tipoimagenpersonaLogic.getTipoImagenPersonas();
			}

			clienteimagenReturnGeneral.settipoimagenpersonasForeignKey(tipoimagenpersonasForeignKey);


			List<TipoImagen> tipoimagensForeignKey=new ArrayList<TipoImagen>();
			TipoImagenLogic tipoimagenLogic=new TipoImagenLogic();
			tipoimagenLogic.setConnexion(this.connexion);
			tipoimagenLogic.getTipoImagenDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoImagen.equals("NONE")) {
				tipoimagenLogic.getTodosTipoImagens(finalQueryGlobalTipoImagen,new Pagination());
				tipoimagensForeignKey=tipoimagenLogic.getTipoImagens();
			}

			clienteimagenReturnGeneral.settipoimagensForeignKey(tipoimagensForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return clienteimagenReturnGeneral;
	}
	
	
	public void deepLoad(ClienteImagen clienteimagen,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ClienteImagenLogicAdditional.updateClienteImagenToGet(clienteimagen,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		clienteimagen.setCliente(clienteimagenDataAccess.getCliente(connexion,clienteimagen));
		clienteimagen.setTipoImagenPersona(clienteimagenDataAccess.getTipoImagenPersona(connexion,clienteimagen));
		clienteimagen.setTipoImagen(clienteimagenDataAccess.getTipoImagen(connexion,clienteimagen));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				clienteimagen.setCliente(clienteimagenDataAccess.getCliente(connexion,clienteimagen));
				continue;
			}

			if(clas.clas.equals(TipoImagenPersona.class)) {
				clienteimagen.setTipoImagenPersona(clienteimagenDataAccess.getTipoImagenPersona(connexion,clienteimagen));
				continue;
			}

			if(clas.clas.equals(TipoImagen.class)) {
				clienteimagen.setTipoImagen(clienteimagenDataAccess.getTipoImagen(connexion,clienteimagen));
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
			clienteimagen.setCliente(clienteimagenDataAccess.getCliente(connexion,clienteimagen));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoImagenPersona.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			clienteimagen.setTipoImagenPersona(clienteimagenDataAccess.getTipoImagenPersona(connexion,clienteimagen));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoImagen.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			clienteimagen.setTipoImagen(clienteimagenDataAccess.getTipoImagen(connexion,clienteimagen));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		clienteimagen.setCliente(clienteimagenDataAccess.getCliente(connexion,clienteimagen));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(clienteimagen.getCliente(),isDeep,deepLoadType,clases);
				
		clienteimagen.setTipoImagenPersona(clienteimagenDataAccess.getTipoImagenPersona(connexion,clienteimagen));
		TipoImagenPersonaLogic tipoimagenpersonaLogic= new TipoImagenPersonaLogic(connexion);
		tipoimagenpersonaLogic.deepLoad(clienteimagen.getTipoImagenPersona(),isDeep,deepLoadType,clases);
				
		clienteimagen.setTipoImagen(clienteimagenDataAccess.getTipoImagen(connexion,clienteimagen));
		TipoImagenLogic tipoimagenLogic= new TipoImagenLogic(connexion);
		tipoimagenLogic.deepLoad(clienteimagen.getTipoImagen(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				clienteimagen.setCliente(clienteimagenDataAccess.getCliente(connexion,clienteimagen));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(clienteimagen.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoImagenPersona.class)) {
				clienteimagen.setTipoImagenPersona(clienteimagenDataAccess.getTipoImagenPersona(connexion,clienteimagen));
				TipoImagenPersonaLogic tipoimagenpersonaLogic= new TipoImagenPersonaLogic(connexion);
				tipoimagenpersonaLogic.deepLoad(clienteimagen.getTipoImagenPersona(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoImagen.class)) {
				clienteimagen.setTipoImagen(clienteimagenDataAccess.getTipoImagen(connexion,clienteimagen));
				TipoImagenLogic tipoimagenLogic= new TipoImagenLogic(connexion);
				tipoimagenLogic.deepLoad(clienteimagen.getTipoImagen(),isDeep,deepLoadType,clases);				
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
			clienteimagen.setCliente(clienteimagenDataAccess.getCliente(connexion,clienteimagen));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(clienteimagen.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoImagenPersona.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			clienteimagen.setTipoImagenPersona(clienteimagenDataAccess.getTipoImagenPersona(connexion,clienteimagen));
			TipoImagenPersonaLogic tipoimagenpersonaLogic= new TipoImagenPersonaLogic(connexion);
			tipoimagenpersonaLogic.deepLoad(clienteimagen.getTipoImagenPersona(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoImagen.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			clienteimagen.setTipoImagen(clienteimagenDataAccess.getTipoImagen(connexion,clienteimagen));
			TipoImagenLogic tipoimagenLogic= new TipoImagenLogic(connexion);
			tipoimagenLogic.deepLoad(clienteimagen.getTipoImagen(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ClienteImagen clienteimagen,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ClienteImagen.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(clienteimagen,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ClienteImagenConstantesFunciones.refrescarForeignKeysDescripcionesClienteImagen(clienteimagen);
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
			this.deepLoad(this.clienteimagen,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ClienteImagenConstantesFunciones.refrescarForeignKeysDescripcionesClienteImagen(this.clienteimagen);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ClienteImagen.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(clienteimagens!=null) {
				for(ClienteImagen clienteimagen:clienteimagens) {
					this.deepLoad(clienteimagen,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ClienteImagenConstantesFunciones.refrescarForeignKeysDescripcionesClienteImagen(clienteimagens);
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
			if(clienteimagens!=null) {
				for(ClienteImagen clienteimagen:clienteimagens) {
					this.deepLoad(clienteimagen,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ClienteImagenConstantesFunciones.refrescarForeignKeysDescripcionesClienteImagen(clienteimagens);
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
	
	
	public void getClienteImagensFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteImagen.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,ClienteImagenConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			ClienteImagenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clienteimagens=clienteimagenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteImagenConstantesFunciones.refrescarForeignKeysDescripcionesClienteImagen(this.clienteimagens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClienteImagensFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,ClienteImagenConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			ClienteImagenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clienteimagens=clienteimagenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteImagenConstantesFunciones.refrescarForeignKeysDescripcionesClienteImagen(this.clienteimagens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClienteImagensFK_IdTipoImagenWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_imagen)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteImagen.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoImagen= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoImagen.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_imagen,ClienteImagenConstantesFunciones.IDTIPOIMAGEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoImagen);

			ClienteImagenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoImagen","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clienteimagens=clienteimagenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteImagenConstantesFunciones.refrescarForeignKeysDescripcionesClienteImagen(this.clienteimagens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClienteImagensFK_IdTipoImagen(String sFinalQuery,Pagination pagination,Long id_tipo_imagen)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoImagen= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoImagen.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_imagen,ClienteImagenConstantesFunciones.IDTIPOIMAGEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoImagen);

			ClienteImagenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoImagen","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clienteimagens=clienteimagenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteImagenConstantesFunciones.refrescarForeignKeysDescripcionesClienteImagen(this.clienteimagens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClienteImagensFK_IdTipoImagenPersonaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_imagen_persona)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteImagen.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoImagenPersona= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoImagenPersona.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_imagen_persona,ClienteImagenConstantesFunciones.IDTIPOIMAGENPERSONA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoImagenPersona);

			ClienteImagenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoImagenPersona","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clienteimagens=clienteimagenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteImagenConstantesFunciones.refrescarForeignKeysDescripcionesClienteImagen(this.clienteimagens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClienteImagensFK_IdTipoImagenPersona(String sFinalQuery,Pagination pagination,Long id_tipo_imagen_persona)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoImagenPersona= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoImagenPersona.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_imagen_persona,ClienteImagenConstantesFunciones.IDTIPOIMAGENPERSONA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoImagenPersona);

			ClienteImagenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoImagenPersona","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clienteimagens=clienteimagenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteImagenConstantesFunciones.refrescarForeignKeysDescripcionesClienteImagen(this.clienteimagens);
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
			if(ClienteImagenConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ClienteImagenDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ClienteImagen clienteimagen,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ClienteImagenConstantesFunciones.ISCONAUDITORIA) {
				if(clienteimagen.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ClienteImagenDataAccess.TABLENAME, clienteimagen.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ClienteImagenConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ClienteImagenLogic.registrarAuditoriaDetallesClienteImagen(connexion,clienteimagen,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(clienteimagen.getIsDeleted()) {
					/*if(!clienteimagen.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ClienteImagenDataAccess.TABLENAME, clienteimagen.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ClienteImagenLogic.registrarAuditoriaDetallesClienteImagen(connexion,clienteimagen,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ClienteImagenDataAccess.TABLENAME, clienteimagen.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(clienteimagen.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ClienteImagenDataAccess.TABLENAME, clienteimagen.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ClienteImagenConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ClienteImagenLogic.registrarAuditoriaDetallesClienteImagen(connexion,clienteimagen,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesClienteImagen(Connexion connexion,ClienteImagen clienteimagen)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(clienteimagen.getIsNew()||!clienteimagen.getid_cliente().equals(clienteimagen.getClienteImagenOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clienteimagen.getClienteImagenOriginal().getid_cliente()!=null)
				{
					strValorActual=clienteimagen.getClienteImagenOriginal().getid_cliente().toString();
				}
				if(clienteimagen.getid_cliente()!=null)
				{
					strValorNuevo=clienteimagen.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteImagenConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(clienteimagen.getIsNew()||!clienteimagen.getid_tipo_imagen_persona().equals(clienteimagen.getClienteImagenOriginal().getid_tipo_imagen_persona()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clienteimagen.getClienteImagenOriginal().getid_tipo_imagen_persona()!=null)
				{
					strValorActual=clienteimagen.getClienteImagenOriginal().getid_tipo_imagen_persona().toString();
				}
				if(clienteimagen.getid_tipo_imagen_persona()!=null)
				{
					strValorNuevo=clienteimagen.getid_tipo_imagen_persona().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteImagenConstantesFunciones.IDTIPOIMAGENPERSONA,strValorActual,strValorNuevo);
			}	
			
			if(clienteimagen.getIsNew()||!clienteimagen.getid_tipo_imagen().equals(clienteimagen.getClienteImagenOriginal().getid_tipo_imagen()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clienteimagen.getClienteImagenOriginal().getid_tipo_imagen()!=null)
				{
					strValorActual=clienteimagen.getClienteImagenOriginal().getid_tipo_imagen().toString();
				}
				if(clienteimagen.getid_tipo_imagen()!=null)
				{
					strValorNuevo=clienteimagen.getid_tipo_imagen().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteImagenConstantesFunciones.IDTIPOIMAGEN,strValorActual,strValorNuevo);
			}	
			
			if(clienteimagen.getIsNew()||!clienteimagen.getnombre().equals(clienteimagen.getClienteImagenOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clienteimagen.getClienteImagenOriginal().getnombre()!=null)
				{
					strValorActual=clienteimagen.getClienteImagenOriginal().getnombre();
				}
				if(clienteimagen.getnombre()!=null)
				{
					strValorNuevo=clienteimagen.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteImagenConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(clienteimagen.getIsNew()||!clienteimagen.getimagen().equals(clienteimagen.getClienteImagenOriginal().getimagen()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clienteimagen.getClienteImagenOriginal().getimagen()!=null)
				{
					strValorActual=clienteimagen.getClienteImagenOriginal().getimagen().toString();
				}
				if(clienteimagen.getimagen()!=null)
				{
					strValorNuevo=clienteimagen.getimagen().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteImagenConstantesFunciones.IMAGEN,strValorActual,strValorNuevo);
			}	
			
			if(clienteimagen.getIsNew()||!clienteimagen.getdescripcion().equals(clienteimagen.getClienteImagenOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clienteimagen.getClienteImagenOriginal().getdescripcion()!=null)
				{
					strValorActual=clienteimagen.getClienteImagenOriginal().getdescripcion();
				}
				if(clienteimagen.getdescripcion()!=null)
				{
					strValorNuevo=clienteimagen.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteImagenConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfClienteImagen(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ClienteImagenConstantesFunciones.getClassesForeignKeysOfClienteImagen(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfClienteImagen(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ClienteImagenConstantesFunciones.getClassesRelationshipsOfClienteImagen(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

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
import com.bydan.erp.cartera.util.ClienteRetencionConstantesFunciones;
import com.bydan.erp.cartera.util.ClienteRetencionParameterReturnGeneral;
//import com.bydan.erp.cartera.util.ClienteRetencionParameterGeneral;
import com.bydan.erp.cartera.business.entity.ClienteRetencion;
import com.bydan.erp.cartera.business.logic.ClienteRetencionLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;








@SuppressWarnings("unused")
public class ClienteRetencionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ClienteRetencionLogic.class);
	
	protected ClienteRetencionDataAccess clienteretencionDataAccess; 	
	protected ClienteRetencion clienteretencion;
	protected List<ClienteRetencion> clienteretencions;
	protected Object clienteretencionObject;	
	protected List<Object> clienteretencionsObject;
	
	public static ClassValidator<ClienteRetencion> clienteretencionValidator = new ClassValidator<ClienteRetencion>(ClienteRetencion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ClienteRetencionLogicAdditional clienteretencionLogicAdditional=null;
	
	public ClienteRetencionLogicAdditional getClienteRetencionLogicAdditional() {
		return this.clienteretencionLogicAdditional;
	}
	
	public void setClienteRetencionLogicAdditional(ClienteRetencionLogicAdditional clienteretencionLogicAdditional) {
		try {
			this.clienteretencionLogicAdditional=clienteretencionLogicAdditional;
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
	
	
	
	
	public  ClienteRetencionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.clienteretencionDataAccess = new ClienteRetencionDataAccess();
			
			this.clienteretencions= new ArrayList<ClienteRetencion>();
			this.clienteretencion= new ClienteRetencion();
			
			this.clienteretencionObject=new Object();
			this.clienteretencionsObject=new ArrayList<Object>();
				
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
			
			this.clienteretencionDataAccess.setConnexionType(this.connexionType);
			this.clienteretencionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ClienteRetencionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.clienteretencionDataAccess = new ClienteRetencionDataAccess();
			this.clienteretencions= new ArrayList<ClienteRetencion>();
			this.clienteretencion= new ClienteRetencion();
			this.clienteretencionObject=new Object();
			this.clienteretencionsObject=new ArrayList<Object>();
			
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
			
			this.clienteretencionDataAccess.setConnexionType(this.connexionType);
			this.clienteretencionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ClienteRetencion getClienteRetencion() throws Exception {	
		ClienteRetencionLogicAdditional.checkClienteRetencionToGet(clienteretencion,this.datosCliente,this.arrDatoGeneral);
		ClienteRetencionLogicAdditional.updateClienteRetencionToGet(clienteretencion,this.arrDatoGeneral);
		
		return clienteretencion;
	}
		
	public void setClienteRetencion(ClienteRetencion newClienteRetencion) {
		this.clienteretencion = newClienteRetencion;
	}
	
	public ClienteRetencionDataAccess getClienteRetencionDataAccess() {
		return clienteretencionDataAccess;
	}
	
	public void setClienteRetencionDataAccess(ClienteRetencionDataAccess newclienteretencionDataAccess) {
		this.clienteretencionDataAccess = newclienteretencionDataAccess;
	}
	
	public List<ClienteRetencion> getClienteRetencions() throws Exception {		
		this.quitarClienteRetencionsNulos();
		
		ClienteRetencionLogicAdditional.checkClienteRetencionToGets(clienteretencions,this.datosCliente,this.arrDatoGeneral);
		
		for (ClienteRetencion clienteretencionLocal: clienteretencions ) {
			ClienteRetencionLogicAdditional.updateClienteRetencionToGet(clienteretencionLocal,this.arrDatoGeneral);
		}
		
		return clienteretencions;
	}
	
	public void setClienteRetencions(List<ClienteRetencion> newClienteRetencions) {
		this.clienteretencions = newClienteRetencions;
	}
	
	public Object getClienteRetencionObject() {	
		this.clienteretencionObject=this.clienteretencionDataAccess.getEntityObject();
		return this.clienteretencionObject;
	}
		
	public void setClienteRetencionObject(Object newClienteRetencionObject) {
		this.clienteretencionObject = newClienteRetencionObject;
	}
	
	public List<Object> getClienteRetencionsObject() {		
		this.clienteretencionsObject=this.clienteretencionDataAccess.getEntitiesObject();
		return this.clienteretencionsObject;
	}
		
	public void setClienteRetencionsObject(List<Object> newClienteRetencionsObject) {
		this.clienteretencionsObject = newClienteRetencionsObject;
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
		
		if(this.clienteretencionDataAccess!=null) {
			this.clienteretencionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteRetencion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			clienteretencionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			clienteretencionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		clienteretencion = new  ClienteRetencion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteRetencion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			clienteretencion=clienteretencionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.clienteretencion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencion);
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
		clienteretencion = new  ClienteRetencion();
		  		  
        try {
			
			clienteretencion=clienteretencionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.clienteretencion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		clienteretencion = new  ClienteRetencion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteRetencion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			clienteretencion=clienteretencionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.clienteretencion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencion);
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
		clienteretencion = new  ClienteRetencion();
		  		  
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
		clienteretencion = new  ClienteRetencion();
		  		  
        try {
			
			clienteretencion=clienteretencionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.clienteretencion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		clienteretencion = new  ClienteRetencion();
		  		  
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
		clienteretencion = new  ClienteRetencion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteRetencion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =clienteretencionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		clienteretencion = new  ClienteRetencion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=clienteretencionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		clienteretencion = new  ClienteRetencion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteRetencion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =clienteretencionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		clienteretencion = new  ClienteRetencion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=clienteretencionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		clienteretencion = new  ClienteRetencion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteRetencion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =clienteretencionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		clienteretencion = new  ClienteRetencion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=clienteretencionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		clienteretencions = new  ArrayList<ClienteRetencion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteRetencion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clienteretencions=clienteretencionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarClienteRetencion(clienteretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencions);
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
		clienteretencions = new  ArrayList<ClienteRetencion>();
		  		  
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
		clienteretencions = new  ArrayList<ClienteRetencion>();
		  		  
        try {			
			ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clienteretencions=clienteretencionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarClienteRetencion(clienteretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		clienteretencions = new  ArrayList<ClienteRetencion>();
		  		  
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
		clienteretencions = new  ArrayList<ClienteRetencion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteRetencion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clienteretencions=clienteretencionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarClienteRetencion(clienteretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencions);
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
		clienteretencions = new  ArrayList<ClienteRetencion>();
		  		  
        try {
			ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clienteretencions=clienteretencionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarClienteRetencion(clienteretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencions);
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
		clienteretencions = new  ArrayList<ClienteRetencion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteRetencion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clienteretencions=clienteretencionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarClienteRetencion(clienteretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencions);
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
		clienteretencions = new  ArrayList<ClienteRetencion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clienteretencions=clienteretencionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarClienteRetencion(clienteretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		clienteretencion = new  ClienteRetencion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteRetencion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clienteretencion=clienteretencionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarClienteRetencion(clienteretencion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencion);
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
		clienteretencion = new  ClienteRetencion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clienteretencion=clienteretencionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarClienteRetencion(clienteretencion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		clienteretencions = new  ArrayList<ClienteRetencion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteRetencion.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clienteretencions=clienteretencionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarClienteRetencion(clienteretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencions);
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
		clienteretencions = new  ArrayList<ClienteRetencion>();
		  		  
        try {
			ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clienteretencions=clienteretencionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarClienteRetencion(clienteretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosClienteRetencionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		clienteretencions = new  ArrayList<ClienteRetencion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteRetencion.class.getSimpleName()+"-getTodosClienteRetencionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clienteretencions=clienteretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarClienteRetencion(clienteretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencions);
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
	
	public  void  getTodosClienteRetencions(String sFinalQuery,Pagination pagination)throws Exception {
		clienteretencions = new  ArrayList<ClienteRetencion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clienteretencions=clienteretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarClienteRetencion(clienteretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarClienteRetencion(ClienteRetencion clienteretencion) throws Exception {
		Boolean estaValidado=false;
		
		if(clienteretencion.getIsNew() || clienteretencion.getIsChanged()) { 
			this.invalidValues = clienteretencionValidator.getInvalidValues(clienteretencion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(clienteretencion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarClienteRetencion(List<ClienteRetencion> ClienteRetencions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ClienteRetencion clienteretencionLocal:clienteretencions) {				
			estaValidadoObjeto=this.validarGuardarClienteRetencion(clienteretencionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarClienteRetencion(List<ClienteRetencion> ClienteRetencions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarClienteRetencion(clienteretencions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarClienteRetencion(ClienteRetencion ClienteRetencion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarClienteRetencion(clienteretencion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ClienteRetencion clienteretencion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+clienteretencion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ClienteRetencionConstantesFunciones.getClienteRetencionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"clienteretencion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ClienteRetencionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ClienteRetencionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveClienteRetencionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteRetencion.class.getSimpleName()+"-saveClienteRetencionWithConnection");connexion.begin();			
			
			ClienteRetencionLogicAdditional.checkClienteRetencionToSave(this.clienteretencion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ClienteRetencionLogicAdditional.updateClienteRetencionToSave(this.clienteretencion,this.arrDatoGeneral);
			
			ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.clienteretencion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowClienteRetencion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarClienteRetencion(this.clienteretencion)) {
				ClienteRetencionDataAccess.save(this.clienteretencion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.clienteretencion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ClienteRetencionLogicAdditional.checkClienteRetencionToSaveAfter(this.clienteretencion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowClienteRetencion();
			
			connexion.commit();			
			
			if(this.clienteretencion.getIsDeleted()) {
				this.clienteretencion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveClienteRetencion()throws Exception {	
		try {	
			
			ClienteRetencionLogicAdditional.checkClienteRetencionToSave(this.clienteretencion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ClienteRetencionLogicAdditional.updateClienteRetencionToSave(this.clienteretencion,this.arrDatoGeneral);
			
			ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.clienteretencion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarClienteRetencion(this.clienteretencion)) {			
				ClienteRetencionDataAccess.save(this.clienteretencion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.clienteretencion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ClienteRetencionLogicAdditional.checkClienteRetencionToSaveAfter(this.clienteretencion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.clienteretencion.getIsDeleted()) {
				this.clienteretencion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveClienteRetencionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteRetencion.class.getSimpleName()+"-saveClienteRetencionsWithConnection");connexion.begin();			
			
			ClienteRetencionLogicAdditional.checkClienteRetencionToSaves(clienteretencions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowClienteRetencions();
			
			Boolean validadoTodosClienteRetencion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ClienteRetencion clienteretencionLocal:clienteretencions) {		
				if(clienteretencionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ClienteRetencionLogicAdditional.updateClienteRetencionToSave(clienteretencionLocal,this.arrDatoGeneral);
	        	
				ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),clienteretencionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarClienteRetencion(clienteretencionLocal)) {
					ClienteRetencionDataAccess.save(clienteretencionLocal, connexion);				
				} else {
					validadoTodosClienteRetencion=false;
				}
			}
			
			if(!validadoTodosClienteRetencion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ClienteRetencionLogicAdditional.checkClienteRetencionToSavesAfter(clienteretencions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowClienteRetencions();
			
			connexion.commit();		
			
			this.quitarClienteRetencionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveClienteRetencions()throws Exception {				
		 try {	
			ClienteRetencionLogicAdditional.checkClienteRetencionToSaves(clienteretencions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosClienteRetencion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ClienteRetencion clienteretencionLocal:clienteretencions) {				
				if(clienteretencionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ClienteRetencionLogicAdditional.updateClienteRetencionToSave(clienteretencionLocal,this.arrDatoGeneral);
	        	
				ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),clienteretencionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarClienteRetencion(clienteretencionLocal)) {				
					ClienteRetencionDataAccess.save(clienteretencionLocal, connexion);				
				} else {
					validadoTodosClienteRetencion=false;
				}
			}
			
			if(!validadoTodosClienteRetencion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ClienteRetencionLogicAdditional.checkClienteRetencionToSavesAfter(clienteretencions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarClienteRetencionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ClienteRetencionParameterReturnGeneral procesarAccionClienteRetencions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ClienteRetencion> clienteretencions,ClienteRetencionParameterReturnGeneral clienteretencionParameterGeneral)throws Exception {
		 try {	
			ClienteRetencionParameterReturnGeneral clienteretencionReturnGeneral=new ClienteRetencionParameterReturnGeneral();
	
			ClienteRetencionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,clienteretencions,clienteretencionParameterGeneral,clienteretencionReturnGeneral);
			
			return clienteretencionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ClienteRetencionParameterReturnGeneral procesarAccionClienteRetencionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ClienteRetencion> clienteretencions,ClienteRetencionParameterReturnGeneral clienteretencionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteRetencion.class.getSimpleName()+"-procesarAccionClienteRetencionsWithConnection");connexion.begin();			
			
			ClienteRetencionParameterReturnGeneral clienteretencionReturnGeneral=new ClienteRetencionParameterReturnGeneral();
	
			ClienteRetencionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,clienteretencions,clienteretencionParameterGeneral,clienteretencionReturnGeneral);
			
			this.connexion.commit();
			
			return clienteretencionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ClienteRetencionParameterReturnGeneral procesarEventosClienteRetencions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ClienteRetencion> clienteretencions,ClienteRetencion clienteretencion,ClienteRetencionParameterReturnGeneral clienteretencionParameterGeneral,Boolean isEsNuevoClienteRetencion,ArrayList<Classe> clases)throws Exception {
		 try {	
			ClienteRetencionParameterReturnGeneral clienteretencionReturnGeneral=new ClienteRetencionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				clienteretencionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ClienteRetencionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,clienteretencions,clienteretencion,clienteretencionParameterGeneral,clienteretencionReturnGeneral,isEsNuevoClienteRetencion,clases);
			
			return clienteretencionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ClienteRetencionParameterReturnGeneral procesarEventosClienteRetencionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ClienteRetencion> clienteretencions,ClienteRetencion clienteretencion,ClienteRetencionParameterReturnGeneral clienteretencionParameterGeneral,Boolean isEsNuevoClienteRetencion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteRetencion.class.getSimpleName()+"-procesarEventosClienteRetencionsWithConnection");connexion.begin();			
			
			ClienteRetencionParameterReturnGeneral clienteretencionReturnGeneral=new ClienteRetencionParameterReturnGeneral();
	
			clienteretencionReturnGeneral.setClienteRetencion(clienteretencion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				clienteretencionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ClienteRetencionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,clienteretencions,clienteretencion,clienteretencionParameterGeneral,clienteretencionReturnGeneral,isEsNuevoClienteRetencion,clases);
			
			this.connexion.commit();
			
			return clienteretencionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ClienteRetencionParameterReturnGeneral procesarImportacionClienteRetencionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ClienteRetencionParameterReturnGeneral clienteretencionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteRetencion.class.getSimpleName()+"-procesarImportacionClienteRetencionsWithConnection");connexion.begin();			
			
			ClienteRetencionParameterReturnGeneral clienteretencionReturnGeneral=new ClienteRetencionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.clienteretencions=new ArrayList<ClienteRetencion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.clienteretencion=new ClienteRetencion();
				
				
				if(conColumnasBase) {this.clienteretencion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.clienteretencion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.clienteretencion.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.clienteretencion.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.clienteretencion.setbase_imponible(Double.parseDouble(arrColumnas[iColumn++]));
				this.clienteretencion.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				this.clienteretencion.setnumero_retencion(arrColumnas[iColumn++]);
				this.clienteretencion.setdescripcion(arrColumnas[iColumn++]);
				
				this.clienteretencions.add(this.clienteretencion);
			}
			
			this.saveClienteRetencions();
			
			this.connexion.commit();
			
			clienteretencionReturnGeneral.setConRetornoEstaProcesado(true);
			clienteretencionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return clienteretencionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarClienteRetencionsEliminados() throws Exception {				
		
		List<ClienteRetencion> clienteretencionsAux= new ArrayList<ClienteRetencion>();
		
		for(ClienteRetencion clienteretencion:clienteretencions) {
			if(!clienteretencion.getIsDeleted()) {
				clienteretencionsAux.add(clienteretencion);
			}
		}
		
		clienteretencions=clienteretencionsAux;
	}
	
	public void quitarClienteRetencionsNulos() throws Exception {				
		
		List<ClienteRetencion> clienteretencionsAux= new ArrayList<ClienteRetencion>();
		
		for(ClienteRetencion clienteretencion : this.clienteretencions) {
			if(clienteretencion==null) {
				clienteretencionsAux.add(clienteretencion);
			}
		}
		
		//this.clienteretencions=clienteretencionsAux;
		
		this.clienteretencions.removeAll(clienteretencionsAux);
	}
	
	public void getSetVersionRowClienteRetencionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(clienteretencion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((clienteretencion.getIsDeleted() || (clienteretencion.getIsChanged()&&!clienteretencion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=clienteretencionDataAccess.getSetVersionRowClienteRetencion(connexion,clienteretencion.getId());
				
				if(!clienteretencion.getVersionRow().equals(timestamp)) {	
					clienteretencion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				clienteretencion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowClienteRetencion()throws Exception {	
		
		if(clienteretencion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((clienteretencion.getIsDeleted() || (clienteretencion.getIsChanged()&&!clienteretencion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=clienteretencionDataAccess.getSetVersionRowClienteRetencion(connexion,clienteretencion.getId());
			
			try {							
				if(!clienteretencion.getVersionRow().equals(timestamp)) {	
					clienteretencion.setVersionRow(timestamp);
				}
				
				clienteretencion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowClienteRetencionsWithConnection()throws Exception {	
		if(clienteretencions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ClienteRetencion clienteretencionAux:clienteretencions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(clienteretencionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(clienteretencionAux.getIsDeleted() || (clienteretencionAux.getIsChanged()&&!clienteretencionAux.getIsNew())) {
						
						timestamp=clienteretencionDataAccess.getSetVersionRowClienteRetencion(connexion,clienteretencionAux.getId());
						
						if(!clienteretencion.getVersionRow().equals(timestamp)) {	
							clienteretencionAux.setVersionRow(timestamp);
						}
								
						clienteretencionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowClienteRetencions()throws Exception {	
		if(clienteretencions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ClienteRetencion clienteretencionAux:clienteretencions) {
					if(clienteretencionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(clienteretencionAux.getIsDeleted() || (clienteretencionAux.getIsChanged()&&!clienteretencionAux.getIsNew())) {
						
						timestamp=clienteretencionDataAccess.getSetVersionRowClienteRetencion(connexion,clienteretencionAux.getId());
						
						if(!clienteretencionAux.getVersionRow().equals(timestamp)) {	
							clienteretencionAux.setVersionRow(timestamp);
						}
						
													
						clienteretencionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ClienteRetencionParameterReturnGeneral cargarCombosLoteForeignKeyClienteRetencionWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalCliente,String finalQueryGlobalFactura,String finalQueryGlobalTransaccion,String finalQueryGlobalTipoRetencion,String finalQueryGlobalAsientoContable,String finalQueryGlobalCuentaContableClienteRetencion,String finalQueryGlobalEstadoRetencion) throws Exception {
		ClienteRetencionParameterReturnGeneral  clienteretencionReturnGeneral =new ClienteRetencionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteRetencion.class.getSimpleName()+"-cargarCombosLoteForeignKeyClienteRetencionWithConnection");connexion.begin();
			
			clienteretencionReturnGeneral =new ClienteRetencionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			clienteretencionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			clienteretencionReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			clienteretencionReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			clienteretencionReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			clienteretencionReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			clienteretencionReturnGeneral.setmessForeignKey(messForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			clienteretencionReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			clienteretencionReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<Transaccion> transaccionsForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			transaccionLogic.setConnexion(this.connexion);
			transaccionLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion.equals("NONE")) {
				transaccionLogic.getTodosTransaccions(finalQueryGlobalTransaccion,new Pagination());
				transaccionsForeignKey=transaccionLogic.getTransaccions();
			}

			clienteretencionReturnGeneral.settransaccionsForeignKey(transaccionsForeignKey);


			List<TipoRetencion> tiporetencionsForeignKey=new ArrayList<TipoRetencion>();
			TipoRetencionLogic tiporetencionLogic=new TipoRetencionLogic();
			tiporetencionLogic.setConnexion(this.connexion);
			tiporetencionLogic.getTipoRetencionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencion.equals("NONE")) {
				tiporetencionLogic.getTodosTipoRetencions(finalQueryGlobalTipoRetencion,new Pagination());
				tiporetencionsForeignKey=tiporetencionLogic.getTipoRetencions();
			}

			clienteretencionReturnGeneral.settiporetencionsForeignKey(tiporetencionsForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			clienteretencionReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);


			List<CuentaContable> cuentacontableclienteretencionsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableclienteretencionLogic=new CuentaContableLogic();
			cuentacontableclienteretencionLogic.setConnexion(this.connexion);
			cuentacontableclienteretencionLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableClienteRetencion.equals("NONE")) {
				cuentacontableclienteretencionLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableClienteRetencion,new Pagination());
				cuentacontableclienteretencionsForeignKey=cuentacontableclienteretencionLogic.getCuentaContables();
			}

			clienteretencionReturnGeneral.setcuentacontableclienteretencionsForeignKey(cuentacontableclienteretencionsForeignKey);


			List<EstadoRetencion> estadoretencionsForeignKey=new ArrayList<EstadoRetencion>();
			EstadoRetencionLogic estadoretencionLogic=new EstadoRetencionLogic();
			estadoretencionLogic.setConnexion(this.connexion);
			estadoretencionLogic.getEstadoRetencionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoRetencion.equals("NONE")) {
				estadoretencionLogic.getTodosEstadoRetencions(finalQueryGlobalEstadoRetencion,new Pagination());
				estadoretencionsForeignKey=estadoretencionLogic.getEstadoRetencions();
			}

			clienteretencionReturnGeneral.setestadoretencionsForeignKey(estadoretencionsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return clienteretencionReturnGeneral;
	}
	
	public ClienteRetencionParameterReturnGeneral cargarCombosLoteForeignKeyClienteRetencion(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalCliente,String finalQueryGlobalFactura,String finalQueryGlobalTransaccion,String finalQueryGlobalTipoRetencion,String finalQueryGlobalAsientoContable,String finalQueryGlobalCuentaContableClienteRetencion,String finalQueryGlobalEstadoRetencion) throws Exception {
		ClienteRetencionParameterReturnGeneral  clienteretencionReturnGeneral =new ClienteRetencionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			clienteretencionReturnGeneral =new ClienteRetencionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			clienteretencionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			clienteretencionReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			clienteretencionReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			clienteretencionReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			clienteretencionReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			clienteretencionReturnGeneral.setmessForeignKey(messForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			clienteretencionReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			clienteretencionReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<Transaccion> transaccionsForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			transaccionLogic.setConnexion(this.connexion);
			transaccionLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion.equals("NONE")) {
				transaccionLogic.getTodosTransaccions(finalQueryGlobalTransaccion,new Pagination());
				transaccionsForeignKey=transaccionLogic.getTransaccions();
			}

			clienteretencionReturnGeneral.settransaccionsForeignKey(transaccionsForeignKey);


			List<TipoRetencion> tiporetencionsForeignKey=new ArrayList<TipoRetencion>();
			TipoRetencionLogic tiporetencionLogic=new TipoRetencionLogic();
			tiporetencionLogic.setConnexion(this.connexion);
			tiporetencionLogic.getTipoRetencionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencion.equals("NONE")) {
				tiporetencionLogic.getTodosTipoRetencions(finalQueryGlobalTipoRetencion,new Pagination());
				tiporetencionsForeignKey=tiporetencionLogic.getTipoRetencions();
			}

			clienteretencionReturnGeneral.settiporetencionsForeignKey(tiporetencionsForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			clienteretencionReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);


			List<CuentaContable> cuentacontableclienteretencionsForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableclienteretencionLogic=new CuentaContableLogic();
			cuentacontableclienteretencionLogic.setConnexion(this.connexion);
			cuentacontableclienteretencionLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableClienteRetencion.equals("NONE")) {
				cuentacontableclienteretencionLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableClienteRetencion,new Pagination());
				cuentacontableclienteretencionsForeignKey=cuentacontableclienteretencionLogic.getCuentaContables();
			}

			clienteretencionReturnGeneral.setcuentacontableclienteretencionsForeignKey(cuentacontableclienteretencionsForeignKey);


			List<EstadoRetencion> estadoretencionsForeignKey=new ArrayList<EstadoRetencion>();
			EstadoRetencionLogic estadoretencionLogic=new EstadoRetencionLogic();
			estadoretencionLogic.setConnexion(this.connexion);
			estadoretencionLogic.getEstadoRetencionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoRetencion.equals("NONE")) {
				estadoretencionLogic.getTodosEstadoRetencions(finalQueryGlobalEstadoRetencion,new Pagination());
				estadoretencionsForeignKey=estadoretencionLogic.getEstadoRetencions();
			}

			clienteretencionReturnGeneral.setestadoretencionsForeignKey(estadoretencionsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return clienteretencionReturnGeneral;
	}
	
	
	public void deepLoad(ClienteRetencion clienteretencion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ClienteRetencionLogicAdditional.updateClienteRetencionToGet(clienteretencion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		clienteretencion.setEmpresa(clienteretencionDataAccess.getEmpresa(connexion,clienteretencion));
		clienteretencion.setSucursal(clienteretencionDataAccess.getSucursal(connexion,clienteretencion));
		clienteretencion.setEjercicio(clienteretencionDataAccess.getEjercicio(connexion,clienteretencion));
		clienteretencion.setPeriodo(clienteretencionDataAccess.getPeriodo(connexion,clienteretencion));
		clienteretencion.setAnio(clienteretencionDataAccess.getAnio(connexion,clienteretencion));
		clienteretencion.setMes(clienteretencionDataAccess.getMes(connexion,clienteretencion));
		clienteretencion.setCliente(clienteretencionDataAccess.getCliente(connexion,clienteretencion));
		clienteretencion.setFactura(clienteretencionDataAccess.getFactura(connexion,clienteretencion));
		clienteretencion.setTransaccion(clienteretencionDataAccess.getTransaccion(connexion,clienteretencion));
		clienteretencion.setTipoRetencion(clienteretencionDataAccess.getTipoRetencion(connexion,clienteretencion));
		clienteretencion.setAsientoContable(clienteretencionDataAccess.getAsientoContable(connexion,clienteretencion));
		clienteretencion.setCuentaContableClienteRetencion(clienteretencionDataAccess.getCuentaContableClienteRetencion(connexion,clienteretencion));
		clienteretencion.setEstadoRetencion(clienteretencionDataAccess.getEstadoRetencion(connexion,clienteretencion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				clienteretencion.setEmpresa(clienteretencionDataAccess.getEmpresa(connexion,clienteretencion));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				clienteretencion.setSucursal(clienteretencionDataAccess.getSucursal(connexion,clienteretencion));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				clienteretencion.setEjercicio(clienteretencionDataAccess.getEjercicio(connexion,clienteretencion));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				clienteretencion.setPeriodo(clienteretencionDataAccess.getPeriodo(connexion,clienteretencion));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				clienteretencion.setAnio(clienteretencionDataAccess.getAnio(connexion,clienteretencion));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				clienteretencion.setMes(clienteretencionDataAccess.getMes(connexion,clienteretencion));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				clienteretencion.setCliente(clienteretencionDataAccess.getCliente(connexion,clienteretencion));
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				clienteretencion.setFactura(clienteretencionDataAccess.getFactura(connexion,clienteretencion));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				clienteretencion.setTransaccion(clienteretencionDataAccess.getTransaccion(connexion,clienteretencion));
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				clienteretencion.setTipoRetencion(clienteretencionDataAccess.getTipoRetencion(connexion,clienteretencion));
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				clienteretencion.setAsientoContable(clienteretencionDataAccess.getAsientoContable(connexion,clienteretencion));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				clienteretencion.setCuentaContableClienteRetencion(clienteretencionDataAccess.getCuentaContableClienteRetencion(connexion,clienteretencion));
				continue;
			}

			if(clas.clas.equals(EstadoRetencion.class)) {
				clienteretencion.setEstadoRetencion(clienteretencionDataAccess.getEstadoRetencion(connexion,clienteretencion));
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
			clienteretencion.setEmpresa(clienteretencionDataAccess.getEmpresa(connexion,clienteretencion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			clienteretencion.setSucursal(clienteretencionDataAccess.getSucursal(connexion,clienteretencion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			clienteretencion.setEjercicio(clienteretencionDataAccess.getEjercicio(connexion,clienteretencion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			clienteretencion.setPeriodo(clienteretencionDataAccess.getPeriodo(connexion,clienteretencion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			clienteretencion.setAnio(clienteretencionDataAccess.getAnio(connexion,clienteretencion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			clienteretencion.setMes(clienteretencionDataAccess.getMes(connexion,clienteretencion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			clienteretencion.setCliente(clienteretencionDataAccess.getCliente(connexion,clienteretencion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			clienteretencion.setFactura(clienteretencionDataAccess.getFactura(connexion,clienteretencion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			clienteretencion.setTransaccion(clienteretencionDataAccess.getTransaccion(connexion,clienteretencion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			clienteretencion.setTipoRetencion(clienteretencionDataAccess.getTipoRetencion(connexion,clienteretencion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			clienteretencion.setAsientoContable(clienteretencionDataAccess.getAsientoContable(connexion,clienteretencion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			clienteretencion.setCuentaContableClienteRetencion(clienteretencionDataAccess.getCuentaContableClienteRetencion(connexion,clienteretencion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			clienteretencion.setEstadoRetencion(clienteretencionDataAccess.getEstadoRetencion(connexion,clienteretencion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		clienteretencion.setEmpresa(clienteretencionDataAccess.getEmpresa(connexion,clienteretencion));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(clienteretencion.getEmpresa(),isDeep,deepLoadType,clases);
				
		clienteretencion.setSucursal(clienteretencionDataAccess.getSucursal(connexion,clienteretencion));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(clienteretencion.getSucursal(),isDeep,deepLoadType,clases);
				
		clienteretencion.setEjercicio(clienteretencionDataAccess.getEjercicio(connexion,clienteretencion));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(clienteretencion.getEjercicio(),isDeep,deepLoadType,clases);
				
		clienteretencion.setPeriodo(clienteretencionDataAccess.getPeriodo(connexion,clienteretencion));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(clienteretencion.getPeriodo(),isDeep,deepLoadType,clases);
				
		clienteretencion.setAnio(clienteretencionDataAccess.getAnio(connexion,clienteretencion));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(clienteretencion.getAnio(),isDeep,deepLoadType,clases);
				
		clienteretencion.setMes(clienteretencionDataAccess.getMes(connexion,clienteretencion));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(clienteretencion.getMes(),isDeep,deepLoadType,clases);
				
		clienteretencion.setCliente(clienteretencionDataAccess.getCliente(connexion,clienteretencion));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(clienteretencion.getCliente(),isDeep,deepLoadType,clases);
				
		clienteretencion.setFactura(clienteretencionDataAccess.getFactura(connexion,clienteretencion));
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(clienteretencion.getFactura(),isDeep,deepLoadType,clases);
				
		clienteretencion.setTransaccion(clienteretencionDataAccess.getTransaccion(connexion,clienteretencion));
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(clienteretencion.getTransaccion(),isDeep,deepLoadType,clases);
				
		clienteretencion.setTipoRetencion(clienteretencionDataAccess.getTipoRetencion(connexion,clienteretencion));
		TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
		tiporetencionLogic.deepLoad(clienteretencion.getTipoRetencion(),isDeep,deepLoadType,clases);
				
		clienteretencion.setAsientoContable(clienteretencionDataAccess.getAsientoContable(connexion,clienteretencion));
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(clienteretencion.getAsientoContable(),isDeep,deepLoadType,clases);
				
		clienteretencion.setCuentaContableClienteRetencion(clienteretencionDataAccess.getCuentaContableClienteRetencion(connexion,clienteretencion));
		CuentaContableLogic cuentacontableclienteretencionLogic= new CuentaContableLogic(connexion);
		cuentacontableclienteretencionLogic.deepLoad(clienteretencion.getCuentaContableClienteRetencion(),isDeep,deepLoadType,clases);
				
		clienteretencion.setEstadoRetencion(clienteretencionDataAccess.getEstadoRetencion(connexion,clienteretencion));
		EstadoRetencionLogic estadoretencionLogic= new EstadoRetencionLogic(connexion);
		estadoretencionLogic.deepLoad(clienteretencion.getEstadoRetencion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				clienteretencion.setEmpresa(clienteretencionDataAccess.getEmpresa(connexion,clienteretencion));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(clienteretencion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				clienteretencion.setSucursal(clienteretencionDataAccess.getSucursal(connexion,clienteretencion));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(clienteretencion.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				clienteretencion.setEjercicio(clienteretencionDataAccess.getEjercicio(connexion,clienteretencion));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(clienteretencion.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				clienteretencion.setPeriodo(clienteretencionDataAccess.getPeriodo(connexion,clienteretencion));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(clienteretencion.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				clienteretencion.setAnio(clienteretencionDataAccess.getAnio(connexion,clienteretencion));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(clienteretencion.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				clienteretencion.setMes(clienteretencionDataAccess.getMes(connexion,clienteretencion));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(clienteretencion.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				clienteretencion.setCliente(clienteretencionDataAccess.getCliente(connexion,clienteretencion));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(clienteretencion.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				clienteretencion.setFactura(clienteretencionDataAccess.getFactura(connexion,clienteretencion));
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepLoad(clienteretencion.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				clienteretencion.setTransaccion(clienteretencionDataAccess.getTransaccion(connexion,clienteretencion));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(clienteretencion.getTransaccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				clienteretencion.setTipoRetencion(clienteretencionDataAccess.getTipoRetencion(connexion,clienteretencion));
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepLoad(clienteretencion.getTipoRetencion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				clienteretencion.setAsientoContable(clienteretencionDataAccess.getAsientoContable(connexion,clienteretencion));
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepLoad(clienteretencion.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				clienteretencion.setCuentaContableClienteRetencion(clienteretencionDataAccess.getCuentaContableClienteRetencion(connexion,clienteretencion));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(clienteretencion.getCuentaContableClienteRetencion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoRetencion.class)) {
				clienteretencion.setEstadoRetencion(clienteretencionDataAccess.getEstadoRetencion(connexion,clienteretencion));
				EstadoRetencionLogic estadoretencionLogic= new EstadoRetencionLogic(connexion);
				estadoretencionLogic.deepLoad(clienteretencion.getEstadoRetencion(),isDeep,deepLoadType,clases);				
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
			clienteretencion.setEmpresa(clienteretencionDataAccess.getEmpresa(connexion,clienteretencion));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(clienteretencion.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			clienteretencion.setSucursal(clienteretencionDataAccess.getSucursal(connexion,clienteretencion));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(clienteretencion.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			clienteretencion.setEjercicio(clienteretencionDataAccess.getEjercicio(connexion,clienteretencion));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(clienteretencion.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			clienteretencion.setPeriodo(clienteretencionDataAccess.getPeriodo(connexion,clienteretencion));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(clienteretencion.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			clienteretencion.setAnio(clienteretencionDataAccess.getAnio(connexion,clienteretencion));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(clienteretencion.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			clienteretencion.setMes(clienteretencionDataAccess.getMes(connexion,clienteretencion));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(clienteretencion.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			clienteretencion.setCliente(clienteretencionDataAccess.getCliente(connexion,clienteretencion));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(clienteretencion.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			clienteretencion.setFactura(clienteretencionDataAccess.getFactura(connexion,clienteretencion));
			FacturaLogic facturaLogic= new FacturaLogic(connexion);
			facturaLogic.deepLoad(clienteretencion.getFactura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			clienteretencion.setTransaccion(clienteretencionDataAccess.getTransaccion(connexion,clienteretencion));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(clienteretencion.getTransaccion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			clienteretencion.setTipoRetencion(clienteretencionDataAccess.getTipoRetencion(connexion,clienteretencion));
			TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
			tiporetencionLogic.deepLoad(clienteretencion.getTipoRetencion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			clienteretencion.setAsientoContable(clienteretencionDataAccess.getAsientoContable(connexion,clienteretencion));
			AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
			asientocontableLogic.deepLoad(clienteretencion.getAsientoContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			clienteretencion.setCuentaContableClienteRetencion(clienteretencionDataAccess.getCuentaContableClienteRetencion(connexion,clienteretencion));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(clienteretencion.getCuentaContableClienteRetencion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			clienteretencion.setEstadoRetencion(clienteretencionDataAccess.getEstadoRetencion(connexion,clienteretencion));
			EstadoRetencionLogic estadoretencionLogic= new EstadoRetencionLogic(connexion);
			estadoretencionLogic.deepLoad(clienteretencion.getEstadoRetencion(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ClienteRetencion clienteretencion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ClienteRetencionLogicAdditional.updateClienteRetencionToSave(clienteretencion,this.arrDatoGeneral);
			
ClienteRetencionDataAccess.save(clienteretencion, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(clienteretencion.getEmpresa(),connexion);

		SucursalDataAccess.save(clienteretencion.getSucursal(),connexion);

		EjercicioDataAccess.save(clienteretencion.getEjercicio(),connexion);

		PeriodoDataAccess.save(clienteretencion.getPeriodo(),connexion);

		AnioDataAccess.save(clienteretencion.getAnio(),connexion);

		MesDataAccess.save(clienteretencion.getMes(),connexion);

		ClienteDataAccess.save(clienteretencion.getCliente(),connexion);

		FacturaDataAccess.save(clienteretencion.getFactura(),connexion);

		TransaccionDataAccess.save(clienteretencion.getTransaccion(),connexion);

		TipoRetencionDataAccess.save(clienteretencion.getTipoRetencion(),connexion);

		AsientoContableDataAccess.save(clienteretencion.getAsientoContable(),connexion);

		CuentaContableDataAccess.save(clienteretencion.getCuentaContableClienteRetencion(),connexion);

		EstadoRetencionDataAccess.save(clienteretencion.getEstadoRetencion(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(clienteretencion.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(clienteretencion.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(clienteretencion.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(clienteretencion.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(clienteretencion.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(clienteretencion.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(clienteretencion.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(clienteretencion.getFactura(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(clienteretencion.getTransaccion(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				TipoRetencionDataAccess.save(clienteretencion.getTipoRetencion(),connexion);
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(clienteretencion.getAsientoContable(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(clienteretencion.getCuentaContableClienteRetencion(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoRetencion.class)) {
				EstadoRetencionDataAccess.save(clienteretencion.getEstadoRetencion(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(clienteretencion.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(clienteretencion.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(clienteretencion.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(clienteretencion.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(clienteretencion.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(clienteretencion.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(clienteretencion.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(clienteretencion.getPeriodo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(clienteretencion.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(clienteretencion.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(clienteretencion.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(clienteretencion.getMes(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(clienteretencion.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(clienteretencion.getCliente(),isDeep,deepLoadType,clases);
				

		FacturaDataAccess.save(clienteretencion.getFactura(),connexion);
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(clienteretencion.getFactura(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(clienteretencion.getTransaccion(),connexion);
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(clienteretencion.getTransaccion(),isDeep,deepLoadType,clases);
				

		TipoRetencionDataAccess.save(clienteretencion.getTipoRetencion(),connexion);
		TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
		tiporetencionLogic.deepLoad(clienteretencion.getTipoRetencion(),isDeep,deepLoadType,clases);
				

		AsientoContableDataAccess.save(clienteretencion.getAsientoContable(),connexion);
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(clienteretencion.getAsientoContable(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(clienteretencion.getCuentaContableClienteRetencion(),connexion);
		CuentaContableLogic cuentacontableclienteretencionLogic= new CuentaContableLogic(connexion);
		cuentacontableclienteretencionLogic.deepLoad(clienteretencion.getCuentaContableClienteRetencion(),isDeep,deepLoadType,clases);
				

		EstadoRetencionDataAccess.save(clienteretencion.getEstadoRetencion(),connexion);
		EstadoRetencionLogic estadoretencionLogic= new EstadoRetencionLogic(connexion);
		estadoretencionLogic.deepLoad(clienteretencion.getEstadoRetencion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(clienteretencion.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(clienteretencion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(clienteretencion.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(clienteretencion.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(clienteretencion.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(clienteretencion.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(clienteretencion.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(clienteretencion.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(clienteretencion.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(clienteretencion.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(clienteretencion.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(clienteretencion.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(clienteretencion.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(clienteretencion.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(clienteretencion.getFactura(),connexion);
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepSave(clienteretencion.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(clienteretencion.getTransaccion(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(clienteretencion.getTransaccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				TipoRetencionDataAccess.save(clienteretencion.getTipoRetencion(),connexion);
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepSave(clienteretencion.getTipoRetencion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(clienteretencion.getAsientoContable(),connexion);
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepSave(clienteretencion.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(clienteretencion.getCuentaContableClienteRetencion(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(clienteretencion.getCuentaContableClienteRetencion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoRetencion.class)) {
				EstadoRetencionDataAccess.save(clienteretencion.getEstadoRetencion(),connexion);
				EstadoRetencionLogic estadoretencionLogic= new EstadoRetencionLogic(connexion);
				estadoretencionLogic.deepSave(clienteretencion.getEstadoRetencion(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ClienteRetencion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(clienteretencion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(clienteretencion);
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
			this.deepLoad(this.clienteretencion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ClienteRetencion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(clienteretencions!=null) {
				for(ClienteRetencion clienteretencion:clienteretencions) {
					this.deepLoad(clienteretencion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(clienteretencions);
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
			if(clienteretencions!=null) {
				for(ClienteRetencion clienteretencion:clienteretencions) {
					this.deepLoad(clienteretencion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(clienteretencions);
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
			this.getNewConnexionToDeep(ClienteRetencion.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(clienteretencion,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ClienteRetencion.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(clienteretencions!=null) {
				for(ClienteRetencion clienteretencion:clienteretencions) {
					this.deepSave(clienteretencion,isDeep,deepLoadType,clases);
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
			if(clienteretencions!=null) {
				for(ClienteRetencion clienteretencion:clienteretencions) {
					this.deepSave(clienteretencion,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getClienteRetencionsFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteRetencion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,ClienteRetencionConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clienteretencions=clienteretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClienteRetencionsFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,ClienteRetencionConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clienteretencions=clienteretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClienteRetencionsFK_IdAsientoContableWithConnection(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteRetencion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,ClienteRetencionConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clienteretencions=clienteretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClienteRetencionsFK_IdAsientoContable(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,ClienteRetencionConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clienteretencions=clienteretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClienteRetencionsFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteRetencion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,ClienteRetencionConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clienteretencions=clienteretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClienteRetencionsFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,ClienteRetencionConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clienteretencions=clienteretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClienteRetencionsFK_IdCuentaContableClienteRetencionWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_retencion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteRetencion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableClienteRetencion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableClienteRetencion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_retencion,ClienteRetencionConstantesFunciones.IDCUENTACONTABLECLIENTERETENCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableClienteRetencion);

			ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableClienteRetencion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clienteretencions=clienteretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClienteRetencionsFK_IdCuentaContableClienteRetencion(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_retencion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableClienteRetencion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableClienteRetencion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_retencion,ClienteRetencionConstantesFunciones.IDCUENTACONTABLECLIENTERETENCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableClienteRetencion);

			ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableClienteRetencion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clienteretencions=clienteretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClienteRetencionsFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteRetencion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,ClienteRetencionConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clienteretencions=clienteretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClienteRetencionsFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,ClienteRetencionConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clienteretencions=clienteretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClienteRetencionsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteRetencion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ClienteRetencionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clienteretencions=clienteretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClienteRetencionsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ClienteRetencionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clienteretencions=clienteretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClienteRetencionsFK_IdEstadoRetencionWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_retencion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteRetencion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoRetencion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoRetencion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_retencion,ClienteRetencionConstantesFunciones.IDESTADORETENCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoRetencion);

			ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoRetencion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clienteretencions=clienteretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClienteRetencionsFK_IdEstadoRetencion(String sFinalQuery,Pagination pagination,Long id_estado_retencion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoRetencion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoRetencion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_retencion,ClienteRetencionConstantesFunciones.IDESTADORETENCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoRetencion);

			ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoRetencion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clienteretencions=clienteretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClienteRetencionsFK_IdFacturaWithConnection(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteRetencion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,ClienteRetencionConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clienteretencions=clienteretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClienteRetencionsFK_IdFactura(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,ClienteRetencionConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clienteretencions=clienteretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClienteRetencionsFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteRetencion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,ClienteRetencionConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clienteretencions=clienteretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClienteRetencionsFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,ClienteRetencionConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clienteretencions=clienteretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClienteRetencionsFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteRetencion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,ClienteRetencionConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clienteretencions=clienteretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClienteRetencionsFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,ClienteRetencionConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clienteretencions=clienteretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClienteRetencionsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteRetencion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ClienteRetencionConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clienteretencions=clienteretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClienteRetencionsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ClienteRetencionConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clienteretencions=clienteretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClienteRetencionsFK_IdTipoRetencionWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_retencion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteRetencion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion,ClienteRetencionConstantesFunciones.IDTIPORETENCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencion);

			ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clienteretencions=clienteretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClienteRetencionsFK_IdTipoRetencion(String sFinalQuery,Pagination pagination,Long id_tipo_retencion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion,ClienteRetencionConstantesFunciones.IDTIPORETENCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencion);

			ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clienteretencions=clienteretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClienteRetencionsFK_IdTransaccionWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ClienteRetencion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion,ClienteRetencionConstantesFunciones.IDTRANSACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion);

			ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clienteretencions=clienteretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClienteRetencionsFK_IdTransaccion(String sFinalQuery,Pagination pagination,Long id_transaccion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion,ClienteRetencionConstantesFunciones.IDTRANSACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion);

			ClienteRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clienteretencions=clienteretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(this.clienteretencions);
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
			if(ClienteRetencionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ClienteRetencionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ClienteRetencion clienteretencion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ClienteRetencionConstantesFunciones.ISCONAUDITORIA) {
				if(clienteretencion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ClienteRetencionDataAccess.TABLENAME, clienteretencion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ClienteRetencionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ClienteRetencionLogic.registrarAuditoriaDetallesClienteRetencion(connexion,clienteretencion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(clienteretencion.getIsDeleted()) {
					/*if(!clienteretencion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ClienteRetencionDataAccess.TABLENAME, clienteretencion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ClienteRetencionLogic.registrarAuditoriaDetallesClienteRetencion(connexion,clienteretencion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ClienteRetencionDataAccess.TABLENAME, clienteretencion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(clienteretencion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ClienteRetencionDataAccess.TABLENAME, clienteretencion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ClienteRetencionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ClienteRetencionLogic.registrarAuditoriaDetallesClienteRetencion(connexion,clienteretencion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesClienteRetencion(Connexion connexion,ClienteRetencion clienteretencion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(clienteretencion.getIsNew()||!clienteretencion.getid_empresa().equals(clienteretencion.getClienteRetencionOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clienteretencion.getClienteRetencionOriginal().getid_empresa()!=null)
				{
					strValorActual=clienteretencion.getClienteRetencionOriginal().getid_empresa().toString();
				}
				if(clienteretencion.getid_empresa()!=null)
				{
					strValorNuevo=clienteretencion.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteRetencionConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(clienteretencion.getIsNew()||!clienteretencion.getid_sucursal().equals(clienteretencion.getClienteRetencionOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clienteretencion.getClienteRetencionOriginal().getid_sucursal()!=null)
				{
					strValorActual=clienteretencion.getClienteRetencionOriginal().getid_sucursal().toString();
				}
				if(clienteretencion.getid_sucursal()!=null)
				{
					strValorNuevo=clienteretencion.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteRetencionConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(clienteretencion.getIsNew()||!clienteretencion.getid_ejercicio().equals(clienteretencion.getClienteRetencionOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clienteretencion.getClienteRetencionOriginal().getid_ejercicio()!=null)
				{
					strValorActual=clienteretencion.getClienteRetencionOriginal().getid_ejercicio().toString();
				}
				if(clienteretencion.getid_ejercicio()!=null)
				{
					strValorNuevo=clienteretencion.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteRetencionConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(clienteretencion.getIsNew()||!clienteretencion.getid_periodo().equals(clienteretencion.getClienteRetencionOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clienteretencion.getClienteRetencionOriginal().getid_periodo()!=null)
				{
					strValorActual=clienteretencion.getClienteRetencionOriginal().getid_periodo().toString();
				}
				if(clienteretencion.getid_periodo()!=null)
				{
					strValorNuevo=clienteretencion.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteRetencionConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(clienteretencion.getIsNew()||!clienteretencion.getid_anio().equals(clienteretencion.getClienteRetencionOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clienteretencion.getClienteRetencionOriginal().getid_anio()!=null)
				{
					strValorActual=clienteretencion.getClienteRetencionOriginal().getid_anio().toString();
				}
				if(clienteretencion.getid_anio()!=null)
				{
					strValorNuevo=clienteretencion.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteRetencionConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(clienteretencion.getIsNew()||!clienteretencion.getid_mes().equals(clienteretencion.getClienteRetencionOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clienteretencion.getClienteRetencionOriginal().getid_mes()!=null)
				{
					strValorActual=clienteretencion.getClienteRetencionOriginal().getid_mes().toString();
				}
				if(clienteretencion.getid_mes()!=null)
				{
					strValorNuevo=clienteretencion.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteRetencionConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(clienteretencion.getIsNew()||!clienteretencion.getfecha().equals(clienteretencion.getClienteRetencionOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clienteretencion.getClienteRetencionOriginal().getfecha()!=null)
				{
					strValorActual=clienteretencion.getClienteRetencionOriginal().getfecha().toString();
				}
				if(clienteretencion.getfecha()!=null)
				{
					strValorNuevo=clienteretencion.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteRetencionConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(clienteretencion.getIsNew()||!clienteretencion.getid_cliente().equals(clienteretencion.getClienteRetencionOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clienteretencion.getClienteRetencionOriginal().getid_cliente()!=null)
				{
					strValorActual=clienteretencion.getClienteRetencionOriginal().getid_cliente().toString();
				}
				if(clienteretencion.getid_cliente()!=null)
				{
					strValorNuevo=clienteretencion.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteRetencionConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(clienteretencion.getIsNew()||!clienteretencion.getid_factura().equals(clienteretencion.getClienteRetencionOriginal().getid_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clienteretencion.getClienteRetencionOriginal().getid_factura()!=null)
				{
					strValorActual=clienteretencion.getClienteRetencionOriginal().getid_factura().toString();
				}
				if(clienteretencion.getid_factura()!=null)
				{
					strValorNuevo=clienteretencion.getid_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteRetencionConstantesFunciones.IDFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(clienteretencion.getIsNew()||!clienteretencion.getid_transaccion().equals(clienteretencion.getClienteRetencionOriginal().getid_transaccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clienteretencion.getClienteRetencionOriginal().getid_transaccion()!=null)
				{
					strValorActual=clienteretencion.getClienteRetencionOriginal().getid_transaccion().toString();
				}
				if(clienteretencion.getid_transaccion()!=null)
				{
					strValorNuevo=clienteretencion.getid_transaccion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteRetencionConstantesFunciones.IDTRANSACCION,strValorActual,strValorNuevo);
			}	
			
			if(clienteretencion.getIsNew()||!clienteretencion.getid_tipo_retencion().equals(clienteretencion.getClienteRetencionOriginal().getid_tipo_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clienteretencion.getClienteRetencionOriginal().getid_tipo_retencion()!=null)
				{
					strValorActual=clienteretencion.getClienteRetencionOriginal().getid_tipo_retencion().toString();
				}
				if(clienteretencion.getid_tipo_retencion()!=null)
				{
					strValorNuevo=clienteretencion.getid_tipo_retencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteRetencionConstantesFunciones.IDTIPORETENCION,strValorActual,strValorNuevo);
			}	
			
			if(clienteretencion.getIsNew()||!clienteretencion.getporcentaje().equals(clienteretencion.getClienteRetencionOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clienteretencion.getClienteRetencionOriginal().getporcentaje()!=null)
				{
					strValorActual=clienteretencion.getClienteRetencionOriginal().getporcentaje().toString();
				}
				if(clienteretencion.getporcentaje()!=null)
				{
					strValorNuevo=clienteretencion.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteRetencionConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(clienteretencion.getIsNew()||!clienteretencion.getbase_imponible().equals(clienteretencion.getClienteRetencionOriginal().getbase_imponible()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clienteretencion.getClienteRetencionOriginal().getbase_imponible()!=null)
				{
					strValorActual=clienteretencion.getClienteRetencionOriginal().getbase_imponible().toString();
				}
				if(clienteretencion.getbase_imponible()!=null)
				{
					strValorNuevo=clienteretencion.getbase_imponible().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteRetencionConstantesFunciones.BASEIMPONIBLE,strValorActual,strValorNuevo);
			}	
			
			if(clienteretencion.getIsNew()||!clienteretencion.getvalor().equals(clienteretencion.getClienteRetencionOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clienteretencion.getClienteRetencionOriginal().getvalor()!=null)
				{
					strValorActual=clienteretencion.getClienteRetencionOriginal().getvalor().toString();
				}
				if(clienteretencion.getvalor()!=null)
				{
					strValorNuevo=clienteretencion.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteRetencionConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
			
			if(clienteretencion.getIsNew()||!clienteretencion.getnumero_retencion().equals(clienteretencion.getClienteRetencionOriginal().getnumero_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clienteretencion.getClienteRetencionOriginal().getnumero_retencion()!=null)
				{
					strValorActual=clienteretencion.getClienteRetencionOriginal().getnumero_retencion();
				}
				if(clienteretencion.getnumero_retencion()!=null)
				{
					strValorNuevo=clienteretencion.getnumero_retencion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteRetencionConstantesFunciones.NUMERORETENCION,strValorActual,strValorNuevo);
			}	
			
			if(clienteretencion.getIsNew()||!clienteretencion.getdescripcion().equals(clienteretencion.getClienteRetencionOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clienteretencion.getClienteRetencionOriginal().getdescripcion()!=null)
				{
					strValorActual=clienteretencion.getClienteRetencionOriginal().getdescripcion();
				}
				if(clienteretencion.getdescripcion()!=null)
				{
					strValorNuevo=clienteretencion.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteRetencionConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(clienteretencion.getIsNew()||!clienteretencion.getid_asiento_contable().equals(clienteretencion.getClienteRetencionOriginal().getid_asiento_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clienteretencion.getClienteRetencionOriginal().getid_asiento_contable()!=null)
				{
					strValorActual=clienteretencion.getClienteRetencionOriginal().getid_asiento_contable().toString();
				}
				if(clienteretencion.getid_asiento_contable()!=null)
				{
					strValorNuevo=clienteretencion.getid_asiento_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteRetencionConstantesFunciones.IDASIENTOCONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(clienteretencion.getIsNew()||!clienteretencion.getid_cuenta_contable_retencion().equals(clienteretencion.getClienteRetencionOriginal().getid_cuenta_contable_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clienteretencion.getClienteRetencionOriginal().getid_cuenta_contable_retencion()!=null)
				{
					strValorActual=clienteretencion.getClienteRetencionOriginal().getid_cuenta_contable_retencion().toString();
				}
				if(clienteretencion.getid_cuenta_contable_retencion()!=null)
				{
					strValorNuevo=clienteretencion.getid_cuenta_contable_retencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteRetencionConstantesFunciones.IDCUENTACONTABLECLIENTERETENCION,strValorActual,strValorNuevo);
			}	
			
			if(clienteretencion.getIsNew()||!clienteretencion.getvalor_tipo_cambio().equals(clienteretencion.getClienteRetencionOriginal().getvalor_tipo_cambio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clienteretencion.getClienteRetencionOriginal().getvalor_tipo_cambio()!=null)
				{
					strValorActual=clienteretencion.getClienteRetencionOriginal().getvalor_tipo_cambio().toString();
				}
				if(clienteretencion.getvalor_tipo_cambio()!=null)
				{
					strValorNuevo=clienteretencion.getvalor_tipo_cambio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteRetencionConstantesFunciones.VALORTIPOCAMBIO,strValorActual,strValorNuevo);
			}	
			
			if(clienteretencion.getIsNew()||!clienteretencion.getdebito_mone_local().equals(clienteretencion.getClienteRetencionOriginal().getdebito_mone_local()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clienteretencion.getClienteRetencionOriginal().getdebito_mone_local()!=null)
				{
					strValorActual=clienteretencion.getClienteRetencionOriginal().getdebito_mone_local().toString();
				}
				if(clienteretencion.getdebito_mone_local()!=null)
				{
					strValorNuevo=clienteretencion.getdebito_mone_local().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteRetencionConstantesFunciones.DEBITOMONELOCAL,strValorActual,strValorNuevo);
			}	
			
			if(clienteretencion.getIsNew()||!clienteretencion.getcredito_mone_local().equals(clienteretencion.getClienteRetencionOriginal().getcredito_mone_local()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clienteretencion.getClienteRetencionOriginal().getcredito_mone_local()!=null)
				{
					strValorActual=clienteretencion.getClienteRetencionOriginal().getcredito_mone_local().toString();
				}
				if(clienteretencion.getcredito_mone_local()!=null)
				{
					strValorNuevo=clienteretencion.getcredito_mone_local().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteRetencionConstantesFunciones.CREDITOMONELOCAL,strValorActual,strValorNuevo);
			}	
			
			if(clienteretencion.getIsNew()||!clienteretencion.getdebito_mone_extra().equals(clienteretencion.getClienteRetencionOriginal().getdebito_mone_extra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clienteretencion.getClienteRetencionOriginal().getdebito_mone_extra()!=null)
				{
					strValorActual=clienteretencion.getClienteRetencionOriginal().getdebito_mone_extra().toString();
				}
				if(clienteretencion.getdebito_mone_extra()!=null)
				{
					strValorNuevo=clienteretencion.getdebito_mone_extra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteRetencionConstantesFunciones.DEBITOMONEEXTRA,strValorActual,strValorNuevo);
			}	
			
			if(clienteretencion.getIsNew()||!clienteretencion.getcredito_mone_extra().equals(clienteretencion.getClienteRetencionOriginal().getcredito_mone_extra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clienteretencion.getClienteRetencionOriginal().getcredito_mone_extra()!=null)
				{
					strValorActual=clienteretencion.getClienteRetencionOriginal().getcredito_mone_extra().toString();
				}
				if(clienteretencion.getcredito_mone_extra()!=null)
				{
					strValorNuevo=clienteretencion.getcredito_mone_extra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteRetencionConstantesFunciones.CREDITOMONEEXTRA,strValorActual,strValorNuevo);
			}	
			
			if(clienteretencion.getIsNew()||!clienteretencion.getbeneficiario().equals(clienteretencion.getClienteRetencionOriginal().getbeneficiario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clienteretencion.getClienteRetencionOriginal().getbeneficiario()!=null)
				{
					strValorActual=clienteretencion.getClienteRetencionOriginal().getbeneficiario();
				}
				if(clienteretencion.getbeneficiario()!=null)
				{
					strValorNuevo=clienteretencion.getbeneficiario() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteRetencionConstantesFunciones.BENEFICIARIO,strValorActual,strValorNuevo);
			}	
			
			if(clienteretencion.getIsNew()||!clienteretencion.getnombre_benef().equals(clienteretencion.getClienteRetencionOriginal().getnombre_benef()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clienteretencion.getClienteRetencionOriginal().getnombre_benef()!=null)
				{
					strValorActual=clienteretencion.getClienteRetencionOriginal().getnombre_benef();
				}
				if(clienteretencion.getnombre_benef()!=null)
				{
					strValorNuevo=clienteretencion.getnombre_benef() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteRetencionConstantesFunciones.NOMBREBENEF,strValorActual,strValorNuevo);
			}	
			
			if(clienteretencion.getIsNew()||!clienteretencion.getdireccion_benef().equals(clienteretencion.getClienteRetencionOriginal().getdireccion_benef()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clienteretencion.getClienteRetencionOriginal().getdireccion_benef()!=null)
				{
					strValorActual=clienteretencion.getClienteRetencionOriginal().getdireccion_benef();
				}
				if(clienteretencion.getdireccion_benef()!=null)
				{
					strValorNuevo=clienteretencion.getdireccion_benef() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteRetencionConstantesFunciones.DIRECCIONBENEF,strValorActual,strValorNuevo);
			}	
			
			if(clienteretencion.getIsNew()||!clienteretencion.gettelefono_benef().equals(clienteretencion.getClienteRetencionOriginal().gettelefono_benef()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clienteretencion.getClienteRetencionOriginal().gettelefono_benef()!=null)
				{
					strValorActual=clienteretencion.getClienteRetencionOriginal().gettelefono_benef();
				}
				if(clienteretencion.gettelefono_benef()!=null)
				{
					strValorNuevo=clienteretencion.gettelefono_benef() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteRetencionConstantesFunciones.TELEFONOBENEF,strValorActual,strValorNuevo);
			}	
			
			if(clienteretencion.getIsNew()||!clienteretencion.getruc_benef().equals(clienteretencion.getClienteRetencionOriginal().getruc_benef()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clienteretencion.getClienteRetencionOriginal().getruc_benef()!=null)
				{
					strValorActual=clienteretencion.getClienteRetencionOriginal().getruc_benef();
				}
				if(clienteretencion.getruc_benef()!=null)
				{
					strValorNuevo=clienteretencion.getruc_benef() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteRetencionConstantesFunciones.RUCBENEF,strValorActual,strValorNuevo);
			}	
			
			if(clienteretencion.getIsNew()||!clienteretencion.getid_estado_retencion().equals(clienteretencion.getClienteRetencionOriginal().getid_estado_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(clienteretencion.getClienteRetencionOriginal().getid_estado_retencion()!=null)
				{
					strValorActual=clienteretencion.getClienteRetencionOriginal().getid_estado_retencion().toString();
				}
				if(clienteretencion.getid_estado_retencion()!=null)
				{
					strValorNuevo=clienteretencion.getid_estado_retencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteRetencionConstantesFunciones.IDESTADORETENCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveClienteRetencionRelacionesWithConnection(ClienteRetencion clienteretencion) throws Exception {

		if(!clienteretencion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveClienteRetencionRelacionesBase(clienteretencion,true);
		}
	}

	public void saveClienteRetencionRelaciones(ClienteRetencion clienteretencion)throws Exception {

		if(!clienteretencion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveClienteRetencionRelacionesBase(clienteretencion,false);
		}
	}

	public void saveClienteRetencionRelacionesBase(ClienteRetencion clienteretencion,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ClienteRetencion-saveRelacionesWithConnection");}
	

			this.setClienteRetencion(clienteretencion);

			if(ClienteRetencionLogicAdditional.validarSaveRelaciones(clienteretencion,this)) {

				ClienteRetencionLogicAdditional.updateRelacionesToSave(clienteretencion,this);

				if((clienteretencion.getIsNew()||clienteretencion.getIsChanged())&&!clienteretencion.getIsDeleted()) {
					this.saveClienteRetencion();
					this.saveClienteRetencionRelacionesDetalles();

				} else if(clienteretencion.getIsDeleted()) {
					this.saveClienteRetencionRelacionesDetalles();
					this.saveClienteRetencion();
				}

				ClienteRetencionLogicAdditional.updateRelacionesToSaveAfter(clienteretencion,this);

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
	
	
	private void saveClienteRetencionRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfClienteRetencion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ClienteRetencionConstantesFunciones.getClassesForeignKeysOfClienteRetencion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfClienteRetencion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ClienteRetencionConstantesFunciones.getClassesRelationshipsOfClienteRetencion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

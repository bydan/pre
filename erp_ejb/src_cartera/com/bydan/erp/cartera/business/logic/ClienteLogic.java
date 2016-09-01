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
import com.bydan.erp.cartera.util.ClienteConstantesFunciones;
import com.bydan.erp.cartera.util.ClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.ClienteParameterGeneral;
import com.bydan.erp.cartera.business.entity.Cliente;
import com.bydan.erp.cartera.business.logic.ClienteLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.sris.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.puntoventa.business.logic.*;
import com.bydan.erp.activosfijos.business.logic.*;
import com.bydan.erp.importaciones.business.logic.*;
import com.bydan.erp.produccion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.produccion.business.dataaccess.*;








@SuppressWarnings("unused")
public class ClienteLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ClienteLogic.class);
	
	protected ClienteDataAccess clienteDataAccess; 	
	protected Cliente cliente;
	protected List<Cliente> clientes;
	protected Object clienteObject;	
	protected List<Object> clientesObject;
	
	public static ClassValidator<Cliente> clienteValidator = new ClassValidator<Cliente>(Cliente.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ClienteLogicAdditional clienteLogicAdditional=null;
	
	public ClienteLogicAdditional getClienteLogicAdditional() {
		return this.clienteLogicAdditional;
	}
	
	public void setClienteLogicAdditional(ClienteLogicAdditional clienteLogicAdditional) {
		try {
			this.clienteLogicAdditional=clienteLogicAdditional;
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
	
	
	
	
	public  ClienteLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.clienteDataAccess = new ClienteDataAccess();
			
			//SE QUITA INICIALIZACION INICIAL, RAPIDEZ PANTALLA
			
			this.clienteObject=new Object();
			this.clientesObject=new ArrayList<Object>();
				
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
			
			this.clienteDataAccess.setConnexionType(this.connexionType);
			this.clienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ClienteLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.clienteDataAccess = new ClienteDataAccess();
			this.clientes= new ArrayList<Cliente>();
			this.cliente= new Cliente();
			this.clienteObject=new Object();
			this.clientesObject=new ArrayList<Object>();
			
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
			
			this.clienteDataAccess.setConnexionType(this.connexionType);
			this.clienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Cliente getCliente() throws Exception {	
		ClienteLogicAdditional.checkClienteToGet(cliente,this.datosCliente,this.arrDatoGeneral);
		ClienteLogicAdditional.updateClienteToGet(cliente,this.arrDatoGeneral);
		
		return cliente;
	}
		
	public void setCliente(Cliente newCliente) {
		this.cliente = newCliente;
	}
	
	public ClienteDataAccess getClienteDataAccess() {
		return clienteDataAccess;
	}
	
	public void setClienteDataAccess(ClienteDataAccess newclienteDataAccess) {
		this.clienteDataAccess = newclienteDataAccess;
	}
	
	public List<Cliente> getClientes() throws Exception {		
		this.quitarClientesNulos();
		
		ClienteLogicAdditional.checkClienteToGets(clientes,this.datosCliente,this.arrDatoGeneral);
		
		for (Cliente clienteLocal: clientes ) {
			ClienteLogicAdditional.updateClienteToGet(clienteLocal,this.arrDatoGeneral);
		}
		
		return clientes;
	}
	
	public void setClientes(List<Cliente> newClientes) {
		this.clientes = newClientes;
	}
	
	public Object getClienteObject() {	
		this.clienteObject=this.clienteDataAccess.getEntityObject();
		return this.clienteObject;
	}
		
	public void setClienteObject(Object newClienteObject) {
		this.clienteObject = newClienteObject;
	}
	
	public List<Object> getClientesObject() {		
		this.clientesObject=this.clienteDataAccess.getEntitiesObject();
		return this.clientesObject;
	}
		
	public void setClientesObject(List<Object> newClientesObject) {
		this.clientesObject = newClientesObject;
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
		
		if(this.clienteDataAccess!=null) {
			this.clienteDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			clienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			clienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		cliente = new  Cliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cliente=clienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.cliente);
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
		cliente = new  Cliente();
		  		  
        try {
			
			cliente=clienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.cliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		cliente = new  Cliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cliente=clienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.cliente);
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
		cliente = new  Cliente();
		  		  
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
		cliente = new  Cliente();
		  		  
        try {
			
			cliente=clienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.cliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		cliente = new  Cliente();
		  		  
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
		cliente = new  Cliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =clienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cliente = new  Cliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=clienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cliente = new  Cliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =clienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cliente = new  Cliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=clienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cliente = new  Cliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =clienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cliente = new  Cliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=clienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		clientes = new  ArrayList<Cliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clientes=clienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCliente(clientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
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
		clientes = new  ArrayList<Cliente>();
		  		  
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
		clientes = new  ArrayList<Cliente>();
		  		  
        try {			
			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clientes=clienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarCliente(clientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		clientes = new  ArrayList<Cliente>();
		  		  
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
		clientes = new  ArrayList<Cliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clientes=clienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCliente(clientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
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
		clientes = new  ArrayList<Cliente>();
		  		  
        try {
			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clientes=clienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCliente(clientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
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
		clientes = new  ArrayList<Cliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clientes=clienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCliente(clientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
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
		clientes = new  ArrayList<Cliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clientes=clienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCliente(clientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		cliente = new  Cliente();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cliente=clienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCliente(cliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.cliente);
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
		cliente = new  Cliente();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cliente=clienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCliente(cliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.cliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		clientes = new  ArrayList<Cliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clientes=clienteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCliente(clientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
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
		clientes = new  ArrayList<Cliente>();
		  		  
        try {
			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clientes=clienteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCliente(clientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosClientesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		clientes = new  ArrayList<Cliente>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getTodosClientesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCliente(clientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
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
	
	public  void  getTodosClientes(String sFinalQuery,Pagination pagination)throws Exception {
		clientes = new  ArrayList<Cliente>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCliente(clientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarCliente(Cliente cliente) throws Exception {
		Boolean estaValidado=false;
		
		if(cliente.getIsNew() || cliente.getIsChanged()) { 
			this.invalidValues = clienteValidator.getInvalidValues(cliente);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(cliente);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarCliente(List<Cliente> Clientes) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Cliente clienteLocal:clientes) {				
			estaValidadoObjeto=this.validarGuardarCliente(clienteLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarCliente(List<Cliente> Clientes) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCliente(clientes)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarCliente(Cliente Cliente) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCliente(cliente)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Cliente cliente) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+cliente.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ClienteConstantesFunciones.getClienteLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"cliente","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveClienteWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-saveClienteWithConnection");connexion.begin();			
			
			ClienteLogicAdditional.checkClienteToSave(this.cliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ClienteLogicAdditional.updateClienteToSave(this.cliente,this.arrDatoGeneral);
			
			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowCliente();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCliente(this.cliente)) {
				ClienteDataAccess.save(this.cliente, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.cliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ClienteLogicAdditional.checkClienteToSaveAfter(this.cliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCliente();
			
			connexion.commit();			
			
			if(this.cliente.getIsDeleted()) {
				this.cliente=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveCliente()throws Exception {	
		try {	
			
			ClienteLogicAdditional.checkClienteToSave(this.cliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ClienteLogicAdditional.updateClienteToSave(this.cliente,this.arrDatoGeneral);
			
			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCliente(this.cliente)) {			
				ClienteDataAccess.save(this.cliente, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.cliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ClienteLogicAdditional.checkClienteToSaveAfter(this.cliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.cliente.getIsDeleted()) {
				this.cliente=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveClientesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-saveClientesWithConnection");connexion.begin();			
			
			ClienteLogicAdditional.checkClienteToSaves(clientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowClientes();
			
			Boolean validadoTodosCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Cliente clienteLocal:clientes) {		
				if(clienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ClienteLogicAdditional.updateClienteToSave(clienteLocal,this.arrDatoGeneral);
	        	
				ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),clienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCliente(clienteLocal)) {
					ClienteDataAccess.save(clienteLocal, connexion);				
				} else {
					validadoTodosCliente=false;
				}
			}
			
			if(!validadoTodosCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ClienteLogicAdditional.checkClienteToSavesAfter(clientes,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowClientes();
			
			connexion.commit();		
			
			this.quitarClientesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveClientes()throws Exception {				
		 try {	
			ClienteLogicAdditional.checkClienteToSaves(clientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Cliente clienteLocal:clientes) {				
				if(clienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ClienteLogicAdditional.updateClienteToSave(clienteLocal,this.arrDatoGeneral);
	        	
				ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),clienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCliente(clienteLocal)) {				
					ClienteDataAccess.save(clienteLocal, connexion);				
				} else {
					validadoTodosCliente=false;
				}
			}
			
			if(!validadoTodosCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ClienteLogicAdditional.checkClienteToSavesAfter(clientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarClientesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ClienteParameterReturnGeneral procesarAccionClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Cliente> clientes,ClienteParameterReturnGeneral clienteParameterGeneral)throws Exception {
		 try {	
			ClienteParameterReturnGeneral clienteReturnGeneral=new ClienteParameterReturnGeneral();
	
			ClienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,clientes,clienteParameterGeneral,clienteReturnGeneral);
			
			return clienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ClienteParameterReturnGeneral procesarAccionClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Cliente> clientes,ClienteParameterReturnGeneral clienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-procesarAccionClientesWithConnection");connexion.begin();			
			
			ClienteParameterReturnGeneral clienteReturnGeneral=new ClienteParameterReturnGeneral();
	
			ClienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,clientes,clienteParameterGeneral,clienteReturnGeneral);
			
			this.connexion.commit();
			
			return clienteReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ClienteParameterReturnGeneral procesarEventosClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Cliente> clientes,Cliente cliente,ClienteParameterReturnGeneral clienteParameterGeneral,Boolean isEsNuevoCliente,ArrayList<Classe> clases)throws Exception {
		 try {	
			ClienteParameterReturnGeneral clienteReturnGeneral=new ClienteParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				clienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ClienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,clientes,cliente,clienteParameterGeneral,clienteReturnGeneral,isEsNuevoCliente,clases);
			
			return clienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ClienteParameterReturnGeneral procesarEventosClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Cliente> clientes,Cliente cliente,ClienteParameterReturnGeneral clienteParameterGeneral,Boolean isEsNuevoCliente,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-procesarEventosClientesWithConnection");connexion.begin();			
			
			ClienteParameterReturnGeneral clienteReturnGeneral=new ClienteParameterReturnGeneral();
	
			clienteReturnGeneral.setCliente(cliente);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				clienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ClienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,clientes,cliente,clienteParameterGeneral,clienteReturnGeneral,isEsNuevoCliente,clases);
			
			this.connexion.commit();
			
			return clienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ClienteParameterReturnGeneral procesarImportacionClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ClienteParameterReturnGeneral clienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-procesarImportacionClientesWithConnection");connexion.begin();			
			
			ClienteParameterReturnGeneral clienteReturnGeneral=new ClienteParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.clientes=new ArrayList<Cliente>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.cliente=new Cliente();
				
				
				if(conColumnasBase) {this.cliente.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.cliente.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.cliente.setcodigo(arrColumnas[iColumn++]);
				this.cliente.setidentificacion(arrColumnas[iColumn++]);
				this.cliente.setruc(arrColumnas[iColumn++]);
				this.cliente.setnombre(arrColumnas[iColumn++]);
				this.cliente.setapellido(arrColumnas[iColumn++]);
				this.cliente.setnombre_completo(arrColumnas[iColumn++]);
				this.cliente.setnombre_comercial(arrColumnas[iColumn++]);
				this.cliente.settelefono(arrColumnas[iColumn++]);
				this.cliente.setdireccion(arrColumnas[iColumn++]);
				this.cliente.setes_prove(Boolean.parseBoolean(arrColumnas[iColumn++]));
			this.cliente.setobservacion(arrColumnas[iColumn++]);
				this.cliente.setfecha_nacimiento(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.cliente.setpath_imagen_firma(arrColumnas[iColumn++]);
				this.cliente.setcontacto(arrColumnas[iColumn++]);
				this.cliente.setrepresentante(arrColumnas[iColumn++]);
				this.cliente.setnombre_garantia(arrColumnas[iColumn++]);
				this.cliente.setvalor_garantia(Double.parseDouble(arrColumnas[iColumn++]));
				this.cliente.setnumero_carga(Integer.parseInt(arrColumnas[iColumn++]));
				this.cliente.setcredito_usado(Double.parseDouble(arrColumnas[iColumn++]));
				this.cliente.setlimite_credito(Double.parseDouble(arrColumnas[iColumn++]));
				this.cliente.setcredito_disponible(Double.parseDouble(arrColumnas[iColumn++]));
				this.cliente.settotal_documentos(Double.parseDouble(arrColumnas[iColumn++]));
				this.cliente.setfecha_ultima_factura(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.cliente.setdescuento(Double.parseDouble(arrColumnas[iColumn++]));
				//this.cliente.sethora_pago(arrColumnas[iColumn++]);
				this.cliente.setcobranzas(arrColumnas[iColumn++]);
				this.cliente.setmotivo(arrColumnas[iColumn++]);
				this.cliente.setpreferencia(arrColumnas[iColumn++]);
				this.cliente.setcon_separacion_bienes(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.cliente.setdetalle_estado(arrColumnas[iColumn++]);
				this.cliente.setes_contribuyente_especial(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.clientes.add(this.cliente);
			}
			
			this.saveClientes();
			
			this.connexion.commit();
			
			clienteReturnGeneral.setConRetornoEstaProcesado(true);
			clienteReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return clienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarClientesEliminados() throws Exception {				
		
		List<Cliente> clientesAux= new ArrayList<Cliente>();
		
		for(Cliente cliente:clientes) {
			if(!cliente.getIsDeleted()) {
				clientesAux.add(cliente);
			}
		}
		
		clientes=clientesAux;
	}
	
	public void quitarClientesNulos() throws Exception {				
		
		List<Cliente> clientesAux= new ArrayList<Cliente>();
		
		for(Cliente cliente : this.clientes) {
			if(cliente==null) {
				clientesAux.add(cliente);
			}
		}
		
		//this.clientes=clientesAux;
		
		this.clientes.removeAll(clientesAux);
	}
	
	public void getSetVersionRowClienteWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(cliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((cliente.getIsDeleted() || (cliente.getIsChanged()&&!cliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=clienteDataAccess.getSetVersionRowCliente(connexion,cliente.getId());
				
				if(!cliente.getVersionRow().equals(timestamp)) {	
					cliente.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				cliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowCliente()throws Exception {	
		
		if(cliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((cliente.getIsDeleted() || (cliente.getIsChanged()&&!cliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=clienteDataAccess.getSetVersionRowCliente(connexion,cliente.getId());
			
			try {							
				if(!cliente.getVersionRow().equals(timestamp)) {	
					cliente.setVersionRow(timestamp);
				}
				
				cliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowClientesWithConnection()throws Exception {	
		if(clientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Cliente clienteAux:clientes) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(clienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(clienteAux.getIsDeleted() || (clienteAux.getIsChanged()&&!clienteAux.getIsNew())) {
						
						timestamp=clienteDataAccess.getSetVersionRowCliente(connexion,clienteAux.getId());
						
						if(!cliente.getVersionRow().equals(timestamp)) {	
							clienteAux.setVersionRow(timestamp);
						}
								
						clienteAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowClientes()throws Exception {	
		if(clientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Cliente clienteAux:clientes) {
					if(clienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(clienteAux.getIsDeleted() || (clienteAux.getIsChanged()&&!clienteAux.getIsNew())) {
						
						timestamp=clienteDataAccess.getSetVersionRowCliente(connexion,clienteAux.getId());
						
						if(!clienteAux.getVersionRow().equals(timestamp)) {	
							clienteAux.setVersionRow(timestamp);
						}
						
													
						clienteAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ClienteParameterReturnGeneral cargarCombosLoteForeignKeyClienteWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalTipoIdentificacion,String finalQueryGlobalGrupoCliente,String finalQueryGlobalTituloCliente,String finalQueryGlobalAreaCr,String finalQueryGlobalEstadoCliente,String finalQueryGlobalPais,String finalQueryGlobalRegion,String finalQueryGlobalProvincia,String finalQueryGlobalCiudad,String finalQueryGlobalZona,String finalQueryGlobalPaisNacionalidad,String finalQueryGlobalTipoCargoLabo,String finalQueryGlobalTipoNivelEdu,String finalQueryGlobalProfesion,String finalQueryGlobalTipoGenero,String finalQueryGlobalEstadoCivil,String finalQueryGlobalEstadoLegal,String finalQueryGlobalCuentaContable,String finalQueryGlobalRuta,String finalQueryGlobalVendedor,String finalQueryGlobalCentroActividad,String finalQueryGlobalTipoGarantiaEmpresa,String finalQueryGlobalCateTipoAfiliacion,String finalQueryGlobalDia,String finalQueryGlobalEmpleado,String finalQueryGlobalTipoPrecio,String finalQueryGlobalTipoListaPrecio) throws Exception {
		ClienteParameterReturnGeneral  clienteReturnGeneral =new ClienteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-cargarCombosLoteForeignKeyClienteWithConnection");connexion.begin();
			
			clienteReturnGeneral =new ClienteParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			clienteReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			clienteReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<TipoIdentificacion> tipoidentificacionsForeignKey=new ArrayList<TipoIdentificacion>();
			TipoIdentificacionLogic tipoidentificacionLogic=new TipoIdentificacionLogic();
			tipoidentificacionLogic.setConnexion(this.connexion);
			tipoidentificacionLogic.getTipoIdentificacionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoIdentificacion.equals("NONE")) {
				tipoidentificacionLogic.getTodosTipoIdentificacions(finalQueryGlobalTipoIdentificacion,new Pagination());
				tipoidentificacionsForeignKey=tipoidentificacionLogic.getTipoIdentificacions();
			}

			clienteReturnGeneral.settipoidentificacionsForeignKey(tipoidentificacionsForeignKey);


			List<GrupoCliente> grupoclientesForeignKey=new ArrayList<GrupoCliente>();
			GrupoClienteLogic grupoclienteLogic=new GrupoClienteLogic();
			grupoclienteLogic.setConnexion(this.connexion);
			grupoclienteLogic.getGrupoClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalGrupoCliente.equals("NONE")) {
				grupoclienteLogic.getTodosGrupoClientes(finalQueryGlobalGrupoCliente,new Pagination());
				grupoclientesForeignKey=grupoclienteLogic.getGrupoClientes();
			}

			clienteReturnGeneral.setgrupoclientesForeignKey(grupoclientesForeignKey);


			List<TituloCliente> tituloclientesForeignKey=new ArrayList<TituloCliente>();
			TituloClienteLogic tituloclienteLogic=new TituloClienteLogic();
			tituloclienteLogic.setConnexion(this.connexion);
			tituloclienteLogic.getTituloClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTituloCliente.equals("NONE")) {
				tituloclienteLogic.getTodosTituloClientes(finalQueryGlobalTituloCliente,new Pagination());
				tituloclientesForeignKey=tituloclienteLogic.getTituloClientes();
			}

			clienteReturnGeneral.settituloclientesForeignKey(tituloclientesForeignKey);


			List<AreaCr> areacrsForeignKey=new ArrayList<AreaCr>();
			AreaCrLogic areacrLogic=new AreaCrLogic();
			areacrLogic.setConnexion(this.connexion);
			areacrLogic.getAreaCrDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAreaCr.equals("NONE")) {
				areacrLogic.getTodosAreaCrs(finalQueryGlobalAreaCr,new Pagination());
				areacrsForeignKey=areacrLogic.getAreaCrs();
			}

			clienteReturnGeneral.setareacrsForeignKey(areacrsForeignKey);


			List<EstadoCliente> estadoclientesForeignKey=new ArrayList<EstadoCliente>();
			EstadoClienteLogic estadoclienteLogic=new EstadoClienteLogic();
			estadoclienteLogic.setConnexion(this.connexion);
			//estadoclienteLogic.getEstadoClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoCliente.equals("NONE")) {
				estadoclienteLogic.getTodosEstadoClientes(finalQueryGlobalEstadoCliente,new Pagination());
				estadoclientesForeignKey=estadoclienteLogic.getEstadoClientes();
			}

			clienteReturnGeneral.setestadoclientesForeignKey(estadoclientesForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			clienteReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Region> regionsForeignKey=new ArrayList<Region>();
			RegionLogic regionLogic=new RegionLogic();
			regionLogic.setConnexion(this.connexion);
			regionLogic.getRegionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRegion.equals("NONE")) {
				regionLogic.getTodosRegions(finalQueryGlobalRegion,new Pagination());
				regionsForeignKey=regionLogic.getRegions();
			}

			clienteReturnGeneral.setregionsForeignKey(regionsForeignKey);


			List<Provincia> provinciasForeignKey=new ArrayList<Provincia>();
			ProvinciaLogic provinciaLogic=new ProvinciaLogic();
			provinciaLogic.setConnexion(this.connexion);
			provinciaLogic.getProvinciaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProvincia.equals("NONE")) {
				provinciaLogic.getTodosProvincias(finalQueryGlobalProvincia,new Pagination());
				provinciasForeignKey=provinciaLogic.getProvincias();
			}

			clienteReturnGeneral.setprovinciasForeignKey(provinciasForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			clienteReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);


			List<Zona> zonasForeignKey=new ArrayList<Zona>();
			ZonaLogic zonaLogic=new ZonaLogic();
			zonaLogic.setConnexion(this.connexion);
			zonaLogic.getZonaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalZona.equals("NONE")) {
				zonaLogic.getTodosZonas(finalQueryGlobalZona,new Pagination());
				zonasForeignKey=zonaLogic.getZonas();
			}

			clienteReturnGeneral.setzonasForeignKey(zonasForeignKey);


			List<Pais> paisnacionalidadsForeignKey=new ArrayList<Pais>();
			PaisLogic paisnacionalidadLogic=new PaisLogic();
			paisnacionalidadLogic.setConnexion(this.connexion);
			paisnacionalidadLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPaisNacionalidad.equals("NONE")) {
				paisnacionalidadLogic.getTodosPaiss(finalQueryGlobalPaisNacionalidad,new Pagination());
				paisnacionalidadsForeignKey=paisnacionalidadLogic.getPaiss();
			}

			clienteReturnGeneral.setpaisnacionalidadsForeignKey(paisnacionalidadsForeignKey);


			List<TipoCargoLabo> tipocargolabosForeignKey=new ArrayList<TipoCargoLabo>();
			TipoCargoLaboLogic tipocargolaboLogic=new TipoCargoLaboLogic();
			tipocargolaboLogic.setConnexion(this.connexion);
			tipocargolaboLogic.getTipoCargoLaboDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCargoLabo.equals("NONE")) {
				tipocargolaboLogic.getTodosTipoCargoLabos(finalQueryGlobalTipoCargoLabo,new Pagination());
				tipocargolabosForeignKey=tipocargolaboLogic.getTipoCargoLabos();
			}

			clienteReturnGeneral.settipocargolabosForeignKey(tipocargolabosForeignKey);


			List<TipoNivelEdu> tiponiveledusForeignKey=new ArrayList<TipoNivelEdu>();
			TipoNivelEduLogic tiponiveleduLogic=new TipoNivelEduLogic();
			tiponiveleduLogic.setConnexion(this.connexion);
			//tiponiveleduLogic.getTipoNivelEduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoNivelEdu.equals("NONE")) {
				tiponiveleduLogic.getTodosTipoNivelEdus(finalQueryGlobalTipoNivelEdu,new Pagination());
				tiponiveledusForeignKey=tiponiveleduLogic.getTipoNivelEdus();
			}

			clienteReturnGeneral.settiponiveledusForeignKey(tiponiveledusForeignKey);


			List<Profesion> profesionsForeignKey=new ArrayList<Profesion>();
			ProfesionLogic profesionLogic=new ProfesionLogic();
			profesionLogic.setConnexion(this.connexion);
			profesionLogic.getProfesionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProfesion.equals("NONE")) {
				profesionLogic.getTodosProfesions(finalQueryGlobalProfesion,new Pagination());
				profesionsForeignKey=profesionLogic.getProfesions();
			}

			clienteReturnGeneral.setprofesionsForeignKey(profesionsForeignKey);


			List<TipoGenero> tipogenerosForeignKey=new ArrayList<TipoGenero>();
			TipoGeneroLogic tipogeneroLogic=new TipoGeneroLogic();
			tipogeneroLogic.setConnexion(this.connexion);
			tipogeneroLogic.getTipoGeneroDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoGenero.equals("NONE")) {
				tipogeneroLogic.getTodosTipoGeneros(finalQueryGlobalTipoGenero,new Pagination());
				tipogenerosForeignKey=tipogeneroLogic.getTipoGeneros();
			}

			clienteReturnGeneral.settipogenerosForeignKey(tipogenerosForeignKey);


			List<EstadoCivil> estadocivilsForeignKey=new ArrayList<EstadoCivil>();
			EstadoCivilLogic estadocivilLogic=new EstadoCivilLogic();
			estadocivilLogic.setConnexion(this.connexion);
			estadocivilLogic.getEstadoCivilDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoCivil.equals("NONE")) {
				estadocivilLogic.getTodosEstadoCivils(finalQueryGlobalEstadoCivil,new Pagination());
				estadocivilsForeignKey=estadocivilLogic.getEstadoCivils();
			}

			clienteReturnGeneral.setestadocivilsForeignKey(estadocivilsForeignKey);


			List<EstadoLegal> estadolegalsForeignKey=new ArrayList<EstadoLegal>();
			EstadoLegalLogic estadolegalLogic=new EstadoLegalLogic();
			estadolegalLogic.setConnexion(this.connexion);
			estadolegalLogic.getEstadoLegalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoLegal.equals("NONE")) {
				estadolegalLogic.getTodosEstadoLegals(finalQueryGlobalEstadoLegal,new Pagination());
				estadolegalsForeignKey=estadolegalLogic.getEstadoLegals();
			}

			clienteReturnGeneral.setestadolegalsForeignKey(estadolegalsForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			clienteReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<Ruta> rutasForeignKey=new ArrayList<Ruta>();
			RutaLogic rutaLogic=new RutaLogic();
			rutaLogic.setConnexion(this.connexion);
			rutaLogic.getRutaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRuta.equals("NONE")) {
				rutaLogic.getTodosRutas(finalQueryGlobalRuta,new Pagination());
				rutasForeignKey=rutaLogic.getRutas();
			}

			clienteReturnGeneral.setrutasForeignKey(rutasForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			clienteReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<CentroActividad> centroactividadsForeignKey=new ArrayList<CentroActividad>();
			CentroActividadLogic centroactividadLogic=new CentroActividadLogic();
			centroactividadLogic.setConnexion(this.connexion);
			centroactividadLogic.getCentroActividadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroActividad.equals("NONE")) {
				centroactividadLogic.getTodosCentroActividads(finalQueryGlobalCentroActividad,new Pagination());
				centroactividadsForeignKey=centroactividadLogic.getCentroActividads();
			}

			clienteReturnGeneral.setcentroactividadsForeignKey(centroactividadsForeignKey);


			List<TipoGarantiaEmpresa> tipogarantiaempresasForeignKey=new ArrayList<TipoGarantiaEmpresa>();
			TipoGarantiaEmpresaLogic tipogarantiaempresaLogic=new TipoGarantiaEmpresaLogic();
			tipogarantiaempresaLogic.setConnexion(this.connexion);
			//tipogarantiaempresaLogic.getTipoGarantiaEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoGarantiaEmpresa.equals("NONE")) {
				tipogarantiaempresaLogic.getTodosTipoGarantiaEmpresas(finalQueryGlobalTipoGarantiaEmpresa,new Pagination());
				tipogarantiaempresasForeignKey=tipogarantiaempresaLogic.getTipoGarantiaEmpresas();
			}

			clienteReturnGeneral.settipogarantiaempresasForeignKey(tipogarantiaempresasForeignKey);


			List<CateTipoAfiliacion> catetipoafiliacionsForeignKey=new ArrayList<CateTipoAfiliacion>();
			CateTipoAfiliacionLogic catetipoafiliacionLogic=new CateTipoAfiliacionLogic();
			catetipoafiliacionLogic.setConnexion(this.connexion);
			//catetipoafiliacionLogic.getCateTipoAfiliacionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCateTipoAfiliacion.equals("NONE")) {
				catetipoafiliacionLogic.getTodosCateTipoAfiliacions(finalQueryGlobalCateTipoAfiliacion,new Pagination());
				catetipoafiliacionsForeignKey=catetipoafiliacionLogic.getCateTipoAfiliacions();
			}

			clienteReturnGeneral.setcatetipoafiliacionsForeignKey(catetipoafiliacionsForeignKey);


			List<Dia> diasForeignKey=new ArrayList<Dia>();
			DiaLogic diaLogic=new DiaLogic();
			diaLogic.setConnexion(this.connexion);
			diaLogic.getDiaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDia.equals("NONE")) {
				diaLogic.getTodosDias(finalQueryGlobalDia,new Pagination());
				diasForeignKey=diaLogic.getDias();
			}

			clienteReturnGeneral.setdiasForeignKey(diasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			clienteReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<TipoPrecio> tipopreciosForeignKey=new ArrayList<TipoPrecio>();
			TipoPrecioLogic tipoprecioLogic=new TipoPrecioLogic();
			tipoprecioLogic.setConnexion(this.connexion);
			tipoprecioLogic.getTipoPrecioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPrecio.equals("NONE")) {
				tipoprecioLogic.getTodosTipoPrecios(finalQueryGlobalTipoPrecio,new Pagination());
				tipopreciosForeignKey=tipoprecioLogic.getTipoPrecios();
			}

			clienteReturnGeneral.settipopreciosForeignKey(tipopreciosForeignKey);


			List<TipoListaPrecio> tipolistapreciosForeignKey=new ArrayList<TipoListaPrecio>();
			TipoListaPrecioLogic tipolistaprecioLogic=new TipoListaPrecioLogic();
			tipolistaprecioLogic.setConnexion(this.connexion);
			tipolistaprecioLogic.getTipoListaPrecioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoListaPrecio.equals("NONE")) {
				tipolistaprecioLogic.getTodosTipoListaPrecios(finalQueryGlobalTipoListaPrecio,new Pagination());
				tipolistapreciosForeignKey=tipolistaprecioLogic.getTipoListaPrecios();
			}

			clienteReturnGeneral.settipolistapreciosForeignKey(tipolistapreciosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return clienteReturnGeneral;
	}
	
	public ClienteParameterReturnGeneral cargarCombosLoteForeignKeyCliente(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalTipoIdentificacion,String finalQueryGlobalGrupoCliente,String finalQueryGlobalTituloCliente,String finalQueryGlobalAreaCr,String finalQueryGlobalEstadoCliente,String finalQueryGlobalPais,String finalQueryGlobalRegion,String finalQueryGlobalProvincia,String finalQueryGlobalCiudad,String finalQueryGlobalZona,String finalQueryGlobalPaisNacionalidad,String finalQueryGlobalTipoCargoLabo,String finalQueryGlobalTipoNivelEdu,String finalQueryGlobalProfesion,String finalQueryGlobalTipoGenero,String finalQueryGlobalEstadoCivil,String finalQueryGlobalEstadoLegal,String finalQueryGlobalCuentaContable,String finalQueryGlobalRuta,String finalQueryGlobalVendedor,String finalQueryGlobalCentroActividad,String finalQueryGlobalTipoGarantiaEmpresa,String finalQueryGlobalCateTipoAfiliacion,String finalQueryGlobalDia,String finalQueryGlobalEmpleado,String finalQueryGlobalTipoPrecio,String finalQueryGlobalTipoListaPrecio) throws Exception {
		ClienteParameterReturnGeneral  clienteReturnGeneral =new ClienteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			clienteReturnGeneral =new ClienteParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			clienteReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			clienteReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<TipoIdentificacion> tipoidentificacionsForeignKey=new ArrayList<TipoIdentificacion>();
			TipoIdentificacionLogic tipoidentificacionLogic=new TipoIdentificacionLogic();
			tipoidentificacionLogic.setConnexion(this.connexion);
			tipoidentificacionLogic.getTipoIdentificacionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoIdentificacion.equals("NONE")) {
				tipoidentificacionLogic.getTodosTipoIdentificacions(finalQueryGlobalTipoIdentificacion,new Pagination());
				tipoidentificacionsForeignKey=tipoidentificacionLogic.getTipoIdentificacions();
			}

			clienteReturnGeneral.settipoidentificacionsForeignKey(tipoidentificacionsForeignKey);


			List<GrupoCliente> grupoclientesForeignKey=new ArrayList<GrupoCliente>();
			GrupoClienteLogic grupoclienteLogic=new GrupoClienteLogic();
			grupoclienteLogic.setConnexion(this.connexion);
			grupoclienteLogic.getGrupoClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalGrupoCliente.equals("NONE")) {
				grupoclienteLogic.getTodosGrupoClientes(finalQueryGlobalGrupoCliente,new Pagination());
				grupoclientesForeignKey=grupoclienteLogic.getGrupoClientes();
			}

			clienteReturnGeneral.setgrupoclientesForeignKey(grupoclientesForeignKey);


			List<TituloCliente> tituloclientesForeignKey=new ArrayList<TituloCliente>();
			TituloClienteLogic tituloclienteLogic=new TituloClienteLogic();
			tituloclienteLogic.setConnexion(this.connexion);
			tituloclienteLogic.getTituloClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTituloCliente.equals("NONE")) {
				tituloclienteLogic.getTodosTituloClientes(finalQueryGlobalTituloCliente,new Pagination());
				tituloclientesForeignKey=tituloclienteLogic.getTituloClientes();
			}

			clienteReturnGeneral.settituloclientesForeignKey(tituloclientesForeignKey);


			List<AreaCr> areacrsForeignKey=new ArrayList<AreaCr>();
			AreaCrLogic areacrLogic=new AreaCrLogic();
			areacrLogic.setConnexion(this.connexion);
			areacrLogic.getAreaCrDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAreaCr.equals("NONE")) {
				areacrLogic.getTodosAreaCrs(finalQueryGlobalAreaCr,new Pagination());
				areacrsForeignKey=areacrLogic.getAreaCrs();
			}

			clienteReturnGeneral.setareacrsForeignKey(areacrsForeignKey);


			List<EstadoCliente> estadoclientesForeignKey=new ArrayList<EstadoCliente>();
			EstadoClienteLogic estadoclienteLogic=new EstadoClienteLogic();
			estadoclienteLogic.setConnexion(this.connexion);
			//estadoclienteLogic.getEstadoClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoCliente.equals("NONE")) {
				estadoclienteLogic.getTodosEstadoClientes(finalQueryGlobalEstadoCliente,new Pagination());
				estadoclientesForeignKey=estadoclienteLogic.getEstadoClientes();
			}

			clienteReturnGeneral.setestadoclientesForeignKey(estadoclientesForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			clienteReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Region> regionsForeignKey=new ArrayList<Region>();
			RegionLogic regionLogic=new RegionLogic();
			regionLogic.setConnexion(this.connexion);
			regionLogic.getRegionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRegion.equals("NONE")) {
				regionLogic.getTodosRegions(finalQueryGlobalRegion,new Pagination());
				regionsForeignKey=regionLogic.getRegions();
			}

			clienteReturnGeneral.setregionsForeignKey(regionsForeignKey);


			List<Provincia> provinciasForeignKey=new ArrayList<Provincia>();
			ProvinciaLogic provinciaLogic=new ProvinciaLogic();
			provinciaLogic.setConnexion(this.connexion);
			provinciaLogic.getProvinciaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProvincia.equals("NONE")) {
				provinciaLogic.getTodosProvincias(finalQueryGlobalProvincia,new Pagination());
				provinciasForeignKey=provinciaLogic.getProvincias();
			}

			clienteReturnGeneral.setprovinciasForeignKey(provinciasForeignKey);


			List<Ciudad> ciudadsForeignKey=new ArrayList<Ciudad>();
			CiudadLogic ciudadLogic=new CiudadLogic();
			ciudadLogic.setConnexion(this.connexion);
			ciudadLogic.getCiudadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCiudad.equals("NONE")) {
				ciudadLogic.getTodosCiudads(finalQueryGlobalCiudad,new Pagination());
				ciudadsForeignKey=ciudadLogic.getCiudads();
			}

			clienteReturnGeneral.setciudadsForeignKey(ciudadsForeignKey);


			List<Zona> zonasForeignKey=new ArrayList<Zona>();
			ZonaLogic zonaLogic=new ZonaLogic();
			zonaLogic.setConnexion(this.connexion);
			zonaLogic.getZonaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalZona.equals("NONE")) {
				zonaLogic.getTodosZonas(finalQueryGlobalZona,new Pagination());
				zonasForeignKey=zonaLogic.getZonas();
			}

			clienteReturnGeneral.setzonasForeignKey(zonasForeignKey);


			List<Pais> paisnacionalidadsForeignKey=new ArrayList<Pais>();
			PaisLogic paisnacionalidadLogic=new PaisLogic();
			paisnacionalidadLogic.setConnexion(this.connexion);
			paisnacionalidadLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPaisNacionalidad.equals("NONE")) {
				paisnacionalidadLogic.getTodosPaiss(finalQueryGlobalPaisNacionalidad,new Pagination());
				paisnacionalidadsForeignKey=paisnacionalidadLogic.getPaiss();
			}

			clienteReturnGeneral.setpaisnacionalidadsForeignKey(paisnacionalidadsForeignKey);


			List<TipoCargoLabo> tipocargolabosForeignKey=new ArrayList<TipoCargoLabo>();
			TipoCargoLaboLogic tipocargolaboLogic=new TipoCargoLaboLogic();
			tipocargolaboLogic.setConnexion(this.connexion);
			tipocargolaboLogic.getTipoCargoLaboDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCargoLabo.equals("NONE")) {
				tipocargolaboLogic.getTodosTipoCargoLabos(finalQueryGlobalTipoCargoLabo,new Pagination());
				tipocargolabosForeignKey=tipocargolaboLogic.getTipoCargoLabos();
			}

			clienteReturnGeneral.settipocargolabosForeignKey(tipocargolabosForeignKey);


			List<TipoNivelEdu> tiponiveledusForeignKey=new ArrayList<TipoNivelEdu>();
			TipoNivelEduLogic tiponiveleduLogic=new TipoNivelEduLogic();
			tiponiveleduLogic.setConnexion(this.connexion);
			//tiponiveleduLogic.getTipoNivelEduDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoNivelEdu.equals("NONE")) {
				tiponiveleduLogic.getTodosTipoNivelEdus(finalQueryGlobalTipoNivelEdu,new Pagination());
				tiponiveledusForeignKey=tiponiveleduLogic.getTipoNivelEdus();
			}

			clienteReturnGeneral.settiponiveledusForeignKey(tiponiveledusForeignKey);


			List<Profesion> profesionsForeignKey=new ArrayList<Profesion>();
			ProfesionLogic profesionLogic=new ProfesionLogic();
			profesionLogic.setConnexion(this.connexion);
			profesionLogic.getProfesionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProfesion.equals("NONE")) {
				profesionLogic.getTodosProfesions(finalQueryGlobalProfesion,new Pagination());
				profesionsForeignKey=profesionLogic.getProfesions();
			}

			clienteReturnGeneral.setprofesionsForeignKey(profesionsForeignKey);


			List<TipoGenero> tipogenerosForeignKey=new ArrayList<TipoGenero>();
			TipoGeneroLogic tipogeneroLogic=new TipoGeneroLogic();
			tipogeneroLogic.setConnexion(this.connexion);
			tipogeneroLogic.getTipoGeneroDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoGenero.equals("NONE")) {
				tipogeneroLogic.getTodosTipoGeneros(finalQueryGlobalTipoGenero,new Pagination());
				tipogenerosForeignKey=tipogeneroLogic.getTipoGeneros();
			}

			clienteReturnGeneral.settipogenerosForeignKey(tipogenerosForeignKey);


			List<EstadoCivil> estadocivilsForeignKey=new ArrayList<EstadoCivil>();
			EstadoCivilLogic estadocivilLogic=new EstadoCivilLogic();
			estadocivilLogic.setConnexion(this.connexion);
			estadocivilLogic.getEstadoCivilDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoCivil.equals("NONE")) {
				estadocivilLogic.getTodosEstadoCivils(finalQueryGlobalEstadoCivil,new Pagination());
				estadocivilsForeignKey=estadocivilLogic.getEstadoCivils();
			}

			clienteReturnGeneral.setestadocivilsForeignKey(estadocivilsForeignKey);


			List<EstadoLegal> estadolegalsForeignKey=new ArrayList<EstadoLegal>();
			EstadoLegalLogic estadolegalLogic=new EstadoLegalLogic();
			estadolegalLogic.setConnexion(this.connexion);
			estadolegalLogic.getEstadoLegalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoLegal.equals("NONE")) {
				estadolegalLogic.getTodosEstadoLegals(finalQueryGlobalEstadoLegal,new Pagination());
				estadolegalsForeignKey=estadolegalLogic.getEstadoLegals();
			}

			clienteReturnGeneral.setestadolegalsForeignKey(estadolegalsForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			clienteReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<Ruta> rutasForeignKey=new ArrayList<Ruta>();
			RutaLogic rutaLogic=new RutaLogic();
			rutaLogic.setConnexion(this.connexion);
			rutaLogic.getRutaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRuta.equals("NONE")) {
				rutaLogic.getTodosRutas(finalQueryGlobalRuta,new Pagination());
				rutasForeignKey=rutaLogic.getRutas();
			}

			clienteReturnGeneral.setrutasForeignKey(rutasForeignKey);


			List<Vendedor> vendedorsForeignKey=new ArrayList<Vendedor>();
			VendedorLogic vendedorLogic=new VendedorLogic();
			vendedorLogic.setConnexion(this.connexion);
			vendedorLogic.getVendedorDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVendedor.equals("NONE")) {
				vendedorLogic.getTodosVendedors(finalQueryGlobalVendedor,new Pagination());
				vendedorsForeignKey=vendedorLogic.getVendedors();
			}

			clienteReturnGeneral.setvendedorsForeignKey(vendedorsForeignKey);


			List<CentroActividad> centroactividadsForeignKey=new ArrayList<CentroActividad>();
			CentroActividadLogic centroactividadLogic=new CentroActividadLogic();
			centroactividadLogic.setConnexion(this.connexion);
			centroactividadLogic.getCentroActividadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroActividad.equals("NONE")) {
				centroactividadLogic.getTodosCentroActividads(finalQueryGlobalCentroActividad,new Pagination());
				centroactividadsForeignKey=centroactividadLogic.getCentroActividads();
			}

			clienteReturnGeneral.setcentroactividadsForeignKey(centroactividadsForeignKey);


			List<TipoGarantiaEmpresa> tipogarantiaempresasForeignKey=new ArrayList<TipoGarantiaEmpresa>();
			TipoGarantiaEmpresaLogic tipogarantiaempresaLogic=new TipoGarantiaEmpresaLogic();
			tipogarantiaempresaLogic.setConnexion(this.connexion);
			//tipogarantiaempresaLogic.getTipoGarantiaEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoGarantiaEmpresa.equals("NONE")) {
				tipogarantiaempresaLogic.getTodosTipoGarantiaEmpresas(finalQueryGlobalTipoGarantiaEmpresa,new Pagination());
				tipogarantiaempresasForeignKey=tipogarantiaempresaLogic.getTipoGarantiaEmpresas();
			}

			clienteReturnGeneral.settipogarantiaempresasForeignKey(tipogarantiaempresasForeignKey);


			List<CateTipoAfiliacion> catetipoafiliacionsForeignKey=new ArrayList<CateTipoAfiliacion>();
			CateTipoAfiliacionLogic catetipoafiliacionLogic=new CateTipoAfiliacionLogic();
			catetipoafiliacionLogic.setConnexion(this.connexion);
			//catetipoafiliacionLogic.getCateTipoAfiliacionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCateTipoAfiliacion.equals("NONE")) {
				catetipoafiliacionLogic.getTodosCateTipoAfiliacions(finalQueryGlobalCateTipoAfiliacion,new Pagination());
				catetipoafiliacionsForeignKey=catetipoafiliacionLogic.getCateTipoAfiliacions();
			}

			clienteReturnGeneral.setcatetipoafiliacionsForeignKey(catetipoafiliacionsForeignKey);


			List<Dia> diasForeignKey=new ArrayList<Dia>();
			DiaLogic diaLogic=new DiaLogic();
			diaLogic.setConnexion(this.connexion);
			diaLogic.getDiaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDia.equals("NONE")) {
				diaLogic.getTodosDias(finalQueryGlobalDia,new Pagination());
				diasForeignKey=diaLogic.getDias();
			}

			clienteReturnGeneral.setdiasForeignKey(diasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			clienteReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<TipoPrecio> tipopreciosForeignKey=new ArrayList<TipoPrecio>();
			TipoPrecioLogic tipoprecioLogic=new TipoPrecioLogic();
			tipoprecioLogic.setConnexion(this.connexion);
			tipoprecioLogic.getTipoPrecioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPrecio.equals("NONE")) {
				tipoprecioLogic.getTodosTipoPrecios(finalQueryGlobalTipoPrecio,new Pagination());
				tipopreciosForeignKey=tipoprecioLogic.getTipoPrecios();
			}

			clienteReturnGeneral.settipopreciosForeignKey(tipopreciosForeignKey);


			List<TipoListaPrecio> tipolistapreciosForeignKey=new ArrayList<TipoListaPrecio>();
			TipoListaPrecioLogic tipolistaprecioLogic=new TipoListaPrecioLogic();
			tipolistaprecioLogic.setConnexion(this.connexion);
			tipolistaprecioLogic.getTipoListaPrecioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoListaPrecio.equals("NONE")) {
				tipolistaprecioLogic.getTodosTipoListaPrecios(finalQueryGlobalTipoListaPrecio,new Pagination());
				tipolistapreciosForeignKey=tipolistaprecioLogic.getTipoListaPrecios();
			}

			clienteReturnGeneral.settipolistapreciosForeignKey(tipolistapreciosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return clienteReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyClienteWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			InformacionLaboralLogic informacionlaboralLogic=new InformacionLaboralLogic();
			TransportistaLogic transportistaLogic=new TransportistaLogic();
			NovedadLogic novedadLogic=new NovedadLogic();
			PoliticasClienteLogic politicasclienteLogic=new PoliticasClienteLogic();
			ReferenciaPersonalLogic referenciapersonalLogic=new ReferenciaPersonalLogic();
			BalanceGeneralClienteLogic balancegeneralclienteLogic=new BalanceGeneralClienteLogic();
			PoliticaClienteLogic politicaclienteLogic=new PoliticaClienteLogic();
			VehiculoClienteLogic vehiculoclienteLogic=new VehiculoClienteLogic();
			ResponsableLogic responsableLogic=new ResponsableLogic();
			InformacionFinancieraLogic informacionfinancieraLogic=new InformacionFinancieraLogic();
			ConsignatarioLogic consignatarioLogic=new ConsignatarioLogic();
			ClienteImagenLogic clienteimagenLogic=new ClienteImagenLogic();
			GarantiaClienteLogic garantiaclienteLogic=new GarantiaClienteLogic();
			InformacionEconomicaLogic informacioneconomicaLogic=new InformacionEconomicaLogic();
			ReferenciaComercialLogic referenciacomercialLogic=new ReferenciaComercialLogic();
			BienLogic bienLogic=new BienLogic();
			ProveedorProductoLogic proveedorproductoLogic=new ProveedorProductoLogic();
			ServicioClienteLogic servicioclienteLogic=new ServicioClienteLogic();
			ContactoClienteLogic contactoclienteLogic=new ContactoClienteLogic();
			DatoConstitucionLogic datoconstitucionLogic=new DatoConstitucionLogic();
			ClienteCoaLogic clientecoaLogic=new ClienteCoaLogic();
			HobbyClienteLogic hobbyclienteLogic=new HobbyClienteLogic();
			CargaFamiliarLogic cargafamiliarLogic=new CargaFamiliarLogic();
			EMailLogic emailLogic=new EMailLogic();
			ConyugeLogic conyugeLogic=new ConyugeLogic();
			CuentaPorCobrarLogic cuentaporcobrarLogic=new CuentaPorCobrarLogic();
			FirmaClienteLogic firmaclienteLogic=new FirmaClienteLogic();
			RepresentanteLegalLogic representantelegalLogic=new RepresentanteLegalLogic();
			TelefonoLogic telefonoLogic=new TelefonoLogic();
			NegocioClienteLogic negocioclienteLogic=new NegocioClienteLogic();
			ReferenciaBancariaLogic referenciabancariaLogic=new ReferenciaBancariaLogic();
			MontoLogic montoLogic=new MontoLogic();
			ClienteArchivoLogic clientearchivoLogic=new ClienteArchivoLogic();
			ActividadEconomicaLogic actividadeconomicaLogic=new ActividadEconomicaLogic();
			DireccionLogic direccionLogic=new DireccionLogic();
			ChequePostFechadoLogic chequepostfechadoLogic=new ChequePostFechadoLogic();
			SubClienteLogic subclienteLogic=new SubClienteLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyClienteWithConnection");connexion.begin();
			
			
			classes.add(new Classe(InformacionLaboral.class));
			classes.add(new Classe(Transportista.class));
			classes.add(new Classe(Novedad.class));
			classes.add(new Classe(PoliticasCliente.class));
			classes.add(new Classe(ReferenciaPersonal.class));
			classes.add(new Classe(BalanceGeneralCliente.class));
			classes.add(new Classe(PoliticaCliente.class));
			classes.add(new Classe(VehiculoCliente.class));
			classes.add(new Classe(Responsable.class));
			classes.add(new Classe(InformacionFinanciera.class));
			classes.add(new Classe(Consignatario.class));
			classes.add(new Classe(ClienteImagen.class));
			classes.add(new Classe(GarantiaCliente.class));
			classes.add(new Classe(InformacionEconomica.class));
			classes.add(new Classe(ReferenciaComercial.class));
			classes.add(new Classe(Bien.class));
			classes.add(new Classe(ProveedorProducto.class));
			classes.add(new Classe(ServicioCliente.class));
			classes.add(new Classe(ContactoCliente.class));
			classes.add(new Classe(DatoConstitucion.class));
			classes.add(new Classe(ClienteCoa.class));
			classes.add(new Classe(HobbyCliente.class));
			classes.add(new Classe(CargaFamiliar.class));
			classes.add(new Classe(EMail.class));
			classes.add(new Classe(Conyuge.class));
			classes.add(new Classe(CuentaPorCobrar.class));
			classes.add(new Classe(FirmaCliente.class));
			classes.add(new Classe(RepresentanteLegal.class));
			classes.add(new Classe(Telefono.class));
			classes.add(new Classe(NegocioCliente.class));
			classes.add(new Classe(ReferenciaBancaria.class));
			classes.add(new Classe(Monto.class));
			classes.add(new Classe(ClienteArchivo.class));
			classes.add(new Classe(ActividadEconomica.class));
			classes.add(new Classe(Direccion.class));
			classes.add(new Classe(ChequePostFechado.class));
			classes.add(new Classe(SubCliente.class));
											
			

			informacionlaboralLogic.setConnexion(this.getConnexion());
			informacionlaboralLogic.setDatosCliente(this.datosCliente);
			informacionlaboralLogic.setIsConRefrescarForeignKeys(true);

			transportistaLogic.setConnexion(this.getConnexion());
			transportistaLogic.setDatosCliente(this.datosCliente);
			transportistaLogic.setIsConRefrescarForeignKeys(true);

			novedadLogic.setConnexion(this.getConnexion());
			novedadLogic.setDatosCliente(this.datosCliente);
			novedadLogic.setIsConRefrescarForeignKeys(true);

			politicasclienteLogic.setConnexion(this.getConnexion());
			politicasclienteLogic.setDatosCliente(this.datosCliente);
			politicasclienteLogic.setIsConRefrescarForeignKeys(true);

			referenciapersonalLogic.setConnexion(this.getConnexion());
			referenciapersonalLogic.setDatosCliente(this.datosCliente);
			referenciapersonalLogic.setIsConRefrescarForeignKeys(true);

			balancegeneralclienteLogic.setConnexion(this.getConnexion());
			balancegeneralclienteLogic.setDatosCliente(this.datosCliente);
			balancegeneralclienteLogic.setIsConRefrescarForeignKeys(true);

			politicaclienteLogic.setConnexion(this.getConnexion());
			politicaclienteLogic.setDatosCliente(this.datosCliente);
			politicaclienteLogic.setIsConRefrescarForeignKeys(true);

			vehiculoclienteLogic.setConnexion(this.getConnexion());
			vehiculoclienteLogic.setDatosCliente(this.datosCliente);
			vehiculoclienteLogic.setIsConRefrescarForeignKeys(true);

			responsableLogic.setConnexion(this.getConnexion());
			responsableLogic.setDatosCliente(this.datosCliente);
			responsableLogic.setIsConRefrescarForeignKeys(true);

			informacionfinancieraLogic.setConnexion(this.getConnexion());
			informacionfinancieraLogic.setDatosCliente(this.datosCliente);
			informacionfinancieraLogic.setIsConRefrescarForeignKeys(true);

			consignatarioLogic.setConnexion(this.getConnexion());
			consignatarioLogic.setDatosCliente(this.datosCliente);
			consignatarioLogic.setIsConRefrescarForeignKeys(true);

			clienteimagenLogic.setConnexion(this.getConnexion());
			clienteimagenLogic.setDatosCliente(this.datosCliente);
			clienteimagenLogic.setIsConRefrescarForeignKeys(true);

			garantiaclienteLogic.setConnexion(this.getConnexion());
			garantiaclienteLogic.setDatosCliente(this.datosCliente);
			garantiaclienteLogic.setIsConRefrescarForeignKeys(true);

			informacioneconomicaLogic.setConnexion(this.getConnexion());
			informacioneconomicaLogic.setDatosCliente(this.datosCliente);
			informacioneconomicaLogic.setIsConRefrescarForeignKeys(true);

			referenciacomercialLogic.setConnexion(this.getConnexion());
			referenciacomercialLogic.setDatosCliente(this.datosCliente);
			referenciacomercialLogic.setIsConRefrescarForeignKeys(true);

			bienLogic.setConnexion(this.getConnexion());
			bienLogic.setDatosCliente(this.datosCliente);
			bienLogic.setIsConRefrescarForeignKeys(true);

			proveedorproductoLogic.setConnexion(this.getConnexion());
			proveedorproductoLogic.setDatosCliente(this.datosCliente);
			proveedorproductoLogic.setIsConRefrescarForeignKeys(true);

			servicioclienteLogic.setConnexion(this.getConnexion());
			servicioclienteLogic.setDatosCliente(this.datosCliente);
			servicioclienteLogic.setIsConRefrescarForeignKeys(true);

			contactoclienteLogic.setConnexion(this.getConnexion());
			contactoclienteLogic.setDatosCliente(this.datosCliente);
			contactoclienteLogic.setIsConRefrescarForeignKeys(true);

			datoconstitucionLogic.setConnexion(this.getConnexion());
			datoconstitucionLogic.setDatosCliente(this.datosCliente);
			datoconstitucionLogic.setIsConRefrescarForeignKeys(true);

			clientecoaLogic.setConnexion(this.getConnexion());
			clientecoaLogic.setDatosCliente(this.datosCliente);
			clientecoaLogic.setIsConRefrescarForeignKeys(true);

			hobbyclienteLogic.setConnexion(this.getConnexion());
			hobbyclienteLogic.setDatosCliente(this.datosCliente);
			hobbyclienteLogic.setIsConRefrescarForeignKeys(true);

			cargafamiliarLogic.setConnexion(this.getConnexion());
			cargafamiliarLogic.setDatosCliente(this.datosCliente);
			cargafamiliarLogic.setIsConRefrescarForeignKeys(true);

			emailLogic.setConnexion(this.getConnexion());
			emailLogic.setDatosCliente(this.datosCliente);
			emailLogic.setIsConRefrescarForeignKeys(true);

			conyugeLogic.setConnexion(this.getConnexion());
			conyugeLogic.setDatosCliente(this.datosCliente);
			conyugeLogic.setIsConRefrescarForeignKeys(true);

			cuentaporcobrarLogic.setConnexion(this.getConnexion());
			cuentaporcobrarLogic.setDatosCliente(this.datosCliente);
			cuentaporcobrarLogic.setIsConRefrescarForeignKeys(true);

			firmaclienteLogic.setConnexion(this.getConnexion());
			firmaclienteLogic.setDatosCliente(this.datosCliente);
			firmaclienteLogic.setIsConRefrescarForeignKeys(true);

			representantelegalLogic.setConnexion(this.getConnexion());
			representantelegalLogic.setDatosCliente(this.datosCliente);
			representantelegalLogic.setIsConRefrescarForeignKeys(true);

			telefonoLogic.setConnexion(this.getConnexion());
			telefonoLogic.setDatosCliente(this.datosCliente);
			telefonoLogic.setIsConRefrescarForeignKeys(true);

			negocioclienteLogic.setConnexion(this.getConnexion());
			negocioclienteLogic.setDatosCliente(this.datosCliente);
			negocioclienteLogic.setIsConRefrescarForeignKeys(true);

			referenciabancariaLogic.setConnexion(this.getConnexion());
			referenciabancariaLogic.setDatosCliente(this.datosCliente);
			referenciabancariaLogic.setIsConRefrescarForeignKeys(true);

			montoLogic.setConnexion(this.getConnexion());
			montoLogic.setDatosCliente(this.datosCliente);
			montoLogic.setIsConRefrescarForeignKeys(true);

			clientearchivoLogic.setConnexion(this.getConnexion());
			clientearchivoLogic.setDatosCliente(this.datosCliente);
			clientearchivoLogic.setIsConRefrescarForeignKeys(true);

			actividadeconomicaLogic.setConnexion(this.getConnexion());
			actividadeconomicaLogic.setDatosCliente(this.datosCliente);
			actividadeconomicaLogic.setIsConRefrescarForeignKeys(true);

			direccionLogic.setConnexion(this.getConnexion());
			direccionLogic.setDatosCliente(this.datosCliente);
			direccionLogic.setIsConRefrescarForeignKeys(true);

			chequepostfechadoLogic.setConnexion(this.getConnexion());
			chequepostfechadoLogic.setDatosCliente(this.datosCliente);
			chequepostfechadoLogic.setIsConRefrescarForeignKeys(true);

			subclienteLogic.setConnexion(this.getConnexion());
			subclienteLogic.setDatosCliente(this.datosCliente);
			subclienteLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Cliente cliente:this.clientes) {
				

				classes=new ArrayList<Classe>();
				classes=InformacionLaboralConstantesFunciones.getClassesForeignKeysOfInformacionLaboral(new ArrayList<Classe>(),DeepLoadType.NONE);

				informacionlaboralLogic.setInformacionLaborals(cliente.informacionlaborals);
				informacionlaboralLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=TransportistaConstantesFunciones.getClassesForeignKeysOfTransportista(new ArrayList<Classe>(),DeepLoadType.NONE);

				transportistaLogic.setTransportistas(cliente.transportistas);
				transportistaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=NovedadConstantesFunciones.getClassesForeignKeysOfNovedad(new ArrayList<Classe>(),DeepLoadType.NONE);

				novedadLogic.setNovedads(cliente.novedads);
				novedadLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PoliticasClienteConstantesFunciones.getClassesForeignKeysOfPoliticasCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				politicasclienteLogic.setPoliticasCliente(cliente.politicascliente);
				politicasclienteLogic.deepLoad(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ReferenciaPersonalConstantesFunciones.getClassesForeignKeysOfReferenciaPersonal(new ArrayList<Classe>(),DeepLoadType.NONE);

				referenciapersonalLogic.setReferenciaPersonals(cliente.referenciapersonals);
				referenciapersonalLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=BalanceGeneralClienteConstantesFunciones.getClassesForeignKeysOfBalanceGeneralCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				balancegeneralclienteLogic.setBalanceGeneralClientes(cliente.balancegeneralclientes);
				balancegeneralclienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PoliticaClienteConstantesFunciones.getClassesForeignKeysOfPoliticaCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				politicaclienteLogic.setPoliticaClientes(cliente.politicaclientes);
				politicaclienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=VehiculoClienteConstantesFunciones.getClassesForeignKeysOfVehiculoCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				vehiculoclienteLogic.setVehiculoClientes(cliente.vehiculoclientes);
				vehiculoclienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ResponsableConstantesFunciones.getClassesForeignKeysOfResponsable(new ArrayList<Classe>(),DeepLoadType.NONE);

				responsableLogic.setResponsables(cliente.responsables);
				responsableLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=InformacionFinancieraConstantesFunciones.getClassesForeignKeysOfInformacionFinanciera(new ArrayList<Classe>(),DeepLoadType.NONE);

				informacionfinancieraLogic.setInformacionFinancieras(cliente.informacionfinancieras);
				informacionfinancieraLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ConsignatarioConstantesFunciones.getClassesForeignKeysOfConsignatario(new ArrayList<Classe>(),DeepLoadType.NONE);

				consignatarioLogic.setConsignatarios(cliente.consignatarios);
				consignatarioLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ClienteImagenConstantesFunciones.getClassesForeignKeysOfClienteImagen(new ArrayList<Classe>(),DeepLoadType.NONE);

				clienteimagenLogic.setClienteImagens(cliente.clienteimagens);
				clienteimagenLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=GarantiaClienteConstantesFunciones.getClassesForeignKeysOfGarantiaCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				garantiaclienteLogic.setGarantiaClientes(cliente.garantiaclientes);
				garantiaclienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=InformacionEconomicaConstantesFunciones.getClassesForeignKeysOfInformacionEconomica(new ArrayList<Classe>(),DeepLoadType.NONE);

				informacioneconomicaLogic.setInformacionEconomicas(cliente.informacioneconomicas);
				informacioneconomicaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ReferenciaComercialConstantesFunciones.getClassesForeignKeysOfReferenciaComercial(new ArrayList<Classe>(),DeepLoadType.NONE);

				referenciacomercialLogic.setReferenciaComercials(cliente.referenciacomercials);
				referenciacomercialLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=BienConstantesFunciones.getClassesForeignKeysOfBien(new ArrayList<Classe>(),DeepLoadType.NONE);

				bienLogic.setBiens(cliente.biens);
				bienLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ProveedorProductoConstantesFunciones.getClassesForeignKeysOfProveedorProducto(new ArrayList<Classe>(),DeepLoadType.NONE);

				proveedorproductoLogic.setProveedorProductos(cliente.proveedorproductos);
				proveedorproductoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ServicioClienteConstantesFunciones.getClassesForeignKeysOfServicioCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				servicioclienteLogic.setServicioClientes(cliente.servicioclientes);
				servicioclienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ContactoClienteConstantesFunciones.getClassesForeignKeysOfContactoCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				contactoclienteLogic.setContactoClientes(cliente.contactoclientes);
				contactoclienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DatoConstitucionConstantesFunciones.getClassesForeignKeysOfDatoConstitucion(new ArrayList<Classe>(),DeepLoadType.NONE);

				datoconstitucionLogic.setDatoConstitucions(cliente.datoconstitucions);
				datoconstitucionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ClienteCoaConstantesFunciones.getClassesForeignKeysOfClienteCoa(new ArrayList<Classe>(),DeepLoadType.NONE);

				clientecoaLogic.setClienteCoas(cliente.clientecoas);
				clientecoaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=HobbyClienteConstantesFunciones.getClassesForeignKeysOfHobbyCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				hobbyclienteLogic.setHobbyClientes(cliente.hobbyclientes);
				hobbyclienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=CargaFamiliarConstantesFunciones.getClassesForeignKeysOfCargaFamiliar(new ArrayList<Classe>(),DeepLoadType.NONE);

				cargafamiliarLogic.setCargaFamiliars(cliente.cargafamiliars);
				cargafamiliarLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=EMailConstantesFunciones.getClassesForeignKeysOfEMail(new ArrayList<Classe>(),DeepLoadType.NONE);

				emailLogic.setEMails(cliente.emails);
				emailLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ConyugeConstantesFunciones.getClassesForeignKeysOfConyuge(new ArrayList<Classe>(),DeepLoadType.NONE);

				conyugeLogic.setConyuge(cliente.conyuge);
				conyugeLogic.deepLoad(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=CuentaPorCobrarConstantesFunciones.getClassesForeignKeysOfCuentaPorCobrar(new ArrayList<Classe>(),DeepLoadType.NONE);

				cuentaporcobrarLogic.setCuentaPorCobrars(cliente.cuentaporcobrars);
				cuentaporcobrarLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=FirmaClienteConstantesFunciones.getClassesForeignKeysOfFirmaCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				firmaclienteLogic.setFirmaClientes(cliente.firmaclientes);
				firmaclienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=RepresentanteLegalConstantesFunciones.getClassesForeignKeysOfRepresentanteLegal(new ArrayList<Classe>(),DeepLoadType.NONE);

				representantelegalLogic.setRepresentanteLegals(cliente.representantelegals);
				representantelegalLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=TelefonoConstantesFunciones.getClassesForeignKeysOfTelefono(new ArrayList<Classe>(),DeepLoadType.NONE);

				telefonoLogic.setTelefonos(cliente.telefonos);
				telefonoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=NegocioClienteConstantesFunciones.getClassesForeignKeysOfNegocioCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				negocioclienteLogic.setNegocioClientes(cliente.negocioclientes);
				negocioclienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ReferenciaBancariaConstantesFunciones.getClassesForeignKeysOfReferenciaBancaria(new ArrayList<Classe>(),DeepLoadType.NONE);

				referenciabancariaLogic.setReferenciaBancarias(cliente.referenciabancarias);
				referenciabancariaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=MontoConstantesFunciones.getClassesForeignKeysOfMonto(new ArrayList<Classe>(),DeepLoadType.NONE);

				montoLogic.setMontos(cliente.montos);
				montoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ClienteArchivoConstantesFunciones.getClassesForeignKeysOfClienteArchivo(new ArrayList<Classe>(),DeepLoadType.NONE);

				clientearchivoLogic.setClienteArchivos(cliente.clientearchivos);
				clientearchivoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ActividadEconomicaConstantesFunciones.getClassesForeignKeysOfActividadEconomica(new ArrayList<Classe>(),DeepLoadType.NONE);

				actividadeconomicaLogic.setActividadEconomicas(cliente.actividadeconomicas);
				actividadeconomicaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DireccionConstantesFunciones.getClassesForeignKeysOfDireccion(new ArrayList<Classe>(),DeepLoadType.NONE);

				direccionLogic.setDireccions(cliente.direccions);
				direccionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ChequePostFechadoConstantesFunciones.getClassesForeignKeysOfChequePostFechado(new ArrayList<Classe>(),DeepLoadType.NONE);

				chequepostfechadoLogic.setChequePostFechados(cliente.chequepostfechados);
				chequepostfechadoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=SubClienteConstantesFunciones.getClassesForeignKeysOfSubCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				subclienteLogic.setSubClientes(cliente.subclientes);
				subclienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Cliente cliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ClienteLogicAdditional.updateClienteToGet(cliente,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cliente.setEmpresa(clienteDataAccess.getEmpresa(connexion,cliente));
		cliente.setSucursal(clienteDataAccess.getSucursal(connexion,cliente));
		cliente.setTipoIdentificacion(clienteDataAccess.getTipoIdentificacion(connexion,cliente));
		cliente.setGrupoCliente(clienteDataAccess.getGrupoCliente(connexion,cliente));
		cliente.setTituloCliente(clienteDataAccess.getTituloCliente(connexion,cliente));
		cliente.setAreaCr(clienteDataAccess.getAreaCr(connexion,cliente));
		cliente.setEstadoCliente(clienteDataAccess.getEstadoCliente(connexion,cliente));
		cliente.setPais(clienteDataAccess.getPais(connexion,cliente));
		cliente.setRegion(clienteDataAccess.getRegion(connexion,cliente));
		cliente.setProvincia(clienteDataAccess.getProvincia(connexion,cliente));
		cliente.setCiudad(clienteDataAccess.getCiudad(connexion,cliente));
		cliente.setZona(clienteDataAccess.getZona(connexion,cliente));
		cliente.setPaisNacionalidad(clienteDataAccess.getPaisNacionalidad(connexion,cliente));
		cliente.setTipoCargoLabo(clienteDataAccess.getTipoCargoLabo(connexion,cliente));
		cliente.setTipoNivelEdu(clienteDataAccess.getTipoNivelEdu(connexion,cliente));
		cliente.setProfesion(clienteDataAccess.getProfesion(connexion,cliente));
		cliente.setTipoGenero(clienteDataAccess.getTipoGenero(connexion,cliente));
		cliente.setEstadoCivil(clienteDataAccess.getEstadoCivil(connexion,cliente));
		cliente.setEstadoLegal(clienteDataAccess.getEstadoLegal(connexion,cliente));
		cliente.setCuentaContable(clienteDataAccess.getCuentaContable(connexion,cliente));
		cliente.setRuta(clienteDataAccess.getRuta(connexion,cliente));
		cliente.setVendedor(clienteDataAccess.getVendedor(connexion,cliente));
		cliente.setCentroActividad(clienteDataAccess.getCentroActividad(connexion,cliente));
		cliente.setTipoGarantiaEmpresa(clienteDataAccess.getTipoGarantiaEmpresa(connexion,cliente));
		cliente.setCateTipoAfiliacion(clienteDataAccess.getCateTipoAfiliacion(connexion,cliente));
		cliente.setDia(clienteDataAccess.getDia(connexion,cliente));
		cliente.setEmpleado(clienteDataAccess.getEmpleado(connexion,cliente));
		cliente.setTipoPrecio(clienteDataAccess.getTipoPrecio(connexion,cliente));
		cliente.setTipoListaPrecio(clienteDataAccess.getTipoListaPrecio(connexion,cliente));
		cliente.setContactoClientes(clienteDataAccess.getContactoClientes(connexion,cliente));
		cliente.setBiens(clienteDataAccess.getBiens(connexion,cliente));
		cliente.setCargaFamiliars(clienteDataAccess.getCargaFamiliars(connexion,cliente));
		cliente.setChequePostFechados(clienteDataAccess.getChequePostFechados(connexion,cliente));
		cliente.setEMails(clienteDataAccess.getEMails(connexion,cliente));
		cliente.setReferenciaPersonals(clienteDataAccess.getReferenciaPersonals(connexion,cliente));
		cliente.setGarantiaClientes(clienteDataAccess.getGarantiaClientes(connexion,cliente));
		cliente.setClienteArchivos(clienteDataAccess.getClienteArchivos(connexion,cliente));
		cliente.setPoliticasCliente(clienteDataAccess.getPoliticasCliente(connexion,cliente));
		cliente.setFirmaClientes(clienteDataAccess.getFirmaClientes(connexion,cliente));
		cliente.setReferenciaComercials(clienteDataAccess.getReferenciaComercials(connexion,cliente));
		cliente.setNovedads(clienteDataAccess.getNovedads(connexion,cliente));
		cliente.setInformacionLaborals(clienteDataAccess.getInformacionLaborals(connexion,cliente));
		cliente.setInformacionFinancieras(clienteDataAccess.getInformacionFinancieras(connexion,cliente));
		cliente.setTelefonos(clienteDataAccess.getTelefonos(connexion,cliente));
		cliente.setCuentaPorCobrars(clienteDataAccess.getCuentaPorCobrars(connexion,cliente));
		cliente.setResponsables(clienteDataAccess.getResponsables(connexion,cliente));
		cliente.setTransportistas(clienteDataAccess.getTransportistas(connexion,cliente));
		cliente.setPoliticaClientes(clienteDataAccess.getPoliticaClientes(connexion,cliente));
		cliente.setConyuge(clienteDataAccess.getConyuge(connexion,cliente));
		cliente.setReferenciaBancarias(clienteDataAccess.getReferenciaBancarias(connexion,cliente));
		cliente.setBalanceGeneralClientes(clienteDataAccess.getBalanceGeneralClientes(connexion,cliente));
		cliente.setDatoConstitucions(clienteDataAccess.getDatoConstitucions(connexion,cliente));
		cliente.setActividadEconomicas(clienteDataAccess.getActividadEconomicas(connexion,cliente));
		cliente.setProveedorProductos(clienteDataAccess.getProveedorProductos(connexion,cliente));
		cliente.setConsignatarios(clienteDataAccess.getConsignatarios(connexion,cliente));
		cliente.setHobbyClientes(clienteDataAccess.getHobbyClientes(connexion,cliente));
		cliente.setRepresentanteLegals(clienteDataAccess.getRepresentanteLegals(connexion,cliente));
		cliente.setClienteCoas(clienteDataAccess.getClienteCoas(connexion,cliente));
		cliente.setDireccions(clienteDataAccess.getDireccions(connexion,cliente));
		cliente.setClienteImagens(clienteDataAccess.getClienteImagens(connexion,cliente));
		cliente.setSubClientes(clienteDataAccess.getSubClientes(connexion,cliente));
		cliente.setServicioClientes(clienteDataAccess.getServicioClientes(connexion,cliente));
		cliente.setInformacionEconomicas(clienteDataAccess.getInformacionEconomicas(connexion,cliente));
		cliente.setVehiculoClientes(clienteDataAccess.getVehiculoClientes(connexion,cliente));
		cliente.setNegocioClientes(clienteDataAccess.getNegocioClientes(connexion,cliente));
		cliente.setMontos(clienteDataAccess.getMontos(connexion,cliente));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cliente.setEmpresa(clienteDataAccess.getEmpresa(connexion,cliente));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				cliente.setSucursal(clienteDataAccess.getSucursal(connexion,cliente));
				continue;
			}

			if(clas.clas.equals(TipoIdentificacion.class)) {
				cliente.setTipoIdentificacion(clienteDataAccess.getTipoIdentificacion(connexion,cliente));
				continue;
			}

			if(clas.clas.equals(GrupoCliente.class)) {
				cliente.setGrupoCliente(clienteDataAccess.getGrupoCliente(connexion,cliente));
				continue;
			}

			if(clas.clas.equals(TituloCliente.class)) {
				cliente.setTituloCliente(clienteDataAccess.getTituloCliente(connexion,cliente));
				continue;
			}

			if(clas.clas.equals(AreaCr.class)) {
				cliente.setAreaCr(clienteDataAccess.getAreaCr(connexion,cliente));
				continue;
			}

			if(clas.clas.equals(EstadoCliente.class)) {
				cliente.setEstadoCliente(clienteDataAccess.getEstadoCliente(connexion,cliente));
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				cliente.setPais(clienteDataAccess.getPais(connexion,cliente));
				continue;
			}

			if(clas.clas.equals(Region.class)) {
				cliente.setRegion(clienteDataAccess.getRegion(connexion,cliente));
				continue;
			}

			if(clas.clas.equals(Provincia.class)) {
				cliente.setProvincia(clienteDataAccess.getProvincia(connexion,cliente));
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				cliente.setCiudad(clienteDataAccess.getCiudad(connexion,cliente));
				continue;
			}

			if(clas.clas.equals(Zona.class)) {
				cliente.setZona(clienteDataAccess.getZona(connexion,cliente));
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				cliente.setPaisNacionalidad(clienteDataAccess.getPaisNacionalidad(connexion,cliente));
				continue;
			}

			if(clas.clas.equals(TipoCargoLabo.class)) {
				cliente.setTipoCargoLabo(clienteDataAccess.getTipoCargoLabo(connexion,cliente));
				continue;
			}

			if(clas.clas.equals(TipoNivelEdu.class)) {
				cliente.setTipoNivelEdu(clienteDataAccess.getTipoNivelEdu(connexion,cliente));
				continue;
			}

			if(clas.clas.equals(Profesion.class)) {
				cliente.setProfesion(clienteDataAccess.getProfesion(connexion,cliente));
				continue;
			}

			if(clas.clas.equals(TipoGenero.class)) {
				cliente.setTipoGenero(clienteDataAccess.getTipoGenero(connexion,cliente));
				continue;
			}

			if(clas.clas.equals(EstadoCivil.class)) {
				cliente.setEstadoCivil(clienteDataAccess.getEstadoCivil(connexion,cliente));
				continue;
			}

			if(clas.clas.equals(EstadoLegal.class)) {
				cliente.setEstadoLegal(clienteDataAccess.getEstadoLegal(connexion,cliente));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cliente.setCuentaContable(clienteDataAccess.getCuentaContable(connexion,cliente));
				continue;
			}

			if(clas.clas.equals(Ruta.class)) {
				cliente.setRuta(clienteDataAccess.getRuta(connexion,cliente));
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				cliente.setVendedor(clienteDataAccess.getVendedor(connexion,cliente));
				continue;
			}

			if(clas.clas.equals(CentroActividad.class)) {
				cliente.setCentroActividad(clienteDataAccess.getCentroActividad(connexion,cliente));
				continue;
			}

			if(clas.clas.equals(TipoGarantiaEmpresa.class)) {
				cliente.setTipoGarantiaEmpresa(clienteDataAccess.getTipoGarantiaEmpresa(connexion,cliente));
				continue;
			}

			if(clas.clas.equals(CateTipoAfiliacion.class)) {
				cliente.setCateTipoAfiliacion(clienteDataAccess.getCateTipoAfiliacion(connexion,cliente));
				continue;
			}

			if(clas.clas.equals(Dia.class)) {
				cliente.setDia(clienteDataAccess.getDia(connexion,cliente));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				cliente.setEmpleado(clienteDataAccess.getEmpleado(connexion,cliente));
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				cliente.setTipoPrecio(clienteDataAccess.getTipoPrecio(connexion,cliente));
				continue;
			}

			if(clas.clas.equals(TipoListaPrecio.class)) {
				cliente.setTipoListaPrecio(clienteDataAccess.getTipoListaPrecio(connexion,cliente));
				continue;
			}

			if(clas.clas.equals(ContactoCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setContactoClientes(clienteDataAccess.getContactoClientes(connexion,cliente));

				if(this.isConDeep) {
					ContactoClienteLogic contactoclienteLogic= new ContactoClienteLogic(this.connexion);
					contactoclienteLogic.setContactoClientes(cliente.getContactoClientes());
					ArrayList<Classe> classesLocal=ContactoClienteConstantesFunciones.getClassesForeignKeysOfContactoCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					contactoclienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ContactoClienteConstantesFunciones.refrescarForeignKeysDescripcionesContactoCliente(contactoclienteLogic.getContactoClientes());
					cliente.setContactoClientes(contactoclienteLogic.getContactoClientes());
				}

				continue;
			}

			if(clas.clas.equals(Bien.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setBiens(clienteDataAccess.getBiens(connexion,cliente));

				if(this.isConDeep) {
					BienLogic bienLogic= new BienLogic(this.connexion);
					bienLogic.setBiens(cliente.getBiens());
					ArrayList<Classe> classesLocal=BienConstantesFunciones.getClassesForeignKeysOfBien(new ArrayList<Classe>(),DeepLoadType.NONE);
					bienLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					BienConstantesFunciones.refrescarForeignKeysDescripcionesBien(bienLogic.getBiens());
					cliente.setBiens(bienLogic.getBiens());
				}

				continue;
			}

			if(clas.clas.equals(CargaFamiliar.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setCargaFamiliars(clienteDataAccess.getCargaFamiliars(connexion,cliente));

				if(this.isConDeep) {
					CargaFamiliarLogic cargafamiliarLogic= new CargaFamiliarLogic(this.connexion);
					cargafamiliarLogic.setCargaFamiliars(cliente.getCargaFamiliars());
					ArrayList<Classe> classesLocal=CargaFamiliarConstantesFunciones.getClassesForeignKeysOfCargaFamiliar(new ArrayList<Classe>(),DeepLoadType.NONE);
					cargafamiliarLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CargaFamiliarConstantesFunciones.refrescarForeignKeysDescripcionesCargaFamiliar(cargafamiliarLogic.getCargaFamiliars());
					cliente.setCargaFamiliars(cargafamiliarLogic.getCargaFamiliars());
				}

				continue;
			}

			if(clas.clas.equals(ChequePostFechado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setChequePostFechados(clienteDataAccess.getChequePostFechados(connexion,cliente));

				if(this.isConDeep) {
					ChequePostFechadoLogic chequepostfechadoLogic= new ChequePostFechadoLogic(this.connexion);
					chequepostfechadoLogic.setChequePostFechados(cliente.getChequePostFechados());
					ArrayList<Classe> classesLocal=ChequePostFechadoConstantesFunciones.getClassesForeignKeysOfChequePostFechado(new ArrayList<Classe>(),DeepLoadType.NONE);
					chequepostfechadoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ChequePostFechadoConstantesFunciones.refrescarForeignKeysDescripcionesChequePostFechado(chequepostfechadoLogic.getChequePostFechados());
					cliente.setChequePostFechados(chequepostfechadoLogic.getChequePostFechados());
				}

				continue;
			}

			if(clas.clas.equals(EMail.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setEMails(clienteDataAccess.getEMails(connexion,cliente));

				if(this.isConDeep) {
					EMailLogic emailLogic= new EMailLogic(this.connexion);
					emailLogic.setEMails(cliente.getEMails());
					ArrayList<Classe> classesLocal=EMailConstantesFunciones.getClassesForeignKeysOfEMail(new ArrayList<Classe>(),DeepLoadType.NONE);
					emailLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					EMailConstantesFunciones.refrescarForeignKeysDescripcionesEMail(emailLogic.getEMails());
					cliente.setEMails(emailLogic.getEMails());
				}

				continue;
			}

			if(clas.clas.equals(ReferenciaPersonal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setReferenciaPersonals(clienteDataAccess.getReferenciaPersonals(connexion,cliente));

				if(this.isConDeep) {
					ReferenciaPersonalLogic referenciapersonalLogic= new ReferenciaPersonalLogic(this.connexion);
					referenciapersonalLogic.setReferenciaPersonals(cliente.getReferenciaPersonals());
					ArrayList<Classe> classesLocal=ReferenciaPersonalConstantesFunciones.getClassesForeignKeysOfReferenciaPersonal(new ArrayList<Classe>(),DeepLoadType.NONE);
					referenciapersonalLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ReferenciaPersonalConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaPersonal(referenciapersonalLogic.getReferenciaPersonals());
					cliente.setReferenciaPersonals(referenciapersonalLogic.getReferenciaPersonals());
				}

				continue;
			}

			if(clas.clas.equals(GarantiaCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setGarantiaClientes(clienteDataAccess.getGarantiaClientes(connexion,cliente));

				if(this.isConDeep) {
					GarantiaClienteLogic garantiaclienteLogic= new GarantiaClienteLogic(this.connexion);
					garantiaclienteLogic.setGarantiaClientes(cliente.getGarantiaClientes());
					ArrayList<Classe> classesLocal=GarantiaClienteConstantesFunciones.getClassesForeignKeysOfGarantiaCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					garantiaclienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					GarantiaClienteConstantesFunciones.refrescarForeignKeysDescripcionesGarantiaCliente(garantiaclienteLogic.getGarantiaClientes());
					cliente.setGarantiaClientes(garantiaclienteLogic.getGarantiaClientes());
				}

				continue;
			}

			if(clas.clas.equals(ClienteArchivo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setClienteArchivos(clienteDataAccess.getClienteArchivos(connexion,cliente));

				if(this.isConDeep) {
					ClienteArchivoLogic clientearchivoLogic= new ClienteArchivoLogic(this.connexion);
					clientearchivoLogic.setClienteArchivos(cliente.getClienteArchivos());
					ArrayList<Classe> classesLocal=ClienteArchivoConstantesFunciones.getClassesForeignKeysOfClienteArchivo(new ArrayList<Classe>(),DeepLoadType.NONE);
					clientearchivoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ClienteArchivoConstantesFunciones.refrescarForeignKeysDescripcionesClienteArchivo(clientearchivoLogic.getClienteArchivos());
					cliente.setClienteArchivos(clientearchivoLogic.getClienteArchivos());
				}

				continue;
			}

			if(clas.clas.equals(PoliticasCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setPoliticasCliente(clienteDataAccess.getPoliticasCliente(connexion,cliente));

				if(this.isConDeep) {
					PoliticasClienteLogic politicasclienteLogic= new PoliticasClienteLogic(this.connexion);
					politicasclienteLogic.setPoliticasCliente(cliente.getPoliticasCliente());
					ArrayList<Classe> classesLocal=PoliticasClienteConstantesFunciones.getClassesForeignKeysOfPoliticasCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					politicasclienteLogic.deepLoad(false,DeepLoadType.INCLUDE, classesLocal,"");
					PoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticasCliente(politicasclienteLogic.getPoliticasCliente());
					cliente.setPoliticasCliente(politicasclienteLogic.getPoliticasCliente());
				}

				continue;
			}

			if(clas.clas.equals(FirmaCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setFirmaClientes(clienteDataAccess.getFirmaClientes(connexion,cliente));

				if(this.isConDeep) {
					FirmaClienteLogic firmaclienteLogic= new FirmaClienteLogic(this.connexion);
					firmaclienteLogic.setFirmaClientes(cliente.getFirmaClientes());
					ArrayList<Classe> classesLocal=FirmaClienteConstantesFunciones.getClassesForeignKeysOfFirmaCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					firmaclienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FirmaClienteConstantesFunciones.refrescarForeignKeysDescripcionesFirmaCliente(firmaclienteLogic.getFirmaClientes());
					cliente.setFirmaClientes(firmaclienteLogic.getFirmaClientes());
				}

				continue;
			}

			if(clas.clas.equals(ReferenciaComercial.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setReferenciaComercials(clienteDataAccess.getReferenciaComercials(connexion,cliente));

				if(this.isConDeep) {
					ReferenciaComercialLogic referenciacomercialLogic= new ReferenciaComercialLogic(this.connexion);
					referenciacomercialLogic.setReferenciaComercials(cliente.getReferenciaComercials());
					ArrayList<Classe> classesLocal=ReferenciaComercialConstantesFunciones.getClassesForeignKeysOfReferenciaComercial(new ArrayList<Classe>(),DeepLoadType.NONE);
					referenciacomercialLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ReferenciaComercialConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaComercial(referenciacomercialLogic.getReferenciaComercials());
					cliente.setReferenciaComercials(referenciacomercialLogic.getReferenciaComercials());
				}

				continue;
			}

			if(clas.clas.equals(Novedad.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setNovedads(clienteDataAccess.getNovedads(connexion,cliente));

				if(this.isConDeep) {
					NovedadLogic novedadLogic= new NovedadLogic(this.connexion);
					novedadLogic.setNovedads(cliente.getNovedads());
					ArrayList<Classe> classesLocal=NovedadConstantesFunciones.getClassesForeignKeysOfNovedad(new ArrayList<Classe>(),DeepLoadType.NONE);
					novedadLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					NovedadConstantesFunciones.refrescarForeignKeysDescripcionesNovedad(novedadLogic.getNovedads());
					cliente.setNovedads(novedadLogic.getNovedads());
				}

				continue;
			}

			if(clas.clas.equals(InformacionLaboral.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setInformacionLaborals(clienteDataAccess.getInformacionLaborals(connexion,cliente));

				if(this.isConDeep) {
					InformacionLaboralLogic informacionlaboralLogic= new InformacionLaboralLogic(this.connexion);
					informacionlaboralLogic.setInformacionLaborals(cliente.getInformacionLaborals());
					ArrayList<Classe> classesLocal=InformacionLaboralConstantesFunciones.getClassesForeignKeysOfInformacionLaboral(new ArrayList<Classe>(),DeepLoadType.NONE);
					informacionlaboralLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					InformacionLaboralConstantesFunciones.refrescarForeignKeysDescripcionesInformacionLaboral(informacionlaboralLogic.getInformacionLaborals());
					cliente.setInformacionLaborals(informacionlaboralLogic.getInformacionLaborals());
				}

				continue;
			}

			if(clas.clas.equals(InformacionFinanciera.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setInformacionFinancieras(clienteDataAccess.getInformacionFinancieras(connexion,cliente));

				if(this.isConDeep) {
					InformacionFinancieraLogic informacionfinancieraLogic= new InformacionFinancieraLogic(this.connexion);
					informacionfinancieraLogic.setInformacionFinancieras(cliente.getInformacionFinancieras());
					ArrayList<Classe> classesLocal=InformacionFinancieraConstantesFunciones.getClassesForeignKeysOfInformacionFinanciera(new ArrayList<Classe>(),DeepLoadType.NONE);
					informacionfinancieraLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					InformacionFinancieraConstantesFunciones.refrescarForeignKeysDescripcionesInformacionFinanciera(informacionfinancieraLogic.getInformacionFinancieras());
					cliente.setInformacionFinancieras(informacionfinancieraLogic.getInformacionFinancieras());
				}

				continue;
			}

			if(clas.clas.equals(Telefono.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setTelefonos(clienteDataAccess.getTelefonos(connexion,cliente));

				if(this.isConDeep) {
					TelefonoLogic telefonoLogic= new TelefonoLogic(this.connexion);
					telefonoLogic.setTelefonos(cliente.getTelefonos());
					ArrayList<Classe> classesLocal=TelefonoConstantesFunciones.getClassesForeignKeysOfTelefono(new ArrayList<Classe>(),DeepLoadType.NONE);
					telefonoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					TelefonoConstantesFunciones.refrescarForeignKeysDescripcionesTelefono(telefonoLogic.getTelefonos());
					cliente.setTelefonos(telefonoLogic.getTelefonos());
				}

				continue;
			}

			if(clas.clas.equals(CuentaPorCobrar.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setCuentaPorCobrars(clienteDataAccess.getCuentaPorCobrars(connexion,cliente));

				if(this.isConDeep) {
					CuentaPorCobrarLogic cuentaporcobrarLogic= new CuentaPorCobrarLogic(this.connexion);
					cuentaporcobrarLogic.setCuentaPorCobrars(cliente.getCuentaPorCobrars());
					ArrayList<Classe> classesLocal=CuentaPorCobrarConstantesFunciones.getClassesForeignKeysOfCuentaPorCobrar(new ArrayList<Classe>(),DeepLoadType.NONE);
					cuentaporcobrarLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CuentaPorCobrarConstantesFunciones.refrescarForeignKeysDescripcionesCuentaPorCobrar(cuentaporcobrarLogic.getCuentaPorCobrars());
					cliente.setCuentaPorCobrars(cuentaporcobrarLogic.getCuentaPorCobrars());
				}

				continue;
			}

			if(clas.clas.equals(Responsable.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setResponsables(clienteDataAccess.getResponsables(connexion,cliente));

				if(this.isConDeep) {
					ResponsableLogic responsableLogic= new ResponsableLogic(this.connexion);
					responsableLogic.setResponsables(cliente.getResponsables());
					ArrayList<Classe> classesLocal=ResponsableConstantesFunciones.getClassesForeignKeysOfResponsable(new ArrayList<Classe>(),DeepLoadType.NONE);
					responsableLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ResponsableConstantesFunciones.refrescarForeignKeysDescripcionesResponsable(responsableLogic.getResponsables());
					cliente.setResponsables(responsableLogic.getResponsables());
				}

				continue;
			}

			if(clas.clas.equals(Transportista.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setTransportistas(clienteDataAccess.getTransportistas(connexion,cliente));

				if(this.isConDeep) {
					TransportistaLogic transportistaLogic= new TransportistaLogic(this.connexion);
					transportistaLogic.setTransportistas(cliente.getTransportistas());
					ArrayList<Classe> classesLocal=TransportistaConstantesFunciones.getClassesForeignKeysOfTransportista(new ArrayList<Classe>(),DeepLoadType.NONE);
					transportistaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					TransportistaConstantesFunciones.refrescarForeignKeysDescripcionesTransportista(transportistaLogic.getTransportistas());
					cliente.setTransportistas(transportistaLogic.getTransportistas());
				}

				continue;
			}

			if(clas.clas.equals(PoliticaCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setPoliticaClientes(clienteDataAccess.getPoliticaClientes(connexion,cliente));

				if(this.isConDeep) {
					PoliticaClienteLogic politicaclienteLogic= new PoliticaClienteLogic(this.connexion);
					politicaclienteLogic.setPoliticaClientes(cliente.getPoliticaClientes());
					ArrayList<Classe> classesLocal=PoliticaClienteConstantesFunciones.getClassesForeignKeysOfPoliticaCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					politicaclienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PoliticaClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticaCliente(politicaclienteLogic.getPoliticaClientes());
					cliente.setPoliticaClientes(politicaclienteLogic.getPoliticaClientes());
				}

				continue;
			}

			if(clas.clas.equals(Conyuge.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setConyuge(clienteDataAccess.getConyuge(connexion,cliente));

				if(this.isConDeep) {
					ConyugeLogic conyugeLogic= new ConyugeLogic(this.connexion);
					conyugeLogic.setConyuge(cliente.getConyuge());
					ArrayList<Classe> classesLocal=ConyugeConstantesFunciones.getClassesForeignKeysOfConyuge(new ArrayList<Classe>(),DeepLoadType.NONE);
					conyugeLogic.deepLoad(false,DeepLoadType.INCLUDE, classesLocal,"");
					ConyugeConstantesFunciones.refrescarForeignKeysDescripcionesConyuge(conyugeLogic.getConyuge());
					cliente.setConyuge(conyugeLogic.getConyuge());
				}

				continue;
			}

			if(clas.clas.equals(ReferenciaBancaria.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setReferenciaBancarias(clienteDataAccess.getReferenciaBancarias(connexion,cliente));

				if(this.isConDeep) {
					ReferenciaBancariaLogic referenciabancariaLogic= new ReferenciaBancariaLogic(this.connexion);
					referenciabancariaLogic.setReferenciaBancarias(cliente.getReferenciaBancarias());
					ArrayList<Classe> classesLocal=ReferenciaBancariaConstantesFunciones.getClassesForeignKeysOfReferenciaBancaria(new ArrayList<Classe>(),DeepLoadType.NONE);
					referenciabancariaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ReferenciaBancariaConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaBancaria(referenciabancariaLogic.getReferenciaBancarias());
					cliente.setReferenciaBancarias(referenciabancariaLogic.getReferenciaBancarias());
				}

				continue;
			}

			if(clas.clas.equals(BalanceGeneralCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setBalanceGeneralClientes(clienteDataAccess.getBalanceGeneralClientes(connexion,cliente));

				if(this.isConDeep) {
					BalanceGeneralClienteLogic balancegeneralclienteLogic= new BalanceGeneralClienteLogic(this.connexion);
					balancegeneralclienteLogic.setBalanceGeneralClientes(cliente.getBalanceGeneralClientes());
					ArrayList<Classe> classesLocal=BalanceGeneralClienteConstantesFunciones.getClassesForeignKeysOfBalanceGeneralCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					balancegeneralclienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					BalanceGeneralClienteConstantesFunciones.refrescarForeignKeysDescripcionesBalanceGeneralCliente(balancegeneralclienteLogic.getBalanceGeneralClientes());
					cliente.setBalanceGeneralClientes(balancegeneralclienteLogic.getBalanceGeneralClientes());
				}

				continue;
			}

			if(clas.clas.equals(DatoConstitucion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setDatoConstitucions(clienteDataAccess.getDatoConstitucions(connexion,cliente));

				if(this.isConDeep) {
					DatoConstitucionLogic datoconstitucionLogic= new DatoConstitucionLogic(this.connexion);
					datoconstitucionLogic.setDatoConstitucions(cliente.getDatoConstitucions());
					ArrayList<Classe> classesLocal=DatoConstitucionConstantesFunciones.getClassesForeignKeysOfDatoConstitucion(new ArrayList<Classe>(),DeepLoadType.NONE);
					datoconstitucionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DatoConstitucionConstantesFunciones.refrescarForeignKeysDescripcionesDatoConstitucion(datoconstitucionLogic.getDatoConstitucions());
					cliente.setDatoConstitucions(datoconstitucionLogic.getDatoConstitucions());
				}

				continue;
			}

			if(clas.clas.equals(ActividadEconomica.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setActividadEconomicas(clienteDataAccess.getActividadEconomicas(connexion,cliente));

				if(this.isConDeep) {
					ActividadEconomicaLogic actividadeconomicaLogic= new ActividadEconomicaLogic(this.connexion);
					actividadeconomicaLogic.setActividadEconomicas(cliente.getActividadEconomicas());
					ArrayList<Classe> classesLocal=ActividadEconomicaConstantesFunciones.getClassesForeignKeysOfActividadEconomica(new ArrayList<Classe>(),DeepLoadType.NONE);
					actividadeconomicaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ActividadEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesActividadEconomica(actividadeconomicaLogic.getActividadEconomicas());
					cliente.setActividadEconomicas(actividadeconomicaLogic.getActividadEconomicas());
				}

				continue;
			}

			if(clas.clas.equals(ProveedorProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setProveedorProductos(clienteDataAccess.getProveedorProductos(connexion,cliente));

				if(this.isConDeep) {
					ProveedorProductoLogic proveedorproductoLogic= new ProveedorProductoLogic(this.connexion);
					proveedorproductoLogic.setProveedorProductos(cliente.getProveedorProductos());
					ArrayList<Classe> classesLocal=ProveedorProductoConstantesFunciones.getClassesForeignKeysOfProveedorProducto(new ArrayList<Classe>(),DeepLoadType.NONE);
					proveedorproductoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProveedorProductoConstantesFunciones.refrescarForeignKeysDescripcionesProveedorProducto(proveedorproductoLogic.getProveedorProductos());
					cliente.setProveedorProductos(proveedorproductoLogic.getProveedorProductos());
				}

				continue;
			}

			if(clas.clas.equals(Consignatario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setConsignatarios(clienteDataAccess.getConsignatarios(connexion,cliente));

				if(this.isConDeep) {
					ConsignatarioLogic consignatarioLogic= new ConsignatarioLogic(this.connexion);
					consignatarioLogic.setConsignatarios(cliente.getConsignatarios());
					ArrayList<Classe> classesLocal=ConsignatarioConstantesFunciones.getClassesForeignKeysOfConsignatario(new ArrayList<Classe>(),DeepLoadType.NONE);
					consignatarioLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ConsignatarioConstantesFunciones.refrescarForeignKeysDescripcionesConsignatario(consignatarioLogic.getConsignatarios());
					cliente.setConsignatarios(consignatarioLogic.getConsignatarios());
				}

				continue;
			}

			if(clas.clas.equals(HobbyCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setHobbyClientes(clienteDataAccess.getHobbyClientes(connexion,cliente));

				if(this.isConDeep) {
					HobbyClienteLogic hobbyclienteLogic= new HobbyClienteLogic(this.connexion);
					hobbyclienteLogic.setHobbyClientes(cliente.getHobbyClientes());
					ArrayList<Classe> classesLocal=HobbyClienteConstantesFunciones.getClassesForeignKeysOfHobbyCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					hobbyclienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					HobbyClienteConstantesFunciones.refrescarForeignKeysDescripcionesHobbyCliente(hobbyclienteLogic.getHobbyClientes());
					cliente.setHobbyClientes(hobbyclienteLogic.getHobbyClientes());
				}

				continue;
			}

			if(clas.clas.equals(RepresentanteLegal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setRepresentanteLegals(clienteDataAccess.getRepresentanteLegals(connexion,cliente));

				if(this.isConDeep) {
					RepresentanteLegalLogic representantelegalLogic= new RepresentanteLegalLogic(this.connexion);
					representantelegalLogic.setRepresentanteLegals(cliente.getRepresentanteLegals());
					ArrayList<Classe> classesLocal=RepresentanteLegalConstantesFunciones.getClassesForeignKeysOfRepresentanteLegal(new ArrayList<Classe>(),DeepLoadType.NONE);
					representantelegalLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					RepresentanteLegalConstantesFunciones.refrescarForeignKeysDescripcionesRepresentanteLegal(representantelegalLogic.getRepresentanteLegals());
					cliente.setRepresentanteLegals(representantelegalLogic.getRepresentanteLegals());
				}

				continue;
			}

			if(clas.clas.equals(ClienteCoa.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setClienteCoas(clienteDataAccess.getClienteCoas(connexion,cliente));

				if(this.isConDeep) {
					ClienteCoaLogic clientecoaLogic= new ClienteCoaLogic(this.connexion);
					clientecoaLogic.setClienteCoas(cliente.getClienteCoas());
					ArrayList<Classe> classesLocal=ClienteCoaConstantesFunciones.getClassesForeignKeysOfClienteCoa(new ArrayList<Classe>(),DeepLoadType.NONE);
					clientecoaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ClienteCoaConstantesFunciones.refrescarForeignKeysDescripcionesClienteCoa(clientecoaLogic.getClienteCoas());
					cliente.setClienteCoas(clientecoaLogic.getClienteCoas());
				}

				continue;
			}

			if(clas.clas.equals(Direccion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setDireccions(clienteDataAccess.getDireccions(connexion,cliente));

				if(this.isConDeep) {
					DireccionLogic direccionLogic= new DireccionLogic(this.connexion);
					direccionLogic.setDireccions(cliente.getDireccions());
					ArrayList<Classe> classesLocal=DireccionConstantesFunciones.getClassesForeignKeysOfDireccion(new ArrayList<Classe>(),DeepLoadType.NONE);
					direccionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DireccionConstantesFunciones.refrescarForeignKeysDescripcionesDireccion(direccionLogic.getDireccions());
					cliente.setDireccions(direccionLogic.getDireccions());
				}

				continue;
			}

			if(clas.clas.equals(ClienteImagen.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setClienteImagens(clienteDataAccess.getClienteImagens(connexion,cliente));

				if(this.isConDeep) {
					ClienteImagenLogic clienteimagenLogic= new ClienteImagenLogic(this.connexion);
					clienteimagenLogic.setClienteImagens(cliente.getClienteImagens());
					ArrayList<Classe> classesLocal=ClienteImagenConstantesFunciones.getClassesForeignKeysOfClienteImagen(new ArrayList<Classe>(),DeepLoadType.NONE);
					clienteimagenLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ClienteImagenConstantesFunciones.refrescarForeignKeysDescripcionesClienteImagen(clienteimagenLogic.getClienteImagens());
					cliente.setClienteImagens(clienteimagenLogic.getClienteImagens());
				}

				continue;
			}

			if(clas.clas.equals(SubCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setSubClientes(clienteDataAccess.getSubClientes(connexion,cliente));

				if(this.isConDeep) {
					SubClienteLogic subclienteLogic= new SubClienteLogic(this.connexion);
					subclienteLogic.setSubClientes(cliente.getSubClientes());
					ArrayList<Classe> classesLocal=SubClienteConstantesFunciones.getClassesForeignKeysOfSubCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					subclienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(subclienteLogic.getSubClientes());
					cliente.setSubClientes(subclienteLogic.getSubClientes());
				}

				continue;
			}

			if(clas.clas.equals(ServicioCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setServicioClientes(clienteDataAccess.getServicioClientes(connexion,cliente));

				if(this.isConDeep) {
					ServicioClienteLogic servicioclienteLogic= new ServicioClienteLogic(this.connexion);
					servicioclienteLogic.setServicioClientes(cliente.getServicioClientes());
					ArrayList<Classe> classesLocal=ServicioClienteConstantesFunciones.getClassesForeignKeysOfServicioCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					servicioclienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ServicioClienteConstantesFunciones.refrescarForeignKeysDescripcionesServicioCliente(servicioclienteLogic.getServicioClientes());
					cliente.setServicioClientes(servicioclienteLogic.getServicioClientes());
				}

				continue;
			}

			if(clas.clas.equals(InformacionEconomica.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setInformacionEconomicas(clienteDataAccess.getInformacionEconomicas(connexion,cliente));

				if(this.isConDeep) {
					InformacionEconomicaLogic informacioneconomicaLogic= new InformacionEconomicaLogic(this.connexion);
					informacioneconomicaLogic.setInformacionEconomicas(cliente.getInformacionEconomicas());
					ArrayList<Classe> classesLocal=InformacionEconomicaConstantesFunciones.getClassesForeignKeysOfInformacionEconomica(new ArrayList<Classe>(),DeepLoadType.NONE);
					informacioneconomicaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					InformacionEconomicaConstantesFunciones.refrescarForeignKeysDescripcionesInformacionEconomica(informacioneconomicaLogic.getInformacionEconomicas());
					cliente.setInformacionEconomicas(informacioneconomicaLogic.getInformacionEconomicas());
				}

				continue;
			}

			if(clas.clas.equals(VehiculoCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setVehiculoClientes(clienteDataAccess.getVehiculoClientes(connexion,cliente));

				if(this.isConDeep) {
					VehiculoClienteLogic vehiculoclienteLogic= new VehiculoClienteLogic(this.connexion);
					vehiculoclienteLogic.setVehiculoClientes(cliente.getVehiculoClientes());
					ArrayList<Classe> classesLocal=VehiculoClienteConstantesFunciones.getClassesForeignKeysOfVehiculoCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					vehiculoclienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					VehiculoClienteConstantesFunciones.refrescarForeignKeysDescripcionesVehiculoCliente(vehiculoclienteLogic.getVehiculoClientes());
					cliente.setVehiculoClientes(vehiculoclienteLogic.getVehiculoClientes());
				}

				continue;
			}

			if(clas.clas.equals(NegocioCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setNegocioClientes(clienteDataAccess.getNegocioClientes(connexion,cliente));

				if(this.isConDeep) {
					NegocioClienteLogic negocioclienteLogic= new NegocioClienteLogic(this.connexion);
					negocioclienteLogic.setNegocioClientes(cliente.getNegocioClientes());
					ArrayList<Classe> classesLocal=NegocioClienteConstantesFunciones.getClassesForeignKeysOfNegocioCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					negocioclienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					NegocioClienteConstantesFunciones.refrescarForeignKeysDescripcionesNegocioCliente(negocioclienteLogic.getNegocioClientes());
					cliente.setNegocioClientes(negocioclienteLogic.getNegocioClientes());
				}

				continue;
			}

			if(clas.clas.equals(Monto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setMontos(clienteDataAccess.getMontos(connexion,cliente));

				if(this.isConDeep) {
					MontoLogic montoLogic= new MontoLogic(this.connexion);
					montoLogic.setMontos(cliente.getMontos());
					ArrayList<Classe> classesLocal=MontoConstantesFunciones.getClassesForeignKeysOfMonto(new ArrayList<Classe>(),DeepLoadType.NONE);
					montoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					MontoConstantesFunciones.refrescarForeignKeysDescripcionesMonto(montoLogic.getMontos());
					cliente.setMontos(montoLogic.getMontos());
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
			cliente.setEmpresa(clienteDataAccess.getEmpresa(connexion,cliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setSucursal(clienteDataAccess.getSucursal(connexion,cliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIdentificacion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setTipoIdentificacion(clienteDataAccess.getTipoIdentificacion(connexion,cliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GrupoCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setGrupoCliente(clienteDataAccess.getGrupoCliente(connexion,cliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TituloCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setTituloCliente(clienteDataAccess.getTituloCliente(connexion,cliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AreaCr.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setAreaCr(clienteDataAccess.getAreaCr(connexion,cliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setEstadoCliente(clienteDataAccess.getEstadoCliente(connexion,cliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setPais(clienteDataAccess.getPais(connexion,cliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Region.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setRegion(clienteDataAccess.getRegion(connexion,cliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Provincia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setProvincia(clienteDataAccess.getProvincia(connexion,cliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setCiudad(clienteDataAccess.getCiudad(connexion,cliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Zona.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setZona(clienteDataAccess.getZona(connexion,cliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setPaisNacionalidad(clienteDataAccess.getPaisNacionalidad(connexion,cliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCargoLabo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setTipoCargoLabo(clienteDataAccess.getTipoCargoLabo(connexion,cliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoNivelEdu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setTipoNivelEdu(clienteDataAccess.getTipoNivelEdu(connexion,cliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Profesion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setProfesion(clienteDataAccess.getProfesion(connexion,cliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoGenero.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setTipoGenero(clienteDataAccess.getTipoGenero(connexion,cliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoCivil.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setEstadoCivil(clienteDataAccess.getEstadoCivil(connexion,cliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoLegal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setEstadoLegal(clienteDataAccess.getEstadoLegal(connexion,cliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setCuentaContable(clienteDataAccess.getCuentaContable(connexion,cliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ruta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setRuta(clienteDataAccess.getRuta(connexion,cliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setVendedor(clienteDataAccess.getVendedor(connexion,cliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroActividad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setCentroActividad(clienteDataAccess.getCentroActividad(connexion,cliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoGarantiaEmpresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setTipoGarantiaEmpresa(clienteDataAccess.getTipoGarantiaEmpresa(connexion,cliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CateTipoAfiliacion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setCateTipoAfiliacion(clienteDataAccess.getCateTipoAfiliacion(connexion,cliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Dia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setDia(clienteDataAccess.getDia(connexion,cliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setEmpleado(clienteDataAccess.getEmpleado(connexion,cliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrecio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setTipoPrecio(clienteDataAccess.getTipoPrecio(connexion,cliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoListaPrecio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setTipoListaPrecio(clienteDataAccess.getTipoListaPrecio(connexion,cliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ContactoCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ContactoCliente.class));
			cliente.setContactoClientes(clienteDataAccess.getContactoClientes(connexion,cliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bien.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Bien.class));
			cliente.setBiens(clienteDataAccess.getBiens(connexion,cliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CargaFamiliar.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CargaFamiliar.class));
			cliente.setCargaFamiliars(clienteDataAccess.getCargaFamiliars(connexion,cliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ChequePostFechado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ChequePostFechado.class));
			cliente.setChequePostFechados(clienteDataAccess.getChequePostFechados(connexion,cliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EMail.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EMail.class));
			cliente.setEMails(clienteDataAccess.getEMails(connexion,cliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ReferenciaPersonal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ReferenciaPersonal.class));
			cliente.setReferenciaPersonals(clienteDataAccess.getReferenciaPersonals(connexion,cliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GarantiaCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(GarantiaCliente.class));
			cliente.setGarantiaClientes(clienteDataAccess.getGarantiaClientes(connexion,cliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ClienteArchivo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ClienteArchivo.class));
			cliente.setClienteArchivos(clienteDataAccess.getClienteArchivos(connexion,cliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PoliticasCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PoliticasCliente.class));
			cliente.setPoliticasCliente(clienteDataAccess.getPoliticasCliente(connexion,cliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FirmaCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FirmaCliente.class));
			cliente.setFirmaClientes(clienteDataAccess.getFirmaClientes(connexion,cliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ReferenciaComercial.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ReferenciaComercial.class));
			cliente.setReferenciaComercials(clienteDataAccess.getReferenciaComercials(connexion,cliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Novedad.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Novedad.class));
			cliente.setNovedads(clienteDataAccess.getNovedads(connexion,cliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(InformacionLaboral.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(InformacionLaboral.class));
			cliente.setInformacionLaborals(clienteDataAccess.getInformacionLaborals(connexion,cliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(InformacionFinanciera.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(InformacionFinanciera.class));
			cliente.setInformacionFinancieras(clienteDataAccess.getInformacionFinancieras(connexion,cliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Telefono.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Telefono.class));
			cliente.setTelefonos(clienteDataAccess.getTelefonos(connexion,cliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaPorCobrar.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CuentaPorCobrar.class));
			cliente.setCuentaPorCobrars(clienteDataAccess.getCuentaPorCobrars(connexion,cliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Responsable.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Responsable.class));
			cliente.setResponsables(clienteDataAccess.getResponsables(connexion,cliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transportista.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Transportista.class));
			cliente.setTransportistas(clienteDataAccess.getTransportistas(connexion,cliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PoliticaCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PoliticaCliente.class));
			cliente.setPoliticaClientes(clienteDataAccess.getPoliticaClientes(connexion,cliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Conyuge.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Conyuge.class));
			cliente.setConyuge(clienteDataAccess.getConyuge(connexion,cliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ReferenciaBancaria.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ReferenciaBancaria.class));
			cliente.setReferenciaBancarias(clienteDataAccess.getReferenciaBancarias(connexion,cliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(BalanceGeneralCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(BalanceGeneralCliente.class));
			cliente.setBalanceGeneralClientes(clienteDataAccess.getBalanceGeneralClientes(connexion,cliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DatoConstitucion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DatoConstitucion.class));
			cliente.setDatoConstitucions(clienteDataAccess.getDatoConstitucions(connexion,cliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ActividadEconomica.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ActividadEconomica.class));
			cliente.setActividadEconomicas(clienteDataAccess.getActividadEconomicas(connexion,cliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProveedorProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProveedorProducto.class));
			cliente.setProveedorProductos(clienteDataAccess.getProveedorProductos(connexion,cliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Consignatario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Consignatario.class));
			cliente.setConsignatarios(clienteDataAccess.getConsignatarios(connexion,cliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(HobbyCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(HobbyCliente.class));
			cliente.setHobbyClientes(clienteDataAccess.getHobbyClientes(connexion,cliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RepresentanteLegal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(RepresentanteLegal.class));
			cliente.setRepresentanteLegals(clienteDataAccess.getRepresentanteLegals(connexion,cliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ClienteCoa.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ClienteCoa.class));
			cliente.setClienteCoas(clienteDataAccess.getClienteCoas(connexion,cliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Direccion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Direccion.class));
			cliente.setDireccions(clienteDataAccess.getDireccions(connexion,cliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ClienteImagen.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ClienteImagen.class));
			cliente.setClienteImagens(clienteDataAccess.getClienteImagens(connexion,cliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SubCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(SubCliente.class));
			cliente.setSubClientes(clienteDataAccess.getSubClientes(connexion,cliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ServicioCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ServicioCliente.class));
			cliente.setServicioClientes(clienteDataAccess.getServicioClientes(connexion,cliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(InformacionEconomica.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(InformacionEconomica.class));
			cliente.setInformacionEconomicas(clienteDataAccess.getInformacionEconomicas(connexion,cliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(VehiculoCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(VehiculoCliente.class));
			cliente.setVehiculoClientes(clienteDataAccess.getVehiculoClientes(connexion,cliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NegocioCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(NegocioCliente.class));
			cliente.setNegocioClientes(clienteDataAccess.getNegocioClientes(connexion,cliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Monto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Monto.class));
			cliente.setMontos(clienteDataAccess.getMontos(connexion,cliente));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cliente.setEmpresa(clienteDataAccess.getEmpresa(connexion,cliente));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cliente.getEmpresa(),isDeep,deepLoadType,clases);
				
		cliente.setSucursal(clienteDataAccess.getSucursal(connexion,cliente));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(cliente.getSucursal(),isDeep,deepLoadType,clases);
				
		cliente.setTipoIdentificacion(clienteDataAccess.getTipoIdentificacion(connexion,cliente));
		TipoIdentificacionLogic tipoidentificacionLogic= new TipoIdentificacionLogic(connexion);
		tipoidentificacionLogic.deepLoad(cliente.getTipoIdentificacion(),isDeep,deepLoadType,clases);
				
		cliente.setGrupoCliente(clienteDataAccess.getGrupoCliente(connexion,cliente));
		GrupoClienteLogic grupoclienteLogic= new GrupoClienteLogic(connexion);
		grupoclienteLogic.deepLoad(cliente.getGrupoCliente(),isDeep,deepLoadType,clases);
				
		cliente.setTituloCliente(clienteDataAccess.getTituloCliente(connexion,cliente));
		TituloClienteLogic tituloclienteLogic= new TituloClienteLogic(connexion);
		tituloclienteLogic.deepLoad(cliente.getTituloCliente(),isDeep,deepLoadType,clases);
				
		cliente.setAreaCr(clienteDataAccess.getAreaCr(connexion,cliente));
		AreaCrLogic areacrLogic= new AreaCrLogic(connexion);
		areacrLogic.deepLoad(cliente.getAreaCr(),isDeep,deepLoadType,clases);
				
		cliente.setEstadoCliente(clienteDataAccess.getEstadoCliente(connexion,cliente));
		EstadoClienteLogic estadoclienteLogic= new EstadoClienteLogic(connexion);
		estadoclienteLogic.deepLoad(cliente.getEstadoCliente(),isDeep,deepLoadType,clases);
				
		cliente.setPais(clienteDataAccess.getPais(connexion,cliente));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(cliente.getPais(),isDeep,deepLoadType,clases);
				
		cliente.setRegion(clienteDataAccess.getRegion(connexion,cliente));
		RegionLogic regionLogic= new RegionLogic(connexion);
		regionLogic.deepLoad(cliente.getRegion(),isDeep,deepLoadType,clases);
				
		cliente.setProvincia(clienteDataAccess.getProvincia(connexion,cliente));
		ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
		provinciaLogic.deepLoad(cliente.getProvincia(),isDeep,deepLoadType,clases);
				
		cliente.setCiudad(clienteDataAccess.getCiudad(connexion,cliente));
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(cliente.getCiudad(),isDeep,deepLoadType,clases);
				
		cliente.setZona(clienteDataAccess.getZona(connexion,cliente));
		ZonaLogic zonaLogic= new ZonaLogic(connexion);
		zonaLogic.deepLoad(cliente.getZona(),isDeep,deepLoadType,clases);
				
		cliente.setPaisNacionalidad(clienteDataAccess.getPaisNacionalidad(connexion,cliente));
		PaisLogic paisnacionalidadLogic= new PaisLogic(connexion);
		paisnacionalidadLogic.deepLoad(cliente.getPaisNacionalidad(),isDeep,deepLoadType,clases);
				
		cliente.setTipoCargoLabo(clienteDataAccess.getTipoCargoLabo(connexion,cliente));
		TipoCargoLaboLogic tipocargolaboLogic= new TipoCargoLaboLogic(connexion);
		tipocargolaboLogic.deepLoad(cliente.getTipoCargoLabo(),isDeep,deepLoadType,clases);
				
		cliente.setTipoNivelEdu(clienteDataAccess.getTipoNivelEdu(connexion,cliente));
		TipoNivelEduLogic tiponiveleduLogic= new TipoNivelEduLogic(connexion);
		tiponiveleduLogic.deepLoad(cliente.getTipoNivelEdu(),isDeep,deepLoadType,clases);
				
		cliente.setProfesion(clienteDataAccess.getProfesion(connexion,cliente));
		ProfesionLogic profesionLogic= new ProfesionLogic(connexion);
		profesionLogic.deepLoad(cliente.getProfesion(),isDeep,deepLoadType,clases);
				
		cliente.setTipoGenero(clienteDataAccess.getTipoGenero(connexion,cliente));
		TipoGeneroLogic tipogeneroLogic= new TipoGeneroLogic(connexion);
		tipogeneroLogic.deepLoad(cliente.getTipoGenero(),isDeep,deepLoadType,clases);
				
		cliente.setEstadoCivil(clienteDataAccess.getEstadoCivil(connexion,cliente));
		EstadoCivilLogic estadocivilLogic= new EstadoCivilLogic(connexion);
		estadocivilLogic.deepLoad(cliente.getEstadoCivil(),isDeep,deepLoadType,clases);
				
		cliente.setEstadoLegal(clienteDataAccess.getEstadoLegal(connexion,cliente));
		EstadoLegalLogic estadolegalLogic= new EstadoLegalLogic(connexion);
		estadolegalLogic.deepLoad(cliente.getEstadoLegal(),isDeep,deepLoadType,clases);
				
		cliente.setCuentaContable(clienteDataAccess.getCuentaContable(connexion,cliente));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(cliente.getCuentaContable(),isDeep,deepLoadType,clases);
				
		cliente.setRuta(clienteDataAccess.getRuta(connexion,cliente));
		RutaLogic rutaLogic= new RutaLogic(connexion);
		rutaLogic.deepLoad(cliente.getRuta(),isDeep,deepLoadType,clases);
				
		cliente.setVendedor(clienteDataAccess.getVendedor(connexion,cliente));
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(cliente.getVendedor(),isDeep,deepLoadType,clases);
				
		cliente.setCentroActividad(clienteDataAccess.getCentroActividad(connexion,cliente));
		CentroActividadLogic centroactividadLogic= new CentroActividadLogic(connexion);
		centroactividadLogic.deepLoad(cliente.getCentroActividad(),isDeep,deepLoadType,clases);
				
		cliente.setTipoGarantiaEmpresa(clienteDataAccess.getTipoGarantiaEmpresa(connexion,cliente));
		TipoGarantiaEmpresaLogic tipogarantiaempresaLogic= new TipoGarantiaEmpresaLogic(connexion);
		tipogarantiaempresaLogic.deepLoad(cliente.getTipoGarantiaEmpresa(),isDeep,deepLoadType,clases);
				
		cliente.setCateTipoAfiliacion(clienteDataAccess.getCateTipoAfiliacion(connexion,cliente));
		CateTipoAfiliacionLogic catetipoafiliacionLogic= new CateTipoAfiliacionLogic(connexion);
		catetipoafiliacionLogic.deepLoad(cliente.getCateTipoAfiliacion(),isDeep,deepLoadType,clases);
				
		cliente.setDia(clienteDataAccess.getDia(connexion,cliente));
		DiaLogic diaLogic= new DiaLogic(connexion);
		diaLogic.deepLoad(cliente.getDia(),isDeep,deepLoadType,clases);
				
		cliente.setEmpleado(clienteDataAccess.getEmpleado(connexion,cliente));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(cliente.getEmpleado(),isDeep,deepLoadType,clases);
				
		cliente.setTipoPrecio(clienteDataAccess.getTipoPrecio(connexion,cliente));
		TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
		tipoprecioLogic.deepLoad(cliente.getTipoPrecio(),isDeep,deepLoadType,clases);
				
		cliente.setTipoListaPrecio(clienteDataAccess.getTipoListaPrecio(connexion,cliente));
		TipoListaPrecioLogic tipolistaprecioLogic= new TipoListaPrecioLogic(connexion);
		tipolistaprecioLogic.deepLoad(cliente.getTipoListaPrecio(),isDeep,deepLoadType,clases);
				

		cliente.setContactoClientes(clienteDataAccess.getContactoClientes(connexion,cliente));

		for(ContactoCliente contactocliente:cliente.getContactoClientes()) {
			ContactoClienteLogic contactoclienteLogic= new ContactoClienteLogic(connexion);
			contactoclienteLogic.deepLoad(contactocliente,isDeep,deepLoadType,clases);
		}

		cliente.setBiens(clienteDataAccess.getBiens(connexion,cliente));

		for(Bien bien:cliente.getBiens()) {
			BienLogic bienLogic= new BienLogic(connexion);
			bienLogic.deepLoad(bien,isDeep,deepLoadType,clases);
		}

		cliente.setCargaFamiliars(clienteDataAccess.getCargaFamiliars(connexion,cliente));

		for(CargaFamiliar cargafamiliar:cliente.getCargaFamiliars()) {
			CargaFamiliarLogic cargafamiliarLogic= new CargaFamiliarLogic(connexion);
			cargafamiliarLogic.deepLoad(cargafamiliar,isDeep,deepLoadType,clases);
		}

		cliente.setChequePostFechados(clienteDataAccess.getChequePostFechados(connexion,cliente));

		for(ChequePostFechado chequepostfechado:cliente.getChequePostFechados()) {
			ChequePostFechadoLogic chequepostfechadoLogic= new ChequePostFechadoLogic(connexion);
			chequepostfechadoLogic.deepLoad(chequepostfechado,isDeep,deepLoadType,clases);
		}

		cliente.setEMails(clienteDataAccess.getEMails(connexion,cliente));

		for(EMail email:cliente.getEMails()) {
			EMailLogic emailLogic= new EMailLogic(connexion);
			emailLogic.deepLoad(email,isDeep,deepLoadType,clases);
		}

		cliente.setReferenciaPersonals(clienteDataAccess.getReferenciaPersonals(connexion,cliente));

		for(ReferenciaPersonal referenciapersonal:cliente.getReferenciaPersonals()) {
			ReferenciaPersonalLogic referenciapersonalLogic= new ReferenciaPersonalLogic(connexion);
			referenciapersonalLogic.deepLoad(referenciapersonal,isDeep,deepLoadType,clases);
		}

		cliente.setGarantiaClientes(clienteDataAccess.getGarantiaClientes(connexion,cliente));

		for(GarantiaCliente garantiacliente:cliente.getGarantiaClientes()) {
			GarantiaClienteLogic garantiaclienteLogic= new GarantiaClienteLogic(connexion);
			garantiaclienteLogic.deepLoad(garantiacliente,isDeep,deepLoadType,clases);
		}

		cliente.setClienteArchivos(clienteDataAccess.getClienteArchivos(connexion,cliente));

		for(ClienteArchivo clientearchivo:cliente.getClienteArchivos()) {
			ClienteArchivoLogic clientearchivoLogic= new ClienteArchivoLogic(connexion);
			clientearchivoLogic.deepLoad(clientearchivo,isDeep,deepLoadType,clases);
		}
					cliente.setPoliticasCliente(clienteDataAccess.getPoliticasCliente(connexion,cliente));

						PoliticasClienteLogic politicasclienteLogic= new PoliticasClienteLogic(connexion);

					politicasclienteLogic.deepLoad(cliente.getPoliticasCliente(),isDeep,deepLoadType,clases);

		cliente.setFirmaClientes(clienteDataAccess.getFirmaClientes(connexion,cliente));

		for(FirmaCliente firmacliente:cliente.getFirmaClientes()) {
			FirmaClienteLogic firmaclienteLogic= new FirmaClienteLogic(connexion);
			firmaclienteLogic.deepLoad(firmacliente,isDeep,deepLoadType,clases);
		}

		cliente.setReferenciaComercials(clienteDataAccess.getReferenciaComercials(connexion,cliente));

		for(ReferenciaComercial referenciacomercial:cliente.getReferenciaComercials()) {
			ReferenciaComercialLogic referenciacomercialLogic= new ReferenciaComercialLogic(connexion);
			referenciacomercialLogic.deepLoad(referenciacomercial,isDeep,deepLoadType,clases);
		}

		cliente.setNovedads(clienteDataAccess.getNovedads(connexion,cliente));

		for(Novedad novedad:cliente.getNovedads()) {
			NovedadLogic novedadLogic= new NovedadLogic(connexion);
			novedadLogic.deepLoad(novedad,isDeep,deepLoadType,clases);
		}

		cliente.setInformacionLaborals(clienteDataAccess.getInformacionLaborals(connexion,cliente));

		for(InformacionLaboral informacionlaboral:cliente.getInformacionLaborals()) {
			InformacionLaboralLogic informacionlaboralLogic= new InformacionLaboralLogic(connexion);
			informacionlaboralLogic.deepLoad(informacionlaboral,isDeep,deepLoadType,clases);
		}

		cliente.setInformacionFinancieras(clienteDataAccess.getInformacionFinancieras(connexion,cliente));

		for(InformacionFinanciera informacionfinanciera:cliente.getInformacionFinancieras()) {
			InformacionFinancieraLogic informacionfinancieraLogic= new InformacionFinancieraLogic(connexion);
			informacionfinancieraLogic.deepLoad(informacionfinanciera,isDeep,deepLoadType,clases);
		}

		cliente.setTelefonos(clienteDataAccess.getTelefonos(connexion,cliente));

		for(Telefono telefono:cliente.getTelefonos()) {
			TelefonoLogic telefonoLogic= new TelefonoLogic(connexion);
			telefonoLogic.deepLoad(telefono,isDeep,deepLoadType,clases);
		}

		cliente.setCuentaPorCobrars(clienteDataAccess.getCuentaPorCobrars(connexion,cliente));

		for(CuentaPorCobrar cuentaporcobrar:cliente.getCuentaPorCobrars()) {
			CuentaPorCobrarLogic cuentaporcobrarLogic= new CuentaPorCobrarLogic(connexion);
			cuentaporcobrarLogic.deepLoad(cuentaporcobrar,isDeep,deepLoadType,clases);
		}

		cliente.setResponsables(clienteDataAccess.getResponsables(connexion,cliente));

		for(Responsable responsable:cliente.getResponsables()) {
			ResponsableLogic responsableLogic= new ResponsableLogic(connexion);
			responsableLogic.deepLoad(responsable,isDeep,deepLoadType,clases);
		}

		cliente.setTransportistas(clienteDataAccess.getTransportistas(connexion,cliente));

		for(Transportista transportista:cliente.getTransportistas()) {
			TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
			transportistaLogic.deepLoad(transportista,isDeep,deepLoadType,clases);
		}

		cliente.setPoliticaClientes(clienteDataAccess.getPoliticaClientes(connexion,cliente));

		for(PoliticaCliente politicacliente:cliente.getPoliticaClientes()) {
			PoliticaClienteLogic politicaclienteLogic= new PoliticaClienteLogic(connexion);
			politicaclienteLogic.deepLoad(politicacliente,isDeep,deepLoadType,clases);
		}
					cliente.setConyuge(clienteDataAccess.getConyuge(connexion,cliente));

						ConyugeLogic conyugeLogic= new ConyugeLogic(connexion);

					conyugeLogic.deepLoad(cliente.getConyuge(),isDeep,deepLoadType,clases);

		cliente.setReferenciaBancarias(clienteDataAccess.getReferenciaBancarias(connexion,cliente));

		for(ReferenciaBancaria referenciabancaria:cliente.getReferenciaBancarias()) {
			ReferenciaBancariaLogic referenciabancariaLogic= new ReferenciaBancariaLogic(connexion);
			referenciabancariaLogic.deepLoad(referenciabancaria,isDeep,deepLoadType,clases);
		}

		cliente.setBalanceGeneralClientes(clienteDataAccess.getBalanceGeneralClientes(connexion,cliente));

		for(BalanceGeneralCliente balancegeneralcliente:cliente.getBalanceGeneralClientes()) {
			BalanceGeneralClienteLogic balancegeneralclienteLogic= new BalanceGeneralClienteLogic(connexion);
			balancegeneralclienteLogic.deepLoad(balancegeneralcliente,isDeep,deepLoadType,clases);
		}

		cliente.setDatoConstitucions(clienteDataAccess.getDatoConstitucions(connexion,cliente));

		for(DatoConstitucion datoconstitucion:cliente.getDatoConstitucions()) {
			DatoConstitucionLogic datoconstitucionLogic= new DatoConstitucionLogic(connexion);
			datoconstitucionLogic.deepLoad(datoconstitucion,isDeep,deepLoadType,clases);
		}

		cliente.setActividadEconomicas(clienteDataAccess.getActividadEconomicas(connexion,cliente));

		for(ActividadEconomica actividadeconomica:cliente.getActividadEconomicas()) {
			ActividadEconomicaLogic actividadeconomicaLogic= new ActividadEconomicaLogic(connexion);
			actividadeconomicaLogic.deepLoad(actividadeconomica,isDeep,deepLoadType,clases);
		}

		cliente.setProveedorProductos(clienteDataAccess.getProveedorProductos(connexion,cliente));

		for(ProveedorProducto proveedorproducto:cliente.getProveedorProductos()) {
			ProveedorProductoLogic proveedorproductoLogic= new ProveedorProductoLogic(connexion);
			proveedorproductoLogic.deepLoad(proveedorproducto,isDeep,deepLoadType,clases);
		}

		cliente.setConsignatarios(clienteDataAccess.getConsignatarios(connexion,cliente));

		for(Consignatario consignatario:cliente.getConsignatarios()) {
			ConsignatarioLogic consignatarioLogic= new ConsignatarioLogic(connexion);
			consignatarioLogic.deepLoad(consignatario,isDeep,deepLoadType,clases);
		}

		cliente.setHobbyClientes(clienteDataAccess.getHobbyClientes(connexion,cliente));

		for(HobbyCliente hobbycliente:cliente.getHobbyClientes()) {
			HobbyClienteLogic hobbyclienteLogic= new HobbyClienteLogic(connexion);
			hobbyclienteLogic.deepLoad(hobbycliente,isDeep,deepLoadType,clases);
		}

		cliente.setRepresentanteLegals(clienteDataAccess.getRepresentanteLegals(connexion,cliente));

		for(RepresentanteLegal representantelegal:cliente.getRepresentanteLegals()) {
			RepresentanteLegalLogic representantelegalLogic= new RepresentanteLegalLogic(connexion);
			representantelegalLogic.deepLoad(representantelegal,isDeep,deepLoadType,clases);
		}

		cliente.setClienteCoas(clienteDataAccess.getClienteCoas(connexion,cliente));

		for(ClienteCoa clientecoa:cliente.getClienteCoas()) {
			ClienteCoaLogic clientecoaLogic= new ClienteCoaLogic(connexion);
			clientecoaLogic.deepLoad(clientecoa,isDeep,deepLoadType,clases);
		}

		cliente.setDireccions(clienteDataAccess.getDireccions(connexion,cliente));

		for(Direccion direccion:cliente.getDireccions()) {
			DireccionLogic direccionLogic= new DireccionLogic(connexion);
			direccionLogic.deepLoad(direccion,isDeep,deepLoadType,clases);
		}

		cliente.setClienteImagens(clienteDataAccess.getClienteImagens(connexion,cliente));

		for(ClienteImagen clienteimagen:cliente.getClienteImagens()) {
			ClienteImagenLogic clienteimagenLogic= new ClienteImagenLogic(connexion);
			clienteimagenLogic.deepLoad(clienteimagen,isDeep,deepLoadType,clases);
		}

		cliente.setSubClientes(clienteDataAccess.getSubClientes(connexion,cliente));

		for(SubCliente subcliente:cliente.getSubClientes()) {
			SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
			subclienteLogic.deepLoad(subcliente,isDeep,deepLoadType,clases);
		}

		cliente.setServicioClientes(clienteDataAccess.getServicioClientes(connexion,cliente));

		for(ServicioCliente serviciocliente:cliente.getServicioClientes()) {
			ServicioClienteLogic servicioclienteLogic= new ServicioClienteLogic(connexion);
			servicioclienteLogic.deepLoad(serviciocliente,isDeep,deepLoadType,clases);
		}

		cliente.setInformacionEconomicas(clienteDataAccess.getInformacionEconomicas(connexion,cliente));

		for(InformacionEconomica informacioneconomica:cliente.getInformacionEconomicas()) {
			InformacionEconomicaLogic informacioneconomicaLogic= new InformacionEconomicaLogic(connexion);
			informacioneconomicaLogic.deepLoad(informacioneconomica,isDeep,deepLoadType,clases);
		}

		cliente.setVehiculoClientes(clienteDataAccess.getVehiculoClientes(connexion,cliente));

		for(VehiculoCliente vehiculocliente:cliente.getVehiculoClientes()) {
			VehiculoClienteLogic vehiculoclienteLogic= new VehiculoClienteLogic(connexion);
			vehiculoclienteLogic.deepLoad(vehiculocliente,isDeep,deepLoadType,clases);
		}

		cliente.setNegocioClientes(clienteDataAccess.getNegocioClientes(connexion,cliente));

		for(NegocioCliente negociocliente:cliente.getNegocioClientes()) {
			NegocioClienteLogic negocioclienteLogic= new NegocioClienteLogic(connexion);
			negocioclienteLogic.deepLoad(negociocliente,isDeep,deepLoadType,clases);
		}

		cliente.setMontos(clienteDataAccess.getMontos(connexion,cliente));

		for(Monto monto:cliente.getMontos()) {
			MontoLogic montoLogic= new MontoLogic(connexion);
			montoLogic.deepLoad(monto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cliente.setEmpresa(clienteDataAccess.getEmpresa(connexion,cliente));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(cliente.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				cliente.setSucursal(clienteDataAccess.getSucursal(connexion,cliente));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(cliente.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoIdentificacion.class)) {
				cliente.setTipoIdentificacion(clienteDataAccess.getTipoIdentificacion(connexion,cliente));
				TipoIdentificacionLogic tipoidentificacionLogic= new TipoIdentificacionLogic(connexion);
				tipoidentificacionLogic.deepLoad(cliente.getTipoIdentificacion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(GrupoCliente.class)) {
				cliente.setGrupoCliente(clienteDataAccess.getGrupoCliente(connexion,cliente));
				GrupoClienteLogic grupoclienteLogic= new GrupoClienteLogic(connexion);
				grupoclienteLogic.deepLoad(cliente.getGrupoCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TituloCliente.class)) {
				cliente.setTituloCliente(clienteDataAccess.getTituloCliente(connexion,cliente));
				TituloClienteLogic tituloclienteLogic= new TituloClienteLogic(connexion);
				tituloclienteLogic.deepLoad(cliente.getTituloCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AreaCr.class)) {
				cliente.setAreaCr(clienteDataAccess.getAreaCr(connexion,cliente));
				AreaCrLogic areacrLogic= new AreaCrLogic(connexion);
				areacrLogic.deepLoad(cliente.getAreaCr(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoCliente.class)) {
				cliente.setEstadoCliente(clienteDataAccess.getEstadoCliente(connexion,cliente));
				EstadoClienteLogic estadoclienteLogic= new EstadoClienteLogic(connexion);
				estadoclienteLogic.deepLoad(cliente.getEstadoCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				cliente.setPais(clienteDataAccess.getPais(connexion,cliente));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(cliente.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Region.class)) {
				cliente.setRegion(clienteDataAccess.getRegion(connexion,cliente));
				RegionLogic regionLogic= new RegionLogic(connexion);
				regionLogic.deepLoad(cliente.getRegion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Provincia.class)) {
				cliente.setProvincia(clienteDataAccess.getProvincia(connexion,cliente));
				ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
				provinciaLogic.deepLoad(cliente.getProvincia(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				cliente.setCiudad(clienteDataAccess.getCiudad(connexion,cliente));
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepLoad(cliente.getCiudad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Zona.class)) {
				cliente.setZona(clienteDataAccess.getZona(connexion,cliente));
				ZonaLogic zonaLogic= new ZonaLogic(connexion);
				zonaLogic.deepLoad(cliente.getZona(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				cliente.setPaisNacionalidad(clienteDataAccess.getPaisNacionalidad(connexion,cliente));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(cliente.getPaisNacionalidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCargoLabo.class)) {
				cliente.setTipoCargoLabo(clienteDataAccess.getTipoCargoLabo(connexion,cliente));
				TipoCargoLaboLogic tipocargolaboLogic= new TipoCargoLaboLogic(connexion);
				tipocargolaboLogic.deepLoad(cliente.getTipoCargoLabo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoNivelEdu.class)) {
				cliente.setTipoNivelEdu(clienteDataAccess.getTipoNivelEdu(connexion,cliente));
				TipoNivelEduLogic tiponiveleduLogic= new TipoNivelEduLogic(connexion);
				tiponiveleduLogic.deepLoad(cliente.getTipoNivelEdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Profesion.class)) {
				cliente.setProfesion(clienteDataAccess.getProfesion(connexion,cliente));
				ProfesionLogic profesionLogic= new ProfesionLogic(connexion);
				profesionLogic.deepLoad(cliente.getProfesion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoGenero.class)) {
				cliente.setTipoGenero(clienteDataAccess.getTipoGenero(connexion,cliente));
				TipoGeneroLogic tipogeneroLogic= new TipoGeneroLogic(connexion);
				tipogeneroLogic.deepLoad(cliente.getTipoGenero(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoCivil.class)) {
				cliente.setEstadoCivil(clienteDataAccess.getEstadoCivil(connexion,cliente));
				EstadoCivilLogic estadocivilLogic= new EstadoCivilLogic(connexion);
				estadocivilLogic.deepLoad(cliente.getEstadoCivil(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoLegal.class)) {
				cliente.setEstadoLegal(clienteDataAccess.getEstadoLegal(connexion,cliente));
				EstadoLegalLogic estadolegalLogic= new EstadoLegalLogic(connexion);
				estadolegalLogic.deepLoad(cliente.getEstadoLegal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cliente.setCuentaContable(clienteDataAccess.getCuentaContable(connexion,cliente));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(cliente.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ruta.class)) {
				cliente.setRuta(clienteDataAccess.getRuta(connexion,cliente));
				RutaLogic rutaLogic= new RutaLogic(connexion);
				rutaLogic.deepLoad(cliente.getRuta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				cliente.setVendedor(clienteDataAccess.getVendedor(connexion,cliente));
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepLoad(cliente.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroActividad.class)) {
				cliente.setCentroActividad(clienteDataAccess.getCentroActividad(connexion,cliente));
				CentroActividadLogic centroactividadLogic= new CentroActividadLogic(connexion);
				centroactividadLogic.deepLoad(cliente.getCentroActividad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoGarantiaEmpresa.class)) {
				cliente.setTipoGarantiaEmpresa(clienteDataAccess.getTipoGarantiaEmpresa(connexion,cliente));
				TipoGarantiaEmpresaLogic tipogarantiaempresaLogic= new TipoGarantiaEmpresaLogic(connexion);
				tipogarantiaempresaLogic.deepLoad(cliente.getTipoGarantiaEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CateTipoAfiliacion.class)) {
				cliente.setCateTipoAfiliacion(clienteDataAccess.getCateTipoAfiliacion(connexion,cliente));
				CateTipoAfiliacionLogic catetipoafiliacionLogic= new CateTipoAfiliacionLogic(connexion);
				catetipoafiliacionLogic.deepLoad(cliente.getCateTipoAfiliacion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Dia.class)) {
				cliente.setDia(clienteDataAccess.getDia(connexion,cliente));
				DiaLogic diaLogic= new DiaLogic(connexion);
				diaLogic.deepLoad(cliente.getDia(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				cliente.setEmpleado(clienteDataAccess.getEmpleado(connexion,cliente));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(cliente.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				cliente.setTipoPrecio(clienteDataAccess.getTipoPrecio(connexion,cliente));
				TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
				tipoprecioLogic.deepLoad(cliente.getTipoPrecio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoListaPrecio.class)) {
				cliente.setTipoListaPrecio(clienteDataAccess.getTipoListaPrecio(connexion,cliente));
				TipoListaPrecioLogic tipolistaprecioLogic= new TipoListaPrecioLogic(connexion);
				tipolistaprecioLogic.deepLoad(cliente.getTipoListaPrecio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ContactoCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setContactoClientes(clienteDataAccess.getContactoClientes(connexion,cliente));

				for(ContactoCliente contactocliente:cliente.getContactoClientes()) {
					ContactoClienteLogic contactoclienteLogic= new ContactoClienteLogic(connexion);
					contactoclienteLogic.deepLoad(contactocliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Bien.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setBiens(clienteDataAccess.getBiens(connexion,cliente));

				for(Bien bien:cliente.getBiens()) {
					BienLogic bienLogic= new BienLogic(connexion);
					bienLogic.deepLoad(bien,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CargaFamiliar.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setCargaFamiliars(clienteDataAccess.getCargaFamiliars(connexion,cliente));

				for(CargaFamiliar cargafamiliar:cliente.getCargaFamiliars()) {
					CargaFamiliarLogic cargafamiliarLogic= new CargaFamiliarLogic(connexion);
					cargafamiliarLogic.deepLoad(cargafamiliar,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ChequePostFechado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setChequePostFechados(clienteDataAccess.getChequePostFechados(connexion,cliente));

				for(ChequePostFechado chequepostfechado:cliente.getChequePostFechados()) {
					ChequePostFechadoLogic chequepostfechadoLogic= new ChequePostFechadoLogic(connexion);
					chequepostfechadoLogic.deepLoad(chequepostfechado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(EMail.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setEMails(clienteDataAccess.getEMails(connexion,cliente));

				for(EMail email:cliente.getEMails()) {
					EMailLogic emailLogic= new EMailLogic(connexion);
					emailLogic.deepLoad(email,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ReferenciaPersonal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setReferenciaPersonals(clienteDataAccess.getReferenciaPersonals(connexion,cliente));

				for(ReferenciaPersonal referenciapersonal:cliente.getReferenciaPersonals()) {
					ReferenciaPersonalLogic referenciapersonalLogic= new ReferenciaPersonalLogic(connexion);
					referenciapersonalLogic.deepLoad(referenciapersonal,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(GarantiaCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setGarantiaClientes(clienteDataAccess.getGarantiaClientes(connexion,cliente));

				for(GarantiaCliente garantiacliente:cliente.getGarantiaClientes()) {
					GarantiaClienteLogic garantiaclienteLogic= new GarantiaClienteLogic(connexion);
					garantiaclienteLogic.deepLoad(garantiacliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ClienteArchivo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setClienteArchivos(clienteDataAccess.getClienteArchivos(connexion,cliente));

				for(ClienteArchivo clientearchivo:cliente.getClienteArchivos()) {
					ClienteArchivoLogic clientearchivoLogic= new ClienteArchivoLogic(connexion);
					clientearchivoLogic.deepLoad(clientearchivo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PoliticasCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setPoliticasCliente(clienteDataAccess.getPoliticasCliente(connexion,cliente));

				PoliticasClienteLogic politicasclienteLogic= new PoliticasClienteLogic(connexion);

				politicasclienteLogic.deepLoad(cliente.getPoliticasCliente(),isDeep,deepLoadType,clases);
				continue;
			}

			if(clas.clas.equals(FirmaCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setFirmaClientes(clienteDataAccess.getFirmaClientes(connexion,cliente));

				for(FirmaCliente firmacliente:cliente.getFirmaClientes()) {
					FirmaClienteLogic firmaclienteLogic= new FirmaClienteLogic(connexion);
					firmaclienteLogic.deepLoad(firmacliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ReferenciaComercial.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setReferenciaComercials(clienteDataAccess.getReferenciaComercials(connexion,cliente));

				for(ReferenciaComercial referenciacomercial:cliente.getReferenciaComercials()) {
					ReferenciaComercialLogic referenciacomercialLogic= new ReferenciaComercialLogic(connexion);
					referenciacomercialLogic.deepLoad(referenciacomercial,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Novedad.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setNovedads(clienteDataAccess.getNovedads(connexion,cliente));

				for(Novedad novedad:cliente.getNovedads()) {
					NovedadLogic novedadLogic= new NovedadLogic(connexion);
					novedadLogic.deepLoad(novedad,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(InformacionLaboral.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setInformacionLaborals(clienteDataAccess.getInformacionLaborals(connexion,cliente));

				for(InformacionLaboral informacionlaboral:cliente.getInformacionLaborals()) {
					InformacionLaboralLogic informacionlaboralLogic= new InformacionLaboralLogic(connexion);
					informacionlaboralLogic.deepLoad(informacionlaboral,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(InformacionFinanciera.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setInformacionFinancieras(clienteDataAccess.getInformacionFinancieras(connexion,cliente));

				for(InformacionFinanciera informacionfinanciera:cliente.getInformacionFinancieras()) {
					InformacionFinancieraLogic informacionfinancieraLogic= new InformacionFinancieraLogic(connexion);
					informacionfinancieraLogic.deepLoad(informacionfinanciera,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Telefono.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setTelefonos(clienteDataAccess.getTelefonos(connexion,cliente));

				for(Telefono telefono:cliente.getTelefonos()) {
					TelefonoLogic telefonoLogic= new TelefonoLogic(connexion);
					telefonoLogic.deepLoad(telefono,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CuentaPorCobrar.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setCuentaPorCobrars(clienteDataAccess.getCuentaPorCobrars(connexion,cliente));

				for(CuentaPorCobrar cuentaporcobrar:cliente.getCuentaPorCobrars()) {
					CuentaPorCobrarLogic cuentaporcobrarLogic= new CuentaPorCobrarLogic(connexion);
					cuentaporcobrarLogic.deepLoad(cuentaporcobrar,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Responsable.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setResponsables(clienteDataAccess.getResponsables(connexion,cliente));

				for(Responsable responsable:cliente.getResponsables()) {
					ResponsableLogic responsableLogic= new ResponsableLogic(connexion);
					responsableLogic.deepLoad(responsable,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Transportista.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setTransportistas(clienteDataAccess.getTransportistas(connexion,cliente));

				for(Transportista transportista:cliente.getTransportistas()) {
					TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
					transportistaLogic.deepLoad(transportista,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PoliticaCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setPoliticaClientes(clienteDataAccess.getPoliticaClientes(connexion,cliente));

				for(PoliticaCliente politicacliente:cliente.getPoliticaClientes()) {
					PoliticaClienteLogic politicaclienteLogic= new PoliticaClienteLogic(connexion);
					politicaclienteLogic.deepLoad(politicacliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Conyuge.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setConyuge(clienteDataAccess.getConyuge(connexion,cliente));

				ConyugeLogic conyugeLogic= new ConyugeLogic(connexion);

				conyugeLogic.deepLoad(cliente.getConyuge(),isDeep,deepLoadType,clases);
				continue;
			}

			if(clas.clas.equals(ReferenciaBancaria.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setReferenciaBancarias(clienteDataAccess.getReferenciaBancarias(connexion,cliente));

				for(ReferenciaBancaria referenciabancaria:cliente.getReferenciaBancarias()) {
					ReferenciaBancariaLogic referenciabancariaLogic= new ReferenciaBancariaLogic(connexion);
					referenciabancariaLogic.deepLoad(referenciabancaria,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(BalanceGeneralCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setBalanceGeneralClientes(clienteDataAccess.getBalanceGeneralClientes(connexion,cliente));

				for(BalanceGeneralCliente balancegeneralcliente:cliente.getBalanceGeneralClientes()) {
					BalanceGeneralClienteLogic balancegeneralclienteLogic= new BalanceGeneralClienteLogic(connexion);
					balancegeneralclienteLogic.deepLoad(balancegeneralcliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DatoConstitucion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setDatoConstitucions(clienteDataAccess.getDatoConstitucions(connexion,cliente));

				for(DatoConstitucion datoconstitucion:cliente.getDatoConstitucions()) {
					DatoConstitucionLogic datoconstitucionLogic= new DatoConstitucionLogic(connexion);
					datoconstitucionLogic.deepLoad(datoconstitucion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ActividadEconomica.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setActividadEconomicas(clienteDataAccess.getActividadEconomicas(connexion,cliente));

				for(ActividadEconomica actividadeconomica:cliente.getActividadEconomicas()) {
					ActividadEconomicaLogic actividadeconomicaLogic= new ActividadEconomicaLogic(connexion);
					actividadeconomicaLogic.deepLoad(actividadeconomica,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProveedorProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setProveedorProductos(clienteDataAccess.getProveedorProductos(connexion,cliente));

				for(ProveedorProducto proveedorproducto:cliente.getProveedorProductos()) {
					ProveedorProductoLogic proveedorproductoLogic= new ProveedorProductoLogic(connexion);
					proveedorproductoLogic.deepLoad(proveedorproducto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Consignatario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setConsignatarios(clienteDataAccess.getConsignatarios(connexion,cliente));

				for(Consignatario consignatario:cliente.getConsignatarios()) {
					ConsignatarioLogic consignatarioLogic= new ConsignatarioLogic(connexion);
					consignatarioLogic.deepLoad(consignatario,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(HobbyCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setHobbyClientes(clienteDataAccess.getHobbyClientes(connexion,cliente));

				for(HobbyCliente hobbycliente:cliente.getHobbyClientes()) {
					HobbyClienteLogic hobbyclienteLogic= new HobbyClienteLogic(connexion);
					hobbyclienteLogic.deepLoad(hobbycliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(RepresentanteLegal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setRepresentanteLegals(clienteDataAccess.getRepresentanteLegals(connexion,cliente));

				for(RepresentanteLegal representantelegal:cliente.getRepresentanteLegals()) {
					RepresentanteLegalLogic representantelegalLogic= new RepresentanteLegalLogic(connexion);
					representantelegalLogic.deepLoad(representantelegal,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ClienteCoa.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setClienteCoas(clienteDataAccess.getClienteCoas(connexion,cliente));

				for(ClienteCoa clientecoa:cliente.getClienteCoas()) {
					ClienteCoaLogic clientecoaLogic= new ClienteCoaLogic(connexion);
					clientecoaLogic.deepLoad(clientecoa,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Direccion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setDireccions(clienteDataAccess.getDireccions(connexion,cliente));

				for(Direccion direccion:cliente.getDireccions()) {
					DireccionLogic direccionLogic= new DireccionLogic(connexion);
					direccionLogic.deepLoad(direccion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ClienteImagen.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setClienteImagens(clienteDataAccess.getClienteImagens(connexion,cliente));

				for(ClienteImagen clienteimagen:cliente.getClienteImagens()) {
					ClienteImagenLogic clienteimagenLogic= new ClienteImagenLogic(connexion);
					clienteimagenLogic.deepLoad(clienteimagen,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(SubCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setSubClientes(clienteDataAccess.getSubClientes(connexion,cliente));

				for(SubCliente subcliente:cliente.getSubClientes()) {
					SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
					subclienteLogic.deepLoad(subcliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ServicioCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setServicioClientes(clienteDataAccess.getServicioClientes(connexion,cliente));

				for(ServicioCliente serviciocliente:cliente.getServicioClientes()) {
					ServicioClienteLogic servicioclienteLogic= new ServicioClienteLogic(connexion);
					servicioclienteLogic.deepLoad(serviciocliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(InformacionEconomica.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setInformacionEconomicas(clienteDataAccess.getInformacionEconomicas(connexion,cliente));

				for(InformacionEconomica informacioneconomica:cliente.getInformacionEconomicas()) {
					InformacionEconomicaLogic informacioneconomicaLogic= new InformacionEconomicaLogic(connexion);
					informacioneconomicaLogic.deepLoad(informacioneconomica,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(VehiculoCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setVehiculoClientes(clienteDataAccess.getVehiculoClientes(connexion,cliente));

				for(VehiculoCliente vehiculocliente:cliente.getVehiculoClientes()) {
					VehiculoClienteLogic vehiculoclienteLogic= new VehiculoClienteLogic(connexion);
					vehiculoclienteLogic.deepLoad(vehiculocliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(NegocioCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setNegocioClientes(clienteDataAccess.getNegocioClientes(connexion,cliente));

				for(NegocioCliente negociocliente:cliente.getNegocioClientes()) {
					NegocioClienteLogic negocioclienteLogic= new NegocioClienteLogic(connexion);
					negocioclienteLogic.deepLoad(negociocliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Monto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cliente.setMontos(clienteDataAccess.getMontos(connexion,cliente));

				for(Monto monto:cliente.getMontos()) {
					MontoLogic montoLogic= new MontoLogic(connexion);
					montoLogic.deepLoad(monto,isDeep,deepLoadType,clases);
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
			cliente.setEmpresa(clienteDataAccess.getEmpresa(connexion,cliente));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(cliente.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setSucursal(clienteDataAccess.getSucursal(connexion,cliente));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(cliente.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIdentificacion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setTipoIdentificacion(clienteDataAccess.getTipoIdentificacion(connexion,cliente));
			TipoIdentificacionLogic tipoidentificacionLogic= new TipoIdentificacionLogic(connexion);
			tipoidentificacionLogic.deepLoad(cliente.getTipoIdentificacion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(GrupoCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setGrupoCliente(clienteDataAccess.getGrupoCliente(connexion,cliente));
			GrupoClienteLogic grupoclienteLogic= new GrupoClienteLogic(connexion);
			grupoclienteLogic.deepLoad(cliente.getGrupoCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TituloCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setTituloCliente(clienteDataAccess.getTituloCliente(connexion,cliente));
			TituloClienteLogic tituloclienteLogic= new TituloClienteLogic(connexion);
			tituloclienteLogic.deepLoad(cliente.getTituloCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(AreaCr.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setAreaCr(clienteDataAccess.getAreaCr(connexion,cliente));
			AreaCrLogic areacrLogic= new AreaCrLogic(connexion);
			areacrLogic.deepLoad(cliente.getAreaCr(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setEstadoCliente(clienteDataAccess.getEstadoCliente(connexion,cliente));
			EstadoClienteLogic estadoclienteLogic= new EstadoClienteLogic(connexion);
			estadoclienteLogic.deepLoad(cliente.getEstadoCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setPais(clienteDataAccess.getPais(connexion,cliente));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(cliente.getPais(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Region.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setRegion(clienteDataAccess.getRegion(connexion,cliente));
			RegionLogic regionLogic= new RegionLogic(connexion);
			regionLogic.deepLoad(cliente.getRegion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Provincia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setProvincia(clienteDataAccess.getProvincia(connexion,cliente));
			ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
			provinciaLogic.deepLoad(cliente.getProvincia(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ciudad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setCiudad(clienteDataAccess.getCiudad(connexion,cliente));
			CiudadLogic ciudadLogic= new CiudadLogic(connexion);
			ciudadLogic.deepLoad(cliente.getCiudad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Zona.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setZona(clienteDataAccess.getZona(connexion,cliente));
			ZonaLogic zonaLogic= new ZonaLogic(connexion);
			zonaLogic.deepLoad(cliente.getZona(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setPaisNacionalidad(clienteDataAccess.getPaisNacionalidad(connexion,cliente));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(cliente.getPaisNacionalidad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCargoLabo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setTipoCargoLabo(clienteDataAccess.getTipoCargoLabo(connexion,cliente));
			TipoCargoLaboLogic tipocargolaboLogic= new TipoCargoLaboLogic(connexion);
			tipocargolaboLogic.deepLoad(cliente.getTipoCargoLabo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoNivelEdu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setTipoNivelEdu(clienteDataAccess.getTipoNivelEdu(connexion,cliente));
			TipoNivelEduLogic tiponiveleduLogic= new TipoNivelEduLogic(connexion);
			tiponiveleduLogic.deepLoad(cliente.getTipoNivelEdu(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Profesion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setProfesion(clienteDataAccess.getProfesion(connexion,cliente));
			ProfesionLogic profesionLogic= new ProfesionLogic(connexion);
			profesionLogic.deepLoad(cliente.getProfesion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoGenero.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setTipoGenero(clienteDataAccess.getTipoGenero(connexion,cliente));
			TipoGeneroLogic tipogeneroLogic= new TipoGeneroLogic(connexion);
			tipogeneroLogic.deepLoad(cliente.getTipoGenero(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoCivil.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setEstadoCivil(clienteDataAccess.getEstadoCivil(connexion,cliente));
			EstadoCivilLogic estadocivilLogic= new EstadoCivilLogic(connexion);
			estadocivilLogic.deepLoad(cliente.getEstadoCivil(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoLegal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setEstadoLegal(clienteDataAccess.getEstadoLegal(connexion,cliente));
			EstadoLegalLogic estadolegalLogic= new EstadoLegalLogic(connexion);
			estadolegalLogic.deepLoad(cliente.getEstadoLegal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setCuentaContable(clienteDataAccess.getCuentaContable(connexion,cliente));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(cliente.getCuentaContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ruta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setRuta(clienteDataAccess.getRuta(connexion,cliente));
			RutaLogic rutaLogic= new RutaLogic(connexion);
			rutaLogic.deepLoad(cliente.getRuta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Vendedor.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setVendedor(clienteDataAccess.getVendedor(connexion,cliente));
			VendedorLogic vendedorLogic= new VendedorLogic(connexion);
			vendedorLogic.deepLoad(cliente.getVendedor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroActividad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setCentroActividad(clienteDataAccess.getCentroActividad(connexion,cliente));
			CentroActividadLogic centroactividadLogic= new CentroActividadLogic(connexion);
			centroactividadLogic.deepLoad(cliente.getCentroActividad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoGarantiaEmpresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setTipoGarantiaEmpresa(clienteDataAccess.getTipoGarantiaEmpresa(connexion,cliente));
			TipoGarantiaEmpresaLogic tipogarantiaempresaLogic= new TipoGarantiaEmpresaLogic(connexion);
			tipogarantiaempresaLogic.deepLoad(cliente.getTipoGarantiaEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CateTipoAfiliacion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setCateTipoAfiliacion(clienteDataAccess.getCateTipoAfiliacion(connexion,cliente));
			CateTipoAfiliacionLogic catetipoafiliacionLogic= new CateTipoAfiliacionLogic(connexion);
			catetipoafiliacionLogic.deepLoad(cliente.getCateTipoAfiliacion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Dia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setDia(clienteDataAccess.getDia(connexion,cliente));
			DiaLogic diaLogic= new DiaLogic(connexion);
			diaLogic.deepLoad(cliente.getDia(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setEmpleado(clienteDataAccess.getEmpleado(connexion,cliente));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(cliente.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrecio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setTipoPrecio(clienteDataAccess.getTipoPrecio(connexion,cliente));
			TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
			tipoprecioLogic.deepLoad(cliente.getTipoPrecio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoListaPrecio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cliente.setTipoListaPrecio(clienteDataAccess.getTipoListaPrecio(connexion,cliente));
			TipoListaPrecioLogic tipolistaprecioLogic= new TipoListaPrecioLogic(connexion);
			tipolistaprecioLogic.deepLoad(cliente.getTipoListaPrecio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ContactoCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ContactoCliente.class));
			cliente.setContactoClientes(clienteDataAccess.getContactoClientes(connexion,cliente));

			for(ContactoCliente contactocliente:cliente.getContactoClientes()) {
				ContactoClienteLogic contactoclienteLogic= new ContactoClienteLogic(connexion);
				contactoclienteLogic.deepLoad(contactocliente,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bien.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Bien.class));
			cliente.setBiens(clienteDataAccess.getBiens(connexion,cliente));

			for(Bien bien:cliente.getBiens()) {
				BienLogic bienLogic= new BienLogic(connexion);
				bienLogic.deepLoad(bien,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CargaFamiliar.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CargaFamiliar.class));
			cliente.setCargaFamiliars(clienteDataAccess.getCargaFamiliars(connexion,cliente));

			for(CargaFamiliar cargafamiliar:cliente.getCargaFamiliars()) {
				CargaFamiliarLogic cargafamiliarLogic= new CargaFamiliarLogic(connexion);
				cargafamiliarLogic.deepLoad(cargafamiliar,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ChequePostFechado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ChequePostFechado.class));
			cliente.setChequePostFechados(clienteDataAccess.getChequePostFechados(connexion,cliente));

			for(ChequePostFechado chequepostfechado:cliente.getChequePostFechados()) {
				ChequePostFechadoLogic chequepostfechadoLogic= new ChequePostFechadoLogic(connexion);
				chequepostfechadoLogic.deepLoad(chequepostfechado,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EMail.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EMail.class));
			cliente.setEMails(clienteDataAccess.getEMails(connexion,cliente));

			for(EMail email:cliente.getEMails()) {
				EMailLogic emailLogic= new EMailLogic(connexion);
				emailLogic.deepLoad(email,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ReferenciaPersonal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ReferenciaPersonal.class));
			cliente.setReferenciaPersonals(clienteDataAccess.getReferenciaPersonals(connexion,cliente));

			for(ReferenciaPersonal referenciapersonal:cliente.getReferenciaPersonals()) {
				ReferenciaPersonalLogic referenciapersonalLogic= new ReferenciaPersonalLogic(connexion);
				referenciapersonalLogic.deepLoad(referenciapersonal,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GarantiaCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(GarantiaCliente.class));
			cliente.setGarantiaClientes(clienteDataAccess.getGarantiaClientes(connexion,cliente));

			for(GarantiaCliente garantiacliente:cliente.getGarantiaClientes()) {
				GarantiaClienteLogic garantiaclienteLogic= new GarantiaClienteLogic(connexion);
				garantiaclienteLogic.deepLoad(garantiacliente,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ClienteArchivo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ClienteArchivo.class));
			cliente.setClienteArchivos(clienteDataAccess.getClienteArchivos(connexion,cliente));

			for(ClienteArchivo clientearchivo:cliente.getClienteArchivos()) {
				ClienteArchivoLogic clientearchivoLogic= new ClienteArchivoLogic(connexion);
				clientearchivoLogic.deepLoad(clientearchivo,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PoliticasCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
				clases.add(new Classe(PoliticasCliente.class));
				cliente.setPoliticasCliente(clienteDataAccess.getPoliticasCliente(connexion,cliente));

					PoliticasClienteLogic politicasclienteLogic= new PoliticasClienteLogic(connexion);

				politicasclienteLogic.deepLoad(cliente.getPoliticasCliente(),isDeep,deepLoadType,clases);
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FirmaCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FirmaCliente.class));
			cliente.setFirmaClientes(clienteDataAccess.getFirmaClientes(connexion,cliente));

			for(FirmaCliente firmacliente:cliente.getFirmaClientes()) {
				FirmaClienteLogic firmaclienteLogic= new FirmaClienteLogic(connexion);
				firmaclienteLogic.deepLoad(firmacliente,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ReferenciaComercial.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ReferenciaComercial.class));
			cliente.setReferenciaComercials(clienteDataAccess.getReferenciaComercials(connexion,cliente));

			for(ReferenciaComercial referenciacomercial:cliente.getReferenciaComercials()) {
				ReferenciaComercialLogic referenciacomercialLogic= new ReferenciaComercialLogic(connexion);
				referenciacomercialLogic.deepLoad(referenciacomercial,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Novedad.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Novedad.class));
			cliente.setNovedads(clienteDataAccess.getNovedads(connexion,cliente));

			for(Novedad novedad:cliente.getNovedads()) {
				NovedadLogic novedadLogic= new NovedadLogic(connexion);
				novedadLogic.deepLoad(novedad,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(InformacionLaboral.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(InformacionLaboral.class));
			cliente.setInformacionLaborals(clienteDataAccess.getInformacionLaborals(connexion,cliente));

			for(InformacionLaboral informacionlaboral:cliente.getInformacionLaborals()) {
				InformacionLaboralLogic informacionlaboralLogic= new InformacionLaboralLogic(connexion);
				informacionlaboralLogic.deepLoad(informacionlaboral,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(InformacionFinanciera.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(InformacionFinanciera.class));
			cliente.setInformacionFinancieras(clienteDataAccess.getInformacionFinancieras(connexion,cliente));

			for(InformacionFinanciera informacionfinanciera:cliente.getInformacionFinancieras()) {
				InformacionFinancieraLogic informacionfinancieraLogic= new InformacionFinancieraLogic(connexion);
				informacionfinancieraLogic.deepLoad(informacionfinanciera,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Telefono.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Telefono.class));
			cliente.setTelefonos(clienteDataAccess.getTelefonos(connexion,cliente));

			for(Telefono telefono:cliente.getTelefonos()) {
				TelefonoLogic telefonoLogic= new TelefonoLogic(connexion);
				telefonoLogic.deepLoad(telefono,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaPorCobrar.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CuentaPorCobrar.class));
			cliente.setCuentaPorCobrars(clienteDataAccess.getCuentaPorCobrars(connexion,cliente));

			for(CuentaPorCobrar cuentaporcobrar:cliente.getCuentaPorCobrars()) {
				CuentaPorCobrarLogic cuentaporcobrarLogic= new CuentaPorCobrarLogic(connexion);
				cuentaporcobrarLogic.deepLoad(cuentaporcobrar,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Responsable.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Responsable.class));
			cliente.setResponsables(clienteDataAccess.getResponsables(connexion,cliente));

			for(Responsable responsable:cliente.getResponsables()) {
				ResponsableLogic responsableLogic= new ResponsableLogic(connexion);
				responsableLogic.deepLoad(responsable,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transportista.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Transportista.class));
			cliente.setTransportistas(clienteDataAccess.getTransportistas(connexion,cliente));

			for(Transportista transportista:cliente.getTransportistas()) {
				TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
				transportistaLogic.deepLoad(transportista,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PoliticaCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PoliticaCliente.class));
			cliente.setPoliticaClientes(clienteDataAccess.getPoliticaClientes(connexion,cliente));

			for(PoliticaCliente politicacliente:cliente.getPoliticaClientes()) {
				PoliticaClienteLogic politicaclienteLogic= new PoliticaClienteLogic(connexion);
				politicaclienteLogic.deepLoad(politicacliente,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Conyuge.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
				clases.add(new Classe(Conyuge.class));
				cliente.setConyuge(clienteDataAccess.getConyuge(connexion,cliente));

					ConyugeLogic conyugeLogic= new ConyugeLogic(connexion);

				conyugeLogic.deepLoad(cliente.getConyuge(),isDeep,deepLoadType,clases);
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ReferenciaBancaria.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ReferenciaBancaria.class));
			cliente.setReferenciaBancarias(clienteDataAccess.getReferenciaBancarias(connexion,cliente));

			for(ReferenciaBancaria referenciabancaria:cliente.getReferenciaBancarias()) {
				ReferenciaBancariaLogic referenciabancariaLogic= new ReferenciaBancariaLogic(connexion);
				referenciabancariaLogic.deepLoad(referenciabancaria,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(BalanceGeneralCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(BalanceGeneralCliente.class));
			cliente.setBalanceGeneralClientes(clienteDataAccess.getBalanceGeneralClientes(connexion,cliente));

			for(BalanceGeneralCliente balancegeneralcliente:cliente.getBalanceGeneralClientes()) {
				BalanceGeneralClienteLogic balancegeneralclienteLogic= new BalanceGeneralClienteLogic(connexion);
				balancegeneralclienteLogic.deepLoad(balancegeneralcliente,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DatoConstitucion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DatoConstitucion.class));
			cliente.setDatoConstitucions(clienteDataAccess.getDatoConstitucions(connexion,cliente));

			for(DatoConstitucion datoconstitucion:cliente.getDatoConstitucions()) {
				DatoConstitucionLogic datoconstitucionLogic= new DatoConstitucionLogic(connexion);
				datoconstitucionLogic.deepLoad(datoconstitucion,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ActividadEconomica.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ActividadEconomica.class));
			cliente.setActividadEconomicas(clienteDataAccess.getActividadEconomicas(connexion,cliente));

			for(ActividadEconomica actividadeconomica:cliente.getActividadEconomicas()) {
				ActividadEconomicaLogic actividadeconomicaLogic= new ActividadEconomicaLogic(connexion);
				actividadeconomicaLogic.deepLoad(actividadeconomica,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProveedorProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProveedorProducto.class));
			cliente.setProveedorProductos(clienteDataAccess.getProveedorProductos(connexion,cliente));

			for(ProveedorProducto proveedorproducto:cliente.getProveedorProductos()) {
				ProveedorProductoLogic proveedorproductoLogic= new ProveedorProductoLogic(connexion);
				proveedorproductoLogic.deepLoad(proveedorproducto,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Consignatario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Consignatario.class));
			cliente.setConsignatarios(clienteDataAccess.getConsignatarios(connexion,cliente));

			for(Consignatario consignatario:cliente.getConsignatarios()) {
				ConsignatarioLogic consignatarioLogic= new ConsignatarioLogic(connexion);
				consignatarioLogic.deepLoad(consignatario,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(HobbyCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(HobbyCliente.class));
			cliente.setHobbyClientes(clienteDataAccess.getHobbyClientes(connexion,cliente));

			for(HobbyCliente hobbycliente:cliente.getHobbyClientes()) {
				HobbyClienteLogic hobbyclienteLogic= new HobbyClienteLogic(connexion);
				hobbyclienteLogic.deepLoad(hobbycliente,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RepresentanteLegal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(RepresentanteLegal.class));
			cliente.setRepresentanteLegals(clienteDataAccess.getRepresentanteLegals(connexion,cliente));

			for(RepresentanteLegal representantelegal:cliente.getRepresentanteLegals()) {
				RepresentanteLegalLogic representantelegalLogic= new RepresentanteLegalLogic(connexion);
				representantelegalLogic.deepLoad(representantelegal,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ClienteCoa.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ClienteCoa.class));
			cliente.setClienteCoas(clienteDataAccess.getClienteCoas(connexion,cliente));

			for(ClienteCoa clientecoa:cliente.getClienteCoas()) {
				ClienteCoaLogic clientecoaLogic= new ClienteCoaLogic(connexion);
				clientecoaLogic.deepLoad(clientecoa,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Direccion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Direccion.class));
			cliente.setDireccions(clienteDataAccess.getDireccions(connexion,cliente));

			for(Direccion direccion:cliente.getDireccions()) {
				DireccionLogic direccionLogic= new DireccionLogic(connexion);
				direccionLogic.deepLoad(direccion,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ClienteImagen.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ClienteImagen.class));
			cliente.setClienteImagens(clienteDataAccess.getClienteImagens(connexion,cliente));

			for(ClienteImagen clienteimagen:cliente.getClienteImagens()) {
				ClienteImagenLogic clienteimagenLogic= new ClienteImagenLogic(connexion);
				clienteimagenLogic.deepLoad(clienteimagen,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(SubCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(SubCliente.class));
			cliente.setSubClientes(clienteDataAccess.getSubClientes(connexion,cliente));

			for(SubCliente subcliente:cliente.getSubClientes()) {
				SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
				subclienteLogic.deepLoad(subcliente,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ServicioCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ServicioCliente.class));
			cliente.setServicioClientes(clienteDataAccess.getServicioClientes(connexion,cliente));

			for(ServicioCliente serviciocliente:cliente.getServicioClientes()) {
				ServicioClienteLogic servicioclienteLogic= new ServicioClienteLogic(connexion);
				servicioclienteLogic.deepLoad(serviciocliente,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(InformacionEconomica.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(InformacionEconomica.class));
			cliente.setInformacionEconomicas(clienteDataAccess.getInformacionEconomicas(connexion,cliente));

			for(InformacionEconomica informacioneconomica:cliente.getInformacionEconomicas()) {
				InformacionEconomicaLogic informacioneconomicaLogic= new InformacionEconomicaLogic(connexion);
				informacioneconomicaLogic.deepLoad(informacioneconomica,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(VehiculoCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(VehiculoCliente.class));
			cliente.setVehiculoClientes(clienteDataAccess.getVehiculoClientes(connexion,cliente));

			for(VehiculoCliente vehiculocliente:cliente.getVehiculoClientes()) {
				VehiculoClienteLogic vehiculoclienteLogic= new VehiculoClienteLogic(connexion);
				vehiculoclienteLogic.deepLoad(vehiculocliente,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NegocioCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(NegocioCliente.class));
			cliente.setNegocioClientes(clienteDataAccess.getNegocioClientes(connexion,cliente));

			for(NegocioCliente negociocliente:cliente.getNegocioClientes()) {
				NegocioClienteLogic negocioclienteLogic= new NegocioClienteLogic(connexion);
				negocioclienteLogic.deepLoad(negociocliente,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Monto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Monto.class));
			cliente.setMontos(clienteDataAccess.getMontos(connexion,cliente));

			for(Monto monto:cliente.getMontos()) {
				MontoLogic montoLogic= new MontoLogic(connexion);
				montoLogic.deepLoad(monto,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Cliente cliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ClienteLogicAdditional.updateClienteToSave(cliente,this.arrDatoGeneral);
			
ClienteDataAccess.save(cliente, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(cliente.getEmpresa(),connexion);

		SucursalDataAccess.save(cliente.getSucursal(),connexion);

		TipoIdentificacionDataAccess.save(cliente.getTipoIdentificacion(),connexion);

		GrupoClienteDataAccess.save(cliente.getGrupoCliente(),connexion);

		TituloClienteDataAccess.save(cliente.getTituloCliente(),connexion);

		AreaCrDataAccess.save(cliente.getAreaCr(),connexion);

		EstadoClienteDataAccess.save(cliente.getEstadoCliente(),connexion);

		PaisDataAccess.save(cliente.getPais(),connexion);

		RegionDataAccess.save(cliente.getRegion(),connexion);

		ProvinciaDataAccess.save(cliente.getProvincia(),connexion);

		CiudadDataAccess.save(cliente.getCiudad(),connexion);

		ZonaDataAccess.save(cliente.getZona(),connexion);

		PaisDataAccess.save(cliente.getPaisNacionalidad(),connexion);

		TipoCargoLaboDataAccess.save(cliente.getTipoCargoLabo(),connexion);

		TipoNivelEduDataAccess.save(cliente.getTipoNivelEdu(),connexion);

		ProfesionDataAccess.save(cliente.getProfesion(),connexion);

		TipoGeneroDataAccess.save(cliente.getTipoGenero(),connexion);

		EstadoCivilDataAccess.save(cliente.getEstadoCivil(),connexion);

		EstadoLegalDataAccess.save(cliente.getEstadoLegal(),connexion);

		CuentaContableDataAccess.save(cliente.getCuentaContable(),connexion);

		RutaDataAccess.save(cliente.getRuta(),connexion);

		VendedorDataAccess.save(cliente.getVendedor(),connexion);

		CentroActividadDataAccess.save(cliente.getCentroActividad(),connexion);

		TipoGarantiaEmpresaDataAccess.save(cliente.getTipoGarantiaEmpresa(),connexion);

		CateTipoAfiliacionDataAccess.save(cliente.getCateTipoAfiliacion(),connexion);

		DiaDataAccess.save(cliente.getDia(),connexion);

		EmpleadoDataAccess.save(cliente.getEmpleado(),connexion);

		TipoPrecioDataAccess.save(cliente.getTipoPrecio(),connexion);

		TipoListaPrecioDataAccess.save(cliente.getTipoListaPrecio(),connexion);

		for(ContactoCliente contactocliente:cliente.getContactoClientes()) {
			contactocliente.setid_cliente(cliente.getId());
			ContactoClienteDataAccess.save(contactocliente,connexion);
		}

		for(Bien bien:cliente.getBiens()) {
			bien.setid_cliente(cliente.getId());
			BienDataAccess.save(bien,connexion);
		}

		for(CargaFamiliar cargafamiliar:cliente.getCargaFamiliars()) {
			cargafamiliar.setid_cliente(cliente.getId());
			CargaFamiliarDataAccess.save(cargafamiliar,connexion);
		}

		for(ChequePostFechado chequepostfechado:cliente.getChequePostFechados()) {
			chequepostfechado.setid_cliente(cliente.getId());
			ChequePostFechadoDataAccess.save(chequepostfechado,connexion);
		}

		for(EMail email:cliente.getEMails()) {
			email.setid_cliente(cliente.getId());
			EMailDataAccess.save(email,connexion);
		}

		for(ReferenciaPersonal referenciapersonal:cliente.getReferenciaPersonals()) {
			referenciapersonal.setidcliente(cliente.getId());
			ReferenciaPersonalDataAccess.save(referenciapersonal,connexion);
		}

		for(GarantiaCliente garantiacliente:cliente.getGarantiaClientes()) {
			garantiacliente.setid_cliente(cliente.getId());
			GarantiaClienteDataAccess.save(garantiacliente,connexion);
		}

		for(ClienteArchivo clientearchivo:cliente.getClienteArchivos()) {
			clientearchivo.setid_cliente(cliente.getId());
			ClienteArchivoDataAccess.save(clientearchivo,connexion);
		}

			cliente.getPoliticasCliente().setId(cliente.getId());
		PoliticasClienteDataAccess.save(cliente.getPoliticasCliente(),connexion);

		for(FirmaCliente firmacliente:cliente.getFirmaClientes()) {
			firmacliente.setid_cliente(cliente.getId());
			FirmaClienteDataAccess.save(firmacliente,connexion);
		}

		for(ReferenciaComercial referenciacomercial:cliente.getReferenciaComercials()) {
			referenciacomercial.setidcliente(cliente.getId());
			ReferenciaComercialDataAccess.save(referenciacomercial,connexion);
		}

		for(Novedad novedad:cliente.getNovedads()) {
			novedad.setid_cliente(cliente.getId());
			NovedadDataAccess.save(novedad,connexion);
		}

		for(InformacionLaboral informacionlaboral:cliente.getInformacionLaborals()) {
			informacionlaboral.setidcliente(cliente.getId());
			InformacionLaboralDataAccess.save(informacionlaboral,connexion);
		}

		for(InformacionFinanciera informacionfinanciera:cliente.getInformacionFinancieras()) {
			informacionfinanciera.setidcliente(cliente.getId());
			InformacionFinancieraDataAccess.save(informacionfinanciera,connexion);
		}

		for(Telefono telefono:cliente.getTelefonos()) {
			telefono.setid_cliente(cliente.getId());
			TelefonoDataAccess.save(telefono,connexion);
		}

		for(CuentaPorCobrar cuentaporcobrar:cliente.getCuentaPorCobrars()) {
			cuentaporcobrar.setid_cliente(cliente.getId());
			CuentaPorCobrarDataAccess.save(cuentaporcobrar,connexion);
		}

		for(Responsable responsable:cliente.getResponsables()) {
			responsable.setid_cliente(cliente.getId());
			ResponsableDataAccess.save(responsable,connexion);
		}

		for(Transportista transportista:cliente.getTransportistas()) {
			transportista.setid_cliente(cliente.getId());
			TransportistaDataAccess.save(transportista,connexion);
		}

		for(PoliticaCliente politicacliente:cliente.getPoliticaClientes()) {
			politicacliente.setid_cliente(cliente.getId());
			PoliticaClienteDataAccess.save(politicacliente,connexion);
		}

			cliente.getConyuge().setId(cliente.getId());
		ConyugeDataAccess.save(cliente.getConyuge(),connexion);

		for(ReferenciaBancaria referenciabancaria:cliente.getReferenciaBancarias()) {
			referenciabancaria.setidcliente(cliente.getId());
			ReferenciaBancariaDataAccess.save(referenciabancaria,connexion);
		}

		for(BalanceGeneralCliente balancegeneralcliente:cliente.getBalanceGeneralClientes()) {
			balancegeneralcliente.setid_cliente(cliente.getId());
			BalanceGeneralClienteDataAccess.save(balancegeneralcliente,connexion);
		}

		for(DatoConstitucion datoconstitucion:cliente.getDatoConstitucions()) {
			datoconstitucion.setidcliente(cliente.getId());
			DatoConstitucionDataAccess.save(datoconstitucion,connexion);
		}

		for(ActividadEconomica actividadeconomica:cliente.getActividadEconomicas()) {
			actividadeconomica.setid_cliente(cliente.getId());
			ActividadEconomicaDataAccess.save(actividadeconomica,connexion);
		}

		for(ProveedorProducto proveedorproducto:cliente.getProveedorProductos()) {
			proveedorproducto.setid_cliente(cliente.getId());
			ProveedorProductoDataAccess.save(proveedorproducto,connexion);
		}

		for(Consignatario consignatario:cliente.getConsignatarios()) {
			consignatario.setid_cliente(cliente.getId());
			ConsignatarioDataAccess.save(consignatario,connexion);
		}

		for(HobbyCliente hobbycliente:cliente.getHobbyClientes()) {
			hobbycliente.setid_cliente(cliente.getId());
			HobbyClienteDataAccess.save(hobbycliente,connexion);
		}

		for(RepresentanteLegal representantelegal:cliente.getRepresentanteLegals()) {
			representantelegal.setidcliente(cliente.getId());
			RepresentanteLegalDataAccess.save(representantelegal,connexion);
		}

		for(ClienteCoa clientecoa:cliente.getClienteCoas()) {
			clientecoa.setid_cliente(cliente.getId());
			ClienteCoaDataAccess.save(clientecoa,connexion);
		}

		for(Direccion direccion:cliente.getDireccions()) {
			direccion.setid_cliente(cliente.getId());
			DireccionDataAccess.save(direccion,connexion);
		}

		for(ClienteImagen clienteimagen:cliente.getClienteImagens()) {
			clienteimagen.setid_cliente(cliente.getId());
			ClienteImagenDataAccess.save(clienteimagen,connexion);
		}

		for(SubCliente subcliente:cliente.getSubClientes()) {
			subcliente.setid_cliente(cliente.getId());
			SubClienteDataAccess.save(subcliente,connexion);
		}

		for(ServicioCliente serviciocliente:cliente.getServicioClientes()) {
			serviciocliente.setid_cliente(cliente.getId());
			ServicioClienteDataAccess.save(serviciocliente,connexion);
		}

		for(InformacionEconomica informacioneconomica:cliente.getInformacionEconomicas()) {
			informacioneconomica.setidcliente(cliente.getId());
			InformacionEconomicaDataAccess.save(informacioneconomica,connexion);
		}

		for(VehiculoCliente vehiculocliente:cliente.getVehiculoClientes()) {
			vehiculocliente.setid_cliente(cliente.getId());
			VehiculoClienteDataAccess.save(vehiculocliente,connexion);
		}

		for(NegocioCliente negociocliente:cliente.getNegocioClientes()) {
			negociocliente.setid_cliente(cliente.getId());
			NegocioClienteDataAccess.save(negociocliente,connexion);
		}

		for(Monto monto:cliente.getMontos()) {
			monto.setid_cliente(cliente.getId());
			MontoDataAccess.save(monto,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cliente.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(cliente.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoIdentificacion.class)) {
				TipoIdentificacionDataAccess.save(cliente.getTipoIdentificacion(),connexion);
				continue;
			}

			if(clas.clas.equals(GrupoCliente.class)) {
				GrupoClienteDataAccess.save(cliente.getGrupoCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(TituloCliente.class)) {
				TituloClienteDataAccess.save(cliente.getTituloCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(AreaCr.class)) {
				AreaCrDataAccess.save(cliente.getAreaCr(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoCliente.class)) {
				EstadoClienteDataAccess.save(cliente.getEstadoCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(cliente.getPais(),connexion);
				continue;
			}

			if(clas.clas.equals(Region.class)) {
				RegionDataAccess.save(cliente.getRegion(),connexion);
				continue;
			}

			if(clas.clas.equals(Provincia.class)) {
				ProvinciaDataAccess.save(cliente.getProvincia(),connexion);
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(cliente.getCiudad(),connexion);
				continue;
			}

			if(clas.clas.equals(Zona.class)) {
				ZonaDataAccess.save(cliente.getZona(),connexion);
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(cliente.getPaisNacionalidad(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoCargoLabo.class)) {
				TipoCargoLaboDataAccess.save(cliente.getTipoCargoLabo(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoNivelEdu.class)) {
				TipoNivelEduDataAccess.save(cliente.getTipoNivelEdu(),connexion);
				continue;
			}

			if(clas.clas.equals(Profesion.class)) {
				ProfesionDataAccess.save(cliente.getProfesion(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoGenero.class)) {
				TipoGeneroDataAccess.save(cliente.getTipoGenero(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoCivil.class)) {
				EstadoCivilDataAccess.save(cliente.getEstadoCivil(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoLegal.class)) {
				EstadoLegalDataAccess.save(cliente.getEstadoLegal(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cliente.getCuentaContable(),connexion);
				continue;
			}

			if(clas.clas.equals(Ruta.class)) {
				RutaDataAccess.save(cliente.getRuta(),connexion);
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(cliente.getVendedor(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroActividad.class)) {
				CentroActividadDataAccess.save(cliente.getCentroActividad(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoGarantiaEmpresa.class)) {
				TipoGarantiaEmpresaDataAccess.save(cliente.getTipoGarantiaEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(CateTipoAfiliacion.class)) {
				CateTipoAfiliacionDataAccess.save(cliente.getCateTipoAfiliacion(),connexion);
				continue;
			}

			if(clas.clas.equals(Dia.class)) {
				DiaDataAccess.save(cliente.getDia(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(cliente.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				TipoPrecioDataAccess.save(cliente.getTipoPrecio(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoListaPrecio.class)) {
				TipoListaPrecioDataAccess.save(cliente.getTipoListaPrecio(),connexion);
				continue;
			}


			if(clas.clas.equals(ContactoCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ContactoCliente contactocliente:cliente.getContactoClientes()) {
					contactocliente.setid_cliente(cliente.getId());
					ContactoClienteDataAccess.save(contactocliente,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Bien.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Bien bien:cliente.getBiens()) {
					bien.setid_cliente(cliente.getId());
					BienDataAccess.save(bien,connexion);
				}
				continue;
			}

			if(clas.clas.equals(CargaFamiliar.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CargaFamiliar cargafamiliar:cliente.getCargaFamiliars()) {
					cargafamiliar.setid_cliente(cliente.getId());
					CargaFamiliarDataAccess.save(cargafamiliar,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ChequePostFechado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ChequePostFechado chequepostfechado:cliente.getChequePostFechados()) {
					chequepostfechado.setid_cliente(cliente.getId());
					ChequePostFechadoDataAccess.save(chequepostfechado,connexion);
				}
				continue;
			}

			if(clas.clas.equals(EMail.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EMail email:cliente.getEMails()) {
					email.setid_cliente(cliente.getId());
					EMailDataAccess.save(email,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ReferenciaPersonal.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ReferenciaPersonal referenciapersonal:cliente.getReferenciaPersonals()) {
					referenciapersonal.setidcliente(cliente.getId());
					ReferenciaPersonalDataAccess.save(referenciapersonal,connexion);
				}
				continue;
			}

			if(clas.clas.equals(GarantiaCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(GarantiaCliente garantiacliente:cliente.getGarantiaClientes()) {
					garantiacliente.setid_cliente(cliente.getId());
					GarantiaClienteDataAccess.save(garantiacliente,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ClienteArchivo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ClienteArchivo clientearchivo:cliente.getClienteArchivos()) {
					clientearchivo.setid_cliente(cliente.getId());
					ClienteArchivoDataAccess.save(clientearchivo,connexion);
				}
				continue;
			}

			if(clas.clas.equals(PoliticasCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				cliente.getPoliticasCliente().setId(cliente.getId());
		PoliticasClienteDataAccess.save(cliente.getPoliticasCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(FirmaCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FirmaCliente firmacliente:cliente.getFirmaClientes()) {
					firmacliente.setid_cliente(cliente.getId());
					FirmaClienteDataAccess.save(firmacliente,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ReferenciaComercial.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ReferenciaComercial referenciacomercial:cliente.getReferenciaComercials()) {
					referenciacomercial.setidcliente(cliente.getId());
					ReferenciaComercialDataAccess.save(referenciacomercial,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Novedad.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Novedad novedad:cliente.getNovedads()) {
					novedad.setid_cliente(cliente.getId());
					NovedadDataAccess.save(novedad,connexion);
				}
				continue;
			}

			if(clas.clas.equals(InformacionLaboral.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(InformacionLaboral informacionlaboral:cliente.getInformacionLaborals()) {
					informacionlaboral.setidcliente(cliente.getId());
					InformacionLaboralDataAccess.save(informacionlaboral,connexion);
				}
				continue;
			}

			if(clas.clas.equals(InformacionFinanciera.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(InformacionFinanciera informacionfinanciera:cliente.getInformacionFinancieras()) {
					informacionfinanciera.setidcliente(cliente.getId());
					InformacionFinancieraDataAccess.save(informacionfinanciera,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Telefono.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Telefono telefono:cliente.getTelefonos()) {
					telefono.setid_cliente(cliente.getId());
					TelefonoDataAccess.save(telefono,connexion);
				}
				continue;
			}

			if(clas.clas.equals(CuentaPorCobrar.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CuentaPorCobrar cuentaporcobrar:cliente.getCuentaPorCobrars()) {
					cuentaporcobrar.setid_cliente(cliente.getId());
					CuentaPorCobrarDataAccess.save(cuentaporcobrar,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Responsable.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Responsable responsable:cliente.getResponsables()) {
					responsable.setid_cliente(cliente.getId());
					ResponsableDataAccess.save(responsable,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Transportista.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Transportista transportista:cliente.getTransportistas()) {
					transportista.setid_cliente(cliente.getId());
					TransportistaDataAccess.save(transportista,connexion);
				}
				continue;
			}

			if(clas.clas.equals(PoliticaCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PoliticaCliente politicacliente:cliente.getPoliticaClientes()) {
					politicacliente.setid_cliente(cliente.getId());
					PoliticaClienteDataAccess.save(politicacliente,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Conyuge.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				cliente.getConyuge().setId(cliente.getId());
		ConyugeDataAccess.save(cliente.getConyuge(),connexion);
				continue;
			}

			if(clas.clas.equals(ReferenciaBancaria.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ReferenciaBancaria referenciabancaria:cliente.getReferenciaBancarias()) {
					referenciabancaria.setidcliente(cliente.getId());
					ReferenciaBancariaDataAccess.save(referenciabancaria,connexion);
				}
				continue;
			}

			if(clas.clas.equals(BalanceGeneralCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(BalanceGeneralCliente balancegeneralcliente:cliente.getBalanceGeneralClientes()) {
					balancegeneralcliente.setid_cliente(cliente.getId());
					BalanceGeneralClienteDataAccess.save(balancegeneralcliente,connexion);
				}
				continue;
			}

			if(clas.clas.equals(DatoConstitucion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DatoConstitucion datoconstitucion:cliente.getDatoConstitucions()) {
					datoconstitucion.setidcliente(cliente.getId());
					DatoConstitucionDataAccess.save(datoconstitucion,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ActividadEconomica.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ActividadEconomica actividadeconomica:cliente.getActividadEconomicas()) {
					actividadeconomica.setid_cliente(cliente.getId());
					ActividadEconomicaDataAccess.save(actividadeconomica,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ProveedorProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProveedorProducto proveedorproducto:cliente.getProveedorProductos()) {
					proveedorproducto.setid_cliente(cliente.getId());
					ProveedorProductoDataAccess.save(proveedorproducto,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Consignatario.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Consignatario consignatario:cliente.getConsignatarios()) {
					consignatario.setid_cliente(cliente.getId());
					ConsignatarioDataAccess.save(consignatario,connexion);
				}
				continue;
			}

			if(clas.clas.equals(HobbyCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(HobbyCliente hobbycliente:cliente.getHobbyClientes()) {
					hobbycliente.setid_cliente(cliente.getId());
					HobbyClienteDataAccess.save(hobbycliente,connexion);
				}
				continue;
			}

			if(clas.clas.equals(RepresentanteLegal.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(RepresentanteLegal representantelegal:cliente.getRepresentanteLegals()) {
					representantelegal.setidcliente(cliente.getId());
					RepresentanteLegalDataAccess.save(representantelegal,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ClienteCoa.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ClienteCoa clientecoa:cliente.getClienteCoas()) {
					clientecoa.setid_cliente(cliente.getId());
					ClienteCoaDataAccess.save(clientecoa,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Direccion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Direccion direccion:cliente.getDireccions()) {
					direccion.setid_cliente(cliente.getId());
					DireccionDataAccess.save(direccion,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ClienteImagen.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ClienteImagen clienteimagen:cliente.getClienteImagens()) {
					clienteimagen.setid_cliente(cliente.getId());
					ClienteImagenDataAccess.save(clienteimagen,connexion);
				}
				continue;
			}

			if(clas.clas.equals(SubCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(SubCliente subcliente:cliente.getSubClientes()) {
					subcliente.setid_cliente(cliente.getId());
					SubClienteDataAccess.save(subcliente,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ServicioCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ServicioCliente serviciocliente:cliente.getServicioClientes()) {
					serviciocliente.setid_cliente(cliente.getId());
					ServicioClienteDataAccess.save(serviciocliente,connexion);
				}
				continue;
			}

			if(clas.clas.equals(InformacionEconomica.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(InformacionEconomica informacioneconomica:cliente.getInformacionEconomicas()) {
					informacioneconomica.setidcliente(cliente.getId());
					InformacionEconomicaDataAccess.save(informacioneconomica,connexion);
				}
				continue;
			}

			if(clas.clas.equals(VehiculoCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(VehiculoCliente vehiculocliente:cliente.getVehiculoClientes()) {
					vehiculocliente.setid_cliente(cliente.getId());
					VehiculoClienteDataAccess.save(vehiculocliente,connexion);
				}
				continue;
			}

			if(clas.clas.equals(NegocioCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(NegocioCliente negociocliente:cliente.getNegocioClientes()) {
					negociocliente.setid_cliente(cliente.getId());
					NegocioClienteDataAccess.save(negociocliente,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Monto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Monto monto:cliente.getMontos()) {
					monto.setid_cliente(cliente.getId());
					MontoDataAccess.save(monto,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(cliente.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cliente.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(cliente.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(cliente.getSucursal(),isDeep,deepLoadType,clases);
				

		TipoIdentificacionDataAccess.save(cliente.getTipoIdentificacion(),connexion);
		TipoIdentificacionLogic tipoidentificacionLogic= new TipoIdentificacionLogic(connexion);
		tipoidentificacionLogic.deepLoad(cliente.getTipoIdentificacion(),isDeep,deepLoadType,clases);
				

		GrupoClienteDataAccess.save(cliente.getGrupoCliente(),connexion);
		GrupoClienteLogic grupoclienteLogic= new GrupoClienteLogic(connexion);
		grupoclienteLogic.deepLoad(cliente.getGrupoCliente(),isDeep,deepLoadType,clases);
				

		TituloClienteDataAccess.save(cliente.getTituloCliente(),connexion);
		TituloClienteLogic tituloclienteLogic= new TituloClienteLogic(connexion);
		tituloclienteLogic.deepLoad(cliente.getTituloCliente(),isDeep,deepLoadType,clases);
				

		AreaCrDataAccess.save(cliente.getAreaCr(),connexion);
		AreaCrLogic areacrLogic= new AreaCrLogic(connexion);
		areacrLogic.deepLoad(cliente.getAreaCr(),isDeep,deepLoadType,clases);
				

		EstadoClienteDataAccess.save(cliente.getEstadoCliente(),connexion);
		EstadoClienteLogic estadoclienteLogic= new EstadoClienteLogic(connexion);
		estadoclienteLogic.deepLoad(cliente.getEstadoCliente(),isDeep,deepLoadType,clases);
				

		PaisDataAccess.save(cliente.getPais(),connexion);
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(cliente.getPais(),isDeep,deepLoadType,clases);
				

		RegionDataAccess.save(cliente.getRegion(),connexion);
		RegionLogic regionLogic= new RegionLogic(connexion);
		regionLogic.deepLoad(cliente.getRegion(),isDeep,deepLoadType,clases);
				

		ProvinciaDataAccess.save(cliente.getProvincia(),connexion);
		ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
		provinciaLogic.deepLoad(cliente.getProvincia(),isDeep,deepLoadType,clases);
				

		CiudadDataAccess.save(cliente.getCiudad(),connexion);
		CiudadLogic ciudadLogic= new CiudadLogic(connexion);
		ciudadLogic.deepLoad(cliente.getCiudad(),isDeep,deepLoadType,clases);
				

		ZonaDataAccess.save(cliente.getZona(),connexion);
		ZonaLogic zonaLogic= new ZonaLogic(connexion);
		zonaLogic.deepLoad(cliente.getZona(),isDeep,deepLoadType,clases);
				

		PaisDataAccess.save(cliente.getPaisNacionalidad(),connexion);
		PaisLogic paisnacionalidadLogic= new PaisLogic(connexion);
		paisnacionalidadLogic.deepLoad(cliente.getPaisNacionalidad(),isDeep,deepLoadType,clases);
				

		TipoCargoLaboDataAccess.save(cliente.getTipoCargoLabo(),connexion);
		TipoCargoLaboLogic tipocargolaboLogic= new TipoCargoLaboLogic(connexion);
		tipocargolaboLogic.deepLoad(cliente.getTipoCargoLabo(),isDeep,deepLoadType,clases);
				

		TipoNivelEduDataAccess.save(cliente.getTipoNivelEdu(),connexion);
		TipoNivelEduLogic tiponiveleduLogic= new TipoNivelEduLogic(connexion);
		tiponiveleduLogic.deepLoad(cliente.getTipoNivelEdu(),isDeep,deepLoadType,clases);
				

		ProfesionDataAccess.save(cliente.getProfesion(),connexion);
		ProfesionLogic profesionLogic= new ProfesionLogic(connexion);
		profesionLogic.deepLoad(cliente.getProfesion(),isDeep,deepLoadType,clases);
				

		TipoGeneroDataAccess.save(cliente.getTipoGenero(),connexion);
		TipoGeneroLogic tipogeneroLogic= new TipoGeneroLogic(connexion);
		tipogeneroLogic.deepLoad(cliente.getTipoGenero(),isDeep,deepLoadType,clases);
				

		EstadoCivilDataAccess.save(cliente.getEstadoCivil(),connexion);
		EstadoCivilLogic estadocivilLogic= new EstadoCivilLogic(connexion);
		estadocivilLogic.deepLoad(cliente.getEstadoCivil(),isDeep,deepLoadType,clases);
				

		EstadoLegalDataAccess.save(cliente.getEstadoLegal(),connexion);
		EstadoLegalLogic estadolegalLogic= new EstadoLegalLogic(connexion);
		estadolegalLogic.deepLoad(cliente.getEstadoLegal(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(cliente.getCuentaContable(),connexion);
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(cliente.getCuentaContable(),isDeep,deepLoadType,clases);
				

		RutaDataAccess.save(cliente.getRuta(),connexion);
		RutaLogic rutaLogic= new RutaLogic(connexion);
		rutaLogic.deepLoad(cliente.getRuta(),isDeep,deepLoadType,clases);
				

		VendedorDataAccess.save(cliente.getVendedor(),connexion);
		VendedorLogic vendedorLogic= new VendedorLogic(connexion);
		vendedorLogic.deepLoad(cliente.getVendedor(),isDeep,deepLoadType,clases);
				

		CentroActividadDataAccess.save(cliente.getCentroActividad(),connexion);
		CentroActividadLogic centroactividadLogic= new CentroActividadLogic(connexion);
		centroactividadLogic.deepLoad(cliente.getCentroActividad(),isDeep,deepLoadType,clases);
				

		TipoGarantiaEmpresaDataAccess.save(cliente.getTipoGarantiaEmpresa(),connexion);
		TipoGarantiaEmpresaLogic tipogarantiaempresaLogic= new TipoGarantiaEmpresaLogic(connexion);
		tipogarantiaempresaLogic.deepLoad(cliente.getTipoGarantiaEmpresa(),isDeep,deepLoadType,clases);
				

		CateTipoAfiliacionDataAccess.save(cliente.getCateTipoAfiliacion(),connexion);
		CateTipoAfiliacionLogic catetipoafiliacionLogic= new CateTipoAfiliacionLogic(connexion);
		catetipoafiliacionLogic.deepLoad(cliente.getCateTipoAfiliacion(),isDeep,deepLoadType,clases);
				

		DiaDataAccess.save(cliente.getDia(),connexion);
		DiaLogic diaLogic= new DiaLogic(connexion);
		diaLogic.deepLoad(cliente.getDia(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(cliente.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(cliente.getEmpleado(),isDeep,deepLoadType,clases);
				

		TipoPrecioDataAccess.save(cliente.getTipoPrecio(),connexion);
		TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
		tipoprecioLogic.deepLoad(cliente.getTipoPrecio(),isDeep,deepLoadType,clases);
				

		TipoListaPrecioDataAccess.save(cliente.getTipoListaPrecio(),connexion);
		TipoListaPrecioLogic tipolistaprecioLogic= new TipoListaPrecioLogic(connexion);
		tipolistaprecioLogic.deepLoad(cliente.getTipoListaPrecio(),isDeep,deepLoadType,clases);
				

		for(ContactoCliente contactocliente:cliente.getContactoClientes()) {
			ContactoClienteLogic contactoclienteLogic= new ContactoClienteLogic(connexion);
			contactocliente.setid_cliente(cliente.getId());
			ContactoClienteDataAccess.save(contactocliente,connexion);
			contactoclienteLogic.deepSave(contactocliente,isDeep,deepLoadType,clases);
		}

		for(Bien bien:cliente.getBiens()) {
			BienLogic bienLogic= new BienLogic(connexion);
			bien.setid_cliente(cliente.getId());
			BienDataAccess.save(bien,connexion);
			bienLogic.deepSave(bien,isDeep,deepLoadType,clases);
		}

		for(CargaFamiliar cargafamiliar:cliente.getCargaFamiliars()) {
			CargaFamiliarLogic cargafamiliarLogic= new CargaFamiliarLogic(connexion);
			cargafamiliar.setid_cliente(cliente.getId());
			CargaFamiliarDataAccess.save(cargafamiliar,connexion);
			cargafamiliarLogic.deepSave(cargafamiliar,isDeep,deepLoadType,clases);
		}

		for(ChequePostFechado chequepostfechado:cliente.getChequePostFechados()) {
			ChequePostFechadoLogic chequepostfechadoLogic= new ChequePostFechadoLogic(connexion);
			chequepostfechado.setid_cliente(cliente.getId());
			ChequePostFechadoDataAccess.save(chequepostfechado,connexion);
			chequepostfechadoLogic.deepSave(chequepostfechado,isDeep,deepLoadType,clases);
		}

		for(EMail email:cliente.getEMails()) {
			EMailLogic emailLogic= new EMailLogic(connexion);
			email.setid_cliente(cliente.getId());
			EMailDataAccess.save(email,connexion);
			emailLogic.deepSave(email,isDeep,deepLoadType,clases);
		}

		for(ReferenciaPersonal referenciapersonal:cliente.getReferenciaPersonals()) {
			ReferenciaPersonalLogic referenciapersonalLogic= new ReferenciaPersonalLogic(connexion);
			referenciapersonal.setidcliente(cliente.getId());
			ReferenciaPersonalDataAccess.save(referenciapersonal,connexion);
			referenciapersonalLogic.deepSave(referenciapersonal,isDeep,deepLoadType,clases);
		}

		for(GarantiaCliente garantiacliente:cliente.getGarantiaClientes()) {
			GarantiaClienteLogic garantiaclienteLogic= new GarantiaClienteLogic(connexion);
			garantiacliente.setid_cliente(cliente.getId());
			GarantiaClienteDataAccess.save(garantiacliente,connexion);
			garantiaclienteLogic.deepSave(garantiacliente,isDeep,deepLoadType,clases);
		}

		for(ClienteArchivo clientearchivo:cliente.getClienteArchivos()) {
			ClienteArchivoLogic clientearchivoLogic= new ClienteArchivoLogic(connexion);
			clientearchivo.setid_cliente(cliente.getId());
			ClienteArchivoDataAccess.save(clientearchivo,connexion);
			clientearchivoLogic.deepSave(clientearchivo,isDeep,deepLoadType,clases);
		}
					PoliticasClienteLogic politicasclienteLogic= new PoliticasClienteLogic(connexion);

				cliente.getPoliticasCliente().setId(cliente.getId());
					PoliticasClienteDataAccess.save(cliente.getPoliticasCliente(),connexion);
					politicasclienteLogic.deepSave(cliente.getPoliticasCliente(),isDeep,deepLoadType,clases);

		for(FirmaCliente firmacliente:cliente.getFirmaClientes()) {
			FirmaClienteLogic firmaclienteLogic= new FirmaClienteLogic(connexion);
			firmacliente.setid_cliente(cliente.getId());
			FirmaClienteDataAccess.save(firmacliente,connexion);
			firmaclienteLogic.deepSave(firmacliente,isDeep,deepLoadType,clases);
		}

		for(ReferenciaComercial referenciacomercial:cliente.getReferenciaComercials()) {
			ReferenciaComercialLogic referenciacomercialLogic= new ReferenciaComercialLogic(connexion);
			referenciacomercial.setidcliente(cliente.getId());
			ReferenciaComercialDataAccess.save(referenciacomercial,connexion);
			referenciacomercialLogic.deepSave(referenciacomercial,isDeep,deepLoadType,clases);
		}

		for(Novedad novedad:cliente.getNovedads()) {
			NovedadLogic novedadLogic= new NovedadLogic(connexion);
			novedad.setid_cliente(cliente.getId());
			NovedadDataAccess.save(novedad,connexion);
			novedadLogic.deepSave(novedad,isDeep,deepLoadType,clases);
		}

		for(InformacionLaboral informacionlaboral:cliente.getInformacionLaborals()) {
			InformacionLaboralLogic informacionlaboralLogic= new InformacionLaboralLogic(connexion);
			informacionlaboral.setidcliente(cliente.getId());
			InformacionLaboralDataAccess.save(informacionlaboral,connexion);
			informacionlaboralLogic.deepSave(informacionlaboral,isDeep,deepLoadType,clases);
		}

		for(InformacionFinanciera informacionfinanciera:cliente.getInformacionFinancieras()) {
			InformacionFinancieraLogic informacionfinancieraLogic= new InformacionFinancieraLogic(connexion);
			informacionfinanciera.setidcliente(cliente.getId());
			InformacionFinancieraDataAccess.save(informacionfinanciera,connexion);
			informacionfinancieraLogic.deepSave(informacionfinanciera,isDeep,deepLoadType,clases);
		}

		for(Telefono telefono:cliente.getTelefonos()) {
			TelefonoLogic telefonoLogic= new TelefonoLogic(connexion);
			telefono.setid_cliente(cliente.getId());
			TelefonoDataAccess.save(telefono,connexion);
			telefonoLogic.deepSave(telefono,isDeep,deepLoadType,clases);
		}

		for(CuentaPorCobrar cuentaporcobrar:cliente.getCuentaPorCobrars()) {
			CuentaPorCobrarLogic cuentaporcobrarLogic= new CuentaPorCobrarLogic(connexion);
			cuentaporcobrar.setid_cliente(cliente.getId());
			CuentaPorCobrarDataAccess.save(cuentaporcobrar,connexion);
			cuentaporcobrarLogic.deepSave(cuentaporcobrar,isDeep,deepLoadType,clases);
		}

		for(Responsable responsable:cliente.getResponsables()) {
			ResponsableLogic responsableLogic= new ResponsableLogic(connexion);
			responsable.setid_cliente(cliente.getId());
			ResponsableDataAccess.save(responsable,connexion);
			responsableLogic.deepSave(responsable,isDeep,deepLoadType,clases);
		}

		for(Transportista transportista:cliente.getTransportistas()) {
			TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
			transportista.setid_cliente(cliente.getId());
			TransportistaDataAccess.save(transportista,connexion);
			transportistaLogic.deepSave(transportista,isDeep,deepLoadType,clases);
		}

		for(PoliticaCliente politicacliente:cliente.getPoliticaClientes()) {
			PoliticaClienteLogic politicaclienteLogic= new PoliticaClienteLogic(connexion);
			politicacliente.setid_cliente(cliente.getId());
			PoliticaClienteDataAccess.save(politicacliente,connexion);
			politicaclienteLogic.deepSave(politicacliente,isDeep,deepLoadType,clases);
		}
					ConyugeLogic conyugeLogic= new ConyugeLogic(connexion);

				cliente.getConyuge().setId(cliente.getId());
					ConyugeDataAccess.save(cliente.getConyuge(),connexion);
					conyugeLogic.deepSave(cliente.getConyuge(),isDeep,deepLoadType,clases);

		for(ReferenciaBancaria referenciabancaria:cliente.getReferenciaBancarias()) {
			ReferenciaBancariaLogic referenciabancariaLogic= new ReferenciaBancariaLogic(connexion);
			referenciabancaria.setidcliente(cliente.getId());
			ReferenciaBancariaDataAccess.save(referenciabancaria,connexion);
			referenciabancariaLogic.deepSave(referenciabancaria,isDeep,deepLoadType,clases);
		}

		for(BalanceGeneralCliente balancegeneralcliente:cliente.getBalanceGeneralClientes()) {
			BalanceGeneralClienteLogic balancegeneralclienteLogic= new BalanceGeneralClienteLogic(connexion);
			balancegeneralcliente.setid_cliente(cliente.getId());
			BalanceGeneralClienteDataAccess.save(balancegeneralcliente,connexion);
			balancegeneralclienteLogic.deepSave(balancegeneralcliente,isDeep,deepLoadType,clases);
		}

		for(DatoConstitucion datoconstitucion:cliente.getDatoConstitucions()) {
			DatoConstitucionLogic datoconstitucionLogic= new DatoConstitucionLogic(connexion);
			datoconstitucion.setidcliente(cliente.getId());
			DatoConstitucionDataAccess.save(datoconstitucion,connexion);
			datoconstitucionLogic.deepSave(datoconstitucion,isDeep,deepLoadType,clases);
		}

		for(ActividadEconomica actividadeconomica:cliente.getActividadEconomicas()) {
			ActividadEconomicaLogic actividadeconomicaLogic= new ActividadEconomicaLogic(connexion);
			actividadeconomica.setid_cliente(cliente.getId());
			ActividadEconomicaDataAccess.save(actividadeconomica,connexion);
			actividadeconomicaLogic.deepSave(actividadeconomica,isDeep,deepLoadType,clases);
		}

		for(ProveedorProducto proveedorproducto:cliente.getProveedorProductos()) {
			ProveedorProductoLogic proveedorproductoLogic= new ProveedorProductoLogic(connexion);
			proveedorproducto.setid_cliente(cliente.getId());
			ProveedorProductoDataAccess.save(proveedorproducto,connexion);
			proveedorproductoLogic.deepSave(proveedorproducto,isDeep,deepLoadType,clases);
		}

		for(Consignatario consignatario:cliente.getConsignatarios()) {
			ConsignatarioLogic consignatarioLogic= new ConsignatarioLogic(connexion);
			consignatario.setid_cliente(cliente.getId());
			ConsignatarioDataAccess.save(consignatario,connexion);
			consignatarioLogic.deepSave(consignatario,isDeep,deepLoadType,clases);
		}

		for(HobbyCliente hobbycliente:cliente.getHobbyClientes()) {
			HobbyClienteLogic hobbyclienteLogic= new HobbyClienteLogic(connexion);
			hobbycliente.setid_cliente(cliente.getId());
			HobbyClienteDataAccess.save(hobbycliente,connexion);
			hobbyclienteLogic.deepSave(hobbycliente,isDeep,deepLoadType,clases);
		}

		for(RepresentanteLegal representantelegal:cliente.getRepresentanteLegals()) {
			RepresentanteLegalLogic representantelegalLogic= new RepresentanteLegalLogic(connexion);
			representantelegal.setidcliente(cliente.getId());
			RepresentanteLegalDataAccess.save(representantelegal,connexion);
			representantelegalLogic.deepSave(representantelegal,isDeep,deepLoadType,clases);
		}

		for(ClienteCoa clientecoa:cliente.getClienteCoas()) {
			ClienteCoaLogic clientecoaLogic= new ClienteCoaLogic(connexion);
			clientecoa.setid_cliente(cliente.getId());
			ClienteCoaDataAccess.save(clientecoa,connexion);
			clientecoaLogic.deepSave(clientecoa,isDeep,deepLoadType,clases);
		}

		for(Direccion direccion:cliente.getDireccions()) {
			DireccionLogic direccionLogic= new DireccionLogic(connexion);
			direccion.setid_cliente(cliente.getId());
			DireccionDataAccess.save(direccion,connexion);
			direccionLogic.deepSave(direccion,isDeep,deepLoadType,clases);
		}

		for(ClienteImagen clienteimagen:cliente.getClienteImagens()) {
			ClienteImagenLogic clienteimagenLogic= new ClienteImagenLogic(connexion);
			clienteimagen.setid_cliente(cliente.getId());
			ClienteImagenDataAccess.save(clienteimagen,connexion);
			clienteimagenLogic.deepSave(clienteimagen,isDeep,deepLoadType,clases);
		}

		for(SubCliente subcliente:cliente.getSubClientes()) {
			SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
			subcliente.setid_cliente(cliente.getId());
			SubClienteDataAccess.save(subcliente,connexion);
			subclienteLogic.deepSave(subcliente,isDeep,deepLoadType,clases);
		}

		for(ServicioCliente serviciocliente:cliente.getServicioClientes()) {
			ServicioClienteLogic servicioclienteLogic= new ServicioClienteLogic(connexion);
			serviciocliente.setid_cliente(cliente.getId());
			ServicioClienteDataAccess.save(serviciocliente,connexion);
			servicioclienteLogic.deepSave(serviciocliente,isDeep,deepLoadType,clases);
		}

		for(InformacionEconomica informacioneconomica:cliente.getInformacionEconomicas()) {
			InformacionEconomicaLogic informacioneconomicaLogic= new InformacionEconomicaLogic(connexion);
			informacioneconomica.setidcliente(cliente.getId());
			InformacionEconomicaDataAccess.save(informacioneconomica,connexion);
			informacioneconomicaLogic.deepSave(informacioneconomica,isDeep,deepLoadType,clases);
		}

		for(VehiculoCliente vehiculocliente:cliente.getVehiculoClientes()) {
			VehiculoClienteLogic vehiculoclienteLogic= new VehiculoClienteLogic(connexion);
			vehiculocliente.setid_cliente(cliente.getId());
			VehiculoClienteDataAccess.save(vehiculocliente,connexion);
			vehiculoclienteLogic.deepSave(vehiculocliente,isDeep,deepLoadType,clases);
		}

		for(NegocioCliente negociocliente:cliente.getNegocioClientes()) {
			NegocioClienteLogic negocioclienteLogic= new NegocioClienteLogic(connexion);
			negociocliente.setid_cliente(cliente.getId());
			NegocioClienteDataAccess.save(negociocliente,connexion);
			negocioclienteLogic.deepSave(negociocliente,isDeep,deepLoadType,clases);
		}

		for(Monto monto:cliente.getMontos()) {
			MontoLogic montoLogic= new MontoLogic(connexion);
			monto.setid_cliente(cliente.getId());
			MontoDataAccess.save(monto,connexion);
			montoLogic.deepSave(monto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cliente.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(cliente.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(cliente.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(cliente.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoIdentificacion.class)) {
				TipoIdentificacionDataAccess.save(cliente.getTipoIdentificacion(),connexion);
				TipoIdentificacionLogic tipoidentificacionLogic= new TipoIdentificacionLogic(connexion);
				tipoidentificacionLogic.deepSave(cliente.getTipoIdentificacion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(GrupoCliente.class)) {
				GrupoClienteDataAccess.save(cliente.getGrupoCliente(),connexion);
				GrupoClienteLogic grupoclienteLogic= new GrupoClienteLogic(connexion);
				grupoclienteLogic.deepSave(cliente.getGrupoCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TituloCliente.class)) {
				TituloClienteDataAccess.save(cliente.getTituloCliente(),connexion);
				TituloClienteLogic tituloclienteLogic= new TituloClienteLogic(connexion);
				tituloclienteLogic.deepSave(cliente.getTituloCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AreaCr.class)) {
				AreaCrDataAccess.save(cliente.getAreaCr(),connexion);
				AreaCrLogic areacrLogic= new AreaCrLogic(connexion);
				areacrLogic.deepSave(cliente.getAreaCr(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoCliente.class)) {
				EstadoClienteDataAccess.save(cliente.getEstadoCliente(),connexion);
				EstadoClienteLogic estadoclienteLogic= new EstadoClienteLogic(connexion);
				estadoclienteLogic.deepSave(cliente.getEstadoCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(cliente.getPais(),connexion);
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepSave(cliente.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Region.class)) {
				RegionDataAccess.save(cliente.getRegion(),connexion);
				RegionLogic regionLogic= new RegionLogic(connexion);
				regionLogic.deepSave(cliente.getRegion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Provincia.class)) {
				ProvinciaDataAccess.save(cliente.getProvincia(),connexion);
				ProvinciaLogic provinciaLogic= new ProvinciaLogic(connexion);
				provinciaLogic.deepSave(cliente.getProvincia(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ciudad.class)) {
				CiudadDataAccess.save(cliente.getCiudad(),connexion);
				CiudadLogic ciudadLogic= new CiudadLogic(connexion);
				ciudadLogic.deepSave(cliente.getCiudad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Zona.class)) {
				ZonaDataAccess.save(cliente.getZona(),connexion);
				ZonaLogic zonaLogic= new ZonaLogic(connexion);
				zonaLogic.deepSave(cliente.getZona(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(cliente.getPaisNacionalidad(),connexion);
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepSave(cliente.getPaisNacionalidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCargoLabo.class)) {
				TipoCargoLaboDataAccess.save(cliente.getTipoCargoLabo(),connexion);
				TipoCargoLaboLogic tipocargolaboLogic= new TipoCargoLaboLogic(connexion);
				tipocargolaboLogic.deepSave(cliente.getTipoCargoLabo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoNivelEdu.class)) {
				TipoNivelEduDataAccess.save(cliente.getTipoNivelEdu(),connexion);
				TipoNivelEduLogic tiponiveleduLogic= new TipoNivelEduLogic(connexion);
				tiponiveleduLogic.deepSave(cliente.getTipoNivelEdu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Profesion.class)) {
				ProfesionDataAccess.save(cliente.getProfesion(),connexion);
				ProfesionLogic profesionLogic= new ProfesionLogic(connexion);
				profesionLogic.deepSave(cliente.getProfesion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoGenero.class)) {
				TipoGeneroDataAccess.save(cliente.getTipoGenero(),connexion);
				TipoGeneroLogic tipogeneroLogic= new TipoGeneroLogic(connexion);
				tipogeneroLogic.deepSave(cliente.getTipoGenero(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoCivil.class)) {
				EstadoCivilDataAccess.save(cliente.getEstadoCivil(),connexion);
				EstadoCivilLogic estadocivilLogic= new EstadoCivilLogic(connexion);
				estadocivilLogic.deepSave(cliente.getEstadoCivil(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoLegal.class)) {
				EstadoLegalDataAccess.save(cliente.getEstadoLegal(),connexion);
				EstadoLegalLogic estadolegalLogic= new EstadoLegalLogic(connexion);
				estadolegalLogic.deepSave(cliente.getEstadoLegal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cliente.getCuentaContable(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(cliente.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ruta.class)) {
				RutaDataAccess.save(cliente.getRuta(),connexion);
				RutaLogic rutaLogic= new RutaLogic(connexion);
				rutaLogic.deepSave(cliente.getRuta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vendedor.class)) {
				VendedorDataAccess.save(cliente.getVendedor(),connexion);
				VendedorLogic vendedorLogic= new VendedorLogic(connexion);
				vendedorLogic.deepSave(cliente.getVendedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroActividad.class)) {
				CentroActividadDataAccess.save(cliente.getCentroActividad(),connexion);
				CentroActividadLogic centroactividadLogic= new CentroActividadLogic(connexion);
				centroactividadLogic.deepSave(cliente.getCentroActividad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoGarantiaEmpresa.class)) {
				TipoGarantiaEmpresaDataAccess.save(cliente.getTipoGarantiaEmpresa(),connexion);
				TipoGarantiaEmpresaLogic tipogarantiaempresaLogic= new TipoGarantiaEmpresaLogic(connexion);
				tipogarantiaempresaLogic.deepSave(cliente.getTipoGarantiaEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CateTipoAfiliacion.class)) {
				CateTipoAfiliacionDataAccess.save(cliente.getCateTipoAfiliacion(),connexion);
				CateTipoAfiliacionLogic catetipoafiliacionLogic= new CateTipoAfiliacionLogic(connexion);
				catetipoafiliacionLogic.deepSave(cliente.getCateTipoAfiliacion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Dia.class)) {
				DiaDataAccess.save(cliente.getDia(),connexion);
				DiaLogic diaLogic= new DiaLogic(connexion);
				diaLogic.deepSave(cliente.getDia(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(cliente.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(cliente.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				TipoPrecioDataAccess.save(cliente.getTipoPrecio(),connexion);
				TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
				tipoprecioLogic.deepSave(cliente.getTipoPrecio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoListaPrecio.class)) {
				TipoListaPrecioDataAccess.save(cliente.getTipoListaPrecio(),connexion);
				TipoListaPrecioLogic tipolistaprecioLogic= new TipoListaPrecioLogic(connexion);
				tipolistaprecioLogic.deepSave(cliente.getTipoListaPrecio(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(ContactoCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ContactoCliente contactocliente:cliente.getContactoClientes()) {
					ContactoClienteLogic contactoclienteLogic= new ContactoClienteLogic(connexion);
					contactocliente.setid_cliente(cliente.getId());
					ContactoClienteDataAccess.save(contactocliente,connexion);
					contactoclienteLogic.deepSave(contactocliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Bien.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Bien bien:cliente.getBiens()) {
					BienLogic bienLogic= new BienLogic(connexion);
					bien.setid_cliente(cliente.getId());
					BienDataAccess.save(bien,connexion);
					bienLogic.deepSave(bien,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CargaFamiliar.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CargaFamiliar cargafamiliar:cliente.getCargaFamiliars()) {
					CargaFamiliarLogic cargafamiliarLogic= new CargaFamiliarLogic(connexion);
					cargafamiliar.setid_cliente(cliente.getId());
					CargaFamiliarDataAccess.save(cargafamiliar,connexion);
					cargafamiliarLogic.deepSave(cargafamiliar,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ChequePostFechado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ChequePostFechado chequepostfechado:cliente.getChequePostFechados()) {
					ChequePostFechadoLogic chequepostfechadoLogic= new ChequePostFechadoLogic(connexion);
					chequepostfechado.setid_cliente(cliente.getId());
					ChequePostFechadoDataAccess.save(chequepostfechado,connexion);
					chequepostfechadoLogic.deepSave(chequepostfechado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(EMail.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EMail email:cliente.getEMails()) {
					EMailLogic emailLogic= new EMailLogic(connexion);
					email.setid_cliente(cliente.getId());
					EMailDataAccess.save(email,connexion);
					emailLogic.deepSave(email,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ReferenciaPersonal.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ReferenciaPersonal referenciapersonal:cliente.getReferenciaPersonals()) {
					ReferenciaPersonalLogic referenciapersonalLogic= new ReferenciaPersonalLogic(connexion);
					referenciapersonal.setidcliente(cliente.getId());
					ReferenciaPersonalDataAccess.save(referenciapersonal,connexion);
					referenciapersonalLogic.deepSave(referenciapersonal,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(GarantiaCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(GarantiaCliente garantiacliente:cliente.getGarantiaClientes()) {
					GarantiaClienteLogic garantiaclienteLogic= new GarantiaClienteLogic(connexion);
					garantiacliente.setid_cliente(cliente.getId());
					GarantiaClienteDataAccess.save(garantiacliente,connexion);
					garantiaclienteLogic.deepSave(garantiacliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ClienteArchivo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ClienteArchivo clientearchivo:cliente.getClienteArchivos()) {
					ClienteArchivoLogic clientearchivoLogic= new ClienteArchivoLogic(connexion);
					clientearchivo.setid_cliente(cliente.getId());
					ClienteArchivoDataAccess.save(clientearchivo,connexion);
					clientearchivoLogic.deepSave(clientearchivo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PoliticasCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
					PoliticasClienteLogic politicasclienteLogic= new PoliticasClienteLogic(connexion);

				cliente.getPoliticasCliente().setId(cliente.getId());
					PoliticasClienteDataAccess.save(cliente.getPoliticasCliente(),connexion);
					politicasclienteLogic.deepSave(cliente.getPoliticasCliente(),isDeep,deepLoadType,clases);
				continue;
			}

			if(clas.clas.equals(FirmaCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FirmaCliente firmacliente:cliente.getFirmaClientes()) {
					FirmaClienteLogic firmaclienteLogic= new FirmaClienteLogic(connexion);
					firmacliente.setid_cliente(cliente.getId());
					FirmaClienteDataAccess.save(firmacliente,connexion);
					firmaclienteLogic.deepSave(firmacliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ReferenciaComercial.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ReferenciaComercial referenciacomercial:cliente.getReferenciaComercials()) {
					ReferenciaComercialLogic referenciacomercialLogic= new ReferenciaComercialLogic(connexion);
					referenciacomercial.setidcliente(cliente.getId());
					ReferenciaComercialDataAccess.save(referenciacomercial,connexion);
					referenciacomercialLogic.deepSave(referenciacomercial,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Novedad.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Novedad novedad:cliente.getNovedads()) {
					NovedadLogic novedadLogic= new NovedadLogic(connexion);
					novedad.setid_cliente(cliente.getId());
					NovedadDataAccess.save(novedad,connexion);
					novedadLogic.deepSave(novedad,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(InformacionLaboral.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(InformacionLaboral informacionlaboral:cliente.getInformacionLaborals()) {
					InformacionLaboralLogic informacionlaboralLogic= new InformacionLaboralLogic(connexion);
					informacionlaboral.setidcliente(cliente.getId());
					InformacionLaboralDataAccess.save(informacionlaboral,connexion);
					informacionlaboralLogic.deepSave(informacionlaboral,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(InformacionFinanciera.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(InformacionFinanciera informacionfinanciera:cliente.getInformacionFinancieras()) {
					InformacionFinancieraLogic informacionfinancieraLogic= new InformacionFinancieraLogic(connexion);
					informacionfinanciera.setidcliente(cliente.getId());
					InformacionFinancieraDataAccess.save(informacionfinanciera,connexion);
					informacionfinancieraLogic.deepSave(informacionfinanciera,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Telefono.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Telefono telefono:cliente.getTelefonos()) {
					TelefonoLogic telefonoLogic= new TelefonoLogic(connexion);
					telefono.setid_cliente(cliente.getId());
					TelefonoDataAccess.save(telefono,connexion);
					telefonoLogic.deepSave(telefono,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CuentaPorCobrar.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CuentaPorCobrar cuentaporcobrar:cliente.getCuentaPorCobrars()) {
					CuentaPorCobrarLogic cuentaporcobrarLogic= new CuentaPorCobrarLogic(connexion);
					cuentaporcobrar.setid_cliente(cliente.getId());
					CuentaPorCobrarDataAccess.save(cuentaporcobrar,connexion);
					cuentaporcobrarLogic.deepSave(cuentaporcobrar,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Responsable.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Responsable responsable:cliente.getResponsables()) {
					ResponsableLogic responsableLogic= new ResponsableLogic(connexion);
					responsable.setid_cliente(cliente.getId());
					ResponsableDataAccess.save(responsable,connexion);
					responsableLogic.deepSave(responsable,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Transportista.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Transportista transportista:cliente.getTransportistas()) {
					TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
					transportista.setid_cliente(cliente.getId());
					TransportistaDataAccess.save(transportista,connexion);
					transportistaLogic.deepSave(transportista,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PoliticaCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PoliticaCliente politicacliente:cliente.getPoliticaClientes()) {
					PoliticaClienteLogic politicaclienteLogic= new PoliticaClienteLogic(connexion);
					politicacliente.setid_cliente(cliente.getId());
					PoliticaClienteDataAccess.save(politicacliente,connexion);
					politicaclienteLogic.deepSave(politicacliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Conyuge.class)&&clas.blnActivo) {
				clas.blnActivo=false;
					ConyugeLogic conyugeLogic= new ConyugeLogic(connexion);

				cliente.getConyuge().setId(cliente.getId());
					ConyugeDataAccess.save(cliente.getConyuge(),connexion);
					conyugeLogic.deepSave(cliente.getConyuge(),isDeep,deepLoadType,clases);
				continue;
			}

			if(clas.clas.equals(ReferenciaBancaria.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ReferenciaBancaria referenciabancaria:cliente.getReferenciaBancarias()) {
					ReferenciaBancariaLogic referenciabancariaLogic= new ReferenciaBancariaLogic(connexion);
					referenciabancaria.setidcliente(cliente.getId());
					ReferenciaBancariaDataAccess.save(referenciabancaria,connexion);
					referenciabancariaLogic.deepSave(referenciabancaria,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(BalanceGeneralCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(BalanceGeneralCliente balancegeneralcliente:cliente.getBalanceGeneralClientes()) {
					BalanceGeneralClienteLogic balancegeneralclienteLogic= new BalanceGeneralClienteLogic(connexion);
					balancegeneralcliente.setid_cliente(cliente.getId());
					BalanceGeneralClienteDataAccess.save(balancegeneralcliente,connexion);
					balancegeneralclienteLogic.deepSave(balancegeneralcliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DatoConstitucion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DatoConstitucion datoconstitucion:cliente.getDatoConstitucions()) {
					DatoConstitucionLogic datoconstitucionLogic= new DatoConstitucionLogic(connexion);
					datoconstitucion.setidcliente(cliente.getId());
					DatoConstitucionDataAccess.save(datoconstitucion,connexion);
					datoconstitucionLogic.deepSave(datoconstitucion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ActividadEconomica.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ActividadEconomica actividadeconomica:cliente.getActividadEconomicas()) {
					ActividadEconomicaLogic actividadeconomicaLogic= new ActividadEconomicaLogic(connexion);
					actividadeconomica.setid_cliente(cliente.getId());
					ActividadEconomicaDataAccess.save(actividadeconomica,connexion);
					actividadeconomicaLogic.deepSave(actividadeconomica,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ProveedorProducto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProveedorProducto proveedorproducto:cliente.getProveedorProductos()) {
					ProveedorProductoLogic proveedorproductoLogic= new ProveedorProductoLogic(connexion);
					proveedorproducto.setid_cliente(cliente.getId());
					ProveedorProductoDataAccess.save(proveedorproducto,connexion);
					proveedorproductoLogic.deepSave(proveedorproducto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Consignatario.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Consignatario consignatario:cliente.getConsignatarios()) {
					ConsignatarioLogic consignatarioLogic= new ConsignatarioLogic(connexion);
					consignatario.setid_cliente(cliente.getId());
					ConsignatarioDataAccess.save(consignatario,connexion);
					consignatarioLogic.deepSave(consignatario,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(HobbyCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(HobbyCliente hobbycliente:cliente.getHobbyClientes()) {
					HobbyClienteLogic hobbyclienteLogic= new HobbyClienteLogic(connexion);
					hobbycliente.setid_cliente(cliente.getId());
					HobbyClienteDataAccess.save(hobbycliente,connexion);
					hobbyclienteLogic.deepSave(hobbycliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(RepresentanteLegal.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(RepresentanteLegal representantelegal:cliente.getRepresentanteLegals()) {
					RepresentanteLegalLogic representantelegalLogic= new RepresentanteLegalLogic(connexion);
					representantelegal.setidcliente(cliente.getId());
					RepresentanteLegalDataAccess.save(representantelegal,connexion);
					representantelegalLogic.deepSave(representantelegal,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ClienteCoa.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ClienteCoa clientecoa:cliente.getClienteCoas()) {
					ClienteCoaLogic clientecoaLogic= new ClienteCoaLogic(connexion);
					clientecoa.setid_cliente(cliente.getId());
					ClienteCoaDataAccess.save(clientecoa,connexion);
					clientecoaLogic.deepSave(clientecoa,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Direccion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Direccion direccion:cliente.getDireccions()) {
					DireccionLogic direccionLogic= new DireccionLogic(connexion);
					direccion.setid_cliente(cliente.getId());
					DireccionDataAccess.save(direccion,connexion);
					direccionLogic.deepSave(direccion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ClienteImagen.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ClienteImagen clienteimagen:cliente.getClienteImagens()) {
					ClienteImagenLogic clienteimagenLogic= new ClienteImagenLogic(connexion);
					clienteimagen.setid_cliente(cliente.getId());
					ClienteImagenDataAccess.save(clienteimagen,connexion);
					clienteimagenLogic.deepSave(clienteimagen,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(SubCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(SubCliente subcliente:cliente.getSubClientes()) {
					SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
					subcliente.setid_cliente(cliente.getId());
					SubClienteDataAccess.save(subcliente,connexion);
					subclienteLogic.deepSave(subcliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ServicioCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ServicioCliente serviciocliente:cliente.getServicioClientes()) {
					ServicioClienteLogic servicioclienteLogic= new ServicioClienteLogic(connexion);
					serviciocliente.setid_cliente(cliente.getId());
					ServicioClienteDataAccess.save(serviciocliente,connexion);
					servicioclienteLogic.deepSave(serviciocliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(InformacionEconomica.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(InformacionEconomica informacioneconomica:cliente.getInformacionEconomicas()) {
					InformacionEconomicaLogic informacioneconomicaLogic= new InformacionEconomicaLogic(connexion);
					informacioneconomica.setidcliente(cliente.getId());
					InformacionEconomicaDataAccess.save(informacioneconomica,connexion);
					informacioneconomicaLogic.deepSave(informacioneconomica,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(VehiculoCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(VehiculoCliente vehiculocliente:cliente.getVehiculoClientes()) {
					VehiculoClienteLogic vehiculoclienteLogic= new VehiculoClienteLogic(connexion);
					vehiculocliente.setid_cliente(cliente.getId());
					VehiculoClienteDataAccess.save(vehiculocliente,connexion);
					vehiculoclienteLogic.deepSave(vehiculocliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(NegocioCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(NegocioCliente negociocliente:cliente.getNegocioClientes()) {
					NegocioClienteLogic negocioclienteLogic= new NegocioClienteLogic(connexion);
					negociocliente.setid_cliente(cliente.getId());
					NegocioClienteDataAccess.save(negociocliente,connexion);
					negocioclienteLogic.deepSave(negociocliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Monto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Monto monto:cliente.getMontos()) {
					MontoLogic montoLogic= new MontoLogic(connexion);
					monto.setid_cliente(cliente.getId());
					MontoDataAccess.save(monto,connexion);
					montoLogic.deepSave(monto,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Cliente.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(cliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(cliente);
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
			this.deepLoad(this.cliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.cliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Cliente.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(clientes!=null) {
				for(Cliente cliente:clientes) {
					this.deepLoad(cliente,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(clientes);
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
			if(clientes!=null) {
				for(Cliente cliente:clientes) {
					this.deepLoad(cliente,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(clientes);
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
			this.getNewConnexionToDeep(Cliente.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(cliente,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Cliente.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(clientes!=null) {
				for(Cliente cliente:clientes) {
					this.deepSave(cliente,isDeep,deepLoadType,clases);
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
			if(clientes!=null) {
				for(Cliente cliente:clientes) {
					this.deepSave(cliente,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getClientesBusquedaPorIdentificacionWithConnection(String sFinalQuery,Pagination pagination,String identificacion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralIdentificacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralIdentificacion.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+identificacion+"%",ClienteConstantesFunciones.IDENTIFICACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralIdentificacion);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdentificacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClientesBusquedaPorIdentificacion(String sFinalQuery,Pagination pagination,String identificacion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralIdentificacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralIdentificacion.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+identificacion+"%",ClienteConstantesFunciones.IDENTIFICACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralIdentificacion);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdentificacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClientesBusquedaPorNombreComercialWithConnection(String sFinalQuery,Pagination pagination,String nombre_comercial)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombreComercial= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombreComercial.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre_comercial+"%",ClienteConstantesFunciones.NOMBRECOMERCIAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombreComercial);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombreComercial","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClientesBusquedaPorNombreComercial(String sFinalQuery,Pagination pagination,String nombre_comercial)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombreComercial= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombreComercial.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre_comercial+"%",ClienteConstantesFunciones.NOMBRECOMERCIAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombreComercial);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombreComercial","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClientesBusquedaPorNombreCompletoWithConnection(String sFinalQuery,Pagination pagination,String nombre_completo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombreCompleto= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombreCompleto.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre_completo+"%",ClienteConstantesFunciones.NOMBRECOMPLETO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombreCompleto);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombreCompleto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClientesBusquedaPorNombreCompleto(String sFinalQuery,Pagination pagination,String nombre_completo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombreCompleto= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombreCompleto.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre_completo+"%",ClienteConstantesFunciones.NOMBRECOMPLETO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombreCompleto);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombreCompleto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClientesFK_IdAreaCrWithConnection(String sFinalQuery,Pagination pagination,Long id_area_cr)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAreaCr= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAreaCr.setParameterSelectionGeneralEqual(ParameterType.LONG,id_area_cr,ClienteConstantesFunciones.IDAREACR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAreaCr);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAreaCr","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClientesFK_IdAreaCr(String sFinalQuery,Pagination pagination,Long id_area_cr)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAreaCr= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAreaCr.setParameterSelectionGeneralEqual(ParameterType.LONG,id_area_cr,ClienteConstantesFunciones.IDAREACR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAreaCr);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAreaCr","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClientesFK_IdCateTipoAfiliacionWithConnection(String sFinalQuery,Pagination pagination,Long id_cate_tipo_afiliacion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCateTipoAfiliacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCateTipoAfiliacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cate_tipo_afiliacion,ClienteConstantesFunciones.IDCATETIPOAFILIACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCateTipoAfiliacion);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCateTipoAfiliacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClientesFK_IdCateTipoAfiliacion(String sFinalQuery,Pagination pagination,Long id_cate_tipo_afiliacion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCateTipoAfiliacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCateTipoAfiliacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cate_tipo_afiliacion,ClienteConstantesFunciones.IDCATETIPOAFILIACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCateTipoAfiliacion);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCateTipoAfiliacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClientesFK_IdCentroActividadWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_actividad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroActividad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroActividad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_actividad,ClienteConstantesFunciones.IDCENTROACTIVIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroActividad);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroActividad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClientesFK_IdCentroActividad(String sFinalQuery,Pagination pagination,Long id_centro_actividad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroActividad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroActividad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_actividad,ClienteConstantesFunciones.IDCENTROACTIVIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroActividad);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroActividad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClientesFK_IdCiudadWithConnection(String sFinalQuery,Pagination pagination,Long id_ciudad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad,ClienteConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClientesFK_IdCiudad(String sFinalQuery,Pagination pagination,Long id_ciudad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCiudad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCiudad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ciudad,ClienteConstantesFunciones.IDCIUDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCiudad);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCiudad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClientesFK_IdCuentaContableWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,ClienteConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClientesFK_IdCuentaContable(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,ClienteConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClientesFK_IdDiaWithConnection(String sFinalQuery,Pagination pagination,Long id_dia)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_dia,ClienteConstantesFunciones.IDDIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDia);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClientesFK_IdDia(String sFinalQuery,Pagination pagination,Long id_dia)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_dia,ClienteConstantesFunciones.IDDIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDia);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClientesFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,ClienteConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClientesFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,ClienteConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClientesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ClienteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClientesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ClienteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClientesFK_IdEstadoCivilWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_civil)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoCivil= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoCivil.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_civil,ClienteConstantesFunciones.IDESTADOCIVIL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoCivil);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoCivil","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClientesFK_IdEstadoCivil(String sFinalQuery,Pagination pagination,Long id_estado_civil)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoCivil= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoCivil.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_civil,ClienteConstantesFunciones.IDESTADOCIVIL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoCivil);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoCivil","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClientesFK_IdEstadoClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_cliente,ClienteConstantesFunciones.IDESTADOCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoCliente);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClientesFK_IdEstadoCliente(String sFinalQuery,Pagination pagination,Long id_estado_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_cliente,ClienteConstantesFunciones.IDESTADOCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoCliente);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClientesFK_IdEstadoLegalWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_legal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoLegal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoLegal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_legal,ClienteConstantesFunciones.IDESTADOLEGAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoLegal);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoLegal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClientesFK_IdEstadoLegal(String sFinalQuery,Pagination pagination,Long id_estado_legal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoLegal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoLegal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_legal,ClienteConstantesFunciones.IDESTADOLEGAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoLegal);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoLegal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClientesFK_IdGrupoClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_grupo_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidGrupoCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidGrupoCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_grupo_cliente,ClienteConstantesFunciones.IDGRUPOCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidGrupoCliente);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdGrupoCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClientesFK_IdGrupoCliente(String sFinalQuery,Pagination pagination,Long id_grupo_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidGrupoCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidGrupoCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_grupo_cliente,ClienteConstantesFunciones.IDGRUPOCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidGrupoCliente);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdGrupoCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClientesFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,ClienteConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClientesFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,ClienteConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClientesFK_IdPaisNacionaladWithConnection(String sFinalQuery,Pagination pagination,Long id_pais_nacionalidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPaisNacionalidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPaisNacionalidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais_nacionalidad,ClienteConstantesFunciones.IDPAISNACIONALIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPaisNacionalidad);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPaisNacionalad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClientesFK_IdPaisNacionalad(String sFinalQuery,Pagination pagination,Long id_pais_nacionalidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPaisNacionalidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPaisNacionalidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais_nacionalidad,ClienteConstantesFunciones.IDPAISNACIONALIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPaisNacionalidad);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPaisNacionalad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClientesFK_IdProfesionWithConnection(String sFinalQuery,Pagination pagination,Long id_profesion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProfesion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProfesion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_profesion,ClienteConstantesFunciones.IDPROFESION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProfesion);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProfesion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClientesFK_IdProfesion(String sFinalQuery,Pagination pagination,Long id_profesion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProfesion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProfesion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_profesion,ClienteConstantesFunciones.IDPROFESION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProfesion);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProfesion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClientesFK_IdProvinciaWithConnection(String sFinalQuery,Pagination pagination,Long id_provincia)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProvincia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProvincia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_provincia,ClienteConstantesFunciones.IDPROVINCIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProvincia);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProvincia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClientesFK_IdProvincia(String sFinalQuery,Pagination pagination,Long id_provincia)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProvincia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProvincia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_provincia,ClienteConstantesFunciones.IDPROVINCIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProvincia);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProvincia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClientesFK_IdRegionWithConnection(String sFinalQuery,Pagination pagination,Long id_region)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRegion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRegion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_region,ClienteConstantesFunciones.IDREGION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRegion);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRegion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClientesFK_IdRegion(String sFinalQuery,Pagination pagination,Long id_region)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRegion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRegion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_region,ClienteConstantesFunciones.IDREGION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRegion);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRegion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClientesFK_IdRutaWithConnection(String sFinalQuery,Pagination pagination,Long id_ruta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRuta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRuta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ruta,ClienteConstantesFunciones.IDRUTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRuta);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRuta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClientesFK_IdRuta(String sFinalQuery,Pagination pagination,Long id_ruta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRuta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRuta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ruta,ClienteConstantesFunciones.IDRUTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRuta);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRuta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClientesFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ClienteConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClientesFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ClienteConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClientesFK_IdTipoCargoLaboWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_cargo_labo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCargoLabo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCargoLabo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cargo_labo,ClienteConstantesFunciones.IDTIPOCARGOLABO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCargoLabo);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCargoLabo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClientesFK_IdTipoCargoLabo(String sFinalQuery,Pagination pagination,Long id_tipo_cargo_labo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCargoLabo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCargoLabo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cargo_labo,ClienteConstantesFunciones.IDTIPOCARGOLABO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCargoLabo);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCargoLabo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClientesFK_IdTipoGarantiaEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_garantia_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoGarantiaEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoGarantiaEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_garantia_empresa,ClienteConstantesFunciones.IDTIPOGARANTIAEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoGarantiaEmpresa);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoGarantiaEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClientesFK_IdTipoGarantiaEmpresa(String sFinalQuery,Pagination pagination,Long id_tipo_garantia_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoGarantiaEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoGarantiaEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_garantia_empresa,ClienteConstantesFunciones.IDTIPOGARANTIAEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoGarantiaEmpresa);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoGarantiaEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClientesFK_IdTipoGeneroWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_genero)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoGenero= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoGenero.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_genero,ClienteConstantesFunciones.IDTIPOGENERO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoGenero);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoGenero","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClientesFK_IdTipoGenero(String sFinalQuery,Pagination pagination,Long id_tipo_genero)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoGenero= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoGenero.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_genero,ClienteConstantesFunciones.IDTIPOGENERO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoGenero);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoGenero","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClientesFK_IdTipoIdentificacionWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_identificacion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoIdentificacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoIdentificacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_identificacion,ClienteConstantesFunciones.IDTIPOIDENTIFICACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoIdentificacion);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoIdentificacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClientesFK_IdTipoIdentificacion(String sFinalQuery,Pagination pagination,Long id_tipo_identificacion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoIdentificacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoIdentificacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_identificacion,ClienteConstantesFunciones.IDTIPOIDENTIFICACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoIdentificacion);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoIdentificacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClientesFK_IdTipoListaPrecioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_lista_precio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoListaPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoListaPrecio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_lista_precio,ClienteConstantesFunciones.IDTIPOLISTAPRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoListaPrecio);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoListaPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClientesFK_IdTipoListaPrecio(String sFinalQuery,Pagination pagination,Long id_tipo_lista_precio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoListaPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoListaPrecio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_lista_precio,ClienteConstantesFunciones.IDTIPOLISTAPRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoListaPrecio);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoListaPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClientesFK_IdTipoNivelEduWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_nivel_edu)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoNivelEdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoNivelEdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_nivel_edu,ClienteConstantesFunciones.IDTIPONIVELEDU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoNivelEdu);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoNivelEdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClientesFK_IdTipoNivelEdu(String sFinalQuery,Pagination pagination,Long id_tipo_nivel_edu)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoNivelEdu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoNivelEdu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_nivel_edu,ClienteConstantesFunciones.IDTIPONIVELEDU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoNivelEdu);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoNivelEdu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClientesFK_IdTipoPrecioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_precio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPrecio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_precio,ClienteConstantesFunciones.IDTIPOPRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPrecio);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClientesFK_IdTipoPrecio(String sFinalQuery,Pagination pagination,Long id_tipo_precio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPrecio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_precio,ClienteConstantesFunciones.IDTIPOPRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPrecio);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClientesFK_IdTituloClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_titulo_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTituloCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTituloCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_titulo_cliente,ClienteConstantesFunciones.IDTITULOCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTituloCliente);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTituloCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClientesFK_IdTituloCliente(String sFinalQuery,Pagination pagination,Long id_titulo_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTituloCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTituloCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_titulo_cliente,ClienteConstantesFunciones.IDTITULOCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTituloCliente);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTituloCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClientesFK_IdVendedorWithConnection(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,ClienteConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClientesFK_IdVendedor(String sFinalQuery,Pagination pagination,Long id_vendedor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVendedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVendedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vendedor,ClienteConstantesFunciones.IDVENDEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVendedor);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVendedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getClientesFK_IdZonaWithConnection(String sFinalQuery,Pagination pagination,Long id_zona)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Cliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidZona= new ParameterSelectionGeneral();
			parameterSelectionGeneralidZona.setParameterSelectionGeneralEqual(ParameterType.LONG,id_zona,ClienteConstantesFunciones.IDZONA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidZona);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdZona","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getClientesFK_IdZona(String sFinalQuery,Pagination pagination,Long id_zona)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidZona= new ParameterSelectionGeneral();
			parameterSelectionGeneralidZona.setParameterSelectionGeneralEqual(ParameterType.LONG,id_zona,ClienteConstantesFunciones.IDZONA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidZona);

			ClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdZona","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(this.clientes);
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
			if(ClienteConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ClienteDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Cliente cliente,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ClienteConstantesFunciones.ISCONAUDITORIA) {
				if(cliente.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ClienteDataAccess.TABLENAME, cliente.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ClienteLogic.registrarAuditoriaDetallesCliente(connexion,cliente,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(cliente.getIsDeleted()) {
					/*if(!cliente.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ClienteDataAccess.TABLENAME, cliente.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ClienteLogic.registrarAuditoriaDetallesCliente(connexion,cliente,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ClienteDataAccess.TABLENAME, cliente.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(cliente.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ClienteDataAccess.TABLENAME, cliente.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ClienteLogic.registrarAuditoriaDetallesCliente(connexion,cliente,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesCliente(Connexion connexion,Cliente cliente)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(cliente.getIsNew()||!cliente.getid_empresa().equals(cliente.getClienteOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getid_empresa()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getid_empresa().toString();
				}
				if(cliente.getid_empresa()!=null)
				{
					strValorNuevo=cliente.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getid_sucursal().equals(cliente.getClienteOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getid_sucursal()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getid_sucursal().toString();
				}
				if(cliente.getid_sucursal()!=null)
				{
					strValorNuevo=cliente.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getcodigo().equals(cliente.getClienteOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getcodigo()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getcodigo();
				}
				if(cliente.getcodigo()!=null)
				{
					strValorNuevo=cliente.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getid_tipo_identificacion().equals(cliente.getClienteOriginal().getid_tipo_identificacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getid_tipo_identificacion()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getid_tipo_identificacion().toString();
				}
				if(cliente.getid_tipo_identificacion()!=null)
				{
					strValorNuevo=cliente.getid_tipo_identificacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.IDTIPOIDENTIFICACION,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getidentificacion().equals(cliente.getClienteOriginal().getidentificacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getidentificacion()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getidentificacion();
				}
				if(cliente.getidentificacion()!=null)
				{
					strValorNuevo=cliente.getidentificacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.IDENTIFICACION,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getruc().equals(cliente.getClienteOriginal().getruc()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getruc()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getruc();
				}
				if(cliente.getruc()!=null)
				{
					strValorNuevo=cliente.getruc() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.RUC,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getnombre().equals(cliente.getClienteOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getnombre()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getnombre();
				}
				if(cliente.getnombre()!=null)
				{
					strValorNuevo=cliente.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getapellido().equals(cliente.getClienteOriginal().getapellido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getapellido()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getapellido();
				}
				if(cliente.getapellido()!=null)
				{
					strValorNuevo=cliente.getapellido() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.APELLIDO,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getnombre_completo().equals(cliente.getClienteOriginal().getnombre_completo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getnombre_completo()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getnombre_completo();
				}
				if(cliente.getnombre_completo()!=null)
				{
					strValorNuevo=cliente.getnombre_completo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.NOMBRECOMPLETO,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getnombre_comercial().equals(cliente.getClienteOriginal().getnombre_comercial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getnombre_comercial()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getnombre_comercial();
				}
				if(cliente.getnombre_comercial()!=null)
				{
					strValorNuevo=cliente.getnombre_comercial() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.NOMBRECOMERCIAL,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.gettelefono().equals(cliente.getClienteOriginal().gettelefono()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().gettelefono()!=null)
				{
					strValorActual=cliente.getClienteOriginal().gettelefono();
				}
				if(cliente.gettelefono()!=null)
				{
					strValorNuevo=cliente.gettelefono() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.TELEFONO,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getdireccion().equals(cliente.getClienteOriginal().getdireccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getdireccion()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getdireccion();
				}
				if(cliente.getdireccion()!=null)
				{
					strValorNuevo=cliente.getdireccion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.DIRECCION,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getes_prove().equals(cliente.getClienteOriginal().getes_prove()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getes_prove()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getes_prove().toString();
				}
				if(cliente.getes_prove()!=null)
				{
					strValorNuevo=cliente.getes_prove().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.ESPROVE,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getid_grupo_cliente().equals(cliente.getClienteOriginal().getid_grupo_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getid_grupo_cliente()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getid_grupo_cliente().toString();
				}
				if(cliente.getid_grupo_cliente()!=null)
				{
					strValorNuevo=cliente.getid_grupo_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.IDGRUPOCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getid_titulo_cliente().equals(cliente.getClienteOriginal().getid_titulo_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getid_titulo_cliente()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getid_titulo_cliente().toString();
				}
				if(cliente.getid_titulo_cliente()!=null)
				{
					strValorNuevo=cliente.getid_titulo_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.IDTITULOCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getid_area_cr().equals(cliente.getClienteOriginal().getid_area_cr()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getid_area_cr()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getid_area_cr().toString();
				}
				if(cliente.getid_area_cr()!=null)
				{
					strValorNuevo=cliente.getid_area_cr().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.IDAREACR,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getid_estado_cliente().equals(cliente.getClienteOriginal().getid_estado_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getid_estado_cliente()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getid_estado_cliente().toString();
				}
				if(cliente.getid_estado_cliente()!=null)
				{
					strValorNuevo=cliente.getid_estado_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.IDESTADOCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getobservacion().equals(cliente.getClienteOriginal().getobservacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getobservacion()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getobservacion();
				}
				if(cliente.getobservacion()!=null)
				{
					strValorNuevo=cliente.getobservacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.OBSERVACION,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getid_pais().equals(cliente.getClienteOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getid_pais()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getid_pais().toString();
				}
				if(cliente.getid_pais()!=null)
				{
					strValorNuevo=cliente.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getid_region().equals(cliente.getClienteOriginal().getid_region()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getid_region()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getid_region().toString();
				}
				if(cliente.getid_region()!=null)
				{
					strValorNuevo=cliente.getid_region().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.IDREGION,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getid_provincia().equals(cliente.getClienteOriginal().getid_provincia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getid_provincia()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getid_provincia().toString();
				}
				if(cliente.getid_provincia()!=null)
				{
					strValorNuevo=cliente.getid_provincia().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.IDPROVINCIA,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getid_ciudad().equals(cliente.getClienteOriginal().getid_ciudad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getid_ciudad()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getid_ciudad().toString();
				}
				if(cliente.getid_ciudad()!=null)
				{
					strValorNuevo=cliente.getid_ciudad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.IDCIUDAD,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getid_zona().equals(cliente.getClienteOriginal().getid_zona()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getid_zona()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getid_zona().toString();
				}
				if(cliente.getid_zona()!=null)
				{
					strValorNuevo=cliente.getid_zona().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.IDZONA,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getid_pais_nacionalidad().equals(cliente.getClienteOriginal().getid_pais_nacionalidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getid_pais_nacionalidad()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getid_pais_nacionalidad().toString();
				}
				if(cliente.getid_pais_nacionalidad()!=null)
				{
					strValorNuevo=cliente.getid_pais_nacionalidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.IDPAISNACIONALIDAD,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getid_tipo_cargo_labo().equals(cliente.getClienteOriginal().getid_tipo_cargo_labo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getid_tipo_cargo_labo()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getid_tipo_cargo_labo().toString();
				}
				if(cliente.getid_tipo_cargo_labo()!=null)
				{
					strValorNuevo=cliente.getid_tipo_cargo_labo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.IDTIPOCARGOLABO,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getid_tipo_nivel_edu().equals(cliente.getClienteOriginal().getid_tipo_nivel_edu()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getid_tipo_nivel_edu()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getid_tipo_nivel_edu().toString();
				}
				if(cliente.getid_tipo_nivel_edu()!=null)
				{
					strValorNuevo=cliente.getid_tipo_nivel_edu().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.IDTIPONIVELEDU,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getid_profesion().equals(cliente.getClienteOriginal().getid_profesion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getid_profesion()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getid_profesion().toString();
				}
				if(cliente.getid_profesion()!=null)
				{
					strValorNuevo=cliente.getid_profesion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.IDPROFESION,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getid_tipo_genero().equals(cliente.getClienteOriginal().getid_tipo_genero()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getid_tipo_genero()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getid_tipo_genero().toString();
				}
				if(cliente.getid_tipo_genero()!=null)
				{
					strValorNuevo=cliente.getid_tipo_genero().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.IDTIPOGENERO,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getid_estado_civil().equals(cliente.getClienteOriginal().getid_estado_civil()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getid_estado_civil()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getid_estado_civil().toString();
				}
				if(cliente.getid_estado_civil()!=null)
				{
					strValorNuevo=cliente.getid_estado_civil().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.IDESTADOCIVIL,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getid_estado_legal().equals(cliente.getClienteOriginal().getid_estado_legal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getid_estado_legal()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getid_estado_legal().toString();
				}
				if(cliente.getid_estado_legal()!=null)
				{
					strValorNuevo=cliente.getid_estado_legal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.IDESTADOLEGAL,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getfecha_nacimiento().equals(cliente.getClienteOriginal().getfecha_nacimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getfecha_nacimiento()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getfecha_nacimiento().toString();
				}
				if(cliente.getfecha_nacimiento()!=null)
				{
					strValorNuevo=cliente.getfecha_nacimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.FECHANACIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getpath_imagen_firma().equals(cliente.getClienteOriginal().getpath_imagen_firma()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getpath_imagen_firma()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getpath_imagen_firma();
				}
				if(cliente.getpath_imagen_firma()!=null)
				{
					strValorNuevo=cliente.getpath_imagen_firma() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.PATHIMAGENFIRMA,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getcontacto().equals(cliente.getClienteOriginal().getcontacto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getcontacto()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getcontacto();
				}
				if(cliente.getcontacto()!=null)
				{
					strValorNuevo=cliente.getcontacto() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.CONTACTO,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getid_cuenta_contable().equals(cliente.getClienteOriginal().getid_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getid_cuenta_contable()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getid_cuenta_contable().toString();
				}
				if(cliente.getid_cuenta_contable()!=null)
				{
					strValorNuevo=cliente.getid_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.IDCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getid_ruta().equals(cliente.getClienteOriginal().getid_ruta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getid_ruta()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getid_ruta().toString();
				}
				if(cliente.getid_ruta()!=null)
				{
					strValorNuevo=cliente.getid_ruta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.IDRUTA,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getid_vendedor().equals(cliente.getClienteOriginal().getid_vendedor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getid_vendedor()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getid_vendedor().toString();
				}
				if(cliente.getid_vendedor()!=null)
				{
					strValorNuevo=cliente.getid_vendedor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.IDVENDEDOR,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getid_centro_actividad().equals(cliente.getClienteOriginal().getid_centro_actividad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getid_centro_actividad()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getid_centro_actividad().toString();
				}
				if(cliente.getid_centro_actividad()!=null)
				{
					strValorNuevo=cliente.getid_centro_actividad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.IDCENTROACTIVIDAD,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getrepresentante().equals(cliente.getClienteOriginal().getrepresentante()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getrepresentante()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getrepresentante();
				}
				if(cliente.getrepresentante()!=null)
				{
					strValorNuevo=cliente.getrepresentante() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.REPRESENTANTE,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getid_tipo_garantia_empresa().equals(cliente.getClienteOriginal().getid_tipo_garantia_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getid_tipo_garantia_empresa()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getid_tipo_garantia_empresa().toString();
				}
				if(cliente.getid_tipo_garantia_empresa()!=null)
				{
					strValorNuevo=cliente.getid_tipo_garantia_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.IDTIPOGARANTIAEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getnombre_garantia().equals(cliente.getClienteOriginal().getnombre_garantia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getnombre_garantia()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getnombre_garantia();
				}
				if(cliente.getnombre_garantia()!=null)
				{
					strValorNuevo=cliente.getnombre_garantia() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.NOMBREGARANTIA,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getvalor_garantia().equals(cliente.getClienteOriginal().getvalor_garantia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getvalor_garantia()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getvalor_garantia().toString();
				}
				if(cliente.getvalor_garantia()!=null)
				{
					strValorNuevo=cliente.getvalor_garantia().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.VALORGARANTIA,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getid_cate_tipo_afiliacion().equals(cliente.getClienteOriginal().getid_cate_tipo_afiliacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getid_cate_tipo_afiliacion()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getid_cate_tipo_afiliacion().toString();
				}
				if(cliente.getid_cate_tipo_afiliacion()!=null)
				{
					strValorNuevo=cliente.getid_cate_tipo_afiliacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.IDCATETIPOAFILIACION,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getnumero_carga().equals(cliente.getClienteOriginal().getnumero_carga()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getnumero_carga()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getnumero_carga().toString();
				}
				if(cliente.getnumero_carga()!=null)
				{
					strValorNuevo=cliente.getnumero_carga().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.NUMEROCARGA,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getcredito_usado().equals(cliente.getClienteOriginal().getcredito_usado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getcredito_usado()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getcredito_usado().toString();
				}
				if(cliente.getcredito_usado()!=null)
				{
					strValorNuevo=cliente.getcredito_usado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.CREDITOUSADO,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getlimite_credito().equals(cliente.getClienteOriginal().getlimite_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getlimite_credito()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getlimite_credito().toString();
				}
				if(cliente.getlimite_credito()!=null)
				{
					strValorNuevo=cliente.getlimite_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.LIMITECREDITO,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getcredito_disponible().equals(cliente.getClienteOriginal().getcredito_disponible()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getcredito_disponible()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getcredito_disponible().toString();
				}
				if(cliente.getcredito_disponible()!=null)
				{
					strValorNuevo=cliente.getcredito_disponible().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.CREDITODISPONIBLE,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.gettotal_documentos().equals(cliente.getClienteOriginal().gettotal_documentos()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().gettotal_documentos()!=null)
				{
					strValorActual=cliente.getClienteOriginal().gettotal_documentos().toString();
				}
				if(cliente.gettotal_documentos()!=null)
				{
					strValorNuevo=cliente.gettotal_documentos().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.TOTALDOCUMENTOS,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getfecha_ultima_factura().equals(cliente.getClienteOriginal().getfecha_ultima_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getfecha_ultima_factura()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getfecha_ultima_factura().toString();
				}
				if(cliente.getfecha_ultima_factura()!=null)
				{
					strValorNuevo=cliente.getfecha_ultima_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.FECHAULTIMAFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getdescuento().equals(cliente.getClienteOriginal().getdescuento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getdescuento()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getdescuento().toString();
				}
				if(cliente.getdescuento()!=null)
				{
					strValorNuevo=cliente.getdescuento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.DESCUENTO,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getid_dia().equals(cliente.getClienteOriginal().getid_dia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getid_dia()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getid_dia().toString();
				}
				if(cliente.getid_dia()!=null)
				{
					strValorNuevo=cliente.getid_dia().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.IDDIA,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.gethora_pago().equals(cliente.getClienteOriginal().gethora_pago()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().gethora_pago()!=null)
				{
					strValorActual=cliente.getClienteOriginal().gethora_pago().toString();
				}
				if(cliente.gethora_pago()!=null)
				{
					strValorNuevo=cliente.gethora_pago().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.HORAPAGO,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getid_empleado().equals(cliente.getClienteOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getid_empleado()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getid_empleado().toString();
				}
				if(cliente.getid_empleado()!=null)
				{
					strValorNuevo=cliente.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getcobranzas().equals(cliente.getClienteOriginal().getcobranzas()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getcobranzas()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getcobranzas();
				}
				if(cliente.getcobranzas()!=null)
				{
					strValorNuevo=cliente.getcobranzas() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.COBRANZAS,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getmotivo().equals(cliente.getClienteOriginal().getmotivo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getmotivo()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getmotivo();
				}
				if(cliente.getmotivo()!=null)
				{
					strValorNuevo=cliente.getmotivo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.MOTIVO,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getpreferencia().equals(cliente.getClienteOriginal().getpreferencia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getpreferencia()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getpreferencia();
				}
				if(cliente.getpreferencia()!=null)
				{
					strValorNuevo=cliente.getpreferencia() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.PREFERENCIA,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getcon_separacion_bienes().equals(cliente.getClienteOriginal().getcon_separacion_bienes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getcon_separacion_bienes()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getcon_separacion_bienes().toString();
				}
				if(cliente.getcon_separacion_bienes()!=null)
				{
					strValorNuevo=cliente.getcon_separacion_bienes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.CONSEPARACIONBIENES,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getid_tipo_precio().equals(cliente.getClienteOriginal().getid_tipo_precio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getid_tipo_precio()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getid_tipo_precio().toString();
				}
				if(cliente.getid_tipo_precio()!=null)
				{
					strValorNuevo=cliente.getid_tipo_precio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.IDTIPOPRECIO,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getid_tipo_lista_precio().equals(cliente.getClienteOriginal().getid_tipo_lista_precio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getid_tipo_lista_precio()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getid_tipo_lista_precio().toString();
				}
				if(cliente.getid_tipo_lista_precio()!=null)
				{
					strValorNuevo=cliente.getid_tipo_lista_precio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.IDTIPOLISTAPRECIO,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getdetalle_estado().equals(cliente.getClienteOriginal().getdetalle_estado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getdetalle_estado()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getdetalle_estado();
				}
				if(cliente.getdetalle_estado()!=null)
				{
					strValorNuevo=cliente.getdetalle_estado() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.DETALLEESTADO,strValorActual,strValorNuevo);
			}	
			
			if(cliente.getIsNew()||!cliente.getes_contribuyente_especial().equals(cliente.getClienteOriginal().getes_contribuyente_especial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cliente.getClienteOriginal().getes_contribuyente_especial()!=null)
				{
					strValorActual=cliente.getClienteOriginal().getes_contribuyente_especial().toString();
				}
				if(cliente.getes_contribuyente_especial()!=null)
				{
					strValorNuevo=cliente.getes_contribuyente_especial().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ClienteConstantesFunciones.ESCONTRIBUYENTEESPECIAL,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveClienteRelacionesWithConnection(Cliente cliente,List<ContactoCliente> contactoclientes,List<Bien> biens,List<CargaFamiliar> cargafamiliars,List<ChequePostFechado> chequepostfechados,List<EMail> emails,List<ReferenciaPersonal> referenciapersonals,List<GarantiaCliente> garantiaclientes,List<ClienteArchivo> clientearchivos,PoliticasCliente politicascliente,List<FirmaCliente> firmaclientes,List<ReferenciaComercial> referenciacomercials,List<Novedad> novedads,List<InformacionLaboral> informacionlaborals,List<InformacionFinanciera> informacionfinancieras,List<Telefono> telefonos,List<CuentaPorCobrar> cuentaporcobrars,List<Responsable> responsables,List<Transportista> transportistas,List<PoliticaCliente> politicaclientes,Conyuge conyuge,List<ReferenciaBancaria> referenciabancarias,List<BalanceGeneralCliente> balancegeneralclientes,List<DatoConstitucion> datoconstitucions,List<ActividadEconomica> actividadeconomicas,List<ProveedorProducto> proveedorproductos,List<Consignatario> consignatarios,List<HobbyCliente> hobbyclientes,List<RepresentanteLegal> representantelegals,List<ClienteCoa> clientecoas,List<Direccion> direccions,List<ClienteImagen> clienteimagens,List<SubCliente> subclientes,List<ServicioCliente> servicioclientes,List<InformacionEconomica> informacioneconomicas,List<VehiculoCliente> vehiculoclientes,List<NegocioCliente> negocioclientes,List<Monto> montos) throws Exception {

		if(!cliente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveClienteRelacionesBase(cliente,contactoclientes,biens,cargafamiliars,chequepostfechados,emails,referenciapersonals,garantiaclientes,clientearchivos,politicascliente,firmaclientes,referenciacomercials,novedads,informacionlaborals,informacionfinancieras,telefonos,cuentaporcobrars,responsables,transportistas,politicaclientes,conyuge,referenciabancarias,balancegeneralclientes,datoconstitucions,actividadeconomicas,proveedorproductos,consignatarios,hobbyclientes,representantelegals,clientecoas,direccions,clienteimagens,subclientes,servicioclientes,informacioneconomicas,vehiculoclientes,negocioclientes,montos,true);
		}
	}

	public void saveClienteRelaciones(Cliente cliente,List<ContactoCliente> contactoclientes,List<Bien> biens,List<CargaFamiliar> cargafamiliars,List<ChequePostFechado> chequepostfechados,List<EMail> emails,List<ReferenciaPersonal> referenciapersonals,List<GarantiaCliente> garantiaclientes,List<ClienteArchivo> clientearchivos,PoliticasCliente politicascliente,List<FirmaCliente> firmaclientes,List<ReferenciaComercial> referenciacomercials,List<Novedad> novedads,List<InformacionLaboral> informacionlaborals,List<InformacionFinanciera> informacionfinancieras,List<Telefono> telefonos,List<CuentaPorCobrar> cuentaporcobrars,List<Responsable> responsables,List<Transportista> transportistas,List<PoliticaCliente> politicaclientes,Conyuge conyuge,List<ReferenciaBancaria> referenciabancarias,List<BalanceGeneralCliente> balancegeneralclientes,List<DatoConstitucion> datoconstitucions,List<ActividadEconomica> actividadeconomicas,List<ProveedorProducto> proveedorproductos,List<Consignatario> consignatarios,List<HobbyCliente> hobbyclientes,List<RepresentanteLegal> representantelegals,List<ClienteCoa> clientecoas,List<Direccion> direccions,List<ClienteImagen> clienteimagens,List<SubCliente> subclientes,List<ServicioCliente> servicioclientes,List<InformacionEconomica> informacioneconomicas,List<VehiculoCliente> vehiculoclientes,List<NegocioCliente> negocioclientes,List<Monto> montos)throws Exception {

		if(!cliente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveClienteRelacionesBase(cliente,contactoclientes,biens,cargafamiliars,chequepostfechados,emails,referenciapersonals,garantiaclientes,clientearchivos,politicascliente,firmaclientes,referenciacomercials,novedads,informacionlaborals,informacionfinancieras,telefonos,cuentaporcobrars,responsables,transportistas,politicaclientes,conyuge,referenciabancarias,balancegeneralclientes,datoconstitucions,actividadeconomicas,proveedorproductos,consignatarios,hobbyclientes,representantelegals,clientecoas,direccions,clienteimagens,subclientes,servicioclientes,informacioneconomicas,vehiculoclientes,negocioclientes,montos,false);
		}
	}

	public void saveClienteRelacionesBase(Cliente cliente,List<ContactoCliente> contactoclientes,List<Bien> biens,List<CargaFamiliar> cargafamiliars,List<ChequePostFechado> chequepostfechados,List<EMail> emails,List<ReferenciaPersonal> referenciapersonals,List<GarantiaCliente> garantiaclientes,List<ClienteArchivo> clientearchivos,PoliticasCliente politicascliente,List<FirmaCliente> firmaclientes,List<ReferenciaComercial> referenciacomercials,List<Novedad> novedads,List<InformacionLaboral> informacionlaborals,List<InformacionFinanciera> informacionfinancieras,List<Telefono> telefonos,List<CuentaPorCobrar> cuentaporcobrars,List<Responsable> responsables,List<Transportista> transportistas,List<PoliticaCliente> politicaclientes,Conyuge conyuge,List<ReferenciaBancaria> referenciabancarias,List<BalanceGeneralCliente> balancegeneralclientes,List<DatoConstitucion> datoconstitucions,List<ActividadEconomica> actividadeconomicas,List<ProveedorProducto> proveedorproductos,List<Consignatario> consignatarios,List<HobbyCliente> hobbyclientes,List<RepresentanteLegal> representantelegals,List<ClienteCoa> clientecoas,List<Direccion> direccions,List<ClienteImagen> clienteimagens,List<SubCliente> subclientes,List<ServicioCliente> servicioclientes,List<InformacionEconomica> informacioneconomicas,List<VehiculoCliente> vehiculoclientes,List<NegocioCliente> negocioclientes,List<Monto> montos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Cliente-saveRelacionesWithConnection");}
	
			cliente.setContactoClientes(contactoclientes);
			cliente.setBiens(biens);
			cliente.setCargaFamiliars(cargafamiliars);
			cliente.setChequePostFechados(chequepostfechados);
			cliente.setEMails(emails);
			cliente.setReferenciaPersonals(referenciapersonals);
			cliente.setGarantiaClientes(garantiaclientes);
			cliente.setClienteArchivos(clientearchivos);
			cliente.setPoliticasCliente(politicascliente);
			cliente.setFirmaClientes(firmaclientes);
			cliente.setReferenciaComercials(referenciacomercials);
			cliente.setNovedads(novedads);
			cliente.setInformacionLaborals(informacionlaborals);
			cliente.setInformacionFinancieras(informacionfinancieras);
			cliente.setTelefonos(telefonos);
			cliente.setCuentaPorCobrars(cuentaporcobrars);
			cliente.setResponsables(responsables);
			cliente.setTransportistas(transportistas);
			cliente.setPoliticaClientes(politicaclientes);
			cliente.setConyuge(conyuge);
			cliente.setReferenciaBancarias(referenciabancarias);
			cliente.setBalanceGeneralClientes(balancegeneralclientes);
			cliente.setDatoConstitucions(datoconstitucions);
			cliente.setActividadEconomicas(actividadeconomicas);
			cliente.setProveedorProductos(proveedorproductos);
			cliente.setConsignatarios(consignatarios);
			cliente.setHobbyClientes(hobbyclientes);
			cliente.setRepresentanteLegals(representantelegals);
			cliente.setClienteCoas(clientecoas);
			cliente.setDireccions(direccions);
			cliente.setClienteImagens(clienteimagens);
			cliente.setSubClientes(subclientes);
			cliente.setServicioClientes(servicioclientes);
			cliente.setInformacionEconomicas(informacioneconomicas);
			cliente.setVehiculoClientes(vehiculoclientes);
			cliente.setNegocioClientes(negocioclientes);
			cliente.setMontos(montos);

			this.setCliente(cliente);

			if(ClienteLogicAdditional.validarSaveRelaciones(cliente,this)) {

				ClienteLogicAdditional.updateRelacionesToSave(cliente,this);

				if((cliente.getIsNew()||cliente.getIsChanged())&&!cliente.getIsDeleted()) {
					this.saveCliente();
					this.saveClienteRelacionesDetalles(contactoclientes,biens,cargafamiliars,chequepostfechados,emails,referenciapersonals,garantiaclientes,clientearchivos,politicascliente,firmaclientes,referenciacomercials,novedads,informacionlaborals,informacionfinancieras,telefonos,cuentaporcobrars,responsables,transportistas,politicaclientes,conyuge,referenciabancarias,balancegeneralclientes,datoconstitucions,actividadeconomicas,proveedorproductos,consignatarios,hobbyclientes,representantelegals,clientecoas,direccions,clienteimagens,subclientes,servicioclientes,informacioneconomicas,vehiculoclientes,negocioclientes,montos);

				} else if(cliente.getIsDeleted()) {
					this.saveClienteRelacionesDetalles(contactoclientes,biens,cargafamiliars,chequepostfechados,emails,referenciapersonals,garantiaclientes,clientearchivos,politicascliente,firmaclientes,referenciacomercials,novedads,informacionlaborals,informacionfinancieras,telefonos,cuentaporcobrars,responsables,transportistas,politicaclientes,conyuge,referenciabancarias,balancegeneralclientes,datoconstitucions,actividadeconomicas,proveedorproductos,consignatarios,hobbyclientes,representantelegals,clientecoas,direccions,clienteimagens,subclientes,servicioclientes,informacioneconomicas,vehiculoclientes,negocioclientes,montos);
					this.saveCliente();
				}

				ClienteLogicAdditional.updateRelacionesToSaveAfter(cliente,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ContactoClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresContactoClientes(contactoclientes,true,true);
			BienConstantesFunciones.InicializarGeneralEntityAuxiliaresBiens(biens,true,true);
			CargaFamiliarConstantesFunciones.InicializarGeneralEntityAuxiliaresCargaFamiliars(cargafamiliars,true,true);
			ChequePostFechadoConstantesFunciones.InicializarGeneralEntityAuxiliaresChequePostFechados(chequepostfechados,true,true);
			EMailConstantesFunciones.InicializarGeneralEntityAuxiliaresEMails(emails,true,true);
			ReferenciaPersonalConstantesFunciones.InicializarGeneralEntityAuxiliaresReferenciaPersonals(referenciapersonals,true,true);
			GarantiaClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresGarantiaClientes(garantiaclientes,true,true);
			ClienteArchivoConstantesFunciones.InicializarGeneralEntityAuxiliaresClienteArchivos(clientearchivos,true,true);
		PoliticasClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresPoliticasCliente(politicascliente,true,true);
			FirmaClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresFirmaClientes(firmaclientes,true,true);
			ReferenciaComercialConstantesFunciones.InicializarGeneralEntityAuxiliaresReferenciaComercials(referenciacomercials,true,true);
			NovedadConstantesFunciones.InicializarGeneralEntityAuxiliaresNovedads(novedads,true,true);
			InformacionLaboralConstantesFunciones.InicializarGeneralEntityAuxiliaresInformacionLaborals(informacionlaborals,true,true);
			InformacionFinancieraConstantesFunciones.InicializarGeneralEntityAuxiliaresInformacionFinancieras(informacionfinancieras,true,true);
			TelefonoConstantesFunciones.InicializarGeneralEntityAuxiliaresTelefonos(telefonos,true,true);
			CuentaPorCobrarConstantesFunciones.InicializarGeneralEntityAuxiliaresCuentaPorCobrars(cuentaporcobrars,true,true);
			ResponsableConstantesFunciones.InicializarGeneralEntityAuxiliaresResponsables(responsables,true,true);
			TransportistaConstantesFunciones.InicializarGeneralEntityAuxiliaresTransportistas(transportistas,true,true);
			PoliticaClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresPoliticaClientes(politicaclientes,true,true);
		ConyugeConstantesFunciones.InicializarGeneralEntityAuxiliaresConyuge(conyuge,true,true);
			ReferenciaBancariaConstantesFunciones.InicializarGeneralEntityAuxiliaresReferenciaBancarias(referenciabancarias,true,true);
			BalanceGeneralClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresBalanceGeneralClientes(balancegeneralclientes,true,true);
			DatoConstitucionConstantesFunciones.InicializarGeneralEntityAuxiliaresDatoConstitucions(datoconstitucions,true,true);
			ActividadEconomicaConstantesFunciones.InicializarGeneralEntityAuxiliaresActividadEconomicas(actividadeconomicas,true,true);
			ProveedorProductoConstantesFunciones.InicializarGeneralEntityAuxiliaresProveedorProductos(proveedorproductos,true,true);
			ConsignatarioConstantesFunciones.InicializarGeneralEntityAuxiliaresConsignatarios(consignatarios,true,true);
			HobbyClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresHobbyClientes(hobbyclientes,true,true);
			RepresentanteLegalConstantesFunciones.InicializarGeneralEntityAuxiliaresRepresentanteLegals(representantelegals,true,true);
			ClienteCoaConstantesFunciones.InicializarGeneralEntityAuxiliaresClienteCoas(clientecoas,true,true);
			DireccionConstantesFunciones.InicializarGeneralEntityAuxiliaresDireccions(direccions,true,true);
			ClienteImagenConstantesFunciones.InicializarGeneralEntityAuxiliaresClienteImagens(clienteimagens,true,true);
			SubClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresSubClientes(subclientes,true,true);
			ServicioClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresServicioClientes(servicioclientes,true,true);
			InformacionEconomicaConstantesFunciones.InicializarGeneralEntityAuxiliaresInformacionEconomicas(informacioneconomicas,true,true);
			VehiculoClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresVehiculoClientes(vehiculoclientes,true,true);
			NegocioClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresNegocioClientes(negocioclientes,true,true);
			MontoConstantesFunciones.InicializarGeneralEntityAuxiliaresMontos(montos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveClienteRelacionesDetalles(List<ContactoCliente> contactoclientes,List<Bien> biens,List<CargaFamiliar> cargafamiliars,List<ChequePostFechado> chequepostfechados,List<EMail> emails,List<ReferenciaPersonal> referenciapersonals,List<GarantiaCliente> garantiaclientes,List<ClienteArchivo> clientearchivos,PoliticasCliente politicascliente,List<FirmaCliente> firmaclientes,List<ReferenciaComercial> referenciacomercials,List<Novedad> novedads,List<InformacionLaboral> informacionlaborals,List<InformacionFinanciera> informacionfinancieras,List<Telefono> telefonos,List<CuentaPorCobrar> cuentaporcobrars,List<Responsable> responsables,List<Transportista> transportistas,List<PoliticaCliente> politicaclientes,Conyuge conyuge,List<ReferenciaBancaria> referenciabancarias,List<BalanceGeneralCliente> balancegeneralclientes,List<DatoConstitucion> datoconstitucions,List<ActividadEconomica> actividadeconomicas,List<ProveedorProducto> proveedorproductos,List<Consignatario> consignatarios,List<HobbyCliente> hobbyclientes,List<RepresentanteLegal> representantelegals,List<ClienteCoa> clientecoas,List<Direccion> direccions,List<ClienteImagen> clienteimagens,List<SubCliente> subclientes,List<ServicioCliente> servicioclientes,List<InformacionEconomica> informacioneconomicas,List<VehiculoCliente> vehiculoclientes,List<NegocioCliente> negocioclientes,List<Monto> montos)throws Exception {
		try {
	

			Long idClienteActual=this.getCliente().getId();

			ContactoClienteLogic contactoclienteLogic_Desde_Cliente=new ContactoClienteLogic();
			contactoclienteLogic_Desde_Cliente.setContactoClientes(contactoclientes);

			contactoclienteLogic_Desde_Cliente.setConnexion(this.getConnexion());
			contactoclienteLogic_Desde_Cliente.setDatosCliente(this.datosCliente);

			for(ContactoCliente contactocliente_Desde_Cliente:contactoclienteLogic_Desde_Cliente.getContactoClientes()) {
				contactocliente_Desde_Cliente.setid_cliente(idClienteActual);
			}

			contactoclienteLogic_Desde_Cliente.saveContactoClientes();

			BienLogic bienLogic_Desde_Cliente=new BienLogic();
			bienLogic_Desde_Cliente.setBiens(biens);

			bienLogic_Desde_Cliente.setConnexion(this.getConnexion());
			bienLogic_Desde_Cliente.setDatosCliente(this.datosCliente);

			for(Bien bien_Desde_Cliente:bienLogic_Desde_Cliente.getBiens()) {
				bien_Desde_Cliente.setid_cliente(idClienteActual);
			}

			bienLogic_Desde_Cliente.saveBiens();

			CargaFamiliarLogic cargafamiliarLogic_Desde_Cliente=new CargaFamiliarLogic();
			cargafamiliarLogic_Desde_Cliente.setCargaFamiliars(cargafamiliars);

			cargafamiliarLogic_Desde_Cliente.setConnexion(this.getConnexion());
			cargafamiliarLogic_Desde_Cliente.setDatosCliente(this.datosCliente);

			for(CargaFamiliar cargafamiliar_Desde_Cliente:cargafamiliarLogic_Desde_Cliente.getCargaFamiliars()) {
				cargafamiliar_Desde_Cliente.setid_cliente(idClienteActual);
			}

			cargafamiliarLogic_Desde_Cliente.saveCargaFamiliars();

			ChequePostFechadoLogic chequepostfechadoLogic_Desde_Cliente=new ChequePostFechadoLogic();
			chequepostfechadoLogic_Desde_Cliente.setChequePostFechados(chequepostfechados);

			chequepostfechadoLogic_Desde_Cliente.setConnexion(this.getConnexion());
			chequepostfechadoLogic_Desde_Cliente.setDatosCliente(this.datosCliente);

			for(ChequePostFechado chequepostfechado_Desde_Cliente:chequepostfechadoLogic_Desde_Cliente.getChequePostFechados()) {
				chequepostfechado_Desde_Cliente.setid_cliente(idClienteActual);
			}

			chequepostfechadoLogic_Desde_Cliente.saveChequePostFechados();

			EMailLogic emailLogic_Desde_Cliente=new EMailLogic();
			emailLogic_Desde_Cliente.setEMails(emails);

			emailLogic_Desde_Cliente.setConnexion(this.getConnexion());
			emailLogic_Desde_Cliente.setDatosCliente(this.datosCliente);

			for(EMail email_Desde_Cliente:emailLogic_Desde_Cliente.getEMails()) {
				email_Desde_Cliente.setid_cliente(idClienteActual);
			}

			emailLogic_Desde_Cliente.saveEMails();

			ReferenciaPersonalLogic referenciapersonalLogic_Desde_Cliente=new ReferenciaPersonalLogic();
			referenciapersonalLogic_Desde_Cliente.setReferenciaPersonals(referenciapersonals);

			referenciapersonalLogic_Desde_Cliente.setConnexion(this.getConnexion());
			referenciapersonalLogic_Desde_Cliente.setDatosCliente(this.datosCliente);

			for(ReferenciaPersonal referenciapersonal_Desde_Cliente:referenciapersonalLogic_Desde_Cliente.getReferenciaPersonals()) {
				referenciapersonal_Desde_Cliente.setidcliente(idClienteActual);
			}

			referenciapersonalLogic_Desde_Cliente.saveReferenciaPersonals();

			GarantiaClienteLogic garantiaclienteLogic_Desde_Cliente=new GarantiaClienteLogic();
			garantiaclienteLogic_Desde_Cliente.setGarantiaClientes(garantiaclientes);

			garantiaclienteLogic_Desde_Cliente.setConnexion(this.getConnexion());
			garantiaclienteLogic_Desde_Cliente.setDatosCliente(this.datosCliente);

			for(GarantiaCliente garantiacliente_Desde_Cliente:garantiaclienteLogic_Desde_Cliente.getGarantiaClientes()) {
				garantiacliente_Desde_Cliente.setid_cliente(idClienteActual);
			}

			garantiaclienteLogic_Desde_Cliente.saveGarantiaClientes();

			ClienteArchivoLogic clientearchivoLogic_Desde_Cliente=new ClienteArchivoLogic();
			clientearchivoLogic_Desde_Cliente.setClienteArchivos(clientearchivos);

			clientearchivoLogic_Desde_Cliente.setConnexion(this.getConnexion());
			clientearchivoLogic_Desde_Cliente.setDatosCliente(this.datosCliente);

			for(ClienteArchivo clientearchivo_Desde_Cliente:clientearchivoLogic_Desde_Cliente.getClienteArchivos()) {
				clientearchivo_Desde_Cliente.setid_cliente(idClienteActual);
			}

			clientearchivoLogic_Desde_Cliente.saveClienteArchivos();

			PoliticasClienteLogic politicasclienteLogic_Desde_Cliente=new PoliticasClienteLogic();
			politicasclienteLogic_Desde_Cliente.setPoliticasCliente(politicascliente);

			if(politicasclienteLogic_Desde_Cliente.getPoliticasCliente()!=null) {
			politicasclienteLogic_Desde_Cliente.getPoliticasCliente().setId(idClienteActual);
			}

			politicasclienteLogic_Desde_Cliente.setConnexion(this.getConnexion());
			politicasclienteLogic_Desde_Cliente.setDatosCliente(this.datosCliente);
			politicasclienteLogic_Desde_Cliente.savePoliticasCliente();

			FirmaClienteLogic firmaclienteLogic_Desde_Cliente=new FirmaClienteLogic();
			firmaclienteLogic_Desde_Cliente.setFirmaClientes(firmaclientes);

			firmaclienteLogic_Desde_Cliente.setConnexion(this.getConnexion());
			firmaclienteLogic_Desde_Cliente.setDatosCliente(this.datosCliente);

			for(FirmaCliente firmacliente_Desde_Cliente:firmaclienteLogic_Desde_Cliente.getFirmaClientes()) {
				firmacliente_Desde_Cliente.setid_cliente(idClienteActual);
			}

			firmaclienteLogic_Desde_Cliente.saveFirmaClientes();

			ReferenciaComercialLogic referenciacomercialLogic_Desde_Cliente=new ReferenciaComercialLogic();
			referenciacomercialLogic_Desde_Cliente.setReferenciaComercials(referenciacomercials);

			referenciacomercialLogic_Desde_Cliente.setConnexion(this.getConnexion());
			referenciacomercialLogic_Desde_Cliente.setDatosCliente(this.datosCliente);

			for(ReferenciaComercial referenciacomercial_Desde_Cliente:referenciacomercialLogic_Desde_Cliente.getReferenciaComercials()) {
				referenciacomercial_Desde_Cliente.setidcliente(idClienteActual);
			}

			referenciacomercialLogic_Desde_Cliente.saveReferenciaComercials();

			NovedadLogic novedadLogic_Desde_Cliente=new NovedadLogic();
			novedadLogic_Desde_Cliente.setNovedads(novedads);

			novedadLogic_Desde_Cliente.setConnexion(this.getConnexion());
			novedadLogic_Desde_Cliente.setDatosCliente(this.datosCliente);

			for(Novedad novedad_Desde_Cliente:novedadLogic_Desde_Cliente.getNovedads()) {
				novedad_Desde_Cliente.setid_cliente(idClienteActual);
			}

			novedadLogic_Desde_Cliente.saveNovedads();

			InformacionLaboralLogic informacionlaboralLogic_Desde_Cliente=new InformacionLaboralLogic();
			informacionlaboralLogic_Desde_Cliente.setInformacionLaborals(informacionlaborals);

			informacionlaboralLogic_Desde_Cliente.setConnexion(this.getConnexion());
			informacionlaboralLogic_Desde_Cliente.setDatosCliente(this.datosCliente);

			for(InformacionLaboral informacionlaboral_Desde_Cliente:informacionlaboralLogic_Desde_Cliente.getInformacionLaborals()) {
				informacionlaboral_Desde_Cliente.setidcliente(idClienteActual);
			}

			informacionlaboralLogic_Desde_Cliente.saveInformacionLaborals();

			InformacionFinancieraLogic informacionfinancieraLogic_Desde_Cliente=new InformacionFinancieraLogic();
			informacionfinancieraLogic_Desde_Cliente.setInformacionFinancieras(informacionfinancieras);

			informacionfinancieraLogic_Desde_Cliente.setConnexion(this.getConnexion());
			informacionfinancieraLogic_Desde_Cliente.setDatosCliente(this.datosCliente);

			for(InformacionFinanciera informacionfinanciera_Desde_Cliente:informacionfinancieraLogic_Desde_Cliente.getInformacionFinancieras()) {
				informacionfinanciera_Desde_Cliente.setidcliente(idClienteActual);
			}

			informacionfinancieraLogic_Desde_Cliente.saveInformacionFinancieras();

			TelefonoLogic telefonoLogic_Desde_Cliente=new TelefonoLogic();
			telefonoLogic_Desde_Cliente.setTelefonos(telefonos);

			telefonoLogic_Desde_Cliente.setConnexion(this.getConnexion());
			telefonoLogic_Desde_Cliente.setDatosCliente(this.datosCliente);

			for(Telefono telefono_Desde_Cliente:telefonoLogic_Desde_Cliente.getTelefonos()) {
				telefono_Desde_Cliente.setid_cliente(idClienteActual);
			}

			telefonoLogic_Desde_Cliente.saveTelefonos();

			CuentaPorCobrarLogic cuentaporcobrarLogic_Desde_Cliente=new CuentaPorCobrarLogic();
			cuentaporcobrarLogic_Desde_Cliente.setCuentaPorCobrars(cuentaporcobrars);

			cuentaporcobrarLogic_Desde_Cliente.setConnexion(this.getConnexion());
			cuentaporcobrarLogic_Desde_Cliente.setDatosCliente(this.datosCliente);

			for(CuentaPorCobrar cuentaporcobrar_Desde_Cliente:cuentaporcobrarLogic_Desde_Cliente.getCuentaPorCobrars()) {
				cuentaporcobrar_Desde_Cliente.setid_cliente(idClienteActual);
			}

			cuentaporcobrarLogic_Desde_Cliente.saveCuentaPorCobrars();

			ResponsableLogic responsableLogic_Desde_Cliente=new ResponsableLogic();
			responsableLogic_Desde_Cliente.setResponsables(responsables);

			responsableLogic_Desde_Cliente.setConnexion(this.getConnexion());
			responsableLogic_Desde_Cliente.setDatosCliente(this.datosCliente);

			for(Responsable responsable_Desde_Cliente:responsableLogic_Desde_Cliente.getResponsables()) {
				responsable_Desde_Cliente.setid_cliente(idClienteActual);

				responsableLogic_Desde_Cliente.setResponsable(responsable_Desde_Cliente);
				responsableLogic_Desde_Cliente.saveResponsable();

				Long idResponsableActual=responsable_Desde_Cliente.getId();

				FacturaLogic facturaLogic_Desde_Responsable=new FacturaLogic();

				if(responsable_Desde_Cliente.getFacturas()==null){
					responsable_Desde_Cliente.setFacturas(new ArrayList<Factura>());
				}

				facturaLogic_Desde_Responsable.setFacturas(responsable_Desde_Cliente.getFacturas());

				facturaLogic_Desde_Responsable.setConnexion(this.getConnexion());
				facturaLogic_Desde_Responsable.setDatosCliente(this.datosCliente);

				for(Factura factura_Desde_Responsable:facturaLogic_Desde_Responsable.getFacturas()) {
					factura_Desde_Responsable.setid_responsable(idResponsableActual);

					facturaLogic_Desde_Responsable.setFactura(factura_Desde_Responsable);
					facturaLogic_Desde_Responsable.saveFactura();

					Long idFacturaActual=factura_Desde_Responsable.getId();

					DetaFormaPagoLogic detaformapagoLogic_Desde_Factura=new DetaFormaPagoLogic();

					if(factura_Desde_Responsable.getDetaFormaPagos()==null){
						factura_Desde_Responsable.setDetaFormaPagos(new ArrayList<DetaFormaPago>());
					}

					detaformapagoLogic_Desde_Factura.setDetaFormaPagos(factura_Desde_Responsable.getDetaFormaPagos());

					detaformapagoLogic_Desde_Factura.setConnexion(this.getConnexion());
					detaformapagoLogic_Desde_Factura.setDatosCliente(this.datosCliente);

					for(DetaFormaPago detaformapago_Desde_Factura:detaformapagoLogic_Desde_Factura.getDetaFormaPagos()) {
						detaformapago_Desde_Factura.setid_factura(idFacturaActual);

						detaformapagoLogic_Desde_Factura.setDetaFormaPago(detaformapago_Desde_Factura);
						detaformapagoLogic_Desde_Factura.saveDetaFormaPago();

						Long idDetaFormaPagoActual=detaformapago_Desde_Factura.getId();

						BancoFormaPagoLogic bancoformapagoLogic_Desde_DetaFormaPago=new BancoFormaPagoLogic();

						if(detaformapago_Desde_Factura.getBancoFormaPagos()==null){
							detaformapago_Desde_Factura.setBancoFormaPagos(new ArrayList<BancoFormaPago>());
						}

						bancoformapagoLogic_Desde_DetaFormaPago.setBancoFormaPagos(detaformapago_Desde_Factura.getBancoFormaPagos());

						bancoformapagoLogic_Desde_DetaFormaPago.setConnexion(this.getConnexion());
						bancoformapagoLogic_Desde_DetaFormaPago.setDatosCliente(this.datosCliente);

						for(BancoFormaPago bancoformapago_Desde_DetaFormaPago:bancoformapagoLogic_Desde_DetaFormaPago.getBancoFormaPagos()) {
							bancoformapago_Desde_DetaFormaPago.setid_deta_forma_pago(idDetaFormaPagoActual);
						}

						bancoformapagoLogic_Desde_DetaFormaPago.saveBancoFormaPagos();
					}


					DetalleFacturaLogic detallefacturaLogic_Desde_Factura=new DetalleFacturaLogic();

					if(factura_Desde_Responsable.getDetalleFacturas()==null){
						factura_Desde_Responsable.setDetalleFacturas(new ArrayList<DetalleFactura>());
					}

					detallefacturaLogic_Desde_Factura.setDetalleFacturas(factura_Desde_Responsable.getDetalleFacturas());

					detallefacturaLogic_Desde_Factura.setConnexion(this.getConnexion());
					detallefacturaLogic_Desde_Factura.setDatosCliente(this.datosCliente);

					for(DetalleFactura detallefactura_Desde_Factura:detallefacturaLogic_Desde_Factura.getDetalleFacturas()) {
						detallefactura_Desde_Factura.setid_factura(idFacturaActual);
					}

					detallefacturaLogic_Desde_Factura.saveDetalleFacturas();
				}


				ConsignacionLogic consignacionLogic_Desde_Responsable=new ConsignacionLogic();

				if(responsable_Desde_Cliente.getConsignacions()==null){
					responsable_Desde_Cliente.setConsignacions(new ArrayList<Consignacion>());
				}

				consignacionLogic_Desde_Responsable.setConsignacions(responsable_Desde_Cliente.getConsignacions());

				consignacionLogic_Desde_Responsable.setConnexion(this.getConnexion());
				consignacionLogic_Desde_Responsable.setDatosCliente(this.datosCliente);

				for(Consignacion consignacion_Desde_Responsable:consignacionLogic_Desde_Responsable.getConsignacions()) {
					consignacion_Desde_Responsable.setid_responsable(idResponsableActual);

					consignacionLogic_Desde_Responsable.setConsignacion(consignacion_Desde_Responsable);
					consignacionLogic_Desde_Responsable.saveConsignacion();

					Long idConsignacionActual=consignacion_Desde_Responsable.getId();

					DetalleConsignacionLogic detalleconsignacionLogic_Desde_Consignacion=new DetalleConsignacionLogic();

					if(consignacion_Desde_Responsable.getDetalleConsignacions()==null){
						consignacion_Desde_Responsable.setDetalleConsignacions(new ArrayList<DetalleConsignacion>());
					}

					detalleconsignacionLogic_Desde_Consignacion.setDetalleConsignacions(consignacion_Desde_Responsable.getDetalleConsignacions());

					detalleconsignacionLogic_Desde_Consignacion.setConnexion(this.getConnexion());
					detalleconsignacionLogic_Desde_Consignacion.setDatosCliente(this.datosCliente);

					for(DetalleConsignacion detalleconsignacion_Desde_Consignacion:detalleconsignacionLogic_Desde_Consignacion.getDetalleConsignacions()) {
						detalleconsignacion_Desde_Consignacion.setid_consignacion(idConsignacionActual);
					}

					detalleconsignacionLogic_Desde_Consignacion.saveDetalleConsignacions();
				}


				PedidoLogic pedidoLogic_Desde_Responsable=new PedidoLogic();

				if(responsable_Desde_Cliente.getPedidos()==null){
					responsable_Desde_Cliente.setPedidos(new ArrayList<Pedido>());
				}

				pedidoLogic_Desde_Responsable.setPedidos(responsable_Desde_Cliente.getPedidos());

				pedidoLogic_Desde_Responsable.setConnexion(this.getConnexion());
				pedidoLogic_Desde_Responsable.setDatosCliente(this.datosCliente);

				for(Pedido pedido_Desde_Responsable:pedidoLogic_Desde_Responsable.getPedidos()) {
					pedido_Desde_Responsable.setid_responsable(idResponsableActual);

					pedidoLogic_Desde_Responsable.setPedido(pedido_Desde_Responsable);
					pedidoLogic_Desde_Responsable.savePedido();

					Long idPedidoActual=pedido_Desde_Responsable.getId();

					DetallePedidoLogic detallepedidoLogic_Desde_Pedido=new DetallePedidoLogic();

					if(pedido_Desde_Responsable.getDetallePedidos()==null){
						pedido_Desde_Responsable.setDetallePedidos(new ArrayList<DetallePedido>());
					}

					detallepedidoLogic_Desde_Pedido.setDetallePedidos(pedido_Desde_Responsable.getDetallePedidos());

					detallepedidoLogic_Desde_Pedido.setConnexion(this.getConnexion());
					detallepedidoLogic_Desde_Pedido.setDatosCliente(this.datosCliente);

					for(DetallePedido detallepedido_Desde_Pedido:detallepedidoLogic_Desde_Pedido.getDetallePedidos()) {
						detallepedido_Desde_Pedido.setid_pedido(idPedidoActual);
					}

					detallepedidoLogic_Desde_Pedido.saveDetallePedidos();
				}


				PedidoExporLogic pedidoexporLogic_Desde_Responsable=new PedidoExporLogic();

				if(responsable_Desde_Cliente.getPedidoExpors()==null){
					responsable_Desde_Cliente.setPedidoExpors(new ArrayList<PedidoExpor>());
				}

				pedidoexporLogic_Desde_Responsable.setPedidoExpors(responsable_Desde_Cliente.getPedidoExpors());

				pedidoexporLogic_Desde_Responsable.setConnexion(this.getConnexion());
				pedidoexporLogic_Desde_Responsable.setDatosCliente(this.datosCliente);

				for(PedidoExpor pedidoexpor_Desde_Responsable:pedidoexporLogic_Desde_Responsable.getPedidoExpors()) {
					pedidoexpor_Desde_Responsable.setid_responsable(idResponsableActual);

					pedidoexporLogic_Desde_Responsable.setPedidoExpor(pedidoexpor_Desde_Responsable);
					pedidoexporLogic_Desde_Responsable.savePedidoExpor();
				}


				NotaCreditoSoliLogic notacreditosoliLogic_Desde_Responsable=new NotaCreditoSoliLogic();

				if(responsable_Desde_Cliente.getNotaCreditoSolis()==null){
					responsable_Desde_Cliente.setNotaCreditoSolis(new ArrayList<NotaCreditoSoli>());
				}

				notacreditosoliLogic_Desde_Responsable.setNotaCreditoSolis(responsable_Desde_Cliente.getNotaCreditoSolis());

				notacreditosoliLogic_Desde_Responsable.setConnexion(this.getConnexion());
				notacreditosoliLogic_Desde_Responsable.setDatosCliente(this.datosCliente);

				for(NotaCreditoSoli notacreditosoli_Desde_Responsable:notacreditosoliLogic_Desde_Responsable.getNotaCreditoSolis()) {
					notacreditosoli_Desde_Responsable.setid_responsable(idResponsableActual);

					notacreditosoliLogic_Desde_Responsable.setNotaCreditoSoli(notacreditosoli_Desde_Responsable);
					notacreditosoliLogic_Desde_Responsable.saveNotaCreditoSoli();
				}

			}


			TransportistaLogic transportistaLogic_Desde_Cliente=new TransportistaLogic();
			transportistaLogic_Desde_Cliente.setTransportistas(transportistas);

			transportistaLogic_Desde_Cliente.setConnexion(this.getConnexion());
			transportistaLogic_Desde_Cliente.setDatosCliente(this.datosCliente);

			for(Transportista transportista_Desde_Cliente:transportistaLogic_Desde_Cliente.getTransportistas()) {
				transportista_Desde_Cliente.setid_cliente(idClienteActual);
			}

			transportistaLogic_Desde_Cliente.saveTransportistas();

			PoliticaClienteLogic politicaclienteLogic_Desde_Cliente=new PoliticaClienteLogic();
			politicaclienteLogic_Desde_Cliente.setPoliticaClientes(politicaclientes);

			politicaclienteLogic_Desde_Cliente.setConnexion(this.getConnexion());
			politicaclienteLogic_Desde_Cliente.setDatosCliente(this.datosCliente);

			for(PoliticaCliente politicacliente_Desde_Cliente:politicaclienteLogic_Desde_Cliente.getPoliticaClientes()) {
				politicacliente_Desde_Cliente.setid_cliente(idClienteActual);
			}

			politicaclienteLogic_Desde_Cliente.savePoliticaClientes();

			ConyugeLogic conyugeLogic_Desde_Cliente=new ConyugeLogic();
			conyugeLogic_Desde_Cliente.setConyuge(conyuge);

			if(conyugeLogic_Desde_Cliente.getConyuge()!=null) {
			conyugeLogic_Desde_Cliente.getConyuge().setId(idClienteActual);
			}

			conyugeLogic_Desde_Cliente.setConnexion(this.getConnexion());
			conyugeLogic_Desde_Cliente.setDatosCliente(this.datosCliente);
			conyugeLogic_Desde_Cliente.saveConyuge();

			ReferenciaBancariaLogic referenciabancariaLogic_Desde_Cliente=new ReferenciaBancariaLogic();
			referenciabancariaLogic_Desde_Cliente.setReferenciaBancarias(referenciabancarias);

			referenciabancariaLogic_Desde_Cliente.setConnexion(this.getConnexion());
			referenciabancariaLogic_Desde_Cliente.setDatosCliente(this.datosCliente);

			for(ReferenciaBancaria referenciabancaria_Desde_Cliente:referenciabancariaLogic_Desde_Cliente.getReferenciaBancarias()) {
				referenciabancaria_Desde_Cliente.setidcliente(idClienteActual);
			}

			referenciabancariaLogic_Desde_Cliente.saveReferenciaBancarias();

			BalanceGeneralClienteLogic balancegeneralclienteLogic_Desde_Cliente=new BalanceGeneralClienteLogic();
			balancegeneralclienteLogic_Desde_Cliente.setBalanceGeneralClientes(balancegeneralclientes);

			balancegeneralclienteLogic_Desde_Cliente.setConnexion(this.getConnexion());
			balancegeneralclienteLogic_Desde_Cliente.setDatosCliente(this.datosCliente);

			for(BalanceGeneralCliente balancegeneralcliente_Desde_Cliente:balancegeneralclienteLogic_Desde_Cliente.getBalanceGeneralClientes()) {
				balancegeneralcliente_Desde_Cliente.setid_cliente(idClienteActual);
			}

			balancegeneralclienteLogic_Desde_Cliente.saveBalanceGeneralClientes();

			DatoConstitucionLogic datoconstitucionLogic_Desde_Cliente=new DatoConstitucionLogic();
			datoconstitucionLogic_Desde_Cliente.setDatoConstitucions(datoconstitucions);

			datoconstitucionLogic_Desde_Cliente.setConnexion(this.getConnexion());
			datoconstitucionLogic_Desde_Cliente.setDatosCliente(this.datosCliente);

			for(DatoConstitucion datoconstitucion_Desde_Cliente:datoconstitucionLogic_Desde_Cliente.getDatoConstitucions()) {
				datoconstitucion_Desde_Cliente.setidcliente(idClienteActual);
			}

			datoconstitucionLogic_Desde_Cliente.saveDatoConstitucions();

			ActividadEconomicaLogic actividadeconomicaLogic_Desde_Cliente=new ActividadEconomicaLogic();
			actividadeconomicaLogic_Desde_Cliente.setActividadEconomicas(actividadeconomicas);

			actividadeconomicaLogic_Desde_Cliente.setConnexion(this.getConnexion());
			actividadeconomicaLogic_Desde_Cliente.setDatosCliente(this.datosCliente);

			for(ActividadEconomica actividadeconomica_Desde_Cliente:actividadeconomicaLogic_Desde_Cliente.getActividadEconomicas()) {
				actividadeconomica_Desde_Cliente.setid_cliente(idClienteActual);
			}

			actividadeconomicaLogic_Desde_Cliente.saveActividadEconomicas();

			ProveedorProductoLogic proveedorproductoLogic_Desde_Cliente=new ProveedorProductoLogic();
			proveedorproductoLogic_Desde_Cliente.setProveedorProductos(proveedorproductos);

			proveedorproductoLogic_Desde_Cliente.setConnexion(this.getConnexion());
			proveedorproductoLogic_Desde_Cliente.setDatosCliente(this.datosCliente);

			for(ProveedorProducto proveedorproducto_Desde_Cliente:proveedorproductoLogic_Desde_Cliente.getProveedorProductos()) {
				proveedorproducto_Desde_Cliente.setid_cliente(idClienteActual);
			}

			proveedorproductoLogic_Desde_Cliente.saveProveedorProductos();

			ConsignatarioLogic consignatarioLogic_Desde_Cliente=new ConsignatarioLogic();
			consignatarioLogic_Desde_Cliente.setConsignatarios(consignatarios);

			consignatarioLogic_Desde_Cliente.setConnexion(this.getConnexion());
			consignatarioLogic_Desde_Cliente.setDatosCliente(this.datosCliente);

			for(Consignatario consignatario_Desde_Cliente:consignatarioLogic_Desde_Cliente.getConsignatarios()) {
				consignatario_Desde_Cliente.setid_cliente(idClienteActual);

				consignatarioLogic_Desde_Cliente.setConsignatario(consignatario_Desde_Cliente);
				consignatarioLogic_Desde_Cliente.saveConsignatario();
			}


			HobbyClienteLogic hobbyclienteLogic_Desde_Cliente=new HobbyClienteLogic();
			hobbyclienteLogic_Desde_Cliente.setHobbyClientes(hobbyclientes);

			hobbyclienteLogic_Desde_Cliente.setConnexion(this.getConnexion());
			hobbyclienteLogic_Desde_Cliente.setDatosCliente(this.datosCliente);

			for(HobbyCliente hobbycliente_Desde_Cliente:hobbyclienteLogic_Desde_Cliente.getHobbyClientes()) {
				hobbycliente_Desde_Cliente.setid_cliente(idClienteActual);
			}

			hobbyclienteLogic_Desde_Cliente.saveHobbyClientes();

			RepresentanteLegalLogic representantelegalLogic_Desde_Cliente=new RepresentanteLegalLogic();
			representantelegalLogic_Desde_Cliente.setRepresentanteLegals(representantelegals);

			representantelegalLogic_Desde_Cliente.setConnexion(this.getConnexion());
			representantelegalLogic_Desde_Cliente.setDatosCliente(this.datosCliente);

			for(RepresentanteLegal representantelegal_Desde_Cliente:representantelegalLogic_Desde_Cliente.getRepresentanteLegals()) {
				representantelegal_Desde_Cliente.setidcliente(idClienteActual);
			}

			representantelegalLogic_Desde_Cliente.saveRepresentanteLegals();

			ClienteCoaLogic clientecoaLogic_Desde_Cliente=new ClienteCoaLogic();
			clientecoaLogic_Desde_Cliente.setClienteCoas(clientecoas);

			clientecoaLogic_Desde_Cliente.setConnexion(this.getConnexion());
			clientecoaLogic_Desde_Cliente.setDatosCliente(this.datosCliente);

			for(ClienteCoa clientecoa_Desde_Cliente:clientecoaLogic_Desde_Cliente.getClienteCoas()) {
				clientecoa_Desde_Cliente.setid_cliente(idClienteActual);
			}

			clientecoaLogic_Desde_Cliente.saveClienteCoas();

			DireccionLogic direccionLogic_Desde_Cliente=new DireccionLogic();
			direccionLogic_Desde_Cliente.setDireccions(direccions);

			direccionLogic_Desde_Cliente.setConnexion(this.getConnexion());
			direccionLogic_Desde_Cliente.setDatosCliente(this.datosCliente);

			for(Direccion direccion_Desde_Cliente:direccionLogic_Desde_Cliente.getDireccions()) {
				direccion_Desde_Cliente.setid_cliente(idClienteActual);
			}

			direccionLogic_Desde_Cliente.saveDireccions();

			ClienteImagenLogic clienteimagenLogic_Desde_Cliente=new ClienteImagenLogic();
			clienteimagenLogic_Desde_Cliente.setClienteImagens(clienteimagens);

			clienteimagenLogic_Desde_Cliente.setConnexion(this.getConnexion());
			clienteimagenLogic_Desde_Cliente.setDatosCliente(this.datosCliente);

			for(ClienteImagen clienteimagen_Desde_Cliente:clienteimagenLogic_Desde_Cliente.getClienteImagens()) {
				clienteimagen_Desde_Cliente.setid_cliente(idClienteActual);
			}

			clienteimagenLogic_Desde_Cliente.saveClienteImagens();

			SubClienteLogic subclienteLogic_Desde_Cliente=new SubClienteLogic();
			subclienteLogic_Desde_Cliente.setSubClientes(subclientes);

			subclienteLogic_Desde_Cliente.setConnexion(this.getConnexion());
			subclienteLogic_Desde_Cliente.setDatosCliente(this.datosCliente);

			for(SubCliente subcliente_Desde_Cliente:subclienteLogic_Desde_Cliente.getSubClientes()) {
				subcliente_Desde_Cliente.setid_cliente(idClienteActual);

				subclienteLogic_Desde_Cliente.setSubCliente(subcliente_Desde_Cliente);
				subclienteLogic_Desde_Cliente.saveSubCliente();
			}


			ServicioClienteLogic servicioclienteLogic_Desde_Cliente=new ServicioClienteLogic();
			servicioclienteLogic_Desde_Cliente.setServicioClientes(servicioclientes);

			servicioclienteLogic_Desde_Cliente.setConnexion(this.getConnexion());
			servicioclienteLogic_Desde_Cliente.setDatosCliente(this.datosCliente);

			for(ServicioCliente serviciocliente_Desde_Cliente:servicioclienteLogic_Desde_Cliente.getServicioClientes()) {
				serviciocliente_Desde_Cliente.setid_cliente(idClienteActual);
			}

			servicioclienteLogic_Desde_Cliente.saveServicioClientes();

			InformacionEconomicaLogic informacioneconomicaLogic_Desde_Cliente=new InformacionEconomicaLogic();
			informacioneconomicaLogic_Desde_Cliente.setInformacionEconomicas(informacioneconomicas);

			informacioneconomicaLogic_Desde_Cliente.setConnexion(this.getConnexion());
			informacioneconomicaLogic_Desde_Cliente.setDatosCliente(this.datosCliente);

			for(InformacionEconomica informacioneconomica_Desde_Cliente:informacioneconomicaLogic_Desde_Cliente.getInformacionEconomicas()) {
				informacioneconomica_Desde_Cliente.setidcliente(idClienteActual);
			}

			informacioneconomicaLogic_Desde_Cliente.saveInformacionEconomicas();

			VehiculoClienteLogic vehiculoclienteLogic_Desde_Cliente=new VehiculoClienteLogic();
			vehiculoclienteLogic_Desde_Cliente.setVehiculoClientes(vehiculoclientes);

			vehiculoclienteLogic_Desde_Cliente.setConnexion(this.getConnexion());
			vehiculoclienteLogic_Desde_Cliente.setDatosCliente(this.datosCliente);

			for(VehiculoCliente vehiculocliente_Desde_Cliente:vehiculoclienteLogic_Desde_Cliente.getVehiculoClientes()) {
				vehiculocliente_Desde_Cliente.setid_cliente(idClienteActual);
			}

			vehiculoclienteLogic_Desde_Cliente.saveVehiculoClientes();

			NegocioClienteLogic negocioclienteLogic_Desde_Cliente=new NegocioClienteLogic();
			negocioclienteLogic_Desde_Cliente.setNegocioClientes(negocioclientes);

			negocioclienteLogic_Desde_Cliente.setConnexion(this.getConnexion());
			negocioclienteLogic_Desde_Cliente.setDatosCliente(this.datosCliente);

			for(NegocioCliente negociocliente_Desde_Cliente:negocioclienteLogic_Desde_Cliente.getNegocioClientes()) {
				negociocliente_Desde_Cliente.setid_cliente(idClienteActual);
			}

			negocioclienteLogic_Desde_Cliente.saveNegocioClientes();

			MontoLogic montoLogic_Desde_Cliente=new MontoLogic();
			montoLogic_Desde_Cliente.setMontos(montos);

			montoLogic_Desde_Cliente.setConnexion(this.getConnexion());
			montoLogic_Desde_Cliente.setDatosCliente(this.datosCliente);

			for(Monto monto_Desde_Cliente:montoLogic_Desde_Cliente.getMontos()) {
				monto_Desde_Cliente.setid_cliente(idClienteActual);
			}

			montoLogic_Desde_Cliente.saveMontos();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ClienteConstantesFunciones.getClassesForeignKeysOfCliente(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ClienteConstantesFunciones.getClassesRelationshipsOfCliente(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

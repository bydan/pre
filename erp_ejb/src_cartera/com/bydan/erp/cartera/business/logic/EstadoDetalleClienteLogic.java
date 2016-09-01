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
import com.bydan.erp.cartera.util.EstadoDetalleClienteConstantesFunciones;
import com.bydan.erp.cartera.util.EstadoDetalleClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.EstadoDetalleClienteParameterGeneral;
import com.bydan.erp.cartera.business.entity.EstadoDetalleCliente;
import com.bydan.erp.cartera.business.logic.EstadoDetalleClienteLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class EstadoDetalleClienteLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoDetalleClienteLogic.class);
	
	protected EstadoDetalleClienteDataAccess estadodetalleclienteDataAccess; 	
	protected EstadoDetalleCliente estadodetallecliente;
	protected List<EstadoDetalleCliente> estadodetalleclientes;
	protected Object estadodetalleclienteObject;	
	protected List<Object> estadodetalleclientesObject;
	
	public static ClassValidator<EstadoDetalleCliente> estadodetalleclienteValidator = new ClassValidator<EstadoDetalleCliente>(EstadoDetalleCliente.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EstadoDetalleClienteLogicAdditional estadodetalleclienteLogicAdditional=null;
	
	public EstadoDetalleClienteLogicAdditional getEstadoDetalleClienteLogicAdditional() {
		return this.estadodetalleclienteLogicAdditional;
	}
	
	public void setEstadoDetalleClienteLogicAdditional(EstadoDetalleClienteLogicAdditional estadodetalleclienteLogicAdditional) {
		try {
			this.estadodetalleclienteLogicAdditional=estadodetalleclienteLogicAdditional;
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
	
	
	
	
	public  EstadoDetalleClienteLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadodetalleclienteDataAccess = new EstadoDetalleClienteDataAccess();
			
			this.estadodetalleclientes= new ArrayList<EstadoDetalleCliente>();
			this.estadodetallecliente= new EstadoDetalleCliente();
			
			this.estadodetalleclienteObject=new Object();
			this.estadodetalleclientesObject=new ArrayList<Object>();
				
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
			
			this.estadodetalleclienteDataAccess.setConnexionType(this.connexionType);
			this.estadodetalleclienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoDetalleClienteLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadodetalleclienteDataAccess = new EstadoDetalleClienteDataAccess();
			this.estadodetalleclientes= new ArrayList<EstadoDetalleCliente>();
			this.estadodetallecliente= new EstadoDetalleCliente();
			this.estadodetalleclienteObject=new Object();
			this.estadodetalleclientesObject=new ArrayList<Object>();
			
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
			
			this.estadodetalleclienteDataAccess.setConnexionType(this.connexionType);
			this.estadodetalleclienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoDetalleCliente getEstadoDetalleCliente() throws Exception {	
		EstadoDetalleClienteLogicAdditional.checkEstadoDetalleClienteToGet(estadodetallecliente,this.datosCliente,this.arrDatoGeneral);
		EstadoDetalleClienteLogicAdditional.updateEstadoDetalleClienteToGet(estadodetallecliente,this.arrDatoGeneral);
		
		return estadodetallecliente;
	}
		
	public void setEstadoDetalleCliente(EstadoDetalleCliente newEstadoDetalleCliente) {
		this.estadodetallecliente = newEstadoDetalleCliente;
	}
	
	public EstadoDetalleClienteDataAccess getEstadoDetalleClienteDataAccess() {
		return estadodetalleclienteDataAccess;
	}
	
	public void setEstadoDetalleClienteDataAccess(EstadoDetalleClienteDataAccess newestadodetalleclienteDataAccess) {
		this.estadodetalleclienteDataAccess = newestadodetalleclienteDataAccess;
	}
	
	public List<EstadoDetalleCliente> getEstadoDetalleClientes() throws Exception {		
		this.quitarEstadoDetalleClientesNulos();
		
		EstadoDetalleClienteLogicAdditional.checkEstadoDetalleClienteToGets(estadodetalleclientes,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoDetalleCliente estadodetalleclienteLocal: estadodetalleclientes ) {
			EstadoDetalleClienteLogicAdditional.updateEstadoDetalleClienteToGet(estadodetalleclienteLocal,this.arrDatoGeneral);
		}
		
		return estadodetalleclientes;
	}
	
	public void setEstadoDetalleClientes(List<EstadoDetalleCliente> newEstadoDetalleClientes) {
		this.estadodetalleclientes = newEstadoDetalleClientes;
	}
	
	public Object getEstadoDetalleClienteObject() {	
		this.estadodetalleclienteObject=this.estadodetalleclienteDataAccess.getEntityObject();
		return this.estadodetalleclienteObject;
	}
		
	public void setEstadoDetalleClienteObject(Object newEstadoDetalleClienteObject) {
		this.estadodetalleclienteObject = newEstadoDetalleClienteObject;
	}
	
	public List<Object> getEstadoDetalleClientesObject() {		
		this.estadodetalleclientesObject=this.estadodetalleclienteDataAccess.getEntitiesObject();
		return this.estadodetalleclientesObject;
	}
		
	public void setEstadoDetalleClientesObject(List<Object> newEstadoDetalleClientesObject) {
		this.estadodetalleclientesObject = newEstadoDetalleClientesObject;
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
		
		if(this.estadodetalleclienteDataAccess!=null) {
			this.estadodetalleclienteDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleCliente.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadodetalleclienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadodetalleclienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadodetallecliente = new  EstadoDetalleCliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadodetallecliente=estadodetalleclienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadodetallecliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoDetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleCliente(this.estadodetallecliente);
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
		estadodetallecliente = new  EstadoDetalleCliente();
		  		  
        try {
			
			estadodetallecliente=estadodetalleclienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadodetallecliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoDetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleCliente(this.estadodetallecliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadodetallecliente = new  EstadoDetalleCliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadodetallecliente=estadodetalleclienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadodetallecliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoDetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleCliente(this.estadodetallecliente);
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
		estadodetallecliente = new  EstadoDetalleCliente();
		  		  
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
		estadodetallecliente = new  EstadoDetalleCliente();
		  		  
        try {
			
			estadodetallecliente=estadodetalleclienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadodetallecliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoDetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleCliente(this.estadodetallecliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadodetallecliente = new  EstadoDetalleCliente();
		  		  
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
		estadodetallecliente = new  EstadoDetalleCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleCliente.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadodetalleclienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadodetallecliente = new  EstadoDetalleCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadodetalleclienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadodetallecliente = new  EstadoDetalleCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleCliente.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadodetalleclienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadodetallecliente = new  EstadoDetalleCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadodetalleclienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadodetallecliente = new  EstadoDetalleCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleCliente.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadodetalleclienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadodetallecliente = new  EstadoDetalleCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadodetalleclienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadodetalleclientes = new  ArrayList<EstadoDetalleCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoDetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleclientes=estadodetalleclienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoDetalleCliente(estadodetalleclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleCliente(this.estadodetalleclientes);
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
		estadodetalleclientes = new  ArrayList<EstadoDetalleCliente>();
		  		  
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
		estadodetalleclientes = new  ArrayList<EstadoDetalleCliente>();
		  		  
        try {			
			EstadoDetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleclientes=estadodetalleclienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoDetalleCliente(estadodetalleclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleCliente(this.estadodetalleclientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadodetalleclientes = new  ArrayList<EstadoDetalleCliente>();
		  		  
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
		estadodetalleclientes = new  ArrayList<EstadoDetalleCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoDetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleclientes=estadodetalleclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoDetalleCliente(estadodetalleclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleCliente(this.estadodetalleclientes);
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
		estadodetalleclientes = new  ArrayList<EstadoDetalleCliente>();
		  		  
        try {
			EstadoDetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleclientes=estadodetalleclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoDetalleCliente(estadodetalleclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleCliente(this.estadodetalleclientes);
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
		estadodetalleclientes = new  ArrayList<EstadoDetalleCliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleclientes=estadodetalleclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoDetalleCliente(estadodetalleclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleCliente(this.estadodetalleclientes);
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
		estadodetalleclientes = new  ArrayList<EstadoDetalleCliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleclientes=estadodetalleclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoDetalleCliente(estadodetalleclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleCliente(this.estadodetalleclientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadodetallecliente = new  EstadoDetalleCliente();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetallecliente=estadodetalleclienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoDetalleCliente(estadodetallecliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleCliente(this.estadodetallecliente);
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
		estadodetallecliente = new  EstadoDetalleCliente();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetallecliente=estadodetalleclienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoDetalleCliente(estadodetallecliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleCliente(this.estadodetallecliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadodetalleclientes = new  ArrayList<EstadoDetalleCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleCliente.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EstadoDetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleclientes=estadodetalleclienteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoDetalleCliente(estadodetalleclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleCliente(this.estadodetalleclientes);
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
		estadodetalleclientes = new  ArrayList<EstadoDetalleCliente>();
		  		  
        try {
			EstadoDetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleclientes=estadodetalleclienteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoDetalleCliente(estadodetalleclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleCliente(this.estadodetalleclientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEstadoDetalleClientesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadodetalleclientes = new  ArrayList<EstadoDetalleCliente>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleCliente.class.getSimpleName()+"-getTodosEstadoDetalleClientesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleclientes=estadodetalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoDetalleCliente(estadodetalleclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleCliente(this.estadodetalleclientes);
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
	
	public  void  getTodosEstadoDetalleClientes(String sFinalQuery,Pagination pagination)throws Exception {
		estadodetalleclientes = new  ArrayList<EstadoDetalleCliente>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoDetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadodetalleclientes=estadodetalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoDetalleCliente(estadodetalleclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoDetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleCliente(this.estadodetalleclientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoDetalleCliente(EstadoDetalleCliente estadodetallecliente) throws Exception {
		Boolean estaValidado=false;
		
		if(estadodetallecliente.getIsNew() || estadodetallecliente.getIsChanged()) { 
			this.invalidValues = estadodetalleclienteValidator.getInvalidValues(estadodetallecliente);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadodetallecliente);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoDetalleCliente(List<EstadoDetalleCliente> EstadoDetalleClientes) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoDetalleCliente estadodetalleclienteLocal:estadodetalleclientes) {				
			estaValidadoObjeto=this.validarGuardarEstadoDetalleCliente(estadodetalleclienteLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoDetalleCliente(List<EstadoDetalleCliente> EstadoDetalleClientes) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoDetalleCliente(estadodetalleclientes)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoDetalleCliente(EstadoDetalleCliente EstadoDetalleCliente) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoDetalleCliente(estadodetallecliente)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoDetalleCliente estadodetallecliente) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadodetallecliente.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoDetalleClienteConstantesFunciones.getEstadoDetalleClienteLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadodetallecliente","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoDetalleClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoDetalleClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoDetalleClienteWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleCliente.class.getSimpleName()+"-saveEstadoDetalleClienteWithConnection");connexion.begin();			
			
			EstadoDetalleClienteLogicAdditional.checkEstadoDetalleClienteToSave(this.estadodetallecliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoDetalleClienteLogicAdditional.updateEstadoDetalleClienteToSave(this.estadodetallecliente,this.arrDatoGeneral);
			
			EstadoDetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadodetallecliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoDetalleCliente();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoDetalleCliente(this.estadodetallecliente)) {
				EstadoDetalleClienteDataAccess.save(this.estadodetallecliente, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadodetallecliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoDetalleClienteLogicAdditional.checkEstadoDetalleClienteToSaveAfter(this.estadodetallecliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoDetalleCliente();
			
			connexion.commit();			
			
			if(this.estadodetallecliente.getIsDeleted()) {
				this.estadodetallecliente=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoDetalleCliente()throws Exception {	
		try {	
			
			EstadoDetalleClienteLogicAdditional.checkEstadoDetalleClienteToSave(this.estadodetallecliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoDetalleClienteLogicAdditional.updateEstadoDetalleClienteToSave(this.estadodetallecliente,this.arrDatoGeneral);
			
			EstadoDetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadodetallecliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoDetalleCliente(this.estadodetallecliente)) {			
				EstadoDetalleClienteDataAccess.save(this.estadodetallecliente, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadodetallecliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoDetalleClienteLogicAdditional.checkEstadoDetalleClienteToSaveAfter(this.estadodetallecliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadodetallecliente.getIsDeleted()) {
				this.estadodetallecliente=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoDetalleClientesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleCliente.class.getSimpleName()+"-saveEstadoDetalleClientesWithConnection");connexion.begin();			
			
			EstadoDetalleClienteLogicAdditional.checkEstadoDetalleClienteToSaves(estadodetalleclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoDetalleClientes();
			
			Boolean validadoTodosEstadoDetalleCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoDetalleCliente estadodetalleclienteLocal:estadodetalleclientes) {		
				if(estadodetalleclienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoDetalleClienteLogicAdditional.updateEstadoDetalleClienteToSave(estadodetalleclienteLocal,this.arrDatoGeneral);
	        	
				EstadoDetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadodetalleclienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoDetalleCliente(estadodetalleclienteLocal)) {
					EstadoDetalleClienteDataAccess.save(estadodetalleclienteLocal, connexion);				
				} else {
					validadoTodosEstadoDetalleCliente=false;
				}
			}
			
			if(!validadoTodosEstadoDetalleCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoDetalleClienteLogicAdditional.checkEstadoDetalleClienteToSavesAfter(estadodetalleclientes,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoDetalleClientes();
			
			connexion.commit();		
			
			this.quitarEstadoDetalleClientesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoDetalleClientes()throws Exception {				
		 try {	
			EstadoDetalleClienteLogicAdditional.checkEstadoDetalleClienteToSaves(estadodetalleclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoDetalleCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoDetalleCliente estadodetalleclienteLocal:estadodetalleclientes) {				
				if(estadodetalleclienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoDetalleClienteLogicAdditional.updateEstadoDetalleClienteToSave(estadodetalleclienteLocal,this.arrDatoGeneral);
	        	
				EstadoDetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadodetalleclienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoDetalleCliente(estadodetalleclienteLocal)) {				
					EstadoDetalleClienteDataAccess.save(estadodetalleclienteLocal, connexion);				
				} else {
					validadoTodosEstadoDetalleCliente=false;
				}
			}
			
			if(!validadoTodosEstadoDetalleCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoDetalleClienteLogicAdditional.checkEstadoDetalleClienteToSavesAfter(estadodetalleclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoDetalleClientesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoDetalleClienteParameterReturnGeneral procesarAccionEstadoDetalleClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoDetalleCliente> estadodetalleclientes,EstadoDetalleClienteParameterReturnGeneral estadodetalleclienteParameterGeneral)throws Exception {
		 try {	
			EstadoDetalleClienteParameterReturnGeneral estadodetalleclienteReturnGeneral=new EstadoDetalleClienteParameterReturnGeneral();
	
			EstadoDetalleClienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadodetalleclientes,estadodetalleclienteParameterGeneral,estadodetalleclienteReturnGeneral);
			
			return estadodetalleclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoDetalleClienteParameterReturnGeneral procesarAccionEstadoDetalleClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoDetalleCliente> estadodetalleclientes,EstadoDetalleClienteParameterReturnGeneral estadodetalleclienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleCliente.class.getSimpleName()+"-procesarAccionEstadoDetalleClientesWithConnection");connexion.begin();			
			
			EstadoDetalleClienteParameterReturnGeneral estadodetalleclienteReturnGeneral=new EstadoDetalleClienteParameterReturnGeneral();
	
			EstadoDetalleClienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadodetalleclientes,estadodetalleclienteParameterGeneral,estadodetalleclienteReturnGeneral);
			
			this.connexion.commit();
			
			return estadodetalleclienteReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoDetalleClienteParameterReturnGeneral procesarEventosEstadoDetalleClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoDetalleCliente> estadodetalleclientes,EstadoDetalleCliente estadodetallecliente,EstadoDetalleClienteParameterReturnGeneral estadodetalleclienteParameterGeneral,Boolean isEsNuevoEstadoDetalleCliente,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoDetalleClienteParameterReturnGeneral estadodetalleclienteReturnGeneral=new EstadoDetalleClienteParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadodetalleclienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoDetalleClienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadodetalleclientes,estadodetallecliente,estadodetalleclienteParameterGeneral,estadodetalleclienteReturnGeneral,isEsNuevoEstadoDetalleCliente,clases);
			
			return estadodetalleclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoDetalleClienteParameterReturnGeneral procesarEventosEstadoDetalleClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoDetalleCliente> estadodetalleclientes,EstadoDetalleCliente estadodetallecliente,EstadoDetalleClienteParameterReturnGeneral estadodetalleclienteParameterGeneral,Boolean isEsNuevoEstadoDetalleCliente,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleCliente.class.getSimpleName()+"-procesarEventosEstadoDetalleClientesWithConnection");connexion.begin();			
			
			EstadoDetalleClienteParameterReturnGeneral estadodetalleclienteReturnGeneral=new EstadoDetalleClienteParameterReturnGeneral();
	
			estadodetalleclienteReturnGeneral.setEstadoDetalleCliente(estadodetallecliente);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadodetalleclienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoDetalleClienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadodetalleclientes,estadodetallecliente,estadodetalleclienteParameterGeneral,estadodetalleclienteReturnGeneral,isEsNuevoEstadoDetalleCliente,clases);
			
			this.connexion.commit();
			
			return estadodetalleclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoDetalleClienteParameterReturnGeneral procesarImportacionEstadoDetalleClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoDetalleClienteParameterReturnGeneral estadodetalleclienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleCliente.class.getSimpleName()+"-procesarImportacionEstadoDetalleClientesWithConnection");connexion.begin();			
			
			EstadoDetalleClienteParameterReturnGeneral estadodetalleclienteReturnGeneral=new EstadoDetalleClienteParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadodetalleclientes=new ArrayList<EstadoDetalleCliente>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadodetallecliente=new EstadoDetalleCliente();
				
				
				if(conColumnasBase) {this.estadodetallecliente.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadodetallecliente.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadodetallecliente.setcodigo(arrColumnas[iColumn++]);
				this.estadodetallecliente.setnombre(arrColumnas[iColumn++]);
				
				this.estadodetalleclientes.add(this.estadodetallecliente);
			}
			
			this.saveEstadoDetalleClientes();
			
			this.connexion.commit();
			
			estadodetalleclienteReturnGeneral.setConRetornoEstaProcesado(true);
			estadodetalleclienteReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadodetalleclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoDetalleClientesEliminados() throws Exception {				
		
		List<EstadoDetalleCliente> estadodetalleclientesAux= new ArrayList<EstadoDetalleCliente>();
		
		for(EstadoDetalleCliente estadodetallecliente:estadodetalleclientes) {
			if(!estadodetallecliente.getIsDeleted()) {
				estadodetalleclientesAux.add(estadodetallecliente);
			}
		}
		
		estadodetalleclientes=estadodetalleclientesAux;
	}
	
	public void quitarEstadoDetalleClientesNulos() throws Exception {				
		
		List<EstadoDetalleCliente> estadodetalleclientesAux= new ArrayList<EstadoDetalleCliente>();
		
		for(EstadoDetalleCliente estadodetallecliente : this.estadodetalleclientes) {
			if(estadodetallecliente==null) {
				estadodetalleclientesAux.add(estadodetallecliente);
			}
		}
		
		//this.estadodetalleclientes=estadodetalleclientesAux;
		
		this.estadodetalleclientes.removeAll(estadodetalleclientesAux);
	}
	
	public void getSetVersionRowEstadoDetalleClienteWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadodetallecliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadodetallecliente.getIsDeleted() || (estadodetallecliente.getIsChanged()&&!estadodetallecliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadodetalleclienteDataAccess.getSetVersionRowEstadoDetalleCliente(connexion,estadodetallecliente.getId());
				
				if(!estadodetallecliente.getVersionRow().equals(timestamp)) {	
					estadodetallecliente.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadodetallecliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoDetalleCliente()throws Exception {	
		
		if(estadodetallecliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadodetallecliente.getIsDeleted() || (estadodetallecliente.getIsChanged()&&!estadodetallecliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadodetalleclienteDataAccess.getSetVersionRowEstadoDetalleCliente(connexion,estadodetallecliente.getId());
			
			try {							
				if(!estadodetallecliente.getVersionRow().equals(timestamp)) {	
					estadodetallecliente.setVersionRow(timestamp);
				}
				
				estadodetallecliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoDetalleClientesWithConnection()throws Exception {	
		if(estadodetalleclientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoDetalleCliente estadodetalleclienteAux:estadodetalleclientes) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadodetalleclienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadodetalleclienteAux.getIsDeleted() || (estadodetalleclienteAux.getIsChanged()&&!estadodetalleclienteAux.getIsNew())) {
						
						timestamp=estadodetalleclienteDataAccess.getSetVersionRowEstadoDetalleCliente(connexion,estadodetalleclienteAux.getId());
						
						if(!estadodetallecliente.getVersionRow().equals(timestamp)) {	
							estadodetalleclienteAux.setVersionRow(timestamp);
						}
								
						estadodetalleclienteAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoDetalleClientes()throws Exception {	
		if(estadodetalleclientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoDetalleCliente estadodetalleclienteAux:estadodetalleclientes) {
					if(estadodetalleclienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadodetalleclienteAux.getIsDeleted() || (estadodetalleclienteAux.getIsChanged()&&!estadodetalleclienteAux.getIsNew())) {
						
						timestamp=estadodetalleclienteDataAccess.getSetVersionRowEstadoDetalleCliente(connexion,estadodetalleclienteAux.getId());
						
						if(!estadodetalleclienteAux.getVersionRow().equals(timestamp)) {	
							estadodetalleclienteAux.setVersionRow(timestamp);
						}
						
													
						estadodetalleclienteAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyEstadoDetalleClienteWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleProveLogic detalleproveLogic=new DetalleProveLogic();
			DetalleMoviClienProveLogic detallemoviclienproveLogic=new DetalleMoviClienProveLogic();
			DetalleClienteLogic detalleclienteLogic=new DetalleClienteLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleCliente.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEstadoDetalleClienteWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleProve.class));
			classes.add(new Classe(DetalleMoviClienProve.class));
			classes.add(new Classe(DetalleCliente.class));
											
			

			detalleproveLogic.setConnexion(this.getConnexion());
			detalleproveLogic.setDatosCliente(this.datosCliente);
			detalleproveLogic.setIsConRefrescarForeignKeys(true);

			detallemoviclienproveLogic.setConnexion(this.getConnexion());
			detallemoviclienproveLogic.setDatosCliente(this.datosCliente);
			detallemoviclienproveLogic.setIsConRefrescarForeignKeys(true);

			detalleclienteLogic.setConnexion(this.getConnexion());
			detalleclienteLogic.setDatosCliente(this.datosCliente);
			detalleclienteLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(EstadoDetalleCliente estadodetallecliente:this.estadodetalleclientes) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleProveConstantesFunciones.getClassesForeignKeysOfDetalleProve(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalleproveLogic.setDetalleProves(estadodetallecliente.detalleproves);
				detalleproveLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DetalleMoviClienProveConstantesFunciones.getClassesForeignKeysOfDetalleMoviClienProve(new ArrayList<Classe>(),DeepLoadType.NONE);

				detallemoviclienproveLogic.setDetalleMoviClienProves(estadodetallecliente.detallemoviclienproves);
				detallemoviclienproveLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DetalleClienteConstantesFunciones.getClassesForeignKeysOfDetalleCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalleclienteLogic.setDetalleClientes(estadodetallecliente.detalleclientes);
				detalleclienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(EstadoDetalleCliente estadodetallecliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EstadoDetalleClienteLogicAdditional.updateEstadoDetalleClienteToGet(estadodetallecliente,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadodetallecliente.setDetalleProves(estadodetalleclienteDataAccess.getDetalleProves(connexion,estadodetallecliente));
		estadodetallecliente.setDetalleMoviClienProves(estadodetalleclienteDataAccess.getDetalleMoviClienProves(connexion,estadodetallecliente));
		estadodetallecliente.setDetalleClientes(estadodetalleclienteDataAccess.getDetalleClientes(connexion,estadodetallecliente));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleProve.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadodetallecliente.setDetalleProves(estadodetalleclienteDataAccess.getDetalleProves(connexion,estadodetallecliente));

				if(this.isConDeep) {
					DetalleProveLogic detalleproveLogic= new DetalleProveLogic(this.connexion);
					detalleproveLogic.setDetalleProves(estadodetallecliente.getDetalleProves());
					ArrayList<Classe> classesLocal=DetalleProveConstantesFunciones.getClassesForeignKeysOfDetalleProve(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalleproveLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleProve(detalleproveLogic.getDetalleProves());
					estadodetallecliente.setDetalleProves(detalleproveLogic.getDetalleProves());
				}

				continue;
			}

			if(clas.clas.equals(DetalleMoviClienProve.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadodetallecliente.setDetalleMoviClienProves(estadodetalleclienteDataAccess.getDetalleMoviClienProves(connexion,estadodetallecliente));

				if(this.isConDeep) {
					DetalleMoviClienProveLogic detallemoviclienproveLogic= new DetalleMoviClienProveLogic(this.connexion);
					detallemoviclienproveLogic.setDetalleMoviClienProves(estadodetallecliente.getDetalleMoviClienProves());
					ArrayList<Classe> classesLocal=DetalleMoviClienProveConstantesFunciones.getClassesForeignKeysOfDetalleMoviClienProve(new ArrayList<Classe>(),DeepLoadType.NONE);
					detallemoviclienproveLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleMoviClienProveConstantesFunciones.refrescarForeignKeysDescripcionesDetalleMoviClienProve(detallemoviclienproveLogic.getDetalleMoviClienProves());
					estadodetallecliente.setDetalleMoviClienProves(detallemoviclienproveLogic.getDetalleMoviClienProves());
				}

				continue;
			}

			if(clas.clas.equals(DetalleCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadodetallecliente.setDetalleClientes(estadodetalleclienteDataAccess.getDetalleClientes(connexion,estadodetallecliente));

				if(this.isConDeep) {
					DetalleClienteLogic detalleclienteLogic= new DetalleClienteLogic(this.connexion);
					detalleclienteLogic.setDetalleClientes(estadodetallecliente.getDetalleClientes());
					ArrayList<Classe> classesLocal=DetalleClienteConstantesFunciones.getClassesForeignKeysOfDetalleCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalleclienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(detalleclienteLogic.getDetalleClientes());
					estadodetallecliente.setDetalleClientes(detalleclienteLogic.getDetalleClientes());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleProve.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleProve.class));
			estadodetallecliente.setDetalleProves(estadodetalleclienteDataAccess.getDetalleProves(connexion,estadodetallecliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleMoviClienProve.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleMoviClienProve.class));
			estadodetallecliente.setDetalleMoviClienProves(estadodetalleclienteDataAccess.getDetalleMoviClienProves(connexion,estadodetallecliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleCliente.class));
			estadodetallecliente.setDetalleClientes(estadodetalleclienteDataAccess.getDetalleClientes(connexion,estadodetallecliente));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		estadodetallecliente.setDetalleProves(estadodetalleclienteDataAccess.getDetalleProves(connexion,estadodetallecliente));

		for(DetalleProve detalleprove:estadodetallecliente.getDetalleProves()) {
			DetalleProveLogic detalleproveLogic= new DetalleProveLogic(connexion);
			detalleproveLogic.deepLoad(detalleprove,isDeep,deepLoadType,clases);
		}

		estadodetallecliente.setDetalleMoviClienProves(estadodetalleclienteDataAccess.getDetalleMoviClienProves(connexion,estadodetallecliente));

		for(DetalleMoviClienProve detallemoviclienprove:estadodetallecliente.getDetalleMoviClienProves()) {
			DetalleMoviClienProveLogic detallemoviclienproveLogic= new DetalleMoviClienProveLogic(connexion);
			detallemoviclienproveLogic.deepLoad(detallemoviclienprove,isDeep,deepLoadType,clases);
		}

		estadodetallecliente.setDetalleClientes(estadodetalleclienteDataAccess.getDetalleClientes(connexion,estadodetallecliente));

		for(DetalleCliente detallecliente:estadodetallecliente.getDetalleClientes()) {
			DetalleClienteLogic detalleclienteLogic= new DetalleClienteLogic(connexion);
			detalleclienteLogic.deepLoad(detallecliente,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleProve.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadodetallecliente.setDetalleProves(estadodetalleclienteDataAccess.getDetalleProves(connexion,estadodetallecliente));

				for(DetalleProve detalleprove:estadodetallecliente.getDetalleProves()) {
					DetalleProveLogic detalleproveLogic= new DetalleProveLogic(connexion);
					detalleproveLogic.deepLoad(detalleprove,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleMoviClienProve.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadodetallecliente.setDetalleMoviClienProves(estadodetalleclienteDataAccess.getDetalleMoviClienProves(connexion,estadodetallecliente));

				for(DetalleMoviClienProve detallemoviclienprove:estadodetallecliente.getDetalleMoviClienProves()) {
					DetalleMoviClienProveLogic detallemoviclienproveLogic= new DetalleMoviClienProveLogic(connexion);
					detallemoviclienproveLogic.deepLoad(detallemoviclienprove,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadodetallecliente.setDetalleClientes(estadodetalleclienteDataAccess.getDetalleClientes(connexion,estadodetallecliente));

				for(DetalleCliente detallecliente:estadodetallecliente.getDetalleClientes()) {
					DetalleClienteLogic detalleclienteLogic= new DetalleClienteLogic(connexion);
					detalleclienteLogic.deepLoad(detallecliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleProve.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleProve.class));
			estadodetallecliente.setDetalleProves(estadodetalleclienteDataAccess.getDetalleProves(connexion,estadodetallecliente));

			for(DetalleProve detalleprove:estadodetallecliente.getDetalleProves()) {
				DetalleProveLogic detalleproveLogic= new DetalleProveLogic(connexion);
				detalleproveLogic.deepLoad(detalleprove,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleMoviClienProve.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleMoviClienProve.class));
			estadodetallecliente.setDetalleMoviClienProves(estadodetalleclienteDataAccess.getDetalleMoviClienProves(connexion,estadodetallecliente));

			for(DetalleMoviClienProve detallemoviclienprove:estadodetallecliente.getDetalleMoviClienProves()) {
				DetalleMoviClienProveLogic detallemoviclienproveLogic= new DetalleMoviClienProveLogic(connexion);
				detallemoviclienproveLogic.deepLoad(detallemoviclienprove,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleCliente.class));
			estadodetallecliente.setDetalleClientes(estadodetalleclienteDataAccess.getDetalleClientes(connexion,estadodetallecliente));

			for(DetalleCliente detallecliente:estadodetallecliente.getDetalleClientes()) {
				DetalleClienteLogic detalleclienteLogic= new DetalleClienteLogic(connexion);
				detalleclienteLogic.deepLoad(detallecliente,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoDetalleCliente estadodetallecliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EstadoDetalleClienteLogicAdditional.updateEstadoDetalleClienteToSave(estadodetallecliente,this.arrDatoGeneral);
			
EstadoDetalleClienteDataAccess.save(estadodetallecliente, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(DetalleProve detalleprove:estadodetallecliente.getDetalleProves()) {
			detalleprove.setid_estado_detalle_cliente(estadodetallecliente.getId());
			DetalleProveDataAccess.save(detalleprove,connexion);
		}

		for(DetalleMoviClienProve detallemoviclienprove:estadodetallecliente.getDetalleMoviClienProves()) {
			detallemoviclienprove.setid_estado_detalle_cliente(estadodetallecliente.getId());
			DetalleMoviClienProveDataAccess.save(detallemoviclienprove,connexion);
		}

		for(DetalleCliente detallecliente:estadodetallecliente.getDetalleClientes()) {
			detallecliente.setid_estado_detalle_cliente(estadodetallecliente.getId());
			DetalleClienteDataAccess.save(detallecliente,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(DetalleProve.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleProve detalleprove:estadodetallecliente.getDetalleProves()) {
					detalleprove.setid_estado_detalle_cliente(estadodetallecliente.getId());
					DetalleProveDataAccess.save(detalleprove,connexion);
				}
				continue;
			}

			if(clas.clas.equals(DetalleMoviClienProve.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleMoviClienProve detallemoviclienprove:estadodetallecliente.getDetalleMoviClienProves()) {
					detallemoviclienprove.setid_estado_detalle_cliente(estadodetallecliente.getId());
					DetalleMoviClienProveDataAccess.save(detallemoviclienprove,connexion);
				}
				continue;
			}

			if(clas.clas.equals(DetalleCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleCliente detallecliente:estadodetallecliente.getDetalleClientes()) {
					detallecliente.setid_estado_detalle_cliente(estadodetallecliente.getId());
					DetalleClienteDataAccess.save(detallecliente,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(DetalleProve detalleprove:estadodetallecliente.getDetalleProves()) {
			DetalleProveLogic detalleproveLogic= new DetalleProveLogic(connexion);
			detalleprove.setid_estado_detalle_cliente(estadodetallecliente.getId());
			DetalleProveDataAccess.save(detalleprove,connexion);
			detalleproveLogic.deepSave(detalleprove,isDeep,deepLoadType,clases);
		}

		for(DetalleMoviClienProve detallemoviclienprove:estadodetallecliente.getDetalleMoviClienProves()) {
			DetalleMoviClienProveLogic detallemoviclienproveLogic= new DetalleMoviClienProveLogic(connexion);
			detallemoviclienprove.setid_estado_detalle_cliente(estadodetallecliente.getId());
			DetalleMoviClienProveDataAccess.save(detallemoviclienprove,connexion);
			detallemoviclienproveLogic.deepSave(detallemoviclienprove,isDeep,deepLoadType,clases);
		}

		for(DetalleCliente detallecliente:estadodetallecliente.getDetalleClientes()) {
			DetalleClienteLogic detalleclienteLogic= new DetalleClienteLogic(connexion);
			detallecliente.setid_estado_detalle_cliente(estadodetallecliente.getId());
			DetalleClienteDataAccess.save(detallecliente,connexion);
			detalleclienteLogic.deepSave(detallecliente,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(DetalleProve.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleProve detalleprove:estadodetallecliente.getDetalleProves()) {
					DetalleProveLogic detalleproveLogic= new DetalleProveLogic(connexion);
					detalleprove.setid_estado_detalle_cliente(estadodetallecliente.getId());
					DetalleProveDataAccess.save(detalleprove,connexion);
					detalleproveLogic.deepSave(detalleprove,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleMoviClienProve.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleMoviClienProve detallemoviclienprove:estadodetallecliente.getDetalleMoviClienProves()) {
					DetalleMoviClienProveLogic detallemoviclienproveLogic= new DetalleMoviClienProveLogic(connexion);
					detallemoviclienprove.setid_estado_detalle_cliente(estadodetallecliente.getId());
					DetalleMoviClienProveDataAccess.save(detallemoviclienprove,connexion);
					detallemoviclienproveLogic.deepSave(detallemoviclienprove,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleCliente detallecliente:estadodetallecliente.getDetalleClientes()) {
					DetalleClienteLogic detalleclienteLogic= new DetalleClienteLogic(connexion);
					detallecliente.setid_estado_detalle_cliente(estadodetallecliente.getId());
					DetalleClienteDataAccess.save(detallecliente,connexion);
					detalleclienteLogic.deepSave(detallecliente,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(EstadoDetalleCliente.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadodetallecliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoDetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleCliente(estadodetallecliente);
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
			this.deepLoad(this.estadodetallecliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoDetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleCliente(this.estadodetallecliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoDetalleCliente.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadodetalleclientes!=null) {
				for(EstadoDetalleCliente estadodetallecliente:estadodetalleclientes) {
					this.deepLoad(estadodetallecliente,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoDetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleCliente(estadodetalleclientes);
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
			if(estadodetalleclientes!=null) {
				for(EstadoDetalleCliente estadodetallecliente:estadodetalleclientes) {
					this.deepLoad(estadodetallecliente,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoDetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleCliente(estadodetalleclientes);
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
			this.getNewConnexionToDeep(EstadoDetalleCliente.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(estadodetallecliente,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(EstadoDetalleCliente.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(estadodetalleclientes!=null) {
				for(EstadoDetalleCliente estadodetallecliente:estadodetalleclientes) {
					this.deepSave(estadodetallecliente,isDeep,deepLoadType,clases);
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
			if(estadodetalleclientes!=null) {
				for(EstadoDetalleCliente estadodetallecliente:estadodetalleclientes) {
					this.deepSave(estadodetallecliente,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getEstadoDetalleClientePorCodigoWithConnection(String codigo)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoDetalleCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,EstadoDetalleClienteConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			estadodetallecliente=estadodetalleclienteDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.estadodetallecliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				EstadoDetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleCliente(this.estadodetallecliente);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEstadoDetalleClientePorCodigo(String codigo)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,EstadoDetalleClienteConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			estadodetallecliente=estadodetalleclienteDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.estadodetallecliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				EstadoDetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesEstadoDetalleCliente(this.estadodetallecliente);
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
			if(EstadoDetalleClienteConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoDetalleClienteDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoDetalleCliente estadodetallecliente,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoDetalleClienteConstantesFunciones.ISCONAUDITORIA) {
				if(estadodetallecliente.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoDetalleClienteDataAccess.TABLENAME, estadodetallecliente.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoDetalleClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoDetalleClienteLogic.registrarAuditoriaDetallesEstadoDetalleCliente(connexion,estadodetallecliente,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadodetallecliente.getIsDeleted()) {
					/*if(!estadodetallecliente.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoDetalleClienteDataAccess.TABLENAME, estadodetallecliente.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoDetalleClienteLogic.registrarAuditoriaDetallesEstadoDetalleCliente(connexion,estadodetallecliente,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoDetalleClienteDataAccess.TABLENAME, estadodetallecliente.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadodetallecliente.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoDetalleClienteDataAccess.TABLENAME, estadodetallecliente.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoDetalleClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoDetalleClienteLogic.registrarAuditoriaDetallesEstadoDetalleCliente(connexion,estadodetallecliente,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoDetalleCliente(Connexion connexion,EstadoDetalleCliente estadodetallecliente)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadodetallecliente.getIsNew()||!estadodetallecliente.getcodigo().equals(estadodetallecliente.getEstadoDetalleClienteOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadodetallecliente.getEstadoDetalleClienteOriginal().getcodigo()!=null)
				{
					strValorActual=estadodetallecliente.getEstadoDetalleClienteOriginal().getcodigo();
				}
				if(estadodetallecliente.getcodigo()!=null)
				{
					strValorNuevo=estadodetallecliente.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoDetalleClienteConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(estadodetallecliente.getIsNew()||!estadodetallecliente.getnombre().equals(estadodetallecliente.getEstadoDetalleClienteOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadodetallecliente.getEstadoDetalleClienteOriginal().getnombre()!=null)
				{
					strValorActual=estadodetallecliente.getEstadoDetalleClienteOriginal().getnombre();
				}
				if(estadodetallecliente.getnombre()!=null)
				{
					strValorNuevo=estadodetallecliente.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoDetalleClienteConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEstadoDetalleClienteRelacionesWithConnection(EstadoDetalleCliente estadodetallecliente,List<DetalleProve> detalleproves,List<DetalleMoviClienProve> detallemoviclienproves,List<DetalleCliente> detalleclientes) throws Exception {

		if(!estadodetallecliente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoDetalleClienteRelacionesBase(estadodetallecliente,detalleproves,detallemoviclienproves,detalleclientes,true);
		}
	}

	public void saveEstadoDetalleClienteRelaciones(EstadoDetalleCliente estadodetallecliente,List<DetalleProve> detalleproves,List<DetalleMoviClienProve> detallemoviclienproves,List<DetalleCliente> detalleclientes)throws Exception {

		if(!estadodetallecliente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoDetalleClienteRelacionesBase(estadodetallecliente,detalleproves,detallemoviclienproves,detalleclientes,false);
		}
	}

	public void saveEstadoDetalleClienteRelacionesBase(EstadoDetalleCliente estadodetallecliente,List<DetalleProve> detalleproves,List<DetalleMoviClienProve> detallemoviclienproves,List<DetalleCliente> detalleclientes,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("EstadoDetalleCliente-saveRelacionesWithConnection");}
	
			estadodetallecliente.setDetalleProves(detalleproves);
			estadodetallecliente.setDetalleMoviClienProves(detallemoviclienproves);
			estadodetallecliente.setDetalleClientes(detalleclientes);

			this.setEstadoDetalleCliente(estadodetallecliente);

			if(EstadoDetalleClienteLogicAdditional.validarSaveRelaciones(estadodetallecliente,this)) {

				EstadoDetalleClienteLogicAdditional.updateRelacionesToSave(estadodetallecliente,this);

				if((estadodetallecliente.getIsNew()||estadodetallecliente.getIsChanged())&&!estadodetallecliente.getIsDeleted()) {
					this.saveEstadoDetalleCliente();
					this.saveEstadoDetalleClienteRelacionesDetalles(detalleproves,detallemoviclienproves,detalleclientes);

				} else if(estadodetallecliente.getIsDeleted()) {
					this.saveEstadoDetalleClienteRelacionesDetalles(detalleproves,detallemoviclienproves,detalleclientes);
					this.saveEstadoDetalleCliente();
				}

				EstadoDetalleClienteLogicAdditional.updateRelacionesToSaveAfter(estadodetallecliente,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetalleProveConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleProves(detalleproves,true,true);
			DetalleMoviClienProveConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleMoviClienProves(detallemoviclienproves,true,true);
			DetalleClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleClientes(detalleclientes,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveEstadoDetalleClienteRelacionesDetalles(List<DetalleProve> detalleproves,List<DetalleMoviClienProve> detallemoviclienproves,List<DetalleCliente> detalleclientes)throws Exception {
		try {
	

			Long idEstadoDetalleClienteActual=this.getEstadoDetalleCliente().getId();

			DetalleProveLogic detalleproveLogic_Desde_EstadoDetalleCliente=new DetalleProveLogic();
			detalleproveLogic_Desde_EstadoDetalleCliente.setDetalleProves(detalleproves);

			detalleproveLogic_Desde_EstadoDetalleCliente.setConnexion(this.getConnexion());
			detalleproveLogic_Desde_EstadoDetalleCliente.setDatosCliente(this.datosCliente);

			for(DetalleProve detalleprove_Desde_EstadoDetalleCliente:detalleproveLogic_Desde_EstadoDetalleCliente.getDetalleProves()) {
				detalleprove_Desde_EstadoDetalleCliente.setid_estado_detalle_cliente(idEstadoDetalleClienteActual);

				detalleproveLogic_Desde_EstadoDetalleCliente.setDetalleProve(detalleprove_Desde_EstadoDetalleCliente);
				detalleproveLogic_Desde_EstadoDetalleCliente.saveDetalleProve();

				Long idDetalleProveActual=detalleprove_Desde_EstadoDetalleCliente.getId();

				PagoAutoLogic pagoautoLogic_Desde_DetalleProve=new PagoAutoLogic();

				if(detalleprove_Desde_EstadoDetalleCliente.getPagoAutos()==null){
					detalleprove_Desde_EstadoDetalleCliente.setPagoAutos(new ArrayList<PagoAuto>());
				}

				pagoautoLogic_Desde_DetalleProve.setPagoAutos(detalleprove_Desde_EstadoDetalleCliente.getPagoAutos());

				pagoautoLogic_Desde_DetalleProve.setConnexion(this.getConnexion());
				pagoautoLogic_Desde_DetalleProve.setDatosCliente(this.datosCliente);

				for(PagoAuto pagoauto_Desde_DetalleProve:pagoautoLogic_Desde_DetalleProve.getPagoAutos()) {
					pagoauto_Desde_DetalleProve.setid_detalle_prove(idDetalleProveActual);
				}

				pagoautoLogic_Desde_DetalleProve.savePagoAutos();

				AutoriPagoLogic autoripagoLogic_Desde_DetalleProve=new AutoriPagoLogic();

				if(detalleprove_Desde_EstadoDetalleCliente.getAutoriPagos()==null){
					detalleprove_Desde_EstadoDetalleCliente.setAutoriPagos(new ArrayList<AutoriPago>());
				}

				autoripagoLogic_Desde_DetalleProve.setAutoriPagos(detalleprove_Desde_EstadoDetalleCliente.getAutoriPagos());

				autoripagoLogic_Desde_DetalleProve.setConnexion(this.getConnexion());
				autoripagoLogic_Desde_DetalleProve.setDatosCliente(this.datosCliente);

				for(AutoriPago autoripago_Desde_DetalleProve:autoripagoLogic_Desde_DetalleProve.getAutoriPagos()) {
					autoripago_Desde_DetalleProve.setid_detalle_prove(idDetalleProveActual);
				}

				autoripagoLogic_Desde_DetalleProve.saveAutoriPagos();
			}


			DetalleMoviClienProveLogic detallemoviclienproveLogic_Desde_EstadoDetalleCliente=new DetalleMoviClienProveLogic();
			detallemoviclienproveLogic_Desde_EstadoDetalleCliente.setDetalleMoviClienProves(detallemoviclienproves);

			detallemoviclienproveLogic_Desde_EstadoDetalleCliente.setConnexion(this.getConnexion());
			detallemoviclienproveLogic_Desde_EstadoDetalleCliente.setDatosCliente(this.datosCliente);

			for(DetalleMoviClienProve detallemoviclienprove_Desde_EstadoDetalleCliente:detallemoviclienproveLogic_Desde_EstadoDetalleCliente.getDetalleMoviClienProves()) {
				detallemoviclienprove_Desde_EstadoDetalleCliente.setid_estado_detalle_cliente(idEstadoDetalleClienteActual);
			}

			detallemoviclienproveLogic_Desde_EstadoDetalleCliente.saveDetalleMoviClienProves();

			DetalleClienteLogic detalleclienteLogic_Desde_EstadoDetalleCliente=new DetalleClienteLogic();
			detalleclienteLogic_Desde_EstadoDetalleCliente.setDetalleClientes(detalleclientes);

			detalleclienteLogic_Desde_EstadoDetalleCliente.setConnexion(this.getConnexion());
			detalleclienteLogic_Desde_EstadoDetalleCliente.setDatosCliente(this.datosCliente);

			for(DetalleCliente detallecliente_Desde_EstadoDetalleCliente:detalleclienteLogic_Desde_EstadoDetalleCliente.getDetalleClientes()) {
				detallecliente_Desde_EstadoDetalleCliente.setid_estado_detalle_cliente(idEstadoDetalleClienteActual);

				detalleclienteLogic_Desde_EstadoDetalleCliente.setDetalleCliente(detallecliente_Desde_EstadoDetalleCliente);
				detalleclienteLogic_Desde_EstadoDetalleCliente.saveDetalleCliente();

				Long idDetalleClienteActual=detallecliente_Desde_EstadoDetalleCliente.getId();

				DetalleRecapLogic detallerecapLogic_Desde_DetalleCliente=new DetalleRecapLogic();

				if(detallecliente_Desde_EstadoDetalleCliente.getDetalleRecaps()==null){
					detallecliente_Desde_EstadoDetalleCliente.setDetalleRecaps(new ArrayList<DetalleRecap>());
				}

				detallerecapLogic_Desde_DetalleCliente.setDetalleRecaps(detallecliente_Desde_EstadoDetalleCliente.getDetalleRecaps());

				detallerecapLogic_Desde_DetalleCliente.setConnexion(this.getConnexion());
				detallerecapLogic_Desde_DetalleCliente.setDatosCliente(this.datosCliente);

				for(DetalleRecap detallerecap_Desde_DetalleCliente:detallerecapLogic_Desde_DetalleCliente.getDetalleRecaps()) {
					detallerecap_Desde_DetalleCliente.setid_detalle_cliente(idDetalleClienteActual);
				}

				detallerecapLogic_Desde_DetalleCliente.saveDetalleRecaps();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoDetalleCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoDetalleClienteConstantesFunciones.getClassesForeignKeysOfEstadoDetalleCliente(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoDetalleCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoDetalleClienteConstantesFunciones.getClassesRelationshipsOfEstadoDetalleCliente(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

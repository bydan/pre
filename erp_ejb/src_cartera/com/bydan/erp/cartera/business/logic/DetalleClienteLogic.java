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
import com.bydan.erp.cartera.util.DetalleClienteConstantesFunciones;
import com.bydan.erp.cartera.util.DetalleClienteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.DetalleClienteParameterGeneral;
import com.bydan.erp.cartera.business.entity.DetalleCliente;
import com.bydan.erp.cartera.business.logic.DetalleClienteLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;








@SuppressWarnings("unused")
public class DetalleClienteLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetalleClienteLogic.class);
	
	protected DetalleClienteDataAccess detalleclienteDataAccess; 	
	protected DetalleCliente detallecliente;
	protected List<DetalleCliente> detalleclientes;
	protected Object detalleclienteObject;	
	protected List<Object> detalleclientesObject;
	
	public static ClassValidator<DetalleCliente> detalleclienteValidator = new ClassValidator<DetalleCliente>(DetalleCliente.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetalleClienteLogicAdditional detalleclienteLogicAdditional=null;
	
	public DetalleClienteLogicAdditional getDetalleClienteLogicAdditional() {
		return this.detalleclienteLogicAdditional;
	}
	
	public void setDetalleClienteLogicAdditional(DetalleClienteLogicAdditional detalleclienteLogicAdditional) {
		try {
			this.detalleclienteLogicAdditional=detalleclienteLogicAdditional;
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
	
	
	
	
	public  DetalleClienteLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detalleclienteDataAccess = new DetalleClienteDataAccess();
			
			this.detalleclientes= new ArrayList<DetalleCliente>();
			this.detallecliente= new DetalleCliente();
			
			this.detalleclienteObject=new Object();
			this.detalleclientesObject=new ArrayList<Object>();
				
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
			
			this.detalleclienteDataAccess.setConnexionType(this.connexionType);
			this.detalleclienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetalleClienteLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detalleclienteDataAccess = new DetalleClienteDataAccess();
			this.detalleclientes= new ArrayList<DetalleCliente>();
			this.detallecliente= new DetalleCliente();
			this.detalleclienteObject=new Object();
			this.detalleclientesObject=new ArrayList<Object>();
			
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
			
			this.detalleclienteDataAccess.setConnexionType(this.connexionType);
			this.detalleclienteDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetalleCliente getDetalleCliente() throws Exception {	
		DetalleClienteLogicAdditional.checkDetalleClienteToGet(detallecliente,this.datosCliente,this.arrDatoGeneral);
		DetalleClienteLogicAdditional.updateDetalleClienteToGet(detallecliente,this.arrDatoGeneral);
		
		return detallecliente;
	}
		
	public void setDetalleCliente(DetalleCliente newDetalleCliente) {
		this.detallecliente = newDetalleCliente;
	}
	
	public DetalleClienteDataAccess getDetalleClienteDataAccess() {
		return detalleclienteDataAccess;
	}
	
	public void setDetalleClienteDataAccess(DetalleClienteDataAccess newdetalleclienteDataAccess) {
		this.detalleclienteDataAccess = newdetalleclienteDataAccess;
	}
	
	public List<DetalleCliente> getDetalleClientes() throws Exception {		
		this.quitarDetalleClientesNulos();
		
		DetalleClienteLogicAdditional.checkDetalleClienteToGets(detalleclientes,this.datosCliente,this.arrDatoGeneral);
		
		for (DetalleCliente detalleclienteLocal: detalleclientes ) {
			DetalleClienteLogicAdditional.updateDetalleClienteToGet(detalleclienteLocal,this.arrDatoGeneral);
		}
		
		return detalleclientes;
	}
	
	public void setDetalleClientes(List<DetalleCliente> newDetalleClientes) {
		this.detalleclientes = newDetalleClientes;
	}
	
	public Object getDetalleClienteObject() {	
		this.detalleclienteObject=this.detalleclienteDataAccess.getEntityObject();
		return this.detalleclienteObject;
	}
		
	public void setDetalleClienteObject(Object newDetalleClienteObject) {
		this.detalleclienteObject = newDetalleClienteObject;
	}
	
	public List<Object> getDetalleClientesObject() {		
		this.detalleclientesObject=this.detalleclienteDataAccess.getEntitiesObject();
		return this.detalleclientesObject;
	}
		
	public void setDetalleClientesObject(List<Object> newDetalleClientesObject) {
		this.detalleclientesObject = newDetalleClientesObject;
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
		
		if(this.detalleclienteDataAccess!=null) {
			this.detalleclienteDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCliente.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detalleclienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detalleclienteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detallecliente = new  DetalleCliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallecliente=detalleclienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallecliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detallecliente);
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
		detallecliente = new  DetalleCliente();
		  		  
        try {
			
			detallecliente=detalleclienteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallecliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detallecliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detallecliente = new  DetalleCliente();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detallecliente=detalleclienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallecliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detallecliente);
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
		detallecliente = new  DetalleCliente();
		  		  
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
		detallecliente = new  DetalleCliente();
		  		  
        try {
			
			detallecliente=detalleclienteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detallecliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detallecliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detallecliente = new  DetalleCliente();
		  		  
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
		detallecliente = new  DetalleCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCliente.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detalleclienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallecliente = new  DetalleCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detalleclienteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallecliente = new  DetalleCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCliente.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detalleclienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallecliente = new  DetalleCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detalleclienteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detallecliente = new  DetalleCliente();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCliente.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detalleclienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detallecliente = new  DetalleCliente();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detalleclienteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleclientes = new  ArrayList<DetalleCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleclientes=detalleclienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleCliente(detalleclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
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
		detalleclientes = new  ArrayList<DetalleCliente>();
		  		  
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
		detalleclientes = new  ArrayList<DetalleCliente>();
		  		  
        try {			
			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleclientes=detalleclienteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetalleCliente(detalleclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detalleclientes = new  ArrayList<DetalleCliente>();
		  		  
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
		detalleclientes = new  ArrayList<DetalleCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleclientes=detalleclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleCliente(detalleclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
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
		detalleclientes = new  ArrayList<DetalleCliente>();
		  		  
        try {
			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleclientes=detalleclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleCliente(detalleclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
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
		detalleclientes = new  ArrayList<DetalleCliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCliente.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleclientes=detalleclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleCliente(detalleclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
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
		detalleclientes = new  ArrayList<DetalleCliente>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleclientes=detalleclienteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleCliente(detalleclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detallecliente = new  DetalleCliente();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCliente.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecliente=detalleclienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleCliente(detallecliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detallecliente);
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
		detallecliente = new  DetalleCliente();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detallecliente=detalleclienteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleCliente(detallecliente);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detallecliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleclientes = new  ArrayList<DetalleCliente>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCliente.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleclientes=detalleclienteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleCliente(detalleclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
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
		detalleclientes = new  ArrayList<DetalleCliente>();
		  		  
        try {
			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleclientes=detalleclienteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleCliente(detalleclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetalleClientesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detalleclientes = new  ArrayList<DetalleCliente>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCliente.class.getSimpleName()+"-getTodosDetalleClientesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleclientes=detalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleCliente(detalleclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
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
	
	public  void  getTodosDetalleClientes(String sFinalQuery,Pagination pagination)throws Exception {
		detalleclientes = new  ArrayList<DetalleCliente>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleclientes=detalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleCliente(detalleclientes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetalleCliente(DetalleCliente detallecliente) throws Exception {
		Boolean estaValidado=false;
		
		if(detallecliente.getIsNew() || detallecliente.getIsChanged()) { 
			this.invalidValues = detalleclienteValidator.getInvalidValues(detallecliente);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detallecliente);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetalleCliente(List<DetalleCliente> DetalleClientes) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetalleCliente detalleclienteLocal:detalleclientes) {				
			estaValidadoObjeto=this.validarGuardarDetalleCliente(detalleclienteLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetalleCliente(List<DetalleCliente> DetalleClientes) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleCliente(detalleclientes)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetalleCliente(DetalleCliente DetalleCliente) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleCliente(detallecliente)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetalleCliente detallecliente) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detallecliente.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetalleClienteConstantesFunciones.getDetalleClienteLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detallecliente","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetalleClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetalleClienteConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetalleClienteWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCliente.class.getSimpleName()+"-saveDetalleClienteWithConnection");connexion.begin();			
			
			DetalleClienteLogicAdditional.checkDetalleClienteToSave(this.detallecliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleClienteLogicAdditional.updateDetalleClienteToSave(this.detallecliente,this.arrDatoGeneral);
			
			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallecliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetalleCliente();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleCliente(this.detallecliente)) {
				DetalleClienteDataAccess.save(this.detallecliente, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detallecliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleClienteLogicAdditional.checkDetalleClienteToSaveAfter(this.detallecliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleCliente();
			
			connexion.commit();			
			
			if(this.detallecliente.getIsDeleted()) {
				this.detallecliente=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetalleCliente()throws Exception {	
		try {	
			
			DetalleClienteLogicAdditional.checkDetalleClienteToSave(this.detallecliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleClienteLogicAdditional.updateDetalleClienteToSave(this.detallecliente,this.arrDatoGeneral);
			
			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detallecliente,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleCliente(this.detallecliente)) {			
				DetalleClienteDataAccess.save(this.detallecliente, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detallecliente,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleClienteLogicAdditional.checkDetalleClienteToSaveAfter(this.detallecliente,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detallecliente.getIsDeleted()) {
				this.detallecliente=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetalleClientesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCliente.class.getSimpleName()+"-saveDetalleClientesWithConnection");connexion.begin();			
			
			DetalleClienteLogicAdditional.checkDetalleClienteToSaves(detalleclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetalleClientes();
			
			Boolean validadoTodosDetalleCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleCliente detalleclienteLocal:detalleclientes) {		
				if(detalleclienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleClienteLogicAdditional.updateDetalleClienteToSave(detalleclienteLocal,this.arrDatoGeneral);
	        	
				DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleclienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleCliente(detalleclienteLocal)) {
					DetalleClienteDataAccess.save(detalleclienteLocal, connexion);				
				} else {
					validadoTodosDetalleCliente=false;
				}
			}
			
			if(!validadoTodosDetalleCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleClienteLogicAdditional.checkDetalleClienteToSavesAfter(detalleclientes,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleClientes();
			
			connexion.commit();		
			
			this.quitarDetalleClientesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetalleClientes()throws Exception {				
		 try {	
			DetalleClienteLogicAdditional.checkDetalleClienteToSaves(detalleclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetalleCliente=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleCliente detalleclienteLocal:detalleclientes) {				
				if(detalleclienteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleClienteLogicAdditional.updateDetalleClienteToSave(detalleclienteLocal,this.arrDatoGeneral);
	        	
				DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleclienteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleCliente(detalleclienteLocal)) {				
					DetalleClienteDataAccess.save(detalleclienteLocal, connexion);				
				} else {
					validadoTodosDetalleCliente=false;
				}
			}
			
			if(!validadoTodosDetalleCliente) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleClienteLogicAdditional.checkDetalleClienteToSavesAfter(detalleclientes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetalleClientesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleClienteParameterReturnGeneral procesarAccionDetalleClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleCliente> detalleclientes,DetalleClienteParameterReturnGeneral detalleclienteParameterGeneral)throws Exception {
		 try {	
			DetalleClienteParameterReturnGeneral detalleclienteReturnGeneral=new DetalleClienteParameterReturnGeneral();
	
			DetalleClienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleclientes,detalleclienteParameterGeneral,detalleclienteReturnGeneral);
			
			return detalleclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleClienteParameterReturnGeneral procesarAccionDetalleClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleCliente> detalleclientes,DetalleClienteParameterReturnGeneral detalleclienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCliente.class.getSimpleName()+"-procesarAccionDetalleClientesWithConnection");connexion.begin();			
			
			DetalleClienteParameterReturnGeneral detalleclienteReturnGeneral=new DetalleClienteParameterReturnGeneral();
	
			DetalleClienteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleclientes,detalleclienteParameterGeneral,detalleclienteReturnGeneral);
			
			this.connexion.commit();
			
			return detalleclienteReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleClienteParameterReturnGeneral procesarEventosDetalleClientes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleCliente> detalleclientes,DetalleCliente detallecliente,DetalleClienteParameterReturnGeneral detalleclienteParameterGeneral,Boolean isEsNuevoDetalleCliente,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetalleClienteParameterReturnGeneral detalleclienteReturnGeneral=new DetalleClienteParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleclienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleClienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleclientes,detallecliente,detalleclienteParameterGeneral,detalleclienteReturnGeneral,isEsNuevoDetalleCliente,clases);
			
			return detalleclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetalleClienteParameterReturnGeneral procesarEventosDetalleClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleCliente> detalleclientes,DetalleCliente detallecliente,DetalleClienteParameterReturnGeneral detalleclienteParameterGeneral,Boolean isEsNuevoDetalleCliente,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCliente.class.getSimpleName()+"-procesarEventosDetalleClientesWithConnection");connexion.begin();			
			
			DetalleClienteParameterReturnGeneral detalleclienteReturnGeneral=new DetalleClienteParameterReturnGeneral();
	
			detalleclienteReturnGeneral.setDetalleCliente(detallecliente);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleclienteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleClienteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleclientes,detallecliente,detalleclienteParameterGeneral,detalleclienteReturnGeneral,isEsNuevoDetalleCliente,clases);
			
			this.connexion.commit();
			
			return detalleclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleClienteParameterReturnGeneral procesarImportacionDetalleClientesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetalleClienteParameterReturnGeneral detalleclienteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCliente.class.getSimpleName()+"-procesarImportacionDetalleClientesWithConnection");connexion.begin();			
			
			DetalleClienteParameterReturnGeneral detalleclienteReturnGeneral=new DetalleClienteParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detalleclientes=new ArrayList<DetalleCliente>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detallecliente=new DetalleCliente();
				
				
				if(conColumnasBase) {this.detallecliente.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detallecliente.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detallecliente.setnumero_factura(arrColumnas[iColumn++]);
				this.detallecliente.setfecha_vence(Funciones.ConvertToDate(arrColumnas[iColumn++]));
			this.detallecliente.setdescripcion(arrColumnas[iColumn++]);
				this.detallecliente.setdebito_mone_local(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallecliente.setcredito_mone_local(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallecliente.setdebito_mone_extra(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallecliente.setcredito_mone_extra(Double.parseDouble(arrColumnas[iColumn++]));
				this.detallecliente.setcotizacion(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.detalleclientes.add(this.detallecliente);
			}
			
			this.saveDetalleClientes();
			
			this.connexion.commit();
			
			detalleclienteReturnGeneral.setConRetornoEstaProcesado(true);
			detalleclienteReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detalleclienteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetalleClientesEliminados() throws Exception {				
		
		List<DetalleCliente> detalleclientesAux= new ArrayList<DetalleCliente>();
		
		for(DetalleCliente detallecliente:detalleclientes) {
			if(!detallecliente.getIsDeleted()) {
				detalleclientesAux.add(detallecliente);
			}
		}
		
		detalleclientes=detalleclientesAux;
	}
	
	public void quitarDetalleClientesNulos() throws Exception {				
		
		List<DetalleCliente> detalleclientesAux= new ArrayList<DetalleCliente>();
		
		for(DetalleCliente detallecliente : this.detalleclientes) {
			if(detallecliente==null) {
				detalleclientesAux.add(detallecliente);
			}
		}
		
		//this.detalleclientes=detalleclientesAux;
		
		this.detalleclientes.removeAll(detalleclientesAux);
	}
	
	public void getSetVersionRowDetalleClienteWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detallecliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detallecliente.getIsDeleted() || (detallecliente.getIsChanged()&&!detallecliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detalleclienteDataAccess.getSetVersionRowDetalleCliente(connexion,detallecliente.getId());
				
				if(!detallecliente.getVersionRow().equals(timestamp)) {	
					detallecliente.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detallecliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetalleCliente()throws Exception {	
		
		if(detallecliente.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detallecliente.getIsDeleted() || (detallecliente.getIsChanged()&&!detallecliente.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detalleclienteDataAccess.getSetVersionRowDetalleCliente(connexion,detallecliente.getId());
			
			try {							
				if(!detallecliente.getVersionRow().equals(timestamp)) {	
					detallecliente.setVersionRow(timestamp);
				}
				
				detallecliente.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetalleClientesWithConnection()throws Exception {	
		if(detalleclientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetalleCliente detalleclienteAux:detalleclientes) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detalleclienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleclienteAux.getIsDeleted() || (detalleclienteAux.getIsChanged()&&!detalleclienteAux.getIsNew())) {
						
						timestamp=detalleclienteDataAccess.getSetVersionRowDetalleCliente(connexion,detalleclienteAux.getId());
						
						if(!detallecliente.getVersionRow().equals(timestamp)) {	
							detalleclienteAux.setVersionRow(timestamp);
						}
								
						detalleclienteAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetalleClientes()throws Exception {	
		if(detalleclientes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetalleCliente detalleclienteAux:detalleclientes) {
					if(detalleclienteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleclienteAux.getIsDeleted() || (detalleclienteAux.getIsChanged()&&!detalleclienteAux.getIsNew())) {
						
						timestamp=detalleclienteDataAccess.getSetVersionRowDetalleCliente(connexion,detalleclienteAux.getId());
						
						if(!detalleclienteAux.getVersionRow().equals(timestamp)) {	
							detalleclienteAux.setVersionRow(timestamp);
						}
						
													
						detalleclienteAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetalleClienteParameterReturnGeneral cargarCombosLoteForeignKeyDetalleClienteWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalModulo,String finalQueryGlobalAsientoContable,String finalQueryGlobalCliente,String finalQueryGlobalTransaccion,String finalQueryGlobalFactura,String finalQueryGlobalMoneda,String finalQueryGlobalSucursalMovimiento,String finalQueryGlobalTipoTransaccionModulo,String finalQueryGlobalEstadoDetalleCliente) throws Exception {
		DetalleClienteParameterReturnGeneral  detalleclienteReturnGeneral =new DetalleClienteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCliente.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetalleClienteWithConnection");connexion.begin();
			
			detalleclienteReturnGeneral =new DetalleClienteParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalleclienteReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detalleclienteReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detalleclienteReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detalleclienteReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detalleclienteReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detalleclienteReturnGeneral.setmessForeignKey(messForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			detalleclienteReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			detalleclienteReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			detalleclienteReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Transaccion> transaccionsForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			transaccionLogic.setConnexion(this.connexion);
			transaccionLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion.equals("NONE")) {
				transaccionLogic.getTodosTransaccions(finalQueryGlobalTransaccion,new Pagination());
				transaccionsForeignKey=transaccionLogic.getTransaccions();
			}

			detalleclienteReturnGeneral.settransaccionsForeignKey(transaccionsForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			detalleclienteReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			detalleclienteReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Sucursal> sucursalmovimientosForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalmovimientoLogic=new SucursalLogic();
			sucursalmovimientoLogic.setConnexion(this.connexion);
			sucursalmovimientoLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursalMovimiento.equals("NONE")) {
				sucursalmovimientoLogic.getTodosSucursals(finalQueryGlobalSucursalMovimiento,new Pagination());
				sucursalmovimientosForeignKey=sucursalmovimientoLogic.getSucursals();
			}

			detalleclienteReturnGeneral.setsucursalmovimientosForeignKey(sucursalmovimientosForeignKey);


			List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic=new TipoTransaccionModuloLogic();
			tipotransaccionmoduloLogic.setConnexion(this.connexion);
			tipotransaccionmoduloLogic.getTipoTransaccionModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTransaccionModulo.equals("NONE")) {
				tipotransaccionmoduloLogic.getTodosTipoTransaccionModulos(finalQueryGlobalTipoTransaccionModulo,new Pagination());
				tipotransaccionmodulosForeignKey=tipotransaccionmoduloLogic.getTipoTransaccionModulos();
			}

			detalleclienteReturnGeneral.settipotransaccionmodulosForeignKey(tipotransaccionmodulosForeignKey);


			List<EstadoDetalleCliente> estadodetalleclientesForeignKey=new ArrayList<EstadoDetalleCliente>();
			EstadoDetalleClienteLogic estadodetalleclienteLogic=new EstadoDetalleClienteLogic();
			estadodetalleclienteLogic.setConnexion(this.connexion);
			estadodetalleclienteLogic.getEstadoDetalleClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoDetalleCliente.equals("NONE")) {
				estadodetalleclienteLogic.getTodosEstadoDetalleClientes(finalQueryGlobalEstadoDetalleCliente,new Pagination());
				estadodetalleclientesForeignKey=estadodetalleclienteLogic.getEstadoDetalleClientes();
			}

			detalleclienteReturnGeneral.setestadodetalleclientesForeignKey(estadodetalleclientesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detalleclienteReturnGeneral;
	}
	
	public DetalleClienteParameterReturnGeneral cargarCombosLoteForeignKeyDetalleCliente(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalModulo,String finalQueryGlobalAsientoContable,String finalQueryGlobalCliente,String finalQueryGlobalTransaccion,String finalQueryGlobalFactura,String finalQueryGlobalMoneda,String finalQueryGlobalSucursalMovimiento,String finalQueryGlobalTipoTransaccionModulo,String finalQueryGlobalEstadoDetalleCliente) throws Exception {
		DetalleClienteParameterReturnGeneral  detalleclienteReturnGeneral =new DetalleClienteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detalleclienteReturnGeneral =new DetalleClienteParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalleclienteReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detalleclienteReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detalleclienteReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detalleclienteReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detalleclienteReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detalleclienteReturnGeneral.setmessForeignKey(messForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			detalleclienteReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			detalleclienteReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			detalleclienteReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Transaccion> transaccionsForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			transaccionLogic.setConnexion(this.connexion);
			transaccionLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion.equals("NONE")) {
				transaccionLogic.getTodosTransaccions(finalQueryGlobalTransaccion,new Pagination());
				transaccionsForeignKey=transaccionLogic.getTransaccions();
			}

			detalleclienteReturnGeneral.settransaccionsForeignKey(transaccionsForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			detalleclienteReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			detalleclienteReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<Sucursal> sucursalmovimientosForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalmovimientoLogic=new SucursalLogic();
			sucursalmovimientoLogic.setConnexion(this.connexion);
			sucursalmovimientoLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursalMovimiento.equals("NONE")) {
				sucursalmovimientoLogic.getTodosSucursals(finalQueryGlobalSucursalMovimiento,new Pagination());
				sucursalmovimientosForeignKey=sucursalmovimientoLogic.getSucursals();
			}

			detalleclienteReturnGeneral.setsucursalmovimientosForeignKey(sucursalmovimientosForeignKey);


			List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic=new TipoTransaccionModuloLogic();
			tipotransaccionmoduloLogic.setConnexion(this.connexion);
			tipotransaccionmoduloLogic.getTipoTransaccionModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTransaccionModulo.equals("NONE")) {
				tipotransaccionmoduloLogic.getTodosTipoTransaccionModulos(finalQueryGlobalTipoTransaccionModulo,new Pagination());
				tipotransaccionmodulosForeignKey=tipotransaccionmoduloLogic.getTipoTransaccionModulos();
			}

			detalleclienteReturnGeneral.settipotransaccionmodulosForeignKey(tipotransaccionmodulosForeignKey);


			List<EstadoDetalleCliente> estadodetalleclientesForeignKey=new ArrayList<EstadoDetalleCliente>();
			EstadoDetalleClienteLogic estadodetalleclienteLogic=new EstadoDetalleClienteLogic();
			estadodetalleclienteLogic.setConnexion(this.connexion);
			estadodetalleclienteLogic.getEstadoDetalleClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoDetalleCliente.equals("NONE")) {
				estadodetalleclienteLogic.getTodosEstadoDetalleClientes(finalQueryGlobalEstadoDetalleCliente,new Pagination());
				estadodetalleclientesForeignKey=estadodetalleclienteLogic.getEstadoDetalleClientes();
			}

			detalleclienteReturnGeneral.setestadodetalleclientesForeignKey(estadodetalleclientesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detalleclienteReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyDetalleClienteWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleRecapLogic detallerecapLogic=new DetalleRecapLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCliente.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyDetalleClienteWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleRecap.class));
											
			

			detallerecapLogic.setConnexion(this.getConnexion());
			detallerecapLogic.setDatosCliente(this.datosCliente);
			detallerecapLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(DetalleCliente detallecliente:this.detalleclientes) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleRecapConstantesFunciones.getClassesForeignKeysOfDetalleRecap(new ArrayList<Classe>(),DeepLoadType.NONE);

				detallerecapLogic.setDetalleRecaps(detallecliente.detallerecaps);
				detallerecapLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(DetalleCliente detallecliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetalleClienteLogicAdditional.updateDetalleClienteToGet(detallecliente,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallecliente.setEmpresa(detalleclienteDataAccess.getEmpresa(connexion,detallecliente));
		detallecliente.setSucursal(detalleclienteDataAccess.getSucursal(connexion,detallecliente));
		detallecliente.setEjercicio(detalleclienteDataAccess.getEjercicio(connexion,detallecliente));
		detallecliente.setPeriodo(detalleclienteDataAccess.getPeriodo(connexion,detallecliente));
		detallecliente.setAnio(detalleclienteDataAccess.getAnio(connexion,detallecliente));
		detallecliente.setMes(detalleclienteDataAccess.getMes(connexion,detallecliente));
		detallecliente.setModulo(detalleclienteDataAccess.getModulo(connexion,detallecliente));
		detallecliente.setAsientoContable(detalleclienteDataAccess.getAsientoContable(connexion,detallecliente));
		detallecliente.setCliente(detalleclienteDataAccess.getCliente(connexion,detallecliente));
		detallecliente.setTransaccion(detalleclienteDataAccess.getTransaccion(connexion,detallecliente));
		detallecliente.setFactura(detalleclienteDataAccess.getFactura(connexion,detallecliente));
		detallecliente.setMoneda(detalleclienteDataAccess.getMoneda(connexion,detallecliente));
		detallecliente.setSucursalMovimiento(detalleclienteDataAccess.getSucursalMovimiento(connexion,detallecliente));
		detallecliente.setTipoTransaccionModulo(detalleclienteDataAccess.getTipoTransaccionModulo(connexion,detallecliente));
		detallecliente.setEstadoDetalleCliente(detalleclienteDataAccess.getEstadoDetalleCliente(connexion,detallecliente));
		detallecliente.setDetalleRecaps(detalleclienteDataAccess.getDetalleRecaps(connexion,detallecliente));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detallecliente.setEmpresa(detalleclienteDataAccess.getEmpresa(connexion,detallecliente));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallecliente.setSucursal(detalleclienteDataAccess.getSucursal(connexion,detallecliente));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detallecliente.setEjercicio(detalleclienteDataAccess.getEjercicio(connexion,detallecliente));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detallecliente.setPeriodo(detalleclienteDataAccess.getPeriodo(connexion,detallecliente));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detallecliente.setAnio(detalleclienteDataAccess.getAnio(connexion,detallecliente));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detallecliente.setMes(detalleclienteDataAccess.getMes(connexion,detallecliente));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				detallecliente.setModulo(detalleclienteDataAccess.getModulo(connexion,detallecliente));
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				detallecliente.setAsientoContable(detalleclienteDataAccess.getAsientoContable(connexion,detallecliente));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				detallecliente.setCliente(detalleclienteDataAccess.getCliente(connexion,detallecliente));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				detallecliente.setTransaccion(detalleclienteDataAccess.getTransaccion(connexion,detallecliente));
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				detallecliente.setFactura(detalleclienteDataAccess.getFactura(connexion,detallecliente));
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				detallecliente.setMoneda(detalleclienteDataAccess.getMoneda(connexion,detallecliente));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallecliente.setSucursalMovimiento(detalleclienteDataAccess.getSucursalMovimiento(connexion,detallecliente));
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				detallecliente.setTipoTransaccionModulo(detalleclienteDataAccess.getTipoTransaccionModulo(connexion,detallecliente));
				continue;
			}

			if(clas.clas.equals(EstadoDetalleCliente.class)) {
				detallecliente.setEstadoDetalleCliente(detalleclienteDataAccess.getEstadoDetalleCliente(connexion,detallecliente));
				continue;
			}

			if(clas.clas.equals(DetalleRecap.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				detallecliente.setDetalleRecaps(detalleclienteDataAccess.getDetalleRecaps(connexion,detallecliente));

				if(this.isConDeep) {
					DetalleRecapLogic detallerecapLogic= new DetalleRecapLogic(this.connexion);
					detallerecapLogic.setDetalleRecaps(detallecliente.getDetalleRecaps());
					ArrayList<Classe> classesLocal=DetalleRecapConstantesFunciones.getClassesForeignKeysOfDetalleRecap(new ArrayList<Classe>(),DeepLoadType.NONE);
					detallerecapLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleRecapConstantesFunciones.refrescarForeignKeysDescripcionesDetalleRecap(detallerecapLogic.getDetalleRecaps());
					detallecliente.setDetalleRecaps(detallerecapLogic.getDetalleRecaps());
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
			detallecliente.setEmpresa(detalleclienteDataAccess.getEmpresa(connexion,detallecliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecliente.setSucursal(detalleclienteDataAccess.getSucursal(connexion,detallecliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecliente.setEjercicio(detalleclienteDataAccess.getEjercicio(connexion,detallecliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecliente.setPeriodo(detalleclienteDataAccess.getPeriodo(connexion,detallecliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecliente.setAnio(detalleclienteDataAccess.getAnio(connexion,detallecliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecliente.setMes(detalleclienteDataAccess.getMes(connexion,detallecliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecliente.setModulo(detalleclienteDataAccess.getModulo(connexion,detallecliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecliente.setAsientoContable(detalleclienteDataAccess.getAsientoContable(connexion,detallecliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecliente.setCliente(detalleclienteDataAccess.getCliente(connexion,detallecliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecliente.setTransaccion(detalleclienteDataAccess.getTransaccion(connexion,detallecliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecliente.setFactura(detalleclienteDataAccess.getFactura(connexion,detallecliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecliente.setMoneda(detalleclienteDataAccess.getMoneda(connexion,detallecliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecliente.setSucursalMovimiento(detalleclienteDataAccess.getSucursalMovimiento(connexion,detallecliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecliente.setTipoTransaccionModulo(detalleclienteDataAccess.getTipoTransaccionModulo(connexion,detallecliente));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoDetalleCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecliente.setEstadoDetalleCliente(detalleclienteDataAccess.getEstadoDetalleCliente(connexion,detallecliente));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleRecap.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleRecap.class));
			detallecliente.setDetalleRecaps(detalleclienteDataAccess.getDetalleRecaps(connexion,detallecliente));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detallecliente.setEmpresa(detalleclienteDataAccess.getEmpresa(connexion,detallecliente));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detallecliente.getEmpresa(),isDeep,deepLoadType,clases);
				
		detallecliente.setSucursal(detalleclienteDataAccess.getSucursal(connexion,detallecliente));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detallecliente.getSucursal(),isDeep,deepLoadType,clases);
				
		detallecliente.setEjercicio(detalleclienteDataAccess.getEjercicio(connexion,detallecliente));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detallecliente.getEjercicio(),isDeep,deepLoadType,clases);
				
		detallecliente.setPeriodo(detalleclienteDataAccess.getPeriodo(connexion,detallecliente));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detallecliente.getPeriodo(),isDeep,deepLoadType,clases);
				
		detallecliente.setAnio(detalleclienteDataAccess.getAnio(connexion,detallecliente));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detallecliente.getAnio(),isDeep,deepLoadType,clases);
				
		detallecliente.setMes(detalleclienteDataAccess.getMes(connexion,detallecliente));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detallecliente.getMes(),isDeep,deepLoadType,clases);
				
		detallecliente.setModulo(detalleclienteDataAccess.getModulo(connexion,detallecliente));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(detallecliente.getModulo(),isDeep,deepLoadType,clases);
				
		detallecliente.setAsientoContable(detalleclienteDataAccess.getAsientoContable(connexion,detallecliente));
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(detallecliente.getAsientoContable(),isDeep,deepLoadType,clases);
				
		detallecliente.setCliente(detalleclienteDataAccess.getCliente(connexion,detallecliente));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(detallecliente.getCliente(),isDeep,deepLoadType,clases);
				
		detallecliente.setTransaccion(detalleclienteDataAccess.getTransaccion(connexion,detallecliente));
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(detallecliente.getTransaccion(),isDeep,deepLoadType,clases);
				
		detallecliente.setFactura(detalleclienteDataAccess.getFactura(connexion,detallecliente));
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(detallecliente.getFactura(),isDeep,deepLoadType,clases);
				
		detallecliente.setMoneda(detalleclienteDataAccess.getMoneda(connexion,detallecliente));
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(detallecliente.getMoneda(),isDeep,deepLoadType,clases);
				
		detallecliente.setSucursalMovimiento(detalleclienteDataAccess.getSucursalMovimiento(connexion,detallecliente));
		SucursalLogic sucursalmovimientoLogic= new SucursalLogic(connexion);
		sucursalmovimientoLogic.deepLoad(detallecliente.getSucursalMovimiento(),isDeep,deepLoadType,clases);
				
		detallecliente.setTipoTransaccionModulo(detalleclienteDataAccess.getTipoTransaccionModulo(connexion,detallecliente));
		TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
		tipotransaccionmoduloLogic.deepLoad(detallecliente.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				
		detallecliente.setEstadoDetalleCliente(detalleclienteDataAccess.getEstadoDetalleCliente(connexion,detallecliente));
		EstadoDetalleClienteLogic estadodetalleclienteLogic= new EstadoDetalleClienteLogic(connexion);
		estadodetalleclienteLogic.deepLoad(detallecliente.getEstadoDetalleCliente(),isDeep,deepLoadType,clases);
				

		detallecliente.setDetalleRecaps(detalleclienteDataAccess.getDetalleRecaps(connexion,detallecliente));

		for(DetalleRecap detallerecap:detallecliente.getDetalleRecaps()) {
			DetalleRecapLogic detallerecapLogic= new DetalleRecapLogic(connexion);
			detallerecapLogic.deepLoad(detallerecap,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detallecliente.setEmpresa(detalleclienteDataAccess.getEmpresa(connexion,detallecliente));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detallecliente.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallecliente.setSucursal(detalleclienteDataAccess.getSucursal(connexion,detallecliente));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detallecliente.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detallecliente.setEjercicio(detalleclienteDataAccess.getEjercicio(connexion,detallecliente));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(detallecliente.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detallecliente.setPeriodo(detalleclienteDataAccess.getPeriodo(connexion,detallecliente));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(detallecliente.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detallecliente.setAnio(detalleclienteDataAccess.getAnio(connexion,detallecliente));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(detallecliente.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detallecliente.setMes(detalleclienteDataAccess.getMes(connexion,detallecliente));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(detallecliente.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				detallecliente.setModulo(detalleclienteDataAccess.getModulo(connexion,detallecliente));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(detallecliente.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				detallecliente.setAsientoContable(detalleclienteDataAccess.getAsientoContable(connexion,detallecliente));
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepLoad(detallecliente.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				detallecliente.setCliente(detalleclienteDataAccess.getCliente(connexion,detallecliente));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(detallecliente.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				detallecliente.setTransaccion(detalleclienteDataAccess.getTransaccion(connexion,detallecliente));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(detallecliente.getTransaccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				detallecliente.setFactura(detalleclienteDataAccess.getFactura(connexion,detallecliente));
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepLoad(detallecliente.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				detallecliente.setMoneda(detalleclienteDataAccess.getMoneda(connexion,detallecliente));
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepLoad(detallecliente.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detallecliente.setSucursalMovimiento(detalleclienteDataAccess.getSucursalMovimiento(connexion,detallecliente));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detallecliente.getSucursalMovimiento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				detallecliente.setTipoTransaccionModulo(detalleclienteDataAccess.getTipoTransaccionModulo(connexion,detallecliente));
				TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
				tipotransaccionmoduloLogic.deepLoad(detallecliente.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoDetalleCliente.class)) {
				detallecliente.setEstadoDetalleCliente(detalleclienteDataAccess.getEstadoDetalleCliente(connexion,detallecliente));
				EstadoDetalleClienteLogic estadodetalleclienteLogic= new EstadoDetalleClienteLogic(connexion);
				estadodetalleclienteLogic.deepLoad(detallecliente.getEstadoDetalleCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleRecap.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				detallecliente.setDetalleRecaps(detalleclienteDataAccess.getDetalleRecaps(connexion,detallecliente));

				for(DetalleRecap detallerecap:detallecliente.getDetalleRecaps()) {
					DetalleRecapLogic detallerecapLogic= new DetalleRecapLogic(connexion);
					detallerecapLogic.deepLoad(detallerecap,isDeep,deepLoadType,clases);
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
			detallecliente.setEmpresa(detalleclienteDataAccess.getEmpresa(connexion,detallecliente));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detallecliente.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecliente.setSucursal(detalleclienteDataAccess.getSucursal(connexion,detallecliente));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detallecliente.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecliente.setEjercicio(detalleclienteDataAccess.getEjercicio(connexion,detallecliente));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(detallecliente.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecliente.setPeriodo(detalleclienteDataAccess.getPeriodo(connexion,detallecliente));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(detallecliente.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecliente.setAnio(detalleclienteDataAccess.getAnio(connexion,detallecliente));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(detallecliente.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecliente.setMes(detalleclienteDataAccess.getMes(connexion,detallecliente));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(detallecliente.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecliente.setModulo(detalleclienteDataAccess.getModulo(connexion,detallecliente));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(detallecliente.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecliente.setAsientoContable(detalleclienteDataAccess.getAsientoContable(connexion,detallecliente));
			AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
			asientocontableLogic.deepLoad(detallecliente.getAsientoContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecliente.setCliente(detalleclienteDataAccess.getCliente(connexion,detallecliente));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(detallecliente.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecliente.setTransaccion(detalleclienteDataAccess.getTransaccion(connexion,detallecliente));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(detallecliente.getTransaccion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecliente.setFactura(detalleclienteDataAccess.getFactura(connexion,detallecliente));
			FacturaLogic facturaLogic= new FacturaLogic(connexion);
			facturaLogic.deepLoad(detallecliente.getFactura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecliente.setMoneda(detalleclienteDataAccess.getMoneda(connexion,detallecliente));
			MonedaLogic monedaLogic= new MonedaLogic(connexion);
			monedaLogic.deepLoad(detallecliente.getMoneda(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecliente.setSucursalMovimiento(detalleclienteDataAccess.getSucursalMovimiento(connexion,detallecliente));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detallecliente.getSucursalMovimiento(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecliente.setTipoTransaccionModulo(detalleclienteDataAccess.getTipoTransaccionModulo(connexion,detallecliente));
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
			tipotransaccionmoduloLogic.deepLoad(detallecliente.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoDetalleCliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detallecliente.setEstadoDetalleCliente(detalleclienteDataAccess.getEstadoDetalleCliente(connexion,detallecliente));
			EstadoDetalleClienteLogic estadodetalleclienteLogic= new EstadoDetalleClienteLogic(connexion);
			estadodetalleclienteLogic.deepLoad(detallecliente.getEstadoDetalleCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleRecap.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleRecap.class));
			detallecliente.setDetalleRecaps(detalleclienteDataAccess.getDetalleRecaps(connexion,detallecliente));

			for(DetalleRecap detallerecap:detallecliente.getDetalleRecaps()) {
				DetalleRecapLogic detallerecapLogic= new DetalleRecapLogic(connexion);
				detallerecapLogic.deepLoad(detallerecap,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetalleCliente detallecliente,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetalleClienteLogicAdditional.updateDetalleClienteToSave(detallecliente,this.arrDatoGeneral);
			
DetalleClienteDataAccess.save(detallecliente, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detallecliente.getEmpresa(),connexion);

		SucursalDataAccess.save(detallecliente.getSucursal(),connexion);

		EjercicioDataAccess.save(detallecliente.getEjercicio(),connexion);

		PeriodoDataAccess.save(detallecliente.getPeriodo(),connexion);

		AnioDataAccess.save(detallecliente.getAnio(),connexion);

		MesDataAccess.save(detallecliente.getMes(),connexion);

		ModuloDataAccess.save(detallecliente.getModulo(),connexion);

		AsientoContableDataAccess.save(detallecliente.getAsientoContable(),connexion);

		ClienteDataAccess.save(detallecliente.getCliente(),connexion);

		TransaccionDataAccess.save(detallecliente.getTransaccion(),connexion);

		FacturaDataAccess.save(detallecliente.getFactura(),connexion);

		MonedaDataAccess.save(detallecliente.getMoneda(),connexion);

		SucursalDataAccess.save(detallecliente.getSucursalMovimiento(),connexion);

		TipoTransaccionModuloDataAccess.save(detallecliente.getTipoTransaccionModulo(),connexion);

		EstadoDetalleClienteDataAccess.save(detallecliente.getEstadoDetalleCliente(),connexion);

		for(DetalleRecap detallerecap:detallecliente.getDetalleRecaps()) {
			detallerecap.setid_detalle_cliente(detallecliente.getId());
			DetalleRecapDataAccess.save(detallerecap,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detallecliente.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detallecliente.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detallecliente.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detallecliente.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detallecliente.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detallecliente.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(detallecliente.getModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(detallecliente.getAsientoContable(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(detallecliente.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(detallecliente.getTransaccion(),connexion);
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(detallecliente.getFactura(),connexion);
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(detallecliente.getMoneda(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detallecliente.getSucursalMovimiento(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				TipoTransaccionModuloDataAccess.save(detallecliente.getTipoTransaccionModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoDetalleCliente.class)) {
				EstadoDetalleClienteDataAccess.save(detallecliente.getEstadoDetalleCliente(),connexion);
				continue;
			}


			if(clas.clas.equals(DetalleRecap.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleRecap detallerecap:detallecliente.getDetalleRecaps()) {
					detallerecap.setid_detalle_cliente(detallecliente.getId());
					DetalleRecapDataAccess.save(detallerecap,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detallecliente.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detallecliente.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detallecliente.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detallecliente.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(detallecliente.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detallecliente.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(detallecliente.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detallecliente.getPeriodo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(detallecliente.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detallecliente.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(detallecliente.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detallecliente.getMes(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(detallecliente.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(detallecliente.getModulo(),isDeep,deepLoadType,clases);
				

		AsientoContableDataAccess.save(detallecliente.getAsientoContable(),connexion);
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(detallecliente.getAsientoContable(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(detallecliente.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(detallecliente.getCliente(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(detallecliente.getTransaccion(),connexion);
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(detallecliente.getTransaccion(),isDeep,deepLoadType,clases);
				

		FacturaDataAccess.save(detallecliente.getFactura(),connexion);
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(detallecliente.getFactura(),isDeep,deepLoadType,clases);
				

		MonedaDataAccess.save(detallecliente.getMoneda(),connexion);
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(detallecliente.getMoneda(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detallecliente.getSucursalMovimiento(),connexion);
		SucursalLogic sucursalmovimientoLogic= new SucursalLogic(connexion);
		sucursalmovimientoLogic.deepLoad(detallecliente.getSucursalMovimiento(),isDeep,deepLoadType,clases);
				

		TipoTransaccionModuloDataAccess.save(detallecliente.getTipoTransaccionModulo(),connexion);
		TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
		tipotransaccionmoduloLogic.deepLoad(detallecliente.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				

		EstadoDetalleClienteDataAccess.save(detallecliente.getEstadoDetalleCliente(),connexion);
		EstadoDetalleClienteLogic estadodetalleclienteLogic= new EstadoDetalleClienteLogic(connexion);
		estadodetalleclienteLogic.deepLoad(detallecliente.getEstadoDetalleCliente(),isDeep,deepLoadType,clases);
				

		for(DetalleRecap detallerecap:detallecliente.getDetalleRecaps()) {
			DetalleRecapLogic detallerecapLogic= new DetalleRecapLogic(connexion);
			detallerecap.setid_detalle_cliente(detallecliente.getId());
			DetalleRecapDataAccess.save(detallerecap,connexion);
			detallerecapLogic.deepSave(detallerecap,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detallecliente.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detallecliente.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detallecliente.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detallecliente.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detallecliente.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(detallecliente.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detallecliente.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(detallecliente.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detallecliente.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(detallecliente.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detallecliente.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(detallecliente.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(detallecliente.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(detallecliente.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(detallecliente.getAsientoContable(),connexion);
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepSave(detallecliente.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(detallecliente.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(detallecliente.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(detallecliente.getTransaccion(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(detallecliente.getTransaccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(detallecliente.getFactura(),connexion);
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepSave(detallecliente.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(detallecliente.getMoneda(),connexion);
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepSave(detallecliente.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detallecliente.getSucursalMovimiento(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detallecliente.getSucursalMovimiento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				TipoTransaccionModuloDataAccess.save(detallecliente.getTipoTransaccionModulo(),connexion);
				TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
				tipotransaccionmoduloLogic.deepSave(detallecliente.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoDetalleCliente.class)) {
				EstadoDetalleClienteDataAccess.save(detallecliente.getEstadoDetalleCliente(),connexion);
				EstadoDetalleClienteLogic estadodetalleclienteLogic= new EstadoDetalleClienteLogic(connexion);
				estadodetalleclienteLogic.deepSave(detallecliente.getEstadoDetalleCliente(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetalleRecap.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleRecap detallerecap:detallecliente.getDetalleRecaps()) {
					DetalleRecapLogic detallerecapLogic= new DetalleRecapLogic(connexion);
					detallerecap.setid_detalle_cliente(detallecliente.getId());
					DetalleRecapDataAccess.save(detallerecap,connexion);
					detallerecapLogic.deepSave(detallerecap,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(DetalleCliente.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detallecliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(detallecliente);
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
			this.deepLoad(this.detallecliente,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detallecliente);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetalleCliente.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detalleclientes!=null) {
				for(DetalleCliente detallecliente:detalleclientes) {
					this.deepLoad(detallecliente,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(detalleclientes);
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
			if(detalleclientes!=null) {
				for(DetalleCliente detallecliente:detalleclientes) {
					this.deepLoad(detallecliente,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(detalleclientes);
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
			this.getNewConnexionToDeep(DetalleCliente.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detallecliente,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetalleCliente.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detalleclientes!=null) {
				for(DetalleCliente detallecliente:detalleclientes) {
					this.deepSave(detallecliente,isDeep,deepLoadType,clases);
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
			if(detalleclientes!=null) {
				for(DetalleCliente detallecliente:detalleclientes) {
					this.deepSave(detallecliente,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetalleClientesBusquedaPorFechaEmisionWithConnection(String sFinalQuery,Pagination pagination,Date fecha_emision,Date fecha_emisionFinal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralFechaEmision= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaEmision.setParameterSelectionGeneralMayorIgual(ParameterType.DATE,fecha_emision,DetalleClienteConstantesFunciones.FECHAEMISION,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaEmision);

			ParameterSelectionGeneral parameterSelectionGeneralFechaEmisionFinal= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaEmisionFinal.setParameterSelectionGeneralMenorIgual(ParameterType.DATE,fecha_emisionFinal,DetalleClienteConstantesFunciones.FECHAEMISION,"Final",ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaEmisionFinal);

			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorFechaEmision","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleclientes=detalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleClientesBusquedaPorFechaEmision(String sFinalQuery,Pagination pagination,Date fecha_emision,Date fecha_emisionFinal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralFechaEmision= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaEmision.setParameterSelectionGeneralMayorIgual(ParameterType.DATE,fecha_emision,DetalleClienteConstantesFunciones.FECHAEMISION,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaEmision);

			ParameterSelectionGeneral parameterSelectionGeneralFechaEmisionFinal= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaEmisionFinal.setParameterSelectionGeneralMenorIgual(ParameterType.DATE,fecha_emisionFinal,DetalleClienteConstantesFunciones.FECHAEMISION,"Final",ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaEmisionFinal);

			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorFechaEmision","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleclientes=detalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleClientesBusquedaPorFechaVenceWithConnection(String sFinalQuery,Pagination pagination,Date fecha_vence,Date fecha_venceFinal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralFechaVence= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaVence.setParameterSelectionGeneralMayorIgual(ParameterType.DATE,fecha_vence,DetalleClienteConstantesFunciones.FECHAVENCE,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaVence);

			ParameterSelectionGeneral parameterSelectionGeneralFechaVenceFinal= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaVenceFinal.setParameterSelectionGeneralMenorIgual(ParameterType.DATE,fecha_venceFinal,DetalleClienteConstantesFunciones.FECHAVENCE,"Final",ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaVenceFinal);

			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorFechaVence","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleclientes=detalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleClientesBusquedaPorFechaVence(String sFinalQuery,Pagination pagination,Date fecha_vence,Date fecha_venceFinal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralFechaVence= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaVence.setParameterSelectionGeneralMayorIgual(ParameterType.DATE,fecha_vence,DetalleClienteConstantesFunciones.FECHAVENCE,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaVence);

			ParameterSelectionGeneral parameterSelectionGeneralFechaVenceFinal= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaVenceFinal.setParameterSelectionGeneralMenorIgual(ParameterType.DATE,fecha_venceFinal,DetalleClienteConstantesFunciones.FECHAVENCE,"Final",ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaVenceFinal);

			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorFechaVence","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleclientes=detalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleClientesFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetalleClienteConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleclientes=detalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleClientesFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetalleClienteConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleclientes=detalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleClientesFK_IdAsientoContableWithConnection(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,DetalleClienteConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleclientes=detalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleClientesFK_IdAsientoContable(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,DetalleClienteConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleclientes=detalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleClientesFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,DetalleClienteConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleclientes=detalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleClientesFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,DetalleClienteConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleclientes=detalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleClientesFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleClienteConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleclientes=detalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleClientesFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleClienteConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleclientes=detalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleClientesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleClienteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleclientes=detalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleClientesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleClienteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleclientes=detalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleClientesFK_IdEstadoDetalleClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_detalle_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoDetalleCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoDetalleCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_detalle_cliente,DetalleClienteConstantesFunciones.IDESTADODETALLECLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoDetalleCliente);

			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoDetalleCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleclientes=detalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleClientesFK_IdEstadoDetalleCliente(String sFinalQuery,Pagination pagination,Long id_estado_detalle_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoDetalleCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoDetalleCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_detalle_cliente,DetalleClienteConstantesFunciones.IDESTADODETALLECLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoDetalleCliente);

			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoDetalleCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleclientes=detalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleClientesFK_IdFacturaWithConnection(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,DetalleClienteConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleclientes=detalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleClientesFK_IdFactura(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,DetalleClienteConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleclientes=detalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleClientesFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetalleClienteConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleclientes=detalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleClientesFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetalleClienteConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleclientes=detalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleClientesFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,DetalleClienteConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleclientes=detalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleClientesFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,DetalleClienteConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleclientes=detalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleClientesFK_IdMonedaWithConnection(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,DetalleClienteConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleclientes=detalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleClientesFK_IdMoneda(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,DetalleClienteConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleclientes=detalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleClientesFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetalleClienteConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleclientes=detalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleClientesFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetalleClienteConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleclientes=detalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleClientesFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleClienteConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleclientes=detalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleClientesFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleClienteConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleclientes=detalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleClientesFK_IdSucursalMovimientoWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal_movimiento)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursalMovimiento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursalMovimiento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal_movimiento,DetalleClienteConstantesFunciones.IDSUCURSALMOVIMIENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursalMovimiento);

			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursalMovimiento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleclientes=detalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleClientesFK_IdSucursalMovimiento(String sFinalQuery,Pagination pagination,Long id_sucursal_movimiento)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursalMovimiento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursalMovimiento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal_movimiento,DetalleClienteConstantesFunciones.IDSUCURSALMOVIMIENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursalMovimiento);

			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursalMovimiento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleclientes=detalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleClientesFK_IdTipoTransaccionModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_transaccion_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransaccionModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransaccionModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transaccion_modulo,DetalleClienteConstantesFunciones.IDTIPOTRANSACCIONMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransaccionModulo);

			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTransaccionModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleclientes=detalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleClientesFK_IdTipoTransaccionModulo(String sFinalQuery,Pagination pagination,Long id_tipo_transaccion_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransaccionModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransaccionModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transaccion_modulo,DetalleClienteConstantesFunciones.IDTIPOTRANSACCIONMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransaccionModulo);

			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTransaccionModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleclientes=detalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleClientesFK_IdTransaccionWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleCliente.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion,DetalleClienteConstantesFunciones.IDTRANSACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion);

			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleclientes=detalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleClientesFK_IdTransaccion(String sFinalQuery,Pagination pagination,Long id_transaccion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion,DetalleClienteConstantesFunciones.IDTRANSACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion);

			DetalleClienteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleclientes=detalleclienteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleClienteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleCliente(this.detalleclientes);
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
			if(DetalleClienteConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleClienteDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetalleCliente detallecliente,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetalleClienteConstantesFunciones.ISCONAUDITORIA) {
				if(detallecliente.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleClienteDataAccess.TABLENAME, detallecliente.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleClienteLogic.registrarAuditoriaDetallesDetalleCliente(connexion,detallecliente,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detallecliente.getIsDeleted()) {
					/*if(!detallecliente.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetalleClienteDataAccess.TABLENAME, detallecliente.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetalleClienteLogic.registrarAuditoriaDetallesDetalleCliente(connexion,detallecliente,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleClienteDataAccess.TABLENAME, detallecliente.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detallecliente.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleClienteDataAccess.TABLENAME, detallecliente.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleClienteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleClienteLogic.registrarAuditoriaDetallesDetalleCliente(connexion,detallecliente,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetalleCliente(Connexion connexion,DetalleCliente detallecliente)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detallecliente.getIsNew()||!detallecliente.getid_empresa().equals(detallecliente.getDetalleClienteOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecliente.getDetalleClienteOriginal().getid_empresa()!=null)
				{
					strValorActual=detallecliente.getDetalleClienteOriginal().getid_empresa().toString();
				}
				if(detallecliente.getid_empresa()!=null)
				{
					strValorNuevo=detallecliente.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleClienteConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detallecliente.getIsNew()||!detallecliente.getid_sucursal().equals(detallecliente.getDetalleClienteOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecliente.getDetalleClienteOriginal().getid_sucursal()!=null)
				{
					strValorActual=detallecliente.getDetalleClienteOriginal().getid_sucursal().toString();
				}
				if(detallecliente.getid_sucursal()!=null)
				{
					strValorNuevo=detallecliente.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleClienteConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(detallecliente.getIsNew()||!detallecliente.getid_ejercicio().equals(detallecliente.getDetalleClienteOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecliente.getDetalleClienteOriginal().getid_ejercicio()!=null)
				{
					strValorActual=detallecliente.getDetalleClienteOriginal().getid_ejercicio().toString();
				}
				if(detallecliente.getid_ejercicio()!=null)
				{
					strValorNuevo=detallecliente.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleClienteConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(detallecliente.getIsNew()||!detallecliente.getid_periodo().equals(detallecliente.getDetalleClienteOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecliente.getDetalleClienteOriginal().getid_periodo()!=null)
				{
					strValorActual=detallecliente.getDetalleClienteOriginal().getid_periodo().toString();
				}
				if(detallecliente.getid_periodo()!=null)
				{
					strValorNuevo=detallecliente.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleClienteConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(detallecliente.getIsNew()||!detallecliente.getid_anio().equals(detallecliente.getDetalleClienteOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecliente.getDetalleClienteOriginal().getid_anio()!=null)
				{
					strValorActual=detallecliente.getDetalleClienteOriginal().getid_anio().toString();
				}
				if(detallecliente.getid_anio()!=null)
				{
					strValorNuevo=detallecliente.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleClienteConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(detallecliente.getIsNew()||!detallecliente.getid_mes().equals(detallecliente.getDetalleClienteOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecliente.getDetalleClienteOriginal().getid_mes()!=null)
				{
					strValorActual=detallecliente.getDetalleClienteOriginal().getid_mes().toString();
				}
				if(detallecliente.getid_mes()!=null)
				{
					strValorNuevo=detallecliente.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleClienteConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(detallecliente.getIsNew()||!detallecliente.getid_modulo().equals(detallecliente.getDetalleClienteOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecliente.getDetalleClienteOriginal().getid_modulo()!=null)
				{
					strValorActual=detallecliente.getDetalleClienteOriginal().getid_modulo().toString();
				}
				if(detallecliente.getid_modulo()!=null)
				{
					strValorNuevo=detallecliente.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleClienteConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(detallecliente.getIsNew()||!detallecliente.getid_asiento_contable().equals(detallecliente.getDetalleClienteOriginal().getid_asiento_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecliente.getDetalleClienteOriginal().getid_asiento_contable()!=null)
				{
					strValorActual=detallecliente.getDetalleClienteOriginal().getid_asiento_contable().toString();
				}
				if(detallecliente.getid_asiento_contable()!=null)
				{
					strValorNuevo=detallecliente.getid_asiento_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleClienteConstantesFunciones.IDASIENTOCONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(detallecliente.getIsNew()||!detallecliente.getid_cliente().equals(detallecliente.getDetalleClienteOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecliente.getDetalleClienteOriginal().getid_cliente()!=null)
				{
					strValorActual=detallecliente.getDetalleClienteOriginal().getid_cliente().toString();
				}
				if(detallecliente.getid_cliente()!=null)
				{
					strValorNuevo=detallecliente.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleClienteConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(detallecliente.getIsNew()||!detallecliente.getid_transaccion().equals(detallecliente.getDetalleClienteOriginal().getid_transaccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecliente.getDetalleClienteOriginal().getid_transaccion()!=null)
				{
					strValorActual=detallecliente.getDetalleClienteOriginal().getid_transaccion().toString();
				}
				if(detallecliente.getid_transaccion()!=null)
				{
					strValorNuevo=detallecliente.getid_transaccion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleClienteConstantesFunciones.IDTRANSACCION,strValorActual,strValorNuevo);
			}	
			
			if(detallecliente.getIsNew()||!detallecliente.getid_factura().equals(detallecliente.getDetalleClienteOriginal().getid_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecliente.getDetalleClienteOriginal().getid_factura()!=null)
				{
					strValorActual=detallecliente.getDetalleClienteOriginal().getid_factura().toString();
				}
				if(detallecliente.getid_factura()!=null)
				{
					strValorNuevo=detallecliente.getid_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleClienteConstantesFunciones.IDFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(detallecliente.getIsNew()||!detallecliente.getnumero_factura().equals(detallecliente.getDetalleClienteOriginal().getnumero_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecliente.getDetalleClienteOriginal().getnumero_factura()!=null)
				{
					strValorActual=detallecliente.getDetalleClienteOriginal().getnumero_factura();
				}
				if(detallecliente.getnumero_factura()!=null)
				{
					strValorNuevo=detallecliente.getnumero_factura() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleClienteConstantesFunciones.NUMEROFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(detallecliente.getIsNew()||!detallecliente.getfecha_vence().equals(detallecliente.getDetalleClienteOriginal().getfecha_vence()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecliente.getDetalleClienteOriginal().getfecha_vence()!=null)
				{
					strValorActual=detallecliente.getDetalleClienteOriginal().getfecha_vence().toString();
				}
				if(detallecliente.getfecha_vence()!=null)
				{
					strValorNuevo=detallecliente.getfecha_vence().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleClienteConstantesFunciones.FECHAVENCE,strValorActual,strValorNuevo);
			}	
			
			if(detallecliente.getIsNew()||!detallecliente.getdescripcion().equals(detallecliente.getDetalleClienteOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecliente.getDetalleClienteOriginal().getdescripcion()!=null)
				{
					strValorActual=detallecliente.getDetalleClienteOriginal().getdescripcion();
				}
				if(detallecliente.getdescripcion()!=null)
				{
					strValorNuevo=detallecliente.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleClienteConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(detallecliente.getIsNew()||!detallecliente.getdebito_mone_local().equals(detallecliente.getDetalleClienteOriginal().getdebito_mone_local()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecliente.getDetalleClienteOriginal().getdebito_mone_local()!=null)
				{
					strValorActual=detallecliente.getDetalleClienteOriginal().getdebito_mone_local().toString();
				}
				if(detallecliente.getdebito_mone_local()!=null)
				{
					strValorNuevo=detallecliente.getdebito_mone_local().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleClienteConstantesFunciones.DEBITOMONELOCAL,strValorActual,strValorNuevo);
			}	
			
			if(detallecliente.getIsNew()||!detallecliente.getcredito_mone_local().equals(detallecliente.getDetalleClienteOriginal().getcredito_mone_local()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecliente.getDetalleClienteOriginal().getcredito_mone_local()!=null)
				{
					strValorActual=detallecliente.getDetalleClienteOriginal().getcredito_mone_local().toString();
				}
				if(detallecliente.getcredito_mone_local()!=null)
				{
					strValorNuevo=detallecliente.getcredito_mone_local().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleClienteConstantesFunciones.CREDITOMONELOCAL,strValorActual,strValorNuevo);
			}	
			
			if(detallecliente.getIsNew()||!detallecliente.getdebito_mone_extra().equals(detallecliente.getDetalleClienteOriginal().getdebito_mone_extra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecliente.getDetalleClienteOriginal().getdebito_mone_extra()!=null)
				{
					strValorActual=detallecliente.getDetalleClienteOriginal().getdebito_mone_extra().toString();
				}
				if(detallecliente.getdebito_mone_extra()!=null)
				{
					strValorNuevo=detallecliente.getdebito_mone_extra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleClienteConstantesFunciones.DEBITOMONEEXTRA,strValorActual,strValorNuevo);
			}	
			
			if(detallecliente.getIsNew()||!detallecliente.getcredito_mone_extra().equals(detallecliente.getDetalleClienteOriginal().getcredito_mone_extra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecliente.getDetalleClienteOriginal().getcredito_mone_extra()!=null)
				{
					strValorActual=detallecliente.getDetalleClienteOriginal().getcredito_mone_extra().toString();
				}
				if(detallecliente.getcredito_mone_extra()!=null)
				{
					strValorNuevo=detallecliente.getcredito_mone_extra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleClienteConstantesFunciones.CREDITOMONEEXTRA,strValorActual,strValorNuevo);
			}	
			
			if(detallecliente.getIsNew()||!detallecliente.getid_moneda().equals(detallecliente.getDetalleClienteOriginal().getid_moneda()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecliente.getDetalleClienteOriginal().getid_moneda()!=null)
				{
					strValorActual=detallecliente.getDetalleClienteOriginal().getid_moneda().toString();
				}
				if(detallecliente.getid_moneda()!=null)
				{
					strValorNuevo=detallecliente.getid_moneda().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleClienteConstantesFunciones.IDMONEDA,strValorActual,strValorNuevo);
			}	
			
			if(detallecliente.getIsNew()||!detallecliente.getcotizacion().equals(detallecliente.getDetalleClienteOriginal().getcotizacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecliente.getDetalleClienteOriginal().getcotizacion()!=null)
				{
					strValorActual=detallecliente.getDetalleClienteOriginal().getcotizacion().toString();
				}
				if(detallecliente.getcotizacion()!=null)
				{
					strValorNuevo=detallecliente.getcotizacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleClienteConstantesFunciones.COTIZACION,strValorActual,strValorNuevo);
			}	
			
			if(detallecliente.getIsNew()||!detallecliente.getid_sucursal_movimiento().equals(detallecliente.getDetalleClienteOriginal().getid_sucursal_movimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecliente.getDetalleClienteOriginal().getid_sucursal_movimiento()!=null)
				{
					strValorActual=detallecliente.getDetalleClienteOriginal().getid_sucursal_movimiento().toString();
				}
				if(detallecliente.getid_sucursal_movimiento()!=null)
				{
					strValorNuevo=detallecliente.getid_sucursal_movimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleClienteConstantesFunciones.IDSUCURSALMOVIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(detallecliente.getIsNew()||!detallecliente.getid_tipo_transaccion_modulo().equals(detallecliente.getDetalleClienteOriginal().getid_tipo_transaccion_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecliente.getDetalleClienteOriginal().getid_tipo_transaccion_modulo()!=null)
				{
					strValorActual=detallecliente.getDetalleClienteOriginal().getid_tipo_transaccion_modulo().toString();
				}
				if(detallecliente.getid_tipo_transaccion_modulo()!=null)
				{
					strValorNuevo=detallecliente.getid_tipo_transaccion_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleClienteConstantesFunciones.IDTIPOTRANSACCIONMODULO,strValorActual,strValorNuevo);
			}	
			
			if(detallecliente.getIsNew()||!detallecliente.getfecha_emision().equals(detallecliente.getDetalleClienteOriginal().getfecha_emision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecliente.getDetalleClienteOriginal().getfecha_emision()!=null)
				{
					strValorActual=detallecliente.getDetalleClienteOriginal().getfecha_emision().toString();
				}
				if(detallecliente.getfecha_emision()!=null)
				{
					strValorNuevo=detallecliente.getfecha_emision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleClienteConstantesFunciones.FECHAEMISION,strValorActual,strValorNuevo);
			}	
			
			if(detallecliente.getIsNew()||!detallecliente.getbeneficiario().equals(detallecliente.getDetalleClienteOriginal().getbeneficiario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecliente.getDetalleClienteOriginal().getbeneficiario()!=null)
				{
					strValorActual=detallecliente.getDetalleClienteOriginal().getbeneficiario();
				}
				if(detallecliente.getbeneficiario()!=null)
				{
					strValorNuevo=detallecliente.getbeneficiario() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleClienteConstantesFunciones.BENEFICIARIO,strValorActual,strValorNuevo);
			}	
			
			if(detallecliente.getIsNew()||!detallecliente.getmonto_mone_local().equals(detallecliente.getDetalleClienteOriginal().getmonto_mone_local()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecliente.getDetalleClienteOriginal().getmonto_mone_local()!=null)
				{
					strValorActual=detallecliente.getDetalleClienteOriginal().getmonto_mone_local().toString();
				}
				if(detallecliente.getmonto_mone_local()!=null)
				{
					strValorNuevo=detallecliente.getmonto_mone_local().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleClienteConstantesFunciones.MONTOMONELOCAL,strValorActual,strValorNuevo);
			}	
			
			if(detallecliente.getIsNew()||!detallecliente.getmonto_mone_extra().equals(detallecliente.getDetalleClienteOriginal().getmonto_mone_extra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecliente.getDetalleClienteOriginal().getmonto_mone_extra()!=null)
				{
					strValorActual=detallecliente.getDetalleClienteOriginal().getmonto_mone_extra().toString();
				}
				if(detallecliente.getmonto_mone_extra()!=null)
				{
					strValorNuevo=detallecliente.getmonto_mone_extra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleClienteConstantesFunciones.MONTOMONEEXTRA,strValorActual,strValorNuevo);
			}	
			
			if(detallecliente.getIsNew()||!detallecliente.getnumero_comprobante().equals(detallecliente.getDetalleClienteOriginal().getnumero_comprobante()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecliente.getDetalleClienteOriginal().getnumero_comprobante()!=null)
				{
					strValorActual=detallecliente.getDetalleClienteOriginal().getnumero_comprobante();
				}
				if(detallecliente.getnumero_comprobante()!=null)
				{
					strValorNuevo=detallecliente.getnumero_comprobante() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleClienteConstantesFunciones.NUMEROCOMPROBANTE,strValorActual,strValorNuevo);
			}	
			
			if(detallecliente.getIsNew()||!detallecliente.getid_estado_detalle_cliente().equals(detallecliente.getDetalleClienteOriginal().getid_estado_detalle_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detallecliente.getDetalleClienteOriginal().getid_estado_detalle_cliente()!=null)
				{
					strValorActual=detallecliente.getDetalleClienteOriginal().getid_estado_detalle_cliente().toString();
				}
				if(detallecliente.getid_estado_detalle_cliente()!=null)
				{
					strValorNuevo=detallecliente.getid_estado_detalle_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleClienteConstantesFunciones.IDESTADODETALLECLIENTE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetalleClienteRelacionesWithConnection(DetalleCliente detallecliente,List<DetalleRecap> detallerecaps) throws Exception {

		if(!detallecliente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleClienteRelacionesBase(detallecliente,detallerecaps,true);
		}
	}

	public void saveDetalleClienteRelaciones(DetalleCliente detallecliente,List<DetalleRecap> detallerecaps)throws Exception {

		if(!detallecliente.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleClienteRelacionesBase(detallecliente,detallerecaps,false);
		}
	}

	public void saveDetalleClienteRelacionesBase(DetalleCliente detallecliente,List<DetalleRecap> detallerecaps,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetalleCliente-saveRelacionesWithConnection");}
	
			detallecliente.setDetalleRecaps(detallerecaps);

			this.setDetalleCliente(detallecliente);

			if(DetalleClienteLogicAdditional.validarSaveRelaciones(detallecliente,this)) {

				DetalleClienteLogicAdditional.updateRelacionesToSave(detallecliente,this);

				if((detallecliente.getIsNew()||detallecliente.getIsChanged())&&!detallecliente.getIsDeleted()) {
					this.saveDetalleCliente();
					this.saveDetalleClienteRelacionesDetalles(detallerecaps);

				} else if(detallecliente.getIsDeleted()) {
					this.saveDetalleClienteRelacionesDetalles(detallerecaps);
					this.saveDetalleCliente();
				}

				DetalleClienteLogicAdditional.updateRelacionesToSaveAfter(detallecliente,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetalleRecapConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleRecaps(detallerecaps,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveDetalleClienteRelacionesDetalles(List<DetalleRecap> detallerecaps)throws Exception {
		try {
	

			Long idDetalleClienteActual=this.getDetalleCliente().getId();

			DetalleRecapLogic detallerecapLogic_Desde_DetalleCliente=new DetalleRecapLogic();
			detallerecapLogic_Desde_DetalleCliente.setDetalleRecaps(detallerecaps);

			detallerecapLogic_Desde_DetalleCliente.setConnexion(this.getConnexion());
			detallerecapLogic_Desde_DetalleCliente.setDatosCliente(this.datosCliente);

			for(DetalleRecap detallerecap_Desde_DetalleCliente:detallerecapLogic_Desde_DetalleCliente.getDetalleRecaps()) {
				detallerecap_Desde_DetalleCliente.setid_detalle_cliente(idDetalleClienteActual);
			}

			detallerecapLogic_Desde_DetalleCliente.saveDetalleRecaps();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleClienteConstantesFunciones.getClassesForeignKeysOfDetalleCliente(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleCliente(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleClienteConstantesFunciones.getClassesRelationshipsOfDetalleCliente(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

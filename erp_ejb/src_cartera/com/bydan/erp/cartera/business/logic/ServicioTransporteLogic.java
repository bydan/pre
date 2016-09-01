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
import com.bydan.erp.cartera.util.ServicioTransporteConstantesFunciones;
import com.bydan.erp.cartera.util.ServicioTransporteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.ServicioTransporteParameterGeneral;
import com.bydan.erp.cartera.business.entity.ServicioTransporte;
import com.bydan.erp.cartera.business.logic.ServicioTransporteLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.activosfijos.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.activosfijos.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;








@SuppressWarnings("unused")
public class ServicioTransporteLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ServicioTransporteLogic.class);
	
	protected ServicioTransporteDataAccess serviciotransporteDataAccess; 	
	protected ServicioTransporte serviciotransporte;
	protected List<ServicioTransporte> serviciotransportes;
	protected Object serviciotransporteObject;	
	protected List<Object> serviciotransportesObject;
	
	public static ClassValidator<ServicioTransporte> serviciotransporteValidator = new ClassValidator<ServicioTransporte>(ServicioTransporte.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ServicioTransporteLogicAdditional serviciotransporteLogicAdditional=null;
	
	public ServicioTransporteLogicAdditional getServicioTransporteLogicAdditional() {
		return this.serviciotransporteLogicAdditional;
	}
	
	public void setServicioTransporteLogicAdditional(ServicioTransporteLogicAdditional serviciotransporteLogicAdditional) {
		try {
			this.serviciotransporteLogicAdditional=serviciotransporteLogicAdditional;
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
	
	
	
	
	public  ServicioTransporteLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.serviciotransporteDataAccess = new ServicioTransporteDataAccess();
			
			this.serviciotransportes= new ArrayList<ServicioTransporte>();
			this.serviciotransporte= new ServicioTransporte();
			
			this.serviciotransporteObject=new Object();
			this.serviciotransportesObject=new ArrayList<Object>();
				
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
			
			this.serviciotransporteDataAccess.setConnexionType(this.connexionType);
			this.serviciotransporteDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ServicioTransporteLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.serviciotransporteDataAccess = new ServicioTransporteDataAccess();
			this.serviciotransportes= new ArrayList<ServicioTransporte>();
			this.serviciotransporte= new ServicioTransporte();
			this.serviciotransporteObject=new Object();
			this.serviciotransportesObject=new ArrayList<Object>();
			
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
			
			this.serviciotransporteDataAccess.setConnexionType(this.connexionType);
			this.serviciotransporteDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ServicioTransporte getServicioTransporte() throws Exception {	
		ServicioTransporteLogicAdditional.checkServicioTransporteToGet(serviciotransporte,this.datosCliente,this.arrDatoGeneral);
		ServicioTransporteLogicAdditional.updateServicioTransporteToGet(serviciotransporte,this.arrDatoGeneral);
		
		return serviciotransporte;
	}
		
	public void setServicioTransporte(ServicioTransporte newServicioTransporte) {
		this.serviciotransporte = newServicioTransporte;
	}
	
	public ServicioTransporteDataAccess getServicioTransporteDataAccess() {
		return serviciotransporteDataAccess;
	}
	
	public void setServicioTransporteDataAccess(ServicioTransporteDataAccess newserviciotransporteDataAccess) {
		this.serviciotransporteDataAccess = newserviciotransporteDataAccess;
	}
	
	public List<ServicioTransporte> getServicioTransportes() throws Exception {		
		this.quitarServicioTransportesNulos();
		
		ServicioTransporteLogicAdditional.checkServicioTransporteToGets(serviciotransportes,this.datosCliente,this.arrDatoGeneral);
		
		for (ServicioTransporte serviciotransporteLocal: serviciotransportes ) {
			ServicioTransporteLogicAdditional.updateServicioTransporteToGet(serviciotransporteLocal,this.arrDatoGeneral);
		}
		
		return serviciotransportes;
	}
	
	public void setServicioTransportes(List<ServicioTransporte> newServicioTransportes) {
		this.serviciotransportes = newServicioTransportes;
	}
	
	public Object getServicioTransporteObject() {	
		this.serviciotransporteObject=this.serviciotransporteDataAccess.getEntityObject();
		return this.serviciotransporteObject;
	}
		
	public void setServicioTransporteObject(Object newServicioTransporteObject) {
		this.serviciotransporteObject = newServicioTransporteObject;
	}
	
	public List<Object> getServicioTransportesObject() {		
		this.serviciotransportesObject=this.serviciotransporteDataAccess.getEntitiesObject();
		return this.serviciotransportesObject;
	}
		
	public void setServicioTransportesObject(List<Object> newServicioTransportesObject) {
		this.serviciotransportesObject = newServicioTransportesObject;
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
		
		if(this.serviciotransporteDataAccess!=null) {
			this.serviciotransporteDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ServicioTransporte.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			serviciotransporteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			serviciotransporteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		serviciotransporte = new  ServicioTransporte();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ServicioTransporte.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			serviciotransporte=serviciotransporteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.serviciotransporte,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(this.serviciotransporte);
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
		serviciotransporte = new  ServicioTransporte();
		  		  
        try {
			
			serviciotransporte=serviciotransporteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.serviciotransporte,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(this.serviciotransporte);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		serviciotransporte = new  ServicioTransporte();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ServicioTransporte.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			serviciotransporte=serviciotransporteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.serviciotransporte,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(this.serviciotransporte);
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
		serviciotransporte = new  ServicioTransporte();
		  		  
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
		serviciotransporte = new  ServicioTransporte();
		  		  
        try {
			
			serviciotransporte=serviciotransporteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.serviciotransporte,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(this.serviciotransporte);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		serviciotransporte = new  ServicioTransporte();
		  		  
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
		serviciotransporte = new  ServicioTransporte();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ServicioTransporte.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =serviciotransporteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		serviciotransporte = new  ServicioTransporte();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=serviciotransporteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		serviciotransporte = new  ServicioTransporte();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ServicioTransporte.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =serviciotransporteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		serviciotransporte = new  ServicioTransporte();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=serviciotransporteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		serviciotransporte = new  ServicioTransporte();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ServicioTransporte.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =serviciotransporteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		serviciotransporte = new  ServicioTransporte();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=serviciotransporteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		serviciotransportes = new  ArrayList<ServicioTransporte>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ServicioTransporte.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			serviciotransportes=serviciotransporteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarServicioTransporte(serviciotransportes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(this.serviciotransportes);
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
		serviciotransportes = new  ArrayList<ServicioTransporte>();
		  		  
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
		serviciotransportes = new  ArrayList<ServicioTransporte>();
		  		  
        try {			
			ServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			serviciotransportes=serviciotransporteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarServicioTransporte(serviciotransportes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(this.serviciotransportes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		serviciotransportes = new  ArrayList<ServicioTransporte>();
		  		  
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
		serviciotransportes = new  ArrayList<ServicioTransporte>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ServicioTransporte.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			serviciotransportes=serviciotransporteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarServicioTransporte(serviciotransportes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(this.serviciotransportes);
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
		serviciotransportes = new  ArrayList<ServicioTransporte>();
		  		  
        try {
			ServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			serviciotransportes=serviciotransporteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarServicioTransporte(serviciotransportes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(this.serviciotransportes);
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
		serviciotransportes = new  ArrayList<ServicioTransporte>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ServicioTransporte.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			serviciotransportes=serviciotransporteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarServicioTransporte(serviciotransportes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(this.serviciotransportes);
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
		serviciotransportes = new  ArrayList<ServicioTransporte>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			serviciotransportes=serviciotransporteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarServicioTransporte(serviciotransportes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(this.serviciotransportes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		serviciotransporte = new  ServicioTransporte();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ServicioTransporte.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			serviciotransporte=serviciotransporteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarServicioTransporte(serviciotransporte);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(this.serviciotransporte);
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
		serviciotransporte = new  ServicioTransporte();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			serviciotransporte=serviciotransporteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarServicioTransporte(serviciotransporte);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(this.serviciotransporte);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		serviciotransportes = new  ArrayList<ServicioTransporte>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ServicioTransporte.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			serviciotransportes=serviciotransporteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarServicioTransporte(serviciotransportes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(this.serviciotransportes);
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
		serviciotransportes = new  ArrayList<ServicioTransporte>();
		  		  
        try {
			ServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			serviciotransportes=serviciotransporteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarServicioTransporte(serviciotransportes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(this.serviciotransportes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosServicioTransportesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		serviciotransportes = new  ArrayList<ServicioTransporte>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ServicioTransporte.class.getSimpleName()+"-getTodosServicioTransportesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			serviciotransportes=serviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarServicioTransporte(serviciotransportes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(this.serviciotransportes);
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
	
	public  void  getTodosServicioTransportes(String sFinalQuery,Pagination pagination)throws Exception {
		serviciotransportes = new  ArrayList<ServicioTransporte>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			serviciotransportes=serviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarServicioTransporte(serviciotransportes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(this.serviciotransportes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarServicioTransporte(ServicioTransporte serviciotransporte) throws Exception {
		Boolean estaValidado=false;
		
		if(serviciotransporte.getIsNew() || serviciotransporte.getIsChanged()) { 
			this.invalidValues = serviciotransporteValidator.getInvalidValues(serviciotransporte);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(serviciotransporte);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarServicioTransporte(List<ServicioTransporte> ServicioTransportes) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ServicioTransporte serviciotransporteLocal:serviciotransportes) {				
			estaValidadoObjeto=this.validarGuardarServicioTransporte(serviciotransporteLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarServicioTransporte(List<ServicioTransporte> ServicioTransportes) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarServicioTransporte(serviciotransportes)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarServicioTransporte(ServicioTransporte ServicioTransporte) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarServicioTransporte(serviciotransporte)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ServicioTransporte serviciotransporte) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+serviciotransporte.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ServicioTransporteConstantesFunciones.getServicioTransporteLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"serviciotransporte","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ServicioTransporteConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ServicioTransporteConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveServicioTransporteWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ServicioTransporte.class.getSimpleName()+"-saveServicioTransporteWithConnection");connexion.begin();			
			
			ServicioTransporteLogicAdditional.checkServicioTransporteToSave(this.serviciotransporte,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ServicioTransporteLogicAdditional.updateServicioTransporteToSave(this.serviciotransporte,this.arrDatoGeneral);
			
			ServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.serviciotransporte,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowServicioTransporte();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarServicioTransporte(this.serviciotransporte)) {
				ServicioTransporteDataAccess.save(this.serviciotransporte, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.serviciotransporte,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ServicioTransporteLogicAdditional.checkServicioTransporteToSaveAfter(this.serviciotransporte,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowServicioTransporte();
			
			connexion.commit();			
			
			if(this.serviciotransporte.getIsDeleted()) {
				this.serviciotransporte=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveServicioTransporte()throws Exception {	
		try {	
			
			ServicioTransporteLogicAdditional.checkServicioTransporteToSave(this.serviciotransporte,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ServicioTransporteLogicAdditional.updateServicioTransporteToSave(this.serviciotransporte,this.arrDatoGeneral);
			
			ServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.serviciotransporte,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarServicioTransporte(this.serviciotransporte)) {			
				ServicioTransporteDataAccess.save(this.serviciotransporte, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.serviciotransporte,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ServicioTransporteLogicAdditional.checkServicioTransporteToSaveAfter(this.serviciotransporte,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.serviciotransporte.getIsDeleted()) {
				this.serviciotransporte=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveServicioTransportesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ServicioTransporte.class.getSimpleName()+"-saveServicioTransportesWithConnection");connexion.begin();			
			
			ServicioTransporteLogicAdditional.checkServicioTransporteToSaves(serviciotransportes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowServicioTransportes();
			
			Boolean validadoTodosServicioTransporte=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ServicioTransporte serviciotransporteLocal:serviciotransportes) {		
				if(serviciotransporteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ServicioTransporteLogicAdditional.updateServicioTransporteToSave(serviciotransporteLocal,this.arrDatoGeneral);
	        	
				ServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),serviciotransporteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarServicioTransporte(serviciotransporteLocal)) {
					ServicioTransporteDataAccess.save(serviciotransporteLocal, connexion);				
				} else {
					validadoTodosServicioTransporte=false;
				}
			}
			
			if(!validadoTodosServicioTransporte) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ServicioTransporteLogicAdditional.checkServicioTransporteToSavesAfter(serviciotransportes,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowServicioTransportes();
			
			connexion.commit();		
			
			this.quitarServicioTransportesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveServicioTransportes()throws Exception {				
		 try {	
			ServicioTransporteLogicAdditional.checkServicioTransporteToSaves(serviciotransportes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosServicioTransporte=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ServicioTransporte serviciotransporteLocal:serviciotransportes) {				
				if(serviciotransporteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ServicioTransporteLogicAdditional.updateServicioTransporteToSave(serviciotransporteLocal,this.arrDatoGeneral);
	        	
				ServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),serviciotransporteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarServicioTransporte(serviciotransporteLocal)) {				
					ServicioTransporteDataAccess.save(serviciotransporteLocal, connexion);				
				} else {
					validadoTodosServicioTransporte=false;
				}
			}
			
			if(!validadoTodosServicioTransporte) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ServicioTransporteLogicAdditional.checkServicioTransporteToSavesAfter(serviciotransportes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarServicioTransportesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ServicioTransporteParameterReturnGeneral procesarAccionServicioTransportes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ServicioTransporte> serviciotransportes,ServicioTransporteParameterReturnGeneral serviciotransporteParameterGeneral)throws Exception {
		 try {	
			ServicioTransporteParameterReturnGeneral serviciotransporteReturnGeneral=new ServicioTransporteParameterReturnGeneral();
	
			ServicioTransporteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,serviciotransportes,serviciotransporteParameterGeneral,serviciotransporteReturnGeneral);
			
			return serviciotransporteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ServicioTransporteParameterReturnGeneral procesarAccionServicioTransportesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ServicioTransporte> serviciotransportes,ServicioTransporteParameterReturnGeneral serviciotransporteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ServicioTransporte.class.getSimpleName()+"-procesarAccionServicioTransportesWithConnection");connexion.begin();			
			
			ServicioTransporteParameterReturnGeneral serviciotransporteReturnGeneral=new ServicioTransporteParameterReturnGeneral();
	
			ServicioTransporteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,serviciotransportes,serviciotransporteParameterGeneral,serviciotransporteReturnGeneral);
			
			this.connexion.commit();
			
			return serviciotransporteReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ServicioTransporteParameterReturnGeneral procesarEventosServicioTransportes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ServicioTransporte> serviciotransportes,ServicioTransporte serviciotransporte,ServicioTransporteParameterReturnGeneral serviciotransporteParameterGeneral,Boolean isEsNuevoServicioTransporte,ArrayList<Classe> clases)throws Exception {
		 try {	
			ServicioTransporteParameterReturnGeneral serviciotransporteReturnGeneral=new ServicioTransporteParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				serviciotransporteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ServicioTransporteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,serviciotransportes,serviciotransporte,serviciotransporteParameterGeneral,serviciotransporteReturnGeneral,isEsNuevoServicioTransporte,clases);
			
			return serviciotransporteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ServicioTransporteParameterReturnGeneral procesarEventosServicioTransportesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ServicioTransporte> serviciotransportes,ServicioTransporte serviciotransporte,ServicioTransporteParameterReturnGeneral serviciotransporteParameterGeneral,Boolean isEsNuevoServicioTransporte,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ServicioTransporte.class.getSimpleName()+"-procesarEventosServicioTransportesWithConnection");connexion.begin();			
			
			ServicioTransporteParameterReturnGeneral serviciotransporteReturnGeneral=new ServicioTransporteParameterReturnGeneral();
	
			serviciotransporteReturnGeneral.setServicioTransporte(serviciotransporte);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				serviciotransporteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ServicioTransporteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,serviciotransportes,serviciotransporte,serviciotransporteParameterGeneral,serviciotransporteReturnGeneral,isEsNuevoServicioTransporte,clases);
			
			this.connexion.commit();
			
			return serviciotransporteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ServicioTransporteParameterReturnGeneral procesarImportacionServicioTransportesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ServicioTransporteParameterReturnGeneral serviciotransporteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ServicioTransporte.class.getSimpleName()+"-procesarImportacionServicioTransportesWithConnection");connexion.begin();			
			
			ServicioTransporteParameterReturnGeneral serviciotransporteReturnGeneral=new ServicioTransporteParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.serviciotransportes=new ArrayList<ServicioTransporte>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.serviciotransporte=new ServicioTransporte();
				
				
				if(conColumnasBase) {this.serviciotransporte.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.serviciotransporte.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.serviciotransporte.setfecha_ingreso(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.serviciotransporte.setfecha_entrega(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.serviciotransporte.setcodigo_guia1(arrColumnas[iColumn++]);
				this.serviciotransporte.setcodigo_guia2(arrColumnas[iColumn++]);
				this.serviciotransporte.setprecio(Double.parseDouble(arrColumnas[iColumn++]));
				this.serviciotransporte.setvalor_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.serviciotransporte.setvalor_total(Double.parseDouble(arrColumnas[iColumn++]));
			this.serviciotransporte.setdescripcion(arrColumnas[iColumn++]);
				
				this.serviciotransportes.add(this.serviciotransporte);
			}
			
			this.saveServicioTransportes();
			
			this.connexion.commit();
			
			serviciotransporteReturnGeneral.setConRetornoEstaProcesado(true);
			serviciotransporteReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return serviciotransporteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarServicioTransportesEliminados() throws Exception {				
		
		List<ServicioTransporte> serviciotransportesAux= new ArrayList<ServicioTransporte>();
		
		for(ServicioTransporte serviciotransporte:serviciotransportes) {
			if(!serviciotransporte.getIsDeleted()) {
				serviciotransportesAux.add(serviciotransporte);
			}
		}
		
		serviciotransportes=serviciotransportesAux;
	}
	
	public void quitarServicioTransportesNulos() throws Exception {				
		
		List<ServicioTransporte> serviciotransportesAux= new ArrayList<ServicioTransporte>();
		
		for(ServicioTransporte serviciotransporte : this.serviciotransportes) {
			if(serviciotransporte==null) {
				serviciotransportesAux.add(serviciotransporte);
			}
		}
		
		//this.serviciotransportes=serviciotransportesAux;
		
		this.serviciotransportes.removeAll(serviciotransportesAux);
	}
	
	public void getSetVersionRowServicioTransporteWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(serviciotransporte.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((serviciotransporte.getIsDeleted() || (serviciotransporte.getIsChanged()&&!serviciotransporte.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=serviciotransporteDataAccess.getSetVersionRowServicioTransporte(connexion,serviciotransporte.getId());
				
				if(!serviciotransporte.getVersionRow().equals(timestamp)) {	
					serviciotransporte.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				serviciotransporte.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowServicioTransporte()throws Exception {	
		
		if(serviciotransporte.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((serviciotransporte.getIsDeleted() || (serviciotransporte.getIsChanged()&&!serviciotransporte.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=serviciotransporteDataAccess.getSetVersionRowServicioTransporte(connexion,serviciotransporte.getId());
			
			try {							
				if(!serviciotransporte.getVersionRow().equals(timestamp)) {	
					serviciotransporte.setVersionRow(timestamp);
				}
				
				serviciotransporte.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowServicioTransportesWithConnection()throws Exception {	
		if(serviciotransportes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ServicioTransporte serviciotransporteAux:serviciotransportes) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(serviciotransporteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(serviciotransporteAux.getIsDeleted() || (serviciotransporteAux.getIsChanged()&&!serviciotransporteAux.getIsNew())) {
						
						timestamp=serviciotransporteDataAccess.getSetVersionRowServicioTransporte(connexion,serviciotransporteAux.getId());
						
						if(!serviciotransporte.getVersionRow().equals(timestamp)) {	
							serviciotransporteAux.setVersionRow(timestamp);
						}
								
						serviciotransporteAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowServicioTransportes()throws Exception {	
		if(serviciotransportes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ServicioTransporte serviciotransporteAux:serviciotransportes) {
					if(serviciotransporteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(serviciotransporteAux.getIsDeleted() || (serviciotransporteAux.getIsChanged()&&!serviciotransporteAux.getIsNew())) {
						
						timestamp=serviciotransporteDataAccess.getSetVersionRowServicioTransporte(connexion,serviciotransporteAux.getId());
						
						if(!serviciotransporteAux.getVersionRow().equals(timestamp)) {	
							serviciotransporteAux.setVersionRow(timestamp);
						}
						
													
						serviciotransporteAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ServicioTransporteParameterReturnGeneral cargarCombosLoteForeignKeyServicioTransporteWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalCliente,String finalQueryGlobalClienteProveedor,String finalQueryGlobalTransportista,String finalQueryGlobalVehiculo,String finalQueryGlobalRutaTransporte,String finalQueryGlobalDetalleActivoFijo) throws Exception {
		ServicioTransporteParameterReturnGeneral  serviciotransporteReturnGeneral =new ServicioTransporteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ServicioTransporte.class.getSimpleName()+"-cargarCombosLoteForeignKeyServicioTransporteWithConnection");connexion.begin();
			
			serviciotransporteReturnGeneral =new ServicioTransporteParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			serviciotransporteReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			serviciotransporteReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			serviciotransporteReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			serviciotransporteReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			serviciotransporteReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Cliente> clienteproveedorsForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteproveedorLogic=new ClienteLogic();
			clienteproveedorLogic.setConnexion(this.connexion);
			clienteproveedorLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalClienteProveedor.equals("NONE")) {
				clienteproveedorLogic.getTodosClientes(finalQueryGlobalClienteProveedor,new Pagination());
				clienteproveedorsForeignKey=clienteproveedorLogic.getClientes();
			}

			serviciotransporteReturnGeneral.setclienteproveedorsForeignKey(clienteproveedorsForeignKey);


			List<Transportista> transportistasForeignKey=new ArrayList<Transportista>();
			TransportistaLogic transportistaLogic=new TransportistaLogic();
			transportistaLogic.setConnexion(this.connexion);
			transportistaLogic.getTransportistaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransportista.equals("NONE")) {
				transportistaLogic.getTodosTransportistas(finalQueryGlobalTransportista,new Pagination());
				transportistasForeignKey=transportistaLogic.getTransportistas();
			}

			serviciotransporteReturnGeneral.settransportistasForeignKey(transportistasForeignKey);


			List<Vehiculo> vehiculosForeignKey=new ArrayList<Vehiculo>();
			VehiculoLogic vehiculoLogic=new VehiculoLogic();
			vehiculoLogic.setConnexion(this.connexion);
			vehiculoLogic.getVehiculoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVehiculo.equals("NONE")) {
				vehiculoLogic.getTodosVehiculos(finalQueryGlobalVehiculo,new Pagination());
				vehiculosForeignKey=vehiculoLogic.getVehiculos();
			}

			serviciotransporteReturnGeneral.setvehiculosForeignKey(vehiculosForeignKey);


			List<RutaTransporte> rutatransportesForeignKey=new ArrayList<RutaTransporte>();
			RutaTransporteLogic rutatransporteLogic=new RutaTransporteLogic();
			rutatransporteLogic.setConnexion(this.connexion);
			rutatransporteLogic.getRutaTransporteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRutaTransporte.equals("NONE")) {
				rutatransporteLogic.getTodosRutaTransportes(finalQueryGlobalRutaTransporte,new Pagination());
				rutatransportesForeignKey=rutatransporteLogic.getRutaTransportes();
			}

			serviciotransporteReturnGeneral.setrutatransportesForeignKey(rutatransportesForeignKey);


			List<DetalleActivoFijo> detalleactivofijosForeignKey=new ArrayList<DetalleActivoFijo>();
			DetalleActivoFijoLogic detalleactivofijoLogic=new DetalleActivoFijoLogic();
			detalleactivofijoLogic.setConnexion(this.connexion);
			detalleactivofijoLogic.getDetalleActivoFijoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDetalleActivoFijo.equals("NONE")) {
				detalleactivofijoLogic.getTodosDetalleActivoFijos(finalQueryGlobalDetalleActivoFijo,new Pagination());
				detalleactivofijosForeignKey=detalleactivofijoLogic.getDetalleActivoFijos();
			}

			serviciotransporteReturnGeneral.setdetalleactivofijosForeignKey(detalleactivofijosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return serviciotransporteReturnGeneral;
	}
	
	public ServicioTransporteParameterReturnGeneral cargarCombosLoteForeignKeyServicioTransporte(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalCliente,String finalQueryGlobalClienteProveedor,String finalQueryGlobalTransportista,String finalQueryGlobalVehiculo,String finalQueryGlobalRutaTransporte,String finalQueryGlobalDetalleActivoFijo) throws Exception {
		ServicioTransporteParameterReturnGeneral  serviciotransporteReturnGeneral =new ServicioTransporteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			serviciotransporteReturnGeneral =new ServicioTransporteParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			serviciotransporteReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			serviciotransporteReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			serviciotransporteReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			serviciotransporteReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			serviciotransporteReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Cliente> clienteproveedorsForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteproveedorLogic=new ClienteLogic();
			clienteproveedorLogic.setConnexion(this.connexion);
			clienteproveedorLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalClienteProveedor.equals("NONE")) {
				clienteproveedorLogic.getTodosClientes(finalQueryGlobalClienteProveedor,new Pagination());
				clienteproveedorsForeignKey=clienteproveedorLogic.getClientes();
			}

			serviciotransporteReturnGeneral.setclienteproveedorsForeignKey(clienteproveedorsForeignKey);


			List<Transportista> transportistasForeignKey=new ArrayList<Transportista>();
			TransportistaLogic transportistaLogic=new TransportistaLogic();
			transportistaLogic.setConnexion(this.connexion);
			transportistaLogic.getTransportistaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransportista.equals("NONE")) {
				transportistaLogic.getTodosTransportistas(finalQueryGlobalTransportista,new Pagination());
				transportistasForeignKey=transportistaLogic.getTransportistas();
			}

			serviciotransporteReturnGeneral.settransportistasForeignKey(transportistasForeignKey);


			List<Vehiculo> vehiculosForeignKey=new ArrayList<Vehiculo>();
			VehiculoLogic vehiculoLogic=new VehiculoLogic();
			vehiculoLogic.setConnexion(this.connexion);
			vehiculoLogic.getVehiculoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalVehiculo.equals("NONE")) {
				vehiculoLogic.getTodosVehiculos(finalQueryGlobalVehiculo,new Pagination());
				vehiculosForeignKey=vehiculoLogic.getVehiculos();
			}

			serviciotransporteReturnGeneral.setvehiculosForeignKey(vehiculosForeignKey);


			List<RutaTransporte> rutatransportesForeignKey=new ArrayList<RutaTransporte>();
			RutaTransporteLogic rutatransporteLogic=new RutaTransporteLogic();
			rutatransporteLogic.setConnexion(this.connexion);
			rutatransporteLogic.getRutaTransporteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRutaTransporte.equals("NONE")) {
				rutatransporteLogic.getTodosRutaTransportes(finalQueryGlobalRutaTransporte,new Pagination());
				rutatransportesForeignKey=rutatransporteLogic.getRutaTransportes();
			}

			serviciotransporteReturnGeneral.setrutatransportesForeignKey(rutatransportesForeignKey);


			List<DetalleActivoFijo> detalleactivofijosForeignKey=new ArrayList<DetalleActivoFijo>();
			DetalleActivoFijoLogic detalleactivofijoLogic=new DetalleActivoFijoLogic();
			detalleactivofijoLogic.setConnexion(this.connexion);
			detalleactivofijoLogic.getDetalleActivoFijoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDetalleActivoFijo.equals("NONE")) {
				detalleactivofijoLogic.getTodosDetalleActivoFijos(finalQueryGlobalDetalleActivoFijo,new Pagination());
				detalleactivofijosForeignKey=detalleactivofijoLogic.getDetalleActivoFijos();
			}

			serviciotransporteReturnGeneral.setdetalleactivofijosForeignKey(detalleactivofijosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return serviciotransporteReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyServicioTransporteWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleServicioTransporteLogic detalleserviciotransporteLogic=new DetalleServicioTransporteLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ServicioTransporte.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyServicioTransporteWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleServicioTransporte.class));
											
			

			detalleserviciotransporteLogic.setConnexion(this.getConnexion());
			detalleserviciotransporteLogic.setDatosCliente(this.datosCliente);
			detalleserviciotransporteLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(ServicioTransporte serviciotransporte:this.serviciotransportes) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleServicioTransporteConstantesFunciones.getClassesForeignKeysOfDetalleServicioTransporte(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalleserviciotransporteLogic.setDetalleServicioTransportes(serviciotransporte.detalleserviciotransportes);
				detalleserviciotransporteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(ServicioTransporte serviciotransporte,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ServicioTransporteLogicAdditional.updateServicioTransporteToGet(serviciotransporte,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		serviciotransporte.setEmpresa(serviciotransporteDataAccess.getEmpresa(connexion,serviciotransporte));
		serviciotransporte.setSucursal(serviciotransporteDataAccess.getSucursal(connexion,serviciotransporte));
		serviciotransporte.setEjercicio(serviciotransporteDataAccess.getEjercicio(connexion,serviciotransporte));
		serviciotransporte.setPeriodo(serviciotransporteDataAccess.getPeriodo(connexion,serviciotransporte));
		serviciotransporte.setCliente(serviciotransporteDataAccess.getCliente(connexion,serviciotransporte));
		serviciotransporte.setClienteProveedor(serviciotransporteDataAccess.getClienteProveedor(connexion,serviciotransporte));
		serviciotransporte.setTransportista(serviciotransporteDataAccess.getTransportista(connexion,serviciotransporte));
		serviciotransporte.setVehiculo(serviciotransporteDataAccess.getVehiculo(connexion,serviciotransporte));
		serviciotransporte.setRutaTransporte(serviciotransporteDataAccess.getRutaTransporte(connexion,serviciotransporte));
		serviciotransporte.setDetalleActivoFijo(serviciotransporteDataAccess.getDetalleActivoFijo(connexion,serviciotransporte));
		serviciotransporte.setDetalleServicioTransportes(serviciotransporteDataAccess.getDetalleServicioTransportes(connexion,serviciotransporte));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				serviciotransporte.setEmpresa(serviciotransporteDataAccess.getEmpresa(connexion,serviciotransporte));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				serviciotransporte.setSucursal(serviciotransporteDataAccess.getSucursal(connexion,serviciotransporte));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				serviciotransporte.setEjercicio(serviciotransporteDataAccess.getEjercicio(connexion,serviciotransporte));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				serviciotransporte.setPeriodo(serviciotransporteDataAccess.getPeriodo(connexion,serviciotransporte));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				serviciotransporte.setCliente(serviciotransporteDataAccess.getCliente(connexion,serviciotransporte));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				serviciotransporte.setClienteProveedor(serviciotransporteDataAccess.getClienteProveedor(connexion,serviciotransporte));
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				serviciotransporte.setTransportista(serviciotransporteDataAccess.getTransportista(connexion,serviciotransporte));
				continue;
			}

			if(clas.clas.equals(Vehiculo.class)) {
				serviciotransporte.setVehiculo(serviciotransporteDataAccess.getVehiculo(connexion,serviciotransporte));
				continue;
			}

			if(clas.clas.equals(RutaTransporte.class)) {
				serviciotransporte.setRutaTransporte(serviciotransporteDataAccess.getRutaTransporte(connexion,serviciotransporte));
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)) {
				serviciotransporte.setDetalleActivoFijo(serviciotransporteDataAccess.getDetalleActivoFijo(connexion,serviciotransporte));
				continue;
			}

			if(clas.clas.equals(DetalleServicioTransporte.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				serviciotransporte.setDetalleServicioTransportes(serviciotransporteDataAccess.getDetalleServicioTransportes(connexion,serviciotransporte));

				if(this.isConDeep) {
					DetalleServicioTransporteLogic detalleserviciotransporteLogic= new DetalleServicioTransporteLogic(this.connexion);
					detalleserviciotransporteLogic.setDetalleServicioTransportes(serviciotransporte.getDetalleServicioTransportes());
					ArrayList<Classe> classesLocal=DetalleServicioTransporteConstantesFunciones.getClassesForeignKeysOfDetalleServicioTransporte(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalleserviciotransporteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleServicioTransporte(detalleserviciotransporteLogic.getDetalleServicioTransportes());
					serviciotransporte.setDetalleServicioTransportes(detalleserviciotransporteLogic.getDetalleServicioTransportes());
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
			serviciotransporte.setEmpresa(serviciotransporteDataAccess.getEmpresa(connexion,serviciotransporte));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			serviciotransporte.setSucursal(serviciotransporteDataAccess.getSucursal(connexion,serviciotransporte));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			serviciotransporte.setEjercicio(serviciotransporteDataAccess.getEjercicio(connexion,serviciotransporte));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			serviciotransporte.setPeriodo(serviciotransporteDataAccess.getPeriodo(connexion,serviciotransporte));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			serviciotransporte.setCliente(serviciotransporteDataAccess.getCliente(connexion,serviciotransporte));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			serviciotransporte.setClienteProveedor(serviciotransporteDataAccess.getClienteProveedor(connexion,serviciotransporte));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transportista.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			serviciotransporte.setTransportista(serviciotransporteDataAccess.getTransportista(connexion,serviciotransporte));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Vehiculo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			serviciotransporte.setVehiculo(serviciotransporteDataAccess.getVehiculo(connexion,serviciotransporte));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RutaTransporte.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			serviciotransporte.setRutaTransporte(serviciotransporteDataAccess.getRutaTransporte(connexion,serviciotransporte));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			serviciotransporte.setDetalleActivoFijo(serviciotransporteDataAccess.getDetalleActivoFijo(connexion,serviciotransporte));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleServicioTransporte.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleServicioTransporte.class));
			serviciotransporte.setDetalleServicioTransportes(serviciotransporteDataAccess.getDetalleServicioTransportes(connexion,serviciotransporte));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		serviciotransporte.setEmpresa(serviciotransporteDataAccess.getEmpresa(connexion,serviciotransporte));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(serviciotransporte.getEmpresa(),isDeep,deepLoadType,clases);
				
		serviciotransporte.setSucursal(serviciotransporteDataAccess.getSucursal(connexion,serviciotransporte));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(serviciotransporte.getSucursal(),isDeep,deepLoadType,clases);
				
		serviciotransporte.setEjercicio(serviciotransporteDataAccess.getEjercicio(connexion,serviciotransporte));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(serviciotransporte.getEjercicio(),isDeep,deepLoadType,clases);
				
		serviciotransporte.setPeriodo(serviciotransporteDataAccess.getPeriodo(connexion,serviciotransporte));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(serviciotransporte.getPeriodo(),isDeep,deepLoadType,clases);
				
		serviciotransporte.setCliente(serviciotransporteDataAccess.getCliente(connexion,serviciotransporte));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(serviciotransporte.getCliente(),isDeep,deepLoadType,clases);
				
		serviciotransporte.setClienteProveedor(serviciotransporteDataAccess.getClienteProveedor(connexion,serviciotransporte));
		ClienteLogic clienteproveedorLogic= new ClienteLogic(connexion);
		clienteproveedorLogic.deepLoad(serviciotransporte.getClienteProveedor(),isDeep,deepLoadType,clases);
				
		serviciotransporte.setTransportista(serviciotransporteDataAccess.getTransportista(connexion,serviciotransporte));
		TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
		transportistaLogic.deepLoad(serviciotransporte.getTransportista(),isDeep,deepLoadType,clases);
				
		serviciotransporte.setVehiculo(serviciotransporteDataAccess.getVehiculo(connexion,serviciotransporte));
		VehiculoLogic vehiculoLogic= new VehiculoLogic(connexion);
		vehiculoLogic.deepLoad(serviciotransporte.getVehiculo(),isDeep,deepLoadType,clases);
				
		serviciotransporte.setRutaTransporte(serviciotransporteDataAccess.getRutaTransporte(connexion,serviciotransporte));
		RutaTransporteLogic rutatransporteLogic= new RutaTransporteLogic(connexion);
		rutatransporteLogic.deepLoad(serviciotransporte.getRutaTransporte(),isDeep,deepLoadType,clases);
				
		serviciotransporte.setDetalleActivoFijo(serviciotransporteDataAccess.getDetalleActivoFijo(connexion,serviciotransporte));
		DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
		detalleactivofijoLogic.deepLoad(serviciotransporte.getDetalleActivoFijo(),isDeep,deepLoadType,clases);
				

		serviciotransporte.setDetalleServicioTransportes(serviciotransporteDataAccess.getDetalleServicioTransportes(connexion,serviciotransporte));

		for(DetalleServicioTransporte detalleserviciotransporte:serviciotransporte.getDetalleServicioTransportes()) {
			DetalleServicioTransporteLogic detalleserviciotransporteLogic= new DetalleServicioTransporteLogic(connexion);
			detalleserviciotransporteLogic.deepLoad(detalleserviciotransporte,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				serviciotransporte.setEmpresa(serviciotransporteDataAccess.getEmpresa(connexion,serviciotransporte));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(serviciotransporte.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				serviciotransporte.setSucursal(serviciotransporteDataAccess.getSucursal(connexion,serviciotransporte));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(serviciotransporte.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				serviciotransporte.setEjercicio(serviciotransporteDataAccess.getEjercicio(connexion,serviciotransporte));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(serviciotransporte.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				serviciotransporte.setPeriodo(serviciotransporteDataAccess.getPeriodo(connexion,serviciotransporte));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(serviciotransporte.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				serviciotransporte.setCliente(serviciotransporteDataAccess.getCliente(connexion,serviciotransporte));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(serviciotransporte.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				serviciotransporte.setClienteProveedor(serviciotransporteDataAccess.getClienteProveedor(connexion,serviciotransporte));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(serviciotransporte.getClienteProveedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				serviciotransporte.setTransportista(serviciotransporteDataAccess.getTransportista(connexion,serviciotransporte));
				TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
				transportistaLogic.deepLoad(serviciotransporte.getTransportista(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vehiculo.class)) {
				serviciotransporte.setVehiculo(serviciotransporteDataAccess.getVehiculo(connexion,serviciotransporte));
				VehiculoLogic vehiculoLogic= new VehiculoLogic(connexion);
				vehiculoLogic.deepLoad(serviciotransporte.getVehiculo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(RutaTransporte.class)) {
				serviciotransporte.setRutaTransporte(serviciotransporteDataAccess.getRutaTransporte(connexion,serviciotransporte));
				RutaTransporteLogic rutatransporteLogic= new RutaTransporteLogic(connexion);
				rutatransporteLogic.deepLoad(serviciotransporte.getRutaTransporte(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)) {
				serviciotransporte.setDetalleActivoFijo(serviciotransporteDataAccess.getDetalleActivoFijo(connexion,serviciotransporte));
				DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
				detalleactivofijoLogic.deepLoad(serviciotransporte.getDetalleActivoFijo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleServicioTransporte.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				serviciotransporte.setDetalleServicioTransportes(serviciotransporteDataAccess.getDetalleServicioTransportes(connexion,serviciotransporte));

				for(DetalleServicioTransporte detalleserviciotransporte:serviciotransporte.getDetalleServicioTransportes()) {
					DetalleServicioTransporteLogic detalleserviciotransporteLogic= new DetalleServicioTransporteLogic(connexion);
					detalleserviciotransporteLogic.deepLoad(detalleserviciotransporte,isDeep,deepLoadType,clases);
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
			serviciotransporte.setEmpresa(serviciotransporteDataAccess.getEmpresa(connexion,serviciotransporte));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(serviciotransporte.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			serviciotransporte.setSucursal(serviciotransporteDataAccess.getSucursal(connexion,serviciotransporte));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(serviciotransporte.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			serviciotransporte.setEjercicio(serviciotransporteDataAccess.getEjercicio(connexion,serviciotransporte));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(serviciotransporte.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			serviciotransporte.setPeriodo(serviciotransporteDataAccess.getPeriodo(connexion,serviciotransporte));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(serviciotransporte.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			serviciotransporte.setCliente(serviciotransporteDataAccess.getCliente(connexion,serviciotransporte));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(serviciotransporte.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			serviciotransporte.setClienteProveedor(serviciotransporteDataAccess.getClienteProveedor(connexion,serviciotransporte));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(serviciotransporte.getClienteProveedor(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transportista.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			serviciotransporte.setTransportista(serviciotransporteDataAccess.getTransportista(connexion,serviciotransporte));
			TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
			transportistaLogic.deepLoad(serviciotransporte.getTransportista(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Vehiculo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			serviciotransporte.setVehiculo(serviciotransporteDataAccess.getVehiculo(connexion,serviciotransporte));
			VehiculoLogic vehiculoLogic= new VehiculoLogic(connexion);
			vehiculoLogic.deepLoad(serviciotransporte.getVehiculo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(RutaTransporte.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			serviciotransporte.setRutaTransporte(serviciotransporteDataAccess.getRutaTransporte(connexion,serviciotransporte));
			RutaTransporteLogic rutatransporteLogic= new RutaTransporteLogic(connexion);
			rutatransporteLogic.deepLoad(serviciotransporte.getRutaTransporte(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			serviciotransporte.setDetalleActivoFijo(serviciotransporteDataAccess.getDetalleActivoFijo(connexion,serviciotransporte));
			DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
			detalleactivofijoLogic.deepLoad(serviciotransporte.getDetalleActivoFijo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleServicioTransporte.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleServicioTransporte.class));
			serviciotransporte.setDetalleServicioTransportes(serviciotransporteDataAccess.getDetalleServicioTransportes(connexion,serviciotransporte));

			for(DetalleServicioTransporte detalleserviciotransporte:serviciotransporte.getDetalleServicioTransportes()) {
				DetalleServicioTransporteLogic detalleserviciotransporteLogic= new DetalleServicioTransporteLogic(connexion);
				detalleserviciotransporteLogic.deepLoad(detalleserviciotransporte,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ServicioTransporte serviciotransporte,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ServicioTransporteLogicAdditional.updateServicioTransporteToSave(serviciotransporte,this.arrDatoGeneral);
			
ServicioTransporteDataAccess.save(serviciotransporte, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(serviciotransporte.getEmpresa(),connexion);

		SucursalDataAccess.save(serviciotransporte.getSucursal(),connexion);

		EjercicioDataAccess.save(serviciotransporte.getEjercicio(),connexion);

		PeriodoDataAccess.save(serviciotransporte.getPeriodo(),connexion);

		ClienteDataAccess.save(serviciotransporte.getCliente(),connexion);

		ClienteDataAccess.save(serviciotransporte.getClienteProveedor(),connexion);

		TransportistaDataAccess.save(serviciotransporte.getTransportista(),connexion);

		VehiculoDataAccess.save(serviciotransporte.getVehiculo(),connexion);

		RutaTransporteDataAccess.save(serviciotransporte.getRutaTransporte(),connexion);

		DetalleActivoFijoDataAccess.save(serviciotransporte.getDetalleActivoFijo(),connexion);

		for(DetalleServicioTransporte detalleserviciotransporte:serviciotransporte.getDetalleServicioTransportes()) {
			detalleserviciotransporte.setid_servicio_transporte(serviciotransporte.getId());
			DetalleServicioTransporteDataAccess.save(detalleserviciotransporte,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(serviciotransporte.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(serviciotransporte.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(serviciotransporte.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(serviciotransporte.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(serviciotransporte.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(serviciotransporte.getClienteProveedor(),connexion);
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				TransportistaDataAccess.save(serviciotransporte.getTransportista(),connexion);
				continue;
			}

			if(clas.clas.equals(Vehiculo.class)) {
				VehiculoDataAccess.save(serviciotransporte.getVehiculo(),connexion);
				continue;
			}

			if(clas.clas.equals(RutaTransporte.class)) {
				RutaTransporteDataAccess.save(serviciotransporte.getRutaTransporte(),connexion);
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)) {
				DetalleActivoFijoDataAccess.save(serviciotransporte.getDetalleActivoFijo(),connexion);
				continue;
			}


			if(clas.clas.equals(DetalleServicioTransporte.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleServicioTransporte detalleserviciotransporte:serviciotransporte.getDetalleServicioTransportes()) {
					detalleserviciotransporte.setid_servicio_transporte(serviciotransporte.getId());
					DetalleServicioTransporteDataAccess.save(detalleserviciotransporte,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(serviciotransporte.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(serviciotransporte.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(serviciotransporte.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(serviciotransporte.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(serviciotransporte.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(serviciotransporte.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(serviciotransporte.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(serviciotransporte.getPeriodo(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(serviciotransporte.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(serviciotransporte.getCliente(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(serviciotransporte.getClienteProveedor(),connexion);
		ClienteLogic clienteproveedorLogic= new ClienteLogic(connexion);
		clienteproveedorLogic.deepLoad(serviciotransporte.getClienteProveedor(),isDeep,deepLoadType,clases);
				

		TransportistaDataAccess.save(serviciotransporte.getTransportista(),connexion);
		TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
		transportistaLogic.deepLoad(serviciotransporte.getTransportista(),isDeep,deepLoadType,clases);
				

		VehiculoDataAccess.save(serviciotransporte.getVehiculo(),connexion);
		VehiculoLogic vehiculoLogic= new VehiculoLogic(connexion);
		vehiculoLogic.deepLoad(serviciotransporte.getVehiculo(),isDeep,deepLoadType,clases);
				

		RutaTransporteDataAccess.save(serviciotransporte.getRutaTransporte(),connexion);
		RutaTransporteLogic rutatransporteLogic= new RutaTransporteLogic(connexion);
		rutatransporteLogic.deepLoad(serviciotransporte.getRutaTransporte(),isDeep,deepLoadType,clases);
				

		DetalleActivoFijoDataAccess.save(serviciotransporte.getDetalleActivoFijo(),connexion);
		DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
		detalleactivofijoLogic.deepLoad(serviciotransporte.getDetalleActivoFijo(),isDeep,deepLoadType,clases);
				

		for(DetalleServicioTransporte detalleserviciotransporte:serviciotransporte.getDetalleServicioTransportes()) {
			DetalleServicioTransporteLogic detalleserviciotransporteLogic= new DetalleServicioTransporteLogic(connexion);
			detalleserviciotransporte.setid_servicio_transporte(serviciotransporte.getId());
			DetalleServicioTransporteDataAccess.save(detalleserviciotransporte,connexion);
			detalleserviciotransporteLogic.deepSave(detalleserviciotransporte,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(serviciotransporte.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(serviciotransporte.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(serviciotransporte.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(serviciotransporte.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(serviciotransporte.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(serviciotransporte.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(serviciotransporte.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(serviciotransporte.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(serviciotransporte.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(serviciotransporte.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(serviciotransporte.getClienteProveedor(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(serviciotransporte.getClienteProveedor(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transportista.class)) {
				TransportistaDataAccess.save(serviciotransporte.getTransportista(),connexion);
				TransportistaLogic transportistaLogic= new TransportistaLogic(connexion);
				transportistaLogic.deepSave(serviciotransporte.getTransportista(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Vehiculo.class)) {
				VehiculoDataAccess.save(serviciotransporte.getVehiculo(),connexion);
				VehiculoLogic vehiculoLogic= new VehiculoLogic(connexion);
				vehiculoLogic.deepSave(serviciotransporte.getVehiculo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(RutaTransporte.class)) {
				RutaTransporteDataAccess.save(serviciotransporte.getRutaTransporte(),connexion);
				RutaTransporteLogic rutatransporteLogic= new RutaTransporteLogic(connexion);
				rutatransporteLogic.deepSave(serviciotransporte.getRutaTransporte(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleActivoFijo.class)) {
				DetalleActivoFijoDataAccess.save(serviciotransporte.getDetalleActivoFijo(),connexion);
				DetalleActivoFijoLogic detalleactivofijoLogic= new DetalleActivoFijoLogic(connexion);
				detalleactivofijoLogic.deepSave(serviciotransporte.getDetalleActivoFijo(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetalleServicioTransporte.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleServicioTransporte detalleserviciotransporte:serviciotransporte.getDetalleServicioTransportes()) {
					DetalleServicioTransporteLogic detalleserviciotransporteLogic= new DetalleServicioTransporteLogic(connexion);
					detalleserviciotransporte.setid_servicio_transporte(serviciotransporte.getId());
					DetalleServicioTransporteDataAccess.save(detalleserviciotransporte,connexion);
					detalleserviciotransporteLogic.deepSave(detalleserviciotransporte,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(ServicioTransporte.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(serviciotransporte,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(serviciotransporte);
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
			this.deepLoad(this.serviciotransporte,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(this.serviciotransporte);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ServicioTransporte.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(serviciotransportes!=null) {
				for(ServicioTransporte serviciotransporte:serviciotransportes) {
					this.deepLoad(serviciotransporte,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(serviciotransportes);
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
			if(serviciotransportes!=null) {
				for(ServicioTransporte serviciotransporte:serviciotransportes) {
					this.deepLoad(serviciotransporte,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(serviciotransportes);
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
			this.getNewConnexionToDeep(ServicioTransporte.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(serviciotransporte,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ServicioTransporte.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(serviciotransportes!=null) {
				for(ServicioTransporte serviciotransporte:serviciotransportes) {
					this.deepSave(serviciotransporte,isDeep,deepLoadType,clases);
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
			if(serviciotransportes!=null) {
				for(ServicioTransporte serviciotransporte:serviciotransportes) {
					this.deepSave(serviciotransporte,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getServicioTransportesFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ServicioTransporte.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,ServicioTransporteConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			ServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			serviciotransportes=serviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(this.serviciotransportes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getServicioTransportesFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,ServicioTransporteConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			ServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			serviciotransportes=serviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(this.serviciotransportes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getServicioTransportesFK_IdClienteProveedorWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente_proveedor)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ServicioTransporte.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidClienteProveedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidClienteProveedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente_proveedor,ServicioTransporteConstantesFunciones.IDCLIENTEPROVEEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidClienteProveedor);

			ServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdClienteProveedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			serviciotransportes=serviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(this.serviciotransportes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getServicioTransportesFK_IdClienteProveedor(String sFinalQuery,Pagination pagination,Long id_cliente_proveedor)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidClienteProveedor= new ParameterSelectionGeneral();
			parameterSelectionGeneralidClienteProveedor.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente_proveedor,ServicioTransporteConstantesFunciones.IDCLIENTEPROVEEDOR,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidClienteProveedor);

			ServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdClienteProveedor","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			serviciotransportes=serviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(this.serviciotransportes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getServicioTransportesFK_IdDetalleActivoFijoWithConnection(String sFinalQuery,Pagination pagination,Long id_detalle_activo_fijo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ServicioTransporte.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDetalleActivoFijo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDetalleActivoFijo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_detalle_activo_fijo,ServicioTransporteConstantesFunciones.IDDETALLEACTIVOFIJO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDetalleActivoFijo);

			ServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleActivoFijo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			serviciotransportes=serviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(this.serviciotransportes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getServicioTransportesFK_IdDetalleActivoFijo(String sFinalQuery,Pagination pagination,Long id_detalle_activo_fijo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDetalleActivoFijo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDetalleActivoFijo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_detalle_activo_fijo,ServicioTransporteConstantesFunciones.IDDETALLEACTIVOFIJO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDetalleActivoFijo);

			ServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleActivoFijo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			serviciotransportes=serviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(this.serviciotransportes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getServicioTransportesFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ServicioTransporte.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,ServicioTransporteConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			ServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			serviciotransportes=serviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(this.serviciotransportes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getServicioTransportesFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,ServicioTransporteConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			ServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			serviciotransportes=serviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(this.serviciotransportes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getServicioTransportesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ServicioTransporte.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ServicioTransporteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			serviciotransportes=serviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(this.serviciotransportes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getServicioTransportesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ServicioTransporteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			serviciotransportes=serviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(this.serviciotransportes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getServicioTransportesFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ServicioTransporte.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,ServicioTransporteConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			ServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			serviciotransportes=serviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(this.serviciotransportes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getServicioTransportesFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,ServicioTransporteConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			ServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			serviciotransportes=serviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(this.serviciotransportes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getServicioTransportesFK_IdRutaTransporteWithConnection(String sFinalQuery,Pagination pagination,Long id_ruta_transporte)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ServicioTransporte.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRutaTransporte= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRutaTransporte.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ruta_transporte,ServicioTransporteConstantesFunciones.IDRUTATRANSPORTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRutaTransporte);

			ServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRutaTransporte","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			serviciotransportes=serviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(this.serviciotransportes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getServicioTransportesFK_IdRutaTransporte(String sFinalQuery,Pagination pagination,Long id_ruta_transporte)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRutaTransporte= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRutaTransporte.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ruta_transporte,ServicioTransporteConstantesFunciones.IDRUTATRANSPORTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRutaTransporte);

			ServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRutaTransporte","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			serviciotransportes=serviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(this.serviciotransportes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getServicioTransportesFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ServicioTransporte.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ServicioTransporteConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			serviciotransportes=serviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(this.serviciotransportes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getServicioTransportesFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ServicioTransporteConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			serviciotransportes=serviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(this.serviciotransportes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getServicioTransportesFK_IdTransportistaWithConnection(String sFinalQuery,Pagination pagination,Long id_transportista)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ServicioTransporte.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransportista= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransportista.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transportista,ServicioTransporteConstantesFunciones.IDTRANSPORTISTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransportista);

			ServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransportista","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			serviciotransportes=serviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(this.serviciotransportes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getServicioTransportesFK_IdTransportista(String sFinalQuery,Pagination pagination,Long id_transportista)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransportista= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransportista.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transportista,ServicioTransporteConstantesFunciones.IDTRANSPORTISTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransportista);

			ServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransportista","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			serviciotransportes=serviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(this.serviciotransportes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getServicioTransportesFK_IdVehiculoWithConnection(String sFinalQuery,Pagination pagination,Long id_vehiculo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ServicioTransporte.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVehiculo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVehiculo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vehiculo,ServicioTransporteConstantesFunciones.IDVEHICULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVehiculo);

			ServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVehiculo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			serviciotransportes=serviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(this.serviciotransportes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getServicioTransportesFK_IdVehiculo(String sFinalQuery,Pagination pagination,Long id_vehiculo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidVehiculo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidVehiculo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_vehiculo,ServicioTransporteConstantesFunciones.IDVEHICULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidVehiculo);

			ServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdVehiculo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			serviciotransportes=serviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesServicioTransporte(this.serviciotransportes);
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
			if(ServicioTransporteConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ServicioTransporteDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ServicioTransporte serviciotransporte,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ServicioTransporteConstantesFunciones.ISCONAUDITORIA) {
				if(serviciotransporte.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ServicioTransporteDataAccess.TABLENAME, serviciotransporte.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ServicioTransporteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ServicioTransporteLogic.registrarAuditoriaDetallesServicioTransporte(connexion,serviciotransporte,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(serviciotransporte.getIsDeleted()) {
					/*if(!serviciotransporte.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ServicioTransporteDataAccess.TABLENAME, serviciotransporte.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ServicioTransporteLogic.registrarAuditoriaDetallesServicioTransporte(connexion,serviciotransporte,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ServicioTransporteDataAccess.TABLENAME, serviciotransporte.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(serviciotransporte.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ServicioTransporteDataAccess.TABLENAME, serviciotransporte.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ServicioTransporteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ServicioTransporteLogic.registrarAuditoriaDetallesServicioTransporte(connexion,serviciotransporte,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesServicioTransporte(Connexion connexion,ServicioTransporte serviciotransporte)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(serviciotransporte.getIsNew()||!serviciotransporte.getid_empresa().equals(serviciotransporte.getServicioTransporteOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(serviciotransporte.getServicioTransporteOriginal().getid_empresa()!=null)
				{
					strValorActual=serviciotransporte.getServicioTransporteOriginal().getid_empresa().toString();
				}
				if(serviciotransporte.getid_empresa()!=null)
				{
					strValorNuevo=serviciotransporte.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ServicioTransporteConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(serviciotransporte.getIsNew()||!serviciotransporte.getid_sucursal().equals(serviciotransporte.getServicioTransporteOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(serviciotransporte.getServicioTransporteOriginal().getid_sucursal()!=null)
				{
					strValorActual=serviciotransporte.getServicioTransporteOriginal().getid_sucursal().toString();
				}
				if(serviciotransporte.getid_sucursal()!=null)
				{
					strValorNuevo=serviciotransporte.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ServicioTransporteConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(serviciotransporte.getIsNew()||!serviciotransporte.getid_ejercicio().equals(serviciotransporte.getServicioTransporteOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(serviciotransporte.getServicioTransporteOriginal().getid_ejercicio()!=null)
				{
					strValorActual=serviciotransporte.getServicioTransporteOriginal().getid_ejercicio().toString();
				}
				if(serviciotransporte.getid_ejercicio()!=null)
				{
					strValorNuevo=serviciotransporte.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ServicioTransporteConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(serviciotransporte.getIsNew()||!serviciotransporte.getid_periodo().equals(serviciotransporte.getServicioTransporteOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(serviciotransporte.getServicioTransporteOriginal().getid_periodo()!=null)
				{
					strValorActual=serviciotransporte.getServicioTransporteOriginal().getid_periodo().toString();
				}
				if(serviciotransporte.getid_periodo()!=null)
				{
					strValorNuevo=serviciotransporte.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ServicioTransporteConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(serviciotransporte.getIsNew()||!serviciotransporte.getid_cliente().equals(serviciotransporte.getServicioTransporteOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(serviciotransporte.getServicioTransporteOriginal().getid_cliente()!=null)
				{
					strValorActual=serviciotransporte.getServicioTransporteOriginal().getid_cliente().toString();
				}
				if(serviciotransporte.getid_cliente()!=null)
				{
					strValorNuevo=serviciotransporte.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ServicioTransporteConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(serviciotransporte.getIsNew()||!serviciotransporte.getid_cliente_proveedor().equals(serviciotransporte.getServicioTransporteOriginal().getid_cliente_proveedor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(serviciotransporte.getServicioTransporteOriginal().getid_cliente_proveedor()!=null)
				{
					strValorActual=serviciotransporte.getServicioTransporteOriginal().getid_cliente_proveedor().toString();
				}
				if(serviciotransporte.getid_cliente_proveedor()!=null)
				{
					strValorNuevo=serviciotransporte.getid_cliente_proveedor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ServicioTransporteConstantesFunciones.IDCLIENTEPROVEEDOR,strValorActual,strValorNuevo);
			}	
			
			if(serviciotransporte.getIsNew()||!serviciotransporte.getid_transportista().equals(serviciotransporte.getServicioTransporteOriginal().getid_transportista()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(serviciotransporte.getServicioTransporteOriginal().getid_transportista()!=null)
				{
					strValorActual=serviciotransporte.getServicioTransporteOriginal().getid_transportista().toString();
				}
				if(serviciotransporte.getid_transportista()!=null)
				{
					strValorNuevo=serviciotransporte.getid_transportista().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ServicioTransporteConstantesFunciones.IDTRANSPORTISTA,strValorActual,strValorNuevo);
			}	
			
			if(serviciotransporte.getIsNew()||!serviciotransporte.getid_vehiculo().equals(serviciotransporte.getServicioTransporteOriginal().getid_vehiculo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(serviciotransporte.getServicioTransporteOriginal().getid_vehiculo()!=null)
				{
					strValorActual=serviciotransporte.getServicioTransporteOriginal().getid_vehiculo().toString();
				}
				if(serviciotransporte.getid_vehiculo()!=null)
				{
					strValorNuevo=serviciotransporte.getid_vehiculo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ServicioTransporteConstantesFunciones.IDVEHICULO,strValorActual,strValorNuevo);
			}	
			
			if(serviciotransporte.getIsNew()||!serviciotransporte.getid_ruta_transporte().equals(serviciotransporte.getServicioTransporteOriginal().getid_ruta_transporte()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(serviciotransporte.getServicioTransporteOriginal().getid_ruta_transporte()!=null)
				{
					strValorActual=serviciotransporte.getServicioTransporteOriginal().getid_ruta_transporte().toString();
				}
				if(serviciotransporte.getid_ruta_transporte()!=null)
				{
					strValorNuevo=serviciotransporte.getid_ruta_transporte().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ServicioTransporteConstantesFunciones.IDRUTATRANSPORTE,strValorActual,strValorNuevo);
			}	
			
			if(serviciotransporte.getIsNew()||!serviciotransporte.getid_detalle_activo_fijo().equals(serviciotransporte.getServicioTransporteOriginal().getid_detalle_activo_fijo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(serviciotransporte.getServicioTransporteOriginal().getid_detalle_activo_fijo()!=null)
				{
					strValorActual=serviciotransporte.getServicioTransporteOriginal().getid_detalle_activo_fijo().toString();
				}
				if(serviciotransporte.getid_detalle_activo_fijo()!=null)
				{
					strValorNuevo=serviciotransporte.getid_detalle_activo_fijo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ServicioTransporteConstantesFunciones.IDDETALLEACTIVOFIJO,strValorActual,strValorNuevo);
			}	
			
			if(serviciotransporte.getIsNew()||!serviciotransporte.getfecha_ingreso().equals(serviciotransporte.getServicioTransporteOriginal().getfecha_ingreso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(serviciotransporte.getServicioTransporteOriginal().getfecha_ingreso()!=null)
				{
					strValorActual=serviciotransporte.getServicioTransporteOriginal().getfecha_ingreso().toString();
				}
				if(serviciotransporte.getfecha_ingreso()!=null)
				{
					strValorNuevo=serviciotransporte.getfecha_ingreso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ServicioTransporteConstantesFunciones.FECHAINGRESO,strValorActual,strValorNuevo);
			}	
			
			if(serviciotransporte.getIsNew()||!serviciotransporte.getfecha_entrega().equals(serviciotransporte.getServicioTransporteOriginal().getfecha_entrega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(serviciotransporte.getServicioTransporteOriginal().getfecha_entrega()!=null)
				{
					strValorActual=serviciotransporte.getServicioTransporteOriginal().getfecha_entrega().toString();
				}
				if(serviciotransporte.getfecha_entrega()!=null)
				{
					strValorNuevo=serviciotransporte.getfecha_entrega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ServicioTransporteConstantesFunciones.FECHAENTREGA,strValorActual,strValorNuevo);
			}	
			
			if(serviciotransporte.getIsNew()||!serviciotransporte.getcodigo_guia1().equals(serviciotransporte.getServicioTransporteOriginal().getcodigo_guia1()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(serviciotransporte.getServicioTransporteOriginal().getcodigo_guia1()!=null)
				{
					strValorActual=serviciotransporte.getServicioTransporteOriginal().getcodigo_guia1();
				}
				if(serviciotransporte.getcodigo_guia1()!=null)
				{
					strValorNuevo=serviciotransporte.getcodigo_guia1() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ServicioTransporteConstantesFunciones.CODIGOGUIA1,strValorActual,strValorNuevo);
			}	
			
			if(serviciotransporte.getIsNew()||!serviciotransporte.getcodigo_guia2().equals(serviciotransporte.getServicioTransporteOriginal().getcodigo_guia2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(serviciotransporte.getServicioTransporteOriginal().getcodigo_guia2()!=null)
				{
					strValorActual=serviciotransporte.getServicioTransporteOriginal().getcodigo_guia2();
				}
				if(serviciotransporte.getcodigo_guia2()!=null)
				{
					strValorNuevo=serviciotransporte.getcodigo_guia2() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ServicioTransporteConstantesFunciones.CODIGOGUIA2,strValorActual,strValorNuevo);
			}	
			
			if(serviciotransporte.getIsNew()||!serviciotransporte.getprecio().equals(serviciotransporte.getServicioTransporteOriginal().getprecio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(serviciotransporte.getServicioTransporteOriginal().getprecio()!=null)
				{
					strValorActual=serviciotransporte.getServicioTransporteOriginal().getprecio().toString();
				}
				if(serviciotransporte.getprecio()!=null)
				{
					strValorNuevo=serviciotransporte.getprecio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ServicioTransporteConstantesFunciones.PRECIO,strValorActual,strValorNuevo);
			}	
			
			if(serviciotransporte.getIsNew()||!serviciotransporte.getvalor_iva().equals(serviciotransporte.getServicioTransporteOriginal().getvalor_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(serviciotransporte.getServicioTransporteOriginal().getvalor_iva()!=null)
				{
					strValorActual=serviciotransporte.getServicioTransporteOriginal().getvalor_iva().toString();
				}
				if(serviciotransporte.getvalor_iva()!=null)
				{
					strValorNuevo=serviciotransporte.getvalor_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ServicioTransporteConstantesFunciones.VALORIVA,strValorActual,strValorNuevo);
			}	
			
			if(serviciotransporte.getIsNew()||!serviciotransporte.getvalor_total().equals(serviciotransporte.getServicioTransporteOriginal().getvalor_total()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(serviciotransporte.getServicioTransporteOriginal().getvalor_total()!=null)
				{
					strValorActual=serviciotransporte.getServicioTransporteOriginal().getvalor_total().toString();
				}
				if(serviciotransporte.getvalor_total()!=null)
				{
					strValorNuevo=serviciotransporte.getvalor_total().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ServicioTransporteConstantesFunciones.VALORTOTAL,strValorActual,strValorNuevo);
			}	
			
			if(serviciotransporte.getIsNew()||!serviciotransporte.getdescripcion().equals(serviciotransporte.getServicioTransporteOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(serviciotransporte.getServicioTransporteOriginal().getdescripcion()!=null)
				{
					strValorActual=serviciotransporte.getServicioTransporteOriginal().getdescripcion();
				}
				if(serviciotransporte.getdescripcion()!=null)
				{
					strValorNuevo=serviciotransporte.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ServicioTransporteConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveServicioTransporteRelacionesWithConnection(ServicioTransporte serviciotransporte,List<DetalleServicioTransporte> detalleserviciotransportes) throws Exception {

		if(!serviciotransporte.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveServicioTransporteRelacionesBase(serviciotransporte,detalleserviciotransportes,true);
		}
	}

	public void saveServicioTransporteRelaciones(ServicioTransporte serviciotransporte,List<DetalleServicioTransporte> detalleserviciotransportes)throws Exception {

		if(!serviciotransporte.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveServicioTransporteRelacionesBase(serviciotransporte,detalleserviciotransportes,false);
		}
	}

	public void saveServicioTransporteRelacionesBase(ServicioTransporte serviciotransporte,List<DetalleServicioTransporte> detalleserviciotransportes,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ServicioTransporte-saveRelacionesWithConnection");}
	
			serviciotransporte.setDetalleServicioTransportes(detalleserviciotransportes);

			this.setServicioTransporte(serviciotransporte);

			if(ServicioTransporteLogicAdditional.validarSaveRelaciones(serviciotransporte,this)) {

				ServicioTransporteLogicAdditional.updateRelacionesToSave(serviciotransporte,this);

				if((serviciotransporte.getIsNew()||serviciotransporte.getIsChanged())&&!serviciotransporte.getIsDeleted()) {
					this.saveServicioTransporte();
					this.saveServicioTransporteRelacionesDetalles(detalleserviciotransportes);

				} else if(serviciotransporte.getIsDeleted()) {
					this.saveServicioTransporteRelacionesDetalles(detalleserviciotransportes);
					this.saveServicioTransporte();
				}

				ServicioTransporteLogicAdditional.updateRelacionesToSaveAfter(serviciotransporte,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetalleServicioTransporteConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleServicioTransportes(detalleserviciotransportes,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveServicioTransporteRelacionesDetalles(List<DetalleServicioTransporte> detalleserviciotransportes)throws Exception {
		try {
	

			Long idServicioTransporteActual=this.getServicioTransporte().getId();

			DetalleServicioTransporteLogic detalleserviciotransporteLogic_Desde_ServicioTransporte=new DetalleServicioTransporteLogic();
			detalleserviciotransporteLogic_Desde_ServicioTransporte.setDetalleServicioTransportes(detalleserviciotransportes);

			detalleserviciotransporteLogic_Desde_ServicioTransporte.setConnexion(this.getConnexion());
			detalleserviciotransporteLogic_Desde_ServicioTransporte.setDatosCliente(this.datosCliente);

			for(DetalleServicioTransporte detalleserviciotransporte_Desde_ServicioTransporte:detalleserviciotransporteLogic_Desde_ServicioTransporte.getDetalleServicioTransportes()) {
				detalleserviciotransporte_Desde_ServicioTransporte.setid_servicio_transporte(idServicioTransporteActual);
			}

			detalleserviciotransporteLogic_Desde_ServicioTransporte.saveDetalleServicioTransportes();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfServicioTransporte(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ServicioTransporteConstantesFunciones.getClassesForeignKeysOfServicioTransporte(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfServicioTransporte(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ServicioTransporteConstantesFunciones.getClassesRelationshipsOfServicioTransporte(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

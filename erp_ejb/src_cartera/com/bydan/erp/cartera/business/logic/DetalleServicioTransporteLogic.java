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
import com.bydan.erp.cartera.util.DetalleServicioTransporteConstantesFunciones;
import com.bydan.erp.cartera.util.DetalleServicioTransporteParameterReturnGeneral;
//import com.bydan.erp.cartera.util.DetalleServicioTransporteParameterGeneral;
import com.bydan.erp.cartera.business.entity.DetalleServicioTransporte;
import com.bydan.erp.cartera.business.logic.DetalleServicioTransporteLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class DetalleServicioTransporteLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetalleServicioTransporteLogic.class);
	
	protected DetalleServicioTransporteDataAccess detalleserviciotransporteDataAccess; 	
	protected DetalleServicioTransporte detalleserviciotransporte;
	protected List<DetalleServicioTransporte> detalleserviciotransportes;
	protected Object detalleserviciotransporteObject;	
	protected List<Object> detalleserviciotransportesObject;
	
	public static ClassValidator<DetalleServicioTransporte> detalleserviciotransporteValidator = new ClassValidator<DetalleServicioTransporte>(DetalleServicioTransporte.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetalleServicioTransporteLogicAdditional detalleserviciotransporteLogicAdditional=null;
	
	public DetalleServicioTransporteLogicAdditional getDetalleServicioTransporteLogicAdditional() {
		return this.detalleserviciotransporteLogicAdditional;
	}
	
	public void setDetalleServicioTransporteLogicAdditional(DetalleServicioTransporteLogicAdditional detalleserviciotransporteLogicAdditional) {
		try {
			this.detalleserviciotransporteLogicAdditional=detalleserviciotransporteLogicAdditional;
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
	
	
	
	
	public  DetalleServicioTransporteLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detalleserviciotransporteDataAccess = new DetalleServicioTransporteDataAccess();
			
			this.detalleserviciotransportes= new ArrayList<DetalleServicioTransporte>();
			this.detalleserviciotransporte= new DetalleServicioTransporte();
			
			this.detalleserviciotransporteObject=new Object();
			this.detalleserviciotransportesObject=new ArrayList<Object>();
				
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
			
			this.detalleserviciotransporteDataAccess.setConnexionType(this.connexionType);
			this.detalleserviciotransporteDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetalleServicioTransporteLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detalleserviciotransporteDataAccess = new DetalleServicioTransporteDataAccess();
			this.detalleserviciotransportes= new ArrayList<DetalleServicioTransporte>();
			this.detalleserviciotransporte= new DetalleServicioTransporte();
			this.detalleserviciotransporteObject=new Object();
			this.detalleserviciotransportesObject=new ArrayList<Object>();
			
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
			
			this.detalleserviciotransporteDataAccess.setConnexionType(this.connexionType);
			this.detalleserviciotransporteDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetalleServicioTransporte getDetalleServicioTransporte() throws Exception {	
		DetalleServicioTransporteLogicAdditional.checkDetalleServicioTransporteToGet(detalleserviciotransporte,this.datosCliente,this.arrDatoGeneral);
		DetalleServicioTransporteLogicAdditional.updateDetalleServicioTransporteToGet(detalleserviciotransporte,this.arrDatoGeneral);
		
		return detalleserviciotransporte;
	}
		
	public void setDetalleServicioTransporte(DetalleServicioTransporte newDetalleServicioTransporte) {
		this.detalleserviciotransporte = newDetalleServicioTransporte;
	}
	
	public DetalleServicioTransporteDataAccess getDetalleServicioTransporteDataAccess() {
		return detalleserviciotransporteDataAccess;
	}
	
	public void setDetalleServicioTransporteDataAccess(DetalleServicioTransporteDataAccess newdetalleserviciotransporteDataAccess) {
		this.detalleserviciotransporteDataAccess = newdetalleserviciotransporteDataAccess;
	}
	
	public List<DetalleServicioTransporte> getDetalleServicioTransportes() throws Exception {		
		this.quitarDetalleServicioTransportesNulos();
		
		DetalleServicioTransporteLogicAdditional.checkDetalleServicioTransporteToGets(detalleserviciotransportes,this.datosCliente,this.arrDatoGeneral);
		
		for (DetalleServicioTransporte detalleserviciotransporteLocal: detalleserviciotransportes ) {
			DetalleServicioTransporteLogicAdditional.updateDetalleServicioTransporteToGet(detalleserviciotransporteLocal,this.arrDatoGeneral);
		}
		
		return detalleserviciotransportes;
	}
	
	public void setDetalleServicioTransportes(List<DetalleServicioTransporte> newDetalleServicioTransportes) {
		this.detalleserviciotransportes = newDetalleServicioTransportes;
	}
	
	public Object getDetalleServicioTransporteObject() {	
		this.detalleserviciotransporteObject=this.detalleserviciotransporteDataAccess.getEntityObject();
		return this.detalleserviciotransporteObject;
	}
		
	public void setDetalleServicioTransporteObject(Object newDetalleServicioTransporteObject) {
		this.detalleserviciotransporteObject = newDetalleServicioTransporteObject;
	}
	
	public List<Object> getDetalleServicioTransportesObject() {		
		this.detalleserviciotransportesObject=this.detalleserviciotransporteDataAccess.getEntitiesObject();
		return this.detalleserviciotransportesObject;
	}
		
	public void setDetalleServicioTransportesObject(List<Object> newDetalleServicioTransportesObject) {
		this.detalleserviciotransportesObject = newDetalleServicioTransportesObject;
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
		
		if(this.detalleserviciotransporteDataAccess!=null) {
			this.detalleserviciotransporteDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleServicioTransporte.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detalleserviciotransporteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detalleserviciotransporteDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detalleserviciotransporte = new  DetalleServicioTransporte();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleServicioTransporte.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalleserviciotransporte=detalleserviciotransporteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleserviciotransporte,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleServicioTransporte(this.detalleserviciotransporte);
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
		detalleserviciotransporte = new  DetalleServicioTransporte();
		  		  
        try {
			
			detalleserviciotransporte=detalleserviciotransporteDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleserviciotransporte,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleServicioTransporte(this.detalleserviciotransporte);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detalleserviciotransporte = new  DetalleServicioTransporte();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleServicioTransporte.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalleserviciotransporte=detalleserviciotransporteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleserviciotransporte,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleServicioTransporte(this.detalleserviciotransporte);
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
		detalleserviciotransporte = new  DetalleServicioTransporte();
		  		  
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
		detalleserviciotransporte = new  DetalleServicioTransporte();
		  		  
        try {
			
			detalleserviciotransporte=detalleserviciotransporteDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleserviciotransporte,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleServicioTransporte(this.detalleserviciotransporte);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detalleserviciotransporte = new  DetalleServicioTransporte();
		  		  
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
		detalleserviciotransporte = new  DetalleServicioTransporte();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleServicioTransporte.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detalleserviciotransporteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleserviciotransporte = new  DetalleServicioTransporte();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detalleserviciotransporteDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalleserviciotransporte = new  DetalleServicioTransporte();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleServicioTransporte.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detalleserviciotransporteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleserviciotransporte = new  DetalleServicioTransporte();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detalleserviciotransporteDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalleserviciotransporte = new  DetalleServicioTransporte();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleServicioTransporte.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detalleserviciotransporteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleserviciotransporte = new  DetalleServicioTransporte();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detalleserviciotransporteDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleserviciotransportes = new  ArrayList<DetalleServicioTransporte>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleServicioTransporte.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetalleServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleserviciotransportes=detalleserviciotransporteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleServicioTransporte(detalleserviciotransportes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleServicioTransporte(this.detalleserviciotransportes);
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
		detalleserviciotransportes = new  ArrayList<DetalleServicioTransporte>();
		  		  
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
		detalleserviciotransportes = new  ArrayList<DetalleServicioTransporte>();
		  		  
        try {			
			DetalleServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleserviciotransportes=detalleserviciotransporteDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetalleServicioTransporte(detalleserviciotransportes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleServicioTransporte(this.detalleserviciotransportes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detalleserviciotransportes = new  ArrayList<DetalleServicioTransporte>();
		  		  
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
		detalleserviciotransportes = new  ArrayList<DetalleServicioTransporte>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleServicioTransporte.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetalleServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleserviciotransportes=detalleserviciotransporteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleServicioTransporte(detalleserviciotransportes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleServicioTransporte(this.detalleserviciotransportes);
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
		detalleserviciotransportes = new  ArrayList<DetalleServicioTransporte>();
		  		  
        try {
			DetalleServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleserviciotransportes=detalleserviciotransporteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleServicioTransporte(detalleserviciotransportes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleServicioTransporte(this.detalleserviciotransportes);
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
		detalleserviciotransportes = new  ArrayList<DetalleServicioTransporte>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleServicioTransporte.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleserviciotransportes=detalleserviciotransporteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleServicioTransporte(detalleserviciotransportes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleServicioTransporte(this.detalleserviciotransportes);
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
		detalleserviciotransportes = new  ArrayList<DetalleServicioTransporte>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleserviciotransportes=detalleserviciotransporteDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleServicioTransporte(detalleserviciotransportes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleServicioTransporte(this.detalleserviciotransportes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detalleserviciotransporte = new  DetalleServicioTransporte();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleServicioTransporte.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleserviciotransporte=detalleserviciotransporteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleServicioTransporte(detalleserviciotransporte);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleServicioTransporte(this.detalleserviciotransporte);
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
		detalleserviciotransporte = new  DetalleServicioTransporte();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleserviciotransporte=detalleserviciotransporteDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleServicioTransporte(detalleserviciotransporte);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleServicioTransporte(this.detalleserviciotransporte);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleserviciotransportes = new  ArrayList<DetalleServicioTransporte>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleServicioTransporte.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetalleServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleserviciotransportes=detalleserviciotransporteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleServicioTransporte(detalleserviciotransportes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleServicioTransporte(this.detalleserviciotransportes);
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
		detalleserviciotransportes = new  ArrayList<DetalleServicioTransporte>();
		  		  
        try {
			DetalleServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleserviciotransportes=detalleserviciotransporteDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleServicioTransporte(detalleserviciotransportes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleServicioTransporte(this.detalleserviciotransportes);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetalleServicioTransportesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detalleserviciotransportes = new  ArrayList<DetalleServicioTransporte>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleServicioTransporte.class.getSimpleName()+"-getTodosDetalleServicioTransportesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleserviciotransportes=detalleserviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleServicioTransporte(detalleserviciotransportes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleServicioTransporte(this.detalleserviciotransportes);
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
	
	public  void  getTodosDetalleServicioTransportes(String sFinalQuery,Pagination pagination)throws Exception {
		detalleserviciotransportes = new  ArrayList<DetalleServicioTransporte>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleserviciotransportes=detalleserviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleServicioTransporte(detalleserviciotransportes);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleServicioTransporte(this.detalleserviciotransportes);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetalleServicioTransporte(DetalleServicioTransporte detalleserviciotransporte) throws Exception {
		Boolean estaValidado=false;
		
		if(detalleserviciotransporte.getIsNew() || detalleserviciotransporte.getIsChanged()) { 
			this.invalidValues = detalleserviciotransporteValidator.getInvalidValues(detalleserviciotransporte);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detalleserviciotransporte);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetalleServicioTransporte(List<DetalleServicioTransporte> DetalleServicioTransportes) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetalleServicioTransporte detalleserviciotransporteLocal:detalleserviciotransportes) {				
			estaValidadoObjeto=this.validarGuardarDetalleServicioTransporte(detalleserviciotransporteLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetalleServicioTransporte(List<DetalleServicioTransporte> DetalleServicioTransportes) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleServicioTransporte(detalleserviciotransportes)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetalleServicioTransporte(DetalleServicioTransporte DetalleServicioTransporte) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleServicioTransporte(detalleserviciotransporte)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetalleServicioTransporte detalleserviciotransporte) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detalleserviciotransporte.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetalleServicioTransporteConstantesFunciones.getDetalleServicioTransporteLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detalleserviciotransporte","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetalleServicioTransporteConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetalleServicioTransporteConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetalleServicioTransporteWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleServicioTransporte.class.getSimpleName()+"-saveDetalleServicioTransporteWithConnection");connexion.begin();			
			
			DetalleServicioTransporteLogicAdditional.checkDetalleServicioTransporteToSave(this.detalleserviciotransporte,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleServicioTransporteLogicAdditional.updateDetalleServicioTransporteToSave(this.detalleserviciotransporte,this.arrDatoGeneral);
			
			DetalleServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalleserviciotransporte,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetalleServicioTransporte();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleServicioTransporte(this.detalleserviciotransporte)) {
				DetalleServicioTransporteDataAccess.save(this.detalleserviciotransporte, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detalleserviciotransporte,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleServicioTransporteLogicAdditional.checkDetalleServicioTransporteToSaveAfter(this.detalleserviciotransporte,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleServicioTransporte();
			
			connexion.commit();			
			
			if(this.detalleserviciotransporte.getIsDeleted()) {
				this.detalleserviciotransporte=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetalleServicioTransporte()throws Exception {	
		try {	
			
			DetalleServicioTransporteLogicAdditional.checkDetalleServicioTransporteToSave(this.detalleserviciotransporte,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleServicioTransporteLogicAdditional.updateDetalleServicioTransporteToSave(this.detalleserviciotransporte,this.arrDatoGeneral);
			
			DetalleServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalleserviciotransporte,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleServicioTransporte(this.detalleserviciotransporte)) {			
				DetalleServicioTransporteDataAccess.save(this.detalleserviciotransporte, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detalleserviciotransporte,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleServicioTransporteLogicAdditional.checkDetalleServicioTransporteToSaveAfter(this.detalleserviciotransporte,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detalleserviciotransporte.getIsDeleted()) {
				this.detalleserviciotransporte=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetalleServicioTransportesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleServicioTransporte.class.getSimpleName()+"-saveDetalleServicioTransportesWithConnection");connexion.begin();			
			
			DetalleServicioTransporteLogicAdditional.checkDetalleServicioTransporteToSaves(detalleserviciotransportes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetalleServicioTransportes();
			
			Boolean validadoTodosDetalleServicioTransporte=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleServicioTransporte detalleserviciotransporteLocal:detalleserviciotransportes) {		
				if(detalleserviciotransporteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleServicioTransporteLogicAdditional.updateDetalleServicioTransporteToSave(detalleserviciotransporteLocal,this.arrDatoGeneral);
	        	
				DetalleServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleserviciotransporteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleServicioTransporte(detalleserviciotransporteLocal)) {
					DetalleServicioTransporteDataAccess.save(detalleserviciotransporteLocal, connexion);				
				} else {
					validadoTodosDetalleServicioTransporte=false;
				}
			}
			
			if(!validadoTodosDetalleServicioTransporte) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleServicioTransporteLogicAdditional.checkDetalleServicioTransporteToSavesAfter(detalleserviciotransportes,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleServicioTransportes();
			
			connexion.commit();		
			
			this.quitarDetalleServicioTransportesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetalleServicioTransportes()throws Exception {				
		 try {	
			DetalleServicioTransporteLogicAdditional.checkDetalleServicioTransporteToSaves(detalleserviciotransportes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetalleServicioTransporte=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleServicioTransporte detalleserviciotransporteLocal:detalleserviciotransportes) {				
				if(detalleserviciotransporteLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleServicioTransporteLogicAdditional.updateDetalleServicioTransporteToSave(detalleserviciotransporteLocal,this.arrDatoGeneral);
	        	
				DetalleServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleserviciotransporteLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleServicioTransporte(detalleserviciotransporteLocal)) {				
					DetalleServicioTransporteDataAccess.save(detalleserviciotransporteLocal, connexion);				
				} else {
					validadoTodosDetalleServicioTransporte=false;
				}
			}
			
			if(!validadoTodosDetalleServicioTransporte) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleServicioTransporteLogicAdditional.checkDetalleServicioTransporteToSavesAfter(detalleserviciotransportes,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetalleServicioTransportesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleServicioTransporteParameterReturnGeneral procesarAccionDetalleServicioTransportes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleServicioTransporte> detalleserviciotransportes,DetalleServicioTransporteParameterReturnGeneral detalleserviciotransporteParameterGeneral)throws Exception {
		 try {	
			DetalleServicioTransporteParameterReturnGeneral detalleserviciotransporteReturnGeneral=new DetalleServicioTransporteParameterReturnGeneral();
	
			DetalleServicioTransporteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleserviciotransportes,detalleserviciotransporteParameterGeneral,detalleserviciotransporteReturnGeneral);
			
			return detalleserviciotransporteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleServicioTransporteParameterReturnGeneral procesarAccionDetalleServicioTransportesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleServicioTransporte> detalleserviciotransportes,DetalleServicioTransporteParameterReturnGeneral detalleserviciotransporteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleServicioTransporte.class.getSimpleName()+"-procesarAccionDetalleServicioTransportesWithConnection");connexion.begin();			
			
			DetalleServicioTransporteParameterReturnGeneral detalleserviciotransporteReturnGeneral=new DetalleServicioTransporteParameterReturnGeneral();
	
			DetalleServicioTransporteLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleserviciotransportes,detalleserviciotransporteParameterGeneral,detalleserviciotransporteReturnGeneral);
			
			this.connexion.commit();
			
			return detalleserviciotransporteReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleServicioTransporteParameterReturnGeneral procesarEventosDetalleServicioTransportes(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleServicioTransporte> detalleserviciotransportes,DetalleServicioTransporte detalleserviciotransporte,DetalleServicioTransporteParameterReturnGeneral detalleserviciotransporteParameterGeneral,Boolean isEsNuevoDetalleServicioTransporte,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetalleServicioTransporteParameterReturnGeneral detalleserviciotransporteReturnGeneral=new DetalleServicioTransporteParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleserviciotransporteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleServicioTransporteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleserviciotransportes,detalleserviciotransporte,detalleserviciotransporteParameterGeneral,detalleserviciotransporteReturnGeneral,isEsNuevoDetalleServicioTransporte,clases);
			
			return detalleserviciotransporteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetalleServicioTransporteParameterReturnGeneral procesarEventosDetalleServicioTransportesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleServicioTransporte> detalleserviciotransportes,DetalleServicioTransporte detalleserviciotransporte,DetalleServicioTransporteParameterReturnGeneral detalleserviciotransporteParameterGeneral,Boolean isEsNuevoDetalleServicioTransporte,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleServicioTransporte.class.getSimpleName()+"-procesarEventosDetalleServicioTransportesWithConnection");connexion.begin();			
			
			DetalleServicioTransporteParameterReturnGeneral detalleserviciotransporteReturnGeneral=new DetalleServicioTransporteParameterReturnGeneral();
	
			detalleserviciotransporteReturnGeneral.setDetalleServicioTransporte(detalleserviciotransporte);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleserviciotransporteReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleServicioTransporteLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleserviciotransportes,detalleserviciotransporte,detalleserviciotransporteParameterGeneral,detalleserviciotransporteReturnGeneral,isEsNuevoDetalleServicioTransporte,clases);
			
			this.connexion.commit();
			
			return detalleserviciotransporteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleServicioTransporteParameterReturnGeneral procesarImportacionDetalleServicioTransportesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetalleServicioTransporteParameterReturnGeneral detalleserviciotransporteParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleServicioTransporte.class.getSimpleName()+"-procesarImportacionDetalleServicioTransportesWithConnection");connexion.begin();			
			
			DetalleServicioTransporteParameterReturnGeneral detalleserviciotransporteReturnGeneral=new DetalleServicioTransporteParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detalleserviciotransportes=new ArrayList<DetalleServicioTransporte>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detalleserviciotransporte=new DetalleServicioTransporte();
				
				
				if(conColumnasBase) {this.detalleserviciotransporte.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detalleserviciotransporte.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detalleserviciotransporte.setcantidad(Integer.parseInt(arrColumnas[iColumn++]));
				this.detalleserviciotransporte.setprecio(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleserviciotransporte.settotal(Double.parseDouble(arrColumnas[iColumn++]));
			this.detalleserviciotransporte.setdescripcion(arrColumnas[iColumn++]);
				
				this.detalleserviciotransportes.add(this.detalleserviciotransporte);
			}
			
			this.saveDetalleServicioTransportes();
			
			this.connexion.commit();
			
			detalleserviciotransporteReturnGeneral.setConRetornoEstaProcesado(true);
			detalleserviciotransporteReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detalleserviciotransporteReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetalleServicioTransportesEliminados() throws Exception {				
		
		List<DetalleServicioTransporte> detalleserviciotransportesAux= new ArrayList<DetalleServicioTransporte>();
		
		for(DetalleServicioTransporte detalleserviciotransporte:detalleserviciotransportes) {
			if(!detalleserviciotransporte.getIsDeleted()) {
				detalleserviciotransportesAux.add(detalleserviciotransporte);
			}
		}
		
		detalleserviciotransportes=detalleserviciotransportesAux;
	}
	
	public void quitarDetalleServicioTransportesNulos() throws Exception {				
		
		List<DetalleServicioTransporte> detalleserviciotransportesAux= new ArrayList<DetalleServicioTransporte>();
		
		for(DetalleServicioTransporte detalleserviciotransporte : this.detalleserviciotransportes) {
			if(detalleserviciotransporte==null) {
				detalleserviciotransportesAux.add(detalleserviciotransporte);
			}
		}
		
		//this.detalleserviciotransportes=detalleserviciotransportesAux;
		
		this.detalleserviciotransportes.removeAll(detalleserviciotransportesAux);
	}
	
	public void getSetVersionRowDetalleServicioTransporteWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detalleserviciotransporte.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detalleserviciotransporte.getIsDeleted() || (detalleserviciotransporte.getIsChanged()&&!detalleserviciotransporte.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detalleserviciotransporteDataAccess.getSetVersionRowDetalleServicioTransporte(connexion,detalleserviciotransporte.getId());
				
				if(!detalleserviciotransporte.getVersionRow().equals(timestamp)) {	
					detalleserviciotransporte.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detalleserviciotransporte.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetalleServicioTransporte()throws Exception {	
		
		if(detalleserviciotransporte.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detalleserviciotransporte.getIsDeleted() || (detalleserviciotransporte.getIsChanged()&&!detalleserviciotransporte.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detalleserviciotransporteDataAccess.getSetVersionRowDetalleServicioTransporte(connexion,detalleserviciotransporte.getId());
			
			try {							
				if(!detalleserviciotransporte.getVersionRow().equals(timestamp)) {	
					detalleserviciotransporte.setVersionRow(timestamp);
				}
				
				detalleserviciotransporte.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetalleServicioTransportesWithConnection()throws Exception {	
		if(detalleserviciotransportes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetalleServicioTransporte detalleserviciotransporteAux:detalleserviciotransportes) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detalleserviciotransporteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleserviciotransporteAux.getIsDeleted() || (detalleserviciotransporteAux.getIsChanged()&&!detalleserviciotransporteAux.getIsNew())) {
						
						timestamp=detalleserviciotransporteDataAccess.getSetVersionRowDetalleServicioTransporte(connexion,detalleserviciotransporteAux.getId());
						
						if(!detalleserviciotransporte.getVersionRow().equals(timestamp)) {	
							detalleserviciotransporteAux.setVersionRow(timestamp);
						}
								
						detalleserviciotransporteAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetalleServicioTransportes()throws Exception {	
		if(detalleserviciotransportes!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetalleServicioTransporte detalleserviciotransporteAux:detalleserviciotransportes) {
					if(detalleserviciotransporteAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleserviciotransporteAux.getIsDeleted() || (detalleserviciotransporteAux.getIsChanged()&&!detalleserviciotransporteAux.getIsNew())) {
						
						timestamp=detalleserviciotransporteDataAccess.getSetVersionRowDetalleServicioTransporte(connexion,detalleserviciotransporteAux.getId());
						
						if(!detalleserviciotransporteAux.getVersionRow().equals(timestamp)) {	
							detalleserviciotransporteAux.setVersionRow(timestamp);
						}
						
													
						detalleserviciotransporteAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetalleServicioTransporteParameterReturnGeneral cargarCombosLoteForeignKeyDetalleServicioTransporteWithConnection(String finalQueryGlobalServicioTransporte,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad,String finalQueryGlobalCentroCosto) throws Exception {
		DetalleServicioTransporteParameterReturnGeneral  detalleserviciotransporteReturnGeneral =new DetalleServicioTransporteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleServicioTransporte.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetalleServicioTransporteWithConnection");connexion.begin();
			
			detalleserviciotransporteReturnGeneral =new DetalleServicioTransporteParameterReturnGeneral();
			
			

			List<ServicioTransporte> serviciotransportesForeignKey=new ArrayList<ServicioTransporte>();
			ServicioTransporteLogic serviciotransporteLogic=new ServicioTransporteLogic();
			serviciotransporteLogic.setConnexion(this.connexion);
			serviciotransporteLogic.getServicioTransporteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalServicioTransporte.equals("NONE")) {
				serviciotransporteLogic.getTodosServicioTransportes(finalQueryGlobalServicioTransporte,new Pagination());
				serviciotransportesForeignKey=serviciotransporteLogic.getServicioTransportes();
			}

			detalleserviciotransporteReturnGeneral.setserviciotransportesForeignKey(serviciotransportesForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalleserviciotransporteReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detalleserviciotransporteReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detalleserviciotransporteReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detalleserviciotransporteReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detalleserviciotransporteReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detalleserviciotransporteReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detalleserviciotransporteReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			detalleserviciotransporteReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detalleserviciotransporteReturnGeneral;
	}
	
	public DetalleServicioTransporteParameterReturnGeneral cargarCombosLoteForeignKeyDetalleServicioTransporte(String finalQueryGlobalServicioTransporte,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalBodega,String finalQueryGlobalProducto,String finalQueryGlobalUnidad,String finalQueryGlobalCentroCosto) throws Exception {
		DetalleServicioTransporteParameterReturnGeneral  detalleserviciotransporteReturnGeneral =new DetalleServicioTransporteParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detalleserviciotransporteReturnGeneral =new DetalleServicioTransporteParameterReturnGeneral();
			
			

			List<ServicioTransporte> serviciotransportesForeignKey=new ArrayList<ServicioTransporte>();
			ServicioTransporteLogic serviciotransporteLogic=new ServicioTransporteLogic();
			serviciotransporteLogic.setConnexion(this.connexion);
			serviciotransporteLogic.getServicioTransporteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalServicioTransporte.equals("NONE")) {
				serviciotransporteLogic.getTodosServicioTransportes(finalQueryGlobalServicioTransporte,new Pagination());
				serviciotransportesForeignKey=serviciotransporteLogic.getServicioTransportes();
			}

			detalleserviciotransporteReturnGeneral.setserviciotransportesForeignKey(serviciotransportesForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalleserviciotransporteReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detalleserviciotransporteReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detalleserviciotransporteReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detalleserviciotransporteReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detalleserviciotransporteReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detalleserviciotransporteReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detalleserviciotransporteReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			detalleserviciotransporteReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detalleserviciotransporteReturnGeneral;
	}
	
	
	public void deepLoad(DetalleServicioTransporte detalleserviciotransporte,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetalleServicioTransporteLogicAdditional.updateDetalleServicioTransporteToGet(detalleserviciotransporte,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalleserviciotransporte.setServicioTransporte(detalleserviciotransporteDataAccess.getServicioTransporte(connexion,detalleserviciotransporte));
		detalleserviciotransporte.setEmpresa(detalleserviciotransporteDataAccess.getEmpresa(connexion,detalleserviciotransporte));
		detalleserviciotransporte.setSucursal(detalleserviciotransporteDataAccess.getSucursal(connexion,detalleserviciotransporte));
		detalleserviciotransporte.setEjercicio(detalleserviciotransporteDataAccess.getEjercicio(connexion,detalleserviciotransporte));
		detalleserviciotransporte.setPeriodo(detalleserviciotransporteDataAccess.getPeriodo(connexion,detalleserviciotransporte));
		detalleserviciotransporte.setBodega(detalleserviciotransporteDataAccess.getBodega(connexion,detalleserviciotransporte));
		detalleserviciotransporte.setProducto(detalleserviciotransporteDataAccess.getProducto(connexion,detalleserviciotransporte));
		detalleserviciotransporte.setUnidad(detalleserviciotransporteDataAccess.getUnidad(connexion,detalleserviciotransporte));
		detalleserviciotransporte.setCentroCosto(detalleserviciotransporteDataAccess.getCentroCosto(connexion,detalleserviciotransporte));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ServicioTransporte.class)) {
				detalleserviciotransporte.setServicioTransporte(detalleserviciotransporteDataAccess.getServicioTransporte(connexion,detalleserviciotransporte));
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				detalleserviciotransporte.setEmpresa(detalleserviciotransporteDataAccess.getEmpresa(connexion,detalleserviciotransporte));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detalleserviciotransporte.setSucursal(detalleserviciotransporteDataAccess.getSucursal(connexion,detalleserviciotransporte));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detalleserviciotransporte.setEjercicio(detalleserviciotransporteDataAccess.getEjercicio(connexion,detalleserviciotransporte));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detalleserviciotransporte.setPeriodo(detalleserviciotransporteDataAccess.getPeriodo(connexion,detalleserviciotransporte));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detalleserviciotransporte.setBodega(detalleserviciotransporteDataAccess.getBodega(connexion,detalleserviciotransporte));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detalleserviciotransporte.setProducto(detalleserviciotransporteDataAccess.getProducto(connexion,detalleserviciotransporte));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detalleserviciotransporte.setUnidad(detalleserviciotransporteDataAccess.getUnidad(connexion,detalleserviciotransporte));
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				detalleserviciotransporte.setCentroCosto(detalleserviciotransporteDataAccess.getCentroCosto(connexion,detalleserviciotransporte));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ServicioTransporte.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleserviciotransporte.setServicioTransporte(detalleserviciotransporteDataAccess.getServicioTransporte(connexion,detalleserviciotransporte));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleserviciotransporte.setEmpresa(detalleserviciotransporteDataAccess.getEmpresa(connexion,detalleserviciotransporte));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleserviciotransporte.setSucursal(detalleserviciotransporteDataAccess.getSucursal(connexion,detalleserviciotransporte));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleserviciotransporte.setEjercicio(detalleserviciotransporteDataAccess.getEjercicio(connexion,detalleserviciotransporte));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleserviciotransporte.setPeriodo(detalleserviciotransporteDataAccess.getPeriodo(connexion,detalleserviciotransporte));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleserviciotransporte.setBodega(detalleserviciotransporteDataAccess.getBodega(connexion,detalleserviciotransporte));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleserviciotransporte.setProducto(detalleserviciotransporteDataAccess.getProducto(connexion,detalleserviciotransporte));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleserviciotransporte.setUnidad(detalleserviciotransporteDataAccess.getUnidad(connexion,detalleserviciotransporte));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleserviciotransporte.setCentroCosto(detalleserviciotransporteDataAccess.getCentroCosto(connexion,detalleserviciotransporte));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalleserviciotransporte.setServicioTransporte(detalleserviciotransporteDataAccess.getServicioTransporte(connexion,detalleserviciotransporte));
		ServicioTransporteLogic serviciotransporteLogic= new ServicioTransporteLogic(connexion);
		serviciotransporteLogic.deepLoad(detalleserviciotransporte.getServicioTransporte(),isDeep,deepLoadType,clases);
				
		detalleserviciotransporte.setEmpresa(detalleserviciotransporteDataAccess.getEmpresa(connexion,detalleserviciotransporte));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalleserviciotransporte.getEmpresa(),isDeep,deepLoadType,clases);
				
		detalleserviciotransporte.setSucursal(detalleserviciotransporteDataAccess.getSucursal(connexion,detalleserviciotransporte));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detalleserviciotransporte.getSucursal(),isDeep,deepLoadType,clases);
				
		detalleserviciotransporte.setEjercicio(detalleserviciotransporteDataAccess.getEjercicio(connexion,detalleserviciotransporte));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detalleserviciotransporte.getEjercicio(),isDeep,deepLoadType,clases);
				
		detalleserviciotransporte.setPeriodo(detalleserviciotransporteDataAccess.getPeriodo(connexion,detalleserviciotransporte));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detalleserviciotransporte.getPeriodo(),isDeep,deepLoadType,clases);
				
		detalleserviciotransporte.setBodega(detalleserviciotransporteDataAccess.getBodega(connexion,detalleserviciotransporte));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detalleserviciotransporte.getBodega(),isDeep,deepLoadType,clases);
				
		detalleserviciotransporte.setProducto(detalleserviciotransporteDataAccess.getProducto(connexion,detalleserviciotransporte));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detalleserviciotransporte.getProducto(),isDeep,deepLoadType,clases);
				
		detalleserviciotransporte.setUnidad(detalleserviciotransporteDataAccess.getUnidad(connexion,detalleserviciotransporte));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detalleserviciotransporte.getUnidad(),isDeep,deepLoadType,clases);
				
		detalleserviciotransporte.setCentroCosto(detalleserviciotransporteDataAccess.getCentroCosto(connexion,detalleserviciotransporte));
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(detalleserviciotransporte.getCentroCosto(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ServicioTransporte.class)) {
				detalleserviciotransporte.setServicioTransporte(detalleserviciotransporteDataAccess.getServicioTransporte(connexion,detalleserviciotransporte));
				ServicioTransporteLogic serviciotransporteLogic= new ServicioTransporteLogic(connexion);
				serviciotransporteLogic.deepLoad(detalleserviciotransporte.getServicioTransporte(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				detalleserviciotransporte.setEmpresa(detalleserviciotransporteDataAccess.getEmpresa(connexion,detalleserviciotransporte));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detalleserviciotransporte.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detalleserviciotransporte.setSucursal(detalleserviciotransporteDataAccess.getSucursal(connexion,detalleserviciotransporte));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detalleserviciotransporte.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detalleserviciotransporte.setEjercicio(detalleserviciotransporteDataAccess.getEjercicio(connexion,detalleserviciotransporte));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(detalleserviciotransporte.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detalleserviciotransporte.setPeriodo(detalleserviciotransporteDataAccess.getPeriodo(connexion,detalleserviciotransporte));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(detalleserviciotransporte.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detalleserviciotransporte.setBodega(detalleserviciotransporteDataAccess.getBodega(connexion,detalleserviciotransporte));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(detalleserviciotransporte.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detalleserviciotransporte.setProducto(detalleserviciotransporteDataAccess.getProducto(connexion,detalleserviciotransporte));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(detalleserviciotransporte.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detalleserviciotransporte.setUnidad(detalleserviciotransporteDataAccess.getUnidad(connexion,detalleserviciotransporte));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(detalleserviciotransporte.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				detalleserviciotransporte.setCentroCosto(detalleserviciotransporteDataAccess.getCentroCosto(connexion,detalleserviciotransporte));
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepLoad(detalleserviciotransporte.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(ServicioTransporte.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleserviciotransporte.setServicioTransporte(detalleserviciotransporteDataAccess.getServicioTransporte(connexion,detalleserviciotransporte));
			ServicioTransporteLogic serviciotransporteLogic= new ServicioTransporteLogic(connexion);
			serviciotransporteLogic.deepLoad(detalleserviciotransporte.getServicioTransporte(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleserviciotransporte.setEmpresa(detalleserviciotransporteDataAccess.getEmpresa(connexion,detalleserviciotransporte));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detalleserviciotransporte.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleserviciotransporte.setSucursal(detalleserviciotransporteDataAccess.getSucursal(connexion,detalleserviciotransporte));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detalleserviciotransporte.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleserviciotransporte.setEjercicio(detalleserviciotransporteDataAccess.getEjercicio(connexion,detalleserviciotransporte));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(detalleserviciotransporte.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleserviciotransporte.setPeriodo(detalleserviciotransporteDataAccess.getPeriodo(connexion,detalleserviciotransporte));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(detalleserviciotransporte.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleserviciotransporte.setBodega(detalleserviciotransporteDataAccess.getBodega(connexion,detalleserviciotransporte));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(detalleserviciotransporte.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleserviciotransporte.setProducto(detalleserviciotransporteDataAccess.getProducto(connexion,detalleserviciotransporte));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(detalleserviciotransporte.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleserviciotransporte.setUnidad(detalleserviciotransporteDataAccess.getUnidad(connexion,detalleserviciotransporte));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(detalleserviciotransporte.getUnidad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleserviciotransporte.setCentroCosto(detalleserviciotransporteDataAccess.getCentroCosto(connexion,detalleserviciotransporte));
			CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
			centrocostoLogic.deepLoad(detalleserviciotransporte.getCentroCosto(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetalleServicioTransporte detalleserviciotransporte,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetalleServicioTransporteLogicAdditional.updateDetalleServicioTransporteToSave(detalleserviciotransporte,this.arrDatoGeneral);
			
DetalleServicioTransporteDataAccess.save(detalleserviciotransporte, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ServicioTransporteDataAccess.save(detalleserviciotransporte.getServicioTransporte(),connexion);

		EmpresaDataAccess.save(detalleserviciotransporte.getEmpresa(),connexion);

		SucursalDataAccess.save(detalleserviciotransporte.getSucursal(),connexion);

		EjercicioDataAccess.save(detalleserviciotransporte.getEjercicio(),connexion);

		PeriodoDataAccess.save(detalleserviciotransporte.getPeriodo(),connexion);

		BodegaDataAccess.save(detalleserviciotransporte.getBodega(),connexion);

		ProductoDataAccess.save(detalleserviciotransporte.getProducto(),connexion);

		UnidadDataAccess.save(detalleserviciotransporte.getUnidad(),connexion);

		CentroCostoDataAccess.save(detalleserviciotransporte.getCentroCosto(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ServicioTransporte.class)) {
				ServicioTransporteDataAccess.save(detalleserviciotransporte.getServicioTransporte(),connexion);
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalleserviciotransporte.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detalleserviciotransporte.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detalleserviciotransporte.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detalleserviciotransporte.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detalleserviciotransporte.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detalleserviciotransporte.getProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detalleserviciotransporte.getUnidad(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(detalleserviciotransporte.getCentroCosto(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ServicioTransporteDataAccess.save(detalleserviciotransporte.getServicioTransporte(),connexion);
		ServicioTransporteLogic serviciotransporteLogic= new ServicioTransporteLogic(connexion);
		serviciotransporteLogic.deepLoad(detalleserviciotransporte.getServicioTransporte(),isDeep,deepLoadType,clases);
				

		EmpresaDataAccess.save(detalleserviciotransporte.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalleserviciotransporte.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detalleserviciotransporte.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detalleserviciotransporte.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(detalleserviciotransporte.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detalleserviciotransporte.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(detalleserviciotransporte.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detalleserviciotransporte.getPeriodo(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(detalleserviciotransporte.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detalleserviciotransporte.getBodega(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(detalleserviciotransporte.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detalleserviciotransporte.getProducto(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(detalleserviciotransporte.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detalleserviciotransporte.getUnidad(),isDeep,deepLoadType,clases);
				

		CentroCostoDataAccess.save(detalleserviciotransporte.getCentroCosto(),connexion);
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(detalleserviciotransporte.getCentroCosto(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ServicioTransporte.class)) {
				ServicioTransporteDataAccess.save(detalleserviciotransporte.getServicioTransporte(),connexion);
				ServicioTransporteLogic serviciotransporteLogic= new ServicioTransporteLogic(connexion);
				serviciotransporteLogic.deepSave(detalleserviciotransporte.getServicioTransporte(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalleserviciotransporte.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detalleserviciotransporte.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detalleserviciotransporte.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detalleserviciotransporte.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detalleserviciotransporte.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(detalleserviciotransporte.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detalleserviciotransporte.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(detalleserviciotransporte.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detalleserviciotransporte.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(detalleserviciotransporte.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detalleserviciotransporte.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(detalleserviciotransporte.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detalleserviciotransporte.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(detalleserviciotransporte.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(detalleserviciotransporte.getCentroCosto(),connexion);
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepSave(detalleserviciotransporte.getCentroCosto(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetalleServicioTransporte.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detalleserviciotransporte,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleServicioTransporte(detalleserviciotransporte);
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
			this.deepLoad(this.detalleserviciotransporte,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleServicioTransporte(this.detalleserviciotransporte);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetalleServicioTransporte.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detalleserviciotransportes!=null) {
				for(DetalleServicioTransporte detalleserviciotransporte:detalleserviciotransportes) {
					this.deepLoad(detalleserviciotransporte,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetalleServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleServicioTransporte(detalleserviciotransportes);
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
			if(detalleserviciotransportes!=null) {
				for(DetalleServicioTransporte detalleserviciotransporte:detalleserviciotransportes) {
					this.deepLoad(detalleserviciotransporte,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetalleServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleServicioTransporte(detalleserviciotransportes);
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
			this.getNewConnexionToDeep(DetalleServicioTransporte.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detalleserviciotransporte,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetalleServicioTransporte.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detalleserviciotransportes!=null) {
				for(DetalleServicioTransporte detalleserviciotransporte:detalleserviciotransportes) {
					this.deepSave(detalleserviciotransporte,isDeep,deepLoadType,clases);
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
			if(detalleserviciotransportes!=null) {
				for(DetalleServicioTransporte detalleserviciotransporte:detalleserviciotransportes) {
					this.deepSave(detalleserviciotransporte,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetalleServicioTransportesFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleServicioTransporte.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetalleServicioTransporteConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetalleServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleserviciotransportes=detalleserviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleServicioTransporte(this.detalleserviciotransportes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleServicioTransportesFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetalleServicioTransporteConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetalleServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleserviciotransportes=detalleserviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleServicioTransporte(this.detalleserviciotransportes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleServicioTransportesFK_IdCentroCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleServicioTransporte.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,DetalleServicioTransporteConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			DetalleServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleserviciotransportes=detalleserviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleServicioTransporte(this.detalleserviciotransportes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleServicioTransportesFK_IdCentroCosto(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,DetalleServicioTransporteConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			DetalleServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleserviciotransportes=detalleserviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleServicioTransporte(this.detalleserviciotransportes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleServicioTransportesFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleServicioTransporte.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleServicioTransporteConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleserviciotransportes=detalleserviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleServicioTransporte(this.detalleserviciotransportes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleServicioTransportesFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleServicioTransporteConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleserviciotransportes=detalleserviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleServicioTransporte(this.detalleserviciotransportes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleServicioTransportesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleServicioTransporte.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleServicioTransporteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleserviciotransportes=detalleserviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleServicioTransporte(this.detalleserviciotransportes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleServicioTransportesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleServicioTransporteConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleserviciotransportes=detalleserviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleServicioTransporte(this.detalleserviciotransportes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleServicioTransportesFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleServicioTransporte.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetalleServicioTransporteConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetalleServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleserviciotransportes=detalleserviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleServicioTransporte(this.detalleserviciotransportes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleServicioTransportesFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetalleServicioTransporteConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetalleServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleserviciotransportes=detalleserviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleServicioTransporte(this.detalleserviciotransportes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleServicioTransportesFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleServicioTransporte.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetalleServicioTransporteConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetalleServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleserviciotransportes=detalleserviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleServicioTransporte(this.detalleserviciotransportes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleServicioTransportesFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetalleServicioTransporteConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetalleServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleserviciotransportes=detalleserviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleServicioTransporte(this.detalleserviciotransportes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleServicioTransportesFK_IdServicioTransporteWithConnection(String sFinalQuery,Pagination pagination,Long id_servicio_transporte)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleServicioTransporte.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidServicioTransporte= new ParameterSelectionGeneral();
			parameterSelectionGeneralidServicioTransporte.setParameterSelectionGeneralEqual(ParameterType.LONG,id_servicio_transporte,DetalleServicioTransporteConstantesFunciones.IDSERVICIOTRANSPORTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidServicioTransporte);

			DetalleServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdServicioTransporte","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleserviciotransportes=detalleserviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleServicioTransporte(this.detalleserviciotransportes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleServicioTransportesFK_IdServicioTransporte(String sFinalQuery,Pagination pagination,Long id_servicio_transporte)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidServicioTransporte= new ParameterSelectionGeneral();
			parameterSelectionGeneralidServicioTransporte.setParameterSelectionGeneralEqual(ParameterType.LONG,id_servicio_transporte,DetalleServicioTransporteConstantesFunciones.IDSERVICIOTRANSPORTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidServicioTransporte);

			DetalleServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdServicioTransporte","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleserviciotransportes=detalleserviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleServicioTransporte(this.detalleserviciotransportes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleServicioTransportesFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleServicioTransporte.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleServicioTransporteConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleserviciotransportes=detalleserviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleServicioTransporte(this.detalleserviciotransportes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleServicioTransportesFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleServicioTransporteConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleserviciotransportes=detalleserviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleServicioTransporte(this.detalleserviciotransportes);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleServicioTransportesFK_IdUnidadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleServicioTransporte.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetalleServicioTransporteConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetalleServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleserviciotransportes=detalleserviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleServicioTransporte(this.detalleserviciotransportes);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleServicioTransportesFK_IdUnidad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetalleServicioTransporteConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetalleServicioTransporteLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleserviciotransportes=detalleserviciotransporteDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleServicioTransporteConstantesFunciones.refrescarForeignKeysDescripcionesDetalleServicioTransporte(this.detalleserviciotransportes);
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
			if(DetalleServicioTransporteConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleServicioTransporteDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetalleServicioTransporte detalleserviciotransporte,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetalleServicioTransporteConstantesFunciones.ISCONAUDITORIA) {
				if(detalleserviciotransporte.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleServicioTransporteDataAccess.TABLENAME, detalleserviciotransporte.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleServicioTransporteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleServicioTransporteLogic.registrarAuditoriaDetallesDetalleServicioTransporte(connexion,detalleserviciotransporte,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detalleserviciotransporte.getIsDeleted()) {
					/*if(!detalleserviciotransporte.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetalleServicioTransporteDataAccess.TABLENAME, detalleserviciotransporte.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetalleServicioTransporteLogic.registrarAuditoriaDetallesDetalleServicioTransporte(connexion,detalleserviciotransporte,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleServicioTransporteDataAccess.TABLENAME, detalleserviciotransporte.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detalleserviciotransporte.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleServicioTransporteDataAccess.TABLENAME, detalleserviciotransporte.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleServicioTransporteConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleServicioTransporteLogic.registrarAuditoriaDetallesDetalleServicioTransporte(connexion,detalleserviciotransporte,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetalleServicioTransporte(Connexion connexion,DetalleServicioTransporte detalleserviciotransporte)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detalleserviciotransporte.getIsNew()||!detalleserviciotransporte.getid_servicio_transporte().equals(detalleserviciotransporte.getDetalleServicioTransporteOriginal().getid_servicio_transporte()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleserviciotransporte.getDetalleServicioTransporteOriginal().getid_servicio_transporte()!=null)
				{
					strValorActual=detalleserviciotransporte.getDetalleServicioTransporteOriginal().getid_servicio_transporte().toString();
				}
				if(detalleserviciotransporte.getid_servicio_transporte()!=null)
				{
					strValorNuevo=detalleserviciotransporte.getid_servicio_transporte().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleServicioTransporteConstantesFunciones.IDSERVICIOTRANSPORTE,strValorActual,strValorNuevo);
			}	
			
			if(detalleserviciotransporte.getIsNew()||!detalleserviciotransporte.getid_empresa().equals(detalleserviciotransporte.getDetalleServicioTransporteOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleserviciotransporte.getDetalleServicioTransporteOriginal().getid_empresa()!=null)
				{
					strValorActual=detalleserviciotransporte.getDetalleServicioTransporteOriginal().getid_empresa().toString();
				}
				if(detalleserviciotransporte.getid_empresa()!=null)
				{
					strValorNuevo=detalleserviciotransporte.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleServicioTransporteConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detalleserviciotransporte.getIsNew()||!detalleserviciotransporte.getid_sucursal().equals(detalleserviciotransporte.getDetalleServicioTransporteOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleserviciotransporte.getDetalleServicioTransporteOriginal().getid_sucursal()!=null)
				{
					strValorActual=detalleserviciotransporte.getDetalleServicioTransporteOriginal().getid_sucursal().toString();
				}
				if(detalleserviciotransporte.getid_sucursal()!=null)
				{
					strValorNuevo=detalleserviciotransporte.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleServicioTransporteConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(detalleserviciotransporte.getIsNew()||!detalleserviciotransporte.getid_ejercicio().equals(detalleserviciotransporte.getDetalleServicioTransporteOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleserviciotransporte.getDetalleServicioTransporteOriginal().getid_ejercicio()!=null)
				{
					strValorActual=detalleserviciotransporte.getDetalleServicioTransporteOriginal().getid_ejercicio().toString();
				}
				if(detalleserviciotransporte.getid_ejercicio()!=null)
				{
					strValorNuevo=detalleserviciotransporte.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleServicioTransporteConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(detalleserviciotransporte.getIsNew()||!detalleserviciotransporte.getid_periodo().equals(detalleserviciotransporte.getDetalleServicioTransporteOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleserviciotransporte.getDetalleServicioTransporteOriginal().getid_periodo()!=null)
				{
					strValorActual=detalleserviciotransporte.getDetalleServicioTransporteOriginal().getid_periodo().toString();
				}
				if(detalleserviciotransporte.getid_periodo()!=null)
				{
					strValorNuevo=detalleserviciotransporte.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleServicioTransporteConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(detalleserviciotransporte.getIsNew()||!detalleserviciotransporte.getid_bodega().equals(detalleserviciotransporte.getDetalleServicioTransporteOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleserviciotransporte.getDetalleServicioTransporteOriginal().getid_bodega()!=null)
				{
					strValorActual=detalleserviciotransporte.getDetalleServicioTransporteOriginal().getid_bodega().toString();
				}
				if(detalleserviciotransporte.getid_bodega()!=null)
				{
					strValorNuevo=detalleserviciotransporte.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleServicioTransporteConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(detalleserviciotransporte.getIsNew()||!detalleserviciotransporte.getid_producto().equals(detalleserviciotransporte.getDetalleServicioTransporteOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleserviciotransporte.getDetalleServicioTransporteOriginal().getid_producto()!=null)
				{
					strValorActual=detalleserviciotransporte.getDetalleServicioTransporteOriginal().getid_producto().toString();
				}
				if(detalleserviciotransporte.getid_producto()!=null)
				{
					strValorNuevo=detalleserviciotransporte.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleServicioTransporteConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(detalleserviciotransporte.getIsNew()||!detalleserviciotransporte.getid_unidad().equals(detalleserviciotransporte.getDetalleServicioTransporteOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleserviciotransporte.getDetalleServicioTransporteOriginal().getid_unidad()!=null)
				{
					strValorActual=detalleserviciotransporte.getDetalleServicioTransporteOriginal().getid_unidad().toString();
				}
				if(detalleserviciotransporte.getid_unidad()!=null)
				{
					strValorNuevo=detalleserviciotransporte.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleServicioTransporteConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detalleserviciotransporte.getIsNew()||!detalleserviciotransporte.getid_centro_costo().equals(detalleserviciotransporte.getDetalleServicioTransporteOriginal().getid_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleserviciotransporte.getDetalleServicioTransporteOriginal().getid_centro_costo()!=null)
				{
					strValorActual=detalleserviciotransporte.getDetalleServicioTransporteOriginal().getid_centro_costo().toString();
				}
				if(detalleserviciotransporte.getid_centro_costo()!=null)
				{
					strValorNuevo=detalleserviciotransporte.getid_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleServicioTransporteConstantesFunciones.IDCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(detalleserviciotransporte.getIsNew()||!detalleserviciotransporte.getcantidad().equals(detalleserviciotransporte.getDetalleServicioTransporteOriginal().getcantidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleserviciotransporte.getDetalleServicioTransporteOriginal().getcantidad()!=null)
				{
					strValorActual=detalleserviciotransporte.getDetalleServicioTransporteOriginal().getcantidad().toString();
				}
				if(detalleserviciotransporte.getcantidad()!=null)
				{
					strValorNuevo=detalleserviciotransporte.getcantidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleServicioTransporteConstantesFunciones.CANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detalleserviciotransporte.getIsNew()||!detalleserviciotransporte.getprecio().equals(detalleserviciotransporte.getDetalleServicioTransporteOriginal().getprecio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleserviciotransporte.getDetalleServicioTransporteOriginal().getprecio()!=null)
				{
					strValorActual=detalleserviciotransporte.getDetalleServicioTransporteOriginal().getprecio().toString();
				}
				if(detalleserviciotransporte.getprecio()!=null)
				{
					strValorNuevo=detalleserviciotransporte.getprecio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleServicioTransporteConstantesFunciones.PRECIO,strValorActual,strValorNuevo);
			}	
			
			if(detalleserviciotransporte.getIsNew()||!detalleserviciotransporte.gettotal().equals(detalleserviciotransporte.getDetalleServicioTransporteOriginal().gettotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleserviciotransporte.getDetalleServicioTransporteOriginal().gettotal()!=null)
				{
					strValorActual=detalleserviciotransporte.getDetalleServicioTransporteOriginal().gettotal().toString();
				}
				if(detalleserviciotransporte.gettotal()!=null)
				{
					strValorNuevo=detalleserviciotransporte.gettotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleServicioTransporteConstantesFunciones.TOTAL,strValorActual,strValorNuevo);
			}	
			
			if(detalleserviciotransporte.getIsNew()||!detalleserviciotransporte.getdescripcion().equals(detalleserviciotransporte.getDetalleServicioTransporteOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleserviciotransporte.getDetalleServicioTransporteOriginal().getdescripcion()!=null)
				{
					strValorActual=detalleserviciotransporte.getDetalleServicioTransporteOriginal().getdescripcion();
				}
				if(detalleserviciotransporte.getdescripcion()!=null)
				{
					strValorNuevo=detalleserviciotransporte.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleServicioTransporteConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetalleServicioTransporteRelacionesWithConnection(DetalleServicioTransporte detalleserviciotransporte) throws Exception {

		if(!detalleserviciotransporte.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleServicioTransporteRelacionesBase(detalleserviciotransporte,true);
		}
	}

	public void saveDetalleServicioTransporteRelaciones(DetalleServicioTransporte detalleserviciotransporte)throws Exception {

		if(!detalleserviciotransporte.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleServicioTransporteRelacionesBase(detalleserviciotransporte,false);
		}
	}

	public void saveDetalleServicioTransporteRelacionesBase(DetalleServicioTransporte detalleserviciotransporte,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetalleServicioTransporte-saveRelacionesWithConnection");}
	

			this.setDetalleServicioTransporte(detalleserviciotransporte);

			if(DetalleServicioTransporteLogicAdditional.validarSaveRelaciones(detalleserviciotransporte,this)) {

				DetalleServicioTransporteLogicAdditional.updateRelacionesToSave(detalleserviciotransporte,this);

				if((detalleserviciotransporte.getIsNew()||detalleserviciotransporte.getIsChanged())&&!detalleserviciotransporte.getIsDeleted()) {
					this.saveDetalleServicioTransporte();
					this.saveDetalleServicioTransporteRelacionesDetalles();

				} else if(detalleserviciotransporte.getIsDeleted()) {
					this.saveDetalleServicioTransporteRelacionesDetalles();
					this.saveDetalleServicioTransporte();
				}

				DetalleServicioTransporteLogicAdditional.updateRelacionesToSaveAfter(detalleserviciotransporte,this);

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
	
	
	private void saveDetalleServicioTransporteRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleServicioTransporte(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleServicioTransporteConstantesFunciones.getClassesForeignKeysOfDetalleServicioTransporte(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleServicioTransporte(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleServicioTransporteConstantesFunciones.getClassesRelationshipsOfDetalleServicioTransporte(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

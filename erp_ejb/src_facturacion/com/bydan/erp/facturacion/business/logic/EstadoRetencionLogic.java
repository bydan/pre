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
package com.bydan.erp.facturacion.business.logic;

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
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.facturacion.util.EstadoRetencionConstantesFunciones;
import com.bydan.erp.facturacion.util.EstadoRetencionParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.EstadoRetencionParameterGeneral;
import com.bydan.erp.facturacion.business.entity.EstadoRetencion;
//import com.bydan.erp.facturacion.business.logic.EstadoRetencionLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.cartera.business.logic.*;


import com.bydan.erp.cartera.util.*;


import com.bydan.erp.cartera.business.dataaccess.*;








@SuppressWarnings("unused")
public class EstadoRetencionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoRetencionLogic.class);
	
	protected EstadoRetencionDataAccess estadoretencionDataAccess; 	
	protected EstadoRetencion estadoretencion;
	protected List<EstadoRetencion> estadoretencions;
	protected Object estadoretencionObject;	
	protected List<Object> estadoretencionsObject;
	
	public static ClassValidator<EstadoRetencion> estadoretencionValidator = new ClassValidator<EstadoRetencion>(EstadoRetencion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
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
	
	
	
	
	public  EstadoRetencionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadoretencionDataAccess = new EstadoRetencionDataAccess();
			
			this.estadoretencions= new ArrayList<EstadoRetencion>();
			this.estadoretencion= new EstadoRetencion();
			
			this.estadoretencionObject=new Object();
			this.estadoretencionsObject=new ArrayList<Object>();
				
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
			
			this.estadoretencionDataAccess.setConnexionType(this.connexionType);
			this.estadoretencionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoRetencionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadoretencionDataAccess = new EstadoRetencionDataAccess();
			this.estadoretencions= new ArrayList<EstadoRetencion>();
			this.estadoretencion= new EstadoRetencion();
			this.estadoretencionObject=new Object();
			this.estadoretencionsObject=new ArrayList<Object>();
			
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
			
			this.estadoretencionDataAccess.setConnexionType(this.connexionType);
			this.estadoretencionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoRetencion getEstadoRetencion() throws Exception {	
		//EstadoRetencionLogicAdditional.checkEstadoRetencionToGet(estadoretencion,this.datosCliente,this.arrDatoGeneral);
		//EstadoRetencionLogicAdditional.updateEstadoRetencionToGet(estadoretencion,this.arrDatoGeneral);
		
		return estadoretencion;
	}
		
	public void setEstadoRetencion(EstadoRetencion newEstadoRetencion) {
		this.estadoretencion = newEstadoRetencion;
	}
	
	public EstadoRetencionDataAccess getEstadoRetencionDataAccess() {
		return estadoretencionDataAccess;
	}
	
	public void setEstadoRetencionDataAccess(EstadoRetencionDataAccess newestadoretencionDataAccess) {
		this.estadoretencionDataAccess = newestadoretencionDataAccess;
	}
	
	public List<EstadoRetencion> getEstadoRetencions() throws Exception {		
		this.quitarEstadoRetencionsNulos();
		
		//EstadoRetencionLogicAdditional.checkEstadoRetencionToGets(estadoretencions,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoRetencion estadoretencionLocal: estadoretencions ) {
			//EstadoRetencionLogicAdditional.updateEstadoRetencionToGet(estadoretencionLocal,this.arrDatoGeneral);
		}
		
		return estadoretencions;
	}
	
	public void setEstadoRetencions(List<EstadoRetencion> newEstadoRetencions) {
		this.estadoretencions = newEstadoRetencions;
	}
	
	public Object getEstadoRetencionObject() {	
		this.estadoretencionObject=this.estadoretencionDataAccess.getEntityObject();
		return this.estadoretencionObject;
	}
		
	public void setEstadoRetencionObject(Object newEstadoRetencionObject) {
		this.estadoretencionObject = newEstadoRetencionObject;
	}
	
	public List<Object> getEstadoRetencionsObject() {		
		this.estadoretencionsObject=this.estadoretencionDataAccess.getEntitiesObject();
		return this.estadoretencionsObject;
	}
		
	public void setEstadoRetencionsObject(List<Object> newEstadoRetencionsObject) {
		this.estadoretencionsObject = newEstadoRetencionsObject;
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
		
		if(this.estadoretencionDataAccess!=null) {
			this.estadoretencionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRetencion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadoretencionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadoretencionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadoretencion = new  EstadoRetencion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRetencion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadoretencion=estadoretencionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoretencion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRetencion(this.estadoretencion);
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
		estadoretencion = new  EstadoRetencion();
		  		  
        try {
			
			estadoretencion=estadoretencionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoretencion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRetencion(this.estadoretencion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadoretencion = new  EstadoRetencion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRetencion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadoretencion=estadoretencionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoretencion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRetencion(this.estadoretencion);
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
		estadoretencion = new  EstadoRetencion();
		  		  
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
		estadoretencion = new  EstadoRetencion();
		  		  
        try {
			
			estadoretencion=estadoretencionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoretencion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRetencion(this.estadoretencion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadoretencion = new  EstadoRetencion();
		  		  
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
		estadoretencion = new  EstadoRetencion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRetencion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadoretencionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadoretencion = new  EstadoRetencion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadoretencionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadoretencion = new  EstadoRetencion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRetencion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadoretencionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadoretencion = new  EstadoRetencion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadoretencionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadoretencion = new  EstadoRetencion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRetencion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadoretencionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadoretencion = new  EstadoRetencion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadoretencionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadoretencions = new  ArrayList<EstadoRetencion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRetencion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoretencions=estadoretencionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoRetencion(estadoretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRetencion(this.estadoretencions);
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
		estadoretencions = new  ArrayList<EstadoRetencion>();
		  		  
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
		estadoretencions = new  ArrayList<EstadoRetencion>();
		  		  
        try {			
			EstadoRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoretencions=estadoretencionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoRetencion(estadoretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRetencion(this.estadoretencions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadoretencions = new  ArrayList<EstadoRetencion>();
		  		  
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
		estadoretencions = new  ArrayList<EstadoRetencion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRetencion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoretencions=estadoretencionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoRetencion(estadoretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRetencion(this.estadoretencions);
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
		estadoretencions = new  ArrayList<EstadoRetencion>();
		  		  
        try {
			EstadoRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoretencions=estadoretencionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoRetencion(estadoretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRetencion(this.estadoretencions);
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
		estadoretencions = new  ArrayList<EstadoRetencion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRetencion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoretencions=estadoretencionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoRetencion(estadoretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRetencion(this.estadoretencions);
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
		estadoretencions = new  ArrayList<EstadoRetencion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoretencions=estadoretencionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoRetencion(estadoretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRetencion(this.estadoretencions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadoretencion = new  EstadoRetencion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRetencion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoretencion=estadoretencionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoRetencion(estadoretencion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRetencion(this.estadoretencion);
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
		estadoretencion = new  EstadoRetencion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoretencion=estadoretencionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoRetencion(estadoretencion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRetencion(this.estadoretencion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosEstadoRetencionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadoretencions = new  ArrayList<EstadoRetencion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRetencion.class.getSimpleName()+"-getTodosEstadoRetencionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoretencions=estadoretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoRetencion(estadoretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRetencion(this.estadoretencions);
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
	
	public  void  getTodosEstadoRetencions(String sFinalQuery,Pagination pagination)throws Exception {
		estadoretencions = new  ArrayList<EstadoRetencion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoretencions=estadoretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoRetencion(estadoretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRetencion(this.estadoretencions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoRetencion(EstadoRetencion estadoretencion) throws Exception {
		Boolean estaValidado=false;
		
		if(estadoretencion.getIsNew() || estadoretencion.getIsChanged()) { 
			this.invalidValues = estadoretencionValidator.getInvalidValues(estadoretencion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadoretencion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoRetencion(List<EstadoRetencion> EstadoRetencions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoRetencion estadoretencionLocal:estadoretencions) {				
			estaValidadoObjeto=this.validarGuardarEstadoRetencion(estadoretencionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoRetencion(List<EstadoRetencion> EstadoRetencions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoRetencion(estadoretencions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoRetencion(EstadoRetencion EstadoRetencion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoRetencion(estadoretencion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoRetencion estadoretencion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadoretencion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoRetencionConstantesFunciones.getEstadoRetencionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadoretencion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoRetencionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoRetencionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoRetencionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRetencion.class.getSimpleName()+"-saveEstadoRetencionWithConnection");connexion.begin();			
			
			//EstadoRetencionLogicAdditional.checkEstadoRetencionToSave(this.estadoretencion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//EstadoRetencionLogicAdditional.updateEstadoRetencionToSave(this.estadoretencion,this.arrDatoGeneral);
			
			EstadoRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadoretencion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoRetencion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoRetencion(this.estadoretencion)) {
				EstadoRetencionDataAccess.save(this.estadoretencion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadoretencion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//EstadoRetencionLogicAdditional.checkEstadoRetencionToSaveAfter(this.estadoretencion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoRetencion();
			
			connexion.commit();			
			
			if(this.estadoretencion.getIsDeleted()) {
				this.estadoretencion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoRetencion()throws Exception {	
		try {	
			
			//EstadoRetencionLogicAdditional.checkEstadoRetencionToSave(this.estadoretencion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//EstadoRetencionLogicAdditional.updateEstadoRetencionToSave(this.estadoretencion,this.arrDatoGeneral);
			
			EstadoRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadoretencion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoRetencion(this.estadoretencion)) {			
				EstadoRetencionDataAccess.save(this.estadoretencion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadoretencion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//EstadoRetencionLogicAdditional.checkEstadoRetencionToSaveAfter(this.estadoretencion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadoretencion.getIsDeleted()) {
				this.estadoretencion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoRetencionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRetencion.class.getSimpleName()+"-saveEstadoRetencionsWithConnection");connexion.begin();			
			
			//EstadoRetencionLogicAdditional.checkEstadoRetencionToSaves(estadoretencions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoRetencions();
			
			Boolean validadoTodosEstadoRetencion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoRetencion estadoretencionLocal:estadoretencions) {		
				if(estadoretencionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//EstadoRetencionLogicAdditional.updateEstadoRetencionToSave(estadoretencionLocal,this.arrDatoGeneral);
	        	
				EstadoRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadoretencionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoRetencion(estadoretencionLocal)) {
					EstadoRetencionDataAccess.save(estadoretencionLocal, connexion);				
				} else {
					validadoTodosEstadoRetencion=false;
				}
			}
			
			if(!validadoTodosEstadoRetencion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//EstadoRetencionLogicAdditional.checkEstadoRetencionToSavesAfter(estadoretencions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoRetencions();
			
			connexion.commit();		
			
			this.quitarEstadoRetencionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoRetencions()throws Exception {				
		 try {	
			//EstadoRetencionLogicAdditional.checkEstadoRetencionToSaves(estadoretencions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoRetencion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoRetencion estadoretencionLocal:estadoretencions) {				
				if(estadoretencionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//EstadoRetencionLogicAdditional.updateEstadoRetencionToSave(estadoretencionLocal,this.arrDatoGeneral);
	        	
				EstadoRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadoretencionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoRetencion(estadoretencionLocal)) {				
					EstadoRetencionDataAccess.save(estadoretencionLocal, connexion);				
				} else {
					validadoTodosEstadoRetencion=false;
				}
			}
			
			if(!validadoTodosEstadoRetencion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//EstadoRetencionLogicAdditional.checkEstadoRetencionToSavesAfter(estadoretencions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoRetencionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoRetencionParameterReturnGeneral procesarAccionEstadoRetencions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoRetencion> estadoretencions,EstadoRetencionParameterReturnGeneral estadoretencionParameterGeneral)throws Exception {
		 try {	
			EstadoRetencionParameterReturnGeneral estadoretencionReturnGeneral=new EstadoRetencionParameterReturnGeneral();
	
			
			return estadoretencionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoRetencionParameterReturnGeneral procesarAccionEstadoRetencionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoRetencion> estadoretencions,EstadoRetencionParameterReturnGeneral estadoretencionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRetencion.class.getSimpleName()+"-procesarAccionEstadoRetencionsWithConnection");connexion.begin();			
			
			EstadoRetencionParameterReturnGeneral estadoretencionReturnGeneral=new EstadoRetencionParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return estadoretencionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoRetencionParameterReturnGeneral procesarEventosEstadoRetencions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoRetencion> estadoretencions,EstadoRetencion estadoretencion,EstadoRetencionParameterReturnGeneral estadoretencionParameterGeneral,Boolean isEsNuevoEstadoRetencion,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoRetencionParameterReturnGeneral estadoretencionReturnGeneral=new EstadoRetencionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadoretencionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return estadoretencionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoRetencionParameterReturnGeneral procesarEventosEstadoRetencionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoRetencion> estadoretencions,EstadoRetencion estadoretencion,EstadoRetencionParameterReturnGeneral estadoretencionParameterGeneral,Boolean isEsNuevoEstadoRetencion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRetencion.class.getSimpleName()+"-procesarEventosEstadoRetencionsWithConnection");connexion.begin();			
			
			EstadoRetencionParameterReturnGeneral estadoretencionReturnGeneral=new EstadoRetencionParameterReturnGeneral();
	
			estadoretencionReturnGeneral.setEstadoRetencion(estadoretencion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadoretencionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return estadoretencionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoRetencionParameterReturnGeneral procesarImportacionEstadoRetencionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoRetencionParameterReturnGeneral estadoretencionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRetencion.class.getSimpleName()+"-procesarImportacionEstadoRetencionsWithConnection");connexion.begin();			
			
			EstadoRetencionParameterReturnGeneral estadoretencionReturnGeneral=new EstadoRetencionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadoretencions=new ArrayList<EstadoRetencion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadoretencion=new EstadoRetencion();
				
				
				if(conColumnasBase) {this.estadoretencion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadoretencion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadoretencion.setcodigo(arrColumnas[iColumn++]);
				this.estadoretencion.setnombre(arrColumnas[iColumn++]);
				
				this.estadoretencions.add(this.estadoretencion);
			}
			
			this.saveEstadoRetencions();
			
			this.connexion.commit();
			
			estadoretencionReturnGeneral.setConRetornoEstaProcesado(true);
			estadoretencionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadoretencionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoRetencionsEliminados() throws Exception {				
		
		List<EstadoRetencion> estadoretencionsAux= new ArrayList<EstadoRetencion>();
		
		for(EstadoRetencion estadoretencion:estadoretencions) {
			if(!estadoretencion.getIsDeleted()) {
				estadoretencionsAux.add(estadoretencion);
			}
		}
		
		estadoretencions=estadoretencionsAux;
	}
	
	public void quitarEstadoRetencionsNulos() throws Exception {				
		
		List<EstadoRetencion> estadoretencionsAux= new ArrayList<EstadoRetencion>();
		
		for(EstadoRetencion estadoretencion : this.estadoretencions) {
			if(estadoretencion==null) {
				estadoretencionsAux.add(estadoretencion);
			}
		}
		
		//this.estadoretencions=estadoretencionsAux;
		
		this.estadoretencions.removeAll(estadoretencionsAux);
	}
	
	public void getSetVersionRowEstadoRetencionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadoretencion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadoretencion.getIsDeleted() || (estadoretencion.getIsChanged()&&!estadoretencion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadoretencionDataAccess.getSetVersionRowEstadoRetencion(connexion,estadoretencion.getId());
				
				if(!estadoretencion.getVersionRow().equals(timestamp)) {	
					estadoretencion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadoretencion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoRetencion()throws Exception {	
		
		if(estadoretencion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadoretencion.getIsDeleted() || (estadoretencion.getIsChanged()&&!estadoretencion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadoretencionDataAccess.getSetVersionRowEstadoRetencion(connexion,estadoretencion.getId());
			
			try {							
				if(!estadoretencion.getVersionRow().equals(timestamp)) {	
					estadoretencion.setVersionRow(timestamp);
				}
				
				estadoretencion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoRetencionsWithConnection()throws Exception {	
		if(estadoretencions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoRetencion estadoretencionAux:estadoretencions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadoretencionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadoretencionAux.getIsDeleted() || (estadoretencionAux.getIsChanged()&&!estadoretencionAux.getIsNew())) {
						
						timestamp=estadoretencionDataAccess.getSetVersionRowEstadoRetencion(connexion,estadoretencionAux.getId());
						
						if(!estadoretencion.getVersionRow().equals(timestamp)) {	
							estadoretencionAux.setVersionRow(timestamp);
						}
								
						estadoretencionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoRetencions()throws Exception {	
		if(estadoretencions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoRetencion estadoretencionAux:estadoretencions) {
					if(estadoretencionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadoretencionAux.getIsDeleted() || (estadoretencionAux.getIsChanged()&&!estadoretencionAux.getIsNew())) {
						
						timestamp=estadoretencionDataAccess.getSetVersionRowEstadoRetencion(connexion,estadoretencionAux.getId());
						
						if(!estadoretencionAux.getVersionRow().equals(timestamp)) {	
							estadoretencionAux.setVersionRow(timestamp);
						}
						
													
						estadoretencionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyEstadoRetencionWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ClienteRetencionLogic clienteretencionLogic=new ClienteRetencionLogic();
			RetencionLogic retencionLogic=new RetencionLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoRetencion.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEstadoRetencionWithConnection");connexion.begin();
			
			
			classes.add(new Classe(ClienteRetencion.class));
			classes.add(new Classe(Retencion.class));
											
			

			clienteretencionLogic.setConnexion(this.getConnexion());
			clienteretencionLogic.setDatosCliente(this.datosCliente);
			clienteretencionLogic.setIsConRefrescarForeignKeys(true);

			retencionLogic.setConnexion(this.getConnexion());
			retencionLogic.setDatosCliente(this.datosCliente);
			retencionLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(EstadoRetencion estadoretencion:this.estadoretencions) {
				

				classes=new ArrayList<Classe>();
				classes=ClienteRetencionConstantesFunciones.getClassesForeignKeysOfClienteRetencion(new ArrayList<Classe>(),DeepLoadType.NONE);

				clienteretencionLogic.setClienteRetencions(estadoretencion.clienteretencions);
				clienteretencionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=RetencionConstantesFunciones.getClassesForeignKeysOfRetencion(new ArrayList<Classe>(),DeepLoadType.NONE);

				retencionLogic.setRetencions(estadoretencion.retencions);
				retencionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(EstadoRetencion estadoretencion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//EstadoRetencionLogicAdditional.updateEstadoRetencionToGet(estadoretencion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadoretencion.setClienteRetencions(estadoretencionDataAccess.getClienteRetencions(connexion,estadoretencion));
		estadoretencion.setRetencions(estadoretencionDataAccess.getRetencions(connexion,estadoretencion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ClienteRetencion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadoretencion.setClienteRetencions(estadoretencionDataAccess.getClienteRetencions(connexion,estadoretencion));

				if(this.isConDeep) {
					ClienteRetencionLogic clienteretencionLogic= new ClienteRetencionLogic(this.connexion);
					clienteretencionLogic.setClienteRetencions(estadoretencion.getClienteRetencions());
					ArrayList<Classe> classesLocal=ClienteRetencionConstantesFunciones.getClassesForeignKeysOfClienteRetencion(new ArrayList<Classe>(),DeepLoadType.NONE);
					clienteretencionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ClienteRetencionConstantesFunciones.refrescarForeignKeysDescripcionesClienteRetencion(clienteretencionLogic.getClienteRetencions());
					estadoretencion.setClienteRetencions(clienteretencionLogic.getClienteRetencions());
				}

				continue;
			}

			if(clas.clas.equals(Retencion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadoretencion.setRetencions(estadoretencionDataAccess.getRetencions(connexion,estadoretencion));

				if(this.isConDeep) {
					RetencionLogic retencionLogic= new RetencionLogic(this.connexion);
					retencionLogic.setRetencions(estadoretencion.getRetencions());
					ArrayList<Classe> classesLocal=RetencionConstantesFunciones.getClassesForeignKeysOfRetencion(new ArrayList<Classe>(),DeepLoadType.NONE);
					retencionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					RetencionConstantesFunciones.refrescarForeignKeysDescripcionesRetencion(retencionLogic.getRetencions());
					estadoretencion.setRetencions(retencionLogic.getRetencions());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ClienteRetencion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ClienteRetencion.class));
			estadoretencion.setClienteRetencions(estadoretencionDataAccess.getClienteRetencions(connexion,estadoretencion));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Retencion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Retencion.class));
			estadoretencion.setRetencions(estadoretencionDataAccess.getRetencions(connexion,estadoretencion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		estadoretencion.setClienteRetencions(estadoretencionDataAccess.getClienteRetencions(connexion,estadoretencion));

		for(ClienteRetencion clienteretencion:estadoretencion.getClienteRetencions()) {
			ClienteRetencionLogic clienteretencionLogic= new ClienteRetencionLogic(connexion);
			clienteretencionLogic.deepLoad(clienteretencion,isDeep,deepLoadType,clases);
		}

		estadoretencion.setRetencions(estadoretencionDataAccess.getRetencions(connexion,estadoretencion));

		for(Retencion retencion:estadoretencion.getRetencions()) {
			RetencionLogic retencionLogic= new RetencionLogic(connexion);
			retencionLogic.deepLoad(retencion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ClienteRetencion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadoretencion.setClienteRetencions(estadoretencionDataAccess.getClienteRetencions(connexion,estadoretencion));

				for(ClienteRetencion clienteretencion:estadoretencion.getClienteRetencions()) {
					ClienteRetencionLogic clienteretencionLogic= new ClienteRetencionLogic(connexion);
					clienteretencionLogic.deepLoad(clienteretencion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Retencion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadoretencion.setRetencions(estadoretencionDataAccess.getRetencions(connexion,estadoretencion));

				for(Retencion retencion:estadoretencion.getRetencions()) {
					RetencionLogic retencionLogic= new RetencionLogic(connexion);
					retencionLogic.deepLoad(retencion,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ClienteRetencion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ClienteRetencion.class));
			estadoretencion.setClienteRetencions(estadoretencionDataAccess.getClienteRetencions(connexion,estadoretencion));

			for(ClienteRetencion clienteretencion:estadoretencion.getClienteRetencions()) {
				ClienteRetencionLogic clienteretencionLogic= new ClienteRetencionLogic(connexion);
				clienteretencionLogic.deepLoad(clienteretencion,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Retencion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Retencion.class));
			estadoretencion.setRetencions(estadoretencionDataAccess.getRetencions(connexion,estadoretencion));

			for(Retencion retencion:estadoretencion.getRetencions()) {
				RetencionLogic retencionLogic= new RetencionLogic(connexion);
				retencionLogic.deepLoad(retencion,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoRetencion estadoretencion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoRetencion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadoretencion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRetencion(estadoretencion);
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
			this.deepLoad(this.estadoretencion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRetencion(this.estadoretencion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoRetencion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadoretencions!=null) {
				for(EstadoRetencion estadoretencion:estadoretencions) {
					this.deepLoad(estadoretencion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRetencion(estadoretencions);
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
			if(estadoretencions!=null) {
				for(EstadoRetencion estadoretencion:estadoretencions) {
					this.deepLoad(estadoretencion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoRetencionConstantesFunciones.refrescarForeignKeysDescripcionesEstadoRetencion(estadoretencions);
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
	
	
	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoRetencionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoRetencionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoRetencion estadoretencion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoRetencionConstantesFunciones.ISCONAUDITORIA) {
				if(estadoretencion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoRetencionDataAccess.TABLENAME, estadoretencion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoRetencionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoRetencionLogic.registrarAuditoriaDetallesEstadoRetencion(connexion,estadoretencion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadoretencion.getIsDeleted()) {
					/*if(!estadoretencion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoRetencionDataAccess.TABLENAME, estadoretencion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoRetencionLogic.registrarAuditoriaDetallesEstadoRetencion(connexion,estadoretencion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoRetencionDataAccess.TABLENAME, estadoretencion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadoretencion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoRetencionDataAccess.TABLENAME, estadoretencion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoRetencionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoRetencionLogic.registrarAuditoriaDetallesEstadoRetencion(connexion,estadoretencion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoRetencion(Connexion connexion,EstadoRetencion estadoretencion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadoretencion.getIsNew()||!estadoretencion.getcodigo().equals(estadoretencion.getEstadoRetencionOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadoretencion.getEstadoRetencionOriginal().getcodigo()!=null)
				{
					strValorActual=estadoretencion.getEstadoRetencionOriginal().getcodigo();
				}
				if(estadoretencion.getcodigo()!=null)
				{
					strValorNuevo=estadoretencion.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoRetencionConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(estadoretencion.getIsNew()||!estadoretencion.getnombre().equals(estadoretencion.getEstadoRetencionOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadoretencion.getEstadoRetencionOriginal().getnombre()!=null)
				{
					strValorActual=estadoretencion.getEstadoRetencionOriginal().getnombre();
				}
				if(estadoretencion.getnombre()!=null)
				{
					strValorNuevo=estadoretencion.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoRetencionConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoRetencion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoRetencionConstantesFunciones.getClassesForeignKeysOfEstadoRetencion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoRetencion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoRetencionConstantesFunciones.getClassesRelationshipsOfEstadoRetencion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

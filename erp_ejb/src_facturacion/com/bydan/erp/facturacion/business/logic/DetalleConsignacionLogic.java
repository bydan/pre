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
import com.bydan.erp.facturacion.util.DetalleConsignacionConstantesFunciones;
import com.bydan.erp.facturacion.util.DetalleConsignacionParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.DetalleConsignacionParameterGeneral;
import com.bydan.erp.facturacion.business.entity.DetalleConsignacion;
import com.bydan.erp.facturacion.business.logic.DetalleConsignacionLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

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
public class DetalleConsignacionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetalleConsignacionLogic.class);
	
	protected DetalleConsignacionDataAccess detalleconsignacionDataAccess; 	
	protected DetalleConsignacion detalleconsignacion;
	protected List<DetalleConsignacion> detalleconsignacions;
	protected Object detalleconsignacionObject;	
	protected List<Object> detalleconsignacionsObject;
	
	public static ClassValidator<DetalleConsignacion> detalleconsignacionValidator = new ClassValidator<DetalleConsignacion>(DetalleConsignacion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetalleConsignacionLogicAdditional detalleconsignacionLogicAdditional=null;
	
	public DetalleConsignacionLogicAdditional getDetalleConsignacionLogicAdditional() {
		return this.detalleconsignacionLogicAdditional;
	}
	
	public void setDetalleConsignacionLogicAdditional(DetalleConsignacionLogicAdditional detalleconsignacionLogicAdditional) {
		try {
			this.detalleconsignacionLogicAdditional=detalleconsignacionLogicAdditional;
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
	
	
	
	
	public  DetalleConsignacionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detalleconsignacionDataAccess = new DetalleConsignacionDataAccess();
			
			this.detalleconsignacions= new ArrayList<DetalleConsignacion>();
			this.detalleconsignacion= new DetalleConsignacion();
			
			this.detalleconsignacionObject=new Object();
			this.detalleconsignacionsObject=new ArrayList<Object>();
				
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
			
			this.detalleconsignacionDataAccess.setConnexionType(this.connexionType);
			this.detalleconsignacionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetalleConsignacionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detalleconsignacionDataAccess = new DetalleConsignacionDataAccess();
			this.detalleconsignacions= new ArrayList<DetalleConsignacion>();
			this.detalleconsignacion= new DetalleConsignacion();
			this.detalleconsignacionObject=new Object();
			this.detalleconsignacionsObject=new ArrayList<Object>();
			
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
			
			this.detalleconsignacionDataAccess.setConnexionType(this.connexionType);
			this.detalleconsignacionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetalleConsignacion getDetalleConsignacion() throws Exception {	
		DetalleConsignacionLogicAdditional.checkDetalleConsignacionToGet(detalleconsignacion,this.datosCliente,this.arrDatoGeneral);
		DetalleConsignacionLogicAdditional.updateDetalleConsignacionToGet(detalleconsignacion,this.arrDatoGeneral);
		
		return detalleconsignacion;
	}
		
	public void setDetalleConsignacion(DetalleConsignacion newDetalleConsignacion) {
		this.detalleconsignacion = newDetalleConsignacion;
	}
	
	public DetalleConsignacionDataAccess getDetalleConsignacionDataAccess() {
		return detalleconsignacionDataAccess;
	}
	
	public void setDetalleConsignacionDataAccess(DetalleConsignacionDataAccess newdetalleconsignacionDataAccess) {
		this.detalleconsignacionDataAccess = newdetalleconsignacionDataAccess;
	}
	
	public List<DetalleConsignacion> getDetalleConsignacions() throws Exception {		
		this.quitarDetalleConsignacionsNulos();
		
		DetalleConsignacionLogicAdditional.checkDetalleConsignacionToGets(detalleconsignacions,this.datosCliente,this.arrDatoGeneral);
		
		for (DetalleConsignacion detalleconsignacionLocal: detalleconsignacions ) {
			DetalleConsignacionLogicAdditional.updateDetalleConsignacionToGet(detalleconsignacionLocal,this.arrDatoGeneral);
		}
		
		return detalleconsignacions;
	}
	
	public void setDetalleConsignacions(List<DetalleConsignacion> newDetalleConsignacions) {
		this.detalleconsignacions = newDetalleConsignacions;
	}
	
	public Object getDetalleConsignacionObject() {	
		this.detalleconsignacionObject=this.detalleconsignacionDataAccess.getEntityObject();
		return this.detalleconsignacionObject;
	}
		
	public void setDetalleConsignacionObject(Object newDetalleConsignacionObject) {
		this.detalleconsignacionObject = newDetalleConsignacionObject;
	}
	
	public List<Object> getDetalleConsignacionsObject() {		
		this.detalleconsignacionsObject=this.detalleconsignacionDataAccess.getEntitiesObject();
		return this.detalleconsignacionsObject;
	}
		
	public void setDetalleConsignacionsObject(List<Object> newDetalleConsignacionsObject) {
		this.detalleconsignacionsObject = newDetalleConsignacionsObject;
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
		
		if(this.detalleconsignacionDataAccess!=null) {
			this.detalleconsignacionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleConsignacion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detalleconsignacionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detalleconsignacionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detalleconsignacion = new  DetalleConsignacion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleConsignacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalleconsignacion=detalleconsignacionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleconsignacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(this.detalleconsignacion);
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
		detalleconsignacion = new  DetalleConsignacion();
		  		  
        try {
			
			detalleconsignacion=detalleconsignacionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleconsignacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(this.detalleconsignacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detalleconsignacion = new  DetalleConsignacion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleConsignacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detalleconsignacion=detalleconsignacionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleconsignacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(this.detalleconsignacion);
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
		detalleconsignacion = new  DetalleConsignacion();
		  		  
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
		detalleconsignacion = new  DetalleConsignacion();
		  		  
        try {
			
			detalleconsignacion=detalleconsignacionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detalleconsignacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(this.detalleconsignacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detalleconsignacion = new  DetalleConsignacion();
		  		  
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
		detalleconsignacion = new  DetalleConsignacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleConsignacion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detalleconsignacionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleconsignacion = new  DetalleConsignacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detalleconsignacionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalleconsignacion = new  DetalleConsignacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleConsignacion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detalleconsignacionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleconsignacion = new  DetalleConsignacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detalleconsignacionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detalleconsignacion = new  DetalleConsignacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleConsignacion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detalleconsignacionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detalleconsignacion = new  DetalleConsignacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detalleconsignacionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleconsignacions = new  ArrayList<DetalleConsignacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleConsignacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetalleConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleconsignacions=detalleconsignacionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleConsignacion(detalleconsignacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(this.detalleconsignacions);
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
		detalleconsignacions = new  ArrayList<DetalleConsignacion>();
		  		  
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
		detalleconsignacions = new  ArrayList<DetalleConsignacion>();
		  		  
        try {			
			DetalleConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleconsignacions=detalleconsignacionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetalleConsignacion(detalleconsignacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(this.detalleconsignacions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detalleconsignacions = new  ArrayList<DetalleConsignacion>();
		  		  
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
		detalleconsignacions = new  ArrayList<DetalleConsignacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleConsignacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetalleConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleconsignacions=detalleconsignacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleConsignacion(detalleconsignacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(this.detalleconsignacions);
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
		detalleconsignacions = new  ArrayList<DetalleConsignacion>();
		  		  
        try {
			DetalleConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleconsignacions=detalleconsignacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleConsignacion(detalleconsignacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(this.detalleconsignacions);
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
		detalleconsignacions = new  ArrayList<DetalleConsignacion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleConsignacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleconsignacions=detalleconsignacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleConsignacion(detalleconsignacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(this.detalleconsignacions);
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
		detalleconsignacions = new  ArrayList<DetalleConsignacion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleconsignacions=detalleconsignacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleConsignacion(detalleconsignacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(this.detalleconsignacions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detalleconsignacion = new  DetalleConsignacion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleConsignacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleconsignacion=detalleconsignacionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleConsignacion(detalleconsignacion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(this.detalleconsignacion);
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
		detalleconsignacion = new  DetalleConsignacion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleconsignacion=detalleconsignacionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetalleConsignacion(detalleconsignacion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(this.detalleconsignacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detalleconsignacions = new  ArrayList<DetalleConsignacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleConsignacion.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetalleConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleconsignacions=detalleconsignacionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleConsignacion(detalleconsignacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(this.detalleconsignacions);
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
		detalleconsignacions = new  ArrayList<DetalleConsignacion>();
		  		  
        try {
			DetalleConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleconsignacions=detalleconsignacionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetalleConsignacion(detalleconsignacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(this.detalleconsignacions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetalleConsignacionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detalleconsignacions = new  ArrayList<DetalleConsignacion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleConsignacion.class.getSimpleName()+"-getTodosDetalleConsignacionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleconsignacions=detalleconsignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleConsignacion(detalleconsignacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(this.detalleconsignacions);
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
	
	public  void  getTodosDetalleConsignacions(String sFinalQuery,Pagination pagination)throws Exception {
		detalleconsignacions = new  ArrayList<DetalleConsignacion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetalleConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detalleconsignacions=detalleconsignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetalleConsignacion(detalleconsignacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(this.detalleconsignacions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetalleConsignacion(DetalleConsignacion detalleconsignacion) throws Exception {
		Boolean estaValidado=false;
		
		if(detalleconsignacion.getIsNew() || detalleconsignacion.getIsChanged()) { 
			this.invalidValues = detalleconsignacionValidator.getInvalidValues(detalleconsignacion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detalleconsignacion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetalleConsignacion(List<DetalleConsignacion> DetalleConsignacions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetalleConsignacion detalleconsignacionLocal:detalleconsignacions) {				
			estaValidadoObjeto=this.validarGuardarDetalleConsignacion(detalleconsignacionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetalleConsignacion(List<DetalleConsignacion> DetalleConsignacions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleConsignacion(detalleconsignacions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetalleConsignacion(DetalleConsignacion DetalleConsignacion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetalleConsignacion(detalleconsignacion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetalleConsignacion detalleconsignacion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detalleconsignacion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetalleConsignacionConstantesFunciones.getDetalleConsignacionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detalleconsignacion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetalleConsignacionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetalleConsignacionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetalleConsignacionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleConsignacion.class.getSimpleName()+"-saveDetalleConsignacionWithConnection");connexion.begin();			
			
			DetalleConsignacionLogicAdditional.checkDetalleConsignacionToSave(this.detalleconsignacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleConsignacionLogicAdditional.updateDetalleConsignacionToSave(this.detalleconsignacion,this.arrDatoGeneral);
			
			DetalleConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalleconsignacion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetalleConsignacion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleConsignacion(this.detalleconsignacion)) {
				DetalleConsignacionDataAccess.save(this.detalleconsignacion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detalleconsignacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleConsignacionLogicAdditional.checkDetalleConsignacionToSaveAfter(this.detalleconsignacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleConsignacion();
			
			connexion.commit();			
			
			if(this.detalleconsignacion.getIsDeleted()) {
				this.detalleconsignacion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetalleConsignacion()throws Exception {	
		try {	
			
			DetalleConsignacionLogicAdditional.checkDetalleConsignacionToSave(this.detalleconsignacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetalleConsignacionLogicAdditional.updateDetalleConsignacionToSave(this.detalleconsignacion,this.arrDatoGeneral);
			
			DetalleConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detalleconsignacion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetalleConsignacion(this.detalleconsignacion)) {			
				DetalleConsignacionDataAccess.save(this.detalleconsignacion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detalleconsignacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetalleConsignacionLogicAdditional.checkDetalleConsignacionToSaveAfter(this.detalleconsignacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detalleconsignacion.getIsDeleted()) {
				this.detalleconsignacion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetalleConsignacionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleConsignacion.class.getSimpleName()+"-saveDetalleConsignacionsWithConnection");connexion.begin();			
			
			DetalleConsignacionLogicAdditional.checkDetalleConsignacionToSaves(detalleconsignacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetalleConsignacions();
			
			Boolean validadoTodosDetalleConsignacion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleConsignacion detalleconsignacionLocal:detalleconsignacions) {		
				if(detalleconsignacionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleConsignacionLogicAdditional.updateDetalleConsignacionToSave(detalleconsignacionLocal,this.arrDatoGeneral);
	        	
				DetalleConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleconsignacionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleConsignacion(detalleconsignacionLocal)) {
					DetalleConsignacionDataAccess.save(detalleconsignacionLocal, connexion);				
				} else {
					validadoTodosDetalleConsignacion=false;
				}
			}
			
			if(!validadoTodosDetalleConsignacion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleConsignacionLogicAdditional.checkDetalleConsignacionToSavesAfter(detalleconsignacions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetalleConsignacions();
			
			connexion.commit();		
			
			this.quitarDetalleConsignacionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetalleConsignacions()throws Exception {				
		 try {	
			DetalleConsignacionLogicAdditional.checkDetalleConsignacionToSaves(detalleconsignacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetalleConsignacion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetalleConsignacion detalleconsignacionLocal:detalleconsignacions) {				
				if(detalleconsignacionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetalleConsignacionLogicAdditional.updateDetalleConsignacionToSave(detalleconsignacionLocal,this.arrDatoGeneral);
	        	
				DetalleConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detalleconsignacionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetalleConsignacion(detalleconsignacionLocal)) {				
					DetalleConsignacionDataAccess.save(detalleconsignacionLocal, connexion);				
				} else {
					validadoTodosDetalleConsignacion=false;
				}
			}
			
			if(!validadoTodosDetalleConsignacion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetalleConsignacionLogicAdditional.checkDetalleConsignacionToSavesAfter(detalleconsignacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetalleConsignacionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleConsignacionParameterReturnGeneral procesarAccionDetalleConsignacions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleConsignacion> detalleconsignacions,DetalleConsignacionParameterReturnGeneral detalleconsignacionParameterGeneral)throws Exception {
		 try {	
			DetalleConsignacionParameterReturnGeneral detalleconsignacionReturnGeneral=new DetalleConsignacionParameterReturnGeneral();
	
			DetalleConsignacionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleconsignacions,detalleconsignacionParameterGeneral,detalleconsignacionReturnGeneral);
			
			return detalleconsignacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetalleConsignacionParameterReturnGeneral procesarAccionDetalleConsignacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetalleConsignacion> detalleconsignacions,DetalleConsignacionParameterReturnGeneral detalleconsignacionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleConsignacion.class.getSimpleName()+"-procesarAccionDetalleConsignacionsWithConnection");connexion.begin();			
			
			DetalleConsignacionParameterReturnGeneral detalleconsignacionReturnGeneral=new DetalleConsignacionParameterReturnGeneral();
	
			DetalleConsignacionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detalleconsignacions,detalleconsignacionParameterGeneral,detalleconsignacionReturnGeneral);
			
			this.connexion.commit();
			
			return detalleconsignacionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleConsignacionParameterReturnGeneral procesarEventosDetalleConsignacions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleConsignacion> detalleconsignacions,DetalleConsignacion detalleconsignacion,DetalleConsignacionParameterReturnGeneral detalleconsignacionParameterGeneral,Boolean isEsNuevoDetalleConsignacion,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetalleConsignacionParameterReturnGeneral detalleconsignacionReturnGeneral=new DetalleConsignacionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleconsignacionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleConsignacionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleconsignacions,detalleconsignacion,detalleconsignacionParameterGeneral,detalleconsignacionReturnGeneral,isEsNuevoDetalleConsignacion,clases);
			
			return detalleconsignacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetalleConsignacionParameterReturnGeneral procesarEventosDetalleConsignacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetalleConsignacion> detalleconsignacions,DetalleConsignacion detalleconsignacion,DetalleConsignacionParameterReturnGeneral detalleconsignacionParameterGeneral,Boolean isEsNuevoDetalleConsignacion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleConsignacion.class.getSimpleName()+"-procesarEventosDetalleConsignacionsWithConnection");connexion.begin();			
			
			DetalleConsignacionParameterReturnGeneral detalleconsignacionReturnGeneral=new DetalleConsignacionParameterReturnGeneral();
	
			detalleconsignacionReturnGeneral.setDetalleConsignacion(detalleconsignacion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detalleconsignacionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetalleConsignacionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detalleconsignacions,detalleconsignacion,detalleconsignacionParameterGeneral,detalleconsignacionReturnGeneral,isEsNuevoDetalleConsignacion,clases);
			
			this.connexion.commit();
			
			return detalleconsignacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetalleConsignacionParameterReturnGeneral procesarImportacionDetalleConsignacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetalleConsignacionParameterReturnGeneral detalleconsignacionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleConsignacion.class.getSimpleName()+"-procesarImportacionDetalleConsignacionsWithConnection");connexion.begin();			
			
			DetalleConsignacionParameterReturnGeneral detalleconsignacionReturnGeneral=new DetalleConsignacionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detalleconsignacions=new ArrayList<DetalleConsignacion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detalleconsignacion=new DetalleConsignacion();
				
				
				if(conColumnasBase) {this.detalleconsignacion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detalleconsignacion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detalleconsignacion.setcantidad(Integer.parseInt(arrColumnas[iColumn++]));
				this.detalleconsignacion.setprecio(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleconsignacion.setdescuento_porcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleconsignacion.setdescuento_valor(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleconsignacion.setiva(Double.parseDouble(arrColumnas[iColumn++]));
				this.detalleconsignacion.settotal(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.detalleconsignacions.add(this.detalleconsignacion);
			}
			
			this.saveDetalleConsignacions();
			
			this.connexion.commit();
			
			detalleconsignacionReturnGeneral.setConRetornoEstaProcesado(true);
			detalleconsignacionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detalleconsignacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetalleConsignacionsEliminados() throws Exception {				
		
		List<DetalleConsignacion> detalleconsignacionsAux= new ArrayList<DetalleConsignacion>();
		
		for(DetalleConsignacion detalleconsignacion:detalleconsignacions) {
			if(!detalleconsignacion.getIsDeleted()) {
				detalleconsignacionsAux.add(detalleconsignacion);
			}
		}
		
		detalleconsignacions=detalleconsignacionsAux;
	}
	
	public void quitarDetalleConsignacionsNulos() throws Exception {				
		
		List<DetalleConsignacion> detalleconsignacionsAux= new ArrayList<DetalleConsignacion>();
		
		for(DetalleConsignacion detalleconsignacion : this.detalleconsignacions) {
			if(detalleconsignacion==null) {
				detalleconsignacionsAux.add(detalleconsignacion);
			}
		}
		
		//this.detalleconsignacions=detalleconsignacionsAux;
		
		this.detalleconsignacions.removeAll(detalleconsignacionsAux);
	}
	
	public void getSetVersionRowDetalleConsignacionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detalleconsignacion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detalleconsignacion.getIsDeleted() || (detalleconsignacion.getIsChanged()&&!detalleconsignacion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detalleconsignacionDataAccess.getSetVersionRowDetalleConsignacion(connexion,detalleconsignacion.getId());
				
				if(!detalleconsignacion.getVersionRow().equals(timestamp)) {	
					detalleconsignacion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detalleconsignacion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetalleConsignacion()throws Exception {	
		
		if(detalleconsignacion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detalleconsignacion.getIsDeleted() || (detalleconsignacion.getIsChanged()&&!detalleconsignacion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detalleconsignacionDataAccess.getSetVersionRowDetalleConsignacion(connexion,detalleconsignacion.getId());
			
			try {							
				if(!detalleconsignacion.getVersionRow().equals(timestamp)) {	
					detalleconsignacion.setVersionRow(timestamp);
				}
				
				detalleconsignacion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetalleConsignacionsWithConnection()throws Exception {	
		if(detalleconsignacions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetalleConsignacion detalleconsignacionAux:detalleconsignacions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detalleconsignacionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleconsignacionAux.getIsDeleted() || (detalleconsignacionAux.getIsChanged()&&!detalleconsignacionAux.getIsNew())) {
						
						timestamp=detalleconsignacionDataAccess.getSetVersionRowDetalleConsignacion(connexion,detalleconsignacionAux.getId());
						
						if(!detalleconsignacion.getVersionRow().equals(timestamp)) {	
							detalleconsignacionAux.setVersionRow(timestamp);
						}
								
						detalleconsignacionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetalleConsignacions()throws Exception {	
		if(detalleconsignacions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetalleConsignacion detalleconsignacionAux:detalleconsignacions) {
					if(detalleconsignacionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detalleconsignacionAux.getIsDeleted() || (detalleconsignacionAux.getIsChanged()&&!detalleconsignacionAux.getIsNew())) {
						
						timestamp=detalleconsignacionDataAccess.getSetVersionRowDetalleConsignacion(connexion,detalleconsignacionAux.getId());
						
						if(!detalleconsignacionAux.getVersionRow().equals(timestamp)) {	
							detalleconsignacionAux.setVersionRow(timestamp);
						}
						
													
						detalleconsignacionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetalleConsignacionParameterReturnGeneral cargarCombosLoteForeignKeyDetalleConsignacionWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalConsignacion,String finalQueryGlobalProducto,String finalQueryGlobalBodega,String finalQueryGlobalUnidad,String finalQueryGlobalEstadoDetallePedido) throws Exception {
		DetalleConsignacionParameterReturnGeneral  detalleconsignacionReturnGeneral =new DetalleConsignacionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleConsignacion.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetalleConsignacionWithConnection");connexion.begin();
			
			detalleconsignacionReturnGeneral =new DetalleConsignacionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalleconsignacionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detalleconsignacionReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detalleconsignacionReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detalleconsignacionReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detalleconsignacionReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detalleconsignacionReturnGeneral.setmessForeignKey(messForeignKey);


			List<Consignacion> consignacionsForeignKey=new ArrayList<Consignacion>();
			ConsignacionLogic consignacionLogic=new ConsignacionLogic();
			consignacionLogic.setConnexion(this.connexion);
			consignacionLogic.getConsignacionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalConsignacion.equals("NONE")) {
				consignacionLogic.getTodosConsignacions(finalQueryGlobalConsignacion,new Pagination());
				consignacionsForeignKey=consignacionLogic.getConsignacions();
			}

			detalleconsignacionReturnGeneral.setconsignacionsForeignKey(consignacionsForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detalleconsignacionReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detalleconsignacionReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detalleconsignacionReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<EstadoDetallePedido> estadodetallepedidosForeignKey=new ArrayList<EstadoDetallePedido>();
			EstadoDetallePedidoLogic estadodetallepedidoLogic=new EstadoDetallePedidoLogic();
			estadodetallepedidoLogic.setConnexion(this.connexion);
			estadodetallepedidoLogic.getEstadoDetallePedidoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoDetallePedido.equals("NONE")) {
				estadodetallepedidoLogic.getTodosEstadoDetallePedidos(finalQueryGlobalEstadoDetallePedido,new Pagination());
				estadodetallepedidosForeignKey=estadodetallepedidoLogic.getEstadoDetallePedidos();
			}

			detalleconsignacionReturnGeneral.setestadodetallepedidosForeignKey(estadodetallepedidosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detalleconsignacionReturnGeneral;
	}
	
	public DetalleConsignacionParameterReturnGeneral cargarCombosLoteForeignKeyDetalleConsignacion(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalConsignacion,String finalQueryGlobalProducto,String finalQueryGlobalBodega,String finalQueryGlobalUnidad,String finalQueryGlobalEstadoDetallePedido) throws Exception {
		DetalleConsignacionParameterReturnGeneral  detalleconsignacionReturnGeneral =new DetalleConsignacionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detalleconsignacionReturnGeneral =new DetalleConsignacionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detalleconsignacionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detalleconsignacionReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detalleconsignacionReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detalleconsignacionReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detalleconsignacionReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detalleconsignacionReturnGeneral.setmessForeignKey(messForeignKey);


			List<Consignacion> consignacionsForeignKey=new ArrayList<Consignacion>();
			ConsignacionLogic consignacionLogic=new ConsignacionLogic();
			consignacionLogic.setConnexion(this.connexion);
			consignacionLogic.getConsignacionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalConsignacion.equals("NONE")) {
				consignacionLogic.getTodosConsignacions(finalQueryGlobalConsignacion,new Pagination());
				consignacionsForeignKey=consignacionLogic.getConsignacions();
			}

			detalleconsignacionReturnGeneral.setconsignacionsForeignKey(consignacionsForeignKey);


			List<Producto> productosForeignKey=new ArrayList<Producto>();
			ProductoLogic productoLogic=new ProductoLogic();
			productoLogic.setConnexion(this.connexion);
			//productoLogic.getProductoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalProducto.equals("NONE")) {
				productoLogic.getTodosProductos(finalQueryGlobalProducto,new Pagination());
				productosForeignKey=productoLogic.getProductos();
			}

			detalleconsignacionReturnGeneral.setproductosForeignKey(productosForeignKey);


			List<Bodega> bodegasForeignKey=new ArrayList<Bodega>();
			BodegaLogic bodegaLogic=new BodegaLogic();
			bodegaLogic.setConnexion(this.connexion);
			bodegaLogic.getBodegaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBodega.equals("NONE")) {
				bodegaLogic.getTodosBodegas(finalQueryGlobalBodega,new Pagination());
				bodegasForeignKey=bodegaLogic.getBodegas();
			}

			detalleconsignacionReturnGeneral.setbodegasForeignKey(bodegasForeignKey);


			List<Unidad> unidadsForeignKey=new ArrayList<Unidad>();
			UnidadLogic unidadLogic=new UnidadLogic();
			unidadLogic.setConnexion(this.connexion);
			unidadLogic.getUnidadDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUnidad.equals("NONE")) {
				unidadLogic.getTodosUnidads(finalQueryGlobalUnidad,new Pagination());
				unidadsForeignKey=unidadLogic.getUnidads();
			}

			detalleconsignacionReturnGeneral.setunidadsForeignKey(unidadsForeignKey);


			List<EstadoDetallePedido> estadodetallepedidosForeignKey=new ArrayList<EstadoDetallePedido>();
			EstadoDetallePedidoLogic estadodetallepedidoLogic=new EstadoDetallePedidoLogic();
			estadodetallepedidoLogic.setConnexion(this.connexion);
			estadodetallepedidoLogic.getEstadoDetallePedidoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoDetallePedido.equals("NONE")) {
				estadodetallepedidoLogic.getTodosEstadoDetallePedidos(finalQueryGlobalEstadoDetallePedido,new Pagination());
				estadodetallepedidosForeignKey=estadodetallepedidoLogic.getEstadoDetallePedidos();
			}

			detalleconsignacionReturnGeneral.setestadodetallepedidosForeignKey(estadodetallepedidosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detalleconsignacionReturnGeneral;
	}
	
	
	public void deepLoad(DetalleConsignacion detalleconsignacion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetalleConsignacionLogicAdditional.updateDetalleConsignacionToGet(detalleconsignacion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalleconsignacion.setEmpresa(detalleconsignacionDataAccess.getEmpresa(connexion,detalleconsignacion));
		detalleconsignacion.setSucursal(detalleconsignacionDataAccess.getSucursal(connexion,detalleconsignacion));
		detalleconsignacion.setEjercicio(detalleconsignacionDataAccess.getEjercicio(connexion,detalleconsignacion));
		detalleconsignacion.setPeriodo(detalleconsignacionDataAccess.getPeriodo(connexion,detalleconsignacion));
		detalleconsignacion.setAnio(detalleconsignacionDataAccess.getAnio(connexion,detalleconsignacion));
		detalleconsignacion.setMes(detalleconsignacionDataAccess.getMes(connexion,detalleconsignacion));
		detalleconsignacion.setConsignacion(detalleconsignacionDataAccess.getConsignacion(connexion,detalleconsignacion));
		detalleconsignacion.setProducto(detalleconsignacionDataAccess.getProducto(connexion,detalleconsignacion));
		detalleconsignacion.setBodega(detalleconsignacionDataAccess.getBodega(connexion,detalleconsignacion));
		detalleconsignacion.setUnidad(detalleconsignacionDataAccess.getUnidad(connexion,detalleconsignacion));
		detalleconsignacion.setEstadoDetallePedido(detalleconsignacionDataAccess.getEstadoDetallePedido(connexion,detalleconsignacion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detalleconsignacion.setEmpresa(detalleconsignacionDataAccess.getEmpresa(connexion,detalleconsignacion));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detalleconsignacion.setSucursal(detalleconsignacionDataAccess.getSucursal(connexion,detalleconsignacion));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detalleconsignacion.setEjercicio(detalleconsignacionDataAccess.getEjercicio(connexion,detalleconsignacion));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detalleconsignacion.setPeriodo(detalleconsignacionDataAccess.getPeriodo(connexion,detalleconsignacion));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detalleconsignacion.setAnio(detalleconsignacionDataAccess.getAnio(connexion,detalleconsignacion));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detalleconsignacion.setMes(detalleconsignacionDataAccess.getMes(connexion,detalleconsignacion));
				continue;
			}

			if(clas.clas.equals(Consignacion.class)) {
				detalleconsignacion.setConsignacion(detalleconsignacionDataAccess.getConsignacion(connexion,detalleconsignacion));
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detalleconsignacion.setProducto(detalleconsignacionDataAccess.getProducto(connexion,detalleconsignacion));
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detalleconsignacion.setBodega(detalleconsignacionDataAccess.getBodega(connexion,detalleconsignacion));
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detalleconsignacion.setUnidad(detalleconsignacionDataAccess.getUnidad(connexion,detalleconsignacion));
				continue;
			}

			if(clas.clas.equals(EstadoDetallePedido.class)) {
				detalleconsignacion.setEstadoDetallePedido(detalleconsignacionDataAccess.getEstadoDetallePedido(connexion,detalleconsignacion));
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
			detalleconsignacion.setEmpresa(detalleconsignacionDataAccess.getEmpresa(connexion,detalleconsignacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleconsignacion.setSucursal(detalleconsignacionDataAccess.getSucursal(connexion,detalleconsignacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleconsignacion.setEjercicio(detalleconsignacionDataAccess.getEjercicio(connexion,detalleconsignacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleconsignacion.setPeriodo(detalleconsignacionDataAccess.getPeriodo(connexion,detalleconsignacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleconsignacion.setAnio(detalleconsignacionDataAccess.getAnio(connexion,detalleconsignacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleconsignacion.setMes(detalleconsignacionDataAccess.getMes(connexion,detalleconsignacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Consignacion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleconsignacion.setConsignacion(detalleconsignacionDataAccess.getConsignacion(connexion,detalleconsignacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleconsignacion.setProducto(detalleconsignacionDataAccess.getProducto(connexion,detalleconsignacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleconsignacion.setBodega(detalleconsignacionDataAccess.getBodega(connexion,detalleconsignacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleconsignacion.setUnidad(detalleconsignacionDataAccess.getUnidad(connexion,detalleconsignacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoDetallePedido.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleconsignacion.setEstadoDetallePedido(detalleconsignacionDataAccess.getEstadoDetallePedido(connexion,detalleconsignacion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detalleconsignacion.setEmpresa(detalleconsignacionDataAccess.getEmpresa(connexion,detalleconsignacion));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalleconsignacion.getEmpresa(),isDeep,deepLoadType,clases);
				
		detalleconsignacion.setSucursal(detalleconsignacionDataAccess.getSucursal(connexion,detalleconsignacion));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detalleconsignacion.getSucursal(),isDeep,deepLoadType,clases);
				
		detalleconsignacion.setEjercicio(detalleconsignacionDataAccess.getEjercicio(connexion,detalleconsignacion));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detalleconsignacion.getEjercicio(),isDeep,deepLoadType,clases);
				
		detalleconsignacion.setPeriodo(detalleconsignacionDataAccess.getPeriodo(connexion,detalleconsignacion));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detalleconsignacion.getPeriodo(),isDeep,deepLoadType,clases);
				
		detalleconsignacion.setAnio(detalleconsignacionDataAccess.getAnio(connexion,detalleconsignacion));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detalleconsignacion.getAnio(),isDeep,deepLoadType,clases);
				
		detalleconsignacion.setMes(detalleconsignacionDataAccess.getMes(connexion,detalleconsignacion));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detalleconsignacion.getMes(),isDeep,deepLoadType,clases);
				
		detalleconsignacion.setConsignacion(detalleconsignacionDataAccess.getConsignacion(connexion,detalleconsignacion));
		ConsignacionLogic consignacionLogic= new ConsignacionLogic(connexion);
		consignacionLogic.deepLoad(detalleconsignacion.getConsignacion(),isDeep,deepLoadType,clases);
				
		detalleconsignacion.setProducto(detalleconsignacionDataAccess.getProducto(connexion,detalleconsignacion));
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detalleconsignacion.getProducto(),isDeep,deepLoadType,clases);
				
		detalleconsignacion.setBodega(detalleconsignacionDataAccess.getBodega(connexion,detalleconsignacion));
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detalleconsignacion.getBodega(),isDeep,deepLoadType,clases);
				
		detalleconsignacion.setUnidad(detalleconsignacionDataAccess.getUnidad(connexion,detalleconsignacion));
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detalleconsignacion.getUnidad(),isDeep,deepLoadType,clases);
				
		detalleconsignacion.setEstadoDetallePedido(detalleconsignacionDataAccess.getEstadoDetallePedido(connexion,detalleconsignacion));
		EstadoDetallePedidoLogic estadodetallepedidoLogic= new EstadoDetallePedidoLogic(connexion);
		estadodetallepedidoLogic.deepLoad(detalleconsignacion.getEstadoDetallePedido(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detalleconsignacion.setEmpresa(detalleconsignacionDataAccess.getEmpresa(connexion,detalleconsignacion));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detalleconsignacion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detalleconsignacion.setSucursal(detalleconsignacionDataAccess.getSucursal(connexion,detalleconsignacion));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detalleconsignacion.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detalleconsignacion.setEjercicio(detalleconsignacionDataAccess.getEjercicio(connexion,detalleconsignacion));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(detalleconsignacion.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detalleconsignacion.setPeriodo(detalleconsignacionDataAccess.getPeriodo(connexion,detalleconsignacion));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(detalleconsignacion.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detalleconsignacion.setAnio(detalleconsignacionDataAccess.getAnio(connexion,detalleconsignacion));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(detalleconsignacion.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detalleconsignacion.setMes(detalleconsignacionDataAccess.getMes(connexion,detalleconsignacion));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(detalleconsignacion.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Consignacion.class)) {
				detalleconsignacion.setConsignacion(detalleconsignacionDataAccess.getConsignacion(connexion,detalleconsignacion));
				ConsignacionLogic consignacionLogic= new ConsignacionLogic(connexion);
				consignacionLogic.deepLoad(detalleconsignacion.getConsignacion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				detalleconsignacion.setProducto(detalleconsignacionDataAccess.getProducto(connexion,detalleconsignacion));
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepLoad(detalleconsignacion.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				detalleconsignacion.setBodega(detalleconsignacionDataAccess.getBodega(connexion,detalleconsignacion));
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepLoad(detalleconsignacion.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				detalleconsignacion.setUnidad(detalleconsignacionDataAccess.getUnidad(connexion,detalleconsignacion));
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepLoad(detalleconsignacion.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoDetallePedido.class)) {
				detalleconsignacion.setEstadoDetallePedido(detalleconsignacionDataAccess.getEstadoDetallePedido(connexion,detalleconsignacion));
				EstadoDetallePedidoLogic estadodetallepedidoLogic= new EstadoDetallePedidoLogic(connexion);
				estadodetallepedidoLogic.deepLoad(detalleconsignacion.getEstadoDetallePedido(),isDeep,deepLoadType,clases);				
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
			detalleconsignacion.setEmpresa(detalleconsignacionDataAccess.getEmpresa(connexion,detalleconsignacion));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detalleconsignacion.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleconsignacion.setSucursal(detalleconsignacionDataAccess.getSucursal(connexion,detalleconsignacion));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detalleconsignacion.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleconsignacion.setEjercicio(detalleconsignacionDataAccess.getEjercicio(connexion,detalleconsignacion));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(detalleconsignacion.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleconsignacion.setPeriodo(detalleconsignacionDataAccess.getPeriodo(connexion,detalleconsignacion));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(detalleconsignacion.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleconsignacion.setAnio(detalleconsignacionDataAccess.getAnio(connexion,detalleconsignacion));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(detalleconsignacion.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleconsignacion.setMes(detalleconsignacionDataAccess.getMes(connexion,detalleconsignacion));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(detalleconsignacion.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Consignacion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleconsignacion.setConsignacion(detalleconsignacionDataAccess.getConsignacion(connexion,detalleconsignacion));
			ConsignacionLogic consignacionLogic= new ConsignacionLogic(connexion);
			consignacionLogic.deepLoad(detalleconsignacion.getConsignacion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Producto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleconsignacion.setProducto(detalleconsignacionDataAccess.getProducto(connexion,detalleconsignacion));
			ProductoLogic productoLogic= new ProductoLogic(connexion);
			productoLogic.deepLoad(detalleconsignacion.getProducto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Bodega.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleconsignacion.setBodega(detalleconsignacionDataAccess.getBodega(connexion,detalleconsignacion));
			BodegaLogic bodegaLogic= new BodegaLogic(connexion);
			bodegaLogic.deepLoad(detalleconsignacion.getBodega(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Unidad.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleconsignacion.setUnidad(detalleconsignacionDataAccess.getUnidad(connexion,detalleconsignacion));
			UnidadLogic unidadLogic= new UnidadLogic(connexion);
			unidadLogic.deepLoad(detalleconsignacion.getUnidad(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoDetallePedido.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detalleconsignacion.setEstadoDetallePedido(detalleconsignacionDataAccess.getEstadoDetallePedido(connexion,detalleconsignacion));
			EstadoDetallePedidoLogic estadodetallepedidoLogic= new EstadoDetallePedidoLogic(connexion);
			estadodetallepedidoLogic.deepLoad(detalleconsignacion.getEstadoDetallePedido(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetalleConsignacion detalleconsignacion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetalleConsignacionLogicAdditional.updateDetalleConsignacionToSave(detalleconsignacion,this.arrDatoGeneral);
			
DetalleConsignacionDataAccess.save(detalleconsignacion, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detalleconsignacion.getEmpresa(),connexion);

		SucursalDataAccess.save(detalleconsignacion.getSucursal(),connexion);

		EjercicioDataAccess.save(detalleconsignacion.getEjercicio(),connexion);

		PeriodoDataAccess.save(detalleconsignacion.getPeriodo(),connexion);

		AnioDataAccess.save(detalleconsignacion.getAnio(),connexion);

		MesDataAccess.save(detalleconsignacion.getMes(),connexion);

		ConsignacionDataAccess.save(detalleconsignacion.getConsignacion(),connexion);

		ProductoDataAccess.save(detalleconsignacion.getProducto(),connexion);

		BodegaDataAccess.save(detalleconsignacion.getBodega(),connexion);

		UnidadDataAccess.save(detalleconsignacion.getUnidad(),connexion);

		EstadoDetallePedidoDataAccess.save(detalleconsignacion.getEstadoDetallePedido(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalleconsignacion.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detalleconsignacion.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detalleconsignacion.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detalleconsignacion.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detalleconsignacion.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detalleconsignacion.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(Consignacion.class)) {
				ConsignacionDataAccess.save(detalleconsignacion.getConsignacion(),connexion);
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detalleconsignacion.getProducto(),connexion);
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detalleconsignacion.getBodega(),connexion);
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detalleconsignacion.getUnidad(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoDetallePedido.class)) {
				EstadoDetallePedidoDataAccess.save(detalleconsignacion.getEstadoDetallePedido(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detalleconsignacion.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detalleconsignacion.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detalleconsignacion.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detalleconsignacion.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(detalleconsignacion.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detalleconsignacion.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(detalleconsignacion.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detalleconsignacion.getPeriodo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(detalleconsignacion.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detalleconsignacion.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(detalleconsignacion.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detalleconsignacion.getMes(),isDeep,deepLoadType,clases);
				

		ConsignacionDataAccess.save(detalleconsignacion.getConsignacion(),connexion);
		ConsignacionLogic consignacionLogic= new ConsignacionLogic(connexion);
		consignacionLogic.deepLoad(detalleconsignacion.getConsignacion(),isDeep,deepLoadType,clases);
				

		ProductoDataAccess.save(detalleconsignacion.getProducto(),connexion);
		ProductoLogic productoLogic= new ProductoLogic(connexion);
		productoLogic.deepLoad(detalleconsignacion.getProducto(),isDeep,deepLoadType,clases);
				

		BodegaDataAccess.save(detalleconsignacion.getBodega(),connexion);
		BodegaLogic bodegaLogic= new BodegaLogic(connexion);
		bodegaLogic.deepLoad(detalleconsignacion.getBodega(),isDeep,deepLoadType,clases);
				

		UnidadDataAccess.save(detalleconsignacion.getUnidad(),connexion);
		UnidadLogic unidadLogic= new UnidadLogic(connexion);
		unidadLogic.deepLoad(detalleconsignacion.getUnidad(),isDeep,deepLoadType,clases);
				

		EstadoDetallePedidoDataAccess.save(detalleconsignacion.getEstadoDetallePedido(),connexion);
		EstadoDetallePedidoLogic estadodetallepedidoLogic= new EstadoDetallePedidoLogic(connexion);
		estadodetallepedidoLogic.deepLoad(detalleconsignacion.getEstadoDetallePedido(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detalleconsignacion.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detalleconsignacion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detalleconsignacion.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detalleconsignacion.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detalleconsignacion.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(detalleconsignacion.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detalleconsignacion.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(detalleconsignacion.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detalleconsignacion.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(detalleconsignacion.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detalleconsignacion.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(detalleconsignacion.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Consignacion.class)) {
				ConsignacionDataAccess.save(detalleconsignacion.getConsignacion(),connexion);
				ConsignacionLogic consignacionLogic= new ConsignacionLogic(connexion);
				consignacionLogic.deepSave(detalleconsignacion.getConsignacion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Producto.class)) {
				ProductoDataAccess.save(detalleconsignacion.getProducto(),connexion);
				ProductoLogic productoLogic= new ProductoLogic(connexion);
				productoLogic.deepSave(detalleconsignacion.getProducto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Bodega.class)) {
				BodegaDataAccess.save(detalleconsignacion.getBodega(),connexion);
				BodegaLogic bodegaLogic= new BodegaLogic(connexion);
				bodegaLogic.deepSave(detalleconsignacion.getBodega(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Unidad.class)) {
				UnidadDataAccess.save(detalleconsignacion.getUnidad(),connexion);
				UnidadLogic unidadLogic= new UnidadLogic(connexion);
				unidadLogic.deepSave(detalleconsignacion.getUnidad(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoDetallePedido.class)) {
				EstadoDetallePedidoDataAccess.save(detalleconsignacion.getEstadoDetallePedido(),connexion);
				EstadoDetallePedidoLogic estadodetallepedidoLogic= new EstadoDetallePedidoLogic(connexion);
				estadodetallepedidoLogic.deepSave(detalleconsignacion.getEstadoDetallePedido(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(DetalleConsignacion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detalleconsignacion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(detalleconsignacion);
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
			this.deepLoad(this.detalleconsignacion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(this.detalleconsignacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetalleConsignacion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detalleconsignacions!=null) {
				for(DetalleConsignacion detalleconsignacion:detalleconsignacions) {
					this.deepLoad(detalleconsignacion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(detalleconsignacions);
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
			if(detalleconsignacions!=null) {
				for(DetalleConsignacion detalleconsignacion:detalleconsignacions) {
					this.deepLoad(detalleconsignacion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(detalleconsignacions);
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
			this.getNewConnexionToDeep(DetalleConsignacion.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detalleconsignacion,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetalleConsignacion.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detalleconsignacions!=null) {
				for(DetalleConsignacion detalleconsignacion:detalleconsignacions) {
					this.deepSave(detalleconsignacion,isDeep,deepLoadType,clases);
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
			if(detalleconsignacions!=null) {
				for(DetalleConsignacion detalleconsignacion:detalleconsignacions) {
					this.deepSave(detalleconsignacion,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetalleConsignacionsFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleConsignacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetalleConsignacionConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetalleConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleconsignacions=detalleconsignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(this.detalleconsignacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleConsignacionsFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetalleConsignacionConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetalleConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleconsignacions=detalleconsignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(this.detalleconsignacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleConsignacionsFK_IdBodegaWithConnection(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleConsignacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetalleConsignacionConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetalleConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleconsignacions=detalleconsignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(this.detalleconsignacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleConsignacionsFK_IdBodega(String sFinalQuery,Pagination pagination,Long id_bodega)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBodega= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBodega.setParameterSelectionGeneralEqual(ParameterType.LONG,id_bodega,DetalleConsignacionConstantesFunciones.IDBODEGA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBodega);

			DetalleConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBodega","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleconsignacions=detalleconsignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(this.detalleconsignacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleConsignacionsFK_IdConsignacionWithConnection(String sFinalQuery,Pagination pagination,Long id_consignacion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleConsignacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidConsignacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidConsignacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_consignacion,DetalleConsignacionConstantesFunciones.IDCONSIGNACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidConsignacion);

			DetalleConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdConsignacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleconsignacions=detalleconsignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(this.detalleconsignacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleConsignacionsFK_IdConsignacion(String sFinalQuery,Pagination pagination,Long id_consignacion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidConsignacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidConsignacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_consignacion,DetalleConsignacionConstantesFunciones.IDCONSIGNACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidConsignacion);

			DetalleConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdConsignacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleconsignacions=detalleconsignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(this.detalleconsignacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleConsignacionsFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleConsignacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleConsignacionConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleconsignacions=detalleconsignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(this.detalleconsignacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleConsignacionsFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetalleConsignacionConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetalleConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleconsignacions=detalleconsignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(this.detalleconsignacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleConsignacionsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleConsignacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleConsignacionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleconsignacions=detalleconsignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(this.detalleconsignacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleConsignacionsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetalleConsignacionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetalleConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleconsignacions=detalleconsignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(this.detalleconsignacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleConsignacionsFK_IdEstadoDetallePedidoWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_detalle_pedido)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleConsignacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoDetallePedido= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoDetallePedido.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_detalle_pedido,DetalleConsignacionConstantesFunciones.IDESTADODETALLEPEDIDO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoDetallePedido);

			DetalleConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoDetallePedido","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleconsignacions=detalleconsignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(this.detalleconsignacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleConsignacionsFK_IdEstadoDetallePedido(String sFinalQuery,Pagination pagination,Long id_estado_detalle_pedido)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoDetallePedido= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoDetallePedido.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_detalle_pedido,DetalleConsignacionConstantesFunciones.IDESTADODETALLEPEDIDO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoDetallePedido);

			DetalleConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoDetallePedido","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleconsignacions=detalleconsignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(this.detalleconsignacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleConsignacionsFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleConsignacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetalleConsignacionConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetalleConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleconsignacions=detalleconsignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(this.detalleconsignacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleConsignacionsFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetalleConsignacionConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetalleConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleconsignacions=detalleconsignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(this.detalleconsignacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleConsignacionsFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleConsignacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetalleConsignacionConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetalleConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleconsignacions=detalleconsignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(this.detalleconsignacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleConsignacionsFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetalleConsignacionConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetalleConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleconsignacions=detalleconsignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(this.detalleconsignacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleConsignacionsFK_IdProductoWithConnection(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleConsignacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetalleConsignacionConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetalleConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleconsignacions=detalleconsignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(this.detalleconsignacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleConsignacionsFK_IdProducto(String sFinalQuery,Pagination pagination,Long id_producto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidProducto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidProducto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_producto,DetalleConsignacionConstantesFunciones.IDPRODUCTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidProducto);

			DetalleConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdProducto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleconsignacions=detalleconsignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(this.detalleconsignacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleConsignacionsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleConsignacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleConsignacionConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleconsignacions=detalleconsignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(this.detalleconsignacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleConsignacionsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetalleConsignacionConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetalleConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleconsignacions=detalleconsignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(this.detalleconsignacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetalleConsignacionsFK_IdUnidadWithConnection(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetalleConsignacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetalleConsignacionConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetalleConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleconsignacions=detalleconsignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(this.detalleconsignacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetalleConsignacionsFK_IdUnidad(String sFinalQuery,Pagination pagination,Long id_unidad)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUnidad= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUnidad.setParameterSelectionGeneralEqual(ParameterType.LONG,id_unidad,DetalleConsignacionConstantesFunciones.IDUNIDAD,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUnidad);

			DetalleConsignacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUnidad","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detalleconsignacions=detalleconsignacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetalleConsignacionConstantesFunciones.refrescarForeignKeysDescripcionesDetalleConsignacion(this.detalleconsignacions);
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
			if(DetalleConsignacionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleConsignacionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetalleConsignacion detalleconsignacion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetalleConsignacionConstantesFunciones.ISCONAUDITORIA) {
				if(detalleconsignacion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleConsignacionDataAccess.TABLENAME, detalleconsignacion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleConsignacionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleConsignacionLogic.registrarAuditoriaDetallesDetalleConsignacion(connexion,detalleconsignacion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detalleconsignacion.getIsDeleted()) {
					/*if(!detalleconsignacion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetalleConsignacionDataAccess.TABLENAME, detalleconsignacion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetalleConsignacionLogic.registrarAuditoriaDetallesDetalleConsignacion(connexion,detalleconsignacion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleConsignacionDataAccess.TABLENAME, detalleconsignacion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detalleconsignacion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetalleConsignacionDataAccess.TABLENAME, detalleconsignacion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetalleConsignacionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetalleConsignacionLogic.registrarAuditoriaDetallesDetalleConsignacion(connexion,detalleconsignacion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetalleConsignacion(Connexion connexion,DetalleConsignacion detalleconsignacion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detalleconsignacion.getIsNew()||!detalleconsignacion.getid_empresa().equals(detalleconsignacion.getDetalleConsignacionOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleconsignacion.getDetalleConsignacionOriginal().getid_empresa()!=null)
				{
					strValorActual=detalleconsignacion.getDetalleConsignacionOriginal().getid_empresa().toString();
				}
				if(detalleconsignacion.getid_empresa()!=null)
				{
					strValorNuevo=detalleconsignacion.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleConsignacionConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detalleconsignacion.getIsNew()||!detalleconsignacion.getid_sucursal().equals(detalleconsignacion.getDetalleConsignacionOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleconsignacion.getDetalleConsignacionOriginal().getid_sucursal()!=null)
				{
					strValorActual=detalleconsignacion.getDetalleConsignacionOriginal().getid_sucursal().toString();
				}
				if(detalleconsignacion.getid_sucursal()!=null)
				{
					strValorNuevo=detalleconsignacion.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleConsignacionConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(detalleconsignacion.getIsNew()||!detalleconsignacion.getid_ejercicio().equals(detalleconsignacion.getDetalleConsignacionOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleconsignacion.getDetalleConsignacionOriginal().getid_ejercicio()!=null)
				{
					strValorActual=detalleconsignacion.getDetalleConsignacionOriginal().getid_ejercicio().toString();
				}
				if(detalleconsignacion.getid_ejercicio()!=null)
				{
					strValorNuevo=detalleconsignacion.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleConsignacionConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(detalleconsignacion.getIsNew()||!detalleconsignacion.getid_periodo().equals(detalleconsignacion.getDetalleConsignacionOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleconsignacion.getDetalleConsignacionOriginal().getid_periodo()!=null)
				{
					strValorActual=detalleconsignacion.getDetalleConsignacionOriginal().getid_periodo().toString();
				}
				if(detalleconsignacion.getid_periodo()!=null)
				{
					strValorNuevo=detalleconsignacion.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleConsignacionConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(detalleconsignacion.getIsNew()||!detalleconsignacion.getid_anio().equals(detalleconsignacion.getDetalleConsignacionOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleconsignacion.getDetalleConsignacionOriginal().getid_anio()!=null)
				{
					strValorActual=detalleconsignacion.getDetalleConsignacionOriginal().getid_anio().toString();
				}
				if(detalleconsignacion.getid_anio()!=null)
				{
					strValorNuevo=detalleconsignacion.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleConsignacionConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(detalleconsignacion.getIsNew()||!detalleconsignacion.getid_mes().equals(detalleconsignacion.getDetalleConsignacionOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleconsignacion.getDetalleConsignacionOriginal().getid_mes()!=null)
				{
					strValorActual=detalleconsignacion.getDetalleConsignacionOriginal().getid_mes().toString();
				}
				if(detalleconsignacion.getid_mes()!=null)
				{
					strValorNuevo=detalleconsignacion.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleConsignacionConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(detalleconsignacion.getIsNew()||!detalleconsignacion.getid_consignacion().equals(detalleconsignacion.getDetalleConsignacionOriginal().getid_consignacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleconsignacion.getDetalleConsignacionOriginal().getid_consignacion()!=null)
				{
					strValorActual=detalleconsignacion.getDetalleConsignacionOriginal().getid_consignacion().toString();
				}
				if(detalleconsignacion.getid_consignacion()!=null)
				{
					strValorNuevo=detalleconsignacion.getid_consignacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleConsignacionConstantesFunciones.IDCONSIGNACION,strValorActual,strValorNuevo);
			}	
			
			if(detalleconsignacion.getIsNew()||!detalleconsignacion.getid_producto().equals(detalleconsignacion.getDetalleConsignacionOriginal().getid_producto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleconsignacion.getDetalleConsignacionOriginal().getid_producto()!=null)
				{
					strValorActual=detalleconsignacion.getDetalleConsignacionOriginal().getid_producto().toString();
				}
				if(detalleconsignacion.getid_producto()!=null)
				{
					strValorNuevo=detalleconsignacion.getid_producto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleConsignacionConstantesFunciones.IDPRODUCTO,strValorActual,strValorNuevo);
			}	
			
			if(detalleconsignacion.getIsNew()||!detalleconsignacion.getid_bodega().equals(detalleconsignacion.getDetalleConsignacionOriginal().getid_bodega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleconsignacion.getDetalleConsignacionOriginal().getid_bodega()!=null)
				{
					strValorActual=detalleconsignacion.getDetalleConsignacionOriginal().getid_bodega().toString();
				}
				if(detalleconsignacion.getid_bodega()!=null)
				{
					strValorNuevo=detalleconsignacion.getid_bodega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleConsignacionConstantesFunciones.IDBODEGA,strValorActual,strValorNuevo);
			}	
			
			if(detalleconsignacion.getIsNew()||!detalleconsignacion.getid_unidad().equals(detalleconsignacion.getDetalleConsignacionOriginal().getid_unidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleconsignacion.getDetalleConsignacionOriginal().getid_unidad()!=null)
				{
					strValorActual=detalleconsignacion.getDetalleConsignacionOriginal().getid_unidad().toString();
				}
				if(detalleconsignacion.getid_unidad()!=null)
				{
					strValorNuevo=detalleconsignacion.getid_unidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleConsignacionConstantesFunciones.IDUNIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detalleconsignacion.getIsNew()||!detalleconsignacion.getid_estado_detalle_pedido().equals(detalleconsignacion.getDetalleConsignacionOriginal().getid_estado_detalle_pedido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleconsignacion.getDetalleConsignacionOriginal().getid_estado_detalle_pedido()!=null)
				{
					strValorActual=detalleconsignacion.getDetalleConsignacionOriginal().getid_estado_detalle_pedido().toString();
				}
				if(detalleconsignacion.getid_estado_detalle_pedido()!=null)
				{
					strValorNuevo=detalleconsignacion.getid_estado_detalle_pedido().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleConsignacionConstantesFunciones.IDESTADODETALLEPEDIDO,strValorActual,strValorNuevo);
			}	
			
			if(detalleconsignacion.getIsNew()||!detalleconsignacion.getcantidad().equals(detalleconsignacion.getDetalleConsignacionOriginal().getcantidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleconsignacion.getDetalleConsignacionOriginal().getcantidad()!=null)
				{
					strValorActual=detalleconsignacion.getDetalleConsignacionOriginal().getcantidad().toString();
				}
				if(detalleconsignacion.getcantidad()!=null)
				{
					strValorNuevo=detalleconsignacion.getcantidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleConsignacionConstantesFunciones.CANTIDAD,strValorActual,strValorNuevo);
			}	
			
			if(detalleconsignacion.getIsNew()||!detalleconsignacion.getprecio().equals(detalleconsignacion.getDetalleConsignacionOriginal().getprecio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleconsignacion.getDetalleConsignacionOriginal().getprecio()!=null)
				{
					strValorActual=detalleconsignacion.getDetalleConsignacionOriginal().getprecio().toString();
				}
				if(detalleconsignacion.getprecio()!=null)
				{
					strValorNuevo=detalleconsignacion.getprecio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleConsignacionConstantesFunciones.PRECIO,strValorActual,strValorNuevo);
			}	
			
			if(detalleconsignacion.getIsNew()||!detalleconsignacion.getdescuento_porcentaje().equals(detalleconsignacion.getDetalleConsignacionOriginal().getdescuento_porcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleconsignacion.getDetalleConsignacionOriginal().getdescuento_porcentaje()!=null)
				{
					strValorActual=detalleconsignacion.getDetalleConsignacionOriginal().getdescuento_porcentaje().toString();
				}
				if(detalleconsignacion.getdescuento_porcentaje()!=null)
				{
					strValorNuevo=detalleconsignacion.getdescuento_porcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleConsignacionConstantesFunciones.DESCUENTOPORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(detalleconsignacion.getIsNew()||!detalleconsignacion.getdescuento_valor().equals(detalleconsignacion.getDetalleConsignacionOriginal().getdescuento_valor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleconsignacion.getDetalleConsignacionOriginal().getdescuento_valor()!=null)
				{
					strValorActual=detalleconsignacion.getDetalleConsignacionOriginal().getdescuento_valor().toString();
				}
				if(detalleconsignacion.getdescuento_valor()!=null)
				{
					strValorNuevo=detalleconsignacion.getdescuento_valor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleConsignacionConstantesFunciones.DESCUENTOVALOR,strValorActual,strValorNuevo);
			}	
			
			if(detalleconsignacion.getIsNew()||!detalleconsignacion.getiva().equals(detalleconsignacion.getDetalleConsignacionOriginal().getiva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleconsignacion.getDetalleConsignacionOriginal().getiva()!=null)
				{
					strValorActual=detalleconsignacion.getDetalleConsignacionOriginal().getiva().toString();
				}
				if(detalleconsignacion.getiva()!=null)
				{
					strValorNuevo=detalleconsignacion.getiva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleConsignacionConstantesFunciones.IVA,strValorActual,strValorNuevo);
			}	
			
			if(detalleconsignacion.getIsNew()||!detalleconsignacion.gettotal().equals(detalleconsignacion.getDetalleConsignacionOriginal().gettotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleconsignacion.getDetalleConsignacionOriginal().gettotal()!=null)
				{
					strValorActual=detalleconsignacion.getDetalleConsignacionOriginal().gettotal().toString();
				}
				if(detalleconsignacion.gettotal()!=null)
				{
					strValorNuevo=detalleconsignacion.gettotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleConsignacionConstantesFunciones.TOTAL,strValorActual,strValorNuevo);
			}	
			
			if(detalleconsignacion.getIsNew()||!detalleconsignacion.getice().equals(detalleconsignacion.getDetalleConsignacionOriginal().getice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleconsignacion.getDetalleConsignacionOriginal().getice()!=null)
				{
					strValorActual=detalleconsignacion.getDetalleConsignacionOriginal().getice().toString();
				}
				if(detalleconsignacion.getice()!=null)
				{
					strValorNuevo=detalleconsignacion.getice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleConsignacionConstantesFunciones.ICE,strValorActual,strValorNuevo);
			}	
			
			if(detalleconsignacion.getIsNew()||!detalleconsignacion.getcosto().equals(detalleconsignacion.getDetalleConsignacionOriginal().getcosto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleconsignacion.getDetalleConsignacionOriginal().getcosto()!=null)
				{
					strValorActual=detalleconsignacion.getDetalleConsignacionOriginal().getcosto().toString();
				}
				if(detalleconsignacion.getcosto()!=null)
				{
					strValorNuevo=detalleconsignacion.getcosto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleConsignacionConstantesFunciones.COSTO,strValorActual,strValorNuevo);
			}	
			
			if(detalleconsignacion.getIsNew()||!detalleconsignacion.getutilidad().equals(detalleconsignacion.getDetalleConsignacionOriginal().getutilidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detalleconsignacion.getDetalleConsignacionOriginal().getutilidad()!=null)
				{
					strValorActual=detalleconsignacion.getDetalleConsignacionOriginal().getutilidad().toString();
				}
				if(detalleconsignacion.getutilidad()!=null)
				{
					strValorNuevo=detalleconsignacion.getutilidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetalleConsignacionConstantesFunciones.UTILIDAD,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetalleConsignacionRelacionesWithConnection(DetalleConsignacion detalleconsignacion) throws Exception {

		if(!detalleconsignacion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleConsignacionRelacionesBase(detalleconsignacion,true);
		}
	}

	public void saveDetalleConsignacionRelaciones(DetalleConsignacion detalleconsignacion)throws Exception {

		if(!detalleconsignacion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetalleConsignacionRelacionesBase(detalleconsignacion,false);
		}
	}

	public void saveDetalleConsignacionRelacionesBase(DetalleConsignacion detalleconsignacion,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetalleConsignacion-saveRelacionesWithConnection");}
	

			this.setDetalleConsignacion(detalleconsignacion);

			if(DetalleConsignacionLogicAdditional.validarSaveRelaciones(detalleconsignacion,this)) {

				DetalleConsignacionLogicAdditional.updateRelacionesToSave(detalleconsignacion,this);

				if((detalleconsignacion.getIsNew()||detalleconsignacion.getIsChanged())&&!detalleconsignacion.getIsDeleted()) {
					this.saveDetalleConsignacion();
					this.saveDetalleConsignacionRelacionesDetalles();

				} else if(detalleconsignacion.getIsDeleted()) {
					this.saveDetalleConsignacionRelacionesDetalles();
					this.saveDetalleConsignacion();
				}

				DetalleConsignacionLogicAdditional.updateRelacionesToSaveAfter(detalleconsignacion,this);

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
	
	
	private void saveDetalleConsignacionRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleConsignacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleConsignacionConstantesFunciones.getClassesForeignKeysOfDetalleConsignacion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleConsignacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetalleConsignacionConstantesFunciones.getClassesRelationshipsOfDetalleConsignacion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

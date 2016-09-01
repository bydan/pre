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
package com.bydan.erp.contabilidad.business.logic;

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
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.contabilidad.util.FacturaProveedorServicioConstantesFunciones;
import com.bydan.erp.contabilidad.util.FacturaProveedorServicioParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.FacturaProveedorServicioParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.FacturaProveedorServicio;
import com.bydan.erp.contabilidad.business.logic.FacturaProveedorServicioLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;








@SuppressWarnings("unused")
public class FacturaProveedorServicioLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(FacturaProveedorServicioLogic.class);
	
	protected FacturaProveedorServicioDataAccess facturaproveedorservicioDataAccess; 	
	protected FacturaProveedorServicio facturaproveedorservicio;
	protected List<FacturaProveedorServicio> facturaproveedorservicios;
	protected Object facturaproveedorservicioObject;	
	protected List<Object> facturaproveedorserviciosObject;
	
	public static ClassValidator<FacturaProveedorServicio> facturaproveedorservicioValidator = new ClassValidator<FacturaProveedorServicio>(FacturaProveedorServicio.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected FacturaProveedorServicioLogicAdditional facturaproveedorservicioLogicAdditional=null;
	
	public FacturaProveedorServicioLogicAdditional getFacturaProveedorServicioLogicAdditional() {
		return this.facturaproveedorservicioLogicAdditional;
	}
	
	public void setFacturaProveedorServicioLogicAdditional(FacturaProveedorServicioLogicAdditional facturaproveedorservicioLogicAdditional) {
		try {
			this.facturaproveedorservicioLogicAdditional=facturaproveedorservicioLogicAdditional;
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
	
	
	
	
	public  FacturaProveedorServicioLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.facturaproveedorservicioDataAccess = new FacturaProveedorServicioDataAccess();
			
			this.facturaproveedorservicios= new ArrayList<FacturaProveedorServicio>();
			this.facturaproveedorservicio= new FacturaProveedorServicio();
			
			this.facturaproveedorservicioObject=new Object();
			this.facturaproveedorserviciosObject=new ArrayList<Object>();
				
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
			
			this.facturaproveedorservicioDataAccess.setConnexionType(this.connexionType);
			this.facturaproveedorservicioDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  FacturaProveedorServicioLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.facturaproveedorservicioDataAccess = new FacturaProveedorServicioDataAccess();
			this.facturaproveedorservicios= new ArrayList<FacturaProveedorServicio>();
			this.facturaproveedorservicio= new FacturaProveedorServicio();
			this.facturaproveedorservicioObject=new Object();
			this.facturaproveedorserviciosObject=new ArrayList<Object>();
			
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
			
			this.facturaproveedorservicioDataAccess.setConnexionType(this.connexionType);
			this.facturaproveedorservicioDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public FacturaProveedorServicio getFacturaProveedorServicio() throws Exception {	
		FacturaProveedorServicioLogicAdditional.checkFacturaProveedorServicioToGet(facturaproveedorservicio,this.datosCliente,this.arrDatoGeneral);
		FacturaProveedorServicioLogicAdditional.updateFacturaProveedorServicioToGet(facturaproveedorservicio,this.arrDatoGeneral);
		
		return facturaproveedorservicio;
	}
		
	public void setFacturaProveedorServicio(FacturaProveedorServicio newFacturaProveedorServicio) {
		this.facturaproveedorservicio = newFacturaProveedorServicio;
	}
	
	public FacturaProveedorServicioDataAccess getFacturaProveedorServicioDataAccess() {
		return facturaproveedorservicioDataAccess;
	}
	
	public void setFacturaProveedorServicioDataAccess(FacturaProveedorServicioDataAccess newfacturaproveedorservicioDataAccess) {
		this.facturaproveedorservicioDataAccess = newfacturaproveedorservicioDataAccess;
	}
	
	public List<FacturaProveedorServicio> getFacturaProveedorServicios() throws Exception {		
		this.quitarFacturaProveedorServiciosNulos();
		
		FacturaProveedorServicioLogicAdditional.checkFacturaProveedorServicioToGets(facturaproveedorservicios,this.datosCliente,this.arrDatoGeneral);
		
		for (FacturaProveedorServicio facturaproveedorservicioLocal: facturaproveedorservicios ) {
			FacturaProveedorServicioLogicAdditional.updateFacturaProveedorServicioToGet(facturaproveedorservicioLocal,this.arrDatoGeneral);
		}
		
		return facturaproveedorservicios;
	}
	
	public void setFacturaProveedorServicios(List<FacturaProveedorServicio> newFacturaProveedorServicios) {
		this.facturaproveedorservicios = newFacturaProveedorServicios;
	}
	
	public Object getFacturaProveedorServicioObject() {	
		this.facturaproveedorservicioObject=this.facturaproveedorservicioDataAccess.getEntityObject();
		return this.facturaproveedorservicioObject;
	}
		
	public void setFacturaProveedorServicioObject(Object newFacturaProveedorServicioObject) {
		this.facturaproveedorservicioObject = newFacturaProveedorServicioObject;
	}
	
	public List<Object> getFacturaProveedorServiciosObject() {		
		this.facturaproveedorserviciosObject=this.facturaproveedorservicioDataAccess.getEntitiesObject();
		return this.facturaproveedorserviciosObject;
	}
		
	public void setFacturaProveedorServiciosObject(List<Object> newFacturaProveedorServiciosObject) {
		this.facturaproveedorserviciosObject = newFacturaProveedorServiciosObject;
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
		
		if(this.facturaproveedorservicioDataAccess!=null) {
			this.facturaproveedorservicioDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedorServicio.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			facturaproveedorservicioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			facturaproveedorservicioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		facturaproveedorservicio = new  FacturaProveedorServicio();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedorServicio.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			facturaproveedorservicio=facturaproveedorservicioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.facturaproveedorservicio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicio);
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
		facturaproveedorservicio = new  FacturaProveedorServicio();
		  		  
        try {
			
			facturaproveedorservicio=facturaproveedorservicioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.facturaproveedorservicio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		facturaproveedorservicio = new  FacturaProveedorServicio();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedorServicio.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			facturaproveedorservicio=facturaproveedorservicioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.facturaproveedorservicio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicio);
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
		facturaproveedorservicio = new  FacturaProveedorServicio();
		  		  
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
		facturaproveedorservicio = new  FacturaProveedorServicio();
		  		  
        try {
			
			facturaproveedorservicio=facturaproveedorservicioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.facturaproveedorservicio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		facturaproveedorservicio = new  FacturaProveedorServicio();
		  		  
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
		facturaproveedorservicio = new  FacturaProveedorServicio();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedorServicio.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =facturaproveedorservicioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		facturaproveedorservicio = new  FacturaProveedorServicio();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=facturaproveedorservicioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		facturaproveedorservicio = new  FacturaProveedorServicio();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedorServicio.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =facturaproveedorservicioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		facturaproveedorservicio = new  FacturaProveedorServicio();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=facturaproveedorservicioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		facturaproveedorservicio = new  FacturaProveedorServicio();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedorServicio.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =facturaproveedorservicioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		facturaproveedorservicio = new  FacturaProveedorServicio();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=facturaproveedorservicioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		facturaproveedorservicios = new  ArrayList<FacturaProveedorServicio>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedorServicio.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFacturaProveedorServicio(facturaproveedorservicios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
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
		facturaproveedorservicios = new  ArrayList<FacturaProveedorServicio>();
		  		  
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
		facturaproveedorservicios = new  ArrayList<FacturaProveedorServicio>();
		  		  
        try {			
			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarFacturaProveedorServicio(facturaproveedorservicios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		facturaproveedorservicios = new  ArrayList<FacturaProveedorServicio>();
		  		  
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
		facturaproveedorservicios = new  ArrayList<FacturaProveedorServicio>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedorServicio.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFacturaProveedorServicio(facturaproveedorservicios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
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
		facturaproveedorservicios = new  ArrayList<FacturaProveedorServicio>();
		  		  
        try {
			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFacturaProveedorServicio(facturaproveedorservicios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
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
		facturaproveedorservicios = new  ArrayList<FacturaProveedorServicio>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedorServicio.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFacturaProveedorServicio(facturaproveedorservicios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
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
		facturaproveedorservicios = new  ArrayList<FacturaProveedorServicio>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFacturaProveedorServicio(facturaproveedorservicios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		facturaproveedorservicio = new  FacturaProveedorServicio();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedorServicio.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaproveedorservicio=facturaproveedorservicioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFacturaProveedorServicio(facturaproveedorservicio);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicio);
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
		facturaproveedorservicio = new  FacturaProveedorServicio();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaproveedorservicio=facturaproveedorservicioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFacturaProveedorServicio(facturaproveedorservicio);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		facturaproveedorservicios = new  ArrayList<FacturaProveedorServicio>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedorServicio.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFacturaProveedorServicio(facturaproveedorservicios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
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
		facturaproveedorservicios = new  ArrayList<FacturaProveedorServicio>();
		  		  
        try {
			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFacturaProveedorServicio(facturaproveedorservicios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosFacturaProveedorServiciosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		facturaproveedorservicios = new  ArrayList<FacturaProveedorServicio>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedorServicio.class.getSimpleName()+"-getTodosFacturaProveedorServiciosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFacturaProveedorServicio(facturaproveedorservicios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
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
	
	public  void  getTodosFacturaProveedorServicios(String sFinalQuery,Pagination pagination)throws Exception {
		facturaproveedorservicios = new  ArrayList<FacturaProveedorServicio>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFacturaProveedorServicio(facturaproveedorservicios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarFacturaProveedorServicio(FacturaProveedorServicio facturaproveedorservicio) throws Exception {
		Boolean estaValidado=false;
		
		if(facturaproveedorservicio.getIsNew() || facturaproveedorservicio.getIsChanged()) { 
			this.invalidValues = facturaproveedorservicioValidator.getInvalidValues(facturaproveedorservicio);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(facturaproveedorservicio);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarFacturaProveedorServicio(List<FacturaProveedorServicio> FacturaProveedorServicios) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(FacturaProveedorServicio facturaproveedorservicioLocal:facturaproveedorservicios) {				
			estaValidadoObjeto=this.validarGuardarFacturaProveedorServicio(facturaproveedorservicioLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarFacturaProveedorServicio(List<FacturaProveedorServicio> FacturaProveedorServicios) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFacturaProveedorServicio(facturaproveedorservicios)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarFacturaProveedorServicio(FacturaProveedorServicio FacturaProveedorServicio) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFacturaProveedorServicio(facturaproveedorservicio)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(FacturaProveedorServicio facturaproveedorservicio) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+facturaproveedorservicio.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=FacturaProveedorServicioConstantesFunciones.getFacturaProveedorServicioLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"facturaproveedorservicio","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(FacturaProveedorServicioConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(FacturaProveedorServicioConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveFacturaProveedorServicioWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedorServicio.class.getSimpleName()+"-saveFacturaProveedorServicioWithConnection");connexion.begin();			
			
			FacturaProveedorServicioLogicAdditional.checkFacturaProveedorServicioToSave(this.facturaproveedorservicio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FacturaProveedorServicioLogicAdditional.updateFacturaProveedorServicioToSave(this.facturaproveedorservicio,this.arrDatoGeneral);
			
			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.facturaproveedorservicio,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowFacturaProveedorServicio();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFacturaProveedorServicio(this.facturaproveedorservicio)) {
				FacturaProveedorServicioDataAccess.save(this.facturaproveedorservicio, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.facturaproveedorservicio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FacturaProveedorServicioLogicAdditional.checkFacturaProveedorServicioToSaveAfter(this.facturaproveedorservicio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFacturaProveedorServicio();
			
			connexion.commit();			
			
			if(this.facturaproveedorservicio.getIsDeleted()) {
				this.facturaproveedorservicio=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveFacturaProveedorServicio()throws Exception {	
		try {	
			
			FacturaProveedorServicioLogicAdditional.checkFacturaProveedorServicioToSave(this.facturaproveedorservicio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FacturaProveedorServicioLogicAdditional.updateFacturaProveedorServicioToSave(this.facturaproveedorservicio,this.arrDatoGeneral);
			
			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.facturaproveedorservicio,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFacturaProveedorServicio(this.facturaproveedorservicio)) {			
				FacturaProveedorServicioDataAccess.save(this.facturaproveedorservicio, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.facturaproveedorservicio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FacturaProveedorServicioLogicAdditional.checkFacturaProveedorServicioToSaveAfter(this.facturaproveedorservicio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.facturaproveedorservicio.getIsDeleted()) {
				this.facturaproveedorservicio=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveFacturaProveedorServiciosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedorServicio.class.getSimpleName()+"-saveFacturaProveedorServiciosWithConnection");connexion.begin();			
			
			FacturaProveedorServicioLogicAdditional.checkFacturaProveedorServicioToSaves(facturaproveedorservicios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowFacturaProveedorServicios();
			
			Boolean validadoTodosFacturaProveedorServicio=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(FacturaProveedorServicio facturaproveedorservicioLocal:facturaproveedorservicios) {		
				if(facturaproveedorservicioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FacturaProveedorServicioLogicAdditional.updateFacturaProveedorServicioToSave(facturaproveedorservicioLocal,this.arrDatoGeneral);
	        	
				FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),facturaproveedorservicioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFacturaProveedorServicio(facturaproveedorservicioLocal)) {
					FacturaProveedorServicioDataAccess.save(facturaproveedorservicioLocal, connexion);				
				} else {
					validadoTodosFacturaProveedorServicio=false;
				}
			}
			
			if(!validadoTodosFacturaProveedorServicio) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FacturaProveedorServicioLogicAdditional.checkFacturaProveedorServicioToSavesAfter(facturaproveedorservicios,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFacturaProveedorServicios();
			
			connexion.commit();		
			
			this.quitarFacturaProveedorServiciosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveFacturaProveedorServicios()throws Exception {				
		 try {	
			FacturaProveedorServicioLogicAdditional.checkFacturaProveedorServicioToSaves(facturaproveedorservicios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosFacturaProveedorServicio=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(FacturaProveedorServicio facturaproveedorservicioLocal:facturaproveedorservicios) {				
				if(facturaproveedorservicioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FacturaProveedorServicioLogicAdditional.updateFacturaProveedorServicioToSave(facturaproveedorservicioLocal,this.arrDatoGeneral);
	        	
				FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),facturaproveedorservicioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFacturaProveedorServicio(facturaproveedorservicioLocal)) {				
					FacturaProveedorServicioDataAccess.save(facturaproveedorservicioLocal, connexion);				
				} else {
					validadoTodosFacturaProveedorServicio=false;
				}
			}
			
			if(!validadoTodosFacturaProveedorServicio) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FacturaProveedorServicioLogicAdditional.checkFacturaProveedorServicioToSavesAfter(facturaproveedorservicios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarFacturaProveedorServiciosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FacturaProveedorServicioParameterReturnGeneral procesarAccionFacturaProveedorServicios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FacturaProveedorServicio> facturaproveedorservicios,FacturaProveedorServicioParameterReturnGeneral facturaproveedorservicioParameterGeneral)throws Exception {
		 try {	
			FacturaProveedorServicioParameterReturnGeneral facturaproveedorservicioReturnGeneral=new FacturaProveedorServicioParameterReturnGeneral();
	
			FacturaProveedorServicioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,facturaproveedorservicios,facturaproveedorservicioParameterGeneral,facturaproveedorservicioReturnGeneral);
			
			return facturaproveedorservicioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FacturaProveedorServicioParameterReturnGeneral procesarAccionFacturaProveedorServiciosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FacturaProveedorServicio> facturaproveedorservicios,FacturaProveedorServicioParameterReturnGeneral facturaproveedorservicioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedorServicio.class.getSimpleName()+"-procesarAccionFacturaProveedorServiciosWithConnection");connexion.begin();			
			
			FacturaProveedorServicioParameterReturnGeneral facturaproveedorservicioReturnGeneral=new FacturaProveedorServicioParameterReturnGeneral();
	
			FacturaProveedorServicioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,facturaproveedorservicios,facturaproveedorservicioParameterGeneral,facturaproveedorservicioReturnGeneral);
			
			this.connexion.commit();
			
			return facturaproveedorservicioReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FacturaProveedorServicioParameterReturnGeneral procesarEventosFacturaProveedorServicios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<FacturaProveedorServicio> facturaproveedorservicios,FacturaProveedorServicio facturaproveedorservicio,FacturaProveedorServicioParameterReturnGeneral facturaproveedorservicioParameterGeneral,Boolean isEsNuevoFacturaProveedorServicio,ArrayList<Classe> clases)throws Exception {
		 try {	
			FacturaProveedorServicioParameterReturnGeneral facturaproveedorservicioReturnGeneral=new FacturaProveedorServicioParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				facturaproveedorservicioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FacturaProveedorServicioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,facturaproveedorservicios,facturaproveedorservicio,facturaproveedorservicioParameterGeneral,facturaproveedorservicioReturnGeneral,isEsNuevoFacturaProveedorServicio,clases);
			
			return facturaproveedorservicioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public FacturaProveedorServicioParameterReturnGeneral procesarEventosFacturaProveedorServiciosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<FacturaProveedorServicio> facturaproveedorservicios,FacturaProveedorServicio facturaproveedorservicio,FacturaProveedorServicioParameterReturnGeneral facturaproveedorservicioParameterGeneral,Boolean isEsNuevoFacturaProveedorServicio,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedorServicio.class.getSimpleName()+"-procesarEventosFacturaProveedorServiciosWithConnection");connexion.begin();			
			
			FacturaProveedorServicioParameterReturnGeneral facturaproveedorservicioReturnGeneral=new FacturaProveedorServicioParameterReturnGeneral();
	
			facturaproveedorservicioReturnGeneral.setFacturaProveedorServicio(facturaproveedorservicio);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				facturaproveedorservicioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FacturaProveedorServicioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,facturaproveedorservicios,facturaproveedorservicio,facturaproveedorservicioParameterGeneral,facturaproveedorservicioReturnGeneral,isEsNuevoFacturaProveedorServicio,clases);
			
			this.connexion.commit();
			
			return facturaproveedorservicioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FacturaProveedorServicioParameterReturnGeneral procesarImportacionFacturaProveedorServiciosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,FacturaProveedorServicioParameterReturnGeneral facturaproveedorservicioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedorServicio.class.getSimpleName()+"-procesarImportacionFacturaProveedorServiciosWithConnection");connexion.begin();			
			
			FacturaProveedorServicioParameterReturnGeneral facturaproveedorservicioReturnGeneral=new FacturaProveedorServicioParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.facturaproveedorservicios=new ArrayList<FacturaProveedorServicio>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.facturaproveedorservicio=new FacturaProveedorServicio();
				
				
				if(conColumnasBase) {this.facturaproveedorservicio.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.facturaproveedorservicio.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.facturaproveedorservicio.setnumero_factura(arrColumnas[iColumn++]);
				this.facturaproveedorservicio.setruc(arrColumnas[iColumn++]);
				this.facturaproveedorservicio.setplazo(Integer.parseInt(arrColumnas[iColumn++]));
				this.facturaproveedorservicio.setcon_rise(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.facturaproveedorservicio.setfecha_emision(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.facturaproveedorservicio.setfecha_vence(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.facturaproveedorservicio.setdetalle(arrColumnas[iColumn++]);
				this.facturaproveedorservicio.setnumero_retencion(arrColumnas[iColumn++]);
				this.facturaproveedorservicio.setnumero_autorizacion(arrColumnas[iColumn++]);
				this.facturaproveedorservicio.setnumero_serie(arrColumnas[iColumn++]);
				this.facturaproveedorservicio.setfecha_validez(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.facturaproveedorservicio.setanexo_factura_inicio(arrColumnas[iColumn++]);
				this.facturaproveedorservicio.setanexo_factura_fin(arrColumnas[iColumn++]);
				
				this.facturaproveedorservicios.add(this.facturaproveedorservicio);
			}
			
			this.saveFacturaProveedorServicios();
			
			this.connexion.commit();
			
			facturaproveedorservicioReturnGeneral.setConRetornoEstaProcesado(true);
			facturaproveedorservicioReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return facturaproveedorservicioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarFacturaProveedorServiciosEliminados() throws Exception {				
		
		List<FacturaProveedorServicio> facturaproveedorserviciosAux= new ArrayList<FacturaProveedorServicio>();
		
		for(FacturaProveedorServicio facturaproveedorservicio:facturaproveedorservicios) {
			if(!facturaproveedorservicio.getIsDeleted()) {
				facturaproveedorserviciosAux.add(facturaproveedorservicio);
			}
		}
		
		facturaproveedorservicios=facturaproveedorserviciosAux;
	}
	
	public void quitarFacturaProveedorServiciosNulos() throws Exception {				
		
		List<FacturaProveedorServicio> facturaproveedorserviciosAux= new ArrayList<FacturaProveedorServicio>();
		
		for(FacturaProveedorServicio facturaproveedorservicio : this.facturaproveedorservicios) {
			if(facturaproveedorservicio==null) {
				facturaproveedorserviciosAux.add(facturaproveedorservicio);
			}
		}
		
		//this.facturaproveedorservicios=facturaproveedorserviciosAux;
		
		this.facturaproveedorservicios.removeAll(facturaproveedorserviciosAux);
	}
	
	public void getSetVersionRowFacturaProveedorServicioWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(facturaproveedorservicio.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((facturaproveedorservicio.getIsDeleted() || (facturaproveedorservicio.getIsChanged()&&!facturaproveedorservicio.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=facturaproveedorservicioDataAccess.getSetVersionRowFacturaProveedorServicio(connexion,facturaproveedorservicio.getId());
				
				if(!facturaproveedorservicio.getVersionRow().equals(timestamp)) {	
					facturaproveedorservicio.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				facturaproveedorservicio.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowFacturaProveedorServicio()throws Exception {	
		
		if(facturaproveedorservicio.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((facturaproveedorservicio.getIsDeleted() || (facturaproveedorservicio.getIsChanged()&&!facturaproveedorservicio.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=facturaproveedorservicioDataAccess.getSetVersionRowFacturaProveedorServicio(connexion,facturaproveedorservicio.getId());
			
			try {							
				if(!facturaproveedorservicio.getVersionRow().equals(timestamp)) {	
					facturaproveedorservicio.setVersionRow(timestamp);
				}
				
				facturaproveedorservicio.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowFacturaProveedorServiciosWithConnection()throws Exception {	
		if(facturaproveedorservicios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(FacturaProveedorServicio facturaproveedorservicioAux:facturaproveedorservicios) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(facturaproveedorservicioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(facturaproveedorservicioAux.getIsDeleted() || (facturaproveedorservicioAux.getIsChanged()&&!facturaproveedorservicioAux.getIsNew())) {
						
						timestamp=facturaproveedorservicioDataAccess.getSetVersionRowFacturaProveedorServicio(connexion,facturaproveedorservicioAux.getId());
						
						if(!facturaproveedorservicio.getVersionRow().equals(timestamp)) {	
							facturaproveedorservicioAux.setVersionRow(timestamp);
						}
								
						facturaproveedorservicioAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowFacturaProveedorServicios()throws Exception {	
		if(facturaproveedorservicios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(FacturaProveedorServicio facturaproveedorservicioAux:facturaproveedorservicios) {
					if(facturaproveedorservicioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(facturaproveedorservicioAux.getIsDeleted() || (facturaproveedorservicioAux.getIsChanged()&&!facturaproveedorservicioAux.getIsNew())) {
						
						timestamp=facturaproveedorservicioDataAccess.getSetVersionRowFacturaProveedorServicio(connexion,facturaproveedorservicioAux.getId());
						
						if(!facturaproveedorservicioAux.getVersionRow().equals(timestamp)) {	
							facturaproveedorservicioAux.setVersionRow(timestamp);
						}
						
													
						facturaproveedorservicioAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public FacturaProveedorServicioParameterReturnGeneral cargarCombosLoteForeignKeyFacturaProveedorServicioWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalModulo,String finalQueryGlobalTransaccion,String finalQueryGlobalFactura,String finalQueryGlobalCliente,String finalQueryGlobalTipoDocumento,String finalQueryGlobalEmpleadoSolicita,String finalQueryGlobalEmpleado,String finalQueryGlobalTipoTributario,String finalQueryGlobalMoneda,String finalQueryGlobalTipoRetencionFuente1,String finalQueryGlobalTipoRetencionIva1,String finalQueryGlobalCuentaContableCreditoFiscalServicios,String finalQueryGlobalTipoMovimiento,String finalQueryGlobalTipoMovimientoModulo,String finalQueryGlobalTipoTransaccionModulo) throws Exception {
		FacturaProveedorServicioParameterReturnGeneral  facturaproveedorservicioReturnGeneral =new FacturaProveedorServicioParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedorServicio.class.getSimpleName()+"-cargarCombosLoteForeignKeyFacturaProveedorServicioWithConnection");connexion.begin();
			
			facturaproveedorservicioReturnGeneral =new FacturaProveedorServicioParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			facturaproveedorservicioReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			facturaproveedorservicioReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			facturaproveedorservicioReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			facturaproveedorservicioReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			facturaproveedorservicioReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			facturaproveedorservicioReturnGeneral.setmessForeignKey(messForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			facturaproveedorservicioReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<Transaccion> transaccionsForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			transaccionLogic.setConnexion(this.connexion);
			transaccionLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion.equals("NONE")) {
				transaccionLogic.getTodosTransaccions(finalQueryGlobalTransaccion,new Pagination());
				transaccionsForeignKey=transaccionLogic.getTransaccions();
			}

			facturaproveedorservicioReturnGeneral.settransaccionsForeignKey(transaccionsForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			facturaproveedorservicioReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			facturaproveedorservicioReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoDocumento> tipodocumentosForeignKey=new ArrayList<TipoDocumento>();
			TipoDocumentoLogic tipodocumentoLogic=new TipoDocumentoLogic();
			tipodocumentoLogic.setConnexion(this.connexion);
			tipodocumentoLogic.getTipoDocumentoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDocumento.equals("NONE")) {
				tipodocumentoLogic.getTodosTipoDocumentos(finalQueryGlobalTipoDocumento,new Pagination());
				tipodocumentosForeignKey=tipodocumentoLogic.getTipoDocumentos();
			}

			facturaproveedorservicioReturnGeneral.settipodocumentosForeignKey(tipodocumentosForeignKey);


			List<Empleado> empleadosolicitasForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadosolicitaLogic=new EmpleadoLogic();
			empleadosolicitaLogic.setConnexion(this.connexion);
			empleadosolicitaLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleadoSolicita.equals("NONE")) {
				empleadosolicitaLogic.getTodosEmpleados(finalQueryGlobalEmpleadoSolicita,new Pagination());
				empleadosolicitasForeignKey=empleadosolicitaLogic.getEmpleados();
			}

			facturaproveedorservicioReturnGeneral.setempleadosolicitasForeignKey(empleadosolicitasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			facturaproveedorservicioReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<TipoTributario> tipotributariosForeignKey=new ArrayList<TipoTributario>();
			TipoTributarioLogic tipotributarioLogic=new TipoTributarioLogic();
			tipotributarioLogic.setConnexion(this.connexion);
			tipotributarioLogic.getTipoTributarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTributario.equals("NONE")) {
				tipotributarioLogic.getTodosTipoTributarios(finalQueryGlobalTipoTributario,new Pagination());
				tipotributariosForeignKey=tipotributarioLogic.getTipoTributarios();
			}

			facturaproveedorservicioReturnGeneral.settipotributariosForeignKey(tipotributariosForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			facturaproveedorservicioReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<TipoRetencion> tiporetencionfuente1sForeignKey=new ArrayList<TipoRetencion>();
			TipoRetencionLogic tiporetencionfuente1Logic=new TipoRetencionLogic();
			tiporetencionfuente1Logic.setConnexion(this.connexion);
			tiporetencionfuente1Logic.getTipoRetencionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencionFuente1.equals("NONE")) {
				tiporetencionfuente1Logic.getTodosTipoRetencions(finalQueryGlobalTipoRetencionFuente1,new Pagination());
				tiporetencionfuente1sForeignKey=tiporetencionfuente1Logic.getTipoRetencions();
			}

			facturaproveedorservicioReturnGeneral.settiporetencionfuente1sForeignKey(tiporetencionfuente1sForeignKey);


			List<TipoRetencion> tiporetencioniva1sForeignKey=new ArrayList<TipoRetencion>();
			TipoRetencionLogic tiporetencioniva1Logic=new TipoRetencionLogic();
			tiporetencioniva1Logic.setConnexion(this.connexion);
			tiporetencioniva1Logic.getTipoRetencionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencionIva1.equals("NONE")) {
				tiporetencioniva1Logic.getTodosTipoRetencions(finalQueryGlobalTipoRetencionIva1,new Pagination());
				tiporetencioniva1sForeignKey=tiporetencioniva1Logic.getTipoRetencions();
			}

			facturaproveedorservicioReturnGeneral.settiporetencioniva1sForeignKey(tiporetencioniva1sForeignKey);


			List<CuentaContable> cuentacontablecreditofiscalserviciossForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditofiscalserviciosLogic=new CuentaContableLogic();
			cuentacontablecreditofiscalserviciosLogic.setConnexion(this.connexion);
			cuentacontablecreditofiscalserviciosLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCreditoFiscalServicios.equals("NONE")) {
				cuentacontablecreditofiscalserviciosLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCreditoFiscalServicios,new Pagination());
				cuentacontablecreditofiscalserviciossForeignKey=cuentacontablecreditofiscalserviciosLogic.getCuentaContables();
			}

			facturaproveedorservicioReturnGeneral.setcuentacontablecreditofiscalserviciossForeignKey(cuentacontablecreditofiscalserviciossForeignKey);


			List<TipoMovimiento> tipomovimientosForeignKey=new ArrayList<TipoMovimiento>();
			TipoMovimientoLogic tipomovimientoLogic=new TipoMovimientoLogic();
			tipomovimientoLogic.setConnexion(this.connexion);
			tipomovimientoLogic.getTipoMovimientoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMovimiento.equals("NONE")) {
				tipomovimientoLogic.getTodosTipoMovimientos(finalQueryGlobalTipoMovimiento,new Pagination());
				tipomovimientosForeignKey=tipomovimientoLogic.getTipoMovimientos();
			}

			facturaproveedorservicioReturnGeneral.settipomovimientosForeignKey(tipomovimientosForeignKey);


			List<TipoMovimientoModulo> tipomovimientomodulosForeignKey=new ArrayList<TipoMovimientoModulo>();
			TipoMovimientoModuloLogic tipomovimientomoduloLogic=new TipoMovimientoModuloLogic();
			tipomovimientomoduloLogic.setConnexion(this.connexion);
			tipomovimientomoduloLogic.getTipoMovimientoModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMovimientoModulo.equals("NONE")) {
				tipomovimientomoduloLogic.getTodosTipoMovimientoModulos(finalQueryGlobalTipoMovimientoModulo,new Pagination());
				tipomovimientomodulosForeignKey=tipomovimientomoduloLogic.getTipoMovimientoModulos();
			}

			facturaproveedorservicioReturnGeneral.settipomovimientomodulosForeignKey(tipomovimientomodulosForeignKey);


			List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic=new TipoTransaccionModuloLogic();
			tipotransaccionmoduloLogic.setConnexion(this.connexion);
			tipotransaccionmoduloLogic.getTipoTransaccionModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTransaccionModulo.equals("NONE")) {
				tipotransaccionmoduloLogic.getTodosTipoTransaccionModulos(finalQueryGlobalTipoTransaccionModulo,new Pagination());
				tipotransaccionmodulosForeignKey=tipotransaccionmoduloLogic.getTipoTransaccionModulos();
			}

			facturaproveedorservicioReturnGeneral.settipotransaccionmodulosForeignKey(tipotransaccionmodulosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return facturaproveedorservicioReturnGeneral;
	}
	
	public FacturaProveedorServicioParameterReturnGeneral cargarCombosLoteForeignKeyFacturaProveedorServicio(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalModulo,String finalQueryGlobalTransaccion,String finalQueryGlobalFactura,String finalQueryGlobalCliente,String finalQueryGlobalTipoDocumento,String finalQueryGlobalEmpleadoSolicita,String finalQueryGlobalEmpleado,String finalQueryGlobalTipoTributario,String finalQueryGlobalMoneda,String finalQueryGlobalTipoRetencionFuente1,String finalQueryGlobalTipoRetencionIva1,String finalQueryGlobalCuentaContableCreditoFiscalServicios,String finalQueryGlobalTipoMovimiento,String finalQueryGlobalTipoMovimientoModulo,String finalQueryGlobalTipoTransaccionModulo) throws Exception {
		FacturaProveedorServicioParameterReturnGeneral  facturaproveedorservicioReturnGeneral =new FacturaProveedorServicioParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			facturaproveedorservicioReturnGeneral =new FacturaProveedorServicioParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			facturaproveedorservicioReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			facturaproveedorservicioReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			facturaproveedorservicioReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			facturaproveedorservicioReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			facturaproveedorservicioReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			facturaproveedorservicioReturnGeneral.setmessForeignKey(messForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			facturaproveedorservicioReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<Transaccion> transaccionsForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			transaccionLogic.setConnexion(this.connexion);
			transaccionLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion.equals("NONE")) {
				transaccionLogic.getTodosTransaccions(finalQueryGlobalTransaccion,new Pagination());
				transaccionsForeignKey=transaccionLogic.getTransaccions();
			}

			facturaproveedorservicioReturnGeneral.settransaccionsForeignKey(transaccionsForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			facturaproveedorservicioReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			facturaproveedorservicioReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoDocumento> tipodocumentosForeignKey=new ArrayList<TipoDocumento>();
			TipoDocumentoLogic tipodocumentoLogic=new TipoDocumentoLogic();
			tipodocumentoLogic.setConnexion(this.connexion);
			tipodocumentoLogic.getTipoDocumentoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDocumento.equals("NONE")) {
				tipodocumentoLogic.getTodosTipoDocumentos(finalQueryGlobalTipoDocumento,new Pagination());
				tipodocumentosForeignKey=tipodocumentoLogic.getTipoDocumentos();
			}

			facturaproveedorservicioReturnGeneral.settipodocumentosForeignKey(tipodocumentosForeignKey);


			List<Empleado> empleadosolicitasForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadosolicitaLogic=new EmpleadoLogic();
			empleadosolicitaLogic.setConnexion(this.connexion);
			empleadosolicitaLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleadoSolicita.equals("NONE")) {
				empleadosolicitaLogic.getTodosEmpleados(finalQueryGlobalEmpleadoSolicita,new Pagination());
				empleadosolicitasForeignKey=empleadosolicitaLogic.getEmpleados();
			}

			facturaproveedorservicioReturnGeneral.setempleadosolicitasForeignKey(empleadosolicitasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			facturaproveedorservicioReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<TipoTributario> tipotributariosForeignKey=new ArrayList<TipoTributario>();
			TipoTributarioLogic tipotributarioLogic=new TipoTributarioLogic();
			tipotributarioLogic.setConnexion(this.connexion);
			tipotributarioLogic.getTipoTributarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTributario.equals("NONE")) {
				tipotributarioLogic.getTodosTipoTributarios(finalQueryGlobalTipoTributario,new Pagination());
				tipotributariosForeignKey=tipotributarioLogic.getTipoTributarios();
			}

			facturaproveedorservicioReturnGeneral.settipotributariosForeignKey(tipotributariosForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			facturaproveedorservicioReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<TipoRetencion> tiporetencionfuente1sForeignKey=new ArrayList<TipoRetencion>();
			TipoRetencionLogic tiporetencionfuente1Logic=new TipoRetencionLogic();
			tiporetencionfuente1Logic.setConnexion(this.connexion);
			tiporetencionfuente1Logic.getTipoRetencionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencionFuente1.equals("NONE")) {
				tiporetencionfuente1Logic.getTodosTipoRetencions(finalQueryGlobalTipoRetencionFuente1,new Pagination());
				tiporetencionfuente1sForeignKey=tiporetencionfuente1Logic.getTipoRetencions();
			}

			facturaproveedorservicioReturnGeneral.settiporetencionfuente1sForeignKey(tiporetencionfuente1sForeignKey);


			List<TipoRetencion> tiporetencioniva1sForeignKey=new ArrayList<TipoRetencion>();
			TipoRetencionLogic tiporetencioniva1Logic=new TipoRetencionLogic();
			tiporetencioniva1Logic.setConnexion(this.connexion);
			tiporetencioniva1Logic.getTipoRetencionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencionIva1.equals("NONE")) {
				tiporetencioniva1Logic.getTodosTipoRetencions(finalQueryGlobalTipoRetencionIva1,new Pagination());
				tiporetencioniva1sForeignKey=tiporetencioniva1Logic.getTipoRetencions();
			}

			facturaproveedorservicioReturnGeneral.settiporetencioniva1sForeignKey(tiporetencioniva1sForeignKey);


			List<CuentaContable> cuentacontablecreditofiscalserviciossForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditofiscalserviciosLogic=new CuentaContableLogic();
			cuentacontablecreditofiscalserviciosLogic.setConnexion(this.connexion);
			cuentacontablecreditofiscalserviciosLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCreditoFiscalServicios.equals("NONE")) {
				cuentacontablecreditofiscalserviciosLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCreditoFiscalServicios,new Pagination());
				cuentacontablecreditofiscalserviciossForeignKey=cuentacontablecreditofiscalserviciosLogic.getCuentaContables();
			}

			facturaproveedorservicioReturnGeneral.setcuentacontablecreditofiscalserviciossForeignKey(cuentacontablecreditofiscalserviciossForeignKey);


			List<TipoMovimiento> tipomovimientosForeignKey=new ArrayList<TipoMovimiento>();
			TipoMovimientoLogic tipomovimientoLogic=new TipoMovimientoLogic();
			tipomovimientoLogic.setConnexion(this.connexion);
			tipomovimientoLogic.getTipoMovimientoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMovimiento.equals("NONE")) {
				tipomovimientoLogic.getTodosTipoMovimientos(finalQueryGlobalTipoMovimiento,new Pagination());
				tipomovimientosForeignKey=tipomovimientoLogic.getTipoMovimientos();
			}

			facturaproveedorservicioReturnGeneral.settipomovimientosForeignKey(tipomovimientosForeignKey);


			List<TipoMovimientoModulo> tipomovimientomodulosForeignKey=new ArrayList<TipoMovimientoModulo>();
			TipoMovimientoModuloLogic tipomovimientomoduloLogic=new TipoMovimientoModuloLogic();
			tipomovimientomoduloLogic.setConnexion(this.connexion);
			tipomovimientomoduloLogic.getTipoMovimientoModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoMovimientoModulo.equals("NONE")) {
				tipomovimientomoduloLogic.getTodosTipoMovimientoModulos(finalQueryGlobalTipoMovimientoModulo,new Pagination());
				tipomovimientomodulosForeignKey=tipomovimientomoduloLogic.getTipoMovimientoModulos();
			}

			facturaproveedorservicioReturnGeneral.settipomovimientomodulosForeignKey(tipomovimientomodulosForeignKey);


			List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic=new TipoTransaccionModuloLogic();
			tipotransaccionmoduloLogic.setConnexion(this.connexion);
			tipotransaccionmoduloLogic.getTipoTransaccionModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTransaccionModulo.equals("NONE")) {
				tipotransaccionmoduloLogic.getTodosTipoTransaccionModulos(finalQueryGlobalTipoTransaccionModulo,new Pagination());
				tipotransaccionmodulosForeignKey=tipotransaccionmoduloLogic.getTipoTransaccionModulos();
			}

			facturaproveedorservicioReturnGeneral.settipotransaccionmodulosForeignKey(tipotransaccionmodulosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return facturaproveedorservicioReturnGeneral;
	}
	
	
	public void deepLoad(FacturaProveedorServicio facturaproveedorservicio,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			FacturaProveedorServicioLogicAdditional.updateFacturaProveedorServicioToGet(facturaproveedorservicio,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		facturaproveedorservicio.setEmpresa(facturaproveedorservicioDataAccess.getEmpresa(connexion,facturaproveedorservicio));
		facturaproveedorservicio.setSucursal(facturaproveedorservicioDataAccess.getSucursal(connexion,facturaproveedorservicio));
		facturaproveedorservicio.setEjercicio(facturaproveedorservicioDataAccess.getEjercicio(connexion,facturaproveedorservicio));
		facturaproveedorservicio.setPeriodo(facturaproveedorservicioDataAccess.getPeriodo(connexion,facturaproveedorservicio));
		facturaproveedorservicio.setAnio(facturaproveedorservicioDataAccess.getAnio(connexion,facturaproveedorservicio));
		facturaproveedorservicio.setMes(facturaproveedorservicioDataAccess.getMes(connexion,facturaproveedorservicio));
		facturaproveedorservicio.setModulo(facturaproveedorservicioDataAccess.getModulo(connexion,facturaproveedorservicio));
		facturaproveedorservicio.setTransaccion(facturaproveedorservicioDataAccess.getTransaccion(connexion,facturaproveedorservicio));
		facturaproveedorservicio.setFactura(facturaproveedorservicioDataAccess.getFactura(connexion,facturaproveedorservicio));
		facturaproveedorservicio.setCliente(facturaproveedorservicioDataAccess.getCliente(connexion,facturaproveedorservicio));
		facturaproveedorservicio.setTipoDocumento(facturaproveedorservicioDataAccess.getTipoDocumento(connexion,facturaproveedorservicio));
		facturaproveedorservicio.setEmpleadoSolicita(facturaproveedorservicioDataAccess.getEmpleadoSolicita(connexion,facturaproveedorservicio));
		facturaproveedorservicio.setEmpleado(facturaproveedorservicioDataAccess.getEmpleado(connexion,facturaproveedorservicio));
		facturaproveedorservicio.setTipoTributario(facturaproveedorservicioDataAccess.getTipoTributario(connexion,facturaproveedorservicio));
		facturaproveedorservicio.setMoneda(facturaproveedorservicioDataAccess.getMoneda(connexion,facturaproveedorservicio));
		facturaproveedorservicio.setTipoRetencionFuente1(facturaproveedorservicioDataAccess.getTipoRetencionFuente1(connexion,facturaproveedorservicio));
		facturaproveedorservicio.setTipoRetencionIva1(facturaproveedorservicioDataAccess.getTipoRetencionIva1(connexion,facturaproveedorservicio));
		facturaproveedorservicio.setCuentaContableCreditoFiscalServicios(facturaproveedorservicioDataAccess.getCuentaContableCreditoFiscalServicios(connexion,facturaproveedorservicio));
		facturaproveedorservicio.setTipoMovimiento(facturaproveedorservicioDataAccess.getTipoMovimiento(connexion,facturaproveedorservicio));
		facturaproveedorservicio.setTipoMovimientoModulo(facturaproveedorservicioDataAccess.getTipoMovimientoModulo(connexion,facturaproveedorservicio));
		facturaproveedorservicio.setTipoTransaccionModulo(facturaproveedorservicioDataAccess.getTipoTransaccionModulo(connexion,facturaproveedorservicio));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				facturaproveedorservicio.setEmpresa(facturaproveedorservicioDataAccess.getEmpresa(connexion,facturaproveedorservicio));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				facturaproveedorservicio.setSucursal(facturaproveedorservicioDataAccess.getSucursal(connexion,facturaproveedorservicio));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				facturaproveedorservicio.setEjercicio(facturaproveedorservicioDataAccess.getEjercicio(connexion,facturaproveedorservicio));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				facturaproveedorservicio.setPeriodo(facturaproveedorservicioDataAccess.getPeriodo(connexion,facturaproveedorservicio));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				facturaproveedorservicio.setAnio(facturaproveedorservicioDataAccess.getAnio(connexion,facturaproveedorservicio));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				facturaproveedorservicio.setMes(facturaproveedorservicioDataAccess.getMes(connexion,facturaproveedorservicio));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				facturaproveedorservicio.setModulo(facturaproveedorservicioDataAccess.getModulo(connexion,facturaproveedorservicio));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				facturaproveedorservicio.setTransaccion(facturaproveedorservicioDataAccess.getTransaccion(connexion,facturaproveedorservicio));
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				facturaproveedorservicio.setFactura(facturaproveedorservicioDataAccess.getFactura(connexion,facturaproveedorservicio));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				facturaproveedorservicio.setCliente(facturaproveedorservicioDataAccess.getCliente(connexion,facturaproveedorservicio));
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				facturaproveedorservicio.setTipoDocumento(facturaproveedorservicioDataAccess.getTipoDocumento(connexion,facturaproveedorservicio));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				facturaproveedorservicio.setEmpleadoSolicita(facturaproveedorservicioDataAccess.getEmpleadoSolicita(connexion,facturaproveedorservicio));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				facturaproveedorservicio.setEmpleado(facturaproveedorservicioDataAccess.getEmpleado(connexion,facturaproveedorservicio));
				continue;
			}

			if(clas.clas.equals(TipoTributario.class)) {
				facturaproveedorservicio.setTipoTributario(facturaproveedorservicioDataAccess.getTipoTributario(connexion,facturaproveedorservicio));
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				facturaproveedorservicio.setMoneda(facturaproveedorservicioDataAccess.getMoneda(connexion,facturaproveedorservicio));
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				facturaproveedorservicio.setTipoRetencionFuente1(facturaproveedorservicioDataAccess.getTipoRetencionFuente1(connexion,facturaproveedorservicio));
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				facturaproveedorservicio.setTipoRetencionIva1(facturaproveedorservicioDataAccess.getTipoRetencionIva1(connexion,facturaproveedorservicio));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				facturaproveedorservicio.setCuentaContableCreditoFiscalServicios(facturaproveedorservicioDataAccess.getCuentaContableCreditoFiscalServicios(connexion,facturaproveedorservicio));
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				facturaproveedorservicio.setTipoMovimiento(facturaproveedorservicioDataAccess.getTipoMovimiento(connexion,facturaproveedorservicio));
				continue;
			}

			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				facturaproveedorservicio.setTipoMovimientoModulo(facturaproveedorservicioDataAccess.getTipoMovimientoModulo(connexion,facturaproveedorservicio));
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				facturaproveedorservicio.setTipoTransaccionModulo(facturaproveedorservicioDataAccess.getTipoTransaccionModulo(connexion,facturaproveedorservicio));
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
			facturaproveedorservicio.setEmpresa(facturaproveedorservicioDataAccess.getEmpresa(connexion,facturaproveedorservicio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedorservicio.setSucursal(facturaproveedorservicioDataAccess.getSucursal(connexion,facturaproveedorservicio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedorservicio.setEjercicio(facturaproveedorservicioDataAccess.getEjercicio(connexion,facturaproveedorservicio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedorservicio.setPeriodo(facturaproveedorservicioDataAccess.getPeriodo(connexion,facturaproveedorservicio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedorservicio.setAnio(facturaproveedorservicioDataAccess.getAnio(connexion,facturaproveedorservicio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedorservicio.setMes(facturaproveedorservicioDataAccess.getMes(connexion,facturaproveedorservicio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedorservicio.setModulo(facturaproveedorservicioDataAccess.getModulo(connexion,facturaproveedorservicio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedorservicio.setTransaccion(facturaproveedorservicioDataAccess.getTransaccion(connexion,facturaproveedorservicio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedorservicio.setFactura(facturaproveedorservicioDataAccess.getFactura(connexion,facturaproveedorservicio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedorservicio.setCliente(facturaproveedorservicioDataAccess.getCliente(connexion,facturaproveedorservicio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedorservicio.setTipoDocumento(facturaproveedorservicioDataAccess.getTipoDocumento(connexion,facturaproveedorservicio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedorservicio.setEmpleadoSolicita(facturaproveedorservicioDataAccess.getEmpleadoSolicita(connexion,facturaproveedorservicio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedorservicio.setEmpleado(facturaproveedorservicioDataAccess.getEmpleado(connexion,facturaproveedorservicio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTributario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedorservicio.setTipoTributario(facturaproveedorservicioDataAccess.getTipoTributario(connexion,facturaproveedorservicio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedorservicio.setMoneda(facturaproveedorservicioDataAccess.getMoneda(connexion,facturaproveedorservicio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedorservicio.setTipoRetencionFuente1(facturaproveedorservicioDataAccess.getTipoRetencionFuente1(connexion,facturaproveedorservicio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedorservicio.setTipoRetencionIva1(facturaproveedorservicioDataAccess.getTipoRetencionIva1(connexion,facturaproveedorservicio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedorservicio.setCuentaContableCreditoFiscalServicios(facturaproveedorservicioDataAccess.getCuentaContableCreditoFiscalServicios(connexion,facturaproveedorservicio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedorservicio.setTipoMovimiento(facturaproveedorservicioDataAccess.getTipoMovimiento(connexion,facturaproveedorservicio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedorservicio.setTipoMovimientoModulo(facturaproveedorservicioDataAccess.getTipoMovimientoModulo(connexion,facturaproveedorservicio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedorservicio.setTipoTransaccionModulo(facturaproveedorservicioDataAccess.getTipoTransaccionModulo(connexion,facturaproveedorservicio));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		facturaproveedorservicio.setEmpresa(facturaproveedorservicioDataAccess.getEmpresa(connexion,facturaproveedorservicio));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(facturaproveedorservicio.getEmpresa(),isDeep,deepLoadType,clases);
				
		facturaproveedorservicio.setSucursal(facturaproveedorservicioDataAccess.getSucursal(connexion,facturaproveedorservicio));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(facturaproveedorservicio.getSucursal(),isDeep,deepLoadType,clases);
				
		facturaproveedorservicio.setEjercicio(facturaproveedorservicioDataAccess.getEjercicio(connexion,facturaproveedorservicio));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(facturaproveedorservicio.getEjercicio(),isDeep,deepLoadType,clases);
				
		facturaproveedorservicio.setPeriodo(facturaproveedorservicioDataAccess.getPeriodo(connexion,facturaproveedorservicio));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(facturaproveedorservicio.getPeriodo(),isDeep,deepLoadType,clases);
				
		facturaproveedorservicio.setAnio(facturaproveedorservicioDataAccess.getAnio(connexion,facturaproveedorservicio));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(facturaproveedorservicio.getAnio(),isDeep,deepLoadType,clases);
				
		facturaproveedorservicio.setMes(facturaproveedorservicioDataAccess.getMes(connexion,facturaproveedorservicio));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(facturaproveedorservicio.getMes(),isDeep,deepLoadType,clases);
				
		facturaproveedorservicio.setModulo(facturaproveedorservicioDataAccess.getModulo(connexion,facturaproveedorservicio));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(facturaproveedorservicio.getModulo(),isDeep,deepLoadType,clases);
				
		facturaproveedorservicio.setTransaccion(facturaproveedorservicioDataAccess.getTransaccion(connexion,facturaproveedorservicio));
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(facturaproveedorservicio.getTransaccion(),isDeep,deepLoadType,clases);
				
		facturaproveedorservicio.setFactura(facturaproveedorservicioDataAccess.getFactura(connexion,facturaproveedorservicio));
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(facturaproveedorservicio.getFactura(),isDeep,deepLoadType,clases);
				
		facturaproveedorservicio.setCliente(facturaproveedorservicioDataAccess.getCliente(connexion,facturaproveedorservicio));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(facturaproveedorservicio.getCliente(),isDeep,deepLoadType,clases);
				
		facturaproveedorservicio.setTipoDocumento(facturaproveedorservicioDataAccess.getTipoDocumento(connexion,facturaproveedorservicio));
		TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
		tipodocumentoLogic.deepLoad(facturaproveedorservicio.getTipoDocumento(),isDeep,deepLoadType,clases);
				
		facturaproveedorservicio.setEmpleadoSolicita(facturaproveedorservicioDataAccess.getEmpleadoSolicita(connexion,facturaproveedorservicio));
		EmpleadoLogic empleadosolicitaLogic= new EmpleadoLogic(connexion);
		empleadosolicitaLogic.deepLoad(facturaproveedorservicio.getEmpleadoSolicita(),isDeep,deepLoadType,clases);
				
		facturaproveedorservicio.setEmpleado(facturaproveedorservicioDataAccess.getEmpleado(connexion,facturaproveedorservicio));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(facturaproveedorservicio.getEmpleado(),isDeep,deepLoadType,clases);
				
		facturaproveedorservicio.setTipoTributario(facturaproveedorservicioDataAccess.getTipoTributario(connexion,facturaproveedorservicio));
		TipoTributarioLogic tipotributarioLogic= new TipoTributarioLogic(connexion);
		tipotributarioLogic.deepLoad(facturaproveedorservicio.getTipoTributario(),isDeep,deepLoadType,clases);
				
		facturaproveedorservicio.setMoneda(facturaproveedorservicioDataAccess.getMoneda(connexion,facturaproveedorservicio));
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(facturaproveedorservicio.getMoneda(),isDeep,deepLoadType,clases);
				
		facturaproveedorservicio.setTipoRetencionFuente1(facturaproveedorservicioDataAccess.getTipoRetencionFuente1(connexion,facturaproveedorservicio));
		TipoRetencionLogic tiporetencionfuente1Logic= new TipoRetencionLogic(connexion);
		tiporetencionfuente1Logic.deepLoad(facturaproveedorservicio.getTipoRetencionFuente1(),isDeep,deepLoadType,clases);
				
		facturaproveedorservicio.setTipoRetencionIva1(facturaproveedorservicioDataAccess.getTipoRetencionIva1(connexion,facturaproveedorservicio));
		TipoRetencionLogic tiporetencioniva1Logic= new TipoRetencionLogic(connexion);
		tiporetencioniva1Logic.deepLoad(facturaproveedorservicio.getTipoRetencionIva1(),isDeep,deepLoadType,clases);
				
		facturaproveedorservicio.setCuentaContableCreditoFiscalServicios(facturaproveedorservicioDataAccess.getCuentaContableCreditoFiscalServicios(connexion,facturaproveedorservicio));
		CuentaContableLogic cuentacontablecreditofiscalserviciosLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditofiscalserviciosLogic.deepLoad(facturaproveedorservicio.getCuentaContableCreditoFiscalServicios(),isDeep,deepLoadType,clases);
				
		facturaproveedorservicio.setTipoMovimiento(facturaproveedorservicioDataAccess.getTipoMovimiento(connexion,facturaproveedorservicio));
		TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
		tipomovimientoLogic.deepLoad(facturaproveedorservicio.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
		facturaproveedorservicio.setTipoMovimientoModulo(facturaproveedorservicioDataAccess.getTipoMovimientoModulo(connexion,facturaproveedorservicio));
		TipoMovimientoModuloLogic tipomovimientomoduloLogic= new TipoMovimientoModuloLogic(connexion);
		tipomovimientomoduloLogic.deepLoad(facturaproveedorservicio.getTipoMovimientoModulo(),isDeep,deepLoadType,clases);
				
		facturaproveedorservicio.setTipoTransaccionModulo(facturaproveedorservicioDataAccess.getTipoTransaccionModulo(connexion,facturaproveedorservicio));
		TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
		tipotransaccionmoduloLogic.deepLoad(facturaproveedorservicio.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				facturaproveedorservicio.setEmpresa(facturaproveedorservicioDataAccess.getEmpresa(connexion,facturaproveedorservicio));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(facturaproveedorservicio.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				facturaproveedorservicio.setSucursal(facturaproveedorservicioDataAccess.getSucursal(connexion,facturaproveedorservicio));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(facturaproveedorservicio.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				facturaproveedorservicio.setEjercicio(facturaproveedorservicioDataAccess.getEjercicio(connexion,facturaproveedorservicio));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(facturaproveedorservicio.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				facturaproveedorservicio.setPeriodo(facturaproveedorservicioDataAccess.getPeriodo(connexion,facturaproveedorservicio));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(facturaproveedorservicio.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				facturaproveedorservicio.setAnio(facturaproveedorservicioDataAccess.getAnio(connexion,facturaproveedorservicio));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(facturaproveedorservicio.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				facturaproveedorservicio.setMes(facturaproveedorservicioDataAccess.getMes(connexion,facturaproveedorservicio));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(facturaproveedorservicio.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				facturaproveedorservicio.setModulo(facturaproveedorservicioDataAccess.getModulo(connexion,facturaproveedorservicio));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(facturaproveedorservicio.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				facturaproveedorservicio.setTransaccion(facturaproveedorservicioDataAccess.getTransaccion(connexion,facturaproveedorservicio));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(facturaproveedorservicio.getTransaccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				facturaproveedorservicio.setFactura(facturaproveedorservicioDataAccess.getFactura(connexion,facturaproveedorservicio));
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepLoad(facturaproveedorservicio.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				facturaproveedorservicio.setCliente(facturaproveedorservicioDataAccess.getCliente(connexion,facturaproveedorservicio));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(facturaproveedorservicio.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				facturaproveedorservicio.setTipoDocumento(facturaproveedorservicioDataAccess.getTipoDocumento(connexion,facturaproveedorservicio));
				TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
				tipodocumentoLogic.deepLoad(facturaproveedorservicio.getTipoDocumento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				facturaproveedorservicio.setEmpleadoSolicita(facturaproveedorservicioDataAccess.getEmpleadoSolicita(connexion,facturaproveedorservicio));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(facturaproveedorservicio.getEmpleadoSolicita(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				facturaproveedorservicio.setEmpleado(facturaproveedorservicioDataAccess.getEmpleado(connexion,facturaproveedorservicio));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(facturaproveedorservicio.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTributario.class)) {
				facturaproveedorservicio.setTipoTributario(facturaproveedorservicioDataAccess.getTipoTributario(connexion,facturaproveedorservicio));
				TipoTributarioLogic tipotributarioLogic= new TipoTributarioLogic(connexion);
				tipotributarioLogic.deepLoad(facturaproveedorservicio.getTipoTributario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				facturaproveedorservicio.setMoneda(facturaproveedorservicioDataAccess.getMoneda(connexion,facturaproveedorservicio));
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepLoad(facturaproveedorservicio.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				facturaproveedorservicio.setTipoRetencionFuente1(facturaproveedorservicioDataAccess.getTipoRetencionFuente1(connexion,facturaproveedorservicio));
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepLoad(facturaproveedorservicio.getTipoRetencionFuente1(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				facturaproveedorservicio.setTipoRetencionIva1(facturaproveedorservicioDataAccess.getTipoRetencionIva1(connexion,facturaproveedorservicio));
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepLoad(facturaproveedorservicio.getTipoRetencionIva1(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				facturaproveedorservicio.setCuentaContableCreditoFiscalServicios(facturaproveedorservicioDataAccess.getCuentaContableCreditoFiscalServicios(connexion,facturaproveedorservicio));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(facturaproveedorservicio.getCuentaContableCreditoFiscalServicios(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				facturaproveedorservicio.setTipoMovimiento(facturaproveedorservicioDataAccess.getTipoMovimiento(connexion,facturaproveedorservicio));
				TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
				tipomovimientoLogic.deepLoad(facturaproveedorservicio.getTipoMovimiento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				facturaproveedorservicio.setTipoMovimientoModulo(facturaproveedorservicioDataAccess.getTipoMovimientoModulo(connexion,facturaproveedorservicio));
				TipoMovimientoModuloLogic tipomovimientomoduloLogic= new TipoMovimientoModuloLogic(connexion);
				tipomovimientomoduloLogic.deepLoad(facturaproveedorservicio.getTipoMovimientoModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				facturaproveedorservicio.setTipoTransaccionModulo(facturaproveedorservicioDataAccess.getTipoTransaccionModulo(connexion,facturaproveedorservicio));
				TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
				tipotransaccionmoduloLogic.deepLoad(facturaproveedorservicio.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);				
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
			facturaproveedorservicio.setEmpresa(facturaproveedorservicioDataAccess.getEmpresa(connexion,facturaproveedorservicio));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(facturaproveedorservicio.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedorservicio.setSucursal(facturaproveedorservicioDataAccess.getSucursal(connexion,facturaproveedorservicio));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(facturaproveedorservicio.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedorservicio.setEjercicio(facturaproveedorservicioDataAccess.getEjercicio(connexion,facturaproveedorservicio));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(facturaproveedorservicio.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedorservicio.setPeriodo(facturaproveedorservicioDataAccess.getPeriodo(connexion,facturaproveedorservicio));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(facturaproveedorservicio.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedorservicio.setAnio(facturaproveedorservicioDataAccess.getAnio(connexion,facturaproveedorservicio));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(facturaproveedorservicio.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedorservicio.setMes(facturaproveedorservicioDataAccess.getMes(connexion,facturaproveedorservicio));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(facturaproveedorservicio.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedorservicio.setModulo(facturaproveedorservicioDataAccess.getModulo(connexion,facturaproveedorservicio));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(facturaproveedorservicio.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedorservicio.setTransaccion(facturaproveedorservicioDataAccess.getTransaccion(connexion,facturaproveedorservicio));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(facturaproveedorservicio.getTransaccion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedorservicio.setFactura(facturaproveedorservicioDataAccess.getFactura(connexion,facturaproveedorservicio));
			FacturaLogic facturaLogic= new FacturaLogic(connexion);
			facturaLogic.deepLoad(facturaproveedorservicio.getFactura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedorservicio.setCliente(facturaproveedorservicioDataAccess.getCliente(connexion,facturaproveedorservicio));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(facturaproveedorservicio.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDocumento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedorservicio.setTipoDocumento(facturaproveedorservicioDataAccess.getTipoDocumento(connexion,facturaproveedorservicio));
			TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
			tipodocumentoLogic.deepLoad(facturaproveedorservicio.getTipoDocumento(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedorservicio.setEmpleadoSolicita(facturaproveedorservicioDataAccess.getEmpleadoSolicita(connexion,facturaproveedorservicio));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(facturaproveedorservicio.getEmpleadoSolicita(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedorservicio.setEmpleado(facturaproveedorservicioDataAccess.getEmpleado(connexion,facturaproveedorservicio));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(facturaproveedorservicio.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTributario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedorservicio.setTipoTributario(facturaproveedorservicioDataAccess.getTipoTributario(connexion,facturaproveedorservicio));
			TipoTributarioLogic tipotributarioLogic= new TipoTributarioLogic(connexion);
			tipotributarioLogic.deepLoad(facturaproveedorservicio.getTipoTributario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedorservicio.setMoneda(facturaproveedorservicioDataAccess.getMoneda(connexion,facturaproveedorservicio));
			MonedaLogic monedaLogic= new MonedaLogic(connexion);
			monedaLogic.deepLoad(facturaproveedorservicio.getMoneda(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedorservicio.setTipoRetencionFuente1(facturaproveedorservicioDataAccess.getTipoRetencionFuente1(connexion,facturaproveedorservicio));
			TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
			tiporetencionLogic.deepLoad(facturaproveedorservicio.getTipoRetencionFuente1(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedorservicio.setTipoRetencionIva1(facturaproveedorservicioDataAccess.getTipoRetencionIva1(connexion,facturaproveedorservicio));
			TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
			tiporetencionLogic.deepLoad(facturaproveedorservicio.getTipoRetencionIva1(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedorservicio.setCuentaContableCreditoFiscalServicios(facturaproveedorservicioDataAccess.getCuentaContableCreditoFiscalServicios(connexion,facturaproveedorservicio));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(facturaproveedorservicio.getCuentaContableCreditoFiscalServicios(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimiento.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedorservicio.setTipoMovimiento(facturaproveedorservicioDataAccess.getTipoMovimiento(connexion,facturaproveedorservicio));
			TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
			tipomovimientoLogic.deepLoad(facturaproveedorservicio.getTipoMovimiento(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedorservicio.setTipoMovimientoModulo(facturaproveedorservicioDataAccess.getTipoMovimientoModulo(connexion,facturaproveedorservicio));
			TipoMovimientoModuloLogic tipomovimientomoduloLogic= new TipoMovimientoModuloLogic(connexion);
			tipomovimientomoduloLogic.deepLoad(facturaproveedorservicio.getTipoMovimientoModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			facturaproveedorservicio.setTipoTransaccionModulo(facturaproveedorservicioDataAccess.getTipoTransaccionModulo(connexion,facturaproveedorservicio));
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
			tipotransaccionmoduloLogic.deepLoad(facturaproveedorservicio.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(FacturaProveedorServicio facturaproveedorservicio,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			FacturaProveedorServicioLogicAdditional.updateFacturaProveedorServicioToSave(facturaproveedorservicio,this.arrDatoGeneral);
			
FacturaProveedorServicioDataAccess.save(facturaproveedorservicio, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(facturaproveedorservicio.getEmpresa(),connexion);

		SucursalDataAccess.save(facturaproveedorservicio.getSucursal(),connexion);

		EjercicioDataAccess.save(facturaproveedorservicio.getEjercicio(),connexion);

		PeriodoDataAccess.save(facturaproveedorservicio.getPeriodo(),connexion);

		AnioDataAccess.save(facturaproveedorservicio.getAnio(),connexion);

		MesDataAccess.save(facturaproveedorservicio.getMes(),connexion);

		ModuloDataAccess.save(facturaproveedorservicio.getModulo(),connexion);

		TransaccionDataAccess.save(facturaproveedorservicio.getTransaccion(),connexion);

		FacturaDataAccess.save(facturaproveedorservicio.getFactura(),connexion);

		ClienteDataAccess.save(facturaproveedorservicio.getCliente(),connexion);

		TipoDocumentoDataAccess.save(facturaproveedorservicio.getTipoDocumento(),connexion);

		EmpleadoDataAccess.save(facturaproveedorservicio.getEmpleadoSolicita(),connexion);

		EmpleadoDataAccess.save(facturaproveedorservicio.getEmpleado(),connexion);

		TipoTributarioDataAccess.save(facturaproveedorservicio.getTipoTributario(),connexion);

		MonedaDataAccess.save(facturaproveedorservicio.getMoneda(),connexion);

		TipoRetencionDataAccess.save(facturaproveedorservicio.getTipoRetencionFuente1(),connexion);

		TipoRetencionDataAccess.save(facturaproveedorservicio.getTipoRetencionIva1(),connexion);

		CuentaContableDataAccess.save(facturaproveedorservicio.getCuentaContableCreditoFiscalServicios(),connexion);

		TipoMovimientoDataAccess.save(facturaproveedorservicio.getTipoMovimiento(),connexion);

		TipoMovimientoModuloDataAccess.save(facturaproveedorservicio.getTipoMovimientoModulo(),connexion);

		TipoTransaccionModuloDataAccess.save(facturaproveedorservicio.getTipoTransaccionModulo(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(facturaproveedorservicio.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(facturaproveedorservicio.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(facturaproveedorservicio.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(facturaproveedorservicio.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(facturaproveedorservicio.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(facturaproveedorservicio.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(facturaproveedorservicio.getModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(facturaproveedorservicio.getTransaccion(),connexion);
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(facturaproveedorservicio.getFactura(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(facturaproveedorservicio.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				TipoDocumentoDataAccess.save(facturaproveedorservicio.getTipoDocumento(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(facturaproveedorservicio.getEmpleadoSolicita(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(facturaproveedorservicio.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoTributario.class)) {
				TipoTributarioDataAccess.save(facturaproveedorservicio.getTipoTributario(),connexion);
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(facturaproveedorservicio.getMoneda(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				TipoRetencionDataAccess.save(facturaproveedorservicio.getTipoRetencionFuente1(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				TipoRetencionDataAccess.save(facturaproveedorservicio.getTipoRetencionIva1(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(facturaproveedorservicio.getCuentaContableCreditoFiscalServicios(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				TipoMovimientoDataAccess.save(facturaproveedorservicio.getTipoMovimiento(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				TipoMovimientoModuloDataAccess.save(facturaproveedorservicio.getTipoMovimientoModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				TipoTransaccionModuloDataAccess.save(facturaproveedorservicio.getTipoTransaccionModulo(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(facturaproveedorservicio.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(facturaproveedorservicio.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(facturaproveedorservicio.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(facturaproveedorservicio.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(facturaproveedorservicio.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(facturaproveedorservicio.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(facturaproveedorservicio.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(facturaproveedorservicio.getPeriodo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(facturaproveedorservicio.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(facturaproveedorservicio.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(facturaproveedorservicio.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(facturaproveedorservicio.getMes(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(facturaproveedorservicio.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(facturaproveedorservicio.getModulo(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(facturaproveedorservicio.getTransaccion(),connexion);
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(facturaproveedorservicio.getTransaccion(),isDeep,deepLoadType,clases);
				

		FacturaDataAccess.save(facturaproveedorservicio.getFactura(),connexion);
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(facturaproveedorservicio.getFactura(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(facturaproveedorservicio.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(facturaproveedorservicio.getCliente(),isDeep,deepLoadType,clases);
				

		TipoDocumentoDataAccess.save(facturaproveedorservicio.getTipoDocumento(),connexion);
		TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
		tipodocumentoLogic.deepLoad(facturaproveedorservicio.getTipoDocumento(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(facturaproveedorservicio.getEmpleadoSolicita(),connexion);
		EmpleadoLogic empleadosolicitaLogic= new EmpleadoLogic(connexion);
		empleadosolicitaLogic.deepLoad(facturaproveedorservicio.getEmpleadoSolicita(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(facturaproveedorservicio.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(facturaproveedorservicio.getEmpleado(),isDeep,deepLoadType,clases);
				

		TipoTributarioDataAccess.save(facturaproveedorservicio.getTipoTributario(),connexion);
		TipoTributarioLogic tipotributarioLogic= new TipoTributarioLogic(connexion);
		tipotributarioLogic.deepLoad(facturaproveedorservicio.getTipoTributario(),isDeep,deepLoadType,clases);
				

		MonedaDataAccess.save(facturaproveedorservicio.getMoneda(),connexion);
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(facturaproveedorservicio.getMoneda(),isDeep,deepLoadType,clases);
				

		TipoRetencionDataAccess.save(facturaproveedorservicio.getTipoRetencionFuente1(),connexion);
		TipoRetencionLogic tiporetencionfuente1Logic= new TipoRetencionLogic(connexion);
		tiporetencionfuente1Logic.deepLoad(facturaproveedorservicio.getTipoRetencionFuente1(),isDeep,deepLoadType,clases);
				

		TipoRetencionDataAccess.save(facturaproveedorservicio.getTipoRetencionIva1(),connexion);
		TipoRetencionLogic tiporetencioniva1Logic= new TipoRetencionLogic(connexion);
		tiporetencioniva1Logic.deepLoad(facturaproveedorservicio.getTipoRetencionIva1(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(facturaproveedorservicio.getCuentaContableCreditoFiscalServicios(),connexion);
		CuentaContableLogic cuentacontablecreditofiscalserviciosLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditofiscalserviciosLogic.deepLoad(facturaproveedorservicio.getCuentaContableCreditoFiscalServicios(),isDeep,deepLoadType,clases);
				

		TipoMovimientoDataAccess.save(facturaproveedorservicio.getTipoMovimiento(),connexion);
		TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
		tipomovimientoLogic.deepLoad(facturaproveedorservicio.getTipoMovimiento(),isDeep,deepLoadType,clases);
				

		TipoMovimientoModuloDataAccess.save(facturaproveedorservicio.getTipoMovimientoModulo(),connexion);
		TipoMovimientoModuloLogic tipomovimientomoduloLogic= new TipoMovimientoModuloLogic(connexion);
		tipomovimientomoduloLogic.deepLoad(facturaproveedorservicio.getTipoMovimientoModulo(),isDeep,deepLoadType,clases);
				

		TipoTransaccionModuloDataAccess.save(facturaproveedorservicio.getTipoTransaccionModulo(),connexion);
		TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
		tipotransaccionmoduloLogic.deepLoad(facturaproveedorservicio.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(facturaproveedorservicio.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(facturaproveedorservicio.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(facturaproveedorservicio.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(facturaproveedorservicio.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(facturaproveedorservicio.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(facturaproveedorservicio.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(facturaproveedorservicio.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(facturaproveedorservicio.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(facturaproveedorservicio.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(facturaproveedorservicio.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(facturaproveedorservicio.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(facturaproveedorservicio.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(facturaproveedorservicio.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(facturaproveedorservicio.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(facturaproveedorservicio.getTransaccion(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(facturaproveedorservicio.getTransaccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(facturaproveedorservicio.getFactura(),connexion);
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepSave(facturaproveedorservicio.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(facturaproveedorservicio.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(facturaproveedorservicio.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDocumento.class)) {
				TipoDocumentoDataAccess.save(facturaproveedorservicio.getTipoDocumento(),connexion);
				TipoDocumentoLogic tipodocumentoLogic= new TipoDocumentoLogic(connexion);
				tipodocumentoLogic.deepSave(facturaproveedorservicio.getTipoDocumento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(facturaproveedorservicio.getEmpleadoSolicita(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(facturaproveedorservicio.getEmpleadoSolicita(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(facturaproveedorservicio.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(facturaproveedorservicio.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTributario.class)) {
				TipoTributarioDataAccess.save(facturaproveedorservicio.getTipoTributario(),connexion);
				TipoTributarioLogic tipotributarioLogic= new TipoTributarioLogic(connexion);
				tipotributarioLogic.deepSave(facturaproveedorservicio.getTipoTributario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(facturaproveedorservicio.getMoneda(),connexion);
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepSave(facturaproveedorservicio.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				TipoRetencionDataAccess.save(facturaproveedorservicio.getTipoRetencionFuente1(),connexion);
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepSave(facturaproveedorservicio.getTipoRetencionFuente1(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				TipoRetencionDataAccess.save(facturaproveedorservicio.getTipoRetencionIva1(),connexion);
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepSave(facturaproveedorservicio.getTipoRetencionIva1(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(facturaproveedorservicio.getCuentaContableCreditoFiscalServicios(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(facturaproveedorservicio.getCuentaContableCreditoFiscalServicios(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMovimiento.class)) {
				TipoMovimientoDataAccess.save(facturaproveedorservicio.getTipoMovimiento(),connexion);
				TipoMovimientoLogic tipomovimientoLogic= new TipoMovimientoLogic(connexion);
				tipomovimientoLogic.deepSave(facturaproveedorservicio.getTipoMovimiento(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoMovimientoModulo.class)) {
				TipoMovimientoModuloDataAccess.save(facturaproveedorservicio.getTipoMovimientoModulo(),connexion);
				TipoMovimientoModuloLogic tipomovimientomoduloLogic= new TipoMovimientoModuloLogic(connexion);
				tipomovimientomoduloLogic.deepSave(facturaproveedorservicio.getTipoMovimientoModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				TipoTransaccionModuloDataAccess.save(facturaproveedorservicio.getTipoTransaccionModulo(),connexion);
				TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
				tipotransaccionmoduloLogic.deepSave(facturaproveedorservicio.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(FacturaProveedorServicio.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(facturaproveedorservicio,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(facturaproveedorservicio);
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
			this.deepLoad(this.facturaproveedorservicio,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(FacturaProveedorServicio.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(facturaproveedorservicios!=null) {
				for(FacturaProveedorServicio facturaproveedorservicio:facturaproveedorservicios) {
					this.deepLoad(facturaproveedorservicio,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(facturaproveedorservicios);
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
			if(facturaproveedorservicios!=null) {
				for(FacturaProveedorServicio facturaproveedorservicio:facturaproveedorservicios) {
					this.deepLoad(facturaproveedorservicio,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(facturaproveedorservicios);
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
			this.getNewConnexionToDeep(FacturaProveedorServicio.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(facturaproveedorservicio,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(FacturaProveedorServicio.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(facturaproveedorservicios!=null) {
				for(FacturaProveedorServicio facturaproveedorservicio:facturaproveedorservicios) {
					this.deepSave(facturaproveedorservicio,isDeep,deepLoadType,clases);
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
			if(facturaproveedorservicios!=null) {
				for(FacturaProveedorServicio facturaproveedorservicio:facturaproveedorservicios) {
					this.deepSave(facturaproveedorservicio,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getFacturaProveedorServiciosFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedorServicio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,FacturaProveedorServicioConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorServiciosFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,FacturaProveedorServicioConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorServiciosFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedorServicio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,FacturaProveedorServicioConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorServiciosFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,FacturaProveedorServicioConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorServiciosFK_IdCuentaContableCreditoFiscalServiciosWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito_fiscal_servicios)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedorServicio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCreditoFiscalServicios= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCreditoFiscalServicios.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito_fiscal_servicios,FacturaProveedorServicioConstantesFunciones.IDCUENTACONTABLECREDITOFISCALSERVICIOS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCreditoFiscalServicios);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCreditoFiscalServicios","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorServiciosFK_IdCuentaContableCreditoFiscalServicios(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito_fiscal_servicios)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCreditoFiscalServicios= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCreditoFiscalServicios.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito_fiscal_servicios,FacturaProveedorServicioConstantesFunciones.IDCUENTACONTABLECREDITOFISCALSERVICIOS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCreditoFiscalServicios);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCreditoFiscalServicios","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorServiciosFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedorServicio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,FacturaProveedorServicioConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorServiciosFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,FacturaProveedorServicioConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorServiciosFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedorServicio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,FacturaProveedorServicioConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorServiciosFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,FacturaProveedorServicioConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorServiciosFK_IdEmpleadoSolicitaWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado_solicita)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedorServicio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleadoSolicita= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleadoSolicita.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado_solicita,FacturaProveedorServicioConstantesFunciones.IDEMPLEADOSOLICITA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleadoSolicita);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleadoSolicita","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorServiciosFK_IdEmpleadoSolicita(String sFinalQuery,Pagination pagination,Long id_empleado_solicita)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleadoSolicita= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleadoSolicita.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado_solicita,FacturaProveedorServicioConstantesFunciones.IDEMPLEADOSOLICITA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleadoSolicita);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleadoSolicita","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorServiciosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedorServicio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FacturaProveedorServicioConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorServiciosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FacturaProveedorServicioConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorServiciosFK_IdFacturaWithConnection(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedorServicio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,FacturaProveedorServicioConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorServiciosFK_IdFactura(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,FacturaProveedorServicioConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorServiciosFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedorServicio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,FacturaProveedorServicioConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorServiciosFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,FacturaProveedorServicioConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorServiciosFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedorServicio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,FacturaProveedorServicioConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorServiciosFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,FacturaProveedorServicioConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorServiciosFK_IdMonedaWithConnection(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedorServicio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,FacturaProveedorServicioConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorServiciosFK_IdMoneda(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,FacturaProveedorServicioConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorServiciosFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedorServicio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,FacturaProveedorServicioConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorServiciosFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,FacturaProveedorServicioConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorServiciosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedorServicio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,FacturaProveedorServicioConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorServiciosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,FacturaProveedorServicioConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorServiciosFK_IdTipoDocumentoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_documento)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedorServicio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento,FacturaProveedorServicioConstantesFunciones.IDTIPODOCUMENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumento);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDocumento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorServiciosFK_IdTipoDocumento(String sFinalQuery,Pagination pagination,Long id_tipo_documento)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDocumento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDocumento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_documento,FacturaProveedorServicioConstantesFunciones.IDTIPODOCUMENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDocumento);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDocumento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorServiciosFK_IdTipoMovimientoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_movimiento)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedorServicio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimiento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimiento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento,FacturaProveedorServicioConstantesFunciones.IDTIPOMOVIMIENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimiento);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMovimiento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorServiciosFK_IdTipoMovimiento(String sFinalQuery,Pagination pagination,Long id_tipo_movimiento)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimiento= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimiento.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento,FacturaProveedorServicioConstantesFunciones.IDTIPOMOVIMIENTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimiento);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMovimiento","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorServiciosFK_IdTipoMovimientoModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_movimiento_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedorServicio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimientoModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimientoModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento_modulo,FacturaProveedorServicioConstantesFunciones.IDTIPOMOVIMIENTOMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimientoModulo);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMovimientoModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorServiciosFK_IdTipoMovimientoModulo(String sFinalQuery,Pagination pagination,Long id_tipo_movimiento_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoMovimientoModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoMovimientoModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_movimiento_modulo,FacturaProveedorServicioConstantesFunciones.IDTIPOMOVIMIENTOMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoMovimientoModulo);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoMovimientoModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorServiciosFK_IdTipoRetencionFuente1WithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_retencion_fuente1)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedorServicio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencionFuente1= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencionFuente1.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion_fuente1,FacturaProveedorServicioConstantesFunciones.IDTIPORETENCIONFUENTE1,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencionFuente1);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencionFuente1","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorServiciosFK_IdTipoRetencionFuente1(String sFinalQuery,Pagination pagination,Long id_tipo_retencion_fuente1)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencionFuente1= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencionFuente1.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion_fuente1,FacturaProveedorServicioConstantesFunciones.IDTIPORETENCIONFUENTE1,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencionFuente1);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencionFuente1","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorServiciosFK_IdTipoRetencionIva1WithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_retencion_iva1)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedorServicio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencionIva1= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencionIva1.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion_iva1,FacturaProveedorServicioConstantesFunciones.IDTIPORETENCIONIVA1,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencionIva1);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencionIva1","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorServiciosFK_IdTipoRetencionIva1(String sFinalQuery,Pagination pagination,Long id_tipo_retencion_iva1)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencionIva1= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencionIva1.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion_iva1,FacturaProveedorServicioConstantesFunciones.IDTIPORETENCIONIVA1,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencionIva1);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencionIva1","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorServiciosFK_IdTipoTransaccionModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_transaccion_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedorServicio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransaccionModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransaccionModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transaccion_modulo,FacturaProveedorServicioConstantesFunciones.IDTIPOTRANSACCIONMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransaccionModulo);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTransaccionModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorServiciosFK_IdTipoTransaccionModulo(String sFinalQuery,Pagination pagination,Long id_tipo_transaccion_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransaccionModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransaccionModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transaccion_modulo,FacturaProveedorServicioConstantesFunciones.IDTIPOTRANSACCIONMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransaccionModulo);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTransaccionModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorServiciosFK_IdTipoTributarioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_tributario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedorServicio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTributario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTributario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_tributario,FacturaProveedorServicioConstantesFunciones.IDTIPOTRIBUTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTributario);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTributario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorServiciosFK_IdTipoTributario(String sFinalQuery,Pagination pagination,Long id_tipo_tributario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTributario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTributario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_tributario,FacturaProveedorServicioConstantesFunciones.IDTIPOTRIBUTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTributario);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTributario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFacturaProveedorServiciosFK_IdTransaccionWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FacturaProveedorServicio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion,FacturaProveedorServicioConstantesFunciones.IDTRANSACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFacturaProveedorServiciosFK_IdTransaccion(String sFinalQuery,Pagination pagination,Long id_transaccion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion,FacturaProveedorServicioConstantesFunciones.IDTRANSACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion);

			FacturaProveedorServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			facturaproveedorservicios=facturaproveedorservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FacturaProveedorServicioConstantesFunciones.refrescarForeignKeysDescripcionesFacturaProveedorServicio(this.facturaproveedorservicios);
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
			if(FacturaProveedorServicioConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,FacturaProveedorServicioDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,FacturaProveedorServicio facturaproveedorservicio,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(FacturaProveedorServicioConstantesFunciones.ISCONAUDITORIA) {
				if(facturaproveedorservicio.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FacturaProveedorServicioDataAccess.TABLENAME, facturaproveedorservicio.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FacturaProveedorServicioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FacturaProveedorServicioLogic.registrarAuditoriaDetallesFacturaProveedorServicio(connexion,facturaproveedorservicio,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(facturaproveedorservicio.getIsDeleted()) {
					/*if(!facturaproveedorservicio.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,FacturaProveedorServicioDataAccess.TABLENAME, facturaproveedorservicio.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////FacturaProveedorServicioLogic.registrarAuditoriaDetallesFacturaProveedorServicio(connexion,facturaproveedorservicio,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FacturaProveedorServicioDataAccess.TABLENAME, facturaproveedorservicio.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(facturaproveedorservicio.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FacturaProveedorServicioDataAccess.TABLENAME, facturaproveedorservicio.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FacturaProveedorServicioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FacturaProveedorServicioLogic.registrarAuditoriaDetallesFacturaProveedorServicio(connexion,facturaproveedorservicio,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesFacturaProveedorServicio(Connexion connexion,FacturaProveedorServicio facturaproveedorservicio)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getid_empresa().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_empresa()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_empresa().toString();
				}
				if(facturaproveedorservicio.getid_empresa()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getid_sucursal().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_sucursal()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_sucursal().toString();
				}
				if(facturaproveedorservicio.getid_sucursal()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getid_ejercicio().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_ejercicio()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_ejercicio().toString();
				}
				if(facturaproveedorservicio.getid_ejercicio()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getid_periodo().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_periodo()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_periodo().toString();
				}
				if(facturaproveedorservicio.getid_periodo()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getid_anio().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_anio()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_anio().toString();
				}
				if(facturaproveedorservicio.getid_anio()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getid_mes().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_mes()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_mes().toString();
				}
				if(facturaproveedorservicio.getid_mes()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getid_modulo().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_modulo()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_modulo().toString();
				}
				if(facturaproveedorservicio.getid_modulo()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getid_transaccion().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_transaccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_transaccion()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_transaccion().toString();
				}
				if(facturaproveedorservicio.getid_transaccion()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getid_transaccion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.IDTRANSACCION,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getid_factura().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_factura()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_factura().toString();
				}
				if(facturaproveedorservicio.getid_factura()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getid_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.IDFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getnumero_factura().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getnumero_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getnumero_factura()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getnumero_factura();
				}
				if(facturaproveedorservicio.getnumero_factura()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getnumero_factura() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.NUMEROFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getid_cliente().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_cliente()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_cliente().toString();
				}
				if(facturaproveedorservicio.getid_cliente()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getruc().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getruc()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getruc()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getruc();
				}
				if(facturaproveedorservicio.getruc()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getruc() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.RUC,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getid_tipo_documento().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_tipo_documento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_tipo_documento()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_tipo_documento().toString();
				}
				if(facturaproveedorservicio.getid_tipo_documento()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getid_tipo_documento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.IDTIPODOCUMENTO,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getplazo().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getplazo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getplazo()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getplazo().toString();
				}
				if(facturaproveedorservicio.getplazo()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getplazo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.PLAZO,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getcon_rise().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getcon_rise()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getcon_rise()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getcon_rise().toString();
				}
				if(facturaproveedorservicio.getcon_rise()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getcon_rise().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.CONRISE,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getfecha_emision().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getfecha_emision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getfecha_emision()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getfecha_emision().toString();
				}
				if(facturaproveedorservicio.getfecha_emision()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getfecha_emision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.FECHAEMISION,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getfecha_vence().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getfecha_vence()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getfecha_vence()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getfecha_vence().toString();
				}
				if(facturaproveedorservicio.getfecha_vence()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getfecha_vence().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.FECHAVENCE,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getid_empleado_solicita().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_empleado_solicita()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_empleado_solicita()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_empleado_solicita().toString();
				}
				if(facturaproveedorservicio.getid_empleado_solicita()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getid_empleado_solicita().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.IDEMPLEADOSOLICITA,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getid_empleado().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_empleado()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_empleado().toString();
				}
				if(facturaproveedorservicio.getid_empleado()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getdetalle().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getdetalle()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getdetalle()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getdetalle();
				}
				if(facturaproveedorservicio.getdetalle()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getdetalle() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.DETALLE,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getnumero_retencion().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getnumero_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getnumero_retencion()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getnumero_retencion();
				}
				if(facturaproveedorservicio.getnumero_retencion()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getnumero_retencion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.NUMERORETENCION,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getnumero_autorizacion().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getnumero_autorizacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getnumero_autorizacion()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getnumero_autorizacion();
				}
				if(facturaproveedorservicio.getnumero_autorizacion()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getnumero_autorizacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.NUMEROAUTORIZACION,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getnumero_serie().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getnumero_serie()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getnumero_serie()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getnumero_serie();
				}
				if(facturaproveedorservicio.getnumero_serie()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getnumero_serie() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.NUMEROSERIE,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getid_tipo_tributario().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_tipo_tributario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_tipo_tributario()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_tipo_tributario().toString();
				}
				if(facturaproveedorservicio.getid_tipo_tributario()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getid_tipo_tributario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.IDTIPOTRIBUTARIO,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getfecha_validez().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getfecha_validez()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getfecha_validez()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getfecha_validez().toString();
				}
				if(facturaproveedorservicio.getfecha_validez()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getfecha_validez().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.FECHAVALIDEZ,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getanexo_factura_inicio().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getanexo_factura_inicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getanexo_factura_inicio()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getanexo_factura_inicio();
				}
				if(facturaproveedorservicio.getanexo_factura_inicio()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getanexo_factura_inicio() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.ANEXOFACTURAINICIO,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getanexo_factura_fin().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getanexo_factura_fin()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getanexo_factura_fin()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getanexo_factura_fin();
				}
				if(facturaproveedorservicio.getanexo_factura_fin()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getanexo_factura_fin() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.ANEXOFACTURAFIN,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getid_moneda().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_moneda()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_moneda()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_moneda().toString();
				}
				if(facturaproveedorservicio.getid_moneda()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getid_moneda().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.IDMONEDA,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getvalor_servicios0().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getvalor_servicios0()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getvalor_servicios0()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getvalor_servicios0().toString();
				}
				if(facturaproveedorservicio.getvalor_servicios0()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getvalor_servicios0().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.VALORSERVICIOS0,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.gettotal_iva().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().gettotal_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().gettotal_iva()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().gettotal_iva().toString();
				}
				if(facturaproveedorservicio.gettotal_iva()!=null)
				{
					strValorNuevo=facturaproveedorservicio.gettotal_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.TOTALIVA,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getiva_porcentaje().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getiva_porcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getiva_porcentaje()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getiva_porcentaje().toString();
				}
				if(facturaproveedorservicio.getiva_porcentaje()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getiva_porcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.IVAPORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.gettotal().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().gettotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().gettotal()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().gettotal().toString();
				}
				if(facturaproveedorservicio.gettotal()!=null)
				{
					strValorNuevo=facturaproveedorservicio.gettotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.TOTAL,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getnumero_mayor().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getnumero_mayor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getnumero_mayor()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getnumero_mayor();
				}
				if(facturaproveedorservicio.getnumero_mayor()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getnumero_mayor() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.NUMEROMAYOR,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getcodigo_asiento().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getcodigo_asiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getcodigo_asiento()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getcodigo_asiento();
				}
				if(facturaproveedorservicio.getcodigo_asiento()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getcodigo_asiento() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.CODIGOASIENTO,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getid_tipo_retencion_fuente1().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_tipo_retencion_fuente1()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_tipo_retencion_fuente1()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_tipo_retencion_fuente1().toString();
				}
				if(facturaproveedorservicio.getid_tipo_retencion_fuente1()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getid_tipo_retencion_fuente1().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.IDTIPORETENCIONFUENTE1,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getid_tipo_retencion_iva1().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_tipo_retencion_iva1()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_tipo_retencion_iva1()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_tipo_retencion_iva1().toString();
				}
				if(facturaproveedorservicio.getid_tipo_retencion_iva1()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getid_tipo_retencion_iva1().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.IDTIPORETENCIONIVA1,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getanexo_numero_autorizacion().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getanexo_numero_autorizacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getanexo_numero_autorizacion()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getanexo_numero_autorizacion();
				}
				if(facturaproveedorservicio.getanexo_numero_autorizacion()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getanexo_numero_autorizacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.ANEXONUMEROAUTORIZACION,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getanexo_numeso_serie().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getanexo_numeso_serie()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getanexo_numeso_serie()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getanexo_numeso_serie();
				}
				if(facturaproveedorservicio.getanexo_numeso_serie()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getanexo_numeso_serie() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.ANEXONUMESOSERIE,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getanexo_fecha_validez().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getanexo_fecha_validez()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getanexo_fecha_validez()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getanexo_fecha_validez().toString();
				}
				if(facturaproveedorservicio.getanexo_fecha_validez()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getanexo_fecha_validez().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.ANEXOFECHAVALIDEZ,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getid_cuenta_contable_credito_fiscal_servicios().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_cuenta_contable_credito_fiscal_servicios()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_cuenta_contable_credito_fiscal_servicios()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_cuenta_contable_credito_fiscal_servicios().toString();
				}
				if(facturaproveedorservicio.getid_cuenta_contable_credito_fiscal_servicios()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getid_cuenta_contable_credito_fiscal_servicios().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.IDCUENTACONTABLECREDITOFISCALSERVICIOS,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getdescripcion().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getdescripcion()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getdescripcion();
				}
				if(facturaproveedorservicio.getdescripcion()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getid_tipo_movimiento().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_tipo_movimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_tipo_movimiento()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_tipo_movimiento().toString();
				}
				if(facturaproveedorservicio.getid_tipo_movimiento()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getid_tipo_movimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.IDTIPOMOVIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getid_tipo_movimiento_modulo().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_tipo_movimiento_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_tipo_movimiento_modulo()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_tipo_movimiento_modulo().toString();
				}
				if(facturaproveedorservicio.getid_tipo_movimiento_modulo()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getid_tipo_movimiento_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.IDTIPOMOVIMIENTOMODULO,strValorActual,strValorNuevo);
			}	
			
			if(facturaproveedorservicio.getIsNew()||!facturaproveedorservicio.getid_tipo_transaccion_modulo().equals(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_tipo_transaccion_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_tipo_transaccion_modulo()!=null)
				{
					strValorActual=facturaproveedorservicio.getFacturaProveedorServicioOriginal().getid_tipo_transaccion_modulo().toString();
				}
				if(facturaproveedorservicio.getid_tipo_transaccion_modulo()!=null)
				{
					strValorNuevo=facturaproveedorservicio.getid_tipo_transaccion_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FacturaProveedorServicioConstantesFunciones.IDTIPOTRANSACCIONMODULO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveFacturaProveedorServicioRelacionesWithConnection(FacturaProveedorServicio facturaproveedorservicio) throws Exception {

		if(!facturaproveedorservicio.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFacturaProveedorServicioRelacionesBase(facturaproveedorservicio,true);
		}
	}

	public void saveFacturaProveedorServicioRelaciones(FacturaProveedorServicio facturaproveedorservicio)throws Exception {

		if(!facturaproveedorservicio.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFacturaProveedorServicioRelacionesBase(facturaproveedorservicio,false);
		}
	}

	public void saveFacturaProveedorServicioRelacionesBase(FacturaProveedorServicio facturaproveedorservicio,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("FacturaProveedorServicio-saveRelacionesWithConnection");}
	

			this.setFacturaProveedorServicio(facturaproveedorservicio);

			if(FacturaProveedorServicioLogicAdditional.validarSaveRelaciones(facturaproveedorservicio,this)) {

				FacturaProveedorServicioLogicAdditional.updateRelacionesToSave(facturaproveedorservicio,this);

				if((facturaproveedorservicio.getIsNew()||facturaproveedorservicio.getIsChanged())&&!facturaproveedorservicio.getIsDeleted()) {
					this.saveFacturaProveedorServicio();
					this.saveFacturaProveedorServicioRelacionesDetalles();

				} else if(facturaproveedorservicio.getIsDeleted()) {
					this.saveFacturaProveedorServicioRelacionesDetalles();
					this.saveFacturaProveedorServicio();
				}

				FacturaProveedorServicioLogicAdditional.updateRelacionesToSaveAfter(facturaproveedorservicio,this);

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
	
	
	private void saveFacturaProveedorServicioRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfFacturaProveedorServicio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FacturaProveedorServicioConstantesFunciones.getClassesForeignKeysOfFacturaProveedorServicio(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFacturaProveedorServicio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FacturaProveedorServicioConstantesFunciones.getClassesRelationshipsOfFacturaProveedorServicio(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

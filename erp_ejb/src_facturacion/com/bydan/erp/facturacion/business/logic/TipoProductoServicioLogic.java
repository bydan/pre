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
import com.bydan.erp.facturacion.util.TipoProductoServicioConstantesFunciones;
import com.bydan.erp.facturacion.util.TipoProductoServicioParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.TipoProductoServicioParameterGeneral;
import com.bydan.erp.facturacion.business.entity.TipoProductoServicio;
//import com.bydan.erp.facturacion.business.logic.TipoProductoServicioLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;


import com.bydan.erp.inventario.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoProductoServicioLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoProductoServicioLogic.class);
	
	protected TipoProductoServicioDataAccess tipoproductoservicioDataAccess; 	
	protected TipoProductoServicio tipoproductoservicio;
	protected List<TipoProductoServicio> tipoproductoservicios;
	protected Object tipoproductoservicioObject;	
	protected List<Object> tipoproductoserviciosObject;
	
	public static ClassValidator<TipoProductoServicio> tipoproductoservicioValidator = new ClassValidator<TipoProductoServicio>(TipoProductoServicio.class);	
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
	
	
	
	
	public  TipoProductoServicioLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoproductoservicioDataAccess = new TipoProductoServicioDataAccess();
			
			this.tipoproductoservicios= new ArrayList<TipoProductoServicio>();
			this.tipoproductoservicio= new TipoProductoServicio();
			
			this.tipoproductoservicioObject=new Object();
			this.tipoproductoserviciosObject=new ArrayList<Object>();
				
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
			
			this.tipoproductoservicioDataAccess.setConnexionType(this.connexionType);
			this.tipoproductoservicioDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoProductoServicioLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoproductoservicioDataAccess = new TipoProductoServicioDataAccess();
			this.tipoproductoservicios= new ArrayList<TipoProductoServicio>();
			this.tipoproductoservicio= new TipoProductoServicio();
			this.tipoproductoservicioObject=new Object();
			this.tipoproductoserviciosObject=new ArrayList<Object>();
			
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
			
			this.tipoproductoservicioDataAccess.setConnexionType(this.connexionType);
			this.tipoproductoservicioDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoProductoServicio getTipoProductoServicio() throws Exception {	
		//TipoProductoServicioLogicAdditional.checkTipoProductoServicioToGet(tipoproductoservicio,this.datosCliente,this.arrDatoGeneral);
		//TipoProductoServicioLogicAdditional.updateTipoProductoServicioToGet(tipoproductoservicio,this.arrDatoGeneral);
		
		return tipoproductoservicio;
	}
		
	public void setTipoProductoServicio(TipoProductoServicio newTipoProductoServicio) {
		this.tipoproductoservicio = newTipoProductoServicio;
	}
	
	public TipoProductoServicioDataAccess getTipoProductoServicioDataAccess() {
		return tipoproductoservicioDataAccess;
	}
	
	public void setTipoProductoServicioDataAccess(TipoProductoServicioDataAccess newtipoproductoservicioDataAccess) {
		this.tipoproductoservicioDataAccess = newtipoproductoservicioDataAccess;
	}
	
	public List<TipoProductoServicio> getTipoProductoServicios() throws Exception {		
		this.quitarTipoProductoServiciosNulos();
		
		//TipoProductoServicioLogicAdditional.checkTipoProductoServicioToGets(tipoproductoservicios,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoProductoServicio tipoproductoservicioLocal: tipoproductoservicios ) {
			//TipoProductoServicioLogicAdditional.updateTipoProductoServicioToGet(tipoproductoservicioLocal,this.arrDatoGeneral);
		}
		
		return tipoproductoservicios;
	}
	
	public void setTipoProductoServicios(List<TipoProductoServicio> newTipoProductoServicios) {
		this.tipoproductoservicios = newTipoProductoServicios;
	}
	
	public Object getTipoProductoServicioObject() {	
		this.tipoproductoservicioObject=this.tipoproductoservicioDataAccess.getEntityObject();
		return this.tipoproductoservicioObject;
	}
		
	public void setTipoProductoServicioObject(Object newTipoProductoServicioObject) {
		this.tipoproductoservicioObject = newTipoProductoServicioObject;
	}
	
	public List<Object> getTipoProductoServiciosObject() {		
		this.tipoproductoserviciosObject=this.tipoproductoservicioDataAccess.getEntitiesObject();
		return this.tipoproductoserviciosObject;
	}
		
	public void setTipoProductoServiciosObject(List<Object> newTipoProductoServiciosObject) {
		this.tipoproductoserviciosObject = newTipoProductoServiciosObject;
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
		
		if(this.tipoproductoservicioDataAccess!=null) {
			this.tipoproductoservicioDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProductoServicio.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoproductoservicioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoproductoservicioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoproductoservicio = new  TipoProductoServicio();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProductoServicio.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoproductoservicio=tipoproductoservicioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoproductoservicio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoProductoServicioConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicio(this.tipoproductoservicio);
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
		tipoproductoservicio = new  TipoProductoServicio();
		  		  
        try {
			
			tipoproductoservicio=tipoproductoservicioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoproductoservicio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoProductoServicioConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicio(this.tipoproductoservicio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoproductoservicio = new  TipoProductoServicio();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProductoServicio.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoproductoservicio=tipoproductoservicioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoproductoservicio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoProductoServicioConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicio(this.tipoproductoservicio);
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
		tipoproductoservicio = new  TipoProductoServicio();
		  		  
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
		tipoproductoservicio = new  TipoProductoServicio();
		  		  
        try {
			
			tipoproductoservicio=tipoproductoservicioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoproductoservicio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoProductoServicioConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicio(this.tipoproductoservicio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoproductoservicio = new  TipoProductoServicio();
		  		  
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
		tipoproductoservicio = new  TipoProductoServicio();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProductoServicio.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoproductoservicioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoproductoservicio = new  TipoProductoServicio();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoproductoservicioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoproductoservicio = new  TipoProductoServicio();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProductoServicio.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoproductoservicioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoproductoservicio = new  TipoProductoServicio();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoproductoservicioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoproductoservicio = new  TipoProductoServicio();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProductoServicio.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoproductoservicioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoproductoservicio = new  TipoProductoServicio();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoproductoservicioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoproductoservicios = new  ArrayList<TipoProductoServicio>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProductoServicio.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoProductoServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproductoservicios=tipoproductoservicioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoProductoServicio(tipoproductoservicios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProductoServicioConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicio(this.tipoproductoservicios);
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
		tipoproductoservicios = new  ArrayList<TipoProductoServicio>();
		  		  
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
		tipoproductoservicios = new  ArrayList<TipoProductoServicio>();
		  		  
        try {			
			TipoProductoServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproductoservicios=tipoproductoservicioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoProductoServicio(tipoproductoservicios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProductoServicioConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicio(this.tipoproductoservicios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoproductoservicios = new  ArrayList<TipoProductoServicio>();
		  		  
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
		tipoproductoservicios = new  ArrayList<TipoProductoServicio>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProductoServicio.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoProductoServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproductoservicios=tipoproductoservicioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoProductoServicio(tipoproductoservicios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProductoServicioConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicio(this.tipoproductoservicios);
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
		tipoproductoservicios = new  ArrayList<TipoProductoServicio>();
		  		  
        try {
			TipoProductoServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproductoservicios=tipoproductoservicioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoProductoServicio(tipoproductoservicios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProductoServicioConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicio(this.tipoproductoservicios);
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
		tipoproductoservicios = new  ArrayList<TipoProductoServicio>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProductoServicio.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProductoServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproductoservicios=tipoproductoservicioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoProductoServicio(tipoproductoservicios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProductoServicioConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicio(this.tipoproductoservicios);
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
		tipoproductoservicios = new  ArrayList<TipoProductoServicio>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProductoServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproductoservicios=tipoproductoservicioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoProductoServicio(tipoproductoservicios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProductoServicioConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicio(this.tipoproductoservicios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoproductoservicio = new  TipoProductoServicio();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProductoServicio.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProductoServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproductoservicio=tipoproductoservicioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoProductoServicio(tipoproductoservicio);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProductoServicioConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicio(this.tipoproductoservicio);
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
		tipoproductoservicio = new  TipoProductoServicio();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProductoServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproductoservicio=tipoproductoservicioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoProductoServicio(tipoproductoservicio);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProductoServicioConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicio(this.tipoproductoservicio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoProductoServiciosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoproductoservicios = new  ArrayList<TipoProductoServicio>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProductoServicio.class.getSimpleName()+"-getTodosTipoProductoServiciosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProductoServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproductoservicios=tipoproductoservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoProductoServicio(tipoproductoservicios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProductoServicioConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicio(this.tipoproductoservicios);
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
	
	public  void  getTodosTipoProductoServicios(String sFinalQuery,Pagination pagination)throws Exception {
		tipoproductoservicios = new  ArrayList<TipoProductoServicio>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProductoServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoproductoservicios=tipoproductoservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoProductoServicio(tipoproductoservicios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProductoServicioConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicio(this.tipoproductoservicios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoProductoServicio(TipoProductoServicio tipoproductoservicio) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoproductoservicio.getIsNew() || tipoproductoservicio.getIsChanged()) { 
			this.invalidValues = tipoproductoservicioValidator.getInvalidValues(tipoproductoservicio);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoproductoservicio);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoProductoServicio(List<TipoProductoServicio> TipoProductoServicios) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoProductoServicio tipoproductoservicioLocal:tipoproductoservicios) {				
			estaValidadoObjeto=this.validarGuardarTipoProductoServicio(tipoproductoservicioLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoProductoServicio(List<TipoProductoServicio> TipoProductoServicios) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoProductoServicio(tipoproductoservicios)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoProductoServicio(TipoProductoServicio TipoProductoServicio) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoProductoServicio(tipoproductoservicio)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoProductoServicio tipoproductoservicio) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoproductoservicio.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoProductoServicioConstantesFunciones.getTipoProductoServicioLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoproductoservicio","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoProductoServicioConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoProductoServicioConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoProductoServicioWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProductoServicio.class.getSimpleName()+"-saveTipoProductoServicioWithConnection");connexion.begin();			
			
			//TipoProductoServicioLogicAdditional.checkTipoProductoServicioToSave(this.tipoproductoservicio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoProductoServicioLogicAdditional.updateTipoProductoServicioToSave(this.tipoproductoservicio,this.arrDatoGeneral);
			
			TipoProductoServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoproductoservicio,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoProductoServicio();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoProductoServicio(this.tipoproductoservicio)) {
				TipoProductoServicioDataAccess.save(this.tipoproductoservicio, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoproductoservicio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoProductoServicioLogicAdditional.checkTipoProductoServicioToSaveAfter(this.tipoproductoservicio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoProductoServicio();
			
			connexion.commit();			
			
			if(this.tipoproductoservicio.getIsDeleted()) {
				this.tipoproductoservicio=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoProductoServicio()throws Exception {	
		try {	
			
			//TipoProductoServicioLogicAdditional.checkTipoProductoServicioToSave(this.tipoproductoservicio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoProductoServicioLogicAdditional.updateTipoProductoServicioToSave(this.tipoproductoservicio,this.arrDatoGeneral);
			
			TipoProductoServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoproductoservicio,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoProductoServicio(this.tipoproductoservicio)) {			
				TipoProductoServicioDataAccess.save(this.tipoproductoservicio, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoproductoservicio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoProductoServicioLogicAdditional.checkTipoProductoServicioToSaveAfter(this.tipoproductoservicio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoproductoservicio.getIsDeleted()) {
				this.tipoproductoservicio=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoProductoServiciosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProductoServicio.class.getSimpleName()+"-saveTipoProductoServiciosWithConnection");connexion.begin();			
			
			//TipoProductoServicioLogicAdditional.checkTipoProductoServicioToSaves(tipoproductoservicios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoProductoServicios();
			
			Boolean validadoTodosTipoProductoServicio=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoProductoServicio tipoproductoservicioLocal:tipoproductoservicios) {		
				if(tipoproductoservicioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoProductoServicioLogicAdditional.updateTipoProductoServicioToSave(tipoproductoservicioLocal,this.arrDatoGeneral);
	        	
				TipoProductoServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoproductoservicioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoProductoServicio(tipoproductoservicioLocal)) {
					TipoProductoServicioDataAccess.save(tipoproductoservicioLocal, connexion);				
				} else {
					validadoTodosTipoProductoServicio=false;
				}
			}
			
			if(!validadoTodosTipoProductoServicio) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoProductoServicioLogicAdditional.checkTipoProductoServicioToSavesAfter(tipoproductoservicios,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoProductoServicios();
			
			connexion.commit();		
			
			this.quitarTipoProductoServiciosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoProductoServicios()throws Exception {				
		 try {	
			//TipoProductoServicioLogicAdditional.checkTipoProductoServicioToSaves(tipoproductoservicios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoProductoServicio=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoProductoServicio tipoproductoservicioLocal:tipoproductoservicios) {				
				if(tipoproductoservicioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoProductoServicioLogicAdditional.updateTipoProductoServicioToSave(tipoproductoservicioLocal,this.arrDatoGeneral);
	        	
				TipoProductoServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoproductoservicioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoProductoServicio(tipoproductoservicioLocal)) {				
					TipoProductoServicioDataAccess.save(tipoproductoservicioLocal, connexion);				
				} else {
					validadoTodosTipoProductoServicio=false;
				}
			}
			
			if(!validadoTodosTipoProductoServicio) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoProductoServicioLogicAdditional.checkTipoProductoServicioToSavesAfter(tipoproductoservicios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoProductoServiciosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoProductoServicioParameterReturnGeneral procesarAccionTipoProductoServicios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoProductoServicio> tipoproductoservicios,TipoProductoServicioParameterReturnGeneral tipoproductoservicioParameterGeneral)throws Exception {
		 try {	
			TipoProductoServicioParameterReturnGeneral tipoproductoservicioReturnGeneral=new TipoProductoServicioParameterReturnGeneral();
	
			
			return tipoproductoservicioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoProductoServicioParameterReturnGeneral procesarAccionTipoProductoServiciosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoProductoServicio> tipoproductoservicios,TipoProductoServicioParameterReturnGeneral tipoproductoservicioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProductoServicio.class.getSimpleName()+"-procesarAccionTipoProductoServiciosWithConnection");connexion.begin();			
			
			TipoProductoServicioParameterReturnGeneral tipoproductoservicioReturnGeneral=new TipoProductoServicioParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipoproductoservicioReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoProductoServicioParameterReturnGeneral procesarEventosTipoProductoServicios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoProductoServicio> tipoproductoservicios,TipoProductoServicio tipoproductoservicio,TipoProductoServicioParameterReturnGeneral tipoproductoservicioParameterGeneral,Boolean isEsNuevoTipoProductoServicio,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoProductoServicioParameterReturnGeneral tipoproductoservicioReturnGeneral=new TipoProductoServicioParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoproductoservicioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipoproductoservicioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoProductoServicioParameterReturnGeneral procesarEventosTipoProductoServiciosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoProductoServicio> tipoproductoservicios,TipoProductoServicio tipoproductoservicio,TipoProductoServicioParameterReturnGeneral tipoproductoservicioParameterGeneral,Boolean isEsNuevoTipoProductoServicio,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProductoServicio.class.getSimpleName()+"-procesarEventosTipoProductoServiciosWithConnection");connexion.begin();			
			
			TipoProductoServicioParameterReturnGeneral tipoproductoservicioReturnGeneral=new TipoProductoServicioParameterReturnGeneral();
	
			tipoproductoservicioReturnGeneral.setTipoProductoServicio(tipoproductoservicio);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoproductoservicioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipoproductoservicioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoProductoServicioParameterReturnGeneral procesarImportacionTipoProductoServiciosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoProductoServicioParameterReturnGeneral tipoproductoservicioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProductoServicio.class.getSimpleName()+"-procesarImportacionTipoProductoServiciosWithConnection");connexion.begin();			
			
			TipoProductoServicioParameterReturnGeneral tipoproductoservicioReturnGeneral=new TipoProductoServicioParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoproductoservicios=new ArrayList<TipoProductoServicio>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoproductoservicio=new TipoProductoServicio();
				
				
				if(conColumnasBase) {this.tipoproductoservicio.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoproductoservicio.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoproductoservicio.setnombre(arrColumnas[iColumn++]);
				
				this.tipoproductoservicios.add(this.tipoproductoservicio);
			}
			
			this.saveTipoProductoServicios();
			
			this.connexion.commit();
			
			tipoproductoservicioReturnGeneral.setConRetornoEstaProcesado(true);
			tipoproductoservicioReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoproductoservicioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoProductoServiciosEliminados() throws Exception {				
		
		List<TipoProductoServicio> tipoproductoserviciosAux= new ArrayList<TipoProductoServicio>();
		
		for(TipoProductoServicio tipoproductoservicio:tipoproductoservicios) {
			if(!tipoproductoservicio.getIsDeleted()) {
				tipoproductoserviciosAux.add(tipoproductoservicio);
			}
		}
		
		tipoproductoservicios=tipoproductoserviciosAux;
	}
	
	public void quitarTipoProductoServiciosNulos() throws Exception {				
		
		List<TipoProductoServicio> tipoproductoserviciosAux= new ArrayList<TipoProductoServicio>();
		
		for(TipoProductoServicio tipoproductoservicio : this.tipoproductoservicios) {
			if(tipoproductoservicio==null) {
				tipoproductoserviciosAux.add(tipoproductoservicio);
			}
		}
		
		//this.tipoproductoservicios=tipoproductoserviciosAux;
		
		this.tipoproductoservicios.removeAll(tipoproductoserviciosAux);
	}
	
	public void getSetVersionRowTipoProductoServicioWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoproductoservicio.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoproductoservicio.getIsDeleted() || (tipoproductoservicio.getIsChanged()&&!tipoproductoservicio.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoproductoservicioDataAccess.getSetVersionRowTipoProductoServicio(connexion,tipoproductoservicio.getId());
				
				if(!tipoproductoservicio.getVersionRow().equals(timestamp)) {	
					tipoproductoservicio.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoproductoservicio.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoProductoServicio()throws Exception {	
		
		if(tipoproductoservicio.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoproductoservicio.getIsDeleted() || (tipoproductoservicio.getIsChanged()&&!tipoproductoservicio.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoproductoservicioDataAccess.getSetVersionRowTipoProductoServicio(connexion,tipoproductoservicio.getId());
			
			try {							
				if(!tipoproductoservicio.getVersionRow().equals(timestamp)) {	
					tipoproductoservicio.setVersionRow(timestamp);
				}
				
				tipoproductoservicio.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoProductoServiciosWithConnection()throws Exception {	
		if(tipoproductoservicios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoProductoServicio tipoproductoservicioAux:tipoproductoservicios) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoproductoservicioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoproductoservicioAux.getIsDeleted() || (tipoproductoservicioAux.getIsChanged()&&!tipoproductoservicioAux.getIsNew())) {
						
						timestamp=tipoproductoservicioDataAccess.getSetVersionRowTipoProductoServicio(connexion,tipoproductoservicioAux.getId());
						
						if(!tipoproductoservicio.getVersionRow().equals(timestamp)) {	
							tipoproductoservicioAux.setVersionRow(timestamp);
						}
								
						tipoproductoservicioAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoProductoServicios()throws Exception {	
		if(tipoproductoservicios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoProductoServicio tipoproductoservicioAux:tipoproductoservicios) {
					if(tipoproductoservicioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoproductoservicioAux.getIsDeleted() || (tipoproductoservicioAux.getIsChanged()&&!tipoproductoservicioAux.getIsNew())) {
						
						timestamp=tipoproductoservicioDataAccess.getSetVersionRowTipoProductoServicio(connexion,tipoproductoservicioAux.getId());
						
						if(!tipoproductoservicioAux.getVersionRow().equals(timestamp)) {	
							tipoproductoservicioAux.setVersionRow(timestamp);
						}
						
													
						tipoproductoservicioAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyTipoProductoServicioWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			CuentaContableTipoLogic cuentacontabletipoLogic=new CuentaContableTipoLogic();
			ParametroInventarioDefectoLogic parametroinventariodefectoLogic=new ParametroInventarioDefectoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProductoServicio.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoProductoServicioWithConnection");connexion.begin();
			
			
			classes.add(new Classe(CuentaContableTipo.class));
			classes.add(new Classe(ParametroInventarioDefecto.class));
											
			

			cuentacontabletipoLogic.setConnexion(this.getConnexion());
			cuentacontabletipoLogic.setDatosCliente(this.datosCliente);
			cuentacontabletipoLogic.setIsConRefrescarForeignKeys(true);

			parametroinventariodefectoLogic.setConnexion(this.getConnexion());
			parametroinventariodefectoLogic.setDatosCliente(this.datosCliente);
			parametroinventariodefectoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoProductoServicio tipoproductoservicio:this.tipoproductoservicios) {
				

				classes=new ArrayList<Classe>();
				classes=CuentaContableTipoConstantesFunciones.getClassesForeignKeysOfCuentaContableTipo(new ArrayList<Classe>(),DeepLoadType.NONE);

				cuentacontabletipoLogic.setCuentaContableTipos(tipoproductoservicio.cuentacontabletipos);
				cuentacontabletipoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ParametroInventarioDefectoConstantesFunciones.getClassesForeignKeysOfParametroInventarioDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);

				parametroinventariodefectoLogic.setParametroInventarioDefectos(tipoproductoservicio.parametroinventariodefectos);
				parametroinventariodefectoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoProductoServicio tipoproductoservicio,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoProductoServicioLogicAdditional.updateTipoProductoServicioToGet(tipoproductoservicio,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoproductoservicio.setCuentaContableTipos(tipoproductoservicioDataAccess.getCuentaContableTipos(connexion,tipoproductoservicio));
		tipoproductoservicio.setParametroInventarioDefectos(tipoproductoservicioDataAccess.getParametroInventarioDefectos(connexion,tipoproductoservicio));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContableTipo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoproductoservicio.setCuentaContableTipos(tipoproductoservicioDataAccess.getCuentaContableTipos(connexion,tipoproductoservicio));

				if(this.isConDeep) {
					CuentaContableTipoLogic cuentacontabletipoLogic= new CuentaContableTipoLogic(this.connexion);
					cuentacontabletipoLogic.setCuentaContableTipos(tipoproductoservicio.getCuentaContableTipos());
					ArrayList<Classe> classesLocal=CuentaContableTipoConstantesFunciones.getClassesForeignKeysOfCuentaContableTipo(new ArrayList<Classe>(),DeepLoadType.NONE);
					cuentacontabletipoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CuentaContableTipoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContableTipo(cuentacontabletipoLogic.getCuentaContableTipos());
					tipoproductoservicio.setCuentaContableTipos(cuentacontabletipoLogic.getCuentaContableTipos());
				}

				continue;
			}

			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoproductoservicio.setParametroInventarioDefectos(tipoproductoservicioDataAccess.getParametroInventarioDefectos(connexion,tipoproductoservicio));

				if(this.isConDeep) {
					ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(this.connexion);
					parametroinventariodefectoLogic.setParametroInventarioDefectos(tipoproductoservicio.getParametroInventarioDefectos());
					ArrayList<Classe> classesLocal=ParametroInventarioDefectoConstantesFunciones.getClassesForeignKeysOfParametroInventarioDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);
					parametroinventariodefectoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ParametroInventarioDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroInventarioDefecto(parametroinventariodefectoLogic.getParametroInventarioDefectos());
					tipoproductoservicio.setParametroInventarioDefectos(parametroinventariodefectoLogic.getParametroInventarioDefectos());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContableTipo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CuentaContableTipo.class));
			tipoproductoservicio.setCuentaContableTipos(tipoproductoservicioDataAccess.getCuentaContableTipos(connexion,tipoproductoservicio));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroInventarioDefecto.class));
			tipoproductoservicio.setParametroInventarioDefectos(tipoproductoservicioDataAccess.getParametroInventarioDefectos(connexion,tipoproductoservicio));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		tipoproductoservicio.setCuentaContableTipos(tipoproductoservicioDataAccess.getCuentaContableTipos(connexion,tipoproductoservicio));

		for(CuentaContableTipo cuentacontabletipo:tipoproductoservicio.getCuentaContableTipos()) {
			CuentaContableTipoLogic cuentacontabletipoLogic= new CuentaContableTipoLogic(connexion);
			cuentacontabletipoLogic.deepLoad(cuentacontabletipo,isDeep,deepLoadType,clases);
		}

		tipoproductoservicio.setParametroInventarioDefectos(tipoproductoservicioDataAccess.getParametroInventarioDefectos(connexion,tipoproductoservicio));

		for(ParametroInventarioDefecto parametroinventariodefecto:tipoproductoservicio.getParametroInventarioDefectos()) {
			ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(connexion);
			parametroinventariodefectoLogic.deepLoad(parametroinventariodefecto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContableTipo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoproductoservicio.setCuentaContableTipos(tipoproductoservicioDataAccess.getCuentaContableTipos(connexion,tipoproductoservicio));

				for(CuentaContableTipo cuentacontabletipo:tipoproductoservicio.getCuentaContableTipos()) {
					CuentaContableTipoLogic cuentacontabletipoLogic= new CuentaContableTipoLogic(connexion);
					cuentacontabletipoLogic.deepLoad(cuentacontabletipo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoproductoservicio.setParametroInventarioDefectos(tipoproductoservicioDataAccess.getParametroInventarioDefectos(connexion,tipoproductoservicio));

				for(ParametroInventarioDefecto parametroinventariodefecto:tipoproductoservicio.getParametroInventarioDefectos()) {
					ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(connexion);
					parametroinventariodefectoLogic.deepLoad(parametroinventariodefecto,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContableTipo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CuentaContableTipo.class));
			tipoproductoservicio.setCuentaContableTipos(tipoproductoservicioDataAccess.getCuentaContableTipos(connexion,tipoproductoservicio));

			for(CuentaContableTipo cuentacontabletipo:tipoproductoservicio.getCuentaContableTipos()) {
				CuentaContableTipoLogic cuentacontabletipoLogic= new CuentaContableTipoLogic(connexion);
				cuentacontabletipoLogic.deepLoad(cuentacontabletipo,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroInventarioDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroInventarioDefecto.class));
			tipoproductoservicio.setParametroInventarioDefectos(tipoproductoservicioDataAccess.getParametroInventarioDefectos(connexion,tipoproductoservicio));

			for(ParametroInventarioDefecto parametroinventariodefecto:tipoproductoservicio.getParametroInventarioDefectos()) {
				ParametroInventarioDefectoLogic parametroinventariodefectoLogic= new ParametroInventarioDefectoLogic(connexion);
				parametroinventariodefectoLogic.deepLoad(parametroinventariodefecto,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoProductoServicio tipoproductoservicio,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoProductoServicio.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoproductoservicio,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoProductoServicioConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicio(tipoproductoservicio);
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
			this.deepLoad(this.tipoproductoservicio,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoProductoServicioConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicio(this.tipoproductoservicio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoProductoServicio.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoproductoservicios!=null) {
				for(TipoProductoServicio tipoproductoservicio:tipoproductoservicios) {
					this.deepLoad(tipoproductoservicio,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoProductoServicioConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicio(tipoproductoservicios);
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
			if(tipoproductoservicios!=null) {
				for(TipoProductoServicio tipoproductoservicio:tipoproductoservicios) {
					this.deepLoad(tipoproductoservicio,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoProductoServicioConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicio(tipoproductoservicios);
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
	
	
	public void getTipoProductoServiciosBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProductoServicio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoProductoServicioConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoProductoServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoproductoservicios=tipoproductoservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoProductoServicioConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicio(this.tipoproductoservicios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoProductoServiciosBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoProductoServicioConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoProductoServicioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoproductoservicios=tipoproductoservicioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoProductoServicioConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicio(this.tipoproductoservicios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoProductoServicioPorNombreWithConnection(String nombre)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProductoServicio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,TipoProductoServicioConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			tipoproductoservicio=tipoproductoservicioDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipoproductoservicio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoProductoServicioConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicio(this.tipoproductoservicio);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoProductoServicioPorNombre(String nombre)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,TipoProductoServicioConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			tipoproductoservicio=tipoproductoservicioDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipoproductoservicio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoProductoServicioConstantesFunciones.refrescarForeignKeysDescripcionesTipoProductoServicio(this.tipoproductoservicio);
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
			if(TipoProductoServicioConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoProductoServicioDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoProductoServicio tipoproductoservicio,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoProductoServicioConstantesFunciones.ISCONAUDITORIA) {
				if(tipoproductoservicio.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoProductoServicioDataAccess.TABLENAME, tipoproductoservicio.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoProductoServicioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoProductoServicioLogic.registrarAuditoriaDetallesTipoProductoServicio(connexion,tipoproductoservicio,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoproductoservicio.getIsDeleted()) {
					/*if(!tipoproductoservicio.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoProductoServicioDataAccess.TABLENAME, tipoproductoservicio.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoProductoServicioLogic.registrarAuditoriaDetallesTipoProductoServicio(connexion,tipoproductoservicio,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoProductoServicioDataAccess.TABLENAME, tipoproductoservicio.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoproductoservicio.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoProductoServicioDataAccess.TABLENAME, tipoproductoservicio.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoProductoServicioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoProductoServicioLogic.registrarAuditoriaDetallesTipoProductoServicio(connexion,tipoproductoservicio,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoProductoServicio(Connexion connexion,TipoProductoServicio tipoproductoservicio)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoproductoservicio.getIsNew()||!tipoproductoservicio.getnombre().equals(tipoproductoservicio.getTipoProductoServicioOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoproductoservicio.getTipoProductoServicioOriginal().getnombre()!=null)
				{
					strValorActual=tipoproductoservicio.getTipoProductoServicioOriginal().getnombre();
				}
				if(tipoproductoservicio.getnombre()!=null)
				{
					strValorNuevo=tipoproductoservicio.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoProductoServicioConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoProductoServicio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoProductoServicioConstantesFunciones.getClassesForeignKeysOfTipoProductoServicio(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoProductoServicio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoProductoServicioConstantesFunciones.getClassesRelationshipsOfTipoProductoServicio(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

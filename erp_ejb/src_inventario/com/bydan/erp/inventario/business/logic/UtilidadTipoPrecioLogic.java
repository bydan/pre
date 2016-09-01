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
package com.bydan.erp.inventario.business.logic;

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
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.inventario.util.UtilidadTipoPrecioConstantesFunciones;
import com.bydan.erp.inventario.util.UtilidadTipoPrecioParameterReturnGeneral;
//import com.bydan.erp.inventario.util.UtilidadTipoPrecioParameterGeneral;
import com.bydan.erp.inventario.business.entity.UtilidadTipoPrecio;
import com.bydan.erp.inventario.business.logic.UtilidadTipoPrecioLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class UtilidadTipoPrecioLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(UtilidadTipoPrecioLogic.class);
	
	protected UtilidadTipoPrecioDataAccess utilidadtipoprecioDataAccess; 	
	protected UtilidadTipoPrecio utilidadtipoprecio;
	protected List<UtilidadTipoPrecio> utilidadtipoprecios;
	protected Object utilidadtipoprecioObject;	
	protected List<Object> utilidadtipopreciosObject;
	
	public static ClassValidator<UtilidadTipoPrecio> utilidadtipoprecioValidator = new ClassValidator<UtilidadTipoPrecio>(UtilidadTipoPrecio.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected UtilidadTipoPrecioLogicAdditional utilidadtipoprecioLogicAdditional=null;
	
	public UtilidadTipoPrecioLogicAdditional getUtilidadTipoPrecioLogicAdditional() {
		return this.utilidadtipoprecioLogicAdditional;
	}
	
	public void setUtilidadTipoPrecioLogicAdditional(UtilidadTipoPrecioLogicAdditional utilidadtipoprecioLogicAdditional) {
		try {
			this.utilidadtipoprecioLogicAdditional=utilidadtipoprecioLogicAdditional;
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
	
	
	
	
	public  UtilidadTipoPrecioLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.utilidadtipoprecioDataAccess = new UtilidadTipoPrecioDataAccess();
			
			this.utilidadtipoprecios= new ArrayList<UtilidadTipoPrecio>();
			this.utilidadtipoprecio= new UtilidadTipoPrecio();
			
			this.utilidadtipoprecioObject=new Object();
			this.utilidadtipopreciosObject=new ArrayList<Object>();
				
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
			
			this.utilidadtipoprecioDataAccess.setConnexionType(this.connexionType);
			this.utilidadtipoprecioDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  UtilidadTipoPrecioLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.utilidadtipoprecioDataAccess = new UtilidadTipoPrecioDataAccess();
			this.utilidadtipoprecios= new ArrayList<UtilidadTipoPrecio>();
			this.utilidadtipoprecio= new UtilidadTipoPrecio();
			this.utilidadtipoprecioObject=new Object();
			this.utilidadtipopreciosObject=new ArrayList<Object>();
			
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
			
			this.utilidadtipoprecioDataAccess.setConnexionType(this.connexionType);
			this.utilidadtipoprecioDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public UtilidadTipoPrecio getUtilidadTipoPrecio() throws Exception {	
		UtilidadTipoPrecioLogicAdditional.checkUtilidadTipoPrecioToGet(utilidadtipoprecio,this.datosCliente,this.arrDatoGeneral);
		UtilidadTipoPrecioLogicAdditional.updateUtilidadTipoPrecioToGet(utilidadtipoprecio,this.arrDatoGeneral);
		
		return utilidadtipoprecio;
	}
		
	public void setUtilidadTipoPrecio(UtilidadTipoPrecio newUtilidadTipoPrecio) {
		this.utilidadtipoprecio = newUtilidadTipoPrecio;
	}
	
	public UtilidadTipoPrecioDataAccess getUtilidadTipoPrecioDataAccess() {
		return utilidadtipoprecioDataAccess;
	}
	
	public void setUtilidadTipoPrecioDataAccess(UtilidadTipoPrecioDataAccess newutilidadtipoprecioDataAccess) {
		this.utilidadtipoprecioDataAccess = newutilidadtipoprecioDataAccess;
	}
	
	public List<UtilidadTipoPrecio> getUtilidadTipoPrecios() throws Exception {		
		this.quitarUtilidadTipoPreciosNulos();
		
		UtilidadTipoPrecioLogicAdditional.checkUtilidadTipoPrecioToGets(utilidadtipoprecios,this.datosCliente,this.arrDatoGeneral);
		
		for (UtilidadTipoPrecio utilidadtipoprecioLocal: utilidadtipoprecios ) {
			UtilidadTipoPrecioLogicAdditional.updateUtilidadTipoPrecioToGet(utilidadtipoprecioLocal,this.arrDatoGeneral);
		}
		
		return utilidadtipoprecios;
	}
	
	public void setUtilidadTipoPrecios(List<UtilidadTipoPrecio> newUtilidadTipoPrecios) {
		this.utilidadtipoprecios = newUtilidadTipoPrecios;
	}
	
	public Object getUtilidadTipoPrecioObject() {	
		this.utilidadtipoprecioObject=this.utilidadtipoprecioDataAccess.getEntityObject();
		return this.utilidadtipoprecioObject;
	}
		
	public void setUtilidadTipoPrecioObject(Object newUtilidadTipoPrecioObject) {
		this.utilidadtipoprecioObject = newUtilidadTipoPrecioObject;
	}
	
	public List<Object> getUtilidadTipoPreciosObject() {		
		this.utilidadtipopreciosObject=this.utilidadtipoprecioDataAccess.getEntitiesObject();
		return this.utilidadtipopreciosObject;
	}
		
	public void setUtilidadTipoPreciosObject(List<Object> newUtilidadTipoPreciosObject) {
		this.utilidadtipopreciosObject = newUtilidadTipoPreciosObject;
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
		
		if(this.utilidadtipoprecioDataAccess!=null) {
			this.utilidadtipoprecioDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadTipoPrecio.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			utilidadtipoprecioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			utilidadtipoprecioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		utilidadtipoprecio = new  UtilidadTipoPrecio();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadTipoPrecio.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			utilidadtipoprecio=utilidadtipoprecioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.utilidadtipoprecio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				UtilidadTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadTipoPrecio(this.utilidadtipoprecio);
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
		utilidadtipoprecio = new  UtilidadTipoPrecio();
		  		  
        try {
			
			utilidadtipoprecio=utilidadtipoprecioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.utilidadtipoprecio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				UtilidadTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadTipoPrecio(this.utilidadtipoprecio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		utilidadtipoprecio = new  UtilidadTipoPrecio();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadTipoPrecio.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			utilidadtipoprecio=utilidadtipoprecioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.utilidadtipoprecio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				UtilidadTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadTipoPrecio(this.utilidadtipoprecio);
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
		utilidadtipoprecio = new  UtilidadTipoPrecio();
		  		  
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
		utilidadtipoprecio = new  UtilidadTipoPrecio();
		  		  
        try {
			
			utilidadtipoprecio=utilidadtipoprecioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.utilidadtipoprecio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				UtilidadTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadTipoPrecio(this.utilidadtipoprecio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		utilidadtipoprecio = new  UtilidadTipoPrecio();
		  		  
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
		utilidadtipoprecio = new  UtilidadTipoPrecio();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadTipoPrecio.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =utilidadtipoprecioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		utilidadtipoprecio = new  UtilidadTipoPrecio();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=utilidadtipoprecioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		utilidadtipoprecio = new  UtilidadTipoPrecio();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadTipoPrecio.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =utilidadtipoprecioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		utilidadtipoprecio = new  UtilidadTipoPrecio();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=utilidadtipoprecioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		utilidadtipoprecio = new  UtilidadTipoPrecio();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadTipoPrecio.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =utilidadtipoprecioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		utilidadtipoprecio = new  UtilidadTipoPrecio();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=utilidadtipoprecioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		utilidadtipoprecios = new  ArrayList<UtilidadTipoPrecio>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadTipoPrecio.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			UtilidadTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			utilidadtipoprecios=utilidadtipoprecioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUtilidadTipoPrecio(utilidadtipoprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UtilidadTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadTipoPrecio(this.utilidadtipoprecios);
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
		utilidadtipoprecios = new  ArrayList<UtilidadTipoPrecio>();
		  		  
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
		utilidadtipoprecios = new  ArrayList<UtilidadTipoPrecio>();
		  		  
        try {			
			UtilidadTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			utilidadtipoprecios=utilidadtipoprecioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarUtilidadTipoPrecio(utilidadtipoprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UtilidadTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadTipoPrecio(this.utilidadtipoprecios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		utilidadtipoprecios = new  ArrayList<UtilidadTipoPrecio>();
		  		  
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
		utilidadtipoprecios = new  ArrayList<UtilidadTipoPrecio>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadTipoPrecio.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			UtilidadTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			utilidadtipoprecios=utilidadtipoprecioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUtilidadTipoPrecio(utilidadtipoprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UtilidadTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadTipoPrecio(this.utilidadtipoprecios);
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
		utilidadtipoprecios = new  ArrayList<UtilidadTipoPrecio>();
		  		  
        try {
			UtilidadTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			utilidadtipoprecios=utilidadtipoprecioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUtilidadTipoPrecio(utilidadtipoprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UtilidadTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadTipoPrecio(this.utilidadtipoprecios);
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
		utilidadtipoprecios = new  ArrayList<UtilidadTipoPrecio>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadTipoPrecio.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UtilidadTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			utilidadtipoprecios=utilidadtipoprecioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarUtilidadTipoPrecio(utilidadtipoprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UtilidadTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadTipoPrecio(this.utilidadtipoprecios);
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
		utilidadtipoprecios = new  ArrayList<UtilidadTipoPrecio>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UtilidadTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			utilidadtipoprecios=utilidadtipoprecioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarUtilidadTipoPrecio(utilidadtipoprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UtilidadTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadTipoPrecio(this.utilidadtipoprecios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		utilidadtipoprecio = new  UtilidadTipoPrecio();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadTipoPrecio.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UtilidadTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			utilidadtipoprecio=utilidadtipoprecioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarUtilidadTipoPrecio(utilidadtipoprecio);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UtilidadTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadTipoPrecio(this.utilidadtipoprecio);
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
		utilidadtipoprecio = new  UtilidadTipoPrecio();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UtilidadTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			utilidadtipoprecio=utilidadtipoprecioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarUtilidadTipoPrecio(utilidadtipoprecio);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UtilidadTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadTipoPrecio(this.utilidadtipoprecio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		utilidadtipoprecios = new  ArrayList<UtilidadTipoPrecio>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadTipoPrecio.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			UtilidadTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			utilidadtipoprecios=utilidadtipoprecioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUtilidadTipoPrecio(utilidadtipoprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UtilidadTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadTipoPrecio(this.utilidadtipoprecios);
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
		utilidadtipoprecios = new  ArrayList<UtilidadTipoPrecio>();
		  		  
        try {
			UtilidadTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			utilidadtipoprecios=utilidadtipoprecioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUtilidadTipoPrecio(utilidadtipoprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UtilidadTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadTipoPrecio(this.utilidadtipoprecios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosUtilidadTipoPreciosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		utilidadtipoprecios = new  ArrayList<UtilidadTipoPrecio>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadTipoPrecio.class.getSimpleName()+"-getTodosUtilidadTipoPreciosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UtilidadTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			utilidadtipoprecios=utilidadtipoprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarUtilidadTipoPrecio(utilidadtipoprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UtilidadTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadTipoPrecio(this.utilidadtipoprecios);
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
	
	public  void  getTodosUtilidadTipoPrecios(String sFinalQuery,Pagination pagination)throws Exception {
		utilidadtipoprecios = new  ArrayList<UtilidadTipoPrecio>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UtilidadTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			utilidadtipoprecios=utilidadtipoprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarUtilidadTipoPrecio(utilidadtipoprecios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UtilidadTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadTipoPrecio(this.utilidadtipoprecios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarUtilidadTipoPrecio(UtilidadTipoPrecio utilidadtipoprecio) throws Exception {
		Boolean estaValidado=false;
		
		if(utilidadtipoprecio.getIsNew() || utilidadtipoprecio.getIsChanged()) { 
			this.invalidValues = utilidadtipoprecioValidator.getInvalidValues(utilidadtipoprecio);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(utilidadtipoprecio);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarUtilidadTipoPrecio(List<UtilidadTipoPrecio> UtilidadTipoPrecios) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(UtilidadTipoPrecio utilidadtipoprecioLocal:utilidadtipoprecios) {				
			estaValidadoObjeto=this.validarGuardarUtilidadTipoPrecio(utilidadtipoprecioLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarUtilidadTipoPrecio(List<UtilidadTipoPrecio> UtilidadTipoPrecios) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarUtilidadTipoPrecio(utilidadtipoprecios)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarUtilidadTipoPrecio(UtilidadTipoPrecio UtilidadTipoPrecio) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarUtilidadTipoPrecio(utilidadtipoprecio)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(UtilidadTipoPrecio utilidadtipoprecio) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+utilidadtipoprecio.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=UtilidadTipoPrecioConstantesFunciones.getUtilidadTipoPrecioLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"utilidadtipoprecio","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(UtilidadTipoPrecioConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(UtilidadTipoPrecioConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveUtilidadTipoPrecioWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadTipoPrecio.class.getSimpleName()+"-saveUtilidadTipoPrecioWithConnection");connexion.begin();			
			
			UtilidadTipoPrecioLogicAdditional.checkUtilidadTipoPrecioToSave(this.utilidadtipoprecio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			UtilidadTipoPrecioLogicAdditional.updateUtilidadTipoPrecioToSave(this.utilidadtipoprecio,this.arrDatoGeneral);
			
			UtilidadTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.utilidadtipoprecio,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowUtilidadTipoPrecio();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarUtilidadTipoPrecio(this.utilidadtipoprecio)) {
				UtilidadTipoPrecioDataAccess.save(this.utilidadtipoprecio, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.utilidadtipoprecio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			UtilidadTipoPrecioLogicAdditional.checkUtilidadTipoPrecioToSaveAfter(this.utilidadtipoprecio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowUtilidadTipoPrecio();
			
			connexion.commit();			
			
			if(this.utilidadtipoprecio.getIsDeleted()) {
				this.utilidadtipoprecio=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveUtilidadTipoPrecio()throws Exception {	
		try {	
			
			UtilidadTipoPrecioLogicAdditional.checkUtilidadTipoPrecioToSave(this.utilidadtipoprecio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			UtilidadTipoPrecioLogicAdditional.updateUtilidadTipoPrecioToSave(this.utilidadtipoprecio,this.arrDatoGeneral);
			
			UtilidadTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.utilidadtipoprecio,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarUtilidadTipoPrecio(this.utilidadtipoprecio)) {			
				UtilidadTipoPrecioDataAccess.save(this.utilidadtipoprecio, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.utilidadtipoprecio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			UtilidadTipoPrecioLogicAdditional.checkUtilidadTipoPrecioToSaveAfter(this.utilidadtipoprecio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.utilidadtipoprecio.getIsDeleted()) {
				this.utilidadtipoprecio=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveUtilidadTipoPreciosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadTipoPrecio.class.getSimpleName()+"-saveUtilidadTipoPreciosWithConnection");connexion.begin();			
			
			UtilidadTipoPrecioLogicAdditional.checkUtilidadTipoPrecioToSaves(utilidadtipoprecios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowUtilidadTipoPrecios();
			
			Boolean validadoTodosUtilidadTipoPrecio=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(UtilidadTipoPrecio utilidadtipoprecioLocal:utilidadtipoprecios) {		
				if(utilidadtipoprecioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				UtilidadTipoPrecioLogicAdditional.updateUtilidadTipoPrecioToSave(utilidadtipoprecioLocal,this.arrDatoGeneral);
	        	
				UtilidadTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),utilidadtipoprecioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarUtilidadTipoPrecio(utilidadtipoprecioLocal)) {
					UtilidadTipoPrecioDataAccess.save(utilidadtipoprecioLocal, connexion);				
				} else {
					validadoTodosUtilidadTipoPrecio=false;
				}
			}
			
			if(!validadoTodosUtilidadTipoPrecio) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			UtilidadTipoPrecioLogicAdditional.checkUtilidadTipoPrecioToSavesAfter(utilidadtipoprecios,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowUtilidadTipoPrecios();
			
			connexion.commit();		
			
			this.quitarUtilidadTipoPreciosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveUtilidadTipoPrecios()throws Exception {				
		 try {	
			UtilidadTipoPrecioLogicAdditional.checkUtilidadTipoPrecioToSaves(utilidadtipoprecios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosUtilidadTipoPrecio=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(UtilidadTipoPrecio utilidadtipoprecioLocal:utilidadtipoprecios) {				
				if(utilidadtipoprecioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				UtilidadTipoPrecioLogicAdditional.updateUtilidadTipoPrecioToSave(utilidadtipoprecioLocal,this.arrDatoGeneral);
	        	
				UtilidadTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),utilidadtipoprecioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarUtilidadTipoPrecio(utilidadtipoprecioLocal)) {				
					UtilidadTipoPrecioDataAccess.save(utilidadtipoprecioLocal, connexion);				
				} else {
					validadoTodosUtilidadTipoPrecio=false;
				}
			}
			
			if(!validadoTodosUtilidadTipoPrecio) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			UtilidadTipoPrecioLogicAdditional.checkUtilidadTipoPrecioToSavesAfter(utilidadtipoprecios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarUtilidadTipoPreciosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public UtilidadTipoPrecioParameterReturnGeneral procesarAccionUtilidadTipoPrecios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<UtilidadTipoPrecio> utilidadtipoprecios,UtilidadTipoPrecioParameterReturnGeneral utilidadtipoprecioParameterGeneral)throws Exception {
		 try {	
			UtilidadTipoPrecioParameterReturnGeneral utilidadtipoprecioReturnGeneral=new UtilidadTipoPrecioParameterReturnGeneral();
	
			UtilidadTipoPrecioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,utilidadtipoprecios,utilidadtipoprecioParameterGeneral,utilidadtipoprecioReturnGeneral);
			
			return utilidadtipoprecioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public UtilidadTipoPrecioParameterReturnGeneral procesarAccionUtilidadTipoPreciosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<UtilidadTipoPrecio> utilidadtipoprecios,UtilidadTipoPrecioParameterReturnGeneral utilidadtipoprecioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadTipoPrecio.class.getSimpleName()+"-procesarAccionUtilidadTipoPreciosWithConnection");connexion.begin();			
			
			UtilidadTipoPrecioParameterReturnGeneral utilidadtipoprecioReturnGeneral=new UtilidadTipoPrecioParameterReturnGeneral();
	
			UtilidadTipoPrecioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,utilidadtipoprecios,utilidadtipoprecioParameterGeneral,utilidadtipoprecioReturnGeneral);
			
			this.connexion.commit();
			
			return utilidadtipoprecioReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public UtilidadTipoPrecioParameterReturnGeneral procesarEventosUtilidadTipoPrecios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<UtilidadTipoPrecio> utilidadtipoprecios,UtilidadTipoPrecio utilidadtipoprecio,UtilidadTipoPrecioParameterReturnGeneral utilidadtipoprecioParameterGeneral,Boolean isEsNuevoUtilidadTipoPrecio,ArrayList<Classe> clases)throws Exception {
		 try {	
			UtilidadTipoPrecioParameterReturnGeneral utilidadtipoprecioReturnGeneral=new UtilidadTipoPrecioParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				utilidadtipoprecioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			UtilidadTipoPrecioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,utilidadtipoprecios,utilidadtipoprecio,utilidadtipoprecioParameterGeneral,utilidadtipoprecioReturnGeneral,isEsNuevoUtilidadTipoPrecio,clases);
			
			return utilidadtipoprecioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public UtilidadTipoPrecioParameterReturnGeneral procesarEventosUtilidadTipoPreciosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<UtilidadTipoPrecio> utilidadtipoprecios,UtilidadTipoPrecio utilidadtipoprecio,UtilidadTipoPrecioParameterReturnGeneral utilidadtipoprecioParameterGeneral,Boolean isEsNuevoUtilidadTipoPrecio,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadTipoPrecio.class.getSimpleName()+"-procesarEventosUtilidadTipoPreciosWithConnection");connexion.begin();			
			
			UtilidadTipoPrecioParameterReturnGeneral utilidadtipoprecioReturnGeneral=new UtilidadTipoPrecioParameterReturnGeneral();
	
			utilidadtipoprecioReturnGeneral.setUtilidadTipoPrecio(utilidadtipoprecio);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				utilidadtipoprecioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			UtilidadTipoPrecioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,utilidadtipoprecios,utilidadtipoprecio,utilidadtipoprecioParameterGeneral,utilidadtipoprecioReturnGeneral,isEsNuevoUtilidadTipoPrecio,clases);
			
			this.connexion.commit();
			
			return utilidadtipoprecioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public UtilidadTipoPrecioParameterReturnGeneral procesarImportacionUtilidadTipoPreciosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,UtilidadTipoPrecioParameterReturnGeneral utilidadtipoprecioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadTipoPrecio.class.getSimpleName()+"-procesarImportacionUtilidadTipoPreciosWithConnection");connexion.begin();			
			
			UtilidadTipoPrecioParameterReturnGeneral utilidadtipoprecioReturnGeneral=new UtilidadTipoPrecioParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.utilidadtipoprecios=new ArrayList<UtilidadTipoPrecio>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.utilidadtipoprecio=new UtilidadTipoPrecio();
				
				
				if(conColumnasBase) {this.utilidadtipoprecio.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.utilidadtipoprecio.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.utilidadtipoprecio.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.utilidadtipoprecios.add(this.utilidadtipoprecio);
			}
			
			this.saveUtilidadTipoPrecios();
			
			this.connexion.commit();
			
			utilidadtipoprecioReturnGeneral.setConRetornoEstaProcesado(true);
			utilidadtipoprecioReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return utilidadtipoprecioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarUtilidadTipoPreciosEliminados() throws Exception {				
		
		List<UtilidadTipoPrecio> utilidadtipopreciosAux= new ArrayList<UtilidadTipoPrecio>();
		
		for(UtilidadTipoPrecio utilidadtipoprecio:utilidadtipoprecios) {
			if(!utilidadtipoprecio.getIsDeleted()) {
				utilidadtipopreciosAux.add(utilidadtipoprecio);
			}
		}
		
		utilidadtipoprecios=utilidadtipopreciosAux;
	}
	
	public void quitarUtilidadTipoPreciosNulos() throws Exception {				
		
		List<UtilidadTipoPrecio> utilidadtipopreciosAux= new ArrayList<UtilidadTipoPrecio>();
		
		for(UtilidadTipoPrecio utilidadtipoprecio : this.utilidadtipoprecios) {
			if(utilidadtipoprecio==null) {
				utilidadtipopreciosAux.add(utilidadtipoprecio);
			}
		}
		
		//this.utilidadtipoprecios=utilidadtipopreciosAux;
		
		this.utilidadtipoprecios.removeAll(utilidadtipopreciosAux);
	}
	
	public void getSetVersionRowUtilidadTipoPrecioWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(utilidadtipoprecio.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((utilidadtipoprecio.getIsDeleted() || (utilidadtipoprecio.getIsChanged()&&!utilidadtipoprecio.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=utilidadtipoprecioDataAccess.getSetVersionRowUtilidadTipoPrecio(connexion,utilidadtipoprecio.getId());
				
				if(!utilidadtipoprecio.getVersionRow().equals(timestamp)) {	
					utilidadtipoprecio.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				utilidadtipoprecio.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowUtilidadTipoPrecio()throws Exception {	
		
		if(utilidadtipoprecio.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((utilidadtipoprecio.getIsDeleted() || (utilidadtipoprecio.getIsChanged()&&!utilidadtipoprecio.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=utilidadtipoprecioDataAccess.getSetVersionRowUtilidadTipoPrecio(connexion,utilidadtipoprecio.getId());
			
			try {							
				if(!utilidadtipoprecio.getVersionRow().equals(timestamp)) {	
					utilidadtipoprecio.setVersionRow(timestamp);
				}
				
				utilidadtipoprecio.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowUtilidadTipoPreciosWithConnection()throws Exception {	
		if(utilidadtipoprecios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(UtilidadTipoPrecio utilidadtipoprecioAux:utilidadtipoprecios) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(utilidadtipoprecioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(utilidadtipoprecioAux.getIsDeleted() || (utilidadtipoprecioAux.getIsChanged()&&!utilidadtipoprecioAux.getIsNew())) {
						
						timestamp=utilidadtipoprecioDataAccess.getSetVersionRowUtilidadTipoPrecio(connexion,utilidadtipoprecioAux.getId());
						
						if(!utilidadtipoprecio.getVersionRow().equals(timestamp)) {	
							utilidadtipoprecioAux.setVersionRow(timestamp);
						}
								
						utilidadtipoprecioAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowUtilidadTipoPrecios()throws Exception {	
		if(utilidadtipoprecios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(UtilidadTipoPrecio utilidadtipoprecioAux:utilidadtipoprecios) {
					if(utilidadtipoprecioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(utilidadtipoprecioAux.getIsDeleted() || (utilidadtipoprecioAux.getIsChanged()&&!utilidadtipoprecioAux.getIsNew())) {
						
						timestamp=utilidadtipoprecioDataAccess.getSetVersionRowUtilidadTipoPrecio(connexion,utilidadtipoprecioAux.getId());
						
						if(!utilidadtipoprecioAux.getVersionRow().equals(timestamp)) {	
							utilidadtipoprecioAux.setVersionRow(timestamp);
						}
						
													
						utilidadtipoprecioAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public UtilidadTipoPrecioParameterReturnGeneral cargarCombosLoteForeignKeyUtilidadTipoPrecioWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalTipoPrecio) throws Exception {
		UtilidadTipoPrecioParameterReturnGeneral  utilidadtipoprecioReturnGeneral =new UtilidadTipoPrecioParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadTipoPrecio.class.getSimpleName()+"-cargarCombosLoteForeignKeyUtilidadTipoPrecioWithConnection");connexion.begin();
			
			utilidadtipoprecioReturnGeneral =new UtilidadTipoPrecioParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			utilidadtipoprecioReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			utilidadtipoprecioReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<TipoPrecio> tipopreciosForeignKey=new ArrayList<TipoPrecio>();
			TipoPrecioLogic tipoprecioLogic=new TipoPrecioLogic();
			tipoprecioLogic.setConnexion(this.connexion);
			tipoprecioLogic.getTipoPrecioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPrecio.equals("NONE")) {
				tipoprecioLogic.getTodosTipoPrecios(finalQueryGlobalTipoPrecio,new Pagination());
				tipopreciosForeignKey=tipoprecioLogic.getTipoPrecios();
			}

			utilidadtipoprecioReturnGeneral.settipopreciosForeignKey(tipopreciosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return utilidadtipoprecioReturnGeneral;
	}
	
	public UtilidadTipoPrecioParameterReturnGeneral cargarCombosLoteForeignKeyUtilidadTipoPrecio(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalTipoPrecio) throws Exception {
		UtilidadTipoPrecioParameterReturnGeneral  utilidadtipoprecioReturnGeneral =new UtilidadTipoPrecioParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			utilidadtipoprecioReturnGeneral =new UtilidadTipoPrecioParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			utilidadtipoprecioReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			utilidadtipoprecioReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<TipoPrecio> tipopreciosForeignKey=new ArrayList<TipoPrecio>();
			TipoPrecioLogic tipoprecioLogic=new TipoPrecioLogic();
			tipoprecioLogic.setConnexion(this.connexion);
			tipoprecioLogic.getTipoPrecioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPrecio.equals("NONE")) {
				tipoprecioLogic.getTodosTipoPrecios(finalQueryGlobalTipoPrecio,new Pagination());
				tipopreciosForeignKey=tipoprecioLogic.getTipoPrecios();
			}

			utilidadtipoprecioReturnGeneral.settipopreciosForeignKey(tipopreciosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return utilidadtipoprecioReturnGeneral;
	}
	
	
	public void deepLoad(UtilidadTipoPrecio utilidadtipoprecio,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			UtilidadTipoPrecioLogicAdditional.updateUtilidadTipoPrecioToGet(utilidadtipoprecio,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		utilidadtipoprecio.setEmpresa(utilidadtipoprecioDataAccess.getEmpresa(connexion,utilidadtipoprecio));
		utilidadtipoprecio.setSucursal(utilidadtipoprecioDataAccess.getSucursal(connexion,utilidadtipoprecio));
		utilidadtipoprecio.setTipoPrecio(utilidadtipoprecioDataAccess.getTipoPrecio(connexion,utilidadtipoprecio));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				utilidadtipoprecio.setEmpresa(utilidadtipoprecioDataAccess.getEmpresa(connexion,utilidadtipoprecio));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				utilidadtipoprecio.setSucursal(utilidadtipoprecioDataAccess.getSucursal(connexion,utilidadtipoprecio));
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				utilidadtipoprecio.setTipoPrecio(utilidadtipoprecioDataAccess.getTipoPrecio(connexion,utilidadtipoprecio));
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
			utilidadtipoprecio.setEmpresa(utilidadtipoprecioDataAccess.getEmpresa(connexion,utilidadtipoprecio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			utilidadtipoprecio.setSucursal(utilidadtipoprecioDataAccess.getSucursal(connexion,utilidadtipoprecio));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrecio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			utilidadtipoprecio.setTipoPrecio(utilidadtipoprecioDataAccess.getTipoPrecio(connexion,utilidadtipoprecio));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		utilidadtipoprecio.setEmpresa(utilidadtipoprecioDataAccess.getEmpresa(connexion,utilidadtipoprecio));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(utilidadtipoprecio.getEmpresa(),isDeep,deepLoadType,clases);
				
		utilidadtipoprecio.setSucursal(utilidadtipoprecioDataAccess.getSucursal(connexion,utilidadtipoprecio));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(utilidadtipoprecio.getSucursal(),isDeep,deepLoadType,clases);
				
		utilidadtipoprecio.setTipoPrecio(utilidadtipoprecioDataAccess.getTipoPrecio(connexion,utilidadtipoprecio));
		TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
		tipoprecioLogic.deepLoad(utilidadtipoprecio.getTipoPrecio(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				utilidadtipoprecio.setEmpresa(utilidadtipoprecioDataAccess.getEmpresa(connexion,utilidadtipoprecio));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(utilidadtipoprecio.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				utilidadtipoprecio.setSucursal(utilidadtipoprecioDataAccess.getSucursal(connexion,utilidadtipoprecio));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(utilidadtipoprecio.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				utilidadtipoprecio.setTipoPrecio(utilidadtipoprecioDataAccess.getTipoPrecio(connexion,utilidadtipoprecio));
				TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
				tipoprecioLogic.deepLoad(utilidadtipoprecio.getTipoPrecio(),isDeep,deepLoadType,clases);				
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
			utilidadtipoprecio.setEmpresa(utilidadtipoprecioDataAccess.getEmpresa(connexion,utilidadtipoprecio));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(utilidadtipoprecio.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			utilidadtipoprecio.setSucursal(utilidadtipoprecioDataAccess.getSucursal(connexion,utilidadtipoprecio));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(utilidadtipoprecio.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrecio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			utilidadtipoprecio.setTipoPrecio(utilidadtipoprecioDataAccess.getTipoPrecio(connexion,utilidadtipoprecio));
			TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
			tipoprecioLogic.deepLoad(utilidadtipoprecio.getTipoPrecio(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(UtilidadTipoPrecio utilidadtipoprecio,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			UtilidadTipoPrecioLogicAdditional.updateUtilidadTipoPrecioToSave(utilidadtipoprecio,this.arrDatoGeneral);
			
UtilidadTipoPrecioDataAccess.save(utilidadtipoprecio, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(utilidadtipoprecio.getEmpresa(),connexion);

		SucursalDataAccess.save(utilidadtipoprecio.getSucursal(),connexion);

		TipoPrecioDataAccess.save(utilidadtipoprecio.getTipoPrecio(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(utilidadtipoprecio.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(utilidadtipoprecio.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				TipoPrecioDataAccess.save(utilidadtipoprecio.getTipoPrecio(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(utilidadtipoprecio.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(utilidadtipoprecio.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(utilidadtipoprecio.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(utilidadtipoprecio.getSucursal(),isDeep,deepLoadType,clases);
				

		TipoPrecioDataAccess.save(utilidadtipoprecio.getTipoPrecio(),connexion);
		TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
		tipoprecioLogic.deepLoad(utilidadtipoprecio.getTipoPrecio(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(utilidadtipoprecio.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(utilidadtipoprecio.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(utilidadtipoprecio.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(utilidadtipoprecio.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPrecio.class)) {
				TipoPrecioDataAccess.save(utilidadtipoprecio.getTipoPrecio(),connexion);
				TipoPrecioLogic tipoprecioLogic= new TipoPrecioLogic(connexion);
				tipoprecioLogic.deepSave(utilidadtipoprecio.getTipoPrecio(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(UtilidadTipoPrecio.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(utilidadtipoprecio,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				UtilidadTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadTipoPrecio(utilidadtipoprecio);
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
			this.deepLoad(this.utilidadtipoprecio,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				UtilidadTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadTipoPrecio(this.utilidadtipoprecio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(UtilidadTipoPrecio.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(utilidadtipoprecios!=null) {
				for(UtilidadTipoPrecio utilidadtipoprecio:utilidadtipoprecios) {
					this.deepLoad(utilidadtipoprecio,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					UtilidadTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadTipoPrecio(utilidadtipoprecios);
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
			if(utilidadtipoprecios!=null) {
				for(UtilidadTipoPrecio utilidadtipoprecio:utilidadtipoprecios) {
					this.deepLoad(utilidadtipoprecio,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					UtilidadTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadTipoPrecio(utilidadtipoprecios);
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
			this.getNewConnexionToDeep(UtilidadTipoPrecio.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(utilidadtipoprecio,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(UtilidadTipoPrecio.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(utilidadtipoprecios!=null) {
				for(UtilidadTipoPrecio utilidadtipoprecio:utilidadtipoprecios) {
					this.deepSave(utilidadtipoprecio,isDeep,deepLoadType,clases);
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
			if(utilidadtipoprecios!=null) {
				for(UtilidadTipoPrecio utilidadtipoprecio:utilidadtipoprecios) {
					this.deepSave(utilidadtipoprecio,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getUtilidadTipoPreciosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadTipoPrecio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,UtilidadTipoPrecioConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			UtilidadTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			utilidadtipoprecios=utilidadtipoprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UtilidadTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadTipoPrecio(this.utilidadtipoprecios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getUtilidadTipoPreciosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,UtilidadTipoPrecioConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			UtilidadTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			utilidadtipoprecios=utilidadtipoprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UtilidadTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadTipoPrecio(this.utilidadtipoprecios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getUtilidadTipoPreciosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadTipoPrecio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,UtilidadTipoPrecioConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			UtilidadTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			utilidadtipoprecios=utilidadtipoprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UtilidadTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadTipoPrecio(this.utilidadtipoprecios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getUtilidadTipoPreciosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,UtilidadTipoPrecioConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			UtilidadTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			utilidadtipoprecios=utilidadtipoprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UtilidadTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadTipoPrecio(this.utilidadtipoprecios);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getUtilidadTipoPreciosFK_IdTipoPrecioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_precio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadTipoPrecio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPrecio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_precio,UtilidadTipoPrecioConstantesFunciones.IDTIPOPRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPrecio);

			UtilidadTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			utilidadtipoprecios=utilidadtipoprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UtilidadTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadTipoPrecio(this.utilidadtipoprecios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getUtilidadTipoPreciosFK_IdTipoPrecio(String sFinalQuery,Pagination pagination,Long id_tipo_precio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPrecio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPrecio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_precio,UtilidadTipoPrecioConstantesFunciones.IDTIPOPRECIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPrecio);

			UtilidadTipoPrecioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPrecio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			utilidadtipoprecios=utilidadtipoprecioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UtilidadTipoPrecioConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadTipoPrecio(this.utilidadtipoprecios);
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
			if(UtilidadTipoPrecioConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,UtilidadTipoPrecioDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,UtilidadTipoPrecio utilidadtipoprecio,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(UtilidadTipoPrecioConstantesFunciones.ISCONAUDITORIA) {
				if(utilidadtipoprecio.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,UtilidadTipoPrecioDataAccess.TABLENAME, utilidadtipoprecio.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(UtilidadTipoPrecioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////UtilidadTipoPrecioLogic.registrarAuditoriaDetallesUtilidadTipoPrecio(connexion,utilidadtipoprecio,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(utilidadtipoprecio.getIsDeleted()) {
					/*if(!utilidadtipoprecio.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,UtilidadTipoPrecioDataAccess.TABLENAME, utilidadtipoprecio.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////UtilidadTipoPrecioLogic.registrarAuditoriaDetallesUtilidadTipoPrecio(connexion,utilidadtipoprecio,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,UtilidadTipoPrecioDataAccess.TABLENAME, utilidadtipoprecio.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(utilidadtipoprecio.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,UtilidadTipoPrecioDataAccess.TABLENAME, utilidadtipoprecio.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(UtilidadTipoPrecioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////UtilidadTipoPrecioLogic.registrarAuditoriaDetallesUtilidadTipoPrecio(connexion,utilidadtipoprecio,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesUtilidadTipoPrecio(Connexion connexion,UtilidadTipoPrecio utilidadtipoprecio)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(utilidadtipoprecio.getIsNew()||!utilidadtipoprecio.getid_empresa().equals(utilidadtipoprecio.getUtilidadTipoPrecioOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(utilidadtipoprecio.getUtilidadTipoPrecioOriginal().getid_empresa()!=null)
				{
					strValorActual=utilidadtipoprecio.getUtilidadTipoPrecioOriginal().getid_empresa().toString();
				}
				if(utilidadtipoprecio.getid_empresa()!=null)
				{
					strValorNuevo=utilidadtipoprecio.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UtilidadTipoPrecioConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(utilidadtipoprecio.getIsNew()||!utilidadtipoprecio.getid_sucursal().equals(utilidadtipoprecio.getUtilidadTipoPrecioOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(utilidadtipoprecio.getUtilidadTipoPrecioOriginal().getid_sucursal()!=null)
				{
					strValorActual=utilidadtipoprecio.getUtilidadTipoPrecioOriginal().getid_sucursal().toString();
				}
				if(utilidadtipoprecio.getid_sucursal()!=null)
				{
					strValorNuevo=utilidadtipoprecio.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UtilidadTipoPrecioConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(utilidadtipoprecio.getIsNew()||!utilidadtipoprecio.getid_tipo_precio().equals(utilidadtipoprecio.getUtilidadTipoPrecioOriginal().getid_tipo_precio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(utilidadtipoprecio.getUtilidadTipoPrecioOriginal().getid_tipo_precio()!=null)
				{
					strValorActual=utilidadtipoprecio.getUtilidadTipoPrecioOriginal().getid_tipo_precio().toString();
				}
				if(utilidadtipoprecio.getid_tipo_precio()!=null)
				{
					strValorNuevo=utilidadtipoprecio.getid_tipo_precio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UtilidadTipoPrecioConstantesFunciones.IDTIPOPRECIO,strValorActual,strValorNuevo);
			}	
			
			if(utilidadtipoprecio.getIsNew()||!utilidadtipoprecio.getporcentaje().equals(utilidadtipoprecio.getUtilidadTipoPrecioOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(utilidadtipoprecio.getUtilidadTipoPrecioOriginal().getporcentaje()!=null)
				{
					strValorActual=utilidadtipoprecio.getUtilidadTipoPrecioOriginal().getporcentaje().toString();
				}
				if(utilidadtipoprecio.getporcentaje()!=null)
				{
					strValorNuevo=utilidadtipoprecio.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UtilidadTipoPrecioConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveUtilidadTipoPrecioRelacionesWithConnection(UtilidadTipoPrecio utilidadtipoprecio) throws Exception {

		if(!utilidadtipoprecio.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveUtilidadTipoPrecioRelacionesBase(utilidadtipoprecio,true);
		}
	}

	public void saveUtilidadTipoPrecioRelaciones(UtilidadTipoPrecio utilidadtipoprecio)throws Exception {

		if(!utilidadtipoprecio.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveUtilidadTipoPrecioRelacionesBase(utilidadtipoprecio,false);
		}
	}

	public void saveUtilidadTipoPrecioRelacionesBase(UtilidadTipoPrecio utilidadtipoprecio,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("UtilidadTipoPrecio-saveRelacionesWithConnection");}
	

			this.setUtilidadTipoPrecio(utilidadtipoprecio);

			if(UtilidadTipoPrecioLogicAdditional.validarSaveRelaciones(utilidadtipoprecio,this)) {

				UtilidadTipoPrecioLogicAdditional.updateRelacionesToSave(utilidadtipoprecio,this);

				if((utilidadtipoprecio.getIsNew()||utilidadtipoprecio.getIsChanged())&&!utilidadtipoprecio.getIsDeleted()) {
					this.saveUtilidadTipoPrecio();
					this.saveUtilidadTipoPrecioRelacionesDetalles();

				} else if(utilidadtipoprecio.getIsDeleted()) {
					this.saveUtilidadTipoPrecioRelacionesDetalles();
					this.saveUtilidadTipoPrecio();
				}

				UtilidadTipoPrecioLogicAdditional.updateRelacionesToSaveAfter(utilidadtipoprecio,this);

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
	
	
	private void saveUtilidadTipoPrecioRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfUtilidadTipoPrecio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=UtilidadTipoPrecioConstantesFunciones.getClassesForeignKeysOfUtilidadTipoPrecio(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfUtilidadTipoPrecio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=UtilidadTipoPrecioConstantesFunciones.getClassesRelationshipsOfUtilidadTipoPrecio(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

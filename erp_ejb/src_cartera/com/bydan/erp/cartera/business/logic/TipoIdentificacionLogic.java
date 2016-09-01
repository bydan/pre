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
import com.bydan.erp.cartera.util.TipoIdentificacionConstantesFunciones;
import com.bydan.erp.cartera.util.TipoIdentificacionParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoIdentificacionParameterGeneral;
import com.bydan.erp.cartera.business.entity.TipoIdentificacion;
import com.bydan.erp.cartera.business.logic.TipoIdentificacionLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;
import com.bydan.erp.comisiones.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoIdentificacionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoIdentificacionLogic.class);
	
	protected TipoIdentificacionDataAccess tipoidentificacionDataAccess; 	
	protected TipoIdentificacion tipoidentificacion;
	protected List<TipoIdentificacion> tipoidentificacions;
	protected Object tipoidentificacionObject;	
	protected List<Object> tipoidentificacionsObject;
	
	public static ClassValidator<TipoIdentificacion> tipoidentificacionValidator = new ClassValidator<TipoIdentificacion>(TipoIdentificacion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoIdentificacionLogicAdditional tipoidentificacionLogicAdditional=null;
	
	public TipoIdentificacionLogicAdditional getTipoIdentificacionLogicAdditional() {
		return this.tipoidentificacionLogicAdditional;
	}
	
	public void setTipoIdentificacionLogicAdditional(TipoIdentificacionLogicAdditional tipoidentificacionLogicAdditional) {
		try {
			this.tipoidentificacionLogicAdditional=tipoidentificacionLogicAdditional;
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
	
	
	
	
	public  TipoIdentificacionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoidentificacionDataAccess = new TipoIdentificacionDataAccess();
			
			this.tipoidentificacions= new ArrayList<TipoIdentificacion>();
			this.tipoidentificacion= new TipoIdentificacion();
			
			this.tipoidentificacionObject=new Object();
			this.tipoidentificacionsObject=new ArrayList<Object>();
				
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
			
			this.tipoidentificacionDataAccess.setConnexionType(this.connexionType);
			this.tipoidentificacionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoIdentificacionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoidentificacionDataAccess = new TipoIdentificacionDataAccess();
			this.tipoidentificacions= new ArrayList<TipoIdentificacion>();
			this.tipoidentificacion= new TipoIdentificacion();
			this.tipoidentificacionObject=new Object();
			this.tipoidentificacionsObject=new ArrayList<Object>();
			
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
			
			this.tipoidentificacionDataAccess.setConnexionType(this.connexionType);
			this.tipoidentificacionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoIdentificacion getTipoIdentificacion() throws Exception {	
		TipoIdentificacionLogicAdditional.checkTipoIdentificacionToGet(tipoidentificacion,this.datosCliente,this.arrDatoGeneral);
		TipoIdentificacionLogicAdditional.updateTipoIdentificacionToGet(tipoidentificacion,this.arrDatoGeneral);
		
		return tipoidentificacion;
	}
		
	public void setTipoIdentificacion(TipoIdentificacion newTipoIdentificacion) {
		this.tipoidentificacion = newTipoIdentificacion;
	}
	
	public TipoIdentificacionDataAccess getTipoIdentificacionDataAccess() {
		return tipoidentificacionDataAccess;
	}
	
	public void setTipoIdentificacionDataAccess(TipoIdentificacionDataAccess newtipoidentificacionDataAccess) {
		this.tipoidentificacionDataAccess = newtipoidentificacionDataAccess;
	}
	
	public List<TipoIdentificacion> getTipoIdentificacions() throws Exception {		
		this.quitarTipoIdentificacionsNulos();
		
		TipoIdentificacionLogicAdditional.checkTipoIdentificacionToGets(tipoidentificacions,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoIdentificacion tipoidentificacionLocal: tipoidentificacions ) {
			TipoIdentificacionLogicAdditional.updateTipoIdentificacionToGet(tipoidentificacionLocal,this.arrDatoGeneral);
		}
		
		return tipoidentificacions;
	}
	
	public void setTipoIdentificacions(List<TipoIdentificacion> newTipoIdentificacions) {
		this.tipoidentificacions = newTipoIdentificacions;
	}
	
	public Object getTipoIdentificacionObject() {	
		this.tipoidentificacionObject=this.tipoidentificacionDataAccess.getEntityObject();
		return this.tipoidentificacionObject;
	}
		
	public void setTipoIdentificacionObject(Object newTipoIdentificacionObject) {
		this.tipoidentificacionObject = newTipoIdentificacionObject;
	}
	
	public List<Object> getTipoIdentificacionsObject() {		
		this.tipoidentificacionsObject=this.tipoidentificacionDataAccess.getEntitiesObject();
		return this.tipoidentificacionsObject;
	}
		
	public void setTipoIdentificacionsObject(List<Object> newTipoIdentificacionsObject) {
		this.tipoidentificacionsObject = newTipoIdentificacionsObject;
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
		
		if(this.tipoidentificacionDataAccess!=null) {
			this.tipoidentificacionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIdentificacion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoidentificacionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoidentificacionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoidentificacion = new  TipoIdentificacion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIdentificacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoidentificacion=tipoidentificacionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoidentificacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoIdentificacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoIdentificacion(this.tipoidentificacion);
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
		tipoidentificacion = new  TipoIdentificacion();
		  		  
        try {
			
			tipoidentificacion=tipoidentificacionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoidentificacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoIdentificacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoIdentificacion(this.tipoidentificacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoidentificacion = new  TipoIdentificacion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIdentificacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoidentificacion=tipoidentificacionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoidentificacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoIdentificacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoIdentificacion(this.tipoidentificacion);
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
		tipoidentificacion = new  TipoIdentificacion();
		  		  
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
		tipoidentificacion = new  TipoIdentificacion();
		  		  
        try {
			
			tipoidentificacion=tipoidentificacionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoidentificacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoIdentificacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoIdentificacion(this.tipoidentificacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoidentificacion = new  TipoIdentificacion();
		  		  
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
		tipoidentificacion = new  TipoIdentificacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIdentificacion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoidentificacionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoidentificacion = new  TipoIdentificacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoidentificacionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoidentificacion = new  TipoIdentificacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIdentificacion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoidentificacionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoidentificacion = new  TipoIdentificacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoidentificacionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoidentificacion = new  TipoIdentificacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIdentificacion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoidentificacionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoidentificacion = new  TipoIdentificacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoidentificacionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoidentificacions = new  ArrayList<TipoIdentificacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIdentificacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoIdentificacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoidentificacions=tipoidentificacionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoIdentificacion(tipoidentificacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIdentificacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoIdentificacion(this.tipoidentificacions);
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
		tipoidentificacions = new  ArrayList<TipoIdentificacion>();
		  		  
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
		tipoidentificacions = new  ArrayList<TipoIdentificacion>();
		  		  
        try {			
			TipoIdentificacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoidentificacions=tipoidentificacionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoIdentificacion(tipoidentificacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIdentificacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoIdentificacion(this.tipoidentificacions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoidentificacions = new  ArrayList<TipoIdentificacion>();
		  		  
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
		tipoidentificacions = new  ArrayList<TipoIdentificacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIdentificacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoIdentificacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoidentificacions=tipoidentificacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoIdentificacion(tipoidentificacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIdentificacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoIdentificacion(this.tipoidentificacions);
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
		tipoidentificacions = new  ArrayList<TipoIdentificacion>();
		  		  
        try {
			TipoIdentificacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoidentificacions=tipoidentificacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoIdentificacion(tipoidentificacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIdentificacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoIdentificacion(this.tipoidentificacions);
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
		tipoidentificacions = new  ArrayList<TipoIdentificacion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIdentificacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoIdentificacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoidentificacions=tipoidentificacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoIdentificacion(tipoidentificacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIdentificacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoIdentificacion(this.tipoidentificacions);
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
		tipoidentificacions = new  ArrayList<TipoIdentificacion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoIdentificacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoidentificacions=tipoidentificacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoIdentificacion(tipoidentificacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIdentificacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoIdentificacion(this.tipoidentificacions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoidentificacion = new  TipoIdentificacion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIdentificacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoIdentificacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoidentificacion=tipoidentificacionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoIdentificacion(tipoidentificacion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIdentificacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoIdentificacion(this.tipoidentificacion);
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
		tipoidentificacion = new  TipoIdentificacion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoIdentificacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoidentificacion=tipoidentificacionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoIdentificacion(tipoidentificacion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIdentificacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoIdentificacion(this.tipoidentificacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoidentificacions = new  ArrayList<TipoIdentificacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIdentificacion.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoIdentificacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoidentificacions=tipoidentificacionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoIdentificacion(tipoidentificacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIdentificacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoIdentificacion(this.tipoidentificacions);
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
		tipoidentificacions = new  ArrayList<TipoIdentificacion>();
		  		  
        try {
			TipoIdentificacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoidentificacions=tipoidentificacionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoIdentificacion(tipoidentificacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIdentificacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoIdentificacion(this.tipoidentificacions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoIdentificacionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoidentificacions = new  ArrayList<TipoIdentificacion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIdentificacion.class.getSimpleName()+"-getTodosTipoIdentificacionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoIdentificacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoidentificacions=tipoidentificacionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoIdentificacion(tipoidentificacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIdentificacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoIdentificacion(this.tipoidentificacions);
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
	
	public  void  getTodosTipoIdentificacions(String sFinalQuery,Pagination pagination)throws Exception {
		tipoidentificacions = new  ArrayList<TipoIdentificacion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoIdentificacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoidentificacions=tipoidentificacionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoIdentificacion(tipoidentificacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoIdentificacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoIdentificacion(this.tipoidentificacions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoIdentificacion(TipoIdentificacion tipoidentificacion) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoidentificacion.getIsNew() || tipoidentificacion.getIsChanged()) { 
			this.invalidValues = tipoidentificacionValidator.getInvalidValues(tipoidentificacion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoidentificacion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoIdentificacion(List<TipoIdentificacion> TipoIdentificacions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoIdentificacion tipoidentificacionLocal:tipoidentificacions) {				
			estaValidadoObjeto=this.validarGuardarTipoIdentificacion(tipoidentificacionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoIdentificacion(List<TipoIdentificacion> TipoIdentificacions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoIdentificacion(tipoidentificacions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoIdentificacion(TipoIdentificacion TipoIdentificacion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoIdentificacion(tipoidentificacion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoIdentificacion tipoidentificacion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoidentificacion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoIdentificacionConstantesFunciones.getTipoIdentificacionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoidentificacion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoIdentificacionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoIdentificacionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoIdentificacionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIdentificacion.class.getSimpleName()+"-saveTipoIdentificacionWithConnection");connexion.begin();			
			
			TipoIdentificacionLogicAdditional.checkTipoIdentificacionToSave(this.tipoidentificacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoIdentificacionLogicAdditional.updateTipoIdentificacionToSave(this.tipoidentificacion,this.arrDatoGeneral);
			
			TipoIdentificacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoidentificacion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoIdentificacion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoIdentificacion(this.tipoidentificacion)) {
				TipoIdentificacionDataAccess.save(this.tipoidentificacion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoidentificacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoIdentificacionLogicAdditional.checkTipoIdentificacionToSaveAfter(this.tipoidentificacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoIdentificacion();
			
			connexion.commit();			
			
			if(this.tipoidentificacion.getIsDeleted()) {
				this.tipoidentificacion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoIdentificacion()throws Exception {	
		try {	
			
			TipoIdentificacionLogicAdditional.checkTipoIdentificacionToSave(this.tipoidentificacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoIdentificacionLogicAdditional.updateTipoIdentificacionToSave(this.tipoidentificacion,this.arrDatoGeneral);
			
			TipoIdentificacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoidentificacion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoIdentificacion(this.tipoidentificacion)) {			
				TipoIdentificacionDataAccess.save(this.tipoidentificacion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoidentificacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoIdentificacionLogicAdditional.checkTipoIdentificacionToSaveAfter(this.tipoidentificacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoidentificacion.getIsDeleted()) {
				this.tipoidentificacion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoIdentificacionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIdentificacion.class.getSimpleName()+"-saveTipoIdentificacionsWithConnection");connexion.begin();			
			
			TipoIdentificacionLogicAdditional.checkTipoIdentificacionToSaves(tipoidentificacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoIdentificacions();
			
			Boolean validadoTodosTipoIdentificacion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoIdentificacion tipoidentificacionLocal:tipoidentificacions) {		
				if(tipoidentificacionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoIdentificacionLogicAdditional.updateTipoIdentificacionToSave(tipoidentificacionLocal,this.arrDatoGeneral);
	        	
				TipoIdentificacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoidentificacionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoIdentificacion(tipoidentificacionLocal)) {
					TipoIdentificacionDataAccess.save(tipoidentificacionLocal, connexion);				
				} else {
					validadoTodosTipoIdentificacion=false;
				}
			}
			
			if(!validadoTodosTipoIdentificacion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoIdentificacionLogicAdditional.checkTipoIdentificacionToSavesAfter(tipoidentificacions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoIdentificacions();
			
			connexion.commit();		
			
			this.quitarTipoIdentificacionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoIdentificacions()throws Exception {				
		 try {	
			TipoIdentificacionLogicAdditional.checkTipoIdentificacionToSaves(tipoidentificacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoIdentificacion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoIdentificacion tipoidentificacionLocal:tipoidentificacions) {				
				if(tipoidentificacionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoIdentificacionLogicAdditional.updateTipoIdentificacionToSave(tipoidentificacionLocal,this.arrDatoGeneral);
	        	
				TipoIdentificacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoidentificacionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoIdentificacion(tipoidentificacionLocal)) {				
					TipoIdentificacionDataAccess.save(tipoidentificacionLocal, connexion);				
				} else {
					validadoTodosTipoIdentificacion=false;
				}
			}
			
			if(!validadoTodosTipoIdentificacion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoIdentificacionLogicAdditional.checkTipoIdentificacionToSavesAfter(tipoidentificacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoIdentificacionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoIdentificacionParameterReturnGeneral procesarAccionTipoIdentificacions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoIdentificacion> tipoidentificacions,TipoIdentificacionParameterReturnGeneral tipoidentificacionParameterGeneral)throws Exception {
		 try {	
			TipoIdentificacionParameterReturnGeneral tipoidentificacionReturnGeneral=new TipoIdentificacionParameterReturnGeneral();
	
			TipoIdentificacionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoidentificacions,tipoidentificacionParameterGeneral,tipoidentificacionReturnGeneral);
			
			return tipoidentificacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoIdentificacionParameterReturnGeneral procesarAccionTipoIdentificacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoIdentificacion> tipoidentificacions,TipoIdentificacionParameterReturnGeneral tipoidentificacionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIdentificacion.class.getSimpleName()+"-procesarAccionTipoIdentificacionsWithConnection");connexion.begin();			
			
			TipoIdentificacionParameterReturnGeneral tipoidentificacionReturnGeneral=new TipoIdentificacionParameterReturnGeneral();
	
			TipoIdentificacionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoidentificacions,tipoidentificacionParameterGeneral,tipoidentificacionReturnGeneral);
			
			this.connexion.commit();
			
			return tipoidentificacionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoIdentificacionParameterReturnGeneral procesarEventosTipoIdentificacions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoIdentificacion> tipoidentificacions,TipoIdentificacion tipoidentificacion,TipoIdentificacionParameterReturnGeneral tipoidentificacionParameterGeneral,Boolean isEsNuevoTipoIdentificacion,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoIdentificacionParameterReturnGeneral tipoidentificacionReturnGeneral=new TipoIdentificacionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoidentificacionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoIdentificacionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoidentificacions,tipoidentificacion,tipoidentificacionParameterGeneral,tipoidentificacionReturnGeneral,isEsNuevoTipoIdentificacion,clases);
			
			return tipoidentificacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoIdentificacionParameterReturnGeneral procesarEventosTipoIdentificacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoIdentificacion> tipoidentificacions,TipoIdentificacion tipoidentificacion,TipoIdentificacionParameterReturnGeneral tipoidentificacionParameterGeneral,Boolean isEsNuevoTipoIdentificacion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIdentificacion.class.getSimpleName()+"-procesarEventosTipoIdentificacionsWithConnection");connexion.begin();			
			
			TipoIdentificacionParameterReturnGeneral tipoidentificacionReturnGeneral=new TipoIdentificacionParameterReturnGeneral();
	
			tipoidentificacionReturnGeneral.setTipoIdentificacion(tipoidentificacion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoidentificacionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoIdentificacionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoidentificacions,tipoidentificacion,tipoidentificacionParameterGeneral,tipoidentificacionReturnGeneral,isEsNuevoTipoIdentificacion,clases);
			
			this.connexion.commit();
			
			return tipoidentificacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoIdentificacionParameterReturnGeneral procesarImportacionTipoIdentificacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoIdentificacionParameterReturnGeneral tipoidentificacionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIdentificacion.class.getSimpleName()+"-procesarImportacionTipoIdentificacionsWithConnection");connexion.begin();			
			
			TipoIdentificacionParameterReturnGeneral tipoidentificacionReturnGeneral=new TipoIdentificacionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoidentificacions=new ArrayList<TipoIdentificacion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoidentificacion=new TipoIdentificacion();
				
				
				if(conColumnasBase) {this.tipoidentificacion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoidentificacion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoidentificacion.setcodigo(arrColumnas[iColumn++]);
				this.tipoidentificacion.setnombre(arrColumnas[iColumn++]);
				
				this.tipoidentificacions.add(this.tipoidentificacion);
			}
			
			this.saveTipoIdentificacions();
			
			this.connexion.commit();
			
			tipoidentificacionReturnGeneral.setConRetornoEstaProcesado(true);
			tipoidentificacionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoidentificacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoIdentificacionsEliminados() throws Exception {				
		
		List<TipoIdentificacion> tipoidentificacionsAux= new ArrayList<TipoIdentificacion>();
		
		for(TipoIdentificacion tipoidentificacion:tipoidentificacions) {
			if(!tipoidentificacion.getIsDeleted()) {
				tipoidentificacionsAux.add(tipoidentificacion);
			}
		}
		
		tipoidentificacions=tipoidentificacionsAux;
	}
	
	public void quitarTipoIdentificacionsNulos() throws Exception {				
		
		List<TipoIdentificacion> tipoidentificacionsAux= new ArrayList<TipoIdentificacion>();
		
		for(TipoIdentificacion tipoidentificacion : this.tipoidentificacions) {
			if(tipoidentificacion==null) {
				tipoidentificacionsAux.add(tipoidentificacion);
			}
		}
		
		//this.tipoidentificacions=tipoidentificacionsAux;
		
		this.tipoidentificacions.removeAll(tipoidentificacionsAux);
	}
	
	public void getSetVersionRowTipoIdentificacionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoidentificacion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoidentificacion.getIsDeleted() || (tipoidentificacion.getIsChanged()&&!tipoidentificacion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoidentificacionDataAccess.getSetVersionRowTipoIdentificacion(connexion,tipoidentificacion.getId());
				
				if(!tipoidentificacion.getVersionRow().equals(timestamp)) {	
					tipoidentificacion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoidentificacion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoIdentificacion()throws Exception {	
		
		if(tipoidentificacion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoidentificacion.getIsDeleted() || (tipoidentificacion.getIsChanged()&&!tipoidentificacion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoidentificacionDataAccess.getSetVersionRowTipoIdentificacion(connexion,tipoidentificacion.getId());
			
			try {							
				if(!tipoidentificacion.getVersionRow().equals(timestamp)) {	
					tipoidentificacion.setVersionRow(timestamp);
				}
				
				tipoidentificacion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoIdentificacionsWithConnection()throws Exception {	
		if(tipoidentificacions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoIdentificacion tipoidentificacionAux:tipoidentificacions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoidentificacionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoidentificacionAux.getIsDeleted() || (tipoidentificacionAux.getIsChanged()&&!tipoidentificacionAux.getIsNew())) {
						
						timestamp=tipoidentificacionDataAccess.getSetVersionRowTipoIdentificacion(connexion,tipoidentificacionAux.getId());
						
						if(!tipoidentificacion.getVersionRow().equals(timestamp)) {	
							tipoidentificacionAux.setVersionRow(timestamp);
						}
								
						tipoidentificacionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoIdentificacions()throws Exception {	
		if(tipoidentificacions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoIdentificacion tipoidentificacionAux:tipoidentificacions) {
					if(tipoidentificacionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoidentificacionAux.getIsDeleted() || (tipoidentificacionAux.getIsChanged()&&!tipoidentificacionAux.getIsNew())) {
						
						timestamp=tipoidentificacionDataAccess.getSetVersionRowTipoIdentificacion(connexion,tipoidentificacionAux.getId());
						
						if(!tipoidentificacionAux.getVersionRow().equals(timestamp)) {	
							tipoidentificacionAux.setVersionRow(timestamp);
						}
						
													
						tipoidentificacionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyTipoIdentificacionWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ConyugeLogic conyugeLogic=new ConyugeLogic();
			CobradorLogic cobradorLogic=new CobradorLogic();
			RepresentanteLegalLogic representantelegalLogic=new RepresentanteLegalLogic();
			SubClienteLogic subclienteLogic=new SubClienteLogic();
			AccionistaLogic accionistaLogic=new AccionistaLogic();
			ClienteLogic clienteLogic=new ClienteLogic();
			ParametroCarteraDefectoLogic parametrocarteradefectoLogic=new ParametroCarteraDefectoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoIdentificacion.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoIdentificacionWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Conyuge.class));
			classes.add(new Classe(Cobrador.class));
			classes.add(new Classe(RepresentanteLegal.class));
			classes.add(new Classe(SubCliente.class));
			classes.add(new Classe(Accionista.class));
			classes.add(new Classe(Cliente.class));
			classes.add(new Classe(ParametroCarteraDefecto.class));
											
			

			conyugeLogic.setConnexion(this.getConnexion());
			conyugeLogic.setDatosCliente(this.datosCliente);
			conyugeLogic.setIsConRefrescarForeignKeys(true);

			cobradorLogic.setConnexion(this.getConnexion());
			cobradorLogic.setDatosCliente(this.datosCliente);
			cobradorLogic.setIsConRefrescarForeignKeys(true);

			representantelegalLogic.setConnexion(this.getConnexion());
			representantelegalLogic.setDatosCliente(this.datosCliente);
			representantelegalLogic.setIsConRefrescarForeignKeys(true);

			subclienteLogic.setConnexion(this.getConnexion());
			subclienteLogic.setDatosCliente(this.datosCliente);
			subclienteLogic.setIsConRefrescarForeignKeys(true);

			accionistaLogic.setConnexion(this.getConnexion());
			accionistaLogic.setDatosCliente(this.datosCliente);
			accionistaLogic.setIsConRefrescarForeignKeys(true);

			clienteLogic.setConnexion(this.getConnexion());
			clienteLogic.setDatosCliente(this.datosCliente);
			clienteLogic.setIsConRefrescarForeignKeys(true);

			parametrocarteradefectoLogic.setConnexion(this.getConnexion());
			parametrocarteradefectoLogic.setDatosCliente(this.datosCliente);
			parametrocarteradefectoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoIdentificacion tipoidentificacion:this.tipoidentificacions) {
				

				classes=new ArrayList<Classe>();
				classes=ConyugeConstantesFunciones.getClassesForeignKeysOfConyuge(new ArrayList<Classe>(),DeepLoadType.NONE);

				conyugeLogic.setConyuges(tipoidentificacion.conyuges);
				conyugeLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=CobradorConstantesFunciones.getClassesForeignKeysOfCobrador(new ArrayList<Classe>(),DeepLoadType.NONE);

				cobradorLogic.setCobradors(tipoidentificacion.cobradors);
				cobradorLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=RepresentanteLegalConstantesFunciones.getClassesForeignKeysOfRepresentanteLegal(new ArrayList<Classe>(),DeepLoadType.NONE);

				representantelegalLogic.setRepresentanteLegals(tipoidentificacion.representantelegals);
				representantelegalLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=SubClienteConstantesFunciones.getClassesForeignKeysOfSubCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				subclienteLogic.setSubClientes(tipoidentificacion.subclientes);
				subclienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=AccionistaConstantesFunciones.getClassesForeignKeysOfAccionista(new ArrayList<Classe>(),DeepLoadType.NONE);

				accionistaLogic.setAccionistas(tipoidentificacion.accionistas);
				accionistaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ClienteConstantesFunciones.getClassesForeignKeysOfCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				clienteLogic.setClientes(tipoidentificacion.clientes);
				clienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ParametroCarteraDefectoConstantesFunciones.getClassesForeignKeysOfParametroCarteraDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);

				parametrocarteradefectoLogic.setParametroCarteraDefectos(tipoidentificacion.parametrocarteradefectos);
				parametrocarteradefectoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoIdentificacion tipoidentificacion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoIdentificacionLogicAdditional.updateTipoIdentificacionToGet(tipoidentificacion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoidentificacion.setConyuges(tipoidentificacionDataAccess.getConyuges(connexion,tipoidentificacion));
		tipoidentificacion.setCobradors(tipoidentificacionDataAccess.getCobradors(connexion,tipoidentificacion));
		tipoidentificacion.setRepresentanteLegals(tipoidentificacionDataAccess.getRepresentanteLegals(connexion,tipoidentificacion));
		tipoidentificacion.setSubClientes(tipoidentificacionDataAccess.getSubClientes(connexion,tipoidentificacion));
		tipoidentificacion.setAccionistas(tipoidentificacionDataAccess.getAccionistas(connexion,tipoidentificacion));
		tipoidentificacion.setClientes(tipoidentificacionDataAccess.getClientes(connexion,tipoidentificacion));
		tipoidentificacion.setParametroCarteraDefectos(tipoidentificacionDataAccess.getParametroCarteraDefectos(connexion,tipoidentificacion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Conyuge.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoidentificacion.setConyuges(tipoidentificacionDataAccess.getConyuges(connexion,tipoidentificacion));

				if(this.isConDeep) {
					ConyugeLogic conyugeLogic= new ConyugeLogic(this.connexion);
					conyugeLogic.setConyuges(tipoidentificacion.getConyuges());
					ArrayList<Classe> classesLocal=ConyugeConstantesFunciones.getClassesForeignKeysOfConyuge(new ArrayList<Classe>(),DeepLoadType.NONE);
					conyugeLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ConyugeConstantesFunciones.refrescarForeignKeysDescripcionesConyuge(conyugeLogic.getConyuges());
					tipoidentificacion.setConyuges(conyugeLogic.getConyuges());
				}

				continue;
			}

			if(clas.clas.equals(Cobrador.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoidentificacion.setCobradors(tipoidentificacionDataAccess.getCobradors(connexion,tipoidentificacion));

				if(this.isConDeep) {
					CobradorLogic cobradorLogic= new CobradorLogic(this.connexion);
					cobradorLogic.setCobradors(tipoidentificacion.getCobradors());
					ArrayList<Classe> classesLocal=CobradorConstantesFunciones.getClassesForeignKeysOfCobrador(new ArrayList<Classe>(),DeepLoadType.NONE);
					cobradorLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CobradorConstantesFunciones.refrescarForeignKeysDescripcionesCobrador(cobradorLogic.getCobradors());
					tipoidentificacion.setCobradors(cobradorLogic.getCobradors());
				}

				continue;
			}

			if(clas.clas.equals(RepresentanteLegal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoidentificacion.setRepresentanteLegals(tipoidentificacionDataAccess.getRepresentanteLegals(connexion,tipoidentificacion));

				if(this.isConDeep) {
					RepresentanteLegalLogic representantelegalLogic= new RepresentanteLegalLogic(this.connexion);
					representantelegalLogic.setRepresentanteLegals(tipoidentificacion.getRepresentanteLegals());
					ArrayList<Classe> classesLocal=RepresentanteLegalConstantesFunciones.getClassesForeignKeysOfRepresentanteLegal(new ArrayList<Classe>(),DeepLoadType.NONE);
					representantelegalLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					RepresentanteLegalConstantesFunciones.refrescarForeignKeysDescripcionesRepresentanteLegal(representantelegalLogic.getRepresentanteLegals());
					tipoidentificacion.setRepresentanteLegals(representantelegalLogic.getRepresentanteLegals());
				}

				continue;
			}

			if(clas.clas.equals(SubCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoidentificacion.setSubClientes(tipoidentificacionDataAccess.getSubClientes(connexion,tipoidentificacion));

				if(this.isConDeep) {
					SubClienteLogic subclienteLogic= new SubClienteLogic(this.connexion);
					subclienteLogic.setSubClientes(tipoidentificacion.getSubClientes());
					ArrayList<Classe> classesLocal=SubClienteConstantesFunciones.getClassesForeignKeysOfSubCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					subclienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					SubClienteConstantesFunciones.refrescarForeignKeysDescripcionesSubCliente(subclienteLogic.getSubClientes());
					tipoidentificacion.setSubClientes(subclienteLogic.getSubClientes());
				}

				continue;
			}

			if(clas.clas.equals(Accionista.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoidentificacion.setAccionistas(tipoidentificacionDataAccess.getAccionistas(connexion,tipoidentificacion));

				if(this.isConDeep) {
					AccionistaLogic accionistaLogic= new AccionistaLogic(this.connexion);
					accionistaLogic.setAccionistas(tipoidentificacion.getAccionistas());
					ArrayList<Classe> classesLocal=AccionistaConstantesFunciones.getClassesForeignKeysOfAccionista(new ArrayList<Classe>(),DeepLoadType.NONE);
					accionistaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					AccionistaConstantesFunciones.refrescarForeignKeysDescripcionesAccionista(accionistaLogic.getAccionistas());
					tipoidentificacion.setAccionistas(accionistaLogic.getAccionistas());
				}

				continue;
			}

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoidentificacion.setClientes(tipoidentificacionDataAccess.getClientes(connexion,tipoidentificacion));

				if(this.isConDeep) {
					ClienteLogic clienteLogic= new ClienteLogic(this.connexion);
					clienteLogic.setClientes(tipoidentificacion.getClientes());
					ArrayList<Classe> classesLocal=ClienteConstantesFunciones.getClassesForeignKeysOfCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					clienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ClienteConstantesFunciones.refrescarForeignKeysDescripcionesCliente(clienteLogic.getClientes());
					tipoidentificacion.setClientes(clienteLogic.getClientes());
				}

				continue;
			}

			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoidentificacion.setParametroCarteraDefectos(tipoidentificacionDataAccess.getParametroCarteraDefectos(connexion,tipoidentificacion));

				if(this.isConDeep) {
					ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(this.connexion);
					parametrocarteradefectoLogic.setParametroCarteraDefectos(tipoidentificacion.getParametroCarteraDefectos());
					ArrayList<Classe> classesLocal=ParametroCarteraDefectoConstantesFunciones.getClassesForeignKeysOfParametroCarteraDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);
					parametrocarteradefectoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ParametroCarteraDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroCarteraDefecto(parametrocarteradefectoLogic.getParametroCarteraDefectos());
					tipoidentificacion.setParametroCarteraDefectos(parametrocarteradefectoLogic.getParametroCarteraDefectos());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


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
			tipoidentificacion.setConyuges(tipoidentificacionDataAccess.getConyuges(connexion,tipoidentificacion));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cobrador.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Cobrador.class));
			tipoidentificacion.setCobradors(tipoidentificacionDataAccess.getCobradors(connexion,tipoidentificacion));
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
			tipoidentificacion.setRepresentanteLegals(tipoidentificacionDataAccess.getRepresentanteLegals(connexion,tipoidentificacion));
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
			tipoidentificacion.setSubClientes(tipoidentificacionDataAccess.getSubClientes(connexion,tipoidentificacion));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Accionista.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Accionista.class));
			tipoidentificacion.setAccionistas(tipoidentificacionDataAccess.getAccionistas(connexion,tipoidentificacion));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Cliente.class));
			tipoidentificacion.setClientes(tipoidentificacionDataAccess.getClientes(connexion,tipoidentificacion));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroCarteraDefecto.class));
			tipoidentificacion.setParametroCarteraDefectos(tipoidentificacionDataAccess.getParametroCarteraDefectos(connexion,tipoidentificacion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		tipoidentificacion.setConyuges(tipoidentificacionDataAccess.getConyuges(connexion,tipoidentificacion));

		for(Conyuge conyuge:tipoidentificacion.getConyuges()) {
			ConyugeLogic conyugeLogic= new ConyugeLogic(connexion);
			conyugeLogic.deepLoad(conyuge,isDeep,deepLoadType,clases);
		}

		tipoidentificacion.setCobradors(tipoidentificacionDataAccess.getCobradors(connexion,tipoidentificacion));

		for(Cobrador cobrador:tipoidentificacion.getCobradors()) {
			CobradorLogic cobradorLogic= new CobradorLogic(connexion);
			cobradorLogic.deepLoad(cobrador,isDeep,deepLoadType,clases);
		}

		tipoidentificacion.setRepresentanteLegals(tipoidentificacionDataAccess.getRepresentanteLegals(connexion,tipoidentificacion));

		for(RepresentanteLegal representantelegal:tipoidentificacion.getRepresentanteLegals()) {
			RepresentanteLegalLogic representantelegalLogic= new RepresentanteLegalLogic(connexion);
			representantelegalLogic.deepLoad(representantelegal,isDeep,deepLoadType,clases);
		}

		tipoidentificacion.setSubClientes(tipoidentificacionDataAccess.getSubClientes(connexion,tipoidentificacion));

		for(SubCliente subcliente:tipoidentificacion.getSubClientes()) {
			SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
			subclienteLogic.deepLoad(subcliente,isDeep,deepLoadType,clases);
		}

		tipoidentificacion.setAccionistas(tipoidentificacionDataAccess.getAccionistas(connexion,tipoidentificacion));

		for(Accionista accionista:tipoidentificacion.getAccionistas()) {
			AccionistaLogic accionistaLogic= new AccionistaLogic(connexion);
			accionistaLogic.deepLoad(accionista,isDeep,deepLoadType,clases);
		}

		tipoidentificacion.setClientes(tipoidentificacionDataAccess.getClientes(connexion,tipoidentificacion));

		for(Cliente cliente:tipoidentificacion.getClientes()) {
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
		}

		tipoidentificacion.setParametroCarteraDefectos(tipoidentificacionDataAccess.getParametroCarteraDefectos(connexion,tipoidentificacion));

		for(ParametroCarteraDefecto parametrocarteradefecto:tipoidentificacion.getParametroCarteraDefectos()) {
			ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
			parametrocarteradefectoLogic.deepLoad(parametrocarteradefecto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Conyuge.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoidentificacion.setConyuges(tipoidentificacionDataAccess.getConyuges(connexion,tipoidentificacion));

				for(Conyuge conyuge:tipoidentificacion.getConyuges()) {
					ConyugeLogic conyugeLogic= new ConyugeLogic(connexion);
					conyugeLogic.deepLoad(conyuge,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Cobrador.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoidentificacion.setCobradors(tipoidentificacionDataAccess.getCobradors(connexion,tipoidentificacion));

				for(Cobrador cobrador:tipoidentificacion.getCobradors()) {
					CobradorLogic cobradorLogic= new CobradorLogic(connexion);
					cobradorLogic.deepLoad(cobrador,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(RepresentanteLegal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoidentificacion.setRepresentanteLegals(tipoidentificacionDataAccess.getRepresentanteLegals(connexion,tipoidentificacion));

				for(RepresentanteLegal representantelegal:tipoidentificacion.getRepresentanteLegals()) {
					RepresentanteLegalLogic representantelegalLogic= new RepresentanteLegalLogic(connexion);
					representantelegalLogic.deepLoad(representantelegal,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(SubCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoidentificacion.setSubClientes(tipoidentificacionDataAccess.getSubClientes(connexion,tipoidentificacion));

				for(SubCliente subcliente:tipoidentificacion.getSubClientes()) {
					SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
					subclienteLogic.deepLoad(subcliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Accionista.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoidentificacion.setAccionistas(tipoidentificacionDataAccess.getAccionistas(connexion,tipoidentificacion));

				for(Accionista accionista:tipoidentificacion.getAccionistas()) {
					AccionistaLogic accionistaLogic= new AccionistaLogic(connexion);
					accionistaLogic.deepLoad(accionista,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoidentificacion.setClientes(tipoidentificacionDataAccess.getClientes(connexion,tipoidentificacion));

				for(Cliente cliente:tipoidentificacion.getClientes()) {
					ClienteLogic clienteLogic= new ClienteLogic(connexion);
					clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoidentificacion.setParametroCarteraDefectos(tipoidentificacionDataAccess.getParametroCarteraDefectos(connexion,tipoidentificacion));

				for(ParametroCarteraDefecto parametrocarteradefecto:tipoidentificacion.getParametroCarteraDefectos()) {
					ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
					parametrocarteradefectoLogic.deepLoad(parametrocarteradefecto,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


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
			tipoidentificacion.setConyuges(tipoidentificacionDataAccess.getConyuges(connexion,tipoidentificacion));

			for(Conyuge conyuge:tipoidentificacion.getConyuges()) {
				ConyugeLogic conyugeLogic= new ConyugeLogic(connexion);
				conyugeLogic.deepLoad(conyuge,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cobrador.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Cobrador.class));
			tipoidentificacion.setCobradors(tipoidentificacionDataAccess.getCobradors(connexion,tipoidentificacion));

			for(Cobrador cobrador:tipoidentificacion.getCobradors()) {
				CobradorLogic cobradorLogic= new CobradorLogic(connexion);
				cobradorLogic.deepLoad(cobrador,isDeep,deepLoadType,clases);
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
			tipoidentificacion.setRepresentanteLegals(tipoidentificacionDataAccess.getRepresentanteLegals(connexion,tipoidentificacion));

			for(RepresentanteLegal representantelegal:tipoidentificacion.getRepresentanteLegals()) {
				RepresentanteLegalLogic representantelegalLogic= new RepresentanteLegalLogic(connexion);
				representantelegalLogic.deepLoad(representantelegal,isDeep,deepLoadType,clases);
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
			tipoidentificacion.setSubClientes(tipoidentificacionDataAccess.getSubClientes(connexion,tipoidentificacion));

			for(SubCliente subcliente:tipoidentificacion.getSubClientes()) {
				SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
				subclienteLogic.deepLoad(subcliente,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Accionista.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Accionista.class));
			tipoidentificacion.setAccionistas(tipoidentificacionDataAccess.getAccionistas(connexion,tipoidentificacion));

			for(Accionista accionista:tipoidentificacion.getAccionistas()) {
				AccionistaLogic accionistaLogic= new AccionistaLogic(connexion);
				accionistaLogic.deepLoad(accionista,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Cliente.class));
			tipoidentificacion.setClientes(tipoidentificacionDataAccess.getClientes(connexion,tipoidentificacion));

			for(Cliente cliente:tipoidentificacion.getClientes()) {
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(cliente,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroCarteraDefecto.class));
			tipoidentificacion.setParametroCarteraDefectos(tipoidentificacionDataAccess.getParametroCarteraDefectos(connexion,tipoidentificacion));

			for(ParametroCarteraDefecto parametrocarteradefecto:tipoidentificacion.getParametroCarteraDefectos()) {
				ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
				parametrocarteradefectoLogic.deepLoad(parametrocarteradefecto,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoIdentificacion tipoidentificacion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoIdentificacionLogicAdditional.updateTipoIdentificacionToSave(tipoidentificacion,this.arrDatoGeneral);
			
TipoIdentificacionDataAccess.save(tipoidentificacion, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(Conyuge conyuge:tipoidentificacion.getConyuges()) {
			conyuge.setidvaloridentificacion(tipoidentificacion.getId());
			ConyugeDataAccess.save(conyuge,connexion);
		}

		for(Cobrador cobrador:tipoidentificacion.getCobradors()) {
			cobrador.setid_tipo_identificacion(tipoidentificacion.getId());
			CobradorDataAccess.save(cobrador,connexion);
		}

		for(RepresentanteLegal representantelegal:tipoidentificacion.getRepresentanteLegals()) {
			representantelegal.setidvalorclientedocumento(tipoidentificacion.getId());
			RepresentanteLegalDataAccess.save(representantelegal,connexion);
		}

		for(SubCliente subcliente:tipoidentificacion.getSubClientes()) {
			subcliente.setid_tipo_identificacion(tipoidentificacion.getId());
			SubClienteDataAccess.save(subcliente,connexion);
		}

		for(Accionista accionista:tipoidentificacion.getAccionistas()) {
			accionista.setidvaloridentificacion(tipoidentificacion.getId());
			AccionistaDataAccess.save(accionista,connexion);
		}

		for(Cliente cliente:tipoidentificacion.getClientes()) {
			cliente.setid_tipo_identificacion(tipoidentificacion.getId());
			ClienteDataAccess.save(cliente,connexion);
		}

		for(ParametroCarteraDefecto parametrocarteradefecto:tipoidentificacion.getParametroCarteraDefectos()) {
			parametrocarteradefecto.setid_tipo_identificacion(tipoidentificacion.getId());
			ParametroCarteraDefectoDataAccess.save(parametrocarteradefecto,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(Conyuge.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Conyuge conyuge:tipoidentificacion.getConyuges()) {
					conyuge.setidvaloridentificacion(tipoidentificacion.getId());
					ConyugeDataAccess.save(conyuge,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Cobrador.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cobrador cobrador:tipoidentificacion.getCobradors()) {
					cobrador.setid_tipo_identificacion(tipoidentificacion.getId());
					CobradorDataAccess.save(cobrador,connexion);
				}
				continue;
			}

			if(clas.clas.equals(RepresentanteLegal.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(RepresentanteLegal representantelegal:tipoidentificacion.getRepresentanteLegals()) {
					representantelegal.setidvalorclientedocumento(tipoidentificacion.getId());
					RepresentanteLegalDataAccess.save(representantelegal,connexion);
				}
				continue;
			}

			if(clas.clas.equals(SubCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(SubCliente subcliente:tipoidentificacion.getSubClientes()) {
					subcliente.setid_tipo_identificacion(tipoidentificacion.getId());
					SubClienteDataAccess.save(subcliente,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Accionista.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Accionista accionista:tipoidentificacion.getAccionistas()) {
					accionista.setidvaloridentificacion(tipoidentificacion.getId());
					AccionistaDataAccess.save(accionista,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cliente cliente:tipoidentificacion.getClientes()) {
					cliente.setid_tipo_identificacion(tipoidentificacion.getId());
					ClienteDataAccess.save(cliente,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroCarteraDefecto parametrocarteradefecto:tipoidentificacion.getParametroCarteraDefectos()) {
					parametrocarteradefecto.setid_tipo_identificacion(tipoidentificacion.getId());
					ParametroCarteraDefectoDataAccess.save(parametrocarteradefecto,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(Conyuge conyuge:tipoidentificacion.getConyuges()) {
			ConyugeLogic conyugeLogic= new ConyugeLogic(connexion);
			conyuge.setidvaloridentificacion(tipoidentificacion.getId());
			ConyugeDataAccess.save(conyuge,connexion);
			conyugeLogic.deepSave(conyuge,isDeep,deepLoadType,clases);
		}

		for(Cobrador cobrador:tipoidentificacion.getCobradors()) {
			CobradorLogic cobradorLogic= new CobradorLogic(connexion);
			cobrador.setid_tipo_identificacion(tipoidentificacion.getId());
			CobradorDataAccess.save(cobrador,connexion);
			cobradorLogic.deepSave(cobrador,isDeep,deepLoadType,clases);
		}

		for(RepresentanteLegal representantelegal:tipoidentificacion.getRepresentanteLegals()) {
			RepresentanteLegalLogic representantelegalLogic= new RepresentanteLegalLogic(connexion);
			representantelegal.setidvalorclientedocumento(tipoidentificacion.getId());
			RepresentanteLegalDataAccess.save(representantelegal,connexion);
			representantelegalLogic.deepSave(representantelegal,isDeep,deepLoadType,clases);
		}

		for(SubCliente subcliente:tipoidentificacion.getSubClientes()) {
			SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
			subcliente.setid_tipo_identificacion(tipoidentificacion.getId());
			SubClienteDataAccess.save(subcliente,connexion);
			subclienteLogic.deepSave(subcliente,isDeep,deepLoadType,clases);
		}

		for(Accionista accionista:tipoidentificacion.getAccionistas()) {
			AccionistaLogic accionistaLogic= new AccionistaLogic(connexion);
			accionista.setidvaloridentificacion(tipoidentificacion.getId());
			AccionistaDataAccess.save(accionista,connexion);
			accionistaLogic.deepSave(accionista,isDeep,deepLoadType,clases);
		}

		for(Cliente cliente:tipoidentificacion.getClientes()) {
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			cliente.setid_tipo_identificacion(tipoidentificacion.getId());
			ClienteDataAccess.save(cliente,connexion);
			clienteLogic.deepSave(cliente,isDeep,deepLoadType,clases);
		}

		for(ParametroCarteraDefecto parametrocarteradefecto:tipoidentificacion.getParametroCarteraDefectos()) {
			ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
			parametrocarteradefecto.setid_tipo_identificacion(tipoidentificacion.getId());
			ParametroCarteraDefectoDataAccess.save(parametrocarteradefecto,connexion);
			parametrocarteradefectoLogic.deepSave(parametrocarteradefecto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(Conyuge.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Conyuge conyuge:tipoidentificacion.getConyuges()) {
					ConyugeLogic conyugeLogic= new ConyugeLogic(connexion);
					conyuge.setidvaloridentificacion(tipoidentificacion.getId());
					ConyugeDataAccess.save(conyuge,connexion);
					conyugeLogic.deepSave(conyuge,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Cobrador.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cobrador cobrador:tipoidentificacion.getCobradors()) {
					CobradorLogic cobradorLogic= new CobradorLogic(connexion);
					cobrador.setid_tipo_identificacion(tipoidentificacion.getId());
					CobradorDataAccess.save(cobrador,connexion);
					cobradorLogic.deepSave(cobrador,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(RepresentanteLegal.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(RepresentanteLegal representantelegal:tipoidentificacion.getRepresentanteLegals()) {
					RepresentanteLegalLogic representantelegalLogic= new RepresentanteLegalLogic(connexion);
					representantelegal.setidvalorclientedocumento(tipoidentificacion.getId());
					RepresentanteLegalDataAccess.save(representantelegal,connexion);
					representantelegalLogic.deepSave(representantelegal,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(SubCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(SubCliente subcliente:tipoidentificacion.getSubClientes()) {
					SubClienteLogic subclienteLogic= new SubClienteLogic(connexion);
					subcliente.setid_tipo_identificacion(tipoidentificacion.getId());
					SubClienteDataAccess.save(subcliente,connexion);
					subclienteLogic.deepSave(subcliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Accionista.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Accionista accionista:tipoidentificacion.getAccionistas()) {
					AccionistaLogic accionistaLogic= new AccionistaLogic(connexion);
					accionista.setidvaloridentificacion(tipoidentificacion.getId());
					AccionistaDataAccess.save(accionista,connexion);
					accionistaLogic.deepSave(accionista,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Cliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cliente cliente:tipoidentificacion.getClientes()) {
					ClienteLogic clienteLogic= new ClienteLogic(connexion);
					cliente.setid_tipo_identificacion(tipoidentificacion.getId());
					ClienteDataAccess.save(cliente,connexion);
					clienteLogic.deepSave(cliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroCarteraDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroCarteraDefecto parametrocarteradefecto:tipoidentificacion.getParametroCarteraDefectos()) {
					ParametroCarteraDefectoLogic parametrocarteradefectoLogic= new ParametroCarteraDefectoLogic(connexion);
					parametrocarteradefecto.setid_tipo_identificacion(tipoidentificacion.getId());
					ParametroCarteraDefectoDataAccess.save(parametrocarteradefecto,connexion);
					parametrocarteradefectoLogic.deepSave(parametrocarteradefecto,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoIdentificacion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoidentificacion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoIdentificacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoIdentificacion(tipoidentificacion);
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
			this.deepLoad(this.tipoidentificacion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoIdentificacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoIdentificacion(this.tipoidentificacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoIdentificacion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoidentificacions!=null) {
				for(TipoIdentificacion tipoidentificacion:tipoidentificacions) {
					this.deepLoad(tipoidentificacion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoIdentificacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoIdentificacion(tipoidentificacions);
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
			if(tipoidentificacions!=null) {
				for(TipoIdentificacion tipoidentificacion:tipoidentificacions) {
					this.deepLoad(tipoidentificacion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoIdentificacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoIdentificacion(tipoidentificacions);
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
			this.getNewConnexionToDeep(TipoIdentificacion.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipoidentificacion,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoIdentificacion.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipoidentificacions!=null) {
				for(TipoIdentificacion tipoidentificacion:tipoidentificacions) {
					this.deepSave(tipoidentificacion,isDeep,deepLoadType,clases);
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
			if(tipoidentificacions!=null) {
				for(TipoIdentificacion tipoidentificacion:tipoidentificacions) {
					this.deepSave(tipoidentificacion,isDeep,deepLoadType,clases);
				}		
			}
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
			if(TipoIdentificacionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoIdentificacionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoIdentificacion tipoidentificacion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoIdentificacionConstantesFunciones.ISCONAUDITORIA) {
				if(tipoidentificacion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoIdentificacionDataAccess.TABLENAME, tipoidentificacion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoIdentificacionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoIdentificacionLogic.registrarAuditoriaDetallesTipoIdentificacion(connexion,tipoidentificacion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoidentificacion.getIsDeleted()) {
					/*if(!tipoidentificacion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoIdentificacionDataAccess.TABLENAME, tipoidentificacion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoIdentificacionLogic.registrarAuditoriaDetallesTipoIdentificacion(connexion,tipoidentificacion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoIdentificacionDataAccess.TABLENAME, tipoidentificacion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoidentificacion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoIdentificacionDataAccess.TABLENAME, tipoidentificacion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoIdentificacionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoIdentificacionLogic.registrarAuditoriaDetallesTipoIdentificacion(connexion,tipoidentificacion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoIdentificacion(Connexion connexion,TipoIdentificacion tipoidentificacion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoidentificacion.getIsNew()||!tipoidentificacion.getcodigo().equals(tipoidentificacion.getTipoIdentificacionOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoidentificacion.getTipoIdentificacionOriginal().getcodigo()!=null)
				{
					strValorActual=tipoidentificacion.getTipoIdentificacionOriginal().getcodigo();
				}
				if(tipoidentificacion.getcodigo()!=null)
				{
					strValorNuevo=tipoidentificacion.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoIdentificacionConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipoidentificacion.getIsNew()||!tipoidentificacion.getnombre().equals(tipoidentificacion.getTipoIdentificacionOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoidentificacion.getTipoIdentificacionOriginal().getnombre()!=null)
				{
					strValorActual=tipoidentificacion.getTipoIdentificacionOriginal().getnombre();
				}
				if(tipoidentificacion.getnombre()!=null)
				{
					strValorNuevo=tipoidentificacion.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoIdentificacionConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoIdentificacionRelacionesWithConnection(TipoIdentificacion tipoidentificacion,List<Conyuge> conyuges,List<Cobrador> cobradors,List<RepresentanteLegal> representantelegals,List<SubCliente> subclientes,List<Accionista> accionistas,List<Cliente> clientes,List<ParametroCarteraDefecto> parametrocarteradefectos) throws Exception {

		if(!tipoidentificacion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoIdentificacionRelacionesBase(tipoidentificacion,conyuges,cobradors,representantelegals,subclientes,accionistas,clientes,parametrocarteradefectos,true);
		}
	}

	public void saveTipoIdentificacionRelaciones(TipoIdentificacion tipoidentificacion,List<Conyuge> conyuges,List<Cobrador> cobradors,List<RepresentanteLegal> representantelegals,List<SubCliente> subclientes,List<Accionista> accionistas,List<Cliente> clientes,List<ParametroCarteraDefecto> parametrocarteradefectos)throws Exception {

		if(!tipoidentificacion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoIdentificacionRelacionesBase(tipoidentificacion,conyuges,cobradors,representantelegals,subclientes,accionistas,clientes,parametrocarteradefectos,false);
		}
	}

	public void saveTipoIdentificacionRelacionesBase(TipoIdentificacion tipoidentificacion,List<Conyuge> conyuges,List<Cobrador> cobradors,List<RepresentanteLegal> representantelegals,List<SubCliente> subclientes,List<Accionista> accionistas,List<Cliente> clientes,List<ParametroCarteraDefecto> parametrocarteradefectos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoIdentificacion-saveRelacionesWithConnection");}
	
			tipoidentificacion.setConyuges(conyuges);
			tipoidentificacion.setCobradors(cobradors);
			tipoidentificacion.setRepresentanteLegals(representantelegals);
			tipoidentificacion.setSubClientes(subclientes);
			tipoidentificacion.setAccionistas(accionistas);
			tipoidentificacion.setClientes(clientes);
			tipoidentificacion.setParametroCarteraDefectos(parametrocarteradefectos);

			this.setTipoIdentificacion(tipoidentificacion);

				if((tipoidentificacion.getIsNew()||tipoidentificacion.getIsChanged())&&!tipoidentificacion.getIsDeleted()) {
					this.saveTipoIdentificacion();
					this.saveTipoIdentificacionRelacionesDetalles(conyuges,cobradors,representantelegals,subclientes,accionistas,clientes,parametrocarteradefectos);

				} else if(tipoidentificacion.getIsDeleted()) {
					this.saveTipoIdentificacionRelacionesDetalles(conyuges,cobradors,representantelegals,subclientes,accionistas,clientes,parametrocarteradefectos);
					this.saveTipoIdentificacion();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ConyugeConstantesFunciones.InicializarGeneralEntityAuxiliaresConyuges(conyuges,true,true);
			CobradorConstantesFunciones.InicializarGeneralEntityAuxiliaresCobradors(cobradors,true,true);
			RepresentanteLegalConstantesFunciones.InicializarGeneralEntityAuxiliaresRepresentanteLegals(representantelegals,true,true);
			SubClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresSubClientes(subclientes,true,true);
			AccionistaConstantesFunciones.InicializarGeneralEntityAuxiliaresAccionistas(accionistas,true,true);
			ClienteConstantesFunciones.InicializarGeneralEntityAuxiliaresClientes(clientes,true,true);
			ParametroCarteraDefectoConstantesFunciones.InicializarGeneralEntityAuxiliaresParametroCarteraDefectos(parametrocarteradefectos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoIdentificacionRelacionesDetalles(List<Conyuge> conyuges,List<Cobrador> cobradors,List<RepresentanteLegal> representantelegals,List<SubCliente> subclientes,List<Accionista> accionistas,List<Cliente> clientes,List<ParametroCarteraDefecto> parametrocarteradefectos)throws Exception {
		try {
	

			Long idTipoIdentificacionActual=this.getTipoIdentificacion().getId();

			ConyugeLogic conyugeLogic_Desde_TipoIdentificacion=new ConyugeLogic();
			conyugeLogic_Desde_TipoIdentificacion.setConyuges(conyuges);

			conyugeLogic_Desde_TipoIdentificacion.setConnexion(this.getConnexion());
			conyugeLogic_Desde_TipoIdentificacion.setDatosCliente(this.datosCliente);

			for(Conyuge conyuge_Desde_TipoIdentificacion:conyugeLogic_Desde_TipoIdentificacion.getConyuges()) {
				conyuge_Desde_TipoIdentificacion.setidvaloridentificacion(idTipoIdentificacionActual);
			}

			conyugeLogic_Desde_TipoIdentificacion.saveConyuges();

			CobradorLogic cobradorLogic_Desde_TipoIdentificacion=new CobradorLogic();
			cobradorLogic_Desde_TipoIdentificacion.setCobradors(cobradors);

			cobradorLogic_Desde_TipoIdentificacion.setConnexion(this.getConnexion());
			cobradorLogic_Desde_TipoIdentificacion.setDatosCliente(this.datosCliente);

			for(Cobrador cobrador_Desde_TipoIdentificacion:cobradorLogic_Desde_TipoIdentificacion.getCobradors()) {
				cobrador_Desde_TipoIdentificacion.setid_tipo_identificacion(idTipoIdentificacionActual);
			}

			cobradorLogic_Desde_TipoIdentificacion.saveCobradors();

			RepresentanteLegalLogic representantelegalLogic_Desde_TipoIdentificacion=new RepresentanteLegalLogic();
			representantelegalLogic_Desde_TipoIdentificacion.setRepresentanteLegals(representantelegals);

			representantelegalLogic_Desde_TipoIdentificacion.setConnexion(this.getConnexion());
			representantelegalLogic_Desde_TipoIdentificacion.setDatosCliente(this.datosCliente);

			for(RepresentanteLegal representantelegal_Desde_TipoIdentificacion:representantelegalLogic_Desde_TipoIdentificacion.getRepresentanteLegals()) {
				representantelegal_Desde_TipoIdentificacion.setidvalorclientedocumento(idTipoIdentificacionActual);
			}

			representantelegalLogic_Desde_TipoIdentificacion.saveRepresentanteLegals();

			SubClienteLogic subclienteLogic_Desde_TipoIdentificacion=new SubClienteLogic();
			subclienteLogic_Desde_TipoIdentificacion.setSubClientes(subclientes);

			subclienteLogic_Desde_TipoIdentificacion.setConnexion(this.getConnexion());
			subclienteLogic_Desde_TipoIdentificacion.setDatosCliente(this.datosCliente);

			for(SubCliente subcliente_Desde_TipoIdentificacion:subclienteLogic_Desde_TipoIdentificacion.getSubClientes()) {
				subcliente_Desde_TipoIdentificacion.setid_tipo_identificacion(idTipoIdentificacionActual);

				subclienteLogic_Desde_TipoIdentificacion.setSubCliente(subcliente_Desde_TipoIdentificacion);
				subclienteLogic_Desde_TipoIdentificacion.saveSubCliente();
			}


			AccionistaLogic accionistaLogic_Desde_TipoIdentificacion=new AccionistaLogic();
			accionistaLogic_Desde_TipoIdentificacion.setAccionistas(accionistas);

			accionistaLogic_Desde_TipoIdentificacion.setConnexion(this.getConnexion());
			accionistaLogic_Desde_TipoIdentificacion.setDatosCliente(this.datosCliente);

			for(Accionista accionista_Desde_TipoIdentificacion:accionistaLogic_Desde_TipoIdentificacion.getAccionistas()) {
				accionista_Desde_TipoIdentificacion.setidvaloridentificacion(idTipoIdentificacionActual);
			}

			accionistaLogic_Desde_TipoIdentificacion.saveAccionistas();

			ClienteLogic clienteLogic_Desde_TipoIdentificacion=new ClienteLogic();
			clienteLogic_Desde_TipoIdentificacion.setClientes(clientes);

			clienteLogic_Desde_TipoIdentificacion.setConnexion(this.getConnexion());
			clienteLogic_Desde_TipoIdentificacion.setDatosCliente(this.datosCliente);

			for(Cliente cliente_Desde_TipoIdentificacion:clienteLogic_Desde_TipoIdentificacion.getClientes()) {
				cliente_Desde_TipoIdentificacion.setid_tipo_identificacion(idTipoIdentificacionActual);

				clienteLogic_Desde_TipoIdentificacion.setCliente(cliente_Desde_TipoIdentificacion);
				clienteLogic_Desde_TipoIdentificacion.saveCliente();
			}


			ParametroCarteraDefectoLogic parametrocarteradefectoLogic_Desde_TipoIdentificacion=new ParametroCarteraDefectoLogic();
			parametrocarteradefectoLogic_Desde_TipoIdentificacion.setParametroCarteraDefectos(parametrocarteradefectos);

			parametrocarteradefectoLogic_Desde_TipoIdentificacion.setConnexion(this.getConnexion());
			parametrocarteradefectoLogic_Desde_TipoIdentificacion.setDatosCliente(this.datosCliente);

			for(ParametroCarteraDefecto parametrocarteradefecto_Desde_TipoIdentificacion:parametrocarteradefectoLogic_Desde_TipoIdentificacion.getParametroCarteraDefectos()) {
				parametrocarteradefecto_Desde_TipoIdentificacion.setid_tipo_identificacion(idTipoIdentificacionActual);
			}

			parametrocarteradefectoLogic_Desde_TipoIdentificacion.saveParametroCarteraDefectos();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoIdentificacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoIdentificacionConstantesFunciones.getClassesForeignKeysOfTipoIdentificacion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoIdentificacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoIdentificacionConstantesFunciones.getClassesRelationshipsOfTipoIdentificacion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

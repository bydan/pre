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
package com.bydan.erp.activosfijos.business.logic;

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
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.activosfijos.util.TipoCalculoDepreciacionConstantesFunciones;
import com.bydan.erp.activosfijos.util.TipoCalculoDepreciacionParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.TipoCalculoDepreciacionParameterGeneral;
import com.bydan.erp.activosfijos.business.entity.TipoCalculoDepreciacion;
//import com.bydan.erp.activosfijos.business.logic.TipoCalculoDepreciacionLogicAdditional;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoCalculoDepreciacionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoCalculoDepreciacionLogic.class);
	
	protected TipoCalculoDepreciacionDataAccess tipocalculodepreciacionDataAccess; 	
	protected TipoCalculoDepreciacion tipocalculodepreciacion;
	protected List<TipoCalculoDepreciacion> tipocalculodepreciacions;
	protected Object tipocalculodepreciacionObject;	
	protected List<Object> tipocalculodepreciacionsObject;
	
	public static ClassValidator<TipoCalculoDepreciacion> tipocalculodepreciacionValidator = new ClassValidator<TipoCalculoDepreciacion>(TipoCalculoDepreciacion.class);	
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
	
	
	
	
	public  TipoCalculoDepreciacionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipocalculodepreciacionDataAccess = new TipoCalculoDepreciacionDataAccess();
			
			this.tipocalculodepreciacions= new ArrayList<TipoCalculoDepreciacion>();
			this.tipocalculodepreciacion= new TipoCalculoDepreciacion();
			
			this.tipocalculodepreciacionObject=new Object();
			this.tipocalculodepreciacionsObject=new ArrayList<Object>();
				
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
			
			this.tipocalculodepreciacionDataAccess.setConnexionType(this.connexionType);
			this.tipocalculodepreciacionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoCalculoDepreciacionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipocalculodepreciacionDataAccess = new TipoCalculoDepreciacionDataAccess();
			this.tipocalculodepreciacions= new ArrayList<TipoCalculoDepreciacion>();
			this.tipocalculodepreciacion= new TipoCalculoDepreciacion();
			this.tipocalculodepreciacionObject=new Object();
			this.tipocalculodepreciacionsObject=new ArrayList<Object>();
			
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
			
			this.tipocalculodepreciacionDataAccess.setConnexionType(this.connexionType);
			this.tipocalculodepreciacionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoCalculoDepreciacion getTipoCalculoDepreciacion() throws Exception {	
		//TipoCalculoDepreciacionLogicAdditional.checkTipoCalculoDepreciacionToGet(tipocalculodepreciacion,this.datosCliente,this.arrDatoGeneral);
		//TipoCalculoDepreciacionLogicAdditional.updateTipoCalculoDepreciacionToGet(tipocalculodepreciacion,this.arrDatoGeneral);
		
		return tipocalculodepreciacion;
	}
		
	public void setTipoCalculoDepreciacion(TipoCalculoDepreciacion newTipoCalculoDepreciacion) {
		this.tipocalculodepreciacion = newTipoCalculoDepreciacion;
	}
	
	public TipoCalculoDepreciacionDataAccess getTipoCalculoDepreciacionDataAccess() {
		return tipocalculodepreciacionDataAccess;
	}
	
	public void setTipoCalculoDepreciacionDataAccess(TipoCalculoDepreciacionDataAccess newtipocalculodepreciacionDataAccess) {
		this.tipocalculodepreciacionDataAccess = newtipocalculodepreciacionDataAccess;
	}
	
	public List<TipoCalculoDepreciacion> getTipoCalculoDepreciacions() throws Exception {		
		this.quitarTipoCalculoDepreciacionsNulos();
		
		//TipoCalculoDepreciacionLogicAdditional.checkTipoCalculoDepreciacionToGets(tipocalculodepreciacions,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoCalculoDepreciacion tipocalculodepreciacionLocal: tipocalculodepreciacions ) {
			//TipoCalculoDepreciacionLogicAdditional.updateTipoCalculoDepreciacionToGet(tipocalculodepreciacionLocal,this.arrDatoGeneral);
		}
		
		return tipocalculodepreciacions;
	}
	
	public void setTipoCalculoDepreciacions(List<TipoCalculoDepreciacion> newTipoCalculoDepreciacions) {
		this.tipocalculodepreciacions = newTipoCalculoDepreciacions;
	}
	
	public Object getTipoCalculoDepreciacionObject() {	
		this.tipocalculodepreciacionObject=this.tipocalculodepreciacionDataAccess.getEntityObject();
		return this.tipocalculodepreciacionObject;
	}
		
	public void setTipoCalculoDepreciacionObject(Object newTipoCalculoDepreciacionObject) {
		this.tipocalculodepreciacionObject = newTipoCalculoDepreciacionObject;
	}
	
	public List<Object> getTipoCalculoDepreciacionsObject() {		
		this.tipocalculodepreciacionsObject=this.tipocalculodepreciacionDataAccess.getEntitiesObject();
		return this.tipocalculodepreciacionsObject;
	}
		
	public void setTipoCalculoDepreciacionsObject(List<Object> newTipoCalculoDepreciacionsObject) {
		this.tipocalculodepreciacionsObject = newTipoCalculoDepreciacionsObject;
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
		
		if(this.tipocalculodepreciacionDataAccess!=null) {
			this.tipocalculodepreciacionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCalculoDepreciacion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipocalculodepreciacionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipocalculodepreciacionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipocalculodepreciacion = new  TipoCalculoDepreciacion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCalculoDepreciacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipocalculodepreciacion=tipocalculodepreciacionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocalculodepreciacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCalculoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalculoDepreciacion(this.tipocalculodepreciacion);
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
		tipocalculodepreciacion = new  TipoCalculoDepreciacion();
		  		  
        try {
			
			tipocalculodepreciacion=tipocalculodepreciacionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocalculodepreciacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCalculoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalculoDepreciacion(this.tipocalculodepreciacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipocalculodepreciacion = new  TipoCalculoDepreciacion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCalculoDepreciacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipocalculodepreciacion=tipocalculodepreciacionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocalculodepreciacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCalculoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalculoDepreciacion(this.tipocalculodepreciacion);
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
		tipocalculodepreciacion = new  TipoCalculoDepreciacion();
		  		  
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
		tipocalculodepreciacion = new  TipoCalculoDepreciacion();
		  		  
        try {
			
			tipocalculodepreciacion=tipocalculodepreciacionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocalculodepreciacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCalculoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalculoDepreciacion(this.tipocalculodepreciacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipocalculodepreciacion = new  TipoCalculoDepreciacion();
		  		  
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
		tipocalculodepreciacion = new  TipoCalculoDepreciacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCalculoDepreciacion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipocalculodepreciacionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocalculodepreciacion = new  TipoCalculoDepreciacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipocalculodepreciacionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipocalculodepreciacion = new  TipoCalculoDepreciacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCalculoDepreciacion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipocalculodepreciacionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocalculodepreciacion = new  TipoCalculoDepreciacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipocalculodepreciacionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipocalculodepreciacion = new  TipoCalculoDepreciacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCalculoDepreciacion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipocalculodepreciacionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocalculodepreciacion = new  TipoCalculoDepreciacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipocalculodepreciacionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipocalculodepreciacions = new  ArrayList<TipoCalculoDepreciacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCalculoDepreciacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoCalculoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocalculodepreciacions=tipocalculodepreciacionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCalculoDepreciacion(tipocalculodepreciacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCalculoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalculoDepreciacion(this.tipocalculodepreciacions);
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
		tipocalculodepreciacions = new  ArrayList<TipoCalculoDepreciacion>();
		  		  
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
		tipocalculodepreciacions = new  ArrayList<TipoCalculoDepreciacion>();
		  		  
        try {			
			TipoCalculoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocalculodepreciacions=tipocalculodepreciacionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoCalculoDepreciacion(tipocalculodepreciacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCalculoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalculoDepreciacion(this.tipocalculodepreciacions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipocalculodepreciacions = new  ArrayList<TipoCalculoDepreciacion>();
		  		  
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
		tipocalculodepreciacions = new  ArrayList<TipoCalculoDepreciacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCalculoDepreciacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoCalculoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocalculodepreciacions=tipocalculodepreciacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCalculoDepreciacion(tipocalculodepreciacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCalculoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalculoDepreciacion(this.tipocalculodepreciacions);
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
		tipocalculodepreciacions = new  ArrayList<TipoCalculoDepreciacion>();
		  		  
        try {
			TipoCalculoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocalculodepreciacions=tipocalculodepreciacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCalculoDepreciacion(tipocalculodepreciacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCalculoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalculoDepreciacion(this.tipocalculodepreciacions);
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
		tipocalculodepreciacions = new  ArrayList<TipoCalculoDepreciacion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCalculoDepreciacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCalculoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocalculodepreciacions=tipocalculodepreciacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCalculoDepreciacion(tipocalculodepreciacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCalculoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalculoDepreciacion(this.tipocalculodepreciacions);
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
		tipocalculodepreciacions = new  ArrayList<TipoCalculoDepreciacion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCalculoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocalculodepreciacions=tipocalculodepreciacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCalculoDepreciacion(tipocalculodepreciacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCalculoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalculoDepreciacion(this.tipocalculodepreciacions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipocalculodepreciacion = new  TipoCalculoDepreciacion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCalculoDepreciacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCalculoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocalculodepreciacion=tipocalculodepreciacionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCalculoDepreciacion(tipocalculodepreciacion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCalculoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalculoDepreciacion(this.tipocalculodepreciacion);
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
		tipocalculodepreciacion = new  TipoCalculoDepreciacion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCalculoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocalculodepreciacion=tipocalculodepreciacionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCalculoDepreciacion(tipocalculodepreciacion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCalculoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalculoDepreciacion(this.tipocalculodepreciacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoCalculoDepreciacionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipocalculodepreciacions = new  ArrayList<TipoCalculoDepreciacion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCalculoDepreciacion.class.getSimpleName()+"-getTodosTipoCalculoDepreciacionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCalculoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocalculodepreciacions=tipocalculodepreciacionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoCalculoDepreciacion(tipocalculodepreciacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCalculoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalculoDepreciacion(this.tipocalculodepreciacions);
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
	
	public  void  getTodosTipoCalculoDepreciacions(String sFinalQuery,Pagination pagination)throws Exception {
		tipocalculodepreciacions = new  ArrayList<TipoCalculoDepreciacion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCalculoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocalculodepreciacions=tipocalculodepreciacionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoCalculoDepreciacion(tipocalculodepreciacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCalculoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalculoDepreciacion(this.tipocalculodepreciacions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoCalculoDepreciacion(TipoCalculoDepreciacion tipocalculodepreciacion) throws Exception {
		Boolean estaValidado=false;
		
		if(tipocalculodepreciacion.getIsNew() || tipocalculodepreciacion.getIsChanged()) { 
			this.invalidValues = tipocalculodepreciacionValidator.getInvalidValues(tipocalculodepreciacion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipocalculodepreciacion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoCalculoDepreciacion(List<TipoCalculoDepreciacion> TipoCalculoDepreciacions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoCalculoDepreciacion tipocalculodepreciacionLocal:tipocalculodepreciacions) {				
			estaValidadoObjeto=this.validarGuardarTipoCalculoDepreciacion(tipocalculodepreciacionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoCalculoDepreciacion(List<TipoCalculoDepreciacion> TipoCalculoDepreciacions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoCalculoDepreciacion(tipocalculodepreciacions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoCalculoDepreciacion(TipoCalculoDepreciacion TipoCalculoDepreciacion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoCalculoDepreciacion(tipocalculodepreciacion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoCalculoDepreciacion tipocalculodepreciacion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipocalculodepreciacion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoCalculoDepreciacionConstantesFunciones.getTipoCalculoDepreciacionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipocalculodepreciacion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoCalculoDepreciacionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoCalculoDepreciacionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoCalculoDepreciacionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCalculoDepreciacion.class.getSimpleName()+"-saveTipoCalculoDepreciacionWithConnection");connexion.begin();			
			
			//TipoCalculoDepreciacionLogicAdditional.checkTipoCalculoDepreciacionToSave(this.tipocalculodepreciacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoCalculoDepreciacionLogicAdditional.updateTipoCalculoDepreciacionToSave(this.tipocalculodepreciacion,this.arrDatoGeneral);
			
			TipoCalculoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipocalculodepreciacion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoCalculoDepreciacion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoCalculoDepreciacion(this.tipocalculodepreciacion)) {
				TipoCalculoDepreciacionDataAccess.save(this.tipocalculodepreciacion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipocalculodepreciacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoCalculoDepreciacionLogicAdditional.checkTipoCalculoDepreciacionToSaveAfter(this.tipocalculodepreciacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoCalculoDepreciacion();
			
			connexion.commit();			
			
			if(this.tipocalculodepreciacion.getIsDeleted()) {
				this.tipocalculodepreciacion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoCalculoDepreciacion()throws Exception {	
		try {	
			
			//TipoCalculoDepreciacionLogicAdditional.checkTipoCalculoDepreciacionToSave(this.tipocalculodepreciacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoCalculoDepreciacionLogicAdditional.updateTipoCalculoDepreciacionToSave(this.tipocalculodepreciacion,this.arrDatoGeneral);
			
			TipoCalculoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipocalculodepreciacion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoCalculoDepreciacion(this.tipocalculodepreciacion)) {			
				TipoCalculoDepreciacionDataAccess.save(this.tipocalculodepreciacion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipocalculodepreciacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoCalculoDepreciacionLogicAdditional.checkTipoCalculoDepreciacionToSaveAfter(this.tipocalculodepreciacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipocalculodepreciacion.getIsDeleted()) {
				this.tipocalculodepreciacion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoCalculoDepreciacionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCalculoDepreciacion.class.getSimpleName()+"-saveTipoCalculoDepreciacionsWithConnection");connexion.begin();			
			
			//TipoCalculoDepreciacionLogicAdditional.checkTipoCalculoDepreciacionToSaves(tipocalculodepreciacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoCalculoDepreciacions();
			
			Boolean validadoTodosTipoCalculoDepreciacion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoCalculoDepreciacion tipocalculodepreciacionLocal:tipocalculodepreciacions) {		
				if(tipocalculodepreciacionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoCalculoDepreciacionLogicAdditional.updateTipoCalculoDepreciacionToSave(tipocalculodepreciacionLocal,this.arrDatoGeneral);
	        	
				TipoCalculoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipocalculodepreciacionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoCalculoDepreciacion(tipocalculodepreciacionLocal)) {
					TipoCalculoDepreciacionDataAccess.save(tipocalculodepreciacionLocal, connexion);				
				} else {
					validadoTodosTipoCalculoDepreciacion=false;
				}
			}
			
			if(!validadoTodosTipoCalculoDepreciacion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoCalculoDepreciacionLogicAdditional.checkTipoCalculoDepreciacionToSavesAfter(tipocalculodepreciacions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoCalculoDepreciacions();
			
			connexion.commit();		
			
			this.quitarTipoCalculoDepreciacionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoCalculoDepreciacions()throws Exception {				
		 try {	
			//TipoCalculoDepreciacionLogicAdditional.checkTipoCalculoDepreciacionToSaves(tipocalculodepreciacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoCalculoDepreciacion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoCalculoDepreciacion tipocalculodepreciacionLocal:tipocalculodepreciacions) {				
				if(tipocalculodepreciacionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoCalculoDepreciacionLogicAdditional.updateTipoCalculoDepreciacionToSave(tipocalculodepreciacionLocal,this.arrDatoGeneral);
	        	
				TipoCalculoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipocalculodepreciacionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoCalculoDepreciacion(tipocalculodepreciacionLocal)) {				
					TipoCalculoDepreciacionDataAccess.save(tipocalculodepreciacionLocal, connexion);				
				} else {
					validadoTodosTipoCalculoDepreciacion=false;
				}
			}
			
			if(!validadoTodosTipoCalculoDepreciacion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoCalculoDepreciacionLogicAdditional.checkTipoCalculoDepreciacionToSavesAfter(tipocalculodepreciacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoCalculoDepreciacionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoCalculoDepreciacionParameterReturnGeneral procesarAccionTipoCalculoDepreciacions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoCalculoDepreciacion> tipocalculodepreciacions,TipoCalculoDepreciacionParameterReturnGeneral tipocalculodepreciacionParameterGeneral)throws Exception {
		 try {	
			TipoCalculoDepreciacionParameterReturnGeneral tipocalculodepreciacionReturnGeneral=new TipoCalculoDepreciacionParameterReturnGeneral();
	
			
			return tipocalculodepreciacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoCalculoDepreciacionParameterReturnGeneral procesarAccionTipoCalculoDepreciacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoCalculoDepreciacion> tipocalculodepreciacions,TipoCalculoDepreciacionParameterReturnGeneral tipocalculodepreciacionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCalculoDepreciacion.class.getSimpleName()+"-procesarAccionTipoCalculoDepreciacionsWithConnection");connexion.begin();			
			
			TipoCalculoDepreciacionParameterReturnGeneral tipocalculodepreciacionReturnGeneral=new TipoCalculoDepreciacionParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipocalculodepreciacionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoCalculoDepreciacionParameterReturnGeneral procesarEventosTipoCalculoDepreciacions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoCalculoDepreciacion> tipocalculodepreciacions,TipoCalculoDepreciacion tipocalculodepreciacion,TipoCalculoDepreciacionParameterReturnGeneral tipocalculodepreciacionParameterGeneral,Boolean isEsNuevoTipoCalculoDepreciacion,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoCalculoDepreciacionParameterReturnGeneral tipocalculodepreciacionReturnGeneral=new TipoCalculoDepreciacionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipocalculodepreciacionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipocalculodepreciacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoCalculoDepreciacionParameterReturnGeneral procesarEventosTipoCalculoDepreciacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoCalculoDepreciacion> tipocalculodepreciacions,TipoCalculoDepreciacion tipocalculodepreciacion,TipoCalculoDepreciacionParameterReturnGeneral tipocalculodepreciacionParameterGeneral,Boolean isEsNuevoTipoCalculoDepreciacion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCalculoDepreciacion.class.getSimpleName()+"-procesarEventosTipoCalculoDepreciacionsWithConnection");connexion.begin();			
			
			TipoCalculoDepreciacionParameterReturnGeneral tipocalculodepreciacionReturnGeneral=new TipoCalculoDepreciacionParameterReturnGeneral();
	
			tipocalculodepreciacionReturnGeneral.setTipoCalculoDepreciacion(tipocalculodepreciacion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipocalculodepreciacionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipocalculodepreciacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoCalculoDepreciacionParameterReturnGeneral procesarImportacionTipoCalculoDepreciacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoCalculoDepreciacionParameterReturnGeneral tipocalculodepreciacionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCalculoDepreciacion.class.getSimpleName()+"-procesarImportacionTipoCalculoDepreciacionsWithConnection");connexion.begin();			
			
			TipoCalculoDepreciacionParameterReturnGeneral tipocalculodepreciacionReturnGeneral=new TipoCalculoDepreciacionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipocalculodepreciacions=new ArrayList<TipoCalculoDepreciacion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipocalculodepreciacion=new TipoCalculoDepreciacion();
				
				
				if(conColumnasBase) {this.tipocalculodepreciacion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipocalculodepreciacion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipocalculodepreciacion.setnombre(arrColumnas[iColumn++]);
				
				this.tipocalculodepreciacions.add(this.tipocalculodepreciacion);
			}
			
			this.saveTipoCalculoDepreciacions();
			
			this.connexion.commit();
			
			tipocalculodepreciacionReturnGeneral.setConRetornoEstaProcesado(true);
			tipocalculodepreciacionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipocalculodepreciacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoCalculoDepreciacionsEliminados() throws Exception {				
		
		List<TipoCalculoDepreciacion> tipocalculodepreciacionsAux= new ArrayList<TipoCalculoDepreciacion>();
		
		for(TipoCalculoDepreciacion tipocalculodepreciacion:tipocalculodepreciacions) {
			if(!tipocalculodepreciacion.getIsDeleted()) {
				tipocalculodepreciacionsAux.add(tipocalculodepreciacion);
			}
		}
		
		tipocalculodepreciacions=tipocalculodepreciacionsAux;
	}
	
	public void quitarTipoCalculoDepreciacionsNulos() throws Exception {				
		
		List<TipoCalculoDepreciacion> tipocalculodepreciacionsAux= new ArrayList<TipoCalculoDepreciacion>();
		
		for(TipoCalculoDepreciacion tipocalculodepreciacion : this.tipocalculodepreciacions) {
			if(tipocalculodepreciacion==null) {
				tipocalculodepreciacionsAux.add(tipocalculodepreciacion);
			}
		}
		
		//this.tipocalculodepreciacions=tipocalculodepreciacionsAux;
		
		this.tipocalculodepreciacions.removeAll(tipocalculodepreciacionsAux);
	}
	
	public void getSetVersionRowTipoCalculoDepreciacionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipocalculodepreciacion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipocalculodepreciacion.getIsDeleted() || (tipocalculodepreciacion.getIsChanged()&&!tipocalculodepreciacion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipocalculodepreciacionDataAccess.getSetVersionRowTipoCalculoDepreciacion(connexion,tipocalculodepreciacion.getId());
				
				if(!tipocalculodepreciacion.getVersionRow().equals(timestamp)) {	
					tipocalculodepreciacion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipocalculodepreciacion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoCalculoDepreciacion()throws Exception {	
		
		if(tipocalculodepreciacion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipocalculodepreciacion.getIsDeleted() || (tipocalculodepreciacion.getIsChanged()&&!tipocalculodepreciacion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipocalculodepreciacionDataAccess.getSetVersionRowTipoCalculoDepreciacion(connexion,tipocalculodepreciacion.getId());
			
			try {							
				if(!tipocalculodepreciacion.getVersionRow().equals(timestamp)) {	
					tipocalculodepreciacion.setVersionRow(timestamp);
				}
				
				tipocalculodepreciacion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoCalculoDepreciacionsWithConnection()throws Exception {	
		if(tipocalculodepreciacions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoCalculoDepreciacion tipocalculodepreciacionAux:tipocalculodepreciacions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipocalculodepreciacionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipocalculodepreciacionAux.getIsDeleted() || (tipocalculodepreciacionAux.getIsChanged()&&!tipocalculodepreciacionAux.getIsNew())) {
						
						timestamp=tipocalculodepreciacionDataAccess.getSetVersionRowTipoCalculoDepreciacion(connexion,tipocalculodepreciacionAux.getId());
						
						if(!tipocalculodepreciacion.getVersionRow().equals(timestamp)) {	
							tipocalculodepreciacionAux.setVersionRow(timestamp);
						}
								
						tipocalculodepreciacionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoCalculoDepreciacions()throws Exception {	
		if(tipocalculodepreciacions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoCalculoDepreciacion tipocalculodepreciacionAux:tipocalculodepreciacions) {
					if(tipocalculodepreciacionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipocalculodepreciacionAux.getIsDeleted() || (tipocalculodepreciacionAux.getIsChanged()&&!tipocalculodepreciacionAux.getIsNew())) {
						
						timestamp=tipocalculodepreciacionDataAccess.getSetVersionRowTipoCalculoDepreciacion(connexion,tipocalculodepreciacionAux.getId());
						
						if(!tipocalculodepreciacionAux.getVersionRow().equals(timestamp)) {	
							tipocalculodepreciacionAux.setVersionRow(timestamp);
						}
						
													
						tipocalculodepreciacionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoCalculoDepreciacionParameterReturnGeneral cargarCombosLoteForeignKeyTipoCalculoDepreciacionWithConnection(String finalQueryGlobalPais) throws Exception {
		TipoCalculoDepreciacionParameterReturnGeneral  tipocalculodepreciacionReturnGeneral =new TipoCalculoDepreciacionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCalculoDepreciacion.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoCalculoDepreciacionWithConnection");connexion.begin();
			
			tipocalculodepreciacionReturnGeneral =new TipoCalculoDepreciacionParameterReturnGeneral();
			
			

			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			tipocalculodepreciacionReturnGeneral.setpaissForeignKey(paissForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipocalculodepreciacionReturnGeneral;
	}
	
	public TipoCalculoDepreciacionParameterReturnGeneral cargarCombosLoteForeignKeyTipoCalculoDepreciacion(String finalQueryGlobalPais) throws Exception {
		TipoCalculoDepreciacionParameterReturnGeneral  tipocalculodepreciacionReturnGeneral =new TipoCalculoDepreciacionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipocalculodepreciacionReturnGeneral =new TipoCalculoDepreciacionParameterReturnGeneral();
			
			

			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			tipocalculodepreciacionReturnGeneral.setpaissForeignKey(paissForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipocalculodepreciacionReturnGeneral;
	}
	
	
	public void deepLoad(TipoCalculoDepreciacion tipocalculodepreciacion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoCalculoDepreciacionLogicAdditional.updateTipoCalculoDepreciacionToGet(tipocalculodepreciacion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipocalculodepreciacion.setPais(tipocalculodepreciacionDataAccess.getPais(connexion,tipocalculodepreciacion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				tipocalculodepreciacion.setPais(tipocalculodepreciacionDataAccess.getPais(connexion,tipocalculodepreciacion));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipocalculodepreciacion.setPais(tipocalculodepreciacionDataAccess.getPais(connexion,tipocalculodepreciacion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipocalculodepreciacion.setPais(tipocalculodepreciacionDataAccess.getPais(connexion,tipocalculodepreciacion));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(tipocalculodepreciacion.getPais(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				tipocalculodepreciacion.setPais(tipocalculodepreciacionDataAccess.getPais(connexion,tipocalculodepreciacion));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(tipocalculodepreciacion.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipocalculodepreciacion.setPais(tipocalculodepreciacionDataAccess.getPais(connexion,tipocalculodepreciacion));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(tipocalculodepreciacion.getPais(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoCalculoDepreciacion tipocalculodepreciacion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoCalculoDepreciacion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipocalculodepreciacion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoCalculoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalculoDepreciacion(tipocalculodepreciacion);
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
			this.deepLoad(this.tipocalculodepreciacion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoCalculoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalculoDepreciacion(this.tipocalculodepreciacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoCalculoDepreciacion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipocalculodepreciacions!=null) {
				for(TipoCalculoDepreciacion tipocalculodepreciacion:tipocalculodepreciacions) {
					this.deepLoad(tipocalculodepreciacion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoCalculoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalculoDepreciacion(tipocalculodepreciacions);
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
			if(tipocalculodepreciacions!=null) {
				for(TipoCalculoDepreciacion tipocalculodepreciacion:tipocalculodepreciacions) {
					this.deepLoad(tipocalculodepreciacion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoCalculoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalculoDepreciacion(tipocalculodepreciacions);
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
	
	
	public void getTipoCalculoDepreciacionsFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCalculoDepreciacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,TipoCalculoDepreciacionConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			TipoCalculoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipocalculodepreciacions=tipocalculodepreciacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoCalculoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalculoDepreciacion(this.tipocalculodepreciacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoCalculoDepreciacionsFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,TipoCalculoDepreciacionConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			TipoCalculoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipocalculodepreciacions=tipocalculodepreciacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoCalculoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalculoDepreciacion(this.tipocalculodepreciacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoCalculoDepreciacionPorNombreWithConnection(String nombre)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCalculoDepreciacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,TipoCalculoDepreciacionConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			tipocalculodepreciacion=tipocalculodepreciacionDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipocalculodepreciacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoCalculoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalculoDepreciacion(this.tipocalculodepreciacion);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoCalculoDepreciacionPorNombre(String nombre)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,TipoCalculoDepreciacionConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			tipocalculodepreciacion=tipocalculodepreciacionDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipocalculodepreciacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoCalculoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalculoDepreciacion(this.tipocalculodepreciacion);
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
			if(TipoCalculoDepreciacionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCalculoDepreciacionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoCalculoDepreciacion tipocalculodepreciacion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoCalculoDepreciacionConstantesFunciones.ISCONAUDITORIA) {
				if(tipocalculodepreciacion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCalculoDepreciacionDataAccess.TABLENAME, tipocalculodepreciacion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoCalculoDepreciacionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoCalculoDepreciacionLogic.registrarAuditoriaDetallesTipoCalculoDepreciacion(connexion,tipocalculodepreciacion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipocalculodepreciacion.getIsDeleted()) {
					/*if(!tipocalculodepreciacion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoCalculoDepreciacionDataAccess.TABLENAME, tipocalculodepreciacion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoCalculoDepreciacionLogic.registrarAuditoriaDetallesTipoCalculoDepreciacion(connexion,tipocalculodepreciacion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCalculoDepreciacionDataAccess.TABLENAME, tipocalculodepreciacion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipocalculodepreciacion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCalculoDepreciacionDataAccess.TABLENAME, tipocalculodepreciacion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoCalculoDepreciacionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoCalculoDepreciacionLogic.registrarAuditoriaDetallesTipoCalculoDepreciacion(connexion,tipocalculodepreciacion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoCalculoDepreciacion(Connexion connexion,TipoCalculoDepreciacion tipocalculodepreciacion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipocalculodepreciacion.getIsNew()||!tipocalculodepreciacion.getid_pais().equals(tipocalculodepreciacion.getTipoCalculoDepreciacionOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocalculodepreciacion.getTipoCalculoDepreciacionOriginal().getid_pais()!=null)
				{
					strValorActual=tipocalculodepreciacion.getTipoCalculoDepreciacionOriginal().getid_pais().toString();
				}
				if(tipocalculodepreciacion.getid_pais()!=null)
				{
					strValorNuevo=tipocalculodepreciacion.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoCalculoDepreciacionConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(tipocalculodepreciacion.getIsNew()||!tipocalculodepreciacion.getnombre().equals(tipocalculodepreciacion.getTipoCalculoDepreciacionOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocalculodepreciacion.getTipoCalculoDepreciacionOriginal().getnombre()!=null)
				{
					strValorActual=tipocalculodepreciacion.getTipoCalculoDepreciacionOriginal().getnombre();
				}
				if(tipocalculodepreciacion.getnombre()!=null)
				{
					strValorNuevo=tipocalculodepreciacion.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoCalculoDepreciacionConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoCalculoDepreciacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoCalculoDepreciacionConstantesFunciones.getClassesForeignKeysOfTipoCalculoDepreciacion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCalculoDepreciacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoCalculoDepreciacionConstantesFunciones.getClassesRelationshipsOfTipoCalculoDepreciacion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

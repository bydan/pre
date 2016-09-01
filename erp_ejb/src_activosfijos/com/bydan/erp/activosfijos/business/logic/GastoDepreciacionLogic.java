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
import com.bydan.erp.activosfijos.util.GastoDepreciacionConstantesFunciones;
import com.bydan.erp.activosfijos.util.GastoDepreciacionParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.GastoDepreciacionParameterGeneral;
import com.bydan.erp.activosfijos.business.entity.GastoDepreciacion;
import com.bydan.erp.activosfijos.business.logic.GastoDepreciacionLogicAdditional;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class GastoDepreciacionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(GastoDepreciacionLogic.class);
	
	protected GastoDepreciacionDataAccess gastodepreciacionDataAccess; 	
	protected GastoDepreciacion gastodepreciacion;
	protected List<GastoDepreciacion> gastodepreciacions;
	protected Object gastodepreciacionObject;	
	protected List<Object> gastodepreciacionsObject;
	
	public static ClassValidator<GastoDepreciacion> gastodepreciacionValidator = new ClassValidator<GastoDepreciacion>(GastoDepreciacion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected GastoDepreciacionLogicAdditional gastodepreciacionLogicAdditional=null;
	
	public GastoDepreciacionLogicAdditional getGastoDepreciacionLogicAdditional() {
		return this.gastodepreciacionLogicAdditional;
	}
	
	public void setGastoDepreciacionLogicAdditional(GastoDepreciacionLogicAdditional gastodepreciacionLogicAdditional) {
		try {
			this.gastodepreciacionLogicAdditional=gastodepreciacionLogicAdditional;
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
	
	
	
	
	public  GastoDepreciacionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.gastodepreciacionDataAccess = new GastoDepreciacionDataAccess();
			
			this.gastodepreciacions= new ArrayList<GastoDepreciacion>();
			this.gastodepreciacion= new GastoDepreciacion();
			
			this.gastodepreciacionObject=new Object();
			this.gastodepreciacionsObject=new ArrayList<Object>();
				
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
			
			this.gastodepreciacionDataAccess.setConnexionType(this.connexionType);
			this.gastodepreciacionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  GastoDepreciacionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.gastodepreciacionDataAccess = new GastoDepreciacionDataAccess();
			this.gastodepreciacions= new ArrayList<GastoDepreciacion>();
			this.gastodepreciacion= new GastoDepreciacion();
			this.gastodepreciacionObject=new Object();
			this.gastodepreciacionsObject=new ArrayList<Object>();
			
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
			
			this.gastodepreciacionDataAccess.setConnexionType(this.connexionType);
			this.gastodepreciacionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public GastoDepreciacion getGastoDepreciacion() throws Exception {	
		GastoDepreciacionLogicAdditional.checkGastoDepreciacionToGet(gastodepreciacion,this.datosCliente,this.arrDatoGeneral);
		GastoDepreciacionLogicAdditional.updateGastoDepreciacionToGet(gastodepreciacion,this.arrDatoGeneral);
		
		return gastodepreciacion;
	}
		
	public void setGastoDepreciacion(GastoDepreciacion newGastoDepreciacion) {
		this.gastodepreciacion = newGastoDepreciacion;
	}
	
	public GastoDepreciacionDataAccess getGastoDepreciacionDataAccess() {
		return gastodepreciacionDataAccess;
	}
	
	public void setGastoDepreciacionDataAccess(GastoDepreciacionDataAccess newgastodepreciacionDataAccess) {
		this.gastodepreciacionDataAccess = newgastodepreciacionDataAccess;
	}
	
	public List<GastoDepreciacion> getGastoDepreciacions() throws Exception {		
		this.quitarGastoDepreciacionsNulos();
		
		GastoDepreciacionLogicAdditional.checkGastoDepreciacionToGets(gastodepreciacions,this.datosCliente,this.arrDatoGeneral);
		
		for (GastoDepreciacion gastodepreciacionLocal: gastodepreciacions ) {
			GastoDepreciacionLogicAdditional.updateGastoDepreciacionToGet(gastodepreciacionLocal,this.arrDatoGeneral);
		}
		
		return gastodepreciacions;
	}
	
	public void setGastoDepreciacions(List<GastoDepreciacion> newGastoDepreciacions) {
		this.gastodepreciacions = newGastoDepreciacions;
	}
	
	public Object getGastoDepreciacionObject() {	
		this.gastodepreciacionObject=this.gastodepreciacionDataAccess.getEntityObject();
		return this.gastodepreciacionObject;
	}
		
	public void setGastoDepreciacionObject(Object newGastoDepreciacionObject) {
		this.gastodepreciacionObject = newGastoDepreciacionObject;
	}
	
	public List<Object> getGastoDepreciacionsObject() {		
		this.gastodepreciacionsObject=this.gastodepreciacionDataAccess.getEntitiesObject();
		return this.gastodepreciacionsObject;
	}
		
	public void setGastoDepreciacionsObject(List<Object> newGastoDepreciacionsObject) {
		this.gastodepreciacionsObject = newGastoDepreciacionsObject;
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
		
		if(this.gastodepreciacionDataAccess!=null) {
			this.gastodepreciacionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			gastodepreciacionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			gastodepreciacionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		gastodepreciacion = new  GastoDepreciacion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			gastodepreciacion=gastodepreciacionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.gastodepreciacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GastoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacion(this.gastodepreciacion);
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
		gastodepreciacion = new  GastoDepreciacion();
		  		  
        try {
			
			gastodepreciacion=gastodepreciacionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.gastodepreciacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GastoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacion(this.gastodepreciacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		gastodepreciacion = new  GastoDepreciacion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			gastodepreciacion=gastodepreciacionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.gastodepreciacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GastoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacion(this.gastodepreciacion);
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
		gastodepreciacion = new  GastoDepreciacion();
		  		  
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
		gastodepreciacion = new  GastoDepreciacion();
		  		  
        try {
			
			gastodepreciacion=gastodepreciacionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.gastodepreciacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GastoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacion(this.gastodepreciacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		gastodepreciacion = new  GastoDepreciacion();
		  		  
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
		gastodepreciacion = new  GastoDepreciacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =gastodepreciacionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		gastodepreciacion = new  GastoDepreciacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=gastodepreciacionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		gastodepreciacion = new  GastoDepreciacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =gastodepreciacionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		gastodepreciacion = new  GastoDepreciacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=gastodepreciacionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		gastodepreciacion = new  GastoDepreciacion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =gastodepreciacionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		gastodepreciacion = new  GastoDepreciacion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=gastodepreciacionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		gastodepreciacions = new  ArrayList<GastoDepreciacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			GastoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			gastodepreciacions=gastodepreciacionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGastoDepreciacion(gastodepreciacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GastoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacion(this.gastodepreciacions);
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
		gastodepreciacions = new  ArrayList<GastoDepreciacion>();
		  		  
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
		gastodepreciacions = new  ArrayList<GastoDepreciacion>();
		  		  
        try {			
			GastoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			gastodepreciacions=gastodepreciacionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarGastoDepreciacion(gastodepreciacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GastoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacion(this.gastodepreciacions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		gastodepreciacions = new  ArrayList<GastoDepreciacion>();
		  		  
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
		gastodepreciacions = new  ArrayList<GastoDepreciacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			GastoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			gastodepreciacions=gastodepreciacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGastoDepreciacion(gastodepreciacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GastoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacion(this.gastodepreciacions);
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
		gastodepreciacions = new  ArrayList<GastoDepreciacion>();
		  		  
        try {
			GastoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			gastodepreciacions=gastodepreciacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGastoDepreciacion(gastodepreciacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GastoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacion(this.gastodepreciacions);
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
		gastodepreciacions = new  ArrayList<GastoDepreciacion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GastoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			gastodepreciacions=gastodepreciacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGastoDepreciacion(gastodepreciacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GastoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacion(this.gastodepreciacions);
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
		gastodepreciacions = new  ArrayList<GastoDepreciacion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GastoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			gastodepreciacions=gastodepreciacionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGastoDepreciacion(gastodepreciacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GastoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacion(this.gastodepreciacions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		gastodepreciacion = new  GastoDepreciacion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GastoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			gastodepreciacion=gastodepreciacionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGastoDepreciacion(gastodepreciacion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GastoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacion(this.gastodepreciacion);
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
		gastodepreciacion = new  GastoDepreciacion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GastoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			gastodepreciacion=gastodepreciacionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGastoDepreciacion(gastodepreciacion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GastoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacion(this.gastodepreciacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		gastodepreciacions = new  ArrayList<GastoDepreciacion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacion.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			GastoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			gastodepreciacions=gastodepreciacionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGastoDepreciacion(gastodepreciacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GastoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacion(this.gastodepreciacions);
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
		gastodepreciacions = new  ArrayList<GastoDepreciacion>();
		  		  
        try {
			GastoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			gastodepreciacions=gastodepreciacionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGastoDepreciacion(gastodepreciacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GastoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacion(this.gastodepreciacions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosGastoDepreciacionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		gastodepreciacions = new  ArrayList<GastoDepreciacion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacion.class.getSimpleName()+"-getTodosGastoDepreciacionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GastoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			gastodepreciacions=gastodepreciacionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarGastoDepreciacion(gastodepreciacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GastoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacion(this.gastodepreciacions);
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
	
	public  void  getTodosGastoDepreciacions(String sFinalQuery,Pagination pagination)throws Exception {
		gastodepreciacions = new  ArrayList<GastoDepreciacion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GastoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			gastodepreciacions=gastodepreciacionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarGastoDepreciacion(gastodepreciacions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GastoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacion(this.gastodepreciacions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarGastoDepreciacion(GastoDepreciacion gastodepreciacion) throws Exception {
		Boolean estaValidado=false;
		
		if(gastodepreciacion.getIsNew() || gastodepreciacion.getIsChanged()) { 
			this.invalidValues = gastodepreciacionValidator.getInvalidValues(gastodepreciacion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(gastodepreciacion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarGastoDepreciacion(List<GastoDepreciacion> GastoDepreciacions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(GastoDepreciacion gastodepreciacionLocal:gastodepreciacions) {				
			estaValidadoObjeto=this.validarGuardarGastoDepreciacion(gastodepreciacionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarGastoDepreciacion(List<GastoDepreciacion> GastoDepreciacions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarGastoDepreciacion(gastodepreciacions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarGastoDepreciacion(GastoDepreciacion GastoDepreciacion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarGastoDepreciacion(gastodepreciacion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(GastoDepreciacion gastodepreciacion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+gastodepreciacion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=GastoDepreciacionConstantesFunciones.getGastoDepreciacionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"gastodepreciacion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(GastoDepreciacionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(GastoDepreciacionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveGastoDepreciacionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacion.class.getSimpleName()+"-saveGastoDepreciacionWithConnection");connexion.begin();			
			
			GastoDepreciacionLogicAdditional.checkGastoDepreciacionToSave(this.gastodepreciacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			GastoDepreciacionLogicAdditional.updateGastoDepreciacionToSave(this.gastodepreciacion,this.arrDatoGeneral);
			
			GastoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.gastodepreciacion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowGastoDepreciacion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarGastoDepreciacion(this.gastodepreciacion)) {
				GastoDepreciacionDataAccess.save(this.gastodepreciacion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.gastodepreciacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			GastoDepreciacionLogicAdditional.checkGastoDepreciacionToSaveAfter(this.gastodepreciacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowGastoDepreciacion();
			
			connexion.commit();			
			
			if(this.gastodepreciacion.getIsDeleted()) {
				this.gastodepreciacion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveGastoDepreciacion()throws Exception {	
		try {	
			
			GastoDepreciacionLogicAdditional.checkGastoDepreciacionToSave(this.gastodepreciacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			GastoDepreciacionLogicAdditional.updateGastoDepreciacionToSave(this.gastodepreciacion,this.arrDatoGeneral);
			
			GastoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.gastodepreciacion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarGastoDepreciacion(this.gastodepreciacion)) {			
				GastoDepreciacionDataAccess.save(this.gastodepreciacion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.gastodepreciacion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			GastoDepreciacionLogicAdditional.checkGastoDepreciacionToSaveAfter(this.gastodepreciacion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.gastodepreciacion.getIsDeleted()) {
				this.gastodepreciacion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveGastoDepreciacionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacion.class.getSimpleName()+"-saveGastoDepreciacionsWithConnection");connexion.begin();			
			
			GastoDepreciacionLogicAdditional.checkGastoDepreciacionToSaves(gastodepreciacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowGastoDepreciacions();
			
			Boolean validadoTodosGastoDepreciacion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(GastoDepreciacion gastodepreciacionLocal:gastodepreciacions) {		
				if(gastodepreciacionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				GastoDepreciacionLogicAdditional.updateGastoDepreciacionToSave(gastodepreciacionLocal,this.arrDatoGeneral);
	        	
				GastoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),gastodepreciacionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarGastoDepreciacion(gastodepreciacionLocal)) {
					GastoDepreciacionDataAccess.save(gastodepreciacionLocal, connexion);				
				} else {
					validadoTodosGastoDepreciacion=false;
				}
			}
			
			if(!validadoTodosGastoDepreciacion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			GastoDepreciacionLogicAdditional.checkGastoDepreciacionToSavesAfter(gastodepreciacions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowGastoDepreciacions();
			
			connexion.commit();		
			
			this.quitarGastoDepreciacionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveGastoDepreciacions()throws Exception {				
		 try {	
			GastoDepreciacionLogicAdditional.checkGastoDepreciacionToSaves(gastodepreciacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosGastoDepreciacion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(GastoDepreciacion gastodepreciacionLocal:gastodepreciacions) {				
				if(gastodepreciacionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				GastoDepreciacionLogicAdditional.updateGastoDepreciacionToSave(gastodepreciacionLocal,this.arrDatoGeneral);
	        	
				GastoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),gastodepreciacionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarGastoDepreciacion(gastodepreciacionLocal)) {				
					GastoDepreciacionDataAccess.save(gastodepreciacionLocal, connexion);				
				} else {
					validadoTodosGastoDepreciacion=false;
				}
			}
			
			if(!validadoTodosGastoDepreciacion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			GastoDepreciacionLogicAdditional.checkGastoDepreciacionToSavesAfter(gastodepreciacions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarGastoDepreciacionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public GastoDepreciacionParameterReturnGeneral procesarAccionGastoDepreciacions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<GastoDepreciacion> gastodepreciacions,GastoDepreciacionParameterReturnGeneral gastodepreciacionParameterGeneral)throws Exception {
		 try {	
			GastoDepreciacionParameterReturnGeneral gastodepreciacionReturnGeneral=new GastoDepreciacionParameterReturnGeneral();
	
			GastoDepreciacionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,gastodepreciacions,gastodepreciacionParameterGeneral,gastodepreciacionReturnGeneral);
			
			return gastodepreciacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public GastoDepreciacionParameterReturnGeneral procesarAccionGastoDepreciacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<GastoDepreciacion> gastodepreciacions,GastoDepreciacionParameterReturnGeneral gastodepreciacionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacion.class.getSimpleName()+"-procesarAccionGastoDepreciacionsWithConnection");connexion.begin();			
			
			GastoDepreciacionParameterReturnGeneral gastodepreciacionReturnGeneral=new GastoDepreciacionParameterReturnGeneral();
	
			GastoDepreciacionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,gastodepreciacions,gastodepreciacionParameterGeneral,gastodepreciacionReturnGeneral);
			
			this.connexion.commit();
			
			return gastodepreciacionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public GastoDepreciacionParameterReturnGeneral procesarEventosGastoDepreciacions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<GastoDepreciacion> gastodepreciacions,GastoDepreciacion gastodepreciacion,GastoDepreciacionParameterReturnGeneral gastodepreciacionParameterGeneral,Boolean isEsNuevoGastoDepreciacion,ArrayList<Classe> clases)throws Exception {
		 try {	
			GastoDepreciacionParameterReturnGeneral gastodepreciacionReturnGeneral=new GastoDepreciacionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				gastodepreciacionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			GastoDepreciacionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,gastodepreciacions,gastodepreciacion,gastodepreciacionParameterGeneral,gastodepreciacionReturnGeneral,isEsNuevoGastoDepreciacion,clases);
			
			return gastodepreciacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public GastoDepreciacionParameterReturnGeneral procesarEventosGastoDepreciacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<GastoDepreciacion> gastodepreciacions,GastoDepreciacion gastodepreciacion,GastoDepreciacionParameterReturnGeneral gastodepreciacionParameterGeneral,Boolean isEsNuevoGastoDepreciacion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacion.class.getSimpleName()+"-procesarEventosGastoDepreciacionsWithConnection");connexion.begin();			
			
			GastoDepreciacionParameterReturnGeneral gastodepreciacionReturnGeneral=new GastoDepreciacionParameterReturnGeneral();
	
			gastodepreciacionReturnGeneral.setGastoDepreciacion(gastodepreciacion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				gastodepreciacionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			GastoDepreciacionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,gastodepreciacions,gastodepreciacion,gastodepreciacionParameterGeneral,gastodepreciacionReturnGeneral,isEsNuevoGastoDepreciacion,clases);
			
			this.connexion.commit();
			
			return gastodepreciacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public GastoDepreciacionParameterReturnGeneral procesarImportacionGastoDepreciacionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,GastoDepreciacionParameterReturnGeneral gastodepreciacionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacion.class.getSimpleName()+"-procesarImportacionGastoDepreciacionsWithConnection");connexion.begin();			
			
			GastoDepreciacionParameterReturnGeneral gastodepreciacionReturnGeneral=new GastoDepreciacionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.gastodepreciacions=new ArrayList<GastoDepreciacion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.gastodepreciacion=new GastoDepreciacion();
				
				
				if(conColumnasBase) {this.gastodepreciacion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.gastodepreciacion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.gastodepreciacion.setanio(Integer.parseInt(arrColumnas[iColumn++]));
				this.gastodepreciacion.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.gastodepreciacions.add(this.gastodepreciacion);
			}
			
			this.saveGastoDepreciacions();
			
			this.connexion.commit();
			
			gastodepreciacionReturnGeneral.setConRetornoEstaProcesado(true);
			gastodepreciacionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return gastodepreciacionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarGastoDepreciacionsEliminados() throws Exception {				
		
		List<GastoDepreciacion> gastodepreciacionsAux= new ArrayList<GastoDepreciacion>();
		
		for(GastoDepreciacion gastodepreciacion:gastodepreciacions) {
			if(!gastodepreciacion.getIsDeleted()) {
				gastodepreciacionsAux.add(gastodepreciacion);
			}
		}
		
		gastodepreciacions=gastodepreciacionsAux;
	}
	
	public void quitarGastoDepreciacionsNulos() throws Exception {				
		
		List<GastoDepreciacion> gastodepreciacionsAux= new ArrayList<GastoDepreciacion>();
		
		for(GastoDepreciacion gastodepreciacion : this.gastodepreciacions) {
			if(gastodepreciacion==null) {
				gastodepreciacionsAux.add(gastodepreciacion);
			}
		}
		
		//this.gastodepreciacions=gastodepreciacionsAux;
		
		this.gastodepreciacions.removeAll(gastodepreciacionsAux);
	}
	
	public void getSetVersionRowGastoDepreciacionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(gastodepreciacion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((gastodepreciacion.getIsDeleted() || (gastodepreciacion.getIsChanged()&&!gastodepreciacion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=gastodepreciacionDataAccess.getSetVersionRowGastoDepreciacion(connexion,gastodepreciacion.getId());
				
				if(!gastodepreciacion.getVersionRow().equals(timestamp)) {	
					gastodepreciacion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				gastodepreciacion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowGastoDepreciacion()throws Exception {	
		
		if(gastodepreciacion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((gastodepreciacion.getIsDeleted() || (gastodepreciacion.getIsChanged()&&!gastodepreciacion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=gastodepreciacionDataAccess.getSetVersionRowGastoDepreciacion(connexion,gastodepreciacion.getId());
			
			try {							
				if(!gastodepreciacion.getVersionRow().equals(timestamp)) {	
					gastodepreciacion.setVersionRow(timestamp);
				}
				
				gastodepreciacion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowGastoDepreciacionsWithConnection()throws Exception {	
		if(gastodepreciacions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(GastoDepreciacion gastodepreciacionAux:gastodepreciacions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(gastodepreciacionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(gastodepreciacionAux.getIsDeleted() || (gastodepreciacionAux.getIsChanged()&&!gastodepreciacionAux.getIsNew())) {
						
						timestamp=gastodepreciacionDataAccess.getSetVersionRowGastoDepreciacion(connexion,gastodepreciacionAux.getId());
						
						if(!gastodepreciacion.getVersionRow().equals(timestamp)) {	
							gastodepreciacionAux.setVersionRow(timestamp);
						}
								
						gastodepreciacionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowGastoDepreciacions()throws Exception {	
		if(gastodepreciacions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(GastoDepreciacion gastodepreciacionAux:gastodepreciacions) {
					if(gastodepreciacionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(gastodepreciacionAux.getIsDeleted() || (gastodepreciacionAux.getIsChanged()&&!gastodepreciacionAux.getIsNew())) {
						
						timestamp=gastodepreciacionDataAccess.getSetVersionRowGastoDepreciacion(connexion,gastodepreciacionAux.getId());
						
						if(!gastodepreciacionAux.getVersionRow().equals(timestamp)) {	
							gastodepreciacionAux.setVersionRow(timestamp);
						}
						
													
						gastodepreciacionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public GastoDepreciacionParameterReturnGeneral cargarCombosLoteForeignKeyGastoDepreciacionWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalDetalleGrupoActivoFijo) throws Exception {
		GastoDepreciacionParameterReturnGeneral  gastodepreciacionReturnGeneral =new GastoDepreciacionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacion.class.getSimpleName()+"-cargarCombosLoteForeignKeyGastoDepreciacionWithConnection");connexion.begin();
			
			gastodepreciacionReturnGeneral =new GastoDepreciacionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			gastodepreciacionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<DetalleGrupoActivoFijo> detallegrupoactivofijosForeignKey=new ArrayList<DetalleGrupoActivoFijo>();
			DetalleGrupoActivoFijoLogic detallegrupoactivofijoLogic=new DetalleGrupoActivoFijoLogic();
			detallegrupoactivofijoLogic.setConnexion(this.connexion);
			detallegrupoactivofijoLogic.getDetalleGrupoActivoFijoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDetalleGrupoActivoFijo.equals("NONE")) {
				detallegrupoactivofijoLogic.getTodosDetalleGrupoActivoFijos(finalQueryGlobalDetalleGrupoActivoFijo,new Pagination());
				detallegrupoactivofijosForeignKey=detallegrupoactivofijoLogic.getDetalleGrupoActivoFijos();
			}

			gastodepreciacionReturnGeneral.setdetallegrupoactivofijosForeignKey(detallegrupoactivofijosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return gastodepreciacionReturnGeneral;
	}
	
	public GastoDepreciacionParameterReturnGeneral cargarCombosLoteForeignKeyGastoDepreciacion(String finalQueryGlobalEmpresa,String finalQueryGlobalDetalleGrupoActivoFijo) throws Exception {
		GastoDepreciacionParameterReturnGeneral  gastodepreciacionReturnGeneral =new GastoDepreciacionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			gastodepreciacionReturnGeneral =new GastoDepreciacionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			gastodepreciacionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<DetalleGrupoActivoFijo> detallegrupoactivofijosForeignKey=new ArrayList<DetalleGrupoActivoFijo>();
			DetalleGrupoActivoFijoLogic detallegrupoactivofijoLogic=new DetalleGrupoActivoFijoLogic();
			detallegrupoactivofijoLogic.setConnexion(this.connexion);
			detallegrupoactivofijoLogic.getDetalleGrupoActivoFijoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDetalleGrupoActivoFijo.equals("NONE")) {
				detallegrupoactivofijoLogic.getTodosDetalleGrupoActivoFijos(finalQueryGlobalDetalleGrupoActivoFijo,new Pagination());
				detallegrupoactivofijosForeignKey=detallegrupoactivofijoLogic.getDetalleGrupoActivoFijos();
			}

			gastodepreciacionReturnGeneral.setdetallegrupoactivofijosForeignKey(detallegrupoactivofijosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return gastodepreciacionReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyGastoDepreciacionWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			CuentaContaGastoDepreLogic cuentacontagastodepreLogic=new CuentaContaGastoDepreLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacion.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyGastoDepreciacionWithConnection");connexion.begin();
			
			
			classes.add(new Classe(CuentaContaGastoDepre.class));
											
			

			cuentacontagastodepreLogic.setConnexion(this.getConnexion());
			cuentacontagastodepreLogic.setDatosCliente(this.datosCliente);
			cuentacontagastodepreLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(GastoDepreciacion gastodepreciacion:this.gastodepreciacions) {
				

				classes=new ArrayList<Classe>();
				classes=CuentaContaGastoDepreConstantesFunciones.getClassesForeignKeysOfCuentaContaGastoDepre(new ArrayList<Classe>(),DeepLoadType.NONE);

				cuentacontagastodepreLogic.setCuentaContaGastoDepres(gastodepreciacion.cuentacontagastodepres);
				cuentacontagastodepreLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(GastoDepreciacion gastodepreciacion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			GastoDepreciacionLogicAdditional.updateGastoDepreciacionToGet(gastodepreciacion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		gastodepreciacion.setEmpresa(gastodepreciacionDataAccess.getEmpresa(connexion,gastodepreciacion));
		gastodepreciacion.setDetalleGrupoActivoFijo(gastodepreciacionDataAccess.getDetalleGrupoActivoFijo(connexion,gastodepreciacion));
		gastodepreciacion.setCuentaContaGastoDepres(gastodepreciacionDataAccess.getCuentaContaGastoDepres(connexion,gastodepreciacion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				gastodepreciacion.setEmpresa(gastodepreciacionDataAccess.getEmpresa(connexion,gastodepreciacion));
				continue;
			}

			if(clas.clas.equals(DetalleGrupoActivoFijo.class)) {
				gastodepreciacion.setDetalleGrupoActivoFijo(gastodepreciacionDataAccess.getDetalleGrupoActivoFijo(connexion,gastodepreciacion));
				continue;
			}

			if(clas.clas.equals(CuentaContaGastoDepre.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				gastodepreciacion.setCuentaContaGastoDepres(gastodepreciacionDataAccess.getCuentaContaGastoDepres(connexion,gastodepreciacion));

				if(this.isConDeep) {
					CuentaContaGastoDepreLogic cuentacontagastodepreLogic= new CuentaContaGastoDepreLogic(this.connexion);
					cuentacontagastodepreLogic.setCuentaContaGastoDepres(gastodepreciacion.getCuentaContaGastoDepres());
					ArrayList<Classe> classesLocal=CuentaContaGastoDepreConstantesFunciones.getClassesForeignKeysOfCuentaContaGastoDepre(new ArrayList<Classe>(),DeepLoadType.NONE);
					cuentacontagastodepreLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CuentaContaGastoDepreConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContaGastoDepre(cuentacontagastodepreLogic.getCuentaContaGastoDepres());
					gastodepreciacion.setCuentaContaGastoDepres(cuentacontagastodepreLogic.getCuentaContaGastoDepres());
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
			gastodepreciacion.setEmpresa(gastodepreciacionDataAccess.getEmpresa(connexion,gastodepreciacion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleGrupoActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			gastodepreciacion.setDetalleGrupoActivoFijo(gastodepreciacionDataAccess.getDetalleGrupoActivoFijo(connexion,gastodepreciacion));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContaGastoDepre.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CuentaContaGastoDepre.class));
			gastodepreciacion.setCuentaContaGastoDepres(gastodepreciacionDataAccess.getCuentaContaGastoDepres(connexion,gastodepreciacion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		gastodepreciacion.setEmpresa(gastodepreciacionDataAccess.getEmpresa(connexion,gastodepreciacion));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(gastodepreciacion.getEmpresa(),isDeep,deepLoadType,clases);
				
		gastodepreciacion.setDetalleGrupoActivoFijo(gastodepreciacionDataAccess.getDetalleGrupoActivoFijo(connexion,gastodepreciacion));
		DetalleGrupoActivoFijoLogic detallegrupoactivofijoLogic= new DetalleGrupoActivoFijoLogic(connexion);
		detallegrupoactivofijoLogic.deepLoad(gastodepreciacion.getDetalleGrupoActivoFijo(),isDeep,deepLoadType,clases);
				

		gastodepreciacion.setCuentaContaGastoDepres(gastodepreciacionDataAccess.getCuentaContaGastoDepres(connexion,gastodepreciacion));

		for(CuentaContaGastoDepre cuentacontagastodepre:gastodepreciacion.getCuentaContaGastoDepres()) {
			CuentaContaGastoDepreLogic cuentacontagastodepreLogic= new CuentaContaGastoDepreLogic(connexion);
			cuentacontagastodepreLogic.deepLoad(cuentacontagastodepre,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				gastodepreciacion.setEmpresa(gastodepreciacionDataAccess.getEmpresa(connexion,gastodepreciacion));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(gastodepreciacion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleGrupoActivoFijo.class)) {
				gastodepreciacion.setDetalleGrupoActivoFijo(gastodepreciacionDataAccess.getDetalleGrupoActivoFijo(connexion,gastodepreciacion));
				DetalleGrupoActivoFijoLogic detallegrupoactivofijoLogic= new DetalleGrupoActivoFijoLogic(connexion);
				detallegrupoactivofijoLogic.deepLoad(gastodepreciacion.getDetalleGrupoActivoFijo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContaGastoDepre.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				gastodepreciacion.setCuentaContaGastoDepres(gastodepreciacionDataAccess.getCuentaContaGastoDepres(connexion,gastodepreciacion));

				for(CuentaContaGastoDepre cuentacontagastodepre:gastodepreciacion.getCuentaContaGastoDepres()) {
					CuentaContaGastoDepreLogic cuentacontagastodepreLogic= new CuentaContaGastoDepreLogic(connexion);
					cuentacontagastodepreLogic.deepLoad(cuentacontagastodepre,isDeep,deepLoadType,clases);
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
			gastodepreciacion.setEmpresa(gastodepreciacionDataAccess.getEmpresa(connexion,gastodepreciacion));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(gastodepreciacion.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleGrupoActivoFijo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			gastodepreciacion.setDetalleGrupoActivoFijo(gastodepreciacionDataAccess.getDetalleGrupoActivoFijo(connexion,gastodepreciacion));
			DetalleGrupoActivoFijoLogic detallegrupoactivofijoLogic= new DetalleGrupoActivoFijoLogic(connexion);
			detallegrupoactivofijoLogic.deepLoad(gastodepreciacion.getDetalleGrupoActivoFijo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContaGastoDepre.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CuentaContaGastoDepre.class));
			gastodepreciacion.setCuentaContaGastoDepres(gastodepreciacionDataAccess.getCuentaContaGastoDepres(connexion,gastodepreciacion));

			for(CuentaContaGastoDepre cuentacontagastodepre:gastodepreciacion.getCuentaContaGastoDepres()) {
				CuentaContaGastoDepreLogic cuentacontagastodepreLogic= new CuentaContaGastoDepreLogic(connexion);
				cuentacontagastodepreLogic.deepLoad(cuentacontagastodepre,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(GastoDepreciacion gastodepreciacion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			GastoDepreciacionLogicAdditional.updateGastoDepreciacionToSave(gastodepreciacion,this.arrDatoGeneral);
			
GastoDepreciacionDataAccess.save(gastodepreciacion, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(gastodepreciacion.getEmpresa(),connexion);

		DetalleGrupoActivoFijoDataAccess.save(gastodepreciacion.getDetalleGrupoActivoFijo(),connexion);

		for(CuentaContaGastoDepre cuentacontagastodepre:gastodepreciacion.getCuentaContaGastoDepres()) {
			cuentacontagastodepre.setid_gasto_depreciacion(gastodepreciacion.getId());
			CuentaContaGastoDepreDataAccess.save(cuentacontagastodepre,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(gastodepreciacion.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(DetalleGrupoActivoFijo.class)) {
				DetalleGrupoActivoFijoDataAccess.save(gastodepreciacion.getDetalleGrupoActivoFijo(),connexion);
				continue;
			}


			if(clas.clas.equals(CuentaContaGastoDepre.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CuentaContaGastoDepre cuentacontagastodepre:gastodepreciacion.getCuentaContaGastoDepres()) {
					cuentacontagastodepre.setid_gasto_depreciacion(gastodepreciacion.getId());
					CuentaContaGastoDepreDataAccess.save(cuentacontagastodepre,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(gastodepreciacion.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(gastodepreciacion.getEmpresa(),isDeep,deepLoadType,clases);
				

		DetalleGrupoActivoFijoDataAccess.save(gastodepreciacion.getDetalleGrupoActivoFijo(),connexion);
		DetalleGrupoActivoFijoLogic detallegrupoactivofijoLogic= new DetalleGrupoActivoFijoLogic(connexion);
		detallegrupoactivofijoLogic.deepLoad(gastodepreciacion.getDetalleGrupoActivoFijo(),isDeep,deepLoadType,clases);
				

		for(CuentaContaGastoDepre cuentacontagastodepre:gastodepreciacion.getCuentaContaGastoDepres()) {
			CuentaContaGastoDepreLogic cuentacontagastodepreLogic= new CuentaContaGastoDepreLogic(connexion);
			cuentacontagastodepre.setid_gasto_depreciacion(gastodepreciacion.getId());
			CuentaContaGastoDepreDataAccess.save(cuentacontagastodepre,connexion);
			cuentacontagastodepreLogic.deepSave(cuentacontagastodepre,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(gastodepreciacion.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(gastodepreciacion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleGrupoActivoFijo.class)) {
				DetalleGrupoActivoFijoDataAccess.save(gastodepreciacion.getDetalleGrupoActivoFijo(),connexion);
				DetalleGrupoActivoFijoLogic detallegrupoactivofijoLogic= new DetalleGrupoActivoFijoLogic(connexion);
				detallegrupoactivofijoLogic.deepSave(gastodepreciacion.getDetalleGrupoActivoFijo(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(CuentaContaGastoDepre.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CuentaContaGastoDepre cuentacontagastodepre:gastodepreciacion.getCuentaContaGastoDepres()) {
					CuentaContaGastoDepreLogic cuentacontagastodepreLogic= new CuentaContaGastoDepreLogic(connexion);
					cuentacontagastodepre.setid_gasto_depreciacion(gastodepreciacion.getId());
					CuentaContaGastoDepreDataAccess.save(cuentacontagastodepre,connexion);
					cuentacontagastodepreLogic.deepSave(cuentacontagastodepre,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(GastoDepreciacion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(gastodepreciacion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				GastoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacion(gastodepreciacion);
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
			this.deepLoad(this.gastodepreciacion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				GastoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacion(this.gastodepreciacion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(GastoDepreciacion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(gastodepreciacions!=null) {
				for(GastoDepreciacion gastodepreciacion:gastodepreciacions) {
					this.deepLoad(gastodepreciacion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					GastoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacion(gastodepreciacions);
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
			if(gastodepreciacions!=null) {
				for(GastoDepreciacion gastodepreciacion:gastodepreciacions) {
					this.deepLoad(gastodepreciacion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					GastoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacion(gastodepreciacions);
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
			this.getNewConnexionToDeep(GastoDepreciacion.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(gastodepreciacion,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(GastoDepreciacion.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(gastodepreciacions!=null) {
				for(GastoDepreciacion gastodepreciacion:gastodepreciacions) {
					this.deepSave(gastodepreciacion,isDeep,deepLoadType,clases);
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
			if(gastodepreciacions!=null) {
				for(GastoDepreciacion gastodepreciacion:gastodepreciacions) {
					this.deepSave(gastodepreciacion,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getGastoDepreciacionsFK_IdDetalleGrupoActivoFijoWithConnection(String sFinalQuery,Pagination pagination,Long id_detalle_grupo_activo_fijo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDetalleGrupoActivoFijo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDetalleGrupoActivoFijo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_detalle_grupo_activo_fijo,GastoDepreciacionConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDetalleGrupoActivoFijo);

			GastoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleGrupoActivoFijo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			gastodepreciacions=gastodepreciacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GastoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacion(this.gastodepreciacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGastoDepreciacionsFK_IdDetalleGrupoActivoFijo(String sFinalQuery,Pagination pagination,Long id_detalle_grupo_activo_fijo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDetalleGrupoActivoFijo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDetalleGrupoActivoFijo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_detalle_grupo_activo_fijo,GastoDepreciacionConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDetalleGrupoActivoFijo);

			GastoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetalleGrupoActivoFijo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			gastodepreciacions=gastodepreciacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GastoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacion(this.gastodepreciacions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGastoDepreciacionsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GastoDepreciacion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,GastoDepreciacionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			GastoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			gastodepreciacions=gastodepreciacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GastoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacion(this.gastodepreciacions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGastoDepreciacionsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,GastoDepreciacionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			GastoDepreciacionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			gastodepreciacions=gastodepreciacionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GastoDepreciacionConstantesFunciones.refrescarForeignKeysDescripcionesGastoDepreciacion(this.gastodepreciacions);
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
			if(GastoDepreciacionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,GastoDepreciacionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,GastoDepreciacion gastodepreciacion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(GastoDepreciacionConstantesFunciones.ISCONAUDITORIA) {
				if(gastodepreciacion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,GastoDepreciacionDataAccess.TABLENAME, gastodepreciacion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(GastoDepreciacionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////GastoDepreciacionLogic.registrarAuditoriaDetallesGastoDepreciacion(connexion,gastodepreciacion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(gastodepreciacion.getIsDeleted()) {
					/*if(!gastodepreciacion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,GastoDepreciacionDataAccess.TABLENAME, gastodepreciacion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////GastoDepreciacionLogic.registrarAuditoriaDetallesGastoDepreciacion(connexion,gastodepreciacion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,GastoDepreciacionDataAccess.TABLENAME, gastodepreciacion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(gastodepreciacion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,GastoDepreciacionDataAccess.TABLENAME, gastodepreciacion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(GastoDepreciacionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////GastoDepreciacionLogic.registrarAuditoriaDetallesGastoDepreciacion(connexion,gastodepreciacion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesGastoDepreciacion(Connexion connexion,GastoDepreciacion gastodepreciacion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(gastodepreciacion.getIsNew()||!gastodepreciacion.getid_empresa().equals(gastodepreciacion.getGastoDepreciacionOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(gastodepreciacion.getGastoDepreciacionOriginal().getid_empresa()!=null)
				{
					strValorActual=gastodepreciacion.getGastoDepreciacionOriginal().getid_empresa().toString();
				}
				if(gastodepreciacion.getid_empresa()!=null)
				{
					strValorNuevo=gastodepreciacion.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GastoDepreciacionConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(gastodepreciacion.getIsNew()||!gastodepreciacion.getid_detalle_grupo_activo_fijo().equals(gastodepreciacion.getGastoDepreciacionOriginal().getid_detalle_grupo_activo_fijo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(gastodepreciacion.getGastoDepreciacionOriginal().getid_detalle_grupo_activo_fijo()!=null)
				{
					strValorActual=gastodepreciacion.getGastoDepreciacionOriginal().getid_detalle_grupo_activo_fijo().toString();
				}
				if(gastodepreciacion.getid_detalle_grupo_activo_fijo()!=null)
				{
					strValorNuevo=gastodepreciacion.getid_detalle_grupo_activo_fijo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GastoDepreciacionConstantesFunciones.IDDETALLEGRUPOACTIVOFIJO,strValorActual,strValorNuevo);
			}	
			
			if(gastodepreciacion.getIsNew()||!gastodepreciacion.getanio().equals(gastodepreciacion.getGastoDepreciacionOriginal().getanio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(gastodepreciacion.getGastoDepreciacionOriginal().getanio()!=null)
				{
					strValorActual=gastodepreciacion.getGastoDepreciacionOriginal().getanio().toString();
				}
				if(gastodepreciacion.getanio()!=null)
				{
					strValorNuevo=gastodepreciacion.getanio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GastoDepreciacionConstantesFunciones.ANIO,strValorActual,strValorNuevo);
			}	
			
			if(gastodepreciacion.getIsNew()||!gastodepreciacion.getvalor().equals(gastodepreciacion.getGastoDepreciacionOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(gastodepreciacion.getGastoDepreciacionOriginal().getvalor()!=null)
				{
					strValorActual=gastodepreciacion.getGastoDepreciacionOriginal().getvalor().toString();
				}
				if(gastodepreciacion.getvalor()!=null)
				{
					strValorNuevo=gastodepreciacion.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GastoDepreciacionConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveGastoDepreciacionRelacionesWithConnection(GastoDepreciacion gastodepreciacion,List<CuentaContaGastoDepre> cuentacontagastodepres) throws Exception {

		if(!gastodepreciacion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveGastoDepreciacionRelacionesBase(gastodepreciacion,cuentacontagastodepres,true);
		}
	}

	public void saveGastoDepreciacionRelaciones(GastoDepreciacion gastodepreciacion,List<CuentaContaGastoDepre> cuentacontagastodepres)throws Exception {

		if(!gastodepreciacion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveGastoDepreciacionRelacionesBase(gastodepreciacion,cuentacontagastodepres,false);
		}
	}

	public void saveGastoDepreciacionRelacionesBase(GastoDepreciacion gastodepreciacion,List<CuentaContaGastoDepre> cuentacontagastodepres,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("GastoDepreciacion-saveRelacionesWithConnection");}
	
			gastodepreciacion.setCuentaContaGastoDepres(cuentacontagastodepres);

			this.setGastoDepreciacion(gastodepreciacion);

			if(GastoDepreciacionLogicAdditional.validarSaveRelaciones(gastodepreciacion,this)) {

				GastoDepreciacionLogicAdditional.updateRelacionesToSave(gastodepreciacion,this);

				if((gastodepreciacion.getIsNew()||gastodepreciacion.getIsChanged())&&!gastodepreciacion.getIsDeleted()) {
					this.saveGastoDepreciacion();
					this.saveGastoDepreciacionRelacionesDetalles(cuentacontagastodepres);

				} else if(gastodepreciacion.getIsDeleted()) {
					this.saveGastoDepreciacionRelacionesDetalles(cuentacontagastodepres);
					this.saveGastoDepreciacion();
				}

				GastoDepreciacionLogicAdditional.updateRelacionesToSaveAfter(gastodepreciacion,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			CuentaContaGastoDepreConstantesFunciones.InicializarGeneralEntityAuxiliaresCuentaContaGastoDepres(cuentacontagastodepres,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveGastoDepreciacionRelacionesDetalles(List<CuentaContaGastoDepre> cuentacontagastodepres)throws Exception {
		try {
	

			Long idGastoDepreciacionActual=this.getGastoDepreciacion().getId();

			CuentaContaGastoDepreLogic cuentacontagastodepreLogic_Desde_GastoDepreciacion=new CuentaContaGastoDepreLogic();
			cuentacontagastodepreLogic_Desde_GastoDepreciacion.setCuentaContaGastoDepres(cuentacontagastodepres);

			cuentacontagastodepreLogic_Desde_GastoDepreciacion.setConnexion(this.getConnexion());
			cuentacontagastodepreLogic_Desde_GastoDepreciacion.setDatosCliente(this.datosCliente);

			for(CuentaContaGastoDepre cuentacontagastodepre_Desde_GastoDepreciacion:cuentacontagastodepreLogic_Desde_GastoDepreciacion.getCuentaContaGastoDepres()) {
				cuentacontagastodepre_Desde_GastoDepreciacion.setid_gasto_depreciacion(idGastoDepreciacionActual);
			}

			cuentacontagastodepreLogic_Desde_GastoDepreciacion.saveCuentaContaGastoDepres();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfGastoDepreciacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=GastoDepreciacionConstantesFunciones.getClassesForeignKeysOfGastoDepreciacion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfGastoDepreciacion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=GastoDepreciacionConstantesFunciones.getClassesRelationshipsOfGastoDepreciacion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

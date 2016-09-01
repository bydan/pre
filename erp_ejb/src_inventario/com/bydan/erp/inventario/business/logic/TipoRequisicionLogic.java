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
import com.bydan.erp.inventario.util.TipoRequisicionConstantesFunciones;
import com.bydan.erp.inventario.util.TipoRequisicionParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TipoRequisicionParameterGeneral;
import com.bydan.erp.inventario.business.entity.TipoRequisicion;
import com.bydan.erp.inventario.business.logic.TipoRequisicionLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoRequisicionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoRequisicionLogic.class);
	
	protected TipoRequisicionDataAccess tiporequisicionDataAccess; 	
	protected TipoRequisicion tiporequisicion;
	protected List<TipoRequisicion> tiporequisicions;
	protected Object tiporequisicionObject;	
	protected List<Object> tiporequisicionsObject;
	
	public static ClassValidator<TipoRequisicion> tiporequisicionValidator = new ClassValidator<TipoRequisicion>(TipoRequisicion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoRequisicionLogicAdditional tiporequisicionLogicAdditional=null;
	
	public TipoRequisicionLogicAdditional getTipoRequisicionLogicAdditional() {
		return this.tiporequisicionLogicAdditional;
	}
	
	public void setTipoRequisicionLogicAdditional(TipoRequisicionLogicAdditional tiporequisicionLogicAdditional) {
		try {
			this.tiporequisicionLogicAdditional=tiporequisicionLogicAdditional;
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
	
	
	
	
	public  TipoRequisicionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tiporequisicionDataAccess = new TipoRequisicionDataAccess();
			
			this.tiporequisicions= new ArrayList<TipoRequisicion>();
			this.tiporequisicion= new TipoRequisicion();
			
			this.tiporequisicionObject=new Object();
			this.tiporequisicionsObject=new ArrayList<Object>();
				
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
			
			this.tiporequisicionDataAccess.setConnexionType(this.connexionType);
			this.tiporequisicionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoRequisicionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tiporequisicionDataAccess = new TipoRequisicionDataAccess();
			this.tiporequisicions= new ArrayList<TipoRequisicion>();
			this.tiporequisicion= new TipoRequisicion();
			this.tiporequisicionObject=new Object();
			this.tiporequisicionsObject=new ArrayList<Object>();
			
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
			
			this.tiporequisicionDataAccess.setConnexionType(this.connexionType);
			this.tiporequisicionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoRequisicion getTipoRequisicion() throws Exception {	
		TipoRequisicionLogicAdditional.checkTipoRequisicionToGet(tiporequisicion,this.datosCliente,this.arrDatoGeneral);
		TipoRequisicionLogicAdditional.updateTipoRequisicionToGet(tiporequisicion,this.arrDatoGeneral);
		
		return tiporequisicion;
	}
		
	public void setTipoRequisicion(TipoRequisicion newTipoRequisicion) {
		this.tiporequisicion = newTipoRequisicion;
	}
	
	public TipoRequisicionDataAccess getTipoRequisicionDataAccess() {
		return tiporequisicionDataAccess;
	}
	
	public void setTipoRequisicionDataAccess(TipoRequisicionDataAccess newtiporequisicionDataAccess) {
		this.tiporequisicionDataAccess = newtiporequisicionDataAccess;
	}
	
	public List<TipoRequisicion> getTipoRequisicions() throws Exception {		
		this.quitarTipoRequisicionsNulos();
		
		TipoRequisicionLogicAdditional.checkTipoRequisicionToGets(tiporequisicions,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoRequisicion tiporequisicionLocal: tiporequisicions ) {
			TipoRequisicionLogicAdditional.updateTipoRequisicionToGet(tiporequisicionLocal,this.arrDatoGeneral);
		}
		
		return tiporequisicions;
	}
	
	public void setTipoRequisicions(List<TipoRequisicion> newTipoRequisicions) {
		this.tiporequisicions = newTipoRequisicions;
	}
	
	public Object getTipoRequisicionObject() {	
		this.tiporequisicionObject=this.tiporequisicionDataAccess.getEntityObject();
		return this.tiporequisicionObject;
	}
		
	public void setTipoRequisicionObject(Object newTipoRequisicionObject) {
		this.tiporequisicionObject = newTipoRequisicionObject;
	}
	
	public List<Object> getTipoRequisicionsObject() {		
		this.tiporequisicionsObject=this.tiporequisicionDataAccess.getEntitiesObject();
		return this.tiporequisicionsObject;
	}
		
	public void setTipoRequisicionsObject(List<Object> newTipoRequisicionsObject) {
		this.tiporequisicionsObject = newTipoRequisicionsObject;
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
		
		if(this.tiporequisicionDataAccess!=null) {
			this.tiporequisicionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRequisicion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tiporequisicionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tiporequisicionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tiporequisicion = new  TipoRequisicion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRequisicion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tiporequisicion=tiporequisicionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiporequisicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoRequisicion(this.tiporequisicion);
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
		tiporequisicion = new  TipoRequisicion();
		  		  
        try {
			
			tiporequisicion=tiporequisicionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiporequisicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoRequisicion(this.tiporequisicion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tiporequisicion = new  TipoRequisicion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRequisicion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tiporequisicion=tiporequisicionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiporequisicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoRequisicion(this.tiporequisicion);
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
		tiporequisicion = new  TipoRequisicion();
		  		  
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
		tiporequisicion = new  TipoRequisicion();
		  		  
        try {
			
			tiporequisicion=tiporequisicionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiporequisicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoRequisicion(this.tiporequisicion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tiporequisicion = new  TipoRequisicion();
		  		  
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
		tiporequisicion = new  TipoRequisicion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRequisicion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tiporequisicionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiporequisicion = new  TipoRequisicion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tiporequisicionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tiporequisicion = new  TipoRequisicion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRequisicion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tiporequisicionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiporequisicion = new  TipoRequisicion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tiporequisicionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tiporequisicion = new  TipoRequisicion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRequisicion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tiporequisicionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiporequisicion = new  TipoRequisicion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tiporequisicionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tiporequisicions = new  ArrayList<TipoRequisicion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRequisicion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporequisicions=tiporequisicionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRequisicion(tiporequisicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoRequisicion(this.tiporequisicions);
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
		tiporequisicions = new  ArrayList<TipoRequisicion>();
		  		  
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
		tiporequisicions = new  ArrayList<TipoRequisicion>();
		  		  
        try {			
			TipoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporequisicions=tiporequisicionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoRequisicion(tiporequisicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoRequisicion(this.tiporequisicions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tiporequisicions = new  ArrayList<TipoRequisicion>();
		  		  
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
		tiporequisicions = new  ArrayList<TipoRequisicion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRequisicion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporequisicions=tiporequisicionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRequisicion(tiporequisicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoRequisicion(this.tiporequisicions);
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
		tiporequisicions = new  ArrayList<TipoRequisicion>();
		  		  
        try {
			TipoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporequisicions=tiporequisicionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRequisicion(tiporequisicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoRequisicion(this.tiporequisicions);
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
		tiporequisicions = new  ArrayList<TipoRequisicion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRequisicion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporequisicions=tiporequisicionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoRequisicion(tiporequisicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoRequisicion(this.tiporequisicions);
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
		tiporequisicions = new  ArrayList<TipoRequisicion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporequisicions=tiporequisicionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoRequisicion(tiporequisicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoRequisicion(this.tiporequisicions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tiporequisicion = new  TipoRequisicion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRequisicion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporequisicion=tiporequisicionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoRequisicion(tiporequisicion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoRequisicion(this.tiporequisicion);
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
		tiporequisicion = new  TipoRequisicion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporequisicion=tiporequisicionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoRequisicion(tiporequisicion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoRequisicion(this.tiporequisicion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tiporequisicions = new  ArrayList<TipoRequisicion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRequisicion.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporequisicions=tiporequisicionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRequisicion(tiporequisicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoRequisicion(this.tiporequisicions);
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
		tiporequisicions = new  ArrayList<TipoRequisicion>();
		  		  
        try {
			TipoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporequisicions=tiporequisicionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRequisicion(tiporequisicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoRequisicion(this.tiporequisicions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoRequisicionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tiporequisicions = new  ArrayList<TipoRequisicion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRequisicion.class.getSimpleName()+"-getTodosTipoRequisicionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporequisicions=tiporequisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoRequisicion(tiporequisicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoRequisicion(this.tiporequisicions);
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
	
	public  void  getTodosTipoRequisicions(String sFinalQuery,Pagination pagination)throws Exception {
		tiporequisicions = new  ArrayList<TipoRequisicion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporequisicions=tiporequisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoRequisicion(tiporequisicions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoRequisicion(this.tiporequisicions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoRequisicion(TipoRequisicion tiporequisicion) throws Exception {
		Boolean estaValidado=false;
		
		if(tiporequisicion.getIsNew() || tiporequisicion.getIsChanged()) { 
			this.invalidValues = tiporequisicionValidator.getInvalidValues(tiporequisicion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tiporequisicion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoRequisicion(List<TipoRequisicion> TipoRequisicions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoRequisicion tiporequisicionLocal:tiporequisicions) {				
			estaValidadoObjeto=this.validarGuardarTipoRequisicion(tiporequisicionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoRequisicion(List<TipoRequisicion> TipoRequisicions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoRequisicion(tiporequisicions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoRequisicion(TipoRequisicion TipoRequisicion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoRequisicion(tiporequisicion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoRequisicion tiporequisicion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tiporequisicion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoRequisicionConstantesFunciones.getTipoRequisicionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tiporequisicion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoRequisicionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoRequisicionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoRequisicionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRequisicion.class.getSimpleName()+"-saveTipoRequisicionWithConnection");connexion.begin();			
			
			TipoRequisicionLogicAdditional.checkTipoRequisicionToSave(this.tiporequisicion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoRequisicionLogicAdditional.updateTipoRequisicionToSave(this.tiporequisicion,this.arrDatoGeneral);
			
			TipoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tiporequisicion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoRequisicion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoRequisicion(this.tiporequisicion)) {
				TipoRequisicionDataAccess.save(this.tiporequisicion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tiporequisicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoRequisicionLogicAdditional.checkTipoRequisicionToSaveAfter(this.tiporequisicion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoRequisicion();
			
			connexion.commit();			
			
			if(this.tiporequisicion.getIsDeleted()) {
				this.tiporequisicion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoRequisicion()throws Exception {	
		try {	
			
			TipoRequisicionLogicAdditional.checkTipoRequisicionToSave(this.tiporequisicion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoRequisicionLogicAdditional.updateTipoRequisicionToSave(this.tiporequisicion,this.arrDatoGeneral);
			
			TipoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tiporequisicion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoRequisicion(this.tiporequisicion)) {			
				TipoRequisicionDataAccess.save(this.tiporequisicion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tiporequisicion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoRequisicionLogicAdditional.checkTipoRequisicionToSaveAfter(this.tiporequisicion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tiporequisicion.getIsDeleted()) {
				this.tiporequisicion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoRequisicionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRequisicion.class.getSimpleName()+"-saveTipoRequisicionsWithConnection");connexion.begin();			
			
			TipoRequisicionLogicAdditional.checkTipoRequisicionToSaves(tiporequisicions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoRequisicions();
			
			Boolean validadoTodosTipoRequisicion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoRequisicion tiporequisicionLocal:tiporequisicions) {		
				if(tiporequisicionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoRequisicionLogicAdditional.updateTipoRequisicionToSave(tiporequisicionLocal,this.arrDatoGeneral);
	        	
				TipoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tiporequisicionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoRequisicion(tiporequisicionLocal)) {
					TipoRequisicionDataAccess.save(tiporequisicionLocal, connexion);				
				} else {
					validadoTodosTipoRequisicion=false;
				}
			}
			
			if(!validadoTodosTipoRequisicion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoRequisicionLogicAdditional.checkTipoRequisicionToSavesAfter(tiporequisicions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoRequisicions();
			
			connexion.commit();		
			
			this.quitarTipoRequisicionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoRequisicions()throws Exception {				
		 try {	
			TipoRequisicionLogicAdditional.checkTipoRequisicionToSaves(tiporequisicions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoRequisicion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoRequisicion tiporequisicionLocal:tiporequisicions) {				
				if(tiporequisicionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoRequisicionLogicAdditional.updateTipoRequisicionToSave(tiporequisicionLocal,this.arrDatoGeneral);
	        	
				TipoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tiporequisicionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoRequisicion(tiporequisicionLocal)) {				
					TipoRequisicionDataAccess.save(tiporequisicionLocal, connexion);				
				} else {
					validadoTodosTipoRequisicion=false;
				}
			}
			
			if(!validadoTodosTipoRequisicion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoRequisicionLogicAdditional.checkTipoRequisicionToSavesAfter(tiporequisicions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoRequisicionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoRequisicionParameterReturnGeneral procesarAccionTipoRequisicions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoRequisicion> tiporequisicions,TipoRequisicionParameterReturnGeneral tiporequisicionParameterGeneral)throws Exception {
		 try {	
			TipoRequisicionParameterReturnGeneral tiporequisicionReturnGeneral=new TipoRequisicionParameterReturnGeneral();
	
			TipoRequisicionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tiporequisicions,tiporequisicionParameterGeneral,tiporequisicionReturnGeneral);
			
			return tiporequisicionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoRequisicionParameterReturnGeneral procesarAccionTipoRequisicionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoRequisicion> tiporequisicions,TipoRequisicionParameterReturnGeneral tiporequisicionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRequisicion.class.getSimpleName()+"-procesarAccionTipoRequisicionsWithConnection");connexion.begin();			
			
			TipoRequisicionParameterReturnGeneral tiporequisicionReturnGeneral=new TipoRequisicionParameterReturnGeneral();
	
			TipoRequisicionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tiporequisicions,tiporequisicionParameterGeneral,tiporequisicionReturnGeneral);
			
			this.connexion.commit();
			
			return tiporequisicionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoRequisicionParameterReturnGeneral procesarEventosTipoRequisicions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoRequisicion> tiporequisicions,TipoRequisicion tiporequisicion,TipoRequisicionParameterReturnGeneral tiporequisicionParameterGeneral,Boolean isEsNuevoTipoRequisicion,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoRequisicionParameterReturnGeneral tiporequisicionReturnGeneral=new TipoRequisicionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tiporequisicionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoRequisicionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tiporequisicions,tiporequisicion,tiporequisicionParameterGeneral,tiporequisicionReturnGeneral,isEsNuevoTipoRequisicion,clases);
			
			return tiporequisicionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoRequisicionParameterReturnGeneral procesarEventosTipoRequisicionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoRequisicion> tiporequisicions,TipoRequisicion tiporequisicion,TipoRequisicionParameterReturnGeneral tiporequisicionParameterGeneral,Boolean isEsNuevoTipoRequisicion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRequisicion.class.getSimpleName()+"-procesarEventosTipoRequisicionsWithConnection");connexion.begin();			
			
			TipoRequisicionParameterReturnGeneral tiporequisicionReturnGeneral=new TipoRequisicionParameterReturnGeneral();
	
			tiporequisicionReturnGeneral.setTipoRequisicion(tiporequisicion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tiporequisicionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoRequisicionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tiporequisicions,tiporequisicion,tiporequisicionParameterGeneral,tiporequisicionReturnGeneral,isEsNuevoTipoRequisicion,clases);
			
			this.connexion.commit();
			
			return tiporequisicionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoRequisicionParameterReturnGeneral procesarImportacionTipoRequisicionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoRequisicionParameterReturnGeneral tiporequisicionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRequisicion.class.getSimpleName()+"-procesarImportacionTipoRequisicionsWithConnection");connexion.begin();			
			
			TipoRequisicionParameterReturnGeneral tiporequisicionReturnGeneral=new TipoRequisicionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tiporequisicions=new ArrayList<TipoRequisicion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tiporequisicion=new TipoRequisicion();
				
				
				if(conColumnasBase) {this.tiporequisicion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tiporequisicion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tiporequisicion.setcodigo(arrColumnas[iColumn++]);
				this.tiporequisicion.setnombre(arrColumnas[iColumn++]);
				//this.tiporequisicion.sethora(arrColumnas[iColumn++]);
				
				this.tiporequisicions.add(this.tiporequisicion);
			}
			
			this.saveTipoRequisicions();
			
			this.connexion.commit();
			
			tiporequisicionReturnGeneral.setConRetornoEstaProcesado(true);
			tiporequisicionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tiporequisicionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoRequisicionsEliminados() throws Exception {				
		
		List<TipoRequisicion> tiporequisicionsAux= new ArrayList<TipoRequisicion>();
		
		for(TipoRequisicion tiporequisicion:tiporequisicions) {
			if(!tiporequisicion.getIsDeleted()) {
				tiporequisicionsAux.add(tiporequisicion);
			}
		}
		
		tiporequisicions=tiporequisicionsAux;
	}
	
	public void quitarTipoRequisicionsNulos() throws Exception {				
		
		List<TipoRequisicion> tiporequisicionsAux= new ArrayList<TipoRequisicion>();
		
		for(TipoRequisicion tiporequisicion : this.tiporequisicions) {
			if(tiporequisicion==null) {
				tiporequisicionsAux.add(tiporequisicion);
			}
		}
		
		//this.tiporequisicions=tiporequisicionsAux;
		
		this.tiporequisicions.removeAll(tiporequisicionsAux);
	}
	
	public void getSetVersionRowTipoRequisicionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tiporequisicion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tiporequisicion.getIsDeleted() || (tiporequisicion.getIsChanged()&&!tiporequisicion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tiporequisicionDataAccess.getSetVersionRowTipoRequisicion(connexion,tiporequisicion.getId());
				
				if(!tiporequisicion.getVersionRow().equals(timestamp)) {	
					tiporequisicion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tiporequisicion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoRequisicion()throws Exception {	
		
		if(tiporequisicion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tiporequisicion.getIsDeleted() || (tiporequisicion.getIsChanged()&&!tiporequisicion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tiporequisicionDataAccess.getSetVersionRowTipoRequisicion(connexion,tiporequisicion.getId());
			
			try {							
				if(!tiporequisicion.getVersionRow().equals(timestamp)) {	
					tiporequisicion.setVersionRow(timestamp);
				}
				
				tiporequisicion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoRequisicionsWithConnection()throws Exception {	
		if(tiporequisicions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoRequisicion tiporequisicionAux:tiporequisicions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tiporequisicionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tiporequisicionAux.getIsDeleted() || (tiporequisicionAux.getIsChanged()&&!tiporequisicionAux.getIsNew())) {
						
						timestamp=tiporequisicionDataAccess.getSetVersionRowTipoRequisicion(connexion,tiporequisicionAux.getId());
						
						if(!tiporequisicion.getVersionRow().equals(timestamp)) {	
							tiporequisicionAux.setVersionRow(timestamp);
						}
								
						tiporequisicionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoRequisicions()throws Exception {	
		if(tiporequisicions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoRequisicion tiporequisicionAux:tiporequisicions) {
					if(tiporequisicionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tiporequisicionAux.getIsDeleted() || (tiporequisicionAux.getIsChanged()&&!tiporequisicionAux.getIsNew())) {
						
						timestamp=tiporequisicionDataAccess.getSetVersionRowTipoRequisicion(connexion,tiporequisicionAux.getId());
						
						if(!tiporequisicionAux.getVersionRow().equals(timestamp)) {	
							tiporequisicionAux.setVersionRow(timestamp);
						}
						
													
						tiporequisicionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoRequisicionParameterReturnGeneral cargarCombosLoteForeignKeyTipoRequisicionWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoPeriodo,String finalQueryGlobalDia) throws Exception {
		TipoRequisicionParameterReturnGeneral  tiporequisicionReturnGeneral =new TipoRequisicionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRequisicion.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoRequisicionWithConnection");connexion.begin();
			
			tiporequisicionReturnGeneral =new TipoRequisicionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tiporequisicionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoPeriodo> tipoperiodosForeignKey=new ArrayList<TipoPeriodo>();
			TipoPeriodoLogic tipoperiodoLogic=new TipoPeriodoLogic();
			tipoperiodoLogic.setConnexion(this.connexion);
			tipoperiodoLogic.getTipoPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPeriodo.equals("NONE")) {
				tipoperiodoLogic.getTodosTipoPeriodos(finalQueryGlobalTipoPeriodo,new Pagination());
				tipoperiodosForeignKey=tipoperiodoLogic.getTipoPeriodos();
			}

			tiporequisicionReturnGeneral.settipoperiodosForeignKey(tipoperiodosForeignKey);


			List<Dia> diasForeignKey=new ArrayList<Dia>();
			DiaLogic diaLogic=new DiaLogic();
			diaLogic.setConnexion(this.connexion);
			diaLogic.getDiaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDia.equals("NONE")) {
				diaLogic.getTodosDias(finalQueryGlobalDia,new Pagination());
				diasForeignKey=diaLogic.getDias();
			}

			tiporequisicionReturnGeneral.setdiasForeignKey(diasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tiporequisicionReturnGeneral;
	}
	
	public TipoRequisicionParameterReturnGeneral cargarCombosLoteForeignKeyTipoRequisicion(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoPeriodo,String finalQueryGlobalDia) throws Exception {
		TipoRequisicionParameterReturnGeneral  tiporequisicionReturnGeneral =new TipoRequisicionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tiporequisicionReturnGeneral =new TipoRequisicionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tiporequisicionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoPeriodo> tipoperiodosForeignKey=new ArrayList<TipoPeriodo>();
			TipoPeriodoLogic tipoperiodoLogic=new TipoPeriodoLogic();
			tipoperiodoLogic.setConnexion(this.connexion);
			tipoperiodoLogic.getTipoPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPeriodo.equals("NONE")) {
				tipoperiodoLogic.getTodosTipoPeriodos(finalQueryGlobalTipoPeriodo,new Pagination());
				tipoperiodosForeignKey=tipoperiodoLogic.getTipoPeriodos();
			}

			tiporequisicionReturnGeneral.settipoperiodosForeignKey(tipoperiodosForeignKey);


			List<Dia> diasForeignKey=new ArrayList<Dia>();
			DiaLogic diaLogic=new DiaLogic();
			diaLogic.setConnexion(this.connexion);
			diaLogic.getDiaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDia.equals("NONE")) {
				diaLogic.getTodosDias(finalQueryGlobalDia,new Pagination());
				diasForeignKey=diaLogic.getDias();
			}

			tiporequisicionReturnGeneral.setdiasForeignKey(diasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tiporequisicionReturnGeneral;
	}
	
	
	public void deepLoad(TipoRequisicion tiporequisicion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoRequisicionLogicAdditional.updateTipoRequisicionToGet(tiporequisicion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tiporequisicion.setEmpresa(tiporequisicionDataAccess.getEmpresa(connexion,tiporequisicion));
		tiporequisicion.setTipoPeriodo(tiporequisicionDataAccess.getTipoPeriodo(connexion,tiporequisicion));
		tiporequisicion.setDia(tiporequisicionDataAccess.getDia(connexion,tiporequisicion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tiporequisicion.setEmpresa(tiporequisicionDataAccess.getEmpresa(connexion,tiporequisicion));
				continue;
			}

			if(clas.clas.equals(TipoPeriodo.class)) {
				tiporequisicion.setTipoPeriodo(tiporequisicionDataAccess.getTipoPeriodo(connexion,tiporequisicion));
				continue;
			}

			if(clas.clas.equals(Dia.class)) {
				tiporequisicion.setDia(tiporequisicionDataAccess.getDia(connexion,tiporequisicion));
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
			tiporequisicion.setEmpresa(tiporequisicionDataAccess.getEmpresa(connexion,tiporequisicion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPeriodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tiporequisicion.setTipoPeriodo(tiporequisicionDataAccess.getTipoPeriodo(connexion,tiporequisicion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Dia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tiporequisicion.setDia(tiporequisicionDataAccess.getDia(connexion,tiporequisicion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tiporequisicion.setEmpresa(tiporequisicionDataAccess.getEmpresa(connexion,tiporequisicion));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tiporequisicion.getEmpresa(),isDeep,deepLoadType,clases);
				
		tiporequisicion.setTipoPeriodo(tiporequisicionDataAccess.getTipoPeriodo(connexion,tiporequisicion));
		TipoPeriodoLogic tipoperiodoLogic= new TipoPeriodoLogic(connexion);
		tipoperiodoLogic.deepLoad(tiporequisicion.getTipoPeriodo(),isDeep,deepLoadType,clases);
				
		tiporequisicion.setDia(tiporequisicionDataAccess.getDia(connexion,tiporequisicion));
		DiaLogic diaLogic= new DiaLogic(connexion);
		diaLogic.deepLoad(tiporequisicion.getDia(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tiporequisicion.setEmpresa(tiporequisicionDataAccess.getEmpresa(connexion,tiporequisicion));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tiporequisicion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPeriodo.class)) {
				tiporequisicion.setTipoPeriodo(tiporequisicionDataAccess.getTipoPeriodo(connexion,tiporequisicion));
				TipoPeriodoLogic tipoperiodoLogic= new TipoPeriodoLogic(connexion);
				tipoperiodoLogic.deepLoad(tiporequisicion.getTipoPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Dia.class)) {
				tiporequisicion.setDia(tiporequisicionDataAccess.getDia(connexion,tiporequisicion));
				DiaLogic diaLogic= new DiaLogic(connexion);
				diaLogic.deepLoad(tiporequisicion.getDia(),isDeep,deepLoadType,clases);				
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
			tiporequisicion.setEmpresa(tiporequisicionDataAccess.getEmpresa(connexion,tiporequisicion));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tiporequisicion.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPeriodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tiporequisicion.setTipoPeriodo(tiporequisicionDataAccess.getTipoPeriodo(connexion,tiporequisicion));
			TipoPeriodoLogic tipoperiodoLogic= new TipoPeriodoLogic(connexion);
			tipoperiodoLogic.deepLoad(tiporequisicion.getTipoPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Dia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tiporequisicion.setDia(tiporequisicionDataAccess.getDia(connexion,tiporequisicion));
			DiaLogic diaLogic= new DiaLogic(connexion);
			diaLogic.deepLoad(tiporequisicion.getDia(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoRequisicion tiporequisicion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoRequisicionLogicAdditional.updateTipoRequisicionToSave(tiporequisicion,this.arrDatoGeneral);
			
TipoRequisicionDataAccess.save(tiporequisicion, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tiporequisicion.getEmpresa(),connexion);

		TipoPeriodoDataAccess.save(tiporequisicion.getTipoPeriodo(),connexion);

		DiaDataAccess.save(tiporequisicion.getDia(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tiporequisicion.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoPeriodo.class)) {
				TipoPeriodoDataAccess.save(tiporequisicion.getTipoPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Dia.class)) {
				DiaDataAccess.save(tiporequisicion.getDia(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tiporequisicion.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tiporequisicion.getEmpresa(),isDeep,deepLoadType,clases);
				

		TipoPeriodoDataAccess.save(tiporequisicion.getTipoPeriodo(),connexion);
		TipoPeriodoLogic tipoperiodoLogic= new TipoPeriodoLogic(connexion);
		tipoperiodoLogic.deepLoad(tiporequisicion.getTipoPeriodo(),isDeep,deepLoadType,clases);
				

		DiaDataAccess.save(tiporequisicion.getDia(),connexion);
		DiaLogic diaLogic= new DiaLogic(connexion);
		diaLogic.deepLoad(tiporequisicion.getDia(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tiporequisicion.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tiporequisicion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPeriodo.class)) {
				TipoPeriodoDataAccess.save(tiporequisicion.getTipoPeriodo(),connexion);
				TipoPeriodoLogic tipoperiodoLogic= new TipoPeriodoLogic(connexion);
				tipoperiodoLogic.deepSave(tiporequisicion.getTipoPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Dia.class)) {
				DiaDataAccess.save(tiporequisicion.getDia(),connexion);
				DiaLogic diaLogic= new DiaLogic(connexion);
				diaLogic.deepSave(tiporequisicion.getDia(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(TipoRequisicion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tiporequisicion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoRequisicion(tiporequisicion);
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
			this.deepLoad(this.tiporequisicion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoRequisicion(this.tiporequisicion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoRequisicion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tiporequisicions!=null) {
				for(TipoRequisicion tiporequisicion:tiporequisicions) {
					this.deepLoad(tiporequisicion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoRequisicion(tiporequisicions);
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
			if(tiporequisicions!=null) {
				for(TipoRequisicion tiporequisicion:tiporequisicions) {
					this.deepLoad(tiporequisicion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoRequisicion(tiporequisicions);
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
			this.getNewConnexionToDeep(TipoRequisicion.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tiporequisicion,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoRequisicion.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tiporequisicions!=null) {
				for(TipoRequisicion tiporequisicion:tiporequisicions) {
					this.deepSave(tiporequisicion,isDeep,deepLoadType,clases);
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
			if(tiporequisicions!=null) {
				for(TipoRequisicion tiporequisicion:tiporequisicions) {
					this.deepSave(tiporequisicion,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoRequisicionsBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRequisicion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TipoRequisicionConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TipoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiporequisicions=tiporequisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoRequisicion(this.tiporequisicions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoRequisicionsBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",TipoRequisicionConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			TipoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiporequisicions=tiporequisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoRequisicion(this.tiporequisicions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoRequisicionsBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRequisicion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoRequisicionConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiporequisicions=tiporequisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoRequisicion(this.tiporequisicions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoRequisicionsBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",TipoRequisicionConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			TipoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiporequisicions=tiporequisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoRequisicion(this.tiporequisicions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoRequisicionsFK_IdDiaWithConnection(String sFinalQuery,Pagination pagination,Long id_dia)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRequisicion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_dia,TipoRequisicionConstantesFunciones.IDDIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDia);

			TipoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiporequisicions=tiporequisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoRequisicion(this.tiporequisicions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoRequisicionsFK_IdDia(String sFinalQuery,Pagination pagination,Long id_dia)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_dia,TipoRequisicionConstantesFunciones.IDDIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDia);

			TipoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiporequisicions=tiporequisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoRequisicion(this.tiporequisicions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoRequisicionsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRequisicion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoRequisicionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiporequisicions=tiporequisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoRequisicion(this.tiporequisicions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoRequisicionsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoRequisicionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiporequisicions=tiporequisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoRequisicion(this.tiporequisicions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoRequisicionsFK_IdTipoPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRequisicion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_periodo,TipoRequisicionConstantesFunciones.IDTIPOPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPeriodo);

			TipoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiporequisicions=tiporequisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoRequisicion(this.tiporequisicions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoRequisicionsFK_IdTipoPeriodo(String sFinalQuery,Pagination pagination,Long id_tipo_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_periodo,TipoRequisicionConstantesFunciones.IDTIPOPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPeriodo);

			TipoRequisicionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tiporequisicions=tiporequisicionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoRequisicionConstantesFunciones.refrescarForeignKeysDescripcionesTipoRequisicion(this.tiporequisicions);
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
			if(TipoRequisicionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoRequisicionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoRequisicion tiporequisicion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoRequisicionConstantesFunciones.ISCONAUDITORIA) {
				if(tiporequisicion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoRequisicionDataAccess.TABLENAME, tiporequisicion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoRequisicionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoRequisicionLogic.registrarAuditoriaDetallesTipoRequisicion(connexion,tiporequisicion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tiporequisicion.getIsDeleted()) {
					/*if(!tiporequisicion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoRequisicionDataAccess.TABLENAME, tiporequisicion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoRequisicionLogic.registrarAuditoriaDetallesTipoRequisicion(connexion,tiporequisicion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoRequisicionDataAccess.TABLENAME, tiporequisicion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tiporequisicion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoRequisicionDataAccess.TABLENAME, tiporequisicion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoRequisicionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoRequisicionLogic.registrarAuditoriaDetallesTipoRequisicion(connexion,tiporequisicion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoRequisicion(Connexion connexion,TipoRequisicion tiporequisicion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tiporequisicion.getIsNew()||!tiporequisicion.getid_empresa().equals(tiporequisicion.getTipoRequisicionOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiporequisicion.getTipoRequisicionOriginal().getid_empresa()!=null)
				{
					strValorActual=tiporequisicion.getTipoRequisicionOriginal().getid_empresa().toString();
				}
				if(tiporequisicion.getid_empresa()!=null)
				{
					strValorNuevo=tiporequisicion.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoRequisicionConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tiporequisicion.getIsNew()||!tiporequisicion.getcodigo().equals(tiporequisicion.getTipoRequisicionOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiporequisicion.getTipoRequisicionOriginal().getcodigo()!=null)
				{
					strValorActual=tiporequisicion.getTipoRequisicionOriginal().getcodigo();
				}
				if(tiporequisicion.getcodigo()!=null)
				{
					strValorNuevo=tiporequisicion.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoRequisicionConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tiporequisicion.getIsNew()||!tiporequisicion.getnombre().equals(tiporequisicion.getTipoRequisicionOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiporequisicion.getTipoRequisicionOriginal().getnombre()!=null)
				{
					strValorActual=tiporequisicion.getTipoRequisicionOriginal().getnombre();
				}
				if(tiporequisicion.getnombre()!=null)
				{
					strValorNuevo=tiporequisicion.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoRequisicionConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(tiporequisicion.getIsNew()||!tiporequisicion.getid_tipo_periodo().equals(tiporequisicion.getTipoRequisicionOriginal().getid_tipo_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiporequisicion.getTipoRequisicionOriginal().getid_tipo_periodo()!=null)
				{
					strValorActual=tiporequisicion.getTipoRequisicionOriginal().getid_tipo_periodo().toString();
				}
				if(tiporequisicion.getid_tipo_periodo()!=null)
				{
					strValorNuevo=tiporequisicion.getid_tipo_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoRequisicionConstantesFunciones.IDTIPOPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(tiporequisicion.getIsNew()||!tiporequisicion.getid_dia().equals(tiporequisicion.getTipoRequisicionOriginal().getid_dia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiporequisicion.getTipoRequisicionOriginal().getid_dia()!=null)
				{
					strValorActual=tiporequisicion.getTipoRequisicionOriginal().getid_dia().toString();
				}
				if(tiporequisicion.getid_dia()!=null)
				{
					strValorNuevo=tiporequisicion.getid_dia().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoRequisicionConstantesFunciones.IDDIA,strValorActual,strValorNuevo);
			}	
			
			if(tiporequisicion.getIsNew()||!tiporequisicion.gethora().equals(tiporequisicion.getTipoRequisicionOriginal().gethora()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiporequisicion.getTipoRequisicionOriginal().gethora()!=null)
				{
					strValorActual=tiporequisicion.getTipoRequisicionOriginal().gethora().toString();
				}
				if(tiporequisicion.gethora()!=null)
				{
					strValorNuevo=tiporequisicion.gethora().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoRequisicionConstantesFunciones.HORA,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoRequisicionRelacionesWithConnection(TipoRequisicion tiporequisicion) throws Exception {

		if(!tiporequisicion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoRequisicionRelacionesBase(tiporequisicion,true);
		}
	}

	public void saveTipoRequisicionRelaciones(TipoRequisicion tiporequisicion)throws Exception {

		if(!tiporequisicion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoRequisicionRelacionesBase(tiporequisicion,false);
		}
	}

	public void saveTipoRequisicionRelacionesBase(TipoRequisicion tiporequisicion,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoRequisicion-saveRelacionesWithConnection");}
	

			this.setTipoRequisicion(tiporequisicion);

			if(TipoRequisicionLogicAdditional.validarSaveRelaciones(tiporequisicion,this)) {

				TipoRequisicionLogicAdditional.updateRelacionesToSave(tiporequisicion,this);

				if((tiporequisicion.getIsNew()||tiporequisicion.getIsChanged())&&!tiporequisicion.getIsDeleted()) {
					this.saveTipoRequisicion();
					this.saveTipoRequisicionRelacionesDetalles();

				} else if(tiporequisicion.getIsDeleted()) {
					this.saveTipoRequisicionRelacionesDetalles();
					this.saveTipoRequisicion();
				}

				TipoRequisicionLogicAdditional.updateRelacionesToSaveAfter(tiporequisicion,this);

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
	
	
	private void saveTipoRequisicionRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoRequisicion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoRequisicionConstantesFunciones.getClassesForeignKeysOfTipoRequisicion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoRequisicion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoRequisicionConstantesFunciones.getClassesRelationshipsOfTipoRequisicion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

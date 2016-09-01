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
package com.bydan.erp.nomina.business.logic;

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
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.nomina.util.TipoRubroEmpleaConstantesFunciones;
import com.bydan.erp.nomina.util.TipoRubroEmpleaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoRubroEmpleaParameterGeneral;
import com.bydan.erp.nomina.business.entity.TipoRubroEmplea;
import com.bydan.erp.nomina.business.logic.TipoRubroEmpleaLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoRubroEmpleaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoRubroEmpleaLogic.class);
	
	protected TipoRubroEmpleaDataAccess tiporubroempleaDataAccess; 	
	protected TipoRubroEmplea tiporubroemplea;
	protected List<TipoRubroEmplea> tiporubroempleas;
	protected Object tiporubroempleaObject;	
	protected List<Object> tiporubroempleasObject;
	
	public static ClassValidator<TipoRubroEmplea> tiporubroempleaValidator = new ClassValidator<TipoRubroEmplea>(TipoRubroEmplea.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoRubroEmpleaLogicAdditional tiporubroempleaLogicAdditional=null;
	
	public TipoRubroEmpleaLogicAdditional getTipoRubroEmpleaLogicAdditional() {
		return this.tiporubroempleaLogicAdditional;
	}
	
	public void setTipoRubroEmpleaLogicAdditional(TipoRubroEmpleaLogicAdditional tiporubroempleaLogicAdditional) {
		try {
			this.tiporubroempleaLogicAdditional=tiporubroempleaLogicAdditional;
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
	
	
	
	
	public  TipoRubroEmpleaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tiporubroempleaDataAccess = new TipoRubroEmpleaDataAccess();
			
			this.tiporubroempleas= new ArrayList<TipoRubroEmplea>();
			this.tiporubroemplea= new TipoRubroEmplea();
			
			this.tiporubroempleaObject=new Object();
			this.tiporubroempleasObject=new ArrayList<Object>();
				
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
			
			this.tiporubroempleaDataAccess.setConnexionType(this.connexionType);
			this.tiporubroempleaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoRubroEmpleaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tiporubroempleaDataAccess = new TipoRubroEmpleaDataAccess();
			this.tiporubroempleas= new ArrayList<TipoRubroEmplea>();
			this.tiporubroemplea= new TipoRubroEmplea();
			this.tiporubroempleaObject=new Object();
			this.tiporubroempleasObject=new ArrayList<Object>();
			
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
			
			this.tiporubroempleaDataAccess.setConnexionType(this.connexionType);
			this.tiporubroempleaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoRubroEmplea getTipoRubroEmplea() throws Exception {	
		TipoRubroEmpleaLogicAdditional.checkTipoRubroEmpleaToGet(tiporubroemplea,this.datosCliente,this.arrDatoGeneral);
		TipoRubroEmpleaLogicAdditional.updateTipoRubroEmpleaToGet(tiporubroemplea,this.arrDatoGeneral);
		
		return tiporubroemplea;
	}
		
	public void setTipoRubroEmplea(TipoRubroEmplea newTipoRubroEmplea) {
		this.tiporubroemplea = newTipoRubroEmplea;
	}
	
	public TipoRubroEmpleaDataAccess getTipoRubroEmpleaDataAccess() {
		return tiporubroempleaDataAccess;
	}
	
	public void setTipoRubroEmpleaDataAccess(TipoRubroEmpleaDataAccess newtiporubroempleaDataAccess) {
		this.tiporubroempleaDataAccess = newtiporubroempleaDataAccess;
	}
	
	public List<TipoRubroEmplea> getTipoRubroEmpleas() throws Exception {		
		this.quitarTipoRubroEmpleasNulos();
		
		TipoRubroEmpleaLogicAdditional.checkTipoRubroEmpleaToGets(tiporubroempleas,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoRubroEmplea tiporubroempleaLocal: tiporubroempleas ) {
			TipoRubroEmpleaLogicAdditional.updateTipoRubroEmpleaToGet(tiporubroempleaLocal,this.arrDatoGeneral);
		}
		
		return tiporubroempleas;
	}
	
	public void setTipoRubroEmpleas(List<TipoRubroEmplea> newTipoRubroEmpleas) {
		this.tiporubroempleas = newTipoRubroEmpleas;
	}
	
	public Object getTipoRubroEmpleaObject() {	
		this.tiporubroempleaObject=this.tiporubroempleaDataAccess.getEntityObject();
		return this.tiporubroempleaObject;
	}
		
	public void setTipoRubroEmpleaObject(Object newTipoRubroEmpleaObject) {
		this.tiporubroempleaObject = newTipoRubroEmpleaObject;
	}
	
	public List<Object> getTipoRubroEmpleasObject() {		
		this.tiporubroempleasObject=this.tiporubroempleaDataAccess.getEntitiesObject();
		return this.tiporubroempleasObject;
	}
		
	public void setTipoRubroEmpleasObject(List<Object> newTipoRubroEmpleasObject) {
		this.tiporubroempleasObject = newTipoRubroEmpleasObject;
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
		
		if(this.tiporubroempleaDataAccess!=null) {
			this.tiporubroempleaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRubroEmplea.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tiporubroempleaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tiporubroempleaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tiporubroemplea = new  TipoRubroEmplea();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRubroEmplea.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tiporubroemplea=tiporubroempleaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiporubroemplea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoRubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRubroEmplea(this.tiporubroemplea);
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
		tiporubroemplea = new  TipoRubroEmplea();
		  		  
        try {
			
			tiporubroemplea=tiporubroempleaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiporubroemplea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoRubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRubroEmplea(this.tiporubroemplea);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tiporubroemplea = new  TipoRubroEmplea();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRubroEmplea.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tiporubroemplea=tiporubroempleaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiporubroemplea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoRubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRubroEmplea(this.tiporubroemplea);
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
		tiporubroemplea = new  TipoRubroEmplea();
		  		  
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
		tiporubroemplea = new  TipoRubroEmplea();
		  		  
        try {
			
			tiporubroemplea=tiporubroempleaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tiporubroemplea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoRubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRubroEmplea(this.tiporubroemplea);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tiporubroemplea = new  TipoRubroEmplea();
		  		  
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
		tiporubroemplea = new  TipoRubroEmplea();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRubroEmplea.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tiporubroempleaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiporubroemplea = new  TipoRubroEmplea();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tiporubroempleaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tiporubroemplea = new  TipoRubroEmplea();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRubroEmplea.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tiporubroempleaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiporubroemplea = new  TipoRubroEmplea();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tiporubroempleaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tiporubroemplea = new  TipoRubroEmplea();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRubroEmplea.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tiporubroempleaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tiporubroemplea = new  TipoRubroEmplea();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tiporubroempleaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tiporubroempleas = new  ArrayList<TipoRubroEmplea>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRubroEmplea.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoRubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporubroempleas=tiporubroempleaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRubroEmplea(tiporubroempleas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRubroEmplea(this.tiporubroempleas);
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
		tiporubroempleas = new  ArrayList<TipoRubroEmplea>();
		  		  
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
		tiporubroempleas = new  ArrayList<TipoRubroEmplea>();
		  		  
        try {			
			TipoRubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporubroempleas=tiporubroempleaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoRubroEmplea(tiporubroempleas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRubroEmplea(this.tiporubroempleas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tiporubroempleas = new  ArrayList<TipoRubroEmplea>();
		  		  
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
		tiporubroempleas = new  ArrayList<TipoRubroEmplea>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRubroEmplea.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoRubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporubroempleas=tiporubroempleaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRubroEmplea(tiporubroempleas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRubroEmplea(this.tiporubroempleas);
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
		tiporubroempleas = new  ArrayList<TipoRubroEmplea>();
		  		  
        try {
			TipoRubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporubroempleas=tiporubroempleaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRubroEmplea(tiporubroempleas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRubroEmplea(this.tiporubroempleas);
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
		tiporubroempleas = new  ArrayList<TipoRubroEmplea>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRubroEmplea.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporubroempleas=tiporubroempleaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoRubroEmplea(tiporubroempleas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRubroEmplea(this.tiporubroempleas);
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
		tiporubroempleas = new  ArrayList<TipoRubroEmplea>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporubroempleas=tiporubroempleaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoRubroEmplea(tiporubroempleas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRubroEmplea(this.tiporubroempleas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tiporubroemplea = new  TipoRubroEmplea();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRubroEmplea.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporubroemplea=tiporubroempleaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoRubroEmplea(tiporubroemplea);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRubroEmplea(this.tiporubroemplea);
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
		tiporubroemplea = new  TipoRubroEmplea();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporubroemplea=tiporubroempleaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoRubroEmplea(tiporubroemplea);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRubroEmplea(this.tiporubroemplea);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tiporubroempleas = new  ArrayList<TipoRubroEmplea>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRubroEmplea.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoRubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporubroempleas=tiporubroempleaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRubroEmplea(tiporubroempleas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRubroEmplea(this.tiporubroempleas);
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
		tiporubroempleas = new  ArrayList<TipoRubroEmplea>();
		  		  
        try {
			TipoRubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporubroempleas=tiporubroempleaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoRubroEmplea(tiporubroempleas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRubroEmplea(this.tiporubroempleas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoRubroEmpleasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tiporubroempleas = new  ArrayList<TipoRubroEmplea>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRubroEmplea.class.getSimpleName()+"-getTodosTipoRubroEmpleasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporubroempleas=tiporubroempleaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoRubroEmplea(tiporubroempleas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRubroEmplea(this.tiporubroempleas);
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
	
	public  void  getTodosTipoRubroEmpleas(String sFinalQuery,Pagination pagination)throws Exception {
		tiporubroempleas = new  ArrayList<TipoRubroEmplea>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoRubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tiporubroempleas=tiporubroempleaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoRubroEmplea(tiporubroempleas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoRubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRubroEmplea(this.tiporubroempleas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoRubroEmplea(TipoRubroEmplea tiporubroemplea) throws Exception {
		Boolean estaValidado=false;
		
		if(tiporubroemplea.getIsNew() || tiporubroemplea.getIsChanged()) { 
			this.invalidValues = tiporubroempleaValidator.getInvalidValues(tiporubroemplea);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tiporubroemplea);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoRubroEmplea(List<TipoRubroEmplea> TipoRubroEmpleas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoRubroEmplea tiporubroempleaLocal:tiporubroempleas) {				
			estaValidadoObjeto=this.validarGuardarTipoRubroEmplea(tiporubroempleaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoRubroEmplea(List<TipoRubroEmplea> TipoRubroEmpleas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoRubroEmplea(tiporubroempleas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoRubroEmplea(TipoRubroEmplea TipoRubroEmplea) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoRubroEmplea(tiporubroemplea)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoRubroEmplea tiporubroemplea) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tiporubroemplea.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoRubroEmpleaConstantesFunciones.getTipoRubroEmpleaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tiporubroemplea","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoRubroEmpleaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoRubroEmpleaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoRubroEmpleaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRubroEmplea.class.getSimpleName()+"-saveTipoRubroEmpleaWithConnection");connexion.begin();			
			
			TipoRubroEmpleaLogicAdditional.checkTipoRubroEmpleaToSave(this.tiporubroemplea,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoRubroEmpleaLogicAdditional.updateTipoRubroEmpleaToSave(this.tiporubroemplea,this.arrDatoGeneral);
			
			TipoRubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tiporubroemplea,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoRubroEmplea();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoRubroEmplea(this.tiporubroemplea)) {
				TipoRubroEmpleaDataAccess.save(this.tiporubroemplea, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tiporubroemplea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoRubroEmpleaLogicAdditional.checkTipoRubroEmpleaToSaveAfter(this.tiporubroemplea,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoRubroEmplea();
			
			connexion.commit();			
			
			if(this.tiporubroemplea.getIsDeleted()) {
				this.tiporubroemplea=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoRubroEmplea()throws Exception {	
		try {	
			
			TipoRubroEmpleaLogicAdditional.checkTipoRubroEmpleaToSave(this.tiporubroemplea,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoRubroEmpleaLogicAdditional.updateTipoRubroEmpleaToSave(this.tiporubroemplea,this.arrDatoGeneral);
			
			TipoRubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tiporubroemplea,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoRubroEmplea(this.tiporubroemplea)) {			
				TipoRubroEmpleaDataAccess.save(this.tiporubroemplea, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tiporubroemplea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoRubroEmpleaLogicAdditional.checkTipoRubroEmpleaToSaveAfter(this.tiporubroemplea,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tiporubroemplea.getIsDeleted()) {
				this.tiporubroemplea=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoRubroEmpleasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRubroEmplea.class.getSimpleName()+"-saveTipoRubroEmpleasWithConnection");connexion.begin();			
			
			TipoRubroEmpleaLogicAdditional.checkTipoRubroEmpleaToSaves(tiporubroempleas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoRubroEmpleas();
			
			Boolean validadoTodosTipoRubroEmplea=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoRubroEmplea tiporubroempleaLocal:tiporubroempleas) {		
				if(tiporubroempleaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoRubroEmpleaLogicAdditional.updateTipoRubroEmpleaToSave(tiporubroempleaLocal,this.arrDatoGeneral);
	        	
				TipoRubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tiporubroempleaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoRubroEmplea(tiporubroempleaLocal)) {
					TipoRubroEmpleaDataAccess.save(tiporubroempleaLocal, connexion);				
				} else {
					validadoTodosTipoRubroEmplea=false;
				}
			}
			
			if(!validadoTodosTipoRubroEmplea) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoRubroEmpleaLogicAdditional.checkTipoRubroEmpleaToSavesAfter(tiporubroempleas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoRubroEmpleas();
			
			connexion.commit();		
			
			this.quitarTipoRubroEmpleasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoRubroEmpleas()throws Exception {				
		 try {	
			TipoRubroEmpleaLogicAdditional.checkTipoRubroEmpleaToSaves(tiporubroempleas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoRubroEmplea=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoRubroEmplea tiporubroempleaLocal:tiporubroempleas) {				
				if(tiporubroempleaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoRubroEmpleaLogicAdditional.updateTipoRubroEmpleaToSave(tiporubroempleaLocal,this.arrDatoGeneral);
	        	
				TipoRubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tiporubroempleaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoRubroEmplea(tiporubroempleaLocal)) {				
					TipoRubroEmpleaDataAccess.save(tiporubroempleaLocal, connexion);				
				} else {
					validadoTodosTipoRubroEmplea=false;
				}
			}
			
			if(!validadoTodosTipoRubroEmplea) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoRubroEmpleaLogicAdditional.checkTipoRubroEmpleaToSavesAfter(tiporubroempleas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoRubroEmpleasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoRubroEmpleaParameterReturnGeneral procesarAccionTipoRubroEmpleas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoRubroEmplea> tiporubroempleas,TipoRubroEmpleaParameterReturnGeneral tiporubroempleaParameterGeneral)throws Exception {
		 try {	
			TipoRubroEmpleaParameterReturnGeneral tiporubroempleaReturnGeneral=new TipoRubroEmpleaParameterReturnGeneral();
	
			TipoRubroEmpleaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tiporubroempleas,tiporubroempleaParameterGeneral,tiporubroempleaReturnGeneral);
			
			return tiporubroempleaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoRubroEmpleaParameterReturnGeneral procesarAccionTipoRubroEmpleasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoRubroEmplea> tiporubroempleas,TipoRubroEmpleaParameterReturnGeneral tiporubroempleaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRubroEmplea.class.getSimpleName()+"-procesarAccionTipoRubroEmpleasWithConnection");connexion.begin();			
			
			TipoRubroEmpleaParameterReturnGeneral tiporubroempleaReturnGeneral=new TipoRubroEmpleaParameterReturnGeneral();
	
			TipoRubroEmpleaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tiporubroempleas,tiporubroempleaParameterGeneral,tiporubroempleaReturnGeneral);
			
			this.connexion.commit();
			
			return tiporubroempleaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoRubroEmpleaParameterReturnGeneral procesarEventosTipoRubroEmpleas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoRubroEmplea> tiporubroempleas,TipoRubroEmplea tiporubroemplea,TipoRubroEmpleaParameterReturnGeneral tiporubroempleaParameterGeneral,Boolean isEsNuevoTipoRubroEmplea,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoRubroEmpleaParameterReturnGeneral tiporubroempleaReturnGeneral=new TipoRubroEmpleaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tiporubroempleaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoRubroEmpleaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tiporubroempleas,tiporubroemplea,tiporubroempleaParameterGeneral,tiporubroempleaReturnGeneral,isEsNuevoTipoRubroEmplea,clases);
			
			return tiporubroempleaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoRubroEmpleaParameterReturnGeneral procesarEventosTipoRubroEmpleasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoRubroEmplea> tiporubroempleas,TipoRubroEmplea tiporubroemplea,TipoRubroEmpleaParameterReturnGeneral tiporubroempleaParameterGeneral,Boolean isEsNuevoTipoRubroEmplea,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRubroEmplea.class.getSimpleName()+"-procesarEventosTipoRubroEmpleasWithConnection");connexion.begin();			
			
			TipoRubroEmpleaParameterReturnGeneral tiporubroempleaReturnGeneral=new TipoRubroEmpleaParameterReturnGeneral();
	
			tiporubroempleaReturnGeneral.setTipoRubroEmplea(tiporubroemplea);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tiporubroempleaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoRubroEmpleaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tiporubroempleas,tiporubroemplea,tiporubroempleaParameterGeneral,tiporubroempleaReturnGeneral,isEsNuevoTipoRubroEmplea,clases);
			
			this.connexion.commit();
			
			return tiporubroempleaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoRubroEmpleaParameterReturnGeneral procesarImportacionTipoRubroEmpleasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoRubroEmpleaParameterReturnGeneral tiporubroempleaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRubroEmplea.class.getSimpleName()+"-procesarImportacionTipoRubroEmpleasWithConnection");connexion.begin();			
			
			TipoRubroEmpleaParameterReturnGeneral tiporubroempleaReturnGeneral=new TipoRubroEmpleaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tiporubroempleas=new ArrayList<TipoRubroEmplea>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tiporubroemplea=new TipoRubroEmplea();
				
				
				if(conColumnasBase) {this.tiporubroemplea.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tiporubroemplea.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tiporubroemplea.setcodigo(arrColumnas[iColumn++]);
				this.tiporubroemplea.setnombre(arrColumnas[iColumn++]);
				
				this.tiporubroempleas.add(this.tiporubroemplea);
			}
			
			this.saveTipoRubroEmpleas();
			
			this.connexion.commit();
			
			tiporubroempleaReturnGeneral.setConRetornoEstaProcesado(true);
			tiporubroempleaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tiporubroempleaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoRubroEmpleasEliminados() throws Exception {				
		
		List<TipoRubroEmplea> tiporubroempleasAux= new ArrayList<TipoRubroEmplea>();
		
		for(TipoRubroEmplea tiporubroemplea:tiporubroempleas) {
			if(!tiporubroemplea.getIsDeleted()) {
				tiporubroempleasAux.add(tiporubroemplea);
			}
		}
		
		tiporubroempleas=tiporubroempleasAux;
	}
	
	public void quitarTipoRubroEmpleasNulos() throws Exception {				
		
		List<TipoRubroEmplea> tiporubroempleasAux= new ArrayList<TipoRubroEmplea>();
		
		for(TipoRubroEmplea tiporubroemplea : this.tiporubroempleas) {
			if(tiporubroemplea==null) {
				tiporubroempleasAux.add(tiporubroemplea);
			}
		}
		
		//this.tiporubroempleas=tiporubroempleasAux;
		
		this.tiporubroempleas.removeAll(tiporubroempleasAux);
	}
	
	public void getSetVersionRowTipoRubroEmpleaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tiporubroemplea.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tiporubroemplea.getIsDeleted() || (tiporubroemplea.getIsChanged()&&!tiporubroemplea.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tiporubroempleaDataAccess.getSetVersionRowTipoRubroEmplea(connexion,tiporubroemplea.getId());
				
				if(!tiporubroemplea.getVersionRow().equals(timestamp)) {	
					tiporubroemplea.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tiporubroemplea.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoRubroEmplea()throws Exception {	
		
		if(tiporubroemplea.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tiporubroemplea.getIsDeleted() || (tiporubroemplea.getIsChanged()&&!tiporubroemplea.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tiporubroempleaDataAccess.getSetVersionRowTipoRubroEmplea(connexion,tiporubroemplea.getId());
			
			try {							
				if(!tiporubroemplea.getVersionRow().equals(timestamp)) {	
					tiporubroemplea.setVersionRow(timestamp);
				}
				
				tiporubroemplea.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoRubroEmpleasWithConnection()throws Exception {	
		if(tiporubroempleas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoRubroEmplea tiporubroempleaAux:tiporubroempleas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tiporubroempleaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tiporubroempleaAux.getIsDeleted() || (tiporubroempleaAux.getIsChanged()&&!tiporubroempleaAux.getIsNew())) {
						
						timestamp=tiporubroempleaDataAccess.getSetVersionRowTipoRubroEmplea(connexion,tiporubroempleaAux.getId());
						
						if(!tiporubroemplea.getVersionRow().equals(timestamp)) {	
							tiporubroempleaAux.setVersionRow(timestamp);
						}
								
						tiporubroempleaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoRubroEmpleas()throws Exception {	
		if(tiporubroempleas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoRubroEmplea tiporubroempleaAux:tiporubroempleas) {
					if(tiporubroempleaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tiporubroempleaAux.getIsDeleted() || (tiporubroempleaAux.getIsChanged()&&!tiporubroempleaAux.getIsNew())) {
						
						timestamp=tiporubroempleaDataAccess.getSetVersionRowTipoRubroEmplea(connexion,tiporubroempleaAux.getId());
						
						if(!tiporubroempleaAux.getVersionRow().equals(timestamp)) {	
							tiporubroempleaAux.setVersionRow(timestamp);
						}
						
													
						tiporubroempleaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyTipoRubroEmpleaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			RubroEmpleaLogic rubroempleaLogic=new RubroEmpleaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoRubroEmplea.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoRubroEmpleaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(RubroEmplea.class));
											
			

			rubroempleaLogic.setConnexion(this.getConnexion());
			rubroempleaLogic.setDatosCliente(this.datosCliente);
			rubroempleaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoRubroEmplea tiporubroemplea:this.tiporubroempleas) {
				

				classes=new ArrayList<Classe>();
				classes=RubroEmpleaConstantesFunciones.getClassesForeignKeysOfRubroEmplea(new ArrayList<Classe>(),DeepLoadType.NONE);

				rubroempleaLogic.setRubroEmpleas(tiporubroemplea.rubroempleas);
				rubroempleaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoRubroEmplea tiporubroemplea,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoRubroEmpleaLogicAdditional.updateTipoRubroEmpleaToGet(tiporubroemplea,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tiporubroemplea.setRubroEmpleas(tiporubroempleaDataAccess.getRubroEmpleas(connexion,tiporubroemplea));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(RubroEmplea.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tiporubroemplea.setRubroEmpleas(tiporubroempleaDataAccess.getRubroEmpleas(connexion,tiporubroemplea));

				if(this.isConDeep) {
					RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(this.connexion);
					rubroempleaLogic.setRubroEmpleas(tiporubroemplea.getRubroEmpleas());
					ArrayList<Classe> classesLocal=RubroEmpleaConstantesFunciones.getClassesForeignKeysOfRubroEmplea(new ArrayList<Classe>(),DeepLoadType.NONE);
					rubroempleaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					RubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmplea(rubroempleaLogic.getRubroEmpleas());
					tiporubroemplea.setRubroEmpleas(rubroempleaLogic.getRubroEmpleas());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RubroEmplea.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(RubroEmplea.class));
			tiporubroemplea.setRubroEmpleas(tiporubroempleaDataAccess.getRubroEmpleas(connexion,tiporubroemplea));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		tiporubroemplea.setRubroEmpleas(tiporubroempleaDataAccess.getRubroEmpleas(connexion,tiporubroemplea));

		for(RubroEmplea rubroemplea:tiporubroemplea.getRubroEmpleas()) {
			RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
			rubroempleaLogic.deepLoad(rubroemplea,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(RubroEmplea.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tiporubroemplea.setRubroEmpleas(tiporubroempleaDataAccess.getRubroEmpleas(connexion,tiporubroemplea));

				for(RubroEmplea rubroemplea:tiporubroemplea.getRubroEmpleas()) {
					RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
					rubroempleaLogic.deepLoad(rubroemplea,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RubroEmplea.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(RubroEmplea.class));
			tiporubroemplea.setRubroEmpleas(tiporubroempleaDataAccess.getRubroEmpleas(connexion,tiporubroemplea));

			for(RubroEmplea rubroemplea:tiporubroemplea.getRubroEmpleas()) {
				RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
				rubroempleaLogic.deepLoad(rubroemplea,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoRubroEmplea tiporubroemplea,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoRubroEmpleaLogicAdditional.updateTipoRubroEmpleaToSave(tiporubroemplea,this.arrDatoGeneral);
			
TipoRubroEmpleaDataAccess.save(tiporubroemplea, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(RubroEmplea rubroemplea:tiporubroemplea.getRubroEmpleas()) {
			rubroemplea.setid_tipo_rubro_emplea(tiporubroemplea.getId());
			RubroEmpleaDataAccess.save(rubroemplea,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(RubroEmplea.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(RubroEmplea rubroemplea:tiporubroemplea.getRubroEmpleas()) {
					rubroemplea.setid_tipo_rubro_emplea(tiporubroemplea.getId());
					RubroEmpleaDataAccess.save(rubroemplea,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(RubroEmplea rubroemplea:tiporubroemplea.getRubroEmpleas()) {
			RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
			rubroemplea.setid_tipo_rubro_emplea(tiporubroemplea.getId());
			RubroEmpleaDataAccess.save(rubroemplea,connexion);
			rubroempleaLogic.deepSave(rubroemplea,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(RubroEmplea.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(RubroEmplea rubroemplea:tiporubroemplea.getRubroEmpleas()) {
					RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
					rubroemplea.setid_tipo_rubro_emplea(tiporubroemplea.getId());
					RubroEmpleaDataAccess.save(rubroemplea,connexion);
					rubroempleaLogic.deepSave(rubroemplea,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoRubroEmplea.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tiporubroemplea,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoRubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRubroEmplea(tiporubroemplea);
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
			this.deepLoad(this.tiporubroemplea,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoRubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRubroEmplea(this.tiporubroemplea);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoRubroEmplea.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tiporubroempleas!=null) {
				for(TipoRubroEmplea tiporubroemplea:tiporubroempleas) {
					this.deepLoad(tiporubroemplea,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoRubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRubroEmplea(tiporubroempleas);
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
			if(tiporubroempleas!=null) {
				for(TipoRubroEmplea tiporubroemplea:tiporubroempleas) {
					this.deepLoad(tiporubroemplea,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoRubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesTipoRubroEmplea(tiporubroempleas);
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
			this.getNewConnexionToDeep(TipoRubroEmplea.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tiporubroemplea,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoRubroEmplea.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tiporubroempleas!=null) {
				for(TipoRubroEmplea tiporubroemplea:tiporubroempleas) {
					this.deepSave(tiporubroemplea,isDeep,deepLoadType,clases);
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
			if(tiporubroempleas!=null) {
				for(TipoRubroEmplea tiporubroemplea:tiporubroempleas) {
					this.deepSave(tiporubroemplea,isDeep,deepLoadType,clases);
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
			if(TipoRubroEmpleaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoRubroEmpleaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoRubroEmplea tiporubroemplea,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoRubroEmpleaConstantesFunciones.ISCONAUDITORIA) {
				if(tiporubroemplea.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoRubroEmpleaDataAccess.TABLENAME, tiporubroemplea.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoRubroEmpleaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoRubroEmpleaLogic.registrarAuditoriaDetallesTipoRubroEmplea(connexion,tiporubroemplea,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tiporubroemplea.getIsDeleted()) {
					/*if(!tiporubroemplea.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoRubroEmpleaDataAccess.TABLENAME, tiporubroemplea.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoRubroEmpleaLogic.registrarAuditoriaDetallesTipoRubroEmplea(connexion,tiporubroemplea,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoRubroEmpleaDataAccess.TABLENAME, tiporubroemplea.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tiporubroemplea.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoRubroEmpleaDataAccess.TABLENAME, tiporubroemplea.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoRubroEmpleaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoRubroEmpleaLogic.registrarAuditoriaDetallesTipoRubroEmplea(connexion,tiporubroemplea,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoRubroEmplea(Connexion connexion,TipoRubroEmplea tiporubroemplea)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tiporubroemplea.getIsNew()||!tiporubroemplea.getcodigo().equals(tiporubroemplea.getTipoRubroEmpleaOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiporubroemplea.getTipoRubroEmpleaOriginal().getcodigo()!=null)
				{
					strValorActual=tiporubroemplea.getTipoRubroEmpleaOriginal().getcodigo();
				}
				if(tiporubroemplea.getcodigo()!=null)
				{
					strValorNuevo=tiporubroemplea.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoRubroEmpleaConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tiporubroemplea.getIsNew()||!tiporubroemplea.getnombre().equals(tiporubroemplea.getTipoRubroEmpleaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tiporubroemplea.getTipoRubroEmpleaOriginal().getnombre()!=null)
				{
					strValorActual=tiporubroemplea.getTipoRubroEmpleaOriginal().getnombre();
				}
				if(tiporubroemplea.getnombre()!=null)
				{
					strValorNuevo=tiporubroemplea.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoRubroEmpleaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoRubroEmpleaRelacionesWithConnection(TipoRubroEmplea tiporubroemplea,List<RubroEmplea> rubroempleas) throws Exception {

		if(!tiporubroemplea.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoRubroEmpleaRelacionesBase(tiporubroemplea,rubroempleas,true);
		}
	}

	public void saveTipoRubroEmpleaRelaciones(TipoRubroEmplea tiporubroemplea,List<RubroEmplea> rubroempleas)throws Exception {

		if(!tiporubroemplea.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoRubroEmpleaRelacionesBase(tiporubroemplea,rubroempleas,false);
		}
	}

	public void saveTipoRubroEmpleaRelacionesBase(TipoRubroEmplea tiporubroemplea,List<RubroEmplea> rubroempleas,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoRubroEmplea-saveRelacionesWithConnection");}
	
			tiporubroemplea.setRubroEmpleas(rubroempleas);

			this.setTipoRubroEmplea(tiporubroemplea);

				if((tiporubroemplea.getIsNew()||tiporubroemplea.getIsChanged())&&!tiporubroemplea.getIsDeleted()) {
					this.saveTipoRubroEmplea();
					this.saveTipoRubroEmpleaRelacionesDetalles(rubroempleas);

				} else if(tiporubroemplea.getIsDeleted()) {
					this.saveTipoRubroEmpleaRelacionesDetalles(rubroempleas);
					this.saveTipoRubroEmplea();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			RubroEmpleaConstantesFunciones.InicializarGeneralEntityAuxiliaresRubroEmpleas(rubroempleas,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoRubroEmpleaRelacionesDetalles(List<RubroEmplea> rubroempleas)throws Exception {
		try {
	

			Long idTipoRubroEmpleaActual=this.getTipoRubroEmplea().getId();

			RubroEmpleaLogic rubroempleaLogic_Desde_TipoRubroEmplea=new RubroEmpleaLogic();
			rubroempleaLogic_Desde_TipoRubroEmplea.setRubroEmpleas(rubroempleas);

			rubroempleaLogic_Desde_TipoRubroEmplea.setConnexion(this.getConnexion());
			rubroempleaLogic_Desde_TipoRubroEmplea.setDatosCliente(this.datosCliente);

			for(RubroEmplea rubroemplea_Desde_TipoRubroEmplea:rubroempleaLogic_Desde_TipoRubroEmplea.getRubroEmpleas()) {
				rubroemplea_Desde_TipoRubroEmplea.setid_tipo_rubro_emplea(idTipoRubroEmpleaActual);

				rubroempleaLogic_Desde_TipoRubroEmplea.setRubroEmplea(rubroemplea_Desde_TipoRubroEmplea);
				rubroempleaLogic_Desde_TipoRubroEmplea.saveRubroEmplea();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoRubroEmplea(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoRubroEmpleaConstantesFunciones.getClassesForeignKeysOfTipoRubroEmplea(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoRubroEmplea(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoRubroEmpleaConstantesFunciones.getClassesRelationshipsOfTipoRubroEmplea(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

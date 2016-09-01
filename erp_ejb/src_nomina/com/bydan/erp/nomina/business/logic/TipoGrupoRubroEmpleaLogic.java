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
import com.bydan.erp.nomina.util.TipoGrupoRubroEmpleaConstantesFunciones;
import com.bydan.erp.nomina.util.TipoGrupoRubroEmpleaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoGrupoRubroEmpleaParameterGeneral;
import com.bydan.erp.nomina.business.entity.TipoGrupoRubroEmplea;
//import com.bydan.erp.nomina.business.logic.TipoGrupoRubroEmpleaLogicAdditional;
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
public class TipoGrupoRubroEmpleaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoGrupoRubroEmpleaLogic.class);
	
	protected TipoGrupoRubroEmpleaDataAccess tipogruporubroempleaDataAccess; 	
	protected TipoGrupoRubroEmplea tipogruporubroemplea;
	protected List<TipoGrupoRubroEmplea> tipogruporubroempleas;
	protected Object tipogruporubroempleaObject;	
	protected List<Object> tipogruporubroempleasObject;
	
	public static ClassValidator<TipoGrupoRubroEmplea> tipogruporubroempleaValidator = new ClassValidator<TipoGrupoRubroEmplea>(TipoGrupoRubroEmplea.class);	
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
	
	
	
	
	public  TipoGrupoRubroEmpleaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipogruporubroempleaDataAccess = new TipoGrupoRubroEmpleaDataAccess();
			
			this.tipogruporubroempleas= new ArrayList<TipoGrupoRubroEmplea>();
			this.tipogruporubroemplea= new TipoGrupoRubroEmplea();
			
			this.tipogruporubroempleaObject=new Object();
			this.tipogruporubroempleasObject=new ArrayList<Object>();
				
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
			
			this.tipogruporubroempleaDataAccess.setConnexionType(this.connexionType);
			this.tipogruporubroempleaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoGrupoRubroEmpleaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipogruporubroempleaDataAccess = new TipoGrupoRubroEmpleaDataAccess();
			this.tipogruporubroempleas= new ArrayList<TipoGrupoRubroEmplea>();
			this.tipogruporubroemplea= new TipoGrupoRubroEmplea();
			this.tipogruporubroempleaObject=new Object();
			this.tipogruporubroempleasObject=new ArrayList<Object>();
			
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
			
			this.tipogruporubroempleaDataAccess.setConnexionType(this.connexionType);
			this.tipogruporubroempleaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoGrupoRubroEmplea getTipoGrupoRubroEmplea() throws Exception {	
		//TipoGrupoRubroEmpleaLogicAdditional.checkTipoGrupoRubroEmpleaToGet(tipogruporubroemplea,this.datosCliente,this.arrDatoGeneral);
		//TipoGrupoRubroEmpleaLogicAdditional.updateTipoGrupoRubroEmpleaToGet(tipogruporubroemplea,this.arrDatoGeneral);
		
		return tipogruporubroemplea;
	}
		
	public void setTipoGrupoRubroEmplea(TipoGrupoRubroEmplea newTipoGrupoRubroEmplea) {
		this.tipogruporubroemplea = newTipoGrupoRubroEmplea;
	}
	
	public TipoGrupoRubroEmpleaDataAccess getTipoGrupoRubroEmpleaDataAccess() {
		return tipogruporubroempleaDataAccess;
	}
	
	public void setTipoGrupoRubroEmpleaDataAccess(TipoGrupoRubroEmpleaDataAccess newtipogruporubroempleaDataAccess) {
		this.tipogruporubroempleaDataAccess = newtipogruporubroempleaDataAccess;
	}
	
	public List<TipoGrupoRubroEmplea> getTipoGrupoRubroEmpleas() throws Exception {		
		this.quitarTipoGrupoRubroEmpleasNulos();
		
		//TipoGrupoRubroEmpleaLogicAdditional.checkTipoGrupoRubroEmpleaToGets(tipogruporubroempleas,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoGrupoRubroEmplea tipogruporubroempleaLocal: tipogruporubroempleas ) {
			//TipoGrupoRubroEmpleaLogicAdditional.updateTipoGrupoRubroEmpleaToGet(tipogruporubroempleaLocal,this.arrDatoGeneral);
		}
		
		return tipogruporubroempleas;
	}
	
	public void setTipoGrupoRubroEmpleas(List<TipoGrupoRubroEmplea> newTipoGrupoRubroEmpleas) {
		this.tipogruporubroempleas = newTipoGrupoRubroEmpleas;
	}
	
	public Object getTipoGrupoRubroEmpleaObject() {	
		this.tipogruporubroempleaObject=this.tipogruporubroempleaDataAccess.getEntityObject();
		return this.tipogruporubroempleaObject;
	}
		
	public void setTipoGrupoRubroEmpleaObject(Object newTipoGrupoRubroEmpleaObject) {
		this.tipogruporubroempleaObject = newTipoGrupoRubroEmpleaObject;
	}
	
	public List<Object> getTipoGrupoRubroEmpleasObject() {		
		this.tipogruporubroempleasObject=this.tipogruporubroempleaDataAccess.getEntitiesObject();
		return this.tipogruporubroempleasObject;
	}
		
	public void setTipoGrupoRubroEmpleasObject(List<Object> newTipoGrupoRubroEmpleasObject) {
		this.tipogruporubroempleasObject = newTipoGrupoRubroEmpleasObject;
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
		
		if(this.tipogruporubroempleaDataAccess!=null) {
			this.tipogruporubroempleaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoRubroEmplea.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipogruporubroempleaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipogruporubroempleaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipogruporubroemplea = new  TipoGrupoRubroEmplea();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoRubroEmplea.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipogruporubroemplea=tipogruporubroempleaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipogruporubroemplea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoGrupoRubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoRubroEmplea(this.tipogruporubroemplea);
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
		tipogruporubroemplea = new  TipoGrupoRubroEmplea();
		  		  
        try {
			
			tipogruporubroemplea=tipogruporubroempleaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipogruporubroemplea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoGrupoRubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoRubroEmplea(this.tipogruporubroemplea);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipogruporubroemplea = new  TipoGrupoRubroEmplea();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoRubroEmplea.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipogruporubroemplea=tipogruporubroempleaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipogruporubroemplea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoGrupoRubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoRubroEmplea(this.tipogruporubroemplea);
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
		tipogruporubroemplea = new  TipoGrupoRubroEmplea();
		  		  
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
		tipogruporubroemplea = new  TipoGrupoRubroEmplea();
		  		  
        try {
			
			tipogruporubroemplea=tipogruporubroempleaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipogruporubroemplea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoGrupoRubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoRubroEmplea(this.tipogruporubroemplea);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipogruporubroemplea = new  TipoGrupoRubroEmplea();
		  		  
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
		tipogruporubroemplea = new  TipoGrupoRubroEmplea();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoRubroEmplea.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipogruporubroempleaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipogruporubroemplea = new  TipoGrupoRubroEmplea();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipogruporubroempleaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipogruporubroemplea = new  TipoGrupoRubroEmplea();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoRubroEmplea.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipogruporubroempleaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipogruporubroemplea = new  TipoGrupoRubroEmplea();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipogruporubroempleaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipogruporubroemplea = new  TipoGrupoRubroEmplea();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoRubroEmplea.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipogruporubroempleaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipogruporubroemplea = new  TipoGrupoRubroEmplea();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipogruporubroempleaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipogruporubroempleas = new  ArrayList<TipoGrupoRubroEmplea>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoRubroEmplea.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoGrupoRubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogruporubroempleas=tipogruporubroempleaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoGrupoRubroEmplea(tipogruporubroempleas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoRubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoRubroEmplea(this.tipogruporubroempleas);
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
		tipogruporubroempleas = new  ArrayList<TipoGrupoRubroEmplea>();
		  		  
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
		tipogruporubroempleas = new  ArrayList<TipoGrupoRubroEmplea>();
		  		  
        try {			
			TipoGrupoRubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogruporubroempleas=tipogruporubroempleaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoGrupoRubroEmplea(tipogruporubroempleas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoRubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoRubroEmplea(this.tipogruporubroempleas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipogruporubroempleas = new  ArrayList<TipoGrupoRubroEmplea>();
		  		  
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
		tipogruporubroempleas = new  ArrayList<TipoGrupoRubroEmplea>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoRubroEmplea.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoGrupoRubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogruporubroempleas=tipogruporubroempleaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoGrupoRubroEmplea(tipogruporubroempleas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoRubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoRubroEmplea(this.tipogruporubroempleas);
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
		tipogruporubroempleas = new  ArrayList<TipoGrupoRubroEmplea>();
		  		  
        try {
			TipoGrupoRubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogruporubroempleas=tipogruporubroempleaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoGrupoRubroEmplea(tipogruporubroempleas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoRubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoRubroEmplea(this.tipogruporubroempleas);
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
		tipogruporubroempleas = new  ArrayList<TipoGrupoRubroEmplea>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoRubroEmplea.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGrupoRubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogruporubroempleas=tipogruporubroempleaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoGrupoRubroEmplea(tipogruporubroempleas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoRubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoRubroEmplea(this.tipogruporubroempleas);
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
		tipogruporubroempleas = new  ArrayList<TipoGrupoRubroEmplea>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGrupoRubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogruporubroempleas=tipogruporubroempleaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoGrupoRubroEmplea(tipogruporubroempleas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoRubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoRubroEmplea(this.tipogruporubroempleas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipogruporubroemplea = new  TipoGrupoRubroEmplea();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoRubroEmplea.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGrupoRubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogruporubroemplea=tipogruporubroempleaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoGrupoRubroEmplea(tipogruporubroemplea);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoRubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoRubroEmplea(this.tipogruporubroemplea);
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
		tipogruporubroemplea = new  TipoGrupoRubroEmplea();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGrupoRubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogruporubroemplea=tipogruporubroempleaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoGrupoRubroEmplea(tipogruporubroemplea);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoRubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoRubroEmplea(this.tipogruporubroemplea);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoGrupoRubroEmpleasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipogruporubroempleas = new  ArrayList<TipoGrupoRubroEmplea>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoRubroEmplea.class.getSimpleName()+"-getTodosTipoGrupoRubroEmpleasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGrupoRubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogruporubroempleas=tipogruporubroempleaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoGrupoRubroEmplea(tipogruporubroempleas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoRubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoRubroEmplea(this.tipogruporubroempleas);
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
	
	public  void  getTodosTipoGrupoRubroEmpleas(String sFinalQuery,Pagination pagination)throws Exception {
		tipogruporubroempleas = new  ArrayList<TipoGrupoRubroEmplea>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGrupoRubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogruporubroempleas=tipogruporubroempleaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoGrupoRubroEmplea(tipogruporubroempleas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoRubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoRubroEmplea(this.tipogruporubroempleas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoGrupoRubroEmplea(TipoGrupoRubroEmplea tipogruporubroemplea) throws Exception {
		Boolean estaValidado=false;
		
		if(tipogruporubroemplea.getIsNew() || tipogruporubroemplea.getIsChanged()) { 
			this.invalidValues = tipogruporubroempleaValidator.getInvalidValues(tipogruporubroemplea);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipogruporubroemplea);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoGrupoRubroEmplea(List<TipoGrupoRubroEmplea> TipoGrupoRubroEmpleas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoGrupoRubroEmplea tipogruporubroempleaLocal:tipogruporubroempleas) {				
			estaValidadoObjeto=this.validarGuardarTipoGrupoRubroEmplea(tipogruporubroempleaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoGrupoRubroEmplea(List<TipoGrupoRubroEmplea> TipoGrupoRubroEmpleas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoGrupoRubroEmplea(tipogruporubroempleas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoGrupoRubroEmplea(TipoGrupoRubroEmplea TipoGrupoRubroEmplea) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoGrupoRubroEmplea(tipogruporubroemplea)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoGrupoRubroEmplea tipogruporubroemplea) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipogruporubroemplea.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoGrupoRubroEmpleaConstantesFunciones.getTipoGrupoRubroEmpleaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipogruporubroemplea","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoGrupoRubroEmpleaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoGrupoRubroEmpleaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoGrupoRubroEmpleaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoRubroEmplea.class.getSimpleName()+"-saveTipoGrupoRubroEmpleaWithConnection");connexion.begin();			
			
			//TipoGrupoRubroEmpleaLogicAdditional.checkTipoGrupoRubroEmpleaToSave(this.tipogruporubroemplea,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoGrupoRubroEmpleaLogicAdditional.updateTipoGrupoRubroEmpleaToSave(this.tipogruporubroemplea,this.arrDatoGeneral);
			
			TipoGrupoRubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipogruporubroemplea,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoGrupoRubroEmplea();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoGrupoRubroEmplea(this.tipogruporubroemplea)) {
				TipoGrupoRubroEmpleaDataAccess.save(this.tipogruporubroemplea, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipogruporubroemplea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoGrupoRubroEmpleaLogicAdditional.checkTipoGrupoRubroEmpleaToSaveAfter(this.tipogruporubroemplea,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoGrupoRubroEmplea();
			
			connexion.commit();			
			
			if(this.tipogruporubroemplea.getIsDeleted()) {
				this.tipogruporubroemplea=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoGrupoRubroEmplea()throws Exception {	
		try {	
			
			//TipoGrupoRubroEmpleaLogicAdditional.checkTipoGrupoRubroEmpleaToSave(this.tipogruporubroemplea,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoGrupoRubroEmpleaLogicAdditional.updateTipoGrupoRubroEmpleaToSave(this.tipogruporubroemplea,this.arrDatoGeneral);
			
			TipoGrupoRubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipogruporubroemplea,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoGrupoRubroEmplea(this.tipogruporubroemplea)) {			
				TipoGrupoRubroEmpleaDataAccess.save(this.tipogruporubroemplea, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipogruporubroemplea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoGrupoRubroEmpleaLogicAdditional.checkTipoGrupoRubroEmpleaToSaveAfter(this.tipogruporubroemplea,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipogruporubroemplea.getIsDeleted()) {
				this.tipogruporubroemplea=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoGrupoRubroEmpleasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoRubroEmplea.class.getSimpleName()+"-saveTipoGrupoRubroEmpleasWithConnection");connexion.begin();			
			
			//TipoGrupoRubroEmpleaLogicAdditional.checkTipoGrupoRubroEmpleaToSaves(tipogruporubroempleas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoGrupoRubroEmpleas();
			
			Boolean validadoTodosTipoGrupoRubroEmplea=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoGrupoRubroEmplea tipogruporubroempleaLocal:tipogruporubroempleas) {		
				if(tipogruporubroempleaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoGrupoRubroEmpleaLogicAdditional.updateTipoGrupoRubroEmpleaToSave(tipogruporubroempleaLocal,this.arrDatoGeneral);
	        	
				TipoGrupoRubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipogruporubroempleaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoGrupoRubroEmplea(tipogruporubroempleaLocal)) {
					TipoGrupoRubroEmpleaDataAccess.save(tipogruporubroempleaLocal, connexion);				
				} else {
					validadoTodosTipoGrupoRubroEmplea=false;
				}
			}
			
			if(!validadoTodosTipoGrupoRubroEmplea) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoGrupoRubroEmpleaLogicAdditional.checkTipoGrupoRubroEmpleaToSavesAfter(tipogruporubroempleas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoGrupoRubroEmpleas();
			
			connexion.commit();		
			
			this.quitarTipoGrupoRubroEmpleasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoGrupoRubroEmpleas()throws Exception {				
		 try {	
			//TipoGrupoRubroEmpleaLogicAdditional.checkTipoGrupoRubroEmpleaToSaves(tipogruporubroempleas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoGrupoRubroEmplea=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoGrupoRubroEmplea tipogruporubroempleaLocal:tipogruporubroempleas) {				
				if(tipogruporubroempleaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoGrupoRubroEmpleaLogicAdditional.updateTipoGrupoRubroEmpleaToSave(tipogruporubroempleaLocal,this.arrDatoGeneral);
	        	
				TipoGrupoRubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipogruporubroempleaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoGrupoRubroEmplea(tipogruporubroempleaLocal)) {				
					TipoGrupoRubroEmpleaDataAccess.save(tipogruporubroempleaLocal, connexion);				
				} else {
					validadoTodosTipoGrupoRubroEmplea=false;
				}
			}
			
			if(!validadoTodosTipoGrupoRubroEmplea) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoGrupoRubroEmpleaLogicAdditional.checkTipoGrupoRubroEmpleaToSavesAfter(tipogruporubroempleas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoGrupoRubroEmpleasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoGrupoRubroEmpleaParameterReturnGeneral procesarAccionTipoGrupoRubroEmpleas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoGrupoRubroEmplea> tipogruporubroempleas,TipoGrupoRubroEmpleaParameterReturnGeneral tipogruporubroempleaParameterGeneral)throws Exception {
		 try {	
			TipoGrupoRubroEmpleaParameterReturnGeneral tipogruporubroempleaReturnGeneral=new TipoGrupoRubroEmpleaParameterReturnGeneral();
	
			
			return tipogruporubroempleaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoGrupoRubroEmpleaParameterReturnGeneral procesarAccionTipoGrupoRubroEmpleasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoGrupoRubroEmplea> tipogruporubroempleas,TipoGrupoRubroEmpleaParameterReturnGeneral tipogruporubroempleaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoRubroEmplea.class.getSimpleName()+"-procesarAccionTipoGrupoRubroEmpleasWithConnection");connexion.begin();			
			
			TipoGrupoRubroEmpleaParameterReturnGeneral tipogruporubroempleaReturnGeneral=new TipoGrupoRubroEmpleaParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipogruporubroempleaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoGrupoRubroEmpleaParameterReturnGeneral procesarEventosTipoGrupoRubroEmpleas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoGrupoRubroEmplea> tipogruporubroempleas,TipoGrupoRubroEmplea tipogruporubroemplea,TipoGrupoRubroEmpleaParameterReturnGeneral tipogruporubroempleaParameterGeneral,Boolean isEsNuevoTipoGrupoRubroEmplea,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoGrupoRubroEmpleaParameterReturnGeneral tipogruporubroempleaReturnGeneral=new TipoGrupoRubroEmpleaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipogruporubroempleaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipogruporubroempleaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoGrupoRubroEmpleaParameterReturnGeneral procesarEventosTipoGrupoRubroEmpleasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoGrupoRubroEmplea> tipogruporubroempleas,TipoGrupoRubroEmplea tipogruporubroemplea,TipoGrupoRubroEmpleaParameterReturnGeneral tipogruporubroempleaParameterGeneral,Boolean isEsNuevoTipoGrupoRubroEmplea,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoRubroEmplea.class.getSimpleName()+"-procesarEventosTipoGrupoRubroEmpleasWithConnection");connexion.begin();			
			
			TipoGrupoRubroEmpleaParameterReturnGeneral tipogruporubroempleaReturnGeneral=new TipoGrupoRubroEmpleaParameterReturnGeneral();
	
			tipogruporubroempleaReturnGeneral.setTipoGrupoRubroEmplea(tipogruporubroemplea);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipogruporubroempleaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipogruporubroempleaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoGrupoRubroEmpleaParameterReturnGeneral procesarImportacionTipoGrupoRubroEmpleasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoGrupoRubroEmpleaParameterReturnGeneral tipogruporubroempleaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoRubroEmplea.class.getSimpleName()+"-procesarImportacionTipoGrupoRubroEmpleasWithConnection");connexion.begin();			
			
			TipoGrupoRubroEmpleaParameterReturnGeneral tipogruporubroempleaReturnGeneral=new TipoGrupoRubroEmpleaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipogruporubroempleas=new ArrayList<TipoGrupoRubroEmplea>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipogruporubroemplea=new TipoGrupoRubroEmplea();
				
				
				if(conColumnasBase) {this.tipogruporubroemplea.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipogruporubroemplea.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipogruporubroemplea.setcodigo(arrColumnas[iColumn++]);
				this.tipogruporubroemplea.setnombre(arrColumnas[iColumn++]);
				
				this.tipogruporubroempleas.add(this.tipogruporubroemplea);
			}
			
			this.saveTipoGrupoRubroEmpleas();
			
			this.connexion.commit();
			
			tipogruporubroempleaReturnGeneral.setConRetornoEstaProcesado(true);
			tipogruporubroempleaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipogruporubroempleaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoGrupoRubroEmpleasEliminados() throws Exception {				
		
		List<TipoGrupoRubroEmplea> tipogruporubroempleasAux= new ArrayList<TipoGrupoRubroEmplea>();
		
		for(TipoGrupoRubroEmplea tipogruporubroemplea:tipogruporubroempleas) {
			if(!tipogruporubroemplea.getIsDeleted()) {
				tipogruporubroempleasAux.add(tipogruporubroemplea);
			}
		}
		
		tipogruporubroempleas=tipogruporubroempleasAux;
	}
	
	public void quitarTipoGrupoRubroEmpleasNulos() throws Exception {				
		
		List<TipoGrupoRubroEmplea> tipogruporubroempleasAux= new ArrayList<TipoGrupoRubroEmplea>();
		
		for(TipoGrupoRubroEmplea tipogruporubroemplea : this.tipogruporubroempleas) {
			if(tipogruporubroemplea==null) {
				tipogruporubroempleasAux.add(tipogruporubroemplea);
			}
		}
		
		//this.tipogruporubroempleas=tipogruporubroempleasAux;
		
		this.tipogruporubroempleas.removeAll(tipogruporubroempleasAux);
	}
	
	public void getSetVersionRowTipoGrupoRubroEmpleaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipogruporubroemplea.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipogruporubroemplea.getIsDeleted() || (tipogruporubroemplea.getIsChanged()&&!tipogruporubroemplea.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipogruporubroempleaDataAccess.getSetVersionRowTipoGrupoRubroEmplea(connexion,tipogruporubroemplea.getId());
				
				if(!tipogruporubroemplea.getVersionRow().equals(timestamp)) {	
					tipogruporubroemplea.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipogruporubroemplea.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoGrupoRubroEmplea()throws Exception {	
		
		if(tipogruporubroemplea.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipogruporubroemplea.getIsDeleted() || (tipogruporubroemplea.getIsChanged()&&!tipogruporubroemplea.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipogruporubroempleaDataAccess.getSetVersionRowTipoGrupoRubroEmplea(connexion,tipogruporubroemplea.getId());
			
			try {							
				if(!tipogruporubroemplea.getVersionRow().equals(timestamp)) {	
					tipogruporubroemplea.setVersionRow(timestamp);
				}
				
				tipogruporubroemplea.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoGrupoRubroEmpleasWithConnection()throws Exception {	
		if(tipogruporubroempleas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoGrupoRubroEmplea tipogruporubroempleaAux:tipogruporubroempleas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipogruporubroempleaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipogruporubroempleaAux.getIsDeleted() || (tipogruporubroempleaAux.getIsChanged()&&!tipogruporubroempleaAux.getIsNew())) {
						
						timestamp=tipogruporubroempleaDataAccess.getSetVersionRowTipoGrupoRubroEmplea(connexion,tipogruporubroempleaAux.getId());
						
						if(!tipogruporubroemplea.getVersionRow().equals(timestamp)) {	
							tipogruporubroempleaAux.setVersionRow(timestamp);
						}
								
						tipogruporubroempleaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoGrupoRubroEmpleas()throws Exception {	
		if(tipogruporubroempleas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoGrupoRubroEmplea tipogruporubroempleaAux:tipogruporubroempleas) {
					if(tipogruporubroempleaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipogruporubroempleaAux.getIsDeleted() || (tipogruporubroempleaAux.getIsChanged()&&!tipogruporubroempleaAux.getIsNew())) {
						
						timestamp=tipogruporubroempleaDataAccess.getSetVersionRowTipoGrupoRubroEmplea(connexion,tipogruporubroempleaAux.getId());
						
						if(!tipogruporubroempleaAux.getVersionRow().equals(timestamp)) {	
							tipogruporubroempleaAux.setVersionRow(timestamp);
						}
						
													
						tipogruporubroempleaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	
	public void deepLoad(TipoGrupoRubroEmplea tipogruporubroemplea,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoGrupoRubroEmpleaLogicAdditional.updateTipoGrupoRubroEmpleaToGet(tipogruporubroemplea,this.arrDatoGeneral);
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoGrupoRubroEmplea tipogruporubroemplea,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoGrupoRubroEmplea.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipogruporubroemplea,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoGrupoRubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoRubroEmplea(tipogruporubroemplea);
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
			this.deepLoad(this.tipogruporubroemplea,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoGrupoRubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoRubroEmplea(this.tipogruporubroemplea);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoGrupoRubroEmplea.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipogruporubroempleas!=null) {
				for(TipoGrupoRubroEmplea tipogruporubroemplea:tipogruporubroempleas) {
					this.deepLoad(tipogruporubroemplea,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoGrupoRubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoRubroEmplea(tipogruporubroempleas);
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
			if(tipogruporubroempleas!=null) {
				for(TipoGrupoRubroEmplea tipogruporubroemplea:tipogruporubroempleas) {
					this.deepLoad(tipogruporubroemplea,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoGrupoRubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoRubroEmplea(tipogruporubroempleas);
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
			if(TipoGrupoRubroEmpleaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoGrupoRubroEmpleaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoGrupoRubroEmplea tipogruporubroemplea,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoGrupoRubroEmpleaConstantesFunciones.ISCONAUDITORIA) {
				if(tipogruporubroemplea.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoGrupoRubroEmpleaDataAccess.TABLENAME, tipogruporubroemplea.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoGrupoRubroEmpleaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoGrupoRubroEmpleaLogic.registrarAuditoriaDetallesTipoGrupoRubroEmplea(connexion,tipogruporubroemplea,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipogruporubroemplea.getIsDeleted()) {
					/*if(!tipogruporubroemplea.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoGrupoRubroEmpleaDataAccess.TABLENAME, tipogruporubroemplea.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoGrupoRubroEmpleaLogic.registrarAuditoriaDetallesTipoGrupoRubroEmplea(connexion,tipogruporubroemplea,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoGrupoRubroEmpleaDataAccess.TABLENAME, tipogruporubroemplea.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipogruporubroemplea.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoGrupoRubroEmpleaDataAccess.TABLENAME, tipogruporubroemplea.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoGrupoRubroEmpleaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoGrupoRubroEmpleaLogic.registrarAuditoriaDetallesTipoGrupoRubroEmplea(connexion,tipogruporubroemplea,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoGrupoRubroEmplea(Connexion connexion,TipoGrupoRubroEmplea tipogruporubroemplea)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipogruporubroemplea.getIsNew()||!tipogruporubroemplea.getcodigo().equals(tipogruporubroemplea.getTipoGrupoRubroEmpleaOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipogruporubroemplea.getTipoGrupoRubroEmpleaOriginal().getcodigo()!=null)
				{
					strValorActual=tipogruporubroemplea.getTipoGrupoRubroEmpleaOriginal().getcodigo();
				}
				if(tipogruporubroemplea.getcodigo()!=null)
				{
					strValorNuevo=tipogruporubroemplea.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoGrupoRubroEmpleaConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipogruporubroemplea.getIsNew()||!tipogruporubroemplea.getnombre().equals(tipogruporubroemplea.getTipoGrupoRubroEmpleaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipogruporubroemplea.getTipoGrupoRubroEmpleaOriginal().getnombre()!=null)
				{
					strValorActual=tipogruporubroemplea.getTipoGrupoRubroEmpleaOriginal().getnombre();
				}
				if(tipogruporubroemplea.getnombre()!=null)
				{
					strValorNuevo=tipogruporubroemplea.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoGrupoRubroEmpleaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoGrupoRubroEmplea(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoGrupoRubroEmpleaConstantesFunciones.getClassesForeignKeysOfTipoGrupoRubroEmplea(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoGrupoRubroEmplea(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoGrupoRubroEmpleaConstantesFunciones.getClassesRelationshipsOfTipoGrupoRubroEmplea(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

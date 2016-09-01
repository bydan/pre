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
import com.bydan.erp.contabilidad.util.TipoParametroFormularioIvaConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoParametroFormularioIvaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoParametroFormularioIvaParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.TipoParametroFormularioIva;
import com.bydan.erp.contabilidad.business.logic.TipoParametroFormularioIvaLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoParametroFormularioIvaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoParametroFormularioIvaLogic.class);
	
	protected TipoParametroFormularioIvaDataAccess tipoparametroformularioivaDataAccess; 	
	protected TipoParametroFormularioIva tipoparametroformularioiva;
	protected List<TipoParametroFormularioIva> tipoparametroformularioivas;
	protected Object tipoparametroformularioivaObject;	
	protected List<Object> tipoparametroformularioivasObject;
	
	public static ClassValidator<TipoParametroFormularioIva> tipoparametroformularioivaValidator = new ClassValidator<TipoParametroFormularioIva>(TipoParametroFormularioIva.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoParametroFormularioIvaLogicAdditional tipoparametroformularioivaLogicAdditional=null;
	
	public TipoParametroFormularioIvaLogicAdditional getTipoParametroFormularioIvaLogicAdditional() {
		return this.tipoparametroformularioivaLogicAdditional;
	}
	
	public void setTipoParametroFormularioIvaLogicAdditional(TipoParametroFormularioIvaLogicAdditional tipoparametroformularioivaLogicAdditional) {
		try {
			this.tipoparametroformularioivaLogicAdditional=tipoparametroformularioivaLogicAdditional;
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
	
	
	
	
	public  TipoParametroFormularioIvaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoparametroformularioivaDataAccess = new TipoParametroFormularioIvaDataAccess();
			
			this.tipoparametroformularioivas= new ArrayList<TipoParametroFormularioIva>();
			this.tipoparametroformularioiva= new TipoParametroFormularioIva();
			
			this.tipoparametroformularioivaObject=new Object();
			this.tipoparametroformularioivasObject=new ArrayList<Object>();
				
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
			
			this.tipoparametroformularioivaDataAccess.setConnexionType(this.connexionType);
			this.tipoparametroformularioivaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoParametroFormularioIvaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoparametroformularioivaDataAccess = new TipoParametroFormularioIvaDataAccess();
			this.tipoparametroformularioivas= new ArrayList<TipoParametroFormularioIva>();
			this.tipoparametroformularioiva= new TipoParametroFormularioIva();
			this.tipoparametroformularioivaObject=new Object();
			this.tipoparametroformularioivasObject=new ArrayList<Object>();
			
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
			
			this.tipoparametroformularioivaDataAccess.setConnexionType(this.connexionType);
			this.tipoparametroformularioivaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoParametroFormularioIva getTipoParametroFormularioIva() throws Exception {	
		TipoParametroFormularioIvaLogicAdditional.checkTipoParametroFormularioIvaToGet(tipoparametroformularioiva,this.datosCliente,this.arrDatoGeneral);
		TipoParametroFormularioIvaLogicAdditional.updateTipoParametroFormularioIvaToGet(tipoparametroformularioiva,this.arrDatoGeneral);
		
		return tipoparametroformularioiva;
	}
		
	public void setTipoParametroFormularioIva(TipoParametroFormularioIva newTipoParametroFormularioIva) {
		this.tipoparametroformularioiva = newTipoParametroFormularioIva;
	}
	
	public TipoParametroFormularioIvaDataAccess getTipoParametroFormularioIvaDataAccess() {
		return tipoparametroformularioivaDataAccess;
	}
	
	public void setTipoParametroFormularioIvaDataAccess(TipoParametroFormularioIvaDataAccess newtipoparametroformularioivaDataAccess) {
		this.tipoparametroformularioivaDataAccess = newtipoparametroformularioivaDataAccess;
	}
	
	public List<TipoParametroFormularioIva> getTipoParametroFormularioIvas() throws Exception {		
		this.quitarTipoParametroFormularioIvasNulos();
		
		TipoParametroFormularioIvaLogicAdditional.checkTipoParametroFormularioIvaToGets(tipoparametroformularioivas,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoParametroFormularioIva tipoparametroformularioivaLocal: tipoparametroformularioivas ) {
			TipoParametroFormularioIvaLogicAdditional.updateTipoParametroFormularioIvaToGet(tipoparametroformularioivaLocal,this.arrDatoGeneral);
		}
		
		return tipoparametroformularioivas;
	}
	
	public void setTipoParametroFormularioIvas(List<TipoParametroFormularioIva> newTipoParametroFormularioIvas) {
		this.tipoparametroformularioivas = newTipoParametroFormularioIvas;
	}
	
	public Object getTipoParametroFormularioIvaObject() {	
		this.tipoparametroformularioivaObject=this.tipoparametroformularioivaDataAccess.getEntityObject();
		return this.tipoparametroformularioivaObject;
	}
		
	public void setTipoParametroFormularioIvaObject(Object newTipoParametroFormularioIvaObject) {
		this.tipoparametroformularioivaObject = newTipoParametroFormularioIvaObject;
	}
	
	public List<Object> getTipoParametroFormularioIvasObject() {		
		this.tipoparametroformularioivasObject=this.tipoparametroformularioivaDataAccess.getEntitiesObject();
		return this.tipoparametroformularioivasObject;
	}
		
	public void setTipoParametroFormularioIvasObject(List<Object> newTipoParametroFormularioIvasObject) {
		this.tipoparametroformularioivasObject = newTipoParametroFormularioIvasObject;
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
		
		if(this.tipoparametroformularioivaDataAccess!=null) {
			this.tipoparametroformularioivaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParametroFormularioIva.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoparametroformularioivaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoparametroformularioivaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoparametroformularioiva = new  TipoParametroFormularioIva();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParametroFormularioIva.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoparametroformularioiva=tipoparametroformularioivaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoparametroformularioiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroFormularioIva(this.tipoparametroformularioiva);
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
		tipoparametroformularioiva = new  TipoParametroFormularioIva();
		  		  
        try {
			
			tipoparametroformularioiva=tipoparametroformularioivaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoparametroformularioiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroFormularioIva(this.tipoparametroformularioiva);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoparametroformularioiva = new  TipoParametroFormularioIva();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParametroFormularioIva.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoparametroformularioiva=tipoparametroformularioivaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoparametroformularioiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroFormularioIva(this.tipoparametroformularioiva);
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
		tipoparametroformularioiva = new  TipoParametroFormularioIva();
		  		  
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
		tipoparametroformularioiva = new  TipoParametroFormularioIva();
		  		  
        try {
			
			tipoparametroformularioiva=tipoparametroformularioivaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoparametroformularioiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroFormularioIva(this.tipoparametroformularioiva);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoparametroformularioiva = new  TipoParametroFormularioIva();
		  		  
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
		tipoparametroformularioiva = new  TipoParametroFormularioIva();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParametroFormularioIva.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoparametroformularioivaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoparametroformularioiva = new  TipoParametroFormularioIva();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoparametroformularioivaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoparametroformularioiva = new  TipoParametroFormularioIva();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParametroFormularioIva.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoparametroformularioivaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoparametroformularioiva = new  TipoParametroFormularioIva();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoparametroformularioivaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoparametroformularioiva = new  TipoParametroFormularioIva();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParametroFormularioIva.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoparametroformularioivaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoparametroformularioiva = new  TipoParametroFormularioIva();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoparametroformularioivaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoparametroformularioivas = new  ArrayList<TipoParametroFormularioIva>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParametroFormularioIva.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparametroformularioivas=tipoparametroformularioivaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoParametroFormularioIva(tipoparametroformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroFormularioIva(this.tipoparametroformularioivas);
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
		tipoparametroformularioivas = new  ArrayList<TipoParametroFormularioIva>();
		  		  
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
		tipoparametroformularioivas = new  ArrayList<TipoParametroFormularioIva>();
		  		  
        try {			
			TipoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparametroformularioivas=tipoparametroformularioivaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoParametroFormularioIva(tipoparametroformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroFormularioIva(this.tipoparametroformularioivas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoparametroformularioivas = new  ArrayList<TipoParametroFormularioIva>();
		  		  
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
		tipoparametroformularioivas = new  ArrayList<TipoParametroFormularioIva>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParametroFormularioIva.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparametroformularioivas=tipoparametroformularioivaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoParametroFormularioIva(tipoparametroformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroFormularioIva(this.tipoparametroformularioivas);
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
		tipoparametroformularioivas = new  ArrayList<TipoParametroFormularioIva>();
		  		  
        try {
			TipoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparametroformularioivas=tipoparametroformularioivaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoParametroFormularioIva(tipoparametroformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroFormularioIva(this.tipoparametroformularioivas);
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
		tipoparametroformularioivas = new  ArrayList<TipoParametroFormularioIva>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParametroFormularioIva.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparametroformularioivas=tipoparametroformularioivaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoParametroFormularioIva(tipoparametroformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroFormularioIva(this.tipoparametroformularioivas);
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
		tipoparametroformularioivas = new  ArrayList<TipoParametroFormularioIva>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparametroformularioivas=tipoparametroformularioivaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoParametroFormularioIva(tipoparametroformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroFormularioIva(this.tipoparametroformularioivas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoparametroformularioiva = new  TipoParametroFormularioIva();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParametroFormularioIva.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparametroformularioiva=tipoparametroformularioivaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoParametroFormularioIva(tipoparametroformularioiva);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroFormularioIva(this.tipoparametroformularioiva);
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
		tipoparametroformularioiva = new  TipoParametroFormularioIva();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparametroformularioiva=tipoparametroformularioivaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoParametroFormularioIva(tipoparametroformularioiva);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroFormularioIva(this.tipoparametroformularioiva);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoparametroformularioivas = new  ArrayList<TipoParametroFormularioIva>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParametroFormularioIva.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparametroformularioivas=tipoparametroformularioivaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoParametroFormularioIva(tipoparametroformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroFormularioIva(this.tipoparametroformularioivas);
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
		tipoparametroformularioivas = new  ArrayList<TipoParametroFormularioIva>();
		  		  
        try {
			TipoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparametroformularioivas=tipoparametroformularioivaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoParametroFormularioIva(tipoparametroformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroFormularioIva(this.tipoparametroformularioivas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoParametroFormularioIvasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoparametroformularioivas = new  ArrayList<TipoParametroFormularioIva>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParametroFormularioIva.class.getSimpleName()+"-getTodosTipoParametroFormularioIvasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparametroformularioivas=tipoparametroformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoParametroFormularioIva(tipoparametroformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroFormularioIva(this.tipoparametroformularioivas);
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
	
	public  void  getTodosTipoParametroFormularioIvas(String sFinalQuery,Pagination pagination)throws Exception {
		tipoparametroformularioivas = new  ArrayList<TipoParametroFormularioIva>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparametroformularioivas=tipoparametroformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoParametroFormularioIva(tipoparametroformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroFormularioIva(this.tipoparametroformularioivas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoParametroFormularioIva(TipoParametroFormularioIva tipoparametroformularioiva) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoparametroformularioiva.getIsNew() || tipoparametroformularioiva.getIsChanged()) { 
			this.invalidValues = tipoparametroformularioivaValidator.getInvalidValues(tipoparametroformularioiva);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoparametroformularioiva);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoParametroFormularioIva(List<TipoParametroFormularioIva> TipoParametroFormularioIvas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoParametroFormularioIva tipoparametroformularioivaLocal:tipoparametroformularioivas) {				
			estaValidadoObjeto=this.validarGuardarTipoParametroFormularioIva(tipoparametroformularioivaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoParametroFormularioIva(List<TipoParametroFormularioIva> TipoParametroFormularioIvas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoParametroFormularioIva(tipoparametroformularioivas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoParametroFormularioIva(TipoParametroFormularioIva TipoParametroFormularioIva) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoParametroFormularioIva(tipoparametroformularioiva)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoParametroFormularioIva tipoparametroformularioiva) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoparametroformularioiva.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoParametroFormularioIvaConstantesFunciones.getTipoParametroFormularioIvaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoparametroformularioiva","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoParametroFormularioIvaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoParametroFormularioIvaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoParametroFormularioIvaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParametroFormularioIva.class.getSimpleName()+"-saveTipoParametroFormularioIvaWithConnection");connexion.begin();			
			
			TipoParametroFormularioIvaLogicAdditional.checkTipoParametroFormularioIvaToSave(this.tipoparametroformularioiva,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoParametroFormularioIvaLogicAdditional.updateTipoParametroFormularioIvaToSave(this.tipoparametroformularioiva,this.arrDatoGeneral);
			
			TipoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoparametroformularioiva,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoParametroFormularioIva();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoParametroFormularioIva(this.tipoparametroformularioiva)) {
				TipoParametroFormularioIvaDataAccess.save(this.tipoparametroformularioiva, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoparametroformularioiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoParametroFormularioIvaLogicAdditional.checkTipoParametroFormularioIvaToSaveAfter(this.tipoparametroformularioiva,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoParametroFormularioIva();
			
			connexion.commit();			
			
			if(this.tipoparametroformularioiva.getIsDeleted()) {
				this.tipoparametroformularioiva=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoParametroFormularioIva()throws Exception {	
		try {	
			
			TipoParametroFormularioIvaLogicAdditional.checkTipoParametroFormularioIvaToSave(this.tipoparametroformularioiva,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoParametroFormularioIvaLogicAdditional.updateTipoParametroFormularioIvaToSave(this.tipoparametroformularioiva,this.arrDatoGeneral);
			
			TipoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoparametroformularioiva,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoParametroFormularioIva(this.tipoparametroformularioiva)) {			
				TipoParametroFormularioIvaDataAccess.save(this.tipoparametroformularioiva, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoparametroformularioiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoParametroFormularioIvaLogicAdditional.checkTipoParametroFormularioIvaToSaveAfter(this.tipoparametroformularioiva,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoparametroformularioiva.getIsDeleted()) {
				this.tipoparametroformularioiva=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoParametroFormularioIvasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParametroFormularioIva.class.getSimpleName()+"-saveTipoParametroFormularioIvasWithConnection");connexion.begin();			
			
			TipoParametroFormularioIvaLogicAdditional.checkTipoParametroFormularioIvaToSaves(tipoparametroformularioivas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoParametroFormularioIvas();
			
			Boolean validadoTodosTipoParametroFormularioIva=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoParametroFormularioIva tipoparametroformularioivaLocal:tipoparametroformularioivas) {		
				if(tipoparametroformularioivaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoParametroFormularioIvaLogicAdditional.updateTipoParametroFormularioIvaToSave(tipoparametroformularioivaLocal,this.arrDatoGeneral);
	        	
				TipoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoparametroformularioivaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoParametroFormularioIva(tipoparametroformularioivaLocal)) {
					TipoParametroFormularioIvaDataAccess.save(tipoparametroformularioivaLocal, connexion);				
				} else {
					validadoTodosTipoParametroFormularioIva=false;
				}
			}
			
			if(!validadoTodosTipoParametroFormularioIva) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoParametroFormularioIvaLogicAdditional.checkTipoParametroFormularioIvaToSavesAfter(tipoparametroformularioivas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoParametroFormularioIvas();
			
			connexion.commit();		
			
			this.quitarTipoParametroFormularioIvasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoParametroFormularioIvas()throws Exception {				
		 try {	
			TipoParametroFormularioIvaLogicAdditional.checkTipoParametroFormularioIvaToSaves(tipoparametroformularioivas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoParametroFormularioIva=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoParametroFormularioIva tipoparametroformularioivaLocal:tipoparametroformularioivas) {				
				if(tipoparametroformularioivaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoParametroFormularioIvaLogicAdditional.updateTipoParametroFormularioIvaToSave(tipoparametroformularioivaLocal,this.arrDatoGeneral);
	        	
				TipoParametroFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoparametroformularioivaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoParametroFormularioIva(tipoparametroformularioivaLocal)) {				
					TipoParametroFormularioIvaDataAccess.save(tipoparametroformularioivaLocal, connexion);				
				} else {
					validadoTodosTipoParametroFormularioIva=false;
				}
			}
			
			if(!validadoTodosTipoParametroFormularioIva) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoParametroFormularioIvaLogicAdditional.checkTipoParametroFormularioIvaToSavesAfter(tipoparametroformularioivas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoParametroFormularioIvasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoParametroFormularioIvaParameterReturnGeneral procesarAccionTipoParametroFormularioIvas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoParametroFormularioIva> tipoparametroformularioivas,TipoParametroFormularioIvaParameterReturnGeneral tipoparametroformularioivaParameterGeneral)throws Exception {
		 try {	
			TipoParametroFormularioIvaParameterReturnGeneral tipoparametroformularioivaReturnGeneral=new TipoParametroFormularioIvaParameterReturnGeneral();
	
			TipoParametroFormularioIvaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoparametroformularioivas,tipoparametroformularioivaParameterGeneral,tipoparametroformularioivaReturnGeneral);
			
			return tipoparametroformularioivaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoParametroFormularioIvaParameterReturnGeneral procesarAccionTipoParametroFormularioIvasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoParametroFormularioIva> tipoparametroformularioivas,TipoParametroFormularioIvaParameterReturnGeneral tipoparametroformularioivaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParametroFormularioIva.class.getSimpleName()+"-procesarAccionTipoParametroFormularioIvasWithConnection");connexion.begin();			
			
			TipoParametroFormularioIvaParameterReturnGeneral tipoparametroformularioivaReturnGeneral=new TipoParametroFormularioIvaParameterReturnGeneral();
	
			TipoParametroFormularioIvaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoparametroformularioivas,tipoparametroformularioivaParameterGeneral,tipoparametroformularioivaReturnGeneral);
			
			this.connexion.commit();
			
			return tipoparametroformularioivaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoParametroFormularioIvaParameterReturnGeneral procesarEventosTipoParametroFormularioIvas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoParametroFormularioIva> tipoparametroformularioivas,TipoParametroFormularioIva tipoparametroformularioiva,TipoParametroFormularioIvaParameterReturnGeneral tipoparametroformularioivaParameterGeneral,Boolean isEsNuevoTipoParametroFormularioIva,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoParametroFormularioIvaParameterReturnGeneral tipoparametroformularioivaReturnGeneral=new TipoParametroFormularioIvaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoparametroformularioivaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoParametroFormularioIvaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoparametroformularioivas,tipoparametroformularioiva,tipoparametroformularioivaParameterGeneral,tipoparametroformularioivaReturnGeneral,isEsNuevoTipoParametroFormularioIva,clases);
			
			return tipoparametroformularioivaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoParametroFormularioIvaParameterReturnGeneral procesarEventosTipoParametroFormularioIvasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoParametroFormularioIva> tipoparametroformularioivas,TipoParametroFormularioIva tipoparametroformularioiva,TipoParametroFormularioIvaParameterReturnGeneral tipoparametroformularioivaParameterGeneral,Boolean isEsNuevoTipoParametroFormularioIva,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParametroFormularioIva.class.getSimpleName()+"-procesarEventosTipoParametroFormularioIvasWithConnection");connexion.begin();			
			
			TipoParametroFormularioIvaParameterReturnGeneral tipoparametroformularioivaReturnGeneral=new TipoParametroFormularioIvaParameterReturnGeneral();
	
			tipoparametroformularioivaReturnGeneral.setTipoParametroFormularioIva(tipoparametroformularioiva);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoparametroformularioivaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoParametroFormularioIvaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoparametroformularioivas,tipoparametroformularioiva,tipoparametroformularioivaParameterGeneral,tipoparametroformularioivaReturnGeneral,isEsNuevoTipoParametroFormularioIva,clases);
			
			this.connexion.commit();
			
			return tipoparametroformularioivaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoParametroFormularioIvaParameterReturnGeneral procesarImportacionTipoParametroFormularioIvasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoParametroFormularioIvaParameterReturnGeneral tipoparametroformularioivaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParametroFormularioIva.class.getSimpleName()+"-procesarImportacionTipoParametroFormularioIvasWithConnection");connexion.begin();			
			
			TipoParametroFormularioIvaParameterReturnGeneral tipoparametroformularioivaReturnGeneral=new TipoParametroFormularioIvaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoparametroformularioivas=new ArrayList<TipoParametroFormularioIva>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoparametroformularioiva=new TipoParametroFormularioIva();
				
				
				if(conColumnasBase) {this.tipoparametroformularioiva.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoparametroformularioiva.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoparametroformularioiva.setnombre(arrColumnas[iColumn++]);
				this.tipoparametroformularioiva.setcodigo_sri(arrColumnas[iColumn++]);
				
				this.tipoparametroformularioivas.add(this.tipoparametroformularioiva);
			}
			
			this.saveTipoParametroFormularioIvas();
			
			this.connexion.commit();
			
			tipoparametroformularioivaReturnGeneral.setConRetornoEstaProcesado(true);
			tipoparametroformularioivaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoparametroformularioivaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoParametroFormularioIvasEliminados() throws Exception {				
		
		List<TipoParametroFormularioIva> tipoparametroformularioivasAux= new ArrayList<TipoParametroFormularioIva>();
		
		for(TipoParametroFormularioIva tipoparametroformularioiva:tipoparametroformularioivas) {
			if(!tipoparametroformularioiva.getIsDeleted()) {
				tipoparametroformularioivasAux.add(tipoparametroformularioiva);
			}
		}
		
		tipoparametroformularioivas=tipoparametroformularioivasAux;
	}
	
	public void quitarTipoParametroFormularioIvasNulos() throws Exception {				
		
		List<TipoParametroFormularioIva> tipoparametroformularioivasAux= new ArrayList<TipoParametroFormularioIva>();
		
		for(TipoParametroFormularioIva tipoparametroformularioiva : this.tipoparametroformularioivas) {
			if(tipoparametroformularioiva==null) {
				tipoparametroformularioivasAux.add(tipoparametroformularioiva);
			}
		}
		
		//this.tipoparametroformularioivas=tipoparametroformularioivasAux;
		
		this.tipoparametroformularioivas.removeAll(tipoparametroformularioivasAux);
	}
	
	public void getSetVersionRowTipoParametroFormularioIvaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoparametroformularioiva.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoparametroformularioiva.getIsDeleted() || (tipoparametroformularioiva.getIsChanged()&&!tipoparametroformularioiva.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoparametroformularioivaDataAccess.getSetVersionRowTipoParametroFormularioIva(connexion,tipoparametroformularioiva.getId());
				
				if(!tipoparametroformularioiva.getVersionRow().equals(timestamp)) {	
					tipoparametroformularioiva.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoparametroformularioiva.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoParametroFormularioIva()throws Exception {	
		
		if(tipoparametroformularioiva.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoparametroformularioiva.getIsDeleted() || (tipoparametroformularioiva.getIsChanged()&&!tipoparametroformularioiva.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoparametroformularioivaDataAccess.getSetVersionRowTipoParametroFormularioIva(connexion,tipoparametroformularioiva.getId());
			
			try {							
				if(!tipoparametroformularioiva.getVersionRow().equals(timestamp)) {	
					tipoparametroformularioiva.setVersionRow(timestamp);
				}
				
				tipoparametroformularioiva.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoParametroFormularioIvasWithConnection()throws Exception {	
		if(tipoparametroformularioivas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoParametroFormularioIva tipoparametroformularioivaAux:tipoparametroformularioivas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoparametroformularioivaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoparametroformularioivaAux.getIsDeleted() || (tipoparametroformularioivaAux.getIsChanged()&&!tipoparametroformularioivaAux.getIsNew())) {
						
						timestamp=tipoparametroformularioivaDataAccess.getSetVersionRowTipoParametroFormularioIva(connexion,tipoparametroformularioivaAux.getId());
						
						if(!tipoparametroformularioiva.getVersionRow().equals(timestamp)) {	
							tipoparametroformularioivaAux.setVersionRow(timestamp);
						}
								
						tipoparametroformularioivaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoParametroFormularioIvas()throws Exception {	
		if(tipoparametroformularioivas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoParametroFormularioIva tipoparametroformularioivaAux:tipoparametroformularioivas) {
					if(tipoparametroformularioivaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoparametroformularioivaAux.getIsDeleted() || (tipoparametroformularioivaAux.getIsChanged()&&!tipoparametroformularioivaAux.getIsNew())) {
						
						timestamp=tipoparametroformularioivaDataAccess.getSetVersionRowTipoParametroFormularioIva(connexion,tipoparametroformularioivaAux.getId());
						
						if(!tipoparametroformularioivaAux.getVersionRow().equals(timestamp)) {	
							tipoparametroformularioivaAux.setVersionRow(timestamp);
						}
						
													
						tipoparametroformularioivaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyTipoParametroFormularioIvaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ParametroFormularioIvaLogic parametroformularioivaLogic=new ParametroFormularioIvaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParametroFormularioIva.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoParametroFormularioIvaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(ParametroFormularioIva.class));
											
			

			parametroformularioivaLogic.setConnexion(this.getConnexion());
			parametroformularioivaLogic.setDatosCliente(this.datosCliente);
			parametroformularioivaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoParametroFormularioIva tipoparametroformularioiva:this.tipoparametroformularioivas) {
				

				classes=new ArrayList<Classe>();
				classes=ParametroFormularioIvaConstantesFunciones.getClassesForeignKeysOfParametroFormularioIva(new ArrayList<Classe>(),DeepLoadType.NONE);

				parametroformularioivaLogic.setParametroFormularioIvas(tipoparametroformularioiva.parametroformularioivas);
				parametroformularioivaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoParametroFormularioIva tipoparametroformularioiva,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoParametroFormularioIvaLogicAdditional.updateTipoParametroFormularioIvaToGet(tipoparametroformularioiva,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoparametroformularioiva.setParametroFormularioIvas(tipoparametroformularioivaDataAccess.getParametroFormularioIvas(connexion,tipoparametroformularioiva));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroFormularioIva.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoparametroformularioiva.setParametroFormularioIvas(tipoparametroformularioivaDataAccess.getParametroFormularioIvas(connexion,tipoparametroformularioiva));

				if(this.isConDeep) {
					ParametroFormularioIvaLogic parametroformularioivaLogic= new ParametroFormularioIvaLogic(this.connexion);
					parametroformularioivaLogic.setParametroFormularioIvas(tipoparametroformularioiva.getParametroFormularioIvas());
					ArrayList<Classe> classesLocal=ParametroFormularioIvaConstantesFunciones.getClassesForeignKeysOfParametroFormularioIva(new ArrayList<Classe>(),DeepLoadType.NONE);
					parametroformularioivaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesParametroFormularioIva(parametroformularioivaLogic.getParametroFormularioIvas());
					tipoparametroformularioiva.setParametroFormularioIvas(parametroformularioivaLogic.getParametroFormularioIvas());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroFormularioIva.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroFormularioIva.class));
			tipoparametroformularioiva.setParametroFormularioIvas(tipoparametroformularioivaDataAccess.getParametroFormularioIvas(connexion,tipoparametroformularioiva));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		tipoparametroformularioiva.setParametroFormularioIvas(tipoparametroformularioivaDataAccess.getParametroFormularioIvas(connexion,tipoparametroformularioiva));

		for(ParametroFormularioIva parametroformularioiva:tipoparametroformularioiva.getParametroFormularioIvas()) {
			ParametroFormularioIvaLogic parametroformularioivaLogic= new ParametroFormularioIvaLogic(connexion);
			parametroformularioivaLogic.deepLoad(parametroformularioiva,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroFormularioIva.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoparametroformularioiva.setParametroFormularioIvas(tipoparametroformularioivaDataAccess.getParametroFormularioIvas(connexion,tipoparametroformularioiva));

				for(ParametroFormularioIva parametroformularioiva:tipoparametroformularioiva.getParametroFormularioIvas()) {
					ParametroFormularioIvaLogic parametroformularioivaLogic= new ParametroFormularioIvaLogic(connexion);
					parametroformularioivaLogic.deepLoad(parametroformularioiva,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroFormularioIva.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroFormularioIva.class));
			tipoparametroformularioiva.setParametroFormularioIvas(tipoparametroformularioivaDataAccess.getParametroFormularioIvas(connexion,tipoparametroformularioiva));

			for(ParametroFormularioIva parametroformularioiva:tipoparametroformularioiva.getParametroFormularioIvas()) {
				ParametroFormularioIvaLogic parametroformularioivaLogic= new ParametroFormularioIvaLogic(connexion);
				parametroformularioivaLogic.deepLoad(parametroformularioiva,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoParametroFormularioIva tipoparametroformularioiva,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoParametroFormularioIvaLogicAdditional.updateTipoParametroFormularioIvaToSave(tipoparametroformularioiva,this.arrDatoGeneral);
			
TipoParametroFormularioIvaDataAccess.save(tipoparametroformularioiva, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(ParametroFormularioIva parametroformularioiva:tipoparametroformularioiva.getParametroFormularioIvas()) {
			parametroformularioiva.setid_tipo_parametro_formulario_iva(tipoparametroformularioiva.getId());
			ParametroFormularioIvaDataAccess.save(parametroformularioiva,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(ParametroFormularioIva.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroFormularioIva parametroformularioiva:tipoparametroformularioiva.getParametroFormularioIvas()) {
					parametroformularioiva.setid_tipo_parametro_formulario_iva(tipoparametroformularioiva.getId());
					ParametroFormularioIvaDataAccess.save(parametroformularioiva,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(ParametroFormularioIva parametroformularioiva:tipoparametroformularioiva.getParametroFormularioIvas()) {
			ParametroFormularioIvaLogic parametroformularioivaLogic= new ParametroFormularioIvaLogic(connexion);
			parametroformularioiva.setid_tipo_parametro_formulario_iva(tipoparametroformularioiva.getId());
			ParametroFormularioIvaDataAccess.save(parametroformularioiva,connexion);
			parametroformularioivaLogic.deepSave(parametroformularioiva,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(ParametroFormularioIva.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroFormularioIva parametroformularioiva:tipoparametroformularioiva.getParametroFormularioIvas()) {
					ParametroFormularioIvaLogic parametroformularioivaLogic= new ParametroFormularioIvaLogic(connexion);
					parametroformularioiva.setid_tipo_parametro_formulario_iva(tipoparametroformularioiva.getId());
					ParametroFormularioIvaDataAccess.save(parametroformularioiva,connexion);
					parametroformularioivaLogic.deepSave(parametroformularioiva,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoParametroFormularioIva.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoparametroformularioiva,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroFormularioIva(tipoparametroformularioiva);
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
			this.deepLoad(this.tipoparametroformularioiva,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroFormularioIva(this.tipoparametroformularioiva);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoParametroFormularioIva.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoparametroformularioivas!=null) {
				for(TipoParametroFormularioIva tipoparametroformularioiva:tipoparametroformularioivas) {
					this.deepLoad(tipoparametroformularioiva,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroFormularioIva(tipoparametroformularioivas);
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
			if(tipoparametroformularioivas!=null) {
				for(TipoParametroFormularioIva tipoparametroformularioiva:tipoparametroformularioivas) {
					this.deepLoad(tipoparametroformularioiva,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoParametroFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroFormularioIva(tipoparametroformularioivas);
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
			this.getNewConnexionToDeep(TipoParametroFormularioIva.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipoparametroformularioiva,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoParametroFormularioIva.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipoparametroformularioivas!=null) {
				for(TipoParametroFormularioIva tipoparametroformularioiva:tipoparametroformularioivas) {
					this.deepSave(tipoparametroformularioiva,isDeep,deepLoadType,clases);
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
			if(tipoparametroformularioivas!=null) {
				for(TipoParametroFormularioIva tipoparametroformularioiva:tipoparametroformularioivas) {
					this.deepSave(tipoparametroformularioiva,isDeep,deepLoadType,clases);
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
			if(TipoParametroFormularioIvaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoParametroFormularioIvaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoParametroFormularioIva tipoparametroformularioiva,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoParametroFormularioIvaConstantesFunciones.ISCONAUDITORIA) {
				if(tipoparametroformularioiva.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoParametroFormularioIvaDataAccess.TABLENAME, tipoparametroformularioiva.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoParametroFormularioIvaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoParametroFormularioIvaLogic.registrarAuditoriaDetallesTipoParametroFormularioIva(connexion,tipoparametroformularioiva,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoparametroformularioiva.getIsDeleted()) {
					/*if(!tipoparametroformularioiva.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoParametroFormularioIvaDataAccess.TABLENAME, tipoparametroformularioiva.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoParametroFormularioIvaLogic.registrarAuditoriaDetallesTipoParametroFormularioIva(connexion,tipoparametroformularioiva,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoParametroFormularioIvaDataAccess.TABLENAME, tipoparametroformularioiva.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoparametroformularioiva.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoParametroFormularioIvaDataAccess.TABLENAME, tipoparametroformularioiva.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoParametroFormularioIvaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoParametroFormularioIvaLogic.registrarAuditoriaDetallesTipoParametroFormularioIva(connexion,tipoparametroformularioiva,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoParametroFormularioIva(Connexion connexion,TipoParametroFormularioIva tipoparametroformularioiva)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoparametroformularioiva.getIsNew()||!tipoparametroformularioiva.getnombre().equals(tipoparametroformularioiva.getTipoParametroFormularioIvaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoparametroformularioiva.getTipoParametroFormularioIvaOriginal().getnombre()!=null)
				{
					strValorActual=tipoparametroformularioiva.getTipoParametroFormularioIvaOriginal().getnombre();
				}
				if(tipoparametroformularioiva.getnombre()!=null)
				{
					strValorNuevo=tipoparametroformularioiva.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoParametroFormularioIvaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(tipoparametroformularioiva.getIsNew()||!tipoparametroformularioiva.getcodigo_sri().equals(tipoparametroformularioiva.getTipoParametroFormularioIvaOriginal().getcodigo_sri()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoparametroformularioiva.getTipoParametroFormularioIvaOriginal().getcodigo_sri()!=null)
				{
					strValorActual=tipoparametroformularioiva.getTipoParametroFormularioIvaOriginal().getcodigo_sri();
				}
				if(tipoparametroformularioiva.getcodigo_sri()!=null)
				{
					strValorNuevo=tipoparametroformularioiva.getcodigo_sri() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoParametroFormularioIvaConstantesFunciones.CODIGOSRI,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoParametroFormularioIvaRelacionesWithConnection(TipoParametroFormularioIva tipoparametroformularioiva,List<ParametroFormularioIva> parametroformularioivas) throws Exception {

		if(!tipoparametroformularioiva.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoParametroFormularioIvaRelacionesBase(tipoparametroformularioiva,parametroformularioivas,true);
		}
	}

	public void saveTipoParametroFormularioIvaRelaciones(TipoParametroFormularioIva tipoparametroformularioiva,List<ParametroFormularioIva> parametroformularioivas)throws Exception {

		if(!tipoparametroformularioiva.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoParametroFormularioIvaRelacionesBase(tipoparametroformularioiva,parametroformularioivas,false);
		}
	}

	public void saveTipoParametroFormularioIvaRelacionesBase(TipoParametroFormularioIva tipoparametroformularioiva,List<ParametroFormularioIva> parametroformularioivas,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoParametroFormularioIva-saveRelacionesWithConnection");}
	
			tipoparametroformularioiva.setParametroFormularioIvas(parametroformularioivas);

			this.setTipoParametroFormularioIva(tipoparametroformularioiva);

				if((tipoparametroformularioiva.getIsNew()||tipoparametroformularioiva.getIsChanged())&&!tipoparametroformularioiva.getIsDeleted()) {
					this.saveTipoParametroFormularioIva();
					this.saveTipoParametroFormularioIvaRelacionesDetalles(parametroformularioivas);

				} else if(tipoparametroformularioiva.getIsDeleted()) {
					this.saveTipoParametroFormularioIvaRelacionesDetalles(parametroformularioivas);
					this.saveTipoParametroFormularioIva();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ParametroFormularioIvaConstantesFunciones.InicializarGeneralEntityAuxiliaresParametroFormularioIvas(parametroformularioivas,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoParametroFormularioIvaRelacionesDetalles(List<ParametroFormularioIva> parametroformularioivas)throws Exception {
		try {
	

			Long idTipoParametroFormularioIvaActual=this.getTipoParametroFormularioIva().getId();

			ParametroFormularioIvaLogic parametroformularioivaLogic_Desde_TipoParametroFormularioIva=new ParametroFormularioIvaLogic();
			parametroformularioivaLogic_Desde_TipoParametroFormularioIva.setParametroFormularioIvas(parametroformularioivas);

			parametroformularioivaLogic_Desde_TipoParametroFormularioIva.setConnexion(this.getConnexion());
			parametroformularioivaLogic_Desde_TipoParametroFormularioIva.setDatosCliente(this.datosCliente);

			for(ParametroFormularioIva parametroformularioiva_Desde_TipoParametroFormularioIva:parametroformularioivaLogic_Desde_TipoParametroFormularioIva.getParametroFormularioIvas()) {
				parametroformularioiva_Desde_TipoParametroFormularioIva.setid_tipo_parametro_formulario_iva(idTipoParametroFormularioIvaActual);

				parametroformularioivaLogic_Desde_TipoParametroFormularioIva.setParametroFormularioIva(parametroformularioiva_Desde_TipoParametroFormularioIva);
				parametroformularioivaLogic_Desde_TipoParametroFormularioIva.saveParametroFormularioIva();

				Long idParametroFormularioIvaActual=parametroformularioiva_Desde_TipoParametroFormularioIva.getId();

				FormularioRentaLogic formulariorentaLogic_Desde_ParametroFormularioIva=new FormularioRentaLogic();

				if(parametroformularioiva_Desde_TipoParametroFormularioIva.getFormularioRentas()==null){
					parametroformularioiva_Desde_TipoParametroFormularioIva.setFormularioRentas(new ArrayList<FormularioRenta>());
				}

				formulariorentaLogic_Desde_ParametroFormularioIva.setFormularioRentas(parametroformularioiva_Desde_TipoParametroFormularioIva.getFormularioRentas());

				formulariorentaLogic_Desde_ParametroFormularioIva.setConnexion(this.getConnexion());
				formulariorentaLogic_Desde_ParametroFormularioIva.setDatosCliente(this.datosCliente);

				for(FormularioRenta formulariorenta_Desde_ParametroFormularioIva:formulariorentaLogic_Desde_ParametroFormularioIva.getFormularioRentas()) {
					formulariorenta_Desde_ParametroFormularioIva.setid_parametro_formulario_iva(idParametroFormularioIvaActual);
				}

				formulariorentaLogic_Desde_ParametroFormularioIva.saveFormularioRentas();

				FormularioIvaLogic formularioivaLogic_Desde_ParametroFormularioIva=new FormularioIvaLogic();

				if(parametroformularioiva_Desde_TipoParametroFormularioIva.getFormularioIvas()==null){
					parametroformularioiva_Desde_TipoParametroFormularioIva.setFormularioIvas(new ArrayList<FormularioIva>());
				}

				formularioivaLogic_Desde_ParametroFormularioIva.setFormularioIvas(parametroformularioiva_Desde_TipoParametroFormularioIva.getFormularioIvas());

				formularioivaLogic_Desde_ParametroFormularioIva.setConnexion(this.getConnexion());
				formularioivaLogic_Desde_ParametroFormularioIva.setDatosCliente(this.datosCliente);

				for(FormularioIva formularioiva_Desde_ParametroFormularioIva:formularioivaLogic_Desde_ParametroFormularioIva.getFormularioIvas()) {
					formularioiva_Desde_ParametroFormularioIva.setid_parametro_formulario_iva(idParametroFormularioIvaActual);
				}

				formularioivaLogic_Desde_ParametroFormularioIva.saveFormularioIvas();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoParametroFormularioIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoParametroFormularioIvaConstantesFunciones.getClassesForeignKeysOfTipoParametroFormularioIva(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoParametroFormularioIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoParametroFormularioIvaConstantesFunciones.getClassesRelationshipsOfTipoParametroFormularioIva(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

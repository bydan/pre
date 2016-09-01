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
import com.bydan.erp.cartera.util.TipoDocumentoPersonalConstantesFunciones;
import com.bydan.erp.cartera.util.TipoDocumentoPersonalParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoDocumentoPersonalParameterGeneral;
import com.bydan.erp.cartera.business.entity.TipoDocumentoPersonal;
//import com.bydan.erp.cartera.business.logic.TipoDocumentoPersonalLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoDocumentoPersonalLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoDocumentoPersonalLogic.class);
	
	protected TipoDocumentoPersonalDataAccess tipodocumentopersonalDataAccess; 	
	protected TipoDocumentoPersonal tipodocumentopersonal;
	protected List<TipoDocumentoPersonal> tipodocumentopersonals;
	protected Object tipodocumentopersonalObject;	
	protected List<Object> tipodocumentopersonalsObject;
	
	public static ClassValidator<TipoDocumentoPersonal> tipodocumentopersonalValidator = new ClassValidator<TipoDocumentoPersonal>(TipoDocumentoPersonal.class);	
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
	
	
	
	
	public  TipoDocumentoPersonalLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipodocumentopersonalDataAccess = new TipoDocumentoPersonalDataAccess();
			
			this.tipodocumentopersonals= new ArrayList<TipoDocumentoPersonal>();
			this.tipodocumentopersonal= new TipoDocumentoPersonal();
			
			this.tipodocumentopersonalObject=new Object();
			this.tipodocumentopersonalsObject=new ArrayList<Object>();
				
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
			
			this.tipodocumentopersonalDataAccess.setConnexionType(this.connexionType);
			this.tipodocumentopersonalDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoDocumentoPersonalLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipodocumentopersonalDataAccess = new TipoDocumentoPersonalDataAccess();
			this.tipodocumentopersonals= new ArrayList<TipoDocumentoPersonal>();
			this.tipodocumentopersonal= new TipoDocumentoPersonal();
			this.tipodocumentopersonalObject=new Object();
			this.tipodocumentopersonalsObject=new ArrayList<Object>();
			
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
			
			this.tipodocumentopersonalDataAccess.setConnexionType(this.connexionType);
			this.tipodocumentopersonalDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoDocumentoPersonal getTipoDocumentoPersonal() throws Exception {	
		//TipoDocumentoPersonalLogicAdditional.checkTipoDocumentoPersonalToGet(tipodocumentopersonal,this.datosCliente,this.arrDatoGeneral);
		//TipoDocumentoPersonalLogicAdditional.updateTipoDocumentoPersonalToGet(tipodocumentopersonal,this.arrDatoGeneral);
		
		return tipodocumentopersonal;
	}
		
	public void setTipoDocumentoPersonal(TipoDocumentoPersonal newTipoDocumentoPersonal) {
		this.tipodocumentopersonal = newTipoDocumentoPersonal;
	}
	
	public TipoDocumentoPersonalDataAccess getTipoDocumentoPersonalDataAccess() {
		return tipodocumentopersonalDataAccess;
	}
	
	public void setTipoDocumentoPersonalDataAccess(TipoDocumentoPersonalDataAccess newtipodocumentopersonalDataAccess) {
		this.tipodocumentopersonalDataAccess = newtipodocumentopersonalDataAccess;
	}
	
	public List<TipoDocumentoPersonal> getTipoDocumentoPersonals() throws Exception {		
		this.quitarTipoDocumentoPersonalsNulos();
		
		//TipoDocumentoPersonalLogicAdditional.checkTipoDocumentoPersonalToGets(tipodocumentopersonals,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoDocumentoPersonal tipodocumentopersonalLocal: tipodocumentopersonals ) {
			//TipoDocumentoPersonalLogicAdditional.updateTipoDocumentoPersonalToGet(tipodocumentopersonalLocal,this.arrDatoGeneral);
		}
		
		return tipodocumentopersonals;
	}
	
	public void setTipoDocumentoPersonals(List<TipoDocumentoPersonal> newTipoDocumentoPersonals) {
		this.tipodocumentopersonals = newTipoDocumentoPersonals;
	}
	
	public Object getTipoDocumentoPersonalObject() {	
		this.tipodocumentopersonalObject=this.tipodocumentopersonalDataAccess.getEntityObject();
		return this.tipodocumentopersonalObject;
	}
		
	public void setTipoDocumentoPersonalObject(Object newTipoDocumentoPersonalObject) {
		this.tipodocumentopersonalObject = newTipoDocumentoPersonalObject;
	}
	
	public List<Object> getTipoDocumentoPersonalsObject() {		
		this.tipodocumentopersonalsObject=this.tipodocumentopersonalDataAccess.getEntitiesObject();
		return this.tipodocumentopersonalsObject;
	}
		
	public void setTipoDocumentoPersonalsObject(List<Object> newTipoDocumentoPersonalsObject) {
		this.tipodocumentopersonalsObject = newTipoDocumentoPersonalsObject;
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
		
		if(this.tipodocumentopersonalDataAccess!=null) {
			this.tipodocumentopersonalDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumentoPersonal.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipodocumentopersonalDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipodocumentopersonalDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipodocumentopersonal = new  TipoDocumentoPersonal();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumentoPersonal.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipodocumentopersonal=tipodocumentopersonalDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodocumentopersonal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDocumentoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoPersonal(this.tipodocumentopersonal);
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
		tipodocumentopersonal = new  TipoDocumentoPersonal();
		  		  
        try {
			
			tipodocumentopersonal=tipodocumentopersonalDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodocumentopersonal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDocumentoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoPersonal(this.tipodocumentopersonal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipodocumentopersonal = new  TipoDocumentoPersonal();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumentoPersonal.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipodocumentopersonal=tipodocumentopersonalDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodocumentopersonal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDocumentoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoPersonal(this.tipodocumentopersonal);
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
		tipodocumentopersonal = new  TipoDocumentoPersonal();
		  		  
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
		tipodocumentopersonal = new  TipoDocumentoPersonal();
		  		  
        try {
			
			tipodocumentopersonal=tipodocumentopersonalDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodocumentopersonal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDocumentoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoPersonal(this.tipodocumentopersonal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipodocumentopersonal = new  TipoDocumentoPersonal();
		  		  
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
		tipodocumentopersonal = new  TipoDocumentoPersonal();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumentoPersonal.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipodocumentopersonalDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipodocumentopersonal = new  TipoDocumentoPersonal();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipodocumentopersonalDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipodocumentopersonal = new  TipoDocumentoPersonal();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumentoPersonal.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipodocumentopersonalDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipodocumentopersonal = new  TipoDocumentoPersonal();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipodocumentopersonalDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipodocumentopersonal = new  TipoDocumentoPersonal();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumentoPersonal.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipodocumentopersonalDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipodocumentopersonal = new  TipoDocumentoPersonal();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipodocumentopersonalDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipodocumentopersonals = new  ArrayList<TipoDocumentoPersonal>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumentoPersonal.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoDocumentoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodocumentopersonals=tipodocumentopersonalDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDocumentoPersonal(tipodocumentopersonals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDocumentoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoPersonal(this.tipodocumentopersonals);
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
		tipodocumentopersonals = new  ArrayList<TipoDocumentoPersonal>();
		  		  
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
		tipodocumentopersonals = new  ArrayList<TipoDocumentoPersonal>();
		  		  
        try {			
			TipoDocumentoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodocumentopersonals=tipodocumentopersonalDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoDocumentoPersonal(tipodocumentopersonals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDocumentoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoPersonal(this.tipodocumentopersonals);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipodocumentopersonals = new  ArrayList<TipoDocumentoPersonal>();
		  		  
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
		tipodocumentopersonals = new  ArrayList<TipoDocumentoPersonal>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumentoPersonal.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoDocumentoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodocumentopersonals=tipodocumentopersonalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDocumentoPersonal(tipodocumentopersonals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDocumentoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoPersonal(this.tipodocumentopersonals);
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
		tipodocumentopersonals = new  ArrayList<TipoDocumentoPersonal>();
		  		  
        try {
			TipoDocumentoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodocumentopersonals=tipodocumentopersonalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDocumentoPersonal(tipodocumentopersonals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDocumentoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoPersonal(this.tipodocumentopersonals);
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
		tipodocumentopersonals = new  ArrayList<TipoDocumentoPersonal>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumentoPersonal.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDocumentoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodocumentopersonals=tipodocumentopersonalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDocumentoPersonal(tipodocumentopersonals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDocumentoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoPersonal(this.tipodocumentopersonals);
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
		tipodocumentopersonals = new  ArrayList<TipoDocumentoPersonal>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDocumentoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodocumentopersonals=tipodocumentopersonalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDocumentoPersonal(tipodocumentopersonals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDocumentoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoPersonal(this.tipodocumentopersonals);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipodocumentopersonal = new  TipoDocumentoPersonal();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumentoPersonal.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDocumentoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodocumentopersonal=tipodocumentopersonalDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDocumentoPersonal(tipodocumentopersonal);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDocumentoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoPersonal(this.tipodocumentopersonal);
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
		tipodocumentopersonal = new  TipoDocumentoPersonal();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDocumentoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodocumentopersonal=tipodocumentopersonalDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDocumentoPersonal(tipodocumentopersonal);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDocumentoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoPersonal(this.tipodocumentopersonal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoDocumentoPersonalsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipodocumentopersonals = new  ArrayList<TipoDocumentoPersonal>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumentoPersonal.class.getSimpleName()+"-getTodosTipoDocumentoPersonalsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDocumentoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodocumentopersonals=tipodocumentopersonalDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoDocumentoPersonal(tipodocumentopersonals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDocumentoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoPersonal(this.tipodocumentopersonals);
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
	
	public  void  getTodosTipoDocumentoPersonals(String sFinalQuery,Pagination pagination)throws Exception {
		tipodocumentopersonals = new  ArrayList<TipoDocumentoPersonal>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDocumentoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodocumentopersonals=tipodocumentopersonalDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoDocumentoPersonal(tipodocumentopersonals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDocumentoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoPersonal(this.tipodocumentopersonals);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoDocumentoPersonal(TipoDocumentoPersonal tipodocumentopersonal) throws Exception {
		Boolean estaValidado=false;
		
		if(tipodocumentopersonal.getIsNew() || tipodocumentopersonal.getIsChanged()) { 
			this.invalidValues = tipodocumentopersonalValidator.getInvalidValues(tipodocumentopersonal);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipodocumentopersonal);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoDocumentoPersonal(List<TipoDocumentoPersonal> TipoDocumentoPersonals) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoDocumentoPersonal tipodocumentopersonalLocal:tipodocumentopersonals) {				
			estaValidadoObjeto=this.validarGuardarTipoDocumentoPersonal(tipodocumentopersonalLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoDocumentoPersonal(List<TipoDocumentoPersonal> TipoDocumentoPersonals) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoDocumentoPersonal(tipodocumentopersonals)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoDocumentoPersonal(TipoDocumentoPersonal TipoDocumentoPersonal) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoDocumentoPersonal(tipodocumentopersonal)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoDocumentoPersonal tipodocumentopersonal) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipodocumentopersonal.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoDocumentoPersonalConstantesFunciones.getTipoDocumentoPersonalLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipodocumentopersonal","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoDocumentoPersonalConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoDocumentoPersonalConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoDocumentoPersonalWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumentoPersonal.class.getSimpleName()+"-saveTipoDocumentoPersonalWithConnection");connexion.begin();			
			
			//TipoDocumentoPersonalLogicAdditional.checkTipoDocumentoPersonalToSave(this.tipodocumentopersonal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoDocumentoPersonalLogicAdditional.updateTipoDocumentoPersonalToSave(this.tipodocumentopersonal,this.arrDatoGeneral);
			
			TipoDocumentoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipodocumentopersonal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoDocumentoPersonal();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoDocumentoPersonal(this.tipodocumentopersonal)) {
				TipoDocumentoPersonalDataAccess.save(this.tipodocumentopersonal, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipodocumentopersonal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoDocumentoPersonalLogicAdditional.checkTipoDocumentoPersonalToSaveAfter(this.tipodocumentopersonal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoDocumentoPersonal();
			
			connexion.commit();			
			
			if(this.tipodocumentopersonal.getIsDeleted()) {
				this.tipodocumentopersonal=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoDocumentoPersonal()throws Exception {	
		try {	
			
			//TipoDocumentoPersonalLogicAdditional.checkTipoDocumentoPersonalToSave(this.tipodocumentopersonal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoDocumentoPersonalLogicAdditional.updateTipoDocumentoPersonalToSave(this.tipodocumentopersonal,this.arrDatoGeneral);
			
			TipoDocumentoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipodocumentopersonal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoDocumentoPersonal(this.tipodocumentopersonal)) {			
				TipoDocumentoPersonalDataAccess.save(this.tipodocumentopersonal, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipodocumentopersonal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoDocumentoPersonalLogicAdditional.checkTipoDocumentoPersonalToSaveAfter(this.tipodocumentopersonal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipodocumentopersonal.getIsDeleted()) {
				this.tipodocumentopersonal=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoDocumentoPersonalsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumentoPersonal.class.getSimpleName()+"-saveTipoDocumentoPersonalsWithConnection");connexion.begin();			
			
			//TipoDocumentoPersonalLogicAdditional.checkTipoDocumentoPersonalToSaves(tipodocumentopersonals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoDocumentoPersonals();
			
			Boolean validadoTodosTipoDocumentoPersonal=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoDocumentoPersonal tipodocumentopersonalLocal:tipodocumentopersonals) {		
				if(tipodocumentopersonalLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoDocumentoPersonalLogicAdditional.updateTipoDocumentoPersonalToSave(tipodocumentopersonalLocal,this.arrDatoGeneral);
	        	
				TipoDocumentoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipodocumentopersonalLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoDocumentoPersonal(tipodocumentopersonalLocal)) {
					TipoDocumentoPersonalDataAccess.save(tipodocumentopersonalLocal, connexion);				
				} else {
					validadoTodosTipoDocumentoPersonal=false;
				}
			}
			
			if(!validadoTodosTipoDocumentoPersonal) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoDocumentoPersonalLogicAdditional.checkTipoDocumentoPersonalToSavesAfter(tipodocumentopersonals,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoDocumentoPersonals();
			
			connexion.commit();		
			
			this.quitarTipoDocumentoPersonalsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoDocumentoPersonals()throws Exception {				
		 try {	
			//TipoDocumentoPersonalLogicAdditional.checkTipoDocumentoPersonalToSaves(tipodocumentopersonals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoDocumentoPersonal=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoDocumentoPersonal tipodocumentopersonalLocal:tipodocumentopersonals) {				
				if(tipodocumentopersonalLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoDocumentoPersonalLogicAdditional.updateTipoDocumentoPersonalToSave(tipodocumentopersonalLocal,this.arrDatoGeneral);
	        	
				TipoDocumentoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipodocumentopersonalLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoDocumentoPersonal(tipodocumentopersonalLocal)) {				
					TipoDocumentoPersonalDataAccess.save(tipodocumentopersonalLocal, connexion);				
				} else {
					validadoTodosTipoDocumentoPersonal=false;
				}
			}
			
			if(!validadoTodosTipoDocumentoPersonal) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoDocumentoPersonalLogicAdditional.checkTipoDocumentoPersonalToSavesAfter(tipodocumentopersonals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoDocumentoPersonalsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoDocumentoPersonalParameterReturnGeneral procesarAccionTipoDocumentoPersonals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoDocumentoPersonal> tipodocumentopersonals,TipoDocumentoPersonalParameterReturnGeneral tipodocumentopersonalParameterGeneral)throws Exception {
		 try {	
			TipoDocumentoPersonalParameterReturnGeneral tipodocumentopersonalReturnGeneral=new TipoDocumentoPersonalParameterReturnGeneral();
	
			
			return tipodocumentopersonalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoDocumentoPersonalParameterReturnGeneral procesarAccionTipoDocumentoPersonalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoDocumentoPersonal> tipodocumentopersonals,TipoDocumentoPersonalParameterReturnGeneral tipodocumentopersonalParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumentoPersonal.class.getSimpleName()+"-procesarAccionTipoDocumentoPersonalsWithConnection");connexion.begin();			
			
			TipoDocumentoPersonalParameterReturnGeneral tipodocumentopersonalReturnGeneral=new TipoDocumentoPersonalParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipodocumentopersonalReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoDocumentoPersonalParameterReturnGeneral procesarEventosTipoDocumentoPersonals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoDocumentoPersonal> tipodocumentopersonals,TipoDocumentoPersonal tipodocumentopersonal,TipoDocumentoPersonalParameterReturnGeneral tipodocumentopersonalParameterGeneral,Boolean isEsNuevoTipoDocumentoPersonal,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoDocumentoPersonalParameterReturnGeneral tipodocumentopersonalReturnGeneral=new TipoDocumentoPersonalParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipodocumentopersonalReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipodocumentopersonalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoDocumentoPersonalParameterReturnGeneral procesarEventosTipoDocumentoPersonalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoDocumentoPersonal> tipodocumentopersonals,TipoDocumentoPersonal tipodocumentopersonal,TipoDocumentoPersonalParameterReturnGeneral tipodocumentopersonalParameterGeneral,Boolean isEsNuevoTipoDocumentoPersonal,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumentoPersonal.class.getSimpleName()+"-procesarEventosTipoDocumentoPersonalsWithConnection");connexion.begin();			
			
			TipoDocumentoPersonalParameterReturnGeneral tipodocumentopersonalReturnGeneral=new TipoDocumentoPersonalParameterReturnGeneral();
	
			tipodocumentopersonalReturnGeneral.setTipoDocumentoPersonal(tipodocumentopersonal);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipodocumentopersonalReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipodocumentopersonalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoDocumentoPersonalParameterReturnGeneral procesarImportacionTipoDocumentoPersonalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoDocumentoPersonalParameterReturnGeneral tipodocumentopersonalParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumentoPersonal.class.getSimpleName()+"-procesarImportacionTipoDocumentoPersonalsWithConnection");connexion.begin();			
			
			TipoDocumentoPersonalParameterReturnGeneral tipodocumentopersonalReturnGeneral=new TipoDocumentoPersonalParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipodocumentopersonals=new ArrayList<TipoDocumentoPersonal>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipodocumentopersonal=new TipoDocumentoPersonal();
				
				
				if(conColumnasBase) {this.tipodocumentopersonal.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipodocumentopersonal.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipodocumentopersonal.setcodigo(arrColumnas[iColumn++]);
				this.tipodocumentopersonal.setnombre(arrColumnas[iColumn++]);
				
				this.tipodocumentopersonals.add(this.tipodocumentopersonal);
			}
			
			this.saveTipoDocumentoPersonals();
			
			this.connexion.commit();
			
			tipodocumentopersonalReturnGeneral.setConRetornoEstaProcesado(true);
			tipodocumentopersonalReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipodocumentopersonalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoDocumentoPersonalsEliminados() throws Exception {				
		
		List<TipoDocumentoPersonal> tipodocumentopersonalsAux= new ArrayList<TipoDocumentoPersonal>();
		
		for(TipoDocumentoPersonal tipodocumentopersonal:tipodocumentopersonals) {
			if(!tipodocumentopersonal.getIsDeleted()) {
				tipodocumentopersonalsAux.add(tipodocumentopersonal);
			}
		}
		
		tipodocumentopersonals=tipodocumentopersonalsAux;
	}
	
	public void quitarTipoDocumentoPersonalsNulos() throws Exception {				
		
		List<TipoDocumentoPersonal> tipodocumentopersonalsAux= new ArrayList<TipoDocumentoPersonal>();
		
		for(TipoDocumentoPersonal tipodocumentopersonal : this.tipodocumentopersonals) {
			if(tipodocumentopersonal==null) {
				tipodocumentopersonalsAux.add(tipodocumentopersonal);
			}
		}
		
		//this.tipodocumentopersonals=tipodocumentopersonalsAux;
		
		this.tipodocumentopersonals.removeAll(tipodocumentopersonalsAux);
	}
	
	public void getSetVersionRowTipoDocumentoPersonalWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipodocumentopersonal.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipodocumentopersonal.getIsDeleted() || (tipodocumentopersonal.getIsChanged()&&!tipodocumentopersonal.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipodocumentopersonalDataAccess.getSetVersionRowTipoDocumentoPersonal(connexion,tipodocumentopersonal.getId());
				
				if(!tipodocumentopersonal.getVersionRow().equals(timestamp)) {	
					tipodocumentopersonal.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipodocumentopersonal.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoDocumentoPersonal()throws Exception {	
		
		if(tipodocumentopersonal.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipodocumentopersonal.getIsDeleted() || (tipodocumentopersonal.getIsChanged()&&!tipodocumentopersonal.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipodocumentopersonalDataAccess.getSetVersionRowTipoDocumentoPersonal(connexion,tipodocumentopersonal.getId());
			
			try {							
				if(!tipodocumentopersonal.getVersionRow().equals(timestamp)) {	
					tipodocumentopersonal.setVersionRow(timestamp);
				}
				
				tipodocumentopersonal.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoDocumentoPersonalsWithConnection()throws Exception {	
		if(tipodocumentopersonals!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoDocumentoPersonal tipodocumentopersonalAux:tipodocumentopersonals) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipodocumentopersonalAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipodocumentopersonalAux.getIsDeleted() || (tipodocumentopersonalAux.getIsChanged()&&!tipodocumentopersonalAux.getIsNew())) {
						
						timestamp=tipodocumentopersonalDataAccess.getSetVersionRowTipoDocumentoPersonal(connexion,tipodocumentopersonalAux.getId());
						
						if(!tipodocumentopersonal.getVersionRow().equals(timestamp)) {	
							tipodocumentopersonalAux.setVersionRow(timestamp);
						}
								
						tipodocumentopersonalAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoDocumentoPersonals()throws Exception {	
		if(tipodocumentopersonals!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoDocumentoPersonal tipodocumentopersonalAux:tipodocumentopersonals) {
					if(tipodocumentopersonalAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipodocumentopersonalAux.getIsDeleted() || (tipodocumentopersonalAux.getIsChanged()&&!tipodocumentopersonalAux.getIsNew())) {
						
						timestamp=tipodocumentopersonalDataAccess.getSetVersionRowTipoDocumentoPersonal(connexion,tipodocumentopersonalAux.getId());
						
						if(!tipodocumentopersonalAux.getVersionRow().equals(timestamp)) {	
							tipodocumentopersonalAux.setVersionRow(timestamp);
						}
						
													
						tipodocumentopersonalAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoDocumentoPersonalParameterReturnGeneral cargarCombosLoteForeignKeyTipoDocumentoPersonalWithConnection(String finalQueryGlobalPais) throws Exception {
		TipoDocumentoPersonalParameterReturnGeneral  tipodocumentopersonalReturnGeneral =new TipoDocumentoPersonalParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumentoPersonal.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoDocumentoPersonalWithConnection");connexion.begin();
			
			tipodocumentopersonalReturnGeneral =new TipoDocumentoPersonalParameterReturnGeneral();
			
			

			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			tipodocumentopersonalReturnGeneral.setpaissForeignKey(paissForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipodocumentopersonalReturnGeneral;
	}
	
	public TipoDocumentoPersonalParameterReturnGeneral cargarCombosLoteForeignKeyTipoDocumentoPersonal(String finalQueryGlobalPais) throws Exception {
		TipoDocumentoPersonalParameterReturnGeneral  tipodocumentopersonalReturnGeneral =new TipoDocumentoPersonalParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipodocumentopersonalReturnGeneral =new TipoDocumentoPersonalParameterReturnGeneral();
			
			

			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			tipodocumentopersonalReturnGeneral.setpaissForeignKey(paissForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipodocumentopersonalReturnGeneral;
	}
	
	
	public void deepLoad(TipoDocumentoPersonal tipodocumentopersonal,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoDocumentoPersonalLogicAdditional.updateTipoDocumentoPersonalToGet(tipodocumentopersonal,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipodocumentopersonal.setPais(tipodocumentopersonalDataAccess.getPais(connexion,tipodocumentopersonal));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				tipodocumentopersonal.setPais(tipodocumentopersonalDataAccess.getPais(connexion,tipodocumentopersonal));
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
			tipodocumentopersonal.setPais(tipodocumentopersonalDataAccess.getPais(connexion,tipodocumentopersonal));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipodocumentopersonal.setPais(tipodocumentopersonalDataAccess.getPais(connexion,tipodocumentopersonal));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(tipodocumentopersonal.getPais(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				tipodocumentopersonal.setPais(tipodocumentopersonalDataAccess.getPais(connexion,tipodocumentopersonal));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(tipodocumentopersonal.getPais(),isDeep,deepLoadType,clases);				
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
			tipodocumentopersonal.setPais(tipodocumentopersonalDataAccess.getPais(connexion,tipodocumentopersonal));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(tipodocumentopersonal.getPais(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoDocumentoPersonal tipodocumentopersonal,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoDocumentoPersonal.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipodocumentopersonal,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoDocumentoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoPersonal(tipodocumentopersonal);
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
			this.deepLoad(this.tipodocumentopersonal,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoDocumentoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoPersonal(this.tipodocumentopersonal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoDocumentoPersonal.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipodocumentopersonals!=null) {
				for(TipoDocumentoPersonal tipodocumentopersonal:tipodocumentopersonals) {
					this.deepLoad(tipodocumentopersonal,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoDocumentoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoPersonal(tipodocumentopersonals);
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
			if(tipodocumentopersonals!=null) {
				for(TipoDocumentoPersonal tipodocumentopersonal:tipodocumentopersonals) {
					this.deepLoad(tipodocumentopersonal,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoDocumentoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoPersonal(tipodocumentopersonals);
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
	
	
	public void getTipoDocumentoPersonalsFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDocumentoPersonal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,TipoDocumentoPersonalConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			TipoDocumentoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodocumentopersonals=tipodocumentopersonalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDocumentoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoPersonal(this.tipodocumentopersonals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoDocumentoPersonalsFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,TipoDocumentoPersonalConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			TipoDocumentoPersonalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodocumentopersonals=tipodocumentopersonalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDocumentoPersonalConstantesFunciones.refrescarForeignKeysDescripcionesTipoDocumentoPersonal(this.tipodocumentopersonals);
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
			if(TipoDocumentoPersonalConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDocumentoPersonalDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoDocumentoPersonal tipodocumentopersonal,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoDocumentoPersonalConstantesFunciones.ISCONAUDITORIA) {
				if(tipodocumentopersonal.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDocumentoPersonalDataAccess.TABLENAME, tipodocumentopersonal.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoDocumentoPersonalConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoDocumentoPersonalLogic.registrarAuditoriaDetallesTipoDocumentoPersonal(connexion,tipodocumentopersonal,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipodocumentopersonal.getIsDeleted()) {
					/*if(!tipodocumentopersonal.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoDocumentoPersonalDataAccess.TABLENAME, tipodocumentopersonal.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoDocumentoPersonalLogic.registrarAuditoriaDetallesTipoDocumentoPersonal(connexion,tipodocumentopersonal,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDocumentoPersonalDataAccess.TABLENAME, tipodocumentopersonal.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipodocumentopersonal.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDocumentoPersonalDataAccess.TABLENAME, tipodocumentopersonal.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoDocumentoPersonalConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoDocumentoPersonalLogic.registrarAuditoriaDetallesTipoDocumentoPersonal(connexion,tipodocumentopersonal,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoDocumentoPersonal(Connexion connexion,TipoDocumentoPersonal tipodocumentopersonal)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipodocumentopersonal.getIsNew()||!tipodocumentopersonal.getid_pais().equals(tipodocumentopersonal.getTipoDocumentoPersonalOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodocumentopersonal.getTipoDocumentoPersonalOriginal().getid_pais()!=null)
				{
					strValorActual=tipodocumentopersonal.getTipoDocumentoPersonalOriginal().getid_pais().toString();
				}
				if(tipodocumentopersonal.getid_pais()!=null)
				{
					strValorNuevo=tipodocumentopersonal.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDocumentoPersonalConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(tipodocumentopersonal.getIsNew()||!tipodocumentopersonal.getcodigo().equals(tipodocumentopersonal.getTipoDocumentoPersonalOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodocumentopersonal.getTipoDocumentoPersonalOriginal().getcodigo()!=null)
				{
					strValorActual=tipodocumentopersonal.getTipoDocumentoPersonalOriginal().getcodigo();
				}
				if(tipodocumentopersonal.getcodigo()!=null)
				{
					strValorNuevo=tipodocumentopersonal.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDocumentoPersonalConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipodocumentopersonal.getIsNew()||!tipodocumentopersonal.getnombre().equals(tipodocumentopersonal.getTipoDocumentoPersonalOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodocumentopersonal.getTipoDocumentoPersonalOriginal().getnombre()!=null)
				{
					strValorActual=tipodocumentopersonal.getTipoDocumentoPersonalOriginal().getnombre();
				}
				if(tipodocumentopersonal.getnombre()!=null)
				{
					strValorNuevo=tipodocumentopersonal.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDocumentoPersonalConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoDocumentoPersonal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoDocumentoPersonalConstantesFunciones.getClassesForeignKeysOfTipoDocumentoPersonal(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDocumentoPersonal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoDocumentoPersonalConstantesFunciones.getClassesRelationshipsOfTipoDocumentoPersonal(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

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
import com.bydan.erp.contabilidad.util.DatoFormularioIvaConstantesFunciones;
import com.bydan.erp.contabilidad.util.DatoFormularioIvaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.DatoFormularioIvaParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.DatoFormularioIva;
import com.bydan.erp.contabilidad.business.logic.DatoFormularioIvaLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class DatoFormularioIvaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DatoFormularioIvaLogic.class);
	
	protected DatoFormularioIvaDataAccess datoformularioivaDataAccess; 	
	protected DatoFormularioIva datoformularioiva;
	protected List<DatoFormularioIva> datoformularioivas;
	protected Object datoformularioivaObject;	
	protected List<Object> datoformularioivasObject;
	
	public static ClassValidator<DatoFormularioIva> datoformularioivaValidator = new ClassValidator<DatoFormularioIva>(DatoFormularioIva.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DatoFormularioIvaLogicAdditional datoformularioivaLogicAdditional=null;
	
	public DatoFormularioIvaLogicAdditional getDatoFormularioIvaLogicAdditional() {
		return this.datoformularioivaLogicAdditional;
	}
	
	public void setDatoFormularioIvaLogicAdditional(DatoFormularioIvaLogicAdditional datoformularioivaLogicAdditional) {
		try {
			this.datoformularioivaLogicAdditional=datoformularioivaLogicAdditional;
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
	
	
	
	
	public  DatoFormularioIvaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.datoformularioivaDataAccess = new DatoFormularioIvaDataAccess();
			
			this.datoformularioivas= new ArrayList<DatoFormularioIva>();
			this.datoformularioiva= new DatoFormularioIva();
			
			this.datoformularioivaObject=new Object();
			this.datoformularioivasObject=new ArrayList<Object>();
				
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
			
			this.datoformularioivaDataAccess.setConnexionType(this.connexionType);
			this.datoformularioivaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DatoFormularioIvaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.datoformularioivaDataAccess = new DatoFormularioIvaDataAccess();
			this.datoformularioivas= new ArrayList<DatoFormularioIva>();
			this.datoformularioiva= new DatoFormularioIva();
			this.datoformularioivaObject=new Object();
			this.datoformularioivasObject=new ArrayList<Object>();
			
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
			
			this.datoformularioivaDataAccess.setConnexionType(this.connexionType);
			this.datoformularioivaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DatoFormularioIva getDatoFormularioIva() throws Exception {	
		DatoFormularioIvaLogicAdditional.checkDatoFormularioIvaToGet(datoformularioiva,this.datosCliente,this.arrDatoGeneral);
		DatoFormularioIvaLogicAdditional.updateDatoFormularioIvaToGet(datoformularioiva,this.arrDatoGeneral);
		
		return datoformularioiva;
	}
		
	public void setDatoFormularioIva(DatoFormularioIva newDatoFormularioIva) {
		this.datoformularioiva = newDatoFormularioIva;
	}
	
	public DatoFormularioIvaDataAccess getDatoFormularioIvaDataAccess() {
		return datoformularioivaDataAccess;
	}
	
	public void setDatoFormularioIvaDataAccess(DatoFormularioIvaDataAccess newdatoformularioivaDataAccess) {
		this.datoformularioivaDataAccess = newdatoformularioivaDataAccess;
	}
	
	public List<DatoFormularioIva> getDatoFormularioIvas() throws Exception {		
		this.quitarDatoFormularioIvasNulos();
		
		DatoFormularioIvaLogicAdditional.checkDatoFormularioIvaToGets(datoformularioivas,this.datosCliente,this.arrDatoGeneral);
		
		for (DatoFormularioIva datoformularioivaLocal: datoformularioivas ) {
			DatoFormularioIvaLogicAdditional.updateDatoFormularioIvaToGet(datoformularioivaLocal,this.arrDatoGeneral);
		}
		
		return datoformularioivas;
	}
	
	public void setDatoFormularioIvas(List<DatoFormularioIva> newDatoFormularioIvas) {
		this.datoformularioivas = newDatoFormularioIvas;
	}
	
	public Object getDatoFormularioIvaObject() {	
		this.datoformularioivaObject=this.datoformularioivaDataAccess.getEntityObject();
		return this.datoformularioivaObject;
	}
		
	public void setDatoFormularioIvaObject(Object newDatoFormularioIvaObject) {
		this.datoformularioivaObject = newDatoFormularioIvaObject;
	}
	
	public List<Object> getDatoFormularioIvasObject() {		
		this.datoformularioivasObject=this.datoformularioivaDataAccess.getEntitiesObject();
		return this.datoformularioivasObject;
	}
		
	public void setDatoFormularioIvasObject(List<Object> newDatoFormularioIvasObject) {
		this.datoformularioivasObject = newDatoFormularioIvasObject;
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
		
		if(this.datoformularioivaDataAccess!=null) {
			this.datoformularioivaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioIva.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			datoformularioivaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			datoformularioivaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		datoformularioiva = new  DatoFormularioIva();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioIva.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			datoformularioiva=datoformularioivaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.datoformularioiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DatoFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioIva(this.datoformularioiva);
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
		datoformularioiva = new  DatoFormularioIva();
		  		  
        try {
			
			datoformularioiva=datoformularioivaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.datoformularioiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DatoFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioIva(this.datoformularioiva);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		datoformularioiva = new  DatoFormularioIva();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioIva.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			datoformularioiva=datoformularioivaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.datoformularioiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DatoFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioIva(this.datoformularioiva);
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
		datoformularioiva = new  DatoFormularioIva();
		  		  
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
		datoformularioiva = new  DatoFormularioIva();
		  		  
        try {
			
			datoformularioiva=datoformularioivaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.datoformularioiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DatoFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioIva(this.datoformularioiva);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		datoformularioiva = new  DatoFormularioIva();
		  		  
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
		datoformularioiva = new  DatoFormularioIva();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioIva.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =datoformularioivaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		datoformularioiva = new  DatoFormularioIva();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=datoformularioivaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		datoformularioiva = new  DatoFormularioIva();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioIva.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =datoformularioivaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		datoformularioiva = new  DatoFormularioIva();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=datoformularioivaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		datoformularioiva = new  DatoFormularioIva();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioIva.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =datoformularioivaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		datoformularioiva = new  DatoFormularioIva();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=datoformularioivaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		datoformularioivas = new  ArrayList<DatoFormularioIva>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioIva.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DatoFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datoformularioivas=datoformularioivaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDatoFormularioIva(datoformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioIva(this.datoformularioivas);
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
		datoformularioivas = new  ArrayList<DatoFormularioIva>();
		  		  
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
		datoformularioivas = new  ArrayList<DatoFormularioIva>();
		  		  
        try {			
			DatoFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datoformularioivas=datoformularioivaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDatoFormularioIva(datoformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioIva(this.datoformularioivas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		datoformularioivas = new  ArrayList<DatoFormularioIva>();
		  		  
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
		datoformularioivas = new  ArrayList<DatoFormularioIva>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioIva.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DatoFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datoformularioivas=datoformularioivaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDatoFormularioIva(datoformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioIva(this.datoformularioivas);
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
		datoformularioivas = new  ArrayList<DatoFormularioIva>();
		  		  
        try {
			DatoFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datoformularioivas=datoformularioivaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDatoFormularioIva(datoformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioIva(this.datoformularioivas);
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
		datoformularioivas = new  ArrayList<DatoFormularioIva>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioIva.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DatoFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datoformularioivas=datoformularioivaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDatoFormularioIva(datoformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioIva(this.datoformularioivas);
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
		datoformularioivas = new  ArrayList<DatoFormularioIva>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DatoFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datoformularioivas=datoformularioivaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDatoFormularioIva(datoformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioIva(this.datoformularioivas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		datoformularioiva = new  DatoFormularioIva();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioIva.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DatoFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datoformularioiva=datoformularioivaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDatoFormularioIva(datoformularioiva);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioIva(this.datoformularioiva);
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
		datoformularioiva = new  DatoFormularioIva();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DatoFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datoformularioiva=datoformularioivaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDatoFormularioIva(datoformularioiva);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioIva(this.datoformularioiva);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		datoformularioivas = new  ArrayList<DatoFormularioIva>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioIva.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DatoFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datoformularioivas=datoformularioivaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDatoFormularioIva(datoformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioIva(this.datoformularioivas);
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
		datoformularioivas = new  ArrayList<DatoFormularioIva>();
		  		  
        try {
			DatoFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datoformularioivas=datoformularioivaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDatoFormularioIva(datoformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioIva(this.datoformularioivas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDatoFormularioIvasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		datoformularioivas = new  ArrayList<DatoFormularioIva>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioIva.class.getSimpleName()+"-getTodosDatoFormularioIvasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DatoFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datoformularioivas=datoformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDatoFormularioIva(datoformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioIva(this.datoformularioivas);
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
	
	public  void  getTodosDatoFormularioIvas(String sFinalQuery,Pagination pagination)throws Exception {
		datoformularioivas = new  ArrayList<DatoFormularioIva>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DatoFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			datoformularioivas=datoformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDatoFormularioIva(datoformularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DatoFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioIva(this.datoformularioivas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDatoFormularioIva(DatoFormularioIva datoformularioiva) throws Exception {
		Boolean estaValidado=false;
		
		if(datoformularioiva.getIsNew() || datoformularioiva.getIsChanged()) { 
			this.invalidValues = datoformularioivaValidator.getInvalidValues(datoformularioiva);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(datoformularioiva);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDatoFormularioIva(List<DatoFormularioIva> DatoFormularioIvas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DatoFormularioIva datoformularioivaLocal:datoformularioivas) {				
			estaValidadoObjeto=this.validarGuardarDatoFormularioIva(datoformularioivaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDatoFormularioIva(List<DatoFormularioIva> DatoFormularioIvas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDatoFormularioIva(datoformularioivas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDatoFormularioIva(DatoFormularioIva DatoFormularioIva) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDatoFormularioIva(datoformularioiva)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DatoFormularioIva datoformularioiva) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+datoformularioiva.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DatoFormularioIvaConstantesFunciones.getDatoFormularioIvaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"datoformularioiva","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DatoFormularioIvaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DatoFormularioIvaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDatoFormularioIvaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioIva.class.getSimpleName()+"-saveDatoFormularioIvaWithConnection");connexion.begin();			
			
			DatoFormularioIvaLogicAdditional.checkDatoFormularioIvaToSave(this.datoformularioiva,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DatoFormularioIvaLogicAdditional.updateDatoFormularioIvaToSave(this.datoformularioiva,this.arrDatoGeneral);
			
			DatoFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.datoformularioiva,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDatoFormularioIva();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDatoFormularioIva(this.datoformularioiva)) {
				DatoFormularioIvaDataAccess.save(this.datoformularioiva, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.datoformularioiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DatoFormularioIvaLogicAdditional.checkDatoFormularioIvaToSaveAfter(this.datoformularioiva,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDatoFormularioIva();
			
			connexion.commit();			
			
			if(this.datoformularioiva.getIsDeleted()) {
				this.datoformularioiva=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDatoFormularioIva()throws Exception {	
		try {	
			
			DatoFormularioIvaLogicAdditional.checkDatoFormularioIvaToSave(this.datoformularioiva,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DatoFormularioIvaLogicAdditional.updateDatoFormularioIvaToSave(this.datoformularioiva,this.arrDatoGeneral);
			
			DatoFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.datoformularioiva,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDatoFormularioIva(this.datoformularioiva)) {			
				DatoFormularioIvaDataAccess.save(this.datoformularioiva, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.datoformularioiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DatoFormularioIvaLogicAdditional.checkDatoFormularioIvaToSaveAfter(this.datoformularioiva,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.datoformularioiva.getIsDeleted()) {
				this.datoformularioiva=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDatoFormularioIvasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioIva.class.getSimpleName()+"-saveDatoFormularioIvasWithConnection");connexion.begin();			
			
			DatoFormularioIvaLogicAdditional.checkDatoFormularioIvaToSaves(datoformularioivas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDatoFormularioIvas();
			
			Boolean validadoTodosDatoFormularioIva=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DatoFormularioIva datoformularioivaLocal:datoformularioivas) {		
				if(datoformularioivaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DatoFormularioIvaLogicAdditional.updateDatoFormularioIvaToSave(datoformularioivaLocal,this.arrDatoGeneral);
	        	
				DatoFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),datoformularioivaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDatoFormularioIva(datoformularioivaLocal)) {
					DatoFormularioIvaDataAccess.save(datoformularioivaLocal, connexion);				
				} else {
					validadoTodosDatoFormularioIva=false;
				}
			}
			
			if(!validadoTodosDatoFormularioIva) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DatoFormularioIvaLogicAdditional.checkDatoFormularioIvaToSavesAfter(datoformularioivas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDatoFormularioIvas();
			
			connexion.commit();		
			
			this.quitarDatoFormularioIvasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDatoFormularioIvas()throws Exception {				
		 try {	
			DatoFormularioIvaLogicAdditional.checkDatoFormularioIvaToSaves(datoformularioivas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDatoFormularioIva=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DatoFormularioIva datoformularioivaLocal:datoformularioivas) {				
				if(datoformularioivaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DatoFormularioIvaLogicAdditional.updateDatoFormularioIvaToSave(datoformularioivaLocal,this.arrDatoGeneral);
	        	
				DatoFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),datoformularioivaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDatoFormularioIva(datoformularioivaLocal)) {				
					DatoFormularioIvaDataAccess.save(datoformularioivaLocal, connexion);				
				} else {
					validadoTodosDatoFormularioIva=false;
				}
			}
			
			if(!validadoTodosDatoFormularioIva) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DatoFormularioIvaLogicAdditional.checkDatoFormularioIvaToSavesAfter(datoformularioivas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDatoFormularioIvasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DatoFormularioIvaParameterReturnGeneral procesarAccionDatoFormularioIvas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DatoFormularioIva> datoformularioivas,DatoFormularioIvaParameterReturnGeneral datoformularioivaParameterGeneral)throws Exception {
		 try {	
			DatoFormularioIvaParameterReturnGeneral datoformularioivaReturnGeneral=new DatoFormularioIvaParameterReturnGeneral();
	
			DatoFormularioIvaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,datoformularioivas,datoformularioivaParameterGeneral,datoformularioivaReturnGeneral);
			
			return datoformularioivaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DatoFormularioIvaParameterReturnGeneral procesarAccionDatoFormularioIvasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DatoFormularioIva> datoformularioivas,DatoFormularioIvaParameterReturnGeneral datoformularioivaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioIva.class.getSimpleName()+"-procesarAccionDatoFormularioIvasWithConnection");connexion.begin();			
			
			DatoFormularioIvaParameterReturnGeneral datoformularioivaReturnGeneral=new DatoFormularioIvaParameterReturnGeneral();
	
			DatoFormularioIvaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,datoformularioivas,datoformularioivaParameterGeneral,datoformularioivaReturnGeneral);
			
			this.connexion.commit();
			
			return datoformularioivaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DatoFormularioIvaParameterReturnGeneral procesarEventosDatoFormularioIvas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DatoFormularioIva> datoformularioivas,DatoFormularioIva datoformularioiva,DatoFormularioIvaParameterReturnGeneral datoformularioivaParameterGeneral,Boolean isEsNuevoDatoFormularioIva,ArrayList<Classe> clases)throws Exception {
		 try {	
			DatoFormularioIvaParameterReturnGeneral datoformularioivaReturnGeneral=new DatoFormularioIvaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				datoformularioivaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DatoFormularioIvaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,datoformularioivas,datoformularioiva,datoformularioivaParameterGeneral,datoformularioivaReturnGeneral,isEsNuevoDatoFormularioIva,clases);
			
			return datoformularioivaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DatoFormularioIvaParameterReturnGeneral procesarEventosDatoFormularioIvasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DatoFormularioIva> datoformularioivas,DatoFormularioIva datoformularioiva,DatoFormularioIvaParameterReturnGeneral datoformularioivaParameterGeneral,Boolean isEsNuevoDatoFormularioIva,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioIva.class.getSimpleName()+"-procesarEventosDatoFormularioIvasWithConnection");connexion.begin();			
			
			DatoFormularioIvaParameterReturnGeneral datoformularioivaReturnGeneral=new DatoFormularioIvaParameterReturnGeneral();
	
			datoformularioivaReturnGeneral.setDatoFormularioIva(datoformularioiva);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				datoformularioivaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DatoFormularioIvaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,datoformularioivas,datoformularioiva,datoformularioivaParameterGeneral,datoformularioivaReturnGeneral,isEsNuevoDatoFormularioIva,clases);
			
			this.connexion.commit();
			
			return datoformularioivaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DatoFormularioIvaParameterReturnGeneral procesarImportacionDatoFormularioIvasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DatoFormularioIvaParameterReturnGeneral datoformularioivaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioIva.class.getSimpleName()+"-procesarImportacionDatoFormularioIvasWithConnection");connexion.begin();			
			
			DatoFormularioIvaParameterReturnGeneral datoformularioivaReturnGeneral=new DatoFormularioIvaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.datoformularioivas=new ArrayList<DatoFormularioIva>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.datoformularioiva=new DatoFormularioIva();
				
				
				if(conColumnasBase) {this.datoformularioiva.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.datoformularioiva.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.datoformularioiva.setes_mensual(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.datoformularioiva.setes_sustitutiva(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.datoformularioiva.setnumero_formulario(arrColumnas[iColumn++]);
				
				this.datoformularioivas.add(this.datoformularioiva);
			}
			
			this.saveDatoFormularioIvas();
			
			this.connexion.commit();
			
			datoformularioivaReturnGeneral.setConRetornoEstaProcesado(true);
			datoformularioivaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return datoformularioivaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDatoFormularioIvasEliminados() throws Exception {				
		
		List<DatoFormularioIva> datoformularioivasAux= new ArrayList<DatoFormularioIva>();
		
		for(DatoFormularioIva datoformularioiva:datoformularioivas) {
			if(!datoformularioiva.getIsDeleted()) {
				datoformularioivasAux.add(datoformularioiva);
			}
		}
		
		datoformularioivas=datoformularioivasAux;
	}
	
	public void quitarDatoFormularioIvasNulos() throws Exception {				
		
		List<DatoFormularioIva> datoformularioivasAux= new ArrayList<DatoFormularioIva>();
		
		for(DatoFormularioIva datoformularioiva : this.datoformularioivas) {
			if(datoformularioiva==null) {
				datoformularioivasAux.add(datoformularioiva);
			}
		}
		
		//this.datoformularioivas=datoformularioivasAux;
		
		this.datoformularioivas.removeAll(datoformularioivasAux);
	}
	
	public void getSetVersionRowDatoFormularioIvaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(datoformularioiva.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((datoformularioiva.getIsDeleted() || (datoformularioiva.getIsChanged()&&!datoformularioiva.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=datoformularioivaDataAccess.getSetVersionRowDatoFormularioIva(connexion,datoformularioiva.getId());
				
				if(!datoformularioiva.getVersionRow().equals(timestamp)) {	
					datoformularioiva.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				datoformularioiva.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDatoFormularioIva()throws Exception {	
		
		if(datoformularioiva.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((datoformularioiva.getIsDeleted() || (datoformularioiva.getIsChanged()&&!datoformularioiva.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=datoformularioivaDataAccess.getSetVersionRowDatoFormularioIva(connexion,datoformularioiva.getId());
			
			try {							
				if(!datoformularioiva.getVersionRow().equals(timestamp)) {	
					datoformularioiva.setVersionRow(timestamp);
				}
				
				datoformularioiva.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDatoFormularioIvasWithConnection()throws Exception {	
		if(datoformularioivas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DatoFormularioIva datoformularioivaAux:datoformularioivas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(datoformularioivaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(datoformularioivaAux.getIsDeleted() || (datoformularioivaAux.getIsChanged()&&!datoformularioivaAux.getIsNew())) {
						
						timestamp=datoformularioivaDataAccess.getSetVersionRowDatoFormularioIva(connexion,datoformularioivaAux.getId());
						
						if(!datoformularioiva.getVersionRow().equals(timestamp)) {	
							datoformularioivaAux.setVersionRow(timestamp);
						}
								
						datoformularioivaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDatoFormularioIvas()throws Exception {	
		if(datoformularioivas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DatoFormularioIva datoformularioivaAux:datoformularioivas) {
					if(datoformularioivaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(datoformularioivaAux.getIsDeleted() || (datoformularioivaAux.getIsChanged()&&!datoformularioivaAux.getIsNew())) {
						
						timestamp=datoformularioivaDataAccess.getSetVersionRowDatoFormularioIva(connexion,datoformularioivaAux.getId());
						
						if(!datoformularioivaAux.getVersionRow().equals(timestamp)) {	
							datoformularioivaAux.setVersionRow(timestamp);
						}
						
													
						datoformularioivaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DatoFormularioIvaParameterReturnGeneral cargarCombosLoteForeignKeyDatoFormularioIvaWithConnection(String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalSemestre) throws Exception {
		DatoFormularioIvaParameterReturnGeneral  datoformularioivaReturnGeneral =new DatoFormularioIvaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioIva.class.getSimpleName()+"-cargarCombosLoteForeignKeyDatoFormularioIvaWithConnection");connexion.begin();
			
			datoformularioivaReturnGeneral =new DatoFormularioIvaParameterReturnGeneral();
			
			

			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			datoformularioivaReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			datoformularioivaReturnGeneral.setmessForeignKey(messForeignKey);


			List<Semestre> semestresForeignKey=new ArrayList<Semestre>();
			SemestreLogic semestreLogic=new SemestreLogic();
			semestreLogic.setConnexion(this.connexion);
			semestreLogic.getSemestreDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSemestre.equals("NONE")) {
				semestreLogic.getTodosSemestres(finalQueryGlobalSemestre,new Pagination());
				semestresForeignKey=semestreLogic.getSemestres();
			}

			datoformularioivaReturnGeneral.setsemestresForeignKey(semestresForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return datoformularioivaReturnGeneral;
	}
	
	public DatoFormularioIvaParameterReturnGeneral cargarCombosLoteForeignKeyDatoFormularioIva(String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalSemestre) throws Exception {
		DatoFormularioIvaParameterReturnGeneral  datoformularioivaReturnGeneral =new DatoFormularioIvaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			datoformularioivaReturnGeneral =new DatoFormularioIvaParameterReturnGeneral();
			
			

			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			datoformularioivaReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			datoformularioivaReturnGeneral.setmessForeignKey(messForeignKey);


			List<Semestre> semestresForeignKey=new ArrayList<Semestre>();
			SemestreLogic semestreLogic=new SemestreLogic();
			semestreLogic.setConnexion(this.connexion);
			semestreLogic.getSemestreDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSemestre.equals("NONE")) {
				semestreLogic.getTodosSemestres(finalQueryGlobalSemestre,new Pagination());
				semestresForeignKey=semestreLogic.getSemestres();
			}

			datoformularioivaReturnGeneral.setsemestresForeignKey(semestresForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return datoformularioivaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyDatoFormularioIvaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			FormularioIvaLogic formularioivaLogic=new FormularioIvaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioIva.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyDatoFormularioIvaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(FormularioIva.class));
											
			

			formularioivaLogic.setConnexion(this.getConnexion());
			formularioivaLogic.setDatosCliente(this.datosCliente);
			formularioivaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(DatoFormularioIva datoformularioiva:this.datoformularioivas) {
				

				classes=new ArrayList<Classe>();
				classes=FormularioIvaConstantesFunciones.getClassesForeignKeysOfFormularioIva(new ArrayList<Classe>(),DeepLoadType.NONE);

				formularioivaLogic.setFormularioIvas(datoformularioiva.formularioivas);
				formularioivaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(DatoFormularioIva datoformularioiva,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DatoFormularioIvaLogicAdditional.updateDatoFormularioIvaToGet(datoformularioiva,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		datoformularioiva.setAnio(datoformularioivaDataAccess.getAnio(connexion,datoformularioiva));
		datoformularioiva.setMes(datoformularioivaDataAccess.getMes(connexion,datoformularioiva));
		datoformularioiva.setSemestre(datoformularioivaDataAccess.getSemestre(connexion,datoformularioiva));
		datoformularioiva.setFormularioIvas(datoformularioivaDataAccess.getFormularioIvas(connexion,datoformularioiva));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				datoformularioiva.setAnio(datoformularioivaDataAccess.getAnio(connexion,datoformularioiva));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				datoformularioiva.setMes(datoformularioivaDataAccess.getMes(connexion,datoformularioiva));
				continue;
			}

			if(clas.clas.equals(Semestre.class)) {
				datoformularioiva.setSemestre(datoformularioivaDataAccess.getSemestre(connexion,datoformularioiva));
				continue;
			}

			if(clas.clas.equals(FormularioIva.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				datoformularioiva.setFormularioIvas(datoformularioivaDataAccess.getFormularioIvas(connexion,datoformularioiva));

				if(this.isConDeep) {
					FormularioIvaLogic formularioivaLogic= new FormularioIvaLogic(this.connexion);
					formularioivaLogic.setFormularioIvas(datoformularioiva.getFormularioIvas());
					ArrayList<Classe> classesLocal=FormularioIvaConstantesFunciones.getClassesForeignKeysOfFormularioIva(new ArrayList<Classe>(),DeepLoadType.NONE);
					formularioivaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioIva(formularioivaLogic.getFormularioIvas());
					datoformularioiva.setFormularioIvas(formularioivaLogic.getFormularioIvas());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datoformularioiva.setAnio(datoformularioivaDataAccess.getAnio(connexion,datoformularioiva));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datoformularioiva.setMes(datoformularioivaDataAccess.getMes(connexion,datoformularioiva));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Semestre.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datoformularioiva.setSemestre(datoformularioivaDataAccess.getSemestre(connexion,datoformularioiva));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormularioIva.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormularioIva.class));
			datoformularioiva.setFormularioIvas(datoformularioivaDataAccess.getFormularioIvas(connexion,datoformularioiva));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		datoformularioiva.setAnio(datoformularioivaDataAccess.getAnio(connexion,datoformularioiva));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(datoformularioiva.getAnio(),isDeep,deepLoadType,clases);
				
		datoformularioiva.setMes(datoformularioivaDataAccess.getMes(connexion,datoformularioiva));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(datoformularioiva.getMes(),isDeep,deepLoadType,clases);
				
		datoformularioiva.setSemestre(datoformularioivaDataAccess.getSemestre(connexion,datoformularioiva));
		SemestreLogic semestreLogic= new SemestreLogic(connexion);
		semestreLogic.deepLoad(datoformularioiva.getSemestre(),isDeep,deepLoadType,clases);
				

		datoformularioiva.setFormularioIvas(datoformularioivaDataAccess.getFormularioIvas(connexion,datoformularioiva));

		for(FormularioIva formularioiva:datoformularioiva.getFormularioIvas()) {
			FormularioIvaLogic formularioivaLogic= new FormularioIvaLogic(connexion);
			formularioivaLogic.deepLoad(formularioiva,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				datoformularioiva.setAnio(datoformularioivaDataAccess.getAnio(connexion,datoformularioiva));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(datoformularioiva.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				datoformularioiva.setMes(datoformularioivaDataAccess.getMes(connexion,datoformularioiva));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(datoformularioiva.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Semestre.class)) {
				datoformularioiva.setSemestre(datoformularioivaDataAccess.getSemestre(connexion,datoformularioiva));
				SemestreLogic semestreLogic= new SemestreLogic(connexion);
				semestreLogic.deepLoad(datoformularioiva.getSemestre(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(FormularioIva.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				datoformularioiva.setFormularioIvas(datoformularioivaDataAccess.getFormularioIvas(connexion,datoformularioiva));

				for(FormularioIva formularioiva:datoformularioiva.getFormularioIvas()) {
					FormularioIvaLogic formularioivaLogic= new FormularioIvaLogic(connexion);
					formularioivaLogic.deepLoad(formularioiva,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datoformularioiva.setAnio(datoformularioivaDataAccess.getAnio(connexion,datoformularioiva));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(datoformularioiva.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datoformularioiva.setMes(datoformularioivaDataAccess.getMes(connexion,datoformularioiva));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(datoformularioiva.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Semestre.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			datoformularioiva.setSemestre(datoformularioivaDataAccess.getSemestre(connexion,datoformularioiva));
			SemestreLogic semestreLogic= new SemestreLogic(connexion);
			semestreLogic.deepLoad(datoformularioiva.getSemestre(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormularioIva.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormularioIva.class));
			datoformularioiva.setFormularioIvas(datoformularioivaDataAccess.getFormularioIvas(connexion,datoformularioiva));

			for(FormularioIva formularioiva:datoformularioiva.getFormularioIvas()) {
				FormularioIvaLogic formularioivaLogic= new FormularioIvaLogic(connexion);
				formularioivaLogic.deepLoad(formularioiva,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DatoFormularioIva datoformularioiva,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DatoFormularioIvaLogicAdditional.updateDatoFormularioIvaToSave(datoformularioiva,this.arrDatoGeneral);
			
DatoFormularioIvaDataAccess.save(datoformularioiva, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		AnioDataAccess.save(datoformularioiva.getAnio(),connexion);

		MesDataAccess.save(datoformularioiva.getMes(),connexion);

		SemestreDataAccess.save(datoformularioiva.getSemestre(),connexion);

		for(FormularioIva formularioiva:datoformularioiva.getFormularioIvas()) {
			formularioiva.setid_dato_formulario_iva(datoformularioiva.getId());
			FormularioIvaDataAccess.save(formularioiva,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(datoformularioiva.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(datoformularioiva.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(Semestre.class)) {
				SemestreDataAccess.save(datoformularioiva.getSemestre(),connexion);
				continue;
			}


			if(clas.clas.equals(FormularioIva.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormularioIva formularioiva:datoformularioiva.getFormularioIvas()) {
					formularioiva.setid_dato_formulario_iva(datoformularioiva.getId());
					FormularioIvaDataAccess.save(formularioiva,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		AnioDataAccess.save(datoformularioiva.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(datoformularioiva.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(datoformularioiva.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(datoformularioiva.getMes(),isDeep,deepLoadType,clases);
				

		SemestreDataAccess.save(datoformularioiva.getSemestre(),connexion);
		SemestreLogic semestreLogic= new SemestreLogic(connexion);
		semestreLogic.deepLoad(datoformularioiva.getSemestre(),isDeep,deepLoadType,clases);
				

		for(FormularioIva formularioiva:datoformularioiva.getFormularioIvas()) {
			FormularioIvaLogic formularioivaLogic= new FormularioIvaLogic(connexion);
			formularioiva.setid_dato_formulario_iva(datoformularioiva.getId());
			FormularioIvaDataAccess.save(formularioiva,connexion);
			formularioivaLogic.deepSave(formularioiva,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(datoformularioiva.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(datoformularioiva.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(datoformularioiva.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(datoformularioiva.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Semestre.class)) {
				SemestreDataAccess.save(datoformularioiva.getSemestre(),connexion);
				SemestreLogic semestreLogic= new SemestreLogic(connexion);
				semestreLogic.deepSave(datoformularioiva.getSemestre(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(FormularioIva.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormularioIva formularioiva:datoformularioiva.getFormularioIvas()) {
					FormularioIvaLogic formularioivaLogic= new FormularioIvaLogic(connexion);
					formularioiva.setid_dato_formulario_iva(datoformularioiva.getId());
					FormularioIvaDataAccess.save(formularioiva,connexion);
					formularioivaLogic.deepSave(formularioiva,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(DatoFormularioIva.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(datoformularioiva,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DatoFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioIva(datoformularioiva);
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
			this.deepLoad(this.datoformularioiva,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DatoFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioIva(this.datoformularioiva);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DatoFormularioIva.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(datoformularioivas!=null) {
				for(DatoFormularioIva datoformularioiva:datoformularioivas) {
					this.deepLoad(datoformularioiva,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DatoFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioIva(datoformularioivas);
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
			if(datoformularioivas!=null) {
				for(DatoFormularioIva datoformularioiva:datoformularioivas) {
					this.deepLoad(datoformularioiva,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DatoFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioIva(datoformularioivas);
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
			this.getNewConnexionToDeep(DatoFormularioIva.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(datoformularioiva,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DatoFormularioIva.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(datoformularioivas!=null) {
				for(DatoFormularioIva datoformularioiva:datoformularioivas) {
					this.deepSave(datoformularioiva,isDeep,deepLoadType,clases);
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
			if(datoformularioivas!=null) {
				for(DatoFormularioIva datoformularioiva:datoformularioivas) {
					this.deepSave(datoformularioiva,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDatoFormularioIvasBusquedaPorIdAnioIdSemestreWithConnection(String sFinalQuery,Pagination pagination,Long id_anio,Long id_semestre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioIva.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DatoFormularioIvaConstantesFunciones.IDANIO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			ParameterSelectionGeneral parameterSelectionGeneralidSemestre= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSemestre.setParameterSelectionGeneralEqual(ParameterType.LONG,id_semestre,DatoFormularioIvaConstantesFunciones.IDSEMESTRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSemestre);

			DatoFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdAnioIdSemestre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datoformularioivas=datoformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioIva(this.datoformularioivas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDatoFormularioIvasBusquedaPorIdAnioIdSemestre(String sFinalQuery,Pagination pagination,Long id_anio,Long id_semestre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DatoFormularioIvaConstantesFunciones.IDANIO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			ParameterSelectionGeneral parameterSelectionGeneralidSemestre= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSemestre.setParameterSelectionGeneralEqual(ParameterType.LONG,id_semestre,DatoFormularioIvaConstantesFunciones.IDSEMESTRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSemestre);

			DatoFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdAnioIdSemestre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datoformularioivas=datoformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioIva(this.datoformularioivas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDatoFormularioIvasBusquedaPorIdAnioPorIdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_anio,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioIva.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DatoFormularioIvaConstantesFunciones.IDANIO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DatoFormularioIvaConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DatoFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdAnioPorIdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datoformularioivas=datoformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioIva(this.datoformularioivas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDatoFormularioIvasBusquedaPorIdAnioPorIdMes(String sFinalQuery,Pagination pagination,Long id_anio,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DatoFormularioIvaConstantesFunciones.IDANIO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DatoFormularioIvaConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DatoFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdAnioPorIdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datoformularioivas=datoformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioIva(this.datoformularioivas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDatoFormularioIvasFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioIva.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DatoFormularioIvaConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DatoFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datoformularioivas=datoformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioIva(this.datoformularioivas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDatoFormularioIvasFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DatoFormularioIvaConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DatoFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datoformularioivas=datoformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioIva(this.datoformularioivas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDatoFormularioIvasFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioIva.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DatoFormularioIvaConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DatoFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datoformularioivas=datoformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioIva(this.datoformularioivas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDatoFormularioIvasFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DatoFormularioIvaConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DatoFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datoformularioivas=datoformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioIva(this.datoformularioivas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDatoFormularioIvasFK_IdSemestreWithConnection(String sFinalQuery,Pagination pagination,Long id_semestre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DatoFormularioIva.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSemestre= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSemestre.setParameterSelectionGeneralEqual(ParameterType.LONG,id_semestre,DatoFormularioIvaConstantesFunciones.IDSEMESTRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSemestre);

			DatoFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSemestre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datoformularioivas=datoformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioIva(this.datoformularioivas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDatoFormularioIvasFK_IdSemestre(String sFinalQuery,Pagination pagination,Long id_semestre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSemestre= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSemestre.setParameterSelectionGeneralEqual(ParameterType.LONG,id_semestre,DatoFormularioIvaConstantesFunciones.IDSEMESTRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSemestre);

			DatoFormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSemestre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			datoformularioivas=datoformularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DatoFormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesDatoFormularioIva(this.datoformularioivas);
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
			if(DatoFormularioIvaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DatoFormularioIvaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DatoFormularioIva datoformularioiva,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DatoFormularioIvaConstantesFunciones.ISCONAUDITORIA) {
				if(datoformularioiva.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DatoFormularioIvaDataAccess.TABLENAME, datoformularioiva.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DatoFormularioIvaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DatoFormularioIvaLogic.registrarAuditoriaDetallesDatoFormularioIva(connexion,datoformularioiva,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(datoformularioiva.getIsDeleted()) {
					/*if(!datoformularioiva.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DatoFormularioIvaDataAccess.TABLENAME, datoformularioiva.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DatoFormularioIvaLogic.registrarAuditoriaDetallesDatoFormularioIva(connexion,datoformularioiva,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DatoFormularioIvaDataAccess.TABLENAME, datoformularioiva.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(datoformularioiva.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DatoFormularioIvaDataAccess.TABLENAME, datoformularioiva.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DatoFormularioIvaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DatoFormularioIvaLogic.registrarAuditoriaDetallesDatoFormularioIva(connexion,datoformularioiva,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDatoFormularioIva(Connexion connexion,DatoFormularioIva datoformularioiva)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(datoformularioiva.getIsNew()||!datoformularioiva.getes_mensual().equals(datoformularioiva.getDatoFormularioIvaOriginal().getes_mensual()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datoformularioiva.getDatoFormularioIvaOriginal().getes_mensual()!=null)
				{
					strValorActual=datoformularioiva.getDatoFormularioIvaOriginal().getes_mensual().toString();
				}
				if(datoformularioiva.getes_mensual()!=null)
				{
					strValorNuevo=datoformularioiva.getes_mensual().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoFormularioIvaConstantesFunciones.ESMENSUAL,strValorActual,strValorNuevo);
			}	
			
			if(datoformularioiva.getIsNew()||!datoformularioiva.getid_anio().equals(datoformularioiva.getDatoFormularioIvaOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datoformularioiva.getDatoFormularioIvaOriginal().getid_anio()!=null)
				{
					strValorActual=datoformularioiva.getDatoFormularioIvaOriginal().getid_anio().toString();
				}
				if(datoformularioiva.getid_anio()!=null)
				{
					strValorNuevo=datoformularioiva.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoFormularioIvaConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(datoformularioiva.getIsNew()||!datoformularioiva.getid_mes().equals(datoformularioiva.getDatoFormularioIvaOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datoformularioiva.getDatoFormularioIvaOriginal().getid_mes()!=null)
				{
					strValorActual=datoformularioiva.getDatoFormularioIvaOriginal().getid_mes().toString();
				}
				if(datoformularioiva.getid_mes()!=null)
				{
					strValorNuevo=datoformularioiva.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoFormularioIvaConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(datoformularioiva.getIsNew()||!datoformularioiva.getid_semestre().equals(datoformularioiva.getDatoFormularioIvaOriginal().getid_semestre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datoformularioiva.getDatoFormularioIvaOriginal().getid_semestre()!=null)
				{
					strValorActual=datoformularioiva.getDatoFormularioIvaOriginal().getid_semestre().toString();
				}
				if(datoformularioiva.getid_semestre()!=null)
				{
					strValorNuevo=datoformularioiva.getid_semestre().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoFormularioIvaConstantesFunciones.IDSEMESTRE,strValorActual,strValorNuevo);
			}	
			
			if(datoformularioiva.getIsNew()||!datoformularioiva.getes_sustitutiva().equals(datoformularioiva.getDatoFormularioIvaOriginal().getes_sustitutiva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datoformularioiva.getDatoFormularioIvaOriginal().getes_sustitutiva()!=null)
				{
					strValorActual=datoformularioiva.getDatoFormularioIvaOriginal().getes_sustitutiva().toString();
				}
				if(datoformularioiva.getes_sustitutiva()!=null)
				{
					strValorNuevo=datoformularioiva.getes_sustitutiva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoFormularioIvaConstantesFunciones.ESSUSTITUTIVA,strValorActual,strValorNuevo);
			}	
			
			if(datoformularioiva.getIsNew()||!datoformularioiva.getnumero_formulario().equals(datoformularioiva.getDatoFormularioIvaOriginal().getnumero_formulario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(datoformularioiva.getDatoFormularioIvaOriginal().getnumero_formulario()!=null)
				{
					strValorActual=datoformularioiva.getDatoFormularioIvaOriginal().getnumero_formulario();
				}
				if(datoformularioiva.getnumero_formulario()!=null)
				{
					strValorNuevo=datoformularioiva.getnumero_formulario() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DatoFormularioIvaConstantesFunciones.NUMEROFORMULARIO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDatoFormularioIvaRelacionesWithConnection(DatoFormularioIva datoformularioiva,List<FormularioIva> formularioivas) throws Exception {

		if(!datoformularioiva.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDatoFormularioIvaRelacionesBase(datoformularioiva,formularioivas,true);
		}
	}

	public void saveDatoFormularioIvaRelaciones(DatoFormularioIva datoformularioiva,List<FormularioIva> formularioivas)throws Exception {

		if(!datoformularioiva.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDatoFormularioIvaRelacionesBase(datoformularioiva,formularioivas,false);
		}
	}

	public void saveDatoFormularioIvaRelacionesBase(DatoFormularioIva datoformularioiva,List<FormularioIva> formularioivas,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DatoFormularioIva-saveRelacionesWithConnection");}
	
			datoformularioiva.setFormularioIvas(formularioivas);

			this.setDatoFormularioIva(datoformularioiva);

			if(DatoFormularioIvaLogicAdditional.validarSaveRelaciones(datoformularioiva,this)) {

				DatoFormularioIvaLogicAdditional.updateRelacionesToSave(datoformularioiva,this);

				if((datoformularioiva.getIsNew()||datoformularioiva.getIsChanged())&&!datoformularioiva.getIsDeleted()) {
					this.saveDatoFormularioIva();
					this.saveDatoFormularioIvaRelacionesDetalles(formularioivas);

				} else if(datoformularioiva.getIsDeleted()) {
					this.saveDatoFormularioIvaRelacionesDetalles(formularioivas);
					this.saveDatoFormularioIva();
				}

				DatoFormularioIvaLogicAdditional.updateRelacionesToSaveAfter(datoformularioiva,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			FormularioIvaConstantesFunciones.InicializarGeneralEntityAuxiliaresFormularioIvas(formularioivas,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveDatoFormularioIvaRelacionesDetalles(List<FormularioIva> formularioivas)throws Exception {
		try {
	

			Long idDatoFormularioIvaActual=this.getDatoFormularioIva().getId();

			FormularioIvaLogic formularioivaLogic_Desde_DatoFormularioIva=new FormularioIvaLogic();
			formularioivaLogic_Desde_DatoFormularioIva.setFormularioIvas(formularioivas);

			formularioivaLogic_Desde_DatoFormularioIva.setConnexion(this.getConnexion());
			formularioivaLogic_Desde_DatoFormularioIva.setDatosCliente(this.datosCliente);

			for(FormularioIva formularioiva_Desde_DatoFormularioIva:formularioivaLogic_Desde_DatoFormularioIva.getFormularioIvas()) {
				formularioiva_Desde_DatoFormularioIva.setid_dato_formulario_iva(idDatoFormularioIvaActual);
			}

			formularioivaLogic_Desde_DatoFormularioIva.saveFormularioIvas();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDatoFormularioIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DatoFormularioIvaConstantesFunciones.getClassesForeignKeysOfDatoFormularioIva(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDatoFormularioIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DatoFormularioIvaConstantesFunciones.getClassesRelationshipsOfDatoFormularioIva(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

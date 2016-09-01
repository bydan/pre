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
import com.bydan.erp.nomina.util.TelefonoReferenciaConstantesFunciones;
import com.bydan.erp.nomina.util.TelefonoReferenciaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TelefonoReferenciaParameterGeneral;
import com.bydan.erp.nomina.business.entity.TelefonoReferencia;
import com.bydan.erp.nomina.business.logic.TelefonoReferenciaLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class TelefonoReferenciaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TelefonoReferenciaLogic.class);
	
	protected TelefonoReferenciaDataAccess telefonoreferenciaDataAccess; 	
	protected TelefonoReferencia telefonoreferencia;
	protected List<TelefonoReferencia> telefonoreferencias;
	protected Object telefonoreferenciaObject;	
	protected List<Object> telefonoreferenciasObject;
	
	public static ClassValidator<TelefonoReferencia> telefonoreferenciaValidator = new ClassValidator<TelefonoReferencia>(TelefonoReferencia.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TelefonoReferenciaLogicAdditional telefonoreferenciaLogicAdditional=null;
	
	public TelefonoReferenciaLogicAdditional getTelefonoReferenciaLogicAdditional() {
		return this.telefonoreferenciaLogicAdditional;
	}
	
	public void setTelefonoReferenciaLogicAdditional(TelefonoReferenciaLogicAdditional telefonoreferenciaLogicAdditional) {
		try {
			this.telefonoreferenciaLogicAdditional=telefonoreferenciaLogicAdditional;
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
	
	
	
	
	public  TelefonoReferenciaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.telefonoreferenciaDataAccess = new TelefonoReferenciaDataAccess();
			
			this.telefonoreferencias= new ArrayList<TelefonoReferencia>();
			this.telefonoreferencia= new TelefonoReferencia();
			
			this.telefonoreferenciaObject=new Object();
			this.telefonoreferenciasObject=new ArrayList<Object>();
				
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
			
			this.telefonoreferenciaDataAccess.setConnexionType(this.connexionType);
			this.telefonoreferenciaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TelefonoReferenciaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.telefonoreferenciaDataAccess = new TelefonoReferenciaDataAccess();
			this.telefonoreferencias= new ArrayList<TelefonoReferencia>();
			this.telefonoreferencia= new TelefonoReferencia();
			this.telefonoreferenciaObject=new Object();
			this.telefonoreferenciasObject=new ArrayList<Object>();
			
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
			
			this.telefonoreferenciaDataAccess.setConnexionType(this.connexionType);
			this.telefonoreferenciaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TelefonoReferencia getTelefonoReferencia() throws Exception {	
		TelefonoReferenciaLogicAdditional.checkTelefonoReferenciaToGet(telefonoreferencia,this.datosCliente,this.arrDatoGeneral);
		TelefonoReferenciaLogicAdditional.updateTelefonoReferenciaToGet(telefonoreferencia,this.arrDatoGeneral);
		
		return telefonoreferencia;
	}
		
	public void setTelefonoReferencia(TelefonoReferencia newTelefonoReferencia) {
		this.telefonoreferencia = newTelefonoReferencia;
	}
	
	public TelefonoReferenciaDataAccess getTelefonoReferenciaDataAccess() {
		return telefonoreferenciaDataAccess;
	}
	
	public void setTelefonoReferenciaDataAccess(TelefonoReferenciaDataAccess newtelefonoreferenciaDataAccess) {
		this.telefonoreferenciaDataAccess = newtelefonoreferenciaDataAccess;
	}
	
	public List<TelefonoReferencia> getTelefonoReferencias() throws Exception {		
		this.quitarTelefonoReferenciasNulos();
		
		TelefonoReferenciaLogicAdditional.checkTelefonoReferenciaToGets(telefonoreferencias,this.datosCliente,this.arrDatoGeneral);
		
		for (TelefonoReferencia telefonoreferenciaLocal: telefonoreferencias ) {
			TelefonoReferenciaLogicAdditional.updateTelefonoReferenciaToGet(telefonoreferenciaLocal,this.arrDatoGeneral);
		}
		
		return telefonoreferencias;
	}
	
	public void setTelefonoReferencias(List<TelefonoReferencia> newTelefonoReferencias) {
		this.telefonoreferencias = newTelefonoReferencias;
	}
	
	public Object getTelefonoReferenciaObject() {	
		this.telefonoreferenciaObject=this.telefonoreferenciaDataAccess.getEntityObject();
		return this.telefonoreferenciaObject;
	}
		
	public void setTelefonoReferenciaObject(Object newTelefonoReferenciaObject) {
		this.telefonoreferenciaObject = newTelefonoReferenciaObject;
	}
	
	public List<Object> getTelefonoReferenciasObject() {		
		this.telefonoreferenciasObject=this.telefonoreferenciaDataAccess.getEntitiesObject();
		return this.telefonoreferenciasObject;
	}
		
	public void setTelefonoReferenciasObject(List<Object> newTelefonoReferenciasObject) {
		this.telefonoreferenciasObject = newTelefonoReferenciasObject;
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
		
		if(this.telefonoreferenciaDataAccess!=null) {
			this.telefonoreferenciaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TelefonoReferencia.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			telefonoreferenciaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			telefonoreferenciaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		telefonoreferencia = new  TelefonoReferencia();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TelefonoReferencia.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			telefonoreferencia=telefonoreferenciaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.telefonoreferencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TelefonoReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTelefonoReferencia(this.telefonoreferencia);
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
		telefonoreferencia = new  TelefonoReferencia();
		  		  
        try {
			
			telefonoreferencia=telefonoreferenciaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.telefonoreferencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TelefonoReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTelefonoReferencia(this.telefonoreferencia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		telefonoreferencia = new  TelefonoReferencia();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TelefonoReferencia.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			telefonoreferencia=telefonoreferenciaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.telefonoreferencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TelefonoReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTelefonoReferencia(this.telefonoreferencia);
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
		telefonoreferencia = new  TelefonoReferencia();
		  		  
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
		telefonoreferencia = new  TelefonoReferencia();
		  		  
        try {
			
			telefonoreferencia=telefonoreferenciaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.telefonoreferencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TelefonoReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTelefonoReferencia(this.telefonoreferencia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		telefonoreferencia = new  TelefonoReferencia();
		  		  
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
		telefonoreferencia = new  TelefonoReferencia();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TelefonoReferencia.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =telefonoreferenciaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		telefonoreferencia = new  TelefonoReferencia();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=telefonoreferenciaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		telefonoreferencia = new  TelefonoReferencia();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TelefonoReferencia.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =telefonoreferenciaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		telefonoreferencia = new  TelefonoReferencia();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=telefonoreferenciaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		telefonoreferencia = new  TelefonoReferencia();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TelefonoReferencia.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =telefonoreferenciaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		telefonoreferencia = new  TelefonoReferencia();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=telefonoreferenciaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		telefonoreferencias = new  ArrayList<TelefonoReferencia>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TelefonoReferencia.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TelefonoReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			telefonoreferencias=telefonoreferenciaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTelefonoReferencia(telefonoreferencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TelefonoReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTelefonoReferencia(this.telefonoreferencias);
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
		telefonoreferencias = new  ArrayList<TelefonoReferencia>();
		  		  
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
		telefonoreferencias = new  ArrayList<TelefonoReferencia>();
		  		  
        try {			
			TelefonoReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			telefonoreferencias=telefonoreferenciaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTelefonoReferencia(telefonoreferencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TelefonoReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTelefonoReferencia(this.telefonoreferencias);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		telefonoreferencias = new  ArrayList<TelefonoReferencia>();
		  		  
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
		telefonoreferencias = new  ArrayList<TelefonoReferencia>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TelefonoReferencia.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TelefonoReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			telefonoreferencias=telefonoreferenciaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTelefonoReferencia(telefonoreferencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TelefonoReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTelefonoReferencia(this.telefonoreferencias);
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
		telefonoreferencias = new  ArrayList<TelefonoReferencia>();
		  		  
        try {
			TelefonoReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			telefonoreferencias=telefonoreferenciaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTelefonoReferencia(telefonoreferencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TelefonoReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTelefonoReferencia(this.telefonoreferencias);
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
		telefonoreferencias = new  ArrayList<TelefonoReferencia>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TelefonoReferencia.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TelefonoReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			telefonoreferencias=telefonoreferenciaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTelefonoReferencia(telefonoreferencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TelefonoReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTelefonoReferencia(this.telefonoreferencias);
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
		telefonoreferencias = new  ArrayList<TelefonoReferencia>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TelefonoReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			telefonoreferencias=telefonoreferenciaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTelefonoReferencia(telefonoreferencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TelefonoReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTelefonoReferencia(this.telefonoreferencias);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		telefonoreferencia = new  TelefonoReferencia();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TelefonoReferencia.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TelefonoReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			telefonoreferencia=telefonoreferenciaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTelefonoReferencia(telefonoreferencia);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TelefonoReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTelefonoReferencia(this.telefonoreferencia);
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
		telefonoreferencia = new  TelefonoReferencia();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TelefonoReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			telefonoreferencia=telefonoreferenciaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTelefonoReferencia(telefonoreferencia);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TelefonoReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTelefonoReferencia(this.telefonoreferencia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		telefonoreferencias = new  ArrayList<TelefonoReferencia>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TelefonoReferencia.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TelefonoReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			telefonoreferencias=telefonoreferenciaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTelefonoReferencia(telefonoreferencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TelefonoReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTelefonoReferencia(this.telefonoreferencias);
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
		telefonoreferencias = new  ArrayList<TelefonoReferencia>();
		  		  
        try {
			TelefonoReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			telefonoreferencias=telefonoreferenciaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTelefonoReferencia(telefonoreferencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TelefonoReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTelefonoReferencia(this.telefonoreferencias);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTelefonoReferenciasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		telefonoreferencias = new  ArrayList<TelefonoReferencia>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TelefonoReferencia.class.getSimpleName()+"-getTodosTelefonoReferenciasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TelefonoReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			telefonoreferencias=telefonoreferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTelefonoReferencia(telefonoreferencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TelefonoReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTelefonoReferencia(this.telefonoreferencias);
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
	
	public  void  getTodosTelefonoReferencias(String sFinalQuery,Pagination pagination)throws Exception {
		telefonoreferencias = new  ArrayList<TelefonoReferencia>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TelefonoReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			telefonoreferencias=telefonoreferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTelefonoReferencia(telefonoreferencias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TelefonoReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTelefonoReferencia(this.telefonoreferencias);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTelefonoReferencia(TelefonoReferencia telefonoreferencia) throws Exception {
		Boolean estaValidado=false;
		
		if(telefonoreferencia.getIsNew() || telefonoreferencia.getIsChanged()) { 
			this.invalidValues = telefonoreferenciaValidator.getInvalidValues(telefonoreferencia);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(telefonoreferencia);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTelefonoReferencia(List<TelefonoReferencia> TelefonoReferencias) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TelefonoReferencia telefonoreferenciaLocal:telefonoreferencias) {				
			estaValidadoObjeto=this.validarGuardarTelefonoReferencia(telefonoreferenciaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTelefonoReferencia(List<TelefonoReferencia> TelefonoReferencias) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTelefonoReferencia(telefonoreferencias)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTelefonoReferencia(TelefonoReferencia TelefonoReferencia) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTelefonoReferencia(telefonoreferencia)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TelefonoReferencia telefonoreferencia) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+telefonoreferencia.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TelefonoReferenciaConstantesFunciones.getTelefonoReferenciaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"telefonoreferencia","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TelefonoReferenciaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TelefonoReferenciaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTelefonoReferenciaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TelefonoReferencia.class.getSimpleName()+"-saveTelefonoReferenciaWithConnection");connexion.begin();			
			
			TelefonoReferenciaLogicAdditional.checkTelefonoReferenciaToSave(this.telefonoreferencia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TelefonoReferenciaLogicAdditional.updateTelefonoReferenciaToSave(this.telefonoreferencia,this.arrDatoGeneral);
			
			TelefonoReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.telefonoreferencia,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTelefonoReferencia();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTelefonoReferencia(this.telefonoreferencia)) {
				TelefonoReferenciaDataAccess.save(this.telefonoreferencia, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.telefonoreferencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TelefonoReferenciaLogicAdditional.checkTelefonoReferenciaToSaveAfter(this.telefonoreferencia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTelefonoReferencia();
			
			connexion.commit();			
			
			if(this.telefonoreferencia.getIsDeleted()) {
				this.telefonoreferencia=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTelefonoReferencia()throws Exception {	
		try {	
			
			TelefonoReferenciaLogicAdditional.checkTelefonoReferenciaToSave(this.telefonoreferencia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TelefonoReferenciaLogicAdditional.updateTelefonoReferenciaToSave(this.telefonoreferencia,this.arrDatoGeneral);
			
			TelefonoReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.telefonoreferencia,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTelefonoReferencia(this.telefonoreferencia)) {			
				TelefonoReferenciaDataAccess.save(this.telefonoreferencia, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.telefonoreferencia,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TelefonoReferenciaLogicAdditional.checkTelefonoReferenciaToSaveAfter(this.telefonoreferencia,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.telefonoreferencia.getIsDeleted()) {
				this.telefonoreferencia=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTelefonoReferenciasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TelefonoReferencia.class.getSimpleName()+"-saveTelefonoReferenciasWithConnection");connexion.begin();			
			
			TelefonoReferenciaLogicAdditional.checkTelefonoReferenciaToSaves(telefonoreferencias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTelefonoReferencias();
			
			Boolean validadoTodosTelefonoReferencia=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TelefonoReferencia telefonoreferenciaLocal:telefonoreferencias) {		
				if(telefonoreferenciaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TelefonoReferenciaLogicAdditional.updateTelefonoReferenciaToSave(telefonoreferenciaLocal,this.arrDatoGeneral);
	        	
				TelefonoReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),telefonoreferenciaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTelefonoReferencia(telefonoreferenciaLocal)) {
					TelefonoReferenciaDataAccess.save(telefonoreferenciaLocal, connexion);				
				} else {
					validadoTodosTelefonoReferencia=false;
				}
			}
			
			if(!validadoTodosTelefonoReferencia) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TelefonoReferenciaLogicAdditional.checkTelefonoReferenciaToSavesAfter(telefonoreferencias,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTelefonoReferencias();
			
			connexion.commit();		
			
			this.quitarTelefonoReferenciasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTelefonoReferencias()throws Exception {				
		 try {	
			TelefonoReferenciaLogicAdditional.checkTelefonoReferenciaToSaves(telefonoreferencias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTelefonoReferencia=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TelefonoReferencia telefonoreferenciaLocal:telefonoreferencias) {				
				if(telefonoreferenciaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TelefonoReferenciaLogicAdditional.updateTelefonoReferenciaToSave(telefonoreferenciaLocal,this.arrDatoGeneral);
	        	
				TelefonoReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),telefonoreferenciaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTelefonoReferencia(telefonoreferenciaLocal)) {				
					TelefonoReferenciaDataAccess.save(telefonoreferenciaLocal, connexion);				
				} else {
					validadoTodosTelefonoReferencia=false;
				}
			}
			
			if(!validadoTodosTelefonoReferencia) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TelefonoReferenciaLogicAdditional.checkTelefonoReferenciaToSavesAfter(telefonoreferencias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTelefonoReferenciasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TelefonoReferenciaParameterReturnGeneral procesarAccionTelefonoReferencias(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TelefonoReferencia> telefonoreferencias,TelefonoReferenciaParameterReturnGeneral telefonoreferenciaParameterGeneral)throws Exception {
		 try {	
			TelefonoReferenciaParameterReturnGeneral telefonoreferenciaReturnGeneral=new TelefonoReferenciaParameterReturnGeneral();
	
			TelefonoReferenciaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,telefonoreferencias,telefonoreferenciaParameterGeneral,telefonoreferenciaReturnGeneral);
			
			return telefonoreferenciaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TelefonoReferenciaParameterReturnGeneral procesarAccionTelefonoReferenciasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TelefonoReferencia> telefonoreferencias,TelefonoReferenciaParameterReturnGeneral telefonoreferenciaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TelefonoReferencia.class.getSimpleName()+"-procesarAccionTelefonoReferenciasWithConnection");connexion.begin();			
			
			TelefonoReferenciaParameterReturnGeneral telefonoreferenciaReturnGeneral=new TelefonoReferenciaParameterReturnGeneral();
	
			TelefonoReferenciaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,telefonoreferencias,telefonoreferenciaParameterGeneral,telefonoreferenciaReturnGeneral);
			
			this.connexion.commit();
			
			return telefonoreferenciaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TelefonoReferenciaParameterReturnGeneral procesarEventosTelefonoReferencias(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TelefonoReferencia> telefonoreferencias,TelefonoReferencia telefonoreferencia,TelefonoReferenciaParameterReturnGeneral telefonoreferenciaParameterGeneral,Boolean isEsNuevoTelefonoReferencia,ArrayList<Classe> clases)throws Exception {
		 try {	
			TelefonoReferenciaParameterReturnGeneral telefonoreferenciaReturnGeneral=new TelefonoReferenciaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				telefonoreferenciaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TelefonoReferenciaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,telefonoreferencias,telefonoreferencia,telefonoreferenciaParameterGeneral,telefonoreferenciaReturnGeneral,isEsNuevoTelefonoReferencia,clases);
			
			return telefonoreferenciaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TelefonoReferenciaParameterReturnGeneral procesarEventosTelefonoReferenciasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TelefonoReferencia> telefonoreferencias,TelefonoReferencia telefonoreferencia,TelefonoReferenciaParameterReturnGeneral telefonoreferenciaParameterGeneral,Boolean isEsNuevoTelefonoReferencia,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TelefonoReferencia.class.getSimpleName()+"-procesarEventosTelefonoReferenciasWithConnection");connexion.begin();			
			
			TelefonoReferenciaParameterReturnGeneral telefonoreferenciaReturnGeneral=new TelefonoReferenciaParameterReturnGeneral();
	
			telefonoreferenciaReturnGeneral.setTelefonoReferencia(telefonoreferencia);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				telefonoreferenciaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TelefonoReferenciaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,telefonoreferencias,telefonoreferencia,telefonoreferenciaParameterGeneral,telefonoreferenciaReturnGeneral,isEsNuevoTelefonoReferencia,clases);
			
			this.connexion.commit();
			
			return telefonoreferenciaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TelefonoReferenciaParameterReturnGeneral procesarImportacionTelefonoReferenciasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TelefonoReferenciaParameterReturnGeneral telefonoreferenciaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TelefonoReferencia.class.getSimpleName()+"-procesarImportacionTelefonoReferenciasWithConnection");connexion.begin();			
			
			TelefonoReferenciaParameterReturnGeneral telefonoreferenciaReturnGeneral=new TelefonoReferenciaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.telefonoreferencias=new ArrayList<TelefonoReferencia>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.telefonoreferencia=new TelefonoReferencia();
				
				
				if(conColumnasBase) {this.telefonoreferencia.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.telefonoreferencia.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.telefonoreferencia.setnumero(arrColumnas[iColumn++]);
				
				this.telefonoreferencias.add(this.telefonoreferencia);
			}
			
			this.saveTelefonoReferencias();
			
			this.connexion.commit();
			
			telefonoreferenciaReturnGeneral.setConRetornoEstaProcesado(true);
			telefonoreferenciaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return telefonoreferenciaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTelefonoReferenciasEliminados() throws Exception {				
		
		List<TelefonoReferencia> telefonoreferenciasAux= new ArrayList<TelefonoReferencia>();
		
		for(TelefonoReferencia telefonoreferencia:telefonoreferencias) {
			if(!telefonoreferencia.getIsDeleted()) {
				telefonoreferenciasAux.add(telefonoreferencia);
			}
		}
		
		telefonoreferencias=telefonoreferenciasAux;
	}
	
	public void quitarTelefonoReferenciasNulos() throws Exception {				
		
		List<TelefonoReferencia> telefonoreferenciasAux= new ArrayList<TelefonoReferencia>();
		
		for(TelefonoReferencia telefonoreferencia : this.telefonoreferencias) {
			if(telefonoreferencia==null) {
				telefonoreferenciasAux.add(telefonoreferencia);
			}
		}
		
		//this.telefonoreferencias=telefonoreferenciasAux;
		
		this.telefonoreferencias.removeAll(telefonoreferenciasAux);
	}
	
	public void getSetVersionRowTelefonoReferenciaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(telefonoreferencia.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((telefonoreferencia.getIsDeleted() || (telefonoreferencia.getIsChanged()&&!telefonoreferencia.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=telefonoreferenciaDataAccess.getSetVersionRowTelefonoReferencia(connexion,telefonoreferencia.getId());
				
				if(!telefonoreferencia.getVersionRow().equals(timestamp)) {	
					telefonoreferencia.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				telefonoreferencia.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTelefonoReferencia()throws Exception {	
		
		if(telefonoreferencia.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((telefonoreferencia.getIsDeleted() || (telefonoreferencia.getIsChanged()&&!telefonoreferencia.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=telefonoreferenciaDataAccess.getSetVersionRowTelefonoReferencia(connexion,telefonoreferencia.getId());
			
			try {							
				if(!telefonoreferencia.getVersionRow().equals(timestamp)) {	
					telefonoreferencia.setVersionRow(timestamp);
				}
				
				telefonoreferencia.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTelefonoReferenciasWithConnection()throws Exception {	
		if(telefonoreferencias!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TelefonoReferencia telefonoreferenciaAux:telefonoreferencias) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(telefonoreferenciaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(telefonoreferenciaAux.getIsDeleted() || (telefonoreferenciaAux.getIsChanged()&&!telefonoreferenciaAux.getIsNew())) {
						
						timestamp=telefonoreferenciaDataAccess.getSetVersionRowTelefonoReferencia(connexion,telefonoreferenciaAux.getId());
						
						if(!telefonoreferencia.getVersionRow().equals(timestamp)) {	
							telefonoreferenciaAux.setVersionRow(timestamp);
						}
								
						telefonoreferenciaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTelefonoReferencias()throws Exception {	
		if(telefonoreferencias!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TelefonoReferencia telefonoreferenciaAux:telefonoreferencias) {
					if(telefonoreferenciaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(telefonoreferenciaAux.getIsDeleted() || (telefonoreferenciaAux.getIsChanged()&&!telefonoreferenciaAux.getIsNew())) {
						
						timestamp=telefonoreferenciaDataAccess.getSetVersionRowTelefonoReferencia(connexion,telefonoreferenciaAux.getId());
						
						if(!telefonoreferenciaAux.getVersionRow().equals(timestamp)) {	
							telefonoreferenciaAux.setVersionRow(timestamp);
						}
						
													
						telefonoreferenciaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TelefonoReferenciaParameterReturnGeneral cargarCombosLoteForeignKeyTelefonoReferenciaWithConnection(String finalQueryGlobalReferencia) throws Exception {
		TelefonoReferenciaParameterReturnGeneral  telefonoreferenciaReturnGeneral =new TelefonoReferenciaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TelefonoReferencia.class.getSimpleName()+"-cargarCombosLoteForeignKeyTelefonoReferenciaWithConnection");connexion.begin();
			
			telefonoreferenciaReturnGeneral =new TelefonoReferenciaParameterReturnGeneral();
			
			

			List<Referencia> referenciasForeignKey=new ArrayList<Referencia>();
			ReferenciaLogic referenciaLogic=new ReferenciaLogic();
			referenciaLogic.setConnexion(this.connexion);
			referenciaLogic.getReferenciaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalReferencia.equals("NONE")) {
				referenciaLogic.getTodosReferencias(finalQueryGlobalReferencia,new Pagination());
				referenciasForeignKey=referenciaLogic.getReferencias();
			}

			telefonoreferenciaReturnGeneral.setreferenciasForeignKey(referenciasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return telefonoreferenciaReturnGeneral;
	}
	
	public TelefonoReferenciaParameterReturnGeneral cargarCombosLoteForeignKeyTelefonoReferencia(String finalQueryGlobalReferencia) throws Exception {
		TelefonoReferenciaParameterReturnGeneral  telefonoreferenciaReturnGeneral =new TelefonoReferenciaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			telefonoreferenciaReturnGeneral =new TelefonoReferenciaParameterReturnGeneral();
			
			

			List<Referencia> referenciasForeignKey=new ArrayList<Referencia>();
			ReferenciaLogic referenciaLogic=new ReferenciaLogic();
			referenciaLogic.setConnexion(this.connexion);
			referenciaLogic.getReferenciaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalReferencia.equals("NONE")) {
				referenciaLogic.getTodosReferencias(finalQueryGlobalReferencia,new Pagination());
				referenciasForeignKey=referenciaLogic.getReferencias();
			}

			telefonoreferenciaReturnGeneral.setreferenciasForeignKey(referenciasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return telefonoreferenciaReturnGeneral;
	}
	
	
	public void deepLoad(TelefonoReferencia telefonoreferencia,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TelefonoReferenciaLogicAdditional.updateTelefonoReferenciaToGet(telefonoreferencia,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		telefonoreferencia.setReferencia(telefonoreferenciaDataAccess.getReferencia(connexion,telefonoreferencia));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Referencia.class)) {
				telefonoreferencia.setReferencia(telefonoreferenciaDataAccess.getReferencia(connexion,telefonoreferencia));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Referencia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			telefonoreferencia.setReferencia(telefonoreferenciaDataAccess.getReferencia(connexion,telefonoreferencia));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		telefonoreferencia.setReferencia(telefonoreferenciaDataAccess.getReferencia(connexion,telefonoreferencia));
		ReferenciaLogic referenciaLogic= new ReferenciaLogic(connexion);
		referenciaLogic.deepLoad(telefonoreferencia.getReferencia(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Referencia.class)) {
				telefonoreferencia.setReferencia(telefonoreferenciaDataAccess.getReferencia(connexion,telefonoreferencia));
				ReferenciaLogic referenciaLogic= new ReferenciaLogic(connexion);
				referenciaLogic.deepLoad(telefonoreferencia.getReferencia(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Referencia.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			telefonoreferencia.setReferencia(telefonoreferenciaDataAccess.getReferencia(connexion,telefonoreferencia));
			ReferenciaLogic referenciaLogic= new ReferenciaLogic(connexion);
			referenciaLogic.deepLoad(telefonoreferencia.getReferencia(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TelefonoReferencia telefonoreferencia,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TelefonoReferenciaLogicAdditional.updateTelefonoReferenciaToSave(telefonoreferencia,this.arrDatoGeneral);
			
TelefonoReferenciaDataAccess.save(telefonoreferencia, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ReferenciaDataAccess.save(telefonoreferencia.getReferencia(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Referencia.class)) {
				ReferenciaDataAccess.save(telefonoreferencia.getReferencia(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ReferenciaDataAccess.save(telefonoreferencia.getReferencia(),connexion);
		ReferenciaLogic referenciaLogic= new ReferenciaLogic(connexion);
		referenciaLogic.deepLoad(telefonoreferencia.getReferencia(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Referencia.class)) {
				ReferenciaDataAccess.save(telefonoreferencia.getReferencia(),connexion);
				ReferenciaLogic referenciaLogic= new ReferenciaLogic(connexion);
				referenciaLogic.deepSave(telefonoreferencia.getReferencia(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(TelefonoReferencia.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(telefonoreferencia,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TelefonoReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTelefonoReferencia(telefonoreferencia);
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
			this.deepLoad(this.telefonoreferencia,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TelefonoReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTelefonoReferencia(this.telefonoreferencia);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TelefonoReferencia.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(telefonoreferencias!=null) {
				for(TelefonoReferencia telefonoreferencia:telefonoreferencias) {
					this.deepLoad(telefonoreferencia,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TelefonoReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTelefonoReferencia(telefonoreferencias);
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
			if(telefonoreferencias!=null) {
				for(TelefonoReferencia telefonoreferencia:telefonoreferencias) {
					this.deepLoad(telefonoreferencia,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TelefonoReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTelefonoReferencia(telefonoreferencias);
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
			this.getNewConnexionToDeep(TelefonoReferencia.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(telefonoreferencia,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TelefonoReferencia.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(telefonoreferencias!=null) {
				for(TelefonoReferencia telefonoreferencia:telefonoreferencias) {
					this.deepSave(telefonoreferencia,isDeep,deepLoadType,clases);
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
			if(telefonoreferencias!=null) {
				for(TelefonoReferencia telefonoreferencia:telefonoreferencias) {
					this.deepSave(telefonoreferencia,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTelefonoReferenciasFK_IdReferenciaWithConnection(String sFinalQuery,Pagination pagination,Long id_referencia)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TelefonoReferencia.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidReferencia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidReferencia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_referencia,TelefonoReferenciaConstantesFunciones.IDREFERENCIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidReferencia);

			TelefonoReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdReferencia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			telefonoreferencias=telefonoreferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TelefonoReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTelefonoReferencia(this.telefonoreferencias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTelefonoReferenciasFK_IdReferencia(String sFinalQuery,Pagination pagination,Long id_referencia)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidReferencia= new ParameterSelectionGeneral();
			parameterSelectionGeneralidReferencia.setParameterSelectionGeneralEqual(ParameterType.LONG,id_referencia,TelefonoReferenciaConstantesFunciones.IDREFERENCIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidReferencia);

			TelefonoReferenciaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdReferencia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			telefonoreferencias=telefonoreferenciaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TelefonoReferenciaConstantesFunciones.refrescarForeignKeysDescripcionesTelefonoReferencia(this.telefonoreferencias);
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
			if(TelefonoReferenciaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TelefonoReferenciaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TelefonoReferencia telefonoreferencia,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TelefonoReferenciaConstantesFunciones.ISCONAUDITORIA) {
				if(telefonoreferencia.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TelefonoReferenciaDataAccess.TABLENAME, telefonoreferencia.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TelefonoReferenciaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TelefonoReferenciaLogic.registrarAuditoriaDetallesTelefonoReferencia(connexion,telefonoreferencia,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(telefonoreferencia.getIsDeleted()) {
					/*if(!telefonoreferencia.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TelefonoReferenciaDataAccess.TABLENAME, telefonoreferencia.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TelefonoReferenciaLogic.registrarAuditoriaDetallesTelefonoReferencia(connexion,telefonoreferencia,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TelefonoReferenciaDataAccess.TABLENAME, telefonoreferencia.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(telefonoreferencia.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TelefonoReferenciaDataAccess.TABLENAME, telefonoreferencia.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TelefonoReferenciaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TelefonoReferenciaLogic.registrarAuditoriaDetallesTelefonoReferencia(connexion,telefonoreferencia,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTelefonoReferencia(Connexion connexion,TelefonoReferencia telefonoreferencia)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(telefonoreferencia.getIsNew()||!telefonoreferencia.getid_referencia().equals(telefonoreferencia.getTelefonoReferenciaOriginal().getid_referencia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(telefonoreferencia.getTelefonoReferenciaOriginal().getid_referencia()!=null)
				{
					strValorActual=telefonoreferencia.getTelefonoReferenciaOriginal().getid_referencia().toString();
				}
				if(telefonoreferencia.getid_referencia()!=null)
				{
					strValorNuevo=telefonoreferencia.getid_referencia().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TelefonoReferenciaConstantesFunciones.IDREFERENCIA,strValorActual,strValorNuevo);
			}	
			
			if(telefonoreferencia.getIsNew()||!telefonoreferencia.getnumero().equals(telefonoreferencia.getTelefonoReferenciaOriginal().getnumero()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(telefonoreferencia.getTelefonoReferenciaOriginal().getnumero()!=null)
				{
					strValorActual=telefonoreferencia.getTelefonoReferenciaOriginal().getnumero();
				}
				if(telefonoreferencia.getnumero()!=null)
				{
					strValorNuevo=telefonoreferencia.getnumero() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TelefonoReferenciaConstantesFunciones.NUMERO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTelefonoReferenciaRelacionesWithConnection(TelefonoReferencia telefonoreferencia) throws Exception {

		if(!telefonoreferencia.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTelefonoReferenciaRelacionesBase(telefonoreferencia,true);
		}
	}

	public void saveTelefonoReferenciaRelaciones(TelefonoReferencia telefonoreferencia)throws Exception {

		if(!telefonoreferencia.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTelefonoReferenciaRelacionesBase(telefonoreferencia,false);
		}
	}

	public void saveTelefonoReferenciaRelacionesBase(TelefonoReferencia telefonoreferencia,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TelefonoReferencia-saveRelacionesWithConnection");}
	

			this.setTelefonoReferencia(telefonoreferencia);

			if(TelefonoReferenciaLogicAdditional.validarSaveRelaciones(telefonoreferencia,this)) {

				TelefonoReferenciaLogicAdditional.updateRelacionesToSave(telefonoreferencia,this);

				if((telefonoreferencia.getIsNew()||telefonoreferencia.getIsChanged())&&!telefonoreferencia.getIsDeleted()) {
					this.saveTelefonoReferencia();
					this.saveTelefonoReferenciaRelacionesDetalles();

				} else if(telefonoreferencia.getIsDeleted()) {
					this.saveTelefonoReferenciaRelacionesDetalles();
					this.saveTelefonoReferencia();
				}

				TelefonoReferenciaLogicAdditional.updateRelacionesToSaveAfter(telefonoreferencia,this);

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
	
	
	private void saveTelefonoReferenciaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTelefonoReferencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TelefonoReferenciaConstantesFunciones.getClassesForeignKeysOfTelefonoReferencia(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTelefonoReferencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TelefonoReferenciaConstantesFunciones.getClassesRelationshipsOfTelefonoReferencia(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

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
package com.bydan.erp.seguridad.business.logic;

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
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.seguridad.util.AuditoriaConstantesFunciones;
import com.bydan.erp.seguridad.util.AuditoriaParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.AuditoriaParameterGeneral;
import com.bydan.erp.seguridad.business.entity.Auditoria;
import com.bydan.erp.seguridad.business.logic.AuditoriaLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class AuditoriaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(AuditoriaLogic.class);
	
	protected AuditoriaDataAccess auditoriaDataAccess; 	
	protected Auditoria auditoria;
	protected List<Auditoria> auditorias;
	protected Object auditoriaObject;	
	protected List<Object> auditoriasObject;
	
	public static ClassValidator<Auditoria> auditoriaValidator = new ClassValidator<Auditoria>(Auditoria.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected AuditoriaLogicAdditional auditoriaLogicAdditional=null;
	
	public AuditoriaLogicAdditional getAuditoriaLogicAdditional() {
		return this.auditoriaLogicAdditional;
	}
	
	public void setAuditoriaLogicAdditional(AuditoriaLogicAdditional auditoriaLogicAdditional) {
		try {
			this.auditoriaLogicAdditional=auditoriaLogicAdditional;
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
	
	
	
	
	public  AuditoriaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.auditoriaDataAccess = new AuditoriaDataAccess();
			
			this.auditorias= new ArrayList<Auditoria>();
			this.auditoria= new Auditoria();
			
			this.auditoriaObject=new Object();
			this.auditoriasObject=new ArrayList<Object>();
				
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
			
			this.auditoriaDataAccess.setConnexionType(this.connexionType);
			this.auditoriaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  AuditoriaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.auditoriaDataAccess = new AuditoriaDataAccess();
			this.auditorias= new ArrayList<Auditoria>();
			this.auditoria= new Auditoria();
			this.auditoriaObject=new Object();
			this.auditoriasObject=new ArrayList<Object>();
			
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
			
			this.auditoriaDataAccess.setConnexionType(this.connexionType);
			this.auditoriaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Auditoria getAuditoria() throws Exception {	
		AuditoriaLogicAdditional.checkAuditoriaToGet(auditoria,this.datosCliente,this.arrDatoGeneral);
		AuditoriaLogicAdditional.updateAuditoriaToGet(auditoria,this.arrDatoGeneral);
		
		return auditoria;
	}
		
	public void setAuditoria(Auditoria newAuditoria) {
		this.auditoria = newAuditoria;
	}
	
	public AuditoriaDataAccess getAuditoriaDataAccess() {
		return auditoriaDataAccess;
	}
	
	public void setAuditoriaDataAccess(AuditoriaDataAccess newauditoriaDataAccess) {
		this.auditoriaDataAccess = newauditoriaDataAccess;
	}
	
	public List<Auditoria> getAuditorias() throws Exception {		
		this.quitarAuditoriasNulos();
		
		AuditoriaLogicAdditional.checkAuditoriaToGets(auditorias,this.datosCliente,this.arrDatoGeneral);
		
		for (Auditoria auditoriaLocal: auditorias ) {
			AuditoriaLogicAdditional.updateAuditoriaToGet(auditoriaLocal,this.arrDatoGeneral);
		}
		
		return auditorias;
	}
	
	public void setAuditorias(List<Auditoria> newAuditorias) {
		this.auditorias = newAuditorias;
	}
	
	public Object getAuditoriaObject() {	
		this.auditoriaObject=this.auditoriaDataAccess.getEntityObject();
		return this.auditoriaObject;
	}
		
	public void setAuditoriaObject(Object newAuditoriaObject) {
		this.auditoriaObject = newAuditoriaObject;
	}
	
	public List<Object> getAuditoriasObject() {		
		this.auditoriasObject=this.auditoriaDataAccess.getEntitiesObject();
		return this.auditoriasObject;
	}
		
	public void setAuditoriasObject(List<Object> newAuditoriasObject) {
		this.auditoriasObject = newAuditoriasObject;
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
		
		if(this.auditoriaDataAccess!=null) {
			this.auditoriaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Auditoria.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			auditoriaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			auditoriaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		auditoria = new  Auditoria();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Auditoria.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			auditoria=auditoriaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.auditoria,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AuditoriaConstantesFunciones.refrescarForeignKeysDescripcionesAuditoria(this.auditoria);
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
		auditoria = new  Auditoria();
		  		  
        try {
			
			auditoria=auditoriaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.auditoria,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AuditoriaConstantesFunciones.refrescarForeignKeysDescripcionesAuditoria(this.auditoria);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		auditoria = new  Auditoria();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Auditoria.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			auditoria=auditoriaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.auditoria,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AuditoriaConstantesFunciones.refrescarForeignKeysDescripcionesAuditoria(this.auditoria);
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
		auditoria = new  Auditoria();
		  		  
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
		auditoria = new  Auditoria();
		  		  
        try {
			
			auditoria=auditoriaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.auditoria,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AuditoriaConstantesFunciones.refrescarForeignKeysDescripcionesAuditoria(this.auditoria);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		auditoria = new  Auditoria();
		  		  
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
		auditoria = new  Auditoria();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Auditoria.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =auditoriaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		auditoria = new  Auditoria();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=auditoriaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		auditoria = new  Auditoria();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Auditoria.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =auditoriaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		auditoria = new  Auditoria();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=auditoriaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		auditoria = new  Auditoria();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Auditoria.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =auditoriaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		auditoria = new  Auditoria();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=auditoriaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		auditorias = new  ArrayList<Auditoria>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Auditoria.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			AuditoriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			auditorias=auditoriaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAuditoria(auditorias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AuditoriaConstantesFunciones.refrescarForeignKeysDescripcionesAuditoria(this.auditorias);
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
		auditorias = new  ArrayList<Auditoria>();
		  		  
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
		auditorias = new  ArrayList<Auditoria>();
		  		  
        try {			
			AuditoriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			auditorias=auditoriaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarAuditoria(auditorias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AuditoriaConstantesFunciones.refrescarForeignKeysDescripcionesAuditoria(this.auditorias);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		auditorias = new  ArrayList<Auditoria>();
		  		  
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
		auditorias = new  ArrayList<Auditoria>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Auditoria.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			AuditoriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			auditorias=auditoriaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAuditoria(auditorias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AuditoriaConstantesFunciones.refrescarForeignKeysDescripcionesAuditoria(this.auditorias);
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
		auditorias = new  ArrayList<Auditoria>();
		  		  
        try {
			AuditoriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			auditorias=auditoriaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAuditoria(auditorias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AuditoriaConstantesFunciones.refrescarForeignKeysDescripcionesAuditoria(this.auditorias);
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
		auditorias = new  ArrayList<Auditoria>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Auditoria.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AuditoriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			auditorias=auditoriaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAuditoria(auditorias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AuditoriaConstantesFunciones.refrescarForeignKeysDescripcionesAuditoria(this.auditorias);
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
		auditorias = new  ArrayList<Auditoria>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AuditoriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			auditorias=auditoriaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAuditoria(auditorias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AuditoriaConstantesFunciones.refrescarForeignKeysDescripcionesAuditoria(this.auditorias);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		auditoria = new  Auditoria();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Auditoria.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AuditoriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			auditoria=auditoriaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAuditoria(auditoria);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AuditoriaConstantesFunciones.refrescarForeignKeysDescripcionesAuditoria(this.auditoria);
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
		auditoria = new  Auditoria();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AuditoriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			auditoria=auditoriaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAuditoria(auditoria);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AuditoriaConstantesFunciones.refrescarForeignKeysDescripcionesAuditoria(this.auditoria);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		auditorias = new  ArrayList<Auditoria>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Auditoria.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			AuditoriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			auditorias=auditoriaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAuditoria(auditorias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AuditoriaConstantesFunciones.refrescarForeignKeysDescripcionesAuditoria(this.auditorias);
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
		auditorias = new  ArrayList<Auditoria>();
		  		  
        try {
			AuditoriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			auditorias=auditoriaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAuditoria(auditorias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AuditoriaConstantesFunciones.refrescarForeignKeysDescripcionesAuditoria(this.auditorias);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosAuditoriasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		auditorias = new  ArrayList<Auditoria>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Auditoria.class.getSimpleName()+"-getTodosAuditoriasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AuditoriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			auditorias=auditoriaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarAuditoria(auditorias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AuditoriaConstantesFunciones.refrescarForeignKeysDescripcionesAuditoria(this.auditorias);
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
	
	public  void  getTodosAuditorias(String sFinalQuery,Pagination pagination)throws Exception {
		auditorias = new  ArrayList<Auditoria>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AuditoriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			auditorias=auditoriaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarAuditoria(auditorias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AuditoriaConstantesFunciones.refrescarForeignKeysDescripcionesAuditoria(this.auditorias);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarAuditoria(Auditoria auditoria) throws Exception {
		Boolean estaValidado=false;
		
		if(auditoria.getIsNew() || auditoria.getIsChanged()) { 
			this.invalidValues = auditoriaValidator.getInvalidValues(auditoria);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(auditoria);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarAuditoria(List<Auditoria> Auditorias) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Auditoria auditoriaLocal:auditorias) {				
			estaValidadoObjeto=this.validarGuardarAuditoria(auditoriaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarAuditoria(List<Auditoria> Auditorias) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarAuditoria(auditorias)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarAuditoria(Auditoria Auditoria) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarAuditoria(auditoria)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Auditoria auditoria) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+auditoria.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=AuditoriaConstantesFunciones.getAuditoriaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"auditoria","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(AuditoriaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(AuditoriaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveAuditoriaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Auditoria.class.getSimpleName()+"-saveAuditoriaWithConnection");connexion.begin();			
			
			AuditoriaLogicAdditional.checkAuditoriaToSave(this.auditoria,this.datosCliente,connexion,this.arrDatoGeneral);
			
			AuditoriaLogicAdditional.updateAuditoriaToSave(this.auditoria,this.arrDatoGeneral);
			
			AuditoriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.auditoria,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowAuditoria();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarAuditoria(this.auditoria)) {
				AuditoriaDataAccess.save(this.auditoria, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.auditoria,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			AuditoriaLogicAdditional.checkAuditoriaToSaveAfter(this.auditoria,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowAuditoria();
			
			connexion.commit();			
			
			if(this.auditoria.getIsDeleted()) {
				this.auditoria=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveAuditoria()throws Exception {	
		try {	
			
			AuditoriaLogicAdditional.checkAuditoriaToSave(this.auditoria,this.datosCliente,connexion,this.arrDatoGeneral);
			
			AuditoriaLogicAdditional.updateAuditoriaToSave(this.auditoria,this.arrDatoGeneral);
			
			AuditoriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.auditoria,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarAuditoria(this.auditoria)) {			
				AuditoriaDataAccess.save(this.auditoria, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.auditoria,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			AuditoriaLogicAdditional.checkAuditoriaToSaveAfter(this.auditoria,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.auditoria.getIsDeleted()) {
				this.auditoria=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveAuditoriasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Auditoria.class.getSimpleName()+"-saveAuditoriasWithConnection");connexion.begin();			
			
			AuditoriaLogicAdditional.checkAuditoriaToSaves(auditorias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowAuditorias();
			
			Boolean validadoTodosAuditoria=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Auditoria auditoriaLocal:auditorias) {		
				if(auditoriaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				AuditoriaLogicAdditional.updateAuditoriaToSave(auditoriaLocal,this.arrDatoGeneral);
	        	
				AuditoriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),auditoriaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarAuditoria(auditoriaLocal)) {
					AuditoriaDataAccess.save(auditoriaLocal, connexion);				
				} else {
					validadoTodosAuditoria=false;
				}
			}
			
			if(!validadoTodosAuditoria) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			AuditoriaLogicAdditional.checkAuditoriaToSavesAfter(auditorias,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowAuditorias();
			
			connexion.commit();		
			
			this.quitarAuditoriasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveAuditorias()throws Exception {				
		 try {	
			AuditoriaLogicAdditional.checkAuditoriaToSaves(auditorias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosAuditoria=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Auditoria auditoriaLocal:auditorias) {				
				if(auditoriaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				AuditoriaLogicAdditional.updateAuditoriaToSave(auditoriaLocal,this.arrDatoGeneral);
	        	
				AuditoriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),auditoriaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarAuditoria(auditoriaLocal)) {				
					AuditoriaDataAccess.save(auditoriaLocal, connexion);				
				} else {
					validadoTodosAuditoria=false;
				}
			}
			
			if(!validadoTodosAuditoria) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			AuditoriaLogicAdditional.checkAuditoriaToSavesAfter(auditorias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarAuditoriasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public AuditoriaParameterReturnGeneral procesarAccionAuditorias(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Auditoria> auditorias,AuditoriaParameterReturnGeneral auditoriaParameterGeneral)throws Exception {
		 try {	
			AuditoriaParameterReturnGeneral auditoriaReturnGeneral=new AuditoriaParameterReturnGeneral();
	
			AuditoriaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,auditorias,auditoriaParameterGeneral,auditoriaReturnGeneral);
			
			return auditoriaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public AuditoriaParameterReturnGeneral procesarAccionAuditoriasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Auditoria> auditorias,AuditoriaParameterReturnGeneral auditoriaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Auditoria.class.getSimpleName()+"-procesarAccionAuditoriasWithConnection");connexion.begin();			
			
			AuditoriaParameterReturnGeneral auditoriaReturnGeneral=new AuditoriaParameterReturnGeneral();
	
			AuditoriaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,auditorias,auditoriaParameterGeneral,auditoriaReturnGeneral);
			
			this.connexion.commit();
			
			return auditoriaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public AuditoriaParameterReturnGeneral procesarEventosAuditorias(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Auditoria> auditorias,Auditoria auditoria,AuditoriaParameterReturnGeneral auditoriaParameterGeneral,Boolean isEsNuevoAuditoria,ArrayList<Classe> clases)throws Exception {
		 try {	
			AuditoriaParameterReturnGeneral auditoriaReturnGeneral=new AuditoriaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				auditoriaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			AuditoriaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,auditorias,auditoria,auditoriaParameterGeneral,auditoriaReturnGeneral,isEsNuevoAuditoria,clases);
			
			return auditoriaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public AuditoriaParameterReturnGeneral procesarEventosAuditoriasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Auditoria> auditorias,Auditoria auditoria,AuditoriaParameterReturnGeneral auditoriaParameterGeneral,Boolean isEsNuevoAuditoria,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Auditoria.class.getSimpleName()+"-procesarEventosAuditoriasWithConnection");connexion.begin();			
			
			AuditoriaParameterReturnGeneral auditoriaReturnGeneral=new AuditoriaParameterReturnGeneral();
	
			auditoriaReturnGeneral.setAuditoria(auditoria);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				auditoriaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			AuditoriaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,auditorias,auditoria,auditoriaParameterGeneral,auditoriaReturnGeneral,isEsNuevoAuditoria,clases);
			
			this.connexion.commit();
			
			return auditoriaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public AuditoriaParameterReturnGeneral procesarImportacionAuditoriasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,AuditoriaParameterReturnGeneral auditoriaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Auditoria.class.getSimpleName()+"-procesarImportacionAuditoriasWithConnection");connexion.begin();			
			
			AuditoriaParameterReturnGeneral auditoriaReturnGeneral=new AuditoriaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.auditorias=new ArrayList<Auditoria>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.auditoria=new Auditoria();
				
				
				if(conColumnasBase) {this.auditoria.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.auditoria.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.auditoria.setnombre_tabla(arrColumnas[iColumn++]);
				this.auditoria.setid_fila(Long.parseLong(arrColumnas[iColumn++]));
				this.auditoria.setaccion(arrColumnas[iColumn++]);
				this.auditoria.setproceso(arrColumnas[iColumn++]);
				this.auditoria.setnombre_p_c(arrColumnas[iColumn++]);
				this.auditoria.setip_pc(arrColumnas[iColumn++]);
				this.auditoria.setusuario_p_c(arrColumnas[iColumn++]);
				//this.auditoria.setfecha_hora(new Timestamp(arrColumnas[iColumn++].getTime()));
			this.auditoria.setobservacion(arrColumnas[iColumn++]);
				
				this.auditorias.add(this.auditoria);
			}
			
			this.saveAuditorias();
			
			this.connexion.commit();
			
			auditoriaReturnGeneral.setConRetornoEstaProcesado(true);
			auditoriaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return auditoriaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarAuditoriasEliminados() throws Exception {				
		
		List<Auditoria> auditoriasAux= new ArrayList<Auditoria>();
		
		for(Auditoria auditoria:auditorias) {
			if(!auditoria.getIsDeleted()) {
				auditoriasAux.add(auditoria);
			}
		}
		
		auditorias=auditoriasAux;
	}
	
	public void quitarAuditoriasNulos() throws Exception {				
		
		List<Auditoria> auditoriasAux= new ArrayList<Auditoria>();
		
		for(Auditoria auditoria : this.auditorias) {
			if(auditoria==null) {
				auditoriasAux.add(auditoria);
			}
		}
		
		//this.auditorias=auditoriasAux;
		
		this.auditorias.removeAll(auditoriasAux);
	}
	
	public void getSetVersionRowAuditoriaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(auditoria.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((auditoria.getIsDeleted() || (auditoria.getIsChanged()&&!auditoria.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=auditoriaDataAccess.getSetVersionRowAuditoria(connexion,auditoria.getId());
				
				if(!auditoria.getVersionRow().equals(timestamp)) {	
					auditoria.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				auditoria.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowAuditoria()throws Exception {	
		
		if(auditoria.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((auditoria.getIsDeleted() || (auditoria.getIsChanged()&&!auditoria.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=auditoriaDataAccess.getSetVersionRowAuditoria(connexion,auditoria.getId());
			
			try {							
				if(!auditoria.getVersionRow().equals(timestamp)) {	
					auditoria.setVersionRow(timestamp);
				}
				
				auditoria.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowAuditoriasWithConnection()throws Exception {	
		if(auditorias!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Auditoria auditoriaAux:auditorias) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(auditoriaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(auditoriaAux.getIsDeleted() || (auditoriaAux.getIsChanged()&&!auditoriaAux.getIsNew())) {
						
						timestamp=auditoriaDataAccess.getSetVersionRowAuditoria(connexion,auditoriaAux.getId());
						
						if(!auditoria.getVersionRow().equals(timestamp)) {	
							auditoriaAux.setVersionRow(timestamp);
						}
								
						auditoriaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowAuditorias()throws Exception {	
		if(auditorias!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Auditoria auditoriaAux:auditorias) {
					if(auditoriaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(auditoriaAux.getIsDeleted() || (auditoriaAux.getIsChanged()&&!auditoriaAux.getIsNew())) {
						
						timestamp=auditoriaDataAccess.getSetVersionRowAuditoria(connexion,auditoriaAux.getId());
						
						if(!auditoriaAux.getVersionRow().equals(timestamp)) {	
							auditoriaAux.setVersionRow(timestamp);
						}
						
													
						auditoriaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public AuditoriaParameterReturnGeneral cargarCombosLoteForeignKeyAuditoriaWithConnection(String finalQueryGlobalUsuario) throws Exception {
		AuditoriaParameterReturnGeneral  auditoriaReturnGeneral =new AuditoriaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Auditoria.class.getSimpleName()+"-cargarCombosLoteForeignKeyAuditoriaWithConnection");connexion.begin();
			
			auditoriaReturnGeneral =new AuditoriaParameterReturnGeneral();
			
			

			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			auditoriaReturnGeneral.setusuariosForeignKey(usuariosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return auditoriaReturnGeneral;
	}
	
	public AuditoriaParameterReturnGeneral cargarCombosLoteForeignKeyAuditoria(String finalQueryGlobalUsuario) throws Exception {
		AuditoriaParameterReturnGeneral  auditoriaReturnGeneral =new AuditoriaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			auditoriaReturnGeneral =new AuditoriaParameterReturnGeneral();
			
			

			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			auditoriaReturnGeneral.setusuariosForeignKey(usuariosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return auditoriaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyAuditoriaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			AuditoriaDetalleLogic auditoriadetalleLogic=new AuditoriaDetalleLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Auditoria.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyAuditoriaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(AuditoriaDetalle.class));
											
			

			auditoriadetalleLogic.setConnexion(this.getConnexion());
			auditoriadetalleLogic.setDatosCliente(this.datosCliente);
			auditoriadetalleLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Auditoria auditoria:this.auditorias) {
				

				classes=new ArrayList<Classe>();
				classes=AuditoriaDetalleConstantesFunciones.getClassesForeignKeysOfAuditoriaDetalle(new ArrayList<Classe>(),DeepLoadType.NONE);

				auditoriadetalleLogic.setAuditoriaDetalles(auditoria.auditoriadetalles);
				auditoriadetalleLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Auditoria auditoria,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			AuditoriaLogicAdditional.updateAuditoriaToGet(auditoria,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		auditoria.setUsuario(auditoriaDataAccess.getUsuario(connexion,auditoria));
		auditoria.setAuditoriaDetalles(auditoriaDataAccess.getAuditoriaDetalles(connexion,auditoria));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				auditoria.setUsuario(auditoriaDataAccess.getUsuario(connexion,auditoria));
				continue;
			}

			if(clas.clas.equals(AuditoriaDetalle.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				auditoria.setAuditoriaDetalles(auditoriaDataAccess.getAuditoriaDetalles(connexion,auditoria));

				if(this.isConDeep) {
					AuditoriaDetalleLogic auditoriadetalleLogic= new AuditoriaDetalleLogic(this.connexion);
					auditoriadetalleLogic.setAuditoriaDetalles(auditoria.getAuditoriaDetalles());
					ArrayList<Classe> classesLocal=AuditoriaDetalleConstantesFunciones.getClassesForeignKeysOfAuditoriaDetalle(new ArrayList<Classe>(),DeepLoadType.NONE);
					auditoriadetalleLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					AuditoriaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesAuditoriaDetalle(auditoriadetalleLogic.getAuditoriaDetalles());
					auditoria.setAuditoriaDetalles(auditoriadetalleLogic.getAuditoriaDetalles());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			auditoria.setUsuario(auditoriaDataAccess.getUsuario(connexion,auditoria));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AuditoriaDetalle.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(AuditoriaDetalle.class));
			auditoria.setAuditoriaDetalles(auditoriaDataAccess.getAuditoriaDetalles(connexion,auditoria));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		auditoria.setUsuario(auditoriaDataAccess.getUsuario(connexion,auditoria));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(auditoria.getUsuario(),isDeep,deepLoadType,clases);
				

		auditoria.setAuditoriaDetalles(auditoriaDataAccess.getAuditoriaDetalles(connexion,auditoria));

		for(AuditoriaDetalle auditoriadetalle:auditoria.getAuditoriaDetalles()) {
			AuditoriaDetalleLogic auditoriadetalleLogic= new AuditoriaDetalleLogic(connexion);
			auditoriadetalleLogic.deepLoad(auditoriadetalle,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				auditoria.setUsuario(auditoriaDataAccess.getUsuario(connexion,auditoria));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(auditoria.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AuditoriaDetalle.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				auditoria.setAuditoriaDetalles(auditoriaDataAccess.getAuditoriaDetalles(connexion,auditoria));

				for(AuditoriaDetalle auditoriadetalle:auditoria.getAuditoriaDetalles()) {
					AuditoriaDetalleLogic auditoriadetalleLogic= new AuditoriaDetalleLogic(connexion);
					auditoriadetalleLogic.deepLoad(auditoriadetalle,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			auditoria.setUsuario(auditoriaDataAccess.getUsuario(connexion,auditoria));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(auditoria.getUsuario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AuditoriaDetalle.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(AuditoriaDetalle.class));
			auditoria.setAuditoriaDetalles(auditoriaDataAccess.getAuditoriaDetalles(connexion,auditoria));

			for(AuditoriaDetalle auditoriadetalle:auditoria.getAuditoriaDetalles()) {
				AuditoriaDetalleLogic auditoriadetalleLogic= new AuditoriaDetalleLogic(connexion);
				auditoriadetalleLogic.deepLoad(auditoriadetalle,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Auditoria auditoria,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			AuditoriaLogicAdditional.updateAuditoriaToSave(auditoria,this.arrDatoGeneral);
			
AuditoriaDataAccess.save(auditoria, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		UsuarioDataAccess.save(auditoria.getUsuario(),connexion);

		for(AuditoriaDetalle auditoriadetalle:auditoria.getAuditoriaDetalles()) {
			auditoriadetalle.setid_auditoria(auditoria.getId());
			AuditoriaDetalleDataAccess.save(auditoriadetalle,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(auditoria.getUsuario(),connexion);
				continue;
			}


			if(clas.clas.equals(AuditoriaDetalle.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(AuditoriaDetalle auditoriadetalle:auditoria.getAuditoriaDetalles()) {
					auditoriadetalle.setid_auditoria(auditoria.getId());
					AuditoriaDetalleDataAccess.save(auditoriadetalle,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		UsuarioDataAccess.save(auditoria.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(auditoria.getUsuario(),isDeep,deepLoadType,clases);
				

		for(AuditoriaDetalle auditoriadetalle:auditoria.getAuditoriaDetalles()) {
			AuditoriaDetalleLogic auditoriadetalleLogic= new AuditoriaDetalleLogic(connexion);
			auditoriadetalle.setid_auditoria(auditoria.getId());
			AuditoriaDetalleDataAccess.save(auditoriadetalle,connexion);
			auditoriadetalleLogic.deepSave(auditoriadetalle,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(auditoria.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(auditoria.getUsuario(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(AuditoriaDetalle.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(AuditoriaDetalle auditoriadetalle:auditoria.getAuditoriaDetalles()) {
					AuditoriaDetalleLogic auditoriadetalleLogic= new AuditoriaDetalleLogic(connexion);
					auditoriadetalle.setid_auditoria(auditoria.getId());
					AuditoriaDetalleDataAccess.save(auditoriadetalle,connexion);
					auditoriadetalleLogic.deepSave(auditoriadetalle,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Auditoria.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(auditoria,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				AuditoriaConstantesFunciones.refrescarForeignKeysDescripcionesAuditoria(auditoria);
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
			this.deepLoad(this.auditoria,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				AuditoriaConstantesFunciones.refrescarForeignKeysDescripcionesAuditoria(this.auditoria);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Auditoria.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(auditorias!=null) {
				for(Auditoria auditoria:auditorias) {
					this.deepLoad(auditoria,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					AuditoriaConstantesFunciones.refrescarForeignKeysDescripcionesAuditoria(auditorias);
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
			if(auditorias!=null) {
				for(Auditoria auditoria:auditorias) {
					this.deepLoad(auditoria,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					AuditoriaConstantesFunciones.refrescarForeignKeysDescripcionesAuditoria(auditorias);
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
			this.getNewConnexionToDeep(Auditoria.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(auditoria,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Auditoria.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(auditorias!=null) {
				for(Auditoria auditoria:auditorias) {
					this.deepSave(auditoria,isDeep,deepLoadType,clases);
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
			if(auditorias!=null) {
				for(Auditoria auditoria:auditorias) {
					this.deepSave(auditoria,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getAuditoriasBusquedaPorIdUsuarioPorFechaHoraWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario,Timestamp fecha_hora,Timestamp fecha_horaFinal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Auditoria.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,AuditoriaConstantesFunciones.IDUSUARIO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			ParameterSelectionGeneral parameterSelectionGeneralFechaHora= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaHora.setParameterSelectionGeneralMayorIgual(ParameterType.TIMESTAMP,fecha_hora,AuditoriaConstantesFunciones.FECHAHORA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaHora);

			ParameterSelectionGeneral parameterSelectionGeneralFechaHoraFinal= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaHoraFinal.setParameterSelectionGeneralMenorIgual(ParameterType.TIMESTAMP,fecha_horaFinal,AuditoriaConstantesFunciones.FECHAHORA,"Final",ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaHoraFinal);

			AuditoriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdUsuarioPorFechaHora","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			auditorias=auditoriaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AuditoriaConstantesFunciones.refrescarForeignKeysDescripcionesAuditoria(this.auditorias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAuditoriasBusquedaPorIdUsuarioPorFechaHora(String sFinalQuery,Pagination pagination,Long id_usuario,Timestamp fecha_hora,Timestamp fecha_horaFinal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,AuditoriaConstantesFunciones.IDUSUARIO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			ParameterSelectionGeneral parameterSelectionGeneralFechaHora= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaHora.setParameterSelectionGeneralMayorIgual(ParameterType.TIMESTAMP,fecha_hora,AuditoriaConstantesFunciones.FECHAHORA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaHora);

			ParameterSelectionGeneral parameterSelectionGeneralFechaHoraFinal= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaHoraFinal.setParameterSelectionGeneralMenorIgual(ParameterType.TIMESTAMP,fecha_horaFinal,AuditoriaConstantesFunciones.FECHAHORA,"Final",ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaHoraFinal);

			AuditoriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdUsuarioPorFechaHora","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			auditorias=auditoriaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AuditoriaConstantesFunciones.refrescarForeignKeysDescripcionesAuditoria(this.auditorias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAuditoriasBusquedaPorIPPCPorFechaHoraWithConnection(String sFinalQuery,Pagination pagination,String ip_pc,Timestamp fecha_hora,Timestamp fecha_horaFinal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Auditoria.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralIPPC= new ParameterSelectionGeneral();
			parameterSelectionGeneralIPPC.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+ip_pc+"%",AuditoriaConstantesFunciones.IPPC,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralIPPC);

			ParameterSelectionGeneral parameterSelectionGeneralFechaHora= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaHora.setParameterSelectionGeneralMayorIgual(ParameterType.TIMESTAMP,fecha_hora,AuditoriaConstantesFunciones.FECHAHORA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaHora);

			ParameterSelectionGeneral parameterSelectionGeneralFechaHoraFinal= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaHoraFinal.setParameterSelectionGeneralMenorIgual(ParameterType.TIMESTAMP,fecha_horaFinal,AuditoriaConstantesFunciones.FECHAHORA,"Final",ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaHoraFinal);

			AuditoriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIPPCPorFechaHora","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			auditorias=auditoriaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AuditoriaConstantesFunciones.refrescarForeignKeysDescripcionesAuditoria(this.auditorias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAuditoriasBusquedaPorIPPCPorFechaHora(String sFinalQuery,Pagination pagination,String ip_pc,Timestamp fecha_hora,Timestamp fecha_horaFinal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralIPPC= new ParameterSelectionGeneral();
			parameterSelectionGeneralIPPC.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+ip_pc+"%",AuditoriaConstantesFunciones.IPPC,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralIPPC);

			ParameterSelectionGeneral parameterSelectionGeneralFechaHora= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaHora.setParameterSelectionGeneralMayorIgual(ParameterType.TIMESTAMP,fecha_hora,AuditoriaConstantesFunciones.FECHAHORA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaHora);

			ParameterSelectionGeneral parameterSelectionGeneralFechaHoraFinal= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaHoraFinal.setParameterSelectionGeneralMenorIgual(ParameterType.TIMESTAMP,fecha_horaFinal,AuditoriaConstantesFunciones.FECHAHORA,"Final",ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaHoraFinal);

			AuditoriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIPPCPorFechaHora","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			auditorias=auditoriaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AuditoriaConstantesFunciones.refrescarForeignKeysDescripcionesAuditoria(this.auditorias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAuditoriasBusquedaPorNombrePCPorFechaHoraWithConnection(String sFinalQuery,Pagination pagination,String nombre_p_c,Timestamp fecha_hora,Timestamp fecha_horaFinal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Auditoria.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombrePC= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombrePC.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre_p_c+"%",AuditoriaConstantesFunciones.NOMBREPC,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombrePC);

			ParameterSelectionGeneral parameterSelectionGeneralFechaHora= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaHora.setParameterSelectionGeneralMayorIgual(ParameterType.TIMESTAMP,fecha_hora,AuditoriaConstantesFunciones.FECHAHORA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaHora);

			ParameterSelectionGeneral parameterSelectionGeneralFechaHoraFinal= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaHoraFinal.setParameterSelectionGeneralMenorIgual(ParameterType.TIMESTAMP,fecha_horaFinal,AuditoriaConstantesFunciones.FECHAHORA,"Final",ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaHoraFinal);

			AuditoriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombrePCPorFechaHora","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			auditorias=auditoriaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AuditoriaConstantesFunciones.refrescarForeignKeysDescripcionesAuditoria(this.auditorias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAuditoriasBusquedaPorNombrePCPorFechaHora(String sFinalQuery,Pagination pagination,String nombre_p_c,Timestamp fecha_hora,Timestamp fecha_horaFinal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombrePC= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombrePC.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre_p_c+"%",AuditoriaConstantesFunciones.NOMBREPC,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombrePC);

			ParameterSelectionGeneral parameterSelectionGeneralFechaHora= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaHora.setParameterSelectionGeneralMayorIgual(ParameterType.TIMESTAMP,fecha_hora,AuditoriaConstantesFunciones.FECHAHORA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaHora);

			ParameterSelectionGeneral parameterSelectionGeneralFechaHoraFinal= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaHoraFinal.setParameterSelectionGeneralMenorIgual(ParameterType.TIMESTAMP,fecha_horaFinal,AuditoriaConstantesFunciones.FECHAHORA,"Final",ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaHoraFinal);

			AuditoriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombrePCPorFechaHora","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			auditorias=auditoriaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AuditoriaConstantesFunciones.refrescarForeignKeysDescripcionesAuditoria(this.auditorias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAuditoriasBusquedaPorNombreTablaPorFechaHoraWithConnection(String sFinalQuery,Pagination pagination,String nombre_tabla,Timestamp fecha_hora,Timestamp fecha_horaFinal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Auditoria.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombreTabla= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombreTabla.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre_tabla+"%",AuditoriaConstantesFunciones.NOMBRETABLA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombreTabla);

			ParameterSelectionGeneral parameterSelectionGeneralFechaHora= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaHora.setParameterSelectionGeneralMayorIgual(ParameterType.TIMESTAMP,fecha_hora,AuditoriaConstantesFunciones.FECHAHORA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaHora);

			ParameterSelectionGeneral parameterSelectionGeneralFechaHoraFinal= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaHoraFinal.setParameterSelectionGeneralMenorIgual(ParameterType.TIMESTAMP,fecha_horaFinal,AuditoriaConstantesFunciones.FECHAHORA,"Final",ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaHoraFinal);

			AuditoriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombreTablaPorFechaHora","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			auditorias=auditoriaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AuditoriaConstantesFunciones.refrescarForeignKeysDescripcionesAuditoria(this.auditorias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAuditoriasBusquedaPorNombreTablaPorFechaHora(String sFinalQuery,Pagination pagination,String nombre_tabla,Timestamp fecha_hora,Timestamp fecha_horaFinal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombreTabla= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombreTabla.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre_tabla+"%",AuditoriaConstantesFunciones.NOMBRETABLA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombreTabla);

			ParameterSelectionGeneral parameterSelectionGeneralFechaHora= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaHora.setParameterSelectionGeneralMayorIgual(ParameterType.TIMESTAMP,fecha_hora,AuditoriaConstantesFunciones.FECHAHORA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaHora);

			ParameterSelectionGeneral parameterSelectionGeneralFechaHoraFinal= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaHoraFinal.setParameterSelectionGeneralMenorIgual(ParameterType.TIMESTAMP,fecha_horaFinal,AuditoriaConstantesFunciones.FECHAHORA,"Final",ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaHoraFinal);

			AuditoriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombreTablaPorFechaHora","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			auditorias=auditoriaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AuditoriaConstantesFunciones.refrescarForeignKeysDescripcionesAuditoria(this.auditorias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAuditoriasBusquedaPorObservacionesPorFechaHoraWithConnection(String sFinalQuery,Pagination pagination,Timestamp fecha_hora,Timestamp fecha_horaFinal,String observacion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Auditoria.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralFechaHora= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaHora.setParameterSelectionGeneralMayorIgual(ParameterType.TIMESTAMP,fecha_hora,AuditoriaConstantesFunciones.FECHAHORA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaHora);

			ParameterSelectionGeneral parameterSelectionGeneralFechaHoraFinal= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaHoraFinal.setParameterSelectionGeneralMenorIgual(ParameterType.TIMESTAMP,fecha_horaFinal,AuditoriaConstantesFunciones.FECHAHORA,"Final",ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaHoraFinal);

			ParameterSelectionGeneral parameterSelectionGeneralObservacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralObservacion.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+observacion+"%",AuditoriaConstantesFunciones.OBSERVACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralObservacion);

			AuditoriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorObservacionesPorFechaHora","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			auditorias=auditoriaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AuditoriaConstantesFunciones.refrescarForeignKeysDescripcionesAuditoria(this.auditorias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAuditoriasBusquedaPorObservacionesPorFechaHora(String sFinalQuery,Pagination pagination,Timestamp fecha_hora,Timestamp fecha_horaFinal,String observacion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralFechaHora= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaHora.setParameterSelectionGeneralMayorIgual(ParameterType.TIMESTAMP,fecha_hora,AuditoriaConstantesFunciones.FECHAHORA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaHora);

			ParameterSelectionGeneral parameterSelectionGeneralFechaHoraFinal= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaHoraFinal.setParameterSelectionGeneralMenorIgual(ParameterType.TIMESTAMP,fecha_horaFinal,AuditoriaConstantesFunciones.FECHAHORA,"Final",ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaHoraFinal);

			ParameterSelectionGeneral parameterSelectionGeneralObservacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralObservacion.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+observacion+"%",AuditoriaConstantesFunciones.OBSERVACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralObservacion);

			AuditoriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorObservacionesPorFechaHora","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			auditorias=auditoriaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AuditoriaConstantesFunciones.refrescarForeignKeysDescripcionesAuditoria(this.auditorias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAuditoriasBusquedaPorProcesoPorFechaHoraWithConnection(String sFinalQuery,Pagination pagination,String proceso,Timestamp fecha_hora,Timestamp fecha_horaFinal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Auditoria.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralProceso= new ParameterSelectionGeneral();
			parameterSelectionGeneralProceso.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+proceso+"%",AuditoriaConstantesFunciones.PROCESO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralProceso);

			ParameterSelectionGeneral parameterSelectionGeneralFechaHora= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaHora.setParameterSelectionGeneralMayorIgual(ParameterType.TIMESTAMP,fecha_hora,AuditoriaConstantesFunciones.FECHAHORA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaHora);

			ParameterSelectionGeneral parameterSelectionGeneralFechaHoraFinal= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaHoraFinal.setParameterSelectionGeneralMenorIgual(ParameterType.TIMESTAMP,fecha_horaFinal,AuditoriaConstantesFunciones.FECHAHORA,"Final",ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaHoraFinal);

			AuditoriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorProcesoPorFechaHora","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			auditorias=auditoriaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AuditoriaConstantesFunciones.refrescarForeignKeysDescripcionesAuditoria(this.auditorias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAuditoriasBusquedaPorProcesoPorFechaHora(String sFinalQuery,Pagination pagination,String proceso,Timestamp fecha_hora,Timestamp fecha_horaFinal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralProceso= new ParameterSelectionGeneral();
			parameterSelectionGeneralProceso.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+proceso+"%",AuditoriaConstantesFunciones.PROCESO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralProceso);

			ParameterSelectionGeneral parameterSelectionGeneralFechaHora= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaHora.setParameterSelectionGeneralMayorIgual(ParameterType.TIMESTAMP,fecha_hora,AuditoriaConstantesFunciones.FECHAHORA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaHora);

			ParameterSelectionGeneral parameterSelectionGeneralFechaHoraFinal= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaHoraFinal.setParameterSelectionGeneralMenorIgual(ParameterType.TIMESTAMP,fecha_horaFinal,AuditoriaConstantesFunciones.FECHAHORA,"Final",ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaHoraFinal);

			AuditoriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorProcesoPorFechaHora","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			auditorias=auditoriaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AuditoriaConstantesFunciones.refrescarForeignKeysDescripcionesAuditoria(this.auditorias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAuditoriasBusquedaPorUsuarioPCPorFechaHoraWithConnection(String sFinalQuery,Pagination pagination,String usuario_p_c,Timestamp fecha_hora,Timestamp fecha_horaFinal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Auditoria.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralUsuarioPC= new ParameterSelectionGeneral();
			parameterSelectionGeneralUsuarioPC.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+usuario_p_c+"%",AuditoriaConstantesFunciones.USUARIOPC,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralUsuarioPC);

			ParameterSelectionGeneral parameterSelectionGeneralFechaHora= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaHora.setParameterSelectionGeneralMayorIgual(ParameterType.TIMESTAMP,fecha_hora,AuditoriaConstantesFunciones.FECHAHORA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaHora);

			ParameterSelectionGeneral parameterSelectionGeneralFechaHoraFinal= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaHoraFinal.setParameterSelectionGeneralMenorIgual(ParameterType.TIMESTAMP,fecha_horaFinal,AuditoriaConstantesFunciones.FECHAHORA,"Final",ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaHoraFinal);

			AuditoriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorUsuarioPCPorFechaHora","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			auditorias=auditoriaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AuditoriaConstantesFunciones.refrescarForeignKeysDescripcionesAuditoria(this.auditorias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAuditoriasBusquedaPorUsuarioPCPorFechaHora(String sFinalQuery,Pagination pagination,String usuario_p_c,Timestamp fecha_hora,Timestamp fecha_horaFinal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralUsuarioPC= new ParameterSelectionGeneral();
			parameterSelectionGeneralUsuarioPC.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+usuario_p_c+"%",AuditoriaConstantesFunciones.USUARIOPC,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralUsuarioPC);

			ParameterSelectionGeneral parameterSelectionGeneralFechaHora= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaHora.setParameterSelectionGeneralMayorIgual(ParameterType.TIMESTAMP,fecha_hora,AuditoriaConstantesFunciones.FECHAHORA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaHora);

			ParameterSelectionGeneral parameterSelectionGeneralFechaHoraFinal= new ParameterSelectionGeneral();
			parameterSelectionGeneralFechaHoraFinal.setParameterSelectionGeneralMenorIgual(ParameterType.TIMESTAMP,fecha_horaFinal,AuditoriaConstantesFunciones.FECHAHORA,"Final",ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralFechaHoraFinal);

			AuditoriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorUsuarioPCPorFechaHora","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			auditorias=auditoriaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AuditoriaConstantesFunciones.refrescarForeignKeysDescripcionesAuditoria(this.auditorias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAuditoriasFK_IdAuditoriaWithConnection(String sFinalQuery,Pagination pagination,Long id_fila)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Auditoria.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFila= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFila.setParameterSelectionGeneralEqual(ParameterType.LONG,id_fila,AuditoriaConstantesFunciones.IDFILA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFila);

			AuditoriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAuditoria","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			auditorias=auditoriaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AuditoriaConstantesFunciones.refrescarForeignKeysDescripcionesAuditoria(this.auditorias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAuditoriasFK_IdAuditoria(String sFinalQuery,Pagination pagination,Long id_fila)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFila= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFila.setParameterSelectionGeneralEqual(ParameterType.LONG,id_fila,AuditoriaConstantesFunciones.IDFILA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFila);

			AuditoriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAuditoria","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			auditorias=auditoriaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AuditoriaConstantesFunciones.refrescarForeignKeysDescripcionesAuditoria(this.auditorias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAuditoriasFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Auditoria.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,AuditoriaConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			AuditoriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			auditorias=auditoriaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AuditoriaConstantesFunciones.refrescarForeignKeysDescripcionesAuditoria(this.auditorias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAuditoriasFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,AuditoriaConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			AuditoriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			auditorias=auditoriaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AuditoriaConstantesFunciones.refrescarForeignKeysDescripcionesAuditoria(this.auditorias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		//AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		//auditoriaLogicAdditional.setConnexion(connexion);
		//AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(AuditoriaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				//auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,AuditoriaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Auditoria auditoria,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		//AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		//auditoriaLogicAdditional.setConnexion(connexion);
		//AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(AuditoriaConstantesFunciones.ISCONAUDITORIA) {
				if(auditoria.getIsNew()) {
					//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AuditoriaDataAccess.TABLENAME, auditoria.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(AuditoriaConstantesFunciones.ISCONAUDITORIADETALLE) {
						//AuditoriaLogic.registrarAuditoriaDetallesAuditoria(connexion,auditoria,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(auditoria.getIsDeleted()) {
					/*if(!auditoria.getIsExpired()) {
						//auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,AuditoriaDataAccess.TABLENAME, auditoria.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						//AuditoriaLogic.registrarAuditoriaDetallesAuditoria(connexion,auditoria,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AuditoriaDataAccess.TABLENAME, auditoria.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(auditoria.getIsChanged()) {
					//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AuditoriaDataAccess.TABLENAME, auditoria.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(AuditoriaConstantesFunciones.ISCONAUDITORIADETALLE) {
						//AuditoriaLogic.registrarAuditoriaDetallesAuditoria(connexion,auditoria,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesAuditoria(Connexion connexion,Auditoria auditoria)throws Exception {		
		//AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		//auditoriaDetalleLogicAdditional.setConnexion(connexion);
		//AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(auditoria.getIsNew()||!auditoria.getid_usuario().equals(auditoria.getAuditoriaOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(auditoria.getAuditoriaOriginal().getid_usuario()!=null)
				{
					strValorActual=auditoria.getAuditoriaOriginal().getid_usuario().toString();
				}
				if(auditoria.getid_usuario()!=null)
				{
					strValorNuevo=auditoria.getid_usuario().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AuditoriaConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(auditoria.getIsNew()||!auditoria.getnombre_tabla().equals(auditoria.getAuditoriaOriginal().getnombre_tabla()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(auditoria.getAuditoriaOriginal().getnombre_tabla()!=null)
				{
					strValorActual=auditoria.getAuditoriaOriginal().getnombre_tabla();
				}
				if(auditoria.getnombre_tabla()!=null)
				{
					strValorNuevo=auditoria.getnombre_tabla() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AuditoriaConstantesFunciones.NOMBRETABLA,strValorActual,strValorNuevo);
			}	
			
			if(auditoria.getIsNew()||!auditoria.getid_fila().equals(auditoria.getAuditoriaOriginal().getid_fila()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(auditoria.getAuditoriaOriginal().getid_fila()!=null)
				{
					strValorActual=auditoria.getAuditoriaOriginal().getid_fila().toString();
				}
				if(auditoria.getid_fila()!=null)
				{
					strValorNuevo=auditoria.getid_fila().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AuditoriaConstantesFunciones.IDFILA,strValorActual,strValorNuevo);
			}	
			
			if(auditoria.getIsNew()||!auditoria.getaccion().equals(auditoria.getAuditoriaOriginal().getaccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(auditoria.getAuditoriaOriginal().getaccion()!=null)
				{
					strValorActual=auditoria.getAuditoriaOriginal().getaccion();
				}
				if(auditoria.getaccion()!=null)
				{
					strValorNuevo=auditoria.getaccion() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AuditoriaConstantesFunciones.ACCION,strValorActual,strValorNuevo);
			}	
			
			if(auditoria.getIsNew()||!auditoria.getproceso().equals(auditoria.getAuditoriaOriginal().getproceso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(auditoria.getAuditoriaOriginal().getproceso()!=null)
				{
					strValorActual=auditoria.getAuditoriaOriginal().getproceso();
				}
				if(auditoria.getproceso()!=null)
				{
					strValorNuevo=auditoria.getproceso() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AuditoriaConstantesFunciones.PROCESO,strValorActual,strValorNuevo);
			}	
			
			if(auditoria.getIsNew()||!auditoria.getnombre_p_c().equals(auditoria.getAuditoriaOriginal().getnombre_p_c()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(auditoria.getAuditoriaOriginal().getnombre_p_c()!=null)
				{
					strValorActual=auditoria.getAuditoriaOriginal().getnombre_p_c();
				}
				if(auditoria.getnombre_p_c()!=null)
				{
					strValorNuevo=auditoria.getnombre_p_c() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AuditoriaConstantesFunciones.NOMBREPC,strValorActual,strValorNuevo);
			}	
			
			if(auditoria.getIsNew()||!auditoria.getip_pc().equals(auditoria.getAuditoriaOriginal().getip_pc()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(auditoria.getAuditoriaOriginal().getip_pc()!=null)
				{
					strValorActual=auditoria.getAuditoriaOriginal().getip_pc();
				}
				if(auditoria.getip_pc()!=null)
				{
					strValorNuevo=auditoria.getip_pc() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AuditoriaConstantesFunciones.IPPC,strValorActual,strValorNuevo);
			}	
			
			if(auditoria.getIsNew()||!auditoria.getusuario_p_c().equals(auditoria.getAuditoriaOriginal().getusuario_p_c()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(auditoria.getAuditoriaOriginal().getusuario_p_c()!=null)
				{
					strValorActual=auditoria.getAuditoriaOriginal().getusuario_p_c();
				}
				if(auditoria.getusuario_p_c()!=null)
				{
					strValorNuevo=auditoria.getusuario_p_c() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AuditoriaConstantesFunciones.USUARIOPC,strValorActual,strValorNuevo);
			}	
			
			if(auditoria.getIsNew()||!auditoria.getfecha_hora().equals(auditoria.getAuditoriaOriginal().getfecha_hora()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(auditoria.getAuditoriaOriginal().getfecha_hora()!=null)
				{
					strValorActual=auditoria.getAuditoriaOriginal().getfecha_hora().toString();
				}
				if(auditoria.getfecha_hora()!=null)
				{
					strValorNuevo=auditoria.getfecha_hora().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AuditoriaConstantesFunciones.FECHAHORA,strValorActual,strValorNuevo);
			}	
			
			if(auditoria.getIsNew()||!auditoria.getobservacion().equals(auditoria.getAuditoriaOriginal().getobservacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(auditoria.getAuditoriaOriginal().getobservacion()!=null)
				{
					strValorActual=auditoria.getAuditoriaOriginal().getobservacion();
				}
				if(auditoria.getobservacion()!=null)
				{
					strValorNuevo=auditoria.getobservacion() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AuditoriaConstantesFunciones.OBSERVACION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveAuditoriaRelacionesWithConnection(Auditoria auditoria,List<AuditoriaDetalle> auditoriadetalles) throws Exception {

		if(!auditoria.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveAuditoriaRelacionesBase(auditoria,auditoriadetalles,true);
		}
	}

	public void saveAuditoriaRelaciones(Auditoria auditoria,List<AuditoriaDetalle> auditoriadetalles)throws Exception {

		if(!auditoria.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveAuditoriaRelacionesBase(auditoria,auditoriadetalles,false);
		}
	}

	public void saveAuditoriaRelacionesBase(Auditoria auditoria,List<AuditoriaDetalle> auditoriadetalles,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Auditoria-saveRelacionesWithConnection");}
	
			auditoria.setAuditoriaDetalles(auditoriadetalles);

			this.setAuditoria(auditoria);

			if(AuditoriaLogicAdditional.validarSaveRelaciones(auditoria,this)) {

				AuditoriaLogicAdditional.updateRelacionesToSave(auditoria,this);

				if((auditoria.getIsNew()||auditoria.getIsChanged())&&!auditoria.getIsDeleted()) {
					this.saveAuditoria();
					this.saveAuditoriaRelacionesDetalles(auditoriadetalles);

				} else if(auditoria.getIsDeleted()) {
					this.saveAuditoriaRelacionesDetalles(auditoriadetalles);
					this.saveAuditoria();
				}

				AuditoriaLogicAdditional.updateRelacionesToSaveAfter(auditoria,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			AuditoriaDetalleConstantesFunciones.InicializarGeneralEntityAuxiliaresAuditoriaDetalles(auditoriadetalles,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveAuditoriaRelacionesDetalles(List<AuditoriaDetalle> auditoriadetalles)throws Exception {
		try {
	

			Long idAuditoriaActual=this.getAuditoria().getId();

			AuditoriaDetalleLogic auditoriadetalleLogic_Desde_Auditoria=new AuditoriaDetalleLogic();
			auditoriadetalleLogic_Desde_Auditoria.setAuditoriaDetalles(auditoriadetalles);

			auditoriadetalleLogic_Desde_Auditoria.setConnexion(this.getConnexion());
			auditoriadetalleLogic_Desde_Auditoria.setDatosCliente(this.datosCliente);

			for(AuditoriaDetalle auditoriadetalle_Desde_Auditoria:auditoriadetalleLogic_Desde_Auditoria.getAuditoriaDetalles()) {
				auditoriadetalle_Desde_Auditoria.setid_auditoria(idAuditoriaActual);
			}

			auditoriadetalleLogic_Desde_Auditoria.saveAuditoriaDetalles();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfAuditoria(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=AuditoriaConstantesFunciones.getClassesForeignKeysOfAuditoria(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAuditoria(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=AuditoriaConstantesFunciones.getClassesRelationshipsOfAuditoria(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

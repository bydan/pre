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
import com.bydan.erp.seguridad.util.AuditoriaDetalleConstantesFunciones;
import com.bydan.erp.seguridad.util.AuditoriaDetalleParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.AuditoriaDetalleParameterGeneral;
import com.bydan.erp.seguridad.business.entity.AuditoriaDetalle;
import com.bydan.erp.seguridad.business.logic.AuditoriaDetalleLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class AuditoriaDetalleLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(AuditoriaDetalleLogic.class);
	
	protected AuditoriaDetalleDataAccess auditoriadetalleDataAccess; 	
	protected AuditoriaDetalle auditoriadetalle;
	protected List<AuditoriaDetalle> auditoriadetalles;
	protected Object auditoriadetalleObject;	
	protected List<Object> auditoriadetallesObject;
	
	public static ClassValidator<AuditoriaDetalle> auditoriadetalleValidator = new ClassValidator<AuditoriaDetalle>(AuditoriaDetalle.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected AuditoriaDetalleLogicAdditional auditoriadetalleLogicAdditional=null;
	
	public AuditoriaDetalleLogicAdditional getAuditoriaDetalleLogicAdditional() {
		return this.auditoriadetalleLogicAdditional;
	}
	
	public void setAuditoriaDetalleLogicAdditional(AuditoriaDetalleLogicAdditional auditoriadetalleLogicAdditional) {
		try {
			this.auditoriadetalleLogicAdditional=auditoriadetalleLogicAdditional;
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
	
	
	
	
	public  AuditoriaDetalleLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.auditoriadetalleDataAccess = new AuditoriaDetalleDataAccess();
			
			this.auditoriadetalles= new ArrayList<AuditoriaDetalle>();
			this.auditoriadetalle= new AuditoriaDetalle();
			
			this.auditoriadetalleObject=new Object();
			this.auditoriadetallesObject=new ArrayList<Object>();
				
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
			
			this.auditoriadetalleDataAccess.setConnexionType(this.connexionType);
			this.auditoriadetalleDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  AuditoriaDetalleLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.auditoriadetalleDataAccess = new AuditoriaDetalleDataAccess();
			this.auditoriadetalles= new ArrayList<AuditoriaDetalle>();
			this.auditoriadetalle= new AuditoriaDetalle();
			this.auditoriadetalleObject=new Object();
			this.auditoriadetallesObject=new ArrayList<Object>();
			
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
			
			this.auditoriadetalleDataAccess.setConnexionType(this.connexionType);
			this.auditoriadetalleDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public AuditoriaDetalle getAuditoriaDetalle() throws Exception {	
		AuditoriaDetalleLogicAdditional.checkAuditoriaDetalleToGet(auditoriadetalle,this.datosCliente,this.arrDatoGeneral);
		AuditoriaDetalleLogicAdditional.updateAuditoriaDetalleToGet(auditoriadetalle,this.arrDatoGeneral);
		
		return auditoriadetalle;
	}
		
	public void setAuditoriaDetalle(AuditoriaDetalle newAuditoriaDetalle) {
		this.auditoriadetalle = newAuditoriaDetalle;
	}
	
	public AuditoriaDetalleDataAccess getAuditoriaDetalleDataAccess() {
		return auditoriadetalleDataAccess;
	}
	
	public void setAuditoriaDetalleDataAccess(AuditoriaDetalleDataAccess newauditoriadetalleDataAccess) {
		this.auditoriadetalleDataAccess = newauditoriadetalleDataAccess;
	}
	
	public List<AuditoriaDetalle> getAuditoriaDetalles() throws Exception {		
		this.quitarAuditoriaDetallesNulos();
		
		AuditoriaDetalleLogicAdditional.checkAuditoriaDetalleToGets(auditoriadetalles,this.datosCliente,this.arrDatoGeneral);
		
		for (AuditoriaDetalle auditoriadetalleLocal: auditoriadetalles ) {
			AuditoriaDetalleLogicAdditional.updateAuditoriaDetalleToGet(auditoriadetalleLocal,this.arrDatoGeneral);
		}
		
		return auditoriadetalles;
	}
	
	public void setAuditoriaDetalles(List<AuditoriaDetalle> newAuditoriaDetalles) {
		this.auditoriadetalles = newAuditoriaDetalles;
	}
	
	public Object getAuditoriaDetalleObject() {	
		this.auditoriadetalleObject=this.auditoriadetalleDataAccess.getEntityObject();
		return this.auditoriadetalleObject;
	}
		
	public void setAuditoriaDetalleObject(Object newAuditoriaDetalleObject) {
		this.auditoriadetalleObject = newAuditoriaDetalleObject;
	}
	
	public List<Object> getAuditoriaDetallesObject() {		
		this.auditoriadetallesObject=this.auditoriadetalleDataAccess.getEntitiesObject();
		return this.auditoriadetallesObject;
	}
		
	public void setAuditoriaDetallesObject(List<Object> newAuditoriaDetallesObject) {
		this.auditoriadetallesObject = newAuditoriaDetallesObject;
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
		
		if(this.auditoriadetalleDataAccess!=null) {
			this.auditoriadetalleDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AuditoriaDetalle.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			auditoriadetalleDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			auditoriadetalleDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		auditoriadetalle = new  AuditoriaDetalle();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AuditoriaDetalle.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			auditoriadetalle=auditoriadetalleDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.auditoriadetalle,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AuditoriaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesAuditoriaDetalle(this.auditoriadetalle);
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
		auditoriadetalle = new  AuditoriaDetalle();
		  		  
        try {
			
			auditoriadetalle=auditoriadetalleDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.auditoriadetalle,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AuditoriaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesAuditoriaDetalle(this.auditoriadetalle);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		auditoriadetalle = new  AuditoriaDetalle();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AuditoriaDetalle.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			auditoriadetalle=auditoriadetalleDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.auditoriadetalle,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AuditoriaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesAuditoriaDetalle(this.auditoriadetalle);
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
		auditoriadetalle = new  AuditoriaDetalle();
		  		  
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
		auditoriadetalle = new  AuditoriaDetalle();
		  		  
        try {
			
			auditoriadetalle=auditoriadetalleDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.auditoriadetalle,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AuditoriaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesAuditoriaDetalle(this.auditoriadetalle);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		auditoriadetalle = new  AuditoriaDetalle();
		  		  
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
		auditoriadetalle = new  AuditoriaDetalle();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AuditoriaDetalle.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =auditoriadetalleDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		auditoriadetalle = new  AuditoriaDetalle();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=auditoriadetalleDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		auditoriadetalle = new  AuditoriaDetalle();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AuditoriaDetalle.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =auditoriadetalleDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		auditoriadetalle = new  AuditoriaDetalle();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=auditoriadetalleDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		auditoriadetalle = new  AuditoriaDetalle();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AuditoriaDetalle.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =auditoriadetalleDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		auditoriadetalle = new  AuditoriaDetalle();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=auditoriadetalleDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		auditoriadetalles = new  ArrayList<AuditoriaDetalle>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AuditoriaDetalle.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			AuditoriaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			auditoriadetalles=auditoriadetalleDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAuditoriaDetalle(auditoriadetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AuditoriaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesAuditoriaDetalle(this.auditoriadetalles);
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
		auditoriadetalles = new  ArrayList<AuditoriaDetalle>();
		  		  
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
		auditoriadetalles = new  ArrayList<AuditoriaDetalle>();
		  		  
        try {			
			AuditoriaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			auditoriadetalles=auditoriadetalleDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarAuditoriaDetalle(auditoriadetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AuditoriaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesAuditoriaDetalle(this.auditoriadetalles);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		auditoriadetalles = new  ArrayList<AuditoriaDetalle>();
		  		  
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
		auditoriadetalles = new  ArrayList<AuditoriaDetalle>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AuditoriaDetalle.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			AuditoriaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			auditoriadetalles=auditoriadetalleDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAuditoriaDetalle(auditoriadetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AuditoriaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesAuditoriaDetalle(this.auditoriadetalles);
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
		auditoriadetalles = new  ArrayList<AuditoriaDetalle>();
		  		  
        try {
			AuditoriaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			auditoriadetalles=auditoriadetalleDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAuditoriaDetalle(auditoriadetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AuditoriaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesAuditoriaDetalle(this.auditoriadetalles);
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
		auditoriadetalles = new  ArrayList<AuditoriaDetalle>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AuditoriaDetalle.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AuditoriaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			auditoriadetalles=auditoriadetalleDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAuditoriaDetalle(auditoriadetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AuditoriaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesAuditoriaDetalle(this.auditoriadetalles);
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
		auditoriadetalles = new  ArrayList<AuditoriaDetalle>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AuditoriaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			auditoriadetalles=auditoriadetalleDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAuditoriaDetalle(auditoriadetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AuditoriaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesAuditoriaDetalle(this.auditoriadetalles);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		auditoriadetalle = new  AuditoriaDetalle();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AuditoriaDetalle.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AuditoriaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			auditoriadetalle=auditoriadetalleDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAuditoriaDetalle(auditoriadetalle);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AuditoriaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesAuditoriaDetalle(this.auditoriadetalle);
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
		auditoriadetalle = new  AuditoriaDetalle();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AuditoriaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			auditoriadetalle=auditoriadetalleDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAuditoriaDetalle(auditoriadetalle);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AuditoriaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesAuditoriaDetalle(this.auditoriadetalle);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		auditoriadetalles = new  ArrayList<AuditoriaDetalle>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AuditoriaDetalle.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			AuditoriaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			auditoriadetalles=auditoriadetalleDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAuditoriaDetalle(auditoriadetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AuditoriaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesAuditoriaDetalle(this.auditoriadetalles);
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
		auditoriadetalles = new  ArrayList<AuditoriaDetalle>();
		  		  
        try {
			AuditoriaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			auditoriadetalles=auditoriadetalleDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAuditoriaDetalle(auditoriadetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AuditoriaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesAuditoriaDetalle(this.auditoriadetalles);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosAuditoriaDetallesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		auditoriadetalles = new  ArrayList<AuditoriaDetalle>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AuditoriaDetalle.class.getSimpleName()+"-getTodosAuditoriaDetallesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AuditoriaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			auditoriadetalles=auditoriadetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarAuditoriaDetalle(auditoriadetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AuditoriaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesAuditoriaDetalle(this.auditoriadetalles);
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
	
	public  void  getTodosAuditoriaDetalles(String sFinalQuery,Pagination pagination)throws Exception {
		auditoriadetalles = new  ArrayList<AuditoriaDetalle>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AuditoriaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			auditoriadetalles=auditoriadetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarAuditoriaDetalle(auditoriadetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AuditoriaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesAuditoriaDetalle(this.auditoriadetalles);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarAuditoriaDetalle(AuditoriaDetalle auditoriadetalle) throws Exception {
		Boolean estaValidado=false;
		
		if(auditoriadetalle.getIsNew() || auditoriadetalle.getIsChanged()) { 
			this.invalidValues = auditoriadetalleValidator.getInvalidValues(auditoriadetalle);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(auditoriadetalle);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarAuditoriaDetalle(List<AuditoriaDetalle> AuditoriaDetalles) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(AuditoriaDetalle auditoriadetalleLocal:auditoriadetalles) {				
			estaValidadoObjeto=this.validarGuardarAuditoriaDetalle(auditoriadetalleLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarAuditoriaDetalle(List<AuditoriaDetalle> AuditoriaDetalles) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarAuditoriaDetalle(auditoriadetalles)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarAuditoriaDetalle(AuditoriaDetalle AuditoriaDetalle) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarAuditoriaDetalle(auditoriadetalle)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(AuditoriaDetalle auditoriadetalle) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+auditoriadetalle.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=AuditoriaDetalleConstantesFunciones.getAuditoriaDetalleLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"auditoriadetalle","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(AuditoriaDetalleConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(AuditoriaDetalleConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveAuditoriaDetalleWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AuditoriaDetalle.class.getSimpleName()+"-saveAuditoriaDetalleWithConnection");connexion.begin();			
			
			AuditoriaDetalleLogicAdditional.checkAuditoriaDetalleToSave(this.auditoriadetalle,this.datosCliente,connexion,this.arrDatoGeneral);
			
			AuditoriaDetalleLogicAdditional.updateAuditoriaDetalleToSave(this.auditoriadetalle,this.arrDatoGeneral);
			
			AuditoriaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.auditoriadetalle,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowAuditoriaDetalle();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarAuditoriaDetalle(this.auditoriadetalle)) {
				AuditoriaDetalleDataAccess.save(this.auditoriadetalle, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.auditoriadetalle,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			AuditoriaDetalleLogicAdditional.checkAuditoriaDetalleToSaveAfter(this.auditoriadetalle,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowAuditoriaDetalle();
			
			connexion.commit();			
			
			if(this.auditoriadetalle.getIsDeleted()) {
				this.auditoriadetalle=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveAuditoriaDetalle()throws Exception {	
		try {	
			
			AuditoriaDetalleLogicAdditional.checkAuditoriaDetalleToSave(this.auditoriadetalle,this.datosCliente,connexion,this.arrDatoGeneral);
			
			AuditoriaDetalleLogicAdditional.updateAuditoriaDetalleToSave(this.auditoriadetalle,this.arrDatoGeneral);
			
			AuditoriaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.auditoriadetalle,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarAuditoriaDetalle(this.auditoriadetalle)) {			
				AuditoriaDetalleDataAccess.save(this.auditoriadetalle, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.auditoriadetalle,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			AuditoriaDetalleLogicAdditional.checkAuditoriaDetalleToSaveAfter(this.auditoriadetalle,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.auditoriadetalle.getIsDeleted()) {
				this.auditoriadetalle=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveAuditoriaDetallesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AuditoriaDetalle.class.getSimpleName()+"-saveAuditoriaDetallesWithConnection");connexion.begin();			
			
			AuditoriaDetalleLogicAdditional.checkAuditoriaDetalleToSaves(auditoriadetalles,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowAuditoriaDetalles();
			
			Boolean validadoTodosAuditoriaDetalle=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(AuditoriaDetalle auditoriadetalleLocal:auditoriadetalles) {		
				if(auditoriadetalleLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				AuditoriaDetalleLogicAdditional.updateAuditoriaDetalleToSave(auditoriadetalleLocal,this.arrDatoGeneral);
	        	
				AuditoriaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),auditoriadetalleLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarAuditoriaDetalle(auditoriadetalleLocal)) {
					AuditoriaDetalleDataAccess.save(auditoriadetalleLocal, connexion);				
				} else {
					validadoTodosAuditoriaDetalle=false;
				}
			}
			
			if(!validadoTodosAuditoriaDetalle) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			AuditoriaDetalleLogicAdditional.checkAuditoriaDetalleToSavesAfter(auditoriadetalles,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowAuditoriaDetalles();
			
			connexion.commit();		
			
			this.quitarAuditoriaDetallesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveAuditoriaDetalles()throws Exception {				
		 try {	
			AuditoriaDetalleLogicAdditional.checkAuditoriaDetalleToSaves(auditoriadetalles,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosAuditoriaDetalle=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(AuditoriaDetalle auditoriadetalleLocal:auditoriadetalles) {				
				if(auditoriadetalleLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				AuditoriaDetalleLogicAdditional.updateAuditoriaDetalleToSave(auditoriadetalleLocal,this.arrDatoGeneral);
	        	
				AuditoriaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),auditoriadetalleLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarAuditoriaDetalle(auditoriadetalleLocal)) {				
					AuditoriaDetalleDataAccess.save(auditoriadetalleLocal, connexion);				
				} else {
					validadoTodosAuditoriaDetalle=false;
				}
			}
			
			if(!validadoTodosAuditoriaDetalle) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			AuditoriaDetalleLogicAdditional.checkAuditoriaDetalleToSavesAfter(auditoriadetalles,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarAuditoriaDetallesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public AuditoriaDetalleParameterReturnGeneral procesarAccionAuditoriaDetalles(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<AuditoriaDetalle> auditoriadetalles,AuditoriaDetalleParameterReturnGeneral auditoriadetalleParameterGeneral)throws Exception {
		 try {	
			AuditoriaDetalleParameterReturnGeneral auditoriadetalleReturnGeneral=new AuditoriaDetalleParameterReturnGeneral();
	
			AuditoriaDetalleLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,auditoriadetalles,auditoriadetalleParameterGeneral,auditoriadetalleReturnGeneral);
			
			return auditoriadetalleReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public AuditoriaDetalleParameterReturnGeneral procesarAccionAuditoriaDetallesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<AuditoriaDetalle> auditoriadetalles,AuditoriaDetalleParameterReturnGeneral auditoriadetalleParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AuditoriaDetalle.class.getSimpleName()+"-procesarAccionAuditoriaDetallesWithConnection");connexion.begin();			
			
			AuditoriaDetalleParameterReturnGeneral auditoriadetalleReturnGeneral=new AuditoriaDetalleParameterReturnGeneral();
	
			AuditoriaDetalleLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,auditoriadetalles,auditoriadetalleParameterGeneral,auditoriadetalleReturnGeneral);
			
			this.connexion.commit();
			
			return auditoriadetalleReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public AuditoriaDetalleParameterReturnGeneral procesarEventosAuditoriaDetalles(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<AuditoriaDetalle> auditoriadetalles,AuditoriaDetalle auditoriadetalle,AuditoriaDetalleParameterReturnGeneral auditoriadetalleParameterGeneral,Boolean isEsNuevoAuditoriaDetalle,ArrayList<Classe> clases)throws Exception {
		 try {	
			AuditoriaDetalleParameterReturnGeneral auditoriadetalleReturnGeneral=new AuditoriaDetalleParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				auditoriadetalleReturnGeneral.setConRecargarPropiedades(true);
			}
			
			AuditoriaDetalleLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,auditoriadetalles,auditoriadetalle,auditoriadetalleParameterGeneral,auditoriadetalleReturnGeneral,isEsNuevoAuditoriaDetalle,clases);
			
			return auditoriadetalleReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public AuditoriaDetalleParameterReturnGeneral procesarEventosAuditoriaDetallesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<AuditoriaDetalle> auditoriadetalles,AuditoriaDetalle auditoriadetalle,AuditoriaDetalleParameterReturnGeneral auditoriadetalleParameterGeneral,Boolean isEsNuevoAuditoriaDetalle,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AuditoriaDetalle.class.getSimpleName()+"-procesarEventosAuditoriaDetallesWithConnection");connexion.begin();			
			
			AuditoriaDetalleParameterReturnGeneral auditoriadetalleReturnGeneral=new AuditoriaDetalleParameterReturnGeneral();
	
			auditoriadetalleReturnGeneral.setAuditoriaDetalle(auditoriadetalle);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				auditoriadetalleReturnGeneral.setConRecargarPropiedades(true);
			}
			
			AuditoriaDetalleLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,auditoriadetalles,auditoriadetalle,auditoriadetalleParameterGeneral,auditoriadetalleReturnGeneral,isEsNuevoAuditoriaDetalle,clases);
			
			this.connexion.commit();
			
			return auditoriadetalleReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public AuditoriaDetalleParameterReturnGeneral procesarImportacionAuditoriaDetallesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,AuditoriaDetalleParameterReturnGeneral auditoriadetalleParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AuditoriaDetalle.class.getSimpleName()+"-procesarImportacionAuditoriaDetallesWithConnection");connexion.begin();			
			
			AuditoriaDetalleParameterReturnGeneral auditoriadetalleReturnGeneral=new AuditoriaDetalleParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.auditoriadetalles=new ArrayList<AuditoriaDetalle>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.auditoriadetalle=new AuditoriaDetalle();
				
				
				if(conColumnasBase) {this.auditoriadetalle.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.auditoriadetalle.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.auditoriadetalle.setnombre_campo(arrColumnas[iColumn++]);
			this.auditoriadetalle.setvalor_anterior(arrColumnas[iColumn++]);
			this.auditoriadetalle.setvalor_actual(arrColumnas[iColumn++]);
				
				this.auditoriadetalles.add(this.auditoriadetalle);
			}
			
			this.saveAuditoriaDetalles();
			
			this.connexion.commit();
			
			auditoriadetalleReturnGeneral.setConRetornoEstaProcesado(true);
			auditoriadetalleReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return auditoriadetalleReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarAuditoriaDetallesEliminados() throws Exception {				
		
		List<AuditoriaDetalle> auditoriadetallesAux= new ArrayList<AuditoriaDetalle>();
		
		for(AuditoriaDetalle auditoriadetalle:auditoriadetalles) {
			if(!auditoriadetalle.getIsDeleted()) {
				auditoriadetallesAux.add(auditoriadetalle);
			}
		}
		
		auditoriadetalles=auditoriadetallesAux;
	}
	
	public void quitarAuditoriaDetallesNulos() throws Exception {				
		
		List<AuditoriaDetalle> auditoriadetallesAux= new ArrayList<AuditoriaDetalle>();
		
		for(AuditoriaDetalle auditoriadetalle : this.auditoriadetalles) {
			if(auditoriadetalle==null) {
				auditoriadetallesAux.add(auditoriadetalle);
			}
		}
		
		//this.auditoriadetalles=auditoriadetallesAux;
		
		this.auditoriadetalles.removeAll(auditoriadetallesAux);
	}
	
	public void getSetVersionRowAuditoriaDetalleWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(auditoriadetalle.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((auditoriadetalle.getIsDeleted() || (auditoriadetalle.getIsChanged()&&!auditoriadetalle.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=auditoriadetalleDataAccess.getSetVersionRowAuditoriaDetalle(connexion,auditoriadetalle.getId());
				
				if(!auditoriadetalle.getVersionRow().equals(timestamp)) {	
					auditoriadetalle.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				auditoriadetalle.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowAuditoriaDetalle()throws Exception {	
		
		if(auditoriadetalle.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((auditoriadetalle.getIsDeleted() || (auditoriadetalle.getIsChanged()&&!auditoriadetalle.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=auditoriadetalleDataAccess.getSetVersionRowAuditoriaDetalle(connexion,auditoriadetalle.getId());
			
			try {							
				if(!auditoriadetalle.getVersionRow().equals(timestamp)) {	
					auditoriadetalle.setVersionRow(timestamp);
				}
				
				auditoriadetalle.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowAuditoriaDetallesWithConnection()throws Exception {	
		if(auditoriadetalles!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(AuditoriaDetalle auditoriadetalleAux:auditoriadetalles) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(auditoriadetalleAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(auditoriadetalleAux.getIsDeleted() || (auditoriadetalleAux.getIsChanged()&&!auditoriadetalleAux.getIsNew())) {
						
						timestamp=auditoriadetalleDataAccess.getSetVersionRowAuditoriaDetalle(connexion,auditoriadetalleAux.getId());
						
						if(!auditoriadetalle.getVersionRow().equals(timestamp)) {	
							auditoriadetalleAux.setVersionRow(timestamp);
						}
								
						auditoriadetalleAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowAuditoriaDetalles()throws Exception {	
		if(auditoriadetalles!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(AuditoriaDetalle auditoriadetalleAux:auditoriadetalles) {
					if(auditoriadetalleAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(auditoriadetalleAux.getIsDeleted() || (auditoriadetalleAux.getIsChanged()&&!auditoriadetalleAux.getIsNew())) {
						
						timestamp=auditoriadetalleDataAccess.getSetVersionRowAuditoriaDetalle(connexion,auditoriadetalleAux.getId());
						
						if(!auditoriadetalleAux.getVersionRow().equals(timestamp)) {	
							auditoriadetalleAux.setVersionRow(timestamp);
						}
						
													
						auditoriadetalleAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public AuditoriaDetalleParameterReturnGeneral cargarCombosLoteForeignKeyAuditoriaDetalleWithConnection(String finalQueryGlobalAuditoria) throws Exception {
		AuditoriaDetalleParameterReturnGeneral  auditoriadetalleReturnGeneral =new AuditoriaDetalleParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AuditoriaDetalle.class.getSimpleName()+"-cargarCombosLoteForeignKeyAuditoriaDetalleWithConnection");connexion.begin();
			
			auditoriadetalleReturnGeneral =new AuditoriaDetalleParameterReturnGeneral();
			
			

			List<Auditoria> auditoriasForeignKey=new ArrayList<Auditoria>();
			AuditoriaLogic auditoriaLogic=new AuditoriaLogic();
			auditoriaLogic.setConnexion(this.connexion);
			auditoriaLogic.getAuditoriaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAuditoria.equals("NONE")) {
				auditoriaLogic.getTodosAuditorias(finalQueryGlobalAuditoria,new Pagination());
				auditoriasForeignKey=auditoriaLogic.getAuditorias();
			}

			auditoriadetalleReturnGeneral.setauditoriasForeignKey(auditoriasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return auditoriadetalleReturnGeneral;
	}
	
	public AuditoriaDetalleParameterReturnGeneral cargarCombosLoteForeignKeyAuditoriaDetalle(String finalQueryGlobalAuditoria) throws Exception {
		AuditoriaDetalleParameterReturnGeneral  auditoriadetalleReturnGeneral =new AuditoriaDetalleParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			auditoriadetalleReturnGeneral =new AuditoriaDetalleParameterReturnGeneral();
			
			

			List<Auditoria> auditoriasForeignKey=new ArrayList<Auditoria>();
			AuditoriaLogic auditoriaLogic=new AuditoriaLogic();
			auditoriaLogic.setConnexion(this.connexion);
			auditoriaLogic.getAuditoriaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAuditoria.equals("NONE")) {
				auditoriaLogic.getTodosAuditorias(finalQueryGlobalAuditoria,new Pagination());
				auditoriasForeignKey=auditoriaLogic.getAuditorias();
			}

			auditoriadetalleReturnGeneral.setauditoriasForeignKey(auditoriasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return auditoriadetalleReturnGeneral;
	}
	
	
	public void deepLoad(AuditoriaDetalle auditoriadetalle,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			AuditoriaDetalleLogicAdditional.updateAuditoriaDetalleToGet(auditoriadetalle,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		auditoriadetalle.setAuditoria(auditoriadetalleDataAccess.getAuditoria(connexion,auditoriadetalle));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Auditoria.class)) {
				auditoriadetalle.setAuditoria(auditoriadetalleDataAccess.getAuditoria(connexion,auditoriadetalle));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Auditoria.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			auditoriadetalle.setAuditoria(auditoriadetalleDataAccess.getAuditoria(connexion,auditoriadetalle));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		auditoriadetalle.setAuditoria(auditoriadetalleDataAccess.getAuditoria(connexion,auditoriadetalle));
		AuditoriaLogic auditoriaLogic= new AuditoriaLogic(connexion);
		auditoriaLogic.deepLoad(auditoriadetalle.getAuditoria(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Auditoria.class)) {
				auditoriadetalle.setAuditoria(auditoriadetalleDataAccess.getAuditoria(connexion,auditoriadetalle));
				AuditoriaLogic auditoriaLogic= new AuditoriaLogic(connexion);
				auditoriaLogic.deepLoad(auditoriadetalle.getAuditoria(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Auditoria.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			auditoriadetalle.setAuditoria(auditoriadetalleDataAccess.getAuditoria(connexion,auditoriadetalle));
			AuditoriaLogic auditoriaLogic= new AuditoriaLogic(connexion);
			auditoriaLogic.deepLoad(auditoriadetalle.getAuditoria(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(AuditoriaDetalle auditoriadetalle,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			AuditoriaDetalleLogicAdditional.updateAuditoriaDetalleToSave(auditoriadetalle,this.arrDatoGeneral);
			
AuditoriaDetalleDataAccess.save(auditoriadetalle, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		AuditoriaDataAccess.save(auditoriadetalle.getAuditoria(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Auditoria.class)) {
				AuditoriaDataAccess.save(auditoriadetalle.getAuditoria(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		AuditoriaDataAccess.save(auditoriadetalle.getAuditoria(),connexion);
		AuditoriaLogic auditoriaLogic= new AuditoriaLogic(connexion);
		auditoriaLogic.deepLoad(auditoriadetalle.getAuditoria(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Auditoria.class)) {
				AuditoriaDataAccess.save(auditoriadetalle.getAuditoria(),connexion);
				AuditoriaLogic auditoriaLogic= new AuditoriaLogic(connexion);
				auditoriaLogic.deepSave(auditoriadetalle.getAuditoria(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(AuditoriaDetalle.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(auditoriadetalle,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				AuditoriaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesAuditoriaDetalle(auditoriadetalle);
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
			this.deepLoad(this.auditoriadetalle,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				AuditoriaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesAuditoriaDetalle(this.auditoriadetalle);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(AuditoriaDetalle.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(auditoriadetalles!=null) {
				for(AuditoriaDetalle auditoriadetalle:auditoriadetalles) {
					this.deepLoad(auditoriadetalle,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					AuditoriaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesAuditoriaDetalle(auditoriadetalles);
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
			if(auditoriadetalles!=null) {
				for(AuditoriaDetalle auditoriadetalle:auditoriadetalles) {
					this.deepLoad(auditoriadetalle,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					AuditoriaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesAuditoriaDetalle(auditoriadetalles);
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
			this.getNewConnexionToDeep(AuditoriaDetalle.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(auditoriadetalle,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(AuditoriaDetalle.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(auditoriadetalles!=null) {
				for(AuditoriaDetalle auditoriadetalle:auditoriadetalles) {
					this.deepSave(auditoriadetalle,isDeep,deepLoadType,clases);
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
			if(auditoriadetalles!=null) {
				for(AuditoriaDetalle auditoriadetalle:auditoriadetalles) {
					this.deepSave(auditoriadetalle,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getAuditoriaDetallesBusquedaPorIdAuditoriaPorNombreCampoWithConnection(String sFinalQuery,Pagination pagination,Long id_auditoria,String nombre_campo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AuditoriaDetalle.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAuditoria= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAuditoria.setParameterSelectionGeneralEqual(ParameterType.LONG,id_auditoria,AuditoriaDetalleConstantesFunciones.IDAUDITORIA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAuditoria);

			ParameterSelectionGeneral parameterSelectionGeneralNombreCampo= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombreCampo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre_campo+"%",AuditoriaDetalleConstantesFunciones.NOMBRECAMPO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombreCampo);

			AuditoriaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdAuditoriaPorNombreCampo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			auditoriadetalles=auditoriadetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AuditoriaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesAuditoriaDetalle(this.auditoriadetalles);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAuditoriaDetallesBusquedaPorIdAuditoriaPorNombreCampo(String sFinalQuery,Pagination pagination,Long id_auditoria,String nombre_campo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAuditoria= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAuditoria.setParameterSelectionGeneralEqual(ParameterType.LONG,id_auditoria,AuditoriaDetalleConstantesFunciones.IDAUDITORIA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAuditoria);

			ParameterSelectionGeneral parameterSelectionGeneralNombreCampo= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombreCampo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre_campo+"%",AuditoriaDetalleConstantesFunciones.NOMBRECAMPO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombreCampo);

			AuditoriaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorIdAuditoriaPorNombreCampo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			auditoriadetalles=auditoriadetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AuditoriaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesAuditoriaDetalle(this.auditoriadetalles);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAuditoriaDetallesFK_IdAuditoriaWithConnection(String sFinalQuery,Pagination pagination,Long id_auditoria)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AuditoriaDetalle.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAuditoria= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAuditoria.setParameterSelectionGeneralEqual(ParameterType.LONG,id_auditoria,AuditoriaDetalleConstantesFunciones.IDAUDITORIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAuditoria);

			AuditoriaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAuditoria","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			auditoriadetalles=auditoriadetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AuditoriaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesAuditoriaDetalle(this.auditoriadetalles);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAuditoriaDetallesFK_IdAuditoria(String sFinalQuery,Pagination pagination,Long id_auditoria)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAuditoria= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAuditoria.setParameterSelectionGeneralEqual(ParameterType.LONG,id_auditoria,AuditoriaDetalleConstantesFunciones.IDAUDITORIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAuditoria);

			AuditoriaDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAuditoria","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			auditoriadetalles=auditoriadetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AuditoriaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesAuditoriaDetalle(this.auditoriadetalles);
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
			if(AuditoriaDetalleConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				//auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,AuditoriaDetalleDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,AuditoriaDetalle auditoriadetalle,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		//AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		//auditoriaLogicAdditional.setConnexion(connexion);
		//AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(AuditoriaDetalleConstantesFunciones.ISCONAUDITORIA) {
				if(auditoriadetalle.getIsNew()) {
					//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AuditoriaDetalleDataAccess.TABLENAME, auditoriadetalle.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(AuditoriaDetalleConstantesFunciones.ISCONAUDITORIADETALLE) {
						//AuditoriaDetalleLogic.registrarAuditoriaDetallesAuditoriaDetalle(connexion,auditoriadetalle,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(auditoriadetalle.getIsDeleted()) {
					/*if(!auditoriadetalle.getIsExpired()) {
						//auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,AuditoriaDetalleDataAccess.TABLENAME, auditoriadetalle.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						//AuditoriaDetalleLogic.registrarAuditoriaDetallesAuditoriaDetalle(connexion,auditoriadetalle,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AuditoriaDetalleDataAccess.TABLENAME, auditoriadetalle.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(auditoriadetalle.getIsChanged()) {
					//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AuditoriaDetalleDataAccess.TABLENAME, auditoriadetalle.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(AuditoriaDetalleConstantesFunciones.ISCONAUDITORIADETALLE) {
						//AuditoriaDetalleLogic.registrarAuditoriaDetallesAuditoriaDetalle(connexion,auditoriadetalle,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesAuditoriaDetalle(Connexion connexion,AuditoriaDetalle auditoriadetalle)throws Exception {		
		//AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		//auditoriaDetalleLogicAdditional.setConnexion(connexion);
		//AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(auditoriadetalle.getIsNew()||!auditoriadetalle.getid_auditoria().equals(auditoriadetalle.getAuditoriaDetalleOriginal().getid_auditoria()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(auditoriadetalle.getAuditoriaDetalleOriginal().getid_auditoria()!=null)
				{
					strValorActual=auditoriadetalle.getAuditoriaDetalleOriginal().getid_auditoria().toString();
				}
				if(auditoriadetalle.getid_auditoria()!=null)
				{
					strValorNuevo=auditoriadetalle.getid_auditoria().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AuditoriaDetalleConstantesFunciones.IDAUDITORIA,strValorActual,strValorNuevo);
			}	
			
			if(auditoriadetalle.getIsNew()||!auditoriadetalle.getnombre_campo().equals(auditoriadetalle.getAuditoriaDetalleOriginal().getnombre_campo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(auditoriadetalle.getAuditoriaDetalleOriginal().getnombre_campo()!=null)
				{
					strValorActual=auditoriadetalle.getAuditoriaDetalleOriginal().getnombre_campo();
				}
				if(auditoriadetalle.getnombre_campo()!=null)
				{
					strValorNuevo=auditoriadetalle.getnombre_campo() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AuditoriaDetalleConstantesFunciones.NOMBRECAMPO,strValorActual,strValorNuevo);
			}	
			
			if(auditoriadetalle.getIsNew()||!auditoriadetalle.getvalor_anterior().equals(auditoriadetalle.getAuditoriaDetalleOriginal().getvalor_anterior()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(auditoriadetalle.getAuditoriaDetalleOriginal().getvalor_anterior()!=null)
				{
					strValorActual=auditoriadetalle.getAuditoriaDetalleOriginal().getvalor_anterior();
				}
				if(auditoriadetalle.getvalor_anterior()!=null)
				{
					strValorNuevo=auditoriadetalle.getvalor_anterior() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AuditoriaDetalleConstantesFunciones.VALORANTERIOR,strValorActual,strValorNuevo);
			}	
			
			if(auditoriadetalle.getIsNew()||!auditoriadetalle.getvalor_actual().equals(auditoriadetalle.getAuditoriaDetalleOriginal().getvalor_actual()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(auditoriadetalle.getAuditoriaDetalleOriginal().getvalor_actual()!=null)
				{
					strValorActual=auditoriadetalle.getAuditoriaDetalleOriginal().getvalor_actual();
				}
				if(auditoriadetalle.getvalor_actual()!=null)
				{
					strValorNuevo=auditoriadetalle.getvalor_actual() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AuditoriaDetalleConstantesFunciones.VALORACTUAL,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveAuditoriaDetalleRelacionesWithConnection(AuditoriaDetalle auditoriadetalle) throws Exception {

		if(!auditoriadetalle.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveAuditoriaDetalleRelacionesBase(auditoriadetalle,true);
		}
	}

	public void saveAuditoriaDetalleRelaciones(AuditoriaDetalle auditoriadetalle)throws Exception {

		if(!auditoriadetalle.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveAuditoriaDetalleRelacionesBase(auditoriadetalle,false);
		}
	}

	public void saveAuditoriaDetalleRelacionesBase(AuditoriaDetalle auditoriadetalle,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("AuditoriaDetalle-saveRelacionesWithConnection");}
	

			this.setAuditoriaDetalle(auditoriadetalle);

			if(AuditoriaDetalleLogicAdditional.validarSaveRelaciones(auditoriadetalle,this)) {

				AuditoriaDetalleLogicAdditional.updateRelacionesToSave(auditoriadetalle,this);

				if((auditoriadetalle.getIsNew()||auditoriadetalle.getIsChanged())&&!auditoriadetalle.getIsDeleted()) {
					this.saveAuditoriaDetalle();
					this.saveAuditoriaDetalleRelacionesDetalles();

				} else if(auditoriadetalle.getIsDeleted()) {
					this.saveAuditoriaDetalleRelacionesDetalles();
					this.saveAuditoriaDetalle();
				}

				AuditoriaDetalleLogicAdditional.updateRelacionesToSaveAfter(auditoriadetalle,this);

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
	
	
	private void saveAuditoriaDetalleRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfAuditoriaDetalle(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=AuditoriaDetalleConstantesFunciones.getClassesForeignKeysOfAuditoriaDetalle(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAuditoriaDetalle(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=AuditoriaDetalleConstantesFunciones.getClassesRelationshipsOfAuditoriaDetalle(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

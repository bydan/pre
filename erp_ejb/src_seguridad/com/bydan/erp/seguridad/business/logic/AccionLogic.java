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
import com.bydan.erp.seguridad.util.AccionConstantesFunciones;
import com.bydan.erp.seguridad.util.AccionParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.AccionParameterGeneral;
import com.bydan.erp.seguridad.business.entity.Accion;
import com.bydan.erp.seguridad.business.logic.AccionLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class AccionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(AccionLogic.class);
	
	protected AccionDataAccess accionDataAccess; 	
	protected Accion accion;
	protected List<Accion> accions;
	protected Object accionObject;	
	protected List<Object> accionsObject;
	
	public static ClassValidator<Accion> accionValidator = new ClassValidator<Accion>(Accion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected AccionLogicAdditional accionLogicAdditional=null;
	
	public AccionLogicAdditional getAccionLogicAdditional() {
		return this.accionLogicAdditional;
	}
	
	public void setAccionLogicAdditional(AccionLogicAdditional accionLogicAdditional) {
		try {
			this.accionLogicAdditional=accionLogicAdditional;
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
	
	
	
	
	public  AccionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.accionDataAccess = new AccionDataAccess();
			
			this.accions= new ArrayList<Accion>();
			this.accion= new Accion();
			
			this.accionObject=new Object();
			this.accionsObject=new ArrayList<Object>();
				
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
			
			this.accionDataAccess.setConnexionType(this.connexionType);
			this.accionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  AccionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.accionDataAccess = new AccionDataAccess();
			this.accions= new ArrayList<Accion>();
			this.accion= new Accion();
			this.accionObject=new Object();
			this.accionsObject=new ArrayList<Object>();
			
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
			
			this.accionDataAccess.setConnexionType(this.connexionType);
			this.accionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Accion getAccion() throws Exception {	
		AccionLogicAdditional.checkAccionToGet(accion,this.datosCliente,this.arrDatoGeneral);
		AccionLogicAdditional.updateAccionToGet(accion,this.arrDatoGeneral);
		
		return accion;
	}
		
	public void setAccion(Accion newAccion) {
		this.accion = newAccion;
	}
	
	public AccionDataAccess getAccionDataAccess() {
		return accionDataAccess;
	}
	
	public void setAccionDataAccess(AccionDataAccess newaccionDataAccess) {
		this.accionDataAccess = newaccionDataAccess;
	}
	
	public List<Accion> getAccions() throws Exception {		
		this.quitarAccionsNulos();
		
		AccionLogicAdditional.checkAccionToGets(accions,this.datosCliente,this.arrDatoGeneral);
		
		for (Accion accionLocal: accions ) {
			AccionLogicAdditional.updateAccionToGet(accionLocal,this.arrDatoGeneral);
		}
		
		return accions;
	}
	
	public void setAccions(List<Accion> newAccions) {
		this.accions = newAccions;
	}
	
	public Object getAccionObject() {	
		this.accionObject=this.accionDataAccess.getEntityObject();
		return this.accionObject;
	}
		
	public void setAccionObject(Object newAccionObject) {
		this.accionObject = newAccionObject;
	}
	
	public List<Object> getAccionsObject() {		
		this.accionsObject=this.accionDataAccess.getEntitiesObject();
		return this.accionsObject;
	}
		
	public void setAccionsObject(List<Object> newAccionsObject) {
		this.accionsObject = newAccionsObject;
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
		
		if(this.accionDataAccess!=null) {
			this.accionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			accionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			accionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		accion = new  Accion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			accion=accionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.accion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AccionConstantesFunciones.refrescarForeignKeysDescripcionesAccion(this.accion);
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
		accion = new  Accion();
		  		  
        try {
			
			accion=accionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.accion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AccionConstantesFunciones.refrescarForeignKeysDescripcionesAccion(this.accion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		accion = new  Accion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			accion=accionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.accion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AccionConstantesFunciones.refrescarForeignKeysDescripcionesAccion(this.accion);
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
		accion = new  Accion();
		  		  
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
		accion = new  Accion();
		  		  
        try {
			
			accion=accionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.accion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AccionConstantesFunciones.refrescarForeignKeysDescripcionesAccion(this.accion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		accion = new  Accion();
		  		  
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
		accion = new  Accion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =accionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		accion = new  Accion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=accionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		accion = new  Accion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =accionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		accion = new  Accion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=accionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		accion = new  Accion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =accionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		accion = new  Accion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=accionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		accions = new  ArrayList<Accion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			AccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			accions=accionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAccion(accions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AccionConstantesFunciones.refrescarForeignKeysDescripcionesAccion(this.accions);
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
		accions = new  ArrayList<Accion>();
		  		  
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
		accions = new  ArrayList<Accion>();
		  		  
        try {			
			AccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			accions=accionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarAccion(accions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AccionConstantesFunciones.refrescarForeignKeysDescripcionesAccion(this.accions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		accions = new  ArrayList<Accion>();
		  		  
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
		accions = new  ArrayList<Accion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			AccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			accions=accionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAccion(accions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AccionConstantesFunciones.refrescarForeignKeysDescripcionesAccion(this.accions);
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
		accions = new  ArrayList<Accion>();
		  		  
        try {
			AccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			accions=accionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAccion(accions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AccionConstantesFunciones.refrescarForeignKeysDescripcionesAccion(this.accions);
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
		accions = new  ArrayList<Accion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			accions=accionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAccion(accions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AccionConstantesFunciones.refrescarForeignKeysDescripcionesAccion(this.accions);
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
		accions = new  ArrayList<Accion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			accions=accionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAccion(accions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AccionConstantesFunciones.refrescarForeignKeysDescripcionesAccion(this.accions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		accion = new  Accion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			accion=accionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAccion(accion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AccionConstantesFunciones.refrescarForeignKeysDescripcionesAccion(this.accion);
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
		accion = new  Accion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			accion=accionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAccion(accion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AccionConstantesFunciones.refrescarForeignKeysDescripcionesAccion(this.accion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		accions = new  ArrayList<Accion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accion.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			AccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			accions=accionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAccion(accions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AccionConstantesFunciones.refrescarForeignKeysDescripcionesAccion(this.accions);
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
		accions = new  ArrayList<Accion>();
		  		  
        try {
			AccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			accions=accionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAccion(accions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AccionConstantesFunciones.refrescarForeignKeysDescripcionesAccion(this.accions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosAccionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		accions = new  ArrayList<Accion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accion.class.getSimpleName()+"-getTodosAccionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			accions=accionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarAccion(accions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AccionConstantesFunciones.refrescarForeignKeysDescripcionesAccion(this.accions);
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
	
	public  void  getTodosAccions(String sFinalQuery,Pagination pagination)throws Exception {
		accions = new  ArrayList<Accion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			accions=accionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarAccion(accions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AccionConstantesFunciones.refrescarForeignKeysDescripcionesAccion(this.accions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarAccion(Accion accion) throws Exception {
		Boolean estaValidado=false;
		
		if(accion.getIsNew() || accion.getIsChanged()) { 
			this.invalidValues = accionValidator.getInvalidValues(accion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(accion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarAccion(List<Accion> Accions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Accion accionLocal:accions) {				
			estaValidadoObjeto=this.validarGuardarAccion(accionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarAccion(List<Accion> Accions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarAccion(accions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarAccion(Accion Accion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarAccion(accion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Accion accion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+accion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=AccionConstantesFunciones.getAccionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"accion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(AccionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(AccionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveAccionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accion.class.getSimpleName()+"-saveAccionWithConnection");connexion.begin();			
			
			AccionLogicAdditional.checkAccionToSave(this.accion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			AccionLogicAdditional.updateAccionToSave(this.accion,this.arrDatoGeneral);
			
			AccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.accion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowAccion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarAccion(this.accion)) {
				AccionDataAccess.save(this.accion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.accion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			AccionLogicAdditional.checkAccionToSaveAfter(this.accion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowAccion();
			
			connexion.commit();			
			
			if(this.accion.getIsDeleted()) {
				this.accion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveAccion()throws Exception {	
		try {	
			
			AccionLogicAdditional.checkAccionToSave(this.accion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			AccionLogicAdditional.updateAccionToSave(this.accion,this.arrDatoGeneral);
			
			AccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.accion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarAccion(this.accion)) {			
				AccionDataAccess.save(this.accion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.accion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			AccionLogicAdditional.checkAccionToSaveAfter(this.accion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.accion.getIsDeleted()) {
				this.accion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveAccionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accion.class.getSimpleName()+"-saveAccionsWithConnection");connexion.begin();			
			
			AccionLogicAdditional.checkAccionToSaves(accions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowAccions();
			
			Boolean validadoTodosAccion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Accion accionLocal:accions) {		
				if(accionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				AccionLogicAdditional.updateAccionToSave(accionLocal,this.arrDatoGeneral);
	        	
				AccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),accionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarAccion(accionLocal)) {
					AccionDataAccess.save(accionLocal, connexion);				
				} else {
					validadoTodosAccion=false;
				}
			}
			
			if(!validadoTodosAccion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			AccionLogicAdditional.checkAccionToSavesAfter(accions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowAccions();
			
			connexion.commit();		
			
			this.quitarAccionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveAccions()throws Exception {				
		 try {	
			AccionLogicAdditional.checkAccionToSaves(accions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosAccion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Accion accionLocal:accions) {				
				if(accionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				AccionLogicAdditional.updateAccionToSave(accionLocal,this.arrDatoGeneral);
	        	
				AccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),accionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarAccion(accionLocal)) {				
					AccionDataAccess.save(accionLocal, connexion);				
				} else {
					validadoTodosAccion=false;
				}
			}
			
			if(!validadoTodosAccion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			AccionLogicAdditional.checkAccionToSavesAfter(accions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarAccionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public AccionParameterReturnGeneral procesarAccionAccions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Accion> accions,AccionParameterReturnGeneral accionParameterGeneral)throws Exception {
		 try {	
			AccionParameterReturnGeneral accionReturnGeneral=new AccionParameterReturnGeneral();
	
			AccionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,accions,accionParameterGeneral,accionReturnGeneral);
			
			return accionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public AccionParameterReturnGeneral procesarAccionAccionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Accion> accions,AccionParameterReturnGeneral accionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accion.class.getSimpleName()+"-procesarAccionAccionsWithConnection");connexion.begin();			
			
			AccionParameterReturnGeneral accionReturnGeneral=new AccionParameterReturnGeneral();
	
			AccionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,accions,accionParameterGeneral,accionReturnGeneral);
			
			this.connexion.commit();
			
			return accionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public AccionParameterReturnGeneral procesarEventosAccions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Accion> accions,Accion accion,AccionParameterReturnGeneral accionParameterGeneral,Boolean isEsNuevoAccion,ArrayList<Classe> clases)throws Exception {
		 try {	
			AccionParameterReturnGeneral accionReturnGeneral=new AccionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				accionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			AccionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,accions,accion,accionParameterGeneral,accionReturnGeneral,isEsNuevoAccion,clases);
			
			return accionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public AccionParameterReturnGeneral procesarEventosAccionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Accion> accions,Accion accion,AccionParameterReturnGeneral accionParameterGeneral,Boolean isEsNuevoAccion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accion.class.getSimpleName()+"-procesarEventosAccionsWithConnection");connexion.begin();			
			
			AccionParameterReturnGeneral accionReturnGeneral=new AccionParameterReturnGeneral();
	
			accionReturnGeneral.setAccion(accion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				accionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			AccionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,accions,accion,accionParameterGeneral,accionReturnGeneral,isEsNuevoAccion,clases);
			
			this.connexion.commit();
			
			return accionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public AccionParameterReturnGeneral procesarImportacionAccionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,AccionParameterReturnGeneral accionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accion.class.getSimpleName()+"-procesarImportacionAccionsWithConnection");connexion.begin();			
			
			AccionParameterReturnGeneral accionReturnGeneral=new AccionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.accions=new ArrayList<Accion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.accion=new Accion();
				
				
				if(conColumnasBase) {this.accion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.accion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.accion.setcodigo(arrColumnas[iColumn++]);
				this.accion.setnombre(arrColumnas[iColumn++]);
				this.accion.setsolo_form(Boolean.parseBoolean(arrColumnas[iColumn++]));
			this.accion.setdescripcion(arrColumnas[iColumn++]);
				this.accion.setorden(Integer.parseInt(arrColumnas[iColumn++]));
				this.accion.setestado(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.accions.add(this.accion);
			}
			
			this.saveAccions();
			
			this.connexion.commit();
			
			accionReturnGeneral.setConRetornoEstaProcesado(true);
			accionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return accionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarAccionsEliminados() throws Exception {				
		
		List<Accion> accionsAux= new ArrayList<Accion>();
		
		for(Accion accion:accions) {
			if(!accion.getIsDeleted()) {
				accionsAux.add(accion);
			}
		}
		
		accions=accionsAux;
	}
	
	public void quitarAccionsNulos() throws Exception {				
		
		List<Accion> accionsAux= new ArrayList<Accion>();
		
		for(Accion accion : this.accions) {
			if(accion==null) {
				accionsAux.add(accion);
			}
		}
		
		//this.accions=accionsAux;
		
		this.accions.removeAll(accionsAux);
	}
	
	public void getSetVersionRowAccionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(accion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((accion.getIsDeleted() || (accion.getIsChanged()&&!accion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=accionDataAccess.getSetVersionRowAccion(connexion,accion.getId());
				
				if(!accion.getVersionRow().equals(timestamp)) {	
					accion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				accion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowAccion()throws Exception {	
		
		if(accion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((accion.getIsDeleted() || (accion.getIsChanged()&&!accion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=accionDataAccess.getSetVersionRowAccion(connexion,accion.getId());
			
			try {							
				if(!accion.getVersionRow().equals(timestamp)) {	
					accion.setVersionRow(timestamp);
				}
				
				accion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowAccionsWithConnection()throws Exception {	
		if(accions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Accion accionAux:accions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(accionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(accionAux.getIsDeleted() || (accionAux.getIsChanged()&&!accionAux.getIsNew())) {
						
						timestamp=accionDataAccess.getSetVersionRowAccion(connexion,accionAux.getId());
						
						if(!accion.getVersionRow().equals(timestamp)) {	
							accionAux.setVersionRow(timestamp);
						}
								
						accionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowAccions()throws Exception {	
		if(accions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Accion accionAux:accions) {
					if(accionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(accionAux.getIsDeleted() || (accionAux.getIsChanged()&&!accionAux.getIsNew())) {
						
						timestamp=accionDataAccess.getSetVersionRowAccion(connexion,accionAux.getId());
						
						if(!accionAux.getVersionRow().equals(timestamp)) {	
							accionAux.setVersionRow(timestamp);
						}
						
													
						accionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public AccionParameterReturnGeneral cargarCombosLoteForeignKeyAccionWithConnection(String finalQueryGlobalOpcion) throws Exception {
		AccionParameterReturnGeneral  accionReturnGeneral =new AccionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accion.class.getSimpleName()+"-cargarCombosLoteForeignKeyAccionWithConnection");connexion.begin();
			
			accionReturnGeneral =new AccionParameterReturnGeneral();
			
			

			List<Opcion> opcionsForeignKey=new ArrayList<Opcion>();
			OpcionLogic opcionLogic=new OpcionLogic();
			opcionLogic.setConnexion(this.connexion);
			opcionLogic.getOpcionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalOpcion.equals("NONE")) {
				opcionLogic.getTodosOpcions(finalQueryGlobalOpcion,new Pagination());
				opcionsForeignKey=opcionLogic.getOpcions();
			}

			accionReturnGeneral.setopcionsForeignKey(opcionsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return accionReturnGeneral;
	}
	
	public AccionParameterReturnGeneral cargarCombosLoteForeignKeyAccion(String finalQueryGlobalOpcion) throws Exception {
		AccionParameterReturnGeneral  accionReturnGeneral =new AccionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			accionReturnGeneral =new AccionParameterReturnGeneral();
			
			

			List<Opcion> opcionsForeignKey=new ArrayList<Opcion>();
			OpcionLogic opcionLogic=new OpcionLogic();
			opcionLogic.setConnexion(this.connexion);
			opcionLogic.getOpcionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalOpcion.equals("NONE")) {
				opcionLogic.getTodosOpcions(finalQueryGlobalOpcion,new Pagination());
				opcionsForeignKey=opcionLogic.getOpcions();
			}

			accionReturnGeneral.setopcionsForeignKey(opcionsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return accionReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyAccionWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			PerfilAccionLogic perfilaccionLogic=new PerfilAccionLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accion.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyAccionWithConnection");connexion.begin();
			
			
			classes.add(new Classe(PerfilAccion.class));
											
			

			perfilaccionLogic.setConnexion(this.getConnexion());
			perfilaccionLogic.setDatosCliente(this.datosCliente);
			perfilaccionLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Accion accion:this.accions) {
				

				classes=new ArrayList<Classe>();
				classes=PerfilAccionConstantesFunciones.getClassesForeignKeysOfPerfilAccion(new ArrayList<Classe>(),DeepLoadType.NONE);

				perfilaccionLogic.setPerfilAccions(accion.perfilaccions);
				perfilaccionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Accion accion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			AccionLogicAdditional.updateAccionToGet(accion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		accion.setOpcion(accionDataAccess.getOpcion(connexion,accion));
		accion.setPerfils(accionDataAccess.getPerfils(connexion,accion));
		accion.setPerfilAccions(accionDataAccess.getPerfilAccions(connexion,accion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Opcion.class)) {
				accion.setOpcion(accionDataAccess.getOpcion(connexion,accion));
				continue;
			}

			if(clas.clas.equals(Perfil.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				accion.setPerfils(accionDataAccess.getPerfils(connexion,accion));

				if(this.isConDeep) {
					PerfilLogic perfilLogic= new PerfilLogic(this.connexion);
					perfilLogic.setPerfils(accion.getPerfils());
					ArrayList<Classe> classesLocal=PerfilConstantesFunciones.getClassesForeignKeysOfPerfil(new ArrayList<Classe>(),DeepLoadType.NONE);
					perfilLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PerfilConstantesFunciones.refrescarForeignKeysDescripcionesPerfil(perfilLogic.getPerfils());
					accion.setPerfils(perfilLogic.getPerfils());
				}

				continue;
			}

			if(clas.clas.equals(PerfilAccion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				accion.setPerfilAccions(accionDataAccess.getPerfilAccions(connexion,accion));

				if(this.isConDeep) {
					PerfilAccionLogic perfilaccionLogic= new PerfilAccionLogic(this.connexion);
					perfilaccionLogic.setPerfilAccions(accion.getPerfilAccions());
					ArrayList<Classe> classesLocal=PerfilAccionConstantesFunciones.getClassesForeignKeysOfPerfilAccion(new ArrayList<Classe>(),DeepLoadType.NONE);
					perfilaccionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PerfilAccionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilAccion(perfilaccionLogic.getPerfilAccions());
					accion.setPerfilAccions(perfilaccionLogic.getPerfilAccions());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Opcion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			accion.setOpcion(accionDataAccess.getOpcion(connexion,accion));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Perfil.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Perfil.class));
			accion.setPerfils(accionDataAccess.getPerfils(connexion,accion));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PerfilAccion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PerfilAccion.class));
			accion.setPerfilAccions(accionDataAccess.getPerfilAccions(connexion,accion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		accion.setOpcion(accionDataAccess.getOpcion(connexion,accion));
		OpcionLogic opcionLogic= new OpcionLogic(connexion);
		opcionLogic.deepLoad(accion.getOpcion(),isDeep,deepLoadType,clases);
				

		accion.setPerfils(accionDataAccess.getPerfils(connexion,accion));

		for(Perfil perfil:accion.getPerfils()) {
			PerfilLogic perfilLogic= new PerfilLogic(connexion);
			perfilLogic.deepLoad(perfil,isDeep,deepLoadType,clases);
		}

		accion.setPerfilAccions(accionDataAccess.getPerfilAccions(connexion,accion));

		for(PerfilAccion perfilaccion:accion.getPerfilAccions()) {
			PerfilAccionLogic perfilaccionLogic= new PerfilAccionLogic(connexion);
			perfilaccionLogic.deepLoad(perfilaccion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Opcion.class)) {
				accion.setOpcion(accionDataAccess.getOpcion(connexion,accion));
				OpcionLogic opcionLogic= new OpcionLogic(connexion);
				opcionLogic.deepLoad(accion.getOpcion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Perfil.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				accion.setPerfils(accionDataAccess.getPerfils(connexion,accion));

				for(Perfil perfil:accion.getPerfils()) {
					PerfilLogic perfilLogic= new PerfilLogic(connexion);
					perfilLogic.deepLoad(perfil,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PerfilAccion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				accion.setPerfilAccions(accionDataAccess.getPerfilAccions(connexion,accion));

				for(PerfilAccion perfilaccion:accion.getPerfilAccions()) {
					PerfilAccionLogic perfilaccionLogic= new PerfilAccionLogic(connexion);
					perfilaccionLogic.deepLoad(perfilaccion,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Opcion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			accion.setOpcion(accionDataAccess.getOpcion(connexion,accion));
			OpcionLogic opcionLogic= new OpcionLogic(connexion);
			opcionLogic.deepLoad(accion.getOpcion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Perfil.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Perfil.class));
			accion.setPerfils(accionDataAccess.getPerfils(connexion,accion));

			for(Perfil perfil:accion.getPerfils()) {
				PerfilLogic perfilLogic= new PerfilLogic(connexion);
				perfilLogic.deepLoad(perfil,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PerfilAccion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PerfilAccion.class));
			accion.setPerfilAccions(accionDataAccess.getPerfilAccions(connexion,accion));

			for(PerfilAccion perfilaccion:accion.getPerfilAccions()) {
				PerfilAccionLogic perfilaccionLogic= new PerfilAccionLogic(connexion);
				perfilaccionLogic.deepLoad(perfilaccion,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Accion accion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			AccionLogicAdditional.updateAccionToSave(accion,this.arrDatoGeneral);
			
AccionDataAccess.save(accion, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		OpcionDataAccess.save(accion.getOpcion(),connexion);

		for(Perfil perfil:accion.getPerfils()) {
			PerfilDataAccess.save(perfil,connexion);
		}

		for(PerfilAccion perfilaccion:accion.getPerfilAccions()) {
			perfilaccion.setid_accion(accion.getId());
			PerfilAccionDataAccess.save(perfilaccion,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Opcion.class)) {
				OpcionDataAccess.save(accion.getOpcion(),connexion);
				continue;
			}


			if(clas.clas.equals(Perfil.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Perfil perfil:accion.getPerfils()) {
					PerfilDataAccess.save(perfil,connexion);
				}
				continue;
			}

			if(clas.clas.equals(PerfilAccion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PerfilAccion perfilaccion:accion.getPerfilAccions()) {
					perfilaccion.setid_accion(accion.getId());
					PerfilAccionDataAccess.save(perfilaccion,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		OpcionDataAccess.save(accion.getOpcion(),connexion);
		OpcionLogic opcionLogic= new OpcionLogic(connexion);
		opcionLogic.deepLoad(accion.getOpcion(),isDeep,deepLoadType,clases);
				

		for(Perfil perfil:accion.getPerfils()) {
			PerfilLogic perfilLogic= new PerfilLogic(connexion);
			PerfilDataAccess.save(perfil,connexion);
			perfilLogic.deepSave(perfil,isDeep,deepLoadType,clases);
		}

		for(PerfilAccion perfilaccion:accion.getPerfilAccions()) {
			PerfilAccionLogic perfilaccionLogic= new PerfilAccionLogic(connexion);
			perfilaccion.setid_accion(accion.getId());
			PerfilAccionDataAccess.save(perfilaccion,connexion);
			perfilaccionLogic.deepSave(perfilaccion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Opcion.class)) {
				OpcionDataAccess.save(accion.getOpcion(),connexion);
				OpcionLogic opcionLogic= new OpcionLogic(connexion);
				opcionLogic.deepSave(accion.getOpcion(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(Perfil.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Perfil perfil:accion.getPerfils()) {
					PerfilLogic perfilLogic= new PerfilLogic(connexion);
					PerfilDataAccess.save(perfil,connexion);
					perfilLogic.deepSave(perfil,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PerfilAccion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PerfilAccion perfilaccion:accion.getPerfilAccions()) {
					PerfilAccionLogic perfilaccionLogic= new PerfilAccionLogic(connexion);
					perfilaccion.setid_accion(accion.getId());
					PerfilAccionDataAccess.save(perfilaccion,connexion);
					perfilaccionLogic.deepSave(perfilaccion,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Accion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(accion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				AccionConstantesFunciones.refrescarForeignKeysDescripcionesAccion(accion);
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
			this.deepLoad(this.accion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				AccionConstantesFunciones.refrescarForeignKeysDescripcionesAccion(this.accion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Accion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(accions!=null) {
				for(Accion accion:accions) {
					this.deepLoad(accion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					AccionConstantesFunciones.refrescarForeignKeysDescripcionesAccion(accions);
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
			if(accions!=null) {
				for(Accion accion:accions) {
					this.deepLoad(accion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					AccionConstantesFunciones.refrescarForeignKeysDescripcionesAccion(accions);
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
			this.getNewConnexionToDeep(Accion.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(accion,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Accion.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(accions!=null) {
				for(Accion accion:accions) {
					this.deepSave(accion,isDeep,deepLoadType,clases);
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
			if(accions!=null) {
				for(Accion accion:accions) {
					this.deepSave(accion,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getAccionsFK_IdOpcionWithConnection(String sFinalQuery,Pagination pagination,Long id_opcion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Accion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidOpcion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidOpcion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_opcion,AccionConstantesFunciones.IDOPCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidOpcion);

			AccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdOpcion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			accions=accionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AccionConstantesFunciones.refrescarForeignKeysDescripcionesAccion(this.accions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAccionsFK_IdOpcion(String sFinalQuery,Pagination pagination,Long id_opcion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidOpcion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidOpcion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_opcion,AccionConstantesFunciones.IDOPCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidOpcion);

			AccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdOpcion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			accions=accionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AccionConstantesFunciones.refrescarForeignKeysDescripcionesAccion(this.accions);
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
			if(AccionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				//auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,AccionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Accion accion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		//AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		//auditoriaLogicAdditional.setConnexion(connexion);
		//AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(AccionConstantesFunciones.ISCONAUDITORIA) {
				if(accion.getIsNew()) {
					//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AccionDataAccess.TABLENAME, accion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(AccionConstantesFunciones.ISCONAUDITORIADETALLE) {
						//AccionLogic.registrarAuditoriaDetallesAccion(connexion,accion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(accion.getIsDeleted()) {
					/*if(!accion.getIsExpired()) {
						//auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,AccionDataAccess.TABLENAME, accion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						//AccionLogic.registrarAuditoriaDetallesAccion(connexion,accion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AccionDataAccess.TABLENAME, accion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(accion.getIsChanged()) {
					//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AccionDataAccess.TABLENAME, accion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(AccionConstantesFunciones.ISCONAUDITORIADETALLE) {
						//AccionLogic.registrarAuditoriaDetallesAccion(connexion,accion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesAccion(Connexion connexion,Accion accion)throws Exception {		
		//AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		//auditoriaDetalleLogicAdditional.setConnexion(connexion);
		//AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(accion.getIsNew()||!accion.getid_opcion().equals(accion.getAccionOriginal().getid_opcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(accion.getAccionOriginal().getid_opcion()!=null)
				{
					strValorActual=accion.getAccionOriginal().getid_opcion().toString();
				}
				if(accion.getid_opcion()!=null)
				{
					strValorNuevo=accion.getid_opcion().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AccionConstantesFunciones.IDOPCION,strValorActual,strValorNuevo);
			}	
			
			if(accion.getIsNew()||!accion.getcodigo().equals(accion.getAccionOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(accion.getAccionOriginal().getcodigo()!=null)
				{
					strValorActual=accion.getAccionOriginal().getcodigo();
				}
				if(accion.getcodigo()!=null)
				{
					strValorNuevo=accion.getcodigo() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AccionConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(accion.getIsNew()||!accion.getnombre().equals(accion.getAccionOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(accion.getAccionOriginal().getnombre()!=null)
				{
					strValorActual=accion.getAccionOriginal().getnombre();
				}
				if(accion.getnombre()!=null)
				{
					strValorNuevo=accion.getnombre() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AccionConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(accion.getIsNew()||!accion.getsolo_form().equals(accion.getAccionOriginal().getsolo_form()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(accion.getAccionOriginal().getsolo_form()!=null)
				{
					strValorActual=accion.getAccionOriginal().getsolo_form().toString();
				}
				if(accion.getsolo_form()!=null)
				{
					strValorNuevo=accion.getsolo_form().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AccionConstantesFunciones.SOLOFORM,strValorActual,strValorNuevo);
			}	
			
			if(accion.getIsNew()||!accion.getdescripcion().equals(accion.getAccionOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(accion.getAccionOriginal().getdescripcion()!=null)
				{
					strValorActual=accion.getAccionOriginal().getdescripcion();
				}
				if(accion.getdescripcion()!=null)
				{
					strValorNuevo=accion.getdescripcion() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AccionConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(accion.getIsNew()||!accion.getorden().equals(accion.getAccionOriginal().getorden()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(accion.getAccionOriginal().getorden()!=null)
				{
					strValorActual=accion.getAccionOriginal().getorden().toString();
				}
				if(accion.getorden()!=null)
				{
					strValorNuevo=accion.getorden().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AccionConstantesFunciones.ORDEN,strValorActual,strValorNuevo);
			}	
			
			if(accion.getIsNew()||!accion.getestado().equals(accion.getAccionOriginal().getestado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(accion.getAccionOriginal().getestado()!=null)
				{
					strValorActual=accion.getAccionOriginal().getestado().toString();
				}
				if(accion.getestado()!=null)
				{
					strValorNuevo=accion.getestado().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AccionConstantesFunciones.ESTADO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveAccionRelacionesWithConnection(Accion accion,List<PerfilAccion> perfilaccions) throws Exception {

		if(!accion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveAccionRelacionesBase(accion,perfilaccions,true);
		}
	}

	public void saveAccionRelaciones(Accion accion,List<PerfilAccion> perfilaccions)throws Exception {

		if(!accion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveAccionRelacionesBase(accion,perfilaccions,false);
		}
	}

	public void saveAccionRelacionesBase(Accion accion,List<PerfilAccion> perfilaccions,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Accion-saveRelacionesWithConnection");}
	
			accion.setPerfilAccions(perfilaccions);

			this.setAccion(accion);

			if(AccionLogicAdditional.validarSaveRelaciones(accion,this)) {

				AccionLogicAdditional.updateRelacionesToSave(accion,this);

				if((accion.getIsNew()||accion.getIsChanged())&&!accion.getIsDeleted()) {
					this.saveAccion();
					this.saveAccionRelacionesDetalles(perfilaccions);

				} else if(accion.getIsDeleted()) {
					this.saveAccionRelacionesDetalles(perfilaccions);
					this.saveAccion();
				}

				AccionLogicAdditional.updateRelacionesToSaveAfter(accion,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			PerfilAccionConstantesFunciones.InicializarGeneralEntityAuxiliaresPerfilAccions(perfilaccions,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveAccionRelacionesDetalles(List<PerfilAccion> perfilaccions)throws Exception {
		try {
	

			Long idAccionActual=this.getAccion().getId();

			PerfilAccionLogic perfilaccionLogic_Desde_Accion=new PerfilAccionLogic();
			perfilaccionLogic_Desde_Accion.setPerfilAccions(perfilaccions);

			perfilaccionLogic_Desde_Accion.setConnexion(this.getConnexion());
			perfilaccionLogic_Desde_Accion.setDatosCliente(this.datosCliente);

			for(PerfilAccion perfilaccion_Desde_Accion:perfilaccionLogic_Desde_Accion.getPerfilAccions()) {
				perfilaccion_Desde_Accion.setid_accion(idAccionActual);
			}

			perfilaccionLogic_Desde_Accion.savePerfilAccions();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfAccion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=AccionConstantesFunciones.getClassesForeignKeysOfAccion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAccion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=AccionConstantesFunciones.getClassesRelationshipsOfAccion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

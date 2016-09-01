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
import com.bydan.erp.seguridad.util.PerfilAccionConstantesFunciones;
import com.bydan.erp.seguridad.util.PerfilAccionParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.PerfilAccionParameterGeneral;
import com.bydan.erp.seguridad.business.entity.PerfilAccion;
import com.bydan.erp.seguridad.business.logic.PerfilAccionLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class PerfilAccionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PerfilAccionLogic.class);
	
	protected PerfilAccionDataAccess perfilaccionDataAccess; 	
	protected PerfilAccion perfilaccion;
	protected List<PerfilAccion> perfilaccions;
	protected Object perfilaccionObject;	
	protected List<Object> perfilaccionsObject;
	
	public static ClassValidator<PerfilAccion> perfilaccionValidator = new ClassValidator<PerfilAccion>(PerfilAccion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PerfilAccionLogicAdditional perfilaccionLogicAdditional=null;
	
	public PerfilAccionLogicAdditional getPerfilAccionLogicAdditional() {
		return this.perfilaccionLogicAdditional;
	}
	
	public void setPerfilAccionLogicAdditional(PerfilAccionLogicAdditional perfilaccionLogicAdditional) {
		try {
			this.perfilaccionLogicAdditional=perfilaccionLogicAdditional;
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
	
	
	
	
	public  PerfilAccionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.perfilaccionDataAccess = new PerfilAccionDataAccess();
			
			this.perfilaccions= new ArrayList<PerfilAccion>();
			this.perfilaccion= new PerfilAccion();
			
			this.perfilaccionObject=new Object();
			this.perfilaccionsObject=new ArrayList<Object>();
				
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
			
			this.perfilaccionDataAccess.setConnexionType(this.connexionType);
			this.perfilaccionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PerfilAccionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.perfilaccionDataAccess = new PerfilAccionDataAccess();
			this.perfilaccions= new ArrayList<PerfilAccion>();
			this.perfilaccion= new PerfilAccion();
			this.perfilaccionObject=new Object();
			this.perfilaccionsObject=new ArrayList<Object>();
			
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
			
			this.perfilaccionDataAccess.setConnexionType(this.connexionType);
			this.perfilaccionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PerfilAccion getPerfilAccion() throws Exception {	
		PerfilAccionLogicAdditional.checkPerfilAccionToGet(perfilaccion,this.datosCliente,this.arrDatoGeneral);
		PerfilAccionLogicAdditional.updatePerfilAccionToGet(perfilaccion,this.arrDatoGeneral);
		
		return perfilaccion;
	}
		
	public void setPerfilAccion(PerfilAccion newPerfilAccion) {
		this.perfilaccion = newPerfilAccion;
	}
	
	public PerfilAccionDataAccess getPerfilAccionDataAccess() {
		return perfilaccionDataAccess;
	}
	
	public void setPerfilAccionDataAccess(PerfilAccionDataAccess newperfilaccionDataAccess) {
		this.perfilaccionDataAccess = newperfilaccionDataAccess;
	}
	
	public List<PerfilAccion> getPerfilAccions() throws Exception {		
		this.quitarPerfilAccionsNulos();
		
		PerfilAccionLogicAdditional.checkPerfilAccionToGets(perfilaccions,this.datosCliente,this.arrDatoGeneral);
		
		for (PerfilAccion perfilaccionLocal: perfilaccions ) {
			PerfilAccionLogicAdditional.updatePerfilAccionToGet(perfilaccionLocal,this.arrDatoGeneral);
		}
		
		return perfilaccions;
	}
	
	public void setPerfilAccions(List<PerfilAccion> newPerfilAccions) {
		this.perfilaccions = newPerfilAccions;
	}
	
	public Object getPerfilAccionObject() {	
		this.perfilaccionObject=this.perfilaccionDataAccess.getEntityObject();
		return this.perfilaccionObject;
	}
		
	public void setPerfilAccionObject(Object newPerfilAccionObject) {
		this.perfilaccionObject = newPerfilAccionObject;
	}
	
	public List<Object> getPerfilAccionsObject() {		
		this.perfilaccionsObject=this.perfilaccionDataAccess.getEntitiesObject();
		return this.perfilaccionsObject;
	}
		
	public void setPerfilAccionsObject(List<Object> newPerfilAccionsObject) {
		this.perfilaccionsObject = newPerfilAccionsObject;
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
		
		if(this.perfilaccionDataAccess!=null) {
			this.perfilaccionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilAccion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			perfilaccionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			perfilaccionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		perfilaccion = new  PerfilAccion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilAccion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			perfilaccion=perfilaccionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.perfilaccion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PerfilAccionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilAccion(this.perfilaccion);
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
		perfilaccion = new  PerfilAccion();
		  		  
        try {
			
			perfilaccion=perfilaccionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.perfilaccion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PerfilAccionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilAccion(this.perfilaccion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		perfilaccion = new  PerfilAccion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilAccion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			perfilaccion=perfilaccionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.perfilaccion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PerfilAccionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilAccion(this.perfilaccion);
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
		perfilaccion = new  PerfilAccion();
		  		  
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
		perfilaccion = new  PerfilAccion();
		  		  
        try {
			
			perfilaccion=perfilaccionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.perfilaccion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PerfilAccionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilAccion(this.perfilaccion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		perfilaccion = new  PerfilAccion();
		  		  
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
		perfilaccion = new  PerfilAccion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilAccion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =perfilaccionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		perfilaccion = new  PerfilAccion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=perfilaccionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		perfilaccion = new  PerfilAccion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilAccion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =perfilaccionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		perfilaccion = new  PerfilAccion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=perfilaccionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		perfilaccion = new  PerfilAccion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilAccion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =perfilaccionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		perfilaccion = new  PerfilAccion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=perfilaccionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		perfilaccions = new  ArrayList<PerfilAccion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilAccion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PerfilAccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfilaccions=perfilaccionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPerfilAccion(perfilaccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilAccionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilAccion(this.perfilaccions);
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
		perfilaccions = new  ArrayList<PerfilAccion>();
		  		  
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
		perfilaccions = new  ArrayList<PerfilAccion>();
		  		  
        try {			
			PerfilAccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfilaccions=perfilaccionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPerfilAccion(perfilaccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilAccionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilAccion(this.perfilaccions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		perfilaccions = new  ArrayList<PerfilAccion>();
		  		  
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
		perfilaccions = new  ArrayList<PerfilAccion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilAccion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PerfilAccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfilaccions=perfilaccionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPerfilAccion(perfilaccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilAccionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilAccion(this.perfilaccions);
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
		perfilaccions = new  ArrayList<PerfilAccion>();
		  		  
        try {
			PerfilAccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfilaccions=perfilaccionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPerfilAccion(perfilaccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilAccionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilAccion(this.perfilaccions);
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
		perfilaccions = new  ArrayList<PerfilAccion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilAccion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PerfilAccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfilaccions=perfilaccionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPerfilAccion(perfilaccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilAccionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilAccion(this.perfilaccions);
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
		perfilaccions = new  ArrayList<PerfilAccion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PerfilAccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfilaccions=perfilaccionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPerfilAccion(perfilaccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilAccionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilAccion(this.perfilaccions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		perfilaccion = new  PerfilAccion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilAccion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PerfilAccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfilaccion=perfilaccionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPerfilAccion(perfilaccion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilAccionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilAccion(this.perfilaccion);
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
		perfilaccion = new  PerfilAccion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PerfilAccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfilaccion=perfilaccionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPerfilAccion(perfilaccion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilAccionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilAccion(this.perfilaccion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		perfilaccions = new  ArrayList<PerfilAccion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilAccion.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			PerfilAccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfilaccions=perfilaccionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPerfilAccion(perfilaccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilAccionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilAccion(this.perfilaccions);
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
		perfilaccions = new  ArrayList<PerfilAccion>();
		  		  
        try {
			PerfilAccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfilaccions=perfilaccionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPerfilAccion(perfilaccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilAccionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilAccion(this.perfilaccions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosPerfilAccionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		perfilaccions = new  ArrayList<PerfilAccion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilAccion.class.getSimpleName()+"-getTodosPerfilAccionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PerfilAccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfilaccions=perfilaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPerfilAccion(perfilaccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilAccionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilAccion(this.perfilaccions);
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
	
	public  void  getTodosPerfilAccions(String sFinalQuery,Pagination pagination)throws Exception {
		perfilaccions = new  ArrayList<PerfilAccion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PerfilAccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfilaccions=perfilaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPerfilAccion(perfilaccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilAccionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilAccion(this.perfilaccions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPerfilAccion(PerfilAccion perfilaccion) throws Exception {
		Boolean estaValidado=false;
		
		if(perfilaccion.getIsNew() || perfilaccion.getIsChanged()) { 
			this.invalidValues = perfilaccionValidator.getInvalidValues(perfilaccion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(perfilaccion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPerfilAccion(List<PerfilAccion> PerfilAccions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(PerfilAccion perfilaccionLocal:perfilaccions) {				
			estaValidadoObjeto=this.validarGuardarPerfilAccion(perfilaccionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPerfilAccion(List<PerfilAccion> PerfilAccions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPerfilAccion(perfilaccions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPerfilAccion(PerfilAccion PerfilAccion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPerfilAccion(perfilaccion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(PerfilAccion perfilaccion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+perfilaccion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PerfilAccionConstantesFunciones.getPerfilAccionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"perfilaccion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PerfilAccionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PerfilAccionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePerfilAccionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilAccion.class.getSimpleName()+"-savePerfilAccionWithConnection");connexion.begin();			
			
			PerfilAccionLogicAdditional.checkPerfilAccionToSave(this.perfilaccion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PerfilAccionLogicAdditional.updatePerfilAccionToSave(this.perfilaccion,this.arrDatoGeneral);
			
			PerfilAccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.perfilaccion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPerfilAccion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPerfilAccion(this.perfilaccion)) {
				PerfilAccionDataAccess.save(this.perfilaccion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.perfilaccion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PerfilAccionLogicAdditional.checkPerfilAccionToSaveAfter(this.perfilaccion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPerfilAccion();
			
			connexion.commit();			
			
			if(this.perfilaccion.getIsDeleted()) {
				this.perfilaccion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePerfilAccion()throws Exception {	
		try {	
			
			PerfilAccionLogicAdditional.checkPerfilAccionToSave(this.perfilaccion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PerfilAccionLogicAdditional.updatePerfilAccionToSave(this.perfilaccion,this.arrDatoGeneral);
			
			PerfilAccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.perfilaccion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPerfilAccion(this.perfilaccion)) {			
				PerfilAccionDataAccess.save(this.perfilaccion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.perfilaccion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PerfilAccionLogicAdditional.checkPerfilAccionToSaveAfter(this.perfilaccion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.perfilaccion.getIsDeleted()) {
				this.perfilaccion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePerfilAccionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilAccion.class.getSimpleName()+"-savePerfilAccionsWithConnection");connexion.begin();			
			
			PerfilAccionLogicAdditional.checkPerfilAccionToSaves(perfilaccions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPerfilAccions();
			
			Boolean validadoTodosPerfilAccion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PerfilAccion perfilaccionLocal:perfilaccions) {		
				if(perfilaccionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PerfilAccionLogicAdditional.updatePerfilAccionToSave(perfilaccionLocal,this.arrDatoGeneral);
	        	
				PerfilAccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),perfilaccionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPerfilAccion(perfilaccionLocal)) {
					PerfilAccionDataAccess.save(perfilaccionLocal, connexion);				
				} else {
					validadoTodosPerfilAccion=false;
				}
			}
			
			if(!validadoTodosPerfilAccion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PerfilAccionLogicAdditional.checkPerfilAccionToSavesAfter(perfilaccions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPerfilAccions();
			
			connexion.commit();		
			
			this.quitarPerfilAccionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePerfilAccions()throws Exception {				
		 try {	
			PerfilAccionLogicAdditional.checkPerfilAccionToSaves(perfilaccions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPerfilAccion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PerfilAccion perfilaccionLocal:perfilaccions) {				
				if(perfilaccionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PerfilAccionLogicAdditional.updatePerfilAccionToSave(perfilaccionLocal,this.arrDatoGeneral);
	        	
				PerfilAccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),perfilaccionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPerfilAccion(perfilaccionLocal)) {				
					PerfilAccionDataAccess.save(perfilaccionLocal, connexion);				
				} else {
					validadoTodosPerfilAccion=false;
				}
			}
			
			if(!validadoTodosPerfilAccion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PerfilAccionLogicAdditional.checkPerfilAccionToSavesAfter(perfilaccions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPerfilAccionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PerfilAccionParameterReturnGeneral procesarAccionPerfilAccions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PerfilAccion> perfilaccions,PerfilAccionParameterReturnGeneral perfilaccionParameterGeneral)throws Exception {
		 try {	
			PerfilAccionParameterReturnGeneral perfilaccionReturnGeneral=new PerfilAccionParameterReturnGeneral();
	
			PerfilAccionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,perfilaccions,perfilaccionParameterGeneral,perfilaccionReturnGeneral);
			
			return perfilaccionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PerfilAccionParameterReturnGeneral procesarAccionPerfilAccionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PerfilAccion> perfilaccions,PerfilAccionParameterReturnGeneral perfilaccionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilAccion.class.getSimpleName()+"-procesarAccionPerfilAccionsWithConnection");connexion.begin();			
			
			PerfilAccionParameterReturnGeneral perfilaccionReturnGeneral=new PerfilAccionParameterReturnGeneral();
	
			PerfilAccionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,perfilaccions,perfilaccionParameterGeneral,perfilaccionReturnGeneral);
			
			this.connexion.commit();
			
			return perfilaccionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PerfilAccionParameterReturnGeneral procesarEventosPerfilAccions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PerfilAccion> perfilaccions,PerfilAccion perfilaccion,PerfilAccionParameterReturnGeneral perfilaccionParameterGeneral,Boolean isEsNuevoPerfilAccion,ArrayList<Classe> clases)throws Exception {
		 try {	
			PerfilAccionParameterReturnGeneral perfilaccionReturnGeneral=new PerfilAccionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				perfilaccionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PerfilAccionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,perfilaccions,perfilaccion,perfilaccionParameterGeneral,perfilaccionReturnGeneral,isEsNuevoPerfilAccion,clases);
			
			return perfilaccionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PerfilAccionParameterReturnGeneral procesarEventosPerfilAccionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PerfilAccion> perfilaccions,PerfilAccion perfilaccion,PerfilAccionParameterReturnGeneral perfilaccionParameterGeneral,Boolean isEsNuevoPerfilAccion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilAccion.class.getSimpleName()+"-procesarEventosPerfilAccionsWithConnection");connexion.begin();			
			
			PerfilAccionParameterReturnGeneral perfilaccionReturnGeneral=new PerfilAccionParameterReturnGeneral();
	
			perfilaccionReturnGeneral.setPerfilAccion(perfilaccion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				perfilaccionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PerfilAccionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,perfilaccions,perfilaccion,perfilaccionParameterGeneral,perfilaccionReturnGeneral,isEsNuevoPerfilAccion,clases);
			
			this.connexion.commit();
			
			return perfilaccionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PerfilAccionParameterReturnGeneral procesarImportacionPerfilAccionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PerfilAccionParameterReturnGeneral perfilaccionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilAccion.class.getSimpleName()+"-procesarImportacionPerfilAccionsWithConnection");connexion.begin();			
			
			PerfilAccionParameterReturnGeneral perfilaccionReturnGeneral=new PerfilAccionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.perfilaccions=new ArrayList<PerfilAccion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.perfilaccion=new PerfilAccion();
				
				
				if(conColumnasBase) {this.perfilaccion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.perfilaccion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.perfilaccion.setejecusion(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.perfilaccion.setestado(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.perfilaccions.add(this.perfilaccion);
			}
			
			this.savePerfilAccions();
			
			this.connexion.commit();
			
			perfilaccionReturnGeneral.setConRetornoEstaProcesado(true);
			perfilaccionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return perfilaccionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPerfilAccionsEliminados() throws Exception {				
		
		List<PerfilAccion> perfilaccionsAux= new ArrayList<PerfilAccion>();
		
		for(PerfilAccion perfilaccion:perfilaccions) {
			if(!perfilaccion.getIsDeleted()) {
				perfilaccionsAux.add(perfilaccion);
			}
		}
		
		perfilaccions=perfilaccionsAux;
	}
	
	public void quitarPerfilAccionsNulos() throws Exception {				
		
		List<PerfilAccion> perfilaccionsAux= new ArrayList<PerfilAccion>();
		
		for(PerfilAccion perfilaccion : this.perfilaccions) {
			if(perfilaccion==null) {
				perfilaccionsAux.add(perfilaccion);
			}
		}
		
		//this.perfilaccions=perfilaccionsAux;
		
		this.perfilaccions.removeAll(perfilaccionsAux);
	}
	
	public void getSetVersionRowPerfilAccionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(perfilaccion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((perfilaccion.getIsDeleted() || (perfilaccion.getIsChanged()&&!perfilaccion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=perfilaccionDataAccess.getSetVersionRowPerfilAccion(connexion,perfilaccion.getId());
				
				if(!perfilaccion.getVersionRow().equals(timestamp)) {	
					perfilaccion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				perfilaccion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPerfilAccion()throws Exception {	
		
		if(perfilaccion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((perfilaccion.getIsDeleted() || (perfilaccion.getIsChanged()&&!perfilaccion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=perfilaccionDataAccess.getSetVersionRowPerfilAccion(connexion,perfilaccion.getId());
			
			try {							
				if(!perfilaccion.getVersionRow().equals(timestamp)) {	
					perfilaccion.setVersionRow(timestamp);
				}
				
				perfilaccion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPerfilAccionsWithConnection()throws Exception {	
		if(perfilaccions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(PerfilAccion perfilaccionAux:perfilaccions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(perfilaccionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(perfilaccionAux.getIsDeleted() || (perfilaccionAux.getIsChanged()&&!perfilaccionAux.getIsNew())) {
						
						timestamp=perfilaccionDataAccess.getSetVersionRowPerfilAccion(connexion,perfilaccionAux.getId());
						
						if(!perfilaccion.getVersionRow().equals(timestamp)) {	
							perfilaccionAux.setVersionRow(timestamp);
						}
								
						perfilaccionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPerfilAccions()throws Exception {	
		if(perfilaccions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(PerfilAccion perfilaccionAux:perfilaccions) {
					if(perfilaccionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(perfilaccionAux.getIsDeleted() || (perfilaccionAux.getIsChanged()&&!perfilaccionAux.getIsNew())) {
						
						timestamp=perfilaccionDataAccess.getSetVersionRowPerfilAccion(connexion,perfilaccionAux.getId());
						
						if(!perfilaccionAux.getVersionRow().equals(timestamp)) {	
							perfilaccionAux.setVersionRow(timestamp);
						}
						
													
						perfilaccionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PerfilAccionParameterReturnGeneral cargarCombosLoteForeignKeyPerfilAccionWithConnection(String finalQueryGlobalPerfil,String finalQueryGlobalAccion) throws Exception {
		PerfilAccionParameterReturnGeneral  perfilaccionReturnGeneral =new PerfilAccionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilAccion.class.getSimpleName()+"-cargarCombosLoteForeignKeyPerfilAccionWithConnection");connexion.begin();
			
			perfilaccionReturnGeneral =new PerfilAccionParameterReturnGeneral();
			
			

			List<Perfil> perfilsForeignKey=new ArrayList<Perfil>();
			PerfilLogic perfilLogic=new PerfilLogic();
			perfilLogic.setConnexion(this.connexion);
			perfilLogic.getPerfilDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPerfil.equals("NONE")) {
				perfilLogic.getTodosPerfils(finalQueryGlobalPerfil,new Pagination());
				perfilsForeignKey=perfilLogic.getPerfils();
			}

			perfilaccionReturnGeneral.setperfilsForeignKey(perfilsForeignKey);


			List<Accion> accionsForeignKey=new ArrayList<Accion>();
			AccionLogic accionLogic=new AccionLogic();
			accionLogic.setConnexion(this.connexion);
			accionLogic.getAccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAccion.equals("NONE")) {
				accionLogic.getTodosAccions(finalQueryGlobalAccion,new Pagination());
				accionsForeignKey=accionLogic.getAccions();
			}

			perfilaccionReturnGeneral.setaccionsForeignKey(accionsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return perfilaccionReturnGeneral;
	}
	
	public PerfilAccionParameterReturnGeneral cargarCombosLoteForeignKeyPerfilAccion(String finalQueryGlobalPerfil,String finalQueryGlobalAccion) throws Exception {
		PerfilAccionParameterReturnGeneral  perfilaccionReturnGeneral =new PerfilAccionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			perfilaccionReturnGeneral =new PerfilAccionParameterReturnGeneral();
			
			

			List<Perfil> perfilsForeignKey=new ArrayList<Perfil>();
			PerfilLogic perfilLogic=new PerfilLogic();
			perfilLogic.setConnexion(this.connexion);
			perfilLogic.getPerfilDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPerfil.equals("NONE")) {
				perfilLogic.getTodosPerfils(finalQueryGlobalPerfil,new Pagination());
				perfilsForeignKey=perfilLogic.getPerfils();
			}

			perfilaccionReturnGeneral.setperfilsForeignKey(perfilsForeignKey);


			List<Accion> accionsForeignKey=new ArrayList<Accion>();
			AccionLogic accionLogic=new AccionLogic();
			accionLogic.setConnexion(this.connexion);
			accionLogic.getAccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAccion.equals("NONE")) {
				accionLogic.getTodosAccions(finalQueryGlobalAccion,new Pagination());
				accionsForeignKey=accionLogic.getAccions();
			}

			perfilaccionReturnGeneral.setaccionsForeignKey(accionsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return perfilaccionReturnGeneral;
	}
	
	
	public void deepLoad(PerfilAccion perfilaccion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PerfilAccionLogicAdditional.updatePerfilAccionToGet(perfilaccion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		perfilaccion.setPerfil(perfilaccionDataAccess.getPerfil(connexion,perfilaccion));
		perfilaccion.setAccion(perfilaccionDataAccess.getAccion(connexion,perfilaccion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Perfil.class)) {
				perfilaccion.setPerfil(perfilaccionDataAccess.getPerfil(connexion,perfilaccion));
				continue;
			}

			if(clas.clas.equals(Accion.class)) {
				perfilaccion.setAccion(perfilaccionDataAccess.getAccion(connexion,perfilaccion));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Perfil.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			perfilaccion.setPerfil(perfilaccionDataAccess.getPerfil(connexion,perfilaccion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Accion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			perfilaccion.setAccion(perfilaccionDataAccess.getAccion(connexion,perfilaccion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		perfilaccion.setPerfil(perfilaccionDataAccess.getPerfil(connexion,perfilaccion));
		PerfilLogic perfilLogic= new PerfilLogic(connexion);
		perfilLogic.deepLoad(perfilaccion.getPerfil(),isDeep,deepLoadType,clases);
				
		perfilaccion.setAccion(perfilaccionDataAccess.getAccion(connexion,perfilaccion));
		AccionLogic accionLogic= new AccionLogic(connexion);
		accionLogic.deepLoad(perfilaccion.getAccion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Perfil.class)) {
				perfilaccion.setPerfil(perfilaccionDataAccess.getPerfil(connexion,perfilaccion));
				PerfilLogic perfilLogic= new PerfilLogic(connexion);
				perfilLogic.deepLoad(perfilaccion.getPerfil(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Accion.class)) {
				perfilaccion.setAccion(perfilaccionDataAccess.getAccion(connexion,perfilaccion));
				AccionLogic accionLogic= new AccionLogic(connexion);
				accionLogic.deepLoad(perfilaccion.getAccion(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Perfil.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			perfilaccion.setPerfil(perfilaccionDataAccess.getPerfil(connexion,perfilaccion));
			PerfilLogic perfilLogic= new PerfilLogic(connexion);
			perfilLogic.deepLoad(perfilaccion.getPerfil(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Accion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			perfilaccion.setAccion(perfilaccionDataAccess.getAccion(connexion,perfilaccion));
			AccionLogic accionLogic= new AccionLogic(connexion);
			accionLogic.deepLoad(perfilaccion.getAccion(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(PerfilAccion perfilaccion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			PerfilAccionLogicAdditional.updatePerfilAccionToSave(perfilaccion,this.arrDatoGeneral);
			
PerfilAccionDataAccess.save(perfilaccion, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		PerfilDataAccess.save(perfilaccion.getPerfil(),connexion);

		AccionDataAccess.save(perfilaccion.getAccion(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Perfil.class)) {
				PerfilDataAccess.save(perfilaccion.getPerfil(),connexion);
				continue;
			}

			if(clas.clas.equals(Accion.class)) {
				AccionDataAccess.save(perfilaccion.getAccion(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		PerfilDataAccess.save(perfilaccion.getPerfil(),connexion);
		PerfilLogic perfilLogic= new PerfilLogic(connexion);
		perfilLogic.deepLoad(perfilaccion.getPerfil(),isDeep,deepLoadType,clases);
				

		AccionDataAccess.save(perfilaccion.getAccion(),connexion);
		AccionLogic accionLogic= new AccionLogic(connexion);
		accionLogic.deepLoad(perfilaccion.getAccion(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Perfil.class)) {
				PerfilDataAccess.save(perfilaccion.getPerfil(),connexion);
				PerfilLogic perfilLogic= new PerfilLogic(connexion);
				perfilLogic.deepSave(perfilaccion.getPerfil(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Accion.class)) {
				AccionDataAccess.save(perfilaccion.getAccion(),connexion);
				AccionLogic accionLogic= new AccionLogic(connexion);
				accionLogic.deepSave(perfilaccion.getAccion(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(PerfilAccion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(perfilaccion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PerfilAccionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilAccion(perfilaccion);
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
			this.deepLoad(this.perfilaccion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PerfilAccionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilAccion(this.perfilaccion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(PerfilAccion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(perfilaccions!=null) {
				for(PerfilAccion perfilaccion:perfilaccions) {
					this.deepLoad(perfilaccion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PerfilAccionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilAccion(perfilaccions);
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
			if(perfilaccions!=null) {
				for(PerfilAccion perfilaccion:perfilaccions) {
					this.deepLoad(perfilaccion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PerfilAccionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilAccion(perfilaccions);
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
			this.getNewConnexionToDeep(PerfilAccion.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(perfilaccion,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(PerfilAccion.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(perfilaccions!=null) {
				for(PerfilAccion perfilaccion:perfilaccions) {
					this.deepSave(perfilaccion,isDeep,deepLoadType,clases);
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
			if(perfilaccions!=null) {
				for(PerfilAccion perfilaccion:perfilaccions) {
					this.deepSave(perfilaccion,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getPerfilAccionsFK_IdAccionWithConnection(String sFinalQuery,Pagination pagination,Long id_accion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilAccion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_accion,PerfilAccionConstantesFunciones.IDACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAccion);

			PerfilAccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			perfilaccions=perfilaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PerfilAccionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilAccion(this.perfilaccions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPerfilAccionsFK_IdAccion(String sFinalQuery,Pagination pagination,Long id_accion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_accion,PerfilAccionConstantesFunciones.IDACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAccion);

			PerfilAccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			perfilaccions=perfilaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PerfilAccionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilAccion(this.perfilaccions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPerfilAccionsFK_IdPerfilWithConnection(String sFinalQuery,Pagination pagination,Long id_perfil)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PerfilAccion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPerfil= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPerfil.setParameterSelectionGeneralEqual(ParameterType.LONG,id_perfil,PerfilAccionConstantesFunciones.IDPERFIL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPerfil);

			PerfilAccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPerfil","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			perfilaccions=perfilaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PerfilAccionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilAccion(this.perfilaccions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPerfilAccionsFK_IdPerfil(String sFinalQuery,Pagination pagination,Long id_perfil)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPerfil= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPerfil.setParameterSelectionGeneralEqual(ParameterType.LONG,id_perfil,PerfilAccionConstantesFunciones.IDPERFIL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPerfil);

			PerfilAccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPerfil","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			perfilaccions=perfilaccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PerfilAccionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilAccion(this.perfilaccions);
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
			if(PerfilAccionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				//auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PerfilAccionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,PerfilAccion perfilaccion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		//AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		//auditoriaLogicAdditional.setConnexion(connexion);
		//AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PerfilAccionConstantesFunciones.ISCONAUDITORIA) {
				if(perfilaccion.getIsNew()) {
					//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PerfilAccionDataAccess.TABLENAME, perfilaccion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PerfilAccionConstantesFunciones.ISCONAUDITORIADETALLE) {
						//PerfilAccionLogic.registrarAuditoriaDetallesPerfilAccion(connexion,perfilaccion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(perfilaccion.getIsDeleted()) {
					/*if(!perfilaccion.getIsExpired()) {
						//auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PerfilAccionDataAccess.TABLENAME, perfilaccion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						//PerfilAccionLogic.registrarAuditoriaDetallesPerfilAccion(connexion,perfilaccion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PerfilAccionDataAccess.TABLENAME, perfilaccion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(perfilaccion.getIsChanged()) {
					//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PerfilAccionDataAccess.TABLENAME, perfilaccion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PerfilAccionConstantesFunciones.ISCONAUDITORIADETALLE) {
						//PerfilAccionLogic.registrarAuditoriaDetallesPerfilAccion(connexion,perfilaccion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPerfilAccion(Connexion connexion,PerfilAccion perfilaccion)throws Exception {		
		//AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		//auditoriaDetalleLogicAdditional.setConnexion(connexion);
		//AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(perfilaccion.getIsNew()||!perfilaccion.getid_perfil().equals(perfilaccion.getPerfilAccionOriginal().getid_perfil()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(perfilaccion.getPerfilAccionOriginal().getid_perfil()!=null)
				{
					strValorActual=perfilaccion.getPerfilAccionOriginal().getid_perfil().toString();
				}
				if(perfilaccion.getid_perfil()!=null)
				{
					strValorNuevo=perfilaccion.getid_perfil().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PerfilAccionConstantesFunciones.IDPERFIL,strValorActual,strValorNuevo);
			}	
			
			if(perfilaccion.getIsNew()||!perfilaccion.getid_accion().equals(perfilaccion.getPerfilAccionOriginal().getid_accion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(perfilaccion.getPerfilAccionOriginal().getid_accion()!=null)
				{
					strValorActual=perfilaccion.getPerfilAccionOriginal().getid_accion().toString();
				}
				if(perfilaccion.getid_accion()!=null)
				{
					strValorNuevo=perfilaccion.getid_accion().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PerfilAccionConstantesFunciones.IDACCION,strValorActual,strValorNuevo);
			}	
			
			if(perfilaccion.getIsNew()||!perfilaccion.getejecusion().equals(perfilaccion.getPerfilAccionOriginal().getejecusion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(perfilaccion.getPerfilAccionOriginal().getejecusion()!=null)
				{
					strValorActual=perfilaccion.getPerfilAccionOriginal().getejecusion().toString();
				}
				if(perfilaccion.getejecusion()!=null)
				{
					strValorNuevo=perfilaccion.getejecusion().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PerfilAccionConstantesFunciones.EJECUSION,strValorActual,strValorNuevo);
			}	
			
			if(perfilaccion.getIsNew()||!perfilaccion.getestado().equals(perfilaccion.getPerfilAccionOriginal().getestado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(perfilaccion.getPerfilAccionOriginal().getestado()!=null)
				{
					strValorActual=perfilaccion.getPerfilAccionOriginal().getestado().toString();
				}
				if(perfilaccion.getestado()!=null)
				{
					strValorNuevo=perfilaccion.getestado().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PerfilAccionConstantesFunciones.ESTADO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void savePerfilAccionRelacionesWithConnection(PerfilAccion perfilaccion) throws Exception {

		if(!perfilaccion.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePerfilAccionRelacionesBase(perfilaccion,true);
		}
	}

	public void savePerfilAccionRelaciones(PerfilAccion perfilaccion)throws Exception {

		if(!perfilaccion.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePerfilAccionRelacionesBase(perfilaccion,false);
		}
	}

	public void savePerfilAccionRelacionesBase(PerfilAccion perfilaccion,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("PerfilAccion-saveRelacionesWithConnection");}
	

			this.setPerfilAccion(perfilaccion);

			if(PerfilAccionLogicAdditional.validarSaveRelaciones(perfilaccion,this)) {

				PerfilAccionLogicAdditional.updateRelacionesToSave(perfilaccion,this);

				if((perfilaccion.getIsNew()||perfilaccion.getIsChanged())&&!perfilaccion.getIsDeleted()) {
					this.savePerfilAccion();
					this.savePerfilAccionRelacionesDetalles();

				} else if(perfilaccion.getIsDeleted()) {
					this.savePerfilAccionRelacionesDetalles();
					this.savePerfilAccion();
				}

				PerfilAccionLogicAdditional.updateRelacionesToSaveAfter(perfilaccion,this);

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
	
	
	private void savePerfilAccionRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPerfilAccion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PerfilAccionConstantesFunciones.getClassesForeignKeysOfPerfilAccion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPerfilAccion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PerfilAccionConstantesFunciones.getClassesRelationshipsOfPerfilAccion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

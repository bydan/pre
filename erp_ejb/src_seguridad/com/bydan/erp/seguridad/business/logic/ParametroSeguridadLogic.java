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
import com.bydan.erp.seguridad.util.ParametroSeguridadConstantesFunciones;
import com.bydan.erp.seguridad.util.ParametroSeguridadParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.ParametroSeguridadParameterGeneral;
import com.bydan.erp.seguridad.business.entity.ParametroSeguridad;
import com.bydan.erp.seguridad.business.logic.ParametroSeguridadLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class ParametroSeguridadLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ParametroSeguridadLogic.class);
	
	protected ParametroSeguridadDataAccess parametroseguridadDataAccess; 	
	protected ParametroSeguridad parametroseguridad;
	protected List<ParametroSeguridad> parametroseguridads;
	protected Object parametroseguridadObject;	
	protected List<Object> parametroseguridadsObject;
	
	public static ClassValidator<ParametroSeguridad> parametroseguridadValidator = new ClassValidator<ParametroSeguridad>(ParametroSeguridad.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ParametroSeguridadLogicAdditional parametroseguridadLogicAdditional=null;
	
	public ParametroSeguridadLogicAdditional getParametroSeguridadLogicAdditional() {
		return this.parametroseguridadLogicAdditional;
	}
	
	public void setParametroSeguridadLogicAdditional(ParametroSeguridadLogicAdditional parametroseguridadLogicAdditional) {
		try {
			this.parametroseguridadLogicAdditional=parametroseguridadLogicAdditional;
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
	
	
	
	
	public  ParametroSeguridadLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.parametroseguridadDataAccess = new ParametroSeguridadDataAccess();
			
			this.parametroseguridads= new ArrayList<ParametroSeguridad>();
			this.parametroseguridad= new ParametroSeguridad();
			
			this.parametroseguridadObject=new Object();
			this.parametroseguridadsObject=new ArrayList<Object>();
				
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
			
			this.parametroseguridadDataAccess.setConnexionType(this.connexionType);
			this.parametroseguridadDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ParametroSeguridadLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.parametroseguridadDataAccess = new ParametroSeguridadDataAccess();
			this.parametroseguridads= new ArrayList<ParametroSeguridad>();
			this.parametroseguridad= new ParametroSeguridad();
			this.parametroseguridadObject=new Object();
			this.parametroseguridadsObject=new ArrayList<Object>();
			
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
			
			this.parametroseguridadDataAccess.setConnexionType(this.connexionType);
			this.parametroseguridadDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ParametroSeguridad getParametroSeguridad() throws Exception {	
		ParametroSeguridadLogicAdditional.checkParametroSeguridadToGet(parametroseguridad,this.datosCliente,this.arrDatoGeneral);
		ParametroSeguridadLogicAdditional.updateParametroSeguridadToGet(parametroseguridad,this.arrDatoGeneral);
		
		return parametroseguridad;
	}
		
	public void setParametroSeguridad(ParametroSeguridad newParametroSeguridad) {
		this.parametroseguridad = newParametroSeguridad;
	}
	
	public ParametroSeguridadDataAccess getParametroSeguridadDataAccess() {
		return parametroseguridadDataAccess;
	}
	
	public void setParametroSeguridadDataAccess(ParametroSeguridadDataAccess newparametroseguridadDataAccess) {
		this.parametroseguridadDataAccess = newparametroseguridadDataAccess;
	}
	
	public List<ParametroSeguridad> getParametroSeguridads() throws Exception {		
		this.quitarParametroSeguridadsNulos();
		
		ParametroSeguridadLogicAdditional.checkParametroSeguridadToGets(parametroseguridads,this.datosCliente,this.arrDatoGeneral);
		
		for (ParametroSeguridad parametroseguridadLocal: parametroseguridads ) {
			ParametroSeguridadLogicAdditional.updateParametroSeguridadToGet(parametroseguridadLocal,this.arrDatoGeneral);
		}
		
		return parametroseguridads;
	}
	
	public void setParametroSeguridads(List<ParametroSeguridad> newParametroSeguridads) {
		this.parametroseguridads = newParametroSeguridads;
	}
	
	public Object getParametroSeguridadObject() {	
		this.parametroseguridadObject=this.parametroseguridadDataAccess.getEntityObject();
		return this.parametroseguridadObject;
	}
		
	public void setParametroSeguridadObject(Object newParametroSeguridadObject) {
		this.parametroseguridadObject = newParametroSeguridadObject;
	}
	
	public List<Object> getParametroSeguridadsObject() {		
		this.parametroseguridadsObject=this.parametroseguridadDataAccess.getEntitiesObject();
		return this.parametroseguridadsObject;
	}
		
	public void setParametroSeguridadsObject(List<Object> newParametroSeguridadsObject) {
		this.parametroseguridadsObject = newParametroSeguridadsObject;
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
		
		if(this.parametroseguridadDataAccess!=null) {
			this.parametroseguridadDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroSeguridad.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			parametroseguridadDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			parametroseguridadDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		parametroseguridad = new  ParametroSeguridad();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroSeguridad.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametroseguridad=parametroseguridadDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametroseguridad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroSeguridadConstantesFunciones.refrescarForeignKeysDescripcionesParametroSeguridad(this.parametroseguridad);
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
		parametroseguridad = new  ParametroSeguridad();
		  		  
        try {
			
			parametroseguridad=parametroseguridadDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametroseguridad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroSeguridadConstantesFunciones.refrescarForeignKeysDescripcionesParametroSeguridad(this.parametroseguridad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		parametroseguridad = new  ParametroSeguridad();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroSeguridad.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametroseguridad=parametroseguridadDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametroseguridad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroSeguridadConstantesFunciones.refrescarForeignKeysDescripcionesParametroSeguridad(this.parametroseguridad);
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
		parametroseguridad = new  ParametroSeguridad();
		  		  
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
		parametroseguridad = new  ParametroSeguridad();
		  		  
        try {
			
			parametroseguridad=parametroseguridadDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametroseguridad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroSeguridadConstantesFunciones.refrescarForeignKeysDescripcionesParametroSeguridad(this.parametroseguridad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		parametroseguridad = new  ParametroSeguridad();
		  		  
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
		parametroseguridad = new  ParametroSeguridad();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroSeguridad.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =parametroseguridadDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametroseguridad = new  ParametroSeguridad();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=parametroseguridadDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametroseguridad = new  ParametroSeguridad();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroSeguridad.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =parametroseguridadDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametroseguridad = new  ParametroSeguridad();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=parametroseguridadDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametroseguridad = new  ParametroSeguridad();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroSeguridad.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =parametroseguridadDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametroseguridad = new  ParametroSeguridad();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=parametroseguridadDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametroseguridads = new  ArrayList<ParametroSeguridad>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroSeguridad.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ParametroSeguridadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroseguridads=parametroseguridadDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroSeguridad(parametroseguridads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroSeguridadConstantesFunciones.refrescarForeignKeysDescripcionesParametroSeguridad(this.parametroseguridads);
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
		parametroseguridads = new  ArrayList<ParametroSeguridad>();
		  		  
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
		parametroseguridads = new  ArrayList<ParametroSeguridad>();
		  		  
        try {			
			ParametroSeguridadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroseguridads=parametroseguridadDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarParametroSeguridad(parametroseguridads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroSeguridadConstantesFunciones.refrescarForeignKeysDescripcionesParametroSeguridad(this.parametroseguridads);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		parametroseguridads = new  ArrayList<ParametroSeguridad>();
		  		  
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
		parametroseguridads = new  ArrayList<ParametroSeguridad>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroSeguridad.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ParametroSeguridadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroseguridads=parametroseguridadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroSeguridad(parametroseguridads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroSeguridadConstantesFunciones.refrescarForeignKeysDescripcionesParametroSeguridad(this.parametroseguridads);
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
		parametroseguridads = new  ArrayList<ParametroSeguridad>();
		  		  
        try {
			ParametroSeguridadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroseguridads=parametroseguridadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroSeguridad(parametroseguridads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroSeguridadConstantesFunciones.refrescarForeignKeysDescripcionesParametroSeguridad(this.parametroseguridads);
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
		parametroseguridads = new  ArrayList<ParametroSeguridad>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroSeguridad.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroSeguridadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroseguridads=parametroseguridadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroSeguridad(parametroseguridads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroSeguridadConstantesFunciones.refrescarForeignKeysDescripcionesParametroSeguridad(this.parametroseguridads);
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
		parametroseguridads = new  ArrayList<ParametroSeguridad>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroSeguridadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroseguridads=parametroseguridadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroSeguridad(parametroseguridads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroSeguridadConstantesFunciones.refrescarForeignKeysDescripcionesParametroSeguridad(this.parametroseguridads);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		parametroseguridad = new  ParametroSeguridad();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroSeguridad.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroSeguridadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroseguridad=parametroseguridadDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroSeguridad(parametroseguridad);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroSeguridadConstantesFunciones.refrescarForeignKeysDescripcionesParametroSeguridad(this.parametroseguridad);
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
		parametroseguridad = new  ParametroSeguridad();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroSeguridadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroseguridad=parametroseguridadDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroSeguridad(parametroseguridad);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroSeguridadConstantesFunciones.refrescarForeignKeysDescripcionesParametroSeguridad(this.parametroseguridad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosParametroSeguridadsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		parametroseguridads = new  ArrayList<ParametroSeguridad>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroSeguridad.class.getSimpleName()+"-getTodosParametroSeguridadsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroSeguridadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroseguridads=parametroseguridadDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroSeguridad(parametroseguridads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroSeguridadConstantesFunciones.refrescarForeignKeysDescripcionesParametroSeguridad(this.parametroseguridads);
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
	
	public  void  getTodosParametroSeguridads(String sFinalQuery,Pagination pagination)throws Exception {
		parametroseguridads = new  ArrayList<ParametroSeguridad>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroSeguridadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametroseguridads=parametroseguridadDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroSeguridad(parametroseguridads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroSeguridadConstantesFunciones.refrescarForeignKeysDescripcionesParametroSeguridad(this.parametroseguridads);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarParametroSeguridad(ParametroSeguridad parametroseguridad) throws Exception {
		Boolean estaValidado=false;
		
		if(parametroseguridad.getIsNew() || parametroseguridad.getIsChanged()) { 
			this.invalidValues = parametroseguridadValidator.getInvalidValues(parametroseguridad);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(parametroseguridad);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarParametroSeguridad(List<ParametroSeguridad> ParametroSeguridads) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ParametroSeguridad parametroseguridadLocal:parametroseguridads) {				
			estaValidadoObjeto=this.validarGuardarParametroSeguridad(parametroseguridadLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarParametroSeguridad(List<ParametroSeguridad> ParametroSeguridads) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroSeguridad(parametroseguridads)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarParametroSeguridad(ParametroSeguridad ParametroSeguridad) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroSeguridad(parametroseguridad)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ParametroSeguridad parametroseguridad) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+parametroseguridad.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ParametroSeguridadConstantesFunciones.getParametroSeguridadLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"parametroseguridad","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ParametroSeguridadConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ParametroSeguridadConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveParametroSeguridadWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroSeguridad.class.getSimpleName()+"-saveParametroSeguridadWithConnection");connexion.begin();			
			
			ParametroSeguridadLogicAdditional.checkParametroSeguridadToSave(this.parametroseguridad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroSeguridadLogicAdditional.updateParametroSeguridadToSave(this.parametroseguridad,this.arrDatoGeneral);
			
			ParametroSeguridadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametroseguridad,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowParametroSeguridad();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroSeguridad(this.parametroseguridad)) {
				ParametroSeguridadDataAccess.save(this.parametroseguridad, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.parametroseguridad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroSeguridadLogicAdditional.checkParametroSeguridadToSaveAfter(this.parametroseguridad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroSeguridad();
			
			connexion.commit();			
			
			if(this.parametroseguridad.getIsDeleted()) {
				this.parametroseguridad=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveParametroSeguridad()throws Exception {	
		try {	
			
			ParametroSeguridadLogicAdditional.checkParametroSeguridadToSave(this.parametroseguridad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroSeguridadLogicAdditional.updateParametroSeguridadToSave(this.parametroseguridad,this.arrDatoGeneral);
			
			ParametroSeguridadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametroseguridad,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroSeguridad(this.parametroseguridad)) {			
				ParametroSeguridadDataAccess.save(this.parametroseguridad, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.parametroseguridad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroSeguridadLogicAdditional.checkParametroSeguridadToSaveAfter(this.parametroseguridad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.parametroseguridad.getIsDeleted()) {
				this.parametroseguridad=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveParametroSeguridadsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroSeguridad.class.getSimpleName()+"-saveParametroSeguridadsWithConnection");connexion.begin();			
			
			ParametroSeguridadLogicAdditional.checkParametroSeguridadToSaves(parametroseguridads,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowParametroSeguridads();
			
			Boolean validadoTodosParametroSeguridad=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroSeguridad parametroseguridadLocal:parametroseguridads) {		
				if(parametroseguridadLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroSeguridadLogicAdditional.updateParametroSeguridadToSave(parametroseguridadLocal,this.arrDatoGeneral);
	        	
				ParametroSeguridadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametroseguridadLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroSeguridad(parametroseguridadLocal)) {
					ParametroSeguridadDataAccess.save(parametroseguridadLocal, connexion);				
				} else {
					validadoTodosParametroSeguridad=false;
				}
			}
			
			if(!validadoTodosParametroSeguridad) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroSeguridadLogicAdditional.checkParametroSeguridadToSavesAfter(parametroseguridads,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroSeguridads();
			
			connexion.commit();		
			
			this.quitarParametroSeguridadsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveParametroSeguridads()throws Exception {				
		 try {	
			ParametroSeguridadLogicAdditional.checkParametroSeguridadToSaves(parametroseguridads,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosParametroSeguridad=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroSeguridad parametroseguridadLocal:parametroseguridads) {				
				if(parametroseguridadLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroSeguridadLogicAdditional.updateParametroSeguridadToSave(parametroseguridadLocal,this.arrDatoGeneral);
	        	
				ParametroSeguridadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametroseguridadLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroSeguridad(parametroseguridadLocal)) {				
					ParametroSeguridadDataAccess.save(parametroseguridadLocal, connexion);				
				} else {
					validadoTodosParametroSeguridad=false;
				}
			}
			
			if(!validadoTodosParametroSeguridad) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroSeguridadLogicAdditional.checkParametroSeguridadToSavesAfter(parametroseguridads,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarParametroSeguridadsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroSeguridadParameterReturnGeneral procesarAccionParametroSeguridads(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroSeguridad> parametroseguridads,ParametroSeguridadParameterReturnGeneral parametroseguridadParameterGeneral)throws Exception {
		 try {	
			ParametroSeguridadParameterReturnGeneral parametroseguridadReturnGeneral=new ParametroSeguridadParameterReturnGeneral();
	
			ParametroSeguridadLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametroseguridads,parametroseguridadParameterGeneral,parametroseguridadReturnGeneral);
			
			return parametroseguridadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroSeguridadParameterReturnGeneral procesarAccionParametroSeguridadsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroSeguridad> parametroseguridads,ParametroSeguridadParameterReturnGeneral parametroseguridadParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroSeguridad.class.getSimpleName()+"-procesarAccionParametroSeguridadsWithConnection");connexion.begin();			
			
			ParametroSeguridadParameterReturnGeneral parametroseguridadReturnGeneral=new ParametroSeguridadParameterReturnGeneral();
	
			ParametroSeguridadLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametroseguridads,parametroseguridadParameterGeneral,parametroseguridadReturnGeneral);
			
			this.connexion.commit();
			
			return parametroseguridadReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroSeguridadParameterReturnGeneral procesarEventosParametroSeguridads(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroSeguridad> parametroseguridads,ParametroSeguridad parametroseguridad,ParametroSeguridadParameterReturnGeneral parametroseguridadParameterGeneral,Boolean isEsNuevoParametroSeguridad,ArrayList<Classe> clases)throws Exception {
		 try {	
			ParametroSeguridadParameterReturnGeneral parametroseguridadReturnGeneral=new ParametroSeguridadParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametroseguridadReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroSeguridadLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametroseguridads,parametroseguridad,parametroseguridadParameterGeneral,parametroseguridadReturnGeneral,isEsNuevoParametroSeguridad,clases);
			
			return parametroseguridadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ParametroSeguridadParameterReturnGeneral procesarEventosParametroSeguridadsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroSeguridad> parametroseguridads,ParametroSeguridad parametroseguridad,ParametroSeguridadParameterReturnGeneral parametroseguridadParameterGeneral,Boolean isEsNuevoParametroSeguridad,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroSeguridad.class.getSimpleName()+"-procesarEventosParametroSeguridadsWithConnection");connexion.begin();			
			
			ParametroSeguridadParameterReturnGeneral parametroseguridadReturnGeneral=new ParametroSeguridadParameterReturnGeneral();
	
			parametroseguridadReturnGeneral.setParametroSeguridad(parametroseguridad);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametroseguridadReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroSeguridadLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametroseguridads,parametroseguridad,parametroseguridadParameterGeneral,parametroseguridadReturnGeneral,isEsNuevoParametroSeguridad,clases);
			
			this.connexion.commit();
			
			return parametroseguridadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroSeguridadParameterReturnGeneral procesarImportacionParametroSeguridadsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ParametroSeguridadParameterReturnGeneral parametroseguridadParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroSeguridad.class.getSimpleName()+"-procesarImportacionParametroSeguridadsWithConnection");connexion.begin();			
			
			ParametroSeguridadParameterReturnGeneral parametroseguridadReturnGeneral=new ParametroSeguridadParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.parametroseguridads=new ArrayList<ParametroSeguridad>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.parametroseguridad=new ParametroSeguridad();
				
				
				if(conColumnasBase) {this.parametroseguridad.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.parametroseguridad.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.parametroseguridad.setcon_cartera(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametroseguridad.setcon_copiar_clientes(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametroseguridad.setcon_copiar_proveedores(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametroseguridad.setcon_generar_cliente_prove(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametroseguridad.setcliente_con_secuencial_auto(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametroseguridad.setcliente_num_maximo_iniciales(Integer.parseInt(arrColumnas[iColumn++]));
				this.parametroseguridad.setprove_con_secuencial_auto(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametroseguridad.setprove_num_maximo_iniciales(Integer.parseInt(arrColumnas[iColumn++]));
				this.parametroseguridad.setcon_validar_grupos(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametroseguridad.setacti_fijo_con_secuencial_auto(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.parametroseguridads.add(this.parametroseguridad);
			}
			
			this.saveParametroSeguridads();
			
			this.connexion.commit();
			
			parametroseguridadReturnGeneral.setConRetornoEstaProcesado(true);
			parametroseguridadReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return parametroseguridadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarParametroSeguridadsEliminados() throws Exception {				
		
		List<ParametroSeguridad> parametroseguridadsAux= new ArrayList<ParametroSeguridad>();
		
		for(ParametroSeguridad parametroseguridad:parametroseguridads) {
			if(!parametroseguridad.getIsDeleted()) {
				parametroseguridadsAux.add(parametroseguridad);
			}
		}
		
		parametroseguridads=parametroseguridadsAux;
	}
	
	public void quitarParametroSeguridadsNulos() throws Exception {				
		
		List<ParametroSeguridad> parametroseguridadsAux= new ArrayList<ParametroSeguridad>();
		
		for(ParametroSeguridad parametroseguridad : this.parametroseguridads) {
			if(parametroseguridad==null) {
				parametroseguridadsAux.add(parametroseguridad);
			}
		}
		
		//this.parametroseguridads=parametroseguridadsAux;
		
		this.parametroseguridads.removeAll(parametroseguridadsAux);
	}
	
	public void getSetVersionRowParametroSeguridadWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(parametroseguridad.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((parametroseguridad.getIsDeleted() || (parametroseguridad.getIsChanged()&&!parametroseguridad.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=parametroseguridadDataAccess.getSetVersionRowParametroSeguridad(connexion,parametroseguridad.getId());
				
				if(!parametroseguridad.getVersionRow().equals(timestamp)) {	
					parametroseguridad.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				parametroseguridad.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowParametroSeguridad()throws Exception {	
		
		if(parametroseguridad.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((parametroseguridad.getIsDeleted() || (parametroseguridad.getIsChanged()&&!parametroseguridad.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=parametroseguridadDataAccess.getSetVersionRowParametroSeguridad(connexion,parametroseguridad.getId());
			
			try {							
				if(!parametroseguridad.getVersionRow().equals(timestamp)) {	
					parametroseguridad.setVersionRow(timestamp);
				}
				
				parametroseguridad.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowParametroSeguridadsWithConnection()throws Exception {	
		if(parametroseguridads!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ParametroSeguridad parametroseguridadAux:parametroseguridads) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(parametroseguridadAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametroseguridadAux.getIsDeleted() || (parametroseguridadAux.getIsChanged()&&!parametroseguridadAux.getIsNew())) {
						
						timestamp=parametroseguridadDataAccess.getSetVersionRowParametroSeguridad(connexion,parametroseguridadAux.getId());
						
						if(!parametroseguridad.getVersionRow().equals(timestamp)) {	
							parametroseguridadAux.setVersionRow(timestamp);
						}
								
						parametroseguridadAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowParametroSeguridads()throws Exception {	
		if(parametroseguridads!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ParametroSeguridad parametroseguridadAux:parametroseguridads) {
					if(parametroseguridadAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametroseguridadAux.getIsDeleted() || (parametroseguridadAux.getIsChanged()&&!parametroseguridadAux.getIsNew())) {
						
						timestamp=parametroseguridadDataAccess.getSetVersionRowParametroSeguridad(connexion,parametroseguridadAux.getId());
						
						if(!parametroseguridadAux.getVersionRow().equals(timestamp)) {	
							parametroseguridadAux.setVersionRow(timestamp);
						}
						
													
						parametroseguridadAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ParametroSeguridadParameterReturnGeneral cargarCombosLoteForeignKeyParametroSeguridadWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		ParametroSeguridadParameterReturnGeneral  parametroseguridadReturnGeneral =new ParametroSeguridadParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroSeguridad.class.getSimpleName()+"-cargarCombosLoteForeignKeyParametroSeguridadWithConnection");connexion.begin();
			
			parametroseguridadReturnGeneral =new ParametroSeguridadParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametroseguridadReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return parametroseguridadReturnGeneral;
	}
	
	public ParametroSeguridadParameterReturnGeneral cargarCombosLoteForeignKeyParametroSeguridad(String finalQueryGlobalEmpresa) throws Exception {
		ParametroSeguridadParameterReturnGeneral  parametroseguridadReturnGeneral =new ParametroSeguridadParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			parametroseguridadReturnGeneral =new ParametroSeguridadParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametroseguridadReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return parametroseguridadReturnGeneral;
	}
	
	
	public void deepLoad(ParametroSeguridad parametroseguridad,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ParametroSeguridadLogicAdditional.updateParametroSeguridadToGet(parametroseguridad,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametroseguridad.setEmpresa(parametroseguridadDataAccess.getEmpresa(connexion,parametroseguridad));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametroseguridad.setEmpresa(parametroseguridadDataAccess.getEmpresa(connexion,parametroseguridad));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroseguridad.setEmpresa(parametroseguridadDataAccess.getEmpresa(connexion,parametroseguridad));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametroseguridad.setEmpresa(parametroseguridadDataAccess.getEmpresa(connexion,parametroseguridad));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametroseguridad.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametroseguridad.setEmpresa(parametroseguridadDataAccess.getEmpresa(connexion,parametroseguridad));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(parametroseguridad.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametroseguridad.setEmpresa(parametroseguridadDataAccess.getEmpresa(connexion,parametroseguridad));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(parametroseguridad.getEmpresa(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ParametroSeguridad parametroseguridad,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ParametroSeguridad.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(parametroseguridad,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroSeguridadConstantesFunciones.refrescarForeignKeysDescripcionesParametroSeguridad(parametroseguridad);
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
			this.deepLoad(this.parametroseguridad,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroSeguridadConstantesFunciones.refrescarForeignKeysDescripcionesParametroSeguridad(this.parametroseguridad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ParametroSeguridad.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(parametroseguridads!=null) {
				for(ParametroSeguridad parametroseguridad:parametroseguridads) {
					this.deepLoad(parametroseguridad,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ParametroSeguridadConstantesFunciones.refrescarForeignKeysDescripcionesParametroSeguridad(parametroseguridads);
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
			if(parametroseguridads!=null) {
				for(ParametroSeguridad parametroseguridad:parametroseguridads) {
					this.deepLoad(parametroseguridad,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ParametroSeguridadConstantesFunciones.refrescarForeignKeysDescripcionesParametroSeguridad(parametroseguridads);
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
	
	
	public void getParametroSeguridadsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroSeguridad.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroSeguridadConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroSeguridadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroseguridads=parametroseguridadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroSeguridadConstantesFunciones.refrescarForeignKeysDescripcionesParametroSeguridad(this.parametroseguridads);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroSeguridadsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroSeguridadConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroSeguridadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametroseguridads=parametroseguridadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroSeguridadConstantesFunciones.refrescarForeignKeysDescripcionesParametroSeguridad(this.parametroseguridads);
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
			if(ParametroSeguridadConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroSeguridadDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ParametroSeguridad parametroseguridad,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ParametroSeguridadConstantesFunciones.ISCONAUDITORIA) {
				if(parametroseguridad.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroSeguridadDataAccess.TABLENAME, parametroseguridad.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroSeguridadConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroSeguridadLogic.registrarAuditoriaDetallesParametroSeguridad(connexion,parametroseguridad,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(parametroseguridad.getIsDeleted()) {
					/*if(!parametroseguridad.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ParametroSeguridadDataAccess.TABLENAME, parametroseguridad.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ParametroSeguridadLogic.registrarAuditoriaDetallesParametroSeguridad(connexion,parametroseguridad,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroSeguridadDataAccess.TABLENAME, parametroseguridad.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(parametroseguridad.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroSeguridadDataAccess.TABLENAME, parametroseguridad.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroSeguridadConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroSeguridadLogic.registrarAuditoriaDetallesParametroSeguridad(connexion,parametroseguridad,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesParametroSeguridad(Connexion connexion,ParametroSeguridad parametroseguridad)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(parametroseguridad.getIsNew()||!parametroseguridad.getid_empresa().equals(parametroseguridad.getParametroSeguridadOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroseguridad.getParametroSeguridadOriginal().getid_empresa()!=null)
				{
					strValorActual=parametroseguridad.getParametroSeguridadOriginal().getid_empresa().toString();
				}
				if(parametroseguridad.getid_empresa()!=null)
				{
					strValorNuevo=parametroseguridad.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroSeguridadConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(parametroseguridad.getIsNew()||!parametroseguridad.getcon_cartera().equals(parametroseguridad.getParametroSeguridadOriginal().getcon_cartera()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroseguridad.getParametroSeguridadOriginal().getcon_cartera()!=null)
				{
					strValorActual=parametroseguridad.getParametroSeguridadOriginal().getcon_cartera().toString();
				}
				if(parametroseguridad.getcon_cartera()!=null)
				{
					strValorNuevo=parametroseguridad.getcon_cartera().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroSeguridadConstantesFunciones.CONCARTERA,strValorActual,strValorNuevo);
			}	
			
			if(parametroseguridad.getIsNew()||!parametroseguridad.getcon_copiar_clientes().equals(parametroseguridad.getParametroSeguridadOriginal().getcon_copiar_clientes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroseguridad.getParametroSeguridadOriginal().getcon_copiar_clientes()!=null)
				{
					strValorActual=parametroseguridad.getParametroSeguridadOriginal().getcon_copiar_clientes().toString();
				}
				if(parametroseguridad.getcon_copiar_clientes()!=null)
				{
					strValorNuevo=parametroseguridad.getcon_copiar_clientes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroSeguridadConstantesFunciones.CONCOPIARCLIENTES,strValorActual,strValorNuevo);
			}	
			
			if(parametroseguridad.getIsNew()||!parametroseguridad.getcon_copiar_proveedores().equals(parametroseguridad.getParametroSeguridadOriginal().getcon_copiar_proveedores()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroseguridad.getParametroSeguridadOriginal().getcon_copiar_proveedores()!=null)
				{
					strValorActual=parametroseguridad.getParametroSeguridadOriginal().getcon_copiar_proveedores().toString();
				}
				if(parametroseguridad.getcon_copiar_proveedores()!=null)
				{
					strValorNuevo=parametroseguridad.getcon_copiar_proveedores().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroSeguridadConstantesFunciones.CONCOPIARPROVEEDORES,strValorActual,strValorNuevo);
			}	
			
			if(parametroseguridad.getIsNew()||!parametroseguridad.getcon_generar_cliente_prove().equals(parametroseguridad.getParametroSeguridadOriginal().getcon_generar_cliente_prove()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroseguridad.getParametroSeguridadOriginal().getcon_generar_cliente_prove()!=null)
				{
					strValorActual=parametroseguridad.getParametroSeguridadOriginal().getcon_generar_cliente_prove().toString();
				}
				if(parametroseguridad.getcon_generar_cliente_prove()!=null)
				{
					strValorNuevo=parametroseguridad.getcon_generar_cliente_prove().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroSeguridadConstantesFunciones.CONGENERARCLIENTEPROVE,strValorActual,strValorNuevo);
			}	
			
			if(parametroseguridad.getIsNew()||!parametroseguridad.getcliente_con_secuencial_auto().equals(parametroseguridad.getParametroSeguridadOriginal().getcliente_con_secuencial_auto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroseguridad.getParametroSeguridadOriginal().getcliente_con_secuencial_auto()!=null)
				{
					strValorActual=parametroseguridad.getParametroSeguridadOriginal().getcliente_con_secuencial_auto().toString();
				}
				if(parametroseguridad.getcliente_con_secuencial_auto()!=null)
				{
					strValorNuevo=parametroseguridad.getcliente_con_secuencial_auto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroSeguridadConstantesFunciones.CLIENTECONSECUENCIALAUTO,strValorActual,strValorNuevo);
			}	
			
			if(parametroseguridad.getIsNew()||!parametroseguridad.getcliente_num_maximo_iniciales().equals(parametroseguridad.getParametroSeguridadOriginal().getcliente_num_maximo_iniciales()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroseguridad.getParametroSeguridadOriginal().getcliente_num_maximo_iniciales()!=null)
				{
					strValorActual=parametroseguridad.getParametroSeguridadOriginal().getcliente_num_maximo_iniciales().toString();
				}
				if(parametroseguridad.getcliente_num_maximo_iniciales()!=null)
				{
					strValorNuevo=parametroseguridad.getcliente_num_maximo_iniciales().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroSeguridadConstantesFunciones.CLIENTENUMMAXIMOINICIALES,strValorActual,strValorNuevo);
			}	
			
			if(parametroseguridad.getIsNew()||!parametroseguridad.getprove_con_secuencial_auto().equals(parametroseguridad.getParametroSeguridadOriginal().getprove_con_secuencial_auto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroseguridad.getParametroSeguridadOriginal().getprove_con_secuencial_auto()!=null)
				{
					strValorActual=parametroseguridad.getParametroSeguridadOriginal().getprove_con_secuencial_auto().toString();
				}
				if(parametroseguridad.getprove_con_secuencial_auto()!=null)
				{
					strValorNuevo=parametroseguridad.getprove_con_secuencial_auto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroSeguridadConstantesFunciones.PROVECONSECUENCIALAUTO,strValorActual,strValorNuevo);
			}	
			
			if(parametroseguridad.getIsNew()||!parametroseguridad.getprove_num_maximo_iniciales().equals(parametroseguridad.getParametroSeguridadOriginal().getprove_num_maximo_iniciales()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroseguridad.getParametroSeguridadOriginal().getprove_num_maximo_iniciales()!=null)
				{
					strValorActual=parametroseguridad.getParametroSeguridadOriginal().getprove_num_maximo_iniciales().toString();
				}
				if(parametroseguridad.getprove_num_maximo_iniciales()!=null)
				{
					strValorNuevo=parametroseguridad.getprove_num_maximo_iniciales().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroSeguridadConstantesFunciones.PROVENUMMAXIMOINICIALES,strValorActual,strValorNuevo);
			}	
			
			if(parametroseguridad.getIsNew()||!parametroseguridad.getcon_validar_grupos().equals(parametroseguridad.getParametroSeguridadOriginal().getcon_validar_grupos()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroseguridad.getParametroSeguridadOriginal().getcon_validar_grupos()!=null)
				{
					strValorActual=parametroseguridad.getParametroSeguridadOriginal().getcon_validar_grupos().toString();
				}
				if(parametroseguridad.getcon_validar_grupos()!=null)
				{
					strValorNuevo=parametroseguridad.getcon_validar_grupos().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroSeguridadConstantesFunciones.CONVALIDARGRUPOS,strValorActual,strValorNuevo);
			}	
			
			if(parametroseguridad.getIsNew()||!parametroseguridad.getacti_fijo_con_secuencial_auto().equals(parametroseguridad.getParametroSeguridadOriginal().getacti_fijo_con_secuencial_auto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametroseguridad.getParametroSeguridadOriginal().getacti_fijo_con_secuencial_auto()!=null)
				{
					strValorActual=parametroseguridad.getParametroSeguridadOriginal().getacti_fijo_con_secuencial_auto().toString();
				}
				if(parametroseguridad.getacti_fijo_con_secuencial_auto()!=null)
				{
					strValorNuevo=parametroseguridad.getacti_fijo_con_secuencial_auto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroSeguridadConstantesFunciones.ACTIFIJOCONSECUENCIALAUTO,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfParametroSeguridad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroSeguridadConstantesFunciones.getClassesForeignKeysOfParametroSeguridad(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroSeguridad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroSeguridadConstantesFunciones.getClassesRelationshipsOfParametroSeguridad(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

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
import com.bydan.erp.seguridad.util.SistemaConstantesFunciones;
import com.bydan.erp.seguridad.util.SistemaParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.SistemaParameterGeneral;
import com.bydan.erp.seguridad.business.entity.Sistema;
import com.bydan.erp.seguridad.business.logic.SistemaLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class SistemaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(SistemaLogic.class);
	
	protected SistemaDataAccess sistemaDataAccess; 	
	protected Sistema sistema;
	protected List<Sistema> sistemas;
	protected Object sistemaObject;	
	protected List<Object> sistemasObject;
	
	public static ClassValidator<Sistema> sistemaValidator = new ClassValidator<Sistema>(Sistema.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected SistemaLogicAdditional sistemaLogicAdditional=null;
	
	public SistemaLogicAdditional getSistemaLogicAdditional() {
		return this.sistemaLogicAdditional;
	}
	
	public void setSistemaLogicAdditional(SistemaLogicAdditional sistemaLogicAdditional) {
		try {
			this.sistemaLogicAdditional=sistemaLogicAdditional;
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
	
	
	
	
	public  SistemaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.sistemaDataAccess = new SistemaDataAccess();
			
			this.sistemas= new ArrayList<Sistema>();
			this.sistema= new Sistema();
			
			this.sistemaObject=new Object();
			this.sistemasObject=new ArrayList<Object>();
				
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
			
			this.sistemaDataAccess.setConnexionType(this.connexionType);
			this.sistemaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  SistemaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.sistemaDataAccess = new SistemaDataAccess();
			this.sistemas= new ArrayList<Sistema>();
			this.sistema= new Sistema();
			this.sistemaObject=new Object();
			this.sistemasObject=new ArrayList<Object>();
			
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
			
			this.sistemaDataAccess.setConnexionType(this.connexionType);
			this.sistemaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Sistema getSistema() throws Exception {	
		SistemaLogicAdditional.checkSistemaToGet(sistema,this.datosCliente,this.arrDatoGeneral);
		SistemaLogicAdditional.updateSistemaToGet(sistema,this.arrDatoGeneral);
		
		return sistema;
	}
		
	public void setSistema(Sistema newSistema) {
		this.sistema = newSistema;
	}
	
	public SistemaDataAccess getSistemaDataAccess() {
		return sistemaDataAccess;
	}
	
	public void setSistemaDataAccess(SistemaDataAccess newsistemaDataAccess) {
		this.sistemaDataAccess = newsistemaDataAccess;
	}
	
	public List<Sistema> getSistemas() throws Exception {		
		this.quitarSistemasNulos();
		
		SistemaLogicAdditional.checkSistemaToGets(sistemas,this.datosCliente,this.arrDatoGeneral);
		
		for (Sistema sistemaLocal: sistemas ) {
			SistemaLogicAdditional.updateSistemaToGet(sistemaLocal,this.arrDatoGeneral);
		}
		
		return sistemas;
	}
	
	public void setSistemas(List<Sistema> newSistemas) {
		this.sistemas = newSistemas;
	}
	
	public Object getSistemaObject() {	
		this.sistemaObject=this.sistemaDataAccess.getEntityObject();
		return this.sistemaObject;
	}
		
	public void setSistemaObject(Object newSistemaObject) {
		this.sistemaObject = newSistemaObject;
	}
	
	public List<Object> getSistemasObject() {		
		this.sistemasObject=this.sistemaDataAccess.getEntitiesObject();
		return this.sistemasObject;
	}
		
	public void setSistemasObject(List<Object> newSistemasObject) {
		this.sistemasObject = newSistemasObject;
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
		
		if(this.sistemaDataAccess!=null) {
			this.sistemaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sistema.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			sistemaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			sistemaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		sistema = new  Sistema();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sistema.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			sistema=sistemaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.sistema,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SistemaConstantesFunciones.refrescarForeignKeysDescripcionesSistema(this.sistema);
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
		sistema = new  Sistema();
		  		  
        try {
			
			sistema=sistemaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.sistema,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SistemaConstantesFunciones.refrescarForeignKeysDescripcionesSistema(this.sistema);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		sistema = new  Sistema();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sistema.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			sistema=sistemaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.sistema,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SistemaConstantesFunciones.refrescarForeignKeysDescripcionesSistema(this.sistema);
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
		sistema = new  Sistema();
		  		  
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
		sistema = new  Sistema();
		  		  
        try {
			
			sistema=sistemaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.sistema,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				SistemaConstantesFunciones.refrescarForeignKeysDescripcionesSistema(this.sistema);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		sistema = new  Sistema();
		  		  
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
		sistema = new  Sistema();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sistema.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =sistemaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		sistema = new  Sistema();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=sistemaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		sistema = new  Sistema();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sistema.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =sistemaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		sistema = new  Sistema();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=sistemaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		sistema = new  Sistema();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sistema.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =sistemaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		sistema = new  Sistema();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=sistemaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		sistemas = new  ArrayList<Sistema>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sistema.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			SistemaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sistemas=sistemaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSistema(sistemas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SistemaConstantesFunciones.refrescarForeignKeysDescripcionesSistema(this.sistemas);
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
		sistemas = new  ArrayList<Sistema>();
		  		  
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
		sistemas = new  ArrayList<Sistema>();
		  		  
        try {			
			SistemaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sistemas=sistemaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarSistema(sistemas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SistemaConstantesFunciones.refrescarForeignKeysDescripcionesSistema(this.sistemas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		sistemas = new  ArrayList<Sistema>();
		  		  
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
		sistemas = new  ArrayList<Sistema>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sistema.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			SistemaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sistemas=sistemaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSistema(sistemas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SistemaConstantesFunciones.refrescarForeignKeysDescripcionesSistema(this.sistemas);
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
		sistemas = new  ArrayList<Sistema>();
		  		  
        try {
			SistemaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sistemas=sistemaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSistema(sistemas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SistemaConstantesFunciones.refrescarForeignKeysDescripcionesSistema(this.sistemas);
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
		sistemas = new  ArrayList<Sistema>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sistema.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SistemaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sistemas=sistemaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSistema(sistemas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SistemaConstantesFunciones.refrescarForeignKeysDescripcionesSistema(this.sistemas);
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
		sistemas = new  ArrayList<Sistema>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SistemaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sistemas=sistemaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSistema(sistemas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SistemaConstantesFunciones.refrescarForeignKeysDescripcionesSistema(this.sistemas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		sistema = new  Sistema();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sistema.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SistemaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sistema=sistemaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSistema(sistema);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SistemaConstantesFunciones.refrescarForeignKeysDescripcionesSistema(this.sistema);
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
		sistema = new  Sistema();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SistemaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sistema=sistemaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarSistema(sistema);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SistemaConstantesFunciones.refrescarForeignKeysDescripcionesSistema(this.sistema);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		sistemas = new  ArrayList<Sistema>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sistema.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			SistemaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sistemas=sistemaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSistema(sistemas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SistemaConstantesFunciones.refrescarForeignKeysDescripcionesSistema(this.sistemas);
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
		sistemas = new  ArrayList<Sistema>();
		  		  
        try {
			SistemaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sistemas=sistemaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarSistema(sistemas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SistemaConstantesFunciones.refrescarForeignKeysDescripcionesSistema(this.sistemas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosSistemasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		sistemas = new  ArrayList<Sistema>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sistema.class.getSimpleName()+"-getTodosSistemasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SistemaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sistemas=sistemaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarSistema(sistemas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SistemaConstantesFunciones.refrescarForeignKeysDescripcionesSistema(this.sistemas);
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
	
	public  void  getTodosSistemas(String sFinalQuery,Pagination pagination)throws Exception {
		sistemas = new  ArrayList<Sistema>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			SistemaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			sistemas=sistemaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarSistema(sistemas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				SistemaConstantesFunciones.refrescarForeignKeysDescripcionesSistema(this.sistemas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarSistema(Sistema sistema) throws Exception {
		Boolean estaValidado=false;
		
		if(sistema.getIsNew() || sistema.getIsChanged()) { 
			this.invalidValues = sistemaValidator.getInvalidValues(sistema);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(sistema);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarSistema(List<Sistema> Sistemas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Sistema sistemaLocal:sistemas) {				
			estaValidadoObjeto=this.validarGuardarSistema(sistemaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarSistema(List<Sistema> Sistemas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarSistema(sistemas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarSistema(Sistema Sistema) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarSistema(sistema)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Sistema sistema) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+sistema.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=SistemaConstantesFunciones.getSistemaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"sistema","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(SistemaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(SistemaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveSistemaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sistema.class.getSimpleName()+"-saveSistemaWithConnection");connexion.begin();			
			
			SistemaLogicAdditional.checkSistemaToSave(this.sistema,this.datosCliente,connexion,this.arrDatoGeneral);
			
			SistemaLogicAdditional.updateSistemaToSave(this.sistema,this.arrDatoGeneral);
			
			SistemaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.sistema,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowSistema();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarSistema(this.sistema)) {
				SistemaDataAccess.save(this.sistema, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.sistema,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			SistemaLogicAdditional.checkSistemaToSaveAfter(this.sistema,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowSistema();
			
			connexion.commit();			
			
			if(this.sistema.getIsDeleted()) {
				this.sistema=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveSistema()throws Exception {	
		try {	
			
			SistemaLogicAdditional.checkSistemaToSave(this.sistema,this.datosCliente,connexion,this.arrDatoGeneral);
			
			SistemaLogicAdditional.updateSistemaToSave(this.sistema,this.arrDatoGeneral);
			
			SistemaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.sistema,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarSistema(this.sistema)) {			
				SistemaDataAccess.save(this.sistema, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.sistema,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			SistemaLogicAdditional.checkSistemaToSaveAfter(this.sistema,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.sistema.getIsDeleted()) {
				this.sistema=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveSistemasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sistema.class.getSimpleName()+"-saveSistemasWithConnection");connexion.begin();			
			
			SistemaLogicAdditional.checkSistemaToSaves(sistemas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowSistemas();
			
			Boolean validadoTodosSistema=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Sistema sistemaLocal:sistemas) {		
				if(sistemaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				SistemaLogicAdditional.updateSistemaToSave(sistemaLocal,this.arrDatoGeneral);
	        	
				SistemaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),sistemaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarSistema(sistemaLocal)) {
					SistemaDataAccess.save(sistemaLocal, connexion);				
				} else {
					validadoTodosSistema=false;
				}
			}
			
			if(!validadoTodosSistema) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			SistemaLogicAdditional.checkSistemaToSavesAfter(sistemas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowSistemas();
			
			connexion.commit();		
			
			this.quitarSistemasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveSistemas()throws Exception {				
		 try {	
			SistemaLogicAdditional.checkSistemaToSaves(sistemas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosSistema=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Sistema sistemaLocal:sistemas) {				
				if(sistemaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				SistemaLogicAdditional.updateSistemaToSave(sistemaLocal,this.arrDatoGeneral);
	        	
				SistemaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),sistemaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarSistema(sistemaLocal)) {				
					SistemaDataAccess.save(sistemaLocal, connexion);				
				} else {
					validadoTodosSistema=false;
				}
			}
			
			if(!validadoTodosSistema) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			SistemaLogicAdditional.checkSistemaToSavesAfter(sistemas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarSistemasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SistemaParameterReturnGeneral procesarAccionSistemas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Sistema> sistemas,SistemaParameterReturnGeneral sistemaParameterGeneral)throws Exception {
		 try {	
			SistemaParameterReturnGeneral sistemaReturnGeneral=new SistemaParameterReturnGeneral();
	
			SistemaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,sistemas,sistemaParameterGeneral,sistemaReturnGeneral);
			
			return sistemaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public SistemaParameterReturnGeneral procesarAccionSistemasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Sistema> sistemas,SistemaParameterReturnGeneral sistemaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sistema.class.getSimpleName()+"-procesarAccionSistemasWithConnection");connexion.begin();			
			
			SistemaParameterReturnGeneral sistemaReturnGeneral=new SistemaParameterReturnGeneral();
	
			SistemaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,sistemas,sistemaParameterGeneral,sistemaReturnGeneral);
			
			this.connexion.commit();
			
			return sistemaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public SistemaParameterReturnGeneral procesarEventosSistemas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Sistema> sistemas,Sistema sistema,SistemaParameterReturnGeneral sistemaParameterGeneral,Boolean isEsNuevoSistema,ArrayList<Classe> clases)throws Exception {
		 try {	
			SistemaParameterReturnGeneral sistemaReturnGeneral=new SistemaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				sistemaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			SistemaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,sistemas,sistema,sistemaParameterGeneral,sistemaReturnGeneral,isEsNuevoSistema,clases);
			
			return sistemaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public SistemaParameterReturnGeneral procesarEventosSistemasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Sistema> sistemas,Sistema sistema,SistemaParameterReturnGeneral sistemaParameterGeneral,Boolean isEsNuevoSistema,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sistema.class.getSimpleName()+"-procesarEventosSistemasWithConnection");connexion.begin();			
			
			SistemaParameterReturnGeneral sistemaReturnGeneral=new SistemaParameterReturnGeneral();
	
			sistemaReturnGeneral.setSistema(sistema);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				sistemaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			SistemaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,sistemas,sistema,sistemaParameterGeneral,sistemaReturnGeneral,isEsNuevoSistema,clases);
			
			this.connexion.commit();
			
			return sistemaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public SistemaParameterReturnGeneral procesarImportacionSistemasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,SistemaParameterReturnGeneral sistemaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sistema.class.getSimpleName()+"-procesarImportacionSistemasWithConnection");connexion.begin();			
			
			SistemaParameterReturnGeneral sistemaReturnGeneral=new SistemaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.sistemas=new ArrayList<Sistema>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.sistema=new Sistema();
				
				
				if(conColumnasBase) {this.sistema.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.sistema.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.sistema.setcodigo(arrColumnas[iColumn++]);
				this.sistema.setnombre_principal(arrColumnas[iColumn++]);
				this.sistema.setnombre_secundario(arrColumnas[iColumn++]);
				this.sistema.setestado(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.sistemas.add(this.sistema);
			}
			
			this.saveSistemas();
			
			this.connexion.commit();
			
			sistemaReturnGeneral.setConRetornoEstaProcesado(true);
			sistemaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return sistemaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarSistemasEliminados() throws Exception {				
		
		List<Sistema> sistemasAux= new ArrayList<Sistema>();
		
		for(Sistema sistema:sistemas) {
			if(!sistema.getIsDeleted()) {
				sistemasAux.add(sistema);
			}
		}
		
		sistemas=sistemasAux;
	}
	
	public void quitarSistemasNulos() throws Exception {				
		
		List<Sistema> sistemasAux= new ArrayList<Sistema>();
		
		for(Sistema sistema : this.sistemas) {
			if(sistema==null) {
				sistemasAux.add(sistema);
			}
		}
		
		//this.sistemas=sistemasAux;
		
		this.sistemas.removeAll(sistemasAux);
	}
	
	public void getSetVersionRowSistemaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(sistema.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((sistema.getIsDeleted() || (sistema.getIsChanged()&&!sistema.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=sistemaDataAccess.getSetVersionRowSistema(connexion,sistema.getId());
				
				if(!sistema.getVersionRow().equals(timestamp)) {	
					sistema.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				sistema.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowSistema()throws Exception {	
		
		if(sistema.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((sistema.getIsDeleted() || (sistema.getIsChanged()&&!sistema.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=sistemaDataAccess.getSetVersionRowSistema(connexion,sistema.getId());
			
			try {							
				if(!sistema.getVersionRow().equals(timestamp)) {	
					sistema.setVersionRow(timestamp);
				}
				
				sistema.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowSistemasWithConnection()throws Exception {	
		if(sistemas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Sistema sistemaAux:sistemas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(sistemaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(sistemaAux.getIsDeleted() || (sistemaAux.getIsChanged()&&!sistemaAux.getIsNew())) {
						
						timestamp=sistemaDataAccess.getSetVersionRowSistema(connexion,sistemaAux.getId());
						
						if(!sistema.getVersionRow().equals(timestamp)) {	
							sistemaAux.setVersionRow(timestamp);
						}
								
						sistemaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowSistemas()throws Exception {	
		if(sistemas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Sistema sistemaAux:sistemas) {
					if(sistemaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(sistemaAux.getIsDeleted() || (sistemaAux.getIsChanged()&&!sistemaAux.getIsNew())) {
						
						timestamp=sistemaDataAccess.getSetVersionRowSistema(connexion,sistemaAux.getId());
						
						if(!sistemaAux.getVersionRow().equals(timestamp)) {	
							sistemaAux.setVersionRow(timestamp);
						}
						
													
						sistemaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeySistemaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			PerfilLogic perfilLogic=new PerfilLogic();
			OpcionLogic opcionLogic=new OpcionLogic();
			PaqueteLogic paqueteLogic=new PaqueteLogic();
			ModuloLogic moduloLogic=new ModuloLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sistema.class.getSimpleName()+"-cargarRelacionesLoteForeignKeySistemaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Perfil.class));
			classes.add(new Classe(Opcion.class));
			classes.add(new Classe(Paquete.class));
			classes.add(new Classe(Modulo.class));
											
			

			perfilLogic.setConnexion(this.getConnexion());
			perfilLogic.setDatosCliente(this.datosCliente);
			perfilLogic.setIsConRefrescarForeignKeys(true);

			opcionLogic.setConnexion(this.getConnexion());
			opcionLogic.setDatosCliente(this.datosCliente);
			opcionLogic.setIsConRefrescarForeignKeys(true);

			paqueteLogic.setConnexion(this.getConnexion());
			paqueteLogic.setDatosCliente(this.datosCliente);
			paqueteLogic.setIsConRefrescarForeignKeys(true);

			moduloLogic.setConnexion(this.getConnexion());
			moduloLogic.setDatosCliente(this.datosCliente);
			moduloLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Sistema sistema:this.sistemas) {
				

				classes=new ArrayList<Classe>();
				classes=PerfilConstantesFunciones.getClassesForeignKeysOfPerfil(new ArrayList<Classe>(),DeepLoadType.NONE);

				perfilLogic.setPerfils(sistema.perfils);
				perfilLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=OpcionConstantesFunciones.getClassesForeignKeysOfOpcion(new ArrayList<Classe>(),DeepLoadType.NONE);

				opcionLogic.setOpcions(sistema.opcions);
				opcionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PaqueteConstantesFunciones.getClassesForeignKeysOfPaquete(new ArrayList<Classe>(),DeepLoadType.NONE);

				paqueteLogic.setPaquetes(sistema.paquetes);
				paqueteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ModuloConstantesFunciones.getClassesForeignKeysOfModulo(new ArrayList<Classe>(),DeepLoadType.NONE);

				moduloLogic.setModulos(sistema.modulos);
				moduloLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Sistema sistema,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			SistemaLogicAdditional.updateSistemaToGet(sistema,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		sistema.setPerfils(sistemaDataAccess.getPerfils(connexion,sistema));
		sistema.setOpcions(sistemaDataAccess.getOpcions(connexion,sistema));
		sistema.setPaquetes(sistemaDataAccess.getPaquetes(connexion,sistema));
		sistema.setModulos(sistemaDataAccess.getModulos(connexion,sistema));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Perfil.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				sistema.setPerfils(sistemaDataAccess.getPerfils(connexion,sistema));

				if(this.isConDeep) {
					PerfilLogic perfilLogic= new PerfilLogic(this.connexion);
					perfilLogic.setPerfils(sistema.getPerfils());
					ArrayList<Classe> classesLocal=PerfilConstantesFunciones.getClassesForeignKeysOfPerfil(new ArrayList<Classe>(),DeepLoadType.NONE);
					perfilLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PerfilConstantesFunciones.refrescarForeignKeysDescripcionesPerfil(perfilLogic.getPerfils());
					sistema.setPerfils(perfilLogic.getPerfils());
				}

				continue;
			}

			if(clas.clas.equals(Opcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				sistema.setOpcions(sistemaDataAccess.getOpcions(connexion,sistema));

				if(this.isConDeep) {
					OpcionLogic opcionLogic= new OpcionLogic(this.connexion);
					opcionLogic.setOpcions(sistema.getOpcions());
					ArrayList<Classe> classesLocal=OpcionConstantesFunciones.getClassesForeignKeysOfOpcion(new ArrayList<Classe>(),DeepLoadType.NONE);
					opcionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					OpcionConstantesFunciones.refrescarForeignKeysDescripcionesOpcion(opcionLogic.getOpcions());
					sistema.setOpcions(opcionLogic.getOpcions());
				}

				continue;
			}

			if(clas.clas.equals(Paquete.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				sistema.setPaquetes(sistemaDataAccess.getPaquetes(connexion,sistema));

				if(this.isConDeep) {
					PaqueteLogic paqueteLogic= new PaqueteLogic(this.connexion);
					paqueteLogic.setPaquetes(sistema.getPaquetes());
					ArrayList<Classe> classesLocal=PaqueteConstantesFunciones.getClassesForeignKeysOfPaquete(new ArrayList<Classe>(),DeepLoadType.NONE);
					paqueteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PaqueteConstantesFunciones.refrescarForeignKeysDescripcionesPaquete(paqueteLogic.getPaquetes());
					sistema.setPaquetes(paqueteLogic.getPaquetes());
				}

				continue;
			}

			if(clas.clas.equals(Modulo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				sistema.setModulos(sistemaDataAccess.getModulos(connexion,sistema));

				if(this.isConDeep) {
					ModuloLogic moduloLogic= new ModuloLogic(this.connexion);
					moduloLogic.setModulos(sistema.getModulos());
					ArrayList<Classe> classesLocal=ModuloConstantesFunciones.getClassesForeignKeysOfModulo(new ArrayList<Classe>(),DeepLoadType.NONE);
					moduloLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ModuloConstantesFunciones.refrescarForeignKeysDescripcionesModulo(moduloLogic.getModulos());
					sistema.setModulos(moduloLogic.getModulos());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


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
			sistema.setPerfils(sistemaDataAccess.getPerfils(connexion,sistema));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Opcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Opcion.class));
			sistema.setOpcions(sistemaDataAccess.getOpcions(connexion,sistema));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Paquete.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Paquete.class));
			sistema.setPaquetes(sistemaDataAccess.getPaquetes(connexion,sistema));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Modulo.class));
			sistema.setModulos(sistemaDataAccess.getModulos(connexion,sistema));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		sistema.setPerfils(sistemaDataAccess.getPerfils(connexion,sistema));

		for(Perfil perfil:sistema.getPerfils()) {
			PerfilLogic perfilLogic= new PerfilLogic(connexion);
			perfilLogic.deepLoad(perfil,isDeep,deepLoadType,clases);
		}

		sistema.setOpcions(sistemaDataAccess.getOpcions(connexion,sistema));

		for(Opcion opcion:sistema.getOpcions()) {
			OpcionLogic opcionLogic= new OpcionLogic(connexion);
			opcionLogic.deepLoad(opcion,isDeep,deepLoadType,clases);
		}

		sistema.setPaquetes(sistemaDataAccess.getPaquetes(connexion,sistema));

		for(Paquete paquete:sistema.getPaquetes()) {
			PaqueteLogic paqueteLogic= new PaqueteLogic(connexion);
			paqueteLogic.deepLoad(paquete,isDeep,deepLoadType,clases);
		}

		sistema.setModulos(sistemaDataAccess.getModulos(connexion,sistema));

		for(Modulo modulo:sistema.getModulos()) {
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(modulo,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Perfil.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				sistema.setPerfils(sistemaDataAccess.getPerfils(connexion,sistema));

				for(Perfil perfil:sistema.getPerfils()) {
					PerfilLogic perfilLogic= new PerfilLogic(connexion);
					perfilLogic.deepLoad(perfil,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Opcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				sistema.setOpcions(sistemaDataAccess.getOpcions(connexion,sistema));

				for(Opcion opcion:sistema.getOpcions()) {
					OpcionLogic opcionLogic= new OpcionLogic(connexion);
					opcionLogic.deepLoad(opcion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Paquete.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				sistema.setPaquetes(sistemaDataAccess.getPaquetes(connexion,sistema));

				for(Paquete paquete:sistema.getPaquetes()) {
					PaqueteLogic paqueteLogic= new PaqueteLogic(connexion);
					paqueteLogic.deepLoad(paquete,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Modulo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				sistema.setModulos(sistemaDataAccess.getModulos(connexion,sistema));

				for(Modulo modulo:sistema.getModulos()) {
					ModuloLogic moduloLogic= new ModuloLogic(connexion);
					moduloLogic.deepLoad(modulo,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


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
			sistema.setPerfils(sistemaDataAccess.getPerfils(connexion,sistema));

			for(Perfil perfil:sistema.getPerfils()) {
				PerfilLogic perfilLogic= new PerfilLogic(connexion);
				perfilLogic.deepLoad(perfil,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Opcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Opcion.class));
			sistema.setOpcions(sistemaDataAccess.getOpcions(connexion,sistema));

			for(Opcion opcion:sistema.getOpcions()) {
				OpcionLogic opcionLogic= new OpcionLogic(connexion);
				opcionLogic.deepLoad(opcion,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Paquete.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Paquete.class));
			sistema.setPaquetes(sistemaDataAccess.getPaquetes(connexion,sistema));

			for(Paquete paquete:sistema.getPaquetes()) {
				PaqueteLogic paqueteLogic= new PaqueteLogic(connexion);
				paqueteLogic.deepLoad(paquete,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Modulo.class));
			sistema.setModulos(sistemaDataAccess.getModulos(connexion,sistema));

			for(Modulo modulo:sistema.getModulos()) {
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(modulo,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Sistema sistema,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			SistemaLogicAdditional.updateSistemaToSave(sistema,this.arrDatoGeneral);
			
SistemaDataAccess.save(sistema, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(Perfil perfil:sistema.getPerfils()) {
			perfil.setid_sistema(sistema.getId());
			PerfilDataAccess.save(perfil,connexion);
		}

		for(Opcion opcion:sistema.getOpcions()) {
			opcion.setid_sistema(sistema.getId());
			OpcionDataAccess.save(opcion,connexion);
		}

		for(Paquete paquete:sistema.getPaquetes()) {
			paquete.setid_sistema(sistema.getId());
			PaqueteDataAccess.save(paquete,connexion);
		}

		for(Modulo modulo:sistema.getModulos()) {
			modulo.setid_sistema(sistema.getId());
			ModuloDataAccess.save(modulo,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(Perfil.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Perfil perfil:sistema.getPerfils()) {
					perfil.setid_sistema(sistema.getId());
					PerfilDataAccess.save(perfil,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Opcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Opcion opcion:sistema.getOpcions()) {
					opcion.setid_sistema(sistema.getId());
					OpcionDataAccess.save(opcion,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Paquete.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Paquete paquete:sistema.getPaquetes()) {
					paquete.setid_sistema(sistema.getId());
					PaqueteDataAccess.save(paquete,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Modulo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Modulo modulo:sistema.getModulos()) {
					modulo.setid_sistema(sistema.getId());
					ModuloDataAccess.save(modulo,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(Perfil perfil:sistema.getPerfils()) {
			PerfilLogic perfilLogic= new PerfilLogic(connexion);
			perfil.setid_sistema(sistema.getId());
			PerfilDataAccess.save(perfil,connexion);
			perfilLogic.deepSave(perfil,isDeep,deepLoadType,clases);
		}

		for(Opcion opcion:sistema.getOpcions()) {
			OpcionLogic opcionLogic= new OpcionLogic(connexion);
			opcion.setid_sistema(sistema.getId());
			OpcionDataAccess.save(opcion,connexion);
			opcionLogic.deepSave(opcion,isDeep,deepLoadType,clases);
		}

		for(Paquete paquete:sistema.getPaquetes()) {
			PaqueteLogic paqueteLogic= new PaqueteLogic(connexion);
			paquete.setid_sistema(sistema.getId());
			PaqueteDataAccess.save(paquete,connexion);
			paqueteLogic.deepSave(paquete,isDeep,deepLoadType,clases);
		}

		for(Modulo modulo:sistema.getModulos()) {
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			modulo.setid_sistema(sistema.getId());
			ModuloDataAccess.save(modulo,connexion);
			moduloLogic.deepSave(modulo,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(Perfil.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Perfil perfil:sistema.getPerfils()) {
					PerfilLogic perfilLogic= new PerfilLogic(connexion);
					perfil.setid_sistema(sistema.getId());
					PerfilDataAccess.save(perfil,connexion);
					perfilLogic.deepSave(perfil,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Opcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Opcion opcion:sistema.getOpcions()) {
					OpcionLogic opcionLogic= new OpcionLogic(connexion);
					opcion.setid_sistema(sistema.getId());
					OpcionDataAccess.save(opcion,connexion);
					opcionLogic.deepSave(opcion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Paquete.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Paquete paquete:sistema.getPaquetes()) {
					PaqueteLogic paqueteLogic= new PaqueteLogic(connexion);
					paquete.setid_sistema(sistema.getId());
					PaqueteDataAccess.save(paquete,connexion);
					paqueteLogic.deepSave(paquete,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Modulo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Modulo modulo:sistema.getModulos()) {
					ModuloLogic moduloLogic= new ModuloLogic(connexion);
					modulo.setid_sistema(sistema.getId());
					ModuloDataAccess.save(modulo,connexion);
					moduloLogic.deepSave(modulo,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Sistema.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(sistema,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SistemaConstantesFunciones.refrescarForeignKeysDescripcionesSistema(sistema);
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
			this.deepLoad(this.sistema,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				SistemaConstantesFunciones.refrescarForeignKeysDescripcionesSistema(this.sistema);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Sistema.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(sistemas!=null) {
				for(Sistema sistema:sistemas) {
					this.deepLoad(sistema,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					SistemaConstantesFunciones.refrescarForeignKeysDescripcionesSistema(sistemas);
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
			if(sistemas!=null) {
				for(Sistema sistema:sistemas) {
					this.deepLoad(sistema,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					SistemaConstantesFunciones.refrescarForeignKeysDescripcionesSistema(sistemas);
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
			this.getNewConnexionToDeep(Sistema.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(sistema,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Sistema.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(sistemas!=null) {
				for(Sistema sistema:sistemas) {
					this.deepSave(sistema,isDeep,deepLoadType,clases);
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
			if(sistemas!=null) {
				for(Sistema sistema:sistemas) {
					this.deepSave(sistema,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getSistemasBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sistema.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",SistemaConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			SistemaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			sistemas=sistemaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SistemaConstantesFunciones.refrescarForeignKeysDescripcionesSistema(this.sistemas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSistemasBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",SistemaConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			SistemaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			sistemas=sistemaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SistemaConstantesFunciones.refrescarForeignKeysDescripcionesSistema(this.sistemas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSistemasBusquedaPorNombrePrincipalWithConnection(String sFinalQuery,Pagination pagination,String nombre_principal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sistema.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombrePrincipal= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombrePrincipal.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre_principal+"%",SistemaConstantesFunciones.NOMBREPRINCIPAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombrePrincipal);

			SistemaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombrePrincipal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			sistemas=sistemaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SistemaConstantesFunciones.refrescarForeignKeysDescripcionesSistema(this.sistemas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSistemasBusquedaPorNombrePrincipal(String sFinalQuery,Pagination pagination,String nombre_principal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombrePrincipal= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombrePrincipal.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre_principal+"%",SistemaConstantesFunciones.NOMBREPRINCIPAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombrePrincipal);

			SistemaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombrePrincipal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			sistemas=sistemaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				SistemaConstantesFunciones.refrescarForeignKeysDescripcionesSistema(this.sistemas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSistemaPorCodigoWithConnection(String codigo)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sistema.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,SistemaConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			sistema=sistemaDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.sistema,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				SistemaConstantesFunciones.refrescarForeignKeysDescripcionesSistema(this.sistema);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSistemaPorCodigo(String codigo)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,SistemaConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			sistema=sistemaDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.sistema,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				SistemaConstantesFunciones.refrescarForeignKeysDescripcionesSistema(this.sistema);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getSistemaPorNombrePrincipalWithConnection(String nombre_principal)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Sistema.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombrePrincipal= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombrePrincipal.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre_principal,SistemaConstantesFunciones.NOMBREPRINCIPAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombrePrincipal);

			sistema=sistemaDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.sistema,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				SistemaConstantesFunciones.refrescarForeignKeysDescripcionesSistema(this.sistema);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getSistemaPorNombrePrincipal(String nombre_principal)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombrePrincipal= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombrePrincipal.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre_principal,SistemaConstantesFunciones.NOMBREPRINCIPAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombrePrincipal);

			sistema=sistemaDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.sistema,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				SistemaConstantesFunciones.refrescarForeignKeysDescripcionesSistema(this.sistema);
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
			if(SistemaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				//auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,SistemaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Sistema sistema,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		//AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		//auditoriaLogicAdditional.setConnexion(connexion);
		//AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(SistemaConstantesFunciones.ISCONAUDITORIA) {
				if(sistema.getIsNew()) {
					//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SistemaDataAccess.TABLENAME, sistema.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(SistemaConstantesFunciones.ISCONAUDITORIADETALLE) {
						//SistemaLogic.registrarAuditoriaDetallesSistema(connexion,sistema,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(sistema.getIsDeleted()) {
					/*if(!sistema.getIsExpired()) {
						//auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,SistemaDataAccess.TABLENAME, sistema.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						//SistemaLogic.registrarAuditoriaDetallesSistema(connexion,sistema,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SistemaDataAccess.TABLENAME, sistema.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(sistema.getIsChanged()) {
					//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,SistemaDataAccess.TABLENAME, sistema.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(SistemaConstantesFunciones.ISCONAUDITORIADETALLE) {
						//SistemaLogic.registrarAuditoriaDetallesSistema(connexion,sistema,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesSistema(Connexion connexion,Sistema sistema)throws Exception {		
		//AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		//auditoriaDetalleLogicAdditional.setConnexion(connexion);
		//AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(sistema.getIsNew()||!sistema.getcodigo().equals(sistema.getSistemaOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(sistema.getSistemaOriginal().getcodigo()!=null)
				{
					strValorActual=sistema.getSistemaOriginal().getcodigo();
				}
				if(sistema.getcodigo()!=null)
				{
					strValorNuevo=sistema.getcodigo() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SistemaConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(sistema.getIsNew()||!sistema.getnombre_principal().equals(sistema.getSistemaOriginal().getnombre_principal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(sistema.getSistemaOriginal().getnombre_principal()!=null)
				{
					strValorActual=sistema.getSistemaOriginal().getnombre_principal();
				}
				if(sistema.getnombre_principal()!=null)
				{
					strValorNuevo=sistema.getnombre_principal() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SistemaConstantesFunciones.NOMBREPRINCIPAL,strValorActual,strValorNuevo);
			}	
			
			if(sistema.getIsNew()||!sistema.getnombre_secundario().equals(sistema.getSistemaOriginal().getnombre_secundario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(sistema.getSistemaOriginal().getnombre_secundario()!=null)
				{
					strValorActual=sistema.getSistemaOriginal().getnombre_secundario();
				}
				if(sistema.getnombre_secundario()!=null)
				{
					strValorNuevo=sistema.getnombre_secundario() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SistemaConstantesFunciones.NOMBRESECUNDARIO,strValorActual,strValorNuevo);
			}	
			
			if(sistema.getIsNew()||!sistema.getestado().equals(sistema.getSistemaOriginal().getestado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(sistema.getSistemaOriginal().getestado()!=null)
				{
					strValorActual=sistema.getSistemaOriginal().getestado().toString();
				}
				if(sistema.getestado()!=null)
				{
					strValorNuevo=sistema.getestado().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),SistemaConstantesFunciones.ESTADO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveSistemaRelacionesWithConnection(Sistema sistema,List<Perfil> perfils,List<Opcion> opcions,List<Paquete> paquetes,List<Modulo> modulos) throws Exception {

		if(!sistema.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveSistemaRelacionesBase(sistema,perfils,opcions,paquetes,modulos,true);
		}
	}

	public void saveSistemaRelaciones(Sistema sistema,List<Perfil> perfils,List<Opcion> opcions,List<Paquete> paquetes,List<Modulo> modulos)throws Exception {

		if(!sistema.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveSistemaRelacionesBase(sistema,perfils,opcions,paquetes,modulos,false);
		}
	}

	public void saveSistemaRelacionesBase(Sistema sistema,List<Perfil> perfils,List<Opcion> opcions,List<Paquete> paquetes,List<Modulo> modulos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Sistema-saveRelacionesWithConnection");}
	
			sistema.setPerfils(perfils);
			sistema.setOpcions(opcions);
			sistema.setPaquetes(paquetes);
			sistema.setModulos(modulos);

			this.setSistema(sistema);

			if(SistemaLogicAdditional.validarSaveRelaciones(sistema,this)) {

				SistemaLogicAdditional.updateRelacionesToSave(sistema,this);

				if((sistema.getIsNew()||sistema.getIsChanged())&&!sistema.getIsDeleted()) {
					this.saveSistema();
					this.saveSistemaRelacionesDetalles(perfils,opcions,paquetes,modulos);

				} else if(sistema.getIsDeleted()) {
					this.saveSistemaRelacionesDetalles(perfils,opcions,paquetes,modulos);
					this.saveSistema();
				}

				SistemaLogicAdditional.updateRelacionesToSaveAfter(sistema,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			PerfilConstantesFunciones.InicializarGeneralEntityAuxiliaresPerfils(perfils,true,true);
			OpcionConstantesFunciones.InicializarGeneralEntityAuxiliaresOpcions(opcions,true,true);
			PaqueteConstantesFunciones.InicializarGeneralEntityAuxiliaresPaquetes(paquetes,true,true);
			ModuloConstantesFunciones.InicializarGeneralEntityAuxiliaresModulos(modulos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveSistemaRelacionesDetalles(List<Perfil> perfils,List<Opcion> opcions,List<Paquete> paquetes,List<Modulo> modulos)throws Exception {
		try {
	

			Long idSistemaActual=this.getSistema().getId();

			PerfilLogic perfilLogic_Desde_Sistema=new PerfilLogic();
			perfilLogic_Desde_Sistema.setPerfils(perfils);

			perfilLogic_Desde_Sistema.setConnexion(this.getConnexion());
			perfilLogic_Desde_Sistema.setDatosCliente(this.datosCliente);

			for(Perfil perfil_Desde_Sistema:perfilLogic_Desde_Sistema.getPerfils()) {
				perfil_Desde_Sistema.setid_sistema(idSistemaActual);

				perfilLogic_Desde_Sistema.setPerfil(perfil_Desde_Sistema);
				perfilLogic_Desde_Sistema.savePerfil();

				Long idPerfilActual=perfil_Desde_Sistema.getId();

				UsuarioOpcionLogic usuarioopcionLogic_Desde_Perfil=new UsuarioOpcionLogic();

				if(perfil_Desde_Sistema.getUsuarioOpcions()==null){
					perfil_Desde_Sistema.setUsuarioOpcions(new ArrayList<UsuarioOpcion>());
				}

				usuarioopcionLogic_Desde_Perfil.setUsuarioOpcions(perfil_Desde_Sistema.getUsuarioOpcions());

				usuarioopcionLogic_Desde_Perfil.setConnexion(this.getConnexion());
				usuarioopcionLogic_Desde_Perfil.setDatosCliente(this.datosCliente);

				for(UsuarioOpcion usuarioopcion_Desde_Perfil:usuarioopcionLogic_Desde_Perfil.getUsuarioOpcions()) {
					usuarioopcion_Desde_Perfil.setid_perfil(idPerfilActual);
				}

				usuarioopcionLogic_Desde_Perfil.saveUsuarioOpcions();

				PerfilUsuarioLogic perfilusuarioLogic_Desde_Perfil=new PerfilUsuarioLogic();

				if(perfil_Desde_Sistema.getPerfilUsuarios()==null){
					perfil_Desde_Sistema.setPerfilUsuarios(new ArrayList<PerfilUsuario>());
				}

				perfilusuarioLogic_Desde_Perfil.setPerfilUsuarios(perfil_Desde_Sistema.getPerfilUsuarios());

				perfilusuarioLogic_Desde_Perfil.setConnexion(this.getConnexion());
				perfilusuarioLogic_Desde_Perfil.setDatosCliente(this.datosCliente);

				for(PerfilUsuario perfilusuario_Desde_Perfil:perfilusuarioLogic_Desde_Perfil.getPerfilUsuarios()) {
					perfilusuario_Desde_Perfil.setid_perfil(idPerfilActual);
				}

				perfilusuarioLogic_Desde_Perfil.savePerfilUsuarios();

				PerfilOpcionLogic perfilopcionLogic_Desde_Perfil=new PerfilOpcionLogic();

				if(perfil_Desde_Sistema.getPerfilOpcions()==null){
					perfil_Desde_Sistema.setPerfilOpcions(new ArrayList<PerfilOpcion>());
				}

				perfilopcionLogic_Desde_Perfil.setPerfilOpcions(perfil_Desde_Sistema.getPerfilOpcions());

				perfilopcionLogic_Desde_Perfil.setConnexion(this.getConnexion());
				perfilopcionLogic_Desde_Perfil.setDatosCliente(this.datosCliente);

				for(PerfilOpcion perfilopcion_Desde_Perfil:perfilopcionLogic_Desde_Perfil.getPerfilOpcions()) {
					perfilopcion_Desde_Perfil.setid_perfil(idPerfilActual);
				}

				perfilopcionLogic_Desde_Perfil.savePerfilOpcions();
			}


			OpcionLogic opcionLogic_Desde_Sistema=new OpcionLogic();
			opcionLogic_Desde_Sistema.setOpcions(opcions);

			opcionLogic_Desde_Sistema.setConnexion(this.getConnexion());
			opcionLogic_Desde_Sistema.setDatosCliente(this.datosCliente);

			for(Opcion opcion_Desde_Sistema:opcionLogic_Desde_Sistema.getOpcions()) {
				opcion_Desde_Sistema.setid_sistema(idSistemaActual);

				opcionLogic_Desde_Sistema.setOpcion(opcion_Desde_Sistema);
				opcionLogic_Desde_Sistema.saveOpcion();

				Long idOpcionActual=opcion_Desde_Sistema.getId();

				UsuarioOpcionLogic usuarioopcionLogic_Desde_Opcion=new UsuarioOpcionLogic();

				if(opcion_Desde_Sistema.getUsuarioOpcions()==null){
					opcion_Desde_Sistema.setUsuarioOpcions(new ArrayList<UsuarioOpcion>());
				}

				usuarioopcionLogic_Desde_Opcion.setUsuarioOpcions(opcion_Desde_Sistema.getUsuarioOpcions());

				usuarioopcionLogic_Desde_Opcion.setConnexion(this.getConnexion());
				usuarioopcionLogic_Desde_Opcion.setDatosCliente(this.datosCliente);

				for(UsuarioOpcion usuarioopcion_Desde_Opcion:usuarioopcionLogic_Desde_Opcion.getUsuarioOpcions()) {
					usuarioopcion_Desde_Opcion.setid_opcion(idOpcionActual);
				}

				usuarioopcionLogic_Desde_Opcion.saveUsuarioOpcions();

				OpcionLogic opcionLogicHijos_Desde_Opcion=new OpcionLogic();

				if(opcion_Desde_Sistema.getOpcions()==null){
					opcion_Desde_Sistema.setOpcions(new ArrayList<Opcion>());
				}

				opcionLogicHijos_Desde_Opcion.setOpcions(opcion_Desde_Sistema.getOpcions());

				opcionLogicHijos_Desde_Opcion.setConnexion(this.getConnexion());
				opcionLogicHijos_Desde_Opcion.setDatosCliente(this.datosCliente);

				for(Opcion opcionHijos_Desde_Opcion:opcionLogicHijos_Desde_Opcion.getOpcions()) {
					opcionHijos_Desde_Opcion.setid_opcion(idOpcionActual);

					opcionLogicHijos_Desde_Opcion.setOpcion(opcionHijos_Desde_Opcion);
					opcionLogicHijos_Desde_Opcion.saveOpcion();
				}


				AccionLogic accionLogic_Desde_Opcion=new AccionLogic();

				if(opcion_Desde_Sistema.getAccions()==null){
					opcion_Desde_Sistema.setAccions(new ArrayList<Accion>());
				}

				accionLogic_Desde_Opcion.setAccions(opcion_Desde_Sistema.getAccions());

				accionLogic_Desde_Opcion.setConnexion(this.getConnexion());
				accionLogic_Desde_Opcion.setDatosCliente(this.datosCliente);

				for(Accion accion_Desde_Opcion:accionLogic_Desde_Opcion.getAccions()) {
					accion_Desde_Opcion.setid_opcion(idOpcionActual);

					accionLogic_Desde_Opcion.setAccion(accion_Desde_Opcion);
					accionLogic_Desde_Opcion.saveAccion();

					Long idAccionActual=accion_Desde_Opcion.getId();

					PerfilAccionLogic perfilaccionLogic_Desde_Accion=new PerfilAccionLogic();

					if(accion_Desde_Opcion.getPerfilAccions()==null){
						accion_Desde_Opcion.setPerfilAccions(new ArrayList<PerfilAccion>());
					}

					perfilaccionLogic_Desde_Accion.setPerfilAccions(accion_Desde_Opcion.getPerfilAccions());

					perfilaccionLogic_Desde_Accion.setConnexion(this.getConnexion());
					perfilaccionLogic_Desde_Accion.setDatosCliente(this.datosCliente);

					for(PerfilAccion perfilaccion_Desde_Accion:perfilaccionLogic_Desde_Accion.getPerfilAccions()) {
						perfilaccion_Desde_Accion.setid_accion(idAccionActual);
					}

					perfilaccionLogic_Desde_Accion.savePerfilAccions();
				}


				PerfilOpcionLogic perfilopcionLogic_Desde_Opcion=new PerfilOpcionLogic();

				if(opcion_Desde_Sistema.getPerfilOpcions()==null){
					opcion_Desde_Sistema.setPerfilOpcions(new ArrayList<PerfilOpcion>());
				}

				perfilopcionLogic_Desde_Opcion.setPerfilOpcions(opcion_Desde_Sistema.getPerfilOpcions());

				perfilopcionLogic_Desde_Opcion.setConnexion(this.getConnexion());
				perfilopcionLogic_Desde_Opcion.setDatosCliente(this.datosCliente);

				for(PerfilOpcion perfilopcion_Desde_Opcion:perfilopcionLogic_Desde_Opcion.getPerfilOpcions()) {
					perfilopcion_Desde_Opcion.setid_opcion(idOpcionActual);
				}

				perfilopcionLogic_Desde_Opcion.savePerfilOpcions();

				CampoLogic campoLogic_Desde_Opcion=new CampoLogic();

				if(opcion_Desde_Sistema.getCampos()==null){
					opcion_Desde_Sistema.setCampos(new ArrayList<Campo>());
				}

				campoLogic_Desde_Opcion.setCampos(opcion_Desde_Sistema.getCampos());

				campoLogic_Desde_Opcion.setConnexion(this.getConnexion());
				campoLogic_Desde_Opcion.setDatosCliente(this.datosCliente);

				for(Campo campo_Desde_Opcion:campoLogic_Desde_Opcion.getCampos()) {
					campo_Desde_Opcion.setid_opcion(idOpcionActual);

					campoLogic_Desde_Opcion.setCampo(campo_Desde_Opcion);
					campoLogic_Desde_Opcion.saveCampo();

					Long idCampoActual=campo_Desde_Opcion.getId();

					PerfilCampoLogic perfilcampoLogic_Desde_Campo=new PerfilCampoLogic();

					if(campo_Desde_Opcion.getPerfilCampos()==null){
						campo_Desde_Opcion.setPerfilCampos(new ArrayList<PerfilCampo>());
					}

					perfilcampoLogic_Desde_Campo.setPerfilCampos(campo_Desde_Opcion.getPerfilCampos());

					perfilcampoLogic_Desde_Campo.setConnexion(this.getConnexion());
					perfilcampoLogic_Desde_Campo.setDatosCliente(this.datosCliente);

					for(PerfilCampo perfilcampo_Desde_Campo:perfilcampoLogic_Desde_Campo.getPerfilCampos()) {
						perfilcampo_Desde_Campo.setid_campo(idCampoActual);
					}

					perfilcampoLogic_Desde_Campo.savePerfilCampos();
				}

			}


			PaqueteLogic paqueteLogic_Desde_Sistema=new PaqueteLogic();
			paqueteLogic_Desde_Sistema.setPaquetes(paquetes);

			paqueteLogic_Desde_Sistema.setConnexion(this.getConnexion());
			paqueteLogic_Desde_Sistema.setDatosCliente(this.datosCliente);

			for(Paquete paquete_Desde_Sistema:paqueteLogic_Desde_Sistema.getPaquetes()) {
				paquete_Desde_Sistema.setid_sistema(idSistemaActual);
			}

			paqueteLogic_Desde_Sistema.savePaquetes();

			ModuloLogic moduloLogic_Desde_Sistema=new ModuloLogic();
			moduloLogic_Desde_Sistema.setModulos(modulos);

			moduloLogic_Desde_Sistema.setConnexion(this.getConnexion());
			moduloLogic_Desde_Sistema.setDatosCliente(this.datosCliente);

			for(Modulo modulo_Desde_Sistema:moduloLogic_Desde_Sistema.getModulos()) {
				modulo_Desde_Sistema.setid_sistema(idSistemaActual);
			}

			moduloLogic_Desde_Sistema.saveModulos();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfSistema(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=SistemaConstantesFunciones.getClassesForeignKeysOfSistema(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfSistema(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=SistemaConstantesFunciones.getClassesRelationshipsOfSistema(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

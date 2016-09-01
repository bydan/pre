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
import com.bydan.erp.seguridad.util.PerfilConstantesFunciones;
import com.bydan.erp.seguridad.util.PerfilParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.PerfilParameterGeneral;
import com.bydan.erp.seguridad.business.entity.Perfil;
import com.bydan.erp.seguridad.business.logic.PerfilLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class PerfilLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PerfilLogic.class);
	
	protected PerfilDataAccess perfilDataAccess; 	
	protected Perfil perfil;
	protected List<Perfil> perfils;
	protected Object perfilObject;	
	protected List<Object> perfilsObject;
	
	public static ClassValidator<Perfil> perfilValidator = new ClassValidator<Perfil>(Perfil.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PerfilLogicAdditional perfilLogicAdditional=null;
	
	public PerfilLogicAdditional getPerfilLogicAdditional() {
		return this.perfilLogicAdditional;
	}
	
	public void setPerfilLogicAdditional(PerfilLogicAdditional perfilLogicAdditional) {
		try {
			this.perfilLogicAdditional=perfilLogicAdditional;
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
	
	
	
	
	public  PerfilLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.perfilDataAccess = new PerfilDataAccess();
			
			this.perfils= new ArrayList<Perfil>();
			this.perfil= new Perfil();
			
			this.perfilObject=new Object();
			this.perfilsObject=new ArrayList<Object>();
				
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
			
			this.perfilDataAccess.setConnexionType(this.connexionType);
			this.perfilDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PerfilLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.perfilDataAccess = new PerfilDataAccess();
			this.perfils= new ArrayList<Perfil>();
			this.perfil= new Perfil();
			this.perfilObject=new Object();
			this.perfilsObject=new ArrayList<Object>();
			
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
			
			this.perfilDataAccess.setConnexionType(this.connexionType);
			this.perfilDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Perfil getPerfil() throws Exception {	
		PerfilLogicAdditional.checkPerfilToGet(perfil,this.datosCliente,this.arrDatoGeneral);
		PerfilLogicAdditional.updatePerfilToGet(perfil,this.arrDatoGeneral);
		
		return perfil;
	}
		
	public void setPerfil(Perfil newPerfil) {
		this.perfil = newPerfil;
	}
	
	public PerfilDataAccess getPerfilDataAccess() {
		return perfilDataAccess;
	}
	
	public void setPerfilDataAccess(PerfilDataAccess newperfilDataAccess) {
		this.perfilDataAccess = newperfilDataAccess;
	}
	
	public List<Perfil> getPerfils() throws Exception {		
		this.quitarPerfilsNulos();
		
		PerfilLogicAdditional.checkPerfilToGets(perfils,this.datosCliente,this.arrDatoGeneral);
		
		for (Perfil perfilLocal: perfils ) {
			PerfilLogicAdditional.updatePerfilToGet(perfilLocal,this.arrDatoGeneral);
		}
		
		return perfils;
	}
	
	public void setPerfils(List<Perfil> newPerfils) {
		this.perfils = newPerfils;
	}
	
	public Object getPerfilObject() {	
		this.perfilObject=this.perfilDataAccess.getEntityObject();
		return this.perfilObject;
	}
		
	public void setPerfilObject(Object newPerfilObject) {
		this.perfilObject = newPerfilObject;
	}
	
	public List<Object> getPerfilsObject() {		
		this.perfilsObject=this.perfilDataAccess.getEntitiesObject();
		return this.perfilsObject;
	}
		
	public void setPerfilsObject(List<Object> newPerfilsObject) {
		this.perfilsObject = newPerfilsObject;
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
		
		if(this.perfilDataAccess!=null) {
			this.perfilDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Perfil.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			perfilDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			perfilDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		perfil = new  Perfil();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Perfil.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			perfil=perfilDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.perfil,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PerfilConstantesFunciones.refrescarForeignKeysDescripcionesPerfil(this.perfil);
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
		perfil = new  Perfil();
		  		  
        try {
			
			perfil=perfilDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.perfil,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PerfilConstantesFunciones.refrescarForeignKeysDescripcionesPerfil(this.perfil);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		perfil = new  Perfil();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Perfil.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			perfil=perfilDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.perfil,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PerfilConstantesFunciones.refrescarForeignKeysDescripcionesPerfil(this.perfil);
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
		perfil = new  Perfil();
		  		  
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
		perfil = new  Perfil();
		  		  
        try {
			
			perfil=perfilDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.perfil,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PerfilConstantesFunciones.refrescarForeignKeysDescripcionesPerfil(this.perfil);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		perfil = new  Perfil();
		  		  
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
		perfil = new  Perfil();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Perfil.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =perfilDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		perfil = new  Perfil();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=perfilDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		perfil = new  Perfil();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Perfil.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =perfilDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		perfil = new  Perfil();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=perfilDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		perfil = new  Perfil();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Perfil.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =perfilDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		perfil = new  Perfil();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=perfilDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		perfils = new  ArrayList<Perfil>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Perfil.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PerfilLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfils=perfilDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPerfil(perfils);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilConstantesFunciones.refrescarForeignKeysDescripcionesPerfil(this.perfils);
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
		perfils = new  ArrayList<Perfil>();
		  		  
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
		perfils = new  ArrayList<Perfil>();
		  		  
        try {			
			PerfilLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfils=perfilDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPerfil(perfils);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilConstantesFunciones.refrescarForeignKeysDescripcionesPerfil(this.perfils);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		perfils = new  ArrayList<Perfil>();
		  		  
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
		perfils = new  ArrayList<Perfil>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Perfil.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PerfilLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfils=perfilDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPerfil(perfils);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilConstantesFunciones.refrescarForeignKeysDescripcionesPerfil(this.perfils);
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
		perfils = new  ArrayList<Perfil>();
		  		  
        try {
			PerfilLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfils=perfilDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPerfil(perfils);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilConstantesFunciones.refrescarForeignKeysDescripcionesPerfil(this.perfils);
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
		perfils = new  ArrayList<Perfil>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Perfil.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PerfilLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfils=perfilDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPerfil(perfils);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilConstantesFunciones.refrescarForeignKeysDescripcionesPerfil(this.perfils);
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
		perfils = new  ArrayList<Perfil>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PerfilLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfils=perfilDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPerfil(perfils);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilConstantesFunciones.refrescarForeignKeysDescripcionesPerfil(this.perfils);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		perfil = new  Perfil();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Perfil.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PerfilLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfil=perfilDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPerfil(perfil);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilConstantesFunciones.refrescarForeignKeysDescripcionesPerfil(this.perfil);
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
		perfil = new  Perfil();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PerfilLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfil=perfilDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPerfil(perfil);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilConstantesFunciones.refrescarForeignKeysDescripcionesPerfil(this.perfil);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		perfils = new  ArrayList<Perfil>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Perfil.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			PerfilLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfils=perfilDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPerfil(perfils);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilConstantesFunciones.refrescarForeignKeysDescripcionesPerfil(this.perfils);
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
		perfils = new  ArrayList<Perfil>();
		  		  
        try {
			PerfilLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfils=perfilDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPerfil(perfils);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilConstantesFunciones.refrescarForeignKeysDescripcionesPerfil(this.perfils);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosPerfilsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		perfils = new  ArrayList<Perfil>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Perfil.class.getSimpleName()+"-getTodosPerfilsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PerfilLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfils=perfilDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPerfil(perfils);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilConstantesFunciones.refrescarForeignKeysDescripcionesPerfil(this.perfils);
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
	
	public  void  getTodosPerfils(String sFinalQuery,Pagination pagination)throws Exception {
		perfils = new  ArrayList<Perfil>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PerfilLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			perfils=perfilDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPerfil(perfils);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PerfilConstantesFunciones.refrescarForeignKeysDescripcionesPerfil(this.perfils);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPerfil(Perfil perfil) throws Exception {
		Boolean estaValidado=false;
		
		if(perfil.getIsNew() || perfil.getIsChanged()) { 
			this.invalidValues = perfilValidator.getInvalidValues(perfil);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(perfil);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPerfil(List<Perfil> Perfils) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Perfil perfilLocal:perfils) {				
			estaValidadoObjeto=this.validarGuardarPerfil(perfilLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPerfil(List<Perfil> Perfils) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPerfil(perfils)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPerfil(Perfil Perfil) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPerfil(perfil)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Perfil perfil) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+perfil.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PerfilConstantesFunciones.getPerfilLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"perfil","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PerfilConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PerfilConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePerfilWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Perfil.class.getSimpleName()+"-savePerfilWithConnection");connexion.begin();			
			
			PerfilLogicAdditional.checkPerfilToSave(this.perfil,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PerfilLogicAdditional.updatePerfilToSave(this.perfil,this.arrDatoGeneral);
			
			PerfilLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.perfil,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPerfil();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPerfil(this.perfil)) {
				PerfilDataAccess.save(this.perfil, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.perfil,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PerfilLogicAdditional.checkPerfilToSaveAfter(this.perfil,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPerfil();
			
			connexion.commit();			
			
			if(this.perfil.getIsDeleted()) {
				this.perfil=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePerfil()throws Exception {	
		try {	
			
			PerfilLogicAdditional.checkPerfilToSave(this.perfil,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PerfilLogicAdditional.updatePerfilToSave(this.perfil,this.arrDatoGeneral);
			
			PerfilLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.perfil,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPerfil(this.perfil)) {			
				PerfilDataAccess.save(this.perfil, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.perfil,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PerfilLogicAdditional.checkPerfilToSaveAfter(this.perfil,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.perfil.getIsDeleted()) {
				this.perfil=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePerfilsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Perfil.class.getSimpleName()+"-savePerfilsWithConnection");connexion.begin();			
			
			PerfilLogicAdditional.checkPerfilToSaves(perfils,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPerfils();
			
			Boolean validadoTodosPerfil=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Perfil perfilLocal:perfils) {		
				if(perfilLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PerfilLogicAdditional.updatePerfilToSave(perfilLocal,this.arrDatoGeneral);
	        	
				PerfilLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),perfilLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPerfil(perfilLocal)) {
					PerfilDataAccess.save(perfilLocal, connexion);				
				} else {
					validadoTodosPerfil=false;
				}
			}
			
			if(!validadoTodosPerfil) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PerfilLogicAdditional.checkPerfilToSavesAfter(perfils,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPerfils();
			
			connexion.commit();		
			
			this.quitarPerfilsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePerfils()throws Exception {				
		 try {	
			PerfilLogicAdditional.checkPerfilToSaves(perfils,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPerfil=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Perfil perfilLocal:perfils) {				
				if(perfilLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PerfilLogicAdditional.updatePerfilToSave(perfilLocal,this.arrDatoGeneral);
	        	
				PerfilLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),perfilLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPerfil(perfilLocal)) {				
					PerfilDataAccess.save(perfilLocal, connexion);				
				} else {
					validadoTodosPerfil=false;
				}
			}
			
			if(!validadoTodosPerfil) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PerfilLogicAdditional.checkPerfilToSavesAfter(perfils,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPerfilsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PerfilParameterReturnGeneral procesarAccionPerfils(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Perfil> perfils,PerfilParameterReturnGeneral perfilParameterGeneral)throws Exception {
		 try {	
			PerfilParameterReturnGeneral perfilReturnGeneral=new PerfilParameterReturnGeneral();
	
			PerfilLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,perfils,perfilParameterGeneral,perfilReturnGeneral);
			
			return perfilReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PerfilParameterReturnGeneral procesarAccionPerfilsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Perfil> perfils,PerfilParameterReturnGeneral perfilParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Perfil.class.getSimpleName()+"-procesarAccionPerfilsWithConnection");connexion.begin();			
			
			PerfilParameterReturnGeneral perfilReturnGeneral=new PerfilParameterReturnGeneral();
	
			PerfilLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,perfils,perfilParameterGeneral,perfilReturnGeneral);
			
			this.connexion.commit();
			
			return perfilReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PerfilParameterReturnGeneral procesarEventosPerfils(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Perfil> perfils,Perfil perfil,PerfilParameterReturnGeneral perfilParameterGeneral,Boolean isEsNuevoPerfil,ArrayList<Classe> clases)throws Exception {
		 try {	
			PerfilParameterReturnGeneral perfilReturnGeneral=new PerfilParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				perfilReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PerfilLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,perfils,perfil,perfilParameterGeneral,perfilReturnGeneral,isEsNuevoPerfil,clases);
			
			return perfilReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PerfilParameterReturnGeneral procesarEventosPerfilsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Perfil> perfils,Perfil perfil,PerfilParameterReturnGeneral perfilParameterGeneral,Boolean isEsNuevoPerfil,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Perfil.class.getSimpleName()+"-procesarEventosPerfilsWithConnection");connexion.begin();			
			
			PerfilParameterReturnGeneral perfilReturnGeneral=new PerfilParameterReturnGeneral();
	
			perfilReturnGeneral.setPerfil(perfil);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				perfilReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PerfilLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,perfils,perfil,perfilParameterGeneral,perfilReturnGeneral,isEsNuevoPerfil,clases);
			
			this.connexion.commit();
			
			return perfilReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PerfilParameterReturnGeneral procesarImportacionPerfilsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PerfilParameterReturnGeneral perfilParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Perfil.class.getSimpleName()+"-procesarImportacionPerfilsWithConnection");connexion.begin();			
			
			PerfilParameterReturnGeneral perfilReturnGeneral=new PerfilParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.perfils=new ArrayList<Perfil>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.perfil=new Perfil();
				
				
				if(conColumnasBase) {this.perfil.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.perfil.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.perfil.setcodigo(arrColumnas[iColumn++]);
				this.perfil.setnombre(arrColumnas[iColumn++]);
			this.perfil.setnombre2(arrColumnas[iColumn++]);
				this.perfil.setestado(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.perfils.add(this.perfil);
			}
			
			this.savePerfils();
			
			this.connexion.commit();
			
			perfilReturnGeneral.setConRetornoEstaProcesado(true);
			perfilReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return perfilReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPerfilsEliminados() throws Exception {				
		
		List<Perfil> perfilsAux= new ArrayList<Perfil>();
		
		for(Perfil perfil:perfils) {
			if(!perfil.getIsDeleted()) {
				perfilsAux.add(perfil);
			}
		}
		
		perfils=perfilsAux;
	}
	
	public void quitarPerfilsNulos() throws Exception {				
		
		List<Perfil> perfilsAux= new ArrayList<Perfil>();
		
		for(Perfil perfil : this.perfils) {
			if(perfil==null) {
				perfilsAux.add(perfil);
			}
		}
		
		//this.perfils=perfilsAux;
		
		this.perfils.removeAll(perfilsAux);
	}
	
	public void getSetVersionRowPerfilWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(perfil.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((perfil.getIsDeleted() || (perfil.getIsChanged()&&!perfil.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=perfilDataAccess.getSetVersionRowPerfil(connexion,perfil.getId());
				
				if(!perfil.getVersionRow().equals(timestamp)) {	
					perfil.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				perfil.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPerfil()throws Exception {	
		
		if(perfil.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((perfil.getIsDeleted() || (perfil.getIsChanged()&&!perfil.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=perfilDataAccess.getSetVersionRowPerfil(connexion,perfil.getId());
			
			try {							
				if(!perfil.getVersionRow().equals(timestamp)) {	
					perfil.setVersionRow(timestamp);
				}
				
				perfil.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPerfilsWithConnection()throws Exception {	
		if(perfils!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Perfil perfilAux:perfils) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(perfilAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(perfilAux.getIsDeleted() || (perfilAux.getIsChanged()&&!perfilAux.getIsNew())) {
						
						timestamp=perfilDataAccess.getSetVersionRowPerfil(connexion,perfilAux.getId());
						
						if(!perfil.getVersionRow().equals(timestamp)) {	
							perfilAux.setVersionRow(timestamp);
						}
								
						perfilAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPerfils()throws Exception {	
		if(perfils!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Perfil perfilAux:perfils) {
					if(perfilAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(perfilAux.getIsDeleted() || (perfilAux.getIsChanged()&&!perfilAux.getIsNew())) {
						
						timestamp=perfilDataAccess.getSetVersionRowPerfil(connexion,perfilAux.getId());
						
						if(!perfilAux.getVersionRow().equals(timestamp)) {	
							perfilAux.setVersionRow(timestamp);
						}
						
													
						perfilAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PerfilParameterReturnGeneral cargarCombosLoteForeignKeyPerfilWithConnection(String finalQueryGlobalSistema) throws Exception {
		PerfilParameterReturnGeneral  perfilReturnGeneral =new PerfilParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Perfil.class.getSimpleName()+"-cargarCombosLoteForeignKeyPerfilWithConnection");connexion.begin();
			
			perfilReturnGeneral =new PerfilParameterReturnGeneral();
			
			

			List<Sistema> sistemasForeignKey=new ArrayList<Sistema>();
			SistemaLogic sistemaLogic=new SistemaLogic();
			sistemaLogic.setConnexion(this.connexion);
			sistemaLogic.getSistemaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSistema.equals("NONE")) {
				sistemaLogic.getTodosSistemas(finalQueryGlobalSistema,new Pagination());
				sistemasForeignKey=sistemaLogic.getSistemas();
			}

			perfilReturnGeneral.setsistemasForeignKey(sistemasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return perfilReturnGeneral;
	}
	
	public PerfilParameterReturnGeneral cargarCombosLoteForeignKeyPerfil(String finalQueryGlobalSistema) throws Exception {
		PerfilParameterReturnGeneral  perfilReturnGeneral =new PerfilParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			perfilReturnGeneral =new PerfilParameterReturnGeneral();
			
			

			List<Sistema> sistemasForeignKey=new ArrayList<Sistema>();
			SistemaLogic sistemaLogic=new SistemaLogic();
			sistemaLogic.setConnexion(this.connexion);
			sistemaLogic.getSistemaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSistema.equals("NONE")) {
				sistemaLogic.getTodosSistemas(finalQueryGlobalSistema,new Pagination());
				sistemasForeignKey=sistemaLogic.getSistemas();
			}

			perfilReturnGeneral.setsistemasForeignKey(sistemasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return perfilReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyPerfilWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			PerfilOpcionLogic perfilopcionLogic=new PerfilOpcionLogic();
			PerfilUsuarioLogic perfilusuarioLogic=new PerfilUsuarioLogic();
			UsuarioOpcionLogic usuarioopcionLogic=new UsuarioOpcionLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Perfil.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyPerfilWithConnection");connexion.begin();
			
			
			classes.add(new Classe(PerfilOpcion.class));
			classes.add(new Classe(PerfilUsuario.class));
			classes.add(new Classe(UsuarioOpcion.class));
											
			

			perfilopcionLogic.setConnexion(this.getConnexion());
			perfilopcionLogic.setDatosCliente(this.datosCliente);
			perfilopcionLogic.setIsConRefrescarForeignKeys(true);

			perfilusuarioLogic.setConnexion(this.getConnexion());
			perfilusuarioLogic.setDatosCliente(this.datosCliente);
			perfilusuarioLogic.setIsConRefrescarForeignKeys(true);

			usuarioopcionLogic.setConnexion(this.getConnexion());
			usuarioopcionLogic.setDatosCliente(this.datosCliente);
			usuarioopcionLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Perfil perfil:this.perfils) {
				

				classes=new ArrayList<Classe>();
				classes=PerfilOpcionConstantesFunciones.getClassesForeignKeysOfPerfilOpcion(new ArrayList<Classe>(),DeepLoadType.NONE);

				perfilopcionLogic.setPerfilOpcions(perfil.perfilopcions);
				perfilopcionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PerfilUsuarioConstantesFunciones.getClassesForeignKeysOfPerfilUsuario(new ArrayList<Classe>(),DeepLoadType.NONE);

				perfilusuarioLogic.setPerfilUsuarios(perfil.perfilusuarios);
				perfilusuarioLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=UsuarioOpcionConstantesFunciones.getClassesForeignKeysOfUsuarioOpcion(new ArrayList<Classe>(),DeepLoadType.NONE);

				usuarioopcionLogic.setUsuarioOpcions(perfil.usuarioopcions);
				usuarioopcionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Perfil perfil,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PerfilLogicAdditional.updatePerfilToGet(perfil,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		perfil.setSistema(perfilDataAccess.getSistema(connexion,perfil));
		perfil.setUsuarioOpcions(perfilDataAccess.getUsuarioOpcions(connexion,perfil));
		perfil.setUsuarios(perfilDataAccess.getUsuarios(connexion,perfil));
		perfil.setPerfilUsuarios(perfilDataAccess.getPerfilUsuarios(connexion,perfil));
		perfil.setPerfilOpcions(perfilDataAccess.getPerfilOpcions(connexion,perfil));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Sistema.class)) {
				perfil.setSistema(perfilDataAccess.getSistema(connexion,perfil));
				continue;
			}

			if(clas.clas.equals(UsuarioOpcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				perfil.setUsuarioOpcions(perfilDataAccess.getUsuarioOpcions(connexion,perfil));

				if(this.isConDeep) {
					UsuarioOpcionLogic usuarioopcionLogic= new UsuarioOpcionLogic(this.connexion);
					usuarioopcionLogic.setUsuarioOpcions(perfil.getUsuarioOpcions());
					ArrayList<Classe> classesLocal=UsuarioOpcionConstantesFunciones.getClassesForeignKeysOfUsuarioOpcion(new ArrayList<Classe>(),DeepLoadType.NONE);
					usuarioopcionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					UsuarioOpcionConstantesFunciones.refrescarForeignKeysDescripcionesUsuarioOpcion(usuarioopcionLogic.getUsuarioOpcions());
					perfil.setUsuarioOpcions(usuarioopcionLogic.getUsuarioOpcions());
				}

				continue;
			}

			if(clas.clas.equals(Usuario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				perfil.setUsuarios(perfilDataAccess.getUsuarios(connexion,perfil));

				if(this.isConDeep) {
					UsuarioLogic usuarioLogic= new UsuarioLogic(this.connexion);
					usuarioLogic.setUsuarios(perfil.getUsuarios());
					ArrayList<Classe> classesLocal=UsuarioConstantesFunciones.getClassesForeignKeysOfUsuario(new ArrayList<Classe>(),DeepLoadType.NONE);
					usuarioLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					UsuarioConstantesFunciones.refrescarForeignKeysDescripcionesUsuario(usuarioLogic.getUsuarios());
					perfil.setUsuarios(usuarioLogic.getUsuarios());
				}

				continue;
			}

			if(clas.clas.equals(PerfilUsuario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				perfil.setPerfilUsuarios(perfilDataAccess.getPerfilUsuarios(connexion,perfil));

				if(this.isConDeep) {
					PerfilUsuarioLogic perfilusuarioLogic= new PerfilUsuarioLogic(this.connexion);
					perfilusuarioLogic.setPerfilUsuarios(perfil.getPerfilUsuarios());
					ArrayList<Classe> classesLocal=PerfilUsuarioConstantesFunciones.getClassesForeignKeysOfPerfilUsuario(new ArrayList<Classe>(),DeepLoadType.NONE);
					perfilusuarioLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PerfilUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesPerfilUsuario(perfilusuarioLogic.getPerfilUsuarios());
					perfil.setPerfilUsuarios(perfilusuarioLogic.getPerfilUsuarios());
				}

				continue;
			}

			if(clas.clas.equals(PerfilOpcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				perfil.setPerfilOpcions(perfilDataAccess.getPerfilOpcions(connexion,perfil));

				if(this.isConDeep) {
					PerfilOpcionLogic perfilopcionLogic= new PerfilOpcionLogic(this.connexion);
					perfilopcionLogic.setPerfilOpcions(perfil.getPerfilOpcions());
					ArrayList<Classe> classesLocal=PerfilOpcionConstantesFunciones.getClassesForeignKeysOfPerfilOpcion(new ArrayList<Classe>(),DeepLoadType.NONE);
					perfilopcionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PerfilOpcionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilOpcion(perfilopcionLogic.getPerfilOpcions());
					perfil.setPerfilOpcions(perfilopcionLogic.getPerfilOpcions());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sistema.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			perfil.setSistema(perfilDataAccess.getSistema(connexion,perfil));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(UsuarioOpcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(UsuarioOpcion.class));
			perfil.setUsuarioOpcions(perfilDataAccess.getUsuarioOpcions(connexion,perfil));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Usuario.class));
			perfil.setUsuarios(perfilDataAccess.getUsuarios(connexion,perfil));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PerfilUsuario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PerfilUsuario.class));
			perfil.setPerfilUsuarios(perfilDataAccess.getPerfilUsuarios(connexion,perfil));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PerfilOpcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PerfilOpcion.class));
			perfil.setPerfilOpcions(perfilDataAccess.getPerfilOpcions(connexion,perfil));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		perfil.setSistema(perfilDataAccess.getSistema(connexion,perfil));
		SistemaLogic sistemaLogic= new SistemaLogic(connexion);
		sistemaLogic.deepLoad(perfil.getSistema(),isDeep,deepLoadType,clases);
				

		perfil.setUsuarioOpcions(perfilDataAccess.getUsuarioOpcions(connexion,perfil));

		for(UsuarioOpcion usuarioopcion:perfil.getUsuarioOpcions()) {
			UsuarioOpcionLogic usuarioopcionLogic= new UsuarioOpcionLogic(connexion);
			usuarioopcionLogic.deepLoad(usuarioopcion,isDeep,deepLoadType,clases);
		}

		perfil.setUsuarios(perfilDataAccess.getUsuarios(connexion,perfil));

		for(Usuario usuario:perfil.getUsuarios()) {
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(usuario,isDeep,deepLoadType,clases);
		}

		perfil.setPerfilUsuarios(perfilDataAccess.getPerfilUsuarios(connexion,perfil));

		for(PerfilUsuario perfilusuario:perfil.getPerfilUsuarios()) {
			PerfilUsuarioLogic perfilusuarioLogic= new PerfilUsuarioLogic(connexion);
			perfilusuarioLogic.deepLoad(perfilusuario,isDeep,deepLoadType,clases);
		}

		perfil.setPerfilOpcions(perfilDataAccess.getPerfilOpcions(connexion,perfil));

		for(PerfilOpcion perfilopcion:perfil.getPerfilOpcions()) {
			PerfilOpcionLogic perfilopcionLogic= new PerfilOpcionLogic(connexion);
			perfilopcionLogic.deepLoad(perfilopcion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Sistema.class)) {
				perfil.setSistema(perfilDataAccess.getSistema(connexion,perfil));
				SistemaLogic sistemaLogic= new SistemaLogic(connexion);
				sistemaLogic.deepLoad(perfil.getSistema(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(UsuarioOpcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				perfil.setUsuarioOpcions(perfilDataAccess.getUsuarioOpcions(connexion,perfil));

				for(UsuarioOpcion usuarioopcion:perfil.getUsuarioOpcions()) {
					UsuarioOpcionLogic usuarioopcionLogic= new UsuarioOpcionLogic(connexion);
					usuarioopcionLogic.deepLoad(usuarioopcion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Usuario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				perfil.setUsuarios(perfilDataAccess.getUsuarios(connexion,perfil));

				for(Usuario usuario:perfil.getUsuarios()) {
					UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
					usuarioLogic.deepLoad(usuario,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PerfilUsuario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				perfil.setPerfilUsuarios(perfilDataAccess.getPerfilUsuarios(connexion,perfil));

				for(PerfilUsuario perfilusuario:perfil.getPerfilUsuarios()) {
					PerfilUsuarioLogic perfilusuarioLogic= new PerfilUsuarioLogic(connexion);
					perfilusuarioLogic.deepLoad(perfilusuario,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PerfilOpcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				perfil.setPerfilOpcions(perfilDataAccess.getPerfilOpcions(connexion,perfil));

				for(PerfilOpcion perfilopcion:perfil.getPerfilOpcions()) {
					PerfilOpcionLogic perfilopcionLogic= new PerfilOpcionLogic(connexion);
					perfilopcionLogic.deepLoad(perfilopcion,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sistema.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			perfil.setSistema(perfilDataAccess.getSistema(connexion,perfil));
			SistemaLogic sistemaLogic= new SistemaLogic(connexion);
			sistemaLogic.deepLoad(perfil.getSistema(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(UsuarioOpcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(UsuarioOpcion.class));
			perfil.setUsuarioOpcions(perfilDataAccess.getUsuarioOpcions(connexion,perfil));

			for(UsuarioOpcion usuarioopcion:perfil.getUsuarioOpcions()) {
				UsuarioOpcionLogic usuarioopcionLogic= new UsuarioOpcionLogic(connexion);
				usuarioopcionLogic.deepLoad(usuarioopcion,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Usuario.class));
			perfil.setUsuarios(perfilDataAccess.getUsuarios(connexion,perfil));

			for(Usuario usuario:perfil.getUsuarios()) {
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(usuario,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PerfilUsuario.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PerfilUsuario.class));
			perfil.setPerfilUsuarios(perfilDataAccess.getPerfilUsuarios(connexion,perfil));

			for(PerfilUsuario perfilusuario:perfil.getPerfilUsuarios()) {
				PerfilUsuarioLogic perfilusuarioLogic= new PerfilUsuarioLogic(connexion);
				perfilusuarioLogic.deepLoad(perfilusuario,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PerfilOpcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PerfilOpcion.class));
			perfil.setPerfilOpcions(perfilDataAccess.getPerfilOpcions(connexion,perfil));

			for(PerfilOpcion perfilopcion:perfil.getPerfilOpcions()) {
				PerfilOpcionLogic perfilopcionLogic= new PerfilOpcionLogic(connexion);
				perfilopcionLogic.deepLoad(perfilopcion,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Perfil perfil,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			PerfilLogicAdditional.updatePerfilToSave(perfil,this.arrDatoGeneral);
			
PerfilDataAccess.save(perfil, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		SistemaDataAccess.save(perfil.getSistema(),connexion);

		for(UsuarioOpcion usuarioopcion:perfil.getUsuarioOpcions()) {
			usuarioopcion.setid_perfil(perfil.getId());
			UsuarioOpcionDataAccess.save(usuarioopcion,connexion);
		}

		for(Usuario usuario:perfil.getUsuarios()) {
			UsuarioDataAccess.save(usuario,connexion);
		}

		for(PerfilUsuario perfilusuario:perfil.getPerfilUsuarios()) {
			perfilusuario.setid_perfil(perfil.getId());
			PerfilUsuarioDataAccess.save(perfilusuario,connexion);
		}

		for(PerfilOpcion perfilopcion:perfil.getPerfilOpcions()) {
			perfilopcion.setid_perfil(perfil.getId());
			PerfilOpcionDataAccess.save(perfilopcion,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Sistema.class)) {
				SistemaDataAccess.save(perfil.getSistema(),connexion);
				continue;
			}


			if(clas.clas.equals(UsuarioOpcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(UsuarioOpcion usuarioopcion:perfil.getUsuarioOpcions()) {
					usuarioopcion.setid_perfil(perfil.getId());
					UsuarioOpcionDataAccess.save(usuarioopcion,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Usuario.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Usuario usuario:perfil.getUsuarios()) {
					UsuarioDataAccess.save(usuario,connexion);
				}
				continue;
			}

			if(clas.clas.equals(PerfilUsuario.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PerfilUsuario perfilusuario:perfil.getPerfilUsuarios()) {
					perfilusuario.setid_perfil(perfil.getId());
					PerfilUsuarioDataAccess.save(perfilusuario,connexion);
				}
				continue;
			}

			if(clas.clas.equals(PerfilOpcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PerfilOpcion perfilopcion:perfil.getPerfilOpcions()) {
					perfilopcion.setid_perfil(perfil.getId());
					PerfilOpcionDataAccess.save(perfilopcion,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		SistemaDataAccess.save(perfil.getSistema(),connexion);
		SistemaLogic sistemaLogic= new SistemaLogic(connexion);
		sistemaLogic.deepLoad(perfil.getSistema(),isDeep,deepLoadType,clases);
				

		for(UsuarioOpcion usuarioopcion:perfil.getUsuarioOpcions()) {
			UsuarioOpcionLogic usuarioopcionLogic= new UsuarioOpcionLogic(connexion);
			usuarioopcion.setid_perfil(perfil.getId());
			UsuarioOpcionDataAccess.save(usuarioopcion,connexion);
			usuarioopcionLogic.deepSave(usuarioopcion,isDeep,deepLoadType,clases);
		}

		for(Usuario usuario:perfil.getUsuarios()) {
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			UsuarioDataAccess.save(usuario,connexion);
			usuarioLogic.deepSave(usuario,isDeep,deepLoadType,clases);
		}

		for(PerfilUsuario perfilusuario:perfil.getPerfilUsuarios()) {
			PerfilUsuarioLogic perfilusuarioLogic= new PerfilUsuarioLogic(connexion);
			perfilusuario.setid_perfil(perfil.getId());
			PerfilUsuarioDataAccess.save(perfilusuario,connexion);
			perfilusuarioLogic.deepSave(perfilusuario,isDeep,deepLoadType,clases);
		}

		for(PerfilOpcion perfilopcion:perfil.getPerfilOpcions()) {
			PerfilOpcionLogic perfilopcionLogic= new PerfilOpcionLogic(connexion);
			perfilopcion.setid_perfil(perfil.getId());
			PerfilOpcionDataAccess.save(perfilopcion,connexion);
			perfilopcionLogic.deepSave(perfilopcion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Sistema.class)) {
				SistemaDataAccess.save(perfil.getSistema(),connexion);
				SistemaLogic sistemaLogic= new SistemaLogic(connexion);
				sistemaLogic.deepSave(perfil.getSistema(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(UsuarioOpcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(UsuarioOpcion usuarioopcion:perfil.getUsuarioOpcions()) {
					UsuarioOpcionLogic usuarioopcionLogic= new UsuarioOpcionLogic(connexion);
					usuarioopcion.setid_perfil(perfil.getId());
					UsuarioOpcionDataAccess.save(usuarioopcion,connexion);
					usuarioopcionLogic.deepSave(usuarioopcion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Usuario.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Usuario usuario:perfil.getUsuarios()) {
					UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
					UsuarioDataAccess.save(usuario,connexion);
					usuarioLogic.deepSave(usuario,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PerfilUsuario.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PerfilUsuario perfilusuario:perfil.getPerfilUsuarios()) {
					PerfilUsuarioLogic perfilusuarioLogic= new PerfilUsuarioLogic(connexion);
					perfilusuario.setid_perfil(perfil.getId());
					PerfilUsuarioDataAccess.save(perfilusuario,connexion);
					perfilusuarioLogic.deepSave(perfilusuario,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PerfilOpcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PerfilOpcion perfilopcion:perfil.getPerfilOpcions()) {
					PerfilOpcionLogic perfilopcionLogic= new PerfilOpcionLogic(connexion);
					perfilopcion.setid_perfil(perfil.getId());
					PerfilOpcionDataAccess.save(perfilopcion,connexion);
					perfilopcionLogic.deepSave(perfilopcion,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Perfil.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(perfil,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PerfilConstantesFunciones.refrescarForeignKeysDescripcionesPerfil(perfil);
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
			this.deepLoad(this.perfil,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PerfilConstantesFunciones.refrescarForeignKeysDescripcionesPerfil(this.perfil);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Perfil.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(perfils!=null) {
				for(Perfil perfil:perfils) {
					this.deepLoad(perfil,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PerfilConstantesFunciones.refrescarForeignKeysDescripcionesPerfil(perfils);
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
			if(perfils!=null) {
				for(Perfil perfil:perfils) {
					this.deepLoad(perfil,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PerfilConstantesFunciones.refrescarForeignKeysDescripcionesPerfil(perfils);
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
			this.getNewConnexionToDeep(Perfil.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(perfil,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Perfil.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(perfils!=null) {
				for(Perfil perfil:perfils) {
					this.deepSave(perfil,isDeep,deepLoadType,clases);
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
			if(perfils!=null) {
				for(Perfil perfil:perfils) {
					this.deepSave(perfil,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getPerfilsBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Perfil.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",PerfilConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			PerfilLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			perfils=perfilDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PerfilConstantesFunciones.refrescarForeignKeysDescripcionesPerfil(this.perfils);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPerfilsBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",PerfilConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			PerfilLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			perfils=perfilDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PerfilConstantesFunciones.refrescarForeignKeysDescripcionesPerfil(this.perfils);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPerfilsBusquedaPorNombre2WithConnection(String sFinalQuery,Pagination pagination,String nombre2)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Perfil.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre2= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre2.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre2+"%",PerfilConstantesFunciones.NOMBRE2,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre2);

			PerfilLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre2","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			perfils=perfilDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PerfilConstantesFunciones.refrescarForeignKeysDescripcionesPerfil(this.perfils);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPerfilsBusquedaPorNombre2(String sFinalQuery,Pagination pagination,String nombre2)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre2= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre2.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre2+"%",PerfilConstantesFunciones.NOMBRE2,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre2);

			PerfilLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre2","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			perfils=perfilDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PerfilConstantesFunciones.refrescarForeignKeysDescripcionesPerfil(this.perfils);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPerfilsFK_IdSistemaWithConnection(String sFinalQuery,Pagination pagination,Long id_sistema)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Perfil.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSistema= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSistema.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sistema,PerfilConstantesFunciones.IDSISTEMA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSistema);

			PerfilLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSistema","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			perfils=perfilDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PerfilConstantesFunciones.refrescarForeignKeysDescripcionesPerfil(this.perfils);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPerfilsFK_IdSistema(String sFinalQuery,Pagination pagination,Long id_sistema)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSistema= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSistema.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sistema,PerfilConstantesFunciones.IDSISTEMA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSistema);

			PerfilLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSistema","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			perfils=perfilDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PerfilConstantesFunciones.refrescarForeignKeysDescripcionesPerfil(this.perfils);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPerfilPorIdSistemaPorNombreWithConnection(Long id_sistema,String nombre)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Perfil.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidSistema= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSistema.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sistema,PerfilConstantesFunciones.IDSISTEMA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSistema);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,PerfilConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			perfil=perfilDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.perfil,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				PerfilConstantesFunciones.refrescarForeignKeysDescripcionesPerfil(this.perfil);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPerfilPorIdSistemaPorNombre(Long id_sistema,String nombre)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidSistema= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSistema.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sistema,PerfilConstantesFunciones.IDSISTEMA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSistema);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,PerfilConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			perfil=perfilDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.perfil,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				PerfilConstantesFunciones.refrescarForeignKeysDescripcionesPerfil(this.perfil);
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
			if(PerfilConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				//auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PerfilDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Perfil perfil,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		//AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		//auditoriaLogicAdditional.setConnexion(connexion);
		//AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PerfilConstantesFunciones.ISCONAUDITORIA) {
				if(perfil.getIsNew()) {
					//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PerfilDataAccess.TABLENAME, perfil.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PerfilConstantesFunciones.ISCONAUDITORIADETALLE) {
						//PerfilLogic.registrarAuditoriaDetallesPerfil(connexion,perfil,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(perfil.getIsDeleted()) {
					/*if(!perfil.getIsExpired()) {
						//auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PerfilDataAccess.TABLENAME, perfil.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						//PerfilLogic.registrarAuditoriaDetallesPerfil(connexion,perfil,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PerfilDataAccess.TABLENAME, perfil.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(perfil.getIsChanged()) {
					//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PerfilDataAccess.TABLENAME, perfil.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PerfilConstantesFunciones.ISCONAUDITORIADETALLE) {
						//PerfilLogic.registrarAuditoriaDetallesPerfil(connexion,perfil,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPerfil(Connexion connexion,Perfil perfil)throws Exception {		
		//AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		//auditoriaDetalleLogicAdditional.setConnexion(connexion);
		//AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(perfil.getIsNew()||!perfil.getid_sistema().equals(perfil.getPerfilOriginal().getid_sistema()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(perfil.getPerfilOriginal().getid_sistema()!=null)
				{
					strValorActual=perfil.getPerfilOriginal().getid_sistema().toString();
				}
				if(perfil.getid_sistema()!=null)
				{
					strValorNuevo=perfil.getid_sistema().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PerfilConstantesFunciones.IDSISTEMA,strValorActual,strValorNuevo);
			}	
			
			if(perfil.getIsNew()||!perfil.getcodigo().equals(perfil.getPerfilOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(perfil.getPerfilOriginal().getcodigo()!=null)
				{
					strValorActual=perfil.getPerfilOriginal().getcodigo();
				}
				if(perfil.getcodigo()!=null)
				{
					strValorNuevo=perfil.getcodigo() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PerfilConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(perfil.getIsNew()||!perfil.getnombre().equals(perfil.getPerfilOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(perfil.getPerfilOriginal().getnombre()!=null)
				{
					strValorActual=perfil.getPerfilOriginal().getnombre();
				}
				if(perfil.getnombre()!=null)
				{
					strValorNuevo=perfil.getnombre() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PerfilConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(perfil.getIsNew()||!perfil.getnombre2().equals(perfil.getPerfilOriginal().getnombre2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(perfil.getPerfilOriginal().getnombre2()!=null)
				{
					strValorActual=perfil.getPerfilOriginal().getnombre2();
				}
				if(perfil.getnombre2()!=null)
				{
					strValorNuevo=perfil.getnombre2() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PerfilConstantesFunciones.NOMBRE2,strValorActual,strValorNuevo);
			}	
			
			if(perfil.getIsNew()||!perfil.getestado().equals(perfil.getPerfilOriginal().getestado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(perfil.getPerfilOriginal().getestado()!=null)
				{
					strValorActual=perfil.getPerfilOriginal().getestado().toString();
				}
				if(perfil.getestado()!=null)
				{
					strValorNuevo=perfil.getestado().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PerfilConstantesFunciones.ESTADO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void savePerfilRelacionesWithConnection(Perfil perfil,List<UsuarioOpcion> usuarioopcions,List<PerfilUsuario> perfilusuarios,List<PerfilOpcion> perfilopcions) throws Exception {

		if(!perfil.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePerfilRelacionesBase(perfil,usuarioopcions,perfilusuarios,perfilopcions,true);
		}
	}

	public void savePerfilRelaciones(Perfil perfil,List<UsuarioOpcion> usuarioopcions,List<PerfilUsuario> perfilusuarios,List<PerfilOpcion> perfilopcions)throws Exception {

		if(!perfil.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePerfilRelacionesBase(perfil,usuarioopcions,perfilusuarios,perfilopcions,false);
		}
	}

	public void savePerfilRelacionesBase(Perfil perfil,List<UsuarioOpcion> usuarioopcions,List<PerfilUsuario> perfilusuarios,List<PerfilOpcion> perfilopcions,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Perfil-saveRelacionesWithConnection");}
	
			perfil.setUsuarioOpcions(usuarioopcions);
			perfil.setPerfilUsuarios(perfilusuarios);
			perfil.setPerfilOpcions(perfilopcions);

			this.setPerfil(perfil);

			if(PerfilLogicAdditional.validarSaveRelaciones(perfil,this)) {

				PerfilLogicAdditional.updateRelacionesToSave(perfil,this);

				if((perfil.getIsNew()||perfil.getIsChanged())&&!perfil.getIsDeleted()) {
					this.savePerfil();
					this.savePerfilRelacionesDetalles(usuarioopcions,perfilusuarios,perfilopcions);

				} else if(perfil.getIsDeleted()) {
					this.savePerfilRelacionesDetalles(usuarioopcions,perfilusuarios,perfilopcions);
					this.savePerfil();
				}

				PerfilLogicAdditional.updateRelacionesToSaveAfter(perfil,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			UsuarioOpcionConstantesFunciones.InicializarGeneralEntityAuxiliaresUsuarioOpcions(usuarioopcions,true,true);
			PerfilUsuarioConstantesFunciones.InicializarGeneralEntityAuxiliaresPerfilUsuarios(perfilusuarios,true,true);
			PerfilOpcionConstantesFunciones.InicializarGeneralEntityAuxiliaresPerfilOpcions(perfilopcions,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void savePerfilRelacionesDetalles(List<UsuarioOpcion> usuarioopcions,List<PerfilUsuario> perfilusuarios,List<PerfilOpcion> perfilopcions)throws Exception {
		try {
	

			Long idPerfilActual=this.getPerfil().getId();

			UsuarioOpcionLogic usuarioopcionLogic_Desde_Perfil=new UsuarioOpcionLogic();
			usuarioopcionLogic_Desde_Perfil.setUsuarioOpcions(usuarioopcions);

			usuarioopcionLogic_Desde_Perfil.setConnexion(this.getConnexion());
			usuarioopcionLogic_Desde_Perfil.setDatosCliente(this.datosCliente);

			for(UsuarioOpcion usuarioopcion_Desde_Perfil:usuarioopcionLogic_Desde_Perfil.getUsuarioOpcions()) {
				usuarioopcion_Desde_Perfil.setid_perfil(idPerfilActual);
			}

			usuarioopcionLogic_Desde_Perfil.saveUsuarioOpcions();

			PerfilUsuarioLogic perfilusuarioLogic_Desde_Perfil=new PerfilUsuarioLogic();
			perfilusuarioLogic_Desde_Perfil.setPerfilUsuarios(perfilusuarios);

			perfilusuarioLogic_Desde_Perfil.setConnexion(this.getConnexion());
			perfilusuarioLogic_Desde_Perfil.setDatosCliente(this.datosCliente);

			for(PerfilUsuario perfilusuario_Desde_Perfil:perfilusuarioLogic_Desde_Perfil.getPerfilUsuarios()) {
				perfilusuario_Desde_Perfil.setid_perfil(idPerfilActual);
			}

			perfilusuarioLogic_Desde_Perfil.savePerfilUsuarios();

			PerfilOpcionLogic perfilopcionLogic_Desde_Perfil=new PerfilOpcionLogic();
			perfilopcionLogic_Desde_Perfil.setPerfilOpcions(perfilopcions);

			perfilopcionLogic_Desde_Perfil.setConnexion(this.getConnexion());
			perfilopcionLogic_Desde_Perfil.setDatosCliente(this.datosCliente);

			for(PerfilOpcion perfilopcion_Desde_Perfil:perfilopcionLogic_Desde_Perfil.getPerfilOpcions()) {
				perfilopcion_Desde_Perfil.setid_perfil(idPerfilActual);
			}

			perfilopcionLogic_Desde_Perfil.savePerfilOpcions();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPerfil(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PerfilConstantesFunciones.getClassesForeignKeysOfPerfil(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPerfil(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PerfilConstantesFunciones.getClassesRelationshipsOfPerfil(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

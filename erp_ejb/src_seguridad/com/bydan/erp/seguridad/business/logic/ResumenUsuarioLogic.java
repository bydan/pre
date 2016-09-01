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
import com.bydan.erp.seguridad.util.ResumenUsuarioConstantesFunciones;
import com.bydan.erp.seguridad.util.ResumenUsuarioParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.ResumenUsuarioParameterGeneral;
import com.bydan.erp.seguridad.business.entity.ResumenUsuario;
import com.bydan.erp.seguridad.business.logic.ResumenUsuarioLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class ResumenUsuarioLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ResumenUsuarioLogic.class);
	
	protected ResumenUsuarioDataAccess resumenusuarioDataAccess; 	
	protected ResumenUsuario resumenusuario;
	protected List<ResumenUsuario> resumenusuarios;
	protected Object resumenusuarioObject;	
	protected List<Object> resumenusuariosObject;
	
	public static ClassValidator<ResumenUsuario> resumenusuarioValidator = new ClassValidator<ResumenUsuario>(ResumenUsuario.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ResumenUsuarioLogicAdditional resumenusuarioLogicAdditional=null;
	
	public ResumenUsuarioLogicAdditional getResumenUsuarioLogicAdditional() {
		return this.resumenusuarioLogicAdditional;
	}
	
	public void setResumenUsuarioLogicAdditional(ResumenUsuarioLogicAdditional resumenusuarioLogicAdditional) {
		try {
			this.resumenusuarioLogicAdditional=resumenusuarioLogicAdditional;
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
	
	
	
	
	public  ResumenUsuarioLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.resumenusuarioDataAccess = new ResumenUsuarioDataAccess();
			
			this.resumenusuarios= new ArrayList<ResumenUsuario>();
			this.resumenusuario= new ResumenUsuario();
			
			this.resumenusuarioObject=new Object();
			this.resumenusuariosObject=new ArrayList<Object>();
				
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
			
			this.resumenusuarioDataAccess.setConnexionType(this.connexionType);
			this.resumenusuarioDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ResumenUsuarioLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.resumenusuarioDataAccess = new ResumenUsuarioDataAccess();
			this.resumenusuarios= new ArrayList<ResumenUsuario>();
			this.resumenusuario= new ResumenUsuario();
			this.resumenusuarioObject=new Object();
			this.resumenusuariosObject=new ArrayList<Object>();
			
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
			
			this.resumenusuarioDataAccess.setConnexionType(this.connexionType);
			this.resumenusuarioDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ResumenUsuario getResumenUsuario() throws Exception {	
		ResumenUsuarioLogicAdditional.checkResumenUsuarioToGet(resumenusuario,this.datosCliente,this.arrDatoGeneral);
		ResumenUsuarioLogicAdditional.updateResumenUsuarioToGet(resumenusuario,this.arrDatoGeneral);
		
		return resumenusuario;
	}
		
	public void setResumenUsuario(ResumenUsuario newResumenUsuario) {
		this.resumenusuario = newResumenUsuario;
	}
	
	public ResumenUsuarioDataAccess getResumenUsuarioDataAccess() {
		return resumenusuarioDataAccess;
	}
	
	public void setResumenUsuarioDataAccess(ResumenUsuarioDataAccess newresumenusuarioDataAccess) {
		this.resumenusuarioDataAccess = newresumenusuarioDataAccess;
	}
	
	public List<ResumenUsuario> getResumenUsuarios() throws Exception {		
		this.quitarResumenUsuariosNulos();
		
		ResumenUsuarioLogicAdditional.checkResumenUsuarioToGets(resumenusuarios,this.datosCliente,this.arrDatoGeneral);
		
		for (ResumenUsuario resumenusuarioLocal: resumenusuarios ) {
			ResumenUsuarioLogicAdditional.updateResumenUsuarioToGet(resumenusuarioLocal,this.arrDatoGeneral);
		}
		
		return resumenusuarios;
	}
	
	public void setResumenUsuarios(List<ResumenUsuario> newResumenUsuarios) {
		this.resumenusuarios = newResumenUsuarios;
	}
	
	public Object getResumenUsuarioObject() {	
		this.resumenusuarioObject=this.resumenusuarioDataAccess.getEntityObject();
		return this.resumenusuarioObject;
	}
		
	public void setResumenUsuarioObject(Object newResumenUsuarioObject) {
		this.resumenusuarioObject = newResumenUsuarioObject;
	}
	
	public List<Object> getResumenUsuariosObject() {		
		this.resumenusuariosObject=this.resumenusuarioDataAccess.getEntitiesObject();
		return this.resumenusuariosObject;
	}
		
	public void setResumenUsuariosObject(List<Object> newResumenUsuariosObject) {
		this.resumenusuariosObject = newResumenUsuariosObject;
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
		
		if(this.resumenusuarioDataAccess!=null) {
			this.resumenusuarioDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResumenUsuario.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			resumenusuarioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			resumenusuarioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		resumenusuario = new  ResumenUsuario();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResumenUsuario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			resumenusuario=resumenusuarioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.resumenusuario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ResumenUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesResumenUsuario(this.resumenusuario);
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
		resumenusuario = new  ResumenUsuario();
		  		  
        try {
			
			resumenusuario=resumenusuarioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.resumenusuario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ResumenUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesResumenUsuario(this.resumenusuario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		resumenusuario = new  ResumenUsuario();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResumenUsuario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			resumenusuario=resumenusuarioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.resumenusuario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ResumenUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesResumenUsuario(this.resumenusuario);
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
		resumenusuario = new  ResumenUsuario();
		  		  
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
		resumenusuario = new  ResumenUsuario();
		  		  
        try {
			
			resumenusuario=resumenusuarioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.resumenusuario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ResumenUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesResumenUsuario(this.resumenusuario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		resumenusuario = new  ResumenUsuario();
		  		  
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
		resumenusuario = new  ResumenUsuario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResumenUsuario.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =resumenusuarioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		resumenusuario = new  ResumenUsuario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=resumenusuarioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		resumenusuario = new  ResumenUsuario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResumenUsuario.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =resumenusuarioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		resumenusuario = new  ResumenUsuario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=resumenusuarioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		resumenusuario = new  ResumenUsuario();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResumenUsuario.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =resumenusuarioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		resumenusuario = new  ResumenUsuario();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=resumenusuarioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		resumenusuarios = new  ArrayList<ResumenUsuario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResumenUsuario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ResumenUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			resumenusuarios=resumenusuarioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarResumenUsuario(resumenusuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResumenUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesResumenUsuario(this.resumenusuarios);
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
		resumenusuarios = new  ArrayList<ResumenUsuario>();
		  		  
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
		resumenusuarios = new  ArrayList<ResumenUsuario>();
		  		  
        try {			
			ResumenUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			resumenusuarios=resumenusuarioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarResumenUsuario(resumenusuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResumenUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesResumenUsuario(this.resumenusuarios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		resumenusuarios = new  ArrayList<ResumenUsuario>();
		  		  
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
		resumenusuarios = new  ArrayList<ResumenUsuario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResumenUsuario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ResumenUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			resumenusuarios=resumenusuarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarResumenUsuario(resumenusuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResumenUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesResumenUsuario(this.resumenusuarios);
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
		resumenusuarios = new  ArrayList<ResumenUsuario>();
		  		  
        try {
			ResumenUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			resumenusuarios=resumenusuarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarResumenUsuario(resumenusuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResumenUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesResumenUsuario(this.resumenusuarios);
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
		resumenusuarios = new  ArrayList<ResumenUsuario>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResumenUsuario.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ResumenUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			resumenusuarios=resumenusuarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarResumenUsuario(resumenusuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResumenUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesResumenUsuario(this.resumenusuarios);
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
		resumenusuarios = new  ArrayList<ResumenUsuario>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ResumenUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			resumenusuarios=resumenusuarioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarResumenUsuario(resumenusuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResumenUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesResumenUsuario(this.resumenusuarios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		resumenusuario = new  ResumenUsuario();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResumenUsuario.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ResumenUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			resumenusuario=resumenusuarioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarResumenUsuario(resumenusuario);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResumenUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesResumenUsuario(this.resumenusuario);
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
		resumenusuario = new  ResumenUsuario();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ResumenUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			resumenusuario=resumenusuarioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarResumenUsuario(resumenusuario);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResumenUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesResumenUsuario(this.resumenusuario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		resumenusuarios = new  ArrayList<ResumenUsuario>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResumenUsuario.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ResumenUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			resumenusuarios=resumenusuarioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarResumenUsuario(resumenusuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResumenUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesResumenUsuario(this.resumenusuarios);
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
		resumenusuarios = new  ArrayList<ResumenUsuario>();
		  		  
        try {
			ResumenUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			resumenusuarios=resumenusuarioDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarResumenUsuario(resumenusuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResumenUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesResumenUsuario(this.resumenusuarios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosResumenUsuariosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		resumenusuarios = new  ArrayList<ResumenUsuario>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResumenUsuario.class.getSimpleName()+"-getTodosResumenUsuariosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ResumenUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			resumenusuarios=resumenusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarResumenUsuario(resumenusuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResumenUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesResumenUsuario(this.resumenusuarios);
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
	
	public  void  getTodosResumenUsuarios(String sFinalQuery,Pagination pagination)throws Exception {
		resumenusuarios = new  ArrayList<ResumenUsuario>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ResumenUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			resumenusuarios=resumenusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarResumenUsuario(resumenusuarios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ResumenUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesResumenUsuario(this.resumenusuarios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarResumenUsuario(ResumenUsuario resumenusuario) throws Exception {
		Boolean estaValidado=false;
		
		if(resumenusuario.getIsNew() || resumenusuario.getIsChanged()) { 
			this.invalidValues = resumenusuarioValidator.getInvalidValues(resumenusuario);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(resumenusuario);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarResumenUsuario(List<ResumenUsuario> ResumenUsuarios) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ResumenUsuario resumenusuarioLocal:resumenusuarios) {				
			estaValidadoObjeto=this.validarGuardarResumenUsuario(resumenusuarioLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarResumenUsuario(List<ResumenUsuario> ResumenUsuarios) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarResumenUsuario(resumenusuarios)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarResumenUsuario(ResumenUsuario ResumenUsuario) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarResumenUsuario(resumenusuario)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ResumenUsuario resumenusuario) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+resumenusuario.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ResumenUsuarioConstantesFunciones.getResumenUsuarioLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"resumenusuario","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ResumenUsuarioConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ResumenUsuarioConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveResumenUsuarioWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResumenUsuario.class.getSimpleName()+"-saveResumenUsuarioWithConnection");connexion.begin();			
			
			ResumenUsuarioLogicAdditional.checkResumenUsuarioToSave(this.resumenusuario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ResumenUsuarioLogicAdditional.updateResumenUsuarioToSave(this.resumenusuario,this.arrDatoGeneral);
			
			ResumenUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.resumenusuario,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowResumenUsuario();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarResumenUsuario(this.resumenusuario)) {
				ResumenUsuarioDataAccess.save(this.resumenusuario, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.resumenusuario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ResumenUsuarioLogicAdditional.checkResumenUsuarioToSaveAfter(this.resumenusuario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowResumenUsuario();
			
			connexion.commit();			
			
			if(this.resumenusuario.getIsDeleted()) {
				this.resumenusuario=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveResumenUsuario()throws Exception {	
		try {	
			
			ResumenUsuarioLogicAdditional.checkResumenUsuarioToSave(this.resumenusuario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ResumenUsuarioLogicAdditional.updateResumenUsuarioToSave(this.resumenusuario,this.arrDatoGeneral);
			
			ResumenUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.resumenusuario,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarResumenUsuario(this.resumenusuario)) {			
				ResumenUsuarioDataAccess.save(this.resumenusuario, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.resumenusuario,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ResumenUsuarioLogicAdditional.checkResumenUsuarioToSaveAfter(this.resumenusuario,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.resumenusuario.getIsDeleted()) {
				this.resumenusuario=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveResumenUsuariosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResumenUsuario.class.getSimpleName()+"-saveResumenUsuariosWithConnection");connexion.begin();			
			
			ResumenUsuarioLogicAdditional.checkResumenUsuarioToSaves(resumenusuarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowResumenUsuarios();
			
			Boolean validadoTodosResumenUsuario=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ResumenUsuario resumenusuarioLocal:resumenusuarios) {		
				if(resumenusuarioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ResumenUsuarioLogicAdditional.updateResumenUsuarioToSave(resumenusuarioLocal,this.arrDatoGeneral);
	        	
				ResumenUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),resumenusuarioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarResumenUsuario(resumenusuarioLocal)) {
					ResumenUsuarioDataAccess.save(resumenusuarioLocal, connexion);				
				} else {
					validadoTodosResumenUsuario=false;
				}
			}
			
			if(!validadoTodosResumenUsuario) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ResumenUsuarioLogicAdditional.checkResumenUsuarioToSavesAfter(resumenusuarios,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowResumenUsuarios();
			
			connexion.commit();		
			
			this.quitarResumenUsuariosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveResumenUsuarios()throws Exception {				
		 try {	
			ResumenUsuarioLogicAdditional.checkResumenUsuarioToSaves(resumenusuarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosResumenUsuario=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ResumenUsuario resumenusuarioLocal:resumenusuarios) {				
				if(resumenusuarioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ResumenUsuarioLogicAdditional.updateResumenUsuarioToSave(resumenusuarioLocal,this.arrDatoGeneral);
	        	
				ResumenUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),resumenusuarioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarResumenUsuario(resumenusuarioLocal)) {				
					ResumenUsuarioDataAccess.save(resumenusuarioLocal, connexion);				
				} else {
					validadoTodosResumenUsuario=false;
				}
			}
			
			if(!validadoTodosResumenUsuario) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ResumenUsuarioLogicAdditional.checkResumenUsuarioToSavesAfter(resumenusuarios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarResumenUsuariosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ResumenUsuarioParameterReturnGeneral procesarAccionResumenUsuarios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ResumenUsuario> resumenusuarios,ResumenUsuarioParameterReturnGeneral resumenusuarioParameterGeneral)throws Exception {
		 try {	
			ResumenUsuarioParameterReturnGeneral resumenusuarioReturnGeneral=new ResumenUsuarioParameterReturnGeneral();
	
			ResumenUsuarioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,resumenusuarios,resumenusuarioParameterGeneral,resumenusuarioReturnGeneral);
			
			return resumenusuarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ResumenUsuarioParameterReturnGeneral procesarAccionResumenUsuariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ResumenUsuario> resumenusuarios,ResumenUsuarioParameterReturnGeneral resumenusuarioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResumenUsuario.class.getSimpleName()+"-procesarAccionResumenUsuariosWithConnection");connexion.begin();			
			
			ResumenUsuarioParameterReturnGeneral resumenusuarioReturnGeneral=new ResumenUsuarioParameterReturnGeneral();
	
			ResumenUsuarioLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,resumenusuarios,resumenusuarioParameterGeneral,resumenusuarioReturnGeneral);
			
			this.connexion.commit();
			
			return resumenusuarioReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ResumenUsuarioParameterReturnGeneral procesarEventosResumenUsuarios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ResumenUsuario> resumenusuarios,ResumenUsuario resumenusuario,ResumenUsuarioParameterReturnGeneral resumenusuarioParameterGeneral,Boolean isEsNuevoResumenUsuario,ArrayList<Classe> clases)throws Exception {
		 try {	
			ResumenUsuarioParameterReturnGeneral resumenusuarioReturnGeneral=new ResumenUsuarioParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				resumenusuarioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ResumenUsuarioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,resumenusuarios,resumenusuario,resumenusuarioParameterGeneral,resumenusuarioReturnGeneral,isEsNuevoResumenUsuario,clases);
			
			return resumenusuarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ResumenUsuarioParameterReturnGeneral procesarEventosResumenUsuariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ResumenUsuario> resumenusuarios,ResumenUsuario resumenusuario,ResumenUsuarioParameterReturnGeneral resumenusuarioParameterGeneral,Boolean isEsNuevoResumenUsuario,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResumenUsuario.class.getSimpleName()+"-procesarEventosResumenUsuariosWithConnection");connexion.begin();			
			
			ResumenUsuarioParameterReturnGeneral resumenusuarioReturnGeneral=new ResumenUsuarioParameterReturnGeneral();
	
			resumenusuarioReturnGeneral.setResumenUsuario(resumenusuario);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				resumenusuarioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ResumenUsuarioLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,resumenusuarios,resumenusuario,resumenusuarioParameterGeneral,resumenusuarioReturnGeneral,isEsNuevoResumenUsuario,clases);
			
			this.connexion.commit();
			
			return resumenusuarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ResumenUsuarioParameterReturnGeneral procesarImportacionResumenUsuariosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ResumenUsuarioParameterReturnGeneral resumenusuarioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResumenUsuario.class.getSimpleName()+"-procesarImportacionResumenUsuariosWithConnection");connexion.begin();			
			
			ResumenUsuarioParameterReturnGeneral resumenusuarioReturnGeneral=new ResumenUsuarioParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.resumenusuarios=new ArrayList<ResumenUsuario>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.resumenusuario=new ResumenUsuario();
				
				
				if(conColumnasBase) {this.resumenusuario.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.resumenusuario.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.resumenusuario.setnumero_ingresos(Long.parseLong(arrColumnas[iColumn++]));
				this.resumenusuario.setnumero_error_ingreso(Long.parseLong(arrColumnas[iColumn++]));
				this.resumenusuario.setnumero_intentos(Long.parseLong(arrColumnas[iColumn++]));
				this.resumenusuario.setnumero_cierres(Long.parseLong(arrColumnas[iColumn++]));
				this.resumenusuario.setnumero_reinicios(Long.parseLong(arrColumnas[iColumn++]));
				this.resumenusuario.setnumero_ingreso_actual(Long.parseLong(arrColumnas[iColumn++]));
				this.resumenusuario.setfecha_ultimo_ingreso(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.resumenusuario.setfecha_ultimo_error_ingreso(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.resumenusuario.setfecha_ultimo_intento(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.resumenusuario.setfecha_ultimo_cierre(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				
				this.resumenusuarios.add(this.resumenusuario);
			}
			
			this.saveResumenUsuarios();
			
			this.connexion.commit();
			
			resumenusuarioReturnGeneral.setConRetornoEstaProcesado(true);
			resumenusuarioReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return resumenusuarioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarResumenUsuariosEliminados() throws Exception {				
		
		List<ResumenUsuario> resumenusuariosAux= new ArrayList<ResumenUsuario>();
		
		for(ResumenUsuario resumenusuario:resumenusuarios) {
			if(!resumenusuario.getIsDeleted()) {
				resumenusuariosAux.add(resumenusuario);
			}
		}
		
		resumenusuarios=resumenusuariosAux;
	}
	
	public void quitarResumenUsuariosNulos() throws Exception {				
		
		List<ResumenUsuario> resumenusuariosAux= new ArrayList<ResumenUsuario>();
		
		for(ResumenUsuario resumenusuario : this.resumenusuarios) {
			if(resumenusuario==null) {
				resumenusuariosAux.add(resumenusuario);
			}
		}
		
		//this.resumenusuarios=resumenusuariosAux;
		
		this.resumenusuarios.removeAll(resumenusuariosAux);
	}
	
	public void getSetVersionRowResumenUsuarioWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(resumenusuario.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((resumenusuario.getIsDeleted() || (resumenusuario.getIsChanged()&&!resumenusuario.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=resumenusuarioDataAccess.getSetVersionRowResumenUsuario(connexion,resumenusuario.getId());
				
				if(!resumenusuario.getVersionRow().equals(timestamp)) {	
					resumenusuario.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				resumenusuario.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowResumenUsuario()throws Exception {	
		
		if(resumenusuario.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((resumenusuario.getIsDeleted() || (resumenusuario.getIsChanged()&&!resumenusuario.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=resumenusuarioDataAccess.getSetVersionRowResumenUsuario(connexion,resumenusuario.getId());
			
			try {							
				if(!resumenusuario.getVersionRow().equals(timestamp)) {	
					resumenusuario.setVersionRow(timestamp);
				}
				
				resumenusuario.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowResumenUsuariosWithConnection()throws Exception {	
		if(resumenusuarios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ResumenUsuario resumenusuarioAux:resumenusuarios) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(resumenusuarioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(resumenusuarioAux.getIsDeleted() || (resumenusuarioAux.getIsChanged()&&!resumenusuarioAux.getIsNew())) {
						
						timestamp=resumenusuarioDataAccess.getSetVersionRowResumenUsuario(connexion,resumenusuarioAux.getId());
						
						if(!resumenusuario.getVersionRow().equals(timestamp)) {	
							resumenusuarioAux.setVersionRow(timestamp);
						}
								
						resumenusuarioAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowResumenUsuarios()throws Exception {	
		if(resumenusuarios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ResumenUsuario resumenusuarioAux:resumenusuarios) {
					if(resumenusuarioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(resumenusuarioAux.getIsDeleted() || (resumenusuarioAux.getIsChanged()&&!resumenusuarioAux.getIsNew())) {
						
						timestamp=resumenusuarioDataAccess.getSetVersionRowResumenUsuario(connexion,resumenusuarioAux.getId());
						
						if(!resumenusuarioAux.getVersionRow().equals(timestamp)) {	
							resumenusuarioAux.setVersionRow(timestamp);
						}
						
													
						resumenusuarioAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ResumenUsuarioParameterReturnGeneral cargarCombosLoteForeignKeyResumenUsuarioWithConnection(String finalQueryGlobalUsuario) throws Exception {
		ResumenUsuarioParameterReturnGeneral  resumenusuarioReturnGeneral =new ResumenUsuarioParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResumenUsuario.class.getSimpleName()+"-cargarCombosLoteForeignKeyResumenUsuarioWithConnection");connexion.begin();
			
			resumenusuarioReturnGeneral =new ResumenUsuarioParameterReturnGeneral();
			
			

			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			resumenusuarioReturnGeneral.setusuariosForeignKey(usuariosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return resumenusuarioReturnGeneral;
	}
	
	public ResumenUsuarioParameterReturnGeneral cargarCombosLoteForeignKeyResumenUsuario(String finalQueryGlobalUsuario) throws Exception {
		ResumenUsuarioParameterReturnGeneral  resumenusuarioReturnGeneral =new ResumenUsuarioParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			resumenusuarioReturnGeneral =new ResumenUsuarioParameterReturnGeneral();
			
			

			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			resumenusuarioReturnGeneral.setusuariosForeignKey(usuariosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return resumenusuarioReturnGeneral;
	}
	
	
	public void deepLoad(ResumenUsuario resumenusuario,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ResumenUsuarioLogicAdditional.updateResumenUsuarioToGet(resumenusuario,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		resumenusuario.setUsuario(resumenusuarioDataAccess.getUsuario(connexion,resumenusuario));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				resumenusuario.setUsuario(resumenusuarioDataAccess.getUsuario(connexion,resumenusuario));
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
			resumenusuario.setUsuario(resumenusuarioDataAccess.getUsuario(connexion,resumenusuario));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		resumenusuario.setUsuario(resumenusuarioDataAccess.getUsuario(connexion,resumenusuario));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(resumenusuario.getUsuario(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				resumenusuario.setUsuario(resumenusuarioDataAccess.getUsuario(connexion,resumenusuario));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(resumenusuario.getUsuario(),isDeep,deepLoadType,clases);				
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
			resumenusuario.setUsuario(resumenusuarioDataAccess.getUsuario(connexion,resumenusuario));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(resumenusuario.getUsuario(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ResumenUsuario resumenusuario,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ResumenUsuarioLogicAdditional.updateResumenUsuarioToSave(resumenusuario,this.arrDatoGeneral);
			
ResumenUsuarioDataAccess.save(resumenusuario, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		UsuarioDataAccess.save(resumenusuario.getUsuario(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(resumenusuario.getUsuario(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		UsuarioDataAccess.save(resumenusuario.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(resumenusuario.getUsuario(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(resumenusuario.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(resumenusuario.getUsuario(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ResumenUsuario.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(resumenusuario,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ResumenUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesResumenUsuario(resumenusuario);
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
			this.deepLoad(this.resumenusuario,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ResumenUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesResumenUsuario(this.resumenusuario);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ResumenUsuario.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(resumenusuarios!=null) {
				for(ResumenUsuario resumenusuario:resumenusuarios) {
					this.deepLoad(resumenusuario,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ResumenUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesResumenUsuario(resumenusuarios);
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
			if(resumenusuarios!=null) {
				for(ResumenUsuario resumenusuario:resumenusuarios) {
					this.deepLoad(resumenusuario,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ResumenUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesResumenUsuario(resumenusuarios);
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
			this.getNewConnexionToDeep(ResumenUsuario.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(resumenusuario,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ResumenUsuario.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(resumenusuarios!=null) {
				for(ResumenUsuario resumenusuario:resumenusuarios) {
					this.deepSave(resumenusuario,isDeep,deepLoadType,clases);
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
			if(resumenusuarios!=null) {
				for(ResumenUsuario resumenusuario:resumenusuarios) {
					this.deepSave(resumenusuario,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getResumenUsuariosFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ResumenUsuario.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,ResumenUsuarioConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			ResumenUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			resumenusuarios=resumenusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ResumenUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesResumenUsuario(this.resumenusuarios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getResumenUsuariosFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,ResumenUsuarioConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			ResumenUsuarioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			resumenusuarios=resumenusuarioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ResumenUsuarioConstantesFunciones.refrescarForeignKeysDescripcionesResumenUsuario(this.resumenusuarios);
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
			if(ResumenUsuarioConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ResumenUsuarioDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ResumenUsuario resumenusuario,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ResumenUsuarioConstantesFunciones.ISCONAUDITORIA) {
				if(resumenusuario.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ResumenUsuarioDataAccess.TABLENAME, resumenusuario.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ResumenUsuarioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ResumenUsuarioLogic.registrarAuditoriaDetallesResumenUsuario(connexion,resumenusuario,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(resumenusuario.getIsDeleted()) {
					/*if(!resumenusuario.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ResumenUsuarioDataAccess.TABLENAME, resumenusuario.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ResumenUsuarioLogic.registrarAuditoriaDetallesResumenUsuario(connexion,resumenusuario,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ResumenUsuarioDataAccess.TABLENAME, resumenusuario.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(resumenusuario.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ResumenUsuarioDataAccess.TABLENAME, resumenusuario.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ResumenUsuarioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ResumenUsuarioLogic.registrarAuditoriaDetallesResumenUsuario(connexion,resumenusuario,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesResumenUsuario(Connexion connexion,ResumenUsuario resumenusuario)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(resumenusuario.getIsNew()||!resumenusuario.getid_usuario().equals(resumenusuario.getResumenUsuarioOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(resumenusuario.getResumenUsuarioOriginal().getid_usuario()!=null)
				{
					strValorActual=resumenusuario.getResumenUsuarioOriginal().getid_usuario().toString();
				}
				if(resumenusuario.getid_usuario()!=null)
				{
					strValorNuevo=resumenusuario.getid_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ResumenUsuarioConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(resumenusuario.getIsNew()||!resumenusuario.getnumero_ingresos().equals(resumenusuario.getResumenUsuarioOriginal().getnumero_ingresos()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(resumenusuario.getResumenUsuarioOriginal().getnumero_ingresos()!=null)
				{
					strValorActual=resumenusuario.getResumenUsuarioOriginal().getnumero_ingresos().toString();
				}
				if(resumenusuario.getnumero_ingresos()!=null)
				{
					strValorNuevo=resumenusuario.getnumero_ingresos().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ResumenUsuarioConstantesFunciones.NUMEROINGRESOS,strValorActual,strValorNuevo);
			}	
			
			if(resumenusuario.getIsNew()||!resumenusuario.getnumero_error_ingreso().equals(resumenusuario.getResumenUsuarioOriginal().getnumero_error_ingreso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(resumenusuario.getResumenUsuarioOriginal().getnumero_error_ingreso()!=null)
				{
					strValorActual=resumenusuario.getResumenUsuarioOriginal().getnumero_error_ingreso().toString();
				}
				if(resumenusuario.getnumero_error_ingreso()!=null)
				{
					strValorNuevo=resumenusuario.getnumero_error_ingreso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ResumenUsuarioConstantesFunciones.NUMEROERRORINGRESO,strValorActual,strValorNuevo);
			}	
			
			if(resumenusuario.getIsNew()||!resumenusuario.getnumero_intentos().equals(resumenusuario.getResumenUsuarioOriginal().getnumero_intentos()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(resumenusuario.getResumenUsuarioOriginal().getnumero_intentos()!=null)
				{
					strValorActual=resumenusuario.getResumenUsuarioOriginal().getnumero_intentos().toString();
				}
				if(resumenusuario.getnumero_intentos()!=null)
				{
					strValorNuevo=resumenusuario.getnumero_intentos().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ResumenUsuarioConstantesFunciones.NUMEROINTENTOS,strValorActual,strValorNuevo);
			}	
			
			if(resumenusuario.getIsNew()||!resumenusuario.getnumero_cierres().equals(resumenusuario.getResumenUsuarioOriginal().getnumero_cierres()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(resumenusuario.getResumenUsuarioOriginal().getnumero_cierres()!=null)
				{
					strValorActual=resumenusuario.getResumenUsuarioOriginal().getnumero_cierres().toString();
				}
				if(resumenusuario.getnumero_cierres()!=null)
				{
					strValorNuevo=resumenusuario.getnumero_cierres().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ResumenUsuarioConstantesFunciones.NUMEROCIERRES,strValorActual,strValorNuevo);
			}	
			
			if(resumenusuario.getIsNew()||!resumenusuario.getnumero_reinicios().equals(resumenusuario.getResumenUsuarioOriginal().getnumero_reinicios()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(resumenusuario.getResumenUsuarioOriginal().getnumero_reinicios()!=null)
				{
					strValorActual=resumenusuario.getResumenUsuarioOriginal().getnumero_reinicios().toString();
				}
				if(resumenusuario.getnumero_reinicios()!=null)
				{
					strValorNuevo=resumenusuario.getnumero_reinicios().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ResumenUsuarioConstantesFunciones.NUMEROREINICIOS,strValorActual,strValorNuevo);
			}	
			
			if(resumenusuario.getIsNew()||!resumenusuario.getnumero_ingreso_actual().equals(resumenusuario.getResumenUsuarioOriginal().getnumero_ingreso_actual()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(resumenusuario.getResumenUsuarioOriginal().getnumero_ingreso_actual()!=null)
				{
					strValorActual=resumenusuario.getResumenUsuarioOriginal().getnumero_ingreso_actual().toString();
				}
				if(resumenusuario.getnumero_ingreso_actual()!=null)
				{
					strValorNuevo=resumenusuario.getnumero_ingreso_actual().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ResumenUsuarioConstantesFunciones.NUMEROINGRESOACTUAL,strValorActual,strValorNuevo);
			}	
			
			if(resumenusuario.getIsNew()||!resumenusuario.getfecha_ultimo_ingreso().equals(resumenusuario.getResumenUsuarioOriginal().getfecha_ultimo_ingreso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(resumenusuario.getResumenUsuarioOriginal().getfecha_ultimo_ingreso()!=null)
				{
					strValorActual=resumenusuario.getResumenUsuarioOriginal().getfecha_ultimo_ingreso().toString();
				}
				if(resumenusuario.getfecha_ultimo_ingreso()!=null)
				{
					strValorNuevo=resumenusuario.getfecha_ultimo_ingreso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ResumenUsuarioConstantesFunciones.FECHAULTIMOINGRESO,strValorActual,strValorNuevo);
			}	
			
			if(resumenusuario.getIsNew()||!resumenusuario.getfecha_ultimo_error_ingreso().equals(resumenusuario.getResumenUsuarioOriginal().getfecha_ultimo_error_ingreso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(resumenusuario.getResumenUsuarioOriginal().getfecha_ultimo_error_ingreso()!=null)
				{
					strValorActual=resumenusuario.getResumenUsuarioOriginal().getfecha_ultimo_error_ingreso().toString();
				}
				if(resumenusuario.getfecha_ultimo_error_ingreso()!=null)
				{
					strValorNuevo=resumenusuario.getfecha_ultimo_error_ingreso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ResumenUsuarioConstantesFunciones.FECHAULTIMOERRORINGRESO,strValorActual,strValorNuevo);
			}	
			
			if(resumenusuario.getIsNew()||!resumenusuario.getfecha_ultimo_intento().equals(resumenusuario.getResumenUsuarioOriginal().getfecha_ultimo_intento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(resumenusuario.getResumenUsuarioOriginal().getfecha_ultimo_intento()!=null)
				{
					strValorActual=resumenusuario.getResumenUsuarioOriginal().getfecha_ultimo_intento().toString();
				}
				if(resumenusuario.getfecha_ultimo_intento()!=null)
				{
					strValorNuevo=resumenusuario.getfecha_ultimo_intento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ResumenUsuarioConstantesFunciones.FECHAULTIMOINTENTO,strValorActual,strValorNuevo);
			}	
			
			if(resumenusuario.getIsNew()||!resumenusuario.getfecha_ultimo_cierre().equals(resumenusuario.getResumenUsuarioOriginal().getfecha_ultimo_cierre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(resumenusuario.getResumenUsuarioOriginal().getfecha_ultimo_cierre()!=null)
				{
					strValorActual=resumenusuario.getResumenUsuarioOriginal().getfecha_ultimo_cierre().toString();
				}
				if(resumenusuario.getfecha_ultimo_cierre()!=null)
				{
					strValorNuevo=resumenusuario.getfecha_ultimo_cierre().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ResumenUsuarioConstantesFunciones.FECHAULTIMOCIERRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveResumenUsuarioRelacionesWithConnection(ResumenUsuario resumenusuario) throws Exception {

		if(!resumenusuario.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveResumenUsuarioRelacionesBase(resumenusuario,true);
		}
	}

	public void saveResumenUsuarioRelaciones(ResumenUsuario resumenusuario)throws Exception {

		if(!resumenusuario.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveResumenUsuarioRelacionesBase(resumenusuario,false);
		}
	}

	public void saveResumenUsuarioRelacionesBase(ResumenUsuario resumenusuario,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ResumenUsuario-saveRelacionesWithConnection");}
	

			this.setResumenUsuario(resumenusuario);

			if(ResumenUsuarioLogicAdditional.validarSaveRelaciones(resumenusuario,this)) {

				ResumenUsuarioLogicAdditional.updateRelacionesToSave(resumenusuario,this);

				if((resumenusuario.getIsNew()||resumenusuario.getIsChanged())&&!resumenusuario.getIsDeleted()) {
					this.saveResumenUsuario();
					this.saveResumenUsuarioRelacionesDetalles();

				} else if(resumenusuario.getIsDeleted()) {
					this.saveResumenUsuarioRelacionesDetalles();
					this.saveResumenUsuario();
				}

				ResumenUsuarioLogicAdditional.updateRelacionesToSaveAfter(resumenusuario,this);

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
	
	
	private void saveResumenUsuarioRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfResumenUsuario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ResumenUsuarioConstantesFunciones.getClassesForeignKeysOfResumenUsuario(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfResumenUsuario(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ResumenUsuarioConstantesFunciones.getClassesRelationshipsOfResumenUsuario(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

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
import com.bydan.erp.seguridad.util.UsuarioOpcionConstantesFunciones;
import com.bydan.erp.seguridad.util.UsuarioOpcionParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.UsuarioOpcionParameterGeneral;
import com.bydan.erp.seguridad.business.entity.UsuarioOpcion;
import com.bydan.erp.seguridad.business.logic.UsuarioOpcionLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class UsuarioOpcionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(UsuarioOpcionLogic.class);
	
	protected UsuarioOpcionDataAccess usuarioopcionDataAccess; 	
	protected UsuarioOpcion usuarioopcion;
	protected List<UsuarioOpcion> usuarioopcions;
	protected Object usuarioopcionObject;	
	protected List<Object> usuarioopcionsObject;
	
	public static ClassValidator<UsuarioOpcion> usuarioopcionValidator = new ClassValidator<UsuarioOpcion>(UsuarioOpcion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected UsuarioOpcionLogicAdditional usuarioopcionLogicAdditional=null;
	
	public UsuarioOpcionLogicAdditional getUsuarioOpcionLogicAdditional() {
		return this.usuarioopcionLogicAdditional;
	}
	
	public void setUsuarioOpcionLogicAdditional(UsuarioOpcionLogicAdditional usuarioopcionLogicAdditional) {
		try {
			this.usuarioopcionLogicAdditional=usuarioopcionLogicAdditional;
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
	
	
	
	
	public  UsuarioOpcionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.usuarioopcionDataAccess = new UsuarioOpcionDataAccess();
			
			this.usuarioopcions= new ArrayList<UsuarioOpcion>();
			this.usuarioopcion= new UsuarioOpcion();
			
			this.usuarioopcionObject=new Object();
			this.usuarioopcionsObject=new ArrayList<Object>();
				
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
			
			this.usuarioopcionDataAccess.setConnexionType(this.connexionType);
			this.usuarioopcionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  UsuarioOpcionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.usuarioopcionDataAccess = new UsuarioOpcionDataAccess();
			this.usuarioopcions= new ArrayList<UsuarioOpcion>();
			this.usuarioopcion= new UsuarioOpcion();
			this.usuarioopcionObject=new Object();
			this.usuarioopcionsObject=new ArrayList<Object>();
			
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
			
			this.usuarioopcionDataAccess.setConnexionType(this.connexionType);
			this.usuarioopcionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public UsuarioOpcion getUsuarioOpcion() throws Exception {	
		UsuarioOpcionLogicAdditional.checkUsuarioOpcionToGet(usuarioopcion,this.datosCliente,this.arrDatoGeneral);
		UsuarioOpcionLogicAdditional.updateUsuarioOpcionToGet(usuarioopcion,this.arrDatoGeneral);
		
		return usuarioopcion;
	}
		
	public void setUsuarioOpcion(UsuarioOpcion newUsuarioOpcion) {
		this.usuarioopcion = newUsuarioOpcion;
	}
	
	public UsuarioOpcionDataAccess getUsuarioOpcionDataAccess() {
		return usuarioopcionDataAccess;
	}
	
	public void setUsuarioOpcionDataAccess(UsuarioOpcionDataAccess newusuarioopcionDataAccess) {
		this.usuarioopcionDataAccess = newusuarioopcionDataAccess;
	}
	
	public List<UsuarioOpcion> getUsuarioOpcions() throws Exception {		
		this.quitarUsuarioOpcionsNulos();
		
		UsuarioOpcionLogicAdditional.checkUsuarioOpcionToGets(usuarioopcions,this.datosCliente,this.arrDatoGeneral);
		
		for (UsuarioOpcion usuarioopcionLocal: usuarioopcions ) {
			UsuarioOpcionLogicAdditional.updateUsuarioOpcionToGet(usuarioopcionLocal,this.arrDatoGeneral);
		}
		
		return usuarioopcions;
	}
	
	public void setUsuarioOpcions(List<UsuarioOpcion> newUsuarioOpcions) {
		this.usuarioopcions = newUsuarioOpcions;
	}
	
	public Object getUsuarioOpcionObject() {	
		this.usuarioopcionObject=this.usuarioopcionDataAccess.getEntityObject();
		return this.usuarioopcionObject;
	}
		
	public void setUsuarioOpcionObject(Object newUsuarioOpcionObject) {
		this.usuarioopcionObject = newUsuarioOpcionObject;
	}
	
	public List<Object> getUsuarioOpcionsObject() {		
		this.usuarioopcionsObject=this.usuarioopcionDataAccess.getEntitiesObject();
		return this.usuarioopcionsObject;
	}
		
	public void setUsuarioOpcionsObject(List<Object> newUsuarioOpcionsObject) {
		this.usuarioopcionsObject = newUsuarioOpcionsObject;
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
		
		if(this.usuarioopcionDataAccess!=null) {
			this.usuarioopcionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UsuarioOpcion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			usuarioopcionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			usuarioopcionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		usuarioopcion = new  UsuarioOpcion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UsuarioOpcion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			usuarioopcion=usuarioopcionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.usuarioopcion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				UsuarioOpcionConstantesFunciones.refrescarForeignKeysDescripcionesUsuarioOpcion(this.usuarioopcion);
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
		usuarioopcion = new  UsuarioOpcion();
		  		  
        try {
			
			usuarioopcion=usuarioopcionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.usuarioopcion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				UsuarioOpcionConstantesFunciones.refrescarForeignKeysDescripcionesUsuarioOpcion(this.usuarioopcion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		usuarioopcion = new  UsuarioOpcion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UsuarioOpcion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			usuarioopcion=usuarioopcionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.usuarioopcion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				UsuarioOpcionConstantesFunciones.refrescarForeignKeysDescripcionesUsuarioOpcion(this.usuarioopcion);
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
		usuarioopcion = new  UsuarioOpcion();
		  		  
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
		usuarioopcion = new  UsuarioOpcion();
		  		  
        try {
			
			usuarioopcion=usuarioopcionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.usuarioopcion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				UsuarioOpcionConstantesFunciones.refrescarForeignKeysDescripcionesUsuarioOpcion(this.usuarioopcion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		usuarioopcion = new  UsuarioOpcion();
		  		  
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
		usuarioopcion = new  UsuarioOpcion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UsuarioOpcion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =usuarioopcionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		usuarioopcion = new  UsuarioOpcion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=usuarioopcionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		usuarioopcion = new  UsuarioOpcion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UsuarioOpcion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =usuarioopcionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		usuarioopcion = new  UsuarioOpcion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=usuarioopcionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		usuarioopcion = new  UsuarioOpcion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UsuarioOpcion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =usuarioopcionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		usuarioopcion = new  UsuarioOpcion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=usuarioopcionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		usuarioopcions = new  ArrayList<UsuarioOpcion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UsuarioOpcion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			UsuarioOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			usuarioopcions=usuarioopcionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUsuarioOpcion(usuarioopcions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UsuarioOpcionConstantesFunciones.refrescarForeignKeysDescripcionesUsuarioOpcion(this.usuarioopcions);
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
		usuarioopcions = new  ArrayList<UsuarioOpcion>();
		  		  
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
		usuarioopcions = new  ArrayList<UsuarioOpcion>();
		  		  
        try {			
			UsuarioOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			usuarioopcions=usuarioopcionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarUsuarioOpcion(usuarioopcions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UsuarioOpcionConstantesFunciones.refrescarForeignKeysDescripcionesUsuarioOpcion(this.usuarioopcions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		usuarioopcions = new  ArrayList<UsuarioOpcion>();
		  		  
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
		usuarioopcions = new  ArrayList<UsuarioOpcion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UsuarioOpcion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			UsuarioOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			usuarioopcions=usuarioopcionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUsuarioOpcion(usuarioopcions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UsuarioOpcionConstantesFunciones.refrescarForeignKeysDescripcionesUsuarioOpcion(this.usuarioopcions);
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
		usuarioopcions = new  ArrayList<UsuarioOpcion>();
		  		  
        try {
			UsuarioOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			usuarioopcions=usuarioopcionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUsuarioOpcion(usuarioopcions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UsuarioOpcionConstantesFunciones.refrescarForeignKeysDescripcionesUsuarioOpcion(this.usuarioopcions);
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
		usuarioopcions = new  ArrayList<UsuarioOpcion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UsuarioOpcion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UsuarioOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			usuarioopcions=usuarioopcionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarUsuarioOpcion(usuarioopcions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UsuarioOpcionConstantesFunciones.refrescarForeignKeysDescripcionesUsuarioOpcion(this.usuarioopcions);
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
		usuarioopcions = new  ArrayList<UsuarioOpcion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UsuarioOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			usuarioopcions=usuarioopcionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarUsuarioOpcion(usuarioopcions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UsuarioOpcionConstantesFunciones.refrescarForeignKeysDescripcionesUsuarioOpcion(this.usuarioopcions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		usuarioopcion = new  UsuarioOpcion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UsuarioOpcion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UsuarioOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			usuarioopcion=usuarioopcionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarUsuarioOpcion(usuarioopcion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UsuarioOpcionConstantesFunciones.refrescarForeignKeysDescripcionesUsuarioOpcion(this.usuarioopcion);
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
		usuarioopcion = new  UsuarioOpcion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UsuarioOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			usuarioopcion=usuarioopcionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarUsuarioOpcion(usuarioopcion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UsuarioOpcionConstantesFunciones.refrescarForeignKeysDescripcionesUsuarioOpcion(this.usuarioopcion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		usuarioopcions = new  ArrayList<UsuarioOpcion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UsuarioOpcion.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			UsuarioOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			usuarioopcions=usuarioopcionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUsuarioOpcion(usuarioopcions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UsuarioOpcionConstantesFunciones.refrescarForeignKeysDescripcionesUsuarioOpcion(this.usuarioopcions);
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
		usuarioopcions = new  ArrayList<UsuarioOpcion>();
		  		  
        try {
			UsuarioOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			usuarioopcions=usuarioopcionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUsuarioOpcion(usuarioopcions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UsuarioOpcionConstantesFunciones.refrescarForeignKeysDescripcionesUsuarioOpcion(this.usuarioopcions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosUsuarioOpcionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		usuarioopcions = new  ArrayList<UsuarioOpcion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UsuarioOpcion.class.getSimpleName()+"-getTodosUsuarioOpcionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UsuarioOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			usuarioopcions=usuarioopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarUsuarioOpcion(usuarioopcions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UsuarioOpcionConstantesFunciones.refrescarForeignKeysDescripcionesUsuarioOpcion(this.usuarioopcions);
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
	
	public  void  getTodosUsuarioOpcions(String sFinalQuery,Pagination pagination)throws Exception {
		usuarioopcions = new  ArrayList<UsuarioOpcion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UsuarioOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			usuarioopcions=usuarioopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarUsuarioOpcion(usuarioopcions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UsuarioOpcionConstantesFunciones.refrescarForeignKeysDescripcionesUsuarioOpcion(this.usuarioopcions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarUsuarioOpcion(UsuarioOpcion usuarioopcion) throws Exception {
		Boolean estaValidado=false;
		
		if(usuarioopcion.getIsNew() || usuarioopcion.getIsChanged()) { 
			this.invalidValues = usuarioopcionValidator.getInvalidValues(usuarioopcion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(usuarioopcion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarUsuarioOpcion(List<UsuarioOpcion> UsuarioOpcions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(UsuarioOpcion usuarioopcionLocal:usuarioopcions) {				
			estaValidadoObjeto=this.validarGuardarUsuarioOpcion(usuarioopcionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarUsuarioOpcion(List<UsuarioOpcion> UsuarioOpcions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarUsuarioOpcion(usuarioopcions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarUsuarioOpcion(UsuarioOpcion UsuarioOpcion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarUsuarioOpcion(usuarioopcion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(UsuarioOpcion usuarioopcion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+usuarioopcion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=UsuarioOpcionConstantesFunciones.getUsuarioOpcionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"usuarioopcion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(UsuarioOpcionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(UsuarioOpcionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveUsuarioOpcionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UsuarioOpcion.class.getSimpleName()+"-saveUsuarioOpcionWithConnection");connexion.begin();			
			
			UsuarioOpcionLogicAdditional.checkUsuarioOpcionToSave(this.usuarioopcion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			UsuarioOpcionLogicAdditional.updateUsuarioOpcionToSave(this.usuarioopcion,this.arrDatoGeneral);
			
			UsuarioOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.usuarioopcion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowUsuarioOpcion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarUsuarioOpcion(this.usuarioopcion)) {
				UsuarioOpcionDataAccess.save(this.usuarioopcion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.usuarioopcion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			UsuarioOpcionLogicAdditional.checkUsuarioOpcionToSaveAfter(this.usuarioopcion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowUsuarioOpcion();
			
			connexion.commit();			
			
			if(this.usuarioopcion.getIsDeleted()) {
				this.usuarioopcion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveUsuarioOpcion()throws Exception {	
		try {	
			
			UsuarioOpcionLogicAdditional.checkUsuarioOpcionToSave(this.usuarioopcion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			UsuarioOpcionLogicAdditional.updateUsuarioOpcionToSave(this.usuarioopcion,this.arrDatoGeneral);
			
			UsuarioOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.usuarioopcion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarUsuarioOpcion(this.usuarioopcion)) {			
				UsuarioOpcionDataAccess.save(this.usuarioopcion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.usuarioopcion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			UsuarioOpcionLogicAdditional.checkUsuarioOpcionToSaveAfter(this.usuarioopcion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.usuarioopcion.getIsDeleted()) {
				this.usuarioopcion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveUsuarioOpcionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UsuarioOpcion.class.getSimpleName()+"-saveUsuarioOpcionsWithConnection");connexion.begin();			
			
			UsuarioOpcionLogicAdditional.checkUsuarioOpcionToSaves(usuarioopcions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowUsuarioOpcions();
			
			Boolean validadoTodosUsuarioOpcion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(UsuarioOpcion usuarioopcionLocal:usuarioopcions) {		
				if(usuarioopcionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				UsuarioOpcionLogicAdditional.updateUsuarioOpcionToSave(usuarioopcionLocal,this.arrDatoGeneral);
	        	
				UsuarioOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),usuarioopcionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarUsuarioOpcion(usuarioopcionLocal)) {
					UsuarioOpcionDataAccess.save(usuarioopcionLocal, connexion);				
				} else {
					validadoTodosUsuarioOpcion=false;
				}
			}
			
			if(!validadoTodosUsuarioOpcion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			UsuarioOpcionLogicAdditional.checkUsuarioOpcionToSavesAfter(usuarioopcions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowUsuarioOpcions();
			
			connexion.commit();		
			
			this.quitarUsuarioOpcionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveUsuarioOpcions()throws Exception {				
		 try {	
			UsuarioOpcionLogicAdditional.checkUsuarioOpcionToSaves(usuarioopcions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosUsuarioOpcion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(UsuarioOpcion usuarioopcionLocal:usuarioopcions) {				
				if(usuarioopcionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				UsuarioOpcionLogicAdditional.updateUsuarioOpcionToSave(usuarioopcionLocal,this.arrDatoGeneral);
	        	
				UsuarioOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),usuarioopcionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarUsuarioOpcion(usuarioopcionLocal)) {				
					UsuarioOpcionDataAccess.save(usuarioopcionLocal, connexion);				
				} else {
					validadoTodosUsuarioOpcion=false;
				}
			}
			
			if(!validadoTodosUsuarioOpcion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			UsuarioOpcionLogicAdditional.checkUsuarioOpcionToSavesAfter(usuarioopcions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarUsuarioOpcionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public UsuarioOpcionParameterReturnGeneral procesarAccionUsuarioOpcions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<UsuarioOpcion> usuarioopcions,UsuarioOpcionParameterReturnGeneral usuarioopcionParameterGeneral)throws Exception {
		 try {	
			UsuarioOpcionParameterReturnGeneral usuarioopcionReturnGeneral=new UsuarioOpcionParameterReturnGeneral();
	
			UsuarioOpcionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,usuarioopcions,usuarioopcionParameterGeneral,usuarioopcionReturnGeneral);
			
			return usuarioopcionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public UsuarioOpcionParameterReturnGeneral procesarAccionUsuarioOpcionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<UsuarioOpcion> usuarioopcions,UsuarioOpcionParameterReturnGeneral usuarioopcionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UsuarioOpcion.class.getSimpleName()+"-procesarAccionUsuarioOpcionsWithConnection");connexion.begin();			
			
			UsuarioOpcionParameterReturnGeneral usuarioopcionReturnGeneral=new UsuarioOpcionParameterReturnGeneral();
	
			UsuarioOpcionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,usuarioopcions,usuarioopcionParameterGeneral,usuarioopcionReturnGeneral);
			
			this.connexion.commit();
			
			return usuarioopcionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public UsuarioOpcionParameterReturnGeneral procesarEventosUsuarioOpcions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<UsuarioOpcion> usuarioopcions,UsuarioOpcion usuarioopcion,UsuarioOpcionParameterReturnGeneral usuarioopcionParameterGeneral,Boolean isEsNuevoUsuarioOpcion,ArrayList<Classe> clases)throws Exception {
		 try {	
			UsuarioOpcionParameterReturnGeneral usuarioopcionReturnGeneral=new UsuarioOpcionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				usuarioopcionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			UsuarioOpcionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,usuarioopcions,usuarioopcion,usuarioopcionParameterGeneral,usuarioopcionReturnGeneral,isEsNuevoUsuarioOpcion,clases);
			
			return usuarioopcionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public UsuarioOpcionParameterReturnGeneral procesarEventosUsuarioOpcionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<UsuarioOpcion> usuarioopcions,UsuarioOpcion usuarioopcion,UsuarioOpcionParameterReturnGeneral usuarioopcionParameterGeneral,Boolean isEsNuevoUsuarioOpcion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UsuarioOpcion.class.getSimpleName()+"-procesarEventosUsuarioOpcionsWithConnection");connexion.begin();			
			
			UsuarioOpcionParameterReturnGeneral usuarioopcionReturnGeneral=new UsuarioOpcionParameterReturnGeneral();
	
			usuarioopcionReturnGeneral.setUsuarioOpcion(usuarioopcion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				usuarioopcionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			UsuarioOpcionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,usuarioopcions,usuarioopcion,usuarioopcionParameterGeneral,usuarioopcionReturnGeneral,isEsNuevoUsuarioOpcion,clases);
			
			this.connexion.commit();
			
			return usuarioopcionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public UsuarioOpcionParameterReturnGeneral procesarImportacionUsuarioOpcionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,UsuarioOpcionParameterReturnGeneral usuarioopcionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UsuarioOpcion.class.getSimpleName()+"-procesarImportacionUsuarioOpcionsWithConnection");connexion.begin();			
			
			UsuarioOpcionParameterReturnGeneral usuarioopcionReturnGeneral=new UsuarioOpcionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.usuarioopcions=new ArrayList<UsuarioOpcion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.usuarioopcion=new UsuarioOpcion();
				
				
				if(conColumnasBase) {this.usuarioopcion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.usuarioopcion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.usuarioopcion.setcon_precargar(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.usuarioopcion.setestado(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.usuarioopcions.add(this.usuarioopcion);
			}
			
			this.saveUsuarioOpcions();
			
			this.connexion.commit();
			
			usuarioopcionReturnGeneral.setConRetornoEstaProcesado(true);
			usuarioopcionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return usuarioopcionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarUsuarioOpcionsEliminados() throws Exception {				
		
		List<UsuarioOpcion> usuarioopcionsAux= new ArrayList<UsuarioOpcion>();
		
		for(UsuarioOpcion usuarioopcion:usuarioopcions) {
			if(!usuarioopcion.getIsDeleted()) {
				usuarioopcionsAux.add(usuarioopcion);
			}
		}
		
		usuarioopcions=usuarioopcionsAux;
	}
	
	public void quitarUsuarioOpcionsNulos() throws Exception {				
		
		List<UsuarioOpcion> usuarioopcionsAux= new ArrayList<UsuarioOpcion>();
		
		for(UsuarioOpcion usuarioopcion : this.usuarioopcions) {
			if(usuarioopcion==null) {
				usuarioopcionsAux.add(usuarioopcion);
			}
		}
		
		//this.usuarioopcions=usuarioopcionsAux;
		
		this.usuarioopcions.removeAll(usuarioopcionsAux);
	}
	
	public void getSetVersionRowUsuarioOpcionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(usuarioopcion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((usuarioopcion.getIsDeleted() || (usuarioopcion.getIsChanged()&&!usuarioopcion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=usuarioopcionDataAccess.getSetVersionRowUsuarioOpcion(connexion,usuarioopcion.getId());
				
				if(!usuarioopcion.getVersionRow().equals(timestamp)) {	
					usuarioopcion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				usuarioopcion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowUsuarioOpcion()throws Exception {	
		
		if(usuarioopcion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((usuarioopcion.getIsDeleted() || (usuarioopcion.getIsChanged()&&!usuarioopcion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=usuarioopcionDataAccess.getSetVersionRowUsuarioOpcion(connexion,usuarioopcion.getId());
			
			try {							
				if(!usuarioopcion.getVersionRow().equals(timestamp)) {	
					usuarioopcion.setVersionRow(timestamp);
				}
				
				usuarioopcion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowUsuarioOpcionsWithConnection()throws Exception {	
		if(usuarioopcions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(UsuarioOpcion usuarioopcionAux:usuarioopcions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(usuarioopcionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(usuarioopcionAux.getIsDeleted() || (usuarioopcionAux.getIsChanged()&&!usuarioopcionAux.getIsNew())) {
						
						timestamp=usuarioopcionDataAccess.getSetVersionRowUsuarioOpcion(connexion,usuarioopcionAux.getId());
						
						if(!usuarioopcion.getVersionRow().equals(timestamp)) {	
							usuarioopcionAux.setVersionRow(timestamp);
						}
								
						usuarioopcionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowUsuarioOpcions()throws Exception {	
		if(usuarioopcions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(UsuarioOpcion usuarioopcionAux:usuarioopcions) {
					if(usuarioopcionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(usuarioopcionAux.getIsDeleted() || (usuarioopcionAux.getIsChanged()&&!usuarioopcionAux.getIsNew())) {
						
						timestamp=usuarioopcionDataAccess.getSetVersionRowUsuarioOpcion(connexion,usuarioopcionAux.getId());
						
						if(!usuarioopcionAux.getVersionRow().equals(timestamp)) {	
							usuarioopcionAux.setVersionRow(timestamp);
						}
						
													
						usuarioopcionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public UsuarioOpcionParameterReturnGeneral cargarCombosLoteForeignKeyUsuarioOpcionWithConnection(String finalQueryGlobalSistema,String finalQueryGlobalModulo,String finalQueryGlobalGrupoOpcion,String finalQueryGlobalOpcion,String finalQueryGlobalPerfil,String finalQueryGlobalUsuario) throws Exception {
		UsuarioOpcionParameterReturnGeneral  usuarioopcionReturnGeneral =new UsuarioOpcionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UsuarioOpcion.class.getSimpleName()+"-cargarCombosLoteForeignKeyUsuarioOpcionWithConnection");connexion.begin();
			
			usuarioopcionReturnGeneral =new UsuarioOpcionParameterReturnGeneral();
			
			

			List<Sistema> sistemasForeignKey=new ArrayList<Sistema>();
			SistemaLogic sistemaLogic=new SistemaLogic();
			sistemaLogic.setConnexion(this.connexion);
			sistemaLogic.getSistemaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSistema.equals("NONE")) {
				sistemaLogic.getTodosSistemas(finalQueryGlobalSistema,new Pagination());
				sistemasForeignKey=sistemaLogic.getSistemas();
			}

			usuarioopcionReturnGeneral.setsistemasForeignKey(sistemasForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			usuarioopcionReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<GrupoOpcion> grupoopcionsForeignKey=new ArrayList<GrupoOpcion>();
			GrupoOpcionLogic grupoopcionLogic=new GrupoOpcionLogic();
			grupoopcionLogic.setConnexion(this.connexion);
			grupoopcionLogic.getGrupoOpcionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalGrupoOpcion.equals("NONE")) {
				grupoopcionLogic.getTodosGrupoOpcions(finalQueryGlobalGrupoOpcion,new Pagination());
				grupoopcionsForeignKey=grupoopcionLogic.getGrupoOpcions();
			}

			usuarioopcionReturnGeneral.setgrupoopcionsForeignKey(grupoopcionsForeignKey);


			List<Opcion> opcionsForeignKey=new ArrayList<Opcion>();
			OpcionLogic opcionLogic=new OpcionLogic();
			opcionLogic.setConnexion(this.connexion);
			opcionLogic.getOpcionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalOpcion.equals("NONE")) {
				opcionLogic.getTodosOpcions(finalQueryGlobalOpcion,new Pagination());
				opcionsForeignKey=opcionLogic.getOpcions();
			}

			usuarioopcionReturnGeneral.setopcionsForeignKey(opcionsForeignKey);


			List<Perfil> perfilsForeignKey=new ArrayList<Perfil>();
			PerfilLogic perfilLogic=new PerfilLogic();
			perfilLogic.setConnexion(this.connexion);
			perfilLogic.getPerfilDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPerfil.equals("NONE")) {
				perfilLogic.getTodosPerfils(finalQueryGlobalPerfil,new Pagination());
				perfilsForeignKey=perfilLogic.getPerfils();
			}

			usuarioopcionReturnGeneral.setperfilsForeignKey(perfilsForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			usuarioopcionReturnGeneral.setusuariosForeignKey(usuariosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return usuarioopcionReturnGeneral;
	}
	
	public UsuarioOpcionParameterReturnGeneral cargarCombosLoteForeignKeyUsuarioOpcion(String finalQueryGlobalSistema,String finalQueryGlobalModulo,String finalQueryGlobalGrupoOpcion,String finalQueryGlobalOpcion,String finalQueryGlobalPerfil,String finalQueryGlobalUsuario) throws Exception {
		UsuarioOpcionParameterReturnGeneral  usuarioopcionReturnGeneral =new UsuarioOpcionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			usuarioopcionReturnGeneral =new UsuarioOpcionParameterReturnGeneral();
			
			

			List<Sistema> sistemasForeignKey=new ArrayList<Sistema>();
			SistemaLogic sistemaLogic=new SistemaLogic();
			sistemaLogic.setConnexion(this.connexion);
			sistemaLogic.getSistemaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSistema.equals("NONE")) {
				sistemaLogic.getTodosSistemas(finalQueryGlobalSistema,new Pagination());
				sistemasForeignKey=sistemaLogic.getSistemas();
			}

			usuarioopcionReturnGeneral.setsistemasForeignKey(sistemasForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			usuarioopcionReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<GrupoOpcion> grupoopcionsForeignKey=new ArrayList<GrupoOpcion>();
			GrupoOpcionLogic grupoopcionLogic=new GrupoOpcionLogic();
			grupoopcionLogic.setConnexion(this.connexion);
			grupoopcionLogic.getGrupoOpcionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalGrupoOpcion.equals("NONE")) {
				grupoopcionLogic.getTodosGrupoOpcions(finalQueryGlobalGrupoOpcion,new Pagination());
				grupoopcionsForeignKey=grupoopcionLogic.getGrupoOpcions();
			}

			usuarioopcionReturnGeneral.setgrupoopcionsForeignKey(grupoopcionsForeignKey);


			List<Opcion> opcionsForeignKey=new ArrayList<Opcion>();
			OpcionLogic opcionLogic=new OpcionLogic();
			opcionLogic.setConnexion(this.connexion);
			opcionLogic.getOpcionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalOpcion.equals("NONE")) {
				opcionLogic.getTodosOpcions(finalQueryGlobalOpcion,new Pagination());
				opcionsForeignKey=opcionLogic.getOpcions();
			}

			usuarioopcionReturnGeneral.setopcionsForeignKey(opcionsForeignKey);


			List<Perfil> perfilsForeignKey=new ArrayList<Perfil>();
			PerfilLogic perfilLogic=new PerfilLogic();
			perfilLogic.setConnexion(this.connexion);
			perfilLogic.getPerfilDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPerfil.equals("NONE")) {
				perfilLogic.getTodosPerfils(finalQueryGlobalPerfil,new Pagination());
				perfilsForeignKey=perfilLogic.getPerfils();
			}

			usuarioopcionReturnGeneral.setperfilsForeignKey(perfilsForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			usuarioopcionReturnGeneral.setusuariosForeignKey(usuariosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return usuarioopcionReturnGeneral;
	}
	
	
	public void deepLoad(UsuarioOpcion usuarioopcion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			UsuarioOpcionLogicAdditional.updateUsuarioOpcionToGet(usuarioopcion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		usuarioopcion.setSistema(usuarioopcionDataAccess.getSistema(connexion,usuarioopcion));
		usuarioopcion.setModulo(usuarioopcionDataAccess.getModulo(connexion,usuarioopcion));
		usuarioopcion.setGrupoOpcion(usuarioopcionDataAccess.getGrupoOpcion(connexion,usuarioopcion));
		usuarioopcion.setOpcion(usuarioopcionDataAccess.getOpcion(connexion,usuarioopcion));
		usuarioopcion.setPerfil(usuarioopcionDataAccess.getPerfil(connexion,usuarioopcion));
		usuarioopcion.setUsuario(usuarioopcionDataAccess.getUsuario(connexion,usuarioopcion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Sistema.class)) {
				usuarioopcion.setSistema(usuarioopcionDataAccess.getSistema(connexion,usuarioopcion));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				usuarioopcion.setModulo(usuarioopcionDataAccess.getModulo(connexion,usuarioopcion));
				continue;
			}

			if(clas.clas.equals(GrupoOpcion.class)) {
				usuarioopcion.setGrupoOpcion(usuarioopcionDataAccess.getGrupoOpcion(connexion,usuarioopcion));
				continue;
			}

			if(clas.clas.equals(Opcion.class)) {
				usuarioopcion.setOpcion(usuarioopcionDataAccess.getOpcion(connexion,usuarioopcion));
				continue;
			}

			if(clas.clas.equals(Perfil.class)) {
				usuarioopcion.setPerfil(usuarioopcionDataAccess.getPerfil(connexion,usuarioopcion));
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				usuarioopcion.setUsuario(usuarioopcionDataAccess.getUsuario(connexion,usuarioopcion));
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
			usuarioopcion.setSistema(usuarioopcionDataAccess.getSistema(connexion,usuarioopcion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			usuarioopcion.setModulo(usuarioopcionDataAccess.getModulo(connexion,usuarioopcion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GrupoOpcion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			usuarioopcion.setGrupoOpcion(usuarioopcionDataAccess.getGrupoOpcion(connexion,usuarioopcion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Opcion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			usuarioopcion.setOpcion(usuarioopcionDataAccess.getOpcion(connexion,usuarioopcion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Perfil.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			usuarioopcion.setPerfil(usuarioopcionDataAccess.getPerfil(connexion,usuarioopcion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			usuarioopcion.setUsuario(usuarioopcionDataAccess.getUsuario(connexion,usuarioopcion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		usuarioopcion.setSistema(usuarioopcionDataAccess.getSistema(connexion,usuarioopcion));
		SistemaLogic sistemaLogic= new SistemaLogic(connexion);
		sistemaLogic.deepLoad(usuarioopcion.getSistema(),isDeep,deepLoadType,clases);
				
		usuarioopcion.setModulo(usuarioopcionDataAccess.getModulo(connexion,usuarioopcion));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(usuarioopcion.getModulo(),isDeep,deepLoadType,clases);
				
		usuarioopcion.setGrupoOpcion(usuarioopcionDataAccess.getGrupoOpcion(connexion,usuarioopcion));
		GrupoOpcionLogic grupoopcionLogic= new GrupoOpcionLogic(connexion);
		grupoopcionLogic.deepLoad(usuarioopcion.getGrupoOpcion(),isDeep,deepLoadType,clases);
				
		usuarioopcion.setOpcion(usuarioopcionDataAccess.getOpcion(connexion,usuarioopcion));
		OpcionLogic opcionLogic= new OpcionLogic(connexion);
		opcionLogic.deepLoad(usuarioopcion.getOpcion(),isDeep,deepLoadType,clases);
				
		usuarioopcion.setPerfil(usuarioopcionDataAccess.getPerfil(connexion,usuarioopcion));
		PerfilLogic perfilLogic= new PerfilLogic(connexion);
		perfilLogic.deepLoad(usuarioopcion.getPerfil(),isDeep,deepLoadType,clases);
				
		usuarioopcion.setUsuario(usuarioopcionDataAccess.getUsuario(connexion,usuarioopcion));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(usuarioopcion.getUsuario(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Sistema.class)) {
				usuarioopcion.setSistema(usuarioopcionDataAccess.getSistema(connexion,usuarioopcion));
				SistemaLogic sistemaLogic= new SistemaLogic(connexion);
				sistemaLogic.deepLoad(usuarioopcion.getSistema(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				usuarioopcion.setModulo(usuarioopcionDataAccess.getModulo(connexion,usuarioopcion));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(usuarioopcion.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(GrupoOpcion.class)) {
				usuarioopcion.setGrupoOpcion(usuarioopcionDataAccess.getGrupoOpcion(connexion,usuarioopcion));
				GrupoOpcionLogic grupoopcionLogic= new GrupoOpcionLogic(connexion);
				grupoopcionLogic.deepLoad(usuarioopcion.getGrupoOpcion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Opcion.class)) {
				usuarioopcion.setOpcion(usuarioopcionDataAccess.getOpcion(connexion,usuarioopcion));
				OpcionLogic opcionLogic= new OpcionLogic(connexion);
				opcionLogic.deepLoad(usuarioopcion.getOpcion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Perfil.class)) {
				usuarioopcion.setPerfil(usuarioopcionDataAccess.getPerfil(connexion,usuarioopcion));
				PerfilLogic perfilLogic= new PerfilLogic(connexion);
				perfilLogic.deepLoad(usuarioopcion.getPerfil(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				usuarioopcion.setUsuario(usuarioopcionDataAccess.getUsuario(connexion,usuarioopcion));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(usuarioopcion.getUsuario(),isDeep,deepLoadType,clases);				
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
			usuarioopcion.setSistema(usuarioopcionDataAccess.getSistema(connexion,usuarioopcion));
			SistemaLogic sistemaLogic= new SistemaLogic(connexion);
			sistemaLogic.deepLoad(usuarioopcion.getSistema(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			usuarioopcion.setModulo(usuarioopcionDataAccess.getModulo(connexion,usuarioopcion));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(usuarioopcion.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(GrupoOpcion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			usuarioopcion.setGrupoOpcion(usuarioopcionDataAccess.getGrupoOpcion(connexion,usuarioopcion));
			GrupoOpcionLogic grupoopcionLogic= new GrupoOpcionLogic(connexion);
			grupoopcionLogic.deepLoad(usuarioopcion.getGrupoOpcion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Opcion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			usuarioopcion.setOpcion(usuarioopcionDataAccess.getOpcion(connexion,usuarioopcion));
			OpcionLogic opcionLogic= new OpcionLogic(connexion);
			opcionLogic.deepLoad(usuarioopcion.getOpcion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Perfil.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			usuarioopcion.setPerfil(usuarioopcionDataAccess.getPerfil(connexion,usuarioopcion));
			PerfilLogic perfilLogic= new PerfilLogic(connexion);
			perfilLogic.deepLoad(usuarioopcion.getPerfil(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			usuarioopcion.setUsuario(usuarioopcionDataAccess.getUsuario(connexion,usuarioopcion));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(usuarioopcion.getUsuario(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(UsuarioOpcion usuarioopcion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			UsuarioOpcionLogicAdditional.updateUsuarioOpcionToSave(usuarioopcion,this.arrDatoGeneral);
			
UsuarioOpcionDataAccess.save(usuarioopcion, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		SistemaDataAccess.save(usuarioopcion.getSistema(),connexion);

		ModuloDataAccess.save(usuarioopcion.getModulo(),connexion);

		GrupoOpcionDataAccess.save(usuarioopcion.getGrupoOpcion(),connexion);

		OpcionDataAccess.save(usuarioopcion.getOpcion(),connexion);

		PerfilDataAccess.save(usuarioopcion.getPerfil(),connexion);

		UsuarioDataAccess.save(usuarioopcion.getUsuario(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Sistema.class)) {
				SistemaDataAccess.save(usuarioopcion.getSistema(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(usuarioopcion.getModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(GrupoOpcion.class)) {
				GrupoOpcionDataAccess.save(usuarioopcion.getGrupoOpcion(),connexion);
				continue;
			}

			if(clas.clas.equals(Opcion.class)) {
				OpcionDataAccess.save(usuarioopcion.getOpcion(),connexion);
				continue;
			}

			if(clas.clas.equals(Perfil.class)) {
				PerfilDataAccess.save(usuarioopcion.getPerfil(),connexion);
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(usuarioopcion.getUsuario(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		SistemaDataAccess.save(usuarioopcion.getSistema(),connexion);
		SistemaLogic sistemaLogic= new SistemaLogic(connexion);
		sistemaLogic.deepLoad(usuarioopcion.getSistema(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(usuarioopcion.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(usuarioopcion.getModulo(),isDeep,deepLoadType,clases);
				

		GrupoOpcionDataAccess.save(usuarioopcion.getGrupoOpcion(),connexion);
		GrupoOpcionLogic grupoopcionLogic= new GrupoOpcionLogic(connexion);
		grupoopcionLogic.deepLoad(usuarioopcion.getGrupoOpcion(),isDeep,deepLoadType,clases);
				

		OpcionDataAccess.save(usuarioopcion.getOpcion(),connexion);
		OpcionLogic opcionLogic= new OpcionLogic(connexion);
		opcionLogic.deepLoad(usuarioopcion.getOpcion(),isDeep,deepLoadType,clases);
				

		PerfilDataAccess.save(usuarioopcion.getPerfil(),connexion);
		PerfilLogic perfilLogic= new PerfilLogic(connexion);
		perfilLogic.deepLoad(usuarioopcion.getPerfil(),isDeep,deepLoadType,clases);
				

		UsuarioDataAccess.save(usuarioopcion.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(usuarioopcion.getUsuario(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Sistema.class)) {
				SistemaDataAccess.save(usuarioopcion.getSistema(),connexion);
				SistemaLogic sistemaLogic= new SistemaLogic(connexion);
				sistemaLogic.deepSave(usuarioopcion.getSistema(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(usuarioopcion.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(usuarioopcion.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(GrupoOpcion.class)) {
				GrupoOpcionDataAccess.save(usuarioopcion.getGrupoOpcion(),connexion);
				GrupoOpcionLogic grupoopcionLogic= new GrupoOpcionLogic(connexion);
				grupoopcionLogic.deepSave(usuarioopcion.getGrupoOpcion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Opcion.class)) {
				OpcionDataAccess.save(usuarioopcion.getOpcion(),connexion);
				OpcionLogic opcionLogic= new OpcionLogic(connexion);
				opcionLogic.deepSave(usuarioopcion.getOpcion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Perfil.class)) {
				PerfilDataAccess.save(usuarioopcion.getPerfil(),connexion);
				PerfilLogic perfilLogic= new PerfilLogic(connexion);
				perfilLogic.deepSave(usuarioopcion.getPerfil(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(usuarioopcion.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(usuarioopcion.getUsuario(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(UsuarioOpcion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(usuarioopcion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				UsuarioOpcionConstantesFunciones.refrescarForeignKeysDescripcionesUsuarioOpcion(usuarioopcion);
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
			this.deepLoad(this.usuarioopcion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				UsuarioOpcionConstantesFunciones.refrescarForeignKeysDescripcionesUsuarioOpcion(this.usuarioopcion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(UsuarioOpcion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(usuarioopcions!=null) {
				for(UsuarioOpcion usuarioopcion:usuarioopcions) {
					this.deepLoad(usuarioopcion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					UsuarioOpcionConstantesFunciones.refrescarForeignKeysDescripcionesUsuarioOpcion(usuarioopcions);
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
			if(usuarioopcions!=null) {
				for(UsuarioOpcion usuarioopcion:usuarioopcions) {
					this.deepLoad(usuarioopcion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					UsuarioOpcionConstantesFunciones.refrescarForeignKeysDescripcionesUsuarioOpcion(usuarioopcions);
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
			this.getNewConnexionToDeep(UsuarioOpcion.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(usuarioopcion,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(UsuarioOpcion.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(usuarioopcions!=null) {
				for(UsuarioOpcion usuarioopcion:usuarioopcions) {
					this.deepSave(usuarioopcion,isDeep,deepLoadType,clases);
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
			if(usuarioopcions!=null) {
				for(UsuarioOpcion usuarioopcion:usuarioopcions) {
					this.deepSave(usuarioopcion,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getUsuarioOpcionsFK_IdGrupoOpcionWithConnection(String sFinalQuery,Pagination pagination,Long id_grupo_opcion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UsuarioOpcion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidGrupoOpcion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidGrupoOpcion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_grupo_opcion,UsuarioOpcionConstantesFunciones.IDGRUPOOPCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidGrupoOpcion);

			UsuarioOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdGrupoOpcion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			usuarioopcions=usuarioopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UsuarioOpcionConstantesFunciones.refrescarForeignKeysDescripcionesUsuarioOpcion(this.usuarioopcions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getUsuarioOpcionsFK_IdGrupoOpcion(String sFinalQuery,Pagination pagination,Long id_grupo_opcion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidGrupoOpcion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidGrupoOpcion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_grupo_opcion,UsuarioOpcionConstantesFunciones.IDGRUPOOPCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidGrupoOpcion);

			UsuarioOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdGrupoOpcion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			usuarioopcions=usuarioopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UsuarioOpcionConstantesFunciones.refrescarForeignKeysDescripcionesUsuarioOpcion(this.usuarioopcions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getUsuarioOpcionsFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UsuarioOpcion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,UsuarioOpcionConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			UsuarioOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			usuarioopcions=usuarioopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UsuarioOpcionConstantesFunciones.refrescarForeignKeysDescripcionesUsuarioOpcion(this.usuarioopcions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getUsuarioOpcionsFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,UsuarioOpcionConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			UsuarioOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			usuarioopcions=usuarioopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UsuarioOpcionConstantesFunciones.refrescarForeignKeysDescripcionesUsuarioOpcion(this.usuarioopcions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getUsuarioOpcionsFK_IdOpcionWithConnection(String sFinalQuery,Pagination pagination,Long id_opcion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UsuarioOpcion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidOpcion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidOpcion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_opcion,UsuarioOpcionConstantesFunciones.IDOPCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidOpcion);

			UsuarioOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdOpcion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			usuarioopcions=usuarioopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UsuarioOpcionConstantesFunciones.refrescarForeignKeysDescripcionesUsuarioOpcion(this.usuarioopcions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getUsuarioOpcionsFK_IdOpcion(String sFinalQuery,Pagination pagination,Long id_opcion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidOpcion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidOpcion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_opcion,UsuarioOpcionConstantesFunciones.IDOPCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidOpcion);

			UsuarioOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdOpcion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			usuarioopcions=usuarioopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UsuarioOpcionConstantesFunciones.refrescarForeignKeysDescripcionesUsuarioOpcion(this.usuarioopcions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getUsuarioOpcionsFK_IdPerfilWithConnection(String sFinalQuery,Pagination pagination,Long id_perfil)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UsuarioOpcion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPerfil= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPerfil.setParameterSelectionGeneralEqual(ParameterType.LONG,id_perfil,UsuarioOpcionConstantesFunciones.IDPERFIL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPerfil);

			UsuarioOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPerfil","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			usuarioopcions=usuarioopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UsuarioOpcionConstantesFunciones.refrescarForeignKeysDescripcionesUsuarioOpcion(this.usuarioopcions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getUsuarioOpcionsFK_IdPerfil(String sFinalQuery,Pagination pagination,Long id_perfil)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPerfil= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPerfil.setParameterSelectionGeneralEqual(ParameterType.LONG,id_perfil,UsuarioOpcionConstantesFunciones.IDPERFIL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPerfil);

			UsuarioOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPerfil","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			usuarioopcions=usuarioopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UsuarioOpcionConstantesFunciones.refrescarForeignKeysDescripcionesUsuarioOpcion(this.usuarioopcions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getUsuarioOpcionsFK_IdSistemaWithConnection(String sFinalQuery,Pagination pagination,Long id_sistema)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UsuarioOpcion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSistema= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSistema.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sistema,UsuarioOpcionConstantesFunciones.IDSISTEMA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSistema);

			UsuarioOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSistema","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			usuarioopcions=usuarioopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UsuarioOpcionConstantesFunciones.refrescarForeignKeysDescripcionesUsuarioOpcion(this.usuarioopcions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getUsuarioOpcionsFK_IdSistema(String sFinalQuery,Pagination pagination,Long id_sistema)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSistema= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSistema.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sistema,UsuarioOpcionConstantesFunciones.IDSISTEMA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSistema);

			UsuarioOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSistema","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			usuarioopcions=usuarioopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UsuarioOpcionConstantesFunciones.refrescarForeignKeysDescripcionesUsuarioOpcion(this.usuarioopcions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getUsuarioOpcionsFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UsuarioOpcion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,UsuarioOpcionConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			UsuarioOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			usuarioopcions=usuarioopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UsuarioOpcionConstantesFunciones.refrescarForeignKeysDescripcionesUsuarioOpcion(this.usuarioopcions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getUsuarioOpcionsFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,UsuarioOpcionConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			UsuarioOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			usuarioopcions=usuarioopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UsuarioOpcionConstantesFunciones.refrescarForeignKeysDescripcionesUsuarioOpcion(this.usuarioopcions);
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
			if(UsuarioOpcionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				//auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,UsuarioOpcionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,UsuarioOpcion usuarioopcion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		//AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		//auditoriaLogicAdditional.setConnexion(connexion);
		//AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(UsuarioOpcionConstantesFunciones.ISCONAUDITORIA) {
				if(usuarioopcion.getIsNew()) {
					//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,UsuarioOpcionDataAccess.TABLENAME, usuarioopcion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(UsuarioOpcionConstantesFunciones.ISCONAUDITORIADETALLE) {
						//UsuarioOpcionLogic.registrarAuditoriaDetallesUsuarioOpcion(connexion,usuarioopcion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(usuarioopcion.getIsDeleted()) {
					/*if(!usuarioopcion.getIsExpired()) {
						//auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,UsuarioOpcionDataAccess.TABLENAME, usuarioopcion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						//UsuarioOpcionLogic.registrarAuditoriaDetallesUsuarioOpcion(connexion,usuarioopcion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,UsuarioOpcionDataAccess.TABLENAME, usuarioopcion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(usuarioopcion.getIsChanged()) {
					//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,UsuarioOpcionDataAccess.TABLENAME, usuarioopcion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(UsuarioOpcionConstantesFunciones.ISCONAUDITORIADETALLE) {
						//UsuarioOpcionLogic.registrarAuditoriaDetallesUsuarioOpcion(connexion,usuarioopcion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesUsuarioOpcion(Connexion connexion,UsuarioOpcion usuarioopcion)throws Exception {		
		//AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		//auditoriaDetalleLogicAdditional.setConnexion(connexion);
		//AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(usuarioopcion.getIsNew()||!usuarioopcion.getid_sistema().equals(usuarioopcion.getUsuarioOpcionOriginal().getid_sistema()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(usuarioopcion.getUsuarioOpcionOriginal().getid_sistema()!=null)
				{
					strValorActual=usuarioopcion.getUsuarioOpcionOriginal().getid_sistema().toString();
				}
				if(usuarioopcion.getid_sistema()!=null)
				{
					strValorNuevo=usuarioopcion.getid_sistema().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UsuarioOpcionConstantesFunciones.IDSISTEMA,strValorActual,strValorNuevo);
			}	
			
			if(usuarioopcion.getIsNew()||!usuarioopcion.getid_modulo().equals(usuarioopcion.getUsuarioOpcionOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(usuarioopcion.getUsuarioOpcionOriginal().getid_modulo()!=null)
				{
					strValorActual=usuarioopcion.getUsuarioOpcionOriginal().getid_modulo().toString();
				}
				if(usuarioopcion.getid_modulo()!=null)
				{
					strValorNuevo=usuarioopcion.getid_modulo().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UsuarioOpcionConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(usuarioopcion.getIsNew()||!usuarioopcion.getid_grupo_opcion().equals(usuarioopcion.getUsuarioOpcionOriginal().getid_grupo_opcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(usuarioopcion.getUsuarioOpcionOriginal().getid_grupo_opcion()!=null)
				{
					strValorActual=usuarioopcion.getUsuarioOpcionOriginal().getid_grupo_opcion().toString();
				}
				if(usuarioopcion.getid_grupo_opcion()!=null)
				{
					strValorNuevo=usuarioopcion.getid_grupo_opcion().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UsuarioOpcionConstantesFunciones.IDGRUPOOPCION,strValorActual,strValorNuevo);
			}	
			
			if(usuarioopcion.getIsNew()||!usuarioopcion.getid_opcion().equals(usuarioopcion.getUsuarioOpcionOriginal().getid_opcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(usuarioopcion.getUsuarioOpcionOriginal().getid_opcion()!=null)
				{
					strValorActual=usuarioopcion.getUsuarioOpcionOriginal().getid_opcion().toString();
				}
				if(usuarioopcion.getid_opcion()!=null)
				{
					strValorNuevo=usuarioopcion.getid_opcion().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UsuarioOpcionConstantesFunciones.IDOPCION,strValorActual,strValorNuevo);
			}	
			
			if(usuarioopcion.getIsNew()||!usuarioopcion.getid_perfil().equals(usuarioopcion.getUsuarioOpcionOriginal().getid_perfil()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(usuarioopcion.getUsuarioOpcionOriginal().getid_perfil()!=null)
				{
					strValorActual=usuarioopcion.getUsuarioOpcionOriginal().getid_perfil().toString();
				}
				if(usuarioopcion.getid_perfil()!=null)
				{
					strValorNuevo=usuarioopcion.getid_perfil().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UsuarioOpcionConstantesFunciones.IDPERFIL,strValorActual,strValorNuevo);
			}	
			
			if(usuarioopcion.getIsNew()||!usuarioopcion.getid_usuario().equals(usuarioopcion.getUsuarioOpcionOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(usuarioopcion.getUsuarioOpcionOriginal().getid_usuario()!=null)
				{
					strValorActual=usuarioopcion.getUsuarioOpcionOriginal().getid_usuario().toString();
				}
				if(usuarioopcion.getid_usuario()!=null)
				{
					strValorNuevo=usuarioopcion.getid_usuario().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UsuarioOpcionConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(usuarioopcion.getIsNew()||!usuarioopcion.getcon_precargar().equals(usuarioopcion.getUsuarioOpcionOriginal().getcon_precargar()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(usuarioopcion.getUsuarioOpcionOriginal().getcon_precargar()!=null)
				{
					strValorActual=usuarioopcion.getUsuarioOpcionOriginal().getcon_precargar().toString();
				}
				if(usuarioopcion.getcon_precargar()!=null)
				{
					strValorNuevo=usuarioopcion.getcon_precargar().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UsuarioOpcionConstantesFunciones.CONPRECARGAR,strValorActual,strValorNuevo);
			}	
			
			if(usuarioopcion.getIsNew()||!usuarioopcion.getestado().equals(usuarioopcion.getUsuarioOpcionOriginal().getestado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(usuarioopcion.getUsuarioOpcionOriginal().getestado()!=null)
				{
					strValorActual=usuarioopcion.getUsuarioOpcionOriginal().getestado().toString();
				}
				if(usuarioopcion.getestado()!=null)
				{
					strValorNuevo=usuarioopcion.getestado().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UsuarioOpcionConstantesFunciones.ESTADO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveUsuarioOpcionRelacionesWithConnection(UsuarioOpcion usuarioopcion) throws Exception {

		if(!usuarioopcion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveUsuarioOpcionRelacionesBase(usuarioopcion,true);
		}
	}

	public void saveUsuarioOpcionRelaciones(UsuarioOpcion usuarioopcion)throws Exception {

		if(!usuarioopcion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveUsuarioOpcionRelacionesBase(usuarioopcion,false);
		}
	}

	public void saveUsuarioOpcionRelacionesBase(UsuarioOpcion usuarioopcion,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("UsuarioOpcion-saveRelacionesWithConnection");}
	

			this.setUsuarioOpcion(usuarioopcion);

			if(UsuarioOpcionLogicAdditional.validarSaveRelaciones(usuarioopcion,this)) {

				UsuarioOpcionLogicAdditional.updateRelacionesToSave(usuarioopcion,this);

				if((usuarioopcion.getIsNew()||usuarioopcion.getIsChanged())&&!usuarioopcion.getIsDeleted()) {
					this.saveUsuarioOpcion();
					this.saveUsuarioOpcionRelacionesDetalles();

				} else if(usuarioopcion.getIsDeleted()) {
					this.saveUsuarioOpcionRelacionesDetalles();
					this.saveUsuarioOpcion();
				}

				UsuarioOpcionLogicAdditional.updateRelacionesToSaveAfter(usuarioopcion,this);

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
	
	
	private void saveUsuarioOpcionRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfUsuarioOpcion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=UsuarioOpcionConstantesFunciones.getClassesForeignKeysOfUsuarioOpcion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfUsuarioOpcion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=UsuarioOpcionConstantesFunciones.getClassesRelationshipsOfUsuarioOpcion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

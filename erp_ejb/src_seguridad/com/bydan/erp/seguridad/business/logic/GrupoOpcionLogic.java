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
import com.bydan.erp.seguridad.util.GrupoOpcionConstantesFunciones;
import com.bydan.erp.seguridad.util.GrupoOpcionParameterReturnGeneral;
//import com.bydan.erp.seguridad.util.GrupoOpcionParameterGeneral;
import com.bydan.erp.seguridad.business.entity.GrupoOpcion;
import com.bydan.erp.seguridad.business.logic.GrupoOpcionLogicAdditional;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.seguridad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class GrupoOpcionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(GrupoOpcionLogic.class);
	
	protected GrupoOpcionDataAccess grupoopcionDataAccess; 	
	protected GrupoOpcion grupoopcion;
	protected List<GrupoOpcion> grupoopcions;
	protected Object grupoopcionObject;	
	protected List<Object> grupoopcionsObject;
	
	public static ClassValidator<GrupoOpcion> grupoopcionValidator = new ClassValidator<GrupoOpcion>(GrupoOpcion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected GrupoOpcionLogicAdditional grupoopcionLogicAdditional=null;
	
	public GrupoOpcionLogicAdditional getGrupoOpcionLogicAdditional() {
		return this.grupoopcionLogicAdditional;
	}
	
	public void setGrupoOpcionLogicAdditional(GrupoOpcionLogicAdditional grupoopcionLogicAdditional) {
		try {
			this.grupoopcionLogicAdditional=grupoopcionLogicAdditional;
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
	
	
	
	
	public  GrupoOpcionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.grupoopcionDataAccess = new GrupoOpcionDataAccess();
			
			this.grupoopcions= new ArrayList<GrupoOpcion>();
			this.grupoopcion= new GrupoOpcion();
			
			this.grupoopcionObject=new Object();
			this.grupoopcionsObject=new ArrayList<Object>();
				
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
			
			this.grupoopcionDataAccess.setConnexionType(this.connexionType);
			this.grupoopcionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  GrupoOpcionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.grupoopcionDataAccess = new GrupoOpcionDataAccess();
			this.grupoopcions= new ArrayList<GrupoOpcion>();
			this.grupoopcion= new GrupoOpcion();
			this.grupoopcionObject=new Object();
			this.grupoopcionsObject=new ArrayList<Object>();
			
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
			
			this.grupoopcionDataAccess.setConnexionType(this.connexionType);
			this.grupoopcionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public GrupoOpcion getGrupoOpcion() throws Exception {	
		GrupoOpcionLogicAdditional.checkGrupoOpcionToGet(grupoopcion,this.datosCliente,this.arrDatoGeneral);
		GrupoOpcionLogicAdditional.updateGrupoOpcionToGet(grupoopcion,this.arrDatoGeneral);
		
		return grupoopcion;
	}
		
	public void setGrupoOpcion(GrupoOpcion newGrupoOpcion) {
		this.grupoopcion = newGrupoOpcion;
	}
	
	public GrupoOpcionDataAccess getGrupoOpcionDataAccess() {
		return grupoopcionDataAccess;
	}
	
	public void setGrupoOpcionDataAccess(GrupoOpcionDataAccess newgrupoopcionDataAccess) {
		this.grupoopcionDataAccess = newgrupoopcionDataAccess;
	}
	
	public List<GrupoOpcion> getGrupoOpcions() throws Exception {		
		this.quitarGrupoOpcionsNulos();
		
		GrupoOpcionLogicAdditional.checkGrupoOpcionToGets(grupoopcions,this.datosCliente,this.arrDatoGeneral);
		
		for (GrupoOpcion grupoopcionLocal: grupoopcions ) {
			GrupoOpcionLogicAdditional.updateGrupoOpcionToGet(grupoopcionLocal,this.arrDatoGeneral);
		}
		
		return grupoopcions;
	}
	
	public void setGrupoOpcions(List<GrupoOpcion> newGrupoOpcions) {
		this.grupoopcions = newGrupoOpcions;
	}
	
	public Object getGrupoOpcionObject() {	
		this.grupoopcionObject=this.grupoopcionDataAccess.getEntityObject();
		return this.grupoopcionObject;
	}
		
	public void setGrupoOpcionObject(Object newGrupoOpcionObject) {
		this.grupoopcionObject = newGrupoOpcionObject;
	}
	
	public List<Object> getGrupoOpcionsObject() {		
		this.grupoopcionsObject=this.grupoopcionDataAccess.getEntitiesObject();
		return this.grupoopcionsObject;
	}
		
	public void setGrupoOpcionsObject(List<Object> newGrupoOpcionsObject) {
		this.grupoopcionsObject = newGrupoOpcionsObject;
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
		
		if(this.grupoopcionDataAccess!=null) {
			this.grupoopcionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoOpcion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			grupoopcionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			grupoopcionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		grupoopcion = new  GrupoOpcion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoOpcion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			grupoopcion=grupoopcionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.grupoopcion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GrupoOpcionConstantesFunciones.refrescarForeignKeysDescripcionesGrupoOpcion(this.grupoopcion);
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
		grupoopcion = new  GrupoOpcion();
		  		  
        try {
			
			grupoopcion=grupoopcionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.grupoopcion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GrupoOpcionConstantesFunciones.refrescarForeignKeysDescripcionesGrupoOpcion(this.grupoopcion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		grupoopcion = new  GrupoOpcion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoOpcion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			grupoopcion=grupoopcionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.grupoopcion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GrupoOpcionConstantesFunciones.refrescarForeignKeysDescripcionesGrupoOpcion(this.grupoopcion);
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
		grupoopcion = new  GrupoOpcion();
		  		  
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
		grupoopcion = new  GrupoOpcion();
		  		  
        try {
			
			grupoopcion=grupoopcionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.grupoopcion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				GrupoOpcionConstantesFunciones.refrescarForeignKeysDescripcionesGrupoOpcion(this.grupoopcion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		grupoopcion = new  GrupoOpcion();
		  		  
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
		grupoopcion = new  GrupoOpcion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoOpcion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =grupoopcionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		grupoopcion = new  GrupoOpcion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=grupoopcionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		grupoopcion = new  GrupoOpcion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoOpcion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =grupoopcionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		grupoopcion = new  GrupoOpcion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=grupoopcionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		grupoopcion = new  GrupoOpcion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoOpcion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =grupoopcionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		grupoopcion = new  GrupoOpcion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=grupoopcionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		grupoopcions = new  ArrayList<GrupoOpcion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoOpcion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			GrupoOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoopcions=grupoopcionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGrupoOpcion(grupoopcions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoOpcionConstantesFunciones.refrescarForeignKeysDescripcionesGrupoOpcion(this.grupoopcions);
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
		grupoopcions = new  ArrayList<GrupoOpcion>();
		  		  
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
		grupoopcions = new  ArrayList<GrupoOpcion>();
		  		  
        try {			
			GrupoOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoopcions=grupoopcionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarGrupoOpcion(grupoopcions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoOpcionConstantesFunciones.refrescarForeignKeysDescripcionesGrupoOpcion(this.grupoopcions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		grupoopcions = new  ArrayList<GrupoOpcion>();
		  		  
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
		grupoopcions = new  ArrayList<GrupoOpcion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoOpcion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			GrupoOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoopcions=grupoopcionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGrupoOpcion(grupoopcions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoOpcionConstantesFunciones.refrescarForeignKeysDescripcionesGrupoOpcion(this.grupoopcions);
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
		grupoopcions = new  ArrayList<GrupoOpcion>();
		  		  
        try {
			GrupoOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoopcions=grupoopcionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGrupoOpcion(grupoopcions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoOpcionConstantesFunciones.refrescarForeignKeysDescripcionesGrupoOpcion(this.grupoopcions);
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
		grupoopcions = new  ArrayList<GrupoOpcion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoOpcion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GrupoOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoopcions=grupoopcionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGrupoOpcion(grupoopcions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoOpcionConstantesFunciones.refrescarForeignKeysDescripcionesGrupoOpcion(this.grupoopcions);
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
		grupoopcions = new  ArrayList<GrupoOpcion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GrupoOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoopcions=grupoopcionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGrupoOpcion(grupoopcions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoOpcionConstantesFunciones.refrescarForeignKeysDescripcionesGrupoOpcion(this.grupoopcions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		grupoopcion = new  GrupoOpcion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoOpcion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GrupoOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoopcion=grupoopcionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGrupoOpcion(grupoopcion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoOpcionConstantesFunciones.refrescarForeignKeysDescripcionesGrupoOpcion(this.grupoopcion);
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
		grupoopcion = new  GrupoOpcion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GrupoOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoopcion=grupoopcionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarGrupoOpcion(grupoopcion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoOpcionConstantesFunciones.refrescarForeignKeysDescripcionesGrupoOpcion(this.grupoopcion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		grupoopcions = new  ArrayList<GrupoOpcion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoOpcion.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			GrupoOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoopcions=grupoopcionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGrupoOpcion(grupoopcions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoOpcionConstantesFunciones.refrescarForeignKeysDescripcionesGrupoOpcion(this.grupoopcions);
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
		grupoopcions = new  ArrayList<GrupoOpcion>();
		  		  
        try {
			GrupoOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoopcions=grupoopcionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarGrupoOpcion(grupoopcions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoOpcionConstantesFunciones.refrescarForeignKeysDescripcionesGrupoOpcion(this.grupoopcions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosGrupoOpcionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		grupoopcions = new  ArrayList<GrupoOpcion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoOpcion.class.getSimpleName()+"-getTodosGrupoOpcionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GrupoOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoopcions=grupoopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarGrupoOpcion(grupoopcions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoOpcionConstantesFunciones.refrescarForeignKeysDescripcionesGrupoOpcion(this.grupoopcions);
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
	
	public  void  getTodosGrupoOpcions(String sFinalQuery,Pagination pagination)throws Exception {
		grupoopcions = new  ArrayList<GrupoOpcion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			GrupoOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			grupoopcions=grupoopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarGrupoOpcion(grupoopcions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				GrupoOpcionConstantesFunciones.refrescarForeignKeysDescripcionesGrupoOpcion(this.grupoopcions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarGrupoOpcion(GrupoOpcion grupoopcion) throws Exception {
		Boolean estaValidado=false;
		
		if(grupoopcion.getIsNew() || grupoopcion.getIsChanged()) { 
			this.invalidValues = grupoopcionValidator.getInvalidValues(grupoopcion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(grupoopcion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarGrupoOpcion(List<GrupoOpcion> GrupoOpcions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(GrupoOpcion grupoopcionLocal:grupoopcions) {				
			estaValidadoObjeto=this.validarGuardarGrupoOpcion(grupoopcionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarGrupoOpcion(List<GrupoOpcion> GrupoOpcions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarGrupoOpcion(grupoopcions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarGrupoOpcion(GrupoOpcion GrupoOpcion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarGrupoOpcion(grupoopcion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(GrupoOpcion grupoopcion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+grupoopcion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=GrupoOpcionConstantesFunciones.getGrupoOpcionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"grupoopcion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(GrupoOpcionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(GrupoOpcionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveGrupoOpcionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoOpcion.class.getSimpleName()+"-saveGrupoOpcionWithConnection");connexion.begin();			
			
			GrupoOpcionLogicAdditional.checkGrupoOpcionToSave(this.grupoopcion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			GrupoOpcionLogicAdditional.updateGrupoOpcionToSave(this.grupoopcion,this.arrDatoGeneral);
			
			GrupoOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.grupoopcion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowGrupoOpcion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarGrupoOpcion(this.grupoopcion)) {
				GrupoOpcionDataAccess.save(this.grupoopcion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.grupoopcion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			GrupoOpcionLogicAdditional.checkGrupoOpcionToSaveAfter(this.grupoopcion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowGrupoOpcion();
			
			connexion.commit();			
			
			if(this.grupoopcion.getIsDeleted()) {
				this.grupoopcion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveGrupoOpcion()throws Exception {	
		try {	
			
			GrupoOpcionLogicAdditional.checkGrupoOpcionToSave(this.grupoopcion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			GrupoOpcionLogicAdditional.updateGrupoOpcionToSave(this.grupoopcion,this.arrDatoGeneral);
			
			GrupoOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.grupoopcion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarGrupoOpcion(this.grupoopcion)) {			
				GrupoOpcionDataAccess.save(this.grupoopcion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.grupoopcion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			GrupoOpcionLogicAdditional.checkGrupoOpcionToSaveAfter(this.grupoopcion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.grupoopcion.getIsDeleted()) {
				this.grupoopcion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveGrupoOpcionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoOpcion.class.getSimpleName()+"-saveGrupoOpcionsWithConnection");connexion.begin();			
			
			GrupoOpcionLogicAdditional.checkGrupoOpcionToSaves(grupoopcions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowGrupoOpcions();
			
			Boolean validadoTodosGrupoOpcion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(GrupoOpcion grupoopcionLocal:grupoopcions) {		
				if(grupoopcionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				GrupoOpcionLogicAdditional.updateGrupoOpcionToSave(grupoopcionLocal,this.arrDatoGeneral);
	        	
				GrupoOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),grupoopcionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarGrupoOpcion(grupoopcionLocal)) {
					GrupoOpcionDataAccess.save(grupoopcionLocal, connexion);				
				} else {
					validadoTodosGrupoOpcion=false;
				}
			}
			
			if(!validadoTodosGrupoOpcion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			GrupoOpcionLogicAdditional.checkGrupoOpcionToSavesAfter(grupoopcions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowGrupoOpcions();
			
			connexion.commit();		
			
			this.quitarGrupoOpcionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveGrupoOpcions()throws Exception {				
		 try {	
			GrupoOpcionLogicAdditional.checkGrupoOpcionToSaves(grupoopcions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosGrupoOpcion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(GrupoOpcion grupoopcionLocal:grupoopcions) {				
				if(grupoopcionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				GrupoOpcionLogicAdditional.updateGrupoOpcionToSave(grupoopcionLocal,this.arrDatoGeneral);
	        	
				GrupoOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),grupoopcionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarGrupoOpcion(grupoopcionLocal)) {				
					GrupoOpcionDataAccess.save(grupoopcionLocal, connexion);				
				} else {
					validadoTodosGrupoOpcion=false;
				}
			}
			
			if(!validadoTodosGrupoOpcion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			GrupoOpcionLogicAdditional.checkGrupoOpcionToSavesAfter(grupoopcions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarGrupoOpcionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public GrupoOpcionParameterReturnGeneral procesarAccionGrupoOpcions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<GrupoOpcion> grupoopcions,GrupoOpcionParameterReturnGeneral grupoopcionParameterGeneral)throws Exception {
		 try {	
			GrupoOpcionParameterReturnGeneral grupoopcionReturnGeneral=new GrupoOpcionParameterReturnGeneral();
	
			GrupoOpcionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,grupoopcions,grupoopcionParameterGeneral,grupoopcionReturnGeneral);
			
			return grupoopcionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public GrupoOpcionParameterReturnGeneral procesarAccionGrupoOpcionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<GrupoOpcion> grupoopcions,GrupoOpcionParameterReturnGeneral grupoopcionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoOpcion.class.getSimpleName()+"-procesarAccionGrupoOpcionsWithConnection");connexion.begin();			
			
			GrupoOpcionParameterReturnGeneral grupoopcionReturnGeneral=new GrupoOpcionParameterReturnGeneral();
	
			GrupoOpcionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,grupoopcions,grupoopcionParameterGeneral,grupoopcionReturnGeneral);
			
			this.connexion.commit();
			
			return grupoopcionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public GrupoOpcionParameterReturnGeneral procesarEventosGrupoOpcions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<GrupoOpcion> grupoopcions,GrupoOpcion grupoopcion,GrupoOpcionParameterReturnGeneral grupoopcionParameterGeneral,Boolean isEsNuevoGrupoOpcion,ArrayList<Classe> clases)throws Exception {
		 try {	
			GrupoOpcionParameterReturnGeneral grupoopcionReturnGeneral=new GrupoOpcionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				grupoopcionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			GrupoOpcionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,grupoopcions,grupoopcion,grupoopcionParameterGeneral,grupoopcionReturnGeneral,isEsNuevoGrupoOpcion,clases);
			
			return grupoopcionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public GrupoOpcionParameterReturnGeneral procesarEventosGrupoOpcionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<GrupoOpcion> grupoopcions,GrupoOpcion grupoopcion,GrupoOpcionParameterReturnGeneral grupoopcionParameterGeneral,Boolean isEsNuevoGrupoOpcion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoOpcion.class.getSimpleName()+"-procesarEventosGrupoOpcionsWithConnection");connexion.begin();			
			
			GrupoOpcionParameterReturnGeneral grupoopcionReturnGeneral=new GrupoOpcionParameterReturnGeneral();
	
			grupoopcionReturnGeneral.setGrupoOpcion(grupoopcion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				grupoopcionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			GrupoOpcionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,grupoopcions,grupoopcion,grupoopcionParameterGeneral,grupoopcionReturnGeneral,isEsNuevoGrupoOpcion,clases);
			
			this.connexion.commit();
			
			return grupoopcionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public GrupoOpcionParameterReturnGeneral procesarImportacionGrupoOpcionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,GrupoOpcionParameterReturnGeneral grupoopcionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoOpcion.class.getSimpleName()+"-procesarImportacionGrupoOpcionsWithConnection");connexion.begin();			
			
			GrupoOpcionParameterReturnGeneral grupoopcionReturnGeneral=new GrupoOpcionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.grupoopcions=new ArrayList<GrupoOpcion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.grupoopcion=new GrupoOpcion();
				
				
				if(conColumnasBase) {this.grupoopcion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.grupoopcion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.grupoopcion.setcodigo(arrColumnas[iColumn++]);
				this.grupoopcion.setnombre_principal(arrColumnas[iColumn++]);
				this.grupoopcion.setorden(Integer.parseInt(arrColumnas[iColumn++]));
				this.grupoopcion.setestado(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.grupoopcions.add(this.grupoopcion);
			}
			
			this.saveGrupoOpcions();
			
			this.connexion.commit();
			
			grupoopcionReturnGeneral.setConRetornoEstaProcesado(true);
			grupoopcionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return grupoopcionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarGrupoOpcionsEliminados() throws Exception {				
		
		List<GrupoOpcion> grupoopcionsAux= new ArrayList<GrupoOpcion>();
		
		for(GrupoOpcion grupoopcion:grupoopcions) {
			if(!grupoopcion.getIsDeleted()) {
				grupoopcionsAux.add(grupoopcion);
			}
		}
		
		grupoopcions=grupoopcionsAux;
	}
	
	public void quitarGrupoOpcionsNulos() throws Exception {				
		
		List<GrupoOpcion> grupoopcionsAux= new ArrayList<GrupoOpcion>();
		
		for(GrupoOpcion grupoopcion : this.grupoopcions) {
			if(grupoopcion==null) {
				grupoopcionsAux.add(grupoopcion);
			}
		}
		
		//this.grupoopcions=grupoopcionsAux;
		
		this.grupoopcions.removeAll(grupoopcionsAux);
	}
	
	public void getSetVersionRowGrupoOpcionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(grupoopcion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((grupoopcion.getIsDeleted() || (grupoopcion.getIsChanged()&&!grupoopcion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=grupoopcionDataAccess.getSetVersionRowGrupoOpcion(connexion,grupoopcion.getId());
				
				if(!grupoopcion.getVersionRow().equals(timestamp)) {	
					grupoopcion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				grupoopcion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowGrupoOpcion()throws Exception {	
		
		if(grupoopcion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((grupoopcion.getIsDeleted() || (grupoopcion.getIsChanged()&&!grupoopcion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=grupoopcionDataAccess.getSetVersionRowGrupoOpcion(connexion,grupoopcion.getId());
			
			try {							
				if(!grupoopcion.getVersionRow().equals(timestamp)) {	
					grupoopcion.setVersionRow(timestamp);
				}
				
				grupoopcion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowGrupoOpcionsWithConnection()throws Exception {	
		if(grupoopcions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(GrupoOpcion grupoopcionAux:grupoopcions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(grupoopcionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(grupoopcionAux.getIsDeleted() || (grupoopcionAux.getIsChanged()&&!grupoopcionAux.getIsNew())) {
						
						timestamp=grupoopcionDataAccess.getSetVersionRowGrupoOpcion(connexion,grupoopcionAux.getId());
						
						if(!grupoopcion.getVersionRow().equals(timestamp)) {	
							grupoopcionAux.setVersionRow(timestamp);
						}
								
						grupoopcionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowGrupoOpcions()throws Exception {	
		if(grupoopcions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(GrupoOpcion grupoopcionAux:grupoopcions) {
					if(grupoopcionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(grupoopcionAux.getIsDeleted() || (grupoopcionAux.getIsChanged()&&!grupoopcionAux.getIsNew())) {
						
						timestamp=grupoopcionDataAccess.getSetVersionRowGrupoOpcion(connexion,grupoopcionAux.getId());
						
						if(!grupoopcionAux.getVersionRow().equals(timestamp)) {	
							grupoopcionAux.setVersionRow(timestamp);
						}
						
													
						grupoopcionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public GrupoOpcionParameterReturnGeneral cargarCombosLoteForeignKeyGrupoOpcionWithConnection(String finalQueryGlobalModulo) throws Exception {
		GrupoOpcionParameterReturnGeneral  grupoopcionReturnGeneral =new GrupoOpcionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoOpcion.class.getSimpleName()+"-cargarCombosLoteForeignKeyGrupoOpcionWithConnection");connexion.begin();
			
			grupoopcionReturnGeneral =new GrupoOpcionParameterReturnGeneral();
			
			

			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			grupoopcionReturnGeneral.setmodulosForeignKey(modulosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return grupoopcionReturnGeneral;
	}
	
	public GrupoOpcionParameterReturnGeneral cargarCombosLoteForeignKeyGrupoOpcion(String finalQueryGlobalModulo) throws Exception {
		GrupoOpcionParameterReturnGeneral  grupoopcionReturnGeneral =new GrupoOpcionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			grupoopcionReturnGeneral =new GrupoOpcionParameterReturnGeneral();
			
			

			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			grupoopcionReturnGeneral.setmodulosForeignKey(modulosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return grupoopcionReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyGrupoOpcionWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			UsuarioOpcionLogic usuarioopcionLogic=new UsuarioOpcionLogic();
			OpcionLogic opcionLogic=new OpcionLogic();
			PerfilOpcionLogic perfilopcionLogic=new PerfilOpcionLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoOpcion.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyGrupoOpcionWithConnection");connexion.begin();
			
			
			classes.add(new Classe(UsuarioOpcion.class));
			classes.add(new Classe(Opcion.class));
			classes.add(new Classe(PerfilOpcion.class));
											
			

			usuarioopcionLogic.setConnexion(this.getConnexion());
			usuarioopcionLogic.setDatosCliente(this.datosCliente);
			usuarioopcionLogic.setIsConRefrescarForeignKeys(true);

			opcionLogic.setConnexion(this.getConnexion());
			opcionLogic.setDatosCliente(this.datosCliente);
			opcionLogic.setIsConRefrescarForeignKeys(true);

			perfilopcionLogic.setConnexion(this.getConnexion());
			perfilopcionLogic.setDatosCliente(this.datosCliente);
			perfilopcionLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(GrupoOpcion grupoopcion:this.grupoopcions) {
				

				classes=new ArrayList<Classe>();
				classes=UsuarioOpcionConstantesFunciones.getClassesForeignKeysOfUsuarioOpcion(new ArrayList<Classe>(),DeepLoadType.NONE);

				usuarioopcionLogic.setUsuarioOpcions(grupoopcion.usuarioopcions);
				usuarioopcionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=OpcionConstantesFunciones.getClassesForeignKeysOfOpcion(new ArrayList<Classe>(),DeepLoadType.NONE);

				opcionLogic.setOpcions(grupoopcion.opcions);
				opcionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PerfilOpcionConstantesFunciones.getClassesForeignKeysOfPerfilOpcion(new ArrayList<Classe>(),DeepLoadType.NONE);

				perfilopcionLogic.setPerfilOpcions(grupoopcion.perfilopcions);
				perfilopcionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(GrupoOpcion grupoopcion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			GrupoOpcionLogicAdditional.updateGrupoOpcionToGet(grupoopcion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		grupoopcion.setModulo(grupoopcionDataAccess.getModulo(connexion,grupoopcion));
		grupoopcion.setUsuarioOpcions(grupoopcionDataAccess.getUsuarioOpcions(connexion,grupoopcion));
		grupoopcion.setOpcions(grupoopcionDataAccess.getOpcions(connexion,grupoopcion));
		grupoopcion.setPerfilOpcions(grupoopcionDataAccess.getPerfilOpcions(connexion,grupoopcion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				grupoopcion.setModulo(grupoopcionDataAccess.getModulo(connexion,grupoopcion));
				continue;
			}

			if(clas.clas.equals(UsuarioOpcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				grupoopcion.setUsuarioOpcions(grupoopcionDataAccess.getUsuarioOpcions(connexion,grupoopcion));

				if(this.isConDeep) {
					UsuarioOpcionLogic usuarioopcionLogic= new UsuarioOpcionLogic(this.connexion);
					usuarioopcionLogic.setUsuarioOpcions(grupoopcion.getUsuarioOpcions());
					ArrayList<Classe> classesLocal=UsuarioOpcionConstantesFunciones.getClassesForeignKeysOfUsuarioOpcion(new ArrayList<Classe>(),DeepLoadType.NONE);
					usuarioopcionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					UsuarioOpcionConstantesFunciones.refrescarForeignKeysDescripcionesUsuarioOpcion(usuarioopcionLogic.getUsuarioOpcions());
					grupoopcion.setUsuarioOpcions(usuarioopcionLogic.getUsuarioOpcions());
				}

				continue;
			}

			if(clas.clas.equals(Opcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				grupoopcion.setOpcions(grupoopcionDataAccess.getOpcions(connexion,grupoopcion));

				if(this.isConDeep) {
					OpcionLogic opcionLogic= new OpcionLogic(this.connexion);
					opcionLogic.setOpcions(grupoopcion.getOpcions());
					ArrayList<Classe> classesLocal=OpcionConstantesFunciones.getClassesForeignKeysOfOpcion(new ArrayList<Classe>(),DeepLoadType.NONE);
					opcionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					OpcionConstantesFunciones.refrescarForeignKeysDescripcionesOpcion(opcionLogic.getOpcions());
					grupoopcion.setOpcions(opcionLogic.getOpcions());
				}

				continue;
			}

			if(clas.clas.equals(PerfilOpcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				grupoopcion.setPerfilOpcions(grupoopcionDataAccess.getPerfilOpcions(connexion,grupoopcion));

				if(this.isConDeep) {
					PerfilOpcionLogic perfilopcionLogic= new PerfilOpcionLogic(this.connexion);
					perfilopcionLogic.setPerfilOpcions(grupoopcion.getPerfilOpcions());
					ArrayList<Classe> classesLocal=PerfilOpcionConstantesFunciones.getClassesForeignKeysOfPerfilOpcion(new ArrayList<Classe>(),DeepLoadType.NONE);
					perfilopcionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PerfilOpcionConstantesFunciones.refrescarForeignKeysDescripcionesPerfilOpcion(perfilopcionLogic.getPerfilOpcions());
					grupoopcion.setPerfilOpcions(perfilopcionLogic.getPerfilOpcions());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupoopcion.setModulo(grupoopcionDataAccess.getModulo(connexion,grupoopcion));
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
			grupoopcion.setUsuarioOpcions(grupoopcionDataAccess.getUsuarioOpcions(connexion,grupoopcion));
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
			grupoopcion.setOpcions(grupoopcionDataAccess.getOpcions(connexion,grupoopcion));
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
			grupoopcion.setPerfilOpcions(grupoopcionDataAccess.getPerfilOpcions(connexion,grupoopcion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		grupoopcion.setModulo(grupoopcionDataAccess.getModulo(connexion,grupoopcion));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(grupoopcion.getModulo(),isDeep,deepLoadType,clases);
				

		grupoopcion.setUsuarioOpcions(grupoopcionDataAccess.getUsuarioOpcions(connexion,grupoopcion));

		for(UsuarioOpcion usuarioopcion:grupoopcion.getUsuarioOpcions()) {
			UsuarioOpcionLogic usuarioopcionLogic= new UsuarioOpcionLogic(connexion);
			usuarioopcionLogic.deepLoad(usuarioopcion,isDeep,deepLoadType,clases);
		}

		grupoopcion.setOpcions(grupoopcionDataAccess.getOpcions(connexion,grupoopcion));

		for(Opcion opcion:grupoopcion.getOpcions()) {
			OpcionLogic opcionLogic= new OpcionLogic(connexion);
			opcionLogic.deepLoad(opcion,isDeep,deepLoadType,clases);
		}

		grupoopcion.setPerfilOpcions(grupoopcionDataAccess.getPerfilOpcions(connexion,grupoopcion));

		for(PerfilOpcion perfilopcion:grupoopcion.getPerfilOpcions()) {
			PerfilOpcionLogic perfilopcionLogic= new PerfilOpcionLogic(connexion);
			perfilopcionLogic.deepLoad(perfilopcion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				grupoopcion.setModulo(grupoopcionDataAccess.getModulo(connexion,grupoopcion));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(grupoopcion.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(UsuarioOpcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				grupoopcion.setUsuarioOpcions(grupoopcionDataAccess.getUsuarioOpcions(connexion,grupoopcion));

				for(UsuarioOpcion usuarioopcion:grupoopcion.getUsuarioOpcions()) {
					UsuarioOpcionLogic usuarioopcionLogic= new UsuarioOpcionLogic(connexion);
					usuarioopcionLogic.deepLoad(usuarioopcion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Opcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				grupoopcion.setOpcions(grupoopcionDataAccess.getOpcions(connexion,grupoopcion));

				for(Opcion opcion:grupoopcion.getOpcions()) {
					OpcionLogic opcionLogic= new OpcionLogic(connexion);
					opcionLogic.deepLoad(opcion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PerfilOpcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				grupoopcion.setPerfilOpcions(grupoopcionDataAccess.getPerfilOpcions(connexion,grupoopcion));

				for(PerfilOpcion perfilopcion:grupoopcion.getPerfilOpcions()) {
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
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			grupoopcion.setModulo(grupoopcionDataAccess.getModulo(connexion,grupoopcion));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(grupoopcion.getModulo(),isDeep,deepLoadType,clases);
				
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
			grupoopcion.setUsuarioOpcions(grupoopcionDataAccess.getUsuarioOpcions(connexion,grupoopcion));

			for(UsuarioOpcion usuarioopcion:grupoopcion.getUsuarioOpcions()) {
				UsuarioOpcionLogic usuarioopcionLogic= new UsuarioOpcionLogic(connexion);
				usuarioopcionLogic.deepLoad(usuarioopcion,isDeep,deepLoadType,clases);
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
			grupoopcion.setOpcions(grupoopcionDataAccess.getOpcions(connexion,grupoopcion));

			for(Opcion opcion:grupoopcion.getOpcions()) {
				OpcionLogic opcionLogic= new OpcionLogic(connexion);
				opcionLogic.deepLoad(opcion,isDeep,deepLoadType,clases);
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
			grupoopcion.setPerfilOpcions(grupoopcionDataAccess.getPerfilOpcions(connexion,grupoopcion));

			for(PerfilOpcion perfilopcion:grupoopcion.getPerfilOpcions()) {
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
	
	public void deepSave(GrupoOpcion grupoopcion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			GrupoOpcionLogicAdditional.updateGrupoOpcionToSave(grupoopcion,this.arrDatoGeneral);
			
GrupoOpcionDataAccess.save(grupoopcion, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ModuloDataAccess.save(grupoopcion.getModulo(),connexion);

		for(UsuarioOpcion usuarioopcion:grupoopcion.getUsuarioOpcions()) {
			usuarioopcion.setid_grupo_opcion(grupoopcion.getId());
			UsuarioOpcionDataAccess.save(usuarioopcion,connexion);
		}

		for(Opcion opcion:grupoopcion.getOpcions()) {
			opcion.setid_grupo_opcion(grupoopcion.getId());
			OpcionDataAccess.save(opcion,connexion);
		}

		for(PerfilOpcion perfilopcion:grupoopcion.getPerfilOpcions()) {
			perfilopcion.setid_grupo_opcion(grupoopcion.getId());
			PerfilOpcionDataAccess.save(perfilopcion,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(grupoopcion.getModulo(),connexion);
				continue;
			}


			if(clas.clas.equals(UsuarioOpcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(UsuarioOpcion usuarioopcion:grupoopcion.getUsuarioOpcions()) {
					usuarioopcion.setid_grupo_opcion(grupoopcion.getId());
					UsuarioOpcionDataAccess.save(usuarioopcion,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Opcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Opcion opcion:grupoopcion.getOpcions()) {
					opcion.setid_grupo_opcion(grupoopcion.getId());
					OpcionDataAccess.save(opcion,connexion);
				}
				continue;
			}

			if(clas.clas.equals(PerfilOpcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PerfilOpcion perfilopcion:grupoopcion.getPerfilOpcions()) {
					perfilopcion.setid_grupo_opcion(grupoopcion.getId());
					PerfilOpcionDataAccess.save(perfilopcion,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ModuloDataAccess.save(grupoopcion.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(grupoopcion.getModulo(),isDeep,deepLoadType,clases);
				

		for(UsuarioOpcion usuarioopcion:grupoopcion.getUsuarioOpcions()) {
			UsuarioOpcionLogic usuarioopcionLogic= new UsuarioOpcionLogic(connexion);
			usuarioopcion.setid_grupo_opcion(grupoopcion.getId());
			UsuarioOpcionDataAccess.save(usuarioopcion,connexion);
			usuarioopcionLogic.deepSave(usuarioopcion,isDeep,deepLoadType,clases);
		}

		for(Opcion opcion:grupoopcion.getOpcions()) {
			OpcionLogic opcionLogic= new OpcionLogic(connexion);
			opcion.setid_grupo_opcion(grupoopcion.getId());
			OpcionDataAccess.save(opcion,connexion);
			opcionLogic.deepSave(opcion,isDeep,deepLoadType,clases);
		}

		for(PerfilOpcion perfilopcion:grupoopcion.getPerfilOpcions()) {
			PerfilOpcionLogic perfilopcionLogic= new PerfilOpcionLogic(connexion);
			perfilopcion.setid_grupo_opcion(grupoopcion.getId());
			PerfilOpcionDataAccess.save(perfilopcion,connexion);
			perfilopcionLogic.deepSave(perfilopcion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(grupoopcion.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(grupoopcion.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(UsuarioOpcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(UsuarioOpcion usuarioopcion:grupoopcion.getUsuarioOpcions()) {
					UsuarioOpcionLogic usuarioopcionLogic= new UsuarioOpcionLogic(connexion);
					usuarioopcion.setid_grupo_opcion(grupoopcion.getId());
					UsuarioOpcionDataAccess.save(usuarioopcion,connexion);
					usuarioopcionLogic.deepSave(usuarioopcion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Opcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Opcion opcion:grupoopcion.getOpcions()) {
					OpcionLogic opcionLogic= new OpcionLogic(connexion);
					opcion.setid_grupo_opcion(grupoopcion.getId());
					OpcionDataAccess.save(opcion,connexion);
					opcionLogic.deepSave(opcion,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PerfilOpcion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PerfilOpcion perfilopcion:grupoopcion.getPerfilOpcions()) {
					PerfilOpcionLogic perfilopcionLogic= new PerfilOpcionLogic(connexion);
					perfilopcion.setid_grupo_opcion(grupoopcion.getId());
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
			this.getNewConnexionToDeep(GrupoOpcion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(grupoopcion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				GrupoOpcionConstantesFunciones.refrescarForeignKeysDescripcionesGrupoOpcion(grupoopcion);
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
			this.deepLoad(this.grupoopcion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				GrupoOpcionConstantesFunciones.refrescarForeignKeysDescripcionesGrupoOpcion(this.grupoopcion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(GrupoOpcion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(grupoopcions!=null) {
				for(GrupoOpcion grupoopcion:grupoopcions) {
					this.deepLoad(grupoopcion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					GrupoOpcionConstantesFunciones.refrescarForeignKeysDescripcionesGrupoOpcion(grupoopcions);
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
			if(grupoopcions!=null) {
				for(GrupoOpcion grupoopcion:grupoopcions) {
					this.deepLoad(grupoopcion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					GrupoOpcionConstantesFunciones.refrescarForeignKeysDescripcionesGrupoOpcion(grupoopcions);
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
			this.getNewConnexionToDeep(GrupoOpcion.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(grupoopcion,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(GrupoOpcion.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(grupoopcions!=null) {
				for(GrupoOpcion grupoopcion:grupoopcions) {
					this.deepSave(grupoopcion,isDeep,deepLoadType,clases);
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
			if(grupoopcions!=null) {
				for(GrupoOpcion grupoopcion:grupoopcions) {
					this.deepSave(grupoopcion,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getGrupoOpcionsBusquedaIdModuloPorNombreWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo,String nombre_principal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoOpcion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,GrupoOpcionConstantesFunciones.IDMODULO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre_principal+"%",GrupoOpcionConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			GrupoOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaIdModuloPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupoopcions=grupoopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoOpcionConstantesFunciones.refrescarForeignKeysDescripcionesGrupoOpcion(this.grupoopcions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoOpcionsBusquedaIdModuloPorNombre(String sFinalQuery,Pagination pagination,Long id_modulo,String nombre_principal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,GrupoOpcionConstantesFunciones.IDMODULO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre_principal+"%",GrupoOpcionConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			GrupoOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaIdModuloPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupoopcions=grupoopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoOpcionConstantesFunciones.refrescarForeignKeysDescripcionesGrupoOpcion(this.grupoopcions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGrupoOpcionsFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoOpcion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,GrupoOpcionConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			GrupoOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupoopcions=grupoopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoOpcionConstantesFunciones.refrescarForeignKeysDescripcionesGrupoOpcion(this.grupoopcions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoOpcionsFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,GrupoOpcionConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			GrupoOpcionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			grupoopcions=grupoopcionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				GrupoOpcionConstantesFunciones.refrescarForeignKeysDescripcionesGrupoOpcion(this.grupoopcions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getGrupoOpcionPorIdModuloPorCodigoWithConnection(Long id_modulo,String codigo)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,GrupoOpcion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,GrupoOpcionConstantesFunciones.IDMODULO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,GrupoOpcionConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			grupoopcion=grupoopcionDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.grupoopcion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				GrupoOpcionConstantesFunciones.refrescarForeignKeysDescripcionesGrupoOpcion(this.grupoopcion);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getGrupoOpcionPorIdModuloPorCodigo(Long id_modulo,String codigo)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,GrupoOpcionConstantesFunciones.IDMODULO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,GrupoOpcionConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			grupoopcion=grupoopcionDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.grupoopcion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				GrupoOpcionConstantesFunciones.refrescarForeignKeysDescripcionesGrupoOpcion(this.grupoopcion);
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
			if(GrupoOpcionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				//auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,GrupoOpcionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,GrupoOpcion grupoopcion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		//AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		//auditoriaLogicAdditional.setConnexion(connexion);
		//AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(GrupoOpcionConstantesFunciones.ISCONAUDITORIA) {
				if(grupoopcion.getIsNew()) {
					//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,GrupoOpcionDataAccess.TABLENAME, grupoopcion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(GrupoOpcionConstantesFunciones.ISCONAUDITORIADETALLE) {
						//GrupoOpcionLogic.registrarAuditoriaDetallesGrupoOpcion(connexion,grupoopcion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(grupoopcion.getIsDeleted()) {
					/*if(!grupoopcion.getIsExpired()) {
						//auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,GrupoOpcionDataAccess.TABLENAME, grupoopcion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						//GrupoOpcionLogic.registrarAuditoriaDetallesGrupoOpcion(connexion,grupoopcion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,GrupoOpcionDataAccess.TABLENAME, grupoopcion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(grupoopcion.getIsChanged()) {
					//auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,GrupoOpcionDataAccess.TABLENAME, grupoopcion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(GrupoOpcionConstantesFunciones.ISCONAUDITORIADETALLE) {
						//GrupoOpcionLogic.registrarAuditoriaDetallesGrupoOpcion(connexion,grupoopcion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesGrupoOpcion(Connexion connexion,GrupoOpcion grupoopcion)throws Exception {		
		//AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		//auditoriaDetalleLogicAdditional.setConnexion(connexion);
		//AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(grupoopcion.getIsNew()||!grupoopcion.getid_modulo().equals(grupoopcion.getGrupoOpcionOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupoopcion.getGrupoOpcionOriginal().getid_modulo()!=null)
				{
					strValorActual=grupoopcion.getGrupoOpcionOriginal().getid_modulo().toString();
				}
				if(grupoopcion.getid_modulo()!=null)
				{
					strValorNuevo=grupoopcion.getid_modulo().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoOpcionConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(grupoopcion.getIsNew()||!grupoopcion.getcodigo().equals(grupoopcion.getGrupoOpcionOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupoopcion.getGrupoOpcionOriginal().getcodigo()!=null)
				{
					strValorActual=grupoopcion.getGrupoOpcionOriginal().getcodigo();
				}
				if(grupoopcion.getcodigo()!=null)
				{
					strValorNuevo=grupoopcion.getcodigo() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoOpcionConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(grupoopcion.getIsNew()||!grupoopcion.getnombre_principal().equals(grupoopcion.getGrupoOpcionOriginal().getnombre_principal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupoopcion.getGrupoOpcionOriginal().getnombre_principal()!=null)
				{
					strValorActual=grupoopcion.getGrupoOpcionOriginal().getnombre_principal();
				}
				if(grupoopcion.getnombre_principal()!=null)
				{
					strValorNuevo=grupoopcion.getnombre_principal() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoOpcionConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(grupoopcion.getIsNew()||!grupoopcion.getorden().equals(grupoopcion.getGrupoOpcionOriginal().getorden()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupoopcion.getGrupoOpcionOriginal().getorden()!=null)
				{
					strValorActual=grupoopcion.getGrupoOpcionOriginal().getorden().toString();
				}
				if(grupoopcion.getorden()!=null)
				{
					strValorNuevo=grupoopcion.getorden().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoOpcionConstantesFunciones.ORDEN,strValorActual,strValorNuevo);
			}	
			
			if(grupoopcion.getIsNew()||!grupoopcion.getestado().equals(grupoopcion.getGrupoOpcionOriginal().getestado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(grupoopcion.getGrupoOpcionOriginal().getestado()!=null)
				{
					strValorActual=grupoopcion.getGrupoOpcionOriginal().getestado().toString();
				}
				if(grupoopcion.getestado()!=null)
				{
					strValorNuevo=grupoopcion.getestado().toString() ;
				}

				//auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),GrupoOpcionConstantesFunciones.ESTADO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveGrupoOpcionRelacionesWithConnection(GrupoOpcion grupoopcion,List<UsuarioOpcion> usuarioopcions,List<Opcion> opcions,List<PerfilOpcion> perfilopcions) throws Exception {

		if(!grupoopcion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveGrupoOpcionRelacionesBase(grupoopcion,usuarioopcions,opcions,perfilopcions,true);
		}
	}

	public void saveGrupoOpcionRelaciones(GrupoOpcion grupoopcion,List<UsuarioOpcion> usuarioopcions,List<Opcion> opcions,List<PerfilOpcion> perfilopcions)throws Exception {

		if(!grupoopcion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveGrupoOpcionRelacionesBase(grupoopcion,usuarioopcions,opcions,perfilopcions,false);
		}
	}

	public void saveGrupoOpcionRelacionesBase(GrupoOpcion grupoopcion,List<UsuarioOpcion> usuarioopcions,List<Opcion> opcions,List<PerfilOpcion> perfilopcions,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("GrupoOpcion-saveRelacionesWithConnection");}
	
			grupoopcion.setUsuarioOpcions(usuarioopcions);
			grupoopcion.setOpcions(opcions);
			grupoopcion.setPerfilOpcions(perfilopcions);

			this.setGrupoOpcion(grupoopcion);

			if(GrupoOpcionLogicAdditional.validarSaveRelaciones(grupoopcion,this)) {

				GrupoOpcionLogicAdditional.updateRelacionesToSave(grupoopcion,this);

				if((grupoopcion.getIsNew()||grupoopcion.getIsChanged())&&!grupoopcion.getIsDeleted()) {
					this.saveGrupoOpcion();
					this.saveGrupoOpcionRelacionesDetalles(usuarioopcions,opcions,perfilopcions);

				} else if(grupoopcion.getIsDeleted()) {
					this.saveGrupoOpcionRelacionesDetalles(usuarioopcions,opcions,perfilopcions);
					this.saveGrupoOpcion();
				}

				GrupoOpcionLogicAdditional.updateRelacionesToSaveAfter(grupoopcion,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			UsuarioOpcionConstantesFunciones.InicializarGeneralEntityAuxiliaresUsuarioOpcions(usuarioopcions,true,true);
			OpcionConstantesFunciones.InicializarGeneralEntityAuxiliaresOpcions(opcions,true,true);
			PerfilOpcionConstantesFunciones.InicializarGeneralEntityAuxiliaresPerfilOpcions(perfilopcions,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveGrupoOpcionRelacionesDetalles(List<UsuarioOpcion> usuarioopcions,List<Opcion> opcions,List<PerfilOpcion> perfilopcions)throws Exception {
		try {
	

			Long idGrupoOpcionActual=this.getGrupoOpcion().getId();

			UsuarioOpcionLogic usuarioopcionLogic_Desde_GrupoOpcion=new UsuarioOpcionLogic();
			usuarioopcionLogic_Desde_GrupoOpcion.setUsuarioOpcions(usuarioopcions);

			usuarioopcionLogic_Desde_GrupoOpcion.setConnexion(this.getConnexion());
			usuarioopcionLogic_Desde_GrupoOpcion.setDatosCliente(this.datosCliente);

			for(UsuarioOpcion usuarioopcion_Desde_GrupoOpcion:usuarioopcionLogic_Desde_GrupoOpcion.getUsuarioOpcions()) {
				usuarioopcion_Desde_GrupoOpcion.setid_grupo_opcion(idGrupoOpcionActual);
			}

			usuarioopcionLogic_Desde_GrupoOpcion.saveUsuarioOpcions();

			OpcionLogic opcionLogic_Desde_GrupoOpcion=new OpcionLogic();
			opcionLogic_Desde_GrupoOpcion.setOpcions(opcions);

			opcionLogic_Desde_GrupoOpcion.setConnexion(this.getConnexion());
			opcionLogic_Desde_GrupoOpcion.setDatosCliente(this.datosCliente);

			for(Opcion opcion_Desde_GrupoOpcion:opcionLogic_Desde_GrupoOpcion.getOpcions()) {
				opcion_Desde_GrupoOpcion.setid_grupo_opcion(idGrupoOpcionActual);

				opcionLogic_Desde_GrupoOpcion.setOpcion(opcion_Desde_GrupoOpcion);
				opcionLogic_Desde_GrupoOpcion.saveOpcion();

				Long idOpcionActual=opcion_Desde_GrupoOpcion.getId();

				UsuarioOpcionLogic usuarioopcionLogic_Desde_Opcion=new UsuarioOpcionLogic();

				if(opcion_Desde_GrupoOpcion.getUsuarioOpcions()==null){
					opcion_Desde_GrupoOpcion.setUsuarioOpcions(new ArrayList<UsuarioOpcion>());
				}

				usuarioopcionLogic_Desde_Opcion.setUsuarioOpcions(opcion_Desde_GrupoOpcion.getUsuarioOpcions());

				usuarioopcionLogic_Desde_Opcion.setConnexion(this.getConnexion());
				usuarioopcionLogic_Desde_Opcion.setDatosCliente(this.datosCliente);

				for(UsuarioOpcion usuarioopcion_Desde_Opcion:usuarioopcionLogic_Desde_Opcion.getUsuarioOpcions()) {
					usuarioopcion_Desde_Opcion.setid_opcion(idOpcionActual);
				}

				usuarioopcionLogic_Desde_Opcion.saveUsuarioOpcions();

				OpcionLogic opcionLogicHijos_Desde_Opcion=new OpcionLogic();

				if(opcion_Desde_GrupoOpcion.getOpcions()==null){
					opcion_Desde_GrupoOpcion.setOpcions(new ArrayList<Opcion>());
				}

				opcionLogicHijos_Desde_Opcion.setOpcions(opcion_Desde_GrupoOpcion.getOpcions());

				opcionLogicHijos_Desde_Opcion.setConnexion(this.getConnexion());
				opcionLogicHijos_Desde_Opcion.setDatosCliente(this.datosCliente);

				for(Opcion opcionHijos_Desde_Opcion:opcionLogicHijos_Desde_Opcion.getOpcions()) {
					opcionHijos_Desde_Opcion.setid_opcion(idOpcionActual);

					opcionLogicHijos_Desde_Opcion.setOpcion(opcionHijos_Desde_Opcion);
					opcionLogicHijos_Desde_Opcion.saveOpcion();
				}


				AccionLogic accionLogic_Desde_Opcion=new AccionLogic();

				if(opcion_Desde_GrupoOpcion.getAccions()==null){
					opcion_Desde_GrupoOpcion.setAccions(new ArrayList<Accion>());
				}

				accionLogic_Desde_Opcion.setAccions(opcion_Desde_GrupoOpcion.getAccions());

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

				if(opcion_Desde_GrupoOpcion.getPerfilOpcions()==null){
					opcion_Desde_GrupoOpcion.setPerfilOpcions(new ArrayList<PerfilOpcion>());
				}

				perfilopcionLogic_Desde_Opcion.setPerfilOpcions(opcion_Desde_GrupoOpcion.getPerfilOpcions());

				perfilopcionLogic_Desde_Opcion.setConnexion(this.getConnexion());
				perfilopcionLogic_Desde_Opcion.setDatosCliente(this.datosCliente);

				for(PerfilOpcion perfilopcion_Desde_Opcion:perfilopcionLogic_Desde_Opcion.getPerfilOpcions()) {
					perfilopcion_Desde_Opcion.setid_opcion(idOpcionActual);
				}

				perfilopcionLogic_Desde_Opcion.savePerfilOpcions();

				CampoLogic campoLogic_Desde_Opcion=new CampoLogic();

				if(opcion_Desde_GrupoOpcion.getCampos()==null){
					opcion_Desde_GrupoOpcion.setCampos(new ArrayList<Campo>());
				}

				campoLogic_Desde_Opcion.setCampos(opcion_Desde_GrupoOpcion.getCampos());

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


			PerfilOpcionLogic perfilopcionLogic_Desde_GrupoOpcion=new PerfilOpcionLogic();
			perfilopcionLogic_Desde_GrupoOpcion.setPerfilOpcions(perfilopcions);

			perfilopcionLogic_Desde_GrupoOpcion.setConnexion(this.getConnexion());
			perfilopcionLogic_Desde_GrupoOpcion.setDatosCliente(this.datosCliente);

			for(PerfilOpcion perfilopcion_Desde_GrupoOpcion:perfilopcionLogic_Desde_GrupoOpcion.getPerfilOpcions()) {
				perfilopcion_Desde_GrupoOpcion.setid_grupo_opcion(idGrupoOpcionActual);
			}

			perfilopcionLogic_Desde_GrupoOpcion.savePerfilOpcions();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfGrupoOpcion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=GrupoOpcionConstantesFunciones.getClassesForeignKeysOfGrupoOpcion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfGrupoOpcion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=GrupoOpcionConstantesFunciones.getClassesRelationshipsOfGrupoOpcion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

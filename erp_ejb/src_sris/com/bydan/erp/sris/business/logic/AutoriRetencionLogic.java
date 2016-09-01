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
package com.bydan.erp.sris.business.logic;

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
import com.bydan.erp.sris.util.*;
import com.bydan.erp.sris.util.AutoriRetencionConstantesFunciones;
import com.bydan.erp.sris.util.AutoriRetencionParameterReturnGeneral;
//import com.bydan.erp.sris.util.AutoriRetencionParameterGeneral;
import com.bydan.erp.sris.business.entity.AutoriRetencion;
import com.bydan.erp.sris.business.logic.AutoriRetencionLogicAdditional;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.sris.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class AutoriRetencionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(AutoriRetencionLogic.class);
	
	protected AutoriRetencionDataAccess autoriretencionDataAccess; 	
	protected AutoriRetencion autoriretencion;
	protected List<AutoriRetencion> autoriretencions;
	protected Object autoriretencionObject;	
	protected List<Object> autoriretencionsObject;
	
	public static ClassValidator<AutoriRetencion> autoriretencionValidator = new ClassValidator<AutoriRetencion>(AutoriRetencion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected AutoriRetencionLogicAdditional autoriretencionLogicAdditional=null;
	
	public AutoriRetencionLogicAdditional getAutoriRetencionLogicAdditional() {
		return this.autoriretencionLogicAdditional;
	}
	
	public void setAutoriRetencionLogicAdditional(AutoriRetencionLogicAdditional autoriretencionLogicAdditional) {
		try {
			this.autoriretencionLogicAdditional=autoriretencionLogicAdditional;
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
	
	
	
	
	public  AutoriRetencionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.autoriretencionDataAccess = new AutoriRetencionDataAccess();
			
			this.autoriretencions= new ArrayList<AutoriRetencion>();
			this.autoriretencion= new AutoriRetencion();
			
			this.autoriretencionObject=new Object();
			this.autoriretencionsObject=new ArrayList<Object>();
				
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
			
			this.autoriretencionDataAccess.setConnexionType(this.connexionType);
			this.autoriretencionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  AutoriRetencionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.autoriretencionDataAccess = new AutoriRetencionDataAccess();
			this.autoriretencions= new ArrayList<AutoriRetencion>();
			this.autoriretencion= new AutoriRetencion();
			this.autoriretencionObject=new Object();
			this.autoriretencionsObject=new ArrayList<Object>();
			
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
			
			this.autoriretencionDataAccess.setConnexionType(this.connexionType);
			this.autoriretencionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public AutoriRetencion getAutoriRetencion() throws Exception {	
		AutoriRetencionLogicAdditional.checkAutoriRetencionToGet(autoriretencion,this.datosCliente,this.arrDatoGeneral);
		AutoriRetencionLogicAdditional.updateAutoriRetencionToGet(autoriretencion,this.arrDatoGeneral);
		
		return autoriretencion;
	}
		
	public void setAutoriRetencion(AutoriRetencion newAutoriRetencion) {
		this.autoriretencion = newAutoriRetencion;
	}
	
	public AutoriRetencionDataAccess getAutoriRetencionDataAccess() {
		return autoriretencionDataAccess;
	}
	
	public void setAutoriRetencionDataAccess(AutoriRetencionDataAccess newautoriretencionDataAccess) {
		this.autoriretencionDataAccess = newautoriretencionDataAccess;
	}
	
	public List<AutoriRetencion> getAutoriRetencions() throws Exception {		
		this.quitarAutoriRetencionsNulos();
		
		AutoriRetencionLogicAdditional.checkAutoriRetencionToGets(autoriretencions,this.datosCliente,this.arrDatoGeneral);
		
		for (AutoriRetencion autoriretencionLocal: autoriretencions ) {
			AutoriRetencionLogicAdditional.updateAutoriRetencionToGet(autoriretencionLocal,this.arrDatoGeneral);
		}
		
		return autoriretencions;
	}
	
	public void setAutoriRetencions(List<AutoriRetencion> newAutoriRetencions) {
		this.autoriretencions = newAutoriRetencions;
	}
	
	public Object getAutoriRetencionObject() {	
		this.autoriretencionObject=this.autoriretencionDataAccess.getEntityObject();
		return this.autoriretencionObject;
	}
		
	public void setAutoriRetencionObject(Object newAutoriRetencionObject) {
		this.autoriretencionObject = newAutoriRetencionObject;
	}
	
	public List<Object> getAutoriRetencionsObject() {		
		this.autoriretencionsObject=this.autoriretencionDataAccess.getEntitiesObject();
		return this.autoriretencionsObject;
	}
		
	public void setAutoriRetencionsObject(List<Object> newAutoriRetencionsObject) {
		this.autoriretencionsObject = newAutoriRetencionsObject;
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
		
		if(this.autoriretencionDataAccess!=null) {
			this.autoriretencionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriRetencion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			autoriretencionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			autoriretencionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		autoriretencion = new  AutoriRetencion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriRetencion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			autoriretencion=autoriretencionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.autoriretencion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AutoriRetencionConstantesFunciones.refrescarForeignKeysDescripcionesAutoriRetencion(this.autoriretencion);
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
		autoriretencion = new  AutoriRetencion();
		  		  
        try {
			
			autoriretencion=autoriretencionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.autoriretencion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AutoriRetencionConstantesFunciones.refrescarForeignKeysDescripcionesAutoriRetencion(this.autoriretencion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		autoriretencion = new  AutoriRetencion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriRetencion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			autoriretencion=autoriretencionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.autoriretencion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AutoriRetencionConstantesFunciones.refrescarForeignKeysDescripcionesAutoriRetencion(this.autoriretencion);
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
		autoriretencion = new  AutoriRetencion();
		  		  
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
		autoriretencion = new  AutoriRetencion();
		  		  
        try {
			
			autoriretencion=autoriretencionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.autoriretencion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				AutoriRetencionConstantesFunciones.refrescarForeignKeysDescripcionesAutoriRetencion(this.autoriretencion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		autoriretencion = new  AutoriRetencion();
		  		  
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
		autoriretencion = new  AutoriRetencion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriRetencion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =autoriretencionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		autoriretencion = new  AutoriRetencion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=autoriretencionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		autoriretencion = new  AutoriRetencion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriRetencion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =autoriretencionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		autoriretencion = new  AutoriRetencion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=autoriretencionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		autoriretencion = new  AutoriRetencion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriRetencion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =autoriretencionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		autoriretencion = new  AutoriRetencion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=autoriretencionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		autoriretencions = new  ArrayList<AutoriRetencion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriRetencion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			AutoriRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoriretencions=autoriretencionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAutoriRetencion(autoriretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriRetencionConstantesFunciones.refrescarForeignKeysDescripcionesAutoriRetencion(this.autoriretencions);
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
		autoriretencions = new  ArrayList<AutoriRetencion>();
		  		  
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
		autoriretencions = new  ArrayList<AutoriRetencion>();
		  		  
        try {			
			AutoriRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoriretencions=autoriretencionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarAutoriRetencion(autoriretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriRetencionConstantesFunciones.refrescarForeignKeysDescripcionesAutoriRetencion(this.autoriretencions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		autoriretencions = new  ArrayList<AutoriRetencion>();
		  		  
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
		autoriretencions = new  ArrayList<AutoriRetencion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriRetencion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			AutoriRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoriretencions=autoriretencionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAutoriRetencion(autoriretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriRetencionConstantesFunciones.refrescarForeignKeysDescripcionesAutoriRetencion(this.autoriretencions);
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
		autoriretencions = new  ArrayList<AutoriRetencion>();
		  		  
        try {
			AutoriRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoriretencions=autoriretencionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAutoriRetencion(autoriretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriRetencionConstantesFunciones.refrescarForeignKeysDescripcionesAutoriRetencion(this.autoriretencions);
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
		autoriretencions = new  ArrayList<AutoriRetencion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriRetencion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AutoriRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoriretencions=autoriretencionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAutoriRetencion(autoriretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriRetencionConstantesFunciones.refrescarForeignKeysDescripcionesAutoriRetencion(this.autoriretencions);
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
		autoriretencions = new  ArrayList<AutoriRetencion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AutoriRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoriretencions=autoriretencionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAutoriRetencion(autoriretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriRetencionConstantesFunciones.refrescarForeignKeysDescripcionesAutoriRetencion(this.autoriretencions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		autoriretencion = new  AutoriRetencion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriRetencion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AutoriRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoriretencion=autoriretencionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAutoriRetencion(autoriretencion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriRetencionConstantesFunciones.refrescarForeignKeysDescripcionesAutoriRetencion(this.autoriretencion);
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
		autoriretencion = new  AutoriRetencion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AutoriRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoriretencion=autoriretencionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarAutoriRetencion(autoriretencion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriRetencionConstantesFunciones.refrescarForeignKeysDescripcionesAutoriRetencion(this.autoriretencion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		autoriretencions = new  ArrayList<AutoriRetencion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriRetencion.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			AutoriRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoriretencions=autoriretencionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAutoriRetencion(autoriretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriRetencionConstantesFunciones.refrescarForeignKeysDescripcionesAutoriRetencion(this.autoriretencions);
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
		autoriretencions = new  ArrayList<AutoriRetencion>();
		  		  
        try {
			AutoriRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoriretencions=autoriretencionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarAutoriRetencion(autoriretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriRetencionConstantesFunciones.refrescarForeignKeysDescripcionesAutoriRetencion(this.autoriretencions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosAutoriRetencionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		autoriretencions = new  ArrayList<AutoriRetencion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriRetencion.class.getSimpleName()+"-getTodosAutoriRetencionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AutoriRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoriretencions=autoriretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarAutoriRetencion(autoriretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriRetencionConstantesFunciones.refrescarForeignKeysDescripcionesAutoriRetencion(this.autoriretencions);
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
	
	public  void  getTodosAutoriRetencions(String sFinalQuery,Pagination pagination)throws Exception {
		autoriretencions = new  ArrayList<AutoriRetencion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			AutoriRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			autoriretencions=autoriretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarAutoriRetencion(autoriretencions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				AutoriRetencionConstantesFunciones.refrescarForeignKeysDescripcionesAutoriRetencion(this.autoriretencions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarAutoriRetencion(AutoriRetencion autoriretencion) throws Exception {
		Boolean estaValidado=false;
		
		if(autoriretencion.getIsNew() || autoriretencion.getIsChanged()) { 
			this.invalidValues = autoriretencionValidator.getInvalidValues(autoriretencion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(autoriretencion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarAutoriRetencion(List<AutoriRetencion> AutoriRetencions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(AutoriRetencion autoriretencionLocal:autoriretencions) {				
			estaValidadoObjeto=this.validarGuardarAutoriRetencion(autoriretencionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarAutoriRetencion(List<AutoriRetencion> AutoriRetencions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarAutoriRetencion(autoriretencions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarAutoriRetencion(AutoriRetencion AutoriRetencion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarAutoriRetencion(autoriretencion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(AutoriRetencion autoriretencion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+autoriretencion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=AutoriRetencionConstantesFunciones.getAutoriRetencionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"autoriretencion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(AutoriRetencionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(AutoriRetencionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveAutoriRetencionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriRetencion.class.getSimpleName()+"-saveAutoriRetencionWithConnection");connexion.begin();			
			
			AutoriRetencionLogicAdditional.checkAutoriRetencionToSave(this.autoriretencion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			AutoriRetencionLogicAdditional.updateAutoriRetencionToSave(this.autoriretencion,this.arrDatoGeneral);
			
			AutoriRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.autoriretencion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowAutoriRetencion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarAutoriRetencion(this.autoriretencion)) {
				AutoriRetencionDataAccess.save(this.autoriretencion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.autoriretencion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			AutoriRetencionLogicAdditional.checkAutoriRetencionToSaveAfter(this.autoriretencion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowAutoriRetencion();
			
			connexion.commit();			
			
			if(this.autoriretencion.getIsDeleted()) {
				this.autoriretencion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveAutoriRetencion()throws Exception {	
		try {	
			
			AutoriRetencionLogicAdditional.checkAutoriRetencionToSave(this.autoriretencion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			AutoriRetencionLogicAdditional.updateAutoriRetencionToSave(this.autoriretencion,this.arrDatoGeneral);
			
			AutoriRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.autoriretencion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarAutoriRetencion(this.autoriretencion)) {			
				AutoriRetencionDataAccess.save(this.autoriretencion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.autoriretencion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			AutoriRetencionLogicAdditional.checkAutoriRetencionToSaveAfter(this.autoriretencion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.autoriretencion.getIsDeleted()) {
				this.autoriretencion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveAutoriRetencionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriRetencion.class.getSimpleName()+"-saveAutoriRetencionsWithConnection");connexion.begin();			
			
			AutoriRetencionLogicAdditional.checkAutoriRetencionToSaves(autoriretencions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowAutoriRetencions();
			
			Boolean validadoTodosAutoriRetencion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(AutoriRetencion autoriretencionLocal:autoriretencions) {		
				if(autoriretencionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				AutoriRetencionLogicAdditional.updateAutoriRetencionToSave(autoriretencionLocal,this.arrDatoGeneral);
	        	
				AutoriRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),autoriretencionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarAutoriRetencion(autoriretencionLocal)) {
					AutoriRetencionDataAccess.save(autoriretencionLocal, connexion);				
				} else {
					validadoTodosAutoriRetencion=false;
				}
			}
			
			if(!validadoTodosAutoriRetencion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			AutoriRetencionLogicAdditional.checkAutoriRetencionToSavesAfter(autoriretencions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowAutoriRetencions();
			
			connexion.commit();		
			
			this.quitarAutoriRetencionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveAutoriRetencions()throws Exception {				
		 try {	
			AutoriRetencionLogicAdditional.checkAutoriRetencionToSaves(autoriretencions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosAutoriRetencion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(AutoriRetencion autoriretencionLocal:autoriretencions) {				
				if(autoriretencionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				AutoriRetencionLogicAdditional.updateAutoriRetencionToSave(autoriretencionLocal,this.arrDatoGeneral);
	        	
				AutoriRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),autoriretencionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarAutoriRetencion(autoriretencionLocal)) {				
					AutoriRetencionDataAccess.save(autoriretencionLocal, connexion);				
				} else {
					validadoTodosAutoriRetencion=false;
				}
			}
			
			if(!validadoTodosAutoriRetencion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			AutoriRetencionLogicAdditional.checkAutoriRetencionToSavesAfter(autoriretencions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarAutoriRetencionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public AutoriRetencionParameterReturnGeneral procesarAccionAutoriRetencions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<AutoriRetencion> autoriretencions,AutoriRetencionParameterReturnGeneral autoriretencionParameterGeneral)throws Exception {
		 try {	
			AutoriRetencionParameterReturnGeneral autoriretencionReturnGeneral=new AutoriRetencionParameterReturnGeneral();
	
			AutoriRetencionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,autoriretencions,autoriretencionParameterGeneral,autoriretencionReturnGeneral);
			
			return autoriretencionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public AutoriRetencionParameterReturnGeneral procesarAccionAutoriRetencionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<AutoriRetencion> autoriretencions,AutoriRetencionParameterReturnGeneral autoriretencionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriRetencion.class.getSimpleName()+"-procesarAccionAutoriRetencionsWithConnection");connexion.begin();			
			
			AutoriRetencionParameterReturnGeneral autoriretencionReturnGeneral=new AutoriRetencionParameterReturnGeneral();
	
			AutoriRetencionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,autoriretencions,autoriretencionParameterGeneral,autoriretencionReturnGeneral);
			
			this.connexion.commit();
			
			return autoriretencionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public AutoriRetencionParameterReturnGeneral procesarEventosAutoriRetencions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<AutoriRetencion> autoriretencions,AutoriRetencion autoriretencion,AutoriRetencionParameterReturnGeneral autoriretencionParameterGeneral,Boolean isEsNuevoAutoriRetencion,ArrayList<Classe> clases)throws Exception {
		 try {	
			AutoriRetencionParameterReturnGeneral autoriretencionReturnGeneral=new AutoriRetencionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				autoriretencionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			AutoriRetencionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,autoriretencions,autoriretencion,autoriretencionParameterGeneral,autoriretencionReturnGeneral,isEsNuevoAutoriRetencion,clases);
			
			return autoriretencionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public AutoriRetencionParameterReturnGeneral procesarEventosAutoriRetencionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<AutoriRetencion> autoriretencions,AutoriRetencion autoriretencion,AutoriRetencionParameterReturnGeneral autoriretencionParameterGeneral,Boolean isEsNuevoAutoriRetencion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriRetencion.class.getSimpleName()+"-procesarEventosAutoriRetencionsWithConnection");connexion.begin();			
			
			AutoriRetencionParameterReturnGeneral autoriretencionReturnGeneral=new AutoriRetencionParameterReturnGeneral();
	
			autoriretencionReturnGeneral.setAutoriRetencion(autoriretencion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				autoriretencionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			AutoriRetencionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,autoriretencions,autoriretencion,autoriretencionParameterGeneral,autoriretencionReturnGeneral,isEsNuevoAutoriRetencion,clases);
			
			this.connexion.commit();
			
			return autoriretencionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public AutoriRetencionParameterReturnGeneral procesarImportacionAutoriRetencionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,AutoriRetencionParameterReturnGeneral autoriretencionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriRetencion.class.getSimpleName()+"-procesarImportacionAutoriRetencionsWithConnection");connexion.begin();			
			
			AutoriRetencionParameterReturnGeneral autoriretencionReturnGeneral=new AutoriRetencionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.autoriretencions=new ArrayList<AutoriRetencion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.autoriretencion=new AutoriRetencion();
				
				
				if(conColumnasBase) {this.autoriretencion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.autoriretencion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.autoriretencion.setnumero_serie(arrColumnas[iColumn++]);
				this.autoriretencion.setnumero_autorizacion(arrColumnas[iColumn++]);
				this.autoriretencion.setnumero_inicial(arrColumnas[iColumn++]);
				this.autoriretencion.setnumero_final(arrColumnas[iColumn++]);
				this.autoriretencion.setfecha_caducidad(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.autoriretencion.setesta_activo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.autoriretencions.add(this.autoriretencion);
			}
			
			this.saveAutoriRetencions();
			
			this.connexion.commit();
			
			autoriretencionReturnGeneral.setConRetornoEstaProcesado(true);
			autoriretencionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return autoriretencionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarAutoriRetencionsEliminados() throws Exception {				
		
		List<AutoriRetencion> autoriretencionsAux= new ArrayList<AutoriRetencion>();
		
		for(AutoriRetencion autoriretencion:autoriretencions) {
			if(!autoriretencion.getIsDeleted()) {
				autoriretencionsAux.add(autoriretencion);
			}
		}
		
		autoriretencions=autoriretencionsAux;
	}
	
	public void quitarAutoriRetencionsNulos() throws Exception {				
		
		List<AutoriRetencion> autoriretencionsAux= new ArrayList<AutoriRetencion>();
		
		for(AutoriRetencion autoriretencion : this.autoriretencions) {
			if(autoriretencion==null) {
				autoriretencionsAux.add(autoriretencion);
			}
		}
		
		//this.autoriretencions=autoriretencionsAux;
		
		this.autoriretencions.removeAll(autoriretencionsAux);
	}
	
	public void getSetVersionRowAutoriRetencionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(autoriretencion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((autoriretencion.getIsDeleted() || (autoriretencion.getIsChanged()&&!autoriretencion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=autoriretencionDataAccess.getSetVersionRowAutoriRetencion(connexion,autoriretencion.getId());
				
				if(!autoriretencion.getVersionRow().equals(timestamp)) {	
					autoriretencion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				autoriretencion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowAutoriRetencion()throws Exception {	
		
		if(autoriretencion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((autoriretencion.getIsDeleted() || (autoriretencion.getIsChanged()&&!autoriretencion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=autoriretencionDataAccess.getSetVersionRowAutoriRetencion(connexion,autoriretencion.getId());
			
			try {							
				if(!autoriretencion.getVersionRow().equals(timestamp)) {	
					autoriretencion.setVersionRow(timestamp);
				}
				
				autoriretencion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowAutoriRetencionsWithConnection()throws Exception {	
		if(autoriretencions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(AutoriRetencion autoriretencionAux:autoriretencions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(autoriretencionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(autoriretencionAux.getIsDeleted() || (autoriretencionAux.getIsChanged()&&!autoriretencionAux.getIsNew())) {
						
						timestamp=autoriretencionDataAccess.getSetVersionRowAutoriRetencion(connexion,autoriretencionAux.getId());
						
						if(!autoriretencion.getVersionRow().equals(timestamp)) {	
							autoriretencionAux.setVersionRow(timestamp);
						}
								
						autoriretencionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowAutoriRetencions()throws Exception {	
		if(autoriretencions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(AutoriRetencion autoriretencionAux:autoriretencions) {
					if(autoriretencionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(autoriretencionAux.getIsDeleted() || (autoriretencionAux.getIsChanged()&&!autoriretencionAux.getIsNew())) {
						
						timestamp=autoriretencionDataAccess.getSetVersionRowAutoriRetencion(connexion,autoriretencionAux.getId());
						
						if(!autoriretencionAux.getVersionRow().equals(timestamp)) {	
							autoriretencionAux.setVersionRow(timestamp);
						}
						
													
						autoriretencionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public AutoriRetencionParameterReturnGeneral cargarCombosLoteForeignKeyAutoriRetencionWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalUsuario) throws Exception {
		AutoriRetencionParameterReturnGeneral  autoriretencionReturnGeneral =new AutoriRetencionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriRetencion.class.getSimpleName()+"-cargarCombosLoteForeignKeyAutoriRetencionWithConnection");connexion.begin();
			
			autoriretencionReturnGeneral =new AutoriRetencionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			autoriretencionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			autoriretencionReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			autoriretencionReturnGeneral.setusuariosForeignKey(usuariosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return autoriretencionReturnGeneral;
	}
	
	public AutoriRetencionParameterReturnGeneral cargarCombosLoteForeignKeyAutoriRetencion(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalUsuario) throws Exception {
		AutoriRetencionParameterReturnGeneral  autoriretencionReturnGeneral =new AutoriRetencionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			autoriretencionReturnGeneral =new AutoriRetencionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			autoriretencionReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			autoriretencionReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Usuario> usuariosForeignKey=new ArrayList<Usuario>();
			UsuarioLogic usuarioLogic=new UsuarioLogic();
			usuarioLogic.setConnexion(this.connexion);
			//usuarioLogic.getUsuarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalUsuario.equals("NONE")) {
				usuarioLogic.getTodosUsuarios(finalQueryGlobalUsuario,new Pagination());
				usuariosForeignKey=usuarioLogic.getUsuarios();
			}

			autoriretencionReturnGeneral.setusuariosForeignKey(usuariosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return autoriretencionReturnGeneral;
	}
	
	
	public void deepLoad(AutoriRetencion autoriretencion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			AutoriRetencionLogicAdditional.updateAutoriRetencionToGet(autoriretencion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		autoriretencion.setEmpresa(autoriretencionDataAccess.getEmpresa(connexion,autoriretencion));
		autoriretencion.setSucursal(autoriretencionDataAccess.getSucursal(connexion,autoriretencion));
		autoriretencion.setUsuario(autoriretencionDataAccess.getUsuario(connexion,autoriretencion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				autoriretencion.setEmpresa(autoriretencionDataAccess.getEmpresa(connexion,autoriretencion));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				autoriretencion.setSucursal(autoriretencionDataAccess.getSucursal(connexion,autoriretencion));
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				autoriretencion.setUsuario(autoriretencionDataAccess.getUsuario(connexion,autoriretencion));
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
			autoriretencion.setEmpresa(autoriretencionDataAccess.getEmpresa(connexion,autoriretencion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoriretencion.setSucursal(autoriretencionDataAccess.getSucursal(connexion,autoriretencion));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoriretencion.setUsuario(autoriretencionDataAccess.getUsuario(connexion,autoriretencion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		autoriretencion.setEmpresa(autoriretencionDataAccess.getEmpresa(connexion,autoriretencion));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(autoriretencion.getEmpresa(),isDeep,deepLoadType,clases);
				
		autoriretencion.setSucursal(autoriretencionDataAccess.getSucursal(connexion,autoriretencion));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(autoriretencion.getSucursal(),isDeep,deepLoadType,clases);
				
		autoriretencion.setUsuario(autoriretencionDataAccess.getUsuario(connexion,autoriretencion));
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(autoriretencion.getUsuario(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				autoriretencion.setEmpresa(autoriretencionDataAccess.getEmpresa(connexion,autoriretencion));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(autoriretencion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				autoriretencion.setSucursal(autoriretencionDataAccess.getSucursal(connexion,autoriretencion));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(autoriretencion.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				autoriretencion.setUsuario(autoriretencionDataAccess.getUsuario(connexion,autoriretencion));
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepLoad(autoriretencion.getUsuario(),isDeep,deepLoadType,clases);				
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
			autoriretencion.setEmpresa(autoriretencionDataAccess.getEmpresa(connexion,autoriretencion));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(autoriretencion.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoriretencion.setSucursal(autoriretencionDataAccess.getSucursal(connexion,autoriretencion));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(autoriretencion.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Usuario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			autoriretencion.setUsuario(autoriretencionDataAccess.getUsuario(connexion,autoriretencion));
			UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
			usuarioLogic.deepLoad(autoriretencion.getUsuario(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(AutoriRetencion autoriretencion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			AutoriRetencionLogicAdditional.updateAutoriRetencionToSave(autoriretencion,this.arrDatoGeneral);
			
AutoriRetencionDataAccess.save(autoriretencion, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(autoriretencion.getEmpresa(),connexion);

		SucursalDataAccess.save(autoriretencion.getSucursal(),connexion);

		UsuarioDataAccess.save(autoriretencion.getUsuario(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(autoriretencion.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(autoriretencion.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(autoriretencion.getUsuario(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(autoriretencion.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(autoriretencion.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(autoriretencion.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(autoriretencion.getSucursal(),isDeep,deepLoadType,clases);
				

		UsuarioDataAccess.save(autoriretencion.getUsuario(),connexion);
		UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
		usuarioLogic.deepLoad(autoriretencion.getUsuario(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(autoriretencion.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(autoriretencion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(autoriretencion.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(autoriretencion.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Usuario.class)) {
				UsuarioDataAccess.save(autoriretencion.getUsuario(),connexion);
				UsuarioLogic usuarioLogic= new UsuarioLogic(connexion);
				usuarioLogic.deepSave(autoriretencion.getUsuario(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(AutoriRetencion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(autoriretencion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				AutoriRetencionConstantesFunciones.refrescarForeignKeysDescripcionesAutoriRetencion(autoriretencion);
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
			this.deepLoad(this.autoriretencion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				AutoriRetencionConstantesFunciones.refrescarForeignKeysDescripcionesAutoriRetencion(this.autoriretencion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(AutoriRetencion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(autoriretencions!=null) {
				for(AutoriRetencion autoriretencion:autoriretencions) {
					this.deepLoad(autoriretencion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					AutoriRetencionConstantesFunciones.refrescarForeignKeysDescripcionesAutoriRetencion(autoriretencions);
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
			if(autoriretencions!=null) {
				for(AutoriRetencion autoriretencion:autoriretencions) {
					this.deepLoad(autoriretencion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					AutoriRetencionConstantesFunciones.refrescarForeignKeysDescripcionesAutoriRetencion(autoriretencions);
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
			this.getNewConnexionToDeep(AutoriRetencion.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(autoriretencion,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(AutoriRetencion.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(autoriretencions!=null) {
				for(AutoriRetencion autoriretencion:autoriretencions) {
					this.deepSave(autoriretencion,isDeep,deepLoadType,clases);
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
			if(autoriretencions!=null) {
				for(AutoriRetencion autoriretencion:autoriretencions) {
					this.deepSave(autoriretencion,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getAutoriRetencionsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriRetencion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,AutoriRetencionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			AutoriRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoriretencions=autoriretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriRetencionConstantesFunciones.refrescarForeignKeysDescripcionesAutoriRetencion(this.autoriretencions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriRetencionsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,AutoriRetencionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			AutoriRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoriretencions=autoriretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriRetencionConstantesFunciones.refrescarForeignKeysDescripcionesAutoriRetencion(this.autoriretencions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAutoriRetencionsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriRetencion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,AutoriRetencionConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			AutoriRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoriretencions=autoriretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriRetencionConstantesFunciones.refrescarForeignKeysDescripcionesAutoriRetencion(this.autoriretencions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriRetencionsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,AutoriRetencionConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			AutoriRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoriretencions=autoriretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriRetencionConstantesFunciones.refrescarForeignKeysDescripcionesAutoriRetencion(this.autoriretencions);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getAutoriRetencionsFK_IdUsuarioWithConnection(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,AutoriRetencion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,AutoriRetencionConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			AutoriRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoriretencions=autoriretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriRetencionConstantesFunciones.refrescarForeignKeysDescripcionesAutoriRetencion(this.autoriretencions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getAutoriRetencionsFK_IdUsuario(String sFinalQuery,Pagination pagination,Long id_usuario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidUsuario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidUsuario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_usuario,AutoriRetencionConstantesFunciones.IDUSUARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidUsuario);

			AutoriRetencionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdUsuario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			autoriretencions=autoriretencionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				AutoriRetencionConstantesFunciones.refrescarForeignKeysDescripcionesAutoriRetencion(this.autoriretencions);
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
			if(AutoriRetencionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,AutoriRetencionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,AutoriRetencion autoriretencion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(AutoriRetencionConstantesFunciones.ISCONAUDITORIA) {
				if(autoriretencion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AutoriRetencionDataAccess.TABLENAME, autoriretencion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(AutoriRetencionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////AutoriRetencionLogic.registrarAuditoriaDetallesAutoriRetencion(connexion,autoriretencion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(autoriretencion.getIsDeleted()) {
					/*if(!autoriretencion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,AutoriRetencionDataAccess.TABLENAME, autoriretencion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////AutoriRetencionLogic.registrarAuditoriaDetallesAutoriRetencion(connexion,autoriretencion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AutoriRetencionDataAccess.TABLENAME, autoriretencion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(autoriretencion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,AutoriRetencionDataAccess.TABLENAME, autoriretencion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(AutoriRetencionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////AutoriRetencionLogic.registrarAuditoriaDetallesAutoriRetencion(connexion,autoriretencion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesAutoriRetencion(Connexion connexion,AutoriRetencion autoriretencion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(autoriretencion.getIsNew()||!autoriretencion.getid_empresa().equals(autoriretencion.getAutoriRetencionOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoriretencion.getAutoriRetencionOriginal().getid_empresa()!=null)
				{
					strValorActual=autoriretencion.getAutoriRetencionOriginal().getid_empresa().toString();
				}
				if(autoriretencion.getid_empresa()!=null)
				{
					strValorNuevo=autoriretencion.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriRetencionConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(autoriretencion.getIsNew()||!autoriretencion.getid_sucursal().equals(autoriretencion.getAutoriRetencionOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoriretencion.getAutoriRetencionOriginal().getid_sucursal()!=null)
				{
					strValorActual=autoriretencion.getAutoriRetencionOriginal().getid_sucursal().toString();
				}
				if(autoriretencion.getid_sucursal()!=null)
				{
					strValorNuevo=autoriretencion.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriRetencionConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(autoriretencion.getIsNew()||!autoriretencion.getid_usuario().equals(autoriretencion.getAutoriRetencionOriginal().getid_usuario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoriretencion.getAutoriRetencionOriginal().getid_usuario()!=null)
				{
					strValorActual=autoriretencion.getAutoriRetencionOriginal().getid_usuario().toString();
				}
				if(autoriretencion.getid_usuario()!=null)
				{
					strValorNuevo=autoriretencion.getid_usuario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriRetencionConstantesFunciones.IDUSUARIO,strValorActual,strValorNuevo);
			}	
			
			if(autoriretencion.getIsNew()||!autoriretencion.getnumero_serie().equals(autoriretencion.getAutoriRetencionOriginal().getnumero_serie()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoriretencion.getAutoriRetencionOriginal().getnumero_serie()!=null)
				{
					strValorActual=autoriretencion.getAutoriRetencionOriginal().getnumero_serie();
				}
				if(autoriretencion.getnumero_serie()!=null)
				{
					strValorNuevo=autoriretencion.getnumero_serie() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriRetencionConstantesFunciones.NUMEROSERIE,strValorActual,strValorNuevo);
			}	
			
			if(autoriretencion.getIsNew()||!autoriretencion.getnumero_autorizacion().equals(autoriretencion.getAutoriRetencionOriginal().getnumero_autorizacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoriretencion.getAutoriRetencionOriginal().getnumero_autorizacion()!=null)
				{
					strValorActual=autoriretencion.getAutoriRetencionOriginal().getnumero_autorizacion();
				}
				if(autoriretencion.getnumero_autorizacion()!=null)
				{
					strValorNuevo=autoriretencion.getnumero_autorizacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriRetencionConstantesFunciones.NUMEROAUTORIZACION,strValorActual,strValorNuevo);
			}	
			
			if(autoriretencion.getIsNew()||!autoriretencion.getnumero_inicial().equals(autoriretencion.getAutoriRetencionOriginal().getnumero_inicial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoriretencion.getAutoriRetencionOriginal().getnumero_inicial()!=null)
				{
					strValorActual=autoriretencion.getAutoriRetencionOriginal().getnumero_inicial();
				}
				if(autoriretencion.getnumero_inicial()!=null)
				{
					strValorNuevo=autoriretencion.getnumero_inicial() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriRetencionConstantesFunciones.NUMEROINICIAL,strValorActual,strValorNuevo);
			}	
			
			if(autoriretencion.getIsNew()||!autoriretencion.getnumero_final().equals(autoriretencion.getAutoriRetencionOriginal().getnumero_final()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoriretencion.getAutoriRetencionOriginal().getnumero_final()!=null)
				{
					strValorActual=autoriretencion.getAutoriRetencionOriginal().getnumero_final();
				}
				if(autoriretencion.getnumero_final()!=null)
				{
					strValorNuevo=autoriretencion.getnumero_final() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriRetencionConstantesFunciones.NUMEROFINAL,strValorActual,strValorNuevo);
			}	
			
			if(autoriretencion.getIsNew()||!autoriretencion.getfecha_caducidad().equals(autoriretencion.getAutoriRetencionOriginal().getfecha_caducidad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoriretencion.getAutoriRetencionOriginal().getfecha_caducidad()!=null)
				{
					strValorActual=autoriretencion.getAutoriRetencionOriginal().getfecha_caducidad().toString();
				}
				if(autoriretencion.getfecha_caducidad()!=null)
				{
					strValorNuevo=autoriretencion.getfecha_caducidad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriRetencionConstantesFunciones.FECHACADUCIDAD,strValorActual,strValorNuevo);
			}	
			
			if(autoriretencion.getIsNew()||!autoriretencion.getesta_activo().equals(autoriretencion.getAutoriRetencionOriginal().getesta_activo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(autoriretencion.getAutoriRetencionOriginal().getesta_activo()!=null)
				{
					strValorActual=autoriretencion.getAutoriRetencionOriginal().getesta_activo().toString();
				}
				if(autoriretencion.getesta_activo()!=null)
				{
					strValorNuevo=autoriretencion.getesta_activo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),AutoriRetencionConstantesFunciones.ESTAACTIVO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveAutoriRetencionRelacionesWithConnection(AutoriRetencion autoriretencion) throws Exception {

		if(!autoriretencion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveAutoriRetencionRelacionesBase(autoriretencion,true);
		}
	}

	public void saveAutoriRetencionRelaciones(AutoriRetencion autoriretencion)throws Exception {

		if(!autoriretencion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveAutoriRetencionRelacionesBase(autoriretencion,false);
		}
	}

	public void saveAutoriRetencionRelacionesBase(AutoriRetencion autoriretencion,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("AutoriRetencion-saveRelacionesWithConnection");}
	

			this.setAutoriRetencion(autoriretencion);

			if(AutoriRetencionLogicAdditional.validarSaveRelaciones(autoriretencion,this)) {

				AutoriRetencionLogicAdditional.updateRelacionesToSave(autoriretencion,this);

				if((autoriretencion.getIsNew()||autoriretencion.getIsChanged())&&!autoriretencion.getIsDeleted()) {
					this.saveAutoriRetencion();
					this.saveAutoriRetencionRelacionesDetalles();

				} else if(autoriretencion.getIsDeleted()) {
					this.saveAutoriRetencionRelacionesDetalles();
					this.saveAutoriRetencion();
				}

				AutoriRetencionLogicAdditional.updateRelacionesToSaveAfter(autoriretencion,this);

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
	
	
	private void saveAutoriRetencionRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfAutoriRetencion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=AutoriRetencionConstantesFunciones.getClassesForeignKeysOfAutoriRetencion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAutoriRetencion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=AutoriRetencionConstantesFunciones.getClassesRelationshipsOfAutoriRetencion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

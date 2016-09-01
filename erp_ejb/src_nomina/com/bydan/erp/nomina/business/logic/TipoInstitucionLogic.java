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
package com.bydan.erp.nomina.business.logic;

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
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.nomina.util.TipoInstitucionConstantesFunciones;
import com.bydan.erp.nomina.util.TipoInstitucionParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoInstitucionParameterGeneral;
import com.bydan.erp.nomina.business.entity.TipoInstitucion;
//import com.bydan.erp.nomina.business.logic.TipoInstitucionLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoInstitucionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoInstitucionLogic.class);
	
	protected TipoInstitucionDataAccess tipoinstitucionDataAccess; 	
	protected TipoInstitucion tipoinstitucion;
	protected List<TipoInstitucion> tipoinstitucions;
	protected Object tipoinstitucionObject;	
	protected List<Object> tipoinstitucionsObject;
	
	public static ClassValidator<TipoInstitucion> tipoinstitucionValidator = new ClassValidator<TipoInstitucion>(TipoInstitucion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
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
	
	
	
	
	public  TipoInstitucionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoinstitucionDataAccess = new TipoInstitucionDataAccess();
			
			this.tipoinstitucions= new ArrayList<TipoInstitucion>();
			this.tipoinstitucion= new TipoInstitucion();
			
			this.tipoinstitucionObject=new Object();
			this.tipoinstitucionsObject=new ArrayList<Object>();
				
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
			
			this.tipoinstitucionDataAccess.setConnexionType(this.connexionType);
			this.tipoinstitucionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoInstitucionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoinstitucionDataAccess = new TipoInstitucionDataAccess();
			this.tipoinstitucions= new ArrayList<TipoInstitucion>();
			this.tipoinstitucion= new TipoInstitucion();
			this.tipoinstitucionObject=new Object();
			this.tipoinstitucionsObject=new ArrayList<Object>();
			
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
			
			this.tipoinstitucionDataAccess.setConnexionType(this.connexionType);
			this.tipoinstitucionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoInstitucion getTipoInstitucion() throws Exception {	
		//TipoInstitucionLogicAdditional.checkTipoInstitucionToGet(tipoinstitucion,this.datosCliente,this.arrDatoGeneral);
		//TipoInstitucionLogicAdditional.updateTipoInstitucionToGet(tipoinstitucion,this.arrDatoGeneral);
		
		return tipoinstitucion;
	}
		
	public void setTipoInstitucion(TipoInstitucion newTipoInstitucion) {
		this.tipoinstitucion = newTipoInstitucion;
	}
	
	public TipoInstitucionDataAccess getTipoInstitucionDataAccess() {
		return tipoinstitucionDataAccess;
	}
	
	public void setTipoInstitucionDataAccess(TipoInstitucionDataAccess newtipoinstitucionDataAccess) {
		this.tipoinstitucionDataAccess = newtipoinstitucionDataAccess;
	}
	
	public List<TipoInstitucion> getTipoInstitucions() throws Exception {		
		this.quitarTipoInstitucionsNulos();
		
		//TipoInstitucionLogicAdditional.checkTipoInstitucionToGets(tipoinstitucions,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoInstitucion tipoinstitucionLocal: tipoinstitucions ) {
			//TipoInstitucionLogicAdditional.updateTipoInstitucionToGet(tipoinstitucionLocal,this.arrDatoGeneral);
		}
		
		return tipoinstitucions;
	}
	
	public void setTipoInstitucions(List<TipoInstitucion> newTipoInstitucions) {
		this.tipoinstitucions = newTipoInstitucions;
	}
	
	public Object getTipoInstitucionObject() {	
		this.tipoinstitucionObject=this.tipoinstitucionDataAccess.getEntityObject();
		return this.tipoinstitucionObject;
	}
		
	public void setTipoInstitucionObject(Object newTipoInstitucionObject) {
		this.tipoinstitucionObject = newTipoInstitucionObject;
	}
	
	public List<Object> getTipoInstitucionsObject() {		
		this.tipoinstitucionsObject=this.tipoinstitucionDataAccess.getEntitiesObject();
		return this.tipoinstitucionsObject;
	}
		
	public void setTipoInstitucionsObject(List<Object> newTipoInstitucionsObject) {
		this.tipoinstitucionsObject = newTipoInstitucionsObject;
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
		
		if(this.tipoinstitucionDataAccess!=null) {
			this.tipoinstitucionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInstitucion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoinstitucionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoinstitucionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoinstitucion = new  TipoInstitucion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInstitucion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoinstitucion=tipoinstitucionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoinstitucion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoInstitucionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInstitucion(this.tipoinstitucion);
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
		tipoinstitucion = new  TipoInstitucion();
		  		  
        try {
			
			tipoinstitucion=tipoinstitucionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoinstitucion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoInstitucionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInstitucion(this.tipoinstitucion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoinstitucion = new  TipoInstitucion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInstitucion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoinstitucion=tipoinstitucionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoinstitucion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoInstitucionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInstitucion(this.tipoinstitucion);
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
		tipoinstitucion = new  TipoInstitucion();
		  		  
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
		tipoinstitucion = new  TipoInstitucion();
		  		  
        try {
			
			tipoinstitucion=tipoinstitucionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoinstitucion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoInstitucionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInstitucion(this.tipoinstitucion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoinstitucion = new  TipoInstitucion();
		  		  
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
		tipoinstitucion = new  TipoInstitucion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInstitucion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoinstitucionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoinstitucion = new  TipoInstitucion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoinstitucionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoinstitucion = new  TipoInstitucion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInstitucion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoinstitucionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoinstitucion = new  TipoInstitucion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoinstitucionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoinstitucion = new  TipoInstitucion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInstitucion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoinstitucionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoinstitucion = new  TipoInstitucion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoinstitucionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoinstitucions = new  ArrayList<TipoInstitucion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInstitucion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoInstitucionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoinstitucions=tipoinstitucionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoInstitucion(tipoinstitucions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInstitucionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInstitucion(this.tipoinstitucions);
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
		tipoinstitucions = new  ArrayList<TipoInstitucion>();
		  		  
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
		tipoinstitucions = new  ArrayList<TipoInstitucion>();
		  		  
        try {			
			TipoInstitucionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoinstitucions=tipoinstitucionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoInstitucion(tipoinstitucions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInstitucionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInstitucion(this.tipoinstitucions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoinstitucions = new  ArrayList<TipoInstitucion>();
		  		  
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
		tipoinstitucions = new  ArrayList<TipoInstitucion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInstitucion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoInstitucionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoinstitucions=tipoinstitucionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoInstitucion(tipoinstitucions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInstitucionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInstitucion(this.tipoinstitucions);
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
		tipoinstitucions = new  ArrayList<TipoInstitucion>();
		  		  
        try {
			TipoInstitucionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoinstitucions=tipoinstitucionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoInstitucion(tipoinstitucions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInstitucionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInstitucion(this.tipoinstitucions);
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
		tipoinstitucions = new  ArrayList<TipoInstitucion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInstitucion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoInstitucionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoinstitucions=tipoinstitucionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoInstitucion(tipoinstitucions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInstitucionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInstitucion(this.tipoinstitucions);
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
		tipoinstitucions = new  ArrayList<TipoInstitucion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoInstitucionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoinstitucions=tipoinstitucionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoInstitucion(tipoinstitucions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInstitucionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInstitucion(this.tipoinstitucions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoinstitucion = new  TipoInstitucion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInstitucion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoInstitucionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoinstitucion=tipoinstitucionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoInstitucion(tipoinstitucion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInstitucionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInstitucion(this.tipoinstitucion);
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
		tipoinstitucion = new  TipoInstitucion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoInstitucionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoinstitucion=tipoinstitucionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoInstitucion(tipoinstitucion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInstitucionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInstitucion(this.tipoinstitucion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoInstitucionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoinstitucions = new  ArrayList<TipoInstitucion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInstitucion.class.getSimpleName()+"-getTodosTipoInstitucionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoInstitucionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoinstitucions=tipoinstitucionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoInstitucion(tipoinstitucions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInstitucionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInstitucion(this.tipoinstitucions);
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
	
	public  void  getTodosTipoInstitucions(String sFinalQuery,Pagination pagination)throws Exception {
		tipoinstitucions = new  ArrayList<TipoInstitucion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoInstitucionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoinstitucions=tipoinstitucionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoInstitucion(tipoinstitucions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoInstitucionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInstitucion(this.tipoinstitucions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoInstitucion(TipoInstitucion tipoinstitucion) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoinstitucion.getIsNew() || tipoinstitucion.getIsChanged()) { 
			this.invalidValues = tipoinstitucionValidator.getInvalidValues(tipoinstitucion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoinstitucion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoInstitucion(List<TipoInstitucion> TipoInstitucions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoInstitucion tipoinstitucionLocal:tipoinstitucions) {				
			estaValidadoObjeto=this.validarGuardarTipoInstitucion(tipoinstitucionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoInstitucion(List<TipoInstitucion> TipoInstitucions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoInstitucion(tipoinstitucions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoInstitucion(TipoInstitucion TipoInstitucion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoInstitucion(tipoinstitucion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoInstitucion tipoinstitucion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoinstitucion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoInstitucionConstantesFunciones.getTipoInstitucionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoinstitucion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoInstitucionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoInstitucionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoInstitucionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInstitucion.class.getSimpleName()+"-saveTipoInstitucionWithConnection");connexion.begin();			
			
			//TipoInstitucionLogicAdditional.checkTipoInstitucionToSave(this.tipoinstitucion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoInstitucionLogicAdditional.updateTipoInstitucionToSave(this.tipoinstitucion,this.arrDatoGeneral);
			
			TipoInstitucionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoinstitucion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoInstitucion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoInstitucion(this.tipoinstitucion)) {
				TipoInstitucionDataAccess.save(this.tipoinstitucion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoinstitucion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoInstitucionLogicAdditional.checkTipoInstitucionToSaveAfter(this.tipoinstitucion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoInstitucion();
			
			connexion.commit();			
			
			if(this.tipoinstitucion.getIsDeleted()) {
				this.tipoinstitucion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoInstitucion()throws Exception {	
		try {	
			
			//TipoInstitucionLogicAdditional.checkTipoInstitucionToSave(this.tipoinstitucion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoInstitucionLogicAdditional.updateTipoInstitucionToSave(this.tipoinstitucion,this.arrDatoGeneral);
			
			TipoInstitucionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoinstitucion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoInstitucion(this.tipoinstitucion)) {			
				TipoInstitucionDataAccess.save(this.tipoinstitucion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoinstitucion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoInstitucionLogicAdditional.checkTipoInstitucionToSaveAfter(this.tipoinstitucion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoinstitucion.getIsDeleted()) {
				this.tipoinstitucion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoInstitucionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInstitucion.class.getSimpleName()+"-saveTipoInstitucionsWithConnection");connexion.begin();			
			
			//TipoInstitucionLogicAdditional.checkTipoInstitucionToSaves(tipoinstitucions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoInstitucions();
			
			Boolean validadoTodosTipoInstitucion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoInstitucion tipoinstitucionLocal:tipoinstitucions) {		
				if(tipoinstitucionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoInstitucionLogicAdditional.updateTipoInstitucionToSave(tipoinstitucionLocal,this.arrDatoGeneral);
	        	
				TipoInstitucionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoinstitucionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoInstitucion(tipoinstitucionLocal)) {
					TipoInstitucionDataAccess.save(tipoinstitucionLocal, connexion);				
				} else {
					validadoTodosTipoInstitucion=false;
				}
			}
			
			if(!validadoTodosTipoInstitucion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoInstitucionLogicAdditional.checkTipoInstitucionToSavesAfter(tipoinstitucions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoInstitucions();
			
			connexion.commit();		
			
			this.quitarTipoInstitucionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoInstitucions()throws Exception {				
		 try {	
			//TipoInstitucionLogicAdditional.checkTipoInstitucionToSaves(tipoinstitucions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoInstitucion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoInstitucion tipoinstitucionLocal:tipoinstitucions) {				
				if(tipoinstitucionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoInstitucionLogicAdditional.updateTipoInstitucionToSave(tipoinstitucionLocal,this.arrDatoGeneral);
	        	
				TipoInstitucionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoinstitucionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoInstitucion(tipoinstitucionLocal)) {				
					TipoInstitucionDataAccess.save(tipoinstitucionLocal, connexion);				
				} else {
					validadoTodosTipoInstitucion=false;
				}
			}
			
			if(!validadoTodosTipoInstitucion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoInstitucionLogicAdditional.checkTipoInstitucionToSavesAfter(tipoinstitucions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoInstitucionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoInstitucionParameterReturnGeneral procesarAccionTipoInstitucions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoInstitucion> tipoinstitucions,TipoInstitucionParameterReturnGeneral tipoinstitucionParameterGeneral)throws Exception {
		 try {	
			TipoInstitucionParameterReturnGeneral tipoinstitucionReturnGeneral=new TipoInstitucionParameterReturnGeneral();
	
			
			return tipoinstitucionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoInstitucionParameterReturnGeneral procesarAccionTipoInstitucionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoInstitucion> tipoinstitucions,TipoInstitucionParameterReturnGeneral tipoinstitucionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInstitucion.class.getSimpleName()+"-procesarAccionTipoInstitucionsWithConnection");connexion.begin();			
			
			TipoInstitucionParameterReturnGeneral tipoinstitucionReturnGeneral=new TipoInstitucionParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipoinstitucionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoInstitucionParameterReturnGeneral procesarEventosTipoInstitucions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoInstitucion> tipoinstitucions,TipoInstitucion tipoinstitucion,TipoInstitucionParameterReturnGeneral tipoinstitucionParameterGeneral,Boolean isEsNuevoTipoInstitucion,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoInstitucionParameterReturnGeneral tipoinstitucionReturnGeneral=new TipoInstitucionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoinstitucionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipoinstitucionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoInstitucionParameterReturnGeneral procesarEventosTipoInstitucionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoInstitucion> tipoinstitucions,TipoInstitucion tipoinstitucion,TipoInstitucionParameterReturnGeneral tipoinstitucionParameterGeneral,Boolean isEsNuevoTipoInstitucion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInstitucion.class.getSimpleName()+"-procesarEventosTipoInstitucionsWithConnection");connexion.begin();			
			
			TipoInstitucionParameterReturnGeneral tipoinstitucionReturnGeneral=new TipoInstitucionParameterReturnGeneral();
	
			tipoinstitucionReturnGeneral.setTipoInstitucion(tipoinstitucion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoinstitucionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipoinstitucionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoInstitucionParameterReturnGeneral procesarImportacionTipoInstitucionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoInstitucionParameterReturnGeneral tipoinstitucionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInstitucion.class.getSimpleName()+"-procesarImportacionTipoInstitucionsWithConnection");connexion.begin();			
			
			TipoInstitucionParameterReturnGeneral tipoinstitucionReturnGeneral=new TipoInstitucionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoinstitucions=new ArrayList<TipoInstitucion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoinstitucion=new TipoInstitucion();
				
				
				if(conColumnasBase) {this.tipoinstitucion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoinstitucion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoinstitucion.setcodigo(arrColumnas[iColumn++]);
				this.tipoinstitucion.setnombre(arrColumnas[iColumn++]);
				
				this.tipoinstitucions.add(this.tipoinstitucion);
			}
			
			this.saveTipoInstitucions();
			
			this.connexion.commit();
			
			tipoinstitucionReturnGeneral.setConRetornoEstaProcesado(true);
			tipoinstitucionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoinstitucionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoInstitucionsEliminados() throws Exception {				
		
		List<TipoInstitucion> tipoinstitucionsAux= new ArrayList<TipoInstitucion>();
		
		for(TipoInstitucion tipoinstitucion:tipoinstitucions) {
			if(!tipoinstitucion.getIsDeleted()) {
				tipoinstitucionsAux.add(tipoinstitucion);
			}
		}
		
		tipoinstitucions=tipoinstitucionsAux;
	}
	
	public void quitarTipoInstitucionsNulos() throws Exception {				
		
		List<TipoInstitucion> tipoinstitucionsAux= new ArrayList<TipoInstitucion>();
		
		for(TipoInstitucion tipoinstitucion : this.tipoinstitucions) {
			if(tipoinstitucion==null) {
				tipoinstitucionsAux.add(tipoinstitucion);
			}
		}
		
		//this.tipoinstitucions=tipoinstitucionsAux;
		
		this.tipoinstitucions.removeAll(tipoinstitucionsAux);
	}
	
	public void getSetVersionRowTipoInstitucionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoinstitucion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoinstitucion.getIsDeleted() || (tipoinstitucion.getIsChanged()&&!tipoinstitucion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoinstitucionDataAccess.getSetVersionRowTipoInstitucion(connexion,tipoinstitucion.getId());
				
				if(!tipoinstitucion.getVersionRow().equals(timestamp)) {	
					tipoinstitucion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoinstitucion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoInstitucion()throws Exception {	
		
		if(tipoinstitucion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoinstitucion.getIsDeleted() || (tipoinstitucion.getIsChanged()&&!tipoinstitucion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoinstitucionDataAccess.getSetVersionRowTipoInstitucion(connexion,tipoinstitucion.getId());
			
			try {							
				if(!tipoinstitucion.getVersionRow().equals(timestamp)) {	
					tipoinstitucion.setVersionRow(timestamp);
				}
				
				tipoinstitucion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoInstitucionsWithConnection()throws Exception {	
		if(tipoinstitucions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoInstitucion tipoinstitucionAux:tipoinstitucions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoinstitucionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoinstitucionAux.getIsDeleted() || (tipoinstitucionAux.getIsChanged()&&!tipoinstitucionAux.getIsNew())) {
						
						timestamp=tipoinstitucionDataAccess.getSetVersionRowTipoInstitucion(connexion,tipoinstitucionAux.getId());
						
						if(!tipoinstitucion.getVersionRow().equals(timestamp)) {	
							tipoinstitucionAux.setVersionRow(timestamp);
						}
								
						tipoinstitucionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoInstitucions()throws Exception {	
		if(tipoinstitucions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoInstitucion tipoinstitucionAux:tipoinstitucions) {
					if(tipoinstitucionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoinstitucionAux.getIsDeleted() || (tipoinstitucionAux.getIsChanged()&&!tipoinstitucionAux.getIsNew())) {
						
						timestamp=tipoinstitucionDataAccess.getSetVersionRowTipoInstitucion(connexion,tipoinstitucionAux.getId());
						
						if(!tipoinstitucionAux.getVersionRow().equals(timestamp)) {	
							tipoinstitucionAux.setVersionRow(timestamp);
						}
						
													
						tipoinstitucionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoInstitucionParameterReturnGeneral cargarCombosLoteForeignKeyTipoInstitucionWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoInstitucionParameterReturnGeneral  tipoinstitucionReturnGeneral =new TipoInstitucionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInstitucion.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoInstitucionWithConnection");connexion.begin();
			
			tipoinstitucionReturnGeneral =new TipoInstitucionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoinstitucionReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipoinstitucionReturnGeneral;
	}
	
	public TipoInstitucionParameterReturnGeneral cargarCombosLoteForeignKeyTipoInstitucion(String finalQueryGlobalEmpresa) throws Exception {
		TipoInstitucionParameterReturnGeneral  tipoinstitucionReturnGeneral =new TipoInstitucionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipoinstitucionReturnGeneral =new TipoInstitucionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoinstitucionReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipoinstitucionReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoInstitucionWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			CursoLogic cursoLogic=new CursoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInstitucion.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoInstitucionWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Curso.class));
											
			

			cursoLogic.setConnexion(this.getConnexion());
			cursoLogic.setDatosCliente(this.datosCliente);
			cursoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoInstitucion tipoinstitucion:this.tipoinstitucions) {
				

				classes=new ArrayList<Classe>();
				classes=CursoConstantesFunciones.getClassesForeignKeysOfCurso(new ArrayList<Classe>(),DeepLoadType.NONE);

				cursoLogic.setCursos(tipoinstitucion.cursos);
				cursoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoInstitucion tipoinstitucion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoInstitucionLogicAdditional.updateTipoInstitucionToGet(tipoinstitucion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoinstitucion.setEmpresa(tipoinstitucionDataAccess.getEmpresa(connexion,tipoinstitucion));
		tipoinstitucion.setCursos(tipoinstitucionDataAccess.getCursos(connexion,tipoinstitucion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoinstitucion.setEmpresa(tipoinstitucionDataAccess.getEmpresa(connexion,tipoinstitucion));
				continue;
			}

			if(clas.clas.equals(Curso.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoinstitucion.setCursos(tipoinstitucionDataAccess.getCursos(connexion,tipoinstitucion));

				if(this.isConDeep) {
					CursoLogic cursoLogic= new CursoLogic(this.connexion);
					cursoLogic.setCursos(tipoinstitucion.getCursos());
					ArrayList<Classe> classesLocal=CursoConstantesFunciones.getClassesForeignKeysOfCurso(new ArrayList<Classe>(),DeepLoadType.NONE);
					cursoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CursoConstantesFunciones.refrescarForeignKeysDescripcionesCurso(cursoLogic.getCursos());
					tipoinstitucion.setCursos(cursoLogic.getCursos());
				}

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
			tipoinstitucion.setEmpresa(tipoinstitucionDataAccess.getEmpresa(connexion,tipoinstitucion));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Curso.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Curso.class));
			tipoinstitucion.setCursos(tipoinstitucionDataAccess.getCursos(connexion,tipoinstitucion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoinstitucion.setEmpresa(tipoinstitucionDataAccess.getEmpresa(connexion,tipoinstitucion));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoinstitucion.getEmpresa(),isDeep,deepLoadType,clases);
				

		tipoinstitucion.setCursos(tipoinstitucionDataAccess.getCursos(connexion,tipoinstitucion));

		for(Curso curso:tipoinstitucion.getCursos()) {
			CursoLogic cursoLogic= new CursoLogic(connexion);
			cursoLogic.deepLoad(curso,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoinstitucion.setEmpresa(tipoinstitucionDataAccess.getEmpresa(connexion,tipoinstitucion));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipoinstitucion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Curso.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoinstitucion.setCursos(tipoinstitucionDataAccess.getCursos(connexion,tipoinstitucion));

				for(Curso curso:tipoinstitucion.getCursos()) {
					CursoLogic cursoLogic= new CursoLogic(connexion);
					cursoLogic.deepLoad(curso,isDeep,deepLoadType,clases);
				}
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
			tipoinstitucion.setEmpresa(tipoinstitucionDataAccess.getEmpresa(connexion,tipoinstitucion));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipoinstitucion.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Curso.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Curso.class));
			tipoinstitucion.setCursos(tipoinstitucionDataAccess.getCursos(connexion,tipoinstitucion));

			for(Curso curso:tipoinstitucion.getCursos()) {
				CursoLogic cursoLogic= new CursoLogic(connexion);
				cursoLogic.deepLoad(curso,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoInstitucion tipoinstitucion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoInstitucion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoinstitucion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoInstitucionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInstitucion(tipoinstitucion);
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
			this.deepLoad(this.tipoinstitucion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoInstitucionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInstitucion(this.tipoinstitucion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoInstitucion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoinstitucions!=null) {
				for(TipoInstitucion tipoinstitucion:tipoinstitucions) {
					this.deepLoad(tipoinstitucion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoInstitucionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInstitucion(tipoinstitucions);
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
			if(tipoinstitucions!=null) {
				for(TipoInstitucion tipoinstitucion:tipoinstitucions) {
					this.deepLoad(tipoinstitucion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoInstitucionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInstitucion(tipoinstitucions);
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
	
	
	public void getTipoInstitucionsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoInstitucion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoInstitucionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoInstitucionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoinstitucions=tipoinstitucionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoInstitucionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInstitucion(this.tipoinstitucions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoInstitucionsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoInstitucionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoInstitucionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoinstitucions=tipoinstitucionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoInstitucionConstantesFunciones.refrescarForeignKeysDescripcionesTipoInstitucion(this.tipoinstitucions);
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
			if(TipoInstitucionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoInstitucionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoInstitucion tipoinstitucion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoInstitucionConstantesFunciones.ISCONAUDITORIA) {
				if(tipoinstitucion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoInstitucionDataAccess.TABLENAME, tipoinstitucion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoInstitucionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoInstitucionLogic.registrarAuditoriaDetallesTipoInstitucion(connexion,tipoinstitucion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoinstitucion.getIsDeleted()) {
					/*if(!tipoinstitucion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoInstitucionDataAccess.TABLENAME, tipoinstitucion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoInstitucionLogic.registrarAuditoriaDetallesTipoInstitucion(connexion,tipoinstitucion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoInstitucionDataAccess.TABLENAME, tipoinstitucion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoinstitucion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoInstitucionDataAccess.TABLENAME, tipoinstitucion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoInstitucionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoInstitucionLogic.registrarAuditoriaDetallesTipoInstitucion(connexion,tipoinstitucion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoInstitucion(Connexion connexion,TipoInstitucion tipoinstitucion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoinstitucion.getIsNew()||!tipoinstitucion.getid_empresa().equals(tipoinstitucion.getTipoInstitucionOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoinstitucion.getTipoInstitucionOriginal().getid_empresa()!=null)
				{
					strValorActual=tipoinstitucion.getTipoInstitucionOriginal().getid_empresa().toString();
				}
				if(tipoinstitucion.getid_empresa()!=null)
				{
					strValorNuevo=tipoinstitucion.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoInstitucionConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipoinstitucion.getIsNew()||!tipoinstitucion.getcodigo().equals(tipoinstitucion.getTipoInstitucionOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoinstitucion.getTipoInstitucionOriginal().getcodigo()!=null)
				{
					strValorActual=tipoinstitucion.getTipoInstitucionOriginal().getcodigo();
				}
				if(tipoinstitucion.getcodigo()!=null)
				{
					strValorNuevo=tipoinstitucion.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoInstitucionConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipoinstitucion.getIsNew()||!tipoinstitucion.getnombre().equals(tipoinstitucion.getTipoInstitucionOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoinstitucion.getTipoInstitucionOriginal().getnombre()!=null)
				{
					strValorActual=tipoinstitucion.getTipoInstitucionOriginal().getnombre();
				}
				if(tipoinstitucion.getnombre()!=null)
				{
					strValorNuevo=tipoinstitucion.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoInstitucionConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoInstitucion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoInstitucionConstantesFunciones.getClassesForeignKeysOfTipoInstitucion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoInstitucion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoInstitucionConstantesFunciones.getClassesRelationshipsOfTipoInstitucion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

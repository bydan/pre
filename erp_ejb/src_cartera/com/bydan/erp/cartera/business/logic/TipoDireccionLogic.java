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
package com.bydan.erp.cartera.business.logic;

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
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.cartera.util.TipoDireccionConstantesFunciones;
import com.bydan.erp.cartera.util.TipoDireccionParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoDireccionParameterGeneral;
import com.bydan.erp.cartera.business.entity.TipoDireccion;
import com.bydan.erp.cartera.business.logic.TipoDireccionLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoDireccionLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoDireccionLogic.class);
	
	protected TipoDireccionDataAccess tipodireccionDataAccess; 	
	protected TipoDireccion tipodireccion;
	protected List<TipoDireccion> tipodireccions;
	protected Object tipodireccionObject;	
	protected List<Object> tipodireccionsObject;
	
	public static ClassValidator<TipoDireccion> tipodireccionValidator = new ClassValidator<TipoDireccion>(TipoDireccion.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoDireccionLogicAdditional tipodireccionLogicAdditional=null;
	
	public TipoDireccionLogicAdditional getTipoDireccionLogicAdditional() {
		return this.tipodireccionLogicAdditional;
	}
	
	public void setTipoDireccionLogicAdditional(TipoDireccionLogicAdditional tipodireccionLogicAdditional) {
		try {
			this.tipodireccionLogicAdditional=tipodireccionLogicAdditional;
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
	
	
	
	
	public  TipoDireccionLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipodireccionDataAccess = new TipoDireccionDataAccess();
			
			this.tipodireccions= new ArrayList<TipoDireccion>();
			this.tipodireccion= new TipoDireccion();
			
			this.tipodireccionObject=new Object();
			this.tipodireccionsObject=new ArrayList<Object>();
				
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
			
			this.tipodireccionDataAccess.setConnexionType(this.connexionType);
			this.tipodireccionDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoDireccionLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipodireccionDataAccess = new TipoDireccionDataAccess();
			this.tipodireccions= new ArrayList<TipoDireccion>();
			this.tipodireccion= new TipoDireccion();
			this.tipodireccionObject=new Object();
			this.tipodireccionsObject=new ArrayList<Object>();
			
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
			
			this.tipodireccionDataAccess.setConnexionType(this.connexionType);
			this.tipodireccionDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoDireccion getTipoDireccion() throws Exception {	
		TipoDireccionLogicAdditional.checkTipoDireccionToGet(tipodireccion,this.datosCliente,this.arrDatoGeneral);
		TipoDireccionLogicAdditional.updateTipoDireccionToGet(tipodireccion,this.arrDatoGeneral);
		
		return tipodireccion;
	}
		
	public void setTipoDireccion(TipoDireccion newTipoDireccion) {
		this.tipodireccion = newTipoDireccion;
	}
	
	public TipoDireccionDataAccess getTipoDireccionDataAccess() {
		return tipodireccionDataAccess;
	}
	
	public void setTipoDireccionDataAccess(TipoDireccionDataAccess newtipodireccionDataAccess) {
		this.tipodireccionDataAccess = newtipodireccionDataAccess;
	}
	
	public List<TipoDireccion> getTipoDireccions() throws Exception {		
		this.quitarTipoDireccionsNulos();
		
		TipoDireccionLogicAdditional.checkTipoDireccionToGets(tipodireccions,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoDireccion tipodireccionLocal: tipodireccions ) {
			TipoDireccionLogicAdditional.updateTipoDireccionToGet(tipodireccionLocal,this.arrDatoGeneral);
		}
		
		return tipodireccions;
	}
	
	public void setTipoDireccions(List<TipoDireccion> newTipoDireccions) {
		this.tipodireccions = newTipoDireccions;
	}
	
	public Object getTipoDireccionObject() {	
		this.tipodireccionObject=this.tipodireccionDataAccess.getEntityObject();
		return this.tipodireccionObject;
	}
		
	public void setTipoDireccionObject(Object newTipoDireccionObject) {
		this.tipodireccionObject = newTipoDireccionObject;
	}
	
	public List<Object> getTipoDireccionsObject() {		
		this.tipodireccionsObject=this.tipodireccionDataAccess.getEntitiesObject();
		return this.tipodireccionsObject;
	}
		
	public void setTipoDireccionsObject(List<Object> newTipoDireccionsObject) {
		this.tipodireccionsObject = newTipoDireccionsObject;
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
		
		if(this.tipodireccionDataAccess!=null) {
			this.tipodireccionDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDireccion.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipodireccionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipodireccionDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipodireccion = new  TipoDireccion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDireccion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipodireccion=tipodireccionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodireccion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDireccionConstantesFunciones.refrescarForeignKeysDescripcionesTipoDireccion(this.tipodireccion);
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
		tipodireccion = new  TipoDireccion();
		  		  
        try {
			
			tipodireccion=tipodireccionDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodireccion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDireccionConstantesFunciones.refrescarForeignKeysDescripcionesTipoDireccion(this.tipodireccion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipodireccion = new  TipoDireccion();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDireccion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipodireccion=tipodireccionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodireccion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDireccionConstantesFunciones.refrescarForeignKeysDescripcionesTipoDireccion(this.tipodireccion);
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
		tipodireccion = new  TipoDireccion();
		  		  
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
		tipodireccion = new  TipoDireccion();
		  		  
        try {
			
			tipodireccion=tipodireccionDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodireccion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDireccionConstantesFunciones.refrescarForeignKeysDescripcionesTipoDireccion(this.tipodireccion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipodireccion = new  TipoDireccion();
		  		  
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
		tipodireccion = new  TipoDireccion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDireccion.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipodireccionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipodireccion = new  TipoDireccion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipodireccionDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipodireccion = new  TipoDireccion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDireccion.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipodireccionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipodireccion = new  TipoDireccion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipodireccionDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipodireccion = new  TipoDireccion();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDireccion.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipodireccionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipodireccion = new  TipoDireccion();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipodireccionDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipodireccions = new  ArrayList<TipoDireccion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDireccion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoDireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodireccions=tipodireccionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDireccion(tipodireccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDireccionConstantesFunciones.refrescarForeignKeysDescripcionesTipoDireccion(this.tipodireccions);
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
		tipodireccions = new  ArrayList<TipoDireccion>();
		  		  
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
		tipodireccions = new  ArrayList<TipoDireccion>();
		  		  
        try {			
			TipoDireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodireccions=tipodireccionDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoDireccion(tipodireccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDireccionConstantesFunciones.refrescarForeignKeysDescripcionesTipoDireccion(this.tipodireccions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipodireccions = new  ArrayList<TipoDireccion>();
		  		  
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
		tipodireccions = new  ArrayList<TipoDireccion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDireccion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoDireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodireccions=tipodireccionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDireccion(tipodireccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDireccionConstantesFunciones.refrescarForeignKeysDescripcionesTipoDireccion(this.tipodireccions);
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
		tipodireccions = new  ArrayList<TipoDireccion>();
		  		  
        try {
			TipoDireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodireccions=tipodireccionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDireccion(tipodireccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDireccionConstantesFunciones.refrescarForeignKeysDescripcionesTipoDireccion(this.tipodireccions);
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
		tipodireccions = new  ArrayList<TipoDireccion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDireccion.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodireccions=tipodireccionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDireccion(tipodireccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDireccionConstantesFunciones.refrescarForeignKeysDescripcionesTipoDireccion(this.tipodireccions);
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
		tipodireccions = new  ArrayList<TipoDireccion>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodireccions=tipodireccionDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDireccion(tipodireccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDireccionConstantesFunciones.refrescarForeignKeysDescripcionesTipoDireccion(this.tipodireccions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipodireccion = new  TipoDireccion();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDireccion.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodireccion=tipodireccionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDireccion(tipodireccion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDireccionConstantesFunciones.refrescarForeignKeysDescripcionesTipoDireccion(this.tipodireccion);
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
		tipodireccion = new  TipoDireccion();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodireccion=tipodireccionDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDireccion(tipodireccion);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDireccionConstantesFunciones.refrescarForeignKeysDescripcionesTipoDireccion(this.tipodireccion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipodireccions = new  ArrayList<TipoDireccion>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDireccion.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoDireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodireccions=tipodireccionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDireccion(tipodireccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDireccionConstantesFunciones.refrescarForeignKeysDescripcionesTipoDireccion(this.tipodireccions);
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
		tipodireccions = new  ArrayList<TipoDireccion>();
		  		  
        try {
			TipoDireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodireccions=tipodireccionDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDireccion(tipodireccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDireccionConstantesFunciones.refrescarForeignKeysDescripcionesTipoDireccion(this.tipodireccions);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoDireccionsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipodireccions = new  ArrayList<TipoDireccion>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDireccion.class.getSimpleName()+"-getTodosTipoDireccionsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodireccions=tipodireccionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoDireccion(tipodireccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDireccionConstantesFunciones.refrescarForeignKeysDescripcionesTipoDireccion(this.tipodireccions);
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
	
	public  void  getTodosTipoDireccions(String sFinalQuery,Pagination pagination)throws Exception {
		tipodireccions = new  ArrayList<TipoDireccion>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodireccions=tipodireccionDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoDireccion(tipodireccions);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDireccionConstantesFunciones.refrescarForeignKeysDescripcionesTipoDireccion(this.tipodireccions);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoDireccion(TipoDireccion tipodireccion) throws Exception {
		Boolean estaValidado=false;
		
		if(tipodireccion.getIsNew() || tipodireccion.getIsChanged()) { 
			this.invalidValues = tipodireccionValidator.getInvalidValues(tipodireccion);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipodireccion);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoDireccion(List<TipoDireccion> TipoDireccions) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoDireccion tipodireccionLocal:tipodireccions) {				
			estaValidadoObjeto=this.validarGuardarTipoDireccion(tipodireccionLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoDireccion(List<TipoDireccion> TipoDireccions) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoDireccion(tipodireccions)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoDireccion(TipoDireccion TipoDireccion) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoDireccion(tipodireccion)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoDireccion tipodireccion) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipodireccion.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoDireccionConstantesFunciones.getTipoDireccionLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipodireccion","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoDireccionConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoDireccionConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoDireccionWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDireccion.class.getSimpleName()+"-saveTipoDireccionWithConnection");connexion.begin();			
			
			TipoDireccionLogicAdditional.checkTipoDireccionToSave(this.tipodireccion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoDireccionLogicAdditional.updateTipoDireccionToSave(this.tipodireccion,this.arrDatoGeneral);
			
			TipoDireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipodireccion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoDireccion();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoDireccion(this.tipodireccion)) {
				TipoDireccionDataAccess.save(this.tipodireccion, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipodireccion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoDireccionLogicAdditional.checkTipoDireccionToSaveAfter(this.tipodireccion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoDireccion();
			
			connexion.commit();			
			
			if(this.tipodireccion.getIsDeleted()) {
				this.tipodireccion=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoDireccion()throws Exception {	
		try {	
			
			TipoDireccionLogicAdditional.checkTipoDireccionToSave(this.tipodireccion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoDireccionLogicAdditional.updateTipoDireccionToSave(this.tipodireccion,this.arrDatoGeneral);
			
			TipoDireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipodireccion,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoDireccion(this.tipodireccion)) {			
				TipoDireccionDataAccess.save(this.tipodireccion, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipodireccion,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoDireccionLogicAdditional.checkTipoDireccionToSaveAfter(this.tipodireccion,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipodireccion.getIsDeleted()) {
				this.tipodireccion=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoDireccionsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDireccion.class.getSimpleName()+"-saveTipoDireccionsWithConnection");connexion.begin();			
			
			TipoDireccionLogicAdditional.checkTipoDireccionToSaves(tipodireccions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoDireccions();
			
			Boolean validadoTodosTipoDireccion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoDireccion tipodireccionLocal:tipodireccions) {		
				if(tipodireccionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoDireccionLogicAdditional.updateTipoDireccionToSave(tipodireccionLocal,this.arrDatoGeneral);
	        	
				TipoDireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipodireccionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoDireccion(tipodireccionLocal)) {
					TipoDireccionDataAccess.save(tipodireccionLocal, connexion);				
				} else {
					validadoTodosTipoDireccion=false;
				}
			}
			
			if(!validadoTodosTipoDireccion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoDireccionLogicAdditional.checkTipoDireccionToSavesAfter(tipodireccions,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoDireccions();
			
			connexion.commit();		
			
			this.quitarTipoDireccionsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoDireccions()throws Exception {				
		 try {	
			TipoDireccionLogicAdditional.checkTipoDireccionToSaves(tipodireccions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoDireccion=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoDireccion tipodireccionLocal:tipodireccions) {				
				if(tipodireccionLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoDireccionLogicAdditional.updateTipoDireccionToSave(tipodireccionLocal,this.arrDatoGeneral);
	        	
				TipoDireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipodireccionLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoDireccion(tipodireccionLocal)) {				
					TipoDireccionDataAccess.save(tipodireccionLocal, connexion);				
				} else {
					validadoTodosTipoDireccion=false;
				}
			}
			
			if(!validadoTodosTipoDireccion) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoDireccionLogicAdditional.checkTipoDireccionToSavesAfter(tipodireccions,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoDireccionsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoDireccionParameterReturnGeneral procesarAccionTipoDireccions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoDireccion> tipodireccions,TipoDireccionParameterReturnGeneral tipodireccionParameterGeneral)throws Exception {
		 try {	
			TipoDireccionParameterReturnGeneral tipodireccionReturnGeneral=new TipoDireccionParameterReturnGeneral();
	
			TipoDireccionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipodireccions,tipodireccionParameterGeneral,tipodireccionReturnGeneral);
			
			return tipodireccionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoDireccionParameterReturnGeneral procesarAccionTipoDireccionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoDireccion> tipodireccions,TipoDireccionParameterReturnGeneral tipodireccionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDireccion.class.getSimpleName()+"-procesarAccionTipoDireccionsWithConnection");connexion.begin();			
			
			TipoDireccionParameterReturnGeneral tipodireccionReturnGeneral=new TipoDireccionParameterReturnGeneral();
	
			TipoDireccionLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipodireccions,tipodireccionParameterGeneral,tipodireccionReturnGeneral);
			
			this.connexion.commit();
			
			return tipodireccionReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoDireccionParameterReturnGeneral procesarEventosTipoDireccions(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoDireccion> tipodireccions,TipoDireccion tipodireccion,TipoDireccionParameterReturnGeneral tipodireccionParameterGeneral,Boolean isEsNuevoTipoDireccion,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoDireccionParameterReturnGeneral tipodireccionReturnGeneral=new TipoDireccionParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipodireccionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoDireccionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipodireccions,tipodireccion,tipodireccionParameterGeneral,tipodireccionReturnGeneral,isEsNuevoTipoDireccion,clases);
			
			return tipodireccionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoDireccionParameterReturnGeneral procesarEventosTipoDireccionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoDireccion> tipodireccions,TipoDireccion tipodireccion,TipoDireccionParameterReturnGeneral tipodireccionParameterGeneral,Boolean isEsNuevoTipoDireccion,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDireccion.class.getSimpleName()+"-procesarEventosTipoDireccionsWithConnection");connexion.begin();			
			
			TipoDireccionParameterReturnGeneral tipodireccionReturnGeneral=new TipoDireccionParameterReturnGeneral();
	
			tipodireccionReturnGeneral.setTipoDireccion(tipodireccion);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipodireccionReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoDireccionLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipodireccions,tipodireccion,tipodireccionParameterGeneral,tipodireccionReturnGeneral,isEsNuevoTipoDireccion,clases);
			
			this.connexion.commit();
			
			return tipodireccionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoDireccionParameterReturnGeneral procesarImportacionTipoDireccionsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoDireccionParameterReturnGeneral tipodireccionParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDireccion.class.getSimpleName()+"-procesarImportacionTipoDireccionsWithConnection");connexion.begin();			
			
			TipoDireccionParameterReturnGeneral tipodireccionReturnGeneral=new TipoDireccionParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipodireccions=new ArrayList<TipoDireccion>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipodireccion=new TipoDireccion();
				
				
				if(conColumnasBase) {this.tipodireccion.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipodireccion.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipodireccion.setcodigo(arrColumnas[iColumn++]);
				this.tipodireccion.setnombre(arrColumnas[iColumn++]);
				
				this.tipodireccions.add(this.tipodireccion);
			}
			
			this.saveTipoDireccions();
			
			this.connexion.commit();
			
			tipodireccionReturnGeneral.setConRetornoEstaProcesado(true);
			tipodireccionReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipodireccionReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoDireccionsEliminados() throws Exception {				
		
		List<TipoDireccion> tipodireccionsAux= new ArrayList<TipoDireccion>();
		
		for(TipoDireccion tipodireccion:tipodireccions) {
			if(!tipodireccion.getIsDeleted()) {
				tipodireccionsAux.add(tipodireccion);
			}
		}
		
		tipodireccions=tipodireccionsAux;
	}
	
	public void quitarTipoDireccionsNulos() throws Exception {				
		
		List<TipoDireccion> tipodireccionsAux= new ArrayList<TipoDireccion>();
		
		for(TipoDireccion tipodireccion : this.tipodireccions) {
			if(tipodireccion==null) {
				tipodireccionsAux.add(tipodireccion);
			}
		}
		
		//this.tipodireccions=tipodireccionsAux;
		
		this.tipodireccions.removeAll(tipodireccionsAux);
	}
	
	public void getSetVersionRowTipoDireccionWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipodireccion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipodireccion.getIsDeleted() || (tipodireccion.getIsChanged()&&!tipodireccion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipodireccionDataAccess.getSetVersionRowTipoDireccion(connexion,tipodireccion.getId());
				
				if(!tipodireccion.getVersionRow().equals(timestamp)) {	
					tipodireccion.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipodireccion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoDireccion()throws Exception {	
		
		if(tipodireccion.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipodireccion.getIsDeleted() || (tipodireccion.getIsChanged()&&!tipodireccion.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipodireccionDataAccess.getSetVersionRowTipoDireccion(connexion,tipodireccion.getId());
			
			try {							
				if(!tipodireccion.getVersionRow().equals(timestamp)) {	
					tipodireccion.setVersionRow(timestamp);
				}
				
				tipodireccion.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoDireccionsWithConnection()throws Exception {	
		if(tipodireccions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoDireccion tipodireccionAux:tipodireccions) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipodireccionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipodireccionAux.getIsDeleted() || (tipodireccionAux.getIsChanged()&&!tipodireccionAux.getIsNew())) {
						
						timestamp=tipodireccionDataAccess.getSetVersionRowTipoDireccion(connexion,tipodireccionAux.getId());
						
						if(!tipodireccion.getVersionRow().equals(timestamp)) {	
							tipodireccionAux.setVersionRow(timestamp);
						}
								
						tipodireccionAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoDireccions()throws Exception {	
		if(tipodireccions!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoDireccion tipodireccionAux:tipodireccions) {
					if(tipodireccionAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipodireccionAux.getIsDeleted() || (tipodireccionAux.getIsChanged()&&!tipodireccionAux.getIsNew())) {
						
						timestamp=tipodireccionDataAccess.getSetVersionRowTipoDireccion(connexion,tipodireccionAux.getId());
						
						if(!tipodireccionAux.getVersionRow().equals(timestamp)) {	
							tipodireccionAux.setVersionRow(timestamp);
						}
						
													
						tipodireccionAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoDireccionParameterReturnGeneral cargarCombosLoteForeignKeyTipoDireccionWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoDireccionParameterReturnGeneral  tipodireccionReturnGeneral =new TipoDireccionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDireccion.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoDireccionWithConnection");connexion.begin();
			
			tipodireccionReturnGeneral =new TipoDireccionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipodireccionReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipodireccionReturnGeneral;
	}
	
	public TipoDireccionParameterReturnGeneral cargarCombosLoteForeignKeyTipoDireccion(String finalQueryGlobalEmpresa) throws Exception {
		TipoDireccionParameterReturnGeneral  tipodireccionReturnGeneral =new TipoDireccionParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipodireccionReturnGeneral =new TipoDireccionParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipodireccionReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipodireccionReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoDireccionWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DireccionLogic direccionLogic=new DireccionLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDireccion.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoDireccionWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Direccion.class));
											
			

			direccionLogic.setConnexion(this.getConnexion());
			direccionLogic.setDatosCliente(this.datosCliente);
			direccionLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoDireccion tipodireccion:this.tipodireccions) {
				

				classes=new ArrayList<Classe>();
				classes=DireccionConstantesFunciones.getClassesForeignKeysOfDireccion(new ArrayList<Classe>(),DeepLoadType.NONE);

				direccionLogic.setDireccions(tipodireccion.direccions);
				direccionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoDireccion tipodireccion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoDireccionLogicAdditional.updateTipoDireccionToGet(tipodireccion,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipodireccion.setEmpresa(tipodireccionDataAccess.getEmpresa(connexion,tipodireccion));
		tipodireccion.setDireccions(tipodireccionDataAccess.getDireccions(connexion,tipodireccion));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipodireccion.setEmpresa(tipodireccionDataAccess.getEmpresa(connexion,tipodireccion));
				continue;
			}

			if(clas.clas.equals(Direccion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipodireccion.setDireccions(tipodireccionDataAccess.getDireccions(connexion,tipodireccion));

				if(this.isConDeep) {
					DireccionLogic direccionLogic= new DireccionLogic(this.connexion);
					direccionLogic.setDireccions(tipodireccion.getDireccions());
					ArrayList<Classe> classesLocal=DireccionConstantesFunciones.getClassesForeignKeysOfDireccion(new ArrayList<Classe>(),DeepLoadType.NONE);
					direccionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DireccionConstantesFunciones.refrescarForeignKeysDescripcionesDireccion(direccionLogic.getDireccions());
					tipodireccion.setDireccions(direccionLogic.getDireccions());
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
			tipodireccion.setEmpresa(tipodireccionDataAccess.getEmpresa(connexion,tipodireccion));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Direccion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Direccion.class));
			tipodireccion.setDireccions(tipodireccionDataAccess.getDireccions(connexion,tipodireccion));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipodireccion.setEmpresa(tipodireccionDataAccess.getEmpresa(connexion,tipodireccion));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipodireccion.getEmpresa(),isDeep,deepLoadType,clases);
				

		tipodireccion.setDireccions(tipodireccionDataAccess.getDireccions(connexion,tipodireccion));

		for(Direccion direccion:tipodireccion.getDireccions()) {
			DireccionLogic direccionLogic= new DireccionLogic(connexion);
			direccionLogic.deepLoad(direccion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipodireccion.setEmpresa(tipodireccionDataAccess.getEmpresa(connexion,tipodireccion));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipodireccion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Direccion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipodireccion.setDireccions(tipodireccionDataAccess.getDireccions(connexion,tipodireccion));

				for(Direccion direccion:tipodireccion.getDireccions()) {
					DireccionLogic direccionLogic= new DireccionLogic(connexion);
					direccionLogic.deepLoad(direccion,isDeep,deepLoadType,clases);
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
			tipodireccion.setEmpresa(tipodireccionDataAccess.getEmpresa(connexion,tipodireccion));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipodireccion.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Direccion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Direccion.class));
			tipodireccion.setDireccions(tipodireccionDataAccess.getDireccions(connexion,tipodireccion));

			for(Direccion direccion:tipodireccion.getDireccions()) {
				DireccionLogic direccionLogic= new DireccionLogic(connexion);
				direccionLogic.deepLoad(direccion,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoDireccion tipodireccion,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoDireccionLogicAdditional.updateTipoDireccionToSave(tipodireccion,this.arrDatoGeneral);
			
TipoDireccionDataAccess.save(tipodireccion, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipodireccion.getEmpresa(),connexion);

		for(Direccion direccion:tipodireccion.getDireccions()) {
			direccion.setid_tipo_direccion(tipodireccion.getId());
			DireccionDataAccess.save(direccion,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipodireccion.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(Direccion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Direccion direccion:tipodireccion.getDireccions()) {
					direccion.setid_tipo_direccion(tipodireccion.getId());
					DireccionDataAccess.save(direccion,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipodireccion.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipodireccion.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(Direccion direccion:tipodireccion.getDireccions()) {
			DireccionLogic direccionLogic= new DireccionLogic(connexion);
			direccion.setid_tipo_direccion(tipodireccion.getId());
			DireccionDataAccess.save(direccion,connexion);
			direccionLogic.deepSave(direccion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipodireccion.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipodireccion.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(Direccion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Direccion direccion:tipodireccion.getDireccions()) {
					DireccionLogic direccionLogic= new DireccionLogic(connexion);
					direccion.setid_tipo_direccion(tipodireccion.getId());
					DireccionDataAccess.save(direccion,connexion);
					direccionLogic.deepSave(direccion,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoDireccion.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipodireccion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoDireccionConstantesFunciones.refrescarForeignKeysDescripcionesTipoDireccion(tipodireccion);
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
			this.deepLoad(this.tipodireccion,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoDireccionConstantesFunciones.refrescarForeignKeysDescripcionesTipoDireccion(this.tipodireccion);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoDireccion.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipodireccions!=null) {
				for(TipoDireccion tipodireccion:tipodireccions) {
					this.deepLoad(tipodireccion,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoDireccionConstantesFunciones.refrescarForeignKeysDescripcionesTipoDireccion(tipodireccions);
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
			if(tipodireccions!=null) {
				for(TipoDireccion tipodireccion:tipodireccions) {
					this.deepLoad(tipodireccion,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoDireccionConstantesFunciones.refrescarForeignKeysDescripcionesTipoDireccion(tipodireccions);
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
			this.getNewConnexionToDeep(TipoDireccion.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipodireccion,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoDireccion.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipodireccions!=null) {
				for(TipoDireccion tipodireccion:tipodireccions) {
					this.deepSave(tipodireccion,isDeep,deepLoadType,clases);
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
			if(tipodireccions!=null) {
				for(TipoDireccion tipodireccion:tipodireccions) {
					this.deepSave(tipodireccion,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoDireccionsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDireccion.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoDireccionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoDireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodireccions=tipodireccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDireccionConstantesFunciones.refrescarForeignKeysDescripcionesTipoDireccion(this.tipodireccions);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoDireccionsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoDireccionConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoDireccionLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodireccions=tipodireccionDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDireccionConstantesFunciones.refrescarForeignKeysDescripcionesTipoDireccion(this.tipodireccions);
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
			if(TipoDireccionConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDireccionDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoDireccion tipodireccion,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoDireccionConstantesFunciones.ISCONAUDITORIA) {
				if(tipodireccion.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDireccionDataAccess.TABLENAME, tipodireccion.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoDireccionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoDireccionLogic.registrarAuditoriaDetallesTipoDireccion(connexion,tipodireccion,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipodireccion.getIsDeleted()) {
					/*if(!tipodireccion.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoDireccionDataAccess.TABLENAME, tipodireccion.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoDireccionLogic.registrarAuditoriaDetallesTipoDireccion(connexion,tipodireccion,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDireccionDataAccess.TABLENAME, tipodireccion.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipodireccion.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDireccionDataAccess.TABLENAME, tipodireccion.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoDireccionConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoDireccionLogic.registrarAuditoriaDetallesTipoDireccion(connexion,tipodireccion,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoDireccion(Connexion connexion,TipoDireccion tipodireccion)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipodireccion.getIsNew()||!tipodireccion.getid_empresa().equals(tipodireccion.getTipoDireccionOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodireccion.getTipoDireccionOriginal().getid_empresa()!=null)
				{
					strValorActual=tipodireccion.getTipoDireccionOriginal().getid_empresa().toString();
				}
				if(tipodireccion.getid_empresa()!=null)
				{
					strValorNuevo=tipodireccion.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDireccionConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipodireccion.getIsNew()||!tipodireccion.getcodigo().equals(tipodireccion.getTipoDireccionOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodireccion.getTipoDireccionOriginal().getcodigo()!=null)
				{
					strValorActual=tipodireccion.getTipoDireccionOriginal().getcodigo();
				}
				if(tipodireccion.getcodigo()!=null)
				{
					strValorNuevo=tipodireccion.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDireccionConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipodireccion.getIsNew()||!tipodireccion.getnombre().equals(tipodireccion.getTipoDireccionOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodireccion.getTipoDireccionOriginal().getnombre()!=null)
				{
					strValorActual=tipodireccion.getTipoDireccionOriginal().getnombre();
				}
				if(tipodireccion.getnombre()!=null)
				{
					strValorNuevo=tipodireccion.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDireccionConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoDireccionRelacionesWithConnection(TipoDireccion tipodireccion,List<Direccion> direccions) throws Exception {

		if(!tipodireccion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoDireccionRelacionesBase(tipodireccion,direccions,true);
		}
	}

	public void saveTipoDireccionRelaciones(TipoDireccion tipodireccion,List<Direccion> direccions)throws Exception {

		if(!tipodireccion.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoDireccionRelacionesBase(tipodireccion,direccions,false);
		}
	}

	public void saveTipoDireccionRelacionesBase(TipoDireccion tipodireccion,List<Direccion> direccions,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoDireccion-saveRelacionesWithConnection");}
	
			tipodireccion.setDireccions(direccions);

			this.setTipoDireccion(tipodireccion);

			if(TipoDireccionLogicAdditional.validarSaveRelaciones(tipodireccion,this)) {

				TipoDireccionLogicAdditional.updateRelacionesToSave(tipodireccion,this);

				if((tipodireccion.getIsNew()||tipodireccion.getIsChanged())&&!tipodireccion.getIsDeleted()) {
					this.saveTipoDireccion();
					this.saveTipoDireccionRelacionesDetalles(direccions);

				} else if(tipodireccion.getIsDeleted()) {
					this.saveTipoDireccionRelacionesDetalles(direccions);
					this.saveTipoDireccion();
				}

				TipoDireccionLogicAdditional.updateRelacionesToSaveAfter(tipodireccion,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DireccionConstantesFunciones.InicializarGeneralEntityAuxiliaresDireccions(direccions,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoDireccionRelacionesDetalles(List<Direccion> direccions)throws Exception {
		try {
	

			Long idTipoDireccionActual=this.getTipoDireccion().getId();

			DireccionLogic direccionLogic_Desde_TipoDireccion=new DireccionLogic();
			direccionLogic_Desde_TipoDireccion.setDireccions(direccions);

			direccionLogic_Desde_TipoDireccion.setConnexion(this.getConnexion());
			direccionLogic_Desde_TipoDireccion.setDatosCliente(this.datosCliente);

			for(Direccion direccion_Desde_TipoDireccion:direccionLogic_Desde_TipoDireccion.getDireccions()) {
				direccion_Desde_TipoDireccion.setid_tipo_direccion(idTipoDireccionActual);
			}

			direccionLogic_Desde_TipoDireccion.saveDireccions();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoDireccion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoDireccionConstantesFunciones.getClassesForeignKeysOfTipoDireccion(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDireccion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoDireccionConstantesFunciones.getClassesRelationshipsOfTipoDireccion(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

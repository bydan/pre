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
import com.bydan.erp.cartera.util.TipoUbicacionNegocioConstantesFunciones;
import com.bydan.erp.cartera.util.TipoUbicacionNegocioParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoUbicacionNegocioParameterGeneral;
import com.bydan.erp.cartera.business.entity.TipoUbicacionNegocio;
//import com.bydan.erp.cartera.business.logic.TipoUbicacionNegocioLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoUbicacionNegocioLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoUbicacionNegocioLogic.class);
	
	protected TipoUbicacionNegocioDataAccess tipoubicacionnegocioDataAccess; 	
	protected TipoUbicacionNegocio tipoubicacionnegocio;
	protected List<TipoUbicacionNegocio> tipoubicacionnegocios;
	protected Object tipoubicacionnegocioObject;	
	protected List<Object> tipoubicacionnegociosObject;
	
	public static ClassValidator<TipoUbicacionNegocio> tipoubicacionnegocioValidator = new ClassValidator<TipoUbicacionNegocio>(TipoUbicacionNegocio.class);	
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
	
	
	
	
	public  TipoUbicacionNegocioLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoubicacionnegocioDataAccess = new TipoUbicacionNegocioDataAccess();
			
			this.tipoubicacionnegocios= new ArrayList<TipoUbicacionNegocio>();
			this.tipoubicacionnegocio= new TipoUbicacionNegocio();
			
			this.tipoubicacionnegocioObject=new Object();
			this.tipoubicacionnegociosObject=new ArrayList<Object>();
				
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
			
			this.tipoubicacionnegocioDataAccess.setConnexionType(this.connexionType);
			this.tipoubicacionnegocioDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoUbicacionNegocioLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoubicacionnegocioDataAccess = new TipoUbicacionNegocioDataAccess();
			this.tipoubicacionnegocios= new ArrayList<TipoUbicacionNegocio>();
			this.tipoubicacionnegocio= new TipoUbicacionNegocio();
			this.tipoubicacionnegocioObject=new Object();
			this.tipoubicacionnegociosObject=new ArrayList<Object>();
			
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
			
			this.tipoubicacionnegocioDataAccess.setConnexionType(this.connexionType);
			this.tipoubicacionnegocioDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoUbicacionNegocio getTipoUbicacionNegocio() throws Exception {	
		//TipoUbicacionNegocioLogicAdditional.checkTipoUbicacionNegocioToGet(tipoubicacionnegocio,this.datosCliente,this.arrDatoGeneral);
		//TipoUbicacionNegocioLogicAdditional.updateTipoUbicacionNegocioToGet(tipoubicacionnegocio,this.arrDatoGeneral);
		
		return tipoubicacionnegocio;
	}
		
	public void setTipoUbicacionNegocio(TipoUbicacionNegocio newTipoUbicacionNegocio) {
		this.tipoubicacionnegocio = newTipoUbicacionNegocio;
	}
	
	public TipoUbicacionNegocioDataAccess getTipoUbicacionNegocioDataAccess() {
		return tipoubicacionnegocioDataAccess;
	}
	
	public void setTipoUbicacionNegocioDataAccess(TipoUbicacionNegocioDataAccess newtipoubicacionnegocioDataAccess) {
		this.tipoubicacionnegocioDataAccess = newtipoubicacionnegocioDataAccess;
	}
	
	public List<TipoUbicacionNegocio> getTipoUbicacionNegocios() throws Exception {		
		this.quitarTipoUbicacionNegociosNulos();
		
		//TipoUbicacionNegocioLogicAdditional.checkTipoUbicacionNegocioToGets(tipoubicacionnegocios,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoUbicacionNegocio tipoubicacionnegocioLocal: tipoubicacionnegocios ) {
			//TipoUbicacionNegocioLogicAdditional.updateTipoUbicacionNegocioToGet(tipoubicacionnegocioLocal,this.arrDatoGeneral);
		}
		
		return tipoubicacionnegocios;
	}
	
	public void setTipoUbicacionNegocios(List<TipoUbicacionNegocio> newTipoUbicacionNegocios) {
		this.tipoubicacionnegocios = newTipoUbicacionNegocios;
	}
	
	public Object getTipoUbicacionNegocioObject() {	
		this.tipoubicacionnegocioObject=this.tipoubicacionnegocioDataAccess.getEntityObject();
		return this.tipoubicacionnegocioObject;
	}
		
	public void setTipoUbicacionNegocioObject(Object newTipoUbicacionNegocioObject) {
		this.tipoubicacionnegocioObject = newTipoUbicacionNegocioObject;
	}
	
	public List<Object> getTipoUbicacionNegociosObject() {		
		this.tipoubicacionnegociosObject=this.tipoubicacionnegocioDataAccess.getEntitiesObject();
		return this.tipoubicacionnegociosObject;
	}
		
	public void setTipoUbicacionNegociosObject(List<Object> newTipoUbicacionNegociosObject) {
		this.tipoubicacionnegociosObject = newTipoUbicacionNegociosObject;
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
		
		if(this.tipoubicacionnegocioDataAccess!=null) {
			this.tipoubicacionnegocioDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoUbicacionNegocio.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoubicacionnegocioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoubicacionnegocioDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoubicacionnegocio = new  TipoUbicacionNegocio();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoUbicacionNegocio.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoubicacionnegocio=tipoubicacionnegocioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoubicacionnegocio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoUbicacionNegocioConstantesFunciones.refrescarForeignKeysDescripcionesTipoUbicacionNegocio(this.tipoubicacionnegocio);
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
		tipoubicacionnegocio = new  TipoUbicacionNegocio();
		  		  
        try {
			
			tipoubicacionnegocio=tipoubicacionnegocioDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoubicacionnegocio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoUbicacionNegocioConstantesFunciones.refrescarForeignKeysDescripcionesTipoUbicacionNegocio(this.tipoubicacionnegocio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoubicacionnegocio = new  TipoUbicacionNegocio();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoUbicacionNegocio.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoubicacionnegocio=tipoubicacionnegocioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoubicacionnegocio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoUbicacionNegocioConstantesFunciones.refrescarForeignKeysDescripcionesTipoUbicacionNegocio(this.tipoubicacionnegocio);
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
		tipoubicacionnegocio = new  TipoUbicacionNegocio();
		  		  
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
		tipoubicacionnegocio = new  TipoUbicacionNegocio();
		  		  
        try {
			
			tipoubicacionnegocio=tipoubicacionnegocioDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoubicacionnegocio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoUbicacionNegocioConstantesFunciones.refrescarForeignKeysDescripcionesTipoUbicacionNegocio(this.tipoubicacionnegocio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoubicacionnegocio = new  TipoUbicacionNegocio();
		  		  
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
		tipoubicacionnegocio = new  TipoUbicacionNegocio();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoUbicacionNegocio.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoubicacionnegocioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoubicacionnegocio = new  TipoUbicacionNegocio();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoubicacionnegocioDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoubicacionnegocio = new  TipoUbicacionNegocio();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoUbicacionNegocio.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoubicacionnegocioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoubicacionnegocio = new  TipoUbicacionNegocio();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoubicacionnegocioDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoubicacionnegocio = new  TipoUbicacionNegocio();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoUbicacionNegocio.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoubicacionnegocioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoubicacionnegocio = new  TipoUbicacionNegocio();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoubicacionnegocioDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoubicacionnegocios = new  ArrayList<TipoUbicacionNegocio>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoUbicacionNegocio.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoUbicacionNegocioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoubicacionnegocios=tipoubicacionnegocioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoUbicacionNegocio(tipoubicacionnegocios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoUbicacionNegocioConstantesFunciones.refrescarForeignKeysDescripcionesTipoUbicacionNegocio(this.tipoubicacionnegocios);
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
		tipoubicacionnegocios = new  ArrayList<TipoUbicacionNegocio>();
		  		  
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
		tipoubicacionnegocios = new  ArrayList<TipoUbicacionNegocio>();
		  		  
        try {			
			TipoUbicacionNegocioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoubicacionnegocios=tipoubicacionnegocioDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoUbicacionNegocio(tipoubicacionnegocios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoUbicacionNegocioConstantesFunciones.refrescarForeignKeysDescripcionesTipoUbicacionNegocio(this.tipoubicacionnegocios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoubicacionnegocios = new  ArrayList<TipoUbicacionNegocio>();
		  		  
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
		tipoubicacionnegocios = new  ArrayList<TipoUbicacionNegocio>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoUbicacionNegocio.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoUbicacionNegocioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoubicacionnegocios=tipoubicacionnegocioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoUbicacionNegocio(tipoubicacionnegocios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoUbicacionNegocioConstantesFunciones.refrescarForeignKeysDescripcionesTipoUbicacionNegocio(this.tipoubicacionnegocios);
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
		tipoubicacionnegocios = new  ArrayList<TipoUbicacionNegocio>();
		  		  
        try {
			TipoUbicacionNegocioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoubicacionnegocios=tipoubicacionnegocioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoUbicacionNegocio(tipoubicacionnegocios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoUbicacionNegocioConstantesFunciones.refrescarForeignKeysDescripcionesTipoUbicacionNegocio(this.tipoubicacionnegocios);
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
		tipoubicacionnegocios = new  ArrayList<TipoUbicacionNegocio>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoUbicacionNegocio.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoUbicacionNegocioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoubicacionnegocios=tipoubicacionnegocioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoUbicacionNegocio(tipoubicacionnegocios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoUbicacionNegocioConstantesFunciones.refrescarForeignKeysDescripcionesTipoUbicacionNegocio(this.tipoubicacionnegocios);
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
		tipoubicacionnegocios = new  ArrayList<TipoUbicacionNegocio>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoUbicacionNegocioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoubicacionnegocios=tipoubicacionnegocioDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoUbicacionNegocio(tipoubicacionnegocios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoUbicacionNegocioConstantesFunciones.refrescarForeignKeysDescripcionesTipoUbicacionNegocio(this.tipoubicacionnegocios);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoubicacionnegocio = new  TipoUbicacionNegocio();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoUbicacionNegocio.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoUbicacionNegocioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoubicacionnegocio=tipoubicacionnegocioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoUbicacionNegocio(tipoubicacionnegocio);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoUbicacionNegocioConstantesFunciones.refrescarForeignKeysDescripcionesTipoUbicacionNegocio(this.tipoubicacionnegocio);
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
		tipoubicacionnegocio = new  TipoUbicacionNegocio();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoUbicacionNegocioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoubicacionnegocio=tipoubicacionnegocioDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoUbicacionNegocio(tipoubicacionnegocio);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoUbicacionNegocioConstantesFunciones.refrescarForeignKeysDescripcionesTipoUbicacionNegocio(this.tipoubicacionnegocio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoUbicacionNegociosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoubicacionnegocios = new  ArrayList<TipoUbicacionNegocio>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoUbicacionNegocio.class.getSimpleName()+"-getTodosTipoUbicacionNegociosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoUbicacionNegocioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoubicacionnegocios=tipoubicacionnegocioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoUbicacionNegocio(tipoubicacionnegocios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoUbicacionNegocioConstantesFunciones.refrescarForeignKeysDescripcionesTipoUbicacionNegocio(this.tipoubicacionnegocios);
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
	
	public  void  getTodosTipoUbicacionNegocios(String sFinalQuery,Pagination pagination)throws Exception {
		tipoubicacionnegocios = new  ArrayList<TipoUbicacionNegocio>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoUbicacionNegocioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoubicacionnegocios=tipoubicacionnegocioDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoUbicacionNegocio(tipoubicacionnegocios);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoUbicacionNegocioConstantesFunciones.refrescarForeignKeysDescripcionesTipoUbicacionNegocio(this.tipoubicacionnegocios);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoUbicacionNegocio(TipoUbicacionNegocio tipoubicacionnegocio) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoubicacionnegocio.getIsNew() || tipoubicacionnegocio.getIsChanged()) { 
			this.invalidValues = tipoubicacionnegocioValidator.getInvalidValues(tipoubicacionnegocio);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoubicacionnegocio);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoUbicacionNegocio(List<TipoUbicacionNegocio> TipoUbicacionNegocios) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoUbicacionNegocio tipoubicacionnegocioLocal:tipoubicacionnegocios) {				
			estaValidadoObjeto=this.validarGuardarTipoUbicacionNegocio(tipoubicacionnegocioLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoUbicacionNegocio(List<TipoUbicacionNegocio> TipoUbicacionNegocios) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoUbicacionNegocio(tipoubicacionnegocios)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoUbicacionNegocio(TipoUbicacionNegocio TipoUbicacionNegocio) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoUbicacionNegocio(tipoubicacionnegocio)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoUbicacionNegocio tipoubicacionnegocio) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoubicacionnegocio.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoUbicacionNegocioConstantesFunciones.getTipoUbicacionNegocioLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoubicacionnegocio","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoUbicacionNegocioConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoUbicacionNegocioConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoUbicacionNegocioWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoUbicacionNegocio.class.getSimpleName()+"-saveTipoUbicacionNegocioWithConnection");connexion.begin();			
			
			//TipoUbicacionNegocioLogicAdditional.checkTipoUbicacionNegocioToSave(this.tipoubicacionnegocio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoUbicacionNegocioLogicAdditional.updateTipoUbicacionNegocioToSave(this.tipoubicacionnegocio,this.arrDatoGeneral);
			
			TipoUbicacionNegocioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoubicacionnegocio,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoUbicacionNegocio();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoUbicacionNegocio(this.tipoubicacionnegocio)) {
				TipoUbicacionNegocioDataAccess.save(this.tipoubicacionnegocio, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoubicacionnegocio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoUbicacionNegocioLogicAdditional.checkTipoUbicacionNegocioToSaveAfter(this.tipoubicacionnegocio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoUbicacionNegocio();
			
			connexion.commit();			
			
			if(this.tipoubicacionnegocio.getIsDeleted()) {
				this.tipoubicacionnegocio=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoUbicacionNegocio()throws Exception {	
		try {	
			
			//TipoUbicacionNegocioLogicAdditional.checkTipoUbicacionNegocioToSave(this.tipoubicacionnegocio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoUbicacionNegocioLogicAdditional.updateTipoUbicacionNegocioToSave(this.tipoubicacionnegocio,this.arrDatoGeneral);
			
			TipoUbicacionNegocioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoubicacionnegocio,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoUbicacionNegocio(this.tipoubicacionnegocio)) {			
				TipoUbicacionNegocioDataAccess.save(this.tipoubicacionnegocio, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoubicacionnegocio,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoUbicacionNegocioLogicAdditional.checkTipoUbicacionNegocioToSaveAfter(this.tipoubicacionnegocio,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoubicacionnegocio.getIsDeleted()) {
				this.tipoubicacionnegocio=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoUbicacionNegociosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoUbicacionNegocio.class.getSimpleName()+"-saveTipoUbicacionNegociosWithConnection");connexion.begin();			
			
			//TipoUbicacionNegocioLogicAdditional.checkTipoUbicacionNegocioToSaves(tipoubicacionnegocios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoUbicacionNegocios();
			
			Boolean validadoTodosTipoUbicacionNegocio=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoUbicacionNegocio tipoubicacionnegocioLocal:tipoubicacionnegocios) {		
				if(tipoubicacionnegocioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoUbicacionNegocioLogicAdditional.updateTipoUbicacionNegocioToSave(tipoubicacionnegocioLocal,this.arrDatoGeneral);
	        	
				TipoUbicacionNegocioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoubicacionnegocioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoUbicacionNegocio(tipoubicacionnegocioLocal)) {
					TipoUbicacionNegocioDataAccess.save(tipoubicacionnegocioLocal, connexion);				
				} else {
					validadoTodosTipoUbicacionNegocio=false;
				}
			}
			
			if(!validadoTodosTipoUbicacionNegocio) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoUbicacionNegocioLogicAdditional.checkTipoUbicacionNegocioToSavesAfter(tipoubicacionnegocios,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoUbicacionNegocios();
			
			connexion.commit();		
			
			this.quitarTipoUbicacionNegociosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoUbicacionNegocios()throws Exception {				
		 try {	
			//TipoUbicacionNegocioLogicAdditional.checkTipoUbicacionNegocioToSaves(tipoubicacionnegocios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoUbicacionNegocio=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoUbicacionNegocio tipoubicacionnegocioLocal:tipoubicacionnegocios) {				
				if(tipoubicacionnegocioLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoUbicacionNegocioLogicAdditional.updateTipoUbicacionNegocioToSave(tipoubicacionnegocioLocal,this.arrDatoGeneral);
	        	
				TipoUbicacionNegocioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoubicacionnegocioLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoUbicacionNegocio(tipoubicacionnegocioLocal)) {				
					TipoUbicacionNegocioDataAccess.save(tipoubicacionnegocioLocal, connexion);				
				} else {
					validadoTodosTipoUbicacionNegocio=false;
				}
			}
			
			if(!validadoTodosTipoUbicacionNegocio) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoUbicacionNegocioLogicAdditional.checkTipoUbicacionNegocioToSavesAfter(tipoubicacionnegocios,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoUbicacionNegociosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoUbicacionNegocioParameterReturnGeneral procesarAccionTipoUbicacionNegocios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoUbicacionNegocio> tipoubicacionnegocios,TipoUbicacionNegocioParameterReturnGeneral tipoubicacionnegocioParameterGeneral)throws Exception {
		 try {	
			TipoUbicacionNegocioParameterReturnGeneral tipoubicacionnegocioReturnGeneral=new TipoUbicacionNegocioParameterReturnGeneral();
	
			
			return tipoubicacionnegocioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoUbicacionNegocioParameterReturnGeneral procesarAccionTipoUbicacionNegociosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoUbicacionNegocio> tipoubicacionnegocios,TipoUbicacionNegocioParameterReturnGeneral tipoubicacionnegocioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoUbicacionNegocio.class.getSimpleName()+"-procesarAccionTipoUbicacionNegociosWithConnection");connexion.begin();			
			
			TipoUbicacionNegocioParameterReturnGeneral tipoubicacionnegocioReturnGeneral=new TipoUbicacionNegocioParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipoubicacionnegocioReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoUbicacionNegocioParameterReturnGeneral procesarEventosTipoUbicacionNegocios(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoUbicacionNegocio> tipoubicacionnegocios,TipoUbicacionNegocio tipoubicacionnegocio,TipoUbicacionNegocioParameterReturnGeneral tipoubicacionnegocioParameterGeneral,Boolean isEsNuevoTipoUbicacionNegocio,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoUbicacionNegocioParameterReturnGeneral tipoubicacionnegocioReturnGeneral=new TipoUbicacionNegocioParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoubicacionnegocioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipoubicacionnegocioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoUbicacionNegocioParameterReturnGeneral procesarEventosTipoUbicacionNegociosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoUbicacionNegocio> tipoubicacionnegocios,TipoUbicacionNegocio tipoubicacionnegocio,TipoUbicacionNegocioParameterReturnGeneral tipoubicacionnegocioParameterGeneral,Boolean isEsNuevoTipoUbicacionNegocio,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoUbicacionNegocio.class.getSimpleName()+"-procesarEventosTipoUbicacionNegociosWithConnection");connexion.begin();			
			
			TipoUbicacionNegocioParameterReturnGeneral tipoubicacionnegocioReturnGeneral=new TipoUbicacionNegocioParameterReturnGeneral();
	
			tipoubicacionnegocioReturnGeneral.setTipoUbicacionNegocio(tipoubicacionnegocio);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoubicacionnegocioReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipoubicacionnegocioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoUbicacionNegocioParameterReturnGeneral procesarImportacionTipoUbicacionNegociosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoUbicacionNegocioParameterReturnGeneral tipoubicacionnegocioParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoUbicacionNegocio.class.getSimpleName()+"-procesarImportacionTipoUbicacionNegociosWithConnection");connexion.begin();			
			
			TipoUbicacionNegocioParameterReturnGeneral tipoubicacionnegocioReturnGeneral=new TipoUbicacionNegocioParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoubicacionnegocios=new ArrayList<TipoUbicacionNegocio>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoubicacionnegocio=new TipoUbicacionNegocio();
				
				
				if(conColumnasBase) {this.tipoubicacionnegocio.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoubicacionnegocio.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoubicacionnegocio.setcodigo(arrColumnas[iColumn++]);
				this.tipoubicacionnegocio.setnombre(arrColumnas[iColumn++]);
				
				this.tipoubicacionnegocios.add(this.tipoubicacionnegocio);
			}
			
			this.saveTipoUbicacionNegocios();
			
			this.connexion.commit();
			
			tipoubicacionnegocioReturnGeneral.setConRetornoEstaProcesado(true);
			tipoubicacionnegocioReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoubicacionnegocioReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoUbicacionNegociosEliminados() throws Exception {				
		
		List<TipoUbicacionNegocio> tipoubicacionnegociosAux= new ArrayList<TipoUbicacionNegocio>();
		
		for(TipoUbicacionNegocio tipoubicacionnegocio:tipoubicacionnegocios) {
			if(!tipoubicacionnegocio.getIsDeleted()) {
				tipoubicacionnegociosAux.add(tipoubicacionnegocio);
			}
		}
		
		tipoubicacionnegocios=tipoubicacionnegociosAux;
	}
	
	public void quitarTipoUbicacionNegociosNulos() throws Exception {				
		
		List<TipoUbicacionNegocio> tipoubicacionnegociosAux= new ArrayList<TipoUbicacionNegocio>();
		
		for(TipoUbicacionNegocio tipoubicacionnegocio : this.tipoubicacionnegocios) {
			if(tipoubicacionnegocio==null) {
				tipoubicacionnegociosAux.add(tipoubicacionnegocio);
			}
		}
		
		//this.tipoubicacionnegocios=tipoubicacionnegociosAux;
		
		this.tipoubicacionnegocios.removeAll(tipoubicacionnegociosAux);
	}
	
	public void getSetVersionRowTipoUbicacionNegocioWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoubicacionnegocio.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoubicacionnegocio.getIsDeleted() || (tipoubicacionnegocio.getIsChanged()&&!tipoubicacionnegocio.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoubicacionnegocioDataAccess.getSetVersionRowTipoUbicacionNegocio(connexion,tipoubicacionnegocio.getId());
				
				if(!tipoubicacionnegocio.getVersionRow().equals(timestamp)) {	
					tipoubicacionnegocio.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoubicacionnegocio.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoUbicacionNegocio()throws Exception {	
		
		if(tipoubicacionnegocio.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoubicacionnegocio.getIsDeleted() || (tipoubicacionnegocio.getIsChanged()&&!tipoubicacionnegocio.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoubicacionnegocioDataAccess.getSetVersionRowTipoUbicacionNegocio(connexion,tipoubicacionnegocio.getId());
			
			try {							
				if(!tipoubicacionnegocio.getVersionRow().equals(timestamp)) {	
					tipoubicacionnegocio.setVersionRow(timestamp);
				}
				
				tipoubicacionnegocio.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoUbicacionNegociosWithConnection()throws Exception {	
		if(tipoubicacionnegocios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoUbicacionNegocio tipoubicacionnegocioAux:tipoubicacionnegocios) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoubicacionnegocioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoubicacionnegocioAux.getIsDeleted() || (tipoubicacionnegocioAux.getIsChanged()&&!tipoubicacionnegocioAux.getIsNew())) {
						
						timestamp=tipoubicacionnegocioDataAccess.getSetVersionRowTipoUbicacionNegocio(connexion,tipoubicacionnegocioAux.getId());
						
						if(!tipoubicacionnegocio.getVersionRow().equals(timestamp)) {	
							tipoubicacionnegocioAux.setVersionRow(timestamp);
						}
								
						tipoubicacionnegocioAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoUbicacionNegocios()throws Exception {	
		if(tipoubicacionnegocios!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoUbicacionNegocio tipoubicacionnegocioAux:tipoubicacionnegocios) {
					if(tipoubicacionnegocioAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoubicacionnegocioAux.getIsDeleted() || (tipoubicacionnegocioAux.getIsChanged()&&!tipoubicacionnegocioAux.getIsNew())) {
						
						timestamp=tipoubicacionnegocioDataAccess.getSetVersionRowTipoUbicacionNegocio(connexion,tipoubicacionnegocioAux.getId());
						
						if(!tipoubicacionnegocioAux.getVersionRow().equals(timestamp)) {	
							tipoubicacionnegocioAux.setVersionRow(timestamp);
						}
						
													
						tipoubicacionnegocioAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoUbicacionNegocioParameterReturnGeneral cargarCombosLoteForeignKeyTipoUbicacionNegocioWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoUbicacionNegocioParameterReturnGeneral  tipoubicacionnegocioReturnGeneral =new TipoUbicacionNegocioParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoUbicacionNegocio.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoUbicacionNegocioWithConnection");connexion.begin();
			
			tipoubicacionnegocioReturnGeneral =new TipoUbicacionNegocioParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoubicacionnegocioReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipoubicacionnegocioReturnGeneral;
	}
	
	public TipoUbicacionNegocioParameterReturnGeneral cargarCombosLoteForeignKeyTipoUbicacionNegocio(String finalQueryGlobalEmpresa) throws Exception {
		TipoUbicacionNegocioParameterReturnGeneral  tipoubicacionnegocioReturnGeneral =new TipoUbicacionNegocioParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipoubicacionnegocioReturnGeneral =new TipoUbicacionNegocioParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoubicacionnegocioReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipoubicacionnegocioReturnGeneral;
	}
	
	
	public void deepLoad(TipoUbicacionNegocio tipoubicacionnegocio,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoUbicacionNegocioLogicAdditional.updateTipoUbicacionNegocioToGet(tipoubicacionnegocio,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoubicacionnegocio.setEmpresa(tipoubicacionnegocioDataAccess.getEmpresa(connexion,tipoubicacionnegocio));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoubicacionnegocio.setEmpresa(tipoubicacionnegocioDataAccess.getEmpresa(connexion,tipoubicacionnegocio));
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
			tipoubicacionnegocio.setEmpresa(tipoubicacionnegocioDataAccess.getEmpresa(connexion,tipoubicacionnegocio));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoubicacionnegocio.setEmpresa(tipoubicacionnegocioDataAccess.getEmpresa(connexion,tipoubicacionnegocio));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoubicacionnegocio.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoubicacionnegocio.setEmpresa(tipoubicacionnegocioDataAccess.getEmpresa(connexion,tipoubicacionnegocio));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipoubicacionnegocio.getEmpresa(),isDeep,deepLoadType,clases);				
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
			tipoubicacionnegocio.setEmpresa(tipoubicacionnegocioDataAccess.getEmpresa(connexion,tipoubicacionnegocio));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipoubicacionnegocio.getEmpresa(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoUbicacionNegocio tipoubicacionnegocio,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoUbicacionNegocio.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoubicacionnegocio,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoUbicacionNegocioConstantesFunciones.refrescarForeignKeysDescripcionesTipoUbicacionNegocio(tipoubicacionnegocio);
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
			this.deepLoad(this.tipoubicacionnegocio,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoUbicacionNegocioConstantesFunciones.refrescarForeignKeysDescripcionesTipoUbicacionNegocio(this.tipoubicacionnegocio);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoUbicacionNegocio.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoubicacionnegocios!=null) {
				for(TipoUbicacionNegocio tipoubicacionnegocio:tipoubicacionnegocios) {
					this.deepLoad(tipoubicacionnegocio,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoUbicacionNegocioConstantesFunciones.refrescarForeignKeysDescripcionesTipoUbicacionNegocio(tipoubicacionnegocios);
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
			if(tipoubicacionnegocios!=null) {
				for(TipoUbicacionNegocio tipoubicacionnegocio:tipoubicacionnegocios) {
					this.deepLoad(tipoubicacionnegocio,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoUbicacionNegocioConstantesFunciones.refrescarForeignKeysDescripcionesTipoUbicacionNegocio(tipoubicacionnegocios);
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
	
	
	public void getTipoUbicacionNegociosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoUbicacionNegocio.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoUbicacionNegocioConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoUbicacionNegocioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoubicacionnegocios=tipoubicacionnegocioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoUbicacionNegocioConstantesFunciones.refrescarForeignKeysDescripcionesTipoUbicacionNegocio(this.tipoubicacionnegocios);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoUbicacionNegociosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoUbicacionNegocioConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoUbicacionNegocioLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoubicacionnegocios=tipoubicacionnegocioDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoUbicacionNegocioConstantesFunciones.refrescarForeignKeysDescripcionesTipoUbicacionNegocio(this.tipoubicacionnegocios);
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
			if(TipoUbicacionNegocioConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoUbicacionNegocioDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoUbicacionNegocio tipoubicacionnegocio,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoUbicacionNegocioConstantesFunciones.ISCONAUDITORIA) {
				if(tipoubicacionnegocio.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoUbicacionNegocioDataAccess.TABLENAME, tipoubicacionnegocio.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoUbicacionNegocioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoUbicacionNegocioLogic.registrarAuditoriaDetallesTipoUbicacionNegocio(connexion,tipoubicacionnegocio,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoubicacionnegocio.getIsDeleted()) {
					/*if(!tipoubicacionnegocio.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoUbicacionNegocioDataAccess.TABLENAME, tipoubicacionnegocio.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoUbicacionNegocioLogic.registrarAuditoriaDetallesTipoUbicacionNegocio(connexion,tipoubicacionnegocio,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoUbicacionNegocioDataAccess.TABLENAME, tipoubicacionnegocio.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoubicacionnegocio.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoUbicacionNegocioDataAccess.TABLENAME, tipoubicacionnegocio.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoUbicacionNegocioConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoUbicacionNegocioLogic.registrarAuditoriaDetallesTipoUbicacionNegocio(connexion,tipoubicacionnegocio,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoUbicacionNegocio(Connexion connexion,TipoUbicacionNegocio tipoubicacionnegocio)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoubicacionnegocio.getIsNew()||!tipoubicacionnegocio.getid_empresa().equals(tipoubicacionnegocio.getTipoUbicacionNegocioOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoubicacionnegocio.getTipoUbicacionNegocioOriginal().getid_empresa()!=null)
				{
					strValorActual=tipoubicacionnegocio.getTipoUbicacionNegocioOriginal().getid_empresa().toString();
				}
				if(tipoubicacionnegocio.getid_empresa()!=null)
				{
					strValorNuevo=tipoubicacionnegocio.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoUbicacionNegocioConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipoubicacionnegocio.getIsNew()||!tipoubicacionnegocio.getcodigo().equals(tipoubicacionnegocio.getTipoUbicacionNegocioOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoubicacionnegocio.getTipoUbicacionNegocioOriginal().getcodigo()!=null)
				{
					strValorActual=tipoubicacionnegocio.getTipoUbicacionNegocioOriginal().getcodigo();
				}
				if(tipoubicacionnegocio.getcodigo()!=null)
				{
					strValorNuevo=tipoubicacionnegocio.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoUbicacionNegocioConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipoubicacionnegocio.getIsNew()||!tipoubicacionnegocio.getnombre().equals(tipoubicacionnegocio.getTipoUbicacionNegocioOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoubicacionnegocio.getTipoUbicacionNegocioOriginal().getnombre()!=null)
				{
					strValorActual=tipoubicacionnegocio.getTipoUbicacionNegocioOriginal().getnombre();
				}
				if(tipoubicacionnegocio.getnombre()!=null)
				{
					strValorNuevo=tipoubicacionnegocio.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoUbicacionNegocioConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoUbicacionNegocio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoUbicacionNegocioConstantesFunciones.getClassesForeignKeysOfTipoUbicacionNegocio(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoUbicacionNegocio(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoUbicacionNegocioConstantesFunciones.getClassesRelationshipsOfTipoUbicacionNegocio(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

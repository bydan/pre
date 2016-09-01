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
import com.bydan.erp.cartera.util.TipoMoviFinanConstantesFunciones;
import com.bydan.erp.cartera.util.TipoMoviFinanParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoMoviFinanParameterGeneral;
import com.bydan.erp.cartera.business.entity.TipoMoviFinan;
import com.bydan.erp.cartera.business.logic.TipoMoviFinanLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoMoviFinanLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoMoviFinanLogic.class);
	
	protected TipoMoviFinanDataAccess tipomovifinanDataAccess; 	
	protected TipoMoviFinan tipomovifinan;
	protected List<TipoMoviFinan> tipomovifinans;
	protected Object tipomovifinanObject;	
	protected List<Object> tipomovifinansObject;
	
	public static ClassValidator<TipoMoviFinan> tipomovifinanValidator = new ClassValidator<TipoMoviFinan>(TipoMoviFinan.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoMoviFinanLogicAdditional tipomovifinanLogicAdditional=null;
	
	public TipoMoviFinanLogicAdditional getTipoMoviFinanLogicAdditional() {
		return this.tipomovifinanLogicAdditional;
	}
	
	public void setTipoMoviFinanLogicAdditional(TipoMoviFinanLogicAdditional tipomovifinanLogicAdditional) {
		try {
			this.tipomovifinanLogicAdditional=tipomovifinanLogicAdditional;
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
	
	
	
	
	public  TipoMoviFinanLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipomovifinanDataAccess = new TipoMoviFinanDataAccess();
			
			this.tipomovifinans= new ArrayList<TipoMoviFinan>();
			this.tipomovifinan= new TipoMoviFinan();
			
			this.tipomovifinanObject=new Object();
			this.tipomovifinansObject=new ArrayList<Object>();
				
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
			
			this.tipomovifinanDataAccess.setConnexionType(this.connexionType);
			this.tipomovifinanDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoMoviFinanLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipomovifinanDataAccess = new TipoMoviFinanDataAccess();
			this.tipomovifinans= new ArrayList<TipoMoviFinan>();
			this.tipomovifinan= new TipoMoviFinan();
			this.tipomovifinanObject=new Object();
			this.tipomovifinansObject=new ArrayList<Object>();
			
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
			
			this.tipomovifinanDataAccess.setConnexionType(this.connexionType);
			this.tipomovifinanDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoMoviFinan getTipoMoviFinan() throws Exception {	
		TipoMoviFinanLogicAdditional.checkTipoMoviFinanToGet(tipomovifinan,this.datosCliente,this.arrDatoGeneral);
		TipoMoviFinanLogicAdditional.updateTipoMoviFinanToGet(tipomovifinan,this.arrDatoGeneral);
		
		return tipomovifinan;
	}
		
	public void setTipoMoviFinan(TipoMoviFinan newTipoMoviFinan) {
		this.tipomovifinan = newTipoMoviFinan;
	}
	
	public TipoMoviFinanDataAccess getTipoMoviFinanDataAccess() {
		return tipomovifinanDataAccess;
	}
	
	public void setTipoMoviFinanDataAccess(TipoMoviFinanDataAccess newtipomovifinanDataAccess) {
		this.tipomovifinanDataAccess = newtipomovifinanDataAccess;
	}
	
	public List<TipoMoviFinan> getTipoMoviFinans() throws Exception {		
		this.quitarTipoMoviFinansNulos();
		
		TipoMoviFinanLogicAdditional.checkTipoMoviFinanToGets(tipomovifinans,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoMoviFinan tipomovifinanLocal: tipomovifinans ) {
			TipoMoviFinanLogicAdditional.updateTipoMoviFinanToGet(tipomovifinanLocal,this.arrDatoGeneral);
		}
		
		return tipomovifinans;
	}
	
	public void setTipoMoviFinans(List<TipoMoviFinan> newTipoMoviFinans) {
		this.tipomovifinans = newTipoMoviFinans;
	}
	
	public Object getTipoMoviFinanObject() {	
		this.tipomovifinanObject=this.tipomovifinanDataAccess.getEntityObject();
		return this.tipomovifinanObject;
	}
		
	public void setTipoMoviFinanObject(Object newTipoMoviFinanObject) {
		this.tipomovifinanObject = newTipoMoviFinanObject;
	}
	
	public List<Object> getTipoMoviFinansObject() {		
		this.tipomovifinansObject=this.tipomovifinanDataAccess.getEntitiesObject();
		return this.tipomovifinansObject;
	}
		
	public void setTipoMoviFinansObject(List<Object> newTipoMoviFinansObject) {
		this.tipomovifinansObject = newTipoMoviFinansObject;
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
		
		if(this.tipomovifinanDataAccess!=null) {
			this.tipomovifinanDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoviFinan.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipomovifinanDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipomovifinanDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipomovifinan = new  TipoMoviFinan();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoviFinan.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipomovifinan=tipomovifinanDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipomovifinan,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoMoviFinanConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoviFinan(this.tipomovifinan);
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
		tipomovifinan = new  TipoMoviFinan();
		  		  
        try {
			
			tipomovifinan=tipomovifinanDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipomovifinan,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoMoviFinanConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoviFinan(this.tipomovifinan);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipomovifinan = new  TipoMoviFinan();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoviFinan.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipomovifinan=tipomovifinanDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipomovifinan,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoMoviFinanConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoviFinan(this.tipomovifinan);
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
		tipomovifinan = new  TipoMoviFinan();
		  		  
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
		tipomovifinan = new  TipoMoviFinan();
		  		  
        try {
			
			tipomovifinan=tipomovifinanDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipomovifinan,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoMoviFinanConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoviFinan(this.tipomovifinan);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipomovifinan = new  TipoMoviFinan();
		  		  
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
		tipomovifinan = new  TipoMoviFinan();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoviFinan.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipomovifinanDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipomovifinan = new  TipoMoviFinan();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipomovifinanDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipomovifinan = new  TipoMoviFinan();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoviFinan.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipomovifinanDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipomovifinan = new  TipoMoviFinan();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipomovifinanDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipomovifinan = new  TipoMoviFinan();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoviFinan.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipomovifinanDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipomovifinan = new  TipoMoviFinan();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipomovifinanDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipomovifinans = new  ArrayList<TipoMoviFinan>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoviFinan.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoMoviFinanLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomovifinans=tipomovifinanDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoMoviFinan(tipomovifinans);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMoviFinanConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoviFinan(this.tipomovifinans);
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
		tipomovifinans = new  ArrayList<TipoMoviFinan>();
		  		  
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
		tipomovifinans = new  ArrayList<TipoMoviFinan>();
		  		  
        try {			
			TipoMoviFinanLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomovifinans=tipomovifinanDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoMoviFinan(tipomovifinans);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMoviFinanConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoviFinan(this.tipomovifinans);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipomovifinans = new  ArrayList<TipoMoviFinan>();
		  		  
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
		tipomovifinans = new  ArrayList<TipoMoviFinan>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoviFinan.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoMoviFinanLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomovifinans=tipomovifinanDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoMoviFinan(tipomovifinans);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMoviFinanConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoviFinan(this.tipomovifinans);
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
		tipomovifinans = new  ArrayList<TipoMoviFinan>();
		  		  
        try {
			TipoMoviFinanLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomovifinans=tipomovifinanDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoMoviFinan(tipomovifinans);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMoviFinanConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoviFinan(this.tipomovifinans);
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
		tipomovifinans = new  ArrayList<TipoMoviFinan>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoviFinan.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoMoviFinanLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomovifinans=tipomovifinanDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoMoviFinan(tipomovifinans);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMoviFinanConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoviFinan(this.tipomovifinans);
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
		tipomovifinans = new  ArrayList<TipoMoviFinan>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoMoviFinanLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomovifinans=tipomovifinanDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoMoviFinan(tipomovifinans);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMoviFinanConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoviFinan(this.tipomovifinans);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipomovifinan = new  TipoMoviFinan();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoviFinan.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoMoviFinanLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomovifinan=tipomovifinanDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoMoviFinan(tipomovifinan);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMoviFinanConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoviFinan(this.tipomovifinan);
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
		tipomovifinan = new  TipoMoviFinan();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoMoviFinanLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomovifinan=tipomovifinanDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoMoviFinan(tipomovifinan);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMoviFinanConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoviFinan(this.tipomovifinan);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipomovifinans = new  ArrayList<TipoMoviFinan>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoviFinan.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoMoviFinanLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomovifinans=tipomovifinanDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoMoviFinan(tipomovifinans);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMoviFinanConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoviFinan(this.tipomovifinans);
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
		tipomovifinans = new  ArrayList<TipoMoviFinan>();
		  		  
        try {
			TipoMoviFinanLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomovifinans=tipomovifinanDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoMoviFinan(tipomovifinans);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMoviFinanConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoviFinan(this.tipomovifinans);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoMoviFinansWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipomovifinans = new  ArrayList<TipoMoviFinan>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoviFinan.class.getSimpleName()+"-getTodosTipoMoviFinansWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoMoviFinanLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomovifinans=tipomovifinanDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoMoviFinan(tipomovifinans);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMoviFinanConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoviFinan(this.tipomovifinans);
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
	
	public  void  getTodosTipoMoviFinans(String sFinalQuery,Pagination pagination)throws Exception {
		tipomovifinans = new  ArrayList<TipoMoviFinan>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoMoviFinanLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomovifinans=tipomovifinanDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoMoviFinan(tipomovifinans);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMoviFinanConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoviFinan(this.tipomovifinans);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoMoviFinan(TipoMoviFinan tipomovifinan) throws Exception {
		Boolean estaValidado=false;
		
		if(tipomovifinan.getIsNew() || tipomovifinan.getIsChanged()) { 
			this.invalidValues = tipomovifinanValidator.getInvalidValues(tipomovifinan);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipomovifinan);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoMoviFinan(List<TipoMoviFinan> TipoMoviFinans) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoMoviFinan tipomovifinanLocal:tipomovifinans) {				
			estaValidadoObjeto=this.validarGuardarTipoMoviFinan(tipomovifinanLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoMoviFinan(List<TipoMoviFinan> TipoMoviFinans) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoMoviFinan(tipomovifinans)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoMoviFinan(TipoMoviFinan TipoMoviFinan) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoMoviFinan(tipomovifinan)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoMoviFinan tipomovifinan) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipomovifinan.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoMoviFinanConstantesFunciones.getTipoMoviFinanLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipomovifinan","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoMoviFinanConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoMoviFinanConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoMoviFinanWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoviFinan.class.getSimpleName()+"-saveTipoMoviFinanWithConnection");connexion.begin();			
			
			TipoMoviFinanLogicAdditional.checkTipoMoviFinanToSave(this.tipomovifinan,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoMoviFinanLogicAdditional.updateTipoMoviFinanToSave(this.tipomovifinan,this.arrDatoGeneral);
			
			TipoMoviFinanLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipomovifinan,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoMoviFinan();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoMoviFinan(this.tipomovifinan)) {
				TipoMoviFinanDataAccess.save(this.tipomovifinan, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipomovifinan,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoMoviFinanLogicAdditional.checkTipoMoviFinanToSaveAfter(this.tipomovifinan,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoMoviFinan();
			
			connexion.commit();			
			
			if(this.tipomovifinan.getIsDeleted()) {
				this.tipomovifinan=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoMoviFinan()throws Exception {	
		try {	
			
			TipoMoviFinanLogicAdditional.checkTipoMoviFinanToSave(this.tipomovifinan,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoMoviFinanLogicAdditional.updateTipoMoviFinanToSave(this.tipomovifinan,this.arrDatoGeneral);
			
			TipoMoviFinanLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipomovifinan,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoMoviFinan(this.tipomovifinan)) {			
				TipoMoviFinanDataAccess.save(this.tipomovifinan, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipomovifinan,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoMoviFinanLogicAdditional.checkTipoMoviFinanToSaveAfter(this.tipomovifinan,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipomovifinan.getIsDeleted()) {
				this.tipomovifinan=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoMoviFinansWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoviFinan.class.getSimpleName()+"-saveTipoMoviFinansWithConnection");connexion.begin();			
			
			TipoMoviFinanLogicAdditional.checkTipoMoviFinanToSaves(tipomovifinans,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoMoviFinans();
			
			Boolean validadoTodosTipoMoviFinan=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoMoviFinan tipomovifinanLocal:tipomovifinans) {		
				if(tipomovifinanLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoMoviFinanLogicAdditional.updateTipoMoviFinanToSave(tipomovifinanLocal,this.arrDatoGeneral);
	        	
				TipoMoviFinanLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipomovifinanLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoMoviFinan(tipomovifinanLocal)) {
					TipoMoviFinanDataAccess.save(tipomovifinanLocal, connexion);				
				} else {
					validadoTodosTipoMoviFinan=false;
				}
			}
			
			if(!validadoTodosTipoMoviFinan) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoMoviFinanLogicAdditional.checkTipoMoviFinanToSavesAfter(tipomovifinans,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoMoviFinans();
			
			connexion.commit();		
			
			this.quitarTipoMoviFinansEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoMoviFinans()throws Exception {				
		 try {	
			TipoMoviFinanLogicAdditional.checkTipoMoviFinanToSaves(tipomovifinans,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoMoviFinan=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoMoviFinan tipomovifinanLocal:tipomovifinans) {				
				if(tipomovifinanLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoMoviFinanLogicAdditional.updateTipoMoviFinanToSave(tipomovifinanLocal,this.arrDatoGeneral);
	        	
				TipoMoviFinanLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipomovifinanLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoMoviFinan(tipomovifinanLocal)) {				
					TipoMoviFinanDataAccess.save(tipomovifinanLocal, connexion);				
				} else {
					validadoTodosTipoMoviFinan=false;
				}
			}
			
			if(!validadoTodosTipoMoviFinan) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoMoviFinanLogicAdditional.checkTipoMoviFinanToSavesAfter(tipomovifinans,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoMoviFinansEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoMoviFinanParameterReturnGeneral procesarAccionTipoMoviFinans(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoMoviFinan> tipomovifinans,TipoMoviFinanParameterReturnGeneral tipomovifinanParameterGeneral)throws Exception {
		 try {	
			TipoMoviFinanParameterReturnGeneral tipomovifinanReturnGeneral=new TipoMoviFinanParameterReturnGeneral();
	
			TipoMoviFinanLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipomovifinans,tipomovifinanParameterGeneral,tipomovifinanReturnGeneral);
			
			return tipomovifinanReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoMoviFinanParameterReturnGeneral procesarAccionTipoMoviFinansWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoMoviFinan> tipomovifinans,TipoMoviFinanParameterReturnGeneral tipomovifinanParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoviFinan.class.getSimpleName()+"-procesarAccionTipoMoviFinansWithConnection");connexion.begin();			
			
			TipoMoviFinanParameterReturnGeneral tipomovifinanReturnGeneral=new TipoMoviFinanParameterReturnGeneral();
	
			TipoMoviFinanLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipomovifinans,tipomovifinanParameterGeneral,tipomovifinanReturnGeneral);
			
			this.connexion.commit();
			
			return tipomovifinanReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoMoviFinanParameterReturnGeneral procesarEventosTipoMoviFinans(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoMoviFinan> tipomovifinans,TipoMoviFinan tipomovifinan,TipoMoviFinanParameterReturnGeneral tipomovifinanParameterGeneral,Boolean isEsNuevoTipoMoviFinan,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoMoviFinanParameterReturnGeneral tipomovifinanReturnGeneral=new TipoMoviFinanParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipomovifinanReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoMoviFinanLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipomovifinans,tipomovifinan,tipomovifinanParameterGeneral,tipomovifinanReturnGeneral,isEsNuevoTipoMoviFinan,clases);
			
			return tipomovifinanReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoMoviFinanParameterReturnGeneral procesarEventosTipoMoviFinansWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoMoviFinan> tipomovifinans,TipoMoviFinan tipomovifinan,TipoMoviFinanParameterReturnGeneral tipomovifinanParameterGeneral,Boolean isEsNuevoTipoMoviFinan,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoviFinan.class.getSimpleName()+"-procesarEventosTipoMoviFinansWithConnection");connexion.begin();			
			
			TipoMoviFinanParameterReturnGeneral tipomovifinanReturnGeneral=new TipoMoviFinanParameterReturnGeneral();
	
			tipomovifinanReturnGeneral.setTipoMoviFinan(tipomovifinan);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipomovifinanReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoMoviFinanLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipomovifinans,tipomovifinan,tipomovifinanParameterGeneral,tipomovifinanReturnGeneral,isEsNuevoTipoMoviFinan,clases);
			
			this.connexion.commit();
			
			return tipomovifinanReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoMoviFinanParameterReturnGeneral procesarImportacionTipoMoviFinansWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoMoviFinanParameterReturnGeneral tipomovifinanParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoviFinan.class.getSimpleName()+"-procesarImportacionTipoMoviFinansWithConnection");connexion.begin();			
			
			TipoMoviFinanParameterReturnGeneral tipomovifinanReturnGeneral=new TipoMoviFinanParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipomovifinans=new ArrayList<TipoMoviFinan>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipomovifinan=new TipoMoviFinan();
				
				
				if(conColumnasBase) {this.tipomovifinan.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipomovifinan.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipomovifinan.setcodigo(arrColumnas[iColumn++]);
				this.tipomovifinan.setnombre(arrColumnas[iColumn++]);
				
				this.tipomovifinans.add(this.tipomovifinan);
			}
			
			this.saveTipoMoviFinans();
			
			this.connexion.commit();
			
			tipomovifinanReturnGeneral.setConRetornoEstaProcesado(true);
			tipomovifinanReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipomovifinanReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoMoviFinansEliminados() throws Exception {				
		
		List<TipoMoviFinan> tipomovifinansAux= new ArrayList<TipoMoviFinan>();
		
		for(TipoMoviFinan tipomovifinan:tipomovifinans) {
			if(!tipomovifinan.getIsDeleted()) {
				tipomovifinansAux.add(tipomovifinan);
			}
		}
		
		tipomovifinans=tipomovifinansAux;
	}
	
	public void quitarTipoMoviFinansNulos() throws Exception {				
		
		List<TipoMoviFinan> tipomovifinansAux= new ArrayList<TipoMoviFinan>();
		
		for(TipoMoviFinan tipomovifinan : this.tipomovifinans) {
			if(tipomovifinan==null) {
				tipomovifinansAux.add(tipomovifinan);
			}
		}
		
		//this.tipomovifinans=tipomovifinansAux;
		
		this.tipomovifinans.removeAll(tipomovifinansAux);
	}
	
	public void getSetVersionRowTipoMoviFinanWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipomovifinan.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipomovifinan.getIsDeleted() || (tipomovifinan.getIsChanged()&&!tipomovifinan.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipomovifinanDataAccess.getSetVersionRowTipoMoviFinan(connexion,tipomovifinan.getId());
				
				if(!tipomovifinan.getVersionRow().equals(timestamp)) {	
					tipomovifinan.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipomovifinan.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoMoviFinan()throws Exception {	
		
		if(tipomovifinan.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipomovifinan.getIsDeleted() || (tipomovifinan.getIsChanged()&&!tipomovifinan.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipomovifinanDataAccess.getSetVersionRowTipoMoviFinan(connexion,tipomovifinan.getId());
			
			try {							
				if(!tipomovifinan.getVersionRow().equals(timestamp)) {	
					tipomovifinan.setVersionRow(timestamp);
				}
				
				tipomovifinan.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoMoviFinansWithConnection()throws Exception {	
		if(tipomovifinans!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoMoviFinan tipomovifinanAux:tipomovifinans) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipomovifinanAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipomovifinanAux.getIsDeleted() || (tipomovifinanAux.getIsChanged()&&!tipomovifinanAux.getIsNew())) {
						
						timestamp=tipomovifinanDataAccess.getSetVersionRowTipoMoviFinan(connexion,tipomovifinanAux.getId());
						
						if(!tipomovifinan.getVersionRow().equals(timestamp)) {	
							tipomovifinanAux.setVersionRow(timestamp);
						}
								
						tipomovifinanAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoMoviFinans()throws Exception {	
		if(tipomovifinans!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoMoviFinan tipomovifinanAux:tipomovifinans) {
					if(tipomovifinanAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipomovifinanAux.getIsDeleted() || (tipomovifinanAux.getIsChanged()&&!tipomovifinanAux.getIsNew())) {
						
						timestamp=tipomovifinanDataAccess.getSetVersionRowTipoMoviFinan(connexion,tipomovifinanAux.getId());
						
						if(!tipomovifinanAux.getVersionRow().equals(timestamp)) {	
							tipomovifinanAux.setVersionRow(timestamp);
						}
						
													
						tipomovifinanAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoMoviFinanParameterReturnGeneral cargarCombosLoteForeignKeyTipoMoviFinanWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoMoviFinanParameterReturnGeneral  tipomovifinanReturnGeneral =new TipoMoviFinanParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoviFinan.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoMoviFinanWithConnection");connexion.begin();
			
			tipomovifinanReturnGeneral =new TipoMoviFinanParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipomovifinanReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipomovifinanReturnGeneral;
	}
	
	public TipoMoviFinanParameterReturnGeneral cargarCombosLoteForeignKeyTipoMoviFinan(String finalQueryGlobalEmpresa) throws Exception {
		TipoMoviFinanParameterReturnGeneral  tipomovifinanReturnGeneral =new TipoMoviFinanParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipomovifinanReturnGeneral =new TipoMoviFinanParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipomovifinanReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipomovifinanReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoMoviFinanWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			InformacionFinancieraLogic informacionfinancieraLogic=new InformacionFinancieraLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoviFinan.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoMoviFinanWithConnection");connexion.begin();
			
			
			classes.add(new Classe(InformacionFinanciera.class));
											
			

			informacionfinancieraLogic.setConnexion(this.getConnexion());
			informacionfinancieraLogic.setDatosCliente(this.datosCliente);
			informacionfinancieraLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoMoviFinan tipomovifinan:this.tipomovifinans) {
				

				classes=new ArrayList<Classe>();
				classes=InformacionFinancieraConstantesFunciones.getClassesForeignKeysOfInformacionFinanciera(new ArrayList<Classe>(),DeepLoadType.NONE);

				informacionfinancieraLogic.setInformacionFinancieras(tipomovifinan.informacionfinancieras);
				informacionfinancieraLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoMoviFinan tipomovifinan,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoMoviFinanLogicAdditional.updateTipoMoviFinanToGet(tipomovifinan,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipomovifinan.setEmpresa(tipomovifinanDataAccess.getEmpresa(connexion,tipomovifinan));
		tipomovifinan.setInformacionFinancieras(tipomovifinanDataAccess.getInformacionFinancieras(connexion,tipomovifinan));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipomovifinan.setEmpresa(tipomovifinanDataAccess.getEmpresa(connexion,tipomovifinan));
				continue;
			}

			if(clas.clas.equals(InformacionFinanciera.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipomovifinan.setInformacionFinancieras(tipomovifinanDataAccess.getInformacionFinancieras(connexion,tipomovifinan));

				if(this.isConDeep) {
					InformacionFinancieraLogic informacionfinancieraLogic= new InformacionFinancieraLogic(this.connexion);
					informacionfinancieraLogic.setInformacionFinancieras(tipomovifinan.getInformacionFinancieras());
					ArrayList<Classe> classesLocal=InformacionFinancieraConstantesFunciones.getClassesForeignKeysOfInformacionFinanciera(new ArrayList<Classe>(),DeepLoadType.NONE);
					informacionfinancieraLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					InformacionFinancieraConstantesFunciones.refrescarForeignKeysDescripcionesInformacionFinanciera(informacionfinancieraLogic.getInformacionFinancieras());
					tipomovifinan.setInformacionFinancieras(informacionfinancieraLogic.getInformacionFinancieras());
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
			tipomovifinan.setEmpresa(tipomovifinanDataAccess.getEmpresa(connexion,tipomovifinan));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(InformacionFinanciera.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(InformacionFinanciera.class));
			tipomovifinan.setInformacionFinancieras(tipomovifinanDataAccess.getInformacionFinancieras(connexion,tipomovifinan));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipomovifinan.setEmpresa(tipomovifinanDataAccess.getEmpresa(connexion,tipomovifinan));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipomovifinan.getEmpresa(),isDeep,deepLoadType,clases);
				

		tipomovifinan.setInformacionFinancieras(tipomovifinanDataAccess.getInformacionFinancieras(connexion,tipomovifinan));

		for(InformacionFinanciera informacionfinanciera:tipomovifinan.getInformacionFinancieras()) {
			InformacionFinancieraLogic informacionfinancieraLogic= new InformacionFinancieraLogic(connexion);
			informacionfinancieraLogic.deepLoad(informacionfinanciera,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipomovifinan.setEmpresa(tipomovifinanDataAccess.getEmpresa(connexion,tipomovifinan));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipomovifinan.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(InformacionFinanciera.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipomovifinan.setInformacionFinancieras(tipomovifinanDataAccess.getInformacionFinancieras(connexion,tipomovifinan));

				for(InformacionFinanciera informacionfinanciera:tipomovifinan.getInformacionFinancieras()) {
					InformacionFinancieraLogic informacionfinancieraLogic= new InformacionFinancieraLogic(connexion);
					informacionfinancieraLogic.deepLoad(informacionfinanciera,isDeep,deepLoadType,clases);
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
			tipomovifinan.setEmpresa(tipomovifinanDataAccess.getEmpresa(connexion,tipomovifinan));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipomovifinan.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(InformacionFinanciera.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(InformacionFinanciera.class));
			tipomovifinan.setInformacionFinancieras(tipomovifinanDataAccess.getInformacionFinancieras(connexion,tipomovifinan));

			for(InformacionFinanciera informacionfinanciera:tipomovifinan.getInformacionFinancieras()) {
				InformacionFinancieraLogic informacionfinancieraLogic= new InformacionFinancieraLogic(connexion);
				informacionfinancieraLogic.deepLoad(informacionfinanciera,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoMoviFinan tipomovifinan,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoMoviFinanLogicAdditional.updateTipoMoviFinanToSave(tipomovifinan,this.arrDatoGeneral);
			
TipoMoviFinanDataAccess.save(tipomovifinan, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipomovifinan.getEmpresa(),connexion);

		for(InformacionFinanciera informacionfinanciera:tipomovifinan.getInformacionFinancieras()) {
			informacionfinanciera.setidvalorclientemovimiento(tipomovifinan.getId());
			InformacionFinancieraDataAccess.save(informacionfinanciera,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipomovifinan.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(InformacionFinanciera.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(InformacionFinanciera informacionfinanciera:tipomovifinan.getInformacionFinancieras()) {
					informacionfinanciera.setidvalorclientemovimiento(tipomovifinan.getId());
					InformacionFinancieraDataAccess.save(informacionfinanciera,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipomovifinan.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipomovifinan.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(InformacionFinanciera informacionfinanciera:tipomovifinan.getInformacionFinancieras()) {
			InformacionFinancieraLogic informacionfinancieraLogic= new InformacionFinancieraLogic(connexion);
			informacionfinanciera.setidvalorclientemovimiento(tipomovifinan.getId());
			InformacionFinancieraDataAccess.save(informacionfinanciera,connexion);
			informacionfinancieraLogic.deepSave(informacionfinanciera,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipomovifinan.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipomovifinan.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(InformacionFinanciera.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(InformacionFinanciera informacionfinanciera:tipomovifinan.getInformacionFinancieras()) {
					InformacionFinancieraLogic informacionfinancieraLogic= new InformacionFinancieraLogic(connexion);
					informacionfinanciera.setidvalorclientemovimiento(tipomovifinan.getId());
					InformacionFinancieraDataAccess.save(informacionfinanciera,connexion);
					informacionfinancieraLogic.deepSave(informacionfinanciera,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoMoviFinan.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipomovifinan,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoMoviFinanConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoviFinan(tipomovifinan);
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
			this.deepLoad(this.tipomovifinan,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoMoviFinanConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoviFinan(this.tipomovifinan);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoMoviFinan.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipomovifinans!=null) {
				for(TipoMoviFinan tipomovifinan:tipomovifinans) {
					this.deepLoad(tipomovifinan,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoMoviFinanConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoviFinan(tipomovifinans);
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
			if(tipomovifinans!=null) {
				for(TipoMoviFinan tipomovifinan:tipomovifinans) {
					this.deepLoad(tipomovifinan,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoMoviFinanConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoviFinan(tipomovifinans);
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
			this.getNewConnexionToDeep(TipoMoviFinan.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipomovifinan,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoMoviFinan.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipomovifinans!=null) {
				for(TipoMoviFinan tipomovifinan:tipomovifinans) {
					this.deepSave(tipomovifinan,isDeep,deepLoadType,clases);
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
			if(tipomovifinans!=null) {
				for(TipoMoviFinan tipomovifinan:tipomovifinans) {
					this.deepSave(tipomovifinan,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoMoviFinansFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMoviFinan.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoMoviFinanConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoMoviFinanLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipomovifinans=tipomovifinanDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoMoviFinanConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoviFinan(this.tipomovifinans);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoMoviFinansFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoMoviFinanConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoMoviFinanLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipomovifinans=tipomovifinanDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoMoviFinanConstantesFunciones.refrescarForeignKeysDescripcionesTipoMoviFinan(this.tipomovifinans);
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
			if(TipoMoviFinanConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoMoviFinanDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoMoviFinan tipomovifinan,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoMoviFinanConstantesFunciones.ISCONAUDITORIA) {
				if(tipomovifinan.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoMoviFinanDataAccess.TABLENAME, tipomovifinan.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoMoviFinanConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoMoviFinanLogic.registrarAuditoriaDetallesTipoMoviFinan(connexion,tipomovifinan,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipomovifinan.getIsDeleted()) {
					/*if(!tipomovifinan.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoMoviFinanDataAccess.TABLENAME, tipomovifinan.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoMoviFinanLogic.registrarAuditoriaDetallesTipoMoviFinan(connexion,tipomovifinan,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoMoviFinanDataAccess.TABLENAME, tipomovifinan.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipomovifinan.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoMoviFinanDataAccess.TABLENAME, tipomovifinan.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoMoviFinanConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoMoviFinanLogic.registrarAuditoriaDetallesTipoMoviFinan(connexion,tipomovifinan,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoMoviFinan(Connexion connexion,TipoMoviFinan tipomovifinan)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipomovifinan.getIsNew()||!tipomovifinan.getid_empresa().equals(tipomovifinan.getTipoMoviFinanOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipomovifinan.getTipoMoviFinanOriginal().getid_empresa()!=null)
				{
					strValorActual=tipomovifinan.getTipoMoviFinanOriginal().getid_empresa().toString();
				}
				if(tipomovifinan.getid_empresa()!=null)
				{
					strValorNuevo=tipomovifinan.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoMoviFinanConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipomovifinan.getIsNew()||!tipomovifinan.getcodigo().equals(tipomovifinan.getTipoMoviFinanOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipomovifinan.getTipoMoviFinanOriginal().getcodigo()!=null)
				{
					strValorActual=tipomovifinan.getTipoMoviFinanOriginal().getcodigo();
				}
				if(tipomovifinan.getcodigo()!=null)
				{
					strValorNuevo=tipomovifinan.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoMoviFinanConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipomovifinan.getIsNew()||!tipomovifinan.getnombre().equals(tipomovifinan.getTipoMoviFinanOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipomovifinan.getTipoMoviFinanOriginal().getnombre()!=null)
				{
					strValorActual=tipomovifinan.getTipoMoviFinanOriginal().getnombre();
				}
				if(tipomovifinan.getnombre()!=null)
				{
					strValorNuevo=tipomovifinan.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoMoviFinanConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoMoviFinanRelacionesWithConnection(TipoMoviFinan tipomovifinan,List<InformacionFinanciera> informacionfinancieras) throws Exception {

		if(!tipomovifinan.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoMoviFinanRelacionesBase(tipomovifinan,informacionfinancieras,true);
		}
	}

	public void saveTipoMoviFinanRelaciones(TipoMoviFinan tipomovifinan,List<InformacionFinanciera> informacionfinancieras)throws Exception {

		if(!tipomovifinan.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoMoviFinanRelacionesBase(tipomovifinan,informacionfinancieras,false);
		}
	}

	public void saveTipoMoviFinanRelacionesBase(TipoMoviFinan tipomovifinan,List<InformacionFinanciera> informacionfinancieras,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoMoviFinan-saveRelacionesWithConnection");}
	
			tipomovifinan.setInformacionFinancieras(informacionfinancieras);

			this.setTipoMoviFinan(tipomovifinan);

			if(TipoMoviFinanLogicAdditional.validarSaveRelaciones(tipomovifinan,this)) {

				TipoMoviFinanLogicAdditional.updateRelacionesToSave(tipomovifinan,this);

				if((tipomovifinan.getIsNew()||tipomovifinan.getIsChanged())&&!tipomovifinan.getIsDeleted()) {
					this.saveTipoMoviFinan();
					this.saveTipoMoviFinanRelacionesDetalles(informacionfinancieras);

				} else if(tipomovifinan.getIsDeleted()) {
					this.saveTipoMoviFinanRelacionesDetalles(informacionfinancieras);
					this.saveTipoMoviFinan();
				}

				TipoMoviFinanLogicAdditional.updateRelacionesToSaveAfter(tipomovifinan,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			InformacionFinancieraConstantesFunciones.InicializarGeneralEntityAuxiliaresInformacionFinancieras(informacionfinancieras,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoMoviFinanRelacionesDetalles(List<InformacionFinanciera> informacionfinancieras)throws Exception {
		try {
	

			Long idTipoMoviFinanActual=this.getTipoMoviFinan().getId();

			InformacionFinancieraLogic informacionfinancieraLogic_Desde_TipoMoviFinan=new InformacionFinancieraLogic();
			informacionfinancieraLogic_Desde_TipoMoviFinan.setInformacionFinancieras(informacionfinancieras);

			informacionfinancieraLogic_Desde_TipoMoviFinan.setConnexion(this.getConnexion());
			informacionfinancieraLogic_Desde_TipoMoviFinan.setDatosCliente(this.datosCliente);

			for(InformacionFinanciera informacionfinanciera_Desde_TipoMoviFinan:informacionfinancieraLogic_Desde_TipoMoviFinan.getInformacionFinancieras()) {
				informacionfinanciera_Desde_TipoMoviFinan.setidvalorclientemovimiento(idTipoMoviFinanActual);
			}

			informacionfinancieraLogic_Desde_TipoMoviFinan.saveInformacionFinancieras();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoMoviFinan(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoMoviFinanConstantesFunciones.getClassesForeignKeysOfTipoMoviFinan(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoMoviFinan(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoMoviFinanConstantesFunciones.getClassesRelationshipsOfTipoMoviFinan(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

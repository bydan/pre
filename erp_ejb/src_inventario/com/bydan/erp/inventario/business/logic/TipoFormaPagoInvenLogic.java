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
package com.bydan.erp.inventario.business.logic;

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
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.inventario.util.TipoFormaPagoInvenConstantesFunciones;
import com.bydan.erp.inventario.util.TipoFormaPagoInvenParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TipoFormaPagoInvenParameterGeneral;
import com.bydan.erp.inventario.business.entity.TipoFormaPagoInven;
import com.bydan.erp.inventario.business.logic.TipoFormaPagoInvenLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoFormaPagoInvenLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoFormaPagoInvenLogic.class);
	
	protected TipoFormaPagoInvenDataAccess tipoformapagoinvenDataAccess; 	
	protected TipoFormaPagoInven tipoformapagoinven;
	protected List<TipoFormaPagoInven> tipoformapagoinvens;
	protected Object tipoformapagoinvenObject;	
	protected List<Object> tipoformapagoinvensObject;
	
	public static ClassValidator<TipoFormaPagoInven> tipoformapagoinvenValidator = new ClassValidator<TipoFormaPagoInven>(TipoFormaPagoInven.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoFormaPagoInvenLogicAdditional tipoformapagoinvenLogicAdditional=null;
	
	public TipoFormaPagoInvenLogicAdditional getTipoFormaPagoInvenLogicAdditional() {
		return this.tipoformapagoinvenLogicAdditional;
	}
	
	public void setTipoFormaPagoInvenLogicAdditional(TipoFormaPagoInvenLogicAdditional tipoformapagoinvenLogicAdditional) {
		try {
			this.tipoformapagoinvenLogicAdditional=tipoformapagoinvenLogicAdditional;
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
	
	
	
	
	public  TipoFormaPagoInvenLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoformapagoinvenDataAccess = new TipoFormaPagoInvenDataAccess();
			
			this.tipoformapagoinvens= new ArrayList<TipoFormaPagoInven>();
			this.tipoformapagoinven= new TipoFormaPagoInven();
			
			this.tipoformapagoinvenObject=new Object();
			this.tipoformapagoinvensObject=new ArrayList<Object>();
				
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
			
			this.tipoformapagoinvenDataAccess.setConnexionType(this.connexionType);
			this.tipoformapagoinvenDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoFormaPagoInvenLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoformapagoinvenDataAccess = new TipoFormaPagoInvenDataAccess();
			this.tipoformapagoinvens= new ArrayList<TipoFormaPagoInven>();
			this.tipoformapagoinven= new TipoFormaPagoInven();
			this.tipoformapagoinvenObject=new Object();
			this.tipoformapagoinvensObject=new ArrayList<Object>();
			
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
			
			this.tipoformapagoinvenDataAccess.setConnexionType(this.connexionType);
			this.tipoformapagoinvenDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoFormaPagoInven getTipoFormaPagoInven() throws Exception {	
		TipoFormaPagoInvenLogicAdditional.checkTipoFormaPagoInvenToGet(tipoformapagoinven,this.datosCliente,this.arrDatoGeneral);
		TipoFormaPagoInvenLogicAdditional.updateTipoFormaPagoInvenToGet(tipoformapagoinven,this.arrDatoGeneral);
		
		return tipoformapagoinven;
	}
		
	public void setTipoFormaPagoInven(TipoFormaPagoInven newTipoFormaPagoInven) {
		this.tipoformapagoinven = newTipoFormaPagoInven;
	}
	
	public TipoFormaPagoInvenDataAccess getTipoFormaPagoInvenDataAccess() {
		return tipoformapagoinvenDataAccess;
	}
	
	public void setTipoFormaPagoInvenDataAccess(TipoFormaPagoInvenDataAccess newtipoformapagoinvenDataAccess) {
		this.tipoformapagoinvenDataAccess = newtipoformapagoinvenDataAccess;
	}
	
	public List<TipoFormaPagoInven> getTipoFormaPagoInvens() throws Exception {		
		this.quitarTipoFormaPagoInvensNulos();
		
		TipoFormaPagoInvenLogicAdditional.checkTipoFormaPagoInvenToGets(tipoformapagoinvens,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoFormaPagoInven tipoformapagoinvenLocal: tipoformapagoinvens ) {
			TipoFormaPagoInvenLogicAdditional.updateTipoFormaPagoInvenToGet(tipoformapagoinvenLocal,this.arrDatoGeneral);
		}
		
		return tipoformapagoinvens;
	}
	
	public void setTipoFormaPagoInvens(List<TipoFormaPagoInven> newTipoFormaPagoInvens) {
		this.tipoformapagoinvens = newTipoFormaPagoInvens;
	}
	
	public Object getTipoFormaPagoInvenObject() {	
		this.tipoformapagoinvenObject=this.tipoformapagoinvenDataAccess.getEntityObject();
		return this.tipoformapagoinvenObject;
	}
		
	public void setTipoFormaPagoInvenObject(Object newTipoFormaPagoInvenObject) {
		this.tipoformapagoinvenObject = newTipoFormaPagoInvenObject;
	}
	
	public List<Object> getTipoFormaPagoInvensObject() {		
		this.tipoformapagoinvensObject=this.tipoformapagoinvenDataAccess.getEntitiesObject();
		return this.tipoformapagoinvensObject;
	}
		
	public void setTipoFormaPagoInvensObject(List<Object> newTipoFormaPagoInvensObject) {
		this.tipoformapagoinvensObject = newTipoFormaPagoInvensObject;
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
		
		if(this.tipoformapagoinvenDataAccess!=null) {
			this.tipoformapagoinvenDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPagoInven.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoformapagoinvenDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoformapagoinvenDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoformapagoinven = new  TipoFormaPagoInven();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPagoInven.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoformapagoinven=tipoformapagoinvenDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoformapagoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoFormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPagoInven(this.tipoformapagoinven);
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
		tipoformapagoinven = new  TipoFormaPagoInven();
		  		  
        try {
			
			tipoformapagoinven=tipoformapagoinvenDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoformapagoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoFormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPagoInven(this.tipoformapagoinven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoformapagoinven = new  TipoFormaPagoInven();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPagoInven.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoformapagoinven=tipoformapagoinvenDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoformapagoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoFormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPagoInven(this.tipoformapagoinven);
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
		tipoformapagoinven = new  TipoFormaPagoInven();
		  		  
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
		tipoformapagoinven = new  TipoFormaPagoInven();
		  		  
        try {
			
			tipoformapagoinven=tipoformapagoinvenDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoformapagoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoFormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPagoInven(this.tipoformapagoinven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoformapagoinven = new  TipoFormaPagoInven();
		  		  
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
		tipoformapagoinven = new  TipoFormaPagoInven();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPagoInven.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoformapagoinvenDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoformapagoinven = new  TipoFormaPagoInven();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoformapagoinvenDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoformapagoinven = new  TipoFormaPagoInven();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPagoInven.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoformapagoinvenDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoformapagoinven = new  TipoFormaPagoInven();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoformapagoinvenDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoformapagoinven = new  TipoFormaPagoInven();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPagoInven.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoformapagoinvenDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoformapagoinven = new  TipoFormaPagoInven();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoformapagoinvenDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoformapagoinvens = new  ArrayList<TipoFormaPagoInven>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPagoInven.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoFormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoformapagoinvens=tipoformapagoinvenDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoFormaPagoInven(tipoformapagoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPagoInven(this.tipoformapagoinvens);
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
		tipoformapagoinvens = new  ArrayList<TipoFormaPagoInven>();
		  		  
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
		tipoformapagoinvens = new  ArrayList<TipoFormaPagoInven>();
		  		  
        try {			
			TipoFormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoformapagoinvens=tipoformapagoinvenDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoFormaPagoInven(tipoformapagoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPagoInven(this.tipoformapagoinvens);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoformapagoinvens = new  ArrayList<TipoFormaPagoInven>();
		  		  
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
		tipoformapagoinvens = new  ArrayList<TipoFormaPagoInven>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPagoInven.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoFormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoformapagoinvens=tipoformapagoinvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoFormaPagoInven(tipoformapagoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPagoInven(this.tipoformapagoinvens);
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
		tipoformapagoinvens = new  ArrayList<TipoFormaPagoInven>();
		  		  
        try {
			TipoFormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoformapagoinvens=tipoformapagoinvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoFormaPagoInven(tipoformapagoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPagoInven(this.tipoformapagoinvens);
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
		tipoformapagoinvens = new  ArrayList<TipoFormaPagoInven>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPagoInven.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoFormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoformapagoinvens=tipoformapagoinvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoFormaPagoInven(tipoformapagoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPagoInven(this.tipoformapagoinvens);
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
		tipoformapagoinvens = new  ArrayList<TipoFormaPagoInven>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoFormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoformapagoinvens=tipoformapagoinvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoFormaPagoInven(tipoformapagoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPagoInven(this.tipoformapagoinvens);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoformapagoinven = new  TipoFormaPagoInven();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPagoInven.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoFormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoformapagoinven=tipoformapagoinvenDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoFormaPagoInven(tipoformapagoinven);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPagoInven(this.tipoformapagoinven);
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
		tipoformapagoinven = new  TipoFormaPagoInven();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoFormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoformapagoinven=tipoformapagoinvenDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoFormaPagoInven(tipoformapagoinven);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPagoInven(this.tipoformapagoinven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoformapagoinvens = new  ArrayList<TipoFormaPagoInven>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPagoInven.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoFormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoformapagoinvens=tipoformapagoinvenDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoFormaPagoInven(tipoformapagoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPagoInven(this.tipoformapagoinvens);
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
		tipoformapagoinvens = new  ArrayList<TipoFormaPagoInven>();
		  		  
        try {
			TipoFormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoformapagoinvens=tipoformapagoinvenDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoFormaPagoInven(tipoformapagoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPagoInven(this.tipoformapagoinvens);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoFormaPagoInvensWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoformapagoinvens = new  ArrayList<TipoFormaPagoInven>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPagoInven.class.getSimpleName()+"-getTodosTipoFormaPagoInvensWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoFormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoformapagoinvens=tipoformapagoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoFormaPagoInven(tipoformapagoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPagoInven(this.tipoformapagoinvens);
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
	
	public  void  getTodosTipoFormaPagoInvens(String sFinalQuery,Pagination pagination)throws Exception {
		tipoformapagoinvens = new  ArrayList<TipoFormaPagoInven>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoFormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoformapagoinvens=tipoformapagoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoFormaPagoInven(tipoformapagoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoFormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPagoInven(this.tipoformapagoinvens);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoFormaPagoInven(TipoFormaPagoInven tipoformapagoinven) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoformapagoinven.getIsNew() || tipoformapagoinven.getIsChanged()) { 
			this.invalidValues = tipoformapagoinvenValidator.getInvalidValues(tipoformapagoinven);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoformapagoinven);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoFormaPagoInven(List<TipoFormaPagoInven> TipoFormaPagoInvens) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoFormaPagoInven tipoformapagoinvenLocal:tipoformapagoinvens) {				
			estaValidadoObjeto=this.validarGuardarTipoFormaPagoInven(tipoformapagoinvenLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoFormaPagoInven(List<TipoFormaPagoInven> TipoFormaPagoInvens) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoFormaPagoInven(tipoformapagoinvens)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoFormaPagoInven(TipoFormaPagoInven TipoFormaPagoInven) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoFormaPagoInven(tipoformapagoinven)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoFormaPagoInven tipoformapagoinven) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoformapagoinven.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoFormaPagoInvenConstantesFunciones.getTipoFormaPagoInvenLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoformapagoinven","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoFormaPagoInvenConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoFormaPagoInvenConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoFormaPagoInvenWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPagoInven.class.getSimpleName()+"-saveTipoFormaPagoInvenWithConnection");connexion.begin();			
			
			TipoFormaPagoInvenLogicAdditional.checkTipoFormaPagoInvenToSave(this.tipoformapagoinven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoFormaPagoInvenLogicAdditional.updateTipoFormaPagoInvenToSave(this.tipoformapagoinven,this.arrDatoGeneral);
			
			TipoFormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoformapagoinven,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoFormaPagoInven();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoFormaPagoInven(this.tipoformapagoinven)) {
				TipoFormaPagoInvenDataAccess.save(this.tipoformapagoinven, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoformapagoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoFormaPagoInvenLogicAdditional.checkTipoFormaPagoInvenToSaveAfter(this.tipoformapagoinven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoFormaPagoInven();
			
			connexion.commit();			
			
			if(this.tipoformapagoinven.getIsDeleted()) {
				this.tipoformapagoinven=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoFormaPagoInven()throws Exception {	
		try {	
			
			TipoFormaPagoInvenLogicAdditional.checkTipoFormaPagoInvenToSave(this.tipoformapagoinven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoFormaPagoInvenLogicAdditional.updateTipoFormaPagoInvenToSave(this.tipoformapagoinven,this.arrDatoGeneral);
			
			TipoFormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoformapagoinven,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoFormaPagoInven(this.tipoformapagoinven)) {			
				TipoFormaPagoInvenDataAccess.save(this.tipoformapagoinven, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoformapagoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoFormaPagoInvenLogicAdditional.checkTipoFormaPagoInvenToSaveAfter(this.tipoformapagoinven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoformapagoinven.getIsDeleted()) {
				this.tipoformapagoinven=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoFormaPagoInvensWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPagoInven.class.getSimpleName()+"-saveTipoFormaPagoInvensWithConnection");connexion.begin();			
			
			TipoFormaPagoInvenLogicAdditional.checkTipoFormaPagoInvenToSaves(tipoformapagoinvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoFormaPagoInvens();
			
			Boolean validadoTodosTipoFormaPagoInven=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoFormaPagoInven tipoformapagoinvenLocal:tipoformapagoinvens) {		
				if(tipoformapagoinvenLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoFormaPagoInvenLogicAdditional.updateTipoFormaPagoInvenToSave(tipoformapagoinvenLocal,this.arrDatoGeneral);
	        	
				TipoFormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoformapagoinvenLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoFormaPagoInven(tipoformapagoinvenLocal)) {
					TipoFormaPagoInvenDataAccess.save(tipoformapagoinvenLocal, connexion);				
				} else {
					validadoTodosTipoFormaPagoInven=false;
				}
			}
			
			if(!validadoTodosTipoFormaPagoInven) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoFormaPagoInvenLogicAdditional.checkTipoFormaPagoInvenToSavesAfter(tipoformapagoinvens,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoFormaPagoInvens();
			
			connexion.commit();		
			
			this.quitarTipoFormaPagoInvensEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoFormaPagoInvens()throws Exception {				
		 try {	
			TipoFormaPagoInvenLogicAdditional.checkTipoFormaPagoInvenToSaves(tipoformapagoinvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoFormaPagoInven=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoFormaPagoInven tipoformapagoinvenLocal:tipoformapagoinvens) {				
				if(tipoformapagoinvenLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoFormaPagoInvenLogicAdditional.updateTipoFormaPagoInvenToSave(tipoformapagoinvenLocal,this.arrDatoGeneral);
	        	
				TipoFormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoformapagoinvenLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoFormaPagoInven(tipoformapagoinvenLocal)) {				
					TipoFormaPagoInvenDataAccess.save(tipoformapagoinvenLocal, connexion);				
				} else {
					validadoTodosTipoFormaPagoInven=false;
				}
			}
			
			if(!validadoTodosTipoFormaPagoInven) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoFormaPagoInvenLogicAdditional.checkTipoFormaPagoInvenToSavesAfter(tipoformapagoinvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoFormaPagoInvensEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoFormaPagoInvenParameterReturnGeneral procesarAccionTipoFormaPagoInvens(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoFormaPagoInven> tipoformapagoinvens,TipoFormaPagoInvenParameterReturnGeneral tipoformapagoinvenParameterGeneral)throws Exception {
		 try {	
			TipoFormaPagoInvenParameterReturnGeneral tipoformapagoinvenReturnGeneral=new TipoFormaPagoInvenParameterReturnGeneral();
	
			TipoFormaPagoInvenLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoformapagoinvens,tipoformapagoinvenParameterGeneral,tipoformapagoinvenReturnGeneral);
			
			return tipoformapagoinvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoFormaPagoInvenParameterReturnGeneral procesarAccionTipoFormaPagoInvensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoFormaPagoInven> tipoformapagoinvens,TipoFormaPagoInvenParameterReturnGeneral tipoformapagoinvenParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPagoInven.class.getSimpleName()+"-procesarAccionTipoFormaPagoInvensWithConnection");connexion.begin();			
			
			TipoFormaPagoInvenParameterReturnGeneral tipoformapagoinvenReturnGeneral=new TipoFormaPagoInvenParameterReturnGeneral();
	
			TipoFormaPagoInvenLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoformapagoinvens,tipoformapagoinvenParameterGeneral,tipoformapagoinvenReturnGeneral);
			
			this.connexion.commit();
			
			return tipoformapagoinvenReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoFormaPagoInvenParameterReturnGeneral procesarEventosTipoFormaPagoInvens(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoFormaPagoInven> tipoformapagoinvens,TipoFormaPagoInven tipoformapagoinven,TipoFormaPagoInvenParameterReturnGeneral tipoformapagoinvenParameterGeneral,Boolean isEsNuevoTipoFormaPagoInven,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoFormaPagoInvenParameterReturnGeneral tipoformapagoinvenReturnGeneral=new TipoFormaPagoInvenParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoformapagoinvenReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoFormaPagoInvenLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoformapagoinvens,tipoformapagoinven,tipoformapagoinvenParameterGeneral,tipoformapagoinvenReturnGeneral,isEsNuevoTipoFormaPagoInven,clases);
			
			return tipoformapagoinvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoFormaPagoInvenParameterReturnGeneral procesarEventosTipoFormaPagoInvensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoFormaPagoInven> tipoformapagoinvens,TipoFormaPagoInven tipoformapagoinven,TipoFormaPagoInvenParameterReturnGeneral tipoformapagoinvenParameterGeneral,Boolean isEsNuevoTipoFormaPagoInven,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPagoInven.class.getSimpleName()+"-procesarEventosTipoFormaPagoInvensWithConnection");connexion.begin();			
			
			TipoFormaPagoInvenParameterReturnGeneral tipoformapagoinvenReturnGeneral=new TipoFormaPagoInvenParameterReturnGeneral();
	
			tipoformapagoinvenReturnGeneral.setTipoFormaPagoInven(tipoformapagoinven);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoformapagoinvenReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoFormaPagoInvenLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoformapagoinvens,tipoformapagoinven,tipoformapagoinvenParameterGeneral,tipoformapagoinvenReturnGeneral,isEsNuevoTipoFormaPagoInven,clases);
			
			this.connexion.commit();
			
			return tipoformapagoinvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoFormaPagoInvenParameterReturnGeneral procesarImportacionTipoFormaPagoInvensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoFormaPagoInvenParameterReturnGeneral tipoformapagoinvenParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPagoInven.class.getSimpleName()+"-procesarImportacionTipoFormaPagoInvensWithConnection");connexion.begin();			
			
			TipoFormaPagoInvenParameterReturnGeneral tipoformapagoinvenReturnGeneral=new TipoFormaPagoInvenParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoformapagoinvens=new ArrayList<TipoFormaPagoInven>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoformapagoinven=new TipoFormaPagoInven();
				
				
				if(conColumnasBase) {this.tipoformapagoinven.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoformapagoinven.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoformapagoinven.setcodigo(arrColumnas[iColumn++]);
				this.tipoformapagoinven.setnombre(arrColumnas[iColumn++]);
				
				this.tipoformapagoinvens.add(this.tipoformapagoinven);
			}
			
			this.saveTipoFormaPagoInvens();
			
			this.connexion.commit();
			
			tipoformapagoinvenReturnGeneral.setConRetornoEstaProcesado(true);
			tipoformapagoinvenReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoformapagoinvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoFormaPagoInvensEliminados() throws Exception {				
		
		List<TipoFormaPagoInven> tipoformapagoinvensAux= new ArrayList<TipoFormaPagoInven>();
		
		for(TipoFormaPagoInven tipoformapagoinven:tipoformapagoinvens) {
			if(!tipoformapagoinven.getIsDeleted()) {
				tipoformapagoinvensAux.add(tipoformapagoinven);
			}
		}
		
		tipoformapagoinvens=tipoformapagoinvensAux;
	}
	
	public void quitarTipoFormaPagoInvensNulos() throws Exception {				
		
		List<TipoFormaPagoInven> tipoformapagoinvensAux= new ArrayList<TipoFormaPagoInven>();
		
		for(TipoFormaPagoInven tipoformapagoinven : this.tipoformapagoinvens) {
			if(tipoformapagoinven==null) {
				tipoformapagoinvensAux.add(tipoformapagoinven);
			}
		}
		
		//this.tipoformapagoinvens=tipoformapagoinvensAux;
		
		this.tipoformapagoinvens.removeAll(tipoformapagoinvensAux);
	}
	
	public void getSetVersionRowTipoFormaPagoInvenWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoformapagoinven.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoformapagoinven.getIsDeleted() || (tipoformapagoinven.getIsChanged()&&!tipoformapagoinven.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoformapagoinvenDataAccess.getSetVersionRowTipoFormaPagoInven(connexion,tipoformapagoinven.getId());
				
				if(!tipoformapagoinven.getVersionRow().equals(timestamp)) {	
					tipoformapagoinven.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoformapagoinven.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoFormaPagoInven()throws Exception {	
		
		if(tipoformapagoinven.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoformapagoinven.getIsDeleted() || (tipoformapagoinven.getIsChanged()&&!tipoformapagoinven.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoformapagoinvenDataAccess.getSetVersionRowTipoFormaPagoInven(connexion,tipoformapagoinven.getId());
			
			try {							
				if(!tipoformapagoinven.getVersionRow().equals(timestamp)) {	
					tipoformapagoinven.setVersionRow(timestamp);
				}
				
				tipoformapagoinven.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoFormaPagoInvensWithConnection()throws Exception {	
		if(tipoformapagoinvens!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoFormaPagoInven tipoformapagoinvenAux:tipoformapagoinvens) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoformapagoinvenAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoformapagoinvenAux.getIsDeleted() || (tipoformapagoinvenAux.getIsChanged()&&!tipoformapagoinvenAux.getIsNew())) {
						
						timestamp=tipoformapagoinvenDataAccess.getSetVersionRowTipoFormaPagoInven(connexion,tipoformapagoinvenAux.getId());
						
						if(!tipoformapagoinven.getVersionRow().equals(timestamp)) {	
							tipoformapagoinvenAux.setVersionRow(timestamp);
						}
								
						tipoformapagoinvenAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoFormaPagoInvens()throws Exception {	
		if(tipoformapagoinvens!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoFormaPagoInven tipoformapagoinvenAux:tipoformapagoinvens) {
					if(tipoformapagoinvenAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoformapagoinvenAux.getIsDeleted() || (tipoformapagoinvenAux.getIsChanged()&&!tipoformapagoinvenAux.getIsNew())) {
						
						timestamp=tipoformapagoinvenDataAccess.getSetVersionRowTipoFormaPagoInven(connexion,tipoformapagoinvenAux.getId());
						
						if(!tipoformapagoinvenAux.getVersionRow().equals(timestamp)) {	
							tipoformapagoinvenAux.setVersionRow(timestamp);
						}
						
													
						tipoformapagoinvenAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoFormaPagoInvenParameterReturnGeneral cargarCombosLoteForeignKeyTipoFormaPagoInvenWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoFormaPagoInvenParameterReturnGeneral  tipoformapagoinvenReturnGeneral =new TipoFormaPagoInvenParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPagoInven.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoFormaPagoInvenWithConnection");connexion.begin();
			
			tipoformapagoinvenReturnGeneral =new TipoFormaPagoInvenParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoformapagoinvenReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipoformapagoinvenReturnGeneral;
	}
	
	public TipoFormaPagoInvenParameterReturnGeneral cargarCombosLoteForeignKeyTipoFormaPagoInven(String finalQueryGlobalEmpresa) throws Exception {
		TipoFormaPagoInvenParameterReturnGeneral  tipoformapagoinvenReturnGeneral =new TipoFormaPagoInvenParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipoformapagoinvenReturnGeneral =new TipoFormaPagoInvenParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoformapagoinvenReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipoformapagoinvenReturnGeneral;
	}
	
	
	public void deepLoad(TipoFormaPagoInven tipoformapagoinven,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoFormaPagoInvenLogicAdditional.updateTipoFormaPagoInvenToGet(tipoformapagoinven,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoformapagoinven.setEmpresa(tipoformapagoinvenDataAccess.getEmpresa(connexion,tipoformapagoinven));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoformapagoinven.setEmpresa(tipoformapagoinvenDataAccess.getEmpresa(connexion,tipoformapagoinven));
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
			tipoformapagoinven.setEmpresa(tipoformapagoinvenDataAccess.getEmpresa(connexion,tipoformapagoinven));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoformapagoinven.setEmpresa(tipoformapagoinvenDataAccess.getEmpresa(connexion,tipoformapagoinven));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoformapagoinven.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoformapagoinven.setEmpresa(tipoformapagoinvenDataAccess.getEmpresa(connexion,tipoformapagoinven));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipoformapagoinven.getEmpresa(),isDeep,deepLoadType,clases);				
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
			tipoformapagoinven.setEmpresa(tipoformapagoinvenDataAccess.getEmpresa(connexion,tipoformapagoinven));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipoformapagoinven.getEmpresa(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoFormaPagoInven tipoformapagoinven,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoFormaPagoInvenLogicAdditional.updateTipoFormaPagoInvenToSave(tipoformapagoinven,this.arrDatoGeneral);
			
TipoFormaPagoInvenDataAccess.save(tipoformapagoinven, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipoformapagoinven.getEmpresa(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipoformapagoinven.getEmpresa(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipoformapagoinven.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoformapagoinven.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipoformapagoinven.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipoformapagoinven.getEmpresa(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(TipoFormaPagoInven.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoformapagoinven,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoFormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPagoInven(tipoformapagoinven);
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
			this.deepLoad(this.tipoformapagoinven,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoFormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPagoInven(this.tipoformapagoinven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoFormaPagoInven.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoformapagoinvens!=null) {
				for(TipoFormaPagoInven tipoformapagoinven:tipoformapagoinvens) {
					this.deepLoad(tipoformapagoinven,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoFormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPagoInven(tipoformapagoinvens);
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
			if(tipoformapagoinvens!=null) {
				for(TipoFormaPagoInven tipoformapagoinven:tipoformapagoinvens) {
					this.deepLoad(tipoformapagoinven,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoFormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPagoInven(tipoformapagoinvens);
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
			this.getNewConnexionToDeep(TipoFormaPagoInven.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipoformapagoinven,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoFormaPagoInven.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipoformapagoinvens!=null) {
				for(TipoFormaPagoInven tipoformapagoinven:tipoformapagoinvens) {
					this.deepSave(tipoformapagoinven,isDeep,deepLoadType,clases);
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
			if(tipoformapagoinvens!=null) {
				for(TipoFormaPagoInven tipoformapagoinven:tipoformapagoinvens) {
					this.deepSave(tipoformapagoinven,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoFormaPagoInvensFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoFormaPagoInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoFormaPagoInvenConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoFormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoformapagoinvens=tipoformapagoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoFormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPagoInven(this.tipoformapagoinvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoFormaPagoInvensFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoFormaPagoInvenConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoFormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoformapagoinvens=tipoformapagoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoFormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoFormaPagoInven(this.tipoformapagoinvens);
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
			if(TipoFormaPagoInvenConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoFormaPagoInvenDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoFormaPagoInven tipoformapagoinven,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoFormaPagoInvenConstantesFunciones.ISCONAUDITORIA) {
				if(tipoformapagoinven.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoFormaPagoInvenDataAccess.TABLENAME, tipoformapagoinven.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoFormaPagoInvenConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoFormaPagoInvenLogic.registrarAuditoriaDetallesTipoFormaPagoInven(connexion,tipoformapagoinven,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoformapagoinven.getIsDeleted()) {
					/*if(!tipoformapagoinven.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoFormaPagoInvenDataAccess.TABLENAME, tipoformapagoinven.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoFormaPagoInvenLogic.registrarAuditoriaDetallesTipoFormaPagoInven(connexion,tipoformapagoinven,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoFormaPagoInvenDataAccess.TABLENAME, tipoformapagoinven.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoformapagoinven.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoFormaPagoInvenDataAccess.TABLENAME, tipoformapagoinven.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoFormaPagoInvenConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoFormaPagoInvenLogic.registrarAuditoriaDetallesTipoFormaPagoInven(connexion,tipoformapagoinven,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoFormaPagoInven(Connexion connexion,TipoFormaPagoInven tipoformapagoinven)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoformapagoinven.getIsNew()||!tipoformapagoinven.getid_empresa().equals(tipoformapagoinven.getTipoFormaPagoInvenOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoformapagoinven.getTipoFormaPagoInvenOriginal().getid_empresa()!=null)
				{
					strValorActual=tipoformapagoinven.getTipoFormaPagoInvenOriginal().getid_empresa().toString();
				}
				if(tipoformapagoinven.getid_empresa()!=null)
				{
					strValorNuevo=tipoformapagoinven.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoFormaPagoInvenConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipoformapagoinven.getIsNew()||!tipoformapagoinven.getcodigo().equals(tipoformapagoinven.getTipoFormaPagoInvenOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoformapagoinven.getTipoFormaPagoInvenOriginal().getcodigo()!=null)
				{
					strValorActual=tipoformapagoinven.getTipoFormaPagoInvenOriginal().getcodigo();
				}
				if(tipoformapagoinven.getcodigo()!=null)
				{
					strValorNuevo=tipoformapagoinven.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoFormaPagoInvenConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipoformapagoinven.getIsNew()||!tipoformapagoinven.getnombre().equals(tipoformapagoinven.getTipoFormaPagoInvenOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoformapagoinven.getTipoFormaPagoInvenOriginal().getnombre()!=null)
				{
					strValorActual=tipoformapagoinven.getTipoFormaPagoInvenOriginal().getnombre();
				}
				if(tipoformapagoinven.getnombre()!=null)
				{
					strValorNuevo=tipoformapagoinven.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoFormaPagoInvenConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoFormaPagoInvenRelacionesWithConnection(TipoFormaPagoInven tipoformapagoinven) throws Exception {

		if(!tipoformapagoinven.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoFormaPagoInvenRelacionesBase(tipoformapagoinven,true);
		}
	}

	public void saveTipoFormaPagoInvenRelaciones(TipoFormaPagoInven tipoformapagoinven)throws Exception {

		if(!tipoformapagoinven.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoFormaPagoInvenRelacionesBase(tipoformapagoinven,false);
		}
	}

	public void saveTipoFormaPagoInvenRelacionesBase(TipoFormaPagoInven tipoformapagoinven,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoFormaPagoInven-saveRelacionesWithConnection");}
	

			this.setTipoFormaPagoInven(tipoformapagoinven);

			if(TipoFormaPagoInvenLogicAdditional.validarSaveRelaciones(tipoformapagoinven,this)) {

				TipoFormaPagoInvenLogicAdditional.updateRelacionesToSave(tipoformapagoinven,this);

				if((tipoformapagoinven.getIsNew()||tipoformapagoinven.getIsChanged())&&!tipoformapagoinven.getIsDeleted()) {
					this.saveTipoFormaPagoInven();
					this.saveTipoFormaPagoInvenRelacionesDetalles();

				} else if(tipoformapagoinven.getIsDeleted()) {
					this.saveTipoFormaPagoInvenRelacionesDetalles();
					this.saveTipoFormaPagoInven();
				}

				TipoFormaPagoInvenLogicAdditional.updateRelacionesToSaveAfter(tipoformapagoinven,this);

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
	
	
	private void saveTipoFormaPagoInvenRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoFormaPagoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoFormaPagoInvenConstantesFunciones.getClassesForeignKeysOfTipoFormaPagoInven(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoFormaPagoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoFormaPagoInvenConstantesFunciones.getClassesRelationshipsOfTipoFormaPagoInven(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

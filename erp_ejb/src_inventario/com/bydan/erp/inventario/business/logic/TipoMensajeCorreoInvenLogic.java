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
import com.bydan.erp.inventario.util.TipoMensajeCorreoInvenConstantesFunciones;
import com.bydan.erp.inventario.util.TipoMensajeCorreoInvenParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TipoMensajeCorreoInvenParameterGeneral;
import com.bydan.erp.inventario.business.entity.TipoMensajeCorreoInven;
//import com.bydan.erp.inventario.business.logic.TipoMensajeCorreoInvenLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoMensajeCorreoInvenLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoMensajeCorreoInvenLogic.class);
	
	protected TipoMensajeCorreoInvenDataAccess tipomensajecorreoinvenDataAccess; 	
	protected TipoMensajeCorreoInven tipomensajecorreoinven;
	protected List<TipoMensajeCorreoInven> tipomensajecorreoinvens;
	protected Object tipomensajecorreoinvenObject;	
	protected List<Object> tipomensajecorreoinvensObject;
	
	public static ClassValidator<TipoMensajeCorreoInven> tipomensajecorreoinvenValidator = new ClassValidator<TipoMensajeCorreoInven>(TipoMensajeCorreoInven.class);	
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
	
	
	
	
	public  TipoMensajeCorreoInvenLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipomensajecorreoinvenDataAccess = new TipoMensajeCorreoInvenDataAccess();
			
			this.tipomensajecorreoinvens= new ArrayList<TipoMensajeCorreoInven>();
			this.tipomensajecorreoinven= new TipoMensajeCorreoInven();
			
			this.tipomensajecorreoinvenObject=new Object();
			this.tipomensajecorreoinvensObject=new ArrayList<Object>();
				
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
			
			this.tipomensajecorreoinvenDataAccess.setConnexionType(this.connexionType);
			this.tipomensajecorreoinvenDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoMensajeCorreoInvenLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipomensajecorreoinvenDataAccess = new TipoMensajeCorreoInvenDataAccess();
			this.tipomensajecorreoinvens= new ArrayList<TipoMensajeCorreoInven>();
			this.tipomensajecorreoinven= new TipoMensajeCorreoInven();
			this.tipomensajecorreoinvenObject=new Object();
			this.tipomensajecorreoinvensObject=new ArrayList<Object>();
			
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
			
			this.tipomensajecorreoinvenDataAccess.setConnexionType(this.connexionType);
			this.tipomensajecorreoinvenDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoMensajeCorreoInven getTipoMensajeCorreoInven() throws Exception {	
		//TipoMensajeCorreoInvenLogicAdditional.checkTipoMensajeCorreoInvenToGet(tipomensajecorreoinven,this.datosCliente,this.arrDatoGeneral);
		//TipoMensajeCorreoInvenLogicAdditional.updateTipoMensajeCorreoInvenToGet(tipomensajecorreoinven,this.arrDatoGeneral);
		
		return tipomensajecorreoinven;
	}
		
	public void setTipoMensajeCorreoInven(TipoMensajeCorreoInven newTipoMensajeCorreoInven) {
		this.tipomensajecorreoinven = newTipoMensajeCorreoInven;
	}
	
	public TipoMensajeCorreoInvenDataAccess getTipoMensajeCorreoInvenDataAccess() {
		return tipomensajecorreoinvenDataAccess;
	}
	
	public void setTipoMensajeCorreoInvenDataAccess(TipoMensajeCorreoInvenDataAccess newtipomensajecorreoinvenDataAccess) {
		this.tipomensajecorreoinvenDataAccess = newtipomensajecorreoinvenDataAccess;
	}
	
	public List<TipoMensajeCorreoInven> getTipoMensajeCorreoInvens() throws Exception {		
		this.quitarTipoMensajeCorreoInvensNulos();
		
		//TipoMensajeCorreoInvenLogicAdditional.checkTipoMensajeCorreoInvenToGets(tipomensajecorreoinvens,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoMensajeCorreoInven tipomensajecorreoinvenLocal: tipomensajecorreoinvens ) {
			//TipoMensajeCorreoInvenLogicAdditional.updateTipoMensajeCorreoInvenToGet(tipomensajecorreoinvenLocal,this.arrDatoGeneral);
		}
		
		return tipomensajecorreoinvens;
	}
	
	public void setTipoMensajeCorreoInvens(List<TipoMensajeCorreoInven> newTipoMensajeCorreoInvens) {
		this.tipomensajecorreoinvens = newTipoMensajeCorreoInvens;
	}
	
	public Object getTipoMensajeCorreoInvenObject() {	
		this.tipomensajecorreoinvenObject=this.tipomensajecorreoinvenDataAccess.getEntityObject();
		return this.tipomensajecorreoinvenObject;
	}
		
	public void setTipoMensajeCorreoInvenObject(Object newTipoMensajeCorreoInvenObject) {
		this.tipomensajecorreoinvenObject = newTipoMensajeCorreoInvenObject;
	}
	
	public List<Object> getTipoMensajeCorreoInvensObject() {		
		this.tipomensajecorreoinvensObject=this.tipomensajecorreoinvenDataAccess.getEntitiesObject();
		return this.tipomensajecorreoinvensObject;
	}
		
	public void setTipoMensajeCorreoInvensObject(List<Object> newTipoMensajeCorreoInvensObject) {
		this.tipomensajecorreoinvensObject = newTipoMensajeCorreoInvensObject;
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
		
		if(this.tipomensajecorreoinvenDataAccess!=null) {
			this.tipomensajecorreoinvenDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMensajeCorreoInven.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipomensajecorreoinvenDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipomensajecorreoinvenDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipomensajecorreoinven = new  TipoMensajeCorreoInven();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMensajeCorreoInven.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipomensajecorreoinven=tipomensajecorreoinvenDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipomensajecorreoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoMensajeCorreoInven(this.tipomensajecorreoinven);
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
		tipomensajecorreoinven = new  TipoMensajeCorreoInven();
		  		  
        try {
			
			tipomensajecorreoinven=tipomensajecorreoinvenDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipomensajecorreoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoMensajeCorreoInven(this.tipomensajecorreoinven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipomensajecorreoinven = new  TipoMensajeCorreoInven();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMensajeCorreoInven.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipomensajecorreoinven=tipomensajecorreoinvenDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipomensajecorreoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoMensajeCorreoInven(this.tipomensajecorreoinven);
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
		tipomensajecorreoinven = new  TipoMensajeCorreoInven();
		  		  
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
		tipomensajecorreoinven = new  TipoMensajeCorreoInven();
		  		  
        try {
			
			tipomensajecorreoinven=tipomensajecorreoinvenDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipomensajecorreoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoMensajeCorreoInven(this.tipomensajecorreoinven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipomensajecorreoinven = new  TipoMensajeCorreoInven();
		  		  
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
		tipomensajecorreoinven = new  TipoMensajeCorreoInven();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMensajeCorreoInven.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipomensajecorreoinvenDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipomensajecorreoinven = new  TipoMensajeCorreoInven();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipomensajecorreoinvenDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipomensajecorreoinven = new  TipoMensajeCorreoInven();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMensajeCorreoInven.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipomensajecorreoinvenDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipomensajecorreoinven = new  TipoMensajeCorreoInven();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipomensajecorreoinvenDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipomensajecorreoinven = new  TipoMensajeCorreoInven();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMensajeCorreoInven.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipomensajecorreoinvenDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipomensajecorreoinven = new  TipoMensajeCorreoInven();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipomensajecorreoinvenDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipomensajecorreoinvens = new  ArrayList<TipoMensajeCorreoInven>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMensajeCorreoInven.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomensajecorreoinvens=tipomensajecorreoinvenDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoMensajeCorreoInven(tipomensajecorreoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoMensajeCorreoInven(this.tipomensajecorreoinvens);
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
		tipomensajecorreoinvens = new  ArrayList<TipoMensajeCorreoInven>();
		  		  
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
		tipomensajecorreoinvens = new  ArrayList<TipoMensajeCorreoInven>();
		  		  
        try {			
			TipoMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomensajecorreoinvens=tipomensajecorreoinvenDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoMensajeCorreoInven(tipomensajecorreoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoMensajeCorreoInven(this.tipomensajecorreoinvens);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipomensajecorreoinvens = new  ArrayList<TipoMensajeCorreoInven>();
		  		  
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
		tipomensajecorreoinvens = new  ArrayList<TipoMensajeCorreoInven>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMensajeCorreoInven.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomensajecorreoinvens=tipomensajecorreoinvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoMensajeCorreoInven(tipomensajecorreoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoMensajeCorreoInven(this.tipomensajecorreoinvens);
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
		tipomensajecorreoinvens = new  ArrayList<TipoMensajeCorreoInven>();
		  		  
        try {
			TipoMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomensajecorreoinvens=tipomensajecorreoinvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoMensajeCorreoInven(tipomensajecorreoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoMensajeCorreoInven(this.tipomensajecorreoinvens);
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
		tipomensajecorreoinvens = new  ArrayList<TipoMensajeCorreoInven>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMensajeCorreoInven.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomensajecorreoinvens=tipomensajecorreoinvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoMensajeCorreoInven(tipomensajecorreoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoMensajeCorreoInven(this.tipomensajecorreoinvens);
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
		tipomensajecorreoinvens = new  ArrayList<TipoMensajeCorreoInven>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomensajecorreoinvens=tipomensajecorreoinvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoMensajeCorreoInven(tipomensajecorreoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoMensajeCorreoInven(this.tipomensajecorreoinvens);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipomensajecorreoinven = new  TipoMensajeCorreoInven();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMensajeCorreoInven.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomensajecorreoinven=tipomensajecorreoinvenDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoMensajeCorreoInven(tipomensajecorreoinven);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoMensajeCorreoInven(this.tipomensajecorreoinven);
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
		tipomensajecorreoinven = new  TipoMensajeCorreoInven();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomensajecorreoinven=tipomensajecorreoinvenDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoMensajeCorreoInven(tipomensajecorreoinven);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoMensajeCorreoInven(this.tipomensajecorreoinven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoMensajeCorreoInvensWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipomensajecorreoinvens = new  ArrayList<TipoMensajeCorreoInven>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMensajeCorreoInven.class.getSimpleName()+"-getTodosTipoMensajeCorreoInvensWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomensajecorreoinvens=tipomensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoMensajeCorreoInven(tipomensajecorreoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoMensajeCorreoInven(this.tipomensajecorreoinvens);
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
	
	public  void  getTodosTipoMensajeCorreoInvens(String sFinalQuery,Pagination pagination)throws Exception {
		tipomensajecorreoinvens = new  ArrayList<TipoMensajeCorreoInven>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipomensajecorreoinvens=tipomensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoMensajeCorreoInven(tipomensajecorreoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoMensajeCorreoInven(this.tipomensajecorreoinvens);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoMensajeCorreoInven(TipoMensajeCorreoInven tipomensajecorreoinven) throws Exception {
		Boolean estaValidado=false;
		
		if(tipomensajecorreoinven.getIsNew() || tipomensajecorreoinven.getIsChanged()) { 
			this.invalidValues = tipomensajecorreoinvenValidator.getInvalidValues(tipomensajecorreoinven);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipomensajecorreoinven);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoMensajeCorreoInven(List<TipoMensajeCorreoInven> TipoMensajeCorreoInvens) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoMensajeCorreoInven tipomensajecorreoinvenLocal:tipomensajecorreoinvens) {				
			estaValidadoObjeto=this.validarGuardarTipoMensajeCorreoInven(tipomensajecorreoinvenLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoMensajeCorreoInven(List<TipoMensajeCorreoInven> TipoMensajeCorreoInvens) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoMensajeCorreoInven(tipomensajecorreoinvens)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoMensajeCorreoInven(TipoMensajeCorreoInven TipoMensajeCorreoInven) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoMensajeCorreoInven(tipomensajecorreoinven)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoMensajeCorreoInven tipomensajecorreoinven) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipomensajecorreoinven.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoMensajeCorreoInvenConstantesFunciones.getTipoMensajeCorreoInvenLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipomensajecorreoinven","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoMensajeCorreoInvenConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoMensajeCorreoInvenConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoMensajeCorreoInvenWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMensajeCorreoInven.class.getSimpleName()+"-saveTipoMensajeCorreoInvenWithConnection");connexion.begin();			
			
			//TipoMensajeCorreoInvenLogicAdditional.checkTipoMensajeCorreoInvenToSave(this.tipomensajecorreoinven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoMensajeCorreoInvenLogicAdditional.updateTipoMensajeCorreoInvenToSave(this.tipomensajecorreoinven,this.arrDatoGeneral);
			
			TipoMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipomensajecorreoinven,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoMensajeCorreoInven();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoMensajeCorreoInven(this.tipomensajecorreoinven)) {
				TipoMensajeCorreoInvenDataAccess.save(this.tipomensajecorreoinven, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipomensajecorreoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoMensajeCorreoInvenLogicAdditional.checkTipoMensajeCorreoInvenToSaveAfter(this.tipomensajecorreoinven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoMensajeCorreoInven();
			
			connexion.commit();			
			
			if(this.tipomensajecorreoinven.getIsDeleted()) {
				this.tipomensajecorreoinven=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoMensajeCorreoInven()throws Exception {	
		try {	
			
			//TipoMensajeCorreoInvenLogicAdditional.checkTipoMensajeCorreoInvenToSave(this.tipomensajecorreoinven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoMensajeCorreoInvenLogicAdditional.updateTipoMensajeCorreoInvenToSave(this.tipomensajecorreoinven,this.arrDatoGeneral);
			
			TipoMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipomensajecorreoinven,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoMensajeCorreoInven(this.tipomensajecorreoinven)) {			
				TipoMensajeCorreoInvenDataAccess.save(this.tipomensajecorreoinven, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipomensajecorreoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoMensajeCorreoInvenLogicAdditional.checkTipoMensajeCorreoInvenToSaveAfter(this.tipomensajecorreoinven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipomensajecorreoinven.getIsDeleted()) {
				this.tipomensajecorreoinven=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoMensajeCorreoInvensWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMensajeCorreoInven.class.getSimpleName()+"-saveTipoMensajeCorreoInvensWithConnection");connexion.begin();			
			
			//TipoMensajeCorreoInvenLogicAdditional.checkTipoMensajeCorreoInvenToSaves(tipomensajecorreoinvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoMensajeCorreoInvens();
			
			Boolean validadoTodosTipoMensajeCorreoInven=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoMensajeCorreoInven tipomensajecorreoinvenLocal:tipomensajecorreoinvens) {		
				if(tipomensajecorreoinvenLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoMensajeCorreoInvenLogicAdditional.updateTipoMensajeCorreoInvenToSave(tipomensajecorreoinvenLocal,this.arrDatoGeneral);
	        	
				TipoMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipomensajecorreoinvenLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoMensajeCorreoInven(tipomensajecorreoinvenLocal)) {
					TipoMensajeCorreoInvenDataAccess.save(tipomensajecorreoinvenLocal, connexion);				
				} else {
					validadoTodosTipoMensajeCorreoInven=false;
				}
			}
			
			if(!validadoTodosTipoMensajeCorreoInven) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoMensajeCorreoInvenLogicAdditional.checkTipoMensajeCorreoInvenToSavesAfter(tipomensajecorreoinvens,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoMensajeCorreoInvens();
			
			connexion.commit();		
			
			this.quitarTipoMensajeCorreoInvensEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoMensajeCorreoInvens()throws Exception {				
		 try {	
			//TipoMensajeCorreoInvenLogicAdditional.checkTipoMensajeCorreoInvenToSaves(tipomensajecorreoinvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoMensajeCorreoInven=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoMensajeCorreoInven tipomensajecorreoinvenLocal:tipomensajecorreoinvens) {				
				if(tipomensajecorreoinvenLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoMensajeCorreoInvenLogicAdditional.updateTipoMensajeCorreoInvenToSave(tipomensajecorreoinvenLocal,this.arrDatoGeneral);
	        	
				TipoMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipomensajecorreoinvenLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoMensajeCorreoInven(tipomensajecorreoinvenLocal)) {				
					TipoMensajeCorreoInvenDataAccess.save(tipomensajecorreoinvenLocal, connexion);				
				} else {
					validadoTodosTipoMensajeCorreoInven=false;
				}
			}
			
			if(!validadoTodosTipoMensajeCorreoInven) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoMensajeCorreoInvenLogicAdditional.checkTipoMensajeCorreoInvenToSavesAfter(tipomensajecorreoinvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoMensajeCorreoInvensEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoMensajeCorreoInvenParameterReturnGeneral procesarAccionTipoMensajeCorreoInvens(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoMensajeCorreoInven> tipomensajecorreoinvens,TipoMensajeCorreoInvenParameterReturnGeneral tipomensajecorreoinvenParameterGeneral)throws Exception {
		 try {	
			TipoMensajeCorreoInvenParameterReturnGeneral tipomensajecorreoinvenReturnGeneral=new TipoMensajeCorreoInvenParameterReturnGeneral();
	
			
			return tipomensajecorreoinvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoMensajeCorreoInvenParameterReturnGeneral procesarAccionTipoMensajeCorreoInvensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoMensajeCorreoInven> tipomensajecorreoinvens,TipoMensajeCorreoInvenParameterReturnGeneral tipomensajecorreoinvenParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMensajeCorreoInven.class.getSimpleName()+"-procesarAccionTipoMensajeCorreoInvensWithConnection");connexion.begin();			
			
			TipoMensajeCorreoInvenParameterReturnGeneral tipomensajecorreoinvenReturnGeneral=new TipoMensajeCorreoInvenParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipomensajecorreoinvenReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoMensajeCorreoInvenParameterReturnGeneral procesarEventosTipoMensajeCorreoInvens(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoMensajeCorreoInven> tipomensajecorreoinvens,TipoMensajeCorreoInven tipomensajecorreoinven,TipoMensajeCorreoInvenParameterReturnGeneral tipomensajecorreoinvenParameterGeneral,Boolean isEsNuevoTipoMensajeCorreoInven,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoMensajeCorreoInvenParameterReturnGeneral tipomensajecorreoinvenReturnGeneral=new TipoMensajeCorreoInvenParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipomensajecorreoinvenReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipomensajecorreoinvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoMensajeCorreoInvenParameterReturnGeneral procesarEventosTipoMensajeCorreoInvensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoMensajeCorreoInven> tipomensajecorreoinvens,TipoMensajeCorreoInven tipomensajecorreoinven,TipoMensajeCorreoInvenParameterReturnGeneral tipomensajecorreoinvenParameterGeneral,Boolean isEsNuevoTipoMensajeCorreoInven,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMensajeCorreoInven.class.getSimpleName()+"-procesarEventosTipoMensajeCorreoInvensWithConnection");connexion.begin();			
			
			TipoMensajeCorreoInvenParameterReturnGeneral tipomensajecorreoinvenReturnGeneral=new TipoMensajeCorreoInvenParameterReturnGeneral();
	
			tipomensajecorreoinvenReturnGeneral.setTipoMensajeCorreoInven(tipomensajecorreoinven);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipomensajecorreoinvenReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipomensajecorreoinvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoMensajeCorreoInvenParameterReturnGeneral procesarImportacionTipoMensajeCorreoInvensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoMensajeCorreoInvenParameterReturnGeneral tipomensajecorreoinvenParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMensajeCorreoInven.class.getSimpleName()+"-procesarImportacionTipoMensajeCorreoInvensWithConnection");connexion.begin();			
			
			TipoMensajeCorreoInvenParameterReturnGeneral tipomensajecorreoinvenReturnGeneral=new TipoMensajeCorreoInvenParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipomensajecorreoinvens=new ArrayList<TipoMensajeCorreoInven>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipomensajecorreoinven=new TipoMensajeCorreoInven();
				
				
				if(conColumnasBase) {this.tipomensajecorreoinven.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipomensajecorreoinven.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipomensajecorreoinven.setcodigo(arrColumnas[iColumn++]);
				this.tipomensajecorreoinven.setnombre(arrColumnas[iColumn++]);
				
				this.tipomensajecorreoinvens.add(this.tipomensajecorreoinven);
			}
			
			this.saveTipoMensajeCorreoInvens();
			
			this.connexion.commit();
			
			tipomensajecorreoinvenReturnGeneral.setConRetornoEstaProcesado(true);
			tipomensajecorreoinvenReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipomensajecorreoinvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoMensajeCorreoInvensEliminados() throws Exception {				
		
		List<TipoMensajeCorreoInven> tipomensajecorreoinvensAux= new ArrayList<TipoMensajeCorreoInven>();
		
		for(TipoMensajeCorreoInven tipomensajecorreoinven:tipomensajecorreoinvens) {
			if(!tipomensajecorreoinven.getIsDeleted()) {
				tipomensajecorreoinvensAux.add(tipomensajecorreoinven);
			}
		}
		
		tipomensajecorreoinvens=tipomensajecorreoinvensAux;
	}
	
	public void quitarTipoMensajeCorreoInvensNulos() throws Exception {				
		
		List<TipoMensajeCorreoInven> tipomensajecorreoinvensAux= new ArrayList<TipoMensajeCorreoInven>();
		
		for(TipoMensajeCorreoInven tipomensajecorreoinven : this.tipomensajecorreoinvens) {
			if(tipomensajecorreoinven==null) {
				tipomensajecorreoinvensAux.add(tipomensajecorreoinven);
			}
		}
		
		//this.tipomensajecorreoinvens=tipomensajecorreoinvensAux;
		
		this.tipomensajecorreoinvens.removeAll(tipomensajecorreoinvensAux);
	}
	
	public void getSetVersionRowTipoMensajeCorreoInvenWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipomensajecorreoinven.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipomensajecorreoinven.getIsDeleted() || (tipomensajecorreoinven.getIsChanged()&&!tipomensajecorreoinven.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipomensajecorreoinvenDataAccess.getSetVersionRowTipoMensajeCorreoInven(connexion,tipomensajecorreoinven.getId());
				
				if(!tipomensajecorreoinven.getVersionRow().equals(timestamp)) {	
					tipomensajecorreoinven.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipomensajecorreoinven.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoMensajeCorreoInven()throws Exception {	
		
		if(tipomensajecorreoinven.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipomensajecorreoinven.getIsDeleted() || (tipomensajecorreoinven.getIsChanged()&&!tipomensajecorreoinven.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipomensajecorreoinvenDataAccess.getSetVersionRowTipoMensajeCorreoInven(connexion,tipomensajecorreoinven.getId());
			
			try {							
				if(!tipomensajecorreoinven.getVersionRow().equals(timestamp)) {	
					tipomensajecorreoinven.setVersionRow(timestamp);
				}
				
				tipomensajecorreoinven.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoMensajeCorreoInvensWithConnection()throws Exception {	
		if(tipomensajecorreoinvens!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoMensajeCorreoInven tipomensajecorreoinvenAux:tipomensajecorreoinvens) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipomensajecorreoinvenAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipomensajecorreoinvenAux.getIsDeleted() || (tipomensajecorreoinvenAux.getIsChanged()&&!tipomensajecorreoinvenAux.getIsNew())) {
						
						timestamp=tipomensajecorreoinvenDataAccess.getSetVersionRowTipoMensajeCorreoInven(connexion,tipomensajecorreoinvenAux.getId());
						
						if(!tipomensajecorreoinven.getVersionRow().equals(timestamp)) {	
							tipomensajecorreoinvenAux.setVersionRow(timestamp);
						}
								
						tipomensajecorreoinvenAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoMensajeCorreoInvens()throws Exception {	
		if(tipomensajecorreoinvens!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoMensajeCorreoInven tipomensajecorreoinvenAux:tipomensajecorreoinvens) {
					if(tipomensajecorreoinvenAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipomensajecorreoinvenAux.getIsDeleted() || (tipomensajecorreoinvenAux.getIsChanged()&&!tipomensajecorreoinvenAux.getIsNew())) {
						
						timestamp=tipomensajecorreoinvenDataAccess.getSetVersionRowTipoMensajeCorreoInven(connexion,tipomensajecorreoinvenAux.getId());
						
						if(!tipomensajecorreoinvenAux.getVersionRow().equals(timestamp)) {	
							tipomensajecorreoinvenAux.setVersionRow(timestamp);
						}
						
													
						tipomensajecorreoinvenAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoMensajeCorreoInvenParameterReturnGeneral cargarCombosLoteForeignKeyTipoMensajeCorreoInvenWithConnection(String finalQueryGlobalModulo) throws Exception {
		TipoMensajeCorreoInvenParameterReturnGeneral  tipomensajecorreoinvenReturnGeneral =new TipoMensajeCorreoInvenParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMensajeCorreoInven.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoMensajeCorreoInvenWithConnection");connexion.begin();
			
			tipomensajecorreoinvenReturnGeneral =new TipoMensajeCorreoInvenParameterReturnGeneral();
			
			

			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			tipomensajecorreoinvenReturnGeneral.setmodulosForeignKey(modulosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipomensajecorreoinvenReturnGeneral;
	}
	
	public TipoMensajeCorreoInvenParameterReturnGeneral cargarCombosLoteForeignKeyTipoMensajeCorreoInven(String finalQueryGlobalModulo) throws Exception {
		TipoMensajeCorreoInvenParameterReturnGeneral  tipomensajecorreoinvenReturnGeneral =new TipoMensajeCorreoInvenParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipomensajecorreoinvenReturnGeneral =new TipoMensajeCorreoInvenParameterReturnGeneral();
			
			

			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			tipomensajecorreoinvenReturnGeneral.setmodulosForeignKey(modulosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipomensajecorreoinvenReturnGeneral;
	}
	
	
	public void deepLoad(TipoMensajeCorreoInven tipomensajecorreoinven,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoMensajeCorreoInvenLogicAdditional.updateTipoMensajeCorreoInvenToGet(tipomensajecorreoinven,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipomensajecorreoinven.setModulo(tipomensajecorreoinvenDataAccess.getModulo(connexion,tipomensajecorreoinven));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				tipomensajecorreoinven.setModulo(tipomensajecorreoinvenDataAccess.getModulo(connexion,tipomensajecorreoinven));
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
			tipomensajecorreoinven.setModulo(tipomensajecorreoinvenDataAccess.getModulo(connexion,tipomensajecorreoinven));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipomensajecorreoinven.setModulo(tipomensajecorreoinvenDataAccess.getModulo(connexion,tipomensajecorreoinven));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(tipomensajecorreoinven.getModulo(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				tipomensajecorreoinven.setModulo(tipomensajecorreoinvenDataAccess.getModulo(connexion,tipomensajecorreoinven));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(tipomensajecorreoinven.getModulo(),isDeep,deepLoadType,clases);				
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
			tipomensajecorreoinven.setModulo(tipomensajecorreoinvenDataAccess.getModulo(connexion,tipomensajecorreoinven));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(tipomensajecorreoinven.getModulo(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoMensajeCorreoInven tipomensajecorreoinven,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoMensajeCorreoInven.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipomensajecorreoinven,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoMensajeCorreoInven(tipomensajecorreoinven);
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
			this.deepLoad(this.tipomensajecorreoinven,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoMensajeCorreoInven(this.tipomensajecorreoinven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoMensajeCorreoInven.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipomensajecorreoinvens!=null) {
				for(TipoMensajeCorreoInven tipomensajecorreoinven:tipomensajecorreoinvens) {
					this.deepLoad(tipomensajecorreoinven,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoMensajeCorreoInven(tipomensajecorreoinvens);
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
			if(tipomensajecorreoinvens!=null) {
				for(TipoMensajeCorreoInven tipomensajecorreoinven:tipomensajecorreoinvens) {
					this.deepLoad(tipomensajecorreoinven,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoMensajeCorreoInven(tipomensajecorreoinvens);
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
	
	
	public void getTipoMensajeCorreoInvensFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoMensajeCorreoInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,TipoMensajeCorreoInvenConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			TipoMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipomensajecorreoinvens=tipomensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoMensajeCorreoInven(this.tipomensajecorreoinvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoMensajeCorreoInvensFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,TipoMensajeCorreoInvenConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			TipoMensajeCorreoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipomensajecorreoinvens=tipomensajecorreoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoMensajeCorreoInvenConstantesFunciones.refrescarForeignKeysDescripcionesTipoMensajeCorreoInven(this.tipomensajecorreoinvens);
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
			if(TipoMensajeCorreoInvenConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoMensajeCorreoInvenDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoMensajeCorreoInven tipomensajecorreoinven,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoMensajeCorreoInvenConstantesFunciones.ISCONAUDITORIA) {
				if(tipomensajecorreoinven.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoMensajeCorreoInvenDataAccess.TABLENAME, tipomensajecorreoinven.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoMensajeCorreoInvenConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoMensajeCorreoInvenLogic.registrarAuditoriaDetallesTipoMensajeCorreoInven(connexion,tipomensajecorreoinven,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipomensajecorreoinven.getIsDeleted()) {
					/*if(!tipomensajecorreoinven.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoMensajeCorreoInvenDataAccess.TABLENAME, tipomensajecorreoinven.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoMensajeCorreoInvenLogic.registrarAuditoriaDetallesTipoMensajeCorreoInven(connexion,tipomensajecorreoinven,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoMensajeCorreoInvenDataAccess.TABLENAME, tipomensajecorreoinven.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipomensajecorreoinven.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoMensajeCorreoInvenDataAccess.TABLENAME, tipomensajecorreoinven.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoMensajeCorreoInvenConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoMensajeCorreoInvenLogic.registrarAuditoriaDetallesTipoMensajeCorreoInven(connexion,tipomensajecorreoinven,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoMensajeCorreoInven(Connexion connexion,TipoMensajeCorreoInven tipomensajecorreoinven)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipomensajecorreoinven.getIsNew()||!tipomensajecorreoinven.getid_modulo().equals(tipomensajecorreoinven.getTipoMensajeCorreoInvenOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipomensajecorreoinven.getTipoMensajeCorreoInvenOriginal().getid_modulo()!=null)
				{
					strValorActual=tipomensajecorreoinven.getTipoMensajeCorreoInvenOriginal().getid_modulo().toString();
				}
				if(tipomensajecorreoinven.getid_modulo()!=null)
				{
					strValorNuevo=tipomensajecorreoinven.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoMensajeCorreoInvenConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(tipomensajecorreoinven.getIsNew()||!tipomensajecorreoinven.getcodigo().equals(tipomensajecorreoinven.getTipoMensajeCorreoInvenOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipomensajecorreoinven.getTipoMensajeCorreoInvenOriginal().getcodigo()!=null)
				{
					strValorActual=tipomensajecorreoinven.getTipoMensajeCorreoInvenOriginal().getcodigo();
				}
				if(tipomensajecorreoinven.getcodigo()!=null)
				{
					strValorNuevo=tipomensajecorreoinven.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoMensajeCorreoInvenConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipomensajecorreoinven.getIsNew()||!tipomensajecorreoinven.getnombre().equals(tipomensajecorreoinven.getTipoMensajeCorreoInvenOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipomensajecorreoinven.getTipoMensajeCorreoInvenOriginal().getnombre()!=null)
				{
					strValorActual=tipomensajecorreoinven.getTipoMensajeCorreoInvenOriginal().getnombre();
				}
				if(tipomensajecorreoinven.getnombre()!=null)
				{
					strValorNuevo=tipomensajecorreoinven.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoMensajeCorreoInvenConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoMensajeCorreoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoMensajeCorreoInvenConstantesFunciones.getClassesForeignKeysOfTipoMensajeCorreoInven(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoMensajeCorreoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoMensajeCorreoInvenConstantesFunciones.getClassesRelationshipsOfTipoMensajeCorreoInven(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

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
import com.bydan.erp.nomina.util.TipoLibretaMiliConstantesFunciones;
import com.bydan.erp.nomina.util.TipoLibretaMiliParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoLibretaMiliParameterGeneral;
import com.bydan.erp.nomina.business.entity.TipoLibretaMili;
import com.bydan.erp.nomina.business.logic.TipoLibretaMiliLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoLibretaMiliLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoLibretaMiliLogic.class);
	
	protected TipoLibretaMiliDataAccess tipolibretamiliDataAccess; 	
	protected TipoLibretaMili tipolibretamili;
	protected List<TipoLibretaMili> tipolibretamilis;
	protected Object tipolibretamiliObject;	
	protected List<Object> tipolibretamilisObject;
	
	public static ClassValidator<TipoLibretaMili> tipolibretamiliValidator = new ClassValidator<TipoLibretaMili>(TipoLibretaMili.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoLibretaMiliLogicAdditional tipolibretamiliLogicAdditional=null;
	
	public TipoLibretaMiliLogicAdditional getTipoLibretaMiliLogicAdditional() {
		return this.tipolibretamiliLogicAdditional;
	}
	
	public void setTipoLibretaMiliLogicAdditional(TipoLibretaMiliLogicAdditional tipolibretamiliLogicAdditional) {
		try {
			this.tipolibretamiliLogicAdditional=tipolibretamiliLogicAdditional;
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
	
	
	
	
	public  TipoLibretaMiliLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipolibretamiliDataAccess = new TipoLibretaMiliDataAccess();
			
			this.tipolibretamilis= new ArrayList<TipoLibretaMili>();
			this.tipolibretamili= new TipoLibretaMili();
			
			this.tipolibretamiliObject=new Object();
			this.tipolibretamilisObject=new ArrayList<Object>();
				
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
			
			this.tipolibretamiliDataAccess.setConnexionType(this.connexionType);
			this.tipolibretamiliDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoLibretaMiliLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipolibretamiliDataAccess = new TipoLibretaMiliDataAccess();
			this.tipolibretamilis= new ArrayList<TipoLibretaMili>();
			this.tipolibretamili= new TipoLibretaMili();
			this.tipolibretamiliObject=new Object();
			this.tipolibretamilisObject=new ArrayList<Object>();
			
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
			
			this.tipolibretamiliDataAccess.setConnexionType(this.connexionType);
			this.tipolibretamiliDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoLibretaMili getTipoLibretaMili() throws Exception {	
		TipoLibretaMiliLogicAdditional.checkTipoLibretaMiliToGet(tipolibretamili,this.datosCliente,this.arrDatoGeneral);
		TipoLibretaMiliLogicAdditional.updateTipoLibretaMiliToGet(tipolibretamili,this.arrDatoGeneral);
		
		return tipolibretamili;
	}
		
	public void setTipoLibretaMili(TipoLibretaMili newTipoLibretaMili) {
		this.tipolibretamili = newTipoLibretaMili;
	}
	
	public TipoLibretaMiliDataAccess getTipoLibretaMiliDataAccess() {
		return tipolibretamiliDataAccess;
	}
	
	public void setTipoLibretaMiliDataAccess(TipoLibretaMiliDataAccess newtipolibretamiliDataAccess) {
		this.tipolibretamiliDataAccess = newtipolibretamiliDataAccess;
	}
	
	public List<TipoLibretaMili> getTipoLibretaMilis() throws Exception {		
		this.quitarTipoLibretaMilisNulos();
		
		TipoLibretaMiliLogicAdditional.checkTipoLibretaMiliToGets(tipolibretamilis,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoLibretaMili tipolibretamiliLocal: tipolibretamilis ) {
			TipoLibretaMiliLogicAdditional.updateTipoLibretaMiliToGet(tipolibretamiliLocal,this.arrDatoGeneral);
		}
		
		return tipolibretamilis;
	}
	
	public void setTipoLibretaMilis(List<TipoLibretaMili> newTipoLibretaMilis) {
		this.tipolibretamilis = newTipoLibretaMilis;
	}
	
	public Object getTipoLibretaMiliObject() {	
		this.tipolibretamiliObject=this.tipolibretamiliDataAccess.getEntityObject();
		return this.tipolibretamiliObject;
	}
		
	public void setTipoLibretaMiliObject(Object newTipoLibretaMiliObject) {
		this.tipolibretamiliObject = newTipoLibretaMiliObject;
	}
	
	public List<Object> getTipoLibretaMilisObject() {		
		this.tipolibretamilisObject=this.tipolibretamiliDataAccess.getEntitiesObject();
		return this.tipolibretamilisObject;
	}
		
	public void setTipoLibretaMilisObject(List<Object> newTipoLibretaMilisObject) {
		this.tipolibretamilisObject = newTipoLibretaMilisObject;
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
		
		if(this.tipolibretamiliDataAccess!=null) {
			this.tipolibretamiliDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLibretaMili.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipolibretamiliDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipolibretamiliDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipolibretamili = new  TipoLibretaMili();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLibretaMili.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipolibretamili=tipolibretamiliDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipolibretamili,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoLibretaMiliConstantesFunciones.refrescarForeignKeysDescripcionesTipoLibretaMili(this.tipolibretamili);
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
		tipolibretamili = new  TipoLibretaMili();
		  		  
        try {
			
			tipolibretamili=tipolibretamiliDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipolibretamili,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoLibretaMiliConstantesFunciones.refrescarForeignKeysDescripcionesTipoLibretaMili(this.tipolibretamili);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipolibretamili = new  TipoLibretaMili();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLibretaMili.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipolibretamili=tipolibretamiliDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipolibretamili,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoLibretaMiliConstantesFunciones.refrescarForeignKeysDescripcionesTipoLibretaMili(this.tipolibretamili);
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
		tipolibretamili = new  TipoLibretaMili();
		  		  
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
		tipolibretamili = new  TipoLibretaMili();
		  		  
        try {
			
			tipolibretamili=tipolibretamiliDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipolibretamili,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoLibretaMiliConstantesFunciones.refrescarForeignKeysDescripcionesTipoLibretaMili(this.tipolibretamili);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipolibretamili = new  TipoLibretaMili();
		  		  
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
		tipolibretamili = new  TipoLibretaMili();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLibretaMili.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipolibretamiliDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipolibretamili = new  TipoLibretaMili();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipolibretamiliDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipolibretamili = new  TipoLibretaMili();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLibretaMili.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipolibretamiliDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipolibretamili = new  TipoLibretaMili();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipolibretamiliDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipolibretamili = new  TipoLibretaMili();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLibretaMili.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipolibretamiliDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipolibretamili = new  TipoLibretaMili();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipolibretamiliDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipolibretamilis = new  ArrayList<TipoLibretaMili>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLibretaMili.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoLibretaMiliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipolibretamilis=tipolibretamiliDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoLibretaMili(tipolibretamilis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoLibretaMiliConstantesFunciones.refrescarForeignKeysDescripcionesTipoLibretaMili(this.tipolibretamilis);
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
		tipolibretamilis = new  ArrayList<TipoLibretaMili>();
		  		  
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
		tipolibretamilis = new  ArrayList<TipoLibretaMili>();
		  		  
        try {			
			TipoLibretaMiliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipolibretamilis=tipolibretamiliDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoLibretaMili(tipolibretamilis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoLibretaMiliConstantesFunciones.refrescarForeignKeysDescripcionesTipoLibretaMili(this.tipolibretamilis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipolibretamilis = new  ArrayList<TipoLibretaMili>();
		  		  
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
		tipolibretamilis = new  ArrayList<TipoLibretaMili>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLibretaMili.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoLibretaMiliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipolibretamilis=tipolibretamiliDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoLibretaMili(tipolibretamilis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoLibretaMiliConstantesFunciones.refrescarForeignKeysDescripcionesTipoLibretaMili(this.tipolibretamilis);
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
		tipolibretamilis = new  ArrayList<TipoLibretaMili>();
		  		  
        try {
			TipoLibretaMiliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipolibretamilis=tipolibretamiliDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoLibretaMili(tipolibretamilis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoLibretaMiliConstantesFunciones.refrescarForeignKeysDescripcionesTipoLibretaMili(this.tipolibretamilis);
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
		tipolibretamilis = new  ArrayList<TipoLibretaMili>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLibretaMili.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoLibretaMiliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipolibretamilis=tipolibretamiliDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoLibretaMili(tipolibretamilis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoLibretaMiliConstantesFunciones.refrescarForeignKeysDescripcionesTipoLibretaMili(this.tipolibretamilis);
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
		tipolibretamilis = new  ArrayList<TipoLibretaMili>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoLibretaMiliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipolibretamilis=tipolibretamiliDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoLibretaMili(tipolibretamilis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoLibretaMiliConstantesFunciones.refrescarForeignKeysDescripcionesTipoLibretaMili(this.tipolibretamilis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipolibretamili = new  TipoLibretaMili();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLibretaMili.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoLibretaMiliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipolibretamili=tipolibretamiliDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoLibretaMili(tipolibretamili);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoLibretaMiliConstantesFunciones.refrescarForeignKeysDescripcionesTipoLibretaMili(this.tipolibretamili);
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
		tipolibretamili = new  TipoLibretaMili();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoLibretaMiliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipolibretamili=tipolibretamiliDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoLibretaMili(tipolibretamili);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoLibretaMiliConstantesFunciones.refrescarForeignKeysDescripcionesTipoLibretaMili(this.tipolibretamili);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipolibretamilis = new  ArrayList<TipoLibretaMili>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLibretaMili.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoLibretaMiliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipolibretamilis=tipolibretamiliDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoLibretaMili(tipolibretamilis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoLibretaMiliConstantesFunciones.refrescarForeignKeysDescripcionesTipoLibretaMili(this.tipolibretamilis);
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
		tipolibretamilis = new  ArrayList<TipoLibretaMili>();
		  		  
        try {
			TipoLibretaMiliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipolibretamilis=tipolibretamiliDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoLibretaMili(tipolibretamilis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoLibretaMiliConstantesFunciones.refrescarForeignKeysDescripcionesTipoLibretaMili(this.tipolibretamilis);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoLibretaMilisWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipolibretamilis = new  ArrayList<TipoLibretaMili>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLibretaMili.class.getSimpleName()+"-getTodosTipoLibretaMilisWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoLibretaMiliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipolibretamilis=tipolibretamiliDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoLibretaMili(tipolibretamilis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoLibretaMiliConstantesFunciones.refrescarForeignKeysDescripcionesTipoLibretaMili(this.tipolibretamilis);
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
	
	public  void  getTodosTipoLibretaMilis(String sFinalQuery,Pagination pagination)throws Exception {
		tipolibretamilis = new  ArrayList<TipoLibretaMili>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoLibretaMiliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipolibretamilis=tipolibretamiliDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoLibretaMili(tipolibretamilis);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoLibretaMiliConstantesFunciones.refrescarForeignKeysDescripcionesTipoLibretaMili(this.tipolibretamilis);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoLibretaMili(TipoLibretaMili tipolibretamili) throws Exception {
		Boolean estaValidado=false;
		
		if(tipolibretamili.getIsNew() || tipolibretamili.getIsChanged()) { 
			this.invalidValues = tipolibretamiliValidator.getInvalidValues(tipolibretamili);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipolibretamili);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoLibretaMili(List<TipoLibretaMili> TipoLibretaMilis) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoLibretaMili tipolibretamiliLocal:tipolibretamilis) {				
			estaValidadoObjeto=this.validarGuardarTipoLibretaMili(tipolibretamiliLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoLibretaMili(List<TipoLibretaMili> TipoLibretaMilis) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoLibretaMili(tipolibretamilis)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoLibretaMili(TipoLibretaMili TipoLibretaMili) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoLibretaMili(tipolibretamili)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoLibretaMili tipolibretamili) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipolibretamili.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoLibretaMiliConstantesFunciones.getTipoLibretaMiliLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipolibretamili","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoLibretaMiliConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoLibretaMiliConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoLibretaMiliWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLibretaMili.class.getSimpleName()+"-saveTipoLibretaMiliWithConnection");connexion.begin();			
			
			TipoLibretaMiliLogicAdditional.checkTipoLibretaMiliToSave(this.tipolibretamili,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoLibretaMiliLogicAdditional.updateTipoLibretaMiliToSave(this.tipolibretamili,this.arrDatoGeneral);
			
			TipoLibretaMiliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipolibretamili,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoLibretaMili();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoLibretaMili(this.tipolibretamili)) {
				TipoLibretaMiliDataAccess.save(this.tipolibretamili, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipolibretamili,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoLibretaMiliLogicAdditional.checkTipoLibretaMiliToSaveAfter(this.tipolibretamili,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoLibretaMili();
			
			connexion.commit();			
			
			if(this.tipolibretamili.getIsDeleted()) {
				this.tipolibretamili=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoLibretaMili()throws Exception {	
		try {	
			
			TipoLibretaMiliLogicAdditional.checkTipoLibretaMiliToSave(this.tipolibretamili,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoLibretaMiliLogicAdditional.updateTipoLibretaMiliToSave(this.tipolibretamili,this.arrDatoGeneral);
			
			TipoLibretaMiliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipolibretamili,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoLibretaMili(this.tipolibretamili)) {			
				TipoLibretaMiliDataAccess.save(this.tipolibretamili, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipolibretamili,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoLibretaMiliLogicAdditional.checkTipoLibretaMiliToSaveAfter(this.tipolibretamili,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipolibretamili.getIsDeleted()) {
				this.tipolibretamili=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoLibretaMilisWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLibretaMili.class.getSimpleName()+"-saveTipoLibretaMilisWithConnection");connexion.begin();			
			
			TipoLibretaMiliLogicAdditional.checkTipoLibretaMiliToSaves(tipolibretamilis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoLibretaMilis();
			
			Boolean validadoTodosTipoLibretaMili=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoLibretaMili tipolibretamiliLocal:tipolibretamilis) {		
				if(tipolibretamiliLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoLibretaMiliLogicAdditional.updateTipoLibretaMiliToSave(tipolibretamiliLocal,this.arrDatoGeneral);
	        	
				TipoLibretaMiliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipolibretamiliLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoLibretaMili(tipolibretamiliLocal)) {
					TipoLibretaMiliDataAccess.save(tipolibretamiliLocal, connexion);				
				} else {
					validadoTodosTipoLibretaMili=false;
				}
			}
			
			if(!validadoTodosTipoLibretaMili) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoLibretaMiliLogicAdditional.checkTipoLibretaMiliToSavesAfter(tipolibretamilis,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoLibretaMilis();
			
			connexion.commit();		
			
			this.quitarTipoLibretaMilisEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoLibretaMilis()throws Exception {				
		 try {	
			TipoLibretaMiliLogicAdditional.checkTipoLibretaMiliToSaves(tipolibretamilis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoLibretaMili=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoLibretaMili tipolibretamiliLocal:tipolibretamilis) {				
				if(tipolibretamiliLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoLibretaMiliLogicAdditional.updateTipoLibretaMiliToSave(tipolibretamiliLocal,this.arrDatoGeneral);
	        	
				TipoLibretaMiliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipolibretamiliLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoLibretaMili(tipolibretamiliLocal)) {				
					TipoLibretaMiliDataAccess.save(tipolibretamiliLocal, connexion);				
				} else {
					validadoTodosTipoLibretaMili=false;
				}
			}
			
			if(!validadoTodosTipoLibretaMili) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoLibretaMiliLogicAdditional.checkTipoLibretaMiliToSavesAfter(tipolibretamilis,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoLibretaMilisEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoLibretaMiliParameterReturnGeneral procesarAccionTipoLibretaMilis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoLibretaMili> tipolibretamilis,TipoLibretaMiliParameterReturnGeneral tipolibretamiliParameterGeneral)throws Exception {
		 try {	
			TipoLibretaMiliParameterReturnGeneral tipolibretamiliReturnGeneral=new TipoLibretaMiliParameterReturnGeneral();
	
			TipoLibretaMiliLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipolibretamilis,tipolibretamiliParameterGeneral,tipolibretamiliReturnGeneral);
			
			return tipolibretamiliReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoLibretaMiliParameterReturnGeneral procesarAccionTipoLibretaMilisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoLibretaMili> tipolibretamilis,TipoLibretaMiliParameterReturnGeneral tipolibretamiliParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLibretaMili.class.getSimpleName()+"-procesarAccionTipoLibretaMilisWithConnection");connexion.begin();			
			
			TipoLibretaMiliParameterReturnGeneral tipolibretamiliReturnGeneral=new TipoLibretaMiliParameterReturnGeneral();
	
			TipoLibretaMiliLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipolibretamilis,tipolibretamiliParameterGeneral,tipolibretamiliReturnGeneral);
			
			this.connexion.commit();
			
			return tipolibretamiliReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoLibretaMiliParameterReturnGeneral procesarEventosTipoLibretaMilis(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoLibretaMili> tipolibretamilis,TipoLibretaMili tipolibretamili,TipoLibretaMiliParameterReturnGeneral tipolibretamiliParameterGeneral,Boolean isEsNuevoTipoLibretaMili,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoLibretaMiliParameterReturnGeneral tipolibretamiliReturnGeneral=new TipoLibretaMiliParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipolibretamiliReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoLibretaMiliLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipolibretamilis,tipolibretamili,tipolibretamiliParameterGeneral,tipolibretamiliReturnGeneral,isEsNuevoTipoLibretaMili,clases);
			
			return tipolibretamiliReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoLibretaMiliParameterReturnGeneral procesarEventosTipoLibretaMilisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoLibretaMili> tipolibretamilis,TipoLibretaMili tipolibretamili,TipoLibretaMiliParameterReturnGeneral tipolibretamiliParameterGeneral,Boolean isEsNuevoTipoLibretaMili,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLibretaMili.class.getSimpleName()+"-procesarEventosTipoLibretaMilisWithConnection");connexion.begin();			
			
			TipoLibretaMiliParameterReturnGeneral tipolibretamiliReturnGeneral=new TipoLibretaMiliParameterReturnGeneral();
	
			tipolibretamiliReturnGeneral.setTipoLibretaMili(tipolibretamili);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipolibretamiliReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoLibretaMiliLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipolibretamilis,tipolibretamili,tipolibretamiliParameterGeneral,tipolibretamiliReturnGeneral,isEsNuevoTipoLibretaMili,clases);
			
			this.connexion.commit();
			
			return tipolibretamiliReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoLibretaMiliParameterReturnGeneral procesarImportacionTipoLibretaMilisWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoLibretaMiliParameterReturnGeneral tipolibretamiliParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLibretaMili.class.getSimpleName()+"-procesarImportacionTipoLibretaMilisWithConnection");connexion.begin();			
			
			TipoLibretaMiliParameterReturnGeneral tipolibretamiliReturnGeneral=new TipoLibretaMiliParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipolibretamilis=new ArrayList<TipoLibretaMili>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipolibretamili=new TipoLibretaMili();
				
				
				if(conColumnasBase) {this.tipolibretamili.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipolibretamili.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipolibretamili.setcodigo(arrColumnas[iColumn++]);
				this.tipolibretamili.setnombre(arrColumnas[iColumn++]);
				
				this.tipolibretamilis.add(this.tipolibretamili);
			}
			
			this.saveTipoLibretaMilis();
			
			this.connexion.commit();
			
			tipolibretamiliReturnGeneral.setConRetornoEstaProcesado(true);
			tipolibretamiliReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipolibretamiliReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoLibretaMilisEliminados() throws Exception {				
		
		List<TipoLibretaMili> tipolibretamilisAux= new ArrayList<TipoLibretaMili>();
		
		for(TipoLibretaMili tipolibretamili:tipolibretamilis) {
			if(!tipolibretamili.getIsDeleted()) {
				tipolibretamilisAux.add(tipolibretamili);
			}
		}
		
		tipolibretamilis=tipolibretamilisAux;
	}
	
	public void quitarTipoLibretaMilisNulos() throws Exception {				
		
		List<TipoLibretaMili> tipolibretamilisAux= new ArrayList<TipoLibretaMili>();
		
		for(TipoLibretaMili tipolibretamili : this.tipolibretamilis) {
			if(tipolibretamili==null) {
				tipolibretamilisAux.add(tipolibretamili);
			}
		}
		
		//this.tipolibretamilis=tipolibretamilisAux;
		
		this.tipolibretamilis.removeAll(tipolibretamilisAux);
	}
	
	public void getSetVersionRowTipoLibretaMiliWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipolibretamili.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipolibretamili.getIsDeleted() || (tipolibretamili.getIsChanged()&&!tipolibretamili.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipolibretamiliDataAccess.getSetVersionRowTipoLibretaMili(connexion,tipolibretamili.getId());
				
				if(!tipolibretamili.getVersionRow().equals(timestamp)) {	
					tipolibretamili.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipolibretamili.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoLibretaMili()throws Exception {	
		
		if(tipolibretamili.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipolibretamili.getIsDeleted() || (tipolibretamili.getIsChanged()&&!tipolibretamili.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipolibretamiliDataAccess.getSetVersionRowTipoLibretaMili(connexion,tipolibretamili.getId());
			
			try {							
				if(!tipolibretamili.getVersionRow().equals(timestamp)) {	
					tipolibretamili.setVersionRow(timestamp);
				}
				
				tipolibretamili.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoLibretaMilisWithConnection()throws Exception {	
		if(tipolibretamilis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoLibretaMili tipolibretamiliAux:tipolibretamilis) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipolibretamiliAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipolibretamiliAux.getIsDeleted() || (tipolibretamiliAux.getIsChanged()&&!tipolibretamiliAux.getIsNew())) {
						
						timestamp=tipolibretamiliDataAccess.getSetVersionRowTipoLibretaMili(connexion,tipolibretamiliAux.getId());
						
						if(!tipolibretamili.getVersionRow().equals(timestamp)) {	
							tipolibretamiliAux.setVersionRow(timestamp);
						}
								
						tipolibretamiliAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoLibretaMilis()throws Exception {	
		if(tipolibretamilis!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoLibretaMili tipolibretamiliAux:tipolibretamilis) {
					if(tipolibretamiliAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipolibretamiliAux.getIsDeleted() || (tipolibretamiliAux.getIsChanged()&&!tipolibretamiliAux.getIsNew())) {
						
						timestamp=tipolibretamiliDataAccess.getSetVersionRowTipoLibretaMili(connexion,tipolibretamiliAux.getId());
						
						if(!tipolibretamiliAux.getVersionRow().equals(timestamp)) {	
							tipolibretamiliAux.setVersionRow(timestamp);
						}
						
													
						tipolibretamiliAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoLibretaMiliParameterReturnGeneral cargarCombosLoteForeignKeyTipoLibretaMiliWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoLibretaMiliParameterReturnGeneral  tipolibretamiliReturnGeneral =new TipoLibretaMiliParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLibretaMili.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoLibretaMiliWithConnection");connexion.begin();
			
			tipolibretamiliReturnGeneral =new TipoLibretaMiliParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipolibretamiliReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipolibretamiliReturnGeneral;
	}
	
	public TipoLibretaMiliParameterReturnGeneral cargarCombosLoteForeignKeyTipoLibretaMili(String finalQueryGlobalEmpresa) throws Exception {
		TipoLibretaMiliParameterReturnGeneral  tipolibretamiliReturnGeneral =new TipoLibretaMiliParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipolibretamiliReturnGeneral =new TipoLibretaMiliParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipolibretamiliReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipolibretamiliReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoLibretaMiliWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DatoGeneralEmpleadoLogic datogeneralempleadoLogic=new DatoGeneralEmpleadoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLibretaMili.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoLibretaMiliWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DatoGeneralEmpleado.class));
											
			

			datogeneralempleadoLogic.setConnexion(this.getConnexion());
			datogeneralempleadoLogic.setDatosCliente(this.datosCliente);
			datogeneralempleadoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoLibretaMili tipolibretamili:this.tipolibretamilis) {
				

				classes=new ArrayList<Classe>();
				classes=DatoGeneralEmpleadoConstantesFunciones.getClassesForeignKeysOfDatoGeneralEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);

				datogeneralempleadoLogic.setDatoGeneralEmpleados(tipolibretamili.datogeneralempleados);
				datogeneralempleadoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoLibretaMili tipolibretamili,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoLibretaMiliLogicAdditional.updateTipoLibretaMiliToGet(tipolibretamili,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipolibretamili.setEmpresa(tipolibretamiliDataAccess.getEmpresa(connexion,tipolibretamili));
		tipolibretamili.setDatoGeneralEmpleados(tipolibretamiliDataAccess.getDatoGeneralEmpleados(connexion,tipolibretamili));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipolibretamili.setEmpresa(tipolibretamiliDataAccess.getEmpresa(connexion,tipolibretamili));
				continue;
			}

			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipolibretamili.setDatoGeneralEmpleados(tipolibretamiliDataAccess.getDatoGeneralEmpleados(connexion,tipolibretamili));

				if(this.isConDeep) {
					DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(this.connexion);
					datogeneralempleadoLogic.setDatoGeneralEmpleados(tipolibretamili.getDatoGeneralEmpleados());
					ArrayList<Classe> classesLocal=DatoGeneralEmpleadoConstantesFunciones.getClassesForeignKeysOfDatoGeneralEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);
					datogeneralempleadoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(datogeneralempleadoLogic.getDatoGeneralEmpleados());
					tipolibretamili.setDatoGeneralEmpleados(datogeneralempleadoLogic.getDatoGeneralEmpleados());
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
			tipolibretamili.setEmpresa(tipolibretamiliDataAccess.getEmpresa(connexion,tipolibretamili));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DatoGeneralEmpleado.class));
			tipolibretamili.setDatoGeneralEmpleados(tipolibretamiliDataAccess.getDatoGeneralEmpleados(connexion,tipolibretamili));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipolibretamili.setEmpresa(tipolibretamiliDataAccess.getEmpresa(connexion,tipolibretamili));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipolibretamili.getEmpresa(),isDeep,deepLoadType,clases);
				

		tipolibretamili.setDatoGeneralEmpleados(tipolibretamiliDataAccess.getDatoGeneralEmpleados(connexion,tipolibretamili));

		for(DatoGeneralEmpleado datogeneralempleado:tipolibretamili.getDatoGeneralEmpleados()) {
			DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);
			datogeneralempleadoLogic.deepLoad(datogeneralempleado,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipolibretamili.setEmpresa(tipolibretamiliDataAccess.getEmpresa(connexion,tipolibretamili));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipolibretamili.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipolibretamili.setDatoGeneralEmpleados(tipolibretamiliDataAccess.getDatoGeneralEmpleados(connexion,tipolibretamili));

				for(DatoGeneralEmpleado datogeneralempleado:tipolibretamili.getDatoGeneralEmpleados()) {
					DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);
					datogeneralempleadoLogic.deepLoad(datogeneralempleado,isDeep,deepLoadType,clases);
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
			tipolibretamili.setEmpresa(tipolibretamiliDataAccess.getEmpresa(connexion,tipolibretamili));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipolibretamili.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DatoGeneralEmpleado.class));
			tipolibretamili.setDatoGeneralEmpleados(tipolibretamiliDataAccess.getDatoGeneralEmpleados(connexion,tipolibretamili));

			for(DatoGeneralEmpleado datogeneralempleado:tipolibretamili.getDatoGeneralEmpleados()) {
				DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);
				datogeneralempleadoLogic.deepLoad(datogeneralempleado,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoLibretaMili tipolibretamili,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoLibretaMiliLogicAdditional.updateTipoLibretaMiliToSave(tipolibretamili,this.arrDatoGeneral);
			
TipoLibretaMiliDataAccess.save(tipolibretamili, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipolibretamili.getEmpresa(),connexion);

		for(DatoGeneralEmpleado datogeneralempleado:tipolibretamili.getDatoGeneralEmpleados()) {
			datogeneralempleado.setid_tipo_libreta_mili(tipolibretamili.getId());
			DatoGeneralEmpleadoDataAccess.save(datogeneralempleado,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipolibretamili.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DatoGeneralEmpleado datogeneralempleado:tipolibretamili.getDatoGeneralEmpleados()) {
					datogeneralempleado.setid_tipo_libreta_mili(tipolibretamili.getId());
					DatoGeneralEmpleadoDataAccess.save(datogeneralempleado,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipolibretamili.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipolibretamili.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(DatoGeneralEmpleado datogeneralempleado:tipolibretamili.getDatoGeneralEmpleados()) {
			DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);
			datogeneralempleado.setid_tipo_libreta_mili(tipolibretamili.getId());
			DatoGeneralEmpleadoDataAccess.save(datogeneralempleado,connexion);
			datogeneralempleadoLogic.deepSave(datogeneralempleado,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipolibretamili.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipolibretamili.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DatoGeneralEmpleado datogeneralempleado:tipolibretamili.getDatoGeneralEmpleados()) {
					DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);
					datogeneralempleado.setid_tipo_libreta_mili(tipolibretamili.getId());
					DatoGeneralEmpleadoDataAccess.save(datogeneralempleado,connexion);
					datogeneralempleadoLogic.deepSave(datogeneralempleado,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoLibretaMili.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipolibretamili,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoLibretaMiliConstantesFunciones.refrescarForeignKeysDescripcionesTipoLibretaMili(tipolibretamili);
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
			this.deepLoad(this.tipolibretamili,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoLibretaMiliConstantesFunciones.refrescarForeignKeysDescripcionesTipoLibretaMili(this.tipolibretamili);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoLibretaMili.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipolibretamilis!=null) {
				for(TipoLibretaMili tipolibretamili:tipolibretamilis) {
					this.deepLoad(tipolibretamili,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoLibretaMiliConstantesFunciones.refrescarForeignKeysDescripcionesTipoLibretaMili(tipolibretamilis);
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
			if(tipolibretamilis!=null) {
				for(TipoLibretaMili tipolibretamili:tipolibretamilis) {
					this.deepLoad(tipolibretamili,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoLibretaMiliConstantesFunciones.refrescarForeignKeysDescripcionesTipoLibretaMili(tipolibretamilis);
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
			this.getNewConnexionToDeep(TipoLibretaMili.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipolibretamili,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoLibretaMili.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipolibretamilis!=null) {
				for(TipoLibretaMili tipolibretamili:tipolibretamilis) {
					this.deepSave(tipolibretamili,isDeep,deepLoadType,clases);
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
			if(tipolibretamilis!=null) {
				for(TipoLibretaMili tipolibretamili:tipolibretamilis) {
					this.deepSave(tipolibretamili,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoLibretaMilisFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoLibretaMili.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoLibretaMiliConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoLibretaMiliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipolibretamilis=tipolibretamiliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoLibretaMiliConstantesFunciones.refrescarForeignKeysDescripcionesTipoLibretaMili(this.tipolibretamilis);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoLibretaMilisFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoLibretaMiliConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoLibretaMiliLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipolibretamilis=tipolibretamiliDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoLibretaMiliConstantesFunciones.refrescarForeignKeysDescripcionesTipoLibretaMili(this.tipolibretamilis);
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
			if(TipoLibretaMiliConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoLibretaMiliDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoLibretaMili tipolibretamili,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoLibretaMiliConstantesFunciones.ISCONAUDITORIA) {
				if(tipolibretamili.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoLibretaMiliDataAccess.TABLENAME, tipolibretamili.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoLibretaMiliConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoLibretaMiliLogic.registrarAuditoriaDetallesTipoLibretaMili(connexion,tipolibretamili,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipolibretamili.getIsDeleted()) {
					/*if(!tipolibretamili.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoLibretaMiliDataAccess.TABLENAME, tipolibretamili.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoLibretaMiliLogic.registrarAuditoriaDetallesTipoLibretaMili(connexion,tipolibretamili,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoLibretaMiliDataAccess.TABLENAME, tipolibretamili.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipolibretamili.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoLibretaMiliDataAccess.TABLENAME, tipolibretamili.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoLibretaMiliConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoLibretaMiliLogic.registrarAuditoriaDetallesTipoLibretaMili(connexion,tipolibretamili,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoLibretaMili(Connexion connexion,TipoLibretaMili tipolibretamili)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipolibretamili.getIsNew()||!tipolibretamili.getid_empresa().equals(tipolibretamili.getTipoLibretaMiliOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipolibretamili.getTipoLibretaMiliOriginal().getid_empresa()!=null)
				{
					strValorActual=tipolibretamili.getTipoLibretaMiliOriginal().getid_empresa().toString();
				}
				if(tipolibretamili.getid_empresa()!=null)
				{
					strValorNuevo=tipolibretamili.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoLibretaMiliConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipolibretamili.getIsNew()||!tipolibretamili.getcodigo().equals(tipolibretamili.getTipoLibretaMiliOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipolibretamili.getTipoLibretaMiliOriginal().getcodigo()!=null)
				{
					strValorActual=tipolibretamili.getTipoLibretaMiliOriginal().getcodigo();
				}
				if(tipolibretamili.getcodigo()!=null)
				{
					strValorNuevo=tipolibretamili.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoLibretaMiliConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipolibretamili.getIsNew()||!tipolibretamili.getnombre().equals(tipolibretamili.getTipoLibretaMiliOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipolibretamili.getTipoLibretaMiliOriginal().getnombre()!=null)
				{
					strValorActual=tipolibretamili.getTipoLibretaMiliOriginal().getnombre();
				}
				if(tipolibretamili.getnombre()!=null)
				{
					strValorNuevo=tipolibretamili.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoLibretaMiliConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoLibretaMiliRelacionesWithConnection(TipoLibretaMili tipolibretamili,List<DatoGeneralEmpleado> datogeneralempleados) throws Exception {

		if(!tipolibretamili.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoLibretaMiliRelacionesBase(tipolibretamili,datogeneralempleados,true);
		}
	}

	public void saveTipoLibretaMiliRelaciones(TipoLibretaMili tipolibretamili,List<DatoGeneralEmpleado> datogeneralempleados)throws Exception {

		if(!tipolibretamili.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoLibretaMiliRelacionesBase(tipolibretamili,datogeneralempleados,false);
		}
	}

	public void saveTipoLibretaMiliRelacionesBase(TipoLibretaMili tipolibretamili,List<DatoGeneralEmpleado> datogeneralempleados,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoLibretaMili-saveRelacionesWithConnection");}
	
			tipolibretamili.setDatoGeneralEmpleados(datogeneralempleados);

			this.setTipoLibretaMili(tipolibretamili);

			if(TipoLibretaMiliLogicAdditional.validarSaveRelaciones(tipolibretamili,this)) {

				TipoLibretaMiliLogicAdditional.updateRelacionesToSave(tipolibretamili,this);

				if((tipolibretamili.getIsNew()||tipolibretamili.getIsChanged())&&!tipolibretamili.getIsDeleted()) {
					this.saveTipoLibretaMili();
					this.saveTipoLibretaMiliRelacionesDetalles(datogeneralempleados);

				} else if(tipolibretamili.getIsDeleted()) {
					this.saveTipoLibretaMiliRelacionesDetalles(datogeneralempleados);
					this.saveTipoLibretaMili();
				}

				TipoLibretaMiliLogicAdditional.updateRelacionesToSaveAfter(tipolibretamili,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DatoGeneralEmpleadoConstantesFunciones.InicializarGeneralEntityAuxiliaresDatoGeneralEmpleados(datogeneralempleados,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoLibretaMiliRelacionesDetalles(List<DatoGeneralEmpleado> datogeneralempleados)throws Exception {
		try {
	

			Long idTipoLibretaMiliActual=this.getTipoLibretaMili().getId();

			DatoGeneralEmpleadoLogic datogeneralempleadoLogic_Desde_TipoLibretaMili=new DatoGeneralEmpleadoLogic();
			datogeneralempleadoLogic_Desde_TipoLibretaMili.setDatoGeneralEmpleados(datogeneralempleados);

			datogeneralempleadoLogic_Desde_TipoLibretaMili.setConnexion(this.getConnexion());
			datogeneralempleadoLogic_Desde_TipoLibretaMili.setDatosCliente(this.datosCliente);

			for(DatoGeneralEmpleado datogeneralempleado_Desde_TipoLibretaMili:datogeneralempleadoLogic_Desde_TipoLibretaMili.getDatoGeneralEmpleados()) {
				datogeneralempleado_Desde_TipoLibretaMili.setid_tipo_libreta_mili(idTipoLibretaMiliActual);
			}

			datogeneralempleadoLogic_Desde_TipoLibretaMili.saveDatoGeneralEmpleados();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoLibretaMili(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoLibretaMiliConstantesFunciones.getClassesForeignKeysOfTipoLibretaMili(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoLibretaMili(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoLibretaMiliConstantesFunciones.getClassesRelationshipsOfTipoLibretaMili(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

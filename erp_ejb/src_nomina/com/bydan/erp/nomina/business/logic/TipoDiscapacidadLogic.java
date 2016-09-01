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
import com.bydan.erp.nomina.util.TipoDiscapacidadConstantesFunciones;
import com.bydan.erp.nomina.util.TipoDiscapacidadParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoDiscapacidadParameterGeneral;
import com.bydan.erp.nomina.business.entity.TipoDiscapacidad;
//import com.bydan.erp.nomina.business.logic.TipoDiscapacidadLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoDiscapacidadLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoDiscapacidadLogic.class);
	
	protected TipoDiscapacidadDataAccess tipodiscapacidadDataAccess; 	
	protected TipoDiscapacidad tipodiscapacidad;
	protected List<TipoDiscapacidad> tipodiscapacidads;
	protected Object tipodiscapacidadObject;	
	protected List<Object> tipodiscapacidadsObject;
	
	public static ClassValidator<TipoDiscapacidad> tipodiscapacidadValidator = new ClassValidator<TipoDiscapacidad>(TipoDiscapacidad.class);	
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
	
	
	
	
	public  TipoDiscapacidadLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipodiscapacidadDataAccess = new TipoDiscapacidadDataAccess();
			
			this.tipodiscapacidads= new ArrayList<TipoDiscapacidad>();
			this.tipodiscapacidad= new TipoDiscapacidad();
			
			this.tipodiscapacidadObject=new Object();
			this.tipodiscapacidadsObject=new ArrayList<Object>();
				
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
			
			this.tipodiscapacidadDataAccess.setConnexionType(this.connexionType);
			this.tipodiscapacidadDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoDiscapacidadLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipodiscapacidadDataAccess = new TipoDiscapacidadDataAccess();
			this.tipodiscapacidads= new ArrayList<TipoDiscapacidad>();
			this.tipodiscapacidad= new TipoDiscapacidad();
			this.tipodiscapacidadObject=new Object();
			this.tipodiscapacidadsObject=new ArrayList<Object>();
			
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
			
			this.tipodiscapacidadDataAccess.setConnexionType(this.connexionType);
			this.tipodiscapacidadDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoDiscapacidad getTipoDiscapacidad() throws Exception {	
		//TipoDiscapacidadLogicAdditional.checkTipoDiscapacidadToGet(tipodiscapacidad,this.datosCliente,this.arrDatoGeneral);
		//TipoDiscapacidadLogicAdditional.updateTipoDiscapacidadToGet(tipodiscapacidad,this.arrDatoGeneral);
		
		return tipodiscapacidad;
	}
		
	public void setTipoDiscapacidad(TipoDiscapacidad newTipoDiscapacidad) {
		this.tipodiscapacidad = newTipoDiscapacidad;
	}
	
	public TipoDiscapacidadDataAccess getTipoDiscapacidadDataAccess() {
		return tipodiscapacidadDataAccess;
	}
	
	public void setTipoDiscapacidadDataAccess(TipoDiscapacidadDataAccess newtipodiscapacidadDataAccess) {
		this.tipodiscapacidadDataAccess = newtipodiscapacidadDataAccess;
	}
	
	public List<TipoDiscapacidad> getTipoDiscapacidads() throws Exception {		
		this.quitarTipoDiscapacidadsNulos();
		
		//TipoDiscapacidadLogicAdditional.checkTipoDiscapacidadToGets(tipodiscapacidads,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoDiscapacidad tipodiscapacidadLocal: tipodiscapacidads ) {
			//TipoDiscapacidadLogicAdditional.updateTipoDiscapacidadToGet(tipodiscapacidadLocal,this.arrDatoGeneral);
		}
		
		return tipodiscapacidads;
	}
	
	public void setTipoDiscapacidads(List<TipoDiscapacidad> newTipoDiscapacidads) {
		this.tipodiscapacidads = newTipoDiscapacidads;
	}
	
	public Object getTipoDiscapacidadObject() {	
		this.tipodiscapacidadObject=this.tipodiscapacidadDataAccess.getEntityObject();
		return this.tipodiscapacidadObject;
	}
		
	public void setTipoDiscapacidadObject(Object newTipoDiscapacidadObject) {
		this.tipodiscapacidadObject = newTipoDiscapacidadObject;
	}
	
	public List<Object> getTipoDiscapacidadsObject() {		
		this.tipodiscapacidadsObject=this.tipodiscapacidadDataAccess.getEntitiesObject();
		return this.tipodiscapacidadsObject;
	}
		
	public void setTipoDiscapacidadsObject(List<Object> newTipoDiscapacidadsObject) {
		this.tipodiscapacidadsObject = newTipoDiscapacidadsObject;
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
		
		if(this.tipodiscapacidadDataAccess!=null) {
			this.tipodiscapacidadDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDiscapacidad.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipodiscapacidadDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipodiscapacidadDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipodiscapacidad = new  TipoDiscapacidad();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDiscapacidad.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipodiscapacidad=tipodiscapacidadDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodiscapacidad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDiscapacidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoDiscapacidad(this.tipodiscapacidad);
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
		tipodiscapacidad = new  TipoDiscapacidad();
		  		  
        try {
			
			tipodiscapacidad=tipodiscapacidadDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodiscapacidad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDiscapacidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoDiscapacidad(this.tipodiscapacidad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipodiscapacidad = new  TipoDiscapacidad();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDiscapacidad.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipodiscapacidad=tipodiscapacidadDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodiscapacidad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDiscapacidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoDiscapacidad(this.tipodiscapacidad);
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
		tipodiscapacidad = new  TipoDiscapacidad();
		  		  
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
		tipodiscapacidad = new  TipoDiscapacidad();
		  		  
        try {
			
			tipodiscapacidad=tipodiscapacidadDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipodiscapacidad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoDiscapacidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoDiscapacidad(this.tipodiscapacidad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipodiscapacidad = new  TipoDiscapacidad();
		  		  
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
		tipodiscapacidad = new  TipoDiscapacidad();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDiscapacidad.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipodiscapacidadDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipodiscapacidad = new  TipoDiscapacidad();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipodiscapacidadDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipodiscapacidad = new  TipoDiscapacidad();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDiscapacidad.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipodiscapacidadDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipodiscapacidad = new  TipoDiscapacidad();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipodiscapacidadDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipodiscapacidad = new  TipoDiscapacidad();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDiscapacidad.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipodiscapacidadDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipodiscapacidad = new  TipoDiscapacidad();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipodiscapacidadDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipodiscapacidads = new  ArrayList<TipoDiscapacidad>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDiscapacidad.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoDiscapacidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodiscapacidads=tipodiscapacidadDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDiscapacidad(tipodiscapacidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDiscapacidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoDiscapacidad(this.tipodiscapacidads);
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
		tipodiscapacidads = new  ArrayList<TipoDiscapacidad>();
		  		  
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
		tipodiscapacidads = new  ArrayList<TipoDiscapacidad>();
		  		  
        try {			
			TipoDiscapacidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodiscapacidads=tipodiscapacidadDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoDiscapacidad(tipodiscapacidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDiscapacidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoDiscapacidad(this.tipodiscapacidads);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipodiscapacidads = new  ArrayList<TipoDiscapacidad>();
		  		  
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
		tipodiscapacidads = new  ArrayList<TipoDiscapacidad>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDiscapacidad.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoDiscapacidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodiscapacidads=tipodiscapacidadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDiscapacidad(tipodiscapacidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDiscapacidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoDiscapacidad(this.tipodiscapacidads);
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
		tipodiscapacidads = new  ArrayList<TipoDiscapacidad>();
		  		  
        try {
			TipoDiscapacidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodiscapacidads=tipodiscapacidadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoDiscapacidad(tipodiscapacidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDiscapacidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoDiscapacidad(this.tipodiscapacidads);
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
		tipodiscapacidads = new  ArrayList<TipoDiscapacidad>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDiscapacidad.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDiscapacidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodiscapacidads=tipodiscapacidadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDiscapacidad(tipodiscapacidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDiscapacidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoDiscapacidad(this.tipodiscapacidads);
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
		tipodiscapacidads = new  ArrayList<TipoDiscapacidad>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDiscapacidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodiscapacidads=tipodiscapacidadDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDiscapacidad(tipodiscapacidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDiscapacidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoDiscapacidad(this.tipodiscapacidads);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipodiscapacidad = new  TipoDiscapacidad();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDiscapacidad.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDiscapacidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodiscapacidad=tipodiscapacidadDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDiscapacidad(tipodiscapacidad);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDiscapacidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoDiscapacidad(this.tipodiscapacidad);
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
		tipodiscapacidad = new  TipoDiscapacidad();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDiscapacidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodiscapacidad=tipodiscapacidadDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoDiscapacidad(tipodiscapacidad);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDiscapacidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoDiscapacidad(this.tipodiscapacidad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoDiscapacidadsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipodiscapacidads = new  ArrayList<TipoDiscapacidad>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDiscapacidad.class.getSimpleName()+"-getTodosTipoDiscapacidadsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDiscapacidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodiscapacidads=tipodiscapacidadDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoDiscapacidad(tipodiscapacidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDiscapacidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoDiscapacidad(this.tipodiscapacidads);
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
	
	public  void  getTodosTipoDiscapacidads(String sFinalQuery,Pagination pagination)throws Exception {
		tipodiscapacidads = new  ArrayList<TipoDiscapacidad>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoDiscapacidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipodiscapacidads=tipodiscapacidadDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoDiscapacidad(tipodiscapacidads);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoDiscapacidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoDiscapacidad(this.tipodiscapacidads);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoDiscapacidad(TipoDiscapacidad tipodiscapacidad) throws Exception {
		Boolean estaValidado=false;
		
		if(tipodiscapacidad.getIsNew() || tipodiscapacidad.getIsChanged()) { 
			this.invalidValues = tipodiscapacidadValidator.getInvalidValues(tipodiscapacidad);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipodiscapacidad);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoDiscapacidad(List<TipoDiscapacidad> TipoDiscapacidads) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoDiscapacidad tipodiscapacidadLocal:tipodiscapacidads) {				
			estaValidadoObjeto=this.validarGuardarTipoDiscapacidad(tipodiscapacidadLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoDiscapacidad(List<TipoDiscapacidad> TipoDiscapacidads) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoDiscapacidad(tipodiscapacidads)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoDiscapacidad(TipoDiscapacidad TipoDiscapacidad) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoDiscapacidad(tipodiscapacidad)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoDiscapacidad tipodiscapacidad) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipodiscapacidad.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoDiscapacidadConstantesFunciones.getTipoDiscapacidadLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipodiscapacidad","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoDiscapacidadConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoDiscapacidadConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoDiscapacidadWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDiscapacidad.class.getSimpleName()+"-saveTipoDiscapacidadWithConnection");connexion.begin();			
			
			//TipoDiscapacidadLogicAdditional.checkTipoDiscapacidadToSave(this.tipodiscapacidad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoDiscapacidadLogicAdditional.updateTipoDiscapacidadToSave(this.tipodiscapacidad,this.arrDatoGeneral);
			
			TipoDiscapacidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipodiscapacidad,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoDiscapacidad();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoDiscapacidad(this.tipodiscapacidad)) {
				TipoDiscapacidadDataAccess.save(this.tipodiscapacidad, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipodiscapacidad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoDiscapacidadLogicAdditional.checkTipoDiscapacidadToSaveAfter(this.tipodiscapacidad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoDiscapacidad();
			
			connexion.commit();			
			
			if(this.tipodiscapacidad.getIsDeleted()) {
				this.tipodiscapacidad=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoDiscapacidad()throws Exception {	
		try {	
			
			//TipoDiscapacidadLogicAdditional.checkTipoDiscapacidadToSave(this.tipodiscapacidad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoDiscapacidadLogicAdditional.updateTipoDiscapacidadToSave(this.tipodiscapacidad,this.arrDatoGeneral);
			
			TipoDiscapacidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipodiscapacidad,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoDiscapacidad(this.tipodiscapacidad)) {			
				TipoDiscapacidadDataAccess.save(this.tipodiscapacidad, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipodiscapacidad,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoDiscapacidadLogicAdditional.checkTipoDiscapacidadToSaveAfter(this.tipodiscapacidad,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipodiscapacidad.getIsDeleted()) {
				this.tipodiscapacidad=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoDiscapacidadsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDiscapacidad.class.getSimpleName()+"-saveTipoDiscapacidadsWithConnection");connexion.begin();			
			
			//TipoDiscapacidadLogicAdditional.checkTipoDiscapacidadToSaves(tipodiscapacidads,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoDiscapacidads();
			
			Boolean validadoTodosTipoDiscapacidad=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoDiscapacidad tipodiscapacidadLocal:tipodiscapacidads) {		
				if(tipodiscapacidadLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoDiscapacidadLogicAdditional.updateTipoDiscapacidadToSave(tipodiscapacidadLocal,this.arrDatoGeneral);
	        	
				TipoDiscapacidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipodiscapacidadLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoDiscapacidad(tipodiscapacidadLocal)) {
					TipoDiscapacidadDataAccess.save(tipodiscapacidadLocal, connexion);				
				} else {
					validadoTodosTipoDiscapacidad=false;
				}
			}
			
			if(!validadoTodosTipoDiscapacidad) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoDiscapacidadLogicAdditional.checkTipoDiscapacidadToSavesAfter(tipodiscapacidads,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoDiscapacidads();
			
			connexion.commit();		
			
			this.quitarTipoDiscapacidadsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoDiscapacidads()throws Exception {				
		 try {	
			//TipoDiscapacidadLogicAdditional.checkTipoDiscapacidadToSaves(tipodiscapacidads,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoDiscapacidad=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoDiscapacidad tipodiscapacidadLocal:tipodiscapacidads) {				
				if(tipodiscapacidadLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoDiscapacidadLogicAdditional.updateTipoDiscapacidadToSave(tipodiscapacidadLocal,this.arrDatoGeneral);
	        	
				TipoDiscapacidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipodiscapacidadLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoDiscapacidad(tipodiscapacidadLocal)) {				
					TipoDiscapacidadDataAccess.save(tipodiscapacidadLocal, connexion);				
				} else {
					validadoTodosTipoDiscapacidad=false;
				}
			}
			
			if(!validadoTodosTipoDiscapacidad) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoDiscapacidadLogicAdditional.checkTipoDiscapacidadToSavesAfter(tipodiscapacidads,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoDiscapacidadsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoDiscapacidadParameterReturnGeneral procesarAccionTipoDiscapacidads(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoDiscapacidad> tipodiscapacidads,TipoDiscapacidadParameterReturnGeneral tipodiscapacidadParameterGeneral)throws Exception {
		 try {	
			TipoDiscapacidadParameterReturnGeneral tipodiscapacidadReturnGeneral=new TipoDiscapacidadParameterReturnGeneral();
	
			
			return tipodiscapacidadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoDiscapacidadParameterReturnGeneral procesarAccionTipoDiscapacidadsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoDiscapacidad> tipodiscapacidads,TipoDiscapacidadParameterReturnGeneral tipodiscapacidadParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDiscapacidad.class.getSimpleName()+"-procesarAccionTipoDiscapacidadsWithConnection");connexion.begin();			
			
			TipoDiscapacidadParameterReturnGeneral tipodiscapacidadReturnGeneral=new TipoDiscapacidadParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipodiscapacidadReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoDiscapacidadParameterReturnGeneral procesarEventosTipoDiscapacidads(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoDiscapacidad> tipodiscapacidads,TipoDiscapacidad tipodiscapacidad,TipoDiscapacidadParameterReturnGeneral tipodiscapacidadParameterGeneral,Boolean isEsNuevoTipoDiscapacidad,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoDiscapacidadParameterReturnGeneral tipodiscapacidadReturnGeneral=new TipoDiscapacidadParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipodiscapacidadReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipodiscapacidadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoDiscapacidadParameterReturnGeneral procesarEventosTipoDiscapacidadsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoDiscapacidad> tipodiscapacidads,TipoDiscapacidad tipodiscapacidad,TipoDiscapacidadParameterReturnGeneral tipodiscapacidadParameterGeneral,Boolean isEsNuevoTipoDiscapacidad,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDiscapacidad.class.getSimpleName()+"-procesarEventosTipoDiscapacidadsWithConnection");connexion.begin();			
			
			TipoDiscapacidadParameterReturnGeneral tipodiscapacidadReturnGeneral=new TipoDiscapacidadParameterReturnGeneral();
	
			tipodiscapacidadReturnGeneral.setTipoDiscapacidad(tipodiscapacidad);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipodiscapacidadReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipodiscapacidadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoDiscapacidadParameterReturnGeneral procesarImportacionTipoDiscapacidadsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoDiscapacidadParameterReturnGeneral tipodiscapacidadParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDiscapacidad.class.getSimpleName()+"-procesarImportacionTipoDiscapacidadsWithConnection");connexion.begin();			
			
			TipoDiscapacidadParameterReturnGeneral tipodiscapacidadReturnGeneral=new TipoDiscapacidadParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipodiscapacidads=new ArrayList<TipoDiscapacidad>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipodiscapacidad=new TipoDiscapacidad();
				
				
				if(conColumnasBase) {this.tipodiscapacidad.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipodiscapacidad.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipodiscapacidad.setnombre(arrColumnas[iColumn++]);
				this.tipodiscapacidad.setporcentaje_inicial(Double.parseDouble(arrColumnas[iColumn++]));
				this.tipodiscapacidad.setporcentaje_final(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.tipodiscapacidads.add(this.tipodiscapacidad);
			}
			
			this.saveTipoDiscapacidads();
			
			this.connexion.commit();
			
			tipodiscapacidadReturnGeneral.setConRetornoEstaProcesado(true);
			tipodiscapacidadReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipodiscapacidadReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoDiscapacidadsEliminados() throws Exception {				
		
		List<TipoDiscapacidad> tipodiscapacidadsAux= new ArrayList<TipoDiscapacidad>();
		
		for(TipoDiscapacidad tipodiscapacidad:tipodiscapacidads) {
			if(!tipodiscapacidad.getIsDeleted()) {
				tipodiscapacidadsAux.add(tipodiscapacidad);
			}
		}
		
		tipodiscapacidads=tipodiscapacidadsAux;
	}
	
	public void quitarTipoDiscapacidadsNulos() throws Exception {				
		
		List<TipoDiscapacidad> tipodiscapacidadsAux= new ArrayList<TipoDiscapacidad>();
		
		for(TipoDiscapacidad tipodiscapacidad : this.tipodiscapacidads) {
			if(tipodiscapacidad==null) {
				tipodiscapacidadsAux.add(tipodiscapacidad);
			}
		}
		
		//this.tipodiscapacidads=tipodiscapacidadsAux;
		
		this.tipodiscapacidads.removeAll(tipodiscapacidadsAux);
	}
	
	public void getSetVersionRowTipoDiscapacidadWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipodiscapacidad.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipodiscapacidad.getIsDeleted() || (tipodiscapacidad.getIsChanged()&&!tipodiscapacidad.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipodiscapacidadDataAccess.getSetVersionRowTipoDiscapacidad(connexion,tipodiscapacidad.getId());
				
				if(!tipodiscapacidad.getVersionRow().equals(timestamp)) {	
					tipodiscapacidad.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipodiscapacidad.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoDiscapacidad()throws Exception {	
		
		if(tipodiscapacidad.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipodiscapacidad.getIsDeleted() || (tipodiscapacidad.getIsChanged()&&!tipodiscapacidad.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipodiscapacidadDataAccess.getSetVersionRowTipoDiscapacidad(connexion,tipodiscapacidad.getId());
			
			try {							
				if(!tipodiscapacidad.getVersionRow().equals(timestamp)) {	
					tipodiscapacidad.setVersionRow(timestamp);
				}
				
				tipodiscapacidad.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoDiscapacidadsWithConnection()throws Exception {	
		if(tipodiscapacidads!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoDiscapacidad tipodiscapacidadAux:tipodiscapacidads) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipodiscapacidadAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipodiscapacidadAux.getIsDeleted() || (tipodiscapacidadAux.getIsChanged()&&!tipodiscapacidadAux.getIsNew())) {
						
						timestamp=tipodiscapacidadDataAccess.getSetVersionRowTipoDiscapacidad(connexion,tipodiscapacidadAux.getId());
						
						if(!tipodiscapacidad.getVersionRow().equals(timestamp)) {	
							tipodiscapacidadAux.setVersionRow(timestamp);
						}
								
						tipodiscapacidadAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoDiscapacidads()throws Exception {	
		if(tipodiscapacidads!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoDiscapacidad tipodiscapacidadAux:tipodiscapacidads) {
					if(tipodiscapacidadAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipodiscapacidadAux.getIsDeleted() || (tipodiscapacidadAux.getIsChanged()&&!tipodiscapacidadAux.getIsNew())) {
						
						timestamp=tipodiscapacidadDataAccess.getSetVersionRowTipoDiscapacidad(connexion,tipodiscapacidadAux.getId());
						
						if(!tipodiscapacidadAux.getVersionRow().equals(timestamp)) {	
							tipodiscapacidadAux.setVersionRow(timestamp);
						}
						
													
						tipodiscapacidadAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoDiscapacidadParameterReturnGeneral cargarCombosLoteForeignKeyTipoDiscapacidadWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoDiscapacidadParameterReturnGeneral  tipodiscapacidadReturnGeneral =new TipoDiscapacidadParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDiscapacidad.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoDiscapacidadWithConnection");connexion.begin();
			
			tipodiscapacidadReturnGeneral =new TipoDiscapacidadParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipodiscapacidadReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipodiscapacidadReturnGeneral;
	}
	
	public TipoDiscapacidadParameterReturnGeneral cargarCombosLoteForeignKeyTipoDiscapacidad(String finalQueryGlobalEmpresa) throws Exception {
		TipoDiscapacidadParameterReturnGeneral  tipodiscapacidadReturnGeneral =new TipoDiscapacidadParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipodiscapacidadReturnGeneral =new TipoDiscapacidadParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipodiscapacidadReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipodiscapacidadReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoDiscapacidadWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			EmpleadoDiscaLogic empleadodiscaLogic=new EmpleadoDiscaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDiscapacidad.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoDiscapacidadWithConnection");connexion.begin();
			
			
			classes.add(new Classe(EmpleadoDisca.class));
											
			

			empleadodiscaLogic.setConnexion(this.getConnexion());
			empleadodiscaLogic.setDatosCliente(this.datosCliente);
			empleadodiscaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoDiscapacidad tipodiscapacidad:this.tipodiscapacidads) {
				

				classes=new ArrayList<Classe>();
				classes=EmpleadoDiscaConstantesFunciones.getClassesForeignKeysOfEmpleadoDisca(new ArrayList<Classe>(),DeepLoadType.NONE);

				empleadodiscaLogic.setEmpleadoDiscas(tipodiscapacidad.empleadodiscas);
				empleadodiscaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoDiscapacidad tipodiscapacidad,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoDiscapacidadLogicAdditional.updateTipoDiscapacidadToGet(tipodiscapacidad,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipodiscapacidad.setEmpresa(tipodiscapacidadDataAccess.getEmpresa(connexion,tipodiscapacidad));
		tipodiscapacidad.setEmpleadoDiscas(tipodiscapacidadDataAccess.getEmpleadoDiscas(connexion,tipodiscapacidad));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipodiscapacidad.setEmpresa(tipodiscapacidadDataAccess.getEmpresa(connexion,tipodiscapacidad));
				continue;
			}

			if(clas.clas.equals(EmpleadoDisca.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipodiscapacidad.setEmpleadoDiscas(tipodiscapacidadDataAccess.getEmpleadoDiscas(connexion,tipodiscapacidad));

				if(this.isConDeep) {
					EmpleadoDiscaLogic empleadodiscaLogic= new EmpleadoDiscaLogic(this.connexion);
					empleadodiscaLogic.setEmpleadoDiscas(tipodiscapacidad.getEmpleadoDiscas());
					ArrayList<Classe> classesLocal=EmpleadoDiscaConstantesFunciones.getClassesForeignKeysOfEmpleadoDisca(new ArrayList<Classe>(),DeepLoadType.NONE);
					empleadodiscaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					EmpleadoDiscaConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoDisca(empleadodiscaLogic.getEmpleadoDiscas());
					tipodiscapacidad.setEmpleadoDiscas(empleadodiscaLogic.getEmpleadoDiscas());
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
			tipodiscapacidad.setEmpresa(tipodiscapacidadDataAccess.getEmpresa(connexion,tipodiscapacidad));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoDisca.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EmpleadoDisca.class));
			tipodiscapacidad.setEmpleadoDiscas(tipodiscapacidadDataAccess.getEmpleadoDiscas(connexion,tipodiscapacidad));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipodiscapacidad.setEmpresa(tipodiscapacidadDataAccess.getEmpresa(connexion,tipodiscapacidad));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipodiscapacidad.getEmpresa(),isDeep,deepLoadType,clases);
				

		tipodiscapacidad.setEmpleadoDiscas(tipodiscapacidadDataAccess.getEmpleadoDiscas(connexion,tipodiscapacidad));

		for(EmpleadoDisca empleadodisca:tipodiscapacidad.getEmpleadoDiscas()) {
			EmpleadoDiscaLogic empleadodiscaLogic= new EmpleadoDiscaLogic(connexion);
			empleadodiscaLogic.deepLoad(empleadodisca,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipodiscapacidad.setEmpresa(tipodiscapacidadDataAccess.getEmpresa(connexion,tipodiscapacidad));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipodiscapacidad.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EmpleadoDisca.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipodiscapacidad.setEmpleadoDiscas(tipodiscapacidadDataAccess.getEmpleadoDiscas(connexion,tipodiscapacidad));

				for(EmpleadoDisca empleadodisca:tipodiscapacidad.getEmpleadoDiscas()) {
					EmpleadoDiscaLogic empleadodiscaLogic= new EmpleadoDiscaLogic(connexion);
					empleadodiscaLogic.deepLoad(empleadodisca,isDeep,deepLoadType,clases);
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
			tipodiscapacidad.setEmpresa(tipodiscapacidadDataAccess.getEmpresa(connexion,tipodiscapacidad));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipodiscapacidad.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoDisca.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EmpleadoDisca.class));
			tipodiscapacidad.setEmpleadoDiscas(tipodiscapacidadDataAccess.getEmpleadoDiscas(connexion,tipodiscapacidad));

			for(EmpleadoDisca empleadodisca:tipodiscapacidad.getEmpleadoDiscas()) {
				EmpleadoDiscaLogic empleadodiscaLogic= new EmpleadoDiscaLogic(connexion);
				empleadodiscaLogic.deepLoad(empleadodisca,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoDiscapacidad tipodiscapacidad,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoDiscapacidad.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipodiscapacidad,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoDiscapacidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoDiscapacidad(tipodiscapacidad);
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
			this.deepLoad(this.tipodiscapacidad,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoDiscapacidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoDiscapacidad(this.tipodiscapacidad);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoDiscapacidad.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipodiscapacidads!=null) {
				for(TipoDiscapacidad tipodiscapacidad:tipodiscapacidads) {
					this.deepLoad(tipodiscapacidad,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoDiscapacidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoDiscapacidad(tipodiscapacidads);
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
			if(tipodiscapacidads!=null) {
				for(TipoDiscapacidad tipodiscapacidad:tipodiscapacidads) {
					this.deepLoad(tipodiscapacidad,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoDiscapacidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoDiscapacidad(tipodiscapacidads);
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
	
	
	public void getTipoDiscapacidadsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoDiscapacidad.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoDiscapacidadConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoDiscapacidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodiscapacidads=tipodiscapacidadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDiscapacidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoDiscapacidad(this.tipodiscapacidads);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoDiscapacidadsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoDiscapacidadConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoDiscapacidadLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipodiscapacidads=tipodiscapacidadDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoDiscapacidadConstantesFunciones.refrescarForeignKeysDescripcionesTipoDiscapacidad(this.tipodiscapacidads);
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
			if(TipoDiscapacidadConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDiscapacidadDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoDiscapacidad tipodiscapacidad,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoDiscapacidadConstantesFunciones.ISCONAUDITORIA) {
				if(tipodiscapacidad.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDiscapacidadDataAccess.TABLENAME, tipodiscapacidad.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoDiscapacidadConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoDiscapacidadLogic.registrarAuditoriaDetallesTipoDiscapacidad(connexion,tipodiscapacidad,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipodiscapacidad.getIsDeleted()) {
					/*if(!tipodiscapacidad.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoDiscapacidadDataAccess.TABLENAME, tipodiscapacidad.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoDiscapacidadLogic.registrarAuditoriaDetallesTipoDiscapacidad(connexion,tipodiscapacidad,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDiscapacidadDataAccess.TABLENAME, tipodiscapacidad.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipodiscapacidad.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoDiscapacidadDataAccess.TABLENAME, tipodiscapacidad.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoDiscapacidadConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoDiscapacidadLogic.registrarAuditoriaDetallesTipoDiscapacidad(connexion,tipodiscapacidad,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoDiscapacidad(Connexion connexion,TipoDiscapacidad tipodiscapacidad)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipodiscapacidad.getIsNew()||!tipodiscapacidad.getid_empresa().equals(tipodiscapacidad.getTipoDiscapacidadOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodiscapacidad.getTipoDiscapacidadOriginal().getid_empresa()!=null)
				{
					strValorActual=tipodiscapacidad.getTipoDiscapacidadOriginal().getid_empresa().toString();
				}
				if(tipodiscapacidad.getid_empresa()!=null)
				{
					strValorNuevo=tipodiscapacidad.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDiscapacidadConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipodiscapacidad.getIsNew()||!tipodiscapacidad.getnombre().equals(tipodiscapacidad.getTipoDiscapacidadOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodiscapacidad.getTipoDiscapacidadOriginal().getnombre()!=null)
				{
					strValorActual=tipodiscapacidad.getTipoDiscapacidadOriginal().getnombre();
				}
				if(tipodiscapacidad.getnombre()!=null)
				{
					strValorNuevo=tipodiscapacidad.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDiscapacidadConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(tipodiscapacidad.getIsNew()||!tipodiscapacidad.getporcentaje_inicial().equals(tipodiscapacidad.getTipoDiscapacidadOriginal().getporcentaje_inicial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodiscapacidad.getTipoDiscapacidadOriginal().getporcentaje_inicial()!=null)
				{
					strValorActual=tipodiscapacidad.getTipoDiscapacidadOriginal().getporcentaje_inicial().toString();
				}
				if(tipodiscapacidad.getporcentaje_inicial()!=null)
				{
					strValorNuevo=tipodiscapacidad.getporcentaje_inicial().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDiscapacidadConstantesFunciones.PORCENTAJEINICIAL,strValorActual,strValorNuevo);
			}	
			
			if(tipodiscapacidad.getIsNew()||!tipodiscapacidad.getporcentaje_final().equals(tipodiscapacidad.getTipoDiscapacidadOriginal().getporcentaje_final()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipodiscapacidad.getTipoDiscapacidadOriginal().getporcentaje_final()!=null)
				{
					strValorActual=tipodiscapacidad.getTipoDiscapacidadOriginal().getporcentaje_final().toString();
				}
				if(tipodiscapacidad.getporcentaje_final()!=null)
				{
					strValorNuevo=tipodiscapacidad.getporcentaje_final().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoDiscapacidadConstantesFunciones.PORCENTAJEFINAL,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoDiscapacidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoDiscapacidadConstantesFunciones.getClassesForeignKeysOfTipoDiscapacidad(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDiscapacidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoDiscapacidadConstantesFunciones.getClassesRelationshipsOfTipoDiscapacidad(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

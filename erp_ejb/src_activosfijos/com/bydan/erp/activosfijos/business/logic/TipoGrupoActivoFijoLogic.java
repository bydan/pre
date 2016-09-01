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
package com.bydan.erp.activosfijos.business.logic;

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
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.activosfijos.util.TipoGrupoActivoFijoConstantesFunciones;
import com.bydan.erp.activosfijos.util.TipoGrupoActivoFijoParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.TipoGrupoActivoFijoParameterGeneral;
import com.bydan.erp.activosfijos.business.entity.TipoGrupoActivoFijo;
//import com.bydan.erp.activosfijos.business.logic.TipoGrupoActivoFijoLogicAdditional;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoGrupoActivoFijoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoGrupoActivoFijoLogic.class);
	
	protected TipoGrupoActivoFijoDataAccess tipogrupoactivofijoDataAccess; 	
	protected TipoGrupoActivoFijo tipogrupoactivofijo;
	protected List<TipoGrupoActivoFijo> tipogrupoactivofijos;
	protected Object tipogrupoactivofijoObject;	
	protected List<Object> tipogrupoactivofijosObject;
	
	public static ClassValidator<TipoGrupoActivoFijo> tipogrupoactivofijoValidator = new ClassValidator<TipoGrupoActivoFijo>(TipoGrupoActivoFijo.class);	
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
	
	
	
	
	public  TipoGrupoActivoFijoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipogrupoactivofijoDataAccess = new TipoGrupoActivoFijoDataAccess();
			
			this.tipogrupoactivofijos= new ArrayList<TipoGrupoActivoFijo>();
			this.tipogrupoactivofijo= new TipoGrupoActivoFijo();
			
			this.tipogrupoactivofijoObject=new Object();
			this.tipogrupoactivofijosObject=new ArrayList<Object>();
				
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
			
			this.tipogrupoactivofijoDataAccess.setConnexionType(this.connexionType);
			this.tipogrupoactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoGrupoActivoFijoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipogrupoactivofijoDataAccess = new TipoGrupoActivoFijoDataAccess();
			this.tipogrupoactivofijos= new ArrayList<TipoGrupoActivoFijo>();
			this.tipogrupoactivofijo= new TipoGrupoActivoFijo();
			this.tipogrupoactivofijoObject=new Object();
			this.tipogrupoactivofijosObject=new ArrayList<Object>();
			
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
			
			this.tipogrupoactivofijoDataAccess.setConnexionType(this.connexionType);
			this.tipogrupoactivofijoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoGrupoActivoFijo getTipoGrupoActivoFijo() throws Exception {	
		//TipoGrupoActivoFijoLogicAdditional.checkTipoGrupoActivoFijoToGet(tipogrupoactivofijo,this.datosCliente,this.arrDatoGeneral);
		//TipoGrupoActivoFijoLogicAdditional.updateTipoGrupoActivoFijoToGet(tipogrupoactivofijo,this.arrDatoGeneral);
		
		return tipogrupoactivofijo;
	}
		
	public void setTipoGrupoActivoFijo(TipoGrupoActivoFijo newTipoGrupoActivoFijo) {
		this.tipogrupoactivofijo = newTipoGrupoActivoFijo;
	}
	
	public TipoGrupoActivoFijoDataAccess getTipoGrupoActivoFijoDataAccess() {
		return tipogrupoactivofijoDataAccess;
	}
	
	public void setTipoGrupoActivoFijoDataAccess(TipoGrupoActivoFijoDataAccess newtipogrupoactivofijoDataAccess) {
		this.tipogrupoactivofijoDataAccess = newtipogrupoactivofijoDataAccess;
	}
	
	public List<TipoGrupoActivoFijo> getTipoGrupoActivoFijos() throws Exception {		
		this.quitarTipoGrupoActivoFijosNulos();
		
		//TipoGrupoActivoFijoLogicAdditional.checkTipoGrupoActivoFijoToGets(tipogrupoactivofijos,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoGrupoActivoFijo tipogrupoactivofijoLocal: tipogrupoactivofijos ) {
			//TipoGrupoActivoFijoLogicAdditional.updateTipoGrupoActivoFijoToGet(tipogrupoactivofijoLocal,this.arrDatoGeneral);
		}
		
		return tipogrupoactivofijos;
	}
	
	public void setTipoGrupoActivoFijos(List<TipoGrupoActivoFijo> newTipoGrupoActivoFijos) {
		this.tipogrupoactivofijos = newTipoGrupoActivoFijos;
	}
	
	public Object getTipoGrupoActivoFijoObject() {	
		this.tipogrupoactivofijoObject=this.tipogrupoactivofijoDataAccess.getEntityObject();
		return this.tipogrupoactivofijoObject;
	}
		
	public void setTipoGrupoActivoFijoObject(Object newTipoGrupoActivoFijoObject) {
		this.tipogrupoactivofijoObject = newTipoGrupoActivoFijoObject;
	}
	
	public List<Object> getTipoGrupoActivoFijosObject() {		
		this.tipogrupoactivofijosObject=this.tipogrupoactivofijoDataAccess.getEntitiesObject();
		return this.tipogrupoactivofijosObject;
	}
		
	public void setTipoGrupoActivoFijosObject(List<Object> newTipoGrupoActivoFijosObject) {
		this.tipogrupoactivofijosObject = newTipoGrupoActivoFijosObject;
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
		
		if(this.tipogrupoactivofijoDataAccess!=null) {
			this.tipogrupoactivofijoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoActivoFijo.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipogrupoactivofijoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipogrupoactivofijoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipogrupoactivofijo = new  TipoGrupoActivoFijo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoActivoFijo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipogrupoactivofijo=tipogrupoactivofijoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipogrupoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoActivoFijo(this.tipogrupoactivofijo);
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
		tipogrupoactivofijo = new  TipoGrupoActivoFijo();
		  		  
        try {
			
			tipogrupoactivofijo=tipogrupoactivofijoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipogrupoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoActivoFijo(this.tipogrupoactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipogrupoactivofijo = new  TipoGrupoActivoFijo();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoActivoFijo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipogrupoactivofijo=tipogrupoactivofijoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipogrupoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoActivoFijo(this.tipogrupoactivofijo);
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
		tipogrupoactivofijo = new  TipoGrupoActivoFijo();
		  		  
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
		tipogrupoactivofijo = new  TipoGrupoActivoFijo();
		  		  
        try {
			
			tipogrupoactivofijo=tipogrupoactivofijoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipogrupoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoActivoFijo(this.tipogrupoactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipogrupoactivofijo = new  TipoGrupoActivoFijo();
		  		  
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
		tipogrupoactivofijo = new  TipoGrupoActivoFijo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoActivoFijo.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipogrupoactivofijoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipogrupoactivofijo = new  TipoGrupoActivoFijo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipogrupoactivofijoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipogrupoactivofijo = new  TipoGrupoActivoFijo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoActivoFijo.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipogrupoactivofijoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipogrupoactivofijo = new  TipoGrupoActivoFijo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipogrupoactivofijoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipogrupoactivofijo = new  TipoGrupoActivoFijo();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoActivoFijo.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipogrupoactivofijoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipogrupoactivofijo = new  TipoGrupoActivoFijo();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipogrupoactivofijoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipogrupoactivofijos = new  ArrayList<TipoGrupoActivoFijo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoActivoFijo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogrupoactivofijos=tipogrupoactivofijoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoGrupoActivoFijo(tipogrupoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoActivoFijo(this.tipogrupoactivofijos);
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
		tipogrupoactivofijos = new  ArrayList<TipoGrupoActivoFijo>();
		  		  
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
		tipogrupoactivofijos = new  ArrayList<TipoGrupoActivoFijo>();
		  		  
        try {			
			TipoGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogrupoactivofijos=tipogrupoactivofijoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoGrupoActivoFijo(tipogrupoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoActivoFijo(this.tipogrupoactivofijos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipogrupoactivofijos = new  ArrayList<TipoGrupoActivoFijo>();
		  		  
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
		tipogrupoactivofijos = new  ArrayList<TipoGrupoActivoFijo>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoActivoFijo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogrupoactivofijos=tipogrupoactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoGrupoActivoFijo(tipogrupoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoActivoFijo(this.tipogrupoactivofijos);
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
		tipogrupoactivofijos = new  ArrayList<TipoGrupoActivoFijo>();
		  		  
        try {
			TipoGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogrupoactivofijos=tipogrupoactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoGrupoActivoFijo(tipogrupoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoActivoFijo(this.tipogrupoactivofijos);
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
		tipogrupoactivofijos = new  ArrayList<TipoGrupoActivoFijo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoActivoFijo.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogrupoactivofijos=tipogrupoactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoGrupoActivoFijo(tipogrupoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoActivoFijo(this.tipogrupoactivofijos);
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
		tipogrupoactivofijos = new  ArrayList<TipoGrupoActivoFijo>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogrupoactivofijos=tipogrupoactivofijoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoGrupoActivoFijo(tipogrupoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoActivoFijo(this.tipogrupoactivofijos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipogrupoactivofijo = new  TipoGrupoActivoFijo();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoActivoFijo.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogrupoactivofijo=tipogrupoactivofijoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoGrupoActivoFijo(tipogrupoactivofijo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoActivoFijo(this.tipogrupoactivofijo);
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
		tipogrupoactivofijo = new  TipoGrupoActivoFijo();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogrupoactivofijo=tipogrupoactivofijoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoGrupoActivoFijo(tipogrupoactivofijo);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoActivoFijo(this.tipogrupoactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoGrupoActivoFijosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipogrupoactivofijos = new  ArrayList<TipoGrupoActivoFijo>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoActivoFijo.class.getSimpleName()+"-getTodosTipoGrupoActivoFijosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogrupoactivofijos=tipogrupoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoGrupoActivoFijo(tipogrupoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoActivoFijo(this.tipogrupoactivofijos);
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
	
	public  void  getTodosTipoGrupoActivoFijos(String sFinalQuery,Pagination pagination)throws Exception {
		tipogrupoactivofijos = new  ArrayList<TipoGrupoActivoFijo>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipogrupoactivofijos=tipogrupoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoGrupoActivoFijo(tipogrupoactivofijos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoActivoFijo(this.tipogrupoactivofijos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoGrupoActivoFijo(TipoGrupoActivoFijo tipogrupoactivofijo) throws Exception {
		Boolean estaValidado=false;
		
		if(tipogrupoactivofijo.getIsNew() || tipogrupoactivofijo.getIsChanged()) { 
			this.invalidValues = tipogrupoactivofijoValidator.getInvalidValues(tipogrupoactivofijo);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipogrupoactivofijo);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoGrupoActivoFijo(List<TipoGrupoActivoFijo> TipoGrupoActivoFijos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoGrupoActivoFijo tipogrupoactivofijoLocal:tipogrupoactivofijos) {				
			estaValidadoObjeto=this.validarGuardarTipoGrupoActivoFijo(tipogrupoactivofijoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoGrupoActivoFijo(List<TipoGrupoActivoFijo> TipoGrupoActivoFijos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoGrupoActivoFijo(tipogrupoactivofijos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoGrupoActivoFijo(TipoGrupoActivoFijo TipoGrupoActivoFijo) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoGrupoActivoFijo(tipogrupoactivofijo)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoGrupoActivoFijo tipogrupoactivofijo) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipogrupoactivofijo.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoGrupoActivoFijoConstantesFunciones.getTipoGrupoActivoFijoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipogrupoactivofijo","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoGrupoActivoFijoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoGrupoActivoFijoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoGrupoActivoFijoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoActivoFijo.class.getSimpleName()+"-saveTipoGrupoActivoFijoWithConnection");connexion.begin();			
			
			//TipoGrupoActivoFijoLogicAdditional.checkTipoGrupoActivoFijoToSave(this.tipogrupoactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoGrupoActivoFijoLogicAdditional.updateTipoGrupoActivoFijoToSave(this.tipogrupoactivofijo,this.arrDatoGeneral);
			
			TipoGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipogrupoactivofijo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoGrupoActivoFijo();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoGrupoActivoFijo(this.tipogrupoactivofijo)) {
				TipoGrupoActivoFijoDataAccess.save(this.tipogrupoactivofijo, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipogrupoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoGrupoActivoFijoLogicAdditional.checkTipoGrupoActivoFijoToSaveAfter(this.tipogrupoactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoGrupoActivoFijo();
			
			connexion.commit();			
			
			if(this.tipogrupoactivofijo.getIsDeleted()) {
				this.tipogrupoactivofijo=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoGrupoActivoFijo()throws Exception {	
		try {	
			
			//TipoGrupoActivoFijoLogicAdditional.checkTipoGrupoActivoFijoToSave(this.tipogrupoactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoGrupoActivoFijoLogicAdditional.updateTipoGrupoActivoFijoToSave(this.tipogrupoactivofijo,this.arrDatoGeneral);
			
			TipoGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipogrupoactivofijo,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoGrupoActivoFijo(this.tipogrupoactivofijo)) {			
				TipoGrupoActivoFijoDataAccess.save(this.tipogrupoactivofijo, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipogrupoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoGrupoActivoFijoLogicAdditional.checkTipoGrupoActivoFijoToSaveAfter(this.tipogrupoactivofijo,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipogrupoactivofijo.getIsDeleted()) {
				this.tipogrupoactivofijo=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoGrupoActivoFijosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoActivoFijo.class.getSimpleName()+"-saveTipoGrupoActivoFijosWithConnection");connexion.begin();			
			
			//TipoGrupoActivoFijoLogicAdditional.checkTipoGrupoActivoFijoToSaves(tipogrupoactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoGrupoActivoFijos();
			
			Boolean validadoTodosTipoGrupoActivoFijo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoGrupoActivoFijo tipogrupoactivofijoLocal:tipogrupoactivofijos) {		
				if(tipogrupoactivofijoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoGrupoActivoFijoLogicAdditional.updateTipoGrupoActivoFijoToSave(tipogrupoactivofijoLocal,this.arrDatoGeneral);
	        	
				TipoGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipogrupoactivofijoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoGrupoActivoFijo(tipogrupoactivofijoLocal)) {
					TipoGrupoActivoFijoDataAccess.save(tipogrupoactivofijoLocal, connexion);				
				} else {
					validadoTodosTipoGrupoActivoFijo=false;
				}
			}
			
			if(!validadoTodosTipoGrupoActivoFijo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoGrupoActivoFijoLogicAdditional.checkTipoGrupoActivoFijoToSavesAfter(tipogrupoactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoGrupoActivoFijos();
			
			connexion.commit();		
			
			this.quitarTipoGrupoActivoFijosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoGrupoActivoFijos()throws Exception {				
		 try {	
			//TipoGrupoActivoFijoLogicAdditional.checkTipoGrupoActivoFijoToSaves(tipogrupoactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoGrupoActivoFijo=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoGrupoActivoFijo tipogrupoactivofijoLocal:tipogrupoactivofijos) {				
				if(tipogrupoactivofijoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoGrupoActivoFijoLogicAdditional.updateTipoGrupoActivoFijoToSave(tipogrupoactivofijoLocal,this.arrDatoGeneral);
	        	
				TipoGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipogrupoactivofijoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoGrupoActivoFijo(tipogrupoactivofijoLocal)) {				
					TipoGrupoActivoFijoDataAccess.save(tipogrupoactivofijoLocal, connexion);				
				} else {
					validadoTodosTipoGrupoActivoFijo=false;
				}
			}
			
			if(!validadoTodosTipoGrupoActivoFijo) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoGrupoActivoFijoLogicAdditional.checkTipoGrupoActivoFijoToSavesAfter(tipogrupoactivofijos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoGrupoActivoFijosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoGrupoActivoFijoParameterReturnGeneral procesarAccionTipoGrupoActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoGrupoActivoFijo> tipogrupoactivofijos,TipoGrupoActivoFijoParameterReturnGeneral tipogrupoactivofijoParameterGeneral)throws Exception {
		 try {	
			TipoGrupoActivoFijoParameterReturnGeneral tipogrupoactivofijoReturnGeneral=new TipoGrupoActivoFijoParameterReturnGeneral();
	
			
			return tipogrupoactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoGrupoActivoFijoParameterReturnGeneral procesarAccionTipoGrupoActivoFijosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoGrupoActivoFijo> tipogrupoactivofijos,TipoGrupoActivoFijoParameterReturnGeneral tipogrupoactivofijoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoActivoFijo.class.getSimpleName()+"-procesarAccionTipoGrupoActivoFijosWithConnection");connexion.begin();			
			
			TipoGrupoActivoFijoParameterReturnGeneral tipogrupoactivofijoReturnGeneral=new TipoGrupoActivoFijoParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipogrupoactivofijoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoGrupoActivoFijoParameterReturnGeneral procesarEventosTipoGrupoActivoFijos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoGrupoActivoFijo> tipogrupoactivofijos,TipoGrupoActivoFijo tipogrupoactivofijo,TipoGrupoActivoFijoParameterReturnGeneral tipogrupoactivofijoParameterGeneral,Boolean isEsNuevoTipoGrupoActivoFijo,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoGrupoActivoFijoParameterReturnGeneral tipogrupoactivofijoReturnGeneral=new TipoGrupoActivoFijoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipogrupoactivofijoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipogrupoactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoGrupoActivoFijoParameterReturnGeneral procesarEventosTipoGrupoActivoFijosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoGrupoActivoFijo> tipogrupoactivofijos,TipoGrupoActivoFijo tipogrupoactivofijo,TipoGrupoActivoFijoParameterReturnGeneral tipogrupoactivofijoParameterGeneral,Boolean isEsNuevoTipoGrupoActivoFijo,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoActivoFijo.class.getSimpleName()+"-procesarEventosTipoGrupoActivoFijosWithConnection");connexion.begin();			
			
			TipoGrupoActivoFijoParameterReturnGeneral tipogrupoactivofijoReturnGeneral=new TipoGrupoActivoFijoParameterReturnGeneral();
	
			tipogrupoactivofijoReturnGeneral.setTipoGrupoActivoFijo(tipogrupoactivofijo);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipogrupoactivofijoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipogrupoactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoGrupoActivoFijoParameterReturnGeneral procesarImportacionTipoGrupoActivoFijosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoGrupoActivoFijoParameterReturnGeneral tipogrupoactivofijoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoActivoFijo.class.getSimpleName()+"-procesarImportacionTipoGrupoActivoFijosWithConnection");connexion.begin();			
			
			TipoGrupoActivoFijoParameterReturnGeneral tipogrupoactivofijoReturnGeneral=new TipoGrupoActivoFijoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipogrupoactivofijos=new ArrayList<TipoGrupoActivoFijo>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipogrupoactivofijo=new TipoGrupoActivoFijo();
				
				
				if(conColumnasBase) {this.tipogrupoactivofijo.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipogrupoactivofijo.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipogrupoactivofijo.setnombre(arrColumnas[iColumn++]);
				
				this.tipogrupoactivofijos.add(this.tipogrupoactivofijo);
			}
			
			this.saveTipoGrupoActivoFijos();
			
			this.connexion.commit();
			
			tipogrupoactivofijoReturnGeneral.setConRetornoEstaProcesado(true);
			tipogrupoactivofijoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipogrupoactivofijoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoGrupoActivoFijosEliminados() throws Exception {				
		
		List<TipoGrupoActivoFijo> tipogrupoactivofijosAux= new ArrayList<TipoGrupoActivoFijo>();
		
		for(TipoGrupoActivoFijo tipogrupoactivofijo:tipogrupoactivofijos) {
			if(!tipogrupoactivofijo.getIsDeleted()) {
				tipogrupoactivofijosAux.add(tipogrupoactivofijo);
			}
		}
		
		tipogrupoactivofijos=tipogrupoactivofijosAux;
	}
	
	public void quitarTipoGrupoActivoFijosNulos() throws Exception {				
		
		List<TipoGrupoActivoFijo> tipogrupoactivofijosAux= new ArrayList<TipoGrupoActivoFijo>();
		
		for(TipoGrupoActivoFijo tipogrupoactivofijo : this.tipogrupoactivofijos) {
			if(tipogrupoactivofijo==null) {
				tipogrupoactivofijosAux.add(tipogrupoactivofijo);
			}
		}
		
		//this.tipogrupoactivofijos=tipogrupoactivofijosAux;
		
		this.tipogrupoactivofijos.removeAll(tipogrupoactivofijosAux);
	}
	
	public void getSetVersionRowTipoGrupoActivoFijoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipogrupoactivofijo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipogrupoactivofijo.getIsDeleted() || (tipogrupoactivofijo.getIsChanged()&&!tipogrupoactivofijo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipogrupoactivofijoDataAccess.getSetVersionRowTipoGrupoActivoFijo(connexion,tipogrupoactivofijo.getId());
				
				if(!tipogrupoactivofijo.getVersionRow().equals(timestamp)) {	
					tipogrupoactivofijo.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipogrupoactivofijo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoGrupoActivoFijo()throws Exception {	
		
		if(tipogrupoactivofijo.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipogrupoactivofijo.getIsDeleted() || (tipogrupoactivofijo.getIsChanged()&&!tipogrupoactivofijo.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipogrupoactivofijoDataAccess.getSetVersionRowTipoGrupoActivoFijo(connexion,tipogrupoactivofijo.getId());
			
			try {							
				if(!tipogrupoactivofijo.getVersionRow().equals(timestamp)) {	
					tipogrupoactivofijo.setVersionRow(timestamp);
				}
				
				tipogrupoactivofijo.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoGrupoActivoFijosWithConnection()throws Exception {	
		if(tipogrupoactivofijos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoGrupoActivoFijo tipogrupoactivofijoAux:tipogrupoactivofijos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipogrupoactivofijoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipogrupoactivofijoAux.getIsDeleted() || (tipogrupoactivofijoAux.getIsChanged()&&!tipogrupoactivofijoAux.getIsNew())) {
						
						timestamp=tipogrupoactivofijoDataAccess.getSetVersionRowTipoGrupoActivoFijo(connexion,tipogrupoactivofijoAux.getId());
						
						if(!tipogrupoactivofijo.getVersionRow().equals(timestamp)) {	
							tipogrupoactivofijoAux.setVersionRow(timestamp);
						}
								
						tipogrupoactivofijoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoGrupoActivoFijos()throws Exception {	
		if(tipogrupoactivofijos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoGrupoActivoFijo tipogrupoactivofijoAux:tipogrupoactivofijos) {
					if(tipogrupoactivofijoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipogrupoactivofijoAux.getIsDeleted() || (tipogrupoactivofijoAux.getIsChanged()&&!tipogrupoactivofijoAux.getIsNew())) {
						
						timestamp=tipogrupoactivofijoDataAccess.getSetVersionRowTipoGrupoActivoFijo(connexion,tipogrupoactivofijoAux.getId());
						
						if(!tipogrupoactivofijoAux.getVersionRow().equals(timestamp)) {	
							tipogrupoactivofijoAux.setVersionRow(timestamp);
						}
						
													
						tipogrupoactivofijoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoGrupoActivoFijoParameterReturnGeneral cargarCombosLoteForeignKeyTipoGrupoActivoFijoWithConnection(String finalQueryGlobalPais) throws Exception {
		TipoGrupoActivoFijoParameterReturnGeneral  tipogrupoactivofijoReturnGeneral =new TipoGrupoActivoFijoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoActivoFijo.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoGrupoActivoFijoWithConnection");connexion.begin();
			
			tipogrupoactivofijoReturnGeneral =new TipoGrupoActivoFijoParameterReturnGeneral();
			
			

			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			tipogrupoactivofijoReturnGeneral.setpaissForeignKey(paissForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipogrupoactivofijoReturnGeneral;
	}
	
	public TipoGrupoActivoFijoParameterReturnGeneral cargarCombosLoteForeignKeyTipoGrupoActivoFijo(String finalQueryGlobalPais) throws Exception {
		TipoGrupoActivoFijoParameterReturnGeneral  tipogrupoactivofijoReturnGeneral =new TipoGrupoActivoFijoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipogrupoactivofijoReturnGeneral =new TipoGrupoActivoFijoParameterReturnGeneral();
			
			

			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			tipogrupoactivofijoReturnGeneral.setpaissForeignKey(paissForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipogrupoactivofijoReturnGeneral;
	}
	
	
	public void deepLoad(TipoGrupoActivoFijo tipogrupoactivofijo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoGrupoActivoFijoLogicAdditional.updateTipoGrupoActivoFijoToGet(tipogrupoactivofijo,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipogrupoactivofijo.setPais(tipogrupoactivofijoDataAccess.getPais(connexion,tipogrupoactivofijo));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				tipogrupoactivofijo.setPais(tipogrupoactivofijoDataAccess.getPais(connexion,tipogrupoactivofijo));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipogrupoactivofijo.setPais(tipogrupoactivofijoDataAccess.getPais(connexion,tipogrupoactivofijo));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipogrupoactivofijo.setPais(tipogrupoactivofijoDataAccess.getPais(connexion,tipogrupoactivofijo));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(tipogrupoactivofijo.getPais(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				tipogrupoactivofijo.setPais(tipogrupoactivofijoDataAccess.getPais(connexion,tipogrupoactivofijo));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(tipogrupoactivofijo.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			tipogrupoactivofijo.setPais(tipogrupoactivofijoDataAccess.getPais(connexion,tipogrupoactivofijo));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(tipogrupoactivofijo.getPais(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoGrupoActivoFijo tipogrupoactivofijo,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoGrupoActivoFijo.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipogrupoactivofijo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoActivoFijo(tipogrupoactivofijo);
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
			this.deepLoad(this.tipogrupoactivofijo,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoActivoFijo(this.tipogrupoactivofijo);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoGrupoActivoFijo.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipogrupoactivofijos!=null) {
				for(TipoGrupoActivoFijo tipogrupoactivofijo:tipogrupoactivofijos) {
					this.deepLoad(tipogrupoactivofijo,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoActivoFijo(tipogrupoactivofijos);
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
			if(tipogrupoactivofijos!=null) {
				for(TipoGrupoActivoFijo tipogrupoactivofijo:tipogrupoactivofijos) {
					this.deepLoad(tipogrupoactivofijo,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoActivoFijo(tipogrupoactivofijos);
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
	
	
	public void getTipoGrupoActivoFijosFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,TipoGrupoActivoFijoConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			TipoGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogrupoactivofijos=tipogrupoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoActivoFijo(this.tipogrupoactivofijos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoGrupoActivoFijosFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,TipoGrupoActivoFijoConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			TipoGrupoActivoFijoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipogrupoactivofijos=tipogrupoactivofijoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoActivoFijo(this.tipogrupoactivofijos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getTipoGrupoActivoFijoPorNombreWithConnection(String nombre)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoGrupoActivoFijo.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,TipoGrupoActivoFijoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			tipogrupoactivofijo=tipogrupoactivofijoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipogrupoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoActivoFijo(this.tipogrupoactivofijo);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoGrupoActivoFijoPorNombre(String nombre)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralEqual(ParameterType.STRING,nombre,TipoGrupoActivoFijoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			tipogrupoactivofijo=tipogrupoactivofijoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.tipogrupoactivofijo,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				TipoGrupoActivoFijoConstantesFunciones.refrescarForeignKeysDescripcionesTipoGrupoActivoFijo(this.tipogrupoactivofijo);
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
			if(TipoGrupoActivoFijoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoGrupoActivoFijoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoGrupoActivoFijo tipogrupoactivofijo,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoGrupoActivoFijoConstantesFunciones.ISCONAUDITORIA) {
				if(tipogrupoactivofijo.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoGrupoActivoFijoDataAccess.TABLENAME, tipogrupoactivofijo.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoGrupoActivoFijoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoGrupoActivoFijoLogic.registrarAuditoriaDetallesTipoGrupoActivoFijo(connexion,tipogrupoactivofijo,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipogrupoactivofijo.getIsDeleted()) {
					/*if(!tipogrupoactivofijo.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoGrupoActivoFijoDataAccess.TABLENAME, tipogrupoactivofijo.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoGrupoActivoFijoLogic.registrarAuditoriaDetallesTipoGrupoActivoFijo(connexion,tipogrupoactivofijo,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoGrupoActivoFijoDataAccess.TABLENAME, tipogrupoactivofijo.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipogrupoactivofijo.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoGrupoActivoFijoDataAccess.TABLENAME, tipogrupoactivofijo.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoGrupoActivoFijoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoGrupoActivoFijoLogic.registrarAuditoriaDetallesTipoGrupoActivoFijo(connexion,tipogrupoactivofijo,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoGrupoActivoFijo(Connexion connexion,TipoGrupoActivoFijo tipogrupoactivofijo)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipogrupoactivofijo.getIsNew()||!tipogrupoactivofijo.getid_pais().equals(tipogrupoactivofijo.getTipoGrupoActivoFijoOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipogrupoactivofijo.getTipoGrupoActivoFijoOriginal().getid_pais()!=null)
				{
					strValorActual=tipogrupoactivofijo.getTipoGrupoActivoFijoOriginal().getid_pais().toString();
				}
				if(tipogrupoactivofijo.getid_pais()!=null)
				{
					strValorNuevo=tipogrupoactivofijo.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoGrupoActivoFijoConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(tipogrupoactivofijo.getIsNew()||!tipogrupoactivofijo.getnombre().equals(tipogrupoactivofijo.getTipoGrupoActivoFijoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipogrupoactivofijo.getTipoGrupoActivoFijoOriginal().getnombre()!=null)
				{
					strValorActual=tipogrupoactivofijo.getTipoGrupoActivoFijoOriginal().getnombre();
				}
				if(tipogrupoactivofijo.getnombre()!=null)
				{
					strValorNuevo=tipogrupoactivofijo.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoGrupoActivoFijoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoGrupoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoGrupoActivoFijoConstantesFunciones.getClassesForeignKeysOfTipoGrupoActivoFijo(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoGrupoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoGrupoActivoFijoConstantesFunciones.getClassesRelationshipsOfTipoGrupoActivoFijo(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

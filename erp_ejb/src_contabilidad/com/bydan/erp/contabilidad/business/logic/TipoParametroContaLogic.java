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
package com.bydan.erp.contabilidad.business.logic;

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
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.contabilidad.util.TipoParametroContaConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoParametroContaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoParametroContaParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.TipoParametroConta;
import com.bydan.erp.contabilidad.business.logic.TipoParametroContaLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoParametroContaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoParametroContaLogic.class);
	
	protected TipoParametroContaDataAccess tipoparametrocontaDataAccess; 	
	protected TipoParametroConta tipoparametroconta;
	protected List<TipoParametroConta> tipoparametrocontas;
	protected Object tipoparametrocontaObject;	
	protected List<Object> tipoparametrocontasObject;
	
	public static ClassValidator<TipoParametroConta> tipoparametrocontaValidator = new ClassValidator<TipoParametroConta>(TipoParametroConta.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoParametroContaLogicAdditional tipoparametrocontaLogicAdditional=null;
	
	public TipoParametroContaLogicAdditional getTipoParametroContaLogicAdditional() {
		return this.tipoparametrocontaLogicAdditional;
	}
	
	public void setTipoParametroContaLogicAdditional(TipoParametroContaLogicAdditional tipoparametrocontaLogicAdditional) {
		try {
			this.tipoparametrocontaLogicAdditional=tipoparametrocontaLogicAdditional;
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
	
	
	
	
	public  TipoParametroContaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoparametrocontaDataAccess = new TipoParametroContaDataAccess();
			
			this.tipoparametrocontas= new ArrayList<TipoParametroConta>();
			this.tipoparametroconta= new TipoParametroConta();
			
			this.tipoparametrocontaObject=new Object();
			this.tipoparametrocontasObject=new ArrayList<Object>();
				
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
			
			this.tipoparametrocontaDataAccess.setConnexionType(this.connexionType);
			this.tipoparametrocontaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoParametroContaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoparametrocontaDataAccess = new TipoParametroContaDataAccess();
			this.tipoparametrocontas= new ArrayList<TipoParametroConta>();
			this.tipoparametroconta= new TipoParametroConta();
			this.tipoparametrocontaObject=new Object();
			this.tipoparametrocontasObject=new ArrayList<Object>();
			
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
			
			this.tipoparametrocontaDataAccess.setConnexionType(this.connexionType);
			this.tipoparametrocontaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoParametroConta getTipoParametroConta() throws Exception {	
		TipoParametroContaLogicAdditional.checkTipoParametroContaToGet(tipoparametroconta,this.datosCliente,this.arrDatoGeneral);
		TipoParametroContaLogicAdditional.updateTipoParametroContaToGet(tipoparametroconta,this.arrDatoGeneral);
		
		return tipoparametroconta;
	}
		
	public void setTipoParametroConta(TipoParametroConta newTipoParametroConta) {
		this.tipoparametroconta = newTipoParametroConta;
	}
	
	public TipoParametroContaDataAccess getTipoParametroContaDataAccess() {
		return tipoparametrocontaDataAccess;
	}
	
	public void setTipoParametroContaDataAccess(TipoParametroContaDataAccess newtipoparametrocontaDataAccess) {
		this.tipoparametrocontaDataAccess = newtipoparametrocontaDataAccess;
	}
	
	public List<TipoParametroConta> getTipoParametroContas() throws Exception {		
		this.quitarTipoParametroContasNulos();
		
		TipoParametroContaLogicAdditional.checkTipoParametroContaToGets(tipoparametrocontas,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoParametroConta tipoparametrocontaLocal: tipoparametrocontas ) {
			TipoParametroContaLogicAdditional.updateTipoParametroContaToGet(tipoparametrocontaLocal,this.arrDatoGeneral);
		}
		
		return tipoparametrocontas;
	}
	
	public void setTipoParametroContas(List<TipoParametroConta> newTipoParametroContas) {
		this.tipoparametrocontas = newTipoParametroContas;
	}
	
	public Object getTipoParametroContaObject() {	
		this.tipoparametrocontaObject=this.tipoparametrocontaDataAccess.getEntityObject();
		return this.tipoparametrocontaObject;
	}
		
	public void setTipoParametroContaObject(Object newTipoParametroContaObject) {
		this.tipoparametrocontaObject = newTipoParametroContaObject;
	}
	
	public List<Object> getTipoParametroContasObject() {		
		this.tipoparametrocontasObject=this.tipoparametrocontaDataAccess.getEntitiesObject();
		return this.tipoparametrocontasObject;
	}
		
	public void setTipoParametroContasObject(List<Object> newTipoParametroContasObject) {
		this.tipoparametrocontasObject = newTipoParametroContasObject;
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
		
		if(this.tipoparametrocontaDataAccess!=null) {
			this.tipoparametrocontaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParametroConta.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoparametrocontaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoparametrocontaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoparametroconta = new  TipoParametroConta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParametroConta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoparametroconta=tipoparametrocontaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoparametroconta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroConta(this.tipoparametroconta);
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
		tipoparametroconta = new  TipoParametroConta();
		  		  
        try {
			
			tipoparametroconta=tipoparametrocontaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoparametroconta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroConta(this.tipoparametroconta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoparametroconta = new  TipoParametroConta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParametroConta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoparametroconta=tipoparametrocontaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoparametroconta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroConta(this.tipoparametroconta);
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
		tipoparametroconta = new  TipoParametroConta();
		  		  
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
		tipoparametroconta = new  TipoParametroConta();
		  		  
        try {
			
			tipoparametroconta=tipoparametrocontaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoparametroconta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroConta(this.tipoparametroconta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoparametroconta = new  TipoParametroConta();
		  		  
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
		tipoparametroconta = new  TipoParametroConta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParametroConta.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoparametrocontaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoparametroconta = new  TipoParametroConta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoparametrocontaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoparametroconta = new  TipoParametroConta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParametroConta.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoparametrocontaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoparametroconta = new  TipoParametroConta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoparametrocontaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoparametroconta = new  TipoParametroConta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParametroConta.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoparametrocontaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoparametroconta = new  TipoParametroConta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoparametrocontaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoparametrocontas = new  ArrayList<TipoParametroConta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParametroConta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparametrocontas=tipoparametrocontaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoParametroConta(tipoparametrocontas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroConta(this.tipoparametrocontas);
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
		tipoparametrocontas = new  ArrayList<TipoParametroConta>();
		  		  
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
		tipoparametrocontas = new  ArrayList<TipoParametroConta>();
		  		  
        try {			
			TipoParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparametrocontas=tipoparametrocontaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoParametroConta(tipoparametrocontas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroConta(this.tipoparametrocontas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoparametrocontas = new  ArrayList<TipoParametroConta>();
		  		  
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
		tipoparametrocontas = new  ArrayList<TipoParametroConta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParametroConta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparametrocontas=tipoparametrocontaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoParametroConta(tipoparametrocontas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroConta(this.tipoparametrocontas);
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
		tipoparametrocontas = new  ArrayList<TipoParametroConta>();
		  		  
        try {
			TipoParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparametrocontas=tipoparametrocontaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoParametroConta(tipoparametrocontas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroConta(this.tipoparametrocontas);
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
		tipoparametrocontas = new  ArrayList<TipoParametroConta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParametroConta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparametrocontas=tipoparametrocontaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoParametroConta(tipoparametrocontas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroConta(this.tipoparametrocontas);
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
		tipoparametrocontas = new  ArrayList<TipoParametroConta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparametrocontas=tipoparametrocontaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoParametroConta(tipoparametrocontas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroConta(this.tipoparametrocontas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoparametroconta = new  TipoParametroConta();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParametroConta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparametroconta=tipoparametrocontaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoParametroConta(tipoparametroconta);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroConta(this.tipoparametroconta);
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
		tipoparametroconta = new  TipoParametroConta();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparametroconta=tipoparametrocontaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoParametroConta(tipoparametroconta);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroConta(this.tipoparametroconta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoparametrocontas = new  ArrayList<TipoParametroConta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParametroConta.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparametrocontas=tipoparametrocontaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoParametroConta(tipoparametrocontas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroConta(this.tipoparametrocontas);
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
		tipoparametrocontas = new  ArrayList<TipoParametroConta>();
		  		  
        try {
			TipoParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparametrocontas=tipoparametrocontaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoParametroConta(tipoparametrocontas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroConta(this.tipoparametrocontas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoParametroContasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoparametrocontas = new  ArrayList<TipoParametroConta>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParametroConta.class.getSimpleName()+"-getTodosTipoParametroContasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparametrocontas=tipoparametrocontaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoParametroConta(tipoparametrocontas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroConta(this.tipoparametrocontas);
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
	
	public  void  getTodosTipoParametroContas(String sFinalQuery,Pagination pagination)throws Exception {
		tipoparametrocontas = new  ArrayList<TipoParametroConta>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoparametrocontas=tipoparametrocontaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoParametroConta(tipoparametrocontas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroConta(this.tipoparametrocontas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoParametroConta(TipoParametroConta tipoparametroconta) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoparametroconta.getIsNew() || tipoparametroconta.getIsChanged()) { 
			this.invalidValues = tipoparametrocontaValidator.getInvalidValues(tipoparametroconta);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoparametroconta);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoParametroConta(List<TipoParametroConta> TipoParametroContas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoParametroConta tipoparametrocontaLocal:tipoparametrocontas) {				
			estaValidadoObjeto=this.validarGuardarTipoParametroConta(tipoparametrocontaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoParametroConta(List<TipoParametroConta> TipoParametroContas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoParametroConta(tipoparametrocontas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoParametroConta(TipoParametroConta TipoParametroConta) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoParametroConta(tipoparametroconta)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoParametroConta tipoparametroconta) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoparametroconta.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoParametroContaConstantesFunciones.getTipoParametroContaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoparametroconta","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoParametroContaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoParametroContaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoParametroContaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParametroConta.class.getSimpleName()+"-saveTipoParametroContaWithConnection");connexion.begin();			
			
			TipoParametroContaLogicAdditional.checkTipoParametroContaToSave(this.tipoparametroconta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoParametroContaLogicAdditional.updateTipoParametroContaToSave(this.tipoparametroconta,this.arrDatoGeneral);
			
			TipoParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoparametroconta,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoParametroConta();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoParametroConta(this.tipoparametroconta)) {
				TipoParametroContaDataAccess.save(this.tipoparametroconta, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoparametroconta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoParametroContaLogicAdditional.checkTipoParametroContaToSaveAfter(this.tipoparametroconta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoParametroConta();
			
			connexion.commit();			
			
			if(this.tipoparametroconta.getIsDeleted()) {
				this.tipoparametroconta=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoParametroConta()throws Exception {	
		try {	
			
			TipoParametroContaLogicAdditional.checkTipoParametroContaToSave(this.tipoparametroconta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoParametroContaLogicAdditional.updateTipoParametroContaToSave(this.tipoparametroconta,this.arrDatoGeneral);
			
			TipoParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoparametroconta,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoParametroConta(this.tipoparametroconta)) {			
				TipoParametroContaDataAccess.save(this.tipoparametroconta, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoparametroconta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoParametroContaLogicAdditional.checkTipoParametroContaToSaveAfter(this.tipoparametroconta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoparametroconta.getIsDeleted()) {
				this.tipoparametroconta=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoParametroContasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParametroConta.class.getSimpleName()+"-saveTipoParametroContasWithConnection");connexion.begin();			
			
			TipoParametroContaLogicAdditional.checkTipoParametroContaToSaves(tipoparametrocontas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoParametroContas();
			
			Boolean validadoTodosTipoParametroConta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoParametroConta tipoparametrocontaLocal:tipoparametrocontas) {		
				if(tipoparametrocontaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoParametroContaLogicAdditional.updateTipoParametroContaToSave(tipoparametrocontaLocal,this.arrDatoGeneral);
	        	
				TipoParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoparametrocontaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoParametroConta(tipoparametrocontaLocal)) {
					TipoParametroContaDataAccess.save(tipoparametrocontaLocal, connexion);				
				} else {
					validadoTodosTipoParametroConta=false;
				}
			}
			
			if(!validadoTodosTipoParametroConta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoParametroContaLogicAdditional.checkTipoParametroContaToSavesAfter(tipoparametrocontas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoParametroContas();
			
			connexion.commit();		
			
			this.quitarTipoParametroContasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoParametroContas()throws Exception {				
		 try {	
			TipoParametroContaLogicAdditional.checkTipoParametroContaToSaves(tipoparametrocontas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoParametroConta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoParametroConta tipoparametrocontaLocal:tipoparametrocontas) {				
				if(tipoparametrocontaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoParametroContaLogicAdditional.updateTipoParametroContaToSave(tipoparametrocontaLocal,this.arrDatoGeneral);
	        	
				TipoParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoparametrocontaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoParametroConta(tipoparametrocontaLocal)) {				
					TipoParametroContaDataAccess.save(tipoparametrocontaLocal, connexion);				
				} else {
					validadoTodosTipoParametroConta=false;
				}
			}
			
			if(!validadoTodosTipoParametroConta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoParametroContaLogicAdditional.checkTipoParametroContaToSavesAfter(tipoparametrocontas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoParametroContasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoParametroContaParameterReturnGeneral procesarAccionTipoParametroContas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoParametroConta> tipoparametrocontas,TipoParametroContaParameterReturnGeneral tipoparametrocontaParameterGeneral)throws Exception {
		 try {	
			TipoParametroContaParameterReturnGeneral tipoparametrocontaReturnGeneral=new TipoParametroContaParameterReturnGeneral();
	
			TipoParametroContaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoparametrocontas,tipoparametrocontaParameterGeneral,tipoparametrocontaReturnGeneral);
			
			return tipoparametrocontaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoParametroContaParameterReturnGeneral procesarAccionTipoParametroContasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoParametroConta> tipoparametrocontas,TipoParametroContaParameterReturnGeneral tipoparametrocontaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParametroConta.class.getSimpleName()+"-procesarAccionTipoParametroContasWithConnection");connexion.begin();			
			
			TipoParametroContaParameterReturnGeneral tipoparametrocontaReturnGeneral=new TipoParametroContaParameterReturnGeneral();
	
			TipoParametroContaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoparametrocontas,tipoparametrocontaParameterGeneral,tipoparametrocontaReturnGeneral);
			
			this.connexion.commit();
			
			return tipoparametrocontaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoParametroContaParameterReturnGeneral procesarEventosTipoParametroContas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoParametroConta> tipoparametrocontas,TipoParametroConta tipoparametroconta,TipoParametroContaParameterReturnGeneral tipoparametrocontaParameterGeneral,Boolean isEsNuevoTipoParametroConta,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoParametroContaParameterReturnGeneral tipoparametrocontaReturnGeneral=new TipoParametroContaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoparametrocontaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoParametroContaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoparametrocontas,tipoparametroconta,tipoparametrocontaParameterGeneral,tipoparametrocontaReturnGeneral,isEsNuevoTipoParametroConta,clases);
			
			return tipoparametrocontaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoParametroContaParameterReturnGeneral procesarEventosTipoParametroContasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoParametroConta> tipoparametrocontas,TipoParametroConta tipoparametroconta,TipoParametroContaParameterReturnGeneral tipoparametrocontaParameterGeneral,Boolean isEsNuevoTipoParametroConta,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParametroConta.class.getSimpleName()+"-procesarEventosTipoParametroContasWithConnection");connexion.begin();			
			
			TipoParametroContaParameterReturnGeneral tipoparametrocontaReturnGeneral=new TipoParametroContaParameterReturnGeneral();
	
			tipoparametrocontaReturnGeneral.setTipoParametroConta(tipoparametroconta);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoparametrocontaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoParametroContaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoparametrocontas,tipoparametroconta,tipoparametrocontaParameterGeneral,tipoparametrocontaReturnGeneral,isEsNuevoTipoParametroConta,clases);
			
			this.connexion.commit();
			
			return tipoparametrocontaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoParametroContaParameterReturnGeneral procesarImportacionTipoParametroContasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoParametroContaParameterReturnGeneral tipoparametrocontaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParametroConta.class.getSimpleName()+"-procesarImportacionTipoParametroContasWithConnection");connexion.begin();			
			
			TipoParametroContaParameterReturnGeneral tipoparametrocontaReturnGeneral=new TipoParametroContaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoparametrocontas=new ArrayList<TipoParametroConta>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoparametroconta=new TipoParametroConta();
				
				
				if(conColumnasBase) {this.tipoparametroconta.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoparametroconta.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoparametroconta.setcodigo(arrColumnas[iColumn++]);
				this.tipoparametroconta.setnombre(arrColumnas[iColumn++]);
				
				this.tipoparametrocontas.add(this.tipoparametroconta);
			}
			
			this.saveTipoParametroContas();
			
			this.connexion.commit();
			
			tipoparametrocontaReturnGeneral.setConRetornoEstaProcesado(true);
			tipoparametrocontaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoparametrocontaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoParametroContasEliminados() throws Exception {				
		
		List<TipoParametroConta> tipoparametrocontasAux= new ArrayList<TipoParametroConta>();
		
		for(TipoParametroConta tipoparametroconta:tipoparametrocontas) {
			if(!tipoparametroconta.getIsDeleted()) {
				tipoparametrocontasAux.add(tipoparametroconta);
			}
		}
		
		tipoparametrocontas=tipoparametrocontasAux;
	}
	
	public void quitarTipoParametroContasNulos() throws Exception {				
		
		List<TipoParametroConta> tipoparametrocontasAux= new ArrayList<TipoParametroConta>();
		
		for(TipoParametroConta tipoparametroconta : this.tipoparametrocontas) {
			if(tipoparametroconta==null) {
				tipoparametrocontasAux.add(tipoparametroconta);
			}
		}
		
		//this.tipoparametrocontas=tipoparametrocontasAux;
		
		this.tipoparametrocontas.removeAll(tipoparametrocontasAux);
	}
	
	public void getSetVersionRowTipoParametroContaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoparametroconta.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoparametroconta.getIsDeleted() || (tipoparametroconta.getIsChanged()&&!tipoparametroconta.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoparametrocontaDataAccess.getSetVersionRowTipoParametroConta(connexion,tipoparametroconta.getId());
				
				if(!tipoparametroconta.getVersionRow().equals(timestamp)) {	
					tipoparametroconta.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoparametroconta.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoParametroConta()throws Exception {	
		
		if(tipoparametroconta.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoparametroconta.getIsDeleted() || (tipoparametroconta.getIsChanged()&&!tipoparametroconta.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoparametrocontaDataAccess.getSetVersionRowTipoParametroConta(connexion,tipoparametroconta.getId());
			
			try {							
				if(!tipoparametroconta.getVersionRow().equals(timestamp)) {	
					tipoparametroconta.setVersionRow(timestamp);
				}
				
				tipoparametroconta.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoParametroContasWithConnection()throws Exception {	
		if(tipoparametrocontas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoParametroConta tipoparametrocontaAux:tipoparametrocontas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoparametrocontaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoparametrocontaAux.getIsDeleted() || (tipoparametrocontaAux.getIsChanged()&&!tipoparametrocontaAux.getIsNew())) {
						
						timestamp=tipoparametrocontaDataAccess.getSetVersionRowTipoParametroConta(connexion,tipoparametrocontaAux.getId());
						
						if(!tipoparametroconta.getVersionRow().equals(timestamp)) {	
							tipoparametrocontaAux.setVersionRow(timestamp);
						}
								
						tipoparametrocontaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoParametroContas()throws Exception {	
		if(tipoparametrocontas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoParametroConta tipoparametrocontaAux:tipoparametrocontas) {
					if(tipoparametrocontaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoparametrocontaAux.getIsDeleted() || (tipoparametrocontaAux.getIsChanged()&&!tipoparametrocontaAux.getIsNew())) {
						
						timestamp=tipoparametrocontaDataAccess.getSetVersionRowTipoParametroConta(connexion,tipoparametrocontaAux.getId());
						
						if(!tipoparametrocontaAux.getVersionRow().equals(timestamp)) {	
							tipoparametrocontaAux.setVersionRow(timestamp);
						}
						
													
						tipoparametrocontaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoParametroContaParameterReturnGeneral cargarCombosLoteForeignKeyTipoParametroContaWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoParametroContaParameterReturnGeneral  tipoparametrocontaReturnGeneral =new TipoParametroContaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParametroConta.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoParametroContaWithConnection");connexion.begin();
			
			tipoparametrocontaReturnGeneral =new TipoParametroContaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoparametrocontaReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipoparametrocontaReturnGeneral;
	}
	
	public TipoParametroContaParameterReturnGeneral cargarCombosLoteForeignKeyTipoParametroConta(String finalQueryGlobalEmpresa) throws Exception {
		TipoParametroContaParameterReturnGeneral  tipoparametrocontaReturnGeneral =new TipoParametroContaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipoparametrocontaReturnGeneral =new TipoParametroContaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoparametrocontaReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipoparametrocontaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoParametroContaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ParametroContaDetalleLogic parametrocontadetalleLogic=new ParametroContaDetalleLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParametroConta.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoParametroContaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(ParametroContaDetalle.class));
											
			

			parametrocontadetalleLogic.setConnexion(this.getConnexion());
			parametrocontadetalleLogic.setDatosCliente(this.datosCliente);
			parametrocontadetalleLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoParametroConta tipoparametroconta:this.tipoparametrocontas) {
				

				classes=new ArrayList<Classe>();
				classes=ParametroContaDetalleConstantesFunciones.getClassesForeignKeysOfParametroContaDetalle(new ArrayList<Classe>(),DeepLoadType.NONE);

				parametrocontadetalleLogic.setParametroContaDetalles(tipoparametroconta.parametrocontadetalles);
				parametrocontadetalleLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoParametroConta tipoparametroconta,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoParametroContaLogicAdditional.updateTipoParametroContaToGet(tipoparametroconta,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoparametroconta.setEmpresa(tipoparametrocontaDataAccess.getEmpresa(connexion,tipoparametroconta));
		tipoparametroconta.setParametroContaDetalles(tipoparametrocontaDataAccess.getParametroContaDetalles(connexion,tipoparametroconta));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoparametroconta.setEmpresa(tipoparametrocontaDataAccess.getEmpresa(connexion,tipoparametroconta));
				continue;
			}

			if(clas.clas.equals(ParametroContaDetalle.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoparametroconta.setParametroContaDetalles(tipoparametrocontaDataAccess.getParametroContaDetalles(connexion,tipoparametroconta));

				if(this.isConDeep) {
					ParametroContaDetalleLogic parametrocontadetalleLogic= new ParametroContaDetalleLogic(this.connexion);
					parametrocontadetalleLogic.setParametroContaDetalles(tipoparametroconta.getParametroContaDetalles());
					ArrayList<Classe> classesLocal=ParametroContaDetalleConstantesFunciones.getClassesForeignKeysOfParametroContaDetalle(new ArrayList<Classe>(),DeepLoadType.NONE);
					parametrocontadetalleLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ParametroContaDetalleConstantesFunciones.refrescarForeignKeysDescripcionesParametroContaDetalle(parametrocontadetalleLogic.getParametroContaDetalles());
					tipoparametroconta.setParametroContaDetalles(parametrocontadetalleLogic.getParametroContaDetalles());
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
			tipoparametroconta.setEmpresa(tipoparametrocontaDataAccess.getEmpresa(connexion,tipoparametroconta));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroContaDetalle.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroContaDetalle.class));
			tipoparametroconta.setParametroContaDetalles(tipoparametrocontaDataAccess.getParametroContaDetalles(connexion,tipoparametroconta));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoparametroconta.setEmpresa(tipoparametrocontaDataAccess.getEmpresa(connexion,tipoparametroconta));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoparametroconta.getEmpresa(),isDeep,deepLoadType,clases);
				

		tipoparametroconta.setParametroContaDetalles(tipoparametrocontaDataAccess.getParametroContaDetalles(connexion,tipoparametroconta));

		for(ParametroContaDetalle parametrocontadetalle:tipoparametroconta.getParametroContaDetalles()) {
			ParametroContaDetalleLogic parametrocontadetalleLogic= new ParametroContaDetalleLogic(connexion);
			parametrocontadetalleLogic.deepLoad(parametrocontadetalle,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoparametroconta.setEmpresa(tipoparametrocontaDataAccess.getEmpresa(connexion,tipoparametroconta));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipoparametroconta.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ParametroContaDetalle.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoparametroconta.setParametroContaDetalles(tipoparametrocontaDataAccess.getParametroContaDetalles(connexion,tipoparametroconta));

				for(ParametroContaDetalle parametrocontadetalle:tipoparametroconta.getParametroContaDetalles()) {
					ParametroContaDetalleLogic parametrocontadetalleLogic= new ParametroContaDetalleLogic(connexion);
					parametrocontadetalleLogic.deepLoad(parametrocontadetalle,isDeep,deepLoadType,clases);
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
			tipoparametroconta.setEmpresa(tipoparametrocontaDataAccess.getEmpresa(connexion,tipoparametroconta));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipoparametroconta.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroContaDetalle.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroContaDetalle.class));
			tipoparametroconta.setParametroContaDetalles(tipoparametrocontaDataAccess.getParametroContaDetalles(connexion,tipoparametroconta));

			for(ParametroContaDetalle parametrocontadetalle:tipoparametroconta.getParametroContaDetalles()) {
				ParametroContaDetalleLogic parametrocontadetalleLogic= new ParametroContaDetalleLogic(connexion);
				parametrocontadetalleLogic.deepLoad(parametrocontadetalle,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoParametroConta tipoparametroconta,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoParametroContaLogicAdditional.updateTipoParametroContaToSave(tipoparametroconta,this.arrDatoGeneral);
			
TipoParametroContaDataAccess.save(tipoparametroconta, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipoparametroconta.getEmpresa(),connexion);

		for(ParametroContaDetalle parametrocontadetalle:tipoparametroconta.getParametroContaDetalles()) {
			parametrocontadetalle.setid_tipo_parametro_conta(tipoparametroconta.getId());
			ParametroContaDetalleDataAccess.save(parametrocontadetalle,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipoparametroconta.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(ParametroContaDetalle.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroContaDetalle parametrocontadetalle:tipoparametroconta.getParametroContaDetalles()) {
					parametrocontadetalle.setid_tipo_parametro_conta(tipoparametroconta.getId());
					ParametroContaDetalleDataAccess.save(parametrocontadetalle,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipoparametroconta.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoparametroconta.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(ParametroContaDetalle parametrocontadetalle:tipoparametroconta.getParametroContaDetalles()) {
			ParametroContaDetalleLogic parametrocontadetalleLogic= new ParametroContaDetalleLogic(connexion);
			parametrocontadetalle.setid_tipo_parametro_conta(tipoparametroconta.getId());
			ParametroContaDetalleDataAccess.save(parametrocontadetalle,connexion);
			parametrocontadetalleLogic.deepSave(parametrocontadetalle,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipoparametroconta.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipoparametroconta.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(ParametroContaDetalle.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ParametroContaDetalle parametrocontadetalle:tipoparametroconta.getParametroContaDetalles()) {
					ParametroContaDetalleLogic parametrocontadetalleLogic= new ParametroContaDetalleLogic(connexion);
					parametrocontadetalle.setid_tipo_parametro_conta(tipoparametroconta.getId());
					ParametroContaDetalleDataAccess.save(parametrocontadetalle,connexion);
					parametrocontadetalleLogic.deepSave(parametrocontadetalle,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoParametroConta.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoparametroconta,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroConta(tipoparametroconta);
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
			this.deepLoad(this.tipoparametroconta,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroConta(this.tipoparametroconta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoParametroConta.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoparametrocontas!=null) {
				for(TipoParametroConta tipoparametroconta:tipoparametrocontas) {
					this.deepLoad(tipoparametroconta,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroConta(tipoparametrocontas);
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
			if(tipoparametrocontas!=null) {
				for(TipoParametroConta tipoparametroconta:tipoparametrocontas) {
					this.deepLoad(tipoparametroconta,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroConta(tipoparametrocontas);
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
			this.getNewConnexionToDeep(TipoParametroConta.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipoparametroconta,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoParametroConta.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipoparametrocontas!=null) {
				for(TipoParametroConta tipoparametroconta:tipoparametrocontas) {
					this.deepSave(tipoparametroconta,isDeep,deepLoadType,clases);
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
			if(tipoparametrocontas!=null) {
				for(TipoParametroConta tipoparametroconta:tipoparametrocontas) {
					this.deepSave(tipoparametroconta,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoParametroContasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoParametroConta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoParametroContaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoparametrocontas=tipoparametrocontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroConta(this.tipoparametrocontas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoParametroContasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoParametroContaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoParametroContaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoparametrocontas=tipoparametrocontaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoParametroContaConstantesFunciones.refrescarForeignKeysDescripcionesTipoParametroConta(this.tipoparametrocontas);
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
			if(TipoParametroContaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoParametroContaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoParametroConta tipoparametroconta,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoParametroContaConstantesFunciones.ISCONAUDITORIA) {
				if(tipoparametroconta.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoParametroContaDataAccess.TABLENAME, tipoparametroconta.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoParametroContaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoParametroContaLogic.registrarAuditoriaDetallesTipoParametroConta(connexion,tipoparametroconta,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoparametroconta.getIsDeleted()) {
					/*if(!tipoparametroconta.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoParametroContaDataAccess.TABLENAME, tipoparametroconta.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoParametroContaLogic.registrarAuditoriaDetallesTipoParametroConta(connexion,tipoparametroconta,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoParametroContaDataAccess.TABLENAME, tipoparametroconta.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoparametroconta.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoParametroContaDataAccess.TABLENAME, tipoparametroconta.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoParametroContaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoParametroContaLogic.registrarAuditoriaDetallesTipoParametroConta(connexion,tipoparametroconta,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoParametroConta(Connexion connexion,TipoParametroConta tipoparametroconta)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoparametroconta.getIsNew()||!tipoparametroconta.getid_empresa().equals(tipoparametroconta.getTipoParametroContaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoparametroconta.getTipoParametroContaOriginal().getid_empresa()!=null)
				{
					strValorActual=tipoparametroconta.getTipoParametroContaOriginal().getid_empresa().toString();
				}
				if(tipoparametroconta.getid_empresa()!=null)
				{
					strValorNuevo=tipoparametroconta.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoParametroContaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipoparametroconta.getIsNew()||!tipoparametroconta.getcodigo().equals(tipoparametroconta.getTipoParametroContaOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoparametroconta.getTipoParametroContaOriginal().getcodigo()!=null)
				{
					strValorActual=tipoparametroconta.getTipoParametroContaOriginal().getcodigo();
				}
				if(tipoparametroconta.getcodigo()!=null)
				{
					strValorNuevo=tipoparametroconta.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoParametroContaConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipoparametroconta.getIsNew()||!tipoparametroconta.getnombre().equals(tipoparametroconta.getTipoParametroContaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoparametroconta.getTipoParametroContaOriginal().getnombre()!=null)
				{
					strValorActual=tipoparametroconta.getTipoParametroContaOriginal().getnombre();
				}
				if(tipoparametroconta.getnombre()!=null)
				{
					strValorNuevo=tipoparametroconta.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoParametroContaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoParametroContaRelacionesWithConnection(TipoParametroConta tipoparametroconta,List<ParametroContaDetalle> parametrocontadetalles) throws Exception {

		if(!tipoparametroconta.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoParametroContaRelacionesBase(tipoparametroconta,parametrocontadetalles,true);
		}
	}

	public void saveTipoParametroContaRelaciones(TipoParametroConta tipoparametroconta,List<ParametroContaDetalle> parametrocontadetalles)throws Exception {

		if(!tipoparametroconta.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoParametroContaRelacionesBase(tipoparametroconta,parametrocontadetalles,false);
		}
	}

	public void saveTipoParametroContaRelacionesBase(TipoParametroConta tipoparametroconta,List<ParametroContaDetalle> parametrocontadetalles,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoParametroConta-saveRelacionesWithConnection");}
	
			tipoparametroconta.setParametroContaDetalles(parametrocontadetalles);

			this.setTipoParametroConta(tipoparametroconta);

			if(TipoParametroContaLogicAdditional.validarSaveRelaciones(tipoparametroconta,this)) {

				TipoParametroContaLogicAdditional.updateRelacionesToSave(tipoparametroconta,this);

				if((tipoparametroconta.getIsNew()||tipoparametroconta.getIsChanged())&&!tipoparametroconta.getIsDeleted()) {
					this.saveTipoParametroConta();
					this.saveTipoParametroContaRelacionesDetalles(parametrocontadetalles);

				} else if(tipoparametroconta.getIsDeleted()) {
					this.saveTipoParametroContaRelacionesDetalles(parametrocontadetalles);
					this.saveTipoParametroConta();
				}

				TipoParametroContaLogicAdditional.updateRelacionesToSaveAfter(tipoparametroconta,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ParametroContaDetalleConstantesFunciones.InicializarGeneralEntityAuxiliaresParametroContaDetalles(parametrocontadetalles,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoParametroContaRelacionesDetalles(List<ParametroContaDetalle> parametrocontadetalles)throws Exception {
		try {
	

			Long idTipoParametroContaActual=this.getTipoParametroConta().getId();

			ParametroContaDetalleLogic parametrocontadetalleLogic_Desde_TipoParametroConta=new ParametroContaDetalleLogic();
			parametrocontadetalleLogic_Desde_TipoParametroConta.setParametroContaDetalles(parametrocontadetalles);

			parametrocontadetalleLogic_Desde_TipoParametroConta.setConnexion(this.getConnexion());
			parametrocontadetalleLogic_Desde_TipoParametroConta.setDatosCliente(this.datosCliente);

			for(ParametroContaDetalle parametrocontadetalle_Desde_TipoParametroConta:parametrocontadetalleLogic_Desde_TipoParametroConta.getParametroContaDetalles()) {
				parametrocontadetalle_Desde_TipoParametroConta.setid_tipo_parametro_conta(idTipoParametroContaActual);
			}

			parametrocontadetalleLogic_Desde_TipoParametroConta.saveParametroContaDetalles();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoParametroConta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoParametroContaConstantesFunciones.getClassesForeignKeysOfTipoParametroConta(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoParametroConta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoParametroContaConstantesFunciones.getClassesRelationshipsOfTipoParametroConta(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

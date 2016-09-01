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
package com.bydan.erp.tesoreria.business.logic;

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
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.tesoreria.util.TipoCodigoSriBancoConstantesFunciones;
import com.bydan.erp.tesoreria.util.TipoCodigoSriBancoParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.TipoCodigoSriBancoParameterGeneral;
import com.bydan.erp.tesoreria.business.entity.TipoCodigoSriBanco;
import com.bydan.erp.tesoreria.business.logic.TipoCodigoSriBancoLogicAdditional;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class TipoCodigoSriBancoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoCodigoSriBancoLogic.class);
	
	protected TipoCodigoSriBancoDataAccess tipocodigosribancoDataAccess; 	
	protected TipoCodigoSriBanco tipocodigosribanco;
	protected List<TipoCodigoSriBanco> tipocodigosribancos;
	protected Object tipocodigosribancoObject;	
	protected List<Object> tipocodigosribancosObject;
	
	public static ClassValidator<TipoCodigoSriBanco> tipocodigosribancoValidator = new ClassValidator<TipoCodigoSriBanco>(TipoCodigoSriBanco.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoCodigoSriBancoLogicAdditional tipocodigosribancoLogicAdditional=null;
	
	public TipoCodigoSriBancoLogicAdditional getTipoCodigoSriBancoLogicAdditional() {
		return this.tipocodigosribancoLogicAdditional;
	}
	
	public void setTipoCodigoSriBancoLogicAdditional(TipoCodigoSriBancoLogicAdditional tipocodigosribancoLogicAdditional) {
		try {
			this.tipocodigosribancoLogicAdditional=tipocodigosribancoLogicAdditional;
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
	
	
	
	
	public  TipoCodigoSriBancoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipocodigosribancoDataAccess = new TipoCodigoSriBancoDataAccess();
			
			this.tipocodigosribancos= new ArrayList<TipoCodigoSriBanco>();
			this.tipocodigosribanco= new TipoCodigoSriBanco();
			
			this.tipocodigosribancoObject=new Object();
			this.tipocodigosribancosObject=new ArrayList<Object>();
				
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
			
			this.tipocodigosribancoDataAccess.setConnexionType(this.connexionType);
			this.tipocodigosribancoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoCodigoSriBancoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipocodigosribancoDataAccess = new TipoCodigoSriBancoDataAccess();
			this.tipocodigosribancos= new ArrayList<TipoCodigoSriBanco>();
			this.tipocodigosribanco= new TipoCodigoSriBanco();
			this.tipocodigosribancoObject=new Object();
			this.tipocodigosribancosObject=new ArrayList<Object>();
			
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
			
			this.tipocodigosribancoDataAccess.setConnexionType(this.connexionType);
			this.tipocodigosribancoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoCodigoSriBanco getTipoCodigoSriBanco() throws Exception {	
		TipoCodigoSriBancoLogicAdditional.checkTipoCodigoSriBancoToGet(tipocodigosribanco,this.datosCliente,this.arrDatoGeneral);
		TipoCodigoSriBancoLogicAdditional.updateTipoCodigoSriBancoToGet(tipocodigosribanco,this.arrDatoGeneral);
		
		return tipocodigosribanco;
	}
		
	public void setTipoCodigoSriBanco(TipoCodigoSriBanco newTipoCodigoSriBanco) {
		this.tipocodigosribanco = newTipoCodigoSriBanco;
	}
	
	public TipoCodigoSriBancoDataAccess getTipoCodigoSriBancoDataAccess() {
		return tipocodigosribancoDataAccess;
	}
	
	public void setTipoCodigoSriBancoDataAccess(TipoCodigoSriBancoDataAccess newtipocodigosribancoDataAccess) {
		this.tipocodigosribancoDataAccess = newtipocodigosribancoDataAccess;
	}
	
	public List<TipoCodigoSriBanco> getTipoCodigoSriBancos() throws Exception {		
		this.quitarTipoCodigoSriBancosNulos();
		
		TipoCodigoSriBancoLogicAdditional.checkTipoCodigoSriBancoToGets(tipocodigosribancos,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoCodigoSriBanco tipocodigosribancoLocal: tipocodigosribancos ) {
			TipoCodigoSriBancoLogicAdditional.updateTipoCodigoSriBancoToGet(tipocodigosribancoLocal,this.arrDatoGeneral);
		}
		
		return tipocodigosribancos;
	}
	
	public void setTipoCodigoSriBancos(List<TipoCodigoSriBanco> newTipoCodigoSriBancos) {
		this.tipocodigosribancos = newTipoCodigoSriBancos;
	}
	
	public Object getTipoCodigoSriBancoObject() {	
		this.tipocodigosribancoObject=this.tipocodigosribancoDataAccess.getEntityObject();
		return this.tipocodigosribancoObject;
	}
		
	public void setTipoCodigoSriBancoObject(Object newTipoCodigoSriBancoObject) {
		this.tipocodigosribancoObject = newTipoCodigoSriBancoObject;
	}
	
	public List<Object> getTipoCodigoSriBancosObject() {		
		this.tipocodigosribancosObject=this.tipocodigosribancoDataAccess.getEntitiesObject();
		return this.tipocodigosribancosObject;
	}
		
	public void setTipoCodigoSriBancosObject(List<Object> newTipoCodigoSriBancosObject) {
		this.tipocodigosribancosObject = newTipoCodigoSriBancosObject;
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
		
		if(this.tipocodigosribancoDataAccess!=null) {
			this.tipocodigosribancoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCodigoSriBanco.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipocodigosribancoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipocodigosribancoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipocodigosribanco = new  TipoCodigoSriBanco();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCodigoSriBanco.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipocodigosribanco=tipocodigosribancoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocodigosribanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCodigoSriBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoSriBanco(this.tipocodigosribanco);
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
		tipocodigosribanco = new  TipoCodigoSriBanco();
		  		  
        try {
			
			tipocodigosribanco=tipocodigosribancoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocodigosribanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCodigoSriBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoSriBanco(this.tipocodigosribanco);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipocodigosribanco = new  TipoCodigoSriBanco();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCodigoSriBanco.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipocodigosribanco=tipocodigosribancoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocodigosribanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCodigoSriBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoSriBanco(this.tipocodigosribanco);
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
		tipocodigosribanco = new  TipoCodigoSriBanco();
		  		  
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
		tipocodigosribanco = new  TipoCodigoSriBanco();
		  		  
        try {
			
			tipocodigosribanco=tipocodigosribancoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocodigosribanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCodigoSriBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoSriBanco(this.tipocodigosribanco);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipocodigosribanco = new  TipoCodigoSriBanco();
		  		  
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
		tipocodigosribanco = new  TipoCodigoSriBanco();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCodigoSriBanco.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipocodigosribancoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocodigosribanco = new  TipoCodigoSriBanco();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipocodigosribancoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipocodigosribanco = new  TipoCodigoSriBanco();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCodigoSriBanco.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipocodigosribancoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocodigosribanco = new  TipoCodigoSriBanco();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipocodigosribancoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipocodigosribanco = new  TipoCodigoSriBanco();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCodigoSriBanco.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipocodigosribancoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocodigosribanco = new  TipoCodigoSriBanco();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipocodigosribancoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipocodigosribancos = new  ArrayList<TipoCodigoSriBanco>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCodigoSriBanco.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoCodigoSriBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocodigosribancos=tipocodigosribancoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCodigoSriBanco(tipocodigosribancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCodigoSriBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoSriBanco(this.tipocodigosribancos);
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
		tipocodigosribancos = new  ArrayList<TipoCodigoSriBanco>();
		  		  
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
		tipocodigosribancos = new  ArrayList<TipoCodigoSriBanco>();
		  		  
        try {			
			TipoCodigoSriBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocodigosribancos=tipocodigosribancoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoCodigoSriBanco(tipocodigosribancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCodigoSriBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoSriBanco(this.tipocodigosribancos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipocodigosribancos = new  ArrayList<TipoCodigoSriBanco>();
		  		  
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
		tipocodigosribancos = new  ArrayList<TipoCodigoSriBanco>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCodigoSriBanco.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoCodigoSriBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocodigosribancos=tipocodigosribancoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCodigoSriBanco(tipocodigosribancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCodigoSriBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoSriBanco(this.tipocodigosribancos);
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
		tipocodigosribancos = new  ArrayList<TipoCodigoSriBanco>();
		  		  
        try {
			TipoCodigoSriBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocodigosribancos=tipocodigosribancoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCodigoSriBanco(tipocodigosribancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCodigoSriBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoSriBanco(this.tipocodigosribancos);
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
		tipocodigosribancos = new  ArrayList<TipoCodigoSriBanco>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCodigoSriBanco.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCodigoSriBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocodigosribancos=tipocodigosribancoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCodigoSriBanco(tipocodigosribancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCodigoSriBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoSriBanco(this.tipocodigosribancos);
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
		tipocodigosribancos = new  ArrayList<TipoCodigoSriBanco>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCodigoSriBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocodigosribancos=tipocodigosribancoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCodigoSriBanco(tipocodigosribancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCodigoSriBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoSriBanco(this.tipocodigosribancos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipocodigosribanco = new  TipoCodigoSriBanco();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCodigoSriBanco.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCodigoSriBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocodigosribanco=tipocodigosribancoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCodigoSriBanco(tipocodigosribanco);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCodigoSriBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoSriBanco(this.tipocodigosribanco);
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
		tipocodigosribanco = new  TipoCodigoSriBanco();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCodigoSriBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocodigosribanco=tipocodigosribancoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCodigoSriBanco(tipocodigosribanco);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCodigoSriBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoSriBanco(this.tipocodigosribanco);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipocodigosribancos = new  ArrayList<TipoCodigoSriBanco>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCodigoSriBanco.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoCodigoSriBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocodigosribancos=tipocodigosribancoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCodigoSriBanco(tipocodigosribancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCodigoSriBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoSriBanco(this.tipocodigosribancos);
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
		tipocodigosribancos = new  ArrayList<TipoCodigoSriBanco>();
		  		  
        try {
			TipoCodigoSriBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocodigosribancos=tipocodigosribancoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCodigoSriBanco(tipocodigosribancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCodigoSriBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoSriBanco(this.tipocodigosribancos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoCodigoSriBancosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipocodigosribancos = new  ArrayList<TipoCodigoSriBanco>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCodigoSriBanco.class.getSimpleName()+"-getTodosTipoCodigoSriBancosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCodigoSriBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocodigosribancos=tipocodigosribancoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoCodigoSriBanco(tipocodigosribancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCodigoSriBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoSriBanco(this.tipocodigosribancos);
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
	
	public  void  getTodosTipoCodigoSriBancos(String sFinalQuery,Pagination pagination)throws Exception {
		tipocodigosribancos = new  ArrayList<TipoCodigoSriBanco>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCodigoSriBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocodigosribancos=tipocodigosribancoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoCodigoSriBanco(tipocodigosribancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCodigoSriBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoSriBanco(this.tipocodigosribancos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoCodigoSriBanco(TipoCodigoSriBanco tipocodigosribanco) throws Exception {
		Boolean estaValidado=false;
		
		if(tipocodigosribanco.getIsNew() || tipocodigosribanco.getIsChanged()) { 
			this.invalidValues = tipocodigosribancoValidator.getInvalidValues(tipocodigosribanco);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipocodigosribanco);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoCodigoSriBanco(List<TipoCodigoSriBanco> TipoCodigoSriBancos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoCodigoSriBanco tipocodigosribancoLocal:tipocodigosribancos) {				
			estaValidadoObjeto=this.validarGuardarTipoCodigoSriBanco(tipocodigosribancoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoCodigoSriBanco(List<TipoCodigoSriBanco> TipoCodigoSriBancos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoCodigoSriBanco(tipocodigosribancos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoCodigoSriBanco(TipoCodigoSriBanco TipoCodigoSriBanco) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoCodigoSriBanco(tipocodigosribanco)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoCodigoSriBanco tipocodigosribanco) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipocodigosribanco.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoCodigoSriBancoConstantesFunciones.getTipoCodigoSriBancoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipocodigosribanco","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoCodigoSriBancoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoCodigoSriBancoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoCodigoSriBancoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCodigoSriBanco.class.getSimpleName()+"-saveTipoCodigoSriBancoWithConnection");connexion.begin();			
			
			TipoCodigoSriBancoLogicAdditional.checkTipoCodigoSriBancoToSave(this.tipocodigosribanco,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoCodigoSriBancoLogicAdditional.updateTipoCodigoSriBancoToSave(this.tipocodigosribanco,this.arrDatoGeneral);
			
			TipoCodigoSriBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipocodigosribanco,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoCodigoSriBanco();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoCodigoSriBanco(this.tipocodigosribanco)) {
				TipoCodigoSriBancoDataAccess.save(this.tipocodigosribanco, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipocodigosribanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoCodigoSriBancoLogicAdditional.checkTipoCodigoSriBancoToSaveAfter(this.tipocodigosribanco,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoCodigoSriBanco();
			
			connexion.commit();			
			
			if(this.tipocodigosribanco.getIsDeleted()) {
				this.tipocodigosribanco=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoCodigoSriBanco()throws Exception {	
		try {	
			
			TipoCodigoSriBancoLogicAdditional.checkTipoCodigoSriBancoToSave(this.tipocodigosribanco,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoCodigoSriBancoLogicAdditional.updateTipoCodigoSriBancoToSave(this.tipocodigosribanco,this.arrDatoGeneral);
			
			TipoCodigoSriBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipocodigosribanco,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoCodigoSriBanco(this.tipocodigosribanco)) {			
				TipoCodigoSriBancoDataAccess.save(this.tipocodigosribanco, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipocodigosribanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoCodigoSriBancoLogicAdditional.checkTipoCodigoSriBancoToSaveAfter(this.tipocodigosribanco,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipocodigosribanco.getIsDeleted()) {
				this.tipocodigosribanco=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoCodigoSriBancosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCodigoSriBanco.class.getSimpleName()+"-saveTipoCodigoSriBancosWithConnection");connexion.begin();			
			
			TipoCodigoSriBancoLogicAdditional.checkTipoCodigoSriBancoToSaves(tipocodigosribancos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoCodigoSriBancos();
			
			Boolean validadoTodosTipoCodigoSriBanco=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoCodigoSriBanco tipocodigosribancoLocal:tipocodigosribancos) {		
				if(tipocodigosribancoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoCodigoSriBancoLogicAdditional.updateTipoCodigoSriBancoToSave(tipocodigosribancoLocal,this.arrDatoGeneral);
	        	
				TipoCodigoSriBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipocodigosribancoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoCodigoSriBanco(tipocodigosribancoLocal)) {
					TipoCodigoSriBancoDataAccess.save(tipocodigosribancoLocal, connexion);				
				} else {
					validadoTodosTipoCodigoSriBanco=false;
				}
			}
			
			if(!validadoTodosTipoCodigoSriBanco) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoCodigoSriBancoLogicAdditional.checkTipoCodigoSriBancoToSavesAfter(tipocodigosribancos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoCodigoSriBancos();
			
			connexion.commit();		
			
			this.quitarTipoCodigoSriBancosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoCodigoSriBancos()throws Exception {				
		 try {	
			TipoCodigoSriBancoLogicAdditional.checkTipoCodigoSriBancoToSaves(tipocodigosribancos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoCodigoSriBanco=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoCodigoSriBanco tipocodigosribancoLocal:tipocodigosribancos) {				
				if(tipocodigosribancoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoCodigoSriBancoLogicAdditional.updateTipoCodigoSriBancoToSave(tipocodigosribancoLocal,this.arrDatoGeneral);
	        	
				TipoCodigoSriBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipocodigosribancoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoCodigoSriBanco(tipocodigosribancoLocal)) {				
					TipoCodigoSriBancoDataAccess.save(tipocodigosribancoLocal, connexion);				
				} else {
					validadoTodosTipoCodigoSriBanco=false;
				}
			}
			
			if(!validadoTodosTipoCodigoSriBanco) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoCodigoSriBancoLogicAdditional.checkTipoCodigoSriBancoToSavesAfter(tipocodigosribancos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoCodigoSriBancosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoCodigoSriBancoParameterReturnGeneral procesarAccionTipoCodigoSriBancos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoCodigoSriBanco> tipocodigosribancos,TipoCodigoSriBancoParameterReturnGeneral tipocodigosribancoParameterGeneral)throws Exception {
		 try {	
			TipoCodigoSriBancoParameterReturnGeneral tipocodigosribancoReturnGeneral=new TipoCodigoSriBancoParameterReturnGeneral();
	
			TipoCodigoSriBancoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipocodigosribancos,tipocodigosribancoParameterGeneral,tipocodigosribancoReturnGeneral);
			
			return tipocodigosribancoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoCodigoSriBancoParameterReturnGeneral procesarAccionTipoCodigoSriBancosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoCodigoSriBanco> tipocodigosribancos,TipoCodigoSriBancoParameterReturnGeneral tipocodigosribancoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCodigoSriBanco.class.getSimpleName()+"-procesarAccionTipoCodigoSriBancosWithConnection");connexion.begin();			
			
			TipoCodigoSriBancoParameterReturnGeneral tipocodigosribancoReturnGeneral=new TipoCodigoSriBancoParameterReturnGeneral();
	
			TipoCodigoSriBancoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipocodigosribancos,tipocodigosribancoParameterGeneral,tipocodigosribancoReturnGeneral);
			
			this.connexion.commit();
			
			return tipocodigosribancoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoCodigoSriBancoParameterReturnGeneral procesarEventosTipoCodigoSriBancos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoCodigoSriBanco> tipocodigosribancos,TipoCodigoSriBanco tipocodigosribanco,TipoCodigoSriBancoParameterReturnGeneral tipocodigosribancoParameterGeneral,Boolean isEsNuevoTipoCodigoSriBanco,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoCodigoSriBancoParameterReturnGeneral tipocodigosribancoReturnGeneral=new TipoCodigoSriBancoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipocodigosribancoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoCodigoSriBancoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipocodigosribancos,tipocodigosribanco,tipocodigosribancoParameterGeneral,tipocodigosribancoReturnGeneral,isEsNuevoTipoCodigoSriBanco,clases);
			
			return tipocodigosribancoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoCodigoSriBancoParameterReturnGeneral procesarEventosTipoCodigoSriBancosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoCodigoSriBanco> tipocodigosribancos,TipoCodigoSriBanco tipocodigosribanco,TipoCodigoSriBancoParameterReturnGeneral tipocodigosribancoParameterGeneral,Boolean isEsNuevoTipoCodigoSriBanco,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCodigoSriBanco.class.getSimpleName()+"-procesarEventosTipoCodigoSriBancosWithConnection");connexion.begin();			
			
			TipoCodigoSriBancoParameterReturnGeneral tipocodigosribancoReturnGeneral=new TipoCodigoSriBancoParameterReturnGeneral();
	
			tipocodigosribancoReturnGeneral.setTipoCodigoSriBanco(tipocodigosribanco);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipocodigosribancoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoCodigoSriBancoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipocodigosribancos,tipocodigosribanco,tipocodigosribancoParameterGeneral,tipocodigosribancoReturnGeneral,isEsNuevoTipoCodigoSriBanco,clases);
			
			this.connexion.commit();
			
			return tipocodigosribancoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoCodigoSriBancoParameterReturnGeneral procesarImportacionTipoCodigoSriBancosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoCodigoSriBancoParameterReturnGeneral tipocodigosribancoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCodigoSriBanco.class.getSimpleName()+"-procesarImportacionTipoCodigoSriBancosWithConnection");connexion.begin();			
			
			TipoCodigoSriBancoParameterReturnGeneral tipocodigosribancoReturnGeneral=new TipoCodigoSriBancoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipocodigosribancos=new ArrayList<TipoCodigoSriBanco>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipocodigosribanco=new TipoCodigoSriBanco();
				
				
				if(conColumnasBase) {this.tipocodigosribanco.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipocodigosribanco.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipocodigosribanco.setcodigo(arrColumnas[iColumn++]);
				this.tipocodigosribanco.setnombre(arrColumnas[iColumn++]);
				
				this.tipocodigosribancos.add(this.tipocodigosribanco);
			}
			
			this.saveTipoCodigoSriBancos();
			
			this.connexion.commit();
			
			tipocodigosribancoReturnGeneral.setConRetornoEstaProcesado(true);
			tipocodigosribancoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipocodigosribancoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoCodigoSriBancosEliminados() throws Exception {				
		
		List<TipoCodigoSriBanco> tipocodigosribancosAux= new ArrayList<TipoCodigoSriBanco>();
		
		for(TipoCodigoSriBanco tipocodigosribanco:tipocodigosribancos) {
			if(!tipocodigosribanco.getIsDeleted()) {
				tipocodigosribancosAux.add(tipocodigosribanco);
			}
		}
		
		tipocodigosribancos=tipocodigosribancosAux;
	}
	
	public void quitarTipoCodigoSriBancosNulos() throws Exception {				
		
		List<TipoCodigoSriBanco> tipocodigosribancosAux= new ArrayList<TipoCodigoSriBanco>();
		
		for(TipoCodigoSriBanco tipocodigosribanco : this.tipocodigosribancos) {
			if(tipocodigosribanco==null) {
				tipocodigosribancosAux.add(tipocodigosribanco);
			}
		}
		
		//this.tipocodigosribancos=tipocodigosribancosAux;
		
		this.tipocodigosribancos.removeAll(tipocodigosribancosAux);
	}
	
	public void getSetVersionRowTipoCodigoSriBancoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipocodigosribanco.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipocodigosribanco.getIsDeleted() || (tipocodigosribanco.getIsChanged()&&!tipocodigosribanco.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipocodigosribancoDataAccess.getSetVersionRowTipoCodigoSriBanco(connexion,tipocodigosribanco.getId());
				
				if(!tipocodigosribanco.getVersionRow().equals(timestamp)) {	
					tipocodigosribanco.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipocodigosribanco.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoCodigoSriBanco()throws Exception {	
		
		if(tipocodigosribanco.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipocodigosribanco.getIsDeleted() || (tipocodigosribanco.getIsChanged()&&!tipocodigosribanco.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipocodigosribancoDataAccess.getSetVersionRowTipoCodigoSriBanco(connexion,tipocodigosribanco.getId());
			
			try {							
				if(!tipocodigosribanco.getVersionRow().equals(timestamp)) {	
					tipocodigosribanco.setVersionRow(timestamp);
				}
				
				tipocodigosribanco.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoCodigoSriBancosWithConnection()throws Exception {	
		if(tipocodigosribancos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoCodigoSriBanco tipocodigosribancoAux:tipocodigosribancos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipocodigosribancoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipocodigosribancoAux.getIsDeleted() || (tipocodigosribancoAux.getIsChanged()&&!tipocodigosribancoAux.getIsNew())) {
						
						timestamp=tipocodigosribancoDataAccess.getSetVersionRowTipoCodigoSriBanco(connexion,tipocodigosribancoAux.getId());
						
						if(!tipocodigosribanco.getVersionRow().equals(timestamp)) {	
							tipocodigosribancoAux.setVersionRow(timestamp);
						}
								
						tipocodigosribancoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoCodigoSriBancos()throws Exception {	
		if(tipocodigosribancos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoCodigoSriBanco tipocodigosribancoAux:tipocodigosribancos) {
					if(tipocodigosribancoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipocodigosribancoAux.getIsDeleted() || (tipocodigosribancoAux.getIsChanged()&&!tipocodigosribancoAux.getIsNew())) {
						
						timestamp=tipocodigosribancoDataAccess.getSetVersionRowTipoCodigoSriBanco(connexion,tipocodigosribancoAux.getId());
						
						if(!tipocodigosribancoAux.getVersionRow().equals(timestamp)) {	
							tipocodigosribancoAux.setVersionRow(timestamp);
						}
						
													
						tipocodigosribancoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	
	public void deepLoad(TipoCodigoSriBanco tipocodigosribanco,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		
		
		try {
			TipoCodigoSriBancoLogicAdditional.updateTipoCodigoSriBancoToGet(tipocodigosribanco,this.arrDatoGeneral);
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoCodigoSriBanco tipocodigosribanco,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
				
		try {
			TipoCodigoSriBancoLogicAdditional.updateTipoCodigoSriBancoToSave(tipocodigosribanco,this.arrDatoGeneral);
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoCodigoSriBanco.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipocodigosribanco,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoCodigoSriBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoSriBanco(tipocodigosribanco);
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
			this.deepLoad(this.tipocodigosribanco,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoCodigoSriBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoSriBanco(this.tipocodigosribanco);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoCodigoSriBanco.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipocodigosribancos!=null) {
				for(TipoCodigoSriBanco tipocodigosribanco:tipocodigosribancos) {
					this.deepLoad(tipocodigosribanco,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoCodigoSriBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoSriBanco(tipocodigosribancos);
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
			if(tipocodigosribancos!=null) {
				for(TipoCodigoSriBanco tipocodigosribanco:tipocodigosribancos) {
					this.deepLoad(tipocodigosribanco,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoCodigoSriBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCodigoSriBanco(tipocodigosribancos);
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
			this.getNewConnexionToDeep(TipoCodigoSriBanco.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipocodigosribanco,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoCodigoSriBanco.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipocodigosribancos!=null) {
				for(TipoCodigoSriBanco tipocodigosribanco:tipocodigosribancos) {
					this.deepSave(tipocodigosribanco,isDeep,deepLoadType,clases);
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
			if(tipocodigosribancos!=null) {
				for(TipoCodigoSriBanco tipocodigosribanco:tipocodigosribancos) {
					this.deepSave(tipocodigosribanco,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoCodigoSriBancoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCodigoSriBancoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoCodigoSriBanco tipocodigosribanco,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoCodigoSriBancoConstantesFunciones.ISCONAUDITORIA) {
				if(tipocodigosribanco.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCodigoSriBancoDataAccess.TABLENAME, tipocodigosribanco.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoCodigoSriBancoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoCodigoSriBancoLogic.registrarAuditoriaDetallesTipoCodigoSriBanco(connexion,tipocodigosribanco,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipocodigosribanco.getIsDeleted()) {
					/*if(!tipocodigosribanco.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoCodigoSriBancoDataAccess.TABLENAME, tipocodigosribanco.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoCodigoSriBancoLogic.registrarAuditoriaDetallesTipoCodigoSriBanco(connexion,tipocodigosribanco,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCodigoSriBancoDataAccess.TABLENAME, tipocodigosribanco.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipocodigosribanco.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCodigoSriBancoDataAccess.TABLENAME, tipocodigosribanco.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoCodigoSriBancoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoCodigoSriBancoLogic.registrarAuditoriaDetallesTipoCodigoSriBanco(connexion,tipocodigosribanco,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoCodigoSriBanco(Connexion connexion,TipoCodigoSriBanco tipocodigosribanco)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipocodigosribanco.getIsNew()||!tipocodigosribanco.getcodigo().equals(tipocodigosribanco.getTipoCodigoSriBancoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocodigosribanco.getTipoCodigoSriBancoOriginal().getcodigo()!=null)
				{
					strValorActual=tipocodigosribanco.getTipoCodigoSriBancoOriginal().getcodigo();
				}
				if(tipocodigosribanco.getcodigo()!=null)
				{
					strValorNuevo=tipocodigosribanco.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoCodigoSriBancoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipocodigosribanco.getIsNew()||!tipocodigosribanco.getnombre().equals(tipocodigosribanco.getTipoCodigoSriBancoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocodigosribanco.getTipoCodigoSriBancoOriginal().getnombre()!=null)
				{
					strValorActual=tipocodigosribanco.getTipoCodigoSriBancoOriginal().getnombre();
				}
				if(tipocodigosribanco.getnombre()!=null)
				{
					strValorNuevo=tipocodigosribanco.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoCodigoSriBancoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoCodigoSriBancoRelacionesWithConnection(TipoCodigoSriBanco tipocodigosribanco) throws Exception {

		if(!tipocodigosribanco.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoCodigoSriBancoRelacionesBase(tipocodigosribanco,true);
		}
	}

	public void saveTipoCodigoSriBancoRelaciones(TipoCodigoSriBanco tipocodigosribanco)throws Exception {

		if(!tipocodigosribanco.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoCodigoSriBancoRelacionesBase(tipocodigosribanco,false);
		}
	}

	public void saveTipoCodigoSriBancoRelacionesBase(TipoCodigoSriBanco tipocodigosribanco,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoCodigoSriBanco-saveRelacionesWithConnection");}
	

			this.setTipoCodigoSriBanco(tipocodigosribanco);

				if((tipocodigosribanco.getIsNew()||tipocodigosribanco.getIsChanged())&&!tipocodigosribanco.getIsDeleted()) {
					this.saveTipoCodigoSriBanco();
					this.saveTipoCodigoSriBancoRelacionesDetalles();

				} else if(tipocodigosribanco.getIsDeleted()) {
					this.saveTipoCodigoSriBancoRelacionesDetalles();
					this.saveTipoCodigoSriBanco();
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
	
	
	private void saveTipoCodigoSriBancoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoCodigoSriBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoCodigoSriBancoConstantesFunciones.getClassesForeignKeysOfTipoCodigoSriBanco(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCodigoSriBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoCodigoSriBancoConstantesFunciones.getClassesRelationshipsOfTipoCodigoSriBanco(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

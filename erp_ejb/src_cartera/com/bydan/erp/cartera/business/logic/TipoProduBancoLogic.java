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
import com.bydan.erp.cartera.util.TipoProduBancoConstantesFunciones;
import com.bydan.erp.cartera.util.TipoProduBancoParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoProduBancoParameterGeneral;
import com.bydan.erp.cartera.business.entity.TipoProduBanco;
import com.bydan.erp.cartera.business.logic.TipoProduBancoLogicAdditional;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.cartera.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class TipoProduBancoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoProduBancoLogic.class);
	
	protected TipoProduBancoDataAccess tipoprodubancoDataAccess; 	
	protected TipoProduBanco tipoprodubanco;
	protected List<TipoProduBanco> tipoprodubancos;
	protected Object tipoprodubancoObject;	
	protected List<Object> tipoprodubancosObject;
	
	public static ClassValidator<TipoProduBanco> tipoprodubancoValidator = new ClassValidator<TipoProduBanco>(TipoProduBanco.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoProduBancoLogicAdditional tipoprodubancoLogicAdditional=null;
	
	public TipoProduBancoLogicAdditional getTipoProduBancoLogicAdditional() {
		return this.tipoprodubancoLogicAdditional;
	}
	
	public void setTipoProduBancoLogicAdditional(TipoProduBancoLogicAdditional tipoprodubancoLogicAdditional) {
		try {
			this.tipoprodubancoLogicAdditional=tipoprodubancoLogicAdditional;
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
	
	
	
	
	public  TipoProduBancoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoprodubancoDataAccess = new TipoProduBancoDataAccess();
			
			this.tipoprodubancos= new ArrayList<TipoProduBanco>();
			this.tipoprodubanco= new TipoProduBanco();
			
			this.tipoprodubancoObject=new Object();
			this.tipoprodubancosObject=new ArrayList<Object>();
				
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
			
			this.tipoprodubancoDataAccess.setConnexionType(this.connexionType);
			this.tipoprodubancoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoProduBancoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoprodubancoDataAccess = new TipoProduBancoDataAccess();
			this.tipoprodubancos= new ArrayList<TipoProduBanco>();
			this.tipoprodubanco= new TipoProduBanco();
			this.tipoprodubancoObject=new Object();
			this.tipoprodubancosObject=new ArrayList<Object>();
			
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
			
			this.tipoprodubancoDataAccess.setConnexionType(this.connexionType);
			this.tipoprodubancoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoProduBanco getTipoProduBanco() throws Exception {	
		TipoProduBancoLogicAdditional.checkTipoProduBancoToGet(tipoprodubanco,this.datosCliente,this.arrDatoGeneral);
		TipoProduBancoLogicAdditional.updateTipoProduBancoToGet(tipoprodubanco,this.arrDatoGeneral);
		
		return tipoprodubanco;
	}
		
	public void setTipoProduBanco(TipoProduBanco newTipoProduBanco) {
		this.tipoprodubanco = newTipoProduBanco;
	}
	
	public TipoProduBancoDataAccess getTipoProduBancoDataAccess() {
		return tipoprodubancoDataAccess;
	}
	
	public void setTipoProduBancoDataAccess(TipoProduBancoDataAccess newtipoprodubancoDataAccess) {
		this.tipoprodubancoDataAccess = newtipoprodubancoDataAccess;
	}
	
	public List<TipoProduBanco> getTipoProduBancos() throws Exception {		
		this.quitarTipoProduBancosNulos();
		
		TipoProduBancoLogicAdditional.checkTipoProduBancoToGets(tipoprodubancos,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoProduBanco tipoprodubancoLocal: tipoprodubancos ) {
			TipoProduBancoLogicAdditional.updateTipoProduBancoToGet(tipoprodubancoLocal,this.arrDatoGeneral);
		}
		
		return tipoprodubancos;
	}
	
	public void setTipoProduBancos(List<TipoProduBanco> newTipoProduBancos) {
		this.tipoprodubancos = newTipoProduBancos;
	}
	
	public Object getTipoProduBancoObject() {	
		this.tipoprodubancoObject=this.tipoprodubancoDataAccess.getEntityObject();
		return this.tipoprodubancoObject;
	}
		
	public void setTipoProduBancoObject(Object newTipoProduBancoObject) {
		this.tipoprodubancoObject = newTipoProduBancoObject;
	}
	
	public List<Object> getTipoProduBancosObject() {		
		this.tipoprodubancosObject=this.tipoprodubancoDataAccess.getEntitiesObject();
		return this.tipoprodubancosObject;
	}
		
	public void setTipoProduBancosObject(List<Object> newTipoProduBancosObject) {
		this.tipoprodubancosObject = newTipoProduBancosObject;
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
		
		if(this.tipoprodubancoDataAccess!=null) {
			this.tipoprodubancoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProduBanco.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoprodubancoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoprodubancoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoprodubanco = new  TipoProduBanco();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProduBanco.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoprodubanco=tipoprodubancoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoprodubanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoProduBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProduBanco(this.tipoprodubanco);
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
		tipoprodubanco = new  TipoProduBanco();
		  		  
        try {
			
			tipoprodubanco=tipoprodubancoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoprodubanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoProduBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProduBanco(this.tipoprodubanco);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoprodubanco = new  TipoProduBanco();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProduBanco.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoprodubanco=tipoprodubancoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoprodubanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoProduBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProduBanco(this.tipoprodubanco);
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
		tipoprodubanco = new  TipoProduBanco();
		  		  
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
		tipoprodubanco = new  TipoProduBanco();
		  		  
        try {
			
			tipoprodubanco=tipoprodubancoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoprodubanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoProduBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProduBanco(this.tipoprodubanco);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoprodubanco = new  TipoProduBanco();
		  		  
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
		tipoprodubanco = new  TipoProduBanco();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProduBanco.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoprodubancoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoprodubanco = new  TipoProduBanco();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoprodubancoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoprodubanco = new  TipoProduBanco();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProduBanco.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoprodubancoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoprodubanco = new  TipoProduBanco();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoprodubancoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoprodubanco = new  TipoProduBanco();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProduBanco.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoprodubancoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoprodubanco = new  TipoProduBanco();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoprodubancoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoprodubancos = new  ArrayList<TipoProduBanco>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProduBanco.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoProduBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprodubancos=tipoprodubancoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoProduBanco(tipoprodubancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProduBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProduBanco(this.tipoprodubancos);
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
		tipoprodubancos = new  ArrayList<TipoProduBanco>();
		  		  
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
		tipoprodubancos = new  ArrayList<TipoProduBanco>();
		  		  
        try {			
			TipoProduBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprodubancos=tipoprodubancoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoProduBanco(tipoprodubancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProduBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProduBanco(this.tipoprodubancos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoprodubancos = new  ArrayList<TipoProduBanco>();
		  		  
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
		tipoprodubancos = new  ArrayList<TipoProduBanco>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProduBanco.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoProduBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprodubancos=tipoprodubancoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoProduBanco(tipoprodubancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProduBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProduBanco(this.tipoprodubancos);
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
		tipoprodubancos = new  ArrayList<TipoProduBanco>();
		  		  
        try {
			TipoProduBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprodubancos=tipoprodubancoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoProduBanco(tipoprodubancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProduBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProduBanco(this.tipoprodubancos);
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
		tipoprodubancos = new  ArrayList<TipoProduBanco>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProduBanco.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProduBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprodubancos=tipoprodubancoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoProduBanco(tipoprodubancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProduBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProduBanco(this.tipoprodubancos);
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
		tipoprodubancos = new  ArrayList<TipoProduBanco>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProduBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprodubancos=tipoprodubancoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoProduBanco(tipoprodubancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProduBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProduBanco(this.tipoprodubancos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoprodubanco = new  TipoProduBanco();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProduBanco.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProduBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprodubanco=tipoprodubancoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoProduBanco(tipoprodubanco);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProduBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProduBanco(this.tipoprodubanco);
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
		tipoprodubanco = new  TipoProduBanco();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProduBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprodubanco=tipoprodubancoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoProduBanco(tipoprodubanco);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProduBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProduBanco(this.tipoprodubanco);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoprodubancos = new  ArrayList<TipoProduBanco>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProduBanco.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoProduBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprodubancos=tipoprodubancoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoProduBanco(tipoprodubancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProduBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProduBanco(this.tipoprodubancos);
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
		tipoprodubancos = new  ArrayList<TipoProduBanco>();
		  		  
        try {
			TipoProduBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprodubancos=tipoprodubancoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoProduBanco(tipoprodubancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProduBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProduBanco(this.tipoprodubancos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoProduBancosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoprodubancos = new  ArrayList<TipoProduBanco>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProduBanco.class.getSimpleName()+"-getTodosTipoProduBancosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProduBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprodubancos=tipoprodubancoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoProduBanco(tipoprodubancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProduBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProduBanco(this.tipoprodubancos);
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
	
	public  void  getTodosTipoProduBancos(String sFinalQuery,Pagination pagination)throws Exception {
		tipoprodubancos = new  ArrayList<TipoProduBanco>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProduBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprodubancos=tipoprodubancoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoProduBanco(tipoprodubancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProduBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProduBanco(this.tipoprodubancos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoProduBanco(TipoProduBanco tipoprodubanco) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoprodubanco.getIsNew() || tipoprodubanco.getIsChanged()) { 
			this.invalidValues = tipoprodubancoValidator.getInvalidValues(tipoprodubanco);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoprodubanco);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoProduBanco(List<TipoProduBanco> TipoProduBancos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoProduBanco tipoprodubancoLocal:tipoprodubancos) {				
			estaValidadoObjeto=this.validarGuardarTipoProduBanco(tipoprodubancoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoProduBanco(List<TipoProduBanco> TipoProduBancos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoProduBanco(tipoprodubancos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoProduBanco(TipoProduBanco TipoProduBanco) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoProduBanco(tipoprodubanco)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoProduBanco tipoprodubanco) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoprodubanco.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoProduBancoConstantesFunciones.getTipoProduBancoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoprodubanco","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoProduBancoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoProduBancoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoProduBancoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProduBanco.class.getSimpleName()+"-saveTipoProduBancoWithConnection");connexion.begin();			
			
			TipoProduBancoLogicAdditional.checkTipoProduBancoToSave(this.tipoprodubanco,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoProduBancoLogicAdditional.updateTipoProduBancoToSave(this.tipoprodubanco,this.arrDatoGeneral);
			
			TipoProduBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoprodubanco,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoProduBanco();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoProduBanco(this.tipoprodubanco)) {
				TipoProduBancoDataAccess.save(this.tipoprodubanco, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoprodubanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoProduBancoLogicAdditional.checkTipoProduBancoToSaveAfter(this.tipoprodubanco,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoProduBanco();
			
			connexion.commit();			
			
			if(this.tipoprodubanco.getIsDeleted()) {
				this.tipoprodubanco=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoProduBanco()throws Exception {	
		try {	
			
			TipoProduBancoLogicAdditional.checkTipoProduBancoToSave(this.tipoprodubanco,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoProduBancoLogicAdditional.updateTipoProduBancoToSave(this.tipoprodubanco,this.arrDatoGeneral);
			
			TipoProduBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoprodubanco,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoProduBanco(this.tipoprodubanco)) {			
				TipoProduBancoDataAccess.save(this.tipoprodubanco, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoprodubanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoProduBancoLogicAdditional.checkTipoProduBancoToSaveAfter(this.tipoprodubanco,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoprodubanco.getIsDeleted()) {
				this.tipoprodubanco=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoProduBancosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProduBanco.class.getSimpleName()+"-saveTipoProduBancosWithConnection");connexion.begin();			
			
			TipoProduBancoLogicAdditional.checkTipoProduBancoToSaves(tipoprodubancos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoProduBancos();
			
			Boolean validadoTodosTipoProduBanco=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoProduBanco tipoprodubancoLocal:tipoprodubancos) {		
				if(tipoprodubancoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoProduBancoLogicAdditional.updateTipoProduBancoToSave(tipoprodubancoLocal,this.arrDatoGeneral);
	        	
				TipoProduBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoprodubancoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoProduBanco(tipoprodubancoLocal)) {
					TipoProduBancoDataAccess.save(tipoprodubancoLocal, connexion);				
				} else {
					validadoTodosTipoProduBanco=false;
				}
			}
			
			if(!validadoTodosTipoProduBanco) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoProduBancoLogicAdditional.checkTipoProduBancoToSavesAfter(tipoprodubancos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoProduBancos();
			
			connexion.commit();		
			
			this.quitarTipoProduBancosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoProduBancos()throws Exception {				
		 try {	
			TipoProduBancoLogicAdditional.checkTipoProduBancoToSaves(tipoprodubancos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoProduBanco=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoProduBanco tipoprodubancoLocal:tipoprodubancos) {				
				if(tipoprodubancoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoProduBancoLogicAdditional.updateTipoProduBancoToSave(tipoprodubancoLocal,this.arrDatoGeneral);
	        	
				TipoProduBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoprodubancoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoProduBanco(tipoprodubancoLocal)) {				
					TipoProduBancoDataAccess.save(tipoprodubancoLocal, connexion);				
				} else {
					validadoTodosTipoProduBanco=false;
				}
			}
			
			if(!validadoTodosTipoProduBanco) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoProduBancoLogicAdditional.checkTipoProduBancoToSavesAfter(tipoprodubancos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoProduBancosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoProduBancoParameterReturnGeneral procesarAccionTipoProduBancos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoProduBanco> tipoprodubancos,TipoProduBancoParameterReturnGeneral tipoprodubancoParameterGeneral)throws Exception {
		 try {	
			TipoProduBancoParameterReturnGeneral tipoprodubancoReturnGeneral=new TipoProduBancoParameterReturnGeneral();
	
			TipoProduBancoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoprodubancos,tipoprodubancoParameterGeneral,tipoprodubancoReturnGeneral);
			
			return tipoprodubancoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoProduBancoParameterReturnGeneral procesarAccionTipoProduBancosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoProduBanco> tipoprodubancos,TipoProduBancoParameterReturnGeneral tipoprodubancoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProduBanco.class.getSimpleName()+"-procesarAccionTipoProduBancosWithConnection");connexion.begin();			
			
			TipoProduBancoParameterReturnGeneral tipoprodubancoReturnGeneral=new TipoProduBancoParameterReturnGeneral();
	
			TipoProduBancoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoprodubancos,tipoprodubancoParameterGeneral,tipoprodubancoReturnGeneral);
			
			this.connexion.commit();
			
			return tipoprodubancoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoProduBancoParameterReturnGeneral procesarEventosTipoProduBancos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoProduBanco> tipoprodubancos,TipoProduBanco tipoprodubanco,TipoProduBancoParameterReturnGeneral tipoprodubancoParameterGeneral,Boolean isEsNuevoTipoProduBanco,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoProduBancoParameterReturnGeneral tipoprodubancoReturnGeneral=new TipoProduBancoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoprodubancoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoProduBancoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoprodubancos,tipoprodubanco,tipoprodubancoParameterGeneral,tipoprodubancoReturnGeneral,isEsNuevoTipoProduBanco,clases);
			
			return tipoprodubancoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoProduBancoParameterReturnGeneral procesarEventosTipoProduBancosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoProduBanco> tipoprodubancos,TipoProduBanco tipoprodubanco,TipoProduBancoParameterReturnGeneral tipoprodubancoParameterGeneral,Boolean isEsNuevoTipoProduBanco,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProduBanco.class.getSimpleName()+"-procesarEventosTipoProduBancosWithConnection");connexion.begin();			
			
			TipoProduBancoParameterReturnGeneral tipoprodubancoReturnGeneral=new TipoProduBancoParameterReturnGeneral();
	
			tipoprodubancoReturnGeneral.setTipoProduBanco(tipoprodubanco);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoprodubancoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoProduBancoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoprodubancos,tipoprodubanco,tipoprodubancoParameterGeneral,tipoprodubancoReturnGeneral,isEsNuevoTipoProduBanco,clases);
			
			this.connexion.commit();
			
			return tipoprodubancoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoProduBancoParameterReturnGeneral procesarImportacionTipoProduBancosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoProduBancoParameterReturnGeneral tipoprodubancoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProduBanco.class.getSimpleName()+"-procesarImportacionTipoProduBancosWithConnection");connexion.begin();			
			
			TipoProduBancoParameterReturnGeneral tipoprodubancoReturnGeneral=new TipoProduBancoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoprodubancos=new ArrayList<TipoProduBanco>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoprodubanco=new TipoProduBanco();
				
				
				if(conColumnasBase) {this.tipoprodubanco.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoprodubanco.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoprodubanco.setcodigo(arrColumnas[iColumn++]);
				this.tipoprodubanco.setnombre(arrColumnas[iColumn++]);
				
				this.tipoprodubancos.add(this.tipoprodubanco);
			}
			
			this.saveTipoProduBancos();
			
			this.connexion.commit();
			
			tipoprodubancoReturnGeneral.setConRetornoEstaProcesado(true);
			tipoprodubancoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoprodubancoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoProduBancosEliminados() throws Exception {				
		
		List<TipoProduBanco> tipoprodubancosAux= new ArrayList<TipoProduBanco>();
		
		for(TipoProduBanco tipoprodubanco:tipoprodubancos) {
			if(!tipoprodubanco.getIsDeleted()) {
				tipoprodubancosAux.add(tipoprodubanco);
			}
		}
		
		tipoprodubancos=tipoprodubancosAux;
	}
	
	public void quitarTipoProduBancosNulos() throws Exception {				
		
		List<TipoProduBanco> tipoprodubancosAux= new ArrayList<TipoProduBanco>();
		
		for(TipoProduBanco tipoprodubanco : this.tipoprodubancos) {
			if(tipoprodubanco==null) {
				tipoprodubancosAux.add(tipoprodubanco);
			}
		}
		
		//this.tipoprodubancos=tipoprodubancosAux;
		
		this.tipoprodubancos.removeAll(tipoprodubancosAux);
	}
	
	public void getSetVersionRowTipoProduBancoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoprodubanco.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoprodubanco.getIsDeleted() || (tipoprodubanco.getIsChanged()&&!tipoprodubanco.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoprodubancoDataAccess.getSetVersionRowTipoProduBanco(connexion,tipoprodubanco.getId());
				
				if(!tipoprodubanco.getVersionRow().equals(timestamp)) {	
					tipoprodubanco.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoprodubanco.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoProduBanco()throws Exception {	
		
		if(tipoprodubanco.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoprodubanco.getIsDeleted() || (tipoprodubanco.getIsChanged()&&!tipoprodubanco.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoprodubancoDataAccess.getSetVersionRowTipoProduBanco(connexion,tipoprodubanco.getId());
			
			try {							
				if(!tipoprodubanco.getVersionRow().equals(timestamp)) {	
					tipoprodubanco.setVersionRow(timestamp);
				}
				
				tipoprodubanco.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoProduBancosWithConnection()throws Exception {	
		if(tipoprodubancos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoProduBanco tipoprodubancoAux:tipoprodubancos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoprodubancoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoprodubancoAux.getIsDeleted() || (tipoprodubancoAux.getIsChanged()&&!tipoprodubancoAux.getIsNew())) {
						
						timestamp=tipoprodubancoDataAccess.getSetVersionRowTipoProduBanco(connexion,tipoprodubancoAux.getId());
						
						if(!tipoprodubanco.getVersionRow().equals(timestamp)) {	
							tipoprodubancoAux.setVersionRow(timestamp);
						}
								
						tipoprodubancoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoProduBancos()throws Exception {	
		if(tipoprodubancos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoProduBanco tipoprodubancoAux:tipoprodubancos) {
					if(tipoprodubancoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoprodubancoAux.getIsDeleted() || (tipoprodubancoAux.getIsChanged()&&!tipoprodubancoAux.getIsNew())) {
						
						timestamp=tipoprodubancoDataAccess.getSetVersionRowTipoProduBanco(connexion,tipoprodubancoAux.getId());
						
						if(!tipoprodubancoAux.getVersionRow().equals(timestamp)) {	
							tipoprodubancoAux.setVersionRow(timestamp);
						}
						
													
						tipoprodubancoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyTipoProduBancoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ReferenciaBancariaLogic referenciabancariaLogic=new ReferenciaBancariaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProduBanco.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoProduBancoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(ReferenciaBancaria.class));
											
			

			referenciabancariaLogic.setConnexion(this.getConnexion());
			referenciabancariaLogic.setDatosCliente(this.datosCliente);
			referenciabancariaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoProduBanco tipoprodubanco:this.tipoprodubancos) {
				

				classes=new ArrayList<Classe>();
				classes=ReferenciaBancariaConstantesFunciones.getClassesForeignKeysOfReferenciaBancaria(new ArrayList<Classe>(),DeepLoadType.NONE);

				referenciabancariaLogic.setReferenciaBancarias(tipoprodubanco.referenciabancarias);
				referenciabancariaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoProduBanco tipoprodubanco,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoProduBancoLogicAdditional.updateTipoProduBancoToGet(tipoprodubanco,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoprodubanco.setReferenciaBancarias(tipoprodubancoDataAccess.getReferenciaBancarias(connexion,tipoprodubanco));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ReferenciaBancaria.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprodubanco.setReferenciaBancarias(tipoprodubancoDataAccess.getReferenciaBancarias(connexion,tipoprodubanco));

				if(this.isConDeep) {
					ReferenciaBancariaLogic referenciabancariaLogic= new ReferenciaBancariaLogic(this.connexion);
					referenciabancariaLogic.setReferenciaBancarias(tipoprodubanco.getReferenciaBancarias());
					ArrayList<Classe> classesLocal=ReferenciaBancariaConstantesFunciones.getClassesForeignKeysOfReferenciaBancaria(new ArrayList<Classe>(),DeepLoadType.NONE);
					referenciabancariaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ReferenciaBancariaConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaBancaria(referenciabancariaLogic.getReferenciaBancarias());
					tipoprodubanco.setReferenciaBancarias(referenciabancariaLogic.getReferenciaBancarias());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ReferenciaBancaria.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ReferenciaBancaria.class));
			tipoprodubanco.setReferenciaBancarias(tipoprodubancoDataAccess.getReferenciaBancarias(connexion,tipoprodubanco));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		tipoprodubanco.setReferenciaBancarias(tipoprodubancoDataAccess.getReferenciaBancarias(connexion,tipoprodubanco));

		for(ReferenciaBancaria referenciabancaria:tipoprodubanco.getReferenciaBancarias()) {
			ReferenciaBancariaLogic referenciabancariaLogic= new ReferenciaBancariaLogic(connexion);
			referenciabancariaLogic.deepLoad(referenciabancaria,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ReferenciaBancaria.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprodubanco.setReferenciaBancarias(tipoprodubancoDataAccess.getReferenciaBancarias(connexion,tipoprodubanco));

				for(ReferenciaBancaria referenciabancaria:tipoprodubanco.getReferenciaBancarias()) {
					ReferenciaBancariaLogic referenciabancariaLogic= new ReferenciaBancariaLogic(connexion);
					referenciabancariaLogic.deepLoad(referenciabancaria,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ReferenciaBancaria.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ReferenciaBancaria.class));
			tipoprodubanco.setReferenciaBancarias(tipoprodubancoDataAccess.getReferenciaBancarias(connexion,tipoprodubanco));

			for(ReferenciaBancaria referenciabancaria:tipoprodubanco.getReferenciaBancarias()) {
				ReferenciaBancariaLogic referenciabancariaLogic= new ReferenciaBancariaLogic(connexion);
				referenciabancariaLogic.deepLoad(referenciabancaria,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoProduBanco tipoprodubanco,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoProduBancoLogicAdditional.updateTipoProduBancoToSave(tipoprodubanco,this.arrDatoGeneral);
			
TipoProduBancoDataAccess.save(tipoprodubanco, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(ReferenciaBancaria referenciabancaria:tipoprodubanco.getReferenciaBancarias()) {
			referenciabancaria.setidvalorclienteproductobanco(tipoprodubanco.getId());
			ReferenciaBancariaDataAccess.save(referenciabancaria,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(ReferenciaBancaria.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ReferenciaBancaria referenciabancaria:tipoprodubanco.getReferenciaBancarias()) {
					referenciabancaria.setidvalorclienteproductobanco(tipoprodubanco.getId());
					ReferenciaBancariaDataAccess.save(referenciabancaria,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(ReferenciaBancaria referenciabancaria:tipoprodubanco.getReferenciaBancarias()) {
			ReferenciaBancariaLogic referenciabancariaLogic= new ReferenciaBancariaLogic(connexion);
			referenciabancaria.setidvalorclienteproductobanco(tipoprodubanco.getId());
			ReferenciaBancariaDataAccess.save(referenciabancaria,connexion);
			referenciabancariaLogic.deepSave(referenciabancaria,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(ReferenciaBancaria.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ReferenciaBancaria referenciabancaria:tipoprodubanco.getReferenciaBancarias()) {
					ReferenciaBancariaLogic referenciabancariaLogic= new ReferenciaBancariaLogic(connexion);
					referenciabancaria.setidvalorclienteproductobanco(tipoprodubanco.getId());
					ReferenciaBancariaDataAccess.save(referenciabancaria,connexion);
					referenciabancariaLogic.deepSave(referenciabancaria,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoProduBanco.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoprodubanco,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoProduBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProduBanco(tipoprodubanco);
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
			this.deepLoad(this.tipoprodubanco,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoProduBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProduBanco(this.tipoprodubanco);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoProduBanco.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoprodubancos!=null) {
				for(TipoProduBanco tipoprodubanco:tipoprodubancos) {
					this.deepLoad(tipoprodubanco,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoProduBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProduBanco(tipoprodubancos);
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
			if(tipoprodubancos!=null) {
				for(TipoProduBanco tipoprodubanco:tipoprodubancos) {
					this.deepLoad(tipoprodubanco,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoProduBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProduBanco(tipoprodubancos);
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
			this.getNewConnexionToDeep(TipoProduBanco.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipoprodubanco,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoProduBanco.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipoprodubancos!=null) {
				for(TipoProduBanco tipoprodubanco:tipoprodubancos) {
					this.deepSave(tipoprodubanco,isDeep,deepLoadType,clases);
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
			if(tipoprodubancos!=null) {
				for(TipoProduBanco tipoprodubanco:tipoprodubancos) {
					this.deepSave(tipoprodubanco,isDeep,deepLoadType,clases);
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
			if(TipoProduBancoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoProduBancoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoProduBanco tipoprodubanco,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoProduBancoConstantesFunciones.ISCONAUDITORIA) {
				if(tipoprodubanco.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoProduBancoDataAccess.TABLENAME, tipoprodubanco.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoProduBancoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoProduBancoLogic.registrarAuditoriaDetallesTipoProduBanco(connexion,tipoprodubanco,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoprodubanco.getIsDeleted()) {
					/*if(!tipoprodubanco.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoProduBancoDataAccess.TABLENAME, tipoprodubanco.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoProduBancoLogic.registrarAuditoriaDetallesTipoProduBanco(connexion,tipoprodubanco,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoProduBancoDataAccess.TABLENAME, tipoprodubanco.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoprodubanco.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoProduBancoDataAccess.TABLENAME, tipoprodubanco.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoProduBancoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoProduBancoLogic.registrarAuditoriaDetallesTipoProduBanco(connexion,tipoprodubanco,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoProduBanco(Connexion connexion,TipoProduBanco tipoprodubanco)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoprodubanco.getIsNew()||!tipoprodubanco.getcodigo().equals(tipoprodubanco.getTipoProduBancoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoprodubanco.getTipoProduBancoOriginal().getcodigo()!=null)
				{
					strValorActual=tipoprodubanco.getTipoProduBancoOriginal().getcodigo();
				}
				if(tipoprodubanco.getcodigo()!=null)
				{
					strValorNuevo=tipoprodubanco.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoProduBancoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipoprodubanco.getIsNew()||!tipoprodubanco.getnombre().equals(tipoprodubanco.getTipoProduBancoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoprodubanco.getTipoProduBancoOriginal().getnombre()!=null)
				{
					strValorActual=tipoprodubanco.getTipoProduBancoOriginal().getnombre();
				}
				if(tipoprodubanco.getnombre()!=null)
				{
					strValorNuevo=tipoprodubanco.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoProduBancoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoProduBancoRelacionesWithConnection(TipoProduBanco tipoprodubanco,List<ReferenciaBancaria> referenciabancarias) throws Exception {

		if(!tipoprodubanco.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoProduBancoRelacionesBase(tipoprodubanco,referenciabancarias,true);
		}
	}

	public void saveTipoProduBancoRelaciones(TipoProduBanco tipoprodubanco,List<ReferenciaBancaria> referenciabancarias)throws Exception {

		if(!tipoprodubanco.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoProduBancoRelacionesBase(tipoprodubanco,referenciabancarias,false);
		}
	}

	public void saveTipoProduBancoRelacionesBase(TipoProduBanco tipoprodubanco,List<ReferenciaBancaria> referenciabancarias,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoProduBanco-saveRelacionesWithConnection");}
	
			tipoprodubanco.setReferenciaBancarias(referenciabancarias);

			this.setTipoProduBanco(tipoprodubanco);

				if((tipoprodubanco.getIsNew()||tipoprodubanco.getIsChanged())&&!tipoprodubanco.getIsDeleted()) {
					this.saveTipoProduBanco();
					this.saveTipoProduBancoRelacionesDetalles(referenciabancarias);

				} else if(tipoprodubanco.getIsDeleted()) {
					this.saveTipoProduBancoRelacionesDetalles(referenciabancarias);
					this.saveTipoProduBanco();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ReferenciaBancariaConstantesFunciones.InicializarGeneralEntityAuxiliaresReferenciaBancarias(referenciabancarias,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoProduBancoRelacionesDetalles(List<ReferenciaBancaria> referenciabancarias)throws Exception {
		try {
	

			Long idTipoProduBancoActual=this.getTipoProduBanco().getId();

			ReferenciaBancariaLogic referenciabancariaLogic_Desde_TipoProduBanco=new ReferenciaBancariaLogic();
			referenciabancariaLogic_Desde_TipoProduBanco.setReferenciaBancarias(referenciabancarias);

			referenciabancariaLogic_Desde_TipoProduBanco.setConnexion(this.getConnexion());
			referenciabancariaLogic_Desde_TipoProduBanco.setDatosCliente(this.datosCliente);

			for(ReferenciaBancaria referenciabancaria_Desde_TipoProduBanco:referenciabancariaLogic_Desde_TipoProduBanco.getReferenciaBancarias()) {
				referenciabancaria_Desde_TipoProduBanco.setidvalorclienteproductobanco(idTipoProduBancoActual);
			}

			referenciabancariaLogic_Desde_TipoProduBanco.saveReferenciaBancarias();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoProduBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoProduBancoConstantesFunciones.getClassesForeignKeysOfTipoProduBanco(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoProduBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoProduBancoConstantesFunciones.getClassesRelationshipsOfTipoProduBanco(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

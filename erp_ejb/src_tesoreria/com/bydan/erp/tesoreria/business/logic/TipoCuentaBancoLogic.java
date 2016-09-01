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
import com.bydan.erp.tesoreria.util.TipoCuentaBancoConstantesFunciones;
import com.bydan.erp.tesoreria.util.TipoCuentaBancoParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.TipoCuentaBancoParameterGeneral;
import com.bydan.erp.tesoreria.business.entity.TipoCuentaBanco;
import com.bydan.erp.tesoreria.business.logic.TipoCuentaBancoLogicAdditional;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoCuentaBancoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoCuentaBancoLogic.class);
	
	protected TipoCuentaBancoDataAccess tipocuentabancoDataAccess; 	
	protected TipoCuentaBanco tipocuentabanco;
	protected List<TipoCuentaBanco> tipocuentabancos;
	protected Object tipocuentabancoObject;	
	protected List<Object> tipocuentabancosObject;
	
	public static ClassValidator<TipoCuentaBanco> tipocuentabancoValidator = new ClassValidator<TipoCuentaBanco>(TipoCuentaBanco.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoCuentaBancoLogicAdditional tipocuentabancoLogicAdditional=null;
	
	public TipoCuentaBancoLogicAdditional getTipoCuentaBancoLogicAdditional() {
		return this.tipocuentabancoLogicAdditional;
	}
	
	public void setTipoCuentaBancoLogicAdditional(TipoCuentaBancoLogicAdditional tipocuentabancoLogicAdditional) {
		try {
			this.tipocuentabancoLogicAdditional=tipocuentabancoLogicAdditional;
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
	
	
	
	
	public  TipoCuentaBancoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipocuentabancoDataAccess = new TipoCuentaBancoDataAccess();
			
			this.tipocuentabancos= new ArrayList<TipoCuentaBanco>();
			this.tipocuentabanco= new TipoCuentaBanco();
			
			this.tipocuentabancoObject=new Object();
			this.tipocuentabancosObject=new ArrayList<Object>();
				
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
			
			this.tipocuentabancoDataAccess.setConnexionType(this.connexionType);
			this.tipocuentabancoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoCuentaBancoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipocuentabancoDataAccess = new TipoCuentaBancoDataAccess();
			this.tipocuentabancos= new ArrayList<TipoCuentaBanco>();
			this.tipocuentabanco= new TipoCuentaBanco();
			this.tipocuentabancoObject=new Object();
			this.tipocuentabancosObject=new ArrayList<Object>();
			
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
			
			this.tipocuentabancoDataAccess.setConnexionType(this.connexionType);
			this.tipocuentabancoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoCuentaBanco getTipoCuentaBanco() throws Exception {	
		TipoCuentaBancoLogicAdditional.checkTipoCuentaBancoToGet(tipocuentabanco,this.datosCliente,this.arrDatoGeneral);
		TipoCuentaBancoLogicAdditional.updateTipoCuentaBancoToGet(tipocuentabanco,this.arrDatoGeneral);
		
		return tipocuentabanco;
	}
		
	public void setTipoCuentaBanco(TipoCuentaBanco newTipoCuentaBanco) {
		this.tipocuentabanco = newTipoCuentaBanco;
	}
	
	public TipoCuentaBancoDataAccess getTipoCuentaBancoDataAccess() {
		return tipocuentabancoDataAccess;
	}
	
	public void setTipoCuentaBancoDataAccess(TipoCuentaBancoDataAccess newtipocuentabancoDataAccess) {
		this.tipocuentabancoDataAccess = newtipocuentabancoDataAccess;
	}
	
	public List<TipoCuentaBanco> getTipoCuentaBancos() throws Exception {		
		this.quitarTipoCuentaBancosNulos();
		
		TipoCuentaBancoLogicAdditional.checkTipoCuentaBancoToGets(tipocuentabancos,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoCuentaBanco tipocuentabancoLocal: tipocuentabancos ) {
			TipoCuentaBancoLogicAdditional.updateTipoCuentaBancoToGet(tipocuentabancoLocal,this.arrDatoGeneral);
		}
		
		return tipocuentabancos;
	}
	
	public void setTipoCuentaBancos(List<TipoCuentaBanco> newTipoCuentaBancos) {
		this.tipocuentabancos = newTipoCuentaBancos;
	}
	
	public Object getTipoCuentaBancoObject() {	
		this.tipocuentabancoObject=this.tipocuentabancoDataAccess.getEntityObject();
		return this.tipocuentabancoObject;
	}
		
	public void setTipoCuentaBancoObject(Object newTipoCuentaBancoObject) {
		this.tipocuentabancoObject = newTipoCuentaBancoObject;
	}
	
	public List<Object> getTipoCuentaBancosObject() {		
		this.tipocuentabancosObject=this.tipocuentabancoDataAccess.getEntitiesObject();
		return this.tipocuentabancosObject;
	}
		
	public void setTipoCuentaBancosObject(List<Object> newTipoCuentaBancosObject) {
		this.tipocuentabancosObject = newTipoCuentaBancosObject;
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
		
		if(this.tipocuentabancoDataAccess!=null) {
			this.tipocuentabancoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBanco.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipocuentabancoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipocuentabancoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipocuentabanco = new  TipoCuentaBanco();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBanco.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipocuentabanco=tipocuentabancoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocuentabanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBanco(this.tipocuentabanco);
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
		tipocuentabanco = new  TipoCuentaBanco();
		  		  
        try {
			
			tipocuentabanco=tipocuentabancoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocuentabanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBanco(this.tipocuentabanco);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipocuentabanco = new  TipoCuentaBanco();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBanco.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipocuentabanco=tipocuentabancoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocuentabanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBanco(this.tipocuentabanco);
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
		tipocuentabanco = new  TipoCuentaBanco();
		  		  
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
		tipocuentabanco = new  TipoCuentaBanco();
		  		  
        try {
			
			tipocuentabanco=tipocuentabancoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocuentabanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBanco(this.tipocuentabanco);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipocuentabanco = new  TipoCuentaBanco();
		  		  
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
		tipocuentabanco = new  TipoCuentaBanco();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBanco.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipocuentabancoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocuentabanco = new  TipoCuentaBanco();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipocuentabancoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipocuentabanco = new  TipoCuentaBanco();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBanco.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipocuentabancoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocuentabanco = new  TipoCuentaBanco();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipocuentabancoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipocuentabanco = new  TipoCuentaBanco();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBanco.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipocuentabancoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocuentabanco = new  TipoCuentaBanco();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipocuentabancoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipocuentabancos = new  ArrayList<TipoCuentaBanco>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBanco.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoCuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentabancos=tipocuentabancoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCuentaBanco(tipocuentabancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBanco(this.tipocuentabancos);
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
		tipocuentabancos = new  ArrayList<TipoCuentaBanco>();
		  		  
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
		tipocuentabancos = new  ArrayList<TipoCuentaBanco>();
		  		  
        try {			
			TipoCuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentabancos=tipocuentabancoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoCuentaBanco(tipocuentabancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBanco(this.tipocuentabancos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipocuentabancos = new  ArrayList<TipoCuentaBanco>();
		  		  
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
		tipocuentabancos = new  ArrayList<TipoCuentaBanco>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBanco.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoCuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentabancos=tipocuentabancoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCuentaBanco(tipocuentabancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBanco(this.tipocuentabancos);
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
		tipocuentabancos = new  ArrayList<TipoCuentaBanco>();
		  		  
        try {
			TipoCuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentabancos=tipocuentabancoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCuentaBanco(tipocuentabancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBanco(this.tipocuentabancos);
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
		tipocuentabancos = new  ArrayList<TipoCuentaBanco>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBanco.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentabancos=tipocuentabancoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCuentaBanco(tipocuentabancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBanco(this.tipocuentabancos);
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
		tipocuentabancos = new  ArrayList<TipoCuentaBanco>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentabancos=tipocuentabancoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCuentaBanco(tipocuentabancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBanco(this.tipocuentabancos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipocuentabanco = new  TipoCuentaBanco();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBanco.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentabanco=tipocuentabancoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCuentaBanco(tipocuentabanco);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBanco(this.tipocuentabanco);
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
		tipocuentabanco = new  TipoCuentaBanco();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentabanco=tipocuentabancoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCuentaBanco(tipocuentabanco);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBanco(this.tipocuentabanco);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipocuentabancos = new  ArrayList<TipoCuentaBanco>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBanco.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoCuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentabancos=tipocuentabancoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCuentaBanco(tipocuentabancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBanco(this.tipocuentabancos);
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
		tipocuentabancos = new  ArrayList<TipoCuentaBanco>();
		  		  
        try {
			TipoCuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentabancos=tipocuentabancoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCuentaBanco(tipocuentabancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBanco(this.tipocuentabancos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoCuentaBancosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipocuentabancos = new  ArrayList<TipoCuentaBanco>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBanco.class.getSimpleName()+"-getTodosTipoCuentaBancosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentabancos=tipocuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoCuentaBanco(tipocuentabancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBanco(this.tipocuentabancos);
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
	
	public  void  getTodosTipoCuentaBancos(String sFinalQuery,Pagination pagination)throws Exception {
		tipocuentabancos = new  ArrayList<TipoCuentaBanco>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentabancos=tipocuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoCuentaBanco(tipocuentabancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBanco(this.tipocuentabancos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoCuentaBanco(TipoCuentaBanco tipocuentabanco) throws Exception {
		Boolean estaValidado=false;
		
		if(tipocuentabanco.getIsNew() || tipocuentabanco.getIsChanged()) { 
			this.invalidValues = tipocuentabancoValidator.getInvalidValues(tipocuentabanco);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipocuentabanco);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoCuentaBanco(List<TipoCuentaBanco> TipoCuentaBancos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoCuentaBanco tipocuentabancoLocal:tipocuentabancos) {				
			estaValidadoObjeto=this.validarGuardarTipoCuentaBanco(tipocuentabancoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoCuentaBanco(List<TipoCuentaBanco> TipoCuentaBancos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoCuentaBanco(tipocuentabancos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoCuentaBanco(TipoCuentaBanco TipoCuentaBanco) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoCuentaBanco(tipocuentabanco)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoCuentaBanco tipocuentabanco) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipocuentabanco.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoCuentaBancoConstantesFunciones.getTipoCuentaBancoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipocuentabanco","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoCuentaBancoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoCuentaBancoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoCuentaBancoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBanco.class.getSimpleName()+"-saveTipoCuentaBancoWithConnection");connexion.begin();			
			
			TipoCuentaBancoLogicAdditional.checkTipoCuentaBancoToSave(this.tipocuentabanco,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoCuentaBancoLogicAdditional.updateTipoCuentaBancoToSave(this.tipocuentabanco,this.arrDatoGeneral);
			
			TipoCuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipocuentabanco,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoCuentaBanco();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoCuentaBanco(this.tipocuentabanco)) {
				TipoCuentaBancoDataAccess.save(this.tipocuentabanco, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipocuentabanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoCuentaBancoLogicAdditional.checkTipoCuentaBancoToSaveAfter(this.tipocuentabanco,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoCuentaBanco();
			
			connexion.commit();			
			
			if(this.tipocuentabanco.getIsDeleted()) {
				this.tipocuentabanco=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoCuentaBanco()throws Exception {	
		try {	
			
			TipoCuentaBancoLogicAdditional.checkTipoCuentaBancoToSave(this.tipocuentabanco,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoCuentaBancoLogicAdditional.updateTipoCuentaBancoToSave(this.tipocuentabanco,this.arrDatoGeneral);
			
			TipoCuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipocuentabanco,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoCuentaBanco(this.tipocuentabanco)) {			
				TipoCuentaBancoDataAccess.save(this.tipocuentabanco, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipocuentabanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoCuentaBancoLogicAdditional.checkTipoCuentaBancoToSaveAfter(this.tipocuentabanco,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipocuentabanco.getIsDeleted()) {
				this.tipocuentabanco=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoCuentaBancosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBanco.class.getSimpleName()+"-saveTipoCuentaBancosWithConnection");connexion.begin();			
			
			TipoCuentaBancoLogicAdditional.checkTipoCuentaBancoToSaves(tipocuentabancos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoCuentaBancos();
			
			Boolean validadoTodosTipoCuentaBanco=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoCuentaBanco tipocuentabancoLocal:tipocuentabancos) {		
				if(tipocuentabancoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoCuentaBancoLogicAdditional.updateTipoCuentaBancoToSave(tipocuentabancoLocal,this.arrDatoGeneral);
	        	
				TipoCuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipocuentabancoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoCuentaBanco(tipocuentabancoLocal)) {
					TipoCuentaBancoDataAccess.save(tipocuentabancoLocal, connexion);				
				} else {
					validadoTodosTipoCuentaBanco=false;
				}
			}
			
			if(!validadoTodosTipoCuentaBanco) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoCuentaBancoLogicAdditional.checkTipoCuentaBancoToSavesAfter(tipocuentabancos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoCuentaBancos();
			
			connexion.commit();		
			
			this.quitarTipoCuentaBancosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoCuentaBancos()throws Exception {				
		 try {	
			TipoCuentaBancoLogicAdditional.checkTipoCuentaBancoToSaves(tipocuentabancos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoCuentaBanco=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoCuentaBanco tipocuentabancoLocal:tipocuentabancos) {				
				if(tipocuentabancoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoCuentaBancoLogicAdditional.updateTipoCuentaBancoToSave(tipocuentabancoLocal,this.arrDatoGeneral);
	        	
				TipoCuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipocuentabancoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoCuentaBanco(tipocuentabancoLocal)) {				
					TipoCuentaBancoDataAccess.save(tipocuentabancoLocal, connexion);				
				} else {
					validadoTodosTipoCuentaBanco=false;
				}
			}
			
			if(!validadoTodosTipoCuentaBanco) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoCuentaBancoLogicAdditional.checkTipoCuentaBancoToSavesAfter(tipocuentabancos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoCuentaBancosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoCuentaBancoParameterReturnGeneral procesarAccionTipoCuentaBancos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoCuentaBanco> tipocuentabancos,TipoCuentaBancoParameterReturnGeneral tipocuentabancoParameterGeneral)throws Exception {
		 try {	
			TipoCuentaBancoParameterReturnGeneral tipocuentabancoReturnGeneral=new TipoCuentaBancoParameterReturnGeneral();
	
			TipoCuentaBancoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipocuentabancos,tipocuentabancoParameterGeneral,tipocuentabancoReturnGeneral);
			
			return tipocuentabancoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoCuentaBancoParameterReturnGeneral procesarAccionTipoCuentaBancosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoCuentaBanco> tipocuentabancos,TipoCuentaBancoParameterReturnGeneral tipocuentabancoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBanco.class.getSimpleName()+"-procesarAccionTipoCuentaBancosWithConnection");connexion.begin();			
			
			TipoCuentaBancoParameterReturnGeneral tipocuentabancoReturnGeneral=new TipoCuentaBancoParameterReturnGeneral();
	
			TipoCuentaBancoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipocuentabancos,tipocuentabancoParameterGeneral,tipocuentabancoReturnGeneral);
			
			this.connexion.commit();
			
			return tipocuentabancoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoCuentaBancoParameterReturnGeneral procesarEventosTipoCuentaBancos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoCuentaBanco> tipocuentabancos,TipoCuentaBanco tipocuentabanco,TipoCuentaBancoParameterReturnGeneral tipocuentabancoParameterGeneral,Boolean isEsNuevoTipoCuentaBanco,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoCuentaBancoParameterReturnGeneral tipocuentabancoReturnGeneral=new TipoCuentaBancoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipocuentabancoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoCuentaBancoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipocuentabancos,tipocuentabanco,tipocuentabancoParameterGeneral,tipocuentabancoReturnGeneral,isEsNuevoTipoCuentaBanco,clases);
			
			return tipocuentabancoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoCuentaBancoParameterReturnGeneral procesarEventosTipoCuentaBancosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoCuentaBanco> tipocuentabancos,TipoCuentaBanco tipocuentabanco,TipoCuentaBancoParameterReturnGeneral tipocuentabancoParameterGeneral,Boolean isEsNuevoTipoCuentaBanco,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBanco.class.getSimpleName()+"-procesarEventosTipoCuentaBancosWithConnection");connexion.begin();			
			
			TipoCuentaBancoParameterReturnGeneral tipocuentabancoReturnGeneral=new TipoCuentaBancoParameterReturnGeneral();
	
			tipocuentabancoReturnGeneral.setTipoCuentaBanco(tipocuentabanco);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipocuentabancoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoCuentaBancoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipocuentabancos,tipocuentabanco,tipocuentabancoParameterGeneral,tipocuentabancoReturnGeneral,isEsNuevoTipoCuentaBanco,clases);
			
			this.connexion.commit();
			
			return tipocuentabancoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoCuentaBancoParameterReturnGeneral procesarImportacionTipoCuentaBancosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoCuentaBancoParameterReturnGeneral tipocuentabancoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBanco.class.getSimpleName()+"-procesarImportacionTipoCuentaBancosWithConnection");connexion.begin();			
			
			TipoCuentaBancoParameterReturnGeneral tipocuentabancoReturnGeneral=new TipoCuentaBancoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipocuentabancos=new ArrayList<TipoCuentaBanco>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipocuentabanco=new TipoCuentaBanco();
				
				
				if(conColumnasBase) {this.tipocuentabanco.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipocuentabanco.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipocuentabanco.setcodigo(arrColumnas[iColumn++]);
				this.tipocuentabanco.setnombre(arrColumnas[iColumn++]);
				
				this.tipocuentabancos.add(this.tipocuentabanco);
			}
			
			this.saveTipoCuentaBancos();
			
			this.connexion.commit();
			
			tipocuentabancoReturnGeneral.setConRetornoEstaProcesado(true);
			tipocuentabancoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipocuentabancoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoCuentaBancosEliminados() throws Exception {				
		
		List<TipoCuentaBanco> tipocuentabancosAux= new ArrayList<TipoCuentaBanco>();
		
		for(TipoCuentaBanco tipocuentabanco:tipocuentabancos) {
			if(!tipocuentabanco.getIsDeleted()) {
				tipocuentabancosAux.add(tipocuentabanco);
			}
		}
		
		tipocuentabancos=tipocuentabancosAux;
	}
	
	public void quitarTipoCuentaBancosNulos() throws Exception {				
		
		List<TipoCuentaBanco> tipocuentabancosAux= new ArrayList<TipoCuentaBanco>();
		
		for(TipoCuentaBanco tipocuentabanco : this.tipocuentabancos) {
			if(tipocuentabanco==null) {
				tipocuentabancosAux.add(tipocuentabanco);
			}
		}
		
		//this.tipocuentabancos=tipocuentabancosAux;
		
		this.tipocuentabancos.removeAll(tipocuentabancosAux);
	}
	
	public void getSetVersionRowTipoCuentaBancoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipocuentabanco.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipocuentabanco.getIsDeleted() || (tipocuentabanco.getIsChanged()&&!tipocuentabanco.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipocuentabancoDataAccess.getSetVersionRowTipoCuentaBanco(connexion,tipocuentabanco.getId());
				
				if(!tipocuentabanco.getVersionRow().equals(timestamp)) {	
					tipocuentabanco.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipocuentabanco.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoCuentaBanco()throws Exception {	
		
		if(tipocuentabanco.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipocuentabanco.getIsDeleted() || (tipocuentabanco.getIsChanged()&&!tipocuentabanco.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipocuentabancoDataAccess.getSetVersionRowTipoCuentaBanco(connexion,tipocuentabanco.getId());
			
			try {							
				if(!tipocuentabanco.getVersionRow().equals(timestamp)) {	
					tipocuentabanco.setVersionRow(timestamp);
				}
				
				tipocuentabanco.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoCuentaBancosWithConnection()throws Exception {	
		if(tipocuentabancos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoCuentaBanco tipocuentabancoAux:tipocuentabancos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipocuentabancoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipocuentabancoAux.getIsDeleted() || (tipocuentabancoAux.getIsChanged()&&!tipocuentabancoAux.getIsNew())) {
						
						timestamp=tipocuentabancoDataAccess.getSetVersionRowTipoCuentaBanco(connexion,tipocuentabancoAux.getId());
						
						if(!tipocuentabanco.getVersionRow().equals(timestamp)) {	
							tipocuentabancoAux.setVersionRow(timestamp);
						}
								
						tipocuentabancoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoCuentaBancos()throws Exception {	
		if(tipocuentabancos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoCuentaBanco tipocuentabancoAux:tipocuentabancos) {
					if(tipocuentabancoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipocuentabancoAux.getIsDeleted() || (tipocuentabancoAux.getIsChanged()&&!tipocuentabancoAux.getIsNew())) {
						
						timestamp=tipocuentabancoDataAccess.getSetVersionRowTipoCuentaBanco(connexion,tipocuentabancoAux.getId());
						
						if(!tipocuentabancoAux.getVersionRow().equals(timestamp)) {	
							tipocuentabancoAux.setVersionRow(timestamp);
						}
						
													
						tipocuentabancoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoCuentaBancoParameterReturnGeneral cargarCombosLoteForeignKeyTipoCuentaBancoWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoCuentaBancoParameterReturnGeneral  tipocuentabancoReturnGeneral =new TipoCuentaBancoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBanco.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoCuentaBancoWithConnection");connexion.begin();
			
			tipocuentabancoReturnGeneral =new TipoCuentaBancoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipocuentabancoReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipocuentabancoReturnGeneral;
	}
	
	public TipoCuentaBancoParameterReturnGeneral cargarCombosLoteForeignKeyTipoCuentaBanco(String finalQueryGlobalEmpresa) throws Exception {
		TipoCuentaBancoParameterReturnGeneral  tipocuentabancoReturnGeneral =new TipoCuentaBancoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipocuentabancoReturnGeneral =new TipoCuentaBancoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipocuentabancoReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipocuentabancoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoCuentaBancoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ReferenciaBancariaLogic referenciabancariaLogic=new ReferenciaBancariaLogic();
			TipoCuentaBancoGeneralLogic tipocuentabancogeneralLogic=new TipoCuentaBancoGeneralLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBanco.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoCuentaBancoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(ReferenciaBancaria.class));
			classes.add(new Classe(TipoCuentaBancoGeneral.class));
											
			

			referenciabancariaLogic.setConnexion(this.getConnexion());
			referenciabancariaLogic.setDatosCliente(this.datosCliente);
			referenciabancariaLogic.setIsConRefrescarForeignKeys(true);

			tipocuentabancogeneralLogic.setConnexion(this.getConnexion());
			tipocuentabancogeneralLogic.setDatosCliente(this.datosCliente);
			tipocuentabancogeneralLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoCuentaBanco tipocuentabanco:this.tipocuentabancos) {
				

				classes=new ArrayList<Classe>();
				classes=ReferenciaBancariaConstantesFunciones.getClassesForeignKeysOfReferenciaBancaria(new ArrayList<Classe>(),DeepLoadType.NONE);

				referenciabancariaLogic.setReferenciaBancarias(tipocuentabanco.referenciabancarias);
				referenciabancariaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=TipoCuentaBancoGeneralConstantesFunciones.getClassesForeignKeysOfTipoCuentaBancoGeneral(new ArrayList<Classe>(),DeepLoadType.NONE);

				tipocuentabancogeneralLogic.setTipoCuentaBancoGenerals(tipocuentabanco.tipocuentabancogenerals);
				tipocuentabancogeneralLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoCuentaBanco tipocuentabanco,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoCuentaBancoLogicAdditional.updateTipoCuentaBancoToGet(tipocuentabanco,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipocuentabanco.setEmpresa(tipocuentabancoDataAccess.getEmpresa(connexion,tipocuentabanco));
		tipocuentabanco.setReferenciaBancarias(tipocuentabancoDataAccess.getReferenciaBancarias(connexion,tipocuentabanco));
		tipocuentabanco.setTipoCuentaBancoGenerals(tipocuentabancoDataAccess.getTipoCuentaBancoGenerals(connexion,tipocuentabanco));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipocuentabanco.setEmpresa(tipocuentabancoDataAccess.getEmpresa(connexion,tipocuentabanco));
				continue;
			}

			if(clas.clas.equals(ReferenciaBancaria.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocuentabanco.setReferenciaBancarias(tipocuentabancoDataAccess.getReferenciaBancarias(connexion,tipocuentabanco));

				if(this.isConDeep) {
					ReferenciaBancariaLogic referenciabancariaLogic= new ReferenciaBancariaLogic(this.connexion);
					referenciabancariaLogic.setReferenciaBancarias(tipocuentabanco.getReferenciaBancarias());
					ArrayList<Classe> classesLocal=ReferenciaBancariaConstantesFunciones.getClassesForeignKeysOfReferenciaBancaria(new ArrayList<Classe>(),DeepLoadType.NONE);
					referenciabancariaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ReferenciaBancariaConstantesFunciones.refrescarForeignKeysDescripcionesReferenciaBancaria(referenciabancariaLogic.getReferenciaBancarias());
					tipocuentabanco.setReferenciaBancarias(referenciabancariaLogic.getReferenciaBancarias());
				}

				continue;
			}

			if(clas.clas.equals(TipoCuentaBancoGeneral.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocuentabanco.setTipoCuentaBancoGenerals(tipocuentabancoDataAccess.getTipoCuentaBancoGenerals(connexion,tipocuentabanco));

				if(this.isConDeep) {
					TipoCuentaBancoGeneralLogic tipocuentabancogeneralLogic= new TipoCuentaBancoGeneralLogic(this.connexion);
					tipocuentabancogeneralLogic.setTipoCuentaBancoGenerals(tipocuentabanco.getTipoCuentaBancoGenerals());
					ArrayList<Classe> classesLocal=TipoCuentaBancoGeneralConstantesFunciones.getClassesForeignKeysOfTipoCuentaBancoGeneral(new ArrayList<Classe>(),DeepLoadType.NONE);
					tipocuentabancogeneralLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					TipoCuentaBancoGeneralConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGeneral(tipocuentabancogeneralLogic.getTipoCuentaBancoGenerals());
					tipocuentabanco.setTipoCuentaBancoGenerals(tipocuentabancogeneralLogic.getTipoCuentaBancoGenerals());
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
			tipocuentabanco.setEmpresa(tipocuentabancoDataAccess.getEmpresa(connexion,tipocuentabanco));
		}

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
			tipocuentabanco.setReferenciaBancarias(tipocuentabancoDataAccess.getReferenciaBancarias(connexion,tipocuentabanco));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCuentaBancoGeneral.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TipoCuentaBancoGeneral.class));
			tipocuentabanco.setTipoCuentaBancoGenerals(tipocuentabancoDataAccess.getTipoCuentaBancoGenerals(connexion,tipocuentabanco));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipocuentabanco.setEmpresa(tipocuentabancoDataAccess.getEmpresa(connexion,tipocuentabanco));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipocuentabanco.getEmpresa(),isDeep,deepLoadType,clases);
				

		tipocuentabanco.setReferenciaBancarias(tipocuentabancoDataAccess.getReferenciaBancarias(connexion,tipocuentabanco));

		for(ReferenciaBancaria referenciabancaria:tipocuentabanco.getReferenciaBancarias()) {
			ReferenciaBancariaLogic referenciabancariaLogic= new ReferenciaBancariaLogic(connexion);
			referenciabancariaLogic.deepLoad(referenciabancaria,isDeep,deepLoadType,clases);
		}

		tipocuentabanco.setTipoCuentaBancoGenerals(tipocuentabancoDataAccess.getTipoCuentaBancoGenerals(connexion,tipocuentabanco));

		for(TipoCuentaBancoGeneral tipocuentabancogeneral:tipocuentabanco.getTipoCuentaBancoGenerals()) {
			TipoCuentaBancoGeneralLogic tipocuentabancogeneralLogic= new TipoCuentaBancoGeneralLogic(connexion);
			tipocuentabancogeneralLogic.deepLoad(tipocuentabancogeneral,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipocuentabanco.setEmpresa(tipocuentabancoDataAccess.getEmpresa(connexion,tipocuentabanco));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipocuentabanco.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ReferenciaBancaria.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocuentabanco.setReferenciaBancarias(tipocuentabancoDataAccess.getReferenciaBancarias(connexion,tipocuentabanco));

				for(ReferenciaBancaria referenciabancaria:tipocuentabanco.getReferenciaBancarias()) {
					ReferenciaBancariaLogic referenciabancariaLogic= new ReferenciaBancariaLogic(connexion);
					referenciabancariaLogic.deepLoad(referenciabancaria,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(TipoCuentaBancoGeneral.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocuentabanco.setTipoCuentaBancoGenerals(tipocuentabancoDataAccess.getTipoCuentaBancoGenerals(connexion,tipocuentabanco));

				for(TipoCuentaBancoGeneral tipocuentabancogeneral:tipocuentabanco.getTipoCuentaBancoGenerals()) {
					TipoCuentaBancoGeneralLogic tipocuentabancogeneralLogic= new TipoCuentaBancoGeneralLogic(connexion);
					tipocuentabancogeneralLogic.deepLoad(tipocuentabancogeneral,isDeep,deepLoadType,clases);
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
			tipocuentabanco.setEmpresa(tipocuentabancoDataAccess.getEmpresa(connexion,tipocuentabanco));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipocuentabanco.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

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
			tipocuentabanco.setReferenciaBancarias(tipocuentabancoDataAccess.getReferenciaBancarias(connexion,tipocuentabanco));

			for(ReferenciaBancaria referenciabancaria:tipocuentabanco.getReferenciaBancarias()) {
				ReferenciaBancariaLogic referenciabancariaLogic= new ReferenciaBancariaLogic(connexion);
				referenciabancariaLogic.deepLoad(referenciabancaria,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCuentaBancoGeneral.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TipoCuentaBancoGeneral.class));
			tipocuentabanco.setTipoCuentaBancoGenerals(tipocuentabancoDataAccess.getTipoCuentaBancoGenerals(connexion,tipocuentabanco));

			for(TipoCuentaBancoGeneral tipocuentabancogeneral:tipocuentabanco.getTipoCuentaBancoGenerals()) {
				TipoCuentaBancoGeneralLogic tipocuentabancogeneralLogic= new TipoCuentaBancoGeneralLogic(connexion);
				tipocuentabancogeneralLogic.deepLoad(tipocuentabancogeneral,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoCuentaBanco tipocuentabanco,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoCuentaBancoLogicAdditional.updateTipoCuentaBancoToSave(tipocuentabanco,this.arrDatoGeneral);
			
TipoCuentaBancoDataAccess.save(tipocuentabanco, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipocuentabanco.getEmpresa(),connexion);

		for(ReferenciaBancaria referenciabancaria:tipocuentabanco.getReferenciaBancarias()) {
			referenciabancaria.setidvalorclientecuentabanco(tipocuentabanco.getId());
			ReferenciaBancariaDataAccess.save(referenciabancaria,connexion);
		}

		for(TipoCuentaBancoGeneral tipocuentabancogeneral:tipocuentabanco.getTipoCuentaBancoGenerals()) {
			tipocuentabancogeneral.setid_tipo_cuenta_banco(tipocuentabanco.getId());
			TipoCuentaBancoGeneralDataAccess.save(tipocuentabancogeneral,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipocuentabanco.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(ReferenciaBancaria.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ReferenciaBancaria referenciabancaria:tipocuentabanco.getReferenciaBancarias()) {
					referenciabancaria.setidvalorclientecuentabanco(tipocuentabanco.getId());
					ReferenciaBancariaDataAccess.save(referenciabancaria,connexion);
				}
				continue;
			}

			if(clas.clas.equals(TipoCuentaBancoGeneral.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TipoCuentaBancoGeneral tipocuentabancogeneral:tipocuentabanco.getTipoCuentaBancoGenerals()) {
					tipocuentabancogeneral.setid_tipo_cuenta_banco(tipocuentabanco.getId());
					TipoCuentaBancoGeneralDataAccess.save(tipocuentabancogeneral,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipocuentabanco.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipocuentabanco.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(ReferenciaBancaria referenciabancaria:tipocuentabanco.getReferenciaBancarias()) {
			ReferenciaBancariaLogic referenciabancariaLogic= new ReferenciaBancariaLogic(connexion);
			referenciabancaria.setidvalorclientecuentabanco(tipocuentabanco.getId());
			ReferenciaBancariaDataAccess.save(referenciabancaria,connexion);
			referenciabancariaLogic.deepSave(referenciabancaria,isDeep,deepLoadType,clases);
		}

		for(TipoCuentaBancoGeneral tipocuentabancogeneral:tipocuentabanco.getTipoCuentaBancoGenerals()) {
			TipoCuentaBancoGeneralLogic tipocuentabancogeneralLogic= new TipoCuentaBancoGeneralLogic(connexion);
			tipocuentabancogeneral.setid_tipo_cuenta_banco(tipocuentabanco.getId());
			TipoCuentaBancoGeneralDataAccess.save(tipocuentabancogeneral,connexion);
			tipocuentabancogeneralLogic.deepSave(tipocuentabancogeneral,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipocuentabanco.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipocuentabanco.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(ReferenciaBancaria.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ReferenciaBancaria referenciabancaria:tipocuentabanco.getReferenciaBancarias()) {
					ReferenciaBancariaLogic referenciabancariaLogic= new ReferenciaBancariaLogic(connexion);
					referenciabancaria.setidvalorclientecuentabanco(tipocuentabanco.getId());
					ReferenciaBancariaDataAccess.save(referenciabancaria,connexion);
					referenciabancariaLogic.deepSave(referenciabancaria,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(TipoCuentaBancoGeneral.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TipoCuentaBancoGeneral tipocuentabancogeneral:tipocuentabanco.getTipoCuentaBancoGenerals()) {
					TipoCuentaBancoGeneralLogic tipocuentabancogeneralLogic= new TipoCuentaBancoGeneralLogic(connexion);
					tipocuentabancogeneral.setid_tipo_cuenta_banco(tipocuentabanco.getId());
					TipoCuentaBancoGeneralDataAccess.save(tipocuentabancogeneral,connexion);
					tipocuentabancogeneralLogic.deepSave(tipocuentabancogeneral,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoCuentaBanco.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipocuentabanco,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBanco(tipocuentabanco);
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
			this.deepLoad(this.tipocuentabanco,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBanco(this.tipocuentabanco);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoCuentaBanco.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipocuentabancos!=null) {
				for(TipoCuentaBanco tipocuentabanco:tipocuentabancos) {
					this.deepLoad(tipocuentabanco,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBanco(tipocuentabancos);
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
			if(tipocuentabancos!=null) {
				for(TipoCuentaBanco tipocuentabanco:tipocuentabancos) {
					this.deepLoad(tipocuentabanco,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBanco(tipocuentabancos);
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
			this.getNewConnexionToDeep(TipoCuentaBanco.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipocuentabanco,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoCuentaBanco.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipocuentabancos!=null) {
				for(TipoCuentaBanco tipocuentabanco:tipocuentabancos) {
					this.deepSave(tipocuentabanco,isDeep,deepLoadType,clases);
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
			if(tipocuentabancos!=null) {
				for(TipoCuentaBanco tipocuentabanco:tipocuentabancos) {
					this.deepSave(tipocuentabanco,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoCuentaBancosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBanco.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoCuentaBancoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoCuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipocuentabancos=tipocuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBanco(this.tipocuentabancos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoCuentaBancosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoCuentaBancoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoCuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipocuentabancos=tipocuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoCuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBanco(this.tipocuentabancos);
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
			if(TipoCuentaBancoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCuentaBancoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoCuentaBanco tipocuentabanco,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoCuentaBancoConstantesFunciones.ISCONAUDITORIA) {
				if(tipocuentabanco.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCuentaBancoDataAccess.TABLENAME, tipocuentabanco.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoCuentaBancoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoCuentaBancoLogic.registrarAuditoriaDetallesTipoCuentaBanco(connexion,tipocuentabanco,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipocuentabanco.getIsDeleted()) {
					/*if(!tipocuentabanco.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoCuentaBancoDataAccess.TABLENAME, tipocuentabanco.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoCuentaBancoLogic.registrarAuditoriaDetallesTipoCuentaBanco(connexion,tipocuentabanco,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCuentaBancoDataAccess.TABLENAME, tipocuentabanco.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipocuentabanco.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCuentaBancoDataAccess.TABLENAME, tipocuentabanco.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoCuentaBancoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoCuentaBancoLogic.registrarAuditoriaDetallesTipoCuentaBanco(connexion,tipocuentabanco,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoCuentaBanco(Connexion connexion,TipoCuentaBanco tipocuentabanco)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipocuentabanco.getIsNew()||!tipocuentabanco.getid_empresa().equals(tipocuentabanco.getTipoCuentaBancoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocuentabanco.getTipoCuentaBancoOriginal().getid_empresa()!=null)
				{
					strValorActual=tipocuentabanco.getTipoCuentaBancoOriginal().getid_empresa().toString();
				}
				if(tipocuentabanco.getid_empresa()!=null)
				{
					strValorNuevo=tipocuentabanco.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoCuentaBancoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipocuentabanco.getIsNew()||!tipocuentabanco.getcodigo().equals(tipocuentabanco.getTipoCuentaBancoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocuentabanco.getTipoCuentaBancoOriginal().getcodigo()!=null)
				{
					strValorActual=tipocuentabanco.getTipoCuentaBancoOriginal().getcodigo();
				}
				if(tipocuentabanco.getcodigo()!=null)
				{
					strValorNuevo=tipocuentabanco.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoCuentaBancoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipocuentabanco.getIsNew()||!tipocuentabanco.getnombre().equals(tipocuentabanco.getTipoCuentaBancoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocuentabanco.getTipoCuentaBancoOriginal().getnombre()!=null)
				{
					strValorActual=tipocuentabanco.getTipoCuentaBancoOriginal().getnombre();
				}
				if(tipocuentabanco.getnombre()!=null)
				{
					strValorNuevo=tipocuentabanco.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoCuentaBancoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoCuentaBancoRelacionesWithConnection(TipoCuentaBanco tipocuentabanco,List<ReferenciaBancaria> referenciabancarias,List<TipoCuentaBancoGeneral> tipocuentabancogenerals) throws Exception {

		if(!tipocuentabanco.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoCuentaBancoRelacionesBase(tipocuentabanco,referenciabancarias,tipocuentabancogenerals,true);
		}
	}

	public void saveTipoCuentaBancoRelaciones(TipoCuentaBanco tipocuentabanco,List<ReferenciaBancaria> referenciabancarias,List<TipoCuentaBancoGeneral> tipocuentabancogenerals)throws Exception {

		if(!tipocuentabanco.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoCuentaBancoRelacionesBase(tipocuentabanco,referenciabancarias,tipocuentabancogenerals,false);
		}
	}

	public void saveTipoCuentaBancoRelacionesBase(TipoCuentaBanco tipocuentabanco,List<ReferenciaBancaria> referenciabancarias,List<TipoCuentaBancoGeneral> tipocuentabancogenerals,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoCuentaBanco-saveRelacionesWithConnection");}
	
			tipocuentabanco.setReferenciaBancarias(referenciabancarias);
			tipocuentabanco.setTipoCuentaBancoGenerals(tipocuentabancogenerals);

			this.setTipoCuentaBanco(tipocuentabanco);

			if(TipoCuentaBancoLogicAdditional.validarSaveRelaciones(tipocuentabanco,this)) {

				TipoCuentaBancoLogicAdditional.updateRelacionesToSave(tipocuentabanco,this);

				if((tipocuentabanco.getIsNew()||tipocuentabanco.getIsChanged())&&!tipocuentabanco.getIsDeleted()) {
					this.saveTipoCuentaBanco();
					this.saveTipoCuentaBancoRelacionesDetalles(referenciabancarias,tipocuentabancogenerals);

				} else if(tipocuentabanco.getIsDeleted()) {
					this.saveTipoCuentaBancoRelacionesDetalles(referenciabancarias,tipocuentabancogenerals);
					this.saveTipoCuentaBanco();
				}

				TipoCuentaBancoLogicAdditional.updateRelacionesToSaveAfter(tipocuentabanco,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ReferenciaBancariaConstantesFunciones.InicializarGeneralEntityAuxiliaresReferenciaBancarias(referenciabancarias,true,true);
			TipoCuentaBancoGeneralConstantesFunciones.InicializarGeneralEntityAuxiliaresTipoCuentaBancoGenerals(tipocuentabancogenerals,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoCuentaBancoRelacionesDetalles(List<ReferenciaBancaria> referenciabancarias,List<TipoCuentaBancoGeneral> tipocuentabancogenerals)throws Exception {
		try {
	

			Long idTipoCuentaBancoActual=this.getTipoCuentaBanco().getId();

			ReferenciaBancariaLogic referenciabancariaLogic_Desde_TipoCuentaBanco=new ReferenciaBancariaLogic();
			referenciabancariaLogic_Desde_TipoCuentaBanco.setReferenciaBancarias(referenciabancarias);

			referenciabancariaLogic_Desde_TipoCuentaBanco.setConnexion(this.getConnexion());
			referenciabancariaLogic_Desde_TipoCuentaBanco.setDatosCliente(this.datosCliente);

			for(ReferenciaBancaria referenciabancaria_Desde_TipoCuentaBanco:referenciabancariaLogic_Desde_TipoCuentaBanco.getReferenciaBancarias()) {
				referenciabancaria_Desde_TipoCuentaBanco.setidvalorclientecuentabanco(idTipoCuentaBancoActual);
			}

			referenciabancariaLogic_Desde_TipoCuentaBanco.saveReferenciaBancarias();

			TipoCuentaBancoGeneralLogic tipocuentabancogeneralLogic_Desde_TipoCuentaBanco=new TipoCuentaBancoGeneralLogic();
			tipocuentabancogeneralLogic_Desde_TipoCuentaBanco.setTipoCuentaBancoGenerals(tipocuentabancogenerals);

			tipocuentabancogeneralLogic_Desde_TipoCuentaBanco.setConnexion(this.getConnexion());
			tipocuentabancogeneralLogic_Desde_TipoCuentaBanco.setDatosCliente(this.datosCliente);

			for(TipoCuentaBancoGeneral tipocuentabancogeneral_Desde_TipoCuentaBanco:tipocuentabancogeneralLogic_Desde_TipoCuentaBanco.getTipoCuentaBancoGenerals()) {
				tipocuentabancogeneral_Desde_TipoCuentaBanco.setid_tipo_cuenta_banco(idTipoCuentaBancoActual);
			}

			tipocuentabancogeneralLogic_Desde_TipoCuentaBanco.saveTipoCuentaBancoGenerals();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoCuentaBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoCuentaBancoConstantesFunciones.getClassesForeignKeysOfTipoCuentaBanco(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCuentaBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoCuentaBancoConstantesFunciones.getClassesRelationshipsOfTipoCuentaBanco(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

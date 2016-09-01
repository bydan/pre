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
import com.bydan.erp.tesoreria.util.TipoCuentaBancoGlobalConstantesFunciones;
import com.bydan.erp.tesoreria.util.TipoCuentaBancoGlobalParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.TipoCuentaBancoGlobalParameterGeneral;
import com.bydan.erp.tesoreria.business.entity.TipoCuentaBancoGlobal;
//import com.bydan.erp.tesoreria.business.logic.TipoCuentaBancoGlobalLogicAdditional;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.nomina.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;


import com.bydan.erp.nomina.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoCuentaBancoGlobalLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoCuentaBancoGlobalLogic.class);
	
	protected TipoCuentaBancoGlobalDataAccess tipocuentabancoglobalDataAccess; 	
	protected TipoCuentaBancoGlobal tipocuentabancoglobal;
	protected List<TipoCuentaBancoGlobal> tipocuentabancoglobals;
	protected Object tipocuentabancoglobalObject;	
	protected List<Object> tipocuentabancoglobalsObject;
	
	public static ClassValidator<TipoCuentaBancoGlobal> tipocuentabancoglobalValidator = new ClassValidator<TipoCuentaBancoGlobal>(TipoCuentaBancoGlobal.class);	
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
	
	
	
	
	public  TipoCuentaBancoGlobalLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipocuentabancoglobalDataAccess = new TipoCuentaBancoGlobalDataAccess();
			
			this.tipocuentabancoglobals= new ArrayList<TipoCuentaBancoGlobal>();
			this.tipocuentabancoglobal= new TipoCuentaBancoGlobal();
			
			this.tipocuentabancoglobalObject=new Object();
			this.tipocuentabancoglobalsObject=new ArrayList<Object>();
				
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
			
			this.tipocuentabancoglobalDataAccess.setConnexionType(this.connexionType);
			this.tipocuentabancoglobalDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoCuentaBancoGlobalLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipocuentabancoglobalDataAccess = new TipoCuentaBancoGlobalDataAccess();
			this.tipocuentabancoglobals= new ArrayList<TipoCuentaBancoGlobal>();
			this.tipocuentabancoglobal= new TipoCuentaBancoGlobal();
			this.tipocuentabancoglobalObject=new Object();
			this.tipocuentabancoglobalsObject=new ArrayList<Object>();
			
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
			
			this.tipocuentabancoglobalDataAccess.setConnexionType(this.connexionType);
			this.tipocuentabancoglobalDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoCuentaBancoGlobal getTipoCuentaBancoGlobal() throws Exception {	
		//TipoCuentaBancoGlobalLogicAdditional.checkTipoCuentaBancoGlobalToGet(tipocuentabancoglobal,this.datosCliente,this.arrDatoGeneral);
		//TipoCuentaBancoGlobalLogicAdditional.updateTipoCuentaBancoGlobalToGet(tipocuentabancoglobal,this.arrDatoGeneral);
		
		return tipocuentabancoglobal;
	}
		
	public void setTipoCuentaBancoGlobal(TipoCuentaBancoGlobal newTipoCuentaBancoGlobal) {
		this.tipocuentabancoglobal = newTipoCuentaBancoGlobal;
	}
	
	public TipoCuentaBancoGlobalDataAccess getTipoCuentaBancoGlobalDataAccess() {
		return tipocuentabancoglobalDataAccess;
	}
	
	public void setTipoCuentaBancoGlobalDataAccess(TipoCuentaBancoGlobalDataAccess newtipocuentabancoglobalDataAccess) {
		this.tipocuentabancoglobalDataAccess = newtipocuentabancoglobalDataAccess;
	}
	
	public List<TipoCuentaBancoGlobal> getTipoCuentaBancoGlobals() throws Exception {		
		this.quitarTipoCuentaBancoGlobalsNulos();
		
		//TipoCuentaBancoGlobalLogicAdditional.checkTipoCuentaBancoGlobalToGets(tipocuentabancoglobals,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoCuentaBancoGlobal tipocuentabancoglobalLocal: tipocuentabancoglobals ) {
			//TipoCuentaBancoGlobalLogicAdditional.updateTipoCuentaBancoGlobalToGet(tipocuentabancoglobalLocal,this.arrDatoGeneral);
		}
		
		return tipocuentabancoglobals;
	}
	
	public void setTipoCuentaBancoGlobals(List<TipoCuentaBancoGlobal> newTipoCuentaBancoGlobals) {
		this.tipocuentabancoglobals = newTipoCuentaBancoGlobals;
	}
	
	public Object getTipoCuentaBancoGlobalObject() {	
		this.tipocuentabancoglobalObject=this.tipocuentabancoglobalDataAccess.getEntityObject();
		return this.tipocuentabancoglobalObject;
	}
		
	public void setTipoCuentaBancoGlobalObject(Object newTipoCuentaBancoGlobalObject) {
		this.tipocuentabancoglobalObject = newTipoCuentaBancoGlobalObject;
	}
	
	public List<Object> getTipoCuentaBancoGlobalsObject() {		
		this.tipocuentabancoglobalsObject=this.tipocuentabancoglobalDataAccess.getEntitiesObject();
		return this.tipocuentabancoglobalsObject;
	}
		
	public void setTipoCuentaBancoGlobalsObject(List<Object> newTipoCuentaBancoGlobalsObject) {
		this.tipocuentabancoglobalsObject = newTipoCuentaBancoGlobalsObject;
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
		
		if(this.tipocuentabancoglobalDataAccess!=null) {
			this.tipocuentabancoglobalDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBancoGlobal.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipocuentabancoglobalDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipocuentabancoglobalDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipocuentabancoglobal = new  TipoCuentaBancoGlobal();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBancoGlobal.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipocuentabancoglobal=tipocuentabancoglobalDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocuentabancoglobal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGlobal(this.tipocuentabancoglobal);
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
		tipocuentabancoglobal = new  TipoCuentaBancoGlobal();
		  		  
        try {
			
			tipocuentabancoglobal=tipocuentabancoglobalDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocuentabancoglobal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGlobal(this.tipocuentabancoglobal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipocuentabancoglobal = new  TipoCuentaBancoGlobal();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBancoGlobal.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipocuentabancoglobal=tipocuentabancoglobalDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocuentabancoglobal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGlobal(this.tipocuentabancoglobal);
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
		tipocuentabancoglobal = new  TipoCuentaBancoGlobal();
		  		  
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
		tipocuentabancoglobal = new  TipoCuentaBancoGlobal();
		  		  
        try {
			
			tipocuentabancoglobal=tipocuentabancoglobalDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocuentabancoglobal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGlobal(this.tipocuentabancoglobal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipocuentabancoglobal = new  TipoCuentaBancoGlobal();
		  		  
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
		tipocuentabancoglobal = new  TipoCuentaBancoGlobal();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBancoGlobal.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipocuentabancoglobalDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocuentabancoglobal = new  TipoCuentaBancoGlobal();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipocuentabancoglobalDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipocuentabancoglobal = new  TipoCuentaBancoGlobal();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBancoGlobal.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipocuentabancoglobalDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocuentabancoglobal = new  TipoCuentaBancoGlobal();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipocuentabancoglobalDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipocuentabancoglobal = new  TipoCuentaBancoGlobal();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBancoGlobal.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipocuentabancoglobalDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocuentabancoglobal = new  TipoCuentaBancoGlobal();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipocuentabancoglobalDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipocuentabancoglobals = new  ArrayList<TipoCuentaBancoGlobal>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBancoGlobal.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoCuentaBancoGlobalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentabancoglobals=tipocuentabancoglobalDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCuentaBancoGlobal(tipocuentabancoglobals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGlobal(this.tipocuentabancoglobals);
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
		tipocuentabancoglobals = new  ArrayList<TipoCuentaBancoGlobal>();
		  		  
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
		tipocuentabancoglobals = new  ArrayList<TipoCuentaBancoGlobal>();
		  		  
        try {			
			TipoCuentaBancoGlobalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentabancoglobals=tipocuentabancoglobalDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoCuentaBancoGlobal(tipocuentabancoglobals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGlobal(this.tipocuentabancoglobals);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipocuentabancoglobals = new  ArrayList<TipoCuentaBancoGlobal>();
		  		  
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
		tipocuentabancoglobals = new  ArrayList<TipoCuentaBancoGlobal>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBancoGlobal.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoCuentaBancoGlobalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentabancoglobals=tipocuentabancoglobalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCuentaBancoGlobal(tipocuentabancoglobals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGlobal(this.tipocuentabancoglobals);
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
		tipocuentabancoglobals = new  ArrayList<TipoCuentaBancoGlobal>();
		  		  
        try {
			TipoCuentaBancoGlobalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentabancoglobals=tipocuentabancoglobalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCuentaBancoGlobal(tipocuentabancoglobals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGlobal(this.tipocuentabancoglobals);
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
		tipocuentabancoglobals = new  ArrayList<TipoCuentaBancoGlobal>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBancoGlobal.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCuentaBancoGlobalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentabancoglobals=tipocuentabancoglobalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCuentaBancoGlobal(tipocuentabancoglobals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGlobal(this.tipocuentabancoglobals);
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
		tipocuentabancoglobals = new  ArrayList<TipoCuentaBancoGlobal>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCuentaBancoGlobalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentabancoglobals=tipocuentabancoglobalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCuentaBancoGlobal(tipocuentabancoglobals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGlobal(this.tipocuentabancoglobals);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipocuentabancoglobal = new  TipoCuentaBancoGlobal();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBancoGlobal.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCuentaBancoGlobalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentabancoglobal=tipocuentabancoglobalDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCuentaBancoGlobal(tipocuentabancoglobal);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGlobal(this.tipocuentabancoglobal);
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
		tipocuentabancoglobal = new  TipoCuentaBancoGlobal();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCuentaBancoGlobalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentabancoglobal=tipocuentabancoglobalDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCuentaBancoGlobal(tipocuentabancoglobal);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGlobal(this.tipocuentabancoglobal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	
	
	public void getTodosTipoCuentaBancoGlobalsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipocuentabancoglobals = new  ArrayList<TipoCuentaBancoGlobal>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBancoGlobal.class.getSimpleName()+"-getTodosTipoCuentaBancoGlobalsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCuentaBancoGlobalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentabancoglobals=tipocuentabancoglobalDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoCuentaBancoGlobal(tipocuentabancoglobals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGlobal(this.tipocuentabancoglobals);
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
	
	public  void  getTodosTipoCuentaBancoGlobals(String sFinalQuery,Pagination pagination)throws Exception {
		tipocuentabancoglobals = new  ArrayList<TipoCuentaBancoGlobal>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCuentaBancoGlobalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocuentabancoglobals=tipocuentabancoglobalDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoCuentaBancoGlobal(tipocuentabancoglobals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGlobal(this.tipocuentabancoglobals);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoCuentaBancoGlobal(TipoCuentaBancoGlobal tipocuentabancoglobal) throws Exception {
		Boolean estaValidado=false;
		
		if(tipocuentabancoglobal.getIsNew() || tipocuentabancoglobal.getIsChanged()) { 
			this.invalidValues = tipocuentabancoglobalValidator.getInvalidValues(tipocuentabancoglobal);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipocuentabancoglobal);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoCuentaBancoGlobal(List<TipoCuentaBancoGlobal> TipoCuentaBancoGlobals) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoCuentaBancoGlobal tipocuentabancoglobalLocal:tipocuentabancoglobals) {				
			estaValidadoObjeto=this.validarGuardarTipoCuentaBancoGlobal(tipocuentabancoglobalLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoCuentaBancoGlobal(List<TipoCuentaBancoGlobal> TipoCuentaBancoGlobals) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoCuentaBancoGlobal(tipocuentabancoglobals)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoCuentaBancoGlobal(TipoCuentaBancoGlobal TipoCuentaBancoGlobal) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoCuentaBancoGlobal(tipocuentabancoglobal)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoCuentaBancoGlobal tipocuentabancoglobal) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipocuentabancoglobal.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoCuentaBancoGlobalConstantesFunciones.getTipoCuentaBancoGlobalLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipocuentabancoglobal","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoCuentaBancoGlobalConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoCuentaBancoGlobalConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoCuentaBancoGlobalWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBancoGlobal.class.getSimpleName()+"-saveTipoCuentaBancoGlobalWithConnection");connexion.begin();			
			
			//TipoCuentaBancoGlobalLogicAdditional.checkTipoCuentaBancoGlobalToSave(this.tipocuentabancoglobal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoCuentaBancoGlobalLogicAdditional.updateTipoCuentaBancoGlobalToSave(this.tipocuentabancoglobal,this.arrDatoGeneral);
			
			TipoCuentaBancoGlobalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipocuentabancoglobal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoCuentaBancoGlobal();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoCuentaBancoGlobal(this.tipocuentabancoglobal)) {
				TipoCuentaBancoGlobalDataAccess.save(this.tipocuentabancoglobal, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipocuentabancoglobal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoCuentaBancoGlobalLogicAdditional.checkTipoCuentaBancoGlobalToSaveAfter(this.tipocuentabancoglobal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoCuentaBancoGlobal();
			
			connexion.commit();			
			
			if(this.tipocuentabancoglobal.getIsDeleted()) {
				this.tipocuentabancoglobal=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoCuentaBancoGlobal()throws Exception {	
		try {	
			
			//TipoCuentaBancoGlobalLogicAdditional.checkTipoCuentaBancoGlobalToSave(this.tipocuentabancoglobal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TipoCuentaBancoGlobalLogicAdditional.updateTipoCuentaBancoGlobalToSave(this.tipocuentabancoglobal,this.arrDatoGeneral);
			
			TipoCuentaBancoGlobalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipocuentabancoglobal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoCuentaBancoGlobal(this.tipocuentabancoglobal)) {			
				TipoCuentaBancoGlobalDataAccess.save(this.tipocuentabancoglobal, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipocuentabancoglobal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			//TipoCuentaBancoGlobalLogicAdditional.checkTipoCuentaBancoGlobalToSaveAfter(this.tipocuentabancoglobal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipocuentabancoglobal.getIsDeleted()) {
				this.tipocuentabancoglobal=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoCuentaBancoGlobalsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBancoGlobal.class.getSimpleName()+"-saveTipoCuentaBancoGlobalsWithConnection");connexion.begin();			
			
			//TipoCuentaBancoGlobalLogicAdditional.checkTipoCuentaBancoGlobalToSaves(tipocuentabancoglobals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoCuentaBancoGlobals();
			
			Boolean validadoTodosTipoCuentaBancoGlobal=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoCuentaBancoGlobal tipocuentabancoglobalLocal:tipocuentabancoglobals) {		
				if(tipocuentabancoglobalLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoCuentaBancoGlobalLogicAdditional.updateTipoCuentaBancoGlobalToSave(tipocuentabancoglobalLocal,this.arrDatoGeneral);
	        	
				TipoCuentaBancoGlobalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipocuentabancoglobalLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoCuentaBancoGlobal(tipocuentabancoglobalLocal)) {
					TipoCuentaBancoGlobalDataAccess.save(tipocuentabancoglobalLocal, connexion);				
				} else {
					validadoTodosTipoCuentaBancoGlobal=false;
				}
			}
			
			if(!validadoTodosTipoCuentaBancoGlobal) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoCuentaBancoGlobalLogicAdditional.checkTipoCuentaBancoGlobalToSavesAfter(tipocuentabancoglobals,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoCuentaBancoGlobals();
			
			connexion.commit();		
			
			this.quitarTipoCuentaBancoGlobalsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoCuentaBancoGlobals()throws Exception {				
		 try {	
			//TipoCuentaBancoGlobalLogicAdditional.checkTipoCuentaBancoGlobalToSaves(tipocuentabancoglobals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoCuentaBancoGlobal=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoCuentaBancoGlobal tipocuentabancoglobalLocal:tipocuentabancoglobals) {				
				if(tipocuentabancoglobalLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				//TipoCuentaBancoGlobalLogicAdditional.updateTipoCuentaBancoGlobalToSave(tipocuentabancoglobalLocal,this.arrDatoGeneral);
	        	
				TipoCuentaBancoGlobalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipocuentabancoglobalLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoCuentaBancoGlobal(tipocuentabancoglobalLocal)) {				
					TipoCuentaBancoGlobalDataAccess.save(tipocuentabancoglobalLocal, connexion);				
				} else {
					validadoTodosTipoCuentaBancoGlobal=false;
				}
			}
			
			if(!validadoTodosTipoCuentaBancoGlobal) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			//TipoCuentaBancoGlobalLogicAdditional.checkTipoCuentaBancoGlobalToSavesAfter(tipocuentabancoglobals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoCuentaBancoGlobalsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoCuentaBancoGlobalParameterReturnGeneral procesarAccionTipoCuentaBancoGlobals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoCuentaBancoGlobal> tipocuentabancoglobals,TipoCuentaBancoGlobalParameterReturnGeneral tipocuentabancoglobalParameterGeneral)throws Exception {
		 try {	
			TipoCuentaBancoGlobalParameterReturnGeneral tipocuentabancoglobalReturnGeneral=new TipoCuentaBancoGlobalParameterReturnGeneral();
	
			
			return tipocuentabancoglobalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoCuentaBancoGlobalParameterReturnGeneral procesarAccionTipoCuentaBancoGlobalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoCuentaBancoGlobal> tipocuentabancoglobals,TipoCuentaBancoGlobalParameterReturnGeneral tipocuentabancoglobalParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBancoGlobal.class.getSimpleName()+"-procesarAccionTipoCuentaBancoGlobalsWithConnection");connexion.begin();			
			
			TipoCuentaBancoGlobalParameterReturnGeneral tipocuentabancoglobalReturnGeneral=new TipoCuentaBancoGlobalParameterReturnGeneral();
	
			
			this.connexion.commit();
			
			return tipocuentabancoglobalReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoCuentaBancoGlobalParameterReturnGeneral procesarEventosTipoCuentaBancoGlobals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoCuentaBancoGlobal> tipocuentabancoglobals,TipoCuentaBancoGlobal tipocuentabancoglobal,TipoCuentaBancoGlobalParameterReturnGeneral tipocuentabancoglobalParameterGeneral,Boolean isEsNuevoTipoCuentaBancoGlobal,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoCuentaBancoGlobalParameterReturnGeneral tipocuentabancoglobalReturnGeneral=new TipoCuentaBancoGlobalParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipocuentabancoglobalReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			return tipocuentabancoglobalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoCuentaBancoGlobalParameterReturnGeneral procesarEventosTipoCuentaBancoGlobalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoCuentaBancoGlobal> tipocuentabancoglobals,TipoCuentaBancoGlobal tipocuentabancoglobal,TipoCuentaBancoGlobalParameterReturnGeneral tipocuentabancoglobalParameterGeneral,Boolean isEsNuevoTipoCuentaBancoGlobal,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBancoGlobal.class.getSimpleName()+"-procesarEventosTipoCuentaBancoGlobalsWithConnection");connexion.begin();			
			
			TipoCuentaBancoGlobalParameterReturnGeneral tipocuentabancoglobalReturnGeneral=new TipoCuentaBancoGlobalParameterReturnGeneral();
	
			tipocuentabancoglobalReturnGeneral.setTipoCuentaBancoGlobal(tipocuentabancoglobal);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipocuentabancoglobalReturnGeneral.setConRecargarPropiedades(true);
			}
			
			
			this.connexion.commit();
			
			return tipocuentabancoglobalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoCuentaBancoGlobalParameterReturnGeneral procesarImportacionTipoCuentaBancoGlobalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoCuentaBancoGlobalParameterReturnGeneral tipocuentabancoglobalParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBancoGlobal.class.getSimpleName()+"-procesarImportacionTipoCuentaBancoGlobalsWithConnection");connexion.begin();			
			
			TipoCuentaBancoGlobalParameterReturnGeneral tipocuentabancoglobalReturnGeneral=new TipoCuentaBancoGlobalParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipocuentabancoglobals=new ArrayList<TipoCuentaBancoGlobal>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipocuentabancoglobal=new TipoCuentaBancoGlobal();
				
				
				if(conColumnasBase) {this.tipocuentabancoglobal.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipocuentabancoglobal.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipocuentabancoglobal.setcodigo(arrColumnas[iColumn++]);
				this.tipocuentabancoglobal.setnombre(arrColumnas[iColumn++]);
				
				this.tipocuentabancoglobals.add(this.tipocuentabancoglobal);
			}
			
			this.saveTipoCuentaBancoGlobals();
			
			this.connexion.commit();
			
			tipocuentabancoglobalReturnGeneral.setConRetornoEstaProcesado(true);
			tipocuentabancoglobalReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipocuentabancoglobalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoCuentaBancoGlobalsEliminados() throws Exception {				
		
		List<TipoCuentaBancoGlobal> tipocuentabancoglobalsAux= new ArrayList<TipoCuentaBancoGlobal>();
		
		for(TipoCuentaBancoGlobal tipocuentabancoglobal:tipocuentabancoglobals) {
			if(!tipocuentabancoglobal.getIsDeleted()) {
				tipocuentabancoglobalsAux.add(tipocuentabancoglobal);
			}
		}
		
		tipocuentabancoglobals=tipocuentabancoglobalsAux;
	}
	
	public void quitarTipoCuentaBancoGlobalsNulos() throws Exception {				
		
		List<TipoCuentaBancoGlobal> tipocuentabancoglobalsAux= new ArrayList<TipoCuentaBancoGlobal>();
		
		for(TipoCuentaBancoGlobal tipocuentabancoglobal : this.tipocuentabancoglobals) {
			if(tipocuentabancoglobal==null) {
				tipocuentabancoglobalsAux.add(tipocuentabancoglobal);
			}
		}
		
		//this.tipocuentabancoglobals=tipocuentabancoglobalsAux;
		
		this.tipocuentabancoglobals.removeAll(tipocuentabancoglobalsAux);
	}
	
	public void getSetVersionRowTipoCuentaBancoGlobalWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipocuentabancoglobal.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipocuentabancoglobal.getIsDeleted() || (tipocuentabancoglobal.getIsChanged()&&!tipocuentabancoglobal.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipocuentabancoglobalDataAccess.getSetVersionRowTipoCuentaBancoGlobal(connexion,tipocuentabancoglobal.getId());
				
				if(!tipocuentabancoglobal.getVersionRow().equals(timestamp)) {	
					tipocuentabancoglobal.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipocuentabancoglobal.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoCuentaBancoGlobal()throws Exception {	
		
		if(tipocuentabancoglobal.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipocuentabancoglobal.getIsDeleted() || (tipocuentabancoglobal.getIsChanged()&&!tipocuentabancoglobal.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipocuentabancoglobalDataAccess.getSetVersionRowTipoCuentaBancoGlobal(connexion,tipocuentabancoglobal.getId());
			
			try {							
				if(!tipocuentabancoglobal.getVersionRow().equals(timestamp)) {	
					tipocuentabancoglobal.setVersionRow(timestamp);
				}
				
				tipocuentabancoglobal.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoCuentaBancoGlobalsWithConnection()throws Exception {	
		if(tipocuentabancoglobals!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoCuentaBancoGlobal tipocuentabancoglobalAux:tipocuentabancoglobals) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipocuentabancoglobalAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipocuentabancoglobalAux.getIsDeleted() || (tipocuentabancoglobalAux.getIsChanged()&&!tipocuentabancoglobalAux.getIsNew())) {
						
						timestamp=tipocuentabancoglobalDataAccess.getSetVersionRowTipoCuentaBancoGlobal(connexion,tipocuentabancoglobalAux.getId());
						
						if(!tipocuentabancoglobal.getVersionRow().equals(timestamp)) {	
							tipocuentabancoglobalAux.setVersionRow(timestamp);
						}
								
						tipocuentabancoglobalAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoCuentaBancoGlobals()throws Exception {	
		if(tipocuentabancoglobals!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoCuentaBancoGlobal tipocuentabancoglobalAux:tipocuentabancoglobals) {
					if(tipocuentabancoglobalAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipocuentabancoglobalAux.getIsDeleted() || (tipocuentabancoglobalAux.getIsChanged()&&!tipocuentabancoglobalAux.getIsNew())) {
						
						timestamp=tipocuentabancoglobalDataAccess.getSetVersionRowTipoCuentaBancoGlobal(connexion,tipocuentabancoglobalAux.getId());
						
						if(!tipocuentabancoglobalAux.getVersionRow().equals(timestamp)) {	
							tipocuentabancoglobalAux.setVersionRow(timestamp);
						}
						
													
						tipocuentabancoglobalAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyTipoCuentaBancoGlobalWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			BancoTipoCuentaBancoGlobalLogic bancotipocuentabancoglobalLogic=new BancoTipoCuentaBancoGlobalLogic();
			DatoGeneralEmpleadoLogic datogeneralempleadoLogic=new DatoGeneralEmpleadoLogic();
			PoliticasClienteLogic politicasclienteLogic=new PoliticasClienteLogic();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			ParametroTesoreriaDefectoLogic parametrotesoreriadefectoLogic=new ParametroTesoreriaDefectoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCuentaBancoGlobal.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoCuentaBancoGlobalWithConnection");connexion.begin();
			
			
			classes.add(new Classe(BancoTipoCuentaBancoGlobal.class));
			classes.add(new Classe(DatoGeneralEmpleado.class));
			classes.add(new Classe(PoliticasCliente.class));
			classes.add(new Classe(Empleado.class));
			classes.add(new Classe(ParametroTesoreriaDefecto.class));
											
			

			bancotipocuentabancoglobalLogic.setConnexion(this.getConnexion());
			bancotipocuentabancoglobalLogic.setDatosCliente(this.datosCliente);
			bancotipocuentabancoglobalLogic.setIsConRefrescarForeignKeys(true);

			datogeneralempleadoLogic.setConnexion(this.getConnexion());
			datogeneralempleadoLogic.setDatosCliente(this.datosCliente);
			datogeneralempleadoLogic.setIsConRefrescarForeignKeys(true);

			politicasclienteLogic.setConnexion(this.getConnexion());
			politicasclienteLogic.setDatosCliente(this.datosCliente);
			politicasclienteLogic.setIsConRefrescarForeignKeys(true);

			empleadoLogic.setConnexion(this.getConnexion());
			empleadoLogic.setDatosCliente(this.datosCliente);
			empleadoLogic.setIsConRefrescarForeignKeys(true);

			parametrotesoreriadefectoLogic.setConnexion(this.getConnexion());
			parametrotesoreriadefectoLogic.setDatosCliente(this.datosCliente);
			parametrotesoreriadefectoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoCuentaBancoGlobal tipocuentabancoglobal:this.tipocuentabancoglobals) {
				

				classes=new ArrayList<Classe>();
				classes=BancoTipoCuentaBancoGlobalConstantesFunciones.getClassesForeignKeysOfBancoTipoCuentaBancoGlobal(new ArrayList<Classe>(),DeepLoadType.NONE);

				bancotipocuentabancoglobalLogic.setBancoTipoCuentaBancoGlobals(tipocuentabancoglobal.bancotipocuentabancoglobals);
				bancotipocuentabancoglobalLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DatoGeneralEmpleadoConstantesFunciones.getClassesForeignKeysOfDatoGeneralEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);

				datogeneralempleadoLogic.setDatoGeneralEmpleados(tipocuentabancoglobal.datogeneralempleados);
				datogeneralempleadoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PoliticasClienteConstantesFunciones.getClassesForeignKeysOfPoliticasCliente(new ArrayList<Classe>(),DeepLoadType.NONE);

				politicasclienteLogic.setPoliticasClientes(tipocuentabancoglobal.politicasclientes);
				politicasclienteLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=EmpleadoConstantesFunciones.getClassesForeignKeysOfEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);

				empleadoLogic.setEmpleados(tipocuentabancoglobal.empleados);
				empleadoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ParametroTesoreriaDefectoConstantesFunciones.getClassesForeignKeysOfParametroTesoreriaDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);

				parametrotesoreriadefectoLogic.setParametroTesoreriaDefectos(tipocuentabancoglobal.parametrotesoreriadefectos);
				parametrotesoreriadefectoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoCuentaBancoGlobal tipocuentabancoglobal,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			//TipoCuentaBancoGlobalLogicAdditional.updateTipoCuentaBancoGlobalToGet(tipocuentabancoglobal,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipocuentabancoglobal.setBancoTipoCuentaBancoGlobals(tipocuentabancoglobalDataAccess.getBancoTipoCuentaBancoGlobals(connexion,tipocuentabancoglobal));
		tipocuentabancoglobal.setDatoGeneralEmpleados(tipocuentabancoglobalDataAccess.getDatoGeneralEmpleados(connexion,tipocuentabancoglobal));
		tipocuentabancoglobal.setPoliticasClientes(tipocuentabancoglobalDataAccess.getPoliticasClientes(connexion,tipocuentabancoglobal));
		tipocuentabancoglobal.setEmpleados(tipocuentabancoglobalDataAccess.getEmpleados(connexion,tipocuentabancoglobal));
		tipocuentabancoglobal.setParametroTesoreriaDefectos(tipocuentabancoglobalDataAccess.getParametroTesoreriaDefectos(connexion,tipocuentabancoglobal));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(BancoTipoCuentaBancoGlobal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocuentabancoglobal.setBancoTipoCuentaBancoGlobals(tipocuentabancoglobalDataAccess.getBancoTipoCuentaBancoGlobals(connexion,tipocuentabancoglobal));

				if(this.isConDeep) {
					BancoTipoCuentaBancoGlobalLogic bancotipocuentabancoglobalLogic= new BancoTipoCuentaBancoGlobalLogic(this.connexion);
					bancotipocuentabancoglobalLogic.setBancoTipoCuentaBancoGlobals(tipocuentabancoglobal.getBancoTipoCuentaBancoGlobals());
					ArrayList<Classe> classesLocal=BancoTipoCuentaBancoGlobalConstantesFunciones.getClassesForeignKeysOfBancoTipoCuentaBancoGlobal(new ArrayList<Classe>(),DeepLoadType.NONE);
					bancotipocuentabancoglobalLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					BancoTipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesBancoTipoCuentaBancoGlobal(bancotipocuentabancoglobalLogic.getBancoTipoCuentaBancoGlobals());
					tipocuentabancoglobal.setBancoTipoCuentaBancoGlobals(bancotipocuentabancoglobalLogic.getBancoTipoCuentaBancoGlobals());
				}

				continue;
			}

			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocuentabancoglobal.setDatoGeneralEmpleados(tipocuentabancoglobalDataAccess.getDatoGeneralEmpleados(connexion,tipocuentabancoglobal));

				if(this.isConDeep) {
					DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(this.connexion);
					datogeneralempleadoLogic.setDatoGeneralEmpleados(tipocuentabancoglobal.getDatoGeneralEmpleados());
					ArrayList<Classe> classesLocal=DatoGeneralEmpleadoConstantesFunciones.getClassesForeignKeysOfDatoGeneralEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);
					datogeneralempleadoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DatoGeneralEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDatoGeneralEmpleado(datogeneralempleadoLogic.getDatoGeneralEmpleados());
					tipocuentabancoglobal.setDatoGeneralEmpleados(datogeneralempleadoLogic.getDatoGeneralEmpleados());
				}

				continue;
			}

			if(clas.clas.equals(PoliticasCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocuentabancoglobal.setPoliticasClientes(tipocuentabancoglobalDataAccess.getPoliticasClientes(connexion,tipocuentabancoglobal));

				if(this.isConDeep) {
					PoliticasClienteLogic politicasclienteLogic= new PoliticasClienteLogic(this.connexion);
					politicasclienteLogic.setPoliticasClientes(tipocuentabancoglobal.getPoliticasClientes());
					ArrayList<Classe> classesLocal=PoliticasClienteConstantesFunciones.getClassesForeignKeysOfPoliticasCliente(new ArrayList<Classe>(),DeepLoadType.NONE);
					politicasclienteLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PoliticasClienteConstantesFunciones.refrescarForeignKeysDescripcionesPoliticasCliente(politicasclienteLogic.getPoliticasClientes());
					tipocuentabancoglobal.setPoliticasClientes(politicasclienteLogic.getPoliticasClientes());
				}

				continue;
			}

			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocuentabancoglobal.setEmpleados(tipocuentabancoglobalDataAccess.getEmpleados(connexion,tipocuentabancoglobal));

				if(this.isConDeep) {
					EmpleadoLogic empleadoLogic= new EmpleadoLogic(this.connexion);
					empleadoLogic.setEmpleados(tipocuentabancoglobal.getEmpleados());
					ArrayList<Classe> classesLocal=EmpleadoConstantesFunciones.getClassesForeignKeysOfEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);
					empleadoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(empleadoLogic.getEmpleados());
					tipocuentabancoglobal.setEmpleados(empleadoLogic.getEmpleados());
				}

				continue;
			}

			if(clas.clas.equals(ParametroTesoreriaDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocuentabancoglobal.setParametroTesoreriaDefectos(tipocuentabancoglobalDataAccess.getParametroTesoreriaDefectos(connexion,tipocuentabancoglobal));

				if(this.isConDeep) {
					ParametroTesoreriaDefectoLogic parametrotesoreriadefectoLogic= new ParametroTesoreriaDefectoLogic(this.connexion);
					parametrotesoreriadefectoLogic.setParametroTesoreriaDefectos(tipocuentabancoglobal.getParametroTesoreriaDefectos());
					ArrayList<Classe> classesLocal=ParametroTesoreriaDefectoConstantesFunciones.getClassesForeignKeysOfParametroTesoreriaDefecto(new ArrayList<Classe>(),DeepLoadType.NONE);
					parametrotesoreriadefectoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ParametroTesoreriaDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreriaDefecto(parametrotesoreriadefectoLogic.getParametroTesoreriaDefectos());
					tipocuentabancoglobal.setParametroTesoreriaDefectos(parametrotesoreriadefectoLogic.getParametroTesoreriaDefectos());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(BancoTipoCuentaBancoGlobal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(BancoTipoCuentaBancoGlobal.class));
			tipocuentabancoglobal.setBancoTipoCuentaBancoGlobals(tipocuentabancoglobalDataAccess.getBancoTipoCuentaBancoGlobals(connexion,tipocuentabancoglobal));
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
			tipocuentabancoglobal.setDatoGeneralEmpleados(tipocuentabancoglobalDataAccess.getDatoGeneralEmpleados(connexion,tipocuentabancoglobal));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PoliticasCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PoliticasCliente.class));
			tipocuentabancoglobal.setPoliticasClientes(tipocuentabancoglobalDataAccess.getPoliticasClientes(connexion,tipocuentabancoglobal));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Empleado.class));
			tipocuentabancoglobal.setEmpleados(tipocuentabancoglobalDataAccess.getEmpleados(connexion,tipocuentabancoglobal));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroTesoreriaDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroTesoreriaDefecto.class));
			tipocuentabancoglobal.setParametroTesoreriaDefectos(tipocuentabancoglobalDataAccess.getParametroTesoreriaDefectos(connexion,tipocuentabancoglobal));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		tipocuentabancoglobal.setBancoTipoCuentaBancoGlobals(tipocuentabancoglobalDataAccess.getBancoTipoCuentaBancoGlobals(connexion,tipocuentabancoglobal));

		for(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal:tipocuentabancoglobal.getBancoTipoCuentaBancoGlobals()) {
			BancoTipoCuentaBancoGlobalLogic bancotipocuentabancoglobalLogic= new BancoTipoCuentaBancoGlobalLogic(connexion);
			bancotipocuentabancoglobalLogic.deepLoad(bancotipocuentabancoglobal,isDeep,deepLoadType,clases);
		}

		tipocuentabancoglobal.setDatoGeneralEmpleados(tipocuentabancoglobalDataAccess.getDatoGeneralEmpleados(connexion,tipocuentabancoglobal));

		for(DatoGeneralEmpleado datogeneralempleado:tipocuentabancoglobal.getDatoGeneralEmpleados()) {
			DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);
			datogeneralempleadoLogic.deepLoad(datogeneralempleado,isDeep,deepLoadType,clases);
		}

		tipocuentabancoglobal.setPoliticasClientes(tipocuentabancoglobalDataAccess.getPoliticasClientes(connexion,tipocuentabancoglobal));

		for(PoliticasCliente politicascliente:tipocuentabancoglobal.getPoliticasClientes()) {
			PoliticasClienteLogic politicasclienteLogic= new PoliticasClienteLogic(connexion);
			politicasclienteLogic.deepLoad(politicascliente,isDeep,deepLoadType,clases);
		}

		tipocuentabancoglobal.setEmpleados(tipocuentabancoglobalDataAccess.getEmpleados(connexion,tipocuentabancoglobal));

		for(Empleado empleado:tipocuentabancoglobal.getEmpleados()) {
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(empleado,isDeep,deepLoadType,clases);
		}

		tipocuentabancoglobal.setParametroTesoreriaDefectos(tipocuentabancoglobalDataAccess.getParametroTesoreriaDefectos(connexion,tipocuentabancoglobal));

		for(ParametroTesoreriaDefecto parametrotesoreriadefecto:tipocuentabancoglobal.getParametroTesoreriaDefectos()) {
			ParametroTesoreriaDefectoLogic parametrotesoreriadefectoLogic= new ParametroTesoreriaDefectoLogic(connexion);
			parametrotesoreriadefectoLogic.deepLoad(parametrotesoreriadefecto,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(BancoTipoCuentaBancoGlobal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocuentabancoglobal.setBancoTipoCuentaBancoGlobals(tipocuentabancoglobalDataAccess.getBancoTipoCuentaBancoGlobals(connexion,tipocuentabancoglobal));

				for(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal:tipocuentabancoglobal.getBancoTipoCuentaBancoGlobals()) {
					BancoTipoCuentaBancoGlobalLogic bancotipocuentabancoglobalLogic= new BancoTipoCuentaBancoGlobalLogic(connexion);
					bancotipocuentabancoglobalLogic.deepLoad(bancotipocuentabancoglobal,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DatoGeneralEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocuentabancoglobal.setDatoGeneralEmpleados(tipocuentabancoglobalDataAccess.getDatoGeneralEmpleados(connexion,tipocuentabancoglobal));

				for(DatoGeneralEmpleado datogeneralempleado:tipocuentabancoglobal.getDatoGeneralEmpleados()) {
					DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);
					datogeneralempleadoLogic.deepLoad(datogeneralempleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PoliticasCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocuentabancoglobal.setPoliticasClientes(tipocuentabancoglobalDataAccess.getPoliticasClientes(connexion,tipocuentabancoglobal));

				for(PoliticasCliente politicascliente:tipocuentabancoglobal.getPoliticasClientes()) {
					PoliticasClienteLogic politicasclienteLogic= new PoliticasClienteLogic(connexion);
					politicasclienteLogic.deepLoad(politicascliente,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocuentabancoglobal.setEmpleados(tipocuentabancoglobalDataAccess.getEmpleados(connexion,tipocuentabancoglobal));

				for(Empleado empleado:tipocuentabancoglobal.getEmpleados()) {
					EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
					empleadoLogic.deepLoad(empleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ParametroTesoreriaDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocuentabancoglobal.setParametroTesoreriaDefectos(tipocuentabancoglobalDataAccess.getParametroTesoreriaDefectos(connexion,tipocuentabancoglobal));

				for(ParametroTesoreriaDefecto parametrotesoreriadefecto:tipocuentabancoglobal.getParametroTesoreriaDefectos()) {
					ParametroTesoreriaDefectoLogic parametrotesoreriadefectoLogic= new ParametroTesoreriaDefectoLogic(connexion);
					parametrotesoreriadefectoLogic.deepLoad(parametrotesoreriadefecto,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(BancoTipoCuentaBancoGlobal.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(BancoTipoCuentaBancoGlobal.class));
			tipocuentabancoglobal.setBancoTipoCuentaBancoGlobals(tipocuentabancoglobalDataAccess.getBancoTipoCuentaBancoGlobals(connexion,tipocuentabancoglobal));

			for(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal:tipocuentabancoglobal.getBancoTipoCuentaBancoGlobals()) {
				BancoTipoCuentaBancoGlobalLogic bancotipocuentabancoglobalLogic= new BancoTipoCuentaBancoGlobalLogic(connexion);
				bancotipocuentabancoglobalLogic.deepLoad(bancotipocuentabancoglobal,isDeep,deepLoadType,clases);
			}
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
			tipocuentabancoglobal.setDatoGeneralEmpleados(tipocuentabancoglobalDataAccess.getDatoGeneralEmpleados(connexion,tipocuentabancoglobal));

			for(DatoGeneralEmpleado datogeneralempleado:tipocuentabancoglobal.getDatoGeneralEmpleados()) {
				DatoGeneralEmpleadoLogic datogeneralempleadoLogic= new DatoGeneralEmpleadoLogic(connexion);
				datogeneralempleadoLogic.deepLoad(datogeneralempleado,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PoliticasCliente.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PoliticasCliente.class));
			tipocuentabancoglobal.setPoliticasClientes(tipocuentabancoglobalDataAccess.getPoliticasClientes(connexion,tipocuentabancoglobal));

			for(PoliticasCliente politicascliente:tipocuentabancoglobal.getPoliticasClientes()) {
				PoliticasClienteLogic politicasclienteLogic= new PoliticasClienteLogic(connexion);
				politicasclienteLogic.deepLoad(politicascliente,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Empleado.class));
			tipocuentabancoglobal.setEmpleados(tipocuentabancoglobalDataAccess.getEmpleados(connexion,tipocuentabancoglobal));

			for(Empleado empleado:tipocuentabancoglobal.getEmpleados()) {
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(empleado,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroTesoreriaDefecto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ParametroTesoreriaDefecto.class));
			tipocuentabancoglobal.setParametroTesoreriaDefectos(tipocuentabancoglobalDataAccess.getParametroTesoreriaDefectos(connexion,tipocuentabancoglobal));

			for(ParametroTesoreriaDefecto parametrotesoreriadefecto:tipocuentabancoglobal.getParametroTesoreriaDefectos()) {
				ParametroTesoreriaDefectoLogic parametrotesoreriadefectoLogic= new ParametroTesoreriaDefectoLogic(connexion);
				parametrotesoreriadefectoLogic.deepLoad(parametrotesoreriadefecto,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoCuentaBancoGlobal tipocuentabancoglobal,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoCuentaBancoGlobal.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipocuentabancoglobal,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGlobal(tipocuentabancoglobal);
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
			this.deepLoad(this.tipocuentabancoglobal,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGlobal(this.tipocuentabancoglobal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoCuentaBancoGlobal.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipocuentabancoglobals!=null) {
				for(TipoCuentaBancoGlobal tipocuentabancoglobal:tipocuentabancoglobals) {
					this.deepLoad(tipocuentabancoglobal,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGlobal(tipocuentabancoglobals);
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
			if(tipocuentabancoglobals!=null) {
				for(TipoCuentaBancoGlobal tipocuentabancoglobal:tipocuentabancoglobals) {
					this.deepLoad(tipocuentabancoglobal,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesTipoCuentaBancoGlobal(tipocuentabancoglobals);
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
	
	
	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoCuentaBancoGlobalConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCuentaBancoGlobalDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoCuentaBancoGlobal tipocuentabancoglobal,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoCuentaBancoGlobalConstantesFunciones.ISCONAUDITORIA) {
				if(tipocuentabancoglobal.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCuentaBancoGlobalDataAccess.TABLENAME, tipocuentabancoglobal.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoCuentaBancoGlobalConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoCuentaBancoGlobalLogic.registrarAuditoriaDetallesTipoCuentaBancoGlobal(connexion,tipocuentabancoglobal,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipocuentabancoglobal.getIsDeleted()) {
					/*if(!tipocuentabancoglobal.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoCuentaBancoGlobalDataAccess.TABLENAME, tipocuentabancoglobal.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoCuentaBancoGlobalLogic.registrarAuditoriaDetallesTipoCuentaBancoGlobal(connexion,tipocuentabancoglobal,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCuentaBancoGlobalDataAccess.TABLENAME, tipocuentabancoglobal.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipocuentabancoglobal.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCuentaBancoGlobalDataAccess.TABLENAME, tipocuentabancoglobal.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoCuentaBancoGlobalConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoCuentaBancoGlobalLogic.registrarAuditoriaDetallesTipoCuentaBancoGlobal(connexion,tipocuentabancoglobal,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoCuentaBancoGlobal(Connexion connexion,TipoCuentaBancoGlobal tipocuentabancoglobal)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipocuentabancoglobal.getIsNew()||!tipocuentabancoglobal.getcodigo().equals(tipocuentabancoglobal.getTipoCuentaBancoGlobalOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocuentabancoglobal.getTipoCuentaBancoGlobalOriginal().getcodigo()!=null)
				{
					strValorActual=tipocuentabancoglobal.getTipoCuentaBancoGlobalOriginal().getcodigo();
				}
				if(tipocuentabancoglobal.getcodigo()!=null)
				{
					strValorNuevo=tipocuentabancoglobal.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoCuentaBancoGlobalConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipocuentabancoglobal.getIsNew()||!tipocuentabancoglobal.getnombre().equals(tipocuentabancoglobal.getTipoCuentaBancoGlobalOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocuentabancoglobal.getTipoCuentaBancoGlobalOriginal().getnombre()!=null)
				{
					strValorActual=tipocuentabancoglobal.getTipoCuentaBancoGlobalOriginal().getnombre();
				}
				if(tipocuentabancoglobal.getnombre()!=null)
				{
					strValorNuevo=tipocuentabancoglobal.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoCuentaBancoGlobalConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoCuentaBancoGlobal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoCuentaBancoGlobalConstantesFunciones.getClassesForeignKeysOfTipoCuentaBancoGlobal(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCuentaBancoGlobal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoCuentaBancoGlobalConstantesFunciones.getClassesRelationshipsOfTipoCuentaBancoGlobal(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
}

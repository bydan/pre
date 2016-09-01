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
import com.bydan.erp.tesoreria.util.BancoTipoCuentaBancoGlobalConstantesFunciones;
import com.bydan.erp.tesoreria.util.BancoTipoCuentaBancoGlobalParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.BancoTipoCuentaBancoGlobalParameterGeneral;
import com.bydan.erp.tesoreria.business.entity.BancoTipoCuentaBancoGlobal;
import com.bydan.erp.tesoreria.business.logic.BancoTipoCuentaBancoGlobalLogicAdditional;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class BancoTipoCuentaBancoGlobalLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(BancoTipoCuentaBancoGlobalLogic.class);
	
	protected BancoTipoCuentaBancoGlobalDataAccess bancotipocuentabancoglobalDataAccess; 	
	protected BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal;
	protected List<BancoTipoCuentaBancoGlobal> bancotipocuentabancoglobals;
	protected Object bancotipocuentabancoglobalObject;	
	protected List<Object> bancotipocuentabancoglobalsObject;
	
	public static ClassValidator<BancoTipoCuentaBancoGlobal> bancotipocuentabancoglobalValidator = new ClassValidator<BancoTipoCuentaBancoGlobal>(BancoTipoCuentaBancoGlobal.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected BancoTipoCuentaBancoGlobalLogicAdditional bancotipocuentabancoglobalLogicAdditional=null;
	
	public BancoTipoCuentaBancoGlobalLogicAdditional getBancoTipoCuentaBancoGlobalLogicAdditional() {
		return this.bancotipocuentabancoglobalLogicAdditional;
	}
	
	public void setBancoTipoCuentaBancoGlobalLogicAdditional(BancoTipoCuentaBancoGlobalLogicAdditional bancotipocuentabancoglobalLogicAdditional) {
		try {
			this.bancotipocuentabancoglobalLogicAdditional=bancotipocuentabancoglobalLogicAdditional;
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
	
	
	
	
	public  BancoTipoCuentaBancoGlobalLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.bancotipocuentabancoglobalDataAccess = new BancoTipoCuentaBancoGlobalDataAccess();
			
			this.bancotipocuentabancoglobals= new ArrayList<BancoTipoCuentaBancoGlobal>();
			this.bancotipocuentabancoglobal= new BancoTipoCuentaBancoGlobal();
			
			this.bancotipocuentabancoglobalObject=new Object();
			this.bancotipocuentabancoglobalsObject=new ArrayList<Object>();
				
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
			
			this.bancotipocuentabancoglobalDataAccess.setConnexionType(this.connexionType);
			this.bancotipocuentabancoglobalDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  BancoTipoCuentaBancoGlobalLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.bancotipocuentabancoglobalDataAccess = new BancoTipoCuentaBancoGlobalDataAccess();
			this.bancotipocuentabancoglobals= new ArrayList<BancoTipoCuentaBancoGlobal>();
			this.bancotipocuentabancoglobal= new BancoTipoCuentaBancoGlobal();
			this.bancotipocuentabancoglobalObject=new Object();
			this.bancotipocuentabancoglobalsObject=new ArrayList<Object>();
			
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
			
			this.bancotipocuentabancoglobalDataAccess.setConnexionType(this.connexionType);
			this.bancotipocuentabancoglobalDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public BancoTipoCuentaBancoGlobal getBancoTipoCuentaBancoGlobal() throws Exception {	
		BancoTipoCuentaBancoGlobalLogicAdditional.checkBancoTipoCuentaBancoGlobalToGet(bancotipocuentabancoglobal,this.datosCliente,this.arrDatoGeneral);
		BancoTipoCuentaBancoGlobalLogicAdditional.updateBancoTipoCuentaBancoGlobalToGet(bancotipocuentabancoglobal,this.arrDatoGeneral);
		
		return bancotipocuentabancoglobal;
	}
		
	public void setBancoTipoCuentaBancoGlobal(BancoTipoCuentaBancoGlobal newBancoTipoCuentaBancoGlobal) {
		this.bancotipocuentabancoglobal = newBancoTipoCuentaBancoGlobal;
	}
	
	public BancoTipoCuentaBancoGlobalDataAccess getBancoTipoCuentaBancoGlobalDataAccess() {
		return bancotipocuentabancoglobalDataAccess;
	}
	
	public void setBancoTipoCuentaBancoGlobalDataAccess(BancoTipoCuentaBancoGlobalDataAccess newbancotipocuentabancoglobalDataAccess) {
		this.bancotipocuentabancoglobalDataAccess = newbancotipocuentabancoglobalDataAccess;
	}
	
	public List<BancoTipoCuentaBancoGlobal> getBancoTipoCuentaBancoGlobals() throws Exception {		
		this.quitarBancoTipoCuentaBancoGlobalsNulos();
		
		BancoTipoCuentaBancoGlobalLogicAdditional.checkBancoTipoCuentaBancoGlobalToGets(bancotipocuentabancoglobals,this.datosCliente,this.arrDatoGeneral);
		
		for (BancoTipoCuentaBancoGlobal bancotipocuentabancoglobalLocal: bancotipocuentabancoglobals ) {
			BancoTipoCuentaBancoGlobalLogicAdditional.updateBancoTipoCuentaBancoGlobalToGet(bancotipocuentabancoglobalLocal,this.arrDatoGeneral);
		}
		
		return bancotipocuentabancoglobals;
	}
	
	public void setBancoTipoCuentaBancoGlobals(List<BancoTipoCuentaBancoGlobal> newBancoTipoCuentaBancoGlobals) {
		this.bancotipocuentabancoglobals = newBancoTipoCuentaBancoGlobals;
	}
	
	public Object getBancoTipoCuentaBancoGlobalObject() {	
		this.bancotipocuentabancoglobalObject=this.bancotipocuentabancoglobalDataAccess.getEntityObject();
		return this.bancotipocuentabancoglobalObject;
	}
		
	public void setBancoTipoCuentaBancoGlobalObject(Object newBancoTipoCuentaBancoGlobalObject) {
		this.bancotipocuentabancoglobalObject = newBancoTipoCuentaBancoGlobalObject;
	}
	
	public List<Object> getBancoTipoCuentaBancoGlobalsObject() {		
		this.bancotipocuentabancoglobalsObject=this.bancotipocuentabancoglobalDataAccess.getEntitiesObject();
		return this.bancotipocuentabancoglobalsObject;
	}
		
	public void setBancoTipoCuentaBancoGlobalsObject(List<Object> newBancoTipoCuentaBancoGlobalsObject) {
		this.bancotipocuentabancoglobalsObject = newBancoTipoCuentaBancoGlobalsObject;
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
		
		if(this.bancotipocuentabancoglobalDataAccess!=null) {
			this.bancotipocuentabancoglobalDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoTipoCuentaBancoGlobal.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			bancotipocuentabancoglobalDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			bancotipocuentabancoglobalDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		bancotipocuentabancoglobal = new  BancoTipoCuentaBancoGlobal();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoTipoCuentaBancoGlobal.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			bancotipocuentabancoglobal=bancotipocuentabancoglobalDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.bancotipocuentabancoglobal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				BancoTipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesBancoTipoCuentaBancoGlobal(this.bancotipocuentabancoglobal);
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
		bancotipocuentabancoglobal = new  BancoTipoCuentaBancoGlobal();
		  		  
        try {
			
			bancotipocuentabancoglobal=bancotipocuentabancoglobalDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.bancotipocuentabancoglobal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				BancoTipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesBancoTipoCuentaBancoGlobal(this.bancotipocuentabancoglobal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		bancotipocuentabancoglobal = new  BancoTipoCuentaBancoGlobal();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoTipoCuentaBancoGlobal.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			bancotipocuentabancoglobal=bancotipocuentabancoglobalDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.bancotipocuentabancoglobal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				BancoTipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesBancoTipoCuentaBancoGlobal(this.bancotipocuentabancoglobal);
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
		bancotipocuentabancoglobal = new  BancoTipoCuentaBancoGlobal();
		  		  
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
		bancotipocuentabancoglobal = new  BancoTipoCuentaBancoGlobal();
		  		  
        try {
			
			bancotipocuentabancoglobal=bancotipocuentabancoglobalDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.bancotipocuentabancoglobal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				BancoTipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesBancoTipoCuentaBancoGlobal(this.bancotipocuentabancoglobal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		bancotipocuentabancoglobal = new  BancoTipoCuentaBancoGlobal();
		  		  
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
		bancotipocuentabancoglobal = new  BancoTipoCuentaBancoGlobal();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoTipoCuentaBancoGlobal.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =bancotipocuentabancoglobalDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		bancotipocuentabancoglobal = new  BancoTipoCuentaBancoGlobal();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=bancotipocuentabancoglobalDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		bancotipocuentabancoglobal = new  BancoTipoCuentaBancoGlobal();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoTipoCuentaBancoGlobal.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =bancotipocuentabancoglobalDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		bancotipocuentabancoglobal = new  BancoTipoCuentaBancoGlobal();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=bancotipocuentabancoglobalDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		bancotipocuentabancoglobal = new  BancoTipoCuentaBancoGlobal();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoTipoCuentaBancoGlobal.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =bancotipocuentabancoglobalDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		bancotipocuentabancoglobal = new  BancoTipoCuentaBancoGlobal();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=bancotipocuentabancoglobalDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		bancotipocuentabancoglobals = new  ArrayList<BancoTipoCuentaBancoGlobal>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoTipoCuentaBancoGlobal.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			BancoTipoCuentaBancoGlobalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bancotipocuentabancoglobals=bancotipocuentabancoglobalDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBancoTipoCuentaBancoGlobal(bancotipocuentabancoglobals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BancoTipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesBancoTipoCuentaBancoGlobal(this.bancotipocuentabancoglobals);
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
		bancotipocuentabancoglobals = new  ArrayList<BancoTipoCuentaBancoGlobal>();
		  		  
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
		bancotipocuentabancoglobals = new  ArrayList<BancoTipoCuentaBancoGlobal>();
		  		  
        try {			
			BancoTipoCuentaBancoGlobalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bancotipocuentabancoglobals=bancotipocuentabancoglobalDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarBancoTipoCuentaBancoGlobal(bancotipocuentabancoglobals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BancoTipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesBancoTipoCuentaBancoGlobal(this.bancotipocuentabancoglobals);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		bancotipocuentabancoglobals = new  ArrayList<BancoTipoCuentaBancoGlobal>();
		  		  
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
		bancotipocuentabancoglobals = new  ArrayList<BancoTipoCuentaBancoGlobal>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoTipoCuentaBancoGlobal.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			BancoTipoCuentaBancoGlobalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bancotipocuentabancoglobals=bancotipocuentabancoglobalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBancoTipoCuentaBancoGlobal(bancotipocuentabancoglobals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BancoTipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesBancoTipoCuentaBancoGlobal(this.bancotipocuentabancoglobals);
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
		bancotipocuentabancoglobals = new  ArrayList<BancoTipoCuentaBancoGlobal>();
		  		  
        try {
			BancoTipoCuentaBancoGlobalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bancotipocuentabancoglobals=bancotipocuentabancoglobalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBancoTipoCuentaBancoGlobal(bancotipocuentabancoglobals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BancoTipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesBancoTipoCuentaBancoGlobal(this.bancotipocuentabancoglobals);
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
		bancotipocuentabancoglobals = new  ArrayList<BancoTipoCuentaBancoGlobal>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoTipoCuentaBancoGlobal.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BancoTipoCuentaBancoGlobalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bancotipocuentabancoglobals=bancotipocuentabancoglobalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarBancoTipoCuentaBancoGlobal(bancotipocuentabancoglobals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BancoTipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesBancoTipoCuentaBancoGlobal(this.bancotipocuentabancoglobals);
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
		bancotipocuentabancoglobals = new  ArrayList<BancoTipoCuentaBancoGlobal>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BancoTipoCuentaBancoGlobalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bancotipocuentabancoglobals=bancotipocuentabancoglobalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarBancoTipoCuentaBancoGlobal(bancotipocuentabancoglobals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BancoTipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesBancoTipoCuentaBancoGlobal(this.bancotipocuentabancoglobals);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		bancotipocuentabancoglobal = new  BancoTipoCuentaBancoGlobal();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoTipoCuentaBancoGlobal.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BancoTipoCuentaBancoGlobalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bancotipocuentabancoglobal=bancotipocuentabancoglobalDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarBancoTipoCuentaBancoGlobal(bancotipocuentabancoglobal);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BancoTipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesBancoTipoCuentaBancoGlobal(this.bancotipocuentabancoglobal);
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
		bancotipocuentabancoglobal = new  BancoTipoCuentaBancoGlobal();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BancoTipoCuentaBancoGlobalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bancotipocuentabancoglobal=bancotipocuentabancoglobalDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarBancoTipoCuentaBancoGlobal(bancotipocuentabancoglobal);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BancoTipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesBancoTipoCuentaBancoGlobal(this.bancotipocuentabancoglobal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		bancotipocuentabancoglobals = new  ArrayList<BancoTipoCuentaBancoGlobal>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoTipoCuentaBancoGlobal.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			BancoTipoCuentaBancoGlobalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bancotipocuentabancoglobals=bancotipocuentabancoglobalDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBancoTipoCuentaBancoGlobal(bancotipocuentabancoglobals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BancoTipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesBancoTipoCuentaBancoGlobal(this.bancotipocuentabancoglobals);
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
		bancotipocuentabancoglobals = new  ArrayList<BancoTipoCuentaBancoGlobal>();
		  		  
        try {
			BancoTipoCuentaBancoGlobalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bancotipocuentabancoglobals=bancotipocuentabancoglobalDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarBancoTipoCuentaBancoGlobal(bancotipocuentabancoglobals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BancoTipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesBancoTipoCuentaBancoGlobal(this.bancotipocuentabancoglobals);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosBancoTipoCuentaBancoGlobalsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		bancotipocuentabancoglobals = new  ArrayList<BancoTipoCuentaBancoGlobal>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoTipoCuentaBancoGlobal.class.getSimpleName()+"-getTodosBancoTipoCuentaBancoGlobalsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BancoTipoCuentaBancoGlobalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bancotipocuentabancoglobals=bancotipocuentabancoglobalDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarBancoTipoCuentaBancoGlobal(bancotipocuentabancoglobals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BancoTipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesBancoTipoCuentaBancoGlobal(this.bancotipocuentabancoglobals);
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
	
	public  void  getTodosBancoTipoCuentaBancoGlobals(String sFinalQuery,Pagination pagination)throws Exception {
		bancotipocuentabancoglobals = new  ArrayList<BancoTipoCuentaBancoGlobal>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			BancoTipoCuentaBancoGlobalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			bancotipocuentabancoglobals=bancotipocuentabancoglobalDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarBancoTipoCuentaBancoGlobal(bancotipocuentabancoglobals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				BancoTipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesBancoTipoCuentaBancoGlobal(this.bancotipocuentabancoglobals);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarBancoTipoCuentaBancoGlobal(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal) throws Exception {
		Boolean estaValidado=false;
		
		if(bancotipocuentabancoglobal.getIsNew() || bancotipocuentabancoglobal.getIsChanged()) { 
			this.invalidValues = bancotipocuentabancoglobalValidator.getInvalidValues(bancotipocuentabancoglobal);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(bancotipocuentabancoglobal);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarBancoTipoCuentaBancoGlobal(List<BancoTipoCuentaBancoGlobal> BancoTipoCuentaBancoGlobals) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobalLocal:bancotipocuentabancoglobals) {				
			estaValidadoObjeto=this.validarGuardarBancoTipoCuentaBancoGlobal(bancotipocuentabancoglobalLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarBancoTipoCuentaBancoGlobal(List<BancoTipoCuentaBancoGlobal> BancoTipoCuentaBancoGlobals) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarBancoTipoCuentaBancoGlobal(bancotipocuentabancoglobals)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarBancoTipoCuentaBancoGlobal(BancoTipoCuentaBancoGlobal BancoTipoCuentaBancoGlobal) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarBancoTipoCuentaBancoGlobal(bancotipocuentabancoglobal)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+bancotipocuentabancoglobal.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=BancoTipoCuentaBancoGlobalConstantesFunciones.getBancoTipoCuentaBancoGlobalLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"bancotipocuentabancoglobal","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(BancoTipoCuentaBancoGlobalConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(BancoTipoCuentaBancoGlobalConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveBancoTipoCuentaBancoGlobalWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoTipoCuentaBancoGlobal.class.getSimpleName()+"-saveBancoTipoCuentaBancoGlobalWithConnection");connexion.begin();			
			
			BancoTipoCuentaBancoGlobalLogicAdditional.checkBancoTipoCuentaBancoGlobalToSave(this.bancotipocuentabancoglobal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			BancoTipoCuentaBancoGlobalLogicAdditional.updateBancoTipoCuentaBancoGlobalToSave(this.bancotipocuentabancoglobal,this.arrDatoGeneral);
			
			BancoTipoCuentaBancoGlobalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.bancotipocuentabancoglobal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowBancoTipoCuentaBancoGlobal();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarBancoTipoCuentaBancoGlobal(this.bancotipocuentabancoglobal)) {
				BancoTipoCuentaBancoGlobalDataAccess.save(this.bancotipocuentabancoglobal, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.bancotipocuentabancoglobal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			BancoTipoCuentaBancoGlobalLogicAdditional.checkBancoTipoCuentaBancoGlobalToSaveAfter(this.bancotipocuentabancoglobal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowBancoTipoCuentaBancoGlobal();
			
			connexion.commit();			
			
			if(this.bancotipocuentabancoglobal.getIsDeleted()) {
				this.bancotipocuentabancoglobal=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveBancoTipoCuentaBancoGlobal()throws Exception {	
		try {	
			
			BancoTipoCuentaBancoGlobalLogicAdditional.checkBancoTipoCuentaBancoGlobalToSave(this.bancotipocuentabancoglobal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			BancoTipoCuentaBancoGlobalLogicAdditional.updateBancoTipoCuentaBancoGlobalToSave(this.bancotipocuentabancoglobal,this.arrDatoGeneral);
			
			BancoTipoCuentaBancoGlobalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.bancotipocuentabancoglobal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarBancoTipoCuentaBancoGlobal(this.bancotipocuentabancoglobal)) {			
				BancoTipoCuentaBancoGlobalDataAccess.save(this.bancotipocuentabancoglobal, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.bancotipocuentabancoglobal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			BancoTipoCuentaBancoGlobalLogicAdditional.checkBancoTipoCuentaBancoGlobalToSaveAfter(this.bancotipocuentabancoglobal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.bancotipocuentabancoglobal.getIsDeleted()) {
				this.bancotipocuentabancoglobal=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveBancoTipoCuentaBancoGlobalsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoTipoCuentaBancoGlobal.class.getSimpleName()+"-saveBancoTipoCuentaBancoGlobalsWithConnection");connexion.begin();			
			
			BancoTipoCuentaBancoGlobalLogicAdditional.checkBancoTipoCuentaBancoGlobalToSaves(bancotipocuentabancoglobals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowBancoTipoCuentaBancoGlobals();
			
			Boolean validadoTodosBancoTipoCuentaBancoGlobal=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobalLocal:bancotipocuentabancoglobals) {		
				if(bancotipocuentabancoglobalLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				BancoTipoCuentaBancoGlobalLogicAdditional.updateBancoTipoCuentaBancoGlobalToSave(bancotipocuentabancoglobalLocal,this.arrDatoGeneral);
	        	
				BancoTipoCuentaBancoGlobalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),bancotipocuentabancoglobalLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarBancoTipoCuentaBancoGlobal(bancotipocuentabancoglobalLocal)) {
					BancoTipoCuentaBancoGlobalDataAccess.save(bancotipocuentabancoglobalLocal, connexion);				
				} else {
					validadoTodosBancoTipoCuentaBancoGlobal=false;
				}
			}
			
			if(!validadoTodosBancoTipoCuentaBancoGlobal) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			BancoTipoCuentaBancoGlobalLogicAdditional.checkBancoTipoCuentaBancoGlobalToSavesAfter(bancotipocuentabancoglobals,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowBancoTipoCuentaBancoGlobals();
			
			connexion.commit();		
			
			this.quitarBancoTipoCuentaBancoGlobalsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveBancoTipoCuentaBancoGlobals()throws Exception {				
		 try {	
			BancoTipoCuentaBancoGlobalLogicAdditional.checkBancoTipoCuentaBancoGlobalToSaves(bancotipocuentabancoglobals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosBancoTipoCuentaBancoGlobal=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobalLocal:bancotipocuentabancoglobals) {				
				if(bancotipocuentabancoglobalLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				BancoTipoCuentaBancoGlobalLogicAdditional.updateBancoTipoCuentaBancoGlobalToSave(bancotipocuentabancoglobalLocal,this.arrDatoGeneral);
	        	
				BancoTipoCuentaBancoGlobalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),bancotipocuentabancoglobalLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarBancoTipoCuentaBancoGlobal(bancotipocuentabancoglobalLocal)) {				
					BancoTipoCuentaBancoGlobalDataAccess.save(bancotipocuentabancoglobalLocal, connexion);				
				} else {
					validadoTodosBancoTipoCuentaBancoGlobal=false;
				}
			}
			
			if(!validadoTodosBancoTipoCuentaBancoGlobal) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			BancoTipoCuentaBancoGlobalLogicAdditional.checkBancoTipoCuentaBancoGlobalToSavesAfter(bancotipocuentabancoglobals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarBancoTipoCuentaBancoGlobalsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public BancoTipoCuentaBancoGlobalParameterReturnGeneral procesarAccionBancoTipoCuentaBancoGlobals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<BancoTipoCuentaBancoGlobal> bancotipocuentabancoglobals,BancoTipoCuentaBancoGlobalParameterReturnGeneral bancotipocuentabancoglobalParameterGeneral)throws Exception {
		 try {	
			BancoTipoCuentaBancoGlobalParameterReturnGeneral bancotipocuentabancoglobalReturnGeneral=new BancoTipoCuentaBancoGlobalParameterReturnGeneral();
	
			BancoTipoCuentaBancoGlobalLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,bancotipocuentabancoglobals,bancotipocuentabancoglobalParameterGeneral,bancotipocuentabancoglobalReturnGeneral);
			
			return bancotipocuentabancoglobalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public BancoTipoCuentaBancoGlobalParameterReturnGeneral procesarAccionBancoTipoCuentaBancoGlobalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<BancoTipoCuentaBancoGlobal> bancotipocuentabancoglobals,BancoTipoCuentaBancoGlobalParameterReturnGeneral bancotipocuentabancoglobalParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoTipoCuentaBancoGlobal.class.getSimpleName()+"-procesarAccionBancoTipoCuentaBancoGlobalsWithConnection");connexion.begin();			
			
			BancoTipoCuentaBancoGlobalParameterReturnGeneral bancotipocuentabancoglobalReturnGeneral=new BancoTipoCuentaBancoGlobalParameterReturnGeneral();
	
			BancoTipoCuentaBancoGlobalLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,bancotipocuentabancoglobals,bancotipocuentabancoglobalParameterGeneral,bancotipocuentabancoglobalReturnGeneral);
			
			this.connexion.commit();
			
			return bancotipocuentabancoglobalReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public BancoTipoCuentaBancoGlobalParameterReturnGeneral procesarEventosBancoTipoCuentaBancoGlobals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<BancoTipoCuentaBancoGlobal> bancotipocuentabancoglobals,BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal,BancoTipoCuentaBancoGlobalParameterReturnGeneral bancotipocuentabancoglobalParameterGeneral,Boolean isEsNuevoBancoTipoCuentaBancoGlobal,ArrayList<Classe> clases)throws Exception {
		 try {	
			BancoTipoCuentaBancoGlobalParameterReturnGeneral bancotipocuentabancoglobalReturnGeneral=new BancoTipoCuentaBancoGlobalParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				bancotipocuentabancoglobalReturnGeneral.setConRecargarPropiedades(true);
			}
			
			BancoTipoCuentaBancoGlobalLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,bancotipocuentabancoglobals,bancotipocuentabancoglobal,bancotipocuentabancoglobalParameterGeneral,bancotipocuentabancoglobalReturnGeneral,isEsNuevoBancoTipoCuentaBancoGlobal,clases);
			
			return bancotipocuentabancoglobalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public BancoTipoCuentaBancoGlobalParameterReturnGeneral procesarEventosBancoTipoCuentaBancoGlobalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<BancoTipoCuentaBancoGlobal> bancotipocuentabancoglobals,BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal,BancoTipoCuentaBancoGlobalParameterReturnGeneral bancotipocuentabancoglobalParameterGeneral,Boolean isEsNuevoBancoTipoCuentaBancoGlobal,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoTipoCuentaBancoGlobal.class.getSimpleName()+"-procesarEventosBancoTipoCuentaBancoGlobalsWithConnection");connexion.begin();			
			
			BancoTipoCuentaBancoGlobalParameterReturnGeneral bancotipocuentabancoglobalReturnGeneral=new BancoTipoCuentaBancoGlobalParameterReturnGeneral();
	
			bancotipocuentabancoglobalReturnGeneral.setBancoTipoCuentaBancoGlobal(bancotipocuentabancoglobal);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				bancotipocuentabancoglobalReturnGeneral.setConRecargarPropiedades(true);
			}
			
			BancoTipoCuentaBancoGlobalLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,bancotipocuentabancoglobals,bancotipocuentabancoglobal,bancotipocuentabancoglobalParameterGeneral,bancotipocuentabancoglobalReturnGeneral,isEsNuevoBancoTipoCuentaBancoGlobal,clases);
			
			this.connexion.commit();
			
			return bancotipocuentabancoglobalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public BancoTipoCuentaBancoGlobalParameterReturnGeneral procesarImportacionBancoTipoCuentaBancoGlobalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,BancoTipoCuentaBancoGlobalParameterReturnGeneral bancotipocuentabancoglobalParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoTipoCuentaBancoGlobal.class.getSimpleName()+"-procesarImportacionBancoTipoCuentaBancoGlobalsWithConnection");connexion.begin();			
			
			BancoTipoCuentaBancoGlobalParameterReturnGeneral bancotipocuentabancoglobalReturnGeneral=new BancoTipoCuentaBancoGlobalParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.bancotipocuentabancoglobals=new ArrayList<BancoTipoCuentaBancoGlobal>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.bancotipocuentabancoglobal=new BancoTipoCuentaBancoGlobal();
				
				
				if(conColumnasBase) {this.bancotipocuentabancoglobal.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.bancotipocuentabancoglobal.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				
				this.bancotipocuentabancoglobals.add(this.bancotipocuentabancoglobal);
			}
			
			this.saveBancoTipoCuentaBancoGlobals();
			
			this.connexion.commit();
			
			bancotipocuentabancoglobalReturnGeneral.setConRetornoEstaProcesado(true);
			bancotipocuentabancoglobalReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return bancotipocuentabancoglobalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarBancoTipoCuentaBancoGlobalsEliminados() throws Exception {				
		
		List<BancoTipoCuentaBancoGlobal> bancotipocuentabancoglobalsAux= new ArrayList<BancoTipoCuentaBancoGlobal>();
		
		for(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal:bancotipocuentabancoglobals) {
			if(!bancotipocuentabancoglobal.getIsDeleted()) {
				bancotipocuentabancoglobalsAux.add(bancotipocuentabancoglobal);
			}
		}
		
		bancotipocuentabancoglobals=bancotipocuentabancoglobalsAux;
	}
	
	public void quitarBancoTipoCuentaBancoGlobalsNulos() throws Exception {				
		
		List<BancoTipoCuentaBancoGlobal> bancotipocuentabancoglobalsAux= new ArrayList<BancoTipoCuentaBancoGlobal>();
		
		for(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal : this.bancotipocuentabancoglobals) {
			if(bancotipocuentabancoglobal==null) {
				bancotipocuentabancoglobalsAux.add(bancotipocuentabancoglobal);
			}
		}
		
		//this.bancotipocuentabancoglobals=bancotipocuentabancoglobalsAux;
		
		this.bancotipocuentabancoglobals.removeAll(bancotipocuentabancoglobalsAux);
	}
	
	public void getSetVersionRowBancoTipoCuentaBancoGlobalWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(bancotipocuentabancoglobal.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((bancotipocuentabancoglobal.getIsDeleted() || (bancotipocuentabancoglobal.getIsChanged()&&!bancotipocuentabancoglobal.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=bancotipocuentabancoglobalDataAccess.getSetVersionRowBancoTipoCuentaBancoGlobal(connexion,bancotipocuentabancoglobal.getId());
				
				if(!bancotipocuentabancoglobal.getVersionRow().equals(timestamp)) {	
					bancotipocuentabancoglobal.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				bancotipocuentabancoglobal.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowBancoTipoCuentaBancoGlobal()throws Exception {	
		
		if(bancotipocuentabancoglobal.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((bancotipocuentabancoglobal.getIsDeleted() || (bancotipocuentabancoglobal.getIsChanged()&&!bancotipocuentabancoglobal.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=bancotipocuentabancoglobalDataAccess.getSetVersionRowBancoTipoCuentaBancoGlobal(connexion,bancotipocuentabancoglobal.getId());
			
			try {							
				if(!bancotipocuentabancoglobal.getVersionRow().equals(timestamp)) {	
					bancotipocuentabancoglobal.setVersionRow(timestamp);
				}
				
				bancotipocuentabancoglobal.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowBancoTipoCuentaBancoGlobalsWithConnection()throws Exception {	
		if(bancotipocuentabancoglobals!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobalAux:bancotipocuentabancoglobals) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(bancotipocuentabancoglobalAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(bancotipocuentabancoglobalAux.getIsDeleted() || (bancotipocuentabancoglobalAux.getIsChanged()&&!bancotipocuentabancoglobalAux.getIsNew())) {
						
						timestamp=bancotipocuentabancoglobalDataAccess.getSetVersionRowBancoTipoCuentaBancoGlobal(connexion,bancotipocuentabancoglobalAux.getId());
						
						if(!bancotipocuentabancoglobal.getVersionRow().equals(timestamp)) {	
							bancotipocuentabancoglobalAux.setVersionRow(timestamp);
						}
								
						bancotipocuentabancoglobalAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowBancoTipoCuentaBancoGlobals()throws Exception {	
		if(bancotipocuentabancoglobals!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobalAux:bancotipocuentabancoglobals) {
					if(bancotipocuentabancoglobalAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(bancotipocuentabancoglobalAux.getIsDeleted() || (bancotipocuentabancoglobalAux.getIsChanged()&&!bancotipocuentabancoglobalAux.getIsNew())) {
						
						timestamp=bancotipocuentabancoglobalDataAccess.getSetVersionRowBancoTipoCuentaBancoGlobal(connexion,bancotipocuentabancoglobalAux.getId());
						
						if(!bancotipocuentabancoglobalAux.getVersionRow().equals(timestamp)) {	
							bancotipocuentabancoglobalAux.setVersionRow(timestamp);
						}
						
													
						bancotipocuentabancoglobalAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public BancoTipoCuentaBancoGlobalParameterReturnGeneral cargarCombosLoteForeignKeyBancoTipoCuentaBancoGlobalWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalBanco,String finalQueryGlobalTipoCuentaBancoGlobal) throws Exception {
		BancoTipoCuentaBancoGlobalParameterReturnGeneral  bancotipocuentabancoglobalReturnGeneral =new BancoTipoCuentaBancoGlobalParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoTipoCuentaBancoGlobal.class.getSimpleName()+"-cargarCombosLoteForeignKeyBancoTipoCuentaBancoGlobalWithConnection");connexion.begin();
			
			bancotipocuentabancoglobalReturnGeneral =new BancoTipoCuentaBancoGlobalParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			bancotipocuentabancoglobalReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Banco> bancosForeignKey=new ArrayList<Banco>();
			BancoLogic bancoLogic=new BancoLogic();
			bancoLogic.setConnexion(this.connexion);
			bancoLogic.getBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBanco.equals("NONE")) {
				bancoLogic.getTodosBancos(finalQueryGlobalBanco,new Pagination());
				bancosForeignKey=bancoLogic.getBancos();
			}

			bancotipocuentabancoglobalReturnGeneral.setbancosForeignKey(bancosForeignKey);


			List<TipoCuentaBancoGlobal> tipocuentabancoglobalsForeignKey=new ArrayList<TipoCuentaBancoGlobal>();
			TipoCuentaBancoGlobalLogic tipocuentabancoglobalLogic=new TipoCuentaBancoGlobalLogic();
			tipocuentabancoglobalLogic.setConnexion(this.connexion);
			tipocuentabancoglobalLogic.getTipoCuentaBancoGlobalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCuentaBancoGlobal.equals("NONE")) {
				tipocuentabancoglobalLogic.getTodosTipoCuentaBancoGlobals(finalQueryGlobalTipoCuentaBancoGlobal,new Pagination());
				tipocuentabancoglobalsForeignKey=tipocuentabancoglobalLogic.getTipoCuentaBancoGlobals();
			}

			bancotipocuentabancoglobalReturnGeneral.settipocuentabancoglobalsForeignKey(tipocuentabancoglobalsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return bancotipocuentabancoglobalReturnGeneral;
	}
	
	public BancoTipoCuentaBancoGlobalParameterReturnGeneral cargarCombosLoteForeignKeyBancoTipoCuentaBancoGlobal(String finalQueryGlobalEmpresa,String finalQueryGlobalBanco,String finalQueryGlobalTipoCuentaBancoGlobal) throws Exception {
		BancoTipoCuentaBancoGlobalParameterReturnGeneral  bancotipocuentabancoglobalReturnGeneral =new BancoTipoCuentaBancoGlobalParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			bancotipocuentabancoglobalReturnGeneral =new BancoTipoCuentaBancoGlobalParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			bancotipocuentabancoglobalReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Banco> bancosForeignKey=new ArrayList<Banco>();
			BancoLogic bancoLogic=new BancoLogic();
			bancoLogic.setConnexion(this.connexion);
			bancoLogic.getBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBanco.equals("NONE")) {
				bancoLogic.getTodosBancos(finalQueryGlobalBanco,new Pagination());
				bancosForeignKey=bancoLogic.getBancos();
			}

			bancotipocuentabancoglobalReturnGeneral.setbancosForeignKey(bancosForeignKey);


			List<TipoCuentaBancoGlobal> tipocuentabancoglobalsForeignKey=new ArrayList<TipoCuentaBancoGlobal>();
			TipoCuentaBancoGlobalLogic tipocuentabancoglobalLogic=new TipoCuentaBancoGlobalLogic();
			tipocuentabancoglobalLogic.setConnexion(this.connexion);
			tipocuentabancoglobalLogic.getTipoCuentaBancoGlobalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCuentaBancoGlobal.equals("NONE")) {
				tipocuentabancoglobalLogic.getTodosTipoCuentaBancoGlobals(finalQueryGlobalTipoCuentaBancoGlobal,new Pagination());
				tipocuentabancoglobalsForeignKey=tipocuentabancoglobalLogic.getTipoCuentaBancoGlobals();
			}

			bancotipocuentabancoglobalReturnGeneral.settipocuentabancoglobalsForeignKey(tipocuentabancoglobalsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return bancotipocuentabancoglobalReturnGeneral;
	}
	
	
	public void deepLoad(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			BancoTipoCuentaBancoGlobalLogicAdditional.updateBancoTipoCuentaBancoGlobalToGet(bancotipocuentabancoglobal,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		bancotipocuentabancoglobal.setEmpresa(bancotipocuentabancoglobalDataAccess.getEmpresa(connexion,bancotipocuentabancoglobal));
		bancotipocuentabancoglobal.setBanco(bancotipocuentabancoglobalDataAccess.getBanco(connexion,bancotipocuentabancoglobal));
		bancotipocuentabancoglobal.setTipoCuentaBancoGlobal(bancotipocuentabancoglobalDataAccess.getTipoCuentaBancoGlobal(connexion,bancotipocuentabancoglobal));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				bancotipocuentabancoglobal.setEmpresa(bancotipocuentabancoglobalDataAccess.getEmpresa(connexion,bancotipocuentabancoglobal));
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				bancotipocuentabancoglobal.setBanco(bancotipocuentabancoglobalDataAccess.getBanco(connexion,bancotipocuentabancoglobal));
				continue;
			}

			if(clas.clas.equals(TipoCuentaBancoGlobal.class)) {
				bancotipocuentabancoglobal.setTipoCuentaBancoGlobal(bancotipocuentabancoglobalDataAccess.getTipoCuentaBancoGlobal(connexion,bancotipocuentabancoglobal));
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
			bancotipocuentabancoglobal.setEmpresa(bancotipocuentabancoglobalDataAccess.getEmpresa(connexion,bancotipocuentabancoglobal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Banco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bancotipocuentabancoglobal.setBanco(bancotipocuentabancoglobalDataAccess.getBanco(connexion,bancotipocuentabancoglobal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCuentaBancoGlobal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bancotipocuentabancoglobal.setTipoCuentaBancoGlobal(bancotipocuentabancoglobalDataAccess.getTipoCuentaBancoGlobal(connexion,bancotipocuentabancoglobal));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		bancotipocuentabancoglobal.setEmpresa(bancotipocuentabancoglobalDataAccess.getEmpresa(connexion,bancotipocuentabancoglobal));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(bancotipocuentabancoglobal.getEmpresa(),isDeep,deepLoadType,clases);
				
		bancotipocuentabancoglobal.setBanco(bancotipocuentabancoglobalDataAccess.getBanco(connexion,bancotipocuentabancoglobal));
		BancoLogic bancoLogic= new BancoLogic(connexion);
		bancoLogic.deepLoad(bancotipocuentabancoglobal.getBanco(),isDeep,deepLoadType,clases);
				
		bancotipocuentabancoglobal.setTipoCuentaBancoGlobal(bancotipocuentabancoglobalDataAccess.getTipoCuentaBancoGlobal(connexion,bancotipocuentabancoglobal));
		TipoCuentaBancoGlobalLogic tipocuentabancoglobalLogic= new TipoCuentaBancoGlobalLogic(connexion);
		tipocuentabancoglobalLogic.deepLoad(bancotipocuentabancoglobal.getTipoCuentaBancoGlobal(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				bancotipocuentabancoglobal.setEmpresa(bancotipocuentabancoglobalDataAccess.getEmpresa(connexion,bancotipocuentabancoglobal));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(bancotipocuentabancoglobal.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				bancotipocuentabancoglobal.setBanco(bancotipocuentabancoglobalDataAccess.getBanco(connexion,bancotipocuentabancoglobal));
				BancoLogic bancoLogic= new BancoLogic(connexion);
				bancoLogic.deepLoad(bancotipocuentabancoglobal.getBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCuentaBancoGlobal.class)) {
				bancotipocuentabancoglobal.setTipoCuentaBancoGlobal(bancotipocuentabancoglobalDataAccess.getTipoCuentaBancoGlobal(connexion,bancotipocuentabancoglobal));
				TipoCuentaBancoGlobalLogic tipocuentabancoglobalLogic= new TipoCuentaBancoGlobalLogic(connexion);
				tipocuentabancoglobalLogic.deepLoad(bancotipocuentabancoglobal.getTipoCuentaBancoGlobal(),isDeep,deepLoadType,clases);				
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
			bancotipocuentabancoglobal.setEmpresa(bancotipocuentabancoglobalDataAccess.getEmpresa(connexion,bancotipocuentabancoglobal));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(bancotipocuentabancoglobal.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Banco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bancotipocuentabancoglobal.setBanco(bancotipocuentabancoglobalDataAccess.getBanco(connexion,bancotipocuentabancoglobal));
			BancoLogic bancoLogic= new BancoLogic(connexion);
			bancoLogic.deepLoad(bancotipocuentabancoglobal.getBanco(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCuentaBancoGlobal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			bancotipocuentabancoglobal.setTipoCuentaBancoGlobal(bancotipocuentabancoglobalDataAccess.getTipoCuentaBancoGlobal(connexion,bancotipocuentabancoglobal));
			TipoCuentaBancoGlobalLogic tipocuentabancoglobalLogic= new TipoCuentaBancoGlobalLogic(connexion);
			tipocuentabancoglobalLogic.deepLoad(bancotipocuentabancoglobal.getTipoCuentaBancoGlobal(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			BancoTipoCuentaBancoGlobalLogicAdditional.updateBancoTipoCuentaBancoGlobalToSave(bancotipocuentabancoglobal,this.arrDatoGeneral);
			
BancoTipoCuentaBancoGlobalDataAccess.save(bancotipocuentabancoglobal, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(bancotipocuentabancoglobal.getEmpresa(),connexion);

		BancoDataAccess.save(bancotipocuentabancoglobal.getBanco(),connexion);

		TipoCuentaBancoGlobalDataAccess.save(bancotipocuentabancoglobal.getTipoCuentaBancoGlobal(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(bancotipocuentabancoglobal.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				BancoDataAccess.save(bancotipocuentabancoglobal.getBanco(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoCuentaBancoGlobal.class)) {
				TipoCuentaBancoGlobalDataAccess.save(bancotipocuentabancoglobal.getTipoCuentaBancoGlobal(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(bancotipocuentabancoglobal.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(bancotipocuentabancoglobal.getEmpresa(),isDeep,deepLoadType,clases);
				

		BancoDataAccess.save(bancotipocuentabancoglobal.getBanco(),connexion);
		BancoLogic bancoLogic= new BancoLogic(connexion);
		bancoLogic.deepLoad(bancotipocuentabancoglobal.getBanco(),isDeep,deepLoadType,clases);
				

		TipoCuentaBancoGlobalDataAccess.save(bancotipocuentabancoglobal.getTipoCuentaBancoGlobal(),connexion);
		TipoCuentaBancoGlobalLogic tipocuentabancoglobalLogic= new TipoCuentaBancoGlobalLogic(connexion);
		tipocuentabancoglobalLogic.deepLoad(bancotipocuentabancoglobal.getTipoCuentaBancoGlobal(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(bancotipocuentabancoglobal.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(bancotipocuentabancoglobal.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				BancoDataAccess.save(bancotipocuentabancoglobal.getBanco(),connexion);
				BancoLogic bancoLogic= new BancoLogic(connexion);
				bancoLogic.deepSave(bancotipocuentabancoglobal.getBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCuentaBancoGlobal.class)) {
				TipoCuentaBancoGlobalDataAccess.save(bancotipocuentabancoglobal.getTipoCuentaBancoGlobal(),connexion);
				TipoCuentaBancoGlobalLogic tipocuentabancoglobalLogic= new TipoCuentaBancoGlobalLogic(connexion);
				tipocuentabancoglobalLogic.deepSave(bancotipocuentabancoglobal.getTipoCuentaBancoGlobal(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(BancoTipoCuentaBancoGlobal.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(bancotipocuentabancoglobal,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				BancoTipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesBancoTipoCuentaBancoGlobal(bancotipocuentabancoglobal);
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
			this.deepLoad(this.bancotipocuentabancoglobal,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				BancoTipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesBancoTipoCuentaBancoGlobal(this.bancotipocuentabancoglobal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(BancoTipoCuentaBancoGlobal.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(bancotipocuentabancoglobals!=null) {
				for(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal:bancotipocuentabancoglobals) {
					this.deepLoad(bancotipocuentabancoglobal,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					BancoTipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesBancoTipoCuentaBancoGlobal(bancotipocuentabancoglobals);
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
			if(bancotipocuentabancoglobals!=null) {
				for(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal:bancotipocuentabancoglobals) {
					this.deepLoad(bancotipocuentabancoglobal,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					BancoTipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesBancoTipoCuentaBancoGlobal(bancotipocuentabancoglobals);
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
			this.getNewConnexionToDeep(BancoTipoCuentaBancoGlobal.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(bancotipocuentabancoglobal,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(BancoTipoCuentaBancoGlobal.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(bancotipocuentabancoglobals!=null) {
				for(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal:bancotipocuentabancoglobals) {
					this.deepSave(bancotipocuentabancoglobal,isDeep,deepLoadType,clases);
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
			if(bancotipocuentabancoglobals!=null) {
				for(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal:bancotipocuentabancoglobals) {
					this.deepSave(bancotipocuentabancoglobal,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getBancoTipoCuentaBancoGlobalsFK_IdBancoWithConnection(String sFinalQuery,Pagination pagination,Long id_banco)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoTipoCuentaBancoGlobal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_banco,BancoTipoCuentaBancoGlobalConstantesFunciones.IDBANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBanco);

			BancoTipoCuentaBancoGlobalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancotipocuentabancoglobals=bancotipocuentabancoglobalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoTipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesBancoTipoCuentaBancoGlobal(this.bancotipocuentabancoglobals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBancoTipoCuentaBancoGlobalsFK_IdBanco(String sFinalQuery,Pagination pagination,Long id_banco)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_banco,BancoTipoCuentaBancoGlobalConstantesFunciones.IDBANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBanco);

			BancoTipoCuentaBancoGlobalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancotipocuentabancoglobals=bancotipocuentabancoglobalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoTipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesBancoTipoCuentaBancoGlobal(this.bancotipocuentabancoglobals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBancoTipoCuentaBancoGlobalsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoTipoCuentaBancoGlobal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,BancoTipoCuentaBancoGlobalConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			BancoTipoCuentaBancoGlobalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancotipocuentabancoglobals=bancotipocuentabancoglobalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoTipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesBancoTipoCuentaBancoGlobal(this.bancotipocuentabancoglobals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBancoTipoCuentaBancoGlobalsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,BancoTipoCuentaBancoGlobalConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			BancoTipoCuentaBancoGlobalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancotipocuentabancoglobals=bancotipocuentabancoglobalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoTipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesBancoTipoCuentaBancoGlobal(this.bancotipocuentabancoglobals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getBancoTipoCuentaBancoGlobalsFK_IdTipoCuentaBancoGlobalWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_cuenta_banco_global)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,BancoTipoCuentaBancoGlobal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCuentaBancoGlobal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCuentaBancoGlobal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cuenta_banco_global,BancoTipoCuentaBancoGlobalConstantesFunciones.IDTIPOCUENTABANCOGLOBAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCuentaBancoGlobal);

			BancoTipoCuentaBancoGlobalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCuentaBancoGlobal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancotipocuentabancoglobals=bancotipocuentabancoglobalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoTipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesBancoTipoCuentaBancoGlobal(this.bancotipocuentabancoglobals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getBancoTipoCuentaBancoGlobalsFK_IdTipoCuentaBancoGlobal(String sFinalQuery,Pagination pagination,Long id_tipo_cuenta_banco_global)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCuentaBancoGlobal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCuentaBancoGlobal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cuenta_banco_global,BancoTipoCuentaBancoGlobalConstantesFunciones.IDTIPOCUENTABANCOGLOBAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCuentaBancoGlobal);

			BancoTipoCuentaBancoGlobalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCuentaBancoGlobal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			bancotipocuentabancoglobals=bancotipocuentabancoglobalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				BancoTipoCuentaBancoGlobalConstantesFunciones.refrescarForeignKeysDescripcionesBancoTipoCuentaBancoGlobal(this.bancotipocuentabancoglobals);
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
			if(BancoTipoCuentaBancoGlobalConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,BancoTipoCuentaBancoGlobalDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(BancoTipoCuentaBancoGlobalConstantesFunciones.ISCONAUDITORIA) {
				if(bancotipocuentabancoglobal.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,BancoTipoCuentaBancoGlobalDataAccess.TABLENAME, bancotipocuentabancoglobal.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(BancoTipoCuentaBancoGlobalConstantesFunciones.ISCONAUDITORIADETALLE) {
						////BancoTipoCuentaBancoGlobalLogic.registrarAuditoriaDetallesBancoTipoCuentaBancoGlobal(connexion,bancotipocuentabancoglobal,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(bancotipocuentabancoglobal.getIsDeleted()) {
					/*if(!bancotipocuentabancoglobal.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,BancoTipoCuentaBancoGlobalDataAccess.TABLENAME, bancotipocuentabancoglobal.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////BancoTipoCuentaBancoGlobalLogic.registrarAuditoriaDetallesBancoTipoCuentaBancoGlobal(connexion,bancotipocuentabancoglobal,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,BancoTipoCuentaBancoGlobalDataAccess.TABLENAME, bancotipocuentabancoglobal.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(bancotipocuentabancoglobal.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,BancoTipoCuentaBancoGlobalDataAccess.TABLENAME, bancotipocuentabancoglobal.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(BancoTipoCuentaBancoGlobalConstantesFunciones.ISCONAUDITORIADETALLE) {
						////BancoTipoCuentaBancoGlobalLogic.registrarAuditoriaDetallesBancoTipoCuentaBancoGlobal(connexion,bancotipocuentabancoglobal,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesBancoTipoCuentaBancoGlobal(Connexion connexion,BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(bancotipocuentabancoglobal.getIsNew()||!bancotipocuentabancoglobal.getid_empresa().equals(bancotipocuentabancoglobal.getBancoTipoCuentaBancoGlobalOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bancotipocuentabancoglobal.getBancoTipoCuentaBancoGlobalOriginal().getid_empresa()!=null)
				{
					strValorActual=bancotipocuentabancoglobal.getBancoTipoCuentaBancoGlobalOriginal().getid_empresa().toString();
				}
				if(bancotipocuentabancoglobal.getid_empresa()!=null)
				{
					strValorNuevo=bancotipocuentabancoglobal.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BancoTipoCuentaBancoGlobalConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(bancotipocuentabancoglobal.getIsNew()||!bancotipocuentabancoglobal.getid_banco().equals(bancotipocuentabancoglobal.getBancoTipoCuentaBancoGlobalOriginal().getid_banco()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bancotipocuentabancoglobal.getBancoTipoCuentaBancoGlobalOriginal().getid_banco()!=null)
				{
					strValorActual=bancotipocuentabancoglobal.getBancoTipoCuentaBancoGlobalOriginal().getid_banco().toString();
				}
				if(bancotipocuentabancoglobal.getid_banco()!=null)
				{
					strValorNuevo=bancotipocuentabancoglobal.getid_banco().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BancoTipoCuentaBancoGlobalConstantesFunciones.IDBANCO,strValorActual,strValorNuevo);
			}	
			
			if(bancotipocuentabancoglobal.getIsNew()||!bancotipocuentabancoglobal.getid_tipo_cuenta_banco_global().equals(bancotipocuentabancoglobal.getBancoTipoCuentaBancoGlobalOriginal().getid_tipo_cuenta_banco_global()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(bancotipocuentabancoglobal.getBancoTipoCuentaBancoGlobalOriginal().getid_tipo_cuenta_banco_global()!=null)
				{
					strValorActual=bancotipocuentabancoglobal.getBancoTipoCuentaBancoGlobalOriginal().getid_tipo_cuenta_banco_global().toString();
				}
				if(bancotipocuentabancoglobal.getid_tipo_cuenta_banco_global()!=null)
				{
					strValorNuevo=bancotipocuentabancoglobal.getid_tipo_cuenta_banco_global().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),BancoTipoCuentaBancoGlobalConstantesFunciones.IDTIPOCUENTABANCOGLOBAL,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveBancoTipoCuentaBancoGlobalRelacionesWithConnection(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal) throws Exception {

		if(!bancotipocuentabancoglobal.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveBancoTipoCuentaBancoGlobalRelacionesBase(bancotipocuentabancoglobal,true);
		}
	}

	public void saveBancoTipoCuentaBancoGlobalRelaciones(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal)throws Exception {

		if(!bancotipocuentabancoglobal.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveBancoTipoCuentaBancoGlobalRelacionesBase(bancotipocuentabancoglobal,false);
		}
	}

	public void saveBancoTipoCuentaBancoGlobalRelacionesBase(BancoTipoCuentaBancoGlobal bancotipocuentabancoglobal,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("BancoTipoCuentaBancoGlobal-saveRelacionesWithConnection");}
	

			this.setBancoTipoCuentaBancoGlobal(bancotipocuentabancoglobal);

			if(BancoTipoCuentaBancoGlobalLogicAdditional.validarSaveRelaciones(bancotipocuentabancoglobal,this)) {

				BancoTipoCuentaBancoGlobalLogicAdditional.updateRelacionesToSave(bancotipocuentabancoglobal,this);

				if((bancotipocuentabancoglobal.getIsNew()||bancotipocuentabancoglobal.getIsChanged())&&!bancotipocuentabancoglobal.getIsDeleted()) {
					this.saveBancoTipoCuentaBancoGlobal();
					this.saveBancoTipoCuentaBancoGlobalRelacionesDetalles();

				} else if(bancotipocuentabancoglobal.getIsDeleted()) {
					this.saveBancoTipoCuentaBancoGlobalRelacionesDetalles();
					this.saveBancoTipoCuentaBancoGlobal();
				}

				BancoTipoCuentaBancoGlobalLogicAdditional.updateRelacionesToSaveAfter(bancotipocuentabancoglobal,this);

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
	
	
	private void saveBancoTipoCuentaBancoGlobalRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfBancoTipoCuentaBancoGlobal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=BancoTipoCuentaBancoGlobalConstantesFunciones.getClassesForeignKeysOfBancoTipoCuentaBancoGlobal(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfBancoTipoCuentaBancoGlobal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=BancoTipoCuentaBancoGlobalConstantesFunciones.getClassesRelationshipsOfBancoTipoCuentaBancoGlobal(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

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
import com.bydan.erp.tesoreria.util.CuentaBancoConstantesFunciones;
import com.bydan.erp.tesoreria.util.CuentaBancoParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.CuentaBancoParameterGeneral;
import com.bydan.erp.tesoreria.business.entity.CuentaBanco;
import com.bydan.erp.tesoreria.business.logic.CuentaBancoLogicAdditional;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;








@SuppressWarnings("unused")
public class CuentaBancoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(CuentaBancoLogic.class);
	
	protected CuentaBancoDataAccess cuentabancoDataAccess; 	
	protected CuentaBanco cuentabanco;
	protected List<CuentaBanco> cuentabancos;
	protected Object cuentabancoObject;	
	protected List<Object> cuentabancosObject;
	
	public static ClassValidator<CuentaBanco> cuentabancoValidator = new ClassValidator<CuentaBanco>(CuentaBanco.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected CuentaBancoLogicAdditional cuentabancoLogicAdditional=null;
	
	public CuentaBancoLogicAdditional getCuentaBancoLogicAdditional() {
		return this.cuentabancoLogicAdditional;
	}
	
	public void setCuentaBancoLogicAdditional(CuentaBancoLogicAdditional cuentabancoLogicAdditional) {
		try {
			this.cuentabancoLogicAdditional=cuentabancoLogicAdditional;
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
	
	
	
	
	public  CuentaBancoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.cuentabancoDataAccess = new CuentaBancoDataAccess();
			
			this.cuentabancos= new ArrayList<CuentaBanco>();
			this.cuentabanco= new CuentaBanco();
			
			this.cuentabancoObject=new Object();
			this.cuentabancosObject=new ArrayList<Object>();
				
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
			
			this.cuentabancoDataAccess.setConnexionType(this.connexionType);
			this.cuentabancoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CuentaBancoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.cuentabancoDataAccess = new CuentaBancoDataAccess();
			this.cuentabancos= new ArrayList<CuentaBanco>();
			this.cuentabanco= new CuentaBanco();
			this.cuentabancoObject=new Object();
			this.cuentabancosObject=new ArrayList<Object>();
			
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
			
			this.cuentabancoDataAccess.setConnexionType(this.connexionType);
			this.cuentabancoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CuentaBanco getCuentaBanco() throws Exception {	
		CuentaBancoLogicAdditional.checkCuentaBancoToGet(cuentabanco,this.datosCliente,this.arrDatoGeneral);
		CuentaBancoLogicAdditional.updateCuentaBancoToGet(cuentabanco,this.arrDatoGeneral);
		
		return cuentabanco;
	}
		
	public void setCuentaBanco(CuentaBanco newCuentaBanco) {
		this.cuentabanco = newCuentaBanco;
	}
	
	public CuentaBancoDataAccess getCuentaBancoDataAccess() {
		return cuentabancoDataAccess;
	}
	
	public void setCuentaBancoDataAccess(CuentaBancoDataAccess newcuentabancoDataAccess) {
		this.cuentabancoDataAccess = newcuentabancoDataAccess;
	}
	
	public List<CuentaBanco> getCuentaBancos() throws Exception {		
		this.quitarCuentaBancosNulos();
		
		CuentaBancoLogicAdditional.checkCuentaBancoToGets(cuentabancos,this.datosCliente,this.arrDatoGeneral);
		
		for (CuentaBanco cuentabancoLocal: cuentabancos ) {
			CuentaBancoLogicAdditional.updateCuentaBancoToGet(cuentabancoLocal,this.arrDatoGeneral);
		}
		
		return cuentabancos;
	}
	
	public void setCuentaBancos(List<CuentaBanco> newCuentaBancos) {
		this.cuentabancos = newCuentaBancos;
	}
	
	public Object getCuentaBancoObject() {	
		this.cuentabancoObject=this.cuentabancoDataAccess.getEntityObject();
		return this.cuentabancoObject;
	}
		
	public void setCuentaBancoObject(Object newCuentaBancoObject) {
		this.cuentabancoObject = newCuentaBancoObject;
	}
	
	public List<Object> getCuentaBancosObject() {		
		this.cuentabancosObject=this.cuentabancoDataAccess.getEntitiesObject();
		return this.cuentabancosObject;
	}
		
	public void setCuentaBancosObject(List<Object> newCuentaBancosObject) {
		this.cuentabancosObject = newCuentaBancosObject;
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
		
		if(this.cuentabancoDataAccess!=null) {
			this.cuentabancoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBanco.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			cuentabancoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			cuentabancoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		cuentabanco = new  CuentaBanco();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBanco.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cuentabanco=cuentabancoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuentabanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabanco);
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
		cuentabanco = new  CuentaBanco();
		  		  
        try {
			
			cuentabanco=cuentabancoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuentabanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabanco);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		cuentabanco = new  CuentaBanco();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBanco.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cuentabanco=cuentabancoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuentabanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabanco);
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
		cuentabanco = new  CuentaBanco();
		  		  
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
		cuentabanco = new  CuentaBanco();
		  		  
        try {
			
			cuentabanco=cuentabancoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuentabanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabanco);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		cuentabanco = new  CuentaBanco();
		  		  
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
		cuentabanco = new  CuentaBanco();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBanco.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =cuentabancoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cuentabanco = new  CuentaBanco();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=cuentabancoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cuentabanco = new  CuentaBanco();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBanco.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =cuentabancoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cuentabanco = new  CuentaBanco();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=cuentabancoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cuentabanco = new  CuentaBanco();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBanco.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =cuentabancoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cuentabanco = new  CuentaBanco();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=cuentabancoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cuentabancos = new  ArrayList<CuentaBanco>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBanco.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentabancos=cuentabancoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaBanco(cuentabancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
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
		cuentabancos = new  ArrayList<CuentaBanco>();
		  		  
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
		cuentabancos = new  ArrayList<CuentaBanco>();
		  		  
        try {			
			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentabancos=cuentabancoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarCuentaBanco(cuentabancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		cuentabancos = new  ArrayList<CuentaBanco>();
		  		  
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
		cuentabancos = new  ArrayList<CuentaBanco>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBanco.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentabancos=cuentabancoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaBanco(cuentabancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
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
		cuentabancos = new  ArrayList<CuentaBanco>();
		  		  
        try {
			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentabancos=cuentabancoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaBanco(cuentabancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
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
		cuentabancos = new  ArrayList<CuentaBanco>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBanco.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentabancos=cuentabancoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuentaBanco(cuentabancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
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
		cuentabancos = new  ArrayList<CuentaBanco>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentabancos=cuentabancoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuentaBanco(cuentabancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		cuentabanco = new  CuentaBanco();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBanco.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentabanco=cuentabancoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuentaBanco(cuentabanco);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabanco);
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
		cuentabanco = new  CuentaBanco();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentabanco=cuentabancoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuentaBanco(cuentabanco);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabanco);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cuentabancos = new  ArrayList<CuentaBanco>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBanco.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentabancos=cuentabancoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaBanco(cuentabancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
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
		cuentabancos = new  ArrayList<CuentaBanco>();
		  		  
        try {
			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentabancos=cuentabancoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaBanco(cuentabancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosCuentaBancosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		cuentabancos = new  ArrayList<CuentaBanco>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBanco.class.getSimpleName()+"-getTodosCuentaBancosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentabancos=cuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCuentaBanco(cuentabancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
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
	
	public  void  getTodosCuentaBancos(String sFinalQuery,Pagination pagination)throws Exception {
		cuentabancos = new  ArrayList<CuentaBanco>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentabancos=cuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCuentaBanco(cuentabancos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarCuentaBanco(CuentaBanco cuentabanco) throws Exception {
		Boolean estaValidado=false;
		
		if(cuentabanco.getIsNew() || cuentabanco.getIsChanged()) { 
			this.invalidValues = cuentabancoValidator.getInvalidValues(cuentabanco);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(cuentabanco);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarCuentaBanco(List<CuentaBanco> CuentaBancos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(CuentaBanco cuentabancoLocal:cuentabancos) {				
			estaValidadoObjeto=this.validarGuardarCuentaBanco(cuentabancoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarCuentaBanco(List<CuentaBanco> CuentaBancos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCuentaBanco(cuentabancos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarCuentaBanco(CuentaBanco CuentaBanco) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCuentaBanco(cuentabanco)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(CuentaBanco cuentabanco) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+cuentabanco.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=CuentaBancoConstantesFunciones.getCuentaBancoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"cuentabanco","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(CuentaBancoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(CuentaBancoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveCuentaBancoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBanco.class.getSimpleName()+"-saveCuentaBancoWithConnection");connexion.begin();			
			
			CuentaBancoLogicAdditional.checkCuentaBancoToSave(this.cuentabanco,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CuentaBancoLogicAdditional.updateCuentaBancoToSave(this.cuentabanco,this.arrDatoGeneral);
			
			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cuentabanco,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowCuentaBanco();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCuentaBanco(this.cuentabanco)) {
				CuentaBancoDataAccess.save(this.cuentabanco, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.cuentabanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CuentaBancoLogicAdditional.checkCuentaBancoToSaveAfter(this.cuentabanco,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCuentaBanco();
			
			connexion.commit();			
			
			if(this.cuentabanco.getIsDeleted()) {
				this.cuentabanco=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveCuentaBanco()throws Exception {	
		try {	
			
			CuentaBancoLogicAdditional.checkCuentaBancoToSave(this.cuentabanco,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CuentaBancoLogicAdditional.updateCuentaBancoToSave(this.cuentabanco,this.arrDatoGeneral);
			
			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cuentabanco,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCuentaBanco(this.cuentabanco)) {			
				CuentaBancoDataAccess.save(this.cuentabanco, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.cuentabanco,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CuentaBancoLogicAdditional.checkCuentaBancoToSaveAfter(this.cuentabanco,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.cuentabanco.getIsDeleted()) {
				this.cuentabanco=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveCuentaBancosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBanco.class.getSimpleName()+"-saveCuentaBancosWithConnection");connexion.begin();			
			
			CuentaBancoLogicAdditional.checkCuentaBancoToSaves(cuentabancos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowCuentaBancos();
			
			Boolean validadoTodosCuentaBanco=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CuentaBanco cuentabancoLocal:cuentabancos) {		
				if(cuentabancoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CuentaBancoLogicAdditional.updateCuentaBancoToSave(cuentabancoLocal,this.arrDatoGeneral);
	        	
				CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cuentabancoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCuentaBanco(cuentabancoLocal)) {
					CuentaBancoDataAccess.save(cuentabancoLocal, connexion);				
				} else {
					validadoTodosCuentaBanco=false;
				}
			}
			
			if(!validadoTodosCuentaBanco) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CuentaBancoLogicAdditional.checkCuentaBancoToSavesAfter(cuentabancos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCuentaBancos();
			
			connexion.commit();		
			
			this.quitarCuentaBancosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveCuentaBancos()throws Exception {				
		 try {	
			CuentaBancoLogicAdditional.checkCuentaBancoToSaves(cuentabancos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosCuentaBanco=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CuentaBanco cuentabancoLocal:cuentabancos) {				
				if(cuentabancoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CuentaBancoLogicAdditional.updateCuentaBancoToSave(cuentabancoLocal,this.arrDatoGeneral);
	        	
				CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cuentabancoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCuentaBanco(cuentabancoLocal)) {				
					CuentaBancoDataAccess.save(cuentabancoLocal, connexion);				
				} else {
					validadoTodosCuentaBanco=false;
				}
			}
			
			if(!validadoTodosCuentaBanco) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CuentaBancoLogicAdditional.checkCuentaBancoToSavesAfter(cuentabancos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarCuentaBancosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CuentaBancoParameterReturnGeneral procesarAccionCuentaBancos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CuentaBanco> cuentabancos,CuentaBancoParameterReturnGeneral cuentabancoParameterGeneral)throws Exception {
		 try {	
			CuentaBancoParameterReturnGeneral cuentabancoReturnGeneral=new CuentaBancoParameterReturnGeneral();
	
			CuentaBancoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cuentabancos,cuentabancoParameterGeneral,cuentabancoReturnGeneral);
			
			return cuentabancoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CuentaBancoParameterReturnGeneral procesarAccionCuentaBancosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CuentaBanco> cuentabancos,CuentaBancoParameterReturnGeneral cuentabancoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBanco.class.getSimpleName()+"-procesarAccionCuentaBancosWithConnection");connexion.begin();			
			
			CuentaBancoParameterReturnGeneral cuentabancoReturnGeneral=new CuentaBancoParameterReturnGeneral();
	
			CuentaBancoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cuentabancos,cuentabancoParameterGeneral,cuentabancoReturnGeneral);
			
			this.connexion.commit();
			
			return cuentabancoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CuentaBancoParameterReturnGeneral procesarEventosCuentaBancos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CuentaBanco> cuentabancos,CuentaBanco cuentabanco,CuentaBancoParameterReturnGeneral cuentabancoParameterGeneral,Boolean isEsNuevoCuentaBanco,ArrayList<Classe> clases)throws Exception {
		 try {	
			CuentaBancoParameterReturnGeneral cuentabancoReturnGeneral=new CuentaBancoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cuentabancoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CuentaBancoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cuentabancos,cuentabanco,cuentabancoParameterGeneral,cuentabancoReturnGeneral,isEsNuevoCuentaBanco,clases);
			
			return cuentabancoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public CuentaBancoParameterReturnGeneral procesarEventosCuentaBancosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CuentaBanco> cuentabancos,CuentaBanco cuentabanco,CuentaBancoParameterReturnGeneral cuentabancoParameterGeneral,Boolean isEsNuevoCuentaBanco,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBanco.class.getSimpleName()+"-procesarEventosCuentaBancosWithConnection");connexion.begin();			
			
			CuentaBancoParameterReturnGeneral cuentabancoReturnGeneral=new CuentaBancoParameterReturnGeneral();
	
			cuentabancoReturnGeneral.setCuentaBanco(cuentabanco);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cuentabancoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CuentaBancoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cuentabancos,cuentabanco,cuentabancoParameterGeneral,cuentabancoReturnGeneral,isEsNuevoCuentaBanco,clases);
			
			this.connexion.commit();
			
			return cuentabancoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CuentaBancoParameterReturnGeneral procesarImportacionCuentaBancosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,CuentaBancoParameterReturnGeneral cuentabancoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBanco.class.getSimpleName()+"-procesarImportacionCuentaBancosWithConnection");connexion.begin();			
			
			CuentaBancoParameterReturnGeneral cuentabancoReturnGeneral=new CuentaBancoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.cuentabancos=new ArrayList<CuentaBanco>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.cuentabanco=new CuentaBanco();
				
				
				if(conColumnasBase) {this.cuentabanco.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.cuentabanco.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.cuentabanco.setcodigo(arrColumnas[iColumn++]);
				this.cuentabanco.setnumero_cuenta(arrColumnas[iColumn++]);
				this.cuentabanco.setnumero_cheque(arrColumnas[iColumn++]);
				this.cuentabanco.setnumero_cheque_auxiliar(arrColumnas[iColumn++]);
				this.cuentabanco.setsaldo(Double.parseDouble(arrColumnas[iColumn++]));
				this.cuentabanco.setprocedencia(arrColumnas[iColumn++]);
				this.cuentabanco.setdestino(arrColumnas[iColumn++]);
				this.cuentabanco.setes_banco(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.cuentabancos.add(this.cuentabanco);
			}
			
			this.saveCuentaBancos();
			
			this.connexion.commit();
			
			cuentabancoReturnGeneral.setConRetornoEstaProcesado(true);
			cuentabancoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return cuentabancoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarCuentaBancosEliminados() throws Exception {				
		
		List<CuentaBanco> cuentabancosAux= new ArrayList<CuentaBanco>();
		
		for(CuentaBanco cuentabanco:cuentabancos) {
			if(!cuentabanco.getIsDeleted()) {
				cuentabancosAux.add(cuentabanco);
			}
		}
		
		cuentabancos=cuentabancosAux;
	}
	
	public void quitarCuentaBancosNulos() throws Exception {				
		
		List<CuentaBanco> cuentabancosAux= new ArrayList<CuentaBanco>();
		
		for(CuentaBanco cuentabanco : this.cuentabancos) {
			if(cuentabanco==null) {
				cuentabancosAux.add(cuentabanco);
			}
		}
		
		//this.cuentabancos=cuentabancosAux;
		
		this.cuentabancos.removeAll(cuentabancosAux);
	}
	
	public void getSetVersionRowCuentaBancoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(cuentabanco.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((cuentabanco.getIsDeleted() || (cuentabanco.getIsChanged()&&!cuentabanco.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=cuentabancoDataAccess.getSetVersionRowCuentaBanco(connexion,cuentabanco.getId());
				
				if(!cuentabanco.getVersionRow().equals(timestamp)) {	
					cuentabanco.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				cuentabanco.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowCuentaBanco()throws Exception {	
		
		if(cuentabanco.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((cuentabanco.getIsDeleted() || (cuentabanco.getIsChanged()&&!cuentabanco.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=cuentabancoDataAccess.getSetVersionRowCuentaBanco(connexion,cuentabanco.getId());
			
			try {							
				if(!cuentabanco.getVersionRow().equals(timestamp)) {	
					cuentabanco.setVersionRow(timestamp);
				}
				
				cuentabanco.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowCuentaBancosWithConnection()throws Exception {	
		if(cuentabancos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(CuentaBanco cuentabancoAux:cuentabancos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(cuentabancoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cuentabancoAux.getIsDeleted() || (cuentabancoAux.getIsChanged()&&!cuentabancoAux.getIsNew())) {
						
						timestamp=cuentabancoDataAccess.getSetVersionRowCuentaBanco(connexion,cuentabancoAux.getId());
						
						if(!cuentabanco.getVersionRow().equals(timestamp)) {	
							cuentabancoAux.setVersionRow(timestamp);
						}
								
						cuentabancoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowCuentaBancos()throws Exception {	
		if(cuentabancos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(CuentaBanco cuentabancoAux:cuentabancos) {
					if(cuentabancoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cuentabancoAux.getIsDeleted() || (cuentabancoAux.getIsChanged()&&!cuentabancoAux.getIsNew())) {
						
						timestamp=cuentabancoDataAccess.getSetVersionRowCuentaBanco(connexion,cuentabancoAux.getId());
						
						if(!cuentabancoAux.getVersionRow().equals(timestamp)) {	
							cuentabancoAux.setVersionRow(timestamp);
						}
						
													
						cuentabancoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public CuentaBancoParameterReturnGeneral cargarCombosLoteForeignKeyCuentaBancoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBanco,String finalQueryGlobalTipoCuentaBancoGlobal,String finalQueryGlobalCuentaContable,String finalQueryGlobalEstadoCuentaBanco,String finalQueryGlobalFormatoIngreso,String finalQueryGlobalFormatoEgreso,String finalQueryGlobalFormatoDiario,String finalQueryGlobalFormatoCheque,String finalQueryGlobalFormatoRetencion,String finalQueryGlobalFormatoRetencionIva) throws Exception {
		CuentaBancoParameterReturnGeneral  cuentabancoReturnGeneral =new CuentaBancoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBanco.class.getSimpleName()+"-cargarCombosLoteForeignKeyCuentaBancoWithConnection");connexion.begin();
			
			cuentabancoReturnGeneral =new CuentaBancoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cuentabancoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			cuentabancoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Banco> bancosForeignKey=new ArrayList<Banco>();
			BancoLogic bancoLogic=new BancoLogic();
			bancoLogic.setConnexion(this.connexion);
			bancoLogic.getBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBanco.equals("NONE")) {
				clases=new ArrayList<Classe>();
				arrClasses=new ArrayList<String>();

				arrClasses.add("TipoBanco");
				arrClasses.add("DepositoBanco");
				clases.addAll(BancoConstantesFunciones.getClassesForeignKeysFromStringsOfBanco(arrClasses,DeepLoadType.INCLUDE));
				clases.addAll(BancoConstantesFunciones.getClassesRelationshipsFromStringsOfBanco(arrClasses,DeepLoadType.INCLUDE));

				datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");


				bancoLogic.getBancoDataAccess().setIsForForeingKeyData(false);
				bancoLogic.setIsConDeep(true);
				bancoLogic.setDatosDeep(datosDeep);

				bancoLogic.getTodosBancos(finalQueryGlobalBanco,new Pagination());
				bancosForeignKey=bancoLogic.getBancos();
			}

			cuentabancoReturnGeneral.setbancosForeignKey(bancosForeignKey);


			List<TipoCuentaBancoGlobal> tipocuentabancoglobalsForeignKey=new ArrayList<TipoCuentaBancoGlobal>();
			TipoCuentaBancoGlobalLogic tipocuentabancoglobalLogic=new TipoCuentaBancoGlobalLogic();
			tipocuentabancoglobalLogic.setConnexion(this.connexion);
			tipocuentabancoglobalLogic.getTipoCuentaBancoGlobalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCuentaBancoGlobal.equals("NONE")) {
				tipocuentabancoglobalLogic.getTodosTipoCuentaBancoGlobals(finalQueryGlobalTipoCuentaBancoGlobal,new Pagination());
				tipocuentabancoglobalsForeignKey=tipocuentabancoglobalLogic.getTipoCuentaBancoGlobals();
			}

			cuentabancoReturnGeneral.settipocuentabancoglobalsForeignKey(tipocuentabancoglobalsForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			cuentabancoReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<EstadoCuentaBanco> estadocuentabancosForeignKey=new ArrayList<EstadoCuentaBanco>();
			EstadoCuentaBancoLogic estadocuentabancoLogic=new EstadoCuentaBancoLogic();
			estadocuentabancoLogic.setConnexion(this.connexion);
			//estadocuentabancoLogic.getEstadoCuentaBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoCuentaBanco.equals("NONE")) {
				estadocuentabancoLogic.getTodosEstadoCuentaBancos(finalQueryGlobalEstadoCuentaBanco,new Pagination());
				estadocuentabancosForeignKey=estadocuentabancoLogic.getEstadoCuentaBancos();
			}

			cuentabancoReturnGeneral.setestadocuentabancosForeignKey(estadocuentabancosForeignKey);


			List<Formato> formatoingresosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoingresoLogic=new FormatoLogic();
			formatoingresoLogic.setConnexion(this.connexion);
			formatoingresoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoIngreso.equals("NONE")) {
				formatoingresoLogic.getTodosFormatos(finalQueryGlobalFormatoIngreso,new Pagination());
				formatoingresosForeignKey=formatoingresoLogic.getFormatos();
			}

			cuentabancoReturnGeneral.setformatoingresosForeignKey(formatoingresosForeignKey);


			List<Formato> formatoegresosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoegresoLogic=new FormatoLogic();
			formatoegresoLogic.setConnexion(this.connexion);
			formatoegresoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoEgreso.equals("NONE")) {
				formatoegresoLogic.getTodosFormatos(finalQueryGlobalFormatoEgreso,new Pagination());
				formatoegresosForeignKey=formatoegresoLogic.getFormatos();
			}

			cuentabancoReturnGeneral.setformatoegresosForeignKey(formatoegresosForeignKey);


			List<Formato> formatodiariosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatodiarioLogic=new FormatoLogic();
			formatodiarioLogic.setConnexion(this.connexion);
			formatodiarioLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoDiario.equals("NONE")) {
				formatodiarioLogic.getTodosFormatos(finalQueryGlobalFormatoDiario,new Pagination());
				formatodiariosForeignKey=formatodiarioLogic.getFormatos();
			}

			cuentabancoReturnGeneral.setformatodiariosForeignKey(formatodiariosForeignKey);


			List<Formato> formatochequesForeignKey=new ArrayList<Formato>();
			FormatoLogic formatochequeLogic=new FormatoLogic();
			formatochequeLogic.setConnexion(this.connexion);
			formatochequeLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoCheque.equals("NONE")) {
				formatochequeLogic.getTodosFormatos(finalQueryGlobalFormatoCheque,new Pagination());
				formatochequesForeignKey=formatochequeLogic.getFormatos();
			}

			cuentabancoReturnGeneral.setformatochequesForeignKey(formatochequesForeignKey);


			List<Formato> formatoretencionsForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoretencionLogic=new FormatoLogic();
			formatoretencionLogic.setConnexion(this.connexion);
			formatoretencionLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoRetencion.equals("NONE")) {
				formatoretencionLogic.getTodosFormatos(finalQueryGlobalFormatoRetencion,new Pagination());
				formatoretencionsForeignKey=formatoretencionLogic.getFormatos();
			}

			cuentabancoReturnGeneral.setformatoretencionsForeignKey(formatoretencionsForeignKey);


			List<Formato> formatoretencionivasForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoretencionivaLogic=new FormatoLogic();
			formatoretencionivaLogic.setConnexion(this.connexion);
			formatoretencionivaLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoRetencionIva.equals("NONE")) {
				formatoretencionivaLogic.getTodosFormatos(finalQueryGlobalFormatoRetencionIva,new Pagination());
				formatoretencionivasForeignKey=formatoretencionivaLogic.getFormatos();
			}

			cuentabancoReturnGeneral.setformatoretencionivasForeignKey(formatoretencionivasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return cuentabancoReturnGeneral;
	}
	
	public CuentaBancoParameterReturnGeneral cargarCombosLoteForeignKeyCuentaBanco(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBanco,String finalQueryGlobalTipoCuentaBancoGlobal,String finalQueryGlobalCuentaContable,String finalQueryGlobalEstadoCuentaBanco,String finalQueryGlobalFormatoIngreso,String finalQueryGlobalFormatoEgreso,String finalQueryGlobalFormatoDiario,String finalQueryGlobalFormatoCheque,String finalQueryGlobalFormatoRetencion,String finalQueryGlobalFormatoRetencionIva) throws Exception {
		CuentaBancoParameterReturnGeneral  cuentabancoReturnGeneral =new CuentaBancoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			cuentabancoReturnGeneral =new CuentaBancoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cuentabancoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			cuentabancoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Banco> bancosForeignKey=new ArrayList<Banco>();
			BancoLogic bancoLogic=new BancoLogic();
			bancoLogic.setConnexion(this.connexion);
			bancoLogic.getBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBanco.equals("NONE")) {
				clases=new ArrayList<Classe>();
				arrClasses=new ArrayList<String>();

				arrClasses.add("TipoBanco");
				arrClasses.add("DepositoBanco");
				clases.addAll(BancoConstantesFunciones.getClassesForeignKeysFromStringsOfBanco(arrClasses,DeepLoadType.INCLUDE));
				clases.addAll(BancoConstantesFunciones.getClassesRelationshipsFromStringsOfBanco(arrClasses,DeepLoadType.INCLUDE));

				datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");


				bancoLogic.getBancoDataAccess().setIsForForeingKeyData(false);
				bancoLogic.setIsConDeep(true);
				bancoLogic.setDatosDeep(datosDeep);

				bancoLogic.getTodosBancos(finalQueryGlobalBanco,new Pagination());
				bancosForeignKey=bancoLogic.getBancos();
			}

			cuentabancoReturnGeneral.setbancosForeignKey(bancosForeignKey);


			List<TipoCuentaBancoGlobal> tipocuentabancoglobalsForeignKey=new ArrayList<TipoCuentaBancoGlobal>();
			TipoCuentaBancoGlobalLogic tipocuentabancoglobalLogic=new TipoCuentaBancoGlobalLogic();
			tipocuentabancoglobalLogic.setConnexion(this.connexion);
			tipocuentabancoglobalLogic.getTipoCuentaBancoGlobalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCuentaBancoGlobal.equals("NONE")) {
				tipocuentabancoglobalLogic.getTodosTipoCuentaBancoGlobals(finalQueryGlobalTipoCuentaBancoGlobal,new Pagination());
				tipocuentabancoglobalsForeignKey=tipocuentabancoglobalLogic.getTipoCuentaBancoGlobals();
			}

			cuentabancoReturnGeneral.settipocuentabancoglobalsForeignKey(tipocuentabancoglobalsForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			cuentabancoReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<EstadoCuentaBanco> estadocuentabancosForeignKey=new ArrayList<EstadoCuentaBanco>();
			EstadoCuentaBancoLogic estadocuentabancoLogic=new EstadoCuentaBancoLogic();
			estadocuentabancoLogic.setConnexion(this.connexion);
			//estadocuentabancoLogic.getEstadoCuentaBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoCuentaBanco.equals("NONE")) {
				estadocuentabancoLogic.getTodosEstadoCuentaBancos(finalQueryGlobalEstadoCuentaBanco,new Pagination());
				estadocuentabancosForeignKey=estadocuentabancoLogic.getEstadoCuentaBancos();
			}

			cuentabancoReturnGeneral.setestadocuentabancosForeignKey(estadocuentabancosForeignKey);


			List<Formato> formatoingresosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoingresoLogic=new FormatoLogic();
			formatoingresoLogic.setConnexion(this.connexion);
			formatoingresoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoIngreso.equals("NONE")) {
				formatoingresoLogic.getTodosFormatos(finalQueryGlobalFormatoIngreso,new Pagination());
				formatoingresosForeignKey=formatoingresoLogic.getFormatos();
			}

			cuentabancoReturnGeneral.setformatoingresosForeignKey(formatoingresosForeignKey);


			List<Formato> formatoegresosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoegresoLogic=new FormatoLogic();
			formatoegresoLogic.setConnexion(this.connexion);
			formatoegresoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoEgreso.equals("NONE")) {
				formatoegresoLogic.getTodosFormatos(finalQueryGlobalFormatoEgreso,new Pagination());
				formatoegresosForeignKey=formatoegresoLogic.getFormatos();
			}

			cuentabancoReturnGeneral.setformatoegresosForeignKey(formatoegresosForeignKey);


			List<Formato> formatodiariosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatodiarioLogic=new FormatoLogic();
			formatodiarioLogic.setConnexion(this.connexion);
			formatodiarioLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoDiario.equals("NONE")) {
				formatodiarioLogic.getTodosFormatos(finalQueryGlobalFormatoDiario,new Pagination());
				formatodiariosForeignKey=formatodiarioLogic.getFormatos();
			}

			cuentabancoReturnGeneral.setformatodiariosForeignKey(formatodiariosForeignKey);


			List<Formato> formatochequesForeignKey=new ArrayList<Formato>();
			FormatoLogic formatochequeLogic=new FormatoLogic();
			formatochequeLogic.setConnexion(this.connexion);
			formatochequeLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoCheque.equals("NONE")) {
				formatochequeLogic.getTodosFormatos(finalQueryGlobalFormatoCheque,new Pagination());
				formatochequesForeignKey=formatochequeLogic.getFormatos();
			}

			cuentabancoReturnGeneral.setformatochequesForeignKey(formatochequesForeignKey);


			List<Formato> formatoretencionsForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoretencionLogic=new FormatoLogic();
			formatoretencionLogic.setConnexion(this.connexion);
			formatoretencionLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoRetencion.equals("NONE")) {
				formatoretencionLogic.getTodosFormatos(finalQueryGlobalFormatoRetencion,new Pagination());
				formatoretencionsForeignKey=formatoretencionLogic.getFormatos();
			}

			cuentabancoReturnGeneral.setformatoretencionsForeignKey(formatoretencionsForeignKey);


			List<Formato> formatoretencionivasForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoretencionivaLogic=new FormatoLogic();
			formatoretencionivaLogic.setConnexion(this.connexion);
			formatoretencionivaLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormatoRetencionIva.equals("NONE")) {
				formatoretencionivaLogic.getTodosFormatos(finalQueryGlobalFormatoRetencionIva,new Pagination());
				formatoretencionivasForeignKey=formatoretencionivaLogic.getFormatos();
			}

			cuentabancoReturnGeneral.setformatoretencionivasForeignKey(formatoretencionivasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return cuentabancoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyCuentaBancoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			PagoAutoLogic pagoautoLogic=new PagoAutoLogic();
			AutoriPagoOrdenCompraLogic autoripagoordencompraLogic=new AutoriPagoOrdenCompraLogic();
			DetalleChequeGiradoLogic detallechequegiradoLogic=new DetalleChequeGiradoLogic();
			AutoriPagoLogic autoripagoLogic=new AutoriPagoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBanco.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyCuentaBancoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(PagoAuto.class));
			classes.add(new Classe(AutoriPagoOrdenCompra.class));
			classes.add(new Classe(DetalleChequeGirado.class));
			classes.add(new Classe(AutoriPago.class));
											
			

			pagoautoLogic.setConnexion(this.getConnexion());
			pagoautoLogic.setDatosCliente(this.datosCliente);
			pagoautoLogic.setIsConRefrescarForeignKeys(true);

			autoripagoordencompraLogic.setConnexion(this.getConnexion());
			autoripagoordencompraLogic.setDatosCliente(this.datosCliente);
			autoripagoordencompraLogic.setIsConRefrescarForeignKeys(true);

			detallechequegiradoLogic.setConnexion(this.getConnexion());
			detallechequegiradoLogic.setDatosCliente(this.datosCliente);
			detallechequegiradoLogic.setIsConRefrescarForeignKeys(true);

			autoripagoLogic.setConnexion(this.getConnexion());
			autoripagoLogic.setDatosCliente(this.datosCliente);
			autoripagoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(CuentaBanco cuentabanco:this.cuentabancos) {
				

				classes=new ArrayList<Classe>();
				classes=PagoAutoConstantesFunciones.getClassesForeignKeysOfPagoAuto(new ArrayList<Classe>(),DeepLoadType.NONE);

				pagoautoLogic.setPagoAutos(cuentabanco.pagoautos);
				pagoautoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=AutoriPagoOrdenCompraConstantesFunciones.getClassesForeignKeysOfAutoriPagoOrdenCompra(new ArrayList<Classe>(),DeepLoadType.NONE);

				autoripagoordencompraLogic.setAutoriPagoOrdenCompras(cuentabanco.autoripagoordencompras);
				autoripagoordencompraLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DetalleChequeGiradoConstantesFunciones.getClassesForeignKeysOfDetalleChequeGirado(new ArrayList<Classe>(),DeepLoadType.NONE);

				detallechequegiradoLogic.setDetalleChequeGirados(cuentabanco.detallechequegirados);
				detallechequegiradoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=AutoriPagoConstantesFunciones.getClassesForeignKeysOfAutoriPago(new ArrayList<Classe>(),DeepLoadType.NONE);

				autoripagoLogic.setAutoriPagos(cuentabanco.autoripagos);
				autoripagoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(CuentaBanco cuentabanco,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CuentaBancoLogicAdditional.updateCuentaBancoToGet(cuentabanco,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cuentabanco.setEmpresa(cuentabancoDataAccess.getEmpresa(connexion,cuentabanco));
		cuentabanco.setSucursal(cuentabancoDataAccess.getSucursal(connexion,cuentabanco));
		cuentabanco.setBanco(cuentabancoDataAccess.getBanco(connexion,cuentabanco));
		cuentabanco.setTipoCuentaBancoGlobal(cuentabancoDataAccess.getTipoCuentaBancoGlobal(connexion,cuentabanco));
		cuentabanco.setCuentaContable(cuentabancoDataAccess.getCuentaContable(connexion,cuentabanco));
		cuentabanco.setEstadoCuentaBanco(cuentabancoDataAccess.getEstadoCuentaBanco(connexion,cuentabanco));
		cuentabanco.setFormatoIngreso(cuentabancoDataAccess.getFormatoIngreso(connexion,cuentabanco));
		cuentabanco.setFormatoEgreso(cuentabancoDataAccess.getFormatoEgreso(connexion,cuentabanco));
		cuentabanco.setFormatoDiario(cuentabancoDataAccess.getFormatoDiario(connexion,cuentabanco));
		cuentabanco.setFormatoCheque(cuentabancoDataAccess.getFormatoCheque(connexion,cuentabanco));
		cuentabanco.setFormatoRetencion(cuentabancoDataAccess.getFormatoRetencion(connexion,cuentabanco));
		cuentabanco.setFormatoRetencionIva(cuentabancoDataAccess.getFormatoRetencionIva(connexion,cuentabanco));
		cuentabanco.setPagoAutos(cuentabancoDataAccess.getPagoAutos(connexion,cuentabanco));
		cuentabanco.setAutoriPagoOrdenCompras(cuentabancoDataAccess.getAutoriPagoOrdenCompras(connexion,cuentabanco));
		cuentabanco.setDetalleChequeGirados(cuentabancoDataAccess.getDetalleChequeGirados(connexion,cuentabanco));
		cuentabanco.setAutoriPagos(cuentabancoDataAccess.getAutoriPagos(connexion,cuentabanco));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cuentabanco.setEmpresa(cuentabancoDataAccess.getEmpresa(connexion,cuentabanco));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				cuentabanco.setSucursal(cuentabancoDataAccess.getSucursal(connexion,cuentabanco));
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				cuentabanco.setBanco(cuentabancoDataAccess.getBanco(connexion,cuentabanco));
				continue;
			}

			if(clas.clas.equals(TipoCuentaBancoGlobal.class)) {
				cuentabanco.setTipoCuentaBancoGlobal(cuentabancoDataAccess.getTipoCuentaBancoGlobal(connexion,cuentabanco));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentabanco.setCuentaContable(cuentabancoDataAccess.getCuentaContable(connexion,cuentabanco));
				continue;
			}

			if(clas.clas.equals(EstadoCuentaBanco.class)) {
				cuentabanco.setEstadoCuentaBanco(cuentabancoDataAccess.getEstadoCuentaBanco(connexion,cuentabanco));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				cuentabanco.setFormatoIngreso(cuentabancoDataAccess.getFormatoIngreso(connexion,cuentabanco));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				cuentabanco.setFormatoEgreso(cuentabancoDataAccess.getFormatoEgreso(connexion,cuentabanco));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				cuentabanco.setFormatoDiario(cuentabancoDataAccess.getFormatoDiario(connexion,cuentabanco));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				cuentabanco.setFormatoCheque(cuentabancoDataAccess.getFormatoCheque(connexion,cuentabanco));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				cuentabanco.setFormatoRetencion(cuentabancoDataAccess.getFormatoRetencion(connexion,cuentabanco));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				cuentabanco.setFormatoRetencionIva(cuentabancoDataAccess.getFormatoRetencionIva(connexion,cuentabanco));
				continue;
			}

			if(clas.clas.equals(PagoAuto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cuentabanco.setPagoAutos(cuentabancoDataAccess.getPagoAutos(connexion,cuentabanco));

				if(this.isConDeep) {
					PagoAutoLogic pagoautoLogic= new PagoAutoLogic(this.connexion);
					pagoautoLogic.setPagoAutos(cuentabanco.getPagoAutos());
					ArrayList<Classe> classesLocal=PagoAutoConstantesFunciones.getClassesForeignKeysOfPagoAuto(new ArrayList<Classe>(),DeepLoadType.NONE);
					pagoautoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PagoAutoConstantesFunciones.refrescarForeignKeysDescripcionesPagoAuto(pagoautoLogic.getPagoAutos());
					cuentabanco.setPagoAutos(pagoautoLogic.getPagoAutos());
				}

				continue;
			}

			if(clas.clas.equals(AutoriPagoOrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cuentabanco.setAutoriPagoOrdenCompras(cuentabancoDataAccess.getAutoriPagoOrdenCompras(connexion,cuentabanco));

				if(this.isConDeep) {
					AutoriPagoOrdenCompraLogic autoripagoordencompraLogic= new AutoriPagoOrdenCompraLogic(this.connexion);
					autoripagoordencompraLogic.setAutoriPagoOrdenCompras(cuentabanco.getAutoriPagoOrdenCompras());
					ArrayList<Classe> classesLocal=AutoriPagoOrdenCompraConstantesFunciones.getClassesForeignKeysOfAutoriPagoOrdenCompra(new ArrayList<Classe>(),DeepLoadType.NONE);
					autoripagoordencompraLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					AutoriPagoOrdenCompraConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPagoOrdenCompra(autoripagoordencompraLogic.getAutoriPagoOrdenCompras());
					cuentabanco.setAutoriPagoOrdenCompras(autoripagoordencompraLogic.getAutoriPagoOrdenCompras());
				}

				continue;
			}

			if(clas.clas.equals(DetalleChequeGirado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cuentabanco.setDetalleChequeGirados(cuentabancoDataAccess.getDetalleChequeGirados(connexion,cuentabanco));

				if(this.isConDeep) {
					DetalleChequeGiradoLogic detallechequegiradoLogic= new DetalleChequeGiradoLogic(this.connexion);
					detallechequegiradoLogic.setDetalleChequeGirados(cuentabanco.getDetalleChequeGirados());
					ArrayList<Classe> classesLocal=DetalleChequeGiradoConstantesFunciones.getClassesForeignKeysOfDetalleChequeGirado(new ArrayList<Classe>(),DeepLoadType.NONE);
					detallechequegiradoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleChequeGiradoConstantesFunciones.refrescarForeignKeysDescripcionesDetalleChequeGirado(detallechequegiradoLogic.getDetalleChequeGirados());
					cuentabanco.setDetalleChequeGirados(detallechequegiradoLogic.getDetalleChequeGirados());
				}

				continue;
			}

			if(clas.clas.equals(AutoriPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cuentabanco.setAutoriPagos(cuentabancoDataAccess.getAutoriPagos(connexion,cuentabanco));

				if(this.isConDeep) {
					AutoriPagoLogic autoripagoLogic= new AutoriPagoLogic(this.connexion);
					autoripagoLogic.setAutoriPagos(cuentabanco.getAutoriPagos());
					ArrayList<Classe> classesLocal=AutoriPagoConstantesFunciones.getClassesForeignKeysOfAutoriPago(new ArrayList<Classe>(),DeepLoadType.NONE);
					autoripagoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					AutoriPagoConstantesFunciones.refrescarForeignKeysDescripcionesAutoriPago(autoripagoLogic.getAutoriPagos());
					cuentabanco.setAutoriPagos(autoripagoLogic.getAutoriPagos());
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
			cuentabanco.setEmpresa(cuentabancoDataAccess.getEmpresa(connexion,cuentabanco));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentabanco.setSucursal(cuentabancoDataAccess.getSucursal(connexion,cuentabanco));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Banco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentabanco.setBanco(cuentabancoDataAccess.getBanco(connexion,cuentabanco));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCuentaBancoGlobal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentabanco.setTipoCuentaBancoGlobal(cuentabancoDataAccess.getTipoCuentaBancoGlobal(connexion,cuentabanco));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentabanco.setCuentaContable(cuentabancoDataAccess.getCuentaContable(connexion,cuentabanco));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoCuentaBanco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentabanco.setEstadoCuentaBanco(cuentabancoDataAccess.getEstadoCuentaBanco(connexion,cuentabanco));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentabanco.setFormatoIngreso(cuentabancoDataAccess.getFormatoIngreso(connexion,cuentabanco));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentabanco.setFormatoEgreso(cuentabancoDataAccess.getFormatoEgreso(connexion,cuentabanco));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentabanco.setFormatoDiario(cuentabancoDataAccess.getFormatoDiario(connexion,cuentabanco));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentabanco.setFormatoCheque(cuentabancoDataAccess.getFormatoCheque(connexion,cuentabanco));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentabanco.setFormatoRetencion(cuentabancoDataAccess.getFormatoRetencion(connexion,cuentabanco));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentabanco.setFormatoRetencionIva(cuentabancoDataAccess.getFormatoRetencionIva(connexion,cuentabanco));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PagoAuto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PagoAuto.class));
			cuentabanco.setPagoAutos(cuentabancoDataAccess.getPagoAutos(connexion,cuentabanco));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AutoriPagoOrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(AutoriPagoOrdenCompra.class));
			cuentabanco.setAutoriPagoOrdenCompras(cuentabancoDataAccess.getAutoriPagoOrdenCompras(connexion,cuentabanco));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleChequeGirado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleChequeGirado.class));
			cuentabanco.setDetalleChequeGirados(cuentabancoDataAccess.getDetalleChequeGirados(connexion,cuentabanco));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AutoriPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(AutoriPago.class));
			cuentabanco.setAutoriPagos(cuentabancoDataAccess.getAutoriPagos(connexion,cuentabanco));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cuentabanco.setEmpresa(cuentabancoDataAccess.getEmpresa(connexion,cuentabanco));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cuentabanco.getEmpresa(),isDeep,deepLoadType,clases);
				
		cuentabanco.setSucursal(cuentabancoDataAccess.getSucursal(connexion,cuentabanco));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(cuentabanco.getSucursal(),isDeep,deepLoadType,clases);
				
		cuentabanco.setBanco(cuentabancoDataAccess.getBanco(connexion,cuentabanco));
		BancoLogic bancoLogic= new BancoLogic(connexion);
		bancoLogic.deepLoad(cuentabanco.getBanco(),isDeep,deepLoadType,clases);
				
		cuentabanco.setTipoCuentaBancoGlobal(cuentabancoDataAccess.getTipoCuentaBancoGlobal(connexion,cuentabanco));
		TipoCuentaBancoGlobalLogic tipocuentabancoglobalLogic= new TipoCuentaBancoGlobalLogic(connexion);
		tipocuentabancoglobalLogic.deepLoad(cuentabanco.getTipoCuentaBancoGlobal(),isDeep,deepLoadType,clases);
				
		cuentabanco.setCuentaContable(cuentabancoDataAccess.getCuentaContable(connexion,cuentabanco));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(cuentabanco.getCuentaContable(),isDeep,deepLoadType,clases);
				
		cuentabanco.setEstadoCuentaBanco(cuentabancoDataAccess.getEstadoCuentaBanco(connexion,cuentabanco));
		EstadoCuentaBancoLogic estadocuentabancoLogic= new EstadoCuentaBancoLogic(connexion);
		estadocuentabancoLogic.deepLoad(cuentabanco.getEstadoCuentaBanco(),isDeep,deepLoadType,clases);
				
		cuentabanco.setFormatoIngreso(cuentabancoDataAccess.getFormatoIngreso(connexion,cuentabanco));
		FormatoLogic formatoingresoLogic= new FormatoLogic(connexion);
		formatoingresoLogic.deepLoad(cuentabanco.getFormatoIngreso(),isDeep,deepLoadType,clases);
				
		cuentabanco.setFormatoEgreso(cuentabancoDataAccess.getFormatoEgreso(connexion,cuentabanco));
		FormatoLogic formatoegresoLogic= new FormatoLogic(connexion);
		formatoegresoLogic.deepLoad(cuentabanco.getFormatoEgreso(),isDeep,deepLoadType,clases);
				
		cuentabanco.setFormatoDiario(cuentabancoDataAccess.getFormatoDiario(connexion,cuentabanco));
		FormatoLogic formatodiarioLogic= new FormatoLogic(connexion);
		formatodiarioLogic.deepLoad(cuentabanco.getFormatoDiario(),isDeep,deepLoadType,clases);
				
		cuentabanco.setFormatoCheque(cuentabancoDataAccess.getFormatoCheque(connexion,cuentabanco));
		FormatoLogic formatochequeLogic= new FormatoLogic(connexion);
		formatochequeLogic.deepLoad(cuentabanco.getFormatoCheque(),isDeep,deepLoadType,clases);
				
		cuentabanco.setFormatoRetencion(cuentabancoDataAccess.getFormatoRetencion(connexion,cuentabanco));
		FormatoLogic formatoretencionLogic= new FormatoLogic(connexion);
		formatoretencionLogic.deepLoad(cuentabanco.getFormatoRetencion(),isDeep,deepLoadType,clases);
				
		cuentabanco.setFormatoRetencionIva(cuentabancoDataAccess.getFormatoRetencionIva(connexion,cuentabanco));
		FormatoLogic formatoretencionivaLogic= new FormatoLogic(connexion);
		formatoretencionivaLogic.deepLoad(cuentabanco.getFormatoRetencionIva(),isDeep,deepLoadType,clases);
				

		cuentabanco.setPagoAutos(cuentabancoDataAccess.getPagoAutos(connexion,cuentabanco));

		for(PagoAuto pagoauto:cuentabanco.getPagoAutos()) {
			PagoAutoLogic pagoautoLogic= new PagoAutoLogic(connexion);
			pagoautoLogic.deepLoad(pagoauto,isDeep,deepLoadType,clases);
		}

		cuentabanco.setAutoriPagoOrdenCompras(cuentabancoDataAccess.getAutoriPagoOrdenCompras(connexion,cuentabanco));

		for(AutoriPagoOrdenCompra autoripagoordencompra:cuentabanco.getAutoriPagoOrdenCompras()) {
			AutoriPagoOrdenCompraLogic autoripagoordencompraLogic= new AutoriPagoOrdenCompraLogic(connexion);
			autoripagoordencompraLogic.deepLoad(autoripagoordencompra,isDeep,deepLoadType,clases);
		}

		cuentabanco.setDetalleChequeGirados(cuentabancoDataAccess.getDetalleChequeGirados(connexion,cuentabanco));

		for(DetalleChequeGirado detallechequegirado:cuentabanco.getDetalleChequeGirados()) {
			DetalleChequeGiradoLogic detallechequegiradoLogic= new DetalleChequeGiradoLogic(connexion);
			detallechequegiradoLogic.deepLoad(detallechequegirado,isDeep,deepLoadType,clases);
		}

		cuentabanco.setAutoriPagos(cuentabancoDataAccess.getAutoriPagos(connexion,cuentabanco));

		for(AutoriPago autoripago:cuentabanco.getAutoriPagos()) {
			AutoriPagoLogic autoripagoLogic= new AutoriPagoLogic(connexion);
			autoripagoLogic.deepLoad(autoripago,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cuentabanco.setEmpresa(cuentabancoDataAccess.getEmpresa(connexion,cuentabanco));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(cuentabanco.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				cuentabanco.setSucursal(cuentabancoDataAccess.getSucursal(connexion,cuentabanco));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(cuentabanco.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				cuentabanco.setBanco(cuentabancoDataAccess.getBanco(connexion,cuentabanco));
				BancoLogic bancoLogic= new BancoLogic(connexion);
				bancoLogic.deepLoad(cuentabanco.getBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCuentaBancoGlobal.class)) {
				cuentabanco.setTipoCuentaBancoGlobal(cuentabancoDataAccess.getTipoCuentaBancoGlobal(connexion,cuentabanco));
				TipoCuentaBancoGlobalLogic tipocuentabancoglobalLogic= new TipoCuentaBancoGlobalLogic(connexion);
				tipocuentabancoglobalLogic.deepLoad(cuentabanco.getTipoCuentaBancoGlobal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentabanco.setCuentaContable(cuentabancoDataAccess.getCuentaContable(connexion,cuentabanco));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(cuentabanco.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoCuentaBanco.class)) {
				cuentabanco.setEstadoCuentaBanco(cuentabancoDataAccess.getEstadoCuentaBanco(connexion,cuentabanco));
				EstadoCuentaBancoLogic estadocuentabancoLogic= new EstadoCuentaBancoLogic(connexion);
				estadocuentabancoLogic.deepLoad(cuentabanco.getEstadoCuentaBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				cuentabanco.setFormatoIngreso(cuentabancoDataAccess.getFormatoIngreso(connexion,cuentabanco));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(cuentabanco.getFormatoIngreso(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				cuentabanco.setFormatoEgreso(cuentabancoDataAccess.getFormatoEgreso(connexion,cuentabanco));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(cuentabanco.getFormatoEgreso(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				cuentabanco.setFormatoDiario(cuentabancoDataAccess.getFormatoDiario(connexion,cuentabanco));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(cuentabanco.getFormatoDiario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				cuentabanco.setFormatoCheque(cuentabancoDataAccess.getFormatoCheque(connexion,cuentabanco));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(cuentabanco.getFormatoCheque(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				cuentabanco.setFormatoRetencion(cuentabancoDataAccess.getFormatoRetencion(connexion,cuentabanco));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(cuentabanco.getFormatoRetencion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				cuentabanco.setFormatoRetencionIva(cuentabancoDataAccess.getFormatoRetencionIva(connexion,cuentabanco));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(cuentabanco.getFormatoRetencionIva(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PagoAuto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cuentabanco.setPagoAutos(cuentabancoDataAccess.getPagoAutos(connexion,cuentabanco));

				for(PagoAuto pagoauto:cuentabanco.getPagoAutos()) {
					PagoAutoLogic pagoautoLogic= new PagoAutoLogic(connexion);
					pagoautoLogic.deepLoad(pagoauto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(AutoriPagoOrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cuentabanco.setAutoriPagoOrdenCompras(cuentabancoDataAccess.getAutoriPagoOrdenCompras(connexion,cuentabanco));

				for(AutoriPagoOrdenCompra autoripagoordencompra:cuentabanco.getAutoriPagoOrdenCompras()) {
					AutoriPagoOrdenCompraLogic autoripagoordencompraLogic= new AutoriPagoOrdenCompraLogic(connexion);
					autoripagoordencompraLogic.deepLoad(autoripagoordencompra,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleChequeGirado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cuentabanco.setDetalleChequeGirados(cuentabancoDataAccess.getDetalleChequeGirados(connexion,cuentabanco));

				for(DetalleChequeGirado detallechequegirado:cuentabanco.getDetalleChequeGirados()) {
					DetalleChequeGiradoLogic detallechequegiradoLogic= new DetalleChequeGiradoLogic(connexion);
					detallechequegiradoLogic.deepLoad(detallechequegirado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(AutoriPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cuentabanco.setAutoriPagos(cuentabancoDataAccess.getAutoriPagos(connexion,cuentabanco));

				for(AutoriPago autoripago:cuentabanco.getAutoriPagos()) {
					AutoriPagoLogic autoripagoLogic= new AutoriPagoLogic(connexion);
					autoripagoLogic.deepLoad(autoripago,isDeep,deepLoadType,clases);
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
			cuentabanco.setEmpresa(cuentabancoDataAccess.getEmpresa(connexion,cuentabanco));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(cuentabanco.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentabanco.setSucursal(cuentabancoDataAccess.getSucursal(connexion,cuentabanco));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(cuentabanco.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Banco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentabanco.setBanco(cuentabancoDataAccess.getBanco(connexion,cuentabanco));
			BancoLogic bancoLogic= new BancoLogic(connexion);
			bancoLogic.deepLoad(cuentabanco.getBanco(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCuentaBancoGlobal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentabanco.setTipoCuentaBancoGlobal(cuentabancoDataAccess.getTipoCuentaBancoGlobal(connexion,cuentabanco));
			TipoCuentaBancoGlobalLogic tipocuentabancoglobalLogic= new TipoCuentaBancoGlobalLogic(connexion);
			tipocuentabancoglobalLogic.deepLoad(cuentabanco.getTipoCuentaBancoGlobal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentabanco.setCuentaContable(cuentabancoDataAccess.getCuentaContable(connexion,cuentabanco));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(cuentabanco.getCuentaContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoCuentaBanco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentabanco.setEstadoCuentaBanco(cuentabancoDataAccess.getEstadoCuentaBanco(connexion,cuentabanco));
			EstadoCuentaBancoLogic estadocuentabancoLogic= new EstadoCuentaBancoLogic(connexion);
			estadocuentabancoLogic.deepLoad(cuentabanco.getEstadoCuentaBanco(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentabanco.setFormatoIngreso(cuentabancoDataAccess.getFormatoIngreso(connexion,cuentabanco));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(cuentabanco.getFormatoIngreso(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentabanco.setFormatoEgreso(cuentabancoDataAccess.getFormatoEgreso(connexion,cuentabanco));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(cuentabanco.getFormatoEgreso(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentabanco.setFormatoDiario(cuentabancoDataAccess.getFormatoDiario(connexion,cuentabanco));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(cuentabanco.getFormatoDiario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentabanco.setFormatoCheque(cuentabancoDataAccess.getFormatoCheque(connexion,cuentabanco));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(cuentabanco.getFormatoCheque(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentabanco.setFormatoRetencion(cuentabancoDataAccess.getFormatoRetencion(connexion,cuentabanco));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(cuentabanco.getFormatoRetencion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentabanco.setFormatoRetencionIva(cuentabancoDataAccess.getFormatoRetencionIva(connexion,cuentabanco));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(cuentabanco.getFormatoRetencionIva(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PagoAuto.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PagoAuto.class));
			cuentabanco.setPagoAutos(cuentabancoDataAccess.getPagoAutos(connexion,cuentabanco));

			for(PagoAuto pagoauto:cuentabanco.getPagoAutos()) {
				PagoAutoLogic pagoautoLogic= new PagoAutoLogic(connexion);
				pagoautoLogic.deepLoad(pagoauto,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AutoriPagoOrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(AutoriPagoOrdenCompra.class));
			cuentabanco.setAutoriPagoOrdenCompras(cuentabancoDataAccess.getAutoriPagoOrdenCompras(connexion,cuentabanco));

			for(AutoriPagoOrdenCompra autoripagoordencompra:cuentabanco.getAutoriPagoOrdenCompras()) {
				AutoriPagoOrdenCompraLogic autoripagoordencompraLogic= new AutoriPagoOrdenCompraLogic(connexion);
				autoripagoordencompraLogic.deepLoad(autoripagoordencompra,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleChequeGirado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleChequeGirado.class));
			cuentabanco.setDetalleChequeGirados(cuentabancoDataAccess.getDetalleChequeGirados(connexion,cuentabanco));

			for(DetalleChequeGirado detallechequegirado:cuentabanco.getDetalleChequeGirados()) {
				DetalleChequeGiradoLogic detallechequegiradoLogic= new DetalleChequeGiradoLogic(connexion);
				detallechequegiradoLogic.deepLoad(detallechequegirado,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AutoriPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(AutoriPago.class));
			cuentabanco.setAutoriPagos(cuentabancoDataAccess.getAutoriPagos(connexion,cuentabanco));

			for(AutoriPago autoripago:cuentabanco.getAutoriPagos()) {
				AutoriPagoLogic autoripagoLogic= new AutoriPagoLogic(connexion);
				autoripagoLogic.deepLoad(autoripago,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(CuentaBanco cuentabanco,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			CuentaBancoLogicAdditional.updateCuentaBancoToSave(cuentabanco,this.arrDatoGeneral);
			
CuentaBancoDataAccess.save(cuentabanco, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(cuentabanco.getEmpresa(),connexion);

		SucursalDataAccess.save(cuentabanco.getSucursal(),connexion);

		BancoDataAccess.save(cuentabanco.getBanco(),connexion);

		TipoCuentaBancoGlobalDataAccess.save(cuentabanco.getTipoCuentaBancoGlobal(),connexion);

		CuentaContableDataAccess.save(cuentabanco.getCuentaContable(),connexion);

		EstadoCuentaBancoDataAccess.save(cuentabanco.getEstadoCuentaBanco(),connexion);

		FormatoDataAccess.save(cuentabanco.getFormatoIngreso(),connexion);

		FormatoDataAccess.save(cuentabanco.getFormatoEgreso(),connexion);

		FormatoDataAccess.save(cuentabanco.getFormatoDiario(),connexion);

		FormatoDataAccess.save(cuentabanco.getFormatoCheque(),connexion);

		FormatoDataAccess.save(cuentabanco.getFormatoRetencion(),connexion);

		FormatoDataAccess.save(cuentabanco.getFormatoRetencionIva(),connexion);

		for(PagoAuto pagoauto:cuentabanco.getPagoAutos()) {
			pagoauto.setid_cuenta_banco(cuentabanco.getId());
			PagoAutoDataAccess.save(pagoauto,connexion);
		}

		for(AutoriPagoOrdenCompra autoripagoordencompra:cuentabanco.getAutoriPagoOrdenCompras()) {
			autoripagoordencompra.setid_cuenta_banco(cuentabanco.getId());
			AutoriPagoOrdenCompraDataAccess.save(autoripagoordencompra,connexion);
		}

		for(DetalleChequeGirado detallechequegirado:cuentabanco.getDetalleChequeGirados()) {
			detallechequegirado.setid_cuenta_banco(cuentabanco.getId());
			DetalleChequeGiradoDataAccess.save(detallechequegirado,connexion);
		}

		for(AutoriPago autoripago:cuentabanco.getAutoriPagos()) {
			autoripago.setid_cuenta_banco(cuentabanco.getId());
			AutoriPagoDataAccess.save(autoripago,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cuentabanco.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(cuentabanco.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				BancoDataAccess.save(cuentabanco.getBanco(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoCuentaBancoGlobal.class)) {
				TipoCuentaBancoGlobalDataAccess.save(cuentabanco.getTipoCuentaBancoGlobal(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentabanco.getCuentaContable(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoCuentaBanco.class)) {
				EstadoCuentaBancoDataAccess.save(cuentabanco.getEstadoCuentaBanco(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(cuentabanco.getFormatoIngreso(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(cuentabanco.getFormatoEgreso(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(cuentabanco.getFormatoDiario(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(cuentabanco.getFormatoCheque(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(cuentabanco.getFormatoRetencion(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(cuentabanco.getFormatoRetencionIva(),connexion);
				continue;
			}


			if(clas.clas.equals(PagoAuto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PagoAuto pagoauto:cuentabanco.getPagoAutos()) {
					pagoauto.setid_cuenta_banco(cuentabanco.getId());
					PagoAutoDataAccess.save(pagoauto,connexion);
				}
				continue;
			}

			if(clas.clas.equals(AutoriPagoOrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(AutoriPagoOrdenCompra autoripagoordencompra:cuentabanco.getAutoriPagoOrdenCompras()) {
					autoripagoordencompra.setid_cuenta_banco(cuentabanco.getId());
					AutoriPagoOrdenCompraDataAccess.save(autoripagoordencompra,connexion);
				}
				continue;
			}

			if(clas.clas.equals(DetalleChequeGirado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleChequeGirado detallechequegirado:cuentabanco.getDetalleChequeGirados()) {
					detallechequegirado.setid_cuenta_banco(cuentabanco.getId());
					DetalleChequeGiradoDataAccess.save(detallechequegirado,connexion);
				}
				continue;
			}

			if(clas.clas.equals(AutoriPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(AutoriPago autoripago:cuentabanco.getAutoriPagos()) {
					autoripago.setid_cuenta_banco(cuentabanco.getId());
					AutoriPagoDataAccess.save(autoripago,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(cuentabanco.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cuentabanco.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(cuentabanco.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(cuentabanco.getSucursal(),isDeep,deepLoadType,clases);
				

		BancoDataAccess.save(cuentabanco.getBanco(),connexion);
		BancoLogic bancoLogic= new BancoLogic(connexion);
		bancoLogic.deepLoad(cuentabanco.getBanco(),isDeep,deepLoadType,clases);
				

		TipoCuentaBancoGlobalDataAccess.save(cuentabanco.getTipoCuentaBancoGlobal(),connexion);
		TipoCuentaBancoGlobalLogic tipocuentabancoglobalLogic= new TipoCuentaBancoGlobalLogic(connexion);
		tipocuentabancoglobalLogic.deepLoad(cuentabanco.getTipoCuentaBancoGlobal(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(cuentabanco.getCuentaContable(),connexion);
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(cuentabanco.getCuentaContable(),isDeep,deepLoadType,clases);
				

		EstadoCuentaBancoDataAccess.save(cuentabanco.getEstadoCuentaBanco(),connexion);
		EstadoCuentaBancoLogic estadocuentabancoLogic= new EstadoCuentaBancoLogic(connexion);
		estadocuentabancoLogic.deepLoad(cuentabanco.getEstadoCuentaBanco(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(cuentabanco.getFormatoIngreso(),connexion);
		FormatoLogic formatoingresoLogic= new FormatoLogic(connexion);
		formatoingresoLogic.deepLoad(cuentabanco.getFormatoIngreso(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(cuentabanco.getFormatoEgreso(),connexion);
		FormatoLogic formatoegresoLogic= new FormatoLogic(connexion);
		formatoegresoLogic.deepLoad(cuentabanco.getFormatoEgreso(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(cuentabanco.getFormatoDiario(),connexion);
		FormatoLogic formatodiarioLogic= new FormatoLogic(connexion);
		formatodiarioLogic.deepLoad(cuentabanco.getFormatoDiario(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(cuentabanco.getFormatoCheque(),connexion);
		FormatoLogic formatochequeLogic= new FormatoLogic(connexion);
		formatochequeLogic.deepLoad(cuentabanco.getFormatoCheque(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(cuentabanco.getFormatoRetencion(),connexion);
		FormatoLogic formatoretencionLogic= new FormatoLogic(connexion);
		formatoretencionLogic.deepLoad(cuentabanco.getFormatoRetencion(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(cuentabanco.getFormatoRetencionIva(),connexion);
		FormatoLogic formatoretencionivaLogic= new FormatoLogic(connexion);
		formatoretencionivaLogic.deepLoad(cuentabanco.getFormatoRetencionIva(),isDeep,deepLoadType,clases);
				

		for(PagoAuto pagoauto:cuentabanco.getPagoAutos()) {
			PagoAutoLogic pagoautoLogic= new PagoAutoLogic(connexion);
			pagoauto.setid_cuenta_banco(cuentabanco.getId());
			PagoAutoDataAccess.save(pagoauto,connexion);
			pagoautoLogic.deepSave(pagoauto,isDeep,deepLoadType,clases);
		}

		for(AutoriPagoOrdenCompra autoripagoordencompra:cuentabanco.getAutoriPagoOrdenCompras()) {
			AutoriPagoOrdenCompraLogic autoripagoordencompraLogic= new AutoriPagoOrdenCompraLogic(connexion);
			autoripagoordencompra.setid_cuenta_banco(cuentabanco.getId());
			AutoriPagoOrdenCompraDataAccess.save(autoripagoordencompra,connexion);
			autoripagoordencompraLogic.deepSave(autoripagoordencompra,isDeep,deepLoadType,clases);
		}

		for(DetalleChequeGirado detallechequegirado:cuentabanco.getDetalleChequeGirados()) {
			DetalleChequeGiradoLogic detallechequegiradoLogic= new DetalleChequeGiradoLogic(connexion);
			detallechequegirado.setid_cuenta_banco(cuentabanco.getId());
			DetalleChequeGiradoDataAccess.save(detallechequegirado,connexion);
			detallechequegiradoLogic.deepSave(detallechequegirado,isDeep,deepLoadType,clases);
		}

		for(AutoriPago autoripago:cuentabanco.getAutoriPagos()) {
			AutoriPagoLogic autoripagoLogic= new AutoriPagoLogic(connexion);
			autoripago.setid_cuenta_banco(cuentabanco.getId());
			AutoriPagoDataAccess.save(autoripago,connexion);
			autoripagoLogic.deepSave(autoripago,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cuentabanco.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(cuentabanco.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(cuentabanco.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(cuentabanco.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				BancoDataAccess.save(cuentabanco.getBanco(),connexion);
				BancoLogic bancoLogic= new BancoLogic(connexion);
				bancoLogic.deepSave(cuentabanco.getBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCuentaBancoGlobal.class)) {
				TipoCuentaBancoGlobalDataAccess.save(cuentabanco.getTipoCuentaBancoGlobal(),connexion);
				TipoCuentaBancoGlobalLogic tipocuentabancoglobalLogic= new TipoCuentaBancoGlobalLogic(connexion);
				tipocuentabancoglobalLogic.deepSave(cuentabanco.getTipoCuentaBancoGlobal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentabanco.getCuentaContable(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(cuentabanco.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoCuentaBanco.class)) {
				EstadoCuentaBancoDataAccess.save(cuentabanco.getEstadoCuentaBanco(),connexion);
				EstadoCuentaBancoLogic estadocuentabancoLogic= new EstadoCuentaBancoLogic(connexion);
				estadocuentabancoLogic.deepSave(cuentabanco.getEstadoCuentaBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(cuentabanco.getFormatoIngreso(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(cuentabanco.getFormatoIngreso(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(cuentabanco.getFormatoEgreso(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(cuentabanco.getFormatoEgreso(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(cuentabanco.getFormatoDiario(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(cuentabanco.getFormatoDiario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(cuentabanco.getFormatoCheque(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(cuentabanco.getFormatoCheque(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(cuentabanco.getFormatoRetencion(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(cuentabanco.getFormatoRetencion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(cuentabanco.getFormatoRetencionIva(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(cuentabanco.getFormatoRetencionIva(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(PagoAuto.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PagoAuto pagoauto:cuentabanco.getPagoAutos()) {
					PagoAutoLogic pagoautoLogic= new PagoAutoLogic(connexion);
					pagoauto.setid_cuenta_banco(cuentabanco.getId());
					PagoAutoDataAccess.save(pagoauto,connexion);
					pagoautoLogic.deepSave(pagoauto,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(AutoriPagoOrdenCompra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(AutoriPagoOrdenCompra autoripagoordencompra:cuentabanco.getAutoriPagoOrdenCompras()) {
					AutoriPagoOrdenCompraLogic autoripagoordencompraLogic= new AutoriPagoOrdenCompraLogic(connexion);
					autoripagoordencompra.setid_cuenta_banco(cuentabanco.getId());
					AutoriPagoOrdenCompraDataAccess.save(autoripagoordencompra,connexion);
					autoripagoordencompraLogic.deepSave(autoripagoordencompra,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DetalleChequeGirado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleChequeGirado detallechequegirado:cuentabanco.getDetalleChequeGirados()) {
					DetalleChequeGiradoLogic detallechequegiradoLogic= new DetalleChequeGiradoLogic(connexion);
					detallechequegirado.setid_cuenta_banco(cuentabanco.getId());
					DetalleChequeGiradoDataAccess.save(detallechequegirado,connexion);
					detallechequegiradoLogic.deepSave(detallechequegirado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(AutoriPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(AutoriPago autoripago:cuentabanco.getAutoriPagos()) {
					AutoriPagoLogic autoripagoLogic= new AutoriPagoLogic(connexion);
					autoripago.setid_cuenta_banco(cuentabanco.getId());
					AutoriPagoDataAccess.save(autoripago,connexion);
					autoripagoLogic.deepSave(autoripago,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(CuentaBanco.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(cuentabanco,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(cuentabanco);
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
			this.deepLoad(this.cuentabanco,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabanco);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(CuentaBanco.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(cuentabancos!=null) {
				for(CuentaBanco cuentabanco:cuentabancos) {
					this.deepLoad(cuentabanco,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(cuentabancos);
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
			if(cuentabancos!=null) {
				for(CuentaBanco cuentabanco:cuentabancos) {
					this.deepLoad(cuentabanco,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(cuentabancos);
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
			this.getNewConnexionToDeep(CuentaBanco.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(cuentabanco,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(CuentaBanco.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(cuentabancos!=null) {
				for(CuentaBanco cuentabanco:cuentabancos) {
					this.deepSave(cuentabanco,isDeep,deepLoadType,clases);
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
			if(cuentabancos!=null) {
				for(CuentaBanco cuentabanco:cuentabancos) {
					this.deepSave(cuentabanco,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getCuentaBancosBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBanco.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",CuentaBancoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancos=cuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaBancosBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",CuentaBancoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancos=cuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaBancosBusquedaPorNumeroChequeWithConnection(String sFinalQuery,Pagination pagination,String numero_cheque)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBanco.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNumeroCheque= new ParameterSelectionGeneral();
			parameterSelectionGeneralNumeroCheque.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+numero_cheque+"%",CuentaBancoConstantesFunciones.NUMEROCHEQUE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNumeroCheque);

			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNumeroCheque","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancos=cuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaBancosBusquedaPorNumeroCheque(String sFinalQuery,Pagination pagination,String numero_cheque)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNumeroCheque= new ParameterSelectionGeneral();
			parameterSelectionGeneralNumeroCheque.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+numero_cheque+"%",CuentaBancoConstantesFunciones.NUMEROCHEQUE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNumeroCheque);

			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNumeroCheque","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancos=cuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaBancosBusquedaPorNumeroCuentaWithConnection(String sFinalQuery,Pagination pagination,String numero_cuenta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBanco.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNumeroCuenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralNumeroCuenta.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+numero_cuenta+"%",CuentaBancoConstantesFunciones.NUMEROCUENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNumeroCuenta);

			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNumeroCuenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancos=cuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaBancosBusquedaPorNumeroCuenta(String sFinalQuery,Pagination pagination,String numero_cuenta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNumeroCuenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralNumeroCuenta.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+numero_cuenta+"%",CuentaBancoConstantesFunciones.NUMEROCUENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNumeroCuenta);

			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNumeroCuenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancos=cuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaBancosBusquedaPorProcedenciaWithConnection(String sFinalQuery,Pagination pagination,String procedencia)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBanco.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralProcedencia= new ParameterSelectionGeneral();
			parameterSelectionGeneralProcedencia.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+procedencia+"%",CuentaBancoConstantesFunciones.PROCEDENCIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralProcedencia);

			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorProcedencia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancos=cuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaBancosBusquedaPorProcedencia(String sFinalQuery,Pagination pagination,String procedencia)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralProcedencia= new ParameterSelectionGeneral();
			parameterSelectionGeneralProcedencia.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+procedencia+"%",CuentaBancoConstantesFunciones.PROCEDENCIA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralProcedencia);

			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorProcedencia","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancos=cuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaBancosFK_IdBancoWithConnection(String sFinalQuery,Pagination pagination,Long id_banco)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBanco.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_banco,CuentaBancoConstantesFunciones.IDBANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBanco);

			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancos=cuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaBancosFK_IdBanco(String sFinalQuery,Pagination pagination,Long id_banco)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_banco,CuentaBancoConstantesFunciones.IDBANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBanco);

			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancos=cuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaBancosFK_IdCuentaContableWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBanco.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,CuentaBancoConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancos=cuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaBancosFK_IdCuentaContable(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,CuentaBancoConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancos=cuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaBancosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBanco.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CuentaBancoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancos=cuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaBancosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CuentaBancoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancos=cuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaBancosFK_IdEstadoCuentaBancoWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_cuenta_banco)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBanco.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoCuentaBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoCuentaBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_cuenta_banco,CuentaBancoConstantesFunciones.IDESTADOCUENTABANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoCuentaBanco);

			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoCuentaBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancos=cuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaBancosFK_IdEstadoCuentaBanco(String sFinalQuery,Pagination pagination,Long id_estado_cuenta_banco)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoCuentaBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoCuentaBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_cuenta_banco,CuentaBancoConstantesFunciones.IDESTADOCUENTABANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoCuentaBanco);

			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoCuentaBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancos=cuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaBancosFK_IdFormatoChequeWithConnection(String sFinalQuery,Pagination pagination,Long id_formato_cheque)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBanco.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoCheque= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoCheque.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_cheque,CuentaBancoConstantesFunciones.IDFORMATOCHEQUE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoCheque);

			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoCheque","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancos=cuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaBancosFK_IdFormatoCheque(String sFinalQuery,Pagination pagination,Long id_formato_cheque)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoCheque= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoCheque.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_cheque,CuentaBancoConstantesFunciones.IDFORMATOCHEQUE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoCheque);

			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoCheque","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancos=cuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaBancosFK_IdFormatoDiarioWithConnection(String sFinalQuery,Pagination pagination,Long id_formato_diario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBanco.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoDiario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoDiario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_diario,CuentaBancoConstantesFunciones.IDFORMATODIARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoDiario);

			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoDiario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancos=cuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaBancosFK_IdFormatoDiario(String sFinalQuery,Pagination pagination,Long id_formato_diario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoDiario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoDiario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_diario,CuentaBancoConstantesFunciones.IDFORMATODIARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoDiario);

			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoDiario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancos=cuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaBancosFK_IdFormatoEgresoWithConnection(String sFinalQuery,Pagination pagination,Long id_formato_egreso)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBanco.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoEgreso= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoEgreso.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_egreso,CuentaBancoConstantesFunciones.IDFORMATOEGRESO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoEgreso);

			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoEgreso","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancos=cuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaBancosFK_IdFormatoEgreso(String sFinalQuery,Pagination pagination,Long id_formato_egreso)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoEgreso= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoEgreso.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_egreso,CuentaBancoConstantesFunciones.IDFORMATOEGRESO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoEgreso);

			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoEgreso","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancos=cuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaBancosFK_IdFormatoIngresoWithConnection(String sFinalQuery,Pagination pagination,Long id_formato_ingreso)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBanco.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoIngreso= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoIngreso.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_ingreso,CuentaBancoConstantesFunciones.IDFORMATOINGRESO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoIngreso);

			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoIngreso","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancos=cuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaBancosFK_IdFormatoIngreso(String sFinalQuery,Pagination pagination,Long id_formato_ingreso)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoIngreso= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoIngreso.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_ingreso,CuentaBancoConstantesFunciones.IDFORMATOINGRESO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoIngreso);

			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoIngreso","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancos=cuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaBancosFK_IdFormatoRetencionWithConnection(String sFinalQuery,Pagination pagination,Long id_formato_retencion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBanco.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoRetencion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoRetencion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_retencion,CuentaBancoConstantesFunciones.IDFORMATORETENCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoRetencion);

			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoRetencion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancos=cuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaBancosFK_IdFormatoRetencion(String sFinalQuery,Pagination pagination,Long id_formato_retencion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoRetencion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoRetencion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_retencion,CuentaBancoConstantesFunciones.IDFORMATORETENCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoRetencion);

			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoRetencion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancos=cuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaBancosFK_IdFormatoRetencionIvaWithConnection(String sFinalQuery,Pagination pagination,Long id_formato_retencion_iva)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBanco.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoRetencionIva= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoRetencionIva.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_retencion_iva,CuentaBancoConstantesFunciones.IDFORMATORETENCIONIVA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoRetencionIva);

			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoRetencionIva","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancos=cuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaBancosFK_IdFormatoRetencionIva(String sFinalQuery,Pagination pagination,Long id_formato_retencion_iva)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormatoRetencionIva= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormatoRetencionIva.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato_retencion_iva,CuentaBancoConstantesFunciones.IDFORMATORETENCIONIVA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormatoRetencionIva);

			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormatoRetencionIva","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancos=cuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaBancosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBanco.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,CuentaBancoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancos=cuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaBancosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,CuentaBancoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancos=cuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaBancosFK_IdTipoCuentaBancoGlobalWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_cuenta_banco_global)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBanco.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCuentaBancoGlobal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCuentaBancoGlobal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cuenta_banco_global,CuentaBancoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCuentaBancoGlobal);

			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCuentaBancoGlobal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancos=cuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaBancosFK_IdTipoCuentaBancoGlobal(String sFinalQuery,Pagination pagination,Long id_tipo_cuenta_banco_global)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCuentaBancoGlobal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCuentaBancoGlobal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cuenta_banco_global,CuentaBancoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCuentaBancoGlobal);

			CuentaBancoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCuentaBancoGlobal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancos=cuentabancoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBanco(this.cuentabancos);
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
			if(CuentaBancoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,CuentaBancoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,CuentaBanco cuentabanco,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(CuentaBancoConstantesFunciones.ISCONAUDITORIA) {
				if(cuentabanco.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CuentaBancoDataAccess.TABLENAME, cuentabanco.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CuentaBancoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CuentaBancoLogic.registrarAuditoriaDetallesCuentaBanco(connexion,cuentabanco,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(cuentabanco.getIsDeleted()) {
					/*if(!cuentabanco.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,CuentaBancoDataAccess.TABLENAME, cuentabanco.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////CuentaBancoLogic.registrarAuditoriaDetallesCuentaBanco(connexion,cuentabanco,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CuentaBancoDataAccess.TABLENAME, cuentabanco.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(cuentabanco.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CuentaBancoDataAccess.TABLENAME, cuentabanco.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CuentaBancoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CuentaBancoLogic.registrarAuditoriaDetallesCuentaBanco(connexion,cuentabanco,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesCuentaBanco(Connexion connexion,CuentaBanco cuentabanco)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(cuentabanco.getIsNew()||!cuentabanco.getid_empresa().equals(cuentabanco.getCuentaBancoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentabanco.getCuentaBancoOriginal().getid_empresa()!=null)
				{
					strValorActual=cuentabanco.getCuentaBancoOriginal().getid_empresa().toString();
				}
				if(cuentabanco.getid_empresa()!=null)
				{
					strValorNuevo=cuentabanco.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaBancoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(cuentabanco.getIsNew()||!cuentabanco.getid_sucursal().equals(cuentabanco.getCuentaBancoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentabanco.getCuentaBancoOriginal().getid_sucursal()!=null)
				{
					strValorActual=cuentabanco.getCuentaBancoOriginal().getid_sucursal().toString();
				}
				if(cuentabanco.getid_sucursal()!=null)
				{
					strValorNuevo=cuentabanco.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaBancoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(cuentabanco.getIsNew()||!cuentabanco.getid_banco().equals(cuentabanco.getCuentaBancoOriginal().getid_banco()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentabanco.getCuentaBancoOriginal().getid_banco()!=null)
				{
					strValorActual=cuentabanco.getCuentaBancoOriginal().getid_banco().toString();
				}
				if(cuentabanco.getid_banco()!=null)
				{
					strValorNuevo=cuentabanco.getid_banco().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaBancoConstantesFunciones.IDBANCO,strValorActual,strValorNuevo);
			}	
			
			if(cuentabanco.getIsNew()||!cuentabanco.getid_tipo_cuenta_banco_global().equals(cuentabanco.getCuentaBancoOriginal().getid_tipo_cuenta_banco_global()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentabanco.getCuentaBancoOriginal().getid_tipo_cuenta_banco_global()!=null)
				{
					strValorActual=cuentabanco.getCuentaBancoOriginal().getid_tipo_cuenta_banco_global().toString();
				}
				if(cuentabanco.getid_tipo_cuenta_banco_global()!=null)
				{
					strValorNuevo=cuentabanco.getid_tipo_cuenta_banco_global().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaBancoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL,strValorActual,strValorNuevo);
			}	
			
			if(cuentabanco.getIsNew()||!cuentabanco.getcodigo().equals(cuentabanco.getCuentaBancoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentabanco.getCuentaBancoOriginal().getcodigo()!=null)
				{
					strValorActual=cuentabanco.getCuentaBancoOriginal().getcodigo();
				}
				if(cuentabanco.getcodigo()!=null)
				{
					strValorNuevo=cuentabanco.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaBancoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(cuentabanco.getIsNew()||!cuentabanco.getnumero_cuenta().equals(cuentabanco.getCuentaBancoOriginal().getnumero_cuenta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentabanco.getCuentaBancoOriginal().getnumero_cuenta()!=null)
				{
					strValorActual=cuentabanco.getCuentaBancoOriginal().getnumero_cuenta();
				}
				if(cuentabanco.getnumero_cuenta()!=null)
				{
					strValorNuevo=cuentabanco.getnumero_cuenta() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaBancoConstantesFunciones.NUMEROCUENTA,strValorActual,strValorNuevo);
			}	
			
			if(cuentabanco.getIsNew()||!cuentabanco.getnumero_cheque().equals(cuentabanco.getCuentaBancoOriginal().getnumero_cheque()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentabanco.getCuentaBancoOriginal().getnumero_cheque()!=null)
				{
					strValorActual=cuentabanco.getCuentaBancoOriginal().getnumero_cheque();
				}
				if(cuentabanco.getnumero_cheque()!=null)
				{
					strValorNuevo=cuentabanco.getnumero_cheque() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaBancoConstantesFunciones.NUMEROCHEQUE,strValorActual,strValorNuevo);
			}	
			
			if(cuentabanco.getIsNew()||!cuentabanco.getnumero_cheque_auxiliar().equals(cuentabanco.getCuentaBancoOriginal().getnumero_cheque_auxiliar()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentabanco.getCuentaBancoOriginal().getnumero_cheque_auxiliar()!=null)
				{
					strValorActual=cuentabanco.getCuentaBancoOriginal().getnumero_cheque_auxiliar();
				}
				if(cuentabanco.getnumero_cheque_auxiliar()!=null)
				{
					strValorNuevo=cuentabanco.getnumero_cheque_auxiliar() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaBancoConstantesFunciones.NUMEROCHEQUEAUXILIAR,strValorActual,strValorNuevo);
			}	
			
			if(cuentabanco.getIsNew()||!cuentabanco.getsaldo().equals(cuentabanco.getCuentaBancoOriginal().getsaldo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentabanco.getCuentaBancoOriginal().getsaldo()!=null)
				{
					strValorActual=cuentabanco.getCuentaBancoOriginal().getsaldo().toString();
				}
				if(cuentabanco.getsaldo()!=null)
				{
					strValorNuevo=cuentabanco.getsaldo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaBancoConstantesFunciones.SALDO,strValorActual,strValorNuevo);
			}	
			
			if(cuentabanco.getIsNew()||!cuentabanco.getprocedencia().equals(cuentabanco.getCuentaBancoOriginal().getprocedencia()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentabanco.getCuentaBancoOriginal().getprocedencia()!=null)
				{
					strValorActual=cuentabanco.getCuentaBancoOriginal().getprocedencia();
				}
				if(cuentabanco.getprocedencia()!=null)
				{
					strValorNuevo=cuentabanco.getprocedencia() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaBancoConstantesFunciones.PROCEDENCIA,strValorActual,strValorNuevo);
			}	
			
			if(cuentabanco.getIsNew()||!cuentabanco.getdestino().equals(cuentabanco.getCuentaBancoOriginal().getdestino()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentabanco.getCuentaBancoOriginal().getdestino()!=null)
				{
					strValorActual=cuentabanco.getCuentaBancoOriginal().getdestino();
				}
				if(cuentabanco.getdestino()!=null)
				{
					strValorNuevo=cuentabanco.getdestino() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaBancoConstantesFunciones.DESTINO,strValorActual,strValorNuevo);
			}	
			
			if(cuentabanco.getIsNew()||!cuentabanco.getid_cuenta_contable().equals(cuentabanco.getCuentaBancoOriginal().getid_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentabanco.getCuentaBancoOriginal().getid_cuenta_contable()!=null)
				{
					strValorActual=cuentabanco.getCuentaBancoOriginal().getid_cuenta_contable().toString();
				}
				if(cuentabanco.getid_cuenta_contable()!=null)
				{
					strValorNuevo=cuentabanco.getid_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaBancoConstantesFunciones.IDCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(cuentabanco.getIsNew()||!cuentabanco.getes_banco().equals(cuentabanco.getCuentaBancoOriginal().getes_banco()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentabanco.getCuentaBancoOriginal().getes_banco()!=null)
				{
					strValorActual=cuentabanco.getCuentaBancoOriginal().getes_banco().toString();
				}
				if(cuentabanco.getes_banco()!=null)
				{
					strValorNuevo=cuentabanco.getes_banco().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaBancoConstantesFunciones.ESBANCO,strValorActual,strValorNuevo);
			}	
			
			if(cuentabanco.getIsNew()||!cuentabanco.getid_estado_cuenta_banco().equals(cuentabanco.getCuentaBancoOriginal().getid_estado_cuenta_banco()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentabanco.getCuentaBancoOriginal().getid_estado_cuenta_banco()!=null)
				{
					strValorActual=cuentabanco.getCuentaBancoOriginal().getid_estado_cuenta_banco().toString();
				}
				if(cuentabanco.getid_estado_cuenta_banco()!=null)
				{
					strValorNuevo=cuentabanco.getid_estado_cuenta_banco().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaBancoConstantesFunciones.IDESTADOCUENTABANCO,strValorActual,strValorNuevo);
			}	
			
			if(cuentabanco.getIsNew()||!cuentabanco.getid_formato_ingreso().equals(cuentabanco.getCuentaBancoOriginal().getid_formato_ingreso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentabanco.getCuentaBancoOriginal().getid_formato_ingreso()!=null)
				{
					strValorActual=cuentabanco.getCuentaBancoOriginal().getid_formato_ingreso().toString();
				}
				if(cuentabanco.getid_formato_ingreso()!=null)
				{
					strValorNuevo=cuentabanco.getid_formato_ingreso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaBancoConstantesFunciones.IDFORMATOINGRESO,strValorActual,strValorNuevo);
			}	
			
			if(cuentabanco.getIsNew()||!cuentabanco.getid_formato_egreso().equals(cuentabanco.getCuentaBancoOriginal().getid_formato_egreso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentabanco.getCuentaBancoOriginal().getid_formato_egreso()!=null)
				{
					strValorActual=cuentabanco.getCuentaBancoOriginal().getid_formato_egreso().toString();
				}
				if(cuentabanco.getid_formato_egreso()!=null)
				{
					strValorNuevo=cuentabanco.getid_formato_egreso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaBancoConstantesFunciones.IDFORMATOEGRESO,strValorActual,strValorNuevo);
			}	
			
			if(cuentabanco.getIsNew()||!cuentabanco.getid_formato_diario().equals(cuentabanco.getCuentaBancoOriginal().getid_formato_diario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentabanco.getCuentaBancoOriginal().getid_formato_diario()!=null)
				{
					strValorActual=cuentabanco.getCuentaBancoOriginal().getid_formato_diario().toString();
				}
				if(cuentabanco.getid_formato_diario()!=null)
				{
					strValorNuevo=cuentabanco.getid_formato_diario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaBancoConstantesFunciones.IDFORMATODIARIO,strValorActual,strValorNuevo);
			}	
			
			if(cuentabanco.getIsNew()||!cuentabanco.getid_formato_cheque().equals(cuentabanco.getCuentaBancoOriginal().getid_formato_cheque()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentabanco.getCuentaBancoOriginal().getid_formato_cheque()!=null)
				{
					strValorActual=cuentabanco.getCuentaBancoOriginal().getid_formato_cheque().toString();
				}
				if(cuentabanco.getid_formato_cheque()!=null)
				{
					strValorNuevo=cuentabanco.getid_formato_cheque().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaBancoConstantesFunciones.IDFORMATOCHEQUE,strValorActual,strValorNuevo);
			}	
			
			if(cuentabanco.getIsNew()||!cuentabanco.getid_formato_retencion().equals(cuentabanco.getCuentaBancoOriginal().getid_formato_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentabanco.getCuentaBancoOriginal().getid_formato_retencion()!=null)
				{
					strValorActual=cuentabanco.getCuentaBancoOriginal().getid_formato_retencion().toString();
				}
				if(cuentabanco.getid_formato_retencion()!=null)
				{
					strValorNuevo=cuentabanco.getid_formato_retencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaBancoConstantesFunciones.IDFORMATORETENCION,strValorActual,strValorNuevo);
			}	
			
			if(cuentabanco.getIsNew()||!cuentabanco.getid_formato_retencion_iva().equals(cuentabanco.getCuentaBancoOriginal().getid_formato_retencion_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentabanco.getCuentaBancoOriginal().getid_formato_retencion_iva()!=null)
				{
					strValorActual=cuentabanco.getCuentaBancoOriginal().getid_formato_retencion_iva().toString();
				}
				if(cuentabanco.getid_formato_retencion_iva()!=null)
				{
					strValorNuevo=cuentabanco.getid_formato_retencion_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaBancoConstantesFunciones.IDFORMATORETENCIONIVA,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveCuentaBancoRelacionesWithConnection(CuentaBanco cuentabanco,List<PagoAuto> pagoautos,List<AutoriPagoOrdenCompra> autoripagoordencompras,List<DetalleChequeGirado> detallechequegirados,List<AutoriPago> autoripagos) throws Exception {

		if(!cuentabanco.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCuentaBancoRelacionesBase(cuentabanco,pagoautos,autoripagoordencompras,detallechequegirados,autoripagos,true);
		}
	}

	public void saveCuentaBancoRelaciones(CuentaBanco cuentabanco,List<PagoAuto> pagoautos,List<AutoriPagoOrdenCompra> autoripagoordencompras,List<DetalleChequeGirado> detallechequegirados,List<AutoriPago> autoripagos)throws Exception {

		if(!cuentabanco.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCuentaBancoRelacionesBase(cuentabanco,pagoautos,autoripagoordencompras,detallechequegirados,autoripagos,false);
		}
	}

	public void saveCuentaBancoRelacionesBase(CuentaBanco cuentabanco,List<PagoAuto> pagoautos,List<AutoriPagoOrdenCompra> autoripagoordencompras,List<DetalleChequeGirado> detallechequegirados,List<AutoriPago> autoripagos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("CuentaBanco-saveRelacionesWithConnection");}
	
			cuentabanco.setPagoAutos(pagoautos);
			cuentabanco.setAutoriPagoOrdenCompras(autoripagoordencompras);
			cuentabanco.setDetalleChequeGirados(detallechequegirados);
			cuentabanco.setAutoriPagos(autoripagos);

			this.setCuentaBanco(cuentabanco);

			if(CuentaBancoLogicAdditional.validarSaveRelaciones(cuentabanco,this)) {

				CuentaBancoLogicAdditional.updateRelacionesToSave(cuentabanco,this);

				if((cuentabanco.getIsNew()||cuentabanco.getIsChanged())&&!cuentabanco.getIsDeleted()) {
					this.saveCuentaBanco();
					this.saveCuentaBancoRelacionesDetalles(pagoautos,autoripagoordencompras,detallechequegirados,autoripagos);

				} else if(cuentabanco.getIsDeleted()) {
					this.saveCuentaBancoRelacionesDetalles(pagoautos,autoripagoordencompras,detallechequegirados,autoripagos);
					this.saveCuentaBanco();
				}

				CuentaBancoLogicAdditional.updateRelacionesToSaveAfter(cuentabanco,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			PagoAutoConstantesFunciones.InicializarGeneralEntityAuxiliaresPagoAutos(pagoautos,true,true);
			AutoriPagoOrdenCompraConstantesFunciones.InicializarGeneralEntityAuxiliaresAutoriPagoOrdenCompras(autoripagoordencompras,true,true);
			DetalleChequeGiradoConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleChequeGirados(detallechequegirados,true,true);
			AutoriPagoConstantesFunciones.InicializarGeneralEntityAuxiliaresAutoriPagos(autoripagos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveCuentaBancoRelacionesDetalles(List<PagoAuto> pagoautos,List<AutoriPagoOrdenCompra> autoripagoordencompras,List<DetalleChequeGirado> detallechequegirados,List<AutoriPago> autoripagos)throws Exception {
		try {
	

			Long idCuentaBancoActual=this.getCuentaBanco().getId();

			PagoAutoLogic pagoautoLogic_Desde_CuentaBanco=new PagoAutoLogic();
			pagoautoLogic_Desde_CuentaBanco.setPagoAutos(pagoautos);

			pagoautoLogic_Desde_CuentaBanco.setConnexion(this.getConnexion());
			pagoautoLogic_Desde_CuentaBanco.setDatosCliente(this.datosCliente);

			for(PagoAuto pagoauto_Desde_CuentaBanco:pagoautoLogic_Desde_CuentaBanco.getPagoAutos()) {
				pagoauto_Desde_CuentaBanco.setid_cuenta_banco(idCuentaBancoActual);
			}

			pagoautoLogic_Desde_CuentaBanco.savePagoAutos();

			AutoriPagoOrdenCompraLogic autoripagoordencompraLogic_Desde_CuentaBanco=new AutoriPagoOrdenCompraLogic();
			autoripagoordencompraLogic_Desde_CuentaBanco.setAutoriPagoOrdenCompras(autoripagoordencompras);

			autoripagoordencompraLogic_Desde_CuentaBanco.setConnexion(this.getConnexion());
			autoripagoordencompraLogic_Desde_CuentaBanco.setDatosCliente(this.datosCliente);

			for(AutoriPagoOrdenCompra autoripagoordencompra_Desde_CuentaBanco:autoripagoordencompraLogic_Desde_CuentaBanco.getAutoriPagoOrdenCompras()) {
				autoripagoordencompra_Desde_CuentaBanco.setid_cuenta_banco(idCuentaBancoActual);
			}

			autoripagoordencompraLogic_Desde_CuentaBanco.saveAutoriPagoOrdenCompras();

			DetalleChequeGiradoLogic detallechequegiradoLogic_Desde_CuentaBanco=new DetalleChequeGiradoLogic();
			detallechequegiradoLogic_Desde_CuentaBanco.setDetalleChequeGirados(detallechequegirados);

			detallechequegiradoLogic_Desde_CuentaBanco.setConnexion(this.getConnexion());
			detallechequegiradoLogic_Desde_CuentaBanco.setDatosCliente(this.datosCliente);

			for(DetalleChequeGirado detallechequegirado_Desde_CuentaBanco:detallechequegiradoLogic_Desde_CuentaBanco.getDetalleChequeGirados()) {
				detallechequegirado_Desde_CuentaBanco.setid_cuenta_banco(idCuentaBancoActual);
			}

			detallechequegiradoLogic_Desde_CuentaBanco.saveDetalleChequeGirados();

			AutoriPagoLogic autoripagoLogic_Desde_CuentaBanco=new AutoriPagoLogic();
			autoripagoLogic_Desde_CuentaBanco.setAutoriPagos(autoripagos);

			autoripagoLogic_Desde_CuentaBanco.setConnexion(this.getConnexion());
			autoripagoLogic_Desde_CuentaBanco.setDatosCliente(this.datosCliente);

			for(AutoriPago autoripago_Desde_CuentaBanco:autoripagoLogic_Desde_CuentaBanco.getAutoriPagos()) {
				autoripago_Desde_CuentaBanco.setid_cuenta_banco(idCuentaBancoActual);
			}

			autoripagoLogic_Desde_CuentaBanco.saveAutoriPagos();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfCuentaBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CuentaBancoConstantesFunciones.getClassesForeignKeysOfCuentaBanco(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCuentaBanco(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CuentaBancoConstantesFunciones.getClassesRelationshipsOfCuentaBanco(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

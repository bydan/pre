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
import com.bydan.erp.contabilidad.util.CuentaContableConstantesFunciones;
import com.bydan.erp.contabilidad.util.CuentaContableParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.CuentaContableParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.CuentaContable;
import com.bydan.erp.contabilidad.business.logic.CuentaContableLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class CuentaContableLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(CuentaContableLogic.class);
	
	protected CuentaContableDataAccess cuentacontableDataAccess; 	
	protected CuentaContable cuentacontable;
	protected List<CuentaContable> cuentacontables;
	protected Object cuentacontableObject;	
	protected List<Object> cuentacontablesObject;
	
	public static ClassValidator<CuentaContable> cuentacontableValidator = new ClassValidator<CuentaContable>(CuentaContable.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected CuentaContableLogicAdditional cuentacontableLogicAdditional=null;
	
	public CuentaContableLogicAdditional getCuentaContableLogicAdditional() {
		return this.cuentacontableLogicAdditional;
	}
	
	public void setCuentaContableLogicAdditional(CuentaContableLogicAdditional cuentacontableLogicAdditional) {
		try {
			this.cuentacontableLogicAdditional=cuentacontableLogicAdditional;
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
	
	
	
	
	public  CuentaContableLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.cuentacontableDataAccess = new CuentaContableDataAccess();
			
			this.cuentacontables= new ArrayList<CuentaContable>();
			this.cuentacontable= new CuentaContable();
			
			this.cuentacontableObject=new Object();
			this.cuentacontablesObject=new ArrayList<Object>();
				
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
			
			this.cuentacontableDataAccess.setConnexionType(this.connexionType);
			this.cuentacontableDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CuentaContableLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.cuentacontableDataAccess = new CuentaContableDataAccess();
			this.cuentacontables= new ArrayList<CuentaContable>();
			this.cuentacontable= new CuentaContable();
			this.cuentacontableObject=new Object();
			this.cuentacontablesObject=new ArrayList<Object>();
			
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
			
			this.cuentacontableDataAccess.setConnexionType(this.connexionType);
			this.cuentacontableDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CuentaContable getCuentaContable() throws Exception {	
		CuentaContableLogicAdditional.checkCuentaContableToGet(cuentacontable,this.datosCliente,this.arrDatoGeneral);
		CuentaContableLogicAdditional.updateCuentaContableToGet(cuentacontable,this.arrDatoGeneral);
		
		return cuentacontable;
	}
		
	public void setCuentaContable(CuentaContable newCuentaContable) {
		this.cuentacontable = newCuentaContable;
	}
	
	public CuentaContableDataAccess getCuentaContableDataAccess() {
		return cuentacontableDataAccess;
	}
	
	public void setCuentaContableDataAccess(CuentaContableDataAccess newcuentacontableDataAccess) {
		this.cuentacontableDataAccess = newcuentacontableDataAccess;
	}
	
	public List<CuentaContable> getCuentaContables() throws Exception {		
		this.quitarCuentaContablesNulos();
		
		CuentaContableLogicAdditional.checkCuentaContableToGets(cuentacontables,this.datosCliente,this.arrDatoGeneral);
		
		for (CuentaContable cuentacontableLocal: cuentacontables ) {
			CuentaContableLogicAdditional.updateCuentaContableToGet(cuentacontableLocal,this.arrDatoGeneral);
		}
		
		return cuentacontables;
	}
	
	public void setCuentaContables(List<CuentaContable> newCuentaContables) {
		this.cuentacontables = newCuentaContables;
	}
	
	public Object getCuentaContableObject() {	
		this.cuentacontableObject=this.cuentacontableDataAccess.getEntityObject();
		return this.cuentacontableObject;
	}
		
	public void setCuentaContableObject(Object newCuentaContableObject) {
		this.cuentacontableObject = newCuentaContableObject;
	}
	
	public List<Object> getCuentaContablesObject() {		
		this.cuentacontablesObject=this.cuentacontableDataAccess.getEntitiesObject();
		return this.cuentacontablesObject;
	}
		
	public void setCuentaContablesObject(List<Object> newCuentaContablesObject) {
		this.cuentacontablesObject = newCuentaContablesObject;
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
		
		if(this.cuentacontableDataAccess!=null) {
			this.cuentacontableDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContable.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			cuentacontableDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			cuentacontableDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		cuentacontable = new  CuentaContable();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContable.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cuentacontable=cuentacontableDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuentacontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontable);
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
		cuentacontable = new  CuentaContable();
		  		  
        try {
			
			cuentacontable=cuentacontableDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuentacontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		cuentacontable = new  CuentaContable();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContable.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cuentacontable=cuentacontableDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuentacontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontable);
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
		cuentacontable = new  CuentaContable();
		  		  
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
		cuentacontable = new  CuentaContable();
		  		  
        try {
			
			cuentacontable=cuentacontableDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuentacontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		cuentacontable = new  CuentaContable();
		  		  
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
		cuentacontable = new  CuentaContable();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContable.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =cuentacontableDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cuentacontable = new  CuentaContable();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=cuentacontableDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cuentacontable = new  CuentaContable();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContable.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =cuentacontableDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cuentacontable = new  CuentaContable();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=cuentacontableDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cuentacontable = new  CuentaContable();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContable.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =cuentacontableDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cuentacontable = new  CuentaContable();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=cuentacontableDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cuentacontables = new  ArrayList<CuentaContable>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContable.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			CuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontables=cuentacontableDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaContable(cuentacontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontables);
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
		cuentacontables = new  ArrayList<CuentaContable>();
		  		  
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
		cuentacontables = new  ArrayList<CuentaContable>();
		  		  
        try {			
			CuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontables=cuentacontableDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarCuentaContable(cuentacontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontables);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		cuentacontables = new  ArrayList<CuentaContable>();
		  		  
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
		cuentacontables = new  ArrayList<CuentaContable>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContable.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			CuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontables=cuentacontableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaContable(cuentacontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontables);
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
		cuentacontables = new  ArrayList<CuentaContable>();
		  		  
        try {
			CuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontables=cuentacontableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaContable(cuentacontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontables);
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
		cuentacontables = new  ArrayList<CuentaContable>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContable.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontables=cuentacontableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuentaContable(cuentacontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontables);
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
		cuentacontables = new  ArrayList<CuentaContable>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontables=cuentacontableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuentaContable(cuentacontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontables);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		cuentacontable = new  CuentaContable();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContable.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontable=cuentacontableDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuentaContable(cuentacontable);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontable);
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
		cuentacontable = new  CuentaContable();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontable=cuentacontableDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuentaContable(cuentacontable);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cuentacontables = new  ArrayList<CuentaContable>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContable.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			CuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontables=cuentacontableDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaContable(cuentacontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontables);
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
		cuentacontables = new  ArrayList<CuentaContable>();
		  		  
        try {
			CuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontables=cuentacontableDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaContable(cuentacontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontables);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosCuentaContablesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		cuentacontables = new  ArrayList<CuentaContable>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContable.class.getSimpleName()+"-getTodosCuentaContablesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontables=cuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCuentaContable(cuentacontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontables);
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
	
	public  void  getTodosCuentaContables(String sFinalQuery,Pagination pagination)throws Exception {
		cuentacontables = new  ArrayList<CuentaContable>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacontables=cuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCuentaContable(cuentacontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontables);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarCuentaContable(CuentaContable cuentacontable) throws Exception {
		Boolean estaValidado=false;
		
		if(cuentacontable.getIsNew() || cuentacontable.getIsChanged()) { 
			this.invalidValues = cuentacontableValidator.getInvalidValues(cuentacontable);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(cuentacontable);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarCuentaContable(List<CuentaContable> CuentaContables) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(CuentaContable cuentacontableLocal:cuentacontables) {				
			estaValidadoObjeto=this.validarGuardarCuentaContable(cuentacontableLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarCuentaContable(List<CuentaContable> CuentaContables) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCuentaContable(cuentacontables)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarCuentaContable(CuentaContable CuentaContable) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCuentaContable(cuentacontable)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(CuentaContable cuentacontable) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+cuentacontable.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=CuentaContableConstantesFunciones.getCuentaContableLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"cuentacontable","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(CuentaContableConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(CuentaContableConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveCuentaContableWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContable.class.getSimpleName()+"-saveCuentaContableWithConnection");connexion.begin();			
			
			CuentaContableLogicAdditional.checkCuentaContableToSave(this.cuentacontable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CuentaContableLogicAdditional.updateCuentaContableToSave(this.cuentacontable,this.arrDatoGeneral);
			
			CuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cuentacontable,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowCuentaContable();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCuentaContable(this.cuentacontable)) {
				CuentaContableDataAccess.save(this.cuentacontable, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.cuentacontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CuentaContableLogicAdditional.checkCuentaContableToSaveAfter(this.cuentacontable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCuentaContable();
			
			connexion.commit();			
			
			if(this.cuentacontable.getIsDeleted()) {
				this.cuentacontable=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveCuentaContable()throws Exception {	
		try {	
			
			CuentaContableLogicAdditional.checkCuentaContableToSave(this.cuentacontable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CuentaContableLogicAdditional.updateCuentaContableToSave(this.cuentacontable,this.arrDatoGeneral);
			
			CuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cuentacontable,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCuentaContable(this.cuentacontable)) {			
				CuentaContableDataAccess.save(this.cuentacontable, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.cuentacontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CuentaContableLogicAdditional.checkCuentaContableToSaveAfter(this.cuentacontable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.cuentacontable.getIsDeleted()) {
				this.cuentacontable=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveCuentaContablesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContable.class.getSimpleName()+"-saveCuentaContablesWithConnection");connexion.begin();			
			
			CuentaContableLogicAdditional.checkCuentaContableToSaves(cuentacontables,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowCuentaContables();
			
			Boolean validadoTodosCuentaContable=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CuentaContable cuentacontableLocal:cuentacontables) {		
				if(cuentacontableLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CuentaContableLogicAdditional.updateCuentaContableToSave(cuentacontableLocal,this.arrDatoGeneral);
	        	
				CuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cuentacontableLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCuentaContable(cuentacontableLocal)) {
					CuentaContableDataAccess.save(cuentacontableLocal, connexion);				
				} else {
					validadoTodosCuentaContable=false;
				}
			}
			
			if(!validadoTodosCuentaContable) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CuentaContableLogicAdditional.checkCuentaContableToSavesAfter(cuentacontables,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCuentaContables();
			
			connexion.commit();		
			
			this.quitarCuentaContablesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveCuentaContables()throws Exception {				
		 try {	
			CuentaContableLogicAdditional.checkCuentaContableToSaves(cuentacontables,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosCuentaContable=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CuentaContable cuentacontableLocal:cuentacontables) {				
				if(cuentacontableLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CuentaContableLogicAdditional.updateCuentaContableToSave(cuentacontableLocal,this.arrDatoGeneral);
	        	
				CuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cuentacontableLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCuentaContable(cuentacontableLocal)) {				
					CuentaContableDataAccess.save(cuentacontableLocal, connexion);				
				} else {
					validadoTodosCuentaContable=false;
				}
			}
			
			if(!validadoTodosCuentaContable) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CuentaContableLogicAdditional.checkCuentaContableToSavesAfter(cuentacontables,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarCuentaContablesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CuentaContableParameterReturnGeneral procesarAccionCuentaContables(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CuentaContable> cuentacontables,CuentaContableParameterReturnGeneral cuentacontableParameterGeneral)throws Exception {
		 try {	
			CuentaContableParameterReturnGeneral cuentacontableReturnGeneral=new CuentaContableParameterReturnGeneral();
	
			CuentaContableLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cuentacontables,cuentacontableParameterGeneral,cuentacontableReturnGeneral);
			
			return cuentacontableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CuentaContableParameterReturnGeneral procesarAccionCuentaContablesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CuentaContable> cuentacontables,CuentaContableParameterReturnGeneral cuentacontableParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContable.class.getSimpleName()+"-procesarAccionCuentaContablesWithConnection");connexion.begin();			
			
			CuentaContableParameterReturnGeneral cuentacontableReturnGeneral=new CuentaContableParameterReturnGeneral();
	
			CuentaContableLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cuentacontables,cuentacontableParameterGeneral,cuentacontableReturnGeneral);
			
			this.connexion.commit();
			
			return cuentacontableReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CuentaContableParameterReturnGeneral procesarEventosCuentaContables(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CuentaContable> cuentacontables,CuentaContable cuentacontable,CuentaContableParameterReturnGeneral cuentacontableParameterGeneral,Boolean isEsNuevoCuentaContable,ArrayList<Classe> clases)throws Exception {
		 try {	
			CuentaContableParameterReturnGeneral cuentacontableReturnGeneral=new CuentaContableParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cuentacontableReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CuentaContableLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cuentacontables,cuentacontable,cuentacontableParameterGeneral,cuentacontableReturnGeneral,isEsNuevoCuentaContable,clases);
			
			return cuentacontableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public CuentaContableParameterReturnGeneral procesarEventosCuentaContablesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CuentaContable> cuentacontables,CuentaContable cuentacontable,CuentaContableParameterReturnGeneral cuentacontableParameterGeneral,Boolean isEsNuevoCuentaContable,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContable.class.getSimpleName()+"-procesarEventosCuentaContablesWithConnection");connexion.begin();			
			
			CuentaContableParameterReturnGeneral cuentacontableReturnGeneral=new CuentaContableParameterReturnGeneral();
	
			cuentacontableReturnGeneral.setCuentaContable(cuentacontable);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cuentacontableReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CuentaContableLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cuentacontables,cuentacontable,cuentacontableParameterGeneral,cuentacontableReturnGeneral,isEsNuevoCuentaContable,clases);
			
			this.connexion.commit();
			
			return cuentacontableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CuentaContableParameterReturnGeneral procesarImportacionCuentaContablesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,CuentaContableParameterReturnGeneral cuentacontableParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContable.class.getSimpleName()+"-procesarImportacionCuentaContablesWithConnection");connexion.begin();			
			
			CuentaContableParameterReturnGeneral cuentacontableReturnGeneral=new CuentaContableParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.cuentacontables=new ArrayList<CuentaContable>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.cuentacontable=new CuentaContable();
				
				
				if(conColumnasBase) {this.cuentacontable.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.cuentacontable.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.cuentacontable.setcodigo(arrColumnas[iColumn++]);
				this.cuentacontable.setnombre(arrColumnas[iColumn++]);
				this.cuentacontable.setcodigo_extranjero(arrColumnas[iColumn++]);
				this.cuentacontable.setnombre_extranjero(arrColumnas[iColumn++]);
			this.cuentacontable.setdescripcion(arrColumnas[iColumn++]);
				this.cuentacontable.setes_movimiento(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.cuentacontable.setes_centro_costo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.cuentacontable.setes_centro_actividad(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.cuentacontable.setes_activo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.cuentacontable.setes_relacion(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.cuentacontable.setes_para_f52(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.cuentacontable.setorden(Integer.parseInt(arrColumnas[iColumn++]));
				
				this.cuentacontables.add(this.cuentacontable);
			}
			
			this.saveCuentaContables();
			
			this.connexion.commit();
			
			cuentacontableReturnGeneral.setConRetornoEstaProcesado(true);
			cuentacontableReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return cuentacontableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarCuentaContablesEliminados() throws Exception {				
		
		List<CuentaContable> cuentacontablesAux= new ArrayList<CuentaContable>();
		
		for(CuentaContable cuentacontable:cuentacontables) {
			if(!cuentacontable.getIsDeleted()) {
				cuentacontablesAux.add(cuentacontable);
			}
		}
		
		cuentacontables=cuentacontablesAux;
	}
	
	public void quitarCuentaContablesNulos() throws Exception {				
		
		List<CuentaContable> cuentacontablesAux= new ArrayList<CuentaContable>();
		
		for(CuentaContable cuentacontable : this.cuentacontables) {
			if(cuentacontable==null) {
				cuentacontablesAux.add(cuentacontable);
			}
		}
		
		//this.cuentacontables=cuentacontablesAux;
		
		this.cuentacontables.removeAll(cuentacontablesAux);
	}
	
	public void getSetVersionRowCuentaContableWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(cuentacontable.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((cuentacontable.getIsDeleted() || (cuentacontable.getIsChanged()&&!cuentacontable.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=cuentacontableDataAccess.getSetVersionRowCuentaContable(connexion,cuentacontable.getId());
				
				if(!cuentacontable.getVersionRow().equals(timestamp)) {	
					cuentacontable.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				cuentacontable.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowCuentaContable()throws Exception {	
		
		if(cuentacontable.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((cuentacontable.getIsDeleted() || (cuentacontable.getIsChanged()&&!cuentacontable.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=cuentacontableDataAccess.getSetVersionRowCuentaContable(connexion,cuentacontable.getId());
			
			try {							
				if(!cuentacontable.getVersionRow().equals(timestamp)) {	
					cuentacontable.setVersionRow(timestamp);
				}
				
				cuentacontable.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowCuentaContablesWithConnection()throws Exception {	
		if(cuentacontables!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(CuentaContable cuentacontableAux:cuentacontables) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(cuentacontableAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cuentacontableAux.getIsDeleted() || (cuentacontableAux.getIsChanged()&&!cuentacontableAux.getIsNew())) {
						
						timestamp=cuentacontableDataAccess.getSetVersionRowCuentaContable(connexion,cuentacontableAux.getId());
						
						if(!cuentacontable.getVersionRow().equals(timestamp)) {	
							cuentacontableAux.setVersionRow(timestamp);
						}
								
						cuentacontableAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowCuentaContables()throws Exception {	
		if(cuentacontables!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(CuentaContable cuentacontableAux:cuentacontables) {
					if(cuentacontableAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cuentacontableAux.getIsDeleted() || (cuentacontableAux.getIsChanged()&&!cuentacontableAux.getIsNew())) {
						
						timestamp=cuentacontableDataAccess.getSetVersionRowCuentaContable(connexion,cuentacontableAux.getId());
						
						if(!cuentacontableAux.getVersionRow().equals(timestamp)) {	
							cuentacontableAux.setVersionRow(timestamp);
						}
						
													
						cuentacontableAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public CuentaContableParameterReturnGeneral cargarCombosLoteForeignKeyCuentaContableWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalNivelCuenta,String finalQueryGlobalCuentaContable,String finalQueryGlobalCentroCosto,String finalQueryGlobalModulo,String finalQueryGlobalMoneda,String finalQueryGlobalTipoIntervalo,String finalQueryGlobalTipoFlujoEfectivo,String finalQueryGlobalCuentaContableDebito,String finalQueryGlobalCuentaContableCredito) throws Exception {
		CuentaContableParameterReturnGeneral  cuentacontableReturnGeneral =new CuentaContableParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContable.class.getSimpleName()+"-cargarCombosLoteForeignKeyCuentaContableWithConnection");connexion.begin();
			
			cuentacontableReturnGeneral =new CuentaContableParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cuentacontableReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<NivelCuenta> nivelcuentasForeignKey=new ArrayList<NivelCuenta>();
			NivelCuentaLogic nivelcuentaLogic=new NivelCuentaLogic();
			nivelcuentaLogic.setConnexion(this.connexion);
			nivelcuentaLogic.getNivelCuentaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalNivelCuenta.equals("NONE")) {
				nivelcuentaLogic.getTodosNivelCuentas(finalQueryGlobalNivelCuenta,new Pagination());
				nivelcuentasForeignKey=nivelcuentaLogic.getNivelCuentas();
			}

			cuentacontableReturnGeneral.setnivelcuentasForeignKey(nivelcuentasForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			cuentacontableReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			cuentacontableReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			cuentacontableReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			cuentacontableReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<TipoIntervalo> tipointervalosForeignKey=new ArrayList<TipoIntervalo>();
			TipoIntervaloLogic tipointervaloLogic=new TipoIntervaloLogic();
			tipointervaloLogic.setConnexion(this.connexion);
			tipointervaloLogic.getTipoIntervaloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoIntervalo.equals("NONE")) {
				tipointervaloLogic.getTodosTipoIntervalos(finalQueryGlobalTipoIntervalo,new Pagination());
				tipointervalosForeignKey=tipointervaloLogic.getTipoIntervalos();
			}

			cuentacontableReturnGeneral.settipointervalosForeignKey(tipointervalosForeignKey);


			List<TipoFlujoEfectivo> tipoflujoefectivosForeignKey=new ArrayList<TipoFlujoEfectivo>();
			TipoFlujoEfectivoLogic tipoflujoefectivoLogic=new TipoFlujoEfectivoLogic();
			tipoflujoefectivoLogic.setConnexion(this.connexion);
			tipoflujoefectivoLogic.getTipoFlujoEfectivoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoFlujoEfectivo.equals("NONE")) {
				tipoflujoefectivoLogic.getTodosTipoFlujoEfectivos(finalQueryGlobalTipoFlujoEfectivo,new Pagination());
				tipoflujoefectivosForeignKey=tipoflujoefectivoLogic.getTipoFlujoEfectivos();
			}

			cuentacontableReturnGeneral.settipoflujoefectivosForeignKey(tipoflujoefectivosForeignKey);


			List<CuentaContable> cuentacontabledebitosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledebitoLogic=new CuentaContableLogic();
			cuentacontabledebitoLogic.setConnexion(this.connexion);
			cuentacontabledebitoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDebito.equals("NONE")) {
				cuentacontabledebitoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDebito,new Pagination());
				cuentacontabledebitosForeignKey=cuentacontabledebitoLogic.getCuentaContables();
			}

			cuentacontableReturnGeneral.setcuentacontabledebitosForeignKey(cuentacontabledebitosForeignKey);


			List<CuentaContable> cuentacontablecreditosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditoLogic=new CuentaContableLogic();
			cuentacontablecreditoLogic.setConnexion(this.connexion);
			cuentacontablecreditoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCredito.equals("NONE")) {
				cuentacontablecreditoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCredito,new Pagination());
				cuentacontablecreditosForeignKey=cuentacontablecreditoLogic.getCuentaContables();
			}

			cuentacontableReturnGeneral.setcuentacontablecreditosForeignKey(cuentacontablecreditosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return cuentacontableReturnGeneral;
	}
	
	public CuentaContableParameterReturnGeneral cargarCombosLoteForeignKeyCuentaContable(String finalQueryGlobalEmpresa,String finalQueryGlobalNivelCuenta,String finalQueryGlobalCuentaContable,String finalQueryGlobalCentroCosto,String finalQueryGlobalModulo,String finalQueryGlobalMoneda,String finalQueryGlobalTipoIntervalo,String finalQueryGlobalTipoFlujoEfectivo,String finalQueryGlobalCuentaContableDebito,String finalQueryGlobalCuentaContableCredito) throws Exception {
		CuentaContableParameterReturnGeneral  cuentacontableReturnGeneral =new CuentaContableParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			cuentacontableReturnGeneral =new CuentaContableParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cuentacontableReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<NivelCuenta> nivelcuentasForeignKey=new ArrayList<NivelCuenta>();
			NivelCuentaLogic nivelcuentaLogic=new NivelCuentaLogic();
			nivelcuentaLogic.setConnexion(this.connexion);
			nivelcuentaLogic.getNivelCuentaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalNivelCuenta.equals("NONE")) {
				nivelcuentaLogic.getTodosNivelCuentas(finalQueryGlobalNivelCuenta,new Pagination());
				nivelcuentasForeignKey=nivelcuentaLogic.getNivelCuentas();
			}

			cuentacontableReturnGeneral.setnivelcuentasForeignKey(nivelcuentasForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			cuentacontableReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			cuentacontableReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			cuentacontableReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<Moneda> monedasForeignKey=new ArrayList<Moneda>();
			MonedaLogic monedaLogic=new MonedaLogic();
			monedaLogic.setConnexion(this.connexion);
			//monedaLogic.getMonedaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMoneda.equals("NONE")) {
				monedaLogic.getTodosMonedas(finalQueryGlobalMoneda,new Pagination());
				monedasForeignKey=monedaLogic.getMonedas();
			}

			cuentacontableReturnGeneral.setmonedasForeignKey(monedasForeignKey);


			List<TipoIntervalo> tipointervalosForeignKey=new ArrayList<TipoIntervalo>();
			TipoIntervaloLogic tipointervaloLogic=new TipoIntervaloLogic();
			tipointervaloLogic.setConnexion(this.connexion);
			tipointervaloLogic.getTipoIntervaloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoIntervalo.equals("NONE")) {
				tipointervaloLogic.getTodosTipoIntervalos(finalQueryGlobalTipoIntervalo,new Pagination());
				tipointervalosForeignKey=tipointervaloLogic.getTipoIntervalos();
			}

			cuentacontableReturnGeneral.settipointervalosForeignKey(tipointervalosForeignKey);


			List<TipoFlujoEfectivo> tipoflujoefectivosForeignKey=new ArrayList<TipoFlujoEfectivo>();
			TipoFlujoEfectivoLogic tipoflujoefectivoLogic=new TipoFlujoEfectivoLogic();
			tipoflujoefectivoLogic.setConnexion(this.connexion);
			tipoflujoefectivoLogic.getTipoFlujoEfectivoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoFlujoEfectivo.equals("NONE")) {
				tipoflujoefectivoLogic.getTodosTipoFlujoEfectivos(finalQueryGlobalTipoFlujoEfectivo,new Pagination());
				tipoflujoefectivosForeignKey=tipoflujoefectivoLogic.getTipoFlujoEfectivos();
			}

			cuentacontableReturnGeneral.settipoflujoefectivosForeignKey(tipoflujoefectivosForeignKey);


			List<CuentaContable> cuentacontabledebitosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontabledebitoLogic=new CuentaContableLogic();
			cuentacontabledebitoLogic.setConnexion(this.connexion);
			cuentacontabledebitoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableDebito.equals("NONE")) {
				cuentacontabledebitoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableDebito,new Pagination());
				cuentacontabledebitosForeignKey=cuentacontabledebitoLogic.getCuentaContables();
			}

			cuentacontableReturnGeneral.setcuentacontabledebitosForeignKey(cuentacontabledebitosForeignKey);


			List<CuentaContable> cuentacontablecreditosForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablecreditoLogic=new CuentaContableLogic();
			cuentacontablecreditoLogic.setConnexion(this.connexion);
			cuentacontablecreditoLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableCredito.equals("NONE")) {
				cuentacontablecreditoLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableCredito,new Pagination());
				cuentacontablecreditosForeignKey=cuentacontablecreditoLogic.getCuentaContables();
			}

			cuentacontableReturnGeneral.setcuentacontablecreditosForeignKey(cuentacontablecreditosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return cuentacontableReturnGeneral;
	}
	
	
	public void deepLoad(CuentaContable cuentacontable,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CuentaContableLogicAdditional.updateCuentaContableToGet(cuentacontable,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cuentacontable.setEmpresa(cuentacontableDataAccess.getEmpresa(connexion,cuentacontable));
		cuentacontable.setNivelCuenta(cuentacontableDataAccess.getNivelCuenta(connexion,cuentacontable));
		cuentacontable.setCuentaContable(cuentacontableDataAccess.getCuentaContable(connexion,cuentacontable));
		cuentacontable.setCentroCosto(cuentacontableDataAccess.getCentroCosto(connexion,cuentacontable));
		cuentacontable.setModulo(cuentacontableDataAccess.getModulo(connexion,cuentacontable));
		cuentacontable.setMoneda(cuentacontableDataAccess.getMoneda(connexion,cuentacontable));
		cuentacontable.setTipoIntervalo(cuentacontableDataAccess.getTipoIntervalo(connexion,cuentacontable));
		cuentacontable.setTipoFlujoEfectivo(cuentacontableDataAccess.getTipoFlujoEfectivo(connexion,cuentacontable));
		cuentacontable.setCuentaContableDebito(cuentacontableDataAccess.getCuentaContableDebito(connexion,cuentacontable));
		cuentacontable.setCuentaContableCredito(cuentacontableDataAccess.getCuentaContableCredito(connexion,cuentacontable));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cuentacontable.setEmpresa(cuentacontableDataAccess.getEmpresa(connexion,cuentacontable));
				continue;
			}

			if(clas.clas.equals(NivelCuenta.class)) {
				cuentacontable.setNivelCuenta(cuentacontableDataAccess.getNivelCuenta(connexion,cuentacontable));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentacontable.setCuentaContable(cuentacontableDataAccess.getCuentaContable(connexion,cuentacontable));
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				cuentacontable.setCentroCosto(cuentacontableDataAccess.getCentroCosto(connexion,cuentacontable));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				cuentacontable.setModulo(cuentacontableDataAccess.getModulo(connexion,cuentacontable));
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				cuentacontable.setMoneda(cuentacontableDataAccess.getMoneda(connexion,cuentacontable));
				continue;
			}

			if(clas.clas.equals(TipoIntervalo.class)) {
				cuentacontable.setTipoIntervalo(cuentacontableDataAccess.getTipoIntervalo(connexion,cuentacontable));
				continue;
			}

			if(clas.clas.equals(TipoFlujoEfectivo.class)) {
				cuentacontable.setTipoFlujoEfectivo(cuentacontableDataAccess.getTipoFlujoEfectivo(connexion,cuentacontable));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentacontable.setCuentaContableDebito(cuentacontableDataAccess.getCuentaContableDebito(connexion,cuentacontable));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentacontable.setCuentaContableCredito(cuentacontableDataAccess.getCuentaContableCredito(connexion,cuentacontable));
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
			cuentacontable.setEmpresa(cuentacontableDataAccess.getEmpresa(connexion,cuentacontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(NivelCuenta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentacontable.setNivelCuenta(cuentacontableDataAccess.getNivelCuenta(connexion,cuentacontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentacontable.setCuentaContable(cuentacontableDataAccess.getCuentaContable(connexion,cuentacontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentacontable.setCentroCosto(cuentacontableDataAccess.getCentroCosto(connexion,cuentacontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentacontable.setModulo(cuentacontableDataAccess.getModulo(connexion,cuentacontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentacontable.setMoneda(cuentacontableDataAccess.getMoneda(connexion,cuentacontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIntervalo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentacontable.setTipoIntervalo(cuentacontableDataAccess.getTipoIntervalo(connexion,cuentacontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFlujoEfectivo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentacontable.setTipoFlujoEfectivo(cuentacontableDataAccess.getTipoFlujoEfectivo(connexion,cuentacontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentacontable.setCuentaContableDebito(cuentacontableDataAccess.getCuentaContableDebito(connexion,cuentacontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentacontable.setCuentaContableCredito(cuentacontableDataAccess.getCuentaContableCredito(connexion,cuentacontable));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cuentacontable.setEmpresa(cuentacontableDataAccess.getEmpresa(connexion,cuentacontable));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cuentacontable.getEmpresa(),isDeep,deepLoadType,clases);
				
		cuentacontable.setNivelCuenta(cuentacontableDataAccess.getNivelCuenta(connexion,cuentacontable));
		NivelCuentaLogic nivelcuentaLogic= new NivelCuentaLogic(connexion);
		nivelcuentaLogic.deepLoad(cuentacontable.getNivelCuenta(),isDeep,deepLoadType,clases);
				
		cuentacontable.setCuentaContable(cuentacontableDataAccess.getCuentaContable(connexion,cuentacontable));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(cuentacontable.getCuentaContable(),isDeep,deepLoadType,clases);
				
		cuentacontable.setCentroCosto(cuentacontableDataAccess.getCentroCosto(connexion,cuentacontable));
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(cuentacontable.getCentroCosto(),isDeep,deepLoadType,clases);
				
		cuentacontable.setModulo(cuentacontableDataAccess.getModulo(connexion,cuentacontable));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(cuentacontable.getModulo(),isDeep,deepLoadType,clases);
				
		cuentacontable.setMoneda(cuentacontableDataAccess.getMoneda(connexion,cuentacontable));
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(cuentacontable.getMoneda(),isDeep,deepLoadType,clases);
				
		cuentacontable.setTipoIntervalo(cuentacontableDataAccess.getTipoIntervalo(connexion,cuentacontable));
		TipoIntervaloLogic tipointervaloLogic= new TipoIntervaloLogic(connexion);
		tipointervaloLogic.deepLoad(cuentacontable.getTipoIntervalo(),isDeep,deepLoadType,clases);
				
		cuentacontable.setTipoFlujoEfectivo(cuentacontableDataAccess.getTipoFlujoEfectivo(connexion,cuentacontable));
		TipoFlujoEfectivoLogic tipoflujoefectivoLogic= new TipoFlujoEfectivoLogic(connexion);
		tipoflujoefectivoLogic.deepLoad(cuentacontable.getTipoFlujoEfectivo(),isDeep,deepLoadType,clases);
				
		cuentacontable.setCuentaContableDebito(cuentacontableDataAccess.getCuentaContableDebito(connexion,cuentacontable));
		CuentaContableLogic cuentacontabledebitoLogic= new CuentaContableLogic(connexion);
		cuentacontabledebitoLogic.deepLoad(cuentacontable.getCuentaContableDebito(),isDeep,deepLoadType,clases);
				
		cuentacontable.setCuentaContableCredito(cuentacontableDataAccess.getCuentaContableCredito(connexion,cuentacontable));
		CuentaContableLogic cuentacontablecreditoLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditoLogic.deepLoad(cuentacontable.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cuentacontable.setEmpresa(cuentacontableDataAccess.getEmpresa(connexion,cuentacontable));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(cuentacontable.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(NivelCuenta.class)) {
				cuentacontable.setNivelCuenta(cuentacontableDataAccess.getNivelCuenta(connexion,cuentacontable));
				NivelCuentaLogic nivelcuentaLogic= new NivelCuentaLogic(connexion);
				nivelcuentaLogic.deepLoad(cuentacontable.getNivelCuenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentacontable.setCuentaContable(cuentacontableDataAccess.getCuentaContable(connexion,cuentacontable));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(cuentacontable.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				cuentacontable.setCentroCosto(cuentacontableDataAccess.getCentroCosto(connexion,cuentacontable));
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepLoad(cuentacontable.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				cuentacontable.setModulo(cuentacontableDataAccess.getModulo(connexion,cuentacontable));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(cuentacontable.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				cuentacontable.setMoneda(cuentacontableDataAccess.getMoneda(connexion,cuentacontable));
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepLoad(cuentacontable.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoIntervalo.class)) {
				cuentacontable.setTipoIntervalo(cuentacontableDataAccess.getTipoIntervalo(connexion,cuentacontable));
				TipoIntervaloLogic tipointervaloLogic= new TipoIntervaloLogic(connexion);
				tipointervaloLogic.deepLoad(cuentacontable.getTipoIntervalo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoFlujoEfectivo.class)) {
				cuentacontable.setTipoFlujoEfectivo(cuentacontableDataAccess.getTipoFlujoEfectivo(connexion,cuentacontable));
				TipoFlujoEfectivoLogic tipoflujoefectivoLogic= new TipoFlujoEfectivoLogic(connexion);
				tipoflujoefectivoLogic.deepLoad(cuentacontable.getTipoFlujoEfectivo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentacontable.setCuentaContableDebito(cuentacontableDataAccess.getCuentaContableDebito(connexion,cuentacontable));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(cuentacontable.getCuentaContableDebito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentacontable.setCuentaContableCredito(cuentacontableDataAccess.getCuentaContableCredito(connexion,cuentacontable));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(cuentacontable.getCuentaContableCredito(),isDeep,deepLoadType,clases);				
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
			cuentacontable.setEmpresa(cuentacontableDataAccess.getEmpresa(connexion,cuentacontable));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(cuentacontable.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(NivelCuenta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentacontable.setNivelCuenta(cuentacontableDataAccess.getNivelCuenta(connexion,cuentacontable));
			NivelCuentaLogic nivelcuentaLogic= new NivelCuentaLogic(connexion);
			nivelcuentaLogic.deepLoad(cuentacontable.getNivelCuenta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentacontable.setCuentaContable(cuentacontableDataAccess.getCuentaContable(connexion,cuentacontable));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(cuentacontable.getCuentaContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentacontable.setCentroCosto(cuentacontableDataAccess.getCentroCosto(connexion,cuentacontable));
			CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
			centrocostoLogic.deepLoad(cuentacontable.getCentroCosto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentacontable.setModulo(cuentacontableDataAccess.getModulo(connexion,cuentacontable));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(cuentacontable.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Moneda.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentacontable.setMoneda(cuentacontableDataAccess.getMoneda(connexion,cuentacontable));
			MonedaLogic monedaLogic= new MonedaLogic(connexion);
			monedaLogic.deepLoad(cuentacontable.getMoneda(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIntervalo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentacontable.setTipoIntervalo(cuentacontableDataAccess.getTipoIntervalo(connexion,cuentacontable));
			TipoIntervaloLogic tipointervaloLogic= new TipoIntervaloLogic(connexion);
			tipointervaloLogic.deepLoad(cuentacontable.getTipoIntervalo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFlujoEfectivo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentacontable.setTipoFlujoEfectivo(cuentacontableDataAccess.getTipoFlujoEfectivo(connexion,cuentacontable));
			TipoFlujoEfectivoLogic tipoflujoefectivoLogic= new TipoFlujoEfectivoLogic(connexion);
			tipoflujoefectivoLogic.deepLoad(cuentacontable.getTipoFlujoEfectivo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentacontable.setCuentaContableDebito(cuentacontableDataAccess.getCuentaContableDebito(connexion,cuentacontable));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(cuentacontable.getCuentaContableDebito(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentacontable.setCuentaContableCredito(cuentacontableDataAccess.getCuentaContableCredito(connexion,cuentacontable));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(cuentacontable.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(CuentaContable cuentacontable,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			CuentaContableLogicAdditional.updateCuentaContableToSave(cuentacontable,this.arrDatoGeneral);
			
CuentaContableDataAccess.save(cuentacontable, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(cuentacontable.getEmpresa(),connexion);

		NivelCuentaDataAccess.save(cuentacontable.getNivelCuenta(),connexion);

		CuentaContableDataAccess.save(cuentacontable.getCuentaContable(),connexion);

		CentroCostoDataAccess.save(cuentacontable.getCentroCosto(),connexion);

		ModuloDataAccess.save(cuentacontable.getModulo(),connexion);

		MonedaDataAccess.save(cuentacontable.getMoneda(),connexion);

		TipoIntervaloDataAccess.save(cuentacontable.getTipoIntervalo(),connexion);

		TipoFlujoEfectivoDataAccess.save(cuentacontable.getTipoFlujoEfectivo(),connexion);

		CuentaContableDataAccess.save(cuentacontable.getCuentaContableDebito(),connexion);

		CuentaContableDataAccess.save(cuentacontable.getCuentaContableCredito(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cuentacontable.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(NivelCuenta.class)) {
				NivelCuentaDataAccess.save(cuentacontable.getNivelCuenta(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentacontable.getCuentaContable(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(cuentacontable.getCentroCosto(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(cuentacontable.getModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(cuentacontable.getMoneda(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoIntervalo.class)) {
				TipoIntervaloDataAccess.save(cuentacontable.getTipoIntervalo(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoFlujoEfectivo.class)) {
				TipoFlujoEfectivoDataAccess.save(cuentacontable.getTipoFlujoEfectivo(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentacontable.getCuentaContableDebito(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentacontable.getCuentaContableCredito(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(cuentacontable.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cuentacontable.getEmpresa(),isDeep,deepLoadType,clases);
				

		NivelCuentaDataAccess.save(cuentacontable.getNivelCuenta(),connexion);
		NivelCuentaLogic nivelcuentaLogic= new NivelCuentaLogic(connexion);
		nivelcuentaLogic.deepLoad(cuentacontable.getNivelCuenta(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(cuentacontable.getCuentaContable(),connexion);
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(cuentacontable.getCuentaContable(),isDeep,deepLoadType,clases);
				

		CentroCostoDataAccess.save(cuentacontable.getCentroCosto(),connexion);
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(cuentacontable.getCentroCosto(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(cuentacontable.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(cuentacontable.getModulo(),isDeep,deepLoadType,clases);
				

		MonedaDataAccess.save(cuentacontable.getMoneda(),connexion);
		MonedaLogic monedaLogic= new MonedaLogic(connexion);
		monedaLogic.deepLoad(cuentacontable.getMoneda(),isDeep,deepLoadType,clases);
				

		TipoIntervaloDataAccess.save(cuentacontable.getTipoIntervalo(),connexion);
		TipoIntervaloLogic tipointervaloLogic= new TipoIntervaloLogic(connexion);
		tipointervaloLogic.deepLoad(cuentacontable.getTipoIntervalo(),isDeep,deepLoadType,clases);
				

		TipoFlujoEfectivoDataAccess.save(cuentacontable.getTipoFlujoEfectivo(),connexion);
		TipoFlujoEfectivoLogic tipoflujoefectivoLogic= new TipoFlujoEfectivoLogic(connexion);
		tipoflujoefectivoLogic.deepLoad(cuentacontable.getTipoFlujoEfectivo(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(cuentacontable.getCuentaContableDebito(),connexion);
		CuentaContableLogic cuentacontabledebitoLogic= new CuentaContableLogic(connexion);
		cuentacontabledebitoLogic.deepLoad(cuentacontable.getCuentaContableDebito(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(cuentacontable.getCuentaContableCredito(),connexion);
		CuentaContableLogic cuentacontablecreditoLogic= new CuentaContableLogic(connexion);
		cuentacontablecreditoLogic.deepLoad(cuentacontable.getCuentaContableCredito(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cuentacontable.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(cuentacontable.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(NivelCuenta.class)) {
				NivelCuentaDataAccess.save(cuentacontable.getNivelCuenta(),connexion);
				NivelCuentaLogic nivelcuentaLogic= new NivelCuentaLogic(connexion);
				nivelcuentaLogic.deepSave(cuentacontable.getNivelCuenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentacontable.getCuentaContable(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(cuentacontable.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(cuentacontable.getCentroCosto(),connexion);
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepSave(cuentacontable.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(cuentacontable.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(cuentacontable.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Moneda.class)) {
				MonedaDataAccess.save(cuentacontable.getMoneda(),connexion);
				MonedaLogic monedaLogic= new MonedaLogic(connexion);
				monedaLogic.deepSave(cuentacontable.getMoneda(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoIntervalo.class)) {
				TipoIntervaloDataAccess.save(cuentacontable.getTipoIntervalo(),connexion);
				TipoIntervaloLogic tipointervaloLogic= new TipoIntervaloLogic(connexion);
				tipointervaloLogic.deepSave(cuentacontable.getTipoIntervalo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoFlujoEfectivo.class)) {
				TipoFlujoEfectivoDataAccess.save(cuentacontable.getTipoFlujoEfectivo(),connexion);
				TipoFlujoEfectivoLogic tipoflujoefectivoLogic= new TipoFlujoEfectivoLogic(connexion);
				tipoflujoefectivoLogic.deepSave(cuentacontable.getTipoFlujoEfectivo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentacontable.getCuentaContableDebito(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(cuentacontable.getCuentaContableDebito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentacontable.getCuentaContableCredito(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(cuentacontable.getCuentaContableCredito(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(CuentaContable.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(cuentacontable,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(cuentacontable);
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
			this.deepLoad(this.cuentacontable,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(CuentaContable.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(cuentacontables!=null) {
				for(CuentaContable cuentacontable:cuentacontables) {
					this.deepLoad(cuentacontable,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(cuentacontables);
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
			if(cuentacontables!=null) {
				for(CuentaContable cuentacontable:cuentacontables) {
					this.deepLoad(cuentacontable,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(cuentacontables);
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
			this.getNewConnexionToDeep(CuentaContable.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(cuentacontable,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(CuentaContable.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(cuentacontables!=null) {
				for(CuentaContable cuentacontable:cuentacontables) {
					this.deepSave(cuentacontable,isDeep,deepLoadType,clases);
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
			if(cuentacontables!=null) {
				for(CuentaContable cuentacontable:cuentacontables) {
					this.deepSave(cuentacontable,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getCuentaContablesBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",CuentaContableConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			CuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontables=cuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaContablesBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",CuentaContableConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			CuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontables=cuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaContablesBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",CuentaContableConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			CuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontables=cuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaContablesBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",CuentaContableConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			CuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontables=cuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaContablesFK_IdCentroCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,CuentaContableConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			CuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontables=cuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaContablesFK_IdCentroCosto(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,CuentaContableConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			CuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontables=cuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaContablesFK_IdCuentaContableWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,CuentaContableConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			CuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontables=cuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaContablesFK_IdCuentaContable(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,CuentaContableConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			CuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontables=cuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaContablesFK_IdCuentaContableCreditoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito,CuentaContableConstantesFunciones.IDCUENTACONTABLECREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCredito);

			CuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontables=cuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaContablesFK_IdCuentaContableCredito(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_credito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_credito,CuentaContableConstantesFunciones.IDCUENTACONTABLECREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableCredito);

			CuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontables=cuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaContablesFK_IdCuentaContableDebitoWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_debito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDebito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDebito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_debito,CuentaContableConstantesFunciones.IDCUENTACONTABLEDEBITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDebito);

			CuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDebito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontables=cuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaContablesFK_IdCuentaContableDebito(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_debito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableDebito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableDebito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_debito,CuentaContableConstantesFunciones.IDCUENTACONTABLEDEBITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableDebito);

			CuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableDebito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontables=cuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaContablesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CuentaContableConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontables=cuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaContablesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CuentaContableConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontables=cuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaContablesFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,CuentaContableConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			CuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontables=cuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaContablesFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,CuentaContableConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			CuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontables=cuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaContablesFK_IdMonedaWithConnection(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,CuentaContableConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			CuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontables=cuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaContablesFK_IdMoneda(String sFinalQuery,Pagination pagination,Long id_moneda)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMoneda= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMoneda.setParameterSelectionGeneralEqual(ParameterType.LONG,id_moneda,CuentaContableConstantesFunciones.IDMONEDA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMoneda);

			CuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMoneda","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontables=cuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaContablesFK_IdNivelCuentaWithConnection(String sFinalQuery,Pagination pagination,Long id_nivel_cuenta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidNivelCuenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidNivelCuenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_nivel_cuenta,CuentaContableConstantesFunciones.IDNIVELCUENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidNivelCuenta);

			CuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdNivelCuenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontables=cuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaContablesFK_IdNivelCuenta(String sFinalQuery,Pagination pagination,Long id_nivel_cuenta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidNivelCuenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidNivelCuenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_nivel_cuenta,CuentaContableConstantesFunciones.IDNIVELCUENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidNivelCuenta);

			CuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdNivelCuenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontables=cuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaContablesFK_IdTipoFlujoEfectivoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_flujo_efectivo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoFlujoEfectivo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoFlujoEfectivo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_flujo_efectivo,CuentaContableConstantesFunciones.IDTIPOFLUJOEFECTIVO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoFlujoEfectivo);

			CuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoFlujoEfectivo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontables=cuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaContablesFK_IdTipoFlujoEfectivo(String sFinalQuery,Pagination pagination,Long id_tipo_flujo_efectivo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoFlujoEfectivo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoFlujoEfectivo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_flujo_efectivo,CuentaContableConstantesFunciones.IDTIPOFLUJOEFECTIVO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoFlujoEfectivo);

			CuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoFlujoEfectivo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontables=cuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaContablesFK_IdTipoIntervaloWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_intervalo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoIntervalo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoIntervalo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_intervalo,CuentaContableConstantesFunciones.IDTIPOINTERVALO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoIntervalo);

			CuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoIntervalo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontables=cuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaContablesFK_IdTipoIntervalo(String sFinalQuery,Pagination pagination,Long id_tipo_intervalo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoIntervalo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoIntervalo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_intervalo,CuentaContableConstantesFunciones.IDTIPOINTERVALO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoIntervalo);

			CuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoIntervalo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacontables=cuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesCuentaContable(this.cuentacontables);
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
			if(CuentaContableConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,CuentaContableDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,CuentaContable cuentacontable,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(CuentaContableConstantesFunciones.ISCONAUDITORIA) {
				if(cuentacontable.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CuentaContableDataAccess.TABLENAME, cuentacontable.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CuentaContableConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CuentaContableLogic.registrarAuditoriaDetallesCuentaContable(connexion,cuentacontable,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(cuentacontable.getIsDeleted()) {
					/*if(!cuentacontable.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,CuentaContableDataAccess.TABLENAME, cuentacontable.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////CuentaContableLogic.registrarAuditoriaDetallesCuentaContable(connexion,cuentacontable,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CuentaContableDataAccess.TABLENAME, cuentacontable.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(cuentacontable.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CuentaContableDataAccess.TABLENAME, cuentacontable.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CuentaContableConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CuentaContableLogic.registrarAuditoriaDetallesCuentaContable(connexion,cuentacontable,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesCuentaContable(Connexion connexion,CuentaContable cuentacontable)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(cuentacontable.getIsNew()||!cuentacontable.getid_empresa().equals(cuentacontable.getCuentaContableOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentacontable.getCuentaContableOriginal().getid_empresa()!=null)
				{
					strValorActual=cuentacontable.getCuentaContableOriginal().getid_empresa().toString();
				}
				if(cuentacontable.getid_empresa()!=null)
				{
					strValorNuevo=cuentacontable.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaContableConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(cuentacontable.getIsNew()||!cuentacontable.getcodigo().equals(cuentacontable.getCuentaContableOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentacontable.getCuentaContableOriginal().getcodigo()!=null)
				{
					strValorActual=cuentacontable.getCuentaContableOriginal().getcodigo();
				}
				if(cuentacontable.getcodigo()!=null)
				{
					strValorNuevo=cuentacontable.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaContableConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(cuentacontable.getIsNew()||!cuentacontable.getnombre().equals(cuentacontable.getCuentaContableOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentacontable.getCuentaContableOriginal().getnombre()!=null)
				{
					strValorActual=cuentacontable.getCuentaContableOriginal().getnombre();
				}
				if(cuentacontable.getnombre()!=null)
				{
					strValorNuevo=cuentacontable.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaContableConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(cuentacontable.getIsNew()||!cuentacontable.getcodigo_extranjero().equals(cuentacontable.getCuentaContableOriginal().getcodigo_extranjero()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentacontable.getCuentaContableOriginal().getcodigo_extranjero()!=null)
				{
					strValorActual=cuentacontable.getCuentaContableOriginal().getcodigo_extranjero();
				}
				if(cuentacontable.getcodigo_extranjero()!=null)
				{
					strValorNuevo=cuentacontable.getcodigo_extranjero() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaContableConstantesFunciones.CODIGOEXTRANJERO,strValorActual,strValorNuevo);
			}	
			
			if(cuentacontable.getIsNew()||!cuentacontable.getnombre_extranjero().equals(cuentacontable.getCuentaContableOriginal().getnombre_extranjero()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentacontable.getCuentaContableOriginal().getnombre_extranjero()!=null)
				{
					strValorActual=cuentacontable.getCuentaContableOriginal().getnombre_extranjero();
				}
				if(cuentacontable.getnombre_extranjero()!=null)
				{
					strValorNuevo=cuentacontable.getnombre_extranjero() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaContableConstantesFunciones.NOMBREEXTRANJERO,strValorActual,strValorNuevo);
			}	
			
			if(cuentacontable.getIsNew()||!cuentacontable.getid_nivel_cuenta().equals(cuentacontable.getCuentaContableOriginal().getid_nivel_cuenta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentacontable.getCuentaContableOriginal().getid_nivel_cuenta()!=null)
				{
					strValorActual=cuentacontable.getCuentaContableOriginal().getid_nivel_cuenta().toString();
				}
				if(cuentacontable.getid_nivel_cuenta()!=null)
				{
					strValorNuevo=cuentacontable.getid_nivel_cuenta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaContableConstantesFunciones.IDNIVELCUENTA,strValorActual,strValorNuevo);
			}	
			
			if(cuentacontable.getIsNew()||!cuentacontable.getid_cuenta_contable().equals(cuentacontable.getCuentaContableOriginal().getid_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentacontable.getCuentaContableOriginal().getid_cuenta_contable()!=null)
				{
					strValorActual=cuentacontable.getCuentaContableOriginal().getid_cuenta_contable().toString();
				}
				if(cuentacontable.getid_cuenta_contable()!=null)
				{
					strValorNuevo=cuentacontable.getid_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaContableConstantesFunciones.IDCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(cuentacontable.getIsNew()||!cuentacontable.getid_centro_costo().equals(cuentacontable.getCuentaContableOriginal().getid_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentacontable.getCuentaContableOriginal().getid_centro_costo()!=null)
				{
					strValorActual=cuentacontable.getCuentaContableOriginal().getid_centro_costo().toString();
				}
				if(cuentacontable.getid_centro_costo()!=null)
				{
					strValorNuevo=cuentacontable.getid_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaContableConstantesFunciones.IDCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(cuentacontable.getIsNew()||!cuentacontable.getid_modulo().equals(cuentacontable.getCuentaContableOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentacontable.getCuentaContableOriginal().getid_modulo()!=null)
				{
					strValorActual=cuentacontable.getCuentaContableOriginal().getid_modulo().toString();
				}
				if(cuentacontable.getid_modulo()!=null)
				{
					strValorNuevo=cuentacontable.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaContableConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(cuentacontable.getIsNew()||!cuentacontable.getdescripcion().equals(cuentacontable.getCuentaContableOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentacontable.getCuentaContableOriginal().getdescripcion()!=null)
				{
					strValorActual=cuentacontable.getCuentaContableOriginal().getdescripcion();
				}
				if(cuentacontable.getdescripcion()!=null)
				{
					strValorNuevo=cuentacontable.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaContableConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(cuentacontable.getIsNew()||!cuentacontable.getes_movimiento().equals(cuentacontable.getCuentaContableOriginal().getes_movimiento()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentacontable.getCuentaContableOriginal().getes_movimiento()!=null)
				{
					strValorActual=cuentacontable.getCuentaContableOriginal().getes_movimiento().toString();
				}
				if(cuentacontable.getes_movimiento()!=null)
				{
					strValorNuevo=cuentacontable.getes_movimiento().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaContableConstantesFunciones.ESMOVIMIENTO,strValorActual,strValorNuevo);
			}	
			
			if(cuentacontable.getIsNew()||!cuentacontable.getes_centro_costo().equals(cuentacontable.getCuentaContableOriginal().getes_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentacontable.getCuentaContableOriginal().getes_centro_costo()!=null)
				{
					strValorActual=cuentacontable.getCuentaContableOriginal().getes_centro_costo().toString();
				}
				if(cuentacontable.getes_centro_costo()!=null)
				{
					strValorNuevo=cuentacontable.getes_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaContableConstantesFunciones.ESCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(cuentacontable.getIsNew()||!cuentacontable.getes_centro_actividad().equals(cuentacontable.getCuentaContableOriginal().getes_centro_actividad()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentacontable.getCuentaContableOriginal().getes_centro_actividad()!=null)
				{
					strValorActual=cuentacontable.getCuentaContableOriginal().getes_centro_actividad().toString();
				}
				if(cuentacontable.getes_centro_actividad()!=null)
				{
					strValorNuevo=cuentacontable.getes_centro_actividad().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaContableConstantesFunciones.ESCENTROACTIVIDAD,strValorActual,strValorNuevo);
			}	
			
			if(cuentacontable.getIsNew()||!cuentacontable.getes_activo().equals(cuentacontable.getCuentaContableOriginal().getes_activo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentacontable.getCuentaContableOriginal().getes_activo()!=null)
				{
					strValorActual=cuentacontable.getCuentaContableOriginal().getes_activo().toString();
				}
				if(cuentacontable.getes_activo()!=null)
				{
					strValorNuevo=cuentacontable.getes_activo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaContableConstantesFunciones.ESACTIVO,strValorActual,strValorNuevo);
			}	
			
			if(cuentacontable.getIsNew()||!cuentacontable.getes_relacion().equals(cuentacontable.getCuentaContableOriginal().getes_relacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentacontable.getCuentaContableOriginal().getes_relacion()!=null)
				{
					strValorActual=cuentacontable.getCuentaContableOriginal().getes_relacion().toString();
				}
				if(cuentacontable.getes_relacion()!=null)
				{
					strValorNuevo=cuentacontable.getes_relacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaContableConstantesFunciones.ESRELACION,strValorActual,strValorNuevo);
			}	
			
			if(cuentacontable.getIsNew()||!cuentacontable.getes_para_f52().equals(cuentacontable.getCuentaContableOriginal().getes_para_f52()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentacontable.getCuentaContableOriginal().getes_para_f52()!=null)
				{
					strValorActual=cuentacontable.getCuentaContableOriginal().getes_para_f52().toString();
				}
				if(cuentacontable.getes_para_f52()!=null)
				{
					strValorNuevo=cuentacontable.getes_para_f52().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaContableConstantesFunciones.ESPARAF52,strValorActual,strValorNuevo);
			}	
			
			if(cuentacontable.getIsNew()||!cuentacontable.getid_moneda().equals(cuentacontable.getCuentaContableOriginal().getid_moneda()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentacontable.getCuentaContableOriginal().getid_moneda()!=null)
				{
					strValorActual=cuentacontable.getCuentaContableOriginal().getid_moneda().toString();
				}
				if(cuentacontable.getid_moneda()!=null)
				{
					strValorNuevo=cuentacontable.getid_moneda().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaContableConstantesFunciones.IDMONEDA,strValorActual,strValorNuevo);
			}	
			
			if(cuentacontable.getIsNew()||!cuentacontable.getid_tipo_intervalo().equals(cuentacontable.getCuentaContableOriginal().getid_tipo_intervalo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentacontable.getCuentaContableOriginal().getid_tipo_intervalo()!=null)
				{
					strValorActual=cuentacontable.getCuentaContableOriginal().getid_tipo_intervalo().toString();
				}
				if(cuentacontable.getid_tipo_intervalo()!=null)
				{
					strValorNuevo=cuentacontable.getid_tipo_intervalo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaContableConstantesFunciones.IDTIPOINTERVALO,strValorActual,strValorNuevo);
			}	
			
			if(cuentacontable.getIsNew()||!cuentacontable.getid_tipo_flujo_efectivo().equals(cuentacontable.getCuentaContableOriginal().getid_tipo_flujo_efectivo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentacontable.getCuentaContableOriginal().getid_tipo_flujo_efectivo()!=null)
				{
					strValorActual=cuentacontable.getCuentaContableOriginal().getid_tipo_flujo_efectivo().toString();
				}
				if(cuentacontable.getid_tipo_flujo_efectivo()!=null)
				{
					strValorNuevo=cuentacontable.getid_tipo_flujo_efectivo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaContableConstantesFunciones.IDTIPOFLUJOEFECTIVO,strValorActual,strValorNuevo);
			}	
			
			if(cuentacontable.getIsNew()||!cuentacontable.getid_cuenta_contable_debito().equals(cuentacontable.getCuentaContableOriginal().getid_cuenta_contable_debito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentacontable.getCuentaContableOriginal().getid_cuenta_contable_debito()!=null)
				{
					strValorActual=cuentacontable.getCuentaContableOriginal().getid_cuenta_contable_debito().toString();
				}
				if(cuentacontable.getid_cuenta_contable_debito()!=null)
				{
					strValorNuevo=cuentacontable.getid_cuenta_contable_debito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaContableConstantesFunciones.IDCUENTACONTABLEDEBITO,strValorActual,strValorNuevo);
			}	
			
			if(cuentacontable.getIsNew()||!cuentacontable.getid_cuenta_contable_credito().equals(cuentacontable.getCuentaContableOriginal().getid_cuenta_contable_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentacontable.getCuentaContableOriginal().getid_cuenta_contable_credito()!=null)
				{
					strValorActual=cuentacontable.getCuentaContableOriginal().getid_cuenta_contable_credito().toString();
				}
				if(cuentacontable.getid_cuenta_contable_credito()!=null)
				{
					strValorNuevo=cuentacontable.getid_cuenta_contable_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaContableConstantesFunciones.IDCUENTACONTABLECREDITO,strValorActual,strValorNuevo);
			}	
			
			if(cuentacontable.getIsNew()||!cuentacontable.getorden().equals(cuentacontable.getCuentaContableOriginal().getorden()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentacontable.getCuentaContableOriginal().getorden()!=null)
				{
					strValorActual=cuentacontable.getCuentaContableOriginal().getorden().toString();
				}
				if(cuentacontable.getorden()!=null)
				{
					strValorNuevo=cuentacontable.getorden().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaContableConstantesFunciones.ORDEN,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveCuentaContableRelacionesWithConnection(CuentaContable cuentacontable) throws Exception {

		if(!cuentacontable.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCuentaContableRelacionesBase(cuentacontable,true);
		}
	}

	public void saveCuentaContableRelaciones(CuentaContable cuentacontable)throws Exception {

		if(!cuentacontable.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCuentaContableRelacionesBase(cuentacontable,false);
		}
	}

	public void saveCuentaContableRelacionesBase(CuentaContable cuentacontable,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("CuentaContable-saveRelacionesWithConnection");}
	

			this.setCuentaContable(cuentacontable);

			if(CuentaContableLogicAdditional.validarSaveRelaciones(cuentacontable,this)) {

				CuentaContableLogicAdditional.updateRelacionesToSave(cuentacontable,this);

				if((cuentacontable.getIsNew()||cuentacontable.getIsChanged())&&!cuentacontable.getIsDeleted()) {
					this.saveCuentaContable();
					this.saveCuentaContableRelacionesDetalles();

				} else if(cuentacontable.getIsDeleted()) {
					this.saveCuentaContableRelacionesDetalles();
					this.saveCuentaContable();
				}

				CuentaContableLogicAdditional.updateRelacionesToSaveAfter(cuentacontable,this);

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
	
	
	private void saveCuentaContableRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfCuentaContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CuentaContableConstantesFunciones.getClassesForeignKeysOfCuentaContable(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCuentaContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CuentaContableConstantesFunciones.getClassesRelationshipsOfCuentaContable(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

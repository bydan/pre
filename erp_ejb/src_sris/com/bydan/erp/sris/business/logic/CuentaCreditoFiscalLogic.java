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
package com.bydan.erp.sris.business.logic;

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
import com.bydan.erp.sris.util.*;
import com.bydan.erp.sris.util.CuentaCreditoFiscalConstantesFunciones;
import com.bydan.erp.sris.util.CuentaCreditoFiscalParameterReturnGeneral;
//import com.bydan.erp.sris.util.CuentaCreditoFiscalParameterGeneral;
import com.bydan.erp.sris.business.entity.CuentaCreditoFiscal;
import com.bydan.erp.sris.business.logic.CuentaCreditoFiscalLogicAdditional;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.sris.business.entity.*;

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
public class CuentaCreditoFiscalLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(CuentaCreditoFiscalLogic.class);
	
	protected CuentaCreditoFiscalDataAccess cuentacreditofiscalDataAccess; 	
	protected CuentaCreditoFiscal cuentacreditofiscal;
	protected List<CuentaCreditoFiscal> cuentacreditofiscals;
	protected Object cuentacreditofiscalObject;	
	protected List<Object> cuentacreditofiscalsObject;
	
	public static ClassValidator<CuentaCreditoFiscal> cuentacreditofiscalValidator = new ClassValidator<CuentaCreditoFiscal>(CuentaCreditoFiscal.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected CuentaCreditoFiscalLogicAdditional cuentacreditofiscalLogicAdditional=null;
	
	public CuentaCreditoFiscalLogicAdditional getCuentaCreditoFiscalLogicAdditional() {
		return this.cuentacreditofiscalLogicAdditional;
	}
	
	public void setCuentaCreditoFiscalLogicAdditional(CuentaCreditoFiscalLogicAdditional cuentacreditofiscalLogicAdditional) {
		try {
			this.cuentacreditofiscalLogicAdditional=cuentacreditofiscalLogicAdditional;
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
	
	
	
	
	public  CuentaCreditoFiscalLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.cuentacreditofiscalDataAccess = new CuentaCreditoFiscalDataAccess();
			
			this.cuentacreditofiscals= new ArrayList<CuentaCreditoFiscal>();
			this.cuentacreditofiscal= new CuentaCreditoFiscal();
			
			this.cuentacreditofiscalObject=new Object();
			this.cuentacreditofiscalsObject=new ArrayList<Object>();
				
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
			
			this.cuentacreditofiscalDataAccess.setConnexionType(this.connexionType);
			this.cuentacreditofiscalDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CuentaCreditoFiscalLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.cuentacreditofiscalDataAccess = new CuentaCreditoFiscalDataAccess();
			this.cuentacreditofiscals= new ArrayList<CuentaCreditoFiscal>();
			this.cuentacreditofiscal= new CuentaCreditoFiscal();
			this.cuentacreditofiscalObject=new Object();
			this.cuentacreditofiscalsObject=new ArrayList<Object>();
			
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
			
			this.cuentacreditofiscalDataAccess.setConnexionType(this.connexionType);
			this.cuentacreditofiscalDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CuentaCreditoFiscal getCuentaCreditoFiscal() throws Exception {	
		CuentaCreditoFiscalLogicAdditional.checkCuentaCreditoFiscalToGet(cuentacreditofiscal,this.datosCliente,this.arrDatoGeneral);
		CuentaCreditoFiscalLogicAdditional.updateCuentaCreditoFiscalToGet(cuentacreditofiscal,this.arrDatoGeneral);
		
		return cuentacreditofiscal;
	}
		
	public void setCuentaCreditoFiscal(CuentaCreditoFiscal newCuentaCreditoFiscal) {
		this.cuentacreditofiscal = newCuentaCreditoFiscal;
	}
	
	public CuentaCreditoFiscalDataAccess getCuentaCreditoFiscalDataAccess() {
		return cuentacreditofiscalDataAccess;
	}
	
	public void setCuentaCreditoFiscalDataAccess(CuentaCreditoFiscalDataAccess newcuentacreditofiscalDataAccess) {
		this.cuentacreditofiscalDataAccess = newcuentacreditofiscalDataAccess;
	}
	
	public List<CuentaCreditoFiscal> getCuentaCreditoFiscals() throws Exception {		
		this.quitarCuentaCreditoFiscalsNulos();
		
		CuentaCreditoFiscalLogicAdditional.checkCuentaCreditoFiscalToGets(cuentacreditofiscals,this.datosCliente,this.arrDatoGeneral);
		
		for (CuentaCreditoFiscal cuentacreditofiscalLocal: cuentacreditofiscals ) {
			CuentaCreditoFiscalLogicAdditional.updateCuentaCreditoFiscalToGet(cuentacreditofiscalLocal,this.arrDatoGeneral);
		}
		
		return cuentacreditofiscals;
	}
	
	public void setCuentaCreditoFiscals(List<CuentaCreditoFiscal> newCuentaCreditoFiscals) {
		this.cuentacreditofiscals = newCuentaCreditoFiscals;
	}
	
	public Object getCuentaCreditoFiscalObject() {	
		this.cuentacreditofiscalObject=this.cuentacreditofiscalDataAccess.getEntityObject();
		return this.cuentacreditofiscalObject;
	}
		
	public void setCuentaCreditoFiscalObject(Object newCuentaCreditoFiscalObject) {
		this.cuentacreditofiscalObject = newCuentaCreditoFiscalObject;
	}
	
	public List<Object> getCuentaCreditoFiscalsObject() {		
		this.cuentacreditofiscalsObject=this.cuentacreditofiscalDataAccess.getEntitiesObject();
		return this.cuentacreditofiscalsObject;
	}
		
	public void setCuentaCreditoFiscalsObject(List<Object> newCuentaCreditoFiscalsObject) {
		this.cuentacreditofiscalsObject = newCuentaCreditoFiscalsObject;
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
		
		if(this.cuentacreditofiscalDataAccess!=null) {
			this.cuentacreditofiscalDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaCreditoFiscal.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			cuentacreditofiscalDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			cuentacreditofiscalDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		cuentacreditofiscal = new  CuentaCreditoFiscal();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaCreditoFiscal.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cuentacreditofiscal=cuentacreditofiscalDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuentacreditofiscal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuentaCreditoFiscalConstantesFunciones.refrescarForeignKeysDescripcionesCuentaCreditoFiscal(this.cuentacreditofiscal);
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
		cuentacreditofiscal = new  CuentaCreditoFiscal();
		  		  
        try {
			
			cuentacreditofiscal=cuentacreditofiscalDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuentacreditofiscal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuentaCreditoFiscalConstantesFunciones.refrescarForeignKeysDescripcionesCuentaCreditoFiscal(this.cuentacreditofiscal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		cuentacreditofiscal = new  CuentaCreditoFiscal();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaCreditoFiscal.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cuentacreditofiscal=cuentacreditofiscalDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuentacreditofiscal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuentaCreditoFiscalConstantesFunciones.refrescarForeignKeysDescripcionesCuentaCreditoFiscal(this.cuentacreditofiscal);
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
		cuentacreditofiscal = new  CuentaCreditoFiscal();
		  		  
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
		cuentacreditofiscal = new  CuentaCreditoFiscal();
		  		  
        try {
			
			cuentacreditofiscal=cuentacreditofiscalDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuentacreditofiscal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuentaCreditoFiscalConstantesFunciones.refrescarForeignKeysDescripcionesCuentaCreditoFiscal(this.cuentacreditofiscal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		cuentacreditofiscal = new  CuentaCreditoFiscal();
		  		  
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
		cuentacreditofiscal = new  CuentaCreditoFiscal();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaCreditoFiscal.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =cuentacreditofiscalDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cuentacreditofiscal = new  CuentaCreditoFiscal();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=cuentacreditofiscalDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cuentacreditofiscal = new  CuentaCreditoFiscal();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaCreditoFiscal.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =cuentacreditofiscalDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cuentacreditofiscal = new  CuentaCreditoFiscal();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=cuentacreditofiscalDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cuentacreditofiscal = new  CuentaCreditoFiscal();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaCreditoFiscal.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =cuentacreditofiscalDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cuentacreditofiscal = new  CuentaCreditoFiscal();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=cuentacreditofiscalDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cuentacreditofiscals = new  ArrayList<CuentaCreditoFiscal>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaCreditoFiscal.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			CuentaCreditoFiscalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacreditofiscals=cuentacreditofiscalDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaCreditoFiscal(cuentacreditofiscals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaCreditoFiscalConstantesFunciones.refrescarForeignKeysDescripcionesCuentaCreditoFiscal(this.cuentacreditofiscals);
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
		cuentacreditofiscals = new  ArrayList<CuentaCreditoFiscal>();
		  		  
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
		cuentacreditofiscals = new  ArrayList<CuentaCreditoFiscal>();
		  		  
        try {			
			CuentaCreditoFiscalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacreditofiscals=cuentacreditofiscalDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarCuentaCreditoFiscal(cuentacreditofiscals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaCreditoFiscalConstantesFunciones.refrescarForeignKeysDescripcionesCuentaCreditoFiscal(this.cuentacreditofiscals);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		cuentacreditofiscals = new  ArrayList<CuentaCreditoFiscal>();
		  		  
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
		cuentacreditofiscals = new  ArrayList<CuentaCreditoFiscal>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaCreditoFiscal.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			CuentaCreditoFiscalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacreditofiscals=cuentacreditofiscalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaCreditoFiscal(cuentacreditofiscals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaCreditoFiscalConstantesFunciones.refrescarForeignKeysDescripcionesCuentaCreditoFiscal(this.cuentacreditofiscals);
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
		cuentacreditofiscals = new  ArrayList<CuentaCreditoFiscal>();
		  		  
        try {
			CuentaCreditoFiscalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacreditofiscals=cuentacreditofiscalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaCreditoFiscal(cuentacreditofiscals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaCreditoFiscalConstantesFunciones.refrescarForeignKeysDescripcionesCuentaCreditoFiscal(this.cuentacreditofiscals);
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
		cuentacreditofiscals = new  ArrayList<CuentaCreditoFiscal>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaCreditoFiscal.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaCreditoFiscalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacreditofiscals=cuentacreditofiscalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuentaCreditoFiscal(cuentacreditofiscals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaCreditoFiscalConstantesFunciones.refrescarForeignKeysDescripcionesCuentaCreditoFiscal(this.cuentacreditofiscals);
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
		cuentacreditofiscals = new  ArrayList<CuentaCreditoFiscal>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaCreditoFiscalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacreditofiscals=cuentacreditofiscalDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuentaCreditoFiscal(cuentacreditofiscals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaCreditoFiscalConstantesFunciones.refrescarForeignKeysDescripcionesCuentaCreditoFiscal(this.cuentacreditofiscals);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		cuentacreditofiscal = new  CuentaCreditoFiscal();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaCreditoFiscal.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaCreditoFiscalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacreditofiscal=cuentacreditofiscalDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuentaCreditoFiscal(cuentacreditofiscal);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaCreditoFiscalConstantesFunciones.refrescarForeignKeysDescripcionesCuentaCreditoFiscal(this.cuentacreditofiscal);
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
		cuentacreditofiscal = new  CuentaCreditoFiscal();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaCreditoFiscalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacreditofiscal=cuentacreditofiscalDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuentaCreditoFiscal(cuentacreditofiscal);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaCreditoFiscalConstantesFunciones.refrescarForeignKeysDescripcionesCuentaCreditoFiscal(this.cuentacreditofiscal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cuentacreditofiscals = new  ArrayList<CuentaCreditoFiscal>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaCreditoFiscal.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			CuentaCreditoFiscalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacreditofiscals=cuentacreditofiscalDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaCreditoFiscal(cuentacreditofiscals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaCreditoFiscalConstantesFunciones.refrescarForeignKeysDescripcionesCuentaCreditoFiscal(this.cuentacreditofiscals);
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
		cuentacreditofiscals = new  ArrayList<CuentaCreditoFiscal>();
		  		  
        try {
			CuentaCreditoFiscalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacreditofiscals=cuentacreditofiscalDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaCreditoFiscal(cuentacreditofiscals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaCreditoFiscalConstantesFunciones.refrescarForeignKeysDescripcionesCuentaCreditoFiscal(this.cuentacreditofiscals);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosCuentaCreditoFiscalsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		cuentacreditofiscals = new  ArrayList<CuentaCreditoFiscal>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaCreditoFiscal.class.getSimpleName()+"-getTodosCuentaCreditoFiscalsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaCreditoFiscalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacreditofiscals=cuentacreditofiscalDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCuentaCreditoFiscal(cuentacreditofiscals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaCreditoFiscalConstantesFunciones.refrescarForeignKeysDescripcionesCuentaCreditoFiscal(this.cuentacreditofiscals);
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
	
	public  void  getTodosCuentaCreditoFiscals(String sFinalQuery,Pagination pagination)throws Exception {
		cuentacreditofiscals = new  ArrayList<CuentaCreditoFiscal>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaCreditoFiscalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentacreditofiscals=cuentacreditofiscalDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCuentaCreditoFiscal(cuentacreditofiscals);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaCreditoFiscalConstantesFunciones.refrescarForeignKeysDescripcionesCuentaCreditoFiscal(this.cuentacreditofiscals);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarCuentaCreditoFiscal(CuentaCreditoFiscal cuentacreditofiscal) throws Exception {
		Boolean estaValidado=false;
		
		if(cuentacreditofiscal.getIsNew() || cuentacreditofiscal.getIsChanged()) { 
			this.invalidValues = cuentacreditofiscalValidator.getInvalidValues(cuentacreditofiscal);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(cuentacreditofiscal);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarCuentaCreditoFiscal(List<CuentaCreditoFiscal> CuentaCreditoFiscals) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(CuentaCreditoFiscal cuentacreditofiscalLocal:cuentacreditofiscals) {				
			estaValidadoObjeto=this.validarGuardarCuentaCreditoFiscal(cuentacreditofiscalLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarCuentaCreditoFiscal(List<CuentaCreditoFiscal> CuentaCreditoFiscals) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCuentaCreditoFiscal(cuentacreditofiscals)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarCuentaCreditoFiscal(CuentaCreditoFiscal CuentaCreditoFiscal) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCuentaCreditoFiscal(cuentacreditofiscal)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(CuentaCreditoFiscal cuentacreditofiscal) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+cuentacreditofiscal.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=CuentaCreditoFiscalConstantesFunciones.getCuentaCreditoFiscalLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"cuentacreditofiscal","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(CuentaCreditoFiscalConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(CuentaCreditoFiscalConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveCuentaCreditoFiscalWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaCreditoFiscal.class.getSimpleName()+"-saveCuentaCreditoFiscalWithConnection");connexion.begin();			
			
			CuentaCreditoFiscalLogicAdditional.checkCuentaCreditoFiscalToSave(this.cuentacreditofiscal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CuentaCreditoFiscalLogicAdditional.updateCuentaCreditoFiscalToSave(this.cuentacreditofiscal,this.arrDatoGeneral);
			
			CuentaCreditoFiscalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cuentacreditofiscal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowCuentaCreditoFiscal();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCuentaCreditoFiscal(this.cuentacreditofiscal)) {
				CuentaCreditoFiscalDataAccess.save(this.cuentacreditofiscal, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.cuentacreditofiscal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CuentaCreditoFiscalLogicAdditional.checkCuentaCreditoFiscalToSaveAfter(this.cuentacreditofiscal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCuentaCreditoFiscal();
			
			connexion.commit();			
			
			if(this.cuentacreditofiscal.getIsDeleted()) {
				this.cuentacreditofiscal=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveCuentaCreditoFiscal()throws Exception {	
		try {	
			
			CuentaCreditoFiscalLogicAdditional.checkCuentaCreditoFiscalToSave(this.cuentacreditofiscal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CuentaCreditoFiscalLogicAdditional.updateCuentaCreditoFiscalToSave(this.cuentacreditofiscal,this.arrDatoGeneral);
			
			CuentaCreditoFiscalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cuentacreditofiscal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCuentaCreditoFiscal(this.cuentacreditofiscal)) {			
				CuentaCreditoFiscalDataAccess.save(this.cuentacreditofiscal, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.cuentacreditofiscal,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CuentaCreditoFiscalLogicAdditional.checkCuentaCreditoFiscalToSaveAfter(this.cuentacreditofiscal,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.cuentacreditofiscal.getIsDeleted()) {
				this.cuentacreditofiscal=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveCuentaCreditoFiscalsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaCreditoFiscal.class.getSimpleName()+"-saveCuentaCreditoFiscalsWithConnection");connexion.begin();			
			
			CuentaCreditoFiscalLogicAdditional.checkCuentaCreditoFiscalToSaves(cuentacreditofiscals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowCuentaCreditoFiscals();
			
			Boolean validadoTodosCuentaCreditoFiscal=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CuentaCreditoFiscal cuentacreditofiscalLocal:cuentacreditofiscals) {		
				if(cuentacreditofiscalLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CuentaCreditoFiscalLogicAdditional.updateCuentaCreditoFiscalToSave(cuentacreditofiscalLocal,this.arrDatoGeneral);
	        	
				CuentaCreditoFiscalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cuentacreditofiscalLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCuentaCreditoFiscal(cuentacreditofiscalLocal)) {
					CuentaCreditoFiscalDataAccess.save(cuentacreditofiscalLocal, connexion);				
				} else {
					validadoTodosCuentaCreditoFiscal=false;
				}
			}
			
			if(!validadoTodosCuentaCreditoFiscal) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CuentaCreditoFiscalLogicAdditional.checkCuentaCreditoFiscalToSavesAfter(cuentacreditofiscals,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCuentaCreditoFiscals();
			
			connexion.commit();		
			
			this.quitarCuentaCreditoFiscalsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveCuentaCreditoFiscals()throws Exception {				
		 try {	
			CuentaCreditoFiscalLogicAdditional.checkCuentaCreditoFiscalToSaves(cuentacreditofiscals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosCuentaCreditoFiscal=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CuentaCreditoFiscal cuentacreditofiscalLocal:cuentacreditofiscals) {				
				if(cuentacreditofiscalLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CuentaCreditoFiscalLogicAdditional.updateCuentaCreditoFiscalToSave(cuentacreditofiscalLocal,this.arrDatoGeneral);
	        	
				CuentaCreditoFiscalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cuentacreditofiscalLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCuentaCreditoFiscal(cuentacreditofiscalLocal)) {				
					CuentaCreditoFiscalDataAccess.save(cuentacreditofiscalLocal, connexion);				
				} else {
					validadoTodosCuentaCreditoFiscal=false;
				}
			}
			
			if(!validadoTodosCuentaCreditoFiscal) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CuentaCreditoFiscalLogicAdditional.checkCuentaCreditoFiscalToSavesAfter(cuentacreditofiscals,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarCuentaCreditoFiscalsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CuentaCreditoFiscalParameterReturnGeneral procesarAccionCuentaCreditoFiscals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CuentaCreditoFiscal> cuentacreditofiscals,CuentaCreditoFiscalParameterReturnGeneral cuentacreditofiscalParameterGeneral)throws Exception {
		 try {	
			CuentaCreditoFiscalParameterReturnGeneral cuentacreditofiscalReturnGeneral=new CuentaCreditoFiscalParameterReturnGeneral();
	
			CuentaCreditoFiscalLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cuentacreditofiscals,cuentacreditofiscalParameterGeneral,cuentacreditofiscalReturnGeneral);
			
			return cuentacreditofiscalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CuentaCreditoFiscalParameterReturnGeneral procesarAccionCuentaCreditoFiscalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CuentaCreditoFiscal> cuentacreditofiscals,CuentaCreditoFiscalParameterReturnGeneral cuentacreditofiscalParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaCreditoFiscal.class.getSimpleName()+"-procesarAccionCuentaCreditoFiscalsWithConnection");connexion.begin();			
			
			CuentaCreditoFiscalParameterReturnGeneral cuentacreditofiscalReturnGeneral=new CuentaCreditoFiscalParameterReturnGeneral();
	
			CuentaCreditoFiscalLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cuentacreditofiscals,cuentacreditofiscalParameterGeneral,cuentacreditofiscalReturnGeneral);
			
			this.connexion.commit();
			
			return cuentacreditofiscalReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CuentaCreditoFiscalParameterReturnGeneral procesarEventosCuentaCreditoFiscals(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CuentaCreditoFiscal> cuentacreditofiscals,CuentaCreditoFiscal cuentacreditofiscal,CuentaCreditoFiscalParameterReturnGeneral cuentacreditofiscalParameterGeneral,Boolean isEsNuevoCuentaCreditoFiscal,ArrayList<Classe> clases)throws Exception {
		 try {	
			CuentaCreditoFiscalParameterReturnGeneral cuentacreditofiscalReturnGeneral=new CuentaCreditoFiscalParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cuentacreditofiscalReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CuentaCreditoFiscalLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cuentacreditofiscals,cuentacreditofiscal,cuentacreditofiscalParameterGeneral,cuentacreditofiscalReturnGeneral,isEsNuevoCuentaCreditoFiscal,clases);
			
			return cuentacreditofiscalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public CuentaCreditoFiscalParameterReturnGeneral procesarEventosCuentaCreditoFiscalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CuentaCreditoFiscal> cuentacreditofiscals,CuentaCreditoFiscal cuentacreditofiscal,CuentaCreditoFiscalParameterReturnGeneral cuentacreditofiscalParameterGeneral,Boolean isEsNuevoCuentaCreditoFiscal,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaCreditoFiscal.class.getSimpleName()+"-procesarEventosCuentaCreditoFiscalsWithConnection");connexion.begin();			
			
			CuentaCreditoFiscalParameterReturnGeneral cuentacreditofiscalReturnGeneral=new CuentaCreditoFiscalParameterReturnGeneral();
	
			cuentacreditofiscalReturnGeneral.setCuentaCreditoFiscal(cuentacreditofiscal);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cuentacreditofiscalReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CuentaCreditoFiscalLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cuentacreditofiscals,cuentacreditofiscal,cuentacreditofiscalParameterGeneral,cuentacreditofiscalReturnGeneral,isEsNuevoCuentaCreditoFiscal,clases);
			
			this.connexion.commit();
			
			return cuentacreditofiscalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CuentaCreditoFiscalParameterReturnGeneral procesarImportacionCuentaCreditoFiscalsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,CuentaCreditoFiscalParameterReturnGeneral cuentacreditofiscalParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaCreditoFiscal.class.getSimpleName()+"-procesarImportacionCuentaCreditoFiscalsWithConnection");connexion.begin();			
			
			CuentaCreditoFiscalParameterReturnGeneral cuentacreditofiscalReturnGeneral=new CuentaCreditoFiscalParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.cuentacreditofiscals=new ArrayList<CuentaCreditoFiscal>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.cuentacreditofiscal=new CuentaCreditoFiscal();
				
				
				if(conColumnasBase) {this.cuentacreditofiscal.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.cuentacreditofiscal.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.cuentacreditofiscal.setesta_activo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.cuentacreditofiscals.add(this.cuentacreditofiscal);
			}
			
			this.saveCuentaCreditoFiscals();
			
			this.connexion.commit();
			
			cuentacreditofiscalReturnGeneral.setConRetornoEstaProcesado(true);
			cuentacreditofiscalReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return cuentacreditofiscalReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarCuentaCreditoFiscalsEliminados() throws Exception {				
		
		List<CuentaCreditoFiscal> cuentacreditofiscalsAux= new ArrayList<CuentaCreditoFiscal>();
		
		for(CuentaCreditoFiscal cuentacreditofiscal:cuentacreditofiscals) {
			if(!cuentacreditofiscal.getIsDeleted()) {
				cuentacreditofiscalsAux.add(cuentacreditofiscal);
			}
		}
		
		cuentacreditofiscals=cuentacreditofiscalsAux;
	}
	
	public void quitarCuentaCreditoFiscalsNulos() throws Exception {				
		
		List<CuentaCreditoFiscal> cuentacreditofiscalsAux= new ArrayList<CuentaCreditoFiscal>();
		
		for(CuentaCreditoFiscal cuentacreditofiscal : this.cuentacreditofiscals) {
			if(cuentacreditofiscal==null) {
				cuentacreditofiscalsAux.add(cuentacreditofiscal);
			}
		}
		
		//this.cuentacreditofiscals=cuentacreditofiscalsAux;
		
		this.cuentacreditofiscals.removeAll(cuentacreditofiscalsAux);
	}
	
	public void getSetVersionRowCuentaCreditoFiscalWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(cuentacreditofiscal.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((cuentacreditofiscal.getIsDeleted() || (cuentacreditofiscal.getIsChanged()&&!cuentacreditofiscal.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=cuentacreditofiscalDataAccess.getSetVersionRowCuentaCreditoFiscal(connexion,cuentacreditofiscal.getId());
				
				if(!cuentacreditofiscal.getVersionRow().equals(timestamp)) {	
					cuentacreditofiscal.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				cuentacreditofiscal.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowCuentaCreditoFiscal()throws Exception {	
		
		if(cuentacreditofiscal.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((cuentacreditofiscal.getIsDeleted() || (cuentacreditofiscal.getIsChanged()&&!cuentacreditofiscal.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=cuentacreditofiscalDataAccess.getSetVersionRowCuentaCreditoFiscal(connexion,cuentacreditofiscal.getId());
			
			try {							
				if(!cuentacreditofiscal.getVersionRow().equals(timestamp)) {	
					cuentacreditofiscal.setVersionRow(timestamp);
				}
				
				cuentacreditofiscal.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowCuentaCreditoFiscalsWithConnection()throws Exception {	
		if(cuentacreditofiscals!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(CuentaCreditoFiscal cuentacreditofiscalAux:cuentacreditofiscals) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(cuentacreditofiscalAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cuentacreditofiscalAux.getIsDeleted() || (cuentacreditofiscalAux.getIsChanged()&&!cuentacreditofiscalAux.getIsNew())) {
						
						timestamp=cuentacreditofiscalDataAccess.getSetVersionRowCuentaCreditoFiscal(connexion,cuentacreditofiscalAux.getId());
						
						if(!cuentacreditofiscal.getVersionRow().equals(timestamp)) {	
							cuentacreditofiscalAux.setVersionRow(timestamp);
						}
								
						cuentacreditofiscalAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowCuentaCreditoFiscals()throws Exception {	
		if(cuentacreditofiscals!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(CuentaCreditoFiscal cuentacreditofiscalAux:cuentacreditofiscals) {
					if(cuentacreditofiscalAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cuentacreditofiscalAux.getIsDeleted() || (cuentacreditofiscalAux.getIsChanged()&&!cuentacreditofiscalAux.getIsNew())) {
						
						timestamp=cuentacreditofiscalDataAccess.getSetVersionRowCuentaCreditoFiscal(connexion,cuentacreditofiscalAux.getId());
						
						if(!cuentacreditofiscalAux.getVersionRow().equals(timestamp)) {	
							cuentacreditofiscalAux.setVersionRow(timestamp);
						}
						
													
						cuentacreditofiscalAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public CuentaCreditoFiscalParameterReturnGeneral cargarCombosLoteForeignKeyCuentaCreditoFiscalWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalCuentaContable) throws Exception {
		CuentaCreditoFiscalParameterReturnGeneral  cuentacreditofiscalReturnGeneral =new CuentaCreditoFiscalParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaCreditoFiscal.class.getSimpleName()+"-cargarCombosLoteForeignKeyCuentaCreditoFiscalWithConnection");connexion.begin();
			
			cuentacreditofiscalReturnGeneral =new CuentaCreditoFiscalParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cuentacreditofiscalReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			cuentacreditofiscalReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return cuentacreditofiscalReturnGeneral;
	}
	
	public CuentaCreditoFiscalParameterReturnGeneral cargarCombosLoteForeignKeyCuentaCreditoFiscal(String finalQueryGlobalEmpresa,String finalQueryGlobalCuentaContable) throws Exception {
		CuentaCreditoFiscalParameterReturnGeneral  cuentacreditofiscalReturnGeneral =new CuentaCreditoFiscalParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			cuentacreditofiscalReturnGeneral =new CuentaCreditoFiscalParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cuentacreditofiscalReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			cuentacreditofiscalReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return cuentacreditofiscalReturnGeneral;
	}
	
	
	public void deepLoad(CuentaCreditoFiscal cuentacreditofiscal,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CuentaCreditoFiscalLogicAdditional.updateCuentaCreditoFiscalToGet(cuentacreditofiscal,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cuentacreditofiscal.setEmpresa(cuentacreditofiscalDataAccess.getEmpresa(connexion,cuentacreditofiscal));
		cuentacreditofiscal.setCuentaContable(cuentacreditofiscalDataAccess.getCuentaContable(connexion,cuentacreditofiscal));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cuentacreditofiscal.setEmpresa(cuentacreditofiscalDataAccess.getEmpresa(connexion,cuentacreditofiscal));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentacreditofiscal.setCuentaContable(cuentacreditofiscalDataAccess.getCuentaContable(connexion,cuentacreditofiscal));
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
			cuentacreditofiscal.setEmpresa(cuentacreditofiscalDataAccess.getEmpresa(connexion,cuentacreditofiscal));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentacreditofiscal.setCuentaContable(cuentacreditofiscalDataAccess.getCuentaContable(connexion,cuentacreditofiscal));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cuentacreditofiscal.setEmpresa(cuentacreditofiscalDataAccess.getEmpresa(connexion,cuentacreditofiscal));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cuentacreditofiscal.getEmpresa(),isDeep,deepLoadType,clases);
				
		cuentacreditofiscal.setCuentaContable(cuentacreditofiscalDataAccess.getCuentaContable(connexion,cuentacreditofiscal));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(cuentacreditofiscal.getCuentaContable(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cuentacreditofiscal.setEmpresa(cuentacreditofiscalDataAccess.getEmpresa(connexion,cuentacreditofiscal));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(cuentacreditofiscal.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentacreditofiscal.setCuentaContable(cuentacreditofiscalDataAccess.getCuentaContable(connexion,cuentacreditofiscal));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(cuentacreditofiscal.getCuentaContable(),isDeep,deepLoadType,clases);				
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
			cuentacreditofiscal.setEmpresa(cuentacreditofiscalDataAccess.getEmpresa(connexion,cuentacreditofiscal));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(cuentacreditofiscal.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentacreditofiscal.setCuentaContable(cuentacreditofiscalDataAccess.getCuentaContable(connexion,cuentacreditofiscal));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(cuentacreditofiscal.getCuentaContable(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(CuentaCreditoFiscal cuentacreditofiscal,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			CuentaCreditoFiscalLogicAdditional.updateCuentaCreditoFiscalToSave(cuentacreditofiscal,this.arrDatoGeneral);
			
CuentaCreditoFiscalDataAccess.save(cuentacreditofiscal, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(cuentacreditofiscal.getEmpresa(),connexion);

		CuentaContableDataAccess.save(cuentacreditofiscal.getCuentaContable(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cuentacreditofiscal.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentacreditofiscal.getCuentaContable(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(cuentacreditofiscal.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cuentacreditofiscal.getEmpresa(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(cuentacreditofiscal.getCuentaContable(),connexion);
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(cuentacreditofiscal.getCuentaContable(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cuentacreditofiscal.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(cuentacreditofiscal.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentacreditofiscal.getCuentaContable(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(cuentacreditofiscal.getCuentaContable(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(CuentaCreditoFiscal.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(cuentacreditofiscal,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CuentaCreditoFiscalConstantesFunciones.refrescarForeignKeysDescripcionesCuentaCreditoFiscal(cuentacreditofiscal);
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
			this.deepLoad(this.cuentacreditofiscal,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CuentaCreditoFiscalConstantesFunciones.refrescarForeignKeysDescripcionesCuentaCreditoFiscal(this.cuentacreditofiscal);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(CuentaCreditoFiscal.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(cuentacreditofiscals!=null) {
				for(CuentaCreditoFiscal cuentacreditofiscal:cuentacreditofiscals) {
					this.deepLoad(cuentacreditofiscal,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CuentaCreditoFiscalConstantesFunciones.refrescarForeignKeysDescripcionesCuentaCreditoFiscal(cuentacreditofiscals);
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
			if(cuentacreditofiscals!=null) {
				for(CuentaCreditoFiscal cuentacreditofiscal:cuentacreditofiscals) {
					this.deepLoad(cuentacreditofiscal,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CuentaCreditoFiscalConstantesFunciones.refrescarForeignKeysDescripcionesCuentaCreditoFiscal(cuentacreditofiscals);
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
			this.getNewConnexionToDeep(CuentaCreditoFiscal.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(cuentacreditofiscal,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(CuentaCreditoFiscal.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(cuentacreditofiscals!=null) {
				for(CuentaCreditoFiscal cuentacreditofiscal:cuentacreditofiscals) {
					this.deepSave(cuentacreditofiscal,isDeep,deepLoadType,clases);
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
			if(cuentacreditofiscals!=null) {
				for(CuentaCreditoFiscal cuentacreditofiscal:cuentacreditofiscals) {
					this.deepSave(cuentacreditofiscal,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getCuentaCreditoFiscalsFK_IdCuentaContableWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaCreditoFiscal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,CuentaCreditoFiscalConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			CuentaCreditoFiscalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacreditofiscals=cuentacreditofiscalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaCreditoFiscalConstantesFunciones.refrescarForeignKeysDescripcionesCuentaCreditoFiscal(this.cuentacreditofiscals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaCreditoFiscalsFK_IdCuentaContable(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,CuentaCreditoFiscalConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			CuentaCreditoFiscalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacreditofiscals=cuentacreditofiscalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaCreditoFiscalConstantesFunciones.refrescarForeignKeysDescripcionesCuentaCreditoFiscal(this.cuentacreditofiscals);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaCreditoFiscalsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaCreditoFiscal.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CuentaCreditoFiscalConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CuentaCreditoFiscalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacreditofiscals=cuentacreditofiscalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaCreditoFiscalConstantesFunciones.refrescarForeignKeysDescripcionesCuentaCreditoFiscal(this.cuentacreditofiscals);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaCreditoFiscalsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CuentaCreditoFiscalConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CuentaCreditoFiscalLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentacreditofiscals=cuentacreditofiscalDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaCreditoFiscalConstantesFunciones.refrescarForeignKeysDescripcionesCuentaCreditoFiscal(this.cuentacreditofiscals);
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
			if(CuentaCreditoFiscalConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,CuentaCreditoFiscalDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,CuentaCreditoFiscal cuentacreditofiscal,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(CuentaCreditoFiscalConstantesFunciones.ISCONAUDITORIA) {
				if(cuentacreditofiscal.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CuentaCreditoFiscalDataAccess.TABLENAME, cuentacreditofiscal.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CuentaCreditoFiscalConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CuentaCreditoFiscalLogic.registrarAuditoriaDetallesCuentaCreditoFiscal(connexion,cuentacreditofiscal,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(cuentacreditofiscal.getIsDeleted()) {
					/*if(!cuentacreditofiscal.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,CuentaCreditoFiscalDataAccess.TABLENAME, cuentacreditofiscal.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////CuentaCreditoFiscalLogic.registrarAuditoriaDetallesCuentaCreditoFiscal(connexion,cuentacreditofiscal,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CuentaCreditoFiscalDataAccess.TABLENAME, cuentacreditofiscal.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(cuentacreditofiscal.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CuentaCreditoFiscalDataAccess.TABLENAME, cuentacreditofiscal.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CuentaCreditoFiscalConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CuentaCreditoFiscalLogic.registrarAuditoriaDetallesCuentaCreditoFiscal(connexion,cuentacreditofiscal,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesCuentaCreditoFiscal(Connexion connexion,CuentaCreditoFiscal cuentacreditofiscal)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(cuentacreditofiscal.getIsNew()||!cuentacreditofiscal.getid_empresa().equals(cuentacreditofiscal.getCuentaCreditoFiscalOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentacreditofiscal.getCuentaCreditoFiscalOriginal().getid_empresa()!=null)
				{
					strValorActual=cuentacreditofiscal.getCuentaCreditoFiscalOriginal().getid_empresa().toString();
				}
				if(cuentacreditofiscal.getid_empresa()!=null)
				{
					strValorNuevo=cuentacreditofiscal.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaCreditoFiscalConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(cuentacreditofiscal.getIsNew()||!cuentacreditofiscal.getid_cuenta_contable().equals(cuentacreditofiscal.getCuentaCreditoFiscalOriginal().getid_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentacreditofiscal.getCuentaCreditoFiscalOriginal().getid_cuenta_contable()!=null)
				{
					strValorActual=cuentacreditofiscal.getCuentaCreditoFiscalOriginal().getid_cuenta_contable().toString();
				}
				if(cuentacreditofiscal.getid_cuenta_contable()!=null)
				{
					strValorNuevo=cuentacreditofiscal.getid_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaCreditoFiscalConstantesFunciones.IDCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(cuentacreditofiscal.getIsNew()||!cuentacreditofiscal.getesta_activo().equals(cuentacreditofiscal.getCuentaCreditoFiscalOriginal().getesta_activo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentacreditofiscal.getCuentaCreditoFiscalOriginal().getesta_activo()!=null)
				{
					strValorActual=cuentacreditofiscal.getCuentaCreditoFiscalOriginal().getesta_activo().toString();
				}
				if(cuentacreditofiscal.getesta_activo()!=null)
				{
					strValorNuevo=cuentacreditofiscal.getesta_activo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaCreditoFiscalConstantesFunciones.ESTAACTIVO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveCuentaCreditoFiscalRelacionesWithConnection(CuentaCreditoFiscal cuentacreditofiscal) throws Exception {

		if(!cuentacreditofiscal.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCuentaCreditoFiscalRelacionesBase(cuentacreditofiscal,true);
		}
	}

	public void saveCuentaCreditoFiscalRelaciones(CuentaCreditoFiscal cuentacreditofiscal)throws Exception {

		if(!cuentacreditofiscal.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCuentaCreditoFiscalRelacionesBase(cuentacreditofiscal,false);
		}
	}

	public void saveCuentaCreditoFiscalRelacionesBase(CuentaCreditoFiscal cuentacreditofiscal,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("CuentaCreditoFiscal-saveRelacionesWithConnection");}
	

			this.setCuentaCreditoFiscal(cuentacreditofiscal);

			if(CuentaCreditoFiscalLogicAdditional.validarSaveRelaciones(cuentacreditofiscal,this)) {

				CuentaCreditoFiscalLogicAdditional.updateRelacionesToSave(cuentacreditofiscal,this);

				if((cuentacreditofiscal.getIsNew()||cuentacreditofiscal.getIsChanged())&&!cuentacreditofiscal.getIsDeleted()) {
					this.saveCuentaCreditoFiscal();
					this.saveCuentaCreditoFiscalRelacionesDetalles();

				} else if(cuentacreditofiscal.getIsDeleted()) {
					this.saveCuentaCreditoFiscalRelacionesDetalles();
					this.saveCuentaCreditoFiscal();
				}

				CuentaCreditoFiscalLogicAdditional.updateRelacionesToSaveAfter(cuentacreditofiscal,this);

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
	
	
	private void saveCuentaCreditoFiscalRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfCuentaCreditoFiscal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CuentaCreditoFiscalConstantesFunciones.getClassesForeignKeysOfCuentaCreditoFiscal(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCuentaCreditoFiscal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CuentaCreditoFiscalConstantesFunciones.getClassesRelationshipsOfCuentaCreditoFiscal(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

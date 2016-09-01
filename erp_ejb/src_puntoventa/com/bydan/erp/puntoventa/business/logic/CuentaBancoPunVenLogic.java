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
package com.bydan.erp.puntoventa.business.logic;

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
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.puntoventa.util.CuentaBancoPunVenConstantesFunciones;
import com.bydan.erp.puntoventa.util.CuentaBancoPunVenParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.CuentaBancoPunVenParameterGeneral;
import com.bydan.erp.puntoventa.business.entity.CuentaBancoPunVen;
import com.bydan.erp.puntoventa.business.logic.CuentaBancoPunVenLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;








@SuppressWarnings("unused")
public class CuentaBancoPunVenLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(CuentaBancoPunVenLogic.class);
	
	protected CuentaBancoPunVenDataAccess cuentabancopunvenDataAccess; 	
	protected CuentaBancoPunVen cuentabancopunven;
	protected List<CuentaBancoPunVen> cuentabancopunvens;
	protected Object cuentabancopunvenObject;	
	protected List<Object> cuentabancopunvensObject;
	
	public static ClassValidator<CuentaBancoPunVen> cuentabancopunvenValidator = new ClassValidator<CuentaBancoPunVen>(CuentaBancoPunVen.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected CuentaBancoPunVenLogicAdditional cuentabancopunvenLogicAdditional=null;
	
	public CuentaBancoPunVenLogicAdditional getCuentaBancoPunVenLogicAdditional() {
		return this.cuentabancopunvenLogicAdditional;
	}
	
	public void setCuentaBancoPunVenLogicAdditional(CuentaBancoPunVenLogicAdditional cuentabancopunvenLogicAdditional) {
		try {
			this.cuentabancopunvenLogicAdditional=cuentabancopunvenLogicAdditional;
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
	
	
	
	
	public  CuentaBancoPunVenLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.cuentabancopunvenDataAccess = new CuentaBancoPunVenDataAccess();
			
			this.cuentabancopunvens= new ArrayList<CuentaBancoPunVen>();
			this.cuentabancopunven= new CuentaBancoPunVen();
			
			this.cuentabancopunvenObject=new Object();
			this.cuentabancopunvensObject=new ArrayList<Object>();
				
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
			
			this.cuentabancopunvenDataAccess.setConnexionType(this.connexionType);
			this.cuentabancopunvenDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CuentaBancoPunVenLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.cuentabancopunvenDataAccess = new CuentaBancoPunVenDataAccess();
			this.cuentabancopunvens= new ArrayList<CuentaBancoPunVen>();
			this.cuentabancopunven= new CuentaBancoPunVen();
			this.cuentabancopunvenObject=new Object();
			this.cuentabancopunvensObject=new ArrayList<Object>();
			
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
			
			this.cuentabancopunvenDataAccess.setConnexionType(this.connexionType);
			this.cuentabancopunvenDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CuentaBancoPunVen getCuentaBancoPunVen() throws Exception {	
		CuentaBancoPunVenLogicAdditional.checkCuentaBancoPunVenToGet(cuentabancopunven,this.datosCliente,this.arrDatoGeneral);
		CuentaBancoPunVenLogicAdditional.updateCuentaBancoPunVenToGet(cuentabancopunven,this.arrDatoGeneral);
		
		return cuentabancopunven;
	}
		
	public void setCuentaBancoPunVen(CuentaBancoPunVen newCuentaBancoPunVen) {
		this.cuentabancopunven = newCuentaBancoPunVen;
	}
	
	public CuentaBancoPunVenDataAccess getCuentaBancoPunVenDataAccess() {
		return cuentabancopunvenDataAccess;
	}
	
	public void setCuentaBancoPunVenDataAccess(CuentaBancoPunVenDataAccess newcuentabancopunvenDataAccess) {
		this.cuentabancopunvenDataAccess = newcuentabancopunvenDataAccess;
	}
	
	public List<CuentaBancoPunVen> getCuentaBancoPunVens() throws Exception {		
		this.quitarCuentaBancoPunVensNulos();
		
		CuentaBancoPunVenLogicAdditional.checkCuentaBancoPunVenToGets(cuentabancopunvens,this.datosCliente,this.arrDatoGeneral);
		
		for (CuentaBancoPunVen cuentabancopunvenLocal: cuentabancopunvens ) {
			CuentaBancoPunVenLogicAdditional.updateCuentaBancoPunVenToGet(cuentabancopunvenLocal,this.arrDatoGeneral);
		}
		
		return cuentabancopunvens;
	}
	
	public void setCuentaBancoPunVens(List<CuentaBancoPunVen> newCuentaBancoPunVens) {
		this.cuentabancopunvens = newCuentaBancoPunVens;
	}
	
	public Object getCuentaBancoPunVenObject() {	
		this.cuentabancopunvenObject=this.cuentabancopunvenDataAccess.getEntityObject();
		return this.cuentabancopunvenObject;
	}
		
	public void setCuentaBancoPunVenObject(Object newCuentaBancoPunVenObject) {
		this.cuentabancopunvenObject = newCuentaBancoPunVenObject;
	}
	
	public List<Object> getCuentaBancoPunVensObject() {		
		this.cuentabancopunvensObject=this.cuentabancopunvenDataAccess.getEntitiesObject();
		return this.cuentabancopunvensObject;
	}
		
	public void setCuentaBancoPunVensObject(List<Object> newCuentaBancoPunVensObject) {
		this.cuentabancopunvensObject = newCuentaBancoPunVensObject;
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
		
		if(this.cuentabancopunvenDataAccess!=null) {
			this.cuentabancopunvenDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBancoPunVen.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			cuentabancopunvenDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			cuentabancopunvenDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		cuentabancopunven = new  CuentaBancoPunVen();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBancoPunVen.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cuentabancopunven=cuentabancopunvenDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuentabancopunven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuentaBancoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBancoPunVen(this.cuentabancopunven);
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
		cuentabancopunven = new  CuentaBancoPunVen();
		  		  
        try {
			
			cuentabancopunven=cuentabancopunvenDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuentabancopunven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuentaBancoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBancoPunVen(this.cuentabancopunven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		cuentabancopunven = new  CuentaBancoPunVen();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBancoPunVen.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cuentabancopunven=cuentabancopunvenDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuentabancopunven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuentaBancoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBancoPunVen(this.cuentabancopunven);
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
		cuentabancopunven = new  CuentaBancoPunVen();
		  		  
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
		cuentabancopunven = new  CuentaBancoPunVen();
		  		  
        try {
			
			cuentabancopunven=cuentabancopunvenDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cuentabancopunven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CuentaBancoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBancoPunVen(this.cuentabancopunven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		cuentabancopunven = new  CuentaBancoPunVen();
		  		  
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
		cuentabancopunven = new  CuentaBancoPunVen();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBancoPunVen.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =cuentabancopunvenDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cuentabancopunven = new  CuentaBancoPunVen();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=cuentabancopunvenDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cuentabancopunven = new  CuentaBancoPunVen();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBancoPunVen.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =cuentabancopunvenDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cuentabancopunven = new  CuentaBancoPunVen();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=cuentabancopunvenDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cuentabancopunven = new  CuentaBancoPunVen();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBancoPunVen.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =cuentabancopunvenDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cuentabancopunven = new  CuentaBancoPunVen();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=cuentabancopunvenDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cuentabancopunvens = new  ArrayList<CuentaBancoPunVen>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBancoPunVen.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			CuentaBancoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentabancopunvens=cuentabancopunvenDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaBancoPunVen(cuentabancopunvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaBancoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBancoPunVen(this.cuentabancopunvens);
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
		cuentabancopunvens = new  ArrayList<CuentaBancoPunVen>();
		  		  
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
		cuentabancopunvens = new  ArrayList<CuentaBancoPunVen>();
		  		  
        try {			
			CuentaBancoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentabancopunvens=cuentabancopunvenDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarCuentaBancoPunVen(cuentabancopunvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaBancoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBancoPunVen(this.cuentabancopunvens);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		cuentabancopunvens = new  ArrayList<CuentaBancoPunVen>();
		  		  
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
		cuentabancopunvens = new  ArrayList<CuentaBancoPunVen>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBancoPunVen.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			CuentaBancoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentabancopunvens=cuentabancopunvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaBancoPunVen(cuentabancopunvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaBancoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBancoPunVen(this.cuentabancopunvens);
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
		cuentabancopunvens = new  ArrayList<CuentaBancoPunVen>();
		  		  
        try {
			CuentaBancoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentabancopunvens=cuentabancopunvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaBancoPunVen(cuentabancopunvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaBancoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBancoPunVen(this.cuentabancopunvens);
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
		cuentabancopunvens = new  ArrayList<CuentaBancoPunVen>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBancoPunVen.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaBancoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentabancopunvens=cuentabancopunvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuentaBancoPunVen(cuentabancopunvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaBancoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBancoPunVen(this.cuentabancopunvens);
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
		cuentabancopunvens = new  ArrayList<CuentaBancoPunVen>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaBancoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentabancopunvens=cuentabancopunvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuentaBancoPunVen(cuentabancopunvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaBancoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBancoPunVen(this.cuentabancopunvens);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		cuentabancopunven = new  CuentaBancoPunVen();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBancoPunVen.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaBancoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentabancopunven=cuentabancopunvenDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuentaBancoPunVen(cuentabancopunven);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaBancoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBancoPunVen(this.cuentabancopunven);
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
		cuentabancopunven = new  CuentaBancoPunVen();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaBancoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentabancopunven=cuentabancopunvenDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCuentaBancoPunVen(cuentabancopunven);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaBancoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBancoPunVen(this.cuentabancopunven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cuentabancopunvens = new  ArrayList<CuentaBancoPunVen>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBancoPunVen.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			CuentaBancoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentabancopunvens=cuentabancopunvenDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaBancoPunVen(cuentabancopunvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaBancoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBancoPunVen(this.cuentabancopunvens);
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
		cuentabancopunvens = new  ArrayList<CuentaBancoPunVen>();
		  		  
        try {
			CuentaBancoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentabancopunvens=cuentabancopunvenDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCuentaBancoPunVen(cuentabancopunvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaBancoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBancoPunVen(this.cuentabancopunvens);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosCuentaBancoPunVensWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		cuentabancopunvens = new  ArrayList<CuentaBancoPunVen>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBancoPunVen.class.getSimpleName()+"-getTodosCuentaBancoPunVensWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaBancoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentabancopunvens=cuentabancopunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCuentaBancoPunVen(cuentabancopunvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaBancoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBancoPunVen(this.cuentabancopunvens);
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
	
	public  void  getTodosCuentaBancoPunVens(String sFinalQuery,Pagination pagination)throws Exception {
		cuentabancopunvens = new  ArrayList<CuentaBancoPunVen>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CuentaBancoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cuentabancopunvens=cuentabancopunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCuentaBancoPunVen(cuentabancopunvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CuentaBancoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBancoPunVen(this.cuentabancopunvens);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarCuentaBancoPunVen(CuentaBancoPunVen cuentabancopunven) throws Exception {
		Boolean estaValidado=false;
		
		if(cuentabancopunven.getIsNew() || cuentabancopunven.getIsChanged()) { 
			this.invalidValues = cuentabancopunvenValidator.getInvalidValues(cuentabancopunven);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(cuentabancopunven);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarCuentaBancoPunVen(List<CuentaBancoPunVen> CuentaBancoPunVens) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(CuentaBancoPunVen cuentabancopunvenLocal:cuentabancopunvens) {				
			estaValidadoObjeto=this.validarGuardarCuentaBancoPunVen(cuentabancopunvenLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarCuentaBancoPunVen(List<CuentaBancoPunVen> CuentaBancoPunVens) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCuentaBancoPunVen(cuentabancopunvens)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarCuentaBancoPunVen(CuentaBancoPunVen CuentaBancoPunVen) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCuentaBancoPunVen(cuentabancopunven)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(CuentaBancoPunVen cuentabancopunven) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+cuentabancopunven.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=CuentaBancoPunVenConstantesFunciones.getCuentaBancoPunVenLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"cuentabancopunven","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(CuentaBancoPunVenConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(CuentaBancoPunVenConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveCuentaBancoPunVenWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBancoPunVen.class.getSimpleName()+"-saveCuentaBancoPunVenWithConnection");connexion.begin();			
			
			CuentaBancoPunVenLogicAdditional.checkCuentaBancoPunVenToSave(this.cuentabancopunven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CuentaBancoPunVenLogicAdditional.updateCuentaBancoPunVenToSave(this.cuentabancopunven,this.arrDatoGeneral);
			
			CuentaBancoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cuentabancopunven,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowCuentaBancoPunVen();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCuentaBancoPunVen(this.cuentabancopunven)) {
				CuentaBancoPunVenDataAccess.save(this.cuentabancopunven, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.cuentabancopunven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CuentaBancoPunVenLogicAdditional.checkCuentaBancoPunVenToSaveAfter(this.cuentabancopunven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCuentaBancoPunVen();
			
			connexion.commit();			
			
			if(this.cuentabancopunven.getIsDeleted()) {
				this.cuentabancopunven=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveCuentaBancoPunVen()throws Exception {	
		try {	
			
			CuentaBancoPunVenLogicAdditional.checkCuentaBancoPunVenToSave(this.cuentabancopunven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CuentaBancoPunVenLogicAdditional.updateCuentaBancoPunVenToSave(this.cuentabancopunven,this.arrDatoGeneral);
			
			CuentaBancoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cuentabancopunven,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCuentaBancoPunVen(this.cuentabancopunven)) {			
				CuentaBancoPunVenDataAccess.save(this.cuentabancopunven, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.cuentabancopunven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CuentaBancoPunVenLogicAdditional.checkCuentaBancoPunVenToSaveAfter(this.cuentabancopunven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.cuentabancopunven.getIsDeleted()) {
				this.cuentabancopunven=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveCuentaBancoPunVensWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBancoPunVen.class.getSimpleName()+"-saveCuentaBancoPunVensWithConnection");connexion.begin();			
			
			CuentaBancoPunVenLogicAdditional.checkCuentaBancoPunVenToSaves(cuentabancopunvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowCuentaBancoPunVens();
			
			Boolean validadoTodosCuentaBancoPunVen=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CuentaBancoPunVen cuentabancopunvenLocal:cuentabancopunvens) {		
				if(cuentabancopunvenLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CuentaBancoPunVenLogicAdditional.updateCuentaBancoPunVenToSave(cuentabancopunvenLocal,this.arrDatoGeneral);
	        	
				CuentaBancoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cuentabancopunvenLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCuentaBancoPunVen(cuentabancopunvenLocal)) {
					CuentaBancoPunVenDataAccess.save(cuentabancopunvenLocal, connexion);				
				} else {
					validadoTodosCuentaBancoPunVen=false;
				}
			}
			
			if(!validadoTodosCuentaBancoPunVen) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CuentaBancoPunVenLogicAdditional.checkCuentaBancoPunVenToSavesAfter(cuentabancopunvens,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCuentaBancoPunVens();
			
			connexion.commit();		
			
			this.quitarCuentaBancoPunVensEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveCuentaBancoPunVens()throws Exception {				
		 try {	
			CuentaBancoPunVenLogicAdditional.checkCuentaBancoPunVenToSaves(cuentabancopunvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosCuentaBancoPunVen=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CuentaBancoPunVen cuentabancopunvenLocal:cuentabancopunvens) {				
				if(cuentabancopunvenLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CuentaBancoPunVenLogicAdditional.updateCuentaBancoPunVenToSave(cuentabancopunvenLocal,this.arrDatoGeneral);
	        	
				CuentaBancoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cuentabancopunvenLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCuentaBancoPunVen(cuentabancopunvenLocal)) {				
					CuentaBancoPunVenDataAccess.save(cuentabancopunvenLocal, connexion);				
				} else {
					validadoTodosCuentaBancoPunVen=false;
				}
			}
			
			if(!validadoTodosCuentaBancoPunVen) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CuentaBancoPunVenLogicAdditional.checkCuentaBancoPunVenToSavesAfter(cuentabancopunvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarCuentaBancoPunVensEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CuentaBancoPunVenParameterReturnGeneral procesarAccionCuentaBancoPunVens(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CuentaBancoPunVen> cuentabancopunvens,CuentaBancoPunVenParameterReturnGeneral cuentabancopunvenParameterGeneral)throws Exception {
		 try {	
			CuentaBancoPunVenParameterReturnGeneral cuentabancopunvenReturnGeneral=new CuentaBancoPunVenParameterReturnGeneral();
	
			CuentaBancoPunVenLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cuentabancopunvens,cuentabancopunvenParameterGeneral,cuentabancopunvenReturnGeneral);
			
			return cuentabancopunvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CuentaBancoPunVenParameterReturnGeneral procesarAccionCuentaBancoPunVensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CuentaBancoPunVen> cuentabancopunvens,CuentaBancoPunVenParameterReturnGeneral cuentabancopunvenParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBancoPunVen.class.getSimpleName()+"-procesarAccionCuentaBancoPunVensWithConnection");connexion.begin();			
			
			CuentaBancoPunVenParameterReturnGeneral cuentabancopunvenReturnGeneral=new CuentaBancoPunVenParameterReturnGeneral();
	
			CuentaBancoPunVenLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cuentabancopunvens,cuentabancopunvenParameterGeneral,cuentabancopunvenReturnGeneral);
			
			this.connexion.commit();
			
			return cuentabancopunvenReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CuentaBancoPunVenParameterReturnGeneral procesarEventosCuentaBancoPunVens(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CuentaBancoPunVen> cuentabancopunvens,CuentaBancoPunVen cuentabancopunven,CuentaBancoPunVenParameterReturnGeneral cuentabancopunvenParameterGeneral,Boolean isEsNuevoCuentaBancoPunVen,ArrayList<Classe> clases)throws Exception {
		 try {	
			CuentaBancoPunVenParameterReturnGeneral cuentabancopunvenReturnGeneral=new CuentaBancoPunVenParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cuentabancopunvenReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CuentaBancoPunVenLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cuentabancopunvens,cuentabancopunven,cuentabancopunvenParameterGeneral,cuentabancopunvenReturnGeneral,isEsNuevoCuentaBancoPunVen,clases);
			
			return cuentabancopunvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public CuentaBancoPunVenParameterReturnGeneral procesarEventosCuentaBancoPunVensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CuentaBancoPunVen> cuentabancopunvens,CuentaBancoPunVen cuentabancopunven,CuentaBancoPunVenParameterReturnGeneral cuentabancopunvenParameterGeneral,Boolean isEsNuevoCuentaBancoPunVen,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBancoPunVen.class.getSimpleName()+"-procesarEventosCuentaBancoPunVensWithConnection");connexion.begin();			
			
			CuentaBancoPunVenParameterReturnGeneral cuentabancopunvenReturnGeneral=new CuentaBancoPunVenParameterReturnGeneral();
	
			cuentabancopunvenReturnGeneral.setCuentaBancoPunVen(cuentabancopunven);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cuentabancopunvenReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CuentaBancoPunVenLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cuentabancopunvens,cuentabancopunven,cuentabancopunvenParameterGeneral,cuentabancopunvenReturnGeneral,isEsNuevoCuentaBancoPunVen,clases);
			
			this.connexion.commit();
			
			return cuentabancopunvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CuentaBancoPunVenParameterReturnGeneral procesarImportacionCuentaBancoPunVensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,CuentaBancoPunVenParameterReturnGeneral cuentabancopunvenParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBancoPunVen.class.getSimpleName()+"-procesarImportacionCuentaBancoPunVensWithConnection");connexion.begin();			
			
			CuentaBancoPunVenParameterReturnGeneral cuentabancopunvenReturnGeneral=new CuentaBancoPunVenParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.cuentabancopunvens=new ArrayList<CuentaBancoPunVen>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.cuentabancopunven=new CuentaBancoPunVen();
				
				
				if(conColumnasBase) {this.cuentabancopunven.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.cuentabancopunven.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.cuentabancopunven.setcodigo(arrColumnas[iColumn++]);
				this.cuentabancopunven.setnombre(arrColumnas[iColumn++]);
				
				this.cuentabancopunvens.add(this.cuentabancopunven);
			}
			
			this.saveCuentaBancoPunVens();
			
			this.connexion.commit();
			
			cuentabancopunvenReturnGeneral.setConRetornoEstaProcesado(true);
			cuentabancopunvenReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return cuentabancopunvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarCuentaBancoPunVensEliminados() throws Exception {				
		
		List<CuentaBancoPunVen> cuentabancopunvensAux= new ArrayList<CuentaBancoPunVen>();
		
		for(CuentaBancoPunVen cuentabancopunven:cuentabancopunvens) {
			if(!cuentabancopunven.getIsDeleted()) {
				cuentabancopunvensAux.add(cuentabancopunven);
			}
		}
		
		cuentabancopunvens=cuentabancopunvensAux;
	}
	
	public void quitarCuentaBancoPunVensNulos() throws Exception {				
		
		List<CuentaBancoPunVen> cuentabancopunvensAux= new ArrayList<CuentaBancoPunVen>();
		
		for(CuentaBancoPunVen cuentabancopunven : this.cuentabancopunvens) {
			if(cuentabancopunven==null) {
				cuentabancopunvensAux.add(cuentabancopunven);
			}
		}
		
		//this.cuentabancopunvens=cuentabancopunvensAux;
		
		this.cuentabancopunvens.removeAll(cuentabancopunvensAux);
	}
	
	public void getSetVersionRowCuentaBancoPunVenWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(cuentabancopunven.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((cuentabancopunven.getIsDeleted() || (cuentabancopunven.getIsChanged()&&!cuentabancopunven.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=cuentabancopunvenDataAccess.getSetVersionRowCuentaBancoPunVen(connexion,cuentabancopunven.getId());
				
				if(!cuentabancopunven.getVersionRow().equals(timestamp)) {	
					cuentabancopunven.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				cuentabancopunven.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowCuentaBancoPunVen()throws Exception {	
		
		if(cuentabancopunven.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((cuentabancopunven.getIsDeleted() || (cuentabancopunven.getIsChanged()&&!cuentabancopunven.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=cuentabancopunvenDataAccess.getSetVersionRowCuentaBancoPunVen(connexion,cuentabancopunven.getId());
			
			try {							
				if(!cuentabancopunven.getVersionRow().equals(timestamp)) {	
					cuentabancopunven.setVersionRow(timestamp);
				}
				
				cuentabancopunven.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowCuentaBancoPunVensWithConnection()throws Exception {	
		if(cuentabancopunvens!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(CuentaBancoPunVen cuentabancopunvenAux:cuentabancopunvens) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(cuentabancopunvenAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cuentabancopunvenAux.getIsDeleted() || (cuentabancopunvenAux.getIsChanged()&&!cuentabancopunvenAux.getIsNew())) {
						
						timestamp=cuentabancopunvenDataAccess.getSetVersionRowCuentaBancoPunVen(connexion,cuentabancopunvenAux.getId());
						
						if(!cuentabancopunven.getVersionRow().equals(timestamp)) {	
							cuentabancopunvenAux.setVersionRow(timestamp);
						}
								
						cuentabancopunvenAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowCuentaBancoPunVens()throws Exception {	
		if(cuentabancopunvens!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(CuentaBancoPunVen cuentabancopunvenAux:cuentabancopunvens) {
					if(cuentabancopunvenAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cuentabancopunvenAux.getIsDeleted() || (cuentabancopunvenAux.getIsChanged()&&!cuentabancopunvenAux.getIsNew())) {
						
						timestamp=cuentabancopunvenDataAccess.getSetVersionRowCuentaBancoPunVen(connexion,cuentabancopunvenAux.getId());
						
						if(!cuentabancopunvenAux.getVersionRow().equals(timestamp)) {	
							cuentabancopunvenAux.setVersionRow(timestamp);
						}
						
													
						cuentabancopunvenAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public CuentaBancoPunVenParameterReturnGeneral cargarCombosLoteForeignKeyCuentaBancoPunVenWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBanco,String finalQueryGlobalCliente,String finalQueryGlobalCuentaContable) throws Exception {
		CuentaBancoPunVenParameterReturnGeneral  cuentabancopunvenReturnGeneral =new CuentaBancoPunVenParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBancoPunVen.class.getSimpleName()+"-cargarCombosLoteForeignKeyCuentaBancoPunVenWithConnection");connexion.begin();
			
			cuentabancopunvenReturnGeneral =new CuentaBancoPunVenParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cuentabancopunvenReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			cuentabancopunvenReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Banco> bancosForeignKey=new ArrayList<Banco>();
			BancoLogic bancoLogic=new BancoLogic();
			bancoLogic.setConnexion(this.connexion);
			bancoLogic.getBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBanco.equals("NONE")) {
				bancoLogic.getTodosBancos(finalQueryGlobalBanco,new Pagination());
				bancosForeignKey=bancoLogic.getBancos();
			}

			cuentabancopunvenReturnGeneral.setbancosForeignKey(bancosForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			cuentabancopunvenReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			cuentabancopunvenReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return cuentabancopunvenReturnGeneral;
	}
	
	public CuentaBancoPunVenParameterReturnGeneral cargarCombosLoteForeignKeyCuentaBancoPunVen(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalBanco,String finalQueryGlobalCliente,String finalQueryGlobalCuentaContable) throws Exception {
		CuentaBancoPunVenParameterReturnGeneral  cuentabancopunvenReturnGeneral =new CuentaBancoPunVenParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			cuentabancopunvenReturnGeneral =new CuentaBancoPunVenParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cuentabancopunvenReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			cuentabancopunvenReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Banco> bancosForeignKey=new ArrayList<Banco>();
			BancoLogic bancoLogic=new BancoLogic();
			bancoLogic.setConnexion(this.connexion);
			bancoLogic.getBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBanco.equals("NONE")) {
				bancoLogic.getTodosBancos(finalQueryGlobalBanco,new Pagination());
				bancosForeignKey=bancoLogic.getBancos();
			}

			cuentabancopunvenReturnGeneral.setbancosForeignKey(bancosForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			cuentabancopunvenReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			cuentabancopunvenReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return cuentabancopunvenReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyCuentaBancoPunVenWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			FormaPagoPuntoVentaLogic formapagopuntoventaLogic=new FormaPagoPuntoVentaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBancoPunVen.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyCuentaBancoPunVenWithConnection");connexion.begin();
			
			
			classes.add(new Classe(FormaPagoPuntoVenta.class));
											
			

			formapagopuntoventaLogic.setConnexion(this.getConnexion());
			formapagopuntoventaLogic.setDatosCliente(this.datosCliente);
			formapagopuntoventaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(CuentaBancoPunVen cuentabancopunven:this.cuentabancopunvens) {
				

				classes=new ArrayList<Classe>();
				classes=FormaPagoPuntoVentaConstantesFunciones.getClassesForeignKeysOfFormaPagoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);

				formapagopuntoventaLogic.setFormaPagoPuntoVentas(cuentabancopunven.formapagopuntoventas);
				formapagopuntoventaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(CuentaBancoPunVen cuentabancopunven,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CuentaBancoPunVenLogicAdditional.updateCuentaBancoPunVenToGet(cuentabancopunven,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cuentabancopunven.setEmpresa(cuentabancopunvenDataAccess.getEmpresa(connexion,cuentabancopunven));
		cuentabancopunven.setSucursal(cuentabancopunvenDataAccess.getSucursal(connexion,cuentabancopunven));
		cuentabancopunven.setBanco(cuentabancopunvenDataAccess.getBanco(connexion,cuentabancopunven));
		cuentabancopunven.setCliente(cuentabancopunvenDataAccess.getCliente(connexion,cuentabancopunven));
		cuentabancopunven.setCuentaContable(cuentabancopunvenDataAccess.getCuentaContable(connexion,cuentabancopunven));
		cuentabancopunven.setFormaPagoPuntoVentas(cuentabancopunvenDataAccess.getFormaPagoPuntoVentas(connexion,cuentabancopunven));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cuentabancopunven.setEmpresa(cuentabancopunvenDataAccess.getEmpresa(connexion,cuentabancopunven));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				cuentabancopunven.setSucursal(cuentabancopunvenDataAccess.getSucursal(connexion,cuentabancopunven));
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				cuentabancopunven.setBanco(cuentabancopunvenDataAccess.getBanco(connexion,cuentabancopunven));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				cuentabancopunven.setCliente(cuentabancopunvenDataAccess.getCliente(connexion,cuentabancopunven));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentabancopunven.setCuentaContable(cuentabancopunvenDataAccess.getCuentaContable(connexion,cuentabancopunven));
				continue;
			}

			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cuentabancopunven.setFormaPagoPuntoVentas(cuentabancopunvenDataAccess.getFormaPagoPuntoVentas(connexion,cuentabancopunven));

				if(this.isConDeep) {
					FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(this.connexion);
					formapagopuntoventaLogic.setFormaPagoPuntoVentas(cuentabancopunven.getFormaPagoPuntoVentas());
					ArrayList<Classe> classesLocal=FormaPagoPuntoVentaConstantesFunciones.getClassesForeignKeysOfFormaPagoPuntoVenta(new ArrayList<Classe>(),DeepLoadType.NONE);
					formapagopuntoventaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(formapagopuntoventaLogic.getFormaPagoPuntoVentas());
					cuentabancopunven.setFormaPagoPuntoVentas(formapagopuntoventaLogic.getFormaPagoPuntoVentas());
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
			cuentabancopunven.setEmpresa(cuentabancopunvenDataAccess.getEmpresa(connexion,cuentabancopunven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentabancopunven.setSucursal(cuentabancopunvenDataAccess.getSucursal(connexion,cuentabancopunven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Banco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentabancopunven.setBanco(cuentabancopunvenDataAccess.getBanco(connexion,cuentabancopunven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentabancopunven.setCliente(cuentabancopunvenDataAccess.getCliente(connexion,cuentabancopunven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentabancopunven.setCuentaContable(cuentabancopunvenDataAccess.getCuentaContable(connexion,cuentabancopunven));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormaPagoPuntoVenta.class));
			cuentabancopunven.setFormaPagoPuntoVentas(cuentabancopunvenDataAccess.getFormaPagoPuntoVentas(connexion,cuentabancopunven));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cuentabancopunven.setEmpresa(cuentabancopunvenDataAccess.getEmpresa(connexion,cuentabancopunven));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cuentabancopunven.getEmpresa(),isDeep,deepLoadType,clases);
				
		cuentabancopunven.setSucursal(cuentabancopunvenDataAccess.getSucursal(connexion,cuentabancopunven));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(cuentabancopunven.getSucursal(),isDeep,deepLoadType,clases);
				
		cuentabancopunven.setBanco(cuentabancopunvenDataAccess.getBanco(connexion,cuentabancopunven));
		BancoLogic bancoLogic= new BancoLogic(connexion);
		bancoLogic.deepLoad(cuentabancopunven.getBanco(),isDeep,deepLoadType,clases);
				
		cuentabancopunven.setCliente(cuentabancopunvenDataAccess.getCliente(connexion,cuentabancopunven));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(cuentabancopunven.getCliente(),isDeep,deepLoadType,clases);
				
		cuentabancopunven.setCuentaContable(cuentabancopunvenDataAccess.getCuentaContable(connexion,cuentabancopunven));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(cuentabancopunven.getCuentaContable(),isDeep,deepLoadType,clases);
				

		cuentabancopunven.setFormaPagoPuntoVentas(cuentabancopunvenDataAccess.getFormaPagoPuntoVentas(connexion,cuentabancopunven));

		for(FormaPagoPuntoVenta formapagopuntoventa:cuentabancopunven.getFormaPagoPuntoVentas()) {
			FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(connexion);
			formapagopuntoventaLogic.deepLoad(formapagopuntoventa,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				cuentabancopunven.setEmpresa(cuentabancopunvenDataAccess.getEmpresa(connexion,cuentabancopunven));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(cuentabancopunven.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				cuentabancopunven.setSucursal(cuentabancopunvenDataAccess.getSucursal(connexion,cuentabancopunven));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(cuentabancopunven.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				cuentabancopunven.setBanco(cuentabancopunvenDataAccess.getBanco(connexion,cuentabancopunven));
				BancoLogic bancoLogic= new BancoLogic(connexion);
				bancoLogic.deepLoad(cuentabancopunven.getBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				cuentabancopunven.setCliente(cuentabancopunvenDataAccess.getCliente(connexion,cuentabancopunven));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(cuentabancopunven.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				cuentabancopunven.setCuentaContable(cuentabancopunvenDataAccess.getCuentaContable(connexion,cuentabancopunven));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(cuentabancopunven.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				cuentabancopunven.setFormaPagoPuntoVentas(cuentabancopunvenDataAccess.getFormaPagoPuntoVentas(connexion,cuentabancopunven));

				for(FormaPagoPuntoVenta formapagopuntoventa:cuentabancopunven.getFormaPagoPuntoVentas()) {
					FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(connexion);
					formapagopuntoventaLogic.deepLoad(formapagopuntoventa,isDeep,deepLoadType,clases);
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
			cuentabancopunven.setEmpresa(cuentabancopunvenDataAccess.getEmpresa(connexion,cuentabancopunven));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(cuentabancopunven.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentabancopunven.setSucursal(cuentabancopunvenDataAccess.getSucursal(connexion,cuentabancopunven));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(cuentabancopunven.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Banco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentabancopunven.setBanco(cuentabancopunvenDataAccess.getBanco(connexion,cuentabancopunven));
			BancoLogic bancoLogic= new BancoLogic(connexion);
			bancoLogic.deepLoad(cuentabancopunven.getBanco(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentabancopunven.setCliente(cuentabancopunvenDataAccess.getCliente(connexion,cuentabancopunven));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(cuentabancopunven.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cuentabancopunven.setCuentaContable(cuentabancopunvenDataAccess.getCuentaContable(connexion,cuentabancopunven));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(cuentabancopunven.getCuentaContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormaPagoPuntoVenta.class));
			cuentabancopunven.setFormaPagoPuntoVentas(cuentabancopunvenDataAccess.getFormaPagoPuntoVentas(connexion,cuentabancopunven));

			for(FormaPagoPuntoVenta formapagopuntoventa:cuentabancopunven.getFormaPagoPuntoVentas()) {
				FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(connexion);
				formapagopuntoventaLogic.deepLoad(formapagopuntoventa,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(CuentaBancoPunVen cuentabancopunven,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			CuentaBancoPunVenLogicAdditional.updateCuentaBancoPunVenToSave(cuentabancopunven,this.arrDatoGeneral);
			
CuentaBancoPunVenDataAccess.save(cuentabancopunven, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(cuentabancopunven.getEmpresa(),connexion);

		SucursalDataAccess.save(cuentabancopunven.getSucursal(),connexion);

		BancoDataAccess.save(cuentabancopunven.getBanco(),connexion);

		ClienteDataAccess.save(cuentabancopunven.getCliente(),connexion);

		CuentaContableDataAccess.save(cuentabancopunven.getCuentaContable(),connexion);

		for(FormaPagoPuntoVenta formapagopuntoventa:cuentabancopunven.getFormaPagoPuntoVentas()) {
			formapagopuntoventa.setid_cuenta_banco_pun_ven(cuentabancopunven.getId());
			FormaPagoPuntoVentaDataAccess.save(formapagopuntoventa,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cuentabancopunven.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(cuentabancopunven.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				BancoDataAccess.save(cuentabancopunven.getBanco(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(cuentabancopunven.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentabancopunven.getCuentaContable(),connexion);
				continue;
			}


			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormaPagoPuntoVenta formapagopuntoventa:cuentabancopunven.getFormaPagoPuntoVentas()) {
					formapagopuntoventa.setid_cuenta_banco_pun_ven(cuentabancopunven.getId());
					FormaPagoPuntoVentaDataAccess.save(formapagopuntoventa,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(cuentabancopunven.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cuentabancopunven.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(cuentabancopunven.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(cuentabancopunven.getSucursal(),isDeep,deepLoadType,clases);
				

		BancoDataAccess.save(cuentabancopunven.getBanco(),connexion);
		BancoLogic bancoLogic= new BancoLogic(connexion);
		bancoLogic.deepLoad(cuentabancopunven.getBanco(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(cuentabancopunven.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(cuentabancopunven.getCliente(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(cuentabancopunven.getCuentaContable(),connexion);
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(cuentabancopunven.getCuentaContable(),isDeep,deepLoadType,clases);
				

		for(FormaPagoPuntoVenta formapagopuntoventa:cuentabancopunven.getFormaPagoPuntoVentas()) {
			FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(connexion);
			formapagopuntoventa.setid_cuenta_banco_pun_ven(cuentabancopunven.getId());
			FormaPagoPuntoVentaDataAccess.save(formapagopuntoventa,connexion);
			formapagopuntoventaLogic.deepSave(formapagopuntoventa,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cuentabancopunven.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(cuentabancopunven.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(cuentabancopunven.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(cuentabancopunven.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				BancoDataAccess.save(cuentabancopunven.getBanco(),connexion);
				BancoLogic bancoLogic= new BancoLogic(connexion);
				bancoLogic.deepSave(cuentabancopunven.getBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(cuentabancopunven.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(cuentabancopunven.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(cuentabancopunven.getCuentaContable(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(cuentabancopunven.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(FormaPagoPuntoVenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormaPagoPuntoVenta formapagopuntoventa:cuentabancopunven.getFormaPagoPuntoVentas()) {
					FormaPagoPuntoVentaLogic formapagopuntoventaLogic= new FormaPagoPuntoVentaLogic(connexion);
					formapagopuntoventa.setid_cuenta_banco_pun_ven(cuentabancopunven.getId());
					FormaPagoPuntoVentaDataAccess.save(formapagopuntoventa,connexion);
					formapagopuntoventaLogic.deepSave(formapagopuntoventa,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(CuentaBancoPunVen.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(cuentabancopunven,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CuentaBancoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBancoPunVen(cuentabancopunven);
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
			this.deepLoad(this.cuentabancopunven,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CuentaBancoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBancoPunVen(this.cuentabancopunven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(CuentaBancoPunVen.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(cuentabancopunvens!=null) {
				for(CuentaBancoPunVen cuentabancopunven:cuentabancopunvens) {
					this.deepLoad(cuentabancopunven,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CuentaBancoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBancoPunVen(cuentabancopunvens);
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
			if(cuentabancopunvens!=null) {
				for(CuentaBancoPunVen cuentabancopunven:cuentabancopunvens) {
					this.deepLoad(cuentabancopunven,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CuentaBancoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBancoPunVen(cuentabancopunvens);
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
			this.getNewConnexionToDeep(CuentaBancoPunVen.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(cuentabancopunven,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(CuentaBancoPunVen.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(cuentabancopunvens!=null) {
				for(CuentaBancoPunVen cuentabancopunven:cuentabancopunvens) {
					this.deepSave(cuentabancopunven,isDeep,deepLoadType,clases);
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
			if(cuentabancopunvens!=null) {
				for(CuentaBancoPunVen cuentabancopunven:cuentabancopunvens) {
					this.deepSave(cuentabancopunven,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getCuentaBancoPunVensFK_IdBancoWithConnection(String sFinalQuery,Pagination pagination,Long id_banco)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBancoPunVen.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_banco,CuentaBancoPunVenConstantesFunciones.IDBANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBanco);

			CuentaBancoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancopunvens=cuentabancopunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBancoPunVen(this.cuentabancopunvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaBancoPunVensFK_IdBanco(String sFinalQuery,Pagination pagination,Long id_banco)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_banco,CuentaBancoPunVenConstantesFunciones.IDBANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBanco);

			CuentaBancoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancopunvens=cuentabancopunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBancoPunVen(this.cuentabancopunvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaBancoPunVensFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBancoPunVen.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,CuentaBancoPunVenConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			CuentaBancoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancopunvens=cuentabancopunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBancoPunVen(this.cuentabancopunvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaBancoPunVensFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,CuentaBancoPunVenConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			CuentaBancoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancopunvens=cuentabancopunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBancoPunVen(this.cuentabancopunvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaBancoPunVensFK_IdCuentaContableWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBancoPunVen.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,CuentaBancoPunVenConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			CuentaBancoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancopunvens=cuentabancopunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBancoPunVen(this.cuentabancopunvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaBancoPunVensFK_IdCuentaContable(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,CuentaBancoPunVenConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			CuentaBancoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancopunvens=cuentabancopunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBancoPunVen(this.cuentabancopunvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaBancoPunVensFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBancoPunVen.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CuentaBancoPunVenConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CuentaBancoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancopunvens=cuentabancopunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBancoPunVen(this.cuentabancopunvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaBancoPunVensFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CuentaBancoPunVenConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CuentaBancoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancopunvens=cuentabancopunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBancoPunVen(this.cuentabancopunvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCuentaBancoPunVensFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CuentaBancoPunVen.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,CuentaBancoPunVenConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			CuentaBancoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancopunvens=cuentabancopunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBancoPunVen(this.cuentabancopunvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCuentaBancoPunVensFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,CuentaBancoPunVenConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			CuentaBancoPunVenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cuentabancopunvens=cuentabancopunvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CuentaBancoPunVenConstantesFunciones.refrescarForeignKeysDescripcionesCuentaBancoPunVen(this.cuentabancopunvens);
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
			if(CuentaBancoPunVenConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,CuentaBancoPunVenDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,CuentaBancoPunVen cuentabancopunven,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(CuentaBancoPunVenConstantesFunciones.ISCONAUDITORIA) {
				if(cuentabancopunven.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CuentaBancoPunVenDataAccess.TABLENAME, cuentabancopunven.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CuentaBancoPunVenConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CuentaBancoPunVenLogic.registrarAuditoriaDetallesCuentaBancoPunVen(connexion,cuentabancopunven,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(cuentabancopunven.getIsDeleted()) {
					/*if(!cuentabancopunven.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,CuentaBancoPunVenDataAccess.TABLENAME, cuentabancopunven.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////CuentaBancoPunVenLogic.registrarAuditoriaDetallesCuentaBancoPunVen(connexion,cuentabancopunven,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CuentaBancoPunVenDataAccess.TABLENAME, cuentabancopunven.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(cuentabancopunven.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CuentaBancoPunVenDataAccess.TABLENAME, cuentabancopunven.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CuentaBancoPunVenConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CuentaBancoPunVenLogic.registrarAuditoriaDetallesCuentaBancoPunVen(connexion,cuentabancopunven,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesCuentaBancoPunVen(Connexion connexion,CuentaBancoPunVen cuentabancopunven)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(cuentabancopunven.getIsNew()||!cuentabancopunven.getid_empresa().equals(cuentabancopunven.getCuentaBancoPunVenOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentabancopunven.getCuentaBancoPunVenOriginal().getid_empresa()!=null)
				{
					strValorActual=cuentabancopunven.getCuentaBancoPunVenOriginal().getid_empresa().toString();
				}
				if(cuentabancopunven.getid_empresa()!=null)
				{
					strValorNuevo=cuentabancopunven.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaBancoPunVenConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(cuentabancopunven.getIsNew()||!cuentabancopunven.getid_sucursal().equals(cuentabancopunven.getCuentaBancoPunVenOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentabancopunven.getCuentaBancoPunVenOriginal().getid_sucursal()!=null)
				{
					strValorActual=cuentabancopunven.getCuentaBancoPunVenOriginal().getid_sucursal().toString();
				}
				if(cuentabancopunven.getid_sucursal()!=null)
				{
					strValorNuevo=cuentabancopunven.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaBancoPunVenConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(cuentabancopunven.getIsNew()||!cuentabancopunven.getid_banco().equals(cuentabancopunven.getCuentaBancoPunVenOriginal().getid_banco()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentabancopunven.getCuentaBancoPunVenOriginal().getid_banco()!=null)
				{
					strValorActual=cuentabancopunven.getCuentaBancoPunVenOriginal().getid_banco().toString();
				}
				if(cuentabancopunven.getid_banco()!=null)
				{
					strValorNuevo=cuentabancopunven.getid_banco().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaBancoPunVenConstantesFunciones.IDBANCO,strValorActual,strValorNuevo);
			}	
			
			if(cuentabancopunven.getIsNew()||!cuentabancopunven.getid_cliente().equals(cuentabancopunven.getCuentaBancoPunVenOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentabancopunven.getCuentaBancoPunVenOriginal().getid_cliente()!=null)
				{
					strValorActual=cuentabancopunven.getCuentaBancoPunVenOriginal().getid_cliente().toString();
				}
				if(cuentabancopunven.getid_cliente()!=null)
				{
					strValorNuevo=cuentabancopunven.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaBancoPunVenConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(cuentabancopunven.getIsNew()||!cuentabancopunven.getid_cuenta_contable().equals(cuentabancopunven.getCuentaBancoPunVenOriginal().getid_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentabancopunven.getCuentaBancoPunVenOriginal().getid_cuenta_contable()!=null)
				{
					strValorActual=cuentabancopunven.getCuentaBancoPunVenOriginal().getid_cuenta_contable().toString();
				}
				if(cuentabancopunven.getid_cuenta_contable()!=null)
				{
					strValorNuevo=cuentabancopunven.getid_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaBancoPunVenConstantesFunciones.IDCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(cuentabancopunven.getIsNew()||!cuentabancopunven.getcodigo().equals(cuentabancopunven.getCuentaBancoPunVenOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentabancopunven.getCuentaBancoPunVenOriginal().getcodigo()!=null)
				{
					strValorActual=cuentabancopunven.getCuentaBancoPunVenOriginal().getcodigo();
				}
				if(cuentabancopunven.getcodigo()!=null)
				{
					strValorNuevo=cuentabancopunven.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaBancoPunVenConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(cuentabancopunven.getIsNew()||!cuentabancopunven.getnombre().equals(cuentabancopunven.getCuentaBancoPunVenOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cuentabancopunven.getCuentaBancoPunVenOriginal().getnombre()!=null)
				{
					strValorActual=cuentabancopunven.getCuentaBancoPunVenOriginal().getnombre();
				}
				if(cuentabancopunven.getnombre()!=null)
				{
					strValorNuevo=cuentabancopunven.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CuentaBancoPunVenConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveCuentaBancoPunVenRelacionesWithConnection(CuentaBancoPunVen cuentabancopunven,List<FormaPagoPuntoVenta> formapagopuntoventas) throws Exception {

		if(!cuentabancopunven.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCuentaBancoPunVenRelacionesBase(cuentabancopunven,formapagopuntoventas,true);
		}
	}

	public void saveCuentaBancoPunVenRelaciones(CuentaBancoPunVen cuentabancopunven,List<FormaPagoPuntoVenta> formapagopuntoventas)throws Exception {

		if(!cuentabancopunven.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCuentaBancoPunVenRelacionesBase(cuentabancopunven,formapagopuntoventas,false);
		}
	}

	public void saveCuentaBancoPunVenRelacionesBase(CuentaBancoPunVen cuentabancopunven,List<FormaPagoPuntoVenta> formapagopuntoventas,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("CuentaBancoPunVen-saveRelacionesWithConnection");}
	
			cuentabancopunven.setFormaPagoPuntoVentas(formapagopuntoventas);

			this.setCuentaBancoPunVen(cuentabancopunven);

			if(CuentaBancoPunVenLogicAdditional.validarSaveRelaciones(cuentabancopunven,this)) {

				CuentaBancoPunVenLogicAdditional.updateRelacionesToSave(cuentabancopunven,this);

				if((cuentabancopunven.getIsNew()||cuentabancopunven.getIsChanged())&&!cuentabancopunven.getIsDeleted()) {
					this.saveCuentaBancoPunVen();
					this.saveCuentaBancoPunVenRelacionesDetalles(formapagopuntoventas);

				} else if(cuentabancopunven.getIsDeleted()) {
					this.saveCuentaBancoPunVenRelacionesDetalles(formapagopuntoventas);
					this.saveCuentaBancoPunVen();
				}

				CuentaBancoPunVenLogicAdditional.updateRelacionesToSaveAfter(cuentabancopunven,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			FormaPagoPuntoVentaConstantesFunciones.InicializarGeneralEntityAuxiliaresFormaPagoPuntoVentas(formapagopuntoventas,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveCuentaBancoPunVenRelacionesDetalles(List<FormaPagoPuntoVenta> formapagopuntoventas)throws Exception {
		try {
	

			Long idCuentaBancoPunVenActual=this.getCuentaBancoPunVen().getId();

			FormaPagoPuntoVentaLogic formapagopuntoventaLogic_Desde_CuentaBancoPunVen=new FormaPagoPuntoVentaLogic();
			formapagopuntoventaLogic_Desde_CuentaBancoPunVen.setFormaPagoPuntoVentas(formapagopuntoventas);

			formapagopuntoventaLogic_Desde_CuentaBancoPunVen.setConnexion(this.getConnexion());
			formapagopuntoventaLogic_Desde_CuentaBancoPunVen.setDatosCliente(this.datosCliente);

			for(FormaPagoPuntoVenta formapagopuntoventa_Desde_CuentaBancoPunVen:formapagopuntoventaLogic_Desde_CuentaBancoPunVen.getFormaPagoPuntoVentas()) {
				formapagopuntoventa_Desde_CuentaBancoPunVen.setid_cuenta_banco_pun_ven(idCuentaBancoPunVenActual);
			}

			formapagopuntoventaLogic_Desde_CuentaBancoPunVen.saveFormaPagoPuntoVentas();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfCuentaBancoPunVen(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CuentaBancoPunVenConstantesFunciones.getClassesForeignKeysOfCuentaBancoPunVen(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCuentaBancoPunVen(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CuentaBancoPunVenConstantesFunciones.getClassesRelationshipsOfCuentaBancoPunVen(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

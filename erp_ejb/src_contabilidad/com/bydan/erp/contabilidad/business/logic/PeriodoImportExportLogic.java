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
import com.bydan.erp.contabilidad.util.PeriodoImportExportConstantesFunciones;
import com.bydan.erp.contabilidad.util.PeriodoImportExportParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.PeriodoImportExportParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.PeriodoImportExport;
import com.bydan.erp.contabilidad.business.logic.PeriodoImportExportLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class PeriodoImportExportLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PeriodoImportExportLogic.class);
	
	protected PeriodoImportExportDataAccess periodoimportexportDataAccess; 	
	protected PeriodoImportExport periodoimportexport;
	protected List<PeriodoImportExport> periodoimportexports;
	protected Object periodoimportexportObject;	
	protected List<Object> periodoimportexportsObject;
	
	public static ClassValidator<PeriodoImportExport> periodoimportexportValidator = new ClassValidator<PeriodoImportExport>(PeriodoImportExport.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PeriodoImportExportLogicAdditional periodoimportexportLogicAdditional=null;
	
	public PeriodoImportExportLogicAdditional getPeriodoImportExportLogicAdditional() {
		return this.periodoimportexportLogicAdditional;
	}
	
	public void setPeriodoImportExportLogicAdditional(PeriodoImportExportLogicAdditional periodoimportexportLogicAdditional) {
		try {
			this.periodoimportexportLogicAdditional=periodoimportexportLogicAdditional;
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
	
	
	
	
	public  PeriodoImportExportLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.periodoimportexportDataAccess = new PeriodoImportExportDataAccess();
			
			this.periodoimportexports= new ArrayList<PeriodoImportExport>();
			this.periodoimportexport= new PeriodoImportExport();
			
			this.periodoimportexportObject=new Object();
			this.periodoimportexportsObject=new ArrayList<Object>();
				
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
			
			this.periodoimportexportDataAccess.setConnexionType(this.connexionType);
			this.periodoimportexportDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PeriodoImportExportLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.periodoimportexportDataAccess = new PeriodoImportExportDataAccess();
			this.periodoimportexports= new ArrayList<PeriodoImportExport>();
			this.periodoimportexport= new PeriodoImportExport();
			this.periodoimportexportObject=new Object();
			this.periodoimportexportsObject=new ArrayList<Object>();
			
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
			
			this.periodoimportexportDataAccess.setConnexionType(this.connexionType);
			this.periodoimportexportDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PeriodoImportExport getPeriodoImportExport() throws Exception {	
		PeriodoImportExportLogicAdditional.checkPeriodoImportExportToGet(periodoimportexport,this.datosCliente,this.arrDatoGeneral);
		PeriodoImportExportLogicAdditional.updatePeriodoImportExportToGet(periodoimportexport,this.arrDatoGeneral);
		
		return periodoimportexport;
	}
		
	public void setPeriodoImportExport(PeriodoImportExport newPeriodoImportExport) {
		this.periodoimportexport = newPeriodoImportExport;
	}
	
	public PeriodoImportExportDataAccess getPeriodoImportExportDataAccess() {
		return periodoimportexportDataAccess;
	}
	
	public void setPeriodoImportExportDataAccess(PeriodoImportExportDataAccess newperiodoimportexportDataAccess) {
		this.periodoimportexportDataAccess = newperiodoimportexportDataAccess;
	}
	
	public List<PeriodoImportExport> getPeriodoImportExports() throws Exception {		
		this.quitarPeriodoImportExportsNulos();
		
		PeriodoImportExportLogicAdditional.checkPeriodoImportExportToGets(periodoimportexports,this.datosCliente,this.arrDatoGeneral);
		
		for (PeriodoImportExport periodoimportexportLocal: periodoimportexports ) {
			PeriodoImportExportLogicAdditional.updatePeriodoImportExportToGet(periodoimportexportLocal,this.arrDatoGeneral);
		}
		
		return periodoimportexports;
	}
	
	public void setPeriodoImportExports(List<PeriodoImportExport> newPeriodoImportExports) {
		this.periodoimportexports = newPeriodoImportExports;
	}
	
	public Object getPeriodoImportExportObject() {	
		this.periodoimportexportObject=this.periodoimportexportDataAccess.getEntityObject();
		return this.periodoimportexportObject;
	}
		
	public void setPeriodoImportExportObject(Object newPeriodoImportExportObject) {
		this.periodoimportexportObject = newPeriodoImportExportObject;
	}
	
	public List<Object> getPeriodoImportExportsObject() {		
		this.periodoimportexportsObject=this.periodoimportexportDataAccess.getEntitiesObject();
		return this.periodoimportexportsObject;
	}
		
	public void setPeriodoImportExportsObject(List<Object> newPeriodoImportExportsObject) {
		this.periodoimportexportsObject = newPeriodoImportExportsObject;
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
		
		if(this.periodoimportexportDataAccess!=null) {
			this.periodoimportexportDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoImportExport.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			periodoimportexportDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			periodoimportexportDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		periodoimportexport = new  PeriodoImportExport();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoImportExport.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			periodoimportexport=periodoimportexportDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.periodoimportexport,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PeriodoImportExportConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoImportExport(this.periodoimportexport);
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
		periodoimportexport = new  PeriodoImportExport();
		  		  
        try {
			
			periodoimportexport=periodoimportexportDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.periodoimportexport,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PeriodoImportExportConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoImportExport(this.periodoimportexport);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		periodoimportexport = new  PeriodoImportExport();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoImportExport.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			periodoimportexport=periodoimportexportDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.periodoimportexport,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PeriodoImportExportConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoImportExport(this.periodoimportexport);
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
		periodoimportexport = new  PeriodoImportExport();
		  		  
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
		periodoimportexport = new  PeriodoImportExport();
		  		  
        try {
			
			periodoimportexport=periodoimportexportDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.periodoimportexport,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PeriodoImportExportConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoImportExport(this.periodoimportexport);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		periodoimportexport = new  PeriodoImportExport();
		  		  
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
		periodoimportexport = new  PeriodoImportExport();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoImportExport.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =periodoimportexportDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		periodoimportexport = new  PeriodoImportExport();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=periodoimportexportDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		periodoimportexport = new  PeriodoImportExport();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoImportExport.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =periodoimportexportDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		periodoimportexport = new  PeriodoImportExport();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=periodoimportexportDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		periodoimportexport = new  PeriodoImportExport();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoImportExport.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =periodoimportexportDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		periodoimportexport = new  PeriodoImportExport();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=periodoimportexportDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		periodoimportexports = new  ArrayList<PeriodoImportExport>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoImportExport.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PeriodoImportExportLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			periodoimportexports=periodoimportexportDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPeriodoImportExport(periodoimportexports);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PeriodoImportExportConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoImportExport(this.periodoimportexports);
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
		periodoimportexports = new  ArrayList<PeriodoImportExport>();
		  		  
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
		periodoimportexports = new  ArrayList<PeriodoImportExport>();
		  		  
        try {			
			PeriodoImportExportLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			periodoimportexports=periodoimportexportDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPeriodoImportExport(periodoimportexports);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PeriodoImportExportConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoImportExport(this.periodoimportexports);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		periodoimportexports = new  ArrayList<PeriodoImportExport>();
		  		  
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
		periodoimportexports = new  ArrayList<PeriodoImportExport>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoImportExport.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PeriodoImportExportLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			periodoimportexports=periodoimportexportDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPeriodoImportExport(periodoimportexports);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PeriodoImportExportConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoImportExport(this.periodoimportexports);
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
		periodoimportexports = new  ArrayList<PeriodoImportExport>();
		  		  
        try {
			PeriodoImportExportLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			periodoimportexports=periodoimportexportDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPeriodoImportExport(periodoimportexports);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PeriodoImportExportConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoImportExport(this.periodoimportexports);
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
		periodoimportexports = new  ArrayList<PeriodoImportExport>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoImportExport.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PeriodoImportExportLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			periodoimportexports=periodoimportexportDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPeriodoImportExport(periodoimportexports);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PeriodoImportExportConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoImportExport(this.periodoimportexports);
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
		periodoimportexports = new  ArrayList<PeriodoImportExport>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PeriodoImportExportLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			periodoimportexports=periodoimportexportDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPeriodoImportExport(periodoimportexports);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PeriodoImportExportConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoImportExport(this.periodoimportexports);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		periodoimportexport = new  PeriodoImportExport();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoImportExport.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PeriodoImportExportLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			periodoimportexport=periodoimportexportDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPeriodoImportExport(periodoimportexport);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PeriodoImportExportConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoImportExport(this.periodoimportexport);
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
		periodoimportexport = new  PeriodoImportExport();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PeriodoImportExportLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			periodoimportexport=periodoimportexportDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPeriodoImportExport(periodoimportexport);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PeriodoImportExportConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoImportExport(this.periodoimportexport);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		periodoimportexports = new  ArrayList<PeriodoImportExport>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoImportExport.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			PeriodoImportExportLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			periodoimportexports=periodoimportexportDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPeriodoImportExport(periodoimportexports);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PeriodoImportExportConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoImportExport(this.periodoimportexports);
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
		periodoimportexports = new  ArrayList<PeriodoImportExport>();
		  		  
        try {
			PeriodoImportExportLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			periodoimportexports=periodoimportexportDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPeriodoImportExport(periodoimportexports);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PeriodoImportExportConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoImportExport(this.periodoimportexports);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosPeriodoImportExportsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		periodoimportexports = new  ArrayList<PeriodoImportExport>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoImportExport.class.getSimpleName()+"-getTodosPeriodoImportExportsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PeriodoImportExportLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			periodoimportexports=periodoimportexportDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPeriodoImportExport(periodoimportexports);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PeriodoImportExportConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoImportExport(this.periodoimportexports);
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
	
	public  void  getTodosPeriodoImportExports(String sFinalQuery,Pagination pagination)throws Exception {
		periodoimportexports = new  ArrayList<PeriodoImportExport>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PeriodoImportExportLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			periodoimportexports=periodoimportexportDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPeriodoImportExport(periodoimportexports);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PeriodoImportExportConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoImportExport(this.periodoimportexports);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPeriodoImportExport(PeriodoImportExport periodoimportexport) throws Exception {
		Boolean estaValidado=false;
		
		if(periodoimportexport.getIsNew() || periodoimportexport.getIsChanged()) { 
			this.invalidValues = periodoimportexportValidator.getInvalidValues(periodoimportexport);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(periodoimportexport);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPeriodoImportExport(List<PeriodoImportExport> PeriodoImportExports) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(PeriodoImportExport periodoimportexportLocal:periodoimportexports) {				
			estaValidadoObjeto=this.validarGuardarPeriodoImportExport(periodoimportexportLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPeriodoImportExport(List<PeriodoImportExport> PeriodoImportExports) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPeriodoImportExport(periodoimportexports)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPeriodoImportExport(PeriodoImportExport PeriodoImportExport) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPeriodoImportExport(periodoimportexport)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(PeriodoImportExport periodoimportexport) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+periodoimportexport.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PeriodoImportExportConstantesFunciones.getPeriodoImportExportLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"periodoimportexport","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PeriodoImportExportConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PeriodoImportExportConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePeriodoImportExportWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoImportExport.class.getSimpleName()+"-savePeriodoImportExportWithConnection");connexion.begin();			
			
			PeriodoImportExportLogicAdditional.checkPeriodoImportExportToSave(this.periodoimportexport,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PeriodoImportExportLogicAdditional.updatePeriodoImportExportToSave(this.periodoimportexport,this.arrDatoGeneral);
			
			PeriodoImportExportLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.periodoimportexport,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPeriodoImportExport();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPeriodoImportExport(this.periodoimportexport)) {
				PeriodoImportExportDataAccess.save(this.periodoimportexport, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.periodoimportexport,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PeriodoImportExportLogicAdditional.checkPeriodoImportExportToSaveAfter(this.periodoimportexport,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPeriodoImportExport();
			
			connexion.commit();			
			
			if(this.periodoimportexport.getIsDeleted()) {
				this.periodoimportexport=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePeriodoImportExport()throws Exception {	
		try {	
			
			PeriodoImportExportLogicAdditional.checkPeriodoImportExportToSave(this.periodoimportexport,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PeriodoImportExportLogicAdditional.updatePeriodoImportExportToSave(this.periodoimportexport,this.arrDatoGeneral);
			
			PeriodoImportExportLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.periodoimportexport,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPeriodoImportExport(this.periodoimportexport)) {			
				PeriodoImportExportDataAccess.save(this.periodoimportexport, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.periodoimportexport,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PeriodoImportExportLogicAdditional.checkPeriodoImportExportToSaveAfter(this.periodoimportexport,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.periodoimportexport.getIsDeleted()) {
				this.periodoimportexport=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePeriodoImportExportsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoImportExport.class.getSimpleName()+"-savePeriodoImportExportsWithConnection");connexion.begin();			
			
			PeriodoImportExportLogicAdditional.checkPeriodoImportExportToSaves(periodoimportexports,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPeriodoImportExports();
			
			Boolean validadoTodosPeriodoImportExport=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PeriodoImportExport periodoimportexportLocal:periodoimportexports) {		
				if(periodoimportexportLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PeriodoImportExportLogicAdditional.updatePeriodoImportExportToSave(periodoimportexportLocal,this.arrDatoGeneral);
	        	
				PeriodoImportExportLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),periodoimportexportLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPeriodoImportExport(periodoimportexportLocal)) {
					PeriodoImportExportDataAccess.save(periodoimportexportLocal, connexion);				
				} else {
					validadoTodosPeriodoImportExport=false;
				}
			}
			
			if(!validadoTodosPeriodoImportExport) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PeriodoImportExportLogicAdditional.checkPeriodoImportExportToSavesAfter(periodoimportexports,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPeriodoImportExports();
			
			connexion.commit();		
			
			this.quitarPeriodoImportExportsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePeriodoImportExports()throws Exception {				
		 try {	
			PeriodoImportExportLogicAdditional.checkPeriodoImportExportToSaves(periodoimportexports,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPeriodoImportExport=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PeriodoImportExport periodoimportexportLocal:periodoimportexports) {				
				if(periodoimportexportLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PeriodoImportExportLogicAdditional.updatePeriodoImportExportToSave(periodoimportexportLocal,this.arrDatoGeneral);
	        	
				PeriodoImportExportLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),periodoimportexportLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPeriodoImportExport(periodoimportexportLocal)) {				
					PeriodoImportExportDataAccess.save(periodoimportexportLocal, connexion);				
				} else {
					validadoTodosPeriodoImportExport=false;
				}
			}
			
			if(!validadoTodosPeriodoImportExport) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PeriodoImportExportLogicAdditional.checkPeriodoImportExportToSavesAfter(periodoimportexports,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPeriodoImportExportsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PeriodoImportExportParameterReturnGeneral procesarAccionPeriodoImportExports(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PeriodoImportExport> periodoimportexports,PeriodoImportExportParameterReturnGeneral periodoimportexportParameterGeneral)throws Exception {
		 try {	
			PeriodoImportExportParameterReturnGeneral periodoimportexportReturnGeneral=new PeriodoImportExportParameterReturnGeneral();
	
			PeriodoImportExportLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,periodoimportexports,periodoimportexportParameterGeneral,periodoimportexportReturnGeneral);
			
			return periodoimportexportReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PeriodoImportExportParameterReturnGeneral procesarAccionPeriodoImportExportsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PeriodoImportExport> periodoimportexports,PeriodoImportExportParameterReturnGeneral periodoimportexportParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoImportExport.class.getSimpleName()+"-procesarAccionPeriodoImportExportsWithConnection");connexion.begin();			
			
			PeriodoImportExportParameterReturnGeneral periodoimportexportReturnGeneral=new PeriodoImportExportParameterReturnGeneral();
	
			PeriodoImportExportLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,periodoimportexports,periodoimportexportParameterGeneral,periodoimportexportReturnGeneral);
			
			this.connexion.commit();
			
			return periodoimportexportReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PeriodoImportExportParameterReturnGeneral procesarEventosPeriodoImportExports(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PeriodoImportExport> periodoimportexports,PeriodoImportExport periodoimportexport,PeriodoImportExportParameterReturnGeneral periodoimportexportParameterGeneral,Boolean isEsNuevoPeriodoImportExport,ArrayList<Classe> clases)throws Exception {
		 try {	
			PeriodoImportExportParameterReturnGeneral periodoimportexportReturnGeneral=new PeriodoImportExportParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				periodoimportexportReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PeriodoImportExportLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,periodoimportexports,periodoimportexport,periodoimportexportParameterGeneral,periodoimportexportReturnGeneral,isEsNuevoPeriodoImportExport,clases);
			
			return periodoimportexportReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PeriodoImportExportParameterReturnGeneral procesarEventosPeriodoImportExportsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PeriodoImportExport> periodoimportexports,PeriodoImportExport periodoimportexport,PeriodoImportExportParameterReturnGeneral periodoimportexportParameterGeneral,Boolean isEsNuevoPeriodoImportExport,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoImportExport.class.getSimpleName()+"-procesarEventosPeriodoImportExportsWithConnection");connexion.begin();			
			
			PeriodoImportExportParameterReturnGeneral periodoimportexportReturnGeneral=new PeriodoImportExportParameterReturnGeneral();
	
			periodoimportexportReturnGeneral.setPeriodoImportExport(periodoimportexport);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				periodoimportexportReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PeriodoImportExportLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,periodoimportexports,periodoimportexport,periodoimportexportParameterGeneral,periodoimportexportReturnGeneral,isEsNuevoPeriodoImportExport,clases);
			
			this.connexion.commit();
			
			return periodoimportexportReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PeriodoImportExportParameterReturnGeneral procesarImportacionPeriodoImportExportsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PeriodoImportExportParameterReturnGeneral periodoimportexportParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoImportExport.class.getSimpleName()+"-procesarImportacionPeriodoImportExportsWithConnection");connexion.begin();			
			
			PeriodoImportExportParameterReturnGeneral periodoimportexportReturnGeneral=new PeriodoImportExportParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.periodoimportexports=new ArrayList<PeriodoImportExport>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.periodoimportexport=new PeriodoImportExport();
				
				
				if(conColumnasBase) {this.periodoimportexport.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.periodoimportexport.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.periodoimportexport.setcodigo(arrColumnas[iColumn++]);
				
				this.periodoimportexports.add(this.periodoimportexport);
			}
			
			this.savePeriodoImportExports();
			
			this.connexion.commit();
			
			periodoimportexportReturnGeneral.setConRetornoEstaProcesado(true);
			periodoimportexportReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return periodoimportexportReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPeriodoImportExportsEliminados() throws Exception {				
		
		List<PeriodoImportExport> periodoimportexportsAux= new ArrayList<PeriodoImportExport>();
		
		for(PeriodoImportExport periodoimportexport:periodoimportexports) {
			if(!periodoimportexport.getIsDeleted()) {
				periodoimportexportsAux.add(periodoimportexport);
			}
		}
		
		periodoimportexports=periodoimportexportsAux;
	}
	
	public void quitarPeriodoImportExportsNulos() throws Exception {				
		
		List<PeriodoImportExport> periodoimportexportsAux= new ArrayList<PeriodoImportExport>();
		
		for(PeriodoImportExport periodoimportexport : this.periodoimportexports) {
			if(periodoimportexport==null) {
				periodoimportexportsAux.add(periodoimportexport);
			}
		}
		
		//this.periodoimportexports=periodoimportexportsAux;
		
		this.periodoimportexports.removeAll(periodoimportexportsAux);
	}
	
	public void getSetVersionRowPeriodoImportExportWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(periodoimportexport.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((periodoimportexport.getIsDeleted() || (periodoimportexport.getIsChanged()&&!periodoimportexport.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=periodoimportexportDataAccess.getSetVersionRowPeriodoImportExport(connexion,periodoimportexport.getId());
				
				if(!periodoimportexport.getVersionRow().equals(timestamp)) {	
					periodoimportexport.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				periodoimportexport.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPeriodoImportExport()throws Exception {	
		
		if(periodoimportexport.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((periodoimportexport.getIsDeleted() || (periodoimportexport.getIsChanged()&&!periodoimportexport.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=periodoimportexportDataAccess.getSetVersionRowPeriodoImportExport(connexion,periodoimportexport.getId());
			
			try {							
				if(!periodoimportexport.getVersionRow().equals(timestamp)) {	
					periodoimportexport.setVersionRow(timestamp);
				}
				
				periodoimportexport.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPeriodoImportExportsWithConnection()throws Exception {	
		if(periodoimportexports!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(PeriodoImportExport periodoimportexportAux:periodoimportexports) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(periodoimportexportAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(periodoimportexportAux.getIsDeleted() || (periodoimportexportAux.getIsChanged()&&!periodoimportexportAux.getIsNew())) {
						
						timestamp=periodoimportexportDataAccess.getSetVersionRowPeriodoImportExport(connexion,periodoimportexportAux.getId());
						
						if(!periodoimportexport.getVersionRow().equals(timestamp)) {	
							periodoimportexportAux.setVersionRow(timestamp);
						}
								
						periodoimportexportAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPeriodoImportExports()throws Exception {	
		if(periodoimportexports!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(PeriodoImportExport periodoimportexportAux:periodoimportexports) {
					if(periodoimportexportAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(periodoimportexportAux.getIsDeleted() || (periodoimportexportAux.getIsChanged()&&!periodoimportexportAux.getIsNew())) {
						
						timestamp=periodoimportexportDataAccess.getSetVersionRowPeriodoImportExport(connexion,periodoimportexportAux.getId());
						
						if(!periodoimportexportAux.getVersionRow().equals(timestamp)) {	
							periodoimportexportAux.setVersionRow(timestamp);
						}
						
													
						periodoimportexportAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PeriodoImportExportParameterReturnGeneral cargarCombosLoteForeignKeyPeriodoImportExportWithConnection(String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		PeriodoImportExportParameterReturnGeneral  periodoimportexportReturnGeneral =new PeriodoImportExportParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoImportExport.class.getSimpleName()+"-cargarCombosLoteForeignKeyPeriodoImportExportWithConnection");connexion.begin();
			
			periodoimportexportReturnGeneral =new PeriodoImportExportParameterReturnGeneral();
			
			

			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			periodoimportexportReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			periodoimportexportReturnGeneral.setmessForeignKey(messForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return periodoimportexportReturnGeneral;
	}
	
	public PeriodoImportExportParameterReturnGeneral cargarCombosLoteForeignKeyPeriodoImportExport(String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		PeriodoImportExportParameterReturnGeneral  periodoimportexportReturnGeneral =new PeriodoImportExportParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			periodoimportexportReturnGeneral =new PeriodoImportExportParameterReturnGeneral();
			
			

			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			periodoimportexportReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			periodoimportexportReturnGeneral.setmessForeignKey(messForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return periodoimportexportReturnGeneral;
	}
	
	
	public void deepLoad(PeriodoImportExport periodoimportexport,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PeriodoImportExportLogicAdditional.updatePeriodoImportExportToGet(periodoimportexport,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		periodoimportexport.setAnio(periodoimportexportDataAccess.getAnio(connexion,periodoimportexport));
		periodoimportexport.setMes(periodoimportexportDataAccess.getMes(connexion,periodoimportexport));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				periodoimportexport.setAnio(periodoimportexportDataAccess.getAnio(connexion,periodoimportexport));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				periodoimportexport.setMes(periodoimportexportDataAccess.getMes(connexion,periodoimportexport));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			periodoimportexport.setAnio(periodoimportexportDataAccess.getAnio(connexion,periodoimportexport));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			periodoimportexport.setMes(periodoimportexportDataAccess.getMes(connexion,periodoimportexport));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		periodoimportexport.setAnio(periodoimportexportDataAccess.getAnio(connexion,periodoimportexport));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(periodoimportexport.getAnio(),isDeep,deepLoadType,clases);
				
		periodoimportexport.setMes(periodoimportexportDataAccess.getMes(connexion,periodoimportexport));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(periodoimportexport.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				periodoimportexport.setAnio(periodoimportexportDataAccess.getAnio(connexion,periodoimportexport));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(periodoimportexport.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				periodoimportexport.setMes(periodoimportexportDataAccess.getMes(connexion,periodoimportexport));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(periodoimportexport.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			periodoimportexport.setAnio(periodoimportexportDataAccess.getAnio(connexion,periodoimportexport));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(periodoimportexport.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			periodoimportexport.setMes(periodoimportexportDataAccess.getMes(connexion,periodoimportexport));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(periodoimportexport.getMes(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(PeriodoImportExport periodoimportexport,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			PeriodoImportExportLogicAdditional.updatePeriodoImportExportToSave(periodoimportexport,this.arrDatoGeneral);
			
PeriodoImportExportDataAccess.save(periodoimportexport, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		AnioDataAccess.save(periodoimportexport.getAnio(),connexion);

		MesDataAccess.save(periodoimportexport.getMes(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(periodoimportexport.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(periodoimportexport.getMes(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		AnioDataAccess.save(periodoimportexport.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(periodoimportexport.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(periodoimportexport.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(periodoimportexport.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(periodoimportexport.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(periodoimportexport.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(periodoimportexport.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(periodoimportexport.getMes(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(PeriodoImportExport.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(periodoimportexport,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PeriodoImportExportConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoImportExport(periodoimportexport);
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
			this.deepLoad(this.periodoimportexport,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PeriodoImportExportConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoImportExport(this.periodoimportexport);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(PeriodoImportExport.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(periodoimportexports!=null) {
				for(PeriodoImportExport periodoimportexport:periodoimportexports) {
					this.deepLoad(periodoimportexport,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PeriodoImportExportConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoImportExport(periodoimportexports);
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
			if(periodoimportexports!=null) {
				for(PeriodoImportExport periodoimportexport:periodoimportexports) {
					this.deepLoad(periodoimportexport,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PeriodoImportExportConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoImportExport(periodoimportexports);
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
			this.getNewConnexionToDeep(PeriodoImportExport.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(periodoimportexport,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(PeriodoImportExport.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(periodoimportexports!=null) {
				for(PeriodoImportExport periodoimportexport:periodoimportexports) {
					this.deepSave(periodoimportexport,isDeep,deepLoadType,clases);
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
			if(periodoimportexports!=null) {
				for(PeriodoImportExport periodoimportexport:periodoimportexports) {
					this.deepSave(periodoimportexport,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getPeriodoImportExportsBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoImportExport.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",PeriodoImportExportConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			PeriodoImportExportLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			periodoimportexports=periodoimportexportDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PeriodoImportExportConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoImportExport(this.periodoimportexports);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPeriodoImportExportsBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",PeriodoImportExportConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			PeriodoImportExportLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			periodoimportexports=periodoimportexportDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PeriodoImportExportConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoImportExport(this.periodoimportexports);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPeriodoImportExportsFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoImportExport.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,PeriodoImportExportConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			PeriodoImportExportLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			periodoimportexports=periodoimportexportDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PeriodoImportExportConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoImportExport(this.periodoimportexports);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPeriodoImportExportsFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,PeriodoImportExportConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			PeriodoImportExportLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			periodoimportexports=periodoimportexportDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PeriodoImportExportConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoImportExport(this.periodoimportexports);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPeriodoImportExportsFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoImportExport.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,PeriodoImportExportConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			PeriodoImportExportLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			periodoimportexports=periodoimportexportDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PeriodoImportExportConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoImportExport(this.periodoimportexports);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPeriodoImportExportsFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,PeriodoImportExportConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			PeriodoImportExportLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			periodoimportexports=periodoimportexportDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PeriodoImportExportConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoImportExport(this.periodoimportexports);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPeriodoImportExportPorIdAnioPorIdMesWithConnection(Long id_anio,Long id_mes)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PeriodoImportExport.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,PeriodoImportExportConstantesFunciones.IDANIO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,PeriodoImportExportConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			periodoimportexport=periodoimportexportDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.periodoimportexport,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				PeriodoImportExportConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoImportExport(this.periodoimportexport);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPeriodoImportExportPorIdAnioPorIdMes(Long id_anio,Long id_mes)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,PeriodoImportExportConstantesFunciones.IDANIO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,PeriodoImportExportConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			periodoimportexport=periodoimportexportDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.periodoimportexport,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				PeriodoImportExportConstantesFunciones.refrescarForeignKeysDescripcionesPeriodoImportExport(this.periodoimportexport);
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
			if(PeriodoImportExportConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PeriodoImportExportDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,PeriodoImportExport periodoimportexport,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PeriodoImportExportConstantesFunciones.ISCONAUDITORIA) {
				if(periodoimportexport.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PeriodoImportExportDataAccess.TABLENAME, periodoimportexport.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PeriodoImportExportConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PeriodoImportExportLogic.registrarAuditoriaDetallesPeriodoImportExport(connexion,periodoimportexport,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(periodoimportexport.getIsDeleted()) {
					/*if(!periodoimportexport.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PeriodoImportExportDataAccess.TABLENAME, periodoimportexport.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////PeriodoImportExportLogic.registrarAuditoriaDetallesPeriodoImportExport(connexion,periodoimportexport,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PeriodoImportExportDataAccess.TABLENAME, periodoimportexport.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(periodoimportexport.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PeriodoImportExportDataAccess.TABLENAME, periodoimportexport.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PeriodoImportExportConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PeriodoImportExportLogic.registrarAuditoriaDetallesPeriodoImportExport(connexion,periodoimportexport,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPeriodoImportExport(Connexion connexion,PeriodoImportExport periodoimportexport)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(periodoimportexport.getIsNew()||!periodoimportexport.getcodigo().equals(periodoimportexport.getPeriodoImportExportOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(periodoimportexport.getPeriodoImportExportOriginal().getcodigo()!=null)
				{
					strValorActual=periodoimportexport.getPeriodoImportExportOriginal().getcodigo();
				}
				if(periodoimportexport.getcodigo()!=null)
				{
					strValorNuevo=periodoimportexport.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PeriodoImportExportConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(periodoimportexport.getIsNew()||!periodoimportexport.getid_anio().equals(periodoimportexport.getPeriodoImportExportOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(periodoimportexport.getPeriodoImportExportOriginal().getid_anio()!=null)
				{
					strValorActual=periodoimportexport.getPeriodoImportExportOriginal().getid_anio().toString();
				}
				if(periodoimportexport.getid_anio()!=null)
				{
					strValorNuevo=periodoimportexport.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PeriodoImportExportConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(periodoimportexport.getIsNew()||!periodoimportexport.getid_mes().equals(periodoimportexport.getPeriodoImportExportOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(periodoimportexport.getPeriodoImportExportOriginal().getid_mes()!=null)
				{
					strValorActual=periodoimportexport.getPeriodoImportExportOriginal().getid_mes().toString();
				}
				if(periodoimportexport.getid_mes()!=null)
				{
					strValorNuevo=periodoimportexport.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PeriodoImportExportConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void savePeriodoImportExportRelacionesWithConnection(PeriodoImportExport periodoimportexport) throws Exception {

		if(!periodoimportexport.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePeriodoImportExportRelacionesBase(periodoimportexport,true);
		}
	}

	public void savePeriodoImportExportRelaciones(PeriodoImportExport periodoimportexport)throws Exception {

		if(!periodoimportexport.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePeriodoImportExportRelacionesBase(periodoimportexport,false);
		}
	}

	public void savePeriodoImportExportRelacionesBase(PeriodoImportExport periodoimportexport,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("PeriodoImportExport-saveRelacionesWithConnection");}
	

			this.setPeriodoImportExport(periodoimportexport);

				if((periodoimportexport.getIsNew()||periodoimportexport.getIsChanged())&&!periodoimportexport.getIsDeleted()) {
					this.savePeriodoImportExport();
					this.savePeriodoImportExportRelacionesDetalles();

				} else if(periodoimportexport.getIsDeleted()) {
					this.savePeriodoImportExportRelacionesDetalles();
					this.savePeriodoImportExport();
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
	
	
	private void savePeriodoImportExportRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPeriodoImportExport(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PeriodoImportExportConstantesFunciones.getClassesForeignKeysOfPeriodoImportExport(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPeriodoImportExport(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PeriodoImportExportConstantesFunciones.getClassesRelationshipsOfPeriodoImportExport(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

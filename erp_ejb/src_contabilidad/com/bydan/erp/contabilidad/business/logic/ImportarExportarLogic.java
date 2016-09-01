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
import com.bydan.erp.contabilidad.util.ImportarExportarConstantesFunciones;
import com.bydan.erp.contabilidad.util.ImportarExportarParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.ImportarExportarParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.ImportarExportar;
import com.bydan.erp.contabilidad.business.logic.ImportarExportarLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;








@SuppressWarnings("unused")
public class ImportarExportarLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ImportarExportarLogic.class);
	
	protected ImportarExportarDataAccess importarexportarDataAccess; 	
	protected ImportarExportar importarexportar;
	protected List<ImportarExportar> importarexportars;
	protected Object importarexportarObject;	
	protected List<Object> importarexportarsObject;
	
	public static ClassValidator<ImportarExportar> importarexportarValidator = new ClassValidator<ImportarExportar>(ImportarExportar.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ImportarExportarLogicAdditional importarexportarLogicAdditional=null;
	
	public ImportarExportarLogicAdditional getImportarExportarLogicAdditional() {
		return this.importarexportarLogicAdditional;
	}
	
	public void setImportarExportarLogicAdditional(ImportarExportarLogicAdditional importarexportarLogicAdditional) {
		try {
			this.importarexportarLogicAdditional=importarexportarLogicAdditional;
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
	
	
	
	
	public  ImportarExportarLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.importarexportarDataAccess = new ImportarExportarDataAccess();
			
			this.importarexportars= new ArrayList<ImportarExportar>();
			this.importarexportar= new ImportarExportar();
			
			this.importarexportarObject=new Object();
			this.importarexportarsObject=new ArrayList<Object>();
				
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
			
			this.importarexportarDataAccess.setConnexionType(this.connexionType);
			this.importarexportarDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ImportarExportarLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.importarexportarDataAccess = new ImportarExportarDataAccess();
			this.importarexportars= new ArrayList<ImportarExportar>();
			this.importarexportar= new ImportarExportar();
			this.importarexportarObject=new Object();
			this.importarexportarsObject=new ArrayList<Object>();
			
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
			
			this.importarexportarDataAccess.setConnexionType(this.connexionType);
			this.importarexportarDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ImportarExportar getImportarExportar() throws Exception {	
		ImportarExportarLogicAdditional.checkImportarExportarToGet(importarexportar,this.datosCliente,this.arrDatoGeneral);
		ImportarExportarLogicAdditional.updateImportarExportarToGet(importarexportar,this.arrDatoGeneral);
		
		return importarexportar;
	}
		
	public void setImportarExportar(ImportarExportar newImportarExportar) {
		this.importarexportar = newImportarExportar;
	}
	
	public ImportarExportarDataAccess getImportarExportarDataAccess() {
		return importarexportarDataAccess;
	}
	
	public void setImportarExportarDataAccess(ImportarExportarDataAccess newimportarexportarDataAccess) {
		this.importarexportarDataAccess = newimportarexportarDataAccess;
	}
	
	public List<ImportarExportar> getImportarExportars() throws Exception {		
		this.quitarImportarExportarsNulos();
		
		ImportarExportarLogicAdditional.checkImportarExportarToGets(importarexportars,this.datosCliente,this.arrDatoGeneral);
		
		for (ImportarExportar importarexportarLocal: importarexportars ) {
			ImportarExportarLogicAdditional.updateImportarExportarToGet(importarexportarLocal,this.arrDatoGeneral);
		}
		
		return importarexportars;
	}
	
	public void setImportarExportars(List<ImportarExportar> newImportarExportars) {
		this.importarexportars = newImportarExportars;
	}
	
	public Object getImportarExportarObject() {	
		this.importarexportarObject=this.importarexportarDataAccess.getEntityObject();
		return this.importarexportarObject;
	}
		
	public void setImportarExportarObject(Object newImportarExportarObject) {
		this.importarexportarObject = newImportarExportarObject;
	}
	
	public List<Object> getImportarExportarsObject() {		
		this.importarexportarsObject=this.importarexportarDataAccess.getEntitiesObject();
		return this.importarexportarsObject;
	}
		
	public void setImportarExportarsObject(List<Object> newImportarExportarsObject) {
		this.importarexportarsObject = newImportarExportarsObject;
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
		
		if(this.importarexportarDataAccess!=null) {
			this.importarexportarDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImportarExportar.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			importarexportarDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			importarexportarDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		importarexportar = new  ImportarExportar();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImportarExportar.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			importarexportar=importarexportarDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.importarexportar,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportar);
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
		importarexportar = new  ImportarExportar();
		  		  
        try {
			
			importarexportar=importarexportarDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.importarexportar,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportar);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		importarexportar = new  ImportarExportar();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImportarExportar.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			importarexportar=importarexportarDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.importarexportar,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportar);
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
		importarexportar = new  ImportarExportar();
		  		  
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
		importarexportar = new  ImportarExportar();
		  		  
        try {
			
			importarexportar=importarexportarDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.importarexportar,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportar);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		importarexportar = new  ImportarExportar();
		  		  
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
		importarexportar = new  ImportarExportar();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImportarExportar.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =importarexportarDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		importarexportar = new  ImportarExportar();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=importarexportarDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		importarexportar = new  ImportarExportar();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImportarExportar.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =importarexportarDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		importarexportar = new  ImportarExportar();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=importarexportarDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		importarexportar = new  ImportarExportar();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImportarExportar.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =importarexportarDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		importarexportar = new  ImportarExportar();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=importarexportarDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		importarexportars = new  ArrayList<ImportarExportar>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImportarExportar.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			importarexportars=importarexportarDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarImportarExportar(importarexportars);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportars);
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
		importarexportars = new  ArrayList<ImportarExportar>();
		  		  
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
		importarexportars = new  ArrayList<ImportarExportar>();
		  		  
        try {			
			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			importarexportars=importarexportarDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarImportarExportar(importarexportars);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportars);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		importarexportars = new  ArrayList<ImportarExportar>();
		  		  
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
		importarexportars = new  ArrayList<ImportarExportar>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImportarExportar.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			importarexportars=importarexportarDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarImportarExportar(importarexportars);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportars);
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
		importarexportars = new  ArrayList<ImportarExportar>();
		  		  
        try {
			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			importarexportars=importarexportarDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarImportarExportar(importarexportars);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportars);
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
		importarexportars = new  ArrayList<ImportarExportar>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImportarExportar.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			importarexportars=importarexportarDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarImportarExportar(importarexportars);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportars);
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
		importarexportars = new  ArrayList<ImportarExportar>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			importarexportars=importarexportarDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarImportarExportar(importarexportars);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportars);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		importarexportar = new  ImportarExportar();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImportarExportar.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			importarexportar=importarexportarDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarImportarExportar(importarexportar);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportar);
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
		importarexportar = new  ImportarExportar();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			importarexportar=importarexportarDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarImportarExportar(importarexportar);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportar);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		importarexportars = new  ArrayList<ImportarExportar>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImportarExportar.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			importarexportars=importarexportarDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarImportarExportar(importarexportars);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportars);
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
		importarexportars = new  ArrayList<ImportarExportar>();
		  		  
        try {
			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			importarexportars=importarexportarDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarImportarExportar(importarexportars);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportars);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosImportarExportarsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		importarexportars = new  ArrayList<ImportarExportar>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImportarExportar.class.getSimpleName()+"-getTodosImportarExportarsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			importarexportars=importarexportarDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarImportarExportar(importarexportars);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportars);
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
	
	public  void  getTodosImportarExportars(String sFinalQuery,Pagination pagination)throws Exception {
		importarexportars = new  ArrayList<ImportarExportar>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			importarexportars=importarexportarDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarImportarExportar(importarexportars);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportars);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarImportarExportar(ImportarExportar importarexportar) throws Exception {
		Boolean estaValidado=false;
		
		if(importarexportar.getIsNew() || importarexportar.getIsChanged()) { 
			this.invalidValues = importarexportarValidator.getInvalidValues(importarexportar);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(importarexportar);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarImportarExportar(List<ImportarExportar> ImportarExportars) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ImportarExportar importarexportarLocal:importarexportars) {				
			estaValidadoObjeto=this.validarGuardarImportarExportar(importarexportarLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarImportarExportar(List<ImportarExportar> ImportarExportars) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarImportarExportar(importarexportars)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarImportarExportar(ImportarExportar ImportarExportar) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarImportarExportar(importarexportar)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ImportarExportar importarexportar) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+importarexportar.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ImportarExportarConstantesFunciones.getImportarExportarLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"importarexportar","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ImportarExportarConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ImportarExportarConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveImportarExportarWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImportarExportar.class.getSimpleName()+"-saveImportarExportarWithConnection");connexion.begin();			
			
			ImportarExportarLogicAdditional.checkImportarExportarToSave(this.importarexportar,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ImportarExportarLogicAdditional.updateImportarExportarToSave(this.importarexportar,this.arrDatoGeneral);
			
			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.importarexportar,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowImportarExportar();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarImportarExportar(this.importarexportar)) {
				ImportarExportarDataAccess.save(this.importarexportar, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.importarexportar,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ImportarExportarLogicAdditional.checkImportarExportarToSaveAfter(this.importarexportar,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowImportarExportar();
			
			connexion.commit();			
			
			if(this.importarexportar.getIsDeleted()) {
				this.importarexportar=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveImportarExportar()throws Exception {	
		try {	
			
			ImportarExportarLogicAdditional.checkImportarExportarToSave(this.importarexportar,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ImportarExportarLogicAdditional.updateImportarExportarToSave(this.importarexportar,this.arrDatoGeneral);
			
			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.importarexportar,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarImportarExportar(this.importarexportar)) {			
				ImportarExportarDataAccess.save(this.importarexportar, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.importarexportar,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ImportarExportarLogicAdditional.checkImportarExportarToSaveAfter(this.importarexportar,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.importarexportar.getIsDeleted()) {
				this.importarexportar=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveImportarExportarsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImportarExportar.class.getSimpleName()+"-saveImportarExportarsWithConnection");connexion.begin();			
			
			ImportarExportarLogicAdditional.checkImportarExportarToSaves(importarexportars,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowImportarExportars();
			
			Boolean validadoTodosImportarExportar=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ImportarExportar importarexportarLocal:importarexportars) {		
				if(importarexportarLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ImportarExportarLogicAdditional.updateImportarExportarToSave(importarexportarLocal,this.arrDatoGeneral);
	        	
				ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),importarexportarLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarImportarExportar(importarexportarLocal)) {
					ImportarExportarDataAccess.save(importarexportarLocal, connexion);				
				} else {
					validadoTodosImportarExportar=false;
				}
			}
			
			if(!validadoTodosImportarExportar) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ImportarExportarLogicAdditional.checkImportarExportarToSavesAfter(importarexportars,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowImportarExportars();
			
			connexion.commit();		
			
			this.quitarImportarExportarsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveImportarExportars()throws Exception {				
		 try {	
			ImportarExportarLogicAdditional.checkImportarExportarToSaves(importarexportars,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosImportarExportar=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ImportarExportar importarexportarLocal:importarexportars) {				
				if(importarexportarLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ImportarExportarLogicAdditional.updateImportarExportarToSave(importarexportarLocal,this.arrDatoGeneral);
	        	
				ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),importarexportarLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarImportarExportar(importarexportarLocal)) {				
					ImportarExportarDataAccess.save(importarexportarLocal, connexion);				
				} else {
					validadoTodosImportarExportar=false;
				}
			}
			
			if(!validadoTodosImportarExportar) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ImportarExportarLogicAdditional.checkImportarExportarToSavesAfter(importarexportars,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarImportarExportarsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ImportarExportarParameterReturnGeneral procesarAccionImportarExportars(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ImportarExportar> importarexportars,ImportarExportarParameterReturnGeneral importarexportarParameterGeneral)throws Exception {
		 try {	
			ImportarExportarParameterReturnGeneral importarexportarReturnGeneral=new ImportarExportarParameterReturnGeneral();
	
			ImportarExportarLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,importarexportars,importarexportarParameterGeneral,importarexportarReturnGeneral);
			
			return importarexportarReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ImportarExportarParameterReturnGeneral procesarAccionImportarExportarsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ImportarExportar> importarexportars,ImportarExportarParameterReturnGeneral importarexportarParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImportarExportar.class.getSimpleName()+"-procesarAccionImportarExportarsWithConnection");connexion.begin();			
			
			ImportarExportarParameterReturnGeneral importarexportarReturnGeneral=new ImportarExportarParameterReturnGeneral();
	
			ImportarExportarLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,importarexportars,importarexportarParameterGeneral,importarexportarReturnGeneral);
			
			this.connexion.commit();
			
			return importarexportarReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ImportarExportarParameterReturnGeneral procesarEventosImportarExportars(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ImportarExportar> importarexportars,ImportarExportar importarexportar,ImportarExportarParameterReturnGeneral importarexportarParameterGeneral,Boolean isEsNuevoImportarExportar,ArrayList<Classe> clases)throws Exception {
		 try {	
			ImportarExportarParameterReturnGeneral importarexportarReturnGeneral=new ImportarExportarParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				importarexportarReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ImportarExportarLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,importarexportars,importarexportar,importarexportarParameterGeneral,importarexportarReturnGeneral,isEsNuevoImportarExportar,clases);
			
			return importarexportarReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ImportarExportarParameterReturnGeneral procesarEventosImportarExportarsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ImportarExportar> importarexportars,ImportarExportar importarexportar,ImportarExportarParameterReturnGeneral importarexportarParameterGeneral,Boolean isEsNuevoImportarExportar,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImportarExportar.class.getSimpleName()+"-procesarEventosImportarExportarsWithConnection");connexion.begin();			
			
			ImportarExportarParameterReturnGeneral importarexportarReturnGeneral=new ImportarExportarParameterReturnGeneral();
	
			importarexportarReturnGeneral.setImportarExportar(importarexportar);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				importarexportarReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ImportarExportarLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,importarexportars,importarexportar,importarexportarParameterGeneral,importarexportarReturnGeneral,isEsNuevoImportarExportar,clases);
			
			this.connexion.commit();
			
			return importarexportarReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ImportarExportarParameterReturnGeneral procesarImportacionImportarExportarsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ImportarExportarParameterReturnGeneral importarexportarParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImportarExportar.class.getSimpleName()+"-procesarImportacionImportarExportarsWithConnection");connexion.begin();			
			
			ImportarExportarParameterReturnGeneral importarexportarReturnGeneral=new ImportarExportarParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.importarexportars=new ArrayList<ImportarExportar>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.importarexportar=new ImportarExportar();
				
				
				if(conColumnasBase) {this.importarexportar.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.importarexportar.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.importarexportar.setruc(arrColumnas[iColumn++]);
				this.importarexportar.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.importarexportar.setnumero_comprobante(arrColumnas[iColumn++]);
				this.importarexportar.setdocumento_transporte(arrColumnas[iColumn++]);
				this.importarexportar.setnumero_referencia_comprobante(arrColumnas[iColumn++]);
				this.importarexportar.setcodigo_fiscal(arrColumnas[iColumn++]);
				this.importarexportar.setes_juridico(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.importarexportar.setbase0(Double.parseDouble(arrColumnas[iColumn++]));
				this.importarexportar.setmonto_total_cif(Double.parseDouble(arrColumnas[iColumn++]));
				this.importarexportar.setmonto_iva(Double.parseDouble(arrColumnas[iColumn++]));
				this.importarexportar.setmonto_ice(Double.parseDouble(arrColumnas[iColumn++]));
				this.importarexportar.setbase_general(Double.parseDouble(arrColumnas[iColumn++]));
				this.importarexportar.setcon_convenio(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.importarexportar.setcon_devolucion(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.importarexportar.setfecha_emision(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.importarexportar.setnumero_serie_comprobante(arrColumnas[iColumn++]);
				this.importarexportar.setnumero_autorizacion_comprobante(arrColumnas[iColumn++]);
				this.importarexportar.setnumero_secuencial_fuente(arrColumnas[iColumn++]);
				this.importarexportar.setvalor_fob(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.importarexportars.add(this.importarexportar);
			}
			
			this.saveImportarExportars();
			
			this.connexion.commit();
			
			importarexportarReturnGeneral.setConRetornoEstaProcesado(true);
			importarexportarReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return importarexportarReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarImportarExportarsEliminados() throws Exception {				
		
		List<ImportarExportar> importarexportarsAux= new ArrayList<ImportarExportar>();
		
		for(ImportarExportar importarexportar:importarexportars) {
			if(!importarexportar.getIsDeleted()) {
				importarexportarsAux.add(importarexportar);
			}
		}
		
		importarexportars=importarexportarsAux;
	}
	
	public void quitarImportarExportarsNulos() throws Exception {				
		
		List<ImportarExportar> importarexportarsAux= new ArrayList<ImportarExportar>();
		
		for(ImportarExportar importarexportar : this.importarexportars) {
			if(importarexportar==null) {
				importarexportarsAux.add(importarexportar);
			}
		}
		
		//this.importarexportars=importarexportarsAux;
		
		this.importarexportars.removeAll(importarexportarsAux);
	}
	
	public void getSetVersionRowImportarExportarWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(importarexportar.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((importarexportar.getIsDeleted() || (importarexportar.getIsChanged()&&!importarexportar.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=importarexportarDataAccess.getSetVersionRowImportarExportar(connexion,importarexportar.getId());
				
				if(!importarexportar.getVersionRow().equals(timestamp)) {	
					importarexportar.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				importarexportar.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowImportarExportar()throws Exception {	
		
		if(importarexportar.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((importarexportar.getIsDeleted() || (importarexportar.getIsChanged()&&!importarexportar.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=importarexportarDataAccess.getSetVersionRowImportarExportar(connexion,importarexportar.getId());
			
			try {							
				if(!importarexportar.getVersionRow().equals(timestamp)) {	
					importarexportar.setVersionRow(timestamp);
				}
				
				importarexportar.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowImportarExportarsWithConnection()throws Exception {	
		if(importarexportars!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ImportarExportar importarexportarAux:importarexportars) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(importarexportarAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(importarexportarAux.getIsDeleted() || (importarexportarAux.getIsChanged()&&!importarexportarAux.getIsNew())) {
						
						timestamp=importarexportarDataAccess.getSetVersionRowImportarExportar(connexion,importarexportarAux.getId());
						
						if(!importarexportar.getVersionRow().equals(timestamp)) {	
							importarexportarAux.setVersionRow(timestamp);
						}
								
						importarexportarAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowImportarExportars()throws Exception {	
		if(importarexportars!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ImportarExportar importarexportarAux:importarexportars) {
					if(importarexportarAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(importarexportarAux.getIsDeleted() || (importarexportarAux.getIsChanged()&&!importarexportarAux.getIsNew())) {
						
						timestamp=importarexportarDataAccess.getSetVersionRowImportarExportar(connexion,importarexportarAux.getId());
						
						if(!importarexportarAux.getVersionRow().equals(timestamp)) {	
							importarexportarAux.setVersionRow(timestamp);
						}
						
													
						importarexportarAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ImportarExportarParameterReturnGeneral cargarCombosLoteForeignKeyImportarExportarWithConnection(String finalQueryGlobalModulo,String finalQueryGlobalAsientoContable,String finalQueryGlobalPeriodoImportExport,String finalQueryGlobalTransaccionConta,String finalQueryGlobalTipoImportacion,String finalQueryGlobalTipoComprobante,String finalQueryGlobalTipoTributario,String finalQueryGlobalCliente,String finalQueryGlobalTipoIva,String finalQueryGlobalTipoIce,String finalQueryGlobalTipoBanco,String finalQueryGlobalTipoComprobanteBanco) throws Exception {
		ImportarExportarParameterReturnGeneral  importarexportarReturnGeneral =new ImportarExportarParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImportarExportar.class.getSimpleName()+"-cargarCombosLoteForeignKeyImportarExportarWithConnection");connexion.begin();
			
			importarexportarReturnGeneral =new ImportarExportarParameterReturnGeneral();
			
			

			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			importarexportarReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			importarexportarReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);


			List<PeriodoImportExport> periodoimportexportsForeignKey=new ArrayList<PeriodoImportExport>();
			PeriodoImportExportLogic periodoimportexportLogic=new PeriodoImportExportLogic();
			periodoimportexportLogic.setConnexion(this.connexion);
			periodoimportexportLogic.getPeriodoImportExportDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodoImportExport.equals("NONE")) {
				periodoimportexportLogic.getTodosPeriodoImportExports(finalQueryGlobalPeriodoImportExport,new Pagination());
				periodoimportexportsForeignKey=periodoimportexportLogic.getPeriodoImportExports();
			}

			importarexportarReturnGeneral.setperiodoimportexportsForeignKey(periodoimportexportsForeignKey);


			List<TransaccionConta> transaccioncontasForeignKey=new ArrayList<TransaccionConta>();
			TransaccionContaLogic transaccioncontaLogic=new TransaccionContaLogic();
			transaccioncontaLogic.setConnexion(this.connexion);
			transaccioncontaLogic.getTransaccionContaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionConta.equals("NONE")) {
				transaccioncontaLogic.getTodosTransaccionContas(finalQueryGlobalTransaccionConta,new Pagination());
				transaccioncontasForeignKey=transaccioncontaLogic.getTransaccionContas();
			}

			importarexportarReturnGeneral.settransaccioncontasForeignKey(transaccioncontasForeignKey);


			List<TipoImportacion> tipoimportacionsForeignKey=new ArrayList<TipoImportacion>();
			TipoImportacionLogic tipoimportacionLogic=new TipoImportacionLogic();
			tipoimportacionLogic.setConnexion(this.connexion);
			tipoimportacionLogic.getTipoImportacionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoImportacion.equals("NONE")) {
				tipoimportacionLogic.getTodosTipoImportacions(finalQueryGlobalTipoImportacion,new Pagination());
				tipoimportacionsForeignKey=tipoimportacionLogic.getTipoImportacions();
			}

			importarexportarReturnGeneral.settipoimportacionsForeignKey(tipoimportacionsForeignKey);


			List<TipoComprobante> tipocomprobantesForeignKey=new ArrayList<TipoComprobante>();
			TipoComprobanteLogic tipocomprobanteLogic=new TipoComprobanteLogic();
			tipocomprobanteLogic.setConnexion(this.connexion);
			tipocomprobanteLogic.getTipoComprobanteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoComprobante.equals("NONE")) {
				tipocomprobanteLogic.getTodosTipoComprobantes(finalQueryGlobalTipoComprobante,new Pagination());
				tipocomprobantesForeignKey=tipocomprobanteLogic.getTipoComprobantes();
			}

			importarexportarReturnGeneral.settipocomprobantesForeignKey(tipocomprobantesForeignKey);


			List<TipoTributario> tipotributariosForeignKey=new ArrayList<TipoTributario>();
			TipoTributarioLogic tipotributarioLogic=new TipoTributarioLogic();
			tipotributarioLogic.setConnexion(this.connexion);
			tipotributarioLogic.getTipoTributarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTributario.equals("NONE")) {
				tipotributarioLogic.getTodosTipoTributarios(finalQueryGlobalTipoTributario,new Pagination());
				tipotributariosForeignKey=tipotributarioLogic.getTipoTributarios();
			}

			importarexportarReturnGeneral.settipotributariosForeignKey(tipotributariosForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			importarexportarReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoIva> tipoivasForeignKey=new ArrayList<TipoIva>();
			TipoIvaLogic tipoivaLogic=new TipoIvaLogic();
			tipoivaLogic.setConnexion(this.connexion);
			tipoivaLogic.getTipoIvaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoIva.equals("NONE")) {
				tipoivaLogic.getTodosTipoIvas(finalQueryGlobalTipoIva,new Pagination());
				tipoivasForeignKey=tipoivaLogic.getTipoIvas();
			}

			importarexportarReturnGeneral.settipoivasForeignKey(tipoivasForeignKey);


			List<TipoIce> tipoicesForeignKey=new ArrayList<TipoIce>();
			TipoIceLogic tipoiceLogic=new TipoIceLogic();
			tipoiceLogic.setConnexion(this.connexion);
			tipoiceLogic.getTipoIceDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoIce.equals("NONE")) {
				tipoiceLogic.getTodosTipoIces(finalQueryGlobalTipoIce,new Pagination());
				tipoicesForeignKey=tipoiceLogic.getTipoIces();
			}

			importarexportarReturnGeneral.settipoicesForeignKey(tipoicesForeignKey);


			List<TipoBanco> tipobancosForeignKey=new ArrayList<TipoBanco>();
			TipoBancoLogic tipobancoLogic=new TipoBancoLogic();
			tipobancoLogic.setConnexion(this.connexion);
			//tipobancoLogic.getTipoBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoBanco.equals("NONE")) {
				tipobancoLogic.getTodosTipoBancos(finalQueryGlobalTipoBanco,new Pagination());
				tipobancosForeignKey=tipobancoLogic.getTipoBancos();
			}

			importarexportarReturnGeneral.settipobancosForeignKey(tipobancosForeignKey);


			List<TipoComprobante> tipocomprobantebancosForeignKey=new ArrayList<TipoComprobante>();
			TipoComprobanteLogic tipocomprobantebancoLogic=new TipoComprobanteLogic();
			tipocomprobantebancoLogic.setConnexion(this.connexion);
			tipocomprobantebancoLogic.getTipoComprobanteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoComprobanteBanco.equals("NONE")) {
				tipocomprobantebancoLogic.getTodosTipoComprobantes(finalQueryGlobalTipoComprobanteBanco,new Pagination());
				tipocomprobantebancosForeignKey=tipocomprobantebancoLogic.getTipoComprobantes();
			}

			importarexportarReturnGeneral.settipocomprobantebancosForeignKey(tipocomprobantebancosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return importarexportarReturnGeneral;
	}
	
	public ImportarExportarParameterReturnGeneral cargarCombosLoteForeignKeyImportarExportar(String finalQueryGlobalModulo,String finalQueryGlobalAsientoContable,String finalQueryGlobalPeriodoImportExport,String finalQueryGlobalTransaccionConta,String finalQueryGlobalTipoImportacion,String finalQueryGlobalTipoComprobante,String finalQueryGlobalTipoTributario,String finalQueryGlobalCliente,String finalQueryGlobalTipoIva,String finalQueryGlobalTipoIce,String finalQueryGlobalTipoBanco,String finalQueryGlobalTipoComprobanteBanco) throws Exception {
		ImportarExportarParameterReturnGeneral  importarexportarReturnGeneral =new ImportarExportarParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			importarexportarReturnGeneral =new ImportarExportarParameterReturnGeneral();
			
			

			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			importarexportarReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			importarexportarReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);


			List<PeriodoImportExport> periodoimportexportsForeignKey=new ArrayList<PeriodoImportExport>();
			PeriodoImportExportLogic periodoimportexportLogic=new PeriodoImportExportLogic();
			periodoimportexportLogic.setConnexion(this.connexion);
			periodoimportexportLogic.getPeriodoImportExportDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodoImportExport.equals("NONE")) {
				periodoimportexportLogic.getTodosPeriodoImportExports(finalQueryGlobalPeriodoImportExport,new Pagination());
				periodoimportexportsForeignKey=periodoimportexportLogic.getPeriodoImportExports();
			}

			importarexportarReturnGeneral.setperiodoimportexportsForeignKey(periodoimportexportsForeignKey);


			List<TransaccionConta> transaccioncontasForeignKey=new ArrayList<TransaccionConta>();
			TransaccionContaLogic transaccioncontaLogic=new TransaccionContaLogic();
			transaccioncontaLogic.setConnexion(this.connexion);
			transaccioncontaLogic.getTransaccionContaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionConta.equals("NONE")) {
				transaccioncontaLogic.getTodosTransaccionContas(finalQueryGlobalTransaccionConta,new Pagination());
				transaccioncontasForeignKey=transaccioncontaLogic.getTransaccionContas();
			}

			importarexportarReturnGeneral.settransaccioncontasForeignKey(transaccioncontasForeignKey);


			List<TipoImportacion> tipoimportacionsForeignKey=new ArrayList<TipoImportacion>();
			TipoImportacionLogic tipoimportacionLogic=new TipoImportacionLogic();
			tipoimportacionLogic.setConnexion(this.connexion);
			tipoimportacionLogic.getTipoImportacionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoImportacion.equals("NONE")) {
				tipoimportacionLogic.getTodosTipoImportacions(finalQueryGlobalTipoImportacion,new Pagination());
				tipoimportacionsForeignKey=tipoimportacionLogic.getTipoImportacions();
			}

			importarexportarReturnGeneral.settipoimportacionsForeignKey(tipoimportacionsForeignKey);


			List<TipoComprobante> tipocomprobantesForeignKey=new ArrayList<TipoComprobante>();
			TipoComprobanteLogic tipocomprobanteLogic=new TipoComprobanteLogic();
			tipocomprobanteLogic.setConnexion(this.connexion);
			tipocomprobanteLogic.getTipoComprobanteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoComprobante.equals("NONE")) {
				tipocomprobanteLogic.getTodosTipoComprobantes(finalQueryGlobalTipoComprobante,new Pagination());
				tipocomprobantesForeignKey=tipocomprobanteLogic.getTipoComprobantes();
			}

			importarexportarReturnGeneral.settipocomprobantesForeignKey(tipocomprobantesForeignKey);


			List<TipoTributario> tipotributariosForeignKey=new ArrayList<TipoTributario>();
			TipoTributarioLogic tipotributarioLogic=new TipoTributarioLogic();
			tipotributarioLogic.setConnexion(this.connexion);
			tipotributarioLogic.getTipoTributarioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTributario.equals("NONE")) {
				tipotributarioLogic.getTodosTipoTributarios(finalQueryGlobalTipoTributario,new Pagination());
				tipotributariosForeignKey=tipotributarioLogic.getTipoTributarios();
			}

			importarexportarReturnGeneral.settipotributariosForeignKey(tipotributariosForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			importarexportarReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<TipoIva> tipoivasForeignKey=new ArrayList<TipoIva>();
			TipoIvaLogic tipoivaLogic=new TipoIvaLogic();
			tipoivaLogic.setConnexion(this.connexion);
			tipoivaLogic.getTipoIvaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoIva.equals("NONE")) {
				tipoivaLogic.getTodosTipoIvas(finalQueryGlobalTipoIva,new Pagination());
				tipoivasForeignKey=tipoivaLogic.getTipoIvas();
			}

			importarexportarReturnGeneral.settipoivasForeignKey(tipoivasForeignKey);


			List<TipoIce> tipoicesForeignKey=new ArrayList<TipoIce>();
			TipoIceLogic tipoiceLogic=new TipoIceLogic();
			tipoiceLogic.setConnexion(this.connexion);
			tipoiceLogic.getTipoIceDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoIce.equals("NONE")) {
				tipoiceLogic.getTodosTipoIces(finalQueryGlobalTipoIce,new Pagination());
				tipoicesForeignKey=tipoiceLogic.getTipoIces();
			}

			importarexportarReturnGeneral.settipoicesForeignKey(tipoicesForeignKey);


			List<TipoBanco> tipobancosForeignKey=new ArrayList<TipoBanco>();
			TipoBancoLogic tipobancoLogic=new TipoBancoLogic();
			tipobancoLogic.setConnexion(this.connexion);
			//tipobancoLogic.getTipoBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoBanco.equals("NONE")) {
				tipobancoLogic.getTodosTipoBancos(finalQueryGlobalTipoBanco,new Pagination());
				tipobancosForeignKey=tipobancoLogic.getTipoBancos();
			}

			importarexportarReturnGeneral.settipobancosForeignKey(tipobancosForeignKey);


			List<TipoComprobante> tipocomprobantebancosForeignKey=new ArrayList<TipoComprobante>();
			TipoComprobanteLogic tipocomprobantebancoLogic=new TipoComprobanteLogic();
			tipocomprobantebancoLogic.setConnexion(this.connexion);
			tipocomprobantebancoLogic.getTipoComprobanteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoComprobanteBanco.equals("NONE")) {
				tipocomprobantebancoLogic.getTodosTipoComprobantes(finalQueryGlobalTipoComprobanteBanco,new Pagination());
				tipocomprobantebancosForeignKey=tipocomprobantebancoLogic.getTipoComprobantes();
			}

			importarexportarReturnGeneral.settipocomprobantebancosForeignKey(tipocomprobantebancosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return importarexportarReturnGeneral;
	}
	
	
	public void deepLoad(ImportarExportar importarexportar,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ImportarExportarLogicAdditional.updateImportarExportarToGet(importarexportar,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		importarexportar.setModulo(importarexportarDataAccess.getModulo(connexion,importarexportar));
		importarexportar.setAsientoContable(importarexportarDataAccess.getAsientoContable(connexion,importarexportar));
		importarexportar.setPeriodoImportExport(importarexportarDataAccess.getPeriodoImportExport(connexion,importarexportar));
		importarexportar.setTransaccionConta(importarexportarDataAccess.getTransaccionConta(connexion,importarexportar));
		importarexportar.setTipoImportacion(importarexportarDataAccess.getTipoImportacion(connexion,importarexportar));
		importarexportar.setTipoComprobante(importarexportarDataAccess.getTipoComprobante(connexion,importarexportar));
		importarexportar.setTipoTributario(importarexportarDataAccess.getTipoTributario(connexion,importarexportar));
		importarexportar.setCliente(importarexportarDataAccess.getCliente(connexion,importarexportar));
		importarexportar.setTipoIva(importarexportarDataAccess.getTipoIva(connexion,importarexportar));
		importarexportar.setTipoIce(importarexportarDataAccess.getTipoIce(connexion,importarexportar));
		importarexportar.setTipoBanco(importarexportarDataAccess.getTipoBanco(connexion,importarexportar));
		importarexportar.setTipoComprobanteBanco(importarexportarDataAccess.getTipoComprobanteBanco(connexion,importarexportar));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				importarexportar.setModulo(importarexportarDataAccess.getModulo(connexion,importarexportar));
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				importarexportar.setAsientoContable(importarexportarDataAccess.getAsientoContable(connexion,importarexportar));
				continue;
			}

			if(clas.clas.equals(PeriodoImportExport.class)) {
				importarexportar.setPeriodoImportExport(importarexportarDataAccess.getPeriodoImportExport(connexion,importarexportar));
				continue;
			}

			if(clas.clas.equals(TransaccionConta.class)) {
				importarexportar.setTransaccionConta(importarexportarDataAccess.getTransaccionConta(connexion,importarexportar));
				continue;
			}

			if(clas.clas.equals(TipoImportacion.class)) {
				importarexportar.setTipoImportacion(importarexportarDataAccess.getTipoImportacion(connexion,importarexportar));
				continue;
			}

			if(clas.clas.equals(TipoComprobante.class)) {
				importarexportar.setTipoComprobante(importarexportarDataAccess.getTipoComprobante(connexion,importarexportar));
				continue;
			}

			if(clas.clas.equals(TipoTributario.class)) {
				importarexportar.setTipoTributario(importarexportarDataAccess.getTipoTributario(connexion,importarexportar));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				importarexportar.setCliente(importarexportarDataAccess.getCliente(connexion,importarexportar));
				continue;
			}

			if(clas.clas.equals(TipoIva.class)) {
				importarexportar.setTipoIva(importarexportarDataAccess.getTipoIva(connexion,importarexportar));
				continue;
			}

			if(clas.clas.equals(TipoIce.class)) {
				importarexportar.setTipoIce(importarexportarDataAccess.getTipoIce(connexion,importarexportar));
				continue;
			}

			if(clas.clas.equals(TipoBanco.class)) {
				importarexportar.setTipoBanco(importarexportarDataAccess.getTipoBanco(connexion,importarexportar));
				continue;
			}

			if(clas.clas.equals(TipoComprobante.class)) {
				importarexportar.setTipoComprobanteBanco(importarexportarDataAccess.getTipoComprobanteBanco(connexion,importarexportar));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			importarexportar.setModulo(importarexportarDataAccess.getModulo(connexion,importarexportar));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			importarexportar.setAsientoContable(importarexportarDataAccess.getAsientoContable(connexion,importarexportar));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PeriodoImportExport.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			importarexportar.setPeriodoImportExport(importarexportarDataAccess.getPeriodoImportExport(connexion,importarexportar));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TransaccionConta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			importarexportar.setTransaccionConta(importarexportarDataAccess.getTransaccionConta(connexion,importarexportar));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoImportacion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			importarexportar.setTipoImportacion(importarexportarDataAccess.getTipoImportacion(connexion,importarexportar));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoComprobante.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			importarexportar.setTipoComprobante(importarexportarDataAccess.getTipoComprobante(connexion,importarexportar));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTributario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			importarexportar.setTipoTributario(importarexportarDataAccess.getTipoTributario(connexion,importarexportar));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			importarexportar.setCliente(importarexportarDataAccess.getCliente(connexion,importarexportar));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIva.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			importarexportar.setTipoIva(importarexportarDataAccess.getTipoIva(connexion,importarexportar));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIce.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			importarexportar.setTipoIce(importarexportarDataAccess.getTipoIce(connexion,importarexportar));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoBanco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			importarexportar.setTipoBanco(importarexportarDataAccess.getTipoBanco(connexion,importarexportar));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoComprobante.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			importarexportar.setTipoComprobanteBanco(importarexportarDataAccess.getTipoComprobanteBanco(connexion,importarexportar));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		importarexportar.setModulo(importarexportarDataAccess.getModulo(connexion,importarexportar));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(importarexportar.getModulo(),isDeep,deepLoadType,clases);
				
		importarexportar.setAsientoContable(importarexportarDataAccess.getAsientoContable(connexion,importarexportar));
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(importarexportar.getAsientoContable(),isDeep,deepLoadType,clases);
				
		importarexportar.setPeriodoImportExport(importarexportarDataAccess.getPeriodoImportExport(connexion,importarexportar));
		PeriodoImportExportLogic periodoimportexportLogic= new PeriodoImportExportLogic(connexion);
		periodoimportexportLogic.deepLoad(importarexportar.getPeriodoImportExport(),isDeep,deepLoadType,clases);
				
		importarexportar.setTransaccionConta(importarexportarDataAccess.getTransaccionConta(connexion,importarexportar));
		TransaccionContaLogic transaccioncontaLogic= new TransaccionContaLogic(connexion);
		transaccioncontaLogic.deepLoad(importarexportar.getTransaccionConta(),isDeep,deepLoadType,clases);
				
		importarexportar.setTipoImportacion(importarexportarDataAccess.getTipoImportacion(connexion,importarexportar));
		TipoImportacionLogic tipoimportacionLogic= new TipoImportacionLogic(connexion);
		tipoimportacionLogic.deepLoad(importarexportar.getTipoImportacion(),isDeep,deepLoadType,clases);
				
		importarexportar.setTipoComprobante(importarexportarDataAccess.getTipoComprobante(connexion,importarexportar));
		TipoComprobanteLogic tipocomprobanteLogic= new TipoComprobanteLogic(connexion);
		tipocomprobanteLogic.deepLoad(importarexportar.getTipoComprobante(),isDeep,deepLoadType,clases);
				
		importarexportar.setTipoTributario(importarexportarDataAccess.getTipoTributario(connexion,importarexportar));
		TipoTributarioLogic tipotributarioLogic= new TipoTributarioLogic(connexion);
		tipotributarioLogic.deepLoad(importarexportar.getTipoTributario(),isDeep,deepLoadType,clases);
				
		importarexportar.setCliente(importarexportarDataAccess.getCliente(connexion,importarexportar));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(importarexportar.getCliente(),isDeep,deepLoadType,clases);
				
		importarexportar.setTipoIva(importarexportarDataAccess.getTipoIva(connexion,importarexportar));
		TipoIvaLogic tipoivaLogic= new TipoIvaLogic(connexion);
		tipoivaLogic.deepLoad(importarexportar.getTipoIva(),isDeep,deepLoadType,clases);
				
		importarexportar.setTipoIce(importarexportarDataAccess.getTipoIce(connexion,importarexportar));
		TipoIceLogic tipoiceLogic= new TipoIceLogic(connexion);
		tipoiceLogic.deepLoad(importarexportar.getTipoIce(),isDeep,deepLoadType,clases);
				
		importarexportar.setTipoBanco(importarexportarDataAccess.getTipoBanco(connexion,importarexportar));
		TipoBancoLogic tipobancoLogic= new TipoBancoLogic(connexion);
		tipobancoLogic.deepLoad(importarexportar.getTipoBanco(),isDeep,deepLoadType,clases);
				
		importarexportar.setTipoComprobanteBanco(importarexportarDataAccess.getTipoComprobanteBanco(connexion,importarexportar));
		TipoComprobanteLogic tipocomprobantebancoLogic= new TipoComprobanteLogic(connexion);
		tipocomprobantebancoLogic.deepLoad(importarexportar.getTipoComprobanteBanco(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				importarexportar.setModulo(importarexportarDataAccess.getModulo(connexion,importarexportar));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(importarexportar.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				importarexportar.setAsientoContable(importarexportarDataAccess.getAsientoContable(connexion,importarexportar));
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepLoad(importarexportar.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PeriodoImportExport.class)) {
				importarexportar.setPeriodoImportExport(importarexportarDataAccess.getPeriodoImportExport(connexion,importarexportar));
				PeriodoImportExportLogic periodoimportexportLogic= new PeriodoImportExportLogic(connexion);
				periodoimportexportLogic.deepLoad(importarexportar.getPeriodoImportExport(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TransaccionConta.class)) {
				importarexportar.setTransaccionConta(importarexportarDataAccess.getTransaccionConta(connexion,importarexportar));
				TransaccionContaLogic transaccioncontaLogic= new TransaccionContaLogic(connexion);
				transaccioncontaLogic.deepLoad(importarexportar.getTransaccionConta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoImportacion.class)) {
				importarexportar.setTipoImportacion(importarexportarDataAccess.getTipoImportacion(connexion,importarexportar));
				TipoImportacionLogic tipoimportacionLogic= new TipoImportacionLogic(connexion);
				tipoimportacionLogic.deepLoad(importarexportar.getTipoImportacion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoComprobante.class)) {
				importarexportar.setTipoComprobante(importarexportarDataAccess.getTipoComprobante(connexion,importarexportar));
				TipoComprobanteLogic tipocomprobanteLogic= new TipoComprobanteLogic(connexion);
				tipocomprobanteLogic.deepLoad(importarexportar.getTipoComprobante(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTributario.class)) {
				importarexportar.setTipoTributario(importarexportarDataAccess.getTipoTributario(connexion,importarexportar));
				TipoTributarioLogic tipotributarioLogic= new TipoTributarioLogic(connexion);
				tipotributarioLogic.deepLoad(importarexportar.getTipoTributario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				importarexportar.setCliente(importarexportarDataAccess.getCliente(connexion,importarexportar));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(importarexportar.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoIva.class)) {
				importarexportar.setTipoIva(importarexportarDataAccess.getTipoIva(connexion,importarexportar));
				TipoIvaLogic tipoivaLogic= new TipoIvaLogic(connexion);
				tipoivaLogic.deepLoad(importarexportar.getTipoIva(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoIce.class)) {
				importarexportar.setTipoIce(importarexportarDataAccess.getTipoIce(connexion,importarexportar));
				TipoIceLogic tipoiceLogic= new TipoIceLogic(connexion);
				tipoiceLogic.deepLoad(importarexportar.getTipoIce(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoBanco.class)) {
				importarexportar.setTipoBanco(importarexportarDataAccess.getTipoBanco(connexion,importarexportar));
				TipoBancoLogic tipobancoLogic= new TipoBancoLogic(connexion);
				tipobancoLogic.deepLoad(importarexportar.getTipoBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoComprobante.class)) {
				importarexportar.setTipoComprobanteBanco(importarexportarDataAccess.getTipoComprobanteBanco(connexion,importarexportar));
				TipoComprobanteLogic tipocomprobanteLogic= new TipoComprobanteLogic(connexion);
				tipocomprobanteLogic.deepLoad(importarexportar.getTipoComprobanteBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			importarexportar.setModulo(importarexportarDataAccess.getModulo(connexion,importarexportar));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(importarexportar.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			importarexportar.setAsientoContable(importarexportarDataAccess.getAsientoContable(connexion,importarexportar));
			AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
			asientocontableLogic.deepLoad(importarexportar.getAsientoContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(PeriodoImportExport.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			importarexportar.setPeriodoImportExport(importarexportarDataAccess.getPeriodoImportExport(connexion,importarexportar));
			PeriodoImportExportLogic periodoimportexportLogic= new PeriodoImportExportLogic(connexion);
			periodoimportexportLogic.deepLoad(importarexportar.getPeriodoImportExport(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TransaccionConta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			importarexportar.setTransaccionConta(importarexportarDataAccess.getTransaccionConta(connexion,importarexportar));
			TransaccionContaLogic transaccioncontaLogic= new TransaccionContaLogic(connexion);
			transaccioncontaLogic.deepLoad(importarexportar.getTransaccionConta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoImportacion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			importarexportar.setTipoImportacion(importarexportarDataAccess.getTipoImportacion(connexion,importarexportar));
			TipoImportacionLogic tipoimportacionLogic= new TipoImportacionLogic(connexion);
			tipoimportacionLogic.deepLoad(importarexportar.getTipoImportacion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoComprobante.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			importarexportar.setTipoComprobante(importarexportarDataAccess.getTipoComprobante(connexion,importarexportar));
			TipoComprobanteLogic tipocomprobanteLogic= new TipoComprobanteLogic(connexion);
			tipocomprobanteLogic.deepLoad(importarexportar.getTipoComprobante(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTributario.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			importarexportar.setTipoTributario(importarexportarDataAccess.getTipoTributario(connexion,importarexportar));
			TipoTributarioLogic tipotributarioLogic= new TipoTributarioLogic(connexion);
			tipotributarioLogic.deepLoad(importarexportar.getTipoTributario(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			importarexportar.setCliente(importarexportarDataAccess.getCliente(connexion,importarexportar));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(importarexportar.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIva.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			importarexportar.setTipoIva(importarexportarDataAccess.getTipoIva(connexion,importarexportar));
			TipoIvaLogic tipoivaLogic= new TipoIvaLogic(connexion);
			tipoivaLogic.deepLoad(importarexportar.getTipoIva(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoIce.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			importarexportar.setTipoIce(importarexportarDataAccess.getTipoIce(connexion,importarexportar));
			TipoIceLogic tipoiceLogic= new TipoIceLogic(connexion);
			tipoiceLogic.deepLoad(importarexportar.getTipoIce(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoBanco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			importarexportar.setTipoBanco(importarexportarDataAccess.getTipoBanco(connexion,importarexportar));
			TipoBancoLogic tipobancoLogic= new TipoBancoLogic(connexion);
			tipobancoLogic.deepLoad(importarexportar.getTipoBanco(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoComprobante.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			importarexportar.setTipoComprobanteBanco(importarexportarDataAccess.getTipoComprobanteBanco(connexion,importarexportar));
			TipoComprobanteLogic tipocomprobanteLogic= new TipoComprobanteLogic(connexion);
			tipocomprobanteLogic.deepLoad(importarexportar.getTipoComprobanteBanco(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ImportarExportar importarexportar,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ImportarExportarLogicAdditional.updateImportarExportarToSave(importarexportar,this.arrDatoGeneral);
			
ImportarExportarDataAccess.save(importarexportar, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ModuloDataAccess.save(importarexportar.getModulo(),connexion);

		AsientoContableDataAccess.save(importarexportar.getAsientoContable(),connexion);

		PeriodoImportExportDataAccess.save(importarexportar.getPeriodoImportExport(),connexion);

		TransaccionContaDataAccess.save(importarexportar.getTransaccionConta(),connexion);

		TipoImportacionDataAccess.save(importarexportar.getTipoImportacion(),connexion);

		TipoComprobanteDataAccess.save(importarexportar.getTipoComprobante(),connexion);

		TipoTributarioDataAccess.save(importarexportar.getTipoTributario(),connexion);

		ClienteDataAccess.save(importarexportar.getCliente(),connexion);

		TipoIvaDataAccess.save(importarexportar.getTipoIva(),connexion);

		TipoIceDataAccess.save(importarexportar.getTipoIce(),connexion);

		TipoBancoDataAccess.save(importarexportar.getTipoBanco(),connexion);

		TipoComprobanteDataAccess.save(importarexportar.getTipoComprobanteBanco(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(importarexportar.getModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(importarexportar.getAsientoContable(),connexion);
				continue;
			}

			if(clas.clas.equals(PeriodoImportExport.class)) {
				PeriodoImportExportDataAccess.save(importarexportar.getPeriodoImportExport(),connexion);
				continue;
			}

			if(clas.clas.equals(TransaccionConta.class)) {
				TransaccionContaDataAccess.save(importarexportar.getTransaccionConta(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoImportacion.class)) {
				TipoImportacionDataAccess.save(importarexportar.getTipoImportacion(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoComprobante.class)) {
				TipoComprobanteDataAccess.save(importarexportar.getTipoComprobante(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoTributario.class)) {
				TipoTributarioDataAccess.save(importarexportar.getTipoTributario(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(importarexportar.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoIva.class)) {
				TipoIvaDataAccess.save(importarexportar.getTipoIva(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoIce.class)) {
				TipoIceDataAccess.save(importarexportar.getTipoIce(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoBanco.class)) {
				TipoBancoDataAccess.save(importarexportar.getTipoBanco(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoComprobante.class)) {
				TipoComprobanteDataAccess.save(importarexportar.getTipoComprobanteBanco(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		ModuloDataAccess.save(importarexportar.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(importarexportar.getModulo(),isDeep,deepLoadType,clases);
				

		AsientoContableDataAccess.save(importarexportar.getAsientoContable(),connexion);
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(importarexportar.getAsientoContable(),isDeep,deepLoadType,clases);
				

		PeriodoImportExportDataAccess.save(importarexportar.getPeriodoImportExport(),connexion);
		PeriodoImportExportLogic periodoimportexportLogic= new PeriodoImportExportLogic(connexion);
		periodoimportexportLogic.deepLoad(importarexportar.getPeriodoImportExport(),isDeep,deepLoadType,clases);
				

		TransaccionContaDataAccess.save(importarexportar.getTransaccionConta(),connexion);
		TransaccionContaLogic transaccioncontaLogic= new TransaccionContaLogic(connexion);
		transaccioncontaLogic.deepLoad(importarexportar.getTransaccionConta(),isDeep,deepLoadType,clases);
				

		TipoImportacionDataAccess.save(importarexportar.getTipoImportacion(),connexion);
		TipoImportacionLogic tipoimportacionLogic= new TipoImportacionLogic(connexion);
		tipoimportacionLogic.deepLoad(importarexportar.getTipoImportacion(),isDeep,deepLoadType,clases);
				

		TipoComprobanteDataAccess.save(importarexportar.getTipoComprobante(),connexion);
		TipoComprobanteLogic tipocomprobanteLogic= new TipoComprobanteLogic(connexion);
		tipocomprobanteLogic.deepLoad(importarexportar.getTipoComprobante(),isDeep,deepLoadType,clases);
				

		TipoTributarioDataAccess.save(importarexportar.getTipoTributario(),connexion);
		TipoTributarioLogic tipotributarioLogic= new TipoTributarioLogic(connexion);
		tipotributarioLogic.deepLoad(importarexportar.getTipoTributario(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(importarexportar.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(importarexportar.getCliente(),isDeep,deepLoadType,clases);
				

		TipoIvaDataAccess.save(importarexportar.getTipoIva(),connexion);
		TipoIvaLogic tipoivaLogic= new TipoIvaLogic(connexion);
		tipoivaLogic.deepLoad(importarexportar.getTipoIva(),isDeep,deepLoadType,clases);
				

		TipoIceDataAccess.save(importarexportar.getTipoIce(),connexion);
		TipoIceLogic tipoiceLogic= new TipoIceLogic(connexion);
		tipoiceLogic.deepLoad(importarexportar.getTipoIce(),isDeep,deepLoadType,clases);
				

		TipoBancoDataAccess.save(importarexportar.getTipoBanco(),connexion);
		TipoBancoLogic tipobancoLogic= new TipoBancoLogic(connexion);
		tipobancoLogic.deepLoad(importarexportar.getTipoBanco(),isDeep,deepLoadType,clases);
				

		TipoComprobanteDataAccess.save(importarexportar.getTipoComprobanteBanco(),connexion);
		TipoComprobanteLogic tipocomprobantebancoLogic= new TipoComprobanteLogic(connexion);
		tipocomprobantebancoLogic.deepLoad(importarexportar.getTipoComprobanteBanco(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(importarexportar.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(importarexportar.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(importarexportar.getAsientoContable(),connexion);
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepSave(importarexportar.getAsientoContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PeriodoImportExport.class)) {
				PeriodoImportExportDataAccess.save(importarexportar.getPeriodoImportExport(),connexion);
				PeriodoImportExportLogic periodoimportexportLogic= new PeriodoImportExportLogic(connexion);
				periodoimportexportLogic.deepSave(importarexportar.getPeriodoImportExport(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TransaccionConta.class)) {
				TransaccionContaDataAccess.save(importarexportar.getTransaccionConta(),connexion);
				TransaccionContaLogic transaccioncontaLogic= new TransaccionContaLogic(connexion);
				transaccioncontaLogic.deepSave(importarexportar.getTransaccionConta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoImportacion.class)) {
				TipoImportacionDataAccess.save(importarexportar.getTipoImportacion(),connexion);
				TipoImportacionLogic tipoimportacionLogic= new TipoImportacionLogic(connexion);
				tipoimportacionLogic.deepSave(importarexportar.getTipoImportacion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoComprobante.class)) {
				TipoComprobanteDataAccess.save(importarexportar.getTipoComprobante(),connexion);
				TipoComprobanteLogic tipocomprobanteLogic= new TipoComprobanteLogic(connexion);
				tipocomprobanteLogic.deepSave(importarexportar.getTipoComprobante(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTributario.class)) {
				TipoTributarioDataAccess.save(importarexportar.getTipoTributario(),connexion);
				TipoTributarioLogic tipotributarioLogic= new TipoTributarioLogic(connexion);
				tipotributarioLogic.deepSave(importarexportar.getTipoTributario(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(importarexportar.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(importarexportar.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoIva.class)) {
				TipoIvaDataAccess.save(importarexportar.getTipoIva(),connexion);
				TipoIvaLogic tipoivaLogic= new TipoIvaLogic(connexion);
				tipoivaLogic.deepSave(importarexportar.getTipoIva(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoIce.class)) {
				TipoIceDataAccess.save(importarexportar.getTipoIce(),connexion);
				TipoIceLogic tipoiceLogic= new TipoIceLogic(connexion);
				tipoiceLogic.deepSave(importarexportar.getTipoIce(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoBanco.class)) {
				TipoBancoDataAccess.save(importarexportar.getTipoBanco(),connexion);
				TipoBancoLogic tipobancoLogic= new TipoBancoLogic(connexion);
				tipobancoLogic.deepSave(importarexportar.getTipoBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoComprobante.class)) {
				TipoComprobanteDataAccess.save(importarexportar.getTipoComprobanteBanco(),connexion);
				TipoComprobanteLogic tipocomprobanteLogic= new TipoComprobanteLogic(connexion);
				tipocomprobanteLogic.deepSave(importarexportar.getTipoComprobanteBanco(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ImportarExportar.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(importarexportar,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(importarexportar);
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
			this.deepLoad(this.importarexportar,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportar);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ImportarExportar.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(importarexportars!=null) {
				for(ImportarExportar importarexportar:importarexportars) {
					this.deepLoad(importarexportar,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(importarexportars);
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
			if(importarexportars!=null) {
				for(ImportarExportar importarexportar:importarexportars) {
					this.deepLoad(importarexportar,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(importarexportars);
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
			this.getNewConnexionToDeep(ImportarExportar.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(importarexportar,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ImportarExportar.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(importarexportars!=null) {
				for(ImportarExportar importarexportar:importarexportars) {
					this.deepSave(importarexportar,isDeep,deepLoadType,clases);
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
			if(importarexportars!=null) {
				for(ImportarExportar importarexportar:importarexportars) {
					this.deepSave(importarexportar,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getImportarExportarsBusquedaPorNumeroComprobanteWithConnection(String sFinalQuery,Pagination pagination,String numero_comprobante)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImportarExportar.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNumeroComprobante= new ParameterSelectionGeneral();
			parameterSelectionGeneralNumeroComprobante.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+numero_comprobante+"%",ImportarExportarConstantesFunciones.NUMEROCOMPROBANTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNumeroComprobante);

			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNumeroComprobante","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			importarexportars=importarexportarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportars);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getImportarExportarsBusquedaPorNumeroComprobante(String sFinalQuery,Pagination pagination,String numero_comprobante)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNumeroComprobante= new ParameterSelectionGeneral();
			parameterSelectionGeneralNumeroComprobante.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+numero_comprobante+"%",ImportarExportarConstantesFunciones.NUMEROCOMPROBANTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNumeroComprobante);

			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNumeroComprobante","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			importarexportars=importarexportarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportars);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getImportarExportarsBusquedaPorRucInformanteWithConnection(String sFinalQuery,Pagination pagination,String ruc)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImportarExportar.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralRucInformante= new ParameterSelectionGeneral();
			parameterSelectionGeneralRucInformante.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+ruc+"%",ImportarExportarConstantesFunciones.RUCINFORMANTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralRucInformante);

			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorRucInformante","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			importarexportars=importarexportarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportars);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getImportarExportarsBusquedaPorRucInformante(String sFinalQuery,Pagination pagination,String ruc)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralRucInformante= new ParameterSelectionGeneral();
			parameterSelectionGeneralRucInformante.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+ruc+"%",ImportarExportarConstantesFunciones.RUCINFORMANTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralRucInformante);

			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorRucInformante","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			importarexportars=importarexportarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportars);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getImportarExportarsFK_IdAsientoContableWithConnection(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImportarExportar.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,ImportarExportarConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			importarexportars=importarexportarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportars);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getImportarExportarsFK_IdAsientoContable(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,ImportarExportarConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			importarexportars=importarexportarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportars);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getImportarExportarsFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImportarExportar.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,ImportarExportarConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			importarexportars=importarexportarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportars);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getImportarExportarsFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,ImportarExportarConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			importarexportars=importarexportarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportars);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getImportarExportarsFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImportarExportar.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,ImportarExportarConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			importarexportars=importarexportarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportars);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getImportarExportarsFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,ImportarExportarConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			importarexportars=importarexportarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportars);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getImportarExportarsFK_IdPeriodoImportExportWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo_import_export)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImportarExportar.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodoImportExport= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodoImportExport.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo_import_export,ImportarExportarConstantesFunciones.IDPERIODOIMPORTEXPORT,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodoImportExport);

			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodoImportExport","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			importarexportars=importarexportarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportars);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getImportarExportarsFK_IdPeriodoImportExport(String sFinalQuery,Pagination pagination,Long id_periodo_import_export)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodoImportExport= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodoImportExport.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo_import_export,ImportarExportarConstantesFunciones.IDPERIODOIMPORTEXPORT,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodoImportExport);

			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodoImportExport","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			importarexportars=importarexportarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportars);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getImportarExportarsFK_IdTipoBancoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_banco)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImportarExportar.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_banco,ImportarExportarConstantesFunciones.IDTIPOBANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoBanco);

			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			importarexportars=importarexportarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportars);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getImportarExportarsFK_IdTipoBanco(String sFinalQuery,Pagination pagination,Long id_tipo_banco)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_banco,ImportarExportarConstantesFunciones.IDTIPOBANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoBanco);

			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			importarexportars=importarexportarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportars);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getImportarExportarsFK_IdTipoComprobanteWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_comprobante)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImportarExportar.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoComprobante= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoComprobante.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_comprobante,ImportarExportarConstantesFunciones.IDTIPOCOMPROBANTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoComprobante);

			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoComprobante","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			importarexportars=importarexportarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportars);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getImportarExportarsFK_IdTipoComprobante(String sFinalQuery,Pagination pagination,Long id_tipo_comprobante)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoComprobante= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoComprobante.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_comprobante,ImportarExportarConstantesFunciones.IDTIPOCOMPROBANTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoComprobante);

			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoComprobante","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			importarexportars=importarexportarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportars);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getImportarExportarsFK_IdTipoComprobanteBancoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_comprobante_banco)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImportarExportar.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoComprobanteBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoComprobanteBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_comprobante_banco,ImportarExportarConstantesFunciones.IDTIPOCOMPROBANTEBANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoComprobanteBanco);

			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoComprobanteBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			importarexportars=importarexportarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportars);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getImportarExportarsFK_IdTipoComprobanteBanco(String sFinalQuery,Pagination pagination,Long id_tipo_comprobante_banco)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoComprobanteBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoComprobanteBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_comprobante_banco,ImportarExportarConstantesFunciones.IDTIPOCOMPROBANTEBANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoComprobanteBanco);

			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoComprobanteBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			importarexportars=importarexportarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportars);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getImportarExportarsFK_IdTipoIceWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_ice)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImportarExportar.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoIce= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoIce.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_ice,ImportarExportarConstantesFunciones.IDTIPOICE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoIce);

			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoIce","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			importarexportars=importarexportarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportars);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getImportarExportarsFK_IdTipoIce(String sFinalQuery,Pagination pagination,Long id_tipo_ice)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoIce= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoIce.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_ice,ImportarExportarConstantesFunciones.IDTIPOICE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoIce);

			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoIce","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			importarexportars=importarexportarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportars);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getImportarExportarsFK_IdTipoImportacionWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_importacion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImportarExportar.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoImportacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoImportacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_importacion,ImportarExportarConstantesFunciones.IDTIPOIMPORTACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoImportacion);

			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoImportacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			importarexportars=importarexportarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportars);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getImportarExportarsFK_IdTipoImportacion(String sFinalQuery,Pagination pagination,Long id_tipo_importacion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoImportacion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoImportacion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_importacion,ImportarExportarConstantesFunciones.IDTIPOIMPORTACION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoImportacion);

			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoImportacion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			importarexportars=importarexportarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportars);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getImportarExportarsFK_IdTipoIvaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_iva)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImportarExportar.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoIva= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoIva.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_iva,ImportarExportarConstantesFunciones.IDTIPOIVA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoIva);

			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoIva","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			importarexportars=importarexportarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportars);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getImportarExportarsFK_IdTipoIva(String sFinalQuery,Pagination pagination,Long id_tipo_iva)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoIva= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoIva.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_iva,ImportarExportarConstantesFunciones.IDTIPOIVA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoIva);

			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoIva","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			importarexportars=importarexportarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportars);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getImportarExportarsFK_IdTipoTributarioWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_tributario)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImportarExportar.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTributario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTributario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_tributario,ImportarExportarConstantesFunciones.IDTIPOTRIBUTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTributario);

			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTributario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			importarexportars=importarexportarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportars);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getImportarExportarsFK_IdTipoTributario(String sFinalQuery,Pagination pagination,Long id_tipo_tributario)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTributario= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTributario.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_tributario,ImportarExportarConstantesFunciones.IDTIPOTRIBUTARIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTributario);

			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTributario","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			importarexportars=importarexportarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportars);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getImportarExportarsFK_IdTransaccionContaWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion_conta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ImportarExportar.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionConta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionConta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_conta,ImportarExportarConstantesFunciones.IDTRANSACCIONCONTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionConta);

			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionConta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			importarexportars=importarexportarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportars);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getImportarExportarsFK_IdTransaccionConta(String sFinalQuery,Pagination pagination,Long id_transaccion_conta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionConta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionConta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_conta,ImportarExportarConstantesFunciones.IDTRANSACCIONCONTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionConta);

			ImportarExportarLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionConta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			importarexportars=importarexportarDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ImportarExportarConstantesFunciones.refrescarForeignKeysDescripcionesImportarExportar(this.importarexportars);
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
			if(ImportarExportarConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ImportarExportarDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ImportarExportar importarexportar,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ImportarExportarConstantesFunciones.ISCONAUDITORIA) {
				if(importarexportar.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ImportarExportarDataAccess.TABLENAME, importarexportar.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ImportarExportarConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ImportarExportarLogic.registrarAuditoriaDetallesImportarExportar(connexion,importarexportar,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(importarexportar.getIsDeleted()) {
					/*if(!importarexportar.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ImportarExportarDataAccess.TABLENAME, importarexportar.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ImportarExportarLogic.registrarAuditoriaDetallesImportarExportar(connexion,importarexportar,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ImportarExportarDataAccess.TABLENAME, importarexportar.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(importarexportar.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ImportarExportarDataAccess.TABLENAME, importarexportar.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ImportarExportarConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ImportarExportarLogic.registrarAuditoriaDetallesImportarExportar(connexion,importarexportar,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesImportarExportar(Connexion connexion,ImportarExportar importarexportar)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(importarexportar.getIsNew()||!importarexportar.getid_modulo().equals(importarexportar.getImportarExportarOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(importarexportar.getImportarExportarOriginal().getid_modulo()!=null)
				{
					strValorActual=importarexportar.getImportarExportarOriginal().getid_modulo().toString();
				}
				if(importarexportar.getid_modulo()!=null)
				{
					strValorNuevo=importarexportar.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ImportarExportarConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(importarexportar.getIsNew()||!importarexportar.getid_asiento_contable().equals(importarexportar.getImportarExportarOriginal().getid_asiento_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(importarexportar.getImportarExportarOriginal().getid_asiento_contable()!=null)
				{
					strValorActual=importarexportar.getImportarExportarOriginal().getid_asiento_contable().toString();
				}
				if(importarexportar.getid_asiento_contable()!=null)
				{
					strValorNuevo=importarexportar.getid_asiento_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ImportarExportarConstantesFunciones.IDASIENTOCONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(importarexportar.getIsNew()||!importarexportar.getruc().equals(importarexportar.getImportarExportarOriginal().getruc()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(importarexportar.getImportarExportarOriginal().getruc()!=null)
				{
					strValorActual=importarexportar.getImportarExportarOriginal().getruc();
				}
				if(importarexportar.getruc()!=null)
				{
					strValorNuevo=importarexportar.getruc() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ImportarExportarConstantesFunciones.RUCINFORMANTE,strValorActual,strValorNuevo);
			}	
			
			if(importarexportar.getIsNew()||!importarexportar.getid_periodo_import_export().equals(importarexportar.getImportarExportarOriginal().getid_periodo_import_export()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(importarexportar.getImportarExportarOriginal().getid_periodo_import_export()!=null)
				{
					strValorActual=importarexportar.getImportarExportarOriginal().getid_periodo_import_export().toString();
				}
				if(importarexportar.getid_periodo_import_export()!=null)
				{
					strValorNuevo=importarexportar.getid_periodo_import_export().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ImportarExportarConstantesFunciones.IDPERIODOIMPORTEXPORT,strValorActual,strValorNuevo);
			}	
			
			if(importarexportar.getIsNew()||!importarexportar.getid_transaccion_conta().equals(importarexportar.getImportarExportarOriginal().getid_transaccion_conta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(importarexportar.getImportarExportarOriginal().getid_transaccion_conta()!=null)
				{
					strValorActual=importarexportar.getImportarExportarOriginal().getid_transaccion_conta().toString();
				}
				if(importarexportar.getid_transaccion_conta()!=null)
				{
					strValorNuevo=importarexportar.getid_transaccion_conta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ImportarExportarConstantesFunciones.IDTRANSACCIONCONTA,strValorActual,strValorNuevo);
			}	
			
			if(importarexportar.getIsNew()||!importarexportar.getfecha().equals(importarexportar.getImportarExportarOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(importarexportar.getImportarExportarOriginal().getfecha()!=null)
				{
					strValorActual=importarexportar.getImportarExportarOriginal().getfecha().toString();
				}
				if(importarexportar.getfecha()!=null)
				{
					strValorNuevo=importarexportar.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ImportarExportarConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(importarexportar.getIsNew()||!importarexportar.getid_tipo_importacion().equals(importarexportar.getImportarExportarOriginal().getid_tipo_importacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(importarexportar.getImportarExportarOriginal().getid_tipo_importacion()!=null)
				{
					strValorActual=importarexportar.getImportarExportarOriginal().getid_tipo_importacion().toString();
				}
				if(importarexportar.getid_tipo_importacion()!=null)
				{
					strValorNuevo=importarexportar.getid_tipo_importacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ImportarExportarConstantesFunciones.IDTIPOIMPORTACION,strValorActual,strValorNuevo);
			}	
			
			if(importarexportar.getIsNew()||!importarexportar.getid_tipo_comprobante().equals(importarexportar.getImportarExportarOriginal().getid_tipo_comprobante()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(importarexportar.getImportarExportarOriginal().getid_tipo_comprobante()!=null)
				{
					strValorActual=importarexportar.getImportarExportarOriginal().getid_tipo_comprobante().toString();
				}
				if(importarexportar.getid_tipo_comprobante()!=null)
				{
					strValorNuevo=importarexportar.getid_tipo_comprobante().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ImportarExportarConstantesFunciones.IDTIPOCOMPROBANTE,strValorActual,strValorNuevo);
			}	
			
			if(importarexportar.getIsNew()||!importarexportar.getnumero_comprobante().equals(importarexportar.getImportarExportarOriginal().getnumero_comprobante()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(importarexportar.getImportarExportarOriginal().getnumero_comprobante()!=null)
				{
					strValorActual=importarexportar.getImportarExportarOriginal().getnumero_comprobante();
				}
				if(importarexportar.getnumero_comprobante()!=null)
				{
					strValorNuevo=importarexportar.getnumero_comprobante() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ImportarExportarConstantesFunciones.NUMEROCOMPROBANTE,strValorActual,strValorNuevo);
			}	
			
			if(importarexportar.getIsNew()||!importarexportar.getdocumento_transporte().equals(importarexportar.getImportarExportarOriginal().getdocumento_transporte()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(importarexportar.getImportarExportarOriginal().getdocumento_transporte()!=null)
				{
					strValorActual=importarexportar.getImportarExportarOriginal().getdocumento_transporte();
				}
				if(importarexportar.getdocumento_transporte()!=null)
				{
					strValorNuevo=importarexportar.getdocumento_transporte() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ImportarExportarConstantesFunciones.DOCUMENTOTRANSPORTE,strValorActual,strValorNuevo);
			}	
			
			if(importarexportar.getIsNew()||!importarexportar.getnumero_referencia_comprobante().equals(importarexportar.getImportarExportarOriginal().getnumero_referencia_comprobante()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(importarexportar.getImportarExportarOriginal().getnumero_referencia_comprobante()!=null)
				{
					strValorActual=importarexportar.getImportarExportarOriginal().getnumero_referencia_comprobante();
				}
				if(importarexportar.getnumero_referencia_comprobante()!=null)
				{
					strValorNuevo=importarexportar.getnumero_referencia_comprobante() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ImportarExportarConstantesFunciones.NUMEROREFERENCIACOMPROBANTE,strValorActual,strValorNuevo);
			}	
			
			if(importarexportar.getIsNew()||!importarexportar.getid_tipo_tributario().equals(importarexportar.getImportarExportarOriginal().getid_tipo_tributario()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(importarexportar.getImportarExportarOriginal().getid_tipo_tributario()!=null)
				{
					strValorActual=importarexportar.getImportarExportarOriginal().getid_tipo_tributario().toString();
				}
				if(importarexportar.getid_tipo_tributario()!=null)
				{
					strValorNuevo=importarexportar.getid_tipo_tributario().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ImportarExportarConstantesFunciones.IDTIPOTRIBUTARIO,strValorActual,strValorNuevo);
			}	
			
			if(importarexportar.getIsNew()||!importarexportar.getcodigo_fiscal().equals(importarexportar.getImportarExportarOriginal().getcodigo_fiscal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(importarexportar.getImportarExportarOriginal().getcodigo_fiscal()!=null)
				{
					strValorActual=importarexportar.getImportarExportarOriginal().getcodigo_fiscal();
				}
				if(importarexportar.getcodigo_fiscal()!=null)
				{
					strValorNuevo=importarexportar.getcodigo_fiscal() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ImportarExportarConstantesFunciones.CODIGOFISCAL,strValorActual,strValorNuevo);
			}	
			
			if(importarexportar.getIsNew()||!importarexportar.getid_cliente().equals(importarexportar.getImportarExportarOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(importarexportar.getImportarExportarOriginal().getid_cliente()!=null)
				{
					strValorActual=importarexportar.getImportarExportarOriginal().getid_cliente().toString();
				}
				if(importarexportar.getid_cliente()!=null)
				{
					strValorNuevo=importarexportar.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ImportarExportarConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(importarexportar.getIsNew()||!importarexportar.getes_juridico().equals(importarexportar.getImportarExportarOriginal().getes_juridico()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(importarexportar.getImportarExportarOriginal().getes_juridico()!=null)
				{
					strValorActual=importarexportar.getImportarExportarOriginal().getes_juridico().toString();
				}
				if(importarexportar.getes_juridico()!=null)
				{
					strValorNuevo=importarexportar.getes_juridico().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ImportarExportarConstantesFunciones.ESJURIDICO,strValorActual,strValorNuevo);
			}	
			
			if(importarexportar.getIsNew()||!importarexportar.getbase0().equals(importarexportar.getImportarExportarOriginal().getbase0()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(importarexportar.getImportarExportarOriginal().getbase0()!=null)
				{
					strValorActual=importarexportar.getImportarExportarOriginal().getbase0().toString();
				}
				if(importarexportar.getbase0()!=null)
				{
					strValorNuevo=importarexportar.getbase0().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ImportarExportarConstantesFunciones.BASE0,strValorActual,strValorNuevo);
			}	
			
			if(importarexportar.getIsNew()||!importarexportar.getmonto_total_cif().equals(importarexportar.getImportarExportarOriginal().getmonto_total_cif()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(importarexportar.getImportarExportarOriginal().getmonto_total_cif()!=null)
				{
					strValorActual=importarexportar.getImportarExportarOriginal().getmonto_total_cif().toString();
				}
				if(importarexportar.getmonto_total_cif()!=null)
				{
					strValorNuevo=importarexportar.getmonto_total_cif().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ImportarExportarConstantesFunciones.MONTOTOTALCIF,strValorActual,strValorNuevo);
			}	
			
			if(importarexportar.getIsNew()||!importarexportar.getmonto_iva().equals(importarexportar.getImportarExportarOriginal().getmonto_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(importarexportar.getImportarExportarOriginal().getmonto_iva()!=null)
				{
					strValorActual=importarexportar.getImportarExportarOriginal().getmonto_iva().toString();
				}
				if(importarexportar.getmonto_iva()!=null)
				{
					strValorNuevo=importarexportar.getmonto_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ImportarExportarConstantesFunciones.MONTOIVA,strValorActual,strValorNuevo);
			}	
			
			if(importarexportar.getIsNew()||!importarexportar.getid_tipo_iva().equals(importarexportar.getImportarExportarOriginal().getid_tipo_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(importarexportar.getImportarExportarOriginal().getid_tipo_iva()!=null)
				{
					strValorActual=importarexportar.getImportarExportarOriginal().getid_tipo_iva().toString();
				}
				if(importarexportar.getid_tipo_iva()!=null)
				{
					strValorNuevo=importarexportar.getid_tipo_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ImportarExportarConstantesFunciones.IDTIPOIVA,strValorActual,strValorNuevo);
			}	
			
			if(importarexportar.getIsNew()||!importarexportar.getmonto_ice().equals(importarexportar.getImportarExportarOriginal().getmonto_ice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(importarexportar.getImportarExportarOriginal().getmonto_ice()!=null)
				{
					strValorActual=importarexportar.getImportarExportarOriginal().getmonto_ice().toString();
				}
				if(importarexportar.getmonto_ice()!=null)
				{
					strValorNuevo=importarexportar.getmonto_ice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ImportarExportarConstantesFunciones.MONTOICE,strValorActual,strValorNuevo);
			}	
			
			if(importarexportar.getIsNew()||!importarexportar.getid_tipo_ice().equals(importarexportar.getImportarExportarOriginal().getid_tipo_ice()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(importarexportar.getImportarExportarOriginal().getid_tipo_ice()!=null)
				{
					strValorActual=importarexportar.getImportarExportarOriginal().getid_tipo_ice().toString();
				}
				if(importarexportar.getid_tipo_ice()!=null)
				{
					strValorNuevo=importarexportar.getid_tipo_ice().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ImportarExportarConstantesFunciones.IDTIPOICE,strValorActual,strValorNuevo);
			}	
			
			if(importarexportar.getIsNew()||!importarexportar.getbase_general().equals(importarexportar.getImportarExportarOriginal().getbase_general()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(importarexportar.getImportarExportarOriginal().getbase_general()!=null)
				{
					strValorActual=importarexportar.getImportarExportarOriginal().getbase_general().toString();
				}
				if(importarexportar.getbase_general()!=null)
				{
					strValorNuevo=importarexportar.getbase_general().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ImportarExportarConstantesFunciones.BASEGENERAL,strValorActual,strValorNuevo);
			}	
			
			if(importarexportar.getIsNew()||!importarexportar.getid_tipo_banco().equals(importarexportar.getImportarExportarOriginal().getid_tipo_banco()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(importarexportar.getImportarExportarOriginal().getid_tipo_banco()!=null)
				{
					strValorActual=importarexportar.getImportarExportarOriginal().getid_tipo_banco().toString();
				}
				if(importarexportar.getid_tipo_banco()!=null)
				{
					strValorNuevo=importarexportar.getid_tipo_banco().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ImportarExportarConstantesFunciones.IDTIPOBANCO,strValorActual,strValorNuevo);
			}	
			
			if(importarexportar.getIsNew()||!importarexportar.getid_tipo_comprobante_banco().equals(importarexportar.getImportarExportarOriginal().getid_tipo_comprobante_banco()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(importarexportar.getImportarExportarOriginal().getid_tipo_comprobante_banco()!=null)
				{
					strValorActual=importarexportar.getImportarExportarOriginal().getid_tipo_comprobante_banco().toString();
				}
				if(importarexportar.getid_tipo_comprobante_banco()!=null)
				{
					strValorNuevo=importarexportar.getid_tipo_comprobante_banco().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ImportarExportarConstantesFunciones.IDTIPOCOMPROBANTEBANCO,strValorActual,strValorNuevo);
			}	
			
			if(importarexportar.getIsNew()||!importarexportar.getcon_convenio().equals(importarexportar.getImportarExportarOriginal().getcon_convenio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(importarexportar.getImportarExportarOriginal().getcon_convenio()!=null)
				{
					strValorActual=importarexportar.getImportarExportarOriginal().getcon_convenio().toString();
				}
				if(importarexportar.getcon_convenio()!=null)
				{
					strValorNuevo=importarexportar.getcon_convenio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ImportarExportarConstantesFunciones.CONCONVENIO,strValorActual,strValorNuevo);
			}	
			
			if(importarexportar.getIsNew()||!importarexportar.getcon_devolucion().equals(importarexportar.getImportarExportarOriginal().getcon_devolucion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(importarexportar.getImportarExportarOriginal().getcon_devolucion()!=null)
				{
					strValorActual=importarexportar.getImportarExportarOriginal().getcon_devolucion().toString();
				}
				if(importarexportar.getcon_devolucion()!=null)
				{
					strValorNuevo=importarexportar.getcon_devolucion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ImportarExportarConstantesFunciones.CONDEVOLUCION,strValorActual,strValorNuevo);
			}	
			
			if(importarexportar.getIsNew()||!importarexportar.getfecha_emision().equals(importarexportar.getImportarExportarOriginal().getfecha_emision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(importarexportar.getImportarExportarOriginal().getfecha_emision()!=null)
				{
					strValorActual=importarexportar.getImportarExportarOriginal().getfecha_emision().toString();
				}
				if(importarexportar.getfecha_emision()!=null)
				{
					strValorNuevo=importarexportar.getfecha_emision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ImportarExportarConstantesFunciones.FECHAEMISION,strValorActual,strValorNuevo);
			}	
			
			if(importarexportar.getIsNew()||!importarexportar.getnumero_serie_comprobante().equals(importarexportar.getImportarExportarOriginal().getnumero_serie_comprobante()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(importarexportar.getImportarExportarOriginal().getnumero_serie_comprobante()!=null)
				{
					strValorActual=importarexportar.getImportarExportarOriginal().getnumero_serie_comprobante();
				}
				if(importarexportar.getnumero_serie_comprobante()!=null)
				{
					strValorNuevo=importarexportar.getnumero_serie_comprobante() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ImportarExportarConstantesFunciones.NUMEROSERIECOMPROBANTE,strValorActual,strValorNuevo);
			}	
			
			if(importarexportar.getIsNew()||!importarexportar.getnumero_autorizacion_comprobante().equals(importarexportar.getImportarExportarOriginal().getnumero_autorizacion_comprobante()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(importarexportar.getImportarExportarOriginal().getnumero_autorizacion_comprobante()!=null)
				{
					strValorActual=importarexportar.getImportarExportarOriginal().getnumero_autorizacion_comprobante();
				}
				if(importarexportar.getnumero_autorizacion_comprobante()!=null)
				{
					strValorNuevo=importarexportar.getnumero_autorizacion_comprobante() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ImportarExportarConstantesFunciones.NUMEROAUTORIZACIONCOMPROBANTE,strValorActual,strValorNuevo);
			}	
			
			if(importarexportar.getIsNew()||!importarexportar.getnumero_secuencial_fuente().equals(importarexportar.getImportarExportarOriginal().getnumero_secuencial_fuente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(importarexportar.getImportarExportarOriginal().getnumero_secuencial_fuente()!=null)
				{
					strValorActual=importarexportar.getImportarExportarOriginal().getnumero_secuencial_fuente();
				}
				if(importarexportar.getnumero_secuencial_fuente()!=null)
				{
					strValorNuevo=importarexportar.getnumero_secuencial_fuente() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ImportarExportarConstantesFunciones.NUMEROSECUENCIALFUENTE,strValorActual,strValorNuevo);
			}	
			
			if(importarexportar.getIsNew()||!importarexportar.getvalor_fob().equals(importarexportar.getImportarExportarOriginal().getvalor_fob()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(importarexportar.getImportarExportarOriginal().getvalor_fob()!=null)
				{
					strValorActual=importarexportar.getImportarExportarOriginal().getvalor_fob().toString();
				}
				if(importarexportar.getvalor_fob()!=null)
				{
					strValorNuevo=importarexportar.getvalor_fob().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ImportarExportarConstantesFunciones.VALORFOB,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveImportarExportarRelacionesWithConnection(ImportarExportar importarexportar) throws Exception {

		if(!importarexportar.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveImportarExportarRelacionesBase(importarexportar,true);
		}
	}

	public void saveImportarExportarRelaciones(ImportarExportar importarexportar)throws Exception {

		if(!importarexportar.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveImportarExportarRelacionesBase(importarexportar,false);
		}
	}

	public void saveImportarExportarRelacionesBase(ImportarExportar importarexportar,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ImportarExportar-saveRelacionesWithConnection");}
	

			this.setImportarExportar(importarexportar);

			if(ImportarExportarLogicAdditional.validarSaveRelaciones(importarexportar,this)) {

				ImportarExportarLogicAdditional.updateRelacionesToSave(importarexportar,this);

				if((importarexportar.getIsNew()||importarexportar.getIsChanged())&&!importarexportar.getIsDeleted()) {
					this.saveImportarExportar();
					this.saveImportarExportarRelacionesDetalles();

				} else if(importarexportar.getIsDeleted()) {
					this.saveImportarExportarRelacionesDetalles();
					this.saveImportarExportar();
				}

				ImportarExportarLogicAdditional.updateRelacionesToSaveAfter(importarexportar,this);

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
	
	
	private void saveImportarExportarRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfImportarExportar(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ImportarExportarConstantesFunciones.getClassesForeignKeysOfImportarExportar(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfImportarExportar(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ImportarExportarConstantesFunciones.getClassesRelationshipsOfImportarExportar(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

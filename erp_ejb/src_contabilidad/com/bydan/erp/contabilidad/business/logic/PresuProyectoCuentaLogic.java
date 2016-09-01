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
import com.bydan.erp.contabilidad.util.PresuProyectoCuentaConstantesFunciones;
import com.bydan.erp.contabilidad.util.PresuProyectoCuentaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.PresuProyectoCuentaParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.PresuProyectoCuenta;
import com.bydan.erp.contabilidad.business.logic.PresuProyectoCuentaLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.nomina.business.logic.*;


import com.bydan.erp.nomina.util.*;


import com.bydan.erp.nomina.business.dataaccess.*;








@SuppressWarnings("unused")
public class PresuProyectoCuentaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PresuProyectoCuentaLogic.class);
	
	protected PresuProyectoCuentaDataAccess presuproyectocuentaDataAccess; 	
	protected PresuProyectoCuenta presuproyectocuenta;
	protected List<PresuProyectoCuenta> presuproyectocuentas;
	protected Object presuproyectocuentaObject;	
	protected List<Object> presuproyectocuentasObject;
	
	public static ClassValidator<PresuProyectoCuenta> presuproyectocuentaValidator = new ClassValidator<PresuProyectoCuenta>(PresuProyectoCuenta.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PresuProyectoCuentaLogicAdditional presuproyectocuentaLogicAdditional=null;
	
	public PresuProyectoCuentaLogicAdditional getPresuProyectoCuentaLogicAdditional() {
		return this.presuproyectocuentaLogicAdditional;
	}
	
	public void setPresuProyectoCuentaLogicAdditional(PresuProyectoCuentaLogicAdditional presuproyectocuentaLogicAdditional) {
		try {
			this.presuproyectocuentaLogicAdditional=presuproyectocuentaLogicAdditional;
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
	
	
	
	
	public  PresuProyectoCuentaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.presuproyectocuentaDataAccess = new PresuProyectoCuentaDataAccess();
			
			this.presuproyectocuentas= new ArrayList<PresuProyectoCuenta>();
			this.presuproyectocuenta= new PresuProyectoCuenta();
			
			this.presuproyectocuentaObject=new Object();
			this.presuproyectocuentasObject=new ArrayList<Object>();
				
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
			
			this.presuproyectocuentaDataAccess.setConnexionType(this.connexionType);
			this.presuproyectocuentaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PresuProyectoCuentaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.presuproyectocuentaDataAccess = new PresuProyectoCuentaDataAccess();
			this.presuproyectocuentas= new ArrayList<PresuProyectoCuenta>();
			this.presuproyectocuenta= new PresuProyectoCuenta();
			this.presuproyectocuentaObject=new Object();
			this.presuproyectocuentasObject=new ArrayList<Object>();
			
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
			
			this.presuproyectocuentaDataAccess.setConnexionType(this.connexionType);
			this.presuproyectocuentaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PresuProyectoCuenta getPresuProyectoCuenta() throws Exception {	
		PresuProyectoCuentaLogicAdditional.checkPresuProyectoCuentaToGet(presuproyectocuenta,this.datosCliente,this.arrDatoGeneral);
		PresuProyectoCuentaLogicAdditional.updatePresuProyectoCuentaToGet(presuproyectocuenta,this.arrDatoGeneral);
		
		return presuproyectocuenta;
	}
		
	public void setPresuProyectoCuenta(PresuProyectoCuenta newPresuProyectoCuenta) {
		this.presuproyectocuenta = newPresuProyectoCuenta;
	}
	
	public PresuProyectoCuentaDataAccess getPresuProyectoCuentaDataAccess() {
		return presuproyectocuentaDataAccess;
	}
	
	public void setPresuProyectoCuentaDataAccess(PresuProyectoCuentaDataAccess newpresuproyectocuentaDataAccess) {
		this.presuproyectocuentaDataAccess = newpresuproyectocuentaDataAccess;
	}
	
	public List<PresuProyectoCuenta> getPresuProyectoCuentas() throws Exception {		
		this.quitarPresuProyectoCuentasNulos();
		
		PresuProyectoCuentaLogicAdditional.checkPresuProyectoCuentaToGets(presuproyectocuentas,this.datosCliente,this.arrDatoGeneral);
		
		for (PresuProyectoCuenta presuproyectocuentaLocal: presuproyectocuentas ) {
			PresuProyectoCuentaLogicAdditional.updatePresuProyectoCuentaToGet(presuproyectocuentaLocal,this.arrDatoGeneral);
		}
		
		return presuproyectocuentas;
	}
	
	public void setPresuProyectoCuentas(List<PresuProyectoCuenta> newPresuProyectoCuentas) {
		this.presuproyectocuentas = newPresuProyectoCuentas;
	}
	
	public Object getPresuProyectoCuentaObject() {	
		this.presuproyectocuentaObject=this.presuproyectocuentaDataAccess.getEntityObject();
		return this.presuproyectocuentaObject;
	}
		
	public void setPresuProyectoCuentaObject(Object newPresuProyectoCuentaObject) {
		this.presuproyectocuentaObject = newPresuProyectoCuentaObject;
	}
	
	public List<Object> getPresuProyectoCuentasObject() {		
		this.presuproyectocuentasObject=this.presuproyectocuentaDataAccess.getEntitiesObject();
		return this.presuproyectocuentasObject;
	}
		
	public void setPresuProyectoCuentasObject(List<Object> newPresuProyectoCuentasObject) {
		this.presuproyectocuentasObject = newPresuProyectoCuentasObject;
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
		
		if(this.presuproyectocuentaDataAccess!=null) {
			this.presuproyectocuentaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyectoCuenta.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			presuproyectocuentaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			presuproyectocuentaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		presuproyectocuenta = new  PresuProyectoCuenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyectoCuenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			presuproyectocuenta=presuproyectocuentaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presuproyectocuenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresuProyectoCuentaConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyectoCuenta(this.presuproyectocuenta);
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
		presuproyectocuenta = new  PresuProyectoCuenta();
		  		  
        try {
			
			presuproyectocuenta=presuproyectocuentaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presuproyectocuenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresuProyectoCuentaConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyectoCuenta(this.presuproyectocuenta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		presuproyectocuenta = new  PresuProyectoCuenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyectoCuenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			presuproyectocuenta=presuproyectocuentaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presuproyectocuenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresuProyectoCuentaConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyectoCuenta(this.presuproyectocuenta);
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
		presuproyectocuenta = new  PresuProyectoCuenta();
		  		  
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
		presuproyectocuenta = new  PresuProyectoCuenta();
		  		  
        try {
			
			presuproyectocuenta=presuproyectocuentaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presuproyectocuenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresuProyectoCuentaConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyectoCuenta(this.presuproyectocuenta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		presuproyectocuenta = new  PresuProyectoCuenta();
		  		  
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
		presuproyectocuenta = new  PresuProyectoCuenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyectoCuenta.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =presuproyectocuentaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		presuproyectocuenta = new  PresuProyectoCuenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=presuproyectocuentaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		presuproyectocuenta = new  PresuProyectoCuenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyectoCuenta.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =presuproyectocuentaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		presuproyectocuenta = new  PresuProyectoCuenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=presuproyectocuentaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		presuproyectocuenta = new  PresuProyectoCuenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyectoCuenta.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =presuproyectocuentaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		presuproyectocuenta = new  PresuProyectoCuenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=presuproyectocuentaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		presuproyectocuentas = new  ArrayList<PresuProyectoCuenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyectoCuenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PresuProyectoCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presuproyectocuentas=presuproyectocuentaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresuProyectoCuenta(presuproyectocuentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuProyectoCuentaConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyectoCuenta(this.presuproyectocuentas);
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
		presuproyectocuentas = new  ArrayList<PresuProyectoCuenta>();
		  		  
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
		presuproyectocuentas = new  ArrayList<PresuProyectoCuenta>();
		  		  
        try {			
			PresuProyectoCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presuproyectocuentas=presuproyectocuentaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPresuProyectoCuenta(presuproyectocuentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuProyectoCuentaConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyectoCuenta(this.presuproyectocuentas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		presuproyectocuentas = new  ArrayList<PresuProyectoCuenta>();
		  		  
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
		presuproyectocuentas = new  ArrayList<PresuProyectoCuenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyectoCuenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PresuProyectoCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presuproyectocuentas=presuproyectocuentaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresuProyectoCuenta(presuproyectocuentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuProyectoCuentaConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyectoCuenta(this.presuproyectocuentas);
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
		presuproyectocuentas = new  ArrayList<PresuProyectoCuenta>();
		  		  
        try {
			PresuProyectoCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presuproyectocuentas=presuproyectocuentaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresuProyectoCuenta(presuproyectocuentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuProyectoCuentaConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyectoCuenta(this.presuproyectocuentas);
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
		presuproyectocuentas = new  ArrayList<PresuProyectoCuenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyectoCuenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresuProyectoCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presuproyectocuentas=presuproyectocuentaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresuProyectoCuenta(presuproyectocuentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuProyectoCuentaConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyectoCuenta(this.presuproyectocuentas);
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
		presuproyectocuentas = new  ArrayList<PresuProyectoCuenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresuProyectoCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presuproyectocuentas=presuproyectocuentaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresuProyectoCuenta(presuproyectocuentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuProyectoCuentaConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyectoCuenta(this.presuproyectocuentas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		presuproyectocuenta = new  PresuProyectoCuenta();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyectoCuenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresuProyectoCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presuproyectocuenta=presuproyectocuentaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresuProyectoCuenta(presuproyectocuenta);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuProyectoCuentaConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyectoCuenta(this.presuproyectocuenta);
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
		presuproyectocuenta = new  PresuProyectoCuenta();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresuProyectoCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presuproyectocuenta=presuproyectocuentaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresuProyectoCuenta(presuproyectocuenta);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuProyectoCuentaConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyectoCuenta(this.presuproyectocuenta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		presuproyectocuentas = new  ArrayList<PresuProyectoCuenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyectoCuenta.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			PresuProyectoCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presuproyectocuentas=presuproyectocuentaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresuProyectoCuenta(presuproyectocuentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuProyectoCuentaConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyectoCuenta(this.presuproyectocuentas);
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
		presuproyectocuentas = new  ArrayList<PresuProyectoCuenta>();
		  		  
        try {
			PresuProyectoCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presuproyectocuentas=presuproyectocuentaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresuProyectoCuenta(presuproyectocuentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuProyectoCuentaConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyectoCuenta(this.presuproyectocuentas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosPresuProyectoCuentasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		presuproyectocuentas = new  ArrayList<PresuProyectoCuenta>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyectoCuenta.class.getSimpleName()+"-getTodosPresuProyectoCuentasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresuProyectoCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presuproyectocuentas=presuproyectocuentaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPresuProyectoCuenta(presuproyectocuentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuProyectoCuentaConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyectoCuenta(this.presuproyectocuentas);
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
	
	public  void  getTodosPresuProyectoCuentas(String sFinalQuery,Pagination pagination)throws Exception {
		presuproyectocuentas = new  ArrayList<PresuProyectoCuenta>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresuProyectoCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presuproyectocuentas=presuproyectocuentaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPresuProyectoCuenta(presuproyectocuentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuProyectoCuentaConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyectoCuenta(this.presuproyectocuentas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPresuProyectoCuenta(PresuProyectoCuenta presuproyectocuenta) throws Exception {
		Boolean estaValidado=false;
		
		if(presuproyectocuenta.getIsNew() || presuproyectocuenta.getIsChanged()) { 
			this.invalidValues = presuproyectocuentaValidator.getInvalidValues(presuproyectocuenta);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(presuproyectocuenta);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPresuProyectoCuenta(List<PresuProyectoCuenta> PresuProyectoCuentas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(PresuProyectoCuenta presuproyectocuentaLocal:presuproyectocuentas) {				
			estaValidadoObjeto=this.validarGuardarPresuProyectoCuenta(presuproyectocuentaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPresuProyectoCuenta(List<PresuProyectoCuenta> PresuProyectoCuentas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPresuProyectoCuenta(presuproyectocuentas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPresuProyectoCuenta(PresuProyectoCuenta PresuProyectoCuenta) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPresuProyectoCuenta(presuproyectocuenta)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(PresuProyectoCuenta presuproyectocuenta) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+presuproyectocuenta.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PresuProyectoCuentaConstantesFunciones.getPresuProyectoCuentaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"presuproyectocuenta","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PresuProyectoCuentaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PresuProyectoCuentaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePresuProyectoCuentaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyectoCuenta.class.getSimpleName()+"-savePresuProyectoCuentaWithConnection");connexion.begin();			
			
			PresuProyectoCuentaLogicAdditional.checkPresuProyectoCuentaToSave(this.presuproyectocuenta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PresuProyectoCuentaLogicAdditional.updatePresuProyectoCuentaToSave(this.presuproyectocuenta,this.arrDatoGeneral);
			
			PresuProyectoCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.presuproyectocuenta,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPresuProyectoCuenta();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPresuProyectoCuenta(this.presuproyectocuenta)) {
				PresuProyectoCuentaDataAccess.save(this.presuproyectocuenta, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.presuproyectocuenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PresuProyectoCuentaLogicAdditional.checkPresuProyectoCuentaToSaveAfter(this.presuproyectocuenta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPresuProyectoCuenta();
			
			connexion.commit();			
			
			if(this.presuproyectocuenta.getIsDeleted()) {
				this.presuproyectocuenta=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePresuProyectoCuenta()throws Exception {	
		try {	
			
			PresuProyectoCuentaLogicAdditional.checkPresuProyectoCuentaToSave(this.presuproyectocuenta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PresuProyectoCuentaLogicAdditional.updatePresuProyectoCuentaToSave(this.presuproyectocuenta,this.arrDatoGeneral);
			
			PresuProyectoCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.presuproyectocuenta,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPresuProyectoCuenta(this.presuproyectocuenta)) {			
				PresuProyectoCuentaDataAccess.save(this.presuproyectocuenta, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.presuproyectocuenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PresuProyectoCuentaLogicAdditional.checkPresuProyectoCuentaToSaveAfter(this.presuproyectocuenta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.presuproyectocuenta.getIsDeleted()) {
				this.presuproyectocuenta=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePresuProyectoCuentasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyectoCuenta.class.getSimpleName()+"-savePresuProyectoCuentasWithConnection");connexion.begin();			
			
			PresuProyectoCuentaLogicAdditional.checkPresuProyectoCuentaToSaves(presuproyectocuentas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPresuProyectoCuentas();
			
			Boolean validadoTodosPresuProyectoCuenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PresuProyectoCuenta presuproyectocuentaLocal:presuproyectocuentas) {		
				if(presuproyectocuentaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PresuProyectoCuentaLogicAdditional.updatePresuProyectoCuentaToSave(presuproyectocuentaLocal,this.arrDatoGeneral);
	        	
				PresuProyectoCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),presuproyectocuentaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPresuProyectoCuenta(presuproyectocuentaLocal)) {
					PresuProyectoCuentaDataAccess.save(presuproyectocuentaLocal, connexion);				
				} else {
					validadoTodosPresuProyectoCuenta=false;
				}
			}
			
			if(!validadoTodosPresuProyectoCuenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PresuProyectoCuentaLogicAdditional.checkPresuProyectoCuentaToSavesAfter(presuproyectocuentas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPresuProyectoCuentas();
			
			connexion.commit();		
			
			this.quitarPresuProyectoCuentasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePresuProyectoCuentas()throws Exception {				
		 try {	
			PresuProyectoCuentaLogicAdditional.checkPresuProyectoCuentaToSaves(presuproyectocuentas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPresuProyectoCuenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PresuProyectoCuenta presuproyectocuentaLocal:presuproyectocuentas) {				
				if(presuproyectocuentaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PresuProyectoCuentaLogicAdditional.updatePresuProyectoCuentaToSave(presuproyectocuentaLocal,this.arrDatoGeneral);
	        	
				PresuProyectoCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),presuproyectocuentaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPresuProyectoCuenta(presuproyectocuentaLocal)) {				
					PresuProyectoCuentaDataAccess.save(presuproyectocuentaLocal, connexion);				
				} else {
					validadoTodosPresuProyectoCuenta=false;
				}
			}
			
			if(!validadoTodosPresuProyectoCuenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PresuProyectoCuentaLogicAdditional.checkPresuProyectoCuentaToSavesAfter(presuproyectocuentas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPresuProyectoCuentasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PresuProyectoCuentaParameterReturnGeneral procesarAccionPresuProyectoCuentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PresuProyectoCuenta> presuproyectocuentas,PresuProyectoCuentaParameterReturnGeneral presuproyectocuentaParameterGeneral)throws Exception {
		 try {	
			PresuProyectoCuentaParameterReturnGeneral presuproyectocuentaReturnGeneral=new PresuProyectoCuentaParameterReturnGeneral();
	
			PresuProyectoCuentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,presuproyectocuentas,presuproyectocuentaParameterGeneral,presuproyectocuentaReturnGeneral);
			
			return presuproyectocuentaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PresuProyectoCuentaParameterReturnGeneral procesarAccionPresuProyectoCuentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PresuProyectoCuenta> presuproyectocuentas,PresuProyectoCuentaParameterReturnGeneral presuproyectocuentaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyectoCuenta.class.getSimpleName()+"-procesarAccionPresuProyectoCuentasWithConnection");connexion.begin();			
			
			PresuProyectoCuentaParameterReturnGeneral presuproyectocuentaReturnGeneral=new PresuProyectoCuentaParameterReturnGeneral();
	
			PresuProyectoCuentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,presuproyectocuentas,presuproyectocuentaParameterGeneral,presuproyectocuentaReturnGeneral);
			
			this.connexion.commit();
			
			return presuproyectocuentaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PresuProyectoCuentaParameterReturnGeneral procesarEventosPresuProyectoCuentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PresuProyectoCuenta> presuproyectocuentas,PresuProyectoCuenta presuproyectocuenta,PresuProyectoCuentaParameterReturnGeneral presuproyectocuentaParameterGeneral,Boolean isEsNuevoPresuProyectoCuenta,ArrayList<Classe> clases)throws Exception {
		 try {	
			PresuProyectoCuentaParameterReturnGeneral presuproyectocuentaReturnGeneral=new PresuProyectoCuentaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				presuproyectocuentaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PresuProyectoCuentaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,presuproyectocuentas,presuproyectocuenta,presuproyectocuentaParameterGeneral,presuproyectocuentaReturnGeneral,isEsNuevoPresuProyectoCuenta,clases);
			
			return presuproyectocuentaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PresuProyectoCuentaParameterReturnGeneral procesarEventosPresuProyectoCuentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PresuProyectoCuenta> presuproyectocuentas,PresuProyectoCuenta presuproyectocuenta,PresuProyectoCuentaParameterReturnGeneral presuproyectocuentaParameterGeneral,Boolean isEsNuevoPresuProyectoCuenta,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyectoCuenta.class.getSimpleName()+"-procesarEventosPresuProyectoCuentasWithConnection");connexion.begin();			
			
			PresuProyectoCuentaParameterReturnGeneral presuproyectocuentaReturnGeneral=new PresuProyectoCuentaParameterReturnGeneral();
	
			presuproyectocuentaReturnGeneral.setPresuProyectoCuenta(presuproyectocuenta);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				presuproyectocuentaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PresuProyectoCuentaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,presuproyectocuentas,presuproyectocuenta,presuproyectocuentaParameterGeneral,presuproyectocuentaReturnGeneral,isEsNuevoPresuProyectoCuenta,clases);
			
			this.connexion.commit();
			
			return presuproyectocuentaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PresuProyectoCuentaParameterReturnGeneral procesarImportacionPresuProyectoCuentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PresuProyectoCuentaParameterReturnGeneral presuproyectocuentaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyectoCuenta.class.getSimpleName()+"-procesarImportacionPresuProyectoCuentasWithConnection");connexion.begin();			
			
			PresuProyectoCuentaParameterReturnGeneral presuproyectocuentaReturnGeneral=new PresuProyectoCuentaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.presuproyectocuentas=new ArrayList<PresuProyectoCuenta>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.presuproyectocuenta=new PresuProyectoCuenta();
				
				
				if(conColumnasBase) {this.presuproyectocuenta.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.presuproyectocuenta.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.presuproyectocuenta.setcodigo(arrColumnas[iColumn++]);
				this.presuproyectocuenta.setnombre(arrColumnas[iColumn++]);
				this.presuproyectocuenta.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.presuproyectocuenta.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				this.presuproyectocuenta.setorden(Integer.parseInt(arrColumnas[iColumn++]));
			this.presuproyectocuenta.setdescripcion(arrColumnas[iColumn++]);
				
				this.presuproyectocuentas.add(this.presuproyectocuenta);
			}
			
			this.savePresuProyectoCuentas();
			
			this.connexion.commit();
			
			presuproyectocuentaReturnGeneral.setConRetornoEstaProcesado(true);
			presuproyectocuentaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return presuproyectocuentaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPresuProyectoCuentasEliminados() throws Exception {				
		
		List<PresuProyectoCuenta> presuproyectocuentasAux= new ArrayList<PresuProyectoCuenta>();
		
		for(PresuProyectoCuenta presuproyectocuenta:presuproyectocuentas) {
			if(!presuproyectocuenta.getIsDeleted()) {
				presuproyectocuentasAux.add(presuproyectocuenta);
			}
		}
		
		presuproyectocuentas=presuproyectocuentasAux;
	}
	
	public void quitarPresuProyectoCuentasNulos() throws Exception {				
		
		List<PresuProyectoCuenta> presuproyectocuentasAux= new ArrayList<PresuProyectoCuenta>();
		
		for(PresuProyectoCuenta presuproyectocuenta : this.presuproyectocuentas) {
			if(presuproyectocuenta==null) {
				presuproyectocuentasAux.add(presuproyectocuenta);
			}
		}
		
		//this.presuproyectocuentas=presuproyectocuentasAux;
		
		this.presuproyectocuentas.removeAll(presuproyectocuentasAux);
	}
	
	public void getSetVersionRowPresuProyectoCuentaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(presuproyectocuenta.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((presuproyectocuenta.getIsDeleted() || (presuproyectocuenta.getIsChanged()&&!presuproyectocuenta.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=presuproyectocuentaDataAccess.getSetVersionRowPresuProyectoCuenta(connexion,presuproyectocuenta.getId());
				
				if(!presuproyectocuenta.getVersionRow().equals(timestamp)) {	
					presuproyectocuenta.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				presuproyectocuenta.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPresuProyectoCuenta()throws Exception {	
		
		if(presuproyectocuenta.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((presuproyectocuenta.getIsDeleted() || (presuproyectocuenta.getIsChanged()&&!presuproyectocuenta.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=presuproyectocuentaDataAccess.getSetVersionRowPresuProyectoCuenta(connexion,presuproyectocuenta.getId());
			
			try {							
				if(!presuproyectocuenta.getVersionRow().equals(timestamp)) {	
					presuproyectocuenta.setVersionRow(timestamp);
				}
				
				presuproyectocuenta.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPresuProyectoCuentasWithConnection()throws Exception {	
		if(presuproyectocuentas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(PresuProyectoCuenta presuproyectocuentaAux:presuproyectocuentas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(presuproyectocuentaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(presuproyectocuentaAux.getIsDeleted() || (presuproyectocuentaAux.getIsChanged()&&!presuproyectocuentaAux.getIsNew())) {
						
						timestamp=presuproyectocuentaDataAccess.getSetVersionRowPresuProyectoCuenta(connexion,presuproyectocuentaAux.getId());
						
						if(!presuproyectocuenta.getVersionRow().equals(timestamp)) {	
							presuproyectocuentaAux.setVersionRow(timestamp);
						}
								
						presuproyectocuentaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPresuProyectoCuentas()throws Exception {	
		if(presuproyectocuentas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(PresuProyectoCuenta presuproyectocuentaAux:presuproyectocuentas) {
					if(presuproyectocuentaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(presuproyectocuentaAux.getIsDeleted() || (presuproyectocuentaAux.getIsChanged()&&!presuproyectocuentaAux.getIsNew())) {
						
						timestamp=presuproyectocuentaDataAccess.getSetVersionRowPresuProyectoCuenta(connexion,presuproyectocuentaAux.getId());
						
						if(!presuproyectocuentaAux.getVersionRow().equals(timestamp)) {	
							presuproyectocuentaAux.setVersionRow(timestamp);
						}
						
													
						presuproyectocuentaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PresuProyectoCuentaParameterReturnGeneral cargarCombosLoteForeignKeyPresuProyectoCuentaWithConnection(String finalQueryGlobalPresuProyecto,String finalQueryGlobalPresuTipoCuentaProyecto,String finalQueryGlobalCuentaContable,String finalQueryGlobalEmpleado,String finalQueryGlobalPresuEstado) throws Exception {
		PresuProyectoCuentaParameterReturnGeneral  presuproyectocuentaReturnGeneral =new PresuProyectoCuentaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyectoCuenta.class.getSimpleName()+"-cargarCombosLoteForeignKeyPresuProyectoCuentaWithConnection");connexion.begin();
			
			presuproyectocuentaReturnGeneral =new PresuProyectoCuentaParameterReturnGeneral();
			
			

			List<PresuProyecto> presuproyectosForeignKey=new ArrayList<PresuProyecto>();
			PresuProyectoLogic presuproyectoLogic=new PresuProyectoLogic();
			presuproyectoLogic.setConnexion(this.connexion);
			presuproyectoLogic.getPresuProyectoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPresuProyecto.equals("NONE")) {
				presuproyectoLogic.getTodosPresuProyectos(finalQueryGlobalPresuProyecto,new Pagination());
				presuproyectosForeignKey=presuproyectoLogic.getPresuProyectos();
			}

			presuproyectocuentaReturnGeneral.setpresuproyectosForeignKey(presuproyectosForeignKey);


			List<PresuTipoCuentaProyecto> presutipocuentaproyectosForeignKey=new ArrayList<PresuTipoCuentaProyecto>();
			PresuTipoCuentaProyectoLogic presutipocuentaproyectoLogic=new PresuTipoCuentaProyectoLogic();
			presutipocuentaproyectoLogic.setConnexion(this.connexion);
			presutipocuentaproyectoLogic.getPresuTipoCuentaProyectoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPresuTipoCuentaProyecto.equals("NONE")) {
				presutipocuentaproyectoLogic.getTodosPresuTipoCuentaProyectos(finalQueryGlobalPresuTipoCuentaProyecto,new Pagination());
				presutipocuentaproyectosForeignKey=presutipocuentaproyectoLogic.getPresuTipoCuentaProyectos();
			}

			presuproyectocuentaReturnGeneral.setpresutipocuentaproyectosForeignKey(presutipocuentaproyectosForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			presuproyectocuentaReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			presuproyectocuentaReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<PresuEstado> presuestadosForeignKey=new ArrayList<PresuEstado>();
			PresuEstadoLogic presuestadoLogic=new PresuEstadoLogic();
			presuestadoLogic.setConnexion(this.connexion);
			presuestadoLogic.getPresuEstadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPresuEstado.equals("NONE")) {
				presuestadoLogic.getTodosPresuEstados(finalQueryGlobalPresuEstado,new Pagination());
				presuestadosForeignKey=presuestadoLogic.getPresuEstados();
			}

			presuproyectocuentaReturnGeneral.setpresuestadosForeignKey(presuestadosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return presuproyectocuentaReturnGeneral;
	}
	
	public PresuProyectoCuentaParameterReturnGeneral cargarCombosLoteForeignKeyPresuProyectoCuenta(String finalQueryGlobalPresuProyecto,String finalQueryGlobalPresuTipoCuentaProyecto,String finalQueryGlobalCuentaContable,String finalQueryGlobalEmpleado,String finalQueryGlobalPresuEstado) throws Exception {
		PresuProyectoCuentaParameterReturnGeneral  presuproyectocuentaReturnGeneral =new PresuProyectoCuentaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			presuproyectocuentaReturnGeneral =new PresuProyectoCuentaParameterReturnGeneral();
			
			

			List<PresuProyecto> presuproyectosForeignKey=new ArrayList<PresuProyecto>();
			PresuProyectoLogic presuproyectoLogic=new PresuProyectoLogic();
			presuproyectoLogic.setConnexion(this.connexion);
			presuproyectoLogic.getPresuProyectoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPresuProyecto.equals("NONE")) {
				presuproyectoLogic.getTodosPresuProyectos(finalQueryGlobalPresuProyecto,new Pagination());
				presuproyectosForeignKey=presuproyectoLogic.getPresuProyectos();
			}

			presuproyectocuentaReturnGeneral.setpresuproyectosForeignKey(presuproyectosForeignKey);


			List<PresuTipoCuentaProyecto> presutipocuentaproyectosForeignKey=new ArrayList<PresuTipoCuentaProyecto>();
			PresuTipoCuentaProyectoLogic presutipocuentaproyectoLogic=new PresuTipoCuentaProyectoLogic();
			presutipocuentaproyectoLogic.setConnexion(this.connexion);
			presutipocuentaproyectoLogic.getPresuTipoCuentaProyectoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPresuTipoCuentaProyecto.equals("NONE")) {
				presutipocuentaproyectoLogic.getTodosPresuTipoCuentaProyectos(finalQueryGlobalPresuTipoCuentaProyecto,new Pagination());
				presutipocuentaproyectosForeignKey=presutipocuentaproyectoLogic.getPresuTipoCuentaProyectos();
			}

			presuproyectocuentaReturnGeneral.setpresutipocuentaproyectosForeignKey(presutipocuentaproyectosForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			presuproyectocuentaReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			presuproyectocuentaReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<PresuEstado> presuestadosForeignKey=new ArrayList<PresuEstado>();
			PresuEstadoLogic presuestadoLogic=new PresuEstadoLogic();
			presuestadoLogic.setConnexion(this.connexion);
			presuestadoLogic.getPresuEstadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPresuEstado.equals("NONE")) {
				presuestadoLogic.getTodosPresuEstados(finalQueryGlobalPresuEstado,new Pagination());
				presuestadosForeignKey=presuestadoLogic.getPresuEstados();
			}

			presuproyectocuentaReturnGeneral.setpresuestadosForeignKey(presuestadosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return presuproyectocuentaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyPresuProyectoCuentaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			PresuAsignacionLogic presuasignacionLogic=new PresuAsignacionLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyectoCuenta.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyPresuProyectoCuentaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(PresuAsignacion.class));
											
			

			presuasignacionLogic.setConnexion(this.getConnexion());
			presuasignacionLogic.setDatosCliente(this.datosCliente);
			presuasignacionLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(PresuProyectoCuenta presuproyectocuenta:this.presuproyectocuentas) {
				

				classes=new ArrayList<Classe>();
				classes=PresuAsignacionConstantesFunciones.getClassesForeignKeysOfPresuAsignacion(new ArrayList<Classe>(),DeepLoadType.NONE);

				presuasignacionLogic.setPresuAsignacions(presuproyectocuenta.presuasignacions);
				presuasignacionLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(PresuProyectoCuenta presuproyectocuenta,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PresuProyectoCuentaLogicAdditional.updatePresuProyectoCuentaToGet(presuproyectocuenta,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		presuproyectocuenta.setPresuProyecto(presuproyectocuentaDataAccess.getPresuProyecto(connexion,presuproyectocuenta));
		presuproyectocuenta.setPresuTipoCuentaProyecto(presuproyectocuentaDataAccess.getPresuTipoCuentaProyecto(connexion,presuproyectocuenta));
		presuproyectocuenta.setCuentaContable(presuproyectocuentaDataAccess.getCuentaContable(connexion,presuproyectocuenta));
		presuproyectocuenta.setEmpleado(presuproyectocuentaDataAccess.getEmpleado(connexion,presuproyectocuenta));
		presuproyectocuenta.setPresuEstado(presuproyectocuentaDataAccess.getPresuEstado(connexion,presuproyectocuenta));
		presuproyectocuenta.setPresuAsignacions(presuproyectocuentaDataAccess.getPresuAsignacions(connexion,presuproyectocuenta));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(PresuProyecto.class)) {
				presuproyectocuenta.setPresuProyecto(presuproyectocuentaDataAccess.getPresuProyecto(connexion,presuproyectocuenta));
				continue;
			}

			if(clas.clas.equals(PresuTipoCuentaProyecto.class)) {
				presuproyectocuenta.setPresuTipoCuentaProyecto(presuproyectocuentaDataAccess.getPresuTipoCuentaProyecto(connexion,presuproyectocuenta));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				presuproyectocuenta.setCuentaContable(presuproyectocuentaDataAccess.getCuentaContable(connexion,presuproyectocuenta));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				presuproyectocuenta.setEmpleado(presuproyectocuentaDataAccess.getEmpleado(connexion,presuproyectocuenta));
				continue;
			}

			if(clas.clas.equals(PresuEstado.class)) {
				presuproyectocuenta.setPresuEstado(presuproyectocuentaDataAccess.getPresuEstado(connexion,presuproyectocuenta));
				continue;
			}

			if(clas.clas.equals(PresuAsignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				presuproyectocuenta.setPresuAsignacions(presuproyectocuentaDataAccess.getPresuAsignacions(connexion,presuproyectocuenta));

				if(this.isConDeep) {
					PresuAsignacionLogic presuasignacionLogic= new PresuAsignacionLogic(this.connexion);
					presuasignacionLogic.setPresuAsignacions(presuproyectocuenta.getPresuAsignacions());
					ArrayList<Classe> classesLocal=PresuAsignacionConstantesFunciones.getClassesForeignKeysOfPresuAsignacion(new ArrayList<Classe>(),DeepLoadType.NONE);
					presuasignacionLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PresuAsignacionConstantesFunciones.refrescarForeignKeysDescripcionesPresuAsignacion(presuasignacionLogic.getPresuAsignacions());
					presuproyectocuenta.setPresuAsignacions(presuasignacionLogic.getPresuAsignacions());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PresuProyecto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presuproyectocuenta.setPresuProyecto(presuproyectocuentaDataAccess.getPresuProyecto(connexion,presuproyectocuenta));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PresuTipoCuentaProyecto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presuproyectocuenta.setPresuTipoCuentaProyecto(presuproyectocuentaDataAccess.getPresuTipoCuentaProyecto(connexion,presuproyectocuenta));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presuproyectocuenta.setCuentaContable(presuproyectocuentaDataAccess.getCuentaContable(connexion,presuproyectocuenta));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presuproyectocuenta.setEmpleado(presuproyectocuentaDataAccess.getEmpleado(connexion,presuproyectocuenta));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PresuEstado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presuproyectocuenta.setPresuEstado(presuproyectocuentaDataAccess.getPresuEstado(connexion,presuproyectocuenta));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PresuAsignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PresuAsignacion.class));
			presuproyectocuenta.setPresuAsignacions(presuproyectocuentaDataAccess.getPresuAsignacions(connexion,presuproyectocuenta));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		presuproyectocuenta.setPresuProyecto(presuproyectocuentaDataAccess.getPresuProyecto(connexion,presuproyectocuenta));
		PresuProyectoLogic presuproyectoLogic= new PresuProyectoLogic(connexion);
		presuproyectoLogic.deepLoad(presuproyectocuenta.getPresuProyecto(),isDeep,deepLoadType,clases);
				
		presuproyectocuenta.setPresuTipoCuentaProyecto(presuproyectocuentaDataAccess.getPresuTipoCuentaProyecto(connexion,presuproyectocuenta));
		PresuTipoCuentaProyectoLogic presutipocuentaproyectoLogic= new PresuTipoCuentaProyectoLogic(connexion);
		presutipocuentaproyectoLogic.deepLoad(presuproyectocuenta.getPresuTipoCuentaProyecto(),isDeep,deepLoadType,clases);
				
		presuproyectocuenta.setCuentaContable(presuproyectocuentaDataAccess.getCuentaContable(connexion,presuproyectocuenta));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(presuproyectocuenta.getCuentaContable(),isDeep,deepLoadType,clases);
				
		presuproyectocuenta.setEmpleado(presuproyectocuentaDataAccess.getEmpleado(connexion,presuproyectocuenta));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(presuproyectocuenta.getEmpleado(),isDeep,deepLoadType,clases);
				
		presuproyectocuenta.setPresuEstado(presuproyectocuentaDataAccess.getPresuEstado(connexion,presuproyectocuenta));
		PresuEstadoLogic presuestadoLogic= new PresuEstadoLogic(connexion);
		presuestadoLogic.deepLoad(presuproyectocuenta.getPresuEstado(),isDeep,deepLoadType,clases);
				

		presuproyectocuenta.setPresuAsignacions(presuproyectocuentaDataAccess.getPresuAsignacions(connexion,presuproyectocuenta));

		for(PresuAsignacion presuasignacion:presuproyectocuenta.getPresuAsignacions()) {
			PresuAsignacionLogic presuasignacionLogic= new PresuAsignacionLogic(connexion);
			presuasignacionLogic.deepLoad(presuasignacion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(PresuProyecto.class)) {
				presuproyectocuenta.setPresuProyecto(presuproyectocuentaDataAccess.getPresuProyecto(connexion,presuproyectocuenta));
				PresuProyectoLogic presuproyectoLogic= new PresuProyectoLogic(connexion);
				presuproyectoLogic.deepLoad(presuproyectocuenta.getPresuProyecto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PresuTipoCuentaProyecto.class)) {
				presuproyectocuenta.setPresuTipoCuentaProyecto(presuproyectocuentaDataAccess.getPresuTipoCuentaProyecto(connexion,presuproyectocuenta));
				PresuTipoCuentaProyectoLogic presutipocuentaproyectoLogic= new PresuTipoCuentaProyectoLogic(connexion);
				presutipocuentaproyectoLogic.deepLoad(presuproyectocuenta.getPresuTipoCuentaProyecto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				presuproyectocuenta.setCuentaContable(presuproyectocuentaDataAccess.getCuentaContable(connexion,presuproyectocuenta));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(presuproyectocuenta.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				presuproyectocuenta.setEmpleado(presuproyectocuentaDataAccess.getEmpleado(connexion,presuproyectocuenta));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(presuproyectocuenta.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PresuEstado.class)) {
				presuproyectocuenta.setPresuEstado(presuproyectocuentaDataAccess.getPresuEstado(connexion,presuproyectocuenta));
				PresuEstadoLogic presuestadoLogic= new PresuEstadoLogic(connexion);
				presuestadoLogic.deepLoad(presuproyectocuenta.getPresuEstado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PresuAsignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				presuproyectocuenta.setPresuAsignacions(presuproyectocuentaDataAccess.getPresuAsignacions(connexion,presuproyectocuenta));

				for(PresuAsignacion presuasignacion:presuproyectocuenta.getPresuAsignacions()) {
					PresuAsignacionLogic presuasignacionLogic= new PresuAsignacionLogic(connexion);
					presuasignacionLogic.deepLoad(presuasignacion,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(PresuProyecto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presuproyectocuenta.setPresuProyecto(presuproyectocuentaDataAccess.getPresuProyecto(connexion,presuproyectocuenta));
			PresuProyectoLogic presuproyectoLogic= new PresuProyectoLogic(connexion);
			presuproyectoLogic.deepLoad(presuproyectocuenta.getPresuProyecto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(PresuTipoCuentaProyecto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presuproyectocuenta.setPresuTipoCuentaProyecto(presuproyectocuentaDataAccess.getPresuTipoCuentaProyecto(connexion,presuproyectocuenta));
			PresuTipoCuentaProyectoLogic presutipocuentaproyectoLogic= new PresuTipoCuentaProyectoLogic(connexion);
			presutipocuentaproyectoLogic.deepLoad(presuproyectocuenta.getPresuTipoCuentaProyecto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presuproyectocuenta.setCuentaContable(presuproyectocuentaDataAccess.getCuentaContable(connexion,presuproyectocuenta));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(presuproyectocuenta.getCuentaContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presuproyectocuenta.setEmpleado(presuproyectocuentaDataAccess.getEmpleado(connexion,presuproyectocuenta));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(presuproyectocuenta.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(PresuEstado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presuproyectocuenta.setPresuEstado(presuproyectocuentaDataAccess.getPresuEstado(connexion,presuproyectocuenta));
			PresuEstadoLogic presuestadoLogic= new PresuEstadoLogic(connexion);
			presuestadoLogic.deepLoad(presuproyectocuenta.getPresuEstado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PresuAsignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PresuAsignacion.class));
			presuproyectocuenta.setPresuAsignacions(presuproyectocuentaDataAccess.getPresuAsignacions(connexion,presuproyectocuenta));

			for(PresuAsignacion presuasignacion:presuproyectocuenta.getPresuAsignacions()) {
				PresuAsignacionLogic presuasignacionLogic= new PresuAsignacionLogic(connexion);
				presuasignacionLogic.deepLoad(presuasignacion,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(PresuProyectoCuenta presuproyectocuenta,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			PresuProyectoCuentaLogicAdditional.updatePresuProyectoCuentaToSave(presuproyectocuenta,this.arrDatoGeneral);
			
PresuProyectoCuentaDataAccess.save(presuproyectocuenta, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		PresuProyectoDataAccess.save(presuproyectocuenta.getPresuProyecto(),connexion);

		PresuTipoCuentaProyectoDataAccess.save(presuproyectocuenta.getPresuTipoCuentaProyecto(),connexion);

		CuentaContableDataAccess.save(presuproyectocuenta.getCuentaContable(),connexion);

		EmpleadoDataAccess.save(presuproyectocuenta.getEmpleado(),connexion);

		PresuEstadoDataAccess.save(presuproyectocuenta.getPresuEstado(),connexion);

		for(PresuAsignacion presuasignacion:presuproyectocuenta.getPresuAsignacions()) {
			presuasignacion.setid_presu_proyecto_cuenta(presuproyectocuenta.getId());
			PresuAsignacionDataAccess.save(presuasignacion,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(PresuProyecto.class)) {
				PresuProyectoDataAccess.save(presuproyectocuenta.getPresuProyecto(),connexion);
				continue;
			}

			if(clas.clas.equals(PresuTipoCuentaProyecto.class)) {
				PresuTipoCuentaProyectoDataAccess.save(presuproyectocuenta.getPresuTipoCuentaProyecto(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(presuproyectocuenta.getCuentaContable(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(presuproyectocuenta.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(PresuEstado.class)) {
				PresuEstadoDataAccess.save(presuproyectocuenta.getPresuEstado(),connexion);
				continue;
			}


			if(clas.clas.equals(PresuAsignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PresuAsignacion presuasignacion:presuproyectocuenta.getPresuAsignacions()) {
					presuasignacion.setid_presu_proyecto_cuenta(presuproyectocuenta.getId());
					PresuAsignacionDataAccess.save(presuasignacion,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		PresuProyectoDataAccess.save(presuproyectocuenta.getPresuProyecto(),connexion);
		PresuProyectoLogic presuproyectoLogic= new PresuProyectoLogic(connexion);
		presuproyectoLogic.deepLoad(presuproyectocuenta.getPresuProyecto(),isDeep,deepLoadType,clases);
				

		PresuTipoCuentaProyectoDataAccess.save(presuproyectocuenta.getPresuTipoCuentaProyecto(),connexion);
		PresuTipoCuentaProyectoLogic presutipocuentaproyectoLogic= new PresuTipoCuentaProyectoLogic(connexion);
		presutipocuentaproyectoLogic.deepLoad(presuproyectocuenta.getPresuTipoCuentaProyecto(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(presuproyectocuenta.getCuentaContable(),connexion);
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(presuproyectocuenta.getCuentaContable(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(presuproyectocuenta.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(presuproyectocuenta.getEmpleado(),isDeep,deepLoadType,clases);
				

		PresuEstadoDataAccess.save(presuproyectocuenta.getPresuEstado(),connexion);
		PresuEstadoLogic presuestadoLogic= new PresuEstadoLogic(connexion);
		presuestadoLogic.deepLoad(presuproyectocuenta.getPresuEstado(),isDeep,deepLoadType,clases);
				

		for(PresuAsignacion presuasignacion:presuproyectocuenta.getPresuAsignacions()) {
			PresuAsignacionLogic presuasignacionLogic= new PresuAsignacionLogic(connexion);
			presuasignacion.setid_presu_proyecto_cuenta(presuproyectocuenta.getId());
			PresuAsignacionDataAccess.save(presuasignacion,connexion);
			presuasignacionLogic.deepSave(presuasignacion,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(PresuProyecto.class)) {
				PresuProyectoDataAccess.save(presuproyectocuenta.getPresuProyecto(),connexion);
				PresuProyectoLogic presuproyectoLogic= new PresuProyectoLogic(connexion);
				presuproyectoLogic.deepSave(presuproyectocuenta.getPresuProyecto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PresuTipoCuentaProyecto.class)) {
				PresuTipoCuentaProyectoDataAccess.save(presuproyectocuenta.getPresuTipoCuentaProyecto(),connexion);
				PresuTipoCuentaProyectoLogic presutipocuentaproyectoLogic= new PresuTipoCuentaProyectoLogic(connexion);
				presutipocuentaproyectoLogic.deepSave(presuproyectocuenta.getPresuTipoCuentaProyecto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(presuproyectocuenta.getCuentaContable(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(presuproyectocuenta.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(presuproyectocuenta.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(presuproyectocuenta.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PresuEstado.class)) {
				PresuEstadoDataAccess.save(presuproyectocuenta.getPresuEstado(),connexion);
				PresuEstadoLogic presuestadoLogic= new PresuEstadoLogic(connexion);
				presuestadoLogic.deepSave(presuproyectocuenta.getPresuEstado(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(PresuAsignacion.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PresuAsignacion presuasignacion:presuproyectocuenta.getPresuAsignacions()) {
					PresuAsignacionLogic presuasignacionLogic= new PresuAsignacionLogic(connexion);
					presuasignacion.setid_presu_proyecto_cuenta(presuproyectocuenta.getId());
					PresuAsignacionDataAccess.save(presuasignacion,connexion);
					presuasignacionLogic.deepSave(presuasignacion,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(PresuProyectoCuenta.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(presuproyectocuenta,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PresuProyectoCuentaConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyectoCuenta(presuproyectocuenta);
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
			this.deepLoad(this.presuproyectocuenta,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PresuProyectoCuentaConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyectoCuenta(this.presuproyectocuenta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(PresuProyectoCuenta.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(presuproyectocuentas!=null) {
				for(PresuProyectoCuenta presuproyectocuenta:presuproyectocuentas) {
					this.deepLoad(presuproyectocuenta,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PresuProyectoCuentaConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyectoCuenta(presuproyectocuentas);
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
			if(presuproyectocuentas!=null) {
				for(PresuProyectoCuenta presuproyectocuenta:presuproyectocuentas) {
					this.deepLoad(presuproyectocuenta,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PresuProyectoCuentaConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyectoCuenta(presuproyectocuentas);
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
			this.getNewConnexionToDeep(PresuProyectoCuenta.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(presuproyectocuenta,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(PresuProyectoCuenta.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(presuproyectocuentas!=null) {
				for(PresuProyectoCuenta presuproyectocuenta:presuproyectocuentas) {
					this.deepSave(presuproyectocuenta,isDeep,deepLoadType,clases);
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
			if(presuproyectocuentas!=null) {
				for(PresuProyectoCuenta presuproyectocuenta:presuproyectocuentas) {
					this.deepSave(presuproyectocuenta,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getPresuProyectoCuentasBusquedaPorProyectoPorCodigoWithConnection(String sFinalQuery,Pagination pagination,Long id_presu_proyecto,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyectoCuenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPresuProyecto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPresuProyecto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_presu_proyecto,PresuProyectoCuentaConstantesFunciones.IDPRESUPROYECTO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPresuProyecto);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",PresuProyectoCuentaConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			PresuProyectoCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorProyectoPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presuproyectocuentas=presuproyectocuentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuProyectoCuentaConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyectoCuenta(this.presuproyectocuentas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresuProyectoCuentasBusquedaPorProyectoPorCodigo(String sFinalQuery,Pagination pagination,Long id_presu_proyecto,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPresuProyecto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPresuProyecto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_presu_proyecto,PresuProyectoCuentaConstantesFunciones.IDPRESUPROYECTO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPresuProyecto);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",PresuProyectoCuentaConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			PresuProyectoCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorProyectoPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presuproyectocuentas=presuproyectocuentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuProyectoCuentaConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyectoCuenta(this.presuproyectocuentas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresuProyectoCuentasBusquedaPorProyectoPorNombreWithConnection(String sFinalQuery,Pagination pagination,Long id_presu_proyecto,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyectoCuenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPresuProyecto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPresuProyecto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_presu_proyecto,PresuProyectoCuentaConstantesFunciones.IDPRESUPROYECTO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPresuProyecto);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",PresuProyectoCuentaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			PresuProyectoCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorProyectoPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presuproyectocuentas=presuproyectocuentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuProyectoCuentaConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyectoCuenta(this.presuproyectocuentas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresuProyectoCuentasBusquedaPorProyectoPorNombre(String sFinalQuery,Pagination pagination,Long id_presu_proyecto,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPresuProyecto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPresuProyecto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_presu_proyecto,PresuProyectoCuentaConstantesFunciones.IDPRESUPROYECTO,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPresuProyecto);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",PresuProyectoCuentaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			PresuProyectoCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorProyectoPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presuproyectocuentas=presuproyectocuentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuProyectoCuentaConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyectoCuenta(this.presuproyectocuentas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresuProyectoCuentasFK_IdCuentaContableWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyectoCuenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,PresuProyectoCuentaConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			PresuProyectoCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presuproyectocuentas=presuproyectocuentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuProyectoCuentaConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyectoCuenta(this.presuproyectocuentas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresuProyectoCuentasFK_IdCuentaContable(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,PresuProyectoCuentaConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			PresuProyectoCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presuproyectocuentas=presuproyectocuentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuProyectoCuentaConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyectoCuenta(this.presuproyectocuentas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresuProyectoCuentasFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyectoCuenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,PresuProyectoCuentaConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			PresuProyectoCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presuproyectocuentas=presuproyectocuentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuProyectoCuentaConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyectoCuenta(this.presuproyectocuentas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresuProyectoCuentasFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,PresuProyectoCuentaConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			PresuProyectoCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presuproyectocuentas=presuproyectocuentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuProyectoCuentaConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyectoCuenta(this.presuproyectocuentas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresuProyectoCuentasFK_IdPresuEstadoWithConnection(String sFinalQuery,Pagination pagination,Long id_presu_estado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyectoCuenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPresuEstado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPresuEstado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_presu_estado,PresuProyectoCuentaConstantesFunciones.IDPRESUESTADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPresuEstado);

			PresuProyectoCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPresuEstado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presuproyectocuentas=presuproyectocuentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuProyectoCuentaConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyectoCuenta(this.presuproyectocuentas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresuProyectoCuentasFK_IdPresuEstado(String sFinalQuery,Pagination pagination,Long id_presu_estado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPresuEstado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPresuEstado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_presu_estado,PresuProyectoCuentaConstantesFunciones.IDPRESUESTADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPresuEstado);

			PresuProyectoCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPresuEstado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presuproyectocuentas=presuproyectocuentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuProyectoCuentaConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyectoCuenta(this.presuproyectocuentas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresuProyectoCuentasFK_IdPresuProyectoWithConnection(String sFinalQuery,Pagination pagination,Long id_presu_proyecto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyectoCuenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPresuProyecto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPresuProyecto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_presu_proyecto,PresuProyectoCuentaConstantesFunciones.IDPRESUPROYECTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPresuProyecto);

			PresuProyectoCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPresuProyecto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presuproyectocuentas=presuproyectocuentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuProyectoCuentaConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyectoCuenta(this.presuproyectocuentas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresuProyectoCuentasFK_IdPresuProyecto(String sFinalQuery,Pagination pagination,Long id_presu_proyecto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPresuProyecto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPresuProyecto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_presu_proyecto,PresuProyectoCuentaConstantesFunciones.IDPRESUPROYECTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPresuProyecto);

			PresuProyectoCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPresuProyecto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presuproyectocuentas=presuproyectocuentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuProyectoCuentaConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyectoCuenta(this.presuproyectocuentas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresuProyectoCuentasFK_IdPresuTipoCuentaProyectoWithConnection(String sFinalQuery,Pagination pagination,Long id_presu_tipo_cuenta_proyecto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyectoCuenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPresuTipoCuentaProyecto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPresuTipoCuentaProyecto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_presu_tipo_cuenta_proyecto,PresuProyectoCuentaConstantesFunciones.IDPRESUTIPOCUENTAPROYECTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPresuTipoCuentaProyecto);

			PresuProyectoCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPresuTipoCuentaProyecto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presuproyectocuentas=presuproyectocuentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuProyectoCuentaConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyectoCuenta(this.presuproyectocuentas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresuProyectoCuentasFK_IdPresuTipoCuentaProyecto(String sFinalQuery,Pagination pagination,Long id_presu_tipo_cuenta_proyecto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPresuTipoCuentaProyecto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPresuTipoCuentaProyecto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_presu_tipo_cuenta_proyecto,PresuProyectoCuentaConstantesFunciones.IDPRESUTIPOCUENTAPROYECTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPresuTipoCuentaProyecto);

			PresuProyectoCuentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPresuTipoCuentaProyecto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presuproyectocuentas=presuproyectocuentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuProyectoCuentaConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyectoCuenta(this.presuproyectocuentas);
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
			if(PresuProyectoCuentaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PresuProyectoCuentaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,PresuProyectoCuenta presuproyectocuenta,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PresuProyectoCuentaConstantesFunciones.ISCONAUDITORIA) {
				if(presuproyectocuenta.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PresuProyectoCuentaDataAccess.TABLENAME, presuproyectocuenta.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PresuProyectoCuentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PresuProyectoCuentaLogic.registrarAuditoriaDetallesPresuProyectoCuenta(connexion,presuproyectocuenta,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(presuproyectocuenta.getIsDeleted()) {
					/*if(!presuproyectocuenta.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PresuProyectoCuentaDataAccess.TABLENAME, presuproyectocuenta.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////PresuProyectoCuentaLogic.registrarAuditoriaDetallesPresuProyectoCuenta(connexion,presuproyectocuenta,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PresuProyectoCuentaDataAccess.TABLENAME, presuproyectocuenta.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(presuproyectocuenta.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PresuProyectoCuentaDataAccess.TABLENAME, presuproyectocuenta.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PresuProyectoCuentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PresuProyectoCuentaLogic.registrarAuditoriaDetallesPresuProyectoCuenta(connexion,presuproyectocuenta,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPresuProyectoCuenta(Connexion connexion,PresuProyectoCuenta presuproyectocuenta)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(presuproyectocuenta.getIsNew()||!presuproyectocuenta.getid_presu_proyecto().equals(presuproyectocuenta.getPresuProyectoCuentaOriginal().getid_presu_proyecto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presuproyectocuenta.getPresuProyectoCuentaOriginal().getid_presu_proyecto()!=null)
				{
					strValorActual=presuproyectocuenta.getPresuProyectoCuentaOriginal().getid_presu_proyecto().toString();
				}
				if(presuproyectocuenta.getid_presu_proyecto()!=null)
				{
					strValorNuevo=presuproyectocuenta.getid_presu_proyecto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuProyectoCuentaConstantesFunciones.IDPRESUPROYECTO,strValorActual,strValorNuevo);
			}	
			
			if(presuproyectocuenta.getIsNew()||!presuproyectocuenta.getid_presu_tipo_cuenta_proyecto().equals(presuproyectocuenta.getPresuProyectoCuentaOriginal().getid_presu_tipo_cuenta_proyecto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presuproyectocuenta.getPresuProyectoCuentaOriginal().getid_presu_tipo_cuenta_proyecto()!=null)
				{
					strValorActual=presuproyectocuenta.getPresuProyectoCuentaOriginal().getid_presu_tipo_cuenta_proyecto().toString();
				}
				if(presuproyectocuenta.getid_presu_tipo_cuenta_proyecto()!=null)
				{
					strValorNuevo=presuproyectocuenta.getid_presu_tipo_cuenta_proyecto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuProyectoCuentaConstantesFunciones.IDPRESUTIPOCUENTAPROYECTO,strValorActual,strValorNuevo);
			}	
			
			if(presuproyectocuenta.getIsNew()||!presuproyectocuenta.getcodigo().equals(presuproyectocuenta.getPresuProyectoCuentaOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presuproyectocuenta.getPresuProyectoCuentaOriginal().getcodigo()!=null)
				{
					strValorActual=presuproyectocuenta.getPresuProyectoCuentaOriginal().getcodigo();
				}
				if(presuproyectocuenta.getcodigo()!=null)
				{
					strValorNuevo=presuproyectocuenta.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuProyectoCuentaConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(presuproyectocuenta.getIsNew()||!presuproyectocuenta.getnombre().equals(presuproyectocuenta.getPresuProyectoCuentaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presuproyectocuenta.getPresuProyectoCuentaOriginal().getnombre()!=null)
				{
					strValorActual=presuproyectocuenta.getPresuProyectoCuentaOriginal().getnombre();
				}
				if(presuproyectocuenta.getnombre()!=null)
				{
					strValorNuevo=presuproyectocuenta.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuProyectoCuentaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(presuproyectocuenta.getIsNew()||!presuproyectocuenta.getid_cuenta_contable().equals(presuproyectocuenta.getPresuProyectoCuentaOriginal().getid_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presuproyectocuenta.getPresuProyectoCuentaOriginal().getid_cuenta_contable()!=null)
				{
					strValorActual=presuproyectocuenta.getPresuProyectoCuentaOriginal().getid_cuenta_contable().toString();
				}
				if(presuproyectocuenta.getid_cuenta_contable()!=null)
				{
					strValorNuevo=presuproyectocuenta.getid_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuProyectoCuentaConstantesFunciones.IDCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(presuproyectocuenta.getIsNew()||!presuproyectocuenta.getid_empleado().equals(presuproyectocuenta.getPresuProyectoCuentaOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presuproyectocuenta.getPresuProyectoCuentaOriginal().getid_empleado()!=null)
				{
					strValorActual=presuproyectocuenta.getPresuProyectoCuentaOriginal().getid_empleado().toString();
				}
				if(presuproyectocuenta.getid_empleado()!=null)
				{
					strValorNuevo=presuproyectocuenta.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuProyectoCuentaConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(presuproyectocuenta.getIsNew()||!presuproyectocuenta.getfecha().equals(presuproyectocuenta.getPresuProyectoCuentaOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presuproyectocuenta.getPresuProyectoCuentaOriginal().getfecha()!=null)
				{
					strValorActual=presuproyectocuenta.getPresuProyectoCuentaOriginal().getfecha().toString();
				}
				if(presuproyectocuenta.getfecha()!=null)
				{
					strValorNuevo=presuproyectocuenta.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuProyectoCuentaConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(presuproyectocuenta.getIsNew()||!presuproyectocuenta.getvalor().equals(presuproyectocuenta.getPresuProyectoCuentaOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presuproyectocuenta.getPresuProyectoCuentaOriginal().getvalor()!=null)
				{
					strValorActual=presuproyectocuenta.getPresuProyectoCuentaOriginal().getvalor().toString();
				}
				if(presuproyectocuenta.getvalor()!=null)
				{
					strValorNuevo=presuproyectocuenta.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuProyectoCuentaConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
			
			if(presuproyectocuenta.getIsNew()||!presuproyectocuenta.getorden().equals(presuproyectocuenta.getPresuProyectoCuentaOriginal().getorden()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presuproyectocuenta.getPresuProyectoCuentaOriginal().getorden()!=null)
				{
					strValorActual=presuproyectocuenta.getPresuProyectoCuentaOriginal().getorden().toString();
				}
				if(presuproyectocuenta.getorden()!=null)
				{
					strValorNuevo=presuproyectocuenta.getorden().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuProyectoCuentaConstantesFunciones.ORDEN,strValorActual,strValorNuevo);
			}	
			
			if(presuproyectocuenta.getIsNew()||!presuproyectocuenta.getid_presu_estado().equals(presuproyectocuenta.getPresuProyectoCuentaOriginal().getid_presu_estado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presuproyectocuenta.getPresuProyectoCuentaOriginal().getid_presu_estado()!=null)
				{
					strValorActual=presuproyectocuenta.getPresuProyectoCuentaOriginal().getid_presu_estado().toString();
				}
				if(presuproyectocuenta.getid_presu_estado()!=null)
				{
					strValorNuevo=presuproyectocuenta.getid_presu_estado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuProyectoCuentaConstantesFunciones.IDPRESUESTADO,strValorActual,strValorNuevo);
			}	
			
			if(presuproyectocuenta.getIsNew()||!presuproyectocuenta.getdescripcion().equals(presuproyectocuenta.getPresuProyectoCuentaOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presuproyectocuenta.getPresuProyectoCuentaOriginal().getdescripcion()!=null)
				{
					strValorActual=presuproyectocuenta.getPresuProyectoCuentaOriginal().getdescripcion();
				}
				if(presuproyectocuenta.getdescripcion()!=null)
				{
					strValorNuevo=presuproyectocuenta.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuProyectoCuentaConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void savePresuProyectoCuentaRelacionesWithConnection(PresuProyectoCuenta presuproyectocuenta,List<PresuAsignacion> presuasignacions) throws Exception {

		if(!presuproyectocuenta.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePresuProyectoCuentaRelacionesBase(presuproyectocuenta,presuasignacions,true);
		}
	}

	public void savePresuProyectoCuentaRelaciones(PresuProyectoCuenta presuproyectocuenta,List<PresuAsignacion> presuasignacions)throws Exception {

		if(!presuproyectocuenta.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePresuProyectoCuentaRelacionesBase(presuproyectocuenta,presuasignacions,false);
		}
	}

	public void savePresuProyectoCuentaRelacionesBase(PresuProyectoCuenta presuproyectocuenta,List<PresuAsignacion> presuasignacions,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("PresuProyectoCuenta-saveRelacionesWithConnection");}
	
			presuproyectocuenta.setPresuAsignacions(presuasignacions);

			this.setPresuProyectoCuenta(presuproyectocuenta);

			if(PresuProyectoCuentaLogicAdditional.validarSaveRelaciones(presuproyectocuenta,this)) {

				PresuProyectoCuentaLogicAdditional.updateRelacionesToSave(presuproyectocuenta,this);

				if((presuproyectocuenta.getIsNew()||presuproyectocuenta.getIsChanged())&&!presuproyectocuenta.getIsDeleted()) {
					this.savePresuProyectoCuenta();
					this.savePresuProyectoCuentaRelacionesDetalles(presuasignacions);

				} else if(presuproyectocuenta.getIsDeleted()) {
					this.savePresuProyectoCuentaRelacionesDetalles(presuasignacions);
					this.savePresuProyectoCuenta();
				}

				PresuProyectoCuentaLogicAdditional.updateRelacionesToSaveAfter(presuproyectocuenta,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			PresuAsignacionConstantesFunciones.InicializarGeneralEntityAuxiliaresPresuAsignacions(presuasignacions,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void savePresuProyectoCuentaRelacionesDetalles(List<PresuAsignacion> presuasignacions)throws Exception {
		try {
	

			Long idPresuProyectoCuentaActual=this.getPresuProyectoCuenta().getId();

			PresuAsignacionLogic presuasignacionLogic_Desde_PresuProyectoCuenta=new PresuAsignacionLogic();
			presuasignacionLogic_Desde_PresuProyectoCuenta.setPresuAsignacions(presuasignacions);

			presuasignacionLogic_Desde_PresuProyectoCuenta.setConnexion(this.getConnexion());
			presuasignacionLogic_Desde_PresuProyectoCuenta.setDatosCliente(this.datosCliente);

			for(PresuAsignacion presuasignacion_Desde_PresuProyectoCuenta:presuasignacionLogic_Desde_PresuProyectoCuenta.getPresuAsignacions()) {
				presuasignacion_Desde_PresuProyectoCuenta.setid_presu_proyecto_cuenta(idPresuProyectoCuentaActual);
			}

			presuasignacionLogic_Desde_PresuProyectoCuenta.savePresuAsignacions();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPresuProyectoCuenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PresuProyectoCuentaConstantesFunciones.getClassesForeignKeysOfPresuProyectoCuenta(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresuProyectoCuenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PresuProyectoCuentaConstantesFunciones.getClassesRelationshipsOfPresuProyectoCuenta(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

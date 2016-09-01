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
import com.bydan.erp.contabilidad.util.PresuProyectoConstantesFunciones;
import com.bydan.erp.contabilidad.util.PresuProyectoParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.PresuProyectoParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.PresuProyecto;
import com.bydan.erp.contabilidad.business.logic.PresuProyectoLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.nomina.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;








@SuppressWarnings("unused")
public class PresuProyectoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PresuProyectoLogic.class);
	
	protected PresuProyectoDataAccess presuproyectoDataAccess; 	
	protected PresuProyecto presuproyecto;
	protected List<PresuProyecto> presuproyectos;
	protected Object presuproyectoObject;	
	protected List<Object> presuproyectosObject;
	
	public static ClassValidator<PresuProyecto> presuproyectoValidator = new ClassValidator<PresuProyecto>(PresuProyecto.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PresuProyectoLogicAdditional presuproyectoLogicAdditional=null;
	
	public PresuProyectoLogicAdditional getPresuProyectoLogicAdditional() {
		return this.presuproyectoLogicAdditional;
	}
	
	public void setPresuProyectoLogicAdditional(PresuProyectoLogicAdditional presuproyectoLogicAdditional) {
		try {
			this.presuproyectoLogicAdditional=presuproyectoLogicAdditional;
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
	
	
	
	
	public  PresuProyectoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.presuproyectoDataAccess = new PresuProyectoDataAccess();
			
			this.presuproyectos= new ArrayList<PresuProyecto>();
			this.presuproyecto= new PresuProyecto();
			
			this.presuproyectoObject=new Object();
			this.presuproyectosObject=new ArrayList<Object>();
				
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
			
			this.presuproyectoDataAccess.setConnexionType(this.connexionType);
			this.presuproyectoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PresuProyectoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.presuproyectoDataAccess = new PresuProyectoDataAccess();
			this.presuproyectos= new ArrayList<PresuProyecto>();
			this.presuproyecto= new PresuProyecto();
			this.presuproyectoObject=new Object();
			this.presuproyectosObject=new ArrayList<Object>();
			
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
			
			this.presuproyectoDataAccess.setConnexionType(this.connexionType);
			this.presuproyectoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PresuProyecto getPresuProyecto() throws Exception {	
		PresuProyectoLogicAdditional.checkPresuProyectoToGet(presuproyecto,this.datosCliente,this.arrDatoGeneral);
		PresuProyectoLogicAdditional.updatePresuProyectoToGet(presuproyecto,this.arrDatoGeneral);
		
		return presuproyecto;
	}
		
	public void setPresuProyecto(PresuProyecto newPresuProyecto) {
		this.presuproyecto = newPresuProyecto;
	}
	
	public PresuProyectoDataAccess getPresuProyectoDataAccess() {
		return presuproyectoDataAccess;
	}
	
	public void setPresuProyectoDataAccess(PresuProyectoDataAccess newpresuproyectoDataAccess) {
		this.presuproyectoDataAccess = newpresuproyectoDataAccess;
	}
	
	public List<PresuProyecto> getPresuProyectos() throws Exception {		
		this.quitarPresuProyectosNulos();
		
		PresuProyectoLogicAdditional.checkPresuProyectoToGets(presuproyectos,this.datosCliente,this.arrDatoGeneral);
		
		for (PresuProyecto presuproyectoLocal: presuproyectos ) {
			PresuProyectoLogicAdditional.updatePresuProyectoToGet(presuproyectoLocal,this.arrDatoGeneral);
		}
		
		return presuproyectos;
	}
	
	public void setPresuProyectos(List<PresuProyecto> newPresuProyectos) {
		this.presuproyectos = newPresuProyectos;
	}
	
	public Object getPresuProyectoObject() {	
		this.presuproyectoObject=this.presuproyectoDataAccess.getEntityObject();
		return this.presuproyectoObject;
	}
		
	public void setPresuProyectoObject(Object newPresuProyectoObject) {
		this.presuproyectoObject = newPresuProyectoObject;
	}
	
	public List<Object> getPresuProyectosObject() {		
		this.presuproyectosObject=this.presuproyectoDataAccess.getEntitiesObject();
		return this.presuproyectosObject;
	}
		
	public void setPresuProyectosObject(List<Object> newPresuProyectosObject) {
		this.presuproyectosObject = newPresuProyectosObject;
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
		
		if(this.presuproyectoDataAccess!=null) {
			this.presuproyectoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyecto.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			presuproyectoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			presuproyectoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		presuproyecto = new  PresuProyecto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyecto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			presuproyecto=presuproyectoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presuproyecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresuProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyecto(this.presuproyecto);
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
		presuproyecto = new  PresuProyecto();
		  		  
        try {
			
			presuproyecto=presuproyectoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presuproyecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresuProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyecto(this.presuproyecto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		presuproyecto = new  PresuProyecto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyecto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			presuproyecto=presuproyectoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presuproyecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresuProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyecto(this.presuproyecto);
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
		presuproyecto = new  PresuProyecto();
		  		  
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
		presuproyecto = new  PresuProyecto();
		  		  
        try {
			
			presuproyecto=presuproyectoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presuproyecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresuProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyecto(this.presuproyecto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		presuproyecto = new  PresuProyecto();
		  		  
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
		presuproyecto = new  PresuProyecto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyecto.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =presuproyectoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		presuproyecto = new  PresuProyecto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=presuproyectoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		presuproyecto = new  PresuProyecto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyecto.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =presuproyectoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		presuproyecto = new  PresuProyecto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=presuproyectoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		presuproyecto = new  PresuProyecto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyecto.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =presuproyectoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		presuproyecto = new  PresuProyecto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=presuproyectoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		presuproyectos = new  ArrayList<PresuProyecto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyecto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PresuProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presuproyectos=presuproyectoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresuProyecto(presuproyectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyecto(this.presuproyectos);
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
		presuproyectos = new  ArrayList<PresuProyecto>();
		  		  
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
		presuproyectos = new  ArrayList<PresuProyecto>();
		  		  
        try {			
			PresuProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presuproyectos=presuproyectoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPresuProyecto(presuproyectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyecto(this.presuproyectos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		presuproyectos = new  ArrayList<PresuProyecto>();
		  		  
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
		presuproyectos = new  ArrayList<PresuProyecto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyecto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PresuProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presuproyectos=presuproyectoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresuProyecto(presuproyectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyecto(this.presuproyectos);
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
		presuproyectos = new  ArrayList<PresuProyecto>();
		  		  
        try {
			PresuProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presuproyectos=presuproyectoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresuProyecto(presuproyectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyecto(this.presuproyectos);
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
		presuproyectos = new  ArrayList<PresuProyecto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyecto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresuProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presuproyectos=presuproyectoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresuProyecto(presuproyectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyecto(this.presuproyectos);
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
		presuproyectos = new  ArrayList<PresuProyecto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresuProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presuproyectos=presuproyectoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresuProyecto(presuproyectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyecto(this.presuproyectos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		presuproyecto = new  PresuProyecto();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyecto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresuProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presuproyecto=presuproyectoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresuProyecto(presuproyecto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyecto(this.presuproyecto);
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
		presuproyecto = new  PresuProyecto();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresuProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presuproyecto=presuproyectoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresuProyecto(presuproyecto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyecto(this.presuproyecto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		presuproyectos = new  ArrayList<PresuProyecto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyecto.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			PresuProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presuproyectos=presuproyectoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresuProyecto(presuproyectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyecto(this.presuproyectos);
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
		presuproyectos = new  ArrayList<PresuProyecto>();
		  		  
        try {
			PresuProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presuproyectos=presuproyectoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresuProyecto(presuproyectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyecto(this.presuproyectos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosPresuProyectosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		presuproyectos = new  ArrayList<PresuProyecto>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyecto.class.getSimpleName()+"-getTodosPresuProyectosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresuProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presuproyectos=presuproyectoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPresuProyecto(presuproyectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyecto(this.presuproyectos);
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
	
	public  void  getTodosPresuProyectos(String sFinalQuery,Pagination pagination)throws Exception {
		presuproyectos = new  ArrayList<PresuProyecto>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresuProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presuproyectos=presuproyectoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPresuProyecto(presuproyectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyecto(this.presuproyectos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPresuProyecto(PresuProyecto presuproyecto) throws Exception {
		Boolean estaValidado=false;
		
		if(presuproyecto.getIsNew() || presuproyecto.getIsChanged()) { 
			this.invalidValues = presuproyectoValidator.getInvalidValues(presuproyecto);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(presuproyecto);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPresuProyecto(List<PresuProyecto> PresuProyectos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(PresuProyecto presuproyectoLocal:presuproyectos) {				
			estaValidadoObjeto=this.validarGuardarPresuProyecto(presuproyectoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPresuProyecto(List<PresuProyecto> PresuProyectos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPresuProyecto(presuproyectos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPresuProyecto(PresuProyecto PresuProyecto) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPresuProyecto(presuproyecto)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(PresuProyecto presuproyecto) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+presuproyecto.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PresuProyectoConstantesFunciones.getPresuProyectoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"presuproyecto","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PresuProyectoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PresuProyectoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePresuProyectoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyecto.class.getSimpleName()+"-savePresuProyectoWithConnection");connexion.begin();			
			
			PresuProyectoLogicAdditional.checkPresuProyectoToSave(this.presuproyecto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PresuProyectoLogicAdditional.updatePresuProyectoToSave(this.presuproyecto,this.arrDatoGeneral);
			
			PresuProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.presuproyecto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPresuProyecto();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPresuProyecto(this.presuproyecto)) {
				PresuProyectoDataAccess.save(this.presuproyecto, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.presuproyecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PresuProyectoLogicAdditional.checkPresuProyectoToSaveAfter(this.presuproyecto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPresuProyecto();
			
			connexion.commit();			
			
			if(this.presuproyecto.getIsDeleted()) {
				this.presuproyecto=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePresuProyecto()throws Exception {	
		try {	
			
			PresuProyectoLogicAdditional.checkPresuProyectoToSave(this.presuproyecto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PresuProyectoLogicAdditional.updatePresuProyectoToSave(this.presuproyecto,this.arrDatoGeneral);
			
			PresuProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.presuproyecto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPresuProyecto(this.presuproyecto)) {			
				PresuProyectoDataAccess.save(this.presuproyecto, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.presuproyecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PresuProyectoLogicAdditional.checkPresuProyectoToSaveAfter(this.presuproyecto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.presuproyecto.getIsDeleted()) {
				this.presuproyecto=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePresuProyectosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyecto.class.getSimpleName()+"-savePresuProyectosWithConnection");connexion.begin();			
			
			PresuProyectoLogicAdditional.checkPresuProyectoToSaves(presuproyectos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPresuProyectos();
			
			Boolean validadoTodosPresuProyecto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PresuProyecto presuproyectoLocal:presuproyectos) {		
				if(presuproyectoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PresuProyectoLogicAdditional.updatePresuProyectoToSave(presuproyectoLocal,this.arrDatoGeneral);
	        	
				PresuProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),presuproyectoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPresuProyecto(presuproyectoLocal)) {
					PresuProyectoDataAccess.save(presuproyectoLocal, connexion);				
				} else {
					validadoTodosPresuProyecto=false;
				}
			}
			
			if(!validadoTodosPresuProyecto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PresuProyectoLogicAdditional.checkPresuProyectoToSavesAfter(presuproyectos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPresuProyectos();
			
			connexion.commit();		
			
			this.quitarPresuProyectosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePresuProyectos()throws Exception {				
		 try {	
			PresuProyectoLogicAdditional.checkPresuProyectoToSaves(presuproyectos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPresuProyecto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PresuProyecto presuproyectoLocal:presuproyectos) {				
				if(presuproyectoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PresuProyectoLogicAdditional.updatePresuProyectoToSave(presuproyectoLocal,this.arrDatoGeneral);
	        	
				PresuProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),presuproyectoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPresuProyecto(presuproyectoLocal)) {				
					PresuProyectoDataAccess.save(presuproyectoLocal, connexion);				
				} else {
					validadoTodosPresuProyecto=false;
				}
			}
			
			if(!validadoTodosPresuProyecto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PresuProyectoLogicAdditional.checkPresuProyectoToSavesAfter(presuproyectos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPresuProyectosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PresuProyectoParameterReturnGeneral procesarAccionPresuProyectos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PresuProyecto> presuproyectos,PresuProyectoParameterReturnGeneral presuproyectoParameterGeneral)throws Exception {
		 try {	
			PresuProyectoParameterReturnGeneral presuproyectoReturnGeneral=new PresuProyectoParameterReturnGeneral();
	
			PresuProyectoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,presuproyectos,presuproyectoParameterGeneral,presuproyectoReturnGeneral);
			
			return presuproyectoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PresuProyectoParameterReturnGeneral procesarAccionPresuProyectosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PresuProyecto> presuproyectos,PresuProyectoParameterReturnGeneral presuproyectoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyecto.class.getSimpleName()+"-procesarAccionPresuProyectosWithConnection");connexion.begin();			
			
			PresuProyectoParameterReturnGeneral presuproyectoReturnGeneral=new PresuProyectoParameterReturnGeneral();
	
			PresuProyectoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,presuproyectos,presuproyectoParameterGeneral,presuproyectoReturnGeneral);
			
			this.connexion.commit();
			
			return presuproyectoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PresuProyectoParameterReturnGeneral procesarEventosPresuProyectos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PresuProyecto> presuproyectos,PresuProyecto presuproyecto,PresuProyectoParameterReturnGeneral presuproyectoParameterGeneral,Boolean isEsNuevoPresuProyecto,ArrayList<Classe> clases)throws Exception {
		 try {	
			PresuProyectoParameterReturnGeneral presuproyectoReturnGeneral=new PresuProyectoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				presuproyectoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PresuProyectoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,presuproyectos,presuproyecto,presuproyectoParameterGeneral,presuproyectoReturnGeneral,isEsNuevoPresuProyecto,clases);
			
			return presuproyectoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PresuProyectoParameterReturnGeneral procesarEventosPresuProyectosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PresuProyecto> presuproyectos,PresuProyecto presuproyecto,PresuProyectoParameterReturnGeneral presuproyectoParameterGeneral,Boolean isEsNuevoPresuProyecto,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyecto.class.getSimpleName()+"-procesarEventosPresuProyectosWithConnection");connexion.begin();			
			
			PresuProyectoParameterReturnGeneral presuproyectoReturnGeneral=new PresuProyectoParameterReturnGeneral();
	
			presuproyectoReturnGeneral.setPresuProyecto(presuproyecto);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				presuproyectoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PresuProyectoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,presuproyectos,presuproyecto,presuproyectoParameterGeneral,presuproyectoReturnGeneral,isEsNuevoPresuProyecto,clases);
			
			this.connexion.commit();
			
			return presuproyectoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PresuProyectoParameterReturnGeneral procesarImportacionPresuProyectosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PresuProyectoParameterReturnGeneral presuproyectoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyecto.class.getSimpleName()+"-procesarImportacionPresuProyectosWithConnection");connexion.begin();			
			
			PresuProyectoParameterReturnGeneral presuproyectoReturnGeneral=new PresuProyectoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.presuproyectos=new ArrayList<PresuProyecto>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.presuproyecto=new PresuProyecto();
				
				
				if(conColumnasBase) {this.presuproyecto.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.presuproyecto.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.presuproyecto.setcodigo(arrColumnas[iColumn++]);
			this.presuproyecto.setnombre(arrColumnas[iColumn++]);
				this.presuproyecto.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.presuproyecto.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
			this.presuproyecto.setdescripcion(arrColumnas[iColumn++]);
				
				this.presuproyectos.add(this.presuproyecto);
			}
			
			this.savePresuProyectos();
			
			this.connexion.commit();
			
			presuproyectoReturnGeneral.setConRetornoEstaProcesado(true);
			presuproyectoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return presuproyectoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPresuProyectosEliminados() throws Exception {				
		
		List<PresuProyecto> presuproyectosAux= new ArrayList<PresuProyecto>();
		
		for(PresuProyecto presuproyecto:presuproyectos) {
			if(!presuproyecto.getIsDeleted()) {
				presuproyectosAux.add(presuproyecto);
			}
		}
		
		presuproyectos=presuproyectosAux;
	}
	
	public void quitarPresuProyectosNulos() throws Exception {				
		
		List<PresuProyecto> presuproyectosAux= new ArrayList<PresuProyecto>();
		
		for(PresuProyecto presuproyecto : this.presuproyectos) {
			if(presuproyecto==null) {
				presuproyectosAux.add(presuproyecto);
			}
		}
		
		//this.presuproyectos=presuproyectosAux;
		
		this.presuproyectos.removeAll(presuproyectosAux);
	}
	
	public void getSetVersionRowPresuProyectoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(presuproyecto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((presuproyecto.getIsDeleted() || (presuproyecto.getIsChanged()&&!presuproyecto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=presuproyectoDataAccess.getSetVersionRowPresuProyecto(connexion,presuproyecto.getId());
				
				if(!presuproyecto.getVersionRow().equals(timestamp)) {	
					presuproyecto.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				presuproyecto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPresuProyecto()throws Exception {	
		
		if(presuproyecto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((presuproyecto.getIsDeleted() || (presuproyecto.getIsChanged()&&!presuproyecto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=presuproyectoDataAccess.getSetVersionRowPresuProyecto(connexion,presuproyecto.getId());
			
			try {							
				if(!presuproyecto.getVersionRow().equals(timestamp)) {	
					presuproyecto.setVersionRow(timestamp);
				}
				
				presuproyecto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPresuProyectosWithConnection()throws Exception {	
		if(presuproyectos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(PresuProyecto presuproyectoAux:presuproyectos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(presuproyectoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(presuproyectoAux.getIsDeleted() || (presuproyectoAux.getIsChanged()&&!presuproyectoAux.getIsNew())) {
						
						timestamp=presuproyectoDataAccess.getSetVersionRowPresuProyecto(connexion,presuproyectoAux.getId());
						
						if(!presuproyecto.getVersionRow().equals(timestamp)) {	
							presuproyectoAux.setVersionRow(timestamp);
						}
								
						presuproyectoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPresuProyectos()throws Exception {	
		if(presuproyectos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(PresuProyecto presuproyectoAux:presuproyectos) {
					if(presuproyectoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(presuproyectoAux.getIsDeleted() || (presuproyectoAux.getIsChanged()&&!presuproyectoAux.getIsNew())) {
						
						timestamp=presuproyectoDataAccess.getSetVersionRowPresuProyecto(connexion,presuproyectoAux.getId());
						
						if(!presuproyectoAux.getVersionRow().equals(timestamp)) {	
							presuproyectoAux.setVersionRow(timestamp);
						}
						
													
						presuproyectoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PresuProyectoParameterReturnGeneral cargarCombosLoteForeignKeyPresuProyectoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPresuTipoProyecto,String finalQueryGlobalCentroCosto,String finalQueryGlobalPresuEstado) throws Exception {
		PresuProyectoParameterReturnGeneral  presuproyectoReturnGeneral =new PresuProyectoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyecto.class.getSimpleName()+"-cargarCombosLoteForeignKeyPresuProyectoWithConnection");connexion.begin();
			
			presuproyectoReturnGeneral =new PresuProyectoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			presuproyectoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			presuproyectoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			presuproyectoReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<PresuTipoProyecto> presutipoproyectosForeignKey=new ArrayList<PresuTipoProyecto>();
			PresuTipoProyectoLogic presutipoproyectoLogic=new PresuTipoProyectoLogic();
			presutipoproyectoLogic.setConnexion(this.connexion);
			presutipoproyectoLogic.getPresuTipoProyectoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPresuTipoProyecto.equals("NONE")) {
				presutipoproyectoLogic.getTodosPresuTipoProyectos(finalQueryGlobalPresuTipoProyecto,new Pagination());
				presutipoproyectosForeignKey=presutipoproyectoLogic.getPresuTipoProyectos();
			}

			presuproyectoReturnGeneral.setpresutipoproyectosForeignKey(presutipoproyectosForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			presuproyectoReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<PresuEstado> presuestadosForeignKey=new ArrayList<PresuEstado>();
			PresuEstadoLogic presuestadoLogic=new PresuEstadoLogic();
			presuestadoLogic.setConnexion(this.connexion);
			presuestadoLogic.getPresuEstadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPresuEstado.equals("NONE")) {
				presuestadoLogic.getTodosPresuEstados(finalQueryGlobalPresuEstado,new Pagination());
				presuestadosForeignKey=presuestadoLogic.getPresuEstados();
			}

			presuproyectoReturnGeneral.setpresuestadosForeignKey(presuestadosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return presuproyectoReturnGeneral;
	}
	
	public PresuProyectoParameterReturnGeneral cargarCombosLoteForeignKeyPresuProyecto(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPresuTipoProyecto,String finalQueryGlobalCentroCosto,String finalQueryGlobalPresuEstado) throws Exception {
		PresuProyectoParameterReturnGeneral  presuproyectoReturnGeneral =new PresuProyectoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			presuproyectoReturnGeneral =new PresuProyectoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			presuproyectoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			presuproyectoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			presuproyectoReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<PresuTipoProyecto> presutipoproyectosForeignKey=new ArrayList<PresuTipoProyecto>();
			PresuTipoProyectoLogic presutipoproyectoLogic=new PresuTipoProyectoLogic();
			presutipoproyectoLogic.setConnexion(this.connexion);
			presutipoproyectoLogic.getPresuTipoProyectoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPresuTipoProyecto.equals("NONE")) {
				presutipoproyectoLogic.getTodosPresuTipoProyectos(finalQueryGlobalPresuTipoProyecto,new Pagination());
				presutipoproyectosForeignKey=presutipoproyectoLogic.getPresuTipoProyectos();
			}

			presuproyectoReturnGeneral.setpresutipoproyectosForeignKey(presutipoproyectosForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			presuproyectoReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<PresuEstado> presuestadosForeignKey=new ArrayList<PresuEstado>();
			PresuEstadoLogic presuestadoLogic=new PresuEstadoLogic();
			presuestadoLogic.setConnexion(this.connexion);
			presuestadoLogic.getPresuEstadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPresuEstado.equals("NONE")) {
				presuestadoLogic.getTodosPresuEstados(finalQueryGlobalPresuEstado,new Pagination());
				presuestadosForeignKey=presuestadoLogic.getPresuEstados();
			}

			presuproyectoReturnGeneral.setpresuestadosForeignKey(presuestadosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return presuproyectoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyPresuProyectoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			PresuTransferenciaLogic presutransferenciaLogic=new PresuTransferenciaLogic();
			PresuProyectoCuentaLogic presuproyectocuentaLogic=new PresuProyectoCuentaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyecto.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyPresuProyectoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(PresuTransferencia.class));
			classes.add(new Classe(PresuProyectoCuenta.class));
											
			

			presutransferenciaLogic.setConnexion(this.getConnexion());
			presutransferenciaLogic.setDatosCliente(this.datosCliente);
			presutransferenciaLogic.setIsConRefrescarForeignKeys(true);

			presuproyectocuentaLogic.setConnexion(this.getConnexion());
			presuproyectocuentaLogic.setDatosCliente(this.datosCliente);
			presuproyectocuentaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(PresuProyecto presuproyecto:this.presuproyectos) {
				

				classes=new ArrayList<Classe>();
				classes=PresuTransferenciaConstantesFunciones.getClassesForeignKeysOfPresuTransferencia(new ArrayList<Classe>(),DeepLoadType.NONE);

				presutransferenciaLogic.setPresuTransferencias(presuproyecto.presutransferencias);
				presutransferenciaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=PresuProyectoCuentaConstantesFunciones.getClassesForeignKeysOfPresuProyectoCuenta(new ArrayList<Classe>(),DeepLoadType.NONE);

				presuproyectocuentaLogic.setPresuProyectoCuentas(presuproyecto.presuproyectocuentas);
				presuproyectocuentaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(PresuProyecto presuproyecto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PresuProyectoLogicAdditional.updatePresuProyectoToGet(presuproyecto,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		presuproyecto.setEmpresa(presuproyectoDataAccess.getEmpresa(connexion,presuproyecto));
		presuproyecto.setSucursal(presuproyectoDataAccess.getSucursal(connexion,presuproyecto));
		presuproyecto.setEjercicio(presuproyectoDataAccess.getEjercicio(connexion,presuproyecto));
		presuproyecto.setPresuTipoProyecto(presuproyectoDataAccess.getPresuTipoProyecto(connexion,presuproyecto));
		presuproyecto.setCentroCosto(presuproyectoDataAccess.getCentroCosto(connexion,presuproyecto));
		presuproyecto.setPresuEstado(presuproyectoDataAccess.getPresuEstado(connexion,presuproyecto));
		presuproyecto.setPresuTransferencias(presuproyectoDataAccess.getPresuTransferencias(connexion,presuproyecto));
		presuproyecto.setPresuProyectoCuentas(presuproyectoDataAccess.getPresuProyectoCuentas(connexion,presuproyecto));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				presuproyecto.setEmpresa(presuproyectoDataAccess.getEmpresa(connexion,presuproyecto));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				presuproyecto.setSucursal(presuproyectoDataAccess.getSucursal(connexion,presuproyecto));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				presuproyecto.setEjercicio(presuproyectoDataAccess.getEjercicio(connexion,presuproyecto));
				continue;
			}

			if(clas.clas.equals(PresuTipoProyecto.class)) {
				presuproyecto.setPresuTipoProyecto(presuproyectoDataAccess.getPresuTipoProyecto(connexion,presuproyecto));
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				presuproyecto.setCentroCosto(presuproyectoDataAccess.getCentroCosto(connexion,presuproyecto));
				continue;
			}

			if(clas.clas.equals(PresuEstado.class)) {
				presuproyecto.setPresuEstado(presuproyectoDataAccess.getPresuEstado(connexion,presuproyecto));
				continue;
			}

			if(clas.clas.equals(PresuTransferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				presuproyecto.setPresuTransferencias(presuproyectoDataAccess.getPresuTransferencias(connexion,presuproyecto));

				if(this.isConDeep) {
					PresuTransferenciaLogic presutransferenciaLogic= new PresuTransferenciaLogic(this.connexion);
					presutransferenciaLogic.setPresuTransferencias(presuproyecto.getPresuTransferencias());
					ArrayList<Classe> classesLocal=PresuTransferenciaConstantesFunciones.getClassesForeignKeysOfPresuTransferencia(new ArrayList<Classe>(),DeepLoadType.NONE);
					presutransferenciaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PresuTransferenciaConstantesFunciones.refrescarForeignKeysDescripcionesPresuTransferencia(presutransferenciaLogic.getPresuTransferencias());
					presuproyecto.setPresuTransferencias(presutransferenciaLogic.getPresuTransferencias());
				}

				continue;
			}

			if(clas.clas.equals(PresuProyectoCuenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				presuproyecto.setPresuProyectoCuentas(presuproyectoDataAccess.getPresuProyectoCuentas(connexion,presuproyecto));

				if(this.isConDeep) {
					PresuProyectoCuentaLogic presuproyectocuentaLogic= new PresuProyectoCuentaLogic(this.connexion);
					presuproyectocuentaLogic.setPresuProyectoCuentas(presuproyecto.getPresuProyectoCuentas());
					ArrayList<Classe> classesLocal=PresuProyectoCuentaConstantesFunciones.getClassesForeignKeysOfPresuProyectoCuenta(new ArrayList<Classe>(),DeepLoadType.NONE);
					presuproyectocuentaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					PresuProyectoCuentaConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyectoCuenta(presuproyectocuentaLogic.getPresuProyectoCuentas());
					presuproyecto.setPresuProyectoCuentas(presuproyectocuentaLogic.getPresuProyectoCuentas());
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
			presuproyecto.setEmpresa(presuproyectoDataAccess.getEmpresa(connexion,presuproyecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presuproyecto.setSucursal(presuproyectoDataAccess.getSucursal(connexion,presuproyecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presuproyecto.setEjercicio(presuproyectoDataAccess.getEjercicio(connexion,presuproyecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PresuTipoProyecto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presuproyecto.setPresuTipoProyecto(presuproyectoDataAccess.getPresuTipoProyecto(connexion,presuproyecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presuproyecto.setCentroCosto(presuproyectoDataAccess.getCentroCosto(connexion,presuproyecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PresuEstado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presuproyecto.setPresuEstado(presuproyectoDataAccess.getPresuEstado(connexion,presuproyecto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PresuTransferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PresuTransferencia.class));
			presuproyecto.setPresuTransferencias(presuproyectoDataAccess.getPresuTransferencias(connexion,presuproyecto));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PresuProyectoCuenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PresuProyectoCuenta.class));
			presuproyecto.setPresuProyectoCuentas(presuproyectoDataAccess.getPresuProyectoCuentas(connexion,presuproyecto));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		presuproyecto.setEmpresa(presuproyectoDataAccess.getEmpresa(connexion,presuproyecto));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(presuproyecto.getEmpresa(),isDeep,deepLoadType,clases);
				
		presuproyecto.setSucursal(presuproyectoDataAccess.getSucursal(connexion,presuproyecto));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(presuproyecto.getSucursal(),isDeep,deepLoadType,clases);
				
		presuproyecto.setEjercicio(presuproyectoDataAccess.getEjercicio(connexion,presuproyecto));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(presuproyecto.getEjercicio(),isDeep,deepLoadType,clases);
				
		presuproyecto.setPresuTipoProyecto(presuproyectoDataAccess.getPresuTipoProyecto(connexion,presuproyecto));
		PresuTipoProyectoLogic presutipoproyectoLogic= new PresuTipoProyectoLogic(connexion);
		presutipoproyectoLogic.deepLoad(presuproyecto.getPresuTipoProyecto(),isDeep,deepLoadType,clases);
				
		presuproyecto.setCentroCosto(presuproyectoDataAccess.getCentroCosto(connexion,presuproyecto));
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(presuproyecto.getCentroCosto(),isDeep,deepLoadType,clases);
				
		presuproyecto.setPresuEstado(presuproyectoDataAccess.getPresuEstado(connexion,presuproyecto));
		PresuEstadoLogic presuestadoLogic= new PresuEstadoLogic(connexion);
		presuestadoLogic.deepLoad(presuproyecto.getPresuEstado(),isDeep,deepLoadType,clases);
				

		presuproyecto.setPresuTransferencias(presuproyectoDataAccess.getPresuTransferencias(connexion,presuproyecto));

		for(PresuTransferencia presutransferencia:presuproyecto.getPresuTransferencias()) {
			PresuTransferenciaLogic presutransferenciaLogic= new PresuTransferenciaLogic(connexion);
			presutransferenciaLogic.deepLoad(presutransferencia,isDeep,deepLoadType,clases);
		}

		presuproyecto.setPresuProyectoCuentas(presuproyectoDataAccess.getPresuProyectoCuentas(connexion,presuproyecto));

		for(PresuProyectoCuenta presuproyectocuenta:presuproyecto.getPresuProyectoCuentas()) {
			PresuProyectoCuentaLogic presuproyectocuentaLogic= new PresuProyectoCuentaLogic(connexion);
			presuproyectocuentaLogic.deepLoad(presuproyectocuenta,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				presuproyecto.setEmpresa(presuproyectoDataAccess.getEmpresa(connexion,presuproyecto));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(presuproyecto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				presuproyecto.setSucursal(presuproyectoDataAccess.getSucursal(connexion,presuproyecto));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(presuproyecto.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				presuproyecto.setEjercicio(presuproyectoDataAccess.getEjercicio(connexion,presuproyecto));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(presuproyecto.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PresuTipoProyecto.class)) {
				presuproyecto.setPresuTipoProyecto(presuproyectoDataAccess.getPresuTipoProyecto(connexion,presuproyecto));
				PresuTipoProyectoLogic presutipoproyectoLogic= new PresuTipoProyectoLogic(connexion);
				presutipoproyectoLogic.deepLoad(presuproyecto.getPresuTipoProyecto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				presuproyecto.setCentroCosto(presuproyectoDataAccess.getCentroCosto(connexion,presuproyecto));
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepLoad(presuproyecto.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PresuEstado.class)) {
				presuproyecto.setPresuEstado(presuproyectoDataAccess.getPresuEstado(connexion,presuproyecto));
				PresuEstadoLogic presuestadoLogic= new PresuEstadoLogic(connexion);
				presuestadoLogic.deepLoad(presuproyecto.getPresuEstado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PresuTransferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				presuproyecto.setPresuTransferencias(presuproyectoDataAccess.getPresuTransferencias(connexion,presuproyecto));

				for(PresuTransferencia presutransferencia:presuproyecto.getPresuTransferencias()) {
					PresuTransferenciaLogic presutransferenciaLogic= new PresuTransferenciaLogic(connexion);
					presutransferenciaLogic.deepLoad(presutransferencia,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PresuProyectoCuenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				presuproyecto.setPresuProyectoCuentas(presuproyectoDataAccess.getPresuProyectoCuentas(connexion,presuproyecto));

				for(PresuProyectoCuenta presuproyectocuenta:presuproyecto.getPresuProyectoCuentas()) {
					PresuProyectoCuentaLogic presuproyectocuentaLogic= new PresuProyectoCuentaLogic(connexion);
					presuproyectocuentaLogic.deepLoad(presuproyectocuenta,isDeep,deepLoadType,clases);
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
			presuproyecto.setEmpresa(presuproyectoDataAccess.getEmpresa(connexion,presuproyecto));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(presuproyecto.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presuproyecto.setSucursal(presuproyectoDataAccess.getSucursal(connexion,presuproyecto));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(presuproyecto.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presuproyecto.setEjercicio(presuproyectoDataAccess.getEjercicio(connexion,presuproyecto));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(presuproyecto.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(PresuTipoProyecto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presuproyecto.setPresuTipoProyecto(presuproyectoDataAccess.getPresuTipoProyecto(connexion,presuproyecto));
			PresuTipoProyectoLogic presutipoproyectoLogic= new PresuTipoProyectoLogic(connexion);
			presutipoproyectoLogic.deepLoad(presuproyecto.getPresuTipoProyecto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presuproyecto.setCentroCosto(presuproyectoDataAccess.getCentroCosto(connexion,presuproyecto));
			CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
			centrocostoLogic.deepLoad(presuproyecto.getCentroCosto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(PresuEstado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			presuproyecto.setPresuEstado(presuproyectoDataAccess.getPresuEstado(connexion,presuproyecto));
			PresuEstadoLogic presuestadoLogic= new PresuEstadoLogic(connexion);
			presuestadoLogic.deepLoad(presuproyecto.getPresuEstado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PresuTransferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PresuTransferencia.class));
			presuproyecto.setPresuTransferencias(presuproyectoDataAccess.getPresuTransferencias(connexion,presuproyecto));

			for(PresuTransferencia presutransferencia:presuproyecto.getPresuTransferencias()) {
				PresuTransferenciaLogic presutransferenciaLogic= new PresuTransferenciaLogic(connexion);
				presutransferenciaLogic.deepLoad(presutransferencia,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(PresuProyectoCuenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(PresuProyectoCuenta.class));
			presuproyecto.setPresuProyectoCuentas(presuproyectoDataAccess.getPresuProyectoCuentas(connexion,presuproyecto));

			for(PresuProyectoCuenta presuproyectocuenta:presuproyecto.getPresuProyectoCuentas()) {
				PresuProyectoCuentaLogic presuproyectocuentaLogic= new PresuProyectoCuentaLogic(connexion);
				presuproyectocuentaLogic.deepLoad(presuproyectocuenta,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(PresuProyecto presuproyecto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			PresuProyectoLogicAdditional.updatePresuProyectoToSave(presuproyecto,this.arrDatoGeneral);
			
PresuProyectoDataAccess.save(presuproyecto, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(presuproyecto.getEmpresa(),connexion);

		SucursalDataAccess.save(presuproyecto.getSucursal(),connexion);

		EjercicioDataAccess.save(presuproyecto.getEjercicio(),connexion);

		PresuTipoProyectoDataAccess.save(presuproyecto.getPresuTipoProyecto(),connexion);

		CentroCostoDataAccess.save(presuproyecto.getCentroCosto(),connexion);

		PresuEstadoDataAccess.save(presuproyecto.getPresuEstado(),connexion);

		for(PresuTransferencia presutransferencia:presuproyecto.getPresuTransferencias()) {
			presutransferencia.setid_presu_proyecto(presuproyecto.getId());
			PresuTransferenciaDataAccess.save(presutransferencia,connexion);
		}

		for(PresuProyectoCuenta presuproyectocuenta:presuproyecto.getPresuProyectoCuentas()) {
			presuproyectocuenta.setid_presu_proyecto(presuproyecto.getId());
			PresuProyectoCuentaDataAccess.save(presuproyectocuenta,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(presuproyecto.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(presuproyecto.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(presuproyecto.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(PresuTipoProyecto.class)) {
				PresuTipoProyectoDataAccess.save(presuproyecto.getPresuTipoProyecto(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(presuproyecto.getCentroCosto(),connexion);
				continue;
			}

			if(clas.clas.equals(PresuEstado.class)) {
				PresuEstadoDataAccess.save(presuproyecto.getPresuEstado(),connexion);
				continue;
			}


			if(clas.clas.equals(PresuTransferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PresuTransferencia presutransferencia:presuproyecto.getPresuTransferencias()) {
					presutransferencia.setid_presu_proyecto(presuproyecto.getId());
					PresuTransferenciaDataAccess.save(presutransferencia,connexion);
				}
				continue;
			}

			if(clas.clas.equals(PresuProyectoCuenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PresuProyectoCuenta presuproyectocuenta:presuproyecto.getPresuProyectoCuentas()) {
					presuproyectocuenta.setid_presu_proyecto(presuproyecto.getId());
					PresuProyectoCuentaDataAccess.save(presuproyectocuenta,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(presuproyecto.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(presuproyecto.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(presuproyecto.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(presuproyecto.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(presuproyecto.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(presuproyecto.getEjercicio(),isDeep,deepLoadType,clases);
				

		PresuTipoProyectoDataAccess.save(presuproyecto.getPresuTipoProyecto(),connexion);
		PresuTipoProyectoLogic presutipoproyectoLogic= new PresuTipoProyectoLogic(connexion);
		presutipoproyectoLogic.deepLoad(presuproyecto.getPresuTipoProyecto(),isDeep,deepLoadType,clases);
				

		CentroCostoDataAccess.save(presuproyecto.getCentroCosto(),connexion);
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(presuproyecto.getCentroCosto(),isDeep,deepLoadType,clases);
				

		PresuEstadoDataAccess.save(presuproyecto.getPresuEstado(),connexion);
		PresuEstadoLogic presuestadoLogic= new PresuEstadoLogic(connexion);
		presuestadoLogic.deepLoad(presuproyecto.getPresuEstado(),isDeep,deepLoadType,clases);
				

		for(PresuTransferencia presutransferencia:presuproyecto.getPresuTransferencias()) {
			PresuTransferenciaLogic presutransferenciaLogic= new PresuTransferenciaLogic(connexion);
			presutransferencia.setid_presu_proyecto(presuproyecto.getId());
			PresuTransferenciaDataAccess.save(presutransferencia,connexion);
			presutransferenciaLogic.deepSave(presutransferencia,isDeep,deepLoadType,clases);
		}

		for(PresuProyectoCuenta presuproyectocuenta:presuproyecto.getPresuProyectoCuentas()) {
			PresuProyectoCuentaLogic presuproyectocuentaLogic= new PresuProyectoCuentaLogic(connexion);
			presuproyectocuenta.setid_presu_proyecto(presuproyecto.getId());
			PresuProyectoCuentaDataAccess.save(presuproyectocuenta,connexion);
			presuproyectocuentaLogic.deepSave(presuproyectocuenta,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(presuproyecto.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(presuproyecto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(presuproyecto.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(presuproyecto.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(presuproyecto.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(presuproyecto.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PresuTipoProyecto.class)) {
				PresuTipoProyectoDataAccess.save(presuproyecto.getPresuTipoProyecto(),connexion);
				PresuTipoProyectoLogic presutipoproyectoLogic= new PresuTipoProyectoLogic(connexion);
				presutipoproyectoLogic.deepSave(presuproyecto.getPresuTipoProyecto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(presuproyecto.getCentroCosto(),connexion);
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepSave(presuproyecto.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(PresuEstado.class)) {
				PresuEstadoDataAccess.save(presuproyecto.getPresuEstado(),connexion);
				PresuEstadoLogic presuestadoLogic= new PresuEstadoLogic(connexion);
				presuestadoLogic.deepSave(presuproyecto.getPresuEstado(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(PresuTransferencia.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PresuTransferencia presutransferencia:presuproyecto.getPresuTransferencias()) {
					PresuTransferenciaLogic presutransferenciaLogic= new PresuTransferenciaLogic(connexion);
					presutransferencia.setid_presu_proyecto(presuproyecto.getId());
					PresuTransferenciaDataAccess.save(presutransferencia,connexion);
					presutransferenciaLogic.deepSave(presutransferencia,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(PresuProyectoCuenta.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(PresuProyectoCuenta presuproyectocuenta:presuproyecto.getPresuProyectoCuentas()) {
					PresuProyectoCuentaLogic presuproyectocuentaLogic= new PresuProyectoCuentaLogic(connexion);
					presuproyectocuenta.setid_presu_proyecto(presuproyecto.getId());
					PresuProyectoCuentaDataAccess.save(presuproyectocuenta,connexion);
					presuproyectocuentaLogic.deepSave(presuproyectocuenta,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(PresuProyecto.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(presuproyecto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PresuProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyecto(presuproyecto);
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
			this.deepLoad(this.presuproyecto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PresuProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyecto(this.presuproyecto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(PresuProyecto.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(presuproyectos!=null) {
				for(PresuProyecto presuproyecto:presuproyectos) {
					this.deepLoad(presuproyecto,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PresuProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyecto(presuproyectos);
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
			if(presuproyectos!=null) {
				for(PresuProyecto presuproyecto:presuproyectos) {
					this.deepLoad(presuproyecto,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PresuProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyecto(presuproyectos);
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
			this.getNewConnexionToDeep(PresuProyecto.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(presuproyecto,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(PresuProyecto.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(presuproyectos!=null) {
				for(PresuProyecto presuproyecto:presuproyectos) {
					this.deepSave(presuproyecto,isDeep,deepLoadType,clases);
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
			if(presuproyectos!=null) {
				for(PresuProyecto presuproyecto:presuproyectos) {
					this.deepSave(presuproyecto,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getPresuProyectosBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",PresuProyectoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			PresuProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presuproyectos=presuproyectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyecto(this.presuproyectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresuProyectosBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",PresuProyectoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			PresuProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presuproyectos=presuproyectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyecto(this.presuproyectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresuProyectosBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",PresuProyectoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			PresuProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presuproyectos=presuproyectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyecto(this.presuproyectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresuProyectosBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",PresuProyectoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			PresuProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presuproyectos=presuproyectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyecto(this.presuproyectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresuProyectosFK_IdCentroCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,PresuProyectoConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			PresuProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presuproyectos=presuproyectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyecto(this.presuproyectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresuProyectosFK_IdCentroCosto(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,PresuProyectoConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			PresuProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presuproyectos=presuproyectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyecto(this.presuproyectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresuProyectosFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,PresuProyectoConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			PresuProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presuproyectos=presuproyectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyecto(this.presuproyectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresuProyectosFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,PresuProyectoConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			PresuProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presuproyectos=presuproyectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyecto(this.presuproyectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresuProyectosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PresuProyectoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PresuProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presuproyectos=presuproyectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyecto(this.presuproyectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresuProyectosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PresuProyectoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PresuProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presuproyectos=presuproyectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyecto(this.presuproyectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresuProyectosFK_IdPresuEstadoWithConnection(String sFinalQuery,Pagination pagination,Long id_presu_estado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPresuEstado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPresuEstado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_presu_estado,PresuProyectoConstantesFunciones.IDPRESUESTADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPresuEstado);

			PresuProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPresuEstado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presuproyectos=presuproyectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyecto(this.presuproyectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresuProyectosFK_IdPresuEstado(String sFinalQuery,Pagination pagination,Long id_presu_estado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPresuEstado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPresuEstado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_presu_estado,PresuProyectoConstantesFunciones.IDPRESUESTADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPresuEstado);

			PresuProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPresuEstado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presuproyectos=presuproyectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyecto(this.presuproyectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresuProyectosFK_IdPresuTipoProyectoWithConnection(String sFinalQuery,Pagination pagination,Long id_presu_tipo_proyecto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPresuTipoProyecto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPresuTipoProyecto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_presu_tipo_proyecto,PresuProyectoConstantesFunciones.IDPRESUTIPOPROYECTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPresuTipoProyecto);

			PresuProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPresuTipoProyecto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presuproyectos=presuproyectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyecto(this.presuproyectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresuProyectosFK_IdPresuTipoProyecto(String sFinalQuery,Pagination pagination,Long id_presu_tipo_proyecto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPresuTipoProyecto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPresuTipoProyecto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_presu_tipo_proyecto,PresuProyectoConstantesFunciones.IDPRESUTIPOPROYECTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPresuTipoProyecto);

			PresuProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPresuTipoProyecto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presuproyectos=presuproyectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyecto(this.presuproyectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresuProyectosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuProyecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,PresuProyectoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			PresuProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presuproyectos=presuproyectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyecto(this.presuproyectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresuProyectosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,PresuProyectoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			PresuProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presuproyectos=presuproyectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuProyecto(this.presuproyectos);
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
			if(PresuProyectoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PresuProyectoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,PresuProyecto presuproyecto,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PresuProyectoConstantesFunciones.ISCONAUDITORIA) {
				if(presuproyecto.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PresuProyectoDataAccess.TABLENAME, presuproyecto.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PresuProyectoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PresuProyectoLogic.registrarAuditoriaDetallesPresuProyecto(connexion,presuproyecto,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(presuproyecto.getIsDeleted()) {
					/*if(!presuproyecto.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PresuProyectoDataAccess.TABLENAME, presuproyecto.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////PresuProyectoLogic.registrarAuditoriaDetallesPresuProyecto(connexion,presuproyecto,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PresuProyectoDataAccess.TABLENAME, presuproyecto.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(presuproyecto.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PresuProyectoDataAccess.TABLENAME, presuproyecto.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PresuProyectoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PresuProyectoLogic.registrarAuditoriaDetallesPresuProyecto(connexion,presuproyecto,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPresuProyecto(Connexion connexion,PresuProyecto presuproyecto)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(presuproyecto.getIsNew()||!presuproyecto.getid_empresa().equals(presuproyecto.getPresuProyectoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presuproyecto.getPresuProyectoOriginal().getid_empresa()!=null)
				{
					strValorActual=presuproyecto.getPresuProyectoOriginal().getid_empresa().toString();
				}
				if(presuproyecto.getid_empresa()!=null)
				{
					strValorNuevo=presuproyecto.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuProyectoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(presuproyecto.getIsNew()||!presuproyecto.getid_sucursal().equals(presuproyecto.getPresuProyectoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presuproyecto.getPresuProyectoOriginal().getid_sucursal()!=null)
				{
					strValorActual=presuproyecto.getPresuProyectoOriginal().getid_sucursal().toString();
				}
				if(presuproyecto.getid_sucursal()!=null)
				{
					strValorNuevo=presuproyecto.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuProyectoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(presuproyecto.getIsNew()||!presuproyecto.getid_ejercicio().equals(presuproyecto.getPresuProyectoOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presuproyecto.getPresuProyectoOriginal().getid_ejercicio()!=null)
				{
					strValorActual=presuproyecto.getPresuProyectoOriginal().getid_ejercicio().toString();
				}
				if(presuproyecto.getid_ejercicio()!=null)
				{
					strValorNuevo=presuproyecto.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuProyectoConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(presuproyecto.getIsNew()||!presuproyecto.getcodigo().equals(presuproyecto.getPresuProyectoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presuproyecto.getPresuProyectoOriginal().getcodigo()!=null)
				{
					strValorActual=presuproyecto.getPresuProyectoOriginal().getcodigo();
				}
				if(presuproyecto.getcodigo()!=null)
				{
					strValorNuevo=presuproyecto.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuProyectoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(presuproyecto.getIsNew()||!presuproyecto.getnombre().equals(presuproyecto.getPresuProyectoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presuproyecto.getPresuProyectoOriginal().getnombre()!=null)
				{
					strValorActual=presuproyecto.getPresuProyectoOriginal().getnombre();
				}
				if(presuproyecto.getnombre()!=null)
				{
					strValorNuevo=presuproyecto.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuProyectoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(presuproyecto.getIsNew()||!presuproyecto.getid_presu_tipo_proyecto().equals(presuproyecto.getPresuProyectoOriginal().getid_presu_tipo_proyecto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presuproyecto.getPresuProyectoOriginal().getid_presu_tipo_proyecto()!=null)
				{
					strValorActual=presuproyecto.getPresuProyectoOriginal().getid_presu_tipo_proyecto().toString();
				}
				if(presuproyecto.getid_presu_tipo_proyecto()!=null)
				{
					strValorNuevo=presuproyecto.getid_presu_tipo_proyecto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuProyectoConstantesFunciones.IDPRESUTIPOPROYECTO,strValorActual,strValorNuevo);
			}	
			
			if(presuproyecto.getIsNew()||!presuproyecto.getid_centro_costo().equals(presuproyecto.getPresuProyectoOriginal().getid_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presuproyecto.getPresuProyectoOriginal().getid_centro_costo()!=null)
				{
					strValorActual=presuproyecto.getPresuProyectoOriginal().getid_centro_costo().toString();
				}
				if(presuproyecto.getid_centro_costo()!=null)
				{
					strValorNuevo=presuproyecto.getid_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuProyectoConstantesFunciones.IDCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(presuproyecto.getIsNew()||!presuproyecto.getfecha().equals(presuproyecto.getPresuProyectoOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presuproyecto.getPresuProyectoOriginal().getfecha()!=null)
				{
					strValorActual=presuproyecto.getPresuProyectoOriginal().getfecha().toString();
				}
				if(presuproyecto.getfecha()!=null)
				{
					strValorNuevo=presuproyecto.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuProyectoConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(presuproyecto.getIsNew()||!presuproyecto.getvalor().equals(presuproyecto.getPresuProyectoOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presuproyecto.getPresuProyectoOriginal().getvalor()!=null)
				{
					strValorActual=presuproyecto.getPresuProyectoOriginal().getvalor().toString();
				}
				if(presuproyecto.getvalor()!=null)
				{
					strValorNuevo=presuproyecto.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuProyectoConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
			
			if(presuproyecto.getIsNew()||!presuproyecto.getid_presu_estado().equals(presuproyecto.getPresuProyectoOriginal().getid_presu_estado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presuproyecto.getPresuProyectoOriginal().getid_presu_estado()!=null)
				{
					strValorActual=presuproyecto.getPresuProyectoOriginal().getid_presu_estado().toString();
				}
				if(presuproyecto.getid_presu_estado()!=null)
				{
					strValorNuevo=presuproyecto.getid_presu_estado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuProyectoConstantesFunciones.IDPRESUESTADO,strValorActual,strValorNuevo);
			}	
			
			if(presuproyecto.getIsNew()||!presuproyecto.getdescripcion().equals(presuproyecto.getPresuProyectoOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presuproyecto.getPresuProyectoOriginal().getdescripcion()!=null)
				{
					strValorActual=presuproyecto.getPresuProyectoOriginal().getdescripcion();
				}
				if(presuproyecto.getdescripcion()!=null)
				{
					strValorNuevo=presuproyecto.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuProyectoConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void savePresuProyectoRelacionesWithConnection(PresuProyecto presuproyecto,List<PresuTransferencia> presutransferencias,List<PresuProyectoCuenta> presuproyectocuentas) throws Exception {

		if(!presuproyecto.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePresuProyectoRelacionesBase(presuproyecto,presutransferencias,presuproyectocuentas,true);
		}
	}

	public void savePresuProyectoRelaciones(PresuProyecto presuproyecto,List<PresuTransferencia> presutransferencias,List<PresuProyectoCuenta> presuproyectocuentas)throws Exception {

		if(!presuproyecto.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePresuProyectoRelacionesBase(presuproyecto,presutransferencias,presuproyectocuentas,false);
		}
	}

	public void savePresuProyectoRelacionesBase(PresuProyecto presuproyecto,List<PresuTransferencia> presutransferencias,List<PresuProyectoCuenta> presuproyectocuentas,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("PresuProyecto-saveRelacionesWithConnection");}
	
			presuproyecto.setPresuTransferencias(presutransferencias);
			presuproyecto.setPresuProyectoCuentas(presuproyectocuentas);

			this.setPresuProyecto(presuproyecto);

			if(PresuProyectoLogicAdditional.validarSaveRelaciones(presuproyecto,this)) {

				PresuProyectoLogicAdditional.updateRelacionesToSave(presuproyecto,this);

				if((presuproyecto.getIsNew()||presuproyecto.getIsChanged())&&!presuproyecto.getIsDeleted()) {
					this.savePresuProyecto();
					this.savePresuProyectoRelacionesDetalles(presutransferencias,presuproyectocuentas);

				} else if(presuproyecto.getIsDeleted()) {
					this.savePresuProyectoRelacionesDetalles(presutransferencias,presuproyectocuentas);
					this.savePresuProyecto();
				}

				PresuProyectoLogicAdditional.updateRelacionesToSaveAfter(presuproyecto,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			PresuTransferenciaConstantesFunciones.InicializarGeneralEntityAuxiliaresPresuTransferencias(presutransferencias,true,true);
			PresuProyectoCuentaConstantesFunciones.InicializarGeneralEntityAuxiliaresPresuProyectoCuentas(presuproyectocuentas,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void savePresuProyectoRelacionesDetalles(List<PresuTransferencia> presutransferencias,List<PresuProyectoCuenta> presuproyectocuentas)throws Exception {
		try {
	

			Long idPresuProyectoActual=this.getPresuProyecto().getId();

			PresuTransferenciaLogic presutransferenciaLogic_Desde_PresuProyecto=new PresuTransferenciaLogic();
			presutransferenciaLogic_Desde_PresuProyecto.setPresuTransferencias(presutransferencias);

			presutransferenciaLogic_Desde_PresuProyecto.setConnexion(this.getConnexion());
			presutransferenciaLogic_Desde_PresuProyecto.setDatosCliente(this.datosCliente);

			for(PresuTransferencia presutransferencia_Desde_PresuProyecto:presutransferenciaLogic_Desde_PresuProyecto.getPresuTransferencias()) {
				presutransferencia_Desde_PresuProyecto.setid_presu_proyecto(idPresuProyectoActual);
			}

			presutransferenciaLogic_Desde_PresuProyecto.savePresuTransferencias();

			PresuProyectoCuentaLogic presuproyectocuentaLogic_Desde_PresuProyecto=new PresuProyectoCuentaLogic();
			presuproyectocuentaLogic_Desde_PresuProyecto.setPresuProyectoCuentas(presuproyectocuentas);

			presuproyectocuentaLogic_Desde_PresuProyecto.setConnexion(this.getConnexion());
			presuproyectocuentaLogic_Desde_PresuProyecto.setDatosCliente(this.datosCliente);

			for(PresuProyectoCuenta presuproyectocuenta_Desde_PresuProyecto:presuproyectocuentaLogic_Desde_PresuProyecto.getPresuProyectoCuentas()) {
				presuproyectocuenta_Desde_PresuProyecto.setid_presu_proyecto(idPresuProyectoActual);

				presuproyectocuentaLogic_Desde_PresuProyecto.setPresuProyectoCuenta(presuproyectocuenta_Desde_PresuProyecto);
				presuproyectocuentaLogic_Desde_PresuProyecto.savePresuProyectoCuenta();

				Long idPresuProyectoCuentaActual=presuproyectocuenta_Desde_PresuProyecto.getId();

				PresuAsignacionLogic presuasignacionLogic_Desde_PresuProyectoCuenta=new PresuAsignacionLogic();

				if(presuproyectocuenta_Desde_PresuProyecto.getPresuAsignacions()==null){
					presuproyectocuenta_Desde_PresuProyecto.setPresuAsignacions(new ArrayList<PresuAsignacion>());
				}

				presuasignacionLogic_Desde_PresuProyectoCuenta.setPresuAsignacions(presuproyectocuenta_Desde_PresuProyecto.getPresuAsignacions());

				presuasignacionLogic_Desde_PresuProyectoCuenta.setConnexion(this.getConnexion());
				presuasignacionLogic_Desde_PresuProyectoCuenta.setDatosCliente(this.datosCliente);

				for(PresuAsignacion presuasignacion_Desde_PresuProyectoCuenta:presuasignacionLogic_Desde_PresuProyectoCuenta.getPresuAsignacions()) {
					presuasignacion_Desde_PresuProyectoCuenta.setid_presu_proyecto_cuenta(idPresuProyectoCuentaActual);
				}

				presuasignacionLogic_Desde_PresuProyectoCuenta.savePresuAsignacions();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPresuProyecto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PresuProyectoConstantesFunciones.getClassesForeignKeysOfPresuProyecto(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresuProyecto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PresuProyectoConstantesFunciones.getClassesRelationshipsOfPresuProyecto(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

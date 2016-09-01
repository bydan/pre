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
import com.bydan.erp.contabilidad.util.PresuTipoCuentaProyectoConstantesFunciones;
import com.bydan.erp.contabilidad.util.PresuTipoCuentaProyectoParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.PresuTipoCuentaProyectoParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.PresuTipoCuentaProyecto;
import com.bydan.erp.contabilidad.business.logic.PresuTipoCuentaProyectoLogicAdditional;
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
public class PresuTipoCuentaProyectoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PresuTipoCuentaProyectoLogic.class);
	
	protected PresuTipoCuentaProyectoDataAccess presutipocuentaproyectoDataAccess; 	
	protected PresuTipoCuentaProyecto presutipocuentaproyecto;
	protected List<PresuTipoCuentaProyecto> presutipocuentaproyectos;
	protected Object presutipocuentaproyectoObject;	
	protected List<Object> presutipocuentaproyectosObject;
	
	public static ClassValidator<PresuTipoCuentaProyecto> presutipocuentaproyectoValidator = new ClassValidator<PresuTipoCuentaProyecto>(PresuTipoCuentaProyecto.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PresuTipoCuentaProyectoLogicAdditional presutipocuentaproyectoLogicAdditional=null;
	
	public PresuTipoCuentaProyectoLogicAdditional getPresuTipoCuentaProyectoLogicAdditional() {
		return this.presutipocuentaproyectoLogicAdditional;
	}
	
	public void setPresuTipoCuentaProyectoLogicAdditional(PresuTipoCuentaProyectoLogicAdditional presutipocuentaproyectoLogicAdditional) {
		try {
			this.presutipocuentaproyectoLogicAdditional=presutipocuentaproyectoLogicAdditional;
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
	
	
	
	
	public  PresuTipoCuentaProyectoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.presutipocuentaproyectoDataAccess = new PresuTipoCuentaProyectoDataAccess();
			
			this.presutipocuentaproyectos= new ArrayList<PresuTipoCuentaProyecto>();
			this.presutipocuentaproyecto= new PresuTipoCuentaProyecto();
			
			this.presutipocuentaproyectoObject=new Object();
			this.presutipocuentaproyectosObject=new ArrayList<Object>();
				
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
			
			this.presutipocuentaproyectoDataAccess.setConnexionType(this.connexionType);
			this.presutipocuentaproyectoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PresuTipoCuentaProyectoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.presutipocuentaproyectoDataAccess = new PresuTipoCuentaProyectoDataAccess();
			this.presutipocuentaproyectos= new ArrayList<PresuTipoCuentaProyecto>();
			this.presutipocuentaproyecto= new PresuTipoCuentaProyecto();
			this.presutipocuentaproyectoObject=new Object();
			this.presutipocuentaproyectosObject=new ArrayList<Object>();
			
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
			
			this.presutipocuentaproyectoDataAccess.setConnexionType(this.connexionType);
			this.presutipocuentaproyectoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PresuTipoCuentaProyecto getPresuTipoCuentaProyecto() throws Exception {	
		PresuTipoCuentaProyectoLogicAdditional.checkPresuTipoCuentaProyectoToGet(presutipocuentaproyecto,this.datosCliente,this.arrDatoGeneral);
		PresuTipoCuentaProyectoLogicAdditional.updatePresuTipoCuentaProyectoToGet(presutipocuentaproyecto,this.arrDatoGeneral);
		
		return presutipocuentaproyecto;
	}
		
	public void setPresuTipoCuentaProyecto(PresuTipoCuentaProyecto newPresuTipoCuentaProyecto) {
		this.presutipocuentaproyecto = newPresuTipoCuentaProyecto;
	}
	
	public PresuTipoCuentaProyectoDataAccess getPresuTipoCuentaProyectoDataAccess() {
		return presutipocuentaproyectoDataAccess;
	}
	
	public void setPresuTipoCuentaProyectoDataAccess(PresuTipoCuentaProyectoDataAccess newpresutipocuentaproyectoDataAccess) {
		this.presutipocuentaproyectoDataAccess = newpresutipocuentaproyectoDataAccess;
	}
	
	public List<PresuTipoCuentaProyecto> getPresuTipoCuentaProyectos() throws Exception {		
		this.quitarPresuTipoCuentaProyectosNulos();
		
		PresuTipoCuentaProyectoLogicAdditional.checkPresuTipoCuentaProyectoToGets(presutipocuentaproyectos,this.datosCliente,this.arrDatoGeneral);
		
		for (PresuTipoCuentaProyecto presutipocuentaproyectoLocal: presutipocuentaproyectos ) {
			PresuTipoCuentaProyectoLogicAdditional.updatePresuTipoCuentaProyectoToGet(presutipocuentaproyectoLocal,this.arrDatoGeneral);
		}
		
		return presutipocuentaproyectos;
	}
	
	public void setPresuTipoCuentaProyectos(List<PresuTipoCuentaProyecto> newPresuTipoCuentaProyectos) {
		this.presutipocuentaproyectos = newPresuTipoCuentaProyectos;
	}
	
	public Object getPresuTipoCuentaProyectoObject() {	
		this.presutipocuentaproyectoObject=this.presutipocuentaproyectoDataAccess.getEntityObject();
		return this.presutipocuentaproyectoObject;
	}
		
	public void setPresuTipoCuentaProyectoObject(Object newPresuTipoCuentaProyectoObject) {
		this.presutipocuentaproyectoObject = newPresuTipoCuentaProyectoObject;
	}
	
	public List<Object> getPresuTipoCuentaProyectosObject() {		
		this.presutipocuentaproyectosObject=this.presutipocuentaproyectoDataAccess.getEntitiesObject();
		return this.presutipocuentaproyectosObject;
	}
		
	public void setPresuTipoCuentaProyectosObject(List<Object> newPresuTipoCuentaProyectosObject) {
		this.presutipocuentaproyectosObject = newPresuTipoCuentaProyectosObject;
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
		
		if(this.presutipocuentaproyectoDataAccess!=null) {
			this.presutipocuentaproyectoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoCuentaProyecto.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			presutipocuentaproyectoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			presutipocuentaproyectoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		presutipocuentaproyecto = new  PresuTipoCuentaProyecto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoCuentaProyecto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			presutipocuentaproyecto=presutipocuentaproyectoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presutipocuentaproyecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresuTipoCuentaProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoCuentaProyecto(this.presutipocuentaproyecto);
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
		presutipocuentaproyecto = new  PresuTipoCuentaProyecto();
		  		  
        try {
			
			presutipocuentaproyecto=presutipocuentaproyectoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presutipocuentaproyecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresuTipoCuentaProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoCuentaProyecto(this.presutipocuentaproyecto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		presutipocuentaproyecto = new  PresuTipoCuentaProyecto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoCuentaProyecto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			presutipocuentaproyecto=presutipocuentaproyectoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presutipocuentaproyecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresuTipoCuentaProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoCuentaProyecto(this.presutipocuentaproyecto);
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
		presutipocuentaproyecto = new  PresuTipoCuentaProyecto();
		  		  
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
		presutipocuentaproyecto = new  PresuTipoCuentaProyecto();
		  		  
        try {
			
			presutipocuentaproyecto=presutipocuentaproyectoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presutipocuentaproyecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresuTipoCuentaProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoCuentaProyecto(this.presutipocuentaproyecto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		presutipocuentaproyecto = new  PresuTipoCuentaProyecto();
		  		  
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
		presutipocuentaproyecto = new  PresuTipoCuentaProyecto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoCuentaProyecto.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =presutipocuentaproyectoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		presutipocuentaproyecto = new  PresuTipoCuentaProyecto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=presutipocuentaproyectoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		presutipocuentaproyecto = new  PresuTipoCuentaProyecto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoCuentaProyecto.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =presutipocuentaproyectoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		presutipocuentaproyecto = new  PresuTipoCuentaProyecto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=presutipocuentaproyectoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		presutipocuentaproyecto = new  PresuTipoCuentaProyecto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoCuentaProyecto.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =presutipocuentaproyectoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		presutipocuentaproyecto = new  PresuTipoCuentaProyecto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=presutipocuentaproyectoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		presutipocuentaproyectos = new  ArrayList<PresuTipoCuentaProyecto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoCuentaProyecto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PresuTipoCuentaProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presutipocuentaproyectos=presutipocuentaproyectoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresuTipoCuentaProyecto(presutipocuentaproyectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuTipoCuentaProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoCuentaProyecto(this.presutipocuentaproyectos);
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
		presutipocuentaproyectos = new  ArrayList<PresuTipoCuentaProyecto>();
		  		  
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
		presutipocuentaproyectos = new  ArrayList<PresuTipoCuentaProyecto>();
		  		  
        try {			
			PresuTipoCuentaProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presutipocuentaproyectos=presutipocuentaproyectoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPresuTipoCuentaProyecto(presutipocuentaproyectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuTipoCuentaProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoCuentaProyecto(this.presutipocuentaproyectos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		presutipocuentaproyectos = new  ArrayList<PresuTipoCuentaProyecto>();
		  		  
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
		presutipocuentaproyectos = new  ArrayList<PresuTipoCuentaProyecto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoCuentaProyecto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PresuTipoCuentaProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presutipocuentaproyectos=presutipocuentaproyectoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresuTipoCuentaProyecto(presutipocuentaproyectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuTipoCuentaProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoCuentaProyecto(this.presutipocuentaproyectos);
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
		presutipocuentaproyectos = new  ArrayList<PresuTipoCuentaProyecto>();
		  		  
        try {
			PresuTipoCuentaProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presutipocuentaproyectos=presutipocuentaproyectoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresuTipoCuentaProyecto(presutipocuentaproyectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuTipoCuentaProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoCuentaProyecto(this.presutipocuentaproyectos);
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
		presutipocuentaproyectos = new  ArrayList<PresuTipoCuentaProyecto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoCuentaProyecto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresuTipoCuentaProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presutipocuentaproyectos=presutipocuentaproyectoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresuTipoCuentaProyecto(presutipocuentaproyectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuTipoCuentaProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoCuentaProyecto(this.presutipocuentaproyectos);
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
		presutipocuentaproyectos = new  ArrayList<PresuTipoCuentaProyecto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresuTipoCuentaProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presutipocuentaproyectos=presutipocuentaproyectoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresuTipoCuentaProyecto(presutipocuentaproyectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuTipoCuentaProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoCuentaProyecto(this.presutipocuentaproyectos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		presutipocuentaproyecto = new  PresuTipoCuentaProyecto();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoCuentaProyecto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresuTipoCuentaProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presutipocuentaproyecto=presutipocuentaproyectoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresuTipoCuentaProyecto(presutipocuentaproyecto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuTipoCuentaProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoCuentaProyecto(this.presutipocuentaproyecto);
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
		presutipocuentaproyecto = new  PresuTipoCuentaProyecto();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresuTipoCuentaProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presutipocuentaproyecto=presutipocuentaproyectoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresuTipoCuentaProyecto(presutipocuentaproyecto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuTipoCuentaProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoCuentaProyecto(this.presutipocuentaproyecto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		presutipocuentaproyectos = new  ArrayList<PresuTipoCuentaProyecto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoCuentaProyecto.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			PresuTipoCuentaProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presutipocuentaproyectos=presutipocuentaproyectoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresuTipoCuentaProyecto(presutipocuentaproyectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuTipoCuentaProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoCuentaProyecto(this.presutipocuentaproyectos);
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
		presutipocuentaproyectos = new  ArrayList<PresuTipoCuentaProyecto>();
		  		  
        try {
			PresuTipoCuentaProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presutipocuentaproyectos=presutipocuentaproyectoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresuTipoCuentaProyecto(presutipocuentaproyectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuTipoCuentaProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoCuentaProyecto(this.presutipocuentaproyectos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosPresuTipoCuentaProyectosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		presutipocuentaproyectos = new  ArrayList<PresuTipoCuentaProyecto>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoCuentaProyecto.class.getSimpleName()+"-getTodosPresuTipoCuentaProyectosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresuTipoCuentaProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presutipocuentaproyectos=presutipocuentaproyectoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPresuTipoCuentaProyecto(presutipocuentaproyectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuTipoCuentaProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoCuentaProyecto(this.presutipocuentaproyectos);
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
	
	public  void  getTodosPresuTipoCuentaProyectos(String sFinalQuery,Pagination pagination)throws Exception {
		presutipocuentaproyectos = new  ArrayList<PresuTipoCuentaProyecto>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresuTipoCuentaProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presutipocuentaproyectos=presutipocuentaproyectoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPresuTipoCuentaProyecto(presutipocuentaproyectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuTipoCuentaProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoCuentaProyecto(this.presutipocuentaproyectos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPresuTipoCuentaProyecto(PresuTipoCuentaProyecto presutipocuentaproyecto) throws Exception {
		Boolean estaValidado=false;
		
		if(presutipocuentaproyecto.getIsNew() || presutipocuentaproyecto.getIsChanged()) { 
			this.invalidValues = presutipocuentaproyectoValidator.getInvalidValues(presutipocuentaproyecto);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(presutipocuentaproyecto);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPresuTipoCuentaProyecto(List<PresuTipoCuentaProyecto> PresuTipoCuentaProyectos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(PresuTipoCuentaProyecto presutipocuentaproyectoLocal:presutipocuentaproyectos) {				
			estaValidadoObjeto=this.validarGuardarPresuTipoCuentaProyecto(presutipocuentaproyectoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPresuTipoCuentaProyecto(List<PresuTipoCuentaProyecto> PresuTipoCuentaProyectos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPresuTipoCuentaProyecto(presutipocuentaproyectos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPresuTipoCuentaProyecto(PresuTipoCuentaProyecto PresuTipoCuentaProyecto) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPresuTipoCuentaProyecto(presutipocuentaproyecto)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(PresuTipoCuentaProyecto presutipocuentaproyecto) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+presutipocuentaproyecto.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PresuTipoCuentaProyectoConstantesFunciones.getPresuTipoCuentaProyectoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"presutipocuentaproyecto","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PresuTipoCuentaProyectoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PresuTipoCuentaProyectoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePresuTipoCuentaProyectoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoCuentaProyecto.class.getSimpleName()+"-savePresuTipoCuentaProyectoWithConnection");connexion.begin();			
			
			PresuTipoCuentaProyectoLogicAdditional.checkPresuTipoCuentaProyectoToSave(this.presutipocuentaproyecto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PresuTipoCuentaProyectoLogicAdditional.updatePresuTipoCuentaProyectoToSave(this.presutipocuentaproyecto,this.arrDatoGeneral);
			
			PresuTipoCuentaProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.presutipocuentaproyecto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPresuTipoCuentaProyecto();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPresuTipoCuentaProyecto(this.presutipocuentaproyecto)) {
				PresuTipoCuentaProyectoDataAccess.save(this.presutipocuentaproyecto, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.presutipocuentaproyecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PresuTipoCuentaProyectoLogicAdditional.checkPresuTipoCuentaProyectoToSaveAfter(this.presutipocuentaproyecto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPresuTipoCuentaProyecto();
			
			connexion.commit();			
			
			if(this.presutipocuentaproyecto.getIsDeleted()) {
				this.presutipocuentaproyecto=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePresuTipoCuentaProyecto()throws Exception {	
		try {	
			
			PresuTipoCuentaProyectoLogicAdditional.checkPresuTipoCuentaProyectoToSave(this.presutipocuentaproyecto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PresuTipoCuentaProyectoLogicAdditional.updatePresuTipoCuentaProyectoToSave(this.presutipocuentaproyecto,this.arrDatoGeneral);
			
			PresuTipoCuentaProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.presutipocuentaproyecto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPresuTipoCuentaProyecto(this.presutipocuentaproyecto)) {			
				PresuTipoCuentaProyectoDataAccess.save(this.presutipocuentaproyecto, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.presutipocuentaproyecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PresuTipoCuentaProyectoLogicAdditional.checkPresuTipoCuentaProyectoToSaveAfter(this.presutipocuentaproyecto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.presutipocuentaproyecto.getIsDeleted()) {
				this.presutipocuentaproyecto=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePresuTipoCuentaProyectosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoCuentaProyecto.class.getSimpleName()+"-savePresuTipoCuentaProyectosWithConnection");connexion.begin();			
			
			PresuTipoCuentaProyectoLogicAdditional.checkPresuTipoCuentaProyectoToSaves(presutipocuentaproyectos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPresuTipoCuentaProyectos();
			
			Boolean validadoTodosPresuTipoCuentaProyecto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PresuTipoCuentaProyecto presutipocuentaproyectoLocal:presutipocuentaproyectos) {		
				if(presutipocuentaproyectoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PresuTipoCuentaProyectoLogicAdditional.updatePresuTipoCuentaProyectoToSave(presutipocuentaproyectoLocal,this.arrDatoGeneral);
	        	
				PresuTipoCuentaProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),presutipocuentaproyectoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPresuTipoCuentaProyecto(presutipocuentaproyectoLocal)) {
					PresuTipoCuentaProyectoDataAccess.save(presutipocuentaproyectoLocal, connexion);				
				} else {
					validadoTodosPresuTipoCuentaProyecto=false;
				}
			}
			
			if(!validadoTodosPresuTipoCuentaProyecto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PresuTipoCuentaProyectoLogicAdditional.checkPresuTipoCuentaProyectoToSavesAfter(presutipocuentaproyectos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPresuTipoCuentaProyectos();
			
			connexion.commit();		
			
			this.quitarPresuTipoCuentaProyectosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePresuTipoCuentaProyectos()throws Exception {				
		 try {	
			PresuTipoCuentaProyectoLogicAdditional.checkPresuTipoCuentaProyectoToSaves(presutipocuentaproyectos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPresuTipoCuentaProyecto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PresuTipoCuentaProyecto presutipocuentaproyectoLocal:presutipocuentaproyectos) {				
				if(presutipocuentaproyectoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PresuTipoCuentaProyectoLogicAdditional.updatePresuTipoCuentaProyectoToSave(presutipocuentaproyectoLocal,this.arrDatoGeneral);
	        	
				PresuTipoCuentaProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),presutipocuentaproyectoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPresuTipoCuentaProyecto(presutipocuentaproyectoLocal)) {				
					PresuTipoCuentaProyectoDataAccess.save(presutipocuentaproyectoLocal, connexion);				
				} else {
					validadoTodosPresuTipoCuentaProyecto=false;
				}
			}
			
			if(!validadoTodosPresuTipoCuentaProyecto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PresuTipoCuentaProyectoLogicAdditional.checkPresuTipoCuentaProyectoToSavesAfter(presutipocuentaproyectos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPresuTipoCuentaProyectosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PresuTipoCuentaProyectoParameterReturnGeneral procesarAccionPresuTipoCuentaProyectos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PresuTipoCuentaProyecto> presutipocuentaproyectos,PresuTipoCuentaProyectoParameterReturnGeneral presutipocuentaproyectoParameterGeneral)throws Exception {
		 try {	
			PresuTipoCuentaProyectoParameterReturnGeneral presutipocuentaproyectoReturnGeneral=new PresuTipoCuentaProyectoParameterReturnGeneral();
	
			PresuTipoCuentaProyectoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,presutipocuentaproyectos,presutipocuentaproyectoParameterGeneral,presutipocuentaproyectoReturnGeneral);
			
			return presutipocuentaproyectoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PresuTipoCuentaProyectoParameterReturnGeneral procesarAccionPresuTipoCuentaProyectosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PresuTipoCuentaProyecto> presutipocuentaproyectos,PresuTipoCuentaProyectoParameterReturnGeneral presutipocuentaproyectoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoCuentaProyecto.class.getSimpleName()+"-procesarAccionPresuTipoCuentaProyectosWithConnection");connexion.begin();			
			
			PresuTipoCuentaProyectoParameterReturnGeneral presutipocuentaproyectoReturnGeneral=new PresuTipoCuentaProyectoParameterReturnGeneral();
	
			PresuTipoCuentaProyectoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,presutipocuentaproyectos,presutipocuentaproyectoParameterGeneral,presutipocuentaproyectoReturnGeneral);
			
			this.connexion.commit();
			
			return presutipocuentaproyectoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PresuTipoCuentaProyectoParameterReturnGeneral procesarEventosPresuTipoCuentaProyectos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PresuTipoCuentaProyecto> presutipocuentaproyectos,PresuTipoCuentaProyecto presutipocuentaproyecto,PresuTipoCuentaProyectoParameterReturnGeneral presutipocuentaproyectoParameterGeneral,Boolean isEsNuevoPresuTipoCuentaProyecto,ArrayList<Classe> clases)throws Exception {
		 try {	
			PresuTipoCuentaProyectoParameterReturnGeneral presutipocuentaproyectoReturnGeneral=new PresuTipoCuentaProyectoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				presutipocuentaproyectoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PresuTipoCuentaProyectoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,presutipocuentaproyectos,presutipocuentaproyecto,presutipocuentaproyectoParameterGeneral,presutipocuentaproyectoReturnGeneral,isEsNuevoPresuTipoCuentaProyecto,clases);
			
			return presutipocuentaproyectoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PresuTipoCuentaProyectoParameterReturnGeneral procesarEventosPresuTipoCuentaProyectosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PresuTipoCuentaProyecto> presutipocuentaproyectos,PresuTipoCuentaProyecto presutipocuentaproyecto,PresuTipoCuentaProyectoParameterReturnGeneral presutipocuentaproyectoParameterGeneral,Boolean isEsNuevoPresuTipoCuentaProyecto,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoCuentaProyecto.class.getSimpleName()+"-procesarEventosPresuTipoCuentaProyectosWithConnection");connexion.begin();			
			
			PresuTipoCuentaProyectoParameterReturnGeneral presutipocuentaproyectoReturnGeneral=new PresuTipoCuentaProyectoParameterReturnGeneral();
	
			presutipocuentaproyectoReturnGeneral.setPresuTipoCuentaProyecto(presutipocuentaproyecto);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				presutipocuentaproyectoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PresuTipoCuentaProyectoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,presutipocuentaproyectos,presutipocuentaproyecto,presutipocuentaproyectoParameterGeneral,presutipocuentaproyectoReturnGeneral,isEsNuevoPresuTipoCuentaProyecto,clases);
			
			this.connexion.commit();
			
			return presutipocuentaproyectoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PresuTipoCuentaProyectoParameterReturnGeneral procesarImportacionPresuTipoCuentaProyectosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PresuTipoCuentaProyectoParameterReturnGeneral presutipocuentaproyectoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoCuentaProyecto.class.getSimpleName()+"-procesarImportacionPresuTipoCuentaProyectosWithConnection");connexion.begin();			
			
			PresuTipoCuentaProyectoParameterReturnGeneral presutipocuentaproyectoReturnGeneral=new PresuTipoCuentaProyectoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.presutipocuentaproyectos=new ArrayList<PresuTipoCuentaProyecto>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.presutipocuentaproyecto=new PresuTipoCuentaProyecto();
				
				
				if(conColumnasBase) {this.presutipocuentaproyecto.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.presutipocuentaproyecto.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.presutipocuentaproyecto.setcodigo(arrColumnas[iColumn++]);
				this.presutipocuentaproyecto.setnombre(arrColumnas[iColumn++]);
				
				this.presutipocuentaproyectos.add(this.presutipocuentaproyecto);
			}
			
			this.savePresuTipoCuentaProyectos();
			
			this.connexion.commit();
			
			presutipocuentaproyectoReturnGeneral.setConRetornoEstaProcesado(true);
			presutipocuentaproyectoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return presutipocuentaproyectoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPresuTipoCuentaProyectosEliminados() throws Exception {				
		
		List<PresuTipoCuentaProyecto> presutipocuentaproyectosAux= new ArrayList<PresuTipoCuentaProyecto>();
		
		for(PresuTipoCuentaProyecto presutipocuentaproyecto:presutipocuentaproyectos) {
			if(!presutipocuentaproyecto.getIsDeleted()) {
				presutipocuentaproyectosAux.add(presutipocuentaproyecto);
			}
		}
		
		presutipocuentaproyectos=presutipocuentaproyectosAux;
	}
	
	public void quitarPresuTipoCuentaProyectosNulos() throws Exception {				
		
		List<PresuTipoCuentaProyecto> presutipocuentaproyectosAux= new ArrayList<PresuTipoCuentaProyecto>();
		
		for(PresuTipoCuentaProyecto presutipocuentaproyecto : this.presutipocuentaproyectos) {
			if(presutipocuentaproyecto==null) {
				presutipocuentaproyectosAux.add(presutipocuentaproyecto);
			}
		}
		
		//this.presutipocuentaproyectos=presutipocuentaproyectosAux;
		
		this.presutipocuentaproyectos.removeAll(presutipocuentaproyectosAux);
	}
	
	public void getSetVersionRowPresuTipoCuentaProyectoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(presutipocuentaproyecto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((presutipocuentaproyecto.getIsDeleted() || (presutipocuentaproyecto.getIsChanged()&&!presutipocuentaproyecto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=presutipocuentaproyectoDataAccess.getSetVersionRowPresuTipoCuentaProyecto(connexion,presutipocuentaproyecto.getId());
				
				if(!presutipocuentaproyecto.getVersionRow().equals(timestamp)) {	
					presutipocuentaproyecto.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				presutipocuentaproyecto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPresuTipoCuentaProyecto()throws Exception {	
		
		if(presutipocuentaproyecto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((presutipocuentaproyecto.getIsDeleted() || (presutipocuentaproyecto.getIsChanged()&&!presutipocuentaproyecto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=presutipocuentaproyectoDataAccess.getSetVersionRowPresuTipoCuentaProyecto(connexion,presutipocuentaproyecto.getId());
			
			try {							
				if(!presutipocuentaproyecto.getVersionRow().equals(timestamp)) {	
					presutipocuentaproyecto.setVersionRow(timestamp);
				}
				
				presutipocuentaproyecto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPresuTipoCuentaProyectosWithConnection()throws Exception {	
		if(presutipocuentaproyectos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(PresuTipoCuentaProyecto presutipocuentaproyectoAux:presutipocuentaproyectos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(presutipocuentaproyectoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(presutipocuentaproyectoAux.getIsDeleted() || (presutipocuentaproyectoAux.getIsChanged()&&!presutipocuentaproyectoAux.getIsNew())) {
						
						timestamp=presutipocuentaproyectoDataAccess.getSetVersionRowPresuTipoCuentaProyecto(connexion,presutipocuentaproyectoAux.getId());
						
						if(!presutipocuentaproyecto.getVersionRow().equals(timestamp)) {	
							presutipocuentaproyectoAux.setVersionRow(timestamp);
						}
								
						presutipocuentaproyectoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPresuTipoCuentaProyectos()throws Exception {	
		if(presutipocuentaproyectos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(PresuTipoCuentaProyecto presutipocuentaproyectoAux:presutipocuentaproyectos) {
					if(presutipocuentaproyectoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(presutipocuentaproyectoAux.getIsDeleted() || (presutipocuentaproyectoAux.getIsChanged()&&!presutipocuentaproyectoAux.getIsNew())) {
						
						timestamp=presutipocuentaproyectoDataAccess.getSetVersionRowPresuTipoCuentaProyecto(connexion,presutipocuentaproyectoAux.getId());
						
						if(!presutipocuentaproyectoAux.getVersionRow().equals(timestamp)) {	
							presutipocuentaproyectoAux.setVersionRow(timestamp);
						}
						
													
						presutipocuentaproyectoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PresuTipoCuentaProyectoParameterReturnGeneral cargarCombosLoteForeignKeyPresuTipoCuentaProyectoWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		PresuTipoCuentaProyectoParameterReturnGeneral  presutipocuentaproyectoReturnGeneral =new PresuTipoCuentaProyectoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoCuentaProyecto.class.getSimpleName()+"-cargarCombosLoteForeignKeyPresuTipoCuentaProyectoWithConnection");connexion.begin();
			
			presutipocuentaproyectoReturnGeneral =new PresuTipoCuentaProyectoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			presutipocuentaproyectoReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return presutipocuentaproyectoReturnGeneral;
	}
	
	public PresuTipoCuentaProyectoParameterReturnGeneral cargarCombosLoteForeignKeyPresuTipoCuentaProyecto(String finalQueryGlobalEmpresa) throws Exception {
		PresuTipoCuentaProyectoParameterReturnGeneral  presutipocuentaproyectoReturnGeneral =new PresuTipoCuentaProyectoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			presutipocuentaproyectoReturnGeneral =new PresuTipoCuentaProyectoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			presutipocuentaproyectoReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return presutipocuentaproyectoReturnGeneral;
	}
	
	
	public void deepLoad(PresuTipoCuentaProyecto presutipocuentaproyecto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PresuTipoCuentaProyectoLogicAdditional.updatePresuTipoCuentaProyectoToGet(presutipocuentaproyecto,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		presutipocuentaproyecto.setEmpresa(presutipocuentaproyectoDataAccess.getEmpresa(connexion,presutipocuentaproyecto));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				presutipocuentaproyecto.setEmpresa(presutipocuentaproyectoDataAccess.getEmpresa(connexion,presutipocuentaproyecto));
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
			presutipocuentaproyecto.setEmpresa(presutipocuentaproyectoDataAccess.getEmpresa(connexion,presutipocuentaproyecto));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		presutipocuentaproyecto.setEmpresa(presutipocuentaproyectoDataAccess.getEmpresa(connexion,presutipocuentaproyecto));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(presutipocuentaproyecto.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				presutipocuentaproyecto.setEmpresa(presutipocuentaproyectoDataAccess.getEmpresa(connexion,presutipocuentaproyecto));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(presutipocuentaproyecto.getEmpresa(),isDeep,deepLoadType,clases);				
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
			presutipocuentaproyecto.setEmpresa(presutipocuentaproyectoDataAccess.getEmpresa(connexion,presutipocuentaproyecto));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(presutipocuentaproyecto.getEmpresa(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(PresuTipoCuentaProyecto presutipocuentaproyecto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			PresuTipoCuentaProyectoLogicAdditional.updatePresuTipoCuentaProyectoToSave(presutipocuentaproyecto,this.arrDatoGeneral);
			
PresuTipoCuentaProyectoDataAccess.save(presutipocuentaproyecto, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(presutipocuentaproyecto.getEmpresa(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(presutipocuentaproyecto.getEmpresa(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(presutipocuentaproyecto.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(presutipocuentaproyecto.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(presutipocuentaproyecto.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(presutipocuentaproyecto.getEmpresa(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(PresuTipoCuentaProyecto.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(presutipocuentaproyecto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PresuTipoCuentaProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoCuentaProyecto(presutipocuentaproyecto);
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
			this.deepLoad(this.presutipocuentaproyecto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PresuTipoCuentaProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoCuentaProyecto(this.presutipocuentaproyecto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(PresuTipoCuentaProyecto.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(presutipocuentaproyectos!=null) {
				for(PresuTipoCuentaProyecto presutipocuentaproyecto:presutipocuentaproyectos) {
					this.deepLoad(presutipocuentaproyecto,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PresuTipoCuentaProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoCuentaProyecto(presutipocuentaproyectos);
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
			if(presutipocuentaproyectos!=null) {
				for(PresuTipoCuentaProyecto presutipocuentaproyecto:presutipocuentaproyectos) {
					this.deepLoad(presutipocuentaproyecto,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PresuTipoCuentaProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoCuentaProyecto(presutipocuentaproyectos);
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
			this.getNewConnexionToDeep(PresuTipoCuentaProyecto.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(presutipocuentaproyecto,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(PresuTipoCuentaProyecto.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(presutipocuentaproyectos!=null) {
				for(PresuTipoCuentaProyecto presutipocuentaproyecto:presutipocuentaproyectos) {
					this.deepSave(presutipocuentaproyecto,isDeep,deepLoadType,clases);
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
			if(presutipocuentaproyectos!=null) {
				for(PresuTipoCuentaProyecto presutipocuentaproyecto:presutipocuentaproyectos) {
					this.deepSave(presutipocuentaproyecto,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getPresuTipoCuentaProyectosBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoCuentaProyecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",PresuTipoCuentaProyectoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			PresuTipoCuentaProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presutipocuentaproyectos=presutipocuentaproyectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuTipoCuentaProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoCuentaProyecto(this.presutipocuentaproyectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresuTipoCuentaProyectosBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",PresuTipoCuentaProyectoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			PresuTipoCuentaProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presutipocuentaproyectos=presutipocuentaproyectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuTipoCuentaProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoCuentaProyecto(this.presutipocuentaproyectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresuTipoCuentaProyectosBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoCuentaProyecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",PresuTipoCuentaProyectoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			PresuTipoCuentaProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presutipocuentaproyectos=presutipocuentaproyectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuTipoCuentaProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoCuentaProyecto(this.presutipocuentaproyectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresuTipoCuentaProyectosBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",PresuTipoCuentaProyectoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			PresuTipoCuentaProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presutipocuentaproyectos=presutipocuentaproyectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuTipoCuentaProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoCuentaProyecto(this.presutipocuentaproyectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresuTipoCuentaProyectosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoCuentaProyecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PresuTipoCuentaProyectoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PresuTipoCuentaProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presutipocuentaproyectos=presutipocuentaproyectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuTipoCuentaProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoCuentaProyecto(this.presutipocuentaproyectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresuTipoCuentaProyectosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PresuTipoCuentaProyectoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PresuTipoCuentaProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presutipocuentaproyectos=presutipocuentaproyectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuTipoCuentaProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoCuentaProyecto(this.presutipocuentaproyectos);
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
			if(PresuTipoCuentaProyectoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PresuTipoCuentaProyectoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,PresuTipoCuentaProyecto presutipocuentaproyecto,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PresuTipoCuentaProyectoConstantesFunciones.ISCONAUDITORIA) {
				if(presutipocuentaproyecto.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PresuTipoCuentaProyectoDataAccess.TABLENAME, presutipocuentaproyecto.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PresuTipoCuentaProyectoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PresuTipoCuentaProyectoLogic.registrarAuditoriaDetallesPresuTipoCuentaProyecto(connexion,presutipocuentaproyecto,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(presutipocuentaproyecto.getIsDeleted()) {
					/*if(!presutipocuentaproyecto.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PresuTipoCuentaProyectoDataAccess.TABLENAME, presutipocuentaproyecto.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////PresuTipoCuentaProyectoLogic.registrarAuditoriaDetallesPresuTipoCuentaProyecto(connexion,presutipocuentaproyecto,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PresuTipoCuentaProyectoDataAccess.TABLENAME, presutipocuentaproyecto.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(presutipocuentaproyecto.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PresuTipoCuentaProyectoDataAccess.TABLENAME, presutipocuentaproyecto.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PresuTipoCuentaProyectoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PresuTipoCuentaProyectoLogic.registrarAuditoriaDetallesPresuTipoCuentaProyecto(connexion,presutipocuentaproyecto,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPresuTipoCuentaProyecto(Connexion connexion,PresuTipoCuentaProyecto presutipocuentaproyecto)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(presutipocuentaproyecto.getIsNew()||!presutipocuentaproyecto.getid_empresa().equals(presutipocuentaproyecto.getPresuTipoCuentaProyectoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presutipocuentaproyecto.getPresuTipoCuentaProyectoOriginal().getid_empresa()!=null)
				{
					strValorActual=presutipocuentaproyecto.getPresuTipoCuentaProyectoOriginal().getid_empresa().toString();
				}
				if(presutipocuentaproyecto.getid_empresa()!=null)
				{
					strValorNuevo=presutipocuentaproyecto.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuTipoCuentaProyectoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(presutipocuentaproyecto.getIsNew()||!presutipocuentaproyecto.getcodigo().equals(presutipocuentaproyecto.getPresuTipoCuentaProyectoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presutipocuentaproyecto.getPresuTipoCuentaProyectoOriginal().getcodigo()!=null)
				{
					strValorActual=presutipocuentaproyecto.getPresuTipoCuentaProyectoOriginal().getcodigo();
				}
				if(presutipocuentaproyecto.getcodigo()!=null)
				{
					strValorNuevo=presutipocuentaproyecto.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuTipoCuentaProyectoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(presutipocuentaproyecto.getIsNew()||!presutipocuentaproyecto.getnombre().equals(presutipocuentaproyecto.getPresuTipoCuentaProyectoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presutipocuentaproyecto.getPresuTipoCuentaProyectoOriginal().getnombre()!=null)
				{
					strValorActual=presutipocuentaproyecto.getPresuTipoCuentaProyectoOriginal().getnombre();
				}
				if(presutipocuentaproyecto.getnombre()!=null)
				{
					strValorNuevo=presutipocuentaproyecto.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuTipoCuentaProyectoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void savePresuTipoCuentaProyectoRelacionesWithConnection(PresuTipoCuentaProyecto presutipocuentaproyecto) throws Exception {

		if(!presutipocuentaproyecto.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePresuTipoCuentaProyectoRelacionesBase(presutipocuentaproyecto,true);
		}
	}

	public void savePresuTipoCuentaProyectoRelaciones(PresuTipoCuentaProyecto presutipocuentaproyecto)throws Exception {

		if(!presutipocuentaproyecto.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePresuTipoCuentaProyectoRelacionesBase(presutipocuentaproyecto,false);
		}
	}

	public void savePresuTipoCuentaProyectoRelacionesBase(PresuTipoCuentaProyecto presutipocuentaproyecto,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("PresuTipoCuentaProyecto-saveRelacionesWithConnection");}
	

			this.setPresuTipoCuentaProyecto(presutipocuentaproyecto);

			if(PresuTipoCuentaProyectoLogicAdditional.validarSaveRelaciones(presutipocuentaproyecto,this)) {

				PresuTipoCuentaProyectoLogicAdditional.updateRelacionesToSave(presutipocuentaproyecto,this);

				if((presutipocuentaproyecto.getIsNew()||presutipocuentaproyecto.getIsChanged())&&!presutipocuentaproyecto.getIsDeleted()) {
					this.savePresuTipoCuentaProyecto();
					this.savePresuTipoCuentaProyectoRelacionesDetalles();

				} else if(presutipocuentaproyecto.getIsDeleted()) {
					this.savePresuTipoCuentaProyectoRelacionesDetalles();
					this.savePresuTipoCuentaProyecto();
				}

				PresuTipoCuentaProyectoLogicAdditional.updateRelacionesToSaveAfter(presutipocuentaproyecto,this);

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
	
	
	private void savePresuTipoCuentaProyectoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPresuTipoCuentaProyecto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PresuTipoCuentaProyectoConstantesFunciones.getClassesForeignKeysOfPresuTipoCuentaProyecto(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresuTipoCuentaProyecto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PresuTipoCuentaProyectoConstantesFunciones.getClassesRelationshipsOfPresuTipoCuentaProyecto(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

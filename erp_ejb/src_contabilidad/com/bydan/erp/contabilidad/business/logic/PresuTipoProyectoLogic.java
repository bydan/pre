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
import com.bydan.erp.contabilidad.util.PresuTipoProyectoConstantesFunciones;
import com.bydan.erp.contabilidad.util.PresuTipoProyectoParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.PresuTipoProyectoParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.PresuTipoProyecto;
import com.bydan.erp.contabilidad.business.logic.PresuTipoProyectoLogicAdditional;
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
public class PresuTipoProyectoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(PresuTipoProyectoLogic.class);
	
	protected PresuTipoProyectoDataAccess presutipoproyectoDataAccess; 	
	protected PresuTipoProyecto presutipoproyecto;
	protected List<PresuTipoProyecto> presutipoproyectos;
	protected Object presutipoproyectoObject;	
	protected List<Object> presutipoproyectosObject;
	
	public static ClassValidator<PresuTipoProyecto> presutipoproyectoValidator = new ClassValidator<PresuTipoProyecto>(PresuTipoProyecto.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected PresuTipoProyectoLogicAdditional presutipoproyectoLogicAdditional=null;
	
	public PresuTipoProyectoLogicAdditional getPresuTipoProyectoLogicAdditional() {
		return this.presutipoproyectoLogicAdditional;
	}
	
	public void setPresuTipoProyectoLogicAdditional(PresuTipoProyectoLogicAdditional presutipoproyectoLogicAdditional) {
		try {
			this.presutipoproyectoLogicAdditional=presutipoproyectoLogicAdditional;
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
	
	
	
	
	public  PresuTipoProyectoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.presutipoproyectoDataAccess = new PresuTipoProyectoDataAccess();
			
			this.presutipoproyectos= new ArrayList<PresuTipoProyecto>();
			this.presutipoproyecto= new PresuTipoProyecto();
			
			this.presutipoproyectoObject=new Object();
			this.presutipoproyectosObject=new ArrayList<Object>();
				
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
			
			this.presutipoproyectoDataAccess.setConnexionType(this.connexionType);
			this.presutipoproyectoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  PresuTipoProyectoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.presutipoproyectoDataAccess = new PresuTipoProyectoDataAccess();
			this.presutipoproyectos= new ArrayList<PresuTipoProyecto>();
			this.presutipoproyecto= new PresuTipoProyecto();
			this.presutipoproyectoObject=new Object();
			this.presutipoproyectosObject=new ArrayList<Object>();
			
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
			
			this.presutipoproyectoDataAccess.setConnexionType(this.connexionType);
			this.presutipoproyectoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public PresuTipoProyecto getPresuTipoProyecto() throws Exception {	
		PresuTipoProyectoLogicAdditional.checkPresuTipoProyectoToGet(presutipoproyecto,this.datosCliente,this.arrDatoGeneral);
		PresuTipoProyectoLogicAdditional.updatePresuTipoProyectoToGet(presutipoproyecto,this.arrDatoGeneral);
		
		return presutipoproyecto;
	}
		
	public void setPresuTipoProyecto(PresuTipoProyecto newPresuTipoProyecto) {
		this.presutipoproyecto = newPresuTipoProyecto;
	}
	
	public PresuTipoProyectoDataAccess getPresuTipoProyectoDataAccess() {
		return presutipoproyectoDataAccess;
	}
	
	public void setPresuTipoProyectoDataAccess(PresuTipoProyectoDataAccess newpresutipoproyectoDataAccess) {
		this.presutipoproyectoDataAccess = newpresutipoproyectoDataAccess;
	}
	
	public List<PresuTipoProyecto> getPresuTipoProyectos() throws Exception {		
		this.quitarPresuTipoProyectosNulos();
		
		PresuTipoProyectoLogicAdditional.checkPresuTipoProyectoToGets(presutipoproyectos,this.datosCliente,this.arrDatoGeneral);
		
		for (PresuTipoProyecto presutipoproyectoLocal: presutipoproyectos ) {
			PresuTipoProyectoLogicAdditional.updatePresuTipoProyectoToGet(presutipoproyectoLocal,this.arrDatoGeneral);
		}
		
		return presutipoproyectos;
	}
	
	public void setPresuTipoProyectos(List<PresuTipoProyecto> newPresuTipoProyectos) {
		this.presutipoproyectos = newPresuTipoProyectos;
	}
	
	public Object getPresuTipoProyectoObject() {	
		this.presutipoproyectoObject=this.presutipoproyectoDataAccess.getEntityObject();
		return this.presutipoproyectoObject;
	}
		
	public void setPresuTipoProyectoObject(Object newPresuTipoProyectoObject) {
		this.presutipoproyectoObject = newPresuTipoProyectoObject;
	}
	
	public List<Object> getPresuTipoProyectosObject() {		
		this.presutipoproyectosObject=this.presutipoproyectoDataAccess.getEntitiesObject();
		return this.presutipoproyectosObject;
	}
		
	public void setPresuTipoProyectosObject(List<Object> newPresuTipoProyectosObject) {
		this.presutipoproyectosObject = newPresuTipoProyectosObject;
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
		
		if(this.presutipoproyectoDataAccess!=null) {
			this.presutipoproyectoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoProyecto.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			presutipoproyectoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			presutipoproyectoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		presutipoproyecto = new  PresuTipoProyecto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoProyecto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			presutipoproyecto=presutipoproyectoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presutipoproyecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresuTipoProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoProyecto(this.presutipoproyecto);
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
		presutipoproyecto = new  PresuTipoProyecto();
		  		  
        try {
			
			presutipoproyecto=presutipoproyectoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presutipoproyecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresuTipoProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoProyecto(this.presutipoproyecto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		presutipoproyecto = new  PresuTipoProyecto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoProyecto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			presutipoproyecto=presutipoproyectoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presutipoproyecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresuTipoProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoProyecto(this.presutipoproyecto);
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
		presutipoproyecto = new  PresuTipoProyecto();
		  		  
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
		presutipoproyecto = new  PresuTipoProyecto();
		  		  
        try {
			
			presutipoproyecto=presutipoproyectoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.presutipoproyecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				PresuTipoProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoProyecto(this.presutipoproyecto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		presutipoproyecto = new  PresuTipoProyecto();
		  		  
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
		presutipoproyecto = new  PresuTipoProyecto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoProyecto.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =presutipoproyectoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		presutipoproyecto = new  PresuTipoProyecto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=presutipoproyectoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		presutipoproyecto = new  PresuTipoProyecto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoProyecto.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =presutipoproyectoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		presutipoproyecto = new  PresuTipoProyecto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=presutipoproyectoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		presutipoproyecto = new  PresuTipoProyecto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoProyecto.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =presutipoproyectoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		presutipoproyecto = new  PresuTipoProyecto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=presutipoproyectoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		presutipoproyectos = new  ArrayList<PresuTipoProyecto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoProyecto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			PresuTipoProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presutipoproyectos=presutipoproyectoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresuTipoProyecto(presutipoproyectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuTipoProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoProyecto(this.presutipoproyectos);
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
		presutipoproyectos = new  ArrayList<PresuTipoProyecto>();
		  		  
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
		presutipoproyectos = new  ArrayList<PresuTipoProyecto>();
		  		  
        try {			
			PresuTipoProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presutipoproyectos=presutipoproyectoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarPresuTipoProyecto(presutipoproyectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuTipoProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoProyecto(this.presutipoproyectos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		presutipoproyectos = new  ArrayList<PresuTipoProyecto>();
		  		  
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
		presutipoproyectos = new  ArrayList<PresuTipoProyecto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoProyecto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			PresuTipoProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presutipoproyectos=presutipoproyectoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresuTipoProyecto(presutipoproyectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuTipoProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoProyecto(this.presutipoproyectos);
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
		presutipoproyectos = new  ArrayList<PresuTipoProyecto>();
		  		  
        try {
			PresuTipoProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presutipoproyectos=presutipoproyectoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresuTipoProyecto(presutipoproyectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuTipoProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoProyecto(this.presutipoproyectos);
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
		presutipoproyectos = new  ArrayList<PresuTipoProyecto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoProyecto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresuTipoProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presutipoproyectos=presutipoproyectoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresuTipoProyecto(presutipoproyectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuTipoProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoProyecto(this.presutipoproyectos);
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
		presutipoproyectos = new  ArrayList<PresuTipoProyecto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresuTipoProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presutipoproyectos=presutipoproyectoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresuTipoProyecto(presutipoproyectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuTipoProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoProyecto(this.presutipoproyectos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		presutipoproyecto = new  PresuTipoProyecto();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoProyecto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresuTipoProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presutipoproyecto=presutipoproyectoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresuTipoProyecto(presutipoproyecto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuTipoProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoProyecto(this.presutipoproyecto);
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
		presutipoproyecto = new  PresuTipoProyecto();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresuTipoProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presutipoproyecto=presutipoproyectoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarPresuTipoProyecto(presutipoproyecto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuTipoProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoProyecto(this.presutipoproyecto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		presutipoproyectos = new  ArrayList<PresuTipoProyecto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoProyecto.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			PresuTipoProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presutipoproyectos=presutipoproyectoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresuTipoProyecto(presutipoproyectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuTipoProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoProyecto(this.presutipoproyectos);
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
		presutipoproyectos = new  ArrayList<PresuTipoProyecto>();
		  		  
        try {
			PresuTipoProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presutipoproyectos=presutipoproyectoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarPresuTipoProyecto(presutipoproyectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuTipoProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoProyecto(this.presutipoproyectos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosPresuTipoProyectosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		presutipoproyectos = new  ArrayList<PresuTipoProyecto>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoProyecto.class.getSimpleName()+"-getTodosPresuTipoProyectosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresuTipoProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presutipoproyectos=presutipoproyectoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPresuTipoProyecto(presutipoproyectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuTipoProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoProyecto(this.presutipoproyectos);
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
	
	public  void  getTodosPresuTipoProyectos(String sFinalQuery,Pagination pagination)throws Exception {
		presutipoproyectos = new  ArrayList<PresuTipoProyecto>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			PresuTipoProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			presutipoproyectos=presutipoproyectoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarPresuTipoProyecto(presutipoproyectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				PresuTipoProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoProyecto(this.presutipoproyectos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarPresuTipoProyecto(PresuTipoProyecto presutipoproyecto) throws Exception {
		Boolean estaValidado=false;
		
		if(presutipoproyecto.getIsNew() || presutipoproyecto.getIsChanged()) { 
			this.invalidValues = presutipoproyectoValidator.getInvalidValues(presutipoproyecto);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(presutipoproyecto);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarPresuTipoProyecto(List<PresuTipoProyecto> PresuTipoProyectos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(PresuTipoProyecto presutipoproyectoLocal:presutipoproyectos) {				
			estaValidadoObjeto=this.validarGuardarPresuTipoProyecto(presutipoproyectoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarPresuTipoProyecto(List<PresuTipoProyecto> PresuTipoProyectos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPresuTipoProyecto(presutipoproyectos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarPresuTipoProyecto(PresuTipoProyecto PresuTipoProyecto) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarPresuTipoProyecto(presutipoproyecto)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(PresuTipoProyecto presutipoproyecto) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+presutipoproyecto.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=PresuTipoProyectoConstantesFunciones.getPresuTipoProyectoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"presutipoproyecto","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(PresuTipoProyectoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(PresuTipoProyectoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void savePresuTipoProyectoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoProyecto.class.getSimpleName()+"-savePresuTipoProyectoWithConnection");connexion.begin();			
			
			PresuTipoProyectoLogicAdditional.checkPresuTipoProyectoToSave(this.presutipoproyecto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PresuTipoProyectoLogicAdditional.updatePresuTipoProyectoToSave(this.presutipoproyecto,this.arrDatoGeneral);
			
			PresuTipoProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.presutipoproyecto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowPresuTipoProyecto();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPresuTipoProyecto(this.presutipoproyecto)) {
				PresuTipoProyectoDataAccess.save(this.presutipoproyecto, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.presutipoproyecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PresuTipoProyectoLogicAdditional.checkPresuTipoProyectoToSaveAfter(this.presutipoproyecto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPresuTipoProyecto();
			
			connexion.commit();			
			
			if(this.presutipoproyecto.getIsDeleted()) {
				this.presutipoproyecto=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void savePresuTipoProyecto()throws Exception {	
		try {	
			
			PresuTipoProyectoLogicAdditional.checkPresuTipoProyectoToSave(this.presutipoproyecto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			PresuTipoProyectoLogicAdditional.updatePresuTipoProyectoToSave(this.presutipoproyecto,this.arrDatoGeneral);
			
			PresuTipoProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.presutipoproyecto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarPresuTipoProyecto(this.presutipoproyecto)) {			
				PresuTipoProyectoDataAccess.save(this.presutipoproyecto, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.presutipoproyecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			PresuTipoProyectoLogicAdditional.checkPresuTipoProyectoToSaveAfter(this.presutipoproyecto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.presutipoproyecto.getIsDeleted()) {
				this.presutipoproyecto=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void savePresuTipoProyectosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoProyecto.class.getSimpleName()+"-savePresuTipoProyectosWithConnection");connexion.begin();			
			
			PresuTipoProyectoLogicAdditional.checkPresuTipoProyectoToSaves(presutipoproyectos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowPresuTipoProyectos();
			
			Boolean validadoTodosPresuTipoProyecto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PresuTipoProyecto presutipoproyectoLocal:presutipoproyectos) {		
				if(presutipoproyectoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PresuTipoProyectoLogicAdditional.updatePresuTipoProyectoToSave(presutipoproyectoLocal,this.arrDatoGeneral);
	        	
				PresuTipoProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),presutipoproyectoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPresuTipoProyecto(presutipoproyectoLocal)) {
					PresuTipoProyectoDataAccess.save(presutipoproyectoLocal, connexion);				
				} else {
					validadoTodosPresuTipoProyecto=false;
				}
			}
			
			if(!validadoTodosPresuTipoProyecto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PresuTipoProyectoLogicAdditional.checkPresuTipoProyectoToSavesAfter(presutipoproyectos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowPresuTipoProyectos();
			
			connexion.commit();		
			
			this.quitarPresuTipoProyectosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void savePresuTipoProyectos()throws Exception {				
		 try {	
			PresuTipoProyectoLogicAdditional.checkPresuTipoProyectoToSaves(presutipoproyectos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosPresuTipoProyecto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(PresuTipoProyecto presutipoproyectoLocal:presutipoproyectos) {				
				if(presutipoproyectoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				PresuTipoProyectoLogicAdditional.updatePresuTipoProyectoToSave(presutipoproyectoLocal,this.arrDatoGeneral);
	        	
				PresuTipoProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),presutipoproyectoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarPresuTipoProyecto(presutipoproyectoLocal)) {				
					PresuTipoProyectoDataAccess.save(presutipoproyectoLocal, connexion);				
				} else {
					validadoTodosPresuTipoProyecto=false;
				}
			}
			
			if(!validadoTodosPresuTipoProyecto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			PresuTipoProyectoLogicAdditional.checkPresuTipoProyectoToSavesAfter(presutipoproyectos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarPresuTipoProyectosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PresuTipoProyectoParameterReturnGeneral procesarAccionPresuTipoProyectos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PresuTipoProyecto> presutipoproyectos,PresuTipoProyectoParameterReturnGeneral presutipoproyectoParameterGeneral)throws Exception {
		 try {	
			PresuTipoProyectoParameterReturnGeneral presutipoproyectoReturnGeneral=new PresuTipoProyectoParameterReturnGeneral();
	
			PresuTipoProyectoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,presutipoproyectos,presutipoproyectoParameterGeneral,presutipoproyectoReturnGeneral);
			
			return presutipoproyectoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public PresuTipoProyectoParameterReturnGeneral procesarAccionPresuTipoProyectosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<PresuTipoProyecto> presutipoproyectos,PresuTipoProyectoParameterReturnGeneral presutipoproyectoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoProyecto.class.getSimpleName()+"-procesarAccionPresuTipoProyectosWithConnection");connexion.begin();			
			
			PresuTipoProyectoParameterReturnGeneral presutipoproyectoReturnGeneral=new PresuTipoProyectoParameterReturnGeneral();
	
			PresuTipoProyectoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,presutipoproyectos,presutipoproyectoParameterGeneral,presutipoproyectoReturnGeneral);
			
			this.connexion.commit();
			
			return presutipoproyectoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PresuTipoProyectoParameterReturnGeneral procesarEventosPresuTipoProyectos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PresuTipoProyecto> presutipoproyectos,PresuTipoProyecto presutipoproyecto,PresuTipoProyectoParameterReturnGeneral presutipoproyectoParameterGeneral,Boolean isEsNuevoPresuTipoProyecto,ArrayList<Classe> clases)throws Exception {
		 try {	
			PresuTipoProyectoParameterReturnGeneral presutipoproyectoReturnGeneral=new PresuTipoProyectoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				presutipoproyectoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PresuTipoProyectoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,presutipoproyectos,presutipoproyecto,presutipoproyectoParameterGeneral,presutipoproyectoReturnGeneral,isEsNuevoPresuTipoProyecto,clases);
			
			return presutipoproyectoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public PresuTipoProyectoParameterReturnGeneral procesarEventosPresuTipoProyectosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<PresuTipoProyecto> presutipoproyectos,PresuTipoProyecto presutipoproyecto,PresuTipoProyectoParameterReturnGeneral presutipoproyectoParameterGeneral,Boolean isEsNuevoPresuTipoProyecto,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoProyecto.class.getSimpleName()+"-procesarEventosPresuTipoProyectosWithConnection");connexion.begin();			
			
			PresuTipoProyectoParameterReturnGeneral presutipoproyectoReturnGeneral=new PresuTipoProyectoParameterReturnGeneral();
	
			presutipoproyectoReturnGeneral.setPresuTipoProyecto(presutipoproyecto);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				presutipoproyectoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			PresuTipoProyectoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,presutipoproyectos,presutipoproyecto,presutipoproyectoParameterGeneral,presutipoproyectoReturnGeneral,isEsNuevoPresuTipoProyecto,clases);
			
			this.connexion.commit();
			
			return presutipoproyectoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public PresuTipoProyectoParameterReturnGeneral procesarImportacionPresuTipoProyectosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,PresuTipoProyectoParameterReturnGeneral presutipoproyectoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoProyecto.class.getSimpleName()+"-procesarImportacionPresuTipoProyectosWithConnection");connexion.begin();			
			
			PresuTipoProyectoParameterReturnGeneral presutipoproyectoReturnGeneral=new PresuTipoProyectoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.presutipoproyectos=new ArrayList<PresuTipoProyecto>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.presutipoproyecto=new PresuTipoProyecto();
				
				
				if(conColumnasBase) {this.presutipoproyecto.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.presutipoproyecto.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.presutipoproyecto.setcodigo(arrColumnas[iColumn++]);
				this.presutipoproyecto.setnombre(arrColumnas[iColumn++]);
				
				this.presutipoproyectos.add(this.presutipoproyecto);
			}
			
			this.savePresuTipoProyectos();
			
			this.connexion.commit();
			
			presutipoproyectoReturnGeneral.setConRetornoEstaProcesado(true);
			presutipoproyectoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return presutipoproyectoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarPresuTipoProyectosEliminados() throws Exception {				
		
		List<PresuTipoProyecto> presutipoproyectosAux= new ArrayList<PresuTipoProyecto>();
		
		for(PresuTipoProyecto presutipoproyecto:presutipoproyectos) {
			if(!presutipoproyecto.getIsDeleted()) {
				presutipoproyectosAux.add(presutipoproyecto);
			}
		}
		
		presutipoproyectos=presutipoproyectosAux;
	}
	
	public void quitarPresuTipoProyectosNulos() throws Exception {				
		
		List<PresuTipoProyecto> presutipoproyectosAux= new ArrayList<PresuTipoProyecto>();
		
		for(PresuTipoProyecto presutipoproyecto : this.presutipoproyectos) {
			if(presutipoproyecto==null) {
				presutipoproyectosAux.add(presutipoproyecto);
			}
		}
		
		//this.presutipoproyectos=presutipoproyectosAux;
		
		this.presutipoproyectos.removeAll(presutipoproyectosAux);
	}
	
	public void getSetVersionRowPresuTipoProyectoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(presutipoproyecto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((presutipoproyecto.getIsDeleted() || (presutipoproyecto.getIsChanged()&&!presutipoproyecto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=presutipoproyectoDataAccess.getSetVersionRowPresuTipoProyecto(connexion,presutipoproyecto.getId());
				
				if(!presutipoproyecto.getVersionRow().equals(timestamp)) {	
					presutipoproyecto.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				presutipoproyecto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowPresuTipoProyecto()throws Exception {	
		
		if(presutipoproyecto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((presutipoproyecto.getIsDeleted() || (presutipoproyecto.getIsChanged()&&!presutipoproyecto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=presutipoproyectoDataAccess.getSetVersionRowPresuTipoProyecto(connexion,presutipoproyecto.getId());
			
			try {							
				if(!presutipoproyecto.getVersionRow().equals(timestamp)) {	
					presutipoproyecto.setVersionRow(timestamp);
				}
				
				presutipoproyecto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowPresuTipoProyectosWithConnection()throws Exception {	
		if(presutipoproyectos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(PresuTipoProyecto presutipoproyectoAux:presutipoproyectos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(presutipoproyectoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(presutipoproyectoAux.getIsDeleted() || (presutipoproyectoAux.getIsChanged()&&!presutipoproyectoAux.getIsNew())) {
						
						timestamp=presutipoproyectoDataAccess.getSetVersionRowPresuTipoProyecto(connexion,presutipoproyectoAux.getId());
						
						if(!presutipoproyecto.getVersionRow().equals(timestamp)) {	
							presutipoproyectoAux.setVersionRow(timestamp);
						}
								
						presutipoproyectoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowPresuTipoProyectos()throws Exception {	
		if(presutipoproyectos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(PresuTipoProyecto presutipoproyectoAux:presutipoproyectos) {
					if(presutipoproyectoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(presutipoproyectoAux.getIsDeleted() || (presutipoproyectoAux.getIsChanged()&&!presutipoproyectoAux.getIsNew())) {
						
						timestamp=presutipoproyectoDataAccess.getSetVersionRowPresuTipoProyecto(connexion,presutipoproyectoAux.getId());
						
						if(!presutipoproyectoAux.getVersionRow().equals(timestamp)) {	
							presutipoproyectoAux.setVersionRow(timestamp);
						}
						
													
						presutipoproyectoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public PresuTipoProyectoParameterReturnGeneral cargarCombosLoteForeignKeyPresuTipoProyectoWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		PresuTipoProyectoParameterReturnGeneral  presutipoproyectoReturnGeneral =new PresuTipoProyectoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoProyecto.class.getSimpleName()+"-cargarCombosLoteForeignKeyPresuTipoProyectoWithConnection");connexion.begin();
			
			presutipoproyectoReturnGeneral =new PresuTipoProyectoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			presutipoproyectoReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return presutipoproyectoReturnGeneral;
	}
	
	public PresuTipoProyectoParameterReturnGeneral cargarCombosLoteForeignKeyPresuTipoProyecto(String finalQueryGlobalEmpresa) throws Exception {
		PresuTipoProyectoParameterReturnGeneral  presutipoproyectoReturnGeneral =new PresuTipoProyectoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			presutipoproyectoReturnGeneral =new PresuTipoProyectoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			presutipoproyectoReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return presutipoproyectoReturnGeneral;
	}
	
	
	public void deepLoad(PresuTipoProyecto presutipoproyecto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			PresuTipoProyectoLogicAdditional.updatePresuTipoProyectoToGet(presutipoproyecto,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		presutipoproyecto.setEmpresa(presutipoproyectoDataAccess.getEmpresa(connexion,presutipoproyecto));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				presutipoproyecto.setEmpresa(presutipoproyectoDataAccess.getEmpresa(connexion,presutipoproyecto));
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
			presutipoproyecto.setEmpresa(presutipoproyectoDataAccess.getEmpresa(connexion,presutipoproyecto));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		presutipoproyecto.setEmpresa(presutipoproyectoDataAccess.getEmpresa(connexion,presutipoproyecto));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(presutipoproyecto.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				presutipoproyecto.setEmpresa(presutipoproyectoDataAccess.getEmpresa(connexion,presutipoproyecto));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(presutipoproyecto.getEmpresa(),isDeep,deepLoadType,clases);				
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
			presutipoproyecto.setEmpresa(presutipoproyectoDataAccess.getEmpresa(connexion,presutipoproyecto));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(presutipoproyecto.getEmpresa(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(PresuTipoProyecto presutipoproyecto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			PresuTipoProyectoLogicAdditional.updatePresuTipoProyectoToSave(presutipoproyecto,this.arrDatoGeneral);
			
PresuTipoProyectoDataAccess.save(presutipoproyecto, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(presutipoproyecto.getEmpresa(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(presutipoproyecto.getEmpresa(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(presutipoproyecto.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(presutipoproyecto.getEmpresa(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(presutipoproyecto.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(presutipoproyecto.getEmpresa(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(PresuTipoProyecto.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(presutipoproyecto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PresuTipoProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoProyecto(presutipoproyecto);
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
			this.deepLoad(this.presutipoproyecto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				PresuTipoProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoProyecto(this.presutipoproyecto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(PresuTipoProyecto.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(presutipoproyectos!=null) {
				for(PresuTipoProyecto presutipoproyecto:presutipoproyectos) {
					this.deepLoad(presutipoproyecto,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					PresuTipoProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoProyecto(presutipoproyectos);
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
			if(presutipoproyectos!=null) {
				for(PresuTipoProyecto presutipoproyecto:presutipoproyectos) {
					this.deepLoad(presutipoproyecto,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					PresuTipoProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoProyecto(presutipoproyectos);
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
			this.getNewConnexionToDeep(PresuTipoProyecto.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(presutipoproyecto,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(PresuTipoProyecto.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(presutipoproyectos!=null) {
				for(PresuTipoProyecto presutipoproyecto:presutipoproyectos) {
					this.deepSave(presutipoproyecto,isDeep,deepLoadType,clases);
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
			if(presutipoproyectos!=null) {
				for(PresuTipoProyecto presutipoproyecto:presutipoproyectos) {
					this.deepSave(presutipoproyecto,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getPresuTipoProyectosBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoProyecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",PresuTipoProyectoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			PresuTipoProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presutipoproyectos=presutipoproyectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuTipoProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoProyecto(this.presutipoproyectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresuTipoProyectosBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",PresuTipoProyectoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			PresuTipoProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presutipoproyectos=presutipoproyectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuTipoProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoProyecto(this.presutipoproyectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresuTipoProyectosBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoProyecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",PresuTipoProyectoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			PresuTipoProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presutipoproyectos=presutipoproyectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuTipoProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoProyecto(this.presutipoproyectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresuTipoProyectosBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",PresuTipoProyectoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			PresuTipoProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presutipoproyectos=presutipoproyectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuTipoProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoProyecto(this.presutipoproyectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getPresuTipoProyectosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,PresuTipoProyecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PresuTipoProyectoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PresuTipoProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presutipoproyectos=presutipoproyectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuTipoProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoProyecto(this.presutipoproyectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getPresuTipoProyectosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,PresuTipoProyectoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			PresuTipoProyectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			presutipoproyectos=presutipoproyectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				PresuTipoProyectoConstantesFunciones.refrescarForeignKeysDescripcionesPresuTipoProyecto(this.presutipoproyectos);
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
			if(PresuTipoProyectoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,PresuTipoProyectoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,PresuTipoProyecto presutipoproyecto,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(PresuTipoProyectoConstantesFunciones.ISCONAUDITORIA) {
				if(presutipoproyecto.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PresuTipoProyectoDataAccess.TABLENAME, presutipoproyecto.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PresuTipoProyectoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PresuTipoProyectoLogic.registrarAuditoriaDetallesPresuTipoProyecto(connexion,presutipoproyecto,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(presutipoproyecto.getIsDeleted()) {
					/*if(!presutipoproyecto.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,PresuTipoProyectoDataAccess.TABLENAME, presutipoproyecto.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////PresuTipoProyectoLogic.registrarAuditoriaDetallesPresuTipoProyecto(connexion,presutipoproyecto,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PresuTipoProyectoDataAccess.TABLENAME, presutipoproyecto.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(presutipoproyecto.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,PresuTipoProyectoDataAccess.TABLENAME, presutipoproyecto.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(PresuTipoProyectoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////PresuTipoProyectoLogic.registrarAuditoriaDetallesPresuTipoProyecto(connexion,presutipoproyecto,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesPresuTipoProyecto(Connexion connexion,PresuTipoProyecto presutipoproyecto)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(presutipoproyecto.getIsNew()||!presutipoproyecto.getid_empresa().equals(presutipoproyecto.getPresuTipoProyectoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presutipoproyecto.getPresuTipoProyectoOriginal().getid_empresa()!=null)
				{
					strValorActual=presutipoproyecto.getPresuTipoProyectoOriginal().getid_empresa().toString();
				}
				if(presutipoproyecto.getid_empresa()!=null)
				{
					strValorNuevo=presutipoproyecto.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuTipoProyectoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(presutipoproyecto.getIsNew()||!presutipoproyecto.getcodigo().equals(presutipoproyecto.getPresuTipoProyectoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presutipoproyecto.getPresuTipoProyectoOriginal().getcodigo()!=null)
				{
					strValorActual=presutipoproyecto.getPresuTipoProyectoOriginal().getcodigo();
				}
				if(presutipoproyecto.getcodigo()!=null)
				{
					strValorNuevo=presutipoproyecto.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuTipoProyectoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(presutipoproyecto.getIsNew()||!presutipoproyecto.getnombre().equals(presutipoproyecto.getPresuTipoProyectoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(presutipoproyecto.getPresuTipoProyectoOriginal().getnombre()!=null)
				{
					strValorActual=presutipoproyecto.getPresuTipoProyectoOriginal().getnombre();
				}
				if(presutipoproyecto.getnombre()!=null)
				{
					strValorNuevo=presutipoproyecto.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),PresuTipoProyectoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void savePresuTipoProyectoRelacionesWithConnection(PresuTipoProyecto presutipoproyecto) throws Exception {

		if(!presutipoproyecto.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePresuTipoProyectoRelacionesBase(presutipoproyecto,true);
		}
	}

	public void savePresuTipoProyectoRelaciones(PresuTipoProyecto presutipoproyecto)throws Exception {

		if(!presutipoproyecto.getsType().contains(Constantes2.S_TOTALES)) {
			this.savePresuTipoProyectoRelacionesBase(presutipoproyecto,false);
		}
	}

	public void savePresuTipoProyectoRelacionesBase(PresuTipoProyecto presutipoproyecto,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("PresuTipoProyecto-saveRelacionesWithConnection");}
	

			this.setPresuTipoProyecto(presutipoproyecto);

			if(PresuTipoProyectoLogicAdditional.validarSaveRelaciones(presutipoproyecto,this)) {

				PresuTipoProyectoLogicAdditional.updateRelacionesToSave(presutipoproyecto,this);

				if((presutipoproyecto.getIsNew()||presutipoproyecto.getIsChanged())&&!presutipoproyecto.getIsDeleted()) {
					this.savePresuTipoProyecto();
					this.savePresuTipoProyectoRelacionesDetalles();

				} else if(presutipoproyecto.getIsDeleted()) {
					this.savePresuTipoProyectoRelacionesDetalles();
					this.savePresuTipoProyecto();
				}

				PresuTipoProyectoLogicAdditional.updateRelacionesToSaveAfter(presutipoproyecto,this);

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
	
	
	private void savePresuTipoProyectoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfPresuTipoProyecto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PresuTipoProyectoConstantesFunciones.getClassesForeignKeysOfPresuTipoProyecto(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPresuTipoProyecto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=PresuTipoProyectoConstantesFunciones.getClassesRelationshipsOfPresuTipoProyecto(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

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
import com.bydan.erp.tesoreria.util.ParametroTesoreriaDefectoConstantesFunciones;
import com.bydan.erp.tesoreria.util.ParametroTesoreriaDefectoParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.ParametroTesoreriaDefectoParameterGeneral;
import com.bydan.erp.tesoreria.business.entity.ParametroTesoreriaDefecto;
import com.bydan.erp.tesoreria.business.logic.ParametroTesoreriaDefectoLogicAdditional;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class ParametroTesoreriaDefectoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ParametroTesoreriaDefectoLogic.class);
	
	protected ParametroTesoreriaDefectoDataAccess parametrotesoreriadefectoDataAccess; 	
	protected ParametroTesoreriaDefecto parametrotesoreriadefecto;
	protected List<ParametroTesoreriaDefecto> parametrotesoreriadefectos;
	protected Object parametrotesoreriadefectoObject;	
	protected List<Object> parametrotesoreriadefectosObject;
	
	public static ClassValidator<ParametroTesoreriaDefecto> parametrotesoreriadefectoValidator = new ClassValidator<ParametroTesoreriaDefecto>(ParametroTesoreriaDefecto.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ParametroTesoreriaDefectoLogicAdditional parametrotesoreriadefectoLogicAdditional=null;
	
	public ParametroTesoreriaDefectoLogicAdditional getParametroTesoreriaDefectoLogicAdditional() {
		return this.parametrotesoreriadefectoLogicAdditional;
	}
	
	public void setParametroTesoreriaDefectoLogicAdditional(ParametroTesoreriaDefectoLogicAdditional parametrotesoreriadefectoLogicAdditional) {
		try {
			this.parametrotesoreriadefectoLogicAdditional=parametrotesoreriadefectoLogicAdditional;
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
	
	
	
	
	public  ParametroTesoreriaDefectoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.parametrotesoreriadefectoDataAccess = new ParametroTesoreriaDefectoDataAccess();
			
			this.parametrotesoreriadefectos= new ArrayList<ParametroTesoreriaDefecto>();
			this.parametrotesoreriadefecto= new ParametroTesoreriaDefecto();
			
			this.parametrotesoreriadefectoObject=new Object();
			this.parametrotesoreriadefectosObject=new ArrayList<Object>();
				
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
			
			this.parametrotesoreriadefectoDataAccess.setConnexionType(this.connexionType);
			this.parametrotesoreriadefectoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ParametroTesoreriaDefectoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.parametrotesoreriadefectoDataAccess = new ParametroTesoreriaDefectoDataAccess();
			this.parametrotesoreriadefectos= new ArrayList<ParametroTesoreriaDefecto>();
			this.parametrotesoreriadefecto= new ParametroTesoreriaDefecto();
			this.parametrotesoreriadefectoObject=new Object();
			this.parametrotesoreriadefectosObject=new ArrayList<Object>();
			
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
			
			this.parametrotesoreriadefectoDataAccess.setConnexionType(this.connexionType);
			this.parametrotesoreriadefectoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ParametroTesoreriaDefecto getParametroTesoreriaDefecto() throws Exception {	
		ParametroTesoreriaDefectoLogicAdditional.checkParametroTesoreriaDefectoToGet(parametrotesoreriadefecto,this.datosCliente,this.arrDatoGeneral);
		ParametroTesoreriaDefectoLogicAdditional.updateParametroTesoreriaDefectoToGet(parametrotesoreriadefecto,this.arrDatoGeneral);
		
		return parametrotesoreriadefecto;
	}
		
	public void setParametroTesoreriaDefecto(ParametroTesoreriaDefecto newParametroTesoreriaDefecto) {
		this.parametrotesoreriadefecto = newParametroTesoreriaDefecto;
	}
	
	public ParametroTesoreriaDefectoDataAccess getParametroTesoreriaDefectoDataAccess() {
		return parametrotesoreriadefectoDataAccess;
	}
	
	public void setParametroTesoreriaDefectoDataAccess(ParametroTesoreriaDefectoDataAccess newparametrotesoreriadefectoDataAccess) {
		this.parametrotesoreriadefectoDataAccess = newparametrotesoreriadefectoDataAccess;
	}
	
	public List<ParametroTesoreriaDefecto> getParametroTesoreriaDefectos() throws Exception {		
		this.quitarParametroTesoreriaDefectosNulos();
		
		ParametroTesoreriaDefectoLogicAdditional.checkParametroTesoreriaDefectoToGets(parametrotesoreriadefectos,this.datosCliente,this.arrDatoGeneral);
		
		for (ParametroTesoreriaDefecto parametrotesoreriadefectoLocal: parametrotesoreriadefectos ) {
			ParametroTesoreriaDefectoLogicAdditional.updateParametroTesoreriaDefectoToGet(parametrotesoreriadefectoLocal,this.arrDatoGeneral);
		}
		
		return parametrotesoreriadefectos;
	}
	
	public void setParametroTesoreriaDefectos(List<ParametroTesoreriaDefecto> newParametroTesoreriaDefectos) {
		this.parametrotesoreriadefectos = newParametroTesoreriaDefectos;
	}
	
	public Object getParametroTesoreriaDefectoObject() {	
		this.parametrotesoreriadefectoObject=this.parametrotesoreriadefectoDataAccess.getEntityObject();
		return this.parametrotesoreriadefectoObject;
	}
		
	public void setParametroTesoreriaDefectoObject(Object newParametroTesoreriaDefectoObject) {
		this.parametrotesoreriadefectoObject = newParametroTesoreriaDefectoObject;
	}
	
	public List<Object> getParametroTesoreriaDefectosObject() {		
		this.parametrotesoreriadefectosObject=this.parametrotesoreriadefectoDataAccess.getEntitiesObject();
		return this.parametrotesoreriadefectosObject;
	}
		
	public void setParametroTesoreriaDefectosObject(List<Object> newParametroTesoreriaDefectosObject) {
		this.parametrotesoreriadefectosObject = newParametroTesoreriaDefectosObject;
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
		
		if(this.parametrotesoreriadefectoDataAccess!=null) {
			this.parametrotesoreriadefectoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreriaDefecto.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			parametrotesoreriadefectoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			parametrotesoreriadefectoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		parametrotesoreriadefecto = new  ParametroTesoreriaDefecto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreriaDefecto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametrotesoreriadefecto=parametrotesoreriadefectoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrotesoreriadefecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroTesoreriaDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreriaDefecto(this.parametrotesoreriadefecto);
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
		parametrotesoreriadefecto = new  ParametroTesoreriaDefecto();
		  		  
        try {
			
			parametrotesoreriadefecto=parametrotesoreriadefectoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrotesoreriadefecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroTesoreriaDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreriaDefecto(this.parametrotesoreriadefecto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		parametrotesoreriadefecto = new  ParametroTesoreriaDefecto();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreriaDefecto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametrotesoreriadefecto=parametrotesoreriadefectoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrotesoreriadefecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroTesoreriaDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreriaDefecto(this.parametrotesoreriadefecto);
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
		parametrotesoreriadefecto = new  ParametroTesoreriaDefecto();
		  		  
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
		parametrotesoreriadefecto = new  ParametroTesoreriaDefecto();
		  		  
        try {
			
			parametrotesoreriadefecto=parametrotesoreriadefectoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrotesoreriadefecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroTesoreriaDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreriaDefecto(this.parametrotesoreriadefecto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		parametrotesoreriadefecto = new  ParametroTesoreriaDefecto();
		  		  
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
		parametrotesoreriadefecto = new  ParametroTesoreriaDefecto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreriaDefecto.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =parametrotesoreriadefectoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrotesoreriadefecto = new  ParametroTesoreriaDefecto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=parametrotesoreriadefectoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametrotesoreriadefecto = new  ParametroTesoreriaDefecto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreriaDefecto.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =parametrotesoreriadefectoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrotesoreriadefecto = new  ParametroTesoreriaDefecto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=parametrotesoreriadefectoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametrotesoreriadefecto = new  ParametroTesoreriaDefecto();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreriaDefecto.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =parametrotesoreriadefectoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrotesoreriadefecto = new  ParametroTesoreriaDefecto();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=parametrotesoreriadefectoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametrotesoreriadefectos = new  ArrayList<ParametroTesoreriaDefecto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreriaDefecto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ParametroTesoreriaDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrotesoreriadefectos=parametrotesoreriadefectoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroTesoreriaDefecto(parametrotesoreriadefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroTesoreriaDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreriaDefecto(this.parametrotesoreriadefectos);
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
		parametrotesoreriadefectos = new  ArrayList<ParametroTesoreriaDefecto>();
		  		  
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
		parametrotesoreriadefectos = new  ArrayList<ParametroTesoreriaDefecto>();
		  		  
        try {			
			ParametroTesoreriaDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrotesoreriadefectos=parametrotesoreriadefectoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarParametroTesoreriaDefecto(parametrotesoreriadefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroTesoreriaDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreriaDefecto(this.parametrotesoreriadefectos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		parametrotesoreriadefectos = new  ArrayList<ParametroTesoreriaDefecto>();
		  		  
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
		parametrotesoreriadefectos = new  ArrayList<ParametroTesoreriaDefecto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreriaDefecto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ParametroTesoreriaDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrotesoreriadefectos=parametrotesoreriadefectoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroTesoreriaDefecto(parametrotesoreriadefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroTesoreriaDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreriaDefecto(this.parametrotesoreriadefectos);
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
		parametrotesoreriadefectos = new  ArrayList<ParametroTesoreriaDefecto>();
		  		  
        try {
			ParametroTesoreriaDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrotesoreriadefectos=parametrotesoreriadefectoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroTesoreriaDefecto(parametrotesoreriadefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroTesoreriaDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreriaDefecto(this.parametrotesoreriadefectos);
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
		parametrotesoreriadefectos = new  ArrayList<ParametroTesoreriaDefecto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreriaDefecto.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroTesoreriaDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrotesoreriadefectos=parametrotesoreriadefectoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroTesoreriaDefecto(parametrotesoreriadefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroTesoreriaDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreriaDefecto(this.parametrotesoreriadefectos);
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
		parametrotesoreriadefectos = new  ArrayList<ParametroTesoreriaDefecto>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroTesoreriaDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrotesoreriadefectos=parametrotesoreriadefectoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroTesoreriaDefecto(parametrotesoreriadefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroTesoreriaDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreriaDefecto(this.parametrotesoreriadefectos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		parametrotesoreriadefecto = new  ParametroTesoreriaDefecto();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreriaDefecto.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroTesoreriaDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrotesoreriadefecto=parametrotesoreriadefectoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroTesoreriaDefecto(parametrotesoreriadefecto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroTesoreriaDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreriaDefecto(this.parametrotesoreriadefecto);
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
		parametrotesoreriadefecto = new  ParametroTesoreriaDefecto();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroTesoreriaDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrotesoreriadefecto=parametrotesoreriadefectoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroTesoreriaDefecto(parametrotesoreriadefecto);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroTesoreriaDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreriaDefecto(this.parametrotesoreriadefecto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametrotesoreriadefectos = new  ArrayList<ParametroTesoreriaDefecto>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreriaDefecto.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ParametroTesoreriaDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrotesoreriadefectos=parametrotesoreriadefectoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroTesoreriaDefecto(parametrotesoreriadefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroTesoreriaDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreriaDefecto(this.parametrotesoreriadefectos);
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
		parametrotesoreriadefectos = new  ArrayList<ParametroTesoreriaDefecto>();
		  		  
        try {
			ParametroTesoreriaDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrotesoreriadefectos=parametrotesoreriadefectoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroTesoreriaDefecto(parametrotesoreriadefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroTesoreriaDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreriaDefecto(this.parametrotesoreriadefectos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosParametroTesoreriaDefectosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		parametrotesoreriadefectos = new  ArrayList<ParametroTesoreriaDefecto>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreriaDefecto.class.getSimpleName()+"-getTodosParametroTesoreriaDefectosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroTesoreriaDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrotesoreriadefectos=parametrotesoreriadefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroTesoreriaDefecto(parametrotesoreriadefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroTesoreriaDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreriaDefecto(this.parametrotesoreriadefectos);
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
	
	public  void  getTodosParametroTesoreriaDefectos(String sFinalQuery,Pagination pagination)throws Exception {
		parametrotesoreriadefectos = new  ArrayList<ParametroTesoreriaDefecto>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroTesoreriaDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrotesoreriadefectos=parametrotesoreriadefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroTesoreriaDefecto(parametrotesoreriadefectos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroTesoreriaDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreriaDefecto(this.parametrotesoreriadefectos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarParametroTesoreriaDefecto(ParametroTesoreriaDefecto parametrotesoreriadefecto) throws Exception {
		Boolean estaValidado=false;
		
		if(parametrotesoreriadefecto.getIsNew() || parametrotesoreriadefecto.getIsChanged()) { 
			this.invalidValues = parametrotesoreriadefectoValidator.getInvalidValues(parametrotesoreriadefecto);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(parametrotesoreriadefecto);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarParametroTesoreriaDefecto(List<ParametroTesoreriaDefecto> ParametroTesoreriaDefectos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ParametroTesoreriaDefecto parametrotesoreriadefectoLocal:parametrotesoreriadefectos) {				
			estaValidadoObjeto=this.validarGuardarParametroTesoreriaDefecto(parametrotesoreriadefectoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarParametroTesoreriaDefecto(List<ParametroTesoreriaDefecto> ParametroTesoreriaDefectos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroTesoreriaDefecto(parametrotesoreriadefectos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarParametroTesoreriaDefecto(ParametroTesoreriaDefecto ParametroTesoreriaDefecto) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroTesoreriaDefecto(parametrotesoreriadefecto)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ParametroTesoreriaDefecto parametrotesoreriadefecto) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+parametrotesoreriadefecto.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ParametroTesoreriaDefectoConstantesFunciones.getParametroTesoreriaDefectoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"parametrotesoreriadefecto","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ParametroTesoreriaDefectoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ParametroTesoreriaDefectoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveParametroTesoreriaDefectoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreriaDefecto.class.getSimpleName()+"-saveParametroTesoreriaDefectoWithConnection");connexion.begin();			
			
			ParametroTesoreriaDefectoLogicAdditional.checkParametroTesoreriaDefectoToSave(this.parametrotesoreriadefecto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroTesoreriaDefectoLogicAdditional.updateParametroTesoreriaDefectoToSave(this.parametrotesoreriadefecto,this.arrDatoGeneral);
			
			ParametroTesoreriaDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametrotesoreriadefecto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowParametroTesoreriaDefecto();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroTesoreriaDefecto(this.parametrotesoreriadefecto)) {
				ParametroTesoreriaDefectoDataAccess.save(this.parametrotesoreriadefecto, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.parametrotesoreriadefecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroTesoreriaDefectoLogicAdditional.checkParametroTesoreriaDefectoToSaveAfter(this.parametrotesoreriadefecto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroTesoreriaDefecto();
			
			connexion.commit();			
			
			if(this.parametrotesoreriadefecto.getIsDeleted()) {
				this.parametrotesoreriadefecto=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveParametroTesoreriaDefecto()throws Exception {	
		try {	
			
			ParametroTesoreriaDefectoLogicAdditional.checkParametroTesoreriaDefectoToSave(this.parametrotesoreriadefecto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroTesoreriaDefectoLogicAdditional.updateParametroTesoreriaDefectoToSave(this.parametrotesoreriadefecto,this.arrDatoGeneral);
			
			ParametroTesoreriaDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametrotesoreriadefecto,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroTesoreriaDefecto(this.parametrotesoreriadefecto)) {			
				ParametroTesoreriaDefectoDataAccess.save(this.parametrotesoreriadefecto, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.parametrotesoreriadefecto,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroTesoreriaDefectoLogicAdditional.checkParametroTesoreriaDefectoToSaveAfter(this.parametrotesoreriadefecto,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.parametrotesoreriadefecto.getIsDeleted()) {
				this.parametrotesoreriadefecto=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveParametroTesoreriaDefectosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreriaDefecto.class.getSimpleName()+"-saveParametroTesoreriaDefectosWithConnection");connexion.begin();			
			
			ParametroTesoreriaDefectoLogicAdditional.checkParametroTesoreriaDefectoToSaves(parametrotesoreriadefectos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowParametroTesoreriaDefectos();
			
			Boolean validadoTodosParametroTesoreriaDefecto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroTesoreriaDefecto parametrotesoreriadefectoLocal:parametrotesoreriadefectos) {		
				if(parametrotesoreriadefectoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroTesoreriaDefectoLogicAdditional.updateParametroTesoreriaDefectoToSave(parametrotesoreriadefectoLocal,this.arrDatoGeneral);
	        	
				ParametroTesoreriaDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametrotesoreriadefectoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroTesoreriaDefecto(parametrotesoreriadefectoLocal)) {
					ParametroTesoreriaDefectoDataAccess.save(parametrotesoreriadefectoLocal, connexion);				
				} else {
					validadoTodosParametroTesoreriaDefecto=false;
				}
			}
			
			if(!validadoTodosParametroTesoreriaDefecto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroTesoreriaDefectoLogicAdditional.checkParametroTesoreriaDefectoToSavesAfter(parametrotesoreriadefectos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroTesoreriaDefectos();
			
			connexion.commit();		
			
			this.quitarParametroTesoreriaDefectosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveParametroTesoreriaDefectos()throws Exception {				
		 try {	
			ParametroTesoreriaDefectoLogicAdditional.checkParametroTesoreriaDefectoToSaves(parametrotesoreriadefectos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosParametroTesoreriaDefecto=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroTesoreriaDefecto parametrotesoreriadefectoLocal:parametrotesoreriadefectos) {				
				if(parametrotesoreriadefectoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroTesoreriaDefectoLogicAdditional.updateParametroTesoreriaDefectoToSave(parametrotesoreriadefectoLocal,this.arrDatoGeneral);
	        	
				ParametroTesoreriaDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametrotesoreriadefectoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroTesoreriaDefecto(parametrotesoreriadefectoLocal)) {				
					ParametroTesoreriaDefectoDataAccess.save(parametrotesoreriadefectoLocal, connexion);				
				} else {
					validadoTodosParametroTesoreriaDefecto=false;
				}
			}
			
			if(!validadoTodosParametroTesoreriaDefecto) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroTesoreriaDefectoLogicAdditional.checkParametroTesoreriaDefectoToSavesAfter(parametrotesoreriadefectos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarParametroTesoreriaDefectosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroTesoreriaDefectoParameterReturnGeneral procesarAccionParametroTesoreriaDefectos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroTesoreriaDefecto> parametrotesoreriadefectos,ParametroTesoreriaDefectoParameterReturnGeneral parametrotesoreriadefectoParameterGeneral)throws Exception {
		 try {	
			ParametroTesoreriaDefectoParameterReturnGeneral parametrotesoreriadefectoReturnGeneral=new ParametroTesoreriaDefectoParameterReturnGeneral();
	
			ParametroTesoreriaDefectoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametrotesoreriadefectos,parametrotesoreriadefectoParameterGeneral,parametrotesoreriadefectoReturnGeneral);
			
			return parametrotesoreriadefectoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroTesoreriaDefectoParameterReturnGeneral procesarAccionParametroTesoreriaDefectosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroTesoreriaDefecto> parametrotesoreriadefectos,ParametroTesoreriaDefectoParameterReturnGeneral parametrotesoreriadefectoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreriaDefecto.class.getSimpleName()+"-procesarAccionParametroTesoreriaDefectosWithConnection");connexion.begin();			
			
			ParametroTesoreriaDefectoParameterReturnGeneral parametrotesoreriadefectoReturnGeneral=new ParametroTesoreriaDefectoParameterReturnGeneral();
	
			ParametroTesoreriaDefectoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametrotesoreriadefectos,parametrotesoreriadefectoParameterGeneral,parametrotesoreriadefectoReturnGeneral);
			
			this.connexion.commit();
			
			return parametrotesoreriadefectoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroTesoreriaDefectoParameterReturnGeneral procesarEventosParametroTesoreriaDefectos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroTesoreriaDefecto> parametrotesoreriadefectos,ParametroTesoreriaDefecto parametrotesoreriadefecto,ParametroTesoreriaDefectoParameterReturnGeneral parametrotesoreriadefectoParameterGeneral,Boolean isEsNuevoParametroTesoreriaDefecto,ArrayList<Classe> clases)throws Exception {
		 try {	
			ParametroTesoreriaDefectoParameterReturnGeneral parametrotesoreriadefectoReturnGeneral=new ParametroTesoreriaDefectoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametrotesoreriadefectoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroTesoreriaDefectoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametrotesoreriadefectos,parametrotesoreriadefecto,parametrotesoreriadefectoParameterGeneral,parametrotesoreriadefectoReturnGeneral,isEsNuevoParametroTesoreriaDefecto,clases);
			
			return parametrotesoreriadefectoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ParametroTesoreriaDefectoParameterReturnGeneral procesarEventosParametroTesoreriaDefectosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroTesoreriaDefecto> parametrotesoreriadefectos,ParametroTesoreriaDefecto parametrotesoreriadefecto,ParametroTesoreriaDefectoParameterReturnGeneral parametrotesoreriadefectoParameterGeneral,Boolean isEsNuevoParametroTesoreriaDefecto,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreriaDefecto.class.getSimpleName()+"-procesarEventosParametroTesoreriaDefectosWithConnection");connexion.begin();			
			
			ParametroTesoreriaDefectoParameterReturnGeneral parametrotesoreriadefectoReturnGeneral=new ParametroTesoreriaDefectoParameterReturnGeneral();
	
			parametrotesoreriadefectoReturnGeneral.setParametroTesoreriaDefecto(parametrotesoreriadefecto);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametrotesoreriadefectoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroTesoreriaDefectoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametrotesoreriadefectos,parametrotesoreriadefecto,parametrotesoreriadefectoParameterGeneral,parametrotesoreriadefectoReturnGeneral,isEsNuevoParametroTesoreriaDefecto,clases);
			
			this.connexion.commit();
			
			return parametrotesoreriadefectoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroTesoreriaDefectoParameterReturnGeneral procesarImportacionParametroTesoreriaDefectosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ParametroTesoreriaDefectoParameterReturnGeneral parametrotesoreriadefectoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreriaDefecto.class.getSimpleName()+"-procesarImportacionParametroTesoreriaDefectosWithConnection");connexion.begin();			
			
			ParametroTesoreriaDefectoParameterReturnGeneral parametrotesoreriadefectoReturnGeneral=new ParametroTesoreriaDefectoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.parametrotesoreriadefectos=new ArrayList<ParametroTesoreriaDefecto>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.parametrotesoreriadefecto=new ParametroTesoreriaDefecto();
				
				
				if(conColumnasBase) {this.parametrotesoreriadefecto.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.parametrotesoreriadefecto.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				
				this.parametrotesoreriadefectos.add(this.parametrotesoreriadefecto);
			}
			
			this.saveParametroTesoreriaDefectos();
			
			this.connexion.commit();
			
			parametrotesoreriadefectoReturnGeneral.setConRetornoEstaProcesado(true);
			parametrotesoreriadefectoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return parametrotesoreriadefectoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarParametroTesoreriaDefectosEliminados() throws Exception {				
		
		List<ParametroTesoreriaDefecto> parametrotesoreriadefectosAux= new ArrayList<ParametroTesoreriaDefecto>();
		
		for(ParametroTesoreriaDefecto parametrotesoreriadefecto:parametrotesoreriadefectos) {
			if(!parametrotesoreriadefecto.getIsDeleted()) {
				parametrotesoreriadefectosAux.add(parametrotesoreriadefecto);
			}
		}
		
		parametrotesoreriadefectos=parametrotesoreriadefectosAux;
	}
	
	public void quitarParametroTesoreriaDefectosNulos() throws Exception {				
		
		List<ParametroTesoreriaDefecto> parametrotesoreriadefectosAux= new ArrayList<ParametroTesoreriaDefecto>();
		
		for(ParametroTesoreriaDefecto parametrotesoreriadefecto : this.parametrotesoreriadefectos) {
			if(parametrotesoreriadefecto==null) {
				parametrotesoreriadefectosAux.add(parametrotesoreriadefecto);
			}
		}
		
		//this.parametrotesoreriadefectos=parametrotesoreriadefectosAux;
		
		this.parametrotesoreriadefectos.removeAll(parametrotesoreriadefectosAux);
	}
	
	public void getSetVersionRowParametroTesoreriaDefectoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(parametrotesoreriadefecto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((parametrotesoreriadefecto.getIsDeleted() || (parametrotesoreriadefecto.getIsChanged()&&!parametrotesoreriadefecto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=parametrotesoreriadefectoDataAccess.getSetVersionRowParametroTesoreriaDefecto(connexion,parametrotesoreriadefecto.getId());
				
				if(!parametrotesoreriadefecto.getVersionRow().equals(timestamp)) {	
					parametrotesoreriadefecto.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				parametrotesoreriadefecto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowParametroTesoreriaDefecto()throws Exception {	
		
		if(parametrotesoreriadefecto.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((parametrotesoreriadefecto.getIsDeleted() || (parametrotesoreriadefecto.getIsChanged()&&!parametrotesoreriadefecto.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=parametrotesoreriadefectoDataAccess.getSetVersionRowParametroTesoreriaDefecto(connexion,parametrotesoreriadefecto.getId());
			
			try {							
				if(!parametrotesoreriadefecto.getVersionRow().equals(timestamp)) {	
					parametrotesoreriadefecto.setVersionRow(timestamp);
				}
				
				parametrotesoreriadefecto.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowParametroTesoreriaDefectosWithConnection()throws Exception {	
		if(parametrotesoreriadefectos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ParametroTesoreriaDefecto parametrotesoreriadefectoAux:parametrotesoreriadefectos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(parametrotesoreriadefectoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametrotesoreriadefectoAux.getIsDeleted() || (parametrotesoreriadefectoAux.getIsChanged()&&!parametrotesoreriadefectoAux.getIsNew())) {
						
						timestamp=parametrotesoreriadefectoDataAccess.getSetVersionRowParametroTesoreriaDefecto(connexion,parametrotesoreriadefectoAux.getId());
						
						if(!parametrotesoreriadefecto.getVersionRow().equals(timestamp)) {	
							parametrotesoreriadefectoAux.setVersionRow(timestamp);
						}
								
						parametrotesoreriadefectoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowParametroTesoreriaDefectos()throws Exception {	
		if(parametrotesoreriadefectos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ParametroTesoreriaDefecto parametrotesoreriadefectoAux:parametrotesoreriadefectos) {
					if(parametrotesoreriadefectoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametrotesoreriadefectoAux.getIsDeleted() || (parametrotesoreriadefectoAux.getIsChanged()&&!parametrotesoreriadefectoAux.getIsNew())) {
						
						timestamp=parametrotesoreriadefectoDataAccess.getSetVersionRowParametroTesoreriaDefecto(connexion,parametrotesoreriadefectoAux.getId());
						
						if(!parametrotesoreriadefectoAux.getVersionRow().equals(timestamp)) {	
							parametrotesoreriadefectoAux.setVersionRow(timestamp);
						}
						
													
						parametrotesoreriadefectoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ParametroTesoreriaDefectoParameterReturnGeneral cargarCombosLoteForeignKeyParametroTesoreriaDefectoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalTipoCuentaBancoGlobal) throws Exception {
		ParametroTesoreriaDefectoParameterReturnGeneral  parametrotesoreriadefectoReturnGeneral =new ParametroTesoreriaDefectoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreriaDefecto.class.getSimpleName()+"-cargarCombosLoteForeignKeyParametroTesoreriaDefectoWithConnection");connexion.begin();
			
			parametrotesoreriadefectoReturnGeneral =new ParametroTesoreriaDefectoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametrotesoreriadefectoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			parametrotesoreriadefectoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<TipoCuentaBancoGlobal> tipocuentabancoglobalsForeignKey=new ArrayList<TipoCuentaBancoGlobal>();
			TipoCuentaBancoGlobalLogic tipocuentabancoglobalLogic=new TipoCuentaBancoGlobalLogic();
			tipocuentabancoglobalLogic.setConnexion(this.connexion);
			tipocuentabancoglobalLogic.getTipoCuentaBancoGlobalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCuentaBancoGlobal.equals("NONE")) {
				tipocuentabancoglobalLogic.getTodosTipoCuentaBancoGlobals(finalQueryGlobalTipoCuentaBancoGlobal,new Pagination());
				tipocuentabancoglobalsForeignKey=tipocuentabancoglobalLogic.getTipoCuentaBancoGlobals();
			}

			parametrotesoreriadefectoReturnGeneral.settipocuentabancoglobalsForeignKey(tipocuentabancoglobalsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return parametrotesoreriadefectoReturnGeneral;
	}
	
	public ParametroTesoreriaDefectoParameterReturnGeneral cargarCombosLoteForeignKeyParametroTesoreriaDefecto(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalTipoCuentaBancoGlobal) throws Exception {
		ParametroTesoreriaDefectoParameterReturnGeneral  parametrotesoreriadefectoReturnGeneral =new ParametroTesoreriaDefectoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			parametrotesoreriadefectoReturnGeneral =new ParametroTesoreriaDefectoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametrotesoreriadefectoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			parametrotesoreriadefectoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<TipoCuentaBancoGlobal> tipocuentabancoglobalsForeignKey=new ArrayList<TipoCuentaBancoGlobal>();
			TipoCuentaBancoGlobalLogic tipocuentabancoglobalLogic=new TipoCuentaBancoGlobalLogic();
			tipocuentabancoglobalLogic.setConnexion(this.connexion);
			tipocuentabancoglobalLogic.getTipoCuentaBancoGlobalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCuentaBancoGlobal.equals("NONE")) {
				tipocuentabancoglobalLogic.getTodosTipoCuentaBancoGlobals(finalQueryGlobalTipoCuentaBancoGlobal,new Pagination());
				tipocuentabancoglobalsForeignKey=tipocuentabancoglobalLogic.getTipoCuentaBancoGlobals();
			}

			parametrotesoreriadefectoReturnGeneral.settipocuentabancoglobalsForeignKey(tipocuentabancoglobalsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return parametrotesoreriadefectoReturnGeneral;
	}
	
	
	public void deepLoad(ParametroTesoreriaDefecto parametrotesoreriadefecto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ParametroTesoreriaDefectoLogicAdditional.updateParametroTesoreriaDefectoToGet(parametrotesoreriadefecto,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametrotesoreriadefecto.setEmpresa(parametrotesoreriadefectoDataAccess.getEmpresa(connexion,parametrotesoreriadefecto));
		parametrotesoreriadefecto.setSucursal(parametrotesoreriadefectoDataAccess.getSucursal(connexion,parametrotesoreriadefecto));
		parametrotesoreriadefecto.setTipoCuentaBancoGlobal(parametrotesoreriadefectoDataAccess.getTipoCuentaBancoGlobal(connexion,parametrotesoreriadefecto));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametrotesoreriadefecto.setEmpresa(parametrotesoreriadefectoDataAccess.getEmpresa(connexion,parametrotesoreriadefecto));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				parametrotesoreriadefecto.setSucursal(parametrotesoreriadefectoDataAccess.getSucursal(connexion,parametrotesoreriadefecto));
				continue;
			}

			if(clas.clas.equals(TipoCuentaBancoGlobal.class)) {
				parametrotesoreriadefecto.setTipoCuentaBancoGlobal(parametrotesoreriadefectoDataAccess.getTipoCuentaBancoGlobal(connexion,parametrotesoreriadefecto));
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
			parametrotesoreriadefecto.setEmpresa(parametrotesoreriadefectoDataAccess.getEmpresa(connexion,parametrotesoreriadefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrotesoreriadefecto.setSucursal(parametrotesoreriadefectoDataAccess.getSucursal(connexion,parametrotesoreriadefecto));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCuentaBancoGlobal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrotesoreriadefecto.setTipoCuentaBancoGlobal(parametrotesoreriadefectoDataAccess.getTipoCuentaBancoGlobal(connexion,parametrotesoreriadefecto));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametrotesoreriadefecto.setEmpresa(parametrotesoreriadefectoDataAccess.getEmpresa(connexion,parametrotesoreriadefecto));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametrotesoreriadefecto.getEmpresa(),isDeep,deepLoadType,clases);
				
		parametrotesoreriadefecto.setSucursal(parametrotesoreriadefectoDataAccess.getSucursal(connexion,parametrotesoreriadefecto));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(parametrotesoreriadefecto.getSucursal(),isDeep,deepLoadType,clases);
				
		parametrotesoreriadefecto.setTipoCuentaBancoGlobal(parametrotesoreriadefectoDataAccess.getTipoCuentaBancoGlobal(connexion,parametrotesoreriadefecto));
		TipoCuentaBancoGlobalLogic tipocuentabancoglobalLogic= new TipoCuentaBancoGlobalLogic(connexion);
		tipocuentabancoglobalLogic.deepLoad(parametrotesoreriadefecto.getTipoCuentaBancoGlobal(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametrotesoreriadefecto.setEmpresa(parametrotesoreriadefectoDataAccess.getEmpresa(connexion,parametrotesoreriadefecto));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(parametrotesoreriadefecto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				parametrotesoreriadefecto.setSucursal(parametrotesoreriadefectoDataAccess.getSucursal(connexion,parametrotesoreriadefecto));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(parametrotesoreriadefecto.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCuentaBancoGlobal.class)) {
				parametrotesoreriadefecto.setTipoCuentaBancoGlobal(parametrotesoreriadefectoDataAccess.getTipoCuentaBancoGlobal(connexion,parametrotesoreriadefecto));
				TipoCuentaBancoGlobalLogic tipocuentabancoglobalLogic= new TipoCuentaBancoGlobalLogic(connexion);
				tipocuentabancoglobalLogic.deepLoad(parametrotesoreriadefecto.getTipoCuentaBancoGlobal(),isDeep,deepLoadType,clases);				
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
			parametrotesoreriadefecto.setEmpresa(parametrotesoreriadefectoDataAccess.getEmpresa(connexion,parametrotesoreriadefecto));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(parametrotesoreriadefecto.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrotesoreriadefecto.setSucursal(parametrotesoreriadefectoDataAccess.getSucursal(connexion,parametrotesoreriadefecto));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(parametrotesoreriadefecto.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCuentaBancoGlobal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrotesoreriadefecto.setTipoCuentaBancoGlobal(parametrotesoreriadefectoDataAccess.getTipoCuentaBancoGlobal(connexion,parametrotesoreriadefecto));
			TipoCuentaBancoGlobalLogic tipocuentabancoglobalLogic= new TipoCuentaBancoGlobalLogic(connexion);
			tipocuentabancoglobalLogic.deepLoad(parametrotesoreriadefecto.getTipoCuentaBancoGlobal(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ParametroTesoreriaDefecto parametrotesoreriadefecto,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ParametroTesoreriaDefectoLogicAdditional.updateParametroTesoreriaDefectoToSave(parametrotesoreriadefecto,this.arrDatoGeneral);
			
ParametroTesoreriaDefectoDataAccess.save(parametrotesoreriadefecto, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametrotesoreriadefecto.getEmpresa(),connexion);

		SucursalDataAccess.save(parametrotesoreriadefecto.getSucursal(),connexion);

		TipoCuentaBancoGlobalDataAccess.save(parametrotesoreriadefecto.getTipoCuentaBancoGlobal(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametrotesoreriadefecto.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(parametrotesoreriadefecto.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoCuentaBancoGlobal.class)) {
				TipoCuentaBancoGlobalDataAccess.save(parametrotesoreriadefecto.getTipoCuentaBancoGlobal(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametrotesoreriadefecto.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametrotesoreriadefecto.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(parametrotesoreriadefecto.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(parametrotesoreriadefecto.getSucursal(),isDeep,deepLoadType,clases);
				

		TipoCuentaBancoGlobalDataAccess.save(parametrotesoreriadefecto.getTipoCuentaBancoGlobal(),connexion);
		TipoCuentaBancoGlobalLogic tipocuentabancoglobalLogic= new TipoCuentaBancoGlobalLogic(connexion);
		tipocuentabancoglobalLogic.deepLoad(parametrotesoreriadefecto.getTipoCuentaBancoGlobal(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametrotesoreriadefecto.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(parametrotesoreriadefecto.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(parametrotesoreriadefecto.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(parametrotesoreriadefecto.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCuentaBancoGlobal.class)) {
				TipoCuentaBancoGlobalDataAccess.save(parametrotesoreriadefecto.getTipoCuentaBancoGlobal(),connexion);
				TipoCuentaBancoGlobalLogic tipocuentabancoglobalLogic= new TipoCuentaBancoGlobalLogic(connexion);
				tipocuentabancoglobalLogic.deepSave(parametrotesoreriadefecto.getTipoCuentaBancoGlobal(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ParametroTesoreriaDefecto.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(parametrotesoreriadefecto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroTesoreriaDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreriaDefecto(parametrotesoreriadefecto);
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
			this.deepLoad(this.parametrotesoreriadefecto,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroTesoreriaDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreriaDefecto(this.parametrotesoreriadefecto);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ParametroTesoreriaDefecto.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(parametrotesoreriadefectos!=null) {
				for(ParametroTesoreriaDefecto parametrotesoreriadefecto:parametrotesoreriadefectos) {
					this.deepLoad(parametrotesoreriadefecto,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ParametroTesoreriaDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreriaDefecto(parametrotesoreriadefectos);
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
			if(parametrotesoreriadefectos!=null) {
				for(ParametroTesoreriaDefecto parametrotesoreriadefecto:parametrotesoreriadefectos) {
					this.deepLoad(parametrotesoreriadefecto,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ParametroTesoreriaDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreriaDefecto(parametrotesoreriadefectos);
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
			this.getNewConnexionToDeep(ParametroTesoreriaDefecto.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(parametrotesoreriadefecto,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ParametroTesoreriaDefecto.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(parametrotesoreriadefectos!=null) {
				for(ParametroTesoreriaDefecto parametrotesoreriadefecto:parametrotesoreriadefectos) {
					this.deepSave(parametrotesoreriadefecto,isDeep,deepLoadType,clases);
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
			if(parametrotesoreriadefectos!=null) {
				for(ParametroTesoreriaDefecto parametrotesoreriadefecto:parametrotesoreriadefectos) {
					this.deepSave(parametrotesoreriadefecto,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getParametroTesoreriaDefectosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreriaDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroTesoreriaDefectoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroTesoreriaDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrotesoreriadefectos=parametrotesoreriadefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroTesoreriaDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreriaDefecto(this.parametrotesoreriadefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroTesoreriaDefectosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroTesoreriaDefectoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroTesoreriaDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrotesoreriadefectos=parametrotesoreriadefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroTesoreriaDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreriaDefecto(this.parametrotesoreriadefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroTesoreriaDefectosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreriaDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ParametroTesoreriaDefectoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ParametroTesoreriaDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrotesoreriadefectos=parametrotesoreriadefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroTesoreriaDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreriaDefecto(this.parametrotesoreriadefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroTesoreriaDefectosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,ParametroTesoreriaDefectoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			ParametroTesoreriaDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrotesoreriadefectos=parametrotesoreriadefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroTesoreriaDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreriaDefecto(this.parametrotesoreriadefectos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroTesoreriaDefectosFK_IdTipoCuentaBancoGlobalWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_cuenta_banco_global)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreriaDefecto.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCuentaBancoGlobal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCuentaBancoGlobal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cuenta_banco_global,ParametroTesoreriaDefectoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCuentaBancoGlobal);

			ParametroTesoreriaDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCuentaBancoGlobal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrotesoreriadefectos=parametrotesoreriadefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroTesoreriaDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreriaDefecto(this.parametrotesoreriadefectos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroTesoreriaDefectosFK_IdTipoCuentaBancoGlobal(String sFinalQuery,Pagination pagination,Long id_tipo_cuenta_banco_global)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCuentaBancoGlobal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCuentaBancoGlobal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_cuenta_banco_global,ParametroTesoreriaDefectoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCuentaBancoGlobal);

			ParametroTesoreriaDefectoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCuentaBancoGlobal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrotesoreriadefectos=parametrotesoreriadefectoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroTesoreriaDefectoConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreriaDefecto(this.parametrotesoreriadefectos);
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
			if(ParametroTesoreriaDefectoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroTesoreriaDefectoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ParametroTesoreriaDefecto parametrotesoreriadefecto,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ParametroTesoreriaDefectoConstantesFunciones.ISCONAUDITORIA) {
				if(parametrotesoreriadefecto.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroTesoreriaDefectoDataAccess.TABLENAME, parametrotesoreriadefecto.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroTesoreriaDefectoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroTesoreriaDefectoLogic.registrarAuditoriaDetallesParametroTesoreriaDefecto(connexion,parametrotesoreriadefecto,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(parametrotesoreriadefecto.getIsDeleted()) {
					/*if(!parametrotesoreriadefecto.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ParametroTesoreriaDefectoDataAccess.TABLENAME, parametrotesoreriadefecto.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ParametroTesoreriaDefectoLogic.registrarAuditoriaDetallesParametroTesoreriaDefecto(connexion,parametrotesoreriadefecto,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroTesoreriaDefectoDataAccess.TABLENAME, parametrotesoreriadefecto.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(parametrotesoreriadefecto.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroTesoreriaDefectoDataAccess.TABLENAME, parametrotesoreriadefecto.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroTesoreriaDefectoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroTesoreriaDefectoLogic.registrarAuditoriaDetallesParametroTesoreriaDefecto(connexion,parametrotesoreriadefecto,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesParametroTesoreriaDefecto(Connexion connexion,ParametroTesoreriaDefecto parametrotesoreriadefecto)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(parametrotesoreriadefecto.getIsNew()||!parametrotesoreriadefecto.getid_empresa().equals(parametrotesoreriadefecto.getParametroTesoreriaDefectoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrotesoreriadefecto.getParametroTesoreriaDefectoOriginal().getid_empresa()!=null)
				{
					strValorActual=parametrotesoreriadefecto.getParametroTesoreriaDefectoOriginal().getid_empresa().toString();
				}
				if(parametrotesoreriadefecto.getid_empresa()!=null)
				{
					strValorNuevo=parametrotesoreriadefecto.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroTesoreriaDefectoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(parametrotesoreriadefecto.getIsNew()||!parametrotesoreriadefecto.getid_sucursal().equals(parametrotesoreriadefecto.getParametroTesoreriaDefectoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrotesoreriadefecto.getParametroTesoreriaDefectoOriginal().getid_sucursal()!=null)
				{
					strValorActual=parametrotesoreriadefecto.getParametroTesoreriaDefectoOriginal().getid_sucursal().toString();
				}
				if(parametrotesoreriadefecto.getid_sucursal()!=null)
				{
					strValorNuevo=parametrotesoreriadefecto.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroTesoreriaDefectoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(parametrotesoreriadefecto.getIsNew()||!parametrotesoreriadefecto.getid_tipo_cuenta_banco_global().equals(parametrotesoreriadefecto.getParametroTesoreriaDefectoOriginal().getid_tipo_cuenta_banco_global()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrotesoreriadefecto.getParametroTesoreriaDefectoOriginal().getid_tipo_cuenta_banco_global()!=null)
				{
					strValorActual=parametrotesoreriadefecto.getParametroTesoreriaDefectoOriginal().getid_tipo_cuenta_banco_global().toString();
				}
				if(parametrotesoreriadefecto.getid_tipo_cuenta_banco_global()!=null)
				{
					strValorNuevo=parametrotesoreriadefecto.getid_tipo_cuenta_banco_global().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroTesoreriaDefectoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveParametroTesoreriaDefectoRelacionesWithConnection(ParametroTesoreriaDefecto parametrotesoreriadefecto) throws Exception {

		if(!parametrotesoreriadefecto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroTesoreriaDefectoRelacionesBase(parametrotesoreriadefecto,true);
		}
	}

	public void saveParametroTesoreriaDefectoRelaciones(ParametroTesoreriaDefecto parametrotesoreriadefecto)throws Exception {

		if(!parametrotesoreriadefecto.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroTesoreriaDefectoRelacionesBase(parametrotesoreriadefecto,false);
		}
	}

	public void saveParametroTesoreriaDefectoRelacionesBase(ParametroTesoreriaDefecto parametrotesoreriadefecto,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ParametroTesoreriaDefecto-saveRelacionesWithConnection");}
	

			this.setParametroTesoreriaDefecto(parametrotesoreriadefecto);

			if(ParametroTesoreriaDefectoLogicAdditional.validarSaveRelaciones(parametrotesoreriadefecto,this)) {

				ParametroTesoreriaDefectoLogicAdditional.updateRelacionesToSave(parametrotesoreriadefecto,this);

				if((parametrotesoreriadefecto.getIsNew()||parametrotesoreriadefecto.getIsChanged())&&!parametrotesoreriadefecto.getIsDeleted()) {
					this.saveParametroTesoreriaDefecto();
					this.saveParametroTesoreriaDefectoRelacionesDetalles();

				} else if(parametrotesoreriadefecto.getIsDeleted()) {
					this.saveParametroTesoreriaDefectoRelacionesDetalles();
					this.saveParametroTesoreriaDefecto();
				}

				ParametroTesoreriaDefectoLogicAdditional.updateRelacionesToSaveAfter(parametrotesoreriadefecto,this);

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
	
	
	private void saveParametroTesoreriaDefectoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfParametroTesoreriaDefecto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroTesoreriaDefectoConstantesFunciones.getClassesForeignKeysOfParametroTesoreriaDefecto(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroTesoreriaDefecto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroTesoreriaDefectoConstantesFunciones.getClassesRelationshipsOfParametroTesoreriaDefecto(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

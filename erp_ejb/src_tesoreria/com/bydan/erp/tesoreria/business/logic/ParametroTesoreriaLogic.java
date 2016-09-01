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
import com.bydan.erp.tesoreria.util.ParametroTesoreriaConstantesFunciones;
import com.bydan.erp.tesoreria.util.ParametroTesoreriaParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.ParametroTesoreriaParameterGeneral;
import com.bydan.erp.tesoreria.business.entity.ParametroTesoreria;
import com.bydan.erp.tesoreria.business.logic.ParametroTesoreriaLogicAdditional;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class ParametroTesoreriaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ParametroTesoreriaLogic.class);
	
	protected ParametroTesoreriaDataAccess parametrotesoreriaDataAccess; 	
	protected ParametroTesoreria parametrotesoreria;
	protected List<ParametroTesoreria> parametrotesorerias;
	protected Object parametrotesoreriaObject;	
	protected List<Object> parametrotesoreriasObject;
	
	public static ClassValidator<ParametroTesoreria> parametrotesoreriaValidator = new ClassValidator<ParametroTesoreria>(ParametroTesoreria.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ParametroTesoreriaLogicAdditional parametrotesoreriaLogicAdditional=null;
	
	public ParametroTesoreriaLogicAdditional getParametroTesoreriaLogicAdditional() {
		return this.parametrotesoreriaLogicAdditional;
	}
	
	public void setParametroTesoreriaLogicAdditional(ParametroTesoreriaLogicAdditional parametrotesoreriaLogicAdditional) {
		try {
			this.parametrotesoreriaLogicAdditional=parametrotesoreriaLogicAdditional;
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
	
	
	
	
	public  ParametroTesoreriaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.parametrotesoreriaDataAccess = new ParametroTesoreriaDataAccess();
			
			this.parametrotesorerias= new ArrayList<ParametroTesoreria>();
			this.parametrotesoreria= new ParametroTesoreria();
			
			this.parametrotesoreriaObject=new Object();
			this.parametrotesoreriasObject=new ArrayList<Object>();
				
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
			
			this.parametrotesoreriaDataAccess.setConnexionType(this.connexionType);
			this.parametrotesoreriaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ParametroTesoreriaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.parametrotesoreriaDataAccess = new ParametroTesoreriaDataAccess();
			this.parametrotesorerias= new ArrayList<ParametroTesoreria>();
			this.parametrotesoreria= new ParametroTesoreria();
			this.parametrotesoreriaObject=new Object();
			this.parametrotesoreriasObject=new ArrayList<Object>();
			
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
			
			this.parametrotesoreriaDataAccess.setConnexionType(this.connexionType);
			this.parametrotesoreriaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ParametroTesoreria getParametroTesoreria() throws Exception {	
		ParametroTesoreriaLogicAdditional.checkParametroTesoreriaToGet(parametrotesoreria,this.datosCliente,this.arrDatoGeneral);
		ParametroTesoreriaLogicAdditional.updateParametroTesoreriaToGet(parametrotesoreria,this.arrDatoGeneral);
		
		return parametrotesoreria;
	}
		
	public void setParametroTesoreria(ParametroTesoreria newParametroTesoreria) {
		this.parametrotesoreria = newParametroTesoreria;
	}
	
	public ParametroTesoreriaDataAccess getParametroTesoreriaDataAccess() {
		return parametrotesoreriaDataAccess;
	}
	
	public void setParametroTesoreriaDataAccess(ParametroTesoreriaDataAccess newparametrotesoreriaDataAccess) {
		this.parametrotesoreriaDataAccess = newparametrotesoreriaDataAccess;
	}
	
	public List<ParametroTesoreria> getParametroTesorerias() throws Exception {		
		this.quitarParametroTesoreriasNulos();
		
		ParametroTesoreriaLogicAdditional.checkParametroTesoreriaToGets(parametrotesorerias,this.datosCliente,this.arrDatoGeneral);
		
		for (ParametroTesoreria parametrotesoreriaLocal: parametrotesorerias ) {
			ParametroTesoreriaLogicAdditional.updateParametroTesoreriaToGet(parametrotesoreriaLocal,this.arrDatoGeneral);
		}
		
		return parametrotesorerias;
	}
	
	public void setParametroTesorerias(List<ParametroTesoreria> newParametroTesorerias) {
		this.parametrotesorerias = newParametroTesorerias;
	}
	
	public Object getParametroTesoreriaObject() {	
		this.parametrotesoreriaObject=this.parametrotesoreriaDataAccess.getEntityObject();
		return this.parametrotesoreriaObject;
	}
		
	public void setParametroTesoreriaObject(Object newParametroTesoreriaObject) {
		this.parametrotesoreriaObject = newParametroTesoreriaObject;
	}
	
	public List<Object> getParametroTesoreriasObject() {		
		this.parametrotesoreriasObject=this.parametrotesoreriaDataAccess.getEntitiesObject();
		return this.parametrotesoreriasObject;
	}
		
	public void setParametroTesoreriasObject(List<Object> newParametroTesoreriasObject) {
		this.parametrotesoreriasObject = newParametroTesoreriasObject;
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
		
		if(this.parametrotesoreriaDataAccess!=null) {
			this.parametrotesoreriaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreria.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			parametrotesoreriaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			parametrotesoreriaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		parametrotesoreria = new  ParametroTesoreria();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreria.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametrotesoreria=parametrotesoreriaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrotesoreria,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroTesoreriaConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreria(this.parametrotesoreria);
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
		parametrotesoreria = new  ParametroTesoreria();
		  		  
        try {
			
			parametrotesoreria=parametrotesoreriaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrotesoreria,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroTesoreriaConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreria(this.parametrotesoreria);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		parametrotesoreria = new  ParametroTesoreria();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreria.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			parametrotesoreria=parametrotesoreriaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrotesoreria,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroTesoreriaConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreria(this.parametrotesoreria);
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
		parametrotesoreria = new  ParametroTesoreria();
		  		  
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
		parametrotesoreria = new  ParametroTesoreria();
		  		  
        try {
			
			parametrotesoreria=parametrotesoreriaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.parametrotesoreria,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ParametroTesoreriaConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreria(this.parametrotesoreria);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		parametrotesoreria = new  ParametroTesoreria();
		  		  
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
		parametrotesoreria = new  ParametroTesoreria();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreria.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =parametrotesoreriaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrotesoreria = new  ParametroTesoreria();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=parametrotesoreriaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametrotesoreria = new  ParametroTesoreria();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreria.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =parametrotesoreriaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrotesoreria = new  ParametroTesoreria();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=parametrotesoreriaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		parametrotesoreria = new  ParametroTesoreria();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreria.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =parametrotesoreriaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		parametrotesoreria = new  ParametroTesoreria();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=parametrotesoreriaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametrotesorerias = new  ArrayList<ParametroTesoreria>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreria.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ParametroTesoreriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrotesorerias=parametrotesoreriaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroTesoreria(parametrotesorerias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroTesoreriaConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreria(this.parametrotesorerias);
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
		parametrotesorerias = new  ArrayList<ParametroTesoreria>();
		  		  
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
		parametrotesorerias = new  ArrayList<ParametroTesoreria>();
		  		  
        try {			
			ParametroTesoreriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrotesorerias=parametrotesoreriaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarParametroTesoreria(parametrotesorerias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroTesoreriaConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreria(this.parametrotesorerias);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		parametrotesorerias = new  ArrayList<ParametroTesoreria>();
		  		  
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
		parametrotesorerias = new  ArrayList<ParametroTesoreria>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreria.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ParametroTesoreriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrotesorerias=parametrotesoreriaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroTesoreria(parametrotesorerias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroTesoreriaConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreria(this.parametrotesorerias);
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
		parametrotesorerias = new  ArrayList<ParametroTesoreria>();
		  		  
        try {
			ParametroTesoreriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrotesorerias=parametrotesoreriaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroTesoreria(parametrotesorerias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroTesoreriaConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreria(this.parametrotesorerias);
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
		parametrotesorerias = new  ArrayList<ParametroTesoreria>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreria.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroTesoreriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrotesorerias=parametrotesoreriaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroTesoreria(parametrotesorerias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroTesoreriaConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreria(this.parametrotesorerias);
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
		parametrotesorerias = new  ArrayList<ParametroTesoreria>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroTesoreriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrotesorerias=parametrotesoreriaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroTesoreria(parametrotesorerias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroTesoreriaConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreria(this.parametrotesorerias);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		parametrotesoreria = new  ParametroTesoreria();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreria.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroTesoreriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrotesoreria=parametrotesoreriaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroTesoreria(parametrotesoreria);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroTesoreriaConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreria(this.parametrotesoreria);
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
		parametrotesoreria = new  ParametroTesoreria();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroTesoreriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrotesoreria=parametrotesoreriaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarParametroTesoreria(parametrotesoreria);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroTesoreriaConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreria(this.parametrotesoreria);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		parametrotesorerias = new  ArrayList<ParametroTesoreria>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreria.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ParametroTesoreriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrotesorerias=parametrotesoreriaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroTesoreria(parametrotesorerias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroTesoreriaConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreria(this.parametrotesorerias);
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
		parametrotesorerias = new  ArrayList<ParametroTesoreria>();
		  		  
        try {
			ParametroTesoreriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrotesorerias=parametrotesoreriaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarParametroTesoreria(parametrotesorerias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroTesoreriaConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreria(this.parametrotesorerias);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosParametroTesoreriasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		parametrotesorerias = new  ArrayList<ParametroTesoreria>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreria.class.getSimpleName()+"-getTodosParametroTesoreriasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroTesoreriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrotesorerias=parametrotesoreriaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroTesoreria(parametrotesorerias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroTesoreriaConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreria(this.parametrotesorerias);
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
	
	public  void  getTodosParametroTesorerias(String sFinalQuery,Pagination pagination)throws Exception {
		parametrotesorerias = new  ArrayList<ParametroTesoreria>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ParametroTesoreriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			parametrotesorerias=parametrotesoreriaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarParametroTesoreria(parametrotesorerias);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ParametroTesoreriaConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreria(this.parametrotesorerias);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarParametroTesoreria(ParametroTesoreria parametrotesoreria) throws Exception {
		Boolean estaValidado=false;
		
		if(parametrotesoreria.getIsNew() || parametrotesoreria.getIsChanged()) { 
			this.invalidValues = parametrotesoreriaValidator.getInvalidValues(parametrotesoreria);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(parametrotesoreria);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarParametroTesoreria(List<ParametroTesoreria> ParametroTesorerias) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ParametroTesoreria parametrotesoreriaLocal:parametrotesorerias) {				
			estaValidadoObjeto=this.validarGuardarParametroTesoreria(parametrotesoreriaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarParametroTesoreria(List<ParametroTesoreria> ParametroTesorerias) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroTesoreria(parametrotesorerias)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarParametroTesoreria(ParametroTesoreria ParametroTesoreria) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarParametroTesoreria(parametrotesoreria)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ParametroTesoreria parametrotesoreria) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+parametrotesoreria.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ParametroTesoreriaConstantesFunciones.getParametroTesoreriaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"parametrotesoreria","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ParametroTesoreriaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ParametroTesoreriaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveParametroTesoreriaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreria.class.getSimpleName()+"-saveParametroTesoreriaWithConnection");connexion.begin();			
			
			ParametroTesoreriaLogicAdditional.checkParametroTesoreriaToSave(this.parametrotesoreria,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroTesoreriaLogicAdditional.updateParametroTesoreriaToSave(this.parametrotesoreria,this.arrDatoGeneral);
			
			ParametroTesoreriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametrotesoreria,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowParametroTesoreria();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroTesoreria(this.parametrotesoreria)) {
				ParametroTesoreriaDataAccess.save(this.parametrotesoreria, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.parametrotesoreria,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroTesoreriaLogicAdditional.checkParametroTesoreriaToSaveAfter(this.parametrotesoreria,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroTesoreria();
			
			connexion.commit();			
			
			if(this.parametrotesoreria.getIsDeleted()) {
				this.parametrotesoreria=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveParametroTesoreria()throws Exception {	
		try {	
			
			ParametroTesoreriaLogicAdditional.checkParametroTesoreriaToSave(this.parametrotesoreria,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ParametroTesoreriaLogicAdditional.updateParametroTesoreriaToSave(this.parametrotesoreria,this.arrDatoGeneral);
			
			ParametroTesoreriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.parametrotesoreria,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarParametroTesoreria(this.parametrotesoreria)) {			
				ParametroTesoreriaDataAccess.save(this.parametrotesoreria, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.parametrotesoreria,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ParametroTesoreriaLogicAdditional.checkParametroTesoreriaToSaveAfter(this.parametrotesoreria,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.parametrotesoreria.getIsDeleted()) {
				this.parametrotesoreria=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveParametroTesoreriasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreria.class.getSimpleName()+"-saveParametroTesoreriasWithConnection");connexion.begin();			
			
			ParametroTesoreriaLogicAdditional.checkParametroTesoreriaToSaves(parametrotesorerias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowParametroTesorerias();
			
			Boolean validadoTodosParametroTesoreria=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroTesoreria parametrotesoreriaLocal:parametrotesorerias) {		
				if(parametrotesoreriaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroTesoreriaLogicAdditional.updateParametroTesoreriaToSave(parametrotesoreriaLocal,this.arrDatoGeneral);
	        	
				ParametroTesoreriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametrotesoreriaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroTesoreria(parametrotesoreriaLocal)) {
					ParametroTesoreriaDataAccess.save(parametrotesoreriaLocal, connexion);				
				} else {
					validadoTodosParametroTesoreria=false;
				}
			}
			
			if(!validadoTodosParametroTesoreria) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroTesoreriaLogicAdditional.checkParametroTesoreriaToSavesAfter(parametrotesorerias,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowParametroTesorerias();
			
			connexion.commit();		
			
			this.quitarParametroTesoreriasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveParametroTesorerias()throws Exception {				
		 try {	
			ParametroTesoreriaLogicAdditional.checkParametroTesoreriaToSaves(parametrotesorerias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosParametroTesoreria=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ParametroTesoreria parametrotesoreriaLocal:parametrotesorerias) {				
				if(parametrotesoreriaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ParametroTesoreriaLogicAdditional.updateParametroTesoreriaToSave(parametrotesoreriaLocal,this.arrDatoGeneral);
	        	
				ParametroTesoreriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),parametrotesoreriaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarParametroTesoreria(parametrotesoreriaLocal)) {				
					ParametroTesoreriaDataAccess.save(parametrotesoreriaLocal, connexion);				
				} else {
					validadoTodosParametroTesoreria=false;
				}
			}
			
			if(!validadoTodosParametroTesoreria) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ParametroTesoreriaLogicAdditional.checkParametroTesoreriaToSavesAfter(parametrotesorerias,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarParametroTesoreriasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroTesoreriaParameterReturnGeneral procesarAccionParametroTesorerias(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroTesoreria> parametrotesorerias,ParametroTesoreriaParameterReturnGeneral parametrotesoreriaParameterGeneral)throws Exception {
		 try {	
			ParametroTesoreriaParameterReturnGeneral parametrotesoreriaReturnGeneral=new ParametroTesoreriaParameterReturnGeneral();
	
			ParametroTesoreriaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametrotesorerias,parametrotesoreriaParameterGeneral,parametrotesoreriaReturnGeneral);
			
			return parametrotesoreriaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ParametroTesoreriaParameterReturnGeneral procesarAccionParametroTesoreriasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ParametroTesoreria> parametrotesorerias,ParametroTesoreriaParameterReturnGeneral parametrotesoreriaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreria.class.getSimpleName()+"-procesarAccionParametroTesoreriasWithConnection");connexion.begin();			
			
			ParametroTesoreriaParameterReturnGeneral parametrotesoreriaReturnGeneral=new ParametroTesoreriaParameterReturnGeneral();
	
			ParametroTesoreriaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,parametrotesorerias,parametrotesoreriaParameterGeneral,parametrotesoreriaReturnGeneral);
			
			this.connexion.commit();
			
			return parametrotesoreriaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroTesoreriaParameterReturnGeneral procesarEventosParametroTesorerias(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroTesoreria> parametrotesorerias,ParametroTesoreria parametrotesoreria,ParametroTesoreriaParameterReturnGeneral parametrotesoreriaParameterGeneral,Boolean isEsNuevoParametroTesoreria,ArrayList<Classe> clases)throws Exception {
		 try {	
			ParametroTesoreriaParameterReturnGeneral parametrotesoreriaReturnGeneral=new ParametroTesoreriaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametrotesoreriaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroTesoreriaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametrotesorerias,parametrotesoreria,parametrotesoreriaParameterGeneral,parametrotesoreriaReturnGeneral,isEsNuevoParametroTesoreria,clases);
			
			return parametrotesoreriaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ParametroTesoreriaParameterReturnGeneral procesarEventosParametroTesoreriasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ParametroTesoreria> parametrotesorerias,ParametroTesoreria parametrotesoreria,ParametroTesoreriaParameterReturnGeneral parametrotesoreriaParameterGeneral,Boolean isEsNuevoParametroTesoreria,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreria.class.getSimpleName()+"-procesarEventosParametroTesoreriasWithConnection");connexion.begin();			
			
			ParametroTesoreriaParameterReturnGeneral parametrotesoreriaReturnGeneral=new ParametroTesoreriaParameterReturnGeneral();
	
			parametrotesoreriaReturnGeneral.setParametroTesoreria(parametrotesoreria);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				parametrotesoreriaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ParametroTesoreriaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,parametrotesorerias,parametrotesoreria,parametrotesoreriaParameterGeneral,parametrotesoreriaReturnGeneral,isEsNuevoParametroTesoreria,clases);
			
			this.connexion.commit();
			
			return parametrotesoreriaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ParametroTesoreriaParameterReturnGeneral procesarImportacionParametroTesoreriasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ParametroTesoreriaParameterReturnGeneral parametrotesoreriaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreria.class.getSimpleName()+"-procesarImportacionParametroTesoreriasWithConnection");connexion.begin();			
			
			ParametroTesoreriaParameterReturnGeneral parametrotesoreriaReturnGeneral=new ParametroTesoreriaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.parametrotesorerias=new ArrayList<ParametroTesoreria>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.parametrotesoreria=new ParametroTesoreria();
				
				
				if(conColumnasBase) {this.parametrotesoreria.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.parametrotesoreria.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.parametrotesoreria.setcon_anticipo_orden_compra(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrotesoreria.setpor_lotes(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.parametrotesoreria.setdescripcion(arrColumnas[iColumn++]);
				
				this.parametrotesorerias.add(this.parametrotesoreria);
			}
			
			this.saveParametroTesorerias();
			
			this.connexion.commit();
			
			parametrotesoreriaReturnGeneral.setConRetornoEstaProcesado(true);
			parametrotesoreriaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return parametrotesoreriaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarParametroTesoreriasEliminados() throws Exception {				
		
		List<ParametroTesoreria> parametrotesoreriasAux= new ArrayList<ParametroTesoreria>();
		
		for(ParametroTesoreria parametrotesoreria:parametrotesorerias) {
			if(!parametrotesoreria.getIsDeleted()) {
				parametrotesoreriasAux.add(parametrotesoreria);
			}
		}
		
		parametrotesorerias=parametrotesoreriasAux;
	}
	
	public void quitarParametroTesoreriasNulos() throws Exception {				
		
		List<ParametroTesoreria> parametrotesoreriasAux= new ArrayList<ParametroTesoreria>();
		
		for(ParametroTesoreria parametrotesoreria : this.parametrotesorerias) {
			if(parametrotesoreria==null) {
				parametrotesoreriasAux.add(parametrotesoreria);
			}
		}
		
		//this.parametrotesorerias=parametrotesoreriasAux;
		
		this.parametrotesorerias.removeAll(parametrotesoreriasAux);
	}
	
	public void getSetVersionRowParametroTesoreriaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(parametrotesoreria.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((parametrotesoreria.getIsDeleted() || (parametrotesoreria.getIsChanged()&&!parametrotesoreria.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=parametrotesoreriaDataAccess.getSetVersionRowParametroTesoreria(connexion,parametrotesoreria.getId());
				
				if(!parametrotesoreria.getVersionRow().equals(timestamp)) {	
					parametrotesoreria.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				parametrotesoreria.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowParametroTesoreria()throws Exception {	
		
		if(parametrotesoreria.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((parametrotesoreria.getIsDeleted() || (parametrotesoreria.getIsChanged()&&!parametrotesoreria.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=parametrotesoreriaDataAccess.getSetVersionRowParametroTesoreria(connexion,parametrotesoreria.getId());
			
			try {							
				if(!parametrotesoreria.getVersionRow().equals(timestamp)) {	
					parametrotesoreria.setVersionRow(timestamp);
				}
				
				parametrotesoreria.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowParametroTesoreriasWithConnection()throws Exception {	
		if(parametrotesorerias!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ParametroTesoreria parametrotesoreriaAux:parametrotesorerias) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(parametrotesoreriaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametrotesoreriaAux.getIsDeleted() || (parametrotesoreriaAux.getIsChanged()&&!parametrotesoreriaAux.getIsNew())) {
						
						timestamp=parametrotesoreriaDataAccess.getSetVersionRowParametroTesoreria(connexion,parametrotesoreriaAux.getId());
						
						if(!parametrotesoreria.getVersionRow().equals(timestamp)) {	
							parametrotesoreriaAux.setVersionRow(timestamp);
						}
								
						parametrotesoreriaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowParametroTesorerias()throws Exception {	
		if(parametrotesorerias!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ParametroTesoreria parametrotesoreriaAux:parametrotesorerias) {
					if(parametrotesoreriaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(parametrotesoreriaAux.getIsDeleted() || (parametrotesoreriaAux.getIsChanged()&&!parametrotesoreriaAux.getIsNew())) {
						
						timestamp=parametrotesoreriaDataAccess.getSetVersionRowParametroTesoreria(connexion,parametrotesoreriaAux.getId());
						
						if(!parametrotesoreriaAux.getVersionRow().equals(timestamp)) {	
							parametrotesoreriaAux.setVersionRow(timestamp);
						}
						
													
						parametrotesoreriaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ParametroTesoreriaParameterReturnGeneral cargarCombosLoteForeignKeyParametroTesoreriaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalTransaccionCobrarPago,String finalQueryGlobalTransaccionCobrarDebito,String finalQueryGlobalTransaccionCobrarCredito,String finalQueryGlobalTransaccionPagarPago,String finalQueryGlobalTransaccionPagarDebito,String finalQueryGlobalTransaccionPagarCredito) throws Exception {
		ParametroTesoreriaParameterReturnGeneral  parametrotesoreriaReturnGeneral =new ParametroTesoreriaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreria.class.getSimpleName()+"-cargarCombosLoteForeignKeyParametroTesoreriaWithConnection");connexion.begin();
			
			parametrotesoreriaReturnGeneral =new ParametroTesoreriaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametrotesoreriaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Transaccion> transaccioncobrarpagosForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccioncobrarpagoLogic=new TransaccionLogic();
			transaccioncobrarpagoLogic.setConnexion(this.connexion);
			transaccioncobrarpagoLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionCobrarPago.equals("NONE")) {
				transaccioncobrarpagoLogic.getTodosTransaccions(finalQueryGlobalTransaccionCobrarPago,new Pagination());
				transaccioncobrarpagosForeignKey=transaccioncobrarpagoLogic.getTransaccions();
			}

			parametrotesoreriaReturnGeneral.settransaccioncobrarpagosForeignKey(transaccioncobrarpagosForeignKey);


			List<Transaccion> transaccioncobrardebitosForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccioncobrardebitoLogic=new TransaccionLogic();
			transaccioncobrardebitoLogic.setConnexion(this.connexion);
			transaccioncobrardebitoLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionCobrarDebito.equals("NONE")) {
				transaccioncobrardebitoLogic.getTodosTransaccions(finalQueryGlobalTransaccionCobrarDebito,new Pagination());
				transaccioncobrardebitosForeignKey=transaccioncobrardebitoLogic.getTransaccions();
			}

			parametrotesoreriaReturnGeneral.settransaccioncobrardebitosForeignKey(transaccioncobrardebitosForeignKey);


			List<Transaccion> transaccioncobrarcreditosForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccioncobrarcreditoLogic=new TransaccionLogic();
			transaccioncobrarcreditoLogic.setConnexion(this.connexion);
			transaccioncobrarcreditoLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionCobrarCredito.equals("NONE")) {
				transaccioncobrarcreditoLogic.getTodosTransaccions(finalQueryGlobalTransaccionCobrarCredito,new Pagination());
				transaccioncobrarcreditosForeignKey=transaccioncobrarcreditoLogic.getTransaccions();
			}

			parametrotesoreriaReturnGeneral.settransaccioncobrarcreditosForeignKey(transaccioncobrarcreditosForeignKey);


			List<Transaccion> transaccionpagarpagosForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionpagarpagoLogic=new TransaccionLogic();
			transaccionpagarpagoLogic.setConnexion(this.connexion);
			transaccionpagarpagoLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionPagarPago.equals("NONE")) {
				transaccionpagarpagoLogic.getTodosTransaccions(finalQueryGlobalTransaccionPagarPago,new Pagination());
				transaccionpagarpagosForeignKey=transaccionpagarpagoLogic.getTransaccions();
			}

			parametrotesoreriaReturnGeneral.settransaccionpagarpagosForeignKey(transaccionpagarpagosForeignKey);


			List<Transaccion> transaccionpagardebitosForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionpagardebitoLogic=new TransaccionLogic();
			transaccionpagardebitoLogic.setConnexion(this.connexion);
			transaccionpagardebitoLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionPagarDebito.equals("NONE")) {
				transaccionpagardebitoLogic.getTodosTransaccions(finalQueryGlobalTransaccionPagarDebito,new Pagination());
				transaccionpagardebitosForeignKey=transaccionpagardebitoLogic.getTransaccions();
			}

			parametrotesoreriaReturnGeneral.settransaccionpagardebitosForeignKey(transaccionpagardebitosForeignKey);


			List<Transaccion> transaccionpagarcreditosForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionpagarcreditoLogic=new TransaccionLogic();
			transaccionpagarcreditoLogic.setConnexion(this.connexion);
			transaccionpagarcreditoLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionPagarCredito.equals("NONE")) {
				transaccionpagarcreditoLogic.getTodosTransaccions(finalQueryGlobalTransaccionPagarCredito,new Pagination());
				transaccionpagarcreditosForeignKey=transaccionpagarcreditoLogic.getTransaccions();
			}

			parametrotesoreriaReturnGeneral.settransaccionpagarcreditosForeignKey(transaccionpagarcreditosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return parametrotesoreriaReturnGeneral;
	}
	
	public ParametroTesoreriaParameterReturnGeneral cargarCombosLoteForeignKeyParametroTesoreria(String finalQueryGlobalEmpresa,String finalQueryGlobalTransaccionCobrarPago,String finalQueryGlobalTransaccionCobrarDebito,String finalQueryGlobalTransaccionCobrarCredito,String finalQueryGlobalTransaccionPagarPago,String finalQueryGlobalTransaccionPagarDebito,String finalQueryGlobalTransaccionPagarCredito) throws Exception {
		ParametroTesoreriaParameterReturnGeneral  parametrotesoreriaReturnGeneral =new ParametroTesoreriaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			parametrotesoreriaReturnGeneral =new ParametroTesoreriaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			parametrotesoreriaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Transaccion> transaccioncobrarpagosForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccioncobrarpagoLogic=new TransaccionLogic();
			transaccioncobrarpagoLogic.setConnexion(this.connexion);
			transaccioncobrarpagoLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionCobrarPago.equals("NONE")) {
				transaccioncobrarpagoLogic.getTodosTransaccions(finalQueryGlobalTransaccionCobrarPago,new Pagination());
				transaccioncobrarpagosForeignKey=transaccioncobrarpagoLogic.getTransaccions();
			}

			parametrotesoreriaReturnGeneral.settransaccioncobrarpagosForeignKey(transaccioncobrarpagosForeignKey);


			List<Transaccion> transaccioncobrardebitosForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccioncobrardebitoLogic=new TransaccionLogic();
			transaccioncobrardebitoLogic.setConnexion(this.connexion);
			transaccioncobrardebitoLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionCobrarDebito.equals("NONE")) {
				transaccioncobrardebitoLogic.getTodosTransaccions(finalQueryGlobalTransaccionCobrarDebito,new Pagination());
				transaccioncobrardebitosForeignKey=transaccioncobrardebitoLogic.getTransaccions();
			}

			parametrotesoreriaReturnGeneral.settransaccioncobrardebitosForeignKey(transaccioncobrardebitosForeignKey);


			List<Transaccion> transaccioncobrarcreditosForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccioncobrarcreditoLogic=new TransaccionLogic();
			transaccioncobrarcreditoLogic.setConnexion(this.connexion);
			transaccioncobrarcreditoLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionCobrarCredito.equals("NONE")) {
				transaccioncobrarcreditoLogic.getTodosTransaccions(finalQueryGlobalTransaccionCobrarCredito,new Pagination());
				transaccioncobrarcreditosForeignKey=transaccioncobrarcreditoLogic.getTransaccions();
			}

			parametrotesoreriaReturnGeneral.settransaccioncobrarcreditosForeignKey(transaccioncobrarcreditosForeignKey);


			List<Transaccion> transaccionpagarpagosForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionpagarpagoLogic=new TransaccionLogic();
			transaccionpagarpagoLogic.setConnexion(this.connexion);
			transaccionpagarpagoLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionPagarPago.equals("NONE")) {
				transaccionpagarpagoLogic.getTodosTransaccions(finalQueryGlobalTransaccionPagarPago,new Pagination());
				transaccionpagarpagosForeignKey=transaccionpagarpagoLogic.getTransaccions();
			}

			parametrotesoreriaReturnGeneral.settransaccionpagarpagosForeignKey(transaccionpagarpagosForeignKey);


			List<Transaccion> transaccionpagardebitosForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionpagardebitoLogic=new TransaccionLogic();
			transaccionpagardebitoLogic.setConnexion(this.connexion);
			transaccionpagardebitoLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionPagarDebito.equals("NONE")) {
				transaccionpagardebitoLogic.getTodosTransaccions(finalQueryGlobalTransaccionPagarDebito,new Pagination());
				transaccionpagardebitosForeignKey=transaccionpagardebitoLogic.getTransaccions();
			}

			parametrotesoreriaReturnGeneral.settransaccionpagardebitosForeignKey(transaccionpagardebitosForeignKey);


			List<Transaccion> transaccionpagarcreditosForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionpagarcreditoLogic=new TransaccionLogic();
			transaccionpagarcreditoLogic.setConnexion(this.connexion);
			transaccionpagarcreditoLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccionPagarCredito.equals("NONE")) {
				transaccionpagarcreditoLogic.getTodosTransaccions(finalQueryGlobalTransaccionPagarCredito,new Pagination());
				transaccionpagarcreditosForeignKey=transaccionpagarcreditoLogic.getTransaccions();
			}

			parametrotesoreriaReturnGeneral.settransaccionpagarcreditosForeignKey(transaccionpagarcreditosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return parametrotesoreriaReturnGeneral;
	}
	
	
	public void deepLoad(ParametroTesoreria parametrotesoreria,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ParametroTesoreriaLogicAdditional.updateParametroTesoreriaToGet(parametrotesoreria,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametrotesoreria.setEmpresa(parametrotesoreriaDataAccess.getEmpresa(connexion,parametrotesoreria));
		parametrotesoreria.setTransaccionCobrarPago(parametrotesoreriaDataAccess.getTransaccionCobrarPago(connexion,parametrotesoreria));
		parametrotesoreria.setTransaccionCobrarDebito(parametrotesoreriaDataAccess.getTransaccionCobrarDebito(connexion,parametrotesoreria));
		parametrotesoreria.setTransaccionCobrarCredito(parametrotesoreriaDataAccess.getTransaccionCobrarCredito(connexion,parametrotesoreria));
		parametrotesoreria.setTransaccionPagarPago(parametrotesoreriaDataAccess.getTransaccionPagarPago(connexion,parametrotesoreria));
		parametrotesoreria.setTransaccionPagarDebito(parametrotesoreriaDataAccess.getTransaccionPagarDebito(connexion,parametrotesoreria));
		parametrotesoreria.setTransaccionPagarCredito(parametrotesoreriaDataAccess.getTransaccionPagarCredito(connexion,parametrotesoreria));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametrotesoreria.setEmpresa(parametrotesoreriaDataAccess.getEmpresa(connexion,parametrotesoreria));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrotesoreria.setTransaccionCobrarPago(parametrotesoreriaDataAccess.getTransaccionCobrarPago(connexion,parametrotesoreria));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrotesoreria.setTransaccionCobrarDebito(parametrotesoreriaDataAccess.getTransaccionCobrarDebito(connexion,parametrotesoreria));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrotesoreria.setTransaccionCobrarCredito(parametrotesoreriaDataAccess.getTransaccionCobrarCredito(connexion,parametrotesoreria));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrotesoreria.setTransaccionPagarPago(parametrotesoreriaDataAccess.getTransaccionPagarPago(connexion,parametrotesoreria));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrotesoreria.setTransaccionPagarDebito(parametrotesoreriaDataAccess.getTransaccionPagarDebito(connexion,parametrotesoreria));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrotesoreria.setTransaccionPagarCredito(parametrotesoreriaDataAccess.getTransaccionPagarCredito(connexion,parametrotesoreria));
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
			parametrotesoreria.setEmpresa(parametrotesoreriaDataAccess.getEmpresa(connexion,parametrotesoreria));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrotesoreria.setTransaccionCobrarPago(parametrotesoreriaDataAccess.getTransaccionCobrarPago(connexion,parametrotesoreria));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrotesoreria.setTransaccionCobrarDebito(parametrotesoreriaDataAccess.getTransaccionCobrarDebito(connexion,parametrotesoreria));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrotesoreria.setTransaccionCobrarCredito(parametrotesoreriaDataAccess.getTransaccionCobrarCredito(connexion,parametrotesoreria));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrotesoreria.setTransaccionPagarPago(parametrotesoreriaDataAccess.getTransaccionPagarPago(connexion,parametrotesoreria));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrotesoreria.setTransaccionPagarDebito(parametrotesoreriaDataAccess.getTransaccionPagarDebito(connexion,parametrotesoreria));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrotesoreria.setTransaccionPagarCredito(parametrotesoreriaDataAccess.getTransaccionPagarCredito(connexion,parametrotesoreria));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		parametrotesoreria.setEmpresa(parametrotesoreriaDataAccess.getEmpresa(connexion,parametrotesoreria));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametrotesoreria.getEmpresa(),isDeep,deepLoadType,clases);
				
		parametrotesoreria.setTransaccionCobrarPago(parametrotesoreriaDataAccess.getTransaccionCobrarPago(connexion,parametrotesoreria));
		TransaccionLogic transaccioncobrarpagoLogic= new TransaccionLogic(connexion);
		transaccioncobrarpagoLogic.deepLoad(parametrotesoreria.getTransaccionCobrarPago(),isDeep,deepLoadType,clases);
				
		parametrotesoreria.setTransaccionCobrarDebito(parametrotesoreriaDataAccess.getTransaccionCobrarDebito(connexion,parametrotesoreria));
		TransaccionLogic transaccioncobrardebitoLogic= new TransaccionLogic(connexion);
		transaccioncobrardebitoLogic.deepLoad(parametrotesoreria.getTransaccionCobrarDebito(),isDeep,deepLoadType,clases);
				
		parametrotesoreria.setTransaccionCobrarCredito(parametrotesoreriaDataAccess.getTransaccionCobrarCredito(connexion,parametrotesoreria));
		TransaccionLogic transaccioncobrarcreditoLogic= new TransaccionLogic(connexion);
		transaccioncobrarcreditoLogic.deepLoad(parametrotesoreria.getTransaccionCobrarCredito(),isDeep,deepLoadType,clases);
				
		parametrotesoreria.setTransaccionPagarPago(parametrotesoreriaDataAccess.getTransaccionPagarPago(connexion,parametrotesoreria));
		TransaccionLogic transaccionpagarpagoLogic= new TransaccionLogic(connexion);
		transaccionpagarpagoLogic.deepLoad(parametrotesoreria.getTransaccionPagarPago(),isDeep,deepLoadType,clases);
				
		parametrotesoreria.setTransaccionPagarDebito(parametrotesoreriaDataAccess.getTransaccionPagarDebito(connexion,parametrotesoreria));
		TransaccionLogic transaccionpagardebitoLogic= new TransaccionLogic(connexion);
		transaccionpagardebitoLogic.deepLoad(parametrotesoreria.getTransaccionPagarDebito(),isDeep,deepLoadType,clases);
				
		parametrotesoreria.setTransaccionPagarCredito(parametrotesoreriaDataAccess.getTransaccionPagarCredito(connexion,parametrotesoreria));
		TransaccionLogic transaccionpagarcreditoLogic= new TransaccionLogic(connexion);
		transaccionpagarcreditoLogic.deepLoad(parametrotesoreria.getTransaccionPagarCredito(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				parametrotesoreria.setEmpresa(parametrotesoreriaDataAccess.getEmpresa(connexion,parametrotesoreria));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(parametrotesoreria.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrotesoreria.setTransaccionCobrarPago(parametrotesoreriaDataAccess.getTransaccionCobrarPago(connexion,parametrotesoreria));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(parametrotesoreria.getTransaccionCobrarPago(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrotesoreria.setTransaccionCobrarDebito(parametrotesoreriaDataAccess.getTransaccionCobrarDebito(connexion,parametrotesoreria));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(parametrotesoreria.getTransaccionCobrarDebito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrotesoreria.setTransaccionCobrarCredito(parametrotesoreriaDataAccess.getTransaccionCobrarCredito(connexion,parametrotesoreria));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(parametrotesoreria.getTransaccionCobrarCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrotesoreria.setTransaccionPagarPago(parametrotesoreriaDataAccess.getTransaccionPagarPago(connexion,parametrotesoreria));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(parametrotesoreria.getTransaccionPagarPago(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrotesoreria.setTransaccionPagarDebito(parametrotesoreriaDataAccess.getTransaccionPagarDebito(connexion,parametrotesoreria));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(parametrotesoreria.getTransaccionPagarDebito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				parametrotesoreria.setTransaccionPagarCredito(parametrotesoreriaDataAccess.getTransaccionPagarCredito(connexion,parametrotesoreria));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(parametrotesoreria.getTransaccionPagarCredito(),isDeep,deepLoadType,clases);				
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
			parametrotesoreria.setEmpresa(parametrotesoreriaDataAccess.getEmpresa(connexion,parametrotesoreria));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(parametrotesoreria.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrotesoreria.setTransaccionCobrarPago(parametrotesoreriaDataAccess.getTransaccionCobrarPago(connexion,parametrotesoreria));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(parametrotesoreria.getTransaccionCobrarPago(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrotesoreria.setTransaccionCobrarDebito(parametrotesoreriaDataAccess.getTransaccionCobrarDebito(connexion,parametrotesoreria));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(parametrotesoreria.getTransaccionCobrarDebito(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrotesoreria.setTransaccionCobrarCredito(parametrotesoreriaDataAccess.getTransaccionCobrarCredito(connexion,parametrotesoreria));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(parametrotesoreria.getTransaccionCobrarCredito(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrotesoreria.setTransaccionPagarPago(parametrotesoreriaDataAccess.getTransaccionPagarPago(connexion,parametrotesoreria));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(parametrotesoreria.getTransaccionPagarPago(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrotesoreria.setTransaccionPagarDebito(parametrotesoreriaDataAccess.getTransaccionPagarDebito(connexion,parametrotesoreria));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(parametrotesoreria.getTransaccionPagarDebito(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			parametrotesoreria.setTransaccionPagarCredito(parametrotesoreriaDataAccess.getTransaccionPagarCredito(connexion,parametrotesoreria));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(parametrotesoreria.getTransaccionPagarCredito(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ParametroTesoreria parametrotesoreria,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ParametroTesoreriaLogicAdditional.updateParametroTesoreriaToSave(parametrotesoreria,this.arrDatoGeneral);
			
ParametroTesoreriaDataAccess.save(parametrotesoreria, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametrotesoreria.getEmpresa(),connexion);

		TransaccionDataAccess.save(parametrotesoreria.getTransaccionCobrarPago(),connexion);

		TransaccionDataAccess.save(parametrotesoreria.getTransaccionCobrarDebito(),connexion);

		TransaccionDataAccess.save(parametrotesoreria.getTransaccionCobrarCredito(),connexion);

		TransaccionDataAccess.save(parametrotesoreria.getTransaccionPagarPago(),connexion);

		TransaccionDataAccess.save(parametrotesoreria.getTransaccionPagarDebito(),connexion);

		TransaccionDataAccess.save(parametrotesoreria.getTransaccionPagarCredito(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametrotesoreria.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrotesoreria.getTransaccionCobrarPago(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrotesoreria.getTransaccionCobrarDebito(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrotesoreria.getTransaccionCobrarCredito(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrotesoreria.getTransaccionPagarPago(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrotesoreria.getTransaccionPagarDebito(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrotesoreria.getTransaccionPagarCredito(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(parametrotesoreria.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(parametrotesoreria.getEmpresa(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(parametrotesoreria.getTransaccionCobrarPago(),connexion);
		TransaccionLogic transaccioncobrarpagoLogic= new TransaccionLogic(connexion);
		transaccioncobrarpagoLogic.deepLoad(parametrotesoreria.getTransaccionCobrarPago(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(parametrotesoreria.getTransaccionCobrarDebito(),connexion);
		TransaccionLogic transaccioncobrardebitoLogic= new TransaccionLogic(connexion);
		transaccioncobrardebitoLogic.deepLoad(parametrotesoreria.getTransaccionCobrarDebito(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(parametrotesoreria.getTransaccionCobrarCredito(),connexion);
		TransaccionLogic transaccioncobrarcreditoLogic= new TransaccionLogic(connexion);
		transaccioncobrarcreditoLogic.deepLoad(parametrotesoreria.getTransaccionCobrarCredito(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(parametrotesoreria.getTransaccionPagarPago(),connexion);
		TransaccionLogic transaccionpagarpagoLogic= new TransaccionLogic(connexion);
		transaccionpagarpagoLogic.deepLoad(parametrotesoreria.getTransaccionPagarPago(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(parametrotesoreria.getTransaccionPagarDebito(),connexion);
		TransaccionLogic transaccionpagardebitoLogic= new TransaccionLogic(connexion);
		transaccionpagardebitoLogic.deepLoad(parametrotesoreria.getTransaccionPagarDebito(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(parametrotesoreria.getTransaccionPagarCredito(),connexion);
		TransaccionLogic transaccionpagarcreditoLogic= new TransaccionLogic(connexion);
		transaccionpagarcreditoLogic.deepLoad(parametrotesoreria.getTransaccionPagarCredito(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(parametrotesoreria.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(parametrotesoreria.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrotesoreria.getTransaccionCobrarPago(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(parametrotesoreria.getTransaccionCobrarPago(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrotesoreria.getTransaccionCobrarDebito(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(parametrotesoreria.getTransaccionCobrarDebito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrotesoreria.getTransaccionCobrarCredito(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(parametrotesoreria.getTransaccionCobrarCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrotesoreria.getTransaccionPagarPago(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(parametrotesoreria.getTransaccionPagarPago(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrotesoreria.getTransaccionPagarDebito(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(parametrotesoreria.getTransaccionPagarDebito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(parametrotesoreria.getTransaccionPagarCredito(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(parametrotesoreria.getTransaccionPagarCredito(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ParametroTesoreria.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(parametrotesoreria,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroTesoreriaConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreria(parametrotesoreria);
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
			this.deepLoad(this.parametrotesoreria,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ParametroTesoreriaConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreria(this.parametrotesoreria);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ParametroTesoreria.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(parametrotesorerias!=null) {
				for(ParametroTesoreria parametrotesoreria:parametrotesorerias) {
					this.deepLoad(parametrotesoreria,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ParametroTesoreriaConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreria(parametrotesorerias);
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
			if(parametrotesorerias!=null) {
				for(ParametroTesoreria parametrotesoreria:parametrotesorerias) {
					this.deepLoad(parametrotesoreria,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ParametroTesoreriaConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreria(parametrotesorerias);
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
			this.getNewConnexionToDeep(ParametroTesoreria.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(parametrotesoreria,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ParametroTesoreria.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(parametrotesorerias!=null) {
				for(ParametroTesoreria parametrotesoreria:parametrotesorerias) {
					this.deepSave(parametrotesoreria,isDeep,deepLoadType,clases);
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
			if(parametrotesorerias!=null) {
				for(ParametroTesoreria parametrotesoreria:parametrotesorerias) {
					this.deepSave(parametrotesoreria,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getParametroTesoreriasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreria.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroTesoreriaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroTesoreriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrotesorerias=parametrotesoreriaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroTesoreriaConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreria(this.parametrotesorerias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroTesoreriasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ParametroTesoreriaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParametroTesoreriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrotesorerias=parametrotesoreriaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroTesoreriaConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreria(this.parametrotesorerias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroTesoreriasFK_IdTransaccionCobrarCreditoWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion_cobrar_credito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreria.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionCobrarCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionCobrarCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_cobrar_credito,ParametroTesoreriaConstantesFunciones.IDTRANSACCIONCOBRARCREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionCobrarCredito);

			ParametroTesoreriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionCobrarCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrotesorerias=parametrotesoreriaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroTesoreriaConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreria(this.parametrotesorerias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroTesoreriasFK_IdTransaccionCobrarCredito(String sFinalQuery,Pagination pagination,Long id_transaccion_cobrar_credito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionCobrarCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionCobrarCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_cobrar_credito,ParametroTesoreriaConstantesFunciones.IDTRANSACCIONCOBRARCREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionCobrarCredito);

			ParametroTesoreriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionCobrarCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrotesorerias=parametrotesoreriaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroTesoreriaConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreria(this.parametrotesorerias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroTesoreriasFK_IdTransaccionCobrarDebitoWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion_cobrar_debito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreria.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionCobrarDebito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionCobrarDebito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_cobrar_debito,ParametroTesoreriaConstantesFunciones.IDTRANSACCIONCOBRARDEBITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionCobrarDebito);

			ParametroTesoreriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionCobrarDebito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrotesorerias=parametrotesoreriaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroTesoreriaConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreria(this.parametrotesorerias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroTesoreriasFK_IdTransaccionCobrarDebito(String sFinalQuery,Pagination pagination,Long id_transaccion_cobrar_debito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionCobrarDebito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionCobrarDebito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_cobrar_debito,ParametroTesoreriaConstantesFunciones.IDTRANSACCIONCOBRARDEBITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionCobrarDebito);

			ParametroTesoreriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionCobrarDebito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrotesorerias=parametrotesoreriaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroTesoreriaConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreria(this.parametrotesorerias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroTesoreriasFK_IdTransaccionCobrarPagoWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion_cobrar_pago)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreria.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionCobrarPago= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionCobrarPago.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_cobrar_pago,ParametroTesoreriaConstantesFunciones.IDTRANSACCIONCOBRARPAGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionCobrarPago);

			ParametroTesoreriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionCobrarPago","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrotesorerias=parametrotesoreriaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroTesoreriaConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreria(this.parametrotesorerias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroTesoreriasFK_IdTransaccionCobrarPago(String sFinalQuery,Pagination pagination,Long id_transaccion_cobrar_pago)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionCobrarPago= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionCobrarPago.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_cobrar_pago,ParametroTesoreriaConstantesFunciones.IDTRANSACCIONCOBRARPAGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionCobrarPago);

			ParametroTesoreriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionCobrarPago","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrotesorerias=parametrotesoreriaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroTesoreriaConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreria(this.parametrotesorerias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroTesoreriasFK_IdTransaccionPagarCreditoWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion_pagar_credito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreria.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionPagarCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionPagarCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_pagar_credito,ParametroTesoreriaConstantesFunciones.IDTRANSACCIONPAGARCREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionPagarCredito);

			ParametroTesoreriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionPagarCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrotesorerias=parametrotesoreriaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroTesoreriaConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreria(this.parametrotesorerias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroTesoreriasFK_IdTransaccionPagarCredito(String sFinalQuery,Pagination pagination,Long id_transaccion_pagar_credito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionPagarCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionPagarCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_pagar_credito,ParametroTesoreriaConstantesFunciones.IDTRANSACCIONPAGARCREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionPagarCredito);

			ParametroTesoreriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionPagarCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrotesorerias=parametrotesoreriaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroTesoreriaConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreria(this.parametrotesorerias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroTesoreriasFK_IdTransaccionPagarDebitoWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion_pagar_debito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreria.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionPagarDebito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionPagarDebito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_pagar_debito,ParametroTesoreriaConstantesFunciones.IDTRANSACCIONPAGARDEBITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionPagarDebito);

			ParametroTesoreriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionPagarDebito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrotesorerias=parametrotesoreriaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroTesoreriaConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreria(this.parametrotesorerias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroTesoreriasFK_IdTransaccionPagarDebito(String sFinalQuery,Pagination pagination,Long id_transaccion_pagar_debito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionPagarDebito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionPagarDebito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_pagar_debito,ParametroTesoreriaConstantesFunciones.IDTRANSACCIONPAGARDEBITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionPagarDebito);

			ParametroTesoreriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionPagarDebito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrotesorerias=parametrotesoreriaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroTesoreriaConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreria(this.parametrotesorerias);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getParametroTesoreriasFK_IdTransaccionPagarPagoWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion_pagar_pago)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ParametroTesoreria.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionPagarPago= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionPagarPago.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_pagar_pago,ParametroTesoreriaConstantesFunciones.IDTRANSACCIONPAGARPAGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionPagarPago);

			ParametroTesoreriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionPagarPago","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrotesorerias=parametrotesoreriaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroTesoreriaConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreria(this.parametrotesorerias);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getParametroTesoreriasFK_IdTransaccionPagarPago(String sFinalQuery,Pagination pagination,Long id_transaccion_pagar_pago)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccionPagarPago= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccionPagarPago.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion_pagar_pago,ParametroTesoreriaConstantesFunciones.IDTRANSACCIONPAGARPAGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccionPagarPago);

			ParametroTesoreriaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccionPagarPago","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			parametrotesorerias=parametrotesoreriaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ParametroTesoreriaConstantesFunciones.refrescarForeignKeysDescripcionesParametroTesoreria(this.parametrotesorerias);
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
			if(ParametroTesoreriaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroTesoreriaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ParametroTesoreria parametrotesoreria,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ParametroTesoreriaConstantesFunciones.ISCONAUDITORIA) {
				if(parametrotesoreria.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroTesoreriaDataAccess.TABLENAME, parametrotesoreria.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroTesoreriaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroTesoreriaLogic.registrarAuditoriaDetallesParametroTesoreria(connexion,parametrotesoreria,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(parametrotesoreria.getIsDeleted()) {
					/*if(!parametrotesoreria.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ParametroTesoreriaDataAccess.TABLENAME, parametrotesoreria.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ParametroTesoreriaLogic.registrarAuditoriaDetallesParametroTesoreria(connexion,parametrotesoreria,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroTesoreriaDataAccess.TABLENAME, parametrotesoreria.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(parametrotesoreria.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ParametroTesoreriaDataAccess.TABLENAME, parametrotesoreria.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ParametroTesoreriaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ParametroTesoreriaLogic.registrarAuditoriaDetallesParametroTesoreria(connexion,parametrotesoreria,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesParametroTesoreria(Connexion connexion,ParametroTesoreria parametrotesoreria)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(parametrotesoreria.getIsNew()||!parametrotesoreria.getid_empresa().equals(parametrotesoreria.getParametroTesoreriaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrotesoreria.getParametroTesoreriaOriginal().getid_empresa()!=null)
				{
					strValorActual=parametrotesoreria.getParametroTesoreriaOriginal().getid_empresa().toString();
				}
				if(parametrotesoreria.getid_empresa()!=null)
				{
					strValorNuevo=parametrotesoreria.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroTesoreriaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(parametrotesoreria.getIsNew()||!parametrotesoreria.getcon_anticipo_orden_compra().equals(parametrotesoreria.getParametroTesoreriaOriginal().getcon_anticipo_orden_compra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrotesoreria.getParametroTesoreriaOriginal().getcon_anticipo_orden_compra()!=null)
				{
					strValorActual=parametrotesoreria.getParametroTesoreriaOriginal().getcon_anticipo_orden_compra().toString();
				}
				if(parametrotesoreria.getcon_anticipo_orden_compra()!=null)
				{
					strValorNuevo=parametrotesoreria.getcon_anticipo_orden_compra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroTesoreriaConstantesFunciones.CONANTICIPOORDENCOMPRA,strValorActual,strValorNuevo);
			}	
			
			if(parametrotesoreria.getIsNew()||!parametrotesoreria.getpor_lotes().equals(parametrotesoreria.getParametroTesoreriaOriginal().getpor_lotes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrotesoreria.getParametroTesoreriaOriginal().getpor_lotes()!=null)
				{
					strValorActual=parametrotesoreria.getParametroTesoreriaOriginal().getpor_lotes().toString();
				}
				if(parametrotesoreria.getpor_lotes()!=null)
				{
					strValorNuevo=parametrotesoreria.getpor_lotes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroTesoreriaConstantesFunciones.PORLOTES,strValorActual,strValorNuevo);
			}	
			
			if(parametrotesoreria.getIsNew()||!parametrotesoreria.getid_transaccion_cobrar_pago().equals(parametrotesoreria.getParametroTesoreriaOriginal().getid_transaccion_cobrar_pago()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrotesoreria.getParametroTesoreriaOriginal().getid_transaccion_cobrar_pago()!=null)
				{
					strValorActual=parametrotesoreria.getParametroTesoreriaOriginal().getid_transaccion_cobrar_pago().toString();
				}
				if(parametrotesoreria.getid_transaccion_cobrar_pago()!=null)
				{
					strValorNuevo=parametrotesoreria.getid_transaccion_cobrar_pago().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroTesoreriaConstantesFunciones.IDTRANSACCIONCOBRARPAGO,strValorActual,strValorNuevo);
			}	
			
			if(parametrotesoreria.getIsNew()||!parametrotesoreria.getid_transaccion_cobrar_debito().equals(parametrotesoreria.getParametroTesoreriaOriginal().getid_transaccion_cobrar_debito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrotesoreria.getParametroTesoreriaOriginal().getid_transaccion_cobrar_debito()!=null)
				{
					strValorActual=parametrotesoreria.getParametroTesoreriaOriginal().getid_transaccion_cobrar_debito().toString();
				}
				if(parametrotesoreria.getid_transaccion_cobrar_debito()!=null)
				{
					strValorNuevo=parametrotesoreria.getid_transaccion_cobrar_debito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroTesoreriaConstantesFunciones.IDTRANSACCIONCOBRARDEBITO,strValorActual,strValorNuevo);
			}	
			
			if(parametrotesoreria.getIsNew()||!parametrotesoreria.getid_transaccion_cobrar_credito().equals(parametrotesoreria.getParametroTesoreriaOriginal().getid_transaccion_cobrar_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrotesoreria.getParametroTesoreriaOriginal().getid_transaccion_cobrar_credito()!=null)
				{
					strValorActual=parametrotesoreria.getParametroTesoreriaOriginal().getid_transaccion_cobrar_credito().toString();
				}
				if(parametrotesoreria.getid_transaccion_cobrar_credito()!=null)
				{
					strValorNuevo=parametrotesoreria.getid_transaccion_cobrar_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroTesoreriaConstantesFunciones.IDTRANSACCIONCOBRARCREDITO,strValorActual,strValorNuevo);
			}	
			
			if(parametrotesoreria.getIsNew()||!parametrotesoreria.getid_transaccion_pagar_pago().equals(parametrotesoreria.getParametroTesoreriaOriginal().getid_transaccion_pagar_pago()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrotesoreria.getParametroTesoreriaOriginal().getid_transaccion_pagar_pago()!=null)
				{
					strValorActual=parametrotesoreria.getParametroTesoreriaOriginal().getid_transaccion_pagar_pago().toString();
				}
				if(parametrotesoreria.getid_transaccion_pagar_pago()!=null)
				{
					strValorNuevo=parametrotesoreria.getid_transaccion_pagar_pago().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroTesoreriaConstantesFunciones.IDTRANSACCIONPAGARPAGO,strValorActual,strValorNuevo);
			}	
			
			if(parametrotesoreria.getIsNew()||!parametrotesoreria.getid_transaccion_pagar_debito().equals(parametrotesoreria.getParametroTesoreriaOriginal().getid_transaccion_pagar_debito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrotesoreria.getParametroTesoreriaOriginal().getid_transaccion_pagar_debito()!=null)
				{
					strValorActual=parametrotesoreria.getParametroTesoreriaOriginal().getid_transaccion_pagar_debito().toString();
				}
				if(parametrotesoreria.getid_transaccion_pagar_debito()!=null)
				{
					strValorNuevo=parametrotesoreria.getid_transaccion_pagar_debito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroTesoreriaConstantesFunciones.IDTRANSACCIONPAGARDEBITO,strValorActual,strValorNuevo);
			}	
			
			if(parametrotesoreria.getIsNew()||!parametrotesoreria.getid_transaccion_pagar_credito().equals(parametrotesoreria.getParametroTesoreriaOriginal().getid_transaccion_pagar_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrotesoreria.getParametroTesoreriaOriginal().getid_transaccion_pagar_credito()!=null)
				{
					strValorActual=parametrotesoreria.getParametroTesoreriaOriginal().getid_transaccion_pagar_credito().toString();
				}
				if(parametrotesoreria.getid_transaccion_pagar_credito()!=null)
				{
					strValorNuevo=parametrotesoreria.getid_transaccion_pagar_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroTesoreriaConstantesFunciones.IDTRANSACCIONPAGARCREDITO,strValorActual,strValorNuevo);
			}	
			
			if(parametrotesoreria.getIsNew()||!parametrotesoreria.getdescripcion().equals(parametrotesoreria.getParametroTesoreriaOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(parametrotesoreria.getParametroTesoreriaOriginal().getdescripcion()!=null)
				{
					strValorActual=parametrotesoreria.getParametroTesoreriaOriginal().getdescripcion();
				}
				if(parametrotesoreria.getdescripcion()!=null)
				{
					strValorNuevo=parametrotesoreria.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ParametroTesoreriaConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveParametroTesoreriaRelacionesWithConnection(ParametroTesoreria parametrotesoreria) throws Exception {

		if(!parametrotesoreria.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroTesoreriaRelacionesBase(parametrotesoreria,true);
		}
	}

	public void saveParametroTesoreriaRelaciones(ParametroTesoreria parametrotesoreria)throws Exception {

		if(!parametrotesoreria.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveParametroTesoreriaRelacionesBase(parametrotesoreria,false);
		}
	}

	public void saveParametroTesoreriaRelacionesBase(ParametroTesoreria parametrotesoreria,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ParametroTesoreria-saveRelacionesWithConnection");}
	

			this.setParametroTesoreria(parametrotesoreria);

			if(ParametroTesoreriaLogicAdditional.validarSaveRelaciones(parametrotesoreria,this)) {

				ParametroTesoreriaLogicAdditional.updateRelacionesToSave(parametrotesoreria,this);

				if((parametrotesoreria.getIsNew()||parametrotesoreria.getIsChanged())&&!parametrotesoreria.getIsDeleted()) {
					this.saveParametroTesoreria();
					this.saveParametroTesoreriaRelacionesDetalles();

				} else if(parametrotesoreria.getIsDeleted()) {
					this.saveParametroTesoreriaRelacionesDetalles();
					this.saveParametroTesoreria();
				}

				ParametroTesoreriaLogicAdditional.updateRelacionesToSaveAfter(parametrotesoreria,this);

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
	
	
	private void saveParametroTesoreriaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfParametroTesoreria(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroTesoreriaConstantesFunciones.getClassesForeignKeysOfParametroTesoreria(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroTesoreria(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ParametroTesoreriaConstantesFunciones.getClassesRelationshipsOfParametroTesoreria(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

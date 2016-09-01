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
package com.bydan.erp.nomina.business.logic;

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
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.nomina.util.TipoCalificacionEmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.TipoCalificacionEmpleadoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoCalificacionEmpleadoParameterGeneral;
import com.bydan.erp.nomina.business.entity.TipoCalificacionEmpleado;
import com.bydan.erp.nomina.business.logic.TipoCalificacionEmpleadoLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoCalificacionEmpleadoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoCalificacionEmpleadoLogic.class);
	
	protected TipoCalificacionEmpleadoDataAccess tipocalificacionempleadoDataAccess; 	
	protected TipoCalificacionEmpleado tipocalificacionempleado;
	protected List<TipoCalificacionEmpleado> tipocalificacionempleados;
	protected Object tipocalificacionempleadoObject;	
	protected List<Object> tipocalificacionempleadosObject;
	
	public static ClassValidator<TipoCalificacionEmpleado> tipocalificacionempleadoValidator = new ClassValidator<TipoCalificacionEmpleado>(TipoCalificacionEmpleado.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoCalificacionEmpleadoLogicAdditional tipocalificacionempleadoLogicAdditional=null;
	
	public TipoCalificacionEmpleadoLogicAdditional getTipoCalificacionEmpleadoLogicAdditional() {
		return this.tipocalificacionempleadoLogicAdditional;
	}
	
	public void setTipoCalificacionEmpleadoLogicAdditional(TipoCalificacionEmpleadoLogicAdditional tipocalificacionempleadoLogicAdditional) {
		try {
			this.tipocalificacionempleadoLogicAdditional=tipocalificacionempleadoLogicAdditional;
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
	
	
	
	
	public  TipoCalificacionEmpleadoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipocalificacionempleadoDataAccess = new TipoCalificacionEmpleadoDataAccess();
			
			this.tipocalificacionempleados= new ArrayList<TipoCalificacionEmpleado>();
			this.tipocalificacionempleado= new TipoCalificacionEmpleado();
			
			this.tipocalificacionempleadoObject=new Object();
			this.tipocalificacionempleadosObject=new ArrayList<Object>();
				
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
			
			this.tipocalificacionempleadoDataAccess.setConnexionType(this.connexionType);
			this.tipocalificacionempleadoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoCalificacionEmpleadoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipocalificacionempleadoDataAccess = new TipoCalificacionEmpleadoDataAccess();
			this.tipocalificacionempleados= new ArrayList<TipoCalificacionEmpleado>();
			this.tipocalificacionempleado= new TipoCalificacionEmpleado();
			this.tipocalificacionempleadoObject=new Object();
			this.tipocalificacionempleadosObject=new ArrayList<Object>();
			
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
			
			this.tipocalificacionempleadoDataAccess.setConnexionType(this.connexionType);
			this.tipocalificacionempleadoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoCalificacionEmpleado getTipoCalificacionEmpleado() throws Exception {	
		TipoCalificacionEmpleadoLogicAdditional.checkTipoCalificacionEmpleadoToGet(tipocalificacionempleado,this.datosCliente,this.arrDatoGeneral);
		TipoCalificacionEmpleadoLogicAdditional.updateTipoCalificacionEmpleadoToGet(tipocalificacionempleado,this.arrDatoGeneral);
		
		return tipocalificacionempleado;
	}
		
	public void setTipoCalificacionEmpleado(TipoCalificacionEmpleado newTipoCalificacionEmpleado) {
		this.tipocalificacionempleado = newTipoCalificacionEmpleado;
	}
	
	public TipoCalificacionEmpleadoDataAccess getTipoCalificacionEmpleadoDataAccess() {
		return tipocalificacionempleadoDataAccess;
	}
	
	public void setTipoCalificacionEmpleadoDataAccess(TipoCalificacionEmpleadoDataAccess newtipocalificacionempleadoDataAccess) {
		this.tipocalificacionempleadoDataAccess = newtipocalificacionempleadoDataAccess;
	}
	
	public List<TipoCalificacionEmpleado> getTipoCalificacionEmpleados() throws Exception {		
		this.quitarTipoCalificacionEmpleadosNulos();
		
		TipoCalificacionEmpleadoLogicAdditional.checkTipoCalificacionEmpleadoToGets(tipocalificacionempleados,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoCalificacionEmpleado tipocalificacionempleadoLocal: tipocalificacionempleados ) {
			TipoCalificacionEmpleadoLogicAdditional.updateTipoCalificacionEmpleadoToGet(tipocalificacionempleadoLocal,this.arrDatoGeneral);
		}
		
		return tipocalificacionempleados;
	}
	
	public void setTipoCalificacionEmpleados(List<TipoCalificacionEmpleado> newTipoCalificacionEmpleados) {
		this.tipocalificacionempleados = newTipoCalificacionEmpleados;
	}
	
	public Object getTipoCalificacionEmpleadoObject() {	
		this.tipocalificacionempleadoObject=this.tipocalificacionempleadoDataAccess.getEntityObject();
		return this.tipocalificacionempleadoObject;
	}
		
	public void setTipoCalificacionEmpleadoObject(Object newTipoCalificacionEmpleadoObject) {
		this.tipocalificacionempleadoObject = newTipoCalificacionEmpleadoObject;
	}
	
	public List<Object> getTipoCalificacionEmpleadosObject() {		
		this.tipocalificacionempleadosObject=this.tipocalificacionempleadoDataAccess.getEntitiesObject();
		return this.tipocalificacionempleadosObject;
	}
		
	public void setTipoCalificacionEmpleadosObject(List<Object> newTipoCalificacionEmpleadosObject) {
		this.tipocalificacionempleadosObject = newTipoCalificacionEmpleadosObject;
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
		
		if(this.tipocalificacionempleadoDataAccess!=null) {
			this.tipocalificacionempleadoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCalificacionEmpleado.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipocalificacionempleadoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipocalificacionempleadoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipocalificacionempleado = new  TipoCalificacionEmpleado();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCalificacionEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipocalificacionempleado=tipocalificacionempleadoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocalificacionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalificacionEmpleado(this.tipocalificacionempleado);
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
		tipocalificacionempleado = new  TipoCalificacionEmpleado();
		  		  
        try {
			
			tipocalificacionempleado=tipocalificacionempleadoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocalificacionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalificacionEmpleado(this.tipocalificacionempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipocalificacionempleado = new  TipoCalificacionEmpleado();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCalificacionEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipocalificacionempleado=tipocalificacionempleadoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocalificacionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalificacionEmpleado(this.tipocalificacionempleado);
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
		tipocalificacionempleado = new  TipoCalificacionEmpleado();
		  		  
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
		tipocalificacionempleado = new  TipoCalificacionEmpleado();
		  		  
        try {
			
			tipocalificacionempleado=tipocalificacionempleadoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipocalificacionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoCalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalificacionEmpleado(this.tipocalificacionempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipocalificacionempleado = new  TipoCalificacionEmpleado();
		  		  
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
		tipocalificacionempleado = new  TipoCalificacionEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCalificacionEmpleado.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipocalificacionempleadoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocalificacionempleado = new  TipoCalificacionEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipocalificacionempleadoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipocalificacionempleado = new  TipoCalificacionEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCalificacionEmpleado.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipocalificacionempleadoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocalificacionempleado = new  TipoCalificacionEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipocalificacionempleadoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipocalificacionempleado = new  TipoCalificacionEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCalificacionEmpleado.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipocalificacionempleadoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipocalificacionempleado = new  TipoCalificacionEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipocalificacionempleadoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipocalificacionempleados = new  ArrayList<TipoCalificacionEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCalificacionEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoCalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocalificacionempleados=tipocalificacionempleadoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCalificacionEmpleado(tipocalificacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalificacionEmpleado(this.tipocalificacionempleados);
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
		tipocalificacionempleados = new  ArrayList<TipoCalificacionEmpleado>();
		  		  
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
		tipocalificacionempleados = new  ArrayList<TipoCalificacionEmpleado>();
		  		  
        try {			
			TipoCalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocalificacionempleados=tipocalificacionempleadoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoCalificacionEmpleado(tipocalificacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalificacionEmpleado(this.tipocalificacionempleados);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipocalificacionempleados = new  ArrayList<TipoCalificacionEmpleado>();
		  		  
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
		tipocalificacionempleados = new  ArrayList<TipoCalificacionEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCalificacionEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoCalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocalificacionempleados=tipocalificacionempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCalificacionEmpleado(tipocalificacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalificacionEmpleado(this.tipocalificacionempleados);
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
		tipocalificacionempleados = new  ArrayList<TipoCalificacionEmpleado>();
		  		  
        try {
			TipoCalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocalificacionempleados=tipocalificacionempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCalificacionEmpleado(tipocalificacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalificacionEmpleado(this.tipocalificacionempleados);
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
		tipocalificacionempleados = new  ArrayList<TipoCalificacionEmpleado>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCalificacionEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocalificacionempleados=tipocalificacionempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCalificacionEmpleado(tipocalificacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalificacionEmpleado(this.tipocalificacionempleados);
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
		tipocalificacionempleados = new  ArrayList<TipoCalificacionEmpleado>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocalificacionempleados=tipocalificacionempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCalificacionEmpleado(tipocalificacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalificacionEmpleado(this.tipocalificacionempleados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipocalificacionempleado = new  TipoCalificacionEmpleado();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCalificacionEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocalificacionempleado=tipocalificacionempleadoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCalificacionEmpleado(tipocalificacionempleado);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalificacionEmpleado(this.tipocalificacionempleado);
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
		tipocalificacionempleado = new  TipoCalificacionEmpleado();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocalificacionempleado=tipocalificacionempleadoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoCalificacionEmpleado(tipocalificacionempleado);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalificacionEmpleado(this.tipocalificacionempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipocalificacionempleados = new  ArrayList<TipoCalificacionEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCalificacionEmpleado.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoCalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocalificacionempleados=tipocalificacionempleadoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCalificacionEmpleado(tipocalificacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalificacionEmpleado(this.tipocalificacionempleados);
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
		tipocalificacionempleados = new  ArrayList<TipoCalificacionEmpleado>();
		  		  
        try {
			TipoCalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocalificacionempleados=tipocalificacionempleadoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoCalificacionEmpleado(tipocalificacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalificacionEmpleado(this.tipocalificacionempleados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoCalificacionEmpleadosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipocalificacionempleados = new  ArrayList<TipoCalificacionEmpleado>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCalificacionEmpleado.class.getSimpleName()+"-getTodosTipoCalificacionEmpleadosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocalificacionempleados=tipocalificacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoCalificacionEmpleado(tipocalificacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalificacionEmpleado(this.tipocalificacionempleados);
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
	
	public  void  getTodosTipoCalificacionEmpleados(String sFinalQuery,Pagination pagination)throws Exception {
		tipocalificacionempleados = new  ArrayList<TipoCalificacionEmpleado>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoCalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipocalificacionempleados=tipocalificacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoCalificacionEmpleado(tipocalificacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoCalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalificacionEmpleado(this.tipocalificacionempleados);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoCalificacionEmpleado(TipoCalificacionEmpleado tipocalificacionempleado) throws Exception {
		Boolean estaValidado=false;
		
		if(tipocalificacionempleado.getIsNew() || tipocalificacionempleado.getIsChanged()) { 
			this.invalidValues = tipocalificacionempleadoValidator.getInvalidValues(tipocalificacionempleado);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipocalificacionempleado);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoCalificacionEmpleado(List<TipoCalificacionEmpleado> TipoCalificacionEmpleados) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoCalificacionEmpleado tipocalificacionempleadoLocal:tipocalificacionempleados) {				
			estaValidadoObjeto=this.validarGuardarTipoCalificacionEmpleado(tipocalificacionempleadoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoCalificacionEmpleado(List<TipoCalificacionEmpleado> TipoCalificacionEmpleados) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoCalificacionEmpleado(tipocalificacionempleados)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoCalificacionEmpleado(TipoCalificacionEmpleado TipoCalificacionEmpleado) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoCalificacionEmpleado(tipocalificacionempleado)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoCalificacionEmpleado tipocalificacionempleado) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipocalificacionempleado.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoCalificacionEmpleadoConstantesFunciones.getTipoCalificacionEmpleadoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipocalificacionempleado","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoCalificacionEmpleadoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoCalificacionEmpleadoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoCalificacionEmpleadoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCalificacionEmpleado.class.getSimpleName()+"-saveTipoCalificacionEmpleadoWithConnection");connexion.begin();			
			
			TipoCalificacionEmpleadoLogicAdditional.checkTipoCalificacionEmpleadoToSave(this.tipocalificacionempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoCalificacionEmpleadoLogicAdditional.updateTipoCalificacionEmpleadoToSave(this.tipocalificacionempleado,this.arrDatoGeneral);
			
			TipoCalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipocalificacionempleado,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoCalificacionEmpleado();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoCalificacionEmpleado(this.tipocalificacionempleado)) {
				TipoCalificacionEmpleadoDataAccess.save(this.tipocalificacionempleado, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipocalificacionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoCalificacionEmpleadoLogicAdditional.checkTipoCalificacionEmpleadoToSaveAfter(this.tipocalificacionempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoCalificacionEmpleado();
			
			connexion.commit();			
			
			if(this.tipocalificacionempleado.getIsDeleted()) {
				this.tipocalificacionempleado=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoCalificacionEmpleado()throws Exception {	
		try {	
			
			TipoCalificacionEmpleadoLogicAdditional.checkTipoCalificacionEmpleadoToSave(this.tipocalificacionempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoCalificacionEmpleadoLogicAdditional.updateTipoCalificacionEmpleadoToSave(this.tipocalificacionempleado,this.arrDatoGeneral);
			
			TipoCalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipocalificacionempleado,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoCalificacionEmpleado(this.tipocalificacionempleado)) {			
				TipoCalificacionEmpleadoDataAccess.save(this.tipocalificacionempleado, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipocalificacionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoCalificacionEmpleadoLogicAdditional.checkTipoCalificacionEmpleadoToSaveAfter(this.tipocalificacionempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipocalificacionempleado.getIsDeleted()) {
				this.tipocalificacionempleado=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoCalificacionEmpleadosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCalificacionEmpleado.class.getSimpleName()+"-saveTipoCalificacionEmpleadosWithConnection");connexion.begin();			
			
			TipoCalificacionEmpleadoLogicAdditional.checkTipoCalificacionEmpleadoToSaves(tipocalificacionempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoCalificacionEmpleados();
			
			Boolean validadoTodosTipoCalificacionEmpleado=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoCalificacionEmpleado tipocalificacionempleadoLocal:tipocalificacionempleados) {		
				if(tipocalificacionempleadoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoCalificacionEmpleadoLogicAdditional.updateTipoCalificacionEmpleadoToSave(tipocalificacionempleadoLocal,this.arrDatoGeneral);
	        	
				TipoCalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipocalificacionempleadoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoCalificacionEmpleado(tipocalificacionempleadoLocal)) {
					TipoCalificacionEmpleadoDataAccess.save(tipocalificacionempleadoLocal, connexion);				
				} else {
					validadoTodosTipoCalificacionEmpleado=false;
				}
			}
			
			if(!validadoTodosTipoCalificacionEmpleado) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoCalificacionEmpleadoLogicAdditional.checkTipoCalificacionEmpleadoToSavesAfter(tipocalificacionempleados,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoCalificacionEmpleados();
			
			connexion.commit();		
			
			this.quitarTipoCalificacionEmpleadosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoCalificacionEmpleados()throws Exception {				
		 try {	
			TipoCalificacionEmpleadoLogicAdditional.checkTipoCalificacionEmpleadoToSaves(tipocalificacionempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoCalificacionEmpleado=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoCalificacionEmpleado tipocalificacionempleadoLocal:tipocalificacionempleados) {				
				if(tipocalificacionempleadoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoCalificacionEmpleadoLogicAdditional.updateTipoCalificacionEmpleadoToSave(tipocalificacionempleadoLocal,this.arrDatoGeneral);
	        	
				TipoCalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipocalificacionempleadoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoCalificacionEmpleado(tipocalificacionempleadoLocal)) {				
					TipoCalificacionEmpleadoDataAccess.save(tipocalificacionempleadoLocal, connexion);				
				} else {
					validadoTodosTipoCalificacionEmpleado=false;
				}
			}
			
			if(!validadoTodosTipoCalificacionEmpleado) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoCalificacionEmpleadoLogicAdditional.checkTipoCalificacionEmpleadoToSavesAfter(tipocalificacionempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoCalificacionEmpleadosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoCalificacionEmpleadoParameterReturnGeneral procesarAccionTipoCalificacionEmpleados(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoCalificacionEmpleado> tipocalificacionempleados,TipoCalificacionEmpleadoParameterReturnGeneral tipocalificacionempleadoParameterGeneral)throws Exception {
		 try {	
			TipoCalificacionEmpleadoParameterReturnGeneral tipocalificacionempleadoReturnGeneral=new TipoCalificacionEmpleadoParameterReturnGeneral();
	
			TipoCalificacionEmpleadoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipocalificacionempleados,tipocalificacionempleadoParameterGeneral,tipocalificacionempleadoReturnGeneral);
			
			return tipocalificacionempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoCalificacionEmpleadoParameterReturnGeneral procesarAccionTipoCalificacionEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoCalificacionEmpleado> tipocalificacionempleados,TipoCalificacionEmpleadoParameterReturnGeneral tipocalificacionempleadoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCalificacionEmpleado.class.getSimpleName()+"-procesarAccionTipoCalificacionEmpleadosWithConnection");connexion.begin();			
			
			TipoCalificacionEmpleadoParameterReturnGeneral tipocalificacionempleadoReturnGeneral=new TipoCalificacionEmpleadoParameterReturnGeneral();
	
			TipoCalificacionEmpleadoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipocalificacionempleados,tipocalificacionempleadoParameterGeneral,tipocalificacionempleadoReturnGeneral);
			
			this.connexion.commit();
			
			return tipocalificacionempleadoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoCalificacionEmpleadoParameterReturnGeneral procesarEventosTipoCalificacionEmpleados(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoCalificacionEmpleado> tipocalificacionempleados,TipoCalificacionEmpleado tipocalificacionempleado,TipoCalificacionEmpleadoParameterReturnGeneral tipocalificacionempleadoParameterGeneral,Boolean isEsNuevoTipoCalificacionEmpleado,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoCalificacionEmpleadoParameterReturnGeneral tipocalificacionempleadoReturnGeneral=new TipoCalificacionEmpleadoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipocalificacionempleadoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoCalificacionEmpleadoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipocalificacionempleados,tipocalificacionempleado,tipocalificacionempleadoParameterGeneral,tipocalificacionempleadoReturnGeneral,isEsNuevoTipoCalificacionEmpleado,clases);
			
			return tipocalificacionempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoCalificacionEmpleadoParameterReturnGeneral procesarEventosTipoCalificacionEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoCalificacionEmpleado> tipocalificacionempleados,TipoCalificacionEmpleado tipocalificacionempleado,TipoCalificacionEmpleadoParameterReturnGeneral tipocalificacionempleadoParameterGeneral,Boolean isEsNuevoTipoCalificacionEmpleado,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCalificacionEmpleado.class.getSimpleName()+"-procesarEventosTipoCalificacionEmpleadosWithConnection");connexion.begin();			
			
			TipoCalificacionEmpleadoParameterReturnGeneral tipocalificacionempleadoReturnGeneral=new TipoCalificacionEmpleadoParameterReturnGeneral();
	
			tipocalificacionempleadoReturnGeneral.setTipoCalificacionEmpleado(tipocalificacionempleado);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipocalificacionempleadoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoCalificacionEmpleadoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipocalificacionempleados,tipocalificacionempleado,tipocalificacionempleadoParameterGeneral,tipocalificacionempleadoReturnGeneral,isEsNuevoTipoCalificacionEmpleado,clases);
			
			this.connexion.commit();
			
			return tipocalificacionempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoCalificacionEmpleadoParameterReturnGeneral procesarImportacionTipoCalificacionEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoCalificacionEmpleadoParameterReturnGeneral tipocalificacionempleadoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCalificacionEmpleado.class.getSimpleName()+"-procesarImportacionTipoCalificacionEmpleadosWithConnection");connexion.begin();			
			
			TipoCalificacionEmpleadoParameterReturnGeneral tipocalificacionempleadoReturnGeneral=new TipoCalificacionEmpleadoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipocalificacionempleados=new ArrayList<TipoCalificacionEmpleado>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipocalificacionempleado=new TipoCalificacionEmpleado();
				
				
				if(conColumnasBase) {this.tipocalificacionempleado.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipocalificacionempleado.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipocalificacionempleado.setcodigo(arrColumnas[iColumn++]);
				this.tipocalificacionempleado.setnombre(arrColumnas[iColumn++]);
				
				this.tipocalificacionempleados.add(this.tipocalificacionempleado);
			}
			
			this.saveTipoCalificacionEmpleados();
			
			this.connexion.commit();
			
			tipocalificacionempleadoReturnGeneral.setConRetornoEstaProcesado(true);
			tipocalificacionempleadoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipocalificacionempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoCalificacionEmpleadosEliminados() throws Exception {				
		
		List<TipoCalificacionEmpleado> tipocalificacionempleadosAux= new ArrayList<TipoCalificacionEmpleado>();
		
		for(TipoCalificacionEmpleado tipocalificacionempleado:tipocalificacionempleados) {
			if(!tipocalificacionempleado.getIsDeleted()) {
				tipocalificacionempleadosAux.add(tipocalificacionempleado);
			}
		}
		
		tipocalificacionempleados=tipocalificacionempleadosAux;
	}
	
	public void quitarTipoCalificacionEmpleadosNulos() throws Exception {				
		
		List<TipoCalificacionEmpleado> tipocalificacionempleadosAux= new ArrayList<TipoCalificacionEmpleado>();
		
		for(TipoCalificacionEmpleado tipocalificacionempleado : this.tipocalificacionempleados) {
			if(tipocalificacionempleado==null) {
				tipocalificacionempleadosAux.add(tipocalificacionempleado);
			}
		}
		
		//this.tipocalificacionempleados=tipocalificacionempleadosAux;
		
		this.tipocalificacionempleados.removeAll(tipocalificacionempleadosAux);
	}
	
	public void getSetVersionRowTipoCalificacionEmpleadoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipocalificacionempleado.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipocalificacionempleado.getIsDeleted() || (tipocalificacionempleado.getIsChanged()&&!tipocalificacionempleado.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipocalificacionempleadoDataAccess.getSetVersionRowTipoCalificacionEmpleado(connexion,tipocalificacionempleado.getId());
				
				if(!tipocalificacionempleado.getVersionRow().equals(timestamp)) {	
					tipocalificacionempleado.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipocalificacionempleado.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoCalificacionEmpleado()throws Exception {	
		
		if(tipocalificacionempleado.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipocalificacionempleado.getIsDeleted() || (tipocalificacionempleado.getIsChanged()&&!tipocalificacionempleado.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipocalificacionempleadoDataAccess.getSetVersionRowTipoCalificacionEmpleado(connexion,tipocalificacionempleado.getId());
			
			try {							
				if(!tipocalificacionempleado.getVersionRow().equals(timestamp)) {	
					tipocalificacionempleado.setVersionRow(timestamp);
				}
				
				tipocalificacionempleado.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoCalificacionEmpleadosWithConnection()throws Exception {	
		if(tipocalificacionempleados!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoCalificacionEmpleado tipocalificacionempleadoAux:tipocalificacionempleados) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipocalificacionempleadoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipocalificacionempleadoAux.getIsDeleted() || (tipocalificacionempleadoAux.getIsChanged()&&!tipocalificacionempleadoAux.getIsNew())) {
						
						timestamp=tipocalificacionempleadoDataAccess.getSetVersionRowTipoCalificacionEmpleado(connexion,tipocalificacionempleadoAux.getId());
						
						if(!tipocalificacionempleado.getVersionRow().equals(timestamp)) {	
							tipocalificacionempleadoAux.setVersionRow(timestamp);
						}
								
						tipocalificacionempleadoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoCalificacionEmpleados()throws Exception {	
		if(tipocalificacionempleados!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoCalificacionEmpleado tipocalificacionempleadoAux:tipocalificacionempleados) {
					if(tipocalificacionempleadoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipocalificacionempleadoAux.getIsDeleted() || (tipocalificacionempleadoAux.getIsChanged()&&!tipocalificacionempleadoAux.getIsNew())) {
						
						timestamp=tipocalificacionempleadoDataAccess.getSetVersionRowTipoCalificacionEmpleado(connexion,tipocalificacionempleadoAux.getId());
						
						if(!tipocalificacionempleadoAux.getVersionRow().equals(timestamp)) {	
							tipocalificacionempleadoAux.setVersionRow(timestamp);
						}
						
													
						tipocalificacionempleadoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoCalificacionEmpleadoParameterReturnGeneral cargarCombosLoteForeignKeyTipoCalificacionEmpleadoWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoCalificacionEmpleadoParameterReturnGeneral  tipocalificacionempleadoReturnGeneral =new TipoCalificacionEmpleadoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCalificacionEmpleado.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoCalificacionEmpleadoWithConnection");connexion.begin();
			
			tipocalificacionempleadoReturnGeneral =new TipoCalificacionEmpleadoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipocalificacionempleadoReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipocalificacionempleadoReturnGeneral;
	}
	
	public TipoCalificacionEmpleadoParameterReturnGeneral cargarCombosLoteForeignKeyTipoCalificacionEmpleado(String finalQueryGlobalEmpresa) throws Exception {
		TipoCalificacionEmpleadoParameterReturnGeneral  tipocalificacionempleadoReturnGeneral =new TipoCalificacionEmpleadoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipocalificacionempleadoReturnGeneral =new TipoCalificacionEmpleadoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipocalificacionempleadoReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipocalificacionempleadoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoCalificacionEmpleadoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			CalificacionEmpleadoLogic calificacionempleadoLogic=new CalificacionEmpleadoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCalificacionEmpleado.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoCalificacionEmpleadoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(CalificacionEmpleado.class));
											
			

			calificacionempleadoLogic.setConnexion(this.getConnexion());
			calificacionempleadoLogic.setDatosCliente(this.datosCliente);
			calificacionempleadoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoCalificacionEmpleado tipocalificacionempleado:this.tipocalificacionempleados) {
				

				classes=new ArrayList<Classe>();
				classes=CalificacionEmpleadoConstantesFunciones.getClassesForeignKeysOfCalificacionEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);

				calificacionempleadoLogic.setCalificacionEmpleados(tipocalificacionempleado.calificacionempleados);
				calificacionempleadoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoCalificacionEmpleado tipocalificacionempleado,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoCalificacionEmpleadoLogicAdditional.updateTipoCalificacionEmpleadoToGet(tipocalificacionempleado,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipocalificacionempleado.setEmpresa(tipocalificacionempleadoDataAccess.getEmpresa(connexion,tipocalificacionempleado));
		tipocalificacionempleado.setCalificacionEmpleados(tipocalificacionempleadoDataAccess.getCalificacionEmpleados(connexion,tipocalificacionempleado));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipocalificacionempleado.setEmpresa(tipocalificacionempleadoDataAccess.getEmpresa(connexion,tipocalificacionempleado));
				continue;
			}

			if(clas.clas.equals(CalificacionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocalificacionempleado.setCalificacionEmpleados(tipocalificacionempleadoDataAccess.getCalificacionEmpleados(connexion,tipocalificacionempleado));

				if(this.isConDeep) {
					CalificacionEmpleadoLogic calificacionempleadoLogic= new CalificacionEmpleadoLogic(this.connexion);
					calificacionempleadoLogic.setCalificacionEmpleados(tipocalificacionempleado.getCalificacionEmpleados());
					ArrayList<Classe> classesLocal=CalificacionEmpleadoConstantesFunciones.getClassesForeignKeysOfCalificacionEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);
					calificacionempleadoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesCalificacionEmpleado(calificacionempleadoLogic.getCalificacionEmpleados());
					tipocalificacionempleado.setCalificacionEmpleados(calificacionempleadoLogic.getCalificacionEmpleados());
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
			tipocalificacionempleado.setEmpresa(tipocalificacionempleadoDataAccess.getEmpresa(connexion,tipocalificacionempleado));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CalificacionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CalificacionEmpleado.class));
			tipocalificacionempleado.setCalificacionEmpleados(tipocalificacionempleadoDataAccess.getCalificacionEmpleados(connexion,tipocalificacionempleado));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipocalificacionempleado.setEmpresa(tipocalificacionempleadoDataAccess.getEmpresa(connexion,tipocalificacionempleado));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipocalificacionempleado.getEmpresa(),isDeep,deepLoadType,clases);
				

		tipocalificacionempleado.setCalificacionEmpleados(tipocalificacionempleadoDataAccess.getCalificacionEmpleados(connexion,tipocalificacionempleado));

		for(CalificacionEmpleado calificacionempleado:tipocalificacionempleado.getCalificacionEmpleados()) {
			CalificacionEmpleadoLogic calificacionempleadoLogic= new CalificacionEmpleadoLogic(connexion);
			calificacionempleadoLogic.deepLoad(calificacionempleado,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipocalificacionempleado.setEmpresa(tipocalificacionempleadoDataAccess.getEmpresa(connexion,tipocalificacionempleado));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipocalificacionempleado.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CalificacionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipocalificacionempleado.setCalificacionEmpleados(tipocalificacionempleadoDataAccess.getCalificacionEmpleados(connexion,tipocalificacionempleado));

				for(CalificacionEmpleado calificacionempleado:tipocalificacionempleado.getCalificacionEmpleados()) {
					CalificacionEmpleadoLogic calificacionempleadoLogic= new CalificacionEmpleadoLogic(connexion);
					calificacionempleadoLogic.deepLoad(calificacionempleado,isDeep,deepLoadType,clases);
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
			tipocalificacionempleado.setEmpresa(tipocalificacionempleadoDataAccess.getEmpresa(connexion,tipocalificacionempleado));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipocalificacionempleado.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CalificacionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CalificacionEmpleado.class));
			tipocalificacionempleado.setCalificacionEmpleados(tipocalificacionempleadoDataAccess.getCalificacionEmpleados(connexion,tipocalificacionempleado));

			for(CalificacionEmpleado calificacionempleado:tipocalificacionempleado.getCalificacionEmpleados()) {
				CalificacionEmpleadoLogic calificacionempleadoLogic= new CalificacionEmpleadoLogic(connexion);
				calificacionempleadoLogic.deepLoad(calificacionempleado,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoCalificacionEmpleado tipocalificacionempleado,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoCalificacionEmpleadoLogicAdditional.updateTipoCalificacionEmpleadoToSave(tipocalificacionempleado,this.arrDatoGeneral);
			
TipoCalificacionEmpleadoDataAccess.save(tipocalificacionempleado, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipocalificacionempleado.getEmpresa(),connexion);

		for(CalificacionEmpleado calificacionempleado:tipocalificacionempleado.getCalificacionEmpleados()) {
			calificacionempleado.setid_tipo_calificacion_empleado(tipocalificacionempleado.getId());
			CalificacionEmpleadoDataAccess.save(calificacionempleado,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipocalificacionempleado.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(CalificacionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CalificacionEmpleado calificacionempleado:tipocalificacionempleado.getCalificacionEmpleados()) {
					calificacionempleado.setid_tipo_calificacion_empleado(tipocalificacionempleado.getId());
					CalificacionEmpleadoDataAccess.save(calificacionempleado,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipocalificacionempleado.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipocalificacionempleado.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(CalificacionEmpleado calificacionempleado:tipocalificacionempleado.getCalificacionEmpleados()) {
			CalificacionEmpleadoLogic calificacionempleadoLogic= new CalificacionEmpleadoLogic(connexion);
			calificacionempleado.setid_tipo_calificacion_empleado(tipocalificacionempleado.getId());
			CalificacionEmpleadoDataAccess.save(calificacionempleado,connexion);
			calificacionempleadoLogic.deepSave(calificacionempleado,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipocalificacionempleado.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipocalificacionempleado.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(CalificacionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CalificacionEmpleado calificacionempleado:tipocalificacionempleado.getCalificacionEmpleados()) {
					CalificacionEmpleadoLogic calificacionempleadoLogic= new CalificacionEmpleadoLogic(connexion);
					calificacionempleado.setid_tipo_calificacion_empleado(tipocalificacionempleado.getId());
					CalificacionEmpleadoDataAccess.save(calificacionempleado,connexion);
					calificacionempleadoLogic.deepSave(calificacionempleado,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoCalificacionEmpleado.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipocalificacionempleado,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoCalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalificacionEmpleado(tipocalificacionempleado);
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
			this.deepLoad(this.tipocalificacionempleado,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoCalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalificacionEmpleado(this.tipocalificacionempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoCalificacionEmpleado.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipocalificacionempleados!=null) {
				for(TipoCalificacionEmpleado tipocalificacionempleado:tipocalificacionempleados) {
					this.deepLoad(tipocalificacionempleado,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoCalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalificacionEmpleado(tipocalificacionempleados);
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
			if(tipocalificacionempleados!=null) {
				for(TipoCalificacionEmpleado tipocalificacionempleado:tipocalificacionempleados) {
					this.deepLoad(tipocalificacionempleado,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoCalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalificacionEmpleado(tipocalificacionempleados);
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
			this.getNewConnexionToDeep(TipoCalificacionEmpleado.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipocalificacionempleado,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoCalificacionEmpleado.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipocalificacionempleados!=null) {
				for(TipoCalificacionEmpleado tipocalificacionempleado:tipocalificacionempleados) {
					this.deepSave(tipocalificacionempleado,isDeep,deepLoadType,clases);
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
			if(tipocalificacionempleados!=null) {
				for(TipoCalificacionEmpleado tipocalificacionempleado:tipocalificacionempleados) {
					this.deepSave(tipocalificacionempleado,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoCalificacionEmpleadosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoCalificacionEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoCalificacionEmpleadoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoCalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipocalificacionempleados=tipocalificacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoCalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalificacionEmpleado(this.tipocalificacionempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoCalificacionEmpleadosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoCalificacionEmpleadoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoCalificacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipocalificacionempleados=tipocalificacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoCalificacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoCalificacionEmpleado(this.tipocalificacionempleados);
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
			if(TipoCalificacionEmpleadoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCalificacionEmpleadoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoCalificacionEmpleado tipocalificacionempleado,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoCalificacionEmpleadoConstantesFunciones.ISCONAUDITORIA) {
				if(tipocalificacionempleado.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCalificacionEmpleadoDataAccess.TABLENAME, tipocalificacionempleado.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoCalificacionEmpleadoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoCalificacionEmpleadoLogic.registrarAuditoriaDetallesTipoCalificacionEmpleado(connexion,tipocalificacionempleado,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipocalificacionempleado.getIsDeleted()) {
					/*if(!tipocalificacionempleado.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoCalificacionEmpleadoDataAccess.TABLENAME, tipocalificacionempleado.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoCalificacionEmpleadoLogic.registrarAuditoriaDetallesTipoCalificacionEmpleado(connexion,tipocalificacionempleado,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCalificacionEmpleadoDataAccess.TABLENAME, tipocalificacionempleado.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipocalificacionempleado.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoCalificacionEmpleadoDataAccess.TABLENAME, tipocalificacionempleado.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoCalificacionEmpleadoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoCalificacionEmpleadoLogic.registrarAuditoriaDetallesTipoCalificacionEmpleado(connexion,tipocalificacionempleado,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoCalificacionEmpleado(Connexion connexion,TipoCalificacionEmpleado tipocalificacionempleado)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipocalificacionempleado.getIsNew()||!tipocalificacionempleado.getid_empresa().equals(tipocalificacionempleado.getTipoCalificacionEmpleadoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocalificacionempleado.getTipoCalificacionEmpleadoOriginal().getid_empresa()!=null)
				{
					strValorActual=tipocalificacionempleado.getTipoCalificacionEmpleadoOriginal().getid_empresa().toString();
				}
				if(tipocalificacionempleado.getid_empresa()!=null)
				{
					strValorNuevo=tipocalificacionempleado.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoCalificacionEmpleadoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipocalificacionempleado.getIsNew()||!tipocalificacionempleado.getcodigo().equals(tipocalificacionempleado.getTipoCalificacionEmpleadoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocalificacionempleado.getTipoCalificacionEmpleadoOriginal().getcodigo()!=null)
				{
					strValorActual=tipocalificacionempleado.getTipoCalificacionEmpleadoOriginal().getcodigo();
				}
				if(tipocalificacionempleado.getcodigo()!=null)
				{
					strValorNuevo=tipocalificacionempleado.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoCalificacionEmpleadoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipocalificacionempleado.getIsNew()||!tipocalificacionempleado.getnombre().equals(tipocalificacionempleado.getTipoCalificacionEmpleadoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipocalificacionempleado.getTipoCalificacionEmpleadoOriginal().getnombre()!=null)
				{
					strValorActual=tipocalificacionempleado.getTipoCalificacionEmpleadoOriginal().getnombre();
				}
				if(tipocalificacionempleado.getnombre()!=null)
				{
					strValorNuevo=tipocalificacionempleado.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoCalificacionEmpleadoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoCalificacionEmpleadoRelacionesWithConnection(TipoCalificacionEmpleado tipocalificacionempleado,List<CalificacionEmpleado> calificacionempleados) throws Exception {

		if(!tipocalificacionempleado.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoCalificacionEmpleadoRelacionesBase(tipocalificacionempleado,calificacionempleados,true);
		}
	}

	public void saveTipoCalificacionEmpleadoRelaciones(TipoCalificacionEmpleado tipocalificacionempleado,List<CalificacionEmpleado> calificacionempleados)throws Exception {

		if(!tipocalificacionempleado.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoCalificacionEmpleadoRelacionesBase(tipocalificacionempleado,calificacionempleados,false);
		}
	}

	public void saveTipoCalificacionEmpleadoRelacionesBase(TipoCalificacionEmpleado tipocalificacionempleado,List<CalificacionEmpleado> calificacionempleados,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoCalificacionEmpleado-saveRelacionesWithConnection");}
	
			tipocalificacionempleado.setCalificacionEmpleados(calificacionempleados);

			this.setTipoCalificacionEmpleado(tipocalificacionempleado);

			if(TipoCalificacionEmpleadoLogicAdditional.validarSaveRelaciones(tipocalificacionempleado,this)) {

				TipoCalificacionEmpleadoLogicAdditional.updateRelacionesToSave(tipocalificacionempleado,this);

				if((tipocalificacionempleado.getIsNew()||tipocalificacionempleado.getIsChanged())&&!tipocalificacionempleado.getIsDeleted()) {
					this.saveTipoCalificacionEmpleado();
					this.saveTipoCalificacionEmpleadoRelacionesDetalles(calificacionempleados);

				} else if(tipocalificacionempleado.getIsDeleted()) {
					this.saveTipoCalificacionEmpleadoRelacionesDetalles(calificacionempleados);
					this.saveTipoCalificacionEmpleado();
				}

				TipoCalificacionEmpleadoLogicAdditional.updateRelacionesToSaveAfter(tipocalificacionempleado,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			CalificacionEmpleadoConstantesFunciones.InicializarGeneralEntityAuxiliaresCalificacionEmpleados(calificacionempleados,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoCalificacionEmpleadoRelacionesDetalles(List<CalificacionEmpleado> calificacionempleados)throws Exception {
		try {
	

			Long idTipoCalificacionEmpleadoActual=this.getTipoCalificacionEmpleado().getId();

			CalificacionEmpleadoLogic calificacionempleadoLogic_Desde_TipoCalificacionEmpleado=new CalificacionEmpleadoLogic();
			calificacionempleadoLogic_Desde_TipoCalificacionEmpleado.setCalificacionEmpleados(calificacionempleados);

			calificacionempleadoLogic_Desde_TipoCalificacionEmpleado.setConnexion(this.getConnexion());
			calificacionempleadoLogic_Desde_TipoCalificacionEmpleado.setDatosCliente(this.datosCliente);

			for(CalificacionEmpleado calificacionempleado_Desde_TipoCalificacionEmpleado:calificacionempleadoLogic_Desde_TipoCalificacionEmpleado.getCalificacionEmpleados()) {
				calificacionempleado_Desde_TipoCalificacionEmpleado.setid_tipo_calificacion_empleado(idTipoCalificacionEmpleadoActual);
			}

			calificacionempleadoLogic_Desde_TipoCalificacionEmpleado.saveCalificacionEmpleados();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoCalificacionEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoCalificacionEmpleadoConstantesFunciones.getClassesForeignKeysOfTipoCalificacionEmpleado(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoCalificacionEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoCalificacionEmpleadoConstantesFunciones.getClassesRelationshipsOfTipoCalificacionEmpleado(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

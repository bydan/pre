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
import com.bydan.erp.nomina.util.TipoEvaluacionEmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.TipoEvaluacionEmpleadoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoEvaluacionEmpleadoParameterGeneral;
import com.bydan.erp.nomina.business.entity.TipoEvaluacionEmpleado;
import com.bydan.erp.nomina.business.logic.TipoEvaluacionEmpleadoLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;








@SuppressWarnings("unused")
public class TipoEvaluacionEmpleadoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoEvaluacionEmpleadoLogic.class);
	
	protected TipoEvaluacionEmpleadoDataAccess tipoevaluacionempleadoDataAccess; 	
	protected TipoEvaluacionEmpleado tipoevaluacionempleado;
	protected List<TipoEvaluacionEmpleado> tipoevaluacionempleados;
	protected Object tipoevaluacionempleadoObject;	
	protected List<Object> tipoevaluacionempleadosObject;
	
	public static ClassValidator<TipoEvaluacionEmpleado> tipoevaluacionempleadoValidator = new ClassValidator<TipoEvaluacionEmpleado>(TipoEvaluacionEmpleado.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoEvaluacionEmpleadoLogicAdditional tipoevaluacionempleadoLogicAdditional=null;
	
	public TipoEvaluacionEmpleadoLogicAdditional getTipoEvaluacionEmpleadoLogicAdditional() {
		return this.tipoevaluacionempleadoLogicAdditional;
	}
	
	public void setTipoEvaluacionEmpleadoLogicAdditional(TipoEvaluacionEmpleadoLogicAdditional tipoevaluacionempleadoLogicAdditional) {
		try {
			this.tipoevaluacionempleadoLogicAdditional=tipoevaluacionempleadoLogicAdditional;
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
	
	
	
	
	public  TipoEvaluacionEmpleadoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoevaluacionempleadoDataAccess = new TipoEvaluacionEmpleadoDataAccess();
			
			this.tipoevaluacionempleados= new ArrayList<TipoEvaluacionEmpleado>();
			this.tipoevaluacionempleado= new TipoEvaluacionEmpleado();
			
			this.tipoevaluacionempleadoObject=new Object();
			this.tipoevaluacionempleadosObject=new ArrayList<Object>();
				
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
			
			this.tipoevaluacionempleadoDataAccess.setConnexionType(this.connexionType);
			this.tipoevaluacionempleadoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoEvaluacionEmpleadoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoevaluacionempleadoDataAccess = new TipoEvaluacionEmpleadoDataAccess();
			this.tipoevaluacionempleados= new ArrayList<TipoEvaluacionEmpleado>();
			this.tipoevaluacionempleado= new TipoEvaluacionEmpleado();
			this.tipoevaluacionempleadoObject=new Object();
			this.tipoevaluacionempleadosObject=new ArrayList<Object>();
			
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
			
			this.tipoevaluacionempleadoDataAccess.setConnexionType(this.connexionType);
			this.tipoevaluacionempleadoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoEvaluacionEmpleado getTipoEvaluacionEmpleado() throws Exception {	
		TipoEvaluacionEmpleadoLogicAdditional.checkTipoEvaluacionEmpleadoToGet(tipoevaluacionempleado,this.datosCliente,this.arrDatoGeneral);
		TipoEvaluacionEmpleadoLogicAdditional.updateTipoEvaluacionEmpleadoToGet(tipoevaluacionempleado,this.arrDatoGeneral);
		
		return tipoevaluacionempleado;
	}
		
	public void setTipoEvaluacionEmpleado(TipoEvaluacionEmpleado newTipoEvaluacionEmpleado) {
		this.tipoevaluacionempleado = newTipoEvaluacionEmpleado;
	}
	
	public TipoEvaluacionEmpleadoDataAccess getTipoEvaluacionEmpleadoDataAccess() {
		return tipoevaluacionempleadoDataAccess;
	}
	
	public void setTipoEvaluacionEmpleadoDataAccess(TipoEvaluacionEmpleadoDataAccess newtipoevaluacionempleadoDataAccess) {
		this.tipoevaluacionempleadoDataAccess = newtipoevaluacionempleadoDataAccess;
	}
	
	public List<TipoEvaluacionEmpleado> getTipoEvaluacionEmpleados() throws Exception {		
		this.quitarTipoEvaluacionEmpleadosNulos();
		
		TipoEvaluacionEmpleadoLogicAdditional.checkTipoEvaluacionEmpleadoToGets(tipoevaluacionempleados,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoEvaluacionEmpleado tipoevaluacionempleadoLocal: tipoevaluacionempleados ) {
			TipoEvaluacionEmpleadoLogicAdditional.updateTipoEvaluacionEmpleadoToGet(tipoevaluacionempleadoLocal,this.arrDatoGeneral);
		}
		
		return tipoevaluacionempleados;
	}
	
	public void setTipoEvaluacionEmpleados(List<TipoEvaluacionEmpleado> newTipoEvaluacionEmpleados) {
		this.tipoevaluacionempleados = newTipoEvaluacionEmpleados;
	}
	
	public Object getTipoEvaluacionEmpleadoObject() {	
		this.tipoevaluacionempleadoObject=this.tipoevaluacionempleadoDataAccess.getEntityObject();
		return this.tipoevaluacionempleadoObject;
	}
		
	public void setTipoEvaluacionEmpleadoObject(Object newTipoEvaluacionEmpleadoObject) {
		this.tipoevaluacionempleadoObject = newTipoEvaluacionEmpleadoObject;
	}
	
	public List<Object> getTipoEvaluacionEmpleadosObject() {		
		this.tipoevaluacionempleadosObject=this.tipoevaluacionempleadoDataAccess.getEntitiesObject();
		return this.tipoevaluacionempleadosObject;
	}
		
	public void setTipoEvaluacionEmpleadosObject(List<Object> newTipoEvaluacionEmpleadosObject) {
		this.tipoevaluacionempleadosObject = newTipoEvaluacionEmpleadosObject;
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
		
		if(this.tipoevaluacionempleadoDataAccess!=null) {
			this.tipoevaluacionempleadoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEvaluacionEmpleado.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoevaluacionempleadoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoevaluacionempleadoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoevaluacionempleado = new  TipoEvaluacionEmpleado();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEvaluacionEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoevaluacionempleado=tipoevaluacionempleadoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoevaluacionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoEvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEvaluacionEmpleado(this.tipoevaluacionempleado);
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
		tipoevaluacionempleado = new  TipoEvaluacionEmpleado();
		  		  
        try {
			
			tipoevaluacionempleado=tipoevaluacionempleadoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoevaluacionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoEvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEvaluacionEmpleado(this.tipoevaluacionempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoevaluacionempleado = new  TipoEvaluacionEmpleado();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEvaluacionEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoevaluacionempleado=tipoevaluacionempleadoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoevaluacionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoEvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEvaluacionEmpleado(this.tipoevaluacionempleado);
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
		tipoevaluacionempleado = new  TipoEvaluacionEmpleado();
		  		  
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
		tipoevaluacionempleado = new  TipoEvaluacionEmpleado();
		  		  
        try {
			
			tipoevaluacionempleado=tipoevaluacionempleadoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoevaluacionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoEvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEvaluacionEmpleado(this.tipoevaluacionempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoevaluacionempleado = new  TipoEvaluacionEmpleado();
		  		  
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
		tipoevaluacionempleado = new  TipoEvaluacionEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEvaluacionEmpleado.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoevaluacionempleadoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoevaluacionempleado = new  TipoEvaluacionEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoevaluacionempleadoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoevaluacionempleado = new  TipoEvaluacionEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEvaluacionEmpleado.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoevaluacionempleadoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoevaluacionempleado = new  TipoEvaluacionEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoevaluacionempleadoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoevaluacionempleado = new  TipoEvaluacionEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEvaluacionEmpleado.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoevaluacionempleadoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoevaluacionempleado = new  TipoEvaluacionEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoevaluacionempleadoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoevaluacionempleados = new  ArrayList<TipoEvaluacionEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEvaluacionEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoEvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoevaluacionempleados=tipoevaluacionempleadoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoEvaluacionEmpleado(tipoevaluacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoEvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEvaluacionEmpleado(this.tipoevaluacionempleados);
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
		tipoevaluacionempleados = new  ArrayList<TipoEvaluacionEmpleado>();
		  		  
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
		tipoevaluacionempleados = new  ArrayList<TipoEvaluacionEmpleado>();
		  		  
        try {			
			TipoEvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoevaluacionempleados=tipoevaluacionempleadoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoEvaluacionEmpleado(tipoevaluacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoEvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEvaluacionEmpleado(this.tipoevaluacionempleados);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoevaluacionempleados = new  ArrayList<TipoEvaluacionEmpleado>();
		  		  
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
		tipoevaluacionempleados = new  ArrayList<TipoEvaluacionEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEvaluacionEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoEvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoevaluacionempleados=tipoevaluacionempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoEvaluacionEmpleado(tipoevaluacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoEvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEvaluacionEmpleado(this.tipoevaluacionempleados);
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
		tipoevaluacionempleados = new  ArrayList<TipoEvaluacionEmpleado>();
		  		  
        try {
			TipoEvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoevaluacionempleados=tipoevaluacionempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoEvaluacionEmpleado(tipoevaluacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoEvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEvaluacionEmpleado(this.tipoevaluacionempleados);
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
		tipoevaluacionempleados = new  ArrayList<TipoEvaluacionEmpleado>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEvaluacionEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoEvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoevaluacionempleados=tipoevaluacionempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoEvaluacionEmpleado(tipoevaluacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoEvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEvaluacionEmpleado(this.tipoevaluacionempleados);
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
		tipoevaluacionempleados = new  ArrayList<TipoEvaluacionEmpleado>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoEvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoevaluacionempleados=tipoevaluacionempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoEvaluacionEmpleado(tipoevaluacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoEvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEvaluacionEmpleado(this.tipoevaluacionempleados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoevaluacionempleado = new  TipoEvaluacionEmpleado();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEvaluacionEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoEvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoevaluacionempleado=tipoevaluacionempleadoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoEvaluacionEmpleado(tipoevaluacionempleado);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoEvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEvaluacionEmpleado(this.tipoevaluacionempleado);
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
		tipoevaluacionempleado = new  TipoEvaluacionEmpleado();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoEvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoevaluacionempleado=tipoevaluacionempleadoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoEvaluacionEmpleado(tipoevaluacionempleado);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoEvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEvaluacionEmpleado(this.tipoevaluacionempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoevaluacionempleados = new  ArrayList<TipoEvaluacionEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEvaluacionEmpleado.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoEvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoevaluacionempleados=tipoevaluacionempleadoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoEvaluacionEmpleado(tipoevaluacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoEvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEvaluacionEmpleado(this.tipoevaluacionempleados);
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
		tipoevaluacionempleados = new  ArrayList<TipoEvaluacionEmpleado>();
		  		  
        try {
			TipoEvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoevaluacionempleados=tipoevaluacionempleadoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoEvaluacionEmpleado(tipoevaluacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoEvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEvaluacionEmpleado(this.tipoevaluacionempleados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoEvaluacionEmpleadosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoevaluacionempleados = new  ArrayList<TipoEvaluacionEmpleado>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEvaluacionEmpleado.class.getSimpleName()+"-getTodosTipoEvaluacionEmpleadosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoEvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoevaluacionempleados=tipoevaluacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoEvaluacionEmpleado(tipoevaluacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoEvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEvaluacionEmpleado(this.tipoevaluacionempleados);
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
	
	public  void  getTodosTipoEvaluacionEmpleados(String sFinalQuery,Pagination pagination)throws Exception {
		tipoevaluacionempleados = new  ArrayList<TipoEvaluacionEmpleado>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoEvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoevaluacionempleados=tipoevaluacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoEvaluacionEmpleado(tipoevaluacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoEvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEvaluacionEmpleado(this.tipoevaluacionempleados);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoEvaluacionEmpleado(TipoEvaluacionEmpleado tipoevaluacionempleado) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoevaluacionempleado.getIsNew() || tipoevaluacionempleado.getIsChanged()) { 
			this.invalidValues = tipoevaluacionempleadoValidator.getInvalidValues(tipoevaluacionempleado);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoevaluacionempleado);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoEvaluacionEmpleado(List<TipoEvaluacionEmpleado> TipoEvaluacionEmpleados) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoEvaluacionEmpleado tipoevaluacionempleadoLocal:tipoevaluacionempleados) {				
			estaValidadoObjeto=this.validarGuardarTipoEvaluacionEmpleado(tipoevaluacionempleadoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoEvaluacionEmpleado(List<TipoEvaluacionEmpleado> TipoEvaluacionEmpleados) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoEvaluacionEmpleado(tipoevaluacionempleados)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoEvaluacionEmpleado(TipoEvaluacionEmpleado TipoEvaluacionEmpleado) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoEvaluacionEmpleado(tipoevaluacionempleado)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoEvaluacionEmpleado tipoevaluacionempleado) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoevaluacionempleado.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoEvaluacionEmpleadoConstantesFunciones.getTipoEvaluacionEmpleadoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoevaluacionempleado","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoEvaluacionEmpleadoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoEvaluacionEmpleadoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoEvaluacionEmpleadoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEvaluacionEmpleado.class.getSimpleName()+"-saveTipoEvaluacionEmpleadoWithConnection");connexion.begin();			
			
			TipoEvaluacionEmpleadoLogicAdditional.checkTipoEvaluacionEmpleadoToSave(this.tipoevaluacionempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoEvaluacionEmpleadoLogicAdditional.updateTipoEvaluacionEmpleadoToSave(this.tipoevaluacionempleado,this.arrDatoGeneral);
			
			TipoEvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoevaluacionempleado,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoEvaluacionEmpleado();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoEvaluacionEmpleado(this.tipoevaluacionempleado)) {
				TipoEvaluacionEmpleadoDataAccess.save(this.tipoevaluacionempleado, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoevaluacionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoEvaluacionEmpleadoLogicAdditional.checkTipoEvaluacionEmpleadoToSaveAfter(this.tipoevaluacionempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoEvaluacionEmpleado();
			
			connexion.commit();			
			
			if(this.tipoevaluacionempleado.getIsDeleted()) {
				this.tipoevaluacionempleado=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoEvaluacionEmpleado()throws Exception {	
		try {	
			
			TipoEvaluacionEmpleadoLogicAdditional.checkTipoEvaluacionEmpleadoToSave(this.tipoevaluacionempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoEvaluacionEmpleadoLogicAdditional.updateTipoEvaluacionEmpleadoToSave(this.tipoevaluacionempleado,this.arrDatoGeneral);
			
			TipoEvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoevaluacionempleado,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoEvaluacionEmpleado(this.tipoevaluacionempleado)) {			
				TipoEvaluacionEmpleadoDataAccess.save(this.tipoevaluacionempleado, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoevaluacionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoEvaluacionEmpleadoLogicAdditional.checkTipoEvaluacionEmpleadoToSaveAfter(this.tipoevaluacionempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoevaluacionempleado.getIsDeleted()) {
				this.tipoevaluacionempleado=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoEvaluacionEmpleadosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEvaluacionEmpleado.class.getSimpleName()+"-saveTipoEvaluacionEmpleadosWithConnection");connexion.begin();			
			
			TipoEvaluacionEmpleadoLogicAdditional.checkTipoEvaluacionEmpleadoToSaves(tipoevaluacionempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoEvaluacionEmpleados();
			
			Boolean validadoTodosTipoEvaluacionEmpleado=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoEvaluacionEmpleado tipoevaluacionempleadoLocal:tipoevaluacionempleados) {		
				if(tipoevaluacionempleadoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoEvaluacionEmpleadoLogicAdditional.updateTipoEvaluacionEmpleadoToSave(tipoevaluacionempleadoLocal,this.arrDatoGeneral);
	        	
				TipoEvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoevaluacionempleadoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoEvaluacionEmpleado(tipoevaluacionempleadoLocal)) {
					TipoEvaluacionEmpleadoDataAccess.save(tipoevaluacionempleadoLocal, connexion);				
				} else {
					validadoTodosTipoEvaluacionEmpleado=false;
				}
			}
			
			if(!validadoTodosTipoEvaluacionEmpleado) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoEvaluacionEmpleadoLogicAdditional.checkTipoEvaluacionEmpleadoToSavesAfter(tipoevaluacionempleados,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoEvaluacionEmpleados();
			
			connexion.commit();		
			
			this.quitarTipoEvaluacionEmpleadosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoEvaluacionEmpleados()throws Exception {				
		 try {	
			TipoEvaluacionEmpleadoLogicAdditional.checkTipoEvaluacionEmpleadoToSaves(tipoevaluacionempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoEvaluacionEmpleado=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoEvaluacionEmpleado tipoevaluacionempleadoLocal:tipoevaluacionempleados) {				
				if(tipoevaluacionempleadoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoEvaluacionEmpleadoLogicAdditional.updateTipoEvaluacionEmpleadoToSave(tipoevaluacionempleadoLocal,this.arrDatoGeneral);
	        	
				TipoEvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoevaluacionempleadoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoEvaluacionEmpleado(tipoevaluacionempleadoLocal)) {				
					TipoEvaluacionEmpleadoDataAccess.save(tipoevaluacionempleadoLocal, connexion);				
				} else {
					validadoTodosTipoEvaluacionEmpleado=false;
				}
			}
			
			if(!validadoTodosTipoEvaluacionEmpleado) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoEvaluacionEmpleadoLogicAdditional.checkTipoEvaluacionEmpleadoToSavesAfter(tipoevaluacionempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoEvaluacionEmpleadosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoEvaluacionEmpleadoParameterReturnGeneral procesarAccionTipoEvaluacionEmpleados(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoEvaluacionEmpleado> tipoevaluacionempleados,TipoEvaluacionEmpleadoParameterReturnGeneral tipoevaluacionempleadoParameterGeneral)throws Exception {
		 try {	
			TipoEvaluacionEmpleadoParameterReturnGeneral tipoevaluacionempleadoReturnGeneral=new TipoEvaluacionEmpleadoParameterReturnGeneral();
	
			TipoEvaluacionEmpleadoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoevaluacionempleados,tipoevaluacionempleadoParameterGeneral,tipoevaluacionempleadoReturnGeneral);
			
			return tipoevaluacionempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoEvaluacionEmpleadoParameterReturnGeneral procesarAccionTipoEvaluacionEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoEvaluacionEmpleado> tipoevaluacionempleados,TipoEvaluacionEmpleadoParameterReturnGeneral tipoevaluacionempleadoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEvaluacionEmpleado.class.getSimpleName()+"-procesarAccionTipoEvaluacionEmpleadosWithConnection");connexion.begin();			
			
			TipoEvaluacionEmpleadoParameterReturnGeneral tipoevaluacionempleadoReturnGeneral=new TipoEvaluacionEmpleadoParameterReturnGeneral();
	
			TipoEvaluacionEmpleadoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoevaluacionempleados,tipoevaluacionempleadoParameterGeneral,tipoevaluacionempleadoReturnGeneral);
			
			this.connexion.commit();
			
			return tipoevaluacionempleadoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoEvaluacionEmpleadoParameterReturnGeneral procesarEventosTipoEvaluacionEmpleados(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoEvaluacionEmpleado> tipoevaluacionempleados,TipoEvaluacionEmpleado tipoevaluacionempleado,TipoEvaluacionEmpleadoParameterReturnGeneral tipoevaluacionempleadoParameterGeneral,Boolean isEsNuevoTipoEvaluacionEmpleado,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoEvaluacionEmpleadoParameterReturnGeneral tipoevaluacionempleadoReturnGeneral=new TipoEvaluacionEmpleadoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoevaluacionempleadoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoEvaluacionEmpleadoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoevaluacionempleados,tipoevaluacionempleado,tipoevaluacionempleadoParameterGeneral,tipoevaluacionempleadoReturnGeneral,isEsNuevoTipoEvaluacionEmpleado,clases);
			
			return tipoevaluacionempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoEvaluacionEmpleadoParameterReturnGeneral procesarEventosTipoEvaluacionEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoEvaluacionEmpleado> tipoevaluacionempleados,TipoEvaluacionEmpleado tipoevaluacionempleado,TipoEvaluacionEmpleadoParameterReturnGeneral tipoevaluacionempleadoParameterGeneral,Boolean isEsNuevoTipoEvaluacionEmpleado,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEvaluacionEmpleado.class.getSimpleName()+"-procesarEventosTipoEvaluacionEmpleadosWithConnection");connexion.begin();			
			
			TipoEvaluacionEmpleadoParameterReturnGeneral tipoevaluacionempleadoReturnGeneral=new TipoEvaluacionEmpleadoParameterReturnGeneral();
	
			tipoevaluacionempleadoReturnGeneral.setTipoEvaluacionEmpleado(tipoevaluacionempleado);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoevaluacionempleadoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoEvaluacionEmpleadoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoevaluacionempleados,tipoevaluacionempleado,tipoevaluacionempleadoParameterGeneral,tipoevaluacionempleadoReturnGeneral,isEsNuevoTipoEvaluacionEmpleado,clases);
			
			this.connexion.commit();
			
			return tipoevaluacionempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoEvaluacionEmpleadoParameterReturnGeneral procesarImportacionTipoEvaluacionEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoEvaluacionEmpleadoParameterReturnGeneral tipoevaluacionempleadoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEvaluacionEmpleado.class.getSimpleName()+"-procesarImportacionTipoEvaluacionEmpleadosWithConnection");connexion.begin();			
			
			TipoEvaluacionEmpleadoParameterReturnGeneral tipoevaluacionempleadoReturnGeneral=new TipoEvaluacionEmpleadoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoevaluacionempleados=new ArrayList<TipoEvaluacionEmpleado>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoevaluacionempleado=new TipoEvaluacionEmpleado();
				
				
				if(conColumnasBase) {this.tipoevaluacionempleado.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoevaluacionempleado.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoevaluacionempleado.setcodigo(arrColumnas[iColumn++]);
				this.tipoevaluacionempleado.setnombre(arrColumnas[iColumn++]);
				
				this.tipoevaluacionempleados.add(this.tipoevaluacionempleado);
			}
			
			this.saveTipoEvaluacionEmpleados();
			
			this.connexion.commit();
			
			tipoevaluacionempleadoReturnGeneral.setConRetornoEstaProcesado(true);
			tipoevaluacionempleadoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoevaluacionempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoEvaluacionEmpleadosEliminados() throws Exception {				
		
		List<TipoEvaluacionEmpleado> tipoevaluacionempleadosAux= new ArrayList<TipoEvaluacionEmpleado>();
		
		for(TipoEvaluacionEmpleado tipoevaluacionempleado:tipoevaluacionempleados) {
			if(!tipoevaluacionempleado.getIsDeleted()) {
				tipoevaluacionempleadosAux.add(tipoevaluacionempleado);
			}
		}
		
		tipoevaluacionempleados=tipoevaluacionempleadosAux;
	}
	
	public void quitarTipoEvaluacionEmpleadosNulos() throws Exception {				
		
		List<TipoEvaluacionEmpleado> tipoevaluacionempleadosAux= new ArrayList<TipoEvaluacionEmpleado>();
		
		for(TipoEvaluacionEmpleado tipoevaluacionempleado : this.tipoevaluacionempleados) {
			if(tipoevaluacionempleado==null) {
				tipoevaluacionempleadosAux.add(tipoevaluacionempleado);
			}
		}
		
		//this.tipoevaluacionempleados=tipoevaluacionempleadosAux;
		
		this.tipoevaluacionempleados.removeAll(tipoevaluacionempleadosAux);
	}
	
	public void getSetVersionRowTipoEvaluacionEmpleadoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoevaluacionempleado.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoevaluacionempleado.getIsDeleted() || (tipoevaluacionempleado.getIsChanged()&&!tipoevaluacionempleado.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoevaluacionempleadoDataAccess.getSetVersionRowTipoEvaluacionEmpleado(connexion,tipoevaluacionempleado.getId());
				
				if(!tipoevaluacionempleado.getVersionRow().equals(timestamp)) {	
					tipoevaluacionempleado.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoevaluacionempleado.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoEvaluacionEmpleado()throws Exception {	
		
		if(tipoevaluacionempleado.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoevaluacionempleado.getIsDeleted() || (tipoevaluacionempleado.getIsChanged()&&!tipoevaluacionempleado.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoevaluacionempleadoDataAccess.getSetVersionRowTipoEvaluacionEmpleado(connexion,tipoevaluacionempleado.getId());
			
			try {							
				if(!tipoevaluacionempleado.getVersionRow().equals(timestamp)) {	
					tipoevaluacionempleado.setVersionRow(timestamp);
				}
				
				tipoevaluacionempleado.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoEvaluacionEmpleadosWithConnection()throws Exception {	
		if(tipoevaluacionempleados!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoEvaluacionEmpleado tipoevaluacionempleadoAux:tipoevaluacionempleados) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoevaluacionempleadoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoevaluacionempleadoAux.getIsDeleted() || (tipoevaluacionempleadoAux.getIsChanged()&&!tipoevaluacionempleadoAux.getIsNew())) {
						
						timestamp=tipoevaluacionempleadoDataAccess.getSetVersionRowTipoEvaluacionEmpleado(connexion,tipoevaluacionempleadoAux.getId());
						
						if(!tipoevaluacionempleado.getVersionRow().equals(timestamp)) {	
							tipoevaluacionempleadoAux.setVersionRow(timestamp);
						}
								
						tipoevaluacionempleadoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoEvaluacionEmpleados()throws Exception {	
		if(tipoevaluacionempleados!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoEvaluacionEmpleado tipoevaluacionempleadoAux:tipoevaluacionempleados) {
					if(tipoevaluacionempleadoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoevaluacionempleadoAux.getIsDeleted() || (tipoevaluacionempleadoAux.getIsChanged()&&!tipoevaluacionempleadoAux.getIsNew())) {
						
						timestamp=tipoevaluacionempleadoDataAccess.getSetVersionRowTipoEvaluacionEmpleado(connexion,tipoevaluacionempleadoAux.getId());
						
						if(!tipoevaluacionempleadoAux.getVersionRow().equals(timestamp)) {	
							tipoevaluacionempleadoAux.setVersionRow(timestamp);
						}
						
													
						tipoevaluacionempleadoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public TipoEvaluacionEmpleadoParameterReturnGeneral cargarCombosLoteForeignKeyTipoEvaluacionEmpleadoWithConnection(String finalQueryGlobalEmpresa) throws Exception {
		TipoEvaluacionEmpleadoParameterReturnGeneral  tipoevaluacionempleadoReturnGeneral =new TipoEvaluacionEmpleadoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEvaluacionEmpleado.class.getSimpleName()+"-cargarCombosLoteForeignKeyTipoEvaluacionEmpleadoWithConnection");connexion.begin();
			
			tipoevaluacionempleadoReturnGeneral =new TipoEvaluacionEmpleadoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoevaluacionempleadoReturnGeneral.setempresasForeignKey(empresasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return tipoevaluacionempleadoReturnGeneral;
	}
	
	public TipoEvaluacionEmpleadoParameterReturnGeneral cargarCombosLoteForeignKeyTipoEvaluacionEmpleado(String finalQueryGlobalEmpresa) throws Exception {
		TipoEvaluacionEmpleadoParameterReturnGeneral  tipoevaluacionempleadoReturnGeneral =new TipoEvaluacionEmpleadoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			tipoevaluacionempleadoReturnGeneral =new TipoEvaluacionEmpleadoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			tipoevaluacionempleadoReturnGeneral.setempresasForeignKey(empresasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return tipoevaluacionempleadoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyTipoEvaluacionEmpleadoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			EvaluacionEmpleadoLogic evaluacionempleadoLogic=new EvaluacionEmpleadoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEvaluacionEmpleado.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoEvaluacionEmpleadoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(EvaluacionEmpleado.class));
											
			

			evaluacionempleadoLogic.setConnexion(this.getConnexion());
			evaluacionempleadoLogic.setDatosCliente(this.datosCliente);
			evaluacionempleadoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoEvaluacionEmpleado tipoevaluacionempleado:this.tipoevaluacionempleados) {
				

				classes=new ArrayList<Classe>();
				classes=EvaluacionEmpleadoConstantesFunciones.getClassesForeignKeysOfEvaluacionEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);

				evaluacionempleadoLogic.setEvaluacionEmpleados(tipoevaluacionempleado.evaluacionempleados);
				evaluacionempleadoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoEvaluacionEmpleado tipoevaluacionempleado,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoEvaluacionEmpleadoLogicAdditional.updateTipoEvaluacionEmpleadoToGet(tipoevaluacionempleado,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoevaluacionempleado.setEmpresa(tipoevaluacionempleadoDataAccess.getEmpresa(connexion,tipoevaluacionempleado));
		tipoevaluacionempleado.setEvaluacionEmpleados(tipoevaluacionempleadoDataAccess.getEvaluacionEmpleados(connexion,tipoevaluacionempleado));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoevaluacionempleado.setEmpresa(tipoevaluacionempleadoDataAccess.getEmpresa(connexion,tipoevaluacionempleado));
				continue;
			}

			if(clas.clas.equals(EvaluacionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoevaluacionempleado.setEvaluacionEmpleados(tipoevaluacionempleadoDataAccess.getEvaluacionEmpleados(connexion,tipoevaluacionempleado));

				if(this.isConDeep) {
					EvaluacionEmpleadoLogic evaluacionempleadoLogic= new EvaluacionEmpleadoLogic(this.connexion);
					evaluacionempleadoLogic.setEvaluacionEmpleados(tipoevaluacionempleado.getEvaluacionEmpleados());
					ArrayList<Classe> classesLocal=EvaluacionEmpleadoConstantesFunciones.getClassesForeignKeysOfEvaluacionEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);
					evaluacionempleadoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					EvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEvaluacionEmpleado(evaluacionempleadoLogic.getEvaluacionEmpleados());
					tipoevaluacionempleado.setEvaluacionEmpleados(evaluacionempleadoLogic.getEvaluacionEmpleados());
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
			tipoevaluacionempleado.setEmpresa(tipoevaluacionempleadoDataAccess.getEmpresa(connexion,tipoevaluacionempleado));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EvaluacionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EvaluacionEmpleado.class));
			tipoevaluacionempleado.setEvaluacionEmpleados(tipoevaluacionempleadoDataAccess.getEvaluacionEmpleados(connexion,tipoevaluacionempleado));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoevaluacionempleado.setEmpresa(tipoevaluacionempleadoDataAccess.getEmpresa(connexion,tipoevaluacionempleado));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoevaluacionempleado.getEmpresa(),isDeep,deepLoadType,clases);
				

		tipoevaluacionempleado.setEvaluacionEmpleados(tipoevaluacionempleadoDataAccess.getEvaluacionEmpleados(connexion,tipoevaluacionempleado));

		for(EvaluacionEmpleado evaluacionempleado:tipoevaluacionempleado.getEvaluacionEmpleados()) {
			EvaluacionEmpleadoLogic evaluacionempleadoLogic= new EvaluacionEmpleadoLogic(connexion);
			evaluacionempleadoLogic.deepLoad(evaluacionempleado,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				tipoevaluacionempleado.setEmpresa(tipoevaluacionempleadoDataAccess.getEmpresa(connexion,tipoevaluacionempleado));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(tipoevaluacionempleado.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EvaluacionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoevaluacionempleado.setEvaluacionEmpleados(tipoevaluacionempleadoDataAccess.getEvaluacionEmpleados(connexion,tipoevaluacionempleado));

				for(EvaluacionEmpleado evaluacionempleado:tipoevaluacionempleado.getEvaluacionEmpleados()) {
					EvaluacionEmpleadoLogic evaluacionempleadoLogic= new EvaluacionEmpleadoLogic(connexion);
					evaluacionempleadoLogic.deepLoad(evaluacionempleado,isDeep,deepLoadType,clases);
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
			tipoevaluacionempleado.setEmpresa(tipoevaluacionempleadoDataAccess.getEmpresa(connexion,tipoevaluacionempleado));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(tipoevaluacionempleado.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EvaluacionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EvaluacionEmpleado.class));
			tipoevaluacionempleado.setEvaluacionEmpleados(tipoevaluacionempleadoDataAccess.getEvaluacionEmpleados(connexion,tipoevaluacionempleado));

			for(EvaluacionEmpleado evaluacionempleado:tipoevaluacionempleado.getEvaluacionEmpleados()) {
				EvaluacionEmpleadoLogic evaluacionempleadoLogic= new EvaluacionEmpleadoLogic(connexion);
				evaluacionempleadoLogic.deepLoad(evaluacionempleado,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoEvaluacionEmpleado tipoevaluacionempleado,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoEvaluacionEmpleadoLogicAdditional.updateTipoEvaluacionEmpleadoToSave(tipoevaluacionempleado,this.arrDatoGeneral);
			
TipoEvaluacionEmpleadoDataAccess.save(tipoevaluacionempleado, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipoevaluacionempleado.getEmpresa(),connexion);

		for(EvaluacionEmpleado evaluacionempleado:tipoevaluacionempleado.getEvaluacionEmpleados()) {
			evaluacionempleado.setid_tipo_evaluacion_empleado(tipoevaluacionempleado.getId());
			EvaluacionEmpleadoDataAccess.save(evaluacionempleado,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipoevaluacionempleado.getEmpresa(),connexion);
				continue;
			}


			if(clas.clas.equals(EvaluacionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EvaluacionEmpleado evaluacionempleado:tipoevaluacionempleado.getEvaluacionEmpleados()) {
					evaluacionempleado.setid_tipo_evaluacion_empleado(tipoevaluacionempleado.getId());
					EvaluacionEmpleadoDataAccess.save(evaluacionempleado,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(tipoevaluacionempleado.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(tipoevaluacionempleado.getEmpresa(),isDeep,deepLoadType,clases);
				

		for(EvaluacionEmpleado evaluacionempleado:tipoevaluacionempleado.getEvaluacionEmpleados()) {
			EvaluacionEmpleadoLogic evaluacionempleadoLogic= new EvaluacionEmpleadoLogic(connexion);
			evaluacionempleado.setid_tipo_evaluacion_empleado(tipoevaluacionempleado.getId());
			EvaluacionEmpleadoDataAccess.save(evaluacionempleado,connexion);
			evaluacionempleadoLogic.deepSave(evaluacionempleado,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(tipoevaluacionempleado.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(tipoevaluacionempleado.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(EvaluacionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EvaluacionEmpleado evaluacionempleado:tipoevaluacionempleado.getEvaluacionEmpleados()) {
					EvaluacionEmpleadoLogic evaluacionempleadoLogic= new EvaluacionEmpleadoLogic(connexion);
					evaluacionempleado.setid_tipo_evaluacion_empleado(tipoevaluacionempleado.getId());
					EvaluacionEmpleadoDataAccess.save(evaluacionempleado,connexion);
					evaluacionempleadoLogic.deepSave(evaluacionempleado,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoEvaluacionEmpleado.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoevaluacionempleado,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoEvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEvaluacionEmpleado(tipoevaluacionempleado);
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
			this.deepLoad(this.tipoevaluacionempleado,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoEvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEvaluacionEmpleado(this.tipoevaluacionempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoEvaluacionEmpleado.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoevaluacionempleados!=null) {
				for(TipoEvaluacionEmpleado tipoevaluacionempleado:tipoevaluacionempleados) {
					this.deepLoad(tipoevaluacionempleado,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoEvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEvaluacionEmpleado(tipoevaluacionempleados);
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
			if(tipoevaluacionempleados!=null) {
				for(TipoEvaluacionEmpleado tipoevaluacionempleado:tipoevaluacionempleados) {
					this.deepLoad(tipoevaluacionempleado,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoEvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEvaluacionEmpleado(tipoevaluacionempleados);
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
			this.getNewConnexionToDeep(TipoEvaluacionEmpleado.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipoevaluacionempleado,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoEvaluacionEmpleado.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipoevaluacionempleados!=null) {
				for(TipoEvaluacionEmpleado tipoevaluacionempleado:tipoevaluacionempleados) {
					this.deepSave(tipoevaluacionempleado,isDeep,deepLoadType,clases);
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
			if(tipoevaluacionempleados!=null) {
				for(TipoEvaluacionEmpleado tipoevaluacionempleado:tipoevaluacionempleados) {
					this.deepSave(tipoevaluacionempleado,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getTipoEvaluacionEmpleadosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoEvaluacionEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoEvaluacionEmpleadoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoEvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoevaluacionempleados=tipoevaluacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoEvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEvaluacionEmpleado(this.tipoevaluacionempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getTipoEvaluacionEmpleadosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,TipoEvaluacionEmpleadoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			TipoEvaluacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			tipoevaluacionempleados=tipoevaluacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				TipoEvaluacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoEvaluacionEmpleado(this.tipoevaluacionempleados);
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
			if(TipoEvaluacionEmpleadoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoEvaluacionEmpleadoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoEvaluacionEmpleado tipoevaluacionempleado,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoEvaluacionEmpleadoConstantesFunciones.ISCONAUDITORIA) {
				if(tipoevaluacionempleado.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoEvaluacionEmpleadoDataAccess.TABLENAME, tipoevaluacionempleado.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoEvaluacionEmpleadoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoEvaluacionEmpleadoLogic.registrarAuditoriaDetallesTipoEvaluacionEmpleado(connexion,tipoevaluacionempleado,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoevaluacionempleado.getIsDeleted()) {
					/*if(!tipoevaluacionempleado.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoEvaluacionEmpleadoDataAccess.TABLENAME, tipoevaluacionempleado.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoEvaluacionEmpleadoLogic.registrarAuditoriaDetallesTipoEvaluacionEmpleado(connexion,tipoevaluacionempleado,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoEvaluacionEmpleadoDataAccess.TABLENAME, tipoevaluacionempleado.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoevaluacionempleado.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoEvaluacionEmpleadoDataAccess.TABLENAME, tipoevaluacionempleado.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoEvaluacionEmpleadoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoEvaluacionEmpleadoLogic.registrarAuditoriaDetallesTipoEvaluacionEmpleado(connexion,tipoevaluacionempleado,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoEvaluacionEmpleado(Connexion connexion,TipoEvaluacionEmpleado tipoevaluacionempleado)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoevaluacionempleado.getIsNew()||!tipoevaluacionempleado.getid_empresa().equals(tipoevaluacionempleado.getTipoEvaluacionEmpleadoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoevaluacionempleado.getTipoEvaluacionEmpleadoOriginal().getid_empresa()!=null)
				{
					strValorActual=tipoevaluacionempleado.getTipoEvaluacionEmpleadoOriginal().getid_empresa().toString();
				}
				if(tipoevaluacionempleado.getid_empresa()!=null)
				{
					strValorNuevo=tipoevaluacionempleado.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoEvaluacionEmpleadoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(tipoevaluacionempleado.getIsNew()||!tipoevaluacionempleado.getcodigo().equals(tipoevaluacionempleado.getTipoEvaluacionEmpleadoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoevaluacionempleado.getTipoEvaluacionEmpleadoOriginal().getcodigo()!=null)
				{
					strValorActual=tipoevaluacionempleado.getTipoEvaluacionEmpleadoOriginal().getcodigo();
				}
				if(tipoevaluacionempleado.getcodigo()!=null)
				{
					strValorNuevo=tipoevaluacionempleado.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoEvaluacionEmpleadoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipoevaluacionempleado.getIsNew()||!tipoevaluacionempleado.getnombre().equals(tipoevaluacionempleado.getTipoEvaluacionEmpleadoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoevaluacionempleado.getTipoEvaluacionEmpleadoOriginal().getnombre()!=null)
				{
					strValorActual=tipoevaluacionempleado.getTipoEvaluacionEmpleadoOriginal().getnombre();
				}
				if(tipoevaluacionempleado.getnombre()!=null)
				{
					strValorNuevo=tipoevaluacionempleado.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoEvaluacionEmpleadoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoEvaluacionEmpleadoRelacionesWithConnection(TipoEvaluacionEmpleado tipoevaluacionempleado,List<EvaluacionEmpleado> evaluacionempleados) throws Exception {

		if(!tipoevaluacionempleado.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoEvaluacionEmpleadoRelacionesBase(tipoevaluacionempleado,evaluacionempleados,true);
		}
	}

	public void saveTipoEvaluacionEmpleadoRelaciones(TipoEvaluacionEmpleado tipoevaluacionempleado,List<EvaluacionEmpleado> evaluacionempleados)throws Exception {

		if(!tipoevaluacionempleado.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoEvaluacionEmpleadoRelacionesBase(tipoevaluacionempleado,evaluacionempleados,false);
		}
	}

	public void saveTipoEvaluacionEmpleadoRelacionesBase(TipoEvaluacionEmpleado tipoevaluacionempleado,List<EvaluacionEmpleado> evaluacionempleados,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoEvaluacionEmpleado-saveRelacionesWithConnection");}
	
			tipoevaluacionempleado.setEvaluacionEmpleados(evaluacionempleados);

			this.setTipoEvaluacionEmpleado(tipoevaluacionempleado);

			if(TipoEvaluacionEmpleadoLogicAdditional.validarSaveRelaciones(tipoevaluacionempleado,this)) {

				TipoEvaluacionEmpleadoLogicAdditional.updateRelacionesToSave(tipoevaluacionempleado,this);

				if((tipoevaluacionempleado.getIsNew()||tipoevaluacionempleado.getIsChanged())&&!tipoevaluacionempleado.getIsDeleted()) {
					this.saveTipoEvaluacionEmpleado();
					this.saveTipoEvaluacionEmpleadoRelacionesDetalles(evaluacionempleados);

				} else if(tipoevaluacionempleado.getIsDeleted()) {
					this.saveTipoEvaluacionEmpleadoRelacionesDetalles(evaluacionempleados);
					this.saveTipoEvaluacionEmpleado();
				}

				TipoEvaluacionEmpleadoLogicAdditional.updateRelacionesToSaveAfter(tipoevaluacionempleado,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			EvaluacionEmpleadoConstantesFunciones.InicializarGeneralEntityAuxiliaresEvaluacionEmpleados(evaluacionempleados,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoEvaluacionEmpleadoRelacionesDetalles(List<EvaluacionEmpleado> evaluacionempleados)throws Exception {
		try {
	

			Long idTipoEvaluacionEmpleadoActual=this.getTipoEvaluacionEmpleado().getId();

			EvaluacionEmpleadoLogic evaluacionempleadoLogic_Desde_TipoEvaluacionEmpleado=new EvaluacionEmpleadoLogic();
			evaluacionempleadoLogic_Desde_TipoEvaluacionEmpleado.setEvaluacionEmpleados(evaluacionempleados);

			evaluacionempleadoLogic_Desde_TipoEvaluacionEmpleado.setConnexion(this.getConnexion());
			evaluacionempleadoLogic_Desde_TipoEvaluacionEmpleado.setDatosCliente(this.datosCliente);

			for(EvaluacionEmpleado evaluacionempleado_Desde_TipoEvaluacionEmpleado:evaluacionempleadoLogic_Desde_TipoEvaluacionEmpleado.getEvaluacionEmpleados()) {
				evaluacionempleado_Desde_TipoEvaluacionEmpleado.setid_tipo_evaluacion_empleado(idTipoEvaluacionEmpleadoActual);

				evaluacionempleadoLogic_Desde_TipoEvaluacionEmpleado.setEvaluacionEmpleado(evaluacionempleado_Desde_TipoEvaluacionEmpleado);
				evaluacionempleadoLogic_Desde_TipoEvaluacionEmpleado.saveEvaluacionEmpleado();

				Long idEvaluacionEmpleadoActual=evaluacionempleado_Desde_TipoEvaluacionEmpleado.getId();

				CalificacionEmpleadoLogic calificacionempleadoLogic_Desde_EvaluacionEmpleado=new CalificacionEmpleadoLogic();

				if(evaluacionempleado_Desde_TipoEvaluacionEmpleado.getCalificacionEmpleados()==null){
					evaluacionempleado_Desde_TipoEvaluacionEmpleado.setCalificacionEmpleados(new ArrayList<CalificacionEmpleado>());
				}

				calificacionempleadoLogic_Desde_EvaluacionEmpleado.setCalificacionEmpleados(evaluacionempleado_Desde_TipoEvaluacionEmpleado.getCalificacionEmpleados());

				calificacionempleadoLogic_Desde_EvaluacionEmpleado.setConnexion(this.getConnexion());
				calificacionempleadoLogic_Desde_EvaluacionEmpleado.setDatosCliente(this.datosCliente);

				for(CalificacionEmpleado calificacionempleado_Desde_EvaluacionEmpleado:calificacionempleadoLogic_Desde_EvaluacionEmpleado.getCalificacionEmpleados()) {
					calificacionempleado_Desde_EvaluacionEmpleado.setid_evaluacion_empleado(idEvaluacionEmpleadoActual);
				}

				calificacionempleadoLogic_Desde_EvaluacionEmpleado.saveCalificacionEmpleados();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoEvaluacionEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoEvaluacionEmpleadoConstantesFunciones.getClassesForeignKeysOfTipoEvaluacionEmpleado(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoEvaluacionEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoEvaluacionEmpleadoConstantesFunciones.getClassesRelationshipsOfTipoEvaluacionEmpleado(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

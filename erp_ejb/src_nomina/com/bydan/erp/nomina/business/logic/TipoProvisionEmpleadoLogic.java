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
import com.bydan.erp.nomina.util.TipoProvisionEmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.TipoProvisionEmpleadoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoProvisionEmpleadoParameterGeneral;
import com.bydan.erp.nomina.business.entity.TipoProvisionEmpleado;
import com.bydan.erp.nomina.business.logic.TipoProvisionEmpleadoLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;
















@SuppressWarnings("unused")
public class TipoProvisionEmpleadoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(TipoProvisionEmpleadoLogic.class);
	
	protected TipoProvisionEmpleadoDataAccess tipoprovisionempleadoDataAccess; 	
	protected TipoProvisionEmpleado tipoprovisionempleado;
	protected List<TipoProvisionEmpleado> tipoprovisionempleados;
	protected Object tipoprovisionempleadoObject;	
	protected List<Object> tipoprovisionempleadosObject;
	
	public static ClassValidator<TipoProvisionEmpleado> tipoprovisionempleadoValidator = new ClassValidator<TipoProvisionEmpleado>(TipoProvisionEmpleado.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected TipoProvisionEmpleadoLogicAdditional tipoprovisionempleadoLogicAdditional=null;
	
	public TipoProvisionEmpleadoLogicAdditional getTipoProvisionEmpleadoLogicAdditional() {
		return this.tipoprovisionempleadoLogicAdditional;
	}
	
	public void setTipoProvisionEmpleadoLogicAdditional(TipoProvisionEmpleadoLogicAdditional tipoprovisionempleadoLogicAdditional) {
		try {
			this.tipoprovisionempleadoLogicAdditional=tipoprovisionempleadoLogicAdditional;
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
	
	
	
	
	public  TipoProvisionEmpleadoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.tipoprovisionempleadoDataAccess = new TipoProvisionEmpleadoDataAccess();
			
			this.tipoprovisionempleados= new ArrayList<TipoProvisionEmpleado>();
			this.tipoprovisionempleado= new TipoProvisionEmpleado();
			
			this.tipoprovisionempleadoObject=new Object();
			this.tipoprovisionempleadosObject=new ArrayList<Object>();
				
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
			
			this.tipoprovisionempleadoDataAccess.setConnexionType(this.connexionType);
			this.tipoprovisionempleadoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  TipoProvisionEmpleadoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.tipoprovisionempleadoDataAccess = new TipoProvisionEmpleadoDataAccess();
			this.tipoprovisionempleados= new ArrayList<TipoProvisionEmpleado>();
			this.tipoprovisionempleado= new TipoProvisionEmpleado();
			this.tipoprovisionempleadoObject=new Object();
			this.tipoprovisionempleadosObject=new ArrayList<Object>();
			
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
			
			this.tipoprovisionempleadoDataAccess.setConnexionType(this.connexionType);
			this.tipoprovisionempleadoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public TipoProvisionEmpleado getTipoProvisionEmpleado() throws Exception {	
		TipoProvisionEmpleadoLogicAdditional.checkTipoProvisionEmpleadoToGet(tipoprovisionempleado,this.datosCliente,this.arrDatoGeneral);
		TipoProvisionEmpleadoLogicAdditional.updateTipoProvisionEmpleadoToGet(tipoprovisionempleado,this.arrDatoGeneral);
		
		return tipoprovisionempleado;
	}
		
	public void setTipoProvisionEmpleado(TipoProvisionEmpleado newTipoProvisionEmpleado) {
		this.tipoprovisionempleado = newTipoProvisionEmpleado;
	}
	
	public TipoProvisionEmpleadoDataAccess getTipoProvisionEmpleadoDataAccess() {
		return tipoprovisionempleadoDataAccess;
	}
	
	public void setTipoProvisionEmpleadoDataAccess(TipoProvisionEmpleadoDataAccess newtipoprovisionempleadoDataAccess) {
		this.tipoprovisionempleadoDataAccess = newtipoprovisionempleadoDataAccess;
	}
	
	public List<TipoProvisionEmpleado> getTipoProvisionEmpleados() throws Exception {		
		this.quitarTipoProvisionEmpleadosNulos();
		
		TipoProvisionEmpleadoLogicAdditional.checkTipoProvisionEmpleadoToGets(tipoprovisionempleados,this.datosCliente,this.arrDatoGeneral);
		
		for (TipoProvisionEmpleado tipoprovisionempleadoLocal: tipoprovisionempleados ) {
			TipoProvisionEmpleadoLogicAdditional.updateTipoProvisionEmpleadoToGet(tipoprovisionempleadoLocal,this.arrDatoGeneral);
		}
		
		return tipoprovisionempleados;
	}
	
	public void setTipoProvisionEmpleados(List<TipoProvisionEmpleado> newTipoProvisionEmpleados) {
		this.tipoprovisionempleados = newTipoProvisionEmpleados;
	}
	
	public Object getTipoProvisionEmpleadoObject() {	
		this.tipoprovisionempleadoObject=this.tipoprovisionempleadoDataAccess.getEntityObject();
		return this.tipoprovisionempleadoObject;
	}
		
	public void setTipoProvisionEmpleadoObject(Object newTipoProvisionEmpleadoObject) {
		this.tipoprovisionempleadoObject = newTipoProvisionEmpleadoObject;
	}
	
	public List<Object> getTipoProvisionEmpleadosObject() {		
		this.tipoprovisionempleadosObject=this.tipoprovisionempleadoDataAccess.getEntitiesObject();
		return this.tipoprovisionempleadosObject;
	}
		
	public void setTipoProvisionEmpleadosObject(List<Object> newTipoProvisionEmpleadosObject) {
		this.tipoprovisionempleadosObject = newTipoProvisionEmpleadosObject;
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
		
		if(this.tipoprovisionempleadoDataAccess!=null) {
			this.tipoprovisionempleadoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProvisionEmpleado.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			tipoprovisionempleadoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			tipoprovisionempleadoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		tipoprovisionempleado = new  TipoProvisionEmpleado();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProvisionEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoprovisionempleado=tipoprovisionempleadoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoprovisionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProvisionEmpleado(this.tipoprovisionempleado);
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
		tipoprovisionempleado = new  TipoProvisionEmpleado();
		  		  
        try {
			
			tipoprovisionempleado=tipoprovisionempleadoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoprovisionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProvisionEmpleado(this.tipoprovisionempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		tipoprovisionempleado = new  TipoProvisionEmpleado();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProvisionEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			tipoprovisionempleado=tipoprovisionempleadoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoprovisionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProvisionEmpleado(this.tipoprovisionempleado);
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
		tipoprovisionempleado = new  TipoProvisionEmpleado();
		  		  
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
		tipoprovisionempleado = new  TipoProvisionEmpleado();
		  		  
        try {
			
			tipoprovisionempleado=tipoprovisionempleadoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.tipoprovisionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				TipoProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProvisionEmpleado(this.tipoprovisionempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		tipoprovisionempleado = new  TipoProvisionEmpleado();
		  		  
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
		tipoprovisionempleado = new  TipoProvisionEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProvisionEmpleado.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =tipoprovisionempleadoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoprovisionempleado = new  TipoProvisionEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=tipoprovisionempleadoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoprovisionempleado = new  TipoProvisionEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProvisionEmpleado.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =tipoprovisionempleadoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoprovisionempleado = new  TipoProvisionEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=tipoprovisionempleadoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		tipoprovisionempleado = new  TipoProvisionEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProvisionEmpleado.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =tipoprovisionempleadoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		tipoprovisionempleado = new  TipoProvisionEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=tipoprovisionempleadoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoprovisionempleados = new  ArrayList<TipoProvisionEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProvisionEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			TipoProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprovisionempleados=tipoprovisionempleadoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoProvisionEmpleado(tipoprovisionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProvisionEmpleado(this.tipoprovisionempleados);
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
		tipoprovisionempleados = new  ArrayList<TipoProvisionEmpleado>();
		  		  
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
		tipoprovisionempleados = new  ArrayList<TipoProvisionEmpleado>();
		  		  
        try {			
			TipoProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprovisionempleados=tipoprovisionempleadoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarTipoProvisionEmpleado(tipoprovisionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProvisionEmpleado(this.tipoprovisionempleados);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		tipoprovisionempleados = new  ArrayList<TipoProvisionEmpleado>();
		  		  
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
		tipoprovisionempleados = new  ArrayList<TipoProvisionEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProvisionEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			TipoProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprovisionempleados=tipoprovisionempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoProvisionEmpleado(tipoprovisionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProvisionEmpleado(this.tipoprovisionempleados);
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
		tipoprovisionempleados = new  ArrayList<TipoProvisionEmpleado>();
		  		  
        try {
			TipoProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprovisionempleados=tipoprovisionempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoProvisionEmpleado(tipoprovisionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProvisionEmpleado(this.tipoprovisionempleados);
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
		tipoprovisionempleados = new  ArrayList<TipoProvisionEmpleado>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProvisionEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprovisionempleados=tipoprovisionempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoProvisionEmpleado(tipoprovisionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProvisionEmpleado(this.tipoprovisionempleados);
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
		tipoprovisionempleados = new  ArrayList<TipoProvisionEmpleado>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprovisionempleados=tipoprovisionempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoProvisionEmpleado(tipoprovisionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProvisionEmpleado(this.tipoprovisionempleados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		tipoprovisionempleado = new  TipoProvisionEmpleado();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProvisionEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprovisionempleado=tipoprovisionempleadoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoProvisionEmpleado(tipoprovisionempleado);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProvisionEmpleado(this.tipoprovisionempleado);
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
		tipoprovisionempleado = new  TipoProvisionEmpleado();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprovisionempleado=tipoprovisionempleadoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarTipoProvisionEmpleado(tipoprovisionempleado);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProvisionEmpleado(this.tipoprovisionempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		tipoprovisionempleados = new  ArrayList<TipoProvisionEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProvisionEmpleado.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			TipoProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprovisionempleados=tipoprovisionempleadoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoProvisionEmpleado(tipoprovisionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProvisionEmpleado(this.tipoprovisionempleados);
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
		tipoprovisionempleados = new  ArrayList<TipoProvisionEmpleado>();
		  		  
        try {
			TipoProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprovisionempleados=tipoprovisionempleadoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarTipoProvisionEmpleado(tipoprovisionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProvisionEmpleado(this.tipoprovisionempleados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosTipoProvisionEmpleadosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		tipoprovisionempleados = new  ArrayList<TipoProvisionEmpleado>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProvisionEmpleado.class.getSimpleName()+"-getTodosTipoProvisionEmpleadosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprovisionempleados=tipoprovisionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoProvisionEmpleado(tipoprovisionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProvisionEmpleado(this.tipoprovisionempleados);
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
	
	public  void  getTodosTipoProvisionEmpleados(String sFinalQuery,Pagination pagination)throws Exception {
		tipoprovisionempleados = new  ArrayList<TipoProvisionEmpleado>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			TipoProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			tipoprovisionempleados=tipoprovisionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarTipoProvisionEmpleado(tipoprovisionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				TipoProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProvisionEmpleado(this.tipoprovisionempleados);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarTipoProvisionEmpleado(TipoProvisionEmpleado tipoprovisionempleado) throws Exception {
		Boolean estaValidado=false;
		
		if(tipoprovisionempleado.getIsNew() || tipoprovisionempleado.getIsChanged()) { 
			this.invalidValues = tipoprovisionempleadoValidator.getInvalidValues(tipoprovisionempleado);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(tipoprovisionempleado);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarTipoProvisionEmpleado(List<TipoProvisionEmpleado> TipoProvisionEmpleados) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(TipoProvisionEmpleado tipoprovisionempleadoLocal:tipoprovisionempleados) {				
			estaValidadoObjeto=this.validarGuardarTipoProvisionEmpleado(tipoprovisionempleadoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarTipoProvisionEmpleado(List<TipoProvisionEmpleado> TipoProvisionEmpleados) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoProvisionEmpleado(tipoprovisionempleados)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarTipoProvisionEmpleado(TipoProvisionEmpleado TipoProvisionEmpleado) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarTipoProvisionEmpleado(tipoprovisionempleado)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(TipoProvisionEmpleado tipoprovisionempleado) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+tipoprovisionempleado.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=TipoProvisionEmpleadoConstantesFunciones.getTipoProvisionEmpleadoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"tipoprovisionempleado","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(TipoProvisionEmpleadoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(TipoProvisionEmpleadoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveTipoProvisionEmpleadoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProvisionEmpleado.class.getSimpleName()+"-saveTipoProvisionEmpleadoWithConnection");connexion.begin();			
			
			TipoProvisionEmpleadoLogicAdditional.checkTipoProvisionEmpleadoToSave(this.tipoprovisionempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoProvisionEmpleadoLogicAdditional.updateTipoProvisionEmpleadoToSave(this.tipoprovisionempleado,this.arrDatoGeneral);
			
			TipoProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoprovisionempleado,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowTipoProvisionEmpleado();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoProvisionEmpleado(this.tipoprovisionempleado)) {
				TipoProvisionEmpleadoDataAccess.save(this.tipoprovisionempleado, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.tipoprovisionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoProvisionEmpleadoLogicAdditional.checkTipoProvisionEmpleadoToSaveAfter(this.tipoprovisionempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoProvisionEmpleado();
			
			connexion.commit();			
			
			if(this.tipoprovisionempleado.getIsDeleted()) {
				this.tipoprovisionempleado=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveTipoProvisionEmpleado()throws Exception {	
		try {	
			
			TipoProvisionEmpleadoLogicAdditional.checkTipoProvisionEmpleadoToSave(this.tipoprovisionempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			TipoProvisionEmpleadoLogicAdditional.updateTipoProvisionEmpleadoToSave(this.tipoprovisionempleado,this.arrDatoGeneral);
			
			TipoProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.tipoprovisionempleado,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarTipoProvisionEmpleado(this.tipoprovisionempleado)) {			
				TipoProvisionEmpleadoDataAccess.save(this.tipoprovisionempleado, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.tipoprovisionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			TipoProvisionEmpleadoLogicAdditional.checkTipoProvisionEmpleadoToSaveAfter(this.tipoprovisionempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.tipoprovisionempleado.getIsDeleted()) {
				this.tipoprovisionempleado=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveTipoProvisionEmpleadosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProvisionEmpleado.class.getSimpleName()+"-saveTipoProvisionEmpleadosWithConnection");connexion.begin();			
			
			TipoProvisionEmpleadoLogicAdditional.checkTipoProvisionEmpleadoToSaves(tipoprovisionempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowTipoProvisionEmpleados();
			
			Boolean validadoTodosTipoProvisionEmpleado=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoProvisionEmpleado tipoprovisionempleadoLocal:tipoprovisionempleados) {		
				if(tipoprovisionempleadoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoProvisionEmpleadoLogicAdditional.updateTipoProvisionEmpleadoToSave(tipoprovisionempleadoLocal,this.arrDatoGeneral);
	        	
				TipoProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoprovisionempleadoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoProvisionEmpleado(tipoprovisionempleadoLocal)) {
					TipoProvisionEmpleadoDataAccess.save(tipoprovisionempleadoLocal, connexion);				
				} else {
					validadoTodosTipoProvisionEmpleado=false;
				}
			}
			
			if(!validadoTodosTipoProvisionEmpleado) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoProvisionEmpleadoLogicAdditional.checkTipoProvisionEmpleadoToSavesAfter(tipoprovisionempleados,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowTipoProvisionEmpleados();
			
			connexion.commit();		
			
			this.quitarTipoProvisionEmpleadosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveTipoProvisionEmpleados()throws Exception {				
		 try {	
			TipoProvisionEmpleadoLogicAdditional.checkTipoProvisionEmpleadoToSaves(tipoprovisionempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosTipoProvisionEmpleado=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(TipoProvisionEmpleado tipoprovisionempleadoLocal:tipoprovisionempleados) {				
				if(tipoprovisionempleadoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				TipoProvisionEmpleadoLogicAdditional.updateTipoProvisionEmpleadoToSave(tipoprovisionempleadoLocal,this.arrDatoGeneral);
	        	
				TipoProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),tipoprovisionempleadoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarTipoProvisionEmpleado(tipoprovisionempleadoLocal)) {				
					TipoProvisionEmpleadoDataAccess.save(tipoprovisionempleadoLocal, connexion);				
				} else {
					validadoTodosTipoProvisionEmpleado=false;
				}
			}
			
			if(!validadoTodosTipoProvisionEmpleado) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			TipoProvisionEmpleadoLogicAdditional.checkTipoProvisionEmpleadoToSavesAfter(tipoprovisionempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarTipoProvisionEmpleadosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoProvisionEmpleadoParameterReturnGeneral procesarAccionTipoProvisionEmpleados(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoProvisionEmpleado> tipoprovisionempleados,TipoProvisionEmpleadoParameterReturnGeneral tipoprovisionempleadoParameterGeneral)throws Exception {
		 try {	
			TipoProvisionEmpleadoParameterReturnGeneral tipoprovisionempleadoReturnGeneral=new TipoProvisionEmpleadoParameterReturnGeneral();
	
			TipoProvisionEmpleadoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoprovisionempleados,tipoprovisionempleadoParameterGeneral,tipoprovisionempleadoReturnGeneral);
			
			return tipoprovisionempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public TipoProvisionEmpleadoParameterReturnGeneral procesarAccionTipoProvisionEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<TipoProvisionEmpleado> tipoprovisionempleados,TipoProvisionEmpleadoParameterReturnGeneral tipoprovisionempleadoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProvisionEmpleado.class.getSimpleName()+"-procesarAccionTipoProvisionEmpleadosWithConnection");connexion.begin();			
			
			TipoProvisionEmpleadoParameterReturnGeneral tipoprovisionempleadoReturnGeneral=new TipoProvisionEmpleadoParameterReturnGeneral();
	
			TipoProvisionEmpleadoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,tipoprovisionempleados,tipoprovisionempleadoParameterGeneral,tipoprovisionempleadoReturnGeneral);
			
			this.connexion.commit();
			
			return tipoprovisionempleadoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoProvisionEmpleadoParameterReturnGeneral procesarEventosTipoProvisionEmpleados(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoProvisionEmpleado> tipoprovisionempleados,TipoProvisionEmpleado tipoprovisionempleado,TipoProvisionEmpleadoParameterReturnGeneral tipoprovisionempleadoParameterGeneral,Boolean isEsNuevoTipoProvisionEmpleado,ArrayList<Classe> clases)throws Exception {
		 try {	
			TipoProvisionEmpleadoParameterReturnGeneral tipoprovisionempleadoReturnGeneral=new TipoProvisionEmpleadoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoprovisionempleadoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoProvisionEmpleadoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoprovisionempleados,tipoprovisionempleado,tipoprovisionempleadoParameterGeneral,tipoprovisionempleadoReturnGeneral,isEsNuevoTipoProvisionEmpleado,clases);
			
			return tipoprovisionempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public TipoProvisionEmpleadoParameterReturnGeneral procesarEventosTipoProvisionEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<TipoProvisionEmpleado> tipoprovisionempleados,TipoProvisionEmpleado tipoprovisionempleado,TipoProvisionEmpleadoParameterReturnGeneral tipoprovisionempleadoParameterGeneral,Boolean isEsNuevoTipoProvisionEmpleado,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProvisionEmpleado.class.getSimpleName()+"-procesarEventosTipoProvisionEmpleadosWithConnection");connexion.begin();			
			
			TipoProvisionEmpleadoParameterReturnGeneral tipoprovisionempleadoReturnGeneral=new TipoProvisionEmpleadoParameterReturnGeneral();
	
			tipoprovisionempleadoReturnGeneral.setTipoProvisionEmpleado(tipoprovisionempleado);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				tipoprovisionempleadoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			TipoProvisionEmpleadoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,tipoprovisionempleados,tipoprovisionempleado,tipoprovisionempleadoParameterGeneral,tipoprovisionempleadoReturnGeneral,isEsNuevoTipoProvisionEmpleado,clases);
			
			this.connexion.commit();
			
			return tipoprovisionempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public TipoProvisionEmpleadoParameterReturnGeneral procesarImportacionTipoProvisionEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,TipoProvisionEmpleadoParameterReturnGeneral tipoprovisionempleadoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProvisionEmpleado.class.getSimpleName()+"-procesarImportacionTipoProvisionEmpleadosWithConnection");connexion.begin();			
			
			TipoProvisionEmpleadoParameterReturnGeneral tipoprovisionempleadoReturnGeneral=new TipoProvisionEmpleadoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.tipoprovisionempleados=new ArrayList<TipoProvisionEmpleado>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.tipoprovisionempleado=new TipoProvisionEmpleado();
				
				
				if(conColumnasBase) {this.tipoprovisionempleado.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.tipoprovisionempleado.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.tipoprovisionempleado.setcodigo(arrColumnas[iColumn++]);
				this.tipoprovisionempleado.setnombre(arrColumnas[iColumn++]);
				
				this.tipoprovisionempleados.add(this.tipoprovisionempleado);
			}
			
			this.saveTipoProvisionEmpleados();
			
			this.connexion.commit();
			
			tipoprovisionempleadoReturnGeneral.setConRetornoEstaProcesado(true);
			tipoprovisionempleadoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return tipoprovisionempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarTipoProvisionEmpleadosEliminados() throws Exception {				
		
		List<TipoProvisionEmpleado> tipoprovisionempleadosAux= new ArrayList<TipoProvisionEmpleado>();
		
		for(TipoProvisionEmpleado tipoprovisionempleado:tipoprovisionempleados) {
			if(!tipoprovisionempleado.getIsDeleted()) {
				tipoprovisionempleadosAux.add(tipoprovisionempleado);
			}
		}
		
		tipoprovisionempleados=tipoprovisionempleadosAux;
	}
	
	public void quitarTipoProvisionEmpleadosNulos() throws Exception {				
		
		List<TipoProvisionEmpleado> tipoprovisionempleadosAux= new ArrayList<TipoProvisionEmpleado>();
		
		for(TipoProvisionEmpleado tipoprovisionempleado : this.tipoprovisionempleados) {
			if(tipoprovisionempleado==null) {
				tipoprovisionempleadosAux.add(tipoprovisionempleado);
			}
		}
		
		//this.tipoprovisionempleados=tipoprovisionempleadosAux;
		
		this.tipoprovisionempleados.removeAll(tipoprovisionempleadosAux);
	}
	
	public void getSetVersionRowTipoProvisionEmpleadoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(tipoprovisionempleado.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((tipoprovisionempleado.getIsDeleted() || (tipoprovisionempleado.getIsChanged()&&!tipoprovisionempleado.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=tipoprovisionempleadoDataAccess.getSetVersionRowTipoProvisionEmpleado(connexion,tipoprovisionempleado.getId());
				
				if(!tipoprovisionempleado.getVersionRow().equals(timestamp)) {	
					tipoprovisionempleado.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				tipoprovisionempleado.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowTipoProvisionEmpleado()throws Exception {	
		
		if(tipoprovisionempleado.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((tipoprovisionempleado.getIsDeleted() || (tipoprovisionempleado.getIsChanged()&&!tipoprovisionempleado.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=tipoprovisionempleadoDataAccess.getSetVersionRowTipoProvisionEmpleado(connexion,tipoprovisionempleado.getId());
			
			try {							
				if(!tipoprovisionempleado.getVersionRow().equals(timestamp)) {	
					tipoprovisionempleado.setVersionRow(timestamp);
				}
				
				tipoprovisionempleado.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowTipoProvisionEmpleadosWithConnection()throws Exception {	
		if(tipoprovisionempleados!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(TipoProvisionEmpleado tipoprovisionempleadoAux:tipoprovisionempleados) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(tipoprovisionempleadoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoprovisionempleadoAux.getIsDeleted() || (tipoprovisionempleadoAux.getIsChanged()&&!tipoprovisionempleadoAux.getIsNew())) {
						
						timestamp=tipoprovisionempleadoDataAccess.getSetVersionRowTipoProvisionEmpleado(connexion,tipoprovisionempleadoAux.getId());
						
						if(!tipoprovisionempleado.getVersionRow().equals(timestamp)) {	
							tipoprovisionempleadoAux.setVersionRow(timestamp);
						}
								
						tipoprovisionempleadoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowTipoProvisionEmpleados()throws Exception {	
		if(tipoprovisionempleados!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(TipoProvisionEmpleado tipoprovisionempleadoAux:tipoprovisionempleados) {
					if(tipoprovisionempleadoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(tipoprovisionempleadoAux.getIsDeleted() || (tipoprovisionempleadoAux.getIsChanged()&&!tipoprovisionempleadoAux.getIsNew())) {
						
						timestamp=tipoprovisionempleadoDataAccess.getSetVersionRowTipoProvisionEmpleado(connexion,tipoprovisionempleadoAux.getId());
						
						if(!tipoprovisionempleadoAux.getVersionRow().equals(timestamp)) {	
							tipoprovisionempleadoAux.setVersionRow(timestamp);
						}
						
													
						tipoprovisionempleadoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyTipoProvisionEmpleadoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ProvisionEmpleadoLogic provisionempleadoLogic=new ProvisionEmpleadoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,TipoProvisionEmpleado.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyTipoProvisionEmpleadoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(ProvisionEmpleado.class));
											
			

			provisionempleadoLogic.setConnexion(this.getConnexion());
			provisionempleadoLogic.setDatosCliente(this.datosCliente);
			provisionempleadoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(TipoProvisionEmpleado tipoprovisionempleado:this.tipoprovisionempleados) {
				

				classes=new ArrayList<Classe>();
				classes=ProvisionEmpleadoConstantesFunciones.getClassesForeignKeysOfProvisionEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);

				provisionempleadoLogic.setProvisionEmpleados(tipoprovisionempleado.provisionempleados);
				provisionempleadoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(TipoProvisionEmpleado tipoprovisionempleado,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			TipoProvisionEmpleadoLogicAdditional.updateTipoProvisionEmpleadoToGet(tipoprovisionempleado,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		tipoprovisionempleado.setProvisionEmpleados(tipoprovisionempleadoDataAccess.getProvisionEmpleados(connexion,tipoprovisionempleado));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ProvisionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprovisionempleado.setProvisionEmpleados(tipoprovisionempleadoDataAccess.getProvisionEmpleados(connexion,tipoprovisionempleado));

				if(this.isConDeep) {
					ProvisionEmpleadoLogic provisionempleadoLogic= new ProvisionEmpleadoLogic(this.connexion);
					provisionempleadoLogic.setProvisionEmpleados(tipoprovisionempleado.getProvisionEmpleados());
					ArrayList<Classe> classesLocal=ProvisionEmpleadoConstantesFunciones.getClassesForeignKeysOfProvisionEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);
					provisionempleadoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesProvisionEmpleado(provisionempleadoLogic.getProvisionEmpleados());
					tipoprovisionempleado.setProvisionEmpleados(provisionempleadoLogic.getProvisionEmpleados());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProvisionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProvisionEmpleado.class));
			tipoprovisionempleado.setProvisionEmpleados(tipoprovisionempleadoDataAccess.getProvisionEmpleados(connexion,tipoprovisionempleado));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		tipoprovisionempleado.setProvisionEmpleados(tipoprovisionempleadoDataAccess.getProvisionEmpleados(connexion,tipoprovisionempleado));

		for(ProvisionEmpleado provisionempleado:tipoprovisionempleado.getProvisionEmpleados()) {
			ProvisionEmpleadoLogic provisionempleadoLogic= new ProvisionEmpleadoLogic(connexion);
			provisionempleadoLogic.deepLoad(provisionempleado,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(ProvisionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				tipoprovisionempleado.setProvisionEmpleados(tipoprovisionempleadoDataAccess.getProvisionEmpleados(connexion,tipoprovisionempleado));

				for(ProvisionEmpleado provisionempleado:tipoprovisionempleado.getProvisionEmpleados()) {
					ProvisionEmpleadoLogic provisionempleadoLogic= new ProvisionEmpleadoLogic(connexion);
					provisionempleadoLogic.deepLoad(provisionempleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ProvisionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ProvisionEmpleado.class));
			tipoprovisionempleado.setProvisionEmpleados(tipoprovisionempleadoDataAccess.getProvisionEmpleados(connexion,tipoprovisionempleado));

			for(ProvisionEmpleado provisionempleado:tipoprovisionempleado.getProvisionEmpleados()) {
				ProvisionEmpleadoLogic provisionempleadoLogic= new ProvisionEmpleadoLogic(connexion);
				provisionempleadoLogic.deepLoad(provisionempleado,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(TipoProvisionEmpleado tipoprovisionempleado,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			TipoProvisionEmpleadoLogicAdditional.updateTipoProvisionEmpleadoToSave(tipoprovisionempleado,this.arrDatoGeneral);
			
TipoProvisionEmpleadoDataAccess.save(tipoprovisionempleado, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(ProvisionEmpleado provisionempleado:tipoprovisionempleado.getProvisionEmpleados()) {
			provisionempleado.setid_tipo_provision_empleado(tipoprovisionempleado.getId());
			ProvisionEmpleadoDataAccess.save(provisionempleado,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(ProvisionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProvisionEmpleado provisionempleado:tipoprovisionempleado.getProvisionEmpleados()) {
					provisionempleado.setid_tipo_provision_empleado(tipoprovisionempleado.getId());
					ProvisionEmpleadoDataAccess.save(provisionempleado,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(ProvisionEmpleado provisionempleado:tipoprovisionempleado.getProvisionEmpleados()) {
			ProvisionEmpleadoLogic provisionempleadoLogic= new ProvisionEmpleadoLogic(connexion);
			provisionempleado.setid_tipo_provision_empleado(tipoprovisionempleado.getId());
			ProvisionEmpleadoDataAccess.save(provisionempleado,connexion);
			provisionempleadoLogic.deepSave(provisionempleado,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(ProvisionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProvisionEmpleado provisionempleado:tipoprovisionempleado.getProvisionEmpleados()) {
					ProvisionEmpleadoLogic provisionempleadoLogic= new ProvisionEmpleadoLogic(connexion);
					provisionempleado.setid_tipo_provision_empleado(tipoprovisionempleado.getId());
					ProvisionEmpleadoDataAccess.save(provisionempleado,connexion);
					provisionempleadoLogic.deepSave(provisionempleado,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(TipoProvisionEmpleado.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(tipoprovisionempleado,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProvisionEmpleado(tipoprovisionempleado);
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
			this.deepLoad(this.tipoprovisionempleado,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				TipoProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProvisionEmpleado(this.tipoprovisionempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(TipoProvisionEmpleado.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(tipoprovisionempleados!=null) {
				for(TipoProvisionEmpleado tipoprovisionempleado:tipoprovisionempleados) {
					this.deepLoad(tipoprovisionempleado,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					TipoProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProvisionEmpleado(tipoprovisionempleados);
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
			if(tipoprovisionempleados!=null) {
				for(TipoProvisionEmpleado tipoprovisionempleado:tipoprovisionempleados) {
					this.deepLoad(tipoprovisionempleado,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					TipoProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesTipoProvisionEmpleado(tipoprovisionempleados);
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
			this.getNewConnexionToDeep(TipoProvisionEmpleado.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(tipoprovisionempleado,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(TipoProvisionEmpleado.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(tipoprovisionempleados!=null) {
				for(TipoProvisionEmpleado tipoprovisionempleado:tipoprovisionempleados) {
					this.deepSave(tipoprovisionempleado,isDeep,deepLoadType,clases);
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
			if(tipoprovisionempleados!=null) {
				for(TipoProvisionEmpleado tipoprovisionempleado:tipoprovisionempleados) {
					this.deepSave(tipoprovisionempleado,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoProvisionEmpleadoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoProvisionEmpleadoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,TipoProvisionEmpleado tipoprovisionempleado,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(TipoProvisionEmpleadoConstantesFunciones.ISCONAUDITORIA) {
				if(tipoprovisionempleado.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoProvisionEmpleadoDataAccess.TABLENAME, tipoprovisionempleado.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoProvisionEmpleadoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoProvisionEmpleadoLogic.registrarAuditoriaDetallesTipoProvisionEmpleado(connexion,tipoprovisionempleado,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(tipoprovisionempleado.getIsDeleted()) {
					/*if(!tipoprovisionempleado.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,TipoProvisionEmpleadoDataAccess.TABLENAME, tipoprovisionempleado.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////TipoProvisionEmpleadoLogic.registrarAuditoriaDetallesTipoProvisionEmpleado(connexion,tipoprovisionempleado,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoProvisionEmpleadoDataAccess.TABLENAME, tipoprovisionempleado.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(tipoprovisionempleado.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,TipoProvisionEmpleadoDataAccess.TABLENAME, tipoprovisionempleado.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(TipoProvisionEmpleadoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////TipoProvisionEmpleadoLogic.registrarAuditoriaDetallesTipoProvisionEmpleado(connexion,tipoprovisionempleado,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesTipoProvisionEmpleado(Connexion connexion,TipoProvisionEmpleado tipoprovisionempleado)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(tipoprovisionempleado.getIsNew()||!tipoprovisionempleado.getcodigo().equals(tipoprovisionempleado.getTipoProvisionEmpleadoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoprovisionempleado.getTipoProvisionEmpleadoOriginal().getcodigo()!=null)
				{
					strValorActual=tipoprovisionempleado.getTipoProvisionEmpleadoOriginal().getcodigo();
				}
				if(tipoprovisionempleado.getcodigo()!=null)
				{
					strValorNuevo=tipoprovisionempleado.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoProvisionEmpleadoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(tipoprovisionempleado.getIsNew()||!tipoprovisionempleado.getnombre().equals(tipoprovisionempleado.getTipoProvisionEmpleadoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(tipoprovisionempleado.getTipoProvisionEmpleadoOriginal().getnombre()!=null)
				{
					strValorActual=tipoprovisionempleado.getTipoProvisionEmpleadoOriginal().getnombre();
				}
				if(tipoprovisionempleado.getnombre()!=null)
				{
					strValorNuevo=tipoprovisionempleado.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),TipoProvisionEmpleadoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveTipoProvisionEmpleadoRelacionesWithConnection(TipoProvisionEmpleado tipoprovisionempleado,List<ProvisionEmpleado> provisionempleados) throws Exception {

		if(!tipoprovisionempleado.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoProvisionEmpleadoRelacionesBase(tipoprovisionempleado,provisionempleados,true);
		}
	}

	public void saveTipoProvisionEmpleadoRelaciones(TipoProvisionEmpleado tipoprovisionempleado,List<ProvisionEmpleado> provisionempleados)throws Exception {

		if(!tipoprovisionempleado.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveTipoProvisionEmpleadoRelacionesBase(tipoprovisionempleado,provisionempleados,false);
		}
	}

	public void saveTipoProvisionEmpleadoRelacionesBase(TipoProvisionEmpleado tipoprovisionempleado,List<ProvisionEmpleado> provisionempleados,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("TipoProvisionEmpleado-saveRelacionesWithConnection");}
	
			tipoprovisionempleado.setProvisionEmpleados(provisionempleados);

			this.setTipoProvisionEmpleado(tipoprovisionempleado);

				if((tipoprovisionempleado.getIsNew()||tipoprovisionempleado.getIsChanged())&&!tipoprovisionempleado.getIsDeleted()) {
					this.saveTipoProvisionEmpleado();
					this.saveTipoProvisionEmpleadoRelacionesDetalles(provisionempleados);

				} else if(tipoprovisionempleado.getIsDeleted()) {
					this.saveTipoProvisionEmpleadoRelacionesDetalles(provisionempleados);
					this.saveTipoProvisionEmpleado();
				}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ProvisionEmpleadoConstantesFunciones.InicializarGeneralEntityAuxiliaresProvisionEmpleados(provisionempleados,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveTipoProvisionEmpleadoRelacionesDetalles(List<ProvisionEmpleado> provisionempleados)throws Exception {
		try {
	

			Long idTipoProvisionEmpleadoActual=this.getTipoProvisionEmpleado().getId();

			ProvisionEmpleadoLogic provisionempleadoLogic_Desde_TipoProvisionEmpleado=new ProvisionEmpleadoLogic();
			provisionempleadoLogic_Desde_TipoProvisionEmpleado.setProvisionEmpleados(provisionempleados);

			provisionempleadoLogic_Desde_TipoProvisionEmpleado.setConnexion(this.getConnexion());
			provisionempleadoLogic_Desde_TipoProvisionEmpleado.setDatosCliente(this.datosCliente);

			for(ProvisionEmpleado provisionempleado_Desde_TipoProvisionEmpleado:provisionempleadoLogic_Desde_TipoProvisionEmpleado.getProvisionEmpleados()) {
				provisionempleado_Desde_TipoProvisionEmpleado.setid_tipo_provision_empleado(idTipoProvisionEmpleadoActual);
			}

			provisionempleadoLogic_Desde_TipoProvisionEmpleado.saveProvisionEmpleados();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfTipoProvisionEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoProvisionEmpleadoConstantesFunciones.getClassesForeignKeysOfTipoProvisionEmpleado(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoProvisionEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=TipoProvisionEmpleadoConstantesFunciones.getClassesRelationshipsOfTipoProvisionEmpleado(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

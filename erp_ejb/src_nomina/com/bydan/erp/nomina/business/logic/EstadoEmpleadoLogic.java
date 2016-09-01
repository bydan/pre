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
import com.bydan.erp.nomina.util.EstadoEmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.EstadoEmpleadoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.EstadoEmpleadoParameterGeneral;
import com.bydan.erp.nomina.business.entity.EstadoEmpleado;
import com.bydan.erp.nomina.business.logic.EstadoEmpleadoLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.cartera.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;








@SuppressWarnings("unused")
public class EstadoEmpleadoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(EstadoEmpleadoLogic.class);
	
	protected EstadoEmpleadoDataAccess estadoempleadoDataAccess; 	
	protected EstadoEmpleado estadoempleado;
	protected List<EstadoEmpleado> estadoempleados;
	protected Object estadoempleadoObject;	
	protected List<Object> estadoempleadosObject;
	
	public static ClassValidator<EstadoEmpleado> estadoempleadoValidator = new ClassValidator<EstadoEmpleado>(EstadoEmpleado.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected EstadoEmpleadoLogicAdditional estadoempleadoLogicAdditional=null;
	
	public EstadoEmpleadoLogicAdditional getEstadoEmpleadoLogicAdditional() {
		return this.estadoempleadoLogicAdditional;
	}
	
	public void setEstadoEmpleadoLogicAdditional(EstadoEmpleadoLogicAdditional estadoempleadoLogicAdditional) {
		try {
			this.estadoempleadoLogicAdditional=estadoempleadoLogicAdditional;
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
	
	
	
	
	public  EstadoEmpleadoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.estadoempleadoDataAccess = new EstadoEmpleadoDataAccess();
			
			this.estadoempleados= new ArrayList<EstadoEmpleado>();
			this.estadoempleado= new EstadoEmpleado();
			
			this.estadoempleadoObject=new Object();
			this.estadoempleadosObject=new ArrayList<Object>();
				
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
			
			this.estadoempleadoDataAccess.setConnexionType(this.connexionType);
			this.estadoempleadoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  EstadoEmpleadoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.estadoempleadoDataAccess = new EstadoEmpleadoDataAccess();
			this.estadoempleados= new ArrayList<EstadoEmpleado>();
			this.estadoempleado= new EstadoEmpleado();
			this.estadoempleadoObject=new Object();
			this.estadoempleadosObject=new ArrayList<Object>();
			
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
			
			this.estadoempleadoDataAccess.setConnexionType(this.connexionType);
			this.estadoempleadoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public EstadoEmpleado getEstadoEmpleado() throws Exception {	
		EstadoEmpleadoLogicAdditional.checkEstadoEmpleadoToGet(estadoempleado,this.datosCliente,this.arrDatoGeneral);
		EstadoEmpleadoLogicAdditional.updateEstadoEmpleadoToGet(estadoempleado,this.arrDatoGeneral);
		
		return estadoempleado;
	}
		
	public void setEstadoEmpleado(EstadoEmpleado newEstadoEmpleado) {
		this.estadoempleado = newEstadoEmpleado;
	}
	
	public EstadoEmpleadoDataAccess getEstadoEmpleadoDataAccess() {
		return estadoempleadoDataAccess;
	}
	
	public void setEstadoEmpleadoDataAccess(EstadoEmpleadoDataAccess newestadoempleadoDataAccess) {
		this.estadoempleadoDataAccess = newestadoempleadoDataAccess;
	}
	
	public List<EstadoEmpleado> getEstadoEmpleados() throws Exception {		
		this.quitarEstadoEmpleadosNulos();
		
		EstadoEmpleadoLogicAdditional.checkEstadoEmpleadoToGets(estadoempleados,this.datosCliente,this.arrDatoGeneral);
		
		for (EstadoEmpleado estadoempleadoLocal: estadoempleados ) {
			EstadoEmpleadoLogicAdditional.updateEstadoEmpleadoToGet(estadoempleadoLocal,this.arrDatoGeneral);
		}
		
		return estadoempleados;
	}
	
	public void setEstadoEmpleados(List<EstadoEmpleado> newEstadoEmpleados) {
		this.estadoempleados = newEstadoEmpleados;
	}
	
	public Object getEstadoEmpleadoObject() {	
		this.estadoempleadoObject=this.estadoempleadoDataAccess.getEntityObject();
		return this.estadoempleadoObject;
	}
		
	public void setEstadoEmpleadoObject(Object newEstadoEmpleadoObject) {
		this.estadoempleadoObject = newEstadoEmpleadoObject;
	}
	
	public List<Object> getEstadoEmpleadosObject() {		
		this.estadoempleadosObject=this.estadoempleadoDataAccess.getEntitiesObject();
		return this.estadoempleadosObject;
	}
		
	public void setEstadoEmpleadosObject(List<Object> newEstadoEmpleadosObject) {
		this.estadoempleadosObject = newEstadoEmpleadosObject;
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
		
		if(this.estadoempleadoDataAccess!=null) {
			this.estadoempleadoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoEmpleado.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			estadoempleadoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			estadoempleadoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		estadoempleado = new  EstadoEmpleado();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadoempleado=estadoempleadoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoEmpleado(this.estadoempleado);
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
		estadoempleado = new  EstadoEmpleado();
		  		  
        try {
			
			estadoempleado=estadoempleadoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoEmpleado(this.estadoempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		estadoempleado = new  EstadoEmpleado();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			estadoempleado=estadoempleadoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoEmpleado(this.estadoempleado);
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
		estadoempleado = new  EstadoEmpleado();
		  		  
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
		estadoempleado = new  EstadoEmpleado();
		  		  
        try {
			
			estadoempleado=estadoempleadoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.estadoempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				EstadoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoEmpleado(this.estadoempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		estadoempleado = new  EstadoEmpleado();
		  		  
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
		estadoempleado = new  EstadoEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoEmpleado.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =estadoempleadoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadoempleado = new  EstadoEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=estadoempleadoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadoempleado = new  EstadoEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoEmpleado.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =estadoempleadoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadoempleado = new  EstadoEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=estadoempleadoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		estadoempleado = new  EstadoEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoEmpleado.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =estadoempleadoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		estadoempleado = new  EstadoEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=estadoempleadoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadoempleados = new  ArrayList<EstadoEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			EstadoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoempleados=estadoempleadoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoEmpleado(estadoempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoEmpleado(this.estadoempleados);
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
		estadoempleados = new  ArrayList<EstadoEmpleado>();
		  		  
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
		estadoempleados = new  ArrayList<EstadoEmpleado>();
		  		  
        try {			
			EstadoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoempleados=estadoempleadoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarEstadoEmpleado(estadoempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoEmpleado(this.estadoempleados);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		estadoempleados = new  ArrayList<EstadoEmpleado>();
		  		  
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
		estadoempleados = new  ArrayList<EstadoEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			EstadoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoempleados=estadoempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoEmpleado(estadoempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoEmpleado(this.estadoempleados);
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
		estadoempleados = new  ArrayList<EstadoEmpleado>();
		  		  
        try {
			EstadoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoempleados=estadoempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoEmpleado(estadoempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoEmpleado(this.estadoempleados);
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
		estadoempleados = new  ArrayList<EstadoEmpleado>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoempleados=estadoempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoEmpleado(estadoempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoEmpleado(this.estadoempleados);
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
		estadoempleados = new  ArrayList<EstadoEmpleado>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoempleados=estadoempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoEmpleado(estadoempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoEmpleado(this.estadoempleados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		estadoempleado = new  EstadoEmpleado();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoempleado=estadoempleadoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoEmpleado(estadoempleado);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoEmpleado(this.estadoempleado);
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
		estadoempleado = new  EstadoEmpleado();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoempleado=estadoempleadoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarEstadoEmpleado(estadoempleado);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoEmpleado(this.estadoempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		estadoempleados = new  ArrayList<EstadoEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoEmpleado.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			EstadoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoempleados=estadoempleadoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoEmpleado(estadoempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoEmpleado(this.estadoempleados);
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
		estadoempleados = new  ArrayList<EstadoEmpleado>();
		  		  
        try {
			EstadoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoempleados=estadoempleadoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarEstadoEmpleado(estadoempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoEmpleado(this.estadoempleados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosEstadoEmpleadosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		estadoempleados = new  ArrayList<EstadoEmpleado>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoEmpleado.class.getSimpleName()+"-getTodosEstadoEmpleadosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoempleados=estadoempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoEmpleado(estadoempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoEmpleado(this.estadoempleados);
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
	
	public  void  getTodosEstadoEmpleados(String sFinalQuery,Pagination pagination)throws Exception {
		estadoempleados = new  ArrayList<EstadoEmpleado>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			EstadoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			estadoempleados=estadoempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarEstadoEmpleado(estadoempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				EstadoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoEmpleado(this.estadoempleados);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarEstadoEmpleado(EstadoEmpleado estadoempleado) throws Exception {
		Boolean estaValidado=false;
		
		if(estadoempleado.getIsNew() || estadoempleado.getIsChanged()) { 
			this.invalidValues = estadoempleadoValidator.getInvalidValues(estadoempleado);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(estadoempleado);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarEstadoEmpleado(List<EstadoEmpleado> EstadoEmpleados) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(EstadoEmpleado estadoempleadoLocal:estadoempleados) {				
			estaValidadoObjeto=this.validarGuardarEstadoEmpleado(estadoempleadoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarEstadoEmpleado(List<EstadoEmpleado> EstadoEmpleados) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoEmpleado(estadoempleados)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarEstadoEmpleado(EstadoEmpleado EstadoEmpleado) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarEstadoEmpleado(estadoempleado)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(EstadoEmpleado estadoempleado) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+estadoempleado.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=EstadoEmpleadoConstantesFunciones.getEstadoEmpleadoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"estadoempleado","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(EstadoEmpleadoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(EstadoEmpleadoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveEstadoEmpleadoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoEmpleado.class.getSimpleName()+"-saveEstadoEmpleadoWithConnection");connexion.begin();			
			
			EstadoEmpleadoLogicAdditional.checkEstadoEmpleadoToSave(this.estadoempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoEmpleadoLogicAdditional.updateEstadoEmpleadoToSave(this.estadoempleado,this.arrDatoGeneral);
			
			EstadoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadoempleado,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowEstadoEmpleado();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoEmpleado(this.estadoempleado)) {
				EstadoEmpleadoDataAccess.save(this.estadoempleado, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.estadoempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoEmpleadoLogicAdditional.checkEstadoEmpleadoToSaveAfter(this.estadoempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoEmpleado();
			
			connexion.commit();			
			
			if(this.estadoempleado.getIsDeleted()) {
				this.estadoempleado=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveEstadoEmpleado()throws Exception {	
		try {	
			
			EstadoEmpleadoLogicAdditional.checkEstadoEmpleadoToSave(this.estadoempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			EstadoEmpleadoLogicAdditional.updateEstadoEmpleadoToSave(this.estadoempleado,this.arrDatoGeneral);
			
			EstadoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.estadoempleado,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarEstadoEmpleado(this.estadoempleado)) {			
				EstadoEmpleadoDataAccess.save(this.estadoempleado, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.estadoempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			EstadoEmpleadoLogicAdditional.checkEstadoEmpleadoToSaveAfter(this.estadoempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.estadoempleado.getIsDeleted()) {
				this.estadoempleado=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveEstadoEmpleadosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoEmpleado.class.getSimpleName()+"-saveEstadoEmpleadosWithConnection");connexion.begin();			
			
			EstadoEmpleadoLogicAdditional.checkEstadoEmpleadoToSaves(estadoempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowEstadoEmpleados();
			
			Boolean validadoTodosEstadoEmpleado=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoEmpleado estadoempleadoLocal:estadoempleados) {		
				if(estadoempleadoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoEmpleadoLogicAdditional.updateEstadoEmpleadoToSave(estadoempleadoLocal,this.arrDatoGeneral);
	        	
				EstadoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadoempleadoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoEmpleado(estadoempleadoLocal)) {
					EstadoEmpleadoDataAccess.save(estadoempleadoLocal, connexion);				
				} else {
					validadoTodosEstadoEmpleado=false;
				}
			}
			
			if(!validadoTodosEstadoEmpleado) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoEmpleadoLogicAdditional.checkEstadoEmpleadoToSavesAfter(estadoempleados,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowEstadoEmpleados();
			
			connexion.commit();		
			
			this.quitarEstadoEmpleadosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveEstadoEmpleados()throws Exception {				
		 try {	
			EstadoEmpleadoLogicAdditional.checkEstadoEmpleadoToSaves(estadoempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosEstadoEmpleado=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(EstadoEmpleado estadoempleadoLocal:estadoempleados) {				
				if(estadoempleadoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				EstadoEmpleadoLogicAdditional.updateEstadoEmpleadoToSave(estadoempleadoLocal,this.arrDatoGeneral);
	        	
				EstadoEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),estadoempleadoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarEstadoEmpleado(estadoempleadoLocal)) {				
					EstadoEmpleadoDataAccess.save(estadoempleadoLocal, connexion);				
				} else {
					validadoTodosEstadoEmpleado=false;
				}
			}
			
			if(!validadoTodosEstadoEmpleado) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			EstadoEmpleadoLogicAdditional.checkEstadoEmpleadoToSavesAfter(estadoempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarEstadoEmpleadosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoEmpleadoParameterReturnGeneral procesarAccionEstadoEmpleados(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoEmpleado> estadoempleados,EstadoEmpleadoParameterReturnGeneral estadoempleadoParameterGeneral)throws Exception {
		 try {	
			EstadoEmpleadoParameterReturnGeneral estadoempleadoReturnGeneral=new EstadoEmpleadoParameterReturnGeneral();
	
			EstadoEmpleadoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadoempleados,estadoempleadoParameterGeneral,estadoempleadoReturnGeneral);
			
			return estadoempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public EstadoEmpleadoParameterReturnGeneral procesarAccionEstadoEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<EstadoEmpleado> estadoempleados,EstadoEmpleadoParameterReturnGeneral estadoempleadoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoEmpleado.class.getSimpleName()+"-procesarAccionEstadoEmpleadosWithConnection");connexion.begin();			
			
			EstadoEmpleadoParameterReturnGeneral estadoempleadoReturnGeneral=new EstadoEmpleadoParameterReturnGeneral();
	
			EstadoEmpleadoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,estadoempleados,estadoempleadoParameterGeneral,estadoempleadoReturnGeneral);
			
			this.connexion.commit();
			
			return estadoempleadoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoEmpleadoParameterReturnGeneral procesarEventosEstadoEmpleados(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoEmpleado> estadoempleados,EstadoEmpleado estadoempleado,EstadoEmpleadoParameterReturnGeneral estadoempleadoParameterGeneral,Boolean isEsNuevoEstadoEmpleado,ArrayList<Classe> clases)throws Exception {
		 try {	
			EstadoEmpleadoParameterReturnGeneral estadoempleadoReturnGeneral=new EstadoEmpleadoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadoempleadoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoEmpleadoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadoempleados,estadoempleado,estadoempleadoParameterGeneral,estadoempleadoReturnGeneral,isEsNuevoEstadoEmpleado,clases);
			
			return estadoempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public EstadoEmpleadoParameterReturnGeneral procesarEventosEstadoEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<EstadoEmpleado> estadoempleados,EstadoEmpleado estadoempleado,EstadoEmpleadoParameterReturnGeneral estadoempleadoParameterGeneral,Boolean isEsNuevoEstadoEmpleado,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoEmpleado.class.getSimpleName()+"-procesarEventosEstadoEmpleadosWithConnection");connexion.begin();			
			
			EstadoEmpleadoParameterReturnGeneral estadoempleadoReturnGeneral=new EstadoEmpleadoParameterReturnGeneral();
	
			estadoempleadoReturnGeneral.setEstadoEmpleado(estadoempleado);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				estadoempleadoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			EstadoEmpleadoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,estadoempleados,estadoempleado,estadoempleadoParameterGeneral,estadoempleadoReturnGeneral,isEsNuevoEstadoEmpleado,clases);
			
			this.connexion.commit();
			
			return estadoempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public EstadoEmpleadoParameterReturnGeneral procesarImportacionEstadoEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,EstadoEmpleadoParameterReturnGeneral estadoempleadoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoEmpleado.class.getSimpleName()+"-procesarImportacionEstadoEmpleadosWithConnection");connexion.begin();			
			
			EstadoEmpleadoParameterReturnGeneral estadoempleadoReturnGeneral=new EstadoEmpleadoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.estadoempleados=new ArrayList<EstadoEmpleado>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.estadoempleado=new EstadoEmpleado();
				
				
				if(conColumnasBase) {this.estadoempleado.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.estadoempleado.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.estadoempleado.setcodigo(arrColumnas[iColumn++]);
				this.estadoempleado.setnombre(arrColumnas[iColumn++]);
				
				this.estadoempleados.add(this.estadoempleado);
			}
			
			this.saveEstadoEmpleados();
			
			this.connexion.commit();
			
			estadoempleadoReturnGeneral.setConRetornoEstaProcesado(true);
			estadoempleadoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return estadoempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarEstadoEmpleadosEliminados() throws Exception {				
		
		List<EstadoEmpleado> estadoempleadosAux= new ArrayList<EstadoEmpleado>();
		
		for(EstadoEmpleado estadoempleado:estadoempleados) {
			if(!estadoempleado.getIsDeleted()) {
				estadoempleadosAux.add(estadoempleado);
			}
		}
		
		estadoempleados=estadoempleadosAux;
	}
	
	public void quitarEstadoEmpleadosNulos() throws Exception {				
		
		List<EstadoEmpleado> estadoempleadosAux= new ArrayList<EstadoEmpleado>();
		
		for(EstadoEmpleado estadoempleado : this.estadoempleados) {
			if(estadoempleado==null) {
				estadoempleadosAux.add(estadoempleado);
			}
		}
		
		//this.estadoempleados=estadoempleadosAux;
		
		this.estadoempleados.removeAll(estadoempleadosAux);
	}
	
	public void getSetVersionRowEstadoEmpleadoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(estadoempleado.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((estadoempleado.getIsDeleted() || (estadoempleado.getIsChanged()&&!estadoempleado.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=estadoempleadoDataAccess.getSetVersionRowEstadoEmpleado(connexion,estadoempleado.getId());
				
				if(!estadoempleado.getVersionRow().equals(timestamp)) {	
					estadoempleado.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				estadoempleado.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowEstadoEmpleado()throws Exception {	
		
		if(estadoempleado.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((estadoempleado.getIsDeleted() || (estadoempleado.getIsChanged()&&!estadoempleado.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=estadoempleadoDataAccess.getSetVersionRowEstadoEmpleado(connexion,estadoempleado.getId());
			
			try {							
				if(!estadoempleado.getVersionRow().equals(timestamp)) {	
					estadoempleado.setVersionRow(timestamp);
				}
				
				estadoempleado.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowEstadoEmpleadosWithConnection()throws Exception {	
		if(estadoempleados!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(EstadoEmpleado estadoempleadoAux:estadoempleados) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(estadoempleadoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadoempleadoAux.getIsDeleted() || (estadoempleadoAux.getIsChanged()&&!estadoempleadoAux.getIsNew())) {
						
						timestamp=estadoempleadoDataAccess.getSetVersionRowEstadoEmpleado(connexion,estadoempleadoAux.getId());
						
						if(!estadoempleado.getVersionRow().equals(timestamp)) {	
							estadoempleadoAux.setVersionRow(timestamp);
						}
								
						estadoempleadoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowEstadoEmpleados()throws Exception {	
		if(estadoempleados!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(EstadoEmpleado estadoempleadoAux:estadoempleados) {
					if(estadoempleadoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(estadoempleadoAux.getIsDeleted() || (estadoempleadoAux.getIsChanged()&&!estadoempleadoAux.getIsNew())) {
						
						timestamp=estadoempleadoDataAccess.getSetVersionRowEstadoEmpleado(connexion,estadoempleadoAux.getId());
						
						if(!estadoempleadoAux.getVersionRow().equals(timestamp)) {	
							estadoempleadoAux.setVersionRow(timestamp);
						}
						
													
						estadoempleadoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	
	public void cargarRelacionesLoteForeignKeyEstadoEmpleadoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			CierreRolMensualLogic cierrerolmensualLogic=new CierreRolMensualLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoEmpleado.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyEstadoEmpleadoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(Empleado.class));
			classes.add(new Classe(CierreRolMensual.class));
											
			

			empleadoLogic.setConnexion(this.getConnexion());
			empleadoLogic.setDatosCliente(this.datosCliente);
			empleadoLogic.setIsConRefrescarForeignKeys(true);

			cierrerolmensualLogic.setConnexion(this.getConnexion());
			cierrerolmensualLogic.setDatosCliente(this.datosCliente);
			cierrerolmensualLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(EstadoEmpleado estadoempleado:this.estadoempleados) {
				

				classes=new ArrayList<Classe>();
				classes=EmpleadoConstantesFunciones.getClassesForeignKeysOfEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);

				empleadoLogic.setEmpleados(estadoempleado.empleados);
				empleadoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=CierreRolMensualConstantesFunciones.getClassesForeignKeysOfCierreRolMensual(new ArrayList<Classe>(),DeepLoadType.NONE);

				cierrerolmensualLogic.setCierreRolMensuals(estadoempleado.cierrerolmensuals);
				cierrerolmensualLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(EstadoEmpleado estadoempleado,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			EstadoEmpleadoLogicAdditional.updateEstadoEmpleadoToGet(estadoempleado,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		estadoempleado.setEmpleados(estadoempleadoDataAccess.getEmpleados(connexion,estadoempleado));
		estadoempleado.setCierreRolMensuals(estadoempleadoDataAccess.getCierreRolMensuals(connexion,estadoempleado));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadoempleado.setEmpleados(estadoempleadoDataAccess.getEmpleados(connexion,estadoempleado));

				if(this.isConDeep) {
					EmpleadoLogic empleadoLogic= new EmpleadoLogic(this.connexion);
					empleadoLogic.setEmpleados(estadoempleado.getEmpleados());
					ArrayList<Classe> classesLocal=EmpleadoConstantesFunciones.getClassesForeignKeysOfEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);
					empleadoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					EmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEmpleado(empleadoLogic.getEmpleados());
					estadoempleado.setEmpleados(empleadoLogic.getEmpleados());
				}

				continue;
			}

			if(clas.clas.equals(CierreRolMensual.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadoempleado.setCierreRolMensuals(estadoempleadoDataAccess.getCierreRolMensuals(connexion,estadoempleado));

				if(this.isConDeep) {
					CierreRolMensualLogic cierrerolmensualLogic= new CierreRolMensualLogic(this.connexion);
					cierrerolmensualLogic.setCierreRolMensuals(estadoempleado.getCierreRolMensuals());
					ArrayList<Classe> classesLocal=CierreRolMensualConstantesFunciones.getClassesForeignKeysOfCierreRolMensual(new ArrayList<Classe>(),DeepLoadType.NONE);
					cierrerolmensualLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CierreRolMensualConstantesFunciones.refrescarForeignKeysDescripcionesCierreRolMensual(cierrerolmensualLogic.getCierreRolMensuals());
					estadoempleado.setCierreRolMensuals(cierrerolmensualLogic.getCierreRolMensuals());
				}

				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Empleado.class));
			estadoempleado.setEmpleados(estadoempleadoDataAccess.getEmpleados(connexion,estadoempleado));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CierreRolMensual.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CierreRolMensual.class));
			estadoempleado.setCierreRolMensuals(estadoempleadoDataAccess.getCierreRolMensuals(connexion,estadoempleado));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {


		estadoempleado.setEmpleados(estadoempleadoDataAccess.getEmpleados(connexion,estadoempleado));

		for(Empleado empleado:estadoempleado.getEmpleados()) {
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(empleado,isDeep,deepLoadType,clases);
		}

		estadoempleado.setCierreRolMensuals(estadoempleadoDataAccess.getCierreRolMensuals(connexion,estadoempleado));

		for(CierreRolMensual cierrerolmensual:estadoempleado.getCierreRolMensuals()) {
			CierreRolMensualLogic cierrerolmensualLogic= new CierreRolMensualLogic(connexion);
			cierrerolmensualLogic.deepLoad(cierrerolmensual,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadoempleado.setEmpleados(estadoempleadoDataAccess.getEmpleados(connexion,estadoempleado));

				for(Empleado empleado:estadoempleado.getEmpleados()) {
					EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
					empleadoLogic.deepLoad(empleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CierreRolMensual.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				estadoempleado.setCierreRolMensuals(estadoempleadoDataAccess.getCierreRolMensuals(connexion,estadoempleado));

				for(CierreRolMensual cierrerolmensual:estadoempleado.getCierreRolMensuals()) {
					CierreRolMensualLogic cierrerolmensualLogic= new CierreRolMensualLogic(connexion);
					cierrerolmensualLogic.deepLoad(cierrerolmensual,isDeep,deepLoadType,clases);
				}
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Empleado.class));
			estadoempleado.setEmpleados(estadoempleadoDataAccess.getEmpleados(connexion,estadoempleado));

			for(Empleado empleado:estadoempleado.getEmpleados()) {
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(empleado,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CierreRolMensual.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(CierreRolMensual.class));
			estadoempleado.setCierreRolMensuals(estadoempleadoDataAccess.getCierreRolMensuals(connexion,estadoempleado));

			for(CierreRolMensual cierrerolmensual:estadoempleado.getCierreRolMensuals()) {
				CierreRolMensualLogic cierrerolmensualLogic= new CierreRolMensualLogic(connexion);
				cierrerolmensualLogic.deepLoad(cierrerolmensual,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(EstadoEmpleado estadoempleado,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			EstadoEmpleadoLogicAdditional.updateEstadoEmpleadoToSave(estadoempleado,this.arrDatoGeneral);
			
EstadoEmpleadoDataAccess.save(estadoempleado, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(Empleado empleado:estadoempleado.getEmpleados()) {
			empleado.setid_estado_empleado(estadoempleado.getId());
			EmpleadoDataAccess.save(empleado,connexion);
		}

		for(CierreRolMensual cierrerolmensual:estadoempleado.getCierreRolMensuals()) {
			cierrerolmensual.setid_estado_empleado(estadoempleado.getId());
			CierreRolMensualDataAccess.save(cierrerolmensual,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Empleado empleado:estadoempleado.getEmpleados()) {
					empleado.setid_estado_empleado(estadoempleado.getId());
					EmpleadoDataAccess.save(empleado,connexion);
				}
				continue;
			}

			if(clas.clas.equals(CierreRolMensual.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CierreRolMensual cierrerolmensual:estadoempleado.getCierreRolMensuals()) {
					cierrerolmensual.setid_estado_empleado(estadoempleado.getId());
					CierreRolMensualDataAccess.save(cierrerolmensual,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		for(Empleado empleado:estadoempleado.getEmpleados()) {
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleado.setid_estado_empleado(estadoempleado.getId());
			EmpleadoDataAccess.save(empleado,connexion);
			empleadoLogic.deepSave(empleado,isDeep,deepLoadType,clases);
		}

		for(CierreRolMensual cierrerolmensual:estadoempleado.getCierreRolMensuals()) {
			CierreRolMensualLogic cierrerolmensualLogic= new CierreRolMensualLogic(connexion);
			cierrerolmensual.setid_estado_empleado(estadoempleado.getId());
			CierreRolMensualDataAccess.save(cierrerolmensual,connexion);
			cierrerolmensualLogic.deepSave(cierrerolmensual,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {

			if(clas.clas.equals(Empleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Empleado empleado:estadoempleado.getEmpleados()) {
					EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
					empleado.setid_estado_empleado(estadoempleado.getId());
					EmpleadoDataAccess.save(empleado,connexion);
					empleadoLogic.deepSave(empleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(CierreRolMensual.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(CierreRolMensual cierrerolmensual:estadoempleado.getCierreRolMensuals()) {
					CierreRolMensualLogic cierrerolmensualLogic= new CierreRolMensualLogic(connexion);
					cierrerolmensual.setid_estado_empleado(estadoempleado.getId());
					CierreRolMensualDataAccess.save(cierrerolmensual,connexion);
					cierrerolmensualLogic.deepSave(cierrerolmensual,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(EstadoEmpleado.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(estadoempleado,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoEmpleado(estadoempleado);
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
			this.deepLoad(this.estadoempleado,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				EstadoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoEmpleado(this.estadoempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(EstadoEmpleado.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(estadoempleados!=null) {
				for(EstadoEmpleado estadoempleado:estadoempleados) {
					this.deepLoad(estadoempleado,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					EstadoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoEmpleado(estadoempleados);
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
			if(estadoempleados!=null) {
				for(EstadoEmpleado estadoempleado:estadoempleados) {
					this.deepLoad(estadoempleado,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					EstadoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoEmpleado(estadoempleados);
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
			this.getNewConnexionToDeep(EstadoEmpleado.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(estadoempleado,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(EstadoEmpleado.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(estadoempleados!=null) {
				for(EstadoEmpleado estadoempleado:estadoempleados) {
					this.deepSave(estadoempleado,isDeep,deepLoadType,clases);
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
			if(estadoempleados!=null) {
				for(EstadoEmpleado estadoempleado:estadoempleados) {
					this.deepSave(estadoempleado,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getEstadoEmpleadoPorCodigoWithConnection(String codigo)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,EstadoEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,EstadoEmpleadoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			estadoempleado=estadoempleadoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.estadoempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				EstadoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoEmpleado(this.estadoempleado);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getEstadoEmpleadoPorCodigo(String codigo)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralEqual(ParameterType.STRING,codigo,EstadoEmpleadoConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			estadoempleado=estadoempleadoDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.estadoempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				EstadoEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesEstadoEmpleado(this.estadoempleado);
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
			if(EstadoEmpleadoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoEmpleadoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,EstadoEmpleado estadoempleado,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(EstadoEmpleadoConstantesFunciones.ISCONAUDITORIA) {
				if(estadoempleado.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoEmpleadoDataAccess.TABLENAME, estadoempleado.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoEmpleadoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoEmpleadoLogic.registrarAuditoriaDetallesEstadoEmpleado(connexion,estadoempleado,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(estadoempleado.getIsDeleted()) {
					/*if(!estadoempleado.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,EstadoEmpleadoDataAccess.TABLENAME, estadoempleado.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////EstadoEmpleadoLogic.registrarAuditoriaDetallesEstadoEmpleado(connexion,estadoempleado,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoEmpleadoDataAccess.TABLENAME, estadoempleado.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(estadoempleado.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,EstadoEmpleadoDataAccess.TABLENAME, estadoempleado.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(EstadoEmpleadoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////EstadoEmpleadoLogic.registrarAuditoriaDetallesEstadoEmpleado(connexion,estadoempleado,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesEstadoEmpleado(Connexion connexion,EstadoEmpleado estadoempleado)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(estadoempleado.getIsNew()||!estadoempleado.getcodigo().equals(estadoempleado.getEstadoEmpleadoOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadoempleado.getEstadoEmpleadoOriginal().getcodigo()!=null)
				{
					strValorActual=estadoempleado.getEstadoEmpleadoOriginal().getcodigo();
				}
				if(estadoempleado.getcodigo()!=null)
				{
					strValorNuevo=estadoempleado.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoEmpleadoConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(estadoempleado.getIsNew()||!estadoempleado.getnombre().equals(estadoempleado.getEstadoEmpleadoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(estadoempleado.getEstadoEmpleadoOriginal().getnombre()!=null)
				{
					strValorActual=estadoempleado.getEstadoEmpleadoOriginal().getnombre();
				}
				if(estadoempleado.getnombre()!=null)
				{
					strValorNuevo=estadoempleado.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),EstadoEmpleadoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveEstadoEmpleadoRelacionesWithConnection(EstadoEmpleado estadoempleado,List<Empleado> empleados,List<CierreRolMensual> cierrerolmensuals) throws Exception {

		if(!estadoempleado.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoEmpleadoRelacionesBase(estadoempleado,empleados,cierrerolmensuals,true);
		}
	}

	public void saveEstadoEmpleadoRelaciones(EstadoEmpleado estadoempleado,List<Empleado> empleados,List<CierreRolMensual> cierrerolmensuals)throws Exception {

		if(!estadoempleado.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveEstadoEmpleadoRelacionesBase(estadoempleado,empleados,cierrerolmensuals,false);
		}
	}

	public void saveEstadoEmpleadoRelacionesBase(EstadoEmpleado estadoempleado,List<Empleado> empleados,List<CierreRolMensual> cierrerolmensuals,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("EstadoEmpleado-saveRelacionesWithConnection");}
	
			estadoempleado.setEmpleados(empleados);
			estadoempleado.setCierreRolMensuals(cierrerolmensuals);

			this.setEstadoEmpleado(estadoempleado);

			if(EstadoEmpleadoLogicAdditional.validarSaveRelaciones(estadoempleado,this)) {

				EstadoEmpleadoLogicAdditional.updateRelacionesToSave(estadoempleado,this);

				if((estadoempleado.getIsNew()||estadoempleado.getIsChanged())&&!estadoempleado.getIsDeleted()) {
					this.saveEstadoEmpleado();
					this.saveEstadoEmpleadoRelacionesDetalles(empleados,cierrerolmensuals);

				} else if(estadoempleado.getIsDeleted()) {
					this.saveEstadoEmpleadoRelacionesDetalles(empleados,cierrerolmensuals);
					this.saveEstadoEmpleado();
				}

				EstadoEmpleadoLogicAdditional.updateRelacionesToSaveAfter(estadoempleado,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			EmpleadoConstantesFunciones.InicializarGeneralEntityAuxiliaresEmpleados(empleados,true,true);
			CierreRolMensualConstantesFunciones.InicializarGeneralEntityAuxiliaresCierreRolMensuals(cierrerolmensuals,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveEstadoEmpleadoRelacionesDetalles(List<Empleado> empleados,List<CierreRolMensual> cierrerolmensuals)throws Exception {
		try {
	

			Long idEstadoEmpleadoActual=this.getEstadoEmpleado().getId();

			EmpleadoLogic empleadoLogic_Desde_EstadoEmpleado=new EmpleadoLogic();
			empleadoLogic_Desde_EstadoEmpleado.setEmpleados(empleados);

			empleadoLogic_Desde_EstadoEmpleado.setConnexion(this.getConnexion());
			empleadoLogic_Desde_EstadoEmpleado.setDatosCliente(this.datosCliente);

			for(Empleado empleado_Desde_EstadoEmpleado:empleadoLogic_Desde_EstadoEmpleado.getEmpleados()) {
				empleado_Desde_EstadoEmpleado.setid_estado_empleado(idEstadoEmpleadoActual);

				empleadoLogic_Desde_EstadoEmpleado.setEmpleado(empleado_Desde_EstadoEmpleado);
				empleadoLogic_Desde_EstadoEmpleado.saveEmpleado();
			}


			CierreRolMensualLogic cierrerolmensualLogic_Desde_EstadoEmpleado=new CierreRolMensualLogic();
			cierrerolmensualLogic_Desde_EstadoEmpleado.setCierreRolMensuals(cierrerolmensuals);

			cierrerolmensualLogic_Desde_EstadoEmpleado.setConnexion(this.getConnexion());
			cierrerolmensualLogic_Desde_EstadoEmpleado.setDatosCliente(this.datosCliente);

			for(CierreRolMensual cierrerolmensual_Desde_EstadoEmpleado:cierrerolmensualLogic_Desde_EstadoEmpleado.getCierreRolMensuals()) {
				cierrerolmensual_Desde_EstadoEmpleado.setid_estado_empleado(idEstadoEmpleadoActual);
			}

			cierrerolmensualLogic_Desde_EstadoEmpleado.saveCierreRolMensuals();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfEstadoEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoEmpleadoConstantesFunciones.getClassesForeignKeysOfEstadoEmpleado(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfEstadoEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=EstadoEmpleadoConstantesFunciones.getClassesRelationshipsOfEstadoEmpleado(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

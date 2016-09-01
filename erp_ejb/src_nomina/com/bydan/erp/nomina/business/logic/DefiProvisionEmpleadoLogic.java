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
import com.bydan.erp.nomina.util.DefiProvisionEmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.DefiProvisionEmpleadoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.DefiProvisionEmpleadoParameterGeneral;
import com.bydan.erp.nomina.business.entity.DefiProvisionEmpleado;
import com.bydan.erp.nomina.business.logic.DefiProvisionEmpleadoLogicAdditional;
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
public class DefiProvisionEmpleadoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DefiProvisionEmpleadoLogic.class);
	
	protected DefiProvisionEmpleadoDataAccess defiprovisionempleadoDataAccess; 	
	protected DefiProvisionEmpleado defiprovisionempleado;
	protected List<DefiProvisionEmpleado> defiprovisionempleados;
	protected Object defiprovisionempleadoObject;	
	protected List<Object> defiprovisionempleadosObject;
	
	public static ClassValidator<DefiProvisionEmpleado> defiprovisionempleadoValidator = new ClassValidator<DefiProvisionEmpleado>(DefiProvisionEmpleado.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DefiProvisionEmpleadoLogicAdditional defiprovisionempleadoLogicAdditional=null;
	
	public DefiProvisionEmpleadoLogicAdditional getDefiProvisionEmpleadoLogicAdditional() {
		return this.defiprovisionempleadoLogicAdditional;
	}
	
	public void setDefiProvisionEmpleadoLogicAdditional(DefiProvisionEmpleadoLogicAdditional defiprovisionempleadoLogicAdditional) {
		try {
			this.defiprovisionempleadoLogicAdditional=defiprovisionempleadoLogicAdditional;
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
	
	
	
	
	public  DefiProvisionEmpleadoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.defiprovisionempleadoDataAccess = new DefiProvisionEmpleadoDataAccess();
			
			this.defiprovisionempleados= new ArrayList<DefiProvisionEmpleado>();
			this.defiprovisionempleado= new DefiProvisionEmpleado();
			
			this.defiprovisionempleadoObject=new Object();
			this.defiprovisionempleadosObject=new ArrayList<Object>();
				
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
			
			this.defiprovisionempleadoDataAccess.setConnexionType(this.connexionType);
			this.defiprovisionempleadoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DefiProvisionEmpleadoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.defiprovisionempleadoDataAccess = new DefiProvisionEmpleadoDataAccess();
			this.defiprovisionempleados= new ArrayList<DefiProvisionEmpleado>();
			this.defiprovisionempleado= new DefiProvisionEmpleado();
			this.defiprovisionempleadoObject=new Object();
			this.defiprovisionempleadosObject=new ArrayList<Object>();
			
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
			
			this.defiprovisionempleadoDataAccess.setConnexionType(this.connexionType);
			this.defiprovisionempleadoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DefiProvisionEmpleado getDefiProvisionEmpleado() throws Exception {	
		DefiProvisionEmpleadoLogicAdditional.checkDefiProvisionEmpleadoToGet(defiprovisionempleado,this.datosCliente,this.arrDatoGeneral);
		DefiProvisionEmpleadoLogicAdditional.updateDefiProvisionEmpleadoToGet(defiprovisionempleado,this.arrDatoGeneral);
		
		return defiprovisionempleado;
	}
		
	public void setDefiProvisionEmpleado(DefiProvisionEmpleado newDefiProvisionEmpleado) {
		this.defiprovisionempleado = newDefiProvisionEmpleado;
	}
	
	public DefiProvisionEmpleadoDataAccess getDefiProvisionEmpleadoDataAccess() {
		return defiprovisionempleadoDataAccess;
	}
	
	public void setDefiProvisionEmpleadoDataAccess(DefiProvisionEmpleadoDataAccess newdefiprovisionempleadoDataAccess) {
		this.defiprovisionempleadoDataAccess = newdefiprovisionempleadoDataAccess;
	}
	
	public List<DefiProvisionEmpleado> getDefiProvisionEmpleados() throws Exception {		
		this.quitarDefiProvisionEmpleadosNulos();
		
		DefiProvisionEmpleadoLogicAdditional.checkDefiProvisionEmpleadoToGets(defiprovisionempleados,this.datosCliente,this.arrDatoGeneral);
		
		for (DefiProvisionEmpleado defiprovisionempleadoLocal: defiprovisionempleados ) {
			DefiProvisionEmpleadoLogicAdditional.updateDefiProvisionEmpleadoToGet(defiprovisionempleadoLocal,this.arrDatoGeneral);
		}
		
		return defiprovisionempleados;
	}
	
	public void setDefiProvisionEmpleados(List<DefiProvisionEmpleado> newDefiProvisionEmpleados) {
		this.defiprovisionempleados = newDefiProvisionEmpleados;
	}
	
	public Object getDefiProvisionEmpleadoObject() {	
		this.defiprovisionempleadoObject=this.defiprovisionempleadoDataAccess.getEntityObject();
		return this.defiprovisionempleadoObject;
	}
		
	public void setDefiProvisionEmpleadoObject(Object newDefiProvisionEmpleadoObject) {
		this.defiprovisionempleadoObject = newDefiProvisionEmpleadoObject;
	}
	
	public List<Object> getDefiProvisionEmpleadosObject() {		
		this.defiprovisionempleadosObject=this.defiprovisionempleadoDataAccess.getEntitiesObject();
		return this.defiprovisionempleadosObject;
	}
		
	public void setDefiProvisionEmpleadosObject(List<Object> newDefiProvisionEmpleadosObject) {
		this.defiprovisionempleadosObject = newDefiProvisionEmpleadosObject;
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
		
		if(this.defiprovisionempleadoDataAccess!=null) {
			this.defiprovisionempleadoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DefiProvisionEmpleado.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			defiprovisionempleadoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			defiprovisionempleadoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		defiprovisionempleado = new  DefiProvisionEmpleado();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DefiProvisionEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			defiprovisionempleado=defiprovisionempleadoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.defiprovisionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DefiProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDefiProvisionEmpleado(this.defiprovisionempleado);
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
		defiprovisionempleado = new  DefiProvisionEmpleado();
		  		  
        try {
			
			defiprovisionempleado=defiprovisionempleadoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.defiprovisionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DefiProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDefiProvisionEmpleado(this.defiprovisionempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		defiprovisionempleado = new  DefiProvisionEmpleado();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DefiProvisionEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			defiprovisionempleado=defiprovisionempleadoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.defiprovisionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DefiProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDefiProvisionEmpleado(this.defiprovisionempleado);
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
		defiprovisionempleado = new  DefiProvisionEmpleado();
		  		  
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
		defiprovisionempleado = new  DefiProvisionEmpleado();
		  		  
        try {
			
			defiprovisionempleado=defiprovisionempleadoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.defiprovisionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DefiProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDefiProvisionEmpleado(this.defiprovisionempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		defiprovisionempleado = new  DefiProvisionEmpleado();
		  		  
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
		defiprovisionempleado = new  DefiProvisionEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DefiProvisionEmpleado.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =defiprovisionempleadoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		defiprovisionempleado = new  DefiProvisionEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=defiprovisionempleadoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		defiprovisionempleado = new  DefiProvisionEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DefiProvisionEmpleado.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =defiprovisionempleadoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		defiprovisionempleado = new  DefiProvisionEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=defiprovisionempleadoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		defiprovisionempleado = new  DefiProvisionEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DefiProvisionEmpleado.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =defiprovisionempleadoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		defiprovisionempleado = new  DefiProvisionEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=defiprovisionempleadoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		defiprovisionempleados = new  ArrayList<DefiProvisionEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DefiProvisionEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DefiProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			defiprovisionempleados=defiprovisionempleadoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDefiProvisionEmpleado(defiprovisionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DefiProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDefiProvisionEmpleado(this.defiprovisionempleados);
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
		defiprovisionempleados = new  ArrayList<DefiProvisionEmpleado>();
		  		  
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
		defiprovisionempleados = new  ArrayList<DefiProvisionEmpleado>();
		  		  
        try {			
			DefiProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			defiprovisionempleados=defiprovisionempleadoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDefiProvisionEmpleado(defiprovisionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DefiProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDefiProvisionEmpleado(this.defiprovisionempleados);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		defiprovisionempleados = new  ArrayList<DefiProvisionEmpleado>();
		  		  
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
		defiprovisionempleados = new  ArrayList<DefiProvisionEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DefiProvisionEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DefiProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			defiprovisionempleados=defiprovisionempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDefiProvisionEmpleado(defiprovisionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DefiProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDefiProvisionEmpleado(this.defiprovisionempleados);
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
		defiprovisionempleados = new  ArrayList<DefiProvisionEmpleado>();
		  		  
        try {
			DefiProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			defiprovisionempleados=defiprovisionempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDefiProvisionEmpleado(defiprovisionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DefiProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDefiProvisionEmpleado(this.defiprovisionempleados);
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
		defiprovisionempleados = new  ArrayList<DefiProvisionEmpleado>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DefiProvisionEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DefiProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			defiprovisionempleados=defiprovisionempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDefiProvisionEmpleado(defiprovisionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DefiProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDefiProvisionEmpleado(this.defiprovisionempleados);
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
		defiprovisionempleados = new  ArrayList<DefiProvisionEmpleado>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DefiProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			defiprovisionempleados=defiprovisionempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDefiProvisionEmpleado(defiprovisionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DefiProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDefiProvisionEmpleado(this.defiprovisionempleados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		defiprovisionempleado = new  DefiProvisionEmpleado();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DefiProvisionEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DefiProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			defiprovisionempleado=defiprovisionempleadoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDefiProvisionEmpleado(defiprovisionempleado);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DefiProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDefiProvisionEmpleado(this.defiprovisionempleado);
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
		defiprovisionempleado = new  DefiProvisionEmpleado();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DefiProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			defiprovisionempleado=defiprovisionempleadoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDefiProvisionEmpleado(defiprovisionempleado);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DefiProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDefiProvisionEmpleado(this.defiprovisionempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		defiprovisionempleados = new  ArrayList<DefiProvisionEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DefiProvisionEmpleado.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DefiProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			defiprovisionempleados=defiprovisionempleadoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDefiProvisionEmpleado(defiprovisionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DefiProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDefiProvisionEmpleado(this.defiprovisionempleados);
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
		defiprovisionempleados = new  ArrayList<DefiProvisionEmpleado>();
		  		  
        try {
			DefiProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			defiprovisionempleados=defiprovisionempleadoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDefiProvisionEmpleado(defiprovisionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DefiProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDefiProvisionEmpleado(this.defiprovisionempleados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDefiProvisionEmpleadosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		defiprovisionempleados = new  ArrayList<DefiProvisionEmpleado>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DefiProvisionEmpleado.class.getSimpleName()+"-getTodosDefiProvisionEmpleadosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DefiProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			defiprovisionempleados=defiprovisionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDefiProvisionEmpleado(defiprovisionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DefiProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDefiProvisionEmpleado(this.defiprovisionempleados);
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
	
	public  void  getTodosDefiProvisionEmpleados(String sFinalQuery,Pagination pagination)throws Exception {
		defiprovisionempleados = new  ArrayList<DefiProvisionEmpleado>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DefiProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			defiprovisionempleados=defiprovisionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDefiProvisionEmpleado(defiprovisionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DefiProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDefiProvisionEmpleado(this.defiprovisionempleados);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDefiProvisionEmpleado(DefiProvisionEmpleado defiprovisionempleado) throws Exception {
		Boolean estaValidado=false;
		
		if(defiprovisionempleado.getIsNew() || defiprovisionempleado.getIsChanged()) { 
			this.invalidValues = defiprovisionempleadoValidator.getInvalidValues(defiprovisionempleado);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(defiprovisionempleado);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDefiProvisionEmpleado(List<DefiProvisionEmpleado> DefiProvisionEmpleados) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DefiProvisionEmpleado defiprovisionempleadoLocal:defiprovisionempleados) {				
			estaValidadoObjeto=this.validarGuardarDefiProvisionEmpleado(defiprovisionempleadoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDefiProvisionEmpleado(List<DefiProvisionEmpleado> DefiProvisionEmpleados) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDefiProvisionEmpleado(defiprovisionempleados)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDefiProvisionEmpleado(DefiProvisionEmpleado DefiProvisionEmpleado) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDefiProvisionEmpleado(defiprovisionempleado)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DefiProvisionEmpleado defiprovisionempleado) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+defiprovisionempleado.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DefiProvisionEmpleadoConstantesFunciones.getDefiProvisionEmpleadoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"defiprovisionempleado","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DefiProvisionEmpleadoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DefiProvisionEmpleadoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDefiProvisionEmpleadoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DefiProvisionEmpleado.class.getSimpleName()+"-saveDefiProvisionEmpleadoWithConnection");connexion.begin();			
			
			DefiProvisionEmpleadoLogicAdditional.checkDefiProvisionEmpleadoToSave(this.defiprovisionempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DefiProvisionEmpleadoLogicAdditional.updateDefiProvisionEmpleadoToSave(this.defiprovisionempleado,this.arrDatoGeneral);
			
			DefiProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.defiprovisionempleado,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDefiProvisionEmpleado();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDefiProvisionEmpleado(this.defiprovisionempleado)) {
				DefiProvisionEmpleadoDataAccess.save(this.defiprovisionempleado, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.defiprovisionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DefiProvisionEmpleadoLogicAdditional.checkDefiProvisionEmpleadoToSaveAfter(this.defiprovisionempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDefiProvisionEmpleado();
			
			connexion.commit();			
			
			if(this.defiprovisionempleado.getIsDeleted()) {
				this.defiprovisionempleado=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDefiProvisionEmpleado()throws Exception {	
		try {	
			
			DefiProvisionEmpleadoLogicAdditional.checkDefiProvisionEmpleadoToSave(this.defiprovisionempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DefiProvisionEmpleadoLogicAdditional.updateDefiProvisionEmpleadoToSave(this.defiprovisionempleado,this.arrDatoGeneral);
			
			DefiProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.defiprovisionempleado,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDefiProvisionEmpleado(this.defiprovisionempleado)) {			
				DefiProvisionEmpleadoDataAccess.save(this.defiprovisionempleado, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.defiprovisionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DefiProvisionEmpleadoLogicAdditional.checkDefiProvisionEmpleadoToSaveAfter(this.defiprovisionempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.defiprovisionempleado.getIsDeleted()) {
				this.defiprovisionempleado=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDefiProvisionEmpleadosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DefiProvisionEmpleado.class.getSimpleName()+"-saveDefiProvisionEmpleadosWithConnection");connexion.begin();			
			
			DefiProvisionEmpleadoLogicAdditional.checkDefiProvisionEmpleadoToSaves(defiprovisionempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDefiProvisionEmpleados();
			
			Boolean validadoTodosDefiProvisionEmpleado=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DefiProvisionEmpleado defiprovisionempleadoLocal:defiprovisionempleados) {		
				if(defiprovisionempleadoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DefiProvisionEmpleadoLogicAdditional.updateDefiProvisionEmpleadoToSave(defiprovisionempleadoLocal,this.arrDatoGeneral);
	        	
				DefiProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),defiprovisionempleadoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDefiProvisionEmpleado(defiprovisionempleadoLocal)) {
					DefiProvisionEmpleadoDataAccess.save(defiprovisionempleadoLocal, connexion);				
				} else {
					validadoTodosDefiProvisionEmpleado=false;
				}
			}
			
			if(!validadoTodosDefiProvisionEmpleado) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DefiProvisionEmpleadoLogicAdditional.checkDefiProvisionEmpleadoToSavesAfter(defiprovisionempleados,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDefiProvisionEmpleados();
			
			connexion.commit();		
			
			this.quitarDefiProvisionEmpleadosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDefiProvisionEmpleados()throws Exception {				
		 try {	
			DefiProvisionEmpleadoLogicAdditional.checkDefiProvisionEmpleadoToSaves(defiprovisionempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDefiProvisionEmpleado=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DefiProvisionEmpleado defiprovisionempleadoLocal:defiprovisionempleados) {				
				if(defiprovisionempleadoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DefiProvisionEmpleadoLogicAdditional.updateDefiProvisionEmpleadoToSave(defiprovisionempleadoLocal,this.arrDatoGeneral);
	        	
				DefiProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),defiprovisionempleadoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDefiProvisionEmpleado(defiprovisionempleadoLocal)) {				
					DefiProvisionEmpleadoDataAccess.save(defiprovisionempleadoLocal, connexion);				
				} else {
					validadoTodosDefiProvisionEmpleado=false;
				}
			}
			
			if(!validadoTodosDefiProvisionEmpleado) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DefiProvisionEmpleadoLogicAdditional.checkDefiProvisionEmpleadoToSavesAfter(defiprovisionempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDefiProvisionEmpleadosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DefiProvisionEmpleadoParameterReturnGeneral procesarAccionDefiProvisionEmpleados(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DefiProvisionEmpleado> defiprovisionempleados,DefiProvisionEmpleadoParameterReturnGeneral defiprovisionempleadoParameterGeneral)throws Exception {
		 try {	
			DefiProvisionEmpleadoParameterReturnGeneral defiprovisionempleadoReturnGeneral=new DefiProvisionEmpleadoParameterReturnGeneral();
	
			DefiProvisionEmpleadoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,defiprovisionempleados,defiprovisionempleadoParameterGeneral,defiprovisionempleadoReturnGeneral);
			
			return defiprovisionempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DefiProvisionEmpleadoParameterReturnGeneral procesarAccionDefiProvisionEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DefiProvisionEmpleado> defiprovisionempleados,DefiProvisionEmpleadoParameterReturnGeneral defiprovisionempleadoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DefiProvisionEmpleado.class.getSimpleName()+"-procesarAccionDefiProvisionEmpleadosWithConnection");connexion.begin();			
			
			DefiProvisionEmpleadoParameterReturnGeneral defiprovisionempleadoReturnGeneral=new DefiProvisionEmpleadoParameterReturnGeneral();
	
			DefiProvisionEmpleadoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,defiprovisionempleados,defiprovisionempleadoParameterGeneral,defiprovisionempleadoReturnGeneral);
			
			this.connexion.commit();
			
			return defiprovisionempleadoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DefiProvisionEmpleadoParameterReturnGeneral procesarEventosDefiProvisionEmpleados(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DefiProvisionEmpleado> defiprovisionempleados,DefiProvisionEmpleado defiprovisionempleado,DefiProvisionEmpleadoParameterReturnGeneral defiprovisionempleadoParameterGeneral,Boolean isEsNuevoDefiProvisionEmpleado,ArrayList<Classe> clases)throws Exception {
		 try {	
			DefiProvisionEmpleadoParameterReturnGeneral defiprovisionempleadoReturnGeneral=new DefiProvisionEmpleadoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				defiprovisionempleadoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DefiProvisionEmpleadoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,defiprovisionempleados,defiprovisionempleado,defiprovisionempleadoParameterGeneral,defiprovisionempleadoReturnGeneral,isEsNuevoDefiProvisionEmpleado,clases);
			
			return defiprovisionempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DefiProvisionEmpleadoParameterReturnGeneral procesarEventosDefiProvisionEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DefiProvisionEmpleado> defiprovisionempleados,DefiProvisionEmpleado defiprovisionempleado,DefiProvisionEmpleadoParameterReturnGeneral defiprovisionempleadoParameterGeneral,Boolean isEsNuevoDefiProvisionEmpleado,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DefiProvisionEmpleado.class.getSimpleName()+"-procesarEventosDefiProvisionEmpleadosWithConnection");connexion.begin();			
			
			DefiProvisionEmpleadoParameterReturnGeneral defiprovisionempleadoReturnGeneral=new DefiProvisionEmpleadoParameterReturnGeneral();
	
			defiprovisionempleadoReturnGeneral.setDefiProvisionEmpleado(defiprovisionempleado);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				defiprovisionempleadoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DefiProvisionEmpleadoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,defiprovisionempleados,defiprovisionempleado,defiprovisionempleadoParameterGeneral,defiprovisionempleadoReturnGeneral,isEsNuevoDefiProvisionEmpleado,clases);
			
			this.connexion.commit();
			
			return defiprovisionempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DefiProvisionEmpleadoParameterReturnGeneral procesarImportacionDefiProvisionEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DefiProvisionEmpleadoParameterReturnGeneral defiprovisionempleadoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DefiProvisionEmpleado.class.getSimpleName()+"-procesarImportacionDefiProvisionEmpleadosWithConnection");connexion.begin();			
			
			DefiProvisionEmpleadoParameterReturnGeneral defiprovisionempleadoReturnGeneral=new DefiProvisionEmpleadoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.defiprovisionempleados=new ArrayList<DefiProvisionEmpleado>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.defiprovisionempleado=new DefiProvisionEmpleado();
				
				
				if(conColumnasBase) {this.defiprovisionempleado.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.defiprovisionempleado.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.defiprovisionempleado.setnombre(arrColumnas[iColumn++]);
				this.defiprovisionempleado.setdia_inicial(Integer.parseInt(arrColumnas[iColumn++]));
				this.defiprovisionempleado.setdia_final(Integer.parseInt(arrColumnas[iColumn++]));
				this.defiprovisionempleado.setpara_liquidacion(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.defiprovisionempleado.setdescripcion(arrColumnas[iColumn++]);
				
				this.defiprovisionempleados.add(this.defiprovisionempleado);
			}
			
			this.saveDefiProvisionEmpleados();
			
			this.connexion.commit();
			
			defiprovisionempleadoReturnGeneral.setConRetornoEstaProcesado(true);
			defiprovisionempleadoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return defiprovisionempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDefiProvisionEmpleadosEliminados() throws Exception {				
		
		List<DefiProvisionEmpleado> defiprovisionempleadosAux= new ArrayList<DefiProvisionEmpleado>();
		
		for(DefiProvisionEmpleado defiprovisionempleado:defiprovisionempleados) {
			if(!defiprovisionempleado.getIsDeleted()) {
				defiprovisionempleadosAux.add(defiprovisionempleado);
			}
		}
		
		defiprovisionempleados=defiprovisionempleadosAux;
	}
	
	public void quitarDefiProvisionEmpleadosNulos() throws Exception {				
		
		List<DefiProvisionEmpleado> defiprovisionempleadosAux= new ArrayList<DefiProvisionEmpleado>();
		
		for(DefiProvisionEmpleado defiprovisionempleado : this.defiprovisionempleados) {
			if(defiprovisionempleado==null) {
				defiprovisionempleadosAux.add(defiprovisionempleado);
			}
		}
		
		//this.defiprovisionempleados=defiprovisionempleadosAux;
		
		this.defiprovisionempleados.removeAll(defiprovisionempleadosAux);
	}
	
	public void getSetVersionRowDefiProvisionEmpleadoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(defiprovisionempleado.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((defiprovisionempleado.getIsDeleted() || (defiprovisionempleado.getIsChanged()&&!defiprovisionempleado.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=defiprovisionempleadoDataAccess.getSetVersionRowDefiProvisionEmpleado(connexion,defiprovisionempleado.getId());
				
				if(!defiprovisionempleado.getVersionRow().equals(timestamp)) {	
					defiprovisionempleado.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				defiprovisionempleado.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDefiProvisionEmpleado()throws Exception {	
		
		if(defiprovisionempleado.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((defiprovisionempleado.getIsDeleted() || (defiprovisionempleado.getIsChanged()&&!defiprovisionempleado.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=defiprovisionempleadoDataAccess.getSetVersionRowDefiProvisionEmpleado(connexion,defiprovisionempleado.getId());
			
			try {							
				if(!defiprovisionempleado.getVersionRow().equals(timestamp)) {	
					defiprovisionempleado.setVersionRow(timestamp);
				}
				
				defiprovisionempleado.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDefiProvisionEmpleadosWithConnection()throws Exception {	
		if(defiprovisionempleados!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DefiProvisionEmpleado defiprovisionempleadoAux:defiprovisionempleados) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(defiprovisionempleadoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(defiprovisionempleadoAux.getIsDeleted() || (defiprovisionempleadoAux.getIsChanged()&&!defiprovisionempleadoAux.getIsNew())) {
						
						timestamp=defiprovisionempleadoDataAccess.getSetVersionRowDefiProvisionEmpleado(connexion,defiprovisionempleadoAux.getId());
						
						if(!defiprovisionempleado.getVersionRow().equals(timestamp)) {	
							defiprovisionempleadoAux.setVersionRow(timestamp);
						}
								
						defiprovisionempleadoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDefiProvisionEmpleados()throws Exception {	
		if(defiprovisionempleados!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DefiProvisionEmpleado defiprovisionempleadoAux:defiprovisionempleados) {
					if(defiprovisionempleadoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(defiprovisionempleadoAux.getIsDeleted() || (defiprovisionempleadoAux.getIsChanged()&&!defiprovisionempleadoAux.getIsNew())) {
						
						timestamp=defiprovisionempleadoDataAccess.getSetVersionRowDefiProvisionEmpleado(connexion,defiprovisionempleadoAux.getId());
						
						if(!defiprovisionempleadoAux.getVersionRow().equals(timestamp)) {	
							defiprovisionempleadoAux.setVersionRow(timestamp);
						}
						
													
						defiprovisionempleadoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DefiProvisionEmpleadoParameterReturnGeneral cargarCombosLoteForeignKeyDefiProvisionEmpleadoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalRubroEmplea,String finalQueryGlobalFormato,String finalQueryGlobalMesInicial,String finalQueryGlobalMesFinal) throws Exception {
		DefiProvisionEmpleadoParameterReturnGeneral  defiprovisionempleadoReturnGeneral =new DefiProvisionEmpleadoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DefiProvisionEmpleado.class.getSimpleName()+"-cargarCombosLoteForeignKeyDefiProvisionEmpleadoWithConnection");connexion.begin();
			
			defiprovisionempleadoReturnGeneral =new DefiProvisionEmpleadoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			defiprovisionempleadoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<RubroEmplea> rubroempleasForeignKey=new ArrayList<RubroEmplea>();
			RubroEmpleaLogic rubroempleaLogic=new RubroEmpleaLogic();
			rubroempleaLogic.setConnexion(this.connexion);
			rubroempleaLogic.getRubroEmpleaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRubroEmplea.equals("NONE")) {
				rubroempleaLogic.getTodosRubroEmpleas(finalQueryGlobalRubroEmplea,new Pagination());
				rubroempleasForeignKey=rubroempleaLogic.getRubroEmpleas();
			}

			defiprovisionempleadoReturnGeneral.setrubroempleasForeignKey(rubroempleasForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			defiprovisionempleadoReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<Mes> mesinicialsForeignKey=new ArrayList<Mes>();
			MesLogic mesinicialLogic=new MesLogic();
			mesinicialLogic.setConnexion(this.connexion);
			mesinicialLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMesInicial.equals("NONE")) {
				mesinicialLogic.getTodosMess(finalQueryGlobalMesInicial,new Pagination());
				mesinicialsForeignKey=mesinicialLogic.getMess();
			}

			defiprovisionempleadoReturnGeneral.setmesinicialsForeignKey(mesinicialsForeignKey);


			List<Mes> mesfinalsForeignKey=new ArrayList<Mes>();
			MesLogic mesfinalLogic=new MesLogic();
			mesfinalLogic.setConnexion(this.connexion);
			mesfinalLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMesFinal.equals("NONE")) {
				mesfinalLogic.getTodosMess(finalQueryGlobalMesFinal,new Pagination());
				mesfinalsForeignKey=mesfinalLogic.getMess();
			}

			defiprovisionempleadoReturnGeneral.setmesfinalsForeignKey(mesfinalsForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return defiprovisionempleadoReturnGeneral;
	}
	
	public DefiProvisionEmpleadoParameterReturnGeneral cargarCombosLoteForeignKeyDefiProvisionEmpleado(String finalQueryGlobalEmpresa,String finalQueryGlobalRubroEmplea,String finalQueryGlobalFormato,String finalQueryGlobalMesInicial,String finalQueryGlobalMesFinal) throws Exception {
		DefiProvisionEmpleadoParameterReturnGeneral  defiprovisionempleadoReturnGeneral =new DefiProvisionEmpleadoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			defiprovisionempleadoReturnGeneral =new DefiProvisionEmpleadoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			defiprovisionempleadoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<RubroEmplea> rubroempleasForeignKey=new ArrayList<RubroEmplea>();
			RubroEmpleaLogic rubroempleaLogic=new RubroEmpleaLogic();
			rubroempleaLogic.setConnexion(this.connexion);
			rubroempleaLogic.getRubroEmpleaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRubroEmplea.equals("NONE")) {
				rubroempleaLogic.getTodosRubroEmpleas(finalQueryGlobalRubroEmplea,new Pagination());
				rubroempleasForeignKey=rubroempleaLogic.getRubroEmpleas();
			}

			defiprovisionempleadoReturnGeneral.setrubroempleasForeignKey(rubroempleasForeignKey);


			List<Formato> formatosForeignKey=new ArrayList<Formato>();
			FormatoLogic formatoLogic=new FormatoLogic();
			formatoLogic.setConnexion(this.connexion);
			formatoLogic.getFormatoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormato.equals("NONE")) {
				formatoLogic.getTodosFormatos(finalQueryGlobalFormato,new Pagination());
				formatosForeignKey=formatoLogic.getFormatos();
			}

			defiprovisionempleadoReturnGeneral.setformatosForeignKey(formatosForeignKey);


			List<Mes> mesinicialsForeignKey=new ArrayList<Mes>();
			MesLogic mesinicialLogic=new MesLogic();
			mesinicialLogic.setConnexion(this.connexion);
			mesinicialLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMesInicial.equals("NONE")) {
				mesinicialLogic.getTodosMess(finalQueryGlobalMesInicial,new Pagination());
				mesinicialsForeignKey=mesinicialLogic.getMess();
			}

			defiprovisionempleadoReturnGeneral.setmesinicialsForeignKey(mesinicialsForeignKey);


			List<Mes> mesfinalsForeignKey=new ArrayList<Mes>();
			MesLogic mesfinalLogic=new MesLogic();
			mesfinalLogic.setConnexion(this.connexion);
			mesfinalLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMesFinal.equals("NONE")) {
				mesfinalLogic.getTodosMess(finalQueryGlobalMesFinal,new Pagination());
				mesfinalsForeignKey=mesfinalLogic.getMess();
			}

			defiprovisionempleadoReturnGeneral.setmesfinalsForeignKey(mesfinalsForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return defiprovisionempleadoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyDefiProvisionEmpleadoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			ProvisionEmpleadoLogic provisionempleadoLogic=new ProvisionEmpleadoLogic();
			CuotaLogic cuotaLogic=new CuotaLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DefiProvisionEmpleado.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyDefiProvisionEmpleadoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(ProvisionEmpleado.class));
			classes.add(new Classe(Cuota.class));
											
			

			provisionempleadoLogic.setConnexion(this.getConnexion());
			provisionempleadoLogic.setDatosCliente(this.datosCliente);
			provisionempleadoLogic.setIsConRefrescarForeignKeys(true);

			cuotaLogic.setConnexion(this.getConnexion());
			cuotaLogic.setDatosCliente(this.datosCliente);
			cuotaLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(DefiProvisionEmpleado defiprovisionempleado:this.defiprovisionempleados) {
				

				classes=new ArrayList<Classe>();
				classes=ProvisionEmpleadoConstantesFunciones.getClassesForeignKeysOfProvisionEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);

				provisionempleadoLogic.setProvisionEmpleados(defiprovisionempleado.provisionempleados);
				provisionempleadoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=CuotaConstantesFunciones.getClassesForeignKeysOfCuota(new ArrayList<Classe>(),DeepLoadType.NONE);

				cuotaLogic.setCuotas(defiprovisionempleado.cuotas);
				cuotaLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(DefiProvisionEmpleado defiprovisionempleado,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DefiProvisionEmpleadoLogicAdditional.updateDefiProvisionEmpleadoToGet(defiprovisionempleado,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		defiprovisionempleado.setEmpresa(defiprovisionempleadoDataAccess.getEmpresa(connexion,defiprovisionempleado));
		defiprovisionempleado.setRubroEmplea(defiprovisionempleadoDataAccess.getRubroEmplea(connexion,defiprovisionempleado));
		defiprovisionempleado.setFormato(defiprovisionempleadoDataAccess.getFormato(connexion,defiprovisionempleado));
		defiprovisionempleado.setMesInicial(defiprovisionempleadoDataAccess.getMesInicial(connexion,defiprovisionempleado));
		defiprovisionempleado.setMesFinal(defiprovisionempleadoDataAccess.getMesFinal(connexion,defiprovisionempleado));
		defiprovisionempleado.setProvisionEmpleados(defiprovisionempleadoDataAccess.getProvisionEmpleados(connexion,defiprovisionempleado));
		defiprovisionempleado.setCuotas(defiprovisionempleadoDataAccess.getCuotas(connexion,defiprovisionempleado));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				defiprovisionempleado.setEmpresa(defiprovisionempleadoDataAccess.getEmpresa(connexion,defiprovisionempleado));
				continue;
			}

			if(clas.clas.equals(RubroEmplea.class)) {
				defiprovisionempleado.setRubroEmplea(defiprovisionempleadoDataAccess.getRubroEmplea(connexion,defiprovisionempleado));
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				defiprovisionempleado.setFormato(defiprovisionempleadoDataAccess.getFormato(connexion,defiprovisionempleado));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				defiprovisionempleado.setMesInicial(defiprovisionempleadoDataAccess.getMesInicial(connexion,defiprovisionempleado));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				defiprovisionempleado.setMesFinal(defiprovisionempleadoDataAccess.getMesFinal(connexion,defiprovisionempleado));
				continue;
			}

			if(clas.clas.equals(ProvisionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				defiprovisionempleado.setProvisionEmpleados(defiprovisionempleadoDataAccess.getProvisionEmpleados(connexion,defiprovisionempleado));

				if(this.isConDeep) {
					ProvisionEmpleadoLogic provisionempleadoLogic= new ProvisionEmpleadoLogic(this.connexion);
					provisionempleadoLogic.setProvisionEmpleados(defiprovisionempleado.getProvisionEmpleados());
					ArrayList<Classe> classesLocal=ProvisionEmpleadoConstantesFunciones.getClassesForeignKeysOfProvisionEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);
					provisionempleadoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesProvisionEmpleado(provisionempleadoLogic.getProvisionEmpleados());
					defiprovisionempleado.setProvisionEmpleados(provisionempleadoLogic.getProvisionEmpleados());
				}

				continue;
			}

			if(clas.clas.equals(Cuota.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				defiprovisionempleado.setCuotas(defiprovisionempleadoDataAccess.getCuotas(connexion,defiprovisionempleado));

				if(this.isConDeep) {
					CuotaLogic cuotaLogic= new CuotaLogic(this.connexion);
					cuotaLogic.setCuotas(defiprovisionempleado.getCuotas());
					ArrayList<Classe> classesLocal=CuotaConstantesFunciones.getClassesForeignKeysOfCuota(new ArrayList<Classe>(),DeepLoadType.NONE);
					cuotaLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					CuotaConstantesFunciones.refrescarForeignKeysDescripcionesCuota(cuotaLogic.getCuotas());
					defiprovisionempleado.setCuotas(cuotaLogic.getCuotas());
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
			defiprovisionempleado.setEmpresa(defiprovisionempleadoDataAccess.getEmpresa(connexion,defiprovisionempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RubroEmplea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			defiprovisionempleado.setRubroEmplea(defiprovisionempleadoDataAccess.getRubroEmplea(connexion,defiprovisionempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			defiprovisionempleado.setFormato(defiprovisionempleadoDataAccess.getFormato(connexion,defiprovisionempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			defiprovisionempleado.setMesInicial(defiprovisionempleadoDataAccess.getMesInicial(connexion,defiprovisionempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			defiprovisionempleado.setMesFinal(defiprovisionempleadoDataAccess.getMesFinal(connexion,defiprovisionempleado));
		}

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
			defiprovisionempleado.setProvisionEmpleados(defiprovisionempleadoDataAccess.getProvisionEmpleados(connexion,defiprovisionempleado));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cuota.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Cuota.class));
			defiprovisionempleado.setCuotas(defiprovisionempleadoDataAccess.getCuotas(connexion,defiprovisionempleado));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		defiprovisionempleado.setEmpresa(defiprovisionempleadoDataAccess.getEmpresa(connexion,defiprovisionempleado));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(defiprovisionempleado.getEmpresa(),isDeep,deepLoadType,clases);
				
		defiprovisionempleado.setRubroEmplea(defiprovisionempleadoDataAccess.getRubroEmplea(connexion,defiprovisionempleado));
		RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
		rubroempleaLogic.deepLoad(defiprovisionempleado.getRubroEmplea(),isDeep,deepLoadType,clases);
				
		defiprovisionempleado.setFormato(defiprovisionempleadoDataAccess.getFormato(connexion,defiprovisionempleado));
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(defiprovisionempleado.getFormato(),isDeep,deepLoadType,clases);
				
		defiprovisionempleado.setMesInicial(defiprovisionempleadoDataAccess.getMesInicial(connexion,defiprovisionempleado));
		MesLogic mesinicialLogic= new MesLogic(connexion);
		mesinicialLogic.deepLoad(defiprovisionempleado.getMesInicial(),isDeep,deepLoadType,clases);
				
		defiprovisionempleado.setMesFinal(defiprovisionempleadoDataAccess.getMesFinal(connexion,defiprovisionempleado));
		MesLogic mesfinalLogic= new MesLogic(connexion);
		mesfinalLogic.deepLoad(defiprovisionempleado.getMesFinal(),isDeep,deepLoadType,clases);
				

		defiprovisionempleado.setProvisionEmpleados(defiprovisionempleadoDataAccess.getProvisionEmpleados(connexion,defiprovisionempleado));

		for(ProvisionEmpleado provisionempleado:defiprovisionempleado.getProvisionEmpleados()) {
			ProvisionEmpleadoLogic provisionempleadoLogic= new ProvisionEmpleadoLogic(connexion);
			provisionempleadoLogic.deepLoad(provisionempleado,isDeep,deepLoadType,clases);
		}

		defiprovisionempleado.setCuotas(defiprovisionempleadoDataAccess.getCuotas(connexion,defiprovisionempleado));

		for(Cuota cuota:defiprovisionempleado.getCuotas()) {
			CuotaLogic cuotaLogic= new CuotaLogic(connexion);
			cuotaLogic.deepLoad(cuota,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				defiprovisionempleado.setEmpresa(defiprovisionempleadoDataAccess.getEmpresa(connexion,defiprovisionempleado));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(defiprovisionempleado.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(RubroEmplea.class)) {
				defiprovisionempleado.setRubroEmplea(defiprovisionempleadoDataAccess.getRubroEmplea(connexion,defiprovisionempleado));
				RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
				rubroempleaLogic.deepLoad(defiprovisionempleado.getRubroEmplea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				defiprovisionempleado.setFormato(defiprovisionempleadoDataAccess.getFormato(connexion,defiprovisionempleado));
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepLoad(defiprovisionempleado.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				defiprovisionempleado.setMesInicial(defiprovisionempleadoDataAccess.getMesInicial(connexion,defiprovisionempleado));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(defiprovisionempleado.getMesInicial(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				defiprovisionempleado.setMesFinal(defiprovisionempleadoDataAccess.getMesFinal(connexion,defiprovisionempleado));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(defiprovisionempleado.getMesFinal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ProvisionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				defiprovisionempleado.setProvisionEmpleados(defiprovisionempleadoDataAccess.getProvisionEmpleados(connexion,defiprovisionempleado));

				for(ProvisionEmpleado provisionempleado:defiprovisionempleado.getProvisionEmpleados()) {
					ProvisionEmpleadoLogic provisionempleadoLogic= new ProvisionEmpleadoLogic(connexion);
					provisionempleadoLogic.deepLoad(provisionempleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Cuota.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				defiprovisionempleado.setCuotas(defiprovisionempleadoDataAccess.getCuotas(connexion,defiprovisionempleado));

				for(Cuota cuota:defiprovisionempleado.getCuotas()) {
					CuotaLogic cuotaLogic= new CuotaLogic(connexion);
					cuotaLogic.deepLoad(cuota,isDeep,deepLoadType,clases);
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
			defiprovisionempleado.setEmpresa(defiprovisionempleadoDataAccess.getEmpresa(connexion,defiprovisionempleado));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(defiprovisionempleado.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(RubroEmplea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			defiprovisionempleado.setRubroEmplea(defiprovisionempleadoDataAccess.getRubroEmplea(connexion,defiprovisionempleado));
			RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
			rubroempleaLogic.deepLoad(defiprovisionempleado.getRubroEmplea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Formato.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			defiprovisionempleado.setFormato(defiprovisionempleadoDataAccess.getFormato(connexion,defiprovisionempleado));
			FormatoLogic formatoLogic= new FormatoLogic(connexion);
			formatoLogic.deepLoad(defiprovisionempleado.getFormato(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			defiprovisionempleado.setMesInicial(defiprovisionempleadoDataAccess.getMesInicial(connexion,defiprovisionempleado));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(defiprovisionempleado.getMesInicial(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			defiprovisionempleado.setMesFinal(defiprovisionempleadoDataAccess.getMesFinal(connexion,defiprovisionempleado));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(defiprovisionempleado.getMesFinal(),isDeep,deepLoadType,clases);
				
		}

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
			defiprovisionempleado.setProvisionEmpleados(defiprovisionempleadoDataAccess.getProvisionEmpleados(connexion,defiprovisionempleado));

			for(ProvisionEmpleado provisionempleado:defiprovisionempleado.getProvisionEmpleados()) {
				ProvisionEmpleadoLogic provisionempleadoLogic= new ProvisionEmpleadoLogic(connexion);
				provisionempleadoLogic.deepLoad(provisionempleado,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cuota.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(Cuota.class));
			defiprovisionempleado.setCuotas(defiprovisionempleadoDataAccess.getCuotas(connexion,defiprovisionempleado));

			for(Cuota cuota:defiprovisionempleado.getCuotas()) {
				CuotaLogic cuotaLogic= new CuotaLogic(connexion);
				cuotaLogic.deepLoad(cuota,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DefiProvisionEmpleado defiprovisionempleado,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DefiProvisionEmpleadoLogicAdditional.updateDefiProvisionEmpleadoToSave(defiprovisionempleado,this.arrDatoGeneral);
			
DefiProvisionEmpleadoDataAccess.save(defiprovisionempleado, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(defiprovisionempleado.getEmpresa(),connexion);

		RubroEmpleaDataAccess.save(defiprovisionempleado.getRubroEmplea(),connexion);

		FormatoDataAccess.save(defiprovisionempleado.getFormato(),connexion);

		MesDataAccess.save(defiprovisionempleado.getMesInicial(),connexion);

		MesDataAccess.save(defiprovisionempleado.getMesFinal(),connexion);

		for(ProvisionEmpleado provisionempleado:defiprovisionempleado.getProvisionEmpleados()) {
			provisionempleado.setid_defi_provision_empleado(defiprovisionempleado.getId());
			ProvisionEmpleadoDataAccess.save(provisionempleado,connexion);
		}

		for(Cuota cuota:defiprovisionempleado.getCuotas()) {
			cuota.setid_defi_provision_empleado(defiprovisionempleado.getId());
			CuotaDataAccess.save(cuota,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(defiprovisionempleado.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(RubroEmplea.class)) {
				RubroEmpleaDataAccess.save(defiprovisionempleado.getRubroEmplea(),connexion);
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(defiprovisionempleado.getFormato(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(defiprovisionempleado.getMesInicial(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(defiprovisionempleado.getMesFinal(),connexion);
				continue;
			}


			if(clas.clas.equals(ProvisionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProvisionEmpleado provisionempleado:defiprovisionempleado.getProvisionEmpleados()) {
					provisionempleado.setid_defi_provision_empleado(defiprovisionempleado.getId());
					ProvisionEmpleadoDataAccess.save(provisionempleado,connexion);
				}
				continue;
			}

			if(clas.clas.equals(Cuota.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cuota cuota:defiprovisionempleado.getCuotas()) {
					cuota.setid_defi_provision_empleado(defiprovisionempleado.getId());
					CuotaDataAccess.save(cuota,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(defiprovisionempleado.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(defiprovisionempleado.getEmpresa(),isDeep,deepLoadType,clases);
				

		RubroEmpleaDataAccess.save(defiprovisionempleado.getRubroEmplea(),connexion);
		RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
		rubroempleaLogic.deepLoad(defiprovisionempleado.getRubroEmplea(),isDeep,deepLoadType,clases);
				

		FormatoDataAccess.save(defiprovisionempleado.getFormato(),connexion);
		FormatoLogic formatoLogic= new FormatoLogic(connexion);
		formatoLogic.deepLoad(defiprovisionempleado.getFormato(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(defiprovisionempleado.getMesInicial(),connexion);
		MesLogic mesinicialLogic= new MesLogic(connexion);
		mesinicialLogic.deepLoad(defiprovisionempleado.getMesInicial(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(defiprovisionempleado.getMesFinal(),connexion);
		MesLogic mesfinalLogic= new MesLogic(connexion);
		mesfinalLogic.deepLoad(defiprovisionempleado.getMesFinal(),isDeep,deepLoadType,clases);
				

		for(ProvisionEmpleado provisionempleado:defiprovisionempleado.getProvisionEmpleados()) {
			ProvisionEmpleadoLogic provisionempleadoLogic= new ProvisionEmpleadoLogic(connexion);
			provisionempleado.setid_defi_provision_empleado(defiprovisionempleado.getId());
			ProvisionEmpleadoDataAccess.save(provisionempleado,connexion);
			provisionempleadoLogic.deepSave(provisionempleado,isDeep,deepLoadType,clases);
		}

		for(Cuota cuota:defiprovisionempleado.getCuotas()) {
			CuotaLogic cuotaLogic= new CuotaLogic(connexion);
			cuota.setid_defi_provision_empleado(defiprovisionempleado.getId());
			CuotaDataAccess.save(cuota,connexion);
			cuotaLogic.deepSave(cuota,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(defiprovisionempleado.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(defiprovisionempleado.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(RubroEmplea.class)) {
				RubroEmpleaDataAccess.save(defiprovisionempleado.getRubroEmplea(),connexion);
				RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
				rubroempleaLogic.deepSave(defiprovisionempleado.getRubroEmplea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Formato.class)) {
				FormatoDataAccess.save(defiprovisionempleado.getFormato(),connexion);
				FormatoLogic formatoLogic= new FormatoLogic(connexion);
				formatoLogic.deepSave(defiprovisionempleado.getFormato(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(defiprovisionempleado.getMesInicial(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(defiprovisionempleado.getMesInicial(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(defiprovisionempleado.getMesFinal(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(defiprovisionempleado.getMesFinal(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(ProvisionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ProvisionEmpleado provisionempleado:defiprovisionempleado.getProvisionEmpleados()) {
					ProvisionEmpleadoLogic provisionempleadoLogic= new ProvisionEmpleadoLogic(connexion);
					provisionempleado.setid_defi_provision_empleado(defiprovisionempleado.getId());
					ProvisionEmpleadoDataAccess.save(provisionempleado,connexion);
					provisionempleadoLogic.deepSave(provisionempleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(Cuota.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(Cuota cuota:defiprovisionempleado.getCuotas()) {
					CuotaLogic cuotaLogic= new CuotaLogic(connexion);
					cuota.setid_defi_provision_empleado(defiprovisionempleado.getId());
					CuotaDataAccess.save(cuota,connexion);
					cuotaLogic.deepSave(cuota,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(DefiProvisionEmpleado.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(defiprovisionempleado,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DefiProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDefiProvisionEmpleado(defiprovisionempleado);
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
			this.deepLoad(this.defiprovisionempleado,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DefiProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDefiProvisionEmpleado(this.defiprovisionempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DefiProvisionEmpleado.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(defiprovisionempleados!=null) {
				for(DefiProvisionEmpleado defiprovisionempleado:defiprovisionempleados) {
					this.deepLoad(defiprovisionempleado,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DefiProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDefiProvisionEmpleado(defiprovisionempleados);
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
			if(defiprovisionempleados!=null) {
				for(DefiProvisionEmpleado defiprovisionempleado:defiprovisionempleados) {
					this.deepLoad(defiprovisionempleado,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DefiProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDefiProvisionEmpleado(defiprovisionempleados);
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
			this.getNewConnexionToDeep(DefiProvisionEmpleado.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(defiprovisionempleado,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DefiProvisionEmpleado.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(defiprovisionempleados!=null) {
				for(DefiProvisionEmpleado defiprovisionempleado:defiprovisionempleados) {
					this.deepSave(defiprovisionempleado,isDeep,deepLoadType,clases);
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
			if(defiprovisionempleados!=null) {
				for(DefiProvisionEmpleado defiprovisionempleado:defiprovisionempleados) {
					this.deepSave(defiprovisionempleado,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDefiProvisionEmpleadosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DefiProvisionEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DefiProvisionEmpleadoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DefiProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			defiprovisionempleados=defiprovisionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefiProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDefiProvisionEmpleado(this.defiprovisionempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDefiProvisionEmpleadosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DefiProvisionEmpleadoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DefiProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			defiprovisionempleados=defiprovisionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefiProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDefiProvisionEmpleado(this.defiprovisionempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDefiProvisionEmpleadosFK_IdFormatoWithConnection(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DefiProvisionEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,DefiProvisionEmpleadoConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			DefiProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			defiprovisionempleados=defiprovisionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefiProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDefiProvisionEmpleado(this.defiprovisionempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDefiProvisionEmpleadosFK_IdFormato(String sFinalQuery,Pagination pagination,Long id_formato)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormato= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormato.setParameterSelectionGeneralEqual(ParameterType.LONG,id_formato,DefiProvisionEmpleadoConstantesFunciones.IDFORMATO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormato);

			DefiProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormato","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			defiprovisionempleados=defiprovisionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefiProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDefiProvisionEmpleado(this.defiprovisionempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDefiProvisionEmpleadosFK_IdMesFinalWithConnection(String sFinalQuery,Pagination pagination,Long id_mes_final)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DefiProvisionEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMesFinal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMesFinal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes_final,DefiProvisionEmpleadoConstantesFunciones.IDMESFINAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMesFinal);

			DefiProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMesFinal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			defiprovisionempleados=defiprovisionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefiProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDefiProvisionEmpleado(this.defiprovisionempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDefiProvisionEmpleadosFK_IdMesFinal(String sFinalQuery,Pagination pagination,Long id_mes_final)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMesFinal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMesFinal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes_final,DefiProvisionEmpleadoConstantesFunciones.IDMESFINAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMesFinal);

			DefiProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMesFinal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			defiprovisionempleados=defiprovisionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefiProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDefiProvisionEmpleado(this.defiprovisionempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDefiProvisionEmpleadosFK_IdMesInicialWithConnection(String sFinalQuery,Pagination pagination,Long id_mes_inicial)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DefiProvisionEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMesInicial= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMesInicial.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes_inicial,DefiProvisionEmpleadoConstantesFunciones.IDMESINICIAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMesInicial);

			DefiProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMesInicial","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			defiprovisionempleados=defiprovisionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefiProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDefiProvisionEmpleado(this.defiprovisionempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDefiProvisionEmpleadosFK_IdMesInicial(String sFinalQuery,Pagination pagination,Long id_mes_inicial)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMesInicial= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMesInicial.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes_inicial,DefiProvisionEmpleadoConstantesFunciones.IDMESINICIAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMesInicial);

			DefiProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMesInicial","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			defiprovisionempleados=defiprovisionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefiProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDefiProvisionEmpleado(this.defiprovisionempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDefiProvisionEmpleadosFK_IdRubroEmpleaWithConnection(String sFinalQuery,Pagination pagination,Long id_rubro_emplea)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DefiProvisionEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRubroEmplea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRubroEmplea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_rubro_emplea,DefiProvisionEmpleadoConstantesFunciones.IDRUBROEMPLEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRubroEmplea);

			DefiProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRubroEmplea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			defiprovisionempleados=defiprovisionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefiProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDefiProvisionEmpleado(this.defiprovisionempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDefiProvisionEmpleadosFK_IdRubroEmplea(String sFinalQuery,Pagination pagination,Long id_rubro_emplea)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRubroEmplea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRubroEmplea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_rubro_emplea,DefiProvisionEmpleadoConstantesFunciones.IDRUBROEMPLEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRubroEmplea);

			DefiProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRubroEmplea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			defiprovisionempleados=defiprovisionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DefiProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDefiProvisionEmpleado(this.defiprovisionempleados);
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
			if(DefiProvisionEmpleadoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DefiProvisionEmpleadoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DefiProvisionEmpleado defiprovisionempleado,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DefiProvisionEmpleadoConstantesFunciones.ISCONAUDITORIA) {
				if(defiprovisionempleado.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DefiProvisionEmpleadoDataAccess.TABLENAME, defiprovisionempleado.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DefiProvisionEmpleadoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DefiProvisionEmpleadoLogic.registrarAuditoriaDetallesDefiProvisionEmpleado(connexion,defiprovisionempleado,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(defiprovisionempleado.getIsDeleted()) {
					/*if(!defiprovisionempleado.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DefiProvisionEmpleadoDataAccess.TABLENAME, defiprovisionempleado.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DefiProvisionEmpleadoLogic.registrarAuditoriaDetallesDefiProvisionEmpleado(connexion,defiprovisionempleado,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DefiProvisionEmpleadoDataAccess.TABLENAME, defiprovisionempleado.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(defiprovisionempleado.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DefiProvisionEmpleadoDataAccess.TABLENAME, defiprovisionempleado.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DefiProvisionEmpleadoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DefiProvisionEmpleadoLogic.registrarAuditoriaDetallesDefiProvisionEmpleado(connexion,defiprovisionempleado,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDefiProvisionEmpleado(Connexion connexion,DefiProvisionEmpleado defiprovisionempleado)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(defiprovisionempleado.getIsNew()||!defiprovisionempleado.getid_empresa().equals(defiprovisionempleado.getDefiProvisionEmpleadoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(defiprovisionempleado.getDefiProvisionEmpleadoOriginal().getid_empresa()!=null)
				{
					strValorActual=defiprovisionempleado.getDefiProvisionEmpleadoOriginal().getid_empresa().toString();
				}
				if(defiprovisionempleado.getid_empresa()!=null)
				{
					strValorNuevo=defiprovisionempleado.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefiProvisionEmpleadoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(defiprovisionempleado.getIsNew()||!defiprovisionempleado.getid_rubro_emplea().equals(defiprovisionempleado.getDefiProvisionEmpleadoOriginal().getid_rubro_emplea()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(defiprovisionempleado.getDefiProvisionEmpleadoOriginal().getid_rubro_emplea()!=null)
				{
					strValorActual=defiprovisionempleado.getDefiProvisionEmpleadoOriginal().getid_rubro_emplea().toString();
				}
				if(defiprovisionempleado.getid_rubro_emplea()!=null)
				{
					strValorNuevo=defiprovisionempleado.getid_rubro_emplea().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefiProvisionEmpleadoConstantesFunciones.IDRUBROEMPLEA,strValorActual,strValorNuevo);
			}	
			
			if(defiprovisionempleado.getIsNew()||!defiprovisionempleado.getid_formato().equals(defiprovisionempleado.getDefiProvisionEmpleadoOriginal().getid_formato()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(defiprovisionempleado.getDefiProvisionEmpleadoOriginal().getid_formato()!=null)
				{
					strValorActual=defiprovisionempleado.getDefiProvisionEmpleadoOriginal().getid_formato().toString();
				}
				if(defiprovisionempleado.getid_formato()!=null)
				{
					strValorNuevo=defiprovisionempleado.getid_formato().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefiProvisionEmpleadoConstantesFunciones.IDFORMATO,strValorActual,strValorNuevo);
			}	
			
			if(defiprovisionempleado.getIsNew()||!defiprovisionempleado.getnombre().equals(defiprovisionempleado.getDefiProvisionEmpleadoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(defiprovisionempleado.getDefiProvisionEmpleadoOriginal().getnombre()!=null)
				{
					strValorActual=defiprovisionempleado.getDefiProvisionEmpleadoOriginal().getnombre();
				}
				if(defiprovisionempleado.getnombre()!=null)
				{
					strValorNuevo=defiprovisionempleado.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefiProvisionEmpleadoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(defiprovisionempleado.getIsNew()||!defiprovisionempleado.getdia_inicial().equals(defiprovisionempleado.getDefiProvisionEmpleadoOriginal().getdia_inicial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(defiprovisionempleado.getDefiProvisionEmpleadoOriginal().getdia_inicial()!=null)
				{
					strValorActual=defiprovisionempleado.getDefiProvisionEmpleadoOriginal().getdia_inicial().toString();
				}
				if(defiprovisionempleado.getdia_inicial()!=null)
				{
					strValorNuevo=defiprovisionempleado.getdia_inicial().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefiProvisionEmpleadoConstantesFunciones.DIAINICIAL,strValorActual,strValorNuevo);
			}	
			
			if(defiprovisionempleado.getIsNew()||!defiprovisionempleado.getid_mes_inicial().equals(defiprovisionempleado.getDefiProvisionEmpleadoOriginal().getid_mes_inicial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(defiprovisionempleado.getDefiProvisionEmpleadoOriginal().getid_mes_inicial()!=null)
				{
					strValorActual=defiprovisionempleado.getDefiProvisionEmpleadoOriginal().getid_mes_inicial().toString();
				}
				if(defiprovisionempleado.getid_mes_inicial()!=null)
				{
					strValorNuevo=defiprovisionempleado.getid_mes_inicial().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefiProvisionEmpleadoConstantesFunciones.IDMESINICIAL,strValorActual,strValorNuevo);
			}	
			
			if(defiprovisionempleado.getIsNew()||!defiprovisionempleado.getdia_final().equals(defiprovisionempleado.getDefiProvisionEmpleadoOriginal().getdia_final()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(defiprovisionempleado.getDefiProvisionEmpleadoOriginal().getdia_final()!=null)
				{
					strValorActual=defiprovisionempleado.getDefiProvisionEmpleadoOriginal().getdia_final().toString();
				}
				if(defiprovisionempleado.getdia_final()!=null)
				{
					strValorNuevo=defiprovisionempleado.getdia_final().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefiProvisionEmpleadoConstantesFunciones.DIAFINAL,strValorActual,strValorNuevo);
			}	
			
			if(defiprovisionempleado.getIsNew()||!defiprovisionempleado.getid_mes_final().equals(defiprovisionempleado.getDefiProvisionEmpleadoOriginal().getid_mes_final()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(defiprovisionempleado.getDefiProvisionEmpleadoOriginal().getid_mes_final()!=null)
				{
					strValorActual=defiprovisionempleado.getDefiProvisionEmpleadoOriginal().getid_mes_final().toString();
				}
				if(defiprovisionempleado.getid_mes_final()!=null)
				{
					strValorNuevo=defiprovisionempleado.getid_mes_final().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefiProvisionEmpleadoConstantesFunciones.IDMESFINAL,strValorActual,strValorNuevo);
			}	
			
			if(defiprovisionempleado.getIsNew()||!defiprovisionempleado.getpara_liquidacion().equals(defiprovisionempleado.getDefiProvisionEmpleadoOriginal().getpara_liquidacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(defiprovisionempleado.getDefiProvisionEmpleadoOriginal().getpara_liquidacion()!=null)
				{
					strValorActual=defiprovisionempleado.getDefiProvisionEmpleadoOriginal().getpara_liquidacion().toString();
				}
				if(defiprovisionempleado.getpara_liquidacion()!=null)
				{
					strValorNuevo=defiprovisionempleado.getpara_liquidacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefiProvisionEmpleadoConstantesFunciones.PARALIQUIDACION,strValorActual,strValorNuevo);
			}	
			
			if(defiprovisionempleado.getIsNew()||!defiprovisionempleado.getdescripcion().equals(defiprovisionempleado.getDefiProvisionEmpleadoOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(defiprovisionempleado.getDefiProvisionEmpleadoOriginal().getdescripcion()!=null)
				{
					strValorActual=defiprovisionempleado.getDefiProvisionEmpleadoOriginal().getdescripcion();
				}
				if(defiprovisionempleado.getdescripcion()!=null)
				{
					strValorNuevo=defiprovisionempleado.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DefiProvisionEmpleadoConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDefiProvisionEmpleadoRelacionesWithConnection(DefiProvisionEmpleado defiprovisionempleado,List<ProvisionEmpleado> provisionempleados,List<Cuota> cuotas) throws Exception {

		if(!defiprovisionempleado.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDefiProvisionEmpleadoRelacionesBase(defiprovisionempleado,provisionempleados,cuotas,true);
		}
	}

	public void saveDefiProvisionEmpleadoRelaciones(DefiProvisionEmpleado defiprovisionempleado,List<ProvisionEmpleado> provisionempleados,List<Cuota> cuotas)throws Exception {

		if(!defiprovisionempleado.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDefiProvisionEmpleadoRelacionesBase(defiprovisionempleado,provisionempleados,cuotas,false);
		}
	}

	public void saveDefiProvisionEmpleadoRelacionesBase(DefiProvisionEmpleado defiprovisionempleado,List<ProvisionEmpleado> provisionempleados,List<Cuota> cuotas,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DefiProvisionEmpleado-saveRelacionesWithConnection");}
	
			defiprovisionempleado.setProvisionEmpleados(provisionempleados);
			defiprovisionempleado.setCuotas(cuotas);

			this.setDefiProvisionEmpleado(defiprovisionempleado);

			if(DefiProvisionEmpleadoLogicAdditional.validarSaveRelaciones(defiprovisionempleado,this)) {

				DefiProvisionEmpleadoLogicAdditional.updateRelacionesToSave(defiprovisionempleado,this);

				if((defiprovisionempleado.getIsNew()||defiprovisionempleado.getIsChanged())&&!defiprovisionempleado.getIsDeleted()) {
					this.saveDefiProvisionEmpleado();
					this.saveDefiProvisionEmpleadoRelacionesDetalles(provisionempleados,cuotas);

				} else if(defiprovisionempleado.getIsDeleted()) {
					this.saveDefiProvisionEmpleadoRelacionesDetalles(provisionempleados,cuotas);
					this.saveDefiProvisionEmpleado();
				}

				DefiProvisionEmpleadoLogicAdditional.updateRelacionesToSaveAfter(defiprovisionempleado,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			ProvisionEmpleadoConstantesFunciones.InicializarGeneralEntityAuxiliaresProvisionEmpleados(provisionempleados,true,true);
			CuotaConstantesFunciones.InicializarGeneralEntityAuxiliaresCuotas(cuotas,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveDefiProvisionEmpleadoRelacionesDetalles(List<ProvisionEmpleado> provisionempleados,List<Cuota> cuotas)throws Exception {
		try {
	

			Long idDefiProvisionEmpleadoActual=this.getDefiProvisionEmpleado().getId();

			ProvisionEmpleadoLogic provisionempleadoLogic_Desde_DefiProvisionEmpleado=new ProvisionEmpleadoLogic();
			provisionempleadoLogic_Desde_DefiProvisionEmpleado.setProvisionEmpleados(provisionempleados);

			provisionempleadoLogic_Desde_DefiProvisionEmpleado.setConnexion(this.getConnexion());
			provisionempleadoLogic_Desde_DefiProvisionEmpleado.setDatosCliente(this.datosCliente);

			for(ProvisionEmpleado provisionempleado_Desde_DefiProvisionEmpleado:provisionempleadoLogic_Desde_DefiProvisionEmpleado.getProvisionEmpleados()) {
				provisionempleado_Desde_DefiProvisionEmpleado.setid_defi_provision_empleado(idDefiProvisionEmpleadoActual);
			}

			provisionempleadoLogic_Desde_DefiProvisionEmpleado.saveProvisionEmpleados();

			CuotaLogic cuotaLogic_Desde_DefiProvisionEmpleado=new CuotaLogic();
			cuotaLogic_Desde_DefiProvisionEmpleado.setCuotas(cuotas);

			cuotaLogic_Desde_DefiProvisionEmpleado.setConnexion(this.getConnexion());
			cuotaLogic_Desde_DefiProvisionEmpleado.setDatosCliente(this.datosCliente);

			for(Cuota cuota_Desde_DefiProvisionEmpleado:cuotaLogic_Desde_DefiProvisionEmpleado.getCuotas()) {
				cuota_Desde_DefiProvisionEmpleado.setid_defi_provision_empleado(idDefiProvisionEmpleadoActual);
			}

			cuotaLogic_Desde_DefiProvisionEmpleado.saveCuotas();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDefiProvisionEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DefiProvisionEmpleadoConstantesFunciones.getClassesForeignKeysOfDefiProvisionEmpleado(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDefiProvisionEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DefiProvisionEmpleadoConstantesFunciones.getClassesRelationshipsOfDefiProvisionEmpleado(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

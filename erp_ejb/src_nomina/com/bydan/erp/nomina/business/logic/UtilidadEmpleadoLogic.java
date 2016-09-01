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
import com.bydan.erp.nomina.util.UtilidadEmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.UtilidadEmpleadoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.UtilidadEmpleadoParameterGeneral;
import com.bydan.erp.nomina.business.entity.UtilidadEmpleado;
import com.bydan.erp.nomina.business.logic.UtilidadEmpleadoLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class UtilidadEmpleadoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(UtilidadEmpleadoLogic.class);
	
	protected UtilidadEmpleadoDataAccess utilidadempleadoDataAccess; 	
	protected UtilidadEmpleado utilidadempleado;
	protected List<UtilidadEmpleado> utilidadempleados;
	protected Object utilidadempleadoObject;	
	protected List<Object> utilidadempleadosObject;
	
	public static ClassValidator<UtilidadEmpleado> utilidadempleadoValidator = new ClassValidator<UtilidadEmpleado>(UtilidadEmpleado.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected UtilidadEmpleadoLogicAdditional utilidadempleadoLogicAdditional=null;
	
	public UtilidadEmpleadoLogicAdditional getUtilidadEmpleadoLogicAdditional() {
		return this.utilidadempleadoLogicAdditional;
	}
	
	public void setUtilidadEmpleadoLogicAdditional(UtilidadEmpleadoLogicAdditional utilidadempleadoLogicAdditional) {
		try {
			this.utilidadempleadoLogicAdditional=utilidadempleadoLogicAdditional;
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
	
	
	
	
	public  UtilidadEmpleadoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.utilidadempleadoDataAccess = new UtilidadEmpleadoDataAccess();
			
			this.utilidadempleados= new ArrayList<UtilidadEmpleado>();
			this.utilidadempleado= new UtilidadEmpleado();
			
			this.utilidadempleadoObject=new Object();
			this.utilidadempleadosObject=new ArrayList<Object>();
				
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
			
			this.utilidadempleadoDataAccess.setConnexionType(this.connexionType);
			this.utilidadempleadoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  UtilidadEmpleadoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.utilidadempleadoDataAccess = new UtilidadEmpleadoDataAccess();
			this.utilidadempleados= new ArrayList<UtilidadEmpleado>();
			this.utilidadempleado= new UtilidadEmpleado();
			this.utilidadempleadoObject=new Object();
			this.utilidadempleadosObject=new ArrayList<Object>();
			
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
			
			this.utilidadempleadoDataAccess.setConnexionType(this.connexionType);
			this.utilidadempleadoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public UtilidadEmpleado getUtilidadEmpleado() throws Exception {	
		UtilidadEmpleadoLogicAdditional.checkUtilidadEmpleadoToGet(utilidadempleado,this.datosCliente,this.arrDatoGeneral);
		UtilidadEmpleadoLogicAdditional.updateUtilidadEmpleadoToGet(utilidadempleado,this.arrDatoGeneral);
		
		return utilidadempleado;
	}
		
	public void setUtilidadEmpleado(UtilidadEmpleado newUtilidadEmpleado) {
		this.utilidadempleado = newUtilidadEmpleado;
	}
	
	public UtilidadEmpleadoDataAccess getUtilidadEmpleadoDataAccess() {
		return utilidadempleadoDataAccess;
	}
	
	public void setUtilidadEmpleadoDataAccess(UtilidadEmpleadoDataAccess newutilidadempleadoDataAccess) {
		this.utilidadempleadoDataAccess = newutilidadempleadoDataAccess;
	}
	
	public List<UtilidadEmpleado> getUtilidadEmpleados() throws Exception {		
		this.quitarUtilidadEmpleadosNulos();
		
		UtilidadEmpleadoLogicAdditional.checkUtilidadEmpleadoToGets(utilidadempleados,this.datosCliente,this.arrDatoGeneral);
		
		for (UtilidadEmpleado utilidadempleadoLocal: utilidadempleados ) {
			UtilidadEmpleadoLogicAdditional.updateUtilidadEmpleadoToGet(utilidadempleadoLocal,this.arrDatoGeneral);
		}
		
		return utilidadempleados;
	}
	
	public void setUtilidadEmpleados(List<UtilidadEmpleado> newUtilidadEmpleados) {
		this.utilidadempleados = newUtilidadEmpleados;
	}
	
	public Object getUtilidadEmpleadoObject() {	
		this.utilidadempleadoObject=this.utilidadempleadoDataAccess.getEntityObject();
		return this.utilidadempleadoObject;
	}
		
	public void setUtilidadEmpleadoObject(Object newUtilidadEmpleadoObject) {
		this.utilidadempleadoObject = newUtilidadEmpleadoObject;
	}
	
	public List<Object> getUtilidadEmpleadosObject() {		
		this.utilidadempleadosObject=this.utilidadempleadoDataAccess.getEntitiesObject();
		return this.utilidadempleadosObject;
	}
		
	public void setUtilidadEmpleadosObject(List<Object> newUtilidadEmpleadosObject) {
		this.utilidadempleadosObject = newUtilidadEmpleadosObject;
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
		
		if(this.utilidadempleadoDataAccess!=null) {
			this.utilidadempleadoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadEmpleado.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			utilidadempleadoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			utilidadempleadoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		utilidadempleado = new  UtilidadEmpleado();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			utilidadempleado=utilidadempleadoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.utilidadempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				UtilidadEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadEmpleado(this.utilidadempleado);
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
		utilidadempleado = new  UtilidadEmpleado();
		  		  
        try {
			
			utilidadempleado=utilidadempleadoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.utilidadempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				UtilidadEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadEmpleado(this.utilidadempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		utilidadempleado = new  UtilidadEmpleado();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			utilidadempleado=utilidadempleadoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.utilidadempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				UtilidadEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadEmpleado(this.utilidadempleado);
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
		utilidadempleado = new  UtilidadEmpleado();
		  		  
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
		utilidadempleado = new  UtilidadEmpleado();
		  		  
        try {
			
			utilidadempleado=utilidadempleadoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.utilidadempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				UtilidadEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadEmpleado(this.utilidadempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		utilidadempleado = new  UtilidadEmpleado();
		  		  
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
		utilidadempleado = new  UtilidadEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadEmpleado.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =utilidadempleadoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		utilidadempleado = new  UtilidadEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=utilidadempleadoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		utilidadempleado = new  UtilidadEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadEmpleado.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =utilidadempleadoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		utilidadempleado = new  UtilidadEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=utilidadempleadoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		utilidadempleado = new  UtilidadEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadEmpleado.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =utilidadempleadoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		utilidadempleado = new  UtilidadEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=utilidadempleadoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		utilidadempleados = new  ArrayList<UtilidadEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			UtilidadEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			utilidadempleados=utilidadempleadoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUtilidadEmpleado(utilidadempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UtilidadEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadEmpleado(this.utilidadempleados);
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
		utilidadempleados = new  ArrayList<UtilidadEmpleado>();
		  		  
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
		utilidadempleados = new  ArrayList<UtilidadEmpleado>();
		  		  
        try {			
			UtilidadEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			utilidadempleados=utilidadempleadoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarUtilidadEmpleado(utilidadempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UtilidadEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadEmpleado(this.utilidadempleados);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		utilidadempleados = new  ArrayList<UtilidadEmpleado>();
		  		  
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
		utilidadempleados = new  ArrayList<UtilidadEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			UtilidadEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			utilidadempleados=utilidadempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUtilidadEmpleado(utilidadempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UtilidadEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadEmpleado(this.utilidadempleados);
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
		utilidadempleados = new  ArrayList<UtilidadEmpleado>();
		  		  
        try {
			UtilidadEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			utilidadempleados=utilidadempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUtilidadEmpleado(utilidadempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UtilidadEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadEmpleado(this.utilidadempleados);
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
		utilidadempleados = new  ArrayList<UtilidadEmpleado>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UtilidadEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			utilidadempleados=utilidadempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarUtilidadEmpleado(utilidadempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UtilidadEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadEmpleado(this.utilidadempleados);
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
		utilidadempleados = new  ArrayList<UtilidadEmpleado>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UtilidadEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			utilidadempleados=utilidadempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarUtilidadEmpleado(utilidadempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UtilidadEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadEmpleado(this.utilidadempleados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		utilidadempleado = new  UtilidadEmpleado();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UtilidadEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			utilidadempleado=utilidadempleadoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarUtilidadEmpleado(utilidadempleado);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UtilidadEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadEmpleado(this.utilidadempleado);
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
		utilidadempleado = new  UtilidadEmpleado();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UtilidadEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			utilidadempleado=utilidadempleadoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarUtilidadEmpleado(utilidadempleado);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UtilidadEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadEmpleado(this.utilidadempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		utilidadempleados = new  ArrayList<UtilidadEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadEmpleado.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			UtilidadEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			utilidadempleados=utilidadempleadoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUtilidadEmpleado(utilidadempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UtilidadEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadEmpleado(this.utilidadempleados);
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
		utilidadempleados = new  ArrayList<UtilidadEmpleado>();
		  		  
        try {
			UtilidadEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			utilidadempleados=utilidadempleadoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarUtilidadEmpleado(utilidadempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UtilidadEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadEmpleado(this.utilidadempleados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosUtilidadEmpleadosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		utilidadempleados = new  ArrayList<UtilidadEmpleado>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadEmpleado.class.getSimpleName()+"-getTodosUtilidadEmpleadosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UtilidadEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			utilidadempleados=utilidadempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarUtilidadEmpleado(utilidadempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UtilidadEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadEmpleado(this.utilidadempleados);
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
	
	public  void  getTodosUtilidadEmpleados(String sFinalQuery,Pagination pagination)throws Exception {
		utilidadempleados = new  ArrayList<UtilidadEmpleado>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			UtilidadEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			utilidadempleados=utilidadempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarUtilidadEmpleado(utilidadempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				UtilidadEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadEmpleado(this.utilidadempleados);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarUtilidadEmpleado(UtilidadEmpleado utilidadempleado) throws Exception {
		Boolean estaValidado=false;
		
		if(utilidadempleado.getIsNew() || utilidadempleado.getIsChanged()) { 
			this.invalidValues = utilidadempleadoValidator.getInvalidValues(utilidadempleado);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(utilidadempleado);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarUtilidadEmpleado(List<UtilidadEmpleado> UtilidadEmpleados) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(UtilidadEmpleado utilidadempleadoLocal:utilidadempleados) {				
			estaValidadoObjeto=this.validarGuardarUtilidadEmpleado(utilidadempleadoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarUtilidadEmpleado(List<UtilidadEmpleado> UtilidadEmpleados) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarUtilidadEmpleado(utilidadempleados)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarUtilidadEmpleado(UtilidadEmpleado UtilidadEmpleado) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarUtilidadEmpleado(utilidadempleado)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(UtilidadEmpleado utilidadempleado) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+utilidadempleado.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=UtilidadEmpleadoConstantesFunciones.getUtilidadEmpleadoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"utilidadempleado","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(UtilidadEmpleadoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(UtilidadEmpleadoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveUtilidadEmpleadoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadEmpleado.class.getSimpleName()+"-saveUtilidadEmpleadoWithConnection");connexion.begin();			
			
			UtilidadEmpleadoLogicAdditional.checkUtilidadEmpleadoToSave(this.utilidadempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			UtilidadEmpleadoLogicAdditional.updateUtilidadEmpleadoToSave(this.utilidadempleado,this.arrDatoGeneral);
			
			UtilidadEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.utilidadempleado,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowUtilidadEmpleado();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarUtilidadEmpleado(this.utilidadempleado)) {
				UtilidadEmpleadoDataAccess.save(this.utilidadempleado, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.utilidadempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			UtilidadEmpleadoLogicAdditional.checkUtilidadEmpleadoToSaveAfter(this.utilidadempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowUtilidadEmpleado();
			
			connexion.commit();			
			
			if(this.utilidadempleado.getIsDeleted()) {
				this.utilidadempleado=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveUtilidadEmpleado()throws Exception {	
		try {	
			
			UtilidadEmpleadoLogicAdditional.checkUtilidadEmpleadoToSave(this.utilidadempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			UtilidadEmpleadoLogicAdditional.updateUtilidadEmpleadoToSave(this.utilidadempleado,this.arrDatoGeneral);
			
			UtilidadEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.utilidadempleado,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarUtilidadEmpleado(this.utilidadempleado)) {			
				UtilidadEmpleadoDataAccess.save(this.utilidadempleado, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.utilidadempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			UtilidadEmpleadoLogicAdditional.checkUtilidadEmpleadoToSaveAfter(this.utilidadempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.utilidadempleado.getIsDeleted()) {
				this.utilidadempleado=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveUtilidadEmpleadosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadEmpleado.class.getSimpleName()+"-saveUtilidadEmpleadosWithConnection");connexion.begin();			
			
			UtilidadEmpleadoLogicAdditional.checkUtilidadEmpleadoToSaves(utilidadempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowUtilidadEmpleados();
			
			Boolean validadoTodosUtilidadEmpleado=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(UtilidadEmpleado utilidadempleadoLocal:utilidadempleados) {		
				if(utilidadempleadoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				UtilidadEmpleadoLogicAdditional.updateUtilidadEmpleadoToSave(utilidadempleadoLocal,this.arrDatoGeneral);
	        	
				UtilidadEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),utilidadempleadoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarUtilidadEmpleado(utilidadempleadoLocal)) {
					UtilidadEmpleadoDataAccess.save(utilidadempleadoLocal, connexion);				
				} else {
					validadoTodosUtilidadEmpleado=false;
				}
			}
			
			if(!validadoTodosUtilidadEmpleado) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			UtilidadEmpleadoLogicAdditional.checkUtilidadEmpleadoToSavesAfter(utilidadempleados,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowUtilidadEmpleados();
			
			connexion.commit();		
			
			this.quitarUtilidadEmpleadosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveUtilidadEmpleados()throws Exception {				
		 try {	
			UtilidadEmpleadoLogicAdditional.checkUtilidadEmpleadoToSaves(utilidadempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosUtilidadEmpleado=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(UtilidadEmpleado utilidadempleadoLocal:utilidadempleados) {				
				if(utilidadempleadoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				UtilidadEmpleadoLogicAdditional.updateUtilidadEmpleadoToSave(utilidadempleadoLocal,this.arrDatoGeneral);
	        	
				UtilidadEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),utilidadempleadoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarUtilidadEmpleado(utilidadempleadoLocal)) {				
					UtilidadEmpleadoDataAccess.save(utilidadempleadoLocal, connexion);				
				} else {
					validadoTodosUtilidadEmpleado=false;
				}
			}
			
			if(!validadoTodosUtilidadEmpleado) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			UtilidadEmpleadoLogicAdditional.checkUtilidadEmpleadoToSavesAfter(utilidadempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarUtilidadEmpleadosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public UtilidadEmpleadoParameterReturnGeneral procesarAccionUtilidadEmpleados(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<UtilidadEmpleado> utilidadempleados,UtilidadEmpleadoParameterReturnGeneral utilidadempleadoParameterGeneral)throws Exception {
		 try {	
			UtilidadEmpleadoParameterReturnGeneral utilidadempleadoReturnGeneral=new UtilidadEmpleadoParameterReturnGeneral();
	
			UtilidadEmpleadoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,utilidadempleados,utilidadempleadoParameterGeneral,utilidadempleadoReturnGeneral);
			
			return utilidadempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public UtilidadEmpleadoParameterReturnGeneral procesarAccionUtilidadEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<UtilidadEmpleado> utilidadempleados,UtilidadEmpleadoParameterReturnGeneral utilidadempleadoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadEmpleado.class.getSimpleName()+"-procesarAccionUtilidadEmpleadosWithConnection");connexion.begin();			
			
			UtilidadEmpleadoParameterReturnGeneral utilidadempleadoReturnGeneral=new UtilidadEmpleadoParameterReturnGeneral();
	
			UtilidadEmpleadoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,utilidadempleados,utilidadempleadoParameterGeneral,utilidadempleadoReturnGeneral);
			
			this.connexion.commit();
			
			return utilidadempleadoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public UtilidadEmpleadoParameterReturnGeneral procesarEventosUtilidadEmpleados(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<UtilidadEmpleado> utilidadempleados,UtilidadEmpleado utilidadempleado,UtilidadEmpleadoParameterReturnGeneral utilidadempleadoParameterGeneral,Boolean isEsNuevoUtilidadEmpleado,ArrayList<Classe> clases)throws Exception {
		 try {	
			UtilidadEmpleadoParameterReturnGeneral utilidadempleadoReturnGeneral=new UtilidadEmpleadoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				utilidadempleadoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			UtilidadEmpleadoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,utilidadempleados,utilidadempleado,utilidadempleadoParameterGeneral,utilidadempleadoReturnGeneral,isEsNuevoUtilidadEmpleado,clases);
			
			return utilidadempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public UtilidadEmpleadoParameterReturnGeneral procesarEventosUtilidadEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<UtilidadEmpleado> utilidadempleados,UtilidadEmpleado utilidadempleado,UtilidadEmpleadoParameterReturnGeneral utilidadempleadoParameterGeneral,Boolean isEsNuevoUtilidadEmpleado,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadEmpleado.class.getSimpleName()+"-procesarEventosUtilidadEmpleadosWithConnection");connexion.begin();			
			
			UtilidadEmpleadoParameterReturnGeneral utilidadempleadoReturnGeneral=new UtilidadEmpleadoParameterReturnGeneral();
	
			utilidadempleadoReturnGeneral.setUtilidadEmpleado(utilidadempleado);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				utilidadempleadoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			UtilidadEmpleadoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,utilidadempleados,utilidadempleado,utilidadempleadoParameterGeneral,utilidadempleadoReturnGeneral,isEsNuevoUtilidadEmpleado,clases);
			
			this.connexion.commit();
			
			return utilidadempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public UtilidadEmpleadoParameterReturnGeneral procesarImportacionUtilidadEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,UtilidadEmpleadoParameterReturnGeneral utilidadempleadoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadEmpleado.class.getSimpleName()+"-procesarImportacionUtilidadEmpleadosWithConnection");connexion.begin();			
			
			UtilidadEmpleadoParameterReturnGeneral utilidadempleadoReturnGeneral=new UtilidadEmpleadoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.utilidadempleados=new ArrayList<UtilidadEmpleado>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.utilidadempleado=new UtilidadEmpleado();
				
				
				if(conColumnasBase) {this.utilidadempleado.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.utilidadempleado.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.utilidadempleado.setfecha_ingreso(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.utilidadempleado.setfecha_salida(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.utilidadempleado.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				this.utilidadempleado.setnumero_dias(Integer.parseInt(arrColumnas[iColumn++]));
				this.utilidadempleado.setnumero_cargas(Integer.parseInt(arrColumnas[iColumn++]));
				this.utilidadempleado.setnumero_factor10(Double.parseDouble(arrColumnas[iColumn++]));
				this.utilidadempleado.setvalor_factor10(Double.parseDouble(arrColumnas[iColumn++]));
				this.utilidadempleado.setutilidad_factor10(Double.parseDouble(arrColumnas[iColumn++]));
				this.utilidadempleado.setnumero_factor5(Double.parseDouble(arrColumnas[iColumn++]));
				this.utilidadempleado.setvalor_factor5(Double.parseDouble(arrColumnas[iColumn++]));
				this.utilidadempleado.setutilidad_factor5(Double.parseDouble(arrColumnas[iColumn++]));
				this.utilidadempleado.settotal(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.utilidadempleados.add(this.utilidadempleado);
			}
			
			this.saveUtilidadEmpleados();
			
			this.connexion.commit();
			
			utilidadempleadoReturnGeneral.setConRetornoEstaProcesado(true);
			utilidadempleadoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return utilidadempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarUtilidadEmpleadosEliminados() throws Exception {				
		
		List<UtilidadEmpleado> utilidadempleadosAux= new ArrayList<UtilidadEmpleado>();
		
		for(UtilidadEmpleado utilidadempleado:utilidadempleados) {
			if(!utilidadempleado.getIsDeleted()) {
				utilidadempleadosAux.add(utilidadempleado);
			}
		}
		
		utilidadempleados=utilidadempleadosAux;
	}
	
	public void quitarUtilidadEmpleadosNulos() throws Exception {				
		
		List<UtilidadEmpleado> utilidadempleadosAux= new ArrayList<UtilidadEmpleado>();
		
		for(UtilidadEmpleado utilidadempleado : this.utilidadempleados) {
			if(utilidadempleado==null) {
				utilidadempleadosAux.add(utilidadempleado);
			}
		}
		
		//this.utilidadempleados=utilidadempleadosAux;
		
		this.utilidadempleados.removeAll(utilidadempleadosAux);
	}
	
	public void getSetVersionRowUtilidadEmpleadoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(utilidadempleado.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((utilidadempleado.getIsDeleted() || (utilidadempleado.getIsChanged()&&!utilidadempleado.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=utilidadempleadoDataAccess.getSetVersionRowUtilidadEmpleado(connexion,utilidadempleado.getId());
				
				if(!utilidadempleado.getVersionRow().equals(timestamp)) {	
					utilidadempleado.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				utilidadempleado.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowUtilidadEmpleado()throws Exception {	
		
		if(utilidadempleado.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((utilidadempleado.getIsDeleted() || (utilidadempleado.getIsChanged()&&!utilidadempleado.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=utilidadempleadoDataAccess.getSetVersionRowUtilidadEmpleado(connexion,utilidadempleado.getId());
			
			try {							
				if(!utilidadempleado.getVersionRow().equals(timestamp)) {	
					utilidadempleado.setVersionRow(timestamp);
				}
				
				utilidadempleado.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowUtilidadEmpleadosWithConnection()throws Exception {	
		if(utilidadempleados!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(UtilidadEmpleado utilidadempleadoAux:utilidadempleados) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(utilidadempleadoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(utilidadempleadoAux.getIsDeleted() || (utilidadempleadoAux.getIsChanged()&&!utilidadempleadoAux.getIsNew())) {
						
						timestamp=utilidadempleadoDataAccess.getSetVersionRowUtilidadEmpleado(connexion,utilidadempleadoAux.getId());
						
						if(!utilidadempleado.getVersionRow().equals(timestamp)) {	
							utilidadempleadoAux.setVersionRow(timestamp);
						}
								
						utilidadempleadoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowUtilidadEmpleados()throws Exception {	
		if(utilidadempleados!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(UtilidadEmpleado utilidadempleadoAux:utilidadempleados) {
					if(utilidadempleadoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(utilidadempleadoAux.getIsDeleted() || (utilidadempleadoAux.getIsChanged()&&!utilidadempleadoAux.getIsNew())) {
						
						timestamp=utilidadempleadoDataAccess.getSetVersionRowUtilidadEmpleado(connexion,utilidadempleadoAux.getId());
						
						if(!utilidadempleadoAux.getVersionRow().equals(timestamp)) {	
							utilidadempleadoAux.setVersionRow(timestamp);
						}
						
													
						utilidadempleadoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public UtilidadEmpleadoParameterReturnGeneral cargarCombosLoteForeignKeyUtilidadEmpleadoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalAnio) throws Exception {
		UtilidadEmpleadoParameterReturnGeneral  utilidadempleadoReturnGeneral =new UtilidadEmpleadoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadEmpleado.class.getSimpleName()+"-cargarCombosLoteForeignKeyUtilidadEmpleadoWithConnection");connexion.begin();
			
			utilidadempleadoReturnGeneral =new UtilidadEmpleadoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			utilidadempleadoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			utilidadempleadoReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			utilidadempleadoReturnGeneral.setaniosForeignKey(aniosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return utilidadempleadoReturnGeneral;
	}
	
	public UtilidadEmpleadoParameterReturnGeneral cargarCombosLoteForeignKeyUtilidadEmpleado(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalAnio) throws Exception {
		UtilidadEmpleadoParameterReturnGeneral  utilidadempleadoReturnGeneral =new UtilidadEmpleadoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			utilidadempleadoReturnGeneral =new UtilidadEmpleadoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			utilidadempleadoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			utilidadempleadoReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			utilidadempleadoReturnGeneral.setaniosForeignKey(aniosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return utilidadempleadoReturnGeneral;
	}
	
	
	public void deepLoad(UtilidadEmpleado utilidadempleado,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			UtilidadEmpleadoLogicAdditional.updateUtilidadEmpleadoToGet(utilidadempleado,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		utilidadempleado.setEmpresa(utilidadempleadoDataAccess.getEmpresa(connexion,utilidadempleado));
		utilidadempleado.setEmpleado(utilidadempleadoDataAccess.getEmpleado(connexion,utilidadempleado));
		utilidadempleado.setAnio(utilidadempleadoDataAccess.getAnio(connexion,utilidadempleado));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				utilidadempleado.setEmpresa(utilidadempleadoDataAccess.getEmpresa(connexion,utilidadempleado));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				utilidadempleado.setEmpleado(utilidadempleadoDataAccess.getEmpleado(connexion,utilidadempleado));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				utilidadempleado.setAnio(utilidadempleadoDataAccess.getAnio(connexion,utilidadempleado));
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
			utilidadempleado.setEmpresa(utilidadempleadoDataAccess.getEmpresa(connexion,utilidadempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			utilidadempleado.setEmpleado(utilidadempleadoDataAccess.getEmpleado(connexion,utilidadempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			utilidadempleado.setAnio(utilidadempleadoDataAccess.getAnio(connexion,utilidadempleado));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		utilidadempleado.setEmpresa(utilidadempleadoDataAccess.getEmpresa(connexion,utilidadempleado));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(utilidadempleado.getEmpresa(),isDeep,deepLoadType,clases);
				
		utilidadempleado.setEmpleado(utilidadempleadoDataAccess.getEmpleado(connexion,utilidadempleado));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(utilidadempleado.getEmpleado(),isDeep,deepLoadType,clases);
				
		utilidadempleado.setAnio(utilidadempleadoDataAccess.getAnio(connexion,utilidadempleado));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(utilidadempleado.getAnio(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				utilidadempleado.setEmpresa(utilidadempleadoDataAccess.getEmpresa(connexion,utilidadempleado));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(utilidadempleado.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				utilidadempleado.setEmpleado(utilidadempleadoDataAccess.getEmpleado(connexion,utilidadempleado));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(utilidadempleado.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				utilidadempleado.setAnio(utilidadempleadoDataAccess.getAnio(connexion,utilidadempleado));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(utilidadempleado.getAnio(),isDeep,deepLoadType,clases);				
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
			utilidadempleado.setEmpresa(utilidadempleadoDataAccess.getEmpresa(connexion,utilidadempleado));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(utilidadempleado.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			utilidadempleado.setEmpleado(utilidadempleadoDataAccess.getEmpleado(connexion,utilidadempleado));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(utilidadempleado.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			utilidadempleado.setAnio(utilidadempleadoDataAccess.getAnio(connexion,utilidadempleado));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(utilidadempleado.getAnio(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(UtilidadEmpleado utilidadempleado,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			UtilidadEmpleadoLogicAdditional.updateUtilidadEmpleadoToSave(utilidadempleado,this.arrDatoGeneral);
			
UtilidadEmpleadoDataAccess.save(utilidadempleado, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(utilidadempleado.getEmpresa(),connexion);

		EmpleadoDataAccess.save(utilidadempleado.getEmpleado(),connexion);

		AnioDataAccess.save(utilidadempleado.getAnio(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(utilidadempleado.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(utilidadempleado.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(utilidadempleado.getAnio(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(utilidadempleado.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(utilidadempleado.getEmpresa(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(utilidadempleado.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(utilidadempleado.getEmpleado(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(utilidadempleado.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(utilidadempleado.getAnio(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(utilidadempleado.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(utilidadempleado.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(utilidadempleado.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(utilidadempleado.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(utilidadempleado.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(utilidadempleado.getAnio(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(UtilidadEmpleado.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(utilidadempleado,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				UtilidadEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadEmpleado(utilidadempleado);
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
			this.deepLoad(this.utilidadempleado,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				UtilidadEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadEmpleado(this.utilidadempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(UtilidadEmpleado.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(utilidadempleados!=null) {
				for(UtilidadEmpleado utilidadempleado:utilidadempleados) {
					this.deepLoad(utilidadempleado,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					UtilidadEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadEmpleado(utilidadempleados);
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
			if(utilidadempleados!=null) {
				for(UtilidadEmpleado utilidadempleado:utilidadempleados) {
					this.deepLoad(utilidadempleado,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					UtilidadEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadEmpleado(utilidadempleados);
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
			this.getNewConnexionToDeep(UtilidadEmpleado.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(utilidadempleado,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(UtilidadEmpleado.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(utilidadempleados!=null) {
				for(UtilidadEmpleado utilidadempleado:utilidadempleados) {
					this.deepSave(utilidadempleado,isDeep,deepLoadType,clases);
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
			if(utilidadempleados!=null) {
				for(UtilidadEmpleado utilidadempleado:utilidadempleados) {
					this.deepSave(utilidadempleado,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getUtilidadEmpleadosFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,UtilidadEmpleadoConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			UtilidadEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			utilidadempleados=utilidadempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UtilidadEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadEmpleado(this.utilidadempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getUtilidadEmpleadosFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,UtilidadEmpleadoConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			UtilidadEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			utilidadempleados=utilidadempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UtilidadEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadEmpleado(this.utilidadempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getUtilidadEmpleadosFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,UtilidadEmpleadoConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			UtilidadEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			utilidadempleados=utilidadempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UtilidadEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadEmpleado(this.utilidadempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getUtilidadEmpleadosFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,UtilidadEmpleadoConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			UtilidadEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			utilidadempleados=utilidadempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UtilidadEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadEmpleado(this.utilidadempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getUtilidadEmpleadosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,UtilidadEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,UtilidadEmpleadoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			UtilidadEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			utilidadempleados=utilidadempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UtilidadEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadEmpleado(this.utilidadempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getUtilidadEmpleadosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,UtilidadEmpleadoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			UtilidadEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			utilidadempleados=utilidadempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				UtilidadEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesUtilidadEmpleado(this.utilidadempleados);
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
			if(UtilidadEmpleadoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,UtilidadEmpleadoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,UtilidadEmpleado utilidadempleado,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(UtilidadEmpleadoConstantesFunciones.ISCONAUDITORIA) {
				if(utilidadempleado.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,UtilidadEmpleadoDataAccess.TABLENAME, utilidadempleado.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(UtilidadEmpleadoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////UtilidadEmpleadoLogic.registrarAuditoriaDetallesUtilidadEmpleado(connexion,utilidadempleado,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(utilidadempleado.getIsDeleted()) {
					/*if(!utilidadempleado.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,UtilidadEmpleadoDataAccess.TABLENAME, utilidadempleado.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////UtilidadEmpleadoLogic.registrarAuditoriaDetallesUtilidadEmpleado(connexion,utilidadempleado,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,UtilidadEmpleadoDataAccess.TABLENAME, utilidadempleado.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(utilidadempleado.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,UtilidadEmpleadoDataAccess.TABLENAME, utilidadempleado.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(UtilidadEmpleadoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////UtilidadEmpleadoLogic.registrarAuditoriaDetallesUtilidadEmpleado(connexion,utilidadempleado,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesUtilidadEmpleado(Connexion connexion,UtilidadEmpleado utilidadempleado)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(utilidadempleado.getIsNew()||!utilidadempleado.getid_empresa().equals(utilidadempleado.getUtilidadEmpleadoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(utilidadempleado.getUtilidadEmpleadoOriginal().getid_empresa()!=null)
				{
					strValorActual=utilidadempleado.getUtilidadEmpleadoOriginal().getid_empresa().toString();
				}
				if(utilidadempleado.getid_empresa()!=null)
				{
					strValorNuevo=utilidadempleado.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UtilidadEmpleadoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(utilidadempleado.getIsNew()||!utilidadempleado.getid_empleado().equals(utilidadempleado.getUtilidadEmpleadoOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(utilidadempleado.getUtilidadEmpleadoOriginal().getid_empleado()!=null)
				{
					strValorActual=utilidadempleado.getUtilidadEmpleadoOriginal().getid_empleado().toString();
				}
				if(utilidadempleado.getid_empleado()!=null)
				{
					strValorNuevo=utilidadempleado.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UtilidadEmpleadoConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(utilidadempleado.getIsNew()||!utilidadempleado.getid_anio().equals(utilidadempleado.getUtilidadEmpleadoOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(utilidadempleado.getUtilidadEmpleadoOriginal().getid_anio()!=null)
				{
					strValorActual=utilidadempleado.getUtilidadEmpleadoOriginal().getid_anio().toString();
				}
				if(utilidadempleado.getid_anio()!=null)
				{
					strValorNuevo=utilidadempleado.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UtilidadEmpleadoConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(utilidadempleado.getIsNew()||!utilidadempleado.getfecha_ingreso().equals(utilidadempleado.getUtilidadEmpleadoOriginal().getfecha_ingreso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(utilidadempleado.getUtilidadEmpleadoOriginal().getfecha_ingreso()!=null)
				{
					strValorActual=utilidadempleado.getUtilidadEmpleadoOriginal().getfecha_ingreso().toString();
				}
				if(utilidadempleado.getfecha_ingreso()!=null)
				{
					strValorNuevo=utilidadempleado.getfecha_ingreso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UtilidadEmpleadoConstantesFunciones.FECHAINGRESO,strValorActual,strValorNuevo);
			}	
			
			if(utilidadempleado.getIsNew()||!utilidadempleado.getfecha_salida().equals(utilidadempleado.getUtilidadEmpleadoOriginal().getfecha_salida()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(utilidadempleado.getUtilidadEmpleadoOriginal().getfecha_salida()!=null)
				{
					strValorActual=utilidadempleado.getUtilidadEmpleadoOriginal().getfecha_salida().toString();
				}
				if(utilidadempleado.getfecha_salida()!=null)
				{
					strValorNuevo=utilidadempleado.getfecha_salida().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UtilidadEmpleadoConstantesFunciones.FECHASALIDA,strValorActual,strValorNuevo);
			}	
			
			if(utilidadempleado.getIsNew()||!utilidadempleado.getvalor().equals(utilidadempleado.getUtilidadEmpleadoOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(utilidadempleado.getUtilidadEmpleadoOriginal().getvalor()!=null)
				{
					strValorActual=utilidadempleado.getUtilidadEmpleadoOriginal().getvalor().toString();
				}
				if(utilidadempleado.getvalor()!=null)
				{
					strValorNuevo=utilidadempleado.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UtilidadEmpleadoConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
			
			if(utilidadempleado.getIsNew()||!utilidadempleado.getnumero_dias().equals(utilidadempleado.getUtilidadEmpleadoOriginal().getnumero_dias()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(utilidadempleado.getUtilidadEmpleadoOriginal().getnumero_dias()!=null)
				{
					strValorActual=utilidadempleado.getUtilidadEmpleadoOriginal().getnumero_dias().toString();
				}
				if(utilidadempleado.getnumero_dias()!=null)
				{
					strValorNuevo=utilidadempleado.getnumero_dias().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UtilidadEmpleadoConstantesFunciones.NUMERODIAS,strValorActual,strValorNuevo);
			}	
			
			if(utilidadempleado.getIsNew()||!utilidadempleado.getnumero_cargas().equals(utilidadempleado.getUtilidadEmpleadoOriginal().getnumero_cargas()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(utilidadempleado.getUtilidadEmpleadoOriginal().getnumero_cargas()!=null)
				{
					strValorActual=utilidadempleado.getUtilidadEmpleadoOriginal().getnumero_cargas().toString();
				}
				if(utilidadempleado.getnumero_cargas()!=null)
				{
					strValorNuevo=utilidadempleado.getnumero_cargas().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UtilidadEmpleadoConstantesFunciones.NUMEROCARGAS,strValorActual,strValorNuevo);
			}	
			
			if(utilidadempleado.getIsNew()||!utilidadempleado.getnumero_factor10().equals(utilidadempleado.getUtilidadEmpleadoOriginal().getnumero_factor10()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(utilidadempleado.getUtilidadEmpleadoOriginal().getnumero_factor10()!=null)
				{
					strValorActual=utilidadempleado.getUtilidadEmpleadoOriginal().getnumero_factor10().toString();
				}
				if(utilidadempleado.getnumero_factor10()!=null)
				{
					strValorNuevo=utilidadempleado.getnumero_factor10().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UtilidadEmpleadoConstantesFunciones.NUMEROFACTOR10,strValorActual,strValorNuevo);
			}	
			
			if(utilidadempleado.getIsNew()||!utilidadempleado.getvalor_factor10().equals(utilidadempleado.getUtilidadEmpleadoOriginal().getvalor_factor10()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(utilidadempleado.getUtilidadEmpleadoOriginal().getvalor_factor10()!=null)
				{
					strValorActual=utilidadempleado.getUtilidadEmpleadoOriginal().getvalor_factor10().toString();
				}
				if(utilidadempleado.getvalor_factor10()!=null)
				{
					strValorNuevo=utilidadempleado.getvalor_factor10().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UtilidadEmpleadoConstantesFunciones.VALORFACTOR10,strValorActual,strValorNuevo);
			}	
			
			if(utilidadempleado.getIsNew()||!utilidadempleado.getutilidad_factor10().equals(utilidadempleado.getUtilidadEmpleadoOriginal().getutilidad_factor10()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(utilidadempleado.getUtilidadEmpleadoOriginal().getutilidad_factor10()!=null)
				{
					strValorActual=utilidadempleado.getUtilidadEmpleadoOriginal().getutilidad_factor10().toString();
				}
				if(utilidadempleado.getutilidad_factor10()!=null)
				{
					strValorNuevo=utilidadempleado.getutilidad_factor10().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UtilidadEmpleadoConstantesFunciones.UTILIDADFACTOR10,strValorActual,strValorNuevo);
			}	
			
			if(utilidadempleado.getIsNew()||!utilidadempleado.getnumero_factor5().equals(utilidadempleado.getUtilidadEmpleadoOriginal().getnumero_factor5()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(utilidadempleado.getUtilidadEmpleadoOriginal().getnumero_factor5()!=null)
				{
					strValorActual=utilidadempleado.getUtilidadEmpleadoOriginal().getnumero_factor5().toString();
				}
				if(utilidadempleado.getnumero_factor5()!=null)
				{
					strValorNuevo=utilidadempleado.getnumero_factor5().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UtilidadEmpleadoConstantesFunciones.NUMEROFACTOR5,strValorActual,strValorNuevo);
			}	
			
			if(utilidadempleado.getIsNew()||!utilidadempleado.getvalor_factor5().equals(utilidadempleado.getUtilidadEmpleadoOriginal().getvalor_factor5()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(utilidadempleado.getUtilidadEmpleadoOriginal().getvalor_factor5()!=null)
				{
					strValorActual=utilidadempleado.getUtilidadEmpleadoOriginal().getvalor_factor5().toString();
				}
				if(utilidadempleado.getvalor_factor5()!=null)
				{
					strValorNuevo=utilidadempleado.getvalor_factor5().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UtilidadEmpleadoConstantesFunciones.VALORFACTOR5,strValorActual,strValorNuevo);
			}	
			
			if(utilidadempleado.getIsNew()||!utilidadempleado.getutilidad_factor5().equals(utilidadempleado.getUtilidadEmpleadoOriginal().getutilidad_factor5()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(utilidadempleado.getUtilidadEmpleadoOriginal().getutilidad_factor5()!=null)
				{
					strValorActual=utilidadempleado.getUtilidadEmpleadoOriginal().getutilidad_factor5().toString();
				}
				if(utilidadempleado.getutilidad_factor5()!=null)
				{
					strValorNuevo=utilidadempleado.getutilidad_factor5().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UtilidadEmpleadoConstantesFunciones.UTILIDADFACTOR5,strValorActual,strValorNuevo);
			}	
			
			if(utilidadempleado.getIsNew()||!utilidadempleado.gettotal().equals(utilidadempleado.getUtilidadEmpleadoOriginal().gettotal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(utilidadempleado.getUtilidadEmpleadoOriginal().gettotal()!=null)
				{
					strValorActual=utilidadempleado.getUtilidadEmpleadoOriginal().gettotal().toString();
				}
				if(utilidadempleado.gettotal()!=null)
				{
					strValorNuevo=utilidadempleado.gettotal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),UtilidadEmpleadoConstantesFunciones.TOTAL,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveUtilidadEmpleadoRelacionesWithConnection(UtilidadEmpleado utilidadempleado) throws Exception {

		if(!utilidadempleado.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveUtilidadEmpleadoRelacionesBase(utilidadempleado,true);
		}
	}

	public void saveUtilidadEmpleadoRelaciones(UtilidadEmpleado utilidadempleado)throws Exception {

		if(!utilidadempleado.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveUtilidadEmpleadoRelacionesBase(utilidadempleado,false);
		}
	}

	public void saveUtilidadEmpleadoRelacionesBase(UtilidadEmpleado utilidadempleado,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("UtilidadEmpleado-saveRelacionesWithConnection");}
	

			this.setUtilidadEmpleado(utilidadempleado);

			if(UtilidadEmpleadoLogicAdditional.validarSaveRelaciones(utilidadempleado,this)) {

				UtilidadEmpleadoLogicAdditional.updateRelacionesToSave(utilidadempleado,this);

				if((utilidadempleado.getIsNew()||utilidadempleado.getIsChanged())&&!utilidadempleado.getIsDeleted()) {
					this.saveUtilidadEmpleado();
					this.saveUtilidadEmpleadoRelacionesDetalles();

				} else if(utilidadempleado.getIsDeleted()) {
					this.saveUtilidadEmpleadoRelacionesDetalles();
					this.saveUtilidadEmpleado();
				}

				UtilidadEmpleadoLogicAdditional.updateRelacionesToSaveAfter(utilidadempleado,this);

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
	
	
	private void saveUtilidadEmpleadoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfUtilidadEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=UtilidadEmpleadoConstantesFunciones.getClassesForeignKeysOfUtilidadEmpleado(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfUtilidadEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=UtilidadEmpleadoConstantesFunciones.getClassesRelationshipsOfUtilidadEmpleado(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

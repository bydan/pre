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
import com.bydan.erp.nomina.util.VacacionEmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.VacacionEmpleadoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.VacacionEmpleadoParameterGeneral;
import com.bydan.erp.nomina.business.entity.VacacionEmpleado;
import com.bydan.erp.nomina.business.logic.VacacionEmpleadoLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class VacacionEmpleadoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(VacacionEmpleadoLogic.class);
	
	protected VacacionEmpleadoDataAccess vacacionempleadoDataAccess; 	
	protected VacacionEmpleado vacacionempleado;
	protected List<VacacionEmpleado> vacacionempleados;
	protected Object vacacionempleadoObject;	
	protected List<Object> vacacionempleadosObject;
	
	public static ClassValidator<VacacionEmpleado> vacacionempleadoValidator = new ClassValidator<VacacionEmpleado>(VacacionEmpleado.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected VacacionEmpleadoLogicAdditional vacacionempleadoLogicAdditional=null;
	
	public VacacionEmpleadoLogicAdditional getVacacionEmpleadoLogicAdditional() {
		return this.vacacionempleadoLogicAdditional;
	}
	
	public void setVacacionEmpleadoLogicAdditional(VacacionEmpleadoLogicAdditional vacacionempleadoLogicAdditional) {
		try {
			this.vacacionempleadoLogicAdditional=vacacionempleadoLogicAdditional;
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
	
	
	
	
	public  VacacionEmpleadoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.vacacionempleadoDataAccess = new VacacionEmpleadoDataAccess();
			
			this.vacacionempleados= new ArrayList<VacacionEmpleado>();
			this.vacacionempleado= new VacacionEmpleado();
			
			this.vacacionempleadoObject=new Object();
			this.vacacionempleadosObject=new ArrayList<Object>();
				
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
			
			this.vacacionempleadoDataAccess.setConnexionType(this.connexionType);
			this.vacacionempleadoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  VacacionEmpleadoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.vacacionempleadoDataAccess = new VacacionEmpleadoDataAccess();
			this.vacacionempleados= new ArrayList<VacacionEmpleado>();
			this.vacacionempleado= new VacacionEmpleado();
			this.vacacionempleadoObject=new Object();
			this.vacacionempleadosObject=new ArrayList<Object>();
			
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
			
			this.vacacionempleadoDataAccess.setConnexionType(this.connexionType);
			this.vacacionempleadoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public VacacionEmpleado getVacacionEmpleado() throws Exception {	
		VacacionEmpleadoLogicAdditional.checkVacacionEmpleadoToGet(vacacionempleado,this.datosCliente,this.arrDatoGeneral);
		VacacionEmpleadoLogicAdditional.updateVacacionEmpleadoToGet(vacacionempleado,this.arrDatoGeneral);
		
		return vacacionempleado;
	}
		
	public void setVacacionEmpleado(VacacionEmpleado newVacacionEmpleado) {
		this.vacacionempleado = newVacacionEmpleado;
	}
	
	public VacacionEmpleadoDataAccess getVacacionEmpleadoDataAccess() {
		return vacacionempleadoDataAccess;
	}
	
	public void setVacacionEmpleadoDataAccess(VacacionEmpleadoDataAccess newvacacionempleadoDataAccess) {
		this.vacacionempleadoDataAccess = newvacacionempleadoDataAccess;
	}
	
	public List<VacacionEmpleado> getVacacionEmpleados() throws Exception {		
		this.quitarVacacionEmpleadosNulos();
		
		VacacionEmpleadoLogicAdditional.checkVacacionEmpleadoToGets(vacacionempleados,this.datosCliente,this.arrDatoGeneral);
		
		for (VacacionEmpleado vacacionempleadoLocal: vacacionempleados ) {
			VacacionEmpleadoLogicAdditional.updateVacacionEmpleadoToGet(vacacionempleadoLocal,this.arrDatoGeneral);
		}
		
		return vacacionempleados;
	}
	
	public void setVacacionEmpleados(List<VacacionEmpleado> newVacacionEmpleados) {
		this.vacacionempleados = newVacacionEmpleados;
	}
	
	public Object getVacacionEmpleadoObject() {	
		this.vacacionempleadoObject=this.vacacionempleadoDataAccess.getEntityObject();
		return this.vacacionempleadoObject;
	}
		
	public void setVacacionEmpleadoObject(Object newVacacionEmpleadoObject) {
		this.vacacionempleadoObject = newVacacionEmpleadoObject;
	}
	
	public List<Object> getVacacionEmpleadosObject() {		
		this.vacacionempleadosObject=this.vacacionempleadoDataAccess.getEntitiesObject();
		return this.vacacionempleadosObject;
	}
		
	public void setVacacionEmpleadosObject(List<Object> newVacacionEmpleadosObject) {
		this.vacacionempleadosObject = newVacacionEmpleadosObject;
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
		
		if(this.vacacionempleadoDataAccess!=null) {
			this.vacacionempleadoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VacacionEmpleado.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			vacacionempleadoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			vacacionempleadoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		vacacionempleado = new  VacacionEmpleado();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VacacionEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			vacacionempleado=vacacionempleadoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.vacacionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				VacacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesVacacionEmpleado(this.vacacionempleado);
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
		vacacionempleado = new  VacacionEmpleado();
		  		  
        try {
			
			vacacionempleado=vacacionempleadoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.vacacionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				VacacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesVacacionEmpleado(this.vacacionempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		vacacionempleado = new  VacacionEmpleado();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VacacionEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			vacacionempleado=vacacionempleadoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.vacacionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				VacacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesVacacionEmpleado(this.vacacionempleado);
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
		vacacionempleado = new  VacacionEmpleado();
		  		  
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
		vacacionempleado = new  VacacionEmpleado();
		  		  
        try {
			
			vacacionempleado=vacacionempleadoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.vacacionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				VacacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesVacacionEmpleado(this.vacacionempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		vacacionempleado = new  VacacionEmpleado();
		  		  
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
		vacacionempleado = new  VacacionEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VacacionEmpleado.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =vacacionempleadoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		vacacionempleado = new  VacacionEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=vacacionempleadoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		vacacionempleado = new  VacacionEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VacacionEmpleado.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =vacacionempleadoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		vacacionempleado = new  VacacionEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=vacacionempleadoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		vacacionempleado = new  VacacionEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VacacionEmpleado.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =vacacionempleadoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		vacacionempleado = new  VacacionEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=vacacionempleadoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		vacacionempleados = new  ArrayList<VacacionEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VacacionEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			VacacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vacacionempleados=vacacionempleadoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVacacionEmpleado(vacacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VacacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesVacacionEmpleado(this.vacacionempleados);
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
		vacacionempleados = new  ArrayList<VacacionEmpleado>();
		  		  
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
		vacacionempleados = new  ArrayList<VacacionEmpleado>();
		  		  
        try {			
			VacacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vacacionempleados=vacacionempleadoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarVacacionEmpleado(vacacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VacacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesVacacionEmpleado(this.vacacionempleados);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		vacacionempleados = new  ArrayList<VacacionEmpleado>();
		  		  
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
		vacacionempleados = new  ArrayList<VacacionEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VacacionEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			VacacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vacacionempleados=vacacionempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVacacionEmpleado(vacacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VacacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesVacacionEmpleado(this.vacacionempleados);
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
		vacacionempleados = new  ArrayList<VacacionEmpleado>();
		  		  
        try {
			VacacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vacacionempleados=vacacionempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVacacionEmpleado(vacacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VacacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesVacacionEmpleado(this.vacacionempleados);
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
		vacacionempleados = new  ArrayList<VacacionEmpleado>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VacacionEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VacacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vacacionempleados=vacacionempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarVacacionEmpleado(vacacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VacacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesVacacionEmpleado(this.vacacionempleados);
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
		vacacionempleados = new  ArrayList<VacacionEmpleado>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VacacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vacacionempleados=vacacionempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarVacacionEmpleado(vacacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VacacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesVacacionEmpleado(this.vacacionempleados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		vacacionempleado = new  VacacionEmpleado();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VacacionEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VacacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vacacionempleado=vacacionempleadoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarVacacionEmpleado(vacacionempleado);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VacacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesVacacionEmpleado(this.vacacionempleado);
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
		vacacionempleado = new  VacacionEmpleado();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VacacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vacacionempleado=vacacionempleadoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarVacacionEmpleado(vacacionempleado);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VacacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesVacacionEmpleado(this.vacacionempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		vacacionempleados = new  ArrayList<VacacionEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VacacionEmpleado.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			VacacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vacacionempleados=vacacionempleadoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVacacionEmpleado(vacacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VacacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesVacacionEmpleado(this.vacacionempleados);
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
		vacacionempleados = new  ArrayList<VacacionEmpleado>();
		  		  
        try {
			VacacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vacacionempleados=vacacionempleadoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarVacacionEmpleado(vacacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VacacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesVacacionEmpleado(this.vacacionempleados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosVacacionEmpleadosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		vacacionempleados = new  ArrayList<VacacionEmpleado>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VacacionEmpleado.class.getSimpleName()+"-getTodosVacacionEmpleadosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VacacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vacacionempleados=vacacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarVacacionEmpleado(vacacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VacacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesVacacionEmpleado(this.vacacionempleados);
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
	
	public  void  getTodosVacacionEmpleados(String sFinalQuery,Pagination pagination)throws Exception {
		vacacionempleados = new  ArrayList<VacacionEmpleado>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			VacacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			vacacionempleados=vacacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarVacacionEmpleado(vacacionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				VacacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesVacacionEmpleado(this.vacacionempleados);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarVacacionEmpleado(VacacionEmpleado vacacionempleado) throws Exception {
		Boolean estaValidado=false;
		
		if(vacacionempleado.getIsNew() || vacacionempleado.getIsChanged()) { 
			this.invalidValues = vacacionempleadoValidator.getInvalidValues(vacacionempleado);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(vacacionempleado);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarVacacionEmpleado(List<VacacionEmpleado> VacacionEmpleados) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(VacacionEmpleado vacacionempleadoLocal:vacacionempleados) {				
			estaValidadoObjeto=this.validarGuardarVacacionEmpleado(vacacionempleadoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarVacacionEmpleado(List<VacacionEmpleado> VacacionEmpleados) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarVacacionEmpleado(vacacionempleados)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarVacacionEmpleado(VacacionEmpleado VacacionEmpleado) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarVacacionEmpleado(vacacionempleado)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(VacacionEmpleado vacacionempleado) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+vacacionempleado.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=VacacionEmpleadoConstantesFunciones.getVacacionEmpleadoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"vacacionempleado","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(VacacionEmpleadoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(VacacionEmpleadoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveVacacionEmpleadoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VacacionEmpleado.class.getSimpleName()+"-saveVacacionEmpleadoWithConnection");connexion.begin();			
			
			VacacionEmpleadoLogicAdditional.checkVacacionEmpleadoToSave(this.vacacionempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			VacacionEmpleadoLogicAdditional.updateVacacionEmpleadoToSave(this.vacacionempleado,this.arrDatoGeneral);
			
			VacacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.vacacionempleado,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowVacacionEmpleado();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarVacacionEmpleado(this.vacacionempleado)) {
				VacacionEmpleadoDataAccess.save(this.vacacionempleado, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.vacacionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			VacacionEmpleadoLogicAdditional.checkVacacionEmpleadoToSaveAfter(this.vacacionempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowVacacionEmpleado();
			
			connexion.commit();			
			
			if(this.vacacionempleado.getIsDeleted()) {
				this.vacacionempleado=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveVacacionEmpleado()throws Exception {	
		try {	
			
			VacacionEmpleadoLogicAdditional.checkVacacionEmpleadoToSave(this.vacacionempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			VacacionEmpleadoLogicAdditional.updateVacacionEmpleadoToSave(this.vacacionempleado,this.arrDatoGeneral);
			
			VacacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.vacacionempleado,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarVacacionEmpleado(this.vacacionempleado)) {			
				VacacionEmpleadoDataAccess.save(this.vacacionempleado, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.vacacionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			VacacionEmpleadoLogicAdditional.checkVacacionEmpleadoToSaveAfter(this.vacacionempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.vacacionempleado.getIsDeleted()) {
				this.vacacionempleado=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveVacacionEmpleadosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VacacionEmpleado.class.getSimpleName()+"-saveVacacionEmpleadosWithConnection");connexion.begin();			
			
			VacacionEmpleadoLogicAdditional.checkVacacionEmpleadoToSaves(vacacionempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowVacacionEmpleados();
			
			Boolean validadoTodosVacacionEmpleado=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(VacacionEmpleado vacacionempleadoLocal:vacacionempleados) {		
				if(vacacionempleadoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				VacacionEmpleadoLogicAdditional.updateVacacionEmpleadoToSave(vacacionempleadoLocal,this.arrDatoGeneral);
	        	
				VacacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),vacacionempleadoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarVacacionEmpleado(vacacionempleadoLocal)) {
					VacacionEmpleadoDataAccess.save(vacacionempleadoLocal, connexion);				
				} else {
					validadoTodosVacacionEmpleado=false;
				}
			}
			
			if(!validadoTodosVacacionEmpleado) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			VacacionEmpleadoLogicAdditional.checkVacacionEmpleadoToSavesAfter(vacacionempleados,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowVacacionEmpleados();
			
			connexion.commit();		
			
			this.quitarVacacionEmpleadosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveVacacionEmpleados()throws Exception {				
		 try {	
			VacacionEmpleadoLogicAdditional.checkVacacionEmpleadoToSaves(vacacionempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosVacacionEmpleado=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(VacacionEmpleado vacacionempleadoLocal:vacacionempleados) {				
				if(vacacionempleadoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				VacacionEmpleadoLogicAdditional.updateVacacionEmpleadoToSave(vacacionempleadoLocal,this.arrDatoGeneral);
	        	
				VacacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),vacacionempleadoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarVacacionEmpleado(vacacionempleadoLocal)) {				
					VacacionEmpleadoDataAccess.save(vacacionempleadoLocal, connexion);				
				} else {
					validadoTodosVacacionEmpleado=false;
				}
			}
			
			if(!validadoTodosVacacionEmpleado) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			VacacionEmpleadoLogicAdditional.checkVacacionEmpleadoToSavesAfter(vacacionempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarVacacionEmpleadosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public VacacionEmpleadoParameterReturnGeneral procesarAccionVacacionEmpleados(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<VacacionEmpleado> vacacionempleados,VacacionEmpleadoParameterReturnGeneral vacacionempleadoParameterGeneral)throws Exception {
		 try {	
			VacacionEmpleadoParameterReturnGeneral vacacionempleadoReturnGeneral=new VacacionEmpleadoParameterReturnGeneral();
	
			VacacionEmpleadoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,vacacionempleados,vacacionempleadoParameterGeneral,vacacionempleadoReturnGeneral);
			
			return vacacionempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public VacacionEmpleadoParameterReturnGeneral procesarAccionVacacionEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<VacacionEmpleado> vacacionempleados,VacacionEmpleadoParameterReturnGeneral vacacionempleadoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VacacionEmpleado.class.getSimpleName()+"-procesarAccionVacacionEmpleadosWithConnection");connexion.begin();			
			
			VacacionEmpleadoParameterReturnGeneral vacacionempleadoReturnGeneral=new VacacionEmpleadoParameterReturnGeneral();
	
			VacacionEmpleadoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,vacacionempleados,vacacionempleadoParameterGeneral,vacacionempleadoReturnGeneral);
			
			this.connexion.commit();
			
			return vacacionempleadoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public VacacionEmpleadoParameterReturnGeneral procesarEventosVacacionEmpleados(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<VacacionEmpleado> vacacionempleados,VacacionEmpleado vacacionempleado,VacacionEmpleadoParameterReturnGeneral vacacionempleadoParameterGeneral,Boolean isEsNuevoVacacionEmpleado,ArrayList<Classe> clases)throws Exception {
		 try {	
			VacacionEmpleadoParameterReturnGeneral vacacionempleadoReturnGeneral=new VacacionEmpleadoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				vacacionempleadoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			VacacionEmpleadoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,vacacionempleados,vacacionempleado,vacacionempleadoParameterGeneral,vacacionempleadoReturnGeneral,isEsNuevoVacacionEmpleado,clases);
			
			return vacacionempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public VacacionEmpleadoParameterReturnGeneral procesarEventosVacacionEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<VacacionEmpleado> vacacionempleados,VacacionEmpleado vacacionempleado,VacacionEmpleadoParameterReturnGeneral vacacionempleadoParameterGeneral,Boolean isEsNuevoVacacionEmpleado,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VacacionEmpleado.class.getSimpleName()+"-procesarEventosVacacionEmpleadosWithConnection");connexion.begin();			
			
			VacacionEmpleadoParameterReturnGeneral vacacionempleadoReturnGeneral=new VacacionEmpleadoParameterReturnGeneral();
	
			vacacionempleadoReturnGeneral.setVacacionEmpleado(vacacionempleado);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				vacacionempleadoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			VacacionEmpleadoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,vacacionempleados,vacacionempleado,vacacionempleadoParameterGeneral,vacacionempleadoReturnGeneral,isEsNuevoVacacionEmpleado,clases);
			
			this.connexion.commit();
			
			return vacacionempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public VacacionEmpleadoParameterReturnGeneral procesarImportacionVacacionEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,VacacionEmpleadoParameterReturnGeneral vacacionempleadoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VacacionEmpleado.class.getSimpleName()+"-procesarImportacionVacacionEmpleadosWithConnection");connexion.begin();			
			
			VacacionEmpleadoParameterReturnGeneral vacacionempleadoReturnGeneral=new VacacionEmpleadoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.vacacionempleados=new ArrayList<VacacionEmpleado>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.vacacionempleado=new VacacionEmpleado();
				
				
				if(conColumnasBase) {this.vacacionempleado.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.vacacionempleado.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.vacacionempleado.setnumero_veces(Integer.parseInt(arrColumnas[iColumn++]));
				this.vacacionempleado.setfecha_estimada(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.vacacionempleado.sethoras_vacaciones(Double.parseDouble(arrColumnas[iColumn++]));
				this.vacacionempleado.sethoras_tomados(Double.parseDouble(arrColumnas[iColumn++]));
				this.vacacionempleado.sethoras_pagados(Double.parseDouble(arrColumnas[iColumn++]));
				this.vacacionempleado.sethoras_adicionales(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.vacacionempleados.add(this.vacacionempleado);
			}
			
			this.saveVacacionEmpleados();
			
			this.connexion.commit();
			
			vacacionempleadoReturnGeneral.setConRetornoEstaProcesado(true);
			vacacionempleadoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return vacacionempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarVacacionEmpleadosEliminados() throws Exception {				
		
		List<VacacionEmpleado> vacacionempleadosAux= new ArrayList<VacacionEmpleado>();
		
		for(VacacionEmpleado vacacionempleado:vacacionempleados) {
			if(!vacacionempleado.getIsDeleted()) {
				vacacionempleadosAux.add(vacacionempleado);
			}
		}
		
		vacacionempleados=vacacionempleadosAux;
	}
	
	public void quitarVacacionEmpleadosNulos() throws Exception {				
		
		List<VacacionEmpleado> vacacionempleadosAux= new ArrayList<VacacionEmpleado>();
		
		for(VacacionEmpleado vacacionempleado : this.vacacionempleados) {
			if(vacacionempleado==null) {
				vacacionempleadosAux.add(vacacionempleado);
			}
		}
		
		//this.vacacionempleados=vacacionempleadosAux;
		
		this.vacacionempleados.removeAll(vacacionempleadosAux);
	}
	
	public void getSetVersionRowVacacionEmpleadoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(vacacionempleado.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((vacacionempleado.getIsDeleted() || (vacacionempleado.getIsChanged()&&!vacacionempleado.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=vacacionempleadoDataAccess.getSetVersionRowVacacionEmpleado(connexion,vacacionempleado.getId());
				
				if(!vacacionempleado.getVersionRow().equals(timestamp)) {	
					vacacionempleado.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				vacacionempleado.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowVacacionEmpleado()throws Exception {	
		
		if(vacacionempleado.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((vacacionempleado.getIsDeleted() || (vacacionempleado.getIsChanged()&&!vacacionempleado.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=vacacionempleadoDataAccess.getSetVersionRowVacacionEmpleado(connexion,vacacionempleado.getId());
			
			try {							
				if(!vacacionempleado.getVersionRow().equals(timestamp)) {	
					vacacionempleado.setVersionRow(timestamp);
				}
				
				vacacionempleado.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowVacacionEmpleadosWithConnection()throws Exception {	
		if(vacacionempleados!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(VacacionEmpleado vacacionempleadoAux:vacacionempleados) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(vacacionempleadoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(vacacionempleadoAux.getIsDeleted() || (vacacionempleadoAux.getIsChanged()&&!vacacionempleadoAux.getIsNew())) {
						
						timestamp=vacacionempleadoDataAccess.getSetVersionRowVacacionEmpleado(connexion,vacacionempleadoAux.getId());
						
						if(!vacacionempleado.getVersionRow().equals(timestamp)) {	
							vacacionempleadoAux.setVersionRow(timestamp);
						}
								
						vacacionempleadoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowVacacionEmpleados()throws Exception {	
		if(vacacionempleados!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(VacacionEmpleado vacacionempleadoAux:vacacionempleados) {
					if(vacacionempleadoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(vacacionempleadoAux.getIsDeleted() || (vacacionempleadoAux.getIsChanged()&&!vacacionempleadoAux.getIsNew())) {
						
						timestamp=vacacionempleadoDataAccess.getSetVersionRowVacacionEmpleado(connexion,vacacionempleadoAux.getId());
						
						if(!vacacionempleadoAux.getVersionRow().equals(timestamp)) {	
							vacacionempleadoAux.setVersionRow(timestamp);
						}
						
													
						vacacionempleadoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public VacacionEmpleadoParameterReturnGeneral cargarCombosLoteForeignKeyVacacionEmpleadoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalAnioPeriodo1,String finalQueryGlobalAnioPeriodo2) throws Exception {
		VacacionEmpleadoParameterReturnGeneral  vacacionempleadoReturnGeneral =new VacacionEmpleadoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VacacionEmpleado.class.getSimpleName()+"-cargarCombosLoteForeignKeyVacacionEmpleadoWithConnection");connexion.begin();
			
			vacacionempleadoReturnGeneral =new VacacionEmpleadoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			vacacionempleadoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			vacacionempleadoReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Anio> anioperiodo1sForeignKey=new ArrayList<Anio>();
			AnioLogic anioperiodo1Logic=new AnioLogic();
			anioperiodo1Logic.setConnexion(this.connexion);
			anioperiodo1Logic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnioPeriodo1.equals("NONE")) {
				anioperiodo1Logic.getTodosAnios(finalQueryGlobalAnioPeriodo1,new Pagination());
				anioperiodo1sForeignKey=anioperiodo1Logic.getAnios();
			}

			vacacionempleadoReturnGeneral.setanioperiodo1sForeignKey(anioperiodo1sForeignKey);


			List<Anio> anioperiodo2sForeignKey=new ArrayList<Anio>();
			AnioLogic anioperiodo2Logic=new AnioLogic();
			anioperiodo2Logic.setConnexion(this.connexion);
			anioperiodo2Logic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnioPeriodo2.equals("NONE")) {
				anioperiodo2Logic.getTodosAnios(finalQueryGlobalAnioPeriodo2,new Pagination());
				anioperiodo2sForeignKey=anioperiodo2Logic.getAnios();
			}

			vacacionempleadoReturnGeneral.setanioperiodo2sForeignKey(anioperiodo2sForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return vacacionempleadoReturnGeneral;
	}
	
	public VacacionEmpleadoParameterReturnGeneral cargarCombosLoteForeignKeyVacacionEmpleado(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalAnioPeriodo1,String finalQueryGlobalAnioPeriodo2) throws Exception {
		VacacionEmpleadoParameterReturnGeneral  vacacionempleadoReturnGeneral =new VacacionEmpleadoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			vacacionempleadoReturnGeneral =new VacacionEmpleadoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			vacacionempleadoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			vacacionempleadoReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Anio> anioperiodo1sForeignKey=new ArrayList<Anio>();
			AnioLogic anioperiodo1Logic=new AnioLogic();
			anioperiodo1Logic.setConnexion(this.connexion);
			anioperiodo1Logic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnioPeriodo1.equals("NONE")) {
				anioperiodo1Logic.getTodosAnios(finalQueryGlobalAnioPeriodo1,new Pagination());
				anioperiodo1sForeignKey=anioperiodo1Logic.getAnios();
			}

			vacacionempleadoReturnGeneral.setanioperiodo1sForeignKey(anioperiodo1sForeignKey);


			List<Anio> anioperiodo2sForeignKey=new ArrayList<Anio>();
			AnioLogic anioperiodo2Logic=new AnioLogic();
			anioperiodo2Logic.setConnexion(this.connexion);
			anioperiodo2Logic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnioPeriodo2.equals("NONE")) {
				anioperiodo2Logic.getTodosAnios(finalQueryGlobalAnioPeriodo2,new Pagination());
				anioperiodo2sForeignKey=anioperiodo2Logic.getAnios();
			}

			vacacionempleadoReturnGeneral.setanioperiodo2sForeignKey(anioperiodo2sForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return vacacionempleadoReturnGeneral;
	}
	
	
	public void deepLoad(VacacionEmpleado vacacionempleado,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			VacacionEmpleadoLogicAdditional.updateVacacionEmpleadoToGet(vacacionempleado,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		vacacionempleado.setEmpresa(vacacionempleadoDataAccess.getEmpresa(connexion,vacacionempleado));
		vacacionempleado.setEmpleado(vacacionempleadoDataAccess.getEmpleado(connexion,vacacionempleado));
		vacacionempleado.setAnioPeriodo1(vacacionempleadoDataAccess.getAnioPeriodo1(connexion,vacacionempleado));
		vacacionempleado.setAnioPeriodo2(vacacionempleadoDataAccess.getAnioPeriodo2(connexion,vacacionempleado));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				vacacionempleado.setEmpresa(vacacionempleadoDataAccess.getEmpresa(connexion,vacacionempleado));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				vacacionempleado.setEmpleado(vacacionempleadoDataAccess.getEmpleado(connexion,vacacionempleado));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				vacacionempleado.setAnioPeriodo1(vacacionempleadoDataAccess.getAnioPeriodo1(connexion,vacacionempleado));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				vacacionempleado.setAnioPeriodo2(vacacionempleadoDataAccess.getAnioPeriodo2(connexion,vacacionempleado));
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
			vacacionempleado.setEmpresa(vacacionempleadoDataAccess.getEmpresa(connexion,vacacionempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vacacionempleado.setEmpleado(vacacionempleadoDataAccess.getEmpleado(connexion,vacacionempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vacacionempleado.setAnioPeriodo1(vacacionempleadoDataAccess.getAnioPeriodo1(connexion,vacacionempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vacacionempleado.setAnioPeriodo2(vacacionempleadoDataAccess.getAnioPeriodo2(connexion,vacacionempleado));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		vacacionempleado.setEmpresa(vacacionempleadoDataAccess.getEmpresa(connexion,vacacionempleado));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(vacacionempleado.getEmpresa(),isDeep,deepLoadType,clases);
				
		vacacionempleado.setEmpleado(vacacionempleadoDataAccess.getEmpleado(connexion,vacacionempleado));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(vacacionempleado.getEmpleado(),isDeep,deepLoadType,clases);
				
		vacacionempleado.setAnioPeriodo1(vacacionempleadoDataAccess.getAnioPeriodo1(connexion,vacacionempleado));
		AnioLogic anioperiodo1Logic= new AnioLogic(connexion);
		anioperiodo1Logic.deepLoad(vacacionempleado.getAnioPeriodo1(),isDeep,deepLoadType,clases);
				
		vacacionempleado.setAnioPeriodo2(vacacionempleadoDataAccess.getAnioPeriodo2(connexion,vacacionempleado));
		AnioLogic anioperiodo2Logic= new AnioLogic(connexion);
		anioperiodo2Logic.deepLoad(vacacionempleado.getAnioPeriodo2(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				vacacionempleado.setEmpresa(vacacionempleadoDataAccess.getEmpresa(connexion,vacacionempleado));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(vacacionempleado.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				vacacionempleado.setEmpleado(vacacionempleadoDataAccess.getEmpleado(connexion,vacacionempleado));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(vacacionempleado.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				vacacionempleado.setAnioPeriodo1(vacacionempleadoDataAccess.getAnioPeriodo1(connexion,vacacionempleado));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(vacacionempleado.getAnioPeriodo1(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				vacacionempleado.setAnioPeriodo2(vacacionempleadoDataAccess.getAnioPeriodo2(connexion,vacacionempleado));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(vacacionempleado.getAnioPeriodo2(),isDeep,deepLoadType,clases);				
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
			vacacionempleado.setEmpresa(vacacionempleadoDataAccess.getEmpresa(connexion,vacacionempleado));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(vacacionempleado.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vacacionempleado.setEmpleado(vacacionempleadoDataAccess.getEmpleado(connexion,vacacionempleado));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(vacacionempleado.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vacacionempleado.setAnioPeriodo1(vacacionempleadoDataAccess.getAnioPeriodo1(connexion,vacacionempleado));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(vacacionempleado.getAnioPeriodo1(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			vacacionempleado.setAnioPeriodo2(vacacionempleadoDataAccess.getAnioPeriodo2(connexion,vacacionempleado));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(vacacionempleado.getAnioPeriodo2(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(VacacionEmpleado vacacionempleado,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			VacacionEmpleadoLogicAdditional.updateVacacionEmpleadoToSave(vacacionempleado,this.arrDatoGeneral);
			
VacacionEmpleadoDataAccess.save(vacacionempleado, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(vacacionempleado.getEmpresa(),connexion);

		EmpleadoDataAccess.save(vacacionempleado.getEmpleado(),connexion);

		AnioDataAccess.save(vacacionempleado.getAnioPeriodo1(),connexion);

		AnioDataAccess.save(vacacionempleado.getAnioPeriodo2(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(vacacionempleado.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(vacacionempleado.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(vacacionempleado.getAnioPeriodo1(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(vacacionempleado.getAnioPeriodo2(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(vacacionempleado.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(vacacionempleado.getEmpresa(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(vacacionempleado.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(vacacionempleado.getEmpleado(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(vacacionempleado.getAnioPeriodo1(),connexion);
		AnioLogic anioperiodo1Logic= new AnioLogic(connexion);
		anioperiodo1Logic.deepLoad(vacacionempleado.getAnioPeriodo1(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(vacacionempleado.getAnioPeriodo2(),connexion);
		AnioLogic anioperiodo2Logic= new AnioLogic(connexion);
		anioperiodo2Logic.deepLoad(vacacionempleado.getAnioPeriodo2(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(vacacionempleado.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(vacacionempleado.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(vacacionempleado.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(vacacionempleado.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(vacacionempleado.getAnioPeriodo1(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(vacacionempleado.getAnioPeriodo1(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(vacacionempleado.getAnioPeriodo2(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(vacacionempleado.getAnioPeriodo2(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(VacacionEmpleado.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(vacacionempleado,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				VacacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesVacacionEmpleado(vacacionempleado);
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
			this.deepLoad(this.vacacionempleado,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				VacacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesVacacionEmpleado(this.vacacionempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(VacacionEmpleado.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(vacacionempleados!=null) {
				for(VacacionEmpleado vacacionempleado:vacacionempleados) {
					this.deepLoad(vacacionempleado,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					VacacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesVacacionEmpleado(vacacionempleados);
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
			if(vacacionempleados!=null) {
				for(VacacionEmpleado vacacionempleado:vacacionempleados) {
					this.deepLoad(vacacionempleado,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					VacacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesVacacionEmpleado(vacacionempleados);
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
			this.getNewConnexionToDeep(VacacionEmpleado.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(vacacionempleado,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(VacacionEmpleado.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(vacacionempleados!=null) {
				for(VacacionEmpleado vacacionempleado:vacacionempleados) {
					this.deepSave(vacacionempleado,isDeep,deepLoadType,clases);
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
			if(vacacionempleados!=null) {
				for(VacacionEmpleado vacacionempleado:vacacionempleados) {
					this.deepSave(vacacionempleado,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getVacacionEmpleadosFK_IdAnioPeriodo1WithConnection(String sFinalQuery,Pagination pagination,Long id_anio_periodo1)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VacacionEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnioPeriodo1= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnioPeriodo1.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio_periodo1,VacacionEmpleadoConstantesFunciones.IDANIOPERIODO1,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnioPeriodo1);

			VacacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnioPeriodo1","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vacacionempleados=vacacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VacacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesVacacionEmpleado(this.vacacionempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getVacacionEmpleadosFK_IdAnioPeriodo1(String sFinalQuery,Pagination pagination,Long id_anio_periodo1)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnioPeriodo1= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnioPeriodo1.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio_periodo1,VacacionEmpleadoConstantesFunciones.IDANIOPERIODO1,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnioPeriodo1);

			VacacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnioPeriodo1","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vacacionempleados=vacacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VacacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesVacacionEmpleado(this.vacacionempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getVacacionEmpleadosFK_IdAnioPeriodo2WithConnection(String sFinalQuery,Pagination pagination,Long id_anio_periodo2)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VacacionEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnioPeriodo2= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnioPeriodo2.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio_periodo2,VacacionEmpleadoConstantesFunciones.IDANIOPERIODO2,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnioPeriodo2);

			VacacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnioPeriodo2","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vacacionempleados=vacacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VacacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesVacacionEmpleado(this.vacacionempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getVacacionEmpleadosFK_IdAnioPeriodo2(String sFinalQuery,Pagination pagination,Long id_anio_periodo2)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnioPeriodo2= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnioPeriodo2.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio_periodo2,VacacionEmpleadoConstantesFunciones.IDANIOPERIODO2,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnioPeriodo2);

			VacacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnioPeriodo2","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vacacionempleados=vacacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VacacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesVacacionEmpleado(this.vacacionempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getVacacionEmpleadosFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VacacionEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,VacacionEmpleadoConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			VacacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vacacionempleados=vacacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VacacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesVacacionEmpleado(this.vacacionempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getVacacionEmpleadosFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,VacacionEmpleadoConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			VacacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vacacionempleados=vacacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VacacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesVacacionEmpleado(this.vacacionempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getVacacionEmpleadosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,VacacionEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,VacacionEmpleadoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			VacacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vacacionempleados=vacacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VacacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesVacacionEmpleado(this.vacacionempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getVacacionEmpleadosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,VacacionEmpleadoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			VacacionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			vacacionempleados=vacacionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				VacacionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesVacacionEmpleado(this.vacacionempleados);
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
			if(VacacionEmpleadoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,VacacionEmpleadoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,VacacionEmpleado vacacionempleado,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(VacacionEmpleadoConstantesFunciones.ISCONAUDITORIA) {
				if(vacacionempleado.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,VacacionEmpleadoDataAccess.TABLENAME, vacacionempleado.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(VacacionEmpleadoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////VacacionEmpleadoLogic.registrarAuditoriaDetallesVacacionEmpleado(connexion,vacacionempleado,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(vacacionempleado.getIsDeleted()) {
					/*if(!vacacionempleado.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,VacacionEmpleadoDataAccess.TABLENAME, vacacionempleado.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////VacacionEmpleadoLogic.registrarAuditoriaDetallesVacacionEmpleado(connexion,vacacionempleado,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,VacacionEmpleadoDataAccess.TABLENAME, vacacionempleado.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(vacacionempleado.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,VacacionEmpleadoDataAccess.TABLENAME, vacacionempleado.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(VacacionEmpleadoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////VacacionEmpleadoLogic.registrarAuditoriaDetallesVacacionEmpleado(connexion,vacacionempleado,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesVacacionEmpleado(Connexion connexion,VacacionEmpleado vacacionempleado)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(vacacionempleado.getIsNew()||!vacacionempleado.getid_empresa().equals(vacacionempleado.getVacacionEmpleadoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vacacionempleado.getVacacionEmpleadoOriginal().getid_empresa()!=null)
				{
					strValorActual=vacacionempleado.getVacacionEmpleadoOriginal().getid_empresa().toString();
				}
				if(vacacionempleado.getid_empresa()!=null)
				{
					strValorNuevo=vacacionempleado.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VacacionEmpleadoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(vacacionempleado.getIsNew()||!vacacionempleado.getid_empleado().equals(vacacionempleado.getVacacionEmpleadoOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vacacionempleado.getVacacionEmpleadoOriginal().getid_empleado()!=null)
				{
					strValorActual=vacacionempleado.getVacacionEmpleadoOriginal().getid_empleado().toString();
				}
				if(vacacionempleado.getid_empleado()!=null)
				{
					strValorNuevo=vacacionempleado.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VacacionEmpleadoConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(vacacionempleado.getIsNew()||!vacacionempleado.getid_anio_periodo1().equals(vacacionempleado.getVacacionEmpleadoOriginal().getid_anio_periodo1()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vacacionempleado.getVacacionEmpleadoOriginal().getid_anio_periodo1()!=null)
				{
					strValorActual=vacacionempleado.getVacacionEmpleadoOriginal().getid_anio_periodo1().toString();
				}
				if(vacacionempleado.getid_anio_periodo1()!=null)
				{
					strValorNuevo=vacacionempleado.getid_anio_periodo1().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VacacionEmpleadoConstantesFunciones.IDANIOPERIODO1,strValorActual,strValorNuevo);
			}	
			
			if(vacacionempleado.getIsNew()||!vacacionempleado.getid_anio_periodo2().equals(vacacionempleado.getVacacionEmpleadoOriginal().getid_anio_periodo2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vacacionempleado.getVacacionEmpleadoOriginal().getid_anio_periodo2()!=null)
				{
					strValorActual=vacacionempleado.getVacacionEmpleadoOriginal().getid_anio_periodo2().toString();
				}
				if(vacacionempleado.getid_anio_periodo2()!=null)
				{
					strValorNuevo=vacacionempleado.getid_anio_periodo2().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VacacionEmpleadoConstantesFunciones.IDANIOPERIODO2,strValorActual,strValorNuevo);
			}	
			
			if(vacacionempleado.getIsNew()||!vacacionempleado.getnumero_veces().equals(vacacionempleado.getVacacionEmpleadoOriginal().getnumero_veces()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vacacionempleado.getVacacionEmpleadoOriginal().getnumero_veces()!=null)
				{
					strValorActual=vacacionempleado.getVacacionEmpleadoOriginal().getnumero_veces().toString();
				}
				if(vacacionempleado.getnumero_veces()!=null)
				{
					strValorNuevo=vacacionempleado.getnumero_veces().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VacacionEmpleadoConstantesFunciones.NUMEROVECES,strValorActual,strValorNuevo);
			}	
			
			if(vacacionempleado.getIsNew()||!vacacionempleado.getfecha_estimada().equals(vacacionempleado.getVacacionEmpleadoOriginal().getfecha_estimada()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vacacionempleado.getVacacionEmpleadoOriginal().getfecha_estimada()!=null)
				{
					strValorActual=vacacionempleado.getVacacionEmpleadoOriginal().getfecha_estimada().toString();
				}
				if(vacacionempleado.getfecha_estimada()!=null)
				{
					strValorNuevo=vacacionempleado.getfecha_estimada().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VacacionEmpleadoConstantesFunciones.FECHAESTIMADA,strValorActual,strValorNuevo);
			}	
			
			if(vacacionempleado.getIsNew()||!vacacionempleado.gethoras_vacaciones().equals(vacacionempleado.getVacacionEmpleadoOriginal().gethoras_vacaciones()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vacacionempleado.getVacacionEmpleadoOriginal().gethoras_vacaciones()!=null)
				{
					strValorActual=vacacionempleado.getVacacionEmpleadoOriginal().gethoras_vacaciones().toString();
				}
				if(vacacionempleado.gethoras_vacaciones()!=null)
				{
					strValorNuevo=vacacionempleado.gethoras_vacaciones().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VacacionEmpleadoConstantesFunciones.HORASVACACIONES,strValorActual,strValorNuevo);
			}	
			
			if(vacacionempleado.getIsNew()||!vacacionempleado.gethoras_tomados().equals(vacacionempleado.getVacacionEmpleadoOriginal().gethoras_tomados()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vacacionempleado.getVacacionEmpleadoOriginal().gethoras_tomados()!=null)
				{
					strValorActual=vacacionempleado.getVacacionEmpleadoOriginal().gethoras_tomados().toString();
				}
				if(vacacionempleado.gethoras_tomados()!=null)
				{
					strValorNuevo=vacacionempleado.gethoras_tomados().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VacacionEmpleadoConstantesFunciones.HORASTOMADOS,strValorActual,strValorNuevo);
			}	
			
			if(vacacionempleado.getIsNew()||!vacacionempleado.gethoras_pagados().equals(vacacionempleado.getVacacionEmpleadoOriginal().gethoras_pagados()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vacacionempleado.getVacacionEmpleadoOriginal().gethoras_pagados()!=null)
				{
					strValorActual=vacacionempleado.getVacacionEmpleadoOriginal().gethoras_pagados().toString();
				}
				if(vacacionempleado.gethoras_pagados()!=null)
				{
					strValorNuevo=vacacionempleado.gethoras_pagados().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VacacionEmpleadoConstantesFunciones.HORASPAGADOS,strValorActual,strValorNuevo);
			}	
			
			if(vacacionempleado.getIsNew()||!vacacionempleado.gethoras_adicionales().equals(vacacionempleado.getVacacionEmpleadoOriginal().gethoras_adicionales()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(vacacionempleado.getVacacionEmpleadoOriginal().gethoras_adicionales()!=null)
				{
					strValorActual=vacacionempleado.getVacacionEmpleadoOriginal().gethoras_adicionales().toString();
				}
				if(vacacionempleado.gethoras_adicionales()!=null)
				{
					strValorNuevo=vacacionempleado.gethoras_adicionales().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),VacacionEmpleadoConstantesFunciones.HORASADICIONALES,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveVacacionEmpleadoRelacionesWithConnection(VacacionEmpleado vacacionempleado) throws Exception {

		if(!vacacionempleado.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveVacacionEmpleadoRelacionesBase(vacacionempleado,true);
		}
	}

	public void saveVacacionEmpleadoRelaciones(VacacionEmpleado vacacionempleado)throws Exception {

		if(!vacacionempleado.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveVacacionEmpleadoRelacionesBase(vacacionempleado,false);
		}
	}

	public void saveVacacionEmpleadoRelacionesBase(VacacionEmpleado vacacionempleado,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("VacacionEmpleado-saveRelacionesWithConnection");}
	

			this.setVacacionEmpleado(vacacionempleado);

			if(VacacionEmpleadoLogicAdditional.validarSaveRelaciones(vacacionempleado,this)) {

				VacacionEmpleadoLogicAdditional.updateRelacionesToSave(vacacionempleado,this);

				if((vacacionempleado.getIsNew()||vacacionempleado.getIsChanged())&&!vacacionempleado.getIsDeleted()) {
					this.saveVacacionEmpleado();
					this.saveVacacionEmpleadoRelacionesDetalles();

				} else if(vacacionempleado.getIsDeleted()) {
					this.saveVacacionEmpleadoRelacionesDetalles();
					this.saveVacacionEmpleado();
				}

				VacacionEmpleadoLogicAdditional.updateRelacionesToSaveAfter(vacacionempleado,this);

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
	
	
	private void saveVacacionEmpleadoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfVacacionEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=VacacionEmpleadoConstantesFunciones.getClassesForeignKeysOfVacacionEmpleado(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfVacacionEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=VacacionEmpleadoConstantesFunciones.getClassesRelationshipsOfVacacionEmpleado(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

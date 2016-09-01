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
import com.bydan.erp.nomina.util.ProvisionEmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.ProvisionEmpleadoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.ProvisionEmpleadoParameterGeneral;
import com.bydan.erp.nomina.business.entity.ProvisionEmpleado;
import com.bydan.erp.nomina.business.logic.ProvisionEmpleadoLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class ProvisionEmpleadoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ProvisionEmpleadoLogic.class);
	
	protected ProvisionEmpleadoDataAccess provisionempleadoDataAccess; 	
	protected ProvisionEmpleado provisionempleado;
	protected List<ProvisionEmpleado> provisionempleados;
	protected Object provisionempleadoObject;	
	protected List<Object> provisionempleadosObject;
	
	public static ClassValidator<ProvisionEmpleado> provisionempleadoValidator = new ClassValidator<ProvisionEmpleado>(ProvisionEmpleado.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ProvisionEmpleadoLogicAdditional provisionempleadoLogicAdditional=null;
	
	public ProvisionEmpleadoLogicAdditional getProvisionEmpleadoLogicAdditional() {
		return this.provisionempleadoLogicAdditional;
	}
	
	public void setProvisionEmpleadoLogicAdditional(ProvisionEmpleadoLogicAdditional provisionempleadoLogicAdditional) {
		try {
			this.provisionempleadoLogicAdditional=provisionempleadoLogicAdditional;
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
	
	
	
	
	public  ProvisionEmpleadoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.provisionempleadoDataAccess = new ProvisionEmpleadoDataAccess();
			
			this.provisionempleados= new ArrayList<ProvisionEmpleado>();
			this.provisionempleado= new ProvisionEmpleado();
			
			this.provisionempleadoObject=new Object();
			this.provisionempleadosObject=new ArrayList<Object>();
				
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
			
			this.provisionempleadoDataAccess.setConnexionType(this.connexionType);
			this.provisionempleadoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ProvisionEmpleadoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.provisionempleadoDataAccess = new ProvisionEmpleadoDataAccess();
			this.provisionempleados= new ArrayList<ProvisionEmpleado>();
			this.provisionempleado= new ProvisionEmpleado();
			this.provisionempleadoObject=new Object();
			this.provisionempleadosObject=new ArrayList<Object>();
			
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
			
			this.provisionempleadoDataAccess.setConnexionType(this.connexionType);
			this.provisionempleadoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ProvisionEmpleado getProvisionEmpleado() throws Exception {	
		ProvisionEmpleadoLogicAdditional.checkProvisionEmpleadoToGet(provisionempleado,this.datosCliente,this.arrDatoGeneral);
		ProvisionEmpleadoLogicAdditional.updateProvisionEmpleadoToGet(provisionempleado,this.arrDatoGeneral);
		
		return provisionempleado;
	}
		
	public void setProvisionEmpleado(ProvisionEmpleado newProvisionEmpleado) {
		this.provisionempleado = newProvisionEmpleado;
	}
	
	public ProvisionEmpleadoDataAccess getProvisionEmpleadoDataAccess() {
		return provisionempleadoDataAccess;
	}
	
	public void setProvisionEmpleadoDataAccess(ProvisionEmpleadoDataAccess newprovisionempleadoDataAccess) {
		this.provisionempleadoDataAccess = newprovisionempleadoDataAccess;
	}
	
	public List<ProvisionEmpleado> getProvisionEmpleados() throws Exception {		
		this.quitarProvisionEmpleadosNulos();
		
		ProvisionEmpleadoLogicAdditional.checkProvisionEmpleadoToGets(provisionempleados,this.datosCliente,this.arrDatoGeneral);
		
		for (ProvisionEmpleado provisionempleadoLocal: provisionempleados ) {
			ProvisionEmpleadoLogicAdditional.updateProvisionEmpleadoToGet(provisionempleadoLocal,this.arrDatoGeneral);
		}
		
		return provisionempleados;
	}
	
	public void setProvisionEmpleados(List<ProvisionEmpleado> newProvisionEmpleados) {
		this.provisionempleados = newProvisionEmpleados;
	}
	
	public Object getProvisionEmpleadoObject() {	
		this.provisionempleadoObject=this.provisionempleadoDataAccess.getEntityObject();
		return this.provisionempleadoObject;
	}
		
	public void setProvisionEmpleadoObject(Object newProvisionEmpleadoObject) {
		this.provisionempleadoObject = newProvisionEmpleadoObject;
	}
	
	public List<Object> getProvisionEmpleadosObject() {		
		this.provisionempleadosObject=this.provisionempleadoDataAccess.getEntitiesObject();
		return this.provisionempleadosObject;
	}
		
	public void setProvisionEmpleadosObject(List<Object> newProvisionEmpleadosObject) {
		this.provisionempleadosObject = newProvisionEmpleadosObject;
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
		
		if(this.provisionempleadoDataAccess!=null) {
			this.provisionempleadoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProvisionEmpleado.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			provisionempleadoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			provisionempleadoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		provisionempleado = new  ProvisionEmpleado();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProvisionEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			provisionempleado=provisionempleadoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.provisionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesProvisionEmpleado(this.provisionempleado);
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
		provisionempleado = new  ProvisionEmpleado();
		  		  
        try {
			
			provisionempleado=provisionempleadoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.provisionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesProvisionEmpleado(this.provisionempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		provisionempleado = new  ProvisionEmpleado();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProvisionEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			provisionempleado=provisionempleadoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.provisionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesProvisionEmpleado(this.provisionempleado);
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
		provisionempleado = new  ProvisionEmpleado();
		  		  
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
		provisionempleado = new  ProvisionEmpleado();
		  		  
        try {
			
			provisionempleado=provisionempleadoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.provisionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesProvisionEmpleado(this.provisionempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		provisionempleado = new  ProvisionEmpleado();
		  		  
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
		provisionempleado = new  ProvisionEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProvisionEmpleado.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =provisionempleadoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		provisionempleado = new  ProvisionEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=provisionempleadoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		provisionempleado = new  ProvisionEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProvisionEmpleado.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =provisionempleadoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		provisionempleado = new  ProvisionEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=provisionempleadoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		provisionempleado = new  ProvisionEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProvisionEmpleado.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =provisionempleadoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		provisionempleado = new  ProvisionEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=provisionempleadoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		provisionempleados = new  ArrayList<ProvisionEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProvisionEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			provisionempleados=provisionempleadoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProvisionEmpleado(provisionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesProvisionEmpleado(this.provisionempleados);
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
		provisionempleados = new  ArrayList<ProvisionEmpleado>();
		  		  
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
		provisionempleados = new  ArrayList<ProvisionEmpleado>();
		  		  
        try {			
			ProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			provisionempleados=provisionempleadoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarProvisionEmpleado(provisionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesProvisionEmpleado(this.provisionempleados);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		provisionempleados = new  ArrayList<ProvisionEmpleado>();
		  		  
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
		provisionempleados = new  ArrayList<ProvisionEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProvisionEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			provisionempleados=provisionempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProvisionEmpleado(provisionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesProvisionEmpleado(this.provisionempleados);
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
		provisionempleados = new  ArrayList<ProvisionEmpleado>();
		  		  
        try {
			ProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			provisionempleados=provisionempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProvisionEmpleado(provisionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesProvisionEmpleado(this.provisionempleados);
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
		provisionempleados = new  ArrayList<ProvisionEmpleado>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProvisionEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			provisionempleados=provisionempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProvisionEmpleado(provisionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesProvisionEmpleado(this.provisionempleados);
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
		provisionempleados = new  ArrayList<ProvisionEmpleado>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			provisionempleados=provisionempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProvisionEmpleado(provisionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesProvisionEmpleado(this.provisionempleados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		provisionempleado = new  ProvisionEmpleado();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProvisionEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			provisionempleado=provisionempleadoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProvisionEmpleado(provisionempleado);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesProvisionEmpleado(this.provisionempleado);
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
		provisionempleado = new  ProvisionEmpleado();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			provisionempleado=provisionempleadoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarProvisionEmpleado(provisionempleado);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesProvisionEmpleado(this.provisionempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		provisionempleados = new  ArrayList<ProvisionEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProvisionEmpleado.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			provisionempleados=provisionempleadoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProvisionEmpleado(provisionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesProvisionEmpleado(this.provisionempleados);
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
		provisionempleados = new  ArrayList<ProvisionEmpleado>();
		  		  
        try {
			ProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			provisionempleados=provisionempleadoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarProvisionEmpleado(provisionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesProvisionEmpleado(this.provisionempleados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosProvisionEmpleadosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		provisionempleados = new  ArrayList<ProvisionEmpleado>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProvisionEmpleado.class.getSimpleName()+"-getTodosProvisionEmpleadosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			provisionempleados=provisionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProvisionEmpleado(provisionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesProvisionEmpleado(this.provisionempleados);
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
	
	public  void  getTodosProvisionEmpleados(String sFinalQuery,Pagination pagination)throws Exception {
		provisionempleados = new  ArrayList<ProvisionEmpleado>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			provisionempleados=provisionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarProvisionEmpleado(provisionempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesProvisionEmpleado(this.provisionempleados);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarProvisionEmpleado(ProvisionEmpleado provisionempleado) throws Exception {
		Boolean estaValidado=false;
		
		if(provisionempleado.getIsNew() || provisionempleado.getIsChanged()) { 
			this.invalidValues = provisionempleadoValidator.getInvalidValues(provisionempleado);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(provisionempleado);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarProvisionEmpleado(List<ProvisionEmpleado> ProvisionEmpleados) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ProvisionEmpleado provisionempleadoLocal:provisionempleados) {				
			estaValidadoObjeto=this.validarGuardarProvisionEmpleado(provisionempleadoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarProvisionEmpleado(List<ProvisionEmpleado> ProvisionEmpleados) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProvisionEmpleado(provisionempleados)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarProvisionEmpleado(ProvisionEmpleado ProvisionEmpleado) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarProvisionEmpleado(provisionempleado)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ProvisionEmpleado provisionempleado) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+provisionempleado.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ProvisionEmpleadoConstantesFunciones.getProvisionEmpleadoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"provisionempleado","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ProvisionEmpleadoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ProvisionEmpleadoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveProvisionEmpleadoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProvisionEmpleado.class.getSimpleName()+"-saveProvisionEmpleadoWithConnection");connexion.begin();			
			
			ProvisionEmpleadoLogicAdditional.checkProvisionEmpleadoToSave(this.provisionempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProvisionEmpleadoLogicAdditional.updateProvisionEmpleadoToSave(this.provisionempleado,this.arrDatoGeneral);
			
			ProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.provisionempleado,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowProvisionEmpleado();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProvisionEmpleado(this.provisionempleado)) {
				ProvisionEmpleadoDataAccess.save(this.provisionempleado, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.provisionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProvisionEmpleadoLogicAdditional.checkProvisionEmpleadoToSaveAfter(this.provisionempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProvisionEmpleado();
			
			connexion.commit();			
			
			if(this.provisionempleado.getIsDeleted()) {
				this.provisionempleado=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveProvisionEmpleado()throws Exception {	
		try {	
			
			ProvisionEmpleadoLogicAdditional.checkProvisionEmpleadoToSave(this.provisionempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ProvisionEmpleadoLogicAdditional.updateProvisionEmpleadoToSave(this.provisionempleado,this.arrDatoGeneral);
			
			ProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.provisionempleado,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarProvisionEmpleado(this.provisionempleado)) {			
				ProvisionEmpleadoDataAccess.save(this.provisionempleado, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.provisionempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ProvisionEmpleadoLogicAdditional.checkProvisionEmpleadoToSaveAfter(this.provisionempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.provisionempleado.getIsDeleted()) {
				this.provisionempleado=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveProvisionEmpleadosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProvisionEmpleado.class.getSimpleName()+"-saveProvisionEmpleadosWithConnection");connexion.begin();			
			
			ProvisionEmpleadoLogicAdditional.checkProvisionEmpleadoToSaves(provisionempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowProvisionEmpleados();
			
			Boolean validadoTodosProvisionEmpleado=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ProvisionEmpleado provisionempleadoLocal:provisionempleados) {		
				if(provisionempleadoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProvisionEmpleadoLogicAdditional.updateProvisionEmpleadoToSave(provisionempleadoLocal,this.arrDatoGeneral);
	        	
				ProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),provisionempleadoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProvisionEmpleado(provisionempleadoLocal)) {
					ProvisionEmpleadoDataAccess.save(provisionempleadoLocal, connexion);				
				} else {
					validadoTodosProvisionEmpleado=false;
				}
			}
			
			if(!validadoTodosProvisionEmpleado) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProvisionEmpleadoLogicAdditional.checkProvisionEmpleadoToSavesAfter(provisionempleados,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowProvisionEmpleados();
			
			connexion.commit();		
			
			this.quitarProvisionEmpleadosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveProvisionEmpleados()throws Exception {				
		 try {	
			ProvisionEmpleadoLogicAdditional.checkProvisionEmpleadoToSaves(provisionempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosProvisionEmpleado=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ProvisionEmpleado provisionempleadoLocal:provisionempleados) {				
				if(provisionempleadoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ProvisionEmpleadoLogicAdditional.updateProvisionEmpleadoToSave(provisionempleadoLocal,this.arrDatoGeneral);
	        	
				ProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),provisionempleadoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarProvisionEmpleado(provisionempleadoLocal)) {				
					ProvisionEmpleadoDataAccess.save(provisionempleadoLocal, connexion);				
				} else {
					validadoTodosProvisionEmpleado=false;
				}
			}
			
			if(!validadoTodosProvisionEmpleado) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ProvisionEmpleadoLogicAdditional.checkProvisionEmpleadoToSavesAfter(provisionempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarProvisionEmpleadosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProvisionEmpleadoParameterReturnGeneral procesarAccionProvisionEmpleados(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProvisionEmpleado> provisionempleados,ProvisionEmpleadoParameterReturnGeneral provisionempleadoParameterGeneral)throws Exception {
		 try {	
			ProvisionEmpleadoParameterReturnGeneral provisionempleadoReturnGeneral=new ProvisionEmpleadoParameterReturnGeneral();
	
			ProvisionEmpleadoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,provisionempleados,provisionempleadoParameterGeneral,provisionempleadoReturnGeneral);
			
			return provisionempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ProvisionEmpleadoParameterReturnGeneral procesarAccionProvisionEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ProvisionEmpleado> provisionempleados,ProvisionEmpleadoParameterReturnGeneral provisionempleadoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProvisionEmpleado.class.getSimpleName()+"-procesarAccionProvisionEmpleadosWithConnection");connexion.begin();			
			
			ProvisionEmpleadoParameterReturnGeneral provisionempleadoReturnGeneral=new ProvisionEmpleadoParameterReturnGeneral();
	
			ProvisionEmpleadoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,provisionempleados,provisionempleadoParameterGeneral,provisionempleadoReturnGeneral);
			
			this.connexion.commit();
			
			return provisionempleadoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProvisionEmpleadoParameterReturnGeneral procesarEventosProvisionEmpleados(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ProvisionEmpleado> provisionempleados,ProvisionEmpleado provisionempleado,ProvisionEmpleadoParameterReturnGeneral provisionempleadoParameterGeneral,Boolean isEsNuevoProvisionEmpleado,ArrayList<Classe> clases)throws Exception {
		 try {	
			ProvisionEmpleadoParameterReturnGeneral provisionempleadoReturnGeneral=new ProvisionEmpleadoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				provisionempleadoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProvisionEmpleadoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,provisionempleados,provisionempleado,provisionempleadoParameterGeneral,provisionempleadoReturnGeneral,isEsNuevoProvisionEmpleado,clases);
			
			return provisionempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ProvisionEmpleadoParameterReturnGeneral procesarEventosProvisionEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ProvisionEmpleado> provisionempleados,ProvisionEmpleado provisionempleado,ProvisionEmpleadoParameterReturnGeneral provisionempleadoParameterGeneral,Boolean isEsNuevoProvisionEmpleado,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProvisionEmpleado.class.getSimpleName()+"-procesarEventosProvisionEmpleadosWithConnection");connexion.begin();			
			
			ProvisionEmpleadoParameterReturnGeneral provisionempleadoReturnGeneral=new ProvisionEmpleadoParameterReturnGeneral();
	
			provisionempleadoReturnGeneral.setProvisionEmpleado(provisionempleado);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				provisionempleadoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ProvisionEmpleadoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,provisionempleados,provisionempleado,provisionempleadoParameterGeneral,provisionempleadoReturnGeneral,isEsNuevoProvisionEmpleado,clases);
			
			this.connexion.commit();
			
			return provisionempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ProvisionEmpleadoParameterReturnGeneral procesarImportacionProvisionEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ProvisionEmpleadoParameterReturnGeneral provisionempleadoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProvisionEmpleado.class.getSimpleName()+"-procesarImportacionProvisionEmpleadosWithConnection");connexion.begin();			
			
			ProvisionEmpleadoParameterReturnGeneral provisionempleadoReturnGeneral=new ProvisionEmpleadoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.provisionempleados=new ArrayList<ProvisionEmpleado>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.provisionempleado=new ProvisionEmpleado();
				
				
				if(conColumnasBase) {this.provisionempleado.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.provisionempleado.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.provisionempleado.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.provisionempleado.setfecha_liquidacion(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.provisionempleado.setvalor_mes(Double.parseDouble(arrColumnas[iColumn++]));
				this.provisionempleado.setvalor_paga(Double.parseDouble(arrColumnas[iColumn++]));
				this.provisionempleado.setvalor_vacacion(Double.parseDouble(arrColumnas[iColumn++]));
				this.provisionempleado.setvalor_liquidacion(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.provisionempleados.add(this.provisionempleado);
			}
			
			this.saveProvisionEmpleados();
			
			this.connexion.commit();
			
			provisionempleadoReturnGeneral.setConRetornoEstaProcesado(true);
			provisionempleadoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return provisionempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarProvisionEmpleadosEliminados() throws Exception {				
		
		List<ProvisionEmpleado> provisionempleadosAux= new ArrayList<ProvisionEmpleado>();
		
		for(ProvisionEmpleado provisionempleado:provisionempleados) {
			if(!provisionempleado.getIsDeleted()) {
				provisionempleadosAux.add(provisionempleado);
			}
		}
		
		provisionempleados=provisionempleadosAux;
	}
	
	public void quitarProvisionEmpleadosNulos() throws Exception {				
		
		List<ProvisionEmpleado> provisionempleadosAux= new ArrayList<ProvisionEmpleado>();
		
		for(ProvisionEmpleado provisionempleado : this.provisionempleados) {
			if(provisionempleado==null) {
				provisionempleadosAux.add(provisionempleado);
			}
		}
		
		//this.provisionempleados=provisionempleadosAux;
		
		this.provisionempleados.removeAll(provisionempleadosAux);
	}
	
	public void getSetVersionRowProvisionEmpleadoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(provisionempleado.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((provisionempleado.getIsDeleted() || (provisionempleado.getIsChanged()&&!provisionempleado.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=provisionempleadoDataAccess.getSetVersionRowProvisionEmpleado(connexion,provisionempleado.getId());
				
				if(!provisionempleado.getVersionRow().equals(timestamp)) {	
					provisionempleado.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				provisionempleado.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowProvisionEmpleado()throws Exception {	
		
		if(provisionempleado.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((provisionempleado.getIsDeleted() || (provisionempleado.getIsChanged()&&!provisionempleado.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=provisionempleadoDataAccess.getSetVersionRowProvisionEmpleado(connexion,provisionempleado.getId());
			
			try {							
				if(!provisionempleado.getVersionRow().equals(timestamp)) {	
					provisionempleado.setVersionRow(timestamp);
				}
				
				provisionempleado.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowProvisionEmpleadosWithConnection()throws Exception {	
		if(provisionempleados!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ProvisionEmpleado provisionempleadoAux:provisionempleados) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(provisionempleadoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(provisionempleadoAux.getIsDeleted() || (provisionempleadoAux.getIsChanged()&&!provisionempleadoAux.getIsNew())) {
						
						timestamp=provisionempleadoDataAccess.getSetVersionRowProvisionEmpleado(connexion,provisionempleadoAux.getId());
						
						if(!provisionempleado.getVersionRow().equals(timestamp)) {	
							provisionempleadoAux.setVersionRow(timestamp);
						}
								
						provisionempleadoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowProvisionEmpleados()throws Exception {	
		if(provisionempleados!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ProvisionEmpleado provisionempleadoAux:provisionempleados) {
					if(provisionempleadoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(provisionempleadoAux.getIsDeleted() || (provisionempleadoAux.getIsChanged()&&!provisionempleadoAux.getIsNew())) {
						
						timestamp=provisionempleadoDataAccess.getSetVersionRowProvisionEmpleado(connexion,provisionempleadoAux.getId());
						
						if(!provisionempleadoAux.getVersionRow().equals(timestamp)) {	
							provisionempleadoAux.setVersionRow(timestamp);
						}
						
													
						provisionempleadoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ProvisionEmpleadoParameterReturnGeneral cargarCombosLoteForeignKeyProvisionEmpleadoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalEstructura,String finalQueryGlobalTipoProvisionEmpleado,String finalQueryGlobalDefiProvisionEmpleado,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		ProvisionEmpleadoParameterReturnGeneral  provisionempleadoReturnGeneral =new ProvisionEmpleadoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProvisionEmpleado.class.getSimpleName()+"-cargarCombosLoteForeignKeyProvisionEmpleadoWithConnection");connexion.begin();
			
			provisionempleadoReturnGeneral =new ProvisionEmpleadoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			provisionempleadoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			provisionempleadoReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			provisionempleadoReturnGeneral.setestructurasForeignKey(estructurasForeignKey);


			List<TipoProvisionEmpleado> tipoprovisionempleadosForeignKey=new ArrayList<TipoProvisionEmpleado>();
			TipoProvisionEmpleadoLogic tipoprovisionempleadoLogic=new TipoProvisionEmpleadoLogic();
			tipoprovisionempleadoLogic.setConnexion(this.connexion);
			tipoprovisionempleadoLogic.getTipoProvisionEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoProvisionEmpleado.equals("NONE")) {
				tipoprovisionempleadoLogic.getTodosTipoProvisionEmpleados(finalQueryGlobalTipoProvisionEmpleado,new Pagination());
				tipoprovisionempleadosForeignKey=tipoprovisionempleadoLogic.getTipoProvisionEmpleados();
			}

			provisionempleadoReturnGeneral.settipoprovisionempleadosForeignKey(tipoprovisionempleadosForeignKey);


			List<DefiProvisionEmpleado> defiprovisionempleadosForeignKey=new ArrayList<DefiProvisionEmpleado>();
			DefiProvisionEmpleadoLogic defiprovisionempleadoLogic=new DefiProvisionEmpleadoLogic();
			defiprovisionempleadoLogic.setConnexion(this.connexion);
			defiprovisionempleadoLogic.getDefiProvisionEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDefiProvisionEmpleado.equals("NONE")) {
				defiprovisionempleadoLogic.getTodosDefiProvisionEmpleados(finalQueryGlobalDefiProvisionEmpleado,new Pagination());
				defiprovisionempleadosForeignKey=defiprovisionempleadoLogic.getDefiProvisionEmpleados();
			}

			provisionempleadoReturnGeneral.setdefiprovisionempleadosForeignKey(defiprovisionempleadosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			provisionempleadoReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			provisionempleadoReturnGeneral.setmessForeignKey(messForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return provisionempleadoReturnGeneral;
	}
	
	public ProvisionEmpleadoParameterReturnGeneral cargarCombosLoteForeignKeyProvisionEmpleado(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalEstructura,String finalQueryGlobalTipoProvisionEmpleado,String finalQueryGlobalDefiProvisionEmpleado,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		ProvisionEmpleadoParameterReturnGeneral  provisionempleadoReturnGeneral =new ProvisionEmpleadoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			provisionempleadoReturnGeneral =new ProvisionEmpleadoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			provisionempleadoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			provisionempleadoReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			provisionempleadoReturnGeneral.setestructurasForeignKey(estructurasForeignKey);


			List<TipoProvisionEmpleado> tipoprovisionempleadosForeignKey=new ArrayList<TipoProvisionEmpleado>();
			TipoProvisionEmpleadoLogic tipoprovisionempleadoLogic=new TipoProvisionEmpleadoLogic();
			tipoprovisionempleadoLogic.setConnexion(this.connexion);
			tipoprovisionempleadoLogic.getTipoProvisionEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoProvisionEmpleado.equals("NONE")) {
				tipoprovisionempleadoLogic.getTodosTipoProvisionEmpleados(finalQueryGlobalTipoProvisionEmpleado,new Pagination());
				tipoprovisionempleadosForeignKey=tipoprovisionempleadoLogic.getTipoProvisionEmpleados();
			}

			provisionempleadoReturnGeneral.settipoprovisionempleadosForeignKey(tipoprovisionempleadosForeignKey);


			List<DefiProvisionEmpleado> defiprovisionempleadosForeignKey=new ArrayList<DefiProvisionEmpleado>();
			DefiProvisionEmpleadoLogic defiprovisionempleadoLogic=new DefiProvisionEmpleadoLogic();
			defiprovisionempleadoLogic.setConnexion(this.connexion);
			defiprovisionempleadoLogic.getDefiProvisionEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDefiProvisionEmpleado.equals("NONE")) {
				defiprovisionempleadoLogic.getTodosDefiProvisionEmpleados(finalQueryGlobalDefiProvisionEmpleado,new Pagination());
				defiprovisionempleadosForeignKey=defiprovisionempleadoLogic.getDefiProvisionEmpleados();
			}

			provisionempleadoReturnGeneral.setdefiprovisionempleadosForeignKey(defiprovisionempleadosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			provisionempleadoReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			provisionempleadoReturnGeneral.setmessForeignKey(messForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return provisionempleadoReturnGeneral;
	}
	
	
	public void deepLoad(ProvisionEmpleado provisionempleado,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ProvisionEmpleadoLogicAdditional.updateProvisionEmpleadoToGet(provisionempleado,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		provisionempleado.setEmpresa(provisionempleadoDataAccess.getEmpresa(connexion,provisionempleado));
		provisionempleado.setEmpleado(provisionempleadoDataAccess.getEmpleado(connexion,provisionempleado));
		provisionempleado.setEstructura(provisionempleadoDataAccess.getEstructura(connexion,provisionempleado));
		provisionempleado.setTipoProvisionEmpleado(provisionempleadoDataAccess.getTipoProvisionEmpleado(connexion,provisionempleado));
		provisionempleado.setDefiProvisionEmpleado(provisionempleadoDataAccess.getDefiProvisionEmpleado(connexion,provisionempleado));
		provisionempleado.setAnio(provisionempleadoDataAccess.getAnio(connexion,provisionempleado));
		provisionempleado.setMes(provisionempleadoDataAccess.getMes(connexion,provisionempleado));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				provisionempleado.setEmpresa(provisionempleadoDataAccess.getEmpresa(connexion,provisionempleado));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				provisionempleado.setEmpleado(provisionempleadoDataAccess.getEmpleado(connexion,provisionempleado));
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				provisionempleado.setEstructura(provisionempleadoDataAccess.getEstructura(connexion,provisionempleado));
				continue;
			}

			if(clas.clas.equals(TipoProvisionEmpleado.class)) {
				provisionempleado.setTipoProvisionEmpleado(provisionempleadoDataAccess.getTipoProvisionEmpleado(connexion,provisionempleado));
				continue;
			}

			if(clas.clas.equals(DefiProvisionEmpleado.class)) {
				provisionempleado.setDefiProvisionEmpleado(provisionempleadoDataAccess.getDefiProvisionEmpleado(connexion,provisionempleado));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				provisionempleado.setAnio(provisionempleadoDataAccess.getAnio(connexion,provisionempleado));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				provisionempleado.setMes(provisionempleadoDataAccess.getMes(connexion,provisionempleado));
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
			provisionempleado.setEmpresa(provisionempleadoDataAccess.getEmpresa(connexion,provisionempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			provisionempleado.setEmpleado(provisionempleadoDataAccess.getEmpleado(connexion,provisionempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			provisionempleado.setEstructura(provisionempleadoDataAccess.getEstructura(connexion,provisionempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProvisionEmpleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			provisionempleado.setTipoProvisionEmpleado(provisionempleadoDataAccess.getTipoProvisionEmpleado(connexion,provisionempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DefiProvisionEmpleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			provisionempleado.setDefiProvisionEmpleado(provisionempleadoDataAccess.getDefiProvisionEmpleado(connexion,provisionempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			provisionempleado.setAnio(provisionempleadoDataAccess.getAnio(connexion,provisionempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			provisionempleado.setMes(provisionempleadoDataAccess.getMes(connexion,provisionempleado));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		provisionempleado.setEmpresa(provisionempleadoDataAccess.getEmpresa(connexion,provisionempleado));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(provisionempleado.getEmpresa(),isDeep,deepLoadType,clases);
				
		provisionempleado.setEmpleado(provisionempleadoDataAccess.getEmpleado(connexion,provisionempleado));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(provisionempleado.getEmpleado(),isDeep,deepLoadType,clases);
				
		provisionempleado.setEstructura(provisionempleadoDataAccess.getEstructura(connexion,provisionempleado));
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(provisionempleado.getEstructura(),isDeep,deepLoadType,clases);
				
		provisionempleado.setTipoProvisionEmpleado(provisionempleadoDataAccess.getTipoProvisionEmpleado(connexion,provisionempleado));
		TipoProvisionEmpleadoLogic tipoprovisionempleadoLogic= new TipoProvisionEmpleadoLogic(connexion);
		tipoprovisionempleadoLogic.deepLoad(provisionempleado.getTipoProvisionEmpleado(),isDeep,deepLoadType,clases);
				
		provisionempleado.setDefiProvisionEmpleado(provisionempleadoDataAccess.getDefiProvisionEmpleado(connexion,provisionempleado));
		DefiProvisionEmpleadoLogic defiprovisionempleadoLogic= new DefiProvisionEmpleadoLogic(connexion);
		defiprovisionempleadoLogic.deepLoad(provisionempleado.getDefiProvisionEmpleado(),isDeep,deepLoadType,clases);
				
		provisionempleado.setAnio(provisionempleadoDataAccess.getAnio(connexion,provisionempleado));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(provisionempleado.getAnio(),isDeep,deepLoadType,clases);
				
		provisionempleado.setMes(provisionempleadoDataAccess.getMes(connexion,provisionempleado));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(provisionempleado.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				provisionempleado.setEmpresa(provisionempleadoDataAccess.getEmpresa(connexion,provisionempleado));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(provisionempleado.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				provisionempleado.setEmpleado(provisionempleadoDataAccess.getEmpleado(connexion,provisionempleado));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(provisionempleado.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				provisionempleado.setEstructura(provisionempleadoDataAccess.getEstructura(connexion,provisionempleado));
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepLoad(provisionempleado.getEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoProvisionEmpleado.class)) {
				provisionempleado.setTipoProvisionEmpleado(provisionempleadoDataAccess.getTipoProvisionEmpleado(connexion,provisionempleado));
				TipoProvisionEmpleadoLogic tipoprovisionempleadoLogic= new TipoProvisionEmpleadoLogic(connexion);
				tipoprovisionempleadoLogic.deepLoad(provisionempleado.getTipoProvisionEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DefiProvisionEmpleado.class)) {
				provisionempleado.setDefiProvisionEmpleado(provisionempleadoDataAccess.getDefiProvisionEmpleado(connexion,provisionempleado));
				DefiProvisionEmpleadoLogic defiprovisionempleadoLogic= new DefiProvisionEmpleadoLogic(connexion);
				defiprovisionempleadoLogic.deepLoad(provisionempleado.getDefiProvisionEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				provisionempleado.setAnio(provisionempleadoDataAccess.getAnio(connexion,provisionempleado));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(provisionempleado.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				provisionempleado.setMes(provisionempleadoDataAccess.getMes(connexion,provisionempleado));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(provisionempleado.getMes(),isDeep,deepLoadType,clases);				
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
			provisionempleado.setEmpresa(provisionempleadoDataAccess.getEmpresa(connexion,provisionempleado));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(provisionempleado.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			provisionempleado.setEmpleado(provisionempleadoDataAccess.getEmpleado(connexion,provisionempleado));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(provisionempleado.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			provisionempleado.setEstructura(provisionempleadoDataAccess.getEstructura(connexion,provisionempleado));
			EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
			estructuraLogic.deepLoad(provisionempleado.getEstructura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoProvisionEmpleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			provisionempleado.setTipoProvisionEmpleado(provisionempleadoDataAccess.getTipoProvisionEmpleado(connexion,provisionempleado));
			TipoProvisionEmpleadoLogic tipoprovisionempleadoLogic= new TipoProvisionEmpleadoLogic(connexion);
			tipoprovisionempleadoLogic.deepLoad(provisionempleado.getTipoProvisionEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(DefiProvisionEmpleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			provisionempleado.setDefiProvisionEmpleado(provisionempleadoDataAccess.getDefiProvisionEmpleado(connexion,provisionempleado));
			DefiProvisionEmpleadoLogic defiprovisionempleadoLogic= new DefiProvisionEmpleadoLogic(connexion);
			defiprovisionempleadoLogic.deepLoad(provisionempleado.getDefiProvisionEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			provisionempleado.setAnio(provisionempleadoDataAccess.getAnio(connexion,provisionempleado));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(provisionempleado.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			provisionempleado.setMes(provisionempleadoDataAccess.getMes(connexion,provisionempleado));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(provisionempleado.getMes(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ProvisionEmpleado provisionempleado,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ProvisionEmpleadoLogicAdditional.updateProvisionEmpleadoToSave(provisionempleado,this.arrDatoGeneral);
			
ProvisionEmpleadoDataAccess.save(provisionempleado, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(provisionempleado.getEmpresa(),connexion);

		EmpleadoDataAccess.save(provisionempleado.getEmpleado(),connexion);

		EstructuraDataAccess.save(provisionempleado.getEstructura(),connexion);

		TipoProvisionEmpleadoDataAccess.save(provisionempleado.getTipoProvisionEmpleado(),connexion);

		DefiProvisionEmpleadoDataAccess.save(provisionempleado.getDefiProvisionEmpleado(),connexion);

		AnioDataAccess.save(provisionempleado.getAnio(),connexion);

		MesDataAccess.save(provisionempleado.getMes(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(provisionempleado.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(provisionempleado.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(provisionempleado.getEstructura(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoProvisionEmpleado.class)) {
				TipoProvisionEmpleadoDataAccess.save(provisionempleado.getTipoProvisionEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(DefiProvisionEmpleado.class)) {
				DefiProvisionEmpleadoDataAccess.save(provisionempleado.getDefiProvisionEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(provisionempleado.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(provisionempleado.getMes(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(provisionempleado.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(provisionempleado.getEmpresa(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(provisionempleado.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(provisionempleado.getEmpleado(),isDeep,deepLoadType,clases);
				

		EstructuraDataAccess.save(provisionempleado.getEstructura(),connexion);
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(provisionempleado.getEstructura(),isDeep,deepLoadType,clases);
				

		TipoProvisionEmpleadoDataAccess.save(provisionempleado.getTipoProvisionEmpleado(),connexion);
		TipoProvisionEmpleadoLogic tipoprovisionempleadoLogic= new TipoProvisionEmpleadoLogic(connexion);
		tipoprovisionempleadoLogic.deepLoad(provisionempleado.getTipoProvisionEmpleado(),isDeep,deepLoadType,clases);
				

		DefiProvisionEmpleadoDataAccess.save(provisionempleado.getDefiProvisionEmpleado(),connexion);
		DefiProvisionEmpleadoLogic defiprovisionempleadoLogic= new DefiProvisionEmpleadoLogic(connexion);
		defiprovisionempleadoLogic.deepLoad(provisionempleado.getDefiProvisionEmpleado(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(provisionempleado.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(provisionempleado.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(provisionempleado.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(provisionempleado.getMes(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(provisionempleado.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(provisionempleado.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(provisionempleado.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(provisionempleado.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(provisionempleado.getEstructura(),connexion);
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepSave(provisionempleado.getEstructura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoProvisionEmpleado.class)) {
				TipoProvisionEmpleadoDataAccess.save(provisionempleado.getTipoProvisionEmpleado(),connexion);
				TipoProvisionEmpleadoLogic tipoprovisionempleadoLogic= new TipoProvisionEmpleadoLogic(connexion);
				tipoprovisionempleadoLogic.deepSave(provisionempleado.getTipoProvisionEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DefiProvisionEmpleado.class)) {
				DefiProvisionEmpleadoDataAccess.save(provisionempleado.getDefiProvisionEmpleado(),connexion);
				DefiProvisionEmpleadoLogic defiprovisionempleadoLogic= new DefiProvisionEmpleadoLogic(connexion);
				defiprovisionempleadoLogic.deepSave(provisionempleado.getDefiProvisionEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(provisionempleado.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(provisionempleado.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(provisionempleado.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(provisionempleado.getMes(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ProvisionEmpleado.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(provisionempleado,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesProvisionEmpleado(provisionempleado);
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
			this.deepLoad(this.provisionempleado,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesProvisionEmpleado(this.provisionempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ProvisionEmpleado.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(provisionempleados!=null) {
				for(ProvisionEmpleado provisionempleado:provisionempleados) {
					this.deepLoad(provisionempleado,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesProvisionEmpleado(provisionempleados);
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
			if(provisionempleados!=null) {
				for(ProvisionEmpleado provisionempleado:provisionempleados) {
					this.deepLoad(provisionempleado,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesProvisionEmpleado(provisionempleados);
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
			this.getNewConnexionToDeep(ProvisionEmpleado.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(provisionempleado,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ProvisionEmpleado.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(provisionempleados!=null) {
				for(ProvisionEmpleado provisionempleado:provisionempleados) {
					this.deepSave(provisionempleado,isDeep,deepLoadType,clases);
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
			if(provisionempleados!=null) {
				for(ProvisionEmpleado provisionempleado:provisionempleados) {
					this.deepSave(provisionempleado,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getProvisionEmpleadosFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProvisionEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,ProvisionEmpleadoConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			ProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			provisionempleados=provisionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesProvisionEmpleado(this.provisionempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProvisionEmpleadosFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,ProvisionEmpleadoConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			ProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			provisionempleados=provisionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesProvisionEmpleado(this.provisionempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProvisionEmpleadosFK_IdDefiProvisionEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_defi_provision_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProvisionEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDefiProvisionEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDefiProvisionEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_defi_provision_empleado,ProvisionEmpleadoConstantesFunciones.IDDEFIPROVISIONEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDefiProvisionEmpleado);

			ProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDefiProvisionEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			provisionempleados=provisionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesProvisionEmpleado(this.provisionempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProvisionEmpleadosFK_IdDefiProvisionEmpleado(String sFinalQuery,Pagination pagination,Long id_defi_provision_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDefiProvisionEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDefiProvisionEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_defi_provision_empleado,ProvisionEmpleadoConstantesFunciones.IDDEFIPROVISIONEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDefiProvisionEmpleado);

			ProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDefiProvisionEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			provisionempleados=provisionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesProvisionEmpleado(this.provisionempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProvisionEmpleadosFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProvisionEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,ProvisionEmpleadoConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			ProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			provisionempleados=provisionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesProvisionEmpleado(this.provisionempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProvisionEmpleadosFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,ProvisionEmpleadoConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			ProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			provisionempleados=provisionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesProvisionEmpleado(this.provisionempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProvisionEmpleadosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProvisionEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ProvisionEmpleadoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			provisionempleados=provisionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesProvisionEmpleado(this.provisionempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProvisionEmpleadosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ProvisionEmpleadoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			provisionempleados=provisionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesProvisionEmpleado(this.provisionempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProvisionEmpleadosFK_IdEstructuraWithConnection(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProvisionEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,ProvisionEmpleadoConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			ProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			provisionempleados=provisionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesProvisionEmpleado(this.provisionempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProvisionEmpleadosFK_IdEstructura(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,ProvisionEmpleadoConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			ProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			provisionempleados=provisionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesProvisionEmpleado(this.provisionempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProvisionEmpleadosFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProvisionEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,ProvisionEmpleadoConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			ProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			provisionempleados=provisionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesProvisionEmpleado(this.provisionempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProvisionEmpleadosFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,ProvisionEmpleadoConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			ProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			provisionempleados=provisionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesProvisionEmpleado(this.provisionempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getProvisionEmpleadosFK_IdTipoProvisionEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_provision_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ProvisionEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProvisionEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProvisionEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_provision_empleado,ProvisionEmpleadoConstantesFunciones.IDTIPOPROVISIONEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProvisionEmpleado);

			ProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoProvisionEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			provisionempleados=provisionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesProvisionEmpleado(this.provisionempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getProvisionEmpleadosFK_IdTipoProvisionEmpleado(String sFinalQuery,Pagination pagination,Long id_tipo_provision_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoProvisionEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoProvisionEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_provision_empleado,ProvisionEmpleadoConstantesFunciones.IDTIPOPROVISIONEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoProvisionEmpleado);

			ProvisionEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoProvisionEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			provisionempleados=provisionempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesProvisionEmpleado(this.provisionempleados);
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
			if(ProvisionEmpleadoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ProvisionEmpleadoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ProvisionEmpleado provisionempleado,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ProvisionEmpleadoConstantesFunciones.ISCONAUDITORIA) {
				if(provisionempleado.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProvisionEmpleadoDataAccess.TABLENAME, provisionempleado.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProvisionEmpleadoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProvisionEmpleadoLogic.registrarAuditoriaDetallesProvisionEmpleado(connexion,provisionempleado,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(provisionempleado.getIsDeleted()) {
					/*if(!provisionempleado.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ProvisionEmpleadoDataAccess.TABLENAME, provisionempleado.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ProvisionEmpleadoLogic.registrarAuditoriaDetallesProvisionEmpleado(connexion,provisionempleado,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProvisionEmpleadoDataAccess.TABLENAME, provisionempleado.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(provisionempleado.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ProvisionEmpleadoDataAccess.TABLENAME, provisionempleado.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ProvisionEmpleadoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ProvisionEmpleadoLogic.registrarAuditoriaDetallesProvisionEmpleado(connexion,provisionempleado,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesProvisionEmpleado(Connexion connexion,ProvisionEmpleado provisionempleado)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(provisionempleado.getIsNew()||!provisionempleado.getid_empresa().equals(provisionempleado.getProvisionEmpleadoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(provisionempleado.getProvisionEmpleadoOriginal().getid_empresa()!=null)
				{
					strValorActual=provisionempleado.getProvisionEmpleadoOriginal().getid_empresa().toString();
				}
				if(provisionempleado.getid_empresa()!=null)
				{
					strValorNuevo=provisionempleado.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProvisionEmpleadoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(provisionempleado.getIsNew()||!provisionempleado.getid_empleado().equals(provisionempleado.getProvisionEmpleadoOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(provisionempleado.getProvisionEmpleadoOriginal().getid_empleado()!=null)
				{
					strValorActual=provisionempleado.getProvisionEmpleadoOriginal().getid_empleado().toString();
				}
				if(provisionempleado.getid_empleado()!=null)
				{
					strValorNuevo=provisionempleado.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProvisionEmpleadoConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(provisionempleado.getIsNew()||!provisionempleado.getid_estructura().equals(provisionempleado.getProvisionEmpleadoOriginal().getid_estructura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(provisionempleado.getProvisionEmpleadoOriginal().getid_estructura()!=null)
				{
					strValorActual=provisionempleado.getProvisionEmpleadoOriginal().getid_estructura().toString();
				}
				if(provisionempleado.getid_estructura()!=null)
				{
					strValorNuevo=provisionempleado.getid_estructura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProvisionEmpleadoConstantesFunciones.IDESTRUCTURA,strValorActual,strValorNuevo);
			}	
			
			if(provisionempleado.getIsNew()||!provisionempleado.getid_tipo_provision_empleado().equals(provisionempleado.getProvisionEmpleadoOriginal().getid_tipo_provision_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(provisionempleado.getProvisionEmpleadoOriginal().getid_tipo_provision_empleado()!=null)
				{
					strValorActual=provisionempleado.getProvisionEmpleadoOriginal().getid_tipo_provision_empleado().toString();
				}
				if(provisionempleado.getid_tipo_provision_empleado()!=null)
				{
					strValorNuevo=provisionempleado.getid_tipo_provision_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProvisionEmpleadoConstantesFunciones.IDTIPOPROVISIONEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(provisionempleado.getIsNew()||!provisionempleado.getid_defi_provision_empleado().equals(provisionempleado.getProvisionEmpleadoOriginal().getid_defi_provision_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(provisionempleado.getProvisionEmpleadoOriginal().getid_defi_provision_empleado()!=null)
				{
					strValorActual=provisionempleado.getProvisionEmpleadoOriginal().getid_defi_provision_empleado().toString();
				}
				if(provisionempleado.getid_defi_provision_empleado()!=null)
				{
					strValorNuevo=provisionempleado.getid_defi_provision_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProvisionEmpleadoConstantesFunciones.IDDEFIPROVISIONEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(provisionempleado.getIsNew()||!provisionempleado.getid_anio().equals(provisionempleado.getProvisionEmpleadoOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(provisionempleado.getProvisionEmpleadoOriginal().getid_anio()!=null)
				{
					strValorActual=provisionempleado.getProvisionEmpleadoOriginal().getid_anio().toString();
				}
				if(provisionempleado.getid_anio()!=null)
				{
					strValorNuevo=provisionempleado.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProvisionEmpleadoConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(provisionempleado.getIsNew()||!provisionempleado.getid_mes().equals(provisionempleado.getProvisionEmpleadoOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(provisionempleado.getProvisionEmpleadoOriginal().getid_mes()!=null)
				{
					strValorActual=provisionempleado.getProvisionEmpleadoOriginal().getid_mes().toString();
				}
				if(provisionempleado.getid_mes()!=null)
				{
					strValorNuevo=provisionempleado.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProvisionEmpleadoConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(provisionempleado.getIsNew()||!provisionempleado.getfecha().equals(provisionempleado.getProvisionEmpleadoOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(provisionempleado.getProvisionEmpleadoOriginal().getfecha()!=null)
				{
					strValorActual=provisionempleado.getProvisionEmpleadoOriginal().getfecha().toString();
				}
				if(provisionempleado.getfecha()!=null)
				{
					strValorNuevo=provisionempleado.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProvisionEmpleadoConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(provisionempleado.getIsNew()||!provisionempleado.getfecha_liquidacion().equals(provisionempleado.getProvisionEmpleadoOriginal().getfecha_liquidacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(provisionempleado.getProvisionEmpleadoOriginal().getfecha_liquidacion()!=null)
				{
					strValorActual=provisionempleado.getProvisionEmpleadoOriginal().getfecha_liquidacion().toString();
				}
				if(provisionempleado.getfecha_liquidacion()!=null)
				{
					strValorNuevo=provisionempleado.getfecha_liquidacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProvisionEmpleadoConstantesFunciones.FECHALIQUIDACION,strValorActual,strValorNuevo);
			}	
			
			if(provisionempleado.getIsNew()||!provisionempleado.getvalor_mes().equals(provisionempleado.getProvisionEmpleadoOriginal().getvalor_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(provisionempleado.getProvisionEmpleadoOriginal().getvalor_mes()!=null)
				{
					strValorActual=provisionempleado.getProvisionEmpleadoOriginal().getvalor_mes().toString();
				}
				if(provisionempleado.getvalor_mes()!=null)
				{
					strValorNuevo=provisionempleado.getvalor_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProvisionEmpleadoConstantesFunciones.VALORMES,strValorActual,strValorNuevo);
			}	
			
			if(provisionempleado.getIsNew()||!provisionempleado.getvalor_paga().equals(provisionempleado.getProvisionEmpleadoOriginal().getvalor_paga()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(provisionempleado.getProvisionEmpleadoOriginal().getvalor_paga()!=null)
				{
					strValorActual=provisionempleado.getProvisionEmpleadoOriginal().getvalor_paga().toString();
				}
				if(provisionempleado.getvalor_paga()!=null)
				{
					strValorNuevo=provisionempleado.getvalor_paga().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProvisionEmpleadoConstantesFunciones.VALORPAGA,strValorActual,strValorNuevo);
			}	
			
			if(provisionempleado.getIsNew()||!provisionempleado.getvalor_vacacion().equals(provisionempleado.getProvisionEmpleadoOriginal().getvalor_vacacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(provisionempleado.getProvisionEmpleadoOriginal().getvalor_vacacion()!=null)
				{
					strValorActual=provisionempleado.getProvisionEmpleadoOriginal().getvalor_vacacion().toString();
				}
				if(provisionempleado.getvalor_vacacion()!=null)
				{
					strValorNuevo=provisionempleado.getvalor_vacacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProvisionEmpleadoConstantesFunciones.VALORVACACION,strValorActual,strValorNuevo);
			}	
			
			if(provisionempleado.getIsNew()||!provisionempleado.getvalor_liquidacion().equals(provisionempleado.getProvisionEmpleadoOriginal().getvalor_liquidacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(provisionempleado.getProvisionEmpleadoOriginal().getvalor_liquidacion()!=null)
				{
					strValorActual=provisionempleado.getProvisionEmpleadoOriginal().getvalor_liquidacion().toString();
				}
				if(provisionempleado.getvalor_liquidacion()!=null)
				{
					strValorNuevo=provisionempleado.getvalor_liquidacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ProvisionEmpleadoConstantesFunciones.VALORLIQUIDACION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveProvisionEmpleadoRelacionesWithConnection(ProvisionEmpleado provisionempleado) throws Exception {

		if(!provisionempleado.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProvisionEmpleadoRelacionesBase(provisionempleado,true);
		}
	}

	public void saveProvisionEmpleadoRelaciones(ProvisionEmpleado provisionempleado)throws Exception {

		if(!provisionempleado.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveProvisionEmpleadoRelacionesBase(provisionempleado,false);
		}
	}

	public void saveProvisionEmpleadoRelacionesBase(ProvisionEmpleado provisionempleado,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ProvisionEmpleado-saveRelacionesWithConnection");}
	

			this.setProvisionEmpleado(provisionempleado);

			if(ProvisionEmpleadoLogicAdditional.validarSaveRelaciones(provisionempleado,this)) {

				ProvisionEmpleadoLogicAdditional.updateRelacionesToSave(provisionempleado,this);

				if((provisionempleado.getIsNew()||provisionempleado.getIsChanged())&&!provisionempleado.getIsDeleted()) {
					this.saveProvisionEmpleado();
					this.saveProvisionEmpleadoRelacionesDetalles();

				} else if(provisionempleado.getIsDeleted()) {
					this.saveProvisionEmpleadoRelacionesDetalles();
					this.saveProvisionEmpleado();
				}

				ProvisionEmpleadoLogicAdditional.updateRelacionesToSaveAfter(provisionempleado,this);

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
	
	
	private void saveProvisionEmpleadoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfProvisionEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProvisionEmpleadoConstantesFunciones.getClassesForeignKeysOfProvisionEmpleado(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfProvisionEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ProvisionEmpleadoConstantesFunciones.getClassesRelationshipsOfProvisionEmpleado(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

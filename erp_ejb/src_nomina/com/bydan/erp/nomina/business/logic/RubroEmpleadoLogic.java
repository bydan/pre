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
import com.bydan.erp.nomina.util.RubroEmpleadoConstantesFunciones;
import com.bydan.erp.nomina.util.RubroEmpleadoParameterReturnGeneral;
//import com.bydan.erp.nomina.util.RubroEmpleadoParameterGeneral;
import com.bydan.erp.nomina.business.entity.RubroEmpleado;
import com.bydan.erp.nomina.business.logic.RubroEmpleadoLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class RubroEmpleadoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(RubroEmpleadoLogic.class);
	
	protected RubroEmpleadoDataAccess rubroempleadoDataAccess; 	
	protected RubroEmpleado rubroempleado;
	protected List<RubroEmpleado> rubroempleados;
	protected Object rubroempleadoObject;	
	protected List<Object> rubroempleadosObject;
	
	public static ClassValidator<RubroEmpleado> rubroempleadoValidator = new ClassValidator<RubroEmpleado>(RubroEmpleado.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected RubroEmpleadoLogicAdditional rubroempleadoLogicAdditional=null;
	
	public RubroEmpleadoLogicAdditional getRubroEmpleadoLogicAdditional() {
		return this.rubroempleadoLogicAdditional;
	}
	
	public void setRubroEmpleadoLogicAdditional(RubroEmpleadoLogicAdditional rubroempleadoLogicAdditional) {
		try {
			this.rubroempleadoLogicAdditional=rubroempleadoLogicAdditional;
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
	
	
	
	
	public  RubroEmpleadoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.rubroempleadoDataAccess = new RubroEmpleadoDataAccess();
			
			this.rubroempleados= new ArrayList<RubroEmpleado>();
			this.rubroempleado= new RubroEmpleado();
			
			this.rubroempleadoObject=new Object();
			this.rubroempleadosObject=new ArrayList<Object>();
				
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
			
			this.rubroempleadoDataAccess.setConnexionType(this.connexionType);
			this.rubroempleadoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  RubroEmpleadoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.rubroempleadoDataAccess = new RubroEmpleadoDataAccess();
			this.rubroempleados= new ArrayList<RubroEmpleado>();
			this.rubroempleado= new RubroEmpleado();
			this.rubroempleadoObject=new Object();
			this.rubroempleadosObject=new ArrayList<Object>();
			
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
			
			this.rubroempleadoDataAccess.setConnexionType(this.connexionType);
			this.rubroempleadoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public RubroEmpleado getRubroEmpleado() throws Exception {	
		RubroEmpleadoLogicAdditional.checkRubroEmpleadoToGet(rubroempleado,this.datosCliente,this.arrDatoGeneral);
		RubroEmpleadoLogicAdditional.updateRubroEmpleadoToGet(rubroempleado,this.arrDatoGeneral);
		
		return rubroempleado;
	}
		
	public void setRubroEmpleado(RubroEmpleado newRubroEmpleado) {
		this.rubroempleado = newRubroEmpleado;
	}
	
	public RubroEmpleadoDataAccess getRubroEmpleadoDataAccess() {
		return rubroempleadoDataAccess;
	}
	
	public void setRubroEmpleadoDataAccess(RubroEmpleadoDataAccess newrubroempleadoDataAccess) {
		this.rubroempleadoDataAccess = newrubroempleadoDataAccess;
	}
	
	public List<RubroEmpleado> getRubroEmpleados() throws Exception {		
		this.quitarRubroEmpleadosNulos();
		
		RubroEmpleadoLogicAdditional.checkRubroEmpleadoToGets(rubroempleados,this.datosCliente,this.arrDatoGeneral);
		
		for (RubroEmpleado rubroempleadoLocal: rubroempleados ) {
			RubroEmpleadoLogicAdditional.updateRubroEmpleadoToGet(rubroempleadoLocal,this.arrDatoGeneral);
		}
		
		return rubroempleados;
	}
	
	public void setRubroEmpleados(List<RubroEmpleado> newRubroEmpleados) {
		this.rubroempleados = newRubroEmpleados;
	}
	
	public Object getRubroEmpleadoObject() {	
		this.rubroempleadoObject=this.rubroempleadoDataAccess.getEntityObject();
		return this.rubroempleadoObject;
	}
		
	public void setRubroEmpleadoObject(Object newRubroEmpleadoObject) {
		this.rubroempleadoObject = newRubroEmpleadoObject;
	}
	
	public List<Object> getRubroEmpleadosObject() {		
		this.rubroempleadosObject=this.rubroempleadoDataAccess.getEntitiesObject();
		return this.rubroempleadosObject;
	}
		
	public void setRubroEmpleadosObject(List<Object> newRubroEmpleadosObject) {
		this.rubroempleadosObject = newRubroEmpleadosObject;
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
		
		if(this.rubroempleadoDataAccess!=null) {
			this.rubroempleadoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleado.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			rubroempleadoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			rubroempleadoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		rubroempleado = new  RubroEmpleado();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			rubroempleado=rubroempleadoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.rubroempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RubroEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleado(this.rubroempleado);
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
		rubroempleado = new  RubroEmpleado();
		  		  
        try {
			
			rubroempleado=rubroempleadoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.rubroempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RubroEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleado(this.rubroempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		rubroempleado = new  RubroEmpleado();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			rubroempleado=rubroempleadoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.rubroempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RubroEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleado(this.rubroempleado);
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
		rubroempleado = new  RubroEmpleado();
		  		  
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
		rubroempleado = new  RubroEmpleado();
		  		  
        try {
			
			rubroempleado=rubroempleadoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.rubroempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RubroEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleado(this.rubroempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		rubroempleado = new  RubroEmpleado();
		  		  
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
		rubroempleado = new  RubroEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleado.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =rubroempleadoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		rubroempleado = new  RubroEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=rubroempleadoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		rubroempleado = new  RubroEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleado.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =rubroempleadoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		rubroempleado = new  RubroEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=rubroempleadoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		rubroempleado = new  RubroEmpleado();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleado.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =rubroempleadoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		rubroempleado = new  RubroEmpleado();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=rubroempleadoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		rubroempleados = new  ArrayList<RubroEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			RubroEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroempleados=rubroempleadoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRubroEmpleado(rubroempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleado(this.rubroempleados);
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
		rubroempleados = new  ArrayList<RubroEmpleado>();
		  		  
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
		rubroempleados = new  ArrayList<RubroEmpleado>();
		  		  
        try {			
			RubroEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroempleados=rubroempleadoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarRubroEmpleado(rubroempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleado(this.rubroempleados);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		rubroempleados = new  ArrayList<RubroEmpleado>();
		  		  
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
		rubroempleados = new  ArrayList<RubroEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			RubroEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroempleados=rubroempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRubroEmpleado(rubroempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleado(this.rubroempleados);
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
		rubroempleados = new  ArrayList<RubroEmpleado>();
		  		  
        try {
			RubroEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroempleados=rubroempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRubroEmpleado(rubroempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleado(this.rubroempleados);
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
		rubroempleados = new  ArrayList<RubroEmpleado>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleado.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RubroEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroempleados=rubroempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRubroEmpleado(rubroempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleado(this.rubroempleados);
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
		rubroempleados = new  ArrayList<RubroEmpleado>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RubroEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroempleados=rubroempleadoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRubroEmpleado(rubroempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleado(this.rubroempleados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		rubroempleado = new  RubroEmpleado();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleado.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RubroEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroempleado=rubroempleadoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRubroEmpleado(rubroempleado);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleado(this.rubroempleado);
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
		rubroempleado = new  RubroEmpleado();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RubroEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroempleado=rubroempleadoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRubroEmpleado(rubroempleado);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleado(this.rubroempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		rubroempleados = new  ArrayList<RubroEmpleado>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleado.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			RubroEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroempleados=rubroempleadoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRubroEmpleado(rubroempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleado(this.rubroempleados);
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
		rubroempleados = new  ArrayList<RubroEmpleado>();
		  		  
        try {
			RubroEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroempleados=rubroempleadoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRubroEmpleado(rubroempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleado(this.rubroempleados);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosRubroEmpleadosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		rubroempleados = new  ArrayList<RubroEmpleado>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleado.class.getSimpleName()+"-getTodosRubroEmpleadosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RubroEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroempleados=rubroempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarRubroEmpleado(rubroempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleado(this.rubroempleados);
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
	
	public  void  getTodosRubroEmpleados(String sFinalQuery,Pagination pagination)throws Exception {
		rubroempleados = new  ArrayList<RubroEmpleado>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RubroEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroempleados=rubroempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarRubroEmpleado(rubroempleados);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleado(this.rubroempleados);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarRubroEmpleado(RubroEmpleado rubroempleado) throws Exception {
		Boolean estaValidado=false;
		
		if(rubroempleado.getIsNew() || rubroempleado.getIsChanged()) { 
			this.invalidValues = rubroempleadoValidator.getInvalidValues(rubroempleado);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(rubroempleado);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarRubroEmpleado(List<RubroEmpleado> RubroEmpleados) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(RubroEmpleado rubroempleadoLocal:rubroempleados) {				
			estaValidadoObjeto=this.validarGuardarRubroEmpleado(rubroempleadoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarRubroEmpleado(List<RubroEmpleado> RubroEmpleados) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarRubroEmpleado(rubroempleados)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarRubroEmpleado(RubroEmpleado RubroEmpleado) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarRubroEmpleado(rubroempleado)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(RubroEmpleado rubroempleado) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+rubroempleado.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=RubroEmpleadoConstantesFunciones.getRubroEmpleadoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"rubroempleado","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(RubroEmpleadoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(RubroEmpleadoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveRubroEmpleadoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleado.class.getSimpleName()+"-saveRubroEmpleadoWithConnection");connexion.begin();			
			
			RubroEmpleadoLogicAdditional.checkRubroEmpleadoToSave(this.rubroempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			RubroEmpleadoLogicAdditional.updateRubroEmpleadoToSave(this.rubroempleado,this.arrDatoGeneral);
			
			RubroEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.rubroempleado,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowRubroEmpleado();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarRubroEmpleado(this.rubroempleado)) {
				RubroEmpleadoDataAccess.save(this.rubroempleado, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.rubroempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			RubroEmpleadoLogicAdditional.checkRubroEmpleadoToSaveAfter(this.rubroempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowRubroEmpleado();
			
			connexion.commit();			
			
			if(this.rubroempleado.getIsDeleted()) {
				this.rubroempleado=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveRubroEmpleado()throws Exception {	
		try {	
			
			RubroEmpleadoLogicAdditional.checkRubroEmpleadoToSave(this.rubroempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			RubroEmpleadoLogicAdditional.updateRubroEmpleadoToSave(this.rubroempleado,this.arrDatoGeneral);
			
			RubroEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.rubroempleado,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarRubroEmpleado(this.rubroempleado)) {			
				RubroEmpleadoDataAccess.save(this.rubroempleado, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.rubroempleado,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			RubroEmpleadoLogicAdditional.checkRubroEmpleadoToSaveAfter(this.rubroempleado,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.rubroempleado.getIsDeleted()) {
				this.rubroempleado=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveRubroEmpleadosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleado.class.getSimpleName()+"-saveRubroEmpleadosWithConnection");connexion.begin();			
			
			RubroEmpleadoLogicAdditional.checkRubroEmpleadoToSaves(rubroempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowRubroEmpleados();
			
			Boolean validadoTodosRubroEmpleado=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(RubroEmpleado rubroempleadoLocal:rubroempleados) {		
				if(rubroempleadoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				RubroEmpleadoLogicAdditional.updateRubroEmpleadoToSave(rubroempleadoLocal,this.arrDatoGeneral);
	        	
				RubroEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),rubroempleadoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarRubroEmpleado(rubroempleadoLocal)) {
					RubroEmpleadoDataAccess.save(rubroempleadoLocal, connexion);				
				} else {
					validadoTodosRubroEmpleado=false;
				}
			}
			
			if(!validadoTodosRubroEmpleado) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			RubroEmpleadoLogicAdditional.checkRubroEmpleadoToSavesAfter(rubroempleados,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowRubroEmpleados();
			
			connexion.commit();		
			
			this.quitarRubroEmpleadosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveRubroEmpleados()throws Exception {				
		 try {	
			RubroEmpleadoLogicAdditional.checkRubroEmpleadoToSaves(rubroempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosRubroEmpleado=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(RubroEmpleado rubroempleadoLocal:rubroempleados) {				
				if(rubroempleadoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				RubroEmpleadoLogicAdditional.updateRubroEmpleadoToSave(rubroempleadoLocal,this.arrDatoGeneral);
	        	
				RubroEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),rubroempleadoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarRubroEmpleado(rubroempleadoLocal)) {				
					RubroEmpleadoDataAccess.save(rubroempleadoLocal, connexion);				
				} else {
					validadoTodosRubroEmpleado=false;
				}
			}
			
			if(!validadoTodosRubroEmpleado) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			RubroEmpleadoLogicAdditional.checkRubroEmpleadoToSavesAfter(rubroempleados,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarRubroEmpleadosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RubroEmpleadoParameterReturnGeneral procesarAccionRubroEmpleados(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<RubroEmpleado> rubroempleados,RubroEmpleadoParameterReturnGeneral rubroempleadoParameterGeneral)throws Exception {
		 try {	
			RubroEmpleadoParameterReturnGeneral rubroempleadoReturnGeneral=new RubroEmpleadoParameterReturnGeneral();
	
			RubroEmpleadoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,rubroempleados,rubroempleadoParameterGeneral,rubroempleadoReturnGeneral);
			
			return rubroempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RubroEmpleadoParameterReturnGeneral procesarAccionRubroEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<RubroEmpleado> rubroempleados,RubroEmpleadoParameterReturnGeneral rubroempleadoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleado.class.getSimpleName()+"-procesarAccionRubroEmpleadosWithConnection");connexion.begin();			
			
			RubroEmpleadoParameterReturnGeneral rubroempleadoReturnGeneral=new RubroEmpleadoParameterReturnGeneral();
	
			RubroEmpleadoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,rubroempleados,rubroempleadoParameterGeneral,rubroempleadoReturnGeneral);
			
			this.connexion.commit();
			
			return rubroempleadoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public RubroEmpleadoParameterReturnGeneral procesarEventosRubroEmpleados(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<RubroEmpleado> rubroempleados,RubroEmpleado rubroempleado,RubroEmpleadoParameterReturnGeneral rubroempleadoParameterGeneral,Boolean isEsNuevoRubroEmpleado,ArrayList<Classe> clases)throws Exception {
		 try {	
			RubroEmpleadoParameterReturnGeneral rubroempleadoReturnGeneral=new RubroEmpleadoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				rubroempleadoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			RubroEmpleadoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,rubroempleados,rubroempleado,rubroempleadoParameterGeneral,rubroempleadoReturnGeneral,isEsNuevoRubroEmpleado,clases);
			
			return rubroempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public RubroEmpleadoParameterReturnGeneral procesarEventosRubroEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<RubroEmpleado> rubroempleados,RubroEmpleado rubroempleado,RubroEmpleadoParameterReturnGeneral rubroempleadoParameterGeneral,Boolean isEsNuevoRubroEmpleado,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleado.class.getSimpleName()+"-procesarEventosRubroEmpleadosWithConnection");connexion.begin();			
			
			RubroEmpleadoParameterReturnGeneral rubroempleadoReturnGeneral=new RubroEmpleadoParameterReturnGeneral();
	
			rubroempleadoReturnGeneral.setRubroEmpleado(rubroempleado);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				rubroempleadoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			RubroEmpleadoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,rubroempleados,rubroempleado,rubroempleadoParameterGeneral,rubroempleadoReturnGeneral,isEsNuevoRubroEmpleado,clases);
			
			this.connexion.commit();
			
			return rubroempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public RubroEmpleadoParameterReturnGeneral procesarImportacionRubroEmpleadosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,RubroEmpleadoParameterReturnGeneral rubroempleadoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleado.class.getSimpleName()+"-procesarImportacionRubroEmpleadosWithConnection");connexion.begin();			
			
			RubroEmpleadoParameterReturnGeneral rubroempleadoReturnGeneral=new RubroEmpleadoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.rubroempleados=new ArrayList<RubroEmpleado>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.rubroempleado=new RubroEmpleado();
				
				
				if(conColumnasBase) {this.rubroempleado.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.rubroempleado.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.rubroempleado.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.rubroempleados.add(this.rubroempleado);
			}
			
			this.saveRubroEmpleados();
			
			this.connexion.commit();
			
			rubroempleadoReturnGeneral.setConRetornoEstaProcesado(true);
			rubroempleadoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return rubroempleadoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarRubroEmpleadosEliminados() throws Exception {				
		
		List<RubroEmpleado> rubroempleadosAux= new ArrayList<RubroEmpleado>();
		
		for(RubroEmpleado rubroempleado:rubroempleados) {
			if(!rubroempleado.getIsDeleted()) {
				rubroempleadosAux.add(rubroempleado);
			}
		}
		
		rubroempleados=rubroempleadosAux;
	}
	
	public void quitarRubroEmpleadosNulos() throws Exception {				
		
		List<RubroEmpleado> rubroempleadosAux= new ArrayList<RubroEmpleado>();
		
		for(RubroEmpleado rubroempleado : this.rubroempleados) {
			if(rubroempleado==null) {
				rubroempleadosAux.add(rubroempleado);
			}
		}
		
		//this.rubroempleados=rubroempleadosAux;
		
		this.rubroempleados.removeAll(rubroempleadosAux);
	}
	
	public void getSetVersionRowRubroEmpleadoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(rubroempleado.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((rubroempleado.getIsDeleted() || (rubroempleado.getIsChanged()&&!rubroempleado.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=rubroempleadoDataAccess.getSetVersionRowRubroEmpleado(connexion,rubroempleado.getId());
				
				if(!rubroempleado.getVersionRow().equals(timestamp)) {	
					rubroempleado.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				rubroempleado.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowRubroEmpleado()throws Exception {	
		
		if(rubroempleado.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((rubroempleado.getIsDeleted() || (rubroempleado.getIsChanged()&&!rubroempleado.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=rubroempleadoDataAccess.getSetVersionRowRubroEmpleado(connexion,rubroempleado.getId());
			
			try {							
				if(!rubroempleado.getVersionRow().equals(timestamp)) {	
					rubroempleado.setVersionRow(timestamp);
				}
				
				rubroempleado.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowRubroEmpleadosWithConnection()throws Exception {	
		if(rubroempleados!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(RubroEmpleado rubroempleadoAux:rubroempleados) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(rubroempleadoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(rubroempleadoAux.getIsDeleted() || (rubroempleadoAux.getIsChanged()&&!rubroempleadoAux.getIsNew())) {
						
						timestamp=rubroempleadoDataAccess.getSetVersionRowRubroEmpleado(connexion,rubroempleadoAux.getId());
						
						if(!rubroempleado.getVersionRow().equals(timestamp)) {	
							rubroempleadoAux.setVersionRow(timestamp);
						}
								
						rubroempleadoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowRubroEmpleados()throws Exception {	
		if(rubroempleados!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(RubroEmpleado rubroempleadoAux:rubroempleados) {
					if(rubroempleadoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(rubroempleadoAux.getIsDeleted() || (rubroempleadoAux.getIsChanged()&&!rubroempleadoAux.getIsNew())) {
						
						timestamp=rubroempleadoDataAccess.getSetVersionRowRubroEmpleado(connexion,rubroempleadoAux.getId());
						
						if(!rubroempleadoAux.getVersionRow().equals(timestamp)) {	
							rubroempleadoAux.setVersionRow(timestamp);
						}
						
													
						rubroempleadoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public RubroEmpleadoParameterReturnGeneral cargarCombosLoteForeignKeyRubroEmpleadoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalRubroEmplea,String finalQueryGlobalEstadoRubro) throws Exception {
		RubroEmpleadoParameterReturnGeneral  rubroempleadoReturnGeneral =new RubroEmpleadoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleado.class.getSimpleName()+"-cargarCombosLoteForeignKeyRubroEmpleadoWithConnection");connexion.begin();
			
			rubroempleadoReturnGeneral =new RubroEmpleadoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			rubroempleadoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			rubroempleadoReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<RubroEmplea> rubroempleasForeignKey=new ArrayList<RubroEmplea>();
			RubroEmpleaLogic rubroempleaLogic=new RubroEmpleaLogic();
			rubroempleaLogic.setConnexion(this.connexion);
			rubroempleaLogic.getRubroEmpleaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRubroEmplea.equals("NONE")) {
				rubroempleaLogic.getTodosRubroEmpleas(finalQueryGlobalRubroEmplea,new Pagination());
				rubroempleasForeignKey=rubroempleaLogic.getRubroEmpleas();
			}

			rubroempleadoReturnGeneral.setrubroempleasForeignKey(rubroempleasForeignKey);


			List<EstadoRubro> estadorubrosForeignKey=new ArrayList<EstadoRubro>();
			EstadoRubroLogic estadorubroLogic=new EstadoRubroLogic();
			estadorubroLogic.setConnexion(this.connexion);
			estadorubroLogic.getEstadoRubroDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoRubro.equals("NONE")) {
				estadorubroLogic.getTodosEstadoRubros(finalQueryGlobalEstadoRubro,new Pagination());
				estadorubrosForeignKey=estadorubroLogic.getEstadoRubros();
			}

			rubroempleadoReturnGeneral.setestadorubrosForeignKey(estadorubrosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return rubroempleadoReturnGeneral;
	}
	
	public RubroEmpleadoParameterReturnGeneral cargarCombosLoteForeignKeyRubroEmpleado(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalRubroEmplea,String finalQueryGlobalEstadoRubro) throws Exception {
		RubroEmpleadoParameterReturnGeneral  rubroempleadoReturnGeneral =new RubroEmpleadoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			rubroempleadoReturnGeneral =new RubroEmpleadoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			rubroempleadoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			rubroempleadoReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<RubroEmplea> rubroempleasForeignKey=new ArrayList<RubroEmplea>();
			RubroEmpleaLogic rubroempleaLogic=new RubroEmpleaLogic();
			rubroempleaLogic.setConnexion(this.connexion);
			rubroempleaLogic.getRubroEmpleaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRubroEmplea.equals("NONE")) {
				rubroempleaLogic.getTodosRubroEmpleas(finalQueryGlobalRubroEmplea,new Pagination());
				rubroempleasForeignKey=rubroempleaLogic.getRubroEmpleas();
			}

			rubroempleadoReturnGeneral.setrubroempleasForeignKey(rubroempleasForeignKey);


			List<EstadoRubro> estadorubrosForeignKey=new ArrayList<EstadoRubro>();
			EstadoRubroLogic estadorubroLogic=new EstadoRubroLogic();
			estadorubroLogic.setConnexion(this.connexion);
			estadorubroLogic.getEstadoRubroDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstadoRubro.equals("NONE")) {
				estadorubroLogic.getTodosEstadoRubros(finalQueryGlobalEstadoRubro,new Pagination());
				estadorubrosForeignKey=estadorubroLogic.getEstadoRubros();
			}

			rubroempleadoReturnGeneral.setestadorubrosForeignKey(estadorubrosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return rubroempleadoReturnGeneral;
	}
	
	
	public void deepLoad(RubroEmpleado rubroempleado,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			RubroEmpleadoLogicAdditional.updateRubroEmpleadoToGet(rubroempleado,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		rubroempleado.setEmpresa(rubroempleadoDataAccess.getEmpresa(connexion,rubroempleado));
		rubroempleado.setEmpleado(rubroempleadoDataAccess.getEmpleado(connexion,rubroempleado));
		rubroempleado.setRubroEmplea(rubroempleadoDataAccess.getRubroEmplea(connexion,rubroempleado));
		rubroempleado.setEstadoRubro(rubroempleadoDataAccess.getEstadoRubro(connexion,rubroempleado));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				rubroempleado.setEmpresa(rubroempleadoDataAccess.getEmpresa(connexion,rubroempleado));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				rubroempleado.setEmpleado(rubroempleadoDataAccess.getEmpleado(connexion,rubroempleado));
				continue;
			}

			if(clas.clas.equals(RubroEmplea.class)) {
				rubroempleado.setRubroEmplea(rubroempleadoDataAccess.getRubroEmplea(connexion,rubroempleado));
				continue;
			}

			if(clas.clas.equals(EstadoRubro.class)) {
				rubroempleado.setEstadoRubro(rubroempleadoDataAccess.getEstadoRubro(connexion,rubroempleado));
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
			rubroempleado.setEmpresa(rubroempleadoDataAccess.getEmpresa(connexion,rubroempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			rubroempleado.setEmpleado(rubroempleadoDataAccess.getEmpleado(connexion,rubroempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RubroEmplea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			rubroempleado.setRubroEmplea(rubroempleadoDataAccess.getRubroEmplea(connexion,rubroempleado));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoRubro.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			rubroempleado.setEstadoRubro(rubroempleadoDataAccess.getEstadoRubro(connexion,rubroempleado));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		rubroempleado.setEmpresa(rubroempleadoDataAccess.getEmpresa(connexion,rubroempleado));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(rubroempleado.getEmpresa(),isDeep,deepLoadType,clases);
				
		rubroempleado.setEmpleado(rubroempleadoDataAccess.getEmpleado(connexion,rubroempleado));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(rubroempleado.getEmpleado(),isDeep,deepLoadType,clases);
				
		rubroempleado.setRubroEmplea(rubroempleadoDataAccess.getRubroEmplea(connexion,rubroempleado));
		RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
		rubroempleaLogic.deepLoad(rubroempleado.getRubroEmplea(),isDeep,deepLoadType,clases);
				
		rubroempleado.setEstadoRubro(rubroempleadoDataAccess.getEstadoRubro(connexion,rubroempleado));
		EstadoRubroLogic estadorubroLogic= new EstadoRubroLogic(connexion);
		estadorubroLogic.deepLoad(rubroempleado.getEstadoRubro(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				rubroempleado.setEmpresa(rubroempleadoDataAccess.getEmpresa(connexion,rubroempleado));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(rubroempleado.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				rubroempleado.setEmpleado(rubroempleadoDataAccess.getEmpleado(connexion,rubroempleado));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(rubroempleado.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(RubroEmplea.class)) {
				rubroempleado.setRubroEmplea(rubroempleadoDataAccess.getRubroEmplea(connexion,rubroempleado));
				RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
				rubroempleaLogic.deepLoad(rubroempleado.getRubroEmplea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoRubro.class)) {
				rubroempleado.setEstadoRubro(rubroempleadoDataAccess.getEstadoRubro(connexion,rubroempleado));
				EstadoRubroLogic estadorubroLogic= new EstadoRubroLogic(connexion);
				estadorubroLogic.deepLoad(rubroempleado.getEstadoRubro(),isDeep,deepLoadType,clases);				
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
			rubroempleado.setEmpresa(rubroempleadoDataAccess.getEmpresa(connexion,rubroempleado));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(rubroempleado.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			rubroempleado.setEmpleado(rubroempleadoDataAccess.getEmpleado(connexion,rubroempleado));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(rubroempleado.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(RubroEmplea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			rubroempleado.setRubroEmplea(rubroempleadoDataAccess.getRubroEmplea(connexion,rubroempleado));
			RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
			rubroempleaLogic.deepLoad(rubroempleado.getRubroEmplea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(EstadoRubro.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			rubroempleado.setEstadoRubro(rubroempleadoDataAccess.getEstadoRubro(connexion,rubroempleado));
			EstadoRubroLogic estadorubroLogic= new EstadoRubroLogic(connexion);
			estadorubroLogic.deepLoad(rubroempleado.getEstadoRubro(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(RubroEmpleado rubroempleado,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			RubroEmpleadoLogicAdditional.updateRubroEmpleadoToSave(rubroempleado,this.arrDatoGeneral);
			
RubroEmpleadoDataAccess.save(rubroempleado, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(rubroempleado.getEmpresa(),connexion);

		EmpleadoDataAccess.save(rubroempleado.getEmpleado(),connexion);

		RubroEmpleaDataAccess.save(rubroempleado.getRubroEmplea(),connexion);

		EstadoRubroDataAccess.save(rubroempleado.getEstadoRubro(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(rubroempleado.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(rubroempleado.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(RubroEmplea.class)) {
				RubroEmpleaDataAccess.save(rubroempleado.getRubroEmplea(),connexion);
				continue;
			}

			if(clas.clas.equals(EstadoRubro.class)) {
				EstadoRubroDataAccess.save(rubroempleado.getEstadoRubro(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(rubroempleado.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(rubroempleado.getEmpresa(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(rubroempleado.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(rubroempleado.getEmpleado(),isDeep,deepLoadType,clases);
				

		RubroEmpleaDataAccess.save(rubroempleado.getRubroEmplea(),connexion);
		RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
		rubroempleaLogic.deepLoad(rubroempleado.getRubroEmplea(),isDeep,deepLoadType,clases);
				

		EstadoRubroDataAccess.save(rubroempleado.getEstadoRubro(),connexion);
		EstadoRubroLogic estadorubroLogic= new EstadoRubroLogic(connexion);
		estadorubroLogic.deepLoad(rubroempleado.getEstadoRubro(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(rubroempleado.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(rubroempleado.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(rubroempleado.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(rubroempleado.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(RubroEmplea.class)) {
				RubroEmpleaDataAccess.save(rubroempleado.getRubroEmplea(),connexion);
				RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
				rubroempleaLogic.deepSave(rubroempleado.getRubroEmplea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(EstadoRubro.class)) {
				EstadoRubroDataAccess.save(rubroempleado.getEstadoRubro(),connexion);
				EstadoRubroLogic estadorubroLogic= new EstadoRubroLogic(connexion);
				estadorubroLogic.deepSave(rubroempleado.getEstadoRubro(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(RubroEmpleado.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(rubroempleado,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RubroEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleado(rubroempleado);
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
			this.deepLoad(this.rubroempleado,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RubroEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleado(this.rubroempleado);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(RubroEmpleado.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(rubroempleados!=null) {
				for(RubroEmpleado rubroempleado:rubroempleados) {
					this.deepLoad(rubroempleado,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					RubroEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleado(rubroempleados);
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
			if(rubroempleados!=null) {
				for(RubroEmpleado rubroempleado:rubroempleados) {
					this.deepLoad(rubroempleado,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					RubroEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleado(rubroempleados);
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
			this.getNewConnexionToDeep(RubroEmpleado.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(rubroempleado,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(RubroEmpleado.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(rubroempleados!=null) {
				for(RubroEmpleado rubroempleado:rubroempleados) {
					this.deepSave(rubroempleado,isDeep,deepLoadType,clases);
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
			if(rubroempleados!=null) {
				for(RubroEmpleado rubroempleado:rubroempleados) {
					this.deepSave(rubroempleado,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getRubroEmpleadosFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,RubroEmpleadoConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			RubroEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rubroempleados=rubroempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RubroEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleado(this.rubroempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRubroEmpleadosFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,RubroEmpleadoConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			RubroEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rubroempleados=rubroempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RubroEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleado(this.rubroempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRubroEmpleadosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,RubroEmpleadoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			RubroEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rubroempleados=rubroempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RubroEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleado(this.rubroempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRubroEmpleadosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,RubroEmpleadoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			RubroEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rubroempleados=rubroempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RubroEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleado(this.rubroempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRubroEmpleadosFK_IdEstadoRubroWithConnection(String sFinalQuery,Pagination pagination,Long id_estado_rubro)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoRubro= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoRubro.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_rubro,RubroEmpleadoConstantesFunciones.IDESTADORUBRO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoRubro);

			RubroEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoRubro","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rubroempleados=rubroempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RubroEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleado(this.rubroempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRubroEmpleadosFK_IdEstadoRubro(String sFinalQuery,Pagination pagination,Long id_estado_rubro)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstadoRubro= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstadoRubro.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estado_rubro,RubroEmpleadoConstantesFunciones.IDESTADORUBRO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstadoRubro);

			RubroEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstadoRubro","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rubroempleados=rubroempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RubroEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleado(this.rubroempleados);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRubroEmpleadosFK_IdRubroEmpleaWithConnection(String sFinalQuery,Pagination pagination,Long id_rubro_emplea)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleado.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRubroEmplea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRubroEmplea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_rubro_emplea,RubroEmpleadoConstantesFunciones.IDRUBROEMPLEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRubroEmplea);

			RubroEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRubroEmplea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rubroempleados=rubroempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RubroEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleado(this.rubroempleados);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRubroEmpleadosFK_IdRubroEmplea(String sFinalQuery,Pagination pagination,Long id_rubro_emplea)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRubroEmplea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRubroEmplea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_rubro_emplea,RubroEmpleadoConstantesFunciones.IDRUBROEMPLEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRubroEmplea);

			RubroEmpleadoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRubroEmplea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rubroempleados=rubroempleadoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RubroEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleado(this.rubroempleados);
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
			if(RubroEmpleadoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,RubroEmpleadoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,RubroEmpleado rubroempleado,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(RubroEmpleadoConstantesFunciones.ISCONAUDITORIA) {
				if(rubroempleado.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RubroEmpleadoDataAccess.TABLENAME, rubroempleado.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(RubroEmpleadoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////RubroEmpleadoLogic.registrarAuditoriaDetallesRubroEmpleado(connexion,rubroempleado,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(rubroempleado.getIsDeleted()) {
					/*if(!rubroempleado.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,RubroEmpleadoDataAccess.TABLENAME, rubroempleado.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////RubroEmpleadoLogic.registrarAuditoriaDetallesRubroEmpleado(connexion,rubroempleado,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RubroEmpleadoDataAccess.TABLENAME, rubroempleado.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(rubroempleado.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RubroEmpleadoDataAccess.TABLENAME, rubroempleado.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(RubroEmpleadoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////RubroEmpleadoLogic.registrarAuditoriaDetallesRubroEmpleado(connexion,rubroempleado,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesRubroEmpleado(Connexion connexion,RubroEmpleado rubroempleado)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(rubroempleado.getIsNew()||!rubroempleado.getid_empresa().equals(rubroempleado.getRubroEmpleadoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rubroempleado.getRubroEmpleadoOriginal().getid_empresa()!=null)
				{
					strValorActual=rubroempleado.getRubroEmpleadoOriginal().getid_empresa().toString();
				}
				if(rubroempleado.getid_empresa()!=null)
				{
					strValorNuevo=rubroempleado.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RubroEmpleadoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(rubroempleado.getIsNew()||!rubroempleado.getid_empleado().equals(rubroempleado.getRubroEmpleadoOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rubroempleado.getRubroEmpleadoOriginal().getid_empleado()!=null)
				{
					strValorActual=rubroempleado.getRubroEmpleadoOriginal().getid_empleado().toString();
				}
				if(rubroempleado.getid_empleado()!=null)
				{
					strValorNuevo=rubroempleado.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RubroEmpleadoConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(rubroempleado.getIsNew()||!rubroempleado.getid_rubro_emplea().equals(rubroempleado.getRubroEmpleadoOriginal().getid_rubro_emplea()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rubroempleado.getRubroEmpleadoOriginal().getid_rubro_emplea()!=null)
				{
					strValorActual=rubroempleado.getRubroEmpleadoOriginal().getid_rubro_emplea().toString();
				}
				if(rubroempleado.getid_rubro_emplea()!=null)
				{
					strValorNuevo=rubroempleado.getid_rubro_emplea().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RubroEmpleadoConstantesFunciones.IDRUBROEMPLEA,strValorActual,strValorNuevo);
			}	
			
			if(rubroempleado.getIsNew()||!rubroempleado.getid_estado_rubro().equals(rubroempleado.getRubroEmpleadoOriginal().getid_estado_rubro()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rubroempleado.getRubroEmpleadoOriginal().getid_estado_rubro()!=null)
				{
					strValorActual=rubroempleado.getRubroEmpleadoOriginal().getid_estado_rubro().toString();
				}
				if(rubroempleado.getid_estado_rubro()!=null)
				{
					strValorNuevo=rubroempleado.getid_estado_rubro().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RubroEmpleadoConstantesFunciones.IDESTADORUBRO,strValorActual,strValorNuevo);
			}	
			
			if(rubroempleado.getIsNew()||!rubroempleado.getvalor().equals(rubroempleado.getRubroEmpleadoOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rubroempleado.getRubroEmpleadoOriginal().getvalor()!=null)
				{
					strValorActual=rubroempleado.getRubroEmpleadoOriginal().getvalor().toString();
				}
				if(rubroempleado.getvalor()!=null)
				{
					strValorNuevo=rubroempleado.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RubroEmpleadoConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveRubroEmpleadoRelacionesWithConnection(RubroEmpleado rubroempleado) throws Exception {

		if(!rubroempleado.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveRubroEmpleadoRelacionesBase(rubroempleado,true);
		}
	}

	public void saveRubroEmpleadoRelaciones(RubroEmpleado rubroempleado)throws Exception {

		if(!rubroempleado.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveRubroEmpleadoRelacionesBase(rubroempleado,false);
		}
	}

	public void saveRubroEmpleadoRelacionesBase(RubroEmpleado rubroempleado,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("RubroEmpleado-saveRelacionesWithConnection");}
	

			this.setRubroEmpleado(rubroempleado);

			if(RubroEmpleadoLogicAdditional.validarSaveRelaciones(rubroempleado,this)) {

				RubroEmpleadoLogicAdditional.updateRelacionesToSave(rubroempleado,this);

				if((rubroempleado.getIsNew()||rubroempleado.getIsChanged())&&!rubroempleado.getIsDeleted()) {
					this.saveRubroEmpleado();
					this.saveRubroEmpleadoRelacionesDetalles();

				} else if(rubroempleado.getIsDeleted()) {
					this.saveRubroEmpleadoRelacionesDetalles();
					this.saveRubroEmpleado();
				}

				RubroEmpleadoLogicAdditional.updateRelacionesToSaveAfter(rubroempleado,this);

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
	
	
	private void saveRubroEmpleadoRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfRubroEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=RubroEmpleadoConstantesFunciones.getClassesForeignKeysOfRubroEmpleado(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRubroEmpleado(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=RubroEmpleadoConstantesFunciones.getClassesRelationshipsOfRubroEmpleado(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

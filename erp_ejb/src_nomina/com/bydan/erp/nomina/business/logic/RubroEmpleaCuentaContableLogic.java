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
import com.bydan.erp.nomina.util.RubroEmpleaCuentaContableConstantesFunciones;
import com.bydan.erp.nomina.util.RubroEmpleaCuentaContableParameterReturnGeneral;
//import com.bydan.erp.nomina.util.RubroEmpleaCuentaContableParameterGeneral;
import com.bydan.erp.nomina.business.entity.RubroEmpleaCuentaContable;
import com.bydan.erp.nomina.business.logic.RubroEmpleaCuentaContableLogicAdditional;
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
public class RubroEmpleaCuentaContableLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(RubroEmpleaCuentaContableLogic.class);
	
	protected RubroEmpleaCuentaContableDataAccess rubroempleacuentacontableDataAccess; 	
	protected RubroEmpleaCuentaContable rubroempleacuentacontable;
	protected List<RubroEmpleaCuentaContable> rubroempleacuentacontables;
	protected Object rubroempleacuentacontableObject;	
	protected List<Object> rubroempleacuentacontablesObject;
	
	public static ClassValidator<RubroEmpleaCuentaContable> rubroempleacuentacontableValidator = new ClassValidator<RubroEmpleaCuentaContable>(RubroEmpleaCuentaContable.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected RubroEmpleaCuentaContableLogicAdditional rubroempleacuentacontableLogicAdditional=null;
	
	public RubroEmpleaCuentaContableLogicAdditional getRubroEmpleaCuentaContableLogicAdditional() {
		return this.rubroempleacuentacontableLogicAdditional;
	}
	
	public void setRubroEmpleaCuentaContableLogicAdditional(RubroEmpleaCuentaContableLogicAdditional rubroempleacuentacontableLogicAdditional) {
		try {
			this.rubroempleacuentacontableLogicAdditional=rubroempleacuentacontableLogicAdditional;
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
	
	
	
	
	public  RubroEmpleaCuentaContableLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.rubroempleacuentacontableDataAccess = new RubroEmpleaCuentaContableDataAccess();
			
			this.rubroempleacuentacontables= new ArrayList<RubroEmpleaCuentaContable>();
			this.rubroempleacuentacontable= new RubroEmpleaCuentaContable();
			
			this.rubroempleacuentacontableObject=new Object();
			this.rubroempleacuentacontablesObject=new ArrayList<Object>();
				
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
			
			this.rubroempleacuentacontableDataAccess.setConnexionType(this.connexionType);
			this.rubroempleacuentacontableDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  RubroEmpleaCuentaContableLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.rubroempleacuentacontableDataAccess = new RubroEmpleaCuentaContableDataAccess();
			this.rubroempleacuentacontables= new ArrayList<RubroEmpleaCuentaContable>();
			this.rubroempleacuentacontable= new RubroEmpleaCuentaContable();
			this.rubroempleacuentacontableObject=new Object();
			this.rubroempleacuentacontablesObject=new ArrayList<Object>();
			
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
			
			this.rubroempleacuentacontableDataAccess.setConnexionType(this.connexionType);
			this.rubroempleacuentacontableDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public RubroEmpleaCuentaContable getRubroEmpleaCuentaContable() throws Exception {	
		RubroEmpleaCuentaContableLogicAdditional.checkRubroEmpleaCuentaContableToGet(rubroempleacuentacontable,this.datosCliente,this.arrDatoGeneral);
		RubroEmpleaCuentaContableLogicAdditional.updateRubroEmpleaCuentaContableToGet(rubroempleacuentacontable,this.arrDatoGeneral);
		
		return rubroempleacuentacontable;
	}
		
	public void setRubroEmpleaCuentaContable(RubroEmpleaCuentaContable newRubroEmpleaCuentaContable) {
		this.rubroempleacuentacontable = newRubroEmpleaCuentaContable;
	}
	
	public RubroEmpleaCuentaContableDataAccess getRubroEmpleaCuentaContableDataAccess() {
		return rubroempleacuentacontableDataAccess;
	}
	
	public void setRubroEmpleaCuentaContableDataAccess(RubroEmpleaCuentaContableDataAccess newrubroempleacuentacontableDataAccess) {
		this.rubroempleacuentacontableDataAccess = newrubroempleacuentacontableDataAccess;
	}
	
	public List<RubroEmpleaCuentaContable> getRubroEmpleaCuentaContables() throws Exception {		
		this.quitarRubroEmpleaCuentaContablesNulos();
		
		RubroEmpleaCuentaContableLogicAdditional.checkRubroEmpleaCuentaContableToGets(rubroempleacuentacontables,this.datosCliente,this.arrDatoGeneral);
		
		for (RubroEmpleaCuentaContable rubroempleacuentacontableLocal: rubroempleacuentacontables ) {
			RubroEmpleaCuentaContableLogicAdditional.updateRubroEmpleaCuentaContableToGet(rubroempleacuentacontableLocal,this.arrDatoGeneral);
		}
		
		return rubroempleacuentacontables;
	}
	
	public void setRubroEmpleaCuentaContables(List<RubroEmpleaCuentaContable> newRubroEmpleaCuentaContables) {
		this.rubroempleacuentacontables = newRubroEmpleaCuentaContables;
	}
	
	public Object getRubroEmpleaCuentaContableObject() {	
		this.rubroempleacuentacontableObject=this.rubroempleacuentacontableDataAccess.getEntityObject();
		return this.rubroempleacuentacontableObject;
	}
		
	public void setRubroEmpleaCuentaContableObject(Object newRubroEmpleaCuentaContableObject) {
		this.rubroempleacuentacontableObject = newRubroEmpleaCuentaContableObject;
	}
	
	public List<Object> getRubroEmpleaCuentaContablesObject() {		
		this.rubroempleacuentacontablesObject=this.rubroempleacuentacontableDataAccess.getEntitiesObject();
		return this.rubroempleacuentacontablesObject;
	}
		
	public void setRubroEmpleaCuentaContablesObject(List<Object> newRubroEmpleaCuentaContablesObject) {
		this.rubroempleacuentacontablesObject = newRubroEmpleaCuentaContablesObject;
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
		
		if(this.rubroempleacuentacontableDataAccess!=null) {
			this.rubroempleacuentacontableDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleaCuentaContable.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			rubroempleacuentacontableDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			rubroempleacuentacontableDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		rubroempleacuentacontable = new  RubroEmpleaCuentaContable();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleaCuentaContable.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			rubroempleacuentacontable=rubroempleacuentacontableDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.rubroempleacuentacontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RubroEmpleaCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleaCuentaContable(this.rubroempleacuentacontable);
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
		rubroempleacuentacontable = new  RubroEmpleaCuentaContable();
		  		  
        try {
			
			rubroempleacuentacontable=rubroempleacuentacontableDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.rubroempleacuentacontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RubroEmpleaCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleaCuentaContable(this.rubroempleacuentacontable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		rubroempleacuentacontable = new  RubroEmpleaCuentaContable();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleaCuentaContable.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			rubroempleacuentacontable=rubroempleacuentacontableDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.rubroempleacuentacontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RubroEmpleaCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleaCuentaContable(this.rubroempleacuentacontable);
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
		rubroempleacuentacontable = new  RubroEmpleaCuentaContable();
		  		  
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
		rubroempleacuentacontable = new  RubroEmpleaCuentaContable();
		  		  
        try {
			
			rubroempleacuentacontable=rubroempleacuentacontableDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.rubroempleacuentacontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RubroEmpleaCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleaCuentaContable(this.rubroempleacuentacontable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		rubroempleacuentacontable = new  RubroEmpleaCuentaContable();
		  		  
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
		rubroempleacuentacontable = new  RubroEmpleaCuentaContable();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleaCuentaContable.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =rubroempleacuentacontableDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		rubroempleacuentacontable = new  RubroEmpleaCuentaContable();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=rubroempleacuentacontableDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		rubroempleacuentacontable = new  RubroEmpleaCuentaContable();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleaCuentaContable.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =rubroempleacuentacontableDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		rubroempleacuentacontable = new  RubroEmpleaCuentaContable();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=rubroempleacuentacontableDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		rubroempleacuentacontable = new  RubroEmpleaCuentaContable();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleaCuentaContable.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =rubroempleacuentacontableDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		rubroempleacuentacontable = new  RubroEmpleaCuentaContable();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=rubroempleacuentacontableDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		rubroempleacuentacontables = new  ArrayList<RubroEmpleaCuentaContable>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleaCuentaContable.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			RubroEmpleaCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroempleacuentacontables=rubroempleacuentacontableDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRubroEmpleaCuentaContable(rubroempleacuentacontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEmpleaCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleaCuentaContable(this.rubroempleacuentacontables);
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
		rubroempleacuentacontables = new  ArrayList<RubroEmpleaCuentaContable>();
		  		  
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
		rubroempleacuentacontables = new  ArrayList<RubroEmpleaCuentaContable>();
		  		  
        try {			
			RubroEmpleaCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroempleacuentacontables=rubroempleacuentacontableDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarRubroEmpleaCuentaContable(rubroempleacuentacontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEmpleaCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleaCuentaContable(this.rubroempleacuentacontables);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		rubroempleacuentacontables = new  ArrayList<RubroEmpleaCuentaContable>();
		  		  
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
		rubroempleacuentacontables = new  ArrayList<RubroEmpleaCuentaContable>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleaCuentaContable.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			RubroEmpleaCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroempleacuentacontables=rubroempleacuentacontableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRubroEmpleaCuentaContable(rubroempleacuentacontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEmpleaCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleaCuentaContable(this.rubroempleacuentacontables);
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
		rubroempleacuentacontables = new  ArrayList<RubroEmpleaCuentaContable>();
		  		  
        try {
			RubroEmpleaCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroempleacuentacontables=rubroempleacuentacontableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRubroEmpleaCuentaContable(rubroempleacuentacontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEmpleaCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleaCuentaContable(this.rubroempleacuentacontables);
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
		rubroempleacuentacontables = new  ArrayList<RubroEmpleaCuentaContable>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleaCuentaContable.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RubroEmpleaCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroempleacuentacontables=rubroempleacuentacontableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRubroEmpleaCuentaContable(rubroempleacuentacontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEmpleaCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleaCuentaContable(this.rubroempleacuentacontables);
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
		rubroempleacuentacontables = new  ArrayList<RubroEmpleaCuentaContable>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RubroEmpleaCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroempleacuentacontables=rubroempleacuentacontableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRubroEmpleaCuentaContable(rubroempleacuentacontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEmpleaCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleaCuentaContable(this.rubroempleacuentacontables);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		rubroempleacuentacontable = new  RubroEmpleaCuentaContable();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleaCuentaContable.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RubroEmpleaCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroempleacuentacontable=rubroempleacuentacontableDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRubroEmpleaCuentaContable(rubroempleacuentacontable);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEmpleaCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleaCuentaContable(this.rubroempleacuentacontable);
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
		rubroempleacuentacontable = new  RubroEmpleaCuentaContable();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RubroEmpleaCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroempleacuentacontable=rubroempleacuentacontableDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRubroEmpleaCuentaContable(rubroempleacuentacontable);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEmpleaCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleaCuentaContable(this.rubroempleacuentacontable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		rubroempleacuentacontables = new  ArrayList<RubroEmpleaCuentaContable>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleaCuentaContable.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			RubroEmpleaCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroempleacuentacontables=rubroempleacuentacontableDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRubroEmpleaCuentaContable(rubroempleacuentacontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEmpleaCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleaCuentaContable(this.rubroempleacuentacontables);
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
		rubroempleacuentacontables = new  ArrayList<RubroEmpleaCuentaContable>();
		  		  
        try {
			RubroEmpleaCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroempleacuentacontables=rubroempleacuentacontableDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRubroEmpleaCuentaContable(rubroempleacuentacontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEmpleaCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleaCuentaContable(this.rubroempleacuentacontables);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosRubroEmpleaCuentaContablesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		rubroempleacuentacontables = new  ArrayList<RubroEmpleaCuentaContable>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleaCuentaContable.class.getSimpleName()+"-getTodosRubroEmpleaCuentaContablesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RubroEmpleaCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroempleacuentacontables=rubroempleacuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarRubroEmpleaCuentaContable(rubroempleacuentacontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEmpleaCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleaCuentaContable(this.rubroempleacuentacontables);
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
	
	public  void  getTodosRubroEmpleaCuentaContables(String sFinalQuery,Pagination pagination)throws Exception {
		rubroempleacuentacontables = new  ArrayList<RubroEmpleaCuentaContable>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RubroEmpleaCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroempleacuentacontables=rubroempleacuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarRubroEmpleaCuentaContable(rubroempleacuentacontables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEmpleaCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleaCuentaContable(this.rubroempleacuentacontables);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarRubroEmpleaCuentaContable(RubroEmpleaCuentaContable rubroempleacuentacontable) throws Exception {
		Boolean estaValidado=false;
		
		if(rubroempleacuentacontable.getIsNew() || rubroempleacuentacontable.getIsChanged()) { 
			this.invalidValues = rubroempleacuentacontableValidator.getInvalidValues(rubroempleacuentacontable);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(rubroempleacuentacontable);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarRubroEmpleaCuentaContable(List<RubroEmpleaCuentaContable> RubroEmpleaCuentaContables) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(RubroEmpleaCuentaContable rubroempleacuentacontableLocal:rubroempleacuentacontables) {				
			estaValidadoObjeto=this.validarGuardarRubroEmpleaCuentaContable(rubroempleacuentacontableLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarRubroEmpleaCuentaContable(List<RubroEmpleaCuentaContable> RubroEmpleaCuentaContables) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarRubroEmpleaCuentaContable(rubroempleacuentacontables)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarRubroEmpleaCuentaContable(RubroEmpleaCuentaContable RubroEmpleaCuentaContable) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarRubroEmpleaCuentaContable(rubroempleacuentacontable)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(RubroEmpleaCuentaContable rubroempleacuentacontable) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+rubroempleacuentacontable.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=RubroEmpleaCuentaContableConstantesFunciones.getRubroEmpleaCuentaContableLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"rubroempleacuentacontable","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(RubroEmpleaCuentaContableConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(RubroEmpleaCuentaContableConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveRubroEmpleaCuentaContableWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleaCuentaContable.class.getSimpleName()+"-saveRubroEmpleaCuentaContableWithConnection");connexion.begin();			
			
			RubroEmpleaCuentaContableLogicAdditional.checkRubroEmpleaCuentaContableToSave(this.rubroempleacuentacontable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			RubroEmpleaCuentaContableLogicAdditional.updateRubroEmpleaCuentaContableToSave(this.rubroempleacuentacontable,this.arrDatoGeneral);
			
			RubroEmpleaCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.rubroempleacuentacontable,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowRubroEmpleaCuentaContable();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarRubroEmpleaCuentaContable(this.rubroempleacuentacontable)) {
				RubroEmpleaCuentaContableDataAccess.save(this.rubroempleacuentacontable, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.rubroempleacuentacontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			RubroEmpleaCuentaContableLogicAdditional.checkRubroEmpleaCuentaContableToSaveAfter(this.rubroempleacuentacontable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowRubroEmpleaCuentaContable();
			
			connexion.commit();			
			
			if(this.rubroempleacuentacontable.getIsDeleted()) {
				this.rubroempleacuentacontable=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveRubroEmpleaCuentaContable()throws Exception {	
		try {	
			
			RubroEmpleaCuentaContableLogicAdditional.checkRubroEmpleaCuentaContableToSave(this.rubroempleacuentacontable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			RubroEmpleaCuentaContableLogicAdditional.updateRubroEmpleaCuentaContableToSave(this.rubroempleacuentacontable,this.arrDatoGeneral);
			
			RubroEmpleaCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.rubroempleacuentacontable,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarRubroEmpleaCuentaContable(this.rubroempleacuentacontable)) {			
				RubroEmpleaCuentaContableDataAccess.save(this.rubroempleacuentacontable, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.rubroempleacuentacontable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			RubroEmpleaCuentaContableLogicAdditional.checkRubroEmpleaCuentaContableToSaveAfter(this.rubroempleacuentacontable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.rubroempleacuentacontable.getIsDeleted()) {
				this.rubroempleacuentacontable=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveRubroEmpleaCuentaContablesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleaCuentaContable.class.getSimpleName()+"-saveRubroEmpleaCuentaContablesWithConnection");connexion.begin();			
			
			RubroEmpleaCuentaContableLogicAdditional.checkRubroEmpleaCuentaContableToSaves(rubroempleacuentacontables,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowRubroEmpleaCuentaContables();
			
			Boolean validadoTodosRubroEmpleaCuentaContable=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(RubroEmpleaCuentaContable rubroempleacuentacontableLocal:rubroempleacuentacontables) {		
				if(rubroempleacuentacontableLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				RubroEmpleaCuentaContableLogicAdditional.updateRubroEmpleaCuentaContableToSave(rubroempleacuentacontableLocal,this.arrDatoGeneral);
	        	
				RubroEmpleaCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),rubroempleacuentacontableLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarRubroEmpleaCuentaContable(rubroempleacuentacontableLocal)) {
					RubroEmpleaCuentaContableDataAccess.save(rubroempleacuentacontableLocal, connexion);				
				} else {
					validadoTodosRubroEmpleaCuentaContable=false;
				}
			}
			
			if(!validadoTodosRubroEmpleaCuentaContable) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			RubroEmpleaCuentaContableLogicAdditional.checkRubroEmpleaCuentaContableToSavesAfter(rubroempleacuentacontables,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowRubroEmpleaCuentaContables();
			
			connexion.commit();		
			
			this.quitarRubroEmpleaCuentaContablesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveRubroEmpleaCuentaContables()throws Exception {				
		 try {	
			RubroEmpleaCuentaContableLogicAdditional.checkRubroEmpleaCuentaContableToSaves(rubroempleacuentacontables,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosRubroEmpleaCuentaContable=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(RubroEmpleaCuentaContable rubroempleacuentacontableLocal:rubroempleacuentacontables) {				
				if(rubroempleacuentacontableLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				RubroEmpleaCuentaContableLogicAdditional.updateRubroEmpleaCuentaContableToSave(rubroempleacuentacontableLocal,this.arrDatoGeneral);
	        	
				RubroEmpleaCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),rubroempleacuentacontableLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarRubroEmpleaCuentaContable(rubroempleacuentacontableLocal)) {				
					RubroEmpleaCuentaContableDataAccess.save(rubroempleacuentacontableLocal, connexion);				
				} else {
					validadoTodosRubroEmpleaCuentaContable=false;
				}
			}
			
			if(!validadoTodosRubroEmpleaCuentaContable) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			RubroEmpleaCuentaContableLogicAdditional.checkRubroEmpleaCuentaContableToSavesAfter(rubroempleacuentacontables,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarRubroEmpleaCuentaContablesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RubroEmpleaCuentaContableParameterReturnGeneral procesarAccionRubroEmpleaCuentaContables(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<RubroEmpleaCuentaContable> rubroempleacuentacontables,RubroEmpleaCuentaContableParameterReturnGeneral rubroempleacuentacontableParameterGeneral)throws Exception {
		 try {	
			RubroEmpleaCuentaContableParameterReturnGeneral rubroempleacuentacontableReturnGeneral=new RubroEmpleaCuentaContableParameterReturnGeneral();
	
			RubroEmpleaCuentaContableLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,rubroempleacuentacontables,rubroempleacuentacontableParameterGeneral,rubroempleacuentacontableReturnGeneral);
			
			return rubroempleacuentacontableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RubroEmpleaCuentaContableParameterReturnGeneral procesarAccionRubroEmpleaCuentaContablesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<RubroEmpleaCuentaContable> rubroempleacuentacontables,RubroEmpleaCuentaContableParameterReturnGeneral rubroempleacuentacontableParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleaCuentaContable.class.getSimpleName()+"-procesarAccionRubroEmpleaCuentaContablesWithConnection");connexion.begin();			
			
			RubroEmpleaCuentaContableParameterReturnGeneral rubroempleacuentacontableReturnGeneral=new RubroEmpleaCuentaContableParameterReturnGeneral();
	
			RubroEmpleaCuentaContableLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,rubroempleacuentacontables,rubroempleacuentacontableParameterGeneral,rubroempleacuentacontableReturnGeneral);
			
			this.connexion.commit();
			
			return rubroempleacuentacontableReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public RubroEmpleaCuentaContableParameterReturnGeneral procesarEventosRubroEmpleaCuentaContables(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<RubroEmpleaCuentaContable> rubroempleacuentacontables,RubroEmpleaCuentaContable rubroempleacuentacontable,RubroEmpleaCuentaContableParameterReturnGeneral rubroempleacuentacontableParameterGeneral,Boolean isEsNuevoRubroEmpleaCuentaContable,ArrayList<Classe> clases)throws Exception {
		 try {	
			RubroEmpleaCuentaContableParameterReturnGeneral rubroempleacuentacontableReturnGeneral=new RubroEmpleaCuentaContableParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				rubroempleacuentacontableReturnGeneral.setConRecargarPropiedades(true);
			}
			
			RubroEmpleaCuentaContableLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,rubroempleacuentacontables,rubroempleacuentacontable,rubroempleacuentacontableParameterGeneral,rubroempleacuentacontableReturnGeneral,isEsNuevoRubroEmpleaCuentaContable,clases);
			
			return rubroempleacuentacontableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public RubroEmpleaCuentaContableParameterReturnGeneral procesarEventosRubroEmpleaCuentaContablesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<RubroEmpleaCuentaContable> rubroempleacuentacontables,RubroEmpleaCuentaContable rubroempleacuentacontable,RubroEmpleaCuentaContableParameterReturnGeneral rubroempleacuentacontableParameterGeneral,Boolean isEsNuevoRubroEmpleaCuentaContable,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleaCuentaContable.class.getSimpleName()+"-procesarEventosRubroEmpleaCuentaContablesWithConnection");connexion.begin();			
			
			RubroEmpleaCuentaContableParameterReturnGeneral rubroempleacuentacontableReturnGeneral=new RubroEmpleaCuentaContableParameterReturnGeneral();
	
			rubroempleacuentacontableReturnGeneral.setRubroEmpleaCuentaContable(rubroempleacuentacontable);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				rubroempleacuentacontableReturnGeneral.setConRecargarPropiedades(true);
			}
			
			RubroEmpleaCuentaContableLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,rubroempleacuentacontables,rubroempleacuentacontable,rubroempleacuentacontableParameterGeneral,rubroempleacuentacontableReturnGeneral,isEsNuevoRubroEmpleaCuentaContable,clases);
			
			this.connexion.commit();
			
			return rubroempleacuentacontableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public RubroEmpleaCuentaContableParameterReturnGeneral procesarImportacionRubroEmpleaCuentaContablesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,RubroEmpleaCuentaContableParameterReturnGeneral rubroempleacuentacontableParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleaCuentaContable.class.getSimpleName()+"-procesarImportacionRubroEmpleaCuentaContablesWithConnection");connexion.begin();			
			
			RubroEmpleaCuentaContableParameterReturnGeneral rubroempleacuentacontableReturnGeneral=new RubroEmpleaCuentaContableParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.rubroempleacuentacontables=new ArrayList<RubroEmpleaCuentaContable>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.rubroempleacuentacontable=new RubroEmpleaCuentaContable();
				
				
				if(conColumnasBase) {this.rubroempleacuentacontable.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.rubroempleacuentacontable.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				
				this.rubroempleacuentacontables.add(this.rubroempleacuentacontable);
			}
			
			this.saveRubroEmpleaCuentaContables();
			
			this.connexion.commit();
			
			rubroempleacuentacontableReturnGeneral.setConRetornoEstaProcesado(true);
			rubroempleacuentacontableReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return rubroempleacuentacontableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarRubroEmpleaCuentaContablesEliminados() throws Exception {				
		
		List<RubroEmpleaCuentaContable> rubroempleacuentacontablesAux= new ArrayList<RubroEmpleaCuentaContable>();
		
		for(RubroEmpleaCuentaContable rubroempleacuentacontable:rubroempleacuentacontables) {
			if(!rubroempleacuentacontable.getIsDeleted()) {
				rubroempleacuentacontablesAux.add(rubroempleacuentacontable);
			}
		}
		
		rubroempleacuentacontables=rubroempleacuentacontablesAux;
	}
	
	public void quitarRubroEmpleaCuentaContablesNulos() throws Exception {				
		
		List<RubroEmpleaCuentaContable> rubroempleacuentacontablesAux= new ArrayList<RubroEmpleaCuentaContable>();
		
		for(RubroEmpleaCuentaContable rubroempleacuentacontable : this.rubroempleacuentacontables) {
			if(rubroempleacuentacontable==null) {
				rubroempleacuentacontablesAux.add(rubroempleacuentacontable);
			}
		}
		
		//this.rubroempleacuentacontables=rubroempleacuentacontablesAux;
		
		this.rubroempleacuentacontables.removeAll(rubroempleacuentacontablesAux);
	}
	
	public void getSetVersionRowRubroEmpleaCuentaContableWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(rubroempleacuentacontable.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((rubroempleacuentacontable.getIsDeleted() || (rubroempleacuentacontable.getIsChanged()&&!rubroempleacuentacontable.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=rubroempleacuentacontableDataAccess.getSetVersionRowRubroEmpleaCuentaContable(connexion,rubroempleacuentacontable.getId());
				
				if(!rubroempleacuentacontable.getVersionRow().equals(timestamp)) {	
					rubroempleacuentacontable.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				rubroempleacuentacontable.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowRubroEmpleaCuentaContable()throws Exception {	
		
		if(rubroempleacuentacontable.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((rubroempleacuentacontable.getIsDeleted() || (rubroempleacuentacontable.getIsChanged()&&!rubroempleacuentacontable.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=rubroempleacuentacontableDataAccess.getSetVersionRowRubroEmpleaCuentaContable(connexion,rubroempleacuentacontable.getId());
			
			try {							
				if(!rubroempleacuentacontable.getVersionRow().equals(timestamp)) {	
					rubroempleacuentacontable.setVersionRow(timestamp);
				}
				
				rubroempleacuentacontable.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowRubroEmpleaCuentaContablesWithConnection()throws Exception {	
		if(rubroempleacuentacontables!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(RubroEmpleaCuentaContable rubroempleacuentacontableAux:rubroempleacuentacontables) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(rubroempleacuentacontableAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(rubroempleacuentacontableAux.getIsDeleted() || (rubroempleacuentacontableAux.getIsChanged()&&!rubroempleacuentacontableAux.getIsNew())) {
						
						timestamp=rubroempleacuentacontableDataAccess.getSetVersionRowRubroEmpleaCuentaContable(connexion,rubroempleacuentacontableAux.getId());
						
						if(!rubroempleacuentacontable.getVersionRow().equals(timestamp)) {	
							rubroempleacuentacontableAux.setVersionRow(timestamp);
						}
								
						rubroempleacuentacontableAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowRubroEmpleaCuentaContables()throws Exception {	
		if(rubroempleacuentacontables!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(RubroEmpleaCuentaContable rubroempleacuentacontableAux:rubroempleacuentacontables) {
					if(rubroempleacuentacontableAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(rubroempleacuentacontableAux.getIsDeleted() || (rubroempleacuentacontableAux.getIsChanged()&&!rubroempleacuentacontableAux.getIsNew())) {
						
						timestamp=rubroempleacuentacontableDataAccess.getSetVersionRowRubroEmpleaCuentaContable(connexion,rubroempleacuentacontableAux.getId());
						
						if(!rubroempleacuentacontableAux.getVersionRow().equals(timestamp)) {	
							rubroempleacuentacontableAux.setVersionRow(timestamp);
						}
						
													
						rubroempleacuentacontableAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public RubroEmpleaCuentaContableParameterReturnGeneral cargarCombosLoteForeignKeyRubroEmpleaCuentaContableWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalRubroEmplea,String finalQueryGlobalCuentaContable,String finalQueryGlobalEstructura) throws Exception {
		RubroEmpleaCuentaContableParameterReturnGeneral  rubroempleacuentacontableReturnGeneral =new RubroEmpleaCuentaContableParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleaCuentaContable.class.getSimpleName()+"-cargarCombosLoteForeignKeyRubroEmpleaCuentaContableWithConnection");connexion.begin();
			
			rubroempleacuentacontableReturnGeneral =new RubroEmpleaCuentaContableParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			rubroempleacuentacontableReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			rubroempleacuentacontableReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<RubroEmplea> rubroempleasForeignKey=new ArrayList<RubroEmplea>();
			RubroEmpleaLogic rubroempleaLogic=new RubroEmpleaLogic();
			rubroempleaLogic.setConnexion(this.connexion);
			rubroempleaLogic.getRubroEmpleaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRubroEmplea.equals("NONE")) {
				rubroempleaLogic.getTodosRubroEmpleas(finalQueryGlobalRubroEmplea,new Pagination());
				rubroempleasForeignKey=rubroempleaLogic.getRubroEmpleas();
			}

			rubroempleacuentacontableReturnGeneral.setrubroempleasForeignKey(rubroempleasForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			rubroempleacuentacontableReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			rubroempleacuentacontableReturnGeneral.setestructurasForeignKey(estructurasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return rubroempleacuentacontableReturnGeneral;
	}
	
	public RubroEmpleaCuentaContableParameterReturnGeneral cargarCombosLoteForeignKeyRubroEmpleaCuentaContable(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalRubroEmplea,String finalQueryGlobalCuentaContable,String finalQueryGlobalEstructura) throws Exception {
		RubroEmpleaCuentaContableParameterReturnGeneral  rubroempleacuentacontableReturnGeneral =new RubroEmpleaCuentaContableParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			rubroempleacuentacontableReturnGeneral =new RubroEmpleaCuentaContableParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			rubroempleacuentacontableReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			rubroempleacuentacontableReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<RubroEmplea> rubroempleasForeignKey=new ArrayList<RubroEmplea>();
			RubroEmpleaLogic rubroempleaLogic=new RubroEmpleaLogic();
			rubroempleaLogic.setConnexion(this.connexion);
			rubroempleaLogic.getRubroEmpleaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRubroEmplea.equals("NONE")) {
				rubroempleaLogic.getTodosRubroEmpleas(finalQueryGlobalRubroEmplea,new Pagination());
				rubroempleasForeignKey=rubroempleaLogic.getRubroEmpleas();
			}

			rubroempleacuentacontableReturnGeneral.setrubroempleasForeignKey(rubroempleasForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			rubroempleacuentacontableReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<Estructura> estructurasForeignKey=new ArrayList<Estructura>();
			EstructuraLogic estructuraLogic=new EstructuraLogic();
			estructuraLogic.setConnexion(this.connexion);
			estructuraLogic.getEstructuraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEstructura.equals("NONE")) {
				estructuraLogic.getTodosEstructuras(finalQueryGlobalEstructura,new Pagination());
				estructurasForeignKey=estructuraLogic.getEstructuras();
			}

			rubroempleacuentacontableReturnGeneral.setestructurasForeignKey(estructurasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return rubroempleacuentacontableReturnGeneral;
	}
	
	
	public void deepLoad(RubroEmpleaCuentaContable rubroempleacuentacontable,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			RubroEmpleaCuentaContableLogicAdditional.updateRubroEmpleaCuentaContableToGet(rubroempleacuentacontable,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		rubroempleacuentacontable.setEmpresa(rubroempleacuentacontableDataAccess.getEmpresa(connexion,rubroempleacuentacontable));
		rubroempleacuentacontable.setSucursal(rubroempleacuentacontableDataAccess.getSucursal(connexion,rubroempleacuentacontable));
		rubroempleacuentacontable.setRubroEmplea(rubroempleacuentacontableDataAccess.getRubroEmplea(connexion,rubroempleacuentacontable));
		rubroempleacuentacontable.setCuentaContable(rubroempleacuentacontableDataAccess.getCuentaContable(connexion,rubroempleacuentacontable));
		rubroempleacuentacontable.setEstructura(rubroempleacuentacontableDataAccess.getEstructura(connexion,rubroempleacuentacontable));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				rubroempleacuentacontable.setEmpresa(rubroempleacuentacontableDataAccess.getEmpresa(connexion,rubroempleacuentacontable));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				rubroempleacuentacontable.setSucursal(rubroempleacuentacontableDataAccess.getSucursal(connexion,rubroempleacuentacontable));
				continue;
			}

			if(clas.clas.equals(RubroEmplea.class)) {
				rubroempleacuentacontable.setRubroEmplea(rubroempleacuentacontableDataAccess.getRubroEmplea(connexion,rubroempleacuentacontable));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				rubroempleacuentacontable.setCuentaContable(rubroempleacuentacontableDataAccess.getCuentaContable(connexion,rubroempleacuentacontable));
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				rubroempleacuentacontable.setEstructura(rubroempleacuentacontableDataAccess.getEstructura(connexion,rubroempleacuentacontable));
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
			rubroempleacuentacontable.setEmpresa(rubroempleacuentacontableDataAccess.getEmpresa(connexion,rubroempleacuentacontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			rubroempleacuentacontable.setSucursal(rubroempleacuentacontableDataAccess.getSucursal(connexion,rubroempleacuentacontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RubroEmplea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			rubroempleacuentacontable.setRubroEmplea(rubroempleacuentacontableDataAccess.getRubroEmplea(connexion,rubroempleacuentacontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			rubroempleacuentacontable.setCuentaContable(rubroempleacuentacontableDataAccess.getCuentaContable(connexion,rubroempleacuentacontable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			rubroempleacuentacontable.setEstructura(rubroempleacuentacontableDataAccess.getEstructura(connexion,rubroempleacuentacontable));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		rubroempleacuentacontable.setEmpresa(rubroempleacuentacontableDataAccess.getEmpresa(connexion,rubroempleacuentacontable));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(rubroempleacuentacontable.getEmpresa(),isDeep,deepLoadType,clases);
				
		rubroempleacuentacontable.setSucursal(rubroempleacuentacontableDataAccess.getSucursal(connexion,rubroempleacuentacontable));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(rubroempleacuentacontable.getSucursal(),isDeep,deepLoadType,clases);
				
		rubroempleacuentacontable.setRubroEmplea(rubroempleacuentacontableDataAccess.getRubroEmplea(connexion,rubroempleacuentacontable));
		RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
		rubroempleaLogic.deepLoad(rubroempleacuentacontable.getRubroEmplea(),isDeep,deepLoadType,clases);
				
		rubroempleacuentacontable.setCuentaContable(rubroempleacuentacontableDataAccess.getCuentaContable(connexion,rubroempleacuentacontable));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(rubroempleacuentacontable.getCuentaContable(),isDeep,deepLoadType,clases);
				
		rubroempleacuentacontable.setEstructura(rubroempleacuentacontableDataAccess.getEstructura(connexion,rubroempleacuentacontable));
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(rubroempleacuentacontable.getEstructura(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				rubroempleacuentacontable.setEmpresa(rubroempleacuentacontableDataAccess.getEmpresa(connexion,rubroempleacuentacontable));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(rubroempleacuentacontable.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				rubroempleacuentacontable.setSucursal(rubroempleacuentacontableDataAccess.getSucursal(connexion,rubroempleacuentacontable));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(rubroempleacuentacontable.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(RubroEmplea.class)) {
				rubroempleacuentacontable.setRubroEmplea(rubroempleacuentacontableDataAccess.getRubroEmplea(connexion,rubroempleacuentacontable));
				RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
				rubroempleaLogic.deepLoad(rubroempleacuentacontable.getRubroEmplea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				rubroempleacuentacontable.setCuentaContable(rubroempleacuentacontableDataAccess.getCuentaContable(connexion,rubroempleacuentacontable));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(rubroempleacuentacontable.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				rubroempleacuentacontable.setEstructura(rubroempleacuentacontableDataAccess.getEstructura(connexion,rubroempleacuentacontable));
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepLoad(rubroempleacuentacontable.getEstructura(),isDeep,deepLoadType,clases);				
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
			rubroempleacuentacontable.setEmpresa(rubroempleacuentacontableDataAccess.getEmpresa(connexion,rubroempleacuentacontable));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(rubroempleacuentacontable.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			rubroempleacuentacontable.setSucursal(rubroempleacuentacontableDataAccess.getSucursal(connexion,rubroempleacuentacontable));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(rubroempleacuentacontable.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(RubroEmplea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			rubroempleacuentacontable.setRubroEmplea(rubroempleacuentacontableDataAccess.getRubroEmplea(connexion,rubroempleacuentacontable));
			RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
			rubroempleaLogic.deepLoad(rubroempleacuentacontable.getRubroEmplea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			rubroempleacuentacontable.setCuentaContable(rubroempleacuentacontableDataAccess.getCuentaContable(connexion,rubroempleacuentacontable));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(rubroempleacuentacontable.getCuentaContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Estructura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			rubroempleacuentacontable.setEstructura(rubroempleacuentacontableDataAccess.getEstructura(connexion,rubroempleacuentacontable));
			EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
			estructuraLogic.deepLoad(rubroempleacuentacontable.getEstructura(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(RubroEmpleaCuentaContable rubroempleacuentacontable,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			RubroEmpleaCuentaContableLogicAdditional.updateRubroEmpleaCuentaContableToSave(rubroempleacuentacontable,this.arrDatoGeneral);
			
RubroEmpleaCuentaContableDataAccess.save(rubroempleacuentacontable, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(rubroempleacuentacontable.getEmpresa(),connexion);

		SucursalDataAccess.save(rubroempleacuentacontable.getSucursal(),connexion);

		RubroEmpleaDataAccess.save(rubroempleacuentacontable.getRubroEmplea(),connexion);

		CuentaContableDataAccess.save(rubroempleacuentacontable.getCuentaContable(),connexion);

		EstructuraDataAccess.save(rubroempleacuentacontable.getEstructura(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(rubroempleacuentacontable.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(rubroempleacuentacontable.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(RubroEmplea.class)) {
				RubroEmpleaDataAccess.save(rubroempleacuentacontable.getRubroEmplea(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(rubroempleacuentacontable.getCuentaContable(),connexion);
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(rubroempleacuentacontable.getEstructura(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(rubroempleacuentacontable.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(rubroempleacuentacontable.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(rubroempleacuentacontable.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(rubroempleacuentacontable.getSucursal(),isDeep,deepLoadType,clases);
				

		RubroEmpleaDataAccess.save(rubroempleacuentacontable.getRubroEmplea(),connexion);
		RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
		rubroempleaLogic.deepLoad(rubroempleacuentacontable.getRubroEmplea(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(rubroempleacuentacontable.getCuentaContable(),connexion);
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(rubroempleacuentacontable.getCuentaContable(),isDeep,deepLoadType,clases);
				

		EstructuraDataAccess.save(rubroempleacuentacontable.getEstructura(),connexion);
		EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
		estructuraLogic.deepLoad(rubroempleacuentacontable.getEstructura(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(rubroempleacuentacontable.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(rubroempleacuentacontable.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(rubroempleacuentacontable.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(rubroempleacuentacontable.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(RubroEmplea.class)) {
				RubroEmpleaDataAccess.save(rubroempleacuentacontable.getRubroEmplea(),connexion);
				RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
				rubroempleaLogic.deepSave(rubroempleacuentacontable.getRubroEmplea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(rubroempleacuentacontable.getCuentaContable(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(rubroempleacuentacontable.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Estructura.class)) {
				EstructuraDataAccess.save(rubroempleacuentacontable.getEstructura(),connexion);
				EstructuraLogic estructuraLogic= new EstructuraLogic(connexion);
				estructuraLogic.deepSave(rubroempleacuentacontable.getEstructura(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(RubroEmpleaCuentaContable.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(rubroempleacuentacontable,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RubroEmpleaCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleaCuentaContable(rubroempleacuentacontable);
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
			this.deepLoad(this.rubroempleacuentacontable,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RubroEmpleaCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleaCuentaContable(this.rubroempleacuentacontable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(RubroEmpleaCuentaContable.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(rubroempleacuentacontables!=null) {
				for(RubroEmpleaCuentaContable rubroempleacuentacontable:rubroempleacuentacontables) {
					this.deepLoad(rubroempleacuentacontable,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					RubroEmpleaCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleaCuentaContable(rubroempleacuentacontables);
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
			if(rubroempleacuentacontables!=null) {
				for(RubroEmpleaCuentaContable rubroempleacuentacontable:rubroempleacuentacontables) {
					this.deepLoad(rubroempleacuentacontable,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					RubroEmpleaCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleaCuentaContable(rubroempleacuentacontables);
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
			this.getNewConnexionToDeep(RubroEmpleaCuentaContable.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(rubroempleacuentacontable,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(RubroEmpleaCuentaContable.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(rubroempleacuentacontables!=null) {
				for(RubroEmpleaCuentaContable rubroempleacuentacontable:rubroempleacuentacontables) {
					this.deepSave(rubroempleacuentacontable,isDeep,deepLoadType,clases);
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
			if(rubroempleacuentacontables!=null) {
				for(RubroEmpleaCuentaContable rubroempleacuentacontable:rubroempleacuentacontables) {
					this.deepSave(rubroempleacuentacontable,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getRubroEmpleaCuentaContablesFK_IdCuentaContableWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleaCuentaContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,RubroEmpleaCuentaContableConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			RubroEmpleaCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rubroempleacuentacontables=rubroempleacuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RubroEmpleaCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleaCuentaContable(this.rubroempleacuentacontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRubroEmpleaCuentaContablesFK_IdCuentaContable(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,RubroEmpleaCuentaContableConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			RubroEmpleaCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rubroempleacuentacontables=rubroempleacuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RubroEmpleaCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleaCuentaContable(this.rubroempleacuentacontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRubroEmpleaCuentaContablesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleaCuentaContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,RubroEmpleaCuentaContableConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			RubroEmpleaCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rubroempleacuentacontables=rubroempleacuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RubroEmpleaCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleaCuentaContable(this.rubroempleacuentacontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRubroEmpleaCuentaContablesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,RubroEmpleaCuentaContableConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			RubroEmpleaCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rubroempleacuentacontables=rubroempleacuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RubroEmpleaCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleaCuentaContable(this.rubroempleacuentacontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRubroEmpleaCuentaContablesFK_IdEstructuraWithConnection(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleaCuentaContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,RubroEmpleaCuentaContableConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			RubroEmpleaCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rubroempleacuentacontables=rubroempleacuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RubroEmpleaCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleaCuentaContable(this.rubroempleacuentacontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRubroEmpleaCuentaContablesFK_IdEstructura(String sFinalQuery,Pagination pagination,Long id_estructura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEstructura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEstructura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_estructura,RubroEmpleaCuentaContableConstantesFunciones.IDESTRUCTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEstructura);

			RubroEmpleaCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEstructura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rubroempleacuentacontables=rubroempleacuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RubroEmpleaCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleaCuentaContable(this.rubroempleacuentacontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRubroEmpleaCuentaContablesFK_IdRubroEmpleaWithConnection(String sFinalQuery,Pagination pagination,Long id_rubro_emplea)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleaCuentaContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRubroEmplea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRubroEmplea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_rubro_emplea,RubroEmpleaCuentaContableConstantesFunciones.IDRUBROEMPLEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRubroEmplea);

			RubroEmpleaCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRubroEmplea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rubroempleacuentacontables=rubroempleacuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RubroEmpleaCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleaCuentaContable(this.rubroempleacuentacontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRubroEmpleaCuentaContablesFK_IdRubroEmplea(String sFinalQuery,Pagination pagination,Long id_rubro_emplea)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRubroEmplea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRubroEmplea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_rubro_emplea,RubroEmpleaCuentaContableConstantesFunciones.IDRUBROEMPLEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRubroEmplea);

			RubroEmpleaCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRubroEmplea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rubroempleacuentacontables=rubroempleacuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RubroEmpleaCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleaCuentaContable(this.rubroempleacuentacontables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRubroEmpleaCuentaContablesFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmpleaCuentaContable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,RubroEmpleaCuentaContableConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			RubroEmpleaCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rubroempleacuentacontables=rubroempleacuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RubroEmpleaCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleaCuentaContable(this.rubroempleacuentacontables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRubroEmpleaCuentaContablesFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,RubroEmpleaCuentaContableConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			RubroEmpleaCuentaContableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rubroempleacuentacontables=rubroempleacuentacontableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RubroEmpleaCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleaCuentaContable(this.rubroempleacuentacontables);
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
			if(RubroEmpleaCuentaContableConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,RubroEmpleaCuentaContableDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,RubroEmpleaCuentaContable rubroempleacuentacontable,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(RubroEmpleaCuentaContableConstantesFunciones.ISCONAUDITORIA) {
				if(rubroempleacuentacontable.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RubroEmpleaCuentaContableDataAccess.TABLENAME, rubroempleacuentacontable.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(RubroEmpleaCuentaContableConstantesFunciones.ISCONAUDITORIADETALLE) {
						////RubroEmpleaCuentaContableLogic.registrarAuditoriaDetallesRubroEmpleaCuentaContable(connexion,rubroempleacuentacontable,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(rubroempleacuentacontable.getIsDeleted()) {
					/*if(!rubroempleacuentacontable.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,RubroEmpleaCuentaContableDataAccess.TABLENAME, rubroempleacuentacontable.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////RubroEmpleaCuentaContableLogic.registrarAuditoriaDetallesRubroEmpleaCuentaContable(connexion,rubroempleacuentacontable,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RubroEmpleaCuentaContableDataAccess.TABLENAME, rubroempleacuentacontable.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(rubroempleacuentacontable.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RubroEmpleaCuentaContableDataAccess.TABLENAME, rubroempleacuentacontable.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(RubroEmpleaCuentaContableConstantesFunciones.ISCONAUDITORIADETALLE) {
						////RubroEmpleaCuentaContableLogic.registrarAuditoriaDetallesRubroEmpleaCuentaContable(connexion,rubroempleacuentacontable,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesRubroEmpleaCuentaContable(Connexion connexion,RubroEmpleaCuentaContable rubroempleacuentacontable)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(rubroempleacuentacontable.getIsNew()||!rubroempleacuentacontable.getid_empresa().equals(rubroempleacuentacontable.getRubroEmpleaCuentaContableOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rubroempleacuentacontable.getRubroEmpleaCuentaContableOriginal().getid_empresa()!=null)
				{
					strValorActual=rubroempleacuentacontable.getRubroEmpleaCuentaContableOriginal().getid_empresa().toString();
				}
				if(rubroempleacuentacontable.getid_empresa()!=null)
				{
					strValorNuevo=rubroempleacuentacontable.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RubroEmpleaCuentaContableConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(rubroempleacuentacontable.getIsNew()||!rubroempleacuentacontable.getid_sucursal().equals(rubroempleacuentacontable.getRubroEmpleaCuentaContableOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rubroempleacuentacontable.getRubroEmpleaCuentaContableOriginal().getid_sucursal()!=null)
				{
					strValorActual=rubroempleacuentacontable.getRubroEmpleaCuentaContableOriginal().getid_sucursal().toString();
				}
				if(rubroempleacuentacontable.getid_sucursal()!=null)
				{
					strValorNuevo=rubroempleacuentacontable.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RubroEmpleaCuentaContableConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(rubroempleacuentacontable.getIsNew()||!rubroempleacuentacontable.getid_rubro_emplea().equals(rubroempleacuentacontable.getRubroEmpleaCuentaContableOriginal().getid_rubro_emplea()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rubroempleacuentacontable.getRubroEmpleaCuentaContableOriginal().getid_rubro_emplea()!=null)
				{
					strValorActual=rubroempleacuentacontable.getRubroEmpleaCuentaContableOriginal().getid_rubro_emplea().toString();
				}
				if(rubroempleacuentacontable.getid_rubro_emplea()!=null)
				{
					strValorNuevo=rubroempleacuentacontable.getid_rubro_emplea().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RubroEmpleaCuentaContableConstantesFunciones.IDRUBROEMPLEA,strValorActual,strValorNuevo);
			}	
			
			if(rubroempleacuentacontable.getIsNew()||!rubroempleacuentacontable.getid_cuenta_contable().equals(rubroempleacuentacontable.getRubroEmpleaCuentaContableOriginal().getid_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rubroempleacuentacontable.getRubroEmpleaCuentaContableOriginal().getid_cuenta_contable()!=null)
				{
					strValorActual=rubroempleacuentacontable.getRubroEmpleaCuentaContableOriginal().getid_cuenta_contable().toString();
				}
				if(rubroempleacuentacontable.getid_cuenta_contable()!=null)
				{
					strValorNuevo=rubroempleacuentacontable.getid_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RubroEmpleaCuentaContableConstantesFunciones.IDCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(rubroempleacuentacontable.getIsNew()||!rubroempleacuentacontable.getid_estructura().equals(rubroempleacuentacontable.getRubroEmpleaCuentaContableOriginal().getid_estructura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rubroempleacuentacontable.getRubroEmpleaCuentaContableOriginal().getid_estructura()!=null)
				{
					strValorActual=rubroempleacuentacontable.getRubroEmpleaCuentaContableOriginal().getid_estructura().toString();
				}
				if(rubroempleacuentacontable.getid_estructura()!=null)
				{
					strValorNuevo=rubroempleacuentacontable.getid_estructura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RubroEmpleaCuentaContableConstantesFunciones.IDESTRUCTURA,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveRubroEmpleaCuentaContableRelacionesWithConnection(RubroEmpleaCuentaContable rubroempleacuentacontable) throws Exception {

		if(!rubroempleacuentacontable.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveRubroEmpleaCuentaContableRelacionesBase(rubroempleacuentacontable,true);
		}
	}

	public void saveRubroEmpleaCuentaContableRelaciones(RubroEmpleaCuentaContable rubroempleacuentacontable)throws Exception {

		if(!rubroempleacuentacontable.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveRubroEmpleaCuentaContableRelacionesBase(rubroempleacuentacontable,false);
		}
	}

	public void saveRubroEmpleaCuentaContableRelacionesBase(RubroEmpleaCuentaContable rubroempleacuentacontable,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("RubroEmpleaCuentaContable-saveRelacionesWithConnection");}
	

			this.setRubroEmpleaCuentaContable(rubroempleacuentacontable);

			if(RubroEmpleaCuentaContableLogicAdditional.validarSaveRelaciones(rubroempleacuentacontable,this)) {

				RubroEmpleaCuentaContableLogicAdditional.updateRelacionesToSave(rubroempleacuentacontable,this);

				if((rubroempleacuentacontable.getIsNew()||rubroempleacuentacontable.getIsChanged())&&!rubroempleacuentacontable.getIsDeleted()) {
					this.saveRubroEmpleaCuentaContable();
					this.saveRubroEmpleaCuentaContableRelacionesDetalles();

				} else if(rubroempleacuentacontable.getIsDeleted()) {
					this.saveRubroEmpleaCuentaContableRelacionesDetalles();
					this.saveRubroEmpleaCuentaContable();
				}

				RubroEmpleaCuentaContableLogicAdditional.updateRelacionesToSaveAfter(rubroempleacuentacontable,this);

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
	
	
	private void saveRubroEmpleaCuentaContableRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfRubroEmpleaCuentaContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=RubroEmpleaCuentaContableConstantesFunciones.getClassesForeignKeysOfRubroEmpleaCuentaContable(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRubroEmpleaCuentaContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=RubroEmpleaCuentaContableConstantesFunciones.getClassesRelationshipsOfRubroEmpleaCuentaContable(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

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
import com.bydan.erp.nomina.util.RubroEmpleaConstantesFunciones;
import com.bydan.erp.nomina.util.RubroEmpleaParameterReturnGeneral;
//import com.bydan.erp.nomina.util.RubroEmpleaParameterGeneral;
import com.bydan.erp.nomina.business.entity.RubroEmplea;
import com.bydan.erp.nomina.business.logic.RubroEmpleaLogicAdditional;
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
public class RubroEmpleaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(RubroEmpleaLogic.class);
	
	protected RubroEmpleaDataAccess rubroempleaDataAccess; 	
	protected RubroEmplea rubroemplea;
	protected List<RubroEmplea> rubroempleas;
	protected Object rubroempleaObject;	
	protected List<Object> rubroempleasObject;
	
	public static ClassValidator<RubroEmplea> rubroempleaValidator = new ClassValidator<RubroEmplea>(RubroEmplea.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected RubroEmpleaLogicAdditional rubroempleaLogicAdditional=null;
	
	public RubroEmpleaLogicAdditional getRubroEmpleaLogicAdditional() {
		return this.rubroempleaLogicAdditional;
	}
	
	public void setRubroEmpleaLogicAdditional(RubroEmpleaLogicAdditional rubroempleaLogicAdditional) {
		try {
			this.rubroempleaLogicAdditional=rubroempleaLogicAdditional;
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
	
	
	
	
	public  RubroEmpleaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.rubroempleaDataAccess = new RubroEmpleaDataAccess();
			
			this.rubroempleas= new ArrayList<RubroEmplea>();
			this.rubroemplea= new RubroEmplea();
			
			this.rubroempleaObject=new Object();
			this.rubroempleasObject=new ArrayList<Object>();
				
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
			
			this.rubroempleaDataAccess.setConnexionType(this.connexionType);
			this.rubroempleaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  RubroEmpleaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.rubroempleaDataAccess = new RubroEmpleaDataAccess();
			this.rubroempleas= new ArrayList<RubroEmplea>();
			this.rubroemplea= new RubroEmplea();
			this.rubroempleaObject=new Object();
			this.rubroempleasObject=new ArrayList<Object>();
			
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
			
			this.rubroempleaDataAccess.setConnexionType(this.connexionType);
			this.rubroempleaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public RubroEmplea getRubroEmplea() throws Exception {	
		RubroEmpleaLogicAdditional.checkRubroEmpleaToGet(rubroemplea,this.datosCliente,this.arrDatoGeneral);
		RubroEmpleaLogicAdditional.updateRubroEmpleaToGet(rubroemplea,this.arrDatoGeneral);
		
		return rubroemplea;
	}
		
	public void setRubroEmplea(RubroEmplea newRubroEmplea) {
		this.rubroemplea = newRubroEmplea;
	}
	
	public RubroEmpleaDataAccess getRubroEmpleaDataAccess() {
		return rubroempleaDataAccess;
	}
	
	public void setRubroEmpleaDataAccess(RubroEmpleaDataAccess newrubroempleaDataAccess) {
		this.rubroempleaDataAccess = newrubroempleaDataAccess;
	}
	
	public List<RubroEmplea> getRubroEmpleas() throws Exception {		
		this.quitarRubroEmpleasNulos();
		
		RubroEmpleaLogicAdditional.checkRubroEmpleaToGets(rubroempleas,this.datosCliente,this.arrDatoGeneral);
		
		for (RubroEmplea rubroempleaLocal: rubroempleas ) {
			RubroEmpleaLogicAdditional.updateRubroEmpleaToGet(rubroempleaLocal,this.arrDatoGeneral);
		}
		
		return rubroempleas;
	}
	
	public void setRubroEmpleas(List<RubroEmplea> newRubroEmpleas) {
		this.rubroempleas = newRubroEmpleas;
	}
	
	public Object getRubroEmpleaObject() {	
		this.rubroempleaObject=this.rubroempleaDataAccess.getEntityObject();
		return this.rubroempleaObject;
	}
		
	public void setRubroEmpleaObject(Object newRubroEmpleaObject) {
		this.rubroempleaObject = newRubroEmpleaObject;
	}
	
	public List<Object> getRubroEmpleasObject() {		
		this.rubroempleasObject=this.rubroempleaDataAccess.getEntitiesObject();
		return this.rubroempleasObject;
	}
		
	public void setRubroEmpleasObject(List<Object> newRubroEmpleasObject) {
		this.rubroempleasObject = newRubroEmpleasObject;
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
		
		if(this.rubroempleaDataAccess!=null) {
			this.rubroempleaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmplea.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			rubroempleaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			rubroempleaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		rubroemplea = new  RubroEmplea();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmplea.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			rubroemplea=rubroempleaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.rubroemplea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmplea(this.rubroemplea);
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
		rubroemplea = new  RubroEmplea();
		  		  
        try {
			
			rubroemplea=rubroempleaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.rubroemplea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmplea(this.rubroemplea);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		rubroemplea = new  RubroEmplea();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmplea.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			rubroemplea=rubroempleaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.rubroemplea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmplea(this.rubroemplea);
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
		rubroemplea = new  RubroEmplea();
		  		  
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
		rubroemplea = new  RubroEmplea();
		  		  
        try {
			
			rubroemplea=rubroempleaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.rubroemplea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				RubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmplea(this.rubroemplea);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		rubroemplea = new  RubroEmplea();
		  		  
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
		rubroemplea = new  RubroEmplea();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmplea.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =rubroempleaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		rubroemplea = new  RubroEmplea();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=rubroempleaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		rubroemplea = new  RubroEmplea();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmplea.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =rubroempleaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		rubroemplea = new  RubroEmplea();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=rubroempleaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		rubroemplea = new  RubroEmplea();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmplea.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =rubroempleaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		rubroemplea = new  RubroEmplea();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=rubroempleaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		rubroempleas = new  ArrayList<RubroEmplea>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmplea.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			RubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroempleas=rubroempleaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRubroEmplea(rubroempleas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmplea(this.rubroempleas);
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
		rubroempleas = new  ArrayList<RubroEmplea>();
		  		  
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
		rubroempleas = new  ArrayList<RubroEmplea>();
		  		  
        try {			
			RubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroempleas=rubroempleaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarRubroEmplea(rubroempleas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmplea(this.rubroempleas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		rubroempleas = new  ArrayList<RubroEmplea>();
		  		  
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
		rubroempleas = new  ArrayList<RubroEmplea>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmplea.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			RubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroempleas=rubroempleaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRubroEmplea(rubroempleas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmplea(this.rubroempleas);
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
		rubroempleas = new  ArrayList<RubroEmplea>();
		  		  
        try {
			RubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroempleas=rubroempleaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRubroEmplea(rubroempleas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmplea(this.rubroempleas);
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
		rubroempleas = new  ArrayList<RubroEmplea>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmplea.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroempleas=rubroempleaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRubroEmplea(rubroempleas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmplea(this.rubroempleas);
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
		rubroempleas = new  ArrayList<RubroEmplea>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroempleas=rubroempleaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRubroEmplea(rubroempleas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmplea(this.rubroempleas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		rubroemplea = new  RubroEmplea();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmplea.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroemplea=rubroempleaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRubroEmplea(rubroemplea);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmplea(this.rubroemplea);
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
		rubroemplea = new  RubroEmplea();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroemplea=rubroempleaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarRubroEmplea(rubroemplea);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmplea(this.rubroemplea);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		rubroempleas = new  ArrayList<RubroEmplea>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmplea.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			RubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroempleas=rubroempleaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRubroEmplea(rubroempleas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmplea(this.rubroempleas);
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
		rubroempleas = new  ArrayList<RubroEmplea>();
		  		  
        try {
			RubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroempleas=rubroempleaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarRubroEmplea(rubroempleas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmplea(this.rubroempleas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosRubroEmpleasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		rubroempleas = new  ArrayList<RubroEmplea>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmplea.class.getSimpleName()+"-getTodosRubroEmpleasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroempleas=rubroempleaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarRubroEmplea(rubroempleas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmplea(this.rubroempleas);
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
	
	public  void  getTodosRubroEmpleas(String sFinalQuery,Pagination pagination)throws Exception {
		rubroempleas = new  ArrayList<RubroEmplea>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			RubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			rubroempleas=rubroempleaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarRubroEmplea(rubroempleas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				RubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmplea(this.rubroempleas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarRubroEmplea(RubroEmplea rubroemplea) throws Exception {
		Boolean estaValidado=false;
		
		if(rubroemplea.getIsNew() || rubroemplea.getIsChanged()) { 
			this.invalidValues = rubroempleaValidator.getInvalidValues(rubroemplea);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(rubroemplea);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarRubroEmplea(List<RubroEmplea> RubroEmpleas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(RubroEmplea rubroempleaLocal:rubroempleas) {				
			estaValidadoObjeto=this.validarGuardarRubroEmplea(rubroempleaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarRubroEmplea(List<RubroEmplea> RubroEmpleas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarRubroEmplea(rubroempleas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarRubroEmplea(RubroEmplea RubroEmplea) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarRubroEmplea(rubroemplea)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(RubroEmplea rubroemplea) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+rubroemplea.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=RubroEmpleaConstantesFunciones.getRubroEmpleaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"rubroemplea","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(RubroEmpleaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(RubroEmpleaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveRubroEmpleaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmplea.class.getSimpleName()+"-saveRubroEmpleaWithConnection");connexion.begin();			
			
			RubroEmpleaLogicAdditional.checkRubroEmpleaToSave(this.rubroemplea,this.datosCliente,connexion,this.arrDatoGeneral);
			
			RubroEmpleaLogicAdditional.updateRubroEmpleaToSave(this.rubroemplea,this.arrDatoGeneral);
			
			RubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.rubroemplea,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowRubroEmplea();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarRubroEmplea(this.rubroemplea)) {
				RubroEmpleaDataAccess.save(this.rubroemplea, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.rubroemplea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			RubroEmpleaLogicAdditional.checkRubroEmpleaToSaveAfter(this.rubroemplea,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowRubroEmplea();
			
			connexion.commit();			
			
			if(this.rubroemplea.getIsDeleted()) {
				this.rubroemplea=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveRubroEmplea()throws Exception {	
		try {	
			
			RubroEmpleaLogicAdditional.checkRubroEmpleaToSave(this.rubroemplea,this.datosCliente,connexion,this.arrDatoGeneral);
			
			RubroEmpleaLogicAdditional.updateRubroEmpleaToSave(this.rubroemplea,this.arrDatoGeneral);
			
			RubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.rubroemplea,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarRubroEmplea(this.rubroemplea)) {			
				RubroEmpleaDataAccess.save(this.rubroemplea, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.rubroemplea,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			RubroEmpleaLogicAdditional.checkRubroEmpleaToSaveAfter(this.rubroemplea,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.rubroemplea.getIsDeleted()) {
				this.rubroemplea=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveRubroEmpleasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmplea.class.getSimpleName()+"-saveRubroEmpleasWithConnection");connexion.begin();			
			
			RubroEmpleaLogicAdditional.checkRubroEmpleaToSaves(rubroempleas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowRubroEmpleas();
			
			Boolean validadoTodosRubroEmplea=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(RubroEmplea rubroempleaLocal:rubroempleas) {		
				if(rubroempleaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				RubroEmpleaLogicAdditional.updateRubroEmpleaToSave(rubroempleaLocal,this.arrDatoGeneral);
	        	
				RubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),rubroempleaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarRubroEmplea(rubroempleaLocal)) {
					RubroEmpleaDataAccess.save(rubroempleaLocal, connexion);				
				} else {
					validadoTodosRubroEmplea=false;
				}
			}
			
			if(!validadoTodosRubroEmplea) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			RubroEmpleaLogicAdditional.checkRubroEmpleaToSavesAfter(rubroempleas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowRubroEmpleas();
			
			connexion.commit();		
			
			this.quitarRubroEmpleasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveRubroEmpleas()throws Exception {				
		 try {	
			RubroEmpleaLogicAdditional.checkRubroEmpleaToSaves(rubroempleas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosRubroEmplea=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(RubroEmplea rubroempleaLocal:rubroempleas) {				
				if(rubroempleaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				RubroEmpleaLogicAdditional.updateRubroEmpleaToSave(rubroempleaLocal,this.arrDatoGeneral);
	        	
				RubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),rubroempleaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarRubroEmplea(rubroempleaLocal)) {				
					RubroEmpleaDataAccess.save(rubroempleaLocal, connexion);				
				} else {
					validadoTodosRubroEmplea=false;
				}
			}
			
			if(!validadoTodosRubroEmplea) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			RubroEmpleaLogicAdditional.checkRubroEmpleaToSavesAfter(rubroempleas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarRubroEmpleasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RubroEmpleaParameterReturnGeneral procesarAccionRubroEmpleas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<RubroEmplea> rubroempleas,RubroEmpleaParameterReturnGeneral rubroempleaParameterGeneral)throws Exception {
		 try {	
			RubroEmpleaParameterReturnGeneral rubroempleaReturnGeneral=new RubroEmpleaParameterReturnGeneral();
	
			RubroEmpleaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,rubroempleas,rubroempleaParameterGeneral,rubroempleaReturnGeneral);
			
			return rubroempleaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public RubroEmpleaParameterReturnGeneral procesarAccionRubroEmpleasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<RubroEmplea> rubroempleas,RubroEmpleaParameterReturnGeneral rubroempleaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmplea.class.getSimpleName()+"-procesarAccionRubroEmpleasWithConnection");connexion.begin();			
			
			RubroEmpleaParameterReturnGeneral rubroempleaReturnGeneral=new RubroEmpleaParameterReturnGeneral();
	
			RubroEmpleaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,rubroempleas,rubroempleaParameterGeneral,rubroempleaReturnGeneral);
			
			this.connexion.commit();
			
			return rubroempleaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public RubroEmpleaParameterReturnGeneral procesarEventosRubroEmpleas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<RubroEmplea> rubroempleas,RubroEmplea rubroemplea,RubroEmpleaParameterReturnGeneral rubroempleaParameterGeneral,Boolean isEsNuevoRubroEmplea,ArrayList<Classe> clases)throws Exception {
		 try {	
			RubroEmpleaParameterReturnGeneral rubroempleaReturnGeneral=new RubroEmpleaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				rubroempleaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			RubroEmpleaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,rubroempleas,rubroemplea,rubroempleaParameterGeneral,rubroempleaReturnGeneral,isEsNuevoRubroEmplea,clases);
			
			return rubroempleaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public RubroEmpleaParameterReturnGeneral procesarEventosRubroEmpleasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<RubroEmplea> rubroempleas,RubroEmplea rubroemplea,RubroEmpleaParameterReturnGeneral rubroempleaParameterGeneral,Boolean isEsNuevoRubroEmplea,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmplea.class.getSimpleName()+"-procesarEventosRubroEmpleasWithConnection");connexion.begin();			
			
			RubroEmpleaParameterReturnGeneral rubroempleaReturnGeneral=new RubroEmpleaParameterReturnGeneral();
	
			rubroempleaReturnGeneral.setRubroEmplea(rubroemplea);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				rubroempleaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			RubroEmpleaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,rubroempleas,rubroemplea,rubroempleaParameterGeneral,rubroempleaReturnGeneral,isEsNuevoRubroEmplea,clases);
			
			this.connexion.commit();
			
			return rubroempleaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public RubroEmpleaParameterReturnGeneral procesarImportacionRubroEmpleasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,RubroEmpleaParameterReturnGeneral rubroempleaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmplea.class.getSimpleName()+"-procesarImportacionRubroEmpleasWithConnection");connexion.begin();			
			
			RubroEmpleaParameterReturnGeneral rubroempleaReturnGeneral=new RubroEmpleaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.rubroempleas=new ArrayList<RubroEmplea>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.rubroemplea=new RubroEmplea();
				
				
				if(conColumnasBase) {this.rubroemplea.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.rubroemplea.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.rubroemplea.setcodigo(arrColumnas[iColumn++]);
				this.rubroemplea.setnombre(arrColumnas[iColumn++]);
				this.rubroemplea.setformula(arrColumnas[iColumn++]);
				this.rubroemplea.setalias(arrColumnas[iColumn++]);
				this.rubroemplea.setsecuencial(Integer.parseInt(arrColumnas[iColumn++]));
				this.rubroemplea.setpara_rol_pagos(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.rubroemplea.setpara_sueldo(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.rubroemplea.setpara_vacaciones(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.rubroemplea.setpara_impuesto_renta(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.rubroemplea.setpara_seguro_social(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.rubroemplea.setpara_provisiones(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.rubroemplea.setpara_utilidades(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.rubroemplea.setpara_rubro_iess(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.rubroemplea.setes_fondo_reserva(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.rubroemplea.setes_decimo_tercero(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.rubroemplea.setes_decimo_cuarto(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.rubroempleas.add(this.rubroemplea);
			}
			
			this.saveRubroEmpleas();
			
			this.connexion.commit();
			
			rubroempleaReturnGeneral.setConRetornoEstaProcesado(true);
			rubroempleaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return rubroempleaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarRubroEmpleasEliminados() throws Exception {				
		
		List<RubroEmplea> rubroempleasAux= new ArrayList<RubroEmplea>();
		
		for(RubroEmplea rubroemplea:rubroempleas) {
			if(!rubroemplea.getIsDeleted()) {
				rubroempleasAux.add(rubroemplea);
			}
		}
		
		rubroempleas=rubroempleasAux;
	}
	
	public void quitarRubroEmpleasNulos() throws Exception {				
		
		List<RubroEmplea> rubroempleasAux= new ArrayList<RubroEmplea>();
		
		for(RubroEmplea rubroemplea : this.rubroempleas) {
			if(rubroemplea==null) {
				rubroempleasAux.add(rubroemplea);
			}
		}
		
		//this.rubroempleas=rubroempleasAux;
		
		this.rubroempleas.removeAll(rubroempleasAux);
	}
	
	public void getSetVersionRowRubroEmpleaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(rubroemplea.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((rubroemplea.getIsDeleted() || (rubroemplea.getIsChanged()&&!rubroemplea.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=rubroempleaDataAccess.getSetVersionRowRubroEmplea(connexion,rubroemplea.getId());
				
				if(!rubroemplea.getVersionRow().equals(timestamp)) {	
					rubroemplea.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				rubroemplea.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowRubroEmplea()throws Exception {	
		
		if(rubroemplea.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((rubroemplea.getIsDeleted() || (rubroemplea.getIsChanged()&&!rubroemplea.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=rubroempleaDataAccess.getSetVersionRowRubroEmplea(connexion,rubroemplea.getId());
			
			try {							
				if(!rubroemplea.getVersionRow().equals(timestamp)) {	
					rubroemplea.setVersionRow(timestamp);
				}
				
				rubroemplea.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowRubroEmpleasWithConnection()throws Exception {	
		if(rubroempleas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(RubroEmplea rubroempleaAux:rubroempleas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(rubroempleaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(rubroempleaAux.getIsDeleted() || (rubroempleaAux.getIsChanged()&&!rubroempleaAux.getIsNew())) {
						
						timestamp=rubroempleaDataAccess.getSetVersionRowRubroEmplea(connexion,rubroempleaAux.getId());
						
						if(!rubroemplea.getVersionRow().equals(timestamp)) {	
							rubroempleaAux.setVersionRow(timestamp);
						}
								
						rubroempleaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowRubroEmpleas()throws Exception {	
		if(rubroempleas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(RubroEmplea rubroempleaAux:rubroempleas) {
					if(rubroempleaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(rubroempleaAux.getIsDeleted() || (rubroempleaAux.getIsChanged()&&!rubroempleaAux.getIsNew())) {
						
						timestamp=rubroempleaDataAccess.getSetVersionRowRubroEmplea(connexion,rubroempleaAux.getId());
						
						if(!rubroempleaAux.getVersionRow().equals(timestamp)) {	
							rubroempleaAux.setVersionRow(timestamp);
						}
						
													
						rubroempleaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public RubroEmpleaParameterReturnGeneral cargarCombosLoteForeignKeyRubroEmpleaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoCalculo,String finalQueryGlobalTipoRubroEmplea,String finalQueryGlobalTipoGrupoRubroEmplea) throws Exception {
		RubroEmpleaParameterReturnGeneral  rubroempleaReturnGeneral =new RubroEmpleaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmplea.class.getSimpleName()+"-cargarCombosLoteForeignKeyRubroEmpleaWithConnection");connexion.begin();
			
			rubroempleaReturnGeneral =new RubroEmpleaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			rubroempleaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoCalculo> tipocalculosForeignKey=new ArrayList<TipoCalculo>();
			TipoCalculoLogic tipocalculoLogic=new TipoCalculoLogic();
			tipocalculoLogic.setConnexion(this.connexion);
			tipocalculoLogic.getTipoCalculoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCalculo.equals("NONE")) {
				tipocalculoLogic.getTodosTipoCalculos(finalQueryGlobalTipoCalculo,new Pagination());
				tipocalculosForeignKey=tipocalculoLogic.getTipoCalculos();
			}

			rubroempleaReturnGeneral.settipocalculosForeignKey(tipocalculosForeignKey);


			List<TipoRubroEmplea> tiporubroempleasForeignKey=new ArrayList<TipoRubroEmplea>();
			TipoRubroEmpleaLogic tiporubroempleaLogic=new TipoRubroEmpleaLogic();
			tiporubroempleaLogic.setConnexion(this.connexion);
			tiporubroempleaLogic.getTipoRubroEmpleaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRubroEmplea.equals("NONE")) {
				tiporubroempleaLogic.getTodosTipoRubroEmpleas(finalQueryGlobalTipoRubroEmplea,new Pagination());
				tiporubroempleasForeignKey=tiporubroempleaLogic.getTipoRubroEmpleas();
			}

			rubroempleaReturnGeneral.settiporubroempleasForeignKey(tiporubroempleasForeignKey);


			List<TipoGrupoRubroEmplea> tipogruporubroempleasForeignKey=new ArrayList<TipoGrupoRubroEmplea>();
			TipoGrupoRubroEmpleaLogic tipogruporubroempleaLogic=new TipoGrupoRubroEmpleaLogic();
			tipogruporubroempleaLogic.setConnexion(this.connexion);
			tipogruporubroempleaLogic.getTipoGrupoRubroEmpleaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoGrupoRubroEmplea.equals("NONE")) {
				tipogruporubroempleaLogic.getTodosTipoGrupoRubroEmpleas(finalQueryGlobalTipoGrupoRubroEmplea,new Pagination());
				tipogruporubroempleasForeignKey=tipogruporubroempleaLogic.getTipoGrupoRubroEmpleas();
			}

			rubroempleaReturnGeneral.settipogruporubroempleasForeignKey(tipogruporubroempleasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return rubroempleaReturnGeneral;
	}
	
	public RubroEmpleaParameterReturnGeneral cargarCombosLoteForeignKeyRubroEmplea(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoCalculo,String finalQueryGlobalTipoRubroEmplea,String finalQueryGlobalTipoGrupoRubroEmplea) throws Exception {
		RubroEmpleaParameterReturnGeneral  rubroempleaReturnGeneral =new RubroEmpleaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			rubroempleaReturnGeneral =new RubroEmpleaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			rubroempleaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoCalculo> tipocalculosForeignKey=new ArrayList<TipoCalculo>();
			TipoCalculoLogic tipocalculoLogic=new TipoCalculoLogic();
			tipocalculoLogic.setConnexion(this.connexion);
			tipocalculoLogic.getTipoCalculoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoCalculo.equals("NONE")) {
				tipocalculoLogic.getTodosTipoCalculos(finalQueryGlobalTipoCalculo,new Pagination());
				tipocalculosForeignKey=tipocalculoLogic.getTipoCalculos();
			}

			rubroempleaReturnGeneral.settipocalculosForeignKey(tipocalculosForeignKey);


			List<TipoRubroEmplea> tiporubroempleasForeignKey=new ArrayList<TipoRubroEmplea>();
			TipoRubroEmpleaLogic tiporubroempleaLogic=new TipoRubroEmpleaLogic();
			tiporubroempleaLogic.setConnexion(this.connexion);
			tiporubroempleaLogic.getTipoRubroEmpleaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRubroEmplea.equals("NONE")) {
				tiporubroempleaLogic.getTodosTipoRubroEmpleas(finalQueryGlobalTipoRubroEmplea,new Pagination());
				tiporubroempleasForeignKey=tiporubroempleaLogic.getTipoRubroEmpleas();
			}

			rubroempleaReturnGeneral.settiporubroempleasForeignKey(tiporubroempleasForeignKey);


			List<TipoGrupoRubroEmplea> tipogruporubroempleasForeignKey=new ArrayList<TipoGrupoRubroEmplea>();
			TipoGrupoRubroEmpleaLogic tipogruporubroempleaLogic=new TipoGrupoRubroEmpleaLogic();
			tipogruporubroempleaLogic.setConnexion(this.connexion);
			tipogruporubroempleaLogic.getTipoGrupoRubroEmpleaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoGrupoRubroEmplea.equals("NONE")) {
				tipogruporubroempleaLogic.getTodosTipoGrupoRubroEmpleas(finalQueryGlobalTipoGrupoRubroEmplea,new Pagination());
				tipogruporubroempleasForeignKey=tipogruporubroempleaLogic.getTipoGrupoRubroEmpleas();
			}

			rubroempleaReturnGeneral.settipogruporubroempleasForeignKey(tipogruporubroempleasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return rubroempleaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyRubroEmpleaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			HistorialPagoNomiLogic historialpagonomiLogic=new HistorialPagoNomiLogic();
			RubroEstructuraLogic rubroestructuraLogic=new RubroEstructuraLogic();
			DefiProvisionEmpleadoLogic defiprovisionempleadoLogic=new DefiProvisionEmpleadoLogic();
			EmpleadoPagoRubroLogic empleadopagorubroLogic=new EmpleadoPagoRubroLogic();
			HistorialPagoMesNomiLogic historialpagomesnomiLogic=new HistorialPagoMesNomiLogic();
			RubroEmpleadoLogic rubroempleadoLogic=new RubroEmpleadoLogic();
			ValorRubroVariableLogic valorrubrovariableLogic=new ValorRubroVariableLogic();
			TipoPrestamoLogic tipoprestamoLogic=new TipoPrestamoLogic();
			RubroEmpleaCuentaContableLogic rubroempleacuentacontableLogic=new RubroEmpleaCuentaContableLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmplea.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyRubroEmpleaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(HistorialPagoNomi.class));
			classes.add(new Classe(RubroEstructura.class));
			classes.add(new Classe(DefiProvisionEmpleado.class));
			classes.add(new Classe(EmpleadoPagoRubro.class));
			classes.add(new Classe(HistorialPagoMesNomi.class));
			classes.add(new Classe(RubroEmpleado.class));
			classes.add(new Classe(ValorRubroVariable.class));
			classes.add(new Classe(TipoPrestamo.class));
			classes.add(new Classe(RubroEmpleaCuentaContable.class));
											
			

			historialpagonomiLogic.setConnexion(this.getConnexion());
			historialpagonomiLogic.setDatosCliente(this.datosCliente);
			historialpagonomiLogic.setIsConRefrescarForeignKeys(true);

			rubroestructuraLogic.setConnexion(this.getConnexion());
			rubroestructuraLogic.setDatosCliente(this.datosCliente);
			rubroestructuraLogic.setIsConRefrescarForeignKeys(true);

			defiprovisionempleadoLogic.setConnexion(this.getConnexion());
			defiprovisionempleadoLogic.setDatosCliente(this.datosCliente);
			defiprovisionempleadoLogic.setIsConRefrescarForeignKeys(true);

			empleadopagorubroLogic.setConnexion(this.getConnexion());
			empleadopagorubroLogic.setDatosCliente(this.datosCliente);
			empleadopagorubroLogic.setIsConRefrescarForeignKeys(true);

			historialpagomesnomiLogic.setConnexion(this.getConnexion());
			historialpagomesnomiLogic.setDatosCliente(this.datosCliente);
			historialpagomesnomiLogic.setIsConRefrescarForeignKeys(true);

			rubroempleadoLogic.setConnexion(this.getConnexion());
			rubroempleadoLogic.setDatosCliente(this.datosCliente);
			rubroempleadoLogic.setIsConRefrescarForeignKeys(true);

			valorrubrovariableLogic.setConnexion(this.getConnexion());
			valorrubrovariableLogic.setDatosCliente(this.datosCliente);
			valorrubrovariableLogic.setIsConRefrescarForeignKeys(true);

			tipoprestamoLogic.setConnexion(this.getConnexion());
			tipoprestamoLogic.setDatosCliente(this.datosCliente);
			tipoprestamoLogic.setIsConRefrescarForeignKeys(true);

			rubroempleacuentacontableLogic.setConnexion(this.getConnexion());
			rubroempleacuentacontableLogic.setDatosCliente(this.datosCliente);
			rubroempleacuentacontableLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(RubroEmplea rubroemplea:this.rubroempleas) {
				

				classes=new ArrayList<Classe>();
				classes=HistorialPagoNomiConstantesFunciones.getClassesForeignKeysOfHistorialPagoNomi(new ArrayList<Classe>(),DeepLoadType.NONE);

				historialpagonomiLogic.setHistorialPagoNomis(rubroemplea.historialpagonomis);
				historialpagonomiLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=RubroEstructuraConstantesFunciones.getClassesForeignKeysOfRubroEstructura(new ArrayList<Classe>(),DeepLoadType.NONE);

				rubroestructuraLogic.setRubroEstructuras(rubroemplea.rubroestructuras);
				rubroestructuraLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=DefiProvisionEmpleadoConstantesFunciones.getClassesForeignKeysOfDefiProvisionEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);

				defiprovisionempleadoLogic.setDefiProvisionEmpleados(rubroemplea.defiprovisionempleados);
				defiprovisionempleadoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=EmpleadoPagoRubroConstantesFunciones.getClassesForeignKeysOfEmpleadoPagoRubro(new ArrayList<Classe>(),DeepLoadType.NONE);

				empleadopagorubroLogic.setEmpleadoPagoRubros(rubroemplea.empleadopagorubros);
				empleadopagorubroLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=HistorialPagoMesNomiConstantesFunciones.getClassesForeignKeysOfHistorialPagoMesNomi(new ArrayList<Classe>(),DeepLoadType.NONE);

				historialpagomesnomiLogic.setHistorialPagoMesNomis(rubroemplea.historialpagomesnomis);
				historialpagomesnomiLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=RubroEmpleadoConstantesFunciones.getClassesForeignKeysOfRubroEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);

				rubroempleadoLogic.setRubroEmpleados(rubroemplea.rubroempleados);
				rubroempleadoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=ValorRubroVariableConstantesFunciones.getClassesForeignKeysOfValorRubroVariable(new ArrayList<Classe>(),DeepLoadType.NONE);

				valorrubrovariableLogic.setValorRubroVariables(rubroemplea.valorrubrovariables);
				valorrubrovariableLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=TipoPrestamoConstantesFunciones.getClassesForeignKeysOfTipoPrestamo(new ArrayList<Classe>(),DeepLoadType.NONE);

				tipoprestamoLogic.setTipoPrestamos(rubroemplea.tipoprestamos);
				tipoprestamoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");

				classes=new ArrayList<Classe>();
				classes=RubroEmpleaCuentaContableConstantesFunciones.getClassesForeignKeysOfRubroEmpleaCuentaContable(new ArrayList<Classe>(),DeepLoadType.NONE);

				rubroempleacuentacontableLogic.setRubroEmpleaCuentaContables(rubroemplea.rubroempleacuentacontables);
				rubroempleacuentacontableLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(RubroEmplea rubroemplea,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			RubroEmpleaLogicAdditional.updateRubroEmpleaToGet(rubroemplea,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		rubroemplea.setEmpresa(rubroempleaDataAccess.getEmpresa(connexion,rubroemplea));
		rubroemplea.setTipoCalculo(rubroempleaDataAccess.getTipoCalculo(connexion,rubroemplea));
		rubroemplea.setTipoRubroEmplea(rubroempleaDataAccess.getTipoRubroEmplea(connexion,rubroemplea));
		rubroemplea.setTipoGrupoRubroEmplea(rubroempleaDataAccess.getTipoGrupoRubroEmplea(connexion,rubroemplea));
		rubroemplea.setHistorialPagoNomis(rubroempleaDataAccess.getHistorialPagoNomis(connexion,rubroemplea));
		rubroemplea.setRubroEstructuras(rubroempleaDataAccess.getRubroEstructuras(connexion,rubroemplea));
		rubroemplea.setDefiProvisionEmpleados(rubroempleaDataAccess.getDefiProvisionEmpleados(connexion,rubroemplea));
		rubroemplea.setEmpleadoPagoRubros(rubroempleaDataAccess.getEmpleadoPagoRubros(connexion,rubroemplea));
		rubroemplea.setHistorialPagoMesNomis(rubroempleaDataAccess.getHistorialPagoMesNomis(connexion,rubroemplea));
		rubroemplea.setRubroEmpleados(rubroempleaDataAccess.getRubroEmpleados(connexion,rubroemplea));
		rubroemplea.setValorRubroVariables(rubroempleaDataAccess.getValorRubroVariables(connexion,rubroemplea));
		rubroemplea.setTipoPrestamos(rubroempleaDataAccess.getTipoPrestamos(connexion,rubroemplea));
		rubroemplea.setRubroEmpleaCuentaContables(rubroempleaDataAccess.getRubroEmpleaCuentaContables(connexion,rubroemplea));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				rubroemplea.setEmpresa(rubroempleaDataAccess.getEmpresa(connexion,rubroemplea));
				continue;
			}

			if(clas.clas.equals(TipoCalculo.class)) {
				rubroemplea.setTipoCalculo(rubroempleaDataAccess.getTipoCalculo(connexion,rubroemplea));
				continue;
			}

			if(clas.clas.equals(TipoRubroEmplea.class)) {
				rubroemplea.setTipoRubroEmplea(rubroempleaDataAccess.getTipoRubroEmplea(connexion,rubroemplea));
				continue;
			}

			if(clas.clas.equals(TipoGrupoRubroEmplea.class)) {
				rubroemplea.setTipoGrupoRubroEmplea(rubroempleaDataAccess.getTipoGrupoRubroEmplea(connexion,rubroemplea));
				continue;
			}

			if(clas.clas.equals(HistorialPagoNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				rubroemplea.setHistorialPagoNomis(rubroempleaDataAccess.getHistorialPagoNomis(connexion,rubroemplea));

				if(this.isConDeep) {
					HistorialPagoNomiLogic historialpagonomiLogic= new HistorialPagoNomiLogic(this.connexion);
					historialpagonomiLogic.setHistorialPagoNomis(rubroemplea.getHistorialPagoNomis());
					ArrayList<Classe> classesLocal=HistorialPagoNomiConstantesFunciones.getClassesForeignKeysOfHistorialPagoNomi(new ArrayList<Classe>(),DeepLoadType.NONE);
					historialpagonomiLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					HistorialPagoNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoNomi(historialpagonomiLogic.getHistorialPagoNomis());
					rubroemplea.setHistorialPagoNomis(historialpagonomiLogic.getHistorialPagoNomis());
				}

				continue;
			}

			if(clas.clas.equals(RubroEstructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				rubroemplea.setRubroEstructuras(rubroempleaDataAccess.getRubroEstructuras(connexion,rubroemplea));

				if(this.isConDeep) {
					RubroEstructuraLogic rubroestructuraLogic= new RubroEstructuraLogic(this.connexion);
					rubroestructuraLogic.setRubroEstructuras(rubroemplea.getRubroEstructuras());
					ArrayList<Classe> classesLocal=RubroEstructuraConstantesFunciones.getClassesForeignKeysOfRubroEstructura(new ArrayList<Classe>(),DeepLoadType.NONE);
					rubroestructuraLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					RubroEstructuraConstantesFunciones.refrescarForeignKeysDescripcionesRubroEstructura(rubroestructuraLogic.getRubroEstructuras());
					rubroemplea.setRubroEstructuras(rubroestructuraLogic.getRubroEstructuras());
				}

				continue;
			}

			if(clas.clas.equals(DefiProvisionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				rubroemplea.setDefiProvisionEmpleados(rubroempleaDataAccess.getDefiProvisionEmpleados(connexion,rubroemplea));

				if(this.isConDeep) {
					DefiProvisionEmpleadoLogic defiprovisionempleadoLogic= new DefiProvisionEmpleadoLogic(this.connexion);
					defiprovisionempleadoLogic.setDefiProvisionEmpleados(rubroemplea.getDefiProvisionEmpleados());
					ArrayList<Classe> classesLocal=DefiProvisionEmpleadoConstantesFunciones.getClassesForeignKeysOfDefiProvisionEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);
					defiprovisionempleadoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DefiProvisionEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesDefiProvisionEmpleado(defiprovisionempleadoLogic.getDefiProvisionEmpleados());
					rubroemplea.setDefiProvisionEmpleados(defiprovisionempleadoLogic.getDefiProvisionEmpleados());
				}

				continue;
			}

			if(clas.clas.equals(EmpleadoPagoRubro.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				rubroemplea.setEmpleadoPagoRubros(rubroempleaDataAccess.getEmpleadoPagoRubros(connexion,rubroemplea));

				if(this.isConDeep) {
					EmpleadoPagoRubroLogic empleadopagorubroLogic= new EmpleadoPagoRubroLogic(this.connexion);
					empleadopagorubroLogic.setEmpleadoPagoRubros(rubroemplea.getEmpleadoPagoRubros());
					ArrayList<Classe> classesLocal=EmpleadoPagoRubroConstantesFunciones.getClassesForeignKeysOfEmpleadoPagoRubro(new ArrayList<Classe>(),DeepLoadType.NONE);
					empleadopagorubroLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					EmpleadoPagoRubroConstantesFunciones.refrescarForeignKeysDescripcionesEmpleadoPagoRubro(empleadopagorubroLogic.getEmpleadoPagoRubros());
					rubroemplea.setEmpleadoPagoRubros(empleadopagorubroLogic.getEmpleadoPagoRubros());
				}

				continue;
			}

			if(clas.clas.equals(HistorialPagoMesNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				rubroemplea.setHistorialPagoMesNomis(rubroempleaDataAccess.getHistorialPagoMesNomis(connexion,rubroemplea));

				if(this.isConDeep) {
					HistorialPagoMesNomiLogic historialpagomesnomiLogic= new HistorialPagoMesNomiLogic(this.connexion);
					historialpagomesnomiLogic.setHistorialPagoMesNomis(rubroemplea.getHistorialPagoMesNomis());
					ArrayList<Classe> classesLocal=HistorialPagoMesNomiConstantesFunciones.getClassesForeignKeysOfHistorialPagoMesNomi(new ArrayList<Classe>(),DeepLoadType.NONE);
					historialpagomesnomiLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					HistorialPagoMesNomiConstantesFunciones.refrescarForeignKeysDescripcionesHistorialPagoMesNomi(historialpagomesnomiLogic.getHistorialPagoMesNomis());
					rubroemplea.setHistorialPagoMesNomis(historialpagomesnomiLogic.getHistorialPagoMesNomis());
				}

				continue;
			}

			if(clas.clas.equals(RubroEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				rubroemplea.setRubroEmpleados(rubroempleaDataAccess.getRubroEmpleados(connexion,rubroemplea));

				if(this.isConDeep) {
					RubroEmpleadoLogic rubroempleadoLogic= new RubroEmpleadoLogic(this.connexion);
					rubroempleadoLogic.setRubroEmpleados(rubroemplea.getRubroEmpleados());
					ArrayList<Classe> classesLocal=RubroEmpleadoConstantesFunciones.getClassesForeignKeysOfRubroEmpleado(new ArrayList<Classe>(),DeepLoadType.NONE);
					rubroempleadoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					RubroEmpleadoConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleado(rubroempleadoLogic.getRubroEmpleados());
					rubroemplea.setRubroEmpleados(rubroempleadoLogic.getRubroEmpleados());
				}

				continue;
			}

			if(clas.clas.equals(ValorRubroVariable.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				rubroemplea.setValorRubroVariables(rubroempleaDataAccess.getValorRubroVariables(connexion,rubroemplea));

				if(this.isConDeep) {
					ValorRubroVariableLogic valorrubrovariableLogic= new ValorRubroVariableLogic(this.connexion);
					valorrubrovariableLogic.setValorRubroVariables(rubroemplea.getValorRubroVariables());
					ArrayList<Classe> classesLocal=ValorRubroVariableConstantesFunciones.getClassesForeignKeysOfValorRubroVariable(new ArrayList<Classe>(),DeepLoadType.NONE);
					valorrubrovariableLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					ValorRubroVariableConstantesFunciones.refrescarForeignKeysDescripcionesValorRubroVariable(valorrubrovariableLogic.getValorRubroVariables());
					rubroemplea.setValorRubroVariables(valorrubrovariableLogic.getValorRubroVariables());
				}

				continue;
			}

			if(clas.clas.equals(TipoPrestamo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				rubroemplea.setTipoPrestamos(rubroempleaDataAccess.getTipoPrestamos(connexion,rubroemplea));

				if(this.isConDeep) {
					TipoPrestamoLogic tipoprestamoLogic= new TipoPrestamoLogic(this.connexion);
					tipoprestamoLogic.setTipoPrestamos(rubroemplea.getTipoPrestamos());
					ArrayList<Classe> classesLocal=TipoPrestamoConstantesFunciones.getClassesForeignKeysOfTipoPrestamo(new ArrayList<Classe>(),DeepLoadType.NONE);
					tipoprestamoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					TipoPrestamoConstantesFunciones.refrescarForeignKeysDescripcionesTipoPrestamo(tipoprestamoLogic.getTipoPrestamos());
					rubroemplea.setTipoPrestamos(tipoprestamoLogic.getTipoPrestamos());
				}

				continue;
			}

			if(clas.clas.equals(RubroEmpleaCuentaContable.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				rubroemplea.setRubroEmpleaCuentaContables(rubroempleaDataAccess.getRubroEmpleaCuentaContables(connexion,rubroemplea));

				if(this.isConDeep) {
					RubroEmpleaCuentaContableLogic rubroempleacuentacontableLogic= new RubroEmpleaCuentaContableLogic(this.connexion);
					rubroempleacuentacontableLogic.setRubroEmpleaCuentaContables(rubroemplea.getRubroEmpleaCuentaContables());
					ArrayList<Classe> classesLocal=RubroEmpleaCuentaContableConstantesFunciones.getClassesForeignKeysOfRubroEmpleaCuentaContable(new ArrayList<Classe>(),DeepLoadType.NONE);
					rubroempleacuentacontableLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					RubroEmpleaCuentaContableConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmpleaCuentaContable(rubroempleacuentacontableLogic.getRubroEmpleaCuentaContables());
					rubroemplea.setRubroEmpleaCuentaContables(rubroempleacuentacontableLogic.getRubroEmpleaCuentaContables());
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
			rubroemplea.setEmpresa(rubroempleaDataAccess.getEmpresa(connexion,rubroemplea));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCalculo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			rubroemplea.setTipoCalculo(rubroempleaDataAccess.getTipoCalculo(connexion,rubroemplea));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRubroEmplea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			rubroemplea.setTipoRubroEmplea(rubroempleaDataAccess.getTipoRubroEmplea(connexion,rubroemplea));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoGrupoRubroEmplea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			rubroemplea.setTipoGrupoRubroEmplea(rubroempleaDataAccess.getTipoGrupoRubroEmplea(connexion,rubroemplea));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(HistorialPagoNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(HistorialPagoNomi.class));
			rubroemplea.setHistorialPagoNomis(rubroempleaDataAccess.getHistorialPagoNomis(connexion,rubroemplea));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RubroEstructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(RubroEstructura.class));
			rubroemplea.setRubroEstructuras(rubroempleaDataAccess.getRubroEstructuras(connexion,rubroemplea));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DefiProvisionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DefiProvisionEmpleado.class));
			rubroemplea.setDefiProvisionEmpleados(rubroempleaDataAccess.getDefiProvisionEmpleados(connexion,rubroemplea));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoPagoRubro.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EmpleadoPagoRubro.class));
			rubroemplea.setEmpleadoPagoRubros(rubroempleaDataAccess.getEmpleadoPagoRubros(connexion,rubroemplea));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(HistorialPagoMesNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(HistorialPagoMesNomi.class));
			rubroemplea.setHistorialPagoMesNomis(rubroempleaDataAccess.getHistorialPagoMesNomis(connexion,rubroemplea));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RubroEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(RubroEmpleado.class));
			rubroemplea.setRubroEmpleados(rubroempleaDataAccess.getRubroEmpleados(connexion,rubroemplea));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ValorRubroVariable.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ValorRubroVariable.class));
			rubroemplea.setValorRubroVariables(rubroempleaDataAccess.getValorRubroVariables(connexion,rubroemplea));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrestamo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TipoPrestamo.class));
			rubroemplea.setTipoPrestamos(rubroempleaDataAccess.getTipoPrestamos(connexion,rubroemplea));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RubroEmpleaCuentaContable.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(RubroEmpleaCuentaContable.class));
			rubroemplea.setRubroEmpleaCuentaContables(rubroempleaDataAccess.getRubroEmpleaCuentaContables(connexion,rubroemplea));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		rubroemplea.setEmpresa(rubroempleaDataAccess.getEmpresa(connexion,rubroemplea));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(rubroemplea.getEmpresa(),isDeep,deepLoadType,clases);
				
		rubroemplea.setTipoCalculo(rubroempleaDataAccess.getTipoCalculo(connexion,rubroemplea));
		TipoCalculoLogic tipocalculoLogic= new TipoCalculoLogic(connexion);
		tipocalculoLogic.deepLoad(rubroemplea.getTipoCalculo(),isDeep,deepLoadType,clases);
				
		rubroemplea.setTipoRubroEmplea(rubroempleaDataAccess.getTipoRubroEmplea(connexion,rubroemplea));
		TipoRubroEmpleaLogic tiporubroempleaLogic= new TipoRubroEmpleaLogic(connexion);
		tiporubroempleaLogic.deepLoad(rubroemplea.getTipoRubroEmplea(),isDeep,deepLoadType,clases);
				
		rubroemplea.setTipoGrupoRubroEmplea(rubroempleaDataAccess.getTipoGrupoRubroEmplea(connexion,rubroemplea));
		TipoGrupoRubroEmpleaLogic tipogruporubroempleaLogic= new TipoGrupoRubroEmpleaLogic(connexion);
		tipogruporubroempleaLogic.deepLoad(rubroemplea.getTipoGrupoRubroEmplea(),isDeep,deepLoadType,clases);
				

		rubroemplea.setHistorialPagoNomis(rubroempleaDataAccess.getHistorialPagoNomis(connexion,rubroemplea));

		for(HistorialPagoNomi historialpagonomi:rubroemplea.getHistorialPagoNomis()) {
			HistorialPagoNomiLogic historialpagonomiLogic= new HistorialPagoNomiLogic(connexion);
			historialpagonomiLogic.deepLoad(historialpagonomi,isDeep,deepLoadType,clases);
		}

		rubroemplea.setRubroEstructuras(rubroempleaDataAccess.getRubroEstructuras(connexion,rubroemplea));

		for(RubroEstructura rubroestructura:rubroemplea.getRubroEstructuras()) {
			RubroEstructuraLogic rubroestructuraLogic= new RubroEstructuraLogic(connexion);
			rubroestructuraLogic.deepLoad(rubroestructura,isDeep,deepLoadType,clases);
		}

		rubroemplea.setDefiProvisionEmpleados(rubroempleaDataAccess.getDefiProvisionEmpleados(connexion,rubroemplea));

		for(DefiProvisionEmpleado defiprovisionempleado:rubroemplea.getDefiProvisionEmpleados()) {
			DefiProvisionEmpleadoLogic defiprovisionempleadoLogic= new DefiProvisionEmpleadoLogic(connexion);
			defiprovisionempleadoLogic.deepLoad(defiprovisionempleado,isDeep,deepLoadType,clases);
		}

		rubroemplea.setEmpleadoPagoRubros(rubroempleaDataAccess.getEmpleadoPagoRubros(connexion,rubroemplea));

		for(EmpleadoPagoRubro empleadopagorubro:rubroemplea.getEmpleadoPagoRubros()) {
			EmpleadoPagoRubroLogic empleadopagorubroLogic= new EmpleadoPagoRubroLogic(connexion);
			empleadopagorubroLogic.deepLoad(empleadopagorubro,isDeep,deepLoadType,clases);
		}

		rubroemplea.setHistorialPagoMesNomis(rubroempleaDataAccess.getHistorialPagoMesNomis(connexion,rubroemplea));

		for(HistorialPagoMesNomi historialpagomesnomi:rubroemplea.getHistorialPagoMesNomis()) {
			HistorialPagoMesNomiLogic historialpagomesnomiLogic= new HistorialPagoMesNomiLogic(connexion);
			historialpagomesnomiLogic.deepLoad(historialpagomesnomi,isDeep,deepLoadType,clases);
		}

		rubroemplea.setRubroEmpleados(rubroempleaDataAccess.getRubroEmpleados(connexion,rubroemplea));

		for(RubroEmpleado rubroempleado:rubroemplea.getRubroEmpleados()) {
			RubroEmpleadoLogic rubroempleadoLogic= new RubroEmpleadoLogic(connexion);
			rubroempleadoLogic.deepLoad(rubroempleado,isDeep,deepLoadType,clases);
		}

		rubroemplea.setValorRubroVariables(rubroempleaDataAccess.getValorRubroVariables(connexion,rubroemplea));

		for(ValorRubroVariable valorrubrovariable:rubroemplea.getValorRubroVariables()) {
			ValorRubroVariableLogic valorrubrovariableLogic= new ValorRubroVariableLogic(connexion);
			valorrubrovariableLogic.deepLoad(valorrubrovariable,isDeep,deepLoadType,clases);
		}

		rubroemplea.setTipoPrestamos(rubroempleaDataAccess.getTipoPrestamos(connexion,rubroemplea));

		for(TipoPrestamo tipoprestamo:rubroemplea.getTipoPrestamos()) {
			TipoPrestamoLogic tipoprestamoLogic= new TipoPrestamoLogic(connexion);
			tipoprestamoLogic.deepLoad(tipoprestamo,isDeep,deepLoadType,clases);
		}

		rubroemplea.setRubroEmpleaCuentaContables(rubroempleaDataAccess.getRubroEmpleaCuentaContables(connexion,rubroemplea));

		for(RubroEmpleaCuentaContable rubroempleacuentacontable:rubroemplea.getRubroEmpleaCuentaContables()) {
			RubroEmpleaCuentaContableLogic rubroempleacuentacontableLogic= new RubroEmpleaCuentaContableLogic(connexion);
			rubroempleacuentacontableLogic.deepLoad(rubroempleacuentacontable,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				rubroemplea.setEmpresa(rubroempleaDataAccess.getEmpresa(connexion,rubroemplea));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(rubroemplea.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCalculo.class)) {
				rubroemplea.setTipoCalculo(rubroempleaDataAccess.getTipoCalculo(connexion,rubroemplea));
				TipoCalculoLogic tipocalculoLogic= new TipoCalculoLogic(connexion);
				tipocalculoLogic.deepLoad(rubroemplea.getTipoCalculo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRubroEmplea.class)) {
				rubroemplea.setTipoRubroEmplea(rubroempleaDataAccess.getTipoRubroEmplea(connexion,rubroemplea));
				TipoRubroEmpleaLogic tiporubroempleaLogic= new TipoRubroEmpleaLogic(connexion);
				tiporubroempleaLogic.deepLoad(rubroemplea.getTipoRubroEmplea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoGrupoRubroEmplea.class)) {
				rubroemplea.setTipoGrupoRubroEmplea(rubroempleaDataAccess.getTipoGrupoRubroEmplea(connexion,rubroemplea));
				TipoGrupoRubroEmpleaLogic tipogruporubroempleaLogic= new TipoGrupoRubroEmpleaLogic(connexion);
				tipogruporubroempleaLogic.deepLoad(rubroemplea.getTipoGrupoRubroEmplea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(HistorialPagoNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				rubroemplea.setHistorialPagoNomis(rubroempleaDataAccess.getHistorialPagoNomis(connexion,rubroemplea));

				for(HistorialPagoNomi historialpagonomi:rubroemplea.getHistorialPagoNomis()) {
					HistorialPagoNomiLogic historialpagonomiLogic= new HistorialPagoNomiLogic(connexion);
					historialpagonomiLogic.deepLoad(historialpagonomi,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(RubroEstructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				rubroemplea.setRubroEstructuras(rubroempleaDataAccess.getRubroEstructuras(connexion,rubroemplea));

				for(RubroEstructura rubroestructura:rubroemplea.getRubroEstructuras()) {
					RubroEstructuraLogic rubroestructuraLogic= new RubroEstructuraLogic(connexion);
					rubroestructuraLogic.deepLoad(rubroestructura,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DefiProvisionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				rubroemplea.setDefiProvisionEmpleados(rubroempleaDataAccess.getDefiProvisionEmpleados(connexion,rubroemplea));

				for(DefiProvisionEmpleado defiprovisionempleado:rubroemplea.getDefiProvisionEmpleados()) {
					DefiProvisionEmpleadoLogic defiprovisionempleadoLogic= new DefiProvisionEmpleadoLogic(connexion);
					defiprovisionempleadoLogic.deepLoad(defiprovisionempleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoPagoRubro.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				rubroemplea.setEmpleadoPagoRubros(rubroempleaDataAccess.getEmpleadoPagoRubros(connexion,rubroemplea));

				for(EmpleadoPagoRubro empleadopagorubro:rubroemplea.getEmpleadoPagoRubros()) {
					EmpleadoPagoRubroLogic empleadopagorubroLogic= new EmpleadoPagoRubroLogic(connexion);
					empleadopagorubroLogic.deepLoad(empleadopagorubro,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(HistorialPagoMesNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				rubroemplea.setHistorialPagoMesNomis(rubroempleaDataAccess.getHistorialPagoMesNomis(connexion,rubroemplea));

				for(HistorialPagoMesNomi historialpagomesnomi:rubroemplea.getHistorialPagoMesNomis()) {
					HistorialPagoMesNomiLogic historialpagomesnomiLogic= new HistorialPagoMesNomiLogic(connexion);
					historialpagomesnomiLogic.deepLoad(historialpagomesnomi,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(RubroEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				rubroemplea.setRubroEmpleados(rubroempleaDataAccess.getRubroEmpleados(connexion,rubroemplea));

				for(RubroEmpleado rubroempleado:rubroemplea.getRubroEmpleados()) {
					RubroEmpleadoLogic rubroempleadoLogic= new RubroEmpleadoLogic(connexion);
					rubroempleadoLogic.deepLoad(rubroempleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ValorRubroVariable.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				rubroemplea.setValorRubroVariables(rubroempleaDataAccess.getValorRubroVariables(connexion,rubroemplea));

				for(ValorRubroVariable valorrubrovariable:rubroemplea.getValorRubroVariables()) {
					ValorRubroVariableLogic valorrubrovariableLogic= new ValorRubroVariableLogic(connexion);
					valorrubrovariableLogic.deepLoad(valorrubrovariable,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(TipoPrestamo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				rubroemplea.setTipoPrestamos(rubroempleaDataAccess.getTipoPrestamos(connexion,rubroemplea));

				for(TipoPrestamo tipoprestamo:rubroemplea.getTipoPrestamos()) {
					TipoPrestamoLogic tipoprestamoLogic= new TipoPrestamoLogic(connexion);
					tipoprestamoLogic.deepLoad(tipoprestamo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(RubroEmpleaCuentaContable.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				rubroemplea.setRubroEmpleaCuentaContables(rubroempleaDataAccess.getRubroEmpleaCuentaContables(connexion,rubroemplea));

				for(RubroEmpleaCuentaContable rubroempleacuentacontable:rubroemplea.getRubroEmpleaCuentaContables()) {
					RubroEmpleaCuentaContableLogic rubroempleacuentacontableLogic= new RubroEmpleaCuentaContableLogic(connexion);
					rubroempleacuentacontableLogic.deepLoad(rubroempleacuentacontable,isDeep,deepLoadType,clases);
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
			rubroemplea.setEmpresa(rubroempleaDataAccess.getEmpresa(connexion,rubroemplea));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(rubroemplea.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoCalculo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			rubroemplea.setTipoCalculo(rubroempleaDataAccess.getTipoCalculo(connexion,rubroemplea));
			TipoCalculoLogic tipocalculoLogic= new TipoCalculoLogic(connexion);
			tipocalculoLogic.deepLoad(rubroemplea.getTipoCalculo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRubroEmplea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			rubroemplea.setTipoRubroEmplea(rubroempleaDataAccess.getTipoRubroEmplea(connexion,rubroemplea));
			TipoRubroEmpleaLogic tiporubroempleaLogic= new TipoRubroEmpleaLogic(connexion);
			tiporubroempleaLogic.deepLoad(rubroemplea.getTipoRubroEmplea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoGrupoRubroEmplea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			rubroemplea.setTipoGrupoRubroEmplea(rubroempleaDataAccess.getTipoGrupoRubroEmplea(connexion,rubroemplea));
			TipoGrupoRubroEmpleaLogic tipogruporubroempleaLogic= new TipoGrupoRubroEmpleaLogic(connexion);
			tipogruporubroempleaLogic.deepLoad(rubroemplea.getTipoGrupoRubroEmplea(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(HistorialPagoNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(HistorialPagoNomi.class));
			rubroemplea.setHistorialPagoNomis(rubroempleaDataAccess.getHistorialPagoNomis(connexion,rubroemplea));

			for(HistorialPagoNomi historialpagonomi:rubroemplea.getHistorialPagoNomis()) {
				HistorialPagoNomiLogic historialpagonomiLogic= new HistorialPagoNomiLogic(connexion);
				historialpagonomiLogic.deepLoad(historialpagonomi,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RubroEstructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(RubroEstructura.class));
			rubroemplea.setRubroEstructuras(rubroempleaDataAccess.getRubroEstructuras(connexion,rubroemplea));

			for(RubroEstructura rubroestructura:rubroemplea.getRubroEstructuras()) {
				RubroEstructuraLogic rubroestructuraLogic= new RubroEstructuraLogic(connexion);
				rubroestructuraLogic.deepLoad(rubroestructura,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DefiProvisionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DefiProvisionEmpleado.class));
			rubroemplea.setDefiProvisionEmpleados(rubroempleaDataAccess.getDefiProvisionEmpleados(connexion,rubroemplea));

			for(DefiProvisionEmpleado defiprovisionempleado:rubroemplea.getDefiProvisionEmpleados()) {
				DefiProvisionEmpleadoLogic defiprovisionempleadoLogic= new DefiProvisionEmpleadoLogic(connexion);
				defiprovisionempleadoLogic.deepLoad(defiprovisionempleado,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(EmpleadoPagoRubro.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(EmpleadoPagoRubro.class));
			rubroemplea.setEmpleadoPagoRubros(rubroempleaDataAccess.getEmpleadoPagoRubros(connexion,rubroemplea));

			for(EmpleadoPagoRubro empleadopagorubro:rubroemplea.getEmpleadoPagoRubros()) {
				EmpleadoPagoRubroLogic empleadopagorubroLogic= new EmpleadoPagoRubroLogic(connexion);
				empleadopagorubroLogic.deepLoad(empleadopagorubro,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(HistorialPagoMesNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(HistorialPagoMesNomi.class));
			rubroemplea.setHistorialPagoMesNomis(rubroempleaDataAccess.getHistorialPagoMesNomis(connexion,rubroemplea));

			for(HistorialPagoMesNomi historialpagomesnomi:rubroemplea.getHistorialPagoMesNomis()) {
				HistorialPagoMesNomiLogic historialpagomesnomiLogic= new HistorialPagoMesNomiLogic(connexion);
				historialpagomesnomiLogic.deepLoad(historialpagomesnomi,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RubroEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(RubroEmpleado.class));
			rubroemplea.setRubroEmpleados(rubroempleaDataAccess.getRubroEmpleados(connexion,rubroemplea));

			for(RubroEmpleado rubroempleado:rubroemplea.getRubroEmpleados()) {
				RubroEmpleadoLogic rubroempleadoLogic= new RubroEmpleadoLogic(connexion);
				rubroempleadoLogic.deepLoad(rubroempleado,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ValorRubroVariable.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(ValorRubroVariable.class));
			rubroemplea.setValorRubroVariables(rubroempleaDataAccess.getValorRubroVariables(connexion,rubroemplea));

			for(ValorRubroVariable valorrubrovariable:rubroemplea.getValorRubroVariables()) {
				ValorRubroVariableLogic valorrubrovariableLogic= new ValorRubroVariableLogic(connexion);
				valorrubrovariableLogic.deepLoad(valorrubrovariable,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPrestamo.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TipoPrestamo.class));
			rubroemplea.setTipoPrestamos(rubroempleaDataAccess.getTipoPrestamos(connexion,rubroemplea));

			for(TipoPrestamo tipoprestamo:rubroemplea.getTipoPrestamos()) {
				TipoPrestamoLogic tipoprestamoLogic= new TipoPrestamoLogic(connexion);
				tipoprestamoLogic.deepLoad(tipoprestamo,isDeep,deepLoadType,clases);
			}
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RubroEmpleaCuentaContable.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(RubroEmpleaCuentaContable.class));
			rubroemplea.setRubroEmpleaCuentaContables(rubroempleaDataAccess.getRubroEmpleaCuentaContables(connexion,rubroemplea));

			for(RubroEmpleaCuentaContable rubroempleacuentacontable:rubroemplea.getRubroEmpleaCuentaContables()) {
				RubroEmpleaCuentaContableLogic rubroempleacuentacontableLogic= new RubroEmpleaCuentaContableLogic(connexion);
				rubroempleacuentacontableLogic.deepLoad(rubroempleacuentacontable,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(RubroEmplea rubroemplea,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			RubroEmpleaLogicAdditional.updateRubroEmpleaToSave(rubroemplea,this.arrDatoGeneral);
			
RubroEmpleaDataAccess.save(rubroemplea, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(rubroemplea.getEmpresa(),connexion);

		TipoCalculoDataAccess.save(rubroemplea.getTipoCalculo(),connexion);

		TipoRubroEmpleaDataAccess.save(rubroemplea.getTipoRubroEmplea(),connexion);

		TipoGrupoRubroEmpleaDataAccess.save(rubroemplea.getTipoGrupoRubroEmplea(),connexion);

		for(HistorialPagoNomi historialpagonomi:rubroemplea.getHistorialPagoNomis()) {
			historialpagonomi.setid_rubro_emplea(rubroemplea.getId());
			HistorialPagoNomiDataAccess.save(historialpagonomi,connexion);
		}

		for(RubroEstructura rubroestructura:rubroemplea.getRubroEstructuras()) {
			rubroestructura.setid_rubro_emplea(rubroemplea.getId());
			RubroEstructuraDataAccess.save(rubroestructura,connexion);
		}

		for(DefiProvisionEmpleado defiprovisionempleado:rubroemplea.getDefiProvisionEmpleados()) {
			defiprovisionempleado.setid_rubro_emplea(rubroemplea.getId());
			DefiProvisionEmpleadoDataAccess.save(defiprovisionempleado,connexion);
		}

		for(EmpleadoPagoRubro empleadopagorubro:rubroemplea.getEmpleadoPagoRubros()) {
			empleadopagorubro.setid_rubro_emplea(rubroemplea.getId());
			EmpleadoPagoRubroDataAccess.save(empleadopagorubro,connexion);
		}

		for(HistorialPagoMesNomi historialpagomesnomi:rubroemplea.getHistorialPagoMesNomis()) {
			historialpagomesnomi.setid_rubro_emplea(rubroemplea.getId());
			HistorialPagoMesNomiDataAccess.save(historialpagomesnomi,connexion);
		}

		for(RubroEmpleado rubroempleado:rubroemplea.getRubroEmpleados()) {
			rubroempleado.setid_rubro_emplea(rubroemplea.getId());
			RubroEmpleadoDataAccess.save(rubroempleado,connexion);
		}

		for(ValorRubroVariable valorrubrovariable:rubroemplea.getValorRubroVariables()) {
			valorrubrovariable.setid_rubro_emplea(rubroemplea.getId());
			ValorRubroVariableDataAccess.save(valorrubrovariable,connexion);
		}

		for(TipoPrestamo tipoprestamo:rubroemplea.getTipoPrestamos()) {
			tipoprestamo.setid_rubro_emplea(rubroemplea.getId());
			TipoPrestamoDataAccess.save(tipoprestamo,connexion);
		}

		for(RubroEmpleaCuentaContable rubroempleacuentacontable:rubroemplea.getRubroEmpleaCuentaContables()) {
			rubroempleacuentacontable.setid_rubro_emplea(rubroemplea.getId());
			RubroEmpleaCuentaContableDataAccess.save(rubroempleacuentacontable,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(rubroemplea.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoCalculo.class)) {
				TipoCalculoDataAccess.save(rubroemplea.getTipoCalculo(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoRubroEmplea.class)) {
				TipoRubroEmpleaDataAccess.save(rubroemplea.getTipoRubroEmplea(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoGrupoRubroEmplea.class)) {
				TipoGrupoRubroEmpleaDataAccess.save(rubroemplea.getTipoGrupoRubroEmplea(),connexion);
				continue;
			}


			if(clas.clas.equals(HistorialPagoNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(HistorialPagoNomi historialpagonomi:rubroemplea.getHistorialPagoNomis()) {
					historialpagonomi.setid_rubro_emplea(rubroemplea.getId());
					HistorialPagoNomiDataAccess.save(historialpagonomi,connexion);
				}
				continue;
			}

			if(clas.clas.equals(RubroEstructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(RubroEstructura rubroestructura:rubroemplea.getRubroEstructuras()) {
					rubroestructura.setid_rubro_emplea(rubroemplea.getId());
					RubroEstructuraDataAccess.save(rubroestructura,connexion);
				}
				continue;
			}

			if(clas.clas.equals(DefiProvisionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DefiProvisionEmpleado defiprovisionempleado:rubroemplea.getDefiProvisionEmpleados()) {
					defiprovisionempleado.setid_rubro_emplea(rubroemplea.getId());
					DefiProvisionEmpleadoDataAccess.save(defiprovisionempleado,connexion);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoPagoRubro.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EmpleadoPagoRubro empleadopagorubro:rubroemplea.getEmpleadoPagoRubros()) {
					empleadopagorubro.setid_rubro_emplea(rubroemplea.getId());
					EmpleadoPagoRubroDataAccess.save(empleadopagorubro,connexion);
				}
				continue;
			}

			if(clas.clas.equals(HistorialPagoMesNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(HistorialPagoMesNomi historialpagomesnomi:rubroemplea.getHistorialPagoMesNomis()) {
					historialpagomesnomi.setid_rubro_emplea(rubroemplea.getId());
					HistorialPagoMesNomiDataAccess.save(historialpagomesnomi,connexion);
				}
				continue;
			}

			if(clas.clas.equals(RubroEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(RubroEmpleado rubroempleado:rubroemplea.getRubroEmpleados()) {
					rubroempleado.setid_rubro_emplea(rubroemplea.getId());
					RubroEmpleadoDataAccess.save(rubroempleado,connexion);
				}
				continue;
			}

			if(clas.clas.equals(ValorRubroVariable.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ValorRubroVariable valorrubrovariable:rubroemplea.getValorRubroVariables()) {
					valorrubrovariable.setid_rubro_emplea(rubroemplea.getId());
					ValorRubroVariableDataAccess.save(valorrubrovariable,connexion);
				}
				continue;
			}

			if(clas.clas.equals(TipoPrestamo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TipoPrestamo tipoprestamo:rubroemplea.getTipoPrestamos()) {
					tipoprestamo.setid_rubro_emplea(rubroemplea.getId());
					TipoPrestamoDataAccess.save(tipoprestamo,connexion);
				}
				continue;
			}

			if(clas.clas.equals(RubroEmpleaCuentaContable.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(RubroEmpleaCuentaContable rubroempleacuentacontable:rubroemplea.getRubroEmpleaCuentaContables()) {
					rubroempleacuentacontable.setid_rubro_emplea(rubroemplea.getId());
					RubroEmpleaCuentaContableDataAccess.save(rubroempleacuentacontable,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(rubroemplea.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(rubroemplea.getEmpresa(),isDeep,deepLoadType,clases);
				

		TipoCalculoDataAccess.save(rubroemplea.getTipoCalculo(),connexion);
		TipoCalculoLogic tipocalculoLogic= new TipoCalculoLogic(connexion);
		tipocalculoLogic.deepLoad(rubroemplea.getTipoCalculo(),isDeep,deepLoadType,clases);
				

		TipoRubroEmpleaDataAccess.save(rubroemplea.getTipoRubroEmplea(),connexion);
		TipoRubroEmpleaLogic tiporubroempleaLogic= new TipoRubroEmpleaLogic(connexion);
		tiporubroempleaLogic.deepLoad(rubroemplea.getTipoRubroEmplea(),isDeep,deepLoadType,clases);
				

		TipoGrupoRubroEmpleaDataAccess.save(rubroemplea.getTipoGrupoRubroEmplea(),connexion);
		TipoGrupoRubroEmpleaLogic tipogruporubroempleaLogic= new TipoGrupoRubroEmpleaLogic(connexion);
		tipogruporubroempleaLogic.deepLoad(rubroemplea.getTipoGrupoRubroEmplea(),isDeep,deepLoadType,clases);
				

		for(HistorialPagoNomi historialpagonomi:rubroemplea.getHistorialPagoNomis()) {
			HistorialPagoNomiLogic historialpagonomiLogic= new HistorialPagoNomiLogic(connexion);
			historialpagonomi.setid_rubro_emplea(rubroemplea.getId());
			HistorialPagoNomiDataAccess.save(historialpagonomi,connexion);
			historialpagonomiLogic.deepSave(historialpagonomi,isDeep,deepLoadType,clases);
		}

		for(RubroEstructura rubroestructura:rubroemplea.getRubroEstructuras()) {
			RubroEstructuraLogic rubroestructuraLogic= new RubroEstructuraLogic(connexion);
			rubroestructura.setid_rubro_emplea(rubroemplea.getId());
			RubroEstructuraDataAccess.save(rubroestructura,connexion);
			rubroestructuraLogic.deepSave(rubroestructura,isDeep,deepLoadType,clases);
		}

		for(DefiProvisionEmpleado defiprovisionempleado:rubroemplea.getDefiProvisionEmpleados()) {
			DefiProvisionEmpleadoLogic defiprovisionempleadoLogic= new DefiProvisionEmpleadoLogic(connexion);
			defiprovisionempleado.setid_rubro_emplea(rubroemplea.getId());
			DefiProvisionEmpleadoDataAccess.save(defiprovisionempleado,connexion);
			defiprovisionempleadoLogic.deepSave(defiprovisionempleado,isDeep,deepLoadType,clases);
		}

		for(EmpleadoPagoRubro empleadopagorubro:rubroemplea.getEmpleadoPagoRubros()) {
			EmpleadoPagoRubroLogic empleadopagorubroLogic= new EmpleadoPagoRubroLogic(connexion);
			empleadopagorubro.setid_rubro_emplea(rubroemplea.getId());
			EmpleadoPagoRubroDataAccess.save(empleadopagorubro,connexion);
			empleadopagorubroLogic.deepSave(empleadopagorubro,isDeep,deepLoadType,clases);
		}

		for(HistorialPagoMesNomi historialpagomesnomi:rubroemplea.getHistorialPagoMesNomis()) {
			HistorialPagoMesNomiLogic historialpagomesnomiLogic= new HistorialPagoMesNomiLogic(connexion);
			historialpagomesnomi.setid_rubro_emplea(rubroemplea.getId());
			HistorialPagoMesNomiDataAccess.save(historialpagomesnomi,connexion);
			historialpagomesnomiLogic.deepSave(historialpagomesnomi,isDeep,deepLoadType,clases);
		}

		for(RubroEmpleado rubroempleado:rubroemplea.getRubroEmpleados()) {
			RubroEmpleadoLogic rubroempleadoLogic= new RubroEmpleadoLogic(connexion);
			rubroempleado.setid_rubro_emplea(rubroemplea.getId());
			RubroEmpleadoDataAccess.save(rubroempleado,connexion);
			rubroempleadoLogic.deepSave(rubroempleado,isDeep,deepLoadType,clases);
		}

		for(ValorRubroVariable valorrubrovariable:rubroemplea.getValorRubroVariables()) {
			ValorRubroVariableLogic valorrubrovariableLogic= new ValorRubroVariableLogic(connexion);
			valorrubrovariable.setid_rubro_emplea(rubroemplea.getId());
			ValorRubroVariableDataAccess.save(valorrubrovariable,connexion);
			valorrubrovariableLogic.deepSave(valorrubrovariable,isDeep,deepLoadType,clases);
		}

		for(TipoPrestamo tipoprestamo:rubroemplea.getTipoPrestamos()) {
			TipoPrestamoLogic tipoprestamoLogic= new TipoPrestamoLogic(connexion);
			tipoprestamo.setid_rubro_emplea(rubroemplea.getId());
			TipoPrestamoDataAccess.save(tipoprestamo,connexion);
			tipoprestamoLogic.deepSave(tipoprestamo,isDeep,deepLoadType,clases);
		}

		for(RubroEmpleaCuentaContable rubroempleacuentacontable:rubroemplea.getRubroEmpleaCuentaContables()) {
			RubroEmpleaCuentaContableLogic rubroempleacuentacontableLogic= new RubroEmpleaCuentaContableLogic(connexion);
			rubroempleacuentacontable.setid_rubro_emplea(rubroemplea.getId());
			RubroEmpleaCuentaContableDataAccess.save(rubroempleacuentacontable,connexion);
			rubroempleacuentacontableLogic.deepSave(rubroempleacuentacontable,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(rubroemplea.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(rubroemplea.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoCalculo.class)) {
				TipoCalculoDataAccess.save(rubroemplea.getTipoCalculo(),connexion);
				TipoCalculoLogic tipocalculoLogic= new TipoCalculoLogic(connexion);
				tipocalculoLogic.deepSave(rubroemplea.getTipoCalculo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRubroEmplea.class)) {
				TipoRubroEmpleaDataAccess.save(rubroemplea.getTipoRubroEmplea(),connexion);
				TipoRubroEmpleaLogic tiporubroempleaLogic= new TipoRubroEmpleaLogic(connexion);
				tiporubroempleaLogic.deepSave(rubroemplea.getTipoRubroEmplea(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoGrupoRubroEmplea.class)) {
				TipoGrupoRubroEmpleaDataAccess.save(rubroemplea.getTipoGrupoRubroEmplea(),connexion);
				TipoGrupoRubroEmpleaLogic tipogruporubroempleaLogic= new TipoGrupoRubroEmpleaLogic(connexion);
				tipogruporubroempleaLogic.deepSave(rubroemplea.getTipoGrupoRubroEmplea(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(HistorialPagoNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(HistorialPagoNomi historialpagonomi:rubroemplea.getHistorialPagoNomis()) {
					HistorialPagoNomiLogic historialpagonomiLogic= new HistorialPagoNomiLogic(connexion);
					historialpagonomi.setid_rubro_emplea(rubroemplea.getId());
					HistorialPagoNomiDataAccess.save(historialpagonomi,connexion);
					historialpagonomiLogic.deepSave(historialpagonomi,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(RubroEstructura.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(RubroEstructura rubroestructura:rubroemplea.getRubroEstructuras()) {
					RubroEstructuraLogic rubroestructuraLogic= new RubroEstructuraLogic(connexion);
					rubroestructura.setid_rubro_emplea(rubroemplea.getId());
					RubroEstructuraDataAccess.save(rubroestructura,connexion);
					rubroestructuraLogic.deepSave(rubroestructura,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(DefiProvisionEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DefiProvisionEmpleado defiprovisionempleado:rubroemplea.getDefiProvisionEmpleados()) {
					DefiProvisionEmpleadoLogic defiprovisionempleadoLogic= new DefiProvisionEmpleadoLogic(connexion);
					defiprovisionempleado.setid_rubro_emplea(rubroemplea.getId());
					DefiProvisionEmpleadoDataAccess.save(defiprovisionempleado,connexion);
					defiprovisionempleadoLogic.deepSave(defiprovisionempleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(EmpleadoPagoRubro.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(EmpleadoPagoRubro empleadopagorubro:rubroemplea.getEmpleadoPagoRubros()) {
					EmpleadoPagoRubroLogic empleadopagorubroLogic= new EmpleadoPagoRubroLogic(connexion);
					empleadopagorubro.setid_rubro_emplea(rubroemplea.getId());
					EmpleadoPagoRubroDataAccess.save(empleadopagorubro,connexion);
					empleadopagorubroLogic.deepSave(empleadopagorubro,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(HistorialPagoMesNomi.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(HistorialPagoMesNomi historialpagomesnomi:rubroemplea.getHistorialPagoMesNomis()) {
					HistorialPagoMesNomiLogic historialpagomesnomiLogic= new HistorialPagoMesNomiLogic(connexion);
					historialpagomesnomi.setid_rubro_emplea(rubroemplea.getId());
					HistorialPagoMesNomiDataAccess.save(historialpagomesnomi,connexion);
					historialpagomesnomiLogic.deepSave(historialpagomesnomi,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(RubroEmpleado.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(RubroEmpleado rubroempleado:rubroemplea.getRubroEmpleados()) {
					RubroEmpleadoLogic rubroempleadoLogic= new RubroEmpleadoLogic(connexion);
					rubroempleado.setid_rubro_emplea(rubroemplea.getId());
					RubroEmpleadoDataAccess.save(rubroempleado,connexion);
					rubroempleadoLogic.deepSave(rubroempleado,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(ValorRubroVariable.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(ValorRubroVariable valorrubrovariable:rubroemplea.getValorRubroVariables()) {
					ValorRubroVariableLogic valorrubrovariableLogic= new ValorRubroVariableLogic(connexion);
					valorrubrovariable.setid_rubro_emplea(rubroemplea.getId());
					ValorRubroVariableDataAccess.save(valorrubrovariable,connexion);
					valorrubrovariableLogic.deepSave(valorrubrovariable,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(TipoPrestamo.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TipoPrestamo tipoprestamo:rubroemplea.getTipoPrestamos()) {
					TipoPrestamoLogic tipoprestamoLogic= new TipoPrestamoLogic(connexion);
					tipoprestamo.setid_rubro_emplea(rubroemplea.getId());
					TipoPrestamoDataAccess.save(tipoprestamo,connexion);
					tipoprestamoLogic.deepSave(tipoprestamo,isDeep,deepLoadType,clases);
				}
				continue;
			}

			if(clas.clas.equals(RubroEmpleaCuentaContable.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(RubroEmpleaCuentaContable rubroempleacuentacontable:rubroemplea.getRubroEmpleaCuentaContables()) {
					RubroEmpleaCuentaContableLogic rubroempleacuentacontableLogic= new RubroEmpleaCuentaContableLogic(connexion);
					rubroempleacuentacontable.setid_rubro_emplea(rubroemplea.getId());
					RubroEmpleaCuentaContableDataAccess.save(rubroempleacuentacontable,connexion);
					rubroempleacuentacontableLogic.deepSave(rubroempleacuentacontable,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(RubroEmplea.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(rubroemplea,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmplea(rubroemplea);
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
			this.deepLoad(this.rubroemplea,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				RubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmplea(this.rubroemplea);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(RubroEmplea.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(rubroempleas!=null) {
				for(RubroEmplea rubroemplea:rubroempleas) {
					this.deepLoad(rubroemplea,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					RubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmplea(rubroempleas);
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
			if(rubroempleas!=null) {
				for(RubroEmplea rubroemplea:rubroempleas) {
					this.deepLoad(rubroemplea,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					RubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmplea(rubroempleas);
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
			this.getNewConnexionToDeep(RubroEmplea.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(rubroemplea,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(RubroEmplea.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(rubroempleas!=null) {
				for(RubroEmplea rubroemplea:rubroempleas) {
					this.deepSave(rubroemplea,isDeep,deepLoadType,clases);
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
			if(rubroempleas!=null) {
				for(RubroEmplea rubroemplea:rubroempleas) {
					this.deepSave(rubroemplea,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getRubroEmpleasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmplea.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,RubroEmpleaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			RubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rubroempleas=rubroempleaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmplea(this.rubroempleas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRubroEmpleasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,RubroEmpleaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			RubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rubroempleas=rubroempleaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmplea(this.rubroempleas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRubroEmpleasFK_IdTipoCalculoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_calculo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmplea.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCalculo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCalculo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_calculo,RubroEmpleaConstantesFunciones.IDTIPOCALCULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCalculo);

			RubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCalculo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rubroempleas=rubroempleaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmplea(this.rubroempleas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRubroEmpleasFK_IdTipoCalculo(String sFinalQuery,Pagination pagination,Long id_tipo_calculo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoCalculo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoCalculo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_calculo,RubroEmpleaConstantesFunciones.IDTIPOCALCULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoCalculo);

			RubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoCalculo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rubroempleas=rubroempleaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmplea(this.rubroempleas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRubroEmpleasFK_IdTipoGrupoRubroEmpleaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_grupo_rubro_emplea)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmplea.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoGrupoRubroEmplea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoGrupoRubroEmplea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_grupo_rubro_emplea,RubroEmpleaConstantesFunciones.IDTIPOGRUPORUBROEMPLEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoGrupoRubroEmplea);

			RubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoGrupoRubroEmplea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rubroempleas=rubroempleaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmplea(this.rubroempleas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRubroEmpleasFK_IdTipoGrupoRubroEmplea(String sFinalQuery,Pagination pagination,Long id_tipo_grupo_rubro_emplea)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoGrupoRubroEmplea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoGrupoRubroEmplea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_grupo_rubro_emplea,RubroEmpleaConstantesFunciones.IDTIPOGRUPORUBROEMPLEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoGrupoRubroEmplea);

			RubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoGrupoRubroEmplea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rubroempleas=rubroempleaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmplea(this.rubroempleas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getRubroEmpleasFK_IdTipoRubroEmpleaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_rubro_emplea)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,RubroEmplea.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRubroEmplea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRubroEmplea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_rubro_emplea,RubroEmpleaConstantesFunciones.IDTIPORUBROEMPLEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRubroEmplea);

			RubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRubroEmplea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rubroempleas=rubroempleaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmplea(this.rubroempleas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getRubroEmpleasFK_IdTipoRubroEmplea(String sFinalQuery,Pagination pagination,Long id_tipo_rubro_emplea)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRubroEmplea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRubroEmplea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_rubro_emplea,RubroEmpleaConstantesFunciones.IDTIPORUBROEMPLEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRubroEmplea);

			RubroEmpleaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRubroEmplea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			rubroempleas=rubroempleaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				RubroEmpleaConstantesFunciones.refrescarForeignKeysDescripcionesRubroEmplea(this.rubroempleas);
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
			if(RubroEmpleaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,RubroEmpleaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,RubroEmplea rubroemplea,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(RubroEmpleaConstantesFunciones.ISCONAUDITORIA) {
				if(rubroemplea.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RubroEmpleaDataAccess.TABLENAME, rubroemplea.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(RubroEmpleaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////RubroEmpleaLogic.registrarAuditoriaDetallesRubroEmplea(connexion,rubroemplea,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(rubroemplea.getIsDeleted()) {
					/*if(!rubroemplea.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,RubroEmpleaDataAccess.TABLENAME, rubroemplea.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////RubroEmpleaLogic.registrarAuditoriaDetallesRubroEmplea(connexion,rubroemplea,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RubroEmpleaDataAccess.TABLENAME, rubroemplea.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(rubroemplea.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,RubroEmpleaDataAccess.TABLENAME, rubroemplea.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(RubroEmpleaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////RubroEmpleaLogic.registrarAuditoriaDetallesRubroEmplea(connexion,rubroemplea,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesRubroEmplea(Connexion connexion,RubroEmplea rubroemplea)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(rubroemplea.getIsNew()||!rubroemplea.getid_empresa().equals(rubroemplea.getRubroEmpleaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rubroemplea.getRubroEmpleaOriginal().getid_empresa()!=null)
				{
					strValorActual=rubroemplea.getRubroEmpleaOriginal().getid_empresa().toString();
				}
				if(rubroemplea.getid_empresa()!=null)
				{
					strValorNuevo=rubroemplea.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RubroEmpleaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(rubroemplea.getIsNew()||!rubroemplea.getid_tipo_calculo().equals(rubroemplea.getRubroEmpleaOriginal().getid_tipo_calculo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rubroemplea.getRubroEmpleaOriginal().getid_tipo_calculo()!=null)
				{
					strValorActual=rubroemplea.getRubroEmpleaOriginal().getid_tipo_calculo().toString();
				}
				if(rubroemplea.getid_tipo_calculo()!=null)
				{
					strValorNuevo=rubroemplea.getid_tipo_calculo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RubroEmpleaConstantesFunciones.IDTIPOCALCULO,strValorActual,strValorNuevo);
			}	
			
			if(rubroemplea.getIsNew()||!rubroemplea.getid_tipo_rubro_emplea().equals(rubroemplea.getRubroEmpleaOriginal().getid_tipo_rubro_emplea()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rubroemplea.getRubroEmpleaOriginal().getid_tipo_rubro_emplea()!=null)
				{
					strValorActual=rubroemplea.getRubroEmpleaOriginal().getid_tipo_rubro_emplea().toString();
				}
				if(rubroemplea.getid_tipo_rubro_emplea()!=null)
				{
					strValorNuevo=rubroemplea.getid_tipo_rubro_emplea().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RubroEmpleaConstantesFunciones.IDTIPORUBROEMPLEA,strValorActual,strValorNuevo);
			}	
			
			if(rubroemplea.getIsNew()||!rubroemplea.getid_tipo_grupo_rubro_emplea().equals(rubroemplea.getRubroEmpleaOriginal().getid_tipo_grupo_rubro_emplea()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rubroemplea.getRubroEmpleaOriginal().getid_tipo_grupo_rubro_emplea()!=null)
				{
					strValorActual=rubroemplea.getRubroEmpleaOriginal().getid_tipo_grupo_rubro_emplea().toString();
				}
				if(rubroemplea.getid_tipo_grupo_rubro_emplea()!=null)
				{
					strValorNuevo=rubroemplea.getid_tipo_grupo_rubro_emplea().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RubroEmpleaConstantesFunciones.IDTIPOGRUPORUBROEMPLEA,strValorActual,strValorNuevo);
			}	
			
			if(rubroemplea.getIsNew()||!rubroemplea.getcodigo().equals(rubroemplea.getRubroEmpleaOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rubroemplea.getRubroEmpleaOriginal().getcodigo()!=null)
				{
					strValorActual=rubroemplea.getRubroEmpleaOriginal().getcodigo();
				}
				if(rubroemplea.getcodigo()!=null)
				{
					strValorNuevo=rubroemplea.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RubroEmpleaConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(rubroemplea.getIsNew()||!rubroemplea.getnombre().equals(rubroemplea.getRubroEmpleaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rubroemplea.getRubroEmpleaOriginal().getnombre()!=null)
				{
					strValorActual=rubroemplea.getRubroEmpleaOriginal().getnombre();
				}
				if(rubroemplea.getnombre()!=null)
				{
					strValorNuevo=rubroemplea.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RubroEmpleaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(rubroemplea.getIsNew()||!rubroemplea.getformula().equals(rubroemplea.getRubroEmpleaOriginal().getformula()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rubroemplea.getRubroEmpleaOriginal().getformula()!=null)
				{
					strValorActual=rubroemplea.getRubroEmpleaOriginal().getformula();
				}
				if(rubroemplea.getformula()!=null)
				{
					strValorNuevo=rubroemplea.getformula() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RubroEmpleaConstantesFunciones.FORMULA,strValorActual,strValorNuevo);
			}	
			
			if(rubroemplea.getIsNew()||!rubroemplea.getalias().equals(rubroemplea.getRubroEmpleaOriginal().getalias()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rubroemplea.getRubroEmpleaOriginal().getalias()!=null)
				{
					strValorActual=rubroemplea.getRubroEmpleaOriginal().getalias();
				}
				if(rubroemplea.getalias()!=null)
				{
					strValorNuevo=rubroemplea.getalias() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RubroEmpleaConstantesFunciones.ALIAS,strValorActual,strValorNuevo);
			}	
			
			if(rubroemplea.getIsNew()||!rubroemplea.getsecuencial().equals(rubroemplea.getRubroEmpleaOriginal().getsecuencial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rubroemplea.getRubroEmpleaOriginal().getsecuencial()!=null)
				{
					strValorActual=rubroemplea.getRubroEmpleaOriginal().getsecuencial().toString();
				}
				if(rubroemplea.getsecuencial()!=null)
				{
					strValorNuevo=rubroemplea.getsecuencial().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RubroEmpleaConstantesFunciones.SECUENCIAL,strValorActual,strValorNuevo);
			}	
			
			if(rubroemplea.getIsNew()||!rubroemplea.getpara_rol_pagos().equals(rubroemplea.getRubroEmpleaOriginal().getpara_rol_pagos()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rubroemplea.getRubroEmpleaOriginal().getpara_rol_pagos()!=null)
				{
					strValorActual=rubroemplea.getRubroEmpleaOriginal().getpara_rol_pagos().toString();
				}
				if(rubroemplea.getpara_rol_pagos()!=null)
				{
					strValorNuevo=rubroemplea.getpara_rol_pagos().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RubroEmpleaConstantesFunciones.PARAROLPAGOS,strValorActual,strValorNuevo);
			}	
			
			if(rubroemplea.getIsNew()||!rubroemplea.getpara_sueldo().equals(rubroemplea.getRubroEmpleaOriginal().getpara_sueldo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rubroemplea.getRubroEmpleaOriginal().getpara_sueldo()!=null)
				{
					strValorActual=rubroemplea.getRubroEmpleaOriginal().getpara_sueldo().toString();
				}
				if(rubroemplea.getpara_sueldo()!=null)
				{
					strValorNuevo=rubroemplea.getpara_sueldo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RubroEmpleaConstantesFunciones.PARASUELDO,strValorActual,strValorNuevo);
			}	
			
			if(rubroemplea.getIsNew()||!rubroemplea.getpara_vacaciones().equals(rubroemplea.getRubroEmpleaOriginal().getpara_vacaciones()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rubroemplea.getRubroEmpleaOriginal().getpara_vacaciones()!=null)
				{
					strValorActual=rubroemplea.getRubroEmpleaOriginal().getpara_vacaciones().toString();
				}
				if(rubroemplea.getpara_vacaciones()!=null)
				{
					strValorNuevo=rubroemplea.getpara_vacaciones().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RubroEmpleaConstantesFunciones.PARAVACACIONES,strValorActual,strValorNuevo);
			}	
			
			if(rubroemplea.getIsNew()||!rubroemplea.getpara_impuesto_renta().equals(rubroemplea.getRubroEmpleaOriginal().getpara_impuesto_renta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rubroemplea.getRubroEmpleaOriginal().getpara_impuesto_renta()!=null)
				{
					strValorActual=rubroemplea.getRubroEmpleaOriginal().getpara_impuesto_renta().toString();
				}
				if(rubroemplea.getpara_impuesto_renta()!=null)
				{
					strValorNuevo=rubroemplea.getpara_impuesto_renta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RubroEmpleaConstantesFunciones.PARAIMPUESTORENTA,strValorActual,strValorNuevo);
			}	
			
			if(rubroemplea.getIsNew()||!rubroemplea.getpara_seguro_social().equals(rubroemplea.getRubroEmpleaOriginal().getpara_seguro_social()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rubroemplea.getRubroEmpleaOriginal().getpara_seguro_social()!=null)
				{
					strValorActual=rubroemplea.getRubroEmpleaOriginal().getpara_seguro_social().toString();
				}
				if(rubroemplea.getpara_seguro_social()!=null)
				{
					strValorNuevo=rubroemplea.getpara_seguro_social().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RubroEmpleaConstantesFunciones.PARASEGUROSOCIAL,strValorActual,strValorNuevo);
			}	
			
			if(rubroemplea.getIsNew()||!rubroemplea.getpara_provisiones().equals(rubroemplea.getRubroEmpleaOriginal().getpara_provisiones()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rubroemplea.getRubroEmpleaOriginal().getpara_provisiones()!=null)
				{
					strValorActual=rubroemplea.getRubroEmpleaOriginal().getpara_provisiones().toString();
				}
				if(rubroemplea.getpara_provisiones()!=null)
				{
					strValorNuevo=rubroemplea.getpara_provisiones().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RubroEmpleaConstantesFunciones.PARAPROVISIONES,strValorActual,strValorNuevo);
			}	
			
			if(rubroemplea.getIsNew()||!rubroemplea.getpara_utilidades().equals(rubroemplea.getRubroEmpleaOriginal().getpara_utilidades()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rubroemplea.getRubroEmpleaOriginal().getpara_utilidades()!=null)
				{
					strValorActual=rubroemplea.getRubroEmpleaOriginal().getpara_utilidades().toString();
				}
				if(rubroemplea.getpara_utilidades()!=null)
				{
					strValorNuevo=rubroemplea.getpara_utilidades().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RubroEmpleaConstantesFunciones.PARAUTILIDADES,strValorActual,strValorNuevo);
			}	
			
			if(rubroemplea.getIsNew()||!rubroemplea.getpara_rubro_iess().equals(rubroemplea.getRubroEmpleaOriginal().getpara_rubro_iess()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rubroemplea.getRubroEmpleaOriginal().getpara_rubro_iess()!=null)
				{
					strValorActual=rubroemplea.getRubroEmpleaOriginal().getpara_rubro_iess().toString();
				}
				if(rubroemplea.getpara_rubro_iess()!=null)
				{
					strValorNuevo=rubroemplea.getpara_rubro_iess().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RubroEmpleaConstantesFunciones.PARARUBROIESS,strValorActual,strValorNuevo);
			}	
			
			if(rubroemplea.getIsNew()||!rubroemplea.getes_fondo_reserva().equals(rubroemplea.getRubroEmpleaOriginal().getes_fondo_reserva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rubroemplea.getRubroEmpleaOriginal().getes_fondo_reserva()!=null)
				{
					strValorActual=rubroemplea.getRubroEmpleaOriginal().getes_fondo_reserva().toString();
				}
				if(rubroemplea.getes_fondo_reserva()!=null)
				{
					strValorNuevo=rubroemplea.getes_fondo_reserva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RubroEmpleaConstantesFunciones.ESFONDORESERVA,strValorActual,strValorNuevo);
			}	
			
			if(rubroemplea.getIsNew()||!rubroemplea.getes_decimo_tercero().equals(rubroemplea.getRubroEmpleaOriginal().getes_decimo_tercero()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rubroemplea.getRubroEmpleaOriginal().getes_decimo_tercero()!=null)
				{
					strValorActual=rubroemplea.getRubroEmpleaOriginal().getes_decimo_tercero().toString();
				}
				if(rubroemplea.getes_decimo_tercero()!=null)
				{
					strValorNuevo=rubroemplea.getes_decimo_tercero().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RubroEmpleaConstantesFunciones.ESDECIMOTERCERO,strValorActual,strValorNuevo);
			}	
			
			if(rubroemplea.getIsNew()||!rubroemplea.getes_decimo_cuarto().equals(rubroemplea.getRubroEmpleaOriginal().getes_decimo_cuarto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(rubroemplea.getRubroEmpleaOriginal().getes_decimo_cuarto()!=null)
				{
					strValorActual=rubroemplea.getRubroEmpleaOriginal().getes_decimo_cuarto().toString();
				}
				if(rubroemplea.getes_decimo_cuarto()!=null)
				{
					strValorNuevo=rubroemplea.getes_decimo_cuarto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),RubroEmpleaConstantesFunciones.ESDECIMOCUARTO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveRubroEmpleaRelacionesWithConnection(RubroEmplea rubroemplea,List<HistorialPagoNomi> historialpagonomis,List<RubroEstructura> rubroestructuras,List<DefiProvisionEmpleado> defiprovisionempleados,List<EmpleadoPagoRubro> empleadopagorubros,List<HistorialPagoMesNomi> historialpagomesnomis,List<RubroEmpleado> rubroempleados,List<ValorRubroVariable> valorrubrovariables,List<TipoPrestamo> tipoprestamos,List<RubroEmpleaCuentaContable> rubroempleacuentacontables) throws Exception {

		if(!rubroemplea.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveRubroEmpleaRelacionesBase(rubroemplea,historialpagonomis,rubroestructuras,defiprovisionempleados,empleadopagorubros,historialpagomesnomis,rubroempleados,valorrubrovariables,tipoprestamos,rubroempleacuentacontables,true);
		}
	}

	public void saveRubroEmpleaRelaciones(RubroEmplea rubroemplea,List<HistorialPagoNomi> historialpagonomis,List<RubroEstructura> rubroestructuras,List<DefiProvisionEmpleado> defiprovisionempleados,List<EmpleadoPagoRubro> empleadopagorubros,List<HistorialPagoMesNomi> historialpagomesnomis,List<RubroEmpleado> rubroempleados,List<ValorRubroVariable> valorrubrovariables,List<TipoPrestamo> tipoprestamos,List<RubroEmpleaCuentaContable> rubroempleacuentacontables)throws Exception {

		if(!rubroemplea.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveRubroEmpleaRelacionesBase(rubroemplea,historialpagonomis,rubroestructuras,defiprovisionempleados,empleadopagorubros,historialpagomesnomis,rubroempleados,valorrubrovariables,tipoprestamos,rubroempleacuentacontables,false);
		}
	}

	public void saveRubroEmpleaRelacionesBase(RubroEmplea rubroemplea,List<HistorialPagoNomi> historialpagonomis,List<RubroEstructura> rubroestructuras,List<DefiProvisionEmpleado> defiprovisionempleados,List<EmpleadoPagoRubro> empleadopagorubros,List<HistorialPagoMesNomi> historialpagomesnomis,List<RubroEmpleado> rubroempleados,List<ValorRubroVariable> valorrubrovariables,List<TipoPrestamo> tipoprestamos,List<RubroEmpleaCuentaContable> rubroempleacuentacontables,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("RubroEmplea-saveRelacionesWithConnection");}
	
			rubroemplea.setHistorialPagoNomis(historialpagonomis);
			rubroemplea.setRubroEstructuras(rubroestructuras);
			rubroemplea.setDefiProvisionEmpleados(defiprovisionempleados);
			rubroemplea.setEmpleadoPagoRubros(empleadopagorubros);
			rubroemplea.setHistorialPagoMesNomis(historialpagomesnomis);
			rubroemplea.setRubroEmpleados(rubroempleados);
			rubroemplea.setValorRubroVariables(valorrubrovariables);
			rubroemplea.setTipoPrestamos(tipoprestamos);
			rubroemplea.setRubroEmpleaCuentaContables(rubroempleacuentacontables);

			this.setRubroEmplea(rubroemplea);

			if(RubroEmpleaLogicAdditional.validarSaveRelaciones(rubroemplea,this)) {

				RubroEmpleaLogicAdditional.updateRelacionesToSave(rubroemplea,this);

				if((rubroemplea.getIsNew()||rubroemplea.getIsChanged())&&!rubroemplea.getIsDeleted()) {
					this.saveRubroEmplea();
					this.saveRubroEmpleaRelacionesDetalles(historialpagonomis,rubroestructuras,defiprovisionempleados,empleadopagorubros,historialpagomesnomis,rubroempleados,valorrubrovariables,tipoprestamos,rubroempleacuentacontables);

				} else if(rubroemplea.getIsDeleted()) {
					this.saveRubroEmpleaRelacionesDetalles(historialpagonomis,rubroestructuras,defiprovisionempleados,empleadopagorubros,historialpagomesnomis,rubroempleados,valorrubrovariables,tipoprestamos,rubroempleacuentacontables);
					this.saveRubroEmplea();
				}

				RubroEmpleaLogicAdditional.updateRelacionesToSaveAfter(rubroemplea,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			HistorialPagoNomiConstantesFunciones.InicializarGeneralEntityAuxiliaresHistorialPagoNomis(historialpagonomis,true,true);
			RubroEstructuraConstantesFunciones.InicializarGeneralEntityAuxiliaresRubroEstructuras(rubroestructuras,true,true);
			DefiProvisionEmpleadoConstantesFunciones.InicializarGeneralEntityAuxiliaresDefiProvisionEmpleados(defiprovisionempleados,true,true);
			EmpleadoPagoRubroConstantesFunciones.InicializarGeneralEntityAuxiliaresEmpleadoPagoRubros(empleadopagorubros,true,true);
			HistorialPagoMesNomiConstantesFunciones.InicializarGeneralEntityAuxiliaresHistorialPagoMesNomis(historialpagomesnomis,true,true);
			RubroEmpleadoConstantesFunciones.InicializarGeneralEntityAuxiliaresRubroEmpleados(rubroempleados,true,true);
			ValorRubroVariableConstantesFunciones.InicializarGeneralEntityAuxiliaresValorRubroVariables(valorrubrovariables,true,true);
			TipoPrestamoConstantesFunciones.InicializarGeneralEntityAuxiliaresTipoPrestamos(tipoprestamos,true,true);
			RubroEmpleaCuentaContableConstantesFunciones.InicializarGeneralEntityAuxiliaresRubroEmpleaCuentaContables(rubroempleacuentacontables,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveRubroEmpleaRelacionesDetalles(List<HistorialPagoNomi> historialpagonomis,List<RubroEstructura> rubroestructuras,List<DefiProvisionEmpleado> defiprovisionempleados,List<EmpleadoPagoRubro> empleadopagorubros,List<HistorialPagoMesNomi> historialpagomesnomis,List<RubroEmpleado> rubroempleados,List<ValorRubroVariable> valorrubrovariables,List<TipoPrestamo> tipoprestamos,List<RubroEmpleaCuentaContable> rubroempleacuentacontables)throws Exception {
		try {
	

			Long idRubroEmpleaActual=this.getRubroEmplea().getId();

			HistorialPagoNomiLogic historialpagonomiLogic_Desde_RubroEmplea=new HistorialPagoNomiLogic();
			historialpagonomiLogic_Desde_RubroEmplea.setHistorialPagoNomis(historialpagonomis);

			historialpagonomiLogic_Desde_RubroEmplea.setConnexion(this.getConnexion());
			historialpagonomiLogic_Desde_RubroEmplea.setDatosCliente(this.datosCliente);

			for(HistorialPagoNomi historialpagonomi_Desde_RubroEmplea:historialpagonomiLogic_Desde_RubroEmplea.getHistorialPagoNomis()) {
				historialpagonomi_Desde_RubroEmplea.setid_rubro_emplea(idRubroEmpleaActual);
			}

			historialpagonomiLogic_Desde_RubroEmplea.saveHistorialPagoNomis();

			RubroEstructuraLogic rubroestructuraLogic_Desde_RubroEmplea=new RubroEstructuraLogic();
			rubroestructuraLogic_Desde_RubroEmplea.setRubroEstructuras(rubroestructuras);

			rubroestructuraLogic_Desde_RubroEmplea.setConnexion(this.getConnexion());
			rubroestructuraLogic_Desde_RubroEmplea.setDatosCliente(this.datosCliente);

			for(RubroEstructura rubroestructura_Desde_RubroEmplea:rubroestructuraLogic_Desde_RubroEmplea.getRubroEstructuras()) {
				rubroestructura_Desde_RubroEmplea.setid_rubro_emplea(idRubroEmpleaActual);
			}

			rubroestructuraLogic_Desde_RubroEmplea.saveRubroEstructuras();

			DefiProvisionEmpleadoLogic defiprovisionempleadoLogic_Desde_RubroEmplea=new DefiProvisionEmpleadoLogic();
			defiprovisionempleadoLogic_Desde_RubroEmplea.setDefiProvisionEmpleados(defiprovisionempleados);

			defiprovisionempleadoLogic_Desde_RubroEmplea.setConnexion(this.getConnexion());
			defiprovisionempleadoLogic_Desde_RubroEmplea.setDatosCliente(this.datosCliente);

			for(DefiProvisionEmpleado defiprovisionempleado_Desde_RubroEmplea:defiprovisionempleadoLogic_Desde_RubroEmplea.getDefiProvisionEmpleados()) {
				defiprovisionempleado_Desde_RubroEmplea.setid_rubro_emplea(idRubroEmpleaActual);

				defiprovisionempleadoLogic_Desde_RubroEmplea.setDefiProvisionEmpleado(defiprovisionempleado_Desde_RubroEmplea);
				defiprovisionempleadoLogic_Desde_RubroEmplea.saveDefiProvisionEmpleado();

				Long idDefiProvisionEmpleadoActual=defiprovisionempleado_Desde_RubroEmplea.getId();

				ProvisionEmpleadoLogic provisionempleadoLogic_Desde_DefiProvisionEmpleado=new ProvisionEmpleadoLogic();

				if(defiprovisionempleado_Desde_RubroEmplea.getProvisionEmpleados()==null){
					defiprovisionempleado_Desde_RubroEmplea.setProvisionEmpleados(new ArrayList<ProvisionEmpleado>());
				}

				provisionempleadoLogic_Desde_DefiProvisionEmpleado.setProvisionEmpleados(defiprovisionempleado_Desde_RubroEmplea.getProvisionEmpleados());

				provisionempleadoLogic_Desde_DefiProvisionEmpleado.setConnexion(this.getConnexion());
				provisionempleadoLogic_Desde_DefiProvisionEmpleado.setDatosCliente(this.datosCliente);

				for(ProvisionEmpleado provisionempleado_Desde_DefiProvisionEmpleado:provisionempleadoLogic_Desde_DefiProvisionEmpleado.getProvisionEmpleados()) {
					provisionempleado_Desde_DefiProvisionEmpleado.setid_defi_provision_empleado(idDefiProvisionEmpleadoActual);
				}

				provisionempleadoLogic_Desde_DefiProvisionEmpleado.saveProvisionEmpleados();

				CuotaLogic cuotaLogic_Desde_DefiProvisionEmpleado=new CuotaLogic();

				if(defiprovisionempleado_Desde_RubroEmplea.getCuotas()==null){
					defiprovisionempleado_Desde_RubroEmplea.setCuotas(new ArrayList<Cuota>());
				}

				cuotaLogic_Desde_DefiProvisionEmpleado.setCuotas(defiprovisionempleado_Desde_RubroEmplea.getCuotas());

				cuotaLogic_Desde_DefiProvisionEmpleado.setConnexion(this.getConnexion());
				cuotaLogic_Desde_DefiProvisionEmpleado.setDatosCliente(this.datosCliente);

				for(Cuota cuota_Desde_DefiProvisionEmpleado:cuotaLogic_Desde_DefiProvisionEmpleado.getCuotas()) {
					cuota_Desde_DefiProvisionEmpleado.setid_defi_provision_empleado(idDefiProvisionEmpleadoActual);
				}

				cuotaLogic_Desde_DefiProvisionEmpleado.saveCuotas();
			}


			EmpleadoPagoRubroLogic empleadopagorubroLogic_Desde_RubroEmplea=new EmpleadoPagoRubroLogic();
			empleadopagorubroLogic_Desde_RubroEmplea.setEmpleadoPagoRubros(empleadopagorubros);

			empleadopagorubroLogic_Desde_RubroEmplea.setConnexion(this.getConnexion());
			empleadopagorubroLogic_Desde_RubroEmplea.setDatosCliente(this.datosCliente);

			for(EmpleadoPagoRubro empleadopagorubro_Desde_RubroEmplea:empleadopagorubroLogic_Desde_RubroEmplea.getEmpleadoPagoRubros()) {
				empleadopagorubro_Desde_RubroEmplea.setid_rubro_emplea(idRubroEmpleaActual);
			}

			empleadopagorubroLogic_Desde_RubroEmplea.saveEmpleadoPagoRubros();

			HistorialPagoMesNomiLogic historialpagomesnomiLogic_Desde_RubroEmplea=new HistorialPagoMesNomiLogic();
			historialpagomesnomiLogic_Desde_RubroEmplea.setHistorialPagoMesNomis(historialpagomesnomis);

			historialpagomesnomiLogic_Desde_RubroEmplea.setConnexion(this.getConnexion());
			historialpagomesnomiLogic_Desde_RubroEmplea.setDatosCliente(this.datosCliente);

			for(HistorialPagoMesNomi historialpagomesnomi_Desde_RubroEmplea:historialpagomesnomiLogic_Desde_RubroEmplea.getHistorialPagoMesNomis()) {
				historialpagomesnomi_Desde_RubroEmplea.setid_rubro_emplea(idRubroEmpleaActual);
			}

			historialpagomesnomiLogic_Desde_RubroEmplea.saveHistorialPagoMesNomis();

			RubroEmpleadoLogic rubroempleadoLogic_Desde_RubroEmplea=new RubroEmpleadoLogic();
			rubroempleadoLogic_Desde_RubroEmplea.setRubroEmpleados(rubroempleados);

			rubroempleadoLogic_Desde_RubroEmplea.setConnexion(this.getConnexion());
			rubroempleadoLogic_Desde_RubroEmplea.setDatosCliente(this.datosCliente);

			for(RubroEmpleado rubroempleado_Desde_RubroEmplea:rubroempleadoLogic_Desde_RubroEmplea.getRubroEmpleados()) {
				rubroempleado_Desde_RubroEmplea.setid_rubro_emplea(idRubroEmpleaActual);
			}

			rubroempleadoLogic_Desde_RubroEmplea.saveRubroEmpleados();

			ValorRubroVariableLogic valorrubrovariableLogic_Desde_RubroEmplea=new ValorRubroVariableLogic();
			valorrubrovariableLogic_Desde_RubroEmplea.setValorRubroVariables(valorrubrovariables);

			valorrubrovariableLogic_Desde_RubroEmplea.setConnexion(this.getConnexion());
			valorrubrovariableLogic_Desde_RubroEmplea.setDatosCliente(this.datosCliente);

			for(ValorRubroVariable valorrubrovariable_Desde_RubroEmplea:valorrubrovariableLogic_Desde_RubroEmplea.getValorRubroVariables()) {
				valorrubrovariable_Desde_RubroEmplea.setid_rubro_emplea(idRubroEmpleaActual);
			}

			valorrubrovariableLogic_Desde_RubroEmplea.saveValorRubroVariables();

			TipoPrestamoLogic tipoprestamoLogic_Desde_RubroEmplea=new TipoPrestamoLogic();
			tipoprestamoLogic_Desde_RubroEmplea.setTipoPrestamos(tipoprestamos);

			tipoprestamoLogic_Desde_RubroEmplea.setConnexion(this.getConnexion());
			tipoprestamoLogic_Desde_RubroEmplea.setDatosCliente(this.datosCliente);

			for(TipoPrestamo tipoprestamo_Desde_RubroEmplea:tipoprestamoLogic_Desde_RubroEmplea.getTipoPrestamos()) {
				tipoprestamo_Desde_RubroEmplea.setid_rubro_emplea(idRubroEmpleaActual);

				tipoprestamoLogic_Desde_RubroEmplea.setTipoPrestamo(tipoprestamo_Desde_RubroEmplea);
				tipoprestamoLogic_Desde_RubroEmplea.saveTipoPrestamo();

				Long idTipoPrestamoActual=tipoprestamo_Desde_RubroEmplea.getId();

				PrestamoLogic prestamoLogic_Desde_TipoPrestamo=new PrestamoLogic();

				if(tipoprestamo_Desde_RubroEmplea.getPrestamos()==null){
					tipoprestamo_Desde_RubroEmplea.setPrestamos(new ArrayList<Prestamo>());
				}

				prestamoLogic_Desde_TipoPrestamo.setPrestamos(tipoprestamo_Desde_RubroEmplea.getPrestamos());

				prestamoLogic_Desde_TipoPrestamo.setConnexion(this.getConnexion());
				prestamoLogic_Desde_TipoPrestamo.setDatosCliente(this.datosCliente);

				for(Prestamo prestamo_Desde_TipoPrestamo:prestamoLogic_Desde_TipoPrestamo.getPrestamos()) {
					prestamo_Desde_TipoPrestamo.setid_tipo_prestamo(idTipoPrestamoActual);

					prestamoLogic_Desde_TipoPrestamo.setPrestamo(prestamo_Desde_TipoPrestamo);
					prestamoLogic_Desde_TipoPrestamo.savePrestamo();

					Long idPrestamoActual=prestamo_Desde_TipoPrestamo.getId();

					AbonoPrestamoLogic abonoprestamoLogic_Desde_Prestamo=new AbonoPrestamoLogic();

					if(prestamo_Desde_TipoPrestamo.getAbonoPrestamos()==null){
						prestamo_Desde_TipoPrestamo.setAbonoPrestamos(new ArrayList<AbonoPrestamo>());
					}

					abonoprestamoLogic_Desde_Prestamo.setAbonoPrestamos(prestamo_Desde_TipoPrestamo.getAbonoPrestamos());

					abonoprestamoLogic_Desde_Prestamo.setConnexion(this.getConnexion());
					abonoprestamoLogic_Desde_Prestamo.setDatosCliente(this.datosCliente);

					for(AbonoPrestamo abonoprestamo_Desde_Prestamo:abonoprestamoLogic_Desde_Prestamo.getAbonoPrestamos()) {
						abonoprestamo_Desde_Prestamo.setid_prestamo(idPrestamoActual);
					}

					abonoprestamoLogic_Desde_Prestamo.saveAbonoPrestamos();

					CuotaLogic cuotaLogic_Desde_Prestamo=new CuotaLogic();

					if(prestamo_Desde_TipoPrestamo.getCuotas()==null){
						prestamo_Desde_TipoPrestamo.setCuotas(new ArrayList<Cuota>());
					}

					cuotaLogic_Desde_Prestamo.setCuotas(prestamo_Desde_TipoPrestamo.getCuotas());

					cuotaLogic_Desde_Prestamo.setConnexion(this.getConnexion());
					cuotaLogic_Desde_Prestamo.setDatosCliente(this.datosCliente);

					for(Cuota cuota_Desde_Prestamo:cuotaLogic_Desde_Prestamo.getCuotas()) {
						cuota_Desde_Prestamo.setid_prestamo(idPrestamoActual);
					}

					cuotaLogic_Desde_Prestamo.saveCuotas();
				}

			}


			RubroEmpleaCuentaContableLogic rubroempleacuentacontableLogic_Desde_RubroEmplea=new RubroEmpleaCuentaContableLogic();
			rubroempleacuentacontableLogic_Desde_RubroEmplea.setRubroEmpleaCuentaContables(rubroempleacuentacontables);

			rubroempleacuentacontableLogic_Desde_RubroEmplea.setConnexion(this.getConnexion());
			rubroempleacuentacontableLogic_Desde_RubroEmplea.setDatosCliente(this.datosCliente);

			for(RubroEmpleaCuentaContable rubroempleacuentacontable_Desde_RubroEmplea:rubroempleacuentacontableLogic_Desde_RubroEmplea.getRubroEmpleaCuentaContables()) {
				rubroempleacuentacontable_Desde_RubroEmplea.setid_rubro_emplea(idRubroEmpleaActual);
			}

			rubroempleacuentacontableLogic_Desde_RubroEmplea.saveRubroEmpleaCuentaContables();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfRubroEmplea(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=RubroEmpleaConstantesFunciones.getClassesForeignKeysOfRubroEmplea(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfRubroEmplea(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=RubroEmpleaConstantesFunciones.getClassesRelationshipsOfRubroEmplea(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

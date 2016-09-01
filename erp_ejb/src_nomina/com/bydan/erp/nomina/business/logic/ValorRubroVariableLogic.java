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
import com.bydan.erp.nomina.util.ValorRubroVariableConstantesFunciones;
import com.bydan.erp.nomina.util.ValorRubroVariableParameterReturnGeneral;
//import com.bydan.erp.nomina.util.ValorRubroVariableParameterGeneral;
import com.bydan.erp.nomina.business.entity.ValorRubroVariable;
import com.bydan.erp.nomina.business.logic.ValorRubroVariableLogicAdditional;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.nomina.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class ValorRubroVariableLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(ValorRubroVariableLogic.class);
	
	protected ValorRubroVariableDataAccess valorrubrovariableDataAccess; 	
	protected ValorRubroVariable valorrubrovariable;
	protected List<ValorRubroVariable> valorrubrovariables;
	protected Object valorrubrovariableObject;	
	protected List<Object> valorrubrovariablesObject;
	
	public static ClassValidator<ValorRubroVariable> valorrubrovariableValidator = new ClassValidator<ValorRubroVariable>(ValorRubroVariable.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected ValorRubroVariableLogicAdditional valorrubrovariableLogicAdditional=null;
	
	public ValorRubroVariableLogicAdditional getValorRubroVariableLogicAdditional() {
		return this.valorrubrovariableLogicAdditional;
	}
	
	public void setValorRubroVariableLogicAdditional(ValorRubroVariableLogicAdditional valorrubrovariableLogicAdditional) {
		try {
			this.valorrubrovariableLogicAdditional=valorrubrovariableLogicAdditional;
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
	
	
	
	
	public  ValorRubroVariableLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.valorrubrovariableDataAccess = new ValorRubroVariableDataAccess();
			
			this.valorrubrovariables= new ArrayList<ValorRubroVariable>();
			this.valorrubrovariable= new ValorRubroVariable();
			
			this.valorrubrovariableObject=new Object();
			this.valorrubrovariablesObject=new ArrayList<Object>();
				
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
			
			this.valorrubrovariableDataAccess.setConnexionType(this.connexionType);
			this.valorrubrovariableDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  ValorRubroVariableLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.valorrubrovariableDataAccess = new ValorRubroVariableDataAccess();
			this.valorrubrovariables= new ArrayList<ValorRubroVariable>();
			this.valorrubrovariable= new ValorRubroVariable();
			this.valorrubrovariableObject=new Object();
			this.valorrubrovariablesObject=new ArrayList<Object>();
			
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
			
			this.valorrubrovariableDataAccess.setConnexionType(this.connexionType);
			this.valorrubrovariableDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public ValorRubroVariable getValorRubroVariable() throws Exception {	
		ValorRubroVariableLogicAdditional.checkValorRubroVariableToGet(valorrubrovariable,this.datosCliente,this.arrDatoGeneral);
		ValorRubroVariableLogicAdditional.updateValorRubroVariableToGet(valorrubrovariable,this.arrDatoGeneral);
		
		return valorrubrovariable;
	}
		
	public void setValorRubroVariable(ValorRubroVariable newValorRubroVariable) {
		this.valorrubrovariable = newValorRubroVariable;
	}
	
	public ValorRubroVariableDataAccess getValorRubroVariableDataAccess() {
		return valorrubrovariableDataAccess;
	}
	
	public void setValorRubroVariableDataAccess(ValorRubroVariableDataAccess newvalorrubrovariableDataAccess) {
		this.valorrubrovariableDataAccess = newvalorrubrovariableDataAccess;
	}
	
	public List<ValorRubroVariable> getValorRubroVariables() throws Exception {		
		this.quitarValorRubroVariablesNulos();
		
		ValorRubroVariableLogicAdditional.checkValorRubroVariableToGets(valorrubrovariables,this.datosCliente,this.arrDatoGeneral);
		
		for (ValorRubroVariable valorrubrovariableLocal: valorrubrovariables ) {
			ValorRubroVariableLogicAdditional.updateValorRubroVariableToGet(valorrubrovariableLocal,this.arrDatoGeneral);
		}
		
		return valorrubrovariables;
	}
	
	public void setValorRubroVariables(List<ValorRubroVariable> newValorRubroVariables) {
		this.valorrubrovariables = newValorRubroVariables;
	}
	
	public Object getValorRubroVariableObject() {	
		this.valorrubrovariableObject=this.valorrubrovariableDataAccess.getEntityObject();
		return this.valorrubrovariableObject;
	}
		
	public void setValorRubroVariableObject(Object newValorRubroVariableObject) {
		this.valorrubrovariableObject = newValorRubroVariableObject;
	}
	
	public List<Object> getValorRubroVariablesObject() {		
		this.valorrubrovariablesObject=this.valorrubrovariableDataAccess.getEntitiesObject();
		return this.valorrubrovariablesObject;
	}
		
	public void setValorRubroVariablesObject(List<Object> newValorRubroVariablesObject) {
		this.valorrubrovariablesObject = newValorRubroVariablesObject;
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
		
		if(this.valorrubrovariableDataAccess!=null) {
			this.valorrubrovariableDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorRubroVariable.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			valorrubrovariableDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			valorrubrovariableDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		valorrubrovariable = new  ValorRubroVariable();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorRubroVariable.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			valorrubrovariable=valorrubrovariableDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.valorrubrovariable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ValorRubroVariableConstantesFunciones.refrescarForeignKeysDescripcionesValorRubroVariable(this.valorrubrovariable);
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
		valorrubrovariable = new  ValorRubroVariable();
		  		  
        try {
			
			valorrubrovariable=valorrubrovariableDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.valorrubrovariable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ValorRubroVariableConstantesFunciones.refrescarForeignKeysDescripcionesValorRubroVariable(this.valorrubrovariable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		valorrubrovariable = new  ValorRubroVariable();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorRubroVariable.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			valorrubrovariable=valorrubrovariableDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.valorrubrovariable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ValorRubroVariableConstantesFunciones.refrescarForeignKeysDescripcionesValorRubroVariable(this.valorrubrovariable);
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
		valorrubrovariable = new  ValorRubroVariable();
		  		  
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
		valorrubrovariable = new  ValorRubroVariable();
		  		  
        try {
			
			valorrubrovariable=valorrubrovariableDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.valorrubrovariable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				ValorRubroVariableConstantesFunciones.refrescarForeignKeysDescripcionesValorRubroVariable(this.valorrubrovariable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		valorrubrovariable = new  ValorRubroVariable();
		  		  
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
		valorrubrovariable = new  ValorRubroVariable();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorRubroVariable.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =valorrubrovariableDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		valorrubrovariable = new  ValorRubroVariable();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=valorrubrovariableDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		valorrubrovariable = new  ValorRubroVariable();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorRubroVariable.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =valorrubrovariableDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		valorrubrovariable = new  ValorRubroVariable();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=valorrubrovariableDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		valorrubrovariable = new  ValorRubroVariable();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorRubroVariable.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =valorrubrovariableDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		valorrubrovariable = new  ValorRubroVariable();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=valorrubrovariableDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		valorrubrovariables = new  ArrayList<ValorRubroVariable>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorRubroVariable.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			ValorRubroVariableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			valorrubrovariables=valorrubrovariableDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarValorRubroVariable(valorrubrovariables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ValorRubroVariableConstantesFunciones.refrescarForeignKeysDescripcionesValorRubroVariable(this.valorrubrovariables);
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
		valorrubrovariables = new  ArrayList<ValorRubroVariable>();
		  		  
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
		valorrubrovariables = new  ArrayList<ValorRubroVariable>();
		  		  
        try {			
			ValorRubroVariableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			valorrubrovariables=valorrubrovariableDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarValorRubroVariable(valorrubrovariables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ValorRubroVariableConstantesFunciones.refrescarForeignKeysDescripcionesValorRubroVariable(this.valorrubrovariables);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		valorrubrovariables = new  ArrayList<ValorRubroVariable>();
		  		  
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
		valorrubrovariables = new  ArrayList<ValorRubroVariable>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorRubroVariable.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			ValorRubroVariableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			valorrubrovariables=valorrubrovariableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarValorRubroVariable(valorrubrovariables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ValorRubroVariableConstantesFunciones.refrescarForeignKeysDescripcionesValorRubroVariable(this.valorrubrovariables);
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
		valorrubrovariables = new  ArrayList<ValorRubroVariable>();
		  		  
        try {
			ValorRubroVariableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			valorrubrovariables=valorrubrovariableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarValorRubroVariable(valorrubrovariables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ValorRubroVariableConstantesFunciones.refrescarForeignKeysDescripcionesValorRubroVariable(this.valorrubrovariables);
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
		valorrubrovariables = new  ArrayList<ValorRubroVariable>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorRubroVariable.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ValorRubroVariableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			valorrubrovariables=valorrubrovariableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarValorRubroVariable(valorrubrovariables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ValorRubroVariableConstantesFunciones.refrescarForeignKeysDescripcionesValorRubroVariable(this.valorrubrovariables);
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
		valorrubrovariables = new  ArrayList<ValorRubroVariable>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ValorRubroVariableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			valorrubrovariables=valorrubrovariableDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarValorRubroVariable(valorrubrovariables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ValorRubroVariableConstantesFunciones.refrescarForeignKeysDescripcionesValorRubroVariable(this.valorrubrovariables);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		valorrubrovariable = new  ValorRubroVariable();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorRubroVariable.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ValorRubroVariableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			valorrubrovariable=valorrubrovariableDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarValorRubroVariable(valorrubrovariable);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ValorRubroVariableConstantesFunciones.refrescarForeignKeysDescripcionesValorRubroVariable(this.valorrubrovariable);
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
		valorrubrovariable = new  ValorRubroVariable();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ValorRubroVariableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			valorrubrovariable=valorrubrovariableDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarValorRubroVariable(valorrubrovariable);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ValorRubroVariableConstantesFunciones.refrescarForeignKeysDescripcionesValorRubroVariable(this.valorrubrovariable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		valorrubrovariables = new  ArrayList<ValorRubroVariable>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorRubroVariable.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			ValorRubroVariableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			valorrubrovariables=valorrubrovariableDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarValorRubroVariable(valorrubrovariables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ValorRubroVariableConstantesFunciones.refrescarForeignKeysDescripcionesValorRubroVariable(this.valorrubrovariables);
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
		valorrubrovariables = new  ArrayList<ValorRubroVariable>();
		  		  
        try {
			ValorRubroVariableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			valorrubrovariables=valorrubrovariableDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarValorRubroVariable(valorrubrovariables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ValorRubroVariableConstantesFunciones.refrescarForeignKeysDescripcionesValorRubroVariable(this.valorrubrovariables);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosValorRubroVariablesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		valorrubrovariables = new  ArrayList<ValorRubroVariable>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorRubroVariable.class.getSimpleName()+"-getTodosValorRubroVariablesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ValorRubroVariableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			valorrubrovariables=valorrubrovariableDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarValorRubroVariable(valorrubrovariables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ValorRubroVariableConstantesFunciones.refrescarForeignKeysDescripcionesValorRubroVariable(this.valorrubrovariables);
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
	
	public  void  getTodosValorRubroVariables(String sFinalQuery,Pagination pagination)throws Exception {
		valorrubrovariables = new  ArrayList<ValorRubroVariable>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			ValorRubroVariableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			valorrubrovariables=valorrubrovariableDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarValorRubroVariable(valorrubrovariables);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				ValorRubroVariableConstantesFunciones.refrescarForeignKeysDescripcionesValorRubroVariable(this.valorrubrovariables);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarValorRubroVariable(ValorRubroVariable valorrubrovariable) throws Exception {
		Boolean estaValidado=false;
		
		if(valorrubrovariable.getIsNew() || valorrubrovariable.getIsChanged()) { 
			this.invalidValues = valorrubrovariableValidator.getInvalidValues(valorrubrovariable);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(valorrubrovariable);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarValorRubroVariable(List<ValorRubroVariable> ValorRubroVariables) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(ValorRubroVariable valorrubrovariableLocal:valorrubrovariables) {				
			estaValidadoObjeto=this.validarGuardarValorRubroVariable(valorrubrovariableLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarValorRubroVariable(List<ValorRubroVariable> ValorRubroVariables) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarValorRubroVariable(valorrubrovariables)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarValorRubroVariable(ValorRubroVariable ValorRubroVariable) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarValorRubroVariable(valorrubrovariable)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(ValorRubroVariable valorrubrovariable) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+valorrubrovariable.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=ValorRubroVariableConstantesFunciones.getValorRubroVariableLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"valorrubrovariable","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(ValorRubroVariableConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(ValorRubroVariableConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveValorRubroVariableWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorRubroVariable.class.getSimpleName()+"-saveValorRubroVariableWithConnection");connexion.begin();			
			
			ValorRubroVariableLogicAdditional.checkValorRubroVariableToSave(this.valorrubrovariable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ValorRubroVariableLogicAdditional.updateValorRubroVariableToSave(this.valorrubrovariable,this.arrDatoGeneral);
			
			ValorRubroVariableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.valorrubrovariable,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowValorRubroVariable();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarValorRubroVariable(this.valorrubrovariable)) {
				ValorRubroVariableDataAccess.save(this.valorrubrovariable, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.valorrubrovariable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ValorRubroVariableLogicAdditional.checkValorRubroVariableToSaveAfter(this.valorrubrovariable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowValorRubroVariable();
			
			connexion.commit();			
			
			if(this.valorrubrovariable.getIsDeleted()) {
				this.valorrubrovariable=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveValorRubroVariable()throws Exception {	
		try {	
			
			ValorRubroVariableLogicAdditional.checkValorRubroVariableToSave(this.valorrubrovariable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			ValorRubroVariableLogicAdditional.updateValorRubroVariableToSave(this.valorrubrovariable,this.arrDatoGeneral);
			
			ValorRubroVariableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.valorrubrovariable,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarValorRubroVariable(this.valorrubrovariable)) {			
				ValorRubroVariableDataAccess.save(this.valorrubrovariable, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.valorrubrovariable,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			ValorRubroVariableLogicAdditional.checkValorRubroVariableToSaveAfter(this.valorrubrovariable,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.valorrubrovariable.getIsDeleted()) {
				this.valorrubrovariable=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveValorRubroVariablesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorRubroVariable.class.getSimpleName()+"-saveValorRubroVariablesWithConnection");connexion.begin();			
			
			ValorRubroVariableLogicAdditional.checkValorRubroVariableToSaves(valorrubrovariables,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowValorRubroVariables();
			
			Boolean validadoTodosValorRubroVariable=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ValorRubroVariable valorrubrovariableLocal:valorrubrovariables) {		
				if(valorrubrovariableLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ValorRubroVariableLogicAdditional.updateValorRubroVariableToSave(valorrubrovariableLocal,this.arrDatoGeneral);
	        	
				ValorRubroVariableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),valorrubrovariableLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarValorRubroVariable(valorrubrovariableLocal)) {
					ValorRubroVariableDataAccess.save(valorrubrovariableLocal, connexion);				
				} else {
					validadoTodosValorRubroVariable=false;
				}
			}
			
			if(!validadoTodosValorRubroVariable) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ValorRubroVariableLogicAdditional.checkValorRubroVariableToSavesAfter(valorrubrovariables,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowValorRubroVariables();
			
			connexion.commit();		
			
			this.quitarValorRubroVariablesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveValorRubroVariables()throws Exception {				
		 try {	
			ValorRubroVariableLogicAdditional.checkValorRubroVariableToSaves(valorrubrovariables,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosValorRubroVariable=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(ValorRubroVariable valorrubrovariableLocal:valorrubrovariables) {				
				if(valorrubrovariableLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				ValorRubroVariableLogicAdditional.updateValorRubroVariableToSave(valorrubrovariableLocal,this.arrDatoGeneral);
	        	
				ValorRubroVariableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),valorrubrovariableLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarValorRubroVariable(valorrubrovariableLocal)) {				
					ValorRubroVariableDataAccess.save(valorrubrovariableLocal, connexion);				
				} else {
					validadoTodosValorRubroVariable=false;
				}
			}
			
			if(!validadoTodosValorRubroVariable) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			ValorRubroVariableLogicAdditional.checkValorRubroVariableToSavesAfter(valorrubrovariables,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarValorRubroVariablesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ValorRubroVariableParameterReturnGeneral procesarAccionValorRubroVariables(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ValorRubroVariable> valorrubrovariables,ValorRubroVariableParameterReturnGeneral valorrubrovariableParameterGeneral)throws Exception {
		 try {	
			ValorRubroVariableParameterReturnGeneral valorrubrovariableReturnGeneral=new ValorRubroVariableParameterReturnGeneral();
	
			ValorRubroVariableLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,valorrubrovariables,valorrubrovariableParameterGeneral,valorrubrovariableReturnGeneral);
			
			return valorrubrovariableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public ValorRubroVariableParameterReturnGeneral procesarAccionValorRubroVariablesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<ValorRubroVariable> valorrubrovariables,ValorRubroVariableParameterReturnGeneral valorrubrovariableParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorRubroVariable.class.getSimpleName()+"-procesarAccionValorRubroVariablesWithConnection");connexion.begin();			
			
			ValorRubroVariableParameterReturnGeneral valorrubrovariableReturnGeneral=new ValorRubroVariableParameterReturnGeneral();
	
			ValorRubroVariableLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,valorrubrovariables,valorrubrovariableParameterGeneral,valorrubrovariableReturnGeneral);
			
			this.connexion.commit();
			
			return valorrubrovariableReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ValorRubroVariableParameterReturnGeneral procesarEventosValorRubroVariables(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ValorRubroVariable> valorrubrovariables,ValorRubroVariable valorrubrovariable,ValorRubroVariableParameterReturnGeneral valorrubrovariableParameterGeneral,Boolean isEsNuevoValorRubroVariable,ArrayList<Classe> clases)throws Exception {
		 try {	
			ValorRubroVariableParameterReturnGeneral valorrubrovariableReturnGeneral=new ValorRubroVariableParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				valorrubrovariableReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ValorRubroVariableLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,valorrubrovariables,valorrubrovariable,valorrubrovariableParameterGeneral,valorrubrovariableReturnGeneral,isEsNuevoValorRubroVariable,clases);
			
			return valorrubrovariableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public ValorRubroVariableParameterReturnGeneral procesarEventosValorRubroVariablesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<ValorRubroVariable> valorrubrovariables,ValorRubroVariable valorrubrovariable,ValorRubroVariableParameterReturnGeneral valorrubrovariableParameterGeneral,Boolean isEsNuevoValorRubroVariable,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorRubroVariable.class.getSimpleName()+"-procesarEventosValorRubroVariablesWithConnection");connexion.begin();			
			
			ValorRubroVariableParameterReturnGeneral valorrubrovariableReturnGeneral=new ValorRubroVariableParameterReturnGeneral();
	
			valorrubrovariableReturnGeneral.setValorRubroVariable(valorrubrovariable);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				valorrubrovariableReturnGeneral.setConRecargarPropiedades(true);
			}
			
			ValorRubroVariableLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,valorrubrovariables,valorrubrovariable,valorrubrovariableParameterGeneral,valorrubrovariableReturnGeneral,isEsNuevoValorRubroVariable,clases);
			
			this.connexion.commit();
			
			return valorrubrovariableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public ValorRubroVariableParameterReturnGeneral procesarImportacionValorRubroVariablesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,ValorRubroVariableParameterReturnGeneral valorrubrovariableParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorRubroVariable.class.getSimpleName()+"-procesarImportacionValorRubroVariablesWithConnection");connexion.begin();			
			
			ValorRubroVariableParameterReturnGeneral valorrubrovariableReturnGeneral=new ValorRubroVariableParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.valorrubrovariables=new ArrayList<ValorRubroVariable>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.valorrubrovariable=new ValorRubroVariable();
				
				
				if(conColumnasBase) {this.valorrubrovariable.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.valorrubrovariable.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.valorrubrovariable.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.valorrubrovariable.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.valorrubrovariables.add(this.valorrubrovariable);
			}
			
			this.saveValorRubroVariables();
			
			this.connexion.commit();
			
			valorrubrovariableReturnGeneral.setConRetornoEstaProcesado(true);
			valorrubrovariableReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return valorrubrovariableReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarValorRubroVariablesEliminados() throws Exception {				
		
		List<ValorRubroVariable> valorrubrovariablesAux= new ArrayList<ValorRubroVariable>();
		
		for(ValorRubroVariable valorrubrovariable:valorrubrovariables) {
			if(!valorrubrovariable.getIsDeleted()) {
				valorrubrovariablesAux.add(valorrubrovariable);
			}
		}
		
		valorrubrovariables=valorrubrovariablesAux;
	}
	
	public void quitarValorRubroVariablesNulos() throws Exception {				
		
		List<ValorRubroVariable> valorrubrovariablesAux= new ArrayList<ValorRubroVariable>();
		
		for(ValorRubroVariable valorrubrovariable : this.valorrubrovariables) {
			if(valorrubrovariable==null) {
				valorrubrovariablesAux.add(valorrubrovariable);
			}
		}
		
		//this.valorrubrovariables=valorrubrovariablesAux;
		
		this.valorrubrovariables.removeAll(valorrubrovariablesAux);
	}
	
	public void getSetVersionRowValorRubroVariableWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(valorrubrovariable.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((valorrubrovariable.getIsDeleted() || (valorrubrovariable.getIsChanged()&&!valorrubrovariable.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=valorrubrovariableDataAccess.getSetVersionRowValorRubroVariable(connexion,valorrubrovariable.getId());
				
				if(!valorrubrovariable.getVersionRow().equals(timestamp)) {	
					valorrubrovariable.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				valorrubrovariable.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowValorRubroVariable()throws Exception {	
		
		if(valorrubrovariable.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((valorrubrovariable.getIsDeleted() || (valorrubrovariable.getIsChanged()&&!valorrubrovariable.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=valorrubrovariableDataAccess.getSetVersionRowValorRubroVariable(connexion,valorrubrovariable.getId());
			
			try {							
				if(!valorrubrovariable.getVersionRow().equals(timestamp)) {	
					valorrubrovariable.setVersionRow(timestamp);
				}
				
				valorrubrovariable.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowValorRubroVariablesWithConnection()throws Exception {	
		if(valorrubrovariables!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(ValorRubroVariable valorrubrovariableAux:valorrubrovariables) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(valorrubrovariableAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(valorrubrovariableAux.getIsDeleted() || (valorrubrovariableAux.getIsChanged()&&!valorrubrovariableAux.getIsNew())) {
						
						timestamp=valorrubrovariableDataAccess.getSetVersionRowValorRubroVariable(connexion,valorrubrovariableAux.getId());
						
						if(!valorrubrovariable.getVersionRow().equals(timestamp)) {	
							valorrubrovariableAux.setVersionRow(timestamp);
						}
								
						valorrubrovariableAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowValorRubroVariables()throws Exception {	
		if(valorrubrovariables!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(ValorRubroVariable valorrubrovariableAux:valorrubrovariables) {
					if(valorrubrovariableAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(valorrubrovariableAux.getIsDeleted() || (valorrubrovariableAux.getIsChanged()&&!valorrubrovariableAux.getIsNew())) {
						
						timestamp=valorrubrovariableDataAccess.getSetVersionRowValorRubroVariable(connexion,valorrubrovariableAux.getId());
						
						if(!valorrubrovariableAux.getVersionRow().equals(timestamp)) {	
							valorrubrovariableAux.setVersionRow(timestamp);
						}
						
													
						valorrubrovariableAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public ValorRubroVariableParameterReturnGeneral cargarCombosLoteForeignKeyValorRubroVariableWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalRubroEmplea) throws Exception {
		ValorRubroVariableParameterReturnGeneral  valorrubrovariableReturnGeneral =new ValorRubroVariableParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorRubroVariable.class.getSimpleName()+"-cargarCombosLoteForeignKeyValorRubroVariableWithConnection");connexion.begin();
			
			valorrubrovariableReturnGeneral =new ValorRubroVariableParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			valorrubrovariableReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			valorrubrovariableReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<RubroEmplea> rubroempleasForeignKey=new ArrayList<RubroEmplea>();
			RubroEmpleaLogic rubroempleaLogic=new RubroEmpleaLogic();
			rubroempleaLogic.setConnexion(this.connexion);
			rubroempleaLogic.getRubroEmpleaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRubroEmplea.equals("NONE")) {
				rubroempleaLogic.getTodosRubroEmpleas(finalQueryGlobalRubroEmplea,new Pagination());
				rubroempleasForeignKey=rubroempleaLogic.getRubroEmpleas();
			}

			valorrubrovariableReturnGeneral.setrubroempleasForeignKey(rubroempleasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return valorrubrovariableReturnGeneral;
	}
	
	public ValorRubroVariableParameterReturnGeneral cargarCombosLoteForeignKeyValorRubroVariable(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalRubroEmplea) throws Exception {
		ValorRubroVariableParameterReturnGeneral  valorrubrovariableReturnGeneral =new ValorRubroVariableParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			valorrubrovariableReturnGeneral =new ValorRubroVariableParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			valorrubrovariableReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			valorrubrovariableReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<RubroEmplea> rubroempleasForeignKey=new ArrayList<RubroEmplea>();
			RubroEmpleaLogic rubroempleaLogic=new RubroEmpleaLogic();
			rubroempleaLogic.setConnexion(this.connexion);
			rubroempleaLogic.getRubroEmpleaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalRubroEmplea.equals("NONE")) {
				rubroempleaLogic.getTodosRubroEmpleas(finalQueryGlobalRubroEmplea,new Pagination());
				rubroempleasForeignKey=rubroempleaLogic.getRubroEmpleas();
			}

			valorrubrovariableReturnGeneral.setrubroempleasForeignKey(rubroempleasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return valorrubrovariableReturnGeneral;
	}
	
	
	public void deepLoad(ValorRubroVariable valorrubrovariable,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			ValorRubroVariableLogicAdditional.updateValorRubroVariableToGet(valorrubrovariable,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		valorrubrovariable.setEmpresa(valorrubrovariableDataAccess.getEmpresa(connexion,valorrubrovariable));
		valorrubrovariable.setEmpleado(valorrubrovariableDataAccess.getEmpleado(connexion,valorrubrovariable));
		valorrubrovariable.setRubroEmplea(valorrubrovariableDataAccess.getRubroEmplea(connexion,valorrubrovariable));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				valorrubrovariable.setEmpresa(valorrubrovariableDataAccess.getEmpresa(connexion,valorrubrovariable));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				valorrubrovariable.setEmpleado(valorrubrovariableDataAccess.getEmpleado(connexion,valorrubrovariable));
				continue;
			}

			if(clas.clas.equals(RubroEmplea.class)) {
				valorrubrovariable.setRubroEmplea(valorrubrovariableDataAccess.getRubroEmplea(connexion,valorrubrovariable));
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
			valorrubrovariable.setEmpresa(valorrubrovariableDataAccess.getEmpresa(connexion,valorrubrovariable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			valorrubrovariable.setEmpleado(valorrubrovariableDataAccess.getEmpleado(connexion,valorrubrovariable));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(RubroEmplea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			valorrubrovariable.setRubroEmplea(valorrubrovariableDataAccess.getRubroEmplea(connexion,valorrubrovariable));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		valorrubrovariable.setEmpresa(valorrubrovariableDataAccess.getEmpresa(connexion,valorrubrovariable));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(valorrubrovariable.getEmpresa(),isDeep,deepLoadType,clases);
				
		valorrubrovariable.setEmpleado(valorrubrovariableDataAccess.getEmpleado(connexion,valorrubrovariable));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(valorrubrovariable.getEmpleado(),isDeep,deepLoadType,clases);
				
		valorrubrovariable.setRubroEmplea(valorrubrovariableDataAccess.getRubroEmplea(connexion,valorrubrovariable));
		RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
		rubroempleaLogic.deepLoad(valorrubrovariable.getRubroEmplea(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				valorrubrovariable.setEmpresa(valorrubrovariableDataAccess.getEmpresa(connexion,valorrubrovariable));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(valorrubrovariable.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				valorrubrovariable.setEmpleado(valorrubrovariableDataAccess.getEmpleado(connexion,valorrubrovariable));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(valorrubrovariable.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(RubroEmplea.class)) {
				valorrubrovariable.setRubroEmplea(valorrubrovariableDataAccess.getRubroEmplea(connexion,valorrubrovariable));
				RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
				rubroempleaLogic.deepLoad(valorrubrovariable.getRubroEmplea(),isDeep,deepLoadType,clases);				
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
			valorrubrovariable.setEmpresa(valorrubrovariableDataAccess.getEmpresa(connexion,valorrubrovariable));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(valorrubrovariable.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			valorrubrovariable.setEmpleado(valorrubrovariableDataAccess.getEmpleado(connexion,valorrubrovariable));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(valorrubrovariable.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(RubroEmplea.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			valorrubrovariable.setRubroEmplea(valorrubrovariableDataAccess.getRubroEmplea(connexion,valorrubrovariable));
			RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
			rubroempleaLogic.deepLoad(valorrubrovariable.getRubroEmplea(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(ValorRubroVariable valorrubrovariable,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			ValorRubroVariableLogicAdditional.updateValorRubroVariableToSave(valorrubrovariable,this.arrDatoGeneral);
			
ValorRubroVariableDataAccess.save(valorrubrovariable, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(valorrubrovariable.getEmpresa(),connexion);

		EmpleadoDataAccess.save(valorrubrovariable.getEmpleado(),connexion);

		RubroEmpleaDataAccess.save(valorrubrovariable.getRubroEmplea(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(valorrubrovariable.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(valorrubrovariable.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(RubroEmplea.class)) {
				RubroEmpleaDataAccess.save(valorrubrovariable.getRubroEmplea(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(valorrubrovariable.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(valorrubrovariable.getEmpresa(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(valorrubrovariable.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(valorrubrovariable.getEmpleado(),isDeep,deepLoadType,clases);
				

		RubroEmpleaDataAccess.save(valorrubrovariable.getRubroEmplea(),connexion);
		RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
		rubroempleaLogic.deepLoad(valorrubrovariable.getRubroEmplea(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(valorrubrovariable.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(valorrubrovariable.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(valorrubrovariable.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(valorrubrovariable.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(RubroEmplea.class)) {
				RubroEmpleaDataAccess.save(valorrubrovariable.getRubroEmplea(),connexion);
				RubroEmpleaLogic rubroempleaLogic= new RubroEmpleaLogic(connexion);
				rubroempleaLogic.deepSave(valorrubrovariable.getRubroEmplea(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(ValorRubroVariable.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(valorrubrovariable,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ValorRubroVariableConstantesFunciones.refrescarForeignKeysDescripcionesValorRubroVariable(valorrubrovariable);
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
			this.deepLoad(this.valorrubrovariable,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				ValorRubroVariableConstantesFunciones.refrescarForeignKeysDescripcionesValorRubroVariable(this.valorrubrovariable);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(ValorRubroVariable.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(valorrubrovariables!=null) {
				for(ValorRubroVariable valorrubrovariable:valorrubrovariables) {
					this.deepLoad(valorrubrovariable,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					ValorRubroVariableConstantesFunciones.refrescarForeignKeysDescripcionesValorRubroVariable(valorrubrovariables);
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
			if(valorrubrovariables!=null) {
				for(ValorRubroVariable valorrubrovariable:valorrubrovariables) {
					this.deepLoad(valorrubrovariable,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					ValorRubroVariableConstantesFunciones.refrescarForeignKeysDescripcionesValorRubroVariable(valorrubrovariables);
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
			this.getNewConnexionToDeep(ValorRubroVariable.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(valorrubrovariable,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(ValorRubroVariable.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(valorrubrovariables!=null) {
				for(ValorRubroVariable valorrubrovariable:valorrubrovariables) {
					this.deepSave(valorrubrovariable,isDeep,deepLoadType,clases);
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
			if(valorrubrovariables!=null) {
				for(ValorRubroVariable valorrubrovariable:valorrubrovariables) {
					this.deepSave(valorrubrovariable,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getValorRubroVariablesFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorRubroVariable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,ValorRubroVariableConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			ValorRubroVariableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			valorrubrovariables=valorrubrovariableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ValorRubroVariableConstantesFunciones.refrescarForeignKeysDescripcionesValorRubroVariable(this.valorrubrovariables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getValorRubroVariablesFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,ValorRubroVariableConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			ValorRubroVariableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			valorrubrovariables=valorrubrovariableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ValorRubroVariableConstantesFunciones.refrescarForeignKeysDescripcionesValorRubroVariable(this.valorrubrovariables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getValorRubroVariablesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorRubroVariable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ValorRubroVariableConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ValorRubroVariableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			valorrubrovariables=valorrubrovariableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ValorRubroVariableConstantesFunciones.refrescarForeignKeysDescripcionesValorRubroVariable(this.valorrubrovariables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getValorRubroVariablesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,ValorRubroVariableConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ValorRubroVariableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			valorrubrovariables=valorrubrovariableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ValorRubroVariableConstantesFunciones.refrescarForeignKeysDescripcionesValorRubroVariable(this.valorrubrovariables);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getValorRubroVariablesFK_IdRubroEmpleaWithConnection(String sFinalQuery,Pagination pagination,Long id_rubro_emplea)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,ValorRubroVariable.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRubroEmplea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRubroEmplea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_rubro_emplea,ValorRubroVariableConstantesFunciones.IDRUBROEMPLEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRubroEmplea);

			ValorRubroVariableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRubroEmplea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			valorrubrovariables=valorrubrovariableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ValorRubroVariableConstantesFunciones.refrescarForeignKeysDescripcionesValorRubroVariable(this.valorrubrovariables);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getValorRubroVariablesFK_IdRubroEmplea(String sFinalQuery,Pagination pagination,Long id_rubro_emplea)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidRubroEmplea= new ParameterSelectionGeneral();
			parameterSelectionGeneralidRubroEmplea.setParameterSelectionGeneralEqual(ParameterType.LONG,id_rubro_emplea,ValorRubroVariableConstantesFunciones.IDRUBROEMPLEA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidRubroEmplea);

			ValorRubroVariableLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdRubroEmplea","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			valorrubrovariables=valorrubrovariableDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				ValorRubroVariableConstantesFunciones.refrescarForeignKeysDescripcionesValorRubroVariable(this.valorrubrovariables);
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
			if(ValorRubroVariableConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,ValorRubroVariableDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,ValorRubroVariable valorrubrovariable,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(ValorRubroVariableConstantesFunciones.ISCONAUDITORIA) {
				if(valorrubrovariable.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ValorRubroVariableDataAccess.TABLENAME, valorrubrovariable.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ValorRubroVariableConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ValorRubroVariableLogic.registrarAuditoriaDetallesValorRubroVariable(connexion,valorrubrovariable,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(valorrubrovariable.getIsDeleted()) {
					/*if(!valorrubrovariable.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,ValorRubroVariableDataAccess.TABLENAME, valorrubrovariable.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////ValorRubroVariableLogic.registrarAuditoriaDetallesValorRubroVariable(connexion,valorrubrovariable,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ValorRubroVariableDataAccess.TABLENAME, valorrubrovariable.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(valorrubrovariable.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,ValorRubroVariableDataAccess.TABLENAME, valorrubrovariable.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(ValorRubroVariableConstantesFunciones.ISCONAUDITORIADETALLE) {
						////ValorRubroVariableLogic.registrarAuditoriaDetallesValorRubroVariable(connexion,valorrubrovariable,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesValorRubroVariable(Connexion connexion,ValorRubroVariable valorrubrovariable)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(valorrubrovariable.getIsNew()||!valorrubrovariable.getid_empresa().equals(valorrubrovariable.getValorRubroVariableOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(valorrubrovariable.getValorRubroVariableOriginal().getid_empresa()!=null)
				{
					strValorActual=valorrubrovariable.getValorRubroVariableOriginal().getid_empresa().toString();
				}
				if(valorrubrovariable.getid_empresa()!=null)
				{
					strValorNuevo=valorrubrovariable.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ValorRubroVariableConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(valorrubrovariable.getIsNew()||!valorrubrovariable.getid_empleado().equals(valorrubrovariable.getValorRubroVariableOriginal().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(valorrubrovariable.getValorRubroVariableOriginal().getid_empleado()!=null)
				{
					strValorActual=valorrubrovariable.getValorRubroVariableOriginal().getid_empleado().toString();
				}
				if(valorrubrovariable.getid_empleado()!=null)
				{
					strValorNuevo=valorrubrovariable.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ValorRubroVariableConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(valorrubrovariable.getIsNew()||!valorrubrovariable.getid_rubro_emplea().equals(valorrubrovariable.getValorRubroVariableOriginal().getid_rubro_emplea()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(valorrubrovariable.getValorRubroVariableOriginal().getid_rubro_emplea()!=null)
				{
					strValorActual=valorrubrovariable.getValorRubroVariableOriginal().getid_rubro_emplea().toString();
				}
				if(valorrubrovariable.getid_rubro_emplea()!=null)
				{
					strValorNuevo=valorrubrovariable.getid_rubro_emplea().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ValorRubroVariableConstantesFunciones.IDRUBROEMPLEA,strValorActual,strValorNuevo);
			}	
			
			if(valorrubrovariable.getIsNew()||!valorrubrovariable.getfecha().equals(valorrubrovariable.getValorRubroVariableOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(valorrubrovariable.getValorRubroVariableOriginal().getfecha()!=null)
				{
					strValorActual=valorrubrovariable.getValorRubroVariableOriginal().getfecha().toString();
				}
				if(valorrubrovariable.getfecha()!=null)
				{
					strValorNuevo=valorrubrovariable.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ValorRubroVariableConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(valorrubrovariable.getIsNew()||!valorrubrovariable.getvalor().equals(valorrubrovariable.getValorRubroVariableOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(valorrubrovariable.getValorRubroVariableOriginal().getvalor()!=null)
				{
					strValorActual=valorrubrovariable.getValorRubroVariableOriginal().getvalor().toString();
				}
				if(valorrubrovariable.getvalor()!=null)
				{
					strValorNuevo=valorrubrovariable.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),ValorRubroVariableConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveValorRubroVariableRelacionesWithConnection(ValorRubroVariable valorrubrovariable) throws Exception {

		if(!valorrubrovariable.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveValorRubroVariableRelacionesBase(valorrubrovariable,true);
		}
	}

	public void saveValorRubroVariableRelaciones(ValorRubroVariable valorrubrovariable)throws Exception {

		if(!valorrubrovariable.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveValorRubroVariableRelacionesBase(valorrubrovariable,false);
		}
	}

	public void saveValorRubroVariableRelacionesBase(ValorRubroVariable valorrubrovariable,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("ValorRubroVariable-saveRelacionesWithConnection");}
	

			this.setValorRubroVariable(valorrubrovariable);

			if(ValorRubroVariableLogicAdditional.validarSaveRelaciones(valorrubrovariable,this)) {

				ValorRubroVariableLogicAdditional.updateRelacionesToSave(valorrubrovariable,this);

				if((valorrubrovariable.getIsNew()||valorrubrovariable.getIsChanged())&&!valorrubrovariable.getIsDeleted()) {
					this.saveValorRubroVariable();
					this.saveValorRubroVariableRelacionesDetalles();

				} else if(valorrubrovariable.getIsDeleted()) {
					this.saveValorRubroVariableRelacionesDetalles();
					this.saveValorRubroVariable();
				}

				ValorRubroVariableLogicAdditional.updateRelacionesToSaveAfter(valorrubrovariable,this);

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
	
	
	private void saveValorRubroVariableRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfValorRubroVariable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ValorRubroVariableConstantesFunciones.getClassesForeignKeysOfValorRubroVariable(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfValorRubroVariable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=ValorRubroVariableConstantesFunciones.getClassesRelationshipsOfValorRubroVariable(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

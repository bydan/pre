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
package com.bydan.erp.puntoventa.business.logic;

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
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.puntoventa.util.FormulaConstantesFunciones;
import com.bydan.erp.puntoventa.util.FormulaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.FormulaParameterGeneral;
import com.bydan.erp.puntoventa.business.entity.Formula;
import com.bydan.erp.puntoventa.business.logic.FormulaLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.contabilidad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;








@SuppressWarnings("unused")
public class FormulaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(FormulaLogic.class);
	
	protected FormulaDataAccess formulaDataAccess; 	
	protected Formula formula;
	protected List<Formula> formulas;
	protected Object formulaObject;	
	protected List<Object> formulasObject;
	
	public static ClassValidator<Formula> formulaValidator = new ClassValidator<Formula>(Formula.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected FormulaLogicAdditional formulaLogicAdditional=null;
	
	public FormulaLogicAdditional getFormulaLogicAdditional() {
		return this.formulaLogicAdditional;
	}
	
	public void setFormulaLogicAdditional(FormulaLogicAdditional formulaLogicAdditional) {
		try {
			this.formulaLogicAdditional=formulaLogicAdditional;
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
	
	
	
	
	public  FormulaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.formulaDataAccess = new FormulaDataAccess();
			
			this.formulas= new ArrayList<Formula>();
			this.formula= new Formula();
			
			this.formulaObject=new Object();
			this.formulasObject=new ArrayList<Object>();
				
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
			
			this.formulaDataAccess.setConnexionType(this.connexionType);
			this.formulaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  FormulaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.formulaDataAccess = new FormulaDataAccess();
			this.formulas= new ArrayList<Formula>();
			this.formula= new Formula();
			this.formulaObject=new Object();
			this.formulasObject=new ArrayList<Object>();
			
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
			
			this.formulaDataAccess.setConnexionType(this.connexionType);
			this.formulaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public Formula getFormula() throws Exception {	
		FormulaLogicAdditional.checkFormulaToGet(formula,this.datosCliente,this.arrDatoGeneral);
		FormulaLogicAdditional.updateFormulaToGet(formula,this.arrDatoGeneral);
		
		return formula;
	}
		
	public void setFormula(Formula newFormula) {
		this.formula = newFormula;
	}
	
	public FormulaDataAccess getFormulaDataAccess() {
		return formulaDataAccess;
	}
	
	public void setFormulaDataAccess(FormulaDataAccess newformulaDataAccess) {
		this.formulaDataAccess = newformulaDataAccess;
	}
	
	public List<Formula> getFormulas() throws Exception {		
		this.quitarFormulasNulos();
		
		FormulaLogicAdditional.checkFormulaToGets(formulas,this.datosCliente,this.arrDatoGeneral);
		
		for (Formula formulaLocal: formulas ) {
			FormulaLogicAdditional.updateFormulaToGet(formulaLocal,this.arrDatoGeneral);
		}
		
		return formulas;
	}
	
	public void setFormulas(List<Formula> newFormulas) {
		this.formulas = newFormulas;
	}
	
	public Object getFormulaObject() {	
		this.formulaObject=this.formulaDataAccess.getEntityObject();
		return this.formulaObject;
	}
		
	public void setFormulaObject(Object newFormulaObject) {
		this.formulaObject = newFormulaObject;
	}
	
	public List<Object> getFormulasObject() {		
		this.formulasObject=this.formulaDataAccess.getEntitiesObject();
		return this.formulasObject;
	}
		
	public void setFormulasObject(List<Object> newFormulasObject) {
		this.formulasObject = newFormulasObject;
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
		
		if(this.formulaDataAccess!=null) {
			this.formulaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Formula.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			formulaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			formulaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		formula = new  Formula();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Formula.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			formula=formulaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formula,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormulaConstantesFunciones.refrescarForeignKeysDescripcionesFormula(this.formula);
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
		formula = new  Formula();
		  		  
        try {
			
			formula=formulaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formula,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormulaConstantesFunciones.refrescarForeignKeysDescripcionesFormula(this.formula);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		formula = new  Formula();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Formula.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			formula=formulaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formula,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormulaConstantesFunciones.refrescarForeignKeysDescripcionesFormula(this.formula);
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
		formula = new  Formula();
		  		  
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
		formula = new  Formula();
		  		  
        try {
			
			formula=formulaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formula,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormulaConstantesFunciones.refrescarForeignKeysDescripcionesFormula(this.formula);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		formula = new  Formula();
		  		  
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
		formula = new  Formula();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Formula.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =formulaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		formula = new  Formula();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=formulaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		formula = new  Formula();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Formula.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =formulaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		formula = new  Formula();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=formulaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		formula = new  Formula();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Formula.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =formulaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		formula = new  Formula();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=formulaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		formulas = new  ArrayList<Formula>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Formula.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			FormulaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulas=formulaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormula(formulas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormulaConstantesFunciones.refrescarForeignKeysDescripcionesFormula(this.formulas);
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
		formulas = new  ArrayList<Formula>();
		  		  
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
		formulas = new  ArrayList<Formula>();
		  		  
        try {			
			FormulaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulas=formulaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarFormula(formulas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormulaConstantesFunciones.refrescarForeignKeysDescripcionesFormula(this.formulas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		formulas = new  ArrayList<Formula>();
		  		  
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
		formulas = new  ArrayList<Formula>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Formula.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			FormulaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulas=formulaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormula(formulas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormulaConstantesFunciones.refrescarForeignKeysDescripcionesFormula(this.formulas);
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
		formulas = new  ArrayList<Formula>();
		  		  
        try {
			FormulaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulas=formulaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormula(formulas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormulaConstantesFunciones.refrescarForeignKeysDescripcionesFormula(this.formulas);
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
		formulas = new  ArrayList<Formula>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Formula.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormulaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulas=formulaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormula(formulas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormulaConstantesFunciones.refrescarForeignKeysDescripcionesFormula(this.formulas);
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
		formulas = new  ArrayList<Formula>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormulaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulas=formulaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormula(formulas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormulaConstantesFunciones.refrescarForeignKeysDescripcionesFormula(this.formulas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		formula = new  Formula();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Formula.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormulaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formula=formulaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormula(formula);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormulaConstantesFunciones.refrescarForeignKeysDescripcionesFormula(this.formula);
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
		formula = new  Formula();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormulaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formula=formulaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormula(formula);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormulaConstantesFunciones.refrescarForeignKeysDescripcionesFormula(this.formula);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		formulas = new  ArrayList<Formula>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Formula.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			FormulaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulas=formulaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormula(formulas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormulaConstantesFunciones.refrescarForeignKeysDescripcionesFormula(this.formulas);
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
		formulas = new  ArrayList<Formula>();
		  		  
        try {
			FormulaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulas=formulaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormula(formulas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormulaConstantesFunciones.refrescarForeignKeysDescripcionesFormula(this.formulas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosFormulasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		formulas = new  ArrayList<Formula>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Formula.class.getSimpleName()+"-getTodosFormulasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormulaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulas=formulaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFormula(formulas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormulaConstantesFunciones.refrescarForeignKeysDescripcionesFormula(this.formulas);
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
	
	public  void  getTodosFormulas(String sFinalQuery,Pagination pagination)throws Exception {
		formulas = new  ArrayList<Formula>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormulaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulas=formulaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFormula(formulas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormulaConstantesFunciones.refrescarForeignKeysDescripcionesFormula(this.formulas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarFormula(Formula formula) throws Exception {
		Boolean estaValidado=false;
		
		if(formula.getIsNew() || formula.getIsChanged()) { 
			this.invalidValues = formulaValidator.getInvalidValues(formula);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(formula);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarFormula(List<Formula> Formulas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(Formula formulaLocal:formulas) {				
			estaValidadoObjeto=this.validarGuardarFormula(formulaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarFormula(List<Formula> Formulas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFormula(formulas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarFormula(Formula Formula) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFormula(formula)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(Formula formula) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+formula.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=FormulaConstantesFunciones.getFormulaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"formula","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(FormulaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(FormulaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveFormulaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Formula.class.getSimpleName()+"-saveFormulaWithConnection");connexion.begin();			
			
			FormulaLogicAdditional.checkFormulaToSave(this.formula,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FormulaLogicAdditional.updateFormulaToSave(this.formula,this.arrDatoGeneral);
			
			FormulaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.formula,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowFormula();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFormula(this.formula)) {
				FormulaDataAccess.save(this.formula, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.formula,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FormulaLogicAdditional.checkFormulaToSaveAfter(this.formula,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFormula();
			
			connexion.commit();			
			
			if(this.formula.getIsDeleted()) {
				this.formula=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveFormula()throws Exception {	
		try {	
			
			FormulaLogicAdditional.checkFormulaToSave(this.formula,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FormulaLogicAdditional.updateFormulaToSave(this.formula,this.arrDatoGeneral);
			
			FormulaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.formula,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFormula(this.formula)) {			
				FormulaDataAccess.save(this.formula, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.formula,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FormulaLogicAdditional.checkFormulaToSaveAfter(this.formula,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.formula.getIsDeleted()) {
				this.formula=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveFormulasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Formula.class.getSimpleName()+"-saveFormulasWithConnection");connexion.begin();			
			
			FormulaLogicAdditional.checkFormulaToSaves(formulas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowFormulas();
			
			Boolean validadoTodosFormula=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Formula formulaLocal:formulas) {		
				if(formulaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FormulaLogicAdditional.updateFormulaToSave(formulaLocal,this.arrDatoGeneral);
	        	
				FormulaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),formulaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFormula(formulaLocal)) {
					FormulaDataAccess.save(formulaLocal, connexion);				
				} else {
					validadoTodosFormula=false;
				}
			}
			
			if(!validadoTodosFormula) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FormulaLogicAdditional.checkFormulaToSavesAfter(formulas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFormulas();
			
			connexion.commit();		
			
			this.quitarFormulasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveFormulas()throws Exception {				
		 try {	
			FormulaLogicAdditional.checkFormulaToSaves(formulas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosFormula=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(Formula formulaLocal:formulas) {				
				if(formulaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FormulaLogicAdditional.updateFormulaToSave(formulaLocal,this.arrDatoGeneral);
	        	
				FormulaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),formulaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFormula(formulaLocal)) {				
					FormulaDataAccess.save(formulaLocal, connexion);				
				} else {
					validadoTodosFormula=false;
				}
			}
			
			if(!validadoTodosFormula) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FormulaLogicAdditional.checkFormulaToSavesAfter(formulas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarFormulasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FormulaParameterReturnGeneral procesarAccionFormulas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Formula> formulas,FormulaParameterReturnGeneral formulaParameterGeneral)throws Exception {
		 try {	
			FormulaParameterReturnGeneral formulaReturnGeneral=new FormulaParameterReturnGeneral();
	
			FormulaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,formulas,formulaParameterGeneral,formulaReturnGeneral);
			
			return formulaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FormulaParameterReturnGeneral procesarAccionFormulasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<Formula> formulas,FormulaParameterReturnGeneral formulaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Formula.class.getSimpleName()+"-procesarAccionFormulasWithConnection");connexion.begin();			
			
			FormulaParameterReturnGeneral formulaReturnGeneral=new FormulaParameterReturnGeneral();
	
			FormulaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,formulas,formulaParameterGeneral,formulaReturnGeneral);
			
			this.connexion.commit();
			
			return formulaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FormulaParameterReturnGeneral procesarEventosFormulas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Formula> formulas,Formula formula,FormulaParameterReturnGeneral formulaParameterGeneral,Boolean isEsNuevoFormula,ArrayList<Classe> clases)throws Exception {
		 try {	
			FormulaParameterReturnGeneral formulaReturnGeneral=new FormulaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				formulaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FormulaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,formulas,formula,formulaParameterGeneral,formulaReturnGeneral,isEsNuevoFormula,clases);
			
			return formulaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public FormulaParameterReturnGeneral procesarEventosFormulasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<Formula> formulas,Formula formula,FormulaParameterReturnGeneral formulaParameterGeneral,Boolean isEsNuevoFormula,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Formula.class.getSimpleName()+"-procesarEventosFormulasWithConnection");connexion.begin();			
			
			FormulaParameterReturnGeneral formulaReturnGeneral=new FormulaParameterReturnGeneral();
	
			formulaReturnGeneral.setFormula(formula);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				formulaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FormulaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,formulas,formula,formulaParameterGeneral,formulaReturnGeneral,isEsNuevoFormula,clases);
			
			this.connexion.commit();
			
			return formulaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FormulaParameterReturnGeneral procesarImportacionFormulasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,FormulaParameterReturnGeneral formulaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Formula.class.getSimpleName()+"-procesarImportacionFormulasWithConnection");connexion.begin();			
			
			FormulaParameterReturnGeneral formulaReturnGeneral=new FormulaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.formulas=new ArrayList<Formula>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.formula=new Formula();
				
				
				if(conColumnasBase) {this.formula.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.formula.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.formula.setcodigo(arrColumnas[iColumn++]);
				this.formula.setnombre(arrColumnas[iColumn++]);
				this.formula.setalias(arrColumnas[iColumn++]);
				this.formula.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				this.formula.setformula1(arrColumnas[iColumn++]);
				
				this.formulas.add(this.formula);
			}
			
			this.saveFormulas();
			
			this.connexion.commit();
			
			formulaReturnGeneral.setConRetornoEstaProcesado(true);
			formulaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return formulaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarFormulasEliminados() throws Exception {				
		
		List<Formula> formulasAux= new ArrayList<Formula>();
		
		for(Formula formula:formulas) {
			if(!formula.getIsDeleted()) {
				formulasAux.add(formula);
			}
		}
		
		formulas=formulasAux;
	}
	
	public void quitarFormulasNulos() throws Exception {				
		
		List<Formula> formulasAux= new ArrayList<Formula>();
		
		for(Formula formula : this.formulas) {
			if(formula==null) {
				formulasAux.add(formula);
			}
		}
		
		//this.formulas=formulasAux;
		
		this.formulas.removeAll(formulasAux);
	}
	
	public void getSetVersionRowFormulaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(formula.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((formula.getIsDeleted() || (formula.getIsChanged()&&!formula.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=formulaDataAccess.getSetVersionRowFormula(connexion,formula.getId());
				
				if(!formula.getVersionRow().equals(timestamp)) {	
					formula.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				formula.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowFormula()throws Exception {	
		
		if(formula.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((formula.getIsDeleted() || (formula.getIsChanged()&&!formula.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=formulaDataAccess.getSetVersionRowFormula(connexion,formula.getId());
			
			try {							
				if(!formula.getVersionRow().equals(timestamp)) {	
					formula.setVersionRow(timestamp);
				}
				
				formula.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowFormulasWithConnection()throws Exception {	
		if(formulas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(Formula formulaAux:formulas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(formulaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(formulaAux.getIsDeleted() || (formulaAux.getIsChanged()&&!formulaAux.getIsNew())) {
						
						timestamp=formulaDataAccess.getSetVersionRowFormula(connexion,formulaAux.getId());
						
						if(!formula.getVersionRow().equals(timestamp)) {	
							formulaAux.setVersionRow(timestamp);
						}
								
						formulaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowFormulas()throws Exception {	
		if(formulas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(Formula formulaAux:formulas) {
					if(formulaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(formulaAux.getIsDeleted() || (formulaAux.getIsChanged()&&!formulaAux.getIsNew())) {
						
						timestamp=formulaDataAccess.getSetVersionRowFormula(connexion,formulaAux.getId());
						
						if(!formulaAux.getVersionRow().equals(timestamp)) {	
							formulaAux.setVersionRow(timestamp);
						}
						
													
						formulaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public FormulaParameterReturnGeneral cargarCombosLoteForeignKeyFormulaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoFormula) throws Exception {
		FormulaParameterReturnGeneral  formulaReturnGeneral =new FormulaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Formula.class.getSimpleName()+"-cargarCombosLoteForeignKeyFormulaWithConnection");connexion.begin();
			
			formulaReturnGeneral =new FormulaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			formulaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoFormula> tipoformulasForeignKey=new ArrayList<TipoFormula>();
			TipoFormulaLogic tipoformulaLogic=new TipoFormulaLogic();
			tipoformulaLogic.setConnexion(this.connexion);
			tipoformulaLogic.getTipoFormulaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoFormula.equals("NONE")) {
				tipoformulaLogic.getTodosTipoFormulas(finalQueryGlobalTipoFormula,new Pagination());
				tipoformulasForeignKey=tipoformulaLogic.getTipoFormulas();
			}

			formulaReturnGeneral.settipoformulasForeignKey(tipoformulasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return formulaReturnGeneral;
	}
	
	public FormulaParameterReturnGeneral cargarCombosLoteForeignKeyFormula(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoFormula) throws Exception {
		FormulaParameterReturnGeneral  formulaReturnGeneral =new FormulaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			formulaReturnGeneral =new FormulaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			formulaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoFormula> tipoformulasForeignKey=new ArrayList<TipoFormula>();
			TipoFormulaLogic tipoformulaLogic=new TipoFormulaLogic();
			tipoformulaLogic.setConnexion(this.connexion);
			tipoformulaLogic.getTipoFormulaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoFormula.equals("NONE")) {
				tipoformulaLogic.getTodosTipoFormulas(finalQueryGlobalTipoFormula,new Pagination());
				tipoformulasForeignKey=tipoformulaLogic.getTipoFormulas();
			}

			formulaReturnGeneral.settipoformulasForeignKey(tipoformulasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return formulaReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyFormulaWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			TarjetaCreditoLogic tarjetacreditoLogic=new TarjetaCreditoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Formula.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyFormulaWithConnection");connexion.begin();
			
			
			classes.add(new Classe(TarjetaCredito.class));
											
			

			tarjetacreditoLogic.setConnexion(this.getConnexion());
			tarjetacreditoLogic.setDatosCliente(this.datosCliente);
			tarjetacreditoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(Formula formula:this.formulas) {
				

				classes=new ArrayList<Classe>();
				classes=TarjetaCreditoConstantesFunciones.getClassesForeignKeysOfTarjetaCredito(new ArrayList<Classe>(),DeepLoadType.NONE);

				tarjetacreditoLogic.setTarjetaCreditos(formula.tarjetacreditoComisions);
				tarjetacreditoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(Formula formula,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			FormulaLogicAdditional.updateFormulaToGet(formula,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		formula.setEmpresa(formulaDataAccess.getEmpresa(connexion,formula));
		formula.setTipoFormula(formulaDataAccess.getTipoFormula(connexion,formula));
		formula.setTarjetaCreditoComisions(formulaDataAccess.getTarjetaCreditoComisions(connexion,formula));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				formula.setEmpresa(formulaDataAccess.getEmpresa(connexion,formula));
				continue;
			}

			if(clas.clas.equals(TipoFormula.class)) {
				formula.setTipoFormula(formulaDataAccess.getTipoFormula(connexion,formula));
				continue;
			}

			if(clas.clas.equals(TarjetaCredito.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				formula.setTarjetaCreditoComisions(formulaDataAccess.getTarjetaCreditoComisions(connexion,formula));

				if(this.isConDeep) {
					TarjetaCreditoLogic tarjetacreditoLogic= new TarjetaCreditoLogic(this.connexion);
					tarjetacreditoLogic.setTarjetaCreditos(formula.getTarjetaCreditoComisions());
					ArrayList<Classe> classesLocal=TarjetaCreditoConstantesFunciones.getClassesForeignKeysOfTarjetaCredito(new ArrayList<Classe>(),DeepLoadType.NONE);
					tarjetacreditoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					TarjetaCreditoConstantesFunciones.refrescarForeignKeysDescripcionesTarjetaCredito(tarjetacreditoLogic.getTarjetaCreditos());
					formula.setTarjetaCreditoComisions(tarjetacreditoLogic.getTarjetaCreditos());
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
			formula.setEmpresa(formulaDataAccess.getEmpresa(connexion,formula));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFormula.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formula.setTipoFormula(formulaDataAccess.getTipoFormula(connexion,formula));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TarjetaCredito.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TarjetaCredito.class));
			formula.setTarjetaCreditoComisions(formulaDataAccess.getTarjetaCreditoComisions(connexion,formula));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		formula.setEmpresa(formulaDataAccess.getEmpresa(connexion,formula));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(formula.getEmpresa(),isDeep,deepLoadType,clases);
				
		formula.setTipoFormula(formulaDataAccess.getTipoFormula(connexion,formula));
		TipoFormulaLogic tipoformulaLogic= new TipoFormulaLogic(connexion);
		tipoformulaLogic.deepLoad(formula.getTipoFormula(),isDeep,deepLoadType,clases);
				

		formula.setTarjetaCreditoComisions(formulaDataAccess.getTarjetaCreditoComisions(connexion,formula));

		for(TarjetaCredito tarjetacredito:formula.getTarjetaCreditoComisions()) {
			TarjetaCreditoLogic tarjetacreditoLogic= new TarjetaCreditoLogic(connexion);
			tarjetacreditoLogic.deepLoad(tarjetacredito,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				formula.setEmpresa(formulaDataAccess.getEmpresa(connexion,formula));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(formula.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoFormula.class)) {
				formula.setTipoFormula(formulaDataAccess.getTipoFormula(connexion,formula));
				TipoFormulaLogic tipoformulaLogic= new TipoFormulaLogic(connexion);
				tipoformulaLogic.deepLoad(formula.getTipoFormula(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TarjetaCredito.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				formula.setTarjetaCreditoComisions(formulaDataAccess.getTarjetaCreditoComisions(connexion,formula));

				for(TarjetaCredito tarjetacredito:formula.getTarjetaCreditoComisions()) {
					TarjetaCreditoLogic tarjetacreditoLogic= new TarjetaCreditoLogic(connexion);
					tarjetacreditoLogic.deepLoad(tarjetacredito,isDeep,deepLoadType,clases);
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
			formula.setEmpresa(formulaDataAccess.getEmpresa(connexion,formula));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(formula.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFormula.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formula.setTipoFormula(formulaDataAccess.getTipoFormula(connexion,formula));
			TipoFormulaLogic tipoformulaLogic= new TipoFormulaLogic(connexion);
			tipoformulaLogic.deepLoad(formula.getTipoFormula(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TarjetaCredito.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(TarjetaCredito.class));
			formula.setTarjetaCreditoComisions(formulaDataAccess.getTarjetaCreditoComisions(connexion,formula));

			for(TarjetaCredito tarjetacredito:formula.getTarjetaCreditoComisions()) {
				TarjetaCreditoLogic tarjetacreditoLogic= new TarjetaCreditoLogic(connexion);
				tarjetacreditoLogic.deepLoad(tarjetacredito,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(Formula formula,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			FormulaLogicAdditional.updateFormulaToSave(formula,this.arrDatoGeneral);
			
FormulaDataAccess.save(formula, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(formula.getEmpresa(),connexion);

		TipoFormulaDataAccess.save(formula.getTipoFormula(),connexion);

		for(TarjetaCredito tarjetacredito:formula.getTarjetaCreditoComisions()) {
			tarjetacredito.setid_formula_comision(formula.getId());
			TarjetaCreditoDataAccess.save(tarjetacredito,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(formula.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoFormula.class)) {
				TipoFormulaDataAccess.save(formula.getTipoFormula(),connexion);
				continue;
			}


			if(clas.clas.equals(TarjetaCredito.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TarjetaCredito tarjetacredito:formula.getTarjetaCreditoComisions()) {
					tarjetacredito.setid_formula_comision(formula.getId());
					TarjetaCreditoDataAccess.save(tarjetacredito,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(formula.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(formula.getEmpresa(),isDeep,deepLoadType,clases);
				

		TipoFormulaDataAccess.save(formula.getTipoFormula(),connexion);
		TipoFormulaLogic tipoformulaLogic= new TipoFormulaLogic(connexion);
		tipoformulaLogic.deepLoad(formula.getTipoFormula(),isDeep,deepLoadType,clases);
				

		for(TarjetaCredito tarjetacredito:formula.getTarjetaCreditoComisions()) {
			TarjetaCreditoLogic tarjetacreditoLogic= new TarjetaCreditoLogic(connexion);
			tarjetacredito.setid_formula_comision(formula.getId());
			TarjetaCreditoDataAccess.save(tarjetacredito,connexion);
			tarjetacreditoLogic.deepSave(tarjetacredito,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(formula.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(formula.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoFormula.class)) {
				TipoFormulaDataAccess.save(formula.getTipoFormula(),connexion);
				TipoFormulaLogic tipoformulaLogic= new TipoFormulaLogic(connexion);
				tipoformulaLogic.deepSave(formula.getTipoFormula(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(TarjetaCredito.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(TarjetaCredito tarjetacredito:formula.getTarjetaCreditoComisions()) {
					TarjetaCreditoLogic tarjetacreditoLogic= new TarjetaCreditoLogic(connexion);
					tarjetacredito.setid_formula_comision(formula.getId());
					TarjetaCreditoDataAccess.save(tarjetacredito,connexion);
					tarjetacreditoLogic.deepSave(tarjetacredito,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(Formula.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(formula,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FormulaConstantesFunciones.refrescarForeignKeysDescripcionesFormula(formula);
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
			this.deepLoad(this.formula,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FormulaConstantesFunciones.refrescarForeignKeysDescripcionesFormula(this.formula);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(Formula.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(formulas!=null) {
				for(Formula formula:formulas) {
					this.deepLoad(formula,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					FormulaConstantesFunciones.refrescarForeignKeysDescripcionesFormula(formulas);
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
			if(formulas!=null) {
				for(Formula formula:formulas) {
					this.deepLoad(formula,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					FormulaConstantesFunciones.refrescarForeignKeysDescripcionesFormula(formulas);
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
			this.getNewConnexionToDeep(Formula.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(formula,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(Formula.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(formulas!=null) {
				for(Formula formula:formulas) {
					this.deepSave(formula,isDeep,deepLoadType,clases);
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
			if(formulas!=null) {
				for(Formula formula:formulas) {
					this.deepSave(formula,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getFormulasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Formula.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FormulaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FormulaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formulas=formulaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormulaConstantesFunciones.refrescarForeignKeysDescripcionesFormula(this.formulas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormulasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FormulaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FormulaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formulas=formulaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormulaConstantesFunciones.refrescarForeignKeysDescripcionesFormula(this.formulas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormulasFK_IdTipoFormulaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_formula)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,Formula.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoFormula= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoFormula.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_formula,FormulaConstantesFunciones.IDTIPOFORMULA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoFormula);

			FormulaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoFormula","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formulas=formulaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormulaConstantesFunciones.refrescarForeignKeysDescripcionesFormula(this.formulas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormulasFK_IdTipoFormula(String sFinalQuery,Pagination pagination,Long id_tipo_formula)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoFormula= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoFormula.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_formula,FormulaConstantesFunciones.IDTIPOFORMULA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoFormula);

			FormulaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoFormula","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formulas=formulaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormulaConstantesFunciones.refrescarForeignKeysDescripcionesFormula(this.formulas);
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
			if(FormulaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,FormulaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,Formula formula,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(FormulaConstantesFunciones.ISCONAUDITORIA) {
				if(formula.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FormulaDataAccess.TABLENAME, formula.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FormulaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FormulaLogic.registrarAuditoriaDetallesFormula(connexion,formula,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(formula.getIsDeleted()) {
					/*if(!formula.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,FormulaDataAccess.TABLENAME, formula.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////FormulaLogic.registrarAuditoriaDetallesFormula(connexion,formula,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FormulaDataAccess.TABLENAME, formula.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(formula.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FormulaDataAccess.TABLENAME, formula.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FormulaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FormulaLogic.registrarAuditoriaDetallesFormula(connexion,formula,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesFormula(Connexion connexion,Formula formula)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(formula.getIsNew()||!formula.getid_empresa().equals(formula.getFormulaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formula.getFormulaOriginal().getid_empresa()!=null)
				{
					strValorActual=formula.getFormulaOriginal().getid_empresa().toString();
				}
				if(formula.getid_empresa()!=null)
				{
					strValorNuevo=formula.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormulaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(formula.getIsNew()||!formula.getid_tipo_formula().equals(formula.getFormulaOriginal().getid_tipo_formula()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formula.getFormulaOriginal().getid_tipo_formula()!=null)
				{
					strValorActual=formula.getFormulaOriginal().getid_tipo_formula().toString();
				}
				if(formula.getid_tipo_formula()!=null)
				{
					strValorNuevo=formula.getid_tipo_formula().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormulaConstantesFunciones.IDTIPOFORMULA,strValorActual,strValorNuevo);
			}	
			
			if(formula.getIsNew()||!formula.getcodigo().equals(formula.getFormulaOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formula.getFormulaOriginal().getcodigo()!=null)
				{
					strValorActual=formula.getFormulaOriginal().getcodigo();
				}
				if(formula.getcodigo()!=null)
				{
					strValorNuevo=formula.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormulaConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(formula.getIsNew()||!formula.getnombre().equals(formula.getFormulaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formula.getFormulaOriginal().getnombre()!=null)
				{
					strValorActual=formula.getFormulaOriginal().getnombre();
				}
				if(formula.getnombre()!=null)
				{
					strValorNuevo=formula.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormulaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(formula.getIsNew()||!formula.getalias().equals(formula.getFormulaOriginal().getalias()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formula.getFormulaOriginal().getalias()!=null)
				{
					strValorActual=formula.getFormulaOriginal().getalias();
				}
				if(formula.getalias()!=null)
				{
					strValorNuevo=formula.getalias() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormulaConstantesFunciones.ALIAS,strValorActual,strValorNuevo);
			}	
			
			if(formula.getIsNew()||!formula.getvalor().equals(formula.getFormulaOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formula.getFormulaOriginal().getvalor()!=null)
				{
					strValorActual=formula.getFormulaOriginal().getvalor().toString();
				}
				if(formula.getvalor()!=null)
				{
					strValorNuevo=formula.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormulaConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
			
			if(formula.getIsNew()||!formula.getformula1().equals(formula.getFormulaOriginal().getformula1()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formula.getFormulaOriginal().getformula1()!=null)
				{
					strValorActual=formula.getFormulaOriginal().getformula1();
				}
				if(formula.getformula1()!=null)
				{
					strValorNuevo=formula.getformula1() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormulaConstantesFunciones.FORMULA1,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveFormulaRelacionesWithConnection(Formula formula,List<TarjetaCredito> tarjetacreditoComisions) throws Exception {

		if(!formula.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFormulaRelacionesBase(formula,tarjetacreditoComisions,true);
		}
	}

	public void saveFormulaRelaciones(Formula formula,List<TarjetaCredito> tarjetacreditoComisions)throws Exception {

		if(!formula.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFormulaRelacionesBase(formula,tarjetacreditoComisions,false);
		}
	}

	public void saveFormulaRelacionesBase(Formula formula,List<TarjetaCredito> tarjetacreditoComisions,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("Formula-saveRelacionesWithConnection");}
	
			formula.setTarjetaCreditoComisions(tarjetacreditoComisions);

			this.setFormula(formula);

			if(FormulaLogicAdditional.validarSaveRelaciones(formula,this)) {

				FormulaLogicAdditional.updateRelacionesToSave(formula,this);

				if((formula.getIsNew()||formula.getIsChanged())&&!formula.getIsDeleted()) {
					this.saveFormula();
					this.saveFormulaRelacionesDetalles(tarjetacreditoComisions);

				} else if(formula.getIsDeleted()) {
					this.saveFormulaRelacionesDetalles(tarjetacreditoComisions);
					this.saveFormula();
				}

				FormulaLogicAdditional.updateRelacionesToSaveAfter(formula,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			TarjetaCreditoConstantesFunciones.InicializarGeneralEntityAuxiliaresTarjetaCreditos(tarjetacreditoComisions,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveFormulaRelacionesDetalles(List<TarjetaCredito> tarjetacreditoComisions)throws Exception {
		try {
	

			Long idFormulaActual=this.getFormula().getId();

			TarjetaCreditoLogic tarjetacreditoComisionLogic_Desde_Formula=new TarjetaCreditoLogic();
			tarjetacreditoComisionLogic_Desde_Formula.setTarjetaCreditos(tarjetacreditoComisions);

			tarjetacreditoComisionLogic_Desde_Formula.setConnexion(this.getConnexion());
			tarjetacreditoComisionLogic_Desde_Formula.setDatosCliente(this.datosCliente);

			for(TarjetaCredito tarjetacredito_Desde_Formula:tarjetacreditoComisionLogic_Desde_Formula.getTarjetaCreditos()) {
				tarjetacredito_Desde_Formula.setid_formula_comision(idFormulaActual);

				tarjetacreditoComisionLogic_Desde_Formula.setTarjetaCredito(tarjetacredito_Desde_Formula);
				tarjetacreditoComisionLogic_Desde_Formula.saveTarjetaCredito();

				Long idTarjetaCreditoActual=tarjetacredito_Desde_Formula.getId();

				TarjetaCreditoConexionLogic tarjetacreditoconexionLogic_Desde_TarjetaCredito=new TarjetaCreditoConexionLogic();

				if(tarjetacredito_Desde_Formula.getTarjetaCreditoConexions()==null){
					tarjetacredito_Desde_Formula.setTarjetaCreditoConexions(new ArrayList<TarjetaCreditoConexion>());
				}

				tarjetacreditoconexionLogic_Desde_TarjetaCredito.setTarjetaCreditoConexions(tarjetacredito_Desde_Formula.getTarjetaCreditoConexions());

				tarjetacreditoconexionLogic_Desde_TarjetaCredito.setConnexion(this.getConnexion());
				tarjetacreditoconexionLogic_Desde_TarjetaCredito.setDatosCliente(this.datosCliente);

				for(TarjetaCreditoConexion tarjetacreditoconexion_Desde_TarjetaCredito:tarjetacreditoconexionLogic_Desde_TarjetaCredito.getTarjetaCreditoConexions()) {
					tarjetacreditoconexion_Desde_TarjetaCredito.setid_tarjeta_credito(idTarjetaCreditoActual);
				}

				tarjetacreditoconexionLogic_Desde_TarjetaCredito.saveTarjetaCreditoConexions();

				TarjetaCreditoDescuentoLogic tarjetacreditodescuentoLogic_Desde_TarjetaCredito=new TarjetaCreditoDescuentoLogic();

				if(tarjetacredito_Desde_Formula.getTarjetaCreditoDescuentos()==null){
					tarjetacredito_Desde_Formula.setTarjetaCreditoDescuentos(new ArrayList<TarjetaCreditoDescuento>());
				}

				tarjetacreditodescuentoLogic_Desde_TarjetaCredito.setTarjetaCreditoDescuentos(tarjetacredito_Desde_Formula.getTarjetaCreditoDescuentos());

				tarjetacreditodescuentoLogic_Desde_TarjetaCredito.setConnexion(this.getConnexion());
				tarjetacreditodescuentoLogic_Desde_TarjetaCredito.setDatosCliente(this.datosCliente);

				for(TarjetaCreditoDescuento tarjetacreditodescuento_Desde_TarjetaCredito:tarjetacreditodescuentoLogic_Desde_TarjetaCredito.getTarjetaCreditoDescuentos()) {
					tarjetacreditodescuento_Desde_TarjetaCredito.setid_tarjeta_credito(idTarjetaCreditoActual);
				}

				tarjetacreditodescuentoLogic_Desde_TarjetaCredito.saveTarjetaCreditoDescuentos();

				FormaPagoPuntoVentaLogic formapagopuntoventaLogic_Desde_TarjetaCredito=new FormaPagoPuntoVentaLogic();

				if(tarjetacredito_Desde_Formula.getFormaPagoPuntoVentas()==null){
					tarjetacredito_Desde_Formula.setFormaPagoPuntoVentas(new ArrayList<FormaPagoPuntoVenta>());
				}

				formapagopuntoventaLogic_Desde_TarjetaCredito.setFormaPagoPuntoVentas(tarjetacredito_Desde_Formula.getFormaPagoPuntoVentas());

				formapagopuntoventaLogic_Desde_TarjetaCredito.setConnexion(this.getConnexion());
				formapagopuntoventaLogic_Desde_TarjetaCredito.setDatosCliente(this.datosCliente);

				for(FormaPagoPuntoVenta formapagopuntoventa_Desde_TarjetaCredito:formapagopuntoventaLogic_Desde_TarjetaCredito.getFormaPagoPuntoVentas()) {
					formapagopuntoventa_Desde_TarjetaCredito.setid_tarjeta_credito(idTarjetaCreditoActual);
				}

				formapagopuntoventaLogic_Desde_TarjetaCredito.saveFormaPagoPuntoVentas();
			}


		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfFormula(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FormulaConstantesFunciones.getClassesForeignKeysOfFormula(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFormula(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FormulaConstantesFunciones.getClassesRelationshipsOfFormula(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

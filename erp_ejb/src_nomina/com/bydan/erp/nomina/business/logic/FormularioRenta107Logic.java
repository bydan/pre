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
import com.bydan.erp.nomina.util.FormularioRenta107ConstantesFunciones;
import com.bydan.erp.nomina.util.FormularioRenta107ParameterReturnGeneral;
//import com.bydan.erp.nomina.util.FormularioRenta107ParameterGeneral;
import com.bydan.erp.nomina.business.entity.FormularioRenta107;
import com.bydan.erp.nomina.business.logic.FormularioRenta107LogicAdditional;
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
public class FormularioRenta107Logic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(FormularioRenta107Logic.class);
	
	protected FormularioRenta107DataAccess formulariorenta107DataAccess; 	
	protected FormularioRenta107 formulariorenta107;
	protected List<FormularioRenta107> formulariorenta107s;
	protected Object formulariorenta107Object;	
	protected List<Object> formulariorenta107sObject;
	
	public static ClassValidator<FormularioRenta107> formulariorenta107Validator = new ClassValidator<FormularioRenta107>(FormularioRenta107.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected FormularioRenta107LogicAdditional formulariorenta107LogicAdditional=null;
	
	public FormularioRenta107LogicAdditional getFormularioRenta107LogicAdditional() {
		return this.formulariorenta107LogicAdditional;
	}
	
	public void setFormularioRenta107LogicAdditional(FormularioRenta107LogicAdditional formulariorenta107LogicAdditional) {
		try {
			this.formulariorenta107LogicAdditional=formulariorenta107LogicAdditional;
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
	
	
	
	
	public  FormularioRenta107Logic()throws SQLException,Exception {
		super();
		
		try	{						
			this.formulariorenta107DataAccess = new FormularioRenta107DataAccess();
			
			this.formulariorenta107s= new ArrayList<FormularioRenta107>();
			this.formulariorenta107= new FormularioRenta107();
			
			this.formulariorenta107Object=new Object();
			this.formulariorenta107sObject=new ArrayList<Object>();
				
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
			
			this.formulariorenta107DataAccess.setConnexionType(this.connexionType);
			this.formulariorenta107DataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  FormularioRenta107Logic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.formulariorenta107DataAccess = new FormularioRenta107DataAccess();
			this.formulariorenta107s= new ArrayList<FormularioRenta107>();
			this.formulariorenta107= new FormularioRenta107();
			this.formulariorenta107Object=new Object();
			this.formulariorenta107sObject=new ArrayList<Object>();
			
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
			
			this.formulariorenta107DataAccess.setConnexionType(this.connexionType);
			this.formulariorenta107DataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public FormularioRenta107 getFormularioRenta107() throws Exception {	
		FormularioRenta107LogicAdditional.checkFormularioRenta107ToGet(formulariorenta107,this.datosCliente,this.arrDatoGeneral);
		FormularioRenta107LogicAdditional.updateFormularioRenta107ToGet(formulariorenta107,this.arrDatoGeneral);
		
		return formulariorenta107;
	}
		
	public void setFormularioRenta107(FormularioRenta107 newFormularioRenta107) {
		this.formulariorenta107 = newFormularioRenta107;
	}
	
	public FormularioRenta107DataAccess getFormularioRenta107DataAccess() {
		return formulariorenta107DataAccess;
	}
	
	public void setFormularioRenta107DataAccess(FormularioRenta107DataAccess newformulariorenta107DataAccess) {
		this.formulariorenta107DataAccess = newformulariorenta107DataAccess;
	}
	
	public List<FormularioRenta107> getFormularioRenta107s() throws Exception {		
		this.quitarFormularioRenta107sNulos();
		
		FormularioRenta107LogicAdditional.checkFormularioRenta107ToGets(formulariorenta107s,this.datosCliente,this.arrDatoGeneral);
		
		for (FormularioRenta107 formulariorenta107Local: formulariorenta107s ) {
			FormularioRenta107LogicAdditional.updateFormularioRenta107ToGet(formulariorenta107Local,this.arrDatoGeneral);
		}
		
		return formulariorenta107s;
	}
	
	public void setFormularioRenta107s(List<FormularioRenta107> newFormularioRenta107s) {
		this.formulariorenta107s = newFormularioRenta107s;
	}
	
	public Object getFormularioRenta107Object() {	
		this.formulariorenta107Object=this.formulariorenta107DataAccess.getEntityObject();
		return this.formulariorenta107Object;
	}
		
	public void setFormularioRenta107Object(Object newFormularioRenta107Object) {
		this.formulariorenta107Object = newFormularioRenta107Object;
	}
	
	public List<Object> getFormularioRenta107sObject() {		
		this.formulariorenta107sObject=this.formulariorenta107DataAccess.getEntitiesObject();
		return this.formulariorenta107sObject;
	}
		
	public void setFormularioRenta107sObject(List<Object> newFormularioRenta107sObject) {
		this.formulariorenta107sObject = newFormularioRenta107sObject;
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
		
		if(this.formulariorenta107DataAccess!=null) {
			this.formulariorenta107DataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta107.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			formulariorenta107DataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			formulariorenta107DataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		formulariorenta107 = new  FormularioRenta107();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta107.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			formulariorenta107=formulariorenta107DataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formulariorenta107,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta107(this.formulariorenta107);
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
		formulariorenta107 = new  FormularioRenta107();
		  		  
        try {
			
			formulariorenta107=formulariorenta107DataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formulariorenta107,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta107(this.formulariorenta107);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		formulariorenta107 = new  FormularioRenta107();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta107.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			formulariorenta107=formulariorenta107DataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formulariorenta107,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta107(this.formulariorenta107);
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
		formulariorenta107 = new  FormularioRenta107();
		  		  
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
		formulariorenta107 = new  FormularioRenta107();
		  		  
        try {
			
			formulariorenta107=formulariorenta107DataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formulariorenta107,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta107(this.formulariorenta107);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		formulariorenta107 = new  FormularioRenta107();
		  		  
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
		formulariorenta107 = new  FormularioRenta107();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta107.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =formulariorenta107DataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		formulariorenta107 = new  FormularioRenta107();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=formulariorenta107DataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		formulariorenta107 = new  FormularioRenta107();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta107.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =formulariorenta107DataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		formulariorenta107 = new  FormularioRenta107();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=formulariorenta107DataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		formulariorenta107 = new  FormularioRenta107();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta107.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =formulariorenta107DataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		formulariorenta107 = new  FormularioRenta107();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=formulariorenta107DataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		formulariorenta107s = new  ArrayList<FormularioRenta107>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta107.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			FormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulariorenta107s=formulariorenta107DataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormularioRenta107(formulariorenta107s);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta107(this.formulariorenta107s);
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
		formulariorenta107s = new  ArrayList<FormularioRenta107>();
		  		  
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
		formulariorenta107s = new  ArrayList<FormularioRenta107>();
		  		  
        try {			
			FormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulariorenta107s=formulariorenta107DataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarFormularioRenta107(formulariorenta107s);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta107(this.formulariorenta107s);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		formulariorenta107s = new  ArrayList<FormularioRenta107>();
		  		  
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
		formulariorenta107s = new  ArrayList<FormularioRenta107>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta107.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			FormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulariorenta107s=formulariorenta107DataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormularioRenta107(formulariorenta107s);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta107(this.formulariorenta107s);
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
		formulariorenta107s = new  ArrayList<FormularioRenta107>();
		  		  
        try {
			FormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulariorenta107s=formulariorenta107DataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormularioRenta107(formulariorenta107s);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta107(this.formulariorenta107s);
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
		formulariorenta107s = new  ArrayList<FormularioRenta107>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta107.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulariorenta107s=formulariorenta107DataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormularioRenta107(formulariorenta107s);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta107(this.formulariorenta107s);
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
		formulariorenta107s = new  ArrayList<FormularioRenta107>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulariorenta107s=formulariorenta107DataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormularioRenta107(formulariorenta107s);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta107(this.formulariorenta107s);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		formulariorenta107 = new  FormularioRenta107();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta107.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulariorenta107=formulariorenta107DataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormularioRenta107(formulariorenta107);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta107(this.formulariorenta107);
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
		formulariorenta107 = new  FormularioRenta107();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulariorenta107=formulariorenta107DataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormularioRenta107(formulariorenta107);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta107(this.formulariorenta107);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		formulariorenta107s = new  ArrayList<FormularioRenta107>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta107.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			FormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulariorenta107s=formulariorenta107DataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormularioRenta107(formulariorenta107s);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta107(this.formulariorenta107s);
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
		formulariorenta107s = new  ArrayList<FormularioRenta107>();
		  		  
        try {
			FormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulariorenta107s=formulariorenta107DataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormularioRenta107(formulariorenta107s);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta107(this.formulariorenta107s);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosFormularioRenta107sWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		formulariorenta107s = new  ArrayList<FormularioRenta107>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta107.class.getSimpleName()+"-getTodosFormularioRenta107sWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulariorenta107s=formulariorenta107DataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFormularioRenta107(formulariorenta107s);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta107(this.formulariorenta107s);
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
	
	public  void  getTodosFormularioRenta107s(String sFinalQuery,Pagination pagination)throws Exception {
		formulariorenta107s = new  ArrayList<FormularioRenta107>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulariorenta107s=formulariorenta107DataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFormularioRenta107(formulariorenta107s);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta107(this.formulariorenta107s);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarFormularioRenta107(FormularioRenta107 formulariorenta107) throws Exception {
		Boolean estaValidado=false;
		
		if(formulariorenta107.getIsNew() || formulariorenta107.getIsChanged()) { 
			this.invalidValues = formulariorenta107Validator.getInvalidValues(formulariorenta107);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(formulariorenta107);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarFormularioRenta107(List<FormularioRenta107> FormularioRenta107s) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(FormularioRenta107 formulariorenta107Local:formulariorenta107s) {				
			estaValidadoObjeto=this.validarGuardarFormularioRenta107(formulariorenta107Local);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarFormularioRenta107(List<FormularioRenta107> FormularioRenta107s) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFormularioRenta107(formulariorenta107s)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarFormularioRenta107(FormularioRenta107 FormularioRenta107) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFormularioRenta107(formulariorenta107)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(FormularioRenta107 formulariorenta107) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+formulariorenta107.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=FormularioRenta107ConstantesFunciones.getFormularioRenta107LabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"formulariorenta107","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(FormularioRenta107ConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(FormularioRenta107ConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveFormularioRenta107WithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta107.class.getSimpleName()+"-saveFormularioRenta107WithConnection");connexion.begin();			
			
			FormularioRenta107LogicAdditional.checkFormularioRenta107ToSave(this.formulariorenta107,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FormularioRenta107LogicAdditional.updateFormularioRenta107ToSave(this.formulariorenta107,this.arrDatoGeneral);
			
			FormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.formulariorenta107,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowFormularioRenta107();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFormularioRenta107(this.formulariorenta107)) {
				FormularioRenta107DataAccess.save(this.formulariorenta107, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.formulariorenta107,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FormularioRenta107LogicAdditional.checkFormularioRenta107ToSaveAfter(this.formulariorenta107,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFormularioRenta107();
			
			connexion.commit();			
			
			if(this.formulariorenta107.getIsDeleted()) {
				this.formulariorenta107=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveFormularioRenta107()throws Exception {	
		try {	
			
			FormularioRenta107LogicAdditional.checkFormularioRenta107ToSave(this.formulariorenta107,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FormularioRenta107LogicAdditional.updateFormularioRenta107ToSave(this.formulariorenta107,this.arrDatoGeneral);
			
			FormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.formulariorenta107,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFormularioRenta107(this.formulariorenta107)) {			
				FormularioRenta107DataAccess.save(this.formulariorenta107, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.formulariorenta107,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FormularioRenta107LogicAdditional.checkFormularioRenta107ToSaveAfter(this.formulariorenta107,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.formulariorenta107.getIsDeleted()) {
				this.formulariorenta107=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveFormularioRenta107sWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta107.class.getSimpleName()+"-saveFormularioRenta107sWithConnection");connexion.begin();			
			
			FormularioRenta107LogicAdditional.checkFormularioRenta107ToSaves(formulariorenta107s,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowFormularioRenta107s();
			
			Boolean validadoTodosFormularioRenta107=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(FormularioRenta107 formulariorenta107Local:formulariorenta107s) {		
				if(formulariorenta107Local.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FormularioRenta107LogicAdditional.updateFormularioRenta107ToSave(formulariorenta107Local,this.arrDatoGeneral);
	        	
				FormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),formulariorenta107Local,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFormularioRenta107(formulariorenta107Local)) {
					FormularioRenta107DataAccess.save(formulariorenta107Local, connexion);				
				} else {
					validadoTodosFormularioRenta107=false;
				}
			}
			
			if(!validadoTodosFormularioRenta107) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FormularioRenta107LogicAdditional.checkFormularioRenta107ToSavesAfter(formulariorenta107s,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFormularioRenta107s();
			
			connexion.commit();		
			
			this.quitarFormularioRenta107sEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveFormularioRenta107s()throws Exception {				
		 try {	
			FormularioRenta107LogicAdditional.checkFormularioRenta107ToSaves(formulariorenta107s,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosFormularioRenta107=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(FormularioRenta107 formulariorenta107Local:formulariorenta107s) {				
				if(formulariorenta107Local.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FormularioRenta107LogicAdditional.updateFormularioRenta107ToSave(formulariorenta107Local,this.arrDatoGeneral);
	        	
				FormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),formulariorenta107Local,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFormularioRenta107(formulariorenta107Local)) {				
					FormularioRenta107DataAccess.save(formulariorenta107Local, connexion);				
				} else {
					validadoTodosFormularioRenta107=false;
				}
			}
			
			if(!validadoTodosFormularioRenta107) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FormularioRenta107LogicAdditional.checkFormularioRenta107ToSavesAfter(formulariorenta107s,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarFormularioRenta107sEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FormularioRenta107ParameterReturnGeneral procesarAccionFormularioRenta107s(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FormularioRenta107> formulariorenta107s,FormularioRenta107ParameterReturnGeneral formulariorenta107ParameterGeneral)throws Exception {
		 try {	
			FormularioRenta107ParameterReturnGeneral formulariorenta107ReturnGeneral=new FormularioRenta107ParameterReturnGeneral();
	
			FormularioRenta107LogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,formulariorenta107s,formulariorenta107ParameterGeneral,formulariorenta107ReturnGeneral);
			
			return formulariorenta107ReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FormularioRenta107ParameterReturnGeneral procesarAccionFormularioRenta107sWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FormularioRenta107> formulariorenta107s,FormularioRenta107ParameterReturnGeneral formulariorenta107ParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta107.class.getSimpleName()+"-procesarAccionFormularioRenta107sWithConnection");connexion.begin();			
			
			FormularioRenta107ParameterReturnGeneral formulariorenta107ReturnGeneral=new FormularioRenta107ParameterReturnGeneral();
	
			FormularioRenta107LogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,formulariorenta107s,formulariorenta107ParameterGeneral,formulariorenta107ReturnGeneral);
			
			this.connexion.commit();
			
			return formulariorenta107ReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FormularioRenta107ParameterReturnGeneral procesarEventosFormularioRenta107s(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<FormularioRenta107> formulariorenta107s,FormularioRenta107 formulariorenta107,FormularioRenta107ParameterReturnGeneral formulariorenta107ParameterGeneral,Boolean isEsNuevoFormularioRenta107,ArrayList<Classe> clases)throws Exception {
		 try {	
			FormularioRenta107ParameterReturnGeneral formulariorenta107ReturnGeneral=new FormularioRenta107ParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				formulariorenta107ReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FormularioRenta107LogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,formulariorenta107s,formulariorenta107,formulariorenta107ParameterGeneral,formulariorenta107ReturnGeneral,isEsNuevoFormularioRenta107,clases);
			
			return formulariorenta107ReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public FormularioRenta107ParameterReturnGeneral procesarEventosFormularioRenta107sWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<FormularioRenta107> formulariorenta107s,FormularioRenta107 formulariorenta107,FormularioRenta107ParameterReturnGeneral formulariorenta107ParameterGeneral,Boolean isEsNuevoFormularioRenta107,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta107.class.getSimpleName()+"-procesarEventosFormularioRenta107sWithConnection");connexion.begin();			
			
			FormularioRenta107ParameterReturnGeneral formulariorenta107ReturnGeneral=new FormularioRenta107ParameterReturnGeneral();
	
			formulariorenta107ReturnGeneral.setFormularioRenta107(formulariorenta107);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				formulariorenta107ReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FormularioRenta107LogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,formulariorenta107s,formulariorenta107,formulariorenta107ParameterGeneral,formulariorenta107ReturnGeneral,isEsNuevoFormularioRenta107,clases);
			
			this.connexion.commit();
			
			return formulariorenta107ReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FormularioRenta107ParameterReturnGeneral procesarImportacionFormularioRenta107sWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,FormularioRenta107ParameterReturnGeneral formulariorenta107ParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta107.class.getSimpleName()+"-procesarImportacionFormularioRenta107sWithConnection");connexion.begin();			
			
			FormularioRenta107ParameterReturnGeneral formulariorenta107ReturnGeneral=new FormularioRenta107ParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.formulariorenta107s=new ArrayList<FormularioRenta107>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.formulariorenta107=new FormularioRenta107();
				
				
				if(conColumnasBase) {this.formulariorenta107.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.formulariorenta107.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.formulariorenta107.setnumero_pre_impreso(arrColumnas[iColumn++]);
				this.formulariorenta107.setfecha_entrega(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.formulariorenta107.setfecha_generacion(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				
				this.formulariorenta107s.add(this.formulariorenta107);
			}
			
			this.saveFormularioRenta107s();
			
			this.connexion.commit();
			
			formulariorenta107ReturnGeneral.setConRetornoEstaProcesado(true);
			formulariorenta107ReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return formulariorenta107ReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarFormularioRenta107sEliminados() throws Exception {				
		
		List<FormularioRenta107> formulariorenta107sAux= new ArrayList<FormularioRenta107>();
		
		for(FormularioRenta107 formulariorenta107:formulariorenta107s) {
			if(!formulariorenta107.getIsDeleted()) {
				formulariorenta107sAux.add(formulariorenta107);
			}
		}
		
		formulariorenta107s=formulariorenta107sAux;
	}
	
	public void quitarFormularioRenta107sNulos() throws Exception {				
		
		List<FormularioRenta107> formulariorenta107sAux= new ArrayList<FormularioRenta107>();
		
		for(FormularioRenta107 formulariorenta107 : this.formulariorenta107s) {
			if(formulariorenta107==null) {
				formulariorenta107sAux.add(formulariorenta107);
			}
		}
		
		//this.formulariorenta107s=formulariorenta107sAux;
		
		this.formulariorenta107s.removeAll(formulariorenta107sAux);
	}
	
	public void getSetVersionRowFormularioRenta107WithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(formulariorenta107.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((formulariorenta107.getIsDeleted() || (formulariorenta107.getIsChanged()&&!formulariorenta107.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=formulariorenta107DataAccess.getSetVersionRowFormularioRenta107(connexion,formulariorenta107.getId());
				
				if(!formulariorenta107.getVersionRow().equals(timestamp)) {	
					formulariorenta107.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				formulariorenta107.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowFormularioRenta107()throws Exception {	
		
		if(formulariorenta107.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((formulariorenta107.getIsDeleted() || (formulariorenta107.getIsChanged()&&!formulariorenta107.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=formulariorenta107DataAccess.getSetVersionRowFormularioRenta107(connexion,formulariorenta107.getId());
			
			try {							
				if(!formulariorenta107.getVersionRow().equals(timestamp)) {	
					formulariorenta107.setVersionRow(timestamp);
				}
				
				formulariorenta107.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowFormularioRenta107sWithConnection()throws Exception {	
		if(formulariorenta107s!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(FormularioRenta107 formulariorenta107Aux:formulariorenta107s) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(formulariorenta107Aux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(formulariorenta107Aux.getIsDeleted() || (formulariorenta107Aux.getIsChanged()&&!formulariorenta107Aux.getIsNew())) {
						
						timestamp=formulariorenta107DataAccess.getSetVersionRowFormularioRenta107(connexion,formulariorenta107Aux.getId());
						
						if(!formulariorenta107.getVersionRow().equals(timestamp)) {	
							formulariorenta107Aux.setVersionRow(timestamp);
						}
								
						formulariorenta107Aux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowFormularioRenta107s()throws Exception {	
		if(formulariorenta107s!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(FormularioRenta107 formulariorenta107Aux:formulariorenta107s) {
					if(formulariorenta107Aux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(formulariorenta107Aux.getIsDeleted() || (formulariorenta107Aux.getIsChanged()&&!formulariorenta107Aux.getIsNew())) {
						
						timestamp=formulariorenta107DataAccess.getSetVersionRowFormularioRenta107(connexion,formulariorenta107Aux.getId());
						
						if(!formulariorenta107Aux.getVersionRow().equals(timestamp)) {	
							formulariorenta107Aux.setVersionRow(timestamp);
						}
						
													
						formulariorenta107Aux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public FormularioRenta107ParameterReturnGeneral cargarCombosLoteForeignKeyFormularioRenta107WithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalEjercicio) throws Exception {
		FormularioRenta107ParameterReturnGeneral  formulariorenta107ReturnGeneral =new FormularioRenta107ParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta107.class.getSimpleName()+"-cargarCombosLoteForeignKeyFormularioRenta107WithConnection");connexion.begin();
			
			formulariorenta107ReturnGeneral =new FormularioRenta107ParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			formulariorenta107ReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			formulariorenta107ReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			formulariorenta107ReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return formulariorenta107ReturnGeneral;
	}
	
	public FormularioRenta107ParameterReturnGeneral cargarCombosLoteForeignKeyFormularioRenta107(String finalQueryGlobalEmpresa,String finalQueryGlobalEmpleado,String finalQueryGlobalEjercicio) throws Exception {
		FormularioRenta107ParameterReturnGeneral  formulariorenta107ReturnGeneral =new FormularioRenta107ParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			formulariorenta107ReturnGeneral =new FormularioRenta107ParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			formulariorenta107ReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Empleado> empleadosForeignKey=new ArrayList<Empleado>();
			EmpleadoLogic empleadoLogic=new EmpleadoLogic();
			empleadoLogic.setConnexion(this.connexion);
			empleadoLogic.getEmpleadoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpleado.equals("NONE")) {
				empleadoLogic.getTodosEmpleados(finalQueryGlobalEmpleado,new Pagination());
				empleadosForeignKey=empleadoLogic.getEmpleados();
			}

			formulariorenta107ReturnGeneral.setempleadosForeignKey(empleadosForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			formulariorenta107ReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return formulariorenta107ReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyFormularioRenta107WithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleFormularioRenta107Logic detalleformulariorenta107Logic=new DetalleFormularioRenta107Logic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta107.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyFormularioRenta107WithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleFormularioRenta107.class));
											
			

			detalleformulariorenta107Logic.setConnexion(this.getConnexion());
			detalleformulariorenta107Logic.setDatosCliente(this.datosCliente);
			detalleformulariorenta107Logic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(FormularioRenta107 formulariorenta107:this.formulariorenta107s) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleFormularioRenta107ConstantesFunciones.getClassesForeignKeysOfDetalleFormularioRenta107(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalleformulariorenta107Logic.setDetalleFormularioRenta107s(formulariorenta107.detalleformulariorenta107s);
				detalleformulariorenta107Logic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(FormularioRenta107 formulariorenta107,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			FormularioRenta107LogicAdditional.updateFormularioRenta107ToGet(formulariorenta107,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		formulariorenta107.setEmpresa(formulariorenta107DataAccess.getEmpresa(connexion,formulariorenta107));
		formulariorenta107.setEmpleado(formulariorenta107DataAccess.getEmpleado(connexion,formulariorenta107));
		formulariorenta107.setEjercicio(formulariorenta107DataAccess.getEjercicio(connexion,formulariorenta107));
		formulariorenta107.setDetalleFormularioRenta107s(formulariorenta107DataAccess.getDetalleFormularioRenta107s(connexion,formulariorenta107));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				formulariorenta107.setEmpresa(formulariorenta107DataAccess.getEmpresa(connexion,formulariorenta107));
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				formulariorenta107.setEmpleado(formulariorenta107DataAccess.getEmpleado(connexion,formulariorenta107));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				formulariorenta107.setEjercicio(formulariorenta107DataAccess.getEjercicio(connexion,formulariorenta107));
				continue;
			}

			if(clas.clas.equals(DetalleFormularioRenta107.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				formulariorenta107.setDetalleFormularioRenta107s(formulariorenta107DataAccess.getDetalleFormularioRenta107s(connexion,formulariorenta107));

				if(this.isConDeep) {
					DetalleFormularioRenta107Logic detalleformulariorenta107Logic= new DetalleFormularioRenta107Logic(this.connexion);
					detalleformulariorenta107Logic.setDetalleFormularioRenta107s(formulariorenta107.getDetalleFormularioRenta107s());
					ArrayList<Classe> classesLocal=DetalleFormularioRenta107ConstantesFunciones.getClassesForeignKeysOfDetalleFormularioRenta107(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalleformulariorenta107Logic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleFormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesDetalleFormularioRenta107(detalleformulariorenta107Logic.getDetalleFormularioRenta107s());
					formulariorenta107.setDetalleFormularioRenta107s(detalleformulariorenta107Logic.getDetalleFormularioRenta107s());
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
			formulariorenta107.setEmpresa(formulariorenta107DataAccess.getEmpresa(connexion,formulariorenta107));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formulariorenta107.setEmpleado(formulariorenta107DataAccess.getEmpleado(connexion,formulariorenta107));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formulariorenta107.setEjercicio(formulariorenta107DataAccess.getEjercicio(connexion,formulariorenta107));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleFormularioRenta107.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleFormularioRenta107.class));
			formulariorenta107.setDetalleFormularioRenta107s(formulariorenta107DataAccess.getDetalleFormularioRenta107s(connexion,formulariorenta107));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		formulariorenta107.setEmpresa(formulariorenta107DataAccess.getEmpresa(connexion,formulariorenta107));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(formulariorenta107.getEmpresa(),isDeep,deepLoadType,clases);
				
		formulariorenta107.setEmpleado(formulariorenta107DataAccess.getEmpleado(connexion,formulariorenta107));
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(formulariorenta107.getEmpleado(),isDeep,deepLoadType,clases);
				
		formulariorenta107.setEjercicio(formulariorenta107DataAccess.getEjercicio(connexion,formulariorenta107));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(formulariorenta107.getEjercicio(),isDeep,deepLoadType,clases);
				

		formulariorenta107.setDetalleFormularioRenta107s(formulariorenta107DataAccess.getDetalleFormularioRenta107s(connexion,formulariorenta107));

		for(DetalleFormularioRenta107 detalleformulariorenta107:formulariorenta107.getDetalleFormularioRenta107s()) {
			DetalleFormularioRenta107Logic detalleformulariorenta107Logic= new DetalleFormularioRenta107Logic(connexion);
			detalleformulariorenta107Logic.deepLoad(detalleformulariorenta107,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				formulariorenta107.setEmpresa(formulariorenta107DataAccess.getEmpresa(connexion,formulariorenta107));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(formulariorenta107.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				formulariorenta107.setEmpleado(formulariorenta107DataAccess.getEmpleado(connexion,formulariorenta107));
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepLoad(formulariorenta107.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				formulariorenta107.setEjercicio(formulariorenta107DataAccess.getEjercicio(connexion,formulariorenta107));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(formulariorenta107.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleFormularioRenta107.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				formulariorenta107.setDetalleFormularioRenta107s(formulariorenta107DataAccess.getDetalleFormularioRenta107s(connexion,formulariorenta107));

				for(DetalleFormularioRenta107 detalleformulariorenta107:formulariorenta107.getDetalleFormularioRenta107s()) {
					DetalleFormularioRenta107Logic detalleformulariorenta107Logic= new DetalleFormularioRenta107Logic(connexion);
					detalleformulariorenta107Logic.deepLoad(detalleformulariorenta107,isDeep,deepLoadType,clases);
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
			formulariorenta107.setEmpresa(formulariorenta107DataAccess.getEmpresa(connexion,formulariorenta107));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(formulariorenta107.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empleado.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formulariorenta107.setEmpleado(formulariorenta107DataAccess.getEmpleado(connexion,formulariorenta107));
			EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
			empleadoLogic.deepLoad(formulariorenta107.getEmpleado(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formulariorenta107.setEjercicio(formulariorenta107DataAccess.getEjercicio(connexion,formulariorenta107));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(formulariorenta107.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleFormularioRenta107.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleFormularioRenta107.class));
			formulariorenta107.setDetalleFormularioRenta107s(formulariorenta107DataAccess.getDetalleFormularioRenta107s(connexion,formulariorenta107));

			for(DetalleFormularioRenta107 detalleformulariorenta107:formulariorenta107.getDetalleFormularioRenta107s()) {
				DetalleFormularioRenta107Logic detalleformulariorenta107Logic= new DetalleFormularioRenta107Logic(connexion);
				detalleformulariorenta107Logic.deepLoad(detalleformulariorenta107,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(FormularioRenta107 formulariorenta107,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			FormularioRenta107LogicAdditional.updateFormularioRenta107ToSave(formulariorenta107,this.arrDatoGeneral);
			
FormularioRenta107DataAccess.save(formulariorenta107, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(formulariorenta107.getEmpresa(),connexion);

		EmpleadoDataAccess.save(formulariorenta107.getEmpleado(),connexion);

		EjercicioDataAccess.save(formulariorenta107.getEjercicio(),connexion);

		for(DetalleFormularioRenta107 detalleformulariorenta107:formulariorenta107.getDetalleFormularioRenta107s()) {
			detalleformulariorenta107.setid_formulario_renta107(formulariorenta107.getId());
			DetalleFormularioRenta107DataAccess.save(detalleformulariorenta107,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(formulariorenta107.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(formulariorenta107.getEmpleado(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(formulariorenta107.getEjercicio(),connexion);
				continue;
			}


			if(clas.clas.equals(DetalleFormularioRenta107.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleFormularioRenta107 detalleformulariorenta107:formulariorenta107.getDetalleFormularioRenta107s()) {
					detalleformulariorenta107.setid_formulario_renta107(formulariorenta107.getId());
					DetalleFormularioRenta107DataAccess.save(detalleformulariorenta107,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(formulariorenta107.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(formulariorenta107.getEmpresa(),isDeep,deepLoadType,clases);
				

		EmpleadoDataAccess.save(formulariorenta107.getEmpleado(),connexion);
		EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
		empleadoLogic.deepLoad(formulariorenta107.getEmpleado(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(formulariorenta107.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(formulariorenta107.getEjercicio(),isDeep,deepLoadType,clases);
				

		for(DetalleFormularioRenta107 detalleformulariorenta107:formulariorenta107.getDetalleFormularioRenta107s()) {
			DetalleFormularioRenta107Logic detalleformulariorenta107Logic= new DetalleFormularioRenta107Logic(connexion);
			detalleformulariorenta107.setid_formulario_renta107(formulariorenta107.getId());
			DetalleFormularioRenta107DataAccess.save(detalleformulariorenta107,connexion);
			detalleformulariorenta107Logic.deepSave(detalleformulariorenta107,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(formulariorenta107.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(formulariorenta107.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empleado.class)) {
				EmpleadoDataAccess.save(formulariorenta107.getEmpleado(),connexion);
				EmpleadoLogic empleadoLogic= new EmpleadoLogic(connexion);
				empleadoLogic.deepSave(formulariorenta107.getEmpleado(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(formulariorenta107.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(formulariorenta107.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetalleFormularioRenta107.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleFormularioRenta107 detalleformulariorenta107:formulariorenta107.getDetalleFormularioRenta107s()) {
					DetalleFormularioRenta107Logic detalleformulariorenta107Logic= new DetalleFormularioRenta107Logic(connexion);
					detalleformulariorenta107.setid_formulario_renta107(formulariorenta107.getId());
					DetalleFormularioRenta107DataAccess.save(detalleformulariorenta107,connexion);
					detalleformulariorenta107Logic.deepSave(detalleformulariorenta107,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(FormularioRenta107.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(formulariorenta107,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta107(formulariorenta107);
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
			this.deepLoad(this.formulariorenta107,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta107(this.formulariorenta107);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(FormularioRenta107.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(formulariorenta107s!=null) {
				for(FormularioRenta107 formulariorenta107:formulariorenta107s) {
					this.deepLoad(formulariorenta107,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					FormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta107(formulariorenta107s);
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
			if(formulariorenta107s!=null) {
				for(FormularioRenta107 formulariorenta107:formulariorenta107s) {
					this.deepLoad(formulariorenta107,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					FormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta107(formulariorenta107s);
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
			this.getNewConnexionToDeep(FormularioRenta107.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(formulariorenta107,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(FormularioRenta107.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(formulariorenta107s!=null) {
				for(FormularioRenta107 formulariorenta107:formulariorenta107s) {
					this.deepSave(formulariorenta107,isDeep,deepLoadType,clases);
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
			if(formulariorenta107s!=null) {
				for(FormularioRenta107 formulariorenta107:formulariorenta107s) {
					this.deepSave(formulariorenta107,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getFormularioRenta107sFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta107.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,FormularioRenta107ConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			FormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formulariorenta107s=formulariorenta107DataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta107(this.formulariorenta107s);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormularioRenta107sFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,FormularioRenta107ConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			FormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formulariorenta107s=formulariorenta107DataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta107(this.formulariorenta107s);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormularioRenta107sFK_IdEmpleadoWithConnection(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta107.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,FormularioRenta107ConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			FormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formulariorenta107s=formulariorenta107DataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta107(this.formulariorenta107s);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormularioRenta107sFK_IdEmpleado(String sFinalQuery,Pagination pagination,Long id_empleado)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpleado= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpleado.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empleado,FormularioRenta107ConstantesFunciones.IDEMPLEADO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpleado);

			FormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpleado","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formulariorenta107s=formulariorenta107DataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta107(this.formulariorenta107s);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormularioRenta107sFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta107.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FormularioRenta107ConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formulariorenta107s=formulariorenta107DataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta107(this.formulariorenta107s);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormularioRenta107sFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FormularioRenta107ConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FormularioRenta107Logic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formulariorenta107s=formulariorenta107DataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioRenta107ConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta107(this.formulariorenta107s);
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
			if(FormularioRenta107ConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,FormularioRenta107DataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,FormularioRenta107 formulariorenta107,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(FormularioRenta107ConstantesFunciones.ISCONAUDITORIA) {
				if(formulariorenta107.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FormularioRenta107DataAccess.TABLENAME, formulariorenta107.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FormularioRenta107ConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FormularioRenta107Logic.registrarAuditoriaDetallesFormularioRenta107(connexion,formulariorenta107,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(formulariorenta107.getIsDeleted()) {
					/*if(!formulariorenta107.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,FormularioRenta107DataAccess.TABLENAME, formulariorenta107.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////FormularioRenta107Logic.registrarAuditoriaDetallesFormularioRenta107(connexion,formulariorenta107,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FormularioRenta107DataAccess.TABLENAME, formulariorenta107.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(formulariorenta107.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FormularioRenta107DataAccess.TABLENAME, formulariorenta107.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FormularioRenta107ConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FormularioRenta107Logic.registrarAuditoriaDetallesFormularioRenta107(connexion,formulariorenta107,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesFormularioRenta107(Connexion connexion,FormularioRenta107 formulariorenta107)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(formulariorenta107.getIsNew()||!formulariorenta107.getid_empresa().equals(formulariorenta107.getFormularioRenta107Original().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorenta107.getFormularioRenta107Original().getid_empresa()!=null)
				{
					strValorActual=formulariorenta107.getFormularioRenta107Original().getid_empresa().toString();
				}
				if(formulariorenta107.getid_empresa()!=null)
				{
					strValorNuevo=formulariorenta107.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRenta107ConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(formulariorenta107.getIsNew()||!formulariorenta107.getid_empleado().equals(formulariorenta107.getFormularioRenta107Original().getid_empleado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorenta107.getFormularioRenta107Original().getid_empleado()!=null)
				{
					strValorActual=formulariorenta107.getFormularioRenta107Original().getid_empleado().toString();
				}
				if(formulariorenta107.getid_empleado()!=null)
				{
					strValorNuevo=formulariorenta107.getid_empleado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRenta107ConstantesFunciones.IDEMPLEADO,strValorActual,strValorNuevo);
			}	
			
			if(formulariorenta107.getIsNew()||!formulariorenta107.getid_ejercicio().equals(formulariorenta107.getFormularioRenta107Original().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorenta107.getFormularioRenta107Original().getid_ejercicio()!=null)
				{
					strValorActual=formulariorenta107.getFormularioRenta107Original().getid_ejercicio().toString();
				}
				if(formulariorenta107.getid_ejercicio()!=null)
				{
					strValorNuevo=formulariorenta107.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRenta107ConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(formulariorenta107.getIsNew()||!formulariorenta107.getnumero_pre_impreso().equals(formulariorenta107.getFormularioRenta107Original().getnumero_pre_impreso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorenta107.getFormularioRenta107Original().getnumero_pre_impreso()!=null)
				{
					strValorActual=formulariorenta107.getFormularioRenta107Original().getnumero_pre_impreso();
				}
				if(formulariorenta107.getnumero_pre_impreso()!=null)
				{
					strValorNuevo=formulariorenta107.getnumero_pre_impreso() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRenta107ConstantesFunciones.NUMEROPREIMPRESO,strValorActual,strValorNuevo);
			}	
			
			if(formulariorenta107.getIsNew()||!formulariorenta107.getfecha_entrega().equals(formulariorenta107.getFormularioRenta107Original().getfecha_entrega()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorenta107.getFormularioRenta107Original().getfecha_entrega()!=null)
				{
					strValorActual=formulariorenta107.getFormularioRenta107Original().getfecha_entrega().toString();
				}
				if(formulariorenta107.getfecha_entrega()!=null)
				{
					strValorNuevo=formulariorenta107.getfecha_entrega().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRenta107ConstantesFunciones.FECHAENTREGA,strValorActual,strValorNuevo);
			}	
			
			if(formulariorenta107.getIsNew()||!formulariorenta107.getfecha_generacion().equals(formulariorenta107.getFormularioRenta107Original().getfecha_generacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorenta107.getFormularioRenta107Original().getfecha_generacion()!=null)
				{
					strValorActual=formulariorenta107.getFormularioRenta107Original().getfecha_generacion().toString();
				}
				if(formulariorenta107.getfecha_generacion()!=null)
				{
					strValorNuevo=formulariorenta107.getfecha_generacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRenta107ConstantesFunciones.FECHAGENERACION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveFormularioRenta107RelacionesWithConnection(FormularioRenta107 formulariorenta107,List<DetalleFormularioRenta107> detalleformulariorenta107s) throws Exception {

		if(!formulariorenta107.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFormularioRenta107RelacionesBase(formulariorenta107,detalleformulariorenta107s,true);
		}
	}

	public void saveFormularioRenta107Relaciones(FormularioRenta107 formulariorenta107,List<DetalleFormularioRenta107> detalleformulariorenta107s)throws Exception {

		if(!formulariorenta107.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFormularioRenta107RelacionesBase(formulariorenta107,detalleformulariorenta107s,false);
		}
	}

	public void saveFormularioRenta107RelacionesBase(FormularioRenta107 formulariorenta107,List<DetalleFormularioRenta107> detalleformulariorenta107s,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("FormularioRenta107-saveRelacionesWithConnection");}
	
			formulariorenta107.setDetalleFormularioRenta107s(detalleformulariorenta107s);

			this.setFormularioRenta107(formulariorenta107);

			if(FormularioRenta107LogicAdditional.validarSaveRelaciones(formulariorenta107,this)) {

				FormularioRenta107LogicAdditional.updateRelacionesToSave(formulariorenta107,this);

				if((formulariorenta107.getIsNew()||formulariorenta107.getIsChanged())&&!formulariorenta107.getIsDeleted()) {
					this.saveFormularioRenta107();
					this.saveFormularioRenta107RelacionesDetalles(detalleformulariorenta107s);

				} else if(formulariorenta107.getIsDeleted()) {
					this.saveFormularioRenta107RelacionesDetalles(detalleformulariorenta107s);
					this.saveFormularioRenta107();
				}

				FormularioRenta107LogicAdditional.updateRelacionesToSaveAfter(formulariorenta107,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetalleFormularioRenta107ConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleFormularioRenta107s(detalleformulariorenta107s,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveFormularioRenta107RelacionesDetalles(List<DetalleFormularioRenta107> detalleformulariorenta107s)throws Exception {
		try {
	

			Long idFormularioRenta107Actual=this.getFormularioRenta107().getId();

			DetalleFormularioRenta107Logic detalleformulariorenta107Logic_Desde_FormularioRenta107=new DetalleFormularioRenta107Logic();
			detalleformulariorenta107Logic_Desde_FormularioRenta107.setDetalleFormularioRenta107s(detalleformulariorenta107s);

			detalleformulariorenta107Logic_Desde_FormularioRenta107.setConnexion(this.getConnexion());
			detalleformulariorenta107Logic_Desde_FormularioRenta107.setDatosCliente(this.datosCliente);

			for(DetalleFormularioRenta107 detalleformulariorenta107_Desde_FormularioRenta107:detalleformulariorenta107Logic_Desde_FormularioRenta107.getDetalleFormularioRenta107s()) {
				detalleformulariorenta107_Desde_FormularioRenta107.setid_formulario_renta107(idFormularioRenta107Actual);
			}

			detalleformulariorenta107Logic_Desde_FormularioRenta107.saveDetalleFormularioRenta107s();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfFormularioRenta107(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FormularioRenta107ConstantesFunciones.getClassesForeignKeysOfFormularioRenta107(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFormularioRenta107(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FormularioRenta107ConstantesFunciones.getClassesRelationshipsOfFormularioRenta107(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

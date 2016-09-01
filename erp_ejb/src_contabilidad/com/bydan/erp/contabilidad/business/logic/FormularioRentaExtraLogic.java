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
package com.bydan.erp.contabilidad.business.logic;

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
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.contabilidad.util.FormularioRentaExtraConstantesFunciones;
import com.bydan.erp.contabilidad.util.FormularioRentaExtraParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.FormularioRentaExtraParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.FormularioRentaExtra;
import com.bydan.erp.contabilidad.business.logic.FormularioRentaExtraLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;








@SuppressWarnings("unused")
public class FormularioRentaExtraLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(FormularioRentaExtraLogic.class);
	
	protected FormularioRentaExtraDataAccess formulariorentaextraDataAccess; 	
	protected FormularioRentaExtra formulariorentaextra;
	protected List<FormularioRentaExtra> formulariorentaextras;
	protected Object formulariorentaextraObject;	
	protected List<Object> formulariorentaextrasObject;
	
	public static ClassValidator<FormularioRentaExtra> formulariorentaextraValidator = new ClassValidator<FormularioRentaExtra>(FormularioRentaExtra.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected FormularioRentaExtraLogicAdditional formulariorentaextraLogicAdditional=null;
	
	public FormularioRentaExtraLogicAdditional getFormularioRentaExtraLogicAdditional() {
		return this.formulariorentaextraLogicAdditional;
	}
	
	public void setFormularioRentaExtraLogicAdditional(FormularioRentaExtraLogicAdditional formulariorentaextraLogicAdditional) {
		try {
			this.formulariorentaextraLogicAdditional=formulariorentaextraLogicAdditional;
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
	
	
	
	
	public  FormularioRentaExtraLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.formulariorentaextraDataAccess = new FormularioRentaExtraDataAccess();
			
			this.formulariorentaextras= new ArrayList<FormularioRentaExtra>();
			this.formulariorentaextra= new FormularioRentaExtra();
			
			this.formulariorentaextraObject=new Object();
			this.formulariorentaextrasObject=new ArrayList<Object>();
				
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
			
			this.formulariorentaextraDataAccess.setConnexionType(this.connexionType);
			this.formulariorentaextraDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  FormularioRentaExtraLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.formulariorentaextraDataAccess = new FormularioRentaExtraDataAccess();
			this.formulariorentaextras= new ArrayList<FormularioRentaExtra>();
			this.formulariorentaextra= new FormularioRentaExtra();
			this.formulariorentaextraObject=new Object();
			this.formulariorentaextrasObject=new ArrayList<Object>();
			
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
			
			this.formulariorentaextraDataAccess.setConnexionType(this.connexionType);
			this.formulariorentaextraDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public FormularioRentaExtra getFormularioRentaExtra() throws Exception {	
		FormularioRentaExtraLogicAdditional.checkFormularioRentaExtraToGet(formulariorentaextra,this.datosCliente,this.arrDatoGeneral);
		FormularioRentaExtraLogicAdditional.updateFormularioRentaExtraToGet(formulariorentaextra,this.arrDatoGeneral);
		
		return formulariorentaextra;
	}
		
	public void setFormularioRentaExtra(FormularioRentaExtra newFormularioRentaExtra) {
		this.formulariorentaextra = newFormularioRentaExtra;
	}
	
	public FormularioRentaExtraDataAccess getFormularioRentaExtraDataAccess() {
		return formulariorentaextraDataAccess;
	}
	
	public void setFormularioRentaExtraDataAccess(FormularioRentaExtraDataAccess newformulariorentaextraDataAccess) {
		this.formulariorentaextraDataAccess = newformulariorentaextraDataAccess;
	}
	
	public List<FormularioRentaExtra> getFormularioRentaExtras() throws Exception {		
		this.quitarFormularioRentaExtrasNulos();
		
		FormularioRentaExtraLogicAdditional.checkFormularioRentaExtraToGets(formulariorentaextras,this.datosCliente,this.arrDatoGeneral);
		
		for (FormularioRentaExtra formulariorentaextraLocal: formulariorentaextras ) {
			FormularioRentaExtraLogicAdditional.updateFormularioRentaExtraToGet(formulariorentaextraLocal,this.arrDatoGeneral);
		}
		
		return formulariorentaextras;
	}
	
	public void setFormularioRentaExtras(List<FormularioRentaExtra> newFormularioRentaExtras) {
		this.formulariorentaextras = newFormularioRentaExtras;
	}
	
	public Object getFormularioRentaExtraObject() {	
		this.formulariorentaextraObject=this.formulariorentaextraDataAccess.getEntityObject();
		return this.formulariorentaextraObject;
	}
		
	public void setFormularioRentaExtraObject(Object newFormularioRentaExtraObject) {
		this.formulariorentaextraObject = newFormularioRentaExtraObject;
	}
	
	public List<Object> getFormularioRentaExtrasObject() {		
		this.formulariorentaextrasObject=this.formulariorentaextraDataAccess.getEntitiesObject();
		return this.formulariorentaextrasObject;
	}
		
	public void setFormularioRentaExtrasObject(List<Object> newFormularioRentaExtrasObject) {
		this.formulariorentaextrasObject = newFormularioRentaExtrasObject;
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
		
		if(this.formulariorentaextraDataAccess!=null) {
			this.formulariorentaextraDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRentaExtra.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			formulariorentaextraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			formulariorentaextraDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		formulariorentaextra = new  FormularioRentaExtra();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRentaExtra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			formulariorentaextra=formulariorentaextraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formulariorentaextra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormularioRentaExtraConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRentaExtra(this.formulariorentaextra);
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
		formulariorentaextra = new  FormularioRentaExtra();
		  		  
        try {
			
			formulariorentaextra=formulariorentaextraDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formulariorentaextra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormularioRentaExtraConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRentaExtra(this.formulariorentaextra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		formulariorentaextra = new  FormularioRentaExtra();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRentaExtra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			formulariorentaextra=formulariorentaextraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formulariorentaextra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormularioRentaExtraConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRentaExtra(this.formulariorentaextra);
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
		formulariorentaextra = new  FormularioRentaExtra();
		  		  
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
		formulariorentaextra = new  FormularioRentaExtra();
		  		  
        try {
			
			formulariorentaextra=formulariorentaextraDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formulariorentaextra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormularioRentaExtraConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRentaExtra(this.formulariorentaextra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		formulariorentaextra = new  FormularioRentaExtra();
		  		  
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
		formulariorentaextra = new  FormularioRentaExtra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRentaExtra.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =formulariorentaextraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		formulariorentaextra = new  FormularioRentaExtra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=formulariorentaextraDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		formulariorentaextra = new  FormularioRentaExtra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRentaExtra.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =formulariorentaextraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		formulariorentaextra = new  FormularioRentaExtra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=formulariorentaextraDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		formulariorentaextra = new  FormularioRentaExtra();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRentaExtra.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =formulariorentaextraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		formulariorentaextra = new  FormularioRentaExtra();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=formulariorentaextraDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		formulariorentaextras = new  ArrayList<FormularioRentaExtra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRentaExtra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			FormularioRentaExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulariorentaextras=formulariorentaextraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormularioRentaExtra(formulariorentaextras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioRentaExtraConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRentaExtra(this.formulariorentaextras);
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
		formulariorentaextras = new  ArrayList<FormularioRentaExtra>();
		  		  
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
		formulariorentaextras = new  ArrayList<FormularioRentaExtra>();
		  		  
        try {			
			FormularioRentaExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulariorentaextras=formulariorentaextraDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarFormularioRentaExtra(formulariorentaextras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioRentaExtraConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRentaExtra(this.formulariorentaextras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		formulariorentaextras = new  ArrayList<FormularioRentaExtra>();
		  		  
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
		formulariorentaextras = new  ArrayList<FormularioRentaExtra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRentaExtra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			FormularioRentaExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulariorentaextras=formulariorentaextraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormularioRentaExtra(formulariorentaextras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioRentaExtraConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRentaExtra(this.formulariorentaextras);
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
		formulariorentaextras = new  ArrayList<FormularioRentaExtra>();
		  		  
        try {
			FormularioRentaExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulariorentaextras=formulariorentaextraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormularioRentaExtra(formulariorentaextras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioRentaExtraConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRentaExtra(this.formulariorentaextras);
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
		formulariorentaextras = new  ArrayList<FormularioRentaExtra>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRentaExtra.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormularioRentaExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulariorentaextras=formulariorentaextraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormularioRentaExtra(formulariorentaextras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioRentaExtraConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRentaExtra(this.formulariorentaextras);
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
		formulariorentaextras = new  ArrayList<FormularioRentaExtra>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormularioRentaExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulariorentaextras=formulariorentaextraDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormularioRentaExtra(formulariorentaextras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioRentaExtraConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRentaExtra(this.formulariorentaextras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		formulariorentaextra = new  FormularioRentaExtra();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRentaExtra.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormularioRentaExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulariorentaextra=formulariorentaextraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormularioRentaExtra(formulariorentaextra);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioRentaExtraConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRentaExtra(this.formulariorentaextra);
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
		formulariorentaextra = new  FormularioRentaExtra();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormularioRentaExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulariorentaextra=formulariorentaextraDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormularioRentaExtra(formulariorentaextra);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioRentaExtraConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRentaExtra(this.formulariorentaextra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		formulariorentaextras = new  ArrayList<FormularioRentaExtra>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRentaExtra.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			FormularioRentaExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulariorentaextras=formulariorentaextraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormularioRentaExtra(formulariorentaextras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioRentaExtraConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRentaExtra(this.formulariorentaextras);
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
		formulariorentaextras = new  ArrayList<FormularioRentaExtra>();
		  		  
        try {
			FormularioRentaExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulariorentaextras=formulariorentaextraDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormularioRentaExtra(formulariorentaextras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioRentaExtraConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRentaExtra(this.formulariorentaextras);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosFormularioRentaExtrasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		formulariorentaextras = new  ArrayList<FormularioRentaExtra>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRentaExtra.class.getSimpleName()+"-getTodosFormularioRentaExtrasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormularioRentaExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulariorentaextras=formulariorentaextraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFormularioRentaExtra(formulariorentaextras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioRentaExtraConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRentaExtra(this.formulariorentaextras);
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
	
	public  void  getTodosFormularioRentaExtras(String sFinalQuery,Pagination pagination)throws Exception {
		formulariorentaextras = new  ArrayList<FormularioRentaExtra>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormularioRentaExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulariorentaextras=formulariorentaextraDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFormularioRentaExtra(formulariorentaextras);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioRentaExtraConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRentaExtra(this.formulariorentaextras);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarFormularioRentaExtra(FormularioRentaExtra formulariorentaextra) throws Exception {
		Boolean estaValidado=false;
		
		if(formulariorentaextra.getIsNew() || formulariorentaextra.getIsChanged()) { 
			this.invalidValues = formulariorentaextraValidator.getInvalidValues(formulariorentaextra);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(formulariorentaextra);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarFormularioRentaExtra(List<FormularioRentaExtra> FormularioRentaExtras) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(FormularioRentaExtra formulariorentaextraLocal:formulariorentaextras) {				
			estaValidadoObjeto=this.validarGuardarFormularioRentaExtra(formulariorentaextraLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarFormularioRentaExtra(List<FormularioRentaExtra> FormularioRentaExtras) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFormularioRentaExtra(formulariorentaextras)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarFormularioRentaExtra(FormularioRentaExtra FormularioRentaExtra) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFormularioRentaExtra(formulariorentaextra)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(FormularioRentaExtra formulariorentaextra) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+formulariorentaextra.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=FormularioRentaExtraConstantesFunciones.getFormularioRentaExtraLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"formulariorentaextra","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(FormularioRentaExtraConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(FormularioRentaExtraConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveFormularioRentaExtraWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRentaExtra.class.getSimpleName()+"-saveFormularioRentaExtraWithConnection");connexion.begin();			
			
			FormularioRentaExtraLogicAdditional.checkFormularioRentaExtraToSave(this.formulariorentaextra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FormularioRentaExtraLogicAdditional.updateFormularioRentaExtraToSave(this.formulariorentaextra,this.arrDatoGeneral);
			
			FormularioRentaExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.formulariorentaextra,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowFormularioRentaExtra();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFormularioRentaExtra(this.formulariorentaextra)) {
				FormularioRentaExtraDataAccess.save(this.formulariorentaextra, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.formulariorentaextra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FormularioRentaExtraLogicAdditional.checkFormularioRentaExtraToSaveAfter(this.formulariorentaextra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFormularioRentaExtra();
			
			connexion.commit();			
			
			if(this.formulariorentaextra.getIsDeleted()) {
				this.formulariorentaextra=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveFormularioRentaExtra()throws Exception {	
		try {	
			
			FormularioRentaExtraLogicAdditional.checkFormularioRentaExtraToSave(this.formulariorentaextra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FormularioRentaExtraLogicAdditional.updateFormularioRentaExtraToSave(this.formulariorentaextra,this.arrDatoGeneral);
			
			FormularioRentaExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.formulariorentaextra,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFormularioRentaExtra(this.formulariorentaextra)) {			
				FormularioRentaExtraDataAccess.save(this.formulariorentaextra, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.formulariorentaextra,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FormularioRentaExtraLogicAdditional.checkFormularioRentaExtraToSaveAfter(this.formulariorentaextra,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.formulariorentaextra.getIsDeleted()) {
				this.formulariorentaextra=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveFormularioRentaExtrasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRentaExtra.class.getSimpleName()+"-saveFormularioRentaExtrasWithConnection");connexion.begin();			
			
			FormularioRentaExtraLogicAdditional.checkFormularioRentaExtraToSaves(formulariorentaextras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowFormularioRentaExtras();
			
			Boolean validadoTodosFormularioRentaExtra=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(FormularioRentaExtra formulariorentaextraLocal:formulariorentaextras) {		
				if(formulariorentaextraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FormularioRentaExtraLogicAdditional.updateFormularioRentaExtraToSave(formulariorentaextraLocal,this.arrDatoGeneral);
	        	
				FormularioRentaExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),formulariorentaextraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFormularioRentaExtra(formulariorentaextraLocal)) {
					FormularioRentaExtraDataAccess.save(formulariorentaextraLocal, connexion);				
				} else {
					validadoTodosFormularioRentaExtra=false;
				}
			}
			
			if(!validadoTodosFormularioRentaExtra) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FormularioRentaExtraLogicAdditional.checkFormularioRentaExtraToSavesAfter(formulariorentaextras,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFormularioRentaExtras();
			
			connexion.commit();		
			
			this.quitarFormularioRentaExtrasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveFormularioRentaExtras()throws Exception {				
		 try {	
			FormularioRentaExtraLogicAdditional.checkFormularioRentaExtraToSaves(formulariorentaextras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosFormularioRentaExtra=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(FormularioRentaExtra formulariorentaextraLocal:formulariorentaextras) {				
				if(formulariorentaextraLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FormularioRentaExtraLogicAdditional.updateFormularioRentaExtraToSave(formulariorentaextraLocal,this.arrDatoGeneral);
	        	
				FormularioRentaExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),formulariorentaextraLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFormularioRentaExtra(formulariorentaextraLocal)) {				
					FormularioRentaExtraDataAccess.save(formulariorentaextraLocal, connexion);				
				} else {
					validadoTodosFormularioRentaExtra=false;
				}
			}
			
			if(!validadoTodosFormularioRentaExtra) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FormularioRentaExtraLogicAdditional.checkFormularioRentaExtraToSavesAfter(formulariorentaextras,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarFormularioRentaExtrasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FormularioRentaExtraParameterReturnGeneral procesarAccionFormularioRentaExtras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FormularioRentaExtra> formulariorentaextras,FormularioRentaExtraParameterReturnGeneral formulariorentaextraParameterGeneral)throws Exception {
		 try {	
			FormularioRentaExtraParameterReturnGeneral formulariorentaextraReturnGeneral=new FormularioRentaExtraParameterReturnGeneral();
	
			FormularioRentaExtraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,formulariorentaextras,formulariorentaextraParameterGeneral,formulariorentaextraReturnGeneral);
			
			return formulariorentaextraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FormularioRentaExtraParameterReturnGeneral procesarAccionFormularioRentaExtrasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FormularioRentaExtra> formulariorentaextras,FormularioRentaExtraParameterReturnGeneral formulariorentaextraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRentaExtra.class.getSimpleName()+"-procesarAccionFormularioRentaExtrasWithConnection");connexion.begin();			
			
			FormularioRentaExtraParameterReturnGeneral formulariorentaextraReturnGeneral=new FormularioRentaExtraParameterReturnGeneral();
	
			FormularioRentaExtraLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,formulariorentaextras,formulariorentaextraParameterGeneral,formulariorentaextraReturnGeneral);
			
			this.connexion.commit();
			
			return formulariorentaextraReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FormularioRentaExtraParameterReturnGeneral procesarEventosFormularioRentaExtras(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<FormularioRentaExtra> formulariorentaextras,FormularioRentaExtra formulariorentaextra,FormularioRentaExtraParameterReturnGeneral formulariorentaextraParameterGeneral,Boolean isEsNuevoFormularioRentaExtra,ArrayList<Classe> clases)throws Exception {
		 try {	
			FormularioRentaExtraParameterReturnGeneral formulariorentaextraReturnGeneral=new FormularioRentaExtraParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				formulariorentaextraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FormularioRentaExtraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,formulariorentaextras,formulariorentaextra,formulariorentaextraParameterGeneral,formulariorentaextraReturnGeneral,isEsNuevoFormularioRentaExtra,clases);
			
			return formulariorentaextraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public FormularioRentaExtraParameterReturnGeneral procesarEventosFormularioRentaExtrasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<FormularioRentaExtra> formulariorentaextras,FormularioRentaExtra formulariorentaextra,FormularioRentaExtraParameterReturnGeneral formulariorentaextraParameterGeneral,Boolean isEsNuevoFormularioRentaExtra,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRentaExtra.class.getSimpleName()+"-procesarEventosFormularioRentaExtrasWithConnection");connexion.begin();			
			
			FormularioRentaExtraParameterReturnGeneral formulariorentaextraReturnGeneral=new FormularioRentaExtraParameterReturnGeneral();
	
			formulariorentaextraReturnGeneral.setFormularioRentaExtra(formulariorentaextra);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				formulariorentaextraReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FormularioRentaExtraLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,formulariorentaextras,formulariorentaextra,formulariorentaextraParameterGeneral,formulariorentaextraReturnGeneral,isEsNuevoFormularioRentaExtra,clases);
			
			this.connexion.commit();
			
			return formulariorentaextraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FormularioRentaExtraParameterReturnGeneral procesarImportacionFormularioRentaExtrasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,FormularioRentaExtraParameterReturnGeneral formulariorentaextraParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRentaExtra.class.getSimpleName()+"-procesarImportacionFormularioRentaExtrasWithConnection");connexion.begin();			
			
			FormularioRentaExtraParameterReturnGeneral formulariorentaextraReturnGeneral=new FormularioRentaExtraParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.formulariorentaextras=new ArrayList<FormularioRentaExtra>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.formulariorentaextra=new FormularioRentaExtra();
				
				
				if(conColumnasBase) {this.formulariorentaextra.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.formulariorentaextra.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.formulariorentaextra.setpago_previo(Double.parseDouble(arrColumnas[iColumn++]));
				this.formulariorentaextra.setinteres_mora(Double.parseDouble(arrColumnas[iColumn++]));
				this.formulariorentaextra.setvalor_multa(Double.parseDouble(arrColumnas[iColumn++]));
				this.formulariorentaextra.setforma_pago1(Double.parseDouble(arrColumnas[iColumn++]));
				this.formulariorentaextra.setforma_pago2(Double.parseDouble(arrColumnas[iColumn++]));
				this.formulariorentaextra.setnumero_nota_credito1(arrColumnas[iColumn++]);
				this.formulariorentaextra.setnumero_nota_credito2(arrColumnas[iColumn++]);
				this.formulariorentaextra.setnumero_nota_credito3(arrColumnas[iColumn++]);
				this.formulariorentaextra.setnumero_nota_credito4(arrColumnas[iColumn++]);
				this.formulariorentaextra.setvalor_nota_credito1(Double.parseDouble(arrColumnas[iColumn++]));
				this.formulariorentaextra.setvalor_nota_credito2(Double.parseDouble(arrColumnas[iColumn++]));
				this.formulariorentaextra.setvalor_nota_credito3(Double.parseDouble(arrColumnas[iColumn++]));
				this.formulariorentaextra.setvalor_nota_credito4(Double.parseDouble(arrColumnas[iColumn++]));
				this.formulariorentaextra.setnumero_comprobante1(arrColumnas[iColumn++]);
				this.formulariorentaextra.setnumero_comprobante2(arrColumnas[iColumn++]);
				this.formulariorentaextra.setvalor_comprobante1(Double.parseDouble(arrColumnas[iColumn++]));
				this.formulariorentaextra.setvalor_comprobante2(Double.parseDouble(arrColumnas[iColumn++]));
				this.formulariorentaextra.setvalor301(Double.parseDouble(arrColumnas[iColumn++]));
				this.formulariorentaextra.setvalor303(Double.parseDouble(arrColumnas[iColumn++]));
				this.formulariorentaextra.setvalor305(Double.parseDouble(arrColumnas[iColumn++]));
				this.formulariorentaextra.setvalor307(Double.parseDouble(arrColumnas[iColumn++]));
				this.formulariorentaextra.setvalor351(Double.parseDouble(arrColumnas[iColumn++]));
				this.formulariorentaextra.setvalor355(Double.parseDouble(arrColumnas[iColumn++]));
				this.formulariorentaextra.setvalor357(Double.parseDouble(arrColumnas[iColumn++]));
				this.formulariorentaextra.setvalor359(Double.parseDouble(arrColumnas[iColumn++]));
				this.formulariorentaextra.setvalor361(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.formulariorentaextras.add(this.formulariorentaextra);
			}
			
			this.saveFormularioRentaExtras();
			
			this.connexion.commit();
			
			formulariorentaextraReturnGeneral.setConRetornoEstaProcesado(true);
			formulariorentaextraReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return formulariorentaextraReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarFormularioRentaExtrasEliminados() throws Exception {				
		
		List<FormularioRentaExtra> formulariorentaextrasAux= new ArrayList<FormularioRentaExtra>();
		
		for(FormularioRentaExtra formulariorentaextra:formulariorentaextras) {
			if(!formulariorentaextra.getIsDeleted()) {
				formulariorentaextrasAux.add(formulariorentaextra);
			}
		}
		
		formulariorentaextras=formulariorentaextrasAux;
	}
	
	public void quitarFormularioRentaExtrasNulos() throws Exception {				
		
		List<FormularioRentaExtra> formulariorentaextrasAux= new ArrayList<FormularioRentaExtra>();
		
		for(FormularioRentaExtra formulariorentaextra : this.formulariorentaextras) {
			if(formulariorentaextra==null) {
				formulariorentaextrasAux.add(formulariorentaextra);
			}
		}
		
		//this.formulariorentaextras=formulariorentaextrasAux;
		
		this.formulariorentaextras.removeAll(formulariorentaextrasAux);
	}
	
	public void getSetVersionRowFormularioRentaExtraWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(formulariorentaextra.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((formulariorentaextra.getIsDeleted() || (formulariorentaextra.getIsChanged()&&!formulariorentaextra.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=formulariorentaextraDataAccess.getSetVersionRowFormularioRentaExtra(connexion,formulariorentaextra.getId());
				
				if(!formulariorentaextra.getVersionRow().equals(timestamp)) {	
					formulariorentaextra.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				formulariorentaextra.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowFormularioRentaExtra()throws Exception {	
		
		if(formulariorentaextra.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((formulariorentaextra.getIsDeleted() || (formulariorentaextra.getIsChanged()&&!formulariorentaextra.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=formulariorentaextraDataAccess.getSetVersionRowFormularioRentaExtra(connexion,formulariorentaextra.getId());
			
			try {							
				if(!formulariorentaextra.getVersionRow().equals(timestamp)) {	
					formulariorentaextra.setVersionRow(timestamp);
				}
				
				formulariorentaextra.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowFormularioRentaExtrasWithConnection()throws Exception {	
		if(formulariorentaextras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(FormularioRentaExtra formulariorentaextraAux:formulariorentaextras) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(formulariorentaextraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(formulariorentaextraAux.getIsDeleted() || (formulariorentaextraAux.getIsChanged()&&!formulariorentaextraAux.getIsNew())) {
						
						timestamp=formulariorentaextraDataAccess.getSetVersionRowFormularioRentaExtra(connexion,formulariorentaextraAux.getId());
						
						if(!formulariorentaextra.getVersionRow().equals(timestamp)) {	
							formulariorentaextraAux.setVersionRow(timestamp);
						}
								
						formulariorentaextraAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowFormularioRentaExtras()throws Exception {	
		if(formulariorentaextras!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(FormularioRentaExtra formulariorentaextraAux:formulariorentaextras) {
					if(formulariorentaextraAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(formulariorentaextraAux.getIsDeleted() || (formulariorentaextraAux.getIsChanged()&&!formulariorentaextraAux.getIsNew())) {
						
						timestamp=formulariorentaextraDataAccess.getSetVersionRowFormularioRentaExtra(connexion,formulariorentaextraAux.getId());
						
						if(!formulariorentaextraAux.getVersionRow().equals(timestamp)) {	
							formulariorentaextraAux.setVersionRow(timestamp);
						}
						
													
						formulariorentaextraAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public FormularioRentaExtraParameterReturnGeneral cargarCombosLoteForeignKeyFormularioRentaExtraWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalDatoFormularioRenta,String finalQueryGlobalFormaPago,String finalQueryGlobalBanco) throws Exception {
		FormularioRentaExtraParameterReturnGeneral  formulariorentaextraReturnGeneral =new FormularioRentaExtraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRentaExtra.class.getSimpleName()+"-cargarCombosLoteForeignKeyFormularioRentaExtraWithConnection");connexion.begin();
			
			formulariorentaextraReturnGeneral =new FormularioRentaExtraParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			formulariorentaextraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			formulariorentaextraReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			formulariorentaextraReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<DatoFormularioRenta> datoformulariorentasForeignKey=new ArrayList<DatoFormularioRenta>();
			DatoFormularioRentaLogic datoformulariorentaLogic=new DatoFormularioRentaLogic();
			datoformulariorentaLogic.setConnexion(this.connexion);
			datoformulariorentaLogic.getDatoFormularioRentaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDatoFormularioRenta.equals("NONE")) {
				datoformulariorentaLogic.getTodosDatoFormularioRentas(finalQueryGlobalDatoFormularioRenta,new Pagination());
				datoformulariorentasForeignKey=datoformulariorentaLogic.getDatoFormularioRentas();
			}

			formulariorentaextraReturnGeneral.setdatoformulariorentasForeignKey(datoformulariorentasForeignKey);


			List<FormaPago> formapagosForeignKey=new ArrayList<FormaPago>();
			FormaPagoLogic formapagoLogic=new FormaPagoLogic();
			formapagoLogic.setConnexion(this.connexion);
			formapagoLogic.getFormaPagoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormaPago.equals("NONE")) {
				formapagoLogic.getTodosFormaPagos(finalQueryGlobalFormaPago,new Pagination());
				formapagosForeignKey=formapagoLogic.getFormaPagos();
			}

			formulariorentaextraReturnGeneral.setformapagosForeignKey(formapagosForeignKey);


			List<Banco> bancosForeignKey=new ArrayList<Banco>();
			BancoLogic bancoLogic=new BancoLogic();
			bancoLogic.setConnexion(this.connexion);
			bancoLogic.getBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBanco.equals("NONE")) {
				bancoLogic.getTodosBancos(finalQueryGlobalBanco,new Pagination());
				bancosForeignKey=bancoLogic.getBancos();
			}

			formulariorentaextraReturnGeneral.setbancosForeignKey(bancosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return formulariorentaextraReturnGeneral;
	}
	
	public FormularioRentaExtraParameterReturnGeneral cargarCombosLoteForeignKeyFormularioRentaExtra(String finalQueryGlobalEmpresa,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalDatoFormularioRenta,String finalQueryGlobalFormaPago,String finalQueryGlobalBanco) throws Exception {
		FormularioRentaExtraParameterReturnGeneral  formulariorentaextraReturnGeneral =new FormularioRentaExtraParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			formulariorentaextraReturnGeneral =new FormularioRentaExtraParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			formulariorentaextraReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			formulariorentaextraReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			formulariorentaextraReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<DatoFormularioRenta> datoformulariorentasForeignKey=new ArrayList<DatoFormularioRenta>();
			DatoFormularioRentaLogic datoformulariorentaLogic=new DatoFormularioRentaLogic();
			datoformulariorentaLogic.setConnexion(this.connexion);
			datoformulariorentaLogic.getDatoFormularioRentaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDatoFormularioRenta.equals("NONE")) {
				datoformulariorentaLogic.getTodosDatoFormularioRentas(finalQueryGlobalDatoFormularioRenta,new Pagination());
				datoformulariorentasForeignKey=datoformulariorentaLogic.getDatoFormularioRentas();
			}

			formulariorentaextraReturnGeneral.setdatoformulariorentasForeignKey(datoformulariorentasForeignKey);


			List<FormaPago> formapagosForeignKey=new ArrayList<FormaPago>();
			FormaPagoLogic formapagoLogic=new FormaPagoLogic();
			formapagoLogic.setConnexion(this.connexion);
			formapagoLogic.getFormaPagoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFormaPago.equals("NONE")) {
				formapagoLogic.getTodosFormaPagos(finalQueryGlobalFormaPago,new Pagination());
				formapagosForeignKey=formapagoLogic.getFormaPagos();
			}

			formulariorentaextraReturnGeneral.setformapagosForeignKey(formapagosForeignKey);


			List<Banco> bancosForeignKey=new ArrayList<Banco>();
			BancoLogic bancoLogic=new BancoLogic();
			bancoLogic.setConnexion(this.connexion);
			bancoLogic.getBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBanco.equals("NONE")) {
				bancoLogic.getTodosBancos(finalQueryGlobalBanco,new Pagination());
				bancosForeignKey=bancoLogic.getBancos();
			}

			formulariorentaextraReturnGeneral.setbancosForeignKey(bancosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return formulariorentaextraReturnGeneral;
	}
	
	
	public void deepLoad(FormularioRentaExtra formulariorentaextra,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			FormularioRentaExtraLogicAdditional.updateFormularioRentaExtraToGet(formulariorentaextra,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		formulariorentaextra.setEmpresa(formulariorentaextraDataAccess.getEmpresa(connexion,formulariorentaextra));
		formulariorentaextra.setEjercicio(formulariorentaextraDataAccess.getEjercicio(connexion,formulariorentaextra));
		formulariorentaextra.setPeriodo(formulariorentaextraDataAccess.getPeriodo(connexion,formulariorentaextra));
		formulariorentaextra.setDatoFormularioRenta(formulariorentaextraDataAccess.getDatoFormularioRenta(connexion,formulariorentaextra));
		formulariorentaextra.setFormaPago(formulariorentaextraDataAccess.getFormaPago(connexion,formulariorentaextra));
		formulariorentaextra.setBanco(formulariorentaextraDataAccess.getBanco(connexion,formulariorentaextra));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				formulariorentaextra.setEmpresa(formulariorentaextraDataAccess.getEmpresa(connexion,formulariorentaextra));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				formulariorentaextra.setEjercicio(formulariorentaextraDataAccess.getEjercicio(connexion,formulariorentaextra));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				formulariorentaextra.setPeriodo(formulariorentaextraDataAccess.getPeriodo(connexion,formulariorentaextra));
				continue;
			}

			if(clas.clas.equals(DatoFormularioRenta.class)) {
				formulariorentaextra.setDatoFormularioRenta(formulariorentaextraDataAccess.getDatoFormularioRenta(connexion,formulariorentaextra));
				continue;
			}

			if(clas.clas.equals(FormaPago.class)) {
				formulariorentaextra.setFormaPago(formulariorentaextraDataAccess.getFormaPago(connexion,formulariorentaextra));
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				formulariorentaextra.setBanco(formulariorentaextraDataAccess.getBanco(connexion,formulariorentaextra));
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
			formulariorentaextra.setEmpresa(formulariorentaextraDataAccess.getEmpresa(connexion,formulariorentaextra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formulariorentaextra.setEjercicio(formulariorentaextraDataAccess.getEjercicio(connexion,formulariorentaextra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formulariorentaextra.setPeriodo(formulariorentaextraDataAccess.getPeriodo(connexion,formulariorentaextra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DatoFormularioRenta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formulariorentaextra.setDatoFormularioRenta(formulariorentaextraDataAccess.getDatoFormularioRenta(connexion,formulariorentaextra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormaPago.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formulariorentaextra.setFormaPago(formulariorentaextraDataAccess.getFormaPago(connexion,formulariorentaextra));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Banco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formulariorentaextra.setBanco(formulariorentaextraDataAccess.getBanco(connexion,formulariorentaextra));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		formulariorentaextra.setEmpresa(formulariorentaextraDataAccess.getEmpresa(connexion,formulariorentaextra));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(formulariorentaextra.getEmpresa(),isDeep,deepLoadType,clases);
				
		formulariorentaextra.setEjercicio(formulariorentaextraDataAccess.getEjercicio(connexion,formulariorentaextra));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(formulariorentaextra.getEjercicio(),isDeep,deepLoadType,clases);
				
		formulariorentaextra.setPeriodo(formulariorentaextraDataAccess.getPeriodo(connexion,formulariorentaextra));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(formulariorentaextra.getPeriodo(),isDeep,deepLoadType,clases);
				
		formulariorentaextra.setDatoFormularioRenta(formulariorentaextraDataAccess.getDatoFormularioRenta(connexion,formulariorentaextra));
		DatoFormularioRentaLogic datoformulariorentaLogic= new DatoFormularioRentaLogic(connexion);
		datoformulariorentaLogic.deepLoad(formulariorentaextra.getDatoFormularioRenta(),isDeep,deepLoadType,clases);
				
		formulariorentaextra.setFormaPago(formulariorentaextraDataAccess.getFormaPago(connexion,formulariorentaextra));
		FormaPagoLogic formapagoLogic= new FormaPagoLogic(connexion);
		formapagoLogic.deepLoad(formulariorentaextra.getFormaPago(),isDeep,deepLoadType,clases);
				
		formulariorentaextra.setBanco(formulariorentaextraDataAccess.getBanco(connexion,formulariorentaextra));
		BancoLogic bancoLogic= new BancoLogic(connexion);
		bancoLogic.deepLoad(formulariorentaextra.getBanco(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				formulariorentaextra.setEmpresa(formulariorentaextraDataAccess.getEmpresa(connexion,formulariorentaextra));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(formulariorentaextra.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				formulariorentaextra.setEjercicio(formulariorentaextraDataAccess.getEjercicio(connexion,formulariorentaextra));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(formulariorentaextra.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				formulariorentaextra.setPeriodo(formulariorentaextraDataAccess.getPeriodo(connexion,formulariorentaextra));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(formulariorentaextra.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DatoFormularioRenta.class)) {
				formulariorentaextra.setDatoFormularioRenta(formulariorentaextraDataAccess.getDatoFormularioRenta(connexion,formulariorentaextra));
				DatoFormularioRentaLogic datoformulariorentaLogic= new DatoFormularioRentaLogic(connexion);
				datoformulariorentaLogic.deepLoad(formulariorentaextra.getDatoFormularioRenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(FormaPago.class)) {
				formulariorentaextra.setFormaPago(formulariorentaextraDataAccess.getFormaPago(connexion,formulariorentaextra));
				FormaPagoLogic formapagoLogic= new FormaPagoLogic(connexion);
				formapagoLogic.deepLoad(formulariorentaextra.getFormaPago(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				formulariorentaextra.setBanco(formulariorentaextraDataAccess.getBanco(connexion,formulariorentaextra));
				BancoLogic bancoLogic= new BancoLogic(connexion);
				bancoLogic.deepLoad(formulariorentaextra.getBanco(),isDeep,deepLoadType,clases);				
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
			formulariorentaextra.setEmpresa(formulariorentaextraDataAccess.getEmpresa(connexion,formulariorentaextra));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(formulariorentaextra.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formulariorentaextra.setEjercicio(formulariorentaextraDataAccess.getEjercicio(connexion,formulariorentaextra));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(formulariorentaextra.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formulariorentaextra.setPeriodo(formulariorentaextraDataAccess.getPeriodo(connexion,formulariorentaextra));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(formulariorentaextra.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(DatoFormularioRenta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formulariorentaextra.setDatoFormularioRenta(formulariorentaextraDataAccess.getDatoFormularioRenta(connexion,formulariorentaextra));
			DatoFormularioRentaLogic datoformulariorentaLogic= new DatoFormularioRentaLogic(connexion);
			datoformulariorentaLogic.deepLoad(formulariorentaextra.getDatoFormularioRenta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(FormaPago.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formulariorentaextra.setFormaPago(formulariorentaextraDataAccess.getFormaPago(connexion,formulariorentaextra));
			FormaPagoLogic formapagoLogic= new FormaPagoLogic(connexion);
			formapagoLogic.deepLoad(formulariorentaextra.getFormaPago(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Banco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formulariorentaextra.setBanco(formulariorentaextraDataAccess.getBanco(connexion,formulariorentaextra));
			BancoLogic bancoLogic= new BancoLogic(connexion);
			bancoLogic.deepLoad(formulariorentaextra.getBanco(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(FormularioRentaExtra formulariorentaextra,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			FormularioRentaExtraLogicAdditional.updateFormularioRentaExtraToSave(formulariorentaextra,this.arrDatoGeneral);
			
FormularioRentaExtraDataAccess.save(formulariorentaextra, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(formulariorentaextra.getEmpresa(),connexion);

		EjercicioDataAccess.save(formulariorentaextra.getEjercicio(),connexion);

		PeriodoDataAccess.save(formulariorentaextra.getPeriodo(),connexion);

		DatoFormularioRentaDataAccess.save(formulariorentaextra.getDatoFormularioRenta(),connexion);

		FormaPagoDataAccess.save(formulariorentaextra.getFormaPago(),connexion);

		BancoDataAccess.save(formulariorentaextra.getBanco(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(formulariorentaextra.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(formulariorentaextra.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(formulariorentaextra.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(DatoFormularioRenta.class)) {
				DatoFormularioRentaDataAccess.save(formulariorentaextra.getDatoFormularioRenta(),connexion);
				continue;
			}

			if(clas.clas.equals(FormaPago.class)) {
				FormaPagoDataAccess.save(formulariorentaextra.getFormaPago(),connexion);
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				BancoDataAccess.save(formulariorentaextra.getBanco(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(formulariorentaextra.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(formulariorentaextra.getEmpresa(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(formulariorentaextra.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(formulariorentaextra.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(formulariorentaextra.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(formulariorentaextra.getPeriodo(),isDeep,deepLoadType,clases);
				

		DatoFormularioRentaDataAccess.save(formulariorentaextra.getDatoFormularioRenta(),connexion);
		DatoFormularioRentaLogic datoformulariorentaLogic= new DatoFormularioRentaLogic(connexion);
		datoformulariorentaLogic.deepLoad(formulariorentaextra.getDatoFormularioRenta(),isDeep,deepLoadType,clases);
				

		FormaPagoDataAccess.save(formulariorentaextra.getFormaPago(),connexion);
		FormaPagoLogic formapagoLogic= new FormaPagoLogic(connexion);
		formapagoLogic.deepLoad(formulariorentaextra.getFormaPago(),isDeep,deepLoadType,clases);
				

		BancoDataAccess.save(formulariorentaextra.getBanco(),connexion);
		BancoLogic bancoLogic= new BancoLogic(connexion);
		bancoLogic.deepLoad(formulariorentaextra.getBanco(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(formulariorentaextra.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(formulariorentaextra.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(formulariorentaextra.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(formulariorentaextra.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(formulariorentaextra.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(formulariorentaextra.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DatoFormularioRenta.class)) {
				DatoFormularioRentaDataAccess.save(formulariorentaextra.getDatoFormularioRenta(),connexion);
				DatoFormularioRentaLogic datoformulariorentaLogic= new DatoFormularioRentaLogic(connexion);
				datoformulariorentaLogic.deepSave(formulariorentaextra.getDatoFormularioRenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(FormaPago.class)) {
				FormaPagoDataAccess.save(formulariorentaextra.getFormaPago(),connexion);
				FormaPagoLogic formapagoLogic= new FormaPagoLogic(connexion);
				formapagoLogic.deepSave(formulariorentaextra.getFormaPago(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				BancoDataAccess.save(formulariorentaextra.getBanco(),connexion);
				BancoLogic bancoLogic= new BancoLogic(connexion);
				bancoLogic.deepSave(formulariorentaextra.getBanco(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(FormularioRentaExtra.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(formulariorentaextra,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FormularioRentaExtraConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRentaExtra(formulariorentaextra);
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
			this.deepLoad(this.formulariorentaextra,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FormularioRentaExtraConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRentaExtra(this.formulariorentaextra);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(FormularioRentaExtra.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(formulariorentaextras!=null) {
				for(FormularioRentaExtra formulariorentaextra:formulariorentaextras) {
					this.deepLoad(formulariorentaextra,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					FormularioRentaExtraConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRentaExtra(formulariorentaextras);
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
			if(formulariorentaextras!=null) {
				for(FormularioRentaExtra formulariorentaextra:formulariorentaextras) {
					this.deepLoad(formulariorentaextra,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					FormularioRentaExtraConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRentaExtra(formulariorentaextras);
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
			this.getNewConnexionToDeep(FormularioRentaExtra.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(formulariorentaextra,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(FormularioRentaExtra.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(formulariorentaextras!=null) {
				for(FormularioRentaExtra formulariorentaextra:formulariorentaextras) {
					this.deepSave(formulariorentaextra,isDeep,deepLoadType,clases);
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
			if(formulariorentaextras!=null) {
				for(FormularioRentaExtra formulariorentaextra:formulariorentaextras) {
					this.deepSave(formulariorentaextra,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getFormularioRentaExtrasFK_IdBancoWithConnection(String sFinalQuery,Pagination pagination,Long id_banco)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRentaExtra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_banco,FormularioRentaExtraConstantesFunciones.IDBANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBanco);

			FormularioRentaExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formulariorentaextras=formulariorentaextraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioRentaExtraConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRentaExtra(this.formulariorentaextras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormularioRentaExtrasFK_IdBanco(String sFinalQuery,Pagination pagination,Long id_banco)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_banco,FormularioRentaExtraConstantesFunciones.IDBANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBanco);

			FormularioRentaExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formulariorentaextras=formulariorentaextraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioRentaExtraConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRentaExtra(this.formulariorentaextras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormularioRentaExtrasFK_IdDatoFormularioRentaWithConnection(String sFinalQuery,Pagination pagination,Long id_dato_formulario_renta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRentaExtra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDatoFormularioRenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDatoFormularioRenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_dato_formulario_renta,FormularioRentaExtraConstantesFunciones.IDDATOFORMULARIORENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDatoFormularioRenta);

			FormularioRentaExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDatoFormularioRenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formulariorentaextras=formulariorentaextraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioRentaExtraConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRentaExtra(this.formulariorentaextras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormularioRentaExtrasFK_IdDatoFormularioRenta(String sFinalQuery,Pagination pagination,Long id_dato_formulario_renta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDatoFormularioRenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDatoFormularioRenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_dato_formulario_renta,FormularioRentaExtraConstantesFunciones.IDDATOFORMULARIORENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDatoFormularioRenta);

			FormularioRentaExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDatoFormularioRenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formulariorentaextras=formulariorentaextraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioRentaExtraConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRentaExtra(this.formulariorentaextras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormularioRentaExtrasFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRentaExtra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,FormularioRentaExtraConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			FormularioRentaExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formulariorentaextras=formulariorentaextraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioRentaExtraConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRentaExtra(this.formulariorentaextras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormularioRentaExtrasFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,FormularioRentaExtraConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			FormularioRentaExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formulariorentaextras=formulariorentaextraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioRentaExtraConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRentaExtra(this.formulariorentaextras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormularioRentaExtrasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRentaExtra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FormularioRentaExtraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FormularioRentaExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formulariorentaextras=formulariorentaextraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioRentaExtraConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRentaExtra(this.formulariorentaextras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormularioRentaExtrasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FormularioRentaExtraConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FormularioRentaExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formulariorentaextras=formulariorentaextraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioRentaExtraConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRentaExtra(this.formulariorentaextras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormularioRentaExtrasFK_IdFormaPagoWithConnection(String sFinalQuery,Pagination pagination,Long id_forma_pago)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRentaExtra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormaPago= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormaPago.setParameterSelectionGeneralEqual(ParameterType.LONG,id_forma_pago,FormularioRentaExtraConstantesFunciones.IDFORMAPAGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormaPago);

			FormularioRentaExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormaPago","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formulariorentaextras=formulariorentaextraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioRentaExtraConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRentaExtra(this.formulariorentaextras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormularioRentaExtrasFK_IdFormaPago(String sFinalQuery,Pagination pagination,Long id_forma_pago)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFormaPago= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFormaPago.setParameterSelectionGeneralEqual(ParameterType.LONG,id_forma_pago,FormularioRentaExtraConstantesFunciones.IDFORMAPAGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFormaPago);

			FormularioRentaExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFormaPago","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formulariorentaextras=formulariorentaextraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioRentaExtraConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRentaExtra(this.formulariorentaextras);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormularioRentaExtrasFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRentaExtra.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,FormularioRentaExtraConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			FormularioRentaExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formulariorentaextras=formulariorentaextraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioRentaExtraConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRentaExtra(this.formulariorentaextras);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormularioRentaExtrasFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,FormularioRentaExtraConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			FormularioRentaExtraLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formulariorentaextras=formulariorentaextraDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioRentaExtraConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRentaExtra(this.formulariorentaextras);
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
			if(FormularioRentaExtraConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,FormularioRentaExtraDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,FormularioRentaExtra formulariorentaextra,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(FormularioRentaExtraConstantesFunciones.ISCONAUDITORIA) {
				if(formulariorentaextra.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FormularioRentaExtraDataAccess.TABLENAME, formulariorentaextra.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FormularioRentaExtraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FormularioRentaExtraLogic.registrarAuditoriaDetallesFormularioRentaExtra(connexion,formulariorentaextra,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(formulariorentaextra.getIsDeleted()) {
					/*if(!formulariorentaextra.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,FormularioRentaExtraDataAccess.TABLENAME, formulariorentaextra.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////FormularioRentaExtraLogic.registrarAuditoriaDetallesFormularioRentaExtra(connexion,formulariorentaextra,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FormularioRentaExtraDataAccess.TABLENAME, formulariorentaextra.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(formulariorentaextra.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FormularioRentaExtraDataAccess.TABLENAME, formulariorentaextra.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FormularioRentaExtraConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FormularioRentaExtraLogic.registrarAuditoriaDetallesFormularioRentaExtra(connexion,formulariorentaextra,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesFormularioRentaExtra(Connexion connexion,FormularioRentaExtra formulariorentaextra)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(formulariorentaextra.getIsNew()||!formulariorentaextra.getid_empresa().equals(formulariorentaextra.getFormularioRentaExtraOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorentaextra.getFormularioRentaExtraOriginal().getid_empresa()!=null)
				{
					strValorActual=formulariorentaextra.getFormularioRentaExtraOriginal().getid_empresa().toString();
				}
				if(formulariorentaextra.getid_empresa()!=null)
				{
					strValorNuevo=formulariorentaextra.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaExtraConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(formulariorentaextra.getIsNew()||!formulariorentaextra.getid_ejercicio().equals(formulariorentaextra.getFormularioRentaExtraOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorentaextra.getFormularioRentaExtraOriginal().getid_ejercicio()!=null)
				{
					strValorActual=formulariorentaextra.getFormularioRentaExtraOriginal().getid_ejercicio().toString();
				}
				if(formulariorentaextra.getid_ejercicio()!=null)
				{
					strValorNuevo=formulariorentaextra.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaExtraConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(formulariorentaextra.getIsNew()||!formulariorentaextra.getid_periodo().equals(formulariorentaextra.getFormularioRentaExtraOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorentaextra.getFormularioRentaExtraOriginal().getid_periodo()!=null)
				{
					strValorActual=formulariorentaextra.getFormularioRentaExtraOriginal().getid_periodo().toString();
				}
				if(formulariorentaextra.getid_periodo()!=null)
				{
					strValorNuevo=formulariorentaextra.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaExtraConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(formulariorentaextra.getIsNew()||!formulariorentaextra.getid_dato_formulario_renta().equals(formulariorentaextra.getFormularioRentaExtraOriginal().getid_dato_formulario_renta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorentaextra.getFormularioRentaExtraOriginal().getid_dato_formulario_renta()!=null)
				{
					strValorActual=formulariorentaextra.getFormularioRentaExtraOriginal().getid_dato_formulario_renta().toString();
				}
				if(formulariorentaextra.getid_dato_formulario_renta()!=null)
				{
					strValorNuevo=formulariorentaextra.getid_dato_formulario_renta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaExtraConstantesFunciones.IDDATOFORMULARIORENTA,strValorActual,strValorNuevo);
			}	
			
			if(formulariorentaextra.getIsNew()||!formulariorentaextra.getid_forma_pago().equals(formulariorentaextra.getFormularioRentaExtraOriginal().getid_forma_pago()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorentaextra.getFormularioRentaExtraOriginal().getid_forma_pago()!=null)
				{
					strValorActual=formulariorentaextra.getFormularioRentaExtraOriginal().getid_forma_pago().toString();
				}
				if(formulariorentaextra.getid_forma_pago()!=null)
				{
					strValorNuevo=formulariorentaextra.getid_forma_pago().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaExtraConstantesFunciones.IDFORMAPAGO,strValorActual,strValorNuevo);
			}	
			
			if(formulariorentaextra.getIsNew()||!formulariorentaextra.getid_banco().equals(formulariorentaextra.getFormularioRentaExtraOriginal().getid_banco()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorentaextra.getFormularioRentaExtraOriginal().getid_banco()!=null)
				{
					strValorActual=formulariorentaextra.getFormularioRentaExtraOriginal().getid_banco().toString();
				}
				if(formulariorentaextra.getid_banco()!=null)
				{
					strValorNuevo=formulariorentaextra.getid_banco().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaExtraConstantesFunciones.IDBANCO,strValorActual,strValorNuevo);
			}	
			
			if(formulariorentaextra.getIsNew()||!formulariorentaextra.getpago_previo().equals(formulariorentaextra.getFormularioRentaExtraOriginal().getpago_previo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorentaextra.getFormularioRentaExtraOriginal().getpago_previo()!=null)
				{
					strValorActual=formulariorentaextra.getFormularioRentaExtraOriginal().getpago_previo().toString();
				}
				if(formulariorentaextra.getpago_previo()!=null)
				{
					strValorNuevo=formulariorentaextra.getpago_previo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaExtraConstantesFunciones.PAGOPREVIO,strValorActual,strValorNuevo);
			}	
			
			if(formulariorentaextra.getIsNew()||!formulariorentaextra.getinteres_mora().equals(formulariorentaextra.getFormularioRentaExtraOriginal().getinteres_mora()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorentaextra.getFormularioRentaExtraOriginal().getinteres_mora()!=null)
				{
					strValorActual=formulariorentaextra.getFormularioRentaExtraOriginal().getinteres_mora().toString();
				}
				if(formulariorentaextra.getinteres_mora()!=null)
				{
					strValorNuevo=formulariorentaextra.getinteres_mora().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaExtraConstantesFunciones.INTERESMORA,strValorActual,strValorNuevo);
			}	
			
			if(formulariorentaextra.getIsNew()||!formulariorentaextra.getvalor_multa().equals(formulariorentaextra.getFormularioRentaExtraOriginal().getvalor_multa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorentaextra.getFormularioRentaExtraOriginal().getvalor_multa()!=null)
				{
					strValorActual=formulariorentaextra.getFormularioRentaExtraOriginal().getvalor_multa().toString();
				}
				if(formulariorentaextra.getvalor_multa()!=null)
				{
					strValorNuevo=formulariorentaextra.getvalor_multa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaExtraConstantesFunciones.VALORMULTA,strValorActual,strValorNuevo);
			}	
			
			if(formulariorentaextra.getIsNew()||!formulariorentaextra.getforma_pago1().equals(formulariorentaextra.getFormularioRentaExtraOriginal().getforma_pago1()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorentaextra.getFormularioRentaExtraOriginal().getforma_pago1()!=null)
				{
					strValorActual=formulariorentaextra.getFormularioRentaExtraOriginal().getforma_pago1().toString();
				}
				if(formulariorentaextra.getforma_pago1()!=null)
				{
					strValorNuevo=formulariorentaextra.getforma_pago1().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaExtraConstantesFunciones.FORMAPAGO1,strValorActual,strValorNuevo);
			}	
			
			if(formulariorentaextra.getIsNew()||!formulariorentaextra.getforma_pago2().equals(formulariorentaextra.getFormularioRentaExtraOriginal().getforma_pago2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorentaextra.getFormularioRentaExtraOriginal().getforma_pago2()!=null)
				{
					strValorActual=formulariorentaextra.getFormularioRentaExtraOriginal().getforma_pago2().toString();
				}
				if(formulariorentaextra.getforma_pago2()!=null)
				{
					strValorNuevo=formulariorentaextra.getforma_pago2().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaExtraConstantesFunciones.FORMAPAGO2,strValorActual,strValorNuevo);
			}	
			
			if(formulariorentaextra.getIsNew()||!formulariorentaextra.getnumero_nota_credito1().equals(formulariorentaextra.getFormularioRentaExtraOriginal().getnumero_nota_credito1()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorentaextra.getFormularioRentaExtraOriginal().getnumero_nota_credito1()!=null)
				{
					strValorActual=formulariorentaextra.getFormularioRentaExtraOriginal().getnumero_nota_credito1();
				}
				if(formulariorentaextra.getnumero_nota_credito1()!=null)
				{
					strValorNuevo=formulariorentaextra.getnumero_nota_credito1() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaExtraConstantesFunciones.NUMERONOTACREDITO1,strValorActual,strValorNuevo);
			}	
			
			if(formulariorentaextra.getIsNew()||!formulariorentaextra.getnumero_nota_credito2().equals(formulariorentaextra.getFormularioRentaExtraOriginal().getnumero_nota_credito2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorentaextra.getFormularioRentaExtraOriginal().getnumero_nota_credito2()!=null)
				{
					strValorActual=formulariorentaextra.getFormularioRentaExtraOriginal().getnumero_nota_credito2();
				}
				if(formulariorentaextra.getnumero_nota_credito2()!=null)
				{
					strValorNuevo=formulariorentaextra.getnumero_nota_credito2() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaExtraConstantesFunciones.NUMERONOTACREDITO2,strValorActual,strValorNuevo);
			}	
			
			if(formulariorentaextra.getIsNew()||!formulariorentaextra.getnumero_nota_credito3().equals(formulariorentaextra.getFormularioRentaExtraOriginal().getnumero_nota_credito3()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorentaextra.getFormularioRentaExtraOriginal().getnumero_nota_credito3()!=null)
				{
					strValorActual=formulariorentaextra.getFormularioRentaExtraOriginal().getnumero_nota_credito3();
				}
				if(formulariorentaextra.getnumero_nota_credito3()!=null)
				{
					strValorNuevo=formulariorentaextra.getnumero_nota_credito3() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaExtraConstantesFunciones.NUMERONOTACREDITO3,strValorActual,strValorNuevo);
			}	
			
			if(formulariorentaextra.getIsNew()||!formulariorentaextra.getnumero_nota_credito4().equals(formulariorentaextra.getFormularioRentaExtraOriginal().getnumero_nota_credito4()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorentaextra.getFormularioRentaExtraOriginal().getnumero_nota_credito4()!=null)
				{
					strValorActual=formulariorentaextra.getFormularioRentaExtraOriginal().getnumero_nota_credito4();
				}
				if(formulariorentaextra.getnumero_nota_credito4()!=null)
				{
					strValorNuevo=formulariorentaextra.getnumero_nota_credito4() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaExtraConstantesFunciones.NUMERONOTACREDITO4,strValorActual,strValorNuevo);
			}	
			
			if(formulariorentaextra.getIsNew()||!formulariorentaextra.getvalor_nota_credito1().equals(formulariorentaextra.getFormularioRentaExtraOriginal().getvalor_nota_credito1()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorentaextra.getFormularioRentaExtraOriginal().getvalor_nota_credito1()!=null)
				{
					strValorActual=formulariorentaextra.getFormularioRentaExtraOriginal().getvalor_nota_credito1().toString();
				}
				if(formulariorentaextra.getvalor_nota_credito1()!=null)
				{
					strValorNuevo=formulariorentaextra.getvalor_nota_credito1().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO1,strValorActual,strValorNuevo);
			}	
			
			if(formulariorentaextra.getIsNew()||!formulariorentaextra.getvalor_nota_credito2().equals(formulariorentaextra.getFormularioRentaExtraOriginal().getvalor_nota_credito2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorentaextra.getFormularioRentaExtraOriginal().getvalor_nota_credito2()!=null)
				{
					strValorActual=formulariorentaextra.getFormularioRentaExtraOriginal().getvalor_nota_credito2().toString();
				}
				if(formulariorentaextra.getvalor_nota_credito2()!=null)
				{
					strValorNuevo=formulariorentaextra.getvalor_nota_credito2().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO2,strValorActual,strValorNuevo);
			}	
			
			if(formulariorentaextra.getIsNew()||!formulariorentaextra.getvalor_nota_credito3().equals(formulariorentaextra.getFormularioRentaExtraOriginal().getvalor_nota_credito3()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorentaextra.getFormularioRentaExtraOriginal().getvalor_nota_credito3()!=null)
				{
					strValorActual=formulariorentaextra.getFormularioRentaExtraOriginal().getvalor_nota_credito3().toString();
				}
				if(formulariorentaextra.getvalor_nota_credito3()!=null)
				{
					strValorNuevo=formulariorentaextra.getvalor_nota_credito3().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO3,strValorActual,strValorNuevo);
			}	
			
			if(formulariorentaextra.getIsNew()||!formulariorentaextra.getvalor_nota_credito4().equals(formulariorentaextra.getFormularioRentaExtraOriginal().getvalor_nota_credito4()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorentaextra.getFormularioRentaExtraOriginal().getvalor_nota_credito4()!=null)
				{
					strValorActual=formulariorentaextra.getFormularioRentaExtraOriginal().getvalor_nota_credito4().toString();
				}
				if(formulariorentaextra.getvalor_nota_credito4()!=null)
				{
					strValorNuevo=formulariorentaextra.getvalor_nota_credito4().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaExtraConstantesFunciones.VALORNOTACREDITO4,strValorActual,strValorNuevo);
			}	
			
			if(formulariorentaextra.getIsNew()||!formulariorentaextra.getnumero_comprobante1().equals(formulariorentaextra.getFormularioRentaExtraOriginal().getnumero_comprobante1()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorentaextra.getFormularioRentaExtraOriginal().getnumero_comprobante1()!=null)
				{
					strValorActual=formulariorentaextra.getFormularioRentaExtraOriginal().getnumero_comprobante1();
				}
				if(formulariorentaextra.getnumero_comprobante1()!=null)
				{
					strValorNuevo=formulariorentaextra.getnumero_comprobante1() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaExtraConstantesFunciones.NUMEROCOMPROBANTE1,strValorActual,strValorNuevo);
			}	
			
			if(formulariorentaextra.getIsNew()||!formulariorentaextra.getnumero_comprobante2().equals(formulariorentaextra.getFormularioRentaExtraOriginal().getnumero_comprobante2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorentaextra.getFormularioRentaExtraOriginal().getnumero_comprobante2()!=null)
				{
					strValorActual=formulariorentaextra.getFormularioRentaExtraOriginal().getnumero_comprobante2();
				}
				if(formulariorentaextra.getnumero_comprobante2()!=null)
				{
					strValorNuevo=formulariorentaextra.getnumero_comprobante2() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaExtraConstantesFunciones.NUMEROCOMPROBANTE2,strValorActual,strValorNuevo);
			}	
			
			if(formulariorentaextra.getIsNew()||!formulariorentaextra.getvalor_comprobante1().equals(formulariorentaextra.getFormularioRentaExtraOriginal().getvalor_comprobante1()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorentaextra.getFormularioRentaExtraOriginal().getvalor_comprobante1()!=null)
				{
					strValorActual=formulariorentaextra.getFormularioRentaExtraOriginal().getvalor_comprobante1().toString();
				}
				if(formulariorentaextra.getvalor_comprobante1()!=null)
				{
					strValorNuevo=formulariorentaextra.getvalor_comprobante1().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaExtraConstantesFunciones.VALORCOMPROBANTE1,strValorActual,strValorNuevo);
			}	
			
			if(formulariorentaextra.getIsNew()||!formulariorentaextra.getvalor_comprobante2().equals(formulariorentaextra.getFormularioRentaExtraOriginal().getvalor_comprobante2()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorentaextra.getFormularioRentaExtraOriginal().getvalor_comprobante2()!=null)
				{
					strValorActual=formulariorentaextra.getFormularioRentaExtraOriginal().getvalor_comprobante2().toString();
				}
				if(formulariorentaextra.getvalor_comprobante2()!=null)
				{
					strValorNuevo=formulariorentaextra.getvalor_comprobante2().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaExtraConstantesFunciones.VALORCOMPROBANTE2,strValorActual,strValorNuevo);
			}	
			
			if(formulariorentaextra.getIsNew()||!formulariorentaextra.getvalor301().equals(formulariorentaextra.getFormularioRentaExtraOriginal().getvalor301()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorentaextra.getFormularioRentaExtraOriginal().getvalor301()!=null)
				{
					strValorActual=formulariorentaextra.getFormularioRentaExtraOriginal().getvalor301().toString();
				}
				if(formulariorentaextra.getvalor301()!=null)
				{
					strValorNuevo=formulariorentaextra.getvalor301().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaExtraConstantesFunciones.VALOR301,strValorActual,strValorNuevo);
			}	
			
			if(formulariorentaextra.getIsNew()||!formulariorentaextra.getvalor303().equals(formulariorentaextra.getFormularioRentaExtraOriginal().getvalor303()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorentaextra.getFormularioRentaExtraOriginal().getvalor303()!=null)
				{
					strValorActual=formulariorentaextra.getFormularioRentaExtraOriginal().getvalor303().toString();
				}
				if(formulariorentaextra.getvalor303()!=null)
				{
					strValorNuevo=formulariorentaextra.getvalor303().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaExtraConstantesFunciones.VALOR303,strValorActual,strValorNuevo);
			}	
			
			if(formulariorentaextra.getIsNew()||!formulariorentaextra.getvalor305().equals(formulariorentaextra.getFormularioRentaExtraOriginal().getvalor305()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorentaextra.getFormularioRentaExtraOriginal().getvalor305()!=null)
				{
					strValorActual=formulariorentaextra.getFormularioRentaExtraOriginal().getvalor305().toString();
				}
				if(formulariorentaextra.getvalor305()!=null)
				{
					strValorNuevo=formulariorentaextra.getvalor305().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaExtraConstantesFunciones.VALOR305,strValorActual,strValorNuevo);
			}	
			
			if(formulariorentaextra.getIsNew()||!formulariorentaextra.getvalor307().equals(formulariorentaextra.getFormularioRentaExtraOriginal().getvalor307()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorentaextra.getFormularioRentaExtraOriginal().getvalor307()!=null)
				{
					strValorActual=formulariorentaextra.getFormularioRentaExtraOriginal().getvalor307().toString();
				}
				if(formulariorentaextra.getvalor307()!=null)
				{
					strValorNuevo=formulariorentaextra.getvalor307().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaExtraConstantesFunciones.VALOR307,strValorActual,strValorNuevo);
			}	
			
			if(formulariorentaextra.getIsNew()||!formulariorentaextra.getvalor351().equals(formulariorentaextra.getFormularioRentaExtraOriginal().getvalor351()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorentaextra.getFormularioRentaExtraOriginal().getvalor351()!=null)
				{
					strValorActual=formulariorentaextra.getFormularioRentaExtraOriginal().getvalor351().toString();
				}
				if(formulariorentaextra.getvalor351()!=null)
				{
					strValorNuevo=formulariorentaextra.getvalor351().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaExtraConstantesFunciones.VALOR351,strValorActual,strValorNuevo);
			}	
			
			if(formulariorentaextra.getIsNew()||!formulariorentaextra.getvalor355().equals(formulariorentaextra.getFormularioRentaExtraOriginal().getvalor355()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorentaextra.getFormularioRentaExtraOriginal().getvalor355()!=null)
				{
					strValorActual=formulariorentaextra.getFormularioRentaExtraOriginal().getvalor355().toString();
				}
				if(formulariorentaextra.getvalor355()!=null)
				{
					strValorNuevo=formulariorentaextra.getvalor355().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaExtraConstantesFunciones.VALOR355,strValorActual,strValorNuevo);
			}	
			
			if(formulariorentaextra.getIsNew()||!formulariorentaextra.getvalor357().equals(formulariorentaextra.getFormularioRentaExtraOriginal().getvalor357()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorentaextra.getFormularioRentaExtraOriginal().getvalor357()!=null)
				{
					strValorActual=formulariorentaextra.getFormularioRentaExtraOriginal().getvalor357().toString();
				}
				if(formulariorentaextra.getvalor357()!=null)
				{
					strValorNuevo=formulariorentaextra.getvalor357().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaExtraConstantesFunciones.VALOR357,strValorActual,strValorNuevo);
			}	
			
			if(formulariorentaextra.getIsNew()||!formulariorentaextra.getvalor359().equals(formulariorentaextra.getFormularioRentaExtraOriginal().getvalor359()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorentaextra.getFormularioRentaExtraOriginal().getvalor359()!=null)
				{
					strValorActual=formulariorentaextra.getFormularioRentaExtraOriginal().getvalor359().toString();
				}
				if(formulariorentaextra.getvalor359()!=null)
				{
					strValorNuevo=formulariorentaextra.getvalor359().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaExtraConstantesFunciones.VALOR359,strValorActual,strValorNuevo);
			}	
			
			if(formulariorentaextra.getIsNew()||!formulariorentaextra.getvalor361().equals(formulariorentaextra.getFormularioRentaExtraOriginal().getvalor361()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorentaextra.getFormularioRentaExtraOriginal().getvalor361()!=null)
				{
					strValorActual=formulariorentaextra.getFormularioRentaExtraOriginal().getvalor361().toString();
				}
				if(formulariorentaextra.getvalor361()!=null)
				{
					strValorNuevo=formulariorentaextra.getvalor361().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaExtraConstantesFunciones.VALOR361,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveFormularioRentaExtraRelacionesWithConnection(FormularioRentaExtra formulariorentaextra) throws Exception {

		if(!formulariorentaextra.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFormularioRentaExtraRelacionesBase(formulariorentaextra,true);
		}
	}

	public void saveFormularioRentaExtraRelaciones(FormularioRentaExtra formulariorentaextra)throws Exception {

		if(!formulariorentaextra.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFormularioRentaExtraRelacionesBase(formulariorentaextra,false);
		}
	}

	public void saveFormularioRentaExtraRelacionesBase(FormularioRentaExtra formulariorentaextra,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("FormularioRentaExtra-saveRelacionesWithConnection");}
	

			this.setFormularioRentaExtra(formulariorentaextra);

			if(FormularioRentaExtraLogicAdditional.validarSaveRelaciones(formulariorentaextra,this)) {

				FormularioRentaExtraLogicAdditional.updateRelacionesToSave(formulariorentaextra,this);

				if((formulariorentaextra.getIsNew()||formulariorentaextra.getIsChanged())&&!formulariorentaextra.getIsDeleted()) {
					this.saveFormularioRentaExtra();
					this.saveFormularioRentaExtraRelacionesDetalles();

				} else if(formulariorentaextra.getIsDeleted()) {
					this.saveFormularioRentaExtraRelacionesDetalles();
					this.saveFormularioRentaExtra();
				}

				FormularioRentaExtraLogicAdditional.updateRelacionesToSaveAfter(formulariorentaextra,this);

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
	
	
	private void saveFormularioRentaExtraRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfFormularioRentaExtra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FormularioRentaExtraConstantesFunciones.getClassesForeignKeysOfFormularioRentaExtra(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFormularioRentaExtra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FormularioRentaExtraConstantesFunciones.getClassesRelationshipsOfFormularioRentaExtra(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

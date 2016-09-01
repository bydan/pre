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
import com.bydan.erp.contabilidad.util.FormularioIvaConstantesFunciones;
import com.bydan.erp.contabilidad.util.FormularioIvaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.FormularioIvaParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.FormularioIva;
import com.bydan.erp.contabilidad.business.logic.FormularioIvaLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class FormularioIvaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(FormularioIvaLogic.class);
	
	protected FormularioIvaDataAccess formularioivaDataAccess; 	
	protected FormularioIva formularioiva;
	protected List<FormularioIva> formularioivas;
	protected Object formularioivaObject;	
	protected List<Object> formularioivasObject;
	
	public static ClassValidator<FormularioIva> formularioivaValidator = new ClassValidator<FormularioIva>(FormularioIva.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected FormularioIvaLogicAdditional formularioivaLogicAdditional=null;
	
	public FormularioIvaLogicAdditional getFormularioIvaLogicAdditional() {
		return this.formularioivaLogicAdditional;
	}
	
	public void setFormularioIvaLogicAdditional(FormularioIvaLogicAdditional formularioivaLogicAdditional) {
		try {
			this.formularioivaLogicAdditional=formularioivaLogicAdditional;
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
	
	
	
	
	public  FormularioIvaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.formularioivaDataAccess = new FormularioIvaDataAccess();
			
			this.formularioivas= new ArrayList<FormularioIva>();
			this.formularioiva= new FormularioIva();
			
			this.formularioivaObject=new Object();
			this.formularioivasObject=new ArrayList<Object>();
				
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
			
			this.formularioivaDataAccess.setConnexionType(this.connexionType);
			this.formularioivaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  FormularioIvaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.formularioivaDataAccess = new FormularioIvaDataAccess();
			this.formularioivas= new ArrayList<FormularioIva>();
			this.formularioiva= new FormularioIva();
			this.formularioivaObject=new Object();
			this.formularioivasObject=new ArrayList<Object>();
			
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
			
			this.formularioivaDataAccess.setConnexionType(this.connexionType);
			this.formularioivaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public FormularioIva getFormularioIva() throws Exception {	
		FormularioIvaLogicAdditional.checkFormularioIvaToGet(formularioiva,this.datosCliente,this.arrDatoGeneral);
		FormularioIvaLogicAdditional.updateFormularioIvaToGet(formularioiva,this.arrDatoGeneral);
		
		return formularioiva;
	}
		
	public void setFormularioIva(FormularioIva newFormularioIva) {
		this.formularioiva = newFormularioIva;
	}
	
	public FormularioIvaDataAccess getFormularioIvaDataAccess() {
		return formularioivaDataAccess;
	}
	
	public void setFormularioIvaDataAccess(FormularioIvaDataAccess newformularioivaDataAccess) {
		this.formularioivaDataAccess = newformularioivaDataAccess;
	}
	
	public List<FormularioIva> getFormularioIvas() throws Exception {		
		this.quitarFormularioIvasNulos();
		
		FormularioIvaLogicAdditional.checkFormularioIvaToGets(formularioivas,this.datosCliente,this.arrDatoGeneral);
		
		for (FormularioIva formularioivaLocal: formularioivas ) {
			FormularioIvaLogicAdditional.updateFormularioIvaToGet(formularioivaLocal,this.arrDatoGeneral);
		}
		
		return formularioivas;
	}
	
	public void setFormularioIvas(List<FormularioIva> newFormularioIvas) {
		this.formularioivas = newFormularioIvas;
	}
	
	public Object getFormularioIvaObject() {	
		this.formularioivaObject=this.formularioivaDataAccess.getEntityObject();
		return this.formularioivaObject;
	}
		
	public void setFormularioIvaObject(Object newFormularioIvaObject) {
		this.formularioivaObject = newFormularioIvaObject;
	}
	
	public List<Object> getFormularioIvasObject() {		
		this.formularioivasObject=this.formularioivaDataAccess.getEntitiesObject();
		return this.formularioivasObject;
	}
		
	public void setFormularioIvasObject(List<Object> newFormularioIvasObject) {
		this.formularioivasObject = newFormularioIvasObject;
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
		
		if(this.formularioivaDataAccess!=null) {
			this.formularioivaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioIva.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			formularioivaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			formularioivaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		formularioiva = new  FormularioIva();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioIva.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			formularioiva=formularioivaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formularioiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioIva(this.formularioiva);
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
		formularioiva = new  FormularioIva();
		  		  
        try {
			
			formularioiva=formularioivaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formularioiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioIva(this.formularioiva);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		formularioiva = new  FormularioIva();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioIva.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			formularioiva=formularioivaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formularioiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioIva(this.formularioiva);
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
		formularioiva = new  FormularioIva();
		  		  
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
		formularioiva = new  FormularioIva();
		  		  
        try {
			
			formularioiva=formularioivaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formularioiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioIva(this.formularioiva);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		formularioiva = new  FormularioIva();
		  		  
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
		formularioiva = new  FormularioIva();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioIva.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =formularioivaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		formularioiva = new  FormularioIva();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=formularioivaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		formularioiva = new  FormularioIva();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioIva.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =formularioivaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		formularioiva = new  FormularioIva();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=formularioivaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		formularioiva = new  FormularioIva();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioIva.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =formularioivaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		formularioiva = new  FormularioIva();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=formularioivaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		formularioivas = new  ArrayList<FormularioIva>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioIva.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			FormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formularioivas=formularioivaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormularioIva(formularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioIva(this.formularioivas);
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
		formularioivas = new  ArrayList<FormularioIva>();
		  		  
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
		formularioivas = new  ArrayList<FormularioIva>();
		  		  
        try {			
			FormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formularioivas=formularioivaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarFormularioIva(formularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioIva(this.formularioivas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		formularioivas = new  ArrayList<FormularioIva>();
		  		  
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
		formularioivas = new  ArrayList<FormularioIva>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioIva.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			FormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formularioivas=formularioivaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormularioIva(formularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioIva(this.formularioivas);
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
		formularioivas = new  ArrayList<FormularioIva>();
		  		  
        try {
			FormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formularioivas=formularioivaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormularioIva(formularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioIva(this.formularioivas);
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
		formularioivas = new  ArrayList<FormularioIva>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioIva.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formularioivas=formularioivaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormularioIva(formularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioIva(this.formularioivas);
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
		formularioivas = new  ArrayList<FormularioIva>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formularioivas=formularioivaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormularioIva(formularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioIva(this.formularioivas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		formularioiva = new  FormularioIva();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioIva.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formularioiva=formularioivaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormularioIva(formularioiva);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioIva(this.formularioiva);
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
		formularioiva = new  FormularioIva();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formularioiva=formularioivaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormularioIva(formularioiva);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioIva(this.formularioiva);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		formularioivas = new  ArrayList<FormularioIva>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioIva.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			FormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formularioivas=formularioivaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormularioIva(formularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioIva(this.formularioivas);
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
		formularioivas = new  ArrayList<FormularioIva>();
		  		  
        try {
			FormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formularioivas=formularioivaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormularioIva(formularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioIva(this.formularioivas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosFormularioIvasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		formularioivas = new  ArrayList<FormularioIva>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioIva.class.getSimpleName()+"-getTodosFormularioIvasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formularioivas=formularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFormularioIva(formularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioIva(this.formularioivas);
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
	
	public  void  getTodosFormularioIvas(String sFinalQuery,Pagination pagination)throws Exception {
		formularioivas = new  ArrayList<FormularioIva>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formularioivas=formularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFormularioIva(formularioivas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioIva(this.formularioivas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarFormularioIva(FormularioIva formularioiva) throws Exception {
		Boolean estaValidado=false;
		
		if(formularioiva.getIsNew() || formularioiva.getIsChanged()) { 
			this.invalidValues = formularioivaValidator.getInvalidValues(formularioiva);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(formularioiva);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarFormularioIva(List<FormularioIva> FormularioIvas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(FormularioIva formularioivaLocal:formularioivas) {				
			estaValidadoObjeto=this.validarGuardarFormularioIva(formularioivaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarFormularioIva(List<FormularioIva> FormularioIvas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFormularioIva(formularioivas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarFormularioIva(FormularioIva FormularioIva) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFormularioIva(formularioiva)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(FormularioIva formularioiva) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+formularioiva.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=FormularioIvaConstantesFunciones.getFormularioIvaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"formularioiva","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(FormularioIvaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(FormularioIvaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveFormularioIvaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioIva.class.getSimpleName()+"-saveFormularioIvaWithConnection");connexion.begin();			
			
			FormularioIvaLogicAdditional.checkFormularioIvaToSave(this.formularioiva,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FormularioIvaLogicAdditional.updateFormularioIvaToSave(this.formularioiva,this.arrDatoGeneral);
			
			FormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.formularioiva,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowFormularioIva();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFormularioIva(this.formularioiva)) {
				FormularioIvaDataAccess.save(this.formularioiva, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.formularioiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FormularioIvaLogicAdditional.checkFormularioIvaToSaveAfter(this.formularioiva,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFormularioIva();
			
			connexion.commit();			
			
			if(this.formularioiva.getIsDeleted()) {
				this.formularioiva=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveFormularioIva()throws Exception {	
		try {	
			
			FormularioIvaLogicAdditional.checkFormularioIvaToSave(this.formularioiva,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FormularioIvaLogicAdditional.updateFormularioIvaToSave(this.formularioiva,this.arrDatoGeneral);
			
			FormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.formularioiva,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFormularioIva(this.formularioiva)) {			
				FormularioIvaDataAccess.save(this.formularioiva, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.formularioiva,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FormularioIvaLogicAdditional.checkFormularioIvaToSaveAfter(this.formularioiva,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.formularioiva.getIsDeleted()) {
				this.formularioiva=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveFormularioIvasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioIva.class.getSimpleName()+"-saveFormularioIvasWithConnection");connexion.begin();			
			
			FormularioIvaLogicAdditional.checkFormularioIvaToSaves(formularioivas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowFormularioIvas();
			
			Boolean validadoTodosFormularioIva=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(FormularioIva formularioivaLocal:formularioivas) {		
				if(formularioivaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FormularioIvaLogicAdditional.updateFormularioIvaToSave(formularioivaLocal,this.arrDatoGeneral);
	        	
				FormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),formularioivaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFormularioIva(formularioivaLocal)) {
					FormularioIvaDataAccess.save(formularioivaLocal, connexion);				
				} else {
					validadoTodosFormularioIva=false;
				}
			}
			
			if(!validadoTodosFormularioIva) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FormularioIvaLogicAdditional.checkFormularioIvaToSavesAfter(formularioivas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFormularioIvas();
			
			connexion.commit();		
			
			this.quitarFormularioIvasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveFormularioIvas()throws Exception {				
		 try {	
			FormularioIvaLogicAdditional.checkFormularioIvaToSaves(formularioivas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosFormularioIva=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(FormularioIva formularioivaLocal:formularioivas) {				
				if(formularioivaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FormularioIvaLogicAdditional.updateFormularioIvaToSave(formularioivaLocal,this.arrDatoGeneral);
	        	
				FormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),formularioivaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFormularioIva(formularioivaLocal)) {				
					FormularioIvaDataAccess.save(formularioivaLocal, connexion);				
				} else {
					validadoTodosFormularioIva=false;
				}
			}
			
			if(!validadoTodosFormularioIva) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FormularioIvaLogicAdditional.checkFormularioIvaToSavesAfter(formularioivas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarFormularioIvasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FormularioIvaParameterReturnGeneral procesarAccionFormularioIvas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FormularioIva> formularioivas,FormularioIvaParameterReturnGeneral formularioivaParameterGeneral)throws Exception {
		 try {	
			FormularioIvaParameterReturnGeneral formularioivaReturnGeneral=new FormularioIvaParameterReturnGeneral();
	
			FormularioIvaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,formularioivas,formularioivaParameterGeneral,formularioivaReturnGeneral);
			
			return formularioivaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FormularioIvaParameterReturnGeneral procesarAccionFormularioIvasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FormularioIva> formularioivas,FormularioIvaParameterReturnGeneral formularioivaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioIva.class.getSimpleName()+"-procesarAccionFormularioIvasWithConnection");connexion.begin();			
			
			FormularioIvaParameterReturnGeneral formularioivaReturnGeneral=new FormularioIvaParameterReturnGeneral();
	
			FormularioIvaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,formularioivas,formularioivaParameterGeneral,formularioivaReturnGeneral);
			
			this.connexion.commit();
			
			return formularioivaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FormularioIvaParameterReturnGeneral procesarEventosFormularioIvas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<FormularioIva> formularioivas,FormularioIva formularioiva,FormularioIvaParameterReturnGeneral formularioivaParameterGeneral,Boolean isEsNuevoFormularioIva,ArrayList<Classe> clases)throws Exception {
		 try {	
			FormularioIvaParameterReturnGeneral formularioivaReturnGeneral=new FormularioIvaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				formularioivaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FormularioIvaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,formularioivas,formularioiva,formularioivaParameterGeneral,formularioivaReturnGeneral,isEsNuevoFormularioIva,clases);
			
			return formularioivaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public FormularioIvaParameterReturnGeneral procesarEventosFormularioIvasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<FormularioIva> formularioivas,FormularioIva formularioiva,FormularioIvaParameterReturnGeneral formularioivaParameterGeneral,Boolean isEsNuevoFormularioIva,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioIva.class.getSimpleName()+"-procesarEventosFormularioIvasWithConnection");connexion.begin();			
			
			FormularioIvaParameterReturnGeneral formularioivaReturnGeneral=new FormularioIvaParameterReturnGeneral();
	
			formularioivaReturnGeneral.setFormularioIva(formularioiva);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				formularioivaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FormularioIvaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,formularioivas,formularioiva,formularioivaParameterGeneral,formularioivaReturnGeneral,isEsNuevoFormularioIva,clases);
			
			this.connexion.commit();
			
			return formularioivaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FormularioIvaParameterReturnGeneral procesarImportacionFormularioIvasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,FormularioIvaParameterReturnGeneral formularioivaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioIva.class.getSimpleName()+"-procesarImportacionFormularioIvasWithConnection");connexion.begin();			
			
			FormularioIvaParameterReturnGeneral formularioivaReturnGeneral=new FormularioIvaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.formularioivas=new ArrayList<FormularioIva>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.formularioiva=new FormularioIva();
				
				
				if(conColumnasBase) {this.formularioiva.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.formularioiva.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.formularioiva.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.formularioivas.add(this.formularioiva);
			}
			
			this.saveFormularioIvas();
			
			this.connexion.commit();
			
			formularioivaReturnGeneral.setConRetornoEstaProcesado(true);
			formularioivaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return formularioivaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarFormularioIvasEliminados() throws Exception {				
		
		List<FormularioIva> formularioivasAux= new ArrayList<FormularioIva>();
		
		for(FormularioIva formularioiva:formularioivas) {
			if(!formularioiva.getIsDeleted()) {
				formularioivasAux.add(formularioiva);
			}
		}
		
		formularioivas=formularioivasAux;
	}
	
	public void quitarFormularioIvasNulos() throws Exception {				
		
		List<FormularioIva> formularioivasAux= new ArrayList<FormularioIva>();
		
		for(FormularioIva formularioiva : this.formularioivas) {
			if(formularioiva==null) {
				formularioivasAux.add(formularioiva);
			}
		}
		
		//this.formularioivas=formularioivasAux;
		
		this.formularioivas.removeAll(formularioivasAux);
	}
	
	public void getSetVersionRowFormularioIvaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(formularioiva.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((formularioiva.getIsDeleted() || (formularioiva.getIsChanged()&&!formularioiva.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=formularioivaDataAccess.getSetVersionRowFormularioIva(connexion,formularioiva.getId());
				
				if(!formularioiva.getVersionRow().equals(timestamp)) {	
					formularioiva.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				formularioiva.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowFormularioIva()throws Exception {	
		
		if(formularioiva.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((formularioiva.getIsDeleted() || (formularioiva.getIsChanged()&&!formularioiva.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=formularioivaDataAccess.getSetVersionRowFormularioIva(connexion,formularioiva.getId());
			
			try {							
				if(!formularioiva.getVersionRow().equals(timestamp)) {	
					formularioiva.setVersionRow(timestamp);
				}
				
				formularioiva.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowFormularioIvasWithConnection()throws Exception {	
		if(formularioivas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(FormularioIva formularioivaAux:formularioivas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(formularioivaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(formularioivaAux.getIsDeleted() || (formularioivaAux.getIsChanged()&&!formularioivaAux.getIsNew())) {
						
						timestamp=formularioivaDataAccess.getSetVersionRowFormularioIva(connexion,formularioivaAux.getId());
						
						if(!formularioiva.getVersionRow().equals(timestamp)) {	
							formularioivaAux.setVersionRow(timestamp);
						}
								
						formularioivaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowFormularioIvas()throws Exception {	
		if(formularioivas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(FormularioIva formularioivaAux:formularioivas) {
					if(formularioivaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(formularioivaAux.getIsDeleted() || (formularioivaAux.getIsChanged()&&!formularioivaAux.getIsNew())) {
						
						timestamp=formularioivaDataAccess.getSetVersionRowFormularioIva(connexion,formularioivaAux.getId());
						
						if(!formularioivaAux.getVersionRow().equals(timestamp)) {	
							formularioivaAux.setVersionRow(timestamp);
						}
						
													
						formularioivaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public FormularioIvaParameterReturnGeneral cargarCombosLoteForeignKeyFormularioIvaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalDatoFormularioIva,String finalQueryGlobalGrupoParametroFormularioIva,String finalQueryGlobalParametroFormularioIva) throws Exception {
		FormularioIvaParameterReturnGeneral  formularioivaReturnGeneral =new FormularioIvaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioIva.class.getSimpleName()+"-cargarCombosLoteForeignKeyFormularioIvaWithConnection");connexion.begin();
			
			formularioivaReturnGeneral =new FormularioIvaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			formularioivaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			formularioivaReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			formularioivaReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<DatoFormularioIva> datoformularioivasForeignKey=new ArrayList<DatoFormularioIva>();
			DatoFormularioIvaLogic datoformularioivaLogic=new DatoFormularioIvaLogic();
			datoformularioivaLogic.setConnexion(this.connexion);
			datoformularioivaLogic.getDatoFormularioIvaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDatoFormularioIva.equals("NONE")) {
				datoformularioivaLogic.getTodosDatoFormularioIvas(finalQueryGlobalDatoFormularioIva,new Pagination());
				datoformularioivasForeignKey=datoformularioivaLogic.getDatoFormularioIvas();
			}

			formularioivaReturnGeneral.setdatoformularioivasForeignKey(datoformularioivasForeignKey);


			List<GrupoParametroFormularioIva> grupoparametroformularioivasForeignKey=new ArrayList<GrupoParametroFormularioIva>();
			GrupoParametroFormularioIvaLogic grupoparametroformularioivaLogic=new GrupoParametroFormularioIvaLogic();
			grupoparametroformularioivaLogic.setConnexion(this.connexion);
			grupoparametroformularioivaLogic.getGrupoParametroFormularioIvaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalGrupoParametroFormularioIva.equals("NONE")) {
				grupoparametroformularioivaLogic.getTodosGrupoParametroFormularioIvas(finalQueryGlobalGrupoParametroFormularioIva,new Pagination());
				grupoparametroformularioivasForeignKey=grupoparametroformularioivaLogic.getGrupoParametroFormularioIvas();
			}

			formularioivaReturnGeneral.setgrupoparametroformularioivasForeignKey(grupoparametroformularioivasForeignKey);


			List<ParametroFormularioIva> parametroformularioivasForeignKey=new ArrayList<ParametroFormularioIva>();
			ParametroFormularioIvaLogic parametroformularioivaLogic=new ParametroFormularioIvaLogic();
			parametroformularioivaLogic.setConnexion(this.connexion);
			parametroformularioivaLogic.getParametroFormularioIvaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalParametroFormularioIva.equals("NONE")) {
				parametroformularioivaLogic.getTodosParametroFormularioIvas(finalQueryGlobalParametroFormularioIva,new Pagination());
				parametroformularioivasForeignKey=parametroformularioivaLogic.getParametroFormularioIvas();
			}

			formularioivaReturnGeneral.setparametroformularioivasForeignKey(parametroformularioivasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return formularioivaReturnGeneral;
	}
	
	public FormularioIvaParameterReturnGeneral cargarCombosLoteForeignKeyFormularioIva(String finalQueryGlobalEmpresa,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalDatoFormularioIva,String finalQueryGlobalGrupoParametroFormularioIva,String finalQueryGlobalParametroFormularioIva) throws Exception {
		FormularioIvaParameterReturnGeneral  formularioivaReturnGeneral =new FormularioIvaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			formularioivaReturnGeneral =new FormularioIvaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			formularioivaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			formularioivaReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			formularioivaReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<DatoFormularioIva> datoformularioivasForeignKey=new ArrayList<DatoFormularioIva>();
			DatoFormularioIvaLogic datoformularioivaLogic=new DatoFormularioIvaLogic();
			datoformularioivaLogic.setConnexion(this.connexion);
			datoformularioivaLogic.getDatoFormularioIvaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDatoFormularioIva.equals("NONE")) {
				datoformularioivaLogic.getTodosDatoFormularioIvas(finalQueryGlobalDatoFormularioIva,new Pagination());
				datoformularioivasForeignKey=datoformularioivaLogic.getDatoFormularioIvas();
			}

			formularioivaReturnGeneral.setdatoformularioivasForeignKey(datoformularioivasForeignKey);


			List<GrupoParametroFormularioIva> grupoparametroformularioivasForeignKey=new ArrayList<GrupoParametroFormularioIva>();
			GrupoParametroFormularioIvaLogic grupoparametroformularioivaLogic=new GrupoParametroFormularioIvaLogic();
			grupoparametroformularioivaLogic.setConnexion(this.connexion);
			grupoparametroformularioivaLogic.getGrupoParametroFormularioIvaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalGrupoParametroFormularioIva.equals("NONE")) {
				grupoparametroformularioivaLogic.getTodosGrupoParametroFormularioIvas(finalQueryGlobalGrupoParametroFormularioIva,new Pagination());
				grupoparametroformularioivasForeignKey=grupoparametroformularioivaLogic.getGrupoParametroFormularioIvas();
			}

			formularioivaReturnGeneral.setgrupoparametroformularioivasForeignKey(grupoparametroformularioivasForeignKey);


			List<ParametroFormularioIva> parametroformularioivasForeignKey=new ArrayList<ParametroFormularioIva>();
			ParametroFormularioIvaLogic parametroformularioivaLogic=new ParametroFormularioIvaLogic();
			parametroformularioivaLogic.setConnexion(this.connexion);
			parametroformularioivaLogic.getParametroFormularioIvaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalParametroFormularioIva.equals("NONE")) {
				parametroformularioivaLogic.getTodosParametroFormularioIvas(finalQueryGlobalParametroFormularioIva,new Pagination());
				parametroformularioivasForeignKey=parametroformularioivaLogic.getParametroFormularioIvas();
			}

			formularioivaReturnGeneral.setparametroformularioivasForeignKey(parametroformularioivasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return formularioivaReturnGeneral;
	}
	
	
	public void deepLoad(FormularioIva formularioiva,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			FormularioIvaLogicAdditional.updateFormularioIvaToGet(formularioiva,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		formularioiva.setEmpresa(formularioivaDataAccess.getEmpresa(connexion,formularioiva));
		formularioiva.setEjercicio(formularioivaDataAccess.getEjercicio(connexion,formularioiva));
		formularioiva.setPeriodo(formularioivaDataAccess.getPeriodo(connexion,formularioiva));
		formularioiva.setDatoFormularioIva(formularioivaDataAccess.getDatoFormularioIva(connexion,formularioiva));
		formularioiva.setGrupoParametroFormularioIva(formularioivaDataAccess.getGrupoParametroFormularioIva(connexion,formularioiva));
		formularioiva.setParametroFormularioIva(formularioivaDataAccess.getParametroFormularioIva(connexion,formularioiva));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				formularioiva.setEmpresa(formularioivaDataAccess.getEmpresa(connexion,formularioiva));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				formularioiva.setEjercicio(formularioivaDataAccess.getEjercicio(connexion,formularioiva));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				formularioiva.setPeriodo(formularioivaDataAccess.getPeriodo(connexion,formularioiva));
				continue;
			}

			if(clas.clas.equals(DatoFormularioIva.class)) {
				formularioiva.setDatoFormularioIva(formularioivaDataAccess.getDatoFormularioIva(connexion,formularioiva));
				continue;
			}

			if(clas.clas.equals(GrupoParametroFormularioIva.class)) {
				formularioiva.setGrupoParametroFormularioIva(formularioivaDataAccess.getGrupoParametroFormularioIva(connexion,formularioiva));
				continue;
			}

			if(clas.clas.equals(ParametroFormularioIva.class)) {
				formularioiva.setParametroFormularioIva(formularioivaDataAccess.getParametroFormularioIva(connexion,formularioiva));
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
			formularioiva.setEmpresa(formularioivaDataAccess.getEmpresa(connexion,formularioiva));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formularioiva.setEjercicio(formularioivaDataAccess.getEjercicio(connexion,formularioiva));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formularioiva.setPeriodo(formularioivaDataAccess.getPeriodo(connexion,formularioiva));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DatoFormularioIva.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formularioiva.setDatoFormularioIva(formularioivaDataAccess.getDatoFormularioIva(connexion,formularioiva));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(GrupoParametroFormularioIva.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formularioiva.setGrupoParametroFormularioIva(formularioivaDataAccess.getGrupoParametroFormularioIva(connexion,formularioiva));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroFormularioIva.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formularioiva.setParametroFormularioIva(formularioivaDataAccess.getParametroFormularioIva(connexion,formularioiva));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		formularioiva.setEmpresa(formularioivaDataAccess.getEmpresa(connexion,formularioiva));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(formularioiva.getEmpresa(),isDeep,deepLoadType,clases);
				
		formularioiva.setEjercicio(formularioivaDataAccess.getEjercicio(connexion,formularioiva));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(formularioiva.getEjercicio(),isDeep,deepLoadType,clases);
				
		formularioiva.setPeriodo(formularioivaDataAccess.getPeriodo(connexion,formularioiva));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(formularioiva.getPeriodo(),isDeep,deepLoadType,clases);
				
		formularioiva.setDatoFormularioIva(formularioivaDataAccess.getDatoFormularioIva(connexion,formularioiva));
		DatoFormularioIvaLogic datoformularioivaLogic= new DatoFormularioIvaLogic(connexion);
		datoformularioivaLogic.deepLoad(formularioiva.getDatoFormularioIva(),isDeep,deepLoadType,clases);
				
		formularioiva.setGrupoParametroFormularioIva(formularioivaDataAccess.getGrupoParametroFormularioIva(connexion,formularioiva));
		GrupoParametroFormularioIvaLogic grupoparametroformularioivaLogic= new GrupoParametroFormularioIvaLogic(connexion);
		grupoparametroformularioivaLogic.deepLoad(formularioiva.getGrupoParametroFormularioIva(),isDeep,deepLoadType,clases);
				
		formularioiva.setParametroFormularioIva(formularioivaDataAccess.getParametroFormularioIva(connexion,formularioiva));
		ParametroFormularioIvaLogic parametroformularioivaLogic= new ParametroFormularioIvaLogic(connexion);
		parametroformularioivaLogic.deepLoad(formularioiva.getParametroFormularioIva(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				formularioiva.setEmpresa(formularioivaDataAccess.getEmpresa(connexion,formularioiva));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(formularioiva.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				formularioiva.setEjercicio(formularioivaDataAccess.getEjercicio(connexion,formularioiva));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(formularioiva.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				formularioiva.setPeriodo(formularioivaDataAccess.getPeriodo(connexion,formularioiva));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(formularioiva.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DatoFormularioIva.class)) {
				formularioiva.setDatoFormularioIva(formularioivaDataAccess.getDatoFormularioIva(connexion,formularioiva));
				DatoFormularioIvaLogic datoformularioivaLogic= new DatoFormularioIvaLogic(connexion);
				datoformularioivaLogic.deepLoad(formularioiva.getDatoFormularioIva(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(GrupoParametroFormularioIva.class)) {
				formularioiva.setGrupoParametroFormularioIva(formularioivaDataAccess.getGrupoParametroFormularioIva(connexion,formularioiva));
				GrupoParametroFormularioIvaLogic grupoparametroformularioivaLogic= new GrupoParametroFormularioIvaLogic(connexion);
				grupoparametroformularioivaLogic.deepLoad(formularioiva.getGrupoParametroFormularioIva(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ParametroFormularioIva.class)) {
				formularioiva.setParametroFormularioIva(formularioivaDataAccess.getParametroFormularioIva(connexion,formularioiva));
				ParametroFormularioIvaLogic parametroformularioivaLogic= new ParametroFormularioIvaLogic(connexion);
				parametroformularioivaLogic.deepLoad(formularioiva.getParametroFormularioIva(),isDeep,deepLoadType,clases);				
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
			formularioiva.setEmpresa(formularioivaDataAccess.getEmpresa(connexion,formularioiva));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(formularioiva.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formularioiva.setEjercicio(formularioivaDataAccess.getEjercicio(connexion,formularioiva));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(formularioiva.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formularioiva.setPeriodo(formularioivaDataAccess.getPeriodo(connexion,formularioiva));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(formularioiva.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(DatoFormularioIva.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formularioiva.setDatoFormularioIva(formularioivaDataAccess.getDatoFormularioIva(connexion,formularioiva));
			DatoFormularioIvaLogic datoformularioivaLogic= new DatoFormularioIvaLogic(connexion);
			datoformularioivaLogic.deepLoad(formularioiva.getDatoFormularioIva(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(GrupoParametroFormularioIva.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formularioiva.setGrupoParametroFormularioIva(formularioivaDataAccess.getGrupoParametroFormularioIva(connexion,formularioiva));
			GrupoParametroFormularioIvaLogic grupoparametroformularioivaLogic= new GrupoParametroFormularioIvaLogic(connexion);
			grupoparametroformularioivaLogic.deepLoad(formularioiva.getGrupoParametroFormularioIva(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroFormularioIva.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formularioiva.setParametroFormularioIva(formularioivaDataAccess.getParametroFormularioIva(connexion,formularioiva));
			ParametroFormularioIvaLogic parametroformularioivaLogic= new ParametroFormularioIvaLogic(connexion);
			parametroformularioivaLogic.deepLoad(formularioiva.getParametroFormularioIva(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(FormularioIva formularioiva,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			FormularioIvaLogicAdditional.updateFormularioIvaToSave(formularioiva,this.arrDatoGeneral);
			
FormularioIvaDataAccess.save(formularioiva, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(formularioiva.getEmpresa(),connexion);

		EjercicioDataAccess.save(formularioiva.getEjercicio(),connexion);

		PeriodoDataAccess.save(formularioiva.getPeriodo(),connexion);

		DatoFormularioIvaDataAccess.save(formularioiva.getDatoFormularioIva(),connexion);

		GrupoParametroFormularioIvaDataAccess.save(formularioiva.getGrupoParametroFormularioIva(),connexion);

		ParametroFormularioIvaDataAccess.save(formularioiva.getParametroFormularioIva(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(formularioiva.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(formularioiva.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(formularioiva.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(DatoFormularioIva.class)) {
				DatoFormularioIvaDataAccess.save(formularioiva.getDatoFormularioIva(),connexion);
				continue;
			}

			if(clas.clas.equals(GrupoParametroFormularioIva.class)) {
				GrupoParametroFormularioIvaDataAccess.save(formularioiva.getGrupoParametroFormularioIva(),connexion);
				continue;
			}

			if(clas.clas.equals(ParametroFormularioIva.class)) {
				ParametroFormularioIvaDataAccess.save(formularioiva.getParametroFormularioIva(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(formularioiva.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(formularioiva.getEmpresa(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(formularioiva.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(formularioiva.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(formularioiva.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(formularioiva.getPeriodo(),isDeep,deepLoadType,clases);
				

		DatoFormularioIvaDataAccess.save(formularioiva.getDatoFormularioIva(),connexion);
		DatoFormularioIvaLogic datoformularioivaLogic= new DatoFormularioIvaLogic(connexion);
		datoformularioivaLogic.deepLoad(formularioiva.getDatoFormularioIva(),isDeep,deepLoadType,clases);
				

		GrupoParametroFormularioIvaDataAccess.save(formularioiva.getGrupoParametroFormularioIva(),connexion);
		GrupoParametroFormularioIvaLogic grupoparametroformularioivaLogic= new GrupoParametroFormularioIvaLogic(connexion);
		grupoparametroformularioivaLogic.deepLoad(formularioiva.getGrupoParametroFormularioIva(),isDeep,deepLoadType,clases);
				

		ParametroFormularioIvaDataAccess.save(formularioiva.getParametroFormularioIva(),connexion);
		ParametroFormularioIvaLogic parametroformularioivaLogic= new ParametroFormularioIvaLogic(connexion);
		parametroformularioivaLogic.deepLoad(formularioiva.getParametroFormularioIva(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(formularioiva.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(formularioiva.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(formularioiva.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(formularioiva.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(formularioiva.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(formularioiva.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DatoFormularioIva.class)) {
				DatoFormularioIvaDataAccess.save(formularioiva.getDatoFormularioIva(),connexion);
				DatoFormularioIvaLogic datoformularioivaLogic= new DatoFormularioIvaLogic(connexion);
				datoformularioivaLogic.deepSave(formularioiva.getDatoFormularioIva(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(GrupoParametroFormularioIva.class)) {
				GrupoParametroFormularioIvaDataAccess.save(formularioiva.getGrupoParametroFormularioIva(),connexion);
				GrupoParametroFormularioIvaLogic grupoparametroformularioivaLogic= new GrupoParametroFormularioIvaLogic(connexion);
				grupoparametroformularioivaLogic.deepSave(formularioiva.getGrupoParametroFormularioIva(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ParametroFormularioIva.class)) {
				ParametroFormularioIvaDataAccess.save(formularioiva.getParametroFormularioIva(),connexion);
				ParametroFormularioIvaLogic parametroformularioivaLogic= new ParametroFormularioIvaLogic(connexion);
				parametroformularioivaLogic.deepSave(formularioiva.getParametroFormularioIva(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(FormularioIva.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(formularioiva,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioIva(formularioiva);
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
			this.deepLoad(this.formularioiva,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioIva(this.formularioiva);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(FormularioIva.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(formularioivas!=null) {
				for(FormularioIva formularioiva:formularioivas) {
					this.deepLoad(formularioiva,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					FormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioIva(formularioivas);
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
			if(formularioivas!=null) {
				for(FormularioIva formularioiva:formularioivas) {
					this.deepLoad(formularioiva,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					FormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioIva(formularioivas);
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
			this.getNewConnexionToDeep(FormularioIva.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(formularioiva,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(FormularioIva.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(formularioivas!=null) {
				for(FormularioIva formularioiva:formularioivas) {
					this.deepSave(formularioiva,isDeep,deepLoadType,clases);
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
			if(formularioivas!=null) {
				for(FormularioIva formularioiva:formularioivas) {
					this.deepSave(formularioiva,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getFormularioIvasBusquedaPorDatoFormularioPorGrupoWithConnection(String sFinalQuery,Pagination pagination,Long id_dato_formulario_iva,Long id_grupo_parametro_formulario_iva)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioIva.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDatoFormularioIva= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDatoFormularioIva.setParameterSelectionGeneralEqual(ParameterType.LONG,id_dato_formulario_iva,FormularioIvaConstantesFunciones.IDDATOFORMULARIOIVA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDatoFormularioIva);

			ParameterSelectionGeneral parameterSelectionGeneralidGrupoParametroFormularioIva= new ParameterSelectionGeneral();
			parameterSelectionGeneralidGrupoParametroFormularioIva.setParameterSelectionGeneralEqual(ParameterType.LONG,id_grupo_parametro_formulario_iva,FormularioIvaConstantesFunciones.IDGRUPOPARAMETROFORMULARIOIVA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidGrupoParametroFormularioIva);

			FormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorDatoFormularioPorGrupo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formularioivas=formularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioIva(this.formularioivas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormularioIvasBusquedaPorDatoFormularioPorGrupo(String sFinalQuery,Pagination pagination,Long id_dato_formulario_iva,Long id_grupo_parametro_formulario_iva)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDatoFormularioIva= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDatoFormularioIva.setParameterSelectionGeneralEqual(ParameterType.LONG,id_dato_formulario_iva,FormularioIvaConstantesFunciones.IDDATOFORMULARIOIVA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDatoFormularioIva);

			ParameterSelectionGeneral parameterSelectionGeneralidGrupoParametroFormularioIva= new ParameterSelectionGeneral();
			parameterSelectionGeneralidGrupoParametroFormularioIva.setParameterSelectionGeneralEqual(ParameterType.LONG,id_grupo_parametro_formulario_iva,FormularioIvaConstantesFunciones.IDGRUPOPARAMETROFORMULARIOIVA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidGrupoParametroFormularioIva);

			FormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorDatoFormularioPorGrupo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formularioivas=formularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioIva(this.formularioivas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormularioIvasFK_IdDatoFormularioIvaWithConnection(String sFinalQuery,Pagination pagination,Long id_dato_formulario_iva)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioIva.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDatoFormularioIva= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDatoFormularioIva.setParameterSelectionGeneralEqual(ParameterType.LONG,id_dato_formulario_iva,FormularioIvaConstantesFunciones.IDDATOFORMULARIOIVA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDatoFormularioIva);

			FormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDatoFormularioIva","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formularioivas=formularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioIva(this.formularioivas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormularioIvasFK_IdDatoFormularioIva(String sFinalQuery,Pagination pagination,Long id_dato_formulario_iva)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDatoFormularioIva= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDatoFormularioIva.setParameterSelectionGeneralEqual(ParameterType.LONG,id_dato_formulario_iva,FormularioIvaConstantesFunciones.IDDATOFORMULARIOIVA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDatoFormularioIva);

			FormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDatoFormularioIva","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formularioivas=formularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioIva(this.formularioivas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormularioIvasFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioIva.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,FormularioIvaConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			FormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formularioivas=formularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioIva(this.formularioivas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormularioIvasFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,FormularioIvaConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			FormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formularioivas=formularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioIva(this.formularioivas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormularioIvasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioIva.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FormularioIvaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formularioivas=formularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioIva(this.formularioivas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormularioIvasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FormularioIvaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formularioivas=formularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioIva(this.formularioivas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormularioIvasFK_IdGrupoParametroFormularioIvaWithConnection(String sFinalQuery,Pagination pagination,Long id_grupo_parametro_formulario_iva)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioIva.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidGrupoParametroFormularioIva= new ParameterSelectionGeneral();
			parameterSelectionGeneralidGrupoParametroFormularioIva.setParameterSelectionGeneralEqual(ParameterType.LONG,id_grupo_parametro_formulario_iva,FormularioIvaConstantesFunciones.IDGRUPOPARAMETROFORMULARIOIVA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidGrupoParametroFormularioIva);

			FormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdGrupoParametroFormularioIva","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formularioivas=formularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioIva(this.formularioivas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormularioIvasFK_IdGrupoParametroFormularioIva(String sFinalQuery,Pagination pagination,Long id_grupo_parametro_formulario_iva)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidGrupoParametroFormularioIva= new ParameterSelectionGeneral();
			parameterSelectionGeneralidGrupoParametroFormularioIva.setParameterSelectionGeneralEqual(ParameterType.LONG,id_grupo_parametro_formulario_iva,FormularioIvaConstantesFunciones.IDGRUPOPARAMETROFORMULARIOIVA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidGrupoParametroFormularioIva);

			FormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdGrupoParametroFormularioIva","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formularioivas=formularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioIva(this.formularioivas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormularioIvasFK_IdParametroFormularioIvaWithConnection(String sFinalQuery,Pagination pagination,Long id_parametro_formulario_iva)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioIva.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidParametroFormularioIva= new ParameterSelectionGeneral();
			parameterSelectionGeneralidParametroFormularioIva.setParameterSelectionGeneralEqual(ParameterType.LONG,id_parametro_formulario_iva,FormularioIvaConstantesFunciones.IDPARAMETROFORMULARIOIVA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidParametroFormularioIva);

			FormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdParametroFormularioIva","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formularioivas=formularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioIva(this.formularioivas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormularioIvasFK_IdParametroFormularioIva(String sFinalQuery,Pagination pagination,Long id_parametro_formulario_iva)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidParametroFormularioIva= new ParameterSelectionGeneral();
			parameterSelectionGeneralidParametroFormularioIva.setParameterSelectionGeneralEqual(ParameterType.LONG,id_parametro_formulario_iva,FormularioIvaConstantesFunciones.IDPARAMETROFORMULARIOIVA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidParametroFormularioIva);

			FormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdParametroFormularioIva","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formularioivas=formularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioIva(this.formularioivas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormularioIvasFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioIva.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,FormularioIvaConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			FormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formularioivas=formularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioIva(this.formularioivas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormularioIvasFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,FormularioIvaConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			FormularioIvaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formularioivas=formularioivaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioIvaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioIva(this.formularioivas);
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
			if(FormularioIvaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,FormularioIvaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,FormularioIva formularioiva,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(FormularioIvaConstantesFunciones.ISCONAUDITORIA) {
				if(formularioiva.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FormularioIvaDataAccess.TABLENAME, formularioiva.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FormularioIvaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FormularioIvaLogic.registrarAuditoriaDetallesFormularioIva(connexion,formularioiva,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(formularioiva.getIsDeleted()) {
					/*if(!formularioiva.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,FormularioIvaDataAccess.TABLENAME, formularioiva.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////FormularioIvaLogic.registrarAuditoriaDetallesFormularioIva(connexion,formularioiva,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FormularioIvaDataAccess.TABLENAME, formularioiva.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(formularioiva.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FormularioIvaDataAccess.TABLENAME, formularioiva.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FormularioIvaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FormularioIvaLogic.registrarAuditoriaDetallesFormularioIva(connexion,formularioiva,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesFormularioIva(Connexion connexion,FormularioIva formularioiva)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(formularioiva.getIsNew()||!formularioiva.getid_empresa().equals(formularioiva.getFormularioIvaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formularioiva.getFormularioIvaOriginal().getid_empresa()!=null)
				{
					strValorActual=formularioiva.getFormularioIvaOriginal().getid_empresa().toString();
				}
				if(formularioiva.getid_empresa()!=null)
				{
					strValorNuevo=formularioiva.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioIvaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(formularioiva.getIsNew()||!formularioiva.getid_ejercicio().equals(formularioiva.getFormularioIvaOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formularioiva.getFormularioIvaOriginal().getid_ejercicio()!=null)
				{
					strValorActual=formularioiva.getFormularioIvaOriginal().getid_ejercicio().toString();
				}
				if(formularioiva.getid_ejercicio()!=null)
				{
					strValorNuevo=formularioiva.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioIvaConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(formularioiva.getIsNew()||!formularioiva.getid_periodo().equals(formularioiva.getFormularioIvaOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formularioiva.getFormularioIvaOriginal().getid_periodo()!=null)
				{
					strValorActual=formularioiva.getFormularioIvaOriginal().getid_periodo().toString();
				}
				if(formularioiva.getid_periodo()!=null)
				{
					strValorNuevo=formularioiva.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioIvaConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(formularioiva.getIsNew()||!formularioiva.getid_dato_formulario_iva().equals(formularioiva.getFormularioIvaOriginal().getid_dato_formulario_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formularioiva.getFormularioIvaOriginal().getid_dato_formulario_iva()!=null)
				{
					strValorActual=formularioiva.getFormularioIvaOriginal().getid_dato_formulario_iva().toString();
				}
				if(formularioiva.getid_dato_formulario_iva()!=null)
				{
					strValorNuevo=formularioiva.getid_dato_formulario_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioIvaConstantesFunciones.IDDATOFORMULARIOIVA,strValorActual,strValorNuevo);
			}	
			
			if(formularioiva.getIsNew()||!formularioiva.getid_grupo_parametro_formulario_iva().equals(formularioiva.getFormularioIvaOriginal().getid_grupo_parametro_formulario_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formularioiva.getFormularioIvaOriginal().getid_grupo_parametro_formulario_iva()!=null)
				{
					strValorActual=formularioiva.getFormularioIvaOriginal().getid_grupo_parametro_formulario_iva().toString();
				}
				if(formularioiva.getid_grupo_parametro_formulario_iva()!=null)
				{
					strValorNuevo=formularioiva.getid_grupo_parametro_formulario_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioIvaConstantesFunciones.IDGRUPOPARAMETROFORMULARIOIVA,strValorActual,strValorNuevo);
			}	
			
			if(formularioiva.getIsNew()||!formularioiva.getid_parametro_formulario_iva().equals(formularioiva.getFormularioIvaOriginal().getid_parametro_formulario_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formularioiva.getFormularioIvaOriginal().getid_parametro_formulario_iva()!=null)
				{
					strValorActual=formularioiva.getFormularioIvaOriginal().getid_parametro_formulario_iva().toString();
				}
				if(formularioiva.getid_parametro_formulario_iva()!=null)
				{
					strValorNuevo=formularioiva.getid_parametro_formulario_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioIvaConstantesFunciones.IDPARAMETROFORMULARIOIVA,strValorActual,strValorNuevo);
			}	
			
			if(formularioiva.getIsNew()||!formularioiva.getvalor().equals(formularioiva.getFormularioIvaOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formularioiva.getFormularioIvaOriginal().getvalor()!=null)
				{
					strValorActual=formularioiva.getFormularioIvaOriginal().getvalor().toString();
				}
				if(formularioiva.getvalor()!=null)
				{
					strValorNuevo=formularioiva.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioIvaConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveFormularioIvaRelacionesWithConnection(FormularioIva formularioiva) throws Exception {

		if(!formularioiva.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFormularioIvaRelacionesBase(formularioiva,true);
		}
	}

	public void saveFormularioIvaRelaciones(FormularioIva formularioiva)throws Exception {

		if(!formularioiva.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFormularioIvaRelacionesBase(formularioiva,false);
		}
	}

	public void saveFormularioIvaRelacionesBase(FormularioIva formularioiva,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("FormularioIva-saveRelacionesWithConnection");}
	

			this.setFormularioIva(formularioiva);

			if(FormularioIvaLogicAdditional.validarSaveRelaciones(formularioiva,this)) {

				FormularioIvaLogicAdditional.updateRelacionesToSave(formularioiva,this);

				if((formularioiva.getIsNew()||formularioiva.getIsChanged())&&!formularioiva.getIsDeleted()) {
					this.saveFormularioIva();
					this.saveFormularioIvaRelacionesDetalles();

				} else if(formularioiva.getIsDeleted()) {
					this.saveFormularioIvaRelacionesDetalles();
					this.saveFormularioIva();
				}

				FormularioIvaLogicAdditional.updateRelacionesToSaveAfter(formularioiva,this);

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
	
	
	private void saveFormularioIvaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfFormularioIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FormularioIvaConstantesFunciones.getClassesForeignKeysOfFormularioIva(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFormularioIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FormularioIvaConstantesFunciones.getClassesRelationshipsOfFormularioIva(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

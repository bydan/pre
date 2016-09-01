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
import com.bydan.erp.contabilidad.util.FormularioRentaConstantesFunciones;
import com.bydan.erp.contabilidad.util.FormularioRentaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.FormularioRentaParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.FormularioRenta;
import com.bydan.erp.contabilidad.business.logic.FormularioRentaLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class FormularioRentaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(FormularioRentaLogic.class);
	
	protected FormularioRentaDataAccess formulariorentaDataAccess; 	
	protected FormularioRenta formulariorenta;
	protected List<FormularioRenta> formulariorentas;
	protected Object formulariorentaObject;	
	protected List<Object> formulariorentasObject;
	
	public static ClassValidator<FormularioRenta> formulariorentaValidator = new ClassValidator<FormularioRenta>(FormularioRenta.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected FormularioRentaLogicAdditional formulariorentaLogicAdditional=null;
	
	public FormularioRentaLogicAdditional getFormularioRentaLogicAdditional() {
		return this.formulariorentaLogicAdditional;
	}
	
	public void setFormularioRentaLogicAdditional(FormularioRentaLogicAdditional formulariorentaLogicAdditional) {
		try {
			this.formulariorentaLogicAdditional=formulariorentaLogicAdditional;
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
	
	
	
	
	public  FormularioRentaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.formulariorentaDataAccess = new FormularioRentaDataAccess();
			
			this.formulariorentas= new ArrayList<FormularioRenta>();
			this.formulariorenta= new FormularioRenta();
			
			this.formulariorentaObject=new Object();
			this.formulariorentasObject=new ArrayList<Object>();
				
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
			
			this.formulariorentaDataAccess.setConnexionType(this.connexionType);
			this.formulariorentaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  FormularioRentaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.formulariorentaDataAccess = new FormularioRentaDataAccess();
			this.formulariorentas= new ArrayList<FormularioRenta>();
			this.formulariorenta= new FormularioRenta();
			this.formulariorentaObject=new Object();
			this.formulariorentasObject=new ArrayList<Object>();
			
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
			
			this.formulariorentaDataAccess.setConnexionType(this.connexionType);
			this.formulariorentaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public FormularioRenta getFormularioRenta() throws Exception {	
		FormularioRentaLogicAdditional.checkFormularioRentaToGet(formulariorenta,this.datosCliente,this.arrDatoGeneral);
		FormularioRentaLogicAdditional.updateFormularioRentaToGet(formulariorenta,this.arrDatoGeneral);
		
		return formulariorenta;
	}
		
	public void setFormularioRenta(FormularioRenta newFormularioRenta) {
		this.formulariorenta = newFormularioRenta;
	}
	
	public FormularioRentaDataAccess getFormularioRentaDataAccess() {
		return formulariorentaDataAccess;
	}
	
	public void setFormularioRentaDataAccess(FormularioRentaDataAccess newformulariorentaDataAccess) {
		this.formulariorentaDataAccess = newformulariorentaDataAccess;
	}
	
	public List<FormularioRenta> getFormularioRentas() throws Exception {		
		this.quitarFormularioRentasNulos();
		
		FormularioRentaLogicAdditional.checkFormularioRentaToGets(formulariorentas,this.datosCliente,this.arrDatoGeneral);
		
		for (FormularioRenta formulariorentaLocal: formulariorentas ) {
			FormularioRentaLogicAdditional.updateFormularioRentaToGet(formulariorentaLocal,this.arrDatoGeneral);
		}
		
		return formulariorentas;
	}
	
	public void setFormularioRentas(List<FormularioRenta> newFormularioRentas) {
		this.formulariorentas = newFormularioRentas;
	}
	
	public Object getFormularioRentaObject() {	
		this.formulariorentaObject=this.formulariorentaDataAccess.getEntityObject();
		return this.formulariorentaObject;
	}
		
	public void setFormularioRentaObject(Object newFormularioRentaObject) {
		this.formulariorentaObject = newFormularioRentaObject;
	}
	
	public List<Object> getFormularioRentasObject() {		
		this.formulariorentasObject=this.formulariorentaDataAccess.getEntitiesObject();
		return this.formulariorentasObject;
	}
		
	public void setFormularioRentasObject(List<Object> newFormularioRentasObject) {
		this.formulariorentasObject = newFormularioRentasObject;
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
		
		if(this.formulariorentaDataAccess!=null) {
			this.formulariorentaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			formulariorentaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			formulariorentaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		formulariorenta = new  FormularioRenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			formulariorenta=formulariorentaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formulariorenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta(this.formulariorenta);
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
		formulariorenta = new  FormularioRenta();
		  		  
        try {
			
			formulariorenta=formulariorentaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formulariorenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta(this.formulariorenta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		formulariorenta = new  FormularioRenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			formulariorenta=formulariorentaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formulariorenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta(this.formulariorenta);
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
		formulariorenta = new  FormularioRenta();
		  		  
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
		formulariorenta = new  FormularioRenta();
		  		  
        try {
			
			formulariorenta=formulariorentaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formulariorenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta(this.formulariorenta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		formulariorenta = new  FormularioRenta();
		  		  
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
		formulariorenta = new  FormularioRenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =formulariorentaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		formulariorenta = new  FormularioRenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=formulariorentaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		formulariorenta = new  FormularioRenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =formulariorentaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		formulariorenta = new  FormularioRenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=formulariorentaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		formulariorenta = new  FormularioRenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =formulariorentaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		formulariorenta = new  FormularioRenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=formulariorentaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		formulariorentas = new  ArrayList<FormularioRenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			FormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulariorentas=formulariorentaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormularioRenta(formulariorentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta(this.formulariorentas);
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
		formulariorentas = new  ArrayList<FormularioRenta>();
		  		  
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
		formulariorentas = new  ArrayList<FormularioRenta>();
		  		  
        try {			
			FormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulariorentas=formulariorentaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarFormularioRenta(formulariorentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta(this.formulariorentas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		formulariorentas = new  ArrayList<FormularioRenta>();
		  		  
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
		formulariorentas = new  ArrayList<FormularioRenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			FormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulariorentas=formulariorentaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormularioRenta(formulariorentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta(this.formulariorentas);
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
		formulariorentas = new  ArrayList<FormularioRenta>();
		  		  
        try {
			FormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulariorentas=formulariorentaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormularioRenta(formulariorentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta(this.formulariorentas);
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
		formulariorentas = new  ArrayList<FormularioRenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulariorentas=formulariorentaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormularioRenta(formulariorentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta(this.formulariorentas);
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
		formulariorentas = new  ArrayList<FormularioRenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulariorentas=formulariorentaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormularioRenta(formulariorentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta(this.formulariorentas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		formulariorenta = new  FormularioRenta();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulariorenta=formulariorentaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormularioRenta(formulariorenta);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta(this.formulariorenta);
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
		formulariorenta = new  FormularioRenta();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulariorenta=formulariorentaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormularioRenta(formulariorenta);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta(this.formulariorenta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		formulariorentas = new  ArrayList<FormularioRenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			FormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulariorentas=formulariorentaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormularioRenta(formulariorentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta(this.formulariorentas);
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
		formulariorentas = new  ArrayList<FormularioRenta>();
		  		  
        try {
			FormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulariorentas=formulariorentaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormularioRenta(formulariorentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta(this.formulariorentas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosFormularioRentasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		formulariorentas = new  ArrayList<FormularioRenta>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta.class.getSimpleName()+"-getTodosFormularioRentasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulariorentas=formulariorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFormularioRenta(formulariorentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta(this.formulariorentas);
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
	
	public  void  getTodosFormularioRentas(String sFinalQuery,Pagination pagination)throws Exception {
		formulariorentas = new  ArrayList<FormularioRenta>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formulariorentas=formulariorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFormularioRenta(formulariorentas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta(this.formulariorentas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarFormularioRenta(FormularioRenta formulariorenta) throws Exception {
		Boolean estaValidado=false;
		
		if(formulariorenta.getIsNew() || formulariorenta.getIsChanged()) { 
			this.invalidValues = formulariorentaValidator.getInvalidValues(formulariorenta);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(formulariorenta);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarFormularioRenta(List<FormularioRenta> FormularioRentas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(FormularioRenta formulariorentaLocal:formulariorentas) {				
			estaValidadoObjeto=this.validarGuardarFormularioRenta(formulariorentaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarFormularioRenta(List<FormularioRenta> FormularioRentas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFormularioRenta(formulariorentas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarFormularioRenta(FormularioRenta FormularioRenta) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFormularioRenta(formulariorenta)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(FormularioRenta formulariorenta) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+formulariorenta.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=FormularioRentaConstantesFunciones.getFormularioRentaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"formulariorenta","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(FormularioRentaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(FormularioRentaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveFormularioRentaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta.class.getSimpleName()+"-saveFormularioRentaWithConnection");connexion.begin();			
			
			FormularioRentaLogicAdditional.checkFormularioRentaToSave(this.formulariorenta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FormularioRentaLogicAdditional.updateFormularioRentaToSave(this.formulariorenta,this.arrDatoGeneral);
			
			FormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.formulariorenta,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowFormularioRenta();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFormularioRenta(this.formulariorenta)) {
				FormularioRentaDataAccess.save(this.formulariorenta, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.formulariorenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FormularioRentaLogicAdditional.checkFormularioRentaToSaveAfter(this.formulariorenta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFormularioRenta();
			
			connexion.commit();			
			
			if(this.formulariorenta.getIsDeleted()) {
				this.formulariorenta=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveFormularioRenta()throws Exception {	
		try {	
			
			FormularioRentaLogicAdditional.checkFormularioRentaToSave(this.formulariorenta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FormularioRentaLogicAdditional.updateFormularioRentaToSave(this.formulariorenta,this.arrDatoGeneral);
			
			FormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.formulariorenta,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFormularioRenta(this.formulariorenta)) {			
				FormularioRentaDataAccess.save(this.formulariorenta, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.formulariorenta,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FormularioRentaLogicAdditional.checkFormularioRentaToSaveAfter(this.formulariorenta,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.formulariorenta.getIsDeleted()) {
				this.formulariorenta=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveFormularioRentasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta.class.getSimpleName()+"-saveFormularioRentasWithConnection");connexion.begin();			
			
			FormularioRentaLogicAdditional.checkFormularioRentaToSaves(formulariorentas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowFormularioRentas();
			
			Boolean validadoTodosFormularioRenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(FormularioRenta formulariorentaLocal:formulariorentas) {		
				if(formulariorentaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FormularioRentaLogicAdditional.updateFormularioRentaToSave(formulariorentaLocal,this.arrDatoGeneral);
	        	
				FormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),formulariorentaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFormularioRenta(formulariorentaLocal)) {
					FormularioRentaDataAccess.save(formulariorentaLocal, connexion);				
				} else {
					validadoTodosFormularioRenta=false;
				}
			}
			
			if(!validadoTodosFormularioRenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FormularioRentaLogicAdditional.checkFormularioRentaToSavesAfter(formulariorentas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFormularioRentas();
			
			connexion.commit();		
			
			this.quitarFormularioRentasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveFormularioRentas()throws Exception {				
		 try {	
			FormularioRentaLogicAdditional.checkFormularioRentaToSaves(formulariorentas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosFormularioRenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(FormularioRenta formulariorentaLocal:formulariorentas) {				
				if(formulariorentaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FormularioRentaLogicAdditional.updateFormularioRentaToSave(formulariorentaLocal,this.arrDatoGeneral);
	        	
				FormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),formulariorentaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFormularioRenta(formulariorentaLocal)) {				
					FormularioRentaDataAccess.save(formulariorentaLocal, connexion);				
				} else {
					validadoTodosFormularioRenta=false;
				}
			}
			
			if(!validadoTodosFormularioRenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FormularioRentaLogicAdditional.checkFormularioRentaToSavesAfter(formulariorentas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarFormularioRentasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FormularioRentaParameterReturnGeneral procesarAccionFormularioRentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FormularioRenta> formulariorentas,FormularioRentaParameterReturnGeneral formulariorentaParameterGeneral)throws Exception {
		 try {	
			FormularioRentaParameterReturnGeneral formulariorentaReturnGeneral=new FormularioRentaParameterReturnGeneral();
	
			FormularioRentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,formulariorentas,formulariorentaParameterGeneral,formulariorentaReturnGeneral);
			
			return formulariorentaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FormularioRentaParameterReturnGeneral procesarAccionFormularioRentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FormularioRenta> formulariorentas,FormularioRentaParameterReturnGeneral formulariorentaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta.class.getSimpleName()+"-procesarAccionFormularioRentasWithConnection");connexion.begin();			
			
			FormularioRentaParameterReturnGeneral formulariorentaReturnGeneral=new FormularioRentaParameterReturnGeneral();
	
			FormularioRentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,formulariorentas,formulariorentaParameterGeneral,formulariorentaReturnGeneral);
			
			this.connexion.commit();
			
			return formulariorentaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FormularioRentaParameterReturnGeneral procesarEventosFormularioRentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<FormularioRenta> formulariorentas,FormularioRenta formulariorenta,FormularioRentaParameterReturnGeneral formulariorentaParameterGeneral,Boolean isEsNuevoFormularioRenta,ArrayList<Classe> clases)throws Exception {
		 try {	
			FormularioRentaParameterReturnGeneral formulariorentaReturnGeneral=new FormularioRentaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				formulariorentaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FormularioRentaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,formulariorentas,formulariorenta,formulariorentaParameterGeneral,formulariorentaReturnGeneral,isEsNuevoFormularioRenta,clases);
			
			return formulariorentaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public FormularioRentaParameterReturnGeneral procesarEventosFormularioRentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<FormularioRenta> formulariorentas,FormularioRenta formulariorenta,FormularioRentaParameterReturnGeneral formulariorentaParameterGeneral,Boolean isEsNuevoFormularioRenta,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta.class.getSimpleName()+"-procesarEventosFormularioRentasWithConnection");connexion.begin();			
			
			FormularioRentaParameterReturnGeneral formulariorentaReturnGeneral=new FormularioRentaParameterReturnGeneral();
	
			formulariorentaReturnGeneral.setFormularioRenta(formulariorenta);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				formulariorentaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FormularioRentaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,formulariorentas,formulariorenta,formulariorentaParameterGeneral,formulariorentaReturnGeneral,isEsNuevoFormularioRenta,clases);
			
			this.connexion.commit();
			
			return formulariorentaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FormularioRentaParameterReturnGeneral procesarImportacionFormularioRentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,FormularioRentaParameterReturnGeneral formulariorentaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta.class.getSimpleName()+"-procesarImportacionFormularioRentasWithConnection");connexion.begin();			
			
			FormularioRentaParameterReturnGeneral formulariorentaReturnGeneral=new FormularioRentaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.formulariorentas=new ArrayList<FormularioRenta>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.formulariorenta=new FormularioRenta();
				
				
				if(conColumnasBase) {this.formulariorenta.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.formulariorenta.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.formulariorenta.setvalor_pagado(Double.parseDouble(arrColumnas[iColumn++]));
				this.formulariorenta.setimpuesto_retenido(Double.parseDouble(arrColumnas[iColumn++]));
				this.formulariorenta.setbase_impornible(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.formulariorentas.add(this.formulariorenta);
			}
			
			this.saveFormularioRentas();
			
			this.connexion.commit();
			
			formulariorentaReturnGeneral.setConRetornoEstaProcesado(true);
			formulariorentaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return formulariorentaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarFormularioRentasEliminados() throws Exception {				
		
		List<FormularioRenta> formulariorentasAux= new ArrayList<FormularioRenta>();
		
		for(FormularioRenta formulariorenta:formulariorentas) {
			if(!formulariorenta.getIsDeleted()) {
				formulariorentasAux.add(formulariorenta);
			}
		}
		
		formulariorentas=formulariorentasAux;
	}
	
	public void quitarFormularioRentasNulos() throws Exception {				
		
		List<FormularioRenta> formulariorentasAux= new ArrayList<FormularioRenta>();
		
		for(FormularioRenta formulariorenta : this.formulariorentas) {
			if(formulariorenta==null) {
				formulariorentasAux.add(formulariorenta);
			}
		}
		
		//this.formulariorentas=formulariorentasAux;
		
		this.formulariorentas.removeAll(formulariorentasAux);
	}
	
	public void getSetVersionRowFormularioRentaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(formulariorenta.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((formulariorenta.getIsDeleted() || (formulariorenta.getIsChanged()&&!formulariorenta.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=formulariorentaDataAccess.getSetVersionRowFormularioRenta(connexion,formulariorenta.getId());
				
				if(!formulariorenta.getVersionRow().equals(timestamp)) {	
					formulariorenta.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				formulariorenta.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowFormularioRenta()throws Exception {	
		
		if(formulariorenta.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((formulariorenta.getIsDeleted() || (formulariorenta.getIsChanged()&&!formulariorenta.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=formulariorentaDataAccess.getSetVersionRowFormularioRenta(connexion,formulariorenta.getId());
			
			try {							
				if(!formulariorenta.getVersionRow().equals(timestamp)) {	
					formulariorenta.setVersionRow(timestamp);
				}
				
				formulariorenta.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowFormularioRentasWithConnection()throws Exception {	
		if(formulariorentas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(FormularioRenta formulariorentaAux:formulariorentas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(formulariorentaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(formulariorentaAux.getIsDeleted() || (formulariorentaAux.getIsChanged()&&!formulariorentaAux.getIsNew())) {
						
						timestamp=formulariorentaDataAccess.getSetVersionRowFormularioRenta(connexion,formulariorentaAux.getId());
						
						if(!formulariorenta.getVersionRow().equals(timestamp)) {	
							formulariorentaAux.setVersionRow(timestamp);
						}
								
						formulariorentaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowFormularioRentas()throws Exception {	
		if(formulariorentas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(FormularioRenta formulariorentaAux:formulariorentas) {
					if(formulariorentaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(formulariorentaAux.getIsDeleted() || (formulariorentaAux.getIsChanged()&&!formulariorentaAux.getIsNew())) {
						
						timestamp=formulariorentaDataAccess.getSetVersionRowFormularioRenta(connexion,formulariorentaAux.getId());
						
						if(!formulariorentaAux.getVersionRow().equals(timestamp)) {	
							formulariorentaAux.setVersionRow(timestamp);
						}
						
													
						formulariorentaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public FormularioRentaParameterReturnGeneral cargarCombosLoteForeignKeyFormularioRentaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalDatoFormularioRenta,String finalQueryGlobalCuentaContable,String finalQueryGlobalTipoRetencion,String finalQueryGlobalParametroFormularioIva,String finalQueryGlobalPais) throws Exception {
		FormularioRentaParameterReturnGeneral  formulariorentaReturnGeneral =new FormularioRentaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta.class.getSimpleName()+"-cargarCombosLoteForeignKeyFormularioRentaWithConnection");connexion.begin();
			
			formulariorentaReturnGeneral =new FormularioRentaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			formulariorentaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			formulariorentaReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			formulariorentaReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<DatoFormularioRenta> datoformulariorentasForeignKey=new ArrayList<DatoFormularioRenta>();
			DatoFormularioRentaLogic datoformulariorentaLogic=new DatoFormularioRentaLogic();
			datoformulariorentaLogic.setConnexion(this.connexion);
			datoformulariorentaLogic.getDatoFormularioRentaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDatoFormularioRenta.equals("NONE")) {
				datoformulariorentaLogic.getTodosDatoFormularioRentas(finalQueryGlobalDatoFormularioRenta,new Pagination());
				datoformulariorentasForeignKey=datoformulariorentaLogic.getDatoFormularioRentas();
			}

			formulariorentaReturnGeneral.setdatoformulariorentasForeignKey(datoformulariorentasForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			formulariorentaReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<TipoRetencion> tiporetencionsForeignKey=new ArrayList<TipoRetencion>();
			TipoRetencionLogic tiporetencionLogic=new TipoRetencionLogic();
			tiporetencionLogic.setConnexion(this.connexion);
			tiporetencionLogic.getTipoRetencionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencion.equals("NONE")) {
				tiporetencionLogic.getTodosTipoRetencions(finalQueryGlobalTipoRetencion,new Pagination());
				tiporetencionsForeignKey=tiporetencionLogic.getTipoRetencions();
			}

			formulariorentaReturnGeneral.settiporetencionsForeignKey(tiporetencionsForeignKey);


			List<ParametroFormularioIva> parametroformularioivasForeignKey=new ArrayList<ParametroFormularioIva>();
			ParametroFormularioIvaLogic parametroformularioivaLogic=new ParametroFormularioIvaLogic();
			parametroformularioivaLogic.setConnexion(this.connexion);
			parametroformularioivaLogic.getParametroFormularioIvaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalParametroFormularioIva.equals("NONE")) {
				parametroformularioivaLogic.getTodosParametroFormularioIvas(finalQueryGlobalParametroFormularioIva,new Pagination());
				parametroformularioivasForeignKey=parametroformularioivaLogic.getParametroFormularioIvas();
			}

			formulariorentaReturnGeneral.setparametroformularioivasForeignKey(parametroformularioivasForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			formulariorentaReturnGeneral.setpaissForeignKey(paissForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return formulariorentaReturnGeneral;
	}
	
	public FormularioRentaParameterReturnGeneral cargarCombosLoteForeignKeyFormularioRenta(String finalQueryGlobalEmpresa,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalDatoFormularioRenta,String finalQueryGlobalCuentaContable,String finalQueryGlobalTipoRetencion,String finalQueryGlobalParametroFormularioIva,String finalQueryGlobalPais) throws Exception {
		FormularioRentaParameterReturnGeneral  formulariorentaReturnGeneral =new FormularioRentaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			formulariorentaReturnGeneral =new FormularioRentaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			formulariorentaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			formulariorentaReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			formulariorentaReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<DatoFormularioRenta> datoformulariorentasForeignKey=new ArrayList<DatoFormularioRenta>();
			DatoFormularioRentaLogic datoformulariorentaLogic=new DatoFormularioRentaLogic();
			datoformulariorentaLogic.setConnexion(this.connexion);
			datoformulariorentaLogic.getDatoFormularioRentaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDatoFormularioRenta.equals("NONE")) {
				datoformulariorentaLogic.getTodosDatoFormularioRentas(finalQueryGlobalDatoFormularioRenta,new Pagination());
				datoformulariorentasForeignKey=datoformulariorentaLogic.getDatoFormularioRentas();
			}

			formulariorentaReturnGeneral.setdatoformulariorentasForeignKey(datoformulariorentasForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			formulariorentaReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<TipoRetencion> tiporetencionsForeignKey=new ArrayList<TipoRetencion>();
			TipoRetencionLogic tiporetencionLogic=new TipoRetencionLogic();
			tiporetencionLogic.setConnexion(this.connexion);
			tiporetencionLogic.getTipoRetencionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencion.equals("NONE")) {
				tiporetencionLogic.getTodosTipoRetencions(finalQueryGlobalTipoRetencion,new Pagination());
				tiporetencionsForeignKey=tiporetencionLogic.getTipoRetencions();
			}

			formulariorentaReturnGeneral.settiporetencionsForeignKey(tiporetencionsForeignKey);


			List<ParametroFormularioIva> parametroformularioivasForeignKey=new ArrayList<ParametroFormularioIva>();
			ParametroFormularioIvaLogic parametroformularioivaLogic=new ParametroFormularioIvaLogic();
			parametroformularioivaLogic.setConnexion(this.connexion);
			parametroformularioivaLogic.getParametroFormularioIvaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalParametroFormularioIva.equals("NONE")) {
				parametroformularioivaLogic.getTodosParametroFormularioIvas(finalQueryGlobalParametroFormularioIva,new Pagination());
				parametroformularioivasForeignKey=parametroformularioivaLogic.getParametroFormularioIvas();
			}

			formulariorentaReturnGeneral.setparametroformularioivasForeignKey(parametroformularioivasForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			formulariorentaReturnGeneral.setpaissForeignKey(paissForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return formulariorentaReturnGeneral;
	}
	
	
	public void deepLoad(FormularioRenta formulariorenta,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			FormularioRentaLogicAdditional.updateFormularioRentaToGet(formulariorenta,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		formulariorenta.setEmpresa(formulariorentaDataAccess.getEmpresa(connexion,formulariorenta));
		formulariorenta.setEjercicio(formulariorentaDataAccess.getEjercicio(connexion,formulariorenta));
		formulariorenta.setPeriodo(formulariorentaDataAccess.getPeriodo(connexion,formulariorenta));
		formulariorenta.setDatoFormularioRenta(formulariorentaDataAccess.getDatoFormularioRenta(connexion,formulariorenta));
		formulariorenta.setCuentaContable(formulariorentaDataAccess.getCuentaContable(connexion,formulariorenta));
		formulariorenta.setTipoRetencion(formulariorentaDataAccess.getTipoRetencion(connexion,formulariorenta));
		formulariorenta.setParametroFormularioIva(formulariorentaDataAccess.getParametroFormularioIva(connexion,formulariorenta));
		formulariorenta.setPais(formulariorentaDataAccess.getPais(connexion,formulariorenta));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				formulariorenta.setEmpresa(formulariorentaDataAccess.getEmpresa(connexion,formulariorenta));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				formulariorenta.setEjercicio(formulariorentaDataAccess.getEjercicio(connexion,formulariorenta));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				formulariorenta.setPeriodo(formulariorentaDataAccess.getPeriodo(connexion,formulariorenta));
				continue;
			}

			if(clas.clas.equals(DatoFormularioRenta.class)) {
				formulariorenta.setDatoFormularioRenta(formulariorentaDataAccess.getDatoFormularioRenta(connexion,formulariorenta));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				formulariorenta.setCuentaContable(formulariorentaDataAccess.getCuentaContable(connexion,formulariorenta));
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				formulariorenta.setTipoRetencion(formulariorentaDataAccess.getTipoRetencion(connexion,formulariorenta));
				continue;
			}

			if(clas.clas.equals(ParametroFormularioIva.class)) {
				formulariorenta.setParametroFormularioIva(formulariorentaDataAccess.getParametroFormularioIva(connexion,formulariorenta));
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				formulariorenta.setPais(formulariorentaDataAccess.getPais(connexion,formulariorenta));
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
			formulariorenta.setEmpresa(formulariorentaDataAccess.getEmpresa(connexion,formulariorenta));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formulariorenta.setEjercicio(formulariorentaDataAccess.getEjercicio(connexion,formulariorenta));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formulariorenta.setPeriodo(formulariorentaDataAccess.getPeriodo(connexion,formulariorenta));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DatoFormularioRenta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formulariorenta.setDatoFormularioRenta(formulariorentaDataAccess.getDatoFormularioRenta(connexion,formulariorenta));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formulariorenta.setCuentaContable(formulariorentaDataAccess.getCuentaContable(connexion,formulariorenta));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formulariorenta.setTipoRetencion(formulariorentaDataAccess.getTipoRetencion(connexion,formulariorenta));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroFormularioIva.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formulariorenta.setParametroFormularioIva(formulariorentaDataAccess.getParametroFormularioIva(connexion,formulariorenta));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formulariorenta.setPais(formulariorentaDataAccess.getPais(connexion,formulariorenta));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		formulariorenta.setEmpresa(formulariorentaDataAccess.getEmpresa(connexion,formulariorenta));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(formulariorenta.getEmpresa(),isDeep,deepLoadType,clases);
				
		formulariorenta.setEjercicio(formulariorentaDataAccess.getEjercicio(connexion,formulariorenta));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(formulariorenta.getEjercicio(),isDeep,deepLoadType,clases);
				
		formulariorenta.setPeriodo(formulariorentaDataAccess.getPeriodo(connexion,formulariorenta));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(formulariorenta.getPeriodo(),isDeep,deepLoadType,clases);
				
		formulariorenta.setDatoFormularioRenta(formulariorentaDataAccess.getDatoFormularioRenta(connexion,formulariorenta));
		DatoFormularioRentaLogic datoformulariorentaLogic= new DatoFormularioRentaLogic(connexion);
		datoformulariorentaLogic.deepLoad(formulariorenta.getDatoFormularioRenta(),isDeep,deepLoadType,clases);
				
		formulariorenta.setCuentaContable(formulariorentaDataAccess.getCuentaContable(connexion,formulariorenta));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(formulariorenta.getCuentaContable(),isDeep,deepLoadType,clases);
				
		formulariorenta.setTipoRetencion(formulariorentaDataAccess.getTipoRetencion(connexion,formulariorenta));
		TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
		tiporetencionLogic.deepLoad(formulariorenta.getTipoRetencion(),isDeep,deepLoadType,clases);
				
		formulariorenta.setParametroFormularioIva(formulariorentaDataAccess.getParametroFormularioIva(connexion,formulariorenta));
		ParametroFormularioIvaLogic parametroformularioivaLogic= new ParametroFormularioIvaLogic(connexion);
		parametroformularioivaLogic.deepLoad(formulariorenta.getParametroFormularioIva(),isDeep,deepLoadType,clases);
				
		formulariorenta.setPais(formulariorentaDataAccess.getPais(connexion,formulariorenta));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(formulariorenta.getPais(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				formulariorenta.setEmpresa(formulariorentaDataAccess.getEmpresa(connexion,formulariorenta));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(formulariorenta.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				formulariorenta.setEjercicio(formulariorentaDataAccess.getEjercicio(connexion,formulariorenta));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(formulariorenta.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				formulariorenta.setPeriodo(formulariorentaDataAccess.getPeriodo(connexion,formulariorenta));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(formulariorenta.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DatoFormularioRenta.class)) {
				formulariorenta.setDatoFormularioRenta(formulariorentaDataAccess.getDatoFormularioRenta(connexion,formulariorenta));
				DatoFormularioRentaLogic datoformulariorentaLogic= new DatoFormularioRentaLogic(connexion);
				datoformulariorentaLogic.deepLoad(formulariorenta.getDatoFormularioRenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				formulariorenta.setCuentaContable(formulariorentaDataAccess.getCuentaContable(connexion,formulariorenta));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(formulariorenta.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				formulariorenta.setTipoRetencion(formulariorentaDataAccess.getTipoRetencion(connexion,formulariorenta));
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepLoad(formulariorenta.getTipoRetencion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ParametroFormularioIva.class)) {
				formulariorenta.setParametroFormularioIva(formulariorentaDataAccess.getParametroFormularioIva(connexion,formulariorenta));
				ParametroFormularioIvaLogic parametroformularioivaLogic= new ParametroFormularioIvaLogic(connexion);
				parametroformularioivaLogic.deepLoad(formulariorenta.getParametroFormularioIva(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				formulariorenta.setPais(formulariorentaDataAccess.getPais(connexion,formulariorenta));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(formulariorenta.getPais(),isDeep,deepLoadType,clases);				
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
			formulariorenta.setEmpresa(formulariorentaDataAccess.getEmpresa(connexion,formulariorenta));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(formulariorenta.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formulariorenta.setEjercicio(formulariorentaDataAccess.getEjercicio(connexion,formulariorenta));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(formulariorenta.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formulariorenta.setPeriodo(formulariorentaDataAccess.getPeriodo(connexion,formulariorenta));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(formulariorenta.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(DatoFormularioRenta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formulariorenta.setDatoFormularioRenta(formulariorentaDataAccess.getDatoFormularioRenta(connexion,formulariorenta));
			DatoFormularioRentaLogic datoformulariorentaLogic= new DatoFormularioRentaLogic(connexion);
			datoformulariorentaLogic.deepLoad(formulariorenta.getDatoFormularioRenta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formulariorenta.setCuentaContable(formulariorentaDataAccess.getCuentaContable(connexion,formulariorenta));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(formulariorenta.getCuentaContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formulariorenta.setTipoRetencion(formulariorentaDataAccess.getTipoRetencion(connexion,formulariorenta));
			TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
			tiporetencionLogic.deepLoad(formulariorenta.getTipoRetencion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(ParametroFormularioIva.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formulariorenta.setParametroFormularioIva(formulariorentaDataAccess.getParametroFormularioIva(connexion,formulariorenta));
			ParametroFormularioIvaLogic parametroformularioivaLogic= new ParametroFormularioIvaLogic(connexion);
			parametroformularioivaLogic.deepLoad(formulariorenta.getParametroFormularioIva(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formulariorenta.setPais(formulariorentaDataAccess.getPais(connexion,formulariorenta));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(formulariorenta.getPais(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(FormularioRenta formulariorenta,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			FormularioRentaLogicAdditional.updateFormularioRentaToSave(formulariorenta,this.arrDatoGeneral);
			
FormularioRentaDataAccess.save(formulariorenta, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(formulariorenta.getEmpresa(),connexion);

		EjercicioDataAccess.save(formulariorenta.getEjercicio(),connexion);

		PeriodoDataAccess.save(formulariorenta.getPeriodo(),connexion);

		DatoFormularioRentaDataAccess.save(formulariorenta.getDatoFormularioRenta(),connexion);

		CuentaContableDataAccess.save(formulariorenta.getCuentaContable(),connexion);

		TipoRetencionDataAccess.save(formulariorenta.getTipoRetencion(),connexion);

		ParametroFormularioIvaDataAccess.save(formulariorenta.getParametroFormularioIva(),connexion);

		PaisDataAccess.save(formulariorenta.getPais(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(formulariorenta.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(formulariorenta.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(formulariorenta.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(DatoFormularioRenta.class)) {
				DatoFormularioRentaDataAccess.save(formulariorenta.getDatoFormularioRenta(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(formulariorenta.getCuentaContable(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				TipoRetencionDataAccess.save(formulariorenta.getTipoRetencion(),connexion);
				continue;
			}

			if(clas.clas.equals(ParametroFormularioIva.class)) {
				ParametroFormularioIvaDataAccess.save(formulariorenta.getParametroFormularioIva(),connexion);
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(formulariorenta.getPais(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(formulariorenta.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(formulariorenta.getEmpresa(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(formulariorenta.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(formulariorenta.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(formulariorenta.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(formulariorenta.getPeriodo(),isDeep,deepLoadType,clases);
				

		DatoFormularioRentaDataAccess.save(formulariorenta.getDatoFormularioRenta(),connexion);
		DatoFormularioRentaLogic datoformulariorentaLogic= new DatoFormularioRentaLogic(connexion);
		datoformulariorentaLogic.deepLoad(formulariorenta.getDatoFormularioRenta(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(formulariorenta.getCuentaContable(),connexion);
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(formulariorenta.getCuentaContable(),isDeep,deepLoadType,clases);
				

		TipoRetencionDataAccess.save(formulariorenta.getTipoRetencion(),connexion);
		TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
		tiporetencionLogic.deepLoad(formulariorenta.getTipoRetencion(),isDeep,deepLoadType,clases);
				

		ParametroFormularioIvaDataAccess.save(formulariorenta.getParametroFormularioIva(),connexion);
		ParametroFormularioIvaLogic parametroformularioivaLogic= new ParametroFormularioIvaLogic(connexion);
		parametroformularioivaLogic.deepLoad(formulariorenta.getParametroFormularioIva(),isDeep,deepLoadType,clases);
				

		PaisDataAccess.save(formulariorenta.getPais(),connexion);
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(formulariorenta.getPais(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(formulariorenta.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(formulariorenta.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(formulariorenta.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(formulariorenta.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(formulariorenta.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(formulariorenta.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DatoFormularioRenta.class)) {
				DatoFormularioRentaDataAccess.save(formulariorenta.getDatoFormularioRenta(),connexion);
				DatoFormularioRentaLogic datoformulariorentaLogic= new DatoFormularioRentaLogic(connexion);
				datoformulariorentaLogic.deepSave(formulariorenta.getDatoFormularioRenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(formulariorenta.getCuentaContable(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(formulariorenta.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				TipoRetencionDataAccess.save(formulariorenta.getTipoRetencion(),connexion);
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepSave(formulariorenta.getTipoRetencion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(ParametroFormularioIva.class)) {
				ParametroFormularioIvaDataAccess.save(formulariorenta.getParametroFormularioIva(),connexion);
				ParametroFormularioIvaLogic parametroformularioivaLogic= new ParametroFormularioIvaLogic(connexion);
				parametroformularioivaLogic.deepSave(formulariorenta.getParametroFormularioIva(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(formulariorenta.getPais(),connexion);
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepSave(formulariorenta.getPais(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(FormularioRenta.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(formulariorenta,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta(formulariorenta);
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
			this.deepLoad(this.formulariorenta,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta(this.formulariorenta);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(FormularioRenta.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(formulariorentas!=null) {
				for(FormularioRenta formulariorenta:formulariorentas) {
					this.deepLoad(formulariorenta,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					FormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta(formulariorentas);
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
			if(formulariorentas!=null) {
				for(FormularioRenta formulariorenta:formulariorentas) {
					this.deepLoad(formulariorenta,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					FormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta(formulariorentas);
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
			this.getNewConnexionToDeep(FormularioRenta.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(formulariorenta,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(FormularioRenta.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(formulariorentas!=null) {
				for(FormularioRenta formulariorenta:formulariorentas) {
					this.deepSave(formulariorenta,isDeep,deepLoadType,clases);
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
			if(formulariorentas!=null) {
				for(FormularioRenta formulariorenta:formulariorentas) {
					this.deepSave(formulariorenta,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getFormularioRentasFK_IdCuentaContableWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,FormularioRentaConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			FormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formulariorentas=formulariorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta(this.formulariorentas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormularioRentasFK_IdCuentaContable(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,FormularioRentaConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			FormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formulariorentas=formulariorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta(this.formulariorentas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormularioRentasFK_IdDatoFormularioRentaWithConnection(String sFinalQuery,Pagination pagination,Long id_dato_formulario_renta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDatoFormularioRenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDatoFormularioRenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_dato_formulario_renta,FormularioRentaConstantesFunciones.IDDATOFORMULARIORENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDatoFormularioRenta);

			FormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDatoFormularioRenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formulariorentas=formulariorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta(this.formulariorentas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormularioRentasFK_IdDatoFormularioRenta(String sFinalQuery,Pagination pagination,Long id_dato_formulario_renta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDatoFormularioRenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDatoFormularioRenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_dato_formulario_renta,FormularioRentaConstantesFunciones.IDDATOFORMULARIORENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDatoFormularioRenta);

			FormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDatoFormularioRenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formulariorentas=formulariorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta(this.formulariorentas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormularioRentasFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,FormularioRentaConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			FormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formulariorentas=formulariorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta(this.formulariorentas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormularioRentasFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,FormularioRentaConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			FormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formulariorentas=formulariorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta(this.formulariorentas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormularioRentasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FormularioRentaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formulariorentas=formulariorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta(this.formulariorentas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormularioRentasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FormularioRentaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formulariorentas=formulariorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta(this.formulariorentas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormularioRentasFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,FormularioRentaConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			FormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formulariorentas=formulariorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta(this.formulariorentas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormularioRentasFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,FormularioRentaConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			FormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formulariorentas=formulariorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta(this.formulariorentas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormularioRentasFK_IdParametroFormularioIvaWithConnection(String sFinalQuery,Pagination pagination,Long id_parametro_formulario_iva)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidParametroFormularioIva= new ParameterSelectionGeneral();
			parameterSelectionGeneralidParametroFormularioIva.setParameterSelectionGeneralEqual(ParameterType.LONG,id_parametro_formulario_iva,FormularioRentaConstantesFunciones.IDPARAMETROFORMULARIOIVA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidParametroFormularioIva);

			FormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdParametroFormularioIva","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formulariorentas=formulariorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta(this.formulariorentas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormularioRentasFK_IdParametroFormularioIva(String sFinalQuery,Pagination pagination,Long id_parametro_formulario_iva)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidParametroFormularioIva= new ParameterSelectionGeneral();
			parameterSelectionGeneralidParametroFormularioIva.setParameterSelectionGeneralEqual(ParameterType.LONG,id_parametro_formulario_iva,FormularioRentaConstantesFunciones.IDPARAMETROFORMULARIOIVA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidParametroFormularioIva);

			FormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdParametroFormularioIva","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formulariorentas=formulariorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta(this.formulariorentas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormularioRentasFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,FormularioRentaConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			FormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formulariorentas=formulariorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta(this.formulariorentas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormularioRentasFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,FormularioRentaConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			FormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formulariorentas=formulariorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta(this.formulariorentas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormularioRentasFK_IdTipoRetencionWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_retencion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormularioRenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion,FormularioRentaConstantesFunciones.IDTIPORETENCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencion);

			FormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formulariorentas=formulariorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta(this.formulariorentas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormularioRentasFK_IdTipoRetencion(String sFinalQuery,Pagination pagination,Long id_tipo_retencion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion,FormularioRentaConstantesFunciones.IDTIPORETENCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencion);

			FormularioRentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formulariorentas=formulariorentaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormularioRentaConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRenta(this.formulariorentas);
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
			if(FormularioRentaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,FormularioRentaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,FormularioRenta formulariorenta,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(FormularioRentaConstantesFunciones.ISCONAUDITORIA) {
				if(formulariorenta.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FormularioRentaDataAccess.TABLENAME, formulariorenta.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FormularioRentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FormularioRentaLogic.registrarAuditoriaDetallesFormularioRenta(connexion,formulariorenta,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(formulariorenta.getIsDeleted()) {
					/*if(!formulariorenta.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,FormularioRentaDataAccess.TABLENAME, formulariorenta.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////FormularioRentaLogic.registrarAuditoriaDetallesFormularioRenta(connexion,formulariorenta,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FormularioRentaDataAccess.TABLENAME, formulariorenta.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(formulariorenta.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FormularioRentaDataAccess.TABLENAME, formulariorenta.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FormularioRentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FormularioRentaLogic.registrarAuditoriaDetallesFormularioRenta(connexion,formulariorenta,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesFormularioRenta(Connexion connexion,FormularioRenta formulariorenta)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(formulariorenta.getIsNew()||!formulariorenta.getid_empresa().equals(formulariorenta.getFormularioRentaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorenta.getFormularioRentaOriginal().getid_empresa()!=null)
				{
					strValorActual=formulariorenta.getFormularioRentaOriginal().getid_empresa().toString();
				}
				if(formulariorenta.getid_empresa()!=null)
				{
					strValorNuevo=formulariorenta.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(formulariorenta.getIsNew()||!formulariorenta.getid_ejercicio().equals(formulariorenta.getFormularioRentaOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorenta.getFormularioRentaOriginal().getid_ejercicio()!=null)
				{
					strValorActual=formulariorenta.getFormularioRentaOriginal().getid_ejercicio().toString();
				}
				if(formulariorenta.getid_ejercicio()!=null)
				{
					strValorNuevo=formulariorenta.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(formulariorenta.getIsNew()||!formulariorenta.getid_periodo().equals(formulariorenta.getFormularioRentaOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorenta.getFormularioRentaOriginal().getid_periodo()!=null)
				{
					strValorActual=formulariorenta.getFormularioRentaOriginal().getid_periodo().toString();
				}
				if(formulariorenta.getid_periodo()!=null)
				{
					strValorNuevo=formulariorenta.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(formulariorenta.getIsNew()||!formulariorenta.getid_dato_formulario_renta().equals(formulariorenta.getFormularioRentaOriginal().getid_dato_formulario_renta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorenta.getFormularioRentaOriginal().getid_dato_formulario_renta()!=null)
				{
					strValorActual=formulariorenta.getFormularioRentaOriginal().getid_dato_formulario_renta().toString();
				}
				if(formulariorenta.getid_dato_formulario_renta()!=null)
				{
					strValorNuevo=formulariorenta.getid_dato_formulario_renta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaConstantesFunciones.IDDATOFORMULARIORENTA,strValorActual,strValorNuevo);
			}	
			
			if(formulariorenta.getIsNew()||!formulariorenta.getid_cuenta_contable().equals(formulariorenta.getFormularioRentaOriginal().getid_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorenta.getFormularioRentaOriginal().getid_cuenta_contable()!=null)
				{
					strValorActual=formulariorenta.getFormularioRentaOriginal().getid_cuenta_contable().toString();
				}
				if(formulariorenta.getid_cuenta_contable()!=null)
				{
					strValorNuevo=formulariorenta.getid_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaConstantesFunciones.IDCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(formulariorenta.getIsNew()||!formulariorenta.getid_tipo_retencion().equals(formulariorenta.getFormularioRentaOriginal().getid_tipo_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorenta.getFormularioRentaOriginal().getid_tipo_retencion()!=null)
				{
					strValorActual=formulariorenta.getFormularioRentaOriginal().getid_tipo_retencion().toString();
				}
				if(formulariorenta.getid_tipo_retencion()!=null)
				{
					strValorNuevo=formulariorenta.getid_tipo_retencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaConstantesFunciones.IDTIPORETENCION,strValorActual,strValorNuevo);
			}	
			
			if(formulariorenta.getIsNew()||!formulariorenta.getid_parametro_formulario_iva().equals(formulariorenta.getFormularioRentaOriginal().getid_parametro_formulario_iva()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorenta.getFormularioRentaOriginal().getid_parametro_formulario_iva()!=null)
				{
					strValorActual=formulariorenta.getFormularioRentaOriginal().getid_parametro_formulario_iva().toString();
				}
				if(formulariorenta.getid_parametro_formulario_iva()!=null)
				{
					strValorNuevo=formulariorenta.getid_parametro_formulario_iva().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaConstantesFunciones.IDPARAMETROFORMULARIOIVA,strValorActual,strValorNuevo);
			}	
			
			if(formulariorenta.getIsNew()||!formulariorenta.getid_pais().equals(formulariorenta.getFormularioRentaOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorenta.getFormularioRentaOriginal().getid_pais()!=null)
				{
					strValorActual=formulariorenta.getFormularioRentaOriginal().getid_pais().toString();
				}
				if(formulariorenta.getid_pais()!=null)
				{
					strValorNuevo=formulariorenta.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(formulariorenta.getIsNew()||!formulariorenta.getvalor_pagado().equals(formulariorenta.getFormularioRentaOriginal().getvalor_pagado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorenta.getFormularioRentaOriginal().getvalor_pagado()!=null)
				{
					strValorActual=formulariorenta.getFormularioRentaOriginal().getvalor_pagado().toString();
				}
				if(formulariorenta.getvalor_pagado()!=null)
				{
					strValorNuevo=formulariorenta.getvalor_pagado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaConstantesFunciones.VALORPAGADO,strValorActual,strValorNuevo);
			}	
			
			if(formulariorenta.getIsNew()||!formulariorenta.getimpuesto_retenido().equals(formulariorenta.getFormularioRentaOriginal().getimpuesto_retenido()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorenta.getFormularioRentaOriginal().getimpuesto_retenido()!=null)
				{
					strValorActual=formulariorenta.getFormularioRentaOriginal().getimpuesto_retenido().toString();
				}
				if(formulariorenta.getimpuesto_retenido()!=null)
				{
					strValorNuevo=formulariorenta.getimpuesto_retenido().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaConstantesFunciones.IMPUESTORETENIDO,strValorActual,strValorNuevo);
			}	
			
			if(formulariorenta.getIsNew()||!formulariorenta.getbase_impornible().equals(formulariorenta.getFormularioRentaOriginal().getbase_impornible()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formulariorenta.getFormularioRentaOriginal().getbase_impornible()!=null)
				{
					strValorActual=formulariorenta.getFormularioRentaOriginal().getbase_impornible().toString();
				}
				if(formulariorenta.getbase_impornible()!=null)
				{
					strValorNuevo=formulariorenta.getbase_impornible().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormularioRentaConstantesFunciones.BASEIMPORNIBLE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveFormularioRentaRelacionesWithConnection(FormularioRenta formulariorenta) throws Exception {

		if(!formulariorenta.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFormularioRentaRelacionesBase(formulariorenta,true);
		}
	}

	public void saveFormularioRentaRelaciones(FormularioRenta formulariorenta)throws Exception {

		if(!formulariorenta.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFormularioRentaRelacionesBase(formulariorenta,false);
		}
	}

	public void saveFormularioRentaRelacionesBase(FormularioRenta formulariorenta,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("FormularioRenta-saveRelacionesWithConnection");}
	

			this.setFormularioRenta(formulariorenta);

			if(FormularioRentaLogicAdditional.validarSaveRelaciones(formulariorenta,this)) {

				FormularioRentaLogicAdditional.updateRelacionesToSave(formulariorenta,this);

				if((formulariorenta.getIsNew()||formulariorenta.getIsChanged())&&!formulariorenta.getIsDeleted()) {
					this.saveFormularioRenta();
					this.saveFormularioRentaRelacionesDetalles();

				} else if(formulariorenta.getIsDeleted()) {
					this.saveFormularioRentaRelacionesDetalles();
					this.saveFormularioRenta();
				}

				FormularioRentaLogicAdditional.updateRelacionesToSaveAfter(formulariorenta,this);

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
	
	
	private void saveFormularioRentaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfFormularioRenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FormularioRentaConstantesFunciones.getClassesForeignKeysOfFormularioRenta(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFormularioRenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FormularioRentaConstantesFunciones.getClassesRelationshipsOfFormularioRenta(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

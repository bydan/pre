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
package com.bydan.erp.tesoreria.business.logic;

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
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.tesoreria.util.FormaPagoConstantesFunciones;
import com.bydan.erp.tesoreria.util.FormaPagoParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.FormaPagoParameterGeneral;
import com.bydan.erp.tesoreria.business.entity.FormaPago;
import com.bydan.erp.tesoreria.business.logic.FormaPagoLogicAdditional;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;








@SuppressWarnings("unused")
public class FormaPagoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(FormaPagoLogic.class);
	
	protected FormaPagoDataAccess formapagoDataAccess; 	
	protected FormaPago formapago;
	protected List<FormaPago> formapagos;
	protected Object formapagoObject;	
	protected List<Object> formapagosObject;
	
	public static ClassValidator<FormaPago> formapagoValidator = new ClassValidator<FormaPago>(FormaPago.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected FormaPagoLogicAdditional formapagoLogicAdditional=null;
	
	public FormaPagoLogicAdditional getFormaPagoLogicAdditional() {
		return this.formapagoLogicAdditional;
	}
	
	public void setFormaPagoLogicAdditional(FormaPagoLogicAdditional formapagoLogicAdditional) {
		try {
			this.formapagoLogicAdditional=formapagoLogicAdditional;
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
	
	
	
	
	public  FormaPagoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.formapagoDataAccess = new FormaPagoDataAccess();
			
			this.formapagos= new ArrayList<FormaPago>();
			this.formapago= new FormaPago();
			
			this.formapagoObject=new Object();
			this.formapagosObject=new ArrayList<Object>();
				
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
			
			this.formapagoDataAccess.setConnexionType(this.connexionType);
			this.formapagoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  FormaPagoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.formapagoDataAccess = new FormaPagoDataAccess();
			this.formapagos= new ArrayList<FormaPago>();
			this.formapago= new FormaPago();
			this.formapagoObject=new Object();
			this.formapagosObject=new ArrayList<Object>();
			
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
			
			this.formapagoDataAccess.setConnexionType(this.connexionType);
			this.formapagoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public FormaPago getFormaPago() throws Exception {	
		FormaPagoLogicAdditional.checkFormaPagoToGet(formapago,this.datosCliente,this.arrDatoGeneral);
		FormaPagoLogicAdditional.updateFormaPagoToGet(formapago,this.arrDatoGeneral);
		
		return formapago;
	}
		
	public void setFormaPago(FormaPago newFormaPago) {
		this.formapago = newFormaPago;
	}
	
	public FormaPagoDataAccess getFormaPagoDataAccess() {
		return formapagoDataAccess;
	}
	
	public void setFormaPagoDataAccess(FormaPagoDataAccess newformapagoDataAccess) {
		this.formapagoDataAccess = newformapagoDataAccess;
	}
	
	public List<FormaPago> getFormaPagos() throws Exception {		
		this.quitarFormaPagosNulos();
		
		FormaPagoLogicAdditional.checkFormaPagoToGets(formapagos,this.datosCliente,this.arrDatoGeneral);
		
		for (FormaPago formapagoLocal: formapagos ) {
			FormaPagoLogicAdditional.updateFormaPagoToGet(formapagoLocal,this.arrDatoGeneral);
		}
		
		return formapagos;
	}
	
	public void setFormaPagos(List<FormaPago> newFormaPagos) {
		this.formapagos = newFormaPagos;
	}
	
	public Object getFormaPagoObject() {	
		this.formapagoObject=this.formapagoDataAccess.getEntityObject();
		return this.formapagoObject;
	}
		
	public void setFormaPagoObject(Object newFormaPagoObject) {
		this.formapagoObject = newFormaPagoObject;
	}
	
	public List<Object> getFormaPagosObject() {		
		this.formapagosObject=this.formapagoDataAccess.getEntitiesObject();
		return this.formapagosObject;
	}
		
	public void setFormaPagosObject(List<Object> newFormaPagosObject) {
		this.formapagosObject = newFormaPagosObject;
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
		
		if(this.formapagoDataAccess!=null) {
			this.formapagoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPago.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			formapagoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			formapagoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		formapago = new  FormaPago();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPago.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			formapago=formapagoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapago);
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
		formapago = new  FormaPago();
		  		  
        try {
			
			formapago=formapagoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapago);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		formapago = new  FormaPago();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPago.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			formapago=formapagoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapago);
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
		formapago = new  FormaPago();
		  		  
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
		formapago = new  FormaPago();
		  		  
        try {
			
			formapago=formapagoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapago);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		formapago = new  FormaPago();
		  		  
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
		formapago = new  FormaPago();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPago.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =formapagoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		formapago = new  FormaPago();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=formapagoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		formapago = new  FormaPago();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPago.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =formapagoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		formapago = new  FormaPago();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=formapagoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		formapago = new  FormaPago();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPago.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =formapagoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		formapago = new  FormaPago();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=formapagoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		formapagos = new  ArrayList<FormaPago>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPago.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formapagos=formapagoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormaPago(formapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapagos);
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
		formapagos = new  ArrayList<FormaPago>();
		  		  
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
		formapagos = new  ArrayList<FormaPago>();
		  		  
        try {			
			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formapagos=formapagoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarFormaPago(formapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapagos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		formapagos = new  ArrayList<FormaPago>();
		  		  
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
		formapagos = new  ArrayList<FormaPago>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPago.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formapagos=formapagoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormaPago(formapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapagos);
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
		formapagos = new  ArrayList<FormaPago>();
		  		  
        try {
			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formapagos=formapagoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormaPago(formapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapagos);
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
		formapagos = new  ArrayList<FormaPago>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPago.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formapagos=formapagoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormaPago(formapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapagos);
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
		formapagos = new  ArrayList<FormaPago>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formapagos=formapagoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormaPago(formapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapagos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		formapago = new  FormaPago();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPago.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formapago=formapagoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormaPago(formapago);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapago);
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
		formapago = new  FormaPago();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formapago=formapagoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormaPago(formapago);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapago);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		formapagos = new  ArrayList<FormaPago>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPago.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formapagos=formapagoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormaPago(formapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapagos);
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
		formapagos = new  ArrayList<FormaPago>();
		  		  
        try {
			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formapagos=formapagoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormaPago(formapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapagos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosFormaPagosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		formapagos = new  ArrayList<FormaPago>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPago.class.getSimpleName()+"-getTodosFormaPagosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formapagos=formapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFormaPago(formapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapagos);
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
	
	public  void  getTodosFormaPagos(String sFinalQuery,Pagination pagination)throws Exception {
		formapagos = new  ArrayList<FormaPago>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formapagos=formapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFormaPago(formapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapagos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarFormaPago(FormaPago formapago) throws Exception {
		Boolean estaValidado=false;
		
		if(formapago.getIsNew() || formapago.getIsChanged()) { 
			this.invalidValues = formapagoValidator.getInvalidValues(formapago);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(formapago);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarFormaPago(List<FormaPago> FormaPagos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(FormaPago formapagoLocal:formapagos) {				
			estaValidadoObjeto=this.validarGuardarFormaPago(formapagoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarFormaPago(List<FormaPago> FormaPagos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFormaPago(formapagos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarFormaPago(FormaPago FormaPago) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFormaPago(formapago)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(FormaPago formapago) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+formapago.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=FormaPagoConstantesFunciones.getFormaPagoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"formapago","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(FormaPagoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(FormaPagoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveFormaPagoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPago.class.getSimpleName()+"-saveFormaPagoWithConnection");connexion.begin();			
			
			FormaPagoLogicAdditional.checkFormaPagoToSave(this.formapago,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FormaPagoLogicAdditional.updateFormaPagoToSave(this.formapago,this.arrDatoGeneral);
			
			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.formapago,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowFormaPago();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFormaPago(this.formapago)) {
				FormaPagoDataAccess.save(this.formapago, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.formapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FormaPagoLogicAdditional.checkFormaPagoToSaveAfter(this.formapago,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFormaPago();
			
			connexion.commit();			
			
			if(this.formapago.getIsDeleted()) {
				this.formapago=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveFormaPago()throws Exception {	
		try {	
			
			FormaPagoLogicAdditional.checkFormaPagoToSave(this.formapago,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FormaPagoLogicAdditional.updateFormaPagoToSave(this.formapago,this.arrDatoGeneral);
			
			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.formapago,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFormaPago(this.formapago)) {			
				FormaPagoDataAccess.save(this.formapago, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.formapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FormaPagoLogicAdditional.checkFormaPagoToSaveAfter(this.formapago,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.formapago.getIsDeleted()) {
				this.formapago=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveFormaPagosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPago.class.getSimpleName()+"-saveFormaPagosWithConnection");connexion.begin();			
			
			FormaPagoLogicAdditional.checkFormaPagoToSaves(formapagos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowFormaPagos();
			
			Boolean validadoTodosFormaPago=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(FormaPago formapagoLocal:formapagos) {		
				if(formapagoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FormaPagoLogicAdditional.updateFormaPagoToSave(formapagoLocal,this.arrDatoGeneral);
	        	
				FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),formapagoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFormaPago(formapagoLocal)) {
					FormaPagoDataAccess.save(formapagoLocal, connexion);				
				} else {
					validadoTodosFormaPago=false;
				}
			}
			
			if(!validadoTodosFormaPago) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FormaPagoLogicAdditional.checkFormaPagoToSavesAfter(formapagos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFormaPagos();
			
			connexion.commit();		
			
			this.quitarFormaPagosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveFormaPagos()throws Exception {				
		 try {	
			FormaPagoLogicAdditional.checkFormaPagoToSaves(formapagos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosFormaPago=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(FormaPago formapagoLocal:formapagos) {				
				if(formapagoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FormaPagoLogicAdditional.updateFormaPagoToSave(formapagoLocal,this.arrDatoGeneral);
	        	
				FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),formapagoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFormaPago(formapagoLocal)) {				
					FormaPagoDataAccess.save(formapagoLocal, connexion);				
				} else {
					validadoTodosFormaPago=false;
				}
			}
			
			if(!validadoTodosFormaPago) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FormaPagoLogicAdditional.checkFormaPagoToSavesAfter(formapagos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarFormaPagosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FormaPagoParameterReturnGeneral procesarAccionFormaPagos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FormaPago> formapagos,FormaPagoParameterReturnGeneral formapagoParameterGeneral)throws Exception {
		 try {	
			FormaPagoParameterReturnGeneral formapagoReturnGeneral=new FormaPagoParameterReturnGeneral();
	
			FormaPagoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,formapagos,formapagoParameterGeneral,formapagoReturnGeneral);
			
			return formapagoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FormaPagoParameterReturnGeneral procesarAccionFormaPagosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FormaPago> formapagos,FormaPagoParameterReturnGeneral formapagoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPago.class.getSimpleName()+"-procesarAccionFormaPagosWithConnection");connexion.begin();			
			
			FormaPagoParameterReturnGeneral formapagoReturnGeneral=new FormaPagoParameterReturnGeneral();
	
			FormaPagoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,formapagos,formapagoParameterGeneral,formapagoReturnGeneral);
			
			this.connexion.commit();
			
			return formapagoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FormaPagoParameterReturnGeneral procesarEventosFormaPagos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<FormaPago> formapagos,FormaPago formapago,FormaPagoParameterReturnGeneral formapagoParameterGeneral,Boolean isEsNuevoFormaPago,ArrayList<Classe> clases)throws Exception {
		 try {	
			FormaPagoParameterReturnGeneral formapagoReturnGeneral=new FormaPagoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				formapagoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FormaPagoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,formapagos,formapago,formapagoParameterGeneral,formapagoReturnGeneral,isEsNuevoFormaPago,clases);
			
			return formapagoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public FormaPagoParameterReturnGeneral procesarEventosFormaPagosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<FormaPago> formapagos,FormaPago formapago,FormaPagoParameterReturnGeneral formapagoParameterGeneral,Boolean isEsNuevoFormaPago,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPago.class.getSimpleName()+"-procesarEventosFormaPagosWithConnection");connexion.begin();			
			
			FormaPagoParameterReturnGeneral formapagoReturnGeneral=new FormaPagoParameterReturnGeneral();
	
			formapagoReturnGeneral.setFormaPago(formapago);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				formapagoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FormaPagoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,formapagos,formapago,formapagoParameterGeneral,formapagoReturnGeneral,isEsNuevoFormaPago,clases);
			
			this.connexion.commit();
			
			return formapagoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FormaPagoParameterReturnGeneral procesarImportacionFormaPagosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,FormaPagoParameterReturnGeneral formapagoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPago.class.getSimpleName()+"-procesarImportacionFormaPagosWithConnection");connexion.begin();			
			
			FormaPagoParameterReturnGeneral formapagoReturnGeneral=new FormaPagoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.formapagos=new ArrayList<FormaPago>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.formapago=new FormaPago();
				
				
				if(conColumnasBase) {this.formapago.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.formapago.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.formapago.setnombre(arrColumnas[iColumn++]);
				this.formapago.setsiglas(arrColumnas[iColumn++]);
				this.formapago.setnumero_dias(Integer.parseInt(arrColumnas[iColumn++]));
				this.formapago.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.formapago.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				this.formapago.setcon_detalle(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.formapago.setcon_remesa(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.formapago.setcon_maneja_cuotas(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.formapago.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.formapago.setfecha_fin(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.formapago.setporcentaje_rete(Double.parseDouble(arrColumnas[iColumn++]));
				this.formapago.setbase_retencion(Double.parseDouble(arrColumnas[iColumn++]));
				this.formapago.setvalor_retencion(Double.parseDouble(arrColumnas[iColumn++]));
				this.formapago.setnumero_retencion(arrColumnas[iColumn++]);
				this.formapago.setnombre_retencion(arrColumnas[iColumn++]);
				
				this.formapagos.add(this.formapago);
			}
			
			this.saveFormaPagos();
			
			this.connexion.commit();
			
			formapagoReturnGeneral.setConRetornoEstaProcesado(true);
			formapagoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return formapagoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarFormaPagosEliminados() throws Exception {				
		
		List<FormaPago> formapagosAux= new ArrayList<FormaPago>();
		
		for(FormaPago formapago:formapagos) {
			if(!formapago.getIsDeleted()) {
				formapagosAux.add(formapago);
			}
		}
		
		formapagos=formapagosAux;
	}
	
	public void quitarFormaPagosNulos() throws Exception {				
		
		List<FormaPago> formapagosAux= new ArrayList<FormaPago>();
		
		for(FormaPago formapago : this.formapagos) {
			if(formapago==null) {
				formapagosAux.add(formapago);
			}
		}
		
		//this.formapagos=formapagosAux;
		
		this.formapagos.removeAll(formapagosAux);
	}
	
	public void getSetVersionRowFormaPagoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(formapago.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((formapago.getIsDeleted() || (formapago.getIsChanged()&&!formapago.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=formapagoDataAccess.getSetVersionRowFormaPago(connexion,formapago.getId());
				
				if(!formapago.getVersionRow().equals(timestamp)) {	
					formapago.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				formapago.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowFormaPago()throws Exception {	
		
		if(formapago.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((formapago.getIsDeleted() || (formapago.getIsChanged()&&!formapago.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=formapagoDataAccess.getSetVersionRowFormaPago(connexion,formapago.getId());
			
			try {							
				if(!formapago.getVersionRow().equals(timestamp)) {	
					formapago.setVersionRow(timestamp);
				}
				
				formapago.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowFormaPagosWithConnection()throws Exception {	
		if(formapagos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(FormaPago formapagoAux:formapagos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(formapagoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(formapagoAux.getIsDeleted() || (formapagoAux.getIsChanged()&&!formapagoAux.getIsNew())) {
						
						timestamp=formapagoDataAccess.getSetVersionRowFormaPago(connexion,formapagoAux.getId());
						
						if(!formapago.getVersionRow().equals(timestamp)) {	
							formapagoAux.setVersionRow(timestamp);
						}
								
						formapagoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowFormaPagos()throws Exception {	
		if(formapagos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(FormaPago formapagoAux:formapagos) {
					if(formapagoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(formapagoAux.getIsDeleted() || (formapagoAux.getIsChanged()&&!formapagoAux.getIsNew())) {
						
						timestamp=formapagoDataAccess.getSetVersionRowFormaPago(connexion,formapagoAux.getId());
						
						if(!formapagoAux.getVersionRow().equals(timestamp)) {	
							formapagoAux.setVersionRow(timestamp);
						}
						
													
						formapagoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public FormaPagoParameterReturnGeneral cargarCombosLoteForeignKeyFormaPagoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalModulo,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalTipoFormaPago,String finalQueryGlobalTransaccion,String finalQueryGlobalTipoTransaccionModulo,String finalQueryGlobalCuentaContable,String finalQueryGlobalCuentaContableRete) throws Exception {
		FormaPagoParameterReturnGeneral  formapagoReturnGeneral =new FormaPagoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPago.class.getSimpleName()+"-cargarCombosLoteForeignKeyFormaPagoWithConnection");connexion.begin();
			
			formapagoReturnGeneral =new FormaPagoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			formapagoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			formapagoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			formapagoReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			formapagoReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			formapagoReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			formapagoReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			formapagoReturnGeneral.setmessForeignKey(messForeignKey);


			List<TipoFormaPago> tipoformapagosForeignKey=new ArrayList<TipoFormaPago>();
			TipoFormaPagoLogic tipoformapagoLogic=new TipoFormaPagoLogic();
			tipoformapagoLogic.setConnexion(this.connexion);
			tipoformapagoLogic.getTipoFormaPagoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoFormaPago.equals("NONE")) {
				tipoformapagoLogic.getTodosTipoFormaPagos(finalQueryGlobalTipoFormaPago,new Pagination());
				tipoformapagosForeignKey=tipoformapagoLogic.getTipoFormaPagos();
			}

			formapagoReturnGeneral.settipoformapagosForeignKey(tipoformapagosForeignKey);


			List<Transaccion> transaccionsForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			transaccionLogic.setConnexion(this.connexion);
			transaccionLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion.equals("NONE")) {
				transaccionLogic.getTodosTransaccions(finalQueryGlobalTransaccion,new Pagination());
				transaccionsForeignKey=transaccionLogic.getTransaccions();
			}

			formapagoReturnGeneral.settransaccionsForeignKey(transaccionsForeignKey);


			List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic=new TipoTransaccionModuloLogic();
			tipotransaccionmoduloLogic.setConnexion(this.connexion);
			tipotransaccionmoduloLogic.getTipoTransaccionModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTransaccionModulo.equals("NONE")) {
				tipotransaccionmoduloLogic.getTodosTipoTransaccionModulos(finalQueryGlobalTipoTransaccionModulo,new Pagination());
				tipotransaccionmodulosForeignKey=tipotransaccionmoduloLogic.getTipoTransaccionModulos();
			}

			formapagoReturnGeneral.settipotransaccionmodulosForeignKey(tipotransaccionmodulosForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			formapagoReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<CuentaContable> cuentacontableretesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablereteLogic=new CuentaContableLogic();
			cuentacontablereteLogic.setConnexion(this.connexion);
			cuentacontablereteLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableRete.equals("NONE")) {
				cuentacontablereteLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableRete,new Pagination());
				cuentacontableretesForeignKey=cuentacontablereteLogic.getCuentaContables();
			}

			formapagoReturnGeneral.setcuentacontableretesForeignKey(cuentacontableretesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return formapagoReturnGeneral;
	}
	
	public FormaPagoParameterReturnGeneral cargarCombosLoteForeignKeyFormaPago(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalModulo,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalTipoFormaPago,String finalQueryGlobalTransaccion,String finalQueryGlobalTipoTransaccionModulo,String finalQueryGlobalCuentaContable,String finalQueryGlobalCuentaContableRete) throws Exception {
		FormaPagoParameterReturnGeneral  formapagoReturnGeneral =new FormaPagoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			formapagoReturnGeneral =new FormaPagoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			formapagoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			formapagoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Modulo> modulosForeignKey=new ArrayList<Modulo>();
			ModuloLogic moduloLogic=new ModuloLogic();
			moduloLogic.setConnexion(this.connexion);
			moduloLogic.getModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalModulo.equals("NONE")) {
				moduloLogic.getTodosModulos(finalQueryGlobalModulo,new Pagination());
				modulosForeignKey=moduloLogic.getModulos();
			}

			formapagoReturnGeneral.setmodulosForeignKey(modulosForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			formapagoReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			formapagoReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			formapagoReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			formapagoReturnGeneral.setmessForeignKey(messForeignKey);


			List<TipoFormaPago> tipoformapagosForeignKey=new ArrayList<TipoFormaPago>();
			TipoFormaPagoLogic tipoformapagoLogic=new TipoFormaPagoLogic();
			tipoformapagoLogic.setConnexion(this.connexion);
			tipoformapagoLogic.getTipoFormaPagoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoFormaPago.equals("NONE")) {
				tipoformapagoLogic.getTodosTipoFormaPagos(finalQueryGlobalTipoFormaPago,new Pagination());
				tipoformapagosForeignKey=tipoformapagoLogic.getTipoFormaPagos();
			}

			formapagoReturnGeneral.settipoformapagosForeignKey(tipoformapagosForeignKey);


			List<Transaccion> transaccionsForeignKey=new ArrayList<Transaccion>();
			TransaccionLogic transaccionLogic=new TransaccionLogic();
			transaccionLogic.setConnexion(this.connexion);
			transaccionLogic.getTransaccionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTransaccion.equals("NONE")) {
				transaccionLogic.getTodosTransaccions(finalQueryGlobalTransaccion,new Pagination());
				transaccionsForeignKey=transaccionLogic.getTransaccions();
			}

			formapagoReturnGeneral.settransaccionsForeignKey(transaccionsForeignKey);


			List<TipoTransaccionModulo> tipotransaccionmodulosForeignKey=new ArrayList<TipoTransaccionModulo>();
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic=new TipoTransaccionModuloLogic();
			tipotransaccionmoduloLogic.setConnexion(this.connexion);
			tipotransaccionmoduloLogic.getTipoTransaccionModuloDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoTransaccionModulo.equals("NONE")) {
				tipotransaccionmoduloLogic.getTodosTipoTransaccionModulos(finalQueryGlobalTipoTransaccionModulo,new Pagination());
				tipotransaccionmodulosForeignKey=tipotransaccionmoduloLogic.getTipoTransaccionModulos();
			}

			formapagoReturnGeneral.settipotransaccionmodulosForeignKey(tipotransaccionmodulosForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			formapagoReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<CuentaContable> cuentacontableretesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontablereteLogic=new CuentaContableLogic();
			cuentacontablereteLogic.setConnexion(this.connexion);
			cuentacontablereteLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContableRete.equals("NONE")) {
				cuentacontablereteLogic.getTodosCuentaContables(finalQueryGlobalCuentaContableRete,new Pagination());
				cuentacontableretesForeignKey=cuentacontablereteLogic.getCuentaContables();
			}

			formapagoReturnGeneral.setcuentacontableretesForeignKey(cuentacontableretesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return formapagoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyFormaPagoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			FormularioRentaExtraLogic formulariorentaextraLogic=new FormularioRentaExtraLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPago.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyFormaPagoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(FormularioRentaExtra.class));
											
			

			formulariorentaextraLogic.setConnexion(this.getConnexion());
			formulariorentaextraLogic.setDatosCliente(this.datosCliente);
			formulariorentaextraLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(FormaPago formapago:this.formapagos) {
				

				classes=new ArrayList<Classe>();
				classes=FormularioRentaExtraConstantesFunciones.getClassesForeignKeysOfFormularioRentaExtra(new ArrayList<Classe>(),DeepLoadType.NONE);

				formulariorentaextraLogic.setFormularioRentaExtras(formapago.formulariorentaextras);
				formulariorentaextraLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(FormaPago formapago,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			FormaPagoLogicAdditional.updateFormaPagoToGet(formapago,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		formapago.setEmpresa(formapagoDataAccess.getEmpresa(connexion,formapago));
		formapago.setSucursal(formapagoDataAccess.getSucursal(connexion,formapago));
		formapago.setModulo(formapagoDataAccess.getModulo(connexion,formapago));
		formapago.setEjercicio(formapagoDataAccess.getEjercicio(connexion,formapago));
		formapago.setPeriodo(formapagoDataAccess.getPeriodo(connexion,formapago));
		formapago.setAnio(formapagoDataAccess.getAnio(connexion,formapago));
		formapago.setMes(formapagoDataAccess.getMes(connexion,formapago));
		formapago.setTipoFormaPago(formapagoDataAccess.getTipoFormaPago(connexion,formapago));
		formapago.setTransaccion(formapagoDataAccess.getTransaccion(connexion,formapago));
		formapago.setTipoTransaccionModulo(formapagoDataAccess.getTipoTransaccionModulo(connexion,formapago));
		formapago.setCuentaContable(formapagoDataAccess.getCuentaContable(connexion,formapago));
		formapago.setCuentaContableRete(formapagoDataAccess.getCuentaContableRete(connexion,formapago));
		formapago.setFormularioRentaExtras(formapagoDataAccess.getFormularioRentaExtras(connexion,formapago));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				formapago.setEmpresa(formapagoDataAccess.getEmpresa(connexion,formapago));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				formapago.setSucursal(formapagoDataAccess.getSucursal(connexion,formapago));
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				formapago.setModulo(formapagoDataAccess.getModulo(connexion,formapago));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				formapago.setEjercicio(formapagoDataAccess.getEjercicio(connexion,formapago));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				formapago.setPeriodo(formapagoDataAccess.getPeriodo(connexion,formapago));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				formapago.setAnio(formapagoDataAccess.getAnio(connexion,formapago));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				formapago.setMes(formapagoDataAccess.getMes(connexion,formapago));
				continue;
			}

			if(clas.clas.equals(TipoFormaPago.class)) {
				formapago.setTipoFormaPago(formapagoDataAccess.getTipoFormaPago(connexion,formapago));
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				formapago.setTransaccion(formapagoDataAccess.getTransaccion(connexion,formapago));
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				formapago.setTipoTransaccionModulo(formapagoDataAccess.getTipoTransaccionModulo(connexion,formapago));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				formapago.setCuentaContable(formapagoDataAccess.getCuentaContable(connexion,formapago));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				formapago.setCuentaContableRete(formapagoDataAccess.getCuentaContableRete(connexion,formapago));
				continue;
			}

			if(clas.clas.equals(FormularioRentaExtra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				formapago.setFormularioRentaExtras(formapagoDataAccess.getFormularioRentaExtras(connexion,formapago));

				if(this.isConDeep) {
					FormularioRentaExtraLogic formulariorentaextraLogic= new FormularioRentaExtraLogic(this.connexion);
					formulariorentaextraLogic.setFormularioRentaExtras(formapago.getFormularioRentaExtras());
					ArrayList<Classe> classesLocal=FormularioRentaExtraConstantesFunciones.getClassesForeignKeysOfFormularioRentaExtra(new ArrayList<Classe>(),DeepLoadType.NONE);
					formulariorentaextraLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					FormularioRentaExtraConstantesFunciones.refrescarForeignKeysDescripcionesFormularioRentaExtra(formulariorentaextraLogic.getFormularioRentaExtras());
					formapago.setFormularioRentaExtras(formulariorentaextraLogic.getFormularioRentaExtras());
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
			formapago.setEmpresa(formapagoDataAccess.getEmpresa(connexion,formapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapago.setSucursal(formapagoDataAccess.getSucursal(connexion,formapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapago.setModulo(formapagoDataAccess.getModulo(connexion,formapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapago.setEjercicio(formapagoDataAccess.getEjercicio(connexion,formapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapago.setPeriodo(formapagoDataAccess.getPeriodo(connexion,formapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapago.setAnio(formapagoDataAccess.getAnio(connexion,formapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapago.setMes(formapagoDataAccess.getMes(connexion,formapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFormaPago.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapago.setTipoFormaPago(formapagoDataAccess.getTipoFormaPago(connexion,formapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapago.setTransaccion(formapagoDataAccess.getTransaccion(connexion,formapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapago.setTipoTransaccionModulo(formapagoDataAccess.getTipoTransaccionModulo(connexion,formapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapago.setCuentaContable(formapagoDataAccess.getCuentaContable(connexion,formapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapago.setCuentaContableRete(formapagoDataAccess.getCuentaContableRete(connexion,formapago));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormularioRentaExtra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormularioRentaExtra.class));
			formapago.setFormularioRentaExtras(formapagoDataAccess.getFormularioRentaExtras(connexion,formapago));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		formapago.setEmpresa(formapagoDataAccess.getEmpresa(connexion,formapago));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(formapago.getEmpresa(),isDeep,deepLoadType,clases);
				
		formapago.setSucursal(formapagoDataAccess.getSucursal(connexion,formapago));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(formapago.getSucursal(),isDeep,deepLoadType,clases);
				
		formapago.setModulo(formapagoDataAccess.getModulo(connexion,formapago));
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(formapago.getModulo(),isDeep,deepLoadType,clases);
				
		formapago.setEjercicio(formapagoDataAccess.getEjercicio(connexion,formapago));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(formapago.getEjercicio(),isDeep,deepLoadType,clases);
				
		formapago.setPeriodo(formapagoDataAccess.getPeriodo(connexion,formapago));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(formapago.getPeriodo(),isDeep,deepLoadType,clases);
				
		formapago.setAnio(formapagoDataAccess.getAnio(connexion,formapago));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(formapago.getAnio(),isDeep,deepLoadType,clases);
				
		formapago.setMes(formapagoDataAccess.getMes(connexion,formapago));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(formapago.getMes(),isDeep,deepLoadType,clases);
				
		formapago.setTipoFormaPago(formapagoDataAccess.getTipoFormaPago(connexion,formapago));
		TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
		tipoformapagoLogic.deepLoad(formapago.getTipoFormaPago(),isDeep,deepLoadType,clases);
				
		formapago.setTransaccion(formapagoDataAccess.getTransaccion(connexion,formapago));
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(formapago.getTransaccion(),isDeep,deepLoadType,clases);
				
		formapago.setTipoTransaccionModulo(formapagoDataAccess.getTipoTransaccionModulo(connexion,formapago));
		TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
		tipotransaccionmoduloLogic.deepLoad(formapago.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				
		formapago.setCuentaContable(formapagoDataAccess.getCuentaContable(connexion,formapago));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(formapago.getCuentaContable(),isDeep,deepLoadType,clases);
				
		formapago.setCuentaContableRete(formapagoDataAccess.getCuentaContableRete(connexion,formapago));
		CuentaContableLogic cuentacontablereteLogic= new CuentaContableLogic(connexion);
		cuentacontablereteLogic.deepLoad(formapago.getCuentaContableRete(),isDeep,deepLoadType,clases);
				

		formapago.setFormularioRentaExtras(formapagoDataAccess.getFormularioRentaExtras(connexion,formapago));

		for(FormularioRentaExtra formulariorentaextra:formapago.getFormularioRentaExtras()) {
			FormularioRentaExtraLogic formulariorentaextraLogic= new FormularioRentaExtraLogic(connexion);
			formulariorentaextraLogic.deepLoad(formulariorentaextra,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				formapago.setEmpresa(formapagoDataAccess.getEmpresa(connexion,formapago));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(formapago.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				formapago.setSucursal(formapagoDataAccess.getSucursal(connexion,formapago));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(formapago.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				formapago.setModulo(formapagoDataAccess.getModulo(connexion,formapago));
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepLoad(formapago.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				formapago.setEjercicio(formapagoDataAccess.getEjercicio(connexion,formapago));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(formapago.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				formapago.setPeriodo(formapagoDataAccess.getPeriodo(connexion,formapago));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(formapago.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				formapago.setAnio(formapagoDataAccess.getAnio(connexion,formapago));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(formapago.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				formapago.setMes(formapagoDataAccess.getMes(connexion,formapago));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(formapago.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoFormaPago.class)) {
				formapago.setTipoFormaPago(formapagoDataAccess.getTipoFormaPago(connexion,formapago));
				TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
				tipoformapagoLogic.deepLoad(formapago.getTipoFormaPago(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				formapago.setTransaccion(formapagoDataAccess.getTransaccion(connexion,formapago));
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepLoad(formapago.getTransaccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				formapago.setTipoTransaccionModulo(formapagoDataAccess.getTipoTransaccionModulo(connexion,formapago));
				TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
				tipotransaccionmoduloLogic.deepLoad(formapago.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				formapago.setCuentaContable(formapagoDataAccess.getCuentaContable(connexion,formapago));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(formapago.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				formapago.setCuentaContableRete(formapagoDataAccess.getCuentaContableRete(connexion,formapago));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(formapago.getCuentaContableRete(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(FormularioRentaExtra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				formapago.setFormularioRentaExtras(formapagoDataAccess.getFormularioRentaExtras(connexion,formapago));

				for(FormularioRentaExtra formulariorentaextra:formapago.getFormularioRentaExtras()) {
					FormularioRentaExtraLogic formulariorentaextraLogic= new FormularioRentaExtraLogic(connexion);
					formulariorentaextraLogic.deepLoad(formulariorentaextra,isDeep,deepLoadType,clases);
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
			formapago.setEmpresa(formapagoDataAccess.getEmpresa(connexion,formapago));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(formapago.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapago.setSucursal(formapagoDataAccess.getSucursal(connexion,formapago));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(formapago.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Modulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapago.setModulo(formapagoDataAccess.getModulo(connexion,formapago));
			ModuloLogic moduloLogic= new ModuloLogic(connexion);
			moduloLogic.deepLoad(formapago.getModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapago.setEjercicio(formapagoDataAccess.getEjercicio(connexion,formapago));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(formapago.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapago.setPeriodo(formapagoDataAccess.getPeriodo(connexion,formapago));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(formapago.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapago.setAnio(formapagoDataAccess.getAnio(connexion,formapago));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(formapago.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapago.setMes(formapagoDataAccess.getMes(connexion,formapago));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(formapago.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFormaPago.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapago.setTipoFormaPago(formapagoDataAccess.getTipoFormaPago(connexion,formapago));
			TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
			tipoformapagoLogic.deepLoad(formapago.getTipoFormaPago(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Transaccion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapago.setTransaccion(formapagoDataAccess.getTransaccion(connexion,formapago));
			TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
			transaccionLogic.deepLoad(formapago.getTransaccion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapago.setTipoTransaccionModulo(formapagoDataAccess.getTipoTransaccionModulo(connexion,formapago));
			TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
			tipotransaccionmoduloLogic.deepLoad(formapago.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapago.setCuentaContable(formapagoDataAccess.getCuentaContable(connexion,formapago));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(formapago.getCuentaContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapago.setCuentaContableRete(formapagoDataAccess.getCuentaContableRete(connexion,formapago));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(formapago.getCuentaContableRete(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FormularioRentaExtra.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(FormularioRentaExtra.class));
			formapago.setFormularioRentaExtras(formapagoDataAccess.getFormularioRentaExtras(connexion,formapago));

			for(FormularioRentaExtra formulariorentaextra:formapago.getFormularioRentaExtras()) {
				FormularioRentaExtraLogic formulariorentaextraLogic= new FormularioRentaExtraLogic(connexion);
				formulariorentaextraLogic.deepLoad(formulariorentaextra,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(FormaPago formapago,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			FormaPagoLogicAdditional.updateFormaPagoToSave(formapago,this.arrDatoGeneral);
			
FormaPagoDataAccess.save(formapago, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(formapago.getEmpresa(),connexion);

		SucursalDataAccess.save(formapago.getSucursal(),connexion);

		ModuloDataAccess.save(formapago.getModulo(),connexion);

		EjercicioDataAccess.save(formapago.getEjercicio(),connexion);

		PeriodoDataAccess.save(formapago.getPeriodo(),connexion);

		AnioDataAccess.save(formapago.getAnio(),connexion);

		MesDataAccess.save(formapago.getMes(),connexion);

		TipoFormaPagoDataAccess.save(formapago.getTipoFormaPago(),connexion);

		TransaccionDataAccess.save(formapago.getTransaccion(),connexion);

		TipoTransaccionModuloDataAccess.save(formapago.getTipoTransaccionModulo(),connexion);

		CuentaContableDataAccess.save(formapago.getCuentaContable(),connexion);

		CuentaContableDataAccess.save(formapago.getCuentaContableRete(),connexion);

		for(FormularioRentaExtra formulariorentaextra:formapago.getFormularioRentaExtras()) {
			formulariorentaextra.setid_forma_pago(formapago.getId());
			FormularioRentaExtraDataAccess.save(formulariorentaextra,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(formapago.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(formapago.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(formapago.getModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(formapago.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(formapago.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(formapago.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(formapago.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoFormaPago.class)) {
				TipoFormaPagoDataAccess.save(formapago.getTipoFormaPago(),connexion);
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(formapago.getTransaccion(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				TipoTransaccionModuloDataAccess.save(formapago.getTipoTransaccionModulo(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(formapago.getCuentaContable(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(formapago.getCuentaContableRete(),connexion);
				continue;
			}


			if(clas.clas.equals(FormularioRentaExtra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormularioRentaExtra formulariorentaextra:formapago.getFormularioRentaExtras()) {
					formulariorentaextra.setid_forma_pago(formapago.getId());
					FormularioRentaExtraDataAccess.save(formulariorentaextra,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(formapago.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(formapago.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(formapago.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(formapago.getSucursal(),isDeep,deepLoadType,clases);
				

		ModuloDataAccess.save(formapago.getModulo(),connexion);
		ModuloLogic moduloLogic= new ModuloLogic(connexion);
		moduloLogic.deepLoad(formapago.getModulo(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(formapago.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(formapago.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(formapago.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(formapago.getPeriodo(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(formapago.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(formapago.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(formapago.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(formapago.getMes(),isDeep,deepLoadType,clases);
				

		TipoFormaPagoDataAccess.save(formapago.getTipoFormaPago(),connexion);
		TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
		tipoformapagoLogic.deepLoad(formapago.getTipoFormaPago(),isDeep,deepLoadType,clases);
				

		TransaccionDataAccess.save(formapago.getTransaccion(),connexion);
		TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
		transaccionLogic.deepLoad(formapago.getTransaccion(),isDeep,deepLoadType,clases);
				

		TipoTransaccionModuloDataAccess.save(formapago.getTipoTransaccionModulo(),connexion);
		TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
		tipotransaccionmoduloLogic.deepLoad(formapago.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(formapago.getCuentaContable(),connexion);
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(formapago.getCuentaContable(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(formapago.getCuentaContableRete(),connexion);
		CuentaContableLogic cuentacontablereteLogic= new CuentaContableLogic(connexion);
		cuentacontablereteLogic.deepLoad(formapago.getCuentaContableRete(),isDeep,deepLoadType,clases);
				

		for(FormularioRentaExtra formulariorentaextra:formapago.getFormularioRentaExtras()) {
			FormularioRentaExtraLogic formulariorentaextraLogic= new FormularioRentaExtraLogic(connexion);
			formulariorentaextra.setid_forma_pago(formapago.getId());
			FormularioRentaExtraDataAccess.save(formulariorentaextra,connexion);
			formulariorentaextraLogic.deepSave(formulariorentaextra,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(formapago.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(formapago.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(formapago.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(formapago.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Modulo.class)) {
				ModuloDataAccess.save(formapago.getModulo(),connexion);
				ModuloLogic moduloLogic= new ModuloLogic(connexion);
				moduloLogic.deepSave(formapago.getModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(formapago.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(formapago.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(formapago.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(formapago.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(formapago.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(formapago.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(formapago.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(formapago.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoFormaPago.class)) {
				TipoFormaPagoDataAccess.save(formapago.getTipoFormaPago(),connexion);
				TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
				tipoformapagoLogic.deepSave(formapago.getTipoFormaPago(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Transaccion.class)) {
				TransaccionDataAccess.save(formapago.getTransaccion(),connexion);
				TransaccionLogic transaccionLogic= new TransaccionLogic(connexion);
				transaccionLogic.deepSave(formapago.getTransaccion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoTransaccionModulo.class)) {
				TipoTransaccionModuloDataAccess.save(formapago.getTipoTransaccionModulo(),connexion);
				TipoTransaccionModuloLogic tipotransaccionmoduloLogic= new TipoTransaccionModuloLogic(connexion);
				tipotransaccionmoduloLogic.deepSave(formapago.getTipoTransaccionModulo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(formapago.getCuentaContable(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(formapago.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(formapago.getCuentaContableRete(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(formapago.getCuentaContableRete(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(FormularioRentaExtra.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(FormularioRentaExtra formulariorentaextra:formapago.getFormularioRentaExtras()) {
					FormularioRentaExtraLogic formulariorentaextraLogic= new FormularioRentaExtraLogic(connexion);
					formulariorentaextra.setid_forma_pago(formapago.getId());
					FormularioRentaExtraDataAccess.save(formulariorentaextra,connexion);
					formulariorentaextraLogic.deepSave(formulariorentaextra,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(FormaPago.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(formapago,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(formapago);
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
			this.deepLoad(this.formapago,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapago);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(FormaPago.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(formapagos!=null) {
				for(FormaPago formapago:formapagos) {
					this.deepLoad(formapago,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(formapagos);
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
			if(formapagos!=null) {
				for(FormaPago formapago:formapagos) {
					this.deepLoad(formapago,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(formapagos);
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
			this.getNewConnexionToDeep(FormaPago.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(formapago,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(FormaPago.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(formapagos!=null) {
				for(FormaPago formapago:formapagos) {
					this.deepSave(formapago,isDeep,deepLoadType,clases);
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
			if(formapagos!=null) {
				for(FormaPago formapago:formapagos) {
					this.deepSave(formapago,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getFormaPagosBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",FormaPagoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagos=formapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagosBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",FormaPagoConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagos=formapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormaPagosBusquedaPorSiglasWithConnection(String sFinalQuery,Pagination pagination,String siglas)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralSiglas= new ParameterSelectionGeneral();
			parameterSelectionGeneralSiglas.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+siglas+"%",FormaPagoConstantesFunciones.SIGLAS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralSiglas);

			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorSiglas","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagos=formapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagosBusquedaPorSiglas(String sFinalQuery,Pagination pagination,String siglas)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralSiglas= new ParameterSelectionGeneral();
			parameterSelectionGeneralSiglas.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+siglas+"%",FormaPagoConstantesFunciones.SIGLAS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralSiglas);

			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorSiglas","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagos=formapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormaPagosFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,FormaPagoConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagos=formapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagosFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,FormaPagoConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagos=formapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormaPagosFK_IdCuentaContableWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,FormaPagoConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagos=formapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagosFK_IdCuentaContable(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,FormaPagoConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagos=formapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormaPagosFK_IdCuentaContableReteWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_rete)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableRete= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableRete.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_rete,FormaPagoConstantesFunciones.IDCUENTACONTABLERETE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableRete);

			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableRete","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagos=formapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagosFK_IdCuentaContableRete(String sFinalQuery,Pagination pagination,Long id_cuenta_contable_rete)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContableRete= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContableRete.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable_rete,FormaPagoConstantesFunciones.IDCUENTACONTABLERETE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContableRete);

			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContableRete","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagos=formapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormaPagosFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,FormaPagoConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagos=formapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagosFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,FormaPagoConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagos=formapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormaPagosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FormaPagoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagos=formapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FormaPagoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagos=formapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormaPagosFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,FormaPagoConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagos=formapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagosFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,FormaPagoConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagos=formapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormaPagosFK_IdModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,FormaPagoConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagos=formapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagosFK_IdModulo(String sFinalQuery,Pagination pagination,Long id_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_modulo,FormaPagoConstantesFunciones.IDMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidModulo);

			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagos=formapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormaPagosFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,FormaPagoConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagos=formapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagosFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,FormaPagoConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagos=formapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormaPagosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,FormaPagoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagos=formapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,FormaPagoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagos=formapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormaPagosFK_IdTipoFormaPagoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_forma_pago)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoFormaPago= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoFormaPago.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_forma_pago,FormaPagoConstantesFunciones.IDTIPOFORMAPAGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoFormaPago);

			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoFormaPago","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagos=formapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagosFK_IdTipoFormaPago(String sFinalQuery,Pagination pagination,Long id_tipo_forma_pago)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoFormaPago= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoFormaPago.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_forma_pago,FormaPagoConstantesFunciones.IDTIPOFORMAPAGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoFormaPago);

			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoFormaPago","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagos=formapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormaPagosFK_IdTipoTransaccionModuloWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_transaccion_modulo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransaccionModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransaccionModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transaccion_modulo,FormaPagoConstantesFunciones.IDTIPOTRANSACCIONMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransaccionModulo);

			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTransaccionModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagos=formapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagosFK_IdTipoTransaccionModulo(String sFinalQuery,Pagination pagination,Long id_tipo_transaccion_modulo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoTransaccionModulo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoTransaccionModulo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_transaccion_modulo,FormaPagoConstantesFunciones.IDTIPOTRANSACCIONMODULO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoTransaccionModulo);

			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoTransaccionModulo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagos=formapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormaPagosFK_IdTransaccionWithConnection(String sFinalQuery,Pagination pagination,Long id_transaccion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion,FormaPagoConstantesFunciones.IDTRANSACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion);

			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagos=formapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagosFK_IdTransaccion(String sFinalQuery,Pagination pagination,Long id_transaccion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTransaccion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTransaccion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_transaccion,FormaPagoConstantesFunciones.IDTRANSACCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTransaccion);

			FormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTransaccion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagos=formapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesFormaPago(this.formapagos);
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
			if(FormaPagoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,FormaPagoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,FormaPago formapago,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(FormaPagoConstantesFunciones.ISCONAUDITORIA) {
				if(formapago.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FormaPagoDataAccess.TABLENAME, formapago.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FormaPagoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FormaPagoLogic.registrarAuditoriaDetallesFormaPago(connexion,formapago,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(formapago.getIsDeleted()) {
					/*if(!formapago.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,FormaPagoDataAccess.TABLENAME, formapago.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////FormaPagoLogic.registrarAuditoriaDetallesFormaPago(connexion,formapago,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FormaPagoDataAccess.TABLENAME, formapago.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(formapago.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FormaPagoDataAccess.TABLENAME, formapago.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FormaPagoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FormaPagoLogic.registrarAuditoriaDetallesFormaPago(connexion,formapago,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesFormaPago(Connexion connexion,FormaPago formapago)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(formapago.getIsNew()||!formapago.getid_empresa().equals(formapago.getFormaPagoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapago.getFormaPagoOriginal().getid_empresa()!=null)
				{
					strValorActual=formapago.getFormaPagoOriginal().getid_empresa().toString();
				}
				if(formapago.getid_empresa()!=null)
				{
					strValorNuevo=formapago.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(formapago.getIsNew()||!formapago.getid_sucursal().equals(formapago.getFormaPagoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapago.getFormaPagoOriginal().getid_sucursal()!=null)
				{
					strValorActual=formapago.getFormaPagoOriginal().getid_sucursal().toString();
				}
				if(formapago.getid_sucursal()!=null)
				{
					strValorNuevo=formapago.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(formapago.getIsNew()||!formapago.getid_modulo().equals(formapago.getFormaPagoOriginal().getid_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapago.getFormaPagoOriginal().getid_modulo()!=null)
				{
					strValorActual=formapago.getFormaPagoOriginal().getid_modulo().toString();
				}
				if(formapago.getid_modulo()!=null)
				{
					strValorNuevo=formapago.getid_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoConstantesFunciones.IDMODULO,strValorActual,strValorNuevo);
			}	
			
			if(formapago.getIsNew()||!formapago.getid_ejercicio().equals(formapago.getFormaPagoOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapago.getFormaPagoOriginal().getid_ejercicio()!=null)
				{
					strValorActual=formapago.getFormaPagoOriginal().getid_ejercicio().toString();
				}
				if(formapago.getid_ejercicio()!=null)
				{
					strValorNuevo=formapago.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(formapago.getIsNew()||!formapago.getid_periodo().equals(formapago.getFormaPagoOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapago.getFormaPagoOriginal().getid_periodo()!=null)
				{
					strValorActual=formapago.getFormaPagoOriginal().getid_periodo().toString();
				}
				if(formapago.getid_periodo()!=null)
				{
					strValorNuevo=formapago.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(formapago.getIsNew()||!formapago.getid_anio().equals(formapago.getFormaPagoOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapago.getFormaPagoOriginal().getid_anio()!=null)
				{
					strValorActual=formapago.getFormaPagoOriginal().getid_anio().toString();
				}
				if(formapago.getid_anio()!=null)
				{
					strValorNuevo=formapago.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(formapago.getIsNew()||!formapago.getid_mes().equals(formapago.getFormaPagoOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapago.getFormaPagoOriginal().getid_mes()!=null)
				{
					strValorActual=formapago.getFormaPagoOriginal().getid_mes().toString();
				}
				if(formapago.getid_mes()!=null)
				{
					strValorNuevo=formapago.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(formapago.getIsNew()||!formapago.getid_tipo_forma_pago().equals(formapago.getFormaPagoOriginal().getid_tipo_forma_pago()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapago.getFormaPagoOriginal().getid_tipo_forma_pago()!=null)
				{
					strValorActual=formapago.getFormaPagoOriginal().getid_tipo_forma_pago().toString();
				}
				if(formapago.getid_tipo_forma_pago()!=null)
				{
					strValorNuevo=formapago.getid_tipo_forma_pago().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoConstantesFunciones.IDTIPOFORMAPAGO,strValorActual,strValorNuevo);
			}	
			
			if(formapago.getIsNew()||!formapago.getnombre().equals(formapago.getFormaPagoOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapago.getFormaPagoOriginal().getnombre()!=null)
				{
					strValorActual=formapago.getFormaPagoOriginal().getnombre();
				}
				if(formapago.getnombre()!=null)
				{
					strValorNuevo=formapago.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(formapago.getIsNew()||!formapago.getsiglas().equals(formapago.getFormaPagoOriginal().getsiglas()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapago.getFormaPagoOriginal().getsiglas()!=null)
				{
					strValorActual=formapago.getFormaPagoOriginal().getsiglas();
				}
				if(formapago.getsiglas()!=null)
				{
					strValorNuevo=formapago.getsiglas() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoConstantesFunciones.SIGLAS,strValorActual,strValorNuevo);
			}	
			
			if(formapago.getIsNew()||!formapago.getnumero_dias().equals(formapago.getFormaPagoOriginal().getnumero_dias()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapago.getFormaPagoOriginal().getnumero_dias()!=null)
				{
					strValorActual=formapago.getFormaPagoOriginal().getnumero_dias().toString();
				}
				if(formapago.getnumero_dias()!=null)
				{
					strValorNuevo=formapago.getnumero_dias().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoConstantesFunciones.NUMERODIAS,strValorActual,strValorNuevo);
			}	
			
			if(formapago.getIsNew()||!formapago.getporcentaje().equals(formapago.getFormaPagoOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapago.getFormaPagoOriginal().getporcentaje()!=null)
				{
					strValorActual=formapago.getFormaPagoOriginal().getporcentaje().toString();
				}
				if(formapago.getporcentaje()!=null)
				{
					strValorNuevo=formapago.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(formapago.getIsNew()||!formapago.getvalor().equals(formapago.getFormaPagoOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapago.getFormaPagoOriginal().getvalor()!=null)
				{
					strValorActual=formapago.getFormaPagoOriginal().getvalor().toString();
				}
				if(formapago.getvalor()!=null)
				{
					strValorNuevo=formapago.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
			
			if(formapago.getIsNew()||!formapago.getcon_detalle().equals(formapago.getFormaPagoOriginal().getcon_detalle()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapago.getFormaPagoOriginal().getcon_detalle()!=null)
				{
					strValorActual=formapago.getFormaPagoOriginal().getcon_detalle().toString();
				}
				if(formapago.getcon_detalle()!=null)
				{
					strValorNuevo=formapago.getcon_detalle().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoConstantesFunciones.CONDETALLE,strValorActual,strValorNuevo);
			}	
			
			if(formapago.getIsNew()||!formapago.getcon_remesa().equals(formapago.getFormaPagoOriginal().getcon_remesa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapago.getFormaPagoOriginal().getcon_remesa()!=null)
				{
					strValorActual=formapago.getFormaPagoOriginal().getcon_remesa().toString();
				}
				if(formapago.getcon_remesa()!=null)
				{
					strValorNuevo=formapago.getcon_remesa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoConstantesFunciones.CONREMESA,strValorActual,strValorNuevo);
			}	
			
			if(formapago.getIsNew()||!formapago.getcon_maneja_cuotas().equals(formapago.getFormaPagoOriginal().getcon_maneja_cuotas()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapago.getFormaPagoOriginal().getcon_maneja_cuotas()!=null)
				{
					strValorActual=formapago.getFormaPagoOriginal().getcon_maneja_cuotas().toString();
				}
				if(formapago.getcon_maneja_cuotas()!=null)
				{
					strValorNuevo=formapago.getcon_maneja_cuotas().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoConstantesFunciones.CONMANEJACUOTAS,strValorActual,strValorNuevo);
			}	
			
			if(formapago.getIsNew()||!formapago.getfecha().equals(formapago.getFormaPagoOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapago.getFormaPagoOriginal().getfecha()!=null)
				{
					strValorActual=formapago.getFormaPagoOriginal().getfecha().toString();
				}
				if(formapago.getfecha()!=null)
				{
					strValorNuevo=formapago.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(formapago.getIsNew()||!formapago.getfecha_fin().equals(formapago.getFormaPagoOriginal().getfecha_fin()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapago.getFormaPagoOriginal().getfecha_fin()!=null)
				{
					strValorActual=formapago.getFormaPagoOriginal().getfecha_fin().toString();
				}
				if(formapago.getfecha_fin()!=null)
				{
					strValorNuevo=formapago.getfecha_fin().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoConstantesFunciones.FECHAFIN,strValorActual,strValorNuevo);
			}	
			
			if(formapago.getIsNew()||!formapago.getid_transaccion().equals(formapago.getFormaPagoOriginal().getid_transaccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapago.getFormaPagoOriginal().getid_transaccion()!=null)
				{
					strValorActual=formapago.getFormaPagoOriginal().getid_transaccion().toString();
				}
				if(formapago.getid_transaccion()!=null)
				{
					strValorNuevo=formapago.getid_transaccion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoConstantesFunciones.IDTRANSACCION,strValorActual,strValorNuevo);
			}	
			
			if(formapago.getIsNew()||!formapago.getid_tipo_transaccion_modulo().equals(formapago.getFormaPagoOriginal().getid_tipo_transaccion_modulo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapago.getFormaPagoOriginal().getid_tipo_transaccion_modulo()!=null)
				{
					strValorActual=formapago.getFormaPagoOriginal().getid_tipo_transaccion_modulo().toString();
				}
				if(formapago.getid_tipo_transaccion_modulo()!=null)
				{
					strValorNuevo=formapago.getid_tipo_transaccion_modulo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoConstantesFunciones.IDTIPOTRANSACCIONMODULO,strValorActual,strValorNuevo);
			}	
			
			if(formapago.getIsNew()||!formapago.getid_cuenta_contable().equals(formapago.getFormaPagoOriginal().getid_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapago.getFormaPagoOriginal().getid_cuenta_contable()!=null)
				{
					strValorActual=formapago.getFormaPagoOriginal().getid_cuenta_contable().toString();
				}
				if(formapago.getid_cuenta_contable()!=null)
				{
					strValorNuevo=formapago.getid_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoConstantesFunciones.IDCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(formapago.getIsNew()||!formapago.getid_cuenta_contable_rete().equals(formapago.getFormaPagoOriginal().getid_cuenta_contable_rete()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapago.getFormaPagoOriginal().getid_cuenta_contable_rete()!=null)
				{
					strValorActual=formapago.getFormaPagoOriginal().getid_cuenta_contable_rete().toString();
				}
				if(formapago.getid_cuenta_contable_rete()!=null)
				{
					strValorNuevo=formapago.getid_cuenta_contable_rete().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoConstantesFunciones.IDCUENTACONTABLERETE,strValorActual,strValorNuevo);
			}	
			
			if(formapago.getIsNew()||!formapago.getporcentaje_rete().equals(formapago.getFormaPagoOriginal().getporcentaje_rete()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapago.getFormaPagoOriginal().getporcentaje_rete()!=null)
				{
					strValorActual=formapago.getFormaPagoOriginal().getporcentaje_rete().toString();
				}
				if(formapago.getporcentaje_rete()!=null)
				{
					strValorNuevo=formapago.getporcentaje_rete().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoConstantesFunciones.PORCENTAJERETE,strValorActual,strValorNuevo);
			}	
			
			if(formapago.getIsNew()||!formapago.getbase_retencion().equals(formapago.getFormaPagoOriginal().getbase_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapago.getFormaPagoOriginal().getbase_retencion()!=null)
				{
					strValorActual=formapago.getFormaPagoOriginal().getbase_retencion().toString();
				}
				if(formapago.getbase_retencion()!=null)
				{
					strValorNuevo=formapago.getbase_retencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoConstantesFunciones.BASERETENCION,strValorActual,strValorNuevo);
			}	
			
			if(formapago.getIsNew()||!formapago.getvalor_retencion().equals(formapago.getFormaPagoOriginal().getvalor_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapago.getFormaPagoOriginal().getvalor_retencion()!=null)
				{
					strValorActual=formapago.getFormaPagoOriginal().getvalor_retencion().toString();
				}
				if(formapago.getvalor_retencion()!=null)
				{
					strValorNuevo=formapago.getvalor_retencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoConstantesFunciones.VALORRETENCION,strValorActual,strValorNuevo);
			}	
			
			if(formapago.getIsNew()||!formapago.getnumero_retencion().equals(formapago.getFormaPagoOriginal().getnumero_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapago.getFormaPagoOriginal().getnumero_retencion()!=null)
				{
					strValorActual=formapago.getFormaPagoOriginal().getnumero_retencion();
				}
				if(formapago.getnumero_retencion()!=null)
				{
					strValorNuevo=formapago.getnumero_retencion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoConstantesFunciones.NUMERORETENCION,strValorActual,strValorNuevo);
			}	
			
			if(formapago.getIsNew()||!formapago.getnombre_retencion().equals(formapago.getFormaPagoOriginal().getnombre_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapago.getFormaPagoOriginal().getnombre_retencion()!=null)
				{
					strValorActual=formapago.getFormaPagoOriginal().getnombre_retencion();
				}
				if(formapago.getnombre_retencion()!=null)
				{
					strValorNuevo=formapago.getnombre_retencion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoConstantesFunciones.NOMBRERETENCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveFormaPagoRelacionesWithConnection(FormaPago formapago,List<FormularioRentaExtra> formulariorentaextras) throws Exception {

		if(!formapago.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFormaPagoRelacionesBase(formapago,formulariorentaextras,true);
		}
	}

	public void saveFormaPagoRelaciones(FormaPago formapago,List<FormularioRentaExtra> formulariorentaextras)throws Exception {

		if(!formapago.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFormaPagoRelacionesBase(formapago,formulariorentaextras,false);
		}
	}

	public void saveFormaPagoRelacionesBase(FormaPago formapago,List<FormularioRentaExtra> formulariorentaextras,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("FormaPago-saveRelacionesWithConnection");}
	
			formapago.setFormularioRentaExtras(formulariorentaextras);

			this.setFormaPago(formapago);

			if(FormaPagoLogicAdditional.validarSaveRelaciones(formapago,this)) {

				FormaPagoLogicAdditional.updateRelacionesToSave(formapago,this);

				if((formapago.getIsNew()||formapago.getIsChanged())&&!formapago.getIsDeleted()) {
					this.saveFormaPago();
					this.saveFormaPagoRelacionesDetalles(formulariorentaextras);

				} else if(formapago.getIsDeleted()) {
					this.saveFormaPagoRelacionesDetalles(formulariorentaextras);
					this.saveFormaPago();
				}

				FormaPagoLogicAdditional.updateRelacionesToSaveAfter(formapago,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			FormularioRentaExtraConstantesFunciones.InicializarGeneralEntityAuxiliaresFormularioRentaExtras(formulariorentaextras,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveFormaPagoRelacionesDetalles(List<FormularioRentaExtra> formulariorentaextras)throws Exception {
		try {
	

			Long idFormaPagoActual=this.getFormaPago().getId();

			FormularioRentaExtraLogic formulariorentaextraLogic_Desde_FormaPago=new FormularioRentaExtraLogic();
			formulariorentaextraLogic_Desde_FormaPago.setFormularioRentaExtras(formulariorentaextras);

			formulariorentaextraLogic_Desde_FormaPago.setConnexion(this.getConnexion());
			formulariorentaextraLogic_Desde_FormaPago.setDatosCliente(this.datosCliente);

			for(FormularioRentaExtra formulariorentaextra_Desde_FormaPago:formulariorentaextraLogic_Desde_FormaPago.getFormularioRentaExtras()) {
				formulariorentaextra_Desde_FormaPago.setid_forma_pago(idFormaPagoActual);
			}

			formulariorentaextraLogic_Desde_FormaPago.saveFormularioRentaExtras();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FormaPagoConstantesFunciones.getClassesForeignKeysOfFormaPago(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FormaPagoConstantesFunciones.getClassesRelationshipsOfFormaPago(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

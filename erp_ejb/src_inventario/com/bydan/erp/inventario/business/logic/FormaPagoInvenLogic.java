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
package com.bydan.erp.inventario.business.logic;

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
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.inventario.util.FormaPagoInvenConstantesFunciones;
import com.bydan.erp.inventario.util.FormaPagoInvenParameterReturnGeneral;
//import com.bydan.erp.inventario.util.FormaPagoInvenParameterGeneral;
import com.bydan.erp.inventario.business.entity.FormaPagoInven;
import com.bydan.erp.inventario.business.logic.FormaPagoInvenLogicAdditional;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.inventario.business.entity.*;

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
public class FormaPagoInvenLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(FormaPagoInvenLogic.class);
	
	protected FormaPagoInvenDataAccess formapagoinvenDataAccess; 	
	protected FormaPagoInven formapagoinven;
	protected List<FormaPagoInven> formapagoinvens;
	protected Object formapagoinvenObject;	
	protected List<Object> formapagoinvensObject;
	
	public static ClassValidator<FormaPagoInven> formapagoinvenValidator = new ClassValidator<FormaPagoInven>(FormaPagoInven.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected FormaPagoInvenLogicAdditional formapagoinvenLogicAdditional=null;
	
	public FormaPagoInvenLogicAdditional getFormaPagoInvenLogicAdditional() {
		return this.formapagoinvenLogicAdditional;
	}
	
	public void setFormaPagoInvenLogicAdditional(FormaPagoInvenLogicAdditional formapagoinvenLogicAdditional) {
		try {
			this.formapagoinvenLogicAdditional=formapagoinvenLogicAdditional;
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
	
	
	
	
	public  FormaPagoInvenLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.formapagoinvenDataAccess = new FormaPagoInvenDataAccess();
			
			this.formapagoinvens= new ArrayList<FormaPagoInven>();
			this.formapagoinven= new FormaPagoInven();
			
			this.formapagoinvenObject=new Object();
			this.formapagoinvensObject=new ArrayList<Object>();
				
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
			
			this.formapagoinvenDataAccess.setConnexionType(this.connexionType);
			this.formapagoinvenDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  FormaPagoInvenLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.formapagoinvenDataAccess = new FormaPagoInvenDataAccess();
			this.formapagoinvens= new ArrayList<FormaPagoInven>();
			this.formapagoinven= new FormaPagoInven();
			this.formapagoinvenObject=new Object();
			this.formapagoinvensObject=new ArrayList<Object>();
			
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
			
			this.formapagoinvenDataAccess.setConnexionType(this.connexionType);
			this.formapagoinvenDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public FormaPagoInven getFormaPagoInven() throws Exception {	
		FormaPagoInvenLogicAdditional.checkFormaPagoInvenToGet(formapagoinven,this.datosCliente,this.arrDatoGeneral);
		FormaPagoInvenLogicAdditional.updateFormaPagoInvenToGet(formapagoinven,this.arrDatoGeneral);
		
		return formapagoinven;
	}
		
	public void setFormaPagoInven(FormaPagoInven newFormaPagoInven) {
		this.formapagoinven = newFormaPagoInven;
	}
	
	public FormaPagoInvenDataAccess getFormaPagoInvenDataAccess() {
		return formapagoinvenDataAccess;
	}
	
	public void setFormaPagoInvenDataAccess(FormaPagoInvenDataAccess newformapagoinvenDataAccess) {
		this.formapagoinvenDataAccess = newformapagoinvenDataAccess;
	}
	
	public List<FormaPagoInven> getFormaPagoInvens() throws Exception {		
		this.quitarFormaPagoInvensNulos();
		
		FormaPagoInvenLogicAdditional.checkFormaPagoInvenToGets(formapagoinvens,this.datosCliente,this.arrDatoGeneral);
		
		for (FormaPagoInven formapagoinvenLocal: formapagoinvens ) {
			FormaPagoInvenLogicAdditional.updateFormaPagoInvenToGet(formapagoinvenLocal,this.arrDatoGeneral);
		}
		
		return formapagoinvens;
	}
	
	public void setFormaPagoInvens(List<FormaPagoInven> newFormaPagoInvens) {
		this.formapagoinvens = newFormaPagoInvens;
	}
	
	public Object getFormaPagoInvenObject() {	
		this.formapagoinvenObject=this.formapagoinvenDataAccess.getEntityObject();
		return this.formapagoinvenObject;
	}
		
	public void setFormaPagoInvenObject(Object newFormaPagoInvenObject) {
		this.formapagoinvenObject = newFormaPagoInvenObject;
	}
	
	public List<Object> getFormaPagoInvensObject() {		
		this.formapagoinvensObject=this.formapagoinvenDataAccess.getEntitiesObject();
		return this.formapagoinvensObject;
	}
		
	public void setFormaPagoInvensObject(List<Object> newFormaPagoInvensObject) {
		this.formapagoinvensObject = newFormaPagoInvensObject;
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
		
		if(this.formapagoinvenDataAccess!=null) {
			this.formapagoinvenDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoInven.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			formapagoinvenDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			formapagoinvenDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		formapagoinven = new  FormaPagoInven();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoInven.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			formapagoinven=formapagoinvenDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formapagoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoInven(this.formapagoinven);
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
		formapagoinven = new  FormaPagoInven();
		  		  
        try {
			
			formapagoinven=formapagoinvenDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formapagoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoInven(this.formapagoinven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		formapagoinven = new  FormaPagoInven();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoInven.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			formapagoinven=formapagoinvenDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formapagoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoInven(this.formapagoinven);
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
		formapagoinven = new  FormaPagoInven();
		  		  
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
		formapagoinven = new  FormaPagoInven();
		  		  
        try {
			
			formapagoinven=formapagoinvenDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formapagoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoInven(this.formapagoinven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		formapagoinven = new  FormaPagoInven();
		  		  
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
		formapagoinven = new  FormaPagoInven();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoInven.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =formapagoinvenDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		formapagoinven = new  FormaPagoInven();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=formapagoinvenDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		formapagoinven = new  FormaPagoInven();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoInven.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =formapagoinvenDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		formapagoinven = new  FormaPagoInven();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=formapagoinvenDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		formapagoinven = new  FormaPagoInven();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoInven.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =formapagoinvenDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		formapagoinven = new  FormaPagoInven();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=formapagoinvenDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		formapagoinvens = new  ArrayList<FormaPagoInven>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoInven.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			FormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formapagoinvens=formapagoinvenDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormaPagoInven(formapagoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoInven(this.formapagoinvens);
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
		formapagoinvens = new  ArrayList<FormaPagoInven>();
		  		  
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
		formapagoinvens = new  ArrayList<FormaPagoInven>();
		  		  
        try {			
			FormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formapagoinvens=formapagoinvenDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarFormaPagoInven(formapagoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoInven(this.formapagoinvens);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		formapagoinvens = new  ArrayList<FormaPagoInven>();
		  		  
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
		formapagoinvens = new  ArrayList<FormaPagoInven>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoInven.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			FormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formapagoinvens=formapagoinvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormaPagoInven(formapagoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoInven(this.formapagoinvens);
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
		formapagoinvens = new  ArrayList<FormaPagoInven>();
		  		  
        try {
			FormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formapagoinvens=formapagoinvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormaPagoInven(formapagoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoInven(this.formapagoinvens);
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
		formapagoinvens = new  ArrayList<FormaPagoInven>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoInven.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formapagoinvens=formapagoinvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormaPagoInven(formapagoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoInven(this.formapagoinvens);
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
		formapagoinvens = new  ArrayList<FormaPagoInven>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formapagoinvens=formapagoinvenDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormaPagoInven(formapagoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoInven(this.formapagoinvens);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		formapagoinven = new  FormaPagoInven();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoInven.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formapagoinven=formapagoinvenDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormaPagoInven(formapagoinven);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoInven(this.formapagoinven);
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
		formapagoinven = new  FormaPagoInven();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formapagoinven=formapagoinvenDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormaPagoInven(formapagoinven);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoInven(this.formapagoinven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		formapagoinvens = new  ArrayList<FormaPagoInven>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoInven.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			FormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formapagoinvens=formapagoinvenDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormaPagoInven(formapagoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoInven(this.formapagoinvens);
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
		formapagoinvens = new  ArrayList<FormaPagoInven>();
		  		  
        try {
			FormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formapagoinvens=formapagoinvenDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormaPagoInven(formapagoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoInven(this.formapagoinvens);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosFormaPagoInvensWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		formapagoinvens = new  ArrayList<FormaPagoInven>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoInven.class.getSimpleName()+"-getTodosFormaPagoInvensWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formapagoinvens=formapagoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFormaPagoInven(formapagoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoInven(this.formapagoinvens);
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
	
	public  void  getTodosFormaPagoInvens(String sFinalQuery,Pagination pagination)throws Exception {
		formapagoinvens = new  ArrayList<FormaPagoInven>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formapagoinvens=formapagoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFormaPagoInven(formapagoinvens);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoInven(this.formapagoinvens);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarFormaPagoInven(FormaPagoInven formapagoinven) throws Exception {
		Boolean estaValidado=false;
		
		if(formapagoinven.getIsNew() || formapagoinven.getIsChanged()) { 
			this.invalidValues = formapagoinvenValidator.getInvalidValues(formapagoinven);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(formapagoinven);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarFormaPagoInven(List<FormaPagoInven> FormaPagoInvens) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(FormaPagoInven formapagoinvenLocal:formapagoinvens) {				
			estaValidadoObjeto=this.validarGuardarFormaPagoInven(formapagoinvenLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarFormaPagoInven(List<FormaPagoInven> FormaPagoInvens) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFormaPagoInven(formapagoinvens)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarFormaPagoInven(FormaPagoInven FormaPagoInven) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFormaPagoInven(formapagoinven)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(FormaPagoInven formapagoinven) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+formapagoinven.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=FormaPagoInvenConstantesFunciones.getFormaPagoInvenLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"formapagoinven","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(FormaPagoInvenConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(FormaPagoInvenConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveFormaPagoInvenWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoInven.class.getSimpleName()+"-saveFormaPagoInvenWithConnection");connexion.begin();			
			
			FormaPagoInvenLogicAdditional.checkFormaPagoInvenToSave(this.formapagoinven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FormaPagoInvenLogicAdditional.updateFormaPagoInvenToSave(this.formapagoinven,this.arrDatoGeneral);
			
			FormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.formapagoinven,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowFormaPagoInven();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFormaPagoInven(this.formapagoinven)) {
				FormaPagoInvenDataAccess.save(this.formapagoinven, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.formapagoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FormaPagoInvenLogicAdditional.checkFormaPagoInvenToSaveAfter(this.formapagoinven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFormaPagoInven();
			
			connexion.commit();			
			
			if(this.formapagoinven.getIsDeleted()) {
				this.formapagoinven=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveFormaPagoInven()throws Exception {	
		try {	
			
			FormaPagoInvenLogicAdditional.checkFormaPagoInvenToSave(this.formapagoinven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FormaPagoInvenLogicAdditional.updateFormaPagoInvenToSave(this.formapagoinven,this.arrDatoGeneral);
			
			FormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.formapagoinven,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFormaPagoInven(this.formapagoinven)) {			
				FormaPagoInvenDataAccess.save(this.formapagoinven, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.formapagoinven,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FormaPagoInvenLogicAdditional.checkFormaPagoInvenToSaveAfter(this.formapagoinven,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.formapagoinven.getIsDeleted()) {
				this.formapagoinven=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveFormaPagoInvensWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoInven.class.getSimpleName()+"-saveFormaPagoInvensWithConnection");connexion.begin();			
			
			FormaPagoInvenLogicAdditional.checkFormaPagoInvenToSaves(formapagoinvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowFormaPagoInvens();
			
			Boolean validadoTodosFormaPagoInven=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(FormaPagoInven formapagoinvenLocal:formapagoinvens) {		
				if(formapagoinvenLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FormaPagoInvenLogicAdditional.updateFormaPagoInvenToSave(formapagoinvenLocal,this.arrDatoGeneral);
	        	
				FormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),formapagoinvenLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFormaPagoInven(formapagoinvenLocal)) {
					FormaPagoInvenDataAccess.save(formapagoinvenLocal, connexion);				
				} else {
					validadoTodosFormaPagoInven=false;
				}
			}
			
			if(!validadoTodosFormaPagoInven) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FormaPagoInvenLogicAdditional.checkFormaPagoInvenToSavesAfter(formapagoinvens,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFormaPagoInvens();
			
			connexion.commit();		
			
			this.quitarFormaPagoInvensEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveFormaPagoInvens()throws Exception {				
		 try {	
			FormaPagoInvenLogicAdditional.checkFormaPagoInvenToSaves(formapagoinvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosFormaPagoInven=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(FormaPagoInven formapagoinvenLocal:formapagoinvens) {				
				if(formapagoinvenLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FormaPagoInvenLogicAdditional.updateFormaPagoInvenToSave(formapagoinvenLocal,this.arrDatoGeneral);
	        	
				FormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),formapagoinvenLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFormaPagoInven(formapagoinvenLocal)) {				
					FormaPagoInvenDataAccess.save(formapagoinvenLocal, connexion);				
				} else {
					validadoTodosFormaPagoInven=false;
				}
			}
			
			if(!validadoTodosFormaPagoInven) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FormaPagoInvenLogicAdditional.checkFormaPagoInvenToSavesAfter(formapagoinvens,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarFormaPagoInvensEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FormaPagoInvenParameterReturnGeneral procesarAccionFormaPagoInvens(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FormaPagoInven> formapagoinvens,FormaPagoInvenParameterReturnGeneral formapagoinvenParameterGeneral)throws Exception {
		 try {	
			FormaPagoInvenParameterReturnGeneral formapagoinvenReturnGeneral=new FormaPagoInvenParameterReturnGeneral();
	
			FormaPagoInvenLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,formapagoinvens,formapagoinvenParameterGeneral,formapagoinvenReturnGeneral);
			
			return formapagoinvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FormaPagoInvenParameterReturnGeneral procesarAccionFormaPagoInvensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FormaPagoInven> formapagoinvens,FormaPagoInvenParameterReturnGeneral formapagoinvenParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoInven.class.getSimpleName()+"-procesarAccionFormaPagoInvensWithConnection");connexion.begin();			
			
			FormaPagoInvenParameterReturnGeneral formapagoinvenReturnGeneral=new FormaPagoInvenParameterReturnGeneral();
	
			FormaPagoInvenLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,formapagoinvens,formapagoinvenParameterGeneral,formapagoinvenReturnGeneral);
			
			this.connexion.commit();
			
			return formapagoinvenReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FormaPagoInvenParameterReturnGeneral procesarEventosFormaPagoInvens(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<FormaPagoInven> formapagoinvens,FormaPagoInven formapagoinven,FormaPagoInvenParameterReturnGeneral formapagoinvenParameterGeneral,Boolean isEsNuevoFormaPagoInven,ArrayList<Classe> clases)throws Exception {
		 try {	
			FormaPagoInvenParameterReturnGeneral formapagoinvenReturnGeneral=new FormaPagoInvenParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				formapagoinvenReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FormaPagoInvenLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,formapagoinvens,formapagoinven,formapagoinvenParameterGeneral,formapagoinvenReturnGeneral,isEsNuevoFormaPagoInven,clases);
			
			return formapagoinvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public FormaPagoInvenParameterReturnGeneral procesarEventosFormaPagoInvensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<FormaPagoInven> formapagoinvens,FormaPagoInven formapagoinven,FormaPagoInvenParameterReturnGeneral formapagoinvenParameterGeneral,Boolean isEsNuevoFormaPagoInven,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoInven.class.getSimpleName()+"-procesarEventosFormaPagoInvensWithConnection");connexion.begin();			
			
			FormaPagoInvenParameterReturnGeneral formapagoinvenReturnGeneral=new FormaPagoInvenParameterReturnGeneral();
	
			formapagoinvenReturnGeneral.setFormaPagoInven(formapagoinven);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				formapagoinvenReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FormaPagoInvenLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,formapagoinvens,formapagoinven,formapagoinvenParameterGeneral,formapagoinvenReturnGeneral,isEsNuevoFormaPagoInven,clases);
			
			this.connexion.commit();
			
			return formapagoinvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FormaPagoInvenParameterReturnGeneral procesarImportacionFormaPagoInvensWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,FormaPagoInvenParameterReturnGeneral formapagoinvenParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoInven.class.getSimpleName()+"-procesarImportacionFormaPagoInvensWithConnection");connexion.begin();			
			
			FormaPagoInvenParameterReturnGeneral formapagoinvenReturnGeneral=new FormaPagoInvenParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.formapagoinvens=new ArrayList<FormaPagoInven>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.formapagoinven=new FormaPagoInven();
				
				
				if(conColumnasBase) {this.formapagoinven.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.formapagoinven.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.formapagoinven.setfecha_inicio(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.formapagoinven.setnumero_dias(Integer.parseInt(arrColumnas[iColumn++]));
				this.formapagoinven.setfecha_fin(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.formapagoinven.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.formapagoinven.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				this.formapagoinven.setdetalle(arrColumnas[iColumn++]);
				
				this.formapagoinvens.add(this.formapagoinven);
			}
			
			this.saveFormaPagoInvens();
			
			this.connexion.commit();
			
			formapagoinvenReturnGeneral.setConRetornoEstaProcesado(true);
			formapagoinvenReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return formapagoinvenReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarFormaPagoInvensEliminados() throws Exception {				
		
		List<FormaPagoInven> formapagoinvensAux= new ArrayList<FormaPagoInven>();
		
		for(FormaPagoInven formapagoinven:formapagoinvens) {
			if(!formapagoinven.getIsDeleted()) {
				formapagoinvensAux.add(formapagoinven);
			}
		}
		
		formapagoinvens=formapagoinvensAux;
	}
	
	public void quitarFormaPagoInvensNulos() throws Exception {				
		
		List<FormaPagoInven> formapagoinvensAux= new ArrayList<FormaPagoInven>();
		
		for(FormaPagoInven formapagoinven : this.formapagoinvens) {
			if(formapagoinven==null) {
				formapagoinvensAux.add(formapagoinven);
			}
		}
		
		//this.formapagoinvens=formapagoinvensAux;
		
		this.formapagoinvens.removeAll(formapagoinvensAux);
	}
	
	public void getSetVersionRowFormaPagoInvenWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(formapagoinven.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((formapagoinven.getIsDeleted() || (formapagoinven.getIsChanged()&&!formapagoinven.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=formapagoinvenDataAccess.getSetVersionRowFormaPagoInven(connexion,formapagoinven.getId());
				
				if(!formapagoinven.getVersionRow().equals(timestamp)) {	
					formapagoinven.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				formapagoinven.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowFormaPagoInven()throws Exception {	
		
		if(formapagoinven.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((formapagoinven.getIsDeleted() || (formapagoinven.getIsChanged()&&!formapagoinven.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=formapagoinvenDataAccess.getSetVersionRowFormaPagoInven(connexion,formapagoinven.getId());
			
			try {							
				if(!formapagoinven.getVersionRow().equals(timestamp)) {	
					formapagoinven.setVersionRow(timestamp);
				}
				
				formapagoinven.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowFormaPagoInvensWithConnection()throws Exception {	
		if(formapagoinvens!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(FormaPagoInven formapagoinvenAux:formapagoinvens) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(formapagoinvenAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(formapagoinvenAux.getIsDeleted() || (formapagoinvenAux.getIsChanged()&&!formapagoinvenAux.getIsNew())) {
						
						timestamp=formapagoinvenDataAccess.getSetVersionRowFormaPagoInven(connexion,formapagoinvenAux.getId());
						
						if(!formapagoinven.getVersionRow().equals(timestamp)) {	
							formapagoinvenAux.setVersionRow(timestamp);
						}
								
						formapagoinvenAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowFormaPagoInvens()throws Exception {	
		if(formapagoinvens!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(FormaPagoInven formapagoinvenAux:formapagoinvens) {
					if(formapagoinvenAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(formapagoinvenAux.getIsDeleted() || (formapagoinvenAux.getIsChanged()&&!formapagoinvenAux.getIsNew())) {
						
						timestamp=formapagoinvenDataAccess.getSetVersionRowFormaPagoInven(connexion,formapagoinvenAux.getId());
						
						if(!formapagoinvenAux.getVersionRow().equals(timestamp)) {	
							formapagoinvenAux.setVersionRow(timestamp);
						}
						
													
						formapagoinvenAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public FormaPagoInvenParameterReturnGeneral cargarCombosLoteForeignKeyFormaPagoInvenWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalTipoFormaPago,String finalQueryGlobalCompra,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalCuentaContable) throws Exception {
		FormaPagoInvenParameterReturnGeneral  formapagoinvenReturnGeneral =new FormaPagoInvenParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoInven.class.getSimpleName()+"-cargarCombosLoteForeignKeyFormaPagoInvenWithConnection");connexion.begin();
			
			formapagoinvenReturnGeneral =new FormaPagoInvenParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			formapagoinvenReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			formapagoinvenReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			formapagoinvenReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			formapagoinvenReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<TipoFormaPago> tipoformapagosForeignKey=new ArrayList<TipoFormaPago>();
			TipoFormaPagoLogic tipoformapagoLogic=new TipoFormaPagoLogic();
			tipoformapagoLogic.setConnexion(this.connexion);
			tipoformapagoLogic.getTipoFormaPagoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoFormaPago.equals("NONE")) {
				tipoformapagoLogic.getTodosTipoFormaPagos(finalQueryGlobalTipoFormaPago,new Pagination());
				tipoformapagosForeignKey=tipoformapagoLogic.getTipoFormaPagos();
			}

			formapagoinvenReturnGeneral.settipoformapagosForeignKey(tipoformapagosForeignKey);


			List<Compra> comprasForeignKey=new ArrayList<Compra>();
			CompraLogic compraLogic=new CompraLogic();
			compraLogic.setConnexion(this.connexion);
			compraLogic.getCompraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCompra.equals("NONE")) {
				compraLogic.getTodosCompras(finalQueryGlobalCompra,new Pagination());
				comprasForeignKey=compraLogic.getCompras();
			}

			formapagoinvenReturnGeneral.setcomprasForeignKey(comprasForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			formapagoinvenReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			formapagoinvenReturnGeneral.setmessForeignKey(messForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			formapagoinvenReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return formapagoinvenReturnGeneral;
	}
	
	public FormaPagoInvenParameterReturnGeneral cargarCombosLoteForeignKeyFormaPagoInven(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalTipoFormaPago,String finalQueryGlobalCompra,String finalQueryGlobalAnio,String finalQueryGlobalMes,String finalQueryGlobalCuentaContable) throws Exception {
		FormaPagoInvenParameterReturnGeneral  formapagoinvenReturnGeneral =new FormaPagoInvenParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			formapagoinvenReturnGeneral =new FormaPagoInvenParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			formapagoinvenReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			formapagoinvenReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			formapagoinvenReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			formapagoinvenReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<TipoFormaPago> tipoformapagosForeignKey=new ArrayList<TipoFormaPago>();
			TipoFormaPagoLogic tipoformapagoLogic=new TipoFormaPagoLogic();
			tipoformapagoLogic.setConnexion(this.connexion);
			tipoformapagoLogic.getTipoFormaPagoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoFormaPago.equals("NONE")) {
				tipoformapagoLogic.getTodosTipoFormaPagos(finalQueryGlobalTipoFormaPago,new Pagination());
				tipoformapagosForeignKey=tipoformapagoLogic.getTipoFormaPagos();
			}

			formapagoinvenReturnGeneral.settipoformapagosForeignKey(tipoformapagosForeignKey);


			List<Compra> comprasForeignKey=new ArrayList<Compra>();
			CompraLogic compraLogic=new CompraLogic();
			compraLogic.setConnexion(this.connexion);
			compraLogic.getCompraDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCompra.equals("NONE")) {
				compraLogic.getTodosCompras(finalQueryGlobalCompra,new Pagination());
				comprasForeignKey=compraLogic.getCompras();
			}

			formapagoinvenReturnGeneral.setcomprasForeignKey(comprasForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			formapagoinvenReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			formapagoinvenReturnGeneral.setmessForeignKey(messForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			formapagoinvenReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return formapagoinvenReturnGeneral;
	}
	
	
	public void deepLoad(FormaPagoInven formapagoinven,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			FormaPagoInvenLogicAdditional.updateFormaPagoInvenToGet(formapagoinven,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		formapagoinven.setEmpresa(formapagoinvenDataAccess.getEmpresa(connexion,formapagoinven));
		formapagoinven.setSucursal(formapagoinvenDataAccess.getSucursal(connexion,formapagoinven));
		formapagoinven.setEjercicio(formapagoinvenDataAccess.getEjercicio(connexion,formapagoinven));
		formapagoinven.setPeriodo(formapagoinvenDataAccess.getPeriodo(connexion,formapagoinven));
		formapagoinven.setTipoFormaPago(formapagoinvenDataAccess.getTipoFormaPago(connexion,formapagoinven));
		formapagoinven.setCompra(formapagoinvenDataAccess.getCompra(connexion,formapagoinven));
		formapagoinven.setAnio(formapagoinvenDataAccess.getAnio(connexion,formapagoinven));
		formapagoinven.setMes(formapagoinvenDataAccess.getMes(connexion,formapagoinven));
		formapagoinven.setCuentaContable(formapagoinvenDataAccess.getCuentaContable(connexion,formapagoinven));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				formapagoinven.setEmpresa(formapagoinvenDataAccess.getEmpresa(connexion,formapagoinven));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				formapagoinven.setSucursal(formapagoinvenDataAccess.getSucursal(connexion,formapagoinven));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				formapagoinven.setEjercicio(formapagoinvenDataAccess.getEjercicio(connexion,formapagoinven));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				formapagoinven.setPeriodo(formapagoinvenDataAccess.getPeriodo(connexion,formapagoinven));
				continue;
			}

			if(clas.clas.equals(TipoFormaPago.class)) {
				formapagoinven.setTipoFormaPago(formapagoinvenDataAccess.getTipoFormaPago(connexion,formapagoinven));
				continue;
			}

			if(clas.clas.equals(Compra.class)) {
				formapagoinven.setCompra(formapagoinvenDataAccess.getCompra(connexion,formapagoinven));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				formapagoinven.setAnio(formapagoinvenDataAccess.getAnio(connexion,formapagoinven));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				formapagoinven.setMes(formapagoinvenDataAccess.getMes(connexion,formapagoinven));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				formapagoinven.setCuentaContable(formapagoinvenDataAccess.getCuentaContable(connexion,formapagoinven));
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
			formapagoinven.setEmpresa(formapagoinvenDataAccess.getEmpresa(connexion,formapagoinven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagoinven.setSucursal(formapagoinvenDataAccess.getSucursal(connexion,formapagoinven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagoinven.setEjercicio(formapagoinvenDataAccess.getEjercicio(connexion,formapagoinven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagoinven.setPeriodo(formapagoinvenDataAccess.getPeriodo(connexion,formapagoinven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFormaPago.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagoinven.setTipoFormaPago(formapagoinvenDataAccess.getTipoFormaPago(connexion,formapagoinven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Compra.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagoinven.setCompra(formapagoinvenDataAccess.getCompra(connexion,formapagoinven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagoinven.setAnio(formapagoinvenDataAccess.getAnio(connexion,formapagoinven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagoinven.setMes(formapagoinvenDataAccess.getMes(connexion,formapagoinven));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagoinven.setCuentaContable(formapagoinvenDataAccess.getCuentaContable(connexion,formapagoinven));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		formapagoinven.setEmpresa(formapagoinvenDataAccess.getEmpresa(connexion,formapagoinven));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(formapagoinven.getEmpresa(),isDeep,deepLoadType,clases);
				
		formapagoinven.setSucursal(formapagoinvenDataAccess.getSucursal(connexion,formapagoinven));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(formapagoinven.getSucursal(),isDeep,deepLoadType,clases);
				
		formapagoinven.setEjercicio(formapagoinvenDataAccess.getEjercicio(connexion,formapagoinven));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(formapagoinven.getEjercicio(),isDeep,deepLoadType,clases);
				
		formapagoinven.setPeriodo(formapagoinvenDataAccess.getPeriodo(connexion,formapagoinven));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(formapagoinven.getPeriodo(),isDeep,deepLoadType,clases);
				
		formapagoinven.setTipoFormaPago(formapagoinvenDataAccess.getTipoFormaPago(connexion,formapagoinven));
		TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
		tipoformapagoLogic.deepLoad(formapagoinven.getTipoFormaPago(),isDeep,deepLoadType,clases);
				
		formapagoinven.setCompra(formapagoinvenDataAccess.getCompra(connexion,formapagoinven));
		CompraLogic compraLogic= new CompraLogic(connexion);
		compraLogic.deepLoad(formapagoinven.getCompra(),isDeep,deepLoadType,clases);
				
		formapagoinven.setAnio(formapagoinvenDataAccess.getAnio(connexion,formapagoinven));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(formapagoinven.getAnio(),isDeep,deepLoadType,clases);
				
		formapagoinven.setMes(formapagoinvenDataAccess.getMes(connexion,formapagoinven));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(formapagoinven.getMes(),isDeep,deepLoadType,clases);
				
		formapagoinven.setCuentaContable(formapagoinvenDataAccess.getCuentaContable(connexion,formapagoinven));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(formapagoinven.getCuentaContable(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				formapagoinven.setEmpresa(formapagoinvenDataAccess.getEmpresa(connexion,formapagoinven));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(formapagoinven.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				formapagoinven.setSucursal(formapagoinvenDataAccess.getSucursal(connexion,formapagoinven));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(formapagoinven.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				formapagoinven.setEjercicio(formapagoinvenDataAccess.getEjercicio(connexion,formapagoinven));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(formapagoinven.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				formapagoinven.setPeriodo(formapagoinvenDataAccess.getPeriodo(connexion,formapagoinven));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(formapagoinven.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoFormaPago.class)) {
				formapagoinven.setTipoFormaPago(formapagoinvenDataAccess.getTipoFormaPago(connexion,formapagoinven));
				TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
				tipoformapagoLogic.deepLoad(formapagoinven.getTipoFormaPago(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Compra.class)) {
				formapagoinven.setCompra(formapagoinvenDataAccess.getCompra(connexion,formapagoinven));
				CompraLogic compraLogic= new CompraLogic(connexion);
				compraLogic.deepLoad(formapagoinven.getCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				formapagoinven.setAnio(formapagoinvenDataAccess.getAnio(connexion,formapagoinven));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(formapagoinven.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				formapagoinven.setMes(formapagoinvenDataAccess.getMes(connexion,formapagoinven));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(formapagoinven.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				formapagoinven.setCuentaContable(formapagoinvenDataAccess.getCuentaContable(connexion,formapagoinven));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(formapagoinven.getCuentaContable(),isDeep,deepLoadType,clases);				
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
			formapagoinven.setEmpresa(formapagoinvenDataAccess.getEmpresa(connexion,formapagoinven));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(formapagoinven.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagoinven.setSucursal(formapagoinvenDataAccess.getSucursal(connexion,formapagoinven));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(formapagoinven.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagoinven.setEjercicio(formapagoinvenDataAccess.getEjercicio(connexion,formapagoinven));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(formapagoinven.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagoinven.setPeriodo(formapagoinvenDataAccess.getPeriodo(connexion,formapagoinven));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(formapagoinven.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFormaPago.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagoinven.setTipoFormaPago(formapagoinvenDataAccess.getTipoFormaPago(connexion,formapagoinven));
			TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
			tipoformapagoLogic.deepLoad(formapagoinven.getTipoFormaPago(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Compra.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagoinven.setCompra(formapagoinvenDataAccess.getCompra(connexion,formapagoinven));
			CompraLogic compraLogic= new CompraLogic(connexion);
			compraLogic.deepLoad(formapagoinven.getCompra(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagoinven.setAnio(formapagoinvenDataAccess.getAnio(connexion,formapagoinven));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(formapagoinven.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagoinven.setMes(formapagoinvenDataAccess.getMes(connexion,formapagoinven));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(formapagoinven.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagoinven.setCuentaContable(formapagoinvenDataAccess.getCuentaContable(connexion,formapagoinven));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(formapagoinven.getCuentaContable(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(FormaPagoInven formapagoinven,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			FormaPagoInvenLogicAdditional.updateFormaPagoInvenToSave(formapagoinven,this.arrDatoGeneral);
			
FormaPagoInvenDataAccess.save(formapagoinven, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(formapagoinven.getEmpresa(),connexion);

		SucursalDataAccess.save(formapagoinven.getSucursal(),connexion);

		EjercicioDataAccess.save(formapagoinven.getEjercicio(),connexion);

		PeriodoDataAccess.save(formapagoinven.getPeriodo(),connexion);

		TipoFormaPagoDataAccess.save(formapagoinven.getTipoFormaPago(),connexion);

		CompraDataAccess.save(formapagoinven.getCompra(),connexion);

		AnioDataAccess.save(formapagoinven.getAnio(),connexion);

		MesDataAccess.save(formapagoinven.getMes(),connexion);

		CuentaContableDataAccess.save(formapagoinven.getCuentaContable(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(formapagoinven.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(formapagoinven.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(formapagoinven.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(formapagoinven.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoFormaPago.class)) {
				TipoFormaPagoDataAccess.save(formapagoinven.getTipoFormaPago(),connexion);
				continue;
			}

			if(clas.clas.equals(Compra.class)) {
				CompraDataAccess.save(formapagoinven.getCompra(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(formapagoinven.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(formapagoinven.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(formapagoinven.getCuentaContable(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(formapagoinven.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(formapagoinven.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(formapagoinven.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(formapagoinven.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(formapagoinven.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(formapagoinven.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(formapagoinven.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(formapagoinven.getPeriodo(),isDeep,deepLoadType,clases);
				

		TipoFormaPagoDataAccess.save(formapagoinven.getTipoFormaPago(),connexion);
		TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
		tipoformapagoLogic.deepLoad(formapagoinven.getTipoFormaPago(),isDeep,deepLoadType,clases);
				

		CompraDataAccess.save(formapagoinven.getCompra(),connexion);
		CompraLogic compraLogic= new CompraLogic(connexion);
		compraLogic.deepLoad(formapagoinven.getCompra(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(formapagoinven.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(formapagoinven.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(formapagoinven.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(formapagoinven.getMes(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(formapagoinven.getCuentaContable(),connexion);
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(formapagoinven.getCuentaContable(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(formapagoinven.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(formapagoinven.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(formapagoinven.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(formapagoinven.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(formapagoinven.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(formapagoinven.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(formapagoinven.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(formapagoinven.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoFormaPago.class)) {
				TipoFormaPagoDataAccess.save(formapagoinven.getTipoFormaPago(),connexion);
				TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
				tipoformapagoLogic.deepSave(formapagoinven.getTipoFormaPago(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Compra.class)) {
				CompraDataAccess.save(formapagoinven.getCompra(),connexion);
				CompraLogic compraLogic= new CompraLogic(connexion);
				compraLogic.deepSave(formapagoinven.getCompra(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(formapagoinven.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(formapagoinven.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(formapagoinven.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(formapagoinven.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(formapagoinven.getCuentaContable(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(formapagoinven.getCuentaContable(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(FormaPagoInven.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(formapagoinven,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoInven(formapagoinven);
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
			this.deepLoad(this.formapagoinven,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoInven(this.formapagoinven);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(FormaPagoInven.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(formapagoinvens!=null) {
				for(FormaPagoInven formapagoinven:formapagoinvens) {
					this.deepLoad(formapagoinven,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					FormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoInven(formapagoinvens);
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
			if(formapagoinvens!=null) {
				for(FormaPagoInven formapagoinven:formapagoinvens) {
					this.deepLoad(formapagoinven,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					FormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoInven(formapagoinvens);
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
			this.getNewConnexionToDeep(FormaPagoInven.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(formapagoinven,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(FormaPagoInven.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(formapagoinvens!=null) {
				for(FormaPagoInven formapagoinven:formapagoinvens) {
					this.deepSave(formapagoinven,isDeep,deepLoadType,clases);
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
			if(formapagoinvens!=null) {
				for(FormaPagoInven formapagoinven:formapagoinvens) {
					this.deepSave(formapagoinven,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getFormaPagoInvensFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,FormaPagoInvenConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			FormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagoinvens=formapagoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoInven(this.formapagoinvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagoInvensFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,FormaPagoInvenConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			FormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagoinvens=formapagoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoInven(this.formapagoinvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormaPagoInvensFK_IdCompraWithConnection(String sFinalQuery,Pagination pagination,Long id_compra)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_compra,FormaPagoInvenConstantesFunciones.IDCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCompra);

			FormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagoinvens=formapagoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoInven(this.formapagoinvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagoInvensFK_IdCompra(String sFinalQuery,Pagination pagination,Long id_compra)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCompra= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCompra.setParameterSelectionGeneralEqual(ParameterType.LONG,id_compra,FormaPagoInvenConstantesFunciones.IDCOMPRA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCompra);

			FormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCompra","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagoinvens=formapagoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoInven(this.formapagoinvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormaPagoInvensFK_IdCuentaContableWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,FormaPagoInvenConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			FormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagoinvens=formapagoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoInven(this.formapagoinvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagoInvensFK_IdCuentaContable(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,FormaPagoInvenConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			FormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagoinvens=formapagoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoInven(this.formapagoinvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormaPagoInvensFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,FormaPagoInvenConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			FormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagoinvens=formapagoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoInven(this.formapagoinvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagoInvensFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,FormaPagoInvenConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			FormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagoinvens=formapagoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoInven(this.formapagoinvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormaPagoInvensFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FormaPagoInvenConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagoinvens=formapagoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoInven(this.formapagoinvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagoInvensFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FormaPagoInvenConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagoinvens=formapagoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoInven(this.formapagoinvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormaPagoInvensFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,FormaPagoInvenConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			FormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagoinvens=formapagoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoInven(this.formapagoinvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagoInvensFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,FormaPagoInvenConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			FormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagoinvens=formapagoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoInven(this.formapagoinvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormaPagoInvensFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,FormaPagoInvenConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			FormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagoinvens=formapagoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoInven(this.formapagoinvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagoInvensFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,FormaPagoInvenConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			FormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagoinvens=formapagoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoInven(this.formapagoinvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormaPagoInvensFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,FormaPagoInvenConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			FormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagoinvens=formapagoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoInven(this.formapagoinvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagoInvensFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,FormaPagoInvenConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			FormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagoinvens=formapagoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoInven(this.formapagoinvens);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormaPagoInvensFK_IdTipoFormaPagoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_forma_pago)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoInven.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoFormaPago= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoFormaPago.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_forma_pago,FormaPagoInvenConstantesFunciones.IDTIPOFORMAPAGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoFormaPago);

			FormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoFormaPago","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagoinvens=formapagoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoInven(this.formapagoinvens);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagoInvensFK_IdTipoFormaPago(String sFinalQuery,Pagination pagination,Long id_tipo_forma_pago)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoFormaPago= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoFormaPago.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_forma_pago,FormaPagoInvenConstantesFunciones.IDTIPOFORMAPAGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoFormaPago);

			FormaPagoInvenLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoFormaPago","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagoinvens=formapagoinvenDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoInvenConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoInven(this.formapagoinvens);
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
			if(FormaPagoInvenConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,FormaPagoInvenDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,FormaPagoInven formapagoinven,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(FormaPagoInvenConstantesFunciones.ISCONAUDITORIA) {
				if(formapagoinven.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FormaPagoInvenDataAccess.TABLENAME, formapagoinven.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FormaPagoInvenConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FormaPagoInvenLogic.registrarAuditoriaDetallesFormaPagoInven(connexion,formapagoinven,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(formapagoinven.getIsDeleted()) {
					/*if(!formapagoinven.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,FormaPagoInvenDataAccess.TABLENAME, formapagoinven.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////FormaPagoInvenLogic.registrarAuditoriaDetallesFormaPagoInven(connexion,formapagoinven,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FormaPagoInvenDataAccess.TABLENAME, formapagoinven.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(formapagoinven.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FormaPagoInvenDataAccess.TABLENAME, formapagoinven.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FormaPagoInvenConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FormaPagoInvenLogic.registrarAuditoriaDetallesFormaPagoInven(connexion,formapagoinven,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesFormaPagoInven(Connexion connexion,FormaPagoInven formapagoinven)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(formapagoinven.getIsNew()||!formapagoinven.getid_empresa().equals(formapagoinven.getFormaPagoInvenOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagoinven.getFormaPagoInvenOriginal().getid_empresa()!=null)
				{
					strValorActual=formapagoinven.getFormaPagoInvenOriginal().getid_empresa().toString();
				}
				if(formapagoinven.getid_empresa()!=null)
				{
					strValorNuevo=formapagoinven.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoInvenConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(formapagoinven.getIsNew()||!formapagoinven.getid_sucursal().equals(formapagoinven.getFormaPagoInvenOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagoinven.getFormaPagoInvenOriginal().getid_sucursal()!=null)
				{
					strValorActual=formapagoinven.getFormaPagoInvenOriginal().getid_sucursal().toString();
				}
				if(formapagoinven.getid_sucursal()!=null)
				{
					strValorNuevo=formapagoinven.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoInvenConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(formapagoinven.getIsNew()||!formapagoinven.getid_ejercicio().equals(formapagoinven.getFormaPagoInvenOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagoinven.getFormaPagoInvenOriginal().getid_ejercicio()!=null)
				{
					strValorActual=formapagoinven.getFormaPagoInvenOriginal().getid_ejercicio().toString();
				}
				if(formapagoinven.getid_ejercicio()!=null)
				{
					strValorNuevo=formapagoinven.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoInvenConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(formapagoinven.getIsNew()||!formapagoinven.getid_periodo().equals(formapagoinven.getFormaPagoInvenOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagoinven.getFormaPagoInvenOriginal().getid_periodo()!=null)
				{
					strValorActual=formapagoinven.getFormaPagoInvenOriginal().getid_periodo().toString();
				}
				if(formapagoinven.getid_periodo()!=null)
				{
					strValorNuevo=formapagoinven.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoInvenConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(formapagoinven.getIsNew()||!formapagoinven.getid_tipo_forma_pago().equals(formapagoinven.getFormaPagoInvenOriginal().getid_tipo_forma_pago()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagoinven.getFormaPagoInvenOriginal().getid_tipo_forma_pago()!=null)
				{
					strValorActual=formapagoinven.getFormaPagoInvenOriginal().getid_tipo_forma_pago().toString();
				}
				if(formapagoinven.getid_tipo_forma_pago()!=null)
				{
					strValorNuevo=formapagoinven.getid_tipo_forma_pago().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoInvenConstantesFunciones.IDTIPOFORMAPAGO,strValorActual,strValorNuevo);
			}	
			
			if(formapagoinven.getIsNew()||!formapagoinven.getfecha_inicio().equals(formapagoinven.getFormaPagoInvenOriginal().getfecha_inicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagoinven.getFormaPagoInvenOriginal().getfecha_inicio()!=null)
				{
					strValorActual=formapagoinven.getFormaPagoInvenOriginal().getfecha_inicio().toString();
				}
				if(formapagoinven.getfecha_inicio()!=null)
				{
					strValorNuevo=formapagoinven.getfecha_inicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoInvenConstantesFunciones.FECHAINICIO,strValorActual,strValorNuevo);
			}	
			
			if(formapagoinven.getIsNew()||!formapagoinven.getnumero_dias().equals(formapagoinven.getFormaPagoInvenOriginal().getnumero_dias()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagoinven.getFormaPagoInvenOriginal().getnumero_dias()!=null)
				{
					strValorActual=formapagoinven.getFormaPagoInvenOriginal().getnumero_dias().toString();
				}
				if(formapagoinven.getnumero_dias()!=null)
				{
					strValorNuevo=formapagoinven.getnumero_dias().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoInvenConstantesFunciones.NUMERODIAS,strValorActual,strValorNuevo);
			}	
			
			if(formapagoinven.getIsNew()||!formapagoinven.getfecha_fin().equals(formapagoinven.getFormaPagoInvenOriginal().getfecha_fin()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagoinven.getFormaPagoInvenOriginal().getfecha_fin()!=null)
				{
					strValorActual=formapagoinven.getFormaPagoInvenOriginal().getfecha_fin().toString();
				}
				if(formapagoinven.getfecha_fin()!=null)
				{
					strValorNuevo=formapagoinven.getfecha_fin().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoInvenConstantesFunciones.FECHAFIN,strValorActual,strValorNuevo);
			}	
			
			if(formapagoinven.getIsNew()||!formapagoinven.getporcentaje().equals(formapagoinven.getFormaPagoInvenOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagoinven.getFormaPagoInvenOriginal().getporcentaje()!=null)
				{
					strValorActual=formapagoinven.getFormaPagoInvenOriginal().getporcentaje().toString();
				}
				if(formapagoinven.getporcentaje()!=null)
				{
					strValorNuevo=formapagoinven.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoInvenConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(formapagoinven.getIsNew()||!formapagoinven.getvalor().equals(formapagoinven.getFormaPagoInvenOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagoinven.getFormaPagoInvenOriginal().getvalor()!=null)
				{
					strValorActual=formapagoinven.getFormaPagoInvenOriginal().getvalor().toString();
				}
				if(formapagoinven.getvalor()!=null)
				{
					strValorNuevo=formapagoinven.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoInvenConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
			
			if(formapagoinven.getIsNew()||!formapagoinven.getdetalle().equals(formapagoinven.getFormaPagoInvenOriginal().getdetalle()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagoinven.getFormaPagoInvenOriginal().getdetalle()!=null)
				{
					strValorActual=formapagoinven.getFormaPagoInvenOriginal().getdetalle();
				}
				if(formapagoinven.getdetalle()!=null)
				{
					strValorNuevo=formapagoinven.getdetalle() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoInvenConstantesFunciones.DETALLE,strValorActual,strValorNuevo);
			}	
			
			if(formapagoinven.getIsNew()||!formapagoinven.getid_compra().equals(formapagoinven.getFormaPagoInvenOriginal().getid_compra()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagoinven.getFormaPagoInvenOriginal().getid_compra()!=null)
				{
					strValorActual=formapagoinven.getFormaPagoInvenOriginal().getid_compra().toString();
				}
				if(formapagoinven.getid_compra()!=null)
				{
					strValorNuevo=formapagoinven.getid_compra().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoInvenConstantesFunciones.IDCOMPRA,strValorActual,strValorNuevo);
			}	
			
			if(formapagoinven.getIsNew()||!formapagoinven.getid_anio().equals(formapagoinven.getFormaPagoInvenOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagoinven.getFormaPagoInvenOriginal().getid_anio()!=null)
				{
					strValorActual=formapagoinven.getFormaPagoInvenOriginal().getid_anio().toString();
				}
				if(formapagoinven.getid_anio()!=null)
				{
					strValorNuevo=formapagoinven.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoInvenConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(formapagoinven.getIsNew()||!formapagoinven.getid_mes().equals(formapagoinven.getFormaPagoInvenOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagoinven.getFormaPagoInvenOriginal().getid_mes()!=null)
				{
					strValorActual=formapagoinven.getFormaPagoInvenOriginal().getid_mes().toString();
				}
				if(formapagoinven.getid_mes()!=null)
				{
					strValorNuevo=formapagoinven.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoInvenConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(formapagoinven.getIsNew()||!formapagoinven.getid_cuenta_contable().equals(formapagoinven.getFormaPagoInvenOriginal().getid_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagoinven.getFormaPagoInvenOriginal().getid_cuenta_contable()!=null)
				{
					strValorActual=formapagoinven.getFormaPagoInvenOriginal().getid_cuenta_contable().toString();
				}
				if(formapagoinven.getid_cuenta_contable()!=null)
				{
					strValorNuevo=formapagoinven.getid_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoInvenConstantesFunciones.IDCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(formapagoinven.getIsNew()||!formapagoinven.getfecha().equals(formapagoinven.getFormaPagoInvenOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagoinven.getFormaPagoInvenOriginal().getfecha()!=null)
				{
					strValorActual=formapagoinven.getFormaPagoInvenOriginal().getfecha().toString();
				}
				if(formapagoinven.getfecha()!=null)
				{
					strValorNuevo=formapagoinven.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoInvenConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveFormaPagoInvenRelacionesWithConnection(FormaPagoInven formapagoinven) throws Exception {

		if(!formapagoinven.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFormaPagoInvenRelacionesBase(formapagoinven,true);
		}
	}

	public void saveFormaPagoInvenRelaciones(FormaPagoInven formapagoinven)throws Exception {

		if(!formapagoinven.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFormaPagoInvenRelacionesBase(formapagoinven,false);
		}
	}

	public void saveFormaPagoInvenRelacionesBase(FormaPagoInven formapagoinven,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("FormaPagoInven-saveRelacionesWithConnection");}
	

			this.setFormaPagoInven(formapagoinven);

			if(FormaPagoInvenLogicAdditional.validarSaveRelaciones(formapagoinven,this)) {

				FormaPagoInvenLogicAdditional.updateRelacionesToSave(formapagoinven,this);

				if((formapagoinven.getIsNew()||formapagoinven.getIsChanged())&&!formapagoinven.getIsDeleted()) {
					this.saveFormaPagoInven();
					this.saveFormaPagoInvenRelacionesDetalles();

				} else if(formapagoinven.getIsDeleted()) {
					this.saveFormaPagoInvenRelacionesDetalles();
					this.saveFormaPagoInven();
				}

				FormaPagoInvenLogicAdditional.updateRelacionesToSaveAfter(formapagoinven,this);

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
	
	
	private void saveFormaPagoInvenRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfFormaPagoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FormaPagoInvenConstantesFunciones.getClassesForeignKeysOfFormaPagoInven(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFormaPagoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FormaPagoInvenConstantesFunciones.getClassesRelationshipsOfFormaPagoInven(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

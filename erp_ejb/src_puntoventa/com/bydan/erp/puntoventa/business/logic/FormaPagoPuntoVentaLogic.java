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
import com.bydan.erp.puntoventa.util.FormaPagoPuntoVentaConstantesFunciones;
import com.bydan.erp.puntoventa.util.FormaPagoPuntoVentaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.FormaPagoPuntoVentaParameterGeneral;
import com.bydan.erp.puntoventa.business.entity.FormaPagoPuntoVenta;
import com.bydan.erp.puntoventa.business.logic.FormaPagoPuntoVentaLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;








@SuppressWarnings("unused")
public class FormaPagoPuntoVentaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(FormaPagoPuntoVentaLogic.class);
	
	protected FormaPagoPuntoVentaDataAccess formapagopuntoventaDataAccess; 	
	protected FormaPagoPuntoVenta formapagopuntoventa;
	protected List<FormaPagoPuntoVenta> formapagopuntoventas;
	protected Object formapagopuntoventaObject;	
	protected List<Object> formapagopuntoventasObject;
	
	public static ClassValidator<FormaPagoPuntoVenta> formapagopuntoventaValidator = new ClassValidator<FormaPagoPuntoVenta>(FormaPagoPuntoVenta.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected FormaPagoPuntoVentaLogicAdditional formapagopuntoventaLogicAdditional=null;
	
	public FormaPagoPuntoVentaLogicAdditional getFormaPagoPuntoVentaLogicAdditional() {
		return this.formapagopuntoventaLogicAdditional;
	}
	
	public void setFormaPagoPuntoVentaLogicAdditional(FormaPagoPuntoVentaLogicAdditional formapagopuntoventaLogicAdditional) {
		try {
			this.formapagopuntoventaLogicAdditional=formapagopuntoventaLogicAdditional;
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
	
	
	
	
	public  FormaPagoPuntoVentaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.formapagopuntoventaDataAccess = new FormaPagoPuntoVentaDataAccess();
			
			this.formapagopuntoventas= new ArrayList<FormaPagoPuntoVenta>();
			this.formapagopuntoventa= new FormaPagoPuntoVenta();
			
			this.formapagopuntoventaObject=new Object();
			this.formapagopuntoventasObject=new ArrayList<Object>();
				
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
			
			this.formapagopuntoventaDataAccess.setConnexionType(this.connexionType);
			this.formapagopuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  FormaPagoPuntoVentaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.formapagopuntoventaDataAccess = new FormaPagoPuntoVentaDataAccess();
			this.formapagopuntoventas= new ArrayList<FormaPagoPuntoVenta>();
			this.formapagopuntoventa= new FormaPagoPuntoVenta();
			this.formapagopuntoventaObject=new Object();
			this.formapagopuntoventasObject=new ArrayList<Object>();
			
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
			
			this.formapagopuntoventaDataAccess.setConnexionType(this.connexionType);
			this.formapagopuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public FormaPagoPuntoVenta getFormaPagoPuntoVenta() throws Exception {	
		FormaPagoPuntoVentaLogicAdditional.checkFormaPagoPuntoVentaToGet(formapagopuntoventa,this.datosCliente,this.arrDatoGeneral);
		FormaPagoPuntoVentaLogicAdditional.updateFormaPagoPuntoVentaToGet(formapagopuntoventa,this.arrDatoGeneral);
		
		return formapagopuntoventa;
	}
		
	public void setFormaPagoPuntoVenta(FormaPagoPuntoVenta newFormaPagoPuntoVenta) {
		this.formapagopuntoventa = newFormaPagoPuntoVenta;
	}
	
	public FormaPagoPuntoVentaDataAccess getFormaPagoPuntoVentaDataAccess() {
		return formapagopuntoventaDataAccess;
	}
	
	public void setFormaPagoPuntoVentaDataAccess(FormaPagoPuntoVentaDataAccess newformapagopuntoventaDataAccess) {
		this.formapagopuntoventaDataAccess = newformapagopuntoventaDataAccess;
	}
	
	public List<FormaPagoPuntoVenta> getFormaPagoPuntoVentas() throws Exception {		
		this.quitarFormaPagoPuntoVentasNulos();
		
		FormaPagoPuntoVentaLogicAdditional.checkFormaPagoPuntoVentaToGets(formapagopuntoventas,this.datosCliente,this.arrDatoGeneral);
		
		for (FormaPagoPuntoVenta formapagopuntoventaLocal: formapagopuntoventas ) {
			FormaPagoPuntoVentaLogicAdditional.updateFormaPagoPuntoVentaToGet(formapagopuntoventaLocal,this.arrDatoGeneral);
		}
		
		return formapagopuntoventas;
	}
	
	public void setFormaPagoPuntoVentas(List<FormaPagoPuntoVenta> newFormaPagoPuntoVentas) {
		this.formapagopuntoventas = newFormaPagoPuntoVentas;
	}
	
	public Object getFormaPagoPuntoVentaObject() {	
		this.formapagopuntoventaObject=this.formapagopuntoventaDataAccess.getEntityObject();
		return this.formapagopuntoventaObject;
	}
		
	public void setFormaPagoPuntoVentaObject(Object newFormaPagoPuntoVentaObject) {
		this.formapagopuntoventaObject = newFormaPagoPuntoVentaObject;
	}
	
	public List<Object> getFormaPagoPuntoVentasObject() {		
		this.formapagopuntoventasObject=this.formapagopuntoventaDataAccess.getEntitiesObject();
		return this.formapagopuntoventasObject;
	}
		
	public void setFormaPagoPuntoVentasObject(List<Object> newFormaPagoPuntoVentasObject) {
		this.formapagopuntoventasObject = newFormaPagoPuntoVentasObject;
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
		
		if(this.formapagopuntoventaDataAccess!=null) {
			this.formapagopuntoventaDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoPuntoVenta.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			formapagopuntoventaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			formapagopuntoventaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		formapagopuntoventa = new  FormaPagoPuntoVenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoPuntoVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			formapagopuntoventa=formapagopuntoventaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formapagopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventa);
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
		formapagopuntoventa = new  FormaPagoPuntoVenta();
		  		  
        try {
			
			formapagopuntoventa=formapagopuntoventaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formapagopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		formapagopuntoventa = new  FormaPagoPuntoVenta();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoPuntoVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			formapagopuntoventa=formapagopuntoventaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formapagopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventa);
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
		formapagopuntoventa = new  FormaPagoPuntoVenta();
		  		  
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
		formapagopuntoventa = new  FormaPagoPuntoVenta();
		  		  
        try {
			
			formapagopuntoventa=formapagopuntoventaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.formapagopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		formapagopuntoventa = new  FormaPagoPuntoVenta();
		  		  
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
		formapagopuntoventa = new  FormaPagoPuntoVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoPuntoVenta.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =formapagopuntoventaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		formapagopuntoventa = new  FormaPagoPuntoVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=formapagopuntoventaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		formapagopuntoventa = new  FormaPagoPuntoVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoPuntoVenta.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =formapagopuntoventaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		formapagopuntoventa = new  FormaPagoPuntoVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=formapagopuntoventaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		formapagopuntoventa = new  FormaPagoPuntoVenta();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoPuntoVenta.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =formapagopuntoventaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		formapagopuntoventa = new  FormaPagoPuntoVenta();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=formapagopuntoventaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		formapagopuntoventas = new  ArrayList<FormaPagoPuntoVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoPuntoVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormaPagoPuntoVenta(formapagopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
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
		formapagopuntoventas = new  ArrayList<FormaPagoPuntoVenta>();
		  		  
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
		formapagopuntoventas = new  ArrayList<FormaPagoPuntoVenta>();
		  		  
        try {			
			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarFormaPagoPuntoVenta(formapagopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		formapagopuntoventas = new  ArrayList<FormaPagoPuntoVenta>();
		  		  
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
		formapagopuntoventas = new  ArrayList<FormaPagoPuntoVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoPuntoVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormaPagoPuntoVenta(formapagopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
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
		formapagopuntoventas = new  ArrayList<FormaPagoPuntoVenta>();
		  		  
        try {
			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormaPagoPuntoVenta(formapagopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
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
		formapagopuntoventas = new  ArrayList<FormaPagoPuntoVenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoPuntoVenta.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormaPagoPuntoVenta(formapagopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
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
		formapagopuntoventas = new  ArrayList<FormaPagoPuntoVenta>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormaPagoPuntoVenta(formapagopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		formapagopuntoventa = new  FormaPagoPuntoVenta();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoPuntoVenta.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formapagopuntoventa=formapagopuntoventaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormaPagoPuntoVenta(formapagopuntoventa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventa);
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
		formapagopuntoventa = new  FormaPagoPuntoVenta();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formapagopuntoventa=formapagopuntoventaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarFormaPagoPuntoVenta(formapagopuntoventa);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		formapagopuntoventas = new  ArrayList<FormaPagoPuntoVenta>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoPuntoVenta.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formapagopuntoventas=formapagopuntoventaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormaPagoPuntoVenta(formapagopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
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
		formapagopuntoventas = new  ArrayList<FormaPagoPuntoVenta>();
		  		  
        try {
			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formapagopuntoventas=formapagopuntoventaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarFormaPagoPuntoVenta(formapagopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosFormaPagoPuntoVentasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		formapagopuntoventas = new  ArrayList<FormaPagoPuntoVenta>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoPuntoVenta.class.getSimpleName()+"-getTodosFormaPagoPuntoVentasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFormaPagoPuntoVenta(formapagopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
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
	
	public  void  getTodosFormaPagoPuntoVentas(String sFinalQuery,Pagination pagination)throws Exception {
		formapagopuntoventas = new  ArrayList<FormaPagoPuntoVenta>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarFormaPagoPuntoVenta(formapagopuntoventas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarFormaPagoPuntoVenta(FormaPagoPuntoVenta formapagopuntoventa) throws Exception {
		Boolean estaValidado=false;
		
		if(formapagopuntoventa.getIsNew() || formapagopuntoventa.getIsChanged()) { 
			this.invalidValues = formapagopuntoventaValidator.getInvalidValues(formapagopuntoventa);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(formapagopuntoventa);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarFormaPagoPuntoVenta(List<FormaPagoPuntoVenta> FormaPagoPuntoVentas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(FormaPagoPuntoVenta formapagopuntoventaLocal:formapagopuntoventas) {				
			estaValidadoObjeto=this.validarGuardarFormaPagoPuntoVenta(formapagopuntoventaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarFormaPagoPuntoVenta(List<FormaPagoPuntoVenta> FormaPagoPuntoVentas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFormaPagoPuntoVenta(formapagopuntoventas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarFormaPagoPuntoVenta(FormaPagoPuntoVenta FormaPagoPuntoVenta) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarFormaPagoPuntoVenta(formapagopuntoventa)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(FormaPagoPuntoVenta formapagopuntoventa) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+formapagopuntoventa.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=FormaPagoPuntoVentaConstantesFunciones.getFormaPagoPuntoVentaLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"formapagopuntoventa","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(FormaPagoPuntoVentaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(FormaPagoPuntoVentaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveFormaPagoPuntoVentaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoPuntoVenta.class.getSimpleName()+"-saveFormaPagoPuntoVentaWithConnection");connexion.begin();			
			
			FormaPagoPuntoVentaLogicAdditional.checkFormaPagoPuntoVentaToSave(this.formapagopuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FormaPagoPuntoVentaLogicAdditional.updateFormaPagoPuntoVentaToSave(this.formapagopuntoventa,this.arrDatoGeneral);
			
			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.formapagopuntoventa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowFormaPagoPuntoVenta();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFormaPagoPuntoVenta(this.formapagopuntoventa)) {
				FormaPagoPuntoVentaDataAccess.save(this.formapagopuntoventa, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.formapagopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FormaPagoPuntoVentaLogicAdditional.checkFormaPagoPuntoVentaToSaveAfter(this.formapagopuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFormaPagoPuntoVenta();
			
			connexion.commit();			
			
			if(this.formapagopuntoventa.getIsDeleted()) {
				this.formapagopuntoventa=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveFormaPagoPuntoVenta()throws Exception {	
		try {	
			
			FormaPagoPuntoVentaLogicAdditional.checkFormaPagoPuntoVentaToSave(this.formapagopuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			FormaPagoPuntoVentaLogicAdditional.updateFormaPagoPuntoVentaToSave(this.formapagopuntoventa,this.arrDatoGeneral);
			
			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.formapagopuntoventa,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarFormaPagoPuntoVenta(this.formapagopuntoventa)) {			
				FormaPagoPuntoVentaDataAccess.save(this.formapagopuntoventa, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.formapagopuntoventa,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			FormaPagoPuntoVentaLogicAdditional.checkFormaPagoPuntoVentaToSaveAfter(this.formapagopuntoventa,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.formapagopuntoventa.getIsDeleted()) {
				this.formapagopuntoventa=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveFormaPagoPuntoVentasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoPuntoVenta.class.getSimpleName()+"-saveFormaPagoPuntoVentasWithConnection");connexion.begin();			
			
			FormaPagoPuntoVentaLogicAdditional.checkFormaPagoPuntoVentaToSaves(formapagopuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowFormaPagoPuntoVentas();
			
			Boolean validadoTodosFormaPagoPuntoVenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(FormaPagoPuntoVenta formapagopuntoventaLocal:formapagopuntoventas) {		
				if(formapagopuntoventaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FormaPagoPuntoVentaLogicAdditional.updateFormaPagoPuntoVentaToSave(formapagopuntoventaLocal,this.arrDatoGeneral);
	        	
				FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),formapagopuntoventaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFormaPagoPuntoVenta(formapagopuntoventaLocal)) {
					FormaPagoPuntoVentaDataAccess.save(formapagopuntoventaLocal, connexion);				
				} else {
					validadoTodosFormaPagoPuntoVenta=false;
				}
			}
			
			if(!validadoTodosFormaPagoPuntoVenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FormaPagoPuntoVentaLogicAdditional.checkFormaPagoPuntoVentaToSavesAfter(formapagopuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowFormaPagoPuntoVentas();
			
			connexion.commit();		
			
			this.quitarFormaPagoPuntoVentasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveFormaPagoPuntoVentas()throws Exception {				
		 try {	
			FormaPagoPuntoVentaLogicAdditional.checkFormaPagoPuntoVentaToSaves(formapagopuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosFormaPagoPuntoVenta=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(FormaPagoPuntoVenta formapagopuntoventaLocal:formapagopuntoventas) {				
				if(formapagopuntoventaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				FormaPagoPuntoVentaLogicAdditional.updateFormaPagoPuntoVentaToSave(formapagopuntoventaLocal,this.arrDatoGeneral);
	        	
				FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),formapagopuntoventaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarFormaPagoPuntoVenta(formapagopuntoventaLocal)) {				
					FormaPagoPuntoVentaDataAccess.save(formapagopuntoventaLocal, connexion);				
				} else {
					validadoTodosFormaPagoPuntoVenta=false;
				}
			}
			
			if(!validadoTodosFormaPagoPuntoVenta) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			FormaPagoPuntoVentaLogicAdditional.checkFormaPagoPuntoVentaToSavesAfter(formapagopuntoventas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarFormaPagoPuntoVentasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FormaPagoPuntoVentaParameterReturnGeneral procesarAccionFormaPagoPuntoVentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FormaPagoPuntoVenta> formapagopuntoventas,FormaPagoPuntoVentaParameterReturnGeneral formapagopuntoventaParameterGeneral)throws Exception {
		 try {	
			FormaPagoPuntoVentaParameterReturnGeneral formapagopuntoventaReturnGeneral=new FormaPagoPuntoVentaParameterReturnGeneral();
	
			FormaPagoPuntoVentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,formapagopuntoventas,formapagopuntoventaParameterGeneral,formapagopuntoventaReturnGeneral);
			
			return formapagopuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public FormaPagoPuntoVentaParameterReturnGeneral procesarAccionFormaPagoPuntoVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<FormaPagoPuntoVenta> formapagopuntoventas,FormaPagoPuntoVentaParameterReturnGeneral formapagopuntoventaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoPuntoVenta.class.getSimpleName()+"-procesarAccionFormaPagoPuntoVentasWithConnection");connexion.begin();			
			
			FormaPagoPuntoVentaParameterReturnGeneral formapagopuntoventaReturnGeneral=new FormaPagoPuntoVentaParameterReturnGeneral();
	
			FormaPagoPuntoVentaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,formapagopuntoventas,formapagopuntoventaParameterGeneral,formapagopuntoventaReturnGeneral);
			
			this.connexion.commit();
			
			return formapagopuntoventaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FormaPagoPuntoVentaParameterReturnGeneral procesarEventosFormaPagoPuntoVentas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<FormaPagoPuntoVenta> formapagopuntoventas,FormaPagoPuntoVenta formapagopuntoventa,FormaPagoPuntoVentaParameterReturnGeneral formapagopuntoventaParameterGeneral,Boolean isEsNuevoFormaPagoPuntoVenta,ArrayList<Classe> clases)throws Exception {
		 try {	
			FormaPagoPuntoVentaParameterReturnGeneral formapagopuntoventaReturnGeneral=new FormaPagoPuntoVentaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				formapagopuntoventaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FormaPagoPuntoVentaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,formapagopuntoventas,formapagopuntoventa,formapagopuntoventaParameterGeneral,formapagopuntoventaReturnGeneral,isEsNuevoFormaPagoPuntoVenta,clases);
			
			return formapagopuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public FormaPagoPuntoVentaParameterReturnGeneral procesarEventosFormaPagoPuntoVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<FormaPagoPuntoVenta> formapagopuntoventas,FormaPagoPuntoVenta formapagopuntoventa,FormaPagoPuntoVentaParameterReturnGeneral formapagopuntoventaParameterGeneral,Boolean isEsNuevoFormaPagoPuntoVenta,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoPuntoVenta.class.getSimpleName()+"-procesarEventosFormaPagoPuntoVentasWithConnection");connexion.begin();			
			
			FormaPagoPuntoVentaParameterReturnGeneral formapagopuntoventaReturnGeneral=new FormaPagoPuntoVentaParameterReturnGeneral();
	
			formapagopuntoventaReturnGeneral.setFormaPagoPuntoVenta(formapagopuntoventa);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				formapagopuntoventaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			FormaPagoPuntoVentaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,formapagopuntoventas,formapagopuntoventa,formapagopuntoventaParameterGeneral,formapagopuntoventaReturnGeneral,isEsNuevoFormaPagoPuntoVenta,clases);
			
			this.connexion.commit();
			
			return formapagopuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public FormaPagoPuntoVentaParameterReturnGeneral procesarImportacionFormaPagoPuntoVentasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,FormaPagoPuntoVentaParameterReturnGeneral formapagopuntoventaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoPuntoVenta.class.getSimpleName()+"-procesarImportacionFormaPagoPuntoVentasWithConnection");connexion.begin();			
			
			FormaPagoPuntoVentaParameterReturnGeneral formapagopuntoventaReturnGeneral=new FormaPagoPuntoVentaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.formapagopuntoventas=new ArrayList<FormaPagoPuntoVenta>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.formapagopuntoventa=new FormaPagoPuntoVenta();
				
				
				if(conColumnasBase) {this.formapagopuntoventa.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.formapagopuntoventa.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.formapagopuntoventa.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.formapagopuntoventa.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				this.formapagopuntoventa.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.formapagopuntoventa.setdescripcion(arrColumnas[iColumn++]);
				this.formapagopuntoventa.setfecha_inicio(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.formapagopuntoventa.setnumero_dias_plazo(Integer.parseInt(arrColumnas[iColumn++]));
				this.formapagopuntoventa.setfecha_fin(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.formapagopuntoventa.setnumero_cuenta(arrColumnas[iColumn++]);
				this.formapagopuntoventa.setnumero_cheque(arrColumnas[iColumn++]);
				this.formapagopuntoventa.setgirador(arrColumnas[iColumn++]);
				this.formapagopuntoventa.setnumero(arrColumnas[iColumn++]);
				this.formapagopuntoventa.settarjeta_habiente(arrColumnas[iColumn++]);
				this.formapagopuntoventa.setautorizacion(arrColumnas[iColumn++]);
				this.formapagopuntoventa.setvoucher(arrColumnas[iColumn++]);
				this.formapagopuntoventa.setlote(arrColumnas[iColumn++]);
				this.formapagopuntoventa.setcuota(Integer.parseInt(arrColumnas[iColumn++]));
				this.formapagopuntoventa.setvalor_retencion(Double.parseDouble(arrColumnas[iColumn++]));
				this.formapagopuntoventa.setvalor_comision(Double.parseDouble(arrColumnas[iColumn++]));
				this.formapagopuntoventa.setvalor_calculado(Double.parseDouble(arrColumnas[iColumn++]));
				this.formapagopuntoventa.setvalor_cancelado(Double.parseDouble(arrColumnas[iColumn++]));
				this.formapagopuntoventa.setvalor_difiere(Double.parseDouble(arrColumnas[iColumn++]));
				this.formapagopuntoventa.setnumero_retencion(arrColumnas[iColumn++]);
				this.formapagopuntoventa.setnumero_liquidacion(arrColumnas[iColumn++]);
				
				this.formapagopuntoventas.add(this.formapagopuntoventa);
			}
			
			this.saveFormaPagoPuntoVentas();
			
			this.connexion.commit();
			
			formapagopuntoventaReturnGeneral.setConRetornoEstaProcesado(true);
			formapagopuntoventaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return formapagopuntoventaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarFormaPagoPuntoVentasEliminados() throws Exception {				
		
		List<FormaPagoPuntoVenta> formapagopuntoventasAux= new ArrayList<FormaPagoPuntoVenta>();
		
		for(FormaPagoPuntoVenta formapagopuntoventa:formapagopuntoventas) {
			if(!formapagopuntoventa.getIsDeleted()) {
				formapagopuntoventasAux.add(formapagopuntoventa);
			}
		}
		
		formapagopuntoventas=formapagopuntoventasAux;
	}
	
	public void quitarFormaPagoPuntoVentasNulos() throws Exception {				
		
		List<FormaPagoPuntoVenta> formapagopuntoventasAux= new ArrayList<FormaPagoPuntoVenta>();
		
		for(FormaPagoPuntoVenta formapagopuntoventa : this.formapagopuntoventas) {
			if(formapagopuntoventa==null) {
				formapagopuntoventasAux.add(formapagopuntoventa);
			}
		}
		
		//this.formapagopuntoventas=formapagopuntoventasAux;
		
		this.formapagopuntoventas.removeAll(formapagopuntoventasAux);
	}
	
	public void getSetVersionRowFormaPagoPuntoVentaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(formapagopuntoventa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((formapagopuntoventa.getIsDeleted() || (formapagopuntoventa.getIsChanged()&&!formapagopuntoventa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=formapagopuntoventaDataAccess.getSetVersionRowFormaPagoPuntoVenta(connexion,formapagopuntoventa.getId());
				
				if(!formapagopuntoventa.getVersionRow().equals(timestamp)) {	
					formapagopuntoventa.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				formapagopuntoventa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowFormaPagoPuntoVenta()throws Exception {	
		
		if(formapagopuntoventa.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((formapagopuntoventa.getIsDeleted() || (formapagopuntoventa.getIsChanged()&&!formapagopuntoventa.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=formapagopuntoventaDataAccess.getSetVersionRowFormaPagoPuntoVenta(connexion,formapagopuntoventa.getId());
			
			try {							
				if(!formapagopuntoventa.getVersionRow().equals(timestamp)) {	
					formapagopuntoventa.setVersionRow(timestamp);
				}
				
				formapagopuntoventa.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowFormaPagoPuntoVentasWithConnection()throws Exception {	
		if(formapagopuntoventas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(FormaPagoPuntoVenta formapagopuntoventaAux:formapagopuntoventas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(formapagopuntoventaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(formapagopuntoventaAux.getIsDeleted() || (formapagopuntoventaAux.getIsChanged()&&!formapagopuntoventaAux.getIsNew())) {
						
						timestamp=formapagopuntoventaDataAccess.getSetVersionRowFormaPagoPuntoVenta(connexion,formapagopuntoventaAux.getId());
						
						if(!formapagopuntoventa.getVersionRow().equals(timestamp)) {	
							formapagopuntoventaAux.setVersionRow(timestamp);
						}
								
						formapagopuntoventaAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowFormaPagoPuntoVentas()throws Exception {	
		if(formapagopuntoventas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(FormaPagoPuntoVenta formapagopuntoventaAux:formapagopuntoventas) {
					if(formapagopuntoventaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(formapagopuntoventaAux.getIsDeleted() || (formapagopuntoventaAux.getIsChanged()&&!formapagopuntoventaAux.getIsNew())) {
						
						timestamp=formapagopuntoventaDataAccess.getSetVersionRowFormaPagoPuntoVenta(connexion,formapagopuntoventaAux.getId());
						
						if(!formapagopuntoventaAux.getVersionRow().equals(timestamp)) {	
							formapagopuntoventaAux.setVersionRow(timestamp);
						}
						
													
						formapagopuntoventaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public FormaPagoPuntoVentaParameterReturnGeneral cargarCombosLoteForeignKeyFormaPagoPuntoVentaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalFacturaPuntoVenta,String finalQueryGlobalTipoFormaPago,String finalQueryGlobalBanco,String finalQueryGlobalCuentaBancoPunVen,String finalQueryGlobalTipoRiesgoCheque,String finalQueryGlobalBancoTarjeta,String finalQueryGlobalTarjetaCredito,String finalQueryGlobalTipoInteresTarjeta,String finalQueryGlobalTipoPagoTarjeta,String finalQueryGlobalConexion,String finalQueryGlobalMes,String finalQueryGlobalAnio,String finalQueryGlobalCuentaContable,String finalQueryGlobalAsientoContable) throws Exception {
		FormaPagoPuntoVentaParameterReturnGeneral  formapagopuntoventaReturnGeneral =new FormaPagoPuntoVentaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoPuntoVenta.class.getSimpleName()+"-cargarCombosLoteForeignKeyFormaPagoPuntoVentaWithConnection");connexion.begin();
			
			formapagopuntoventaReturnGeneral =new FormaPagoPuntoVentaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			formapagopuntoventaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			formapagopuntoventaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			formapagopuntoventaReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			formapagopuntoventaReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<FacturaPuntoVenta> facturapuntoventasForeignKey=new ArrayList<FacturaPuntoVenta>();
			FacturaPuntoVentaLogic facturapuntoventaLogic=new FacturaPuntoVentaLogic();
			facturapuntoventaLogic.setConnexion(this.connexion);
			facturapuntoventaLogic.getFacturaPuntoVentaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFacturaPuntoVenta.equals("NONE")) {
				facturapuntoventaLogic.getTodosFacturaPuntoVentas(finalQueryGlobalFacturaPuntoVenta,new Pagination());
				facturapuntoventasForeignKey=facturapuntoventaLogic.getFacturaPuntoVentas();
			}

			formapagopuntoventaReturnGeneral.setfacturapuntoventasForeignKey(facturapuntoventasForeignKey);


			List<TipoFormaPago> tipoformapagosForeignKey=new ArrayList<TipoFormaPago>();
			TipoFormaPagoLogic tipoformapagoLogic=new TipoFormaPagoLogic();
			tipoformapagoLogic.setConnexion(this.connexion);
			//tipoformapagoLogic.getTipoFormaPagoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoFormaPago.equals("NONE")) {
				tipoformapagoLogic.getTodosTipoFormaPagos(finalQueryGlobalTipoFormaPago,new Pagination());
				tipoformapagosForeignKey=tipoformapagoLogic.getTipoFormaPagos();
			}

			formapagopuntoventaReturnGeneral.settipoformapagosForeignKey(tipoformapagosForeignKey);


			List<Banco> bancosForeignKey=new ArrayList<Banco>();
			BancoLogic bancoLogic=new BancoLogic();
			bancoLogic.setConnexion(this.connexion);
			bancoLogic.getBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBanco.equals("NONE")) {
				bancoLogic.getTodosBancos(finalQueryGlobalBanco,new Pagination());
				bancosForeignKey=bancoLogic.getBancos();
			}

			formapagopuntoventaReturnGeneral.setbancosForeignKey(bancosForeignKey);


			List<CuentaBancoPunVen> cuentabancopunvensForeignKey=new ArrayList<CuentaBancoPunVen>();
			CuentaBancoPunVenLogic cuentabancopunvenLogic=new CuentaBancoPunVenLogic();
			cuentabancopunvenLogic.setConnexion(this.connexion);
			cuentabancopunvenLogic.getCuentaBancoPunVenDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaBancoPunVen.equals("NONE")) {
				cuentabancopunvenLogic.getTodosCuentaBancoPunVens(finalQueryGlobalCuentaBancoPunVen,new Pagination());
				cuentabancopunvensForeignKey=cuentabancopunvenLogic.getCuentaBancoPunVens();
			}

			formapagopuntoventaReturnGeneral.setcuentabancopunvensForeignKey(cuentabancopunvensForeignKey);


			List<TipoRiesgoCheque> tiporiesgochequesForeignKey=new ArrayList<TipoRiesgoCheque>();
			TipoRiesgoChequeLogic tiporiesgochequeLogic=new TipoRiesgoChequeLogic();
			tiporiesgochequeLogic.setConnexion(this.connexion);
			tiporiesgochequeLogic.getTipoRiesgoChequeDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRiesgoCheque.equals("NONE")) {
				tiporiesgochequeLogic.getTodosTipoRiesgoCheques(finalQueryGlobalTipoRiesgoCheque,new Pagination());
				tiporiesgochequesForeignKey=tiporiesgochequeLogic.getTipoRiesgoCheques();
			}

			formapagopuntoventaReturnGeneral.settiporiesgochequesForeignKey(tiporiesgochequesForeignKey);


			List<Banco> bancotarjetasForeignKey=new ArrayList<Banco>();
			BancoLogic bancotarjetaLogic=new BancoLogic();
			bancotarjetaLogic.setConnexion(this.connexion);
			bancotarjetaLogic.getBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBancoTarjeta.equals("NONE")) {
				bancotarjetaLogic.getTodosBancos(finalQueryGlobalBancoTarjeta,new Pagination());
				bancotarjetasForeignKey=bancotarjetaLogic.getBancos();
			}

			formapagopuntoventaReturnGeneral.setbancotarjetasForeignKey(bancotarjetasForeignKey);


			List<TarjetaCredito> tarjetacreditosForeignKey=new ArrayList<TarjetaCredito>();
			TarjetaCreditoLogic tarjetacreditoLogic=new TarjetaCreditoLogic();
			tarjetacreditoLogic.setConnexion(this.connexion);
			tarjetacreditoLogic.getTarjetaCreditoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTarjetaCredito.equals("NONE")) {
				tarjetacreditoLogic.getTodosTarjetaCreditos(finalQueryGlobalTarjetaCredito,new Pagination());
				tarjetacreditosForeignKey=tarjetacreditoLogic.getTarjetaCreditos();
			}

			formapagopuntoventaReturnGeneral.settarjetacreditosForeignKey(tarjetacreditosForeignKey);


			List<TipoInteresTarjeta> tipointerestarjetasForeignKey=new ArrayList<TipoInteresTarjeta>();
			TipoInteresTarjetaLogic tipointerestarjetaLogic=new TipoInteresTarjetaLogic();
			tipointerestarjetaLogic.setConnexion(this.connexion);
			tipointerestarjetaLogic.getTipoInteresTarjetaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoInteresTarjeta.equals("NONE")) {
				tipointerestarjetaLogic.getTodosTipoInteresTarjetas(finalQueryGlobalTipoInteresTarjeta,new Pagination());
				tipointerestarjetasForeignKey=tipointerestarjetaLogic.getTipoInteresTarjetas();
			}

			formapagopuntoventaReturnGeneral.settipointerestarjetasForeignKey(tipointerestarjetasForeignKey);


			List<TipoPagoTarjeta> tipopagotarjetasForeignKey=new ArrayList<TipoPagoTarjeta>();
			TipoPagoTarjetaLogic tipopagotarjetaLogic=new TipoPagoTarjetaLogic();
			tipopagotarjetaLogic.setConnexion(this.connexion);
			tipopagotarjetaLogic.getTipoPagoTarjetaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPagoTarjeta.equals("NONE")) {
				tipopagotarjetaLogic.getTodosTipoPagoTarjetas(finalQueryGlobalTipoPagoTarjeta,new Pagination());
				tipopagotarjetasForeignKey=tipopagotarjetaLogic.getTipoPagoTarjetas();
			}

			formapagopuntoventaReturnGeneral.settipopagotarjetasForeignKey(tipopagotarjetasForeignKey);


			List<Conexion> conexionsForeignKey=new ArrayList<Conexion>();
			ConexionLogic conexionLogic=new ConexionLogic();
			conexionLogic.setConnexion(this.connexion);
			conexionLogic.getConexionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalConexion.equals("NONE")) {
				conexionLogic.getTodosConexions(finalQueryGlobalConexion,new Pagination());
				conexionsForeignKey=conexionLogic.getConexions();
			}

			formapagopuntoventaReturnGeneral.setconexionsForeignKey(conexionsForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			formapagopuntoventaReturnGeneral.setmessForeignKey(messForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			formapagopuntoventaReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			formapagopuntoventaReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			formapagopuntoventaReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return formapagopuntoventaReturnGeneral;
	}
	
	public FormaPagoPuntoVentaParameterReturnGeneral cargarCombosLoteForeignKeyFormaPagoPuntoVenta(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalFacturaPuntoVenta,String finalQueryGlobalTipoFormaPago,String finalQueryGlobalBanco,String finalQueryGlobalCuentaBancoPunVen,String finalQueryGlobalTipoRiesgoCheque,String finalQueryGlobalBancoTarjeta,String finalQueryGlobalTarjetaCredito,String finalQueryGlobalTipoInteresTarjeta,String finalQueryGlobalTipoPagoTarjeta,String finalQueryGlobalConexion,String finalQueryGlobalMes,String finalQueryGlobalAnio,String finalQueryGlobalCuentaContable,String finalQueryGlobalAsientoContable) throws Exception {
		FormaPagoPuntoVentaParameterReturnGeneral  formapagopuntoventaReturnGeneral =new FormaPagoPuntoVentaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			formapagopuntoventaReturnGeneral =new FormaPagoPuntoVentaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			formapagopuntoventaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			formapagopuntoventaReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			formapagopuntoventaReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			formapagopuntoventaReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<FacturaPuntoVenta> facturapuntoventasForeignKey=new ArrayList<FacturaPuntoVenta>();
			FacturaPuntoVentaLogic facturapuntoventaLogic=new FacturaPuntoVentaLogic();
			facturapuntoventaLogic.setConnexion(this.connexion);
			facturapuntoventaLogic.getFacturaPuntoVentaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFacturaPuntoVenta.equals("NONE")) {
				facturapuntoventaLogic.getTodosFacturaPuntoVentas(finalQueryGlobalFacturaPuntoVenta,new Pagination());
				facturapuntoventasForeignKey=facturapuntoventaLogic.getFacturaPuntoVentas();
			}

			formapagopuntoventaReturnGeneral.setfacturapuntoventasForeignKey(facturapuntoventasForeignKey);


			List<TipoFormaPago> tipoformapagosForeignKey=new ArrayList<TipoFormaPago>();
			TipoFormaPagoLogic tipoformapagoLogic=new TipoFormaPagoLogic();
			tipoformapagoLogic.setConnexion(this.connexion);
			//tipoformapagoLogic.getTipoFormaPagoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoFormaPago.equals("NONE")) {
				tipoformapagoLogic.getTodosTipoFormaPagos(finalQueryGlobalTipoFormaPago,new Pagination());
				tipoformapagosForeignKey=tipoformapagoLogic.getTipoFormaPagos();
			}

			formapagopuntoventaReturnGeneral.settipoformapagosForeignKey(tipoformapagosForeignKey);


			List<Banco> bancosForeignKey=new ArrayList<Banco>();
			BancoLogic bancoLogic=new BancoLogic();
			bancoLogic.setConnexion(this.connexion);
			bancoLogic.getBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBanco.equals("NONE")) {
				bancoLogic.getTodosBancos(finalQueryGlobalBanco,new Pagination());
				bancosForeignKey=bancoLogic.getBancos();
			}

			formapagopuntoventaReturnGeneral.setbancosForeignKey(bancosForeignKey);


			List<CuentaBancoPunVen> cuentabancopunvensForeignKey=new ArrayList<CuentaBancoPunVen>();
			CuentaBancoPunVenLogic cuentabancopunvenLogic=new CuentaBancoPunVenLogic();
			cuentabancopunvenLogic.setConnexion(this.connexion);
			cuentabancopunvenLogic.getCuentaBancoPunVenDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaBancoPunVen.equals("NONE")) {
				cuentabancopunvenLogic.getTodosCuentaBancoPunVens(finalQueryGlobalCuentaBancoPunVen,new Pagination());
				cuentabancopunvensForeignKey=cuentabancopunvenLogic.getCuentaBancoPunVens();
			}

			formapagopuntoventaReturnGeneral.setcuentabancopunvensForeignKey(cuentabancopunvensForeignKey);


			List<TipoRiesgoCheque> tiporiesgochequesForeignKey=new ArrayList<TipoRiesgoCheque>();
			TipoRiesgoChequeLogic tiporiesgochequeLogic=new TipoRiesgoChequeLogic();
			tiporiesgochequeLogic.setConnexion(this.connexion);
			tiporiesgochequeLogic.getTipoRiesgoChequeDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRiesgoCheque.equals("NONE")) {
				tiporiesgochequeLogic.getTodosTipoRiesgoCheques(finalQueryGlobalTipoRiesgoCheque,new Pagination());
				tiporiesgochequesForeignKey=tiporiesgochequeLogic.getTipoRiesgoCheques();
			}

			formapagopuntoventaReturnGeneral.settiporiesgochequesForeignKey(tiporiesgochequesForeignKey);


			List<Banco> bancotarjetasForeignKey=new ArrayList<Banco>();
			BancoLogic bancotarjetaLogic=new BancoLogic();
			bancotarjetaLogic.setConnexion(this.connexion);
			bancotarjetaLogic.getBancoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalBancoTarjeta.equals("NONE")) {
				bancotarjetaLogic.getTodosBancos(finalQueryGlobalBancoTarjeta,new Pagination());
				bancotarjetasForeignKey=bancotarjetaLogic.getBancos();
			}

			formapagopuntoventaReturnGeneral.setbancotarjetasForeignKey(bancotarjetasForeignKey);


			List<TarjetaCredito> tarjetacreditosForeignKey=new ArrayList<TarjetaCredito>();
			TarjetaCreditoLogic tarjetacreditoLogic=new TarjetaCreditoLogic();
			tarjetacreditoLogic.setConnexion(this.connexion);
			tarjetacreditoLogic.getTarjetaCreditoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTarjetaCredito.equals("NONE")) {
				tarjetacreditoLogic.getTodosTarjetaCreditos(finalQueryGlobalTarjetaCredito,new Pagination());
				tarjetacreditosForeignKey=tarjetacreditoLogic.getTarjetaCreditos();
			}

			formapagopuntoventaReturnGeneral.settarjetacreditosForeignKey(tarjetacreditosForeignKey);


			List<TipoInteresTarjeta> tipointerestarjetasForeignKey=new ArrayList<TipoInteresTarjeta>();
			TipoInteresTarjetaLogic tipointerestarjetaLogic=new TipoInteresTarjetaLogic();
			tipointerestarjetaLogic.setConnexion(this.connexion);
			tipointerestarjetaLogic.getTipoInteresTarjetaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoInteresTarjeta.equals("NONE")) {
				tipointerestarjetaLogic.getTodosTipoInteresTarjetas(finalQueryGlobalTipoInteresTarjeta,new Pagination());
				tipointerestarjetasForeignKey=tipointerestarjetaLogic.getTipoInteresTarjetas();
			}

			formapagopuntoventaReturnGeneral.settipointerestarjetasForeignKey(tipointerestarjetasForeignKey);


			List<TipoPagoTarjeta> tipopagotarjetasForeignKey=new ArrayList<TipoPagoTarjeta>();
			TipoPagoTarjetaLogic tipopagotarjetaLogic=new TipoPagoTarjetaLogic();
			tipopagotarjetaLogic.setConnexion(this.connexion);
			tipopagotarjetaLogic.getTipoPagoTarjetaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoPagoTarjeta.equals("NONE")) {
				tipopagotarjetaLogic.getTodosTipoPagoTarjetas(finalQueryGlobalTipoPagoTarjeta,new Pagination());
				tipopagotarjetasForeignKey=tipopagotarjetaLogic.getTipoPagoTarjetas();
			}

			formapagopuntoventaReturnGeneral.settipopagotarjetasForeignKey(tipopagotarjetasForeignKey);


			List<Conexion> conexionsForeignKey=new ArrayList<Conexion>();
			ConexionLogic conexionLogic=new ConexionLogic();
			conexionLogic.setConnexion(this.connexion);
			conexionLogic.getConexionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalConexion.equals("NONE")) {
				conexionLogic.getTodosConexions(finalQueryGlobalConexion,new Pagination());
				conexionsForeignKey=conexionLogic.getConexions();
			}

			formapagopuntoventaReturnGeneral.setconexionsForeignKey(conexionsForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			formapagopuntoventaReturnGeneral.setmessForeignKey(messForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			formapagopuntoventaReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			formapagopuntoventaReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<AsientoContable> asientocontablesForeignKey=new ArrayList<AsientoContable>();
			AsientoContableLogic asientocontableLogic=new AsientoContableLogic();
			asientocontableLogic.setConnexion(this.connexion);
			asientocontableLogic.getAsientoContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAsientoContable.equals("NONE")) {
				asientocontableLogic.getTodosAsientoContables(finalQueryGlobalAsientoContable,new Pagination());
				asientocontablesForeignKey=asientocontableLogic.getAsientoContables();
			}

			formapagopuntoventaReturnGeneral.setasientocontablesForeignKey(asientocontablesForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return formapagopuntoventaReturnGeneral;
	}
	
	
	public void deepLoad(FormaPagoPuntoVenta formapagopuntoventa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			FormaPagoPuntoVentaLogicAdditional.updateFormaPagoPuntoVentaToGet(formapagopuntoventa,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		formapagopuntoventa.setEmpresa(formapagopuntoventaDataAccess.getEmpresa(connexion,formapagopuntoventa));
		formapagopuntoventa.setSucursal(formapagopuntoventaDataAccess.getSucursal(connexion,formapagopuntoventa));
		formapagopuntoventa.setEjercicio(formapagopuntoventaDataAccess.getEjercicio(connexion,formapagopuntoventa));
		formapagopuntoventa.setPeriodo(formapagopuntoventaDataAccess.getPeriodo(connexion,formapagopuntoventa));
		formapagopuntoventa.setFacturaPuntoVenta(formapagopuntoventaDataAccess.getFacturaPuntoVenta(connexion,formapagopuntoventa));
		formapagopuntoventa.setTipoFormaPago(formapagopuntoventaDataAccess.getTipoFormaPago(connexion,formapagopuntoventa));
		formapagopuntoventa.setBanco(formapagopuntoventaDataAccess.getBanco(connexion,formapagopuntoventa));
		formapagopuntoventa.setCuentaBancoPunVen(formapagopuntoventaDataAccess.getCuentaBancoPunVen(connexion,formapagopuntoventa));
		formapagopuntoventa.setTipoRiesgoCheque(formapagopuntoventaDataAccess.getTipoRiesgoCheque(connexion,formapagopuntoventa));
		formapagopuntoventa.setBancoTarjeta(formapagopuntoventaDataAccess.getBancoTarjeta(connexion,formapagopuntoventa));
		formapagopuntoventa.setTarjetaCredito(formapagopuntoventaDataAccess.getTarjetaCredito(connexion,formapagopuntoventa));
		formapagopuntoventa.setTipoInteresTarjeta(formapagopuntoventaDataAccess.getTipoInteresTarjeta(connexion,formapagopuntoventa));
		formapagopuntoventa.setTipoPagoTarjeta(formapagopuntoventaDataAccess.getTipoPagoTarjeta(connexion,formapagopuntoventa));
		formapagopuntoventa.setConexion(formapagopuntoventaDataAccess.getConexion(connexion,formapagopuntoventa));
		formapagopuntoventa.setMes(formapagopuntoventaDataAccess.getMes(connexion,formapagopuntoventa));
		formapagopuntoventa.setAnio(formapagopuntoventaDataAccess.getAnio(connexion,formapagopuntoventa));
		formapagopuntoventa.setCuentaContable(formapagopuntoventaDataAccess.getCuentaContable(connexion,formapagopuntoventa));
		formapagopuntoventa.setAsientoContable(formapagopuntoventaDataAccess.getAsientoContable(connexion,formapagopuntoventa));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				formapagopuntoventa.setEmpresa(formapagopuntoventaDataAccess.getEmpresa(connexion,formapagopuntoventa));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				formapagopuntoventa.setSucursal(formapagopuntoventaDataAccess.getSucursal(connexion,formapagopuntoventa));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				formapagopuntoventa.setEjercicio(formapagopuntoventaDataAccess.getEjercicio(connexion,formapagopuntoventa));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				formapagopuntoventa.setPeriodo(formapagopuntoventaDataAccess.getPeriodo(connexion,formapagopuntoventa));
				continue;
			}

			if(clas.clas.equals(FacturaPuntoVenta.class)) {
				formapagopuntoventa.setFacturaPuntoVenta(formapagopuntoventaDataAccess.getFacturaPuntoVenta(connexion,formapagopuntoventa));
				continue;
			}

			if(clas.clas.equals(TipoFormaPago.class)) {
				formapagopuntoventa.setTipoFormaPago(formapagopuntoventaDataAccess.getTipoFormaPago(connexion,formapagopuntoventa));
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				formapagopuntoventa.setBanco(formapagopuntoventaDataAccess.getBanco(connexion,formapagopuntoventa));
				continue;
			}

			if(clas.clas.equals(CuentaBancoPunVen.class)) {
				formapagopuntoventa.setCuentaBancoPunVen(formapagopuntoventaDataAccess.getCuentaBancoPunVen(connexion,formapagopuntoventa));
				continue;
			}

			if(clas.clas.equals(TipoRiesgoCheque.class)) {
				formapagopuntoventa.setTipoRiesgoCheque(formapagopuntoventaDataAccess.getTipoRiesgoCheque(connexion,formapagopuntoventa));
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				formapagopuntoventa.setBancoTarjeta(formapagopuntoventaDataAccess.getBancoTarjeta(connexion,formapagopuntoventa));
				continue;
			}

			if(clas.clas.equals(TarjetaCredito.class)) {
				formapagopuntoventa.setTarjetaCredito(formapagopuntoventaDataAccess.getTarjetaCredito(connexion,formapagopuntoventa));
				continue;
			}

			if(clas.clas.equals(TipoInteresTarjeta.class)) {
				formapagopuntoventa.setTipoInteresTarjeta(formapagopuntoventaDataAccess.getTipoInteresTarjeta(connexion,formapagopuntoventa));
				continue;
			}

			if(clas.clas.equals(TipoPagoTarjeta.class)) {
				formapagopuntoventa.setTipoPagoTarjeta(formapagopuntoventaDataAccess.getTipoPagoTarjeta(connexion,formapagopuntoventa));
				continue;
			}

			if(clas.clas.equals(Conexion.class)) {
				formapagopuntoventa.setConexion(formapagopuntoventaDataAccess.getConexion(connexion,formapagopuntoventa));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				formapagopuntoventa.setMes(formapagopuntoventaDataAccess.getMes(connexion,formapagopuntoventa));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				formapagopuntoventa.setAnio(formapagopuntoventaDataAccess.getAnio(connexion,formapagopuntoventa));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				formapagopuntoventa.setCuentaContable(formapagopuntoventaDataAccess.getCuentaContable(connexion,formapagopuntoventa));
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				formapagopuntoventa.setAsientoContable(formapagopuntoventaDataAccess.getAsientoContable(connexion,formapagopuntoventa));
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
			formapagopuntoventa.setEmpresa(formapagopuntoventaDataAccess.getEmpresa(connexion,formapagopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagopuntoventa.setSucursal(formapagopuntoventaDataAccess.getSucursal(connexion,formapagopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagopuntoventa.setEjercicio(formapagopuntoventaDataAccess.getEjercicio(connexion,formapagopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagopuntoventa.setPeriodo(formapagopuntoventaDataAccess.getPeriodo(connexion,formapagopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaPuntoVenta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagopuntoventa.setFacturaPuntoVenta(formapagopuntoventaDataAccess.getFacturaPuntoVenta(connexion,formapagopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFormaPago.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagopuntoventa.setTipoFormaPago(formapagopuntoventaDataAccess.getTipoFormaPago(connexion,formapagopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Banco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagopuntoventa.setBanco(formapagopuntoventaDataAccess.getBanco(connexion,formapagopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaBancoPunVen.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagopuntoventa.setCuentaBancoPunVen(formapagopuntoventaDataAccess.getCuentaBancoPunVen(connexion,formapagopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRiesgoCheque.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagopuntoventa.setTipoRiesgoCheque(formapagopuntoventaDataAccess.getTipoRiesgoCheque(connexion,formapagopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Banco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagopuntoventa.setBancoTarjeta(formapagopuntoventaDataAccess.getBancoTarjeta(connexion,formapagopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TarjetaCredito.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagopuntoventa.setTarjetaCredito(formapagopuntoventaDataAccess.getTarjetaCredito(connexion,formapagopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoInteresTarjeta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagopuntoventa.setTipoInteresTarjeta(formapagopuntoventaDataAccess.getTipoInteresTarjeta(connexion,formapagopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPagoTarjeta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagopuntoventa.setTipoPagoTarjeta(formapagopuntoventaDataAccess.getTipoPagoTarjeta(connexion,formapagopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Conexion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagopuntoventa.setConexion(formapagopuntoventaDataAccess.getConexion(connexion,formapagopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagopuntoventa.setMes(formapagopuntoventaDataAccess.getMes(connexion,formapagopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagopuntoventa.setAnio(formapagopuntoventaDataAccess.getAnio(connexion,formapagopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagopuntoventa.setCuentaContable(formapagopuntoventaDataAccess.getCuentaContable(connexion,formapagopuntoventa));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagopuntoventa.setAsientoContable(formapagopuntoventaDataAccess.getAsientoContable(connexion,formapagopuntoventa));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		formapagopuntoventa.setEmpresa(formapagopuntoventaDataAccess.getEmpresa(connexion,formapagopuntoventa));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(formapagopuntoventa.getEmpresa(),isDeep,deepLoadType,clases);
				
		formapagopuntoventa.setSucursal(formapagopuntoventaDataAccess.getSucursal(connexion,formapagopuntoventa));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(formapagopuntoventa.getSucursal(),isDeep,deepLoadType,clases);
				
		formapagopuntoventa.setEjercicio(formapagopuntoventaDataAccess.getEjercicio(connexion,formapagopuntoventa));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(formapagopuntoventa.getEjercicio(),isDeep,deepLoadType,clases);
				
		formapagopuntoventa.setPeriodo(formapagopuntoventaDataAccess.getPeriodo(connexion,formapagopuntoventa));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(formapagopuntoventa.getPeriodo(),isDeep,deepLoadType,clases);
				
		formapagopuntoventa.setFacturaPuntoVenta(formapagopuntoventaDataAccess.getFacturaPuntoVenta(connexion,formapagopuntoventa));
		FacturaPuntoVentaLogic facturapuntoventaLogic= new FacturaPuntoVentaLogic(connexion);
		facturapuntoventaLogic.deepLoad(formapagopuntoventa.getFacturaPuntoVenta(),isDeep,deepLoadType,clases);
				
		formapagopuntoventa.setTipoFormaPago(formapagopuntoventaDataAccess.getTipoFormaPago(connexion,formapagopuntoventa));
		TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
		tipoformapagoLogic.deepLoad(formapagopuntoventa.getTipoFormaPago(),isDeep,deepLoadType,clases);
				
		formapagopuntoventa.setBanco(formapagopuntoventaDataAccess.getBanco(connexion,formapagopuntoventa));
		BancoLogic bancoLogic= new BancoLogic(connexion);
		bancoLogic.deepLoad(formapagopuntoventa.getBanco(),isDeep,deepLoadType,clases);
				
		formapagopuntoventa.setCuentaBancoPunVen(formapagopuntoventaDataAccess.getCuentaBancoPunVen(connexion,formapagopuntoventa));
		CuentaBancoPunVenLogic cuentabancopunvenLogic= new CuentaBancoPunVenLogic(connexion);
		cuentabancopunvenLogic.deepLoad(formapagopuntoventa.getCuentaBancoPunVen(),isDeep,deepLoadType,clases);
				
		formapagopuntoventa.setTipoRiesgoCheque(formapagopuntoventaDataAccess.getTipoRiesgoCheque(connexion,formapagopuntoventa));
		TipoRiesgoChequeLogic tiporiesgochequeLogic= new TipoRiesgoChequeLogic(connexion);
		tiporiesgochequeLogic.deepLoad(formapagopuntoventa.getTipoRiesgoCheque(),isDeep,deepLoadType,clases);
				
		formapagopuntoventa.setBancoTarjeta(formapagopuntoventaDataAccess.getBancoTarjeta(connexion,formapagopuntoventa));
		BancoLogic bancotarjetaLogic= new BancoLogic(connexion);
		bancotarjetaLogic.deepLoad(formapagopuntoventa.getBancoTarjeta(),isDeep,deepLoadType,clases);
				
		formapagopuntoventa.setTarjetaCredito(formapagopuntoventaDataAccess.getTarjetaCredito(connexion,formapagopuntoventa));
		TarjetaCreditoLogic tarjetacreditoLogic= new TarjetaCreditoLogic(connexion);
		tarjetacreditoLogic.deepLoad(formapagopuntoventa.getTarjetaCredito(),isDeep,deepLoadType,clases);
				
		formapagopuntoventa.setTipoInteresTarjeta(formapagopuntoventaDataAccess.getTipoInteresTarjeta(connexion,formapagopuntoventa));
		TipoInteresTarjetaLogic tipointerestarjetaLogic= new TipoInteresTarjetaLogic(connexion);
		tipointerestarjetaLogic.deepLoad(formapagopuntoventa.getTipoInteresTarjeta(),isDeep,deepLoadType,clases);
				
		formapagopuntoventa.setTipoPagoTarjeta(formapagopuntoventaDataAccess.getTipoPagoTarjeta(connexion,formapagopuntoventa));
		TipoPagoTarjetaLogic tipopagotarjetaLogic= new TipoPagoTarjetaLogic(connexion);
		tipopagotarjetaLogic.deepLoad(formapagopuntoventa.getTipoPagoTarjeta(),isDeep,deepLoadType,clases);
				
		formapagopuntoventa.setConexion(formapagopuntoventaDataAccess.getConexion(connexion,formapagopuntoventa));
		ConexionLogic conexionLogic= new ConexionLogic(connexion);
		conexionLogic.deepLoad(formapagopuntoventa.getConexion(),isDeep,deepLoadType,clases);
				
		formapagopuntoventa.setMes(formapagopuntoventaDataAccess.getMes(connexion,formapagopuntoventa));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(formapagopuntoventa.getMes(),isDeep,deepLoadType,clases);
				
		formapagopuntoventa.setAnio(formapagopuntoventaDataAccess.getAnio(connexion,formapagopuntoventa));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(formapagopuntoventa.getAnio(),isDeep,deepLoadType,clases);
				
		formapagopuntoventa.setCuentaContable(formapagopuntoventaDataAccess.getCuentaContable(connexion,formapagopuntoventa));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(formapagopuntoventa.getCuentaContable(),isDeep,deepLoadType,clases);
				
		formapagopuntoventa.setAsientoContable(formapagopuntoventaDataAccess.getAsientoContable(connexion,formapagopuntoventa));
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(formapagopuntoventa.getAsientoContable(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				formapagopuntoventa.setEmpresa(formapagopuntoventaDataAccess.getEmpresa(connexion,formapagopuntoventa));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(formapagopuntoventa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				formapagopuntoventa.setSucursal(formapagopuntoventaDataAccess.getSucursal(connexion,formapagopuntoventa));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(formapagopuntoventa.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				formapagopuntoventa.setEjercicio(formapagopuntoventaDataAccess.getEjercicio(connexion,formapagopuntoventa));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(formapagopuntoventa.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				formapagopuntoventa.setPeriodo(formapagopuntoventaDataAccess.getPeriodo(connexion,formapagopuntoventa));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(formapagopuntoventa.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(FacturaPuntoVenta.class)) {
				formapagopuntoventa.setFacturaPuntoVenta(formapagopuntoventaDataAccess.getFacturaPuntoVenta(connexion,formapagopuntoventa));
				FacturaPuntoVentaLogic facturapuntoventaLogic= new FacturaPuntoVentaLogic(connexion);
				facturapuntoventaLogic.deepLoad(formapagopuntoventa.getFacturaPuntoVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoFormaPago.class)) {
				formapagopuntoventa.setTipoFormaPago(formapagopuntoventaDataAccess.getTipoFormaPago(connexion,formapagopuntoventa));
				TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
				tipoformapagoLogic.deepLoad(formapagopuntoventa.getTipoFormaPago(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				formapagopuntoventa.setBanco(formapagopuntoventaDataAccess.getBanco(connexion,formapagopuntoventa));
				BancoLogic bancoLogic= new BancoLogic(connexion);
				bancoLogic.deepLoad(formapagopuntoventa.getBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaBancoPunVen.class)) {
				formapagopuntoventa.setCuentaBancoPunVen(formapagopuntoventaDataAccess.getCuentaBancoPunVen(connexion,formapagopuntoventa));
				CuentaBancoPunVenLogic cuentabancopunvenLogic= new CuentaBancoPunVenLogic(connexion);
				cuentabancopunvenLogic.deepLoad(formapagopuntoventa.getCuentaBancoPunVen(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRiesgoCheque.class)) {
				formapagopuntoventa.setTipoRiesgoCheque(formapagopuntoventaDataAccess.getTipoRiesgoCheque(connexion,formapagopuntoventa));
				TipoRiesgoChequeLogic tiporiesgochequeLogic= new TipoRiesgoChequeLogic(connexion);
				tiporiesgochequeLogic.deepLoad(formapagopuntoventa.getTipoRiesgoCheque(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				formapagopuntoventa.setBancoTarjeta(formapagopuntoventaDataAccess.getBancoTarjeta(connexion,formapagopuntoventa));
				BancoLogic bancoLogic= new BancoLogic(connexion);
				bancoLogic.deepLoad(formapagopuntoventa.getBancoTarjeta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TarjetaCredito.class)) {
				formapagopuntoventa.setTarjetaCredito(formapagopuntoventaDataAccess.getTarjetaCredito(connexion,formapagopuntoventa));
				TarjetaCreditoLogic tarjetacreditoLogic= new TarjetaCreditoLogic(connexion);
				tarjetacreditoLogic.deepLoad(formapagopuntoventa.getTarjetaCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoInteresTarjeta.class)) {
				formapagopuntoventa.setTipoInteresTarjeta(formapagopuntoventaDataAccess.getTipoInteresTarjeta(connexion,formapagopuntoventa));
				TipoInteresTarjetaLogic tipointerestarjetaLogic= new TipoInteresTarjetaLogic(connexion);
				tipointerestarjetaLogic.deepLoad(formapagopuntoventa.getTipoInteresTarjeta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPagoTarjeta.class)) {
				formapagopuntoventa.setTipoPagoTarjeta(formapagopuntoventaDataAccess.getTipoPagoTarjeta(connexion,formapagopuntoventa));
				TipoPagoTarjetaLogic tipopagotarjetaLogic= new TipoPagoTarjetaLogic(connexion);
				tipopagotarjetaLogic.deepLoad(formapagopuntoventa.getTipoPagoTarjeta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Conexion.class)) {
				formapagopuntoventa.setConexion(formapagopuntoventaDataAccess.getConexion(connexion,formapagopuntoventa));
				ConexionLogic conexionLogic= new ConexionLogic(connexion);
				conexionLogic.deepLoad(formapagopuntoventa.getConexion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				formapagopuntoventa.setMes(formapagopuntoventaDataAccess.getMes(connexion,formapagopuntoventa));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(formapagopuntoventa.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				formapagopuntoventa.setAnio(formapagopuntoventaDataAccess.getAnio(connexion,formapagopuntoventa));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(formapagopuntoventa.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				formapagopuntoventa.setCuentaContable(formapagopuntoventaDataAccess.getCuentaContable(connexion,formapagopuntoventa));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(formapagopuntoventa.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				formapagopuntoventa.setAsientoContable(formapagopuntoventaDataAccess.getAsientoContable(connexion,formapagopuntoventa));
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepLoad(formapagopuntoventa.getAsientoContable(),isDeep,deepLoadType,clases);				
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
			formapagopuntoventa.setEmpresa(formapagopuntoventaDataAccess.getEmpresa(connexion,formapagopuntoventa));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(formapagopuntoventa.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagopuntoventa.setSucursal(formapagopuntoventaDataAccess.getSucursal(connexion,formapagopuntoventa));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(formapagopuntoventa.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagopuntoventa.setEjercicio(formapagopuntoventaDataAccess.getEjercicio(connexion,formapagopuntoventa));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(formapagopuntoventa.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagopuntoventa.setPeriodo(formapagopuntoventaDataAccess.getPeriodo(connexion,formapagopuntoventa));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(formapagopuntoventa.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(FacturaPuntoVenta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagopuntoventa.setFacturaPuntoVenta(formapagopuntoventaDataAccess.getFacturaPuntoVenta(connexion,formapagopuntoventa));
			FacturaPuntoVentaLogic facturapuntoventaLogic= new FacturaPuntoVentaLogic(connexion);
			facturapuntoventaLogic.deepLoad(formapagopuntoventa.getFacturaPuntoVenta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFormaPago.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagopuntoventa.setTipoFormaPago(formapagopuntoventaDataAccess.getTipoFormaPago(connexion,formapagopuntoventa));
			TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
			tipoformapagoLogic.deepLoad(formapagopuntoventa.getTipoFormaPago(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Banco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagopuntoventa.setBanco(formapagopuntoventaDataAccess.getBanco(connexion,formapagopuntoventa));
			BancoLogic bancoLogic= new BancoLogic(connexion);
			bancoLogic.deepLoad(formapagopuntoventa.getBanco(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaBancoPunVen.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagopuntoventa.setCuentaBancoPunVen(formapagopuntoventaDataAccess.getCuentaBancoPunVen(connexion,formapagopuntoventa));
			CuentaBancoPunVenLogic cuentabancopunvenLogic= new CuentaBancoPunVenLogic(connexion);
			cuentabancopunvenLogic.deepLoad(formapagopuntoventa.getCuentaBancoPunVen(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRiesgoCheque.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagopuntoventa.setTipoRiesgoCheque(formapagopuntoventaDataAccess.getTipoRiesgoCheque(connexion,formapagopuntoventa));
			TipoRiesgoChequeLogic tiporiesgochequeLogic= new TipoRiesgoChequeLogic(connexion);
			tiporiesgochequeLogic.deepLoad(formapagopuntoventa.getTipoRiesgoCheque(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Banco.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagopuntoventa.setBancoTarjeta(formapagopuntoventaDataAccess.getBancoTarjeta(connexion,formapagopuntoventa));
			BancoLogic bancoLogic= new BancoLogic(connexion);
			bancoLogic.deepLoad(formapagopuntoventa.getBancoTarjeta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TarjetaCredito.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagopuntoventa.setTarjetaCredito(formapagopuntoventaDataAccess.getTarjetaCredito(connexion,formapagopuntoventa));
			TarjetaCreditoLogic tarjetacreditoLogic= new TarjetaCreditoLogic(connexion);
			tarjetacreditoLogic.deepLoad(formapagopuntoventa.getTarjetaCredito(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoInteresTarjeta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagopuntoventa.setTipoInteresTarjeta(formapagopuntoventaDataAccess.getTipoInteresTarjeta(connexion,formapagopuntoventa));
			TipoInteresTarjetaLogic tipointerestarjetaLogic= new TipoInteresTarjetaLogic(connexion);
			tipointerestarjetaLogic.deepLoad(formapagopuntoventa.getTipoInteresTarjeta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoPagoTarjeta.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagopuntoventa.setTipoPagoTarjeta(formapagopuntoventaDataAccess.getTipoPagoTarjeta(connexion,formapagopuntoventa));
			TipoPagoTarjetaLogic tipopagotarjetaLogic= new TipoPagoTarjetaLogic(connexion);
			tipopagotarjetaLogic.deepLoad(formapagopuntoventa.getTipoPagoTarjeta(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Conexion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagopuntoventa.setConexion(formapagopuntoventaDataAccess.getConexion(connexion,formapagopuntoventa));
			ConexionLogic conexionLogic= new ConexionLogic(connexion);
			conexionLogic.deepLoad(formapagopuntoventa.getConexion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagopuntoventa.setMes(formapagopuntoventaDataAccess.getMes(connexion,formapagopuntoventa));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(formapagopuntoventa.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagopuntoventa.setAnio(formapagopuntoventaDataAccess.getAnio(connexion,formapagopuntoventa));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(formapagopuntoventa.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagopuntoventa.setCuentaContable(formapagopuntoventaDataAccess.getCuentaContable(connexion,formapagopuntoventa));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(formapagopuntoventa.getCuentaContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(AsientoContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			formapagopuntoventa.setAsientoContable(formapagopuntoventaDataAccess.getAsientoContable(connexion,formapagopuntoventa));
			AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
			asientocontableLogic.deepLoad(formapagopuntoventa.getAsientoContable(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(FormaPagoPuntoVenta formapagopuntoventa,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			FormaPagoPuntoVentaLogicAdditional.updateFormaPagoPuntoVentaToSave(formapagopuntoventa,this.arrDatoGeneral);
			
FormaPagoPuntoVentaDataAccess.save(formapagopuntoventa, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(formapagopuntoventa.getEmpresa(),connexion);

		SucursalDataAccess.save(formapagopuntoventa.getSucursal(),connexion);

		EjercicioDataAccess.save(formapagopuntoventa.getEjercicio(),connexion);

		PeriodoDataAccess.save(formapagopuntoventa.getPeriodo(),connexion);

		FacturaPuntoVentaDataAccess.save(formapagopuntoventa.getFacturaPuntoVenta(),connexion);

		TipoFormaPagoDataAccess.save(formapagopuntoventa.getTipoFormaPago(),connexion);

		BancoDataAccess.save(formapagopuntoventa.getBanco(),connexion);

		CuentaBancoPunVenDataAccess.save(formapagopuntoventa.getCuentaBancoPunVen(),connexion);

		TipoRiesgoChequeDataAccess.save(formapagopuntoventa.getTipoRiesgoCheque(),connexion);

		BancoDataAccess.save(formapagopuntoventa.getBancoTarjeta(),connexion);

		TarjetaCreditoDataAccess.save(formapagopuntoventa.getTarjetaCredito(),connexion);

		TipoInteresTarjetaDataAccess.save(formapagopuntoventa.getTipoInteresTarjeta(),connexion);

		TipoPagoTarjetaDataAccess.save(formapagopuntoventa.getTipoPagoTarjeta(),connexion);

		ConexionDataAccess.save(formapagopuntoventa.getConexion(),connexion);

		MesDataAccess.save(formapagopuntoventa.getMes(),connexion);

		AnioDataAccess.save(formapagopuntoventa.getAnio(),connexion);

		CuentaContableDataAccess.save(formapagopuntoventa.getCuentaContable(),connexion);

		AsientoContableDataAccess.save(formapagopuntoventa.getAsientoContable(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(formapagopuntoventa.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(formapagopuntoventa.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(formapagopuntoventa.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(formapagopuntoventa.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(FacturaPuntoVenta.class)) {
				FacturaPuntoVentaDataAccess.save(formapagopuntoventa.getFacturaPuntoVenta(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoFormaPago.class)) {
				TipoFormaPagoDataAccess.save(formapagopuntoventa.getTipoFormaPago(),connexion);
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				BancoDataAccess.save(formapagopuntoventa.getBanco(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaBancoPunVen.class)) {
				CuentaBancoPunVenDataAccess.save(formapagopuntoventa.getCuentaBancoPunVen(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoRiesgoCheque.class)) {
				TipoRiesgoChequeDataAccess.save(formapagopuntoventa.getTipoRiesgoCheque(),connexion);
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				BancoDataAccess.save(formapagopuntoventa.getBancoTarjeta(),connexion);
				continue;
			}

			if(clas.clas.equals(TarjetaCredito.class)) {
				TarjetaCreditoDataAccess.save(formapagopuntoventa.getTarjetaCredito(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoInteresTarjeta.class)) {
				TipoInteresTarjetaDataAccess.save(formapagopuntoventa.getTipoInteresTarjeta(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoPagoTarjeta.class)) {
				TipoPagoTarjetaDataAccess.save(formapagopuntoventa.getTipoPagoTarjeta(),connexion);
				continue;
			}

			if(clas.clas.equals(Conexion.class)) {
				ConexionDataAccess.save(formapagopuntoventa.getConexion(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(formapagopuntoventa.getMes(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(formapagopuntoventa.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(formapagopuntoventa.getCuentaContable(),connexion);
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(formapagopuntoventa.getAsientoContable(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(formapagopuntoventa.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(formapagopuntoventa.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(formapagopuntoventa.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(formapagopuntoventa.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(formapagopuntoventa.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(formapagopuntoventa.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(formapagopuntoventa.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(formapagopuntoventa.getPeriodo(),isDeep,deepLoadType,clases);
				

		FacturaPuntoVentaDataAccess.save(formapagopuntoventa.getFacturaPuntoVenta(),connexion);
		FacturaPuntoVentaLogic facturapuntoventaLogic= new FacturaPuntoVentaLogic(connexion);
		facturapuntoventaLogic.deepLoad(formapagopuntoventa.getFacturaPuntoVenta(),isDeep,deepLoadType,clases);
				

		TipoFormaPagoDataAccess.save(formapagopuntoventa.getTipoFormaPago(),connexion);
		TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
		tipoformapagoLogic.deepLoad(formapagopuntoventa.getTipoFormaPago(),isDeep,deepLoadType,clases);
				

		BancoDataAccess.save(formapagopuntoventa.getBanco(),connexion);
		BancoLogic bancoLogic= new BancoLogic(connexion);
		bancoLogic.deepLoad(formapagopuntoventa.getBanco(),isDeep,deepLoadType,clases);
				

		CuentaBancoPunVenDataAccess.save(formapagopuntoventa.getCuentaBancoPunVen(),connexion);
		CuentaBancoPunVenLogic cuentabancopunvenLogic= new CuentaBancoPunVenLogic(connexion);
		cuentabancopunvenLogic.deepLoad(formapagopuntoventa.getCuentaBancoPunVen(),isDeep,deepLoadType,clases);
				

		TipoRiesgoChequeDataAccess.save(formapagopuntoventa.getTipoRiesgoCheque(),connexion);
		TipoRiesgoChequeLogic tiporiesgochequeLogic= new TipoRiesgoChequeLogic(connexion);
		tiporiesgochequeLogic.deepLoad(formapagopuntoventa.getTipoRiesgoCheque(),isDeep,deepLoadType,clases);
				

		BancoDataAccess.save(formapagopuntoventa.getBancoTarjeta(),connexion);
		BancoLogic bancotarjetaLogic= new BancoLogic(connexion);
		bancotarjetaLogic.deepLoad(formapagopuntoventa.getBancoTarjeta(),isDeep,deepLoadType,clases);
				

		TarjetaCreditoDataAccess.save(formapagopuntoventa.getTarjetaCredito(),connexion);
		TarjetaCreditoLogic tarjetacreditoLogic= new TarjetaCreditoLogic(connexion);
		tarjetacreditoLogic.deepLoad(formapagopuntoventa.getTarjetaCredito(),isDeep,deepLoadType,clases);
				

		TipoInteresTarjetaDataAccess.save(formapagopuntoventa.getTipoInteresTarjeta(),connexion);
		TipoInteresTarjetaLogic tipointerestarjetaLogic= new TipoInteresTarjetaLogic(connexion);
		tipointerestarjetaLogic.deepLoad(formapagopuntoventa.getTipoInteresTarjeta(),isDeep,deepLoadType,clases);
				

		TipoPagoTarjetaDataAccess.save(formapagopuntoventa.getTipoPagoTarjeta(),connexion);
		TipoPagoTarjetaLogic tipopagotarjetaLogic= new TipoPagoTarjetaLogic(connexion);
		tipopagotarjetaLogic.deepLoad(formapagopuntoventa.getTipoPagoTarjeta(),isDeep,deepLoadType,clases);
				

		ConexionDataAccess.save(formapagopuntoventa.getConexion(),connexion);
		ConexionLogic conexionLogic= new ConexionLogic(connexion);
		conexionLogic.deepLoad(formapagopuntoventa.getConexion(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(formapagopuntoventa.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(formapagopuntoventa.getMes(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(formapagopuntoventa.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(formapagopuntoventa.getAnio(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(formapagopuntoventa.getCuentaContable(),connexion);
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(formapagopuntoventa.getCuentaContable(),isDeep,deepLoadType,clases);
				

		AsientoContableDataAccess.save(formapagopuntoventa.getAsientoContable(),connexion);
		AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
		asientocontableLogic.deepLoad(formapagopuntoventa.getAsientoContable(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(formapagopuntoventa.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(formapagopuntoventa.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(formapagopuntoventa.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(formapagopuntoventa.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(formapagopuntoventa.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(formapagopuntoventa.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(formapagopuntoventa.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(formapagopuntoventa.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(FacturaPuntoVenta.class)) {
				FacturaPuntoVentaDataAccess.save(formapagopuntoventa.getFacturaPuntoVenta(),connexion);
				FacturaPuntoVentaLogic facturapuntoventaLogic= new FacturaPuntoVentaLogic(connexion);
				facturapuntoventaLogic.deepSave(formapagopuntoventa.getFacturaPuntoVenta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoFormaPago.class)) {
				TipoFormaPagoDataAccess.save(formapagopuntoventa.getTipoFormaPago(),connexion);
				TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
				tipoformapagoLogic.deepSave(formapagopuntoventa.getTipoFormaPago(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				BancoDataAccess.save(formapagopuntoventa.getBanco(),connexion);
				BancoLogic bancoLogic= new BancoLogic(connexion);
				bancoLogic.deepSave(formapagopuntoventa.getBanco(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaBancoPunVen.class)) {
				CuentaBancoPunVenDataAccess.save(formapagopuntoventa.getCuentaBancoPunVen(),connexion);
				CuentaBancoPunVenLogic cuentabancopunvenLogic= new CuentaBancoPunVenLogic(connexion);
				cuentabancopunvenLogic.deepSave(formapagopuntoventa.getCuentaBancoPunVen(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRiesgoCheque.class)) {
				TipoRiesgoChequeDataAccess.save(formapagopuntoventa.getTipoRiesgoCheque(),connexion);
				TipoRiesgoChequeLogic tiporiesgochequeLogic= new TipoRiesgoChequeLogic(connexion);
				tiporiesgochequeLogic.deepSave(formapagopuntoventa.getTipoRiesgoCheque(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Banco.class)) {
				BancoDataAccess.save(formapagopuntoventa.getBancoTarjeta(),connexion);
				BancoLogic bancoLogic= new BancoLogic(connexion);
				bancoLogic.deepSave(formapagopuntoventa.getBancoTarjeta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TarjetaCredito.class)) {
				TarjetaCreditoDataAccess.save(formapagopuntoventa.getTarjetaCredito(),connexion);
				TarjetaCreditoLogic tarjetacreditoLogic= new TarjetaCreditoLogic(connexion);
				tarjetacreditoLogic.deepSave(formapagopuntoventa.getTarjetaCredito(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoInteresTarjeta.class)) {
				TipoInteresTarjetaDataAccess.save(formapagopuntoventa.getTipoInteresTarjeta(),connexion);
				TipoInteresTarjetaLogic tipointerestarjetaLogic= new TipoInteresTarjetaLogic(connexion);
				tipointerestarjetaLogic.deepSave(formapagopuntoventa.getTipoInteresTarjeta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoPagoTarjeta.class)) {
				TipoPagoTarjetaDataAccess.save(formapagopuntoventa.getTipoPagoTarjeta(),connexion);
				TipoPagoTarjetaLogic tipopagotarjetaLogic= new TipoPagoTarjetaLogic(connexion);
				tipopagotarjetaLogic.deepSave(formapagopuntoventa.getTipoPagoTarjeta(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Conexion.class)) {
				ConexionDataAccess.save(formapagopuntoventa.getConexion(),connexion);
				ConexionLogic conexionLogic= new ConexionLogic(connexion);
				conexionLogic.deepSave(formapagopuntoventa.getConexion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(formapagopuntoventa.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(formapagopuntoventa.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(formapagopuntoventa.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(formapagopuntoventa.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(formapagopuntoventa.getCuentaContable(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(formapagopuntoventa.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(AsientoContable.class)) {
				AsientoContableDataAccess.save(formapagopuntoventa.getAsientoContable(),connexion);
				AsientoContableLogic asientocontableLogic= new AsientoContableLogic(connexion);
				asientocontableLogic.deepSave(formapagopuntoventa.getAsientoContable(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(FormaPagoPuntoVenta.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(formapagopuntoventa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(formapagopuntoventa);
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
			this.deepLoad(this.formapagopuntoventa,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventa);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(FormaPagoPuntoVenta.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(formapagopuntoventas!=null) {
				for(FormaPagoPuntoVenta formapagopuntoventa:formapagopuntoventas) {
					this.deepLoad(formapagopuntoventa,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(formapagopuntoventas);
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
			if(formapagopuntoventas!=null) {
				for(FormaPagoPuntoVenta formapagopuntoventa:formapagopuntoventas) {
					this.deepLoad(formapagopuntoventa,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(formapagopuntoventas);
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
			this.getNewConnexionToDeep(FormaPagoPuntoVenta.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(formapagopuntoventa,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(FormaPagoPuntoVenta.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(formapagopuntoventas!=null) {
				for(FormaPagoPuntoVenta formapagopuntoventa:formapagopuntoventas) {
					this.deepSave(formapagopuntoventa,isDeep,deepLoadType,clases);
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
			if(formapagopuntoventas!=null) {
				for(FormaPagoPuntoVenta formapagopuntoventa:formapagopuntoventas) {
					this.deepSave(formapagopuntoventa,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getFormaPagoPuntoVentasFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,FormaPagoPuntoVentaConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagoPuntoVentasFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,FormaPagoPuntoVentaConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormaPagoPuntoVentasFK_IdAsientoContableWithConnection(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,FormaPagoPuntoVentaConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagoPuntoVentasFK_IdAsientoContable(String sFinalQuery,Pagination pagination,Long id_asiento_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAsientoContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAsientoContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_asiento_contable,FormaPagoPuntoVentaConstantesFunciones.IDASIENTOCONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAsientoContable);

			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAsientoContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormaPagoPuntoVentasFK_IdBancoWithConnection(String sFinalQuery,Pagination pagination,Long id_banco)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_banco,FormaPagoPuntoVentaConstantesFunciones.IDBANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBanco);

			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagoPuntoVentasFK_IdBanco(String sFinalQuery,Pagination pagination,Long id_banco)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBanco= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBanco.setParameterSelectionGeneralEqual(ParameterType.LONG,id_banco,FormaPagoPuntoVentaConstantesFunciones.IDBANCO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBanco);

			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBanco","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormaPagoPuntoVentasFK_IdBancoTarjetaWithConnection(String sFinalQuery,Pagination pagination,Long id_banco_tarjeta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBancoTarjeta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBancoTarjeta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_banco_tarjeta,FormaPagoPuntoVentaConstantesFunciones.IDBANCOTARJETA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBancoTarjeta);

			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBancoTarjeta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagoPuntoVentasFK_IdBancoTarjeta(String sFinalQuery,Pagination pagination,Long id_banco_tarjeta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidBancoTarjeta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidBancoTarjeta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_banco_tarjeta,FormaPagoPuntoVentaConstantesFunciones.IDBANCOTARJETA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidBancoTarjeta);

			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdBancoTarjeta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormaPagoPuntoVentasFK_IdConexionWithConnection(String sFinalQuery,Pagination pagination,Long id_conexion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidConexion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidConexion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_conexion,FormaPagoPuntoVentaConstantesFunciones.IDCONEXION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidConexion);

			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdConexion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagoPuntoVentasFK_IdConexion(String sFinalQuery,Pagination pagination,Long id_conexion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidConexion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidConexion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_conexion,FormaPagoPuntoVentaConstantesFunciones.IDCONEXION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidConexion);

			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdConexion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormaPagoPuntoVentasFK_IdCuentaBancoPunVenWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_banco_pun_ven)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaBancoPunVen= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaBancoPunVen.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_banco_pun_ven,FormaPagoPuntoVentaConstantesFunciones.IDCUENTABANCOPUNVEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaBancoPunVen);

			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaBancoPunVen","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagoPuntoVentasFK_IdCuentaBancoPunVen(String sFinalQuery,Pagination pagination,Long id_cuenta_banco_pun_ven)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaBancoPunVen= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaBancoPunVen.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_banco_pun_ven,FormaPagoPuntoVentaConstantesFunciones.IDCUENTABANCOPUNVEN,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaBancoPunVen);

			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaBancoPunVen","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormaPagoPuntoVentasFK_IdCuentaContableWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,FormaPagoPuntoVentaConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagoPuntoVentasFK_IdCuentaContable(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,FormaPagoPuntoVentaConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormaPagoPuntoVentasFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,FormaPagoPuntoVentaConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagoPuntoVentasFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,FormaPagoPuntoVentaConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormaPagoPuntoVentasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FormaPagoPuntoVentaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagoPuntoVentasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,FormaPagoPuntoVentaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormaPagoPuntoVentasFK_IdFacturaPuntoVentaWithConnection(String sFinalQuery,Pagination pagination,Long id_factura_punto_venta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFacturaPuntoVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFacturaPuntoVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura_punto_venta,FormaPagoPuntoVentaConstantesFunciones.IDFACTURAPUNTOVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFacturaPuntoVenta);

			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFacturaPuntoVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagoPuntoVentasFK_IdFacturaPuntoVenta(String sFinalQuery,Pagination pagination,Long id_factura_punto_venta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFacturaPuntoVenta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFacturaPuntoVenta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura_punto_venta,FormaPagoPuntoVentaConstantesFunciones.IDFACTURAPUNTOVENTA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFacturaPuntoVenta);

			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFacturaPuntoVenta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormaPagoPuntoVentasFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,FormaPagoPuntoVentaConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagoPuntoVentasFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,FormaPagoPuntoVentaConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormaPagoPuntoVentasFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,FormaPagoPuntoVentaConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagoPuntoVentasFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,FormaPagoPuntoVentaConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormaPagoPuntoVentasFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,FormaPagoPuntoVentaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagoPuntoVentasFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,FormaPagoPuntoVentaConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormaPagoPuntoVentasFK_IdTarjetaCreditoWithConnection(String sFinalQuery,Pagination pagination,Long id_tarjeta_credito)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTarjetaCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTarjetaCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tarjeta_credito,FormaPagoPuntoVentaConstantesFunciones.IDTARJETACREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTarjetaCredito);

			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTarjetaCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagoPuntoVentasFK_IdTarjetaCredito(String sFinalQuery,Pagination pagination,Long id_tarjeta_credito)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTarjetaCredito= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTarjetaCredito.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tarjeta_credito,FormaPagoPuntoVentaConstantesFunciones.IDTARJETACREDITO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTarjetaCredito);

			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTarjetaCredito","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormaPagoPuntoVentasFK_IdTipoFormaPagoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_forma_pago)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoFormaPago= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoFormaPago.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_forma_pago,FormaPagoPuntoVentaConstantesFunciones.IDTIPOFORMAPAGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoFormaPago);

			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoFormaPago","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagoPuntoVentasFK_IdTipoFormaPago(String sFinalQuery,Pagination pagination,Long id_tipo_forma_pago)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoFormaPago= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoFormaPago.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_forma_pago,FormaPagoPuntoVentaConstantesFunciones.IDTIPOFORMAPAGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoFormaPago);

			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoFormaPago","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormaPagoPuntoVentasFK_IdTipoInteresTarjetaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_interes_tarjeta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoInteresTarjeta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoInteresTarjeta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_interes_tarjeta,FormaPagoPuntoVentaConstantesFunciones.IDTIPOINTERESTARJETA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoInteresTarjeta);

			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoInteresTarjeta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagoPuntoVentasFK_IdTipoInteresTarjeta(String sFinalQuery,Pagination pagination,Long id_tipo_interes_tarjeta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoInteresTarjeta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoInteresTarjeta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_interes_tarjeta,FormaPagoPuntoVentaConstantesFunciones.IDTIPOINTERESTARJETA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoInteresTarjeta);

			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoInteresTarjeta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormaPagoPuntoVentasFK_IdTipoPagoTarjetaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_pago_tarjeta)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPagoTarjeta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPagoTarjeta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_pago_tarjeta,FormaPagoPuntoVentaConstantesFunciones.IDTIPOPAGOTARJETA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPagoTarjeta);

			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPagoTarjeta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagoPuntoVentasFK_IdTipoPagoTarjeta(String sFinalQuery,Pagination pagination,Long id_tipo_pago_tarjeta)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoPagoTarjeta= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoPagoTarjeta.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_pago_tarjeta,FormaPagoPuntoVentaConstantesFunciones.IDTIPOPAGOTARJETA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoPagoTarjeta);

			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoPagoTarjeta","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getFormaPagoPuntoVentasFK_IdTipoRiesgoChequeWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_riesgo_cheque)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,FormaPagoPuntoVenta.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRiesgoCheque= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRiesgoCheque.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_riesgo_cheque,FormaPagoPuntoVentaConstantesFunciones.IDTIPORIESGOCHEQUE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRiesgoCheque);

			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRiesgoCheque","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getFormaPagoPuntoVentasFK_IdTipoRiesgoCheque(String sFinalQuery,Pagination pagination,Long id_tipo_riesgo_cheque)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRiesgoCheque= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRiesgoCheque.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_riesgo_cheque,FormaPagoPuntoVentaConstantesFunciones.IDTIPORIESGOCHEQUE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRiesgoCheque);

			FormaPagoPuntoVentaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRiesgoCheque","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			formapagopuntoventas=formapagopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				FormaPagoPuntoVentaConstantesFunciones.refrescarForeignKeysDescripcionesFormaPagoPuntoVenta(this.formapagopuntoventas);
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
			if(FormaPagoPuntoVentaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,FormaPagoPuntoVentaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,FormaPagoPuntoVenta formapagopuntoventa,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(FormaPagoPuntoVentaConstantesFunciones.ISCONAUDITORIA) {
				if(formapagopuntoventa.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FormaPagoPuntoVentaDataAccess.TABLENAME, formapagopuntoventa.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FormaPagoPuntoVentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FormaPagoPuntoVentaLogic.registrarAuditoriaDetallesFormaPagoPuntoVenta(connexion,formapagopuntoventa,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(formapagopuntoventa.getIsDeleted()) {
					/*if(!formapagopuntoventa.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,FormaPagoPuntoVentaDataAccess.TABLENAME, formapagopuntoventa.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////FormaPagoPuntoVentaLogic.registrarAuditoriaDetallesFormaPagoPuntoVenta(connexion,formapagopuntoventa,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FormaPagoPuntoVentaDataAccess.TABLENAME, formapagopuntoventa.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(formapagopuntoventa.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,FormaPagoPuntoVentaDataAccess.TABLENAME, formapagopuntoventa.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(FormaPagoPuntoVentaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////FormaPagoPuntoVentaLogic.registrarAuditoriaDetallesFormaPagoPuntoVenta(connexion,formapagopuntoventa,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesFormaPagoPuntoVenta(Connexion connexion,FormaPagoPuntoVenta formapagopuntoventa)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.getid_empresa().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_empresa()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_empresa().toString();
				}
				if(formapagopuntoventa.getid_empresa()!=null)
				{
					strValorNuevo=formapagopuntoventa.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.getid_sucursal().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_sucursal()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_sucursal().toString();
				}
				if(formapagopuntoventa.getid_sucursal()!=null)
				{
					strValorNuevo=formapagopuntoventa.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.getid_ejercicio().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_ejercicio()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_ejercicio().toString();
				}
				if(formapagopuntoventa.getid_ejercicio()!=null)
				{
					strValorNuevo=formapagopuntoventa.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.getid_periodo().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_periodo()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_periodo().toString();
				}
				if(formapagopuntoventa.getid_periodo()!=null)
				{
					strValorNuevo=formapagopuntoventa.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.getid_factura_punto_venta().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_factura_punto_venta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_factura_punto_venta()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_factura_punto_venta().toString();
				}
				if(formapagopuntoventa.getid_factura_punto_venta()!=null)
				{
					strValorNuevo=formapagopuntoventa.getid_factura_punto_venta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.IDFACTURAPUNTOVENTA,strValorActual,strValorNuevo);
			}	
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.getid_tipo_forma_pago().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_tipo_forma_pago()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_tipo_forma_pago()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_tipo_forma_pago().toString();
				}
				if(formapagopuntoventa.getid_tipo_forma_pago()!=null)
				{
					strValorNuevo=formapagopuntoventa.getid_tipo_forma_pago().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.IDTIPOFORMAPAGO,strValorActual,strValorNuevo);
			}	
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.getporcentaje().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getporcentaje()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getporcentaje().toString();
				}
				if(formapagopuntoventa.getporcentaje()!=null)
				{
					strValorNuevo=formapagopuntoventa.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.getvalor().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getvalor()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getvalor().toString();
				}
				if(formapagopuntoventa.getvalor()!=null)
				{
					strValorNuevo=formapagopuntoventa.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.getfecha().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getfecha()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getfecha().toString();
				}
				if(formapagopuntoventa.getfecha()!=null)
				{
					strValorNuevo=formapagopuntoventa.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.getdescripcion().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getdescripcion()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getdescripcion();
				}
				if(formapagopuntoventa.getdescripcion()!=null)
				{
					strValorNuevo=formapagopuntoventa.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.getfecha_inicio().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getfecha_inicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getfecha_inicio()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getfecha_inicio().toString();
				}
				if(formapagopuntoventa.getfecha_inicio()!=null)
				{
					strValorNuevo=formapagopuntoventa.getfecha_inicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.FECHAINICIO,strValorActual,strValorNuevo);
			}	
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.getnumero_dias_plazo().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getnumero_dias_plazo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getnumero_dias_plazo()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getnumero_dias_plazo().toString();
				}
				if(formapagopuntoventa.getnumero_dias_plazo()!=null)
				{
					strValorNuevo=formapagopuntoventa.getnumero_dias_plazo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.NUMERODIASPLAZO,strValorActual,strValorNuevo);
			}	
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.getfecha_fin().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getfecha_fin()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getfecha_fin()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getfecha_fin().toString();
				}
				if(formapagopuntoventa.getfecha_fin()!=null)
				{
					strValorNuevo=formapagopuntoventa.getfecha_fin().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.FECHAFIN,strValorActual,strValorNuevo);
			}	
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.getid_banco().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_banco()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_banco()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_banco().toString();
				}
				if(formapagopuntoventa.getid_banco()!=null)
				{
					strValorNuevo=formapagopuntoventa.getid_banco().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.IDBANCO,strValorActual,strValorNuevo);
			}	
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.getid_cuenta_banco_pun_ven().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_cuenta_banco_pun_ven()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_cuenta_banco_pun_ven()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_cuenta_banco_pun_ven().toString();
				}
				if(formapagopuntoventa.getid_cuenta_banco_pun_ven()!=null)
				{
					strValorNuevo=formapagopuntoventa.getid_cuenta_banco_pun_ven().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.IDCUENTABANCOPUNVEN,strValorActual,strValorNuevo);
			}	
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.getid_tipo_riesgo_cheque().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_tipo_riesgo_cheque()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_tipo_riesgo_cheque()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_tipo_riesgo_cheque().toString();
				}
				if(formapagopuntoventa.getid_tipo_riesgo_cheque()!=null)
				{
					strValorNuevo=formapagopuntoventa.getid_tipo_riesgo_cheque().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.IDTIPORIESGOCHEQUE,strValorActual,strValorNuevo);
			}	
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.getnumero_cuenta().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getnumero_cuenta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getnumero_cuenta()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getnumero_cuenta();
				}
				if(formapagopuntoventa.getnumero_cuenta()!=null)
				{
					strValorNuevo=formapagopuntoventa.getnumero_cuenta() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.NUMEROCUENTA,strValorActual,strValorNuevo);
			}	
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.getnumero_cheque().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getnumero_cheque()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getnumero_cheque()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getnumero_cheque();
				}
				if(formapagopuntoventa.getnumero_cheque()!=null)
				{
					strValorNuevo=formapagopuntoventa.getnumero_cheque() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.NUMEROCHEQUE,strValorActual,strValorNuevo);
			}	
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.getgirador().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getgirador()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getgirador()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getgirador();
				}
				if(formapagopuntoventa.getgirador()!=null)
				{
					strValorNuevo=formapagopuntoventa.getgirador() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.GIRADOR,strValorActual,strValorNuevo);
			}	
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.getid_banco_tarjeta().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_banco_tarjeta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_banco_tarjeta()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_banco_tarjeta().toString();
				}
				if(formapagopuntoventa.getid_banco_tarjeta()!=null)
				{
					strValorNuevo=formapagopuntoventa.getid_banco_tarjeta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.IDBANCOTARJETA,strValorActual,strValorNuevo);
			}	
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.getid_tarjeta_credito().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_tarjeta_credito()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_tarjeta_credito()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_tarjeta_credito().toString();
				}
				if(formapagopuntoventa.getid_tarjeta_credito()!=null)
				{
					strValorNuevo=formapagopuntoventa.getid_tarjeta_credito().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.IDTARJETACREDITO,strValorActual,strValorNuevo);
			}	
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.getid_tipo_interes_tarjeta().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_tipo_interes_tarjeta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_tipo_interes_tarjeta()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_tipo_interes_tarjeta().toString();
				}
				if(formapagopuntoventa.getid_tipo_interes_tarjeta()!=null)
				{
					strValorNuevo=formapagopuntoventa.getid_tipo_interes_tarjeta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.IDTIPOINTERESTARJETA,strValorActual,strValorNuevo);
			}	
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.getid_tipo_pago_tarjeta().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_tipo_pago_tarjeta()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_tipo_pago_tarjeta()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_tipo_pago_tarjeta().toString();
				}
				if(formapagopuntoventa.getid_tipo_pago_tarjeta()!=null)
				{
					strValorNuevo=formapagopuntoventa.getid_tipo_pago_tarjeta().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.IDTIPOPAGOTARJETA,strValorActual,strValorNuevo);
			}	
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.getid_conexion().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_conexion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_conexion()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_conexion().toString();
				}
				if(formapagopuntoventa.getid_conexion()!=null)
				{
					strValorNuevo=formapagopuntoventa.getid_conexion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.IDCONEXION,strValorActual,strValorNuevo);
			}	
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.getid_mes().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_mes()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_mes().toString();
				}
				if(formapagopuntoventa.getid_mes()!=null)
				{
					strValorNuevo=formapagopuntoventa.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.getnumero().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getnumero()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getnumero()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getnumero();
				}
				if(formapagopuntoventa.getnumero()!=null)
				{
					strValorNuevo=formapagopuntoventa.getnumero() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.NUMERO,strValorActual,strValorNuevo);
			}	
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.gettarjeta_habiente().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().gettarjeta_habiente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().gettarjeta_habiente()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().gettarjeta_habiente();
				}
				if(formapagopuntoventa.gettarjeta_habiente()!=null)
				{
					strValorNuevo=formapagopuntoventa.gettarjeta_habiente() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.TARJETAHABIENTE,strValorActual,strValorNuevo);
			}	
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.getautorizacion().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getautorizacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getautorizacion()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getautorizacion();
				}
				if(formapagopuntoventa.getautorizacion()!=null)
				{
					strValorNuevo=formapagopuntoventa.getautorizacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.AUTORIZACION,strValorActual,strValorNuevo);
			}	
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.getvoucher().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getvoucher()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getvoucher()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getvoucher();
				}
				if(formapagopuntoventa.getvoucher()!=null)
				{
					strValorNuevo=formapagopuntoventa.getvoucher() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.VOUCHER,strValorActual,strValorNuevo);
			}	
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.getlote().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getlote()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getlote()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getlote();
				}
				if(formapagopuntoventa.getlote()!=null)
				{
					strValorNuevo=formapagopuntoventa.getlote() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.LOTE,strValorActual,strValorNuevo);
			}	
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.getcuota().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getcuota()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getcuota()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getcuota().toString();
				}
				if(formapagopuntoventa.getcuota()!=null)
				{
					strValorNuevo=formapagopuntoventa.getcuota().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.CUOTA,strValorActual,strValorNuevo);
			}	
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.getvalor_retencion().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getvalor_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getvalor_retencion()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getvalor_retencion().toString();
				}
				if(formapagopuntoventa.getvalor_retencion()!=null)
				{
					strValorNuevo=formapagopuntoventa.getvalor_retencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.VALORRETENCION,strValorActual,strValorNuevo);
			}	
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.getvalor_comision().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getvalor_comision()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getvalor_comision()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getvalor_comision().toString();
				}
				if(formapagopuntoventa.getvalor_comision()!=null)
				{
					strValorNuevo=formapagopuntoventa.getvalor_comision().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.VALORCOMISION,strValorActual,strValorNuevo);
			}	
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.getvalor_calculado().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getvalor_calculado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getvalor_calculado()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getvalor_calculado().toString();
				}
				if(formapagopuntoventa.getvalor_calculado()!=null)
				{
					strValorNuevo=formapagopuntoventa.getvalor_calculado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.VALORCALCULADO,strValorActual,strValorNuevo);
			}	
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.getvalor_cancelado().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getvalor_cancelado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getvalor_cancelado()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getvalor_cancelado().toString();
				}
				if(formapagopuntoventa.getvalor_cancelado()!=null)
				{
					strValorNuevo=formapagopuntoventa.getvalor_cancelado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.VALORCANCELADO,strValorActual,strValorNuevo);
			}	
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.getvalor_difiere().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getvalor_difiere()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getvalor_difiere()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getvalor_difiere().toString();
				}
				if(formapagopuntoventa.getvalor_difiere()!=null)
				{
					strValorNuevo=formapagopuntoventa.getvalor_difiere().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.VALORDIFIERE,strValorActual,strValorNuevo);
			}	
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.getnumero_retencion().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getnumero_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getnumero_retencion()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getnumero_retencion();
				}
				if(formapagopuntoventa.getnumero_retencion()!=null)
				{
					strValorNuevo=formapagopuntoventa.getnumero_retencion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.NUMERORETENCION,strValorActual,strValorNuevo);
			}	
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.getnumero_liquidacion().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getnumero_liquidacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getnumero_liquidacion()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getnumero_liquidacion();
				}
				if(formapagopuntoventa.getnumero_liquidacion()!=null)
				{
					strValorNuevo=formapagopuntoventa.getnumero_liquidacion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.NUMEROLIQUIDACION,strValorActual,strValorNuevo);
			}	
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.getid_anio().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_anio()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_anio().toString();
				}
				if(formapagopuntoventa.getid_anio()!=null)
				{
					strValorNuevo=formapagopuntoventa.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.getid_cuenta_contable().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_cuenta_contable()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_cuenta_contable().toString();
				}
				if(formapagopuntoventa.getid_cuenta_contable()!=null)
				{
					strValorNuevo=formapagopuntoventa.getid_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.IDCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(formapagopuntoventa.getIsNew()||!formapagopuntoventa.getid_asiento_contable().equals(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_asiento_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_asiento_contable()!=null)
				{
					strValorActual=formapagopuntoventa.getFormaPagoPuntoVentaOriginal().getid_asiento_contable().toString();
				}
				if(formapagopuntoventa.getid_asiento_contable()!=null)
				{
					strValorNuevo=formapagopuntoventa.getid_asiento_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),FormaPagoPuntoVentaConstantesFunciones.IDASIENTOCONTABLE,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveFormaPagoPuntoVentaRelacionesWithConnection(FormaPagoPuntoVenta formapagopuntoventa) throws Exception {

		if(!formapagopuntoventa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFormaPagoPuntoVentaRelacionesBase(formapagopuntoventa,true);
		}
	}

	public void saveFormaPagoPuntoVentaRelaciones(FormaPagoPuntoVenta formapagopuntoventa)throws Exception {

		if(!formapagopuntoventa.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveFormaPagoPuntoVentaRelacionesBase(formapagopuntoventa,false);
		}
	}

	public void saveFormaPagoPuntoVentaRelacionesBase(FormaPagoPuntoVenta formapagopuntoventa,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("FormaPagoPuntoVenta-saveRelacionesWithConnection");}
	

			this.setFormaPagoPuntoVenta(formapagopuntoventa);

			if(FormaPagoPuntoVentaLogicAdditional.validarSaveRelaciones(formapagopuntoventa,this)) {

				FormaPagoPuntoVentaLogicAdditional.updateRelacionesToSave(formapagopuntoventa,this);

				if((formapagopuntoventa.getIsNew()||formapagopuntoventa.getIsChanged())&&!formapagopuntoventa.getIsDeleted()) {
					this.saveFormaPagoPuntoVenta();
					this.saveFormaPagoPuntoVentaRelacionesDetalles();

				} else if(formapagopuntoventa.getIsDeleted()) {
					this.saveFormaPagoPuntoVentaRelacionesDetalles();
					this.saveFormaPagoPuntoVenta();
				}

				FormaPagoPuntoVentaLogicAdditional.updateRelacionesToSaveAfter(formapagopuntoventa,this);

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
	
	
	private void saveFormaPagoPuntoVentaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfFormaPagoPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FormaPagoPuntoVentaConstantesFunciones.getClassesForeignKeysOfFormaPagoPuntoVenta(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfFormaPagoPuntoVenta(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=FormaPagoPuntoVentaConstantesFunciones.getClassesRelationshipsOfFormaPagoPuntoVenta(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}

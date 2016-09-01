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
package com.bydan.erp.facturacion.business.logic;

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
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.facturacion.util.DetaFormaPagoConstantesFunciones;
import com.bydan.erp.facturacion.util.DetaFormaPagoParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.DetaFormaPagoParameterGeneral;
import com.bydan.erp.facturacion.business.entity.DetaFormaPago;
import com.bydan.erp.facturacion.business.logic.DetaFormaPagoLogicAdditional;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.facturacion.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.tesoreria.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.tesoreria.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;








@SuppressWarnings("unused")
public class DetaFormaPagoLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(DetaFormaPagoLogic.class);
	
	protected DetaFormaPagoDataAccess detaformapagoDataAccess; 	
	protected DetaFormaPago detaformapago;
	protected List<DetaFormaPago> detaformapagos;
	protected Object detaformapagoObject;	
	protected List<Object> detaformapagosObject;
	
	public static ClassValidator<DetaFormaPago> detaformapagoValidator = new ClassValidator<DetaFormaPago>(DetaFormaPago.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected DetaFormaPagoLogicAdditional detaformapagoLogicAdditional=null;
	
	public DetaFormaPagoLogicAdditional getDetaFormaPagoLogicAdditional() {
		return this.detaformapagoLogicAdditional;
	}
	
	public void setDetaFormaPagoLogicAdditional(DetaFormaPagoLogicAdditional detaformapagoLogicAdditional) {
		try {
			this.detaformapagoLogicAdditional=detaformapagoLogicAdditional;
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
	
	
	
	
	public  DetaFormaPagoLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.detaformapagoDataAccess = new DetaFormaPagoDataAccess();
			
			this.detaformapagos= new ArrayList<DetaFormaPago>();
			this.detaformapago= new DetaFormaPago();
			
			this.detaformapagoObject=new Object();
			this.detaformapagosObject=new ArrayList<Object>();
				
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
			
			this.detaformapagoDataAccess.setConnexionType(this.connexionType);
			this.detaformapagoDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  DetaFormaPagoLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.detaformapagoDataAccess = new DetaFormaPagoDataAccess();
			this.detaformapagos= new ArrayList<DetaFormaPago>();
			this.detaformapago= new DetaFormaPago();
			this.detaformapagoObject=new Object();
			this.detaformapagosObject=new ArrayList<Object>();
			
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
			
			this.detaformapagoDataAccess.setConnexionType(this.connexionType);
			this.detaformapagoDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public DetaFormaPago getDetaFormaPago() throws Exception {	
		DetaFormaPagoLogicAdditional.checkDetaFormaPagoToGet(detaformapago,this.datosCliente,this.arrDatoGeneral);
		DetaFormaPagoLogicAdditional.updateDetaFormaPagoToGet(detaformapago,this.arrDatoGeneral);
		
		return detaformapago;
	}
		
	public void setDetaFormaPago(DetaFormaPago newDetaFormaPago) {
		this.detaformapago = newDetaFormaPago;
	}
	
	public DetaFormaPagoDataAccess getDetaFormaPagoDataAccess() {
		return detaformapagoDataAccess;
	}
	
	public void setDetaFormaPagoDataAccess(DetaFormaPagoDataAccess newdetaformapagoDataAccess) {
		this.detaformapagoDataAccess = newdetaformapagoDataAccess;
	}
	
	public List<DetaFormaPago> getDetaFormaPagos() throws Exception {		
		this.quitarDetaFormaPagosNulos();
		
		DetaFormaPagoLogicAdditional.checkDetaFormaPagoToGets(detaformapagos,this.datosCliente,this.arrDatoGeneral);
		
		for (DetaFormaPago detaformapagoLocal: detaformapagos ) {
			DetaFormaPagoLogicAdditional.updateDetaFormaPagoToGet(detaformapagoLocal,this.arrDatoGeneral);
		}
		
		return detaformapagos;
	}
	
	public void setDetaFormaPagos(List<DetaFormaPago> newDetaFormaPagos) {
		this.detaformapagos = newDetaFormaPagos;
	}
	
	public Object getDetaFormaPagoObject() {	
		this.detaformapagoObject=this.detaformapagoDataAccess.getEntityObject();
		return this.detaformapagoObject;
	}
		
	public void setDetaFormaPagoObject(Object newDetaFormaPagoObject) {
		this.detaformapagoObject = newDetaFormaPagoObject;
	}
	
	public List<Object> getDetaFormaPagosObject() {		
		this.detaformapagosObject=this.detaformapagoDataAccess.getEntitiesObject();
		return this.detaformapagosObject;
	}
		
	public void setDetaFormaPagosObject(List<Object> newDetaFormaPagosObject) {
		this.detaformapagosObject = newDetaFormaPagosObject;
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
		
		if(this.detaformapagoDataAccess!=null) {
			this.detaformapagoDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPago.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			detaformapagoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			detaformapagoDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		detaformapago = new  DetaFormaPago();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPago.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detaformapago=detaformapagoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detaformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapago);
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
		detaformapago = new  DetaFormaPago();
		  		  
        try {
			
			detaformapago=detaformapagoDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detaformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapago);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		detaformapago = new  DetaFormaPago();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPago.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			detaformapago=detaformapagoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detaformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapago);
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
		detaformapago = new  DetaFormaPago();
		  		  
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
		detaformapago = new  DetaFormaPago();
		  		  
        try {
			
			detaformapago=detaformapagoDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.detaformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapago);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		detaformapago = new  DetaFormaPago();
		  		  
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
		detaformapago = new  DetaFormaPago();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPago.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =detaformapagoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detaformapago = new  DetaFormaPago();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=detaformapagoDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detaformapago = new  DetaFormaPago();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPago.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =detaformapagoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detaformapago = new  DetaFormaPago();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=detaformapagoDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		detaformapago = new  DetaFormaPago();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPago.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =detaformapagoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		detaformapago = new  DetaFormaPago();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=detaformapagoDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detaformapagos = new  ArrayList<DetaFormaPago>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPago.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			DetaFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detaformapagos=detaformapagoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetaFormaPago(detaformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapagos);
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
		detaformapagos = new  ArrayList<DetaFormaPago>();
		  		  
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
		detaformapagos = new  ArrayList<DetaFormaPago>();
		  		  
        try {			
			DetaFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detaformapagos=detaformapagoDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarDetaFormaPago(detaformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapagos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		detaformapagos = new  ArrayList<DetaFormaPago>();
		  		  
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
		detaformapagos = new  ArrayList<DetaFormaPago>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPago.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			DetaFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detaformapagos=detaformapagoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetaFormaPago(detaformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapagos);
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
		detaformapagos = new  ArrayList<DetaFormaPago>();
		  		  
        try {
			DetaFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detaformapagos=detaformapagoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetaFormaPago(detaformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapagos);
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
		detaformapagos = new  ArrayList<DetaFormaPago>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPago.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetaFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detaformapagos=detaformapagoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetaFormaPago(detaformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapagos);
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
		detaformapagos = new  ArrayList<DetaFormaPago>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetaFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detaformapagos=detaformapagoDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetaFormaPago(detaformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapagos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		detaformapago = new  DetaFormaPago();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPago.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetaFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detaformapago=detaformapagoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetaFormaPago(detaformapago);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapago);
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
		detaformapago = new  DetaFormaPago();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetaFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detaformapago=detaformapagoDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarDetaFormaPago(detaformapago);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapago);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		detaformapagos = new  ArrayList<DetaFormaPago>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPago.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			DetaFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detaformapagos=detaformapagoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetaFormaPago(detaformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapagos);
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
		detaformapagos = new  ArrayList<DetaFormaPago>();
		  		  
        try {
			DetaFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detaformapagos=detaformapagoDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarDetaFormaPago(detaformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapagos);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosDetaFormaPagosWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		detaformapagos = new  ArrayList<DetaFormaPago>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPago.class.getSimpleName()+"-getTodosDetaFormaPagosWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetaFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detaformapagos=detaformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetaFormaPago(detaformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapagos);
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
	
	public  void  getTodosDetaFormaPagos(String sFinalQuery,Pagination pagination)throws Exception {
		detaformapagos = new  ArrayList<DetaFormaPago>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			DetaFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			detaformapagos=detaformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarDetaFormaPago(detaformapagos);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapagos);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarDetaFormaPago(DetaFormaPago detaformapago) throws Exception {
		Boolean estaValidado=false;
		
		if(detaformapago.getIsNew() || detaformapago.getIsChanged()) { 
			this.invalidValues = detaformapagoValidator.getInvalidValues(detaformapago);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(detaformapago);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarDetaFormaPago(List<DetaFormaPago> DetaFormaPagos) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(DetaFormaPago detaformapagoLocal:detaformapagos) {				
			estaValidadoObjeto=this.validarGuardarDetaFormaPago(detaformapagoLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarDetaFormaPago(List<DetaFormaPago> DetaFormaPagos) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetaFormaPago(detaformapagos)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarDetaFormaPago(DetaFormaPago DetaFormaPago) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarDetaFormaPago(detaformapago)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(DetaFormaPago detaformapago) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+detaformapago.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=DetaFormaPagoConstantesFunciones.getDetaFormaPagoLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"detaformapago","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(DetaFormaPagoConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(DetaFormaPagoConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveDetaFormaPagoWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPago.class.getSimpleName()+"-saveDetaFormaPagoWithConnection");connexion.begin();			
			
			DetaFormaPagoLogicAdditional.checkDetaFormaPagoToSave(this.detaformapago,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetaFormaPagoLogicAdditional.updateDetaFormaPagoToSave(this.detaformapago,this.arrDatoGeneral);
			
			DetaFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detaformapago,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowDetaFormaPago();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetaFormaPago(this.detaformapago)) {
				DetaFormaPagoDataAccess.save(this.detaformapago, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.detaformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetaFormaPagoLogicAdditional.checkDetaFormaPagoToSaveAfter(this.detaformapago,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetaFormaPago();
			
			connexion.commit();			
			
			if(this.detaformapago.getIsDeleted()) {
				this.detaformapago=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveDetaFormaPago()throws Exception {	
		try {	
			
			DetaFormaPagoLogicAdditional.checkDetaFormaPagoToSave(this.detaformapago,this.datosCliente,connexion,this.arrDatoGeneral);
			
			DetaFormaPagoLogicAdditional.updateDetaFormaPagoToSave(this.detaformapago,this.arrDatoGeneral);
			
			DetaFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.detaformapago,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarDetaFormaPago(this.detaformapago)) {			
				DetaFormaPagoDataAccess.save(this.detaformapago, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.detaformapago,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			DetaFormaPagoLogicAdditional.checkDetaFormaPagoToSaveAfter(this.detaformapago,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.detaformapago.getIsDeleted()) {
				this.detaformapago=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveDetaFormaPagosWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPago.class.getSimpleName()+"-saveDetaFormaPagosWithConnection");connexion.begin();			
			
			DetaFormaPagoLogicAdditional.checkDetaFormaPagoToSaves(detaformapagos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowDetaFormaPagos();
			
			Boolean validadoTodosDetaFormaPago=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetaFormaPago detaformapagoLocal:detaformapagos) {		
				if(detaformapagoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetaFormaPagoLogicAdditional.updateDetaFormaPagoToSave(detaformapagoLocal,this.arrDatoGeneral);
	        	
				DetaFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detaformapagoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetaFormaPago(detaformapagoLocal)) {
					DetaFormaPagoDataAccess.save(detaformapagoLocal, connexion);				
				} else {
					validadoTodosDetaFormaPago=false;
				}
			}
			
			if(!validadoTodosDetaFormaPago) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetaFormaPagoLogicAdditional.checkDetaFormaPagoToSavesAfter(detaformapagos,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowDetaFormaPagos();
			
			connexion.commit();		
			
			this.quitarDetaFormaPagosEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveDetaFormaPagos()throws Exception {				
		 try {	
			DetaFormaPagoLogicAdditional.checkDetaFormaPagoToSaves(detaformapagos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosDetaFormaPago=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(DetaFormaPago detaformapagoLocal:detaformapagos) {				
				if(detaformapagoLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				DetaFormaPagoLogicAdditional.updateDetaFormaPagoToSave(detaformapagoLocal,this.arrDatoGeneral);
	        	
				DetaFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),detaformapagoLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarDetaFormaPago(detaformapagoLocal)) {				
					DetaFormaPagoDataAccess.save(detaformapagoLocal, connexion);				
				} else {
					validadoTodosDetaFormaPago=false;
				}
			}
			
			if(!validadoTodosDetaFormaPago) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			DetaFormaPagoLogicAdditional.checkDetaFormaPagoToSavesAfter(detaformapagos,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarDetaFormaPagosEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetaFormaPagoParameterReturnGeneral procesarAccionDetaFormaPagos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetaFormaPago> detaformapagos,DetaFormaPagoParameterReturnGeneral detaformapagoParameterGeneral)throws Exception {
		 try {	
			DetaFormaPagoParameterReturnGeneral detaformapagoReturnGeneral=new DetaFormaPagoParameterReturnGeneral();
	
			DetaFormaPagoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detaformapagos,detaformapagoParameterGeneral,detaformapagoReturnGeneral);
			
			return detaformapagoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public DetaFormaPagoParameterReturnGeneral procesarAccionDetaFormaPagosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<DetaFormaPago> detaformapagos,DetaFormaPagoParameterReturnGeneral detaformapagoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPago.class.getSimpleName()+"-procesarAccionDetaFormaPagosWithConnection");connexion.begin();			
			
			DetaFormaPagoParameterReturnGeneral detaformapagoReturnGeneral=new DetaFormaPagoParameterReturnGeneral();
	
			DetaFormaPagoLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,detaformapagos,detaformapagoParameterGeneral,detaformapagoReturnGeneral);
			
			this.connexion.commit();
			
			return detaformapagoReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetaFormaPagoParameterReturnGeneral procesarEventosDetaFormaPagos(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetaFormaPago> detaformapagos,DetaFormaPago detaformapago,DetaFormaPagoParameterReturnGeneral detaformapagoParameterGeneral,Boolean isEsNuevoDetaFormaPago,ArrayList<Classe> clases)throws Exception {
		 try {	
			DetaFormaPagoParameterReturnGeneral detaformapagoReturnGeneral=new DetaFormaPagoParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detaformapagoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetaFormaPagoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detaformapagos,detaformapago,detaformapagoParameterGeneral,detaformapagoReturnGeneral,isEsNuevoDetaFormaPago,clases);
			
			return detaformapagoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public DetaFormaPagoParameterReturnGeneral procesarEventosDetaFormaPagosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<DetaFormaPago> detaformapagos,DetaFormaPago detaformapago,DetaFormaPagoParameterReturnGeneral detaformapagoParameterGeneral,Boolean isEsNuevoDetaFormaPago,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPago.class.getSimpleName()+"-procesarEventosDetaFormaPagosWithConnection");connexion.begin();			
			
			DetaFormaPagoParameterReturnGeneral detaformapagoReturnGeneral=new DetaFormaPagoParameterReturnGeneral();
	
			detaformapagoReturnGeneral.setDetaFormaPago(detaformapago);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				detaformapagoReturnGeneral.setConRecargarPropiedades(true);
			}
			
			DetaFormaPagoLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,detaformapagos,detaformapago,detaformapagoParameterGeneral,detaformapagoReturnGeneral,isEsNuevoDetaFormaPago,clases);
			
			this.connexion.commit();
			
			return detaformapagoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public DetaFormaPagoParameterReturnGeneral procesarImportacionDetaFormaPagosWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,DetaFormaPagoParameterReturnGeneral detaformapagoParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPago.class.getSimpleName()+"-procesarImportacionDetaFormaPagosWithConnection");connexion.begin();			
			
			DetaFormaPagoParameterReturnGeneral detaformapagoReturnGeneral=new DetaFormaPagoParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.detaformapagos=new ArrayList<DetaFormaPago>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.detaformapago=new DetaFormaPago();
				
				
				if(conColumnasBase) {this.detaformapago.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.detaformapago.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.detaformapago.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				this.detaformapago.setfecha_inicial(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.detaformapago.setfecha_final(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.detaformapago.setporcentaje(Double.parseDouble(arrColumnas[iColumn++]));
				this.detaformapago.setretencion(Double.parseDouble(arrColumnas[iColumn++]));
				this.detaformapago.setporcentaje_retencion(Double.parseDouble(arrColumnas[iColumn++]));
				this.detaformapago.setbase_retencion(Double.parseDouble(arrColumnas[iColumn++]));
				this.detaformapago.setvalor_retencion(Double.parseDouble(arrColumnas[iColumn++]));
				this.detaformapago.setnumero_retencion(arrColumnas[iColumn++]);
				this.detaformapago.setnumero_dias(Integer.parseInt(arrColumnas[iColumn++]));
				this.detaformapago.setnumero_cuota(Integer.parseInt(arrColumnas[iColumn++]));
				this.detaformapago.setdescripcion(arrColumnas[iColumn++]);
				
				this.detaformapagos.add(this.detaformapago);
			}
			
			this.saveDetaFormaPagos();
			
			this.connexion.commit();
			
			detaformapagoReturnGeneral.setConRetornoEstaProcesado(true);
			detaformapagoReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return detaformapagoReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarDetaFormaPagosEliminados() throws Exception {				
		
		List<DetaFormaPago> detaformapagosAux= new ArrayList<DetaFormaPago>();
		
		for(DetaFormaPago detaformapago:detaformapagos) {
			if(!detaformapago.getIsDeleted()) {
				detaformapagosAux.add(detaformapago);
			}
		}
		
		detaformapagos=detaformapagosAux;
	}
	
	public void quitarDetaFormaPagosNulos() throws Exception {				
		
		List<DetaFormaPago> detaformapagosAux= new ArrayList<DetaFormaPago>();
		
		for(DetaFormaPago detaformapago : this.detaformapagos) {
			if(detaformapago==null) {
				detaformapagosAux.add(detaformapago);
			}
		}
		
		//this.detaformapagos=detaformapagosAux;
		
		this.detaformapagos.removeAll(detaformapagosAux);
	}
	
	public void getSetVersionRowDetaFormaPagoWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(detaformapago.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((detaformapago.getIsDeleted() || (detaformapago.getIsChanged()&&!detaformapago.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=detaformapagoDataAccess.getSetVersionRowDetaFormaPago(connexion,detaformapago.getId());
				
				if(!detaformapago.getVersionRow().equals(timestamp)) {	
					detaformapago.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				detaformapago.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowDetaFormaPago()throws Exception {	
		
		if(detaformapago.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((detaformapago.getIsDeleted() || (detaformapago.getIsChanged()&&!detaformapago.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=detaformapagoDataAccess.getSetVersionRowDetaFormaPago(connexion,detaformapago.getId());
			
			try {							
				if(!detaformapago.getVersionRow().equals(timestamp)) {	
					detaformapago.setVersionRow(timestamp);
				}
				
				detaformapago.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowDetaFormaPagosWithConnection()throws Exception {	
		if(detaformapagos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(DetaFormaPago detaformapagoAux:detaformapagos) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(detaformapagoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detaformapagoAux.getIsDeleted() || (detaformapagoAux.getIsChanged()&&!detaformapagoAux.getIsNew())) {
						
						timestamp=detaformapagoDataAccess.getSetVersionRowDetaFormaPago(connexion,detaformapagoAux.getId());
						
						if(!detaformapago.getVersionRow().equals(timestamp)) {	
							detaformapagoAux.setVersionRow(timestamp);
						}
								
						detaformapagoAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowDetaFormaPagos()throws Exception {	
		if(detaformapagos!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(DetaFormaPago detaformapagoAux:detaformapagos) {
					if(detaformapagoAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(detaformapagoAux.getIsDeleted() || (detaformapagoAux.getIsChanged()&&!detaformapagoAux.getIsNew())) {
						
						timestamp=detaformapagoDataAccess.getSetVersionRowDetaFormaPago(connexion,detaformapagoAux.getId());
						
						if(!detaformapagoAux.getVersionRow().equals(timestamp)) {	
							detaformapagoAux.setVersionRow(timestamp);
						}
						
													
						detaformapagoAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public DetaFormaPagoParameterReturnGeneral cargarCombosLoteForeignKeyDetaFormaPagoWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalFactura,String finalQueryGlobalTipoFormaPago,String finalQueryGlobalTipoDetaFormaPago,String finalQueryGlobalDetaFormaPagoFactu,String finalQueryGlobalCuentaContable,String finalQueryGlobalTipoRetencion,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		DetaFormaPagoParameterReturnGeneral  detaformapagoReturnGeneral =new DetaFormaPagoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPago.class.getSimpleName()+"-cargarCombosLoteForeignKeyDetaFormaPagoWithConnection");connexion.begin();
			
			detaformapagoReturnGeneral =new DetaFormaPagoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detaformapagoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detaformapagoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detaformapagoReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detaformapagoReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			detaformapagoReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<TipoFormaPago> tipoformapagosForeignKey=new ArrayList<TipoFormaPago>();
			TipoFormaPagoLogic tipoformapagoLogic=new TipoFormaPagoLogic();
			tipoformapagoLogic.setConnexion(this.connexion);
			tipoformapagoLogic.getTipoFormaPagoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoFormaPago.equals("NONE")) {
				tipoformapagoLogic.getTodosTipoFormaPagos(finalQueryGlobalTipoFormaPago,new Pagination());
				tipoformapagosForeignKey=tipoformapagoLogic.getTipoFormaPagos();
			}

			detaformapagoReturnGeneral.settipoformapagosForeignKey(tipoformapagosForeignKey);


			List<TipoDetaFormaPago> tipodetaformapagosForeignKey=new ArrayList<TipoDetaFormaPago>();
			TipoDetaFormaPagoLogic tipodetaformapagoLogic=new TipoDetaFormaPagoLogic();
			tipodetaformapagoLogic.setConnexion(this.connexion);
			tipodetaformapagoLogic.getTipoDetaFormaPagoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDetaFormaPago.equals("NONE")) {
				tipodetaformapagoLogic.getTodosTipoDetaFormaPagos(finalQueryGlobalTipoDetaFormaPago,new Pagination());
				tipodetaformapagosForeignKey=tipodetaformapagoLogic.getTipoDetaFormaPagos();
			}

			detaformapagoReturnGeneral.settipodetaformapagosForeignKey(tipodetaformapagosForeignKey);


			List<DetaFormaPagoFactu> detaformapagofactusForeignKey=new ArrayList<DetaFormaPagoFactu>();
			DetaFormaPagoFactuLogic detaformapagofactuLogic=new DetaFormaPagoFactuLogic();
			detaformapagofactuLogic.setConnexion(this.connexion);
			detaformapagofactuLogic.getDetaFormaPagoFactuDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDetaFormaPagoFactu.equals("NONE")) {
				detaformapagofactuLogic.getTodosDetaFormaPagoFactus(finalQueryGlobalDetaFormaPagoFactu,new Pagination());
				detaformapagofactusForeignKey=detaformapagofactuLogic.getDetaFormaPagoFactus();
			}

			detaformapagoReturnGeneral.setdetaformapagofactusForeignKey(detaformapagofactusForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			detaformapagoReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<TipoRetencion> tiporetencionsForeignKey=new ArrayList<TipoRetencion>();
			TipoRetencionLogic tiporetencionLogic=new TipoRetencionLogic();
			tiporetencionLogic.setConnexion(this.connexion);
			tiporetencionLogic.getTipoRetencionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencion.equals("NONE")) {
				tiporetencionLogic.getTodosTipoRetencions(finalQueryGlobalTipoRetencion,new Pagination());
				tiporetencionsForeignKey=tiporetencionLogic.getTipoRetencions();
			}

			detaformapagoReturnGeneral.settiporetencionsForeignKey(tiporetencionsForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detaformapagoReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detaformapagoReturnGeneral.setmessForeignKey(messForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return detaformapagoReturnGeneral;
	}
	
	public DetaFormaPagoParameterReturnGeneral cargarCombosLoteForeignKeyDetaFormaPago(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalEjercicio,String finalQueryGlobalPeriodo,String finalQueryGlobalFactura,String finalQueryGlobalTipoFormaPago,String finalQueryGlobalTipoDetaFormaPago,String finalQueryGlobalDetaFormaPagoFactu,String finalQueryGlobalCuentaContable,String finalQueryGlobalTipoRetencion,String finalQueryGlobalAnio,String finalQueryGlobalMes) throws Exception {
		DetaFormaPagoParameterReturnGeneral  detaformapagoReturnGeneral =new DetaFormaPagoParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			detaformapagoReturnGeneral =new DetaFormaPagoParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			detaformapagoReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			detaformapagoReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Ejercicio> ejerciciosForeignKey=new ArrayList<Ejercicio>();
			EjercicioLogic ejercicioLogic=new EjercicioLogic();
			ejercicioLogic.setConnexion(this.connexion);
			//ejercicioLogic.getEjercicioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEjercicio.equals("NONE")) {
				ejercicioLogic.getTodosEjercicios(finalQueryGlobalEjercicio,new Pagination());
				ejerciciosForeignKey=ejercicioLogic.getEjercicios();
			}

			detaformapagoReturnGeneral.setejerciciosForeignKey(ejerciciosForeignKey);


			List<Periodo> periodosForeignKey=new ArrayList<Periodo>();
			PeriodoLogic periodoLogic=new PeriodoLogic();
			periodoLogic.setConnexion(this.connexion);
			//periodoLogic.getPeriodoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPeriodo.equals("NONE")) {
				periodoLogic.getTodosPeriodos(finalQueryGlobalPeriodo,new Pagination());
				periodosForeignKey=periodoLogic.getPeriodos();
			}

			detaformapagoReturnGeneral.setperiodosForeignKey(periodosForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			detaformapagoReturnGeneral.setfacturasForeignKey(facturasForeignKey);


			List<TipoFormaPago> tipoformapagosForeignKey=new ArrayList<TipoFormaPago>();
			TipoFormaPagoLogic tipoformapagoLogic=new TipoFormaPagoLogic();
			tipoformapagoLogic.setConnexion(this.connexion);
			tipoformapagoLogic.getTipoFormaPagoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoFormaPago.equals("NONE")) {
				tipoformapagoLogic.getTodosTipoFormaPagos(finalQueryGlobalTipoFormaPago,new Pagination());
				tipoformapagosForeignKey=tipoformapagoLogic.getTipoFormaPagos();
			}

			detaformapagoReturnGeneral.settipoformapagosForeignKey(tipoformapagosForeignKey);


			List<TipoDetaFormaPago> tipodetaformapagosForeignKey=new ArrayList<TipoDetaFormaPago>();
			TipoDetaFormaPagoLogic tipodetaformapagoLogic=new TipoDetaFormaPagoLogic();
			tipodetaformapagoLogic.setConnexion(this.connexion);
			tipodetaformapagoLogic.getTipoDetaFormaPagoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoDetaFormaPago.equals("NONE")) {
				tipodetaformapagoLogic.getTodosTipoDetaFormaPagos(finalQueryGlobalTipoDetaFormaPago,new Pagination());
				tipodetaformapagosForeignKey=tipodetaformapagoLogic.getTipoDetaFormaPagos();
			}

			detaformapagoReturnGeneral.settipodetaformapagosForeignKey(tipodetaformapagosForeignKey);


			List<DetaFormaPagoFactu> detaformapagofactusForeignKey=new ArrayList<DetaFormaPagoFactu>();
			DetaFormaPagoFactuLogic detaformapagofactuLogic=new DetaFormaPagoFactuLogic();
			detaformapagofactuLogic.setConnexion(this.connexion);
			detaformapagofactuLogic.getDetaFormaPagoFactuDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalDetaFormaPagoFactu.equals("NONE")) {
				detaformapagofactuLogic.getTodosDetaFormaPagoFactus(finalQueryGlobalDetaFormaPagoFactu,new Pagination());
				detaformapagofactusForeignKey=detaformapagofactuLogic.getDetaFormaPagoFactus();
			}

			detaformapagoReturnGeneral.setdetaformapagofactusForeignKey(detaformapagofactusForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			detaformapagoReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<TipoRetencion> tiporetencionsForeignKey=new ArrayList<TipoRetencion>();
			TipoRetencionLogic tiporetencionLogic=new TipoRetencionLogic();
			tiporetencionLogic.setConnexion(this.connexion);
			tiporetencionLogic.getTipoRetencionDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoRetencion.equals("NONE")) {
				tiporetencionLogic.getTodosTipoRetencions(finalQueryGlobalTipoRetencion,new Pagination());
				tiporetencionsForeignKey=tiporetencionLogic.getTipoRetencions();
			}

			detaformapagoReturnGeneral.settiporetencionsForeignKey(tiporetencionsForeignKey);


			List<Anio> aniosForeignKey=new ArrayList<Anio>();
			AnioLogic anioLogic=new AnioLogic();
			anioLogic.setConnexion(this.connexion);
			anioLogic.getAnioDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalAnio.equals("NONE")) {
				anioLogic.getTodosAnios(finalQueryGlobalAnio,new Pagination());
				aniosForeignKey=anioLogic.getAnios();
			}

			detaformapagoReturnGeneral.setaniosForeignKey(aniosForeignKey);


			List<Mes> messForeignKey=new ArrayList<Mes>();
			MesLogic mesLogic=new MesLogic();
			mesLogic.setConnexion(this.connexion);
			mesLogic.getMesDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalMes.equals("NONE")) {
				mesLogic.getTodosMess(finalQueryGlobalMes,new Pagination());
				messForeignKey=mesLogic.getMess();
			}

			detaformapagoReturnGeneral.setmessForeignKey(messForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return detaformapagoReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyDetaFormaPagoWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			BancoFormaPagoLogic bancoformapagoLogic=new BancoFormaPagoLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPago.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyDetaFormaPagoWithConnection");connexion.begin();
			
			
			classes.add(new Classe(BancoFormaPago.class));
											
			

			bancoformapagoLogic.setConnexion(this.getConnexion());
			bancoformapagoLogic.setDatosCliente(this.datosCliente);
			bancoformapagoLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(DetaFormaPago detaformapago:this.detaformapagos) {
				

				classes=new ArrayList<Classe>();
				classes=BancoFormaPagoConstantesFunciones.getClassesForeignKeysOfBancoFormaPago(new ArrayList<Classe>(),DeepLoadType.NONE);

				bancoformapagoLogic.setBancoFormaPagos(detaformapago.bancoformapagos);
				bancoformapagoLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
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
	
	public void deepLoad(DetaFormaPago detaformapago,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			DetaFormaPagoLogicAdditional.updateDetaFormaPagoToGet(detaformapago,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detaformapago.setEmpresa(detaformapagoDataAccess.getEmpresa(connexion,detaformapago));
		detaformapago.setSucursal(detaformapagoDataAccess.getSucursal(connexion,detaformapago));
		detaformapago.setEjercicio(detaformapagoDataAccess.getEjercicio(connexion,detaformapago));
		detaformapago.setPeriodo(detaformapagoDataAccess.getPeriodo(connexion,detaformapago));
		detaformapago.setFactura(detaformapagoDataAccess.getFactura(connexion,detaformapago));
		detaformapago.setTipoFormaPago(detaformapagoDataAccess.getTipoFormaPago(connexion,detaformapago));
		detaformapago.setTipoDetaFormaPago(detaformapagoDataAccess.getTipoDetaFormaPago(connexion,detaformapago));
		detaformapago.setDetaFormaPagoFactu(detaformapagoDataAccess.getDetaFormaPagoFactu(connexion,detaformapago));
		detaformapago.setCuentaContable(detaformapagoDataAccess.getCuentaContable(connexion,detaformapago));
		detaformapago.setTipoRetencion(detaformapagoDataAccess.getTipoRetencion(connexion,detaformapago));
		detaformapago.setAnio(detaformapagoDataAccess.getAnio(connexion,detaformapago));
		detaformapago.setMes(detaformapagoDataAccess.getMes(connexion,detaformapago));
		detaformapago.setBancoFormaPagos(detaformapagoDataAccess.getBancoFormaPagos(connexion,detaformapago));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detaformapago.setEmpresa(detaformapagoDataAccess.getEmpresa(connexion,detaformapago));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detaformapago.setSucursal(detaformapagoDataAccess.getSucursal(connexion,detaformapago));
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detaformapago.setEjercicio(detaformapagoDataAccess.getEjercicio(connexion,detaformapago));
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detaformapago.setPeriodo(detaformapagoDataAccess.getPeriodo(connexion,detaformapago));
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				detaformapago.setFactura(detaformapagoDataAccess.getFactura(connexion,detaformapago));
				continue;
			}

			if(clas.clas.equals(TipoFormaPago.class)) {
				detaformapago.setTipoFormaPago(detaformapagoDataAccess.getTipoFormaPago(connexion,detaformapago));
				continue;
			}

			if(clas.clas.equals(TipoDetaFormaPago.class)) {
				detaformapago.setTipoDetaFormaPago(detaformapagoDataAccess.getTipoDetaFormaPago(connexion,detaformapago));
				continue;
			}

			if(clas.clas.equals(DetaFormaPagoFactu.class)) {
				detaformapago.setDetaFormaPagoFactu(detaformapagoDataAccess.getDetaFormaPagoFactu(connexion,detaformapago));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				detaformapago.setCuentaContable(detaformapagoDataAccess.getCuentaContable(connexion,detaformapago));
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				detaformapago.setTipoRetencion(detaformapagoDataAccess.getTipoRetencion(connexion,detaformapago));
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detaformapago.setAnio(detaformapagoDataAccess.getAnio(connexion,detaformapago));
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detaformapago.setMes(detaformapagoDataAccess.getMes(connexion,detaformapago));
				continue;
			}

			if(clas.clas.equals(BancoFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				detaformapago.setBancoFormaPagos(detaformapagoDataAccess.getBancoFormaPagos(connexion,detaformapago));

				if(this.isConDeep) {
					BancoFormaPagoLogic bancoformapagoLogic= new BancoFormaPagoLogic(this.connexion);
					bancoformapagoLogic.setBancoFormaPagos(detaformapago.getBancoFormaPagos());
					ArrayList<Classe> classesLocal=BancoFormaPagoConstantesFunciones.getClassesForeignKeysOfBancoFormaPago(new ArrayList<Classe>(),DeepLoadType.NONE);
					bancoformapagoLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					BancoFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesBancoFormaPago(bancoformapagoLogic.getBancoFormaPagos());
					detaformapago.setBancoFormaPagos(bancoformapagoLogic.getBancoFormaPagos());
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
			detaformapago.setEmpresa(detaformapagoDataAccess.getEmpresa(connexion,detaformapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detaformapago.setSucursal(detaformapagoDataAccess.getSucursal(connexion,detaformapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detaformapago.setEjercicio(detaformapagoDataAccess.getEjercicio(connexion,detaformapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detaformapago.setPeriodo(detaformapagoDataAccess.getPeriodo(connexion,detaformapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detaformapago.setFactura(detaformapagoDataAccess.getFactura(connexion,detaformapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFormaPago.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detaformapago.setTipoFormaPago(detaformapagoDataAccess.getTipoFormaPago(connexion,detaformapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDetaFormaPago.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detaformapago.setTipoDetaFormaPago(detaformapagoDataAccess.getTipoDetaFormaPago(connexion,detaformapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetaFormaPagoFactu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detaformapago.setDetaFormaPagoFactu(detaformapagoDataAccess.getDetaFormaPagoFactu(connexion,detaformapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detaformapago.setCuentaContable(detaformapagoDataAccess.getCuentaContable(connexion,detaformapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detaformapago.setTipoRetencion(detaformapagoDataAccess.getTipoRetencion(connexion,detaformapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detaformapago.setAnio(detaformapagoDataAccess.getAnio(connexion,detaformapago));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detaformapago.setMes(detaformapagoDataAccess.getMes(connexion,detaformapago));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(BancoFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(BancoFormaPago.class));
			detaformapago.setBancoFormaPagos(detaformapagoDataAccess.getBancoFormaPagos(connexion,detaformapago));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		detaformapago.setEmpresa(detaformapagoDataAccess.getEmpresa(connexion,detaformapago));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detaformapago.getEmpresa(),isDeep,deepLoadType,clases);
				
		detaformapago.setSucursal(detaformapagoDataAccess.getSucursal(connexion,detaformapago));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detaformapago.getSucursal(),isDeep,deepLoadType,clases);
				
		detaformapago.setEjercicio(detaformapagoDataAccess.getEjercicio(connexion,detaformapago));
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detaformapago.getEjercicio(),isDeep,deepLoadType,clases);
				
		detaformapago.setPeriodo(detaformapagoDataAccess.getPeriodo(connexion,detaformapago));
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detaformapago.getPeriodo(),isDeep,deepLoadType,clases);
				
		detaformapago.setFactura(detaformapagoDataAccess.getFactura(connexion,detaformapago));
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(detaformapago.getFactura(),isDeep,deepLoadType,clases);
				
		detaformapago.setTipoFormaPago(detaformapagoDataAccess.getTipoFormaPago(connexion,detaformapago));
		TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
		tipoformapagoLogic.deepLoad(detaformapago.getTipoFormaPago(),isDeep,deepLoadType,clases);
				
		detaformapago.setTipoDetaFormaPago(detaformapagoDataAccess.getTipoDetaFormaPago(connexion,detaformapago));
		TipoDetaFormaPagoLogic tipodetaformapagoLogic= new TipoDetaFormaPagoLogic(connexion);
		tipodetaformapagoLogic.deepLoad(detaformapago.getTipoDetaFormaPago(),isDeep,deepLoadType,clases);
				
		detaformapago.setDetaFormaPagoFactu(detaformapagoDataAccess.getDetaFormaPagoFactu(connexion,detaformapago));
		DetaFormaPagoFactuLogic detaformapagofactuLogic= new DetaFormaPagoFactuLogic(connexion);
		detaformapagofactuLogic.deepLoad(detaformapago.getDetaFormaPagoFactu(),isDeep,deepLoadType,clases);
				
		detaformapago.setCuentaContable(detaformapagoDataAccess.getCuentaContable(connexion,detaformapago));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(detaformapago.getCuentaContable(),isDeep,deepLoadType,clases);
				
		detaformapago.setTipoRetencion(detaformapagoDataAccess.getTipoRetencion(connexion,detaformapago));
		TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
		tiporetencionLogic.deepLoad(detaformapago.getTipoRetencion(),isDeep,deepLoadType,clases);
				
		detaformapago.setAnio(detaformapagoDataAccess.getAnio(connexion,detaformapago));
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detaformapago.getAnio(),isDeep,deepLoadType,clases);
				
		detaformapago.setMes(detaformapagoDataAccess.getMes(connexion,detaformapago));
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detaformapago.getMes(),isDeep,deepLoadType,clases);
				

		detaformapago.setBancoFormaPagos(detaformapagoDataAccess.getBancoFormaPagos(connexion,detaformapago));

		for(BancoFormaPago bancoformapago:detaformapago.getBancoFormaPagos()) {
			BancoFormaPagoLogic bancoformapagoLogic= new BancoFormaPagoLogic(connexion);
			bancoformapagoLogic.deepLoad(bancoformapago,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				detaformapago.setEmpresa(detaformapagoDataAccess.getEmpresa(connexion,detaformapago));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(detaformapago.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				detaformapago.setSucursal(detaformapagoDataAccess.getSucursal(connexion,detaformapago));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(detaformapago.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				detaformapago.setEjercicio(detaformapagoDataAccess.getEjercicio(connexion,detaformapago));
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepLoad(detaformapago.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				detaformapago.setPeriodo(detaformapagoDataAccess.getPeriodo(connexion,detaformapago));
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepLoad(detaformapago.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				detaformapago.setFactura(detaformapagoDataAccess.getFactura(connexion,detaformapago));
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepLoad(detaformapago.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoFormaPago.class)) {
				detaformapago.setTipoFormaPago(detaformapagoDataAccess.getTipoFormaPago(connexion,detaformapago));
				TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
				tipoformapagoLogic.deepLoad(detaformapago.getTipoFormaPago(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDetaFormaPago.class)) {
				detaformapago.setTipoDetaFormaPago(detaformapagoDataAccess.getTipoDetaFormaPago(connexion,detaformapago));
				TipoDetaFormaPagoLogic tipodetaformapagoLogic= new TipoDetaFormaPagoLogic(connexion);
				tipodetaformapagoLogic.deepLoad(detaformapago.getTipoDetaFormaPago(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetaFormaPagoFactu.class)) {
				detaformapago.setDetaFormaPagoFactu(detaformapagoDataAccess.getDetaFormaPagoFactu(connexion,detaformapago));
				DetaFormaPagoFactuLogic detaformapagofactuLogic= new DetaFormaPagoFactuLogic(connexion);
				detaformapagofactuLogic.deepLoad(detaformapago.getDetaFormaPagoFactu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				detaformapago.setCuentaContable(detaformapagoDataAccess.getCuentaContable(connexion,detaformapago));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(detaformapago.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				detaformapago.setTipoRetencion(detaformapagoDataAccess.getTipoRetencion(connexion,detaformapago));
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepLoad(detaformapago.getTipoRetencion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				detaformapago.setAnio(detaformapagoDataAccess.getAnio(connexion,detaformapago));
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepLoad(detaformapago.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				detaformapago.setMes(detaformapagoDataAccess.getMes(connexion,detaformapago));
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepLoad(detaformapago.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(BancoFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				detaformapago.setBancoFormaPagos(detaformapagoDataAccess.getBancoFormaPagos(connexion,detaformapago));

				for(BancoFormaPago bancoformapago:detaformapago.getBancoFormaPagos()) {
					BancoFormaPagoLogic bancoformapagoLogic= new BancoFormaPagoLogic(connexion);
					bancoformapagoLogic.deepLoad(bancoformapago,isDeep,deepLoadType,clases);
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
			detaformapago.setEmpresa(detaformapagoDataAccess.getEmpresa(connexion,detaformapago));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(detaformapago.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detaformapago.setSucursal(detaformapagoDataAccess.getSucursal(connexion,detaformapago));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(detaformapago.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Ejercicio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detaformapago.setEjercicio(detaformapagoDataAccess.getEjercicio(connexion,detaformapago));
			EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
			ejercicioLogic.deepLoad(detaformapago.getEjercicio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Periodo.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detaformapago.setPeriodo(detaformapagoDataAccess.getPeriodo(connexion,detaformapago));
			PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
			periodoLogic.deepLoad(detaformapago.getPeriodo(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detaformapago.setFactura(detaformapagoDataAccess.getFactura(connexion,detaformapago));
			FacturaLogic facturaLogic= new FacturaLogic(connexion);
			facturaLogic.deepLoad(detaformapago.getFactura(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoFormaPago.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detaformapago.setTipoFormaPago(detaformapagoDataAccess.getTipoFormaPago(connexion,detaformapago));
			TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
			tipoformapagoLogic.deepLoad(detaformapago.getTipoFormaPago(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoDetaFormaPago.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detaformapago.setTipoDetaFormaPago(detaformapagoDataAccess.getTipoDetaFormaPago(connexion,detaformapago));
			TipoDetaFormaPagoLogic tipodetaformapagoLogic= new TipoDetaFormaPagoLogic(connexion);
			tipodetaformapagoLogic.deepLoad(detaformapago.getTipoDetaFormaPago(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(DetaFormaPagoFactu.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detaformapago.setDetaFormaPagoFactu(detaformapagoDataAccess.getDetaFormaPagoFactu(connexion,detaformapago));
			DetaFormaPagoFactuLogic detaformapagofactuLogic= new DetaFormaPagoFactuLogic(connexion);
			detaformapagofactuLogic.deepLoad(detaformapago.getDetaFormaPagoFactu(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detaformapago.setCuentaContable(detaformapagoDataAccess.getCuentaContable(connexion,detaformapago));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(detaformapago.getCuentaContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoRetencion.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detaformapago.setTipoRetencion(detaformapagoDataAccess.getTipoRetencion(connexion,detaformapago));
			TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
			tiporetencionLogic.deepLoad(detaformapago.getTipoRetencion(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Anio.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detaformapago.setAnio(detaformapagoDataAccess.getAnio(connexion,detaformapago));
			AnioLogic anioLogic= new AnioLogic(connexion);
			anioLogic.deepLoad(detaformapago.getAnio(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Mes.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			detaformapago.setMes(detaformapagoDataAccess.getMes(connexion,detaformapago));
			MesLogic mesLogic= new MesLogic(connexion);
			mesLogic.deepLoad(detaformapago.getMes(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(BancoFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(BancoFormaPago.class));
			detaformapago.setBancoFormaPagos(detaformapagoDataAccess.getBancoFormaPagos(connexion,detaformapago));

			for(BancoFormaPago bancoformapago:detaformapago.getBancoFormaPagos()) {
				BancoFormaPagoLogic bancoformapagoLogic= new BancoFormaPagoLogic(connexion);
				bancoformapagoLogic.deepLoad(bancoformapago,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(DetaFormaPago detaformapago,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			DetaFormaPagoLogicAdditional.updateDetaFormaPagoToSave(detaformapago,this.arrDatoGeneral);
			
DetaFormaPagoDataAccess.save(detaformapago, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detaformapago.getEmpresa(),connexion);

		SucursalDataAccess.save(detaformapago.getSucursal(),connexion);

		EjercicioDataAccess.save(detaformapago.getEjercicio(),connexion);

		PeriodoDataAccess.save(detaformapago.getPeriodo(),connexion);

		FacturaDataAccess.save(detaformapago.getFactura(),connexion);

		TipoFormaPagoDataAccess.save(detaformapago.getTipoFormaPago(),connexion);

		TipoDetaFormaPagoDataAccess.save(detaformapago.getTipoDetaFormaPago(),connexion);

		DetaFormaPagoFactuDataAccess.save(detaformapago.getDetaFormaPagoFactu(),connexion);

		CuentaContableDataAccess.save(detaformapago.getCuentaContable(),connexion);

		TipoRetencionDataAccess.save(detaformapago.getTipoRetencion(),connexion);

		AnioDataAccess.save(detaformapago.getAnio(),connexion);

		MesDataAccess.save(detaformapago.getMes(),connexion);

		for(BancoFormaPago bancoformapago:detaformapago.getBancoFormaPagos()) {
			bancoformapago.setid_deta_forma_pago(detaformapago.getId());
			BancoFormaPagoDataAccess.save(bancoformapago,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detaformapago.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detaformapago.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detaformapago.getEjercicio(),connexion);
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detaformapago.getPeriodo(),connexion);
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(detaformapago.getFactura(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoFormaPago.class)) {
				TipoFormaPagoDataAccess.save(detaformapago.getTipoFormaPago(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoDetaFormaPago.class)) {
				TipoDetaFormaPagoDataAccess.save(detaformapago.getTipoDetaFormaPago(),connexion);
				continue;
			}

			if(clas.clas.equals(DetaFormaPagoFactu.class)) {
				DetaFormaPagoFactuDataAccess.save(detaformapago.getDetaFormaPagoFactu(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(detaformapago.getCuentaContable(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				TipoRetencionDataAccess.save(detaformapago.getTipoRetencion(),connexion);
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detaformapago.getAnio(),connexion);
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detaformapago.getMes(),connexion);
				continue;
			}


			if(clas.clas.equals(BancoFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(BancoFormaPago bancoformapago:detaformapago.getBancoFormaPagos()) {
					bancoformapago.setid_deta_forma_pago(detaformapago.getId());
					BancoFormaPagoDataAccess.save(bancoformapago,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(detaformapago.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(detaformapago.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(detaformapago.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(detaformapago.getSucursal(),isDeep,deepLoadType,clases);
				

		EjercicioDataAccess.save(detaformapago.getEjercicio(),connexion);
		EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
		ejercicioLogic.deepLoad(detaformapago.getEjercicio(),isDeep,deepLoadType,clases);
				

		PeriodoDataAccess.save(detaformapago.getPeriodo(),connexion);
		PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
		periodoLogic.deepLoad(detaformapago.getPeriodo(),isDeep,deepLoadType,clases);
				

		FacturaDataAccess.save(detaformapago.getFactura(),connexion);
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(detaformapago.getFactura(),isDeep,deepLoadType,clases);
				

		TipoFormaPagoDataAccess.save(detaformapago.getTipoFormaPago(),connexion);
		TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
		tipoformapagoLogic.deepLoad(detaformapago.getTipoFormaPago(),isDeep,deepLoadType,clases);
				

		TipoDetaFormaPagoDataAccess.save(detaformapago.getTipoDetaFormaPago(),connexion);
		TipoDetaFormaPagoLogic tipodetaformapagoLogic= new TipoDetaFormaPagoLogic(connexion);
		tipodetaformapagoLogic.deepLoad(detaformapago.getTipoDetaFormaPago(),isDeep,deepLoadType,clases);
				

		DetaFormaPagoFactuDataAccess.save(detaformapago.getDetaFormaPagoFactu(),connexion);
		DetaFormaPagoFactuLogic detaformapagofactuLogic= new DetaFormaPagoFactuLogic(connexion);
		detaformapagofactuLogic.deepLoad(detaformapago.getDetaFormaPagoFactu(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(detaformapago.getCuentaContable(),connexion);
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(detaformapago.getCuentaContable(),isDeep,deepLoadType,clases);
				

		TipoRetencionDataAccess.save(detaformapago.getTipoRetencion(),connexion);
		TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
		tiporetencionLogic.deepLoad(detaformapago.getTipoRetencion(),isDeep,deepLoadType,clases);
				

		AnioDataAccess.save(detaformapago.getAnio(),connexion);
		AnioLogic anioLogic= new AnioLogic(connexion);
		anioLogic.deepLoad(detaformapago.getAnio(),isDeep,deepLoadType,clases);
				

		MesDataAccess.save(detaformapago.getMes(),connexion);
		MesLogic mesLogic= new MesLogic(connexion);
		mesLogic.deepLoad(detaformapago.getMes(),isDeep,deepLoadType,clases);
				

		for(BancoFormaPago bancoformapago:detaformapago.getBancoFormaPagos()) {
			BancoFormaPagoLogic bancoformapagoLogic= new BancoFormaPagoLogic(connexion);
			bancoformapago.setid_deta_forma_pago(detaformapago.getId());
			BancoFormaPagoDataAccess.save(bancoformapago,connexion);
			bancoformapagoLogic.deepSave(bancoformapago,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(detaformapago.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(detaformapago.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(detaformapago.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(detaformapago.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Ejercicio.class)) {
				EjercicioDataAccess.save(detaformapago.getEjercicio(),connexion);
				EjercicioLogic ejercicioLogic= new EjercicioLogic(connexion);
				ejercicioLogic.deepSave(detaformapago.getEjercicio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Periodo.class)) {
				PeriodoDataAccess.save(detaformapago.getPeriodo(),connexion);
				PeriodoLogic periodoLogic= new PeriodoLogic(connexion);
				periodoLogic.deepSave(detaformapago.getPeriodo(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(detaformapago.getFactura(),connexion);
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepSave(detaformapago.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoFormaPago.class)) {
				TipoFormaPagoDataAccess.save(detaformapago.getTipoFormaPago(),connexion);
				TipoFormaPagoLogic tipoformapagoLogic= new TipoFormaPagoLogic(connexion);
				tipoformapagoLogic.deepSave(detaformapago.getTipoFormaPago(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoDetaFormaPago.class)) {
				TipoDetaFormaPagoDataAccess.save(detaformapago.getTipoDetaFormaPago(),connexion);
				TipoDetaFormaPagoLogic tipodetaformapagoLogic= new TipoDetaFormaPagoLogic(connexion);
				tipodetaformapagoLogic.deepSave(detaformapago.getTipoDetaFormaPago(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetaFormaPagoFactu.class)) {
				DetaFormaPagoFactuDataAccess.save(detaformapago.getDetaFormaPagoFactu(),connexion);
				DetaFormaPagoFactuLogic detaformapagofactuLogic= new DetaFormaPagoFactuLogic(connexion);
				detaformapagofactuLogic.deepSave(detaformapago.getDetaFormaPagoFactu(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(detaformapago.getCuentaContable(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(detaformapago.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoRetencion.class)) {
				TipoRetencionDataAccess.save(detaformapago.getTipoRetencion(),connexion);
				TipoRetencionLogic tiporetencionLogic= new TipoRetencionLogic(connexion);
				tiporetencionLogic.deepSave(detaformapago.getTipoRetencion(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Anio.class)) {
				AnioDataAccess.save(detaformapago.getAnio(),connexion);
				AnioLogic anioLogic= new AnioLogic(connexion);
				anioLogic.deepSave(detaformapago.getAnio(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Mes.class)) {
				MesDataAccess.save(detaformapago.getMes(),connexion);
				MesLogic mesLogic= new MesLogic(connexion);
				mesLogic.deepSave(detaformapago.getMes(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(BancoFormaPago.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(BancoFormaPago bancoformapago:detaformapago.getBancoFormaPagos()) {
					BancoFormaPagoLogic bancoformapagoLogic= new BancoFormaPagoLogic(connexion);
					bancoformapago.setid_deta_forma_pago(detaformapago.getId());
					BancoFormaPagoDataAccess.save(bancoformapago,connexion);
					bancoformapagoLogic.deepSave(bancoformapago,isDeep,deepLoadType,clases);
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
			this.getNewConnexionToDeep(DetaFormaPago.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(detaformapago,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(detaformapago);
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
			this.deepLoad(this.detaformapago,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapago);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(DetaFormaPago.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(detaformapagos!=null) {
				for(DetaFormaPago detaformapago:detaformapagos) {
					this.deepLoad(detaformapago,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(detaformapagos);
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
			if(detaformapagos!=null) {
				for(DetaFormaPago detaformapago:detaformapagos) {
					this.deepLoad(detaformapago,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(detaformapagos);
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
			this.getNewConnexionToDeep(DetaFormaPago.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(detaformapago,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(DetaFormaPago.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(detaformapagos!=null) {
				for(DetaFormaPago detaformapago:detaformapagos) {
					this.deepSave(detaformapago,isDeep,deepLoadType,clases);
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
			if(detaformapagos!=null) {
				for(DetaFormaPago detaformapago:detaformapagos) {
					this.deepSave(detaformapago,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getDetaFormaPagosFK_IdAnioWithConnection(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetaFormaPagoConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetaFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detaformapagos=detaformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaFormaPagosFK_IdAnio(String sFinalQuery,Pagination pagination,Long id_anio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidAnio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidAnio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_anio,DetaFormaPagoConstantesFunciones.IDANIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidAnio);

			DetaFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdAnio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detaformapagos=detaformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetaFormaPagosFK_IdCuentaContableWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,DetaFormaPagoConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			DetaFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detaformapagos=detaformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaFormaPagosFK_IdCuentaContable(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,DetaFormaPagoConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			DetaFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detaformapagos=detaformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetaFormaPagosFK_IdDetaFormaPagoFactuWithConnection(String sFinalQuery,Pagination pagination,Long id_deta_forma_pago_factu)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDetaFormaPagoFactu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDetaFormaPagoFactu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_deta_forma_pago_factu,DetaFormaPagoConstantesFunciones.IDDETAFORMAPAGOFACTU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDetaFormaPagoFactu);

			DetaFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetaFormaPagoFactu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detaformapagos=detaformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaFormaPagosFK_IdDetaFormaPagoFactu(String sFinalQuery,Pagination pagination,Long id_deta_forma_pago_factu)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidDetaFormaPagoFactu= new ParameterSelectionGeneral();
			parameterSelectionGeneralidDetaFormaPagoFactu.setParameterSelectionGeneralEqual(ParameterType.LONG,id_deta_forma_pago_factu,DetaFormaPagoConstantesFunciones.IDDETAFORMAPAGOFACTU,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidDetaFormaPagoFactu);

			DetaFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdDetaFormaPagoFactu","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detaformapagos=detaformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetaFormaPagosFK_IdEjercicioWithConnection(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetaFormaPagoConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetaFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detaformapagos=detaformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaFormaPagosFK_IdEjercicio(String sFinalQuery,Pagination pagination,Long id_ejercicio)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEjercicio= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEjercicio.setParameterSelectionGeneralEqual(ParameterType.LONG,id_ejercicio,DetaFormaPagoConstantesFunciones.IDEJERCICIO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEjercicio);

			DetaFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEjercicio","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detaformapagos=detaformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetaFormaPagosFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetaFormaPagoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetaFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detaformapagos=detaformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaFormaPagosFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,DetaFormaPagoConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			DetaFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detaformapagos=detaformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetaFormaPagosFK_IdFacturaWithConnection(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,DetaFormaPagoConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			DetaFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detaformapagos=detaformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaFormaPagosFK_IdFactura(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,DetaFormaPagoConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			DetaFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detaformapagos=detaformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetaFormaPagosFK_IdMesWithConnection(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetaFormaPagoConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetaFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detaformapagos=detaformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaFormaPagosFK_IdMes(String sFinalQuery,Pagination pagination,Long id_mes)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidMes= new ParameterSelectionGeneral();
			parameterSelectionGeneralidMes.setParameterSelectionGeneralEqual(ParameterType.LONG,id_mes,DetaFormaPagoConstantesFunciones.IDMES,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidMes);

			DetaFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdMes","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detaformapagos=detaformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetaFormaPagosFK_IdPeriodoWithConnection(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetaFormaPagoConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetaFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detaformapagos=detaformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaFormaPagosFK_IdPeriodo(String sFinalQuery,Pagination pagination,Long id_periodo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPeriodo= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPeriodo.setParameterSelectionGeneralEqual(ParameterType.LONG,id_periodo,DetaFormaPagoConstantesFunciones.IDPERIODO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPeriodo);

			DetaFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPeriodo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detaformapagos=detaformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetaFormaPagosFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetaFormaPagoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetaFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detaformapagos=detaformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaFormaPagosFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,DetaFormaPagoConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			DetaFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detaformapagos=detaformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetaFormaPagosFK_IdTipoDetaFormaPagoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_deta_forma_pago)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDetaFormaPago= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDetaFormaPago.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_deta_forma_pago,DetaFormaPagoConstantesFunciones.IDTIPODETAFORMAPAGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDetaFormaPago);

			DetaFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDetaFormaPago","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detaformapagos=detaformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaFormaPagosFK_IdTipoDetaFormaPago(String sFinalQuery,Pagination pagination,Long id_tipo_deta_forma_pago)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoDetaFormaPago= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoDetaFormaPago.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_deta_forma_pago,DetaFormaPagoConstantesFunciones.IDTIPODETAFORMAPAGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoDetaFormaPago);

			DetaFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoDetaFormaPago","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detaformapagos=detaformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetaFormaPagosFK_IdTipoFormaPagoWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_forma_pago)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoFormaPago= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoFormaPago.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_forma_pago,DetaFormaPagoConstantesFunciones.IDTIPOFORMAPAGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoFormaPago);

			DetaFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoFormaPago","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detaformapagos=detaformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaFormaPagosFK_IdTipoFormaPago(String sFinalQuery,Pagination pagination,Long id_tipo_forma_pago)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoFormaPago= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoFormaPago.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_forma_pago,DetaFormaPagoConstantesFunciones.IDTIPOFORMAPAGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoFormaPago);

			DetaFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoFormaPago","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detaformapagos=detaformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapagos);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getDetaFormaPagosFK_IdTipoRetencionWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_retencion)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,DetaFormaPago.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion,DetaFormaPagoConstantesFunciones.IDTIPORETENCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencion);

			DetaFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detaformapagos=detaformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapagos);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getDetaFormaPagosFK_IdTipoRetencion(String sFinalQuery,Pagination pagination,Long id_tipo_retencion)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoRetencion= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoRetencion.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_retencion,DetaFormaPagoConstantesFunciones.IDTIPORETENCION,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoRetencion);

			DetaFormaPagoLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoRetencion","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			detaformapagos=detaformapagoDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				DetaFormaPagoConstantesFunciones.refrescarForeignKeysDescripcionesDetaFormaPago(this.detaformapagos);
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
			if(DetaFormaPagoConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,DetaFormaPagoDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,DetaFormaPago detaformapago,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(DetaFormaPagoConstantesFunciones.ISCONAUDITORIA) {
				if(detaformapago.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetaFormaPagoDataAccess.TABLENAME, detaformapago.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetaFormaPagoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetaFormaPagoLogic.registrarAuditoriaDetallesDetaFormaPago(connexion,detaformapago,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(detaformapago.getIsDeleted()) {
					/*if(!detaformapago.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,DetaFormaPagoDataAccess.TABLENAME, detaformapago.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////DetaFormaPagoLogic.registrarAuditoriaDetallesDetaFormaPago(connexion,detaformapago,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetaFormaPagoDataAccess.TABLENAME, detaformapago.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(detaformapago.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,DetaFormaPagoDataAccess.TABLENAME, detaformapago.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(DetaFormaPagoConstantesFunciones.ISCONAUDITORIADETALLE) {
						////DetaFormaPagoLogic.registrarAuditoriaDetallesDetaFormaPago(connexion,detaformapago,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesDetaFormaPago(Connexion connexion,DetaFormaPago detaformapago)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(detaformapago.getIsNew()||!detaformapago.getid_empresa().equals(detaformapago.getDetaFormaPagoOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detaformapago.getDetaFormaPagoOriginal().getid_empresa()!=null)
				{
					strValorActual=detaformapago.getDetaFormaPagoOriginal().getid_empresa().toString();
				}
				if(detaformapago.getid_empresa()!=null)
				{
					strValorNuevo=detaformapago.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaFormaPagoConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(detaformapago.getIsNew()||!detaformapago.getid_sucursal().equals(detaformapago.getDetaFormaPagoOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detaformapago.getDetaFormaPagoOriginal().getid_sucursal()!=null)
				{
					strValorActual=detaformapago.getDetaFormaPagoOriginal().getid_sucursal().toString();
				}
				if(detaformapago.getid_sucursal()!=null)
				{
					strValorNuevo=detaformapago.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaFormaPagoConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(detaformapago.getIsNew()||!detaformapago.getid_ejercicio().equals(detaformapago.getDetaFormaPagoOriginal().getid_ejercicio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detaformapago.getDetaFormaPagoOriginal().getid_ejercicio()!=null)
				{
					strValorActual=detaformapago.getDetaFormaPagoOriginal().getid_ejercicio().toString();
				}
				if(detaformapago.getid_ejercicio()!=null)
				{
					strValorNuevo=detaformapago.getid_ejercicio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaFormaPagoConstantesFunciones.IDEJERCICIO,strValorActual,strValorNuevo);
			}	
			
			if(detaformapago.getIsNew()||!detaformapago.getid_periodo().equals(detaformapago.getDetaFormaPagoOriginal().getid_periodo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detaformapago.getDetaFormaPagoOriginal().getid_periodo()!=null)
				{
					strValorActual=detaformapago.getDetaFormaPagoOriginal().getid_periodo().toString();
				}
				if(detaformapago.getid_periodo()!=null)
				{
					strValorNuevo=detaformapago.getid_periodo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaFormaPagoConstantesFunciones.IDPERIODO,strValorActual,strValorNuevo);
			}	
			
			if(detaformapago.getIsNew()||!detaformapago.getid_factura().equals(detaformapago.getDetaFormaPagoOriginal().getid_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detaformapago.getDetaFormaPagoOriginal().getid_factura()!=null)
				{
					strValorActual=detaformapago.getDetaFormaPagoOriginal().getid_factura().toString();
				}
				if(detaformapago.getid_factura()!=null)
				{
					strValorNuevo=detaformapago.getid_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaFormaPagoConstantesFunciones.IDFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(detaformapago.getIsNew()||!detaformapago.getid_tipo_forma_pago().equals(detaformapago.getDetaFormaPagoOriginal().getid_tipo_forma_pago()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detaformapago.getDetaFormaPagoOriginal().getid_tipo_forma_pago()!=null)
				{
					strValorActual=detaformapago.getDetaFormaPagoOriginal().getid_tipo_forma_pago().toString();
				}
				if(detaformapago.getid_tipo_forma_pago()!=null)
				{
					strValorNuevo=detaformapago.getid_tipo_forma_pago().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaFormaPagoConstantesFunciones.IDTIPOFORMAPAGO,strValorActual,strValorNuevo);
			}	
			
			if(detaformapago.getIsNew()||!detaformapago.getid_tipo_deta_forma_pago().equals(detaformapago.getDetaFormaPagoOriginal().getid_tipo_deta_forma_pago()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detaformapago.getDetaFormaPagoOriginal().getid_tipo_deta_forma_pago()!=null)
				{
					strValorActual=detaformapago.getDetaFormaPagoOriginal().getid_tipo_deta_forma_pago().toString();
				}
				if(detaformapago.getid_tipo_deta_forma_pago()!=null)
				{
					strValorNuevo=detaformapago.getid_tipo_deta_forma_pago().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaFormaPagoConstantesFunciones.IDTIPODETAFORMAPAGO,strValorActual,strValorNuevo);
			}	
			
			if(detaformapago.getIsNew()||!detaformapago.getid_deta_forma_pago_factu().equals(detaformapago.getDetaFormaPagoOriginal().getid_deta_forma_pago_factu()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detaformapago.getDetaFormaPagoOriginal().getid_deta_forma_pago_factu()!=null)
				{
					strValorActual=detaformapago.getDetaFormaPagoOriginal().getid_deta_forma_pago_factu().toString();
				}
				if(detaformapago.getid_deta_forma_pago_factu()!=null)
				{
					strValorNuevo=detaformapago.getid_deta_forma_pago_factu().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaFormaPagoConstantesFunciones.IDDETAFORMAPAGOFACTU,strValorActual,strValorNuevo);
			}	
			
			if(detaformapago.getIsNew()||!detaformapago.getid_cuenta_contable().equals(detaformapago.getDetaFormaPagoOriginal().getid_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detaformapago.getDetaFormaPagoOriginal().getid_cuenta_contable()!=null)
				{
					strValorActual=detaformapago.getDetaFormaPagoOriginal().getid_cuenta_contable().toString();
				}
				if(detaformapago.getid_cuenta_contable()!=null)
				{
					strValorNuevo=detaformapago.getid_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaFormaPagoConstantesFunciones.IDCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(detaformapago.getIsNew()||!detaformapago.getid_tipo_retencion().equals(detaformapago.getDetaFormaPagoOriginal().getid_tipo_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detaformapago.getDetaFormaPagoOriginal().getid_tipo_retencion()!=null)
				{
					strValorActual=detaformapago.getDetaFormaPagoOriginal().getid_tipo_retencion().toString();
				}
				if(detaformapago.getid_tipo_retencion()!=null)
				{
					strValorNuevo=detaformapago.getid_tipo_retencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaFormaPagoConstantesFunciones.IDTIPORETENCION,strValorActual,strValorNuevo);
			}	
			
			if(detaformapago.getIsNew()||!detaformapago.getvalor().equals(detaformapago.getDetaFormaPagoOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detaformapago.getDetaFormaPagoOriginal().getvalor()!=null)
				{
					strValorActual=detaformapago.getDetaFormaPagoOriginal().getvalor().toString();
				}
				if(detaformapago.getvalor()!=null)
				{
					strValorNuevo=detaformapago.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaFormaPagoConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
			
			if(detaformapago.getIsNew()||!detaformapago.getfecha_inicial().equals(detaformapago.getDetaFormaPagoOriginal().getfecha_inicial()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detaformapago.getDetaFormaPagoOriginal().getfecha_inicial()!=null)
				{
					strValorActual=detaformapago.getDetaFormaPagoOriginal().getfecha_inicial().toString();
				}
				if(detaformapago.getfecha_inicial()!=null)
				{
					strValorNuevo=detaformapago.getfecha_inicial().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaFormaPagoConstantesFunciones.FECHAINICIAL,strValorActual,strValorNuevo);
			}	
			
			if(detaformapago.getIsNew()||!detaformapago.getfecha_final().equals(detaformapago.getDetaFormaPagoOriginal().getfecha_final()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detaformapago.getDetaFormaPagoOriginal().getfecha_final()!=null)
				{
					strValorActual=detaformapago.getDetaFormaPagoOriginal().getfecha_final().toString();
				}
				if(detaformapago.getfecha_final()!=null)
				{
					strValorNuevo=detaformapago.getfecha_final().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaFormaPagoConstantesFunciones.FECHAFINAL,strValorActual,strValorNuevo);
			}	
			
			if(detaformapago.getIsNew()||!detaformapago.getporcentaje().equals(detaformapago.getDetaFormaPagoOriginal().getporcentaje()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detaformapago.getDetaFormaPagoOriginal().getporcentaje()!=null)
				{
					strValorActual=detaformapago.getDetaFormaPagoOriginal().getporcentaje().toString();
				}
				if(detaformapago.getporcentaje()!=null)
				{
					strValorNuevo=detaformapago.getporcentaje().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaFormaPagoConstantesFunciones.PORCENTAJE,strValorActual,strValorNuevo);
			}	
			
			if(detaformapago.getIsNew()||!detaformapago.getretencion().equals(detaformapago.getDetaFormaPagoOriginal().getretencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detaformapago.getDetaFormaPagoOriginal().getretencion()!=null)
				{
					strValorActual=detaformapago.getDetaFormaPagoOriginal().getretencion().toString();
				}
				if(detaformapago.getretencion()!=null)
				{
					strValorNuevo=detaformapago.getretencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaFormaPagoConstantesFunciones.RETENCION,strValorActual,strValorNuevo);
			}	
			
			if(detaformapago.getIsNew()||!detaformapago.getporcentaje_retencion().equals(detaformapago.getDetaFormaPagoOriginal().getporcentaje_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detaformapago.getDetaFormaPagoOriginal().getporcentaje_retencion()!=null)
				{
					strValorActual=detaformapago.getDetaFormaPagoOriginal().getporcentaje_retencion().toString();
				}
				if(detaformapago.getporcentaje_retencion()!=null)
				{
					strValorNuevo=detaformapago.getporcentaje_retencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaFormaPagoConstantesFunciones.PORCENTAJERETENCION,strValorActual,strValorNuevo);
			}	
			
			if(detaformapago.getIsNew()||!detaformapago.getbase_retencion().equals(detaformapago.getDetaFormaPagoOriginal().getbase_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detaformapago.getDetaFormaPagoOriginal().getbase_retencion()!=null)
				{
					strValorActual=detaformapago.getDetaFormaPagoOriginal().getbase_retencion().toString();
				}
				if(detaformapago.getbase_retencion()!=null)
				{
					strValorNuevo=detaformapago.getbase_retencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaFormaPagoConstantesFunciones.BASERETENCION,strValorActual,strValorNuevo);
			}	
			
			if(detaformapago.getIsNew()||!detaformapago.getvalor_retencion().equals(detaformapago.getDetaFormaPagoOriginal().getvalor_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detaformapago.getDetaFormaPagoOriginal().getvalor_retencion()!=null)
				{
					strValorActual=detaformapago.getDetaFormaPagoOriginal().getvalor_retencion().toString();
				}
				if(detaformapago.getvalor_retencion()!=null)
				{
					strValorNuevo=detaformapago.getvalor_retencion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaFormaPagoConstantesFunciones.VALORRETENCION,strValorActual,strValorNuevo);
			}	
			
			if(detaformapago.getIsNew()||!detaformapago.getnumero_retencion().equals(detaformapago.getDetaFormaPagoOriginal().getnumero_retencion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detaformapago.getDetaFormaPagoOriginal().getnumero_retencion()!=null)
				{
					strValorActual=detaformapago.getDetaFormaPagoOriginal().getnumero_retencion();
				}
				if(detaformapago.getnumero_retencion()!=null)
				{
					strValorNuevo=detaformapago.getnumero_retencion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaFormaPagoConstantesFunciones.NUMERORETENCION,strValorActual,strValorNuevo);
			}	
			
			if(detaformapago.getIsNew()||!detaformapago.getnumero_dias().equals(detaformapago.getDetaFormaPagoOriginal().getnumero_dias()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detaformapago.getDetaFormaPagoOriginal().getnumero_dias()!=null)
				{
					strValorActual=detaformapago.getDetaFormaPagoOriginal().getnumero_dias().toString();
				}
				if(detaformapago.getnumero_dias()!=null)
				{
					strValorNuevo=detaformapago.getnumero_dias().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaFormaPagoConstantesFunciones.NUMERODIAS,strValorActual,strValorNuevo);
			}	
			
			if(detaformapago.getIsNew()||!detaformapago.getnumero_cuota().equals(detaformapago.getDetaFormaPagoOriginal().getnumero_cuota()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detaformapago.getDetaFormaPagoOriginal().getnumero_cuota()!=null)
				{
					strValorActual=detaformapago.getDetaFormaPagoOriginal().getnumero_cuota().toString();
				}
				if(detaformapago.getnumero_cuota()!=null)
				{
					strValorNuevo=detaformapago.getnumero_cuota().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaFormaPagoConstantesFunciones.NUMEROCUOTA,strValorActual,strValorNuevo);
			}	
			
			if(detaformapago.getIsNew()||!detaformapago.getdescripcion().equals(detaformapago.getDetaFormaPagoOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detaformapago.getDetaFormaPagoOriginal().getdescripcion()!=null)
				{
					strValorActual=detaformapago.getDetaFormaPagoOriginal().getdescripcion();
				}
				if(detaformapago.getdescripcion()!=null)
				{
					strValorNuevo=detaformapago.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaFormaPagoConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(detaformapago.getIsNew()||!detaformapago.getid_anio().equals(detaformapago.getDetaFormaPagoOriginal().getid_anio()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detaformapago.getDetaFormaPagoOriginal().getid_anio()!=null)
				{
					strValorActual=detaformapago.getDetaFormaPagoOriginal().getid_anio().toString();
				}
				if(detaformapago.getid_anio()!=null)
				{
					strValorNuevo=detaformapago.getid_anio().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaFormaPagoConstantesFunciones.IDANIO,strValorActual,strValorNuevo);
			}	
			
			if(detaformapago.getIsNew()||!detaformapago.getid_mes().equals(detaformapago.getDetaFormaPagoOriginal().getid_mes()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(detaformapago.getDetaFormaPagoOriginal().getid_mes()!=null)
				{
					strValorActual=detaformapago.getDetaFormaPagoOriginal().getid_mes().toString();
				}
				if(detaformapago.getid_mes()!=null)
				{
					strValorNuevo=detaformapago.getid_mes().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),DetaFormaPagoConstantesFunciones.IDMES,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveDetaFormaPagoRelacionesWithConnection(DetaFormaPago detaformapago,List<BancoFormaPago> bancoformapagos) throws Exception {

		if(!detaformapago.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetaFormaPagoRelacionesBase(detaformapago,bancoformapagos,true);
		}
	}

	public void saveDetaFormaPagoRelaciones(DetaFormaPago detaformapago,List<BancoFormaPago> bancoformapagos)throws Exception {

		if(!detaformapago.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveDetaFormaPagoRelacionesBase(detaformapago,bancoformapagos,false);
		}
	}

	public void saveDetaFormaPagoRelacionesBase(DetaFormaPago detaformapago,List<BancoFormaPago> bancoformapagos,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("DetaFormaPago-saveRelacionesWithConnection");}
	
			detaformapago.setBancoFormaPagos(bancoformapagos);

			this.setDetaFormaPago(detaformapago);

			if(DetaFormaPagoLogicAdditional.validarSaveRelaciones(detaformapago,this)) {

				DetaFormaPagoLogicAdditional.updateRelacionesToSave(detaformapago,this);

				if((detaformapago.getIsNew()||detaformapago.getIsChanged())&&!detaformapago.getIsDeleted()) {
					this.saveDetaFormaPago();
					this.saveDetaFormaPagoRelacionesDetalles(bancoformapagos);

				} else if(detaformapago.getIsDeleted()) {
					this.saveDetaFormaPagoRelacionesDetalles(bancoformapagos);
					this.saveDetaFormaPago();
				}

				DetaFormaPagoLogicAdditional.updateRelacionesToSaveAfter(detaformapago,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			BancoFormaPagoConstantesFunciones.InicializarGeneralEntityAuxiliaresBancoFormaPagos(bancoformapagos,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveDetaFormaPagoRelacionesDetalles(List<BancoFormaPago> bancoformapagos)throws Exception {
		try {
	

			Long idDetaFormaPagoActual=this.getDetaFormaPago().getId();

			BancoFormaPagoLogic bancoformapagoLogic_Desde_DetaFormaPago=new BancoFormaPagoLogic();
			bancoformapagoLogic_Desde_DetaFormaPago.setBancoFormaPagos(bancoformapagos);

			bancoformapagoLogic_Desde_DetaFormaPago.setConnexion(this.getConnexion());
			bancoformapagoLogic_Desde_DetaFormaPago.setDatosCliente(this.datosCliente);

			for(BancoFormaPago bancoformapago_Desde_DetaFormaPago:bancoformapagoLogic_Desde_DetaFormaPago.getBancoFormaPagos()) {
				bancoformapago_Desde_DetaFormaPago.setid_deta_forma_pago(idDetaFormaPagoActual);
			}

			bancoformapagoLogic_Desde_DetaFormaPago.saveBancoFormaPagos();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfDetaFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetaFormaPagoConstantesFunciones.getClassesForeignKeysOfDetaFormaPago(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetaFormaPago(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=DetaFormaPagoConstantesFunciones.getClassesRelationshipsOfDetaFormaPago(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
